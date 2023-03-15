<%@ include file="/init.jsp" %>

<%
String iconChecked = "checked";
String iconUnchecked = "unchecked";
SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatVal);
SimpleDateFormat dateTimeFormat = new SimpleDateFormat(datetimeFormatVal);

SystemEntryLocalService systemEntryLocalService = (SystemEntryLocalService) request
.getAttribute(TableEntryWebKeys.SYSTEMENTRY_LOCAL_SERVICE);

TableEntryDisplayContext tableEntryDisplayContext = (TableEntryDisplayContext)request.getAttribute(TableEntryWebKeys.TABLEENTRY_DISPLAY_CONTEXT);

String displayStyle = tableEntryDisplayContext.getDisplayStyle();
SearchContainer entriesSearchContainer = tableEntryDisplayContext.getSearchContainer();

PortletURL portletURL = entriesSearchContainer.getIteratorURL();

TableEntryManagementToolbarDisplayContext tableEntryManagementToolbarDisplayContext = new TableEntryManagementToolbarDisplayContext(liferayPortletRequest, liferayPortletResponse, request, entriesSearchContainer, trashHelper, displayStyle);
%>

<clay:management-toolbar
	actionDropdownItems="<%= tableEntryManagementToolbarDisplayContext.getActionDropdownItems() %>"
	clearResultsURL="<%= tableEntryManagementToolbarDisplayContext.getSearchActionURL() %>"
	componentId="tableEntryManagementToolbar"
	creationMenu="<%= tableEntryManagementToolbarDisplayContext.getCreationMenu() %>"
	disabled="<%= tableEntryManagementToolbarDisplayContext.isDisabled() %>"
	filterDropdownItems="<%= tableEntryManagementToolbarDisplayContext.getFilterDropdownItems() %>"
	itemsTotal="<%= tableEntryManagementToolbarDisplayContext.getItemsTotal() %>"
	searchActionURL="<%= tableEntryManagementToolbarDisplayContext.getSearchActionURL() %>"
	searchContainerId="tableEntry"
	searchFormName="fm"
	showSearch="true"
	sortingOrder="<%= tableEntryManagementToolbarDisplayContext.getOrderByType() %>"
	sortingURL="<%= tableEntryManagementToolbarDisplayContext.getSortingURL() %>"
/>

<portlet:actionURL name="/tableentry/crud" var="restoreTrashEntriesURL">
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
			id="tableEntry"
			rowChecker="<%= new EmptyOnClickRowChecker(renderResponse) %>"
			searchContainer="<%= entriesSearchContainer %>"
		>
			<liferay-ui:search-container-row
				className="cz.csob.ency.modules.apps.meta.cds.model.TableEntry"
				escapedModel="<%= true %>"
				keyProperty="tableEntryId"
				modelVar="tableEntry"
			>


				<portlet:renderURL var="viewTableUrl">
					<portlet:param name="mvcRenderCommandName" value="/tableentry/crud"/>
					<portlet:param
							name="<%= Constants.CMD %>"
							value="<%= Constants.VIEW %>"
					/>
					<portlet:param name="backUrl" value="<%= portletURL.toString() %>"/>
					<portlet:param name="resourcePrimKey" value="<%= Long.toString(tableEntry.getPrimaryKey()) %>"/>
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
					name="tablefullname"
					orderable="true"
					orderableProperty="tableFullName"
					property="tableFullName"
					href="<%=viewTableUrl%>"
				/>


				<liferay-ui:search-container-column-text
					align="left"
					name="tabletype"
					orderable="true"
					orderableProperty="tableType"
					property="tableType"
				/>


				<liferay-ui:search-container-column-text
					align="left"
					name="tabledatabase"
					orderable="true"
					orderableProperty="tableDatabase"
					property="tableDatabase"
				/>

				<portlet:renderURL var="viewSystemUrl">
					<portlet:param name="mvcRenderCommandName" value="/systementry/crud"/>
					<portlet:param
							name="<%= Constants.CMD %>"
							value="<%= Constants.VIEW %>"
					/>
					<portlet:param name="backUrl" value="<%= portletURL.toString() %>"/>
					<portlet:param name="resourcePrimKey" value="<%= Long.toString(tableEntry.getSystemEntryId()) %>"/>
				</portlet:renderURL>

				<liferay-ui:search-container-column-text
					align="left"
					name="systemname"
					orderable="true"
					orderableProperty="systemName"
					property="systemName"
					href="<%=viewTableUrl%>"
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
					name="dsaurl"
					value="DSA"
					href="<%=tableEntry.getDsaUrl()%>"
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
					path="/table_entry_admin/edit_actions.jsp"
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
			submitForm(form, '<portlet:actionURL name="/tableentry/crud" />');
		}
	}
</aui:script>