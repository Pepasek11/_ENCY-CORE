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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EncyWorkflowStateInstance}.
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowStateInstance
 * @generated
 */
public class EncyWorkflowStateInstanceWrapper
	extends BaseModelWrapper<EncyWorkflowStateInstance>
	implements EncyWorkflowStateInstance,
			   ModelWrapper<EncyWorkflowStateInstance> {

	public EncyWorkflowStateInstanceWrapper(
		EncyWorkflowStateInstance encyWorkflowStateInstance) {

		super(encyWorkflowStateInstance);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("stateInstanceId", getStateInstanceId());
		attributes.put("stateId", getStateId());
		attributes.put("workflowId", getWorkflowId());
		attributes.put("workflowInstanceId", getWorkflowInstanceId());
		attributes.put("version", getVersion());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("completedDate", getCompletedDate());
		attributes.put("workflowContext", getWorkflowContext());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long stateInstanceId = (Long)attributes.get("stateInstanceId");

		if (stateInstanceId != null) {
			setStateInstanceId(stateInstanceId);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		Long workflowId = (Long)attributes.get("workflowId");

		if (workflowId != null) {
			setWorkflowId(workflowId);
		}

		Long workflowInstanceId = (Long)attributes.get("workflowInstanceId");

		if (workflowInstanceId != null) {
			setWorkflowInstanceId(workflowInstanceId);
		}

		Long version = (Long)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date completedDate = (Date)attributes.get("completedDate");

		if (completedDate != null) {
			setCompletedDate(completedDate);
		}

		String workflowContext = (String)attributes.get("workflowContext");

		if (workflowContext != null) {
			setWorkflowContext(workflowContext);
		}
	}

	@Override
	public EncyWorkflowStateInstance cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this ency workflow state instance.
	 *
	 * @return the company ID of this ency workflow state instance
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the completed date of this ency workflow state instance.
	 *
	 * @return the completed date of this ency workflow state instance
	 */
	@Override
	public Date getCompletedDate() {
		return model.getCompletedDate();
	}

	/**
	 * Returns the create date of this ency workflow state instance.
	 *
	 * @return the create date of this ency workflow state instance
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this ency workflow state instance.
	 *
	 * @return the group ID of this ency workflow state instance
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this ency workflow state instance.
	 *
	 * @return the modified date of this ency workflow state instance
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this ency workflow state instance.
	 *
	 * @return the primary key of this ency workflow state instance
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the state ID of this ency workflow state instance.
	 *
	 * @return the state ID of this ency workflow state instance
	 */
	@Override
	public long getStateId() {
		return model.getStateId();
	}

	/**
	 * Returns the state instance ID of this ency workflow state instance.
	 *
	 * @return the state instance ID of this ency workflow state instance
	 */
	@Override
	public long getStateInstanceId() {
		return model.getStateInstanceId();
	}

	/**
	 * Returns the user ID of this ency workflow state instance.
	 *
	 * @return the user ID of this ency workflow state instance
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this ency workflow state instance.
	 *
	 * @return the user name of this ency workflow state instance
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this ency workflow state instance.
	 *
	 * @return the user uuid of this ency workflow state instance
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this ency workflow state instance.
	 *
	 * @return the uuid of this ency workflow state instance
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the version of this ency workflow state instance.
	 *
	 * @return the version of this ency workflow state instance
	 */
	@Override
	public long getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns the workflow context of this ency workflow state instance.
	 *
	 * @return the workflow context of this ency workflow state instance
	 */
	@Override
	public String getWorkflowContext() {
		return model.getWorkflowContext();
	}

	/**
	 * Returns the workflow ID of this ency workflow state instance.
	 *
	 * @return the workflow ID of this ency workflow state instance
	 */
	@Override
	public long getWorkflowId() {
		return model.getWorkflowId();
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowInstance
		getWorkflowInstance() {

		return model.getWorkflowInstance();
	}

	/**
	 * Returns the workflow instance ID of this ency workflow state instance.
	 *
	 * @return the workflow instance ID of this ency workflow state instance
	 */
	@Override
	public long getWorkflowInstanceId() {
		return model.getWorkflowInstanceId();
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowState getWorkflowState() {
		return model.getWorkflowState();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this ency workflow state instance.
	 *
	 * @param companyId the company ID of this ency workflow state instance
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the completed date of this ency workflow state instance.
	 *
	 * @param completedDate the completed date of this ency workflow state instance
	 */
	@Override
	public void setCompletedDate(Date completedDate) {
		model.setCompletedDate(completedDate);
	}

	/**
	 * Sets the create date of this ency workflow state instance.
	 *
	 * @param createDate the create date of this ency workflow state instance
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this ency workflow state instance.
	 *
	 * @param groupId the group ID of this ency workflow state instance
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this ency workflow state instance.
	 *
	 * @param modifiedDate the modified date of this ency workflow state instance
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this ency workflow state instance.
	 *
	 * @param primaryKey the primary key of this ency workflow state instance
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the state ID of this ency workflow state instance.
	 *
	 * @param stateId the state ID of this ency workflow state instance
	 */
	@Override
	public void setStateId(long stateId) {
		model.setStateId(stateId);
	}

	/**
	 * Sets the state instance ID of this ency workflow state instance.
	 *
	 * @param stateInstanceId the state instance ID of this ency workflow state instance
	 */
	@Override
	public void setStateInstanceId(long stateInstanceId) {
		model.setStateInstanceId(stateInstanceId);
	}

	/**
	 * Sets the user ID of this ency workflow state instance.
	 *
	 * @param userId the user ID of this ency workflow state instance
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this ency workflow state instance.
	 *
	 * @param userName the user name of this ency workflow state instance
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this ency workflow state instance.
	 *
	 * @param userUuid the user uuid of this ency workflow state instance
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this ency workflow state instance.
	 *
	 * @param uuid the uuid of this ency workflow state instance
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the version of this ency workflow state instance.
	 *
	 * @param version the version of this ency workflow state instance
	 */
	@Override
	public void setVersion(long version) {
		model.setVersion(version);
	}

	@Override
	public void setWorkflowContext(Map<String, Serializable> workflowContext) {
		model.setWorkflowContext(workflowContext);
	}

	/**
	 * Sets the workflow context of this ency workflow state instance.
	 *
	 * @param workflowContext the workflow context of this ency workflow state instance
	 */
	@Override
	public void setWorkflowContext(String workflowContext) {
		model.setWorkflowContext(workflowContext);
	}

	/**
	 * Sets the workflow ID of this ency workflow state instance.
	 *
	 * @param workflowId the workflow ID of this ency workflow state instance
	 */
	@Override
	public void setWorkflowId(long workflowId) {
		model.setWorkflowId(workflowId);
	}

	/**
	 * Sets the workflow instance ID of this ency workflow state instance.
	 *
	 * @param workflowInstanceId the workflow instance ID of this ency workflow state instance
	 */
	@Override
	public void setWorkflowInstanceId(long workflowInstanceId) {
		model.setWorkflowInstanceId(workflowInstanceId);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected EncyWorkflowStateInstanceWrapper wrap(
		EncyWorkflowStateInstance encyWorkflowStateInstance) {

		return new EncyWorkflowStateInstanceWrapper(encyWorkflowStateInstance);
	}

}