package cz.csob.ency.scheduler.service;

import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.messaging.SchedulerResponse;
import com.liferay.portal.kernel.util.OrderByComparator;
import cz.csob.ency.scheduler.job.SchedulerJob;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import javax.portlet.PortletRequest;
import java.text.ParseException;
import java.util.List;

public class SchedulerUtil {

    private static ServiceTracker<SchedulerLocalService, SchedulerLocalService>
        _serviceTracker;

    static {
        Bundle bundle = FrameworkUtil.getBundle(SchedulerLocalService.class);

        ServiceTracker<SchedulerLocalService, SchedulerLocalService>
            serviceTracker =
            new ServiceTracker
                <SchedulerLocalService, SchedulerLocalService>(
                bundle.getBundleContext(), SchedulerLocalService.class,
                null);

        serviceTracker.open();

        _serviceTracker = serviceTracker;
    }

    public static boolean checkRunSupported() {
        return getService().checkRunSupported();
    }

    public static SchedulerJob getSchedulerJob(SchedulerResponse schedulerResponse) {
        return getService().getSchedulerJob(schedulerResponse);
    }

    public static List<SchedulerJob> getSchedulerJobsList(List<SchedulerResponse> schedulerResponses) {
        return getService().getSchedulerJobsList(schedulerResponses);
    }

    public static void doServiceAction(String action) throws SchedulerException {
        getService().doScheduledJobServiceAction(action);
    }

    public static void doScheduledJobsAction(PortletRequest request, String action)
        throws SchedulerException, ParseException {
        getService().doScheduledJobAction(request, action);
    }

    public static List<SchedulerResponse> getScheduledJobs() {
        return getService().getScheduledJobs();
    }

    public static void getScheduledJobs(PortletRequest portletRequest) {
        getService().getScheduledJobs(portletRequest);
    }

    /*@todo bez listu?*/
    public static List<SchedulerJob> getScheduledJobs(List<SchedulerJob> list, Integer start, Integer end) {
        return getService().getScheduledJobs(list, start, end);
    }

    public static int getScheduledJobsCount() {
        return getService().getScheduledJobsCount();
    }

    public static OrderByComparator<?> getSchedulerJobComparator(String orderByCol, String orderByType) {
        return getService().getSchedulerJobComparator(orderByCol, orderByType);
    }

    public static SchedulerLocalService getService() {
        return _serviceTracker.getService();
    }

}
