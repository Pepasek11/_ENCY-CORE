<%@ include file="/init.jsp" %>

<%
    SystemEntry systemEntry = (SystemEntry) request.getAttribute("systemEntry");
    String redirect = ParamUtil.getString(request, "redirect");
    boolean fromAsset = ParamUtil.getBoolean(request, "fromAsset", false);
    portletDisplay.setTitle("Meta CDS Table: " + systemEntry.getSystemName() + " [" + systemEntry.getSystemCode() + "]");
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
                    <h2 class="title"><%= HtmlUtil.escape(systemEntry.getSystemName()) %>
                    </h2>

                    <%
                        String subtitle = systemEntry.getSystemTitle();
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
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a class="breadcrumb-link" href="<%=rootUrl%>"
                       title="<liferay-ui:message key="meta-cds-systems"/>">
                        <span class="breadcrumb-text-truncate"><liferay-ui:message key="meta-cds-systems"/></span>
                    </a>
                </li>
                <li class="active breadcrumb-item">
                    <span class="breadcrumb-text-truncate" title="<%=systemEntry.getSystemName()%>">
                        <%=systemEntry.getSystemName()%></span>
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
                        <label><liferay-ui:message key="systementryid"/></label>
                        <div class="e3-ro-form-item"><%=systemEntry.getSystemEntryId()%>
                        </div>
                    </div>
                    <div class="flex-item">
                        <label><liferay-ui:message key="systemcode"/></label>
                        <div class="e3-ro-form-item"><%=systemEntry.getSystemCode()%>
                        </div>
                    </div>
                    <div class="flex-item">
                        <label><liferay-ui:message key="systemname"/></label>
                        <div class="e3-ro-form-item"><%=systemEntry.getSystemName()%>
                        </div>
                    </div>
                    <div class="flex-item">
                        <label><liferay-ui:message key="systemtitle"/></label>
                        <div class="e3-ro-form-item"><%=systemEntry.getSystemTitle()%>
                        </div>
                    </div>
                    <div class="flex-item">
                        <label><liferay-ui:message key="systemtype"/></label>
                        <div class="e3-ro-form-item"><%=systemEntry.getSystemTitle()%>
                        </div>
                    </div>
                    <div class="flex-item">
                        <label><liferay-ui:message key="role"/></label>
                        <div class="e3-ro-form-item"><%=systemEntry.getRole()%>
                        </div>
                    </div>
                    <div class="flex-item">
                        <label><liferay-ui:message key="snowassettagname"/></label>
                        <div class="e3-ro-form-item"><%=systemEntry.getSnowAssetTagName()%>
                        </div>
                    </div>
                </div>
                <div class="flex-box fbjcl">
                    <div class="flex-item">
                        <label><liferay-ui:message key="isselfbi"/></label>
                        <clay:checkbox name="isslasigned"
                                       checked="<%=systemEntry.getIsSelfBi()%>"
                                       disabled="true"
                        />
                    </div>
                    <div class="flex-item">
                        <label><liferay-ui:message key="isslasigned"/></label>
                        <clay:checkbox name="isslasigned"
                                       checked="<%=systemEntry.getIsSlaSigned()%>"
                                       disabled="true"
                        />
                    </div>
                    <div class="flex-item">
                        <label><liferay-ui:message key="isactive"/></label>
                        <clay:checkbox name="isslasigned"
                                       checked="<%=systemEntry.getIsActive()%>"
                                       disabled="true"
                        />
                    </div>
                </div>
                <div class="flex-box ">
                    <div class="flex-item" style="min-width:100%">
                        <label><liferay-ui:message key="description"/></label>
                        <div class="e3-ro-form-item"><%=systemEntry.getDescription()%>
                        </div>
                    </div>
                </div>

            </liferay-ui:panel>
        </clay:col>
        <clay:col md="4" sm="12">
            <liferay-ui:panel title="governance" collapsible="false" iconCssClass="icon-user" extended="true">
                <div class="flex-item">
                    <label><liferay-ui:message key="businessownername"/></label>
                    <div class="e3-ro-form-item"><%=systemEntry.getBusinessOwnerName()%>
                    </div>
                </div>
                <div class="flex-item">
                    <label><liferay-ui:message key="gestordepartmentname"/></label>
                    <div class="e3-ro-form-item"><%=systemEntry.getGestorDepartmentName()%>
                    </div>
                </div>
                <div class="flex-item">
                    <label><liferay-ui:message key="stewardname"/></label>
                    <p class="e3-ro-form-item"><%=systemEntry.getStewardName()%>
                    </p>
                </div>
                <div class="flex-item">
                    <label><liferay-ui:message key="stewarddepartment"/></label>
                    <p class="e3-ro-form-item"><%=systemEntry.getStewardDepartment()%>
                    </p>
                </div>
                <div class="flex-item">
                    <label><liferay-ui:message key="contactpersonname"/></label>
                    <p class="e3-ro-form-item"><%=systemEntry.getContactPersonName()%>
                    </p>
                </div>
            </liferay-ui:panel>
        </clay:col>
    </clay:row>


    <%
        String iconCssClass = "icon-table";
        String tableTitle = "";
        String tableId = "";
    %>

    <% tableId = "tables_tbl";
        tableTitle = "tables"; %>
    <%@ include file="./fragments/system_tables_block.jsp" %>

    <% tableId = "views_tbl";
        tableTitle = "views"; %>
    <%@ include file="./fragments/system_tables_block.jsp" %>

    <% tableId = "stage_tbl";
        tableTitle = "stage-extracts"; %>
    <%@ include file="./fragments/system_tables_block.jsp" %>

    <% tableId = "files_tbl";
        tableTitle = "etl-files";
        iconCssClass = "icon-file"; %>
    <%@ include file="./fragments/system_tables_block.jsp" %>

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
                        className="<%= SystemEntry.class.getName() %>"
                        classPK="<%= systemEntry.getPrimaryKey() %>"
                        formName="fm2"
                        ratingsEnabled="<%= true %>"
                        redirect="<%= currentURL %>"
                        userId="<%= systemEntry.getUserId() %>"
                />
            </liferay-ui:panel>
        </clay:content-col>
    </clay:content-row>
