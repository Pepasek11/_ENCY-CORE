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
import com.liferay.portal.workflow.kaleo.runtime.util.WorkflowContextUtil;
import cz.csob.ency.workflow.constants.EncyWorkflowConstants;
import cz.csob.ency.workflow.util.WorkflowHelperUtils;
import cz.csob.ency.workflow.model.EncyWorkflowTransitionInstance;
import cz.csob.ency.workflow.service.EncyWorkflowStateInstanceLocalService;
import cz.csob.ency.workflow.service.EncyWorkflowTransitionLocalService;
import cz.csob.ency.workflow.service.base.EncyWorkflowTransitionInstanceLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Miroslav Čermák
 */
@Component(
        property = "model.class.name=cz.csob.ency.workflow.model.EncyWorkflowTransitionInstance",
        service = AopService.class
)
public class EncyWorkflowTransitionInstanceLocalServiceImpl
        extends EncyWorkflowTransitionInstanceLocalServiceBaseImpl {


    @Override
    public EncyWorkflowTransitionInstance addEncyWorkflowTransitionInstance(
            long transitionId, long stateId, long stateInstanceId,
            long workflowId, long workflowInstanceId,
            long targetStateId, long targetStateInstanceId, long version,
            long groupId, long companyId, long userId, String comment,
            Map<String, Serializable> workflowContext
    ) throws PortalException {

        EncyWorkflowTransitionInstance wti = create();

        workflowContext.put(
                EncyWorkflowConstants.CONTEXT_TRANSITION_INSTANCE_ID,
                wti.getTransitionInstanceId()
        );

        workflowContext.put(
                EncyWorkflowConstants.CONTEXT_TRANSITION_ID,
                wti.getTransitionInstanceId()
        );

        workflowContext.put(
                EncyWorkflowConstants.CONTEXT_COMMENT,
                comment
        );

        String userName = WorkflowHelperUtils.getUserName(userId);
        Date now = new Date();

        wti.setTransitionId(transitionId);
        wti.setStateId(stateId);
        wti.setStateInstanceId(stateInstanceId);
        wti.setWorkflowId(workflowId);
        wti.setWorkflowInstanceId(workflowInstanceId);
        wti.setVersion(version);
        wti.setTargetStateId(targetStateId);
        wti.setTargetStateInstanceId(targetStateInstanceId);
        wti.setGroupId(groupId);
        wti.setCompanyId(companyId);
        wti.setUserId(userId);
        wti.setUserName(userName);
        wti.setCreateDate(now);
        wti.setCreateDate(now);
        wti.setComment(comment);
        wti.setWorkflowContext(
                WorkflowContextUtil.convert(workflowContext)
        );

        return updateEncyWorkflowTransitionInstance(wti);
    }

    public long deleteEncyWorkflowInstanceTransitionInstances(
            long workflowInstanceId
    ) {
        List<EncyWorkflowTransitionInstance> instances =
            encyWorkflowTransitionInstancePersistence.findByWorkflowInstanceId(workflowInstanceId);

        for(EncyWorkflowTransitionInstance instance:instances){
            encyWorkflowTransitionInstancePersistence.remove(instance);
        }

        return instances.size();
    }

    public EncyWorkflowTransitionInstance create() {
        long id = counterLocalService.increment(
                EncyWorkflowTransitionInstance.class.getName());

        return createEncyWorkflowTransitionInstance(id);
    }
    @Reference
    private EncyWorkflowStateInstanceLocalService _encyWorkflowStateInstanceLocalService;
    @Reference
    private EncyWorkflowTransitionLocalService _encyWorkflowTransitionLocalService;
}