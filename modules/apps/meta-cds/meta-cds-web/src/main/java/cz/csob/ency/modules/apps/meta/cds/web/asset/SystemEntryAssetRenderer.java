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

import com.liferay.asset.display.page.portlet.AssetDisplayPageFriendlyURLProvider;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.*;
import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoader;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.trash.TrashRenderer;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import cz.csob.ency.modules.apps.meta.cds.constants.MetaCdsPortletKeys;
import cz.csob.ency.modules.apps.meta.cds.model.SystemEntry;
import cz.csob.ency.modules.apps.meta.cds.web.internal.security.permission.resource.SystemEntryEntryPermission;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


/**
 * Asset Renderer
 *
 * This class is used to display contents in Asset Publisher.
 *
 * @author Miroslav Čermák
 */
public class SystemEntryAssetRenderer
        extends BaseJSPAssetRenderer<SystemEntry> implements TrashRenderer {

    private static final Log _log = LogFactoryUtil.getLog(
            SystemEntryAssetRenderer.class);

    public SystemEntryAssetRenderer(
            SystemEntry entry, ResourceBundleLoader resourceBundleLoader) {

        _entry = entry;
        _resourceBundleLoader = resourceBundleLoader;
    }

    @Override
    public SystemEntry getAssetObject() {
        return _entry;
    }

    @Override
    public String getClassName() {
        return SystemEntry.class.getName();
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

            request.setAttribute("systemEntry", _entry);

            return "/system_entry/asset/" + template + ".jsp";
        }

        return null;
    }

    @Override
    public String getPortletId() {
        AssetRendererFactory<SystemEntry> assetRendererFactory =
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
//  //
        return _entry.getSystemName();
// //
    }

    @Override
    public String getTitle(Locale locale) {
//  //
        return _entry.getSystemName();
//  //
    }

    @Override
    public String getType() {
        return SystemEntryAssetRendererFactory.TYPE;
    }

    @Override
    public PortletURL getURLEdit(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse)
            throws Exception {

        Group group = GroupLocalServiceUtil.fetchGroup(_entry.getGroupId());

        if (group.isCompany()) {
            ThemeDisplay themeDisplay =
                    (ThemeDisplay) liferayPortletRequest.getAttribute(
                            WebKeys.THEME_DISPLAY);

            group = themeDisplay.getScopeGroup();
        }

        PortletURL portletURL = PortalUtil.getControlPanelPortletURL(
                liferayPortletRequest, group, MetaCdsPortletKeys.METACDS_ADMIN, 0,
                0, PortletRequest.RENDER_PHASE);

        portletURL.setParameter("mvcRenderCommandName", "/systementry/crud");
        portletURL.setParameter("fromAsset", StringPool.TRUE);
        portletURL.setParameter(Constants.CMD, Constants.UPDATE);
        portletURL.setParameter(
                "resourcePrimKey", String.valueOf(_entry.getPrimaryKey()));

        return portletURL;
    }

    @Override
    public String getURLView(
            LiferayPortletResponse liferayPortletResponse,
            WindowState windowState)
            throws Exception {

        AssetRendererFactory<SystemEntry> assetRendererFactory =
                getAssetRendererFactory();

        PortletURL portletURL = assetRendererFactory.getURLView(
                liferayPortletResponse, windowState);

        portletURL.setParameter("mvcRenderCommandName", "/systementry/crud");
        portletURL.setParameter("fromAsset", StringPool.TRUE);
        portletURL.setParameter(Constants.CMD, Constants.VIEW);
        portletURL.setParameter(
                "resourcePrimKey", String.valueOf(_entry.getPrimaryKey()));
        portletURL.setWindowState(windowState);

        return portletURL.toString();
    }

    @Override
    public String getURLViewInContext(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            String noSuchEntryRedirect)
            throws PortalException {

        if (_assetDisplayPageFriendlyURLProvider != null) {
            ThemeDisplay themeDisplay =
                    (ThemeDisplay) liferayPortletRequest.getAttribute(
                            WebKeys.THEME_DISPLAY);

            String friendlyURL =
                    _assetDisplayPageFriendlyURLProvider.getFriendlyURL(
                            getClassName(), getClassPK(), themeDisplay);

            if (Validator.isNotNull(friendlyURL)) {
                return friendlyURL;
            }
        }
/*
		ThemeDisplay themeDisplay =
			(ThemeDisplay)liferayPortletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		if (!_hasViewInContextGroupLayout(_entry.getGroupId(), themeDisplay)) {
			return null;
		}

		return getURLViewInContext(
			liferayPortletRequest, noSuchEntryRedirect, "/systementry/crud",
			"resourcePrimKey", _entry.getPrimaryKey());
*/
        try {
            long plid = PortalUtil.getPlidFromPortletId(
                    _entry.getGroupId(),
                    MetaCdsPortletKeys.METACDS
            );

            PortletURL portletURL;

            if (plid == LayoutConstants.DEFAULT_PLID) {
                portletURL = liferayPortletResponse.createLiferayPortletURL(
                        getControlPanelPlid(liferayPortletRequest),
                        MetaCdsPortletKeys.METACDS,
                        PortletRequest.RENDER_PHASE
                );
            } else {
                portletURL = PortletURLFactoryUtil.create(liferayPortletRequest,
                        MetaCdsPortletKeys.METACDS, plid, PortletRequest.RENDER_PHASE);
            }
            portletURL.setParameter("mvcRenderCommandName", "/systementry/crud");
            portletURL.setParameter("resourcePrimKey", Long.toString(_entry.getPrimaryKey()));
            String currentUrl = PortalUtil.getCurrentURL(liferayPortletRequest);
            portletURL.setParameter("redirect", currentUrl);
            portletURL.setParameter("backURL", currentUrl);

            return portletURL.toString();

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

        return SystemEntryEntryPermission.contains(
                permissionChecker, _entry, ActionKeys.UPDATE);
    }

    @Override
    public boolean hasViewPermission(PermissionChecker permissionChecker)
            throws PortalException {

        return SystemEntryEntryPermission.contains(
                permissionChecker, _entry, ActionKeys.VIEW);
    }

    @Override
    public boolean include(
            HttpServletRequest request, HttpServletResponse response,
            String template)
            throws Exception {

        request.setAttribute("systemEntry", _entry);

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
                            SystemEntry.class.getName());

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
    private final SystemEntry _entry;
    private final ResourceBundleLoader _resourceBundleLoader;
    private AssetDisplayPageFriendlyURLProvider
            _assetDisplayPageFriendlyURLProvider;

}