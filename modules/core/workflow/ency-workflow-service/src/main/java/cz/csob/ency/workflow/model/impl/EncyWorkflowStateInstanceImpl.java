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

package cz.csob.ency.workflow.model.impl;

import com.liferay.portal.workflow.kaleo.runtime.util.WorkflowContextUtil;
import cz.csob.ency.workflow.model.EncyWorkflowInstance;
import cz.csob.ency.workflow.model.EncyWorkflowState;
import cz.csob.ency.workflow.service.EncyWorkflowInstanceLocalServiceUtil;
import cz.csob.ency.workflow.service.EncyWorkflowStateLocalServiceUtil;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Miroslav Čermák
 */
public class EncyWorkflowStateInstanceImpl
        extends EncyWorkflowStateInstanceBaseImpl {

    public EncyWorkflowInstance getWorkflowInstance() {
        if (_encyWorkflowInstance == null) {
            _encyWorkflowInstance = EncyWorkflowInstanceLocalServiceUtil.fetchEncyWorkflowInstance(getWorkflowInstanceId());
        }
        return _encyWorkflowInstance;
    }

    public EncyWorkflowState getWorkflowState() {
        return EncyWorkflowStateLocalServiceUtil.fetchEncyWorkflowState(getStateId());
    }

    public void setWorkflowContext(Map<String, Serializable> workflowContext){
           setWorkflowContext(WorkflowContextUtil.convert(workflowContext));
    }

    private EncyWorkflowInstance _encyWorkflowInstance;
}