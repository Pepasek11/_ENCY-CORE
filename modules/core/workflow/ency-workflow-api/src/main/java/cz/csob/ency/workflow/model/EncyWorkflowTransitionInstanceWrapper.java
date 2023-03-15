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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EncyWorkflowTransitionInstance}.
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowTransitionInstance
 * @generated
 */
public class EncyWorkflowTransitionInstanceWrapper
	extends BaseModelWrapper<EncyWorkflowTransitionInstance>
	implements EncyWorkflowTransitionInstance,
			   ModelWrapper<EncyWorkflowTransitionInstance> {

	public EncyWorkflowTransitionInstanceWrapper(
		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance) {

		super(encyWorkflowTransitionInstance);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("transitionInstanceId", getTransitionInstanceId());
		attributes.put("transitionId", getTransitionId());
		attributes.put("stateId", getStateId());
		attributes.put("stateInstanceId", getStateInstanceId());
		attributes.put("workflowId", getWorkflowId());
		attributes.put("workflowInstanceId", getWorkflowInstanceId());
		attributes.put("version", getVersion());
		attributes.put("comment", getComment());
		attributes.put("targetStateId", getTargetStateId());
		attributes.put("targetStateInstanceId", getTargetStateInstanceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("workflowContext", getWorkflowContext());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long transitionInstanceId = (Long)attributes.get(
			"transitionInstanceId");

		if (transitionInstanceId != null) {
			setTransitionInstanceId(transitionInstanceId);
		}

		Long transitionId = (Long)attributes.get("transitionId");

		if (transitionId != null) {
			setTransitionId(transitionId);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		Long stateInstanceId = (Long)attributes.get("stateInstanceId");

		if (stateInstanceId != null) {
			setStateInstanceId(stateInstanceId);
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

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}

		Long targetStateId = (Long)attributes.get("targetStateId");

		if (targetStateId != null) {
			setTargetStateId(targetStateId);
		}

		Long targetStateInstanceId = (Long)attributes.get(
			"targetStateInstanceId");

		if (targetStateInstanceId != null) {
			setTargetStateInstanceId(targetStateInstanceId);
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

		String workflowContext = (String)attributes.get("workflowContext");

		if (workflowContext != null) {
			setWorkflowContext(workflowContext);
		}
	}

	@Override
	public EncyWorkflowTransitionInstance cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the comment of this ency workflow transition instance.
	 *
	 * @return the comment of this ency workflow transition instance
	 */
	@Override
	public String getComment() {
		return model.getComment();
	}

	/**
	 * Returns the company ID of this ency workflow transition instance.
	 *
	 * @return the company ID of this ency workflow transition instance
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this ency workflow transition instance.
	 *
	 * @return the create date of this ency workflow transition instance
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this ency workflow transition instance.
	 *
	 * @return the group ID of this ency workflow transition instance
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the primary key of this ency workflow transition instance.
	 *
	 * @return the primary key of this ency workflow transition instance
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the state ID of this ency workflow transition instance.
	 *
	 * @return the state ID of this ency workflow transition instance
	 */
	@Override
	public long getStateId() {
		return model.getStateId();
	}

	/**
	 * Returns the state instance ID of this ency workflow transition instance.
	 *
	 * @return the state instance ID of this ency workflow transition instance
	 */
	@Override
	public long getStateInstanceId() {
		return model.getStateInstanceId();
	}

	/**
	 * Returns the target state ID of this ency workflow transition instance.
	 *
	 * @return the target state ID of this ency workflow transition instance
	 */
	@Override
	public long getTargetStateId() {
		return model.getTargetStateId();
	}

	/**
	 * Returns the target state instance ID of this ency workflow transition instance.
	 *
	 * @return the target state instance ID of this ency workflow transition instance
	 */
	@Override
	public long getTargetStateInstanceId() {
		return model.getTargetStateInstanceId();
	}

	/**
	 * Returns the transition ID of this ency workflow transition instance.
	 *
	 * @return the transition ID of this ency workflow transition instance
	 */
	@Override
	public long getTransitionId() {
		return model.getTransitionId();
	}

	/**
	 * Returns the transition instance ID of this ency workflow transition instance.
	 *
	 * @return the transition instance ID of this ency workflow transition instance
	 */
	@Override
	public long getTransitionInstanceId() {
		return model.getTransitionInstanceId();
	}

	/**
	 * Returns the user ID of this ency workflow transition instance.
	 *
	 * @return the user ID of this ency workflow transition instance
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this ency workflow transition instance.
	 *
	 * @return the user name of this ency workflow transition instance
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this ency workflow transition instance.
	 *
	 * @return the user uuid of this ency workflow transition instance
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this ency workflow transition instance.
	 *
	 * @return the uuid of this ency workflow transition instance
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the version of this ency workflow transition instance.
	 *
	 * @return the version of this ency workflow transition instance
	 */
	@Override
	public long getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns the workflow context of this ency workflow transition instance.
	 *
	 * @return the workflow context of this ency workflow transition instance
	 */
	@Override
	public String getWorkflowContext() {
		return model.getWorkflowContext();
	}

	/**
	 * Returns the workflow ID of this ency workflow transition instance.
	 *
	 * @return the workflow ID of this ency workflow transition instance
	 */
	@Override
	public long getWorkflowId() {
		return model.getWorkflowId();
	}

	/**
	 * Returns the workflow instance ID of this ency workflow transition instance.
	 *
	 * @return the workflow instance ID of this ency workflow transition instance
	 */
	@Override
	public long getWorkflowInstanceId() {
		return model.getWorkflowInstanceId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the comment of this ency workflow transition instance.
	 *
	 * @param comment the comment of this ency workflow transition instance
	 */
	@Override
	public void setComment(String comment) {
		model.setComment(comment);
	}

	/**
	 * Sets the company ID of this ency workflow transition instance.
	 *
	 * @param companyId the company ID of this ency workflow transition instance
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ency workflow transition instance.
	 *
	 * @param createDate the create date of this ency workflow transition instance
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this ency workflow transition instance.
	 *
	 * @param groupId the group ID of this ency workflow transition instance
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the primary key of this ency workflow transition instance.
	 *
	 * @param primaryKey the primary key of this ency workflow transition instance
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the state ID of this ency workflow transition instance.
	 *
	 * @param stateId the state ID of this ency workflow transition instance
	 */
	@Override
	public void setStateId(long stateId) {
		model.setStateId(stateId);
	}

	/**
	 * Sets the state instance ID of this ency workflow transition instance.
	 *
	 * @param stateInstanceId the state instance ID of this ency workflow transition instance
	 */
	@Override
	public void setStateInstanceId(long stateInstanceId) {
		model.setStateInstanceId(stateInstanceId);
	}

	/**
	 * Sets the target state ID of this ency workflow transition instance.
	 *
	 * @param targetStateId the target state ID of this ency workflow transition instance
	 */
	@Override
	public void setTargetStateId(long targetStateId) {
		model.setTargetStateId(targetStateId);
	}

	/**
	 * Sets the target state instance ID of this ency workflow transition instance.
	 *
	 * @param targetStateInstanceId the target state instance ID of this ency workflow transition instance
	 */
	@Override
	public void setTargetStateInstanceId(long targetStateInstanceId) {
		model.setTargetStateInstanceId(targetStateInstanceId);
	}

	/**
	 * Sets the transition ID of this ency workflow transition instance.
	 *
	 * @param transitionId the transition ID of this ency workflow transition instance
	 */
	@Override
	public void setTransitionId(long transitionId) {
		model.setTransitionId(transitionId);
	}

	/**
	 * Sets the transition instance ID of this ency workflow transition instance.
	 *
	 * @param transitionInstanceId the transition instance ID of this ency workflow transition instance
	 */
	@Override
	public void setTransitionInstanceId(long transitionInstanceId) {
		model.setTransitionInstanceId(transitionInstanceId);
	}

	/**
	 * Sets the user ID of this ency workflow transition instance.
	 *
	 * @param userId the user ID of this ency workflow transition instance
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this ency workflow transition instance.
	 *
	 * @param userName the user name of this ency workflow transition instance
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this ency workflow transition instance.
	 *
	 * @param userUuid the user uuid of this ency workflow transition instance
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this ency workflow transition instance.
	 *
	 * @param uuid the uuid of this ency workflow transition instance
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the version of this ency workflow transition instance.
	 *
	 * @param version the version of this ency workflow transition instance
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
	 * Sets the workflow context of this ency workflow transition instance.
	 *
	 * @param workflowContext the workflow context of this ency workflow transition instance
	 */
	@Override
	public void setWorkflowContext(String workflowContext) {
		model.setWorkflowContext(workflowContext);
	}

	/**
	 * Sets the workflow ID of this ency workflow transition instance.
	 *
	 * @param workflowId the workflow ID of this ency workflow transition instance
	 */
	@Override
	public void setWorkflowId(long workflowId) {
		model.setWorkflowId(workflowId);
	}

	/**
	 * Sets the workflow instance ID of this ency workflow transition instance.
	 *
	 * @param workflowInstanceId the workflow instance ID of this ency workflow transition instance
	 */
	@Override
	public void setWorkflowInstanceId(long workflowInstanceId) {
		model.setWorkflowInstanceId(workflowInstanceId);
	}

	@Override
	protected EncyWorkflowTransitionInstanceWrapper wrap(
		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance) {

		return new EncyWorkflowTransitionInstanceWrapper(
			encyWorkflowTransitionInstance);
	}

}