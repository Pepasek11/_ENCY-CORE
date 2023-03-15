<%@ page import="cz.csob.ency.connection.model.ConnectionDefinition" %>
<%@include file="../init.jsp" %>
<%
    String mvcPath = ParamUtil.getString(request, "mvcPath");
    ResultRow row = (ResultRow) request.getAttribute("SEARCH_CONTAINER_RESULT_ROW");
    ConnectionDefinition ConnectionDefinition = (ConnectionDefinition) row.getObject();
%>

<%--<liferay-ui:icon-menu>--%>
<portlet:renderURL var="editURL">
    <portlet:param name="connectionId"
                   value="<%=String.valueOf(ConnectionDefinition.getConnectionId()) %>"/>
    <portlet:param name="mvcPath"
                   value="/admin/edit.jsp"/>
</portlet:renderURL>

<portlet:actionURL name="deleteConnectionDefinition" var="deleteURL">
    <portlet:param name="connectionId"
                   value="<%= String.valueOf(ConnectionDefinition.getConnectionId()) %>"/>
</portlet:actionURL>

<liferay-ui:icon image="edit" alt="Edit" url="<%=editURL.toString() %>"/>
<liferay-ui:icon image="delete" alt="Edit" url="<%=deleteURL.toString() %>"/>

<%--</liferay-ui:icon-menu>--%>