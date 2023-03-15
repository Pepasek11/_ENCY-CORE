package cz.csob.ency.modules.e3.web.util;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryServiceUtil;
import com.liferay.asset.kernel.service.persistence.AssetEntryQuery;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchContainerResults;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.util.*;
import cz.csob.ency.modules.e3.app.model.E3App;
import cz.csob.ency.modules.e3.app.service.E3AppLocalServiceUtil;
import cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.entry.service.E3EntryLocalServiceUtil;
import cz.csob.ency.modules.e3.entry.utils.comparator.EntryModifiedDateComparator;
import cz.csob.ency.modules.e3.entry.utils.comparator.EntryNameComparator;
import cz.csob.ency.modules.e3.web.portlet.base.actions.constants.E3RenderCommand;

import javax.portlet.MimeResponse;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;


public class E3EntryUtil {
    private static final Log log = LogFactoryUtil.getLog(E3EntryUtil.class);

    public static E3Entry getEntry(PortletRequest portletRequest)
            throws NoSuchE3EntryException {

        long entryId = ParamUtil.getLong(portletRequest, "entryId");

        String urlTitle = ParamUtil.getString(portletRequest, "urlTitle");

        E3Entry entry = null;

        if (entryId > 0) {
            entry = E3EntryLocalServiceUtil.getEntry(entryId);
        }
        /*
        @todo url title support
        else if (Validator.isNotNull(urlTitle) &&
                SessionErrors.isEmpty(portletRequest)) {

            ThemeDisplay themeDisplay =
                    (ThemeDisplay)portletRequest.getAttribute(
                            WebKeys.THEME_DISPLAY);

            try {
                entry = E3EntryLocalServiceUtil.getE3Entry(
                        themeDisplay.getScopeGroupId(), urlTitle);
            }
            catch (NoSuchEntryException noSuchEntryException) {
                if (urlTitle.indexOf(CharPool.UNDERLINE) != -1) {

                    // Check another URL title for backwards compatibility. See
                    // LEP-5733.

                    urlTitle = StringUtil.replace(
                            urlTitle, CharPool.UNDERLINE, CharPool.DASH);

                    entry = E3EntryLocalServiceUtil.getEntry(
                            themeDisplay.getScopeGroupId(), urlTitle);
                }
                else {
                    throw noSuchEntryException;
                }
            }
        }

         */

        /*
        @todo trash support
        if ((entry != null) && entry.isInTrash()) {
            throw new NoSuchEntryException("{entryId=" + entryId + "}");
        }
               */
        if (entry == null) {
            throw new NoSuchE3EntryException("{entryId=" + entryId + "}");
        }
        return entry;
    }

    public static LiferayPortletURL getEntryAddUrl(RenderRequest request, RenderResponse response, String appClass) {
        return getEntryAddUrl(
                PortalUtil.getPortal().getLiferayPortletRequest(request),
                PortalUtil.getPortal().getLiferayPortletResponse(response),
                appClass
        );
    }

    public static LiferayPortletURL getEntryAddUrl(LiferayPortletRequest request, LiferayPortletResponse response, String appClass) {
        try {
            String portletId = E3AppLocalServiceUtil.getApp(appClass).getAppMainPortletName();
            LiferayPortletURL renderURL = response.createRenderURL();
            String namespace = response.getNamespace();
            // renderURL.setPortletId(portletId);
            renderURL.setParameter(namespace + "appClass", appClass);
            renderURL.setParameter(namespace + "mvcRenderCommandName", E3RenderCommand.EDIT_ENTRY_COMMAND);
            renderURL.setParameter(Constants.CMD, Constants.ADD);

            return renderURL;
        } catch (Exception ex) {
            log.error(ex);
        }
        return null;
    }

    public static LiferayPortletURL getEntryDeleteUrl(
            RenderRequest request, RenderResponse response, E3Entry entry, String redirectURI) {
        return getEntryDeleteUrl(request, response, entry, redirectURI, false);
    }

    public static LiferayPortletURL getEntryDeleteUrl(
            RenderRequest request, RenderResponse response, E3Entry entry, String redirectURI, boolean toTrash) {
        return getEntryDeleteUrl(
                PortalUtil.getPortal().getLiferayPortletRequest(request),
                PortalUtil.getPortal().getLiferayPortletResponse(response),
                entry,
                redirectURI,
                toTrash
        );
    }

    public static LiferayPortletURL getEntryDeleteUrl(
            LiferayPortletRequest request, LiferayPortletResponse response, E3Entry entry, String redirectURI) {
        return getEntryDeleteUrl(request, response, entry, redirectURI, false);
    }

