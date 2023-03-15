<%@ include file="/init.jsp" %>

<jsp:useBean id="columnEntry" scope="request" type="cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry" />

<%= columnEntry.getColumnName() %>