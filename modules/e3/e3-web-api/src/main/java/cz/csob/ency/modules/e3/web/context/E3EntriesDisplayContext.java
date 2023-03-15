package cz.csob.ency.modules.e3.web.context;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.chat.service.persistence.EntryUtil;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItem;
import com.liferay.petra.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchContainerResults;
import com.liferay.portal.kernel.exception.NoSuchResourcePermissionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.*;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import cz.csob.ency.modules.e3.app.service.E3AppLocalService;
import cz.csob.ency.modules.e3.app.service.E3AppLocalServiceUtil;
import cz.csob.ency.modules.e3.entry.constants.E3PortletKeys;
import cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException;
import cz.csob.ency.modules.e3.entry.internal.security.permission.resource.E3EntryModelPermission;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.entry.service.E3EntryLocalServiceUtil;
import cz.csob.ency.modules.e3.web.portlet.base.actions.constants.E3RenderCommand;
import cz.csob.ency.modules.e3.web.util.E3EntryUtil;

import javax.portlet.MimeResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E3EntriesDisplayContext {
    private static final Log _log = LogFactoryUtil.getLog(E3EntriesDisplayContext.class);

    public E3EntriesDisplayContext(LiferayPortletRequest liferayPortletRequest,
                                   LiferayPortletResponse liferayPortletResponse)
            throws NoSuchE3EntryException, PortalException {
        _appLocalService = E3AppLocalServiceUtil.getService();
        _liferayPortletRequest = liferayPortletRequest;
        _liferayPortletResponse = liferayPortletResponse;

        _portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(
                liferayPortletRequest);

        _httpServletRequest = _liferayPortletRequest.getHttpServletRequest();

    }

    public ArrayList<DropdownItem> getActionDropdownItems(E3Entry entry) {
        return DropdownItemListBuilder
                .add(dropdownItem ->
                {
                    dropdownItem.setLabel("edit");
                    dropdownItem.setHref(E3EntryUtil.getEntryEditUrl(_liferayPortletRequest, _liferayPortletResponse, entry));
                })
                .add(dropdownItem ->
                {
                    dropdownItem.setLabel("delete");
                    dropdownItem.setHref(E3EntryUtil.getEntryDeleteUrl(
                            _liferayPortletRequest, _liferayPortletResponse, entry, null));

                })
                .build();
    }

    public List<String> getAvailableActions(E3Entry entry)
            throws PortalException {

        ThemeDisplay themeDisplay =
                (ThemeDisplay) _httpServletRequest.getAttribute(
                        WebKeys.THEME_DISPLAY);

        /*
            if (E3EntryModelPermission.contains(
                    themeDisplay.getPermissionChecker(), entry,
                    ActionKeys.DELETE)) {

                return Collections.singletonList("deleteEntries");
            }
*/
        return Collections.singletonList("deleteEntries");
//        return Collections.emptyList();
    }

    public String getDisplayStyle() {
        String displayStyle = ParamUtil.getString(
                _httpServletRequest, "displayStyle");

        if (Validator.isNull(displayStyle)) {
            return _portalPreferences.getValue(
                    E3PortletKeys.E3AdminPortlet, "entries-display-style", "icon");
        }

        _portalPreferences.setValue(
                E3PortletKeys.E3AdminPortlet, "entries-display-style",
                displayStyle);

        _httpServletRequest.setAttribute(
                WebKeys.SINGLE_PAGE_APPLICATION_CLEAR_CACHE, Boolean.TRUE);

        return displayStyle;
    }

    public SearchContainer<E3Entry> getSearchContainer()
            throws PortalException, PortletException {

        PortletURL portletURL = PortletURLBuilder.createRenderURL(
                _liferayPortletResponse
        ).setMVCRenderCommandName(
                E3RenderCommand.VIEW_COMMAND
        ).setParameter(
                "entriesNavigation",
                ParamUtil.getString(_httpServletRequest, "entriesNavigation")
        ).build();

        SearchContainer<E3Entry> entriesSearchContainer =
                new SearchContainer<>(
                        _liferayPortletRequest,
                        PortletURLUtil.clone(portletURL, _liferayPortletResponse), null,
                        "no-entries-were-found");

        String orderByCol = ParamUtil.getString(
                _httpServletRequest, "orderByCol", "entryName");

        entriesSearchContainer.setOrderByCol(orderByCol);

        String orderByType = ParamUtil.getString(
                _httpServletRequest, "orderByType", "asc");

        entriesSearchContainer.setOrderByType(orderByType);

        entriesSearchContainer.setOrderByComparator(
                E3EntryUtil.getOrderByComparator(
                        entriesSearchContainer.getOrderByCol(),
                        entriesSearchContainer.getOrderByType()));

        entriesSearchContainer.setRowChecker(
                new EmptyOnClickRowChecker(_liferayPortletResponse));

        _populateResults(entriesSearchContainer);

        return entriesSearchContainer;
    }

    public Map<String, Object> getComponentContext() throws PortalException {
        return HashMapBuilder.<String, Object>put(
                "trashEnabled", false
/*                () -> {
                    ThemeDisplay themeDisplay =
                            (ThemeDisplay)_httpServletRequest.getAttribute(
                                    WebKeys.THEME_DISPLAY);

                    return _trashHelper.isTrashEnabled(
                            themeDisplay.getScopeGroupId());
                }
 */
        ).build();
    }

    private void _populateResults(SearchContainer<E3Entry> searchContainer)
            throws PortalException {

        ThemeDisplay themeDisplay =
                (ThemeDisplay) _httpServletRequest.getAttribute(
                        WebKeys.THEME_DISPLAY);

        List<E3Entry> entriesResults = null;

        long assetCategoryId = ParamUtil.getLong(
                _httpServletRequest, "categoryId");
        String assetTagName = ParamUtil.getString(_httpServletRequest, "tag");

        String keywords = ParamUtil.getString(_httpServletRequest, "keywords");

        if ((assetCategoryId != 0) || Validator.isNotNull(assetTagName)) {
            SearchContainerResults<AssetEntry> searchContainerResults =
                    E3EntryUtil.getSearchContainerResults(searchContainer);

            searchContainer.setTotal(searchContainerResults.getTotal());

            List<AssetEntry> assetEntries = searchContainerResults.getResults();

            entriesResults = new ArrayList<>(assetEntries.size());

            for (AssetEntry assetEntry : assetEntries) {
                entriesResults.add(
                        E3EntryLocalServiceUtil.getEntry(
                                assetEntry.getClassPK()));
            }
        } else if (Validator.isNull(keywords)) {
            String entriesNavigation = ParamUtil.getString(
                    _httpServletRequest, "entriesNavigation");

            //@todo extend with wf & group
            searchContainer.setTotal(
                    E3EntryLocalServiceUtil.getE3EntriesCount()
            );


            /*
            if (entriesNavigation.equals("mine")) {
                searchContainer.setTotal(
                        BlogsEntryServiceUtil.getGroupUserEntriesCount(
                                themeDisplay.getScopeGroupId(),
                                themeDisplay.getUserId(),
                                WorkflowConstants.STATUS_ANY));
            } else {
                searchContainer.setTotal(
                        BlogsEntryServiceUtil.getGroupEntriesCount(
                                themeDisplay.getScopeGroupId(),
                                // @todo apply e3workflow?
                                WorkflowConstants.STATUS_ANY));
            }
             */

            //@todo extend with wf & group
            entriesResults = E3EntryLocalServiceUtil.getE3Entries(
                    searchContainer.getStart(),
                    searchContainer.getEnd());

            /*
            if (entriesNavigation.equals("mine")) {
                entriesResults = BlogsEntryServiceUtil.getGroupUserEntries(
                        themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),
                        WorkflowConstants.STATUS_ANY, searchContainer.getStart(),
                        searchContainer.getEnd(),
                        searchContainer.getOrderByComparator());
            } else {
                entriesResults = BlogsEntryServiceUtil.getGroupEntries(
                        themeDisplay.getScopeGroupId(),
                        WorkflowConstants.STATUS_ANY, searchContainer.getStart(),
                        searchContainer.getEnd(),
                        searchContainer.getOrderByComparator());
            }
            */
        } else {
            Indexer<E3Entry> indexer = IndexerRegistryUtil.getIndexer(
                    E3Entry.class);

            SearchContext searchContext = SearchContextFactory.getInstance(
                    _httpServletRequest);

            searchContext.setAttribute(
                    Field.STATUS, WorkflowConstants.STATUS_ANY);
            searchContext.setEnd(searchContainer.getEnd());
            searchContext.setIncludeDiscussions(true);
            searchContext.setIncludeInternalAssetCategories(true);
            searchContext.setKeywords(keywords);
            searchContext.setStart(searchContainer.getStart());

            String entriesNavigation = ParamUtil.getString(
                    _httpServletRequest, "entriesNavigation");

            if (entriesNavigation.equals("mine")) {
                searchContext.setOwnerUserId(themeDisplay.getUserId());
            }

            String orderByCol = ParamUtil.getString(
                    _httpServletRequest, "orderByCol", "name");
            String orderByType = ParamUtil.getString(
                    _httpServletRequest, "orderByType", "asc");

            Sort sort = null;

            boolean orderByAsc = false;

            if (Objects.equals(orderByType, "asc")) {
                orderByAsc = true;
            }

            if (Objects.equals(orderByCol, "modified-date")) {
                sort = new Sort(
                        Field.MODIFIED_DATE, Sort.LONG_TYPE, !orderByAsc);
            } else {
                sort = new Sort(orderByCol, !orderByAsc);
            }

            searchContext.setSorts(sort);

            Hits hits = indexer.search(searchContext);

            searchContainer.setTotal(hits.getLength());

            List<SearchResult> searchResults =
                    SearchResultUtil.getSearchResults(
                            hits, LocaleUtil.getDefault());

            Stream<SearchResult> stream = searchResults.stream();

            entriesResults = stream.map(
                    this::_toEntryOptional
            ).filter(
                    Optional::isPresent
            ).map(
                    Optional::get
            ).collect(
                    Collectors.toList()
            );
        }

        searchContainer.setResults(entriesResults);
    }

    private Optional<E3Entry> _toEntryOptional(
            SearchResult searchResult) {

        try {
            return Optional.of(
                    E3EntryLocalServiceUtil.getEntry(searchResult.getClassPK()));
        } catch (Exception exception) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                        "E3Entry search index is stale and contains entry " +
                                searchResult.getClassPK(),
                        exception);
            }

            return Optional.empty();
        }
    }

    private final E3AppLocalService _appLocalService;
    private final HttpServletRequest _httpServletRequest;
    private final LiferayPortletRequest _liferayPortletRequest;
    private final LiferayPortletResponse _liferayPortletResponse;
    private final PortalPreferences _portalPreferences;
}
