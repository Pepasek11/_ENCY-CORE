package cz.csob.ency.workflow.definition;

import com.liferay.petra.string.StringPool;

import java.util.Collections;
import java.util.List;

public interface EncyWorkflowStateDefinition {
    default String getCssIcon() {
        return StringPool.BLANK;
    }

    default String getCssIconColor() {
        return StringPool.BLANK;
    }

    default String getCssLabelColor() {
        return "";
    }

    default String getDescription() {
        return "";
    }

    String getName();

    default String getTitle() {
        return getName();
    }

    default String getTitle(String languageId) {
        return getName();
    }

    default List<EncyWorkflowTransitionDefinition> getTransitions() {
        return Collections.emptyList();
    }

    default boolean isFinal() {
        return false;
    }

    default boolean isInitial() {
        return false;
    }

    default boolean isEditable() {
        return true;
    }

    default boolean isSearchable() {
        return true;
    }

    default boolean isPermanent() {
        return true;
    }

    ;
}
