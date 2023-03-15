<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="init.jsp" %>

<portlet:renderURL var="basePortletURL"/>

<div id="<%= liferayPortletResponse.getNamespace() + "-delegations-root" %>">

    <%
    %>

    <portlet:resourceURL id="/resources/getentry" var="entryResourceUrl"/>

    <react:component
            module="js/index.es"
            props='<%=
			HashMapBuilder.<String, Object>put(
                "basePortletURL",basePortletURL
            ).put(
				"entryResourceURL", entryResourceUrl
			).put(
				"includeContextPath", renderRequest.getAttribute("javax.servlet.include.context_path")
			).put(
				"isOmniAdmin", permissionChecker.isOmniadmin()
			).put(
				"namespace", portletDisplay.getNamespace()
			).put(
				"npmResolvedPackageName", npmResolvedPackageName
			).put(
				"portletId", themeDisplay.getPortletDisplay().getId()
			).put(
				"groupId", String.valueOf(themeDisplay.getScopeGroupId())
			).put(
				"userId", String.valueOf(themeDisplay.getUserId())
			).build()
		%>'
    />
</div>