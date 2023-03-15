package cz.csob.ency.workflow.runtime.action;

import com.liferay.portal.kernel.exception.PortalException;
import cz.csob.ency.workflow.runtime.ExecutionContext;

public interface EncyWorkflowBoolAction<T> extends EncyWorkflowAction {
    boolean perform(ExecutionContext<T> executionContext) throws PortalException;
}
