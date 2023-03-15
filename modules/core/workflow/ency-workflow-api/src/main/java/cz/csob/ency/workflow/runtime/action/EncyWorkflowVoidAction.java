package cz.csob.ency.workflow.runtime.action;

import com.liferay.portal.kernel.exception.PortalException;
import cz.csob.ency.workflow.runtime.ExecutionContext;

public interface EncyWorkflowVoidAction<T> extends EncyWorkflowAction{
    void perform(ExecutionContext<T> executionContext);
}
