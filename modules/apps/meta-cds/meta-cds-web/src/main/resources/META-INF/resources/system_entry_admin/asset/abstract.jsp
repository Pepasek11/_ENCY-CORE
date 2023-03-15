<%@ include file="/init.jsp" %>

<jsp:useBean id="systemEntry" scope="request" type="cz.csob.ency.modules.apps.meta.cds.model.SystemEntry" />

<portlet:defineObjects />

<%= systemEntry.getSystemName() %>
