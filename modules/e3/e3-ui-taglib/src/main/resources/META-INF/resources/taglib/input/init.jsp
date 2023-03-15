<%@ include file="../init.jsp" %>

<%--
--%>
<%
    String id = GetterUtil.getString((String)request.getAttribute("e3-ui:input:id"));
    String name = GetterUtil.getString((String)request.getAttribute("e3-ui:input:name"));
    String value = GetterUtil.getString((String)request.getAttribute("e3-ui:input:value"));
    String mode = GetterUtil.getString((String)request.getAttribute("e3-ui:input:mode"));

    String title = GetterUtil.getString((String) request.getAttribute("e3-ui:input:title"));
    String label = GetterUtil.getString((String) request.getAttribute("e3-ui:input:label"));

%>