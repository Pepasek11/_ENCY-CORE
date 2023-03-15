package cz.csob.ency.workflow.internal.handler;

import com.liferay.osgi.service.tracker.collections.map.ServiceReferenceMapper;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.ModelListenerRegistrationUtil;
import cz.csob.ency.workflow.handler.EncyWorkflowHandler;
import cz.csob.ency.workflow.handler.EncyWorkflowHandlerRegistry;
import cz.csob.ency.workflow.handler.WorkflowedModelListener;
import cz.csob.ency.workflow.internal.runtime.model.listener.WorkflowedModelListenerImpl;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component(immediate = true, service = EncyWorkflowHandlerRegistry.class)
public class EncyWorkflowHandlerRegistryImpl implements EncyWorkflowHandlerRegistry {

    private static final Log _log = LogFactoryUtil.getLog(
            EncyWorkflowHandlerRegistryImpl.class);

    @Activate
    public void activate(ComponentContext componentContext)
            throws Exception {
        _bundleContext = componentContext.getBundleContext();
        _workflowHandlerServiceTrackerMap =
                ServiceTrackerMapFactory.openSingleValueMap(
                        _bundleContext,
                        (Class<EncyWorkflowHandler<?>>) (Class<?>) EncyWorkflowHandler.class,
                        null,
                        new WorkflowHandlerServiceReferenceMapper(handler -> true),
                        new WorkflowHandlerTrackerCustomizer()
                );
    }

    @Override
    public <T> EncyWorkflowHandler<T> getWorkflowHandler(String className) {
        return (EncyWorkflowHandler<T>) _workflowHandlerServiceTrackerMap.getService(
                className);
    }

    @Override
    public List<EncyWorkflowHandler<?>> getWorkflowHandlers() {
        return _getWorkflowHandlers(_workflowHandlerServiceTrackerMap);
    }

    private List<EncyWorkflowHandler<?>> _getWorkflowHandlers(
            ServiceTrackerMap<String, EncyWorkflowHandler<?>>
                    workflowHandlerServiceTrackerMap) {

        List<EncyWorkflowHandler<?>> workflowHandlers = new ArrayList<>();

        for (String modelClassName :
                workflowHandlerServiceTrackerMap.keySet()) {

            workflowHandlers.add(
                    workflowHandlerServiceTrackerMap.getService(modelClassName));
        }

        return workflowHandlers;
    }

    private BundleContext _bundleContext;
    private ServiceTrackerMap<String, EncyWorkflowHandler<?>>
            _workflowHandlerServiceTrackerMap;

    private class WorkflowHandlerServiceReferenceMapper
            implements ServiceReferenceMapper<String, EncyWorkflowHandler<?>> {

        private WorkflowHandlerServiceReferenceMapper(
                Predicate<EncyWorkflowHandler<?>> predicate) {

            _predicate = predicate;
        }

        @Override
        public void map(
                ServiceReference<EncyWorkflowHandler<?>> serviceReference,
                Emitter<String> emitter) {

            EncyWorkflowHandler<?> workflowHandler = _bundleContext.getService(
                    serviceReference);

            if (_predicate.test(workflowHandler)) {
                emitter.emit(workflowHandler.getModelClassName());
            }
        }

        private final Predicate<EncyWorkflowHandler<?>> _predicate;

    }


    private class WorkflowHandlerTrackerCustomizer
            implements ServiceTrackerCustomizer
            <EncyWorkflowHandler<?>, EncyWorkflowHandler<?>> {

        @Override
        public EncyWorkflowHandler<?> addingService(ServiceReference<EncyWorkflowHandler<?>> serviceReference) {
            EncyWorkflowHandler handler = _bundleContext.getService(serviceReference);
            Class<?> clazz = handler.getModelClass();

            for (ModelListener listener : ModelListenerRegistrationUtil.getModelListeners(clazz)) {
                if (WorkflowedModelListener.class.isAssignableFrom(listener.getModelClass())) {
                    // Ency WorkflowedModelListener is already registered
                    return handler;
                }
            }

            ModelListener listener = new WorkflowedModelListenerImpl(clazz);
            ModelListenerRegistrationUtil.register(listener);
            if (_log.isDebugEnabled()) _log.debug("Registering listener for " + clazz);

            return handler;
        }

        @Override
        public void modifiedService(ServiceReference<EncyWorkflowHandler<?>> serviceReference, EncyWorkflowHandler<?> encyWorkflowHandler) {

        }

        @Override
        public void removedService(ServiceReference<EncyWorkflowHandler<?>> serviceReference, EncyWorkflowHandler<?> encyWorkflowHandler) {
            EncyWorkflowHandler handler = _bundleContext.getService(serviceReference);
            Class<?> clazz = handler.getModelClass();

            for (ModelListener listener : ModelListenerRegistrationUtil.getModelListeners(clazz)) {
                if (_log.isDebugEnabled())
                    _log.debug("Ungrgistering listener for class " + listener.getModelClass());
                ModelListenerRegistrationUtil.unregister(listener);
            }
        }
    }
}
