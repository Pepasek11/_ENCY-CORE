/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package cz.csob.ency.workflow.model.impl;

import cz.csob.ency.workflow.model.EncyWorkflowState;
import cz.csob.ency.workflow.service.EncyWorkflowStateLocalServiceUtil;

/**
 * The extended model base implementation for the EncyWorkflowState service. Represents a row in the &quot;ency_workflowstate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EncyWorkflowStateImpl}.
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowStateImpl
 * @see EncyWorkflowState
 * @generated
 */
public abstract class EncyWorkflowStateBaseImpl
	extends EncyWorkflowStateModelImpl implements EncyWorkflowState {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ency workflow state model instance should use the <code>EncyWorkflowState</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			EncyWorkflowStateLocalServiceUtil.addEncyWorkflowState(this);
		}
		else {
			EncyWorkflowStateLocalServiceUtil.updateEncyWorkflowState(this);
		}
	}

}