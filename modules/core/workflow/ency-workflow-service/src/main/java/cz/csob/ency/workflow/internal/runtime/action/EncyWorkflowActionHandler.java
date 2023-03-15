package cz.csob.ency.workflow.internal.runtime.action;

import com.liferay.osgi.service.tracker.collections.map.ServiceReferenceMapper;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.workflow.runtime.ExecutionContext;
import cz.csob.ency.workflow.runtime.action.*;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import java.util.*;

@Component(
        immediate = true,
        service = EncyWorkflowActionHandler.class

)
public class EncyWorkflowActionHandler {
    private static final Class[] STATE_ACTION_CLASSES = {
            EncyWorkflowOnStateEntryAction.class,
            EncyWorkflowOnStateExitAction.class
    };

    private static final Class[] TRANSITION_ACTION_CLASSES = {
            EncyWorkflowOnTransitionStartAction.class,
            EncyWorkflowOnTransitionEndAction.class,
            EncyWorkflowTransitionAllowAction.class,
            EncyWorkflowTransitionDoAutoAction.class
    };

    private static final Log _log = LogFactoryUtil.getLog(
            EncyWorkflowActionHandler.class);

    public void onStateEntry(ExecutionContext executionContext) {
        _doVoidAction(EncyWorkflowOnStateEntryAction.class, executionContext, false);
    }

    public void onStateExit(ExecutionContext executionContext) {
        _doVoidAction(EncyWorkflowOnStateExitAction.class, executionContext, false);
    }

    /**
     * Run Transition Allow scripts. By default transition is allowed if none script exist, oterwise
     * all scripts must allow transition to be allowed.
     *
     * @param executionContext
     * @return bool whether transition is allowed
     */
    public boolean onTransitionAllowSafe(ExecutionContext executionContext) {
        try {
            return onTransitionAllow(executionContext);
        } catch (PortalException e) {
           return false;
        }
    }
    public boolean onTransitionAllow(ExecutionContext executionContext) throws PortalException {

        List<Boolean> results =
                null;
        results = _doBoolAction(EncyWorkflowTransitionAllowAction.class, executionContext, true);

        for (Boolean result : results) {
            if (!result) return false;
        }

        return true;
    }

    /**
     * Run TransitionDoAuto scripts that determine, wether transition should be performed automatically.
     * By default auto transition is not allowed until at least one of the action scripts allows it.
     *
     * @param executionContext
     * @return bool whether transition should be performed automatically
     */
    public boolean onTransitionDoAuto(ExecutionContext executionContext) {

        List<Boolean> results =
                null;
        try {
            results = _doBoolAction(EncyWorkflowTransitionDoAutoAction.class, executionContext, true);
        } catch (PortalException e) {
            _log.warn(e);
        }

        for (Boolean result : results) {
            if (result) return true;
        }

        return false;
    }

    public void onTransitionEnd(ExecutionContext executionContext) {
        _doVoidAction(EncyWorkflowOnTransitionEndAction.class, executionContext, true);
    }

    public void onTransitionStart(ExecutionContext executionContext) {
        _doVoidAction(EncyWorkflowOnTransitionStartAction.class, executionContext, true);
    }

    @Activate
    protected void activate(BundleContext bundleContext) {
        _stateTrackers = new HashMap<>();
        _transitionTrackers = new HashMap<>();
        for (Class<EncyWorkflowAction> clazz : STATE_ACTION_CLASSES) {
            _stateTrackers.put(clazz, ServiceTrackerMapFactory.openMultiValueMap(
                    bundleContext, clazz, "(ency.workflow.class.name=*)",
                    new EVServiceReferenceMapper<>(
                            "ency.workflow.class.name",
                            "ency.workflow.state.name"))
            );
        }

        for (Class<EncyWorkflowAction> clazz : TRANSITION_ACTION_CLASSES) {
            _transitionTrackers.put(clazz, ServiceTrackerMapFactory.openMultiValueMap(
                    bundleContext, clazz, "(ency.workflow.class.name=*)",
                    new EVServiceReferenceMapper<>(
                            "ency.workflow.class.name",
                            "ency.workflow.transition.name"))
            );
        }
    }

    @Deactivate
    protected void deactivate() {
        _stateTrackers.forEach((c, trackerMap) -> trackerMap.close());
        _transitionTrackers.forEach((c, trackerMap) -> trackerMap.close());
    }

    private void _addAll(
            List<EncyWorkflowAction> list1,
            List<EncyWorkflowAction> list2) {

        if (list2 == null) {
            return;
        }

        list1.addAll(list2);
    }

