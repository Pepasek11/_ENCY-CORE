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

package cz.csob.ency.modules.apps.meta.cds.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import cz.csob.ency.modules.apps.meta.cds.constants.MetaCdsPortletKeys;
import cz.csob.ency.modules.apps.meta.cds.exception.SystemEntryValidateException;
import cz.csob.ency.modules.apps.meta.cds.model.SystemEntry;
import cz.csob.ency.modules.apps.meta.cds.service.SystemEntryService;
import cz.csob.ency.modules.apps.meta.cds.web.constants.SystemEntryWebKeys;
import cz.csob.ency.modules.apps.meta.cds.web.internal.security.permission.resource.SystemEntryEntryPermission;
import cz.csob.ency.modules.apps.meta.cds.web.upload.SystemEntryItemSelectorHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * SystemEntry CRUD Render
 *
 * @author Miroslav Čermák
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + MetaCdsPortletKeys.METACDS_ADMIN,
                "mvc.command.name=/systementry/crud"
        },
        service = MVCRenderCommand.class
)
public class SystemEntryAdminCrudMVCRenderCommand implements MVCRenderCommand {

    /**
     * Edit Page JSP file
     */
    public String getEditPageJSP() {
        return SystemEntryWebKeys.ADMIN_EDIT_JSP;
    }

    /**
     * View Page JSP file
     */
    public String getViewPageJSP() {
        return SystemEntryWebKeys.ADMIN_VIEW_JSP;
    }

    /**
     * View Record JSP file
     */
    public String getViewRecordPageJSP() {
        return SystemEntryWebKeys.ADMIN_VIEW_RECORD_JSP;
    }

    @Override
    public String render(RenderRequest request, RenderResponse response)
            throws PortletException {

        String renderJSP = getViewPageJSP();

        // Fetch command

        String cmd = ParamUtil.getString(request, Constants.CMD);

        // Fetch primary key

        long primaryKey = ParamUtil.getLong(request, "resourcePrimKey", 0);
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(
                WebKeys.THEME_DISPLAY);

        try {
            if (cmd.equalsIgnoreCase(Constants.UPDATE)) {
                renderJSP = update(request, themeDisplay, primaryKey);
            } else if (cmd.equalsIgnoreCase(Constants.VIEW)) {
                renderJSP = view(request, themeDisplay, primaryKey);
            } else {
                renderJSP = add(request, themeDisplay, primaryKey);
            }
        } catch (PortalException pe) {
            throw new PortletException(pe.getMessage());
        }


//  //
// //
        request.setAttribute(
                SystemEntryWebKeys.SYSTEMENTRY_ITEM_SELECTOR_HELPER,
                _systemEntryItemSelectorHelper);

        return renderJSP;
    }

    /**
     * Add record
     *
     * @param request
     * @param themeDisplay
     * @param primaryKey
     * @return JSP file path
     * @throws PortalException
     * @throws SystemEntryValidateException
     * @throws PortletException
     */
    protected String add(
            RenderRequest request, ThemeDisplay themeDisplay, long primaryKey)
            throws PortalException, PortletException, SystemEntryValidateException {

        SystemEntry record = null;

        if (Validator.isNull(request.getParameter("addErrors"))) {
            record = _systemEntryService.getInitializedSystemEntry(
                    primaryKey, request);
        } else {
            record = _systemEntryService.getSystemEntryFromRequest(
                    primaryKey, request);
        }

        request.setAttribute("systemEntry", record);

        return getEditPageJSP();
    }

    /**
     * Update record
     *
     * @param request
     * @param themeDisplay
     * @param primaryKey
     * @return JSP file path to open
     * @throws PortalException
     * @throws SystemEntryValidateException
     */
    protected String update(
            RenderRequest request, ThemeDisplay themeDisplay, long primaryKey)
            throws PortalException, SystemEntryValidateException {

        SystemEntry record = _systemEntryService.getSystemEntry(primaryKey);

        if (!SystemEntryEntryPermission.contains(
                themeDisplay.getPermissionChecker(), record,
                ActionKeys.UPDATE)) {

            List<String> error = new ArrayList<>();
            error.add("permission-error");

            throw new SystemEntryValidateException(error);
        }

        request.setAttribute("systemEntry", record);

        return getEditPageJSP();
    }

    /**
     * View record
     *
     * @param request
     * @param themeDisplay
     * @param primaryKey
     * @return
     * @throws PortalException
     * @throws SystemEntryValidateException
     */
    protected String view(
            RenderRequest request, ThemeDisplay themeDisplay, long primaryKey)
            throws PortalException, SystemEntryValidateException {

        SystemEntry record = _systemEntryService.getSystemEntry(primaryKey);

        if (!SystemEntryEntryPermission.contains(
                themeDisplay.getPermissionChecker(), record, ActionKeys.VIEW)) {

            List<String> error = new ArrayList<>();
            error.add("permission-error");

            throw new SystemEntryValidateException(error);
        }

        request.setAttribute("systemEntry", record);

        return getViewRecordPageJSP();
    }

    @Reference
    private SystemEntryItemSelectorHelper _systemEntryItemSelectorHelper;

    //  //
// //
    @Reference
    private SystemEntryService _systemEntryService;

}
