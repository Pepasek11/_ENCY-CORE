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

import com.liferay.asset.display.page.portlet.AssetDisplayPageEntryFormProcessor;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.TrashedModel;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import com.liferay.trash.service.TrashEntryService;
import cz.csob.ency.modules.apps.meta.cds.constants.MetaCdsPortletKeys;
import cz.csob.ency.modules.apps.meta.cds.constants.MetaCdsPortletKeys;
import cz.csob.ency.modules.apps.meta.cds.exception.TableEntryValidateException;
import cz.csob.ency.modules.apps.meta.cds.model.TableEntry;
import cz.csob.ency.modules.apps.meta.cds.service.TableEntryLocalService;
import cz.csob.ency.modules.apps.meta.cds.service.TableEntryService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Miroslav Čermák
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + MetaCdsPortletKeys.METACDS,
                "javax.portlet.name=" + MetaCdsPortletKeys.METACDS,
                "mvc.command.name=/tableentry/crud"
        },
        service = MVCActionCommand.class
)
public class TableEntryCrudMVCActionCommand extends BaseMVCActionCommand {

    private static final Log _log = LogFactoryUtil.getLog(
            TableEntryCrudMVCActionCommand.class);

    /**
     * Add Entry
     *
     * @param request
     * @param response
     * @throws TableEntryValidateException, Exception
     */
    public void addEntry(ActionRequest request, ActionResponse response)
            throws Exception, TableEntryValidateException {

        long primaryKey = ParamUtil.getLong(request, "resourcePrimKey", 0);

        TableEntry entry = _tableEntryLocalService.getTableEntryFromRequest(
                primaryKey, request);

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                TableEntry.class.getName(), request);

        // Add entry

        _tableEntryService.addEntry(entry, serviceContext);

        _assetDisplayPageEntryFormProcessor.process(
                TableEntry.class.getName(), entry.getPrimaryKey(), request);

        SessionMessages.add(request, "tableentryAddedSuccessfully");
    }

    /**
     * Delte Entry
     *
     * @param request
     * @param response
     * @param moveToTrash true to move to trush.
     * @throws PortalException
     * @throws Exception
     */
    public void deleteEntry(
            ActionRequest request, ActionResponse response, boolean moveToTrash)
            throws PortalException {

        long[] deleteEntryIds = null;
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(
                WebKeys.THEME_DISPLAY);

        long entryId = ParamUtil.getLong(request, "resourcePrimKey", 0L);

        if (entryId > 0) {
            deleteEntryIds = new long[]{entryId};
        } else {
            deleteEntryIds = StringUtil.split(
                    ParamUtil.getString(request, "deleteEntryIds"), 0L);
        }

        List<TrashedModel> trashedModels = new ArrayList<>();

        for (long deleteEntryId : deleteEntryIds) {
            try {
                if (moveToTrash) {
                    TableEntry entry = _tableEntryService.moveEntryToTrash(
                            deleteEntryId);

                    trashedModels.add(entry);
                } else {
                    _tableEntryService.deleteEntry(deleteEntryId);
                }
            } catch (PortalException pe) {
                ReflectionUtil.throwException(pe);
            }
        }

        if (moveToTrash && !trashedModels.isEmpty()) {
            Map<String, Object> data = new HashMap<>();

            data.put("trashedModels", trashedModels);

            addDeleteSuccessData(request, data);
        }
    }

    /**
     * Restore Entries
     *
     * @param actionRequest
     * @throws Exception
     */
    public void restoreTrashEntries(ActionRequest actionRequest)
            throws Exception {

        long[] restoreTrashEntryIds = StringUtil.split(
                ParamUtil.getString(actionRequest, "restoreTrashEntryIds"), 0L);

        for (long restoreTrashEntryId : restoreTrashEntryIds) {
            _trashEntryService.restoreEntry(restoreTrashEntryId);
        }
    }

    /**
     * Update Entry
     *
     * @param request
     * @param response
     * @throws Exception
     */
    public void updateEntry(ActionRequest request, ActionResponse response)
            throws Exception {

        long primaryKey = ParamUtil.getLong(request, "resourcePrimKey", 0);

        TableEntry entry = _tableEntryLocalService.getTableEntryFromRequest(
                primaryKey, request);

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                TableEntry.class.getName(), request);

        //Update entry
        _tableEntryService.updateEntry(entry, serviceContext);

        _assetDisplayPageEntryFormProcessor.process(
                TableEntry.class.getName(), entry.getPrimaryKey(), request);

        SessionMessages.add(request, "tableentryUpdatedSuccessfully");
    }

    /**
     * Single Delete
     *
     * @param entry
     * @param moveToTrash
     * @param trashedModels
     */
    protected void _deleteEntry(
            TableEntry entry, boolean moveToTrash, List<TrashedModel> trashedModels) {

        try {
            if (moveToTrash) {
                trashedModels.add(
                        _tableEntryService.moveEntryToTrash(entry.getPrimaryKey()));
            } else {
                _tableEntryService.deleteEntry(entry.getPrimaryKey());
            }
        } catch (PortalException pe) {
            ReflectionUtil.throwException(pe);
        }
    }

    @Override
    protected void doProcessAction(
            ActionRequest request, ActionResponse response)
            throws IOException {

        try {

            // Fetch command

            String cmd = ParamUtil.getString(request, Constants.CMD);

            if (cmd.equals(Constants.ADD)) {
                addEntry(request, response);
            } else if (cmd.equals(Constants.UPDATE)) {
                updateEntry(request, response);
            } else if (cmd.equals(Constants.DELETE)) {
                deleteEntry(request, response, false);
            } else if (cmd.equals(Constants.MOVE_TO_TRASH)) {
                deleteEntry(request, response, true);
            } else if (cmd.equals(Constants.RESTORE)) {
                restoreTrashEntries(request);
            }
        } catch (TableEntryValidateException ssbve) {
            for (String error : ssbve.getErrors()) {
                SessionErrors.add(request, error);
            }

            PortalUtil.copyRequestParameters(request, response);
            response.setRenderParameter(
                    "mvcRenderCommandName", "/tableentry/crud");
            hideDefaultSuccessMessage(request);
        } catch (Exception t) {
            _log.error(t.getLocalizedMessage(), t);
            SessionErrors.add(request, PortalException.class);
            hideDefaultSuccessMessage(request);
        }

        //For access from Asset Publisher
        String redirect = ParamUtil.getString(request, "redirect");
        Boolean fromAsset = ParamUtil.getBoolean(request, "fromAsset", false);

        if (Validator.isNotNull(redirect) && (true == fromAsset)) {
            sendRedirect(request, response, redirect);
        }
    }

    @Reference(unbind = "-")
    protected void setTableEntryLocalService(
            TableEntryLocalService tableEntryLocalService) {

        _tableEntryLocalService = tableEntryLocalService;
    }

    @Reference(unbind = "-")
    protected void setTableEntryService(TableEntryService tableEntryService) {
        _tableEntryService = tableEntryService;
    }
    @Reference
    private AssetDisplayPageEntryFormProcessor
            _assetDisplayPageEntryFormProcessor;

    private TableEntryLocalService _tableEntryLocalService;
    private TableEntryService _tableEntryService;

    @Reference
    private TrashEntryService _trashEntryService;

}