<%@ include file="/init.jsp" %>

<jsp:useBean id="tableEntry" scope="request" type="cz.csob.ency.modules.apps.meta.cds.model.TableEntry" />

<%= tableEntry.getTableName()  %>
