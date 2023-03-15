<%@ include file="/init.jsp" %>

<%
    TableEntry tableEntry = (TableEntry) request.getAttribute("tableEntry");
    String redirect = ParamUtil.getString(request, "redirect");
    boolean fromAsset = ParamUtil.getBoolean(request, "fromAsset", false);
    portletDisplay.setTitle("Meta CDS Table: " + tableEntry.getTableName());

%>

<div class="e3-app-headers">
    <clay:row cssClass="e3-app-header-row">
        <clay:col cssClass="mx-auto" md="12">
            <clay:content-row>
                <clay:content-col cssClass="inline-item-before">
                    <div class="e3-app-logo">
                        <clay:sticker icon="add-row"/>
                    </div>
                </clay:content-col>
                <clay:content-col expand="<%= true %>">
                    <h2 class="title"><%= HtmlUtil.escape(tableEntry.getTableName()) %>
                    </h2>

                    <%
                        String subtitle = tableEntry.getTableDatabase();
                    %>

                    <c:if test="<%= Validator.isNotNull(subtitle) %>">
                        <h5 class="sub-title"><%= HtmlUtil.escape(subtitle) %>
                        </h5>
                    </c:if>
                </clay:content-col>
                <clay:content-col>
                    <%@ include file="./fragments/entry_actions.jsp" %>
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
                <li class="breadcrumb-item active">
                    <span class="breadcrumb-text-truncate" title="<%=tableEntry.getTableName()%>">
                        <%=tableEntry.getTableFullName()%></span>
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
                    <div class="flex-item">
                        <label><liferay-ui:message key="tableentryid"/></label>
                        <div class="e3-ro-form-item"><%=tableEntry.getTableEntryId()%>
                        </div>
                    </div>
                    <div class="flex-item">
                        <label><liferay-ui:message key="tablename"/></label>
                        <div class="e3-ro-form-item"><%=tableEntry.getTableName()%>
                        </div>
                    </div>
                    <div class="flex-item">
                        <label><liferay-ui:message key="tablefullname"/></label>
                        <div class="e3-ro-form-item"><%=tableEntry.getTableFullName()%>
                        </div>
                    </div>
                    <div class="flex-item">
                        <label><liferay-ui:message key="tabledatabase"/></label>
                        <div class="e3-ro-form-item"><%=tableEntry.getTableDatabase()%>
                        </div>
                    </div>
                    <div class="flex-item">
                        <label><liferay-ui:message key="systemname"/></label>
                        <div class="e3-ro-form-item"><%=tableEntry.getSystemName()%>
                        </div>
                    </div>
                    <div class="flex-item">
                        <label><liferay-ui:message key="tabletype"/></label>
                        <div class="e3-ro-form-item"><%=tableEntry.getTableType()%>
                        </div>
                    </div>
                    <div class="flex-item">
                        <label><liferay-ui:message key="dsaurl"/></label>
                        <div class="">
                            <a href="<%=tableEntry.getDsaUrl()%>" title="DSA" class="extlink" target="_blank">
                                <liferay-ui:message key="open-in-dsa"/>&nbsp;<i class="icon-external-link"></i></a>
                        </div>
                    </div>
                </div>
                <div class="flex-box fbjcl">
                    <div class="flex-item">
                        <label><liferay-ui:message key="isactive"/></label>
                        <clay:checkbox name="isslasigned"
                                       checked="<%=tableEntry.getIsActive()%>"
                                       disabled="true"
                        />
                    </div>
                </div>
                <div class="flex-box ">
                    <div class="flex-item" style="min-width:100%">
                        <label><liferay-ui:message key="description"/></label>
                        <div class="e3-ro-form-item"><%=tableEntry.getDescription()%>
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
    <c:if test="<%=!Validator.isBlank(tableEntry.getUnstructuredClause())%>">
        <clay:row>
            <clay:col expand="true">
                <liferay-ui:panel title="sql" collapsible="true" extended="false" iconCssClass="icon-code">
                    <code lang="sql"><%=tableEntry.getUnstructuredClause()%>
                    </code>
                </liferay-ui:panel>
            </clay:col>
        </clay:row>
    </c:if>
    <%
        String iconCssClass = "icon-table";
        String tableTitle = "Columns";
        String tableId = "columns_tbl";
    %>
    <%@ include file="./fragments/table_columns_block.jsp" %>

    <clay:content-row>
        <clay:content-col expand="true">
            <liferay-ui:panel
                    collapsible="<%= true %>"
                    extended="<%= true %>"
                    id="columnEntryCommentsPanel"
                    persistState="<%= true %>"
                    title='<%= LanguageUtil.get(request, "comments") %>'
                    iconCssClass="icon-comments-alt"
            >
                <portlet:actionURL name="invokeTaglibDiscussion" var="discussionURL"/>

                <liferay-comment:discussion
                        className="<%= TableEntry.class.getName() %>"
                        classPK="<%= tableEntry.getPrimaryKey() %>"
                        formName="fm2"
                        ratingsEnabled="<%= true %>"
                        redirect="<%= currentURL %>"
                        userId="<%= tableEntry.getUserId() %>"
                />
            </liferay-ui:panel>
        </clay:content-col>
    </clay:content-row>
</clay:container>


<portlet:renderURL var="viewColumnUrl">
    <portlet:param name="mvcRenderCommandName" value="/columnentry/crud"/>
    <portlet:param name="<%= Constants.CMD %>" value="<%= Constants.VIEW %>"
    />
</portlet:renderURL>

<liferay-util:html-top>
    <%@ include file="../datatables_include.jsp" %>

    <script>
        var resourcePrimKey = <%=tableEntry.getPrimaryKey()%>;
        var options = {
            data: [],
            columns: [
                {
                  data:'columnPosition'
                },
                {
                    data: 'columnName',
                    render: function (data, type, row) {
                        return (row.isPrimaryKey?'<i class="icon-key"></i>&nbsp;':'') +
                            '<a href="<%=viewColumnUrl.toString()%>&_<%=portletName%>_resourcePrimKey=' + row.columnEntryId + '">'
                            + data + '</a>';
                    }
                },
                {
                    data: 'tableName',
                },
                {
                    data: 'databaseName'
                },
                {
                    data: 'description'
                }

            ],
            "autoWidth": true,
            "createdRow": function ( row, data, index ) {
                if ( data.isActive ) {
                    $(row).addClass('entry-active');
                }else{
                    $(row).addClass('entry-deprecated');
                }
            }
        };

        $(document).ready(function () {
            let columns_tbl = new DataTable('#columns_tbl', options);
            Liferay.Service({
                    '$column[databaseName,tableName,isActive, columnEntryId,columnName,description,isPrimaryKey,columnPosition] = /metacds.columnentry/get-table-columns':
                        {
                            tableEntryId: resourcePrimKey
                        }
                },
                function (obj) {
                    columns_tbl.clear();
                    columns_tbl.rows.add(obj).draw();
                }
            );

        });

    </script>
</liferay-util:html-top>