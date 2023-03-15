// 
/*   */
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
/*  */

package cz.csob.ency.modules.apps.meta.cds.internal.trash;

import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.TrashedModel;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.trash.TrashHandler;
import com.liferay.portal.kernel.trash.TrashRenderer;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.trash.BaseTrashHandler;
import com.liferay.trash.constants.TrashActionKeys;
import cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry;
import cz.csob.ency.modules.apps.meta.cds.service.ColumnEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * ColumnEntry Trash handler
 *
 * @author Miroslav Čermák
 */
@Component(
        immediate = true,
        property = "model.class.name=cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry",
        service = TrashHandler.class
)
public class ColumnEntryTrashHandler extends BaseTrashHandler {

    @Override
    public void deleteTrashEntry(long classPK) throws PortalException {
        _columnEntryLocalService.deleteEntry(classPK);
    }

    @Override
    public String getClassName() {
        return ColumnEntry.class.getName();
    }

    @Override
    public String getRestoreContainedModelLink(
            PortletRequest portletRequest, long classPK)
            throws PortalException {

        ColumnEntry entry = _columnEntryLocalService.getColumnEntry(classPK);

        PortletURL portletURL = getRestoreURL(portletRequest, classPK, false);

        portletURL.setParameter("urlTitle", entry.getUrlTitle());
        portletURL.setParameter(Constants.CMD, Constants.UPDATE);
        portletURL.setParameter(
                "resourcePrimKey", String.valueOf(entry.getPrimaryKey()));

        return portletURL.toString();
    }

    @Override
    public String getRestoreContainerModelLink(
            PortletRequest portletRequest, long classPK)
            throws PortalException {

        PortletURL portletURL = getRestoreURL(portletRequest, classPK, true);

        return portletURL.toString();
    }

    @Override
    public String getRestoreMessage(
            PortletRequest portletRequest, long classPK) {

        ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);

        return themeDisplay.translate("columnentry");
    }

    @Override
    public TrashRenderer getTrashRenderer(long classPK) throws PortalException {
        AssetRendererFactory<ColumnEntry> assetRendererFactory =
                AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClass(
                        ColumnEntry.class);

        ColumnEntry entry = _columnEntryLocalService.getColumnEntry(classPK);

        return (TrashRenderer) assetRendererFactory.getAssetRenderer(
                entry.getPrimaryKey());
    }

    @Override
    public TrashedModel getTrashedModel(long classPK) {
        return _columnEntryLocalService.fetchColumnEntry(classPK);
    }

    @Override
    public boolean hasTrashPermission(
            PermissionChecker permissionChecker, long groupId, long classPK,
            String trashActionId)
            throws PortalException {
/*
        if (trashActionId.equals(TrashActionKeys.MOVE)) {
            return ModelResourcePermissionHelper.contains(
                    _columnEntryModelResourcePermission, permissionChecker, groupId,
                    classPK, ActionKeys.ADD_ARTICLE);
        }
*/
        return super.hasTrashPermission(
                permissionChecker, groupId, classPK, trashActionId);
    }

    @Override
    public boolean isInTrash(long classPK) throws PortalException {
        ColumnEntry entry = _columnEntryLocalService.getColumnEntry(classPK);

        return entry.isInTrash();
    }

    @Override
    public boolean isRestorable(long classPK) throws PortalException {
        ColumnEntry entry = _columnEntryLocalService.getColumnEntry(classPK);

        if (!hasTrashPermission(
                PermissionThreadLocal.getPermissionChecker(),
                entry.getGroupId(), classPK, TrashActionKeys.RESTORE)) {

            return false;
        }

        return !entry.isInTrashContainer();
    }

    @Override
    public void restoreTrashEntry(long userId, long classPK)
            throws PortalException {

        _columnEntryLocalService.restoreEntryFromTrash(userId, classPK);
    }

    /**
     * Get Restore URL
     *
     * @param portletRequest
     * @param classPK
     * @param containerModel
     * @return
     * @throws PortalException
     */
    protected PortletURL getRestoreURL(
            PortletRequest portletRequest, long classPK, boolean containerModel)
            throws PortalException {

        PortletURL portletURL = null;

        ColumnEntry entry = _columnEntryLocalService.getColumnEntry(classPK);
        String portletId = PortletProviderUtil.getPortletId(
                ColumnEntry.class.getName(), PortletProvider.Action.VIEW);

        long plid = _portal.getPlidFromPortletId(entry.getGroupId(), portletId);

        if (plid == LayoutConstants.DEFAULT_PLID) {
            portletId = PortletProviderUtil.getPortletId(
                    ColumnEntry.class.getName(), PortletProvider.Action.MANAGE);

            portletURL = _portal.getControlPanelPortletURL(
                    portletRequest, portletId, PortletRequest.RENDER_PHASE);
        } else {
            portletURL = PortletURLFactoryUtil.create(
                    portletRequest, portletId, plid, PortletRequest.RENDER_PHASE);
        }

        if (!containerModel) {
            portletURL.setParameter("mvcRenderCommandName", "/columnentry/view");
        }

        return portletURL;
    }

    @Override
    protected boolean hasPermission(
            PermissionChecker permissionChecker, long classPK, String actionId)
            throws PortalException {

        return _columnEntryModelResourcePermission.contains(
                permissionChecker, classPK, actionId);
    }

    @Reference
    private ColumnEntryLocalService _columnEntryLocalService;
    @Reference(target = "(model.class.name=cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry)")
    private ModelResourcePermission<ColumnEntry> _columnEntryModelResourcePermission;
    @Reference
    private Portal _portal;

}