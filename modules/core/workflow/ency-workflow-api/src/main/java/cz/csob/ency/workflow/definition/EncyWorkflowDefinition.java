package cz.csob.ency.workflow.definition;

import com.liferay.portal.kernel.workflow.WorkflowModel;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface EncyWorkflowDefinition extends WorkflowModel {
    default String getDescription() {
        return "";
    }

    String getInitialStateName();

    Map<String, Object> getOptionalAttributes();

    String getTitle();

    String getTitle(String languageId);

    long getVersion();

    Map<String, EncyWorkflowStateDefinition> getWorkflowStates();

    Set<String> getWorkflowStatesNames();

    List<EncyWorkflowTransitionDefinition> getWorkflowTransitions();

    boolean isValid();
}
