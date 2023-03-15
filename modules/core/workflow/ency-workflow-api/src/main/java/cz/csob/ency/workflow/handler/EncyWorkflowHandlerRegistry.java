package cz.csob.ency.workflow.handler;

import java.util.List;

public interface EncyWorkflowHandlerRegistry {
    <T> EncyWorkflowHandler<T> getWorkflowHandler(String className);

    List<EncyWorkflowHandler<?>> getWorkflowHandlers();

}
