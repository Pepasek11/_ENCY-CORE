<%@ include file="init.jsp" %>
<%
    E3EntryDisplayContext context = (E3EntryDisplayContext)renderRequest.getAttribute(E3WebKeys.ENTRY_DISPLAY_CONTEXT);
%>
<hr/>
<liferay-portlet:runtime portletName="<%=context.getPortletId()%>"  />
<hr/>
