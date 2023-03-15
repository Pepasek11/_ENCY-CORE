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


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/asset" prefix="liferay-asset" %><%@
        taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
        taglib uri="http://liferay.com/tld/clay" prefix="clay" %><%@
        taglib uri="http://liferay.com/tld/comment" prefix="liferay-comment" %><%@
        taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %><%--<%@
        taglib uri="http://liferay.com/tld/editor" prefix="liferay-editor" %>--%><%@
        taglib uri="http://liferay.com/tld/expando" prefix="liferay-expando" %><%@
        taglib uri="http://liferay.com/tld/flags" prefix="liferay-flags" %><%@
        taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
        taglib uri="http://liferay.com/tld/item-selector" prefix="liferay-item-selector" %><%@
        taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
        taglib uri="http://liferay.com/tld/ratings" prefix="liferay-ratings" %><%@
        taglib uri="http://liferay.com/tld/reading-time" prefix="liferay-reading-time" %><%@
        taglib uri="http://liferay.com/tld/rss" prefix="liferay-rss" %><%@
        taglib uri="http://liferay.com/tld/social-bookmarks" prefix="liferay-social-bookmarks" %><%@
        taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %><%@
        taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
        taglib uri="http://liferay.com/tld/trash" prefix="liferay-trash" %><%@
        taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
        taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>


<%@ page import="com.liferay.petra.string.StringPool" %><%@
    page import="com.liferay.portal.kernel.portlet.PortletURLUtil" %><%@
    page import="com.liferay.portal.kernel.util.GetterUtil" %><%@
    page import="com.liferay.portal.kernel.util.JavaConstants" %><%@
    page import="com.liferay.portal.kernel.util.PortalUtil" %><%@
    page import="com.liferay.portal.kernel.util.Validator" %><%@
    page import="com.liferay.taglib.aui.AUIUtil" %><%@
    page import="com.liferay.taglib.util.TagResourceBundleUtil" %><%@
    page import="javax.portlet.PortletRequest" %><%@
    page import="javax.portlet.PortletResponse" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ResourceBundle" %>


<liferay-theme:defineObjects />
<liferay-frontend:defineObjects/>
<portlet:defineObjects />
<%
    PortletRequest portletRequest = (PortletRequest)request.getAttribute(JavaConstants.JAVAX_PORTLET_REQUEST);
    PortletResponse portletResponse = (PortletResponse)request.getAttribute(JavaConstants.JAVAX_PORTLET_RESPONSE);
    String namespace = AUIUtil.getNamespace(portletRequest, portletResponse);
    if (Validator.isNull(namespace)) {
        namespace = AUIUtil.getNamespace(request);
    }
%>