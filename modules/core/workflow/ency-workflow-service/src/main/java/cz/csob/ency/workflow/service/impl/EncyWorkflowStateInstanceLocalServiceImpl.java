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
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.workflow.kaleo.runtime.util.WorkflowContextUtil;
import cz.csob.ency.workflow.constants.EncyWorkflowConstants;
import cz.csob.ency.workflow.util.WorkflowHelperUtils;
import cz.csob.ency.workflow.model.EncyWorkflowStateInstance;
import cz.csob.ency.workflow.model.impl.EncyWorkflowStateInstanceModelImpl;
import cz.csob.ency.workflow.service.base.EncyWorkflowStateInstanceLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Miroslav Čermák
 */
@Component(
        property = "model.class.name=cz.csob.ency.workflow.model.EncyWorkflowStateInstance",
        service = AopService.class
)
public class EncyWorkflowStateInstanceLocalServiceImpl
        extends EncyWorkflowStateInstanceLocalServiceBaseImpl {

    public EncyWorkflowStateInstance completeWorkflowStateInstance(
            long stateInstanceId, long userId, Map<String, Serializable> workflowContext
    ) throws PortalException {

        EncyWorkflowStateInstance wsi =
                getEncyWorkflowStateInstance(stateInstanceId);

        String userName = WorkflowHelperUtils.getUserName(userId);

        workflowContext.put(EncyWorkflowConstants.CONTEXT_USER_ID, userId);

        workflowContext.put(EncyWorkflowConstants.CONTEXT_USER_NAME, userName);

        wsi.setCompletedDate(new Date());
        wsi.setWorkflowContext(
                WorkflowContextUtil.convert(workflowContext)
        );

        EncyWorkflowStateInstance uwsi =
                updateEncyWorkflowStateInstance(wsi);

        return uwsi;
    }

    public void deleteEncyWorkflowInstanceStateInstances(long workflowInstanceId) {
        List<EncyWorkflowStateInstance> states =
                encyWorkflowStateInstancePersistence.findByWorkflowInstanceId(workflowInstanceId);

        for (EncyWorkflowStateInstance state : states) {
            deleteEncyWorkflowStateInstance(state);
        }

    }

    public EncyWorkflowStateInstance getCurrentWorkflowStateInstance(long workflowInstanceId) {
        return encyWorkflowStateInstancePersistence.fetchByWorkflowInstanceId_First(
                workflowInstanceId, OrderByComparatorFactoryUtil.create(
                        EncyWorkflowStateInstanceModelImpl.TABLE_NAME, "createDate", false)
        );
    }

    public EncyWorkflowStateInstance startWorkflowStateInstance(
            long stateId, long workflowId, long workflowInstanceId, long version,
            long groupId, long companyId, long userId, Map<String, Serializable> workflowContext
    ) {
        EncyWorkflowStateInstance wsi = create();

        //@todo update context with given params
        workflowContext.put(
                EncyWorkflowConstants.CONTEXT_STATE_INSTANCE_ID,
                wsi.getStateInstanceId()
        );

        String userName = WorkflowHelperUtils.getUserName(userId);
        Date now = new Date();

        wsi.setStateId(stateId);
        wsi.setWorkflowId(workflowId);
        wsi.setWorkflowInstanceId(workflowInstanceId);
        wsi.setVersion(version);
        wsi.setGroupId(groupId);
        wsi.setCompanyId(companyId);
        wsi.setUserId(userId);
        wsi.setUserName(userName);
        wsi.setCreateDate(now);
        wsi.setCreateDate(now);
        wsi.setCompletedDate(null);
        wsi.setWorkflowContext(
                WorkflowContextUtil.convert(workflowContext)
        );

        EncyWorkflowStateInstance uwsi =
                addEncyWorkflowStateInstance(wsi);

        return uwsi;
    }

    public EncyWorkflowStateInstance updateWorkflowStateInstance(
            long stateInstanceId, long userId, Map<String, Serializable> workflowContext
    ) throws PortalException {
        EncyWorkflowStateInstance wsi = getEncyWorkflowStateInstance(stateInstanceId);

        String userName = WorkflowHelperUtils.getUserName(userId);

        workflowContext.put(EncyWorkflowConstants.CONTEXT_USER_ID, userId);
        workflowContext.put(EncyWorkflowConstants.CONTEXT_USER_NAME, userName);

        wsi.setModifiedDate(new Date());
        wsi.setWorkflowContext(
                WorkflowContextUtil.convert(workflowContext)
        );

        EncyWorkflowStateInstance uwsi =
                updateEncyWorkflowStateInstance(wsi);

        return uwsi;
    }

    public EncyWorkflowStateInstance create() {
        long id = counterLocalService.increment(
                EncyWorkflowStateInstance.class.getName());

        return createEncyWorkflowStateInstance(id);
    }

}