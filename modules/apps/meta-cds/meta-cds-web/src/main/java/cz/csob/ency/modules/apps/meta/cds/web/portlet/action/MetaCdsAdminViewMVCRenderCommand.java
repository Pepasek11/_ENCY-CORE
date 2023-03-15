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

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.trash.TrashHelper;
import cz.csob.ency.modules.apps.meta.cds.constants.MetaCdsPortletKeys;
import cz.csob.ency.modules.apps.meta.cds.service.SystemEntryLocalService;
import cz.csob.ency.modules.apps.meta.cds.service.TableEntryLocalService;
import cz.csob.ency.modules.apps.meta.cds.web.constants.ColumnEntryWebKeys;
import cz.csob.ency.modules.apps.meta.cds.web.constants.MetaCdsWebKeys;
import cz.csob.ency.modules.apps.meta.cds.web.constants.SystemEntryWebKeys;
import cz.csob.ency.modules.apps.meta.cds.web.constants.TableEntryWebKeys;
import cz.csob.ency.modules.apps.meta.cds.web.internal.display.context.ColumnEntryDisplayContext;
import cz.csob.ency.modules.apps.meta.cds.web.internal.display.context.SystemEntryDisplayContext;
import cz.csob.ency.modules.apps.meta.cds.web.internal.display.context.TableEntryDisplayContext;
import cz.csob.ency.modules.apps.meta.cds.web.util.ColumnEntryViewHelper;
import cz.csob.ency.modules.apps.meta.cds.web.util.SystemEntryViewHelper;
import cz.csob.ency.modules.apps.meta.cds.web.util.TableEntryViewHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Miroslav Čermák
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + MetaCdsPortletKeys.METACDS_ADMIN,
                "mvc.command.name=/", "mvc.command.name=/metacds/view",
                "mvc.command.name=/systementry/view", "mvc.command.name=/tableentry/view",
                "mvc.command.name=/columnentry/view"

        },
        service = MVCRenderCommand.class
)
public class MetaCdsAdminViewMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest request, RenderResponse response) {
        String navigation = ParamUtil.getString(request, MetaCdsWebKeys.NAVIGATION);
        String mvcRenderCommandName = ParamUtil.getString(request, "mvcRenderCommandName");

        if (Validator.isBlank(navigation)) {
            if (mvcRenderCommandName.startsWith("/system")) {
                navigation = MetaCdsWebKeys.NAVIGATION_SYSTEMS;
            } else if (mvcRenderCommandName.startsWith("/table")) {
                navigation = MetaCdsWebKeys.NAVIGATION_TABLES;
            } else if (mvcRenderCommandName.startsWith("/column")) {
                navigation = MetaCdsWebKeys.NAVIGATION_COLUMNS;
            } else {
                //fallback
                navigation = MetaCdsWebKeys.NAVIGATION_SYSTEMS;
            }
        }

        if (navigation.equals(MetaCdsWebKeys.NAVIGATION_TABLES)) {
            // Tables tab displayed
            request.setAttribute(
                    TableEntryWebKeys.TABLEENTRY_DISPLAY_CONTEXT,
                    new TableEntryDisplayContext(
                            _portal.getLiferayPortletRequest(request),
                            _portal.getLiferayPortletResponse(response), _trashHelper,
                            _tableEntryViewHelper));

            request.setAttribute(
                    TableEntryWebKeys.TABLEENTRY_VIEW_HELPER, _tableEntryViewHelper);

            request.setAttribute(TableEntryWebKeys.SYSTEMENTRY_LOCAL_SERVICE, _systemEntryLocalService);
        } else if (navigation.equals(MetaCdsWebKeys.NAVIGATION_COLUMNS)) {
            // Columns tab displayed
            request.setAttribute(
                    ColumnEntryWebKeys.COLUMNENTRY_DISPLAY_CONTEXT,
                    new ColumnEntryDisplayContext(
                            _portal.getLiferayPortletRequest(request),
                            _portal.getLiferayPortletResponse(response), _trashHelper,
                            _columnEntryViewHelper));

            request.setAttribute(
                    ColumnEntryWebKeys.COLUMNENTRY_VIEW_HELPER, _columnEntryViewHelper);
            request.setAttribute(
                    ColumnEntryWebKeys.TABLEENTRY_LOCAL_SERVICE, _tableEntryLocalService);

        } else if (navigation.equals(MetaCdsWebKeys.NAVIGATION_DASHBOARD)) {

            ThemeDisplay themeDisplay =
                    (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

            long systems = _systemEntryLocalService.countAllInGroup(themeDisplay.getScopeGroupId());


            // Dashboard tab displayed

        } else {
            // Systems tab displayed
            request.setAttribute(
                    SystemEntryWebKeys.SYSTEMENTRY_DISPLAY_CONTEXT,
                    new SystemEntryDisplayContext(
                            _portal.getLiferayPortletRequest(request),
                            _portal.getLiferayPortletResponse(response), _trashHelper,
                            _systemEntryViewHelper));

            request.setAttribute(
                    SystemEntryWebKeys.SYSTEMENTRY_VIEW_HELPER, _systemEntryViewHelper);
        }

        // set navigation, in case it was determined by action
        request.setAttribute(
                MetaCdsWebKeys.NAVIGATION, navigation);

        return MetaCdsWebKeys.ADMIN_VIEW_JSP;
    }

    @Reference
    private ColumnEntryViewHelper _columnEntryViewHelper;
    @Reference
    private Portal _portal;
    @Reference
    private SystemEntryLocalService _systemEntryLocalService;
    @Reference
    private SystemEntryViewHelper _systemEntryViewHelper;
    @Reference
    private TableEntryLocalService _tableEntryLocalService;
    @Reference
    private TableEntryViewHelper _tableEntryViewHelper;
    @Reference
    private TrashHelper _trashHelper;

}