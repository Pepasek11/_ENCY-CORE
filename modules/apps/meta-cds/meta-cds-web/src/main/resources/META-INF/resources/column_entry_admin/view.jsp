<%@ include file="/init.jsp" %>

<%
String iconChecked = "checked";
String iconUnchecked = "unchecked";
SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatVal);
SimpleDateFormat dateTimeFormat = new SimpleDateFormat(datetimeFormatVal);

TableEntryLocalService tableEntryLocalService = (TableEntryLocalService) request
.getAttribute(ColumnEntryWebKeys.TABLEENTRY_LOCAL_SERVICE);

ColumnEntryDisplayContext columnEntryDisplayContext = (ColumnEntryDisplayContext)request.getAttribute(ColumnEntryWebKeys.COLUMNENTRY_DISPLAY_CONTEXT);

String displayStyle = columnEntryDisplayContext.getDisplayStyle();
SearchContainer entriesSearchContainer = columnEntryDisplayContext.getSearchContainer();

PortletURL portletURL = entriesSearchContainer.getIteratorURL();

ColumnEntryManagementToolbarDisplayContext columnEntryManagementToolbarDisplayContext = new ColumnEntryManagementToolbarDisplayContext(liferayPortletRequest, liferayPortletResponse, request, entriesSearchContainer, trashHelper, displayStyle);
%>


<clay:management-toolbar
	actionDropdownItems="<%= columnEntryManagementToolbarDisplayContext.getActionDropdownItems() %>"
	clearResultsURL="<%= columnEntryManagementToolbarDisplayContext.getSearchActionURL() %>"
	componentId="columnEntryManagementToolbar"
	creationMenu="<%= columnEntryManagementToolbarDisplayContext.getCreationMenu() %>"
	disabled="<%= columnEntryManagementToolbarDisplayContext.isDisabled() %>"
	filterDropdownItems="<%= columnEntryManagementToolbarDisplayContext.getFilterDropdownItems() %>"
	itemsTotal="<%= columnEntryManagementToolbarDisplayContext.getItemsTotal() %>"
	searchActionURL="<%= columnEntryManagementToolbarDisplayContext.getSearchActionURL() %>"
	searchContainerId="columnEntry"
	searchFormName="fm"
	showSearch="true"
	sortingOrder="<%= columnEntryManagementToolbarDisplayContext.getOrderByType() %>"
	sortingURL="<%= columnEntryManagementToolbarDisplayContext.getSortingURL() %>"
/>

<portlet:actionURL name="/columnentry/crud" var="restoreTrashEntriesURL">
	<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.RESTORE %>" />
</portlet:actionURL>

<liferay-trash:undo
	portletURL="<%= restoreTrashEntriesURL %>"
/>

<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form action="<%= portletURL.toString() %>" method="get" name="fm">
		<aui:input name="<%= Constants.CMD %>" type="hidden" />
		<aui:input name="redirect" type="hidden" value="<%= portletURL.toString() %>" />
		<aui:input name="deleteEntryIds" type="hidden" />
		<aui:input name="selectAll" type="hidden" value="<%= false %>" />

		<liferay-ui:search-container
			emptyResultsMessage="no-record-was-found"
			id="columnEntry"
			rowChecker="<%= new EmptyOnClickRowChecker(renderResponse) %>"
			searchContainer="<%= entriesSearchContainer %>"
		>
			<liferay-ui:search-container-row
				className="cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry"
				escapedModel="<%= true %>"
				keyProperty="columnEntryId"
				modelVar="columnEntry"
			>

				<portlet:renderURL var="viewColumnUrl">
					<portlet:param name="mvcRenderCommandName" value="/columnentry/crud"/>
					<portlet:param
							name="<%= Constants.CMD %>"
							value="<%= Constants.VIEW %>"
					/>
					<portlet:param name="backUrl" value="<%= portletURL.toString() %>"/>
					<portlet:param name="resourcePrimKey" value="<%= Long.toString(columnEntry.getPrimaryKey()) %>"/>
				</portlet:renderURL>

				<liferay-ui:search-container-column-text
					align="left"
					name="columntype"
					orderable="true"
					orderableProperty="columnType"
					property="columnType"
				/>

				<liferay-ui:search-container-column-text
					align="left"
					name="columnname"
					orderable="true"
					orderableProperty="columnName"
					property="columnName"
					href="<%=viewColumnUrl%>"
				/>

				<portlet:renderURL var="viewTableUrl">
					<portlet:param name="mvcRenderCommandName" value="/tableentry/crud"/>
					<portlet:param
							name="<%= Constants.CMD %>"
							value="<%= Constants.VIEW %>"
					/>
					<portlet:param name="backUrl" value="<%= portletURL.toString() %>"/>
					<portlet:param name="resourcePrimKey" value="<%= Long.toString(columnEntry.getTableEntryId()) %>"/>
				</portlet:renderURL>

				<liferay-ui:search-container-column-text
					align="left"
					name="tablename"
					orderable="true"
					orderableProperty="tableName"
					property="tableName"
					href="<%=viewTableUrl%>"
				/>

				<liferay-ui:search-container-column-text
					align="left"
					name="systemname"
					orderable="true"
					orderableProperty="systemName"
					property="systemName"
				/>

				<liferay-ui:search-container-column-text
					align="left"
					name="databasename"
					orderable="true"
					orderableProperty="databaseName"
					property="databaseName"
				/>

				<liferay-ui:search-container-column-text
					align="left"
					name="datatype"
					orderable="true"
					orderableProperty="dataType"
					property="dataType"
				/>


				<liferay-ui:search-container-column-text
					align="left"
					name="isprimarykey"
					orderable="true"
					orderableProperty="isPrimaryKey"
					property="isPrimaryKey"
				/>


				<liferay-ui:search-container-column-text
					align="left"
					name="isnotnull"
					orderable="true"
					orderableProperty="isNotNull"
					property="isNotNull"
				/>

				<liferay-ui:search-container-column-text
					align="left"
					name="isactive"
					orderable="true"
					orderableProperty="isActive"
					property="isActive"
				/>

<%--  --%>

				<liferay-ui:search-container-column-jsp
					align="right"
					path="/column_entry_admin/edit_actions.jsp"
				/>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator displayStyle="list" markupView="lexicon" />
		</liferay-ui:search-container>
	</aui:form>
</div>

<aui:script>
	function <portlet:namespace />deleteEntries() {
		if (<%=trashHelper.isTrashEnabled(scopeGroupId) %> || confirm('<%=UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-delete-the-selected-entries") %>')) {
   			var form = document.getElementById('<portlet:namespace />fm');

			form.setAttribute('method', 'post');

			var cmd = form.querySelector('#<portlet:namespace /><%= Constants.CMD %>');

            if (cmd) {
                cmd.setAttribute('value', '<%= trashHelper.isTrashEnabled(scopeGroupId) ? Constants.DELETE : Constants.DELETE %>');
            }

            var deleteEntryIds = form.querySelector('#<portlet:namespace />deleteEntryIds');

            if (deleteEntryIds) {
                deleteEntryIds.setAttribute('value', Liferay.Util.listCheckedExcept(form, '<portlet:namespace />allRowIds'));
            }
			submitForm(form, '<portlet:actionURL name="/columnentry/crud" />');
		}
	}
</aui:script>