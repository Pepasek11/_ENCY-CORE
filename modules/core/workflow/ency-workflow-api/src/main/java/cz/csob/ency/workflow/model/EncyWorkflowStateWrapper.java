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
 * This class is a wrapper for {@link EncyWorkflowState}.
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowState
 * @generated
 */
public class EncyWorkflowStateWrapper
	extends BaseModelWrapper<EncyWorkflowState>
	implements EncyWorkflowState, ModelWrapper<EncyWorkflowState> {

	public EncyWorkflowStateWrapper(EncyWorkflowState encyWorkflowState) {
		super(encyWorkflowState);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("stateId", getStateId());
		attributes.put("workflowId", getWorkflowId());
		attributes.put("name", getName());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("version", getVersion());
		attributes.put("isInitial", getIsInitial());
		attributes.put("isFinal", getIsFinal());
		attributes.put("isEditable", getIsEditable());
		attributes.put("isSearchable", getIsSearchable());
		attributes.put("isPermanent", getIsPermanent());
		attributes.put("cssIcon", getCssIcon());
		attributes.put("cssIconColor", getCssIconColor());
		attributes.put("cssLabelColor", getCssLabelColor());
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

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		Long workflowId = (Long)attributes.get("workflowId");

		if (workflowId != null) {
			setWorkflowId(workflowId);
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

		Long version = (Long)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Boolean isInitial = (Boolean)attributes.get("isInitial");

		if (isInitial != null) {
			setIsInitial(isInitial);
		}

		Boolean isFinal = (Boolean)attributes.get("isFinal");

		if (isFinal != null) {
			setIsFinal(isFinal);
		}

		Boolean isEditable = (Boolean)attributes.get("isEditable");

		if (isEditable != null) {
			setIsEditable(isEditable);
		}

		Boolean isSearchable = (Boolean)attributes.get("isSearchable");

		if (isSearchable != null) {
			setIsSearchable(isSearchable);
		}

		Boolean isPermanent = (Boolean)attributes.get("isPermanent");

		if (isPermanent != null) {
			setIsPermanent(isPermanent);
		}

		String cssIcon = (String)attributes.get("cssIcon");

		if (cssIcon != null) {
			setCssIcon(cssIcon);
		}

		String cssIconColor = (String)attributes.get("cssIconColor");

		if (cssIconColor != null) {
			setCssIconColor(cssIconColor);
		}

		String cssLabelColor = (String)attributes.get("cssLabelColor");

		if (cssLabelColor != null) {
			setCssLabelColor(cssLabelColor);
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
	public EncyWorkflowState cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the active of this ency workflow state.
	 *
	 * @return the active of this ency workflow state
	 */
	@Override
	public Boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the create date of this ency workflow state.
	 *
	 * @return the create date of this ency workflow state
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the css icon of this ency workflow state.
	 *
	 * @return the css icon of this ency workflow state
	 */
	@Override
	public String getCssIcon() {
		return model.getCssIcon();
	}

	/**
	 * Returns the css icon color of this ency workflow state.
	 *
	 * @return the css icon color of this ency workflow state
	 */
	@Override
	public String getCssIconColor() {
		return model.getCssIconColor();
	}

	/**
	 * Returns the css label color of this ency workflow state.
	 *
	 * @return the css label color of this ency workflow state
	 */
	@Override
	public String getCssLabelColor() {
		return model.getCssLabelColor();
	}

	/**
	 * Returns the description of this ency workflow state.
	 *
	 * @return the description of this ency workflow state
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the is editable of this ency workflow state.
	 *
	 * @return the is editable of this ency workflow state
	 */
	@Override
	public Boolean getIsEditable() {
		return model.getIsEditable();
	}

	/**
	 * Returns the is final of this ency workflow state.
	 *
	 * @return the is final of this ency workflow state
	 */
	@Override
	public Boolean getIsFinal() {
		return model.getIsFinal();
	}

	/**
	 * Returns the is initial of this ency workflow state.
	 *
	 * @return the is initial of this ency workflow state
	 */
	@Override
	public Boolean getIsInitial() {
		return model.getIsInitial();
	}

	/**
	 * Returns the is permanent of this ency workflow state.
	 *
	 * @return the is permanent of this ency workflow state
	 */
	@Override
	public Boolean getIsPermanent() {
		return model.getIsPermanent();
	}

	/**
	 * Returns the is searchable of this ency workflow state.
	 *
	 * @return the is searchable of this ency workflow state
	 */
	@Override
	public Boolean getIsSearchable() {
		return model.getIsSearchable();
	}

	/**
	 * Returns the modified date of this ency workflow state.
	 *
	 * @return the modified date of this ency workflow state
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this ency workflow state.
	 *
	 * @return the name of this ency workflow state
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	@Override
	public java.util.List<cz.csob.ency.workflow.model.EncyWorkflowTransition>
		getOutgoingTransitions() {

		return model.getOutgoingTransitions();
	}

	/**
	 * Returns the primary key of this ency workflow state.
	 *
	 * @return the primary key of this ency workflow state
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the state ID of this ency workflow state.
	 *
	 * @return the state ID of this ency workflow state
	 */
	@Override
	public long getStateId() {
		return model.getStateId();
	}

	/**
	 * Returns the title of this ency workflow state.
	 *
	 * @return the title of this ency workflow state
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the uuid of this ency workflow state.
	 *
	 * @return the uuid of this ency workflow state
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the version of this ency workflow state.
	 *
	 * @return the version of this ency workflow state
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
	 * Returns the workflow ID of this ency workflow state.
	 *
	 * @return the workflow ID of this ency workflow state
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
	public Boolean isFinal() {
		return model.isFinal();
	}

	@Override
	public Boolean isInitial() {
		return model.isInitial();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the active of this ency workflow state.
	 *
	 * @param active the active of this ency workflow state
	 */
	@Override
	public void setActive(Boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the create date of this ency workflow state.
	 *
	 * @param createDate the create date of this ency workflow state
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the css icon of this ency workflow state.
	 *
	 * @param cssIcon the css icon of this ency workflow state
	 */
	@Override
	public void setCssIcon(String cssIcon) {
		model.setCssIcon(cssIcon);
	}

	/**
	 * Sets the css icon color of this ency workflow state.
	 *
	 * @param cssIconColor the css icon color of this ency workflow state
	 */
	@Override
	public void setCssIconColor(String cssIconColor) {
		model.setCssIconColor(cssIconColor);
	}

	/**
	 * Sets the css label color of this ency workflow state.
	 *
	 * @param cssLabelColor the css label color of this ency workflow state
	 */
	@Override
	public void setCssLabelColor(String cssLabelColor) {
		model.setCssLabelColor(cssLabelColor);
	}

	/**
	 * Sets the description of this ency workflow state.
	 *
	 * @param description the description of this ency workflow state
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the is editable of this ency workflow state.
	 *
	 * @param isEditable the is editable of this ency workflow state
	 */
	@Override
	public void setIsEditable(Boolean isEditable) {
		model.setIsEditable(isEditable);
	}

	/**
	 * Sets the is final of this ency workflow state.
	 *
	 * @param isFinal the is final of this ency workflow state
	 */
	@Override
	public void setIsFinal(Boolean isFinal) {
		model.setIsFinal(isFinal);
	}

	/**
	 * Sets the is initial of this ency workflow state.
	 *
	 * @param isInitial the is initial of this ency workflow state
	 */
	@Override
	public void setIsInitial(Boolean isInitial) {
		model.setIsInitial(isInitial);
	}

	/**
	 * Sets the is permanent of this ency workflow state.
	 *
	 * @param isPermanent the is permanent of this ency workflow state
	 */
	@Override
	public void setIsPermanent(Boolean isPermanent) {
		model.setIsPermanent(isPermanent);
	}

	/**
	 * Sets the is searchable of this ency workflow state.
	 *
	 * @param isSearchable the is searchable of this ency workflow state
	 */
	@Override
	public void setIsSearchable(Boolean isSearchable) {
		model.setIsSearchable(isSearchable);
	}

	/**
	 * Sets the modified date of this ency workflow state.
	 *
	 * @param modifiedDate the modified date of this ency workflow state
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this ency workflow state.
	 *
	 * @param name the name of this ency workflow state
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this ency workflow state.
	 *
	 * @param primaryKey the primary key of this ency workflow state
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the state ID of this ency workflow state.
	 *
	 * @param stateId the state ID of this ency workflow state
	 */
	@Override
	public void setStateId(long stateId) {
		model.setStateId(stateId);
	}

	/**
	 * Sets the title of this ency workflow state.
	 *
	 * @param title the title of this ency workflow state
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the uuid of this ency workflow state.
	 *
	 * @param uuid the uuid of this ency workflow state
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the version of this ency workflow state.
	 *
	 * @param version the version of this ency workflow state
	 */
	@Override
	public void setVersion(long version) {
		model.setVersion(version);
	}

	/**
	 * Sets the workflow ID of this ency workflow state.
	 *
	 * @param workflowId the workflow ID of this ency workflow state
	 */
	@Override
	public void setWorkflowId(long workflowId) {
		model.setWorkflowId(workflowId);
	}

	@Override
	protected EncyWorkflowStateWrapper wrap(
		EncyWorkflowState encyWorkflowState) {

		return new EncyWorkflowStateWrapper(encyWorkflowState);
	}

}