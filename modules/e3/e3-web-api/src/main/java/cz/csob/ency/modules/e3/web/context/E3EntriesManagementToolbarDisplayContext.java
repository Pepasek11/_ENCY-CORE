package cz.csob.ency.modules.e3.web.context;


import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.*;
import com.liferay.petra.portlet.url.builder.PortletURLBuilder;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import com.liferay.trash.TrashHelper;
import cz.csob.ency.modules.e3.entry.internal.security.permission.resource.E3PortletPermission;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.web.portlet.base.actions.constants.E3RenderCommand;
import cz.csob.ency.modules.e3.web.util.E3EntryUtil;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class E3EntriesManagementToolbarDisplayContext
        extends SearchContainerManagementToolbarDisplayContext {

    public E3EntriesManagementToolbarDisplayContext(
            HttpServletRequest httpServletRequest,
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            SearchContainer<E3Entry> searchContainer, TrashHelper trashHelper,
            String displayStyle) {

        super(
                httpServletRequest, liferayPortletRequest, liferayPortletResponse,
                searchContainer);

        _httpServletRequest = httpServletRequest;
        _trashHelper = trashHelper;
        _displayStyle = displayStyle;

        _themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
    }


    @Override
    public List<DropdownItem> getActionDropdownItems() {
        return DropdownItemListBuilder.add(
                dropdownItem -> {
                    dropdownItem.putData("action", "deleteEntries");

                    boolean trashEnabled = Validator.isNotNull(_trashHelper) && _trashHelper.isTrashEnabled(
                            _themeDisplay.getScopeGroupId());

                    dropdownItem.setIcon(trashEnabled ? "trash" : "times-circle");

                    String label = "delete";

                    if (trashEnabled) {
                        label = "move-to-recycle-bin";
                    }

                    dropdownItem.setLabel(
                            LanguageUtil.get(httpServletRequest, label));

                    dropdownItem.setQuickAction(true);
                }
        ).build();
    }

    public Map<String, Object> getAdditionalProps() {
        return HashMapBuilder.<String, Object>put(
                "deleteEntriesCmd",
                () -> {
                    if (_isTrashEnabled()) {
                        return Constants.MOVE_TO_TRASH;
                    }

                    return Constants.DELETE;
                }
        ).put(
                "deleteEntriesURL",
                () -> PortletURLBuilder.createActionURL(
                        liferayPortletResponse
                ).setActionName(
                        E3RenderCommand.EDIT_ENTRY_COMMAND
                ).buildString()
        ).put(
                "trashEnabled", _isTrashEnabled()
        ).build();
    }

    @Override
    public String getClearResultsURL() {
        return getSearchActionURL();
    }

    @Override
    public CreationMenu getCreationMenu() {
        if (!E3PortletPermission.contains(
                _themeDisplay.getPermissionChecker(),
                _themeDisplay.getScopeGroupId(), ActionKeys.ADD_ENTRY)) {

            return null;
        }

        return CreationMenuBuilder.addDropdownItem(
                dropdownItem -> {
                    dropdownItem.setHref(
                            liferayPortletResponse.createRenderURL(),
                            "mvcRenderCommandName", E3RenderCommand.EDIT_ENTRY_COMMAND, "redirect",
                            currentURLObj.toString(), "appClass","foo.bar.FooBarApp");
                    dropdownItem.setLabel(
                            LanguageUtil.get(httpServletRequest, "add-entry"));
                }
        ).build();
    }

    @Override
    public List<LabelItem> getFilterLabelItems() {
        if (!Objects.equals(getNavigation(), "mine")) {
            return null;
        }

        return null;
/*        return LabelItemListBuilder.add(
                labelItem -> {
                    labelItem.putData(
                            "removeLabelURL",
                            PortletURLBuilder.create(
                                    getPortletURL()
                            ).setParameter(
                                    "entriesNavigation", (String) null
                            ).buildString());

                    labelItem.setCloseable(true);

                    User user = _themeDisplay.getUser();

                    String label = String.format(
                            "%s: %s", LanguageUtil.get(httpServletRequest, "owner"),
                            user.getFullName());

                    labelItem.setLabel(label);
                }
        ).build();

 */
    }

    @Override
    public String getSearchActionURL() {
        String navigation = ParamUtil.getString(
                httpServletRequest, "navigation", "entries");

        return PortletURLBuilder.createRenderURL(
                liferayPortletResponse
        ).setMVCRenderCommandName(
                E3RenderCommand.VIEW_COMMAND
        ).setNavigation(
                navigation
        ).setParameter(
                "orderByCol", getOrderByCol()
        ).setParameter(
                "orderByType", getOrderByType()
        ).buildString();
    }

    @Override
    public List<ViewTypeItem> getViewTypeItems() {
        PortletURL portletURL = PortletURLBuilder.createRenderURL(
                liferayPortletResponse
        ).setMVCRenderCommandName(
                E3RenderCommand.VIEW_COMMAND
        ).build();

        if (searchContainer.getDelta() > 0) {
            portletURL.setParameter(
                    "delta", String.valueOf(searchContainer.getDelta()));
        }

        portletURL.setParameter("orderBycol", searchContainer.getOrderByCol());
        portletURL.setParameter(
                "orderByType", searchContainer.getOrderByType());

        portletURL.setParameter("entriesNavigation", getNavigation());

        if (searchContainer.getCur() > 0) {
            portletURL.setParameter(
                    "cur", String.valueOf(searchContainer.getCur()));
        }

        return new ViewTypeItemList(portletURL, _displayStyle) {
            {
                //   addCardViewTypeItem();

                //   addListViewTypeItem();

                addTableViewTypeItem();
            }
        };
    }

    @Override
    protected String[] getNavigationKeys() {
        return new String[]{"all"/*, "mine"*/};
    }

    @Override
    protected String getNavigationParam() {
        return "entriesNavigation";
    }

    @Override
    protected List<DropdownItem> getOrderByDropdownItems() {
        return DropdownItemListBuilder.add(
                dropdownItem -> {
                    dropdownItem.setActive(
                            Objects.equals(getOrderByCol(), "entryName"));
                    dropdownItem.setHref(
                            _getCurrentSortingURL(), "orderByCol", "entryName");
                    dropdownItem.setLabel(
                            LanguageUtil.get(httpServletRequest, "name"));
                }
        )
                /*.add(
                dropdownItem -> {
                    dropdownItem.setActive(
                            Objects.equals(getOrderByCol(), "display-date"));
                    dropdownItem.setHref(
                            _getCurrentSortingURL(), "orderByCol", "display-date");
                    dropdownItem.setLabel(
                            LanguageUtil.get(httpServletRequest, "display-date"));
                }
        )*/.build();
    }

    private PortletURL _getCurrentSortingURL() {
        PortletURL sortingURL = PortletURLBuilder.create(
                getPortletURL()
        ).setMVCRenderCommandName(
                E3RenderCommand.VIEW_COMMAND
        ).setParameter(
                SearchContainer.DEFAULT_CUR_PARAM, "0"
        ).build();

        String keywords = ParamUtil.getString(httpServletRequest, "keywords");

        if (Validator.isNotNull(keywords)) {
            sortingURL.setParameter("keywords", keywords);
        }

        return sortingURL;
    }

    private boolean _isTrashEnabled() {
        try {
            return Validator.isNotNull(_trashHelper) && _trashHelper.isTrashEnabled(
                    PortalUtil.getScopeGroupId(_httpServletRequest));
        } catch (PortalException portalException) {
            return ReflectionUtil.throwException(portalException);
        }
    }

    private final String _displayStyle;
    private final HttpServletRequest _httpServletRequest;
    private final ThemeDisplay _themeDisplay;
    private final TrashHelper _trashHelper;
}
