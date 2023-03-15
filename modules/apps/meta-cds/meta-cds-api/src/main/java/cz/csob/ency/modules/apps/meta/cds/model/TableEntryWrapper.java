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

package cz.csob.ency.modules.apps.meta.cds.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TableEntry}.
 * </p>
 *
 * @author "Miroslav Čermák"
 * @see TableEntry
 * @generated
 */
public class TableEntryWrapper
	extends BaseModelWrapper<TableEntry>
	implements ModelWrapper<TableEntry>, TableEntry {

	public TableEntryWrapper(TableEntry tableEntry) {
		super(tableEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("tableEntryId", getTableEntryId());
		attributes.put("tableName", getTableName());
		attributes.put("tableFullName", getTableFullName());
		attributes.put("tableType", getTableType());
		attributes.put("tableDatabase", getTableDatabase());
		attributes.put("systemEntryId", getSystemEntryId());
		attributes.put("systemName", getSystemName());
		attributes.put("description", getDescription());
		attributes.put("dsaUrl", getDsaUrl());
		attributes.put("contactPersonName", getContactPersonName());
		attributes.put("contactPersonId", getContactPersonId());
		attributes.put("specificationOwnerName", getSpecificationOwnerName());
		attributes.put("specificationOwnerId", getSpecificationOwnerId());
		attributes.put("unstructuredClause", getUnstructuredClause());
		attributes.put("isActive", isIsActive());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("urlTitle", getUrlTitle());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long tableEntryId = (Long)attributes.get("tableEntryId");

		if (tableEntryId != null) {
			setTableEntryId(tableEntryId);
		}

		String tableName = (String)attributes.get("tableName");

		if (tableName != null) {
			setTableName(tableName);
		}

		String tableFullName = (String)attributes.get("tableFullName");

		if (tableFullName != null) {
			setTableFullName(tableFullName);
		}

		String tableType = (String)attributes.get("tableType");

		if (tableType != null) {
			setTableType(tableType);
		}

		String tableDatabase = (String)attributes.get("tableDatabase");

		if (tableDatabase != null) {
			setTableDatabase(tableDatabase);
		}

		Long systemEntryId = (Long)attributes.get("systemEntryId");

		if (systemEntryId != null) {
			setSystemEntryId(systemEntryId);
		}

		String systemName = (String)attributes.get("systemName");

		if (systemName != null) {
			setSystemName(systemName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String dsaUrl = (String)attributes.get("dsaUrl");

		if (dsaUrl != null) {
			setDsaUrl(dsaUrl);
		}

		String contactPersonName = (String)attributes.get("contactPersonName");

		if (contactPersonName != null) {
			setContactPersonName(contactPersonName);
		}

		String contactPersonId = (String)attributes.get("contactPersonId");

		if (contactPersonId != null) {
			setContactPersonId(contactPersonId);
		}

		String specificationOwnerName = (String)attributes.get(
			"specificationOwnerName");

		if (specificationOwnerName != null) {
			setSpecificationOwnerName(specificationOwnerName);
		}

		String specificationOwnerId = (String)attributes.get(
			"specificationOwnerId");

		if (specificationOwnerId != null) {
			setSpecificationOwnerId(specificationOwnerId);
		}

		String unstructuredClause = (String)attributes.get(
			"unstructuredClause");

		if (unstructuredClause != null) {
			setUnstructuredClause(unstructuredClause);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
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

		String urlTitle = (String)attributes.get("urlTitle");

		if (urlTitle != null) {
			setUrlTitle(urlTitle);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@Override
	public TableEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public boolean equals(Object object) {
		return model.equals(object);
	}

	/**
	 * Returns the company ID of this table entry.
	 *
	 * @return the company ID of this table entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the contact person ID of this table entry.
	 *
	 * @return the contact person ID of this table entry
	 */
	@Override
	public String getContactPersonId() {
		return model.getContactPersonId();
	}

	/**
	 * Returns the contact person name of this table entry.
	 *
	 * @return the contact person name of this table entry
	 */
	@Override
	public String getContactPersonName() {
		return model.getContactPersonName();
	}

	/**
	 * Returns the create date of this table entry.
	 *
	 * @return the create date of this table entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this table entry.
	 *
	 * @return the description of this table entry
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the dsa url of this table entry.
	 *
	 * @return the dsa url of this table entry
	 */
	@Override
	public String getDsaUrl() {
		return model.getDsaUrl();
	}

	/**
	 * Returns the group ID of this table entry.
	 *
	 * @return the group ID of this table entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is active of this table entry.
	 *
	 * @return the is active of this table entry
	 */
	@Override
	public boolean getIsActive() {
		return model.getIsActive();
	}

	/**
	 * Returns the modified date of this table entry.
	 *
	 * @return the modified date of this table entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this table entry.
	 *
	 * @return the mvcc version of this table entry
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this table entry.
	 *
	 * @return the primary key of this table entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the specification owner ID of this table entry.
	 *
	 * @return the specification owner ID of this table entry
	 */
	@Override
	public String getSpecificationOwnerId() {
		return model.getSpecificationOwnerId();
	}

	/**
	 * Returns the specification owner name of this table entry.
	 *
	 * @return the specification owner name of this table entry
	 */
	@Override
	public String getSpecificationOwnerName() {
		return model.getSpecificationOwnerName();
	}

	/**
	 * Returns the status of this table entry.
	 *
	 * @return the status of this table entry
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this table entry.
	 *
	 * @return the status by user ID of this table entry
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this table entry.
	 *
	 * @return the status by user name of this table entry
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this table entry.
	 *
	 * @return the status by user uuid of this table entry
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this table entry.
	 *
	 * @return the status date of this table entry
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the system entry ID of this table entry.
	 *
	 * @return the system entry ID of this table entry
	 */
	@Override
	public long getSystemEntryId() {
		return model.getSystemEntryId();
	}

	/**
	 * Returns the system name of this table entry.
	 *
	 * @return the system name of this table entry
	 */
	@Override
	public String getSystemName() {
		return model.getSystemName();
	}

	/**
	 * Returns the table database of this table entry.
	 *
	 * @return the table database of this table entry
	 */
	@Override
	public String getTableDatabase() {
		return model.getTableDatabase();
	}

	/**
	 * Returns the table entry ID of this table entry.
	 *
	 * @return the table entry ID of this table entry
	 */
	@Override
	public long getTableEntryId() {
		return model.getTableEntryId();
	}

	/**
	 * Returns the table full name of this table entry.
	 *
	 * @return the table full name of this table entry
	 */
	@Override
	public String getTableFullName() {
		return model.getTableFullName();
	}

	/**
	 * Returns the table name of this table entry.
	 *
	 * @return the table name of this table entry
	 */
	@Override
	public String getTableName() {
		return model.getTableName();
	}

	/**
	 * Returns the table type of this table entry.
	 *
	 * @return the table type of this table entry
	 */
	@Override
	public String getTableType() {
		return model.getTableType();
	}

	/**
	 * Returns the trash entry created when this table entry was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this table entry.
	 *
	 * @return the trash entry created when this table entry was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this table entry.
	 *
	 * @return the class primary key of the trash entry for this table entry
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this table entry.
	 *
	 * @return the trash handler for this table entry
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the unstructured clause of this table entry.
	 *
	 * @return the unstructured clause of this table entry
	 */
	@Override
	public String getUnstructuredClause() {
		return model.getUnstructuredClause();
	}

	/**
	 * Returns the url title of this table entry.
	 *
	 * @return the url title of this table entry
	 */
	@Override
	public String getUrlTitle() {
		return model.getUrlTitle();
	}

	/**
	 * Returns the user ID of this table entry.
	 *
	 * @return the user ID of this table entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this table entry.
	 *
	 * @return the user name of this table entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this table entry.
	 *
	 * @return the user uuid of this table entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this table entry.
	 *
	 * @return the uuid of this table entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this table entry is approved.
	 *
	 * @return <code>true</code> if this table entry is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this table entry is denied.
	 *
	 * @return <code>true</code> if this table entry is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this table entry is a draft.
	 *
	 * @return <code>true</code> if this table entry is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this table entry is expired.
	 *
	 * @return <code>true</code> if this table entry is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this table entry is inactive.
	 *
	 * @return <code>true</code> if this table entry is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this table entry is incomplete.
	 *
	 * @return <code>true</code> if this table entry is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this table entry is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this table entry is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this table entry is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this table entry is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrashContainer() {
		return model.isInTrashContainer();
	}

	@Override
	public boolean isInTrashExplicitly() {
		return model.isInTrashExplicitly();
	}

	@Override
	public boolean isInTrashImplicitly() {
		return model.isInTrashImplicitly();
	}

	/**
	 * Returns <code>true</code> if this table entry is is active.
	 *
	 * @return <code>true</code> if this table entry is is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsActive() {
		return model.isIsActive();
	}

	/**
	 * Returns <code>true</code> if this table entry is pending.
	 *
	 * @return <code>true</code> if this table entry is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this table entry is scheduled.
	 *
	 * @return <code>true</code> if this table entry is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this table entry.
	 *
	 * @param companyId the company ID of this table entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the contact person ID of this table entry.
	 *
	 * @param contactPersonId the contact person ID of this table entry
	 */
	@Override
	public void setContactPersonId(String contactPersonId) {
		model.setContactPersonId(contactPersonId);
	}

	/**
	 * Sets the contact person name of this table entry.
	 *
	 * @param contactPersonName the contact person name of this table entry
	 */
	@Override
	public void setContactPersonName(String contactPersonName) {
		model.setContactPersonName(contactPersonName);
	}

	/**
	 * Sets the create date of this table entry.
	 *
	 * @param createDate the create date of this table entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this table entry.
	 *
	 * @param description the description of this table entry
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the dsa url of this table entry.
	 *
	 * @param dsaUrl the dsa url of this table entry
	 */
	@Override
	public void setDsaUrl(String dsaUrl) {
		model.setDsaUrl(dsaUrl);
	}

	/**
	 * Sets the group ID of this table entry.
	 *
	 * @param groupId the group ID of this table entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this table entry is is active.
	 *
	 * @param isActive the is active of this table entry
	 */
	@Override
	public void setIsActive(boolean isActive) {
		model.setIsActive(isActive);
	}

	/**
	 * Sets the modified date of this table entry.
	 *
	 * @param modifiedDate the modified date of this table entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this table entry.
	 *
	 * @param mvccVersion the mvcc version of this table entry
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this table entry.
	 *
	 * @param primaryKey the primary key of this table entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the specification owner ID of this table entry.
	 *
	 * @param specificationOwnerId the specification owner ID of this table entry
	 */
	@Override
	public void setSpecificationOwnerId(String specificationOwnerId) {
		model.setSpecificationOwnerId(specificationOwnerId);
	}

	/**
	 * Sets the specification owner name of this table entry.
	 *
	 * @param specificationOwnerName the specification owner name of this table entry
	 */
	@Override
	public void setSpecificationOwnerName(String specificationOwnerName) {
		model.setSpecificationOwnerName(specificationOwnerName);
	}

	/**
	 * Sets the status of this table entry.
	 *
	 * @param status the status of this table entry
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this table entry.
	 *
	 * @param statusByUserId the status by user ID of this table entry
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this table entry.
	 *
	 * @param statusByUserName the status by user name of this table entry
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this table entry.
	 *
	 * @param statusByUserUuid the status by user uuid of this table entry
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this table entry.
	 *
	 * @param statusDate the status date of this table entry
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the system entry ID of this table entry.
	 *
	 * @param systemEntryId the system entry ID of this table entry
	 */
	@Override
	public void setSystemEntryId(long systemEntryId) {
		model.setSystemEntryId(systemEntryId);
	}

	/**
	 * Sets the system name of this table entry.
	 *
	 * @param systemName the system name of this table entry
	 */
	@Override
	public void setSystemName(String systemName) {
		model.setSystemName(systemName);
	}

	/**
	 * Sets the table database of this table entry.
	 *
	 * @param tableDatabase the table database of this table entry
	 */
	@Override
	public void setTableDatabase(String tableDatabase) {
		model.setTableDatabase(tableDatabase);
	}

	/**
	 * Sets the table entry ID of this table entry.
	 *
	 * @param tableEntryId the table entry ID of this table entry
	 */
	@Override
	public void setTableEntryId(long tableEntryId) {
		model.setTableEntryId(tableEntryId);
	}

	/**
	 * Sets the table full name of this table entry.
	 *
	 * @param tableFullName the table full name of this table entry
	 */
	@Override
	public void setTableFullName(String tableFullName) {
		model.setTableFullName(tableFullName);
	}

	/**
	 * Sets the table name of this table entry.
	 *
	 * @param tableName the table name of this table entry
	 */
	@Override
	public void setTableName(String tableName) {
		model.setTableName(tableName);
	}

	/**
	 * Sets the table type of this table entry.
	 *
	 * @param tableType the table type of this table entry
	 */
	@Override
	public void setTableType(String tableType) {
		model.setTableType(tableType);
	}

	/**
	 * Sets the unstructured clause of this table entry.
	 *
	 * @param unstructuredClause the unstructured clause of this table entry
	 */
	@Override
	public void setUnstructuredClause(String unstructuredClause) {
		model.setUnstructuredClause(unstructuredClause);
	}

	/**
	 * Sets the url title of this table entry.
	 *
	 * @param urlTitle the url title of this table entry
	 */
	@Override
	public void setUrlTitle(String urlTitle) {
		model.setUrlTitle(urlTitle);
	}

	/**
	 * Sets the user ID of this table entry.
	 *
	 * @param userId the user ID of this table entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this table entry.
	 *
	 * @param userName the user name of this table entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this table entry.
	 *
	 * @param userUuid the user uuid of this table entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this table entry.
	 *
	 * @param uuid the uuid of this table entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected TableEntryWrapper wrap(TableEntry tableEntry) {
		return new TableEntryWrapper(tableEntry);
	}

}