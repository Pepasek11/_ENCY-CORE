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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EncyWorkflowInstance}.
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowInstance
 * @generated
 */
public class EncyWorkflowInstanceWrapper
	extends BaseModelWrapper<EncyWorkflowInstance>
	implements EncyWorkflowInstance, ModelWrapper<EncyWorkflowInstance> {

	public EncyWorkflowInstanceWrapper(
		EncyWorkflowInstance encyWorkflowInstance) {

		super(encyWorkflowInstance);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("workflowInstanceId", getWorkflowInstanceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("workflowId", getWorkflowId());
		attributes.put("workflowVersion", getWorkflowVersion());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("workflowContext", getWorkflowContext());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long workflowInstanceId = (Long)attributes.get("workflowInstanceId");

		if (workflowInstanceId != null) {
			setWorkflowInstanceId(workflowInstanceId);
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

		Long workflowId = (Long)attributes.get("workflowId");

		if (workflowId != null) {
			setWorkflowId(workflowId);
		}

		Long workflowVersion = (Long)attributes.get("workflowVersion");

		if (workflowVersion != null) {
			setWorkflowVersion(workflowVersion);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String workflowContext = (String)attributes.get("workflowContext");

		if (workflowContext != null) {
			setWorkflowContext(workflowContext);
		}
	}

	@Override
	public EncyWorkflowInstance cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the class name of this ency workflow instance.
	 *
	 * @return the class name of this ency workflow instance
	 */
	@Override
	public String getClassName() {
		return model.getClassName();
	}

	/**
	 * Returns the class pk of this ency workflow instance.
	 *
	 * @return the class pk of this ency workflow instance
	 */
	@Override
	public long getClassPK() {
		return model.getClassPK();
	}

	/**
	 * Returns the company ID of this ency workflow instance.
	 *
	 * @return the company ID of this ency workflow instance
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this ency workflow instance.
	 *
	 * @return the create date of this ency workflow instance
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this ency workflow instance.
	 *
	 * @return the group ID of this ency workflow instance
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this ency workflow instance.
	 *
	 * @return the modified date of this ency workflow instance
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this ency workflow instance.
	 *
	 * @return the primary key of this ency workflow instance
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this ency workflow instance.
	 *
	 * @return the user ID of this ency workflow instance
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this ency workflow instance.
	 *
	 * @return the user name of this ency workflow instance
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this ency workflow instance.
	 *
	 * @return the user uuid of this ency workflow instance
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this ency workflow instance.
	 *
	 * @return the uuid of this ency workflow instance
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflow getWorkflow() {
		return model.getWorkflow();
	}

	/**
	 * Returns the workflow context of this ency workflow instance.
	 *
	 * @return the workflow context of this ency workflow instance
	 */
	@Override
	public String getWorkflowContext() {
		return model.getWorkflowContext();
	}

	/**
	 * Returns the workflow ID of this ency workflow instance.
	 *
	 * @return the workflow ID of this ency workflow instance
	 */
	@Override
	public long getWorkflowId() {
		return model.getWorkflowId();
	}

	/**
	 * Returns the workflow instance ID of this ency workflow instance.
	 *
	 * @return the workflow instance ID of this ency workflow instance
	 */
	@Override
	public long getWorkflowInstanceId() {
		return model.getWorkflowInstanceId();
	}

	/**
	 * Returns the workflow version of this ency workflow instance.
	 *
	 * @return the workflow version of this ency workflow instance
	 */
	@Override
	public long getWorkflowVersion() {
		return model.getWorkflowVersion();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the class name of this ency workflow instance.
	 *
	 * @param className the class name of this ency workflow instance
	 */
	@Override
	public void setClassName(String className) {
		model.setClassName(className);
	}

	/**
	 * Sets the class pk of this ency workflow instance.
	 *
	 * @param classPK the class pk of this ency workflow instance
	 */
	@Override
	public void setClassPK(long classPK) {
		model.setClassPK(classPK);
	}

	/**
	 * Sets the company ID of this ency workflow instance.
	 *
	 * @param companyId the company ID of this ency workflow instance
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ency workflow instance.
	 *
	 * @param createDate the create date of this ency workflow instance
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this ency workflow instance.
	 *
	 * @param groupId the group ID of this ency workflow instance
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this ency workflow instance.
	 *
	 * @param modifiedDate the modified date of this ency workflow instance
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this ency workflow instance.
	 *
	 * @param primaryKey the primary key of this ency workflow instance
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this ency workflow instance.
	 *
	 * @param userId the user ID of this ency workflow instance
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this ency workflow instance.
	 *
	 * @param userName the user name of this ency workflow instance
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this ency workflow instance.
	 *
	 * @param userUuid the user uuid of this ency workflow instance
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this ency workflow instance.
	 *
	 * @param uuid the uuid of this ency workflow instance
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the workflow context of this ency workflow instance.
	 *
	 * @param workflowContext the workflow context of this ency workflow instance
	 */
	@Override
	public void setWorkflowContext(String workflowContext) {
		model.setWorkflowContext(workflowContext);
	}

	/**
	 * Sets the workflow ID of this ency workflow instance.
	 *
	 * @param workflowId the workflow ID of this ency workflow instance
	 */
	@Override
	public void setWorkflowId(long workflowId) {
		model.setWorkflowId(workflowId);
	}

	/**
	 * Sets the workflow instance ID of this ency workflow instance.
	 *
	 * @param workflowInstanceId the workflow instance ID of this ency workflow instance
	 */
	@Override
	public void setWorkflowInstanceId(long workflowInstanceId) {
		model.setWorkflowInstanceId(workflowInstanceId);
	}

	/**
	 * Sets the workflow version of this ency workflow instance.
	 *
	 * @param workflowVersion the workflow version of this ency workflow instance
	 */
	@Override
	public void setWorkflowVersion(long workflowVersion) {
		model.setWorkflowVersion(workflowVersion);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected EncyWorkflowInstanceWrapper wrap(
		EncyWorkflowInstance encyWorkflowInstance) {

		return new EncyWorkflowInstanceWrapper(encyWorkflowInstance);
	}

}