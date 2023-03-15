<%@ taglib prefix="chart" uri="http://liferay.com/tld/chart" %>
<%@ page import="com.liferay.frontend.taglib.chart.model.SingleValueColumn" %>
<%@ page import="com.liferay.frontend.taglib.chart.model.gauge.GaugeChartConfig" %>
<%@ page import="com.liferay.portal.kernel.backgroundtask.BackgroundTask" %>
<%@ page import="com.liferay.portal.kernel.backgroundtask.BackgroundTaskManagerUtil" %>
<%@ page import="com.liferay.portal.kernel.backgroundtask.constants.BackgroundTaskConstants" %>
<%@ page import="com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay" %>
<%@ page import="com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplayFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.model.CompanyConstants" %>
<%@ page import="cz.csob.ency.modules.apps.meta.cds.internal.background.task.MetaCdsLoaderBackgroundTaskExecutor" %>
<%@ page import="java.util.List" %>

<%@ include file="/init.jsp" %>

<%
    String redirect = ParamUtil.getString(request, "redirect");
    portletDisplay.setShowBackIcon(true);
    portletDisplay.setURLBack(redirect);

%>

<clay:container cssClass="e3-container container-fluid main-content-body">
    <clay:content-row>
        <clay:content-col expand="true">
            <liferay-ui:panel title="actions" collapsible="false" iconCssClass="icon-cogs" extended="true">
                <%
                    List<BackgroundTask> backgroundTasks = BackgroundTaskManagerUtil.getBackgroundTasks(CompanyConstants.SYSTEM, MetaCdsLoaderBackgroundTaskExecutor.class.getName(), BackgroundTaskConstants.STATUS_IN_PROGRESS);
                    BackgroundTaskDisplay backgroundTaskDisplay = null;
                    BackgroundTask backgroundTask = null;
                    if (backgroundTasks != null && backgroundTasks.size() > 0) {
                        backgroundTaskDisplay = BackgroundTaskDisplayFactoryUtil.getBackgroundTaskDisplay(backgroundTasks.get(0));
                    }

                %>
                <c:choose>
                    <c:when test="<%= (backgroundTaskDisplay == null) || !backgroundTaskDisplay.hasPercentage() %>">

                        <portlet:actionURL name="/systementry/crud" var="importEntriesURL">
                            <portlet:param name="<%= Constants.CMD %>" value="<%= Constants.IMPORT %>"/>
                            <portlet:param name="redirect" value="<%= currentURL %>"/>
                        </portlet:actionURL>

                        <a href="<%=importEntriesURL.toString()%>" class="btn btn-primary">
                            <liferay-ui:message key="import-all"/></a>

                        <portlet:actionURL name="/systementry/crud" var="importEntriesURL">
                            <portlet:param name="<%= Constants.CMD %>" value="<%= Constants.IMPORT %>"/>
                            <portlet:param name="redirect" value="<%= currentURL %>"/>
                        </portlet:actionURL>

                        <a href="<%=importEntriesURL.toString()%>" class="btn btn-secondary">
                            <liferay-ui:message key="import-systems"/></a>

                        <portlet:actionURL name="/tableentry/crud" var="importEntriesURL">
                            <portlet:param name="<%= Constants.CMD %>" value="<%= Constants.IMPORT %>"/>
                            <portlet:param name="redirect" value="<%= currentURL %>"/>
                        </portlet:actionURL>

                        <a href="<%=importEntriesURL.toString()%>" class="btn btn-secondary">
                            <liferay-ui:message key="import-tabless"/></a>

                        <portlet:actionURL name="/columnentry/crud" var="importEntriesURL">
                            <portlet:param name="<%= Constants.CMD %>" value="<%= Constants.IMPORT %>"/>
                            <portlet:param name="redirect" value="<%= currentURL %>"/>
                        </portlet:actionURL>

                        <a href="<%=importEntriesURL.toString()%>" class="btn btn-secondary">
                            <liferay-ui:message key="import-columns"/></a>
                    </c:when>
                    <c:otherwise>
                        <%=backgroundTaskDisplay.getStatusLabel()%>
                        <%=backgroundTaskDisplay.renderDisplayTemplate()%>
                    </c:otherwise>
                </c:choose>

            </liferay-ui:panel>
            <liferay-ui:panel title="stats" collapsible="false" iconCssClass="icon-bar-chart" extended="false">
                <clay:container fluid="true">
                    <%
                        GaugeChartConfig _gaugeChartConfig = new GaugeChartConfig();

                        _gaugeChartConfig.addColumn(
                                new SingleValueColumn("data1", 85.4)
                        );

                    %>
                    <chart:gauge
                            config="<%= _gaugeChartConfig %>"
                    />
                </clay:container>
            </liferay-ui:panel>

        </clay:content-col>
    </clay:content-row>
</clay:container>
