<%@ include file="./init.jsp" %>

<%

    String viewUsersRedirect = ParamUtil.getString(request, "viewUsersRedirect");
    String backURL = ParamUtil.getString(request, "backURL", redirect);

	String portletURL = renderResponse.createRenderURL().toString();

    List<SchedulerJob> schedulerJobs = (List<SchedulerJob>) request.getAttribute("schedulerJobsList");
    
    String displayStyle = ParamUtil.getString(request, "displayStyle");
    
	/* Sorting */
	String orderByCol = ParamUtil.getString(request, "orderByCol");
	String orderByType = ParamUtil.getString(request, "orderByType");
	
	if (orderByCol == null || orderByCol.equals(StringPool.BLANK)) {
	    orderByCol = SchedulerConstants.DEFAULT_ORDER_BY_COL;
	}

	if (orderByType == null || orderByType.equals(StringPool.BLANK)) {
	    orderByType = SchedulerConstants.DEFAULT_ORDER_BY_TYPE;
	}
	OrderByComparator orderByComparator = SchedulerUtil.getSchedulerJobComparator(orderByCol, orderByType);
	Collections.sort(schedulerJobs, orderByComparator);
	Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);

	ViewJobsManagementToolbarDisplayContext viewJobsManagementToolbarDisplayContext
	    = new ViewJobsManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse);

%>

<c:set var="jobselectedparam" value ="<%=SchedulerConstants.PARAMETER_JOB_SELECTED %>"/>
<c:set var="jobnameparam" value ="<%=SchedulerConstants.PARAMETER_JOB_NAME %>"/>
<c:set var="jobgroupparam" value ="<%=SchedulerConstants.PARAMETER_JOB_GROUP %>"/>
<c:set var="jobstoragetypeparam" value ="<%=SchedulerConstants.PARAMETER_STORAGE_TYPE %>"/>
<c:set var="runSupported" value="<%=SchedulerUtil.checkRunSupported() %>"/>

<portlet:renderURL var="addRoleRenderURL">
	<portlet:param name="mvcPath" value="/edit_job.jsp" />
	<portlet:param name="backURL" value="<%= backURL %>" />
</portlet:renderURL>

<div id=schedulerJobsContainer class="custom-scheduled">
	    <portlet:actionURL var="jobActionURL" name="jobAction"></portlet:actionURL>
        <aui:form name ="jobsActionsForm" action="${jobActionURL}" method="post">
            <clay:management-toolbar
                displayContext="<%= viewJobsManagementToolbarDisplayContext %>"
                searchContainerId="schedulerJobListContainer"
                selectable="<%=true%>"
            />

			<liferay-ui:search-container delta="10" deltaConfigurable="<%= true %>" id="schedulerJobListContainer"
			emptyResultsMessage="scheduled.job.manager.empty" total="<%= schedulerJobs.size() %>" orderByCol="<%= orderByCol %>"
			orderByType="<%= orderByType %>">

				<liferay-ui:search-container-results
				    results="<%= SchedulerUtil.getScheduledJobs(schedulerJobs, searchContainer.getStart(), searchContainer.getEnd()) %>" />

					<liferay-ui:search-container-row className="cz.csob.ency.scheduler.job.SchedulerJobImpl" modelVar="SchedulerJob">

						<liferay-ui:search-container-column-text name="short-name"  >
				                ${SchedulerJob.shortName}
				                <aui:input name="${jobnameparam}${index}" type="hidden" value="${SchedulerJob.jobName}"/>
				        </liferay-ui:search-container-column-text>
				        <liferay-ui:search-container-column-text name="group-name" cssClass="hidden-phone hidden-tablet" >
				                ${SchedulerJob.shortGroup}
				                <aui:input name="${jobgroupparam}${index}" type="hidden" value="${SchedulerJob.groupName}"/>
				        </liferay-ui:search-container-column-text>
				        <liferay-ui:search-container-column-text name="status">
				                ${SchedulerJob.triggerState}
				        </liferay-ui:search-container-column-text>
				        <liferay-ui:search-container-column-text name="start-time" orderable="true" orderableProperty="startTime">
				                <%= SchedulerJob.getStartTime() == null ? '-' : dateFormatDateTime.format(SchedulerJob.getStartTime()) %>
				        </liferay-ui:search-container-column-text>
				        <liferay-ui:search-container-column-text name="termination-time" cssClass="hidden-phone hidden-tablet" >
				                <%= SchedulerJob.getEndTime() == null ? '-' : dateFormatDateTime.format(SchedulerJob.getEndTime()) %>
				        </liferay-ui:search-container-column-text>
				        <liferay-ui:search-container-column-text name="previous-fire-time" cssClass="hidden-phone hidden-tablet">
				                <%= SchedulerJob.getPreviousFireTime() == null ? '-' : dateFormatDateTime.format(SchedulerJob.getPreviousFireTime()) %>
				        </liferay-ui:search-container-column-text>
				        <liferay-ui:search-container-column-text name="next-fire-time" >
				                <%= SchedulerJob.getNextFireTime() == null ? '-' : dateFormatDateTime.format(SchedulerJob.getNextFireTime()) %>
				        </liferay-ui:search-container-column-text>
				        <liferay-ui:search-container-column-text name="storage-type"  cssClass="hidden-phone hidden-tablet">
				                ${SchedulerJob.storageType}
				                <aui:input name="${jobstoragetypeparam}${index}" type="hidden" value="${SchedulerJob.storageType}"/>
				        </liferay-ui:search-container-column-text>
                        <liferay-ui:search-container-column-jsp
                            align="right"
                            path="/row_actions.jsp" />

					</liferay-ui:search-container-row>

				<liferay-ui:search-iterator displayStyle="<%= displayStyle %>" markupView="lexicon" paginate="<%= true %>" />

			</liferay-ui:search-container>
		</aui:form>
	</div>
</div>

<aui:script use ="scheduledjobutil">



</aui:script>