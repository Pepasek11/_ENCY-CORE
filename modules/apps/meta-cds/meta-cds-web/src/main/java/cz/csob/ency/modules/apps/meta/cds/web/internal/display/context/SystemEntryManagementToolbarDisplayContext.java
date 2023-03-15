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

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItem;
import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.trash.TrashHelper;
import cz.csob.ency.modules.apps.meta.cds.web.internal.security.permission.resource.SystemEntryPermission;
import cz.csob.ency.modules.apps.meta.cds.web.util.SystemEntryViewHelper;

import javax.portlet.ActionRequest;
import javax.portlet.PortletURL;
import javax.portlet.ResourceURL;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * SystemEntry Management Toolbar Display Context
 *
 * @author Miroslav Čermák
 */
public class SystemEntryManagementToolbarDisplayContext
        extends SearchContainerManagementToolbarDisplayContext {

    public SystemEntryManagementToolbarDisplayContext(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            HttpServletRequest httpServletRequest,
            SearchContainer<?> searchContainer, TrashHelper trashHelper,
            String displayStyle) {

        super(
                liferayPortletRequest, liferayPortletResponse, httpServletRequest,
                searchContainer);

        _trashHelper = trashHelper;
        _displayStyle = displayStyle;

        _themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
    }

    /**
     * Order Dropdown items
     *
     * @return
     */
    public List<DropdownItem> _getOrderByDropdownItems() {
        return new DropdownItemList() {
            {
//  //
                add(
                        dropdownItem -> {
                            dropdownItem.setActive(
                                    Objects.equals(getOrderByCol(), "systemCode"));
                            dropdownItem.setHref(
                                    _getCurrentSortingURL(), "orderByCol", "systemCode");
                            dropdownItem.setLabel(
                                    LanguageUtil.get(request, "systemcode"));
                        });
                add(
                        dropdownItem -> {
                            dropdownItem.setActive(
                                    Objects.equals(getOrderByCol(), "systemName"));
                            dropdownItem.setHref(
                                    _getCurrentSortingURL(), "orderByCol", "systemName");
                            dropdownItem.setLabel(
                                    LanguageUtil.get(request, "systemname"));
                        });
                add(
                        dropdownItem -> {
                            dropdownItem.setActive(
                                    Objects.equals(getOrderByCol(), "systemTitle"));
                            dropdownItem.setHref(
                                    _getCurrentSortingURL(), "orderByCol", "systemTitle");
                            dropdownItem.setLabel(
                                    LanguageUtil.get(request, "systemtitle"));
                        });
                add(
                        dropdownItem -> {
                            dropdownItem.setActive(
                                    Objects.equals(getOrderByCol(), "systemType"));
                            dropdownItem.setHref(
                                    _getCurrentSortingURL(), "orderByCol", "systemType");
                            dropdownItem.setLabel(
                                    LanguageUtil.get(request, "systemtype"));
                        });
                add(
                        dropdownItem -> {
                            dropdownItem.setActive(
                                    Objects.equals(getOrderByCol(), "description"));
                            dropdownItem.setHref(
                                    _getCurrentSortingURL(), "orderByCol", "description");
                            dropdownItem.setLabel(
                                    LanguageUtil.get(request, "description"));
                        });
                add(
                        dropdownItem -> {
                            dropdownItem.setActive(
                                    Objects.equals(getOrderByCol(), "stewardName"));
                            dropdownItem.setHref(
                                    _getCurrentSortingURL(), "orderByCol", "stewardName");
                            dropdownItem.setLabel(
                                    LanguageUtil.get(request, "stewardname"));
                        });
                add(
                        dropdownItem -> {
                            dropdownItem.setActive(
                                    Objects.equals(getOrderByCol(), "sandboxName"));
                            dropdownItem.setHref(
                                    _getCurrentSortingURL(), "orderByCol", "sandboxName");
                            dropdownItem.setLabel(
                                    LanguageUtil.get(request, "sandboxname"));
                        });
                add(
                        dropdownItem -> {
                            dropdownItem.setActive(
                                    Objects.equals(getOrderByCol(), "role"));
                            dropdownItem.setHref(
                                    _getCurrentSortingURL(), "orderByCol", "role");
                            dropdownItem.setLabel(
                                    LanguageUtil.get(request, "role"));
                        });
                add(
                        dropdownItem -> {
                            dropdownItem.setActive(
                                    Objects.equals(getOrderByCol(), "snowAssetTagName"));
                            dropdownItem.setHref(
                                    _getCurrentSortingURL(), "orderByCol", "snowAssetTagName");
                            dropdownItem.setLabel(
                                    LanguageUtil.get(request, "snowassettagname"));
                        });
                add(
                        dropdownItem -> {
                            dropdownItem.setActive(
                                    Objects.equals(getOrderByCol(), "isSlaSigned"));
                            dropdownItem.setHref(
                                    _getCurrentSortingURL(), "orderByCol", "isSlaSigned");
                            dropdownItem.setLabel(
                                    LanguageUtil.get(request, "isalasigned"));
                        });
                add(
                        dropdownItem -> {
                            dropdownItem.setActive(
                                    Objects.equals(getOrderByCol(), "isSelfBi"));
                            dropdownItem.setHref(
                                    _getCurrentSortingURL(), "orderByCol", "isSelfBi");
                            dropdownItem.setLabel(
                                    LanguageUtil.get(request, "isselfbi"));
                        });
                add(
                        dropdownItem -> {
                            dropdownItem.setActive(
                                    Objects.equals(getOrderByCol(), "isActive"));
                            dropdownItem.setHref(
                                    _getCurrentSortingURL(), "orderByCol", "isActive");
                            dropdownItem.setLabel(
                                    LanguageUtil.get(request, "isactive"));
                        });
            }
        };
    }

    /**
     * Action Items
     */
    @Override
    public List<DropdownItem> getActionDropdownItems() {
        return new DropdownItemList() {
            {

                // Delete action
                add(
                        dropdownItem -> {
                            dropdownItem.putData("action", "deleteEntries");
                            dropdownItem.setHref(
                                    "javascript:" +
                                            liferayPortletResponse.getNamespace() +
                                            "deleteEntries();");

                            boolean trashEnabled = _trashHelper.isTrashEnabled(
                                    _themeDisplay.getScopeGroupId());

                            dropdownItem.setIcon(
                                    trashEnabled ? "trash" : "times-circle");

                            String label = "delete";

                            if (trashEnabled) {
                                label = "move-to-recycle-bin";
                            }

                            dropdownItem.setLabel(LanguageUtil.get(request, label));

                            dropdownItem.setQuickAction(true);
                        });
            }
        };
    }

    @Override
    public String getClearResultsURL() {
        return getSearchActionURL();
    }

    public Map<String, Object> getComponentContext() throws PortalException {
        Map<String, Object> context = new HashMap<>();

        String cmd = Constants.DELETE;

        if (_trashHelper.isTrashEnabled(_themeDisplay.getScopeGroup())) {
            cmd = Constants.MOVE_TO_TRASH;
        }

        context.put(Constants.CMD, cmd);

        PortletURL deleteEntriesURL = liferayPortletResponse.createActionURL();

        deleteEntriesURL.setParameter(
                ActionRequest.ACTION_NAME, "/systementry/crud");

        context.put("deleteEntryIds", deleteEntriesURL.toString());

        context.put(
                "trashEnabled",
                _trashHelper.isTrashEnabled(_themeDisplay.getScopeGroupId()));

        return context;
    }

    @Override
    public CreationMenu getCreationMenu() {
        if (!SystemEntryPermission.contains(
                _themeDisplay.getPermissionChecker(),
                _themeDisplay.getScopeGroupId(), ActionKeys.ADD_ENTRY)) {

            return null;
        }

        return new CreationMenu() {
            {
                addDropdownItem(
                        dropdownItem -> {
                            dropdownItem.setHref(
                                    liferayPortletResponse.createRenderURL(),
                                    Constants.CMD, Constants.ADD,
                                    "mvcRenderCommandName", "/systementry/crud",
                                    "redirect", currentURLObj.toString());
                            dropdownItem.setLabel(
                                    LanguageUtil.get(request, "add-systementry"));
                        });
                addDropdownItem(
                        dropdownItem -> {
                            dropdownItem.setHref(
                                    liferayPortletResponse.createActionURL(),
                                    Constants.CMD, Constants.IMPORT,
                                    "javax.portlet.action", "/systementry/crud",
                                    "redirect", currentURLObj.toString());
                            dropdownItem.setLabel(
                                    LanguageUtil.get(request, "import-systems"));
                        });
            }
        };
    }

    /**
     * Returns the filter menu options.
     *
     * @return menu options list
     */
    @Override
    public List<DropdownItem> getFilterDropdownItems() {
        return new DropdownItemList() {
            {
                addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    _getOrderByDropdownItems());
                            dropdownGroupItem.setLabel(
                                    LanguageUtil.get(request, "order-by"));
                        });
            }
        };
    }

    public String getOrderByType() {
        return searchContainer.getOrderByType();
    }

    @Override
    public String getSearchActionURL() {
        PortletURL searchURL = liferayPortletResponse.createRenderURL();

        searchURL.setParameter("mvcRenderCommandName", "/systementry/view");

        String navigation = ParamUtil.getString(
                request, "navigation", "entries");

        searchURL.setParameter("navigation", navigation);

        searchURL.setParameter("orderByCol", getOrderByCol());
        searchURL.setParameter("orderByType", getOrderByType());

        return searchURL.toString();
    }

    @Override
    public String getSortingURL() {
        PortletURL sortingURL = _getCurrentSortingURL();

        sortingURL.setParameter(
                "orderByType",
                Objects.equals(getOrderByType(), "asc") ? "desc" : "asc");

        return sortingURL.toString();
    }

    @Override
    public List<ViewTypeItem> getViewTypeItems() {
        return null;

        // TODO : Configure if you need to switch view type

        //		return new ViewTypeItemList(getPortletURL(), getDisplayStyle()) {

        //			{
        //				if (ArrayUtil.contains(getDisplayViews(), "icon")) {
        //					addCardViewTypeItem();
        //				}
        //
        //				if (ArrayUtil.contains(getDisplayViews(), "descriptive")) {
        //					addListViewTypeItem();
        //				}
        //
        //				if (ArrayUtil.contains(getDisplayViews(), "list")) {
        //					addTableViewTypeItem();
        //				}
        //			}
        //		};

    }

    /**
     * Search Sort URL
     *
     * @return Search filter URL string
     */
    private PortletURL _getCurrentSortingURL() {
        String keywords = ParamUtil.getString(request, DisplayTerms.KEYWORDS);
        int cur = ParamUtil.getInteger(
                request, SearchContainer.DEFAULT_CUR_PARAM);
        int delta = ParamUtil.getInteger(
                request, SearchContainer.DEFAULT_DELTA_PARAM);
        String orderByCol = ParamUtil.getString(
                request, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM, "systemEntryId");
        String orderByType = ParamUtil.getString(
                request, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM, "asc");

        PortletURL navigationPortletURL =
                liferayPortletResponse.createRenderURL();

        navigationPortletURL.setParameter(
                SearchContainer.DEFAULT_CUR_PARAM, String.valueOf(cur));
        navigationPortletURL.setParameter(
                "mvcRenderCommandName", "/systementry/view");
        navigationPortletURL.setParameter(
                SearchContainer.DEFAULT_ORDER_BY_COL_PARAM, orderByCol);
        navigationPortletURL.setParameter(
                SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM, orderByType);

        Map<String, String> advSearchKeywords = SystemEntryViewHelper.getAdvSearchKeywords(liferayPortletRequest);

        for (String key : advSearchKeywords.keySet()) {
            navigationPortletURL.setParameter(key, advSearchKeywords.get(key));
        }

        if (advSearchKeywords.isEmpty()) {

            if (Validator.isNotNull(keywords)) {
                navigationPortletURL.setParameter(DisplayTerms.KEYWORDS, keywords);
            }

        }

        return navigationPortletURL;
    }

    private final String _displayStyle;
    private final ThemeDisplay _themeDisplay;
    private final TrashHelper _trashHelper;

}