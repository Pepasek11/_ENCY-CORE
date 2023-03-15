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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the EncyWorkflowStateInstance service. Represents a row in the &quot;ency_workflowstateinstance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>cz.csob.ency.workflow.model.impl.EncyWorkflowStateInstanceModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>cz.csob.ency.workflow.model.impl.EncyWorkflowStateInstanceImpl</code>.
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowStateInstance
 * @generated
 */
@ProviderType
public interface EncyWorkflowStateInstanceModel
	extends BaseModel<EncyWorkflowStateInstance>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ency workflow state instance model instance should use the {@link EncyWorkflowStateInstance} interface instead.
	 */

	/**
	 * Returns the primary key of this ency workflow state instance.
	 *
	 * @return the primary key of this ency workflow state instance
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ency workflow state instance.
	 *
	 * @param primaryKey the primary key of this ency workflow state instance
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this ency workflow state instance.
	 *
	 * @return the uuid of this ency workflow state instance
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this ency workflow state instance.
	 *
	 * @param uuid the uuid of this ency workflow state instance
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the state instance ID of this ency workflow state instance.
	 *
	 * @return the state instance ID of this ency workflow state instance
	 */
	public long getStateInstanceId();

	/**
	 * Sets the state instance ID of this ency workflow state instance.
	 *
	 * @param stateInstanceId the state instance ID of this ency workflow state instance
	 */
	public void setStateInstanceId(long stateInstanceId);

	/**
	 * Returns the state ID of this ency workflow state instance.
	 *
	 * @return the state ID of this ency workflow state instance
	 */
	public long getStateId();

	/**
	 * Sets the state ID of this ency workflow state instance.
	 *
	 * @param stateId the state ID of this ency workflow state instance
	 */
	public void setStateId(long stateId);

	/**
	 * Returns the workflow ID of this ency workflow state instance.
	 *
	 * @return the workflow ID of this ency workflow state instance
	 */
	public long getWorkflowId();

	/**
	 * Sets the workflow ID of this ency workflow state instance.
	 *
	 * @param workflowId the workflow ID of this ency workflow state instance
	 */
	public void setWorkflowId(long workflowId);

	/**
	 * Returns the workflow instance ID of this ency workflow state instance.
	 *
	 * @return the workflow instance ID of this ency workflow state instance
	 */
	public long getWorkflowInstanceId();

	/**
	 * Sets the workflow instance ID of this ency workflow state instance.
	 *
	 * @param workflowInstanceId the workflow instance ID of this ency workflow state instance
	 */
	public void setWorkflowInstanceId(long workflowInstanceId);

	/**
	 * Returns the version of this ency workflow state instance.
	 *
	 * @return the version of this ency workflow state instance
	 */
	public long getVersion();

	/**
	 * Sets the version of this ency workflow state instance.
	 *
	 * @param version the version of this ency workflow state instance
	 */
	public void setVersion(long version);

	/**
	 * Returns the group ID of this ency workflow state instance.
	 *
	 * @return the group ID of this ency workflow state instance
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this ency workflow state instance.
	 *
	 * @param groupId the group ID of this ency workflow state instance
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this ency workflow state instance.
	 *
	 * @return the company ID of this ency workflow state instance
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this ency workflow state instance.
	 *
	 * @param companyId the company ID of this ency workflow state instance
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this ency workflow state instance.
	 *
	 * @return the user ID of this ency workflow state instance
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this ency workflow state instance.
	 *
	 * @param userId the user ID of this ency workflow state instance
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this ency workflow state instance.
	 *
	 * @return the user uuid of this ency workflow state instance
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this ency workflow state instance.
	 *
	 * @param userUuid the user uuid of this ency workflow state instance
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this ency workflow state instance.
	 *
	 * @return the user name of this ency workflow state instance
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this ency workflow state instance.
	 *
	 * @param userName the user name of this ency workflow state instance
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this ency workflow state instance.
	 *
	 * @return the create date of this ency workflow state instance
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this ency workflow state instance.
	 *
	 * @param createDate the create date of this ency workflow state instance
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this ency workflow state instance.
	 *
	 * @return the modified date of this ency workflow state instance
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this ency workflow state instance.
	 *
	 * @param modifiedDate the modified date of this ency workflow state instance
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the completed date of this ency workflow state instance.
	 *
	 * @return the completed date of this ency workflow state instance
	 */
	public Date getCompletedDate();

	/**
	 * Sets the completed date of this ency workflow state instance.
	 *
	 * @param completedDate the completed date of this ency workflow state instance
	 */
	public void setCompletedDate(Date completedDate);

	/**
	 * Returns the workflow context of this ency workflow state instance.
	 *
	 * @return the workflow context of this ency workflow state instance
	 */
	@AutoEscape
	public String getWorkflowContext();

	/**
	 * Sets the workflow context of this ency workflow state instance.
	 *
	 * @param workflowContext the workflow context of this ency workflow state instance
	 */
	public void setWorkflowContext(String workflowContext);

	@Override
	public EncyWorkflowStateInstance cloneWithOriginalValues();

}