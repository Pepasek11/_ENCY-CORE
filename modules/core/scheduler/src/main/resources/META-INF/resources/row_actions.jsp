<%@include file="./init.jsp"%>
<%
    String mvcPath = ParamUtil.getString(request, "mvcPath");
    ResultRow row = (ResultRow) request.getAttribute("SEARCH_CONTAINER_RESULT_ROW");
    SchedulerJob schedulerJob = (SchedulerJob) row.getObject();
%>

<liferay-ui:icon-menu>

    <portlet:renderURL var="editURL">

        <portlet:param name="mvcPath"
            value="/admin/edit.jsp" />
    </portlet:renderURL>

    <liferay-ui:icon image="edit" message="Edit"
            url="<%=editURL.toString() %>" />

    <portlet:actionURL name="jobAction" var="runURL">
             <portlet:param name="<%=SchedulerConstants.PARAMETER_JOB_ACTION %>"
                        value="<%=SchedulerConstants.ACTION_RUN %>" />
             <portlet:param name="<%=SchedulerConstants.PARAMETER_JOB_NAME %>"
                        value="<%=String.valueOf(schedulerJob.getJobName()) %>" />
             <portlet:param name="<%=SchedulerConstants.PARAMETER_JOB_GROUP %>"
                        value="<%=String.valueOf(schedulerJob.getGroupName()) %>" />
             <portlet:param name="<%=SchedulerConstants.PARAMETER_STORAGE_TYPE %>"
                        value="<%=String.valueOf(schedulerJob.getStorageType()) %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="forward" url="<%=runURL.toString() %>" label="run" />

    <portlet:actionURL name="jobAction" var="runURL">
             <portlet:param name="<%=SchedulerConstants.PARAMETER_JOB_ACTION %>"
                        value="<%=SchedulerConstants.ACTION_RESUME %>" />
             <portlet:param name="<%=SchedulerConstants.PARAMETER_JOB_NAME %>"
                        value="<%=String.valueOf(schedulerJob.getJobName()) %>" />
             <portlet:param name="<%=SchedulerConstants.PARAMETER_JOB_GROUP %>"
                        value="<%=String.valueOf(schedulerJob.getGroupName()) %>" />
             <portlet:param name="<%=SchedulerConstants.PARAMETER_STORAGE_TYPE %>"
                        value="<%=String.valueOf(schedulerJob.getStorageType()) %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="activate" url="<%=runURL.toString() %>" label="resume"/>

    <portlet:actionURL name="jobAction" var="runURL">
             <portlet:param name="<%=SchedulerConstants.PARAMETER_JOB_ACTION %>"
                        value="<%=SchedulerConstants.ACTION_PAUSE %>" />
             <portlet:param name="<%=SchedulerConstants.PARAMETER_JOB_NAME %>"
                        value="<%=String.valueOf(schedulerJob.getJobName()) %>" />
             <portlet:param name="<%=SchedulerConstants.PARAMETER_JOB_GROUP %>"
                        value="<%=String.valueOf(schedulerJob.getGroupName()) %>" />
             <portlet:param name="<%=SchedulerConstants.PARAMETER_STORAGE_TYPE %>"
                        value="<%=String.valueOf(schedulerJob.getStorageType()) %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="deactivate" url="<%=runURL.toString() %>" label="pause"/>

    <portlet:actionURL name="jobAction" var="runURL">
             <portlet:param name="<%=SchedulerConstants.PARAMETER_JOB_ACTION %>"
                        value="<%=SchedulerConstants.ACTION_UNSCHEDULE %>" />
             <portlet:param name="<%=SchedulerConstants.PARAMETER_JOB_NAME %>"
                        value="<%=String.valueOf(schedulerJob.getJobName()) %>" />
             <portlet:param name="<%=SchedulerConstants.PARAMETER_JOB_GROUP %>"
                        value="<%=String.valueOf(schedulerJob.getGroupName()) %>" />
             <portlet:param name="<%=SchedulerConstants.PARAMETER_STORAGE_TYPE %>"
                        value="<%=String.valueOf(schedulerJob.getStorageType()) %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="delete" url="<%=runURL.toString() %>" label="unschedule"/>

</liferay-ui:icon-menu>