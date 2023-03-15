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
import cz.csob.ency.workflow.definition.EncyWorkflowStateDefinition;
import cz.csob.ency.workflow.exception.NoSuchStateException;
import cz.csob.ency.workflow.model.EncyWorkflow;
import cz.csob.ency.workflow.model.EncyWorkflowState;
import cz.csob.ency.workflow.service.EncyWorkflowTransitionLocalService;
import cz.csob.ency.workflow.service.base.EncyWorkflowStateLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Collections;
import java.util.Date;
import java.util.Set;

/**
 * @author Miroslav Čermák
 */
@Component(
        property = "model.class.name=cz.csob.ency.workflow.model.EncyWorkflowState",
        service = AopService.class
)
public class EncyWorkflowStateLocalServiceImpl
        extends EncyWorkflowStateLocalServiceBaseImpl {

    private static final Log _log = LogFactoryUtil.getLog(
            EncyWorkflowStateLocalServiceBaseImpl.class);

    /**
     * Create new EncyWorkflowState entry, but do not persist it.
     * @return EncyWorkflowState
     */
    @Transactional(enabled = false)
    public EncyWorkflowState create() {
        long primaryKey = counterLocalService.increment(
                EncyWorkflowState.class.getName());

        EncyWorkflowState entry = encyWorkflowStatePersistence.create(primaryKey);

        return entry;
    }

    /**
     * Deactivae old states for given workflow. List of valid states is given and all other states are
     * considered ad deprecated, thus are marked inactive.
     * @param workflowId
     * @param activeStatesNames
     */
    public void deactivateOldWorkflowStates(long workflowId, Set<String> activeStatesNames) {
        ActionableDynamicQuery adq = getActionableDynamicQuery();

        adq.setAddCriteriaMethod(new ActionableDynamicQuery.AddCriteriaMethod() {
            @Override
            public void addCriteria(DynamicQuery dynamicQuery) {
                if (activeStatesNames.size() > 0) {
                    dynamicQuery.add(
                            RestrictionsFactoryUtil.not(
                                    RestrictionsFactoryUtil.in("name", activeStatesNames)
                            )
                    );
                }

                dynamicQuery.add(
                        RestrictionsFactoryUtil.eq("workflowId", workflowId)
                );
            }
        });

        adq.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<EncyWorkflowState>() {
            @Override
            public void performAction(EncyWorkflowState entry) throws PortalException {
                if(entry.isActive()) {
                    entry.setActive(false);
                    _log.debug("Deactivating state " + entry.getName());
                    encyWorkflowStatePersistence.update(entry);

                    encyWorkflowTransitionLocalService.deactivateOldWorkflowStateTransitions(
                            entry.getStateId(), Collections.EMPTY_SET
                    );
                }
            }
        });

        try {
            adq.performActions();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public EncyWorkflowState getEncyWorkflowState(long workflowId, String stateName)
            throws NoSuchStateException {

        return encyWorkflowStatePersistence.findByW_N(workflowId, stateName);
    }


    /**
     * Save (add or update) Ency Workflow State into persistence. Transitions are saved in workflow service, after
     * references to all states are available.
     * @param definition
     * @param workflowEntry
     * @return
     */
    @Transactional
    @Override
    public EncyWorkflowState saveWorkflowState(EncyWorkflowStateDefinition definition, EncyWorkflow workflowEntry) {
        _log.debug("Saving workflow state [" + definition.getName() + "]");

        EncyWorkflowState entry = encyWorkflowStatePersistence.fetchByW_N(
                workflowEntry.getPrimaryKey(), definition.getName()
        );

        if (Validator.isNull(entry)) {
            if(_log.isDebugEnabled()) {
                _log.debug("New workflow state - CREATE " + workflowEntry.getClassName() +
                        "::" + definition.getName());
            }
            entry = create();
        }

        entry.setActive(true);
        entry.setWorkflowId(workflowEntry.getPrimaryKey());

        entry.setName(definition.getName());
        entry.setTitle(definition.getTitle());
        entry.setDescription(definition.getDescription());
        entry.setCssIcon(definition.getCssIcon());
        entry.setCssIconColor(definition.getCssIconColor());
        entry.setCssLabelColor(definition.getCssLabelColor());
        entry.setIsFinal(definition.isFinal());
        entry.setIsInitial(definition.isInitial());
        entry.setIsEditable(definition.isEditable());
        entry.setIsSearchable(definition.isSearchable());
        entry.setIsPermanent(definition.isPermanent());

        entry.setVersion(workflowEntry.getVersion());

        if (entry.isNew()) {
            entry.setCreateDate(new Date());
        }

        if (/* @todo entry.hasChanged() */ true) {
            entry.setModifiedDate(new Date());
        }


        EncyWorkflowState persistedEntry =
                encyWorkflowStatePersistence.update(entry);

        return persistedEntry;

    }

    @Reference
    protected EncyWorkflowTransitionLocalService encyWorkflowTransitionLocalService;
}
