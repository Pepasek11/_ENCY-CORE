package cz.csob.ency.modules.apps.meta.cds.internal.background.task;

import com.liferay.portal.kernel.backgroundtask.BackgroundTaskStatus;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskStatusMessageTranslator;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.search.background.task.ReindexBackgroundTaskConstants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * @todo add phase support (single class run, full run)
 */

public class MetaCdsLoaderBackgroundTaskStatusMessageTranslator implements BackgroundTaskStatusMessageTranslator {
    private static final Log _log = LogFactoryUtil.getLog(
            MetaCdsLoaderBackgroundTaskStatusMessageTranslator.class);

    @Override
    public void translate(
            BackgroundTaskStatus backgroundTaskStatus, Message message) {

        String phase = message.getString(ReindexBackgroundTaskConstants.PHASE);

        if (Validator.isNotNull(phase)) {
            setPhaseAttributes(backgroundTaskStatus, message);

            return;
        }

        phase = GetterUtil.getString(
                backgroundTaskStatus.getAttribute(
                        ReindexBackgroundTaskConstants.PHASE));

        String className = message.getString(
                ReindexBackgroundTaskConstants.CLASS_NAME);

        backgroundTaskStatus.setAttribute(
                ReindexBackgroundTaskConstants.CLASS_NAME, className);

        long count = message.getLong(ReindexBackgroundTaskConstants.COUNT);

        backgroundTaskStatus.setAttribute(
                ReindexBackgroundTaskConstants.COUNT, count);

        long total = message.getLong(ReindexBackgroundTaskConstants.TOTAL);

        backgroundTaskStatus.setAttribute(
                ReindexBackgroundTaskConstants.TOTAL, total);

        long percentage = 100;

        if (phase.equals(ReindexBackgroundTaskConstants.PORTAL_START)) {
            //todo
            percentage = getPercentage(count, total);
        } else {
            percentage = getPercentage(count, total);
        }

        backgroundTaskStatus.setAttribute(
                "percentage", String.valueOf(percentage));

      //  _log.info("backgroundTaskStatus"+backgroundTaskStatus.getAttributes());
    }

    protected long getPercentage(long count, long total) {
        return (long) ((count * 100) / total);
    }


    protected void setPhaseAttributes(
            BackgroundTaskStatus backgroundTaskStatus, Message message) {

        backgroundTaskStatus.setAttribute(
                ReindexBackgroundTaskConstants.PHASE,
                message.getString(ReindexBackgroundTaskConstants.PHASE));
    }

}
