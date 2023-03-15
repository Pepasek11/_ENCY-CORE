package cz.csob.ency.modules.e3.web.internal.servlet.taglib.util;

/**
 * @see com.liferay.blogs.web.internal.servlet.taglib.util.BlogsEntryActionDropdownItemsProvider
 */

import com.liferay.blogs.constants.BlogsPortletKeys;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerRegistryUtil;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.portlet.url.builder.PortletURLBuilder;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.StagedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.permission.GroupPermissionUtil;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import com.liferay.taglib.security.PermissionsURLTag;
import com.liferay.trash.TrashHelper;
import cz.csob.ency.modules.e3.entry.constants.E3PortletKeys;
import cz.csob.ency.modules.e3.entry.internal.security.permission.resource.E3EntryModelPermission;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.entry.service.E3EntryLocalServiceUtil;
import cz.csob.ency.modules.e3.web.portlet.base.actions.constants.E3RenderCommand;
import cz.csob.ency.modules.e3.web.util.E3EntryUtil;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.ActionURL;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

public class E3EntryActionDropdownItemsProvider {
    private static final Log _log = LogFactoryUtil.getLog(
            E3EntryActionDropdownItemsProvider.class);

    public E3EntryActionDropdownItemsProvider(
            RenderRequest renderRequest, RenderResponse renderResponse,
            PermissionChecker permissionChecker, ResourceBundle resourceBundle,
            TrashHelper trashHelper) {

        _renderResponse = renderResponse;
        _renderRequest = renderRequest;
        _permissionChecker = permissionChecker;
        _resourceBundle = resourceBundle;
        _trashHelper = trashHelper;

        _httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
    }

    /*
    /**
     * @se e
     * com.liferay.exportimport.changeset.taglib.internal.display.context.ChangesetTaglibDisplayContext#isShowPublishMenuItem(
     *Group, String)
     * /
    private static boolean _isShowPublishMenuItem(
            Group group, String portletId) {

        try {
            if (group.isLayout()) {
                return false;
            }

            if ((group.isStagingGroup() || group.isStagedRemotely()) &&
                    group.isStagedPortlet(portletId)) {

                return true;
            }

            return false;
        } catch (Exception exception) {
            if (_log.isDebugEnabled()) {
                _log.debug(exception, exception);
            }

            return false;
        }
    }

    /**
     * @se e com.liferay.exportimport.changeset.taglib.internal.display.context.ChangesetTaglibDisplayContext#isShowPublishMenuItem(
     *Group, String, String, String)
     * /
    private static boolean _isShowPublishMenuItem(
            Group group, String portletId, String className, String uuid) {

        try {
            StagedModelDataHandler<?> stagedModelDataHandler =
                    StagedModelDataHandlerRegistryUtil.getStagedModelDataHandler(
                            className);

            StagedModel stagedModel =
                    stagedModelDataHandler.fetchStagedModelByUuidAndGroupId(
                            uuid, group.getGroupId());

            if (stagedModel == null) {
                return false;
            }

            if (stagedModel instanceof WorkflowedModel) {
                WorkflowedModel workflowedModel = (WorkflowedModel) stagedModel;

                if (!ArrayUtil.contains(
                        stagedModelDataHandler.getExportableStatuses(),
                        workflowedModel.getStatus())) {

                    return false;
                }
            }

            return _isShowPublishMenuItem(group, portletId);
        } catch (Exception exception) {
            if (_log.isDebugEnabled()) {
                _log.debug(exception, exception);
            }

            return false;
        }
    }
    */

