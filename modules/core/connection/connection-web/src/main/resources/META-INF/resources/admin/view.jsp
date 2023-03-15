<%@ page import="cz.csob.ency.connection.service.ConnectionDefinitionLocalServiceUtil" %>
<%@ include file="../init.jsp" %>

<aui:container>
<aui:form action="" cssClass="container-fluid container-fluid-max-xl container-form-view" method="get" name="fm">

    <liferay-ui:search-container
            total="<%= ConnectionDefinitionLocalServiceUtil.getConnectionDefinitionsCount() %>"
            var="searchContainer">
        <liferay-ui:search-container-results
                results="<%= ConnectionDefinitionLocalServiceUtil.getConnectionDefinitions(
                searchContainer.getStart(), searchContainer.getEnd()) %>"/>

        <liferay-ui:search-container-row
                className="cz.csob.ency.connection.model.ConnectionDefinition"
                modelVar="connectionDefinition">

            <liferay-ui:search-container-column-text
                    name="name"
                    property="name"
                    cssClass="table-cell-expand-small table-cell-minw-100 table-title"/>
            <liferay-ui:search-container-column-text
                    name="driver"
                    property="driver"
                    cssClass="table-cell-expand-small table-cell-minw-100 table-title"/>
            <liferay-ui:search-container-column-text
                    name="server-address"
                    property="serverAddress"
                    cssClass="table-cell-expand-small table-cell-minw-250 table-title"/>
            <liferay-ui:search-container-column-text
                    name="server-port"
                    property="serverPort"
                    cssClass="table-cell-expand-small table-cell-minw-100 table-title"/>
            <liferay-ui:search-container-column-text
                    name="user-name"
                    property="username"
                    cssClass="table-cell-expand-small table-cell-minw-150 table-title"/>
            <liferay-ui:search-container-column-jsp
                    cssClass="table-cell-expand-small table-cell-minw-70 table-title"
                    name="integrated-security"
                    align="center"
                    path="/admin/col_integrationsecurity.jsp"/>

            <liferay-ui:search-container-column-text
                    name="status"
                    property="status"
                    cssClass="table-cell-minw-200 table-title"/>

            <liferay-ui:search-container-column-jsp
                    cssClass="table-cell-expand-small table-cell-minw-70 table-title"
                    name="actions"
                    align="right"
                    path="/admin/row_actions.jsp"/>

        </liferay-ui:search-container-row>

        <liferay-ui:search-iterator/>
    </liferay-ui:search-container>


    <aui:button-row cssClass="connectionDefinition-admin-buttons">
        <portlet:renderURL var="addConnectionDefinitionURL">
            <portlet:param name="mvcPath" value="/admin/edit.jsp"/>
            <portlet:param name="redirect" value="<%= "currentURL" %>"/>
        </portlet:renderURL>

        <aui:button onClick="<%= addConnectionDefinitionURL.toString() %>"
                    value="add-connection-definition"/>
    </aui:button-row>
</aui:form>
</aui:container>