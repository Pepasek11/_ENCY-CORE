<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/asset" prefix="liferay-asset" %><%@
        taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
        taglib uri="http://liferay.com/tld/clay" prefix="clay" %><%@
        taglib uri="http://liferay.com/tld/comment" prefix="liferay-comment" %><%@
        taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %><%--<%@
        taglib uri="http://liferay.com/tld/editor" prefix="liferay-editor" %>--%><%@
        taglib uri="http://liferay.com/tld/expando" prefix="liferay-expando" %><%@
        taglib uri="http://liferay.com/tld/flags" prefix="liferay-flags" %><%@
        taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
        taglib uri="http://liferay.com/tld/item-selector" prefix="liferay-item-selector" %><%@
        taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
        taglib uri="http://liferay.com/tld/ratings" prefix="liferay-ratings" %><%@
        taglib uri="http://liferay.com/tld/reading-time" prefix="liferay-reading-time" %><%@
        taglib uri="http://liferay.com/tld/rss" prefix="liferay-rss" %><%@
        taglib uri="http://liferay.com/tld/social-bookmarks" prefix="liferay-social-bookmarks" %><%@
        taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
        taglib uri="http://liferay.com/tld/trash" prefix="liferay-trash" %><%@
        taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
        taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.asset.constants.AssetWebKeys" %>
<%@ page import="com.liferay.asset.kernel.model.AssetRenderer" %>
<%@ page import="com.liferay.asset.util.AssetHelper" %>
<%@ page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.*" %>

<%@ page import="java.text.Format" %>
<%@ page import="javax.portlet.PortletURL" %>

<%@ page import="cz.csob.ency.modules.e3.entry.model.E3Entry" %>
<%@ page import="cz.csob.ency.modules.e3.entry.service.E3EntryLocalServiceUtil" %>
<%@ page import="cz.csob.ency.modules.e3.web.context.E3EntryDisplayContext" %>
<%@ page import="cz.csob.ency.modules.e3.web.util.E3EntryUtil" %>
<%@ page import="cz.csob.ency.modules.e3.web.constants.E3WebKeys" %>


<liferay-frontend:defineObjects />
<liferay-theme:defineObjects />
<liferay-trash:defineObjects />
<portlet:defineObjects />

<%
    AssetHelper assetHelper = (AssetHelper)request.getAttribute(AssetWebKeys.ASSET_HELPER);
    Format dateFormatDate = FastDateFormatFactoryUtil.getDate(locale, timeZone);
%>