    private <T extends EncyWorkflowBoolAction> List<Boolean> _doBoolAction (
            Class<T> clazz, ExecutionContext executionContext, boolean isTransition
    )  throws PortalException  {

        if (!_validate(clazz, executionContext, isTransition)) {
            return Collections.emptyList();
        }

        List<Boolean> results = new LinkedList<>();
        for (EncyWorkflowAction action : _getActions(clazz, executionContext, isTransition)) {
            results.add(((EncyWorkflowBoolAction) action).perform(executionContext));
        }

        return results;
    }

    private <T extends EncyWorkflowVoidAction> void _doVoidAction(
            Class<T> clazz, ExecutionContext executionContext,
            boolean isTransition) {

        if (!_validate(clazz, executionContext, isTransition)) {
            return;
        }

        for (EncyWorkflowAction action : _getActions(clazz, executionContext, isTransition)) {
            ((EncyWorkflowVoidAction) action).perform(executionContext);
        }
    }

    private <T extends EncyWorkflowVoidAction> List<EncyWorkflowAction> _getActions(
            Class<?> clazz, ExecutionContext executionContext, boolean isTransition
    ) {

        Map<Class<?>, ServiceTrackerMap<String, List<EncyWorkflowAction>>> trackerMap =
                isTransition ? _transitionTrackers : _stateTrackers;

        String workflowClassName = executionContext.getWorkflowInstance().getWorkflow().getClassName();
        String name = isTransition ?
                executionContext.getTransitionName() :
                executionContext.getWorkflowStateInstance().getWorkflowState().getName();

        List<EncyWorkflowAction> actions = new LinkedList<>();
        _addAll(actions, trackerMap.get(clazz).getService(workflowClassName + ":" + name));
        _addAll(actions, trackerMap.get(clazz).getService(workflowClassName + ":ALL"));

        return actions;
    }

    private <T extends EncyWorkflowAction> boolean _validate(
            Class<?> clazz, ExecutionContext executionContext, boolean isTransition) {

        if (isTransition && !_transitionTrackers.containsKey(clazz)) {
            return false;
        }

        if (!isTransition && !_stateTrackers.containsKey(clazz)) {
            return false;
        }

        if (null == executionContext.getWorkflowInstance()) {
            _log.error(" WorkflowInstance in execution context is null. Can not preform workflow action");
            return false;
        }

        if (null == executionContext.getWorkflowStateInstance()) {
            _log.error("WorkflowStateInstance in execution context is null. Can not preform workflow action");
            return false;
        }

        if (isTransition && Validator.isBlank(executionContext.getTransitionName())) {
            _log.error("TransitionName in execution context is blank. Can not preform workflow action");
            return false;
        }

        return true;
    }

    private Map<Class<?>, ServiceTrackerMap<String, List<EncyWorkflowAction>>> _stateTrackers;
    private Map<Class<?>, ServiceTrackerMap<String, List<EncyWorkflowAction>>> _transitionTrackers;

    protected class EVServiceReferenceMapper<S>
            implements ServiceReferenceMapper<String, S> {

        public EVServiceReferenceMapper(String p1, String p2) {
            this._p1 = p1;
            this._p2 = p2;
        }

        @Override
        public void map(ServiceReference<S> serviceReference, Emitter<String> emitter) {
            Object workflowValue = serviceReference.getProperty(this._p1);
            Object stateValue = serviceReference.getProperty(this._p2);

            if (workflowValue == null || stateValue == null) {
                return;
            }

            List<String> workflowValues = new LinkedList<>();

            if (workflowValue instanceof Collection) {
                for (String t : (Collection<String>) workflowValue) {
                    workflowValues.add(t);
                }
            } else if (workflowValue instanceof Object[]) {
                for (String t : (String[]) workflowValue) {
                    workflowValues.add(t);
                }
            } else {
                workflowValues.add((String) workflowValue);
            }

            if (stateValue instanceof Collection) {
                for (String t : (Collection<String>) stateValue) {
                    for (String c : workflowValues) {
                        emitter.emit(c + ":" + t);
                    }
                }
            } else if (stateValue instanceof Object[]) {
                for (String t : (String[]) stateValue) {
                    for (String c : workflowValues) {
                        emitter.emit(c + ":" + t);
                    }
                }
            } else {
                for (String c : workflowValues) {
                    emitter.emit(c + ":" + stateValue.toString());
                }
            }
        }

        private String _p1;
        private String _p2;
    }
}
