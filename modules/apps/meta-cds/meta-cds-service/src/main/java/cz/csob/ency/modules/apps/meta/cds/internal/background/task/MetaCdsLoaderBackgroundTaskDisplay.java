package cz.csob.ency.modules.apps.meta.cds.internal.background.task;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.display.BaseBackgroundTaskDisplay;
import com.liferay.portal.kernel.template.TemplateResource;
import com.liferay.portal.kernel.template.URLTemplateResource;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Map;

public class MetaCdsLoaderBackgroundTaskDisplay extends BaseBackgroundTaskDisplay {
    public MetaCdsLoaderBackgroundTaskDisplay(BackgroundTask backgroundTask) {
        super(backgroundTask);
    }

    @Override
    public int getPercentage() {
        return GetterUtil.getInteger(
                getBackgroundTaskStatusAttributeString("percentage"),
                PERCENTAGE_MIN);
    }

    @Override
    protected TemplateResource getTemplateResource() {
        Class<?> clazz = getClass();

        ClassLoader classLoader = clazz.getClassLoader();

        return new URLTemplateResource(
                _PROGRESS_TEMPLATE, classLoader.getResource(_PROGRESS_TEMPLATE));
    }

    @Override
    protected Map<String, Object> getTemplateVars() {
        return null;
    }

    private static final String _PROGRESS_TEMPLATE =
            "cz/csob/ency/modules/metacds/internal/background/task/display/dependencies/load_background_task_progress.ftl";

}