    public List<DropdownItem> getActionDropdownItems(E3Entry entry)
            throws PortalException {

        try {
            boolean sharingEnabled = false;
        /* @todo
               = SharingUtil.isSharingEnabled(
                entry.getGroupId());

         */
            boolean hasDeletePermission = _hasDeletePermission(entry);
            boolean trashEnabled = _isTrashEnabled();

            return DropdownItemListBuilder.add(
                    () -> _hasUpdatePermission(entry),
                    _getEditEntryActionUnsafeConsumer(entry)
            )/*
                .add(
                () ->
                        sharingEnabled &&
                                E3EntrySharingUtil.containsSharePermission(
                                        _permissionChecker, entry),
                E3EntrySharingUtil.createShareDropdownItem(
                        entry, _httpServletRequest)
        ).add(
                () ->
                        sharingEnabled &&
                                E3EntrySharingUtil.containsManageCollaboratorsPermission(
                                        _permissionChecker, entry),
                E3EntrySharingUtil.createManageCollaboratorsDropdownItem(
                        entry, _httpServletRequest)
        )*/
                    .add(
                            () -> _hasPermissionsPermission(entry),
                            _getPermissionsActionUnsafeConsumer(entry)
                    ).add(
                            () -> hasDeletePermission && trashEnabled,
                            _getMoveEntryToTrashActionUnsafeConsumer(entry)
                    ).add(
                            () -> hasDeletePermission && !trashEnabled,
                            _getDeleteEntryActionUnsafeConsumer(entry)
                    )/*.add(
                        () ->
                                _isShowPublishMenuItem(entry) &&
                                        _hasExportImportPortletInfoPermission(entry),
                        _getPublishToLiveEntryActionUnsafeConsumer(entry)
                )*/
                    .build();
        }catch (Exception ex) {
            _log.error(ex);
            return Collections.emptyList();
        }
    }

    private UnsafeConsumer<DropdownItem, Exception>
    _getDeleteEntryActionUnsafeConsumer(E3Entry entry) {

        LiferayPortletURL deleteURL = E3EntryUtil.getEntryDeleteUrl(
                _renderRequest, _renderResponse, entry, _getRedirectURL());

        return dropdownItem -> {
            dropdownItem.putData("action", "delete");
            dropdownItem.putData("deleteURL", deleteURL.toString());
            dropdownItem.setLabel(
                    LanguageUtil.get(_httpServletRequest, "delete"));
        };
    }

    private UnsafeConsumer<DropdownItem, Exception>
    _getEditEntryActionUnsafeConsumer(E3Entry entry) {

        ThemeDisplay themeDisplay =
                (ThemeDisplay) _httpServletRequest.getAttribute(
                        WebKeys.THEME_DISPLAY);

        return dropdownItem -> {
            String portletResource = StringPool.BLANK;

            PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

            if (!Objects.equals(
                    portletDisplay.getPortletName(),
                    BlogsPortletKeys.BLOGS_ADMIN)) {

                portletResource = portletDisplay.getPortletName();
            }

            dropdownItem.setHref(
                    /*
                    PortalUtil.getControlPanelPortletURL(
                            _httpServletRequest, themeDisplay.getScopeGroup(),
                            BlogsPortletKeys.BLOGS_ADMIN, 0, themeDisplay.getPlid(),
                            PortletRequest.RENDER_PHASE),
                    "mvcRenderCommandName", "/blogs/edit_entry", "redirect",
                    _getRedirectURL(), "portletResource", portletResource,
                    "entryId", entry.getEntryId()
                     */
                    E3EntryUtil.getEntryEditUrl(_renderRequest, _renderResponse, entry)
            );

            dropdownItem.setIcon("edit");
            dropdownItem.setLabel(LanguageUtil.get(_resourceBundle, "edit"));
        };
    }

    private UnsafeConsumer<DropdownItem, Exception>
    _getMoveEntryToTrashActionUnsafeConsumer(E3Entry entry) {
        LiferayPortletURL moveToTrashURL = E3EntryUtil.getEntryToTrashUrl(_renderRequest,_renderResponse,entry,_getRedirectURL());
        return dropdownItem -> {
            dropdownItem.putData("action", "delete");
            dropdownItem.putData("deleteURL", moveToTrashURL.toString());
            dropdownItem.setLabel(
                    LanguageUtil.get(_httpServletRequest, "move-to-recycle-bin"));
        };
    }

