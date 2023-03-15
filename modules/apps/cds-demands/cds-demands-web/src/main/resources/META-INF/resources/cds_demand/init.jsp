
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@
		taglib uri="http://liferay.com/tld/asset" prefix="liferay-asset" %><%@
		taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
		taglib uri="http://liferay.com/tld/editor" prefix="liferay-editor" %><%@
		taglib uri="http://liferay.com/tld/clay" prefix="clay" %><%@
		taglib uri="http://liferay.com/tld/comment" prefix="liferay-comment" %><%@
		taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
		taglib uri="http://liferay.com/tld/item-selector" prefix="liferay-item-selector" %><%@
		taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
		taglib uri="http://liferay.com/tld/ratings" prefix="liferay-ratings" %><%@
		taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %><%@
		taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
		taglib uri="http://liferay.com/tld/trash" prefix="liferay-trash" %><%@
		taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
		taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@
		page import="com.liferay.asset.constants.AssetWebKeys" %><%@
		page import="com.liferay.asset.util.AssetHelper" %><%@
		page import="com.liferay.portal.kernel.dao.search.*" %><%@
		page import="com.liferay.portal.kernel.language.*" %><%@
		page import="com.liferay.portal.kernel.portlet.*" %><%@
		page import="com.liferay.portal.kernel.security.permission.ActionKeys" %><%@
		page import="com.liferay.portal.kernel.util.*" %><%@
		page import="com.liferay.portal.kernel.workflow.*" %><%@
		page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPNavigationItemList" %><%@
		page import="cz.csob.ency.cds.demands.model.CdsDemand" %><%@
		page import="cz.csob.ency.cds.demands.web.internal.constants.*" %><%@
		page import="cz.csob.ency.cds.demands.web.internal.constants.CdsDemandWebKeys" %><%@
		page import="cz.csob.ency.cds.demands.web.internal.security.permission.resource.*" %><%@
		page import="com.liferay.petra.string.StringPool" %><%@
		page import="cz.csob.ency.cds.demands.internal.util.RenderHelperUtils" %><%@
		page import="cz.csob.ency.cds.demands.service.CdsDemandLocalServiceUtil" %>

<%@ taglib uri="http://liferay.com/tld/react" prefix="react" %>

<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="java.util.Map" %>

<liferay-frontend:defineObjects />
<liferay-theme:defineObjects />
<portlet:defineObjects />