    public static LiferayPortletURL getEntryDeleteUrl(
            LiferayPortletRequest request, LiferayPortletResponse response, E3Entry entry, String redirectURI, Boolean toTrash) {
        try {
            LiferayPortletURL renderURL = response.createActionURL(E3EntryLocalServiceUtil.getEntryPortletName(entry));
            String namespace = response.getNamespace();
            // renderURL.setPortletId(portletId);
            renderURL.setParameter(namespace + "redirect",
                    Validator.isBlank(redirectURI) ? response.createRenderURL(MimeResponse.Copy.ALL).toString() : redirectURI);
            renderURL.setParameter(namespace + "entryId", String.valueOf(entry.getEntryId()));
            renderURL.setParameter(namespace + "javax.portlet.action", E3RenderCommand.EDIT_ENTRY_COMMAND);
            renderURL.setParameter(namespace + Constants.CMD, toTrash ? Constants.MOVE_TO_TRASH : Constants.DELETE);

            return renderURL;
        } catch (Exception ex) {
            log.error(ex);
        }
        return null;
    }

    public static LiferayPortletURL getEntryEditUrl(RenderRequest request, RenderResponse response, E3Entry entry) {
        return getEntryEditUrl(
                PortalUtil.getPortal().getLiferayPortletRequest(request),
                PortalUtil.getPortal().getLiferayPortletResponse(response),
                entry
        );
    }

    public static LiferayPortletURL getEntryEditUrl(LiferayPortletRequest request, LiferayPortletResponse response, E3Entry entry) {
        try {
            String portletId = E3EntryLocalServiceUtil.getEntryPortletName(entry);
            LiferayPortletURL renderURL = response.createRenderURL();

            String namespace = response.getNamespace();
            renderURL.setPortletId(portletId);
            renderURL.setParameter("entryId", String.valueOf(entry.getEntryId()));
            renderURL.setParameter(Constants.CMD, Constants.UPDATE);
            renderURL.setParameter("mvcRenderCommandName", E3RenderCommand.EDIT_ENTRY_COMMAND);

            return renderURL;
        } catch (Exception ex) {
            log.error(ex);
        }
        return null;
    }

    public static LiferayPortletURL getEntryToTrashUrl(
            RenderRequest request, RenderResponse response, E3Entry entry, String redirectURI) {

        return getEntryDeleteUrl(
                request, response, entry, redirectURI, true
        );
    }

    public static LiferayPortletURL getEntryToTrashUrl(
            LiferayPortletRequest request, LiferayPortletResponse response, E3Entry entry, String redirectURI) {

        return getEntryDeleteUrl(
                request, response, entry, redirectURI, true
        );
    }

    public static LiferayPortletURL getEntryViewUrl(RenderRequest request, RenderResponse response, E3Entry entry) {
        return getEntryViewUrl(
                PortalUtil.getPortal().getLiferayPortletRequest(request),
                PortalUtil.getPortal().getLiferayPortletResponse(response),
                entry
        );
    }

    public static LiferayPortletURL getEntryViewUrl(LiferayPortletRequest request, LiferayPortletResponse response, E3Entry entry) {
        try {

            String portletId = E3EntryLocalServiceUtil.getEntryPortletName(entry);
            LiferayPortletURL renderURL = response.createRenderURL();

            renderURL.setPortletId(portletId);
            renderURL.setParameter("entryId", String.valueOf(entry.getEntryId()));
            renderURL.setParameter("mvcRenderCommandName", E3RenderCommand.VIEW_ENTRY_COMMAND);

            return renderURL;
        } catch (Exception ex) {
            log.error(ex);
        }
        return null;
    }

    public static OrderByComparator<E3Entry> getOrderByComparator(
            String orderByCol, String orderByType) {

        boolean orderByAsc = !orderByType.equals("desc");

        OrderByComparator<E3Entry> orderByComparator = null;

        if (orderByCol.equals("modified-date")) {
            orderByComparator = new EntryModifiedDateComparator(orderByAsc);
        } else {
            orderByComparator = new EntryNameComparator(orderByAsc);
        }

        return orderByComparator;
    }

    public static SearchContainerResults<AssetEntry> getSearchContainerResults(
            SearchContainer<?> searchContainer)
            throws PortalException {

        AssetEntryQuery assetEntryQuery = new AssetEntryQuery(
                E3Entry.class.getName(), searchContainer);

        assetEntryQuery.setEnablePermissions(true);
        assetEntryQuery.setExcludeZeroViewCount(false);
        assetEntryQuery.setOrderByCol1("publishDate");
        assetEntryQuery.setVisible(Boolean.TRUE);

        int total = AssetEntryServiceUtil.getEntriesCount(assetEntryQuery);

        assetEntryQuery.setEnd(searchContainer.getEnd());
        assetEntryQuery.setStart(searchContainer.getStart());

        List<AssetEntry> assetEntries = AssetEntryServiceUtil.getEntries(
                assetEntryQuery);

        return new SearchContainerResults<>(assetEntries, total);
    }
}
