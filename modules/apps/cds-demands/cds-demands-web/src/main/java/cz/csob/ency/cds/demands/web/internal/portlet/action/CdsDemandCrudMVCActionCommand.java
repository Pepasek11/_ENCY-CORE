// 
//  //
/**
 * Copyright (C) 2021 Yasuyuki Takeo All rights reserved.
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 */
//  //
package cz.csob.ency.cds.demands.web.internal.portlet.action;

/*@todo refactor to Services */

import com.liferay.asset.display.page.portlet.AssetDisplayPageEntryFormProcessor;
import com.liferay.petra.portlet.url.builder.PortletURLBuilder;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import com.liferay.trash.service.TrashEntryService;
import cz.csob.ency.cds.demands.constants.CdsDemandPortletKeys;
import cz.csob.ency.cds.demands.exception.CdsDemandValidateException;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.cds.demands.service.CdsDemandLocalService;
import cz.csob.ency.cds.demands.service.CdsDemandService;
import cz.csob.ency.workflow.manager.EncyWorkflowManager;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * @author Miroslav Čermák
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + CdsDemandPortletKeys.CDSDEMAND,
                "javax.portlet.name=" + CdsDemandPortletKeys.CDSDEMAND_ADMIN,
                "mvc.command.name=/cdsdemand/crud"
        },
        service = MVCActionCommand.class
)
public class CdsDemandCrudMVCActionCommand extends BaseMVCActionCommand {

    private static final Log _log = LogFactoryUtil.getLog(
            CdsDemandCrudMVCActionCommand.class);


    @Override
    protected void doProcessAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException {

        try {

            ajax = ParamUtil.getBoolean(actionRequest, "ajax", false);
            redirect = ParamUtil.getString(actionRequest, "redirect");
            // Fetch command
            String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

            if (cmd.equals(Constants.ADD)) {
                updateEntry(actionRequest, actionResponse, true);
            } else if (cmd.equals(Constants.UPDATE)) {
                updateEntry(actionRequest, actionResponse, false);
            }

        } catch (CdsDemandValidateException ssbve) {
            for (String error : ssbve.getErrors()) {
                SessionErrors.add(actionRequest, error);
                _log.warn(error);
            }

            PortalUtil.copyRequestParameters(actionRequest, actionResponse);
            actionResponse.setRenderParameter(
                    "mvcRenderCommandName", "/cdsdemand/crud");
            hideDefaultSuccessMessage(actionRequest);
        } catch (Exception t) {
            _log.error(t.getLocalizedMessage(), t);
            SessionErrors.add(actionRequest, PortalException.class);
            hideDefaultSuccessMessage(actionRequest);
        }

        //For access from Asset Publisher

        Boolean fromAsset = ParamUtil.getBoolean(actionRequest, "fromAsset", false);

        if (Validator.isNotNull(redirect) && !ajax) {
            sendRedirect(actionRequest, actionResponse, redirect);
        }
    }

    /**
     * Update/Add Entry
     *
     * @param actionRequest
     * @param actionResponse
     * @throws Exception
     */
    private void updateEntry(ActionRequest actionRequest, ActionResponse actionResponse, boolean add)
            throws Exception {

        hideDefaultErrorMessage(actionRequest);

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(
                WebKeys.THEME_DISPLAY);

        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

        ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
                "content.Language", themeDisplay.getLocale(), getClass());

        String message;
        Boolean success = true;

        long primaryKey = ParamUtil.getLong(actionRequest, "resourcePrimKey", 0);

        if (primaryKey <= 0 && !add) {
            message = LanguageUtil.get(
                    resourceBundle, "updating-entry-with-null-id");
            success = false;
        } else {

            try {
                CdsDemand entry = _cdsDemandLocalService.getCdsDemandFromRequest(
                        primaryKey, actionRequest);

                ServiceContext serviceContext = ServiceContextFactory.getInstance(
                        CdsDemand.class.getName(), actionRequest);

                CdsDemand updatedEntry;

                if (add) {
                    // Add entry
                    updatedEntry = _cdsDemandService.addEntry(entry, serviceContext);

                    _assetDisplayPageEntryFormProcessor.process(
                            CdsDemand.class.getName(), entry.getPrimaryKey(), actionRequest);

                    message = LanguageUtil.format(
                            resourceBundle, "x-was-added-successfully",
                            updatedEntry.getTitle());
                    SessionMessages.add(actionRequest, "x-was-added-successfully");
                } else {
                    //Update entry
                    updatedEntry = _cdsDemandService.updateEntry(entry, serviceContext);

                    _assetDisplayPageEntryFormProcessor.process(
                            CdsDemand.class.getName(), entry.getPrimaryKey(), actionRequest);

                    message = LanguageUtil.format(
                            resourceBundle, "x-was-saved-successfully",
                            updatedEntry.getTitle());

                    SessionMessages.add(actionRequest, "x-was-saved-successfully");
                }

            } catch (Exception ex) {
                _log.error(ex);
                message = ex.getMessage();
                success = false;
                SessionErrors.add(actionRequest, "error-occured-when-saving");
            }

        }

        if (ajax) {
            hideDefaultSuccessMessage(actionRequest);

            jsonObject.put(
                    "message", message
            ).put(
                    "success", success
            );

            JSONPortletResponseUtil.writeJSON(
                    actionRequest, actionResponse, jsonObject);
        }
    }

    protected Boolean ajax = false;
    protected String redirect = "";

    @Reference
    private AssetDisplayPageEntryFormProcessor
            _assetDisplayPageEntryFormProcessor;

    @Reference
    private CdsDemandLocalService _cdsDemandLocalService;
    @Reference
    private CdsDemandService _cdsDemandService;

}