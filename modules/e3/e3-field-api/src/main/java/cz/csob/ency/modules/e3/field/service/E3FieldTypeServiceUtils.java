package cz.csob.ency.modules.e3.field.service;

import cz.csob.ency.modules.e3.field.model.E3FieldType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.util.tracker.ServiceTracker;

@Component(
    immediate = true,
    service = E3FieldTypeServiceUtils.class
)
public class E3FieldTypeServiceUtils {

    private static final ServiceTracker<E3FieldTypeLocalService, E3FieldTypeLocalService> _serviceTracker;

    static {
        Bundle bundle = FrameworkUtil.getBundle(E3FieldTypeLocalService.class);

        ServiceTracker<E3FieldTypeLocalService, E3FieldTypeLocalService>
            serviceTracker =
            new ServiceTracker
                <E3FieldTypeLocalService, E3FieldTypeLocalService>(
                bundle.getBundleContext(), E3FieldTypeLocalService.class,
                null);

        serviceTracker.open();

        _serviceTracker = serviceTracker;
    }


    public static E3FieldType getFallbackFieldType() {
        return getService().getFallbackFieldType();
    }

    public static E3FieldType getFieldType(String name) {
        return getService().getFieldType(name);
    }

    private static E3FieldTypeLocalService getService() {
        return _serviceTracker.getService();
    }
}
