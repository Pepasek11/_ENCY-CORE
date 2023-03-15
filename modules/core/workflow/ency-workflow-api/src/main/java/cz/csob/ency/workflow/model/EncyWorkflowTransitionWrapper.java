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
 * This class is a wrapper for {@link EncyWorkflowTransition}.
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowTransition
 * @generated
 */
public class EncyWorkflowTransitionWrapper
	extends BaseModelWrapper<EncyWorkflowTransition>
	implements EncyWorkflowTransition, ModelWrapper<EncyWorkflowTransition> {

	public EncyWorkflowTransitionWrapper(
		EncyWorkflowTransition encyWorkflowTransition) {

		super(encyWorkflowTransition);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("transitionId", getTransitionId());
		attributes.put("stateId", getStateId());
		attributes.put("workflowId", getWorkflowId());
		attributes.put("version", getVersion());
		attributes.put("name", getName());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("targetStateName", getTargetStateName());
		attributes.put("targetStateId", getTargetStateId());
		attributes.put("cssIcon", getCssIcon());
		attributes.put("cssIconColor", getCssIconColor());
		attributes.put("active", getActive());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("order", getOrder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long transitionId = (Long)attributes.get("transitionId");

		if (transitionId != null) {
			setTransitionId(transitionId);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		Long workflowId = (Long)attributes.get("workflowId");

		if (workflowId != null) {
			setWorkflowId(workflowId);
		}

		Long version = (Long)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String targetStateName = (String)attributes.get("targetStateName");

		if (targetStateName != null) {
			setTargetStateName(targetStateName);
		}

		Long targetStateId = (Long)attributes.get("targetStateId");

		if (targetStateId != null) {
			setTargetStateId(targetStateId);
		}

		String cssIcon = (String)attributes.get("cssIcon");

		if (cssIcon != null) {
			setCssIcon(cssIcon);
		}

		String cssIconColor = (String)attributes.get("cssIconColor");

		if (cssIconColor != null) {
			setCssIconColor(cssIconColor);
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

		Long order = (Long)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}
	}

	@Override
	public EncyWorkflowTransition cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the active of this ency workflow transition.
	 *
	 * @return the active of this ency workflow transition
	 */
	@Override
	public Boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the create date of this ency workflow transition.
	 *
	 * @return the create date of this ency workflow transition
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the css icon of this ency workflow transition.
	 *
	 * @return the css icon of this ency workflow transition
	 */
	@Override
	public String getCssIcon() {
		return model.getCssIcon();
	}

	/**
	 * Returns the css icon color of this ency workflow transition.
	 *
	 * @return the css icon color of this ency workflow transition
	 */
	@Override
	public String getCssIconColor() {
		return model.getCssIconColor();
	}

	/**
	 * Returns the description of this ency workflow transition.
	 *
	 * @return the description of this ency workflow transition
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the modified date of this ency workflow transition.
	 *
	 * @return the modified date of this ency workflow transition
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this ency workflow transition.
	 *
	 * @return the name of this ency workflow transition
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the order of this ency workflow transition.
	 *
	 * @return the order of this ency workflow transition
	 */
	@Override
	public long getOrder() {
		return model.getOrder();
	}

	/**
	 * Returns the primary key of this ency workflow transition.
	 *
	 * @return the primary key of this ency workflow transition
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the state ID of this ency workflow transition.
	 *
	 * @return the state ID of this ency workflow transition
	 */
	@Override
	public long getStateId() {
		return model.getStateId();
	}

	/**
	 * Returns the target state ID of this ency workflow transition.
	 *
	 * @return the target state ID of this ency workflow transition
	 */
	@Override
	public long getTargetStateId() {
		return model.getTargetStateId();
	}

	/**
	 * Returns the target state name of this ency workflow transition.
	 *
	 * @return the target state name of this ency workflow transition
	 */
	@Override
	public String getTargetStateName() {
		return model.getTargetStateName();
	}

	/**
	 * Returns the title of this ency workflow transition.
	 *
	 * @return the title of this ency workflow transition
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the transition ID of this ency workflow transition.
	 *
	 * @return the transition ID of this ency workflow transition
	 */
	@Override
	public long getTransitionId() {
		return model.getTransitionId();
	}

	/**
	 * Returns the uuid of this ency workflow transition.
	 *
	 * @return the uuid of this ency workflow transition
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the version of this ency workflow transition.
	 *
	 * @return the version of this ency workflow transition
	 */
	@Override
	public long getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns the workflow ID of this ency workflow transition.
	 *
	 * @return the workflow ID of this ency workflow transition
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
	 * Sets the active of this ency workflow transition.
	 *
	 * @param active the active of this ency workflow transition
	 */
	@Override
	public void setActive(Boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the create date of this ency workflow transition.
	 *
	 * @param createDate the create date of this ency workflow transition
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the css icon of this ency workflow transition.
	 *
	 * @param cssIcon the css icon of this ency workflow transition
	 */
	@Override
	public void setCssIcon(String cssIcon) {
		model.setCssIcon(cssIcon);
	}

	/**
	 * Sets the css icon color of this ency workflow transition.
	 *
	 * @param cssIconColor the css icon color of this ency workflow transition
	 */
	@Override
	public void setCssIconColor(String cssIconColor) {
		model.setCssIconColor(cssIconColor);
	}

	/**
	 * Sets the description of this ency workflow transition.
	 *
	 * @param description the description of this ency workflow transition
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the modified date of this ency workflow transition.
	 *
	 * @param modifiedDate the modified date of this ency workflow transition
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this ency workflow transition.
	 *
	 * @param name the name of this ency workflow transition
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the order of this ency workflow transition.
	 *
	 * @param order the order of this ency workflow transition
	 */
	@Override
	public void setOrder(long order) {
		model.setOrder(order);
	}

	/**
	 * Sets the primary key of this ency workflow transition.
	 *
	 * @param primaryKey the primary key of this ency workflow transition
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the state ID of this ency workflow transition.
	 *
	 * @param stateId the state ID of this ency workflow transition
	 */
	@Override
	public void setStateId(long stateId) {
		model.setStateId(stateId);
	}

	/**
	 * Sets the target state ID of this ency workflow transition.
	 *
	 * @param targetStateId the target state ID of this ency workflow transition
	 */
	@Override
	public void setTargetStateId(long targetStateId) {
		model.setTargetStateId(targetStateId);
	}

	/**
	 * Sets the target state name of this ency workflow transition.
	 *
	 * @param targetStateName the target state name of this ency workflow transition
	 */
	@Override
	public void setTargetStateName(String targetStateName) {
		model.setTargetStateName(targetStateName);
	}

	/**
	 * Sets the title of this ency workflow transition.
	 *
	 * @param title the title of this ency workflow transition
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the transition ID of this ency workflow transition.
	 *
	 * @param transitionId the transition ID of this ency workflow transition
	 */
	@Override
	public void setTransitionId(long transitionId) {
		model.setTransitionId(transitionId);
	}

	/**
	 * Sets the uuid of this ency workflow transition.
	 *
	 * @param uuid the uuid of this ency workflow transition
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the version of this ency workflow transition.
	 *
	 * @param version the version of this ency workflow transition
	 */
	@Override
	public void setVersion(long version) {
		model.setVersion(version);
	}

	/**
	 * Sets the workflow ID of this ency workflow transition.
	 *
	 * @param workflowId the workflow ID of this ency workflow transition
	 */
	@Override
	public void setWorkflowId(long workflowId) {
		model.setWorkflowId(workflowId);
	}

	@Override
	protected EncyWorkflowTransitionWrapper wrap(
		EncyWorkflowTransition encyWorkflowTransition) {

		return new EncyWorkflowTransitionWrapper(encyWorkflowTransition);
	}

}