
<%
PortletURL navigationPortletURL = renderResponse.createRenderURL();
PortletURL portletURL = PortletURLUtil.clone(navigationPortletURL, liferayPortletResponse);

long groupId = systemEntry.getGroupId();
String name = SystemEntry.class.getName();
String primKey = String.valueOf(systemEntry.getPrimaryKey());
%>

<liferay-ui:icon-menu
	cssClass='<%= systemEntry == null ? "entry-options inline" : StringPool.BLANK %>'
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>
	<c:if test="<%= SystemEntryEntryPermission.contains(permissionChecker, systemEntry, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="cz.csob.ency.modules.apps.meta.cds.model.SystemEntry"
			modelResourceDescription="SystemEntry"
			resourcePrimKey="<%= String.valueOf(primKey) %>"
			var="permissionsEntryURL"
		/>

		<liferay-ui:icon iconCssClass="icon-lock" label="<%= true %>" markupView="lexicon" message="permissions" url="<%= permissionsEntryURL %>" />
	</c:if>

	<c:if test="<%= SystemEntryEntryPermission.contains(permissionChecker, systemEntry, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editSystemEntryURL">
			<portlet:param name="mvcRenderCommandName" value="/systementry/crud" />

			<portlet:param
				name="<%= Constants.CMD %>"
				value="<%= Constants.UPDATE %>"
			/>

			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:renderURL>

		<liferay-ui:icon iconCssClass="icon-edit" label="<%= true %>" markupView="lexicon" message="edit" url="<%= editSystemEntryURL.toString() %>" />
	</c:if>

	<c:if test="<%= SystemEntryEntryPermission.contains(permissionChecker, systemEntry, ActionKeys.DELETE) %>">
		<portlet:actionURL name="/systementry/crud" var="deleteSystemEntryURL">
			<portlet:param
				name="<%= Constants.CMD %>"
				value="<%= Constants.DELETE %>"
			/>

			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:actionURL>

		<liferay-ui:icon iconCssClass="icon-remove" label="<%= true %>" markupView="lexicon" message="delete" url="<%= deleteSystemEntryURL.toString() %>" />
	</c:if>

	<c:if test="<%= SystemEntryEntryPermission.contains(permissionChecker, systemEntry, ActionKeys.DELETE) %>">
		<portlet:actionURL name="/systementry/crud" var="moveToTrashSystemEntryURL">
			<portlet:param
				name="<%= Constants.CMD %>"
				value="<%= Constants.MOVE_TO_TRASH %>"
			/>

			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:actionURL>

		<liferay-ui:icon iconCssClass="icon-trash" label="<%= true %>" markupView="lexicon" message="move-to-recycle-bin" url="<%= moveToTrashSystemEntryURL.toString() %>" />
	</c:if>

	<c:if test="<%= SystemEntryEntryPermission.contains(permissionChecker, systemEntry, ActionKeys.UPDATE) %>">
		<portlet:actionURL name="/tableentry/crud" var="importSystemTablesURL">
			<portlet:param
					name="<%= Constants.CMD %>"
					value="<%= Constants.IMPORT %>"
			/>

			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="resourcePrimKey" value="<%= systemEntry.getSystemName() %>" />
		</portlet:actionURL>

		<liferay-ui:icon iconCssClass="icon-download-alt" label="<%= true %>" markupView="lexicon" message="import-tabless" url="<%= importSystemTablesURL.toString() %>" />
	</c:if>

</liferay-ui:icon-menu>