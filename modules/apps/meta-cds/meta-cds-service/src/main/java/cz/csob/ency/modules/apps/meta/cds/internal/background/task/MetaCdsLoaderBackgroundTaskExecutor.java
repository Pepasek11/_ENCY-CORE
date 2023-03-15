package cz.csob.ency.modules.apps.meta.cds.internal.background.task;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.constants.BackgroundTaskConstants;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.modules.apps.meta.cds.background.task.MetaCdsLoaderStatusMessageSender;
import cz.csob.ency.modules.apps.meta.cds.loader.MetaCdsLoader;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.Map;

@Component(
        immediate = true,
        property = "background.task.executor.class.name=cz.csob.ency.modules.apps.meta.cds.internal.background.task.MetaCdsLoaderBackgroundTaskExecutor",
        service = {
                BackgroundTaskExecutor.class,
                MetaCdsLoaderBackgroundTaskExecutor.class
        }
)
public class MetaCdsLoaderBackgroundTaskExecutor
        extends BaseBackgroundTaskExecutor {
    private static final Log _log = LogFactoryUtil.getLog(
            MetaCdsLoaderBackgroundTaskExecutor.class);

    public MetaCdsLoaderBackgroundTaskExecutor() {
        setBackgroundTaskStatusMessageTranslator(new MetaCdsLoaderBackgroundTaskStatusMessageTranslator());
        setIsolationLevel(BackgroundTaskConstants.ISOLATION_LEVEL_TASK_NAME);
    }

    @Override
    public BackgroundTaskExecutor clone() {
        return this;
    }

    @Override
    public BackgroundTaskResult execute(BackgroundTask backgroundTask)
            throws Exception {

        Map<String, Serializable> taskContextMap =
                backgroundTask.getTaskContextMap();

        String target = (String) taskContextMap.get(
                "target");

        String parent = (String) taskContextMap.getOrDefault(
                "parent",null);

        ServiceContext serviceContext = (ServiceContext) taskContextMap.get(
                "serviceContext");
        serviceContext = (ServiceContext) serviceContext.clone();

        metaCdsLoaderStatusMessageSender.sendStatusMessage(MetaCdsLoader.class.getName(), 0, 1);

        switch (target) {
            case "systems":
                _metaMetaCdsLoader.loadSystemMeta(serviceContext);
                break;
            case "tables":
                _metaMetaCdsLoader.loadTableMeta(serviceContext, parent);
                break;
            case "columns":
                _metaMetaCdsLoader.loadColumnMeta(serviceContext, parent);
                break;
            default:
                _metaMetaCdsLoader.loadMetaCdsFull(serviceContext);
        }
        metaCdsLoaderStatusMessageSender.sendStatusMessage(MetaCdsLoader.class.getName(), 1, 1);

        return BackgroundTaskResult.SUCCESS;
    }

    @Override
    public String generateLockKey(BackgroundTask backgroundTask) {
        Map<String, Serializable> taskContextMap =
                backgroundTask.getTaskContextMap();

        String className = (String) taskContextMap.get("className");

        if (Validator.isNotNull(className)) {
            return className;
        }

        return super.generateLockKey(backgroundTask);
    }

    @Override
    public BackgroundTaskDisplay getBackgroundTaskDisplay(
            BackgroundTask backgroundTask) {

        return new MetaCdsLoaderBackgroundTaskDisplay(backgroundTask);
    }
    @Reference
    protected MetaCdsLoaderStatusMessageSender metaCdsLoaderStatusMessageSender;
    @Reference
    private MetaCdsLoader _metaMetaCdsLoader;


}
