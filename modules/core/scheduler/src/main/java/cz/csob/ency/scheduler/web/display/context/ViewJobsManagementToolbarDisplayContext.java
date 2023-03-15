package cz.csob.ency.scheduler.web.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.BaseManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenuBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.ParamUtil;
import cz.csob.ency.scheduler.constants.SchedulerConstants;

import javax.portlet.ActionRequest;
import javax.portlet.ActionURL;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ViewJobsManagementToolbarDisplayContext
    extends BaseManagementToolbarDisplayContext {

    private final String DEFAULY_DISPLAY_STYLE = "list";

    public ViewJobsManagementToolbarDisplayContext(HttpServletRequest httpServletRequest,
                                                   LiferayPortletRequest liferayPortletRequest,
                                                   LiferayPortletResponse liferayPortletResponse) {
        super(httpServletRequest, liferayPortletRequest, liferayPortletResponse);
    }

    @Override
    public List<DropdownItem> getFilterDropdownItems() {
        return DropdownItemListBuilder.addGroup(
            dropdownGroupItem -> {
                dropdownGroupItem.setDropdownItems(
                    _getFilterNavigatioDropdownItems());
                dropdownGroupItem.setLabel(
                    LanguageUtil.get(request, "filter"));
                dropdownGroupItem.setSeparator(true);
            }
        ).addGroup(
            dropdownGroupItem -> {
                dropdownGroupItem.setDropdownItems(_getOrderByDropDownItems());
                dropdownGroupItem.setLabel(
                    LanguageUtil.get(request, "order-by"));
            }
        ).build();
    }

    public String getSortingOrder() {
        return ParamUtil.getString(request, "orderByType", "asc");
    }

    public String getSortingURL() {
        PortletURL sortingURL = getRenderURL();

        sortingURL.setParameter(
            "groupId",
            String.valueOf(ParamUtil.getLong(request, "groupId")));
        sortingURL.setParameter(
            "privateLayout",
            String.valueOf(
                ParamUtil.getBoolean(request, "privateLayout")));
        sortingURL.setParameter(
            "displayStyle",
            ParamUtil.getString(
                request, "displayStyle", "descriptive"));
        sortingURL.setParameter(
            "orderByCol",
            ParamUtil.getString(request, "orderByCol"));

        String orderByType = ParamUtil.getString(
            request, "orderByType");

        if (orderByType.equals("asc")) {
            sortingURL.setParameter("orderByType", "desc");
        } else {
            sortingURL.setParameter("orderByType", "asc");
        }

        sortingURL.setParameter(
            "navigation",
            ParamUtil.getString(request, "navigation", "all"));
        sortingURL.setParameter(
            "searchContainerId",
            ParamUtil.getString(request, "searchContainerId"));

        return sortingURL.toString();
    }

    @Override
    protected String[] getNavigationKeys() {
        return new String[]{"all", "persistent"};
    }

    @Override
    protected String[] getOrderByKeys() {
        return new String[]{"jobName", "groupName", "triggerState", "storageType"};
    }

    @Override
    public CreationMenu getCreationMenu() {
        return CreationMenuBuilder
            .addPrimaryDropdownItem(
                dropdownItem -> {
                    dropdownItem.setHref(
                        getRenderURL(),
                        "mvcPath", "/edit.jsp" ,
                        "backURL", getRenderURL().toString()
                    );
                    dropdownItem.setLabel(LanguageUtil.get(request, "schedule-job"));
                }
            ).addPrimaryDropdownItem(
                dropdownItem -> {
                    dropdownItem.setHref(
                        getActionURL("jobAction"),
                        SchedulerConstants.PARAMETER_JOB_ACTION, "test"

                    );
                    dropdownItem.setLabel(LanguageUtil.get(request, "test-action"));
                }
            ).build();
    }

    public String getSearchContainerId() {
        return ParamUtil.getString(request, "searchContainerId");
    }

    @Override
    public Boolean isShowSearch() {
        return false;
    }

    protected PortletURL getRenderURL() {
        return liferayPortletResponse.createRenderURL();
    }

    protected PortletURL getActionURL(String name) {
        ActionURL url = liferayPortletResponse.createActionURL();
        url.setParameter(ActionRequest.ACTION_NAME, name);
        return url;
    }



    private List<DropdownItem> _getFilterNavigatioDropdownItems() {
        return DropdownItemListBuilder.add(
            dropdownItem -> {
                dropdownItem.setHref(
                    getRenderURL(),
                    "groupId", String.valueOf(ParamUtil.getLong(request, "groupId")),
                    "displayStyle", ParamUtil.getString(request, "displayStyle", DEFAULY_DISPLAY_STYLE),
                    "orderByCol", ParamUtil.getString(request, "orderByCol"),
                    "orderByType", ParamUtil.getString(request, "orderByType"),
                    "navigation", "all",
                    "searchContainerId", ParamUtil.getString(request, "searchContainerId")
                );
                dropdownItem.setLabel(LanguageUtil.get(request, "all"));
            }
        ).add(
            dropdownItem -> {
                dropdownItem.setHref(
                    getRenderURL(),
                    "groupId", String.valueOf(ParamUtil.getLong(request, "groupId")),
                    "displayStyle", ParamUtil.getString(request, "displayStyle", DEFAULY_DISPLAY_STYLE),
                    "orderByCol", ParamUtil.getString(request, "orderByCol"),
                    "orderByType", ParamUtil.getString(request, "orderByType"),
                    "navigation", "PERSISTENT",
                    "searchContainerId", ParamUtil.getString(request, "searchContainerId")
                );
                dropdownItem.setLabel(LanguageUtil.get(request, "Persistent"));
            }
        ).build();
    }

    private List<DropdownItem> _getOrderByDropDownItems() {
        return DropdownItemListBuilder.add(
            dropdownItem -> {
                dropdownItem.setHref(
                    getRenderURL(),
                    "groupId", String.valueOf(ParamUtil.getLong(request, "groupId")),
                    "displayStyle", ParamUtil.getString(request, "displayStyle", DEFAULY_DISPLAY_STYLE),
                    "delta", ParamUtil.getInteger(request, "delta"),
                    "orderByCol", SchedulerConstants.COLUMN_SHORT_NAME,
                    "orderByType", ParamUtil.getString(request, "orderByType"),
                    "navigation", ParamUtil.getString(request, "navigation", "all"),
                    "searchContainerId", ParamUtil.getString(request, "searchContainerId")
                );
                dropdownItem.setLabel(LanguageUtil.get(request, "job-name"));
            }
        ).add(
            dropdownItem -> {
                dropdownItem.setHref(
                    getRenderURL(),
                    "groupId", String.valueOf(ParamUtil.getLong(request, "groupId")),
                    "displayStyle", ParamUtil.getString(request, "displayStyle", DEFAULY_DISPLAY_STYLE),
                    "delta", ParamUtil.getInteger(request, "delta"),
                    "orderByCol", SchedulerConstants.COLUMN_SHORT_GROUP,
                    "orderByType", ParamUtil.getString(request, "orderByType"),
                    "navigation", ParamUtil.getString(request, "navigation", "all"),
                    "searchContainerId", ParamUtil.getString(request, "searchContainerId")
                );
                dropdownItem.setLabel(LanguageUtil.get(request, "group-name"));
            }
        ).add(
            dropdownItem -> {
                dropdownItem.setHref(
                    getRenderURL(),
                    "groupId", String.valueOf(ParamUtil.getLong(request, "groupId")),
                    "displayStyle", ParamUtil.getString(request, "displayStyle", DEFAULY_DISPLAY_STYLE),
                    "delta", ParamUtil.getInteger(request, "delta"),
                    "orderByCol", SchedulerConstants.COLUMN_STATE,
                    "orderByType", ParamUtil.getString(request, "orderByType"),
                    "navigation", ParamUtil.getString(request, "navigation", "all"),
                    "searchContainerId", ParamUtil.getString(request, "searchContainerId")
                );
                dropdownItem.setLabel(LanguageUtil.get(request, "status"));
            }
        ).add(
            dropdownItem -> {
                dropdownItem.setHref(
                    getRenderURL(),
                    "groupId", String.valueOf(ParamUtil.getLong(request, "groupId")),
                    "displayStyle", ParamUtil.getString(request, "displayStyle", DEFAULY_DISPLAY_STYLE),
                    "delta", ParamUtil.getInteger(request, "delta"),
                    "orderByCol", SchedulerConstants.COLUMN_STORAGE_TYPE,
                    "orderByType", ParamUtil.getString(request, "orderByType"),
                    "navigation", ParamUtil.getString(request, "navigation", "all"),
                    "searchContainerId", ParamUtil.getString(request, "searchContainerId")
                );
                dropdownItem.setLabel(LanguageUtil.get(request, "storage-type"));
            }
        ).add(
            dropdownItem -> {
                dropdownItem.setHref(
                    getRenderURL(),
                    "groupId", String.valueOf(ParamUtil.getLong(request, "groupId")),
                    "displayStyle", ParamUtil.getString(request, "displayStyle", DEFAULY_DISPLAY_STYLE),
                    "delta", ParamUtil.getInteger(request, "delta"),
                    "orderByCol", SchedulerConstants.COLUMN_START_TIME,
                    "orderByType", ParamUtil.getString(request, "orderByType"),
                    "navigation", ParamUtil.getString(request, "navigation", "all"),
                    "searchContainerId", ParamUtil.getString(request, "searchContainerId")
                );
                dropdownItem.setLabel(LanguageUtil.get(request, "start-time"));
            }
        ).add(
            dropdownItem -> {
                dropdownItem.setHref(
                    getRenderURL(),
                    "groupId", String.valueOf(ParamUtil.getLong(request, "groupId")),
                    "delta", ParamUtil.getInteger(request, "delta"),
                    "displayStyle", ParamUtil.getString(request, "displayStyle", DEFAULY_DISPLAY_STYLE),
                    "orderByCol", SchedulerConstants.COLUMN_PREVIOUS_FIRE_TIME,
                    "orderByType", ParamUtil.getString(request, "orderByType"),
                    "navigation", ParamUtil.getString(request, "navigation", "all"),
                    "searchContainerId", ParamUtil.getString(request, "searchContainerId")
                );
                dropdownItem.setLabel(LanguageUtil.get(request, "last-run"));
            }
        ).add(
            dropdownItem -> {
                dropdownItem.setHref(
                    getRenderURL(),
                    "groupId", String.valueOf(ParamUtil.getLong(request, "groupId")),
                    "displayStyle", ParamUtil.getString(request, "displayStyle", DEFAULY_DISPLAY_STYLE),
                    "delta", ParamUtil.getInteger(request, "delta"),
                    "orderByCol", SchedulerConstants.COLUMN_NEXT_FIRE_TIME,
                    "orderByType", ParamUtil.getString(request, "orderByType"),
                    "navigation", ParamUtil.getString(request, "navigation", "all"),
                    "searchContainerId", ParamUtil.getString(request, "searchContainerId")
                );
                dropdownItem.setLabel(LanguageUtil.get(request, "next-run"));
            }
        ).build();
    }




}
