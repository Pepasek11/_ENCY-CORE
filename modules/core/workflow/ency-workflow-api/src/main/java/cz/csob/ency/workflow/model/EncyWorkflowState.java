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

package cz.csob.ency.workflow.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the EncyWorkflowState service. Represents a row in the &quot;ency_workflowstate&quot; database table, with each column mapped to a property of this class.
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowStateModel
 * @generated
 */
@ImplementationClassName(
	"cz.csob.ency.workflow.model.impl.EncyWorkflowStateImpl"
)
@ProviderType
public interface EncyWorkflowState
	extends EncyWorkflowStateModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>cz.csob.ency.workflow.model.impl.EncyWorkflowStateImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<EncyWorkflowState, Long> STATE_ID_ACCESSOR =
		new Accessor<EncyWorkflowState, Long>() {

			@Override
			public Long get(EncyWorkflowState encyWorkflowState) {
				return encyWorkflowState.getStateId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<EncyWorkflowState> getTypeClass() {
				return EncyWorkflowState.class;
			}

		};

	public Boolean isActive();

	public Boolean isFinal();

	public Boolean isInitial();

	public cz.csob.ency.workflow.model.EncyWorkflow getWorkflow();

	public java.util.List<cz.csob.ency.workflow.model.EncyWorkflowTransition>
		getOutgoingTransitions();

}