<%@ include file="/init.jsp" %>

<%
PortletURL navigationPortletURL = renderResponse.createRenderURL();
PortletURL portletURL = PortletURLUtil.clone(navigationPortletURL, liferayPortletResponse);

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
TableEntry tableEntry = (TableEntry)row.getObject();

long groupId = tableEntry.getGroupId();
String name = TableEntry.class.getName();
String primKey = String.valueOf(tableEntry.getPrimaryKey());
%>

<liferay-ui:icon-menu
	cssClass='<%= row == null ? "entry-options inline" : StringPool.BLANK %>'
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>
	<c:if test="<%= TableEntryEntryPermission.contains(permissionChecker, tableEntry, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="cz.csob.ency.modules.apps.meta.cds.model.TableEntry"
			modelResourceDescription="TableEntry"
			resourcePrimKey="<%= String.valueOf(primKey) %>"
			var="permissionsEntryURL"
		/>

		<liferay-ui:icon iconCssClass="icon-lock" label="<%= true %>" markupView="lexicon" message="permissions" url="<%= permissionsEntryURL %>" />
	</c:if>

	<c:if test="<%= TableEntryEntryPermission.contains(permissionChecker, tableEntry, ActionKeys.VIEW) %>">
		<portlet:renderURL var="viewTableEntryURL">
			<portlet:param name="mvcRenderCommandName" value="/tableentry/crud" />

			<portlet:param
				name="<%= Constants.CMD %>"
				value="<%= Constants.VIEW %>"
			/>

			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:renderURL>

		<liferay-ui:icon iconCssClass="icon-eye-open" label="<%= true %>" markupView="lexicon" message="view" url="<%= viewTableEntryURL.toString() %>" />
	</c:if>

	<c:if test="<%= TableEntryEntryPermission.contains(permissionChecker, tableEntry, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editTableEntryURL">
			<portlet:param name="mvcRenderCommandName" value="/tableentry/crud" />

			<portlet:param
				name="<%= Constants.CMD %>"
				value="<%= Constants.UPDATE %>"
			/>

			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:renderURL>

		<liferay-ui:icon iconCssClass="icon-edit" label="<%= true %>" markupView="lexicon" message="edit" url="<%= editTableEntryURL.toString() %>" />
	</c:if>

	<c:if test="<%= TableEntryEntryPermission.contains(permissionChecker, tableEntry, ActionKeys.DELETE) %>">
		<portlet:actionURL name="/tableentry/crud" var="deleteTableEntryURL">
			<portlet:param
				name="<%= Constants.CMD %>"
				value="<%= Constants.DELETE %>"
			/>

			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:actionURL>

		<liferay-ui:icon iconCssClass="icon-remove" label="<%= true %>" markupView="lexicon" message="delete" url="<%= deleteTableEntryURL.toString() %>" />
	</c:if>

	<c:if test="<%= TableEntryEntryPermission.contains(permissionChecker, tableEntry, ActionKeys.DELETE) %>">
		<portlet:actionURL name="/tableentry/crud" var="moveToTrashTableEntryURL">
			<portlet:param
				name="<%= Constants.CMD %>"
				value="<%= Constants.MOVE_TO_TRASH %>"
			/>

			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:actionURL>

		<liferay-ui:icon iconCssClass="icon-trash" label="<%= true %>" markupView="lexicon" message="move-to-recycle-bin" url="<%= moveToTrashTableEntryURL.toString() %>" />
	</c:if>
</liferay-ui:icon-menu>