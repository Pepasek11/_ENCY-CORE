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
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
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
 * CRUD Render
 *
 * @author Miroslav Čermák
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + MetaCdsPortletKeys.METACDS,
                "mvc.command.name=/systementry/crud"
        },
        service = MVCRenderCommand.class
)
public class SystemEntryCrudMVCRenderCommand implements MVCRenderCommand {

    /**
     * View Page JSP file
     */
    public String getViewPageJSP() {
        return SystemEntryWebKeys.VIEW_JSP;
    }

    /**
     * View Record JSP file
     */
    public String getViewRecordPageJSP() {
        return SystemEntryWebKeys.VIEW_RECORD_JSP;
    }

    @Override
    public String render(RenderRequest request, RenderResponse response)
            throws PortletException {

        String renderJSP = getViewPageJSP();

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(
                WebKeys.THEME_DISPLAY);

        // Fetch command

        String cmd = ParamUtil.getString(request, Constants.CMD);

        // Fetch primary key
        SystemEntry entry = null;

        try {
            long primaryKey = ParamUtil.getLong(request, "resourcePrimKey", 0);

            if (0 != primaryKey) {
                entry = _systemEntryService.getSystemEntry(primaryKey);
            } else {
                String urlTitle = ParamUtil.getString(request, "urlTitle", "");
                entry = _systemEntryService.getSystemEntry(themeDisplay.getScopeGroupId(), urlTitle);
            }

            if (cmd.equalsIgnoreCase(Constants.VIEW) && entry != null) {
                renderJSP = view(request, themeDisplay, entry);
            }
        } catch (PortalException e) {
            return "/404.jsp";
        }

        return renderJSP;
    }

    /**
     * View entry
     *
     * @param request
     * @param themeDisplay
     * @param entry
     * @return
     * @throws PortalException
     * @throws SystemEntryValidateException
     */
    protected String view(
            RenderRequest request, ThemeDisplay themeDisplay, SystemEntry entry)
            throws PortalException, SystemEntryValidateException {

        if (!SystemEntryEntryPermission.contains(
                themeDisplay.getPermissionChecker(), entry, ActionKeys.VIEW)) {

            List<String> error = new ArrayList<>();
            error.add("permission-error");

            throw new SystemEntryValidateException(error);
        }

        request.setAttribute("systemEntry", entry);

        return getViewRecordPageJSP();
    }

    @Reference
    private SystemEntryItemSelectorHelper _systemEntryItemSelectorHelper;

    @Reference
    private SystemEntryService _systemEntryService;

}
