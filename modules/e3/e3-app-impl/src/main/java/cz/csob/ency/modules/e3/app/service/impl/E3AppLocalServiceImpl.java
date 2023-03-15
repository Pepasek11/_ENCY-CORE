package cz.csob.ency.modules.e3.app.service.impl;

import com.liferay.osgi.util.ServiceTrackerFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.modules.e3.app.impl.FallbackApp;
import cz.csob.ency.modules.e3.app.model.E3App;
import cz.csob.ency.modules.e3.app.service.E3AppLocalService;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.field.model.E3Field;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component(
        immediate = true,
        service = E3AppLocalService.class
)
public class E3AppLocalServiceImpl
        implements E3AppLocalService, IdentifiableOSGiService {
    private static final Log _log = LogFactoryUtil.getLog(E3AppLocalServiceImpl.class);

    @Override
    public E3App getApp(E3Entry entry) {
        return getApp(entry.getAppClass());
    }

    @Override
    public E3App getApp(String clazz) {
        if (!_serviceReferences.containsKey(clazz)) {
            _log.warn("Can not locate EncyApp definition class " + clazz + "! Using fallback application.");
            return getFallbackApp();
        }

        ServiceReference<E3App> serviceReference = _serviceReferences.get(clazz);

        Bundle bundle = serviceReference.getBundle();

        if (bundle == null) {
            _log.warn("Can not locate EncyApp definition class " + clazz +
                    " (expired reference). Using fallback application.");
            return getFallbackApp();
        }

        BundleContext bundleContext = bundle.getBundleContext();

        return bundleContext.getService(serviceReference);
    }

    @Override
    public Map<String, Object> getAppRenderContext(String appClassName) {
        E3App app = getApp(appClassName);

        if (Validator.isNull(app)) {
            _log.error("Unavailable App  " + appClassName);
            return Collections.EMPTY_MAP;
        }
        return _getAppRenderContext(app, null);
    }

    @Override
    public Map<String, Object> getAppRenderContext(E3Entry entry) {
        if (Validator.isNull(entry)) {
            _log.error("Unable to determine display context for null entry.");
            return Collections.EMPTY_MAP;
        }
        E3App app = getApp(entry);

        if (Validator.isNull(app)) {
            _log.error("Unavailable App for entry " + entry);
            return Collections.EMPTY_MAP;
        }

        return _getAppRenderContext(app, entry);
    }

    @Override
    public Set<E3App> getApps() {

        return _serviceReferences.values().stream()
                .filter(appServiceReference ->
                        appServiceReference.getBundle() != null)
                .map(appServiceReference ->
                        appServiceReference.getBundle().getBundleContext().getService(appServiceReference))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getAppsClassNames() {
        return _serviceReferences.keySet();
    }

    @Override
    public E3App getFallbackApp() {
        return fallbackEncyApp;
    }

    @Override
    public String getOSGiServiceIdentifier() {
        return E3AppLocalService.class.getName();
    }

    @Override
    public boolean isEntryApproved(E3Entry entry) {
        try {
            E3App app = getApp(entry);
            return app.isEntryApproved(entry);
        } catch (Exception ex) {
            _log.error(ex);
        }
        return false;

    }

    protected Map<String, Object> _getAppRenderContext(E3App app, E3Entry entry) {
        Map<String, Object> context = new HashMap<>();

        context.putAll(app.getRenderContext(entry));

        Map<String, Object> fieldsContext = new HashMap<>();
        Map<String, E3Field> fields = app.getFields();

        for (E3Field field : fields.values()) {
            fieldsContext.put(field.getName(), field.getDisplayContext(entry));
        }

        fieldsContext.putAll(app.getCustomFieldsRenderContext(entry));

        context.put("_fields", fieldsContext);

        return context;
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
                "(objectClass=" + E3App.class.getName() + ")",
                new EncyAppServiceTrackerCustomizer());

        this._initialized = true;
    }

    @Deactivate
    protected void deactivate() {
        if (_log.isDebugEnabled()) {
            _log.debug("Deactivating AppLocalService");
        }
        this._initialized = false;
        if (_bundleContext == null) {
            return;
        }

        if (_serviceTracker != null) {
            _serviceTracker.close();
        }

        _bundleContext = null;
    }
    private final Map<String, ServiceReference<E3App>> _serviceReferences = new HashMap<>();
    private final E3App fallbackEncyApp = new FallbackApp();
    private volatile BundleContext _bundleContext;
    private volatile boolean _initialized;
    private volatile ServiceTracker<E3App, E3App> _serviceTracker;

    private class EncyAppServiceTrackerCustomizer
            implements ServiceTrackerCustomizer<E3App, E3App> {

        @Override
        public E3App addingService(ServiceReference<E3App> reference) {
            E3App e3App = _bundleContext.getService(reference);
            String appClass = e3App.getAppClass().getName();

            if (_log.isDebugEnabled()) {
                this._log.debug("Adding app " + e3App.getAppName() + " under key " + appClass);
            }

            if (_serviceReferences.containsKey(appClass)) {
                _serviceReferences.replace(appClass, reference);
            } else {
                _serviceReferences.put(appClass, reference);
            }

            return e3App;
        }

        @Override
        public void modifiedService(ServiceReference<E3App> reference, E3App service) {
            if (_log.isDebugEnabled()) {
                this._log.debug("Modifiing service" + reference);
            }

            _serviceReferences.replace(service.getClass().getName(), reference);
        }

        @Override
        public void removedService(ServiceReference<E3App> reference, E3App service) {
            if (_log.isDebugEnabled()) {
                this._log.debug("Removing service" + reference);
            }

            _serviceReferences.remove(service.getClass().getName());
        }
        private final Log _log = LogFactoryUtil.getLog(EncyAppServiceTrackerCustomizer.class);

    }
}
