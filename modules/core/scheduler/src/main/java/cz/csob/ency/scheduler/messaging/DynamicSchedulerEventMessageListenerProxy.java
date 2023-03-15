package cz.csob.ency.scheduler.messaging;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBus;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.scheduler.SchedulerEngine;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.scheduler.constants.SchedulerConstants;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.*;

@Component(
    immediate = true,
    service = DynamicSchedulerEventMessageListenerProxy.class
)
public class DynamicSchedulerEventMessageListenerProxy extends BaseMessageListener {
    private static final Log _log = LogFactoryUtil.getLog(DynamicSchedulerEventMessageListenerProxy.class);

    private volatile boolean _initialized;

    @Reference
    private MessageBus _messageBus;
    private volatile BundleContext _bundleContext;

    /**
     * doReceive: This is where the magic happens, this is where you want to do the work for
     * the scheduled job.
     *
     * @param message This is the message object tied to the job.  If you stored data with the
     *                job, the message will contain that data.
     * @throws Exception In case there is some sort of error processing the task.
     */
    @Override
    protected void doReceive(Message message) throws Exception {
        String destination = message.getString(SchedulerEngine.DESTINATION_NAME);

        // Check that we have message for out destination
        if (!destination.equals(SchedulerConstants.DYNAMIC_SCHEDULER_DESTINATION)) {
            _log.info("Dynamic scheduler destination is not available.");
            return;
        }

        String jobClass = message.getString(SchedulerConstants.JOB_CLASS);

        if (Validator.isBlank(jobClass)) {
            _log.info("JobClass is not present.");
            return;
        }

        ServiceReference<BaseMessageListener> sr =
            (ServiceReference<BaseMessageListener>) _bundleContext.getServiceReference(jobClass);

        if (sr == null) {
            _log.info("No Service available for class " + jobClass);
            return;
        }
        BaseMessageListener listener = _bundleContext.getService(sr);

        listener.receive(message);
    }

    /**
     * activate: Called whenever the properties for the component change (ala Config Admin)
     * or OSGi is activating the component.
     *
     * @param componentContext
     * @throws SchedulerException in case of error.
     */
    @Activate
    @Modified
    protected void activate(ComponentContext componentContext) throws SchedulerException {
        _bundleContext = componentContext.getBundleContext();
        // if we were initialized (i.e. if this is called due to CA modification)
        if (_initialized) {
            // first deactivate the current job before we schedule.
            deactivate();
        }

        // register listener proxy
        _messageBus.registerMessageListener(SchedulerConstants.DYNAMIC_SCHEDULER_DESTINATION, this);

        // set the initialized flag.
        _initialized = true;
    }

    /**
     * deactivate: Called when OSGi is deactivating the component.
     */
    @Deactivate
    protected void deactivate() {
        // if we previously were initialized
        if (_initialized) {
            // unregister
            _messageBus.unregisterMessageListener(SchedulerConstants.DYNAMIC_SCHEDULER_DESTINATION, this);
        }

        // clear the initialized flag
        _initialized = false;
    }

    /**
     * setModuleServiceLifecycle: So this requires some explanation...
     * <p>
     * OSGi will start a component once all of it's dependencies are satisfied.  However, there
     * are times where you want to hold off until the portal is completely ready to go.
     * <p>
     * This reference declaration is waiting for the ModuleServiceLifecycle's PORTAL_INITIALIZED
     * component which will not be available until, surprise surprise, the portal has finished
     * initializing.
     * <p>
     * With this reference, this component activation waits until portal initialization has completed.
     *
     * @param moduleServiceLifecycle
     */
    @Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
    protected void setModuleServiceLifecycle(ModuleServiceLifecycle moduleServiceLifecycle) {
    }


}