<%@ page import="com.liferay.portal.kernel.util.*" %>
<%@ include file="init.jsp" %>

<%-- @todo predavat si redirect adresu pres request attribute a tohle jenom jako backup--%>
<portlet:renderURL var="redirectURL">
    <c:choose>
        <c:when test="<%=entryId!=0%>">
            <portlet:param name="mvcRenderCommandName" value="/e3/view_entry"/>
            <portlet:param name="entryId" value="<%=String.valueOf(entryId)%>"/>
        </c:when>
        <c:otherwise>
            <portlet:param name="mvcRenderCommandName" value="/e3/view"/>
        </c:otherwise>
    </c:choose>
</portlet:renderURL>

<%
    portletDisplay.setShowBackIcon(true);
    portletDisplay.setURLBack(redirectURL);
%>


<portlet:actionURL name="/e3/edit_entry" var="addEntryURL">
    <c:choose>
        <c:when test="<%=entryId>0%>">
            <portlet:param name="<%=Constants.CMD%>" value="<%=Constants.UPDATE%>"/>
        </c:when>
        <c:otherwise>
            <portlet:param name="<%=Constants.CMD%>" value="<%=Constants.ADD%>"/>
        </c:otherwise>
    </c:choose>
</portlet:actionURL>
<aui:container id="" cssClass="" fluid="false">
    <aui:form
            cssClass="<%=cssClass%>"
            name="<%=name%>"
            action="<%=((action!=null&&action.length()>0)?action:addEntryURL)%>"
            escapeXml="<%=escapeXml%>"
            inlineLabels="<%=inlineLabels%>"
            method="<%=method%>"
            onSubmit="<%=onSubmit%>"
            portletNamespace="<%=portletNamespace%>"
            useNamespace="<%=useNamespace%>"
            validateOnBlur="<%=validateOnBlur%>"
    >
        <liferay-ui:panel-container>
            <input name="<portlet:namespace/>entryId" type="hidden" value="<%=entryId%>"/>
            <input name="<portlet:namespace/>appClass" type="hidden" value="<%=appClass%>"/>
            <aui:input name="<%=namespace+"entryName"%>" type="text" value="<%=entryName%>"
                       placeholder="Entry name" label="entry-name"/>
            <liferay-ui:panel id="e3_entry_body" title="" collapsible="false"
                              extended="true">
                <%=bodyContentString%>
            </liferay-ui:panel>


            <liferay-ui:panel id="e3_entry_actions" title="" collapsible="false"
                              extended="true">
                <aui:button-row>
                    <aui:button type="submit"></aui:button>
                    <aui:button type="cancel" onClick="<%= redirectURL.toString() %>"></aui:button>
                </aui:button-row>
            </liferay-ui:panel>
        </liferay-ui:panel-container>
    </aui:form>
</aui:container>