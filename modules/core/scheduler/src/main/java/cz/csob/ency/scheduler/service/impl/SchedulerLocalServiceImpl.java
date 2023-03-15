package cz.csob.ency.scheduler.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBus;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.scheduler.*;
import com.liferay.portal.kernel.scheduler.messaging.SchedulerResponse;
import com.liferay.portal.kernel.security.RandomUtil;
import com.liferay.portal.kernel.util.*;
import cz.csob.ency.scheduler.constants.SchedulerConstants;
import cz.csob.ency.scheduler.job.SchedulerJob;
import cz.csob.ency.scheduler.job.SchedulerJobImpl;
import cz.csob.ency.scheduler.service.SchedulerLocalService;
import cz.csob.ency.scheduler.sort.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;
import java.text.ParseException;
import java.util.*;


@Component(
    service = SchedulerLocalService.class
)
public class SchedulerLocalServiceImpl implements SchedulerLocalService {
    private static final Log log = LogFactoryUtil.getLog(SchedulerLocalServiceImpl.class);

    public boolean checkRunSupported() {
        try {
            SchedulerLocalService.class.getClassLoader().loadClass("com.liferay.portal.kernel.scheduler.messaging.ReceiverKey");
            return true;
        } catch (ClassNotFoundException e) {
            if (log.isDebugEnabled()) {
                log.debug("Scheduled Job execution not supported.");
            }
            return false;
        }
    }

    public SchedulerJob getSchedulerJob(SchedulerResponse schedulerResponse) {
        TriggerState triggerState = SchedulerEngineHelperUtil.getJobState(schedulerResponse);
        Date startTime = SchedulerEngineHelperUtil.getStartTime(schedulerResponse);
        Date endTime = SchedulerEngineHelperUtil.getEndTime(schedulerResponse);
        Date previousFireTime = SchedulerEngineHelperUtil.getPreviousFireTime(schedulerResponse);
        Date nextFireTime = SchedulerEngineHelperUtil.getNextFireTime(schedulerResponse);
        StorageType storageType = schedulerResponse.getStorageType();

        SchedulerJob SchedulerJob = new SchedulerJobImpl();
        SchedulerJob.setJobName(schedulerResponse.getJobName());
        SchedulerJob.setGroupName(schedulerResponse.getGroupName());
        SchedulerJob.setTriggerState(triggerState == null ? SchedulerJob.NULL_VALUE_DISPLAY : triggerState
            .toString());
        SchedulerJob.setStartTime(startTime);
        SchedulerJob.setEndTime(endTime);
        SchedulerJob.setPreviousFireTime(previousFireTime);
        SchedulerJob.setNextFireTime(nextFireTime);
        SchedulerJob.setStorageType(storageType == null ? SchedulerJob.NULL_VALUE_DISPLAY : storageType
            .toString().trim());
        return SchedulerJob;
    }

    public List<SchedulerJob> getSchedulerJobsList(List<SchedulerResponse> schedulerResponses) {
        List<SchedulerJob> SchedulerJobs = new ArrayList<SchedulerJob>();
        for (SchedulerResponse scheduler : schedulerResponses) {
            SchedulerJobs.add(getSchedulerJob(scheduler));
        }
        return SchedulerJobs;
    }

    public void doScheduledJobServiceAction(String action) throws SchedulerException {

        if (action.equals(SchedulerConstants.ACTION_SHUTDOWN)) {
            log.info(SchedulerConstants.LOG_SHUTDOWN_ACTION_MSG);
            SchedulerEngineHelperUtil.shutdown();
        }
    }

