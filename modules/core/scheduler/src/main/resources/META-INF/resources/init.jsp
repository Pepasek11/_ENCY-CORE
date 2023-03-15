<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/clay" prefix="clay" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="com.liferay.taglib.search.ResultRow" %>
<%@ page import="cz.csob.ency.scheduler.constants.SchedulerConstants"%>
<%@ page import="cz.csob.ency.scheduler.job.SchedulerJob" %>


<%@ page import="java.util.List" %>
<%@ page import="com.liferay.petra.string.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>
<%@ page import="cz.csob.ency.scheduler.service.SchedulerUtil" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.text.Format" %>
<%@ page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %>
<%@ page import="cz.csob.ency.scheduler.web.display.context.ViewJobsManagementToolbarDisplayContext" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<c:set var="pns"><portlet:namespace/></c:set>

<%
String redirect = ParamUtil.getString(request, "redirect");
String currentURL = PortalUtil.getCurrentURL(request);
%>
