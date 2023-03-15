package cz.csob.ency.workflow.definition;

import com.liferay.petra.string.StringPool;

public interface EncyWorkflowTransitionDefinition {
    default String getCssIcon() {
        return StringPool.BLANK;
    }

    default String getCssIconColor() {
        return StringPool.BLANK;
    }

    default String getDescription() {
        return "";
    }

    String getName();

    long getOrder();

    void setOrder(long order);

    String getSourceStateName();

    String getTargetStateName();

    default String getTitle() {
        return getName();
    }
}
