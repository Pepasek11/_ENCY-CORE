package cz.csob.ency.modules.e3.field.service.impl;

import com.liferay.osgi.util.ServiceTrackerFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import cz.csob.ency.modules.e3.field.model.E3FieldType;
import cz.csob.ency.modules.e3.field.service.E3FieldTypeLocalService;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component(
        immediate = true,
        service = E3FieldTypeLocalService.class
)
public class E3FieldTypeLocalServiceImpl implements E3FieldTypeLocalService {
    private static final Log _log = LogFactoryUtil.getLog(E3FieldTypeLocalServiceImpl.class);
    private final Map<String, ServiceReference<E3FieldType>> _serviceReferences = new HashMap<>();
    private volatile boolean _initialized;
    private volatile BundleContext _bundleContext;
    private volatile ServiceTracker<E3FieldType, E3FieldType> _serviceTracker;

    //private volatile EncyFieldType fallbackEncyFieldType = new FallbackApp();

    @Override
    public E3FieldType getFallbackFieldType() {
        return null;
    }



    @Override
    public E3FieldType getFieldType(String name) {
        if (!_serviceReferences.containsKey(name)) {
            _log.warn("Couldn't locate EncyFieldType definition class " + name + "! Using fallback type.");
            return getFallbackFieldType();
        }

        ServiceReference<E3FieldType> serviceReference = _serviceReferences.get(name);

        Bundle bundle = serviceReference.getBundle();

        if (bundle == null) {
            _log.warn("Couldn't locate EncyFieldType definition class " + name +
                    " (expired reference). Using fallback application.");
            return getFallbackFieldType();
        }

        BundleContext bundleContext = bundle.getBundleContext();

        return bundleContext.getService(serviceReference);
    }

    @Override
    public Set<E3FieldType> getFieldTypes() {

        return _serviceReferences.values().stream()
                .filter(appServiceReference ->
                        appServiceReference.getBundle() != null)
                .map(appServiceReference ->
                        appServiceReference.getBundle().getBundleContext().getService(appServiceReference))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getFieldTypesNames() {
        return _serviceReferences.keySet();
    }


    /**
     * activate: Called whenever the properties for the component change (ala Config Admin)
     * or OSGi is activating the component.
     *
     * @param componentContext
     * @throws SchedulerException in case of error.
     */
    @Activate
    protected void activate(ComponentContext componentContext)
            throws Exception {
        _bundleContext = componentContext.getBundleContext();


        if (_log.isDebugEnabled()) {
            _log.debug("Activating AppLocalService");
        }

        // Register bundle tracker to watch over available Apps
        _serviceTracker = ServiceTrackerFactory.open(
                _bundleContext,
                "(objectClass=" + E3FieldType.class.getName() + ")",
                new E3FieldTypeLocalServiceImpl.EncyFieldTypeServiceTrackerCustomizer());
    }

    @Deactivate
    protected void deactivate() {
        if (_log.isDebugEnabled()) {
            _log.debug("Deactivating AppLocalService");
        }
        if (_bundleContext == null) {
            return;
        }

        if (_serviceTracker != null) {
            _serviceTracker.close();
        }

        _bundleContext = null;
    }

    private class EncyFieldTypeServiceTrackerCustomizer
            implements ServiceTrackerCustomizer<E3FieldType, E3FieldType> {

        private final Log _log = LogFactoryUtil.getLog(EncyFieldTypeServiceTrackerCustomizer.class);

        @Override
        public E3FieldType addingService(ServiceReference<E3FieldType> reference) {
            E3FieldType E3FieldType = _bundleContext.getService(reference);
            String name = E3FieldType.getName();

            if (_log.isDebugEnabled()) {
                this._log.debug("Adding service " + E3FieldType.getClass());
            }

            if (_serviceReferences.containsKey(name)) {
                _serviceReferences.replace(name, reference);
            } else {
                _serviceReferences.put(name, reference);
            }

            return E3FieldType;
        }

        @Override
        public void modifiedService(ServiceReference<E3FieldType> reference, E3FieldType service) {
            if (_log.isDebugEnabled()) {
                this._log.debug("Modifiing service" + reference);
            }
            _serviceReferences.replace(service.getClass().getName(), reference);
        }

        @Override
        public void removedService(ServiceReference<E3FieldType> reference, E3FieldType service) {
            if (_log.isDebugEnabled()) {
                this._log.debug("Removing service" + reference);
            }
            _serviceReferences.remove(service.getClass().getName());
        }

    }
}
