<%@ page import="java.util.HashMap" %><%--
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
<portlet:resourceURL id="/resources/getentry" var="getEntryResourceUrl"/>
<portlet:actionURL name="/cdsdemand/crud" var="updateDemandActionUrl">
    <portlet:param name="ajax" value="true"/>
    <portlet:param name="<%= Constants.CMD %>" value="<%= Constants.UPDATE %>"/>
</portlet:actionURL>
<portlet:actionURL name="/cdsdemand/crud" var="addDemandActionUrl">
    <portlet:param name="ajax" value="true"/>
    <portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD %>"/>
</portlet:actionURL>
<portlet:actionURL name="/cdsdemand/upload_file_entry" var="uploadActionUrl"/>

<%
    Map<String, Object> context =
            (Map<String, Object>) request.getAttribute(CdsDemandWebKeys.DISPLAY_CONTEXT);
    if(context==null){
        context = new HashMap<>();
    }

    context = HashMapBuilder.create(context).put(
            "entryResourceURL", getEntryResourceUrl
    ).put(
            "npmResolvedPackageName", npmResolvedPackageName
    ).put(
            "urls", HashMapBuilder.<String, Object>put(
                    "addDemandAction", addDemandActionUrl
            ).put(
                    "updateDemandAction", updateDemandActionUrl
            ).put(
                    "uploadAction", uploadActionUrl
            ).build()
    ).build();
%>

<div id="<%= liferayPortletResponse.getNamespace() + "-demands-root" %>">
    <react:component
            module="js/index.es"
            props='<%=context%>'
    />
</div>