    private UnsafeConsumer<DropdownItem, Exception>
    _getPermissionsActionUnsafeConsumer(E3Entry entry) {

        return dropdownItem -> {
            dropdownItem.putData("action", "permissions");
            dropdownItem.putData(
                    "permissionsURL", _getPermissionsURL(entry));
            dropdownItem.setLabel(
                    LanguageUtil.get(_httpServletRequest, "permissions"));
        };
    }

    private String _getPermissionsURL(E3Entry entry) {
        try {
            return PermissionsURLTag.doTag(
                    StringPool.BLANK, E3Entry.class.getName(),
                    entry.getName(), /*.getDisplayTitle(_resourceBundle, entry),*/
                    null, String.valueOf(entry.getEntryId()),
                    LiferayWindowState.POP_UP.toString(), null,
                    _httpServletRequest);
        } catch (Exception exception) {
            return ReflectionUtil.throwException(exception);
        }
    }

    /*
    private UnsafeConsumer<DropdownItem, Exception>
    _getPublishToLiveEntryActionUnsafeConsumer(E3Entry entry) {
    // todo
        return dropdownItem -> {
            dropdownItem.putData("action", "publishToLive");
            dropdownItem.putData(
                    "publishEntryURL",
                    PortletURLBuilder.createActionURL(
                            _renderResponse
                    ).setActionName(
                            "/e3_entry/publish_entry"
                    ).setBackURL(
                            _getRedirectURL()
                    ).setParameter(
                            "entryId", entry.getEntryId()
                    ).buildString());
            dropdownItem.setLabel(
                    LanguageUtil.get(_httpServletRequest, "publish-to-live"));
        };
    }

     */

    private String _getRedirectURL() {
        return PortletURLBuilder.createRenderURL(
                _renderResponse
        ).setMVCRenderCommandName(
                E3RenderCommand.VIEW_COMMAND
        ).buildString();
    }

    private boolean _hasDeletePermission(E3Entry entry) {
        try {
            return E3EntryModelPermission.contains(
                    _permissionChecker, entry, ActionKeys.DELETE);
        } catch (PortalException portalException) {
            return ReflectionUtil.throwException(portalException);
        }
    }

    private boolean _hasExportImportPortletInfoPermission(
            E3Entry entry) {

        try {
            return GroupPermissionUtil.contains(
                    _permissionChecker, entry.getGroupId(),
                    ActionKeys.EXPORT_IMPORT_PORTLET_INFO);
        } catch (PortalException portalException) {
            return ReflectionUtil.throwException(portalException);
        }
    }

    private boolean _hasPermissionsPermission(E3Entry entry) {
        try {
            return E3EntryModelPermission.contains(
                    _permissionChecker, entry, ActionKeys.PERMISSIONS);
        } catch (PortalException portalException) {
            return ReflectionUtil.throwException(portalException);
        }
    }

    private boolean _hasUpdatePermission(E3Entry entry) {
        try {
            return E3EntryModelPermission.contains(
                    _permissionChecker, entry, ActionKeys.UPDATE);
        } catch (PortalException portalException) {
            return ReflectionUtil.throwException(portalException);
        }
    }
/*
    private boolean _isShowPublishMenuItem(E3Entry entry) {
        ThemeDisplay themeDisplay =
                (ThemeDisplay) _httpServletRequest.getAttribute(
                        WebKeys.THEME_DISPLAY);

        return _isShowPublishMenuItem(
                themeDisplay.getScopeGroup(), E3PortletKeys.E3Portlet,
                E3Entry.class.getName(), entry.getUuid());
    }
*/
    private boolean _isTrashEnabled() {
        try {
            if(Validator.isNull(_trashHelper)) {
                return false;
            }
            return _trashHelper.isTrashEnabled(
                    PortalUtil.getScopeGroupId(_httpServletRequest));
        } catch (PortalException portalException) {
            return ReflectionUtil.throwException(portalException);
        }
    }

    private final HttpServletRequest _httpServletRequest;
    private final PermissionChecker _permissionChecker;
    private final RenderRequest _renderRequest;
    private final RenderResponse _renderResponse;
    private final ResourceBundle _resourceBundle;
    private final TrashHelper _trashHelper;
}
