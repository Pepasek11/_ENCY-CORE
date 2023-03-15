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
package cz.csob.ency.cds.demands.web.internal.asset;

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
import cz.csob.ency.cds.demands.constants.CdsDemandConstants;
import cz.csob.ency.cds.demands.constants.CdsDemandPortletKeys;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.cds.demands.service.CdsDemandLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.ServletContext;


/**
 * CdsDemand Asset Renderer Factory
 *
 * @author Miroslav Čermák
 */
@Component(
        immediate = true,
        property = "javax.portlet.name=" + CdsDemandPortletKeys.CDSDEMAND,
        service = AssetRendererFactory.class
)
public class CdsDemandAssetRendererFactory
        extends BaseAssetRendererFactory<CdsDemand> {

    public static final String SYMBOLIC_NAME =
            CdsDemandConstants.RESOURCE_NAME + ".web";

    public static final String TYPE = "cdsdemand";
    private static final Log _log = LogFactoryUtil.getLog(
            CdsDemandAssetRendererFactory.class);

    public CdsDemandAssetRendererFactory() {
        setClassName(CdsDemand.class.getName());
        setCategorizable(true);
        setPortletId(CdsDemandPortletKeys.CDSDEMAND);
        setLinkable(true);
        setSearchable(true);
        setSelectable(true);
    }

    @Override
    public AssetRenderer<CdsDemand> getAssetRenderer(long classPK, int type)
            throws PortalException {

        CdsDemandAssetRenderer cdsDemandAssetRenderer = new CdsDemandAssetRenderer(
                _cdsDemandLocalService.getCdsDemand(classPK),
                ResourceBundleLoaderUtil.getPortalResourceBundleLoader());

        cdsDemandAssetRenderer.setAssetRendererType(type);
        cdsDemandAssetRenderer.setServletContext(_servletContext);

        return cdsDemandAssetRenderer;
    }

    /*
    @Override
    public AssetRenderer<CdsDemand> getAssetRenderer(
            long groupId, String urlTitle)
            throws PortalException {

        CdsDemand entry = _cdsDemandLocalService.getCdsDemand(groupId, urlTitle);

        CdsDemandAssetRenderer cdsDemandAssetRenderer = new CdsDemandAssetRenderer(
                entry,
                ResourceBundleLoaderUtil.
                        getResourceBundleLoaderByBundleSymbolicName(SYMBOLIC_NAME));

        cdsDemandAssetRenderer.setServletContext(_servletContext);

        return cdsDemandAssetRenderer;
    }

     */

    @Override
    public String getClassName() {
        return CdsDemand.class.getName();
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
                CdsDemandPortletKeys.CDSDEMAND_ADMIN, 0, 0,
                PortletRequest.RENDER_PHASE);

        portletURL.setParameter("mvcRenderCommandName", "/cdsdemand/crud");
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
                        CdsDemandPortletKeys.CDSDEMAND_ADMIN,
                        PortletRequest.RENDER_PHASE);

        liferayPortletURL.setParameter(
                "mvcRenderCommandName", "/cdsdemand/view");
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

        return _cdsDemandModelResourcePermission.contains(
                permissionChecker, classPK, actionId);
    }

    @Reference(
            target = "(osgi.web.symbolicname=cz.csob.ency.cds.demands.web)", unbind = "-"
    )
    public void setServletContext(ServletContext servletContext) {
        _servletContext = servletContext;
    }

    @Reference
    private CdsDemandLocalService _cdsDemandLocalService;

    @Reference(target = "(model.class.name=cz.csob.ency.cds.demands.model.CdsDemand)")
    private ModelResourcePermission<CdsDemand> _cdsDemandModelResourcePermission;

    @Reference
    private Portal _portal;

    @Reference(
            target = "(resource.name=" + CdsDemandConstants.RESOURCE_NAME + ")"
    )
    private PortletResourcePermission _portletResourcePermission;

    @Reference(target = "(osgi.web.symbolicname=" + SYMBOLIC_NAME + ")")
    private ServletContext _servletContext;

}