</clay:container>


<portlet:renderURL var="viewTableUrl">
    <portlet:param name="mvcRenderCommandName" value="/tableentry/crud"/>
    <portlet:param name="<%= Constants.CMD %>" value="<%= Constants.VIEW %>"
    />
</portlet:renderURL>

<liferay-util:html-top>
    <%@ include file="../datatables_include.jsp" %>

    <script>
        var resourcePrimKey = <%=systemEntry.getPrimaryKey()%>;
        var options = {
            data: [],
            columns: [
                {
                    data: 'tableName',
                    render: function (data, type, row) {
                        return '<a href="<%=viewTableUrl.toString()%>&_<%=portletName%>_resourcePrimKey=' + row.tableEntryId + '">' + data + '</a>';
                    }
                },
                {
                    data: 'tableDatabase'
                },
                {data: 'description'},
                {
                    data: 'dsaUrl',
                    orderable: false,
                    render: function (data, type) {
                        if (type === 'display') {
                            return '<a href="' + data + '" class="extlink" target="_blank"><liferay-ui:message key="open-in-dsa" />&nbsp;<i class="icon-external-link"></i></a>';
                        }
                        return data;
                    }
                }
            ],
            "autoWidth": true,
            "createdRow": function (row, data, index) {
                if (data.isActive) {
                    $(row).addClass('entry-active');
                } else {
                    $(row).addClass('entry-deprecated');
                }
            }

        };

        $(document).ready(function () {
            let tables_tbl = new DataTable('#tables_tbl', options);
            Liferay.Service({
                    '$table[tableDatabase,tableName,tableEntryId,isActive,dsaUrl,description] = /metacds.tableentry/get-system-tables':
                        {
                            systemEntryId: resourcePrimKey,
                            type: 'tables'
                        }
                },
                function (obj) {
                    tables_tbl.clear();
                    tables_tbl.rows.add(obj).draw();
                }
            );

            let views_tbl = new DataTable('#views_tbl', options);
            Liferay.Service({
                    '$table[tableDatabase,tableName,tableEntryId,isActive,dsaUrl,description] = /metacds.tableentry/get-system-tables':
                        {
                            systemEntryId: resourcePrimKey,
                            type: 'views'
                        }
                },
                function (obj) {
                    views_tbl.clear();
                    views_tbl.rows.add(obj).draw();
                }
            );

            let stage_tbl = new DataTable('#stage_tbl', options);
            Liferay.Service({
                    '$table[tableDatabase,tableName,tableEntryId,isActive,dsaUrl,description] = /metacds.tableentry/get-system-tables':
                        {
                            systemEntryId: resourcePrimKey,
                            type: 'stage'
                        }
                },
                function (obj) {
                    stage_tbl.clear();
                    stage_tbl.rows.add(obj).draw();
                }
            );

            let files_tbl = new DataTable('#files_tbl', options);
            Liferay.Service({
                    '$table[tableDatabase,tableName,tableEntryId,isActive,dsaUrl,description] = /metacds.tableentry/get-system-tables':
                        {
                            systemEntryId: resourcePrimKey,
                            type: 'files'
                        }
                },
                function (obj) {
                    files_tbl.clear();
                    files_tbl.rows.add(obj).draw();
                }
            );
        });

    </script>
</liferay-util:html-top>
