
<%@ include file="../init.jsp" %>

<%
    E3Entry entry = (E3Entry)request.getAttribute(E3WebKeys.ENTRY);
%>

<div class="asset-summary">
Full Asset TODO:
    <%
        AssetRenderer<?> assetRenderer = (AssetRenderer<?>)request.getAttribute(WebKeys.ASSET_RENDERER);
    %>

    <%= HtmlUtil.stripHtml(assetRenderer.getSummary(renderRequest, renderResponse)) %>
</div>