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

import com.liferay.asset.display.page.portlet.AssetDisplayPageFriendlyURLProvider;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.*;
import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoader;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.trash.TrashRenderer;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.cds.demands.constants.CdsDemandPortletKeys;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.cds.demands.web.internal.security.permission.resource.CdsDemandEntryPermission;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


/**
 * Asset Renderer
 * <p>
 * This class is used to display contents in Asset Publisher.
 *
 * @author Miroslav Čermák
 */
public class CdsDemandAssetRenderer
        extends BaseJSPAssetRenderer<CdsDemand> implements TrashRenderer {

    private static final Log _log = LogFactoryUtil.getLog(
            CdsDemandAssetRenderer.class);

    public CdsDemandAssetRenderer(
            CdsDemand entry, ResourceBundleLoader resourceBundleLoader) {

        _entry = entry;
        _resourceBundleLoader = resourceBundleLoader;
    }

    @Override
    public CdsDemand getAssetObject() {
        return _entry;
    }

    @Override
    public String getClassName() {
        return CdsDemand.class.getName();
    }

    @Override
    public long getClassPK() {
        return _entry.getPrimaryKey();
    }

    @Override
    public String getDiscussionPath() {
        return null;
    }

    @Override
    public long getGroupId() {
        return _entry.getGroupId();
    }

    @Override
    public String getJspPath(HttpServletRequest request, String template) {
        if (template.equals(TEMPLATE_ABSTRACT) ||
                template.equals(TEMPLATE_FULL_CONTENT)) {

            request.setAttribute("cdsDemand", _entry);

            return "/cds_demand/asset/" + template + ".jsp";
        }

        return null;
    }

    @Override
    public String getPortletId() {
        AssetRendererFactory<CdsDemand> assetRendererFactory =
                getAssetRendererFactory();

        return assetRendererFactory.getPortletId();
    }

    @Override
    public int getStatus() {
        return _entry.getStatus();
    }

    @Override
    public String getSummary(
            PortletRequest portletRequest, PortletResponse portletResponse) {
        return _entry.getDescription();
    }

    @Override
    public String getTitle(Locale locale) {
        return _entry.getTitle();
    }

    @Override
    public String getType() {
        return CdsDemandAssetRendererFactory.TYPE;
    }

    @Override
    public PortletURL getURLEdit(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse) {
        _log.warn("getURLEdit");
        return null;
    }

    @Override
    public String getURLView(
            LiferayPortletResponse liferayPortletResponse,
            WindowState windowState)
            throws Exception {
        _log.warn("getURLView");

        AssetRendererFactory<CdsDemand> assetRendererFactory =
                getAssetRendererFactory();

        return PortletURLBuilder.create(assetRendererFactory.getURLView(
                liferayPortletResponse, windowState)
        ).buildString() + "#/demand/view/" + _entry.getPrimaryKey();

    }

    @Override
    public String getURLViewInContext(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            String noSuchEntryRedirect)
            throws PortalException {

        try {
            long plid = PortalUtil.getPlidFromPortletId(
                    _entry.getGroupId(),
                    CdsDemandPortletKeys.CDSDEMAND
            );

            PortletURL portletURL;

            if (plid == LayoutConstants.DEFAULT_PLID) {
                portletURL = liferayPortletResponse.createLiferayPortletURL(
                        getControlPanelPlid(liferayPortletRequest),
                        CdsDemandPortletKeys.CDSDEMAND,
                        PortletRequest.RENDER_PHASE
                );
            } else {
                portletURL = PortletURLFactoryUtil.create(liferayPortletRequest,
                        CdsDemandPortletKeys.CDSDEMAND, plid, PortletRequest.RENDER_PHASE);
            }

            return portletURL.toString() + "#/demand/view/" + _entry.getPrimaryKey();

        } catch (Exception ex) {
            _log.error(ex);
        }

        return null;

    }

    @Override
    public String getUrlTitle() {
        return _entry.getUrlTitle();
    }

    @Override
    public long getUserId() {
        return _entry.getUserId();
    }

    @Override
    public String getUserName() {
        return _entry.getUserName();
    }

    @Override
    public String getUuid() {
        return _entry.getUuid();
    }

    @Override
    public boolean hasEditPermission(PermissionChecker permissionChecker)
            throws PortalException {

        return CdsDemandEntryPermission.contains(
                permissionChecker, _entry, ActionKeys.UPDATE);
    }

    @Override
    public boolean hasViewPermission(PermissionChecker permissionChecker)
            throws PortalException {

        return CdsDemandEntryPermission.contains(
                permissionChecker, _entry, ActionKeys.VIEW);
    }

    @Override
    public boolean include(
            HttpServletRequest request, HttpServletResponse response,
            String template)
            throws Exception {

        request.setAttribute("cdsDemand", _entry);

        return super.include(request, response, template);
    }

    @Override
    public boolean isPrintable() {
        return true;
    }

    public void setAssetDisplayPageFriendlyURLProvider(
            AssetDisplayPageFriendlyURLProvider
                    assetDisplayPageFriendlyURLProvider) {

        _assetDisplayPageFriendlyURLProvider =
                assetDisplayPageFriendlyURLProvider;
    }

    private boolean _hasViewInContextGroupLayout(
            long groupId, ThemeDisplay themeDisplay) {

        try {
            PortletLayoutFinder portletLayoutFinder =
                    PortletLayoutFinderRegistryUtil.getPortletLayoutFinder(
                            CdsDemand.class.getName());

            PortletLayoutFinder.Result result = portletLayoutFinder.find(
                    themeDisplay, groupId);

            if ((result == null) || Validator.isNull(result.getPortletId())) {
                return false;
            }

            return true;
        } catch (PortalException pe) {
            if (_log.isDebugEnabled()) {
                _log.debug(pe.getLocalizedMessage(), pe);
            }

            return false;
        }
    }

    private final CdsDemand _entry;
    private final ResourceBundleLoader _resourceBundleLoader;
    private AssetDisplayPageFriendlyURLProvider
            _assetDisplayPageFriendlyURLProvider;

}