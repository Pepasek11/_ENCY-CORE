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
import com.liferay.portal.background.task.constants.BackgroundTaskContextMapConstants;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskManager;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.TrashedModel;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import com.liferay.trash.service.TrashEntryService;
import cz.csob.ency.modules.apps.meta.cds.constants.MetaCdsPortletKeys;
import cz.csob.ency.modules.apps.meta.cds.exception.ColumnEntryValidateException;
import cz.csob.ency.modules.apps.meta.cds.exception.SystemEntryValidateException;
import cz.csob.ency.modules.apps.meta.cds.internal.background.task.MetaCdsLoaderBackgroundTaskExecutor;
import cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry;
import cz.csob.ency.modules.apps.meta.cds.service.ColumnEntryLocalService;
import cz.csob.ency.modules.apps.meta.cds.service.ColumnEntryService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.io.IOException;
import java.io.Serializable;
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
                "javax.portlet.name=" + MetaCdsPortletKeys.METACDS_ADMIN,
                "mvc.command.name=/columnentry/crud"
        },
        service = MVCActionCommand.class
)
public class ColumnEntryAdminCrudMVCActionCommand extends BaseMVCActionCommand {

    private static final Log _log = LogFactoryUtil.getLog(
            ColumnEntryAdminCrudMVCActionCommand.class);

    /**
     * Add Entry
     *
     * @param request
     * @param response
     * @throws ColumnEntryValidateException, Exception
     */
    public void addEntry(ActionRequest request, ActionResponse response)
            throws Exception, ColumnEntryValidateException {

        long primaryKey = ParamUtil.getLong(request, "resourcePrimKey", 0);

        ColumnEntry entry = _columnEntryLocalService.getColumnEntryFromRequest(
                primaryKey, request);

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                ColumnEntry.class.getName(), request);

        // Add entry

        _columnEntryService.addEntry(entry, serviceContext);

        _assetDisplayPageEntryFormProcessor.process(
                ColumnEntry.class.getName(), entry.getPrimaryKey(), request);

        SessionMessages.add(request, "columnentryAddedSuccessfully");
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
                    ColumnEntry entry = _columnEntryService.moveEntryToTrash(
                            deleteEntryId);

                    trashedModels.add(entry);
                } else {
                    _columnEntryService.deleteEntry(deleteEntryId);
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
     * Import Entries
     *
     * @param request
     * @param response
     * @throws SystemEntryValidateException, Exception
     */
    public void importEntries(ActionRequest request, ActionResponse response)
            throws Exception, SystemEntryValidateException {

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                ColumnEntry.class.getName(), request);

        String parent = ParamUtil.getString(request, "resourcePrimKey", "");

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(
                WebKeys.THEME_DISPLAY);

        Map<String, Serializable> taskContextMap = new HashMap<>();

        taskContextMap.put(
                BackgroundTaskContextMapConstants.DELETE_ON_SUCCESS, true);
        taskContextMap.put(
                "target", "columns");
        taskContextMap.put(
                "parent", parent);
        taskContextMap.put(
                "serviceContext", serviceContext);

        String jobName = "meta-cds-import";

        try {
            _backgroundTaskManager.addBackgroundTask(
                    themeDisplay.getUserId(), CompanyConstants.SYSTEM, jobName,
                    MetaCdsLoaderBackgroundTaskExecutor.class.getName(),
                    taskContextMap, serviceContext);
            SessionMessages.add(request, "import-started-succesfully");
        } catch (PortalException portalException) {
            SessionErrors.add(request, "unable-to-schedule-import");
            throw new SearchException(
                    "Unable to schedule metacds import", portalException);
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

        ColumnEntry entry = _columnEntryLocalService.getColumnEntryFromRequest(
                primaryKey, request);

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                ColumnEntry.class.getName(), request);

        //Update entry
        _columnEntryService.updateEntry(entry, serviceContext);

        _assetDisplayPageEntryFormProcessor.process(
                ColumnEntry.class.getName(), entry.getPrimaryKey(), request);

        SessionMessages.add(request, "columnentryUpdatedSuccessfully");
    }

    /**
     * Single Delete
     *
     * @param entry
     * @param moveToTrash
     * @param trashedModels
     */
    protected void _deleteEntry(
            ColumnEntry entry, boolean moveToTrash, List<TrashedModel> trashedModels) {

        try {
            if (moveToTrash) {
                trashedModels.add(
                        _columnEntryService.moveEntryToTrash(entry.getPrimaryKey()));
            } else {
                _columnEntryService.deleteEntry(entry.getPrimaryKey());
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
            } else if (cmd.equals(Constants.IMPORT)) {
                importEntries(request, response);
            }
        } catch (ColumnEntryValidateException ssbve) {
            for (String error : ssbve.getErrors()) {
                SessionErrors.add(request, error);
            }

            PortalUtil.copyRequestParameters(request, response);
            response.setRenderParameter(
                    "mvcRenderCommandName", "/columnentry/crud");
            hideDefaultSuccessMessage(request);
        } catch (Exception t) {
            _log.error(t.getLocalizedMessage(), t);
            SessionErrors.add(request, PortalException.class);
            hideDefaultSuccessMessage(request);
        }

        //For access from Asset Publisher
        String redirect = ParamUtil.getString(request, "redirect");
        Boolean fromAsset = ParamUtil.getBoolean(request, "fromAsset", false);

        if (Validator.isNotNull(redirect) /*&& (true == fromAsset)*/) {
            sendRedirect(request, response, redirect);
        }
    }

    @Reference(unbind = "-")
    protected void setColumnEntryLocalService(
            ColumnEntryLocalService columnEntryLocalService) {

        _columnEntryLocalService = columnEntryLocalService;
    }

    @Reference(unbind = "-")
    protected void setColumnEntryService(ColumnEntryService columnEntryService) {
        _columnEntryService = columnEntryService;
    }

    @Reference
    private AssetDisplayPageEntryFormProcessor
            _assetDisplayPageEntryFormProcessor;
    @Reference
    private BackgroundTaskManager _backgroundTaskManager;
    private ColumnEntryLocalService _columnEntryLocalService;
    private ColumnEntryService _columnEntryService;
    @Reference
    private TrashEntryService _trashEntryService;

}