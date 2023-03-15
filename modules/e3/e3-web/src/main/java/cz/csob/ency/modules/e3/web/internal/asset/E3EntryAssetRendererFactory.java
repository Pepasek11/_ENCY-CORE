package cz.csob.ency.modules.e3.web.internal.asset;

import com.liferay.asset.display.page.portlet.AssetDisplayPageFriendlyURLProvider;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.petra.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoaderUtil;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.Portal;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import javax.servlet.ServletContext;

import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.entry.service.E3EntryLocalService;
import cz.csob.ency.modules.e3.web.portlet.base.actions.constants.E3RenderCommand;
import cz.csob.ency.modules.e3.entry.constants.E3PortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jorge Ferrer
 * @author Juan Fernández
 * @author Raymond Augé
 * @author Sergio González
 */
@Component(
        immediate = true, property = "javax.portlet.name=" + E3PortletKeys.E3Portlet,
        service = AssetRendererFactory.class
)
public class E3EntryAssetRendererFactory
        extends BaseAssetRendererFactory<E3Entry> {

    public static final String TYPE = "e3entry";
    private static final Log _log = LogFactoryUtil.getLog(
            E3EntryAssetRendererFactory.class);

    public E3EntryAssetRendererFactory() {
        setClassName(E3Entry.class.getName());
        setLinkable(true);
        setPortletId(E3PortletKeys.E3Portlet);
        setSearchable(true);
    }

    @Override
    public AssetRenderer<E3Entry> getAssetRenderer(long classPK, int type)
            throws PortalException {

        E3EntryAssetRenderer e3EntryAssetRenderer =
                new E3EntryAssetRenderer(
                        _e3EntryLocalService.getEntry(classPK),
                        ResourceBundleLoaderUtil.
                                getResourceBundleLoaderByBundleSymbolicName(
                                        "cz.csob.ency.modules.e3.web"));

        e3EntryAssetRenderer.setAssetDisplayPageFriendlyURLProvider(
                _assetDisplayPageFriendlyURLProvider);
        e3EntryAssetRenderer.setAssetRendererType(type);
        e3EntryAssetRenderer.setServletContext(_servletContext);

        return e3EntryAssetRenderer;
    }

    /* @todo urltitle
    @Override
    public AssetRenderer<E3Entry> getAssetRenderer(
            long groupId, String urlTitle)
            throws PortalException {

        E3EntryAssetRenderer e3EntryAssetRenderer =
                new E3EntryAssetRenderer(
                        _e3EntryLocalService.getEntry(groupId, urlTitle),
                        ResourceBundleLoaderUtil.
                                getResourceBundleLoaderByBundleSymbolicName(
                                        "cz.csob.ency.modules.e3.web"));

        e3EntryAssetRenderer.setServletContext(_servletContext);

        return e3EntryAssetRenderer;
    }
*/

    @Override
    public String getClassName() {
        return E3Entry.class.getName();
    }

    @Override
    public String getIconCssClass() {
        return "e3entries";
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public PortletURL getURLAdd(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse, long classTypeId) {

        return PortletURLBuilder.create(
                _portal.getControlPanelPortletURL(
                        liferayPortletRequest, getGroup(liferayPortletRequest),
                        E3PortletKeys.E3Portlet, 0, 0, PortletRequest.RENDER_PHASE)
        ).setMVCRenderCommandName(
                E3RenderCommand.EDIT_ENTRY_COMMAND
        ).build();
    }

    @Override
    public PortletURL getURLView(
            LiferayPortletResponse liferayPortletResponse,
            WindowState windowState) {

        LiferayPortletURL liferayPortletURL =
                liferayPortletResponse.createLiferayPortletURL(
                        E3PortletKeys.E3Portlet, PortletRequest.RENDER_PHASE);

        try {
            liferayPortletURL.setWindowState(windowState);
            liferayPortletURL.setParameter("XXXX","factory");
        } catch (WindowStateException windowStateException) {
            if (_log.isDebugEnabled()) {
                _log.debug(windowStateException, windowStateException);
            }
        }

        return liferayPortletURL;
    }

    @Override
    public boolean hasAddPermission(
            PermissionChecker permissionChecker, long groupId, long classTypeId) {

        return true;
//        return _portletResourcePermission.contains(
//                permissionChecker, groupId, ActionKeys.ADD_ENTRY);
    }

    @Override
    public boolean hasPermission(
            PermissionChecker permissionChecker, long classPK, String actionId)
            throws Exception {

        return true;
//        return _e3EntryModelResourcePermission.contains(
//                permissionChecker, classPK, actionId);
    }

    @Reference
    private AssetDisplayPageFriendlyURLProvider
            _assetDisplayPageFriendlyURLProvider;

    @Reference
    private E3EntryLocalService _e3EntryLocalService;
/*
    @Reference(target = "(model.class.name=cz.csob.ency.modules.e3.entry.model.E3Entry)")
    private ModelResourcePermission<E3Entry>
            _e3EntryModelResourcePermission;
*/
    @Reference
    private Portal _portal;
/*
    @Reference(target = "(resource.name=" + E3Constants.RESOURCE_NAME + ")")
    private PortletResourcePermission _portletResourcePermission;
*/
    @Reference(target = "(osgi.web.symbolicname=cz.csob.ency.modules.e3.web)")
    private ServletContext _servletContext;
}