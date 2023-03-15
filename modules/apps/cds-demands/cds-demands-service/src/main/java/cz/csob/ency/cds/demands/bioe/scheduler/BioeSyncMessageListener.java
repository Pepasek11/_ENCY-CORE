package cz.csob.ency.cds.demands.bioe.scheduler;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.scheduler.*;
import cz.csob.ency.cds.demands.bioe.service.impl.BioeDemandsSync;
import cz.csob.ency.cds.demands.configuration.BioeSyncConfiguration;
import org.osgi.service.component.annotations.*;

import java.util.Date;
import java.util.Map;

@Component(
        configurationPid = "cz.csob.ency.cds.demands.configuration.BioeSyncConfiguration",
        immediate = true, property = {"cron.expression=0/10 * * ? * *"},
        service = BioeSyncMessageListener.class
)
public class BioeSyncMessageListener extends BaseMessageListener {
    // the default cron expression is to run daily at midnight
    //  private static final String _DEFAULT_CRON_EXPRESSION = "0/10 * * ? * *";
    private static final int _DEFAULT_SYNC_INTERVAL_MIN = 10;
    private static final Log _log = LogFactoryUtil.getLog(BioeSyncMessageListener.class);

    /**
     * activate: Called whenever the properties for the component change (ala Config Admin)
     * or OSGi is activating the component.
     *
     * @param properties The properties map from Config Admin.
     * @throws SchedulerException in case of error.
     */
    @Activate
    @Modified
    protected void activate(Map<String, Object> properties) throws SchedulerException {

        _bioeSyncConfiguration = ConfigurableUtil.createConfigurable(
                BioeSyncConfiguration.class, properties);

        // if we were initialized (i.e. if this is called due to CA modification)
        if (_initialized) {
            // first deactivate the current job before we schedule.
            deactivate();
        }

        if (!_bioeSyncConfiguration.syncEnabled()) {
            return;
        }

        int interval = _bioeSyncConfiguration.checkInterval();
        if (interval == 0) interval = _DEFAULT_SYNC_INTERVAL_MIN;
        String className = getClass().getName();

        // create a new trigger definition for the job.
        Trigger jobTrigger = _triggerFactory.createTrigger(
                className, className, new Date(), null, interval, TimeUnit.MINUTE);

        _schedulerEntryImpl = new SchedulerEntryImpl(className, jobTrigger, "CdsDemandBioeSync");

        // register the scheduled task
        _schedulerEngineHelper.register(this, _schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);

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
            // unschedule the job so it is cleaned up
            try {
                _schedulerEngineHelper.unschedule(_schedulerEntryImpl, getStorageType());
            } catch (SchedulerException se) {
                if (_log.isWarnEnabled()) {
                    _log.warn("Unable to unschedule trigger", se);
                }
            }

            // unregister this listener
            _schedulerEngineHelper.unregister(this);
        }

        // clear the initialized flag
        _initialized = false;
    }

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
        bioeDemandsSync.doSync();
    }

    /**
     * getStorageType: Utility method to get the storage type from the scheduler entry wrapper.
     *
     * @return StorageType The storage type to use.
     */
    protected StorageType getStorageType() {
        if (_schedulerEntryImpl instanceof StorageTypeAware) {
            return ((StorageTypeAware) _schedulerEntryImpl).getStorageType();
        }

        return StorageType.MEMORY_CLUSTERED;
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

    @Reference(unbind = "-")
    protected void setSchedulerEngineHelper(SchedulerEngineHelper schedulerEngineHelper) {
        _schedulerEngineHelper = schedulerEngineHelper;
    }

    @Reference
    protected BioeDemandsSync bioeDemandsSync;

    @Reference(unbind = "-")
    protected void setTriggerFactory(TriggerFactory triggerFactory) {
        _triggerFactory = triggerFactory;
    }
    private volatile BioeSyncConfiguration _bioeSyncConfiguration;
    private volatile boolean _initialized;
    private SchedulerEngineHelper _schedulerEngineHelper;
    private SchedulerEntryImpl _schedulerEntryImpl = null;
    private TriggerFactory _triggerFactory;
}