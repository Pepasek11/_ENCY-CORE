<%@ page import="cz.csob.ency.connection.model.ConnectionDefinition" %>
<%@include file="../init.jsp" %>
<%
    String mvcPath = ParamUtil.getString(request, "mvcPath");
    ResultRow row = (ResultRow) request.getAttribute("SEARCH_CONTAINER_RESULT_ROW");
    ConnectionDefinition connectionDefinition = (ConnectionDefinition) row.getObject();
%>

<liferay-ui:icon image="<%=connectionDefinition.getIntegratedSecurity()?"check":"delete"%>"/>

