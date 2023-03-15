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

import cz.csob.ency.workflow.model.EncyWorkflow;
import cz.csob.ency.workflow.model.EncyWorkflowTransition;
import cz.csob.ency.workflow.service.EncyWorkflowLocalServiceUtil;
import cz.csob.ency.workflow.service.EncyWorkflowTransitionLocalServiceUtil;

import java.util.List;

/**
 * @author Miroslav Čermák
 */
public class EncyWorkflowStateImpl extends EncyWorkflowStateBaseImpl {

    public Boolean isActive() {
        return getActive();
    }

    public Boolean isFinal() {
        return getIsFinal();
    }

    public Boolean isInitial() {
        return getIsInitial();
    }

    public EncyWorkflow getWorkflow() {
        if(_encyWorkflow==null) {
            _encyWorkflow = EncyWorkflowLocalServiceUtil.fetchEncyWorkflow(getWorkflowId());
        }
        return _encyWorkflow;
    }

    public List<EncyWorkflowTransition> getOutgoingTransitions(){
        return EncyWorkflowTransitionLocalServiceUtil.getOutgoingTransitions(getStateId());
    }

    private EncyWorkflow _encyWorkflow;
}
