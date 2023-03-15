<%@ page import="cz.csob.ency.modules.apps.meta.cds.web.internal.security.permission.resource.TableEntryEntryPermission" %>

<%
PortletURL navigationPortletURL = renderResponse.createRenderURL();
PortletURL portletURL = PortletURLUtil.clone(navigationPortletURL, liferayPortletResponse);

String primKey = String.valueOf(tableEntry.getPrimaryKey());
%>

<liferay-ui:icon-menu
	cssClass='<%= tableEntry == null ? "entry-options inline" : StringPool.BLANK %>'
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>
	<c:if test="<%=    TableEntryEntryPermission.contains(permissionChecker, tableEntry, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="cz.csob.ency.modules.apps.meta.cds.model.TableEntry"
			modelResourceDescription="TableEntry"
			resourcePrimKey="<%= String.valueOf(primKey) %>"
			var="permissionsEntryURL"
		/>

		<liferay-ui:icon iconCssClass="icon-lock" label="<%= true %>" markupView="lexicon" message="permissions" url="<%= permissionsEntryURL %>" />
	</c:if>

	<c:if test="<%=    TableEntryEntryPermission.contains(permissionChecker, tableEntry, ActionKeys.UPDATE) %>">
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

	<c:if test="<%=    TableEntryEntryPermission.contains(permissionChecker, tableEntry, ActionKeys.DELETE) %>">
		<portlet:actionURL name="/tableEntry/crud" var="deleteTableEntryURL">
			<portlet:param
				name="<%= Constants.CMD %>"
				value="<%= Constants.DELETE %>"
			/>

			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:actionURL>

		<liferay-ui:icon iconCssClass="icon-remove" label="<%= true %>" markupView="lexicon" message="delete" url="<%= deleteTableEntryURL.toString() %>" />
	</c:if>

	<c:if test="<%=    TableEntryEntryPermission.contains(permissionChecker, tableEntry, ActionKeys.DELETE) %>">
		<portlet:actionURL name="/tableEntry/crud" var="moveToTrashTableEntryURL">
			<portlet:param
				name="<%= Constants.CMD %>"
				value="<%= Constants.MOVE_TO_TRASH %>"
			/>

			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:actionURL>

		<liferay-ui:icon iconCssClass="icon-trash" label="<%= true %>" markupView="lexicon" message="move-to-recycle-bin" url="<%= moveToTrashTableEntryURL.toString() %>" />
	</c:if>

	<c:if test="<%=    TableEntryEntryPermission.contains(permissionChecker, tableEntry, ActionKeys.UPDATE) %>">
		<portlet:actionURL name="/columnentry/crud" var="importTableColmnsURL">
			<portlet:param
					name="<%= Constants.CMD %>"
					value="<%= Constants.IMPORT %>"
			/>

			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="resourcePrimKey" value="<%=tableEntry.getTableFullName() %>" />
		</portlet:actionURL>

		<liferay-ui:icon iconCssClass="icon-download-alt" label="<%= true %>" markupView="lexicon" message="import-columns" url="<%= importTableColmnsURL.toString() %>" />
	</c:if>

</liferay-ui:icon-menu>