<%@ include file="../init.jsp" %>

<%
    ColumnEntry columnEntry = (ColumnEntry) request.getAttribute("columnEntry");
    TableEntry tableEntry = (TableEntry) TableEntryLocalServiceUtil.getTableEntry(columnEntry.getTableEntryId());
    portletDisplay.setTitle("Meta CDS Column: " + columnEntry.getColumnName());
%>

<div class="e3-app-headers">
    <clay:row cssClass="e3-app-header-row">
        <clay:col cssClass="mx-auto" md="12">
            <clay:content-row>
                <clay:content-col cssClass="inline-item-before">
                    <div class="e3-app-logo">
                        <clay:sticker icon="add-column"/>
                    </div>
                </clay:content-col>
                <clay:content-col expand="<%= true %>">
                    <h2 class="title"><%= HtmlUtil.escape(columnEntry.getColumnName()) %>
                    </h2>

                    <%
                        String subtitle = columnEntry.getDatabaseName() + " > " + columnEntry.getTableName();
                    %>

                    <c:if test="<%= Validator.isNotNull(subtitle) %>">
                        <h5 class="sub-title"><%= HtmlUtil.escape(subtitle) %>
                        </h5>
                    </c:if>
                </clay:content-col>
                <clay:content-col>
                    <%--<%@ include file="./fragments/entry_actions.jsp" %>--%>
                </clay:content-col>
            </clay:content-row>
        </clay:col>
    </clay:row>
    <clay:row cssClass="e3-app-breadcrumbs-row">
        <clay:col md="12">
            <portlet:renderURL var="rootUrl">
                <portlet:param name="mvcRenderCommandName" value="/metacds/view"/>
            </portlet:renderURL>
            <portlet:renderURL var="parentSystemUrl">
                <portlet:param name="mvcRenderCommandName" value="/systementry/crud"/>
                <portlet:param name="<%=Constants.CMD%>" value="<%=Constants.VIEW%>"/>
                <portlet:param name="resourcePrimKey" value="<%=Long.toString(tableEntry.getSystemEntryId())%>"/>
            </portlet:renderURL>
            <portlet:renderURL var="parentTableUrl">
                <portlet:param name="mvcRenderCommandName" value="/tableentry/crud"/>
                <portlet:param name="<%=Constants.CMD%>" value="<%=Constants.VIEW%>"/>
                <portlet:param name="resourcePrimKey" value="<%=Long.toString(tableEntry.getTableEntryId())%>"/>
            </portlet:renderURL>
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a class="breadcrumb-link" href="<%=rootUrl%>"
                       title="<liferay-ui:message key="meta-cds-systems"/>">
                        <span class="breadcrumb-text-truncate"><liferay-ui:message key="meta-cds-systems"/></span>
                    </a>
                </li>
                <li class="breadcrumb-item">
                    <a class="breadcrumb-link" href="<%=parentSystemUrl%>" title="<%=tableEntry.getSystemName()%>">
                        <span class="breadcrumb-text-truncate"><%=tableEntry.getSystemName()%></span>
                    </a>
                </li>
                <li class="breadcrumb-item">
                    <a class="breadcrumb-link" href="<%=parentTableUrl%>" title="<%=tableEntry.getTableFullName()%>">
                        <span class="breadcrumb-text-truncate"><%=tableEntry.getTableName()%></span>
                    </a>
                </li>
                <li class="active breadcrumb-item">
					<span class="breadcrumb-text-truncate" title="<%=columnEntry.getColumnName()%>">
						<%=columnEntry.getColumnName()%></span>
                </li>
            </ol>
        </clay:col>
    </clay:row>
</div>

