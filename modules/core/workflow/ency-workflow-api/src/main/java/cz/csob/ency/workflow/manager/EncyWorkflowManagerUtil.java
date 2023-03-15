package cz.csob.ency.workflow.manager;

import com.liferay.portal.kernel.model.ClassedModel;
import com.liferay.portal.kernel.service.ServiceContext;
import cz.csob.ency.workflow.model.EncyWorkflow;
import cz.csob.ency.workflow.model.EncyWorkflowInstance;
import cz.csob.ency.workflow.model.EncyWorkflowStateInstance;
import cz.csob.ency.workflow.model.EncyWorkflowTransition;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

public class EncyWorkflowManagerUtil {


    private static final ServiceTracker<EncyWorkflowManager, EncyWorkflowManager>
            _serviceTracker;

    public static List<EncyWorkflowTransition> getAllowedOutgoingTransitions(
            long companyId, long groupId, ClassedModel entry, ServiceContext serviceContext) {
        return getService().getAllowedOutgoingTransitions(companyId, groupId, entry, serviceContext);
    }

    public static EncyWorkflowStateInstance getEntryStateInstance(
            long companyId, long groupId, ClassedModel model) {

        return getService().getWorkflowStateInstance(companyId, groupId, model);
    }

    public static EncyWorkflowStateInstance getEntryStateInstance(
            long companyId, long groupId, String className, long primaryKey) {

        return getService().getWorkflowStateInstance(companyId, groupId, className, primaryKey);
    }

    public static List<EncyWorkflowTransition> getOutgoingTransitions(
            long companyId, long groupId, ClassedModel model) {
        return getService().getOutgoingTransitions(companyId, groupId, model);
    }

    public static List<EncyWorkflowTransition> getOutgoingTransitions(
            long companyId, long groupId, String className, long primaryKey) {

        return getService().getOutgoingTransitions(companyId, groupId, className, primaryKey);
    }

    public static List<String> getOutgoingTransitionsNames(
            long companyId, long groupId, String className, long primaryKey) {

        return getService().getOutgoingTransitionsNames(companyId, groupId, className, primaryKey);
    }

    public static EncyWorkflowManager getService() {
        return _serviceTracker.getService();
    }

    public static EncyWorkflow getWorkflow(EncyWorkflowInstance instance) {

        return getService().getWorkflow(instance);
    }

    public static EncyWorkflow getWorkflow(
            long companyId, long groupId, String className, long primaryKey) {

        return getService().getWorkflow(companyId, groupId, className, primaryKey);
    }

    public static EncyWorkflowInstance getWorkflowInstance(
            long companyId, long groupId, String className, long primaryKey) {

        return getService().getWorkflowInstance(companyId, groupId, className, primaryKey);
    }

    static {
        Bundle bundle = FrameworkUtil.getBundle(EncyWorkflowManager.class);

        ServiceTracker<EncyWorkflowManager, EncyWorkflowManager>
                serviceTracker =
                new ServiceTracker<>(
                        bundle.getBundleContext(), EncyWorkflowManager.class,
                        null
                );

        serviceTracker.open();

        _serviceTracker = serviceTracker;
    }
}
