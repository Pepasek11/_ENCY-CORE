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
 * This class is a wrapper for {@link EncyWorkflowLink}.
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowLink
 * @generated
 */
public class EncyWorkflowLinkWrapper
	extends BaseModelWrapper<EncyWorkflowLink>
	implements EncyWorkflowLink, ModelWrapper<EncyWorkflowLink> {

	public EncyWorkflowLinkWrapper(EncyWorkflowLink encyWorkflowLink) {
		super(encyWorkflowLink);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("workflowLinkId", getWorkflowLinkId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("className", getClassName());
		attributes.put("folderClassName", getFolderClassName());
		attributes.put("folderPK", getFolderPK());
		attributes.put("workflowId", getWorkflowId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long workflowLinkId = (Long)attributes.get("workflowLinkId");

		if (workflowLinkId != null) {
			setWorkflowLinkId(workflowLinkId);
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

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		String folderClassName = (String)attributes.get("folderClassName");

		if (folderClassName != null) {
			setFolderClassName(folderClassName);
		}

		Long folderPK = (Long)attributes.get("folderPK");

		if (folderPK != null) {
			setFolderPK(folderPK);
		}

		Long workflowId = (Long)attributes.get("workflowId");

		if (workflowId != null) {
			setWorkflowId(workflowId);
		}
	}

	@Override
	public EncyWorkflowLink cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the class name of this ency workflow link.
	 *
	 * @return the class name of this ency workflow link
	 */
	@Override
	public String getClassName() {
		return model.getClassName();
	}

	/**
	 * Returns the company ID of this ency workflow link.
	 *
	 * @return the company ID of this ency workflow link
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this ency workflow link.
	 *
	 * @return the create date of this ency workflow link
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the folder class name of this ency workflow link.
	 *
	 * @return the folder class name of this ency workflow link
	 */
	@Override
	public String getFolderClassName() {
		return model.getFolderClassName();
	}

	/**
	 * Returns the folder pk of this ency workflow link.
	 *
	 * @return the folder pk of this ency workflow link
	 */
	@Override
	public long getFolderPK() {
		return model.getFolderPK();
	}

	/**
	 * Returns the group ID of this ency workflow link.
	 *
	 * @return the group ID of this ency workflow link
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this ency workflow link.
	 *
	 * @return the modified date of this ency workflow link
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this ency workflow link.
	 *
	 * @return the primary key of this ency workflow link
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this ency workflow link.
	 *
	 * @return the user ID of this ency workflow link
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this ency workflow link.
	 *
	 * @return the user name of this ency workflow link
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this ency workflow link.
	 *
	 * @return the user uuid of this ency workflow link
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this ency workflow link.
	 *
	 * @return the uuid of this ency workflow link
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the workflow ID of this ency workflow link.
	 *
	 * @return the workflow ID of this ency workflow link
	 */
	@Override
	public long getWorkflowId() {
		return model.getWorkflowId();
	}

	/**
	 * Returns the workflow link ID of this ency workflow link.
	 *
	 * @return the workflow link ID of this ency workflow link
	 */
	@Override
	public long getWorkflowLinkId() {
		return model.getWorkflowLinkId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the class name of this ency workflow link.
	 *
	 * @param className the class name of this ency workflow link
	 */
	@Override
	public void setClassName(String className) {
		model.setClassName(className);
	}

	/**
	 * Sets the company ID of this ency workflow link.
	 *
	 * @param companyId the company ID of this ency workflow link
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ency workflow link.
	 *
	 * @param createDate the create date of this ency workflow link
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the folder class name of this ency workflow link.
	 *
	 * @param folderClassName the folder class name of this ency workflow link
	 */
	@Override
	public void setFolderClassName(String folderClassName) {
		model.setFolderClassName(folderClassName);
	}

	/**
	 * Sets the folder pk of this ency workflow link.
	 *
	 * @param folderPK the folder pk of this ency workflow link
	 */
	@Override
	public void setFolderPK(long folderPK) {
		model.setFolderPK(folderPK);
	}

	/**
	 * Sets the group ID of this ency workflow link.
	 *
	 * @param groupId the group ID of this ency workflow link
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this ency workflow link.
	 *
	 * @param modifiedDate the modified date of this ency workflow link
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this ency workflow link.
	 *
	 * @param primaryKey the primary key of this ency workflow link
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this ency workflow link.
	 *
	 * @param userId the user ID of this ency workflow link
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this ency workflow link.
	 *
	 * @param userName the user name of this ency workflow link
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this ency workflow link.
	 *
	 * @param userUuid the user uuid of this ency workflow link
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this ency workflow link.
	 *
	 * @param uuid the uuid of this ency workflow link
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the workflow ID of this ency workflow link.
	 *
	 * @param workflowId the workflow ID of this ency workflow link
	 */
	@Override
	public void setWorkflowId(long workflowId) {
		model.setWorkflowId(workflowId);
	}

	/**
	 * Sets the workflow link ID of this ency workflow link.
	 *
	 * @param workflowLinkId the workflow link ID of this ency workflow link
	 */
	@Override
	public void setWorkflowLinkId(long workflowLinkId) {
		model.setWorkflowLinkId(workflowLinkId);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected EncyWorkflowLinkWrapper wrap(EncyWorkflowLink encyWorkflowLink) {
		return new EncyWorkflowLinkWrapper(encyWorkflowLink);
	}

}