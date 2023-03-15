<%@ include file="/init.jsp" %>

<%
    SystemEntryDisplayContext systemEntryDisplayContext = (SystemEntryDisplayContext) request.getAttribute(SystemEntryWebKeys.SYSTEMENTRY_DISPLAY_CONTEXT);

    String displayStyle = systemEntryDisplayContext.getDisplayStyle();
    SearchContainer entriesSearchContainer = systemEntryDisplayContext.getSearchContainer();


    PortletURL portletURL = entriesSearchContainer.getIteratorURL();
    portletDisplay.setTitle("meta-cds-systems");
    portletDisplay.setShowBackIcon(false);
    portletDisplay.setShowEditIcon(true);
    SystemEntryManagementToolbarDisplayContext systemEntryManagementToolbarDisplayContext = new SystemEntryManagementToolbarDisplayContext(liferayPortletRequest, liferayPortletResponse, request, entriesSearchContainer, trashHelper, displayStyle);
%>

<div class="e3-app-headers">
    <clay:row cssClass="e3-app-header-row">
        <clay:col cssClass="mx-auto" md="12">
            <clay:content-row>
                <clay:content-col cssClass="inline-item-before">
                    <div class="e3-app-logo">
                        <clay:sticker icon="grid"/>
                    </div>
                </clay:content-col>
                <clay:content-col expand="<%= true %>"
                >
                    <h2 class="title"><liferay-ui:message key="meta-cds-systems"/>
                    </h2>
                </clay:content-col>
                <clay:content-col>
                    <%-- <%@ include file="../table_entry_admin/fragments/entry_actions.jsp" %> --%>
                </clay:content-col>
            </clay:content-row>
        </clay:col>
    </clay:row>
</div>

<clay:management-toolbar
        clearResultsURL="<%= systemEntryManagementToolbarDisplayContext.getSearchActionURL() %>"
        componentId="systemEntryManagementToolbar"
        disabled="<%= systemEntryManagementToolbarDisplayContext.isDisabled() %>"
        filterDropdownItems="<%= systemEntryManagementToolbarDisplayContext.getFilterDropdownItems() %>"
        itemsTotal="<%= systemEntryManagementToolbarDisplayContext.getItemsTotal() %>"
        searchActionURL="<%= systemEntryManagementToolbarDisplayContext.getSearchActionURL() %>"
        searchContainerId="systemEntry"
        searchFormName="fm"
        showSearch="true"
        sortingOrder="<%= systemEntryManagementToolbarDisplayContext.getOrderByType() %>"
        sortingURL="<%= systemEntryManagementToolbarDisplayContext.getSortingURL() %>"
        selectable="false"
/>

<div class="container-fluid container-fluid-max-xl main-content-body">
    <aui:form action="<%= portletURL.toString() %>" method="get" name="fm">
        <aui:input name="<%= Constants.CMD %>" type="hidden"/>
        <aui:input name="redirect" type="hidden" value="<%= portletURL.toString() %>"/>
        <aui:input name="deleteEntryIds" type="hidden"/>
        <aui:input name="selectAll" type="hidden" value="<%= false %>"/>

        <liferay-ui:search-container
                emptyResultsMessage="no-record-was-found"
                id="systemEntry"
                searchContainer="<%= entriesSearchContainer %>"
        >
            <liferay-ui:search-container-row
                    className="cz.csob.ency.modules.apps.meta.cds.model.SystemEntry"
                    escapedModel="<%= true %>"
                    keyProperty="systemEntryId"
                    modelVar="systemEntry"
            >

                <portlet:renderURL var="viewEntryUrl">
                    <portlet:param name="mvcRenderCommandName" value="/systementry/crud"/>
                    <portlet:param
                            name="<%= Constants.CMD %>"
                            value="<%= Constants.VIEW %>"
                    />
                    <c:choose>
                        <c:when test="<%=!Validator.isBlank(systemEntry.getUrlTitle())%>">
                            <portlet:param name="urlTitle" value="<%= systemEntry.getUrlTitle() %>"/>
                        </c:when>
                        <c:otherwise>
                            <portlet:param name="resourcePrimKey" value="<%= Long.toString(systemEntry.getPrimaryKey()) %>"/>
                        </c:otherwise>
                    </c:choose>
                </portlet:renderURL>

                <liferay-ui:search-container-column-text
                        align="left"
                        name="systemcode"
                        orderable="true"
                        orderableProperty="systemCode"
                        property="systemCode"
                        href="<%=viewEntryUrl%>"
                />

                <liferay-ui:search-container-column-text
                        align="left"
                        name="systemname"
                        orderable="true"
                        orderableProperty="systemName"
                        property="systemName"
                        href="<%=viewEntryUrl%>"
                />

                <liferay-ui:search-container-column-text
                        align="left"
                        name="systemtitle"
                        orderable="true"
                        orderableProperty="systemTitle"
                        property="systemTitle"
                />

                <liferay-ui:search-container-column-text
                        align="left"
                        name="description"
                        orderable="true"
                        orderableProperty="description"
                        property="description"
                />

                <liferay-ui:search-container-column-text
                        align="middle"
                        name="tags"
                >
                    <c:choose>
                        <c:when test="<%=systemEntry.getSystemType().toLowerCase().equals("system")%>">
                            <clay:label label="system" displayType="info"/>
                        </c:when>
                        <c:when test="<%=systemEntry.getSystemType().toLowerCase().equals("system-datamart")%>">
                            <clay:label label="datamart" displayType="info"/>
                        </c:when>
                        <c:otherwise>
                            <clay:label label="<%=systemEntry.getSystemType()%>" displayType="info"/>
                        </c:otherwise>
                    </c:choose>
                    <c:if test="<%=systemEntry.isIsSlaSigned()%>">
                        <clay:label label="sla-signed" displayType="info"/>
                    </c:if>
                    <c:if test="<%=systemEntry.isIsSelfBi()%>">
                        <clay:label label="self-bi" displayType="info"/>
                    </c:if>
                    <c:choose>
                        <c:when test="<%=systemEntry.isIsActive()%>">
                            <clay:label label="active" displayType="success"/>
                        </c:when>
                        <c:otherwise>
                            <clay:label label="deprecated" displayType="danger"/>
                        </c:otherwise>
                    </c:choose>
                </liferay-ui:search-container-column-text>
            </liferay-ui:search-container-row>

            <liferay-ui:search-iterator displayStyle="list" markupView="lexicon"/>
        </liferay-ui:search-container>
    </aui:form>
</div>