<clay:container cssClass="e3-container container-fluid main-content-body">
    <clay:row>
        <clay:col md="8" sm="12">
            <liferay-ui:panel title="system-info" collapsible="false" iconCssClass="icon-info">
                <div class="flex-box">
                        <%--
                        <div class="flex-item">
                            <label><liferay-ui:message key="columnEntryId"/></label>
                            <div class="e3-ro-form-item"><%=columnEntry.getColumnEntryId()%>
                            </div>
                        </div>
                        <div class="flex-item">
                            <label><liferay-ui:message key="columnType"/></label>
                            <div class="e3-ro-form-item"><%=columnEntry.getColumnType()%>
                            </div>
                        </div>
                        --%>
                    <div class="flex-item">
                        <label><liferay-ui:message key="columnname"/></label>
                        <div class="e3-ro-form-item"><%=columnEntry.getColumnName()%>
                        </div>
                    </div>
                    <div class="flex-item">
                        <label><liferay-ui:message key="columnfullname"/></label>
                        <div class="e3-ro-form-item"><%=columnEntry.getColumnFullName()%>
                        </div>
                    </div>

                        <%--
                        <div class="flex-item">
                            <label><liferay-ui:message key="tableentryid"/></label>
                            <div class="e3-ro-form-item"><%=Long.toString(columnEntry.getTableEntryId())%>
                            </div>
                        </div>
                        --%>
                    <div class="flex-item">
                        <label><liferay-ui:message key="tablename"/></label>
                        <div class="e3-ro-form-item"><%=columnEntry.getTableName()%>
                        </div>
                    </div>
                    <div class="flex-item">
                        <label><liferay-ui:message key="systemname"/></label>
                        <div class="e3-ro-form-item"><%=columnEntry.getSystemName()%>
                        </div>
                    </div>
                    <div class="flex-item">
                        <label><liferay-ui:message key="databasename"/></label>
                        <div class="e3-ro-form-item"><%=columnEntry.getDatabaseName()%>
                        </div>
                    </div>

                </div>
                <div class="flex-box ">
                    <div class="flex-item">
                        <label><liferay-ui:message key="datatype"/></label>
                        <div class="e3-ro-form-item"><%=columnEntry.getDataType()%>
                        </div>
                    </div>
                    <c:if test="<%=columnEntry.getDataSize()!=0%>">
                        <div class="flex-item">
                            <label><liferay-ui:message key="datasize"/></label>
                            <div class="e3-ro-form-item"><%=columnEntry.getDataSize()%>
                            </div>
                        </div>
                    </c:if>
                        <%--
                        <div class="flex-item">
                            <label><liferay-ui:message key="isprimarykey"/></label>
                            <div class="e3-ro-form-item"><%=columnEntry.getIsPrimaryKey()%>
                            </div>
                        </div>
                        <div class="flex-item">
                            <label><liferay-ui:message key="isnotnull"/></label>
                            <div class="e3-ro-form-item"><%=columnEntry.getIsNotNull()%>
                            </div>
                        </div>
                        <div class="flex-item">
                            <label><liferay-ui:message key="isactive"/></label>
                            <div class="e3-ro-form-item"><%=columnEntry.getIsActive()%>
                            </div>
                        </div>
                        --%>
                </div>
                <div class="flex-box ">
                    <div class="flex-item" style="min-width:100%">
                        <label><liferay-ui:message key="description"/></label>
                        <div class="e3-ro-form-item"><%=tableEntry.getDescription()%>
                        </div>
                    </div>
                </div>
                <div class="flex-box ">
                    <div class="flex-item">
                        <label><liferay-ui:message key="tags"/></label>
                        <div>

                            <c:if test="<%=columnEntry.isIsPrimaryKey()%>">
                                <clay:label label="primary-key" displayType="info"/>
                            </c:if>
                            <c:choose>
                                <c:when test="<%=columnEntry.isIsNotNull()%>">
                                    <clay:label label="Not Null" displayType="info"/>
                                </c:when>
                                <c:otherwise>
                                    <clay:label label="Nullable" displayType="info"/>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="<%=columnEntry.isIsActive()%>">
                                    <clay:label label="active" displayType="success"/>
                                </c:when>
                                <c:otherwise>
                                    <clay:label label="deprecated" displayType="danger"/>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </liferay-ui:panel>
        </clay:col>
        <clay:col md="4" sm="12">
            <liferay-ui:panel title="governance" collapsible="false" iconCssClass="icon-user" extended="true">
                <div class="flex-item">
                    <label><liferay-ui:message key="contactpersonname"/></label>
                    <div class="e3-ro-form-item"><%=tableEntry.getContactPersonName()%>
                    </div>
                </div>
                <div class="flex-item">
                    <label><liferay-ui:message key="specificationownername"/></label>
                    <div class="e3-ro-form-item"><%=tableEntry.getSpecificationOwnerName()%>
                    </div>
                </div>
            </liferay-ui:panel>
        </clay:col>
    </clay:row>
</clay:container>
