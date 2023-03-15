package cz.csob.ency.modules.apps.meta.cds.internal.background.task;

import com.liferay.portal.kernel.backgroundtask.BackgroundTaskStatusMessageSender;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskThreadLocal;
import com.liferay.portal.kernel.backgroundtask.constants.BackgroundTaskConstants;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import cz.csob.ency.modules.apps.meta.cds.background.task.MetaCdsLoaderBackgroundTaskConstants;
import cz.csob.ency.modules.apps.meta.cds.background.task.MetaCdsLoaderStatusMessageSender;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Andrew Betts
 */
@Component(immediate = true, service = MetaCdsLoaderStatusMessageSender.class)
public class MetaCdsLoaderStatusMessageSenderImpl implements MetaCdsLoaderStatusMessageSender {

    private static final Log _log = LogFactoryUtil.getLog(
            MetaCdsLoaderStatusMessageSenderImpl.class);

    @Override
    public void sendStatusMessage(String className, long count, long total) {
        Message message = new Message();

        message.put(
                BackgroundTaskConstants.BACKGROUND_TASK_ID,
                BackgroundTaskThreadLocal.getBackgroundTaskId());
        message.put(MetaCdsLoaderBackgroundTaskConstants.CLASS_NAME, className);
        message.put(MetaCdsLoaderBackgroundTaskConstants.COUNT, count);
        message.put(MetaCdsLoaderBackgroundTaskConstants.TOTAL, total);
        message.put("status", BackgroundTaskConstants.STATUS_IN_PROGRESS);

        sendBackgroundTaskStatusMessage(message);
    }

    protected void sendBackgroundTaskStatusMessage(Message message) {
        _backgroundTaskStatusMessageSender.sendBackgroundTaskStatusMessage(
                message);

        if (_log.isDebugEnabled()) {
            _log.debug(
                    "Sent reindex background task status message: " + message);
        }
    }
    @Reference
    private BackgroundTaskStatusMessageSender
            _backgroundTaskStatusMessageSender;
}
