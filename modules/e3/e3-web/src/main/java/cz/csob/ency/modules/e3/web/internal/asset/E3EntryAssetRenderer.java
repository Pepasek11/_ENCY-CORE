package cz.csob.ency.modules.e3.web.internal.asset;

import com.liferay.asset.display.page.portlet.AssetDisplayPageFriendlyURLProvider;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.asset.util.AssetHelper;
import com.liferay.petra.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.portlet.*;
import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoader;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.trash.TrashRenderer;
import com.liferay.portal.kernel.util.*;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.entry.service.E3EntryLocalServiceUtil;
import cz.csob.ency.modules.e3.web.portlet.base.actions.constants.E3RenderCommand;
import cz.csob.ency.modules.e3.entry.constants.E3PortletKeys;
import cz.csob.ency.modules.e3.web.constants.E3WebKeys;

import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Locale;

/**
 * @author Jorge Ferrer
 * @author Juan Fernández
 * @author Sergio González
 * @author Zsolt Berentey
 */
public class E3EntryAssetRenderer
        extends BaseJSPAssetRenderer<E3Entry> implements TrashRenderer {

    private static final Log _log = LogFactoryUtil.getLog(
            E3EntryAssetRenderer.class);

    public E3EntryAssetRenderer(
            E3Entry entry, ResourceBundleLoader resourceBundleLoader) {

        _entry = entry;
        _resourceBundleLoader = resourceBundleLoader;
        try {
            _portletId = E3EntryLocalServiceUtil.getEntryPortletName(_entry);
        } catch (PortalException exception) {
        } finally {
            if (Validator.isBlank(_portletId)) {
                _portletId = E3PortletKeys.E3Portlet;
            }
        }
    }

    @Override
    public E3Entry getAssetObject() {
        return _entry;
    }

    @Override
    public String getClassName() {
        return E3Entry.class.getName();
    }

    /*
    @Override
    public String getDiscussionPath() {
        if (PropsValues.E3_ENTRY_COMMENTS_ENABLED) {
            return "edit_entry_discussion";
        }

        return null;
    }
*/

    @Override
    public long getClassPK() {
        return _entry.getEntryId();
    }

    @Override
    public long getGroupId() {
        return _entry.getGroupId();
    }

    @Override
    public String getJspPath(
            HttpServletRequest httpServletRequest, String template) {

        if (template.equals(TEMPLATE_ABSTRACT) ||
                template.equals(TEMPLATE_FULL_CONTENT)) {

            return "/e3/asset/" + template + ".jsp";
        }

        return null;
    }

    @Override
    public String getPortletId() {
        AssetRendererFactory<E3Entry> assetRendererFactory =
                getAssetRendererFactory();

        return assetRendererFactory.getPortletId();
    }

    @Override
    public int getStatus() {
        return (int) _entry.getStatus();
    }

    @Override
    public String getSummary(
            PortletRequest portletRequest, PortletResponse portletResponse) {

        int abstractLength = AssetHelper.ASSET_ENTRY_ABSTRACT_LENGTH;

        if (portletRequest != null) {
            abstractLength = GetterUtil.getInteger(
                    portletRequest.getAttribute(
                            WebKeys.ASSET_ENTRY_ABSTRACT_LENGTH),
                    AssetHelper.ASSET_ENTRY_ABSTRACT_LENGTH);
        }

        String summary = HtmlUtil.escape(_entry.getDescription());

        if (Validator.isNull(summary)) {
            summary = StringUtil.shorten(
                    HtmlUtil.stripHtml(_entry.getSummary()), abstractLength);
        }

        return summary;
    }

    @Override
    public String getTitle(Locale locale) {
//        ResourceBundle resourceBundle =
//                _resourceBundleLoader.loadResourceBundle(locale);

        return _entry.getName();
//        return E3EntryUtil.getDisplayTitle(resourceBundle, _entry);
    }

    @Override
    public String getType() {
        return E3EntryAssetRendererFactory.TYPE;
    }

    @Override
    public PortletURL getURLEdit(HttpServletRequest httpServletRequest) {
        Group group = GroupLocalServiceUtil.fetchGroup(_entry.getGroupId());

        if (group.isCompany()) {
            ThemeDisplay themeDisplay =
                    (ThemeDisplay) httpServletRequest.getAttribute(
                            WebKeys.THEME_DISPLAY);

            group = themeDisplay.getScopeGroup();
        }

        return PortletURLBuilder.create(
                PortalUtil.getControlPanelPortletURL(
                        httpServletRequest, group, _portletId, 0, 0,
                        PortletRequest.RENDER_PHASE)
        ).setMVCRenderCommandName(
                E3RenderCommand.EDIT_ENTRY_COMMAND
        ).setParameter(
                "entryId", _entry.getEntryId()
        ).build();
    }

    @Override
    public PortletURL getURLEdit(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse) {

        PortletURL contextUrl =
                _getUrlInContext(liferayPortletRequest, E3RenderCommand.EDIT_ENTRY_COMMAND);

        if(!Validator.isNull(contextUrl)) {
            return contextUrl;
        }

        return getURLEdit(
                PortalUtil.getHttpServletRequest(liferayPortletRequest));
    }

    @Override
    public String getURLView(
            LiferayPortletResponse liferayPortletResponse,
            WindowState windowState)
            throws Exception {

        AssetRendererFactory<E3Entry> assetRendererFactory =
                getAssetRendererFactory();

        return PortletURLBuilder.create(
                assetRendererFactory.getURLView(liferayPortletResponse, windowState)
        ).setMVCRenderCommandName(
                E3RenderCommand.VIEW_ENTRY_COMMAND
        ).setParameter(
                "entryId", _entry.getEntryId()
        ).setWindowState(
                windowState
        ).buildString();

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

        PortletURL contextUrl =
                _getUrlInContext(liferayPortletRequest, E3RenderCommand.VIEW_ENTRY_COMMAND);

        if(contextUrl!=null) {
            return contextUrl.toString();
        }

        return noSuchEntryRedirect;

    }

    /*
        @Override
        public String getUrlTitle() {
            return _entry.getUrlTitle();
        }
    */
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

        return true;
        /* @todo
        return E3EntryPermission.contains(
                permissionChecker, _entry, ActionKeys.UPDATE);

         */
    }

    @Override
    public boolean hasViewPermission(PermissionChecker permissionChecker)
            throws PortalException {

        return true;
        /* @todo
        return E3EntryPermission.contains(
                permissionChecker, _entry, ActionKeys.VIEW);

         */
    }

    @Override
    public boolean include(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, String template)
            throws Exception {

        httpServletRequest.setAttribute(E3WebKeys.ENTRY, _entry);

        return super.include(httpServletRequest, httpServletResponse, template);
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

    private long _getPlidFromPortletId(long groupId, String portletId) throws PortalException {
        Group group = GroupLocalServiceUtil.getGroup(groupId);

        if (group.isLayout()) {
            Layout scopeLayout = LayoutLocalServiceUtil.getLayout(
                    group.getClassPK());

            groupId = scopeLayout.getGroupId();
        }

        List<Layout> layouts = LayoutLocalServiceUtil.getLayouts(
                groupId, false, LayoutConstants.TYPE_PORTLET);

        for (Layout layout : layouts) {
            LayoutTypePortlet layoutTypePortlet =
                    (LayoutTypePortlet) layout.getLayoutType();


            long scopeGroupId = PortalUtil.getScopeGroupId(layout, portletId);
            if (scopeGroupId != groupId) {
                continue;
            }

            for (Portlet portlet : layoutTypePortlet.getAllPortlets()) {
                if ((portletId.equals(portlet.getPortletId()) ||
                        portletId.equals(portlet.getRootPortletId()))) {
                    return layout.getPlid();
                }
            }
        }
        return LayoutConstants.DEFAULT_PLID;
    }

    private PortletURL _getUrlInContext(LiferayPortletRequest liferayPortletRequest, String commandName) {
        try {
            long plid = PortalUtil.getPlidFromPortletId(_entry.getGroupId(),
                    _portletId);

            PortletURL portletURL;

            if (plid == LayoutConstants.DEFAULT_PLID) {
                plid = _getPlidFromPortletId(_entry.getGroupId(), _portletId);
            }
            if (plid == LayoutConstants.DEFAULT_PLID) {
                portletURL = PortletURLFactoryUtil.create(liferayPortletRequest,
                        _portletId, getControlPanelPlid(liferayPortletRequest), PortletRequest.RENDER_PHASE);
            } else {
                portletURL = PortletURLFactoryUtil.create(liferayPortletRequest,
                        _portletId, plid, PortletRequest.RENDER_PHASE);
            }

            portletURL.setParameter("mvcRenderCommandName", commandName);
            portletURL.setParameter("entryId", String.valueOf(_entry.getEntryId()));
            String currentUrl = PortalUtil.getCurrentURL(liferayPortletRequest);

            portletURL.setParameter("redirect", currentUrl);

            return portletURL;

        } catch (PortalException e) {

        } catch (SystemException e) {
        }
        return null;
    }
    private final E3Entry _entry;
    private final ResourceBundleLoader _resourceBundleLoader;
    private AssetDisplayPageFriendlyURLProvider
            _assetDisplayPageFriendlyURLProvider;
    private String _portletId;

}