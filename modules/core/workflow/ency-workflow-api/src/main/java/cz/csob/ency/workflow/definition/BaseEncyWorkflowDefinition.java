package cz.csob.ency.workflow.definition;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.workflow.annotation.EncyWorkflow;
import cz.csob.ency.workflow.annotation.EncyWorkflowState;

import java.lang.annotation.IncompleteAnnotationException;
import java.util.*;

public abstract class BaseEncyWorkflowDefinition implements EncyWorkflowDefinition {
    private final static Log _log = LogFactoryUtil.getLog(BaseEncyWorkflowDefinition.class);

    public BaseEncyWorkflowDefinition() {
        init();
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public String getInitialStateName() {
        return _initialStateName;
    }

    @Override
    public Map<String, Object> getOptionalAttributes() {
        return null;
    }

    @Override
    public String getTitle() {
        return _title;
    }

    @Override
    public String getTitle(String languageId) {
        return _title;
    }

    @Override
    public long getVersion() {
        return _version;
    }

    @Override
    public final Map<String, EncyWorkflowStateDefinition> getWorkflowStates() {
        return _states;
    }

    @Override
    public final Set<String> getWorkflowStatesNames() {
        return this._states.keySet();
    }

    @Override
    public final List<EncyWorkflowTransitionDefinition> getWorkflowTransitions() {
        List<EncyWorkflowTransitionDefinition> list = new ArrayList<>();
        for (EncyWorkflowStateDefinition node : _states.values()) {
            list.addAll(node.getTransitions());
        }
        return list;
    }

    @Override
    public boolean isValid() {
        if (Validator.isNull(_valid)) {
            this._valid = validate();
        }
        return this._valid;
    }

    protected boolean validate() {
        boolean isOk = true;
        boolean hasStartNode = false;
        boolean hasEndNode = false;

        Set<String> nodeNames = new HashSet<>();


        for (EncyWorkflowStateDefinition node : _states.values()) {
            // validate that node names are unique
            if (nodeNames.contains(node.getName())) {
                _log.error("There is more then one node with name " + node.getName());
                isOk = false;
            } else {
                nodeNames.add(node.getName());
            }

            // validate start node exists
            if (node.isInitial()) {
                hasStartNode = true;
            }

            // validate end node(s) exists
            if (node.isFinal()) {
                hasEndNode = true;
            }
        }

        if (!hasStartNode) {
            _log.error("Initial node is missing in the workflow " + getClass());
            isOk = false;
        }

        if (!hasEndNode) {
            _log.error("Final node(s) is missing in the workflow " + getClass());
            isOk = false;
        }

        // validate orphaned nodes
        // @todo

        // validate transitions (destinations)
        for (EncyWorkflowTransitionDefinition transition : getWorkflowTransitions()) {
            if (Validator.isBlank(transition.getName())) {
                _log.error("Transition with empty name in workflow " + getClass());
                isOk = false;
                continue;
            }

            if (Validator.isBlank(transition.getTargetStateName())) {
                _log.error("Transition " + getClass() + "::" + transition.getSourceStateName() +
                        "::" + transition.getName() + " must define target state ");
                isOk = false;
            } else if (!_states.containsKey(transition.getTargetStateName())) {
                _log.error("Transition " + getClass() + "::" + transition.getSourceStateName() +
                        "::" + transition.getName() + " have invalid target state " +
                        transition.getTargetStateName() + ". Available target states are: " + _states.keySet());
                isOk = false;
            }
        }

        return isOk;
    }

    private void init() {
        Class<?> clazz = this.getClass();

        if (!clazz.isAnnotationPresent(EncyWorkflow.class)) {
            _log.error("Class {className:" + clazz + "} is not Annotated as EncyWorkflow");
            return;
        }

        EncyWorkflow workflowAnnotation = clazz.getAnnotation(EncyWorkflow.class);

        this._title = workflowAnnotation.title();
        if (Validator.isBlank(this._title)) {
            this._title = this.getClass().getSimpleName();
        }

        this._description = workflowAnnotation.description();
        this._version = workflowAnnotation.version();

        for (EncyWorkflowState node : workflowAnnotation.nodes()) {
            try {
                EncyWorkflowStateDefinition stateEntry = new DefaultEncyWorkflowStateDefinition(node);

                if (_states.containsKey(stateEntry.getName())) {
                    _log.error("Duplicite definition of the node " + stateEntry.getName() +
                            " in workflow " + this.getClass().getName());
                    return;
                }

                _states.put(stateEntry.getName(), stateEntry);
                if (node.isInitial()) {
                    this._initialStateName = node.name();
                }
            } catch (IncompleteAnnotationException iae) {
                _log.error("Incomplete annotation of node in workflow " + this.getClass());
            }
        }

        this._valid = validate();

        if (!this._valid) {
            _log.error("Workflow definition is not valid and therefore cannot be initialized. " +
                    "See errors above for details.");
            return;
        }
    }

    private String _description;
    private String _initialStateName = "";
    private Map<String, EncyWorkflowStateDefinition> _states = new HashMap<>();
    private String _title;
    private Boolean _valid;
    private long _version;

}
