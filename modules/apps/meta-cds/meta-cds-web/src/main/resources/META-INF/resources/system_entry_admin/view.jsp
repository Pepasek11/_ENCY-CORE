<%@ include file="/init.jsp" %>

<%
    String iconChecked = "checked";
    String iconUnchecked = "unchecked";
    SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatVal);
    SimpleDateFormat dateTimeFormat = new SimpleDateFormat(datetimeFormatVal);


    SystemEntryDisplayContext systemEntryDisplayContext = (SystemEntryDisplayContext) request.getAttribute(SystemEntryWebKeys.SYSTEMENTRY_DISPLAY_CONTEXT);

    String displayStyle = systemEntryDisplayContext.getDisplayStyle();
    SearchContainer entriesSearchContainer = systemEntryDisplayContext.getSearchContainer();

    PortletURL portletURL = entriesSearchContainer.getIteratorURL();

    SystemEntryManagementToolbarDisplayContext systemEntryManagementToolbarDisplayContext = new SystemEntryManagementToolbarDisplayContext(liferayPortletRequest, liferayPortletResponse, request, entriesSearchContainer, trashHelper, displayStyle);
%>

<clay:management-toolbar
        actionDropdownItems="<%= systemEntryManagementToolbarDisplayContext.getActionDropdownItems() %>"
        clearResultsURL="<%= systemEntryManagementToolbarDisplayContext.getSearchActionURL() %>"
        componentId="systemEntryManagementToolbar"
        creationMenu="<%= systemEntryManagementToolbarDisplayContext.getCreationMenu() %>"
        disabled="<%= systemEntryManagementToolbarDisplayContext.isDisabled() %>"
        filterDropdownItems="<%= systemEntryManagementToolbarDisplayContext.getFilterDropdownItems() %>"
        itemsTotal="<%= systemEntryManagementToolbarDisplayContext.getItemsTotal() %>"
        searchActionURL="<%= systemEntryManagementToolbarDisplayContext.getSearchActionURL() %>"
        searchContainerId="systemEntry"
        searchFormName="fm"
        showSearch="true"
        sortingOrder="<%= systemEntryManagementToolbarDisplayContext.getOrderByType() %>"
        sortingURL="<%= systemEntryManagementToolbarDisplayContext.getSortingURL() %>"
/>

<portlet:actionURL name="/systementry/crud" var="restoreTrashEntriesURL">
    <portlet:param name="<%= Constants.CMD %>" value="<%= Constants.RESTORE %>"/>
</portlet:actionURL>

<liferay-trash:undo
        portletURL="<%= restoreTrashEntriesURL %>"
/>

<div class="container-fluid container-fluid-max-xl main-content-body">
    <aui:form action="<%= portletURL.toString() %>" method="get" name="fm">
        <aui:input name="<%= Constants.CMD %>" type="hidden"/>
        <aui:input name="redirect" type="hidden" value="<%= portletURL.toString() %>"/>
        <aui:input name="deleteEntryIds" type="hidden"/>
        <aui:input name="selectAll" type="hidden" value="<%= false %>"/>

        <liferay-ui:search-container
                emptyResultsMessage="no-record-was-found"
                id="systemEntry"
                rowChecker="<%= new EmptyOnClickRowChecker(renderResponse) %>"
                searchContainer="<%= entriesSearchContainer %>"
        >
            <liferay-ui:search-container-row
                    className="cz.csob.ency.modules.apps.meta.cds.model.SystemEntry"
                    escapedModel="<%= true %>"
                    keyProperty="systemEntryId"
                    modelVar="systemEntry"
            >

                <portlet:renderURL var="viewEntryUrl">
                    <portlet:param name="mvcRenderCommandName" value="/systementry/crud"/>
                    <portlet:param
                            name="<%= Constants.CMD %>"
                            value="<%= Constants.VIEW %>"
                    />
                    <portlet:param name="backUrl" value="<%= portletURL.toString() %>"/>
                    <portlet:param name="resourcePrimKey" value="<%= Long.toString(systemEntry.getPrimaryKey()) %>"/>
                </portlet:renderURL>

                <liferay-ui:search-container-column-text
                        align="left"
                        name="systemcode"
                        orderable="true"
                        orderableProperty="systemCode"
                        property="systemCode"
                        href="<%=viewEntryUrl%>"
                />


                <liferay-ui:search-container-column-text
                        align="left"
                        name="systemname"
                        orderable="true"
                        orderableProperty="systemName"
                        property="systemName"
                        href="<%=viewEntryUrl%>"
                />


                <liferay-ui:search-container-column-text
                        align="left"
                        name="systemtitle"
                        orderable="true"
                        orderableProperty="systemTitle"
                        property="systemTitle"
                />


                <liferay-ui:search-container-column-text
                        align="left"
                        name="systemtype"
                        orderable="true"
                        orderableProperty="systemType"
                        property="systemType"
                />


                <liferay-ui:search-container-column-text
                        align="left"
                        name="description"
                        orderable="true"
                        orderableProperty="description"
                        property="description"
                />

                <liferay-ui:search-container-column-text
                        align="left"
                        name="isslasigned"
                        orderable="true"
                        orderableProperty="isSlaSigned"
                        property="isSlaSigned"
                />


                <liferay-ui:search-container-column-text
                        align="left"
                        name="isselfbi"
                        orderable="true"
                        orderableProperty="isSelfBi"
                        property="isSelfBi"
                />
                <liferay-ui:search-container-column-text
                        align="left"
                        name="isactive"
                        orderable="true"
                        orderableProperty="isActive"
                        property="isActive"
                />
                <liferay-ui:search-container-column-jsp
                        align="right"
                        path="/system_entry_admin/edit_actions.jsp"
                />
            </liferay-ui:search-container-row>

            <liferay-ui:search-iterator displayStyle="list" markupView="lexicon"/>
        </liferay-ui:search-container>
    </aui:form>
</div>

<aui:script>
    function <portlet:namespace/>deleteEntries() {
    if (<%=trashHelper.isTrashEnabled(scopeGroupId) %> || confirm('<%=UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-delete-the-selected-entries") %>')) {
    var form = document.getElementById('<portlet:namespace/>fm');

    form.setAttribute('method', 'post');

    var cmd = form.querySelector('#<portlet:namespace/><%= Constants.CMD %>');

    if (cmd) {
    cmd.setAttribute('value', '<%= trashHelper.isTrashEnabled(scopeGroupId) ? Constants.DELETE : Constants.DELETE %>');
    }

    var deleteEntryIds = form.querySelector('#<portlet:namespace/>deleteEntryIds');

    if (deleteEntryIds) {
    deleteEntryIds.setAttribute('value', Liferay.Util.listCheckedExcept(form, '<portlet:namespace/>allRowIds'));
    }
    submitForm(form, '<portlet:actionURL name="/systementry/crud"/>');
    }
    }
</aui:script>