<%@ page import="com.liferay.portal.kernel.comment.Discussion" %>
<%@ page import="com.liferay.portal.kernel.comment.CommentManagerUtil" %>
<%@ page import="com.liferay.portal.kernel.service.ServiceContextFunction" %>
<%@ include file="init.jsp" %>


<portlet:renderURL var="redirect">
    <portlet:param name="mvcRenderCommandName" value="/e3/view"/>
</portlet:renderURL>

<portlet:renderURL var="editEntryURL">
    <portlet:param name="mvcRenderCommandName" value="/e3/edit_entry"/>
    <portlet:param name="<%=Constants.CMD%>" value="<%=Constants.UPDATE%>"/>
    <portlet:param name="entryId" value="<%=String.valueOf(entryId)%>"/>
    <portlet:param name="redirect" value="<%=currentURL%>"/>
</portlet:renderURL>

<portlet:actionURL name="/e3/edit_entry" var="deleteEntryURL">
    <portlet:param name="<%=Constants.CMD%>" value="<%=Constants.DELETE%>"/>
    <portlet:param name="entryId" value="<%= String.valueOf(entryId) %>"/>
    <portlet:param name="redirect" value="<%=redirect%>"/>
</portlet:actionURL>

<%
    portletDisplay.setShowBackIcon(true);
    portletDisplay.setURLBack(redirect);
%>


<clay:container-fluid
        cssClass="widget-mode-detail-header"
>
    <clay:row>
        <clay:col cssClass="mx-auto" md="12">
            <clay:content-row>
                <clay:content-col expand="<%= true %>">
                    <h3 class="title">
                        <%= HtmlUtil.escape(entryName) %>
                    </h3>

                    <%
                        String subtitle = "";
                    %>

                    <c:if test="<%= Validator.isNotNull(subtitle) %>">
                        <h4 class="sub-title">
                            <%= HtmlUtil.escape(subtitle) %>
                        </h4>
                    </c:if>
                </clay:content-col>

                <clay:content-col cssClass=""> <%--"visible-interaction"> --%>
                    <div class="dropdown dropdown-action">
                            <%--
                            <c:if test="<%= E3EntryModelPermission.contains(permissionChecker, entryId, ActionKeys.UPDATE) %>">
                            --%>
                        <a href="<%= editEntryURL %>">
                            <clay:icon symbol="pencil"/>
                            <span><liferay-ui:message key="edit"/></span>
                        </a>
                        <a href="<%= deleteEntryURL %>">
                            <clay:icon symbol="trash"/>
                            <span><liferay-ui:message key="delete"/></span>
                        </a>
                            <%--
                                 </c:if>
                                 --%>
                        <c:if test="<%=E3EntryModelPermission.contains(permissionChecker, entryId, ActionKeys.PERMISSIONS)
                                 || request.isUserInRole("power-user")%>">

                            <liferay-security:permissionsURL
                                    modelResource="<%= E3Entry.class.getName() %>"
                                    modelResourceDescription="<%= entryName %>"
                                    resourcePrimKey="<%= String.valueOf(entryId) %>"
                                    var="permissionsURL"/>

                            <a href="<%=permissionsURL %>">
                                <clay:icon symbol="add-role"/>
                                <span><liferay-ui:message key="permissions"/></span>
                            </a>
                        </c:if>

                    </div>
                </clay:content-col>
            </clay:content-row>
        </clay:col>
    </clay:row>
</clay:container-fluid>

<clay:container-fluid>
    <clay:row>
        <clay:col
                cssClass="mx-auto widget-mode-detail-text"
                md="12"
        >
            <%=bodyContentString%>
        </clay:col>
    </clay:row>
</clay:container-fluid>

<clay:container-fluid>
    <clay:row>
        <clay:col
                cssClass="mx-auto widget-mode-detail-text"
                md="12"
        >
            <liferay-ui:panel-container extended="<%=false%>"
                                        id="e3CollaborationPanelContainer" persistState="<%=true%>">
                <liferay-ui:panel collapsible="<%=true%>" extended="<%=true%>"
                                  id="e3CollaborationPanel" persistState="<%=true%>"
                                  title="Collaboration">

                    <liferay-ratings:ratings className="<%=E3Entry.class.getName()%>"
                                             classPK="<%=entryId%>" type="stars"/>

                    <br/>
                    <%

                        Discussion discussion = null;

                        try {
                            discussion = CommentManagerUtil.getDiscussion(user.getUserId(),
                                    scopeGroupId, E3Entry.class.getName(),
                                    entryId, new ServiceContextFunction(request));
                        } catch (Exception e) {
                        }
                    %>

                    <c:if test="<%= discussion != null %>">
                        <h2>
                            <strong><liferay-ui:message
                                    arguments="<%= discussion.getDiscussionCommentsCount() %>"
                                    key='<%= (discussion.getDiscussionCommentsCount() == 1) ? "x-comment" : "x-comments" %>'/></strong>
                        </h2>
                        <liferay-comment:discussion
                                className="<%= E3Entry.class.getName() %>"
                                classPK="<%= entryId %>"
                                discussion="<%= discussion %>"
                                formName="fm2"
                                ratingsEnabled="false"
                                redirect="<%= currentURL %>"
                                userId="<%= user.getUserId() %>"
                        />
                    </c:if>
                </liferay-ui:panel>
            </liferay-ui:panel-container>
        </clay:col>
    </clay:row>
</clay:container-fluid>
