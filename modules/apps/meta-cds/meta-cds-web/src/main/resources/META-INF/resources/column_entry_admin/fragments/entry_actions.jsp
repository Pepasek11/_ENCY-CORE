
<%
PortletURL navigationPortletURL = renderResponse.createRenderURL();
PortletURL portletURL = PortletURLUtil.clone(navigationPortletURL, liferayPortletResponse);

long groupId = columnEntry.getGroupId();
String name = ColumnEntry.class.getName();
String primKey = String.valueOf(columnEntry.getPrimaryKey());
%>

<liferay-ui:icon-menu
	cssClass='<%= columnEntry == null ? "entry-options inline" : StringPool.BLANK %>'
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>
	<c:if test="<%= ColumnEntryEntryPermission.contains(permissionChecker, columnEntry, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry"
			modelResourceDescription="ColumnEntry"
			resourcePrimKey="<%= String.valueOf(primKey) %>"
			var="permissionsEntryURL"
		/>

		<liferay-ui:icon iconCssClass="icon-lock" label="<%= true %>" markupView="lexicon" message="permissions" url="<%= permissionsEntryURL %>" />
	</c:if>

	<c:if test="<%= ColumnEntryEntryPermission.contains(permissionChecker, columnEntry, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editColumnEntryURL">
			<portlet:param name="mvcRenderCommandName" value="/columnentry/crud" />

			<portlet:param
				name="<%= Constants.CMD %>"
				value="<%= Constants.UPDATE %>"
			/>

			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:renderURL>

		<liferay-ui:icon iconCssClass="icon-edit" label="<%= true %>" markupView="lexicon" message="edit" url="<%= editColumnEntryURL.toString() %>" />
	</c:if>

	<c:if test="<%= ColumnEntryEntryPermission.contains(permissionChecker, columnEntry, ActionKeys.DELETE) %>">
		<portlet:actionURL name="/columnentry/crud" var="deleteColumnEntryURL">
			<portlet:param
				name="<%= Constants.CMD %>"
				value="<%= Constants.DELETE %>"
			/>

			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:actionURL>

		<liferay-ui:icon iconCssClass="icon-remove" label="<%= true %>" markupView="lexicon" message="delete" url="<%= deleteColumnEntryURL.toString() %>" />
	</c:if>

	<c:if test="<%= ColumnEntryEntryPermission.contains(permissionChecker, columnEntry, ActionKeys.DELETE) %>">
		<portlet:actionURL name="/columnentry/crud" var="moveToTrashColumnEntryURL">
			<portlet:param
				name="<%= Constants.CMD %>"
				value="<%= Constants.MOVE_TO_TRASH %>"
			/>

			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:actionURL>

		<liferay-ui:icon iconCssClass="icon-trash" label="<%= true %>" markupView="lexicon" message="move-to-recycle-bin" url="<%= moveToTrashColumnEntryURL.toString() %>" />
	</c:if>
</liferay-ui:icon-menu>