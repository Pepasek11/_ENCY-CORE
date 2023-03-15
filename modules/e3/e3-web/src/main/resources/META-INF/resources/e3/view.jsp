<%@ include file="init.jsp" %>

<%
    String mvcRenderCommandName = ParamUtil.getString(request, "mvcRenderCommandName");
    long assetCategoryId = ParamUtil.getLong(request, "categoryId");
    String assetTagName = ParamUtil.getString(request, "tag");
    boolean useAssetEntryQuery = (assetCategoryId > 0) || Validator.isNotNull(assetTagName);
    PortletURL portletURL = renderResponse.createRenderURL();
    portletURL.setParameter("mvcRenderCommandName", "/e3/view");
%>

<h3>View entries</h3>
<aui:input name="redirect" type="hidden" value="<%= currentURL %>"/>

<%

%>


<%@ include file="view_entries.jspf" %>