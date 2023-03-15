<%@ page import="com.liferay.asset.kernel.model.AssetTag" %>
<%@ page import="com.liferay.asset.kernel.service.AssetTagLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="cz.csob.ency.modules.e3.entry.model.E3Entry" %>
<%@ page import="java.util.List" %>

<%@ page import="cz.csob.ency.modules.e3.entry.internal.security.permission.resource.E3EntryModelPermission" %>
<%@ page import="cz.csob.ency.modules.e3.entry.internal.security.permission.resource.E3PortletPermission" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys" %>

<%@ include file="../init.jsp" %>
<%
    String  bodyContentString = GetterUtil.getString(
            request.getAttribute("e3-ui:entry:body"),
            StringPool.BLANK
    );
    String action = GetterUtil.getString((String)request.getAttribute("e3-ui:entry:action"));
    String appClass = GetterUtil.getString((String)request.getAttribute("e3-ui:entry:appClass"));
    String cssClass = GetterUtil.getString((String)request.getAttribute("e3-ui:entry:cssClass"));
    long entryId = GetterUtil.getLong(request.getAttribute("e3-ui:entry:entryId"));
    String entryName = GetterUtil.getString((String)request.getAttribute("e3-ui:entry:entryName"));
    String entryExtendedName = GetterUtil.getString((String)request.getAttribute("e3-ui:entry:entryExtendedName"));
    String userName = GetterUtil.getString((String)request.getAttribute("e3-ui:entry:userName"));
    String authorName = GetterUtil.getString((String)request.getAttribute("e3-ui:entry:authorName"));
    boolean escapeXml = GetterUtil.getBoolean(String.valueOf(request.getAttribute("e3-ui:entry:escapeXml")));
    boolean inlineLabels = GetterUtil.getBoolean(String.valueOf(request.getAttribute("e3-ui:entry:inlineLabels")));
    String method = GetterUtil.getString((String)request.getAttribute("e3-ui:entry:method"), "post");
    String name = GetterUtil.getString((String)request.getAttribute("e3-ui:entry:name"), "fm");
    String onSubmit = GetterUtil.getString((String)request.getAttribute("e3-ui:entry:onSubmit"));
    String portletNamespace = GetterUtil.getString((String)request.getAttribute("e3-ui:entry:portletNamespace"));
    boolean useNamespace = GetterUtil.getBoolean(String.valueOf(request.getAttribute("e3-ui:entry:useNamespace")), true);
    boolean validateOnBlur = GetterUtil.getBoolean(String.valueOf(request.getAttribute("e3-ui:entry:validateOnBlur")), true);
    Map<String, Object> dynamicAttributes = (Map<String, Object>)request.getAttribute("e3-ui:entry:dynamicAttributes");

    PortalUtil.addPortletBreadcrumbEntry(request,entryName,currentURL);

    List<AssetTag> assetTags =
            AssetTagLocalServiceUtil.getTags(appClass, entryId);
    PortalUtil.setPageKeywords(ListUtil.toString(assetTags, "name"), request);
%>
