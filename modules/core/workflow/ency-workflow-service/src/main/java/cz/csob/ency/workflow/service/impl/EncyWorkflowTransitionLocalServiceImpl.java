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
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.workflow.definition.EncyWorkflowTransitionDefinition;
import cz.csob.ency.workflow.model.EncyWorkflowState;
import cz.csob.ency.workflow.model.EncyWorkflowTransition;
import cz.csob.ency.workflow.service.base.EncyWorkflowTransitionLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Miroslav Čermák
 */
@Component(
        property = "model.class.name=cz.csob.ency.workflow.model.EncyWorkflowTransition",
        service = AopService.class
)
public class EncyWorkflowTransitionLocalServiceImpl
        extends EncyWorkflowTransitionLocalServiceBaseImpl {

    private static final Log _log = LogFactoryUtil.getLog(
            EncyWorkflowTransitionLocalServiceBaseImpl.class);

    /**
     * Create new EncyWorkflowState entry, but do not persist it.
     *
     * @return EncyWorkflowState
     */
    @Transactional(enabled = false)
    public EncyWorkflowTransition create() {
        long primaryKey = counterLocalService.increment(
                EncyWorkflowTransition.class.getName());

        EncyWorkflowTransition entry =
                encyWorkflowTransitionPersistence.create(primaryKey);

        return entry;
    }

    /**
     * Deactivae old states for given workflow. List of valid states is given and all other states are
     * considered ad deprecated, thus are marked inactive.
     *
     * @param stateId
     * @param activeTransitionNames
     */
    public void deactivateOldWorkflowStateTransitions(long stateId, Set<String> activeTransitionNames) {
        ActionableDynamicQuery adq = getActionableDynamicQuery();

        adq.setAddCriteriaMethod(new ActionableDynamicQuery.AddCriteriaMethod() {
            @Override
            public void addCriteria(DynamicQuery dynamicQuery) {
                if (activeTransitionNames.size() > 0) {
                    dynamicQuery.add(
                            RestrictionsFactoryUtil.not(
                                    RestrictionsFactoryUtil.in("name", activeTransitionNames)
                            )
                    );
                }

                dynamicQuery.add(
                        RestrictionsFactoryUtil.eq("stateId", stateId)
                );
            }
        });

        adq.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<EncyWorkflowTransition>() {
            @Override
            public void performAction(EncyWorkflowTransition entry) throws PortalException {
                if (entry.isActive()) {
                    entry.setActive(false);
                    if (_log.isDebugEnabled()) {
                        _log.debug("Deactivating transition " + entry.getName());
                    }
                    encyWorkflowTransitionPersistence.update(entry);
                }
            }
        });

        try {
            adq.performActions();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public EncyWorkflowTransition fetchEncyWorkflowTransition(long stateId, String name) {
        return encyWorkflowTransitionPersistence.fetchByS_N(stateId, name);
    }

    @Override
    public List<EncyWorkflowTransition> getOutgoingTransitions(long stateId) {
        return encyWorkflowTransitionPersistence.findByState(stateId)
                .stream().filter(t -> t.isActive())
                .collect(Collectors.toList());
    }


    /**
     * Save (add or update) Ency Workflow State into persistence. Transitions are saved separately at the workflow
     * level to have available all target state references (State Ids)
     *
     * @param definition
     * @param sourceEntry
     * @return
     */
    @Transactional
    @Override
    public EncyWorkflowTransition saveWorkflowTransition(
            EncyWorkflowTransitionDefinition definition,
            EncyWorkflowState sourceEntry,
            EncyWorkflowState targetEntry
    ) {
        _log.debug("Saving workflow transition [" + definition.getName() + "]");

        EncyWorkflowTransition entry = encyWorkflowTransitionPersistence.fetchByS_N(
                sourceEntry.getPrimaryKey(), definition.getName()
        );

        if (Validator.isNull(entry)) {
            _log.debug("New workflow transition - CREATE " + sourceEntry.getName() + "::" + definition.getName());

            entry = create();
        }

        entry.setActive(true);
        entry.setStateId(sourceEntry.getStateId());
        entry.setWorkflowId(sourceEntry.getWorkflowId());

        entry.setName(definition.getName());
        entry.setTitle(definition.getTitle());
        entry.setDescription(definition.getDescription());
        entry.setCssIcon(definition.getCssIcon());
        entry.setCssIconColor(definition.getCssIconColor());
        entry.setTargetStateName(definition.getTargetStateName());
        entry.setTargetStateId(targetEntry.getPrimaryKey());
        entry.setVersion(sourceEntry.getVersion());

        if (entry.isNew()) {
            entry.setCreateDate(new Date());
        }

        if (/* @todo entry.hasChanged() */ true) {
            entry.setModifiedDate(new Date());
        }


        EncyWorkflowTransition persistedEntry =
                encyWorkflowTransitionPersistence.update(entry);

        return persistedEntry;

    }
}