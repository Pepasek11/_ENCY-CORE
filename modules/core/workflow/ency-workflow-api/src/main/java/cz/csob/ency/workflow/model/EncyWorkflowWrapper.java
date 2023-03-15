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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EncyWorkflow}.
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflow
 * @generated
 */
public class EncyWorkflowWrapper
	extends BaseModelWrapper<EncyWorkflow>
	implements EncyWorkflow, ModelWrapper<EncyWorkflow> {

	public EncyWorkflowWrapper(EncyWorkflow encyWorkflow) {
		super(encyWorkflow);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("workflowId", getWorkflowId());
		attributes.put("className", getClassName());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("initialStateName", getInitialStateName());
		attributes.put("version", getVersion());
		attributes.put("active", getActive());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long workflowId = (Long)attributes.get("workflowId");

		if (workflowId != null) {
			setWorkflowId(workflowId);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String initialStateName = (String)attributes.get("initialStateName");

		if (initialStateName != null) {
			setInitialStateName(initialStateName);
		}

		Long version = (Long)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public EncyWorkflow cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the active of this ency workflow.
	 *
	 * @return the active of this ency workflow
	 */
	@Override
	public Boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the class name of this ency workflow.
	 *
	 * @return the class name of this ency workflow
	 */
	@Override
	public String getClassName() {
		return model.getClassName();
	}

	/**
	 * Returns the create date of this ency workflow.
	 *
	 * @return the create date of this ency workflow
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this ency workflow.
	 *
	 * @return the description of this ency workflow
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowState getInitialState()
		throws cz.csob.ency.workflow.exception.NoSuchStateException {

		return model.getInitialState();
	}

	/**
	 * Returns the initial state name of this ency workflow.
	 *
	 * @return the initial state name of this ency workflow
	 */
	@Override
	public String getInitialStateName() {
		return model.getInitialStateName();
	}

	/**
	 * Returns the modified date of this ency workflow.
	 *
	 * @return the modified date of this ency workflow
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this ency workflow.
	 *
	 * @return the primary key of this ency workflow
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the title of this ency workflow.
	 *
	 * @return the title of this ency workflow
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the uuid of this ency workflow.
	 *
	 * @return the uuid of this ency workflow
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the version of this ency workflow.
	 *
	 * @return the version of this ency workflow
	 */
	@Override
	public long getVersion() {
		return model.getVersion();
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflow getWorkflow() {
		return model.getWorkflow();
	}

	/**
	 * Returns the workflow ID of this ency workflow.
	 *
	 * @return the workflow ID of this ency workflow
	 */
	@Override
	public long getWorkflowId() {
		return model.getWorkflowId();
	}

	@Override
	public Boolean isActive() {
		return model.isActive();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the active of this ency workflow.
	 *
	 * @param active the active of this ency workflow
	 */
	@Override
	public void setActive(Boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the class name of this ency workflow.
	 *
	 * @param className the class name of this ency workflow
	 */
	@Override
	public void setClassName(String className) {
		model.setClassName(className);
	}

	/**
	 * Sets the create date of this ency workflow.
	 *
	 * @param createDate the create date of this ency workflow
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this ency workflow.
	 *
	 * @param description the description of this ency workflow
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the initial state name of this ency workflow.
	 *
	 * @param initialStateName the initial state name of this ency workflow
	 */
	@Override
	public void setInitialStateName(String initialStateName) {
		model.setInitialStateName(initialStateName);
	}

	/**
	 * Sets the modified date of this ency workflow.
	 *
	 * @param modifiedDate the modified date of this ency workflow
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this ency workflow.
	 *
	 * @param primaryKey the primary key of this ency workflow
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the title of this ency workflow.
	 *
	 * @param title the title of this ency workflow
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the uuid of this ency workflow.
	 *
	 * @param uuid the uuid of this ency workflow
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the version of this ency workflow.
	 *
	 * @param version the version of this ency workflow
	 */
	@Override
	public void setVersion(long version) {
		model.setVersion(version);
	}

	/**
	 * Sets the workflow ID of this ency workflow.
	 *
	 * @param workflowId the workflow ID of this ency workflow
	 */
	@Override
	public void setWorkflowId(long workflowId) {
		model.setWorkflowId(workflowId);
	}

	@Override
	protected EncyWorkflowWrapper wrap(EncyWorkflow encyWorkflow) {
		return new EncyWorkflowWrapper(encyWorkflow);
	}

}