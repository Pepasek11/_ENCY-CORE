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
package cz.csob.ency.modules.apps.meta.cds.web.asset;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoaderUtil;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.Portal;
import cz.csob.ency.modules.apps.meta.cds.constants.MetaCdsPortletKeys;
import cz.csob.ency.modules.apps.meta.cds.constants.TableEntryConstants;
import cz.csob.ency.modules.apps.meta.cds.model.TableEntry;
import cz.csob.ency.modules.apps.meta.cds.service.TableEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.ServletContext;


/**
 * TableEntry Asset Renderer Factory
 *
 * @author Miroslav Čermák
 */
@Component(
        immediate = true,
        property = "javax.portlet.name=" + MetaCdsPortletKeys.METACDS,
        service = AssetRendererFactory.class
)
public class TableEntryAssetRendererFactory
        extends BaseAssetRendererFactory<TableEntry> {

    public static final String SYMBOLIC_NAME =
            TableEntryConstants.RESOURCE_NAME + ".web";

    public static final String TYPE = "tableentry";
    private static final Log _log = LogFactoryUtil.getLog(
            TableEntryAssetRendererFactory.class);

    public TableEntryAssetRendererFactory() {
        setClassName(TableEntry.class.getName());
        setCategorizable(true);
        setPortletId(MetaCdsPortletKeys.METACDS);
        setLinkable(true);
        setSearchable(true);
        setSelectable(true);
    }

    @Override
    public AssetRenderer<TableEntry> getAssetRenderer(long classPK, int type)
            throws PortalException {

        TableEntryAssetRenderer tableEntryAssetRenderer = new TableEntryAssetRenderer(
                _tableEntryLocalService.getTableEntry(classPK),
                ResourceBundleLoaderUtil.getPortalResourceBundleLoader());

        tableEntryAssetRenderer.setAssetRendererType(type);
        tableEntryAssetRenderer.setServletContext(_servletContext);

        return tableEntryAssetRenderer;
    }

    @Override
    public AssetRenderer<TableEntry> getAssetRenderer(
            long groupId, String urlTitle)
            throws PortalException {

        TableEntry entry = _tableEntryLocalService.getTableEntry(groupId, urlTitle);

        TableEntryAssetRenderer tableEntryAssetRenderer = new TableEntryAssetRenderer(
                entry,
                ResourceBundleLoaderUtil.getPortalResourceBundleLoader());

        tableEntryAssetRenderer.setServletContext(_servletContext);

        return tableEntryAssetRenderer;
    }

    @Override
    public String getClassName() {
        return TableEntry.class.getName();
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public PortletURL getURLAdd(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse, long classTypeId) {

        PortletURL portletURL = _portal.getControlPanelPortletURL(
                liferayPortletRequest, getGroup(liferayPortletRequest),
                MetaCdsPortletKeys.METACDS_ADMIN, 0, 0,
                PortletRequest.RENDER_PHASE);

        portletURL.setParameter("mvcRenderCommandName", "/tableentry/crud");
        portletURL.setParameter(Constants.CMD, Constants.ADD);
        portletURL.setParameter("fromAsset", StringPool.TRUE);

        return portletURL;
    }

    @Override
    public PortletURL getURLView(
            LiferayPortletResponse liferayPortletResponse,
            WindowState windowState) {

        LiferayPortletURL liferayPortletURL =
                liferayPortletResponse.createLiferayPortletURL(
                        MetaCdsPortletKeys.METACDS_ADMIN,
                        PortletRequest.RENDER_PHASE);

        liferayPortletURL.setParameter(
                "mvcRenderCommandName", "/tableentry/view");
        liferayPortletURL.setParameter(Constants.CMD, Constants.VIEW);
        liferayPortletURL.setParameter("fromAsset", StringPool.TRUE);

        try {
            liferayPortletURL.setWindowState(windowState);
        } catch (WindowStateException wse) {
            _log.error("Windos state is not valid. Skip.", wse);
        }

        return liferayPortletURL;
    }

    @Override
    public boolean hasAddPermission(
            PermissionChecker permissionChecker, long groupId, long classTypeId)
            throws Exception {

        if (_portletResourcePermission.contains(
                permissionChecker, groupId, ActionKeys.VIEW)) {

            return false;
        }

        return _portletResourcePermission.contains(
                permissionChecker, groupId, ActionKeys.ADD_ENTRY);
    }

    @Override
    public boolean hasPermission(
            PermissionChecker permissionChecker, long classPK, String actionId)
            throws Exception {

        return _tableEntryModelResourcePermission.contains(
                permissionChecker, classPK, actionId);
    }

    @Reference(
            target = "(osgi.web.symbolicname=cz.csob.ency.modules.apps.meta.cds.web)", unbind = "-"
    )
    public void setServletContext(ServletContext servletContext) {
        _servletContext = servletContext;
    }

    @Reference
    private Portal _portal;

    @Reference(
            target = "(resource.name=" + TableEntryConstants.RESOURCE_NAME + ")"
    )
    private PortletResourcePermission _portletResourcePermission;
    @Reference(target = "(osgi.web.symbolicname=" + SYMBOLIC_NAME + ")")
    private ServletContext _servletContext;
    @Reference
    private TableEntryLocalService _tableEntryLocalService;
    @Reference(target = "(model.class.name=cz.csob.ency.modules.apps.meta.cds.model.TableEntry)")
    private ModelResourcePermission<TableEntry> _tableEntryModelResourcePermission;

}