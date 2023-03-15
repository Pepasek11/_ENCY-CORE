package cz.csob.ency.cds.demands.bioe.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

public class BioeLocalServiceUtil {
    private static final ServiceTracker
            <BioeLocalService, BioeLocalService>
            _serviceTracker;
    private static final Log log = LogFactoryUtil.getLog(BioeLocalServiceUtil.class);

    public static BioeLocalService getService() {
        return _serviceTracker.getService();
    }

    static {
        Bundle bundle = FrameworkUtil.getBundle(
                BioeLocalService.class);

        ServiceTracker
                <BioeLocalService, BioeLocalService>
                serviceTracker =
                new ServiceTracker
                        <BioeLocalService,
                                BioeLocalService>(
                        bundle.getBundleContext(),
                        BioeLocalService.class, null);

        serviceTracker.open();

        _serviceTracker = serviceTracker;
    }

    /** @todo add specific methosd */

}
