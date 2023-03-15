package cz.csob.ency.modules.e3.app.service;

import cz.csob.ency.modules.e3.app.model.E3App;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import java.util.Map;

public class E3AppLocalServiceUtil {

    private static final ServiceTracker<E3AppLocalService, E3AppLocalService>
            _serviceTracker;

    public static E3App getApp(String clazz) {
        return getService().getApp(clazz);
    }

    public static E3App getApp(E3Entry entry) {
        return getService().getApp(entry);
    }

    public static Map<String, Object> getAppRenderContext(String appClassName) {
        return getService().getAppRenderContext(appClassName);
    }

    public static Map<String, Object> getAppRenderContext(E3Entry entry) {
        return getService().getAppRenderContext(entry);
    }

    public static E3App getFallbackApp() {
        return getService().getFallbackApp();
    }

    public static E3AppLocalService getService() {
        return _serviceTracker.getService();
    }

    public static boolean isEntryApproved(E3Entry entry) {
        return getService().isEntryApproved(entry);
    }

    static {
        Bundle bundle = FrameworkUtil.getBundle(E3AppLocalService.class);

        ServiceTracker<E3AppLocalService, E3AppLocalService>
                serviceTracker =
                new ServiceTracker
                        <E3AppLocalService, E3AppLocalService>(
                        bundle.getBundleContext(), E3AppLocalService.class,
                        null);

        serviceTracker.open();

        _serviceTracker = serviceTracker;
    }
}
