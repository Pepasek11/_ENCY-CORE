package cz.csob.ency.workflow.runtime.action.manager;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import cz.csob.ency.workflow.entry.model.EncyWorkflowedModel;
import cz.csob.ency.workflow.model.EncyWorkflowStateInstance;
import cz.csob.ency.workflow.model.EncyWorkflowTransition;
import cz.csob.ency.workflow.runtime.ExecutionContext;

import java.io.Serializable;
import java.util.Map;

public interface EncyWorkflowActionManager {
    <T extends EncyWorkflowedModel> EncyWorkflowTransition getAutoTransition(
            EncyWorkflowStateInstance workflowStateInstance,
            T model,  Map<String, Serializable> workflowContext);

    <T extends EncyWorkflowedModel> Boolean isTransitionAllowed(
            EncyWorkflowStateInstance workflowStateInstance,
            EncyWorkflowTransition transition,
            long userId,
            T model,
            ServiceContext serviceContext
    ) throws PortalException;

    <T extends EncyWorkflowedModel> Boolean isTransitionAllowed(
            EncyWorkflowStateInstance workflowStateInstance,
            String transitionName,
            long userId,
            T model,
            Map<String, Serializable> workflowContext
    ) throws PortalException;


    void stateEntry(EncyWorkflowStateInstance workflowStateInstance,
                    String transitionName, Map<String, Serializable> workflowContext
    );

    void stateEntry(EncyWorkflowStateInstance workflowStateInstance, Map<String, Serializable> workflowContext);

    void stateExit(
            EncyWorkflowStateInstance workflowStateInstance, String transitionName,
            Map<String, Serializable> workflowContext
    );

    void stateExit(EncyWorkflowStateInstance workflowStateInstance, Map<String, Serializable> workflowContext);
}
