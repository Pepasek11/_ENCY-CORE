<%@ page import="cz.csob.ency.connection.model.ConnectionDefinition" %>
<%@ page import="cz.csob.ency.connection.service.ConnectionDefinitionLocalServiceUtil" %>
<%@include file="../init.jsp" %>

<%
    long connectionId = ParamUtil.getLong(request, "connectionId");
    ConnectionDefinition connectionDefinition = null;
    if (connectionId > 0) {
        connectionDefinition = ConnectionDefinitionLocalServiceUtil.getConnectionDefinition(connectionId);
    }
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/admin/view.jsp"/>
</portlet:renderURL>

<portlet:actionURL name='<%= connectionDefinition == null ? "addConnectionDefinition" : "updateConnectionDefinition" %>'
                   var="editConnectionDefinitionURL"/>

<aui:form action="<%= editConnectionDefinitionURL %>" name="fm"
          cssClass="container-fluid container-fluid-max-xl container-form-view">


    <aui:input type="hidden" name="connectionId"
               value='<%= connectionDefinition == null ? "" : connectionDefinition.getConnectionId() %>'/>

    <aui:fieldset-group>
        <aui:fieldset>
            <aui:input
                    name="name"
                    required="true"
                    value='<%= connectionDefinition == null ? "" : connectionDefinition.getName() %>'/>
            <aui:select
                    name="driver"
                    label="Driver Type"
                    value="<%= connectionDefinition == null ? "" : connectionDefinition.getDriver() %>"
            >
                <aui:option value="jdbc:sqlserver">MS SQL Server</aui:option>
                <aui:option value="jdbc:h2">H2</aui:option>
                <aui:option value="jdbc:oracle">Oracle</aui:option>
                <aui:option value="jdbc:teradata">Teradata</aui:option>
            </aui:select>
            <aui:input
                    name="serverAddress"
                    label="Server Address"
                    required="true"
                    value='<%= connectionDefinition == null ? "" : connectionDefinition.getServerAddress() %>'/>
            <aui:input
                    name="serverPort"
                    label="Server Port"
                    required="false"
                    value='<%= connectionDefinition == null ? "" : connectionDefinition.getServerPort() %>'
                    helpMessage="edit.field.helpmessage"
            />
            <aui:input
                    name="databaseName"
                    label="edit.label.databaseName"
                    required="false"
                    value='<%= connectionDefinition == null ? "" : connectionDefinition.getDatabaseName() %>'
            />
            <aui:input
                    name="integratedSecurity"
                    type="checkbox"
                    label="useIntegratedSecurity"
                    required="false"
                    value='<%= connectionDefinition == null ? "" : connectionDefinition.getIntegratedSecurity() %>'
            />

            <aui:input
                    name="username"
                    label="DB User Name"
                    required="true"
                    value='<%= connectionDefinition == null ? "" : connectionDefinition.getUsername() %>'/>
            <aui:input
                    name="password"
                    label="DB Password"
                    value='<%= connectionDefinition == null ? "" : connectionDefinition.getPassword() %>'/>

            <aui:button-row>
                <aui:button type="submit"/>
                <aui:button onClick="<%= viewURL %>" type="cancel"/>
            </aui:button-row>
        </aui:fieldset>
    </aui:fieldset-group>
</aui:form>