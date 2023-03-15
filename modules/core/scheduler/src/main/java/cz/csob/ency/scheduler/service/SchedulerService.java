package cz.csob.ency.scheduler.service;

import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.messaging.SchedulerResponse;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.util.OrderByComparator;
import cz.csob.ency.scheduler.job.SchedulerJob;
import org.osgi.annotation.versioning.ProviderType;

import javax.portlet.PortletRequest;
import java.text.ParseException;
import java.util.List;

@ProviderType
public interface SchedulerService extends BaseLocalService {

    boolean checkRunSupported();

    SchedulerJob getSchedulerJob(SchedulerResponse schedulerResponse);

    List<SchedulerJob> getSchedulerJobsList(List<SchedulerResponse> schedulerResponses);

    void doScheduledJobServiceAction(String action) throws SchedulerException;

    void doScheduledJobAction(PortletRequest request, String action)
        throws SchedulerException, ParseException;

    List<SchedulerResponse> getScheduledJobs();

    void getScheduledJobs(PortletRequest portletRequest);

    /*@todo bez listu?*/
    List<SchedulerJob> getScheduledJobs(List<SchedulerJob> list, Integer start, Integer end);

    int getScheduledJobsCount();

    OrderByComparator<?> getSchedulerJobComparator(String orderByCol, String orderByType);
}
