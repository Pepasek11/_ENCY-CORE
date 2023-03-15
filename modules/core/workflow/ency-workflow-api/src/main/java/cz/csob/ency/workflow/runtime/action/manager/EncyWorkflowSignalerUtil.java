package cz.csob.ency.workflow.runtime.action.manager;


import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

public class EncyWorkflowSignalerUtil {
    private static final ServiceTracker<EncyWorkflowActionManager, EncyWorkflowActionManager>
            _serviceTracker;

    public static EncyWorkflowActionManager getService(){
        return _serviceTracker.getService();
    }

    static {
        Bundle bundle = FrameworkUtil.getBundle(EncyWorkflowActionManager.class);

        ServiceTracker<EncyWorkflowActionManager, EncyWorkflowActionManager>
                serviceTracker =
                new ServiceTracker<>(
                        bundle.getBundleContext(), EncyWorkflowActionManager.class,
                        null
                );

        serviceTracker.open();

        _serviceTracker = serviceTracker;
    }
}
