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
package cz.csob.ency.modules.apps.meta.cds.web.internal.display.context;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchContainerResults;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.*;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.trash.TrashHelper;
import cz.csob.ency.modules.apps.meta.cds.constants.MetaCdsPortletKeys;
import cz.csob.ency.modules.apps.meta.cds.model.TableEntry;
import cz.csob.ency.modules.apps.meta.cds.web.internal.security.permission.resource.TableEntryEntryPermission;
import cz.csob.ency.modules.apps.meta.cds.web.util.TableEntryViewHelper;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * TableEntry Display Context
 *
 * @author Miroslav Čermák
 */
public class TableEntryDisplayContext {

    private static final Log _log = LogFactoryUtil.getLog(
            TableEntryDisplayContext.class);

    public TableEntryDisplayContext(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse, TrashHelper trashHelper,
            TableEntryViewHelper tableEntryViewHelper) {

        _liferayPortletRequest = liferayPortletRequest;
        _liferayPortletResponse = liferayPortletResponse;
        _trashHelper = trashHelper;

        _portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(
                liferayPortletRequest);

        _httpServletRequest = _liferayPortletRequest.getHttpServletRequest();
        _tableEntryViewHelper = tableEntryViewHelper;
    }

    public List<String> getAvailableActions(TableEntry entry)
            throws PortalException {

        ThemeDisplay themeDisplay =
                (ThemeDisplay) _httpServletRequest.getAttribute(
                        WebKeys.THEME_DISPLAY);

        if (TableEntryEntryPermission.contains(
                themeDisplay.getPermissionChecker(), entry,
                ActionKeys.DELETE)) {

            return Collections.singletonList("deleteEntries");
        }

        return Collections.emptyList();
    }

    public Map<String, Object> getComponentContext() throws PortalException {
        ThemeDisplay themeDisplay =
                (ThemeDisplay) _httpServletRequest.getAttribute(
                        WebKeys.THEME_DISPLAY);

        return new HashMap<String, Object>() {
            {
                put(
                        "trashEnabled",
                        _trashHelper.isTrashEnabled(
                                themeDisplay.getScopeGroupId()));
            }
        };
    }

    public String getDisplayStyle() {
        String displayStyle = ParamUtil.getString(
                _httpServletRequest, "displayStyle");

        if (Validator.isNull(displayStyle)) {
            return _portalPreferences.getValue(
                    MetaCdsPortletKeys.METACDS_ADMIN, "entries-display-style",
                    "icon");
        }

        _portalPreferences.setValue(
                MetaCdsPortletKeys.METACDS_ADMIN, "entries-display-style",
                displayStyle);

        _httpServletRequest.setAttribute(
                WebKeys.SINGLE_PAGE_APPLICATION_CLEAR_CACHE, Boolean.TRUE);

        return displayStyle;
    }

    public SearchContainer<TableEntry> getSearchContainer()
            throws ParseException, PortalException, PortletException {

        PortletURL navigationPortletURL =
                _liferayPortletResponse.createRenderURL();

        String keywords = ParamUtil.getString(
                _httpServletRequest, DisplayTerms.KEYWORDS);
        int cur = ParamUtil.getInteger(
                _httpServletRequest, SearchContainer.DEFAULT_CUR_PARAM);
        String orderByCol = ParamUtil.getString(
                _httpServletRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM,
                "tableEntryId");
        String orderByType = ParamUtil.getString(
                _httpServletRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM,
                "asc");

        navigationPortletURL.setParameter(DisplayTerms.KEYWORDS, keywords);
        navigationPortletURL.setParameter(
                SearchContainer.DEFAULT_CUR_PARAM, String.valueOf(cur));
        navigationPortletURL.setParameter(
                "mvcRenderCommandName", "/tableentry/view");
        navigationPortletURL.setParameter(
                SearchContainer.DEFAULT_ORDER_BY_COL_PARAM, orderByCol);
        navigationPortletURL.setParameter(
                SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM, orderByType);


        Map<String, String> advSearchKeywords = _tableEntryViewHelper.getAdvSearchKeywords(_liferayPortletRequest);

        for (String key : advSearchKeywords.keySet()) {
            navigationPortletURL.setParameter(key, advSearchKeywords.get(key));
        }

        SearchContainer<TableEntry> _searchContainer = new SearchContainer<>(
                _liferayPortletRequest,
                PortletURLUtil.clone(navigationPortletURL, _liferayPortletResponse),
                null, "no-records-were-found");

        _searchContainer.setId("entryList");
        _searchContainer.setDeltaConfigurable(true);

        _searchContainer.setOrderByCol(orderByCol);
        _searchContainer.setOrderByType(orderByType);

        SearchContainerResults<TableEntry> searchContainerResults = null;

        if (Validator.isNull(keywords) && advSearchKeywords.isEmpty()) {
            searchContainerResults = _tableEntryViewHelper.getListFromDB(
                    _liferayPortletRequest, _searchContainer,
                    new int[]{WorkflowConstants.STATUS_APPROVED});
        } else {
            searchContainerResults = _tableEntryViewHelper.getListFromIndex(
                    _liferayPortletRequest, _searchContainer,
                    WorkflowConstants.STATUS_APPROVED);
        }

        SearchContainerResults<TableEntry> finalSearchContainerResults = searchContainerResults;
        _searchContainer.setResultsAndTotal(()-> finalSearchContainerResults.getResults(),searchContainerResults.getTotal());

        if (!advSearchKeywords.isEmpty()) {
            PortletURL iteratorURL = _searchContainer.getIteratorURL();
            iteratorURL.setParameter(DisplayTerms.KEYWORDS, "");
            _searchContainer.setIteratorURL(iteratorURL);
        }

        return _searchContainer;
    }
    private final HttpServletRequest _httpServletRequest;
    private final LiferayPortletRequest _liferayPortletRequest;
    private final LiferayPortletResponse _liferayPortletResponse;
    private final PortalPreferences _portalPreferences;
    private final TrashHelper _trashHelper;
    private TableEntryViewHelper _tableEntryViewHelper;

}