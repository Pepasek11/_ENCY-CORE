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

import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.workflow.exception.NoSuchStateException;
import cz.csob.ency.workflow.model.EncyWorkflow;
import cz.csob.ency.workflow.model.EncyWorkflowState;
import cz.csob.ency.workflow.service.EncyWorkflowLocalService;
import cz.csob.ency.workflow.service.EncyWorkflowLocalServiceUtil;
import cz.csob.ency.workflow.service.EncyWorkflowStateLocalServiceUtil;

import javax.validation.Valid;

/**
 * @author Miroslav Čermák
 */
public class EncyWorkflowImpl
        extends EncyWorkflowBaseImpl {

    public Boolean isActive() {
        return getActive();
    }

    public EncyWorkflowState getInitialState() throws NoSuchStateException {
        if(Validator.isNull(_initialState)) {
            _initialState = EncyWorkflowStateLocalServiceUtil.getEncyWorkflowState(
                    getWorkflowId(),
                    getInitialStateName()
            );
        }

        if(Validator.isNull(_initialState)) {
            throw new NoSuchStateException("Unable to get initial state for workflow "+getWorkflowId());
        }

        return _initialState;
    }

    public EncyWorkflow getWorkflow() {
        return EncyWorkflowLocalServiceUtil.fetchEncyWorkflow(getWorkflowId());
    }

    protected EncyWorkflowState _initialState = null;
}