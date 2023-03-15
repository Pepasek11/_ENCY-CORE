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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.workflow.kaleo.runtime.util.WorkflowContextUtil;
import cz.csob.ency.workflow.constants.EncyWorkflowConstants;
import cz.csob.ency.workflow.exception.WorkflowContextException;
import cz.csob.ency.workflow.model.EncyWorkflow;
import cz.csob.ency.workflow.model.EncyWorkflowInstance;
import cz.csob.ency.workflow.model.EncyWorkflowState;
import cz.csob.ency.workflow.model.EncyWorkflowStateInstance;
import cz.csob.ency.workflow.runtime.action.manager.EncyWorkflowActionManager;
import cz.csob.ency.workflow.service.EncyWorkflowLocalService;
import cz.csob.ency.workflow.service.EncyWorkflowStateInstanceLocalService;
import cz.csob.ency.workflow.service.EncyWorkflowStateLocalService;
import cz.csob.ency.workflow.service.EncyWorkflowTransitionInstanceLocalService;
import cz.csob.ency.workflow.service.base.EncyWorkflowInstanceLocalServiceBaseImpl;
import cz.csob.ency.workflow.util.WorkflowHelperUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author Miroslav Čermák
 */
@Component(
        property = "model.class.name=cz.csob.ency.workflow.model.EncyWorkflowInstance",
        service = AopService.class
)
public class EncyWorkflowInstanceLocalServiceImpl
        extends EncyWorkflowInstanceLocalServiceBaseImpl {

    private static final Log _log = LogFactoryUtil.getLog(
            EncyWorkflowInstanceLocalServiceImpl.class);

    public EncyWorkflowInstance create() {
        long id = counterLocalService.increment(EncyWorkflowInstance.class.getName());
        return encyWorkflowInstancePersistence.create(id);
    }

    @Override
    public EncyWorkflowInstance deleteEncyWorkflowInstance(String className, long primaryKey)
            throws PortalException {
        EncyWorkflowInstance workflowInstance =
                encyWorkflowInstancePersistence.fetchByC_C(className, primaryKey);
        if (Validator.isNull(workflowInstance)) {
            return null;
        }

        return deleteEncyWorkflowInstance(workflowInstance.getWorkflowInstanceId());
    }

    @Override
    public EncyWorkflowInstance deleteEncyWorkflowInstance(EncyWorkflowInstance workflowInstance)
            throws PortalException {
        return deleteEncyWorkflowInstance(workflowInstance.getWorkflowInstanceId());
    }

    @Override
    public EncyWorkflowInstance deleteEncyWorkflowInstance(long workflowInstanceId)
            throws PortalException {
        _encyWorkflowStateInstanceLocalService.deleteEncyWorkflowInstanceStateInstances(
                workflowInstanceId
        );

        _encyWorkflowTransitionInstanceLocalService.deleteEncyWorkflowInstanceTransitionInstances(
                workflowInstanceId
        );

        return super.deleteEncyWorkflowInstance(workflowInstanceId);

    }

    public EncyWorkflowInstance getWorkflowInstance(
            long companyId, long groupId, String className, long classPK) {
        return getWorkflowInstance(className, classPK);
    }

    public EncyWorkflowInstance getWorkflowInstance(
            String className, long classPK) {
        return encyWorkflowInstancePersistence.fetchByC_C(
                className, classPK
        );
    }

    public boolean hasWorkflowInstance(
            long companyId, long groupId, String className, long classPK) {
        return getWorkflowInstance(className, classPK) != null;
    }

    public boolean hasWorkflowInstance(
            String className, long classPK) {
        return encyWorkflowInstancePersistence.fetchByC_C(
                className, classPK
        ) != null;
    }

    public EncyWorkflowInstance startWorkflowInstance(
            long companyId, long groupId, long userId, String className, long classPK,
            Map<String, Serializable> workflowContext) throws PortalException {

        EncyWorkflowInstance workflowInstance = create();

        // Read additional info from context and validate
        long workflowId = GetterUtil.getLong(
                workflowContext.get(EncyWorkflowConstants.CONTEXT_WORKFLOW_ID)
        );

        if (0 == workflowId) {
            throw new WorkflowContextException("WorkflowId missing in context when expected.");
        }

        long version = GetterUtil.getLong(
                workflowContext.get(EncyWorkflowConstants.CONTEXT_WORKFLOW_VERSION)
        );

        EncyWorkflow workflow = _encyWorkflowLocalService.getEncyWorkflow(workflowId);
        EncyWorkflowState state = workflow.getInitialState();

        workflowContext.put(
                EncyWorkflowConstants.CONTEXT_STATE_ID,
                state.getStateId()
        );

        workflowContext.put(
                EncyWorkflowConstants.CONTEXT_STATE_NAME,
                state.getName()
        );

        // Set instance
        workflowInstance.setCompanyId(companyId);
        workflowInstance.setGroupId(groupId);
        workflowInstance.setUserId(userId);
        workflowInstance.setUserName(WorkflowHelperUtils.getUserName(userId));
        workflowInstance.setCreateDate(new Date());
        workflowInstance.setModifiedDate(new Date());
        workflowInstance.setClassName(className);
        workflowInstance.setClassPK(classPK);
        workflowInstance.setWorkflowId(workflowId);
        workflowInstance.setWorkflowVersion(version);
        workflowInstance.setWorkflowContext(WorkflowContextUtil.convert(workflowContext));

        // Save instance
        EncyWorkflowInstance updatedWorkflowInstance
                = addEncyWorkflowInstance(workflowInstance);

        // Update context
        workflowContext.put(
                EncyWorkflowConstants.CONTEXT_WORKFLOW_INSTANCE_ID,
                updatedWorkflowInstance.getPrimaryKey());


        EncyWorkflowStateInstance workflowStateInstance =
                _encyWorkflowStateInstanceLocalService.startWorkflowStateInstance(
                        state.getStateId(), workflowId, updatedWorkflowInstance.getPrimaryKey(),
                        version, groupId, companyId, userId, workflowContext
                );


        _encyWorkflowActionManager.stateEntry(workflowStateInstance, workflowContext);

        return updatedWorkflowInstance;
    }

    @Reference
    protected EncyWorkflowLocalService _encyWorkflowLocalService;
    @Reference
    protected EncyWorkflowStateInstanceLocalService _encyWorkflowStateInstanceLocalService;
    @Reference
    protected EncyWorkflowStateLocalService _encyWorkflowStateLocalService;
    @Reference
    private EncyWorkflowActionManager _encyWorkflowActionManager;
    @Reference
    private EncyWorkflowTransitionInstanceLocalService _encyWorkflowTransitionInstanceLocalService;
}