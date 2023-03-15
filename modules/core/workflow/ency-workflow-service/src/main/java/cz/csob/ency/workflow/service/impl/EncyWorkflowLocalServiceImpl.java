/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package cz.csob.ency.workflow.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.workflow.definition.EncyWorkflowDefinition;
import cz.csob.ency.workflow.model.EncyWorkflow;
import cz.csob.ency.workflow.model.EncyWorkflowState;
import cz.csob.ency.workflow.service.EncyWorkflowStateLocalService;
import cz.csob.ency.workflow.service.EncyWorkflowTransitionLocalService;
import cz.csob.ency.workflow.service.base.EncyWorkflowLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Miroslav Čermák
 */
@Component(
        property = "model.class.name=cz.csob.ency.workflow.model.EncyWorkflow",
        service = AopService.class
)
public class EncyWorkflowLocalServiceImpl
        extends EncyWorkflowLocalServiceBaseImpl {

    private static final Log _log = LogFactoryUtil.getLog(
            EncyWorkflowLocalServiceImpl.class);

    @Transactional(enabled = false)
    public EncyWorkflow create() {
        long primaryKey = counterLocalService.increment(
                EncyWorkflow.class.getName());

        EncyWorkflow entry = encyWorkflowPersistence.create(primaryKey);

        return entry;
    }

    /**
     * Deactivates workflow entry, i.e. when definition is unloaded.
     * @param definitionClass
     * @return
     */
    public EncyWorkflow deactivateWorkflow(String definitionClass) {
        EncyWorkflow workflowEntry = encyWorkflowPersistence.fetchByClassName(
                definitionClass
        );

        if (Validator.isNotNull(workflowEntry)) {
            workflowEntry.setActive(false);

            workflowEntry = encyWorkflowPersistence.update(workflowEntry);

            encyWorkflowStateLocalService.deactivateOldWorkflowStates(
                    workflowEntry.getWorkflowId(), Collections.EMPTY_SET
            );
        }

        return workflowEntry;
    }

    @Override
    public EncyWorkflow fetchEncyWorkflow(String className) {
        return encyWorkflowPersistence.fetchByClassName(className);
    }

    /**
     * Save (Add or update) Ency Workflow into persistence. Also save its states.
     *
     * @param definition
     * @return
     */
    @Transactional
    @Override
    public EncyWorkflow saveWorkflow(EncyWorkflowDefinition definition) {
        _log.debug("Saving workflow " + definition.getClass());

        EncyWorkflow workflow = encyWorkflowPersistence.fetchByClassName(
                definition.getClass().getName()
        );

        if (Validator.isNull(workflow)) {
            _log.warn("New workflow - CREATE");
            workflow = create();
        }

        //@todo skip when def version < db version?

        workflow.setActive(true);

        workflow.setClassName(definition.getClass().getName());
        workflow.setTitle(definition.getTitle());
        workflow.setDescription(definition.getDescription());
        workflow.setVersion(definition.getVersion());
        workflow.setInitialStateName(definition.getInitialStateName());

        if (workflow.isNew()) {
            workflow.setCreateDate(new Date());
        }

        if (/* @todo workflow.hasChanged() */ true) {
            workflow.setModifiedDate(new Date());
        }


        EncyWorkflow persistedWorkflowEntry =
                encyWorkflowPersistence.update(workflow);

        Map<String, EncyWorkflowState> stateEntries = new HashMap<>();

        //update nodes
        definition.getWorkflowStates().forEach((stateName, stateDefinition) -> {
            try {
                EncyWorkflowState stateEntry =
                        encyWorkflowStateLocalService.saveWorkflowState(
                                stateDefinition, persistedWorkflowEntry
                        );

                stateEntries.put(stateEntry.getName(), stateEntry);

                encyWorkflowTransitionLocalService.deactivateOldWorkflowStateTransitions(
                        stateEntry.getStateId(),
                        stateDefinition.getTransitions().stream().map(
                                td -> td.getName()).collect(Collectors.toSet())
                );

            } catch (Exception e) {
                _log.error("Error when saving workflow state", e);
            }
        });

        // deactivate old nodes, not in current version of workflow. Do not delete it if for backward data reference
        encyWorkflowStateLocalService.deactivateOldWorkflowStates(
                persistedWorkflowEntry.getPrimaryKey(), definition.getWorkflowStatesNames()
        );

        // Update transitions. Must be here, so target states are available
        definition.getWorkflowTransitions().forEach(transitionDefinition -> {
            EncyWorkflowState sourceEntry = stateEntries.get(transitionDefinition.getSourceStateName());
            EncyWorkflowState targetEntry = stateEntries.get(transitionDefinition.getTargetStateName());
            encyWorkflowTransitionLocalService.saveWorkflowTransition(
                    transitionDefinition, sourceEntry, targetEntry
            );
        });


        return workflow;

    }

    @Reference
    protected EncyWorkflowStateLocalService encyWorkflowStateLocalService;

    @Reference
    protected EncyWorkflowTransitionLocalService encyWorkflowTransitionLocalService;
}