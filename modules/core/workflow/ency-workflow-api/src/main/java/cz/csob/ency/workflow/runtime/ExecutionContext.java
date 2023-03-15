package cz.csob.ency.workflow.runtime;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import cz.csob.ency.workflow.constants.EncyWorkflowConstants;
import cz.csob.ency.workflow.model.EncyWorkflowInstance;
import cz.csob.ency.workflow.model.EncyWorkflowStateInstance;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ExecutionContext<T> implements Serializable {

    public ExecutionContext(
            EncyWorkflowStateInstance workflowStateInstance,
            Map<String, Serializable> workflowContext
    ) {
        this(workflowStateInstance.getWorkflowInstance(), workflowContext);
        this._workflowStateInstance = workflowStateInstance;
    }

    public ExecutionContext(
            EncyWorkflowInstance workflowInstance,
            Map<String, Serializable> workflowContext
    ) {
        this._workflowInstance = workflowInstance;
        this._workflowContext = workflowContext;
    }

    public T getModel() {
        if (_workflowContext == null
                || !_workflowContext.containsKey(EncyWorkflowConstants.CONTEXT_ENTRY)) {
            return null;
        }

        return (T) _workflowContext.get(EncyWorkflowConstants.CONTEXT_ENTRY);
    }

    public String getTransitionName() {
        return _transitionName;
    }

    public void setTransitionName(String _transitionName) {
        this._transitionName = _transitionName;
    }

    public Map<String, Serializable> getWorkflowContext() {
        return _workflowContext;
    }

    public void setWorkflowContext(Map<String, Serializable> _workflowContext) {
        this._workflowContext = _workflowContext;
    }

    public EncyWorkflowInstance getWorkflowInstance() {
        return _workflowInstance;
    }

    public void setWorkflowInstance(EncyWorkflowInstance _workflowInstance) {
        this._workflowInstance = _workflowInstance;
    }

    public EncyWorkflowStateInstance getWorkflowStateInstance() {
        return _workflowStateInstance;
    }

    public void setWorkflowStateInstance(EncyWorkflowStateInstance _workflowStateInstance) {
        this._workflowStateInstance = _workflowStateInstance;
    }

    public String getWorkflowStateName() {
        if (Validator.isNull(_workflowStateInstance)) {
            return StringPool.BLANK;
        }
        return _workflowStateInstance.getWorkflowState().getName();
    }

    public ServiceContext getServiceContext() {
        if(_workflowContext == null || !_workflowContext.containsKey(WorkflowConstants.CONTEXT_SERVICE_CONTEXT)){
            return new ServiceContext();
        }
        return (ServiceContext) _workflowContext.get(WorkflowConstants.CONTEXT_SERVICE_CONTEXT);
    }

    private T _model;
    private String _transitionName;
    private Map<String, Serializable> _workflowContext;
    private EncyWorkflowInstance _workflowInstance;
    private EncyWorkflowStateInstance _workflowStateInstance;
}