    public void scheduledJobsAction(PortletRequest request, String action) throws SchedulerException,
        ParseException {
        if (log.isDebugEnabled()) {
            log.debug("Schedule job action " + action);
        }
        Enumeration<String > names = request.getPropertyNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            log.info("  -  "+name+"="+request.getProperty(name));
        }
        // Checking all the rows to see which are selected
        String rowSelection;
        for (int i = 0; (rowSelection = request.getProperty(SchedulerConstants.PARAMETER_JOB_SELECTED + i)) != null; i++) {
            boolean rowSelected = GetterUtil.get(rowSelection, false);
            if (log.isDebugEnabled()) {
                log.debug("row " + rowSelection + " selected " + rowSelected);
            }
            log.info("row " + rowSelection + " selected " + rowSelected);
            if (rowSelected) {

                String jobName = ParamUtil.getString(request, SchedulerConstants.PARAMETER_JOB_NAME + i);
                String groupName = ParamUtil.getString(request, SchedulerConstants.PARAMETER_JOB_GROUP + i);
                String storageTypeText = ParamUtil.getString(request, SchedulerConstants.PARAMETER_STORAGE_TYPE + i);
                StorageType storageType = StorageType.valueOf(storageTypeText);

                // Log debug messages
                if (log.isDebugEnabled()) {
                    log.debug(String.format(SchedulerConstants.LOG_JOB_FORMAT, action, SchedulerConstants.LOG_ACTION_MSG, jobName, groupName, storageType));
                }

                if (action.equals(SchedulerConstants.ACTION_PAUSE)) {
                    SchedulerEngineHelperUtil.pause(jobName, groupName, storageType);
                } else if (action.equals(SchedulerConstants.ACTION_RESUME)) {
                    SchedulerEngineHelperUtil.resume(jobName, groupName, storageType);
                } else if (action.equals(SchedulerConstants.ACTION_RUN)) {
                    runScheduledJob(jobName, groupName, storageType);
                }
            }
        }
    }

    public void doScheduledJobAction(PortletRequest request, String action) throws SchedulerException{
        if (log.isDebugEnabled()) {
            log.debug("Schedule job action " + action);
        }

        String jobName = ParamUtil.getString(request, SchedulerConstants.PARAMETER_JOB_NAME );
        String groupName = ParamUtil.getString(request, SchedulerConstants.PARAMETER_JOB_GROUP );
        String storageTypeText = ParamUtil.getString(request, SchedulerConstants.PARAMETER_STORAGE_TYPE );
        StorageType storageType = Validator.isBlank(storageTypeText)?StorageType.MEMORY_CLUSTERED:StorageType.valueOf(storageTypeText);

        // Log debug messages
        if (log.isDebugEnabled()) {
            log.debug(String.format(SchedulerConstants.LOG_JOB_FORMAT, action, SchedulerConstants.LOG_ACTION_MSG, jobName, groupName, storageType));
        }

        if (action.equals(SchedulerConstants.ACTION_PAUSE)) {
            SchedulerEngineHelperUtil.pause(jobName, groupName, storageType);
        } else if (action.equals(SchedulerConstants.ACTION_RESUME)) {
            SchedulerEngineHelperUtil.resume(jobName, groupName, storageType);
        } else if (action.equals(SchedulerConstants.ACTION_RUN)) {
            runScheduledJob(jobName, groupName, storageType);
        }else if (action.equals(SchedulerConstants.ACTION_UNSCHEDULE)) {
            SchedulerEngineHelperUtil.unschedule(jobName, groupName, storageType);
            SchedulerEngineHelperUtil.delete(jobName, groupName, storageType);
        }else if (action.equals("test")) {
            doTest();
        }
    }

    public void doTest() throws SchedulerException {
        Destination destination = _messageBus.getDestination(SchedulerConstants.DYNAMIC_SCHEDULER_DESTINATION);
        if(null == destination) {
            log.warn("Destionation is not available");
            return;
        }

        if(destination.getMessageListeners().size()<=0) {
            log.warn("Destionation has no listener ready. Jobs will not be processed");
            return;
        }


        Trigger jobTrigger = _triggerFactory.createTrigger("_My job "+ RandomUtil.nextInt(999999), "Ency jobs", new Date(), null, "10 * * * * ?");


        // register the scheduled task
        // SchedulerEngineHelperUtil.register(tl, se, DestinationNames.SCHEDULER_DISPATCH);
        Message message = new Message();
        message.put("foo","bar from "+jobTrigger.getJobName());
        message.put(SchedulerConstants.JOB_CLASS,"foo.bar.FooBarListener");

        SchedulerEngineHelperUtil.schedule(jobTrigger,StorageType.PERSISTED,"test job", SchedulerConstants.DYNAMIC_SCHEDULER_DESTINATION, message ,0);
    }

    public List<SchedulerResponse> getScheduledJobs() {
        try {
            return SchedulerEngineHelperUtil.getScheduledJobs();
        } catch (SchedulerException e) {
            log.error(e);
        }
        return Collections.EMPTY_LIST;
    }

    public void getScheduledJobs(PortletRequest portletRequest) {
        // Scheduler List
        List<SchedulerJob> SchedulerJobs = getSchedulerJobsList(getScheduledJobs());
        portletRequest.setAttribute(SchedulerConstants.ATTRIBUTE_JOBS_LIST, SchedulerJobs);
        portletRequest.setAttribute(SchedulerConstants.ATTRIBUTE_COUNT, SchedulerJobs.size());
    }

    /*@todo bez listu?*/
    public List<SchedulerJob> getScheduledJobs(List<SchedulerJob> list, Integer start, Integer end) {
        if (list != null) {
            return ListUtil.subList(list, start, end);
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    public int getScheduledJobsCount() {
        return getScheduledJobs().size();
    }

    public OrderByComparator<?> getSchedulerJobComparator(String orderByCol, String orderByType) {
        boolean orderByAsc = false;
        if (orderByType.equals(SchedulerConstants.DEFAULT_ORDER_BY_TYPE)) {
            orderByAsc = true;
        }

        OrderByComparator<?> orderByComparator = null;

        if (orderByCol.equalsIgnoreCase(SchedulerConstants.COLUMN_SHORT_NAME)) {
            orderByComparator = new JobNameComparator(orderByAsc);
        } else if (orderByCol.equalsIgnoreCase(SchedulerConstants.COLUMN_SHORT_GROUP)) {
            orderByComparator = new GroupNameComparator(orderByAsc);
        } else if (orderByCol.equalsIgnoreCase(SchedulerConstants.COLUMN_STATE)) {
            orderByComparator = new TriggerStateComparator(orderByAsc);
        } else if (orderByCol.equalsIgnoreCase(SchedulerConstants.COLUMN_START_TIME)) {
            orderByComparator = new StartTimeComparator(orderByAsc);
        } else if (orderByCol.equalsIgnoreCase(SchedulerConstants.COLUMN_END_TIME)) {
            orderByComparator = new EndTimeComparator(orderByAsc);
        } else if (orderByCol.equalsIgnoreCase(SchedulerConstants.COLUMN_PREVIOUS_FIRE_TIME)) {
            orderByComparator = new PreviousFireTimeComparator(orderByAsc);
        } else if (orderByCol.equalsIgnoreCase(SchedulerConstants.COLUMN_NEXT_FIRE_TIME)) {
            orderByComparator = new NextFireTimeComparator(orderByAsc);
        } else if (orderByCol.equalsIgnoreCase(SchedulerConstants.COLUMN_STORAGE_TYPE)) {
            orderByComparator = new StorageTypeComparator(orderByAsc);
        }

        return orderByComparator;
    }

    private void runScheduledJob(String jobName, String groupName, StorageType storageType) {
        SchedulerResponse sr;
        try {
            sr =  SchedulerEngineHelperUtil.getScheduledJob(jobName, groupName, storageType);
        } catch (SchedulerException e) {
            return;
        }

        if(sr == null) return;

        Message message = sr.getMessage();
        message.put(SchedulerEngine.DESTINATION_NAME, sr.getDestinationName());
        MessageBusUtil.sendMessage(sr.getDestinationName(), message);
    }

    @Reference(unbind = "-")
    private MessageBus _messageBus;

    @Reference(unbind = "-")
        TriggerFactory _triggerFactory;

}
