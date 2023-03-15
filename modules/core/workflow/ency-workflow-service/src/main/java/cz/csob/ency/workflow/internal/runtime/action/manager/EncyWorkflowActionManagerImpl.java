package cz.csob.ency.workflow.internal.runtime.action.manager;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.workflow.entry.model.EncyWorkflowedModel;
import cz.csob.ency.workflow.internal.runtime.action.EncyWorkflowActionHandler;
import cz.csob.ency.workflow.model.EncyWorkflowStateInstance;
import cz.csob.ency.workflow.model.EncyWorkflowTransition;
import cz.csob.ency.workflow.runtime.ExecutionContext;
import cz.csob.ency.workflow.runtime.action.manager.EncyWorkflowActionManager;
import cz.csob.ency.workflow.util.WorkflowContextBuilder;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Map;

@Component(immediate = true, service = EncyWorkflowActionManager.class)
@Transactional(
        isolation = Isolation.PORTAL, propagation = Propagation.SUPPORTS,
        rollbackFor = Exception.class
)
public class EncyWorkflowActionManagerImpl implements EncyWorkflowActionManager {
    private static final Log _log = LogFactoryUtil.getLog(
            EncyWorkflowActionManagerImpl.class);

    @Override
    public <T extends EncyWorkflowedModel> EncyWorkflowTransition getAutoTransition(
            EncyWorkflowStateInstance workflowStateInstance,
            T model,  Map<String, Serializable> workflowContext) {

        if (workflowStateInstance == null) {
            return null;
        }
        Map<String, Serializable> wc = WorkflowContextBuilder
                .putAll(workflowContext)
                .putModel(model)
                .build();

        ExecutionContext executionContext = new ExecutionContext(workflowStateInstance, wc);

        List<EncyWorkflowTransition> transitions =
                workflowStateInstance.getWorkflowState().getOutgoingTransitions();

        for (EncyWorkflowTransition transition : transitions) {
            executionContext.setTransitionName(transition.getName());
            boolean doTransition = encyWorkflowActionHandler.onTransitionDoAuto(executionContext);
            if (doTransition) {
                if (_log.isDebugEnabled()) {
                    _log.debug("Allowed auto transition " + transition.getName());
                }
                return transition;
            }
        }

        return null;
    }

    @Override
    public <T extends EncyWorkflowedModel> Boolean isTransitionAllowed(
            EncyWorkflowStateInstance workflowStateInstance,
            EncyWorkflowTransition transition,
            long userId,
            T model,
            ServiceContext serviceContext
    ) throws PortalException {

        if (transition == null) {
            // no transition
            return false;
        }
        if (workflowStateInstance == null) {
            // probably not under workflow, so workflow will not block it
            return true;
        }

        Map<String, Serializable> workflowContext =
                WorkflowContextBuilder
                        .fromServiceContext(serviceContext)
                        .putModel(model)
                        .build();

        if (model == null) {
            throw new InvalidParameterException("Model is not set when checking if transition is allowed");
        }

        ExecutionContext executionContext = new ExecutionContext<T>(workflowStateInstance, workflowContext);
        executionContext.setTransitionName(transition.getName());
        executionContext.setWorkflowStateInstance(workflowStateInstance);

        return encyWorkflowActionHandler.onTransitionAllow(executionContext);
    }

    @Override
    public <T extends EncyWorkflowedModel> Boolean isTransitionAllowed(
            EncyWorkflowStateInstance workflowStateInstance,
            String transitionName,
            long userId,
            T model,
            Map<String, Serializable> workflowContext
    ) throws PortalException {

        if (workflowStateInstance == null) {
            // probably not under workflow, so workflow will not block it
            return true;
        }

        if (model == null) {
            throw new InvalidParameterException("Model is not set when checking if transition is allowed");
        }

        Map<String, Serializable> wc = WorkflowContextBuilder
                .putAll(workflowContext)
                .putModel(model)
                .putUserId(userId)
                .build();

        ExecutionContext executionContext = new ExecutionContext(workflowStateInstance, wc);
        executionContext.setTransitionName(transitionName);

        return encyWorkflowActionHandler.onTransitionAllow(executionContext);
    }

    @Override
    public void stateEntry(EncyWorkflowStateInstance workflowStateInstance,
                           String transitionName, Map<String, Serializable> workflowContext
    ) {

        Map<String, Serializable> wc = WorkflowContextBuilder
                .putAll(workflowContext)
                .build();

        ExecutionContext executionContext = new ExecutionContext(workflowStateInstance, wc);
        executionContext.setTransitionName(transitionName);

        if (!Validator.isBlank(transitionName)) {
            executionContext.setTransitionName(transitionName);
            encyWorkflowActionHandler.onTransitionEnd(executionContext);
        }

        encyWorkflowActionHandler.onStateEntry(executionContext);
    }

    @Override
    public void stateEntry(EncyWorkflowStateInstance workflowStateInstance, Map<String, Serializable> workflowContext) {
        stateEntry(workflowStateInstance, StringPool.BLANK, workflowContext);
    }

    @Override
    public void stateExit(
            EncyWorkflowStateInstance workflowStateInstance, String transitionName,
            Map<String, Serializable> workflowContext
    ) {
        Map<String, Serializable> wc = WorkflowContextBuilder
                .putAll(workflowContext)
                .build();

        ExecutionContext executionContext = new ExecutionContext(workflowStateInstance, wc);
        executionContext.setTransitionName(transitionName);

        encyWorkflowActionHandler.onStateExit(executionContext);

        if (!Validator.isBlank(transitionName)) {
            executionContext.setTransitionName(transitionName);
            encyWorkflowActionHandler.onTransitionStart(executionContext);
        }
    }

    @Override
    public void stateExit(EncyWorkflowStateInstance workflowStateInstance, Map<String, Serializable> workflowContext) {
        stateExit(workflowStateInstance, StringPool.BLANK, workflowContext);
    }
    @Reference
    private EncyWorkflowActionHandler encyWorkflowActionHandler;
}
