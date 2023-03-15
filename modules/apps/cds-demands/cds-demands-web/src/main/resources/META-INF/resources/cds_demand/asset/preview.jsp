<%--  --%>
<%--  --%>
<%--  --%>
<%@ include file="/cds_demand/init.jsp" %>

<jsp:useBean id="cdsDemand" scope="request" type="cz.csob.ency.cds.demands.model.CdsDemand" />

<%= cdsDemand.getTitle() %>