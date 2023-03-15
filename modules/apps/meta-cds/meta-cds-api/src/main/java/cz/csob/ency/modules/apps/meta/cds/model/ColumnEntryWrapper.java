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
 * This class is a wrapper for {@link ColumnEntry}.
 * </p>
 *
 * @author "Miroslav Čermák"
 * @see ColumnEntry
 * @generated
 */
public class ColumnEntryWrapper
	extends BaseModelWrapper<ColumnEntry>
	implements ColumnEntry, ModelWrapper<ColumnEntry> {

	public ColumnEntryWrapper(ColumnEntry columnEntry) {
		super(columnEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("columnEntryId", getColumnEntryId());
		attributes.put("columnType", getColumnType());
		attributes.put("columnName", getColumnName());
		attributes.put("columnPosition", getColumnPosition());
		attributes.put("columnFullName", getColumnFullName());
		attributes.put("tableEntryId", getTableEntryId());
		attributes.put("tableName", getTableName());
		attributes.put("systemName", getSystemName());
		attributes.put("databaseName", getDatabaseName());
		attributes.put("description", getDescription());
		attributes.put("dataType", getDataType());
		attributes.put("dataSize", getDataSize());
		attributes.put("isPrimaryKey", isIsPrimaryKey());
		attributes.put("isNotNull", isIsNotNull());
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

		Long columnEntryId = (Long)attributes.get("columnEntryId");

		if (columnEntryId != null) {
			setColumnEntryId(columnEntryId);
		}

		String columnType = (String)attributes.get("columnType");

		if (columnType != null) {
			setColumnType(columnType);
		}

		String columnName = (String)attributes.get("columnName");

		if (columnName != null) {
			setColumnName(columnName);
		}

		Long columnPosition = (Long)attributes.get("columnPosition");

		if (columnPosition != null) {
			setColumnPosition(columnPosition);
		}

		String columnFullName = (String)attributes.get("columnFullName");

		if (columnFullName != null) {
			setColumnFullName(columnFullName);
		}

		Long tableEntryId = (Long)attributes.get("tableEntryId");

		if (tableEntryId != null) {
			setTableEntryId(tableEntryId);
		}

		String tableName = (String)attributes.get("tableName");

		if (tableName != null) {
			setTableName(tableName);
		}

		String systemName = (String)attributes.get("systemName");

		if (systemName != null) {
			setSystemName(systemName);
		}

		String databaseName = (String)attributes.get("databaseName");

		if (databaseName != null) {
			setDatabaseName(databaseName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String dataType = (String)attributes.get("dataType");

		if (dataType != null) {
			setDataType(dataType);
		}

		Long dataSize = (Long)attributes.get("dataSize");

		if (dataSize != null) {
			setDataSize(dataSize);
		}

		Boolean isPrimaryKey = (Boolean)attributes.get("isPrimaryKey");

		if (isPrimaryKey != null) {
			setIsPrimaryKey(isPrimaryKey);
		}

		Boolean isNotNull = (Boolean)attributes.get("isNotNull");

		if (isNotNull != null) {
			setIsNotNull(isNotNull);
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
	public ColumnEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public boolean equals(Object object) {
		return model.equals(object);
	}

	/**
	 * Returns the column entry ID of this column entry.
	 *
	 * @return the column entry ID of this column entry
	 */
	@Override
	public long getColumnEntryId() {
		return model.getColumnEntryId();
	}

	/**
	 * Returns the column full name of this column entry.
	 *
	 * @return the column full name of this column entry
	 */
	@Override
	public String getColumnFullName() {
		return model.getColumnFullName();
	}

	/**
	 * Returns the column name of this column entry.
	 *
	 * @return the column name of this column entry
	 */
	@Override
	public String getColumnName() {
		return model.getColumnName();
	}

	/**
	 * Returns the column position of this column entry.
	 *
	 * @return the column position of this column entry
	 */
	@Override
	public long getColumnPosition() {
		return model.getColumnPosition();
	}

	/**
	 * Returns the column type of this column entry.
	 *
	 * @return the column type of this column entry
	 */
	@Override
	public String getColumnType() {
		return model.getColumnType();
	}

	/**
	 * Returns the company ID of this column entry.
	 *
	 * @return the company ID of this column entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this column entry.
	 *
	 * @return the create date of this column entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the database name of this column entry.
	 *
	 * @return the database name of this column entry
	 */
	@Override
	public String getDatabaseName() {
		return model.getDatabaseName();
	}

	/**
	 * Returns the data size of this column entry.
	 *
	 * @return the data size of this column entry
	 */
	@Override
	public long getDataSize() {
		return model.getDataSize();
	}

	/**
	 * Returns the data type of this column entry.
	 *
	 * @return the data type of this column entry
	 */
	@Override
	public String getDataType() {
		return model.getDataType();
	}

	/**
	 * Returns the description of this column entry.
	 *
	 * @return the description of this column entry
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this column entry.
	 *
	 * @return the group ID of this column entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is active of this column entry.
	 *
	 * @return the is active of this column entry
	 */
	@Override
	public boolean getIsActive() {
		return model.getIsActive();
	}

	/**
	 * Returns the is not null of this column entry.
	 *
	 * @return the is not null of this column entry
	 */
	@Override
	public boolean getIsNotNull() {
		return model.getIsNotNull();
	}

	/**
	 * Returns the is primary key of this column entry.
	 *
	 * @return the is primary key of this column entry
	 */
	@Override
	public boolean getIsPrimaryKey() {
		return model.getIsPrimaryKey();
	}

	/**
	 * Returns the modified date of this column entry.
	 *
	 * @return the modified date of this column entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this column entry.
	 *
	 * @return the mvcc version of this column entry
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this column entry.
	 *
	 * @return the primary key of this column entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this column entry.
	 *
	 * @return the status of this column entry
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this column entry.
	 *
	 * @return the status by user ID of this column entry
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this column entry.
	 *
	 * @return the status by user name of this column entry
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this column entry.
	 *
	 * @return the status by user uuid of this column entry
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this column entry.
	 *
	 * @return the status date of this column entry
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the system name of this column entry.
	 *
	 * @return the system name of this column entry
	 */
	@Override
	public String getSystemName() {
		return model.getSystemName();
	}

	/**
	 * Returns the table entry ID of this column entry.
	 *
	 * @return the table entry ID of this column entry
	 */
	@Override
	public long getTableEntryId() {
		return model.getTableEntryId();
	}

	/**
	 * Returns the table name of this column entry.
	 *
	 * @return the table name of this column entry
	 */
	@Override
	public String getTableName() {
		return model.getTableName();
	}

	/**
	 * Returns the trash entry created when this column entry was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this column entry.
	 *
	 * @return the trash entry created when this column entry was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this column entry.
	 *
	 * @return the class primary key of the trash entry for this column entry
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this column entry.
	 *
	 * @return the trash handler for this column entry
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the url title of this column entry.
	 *
	 * @return the url title of this column entry
	 */
	@Override
	public String getUrlTitle() {
		return model.getUrlTitle();
	}

	/**
	 * Returns the user ID of this column entry.
	 *
	 * @return the user ID of this column entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this column entry.
	 *
	 * @return the user name of this column entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this column entry.
	 *
	 * @return the user uuid of this column entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this column entry.
	 *
	 * @return the uuid of this column entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this column entry is approved.
	 *
	 * @return <code>true</code> if this column entry is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this column entry is denied.
	 *
	 * @return <code>true</code> if this column entry is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this column entry is a draft.
	 *
	 * @return <code>true</code> if this column entry is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this column entry is expired.
	 *
	 * @return <code>true</code> if this column entry is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this column entry is inactive.
	 *
	 * @return <code>true</code> if this column entry is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this column entry is incomplete.
	 *
	 * @return <code>true</code> if this column entry is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this column entry is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this column entry is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this column entry is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this column entry is in the Recycle Bin; <code>false</code> otherwise
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
	 * Returns <code>true</code> if this column entry is is active.
	 *
	 * @return <code>true</code> if this column entry is is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsActive() {
		return model.isIsActive();
	}

	/**
	 * Returns <code>true</code> if this column entry is is not null.
	 *
	 * @return <code>true</code> if this column entry is is not null; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsNotNull() {
		return model.isIsNotNull();
	}

	/**
	 * Returns <code>true</code> if this column entry is is primary key.
	 *
	 * @return <code>true</code> if this column entry is is primary key; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsPrimaryKey() {
		return model.isIsPrimaryKey();
	}

	/**
	 * Returns <code>true</code> if this column entry is pending.
	 *
	 * @return <code>true</code> if this column entry is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this column entry is scheduled.
	 *
	 * @return <code>true</code> if this column entry is scheduled; <code>false</code> otherwise
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
	 * Sets the column entry ID of this column entry.
	 *
	 * @param columnEntryId the column entry ID of this column entry
	 */
	@Override
	public void setColumnEntryId(long columnEntryId) {
		model.setColumnEntryId(columnEntryId);
	}

	/**
	 * Sets the column full name of this column entry.
	 *
	 * @param columnFullName the column full name of this column entry
	 */
	@Override
	public void setColumnFullName(String columnFullName) {
		model.setColumnFullName(columnFullName);
	}

	/**
	 * Sets the column name of this column entry.
	 *
	 * @param columnName the column name of this column entry
	 */
	@Override
	public void setColumnName(String columnName) {
		model.setColumnName(columnName);
	}

	/**
	 * Sets the column position of this column entry.
	 *
	 * @param columnPosition the column position of this column entry
	 */
	@Override
	public void setColumnPosition(long columnPosition) {
		model.setColumnPosition(columnPosition);
	}

	/**
	 * Sets the column type of this column entry.
	 *
	 * @param columnType the column type of this column entry
	 */
	@Override
	public void setColumnType(String columnType) {
		model.setColumnType(columnType);
	}

	/**
	 * Sets the company ID of this column entry.
	 *
	 * @param companyId the company ID of this column entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this column entry.
	 *
	 * @param createDate the create date of this column entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the database name of this column entry.
	 *
	 * @param databaseName the database name of this column entry
	 */
	@Override
	public void setDatabaseName(String databaseName) {
		model.setDatabaseName(databaseName);
	}

	/**
	 * Sets the data size of this column entry.
	 *
	 * @param dataSize the data size of this column entry
	 */
	@Override
	public void setDataSize(long dataSize) {
		model.setDataSize(dataSize);
	}

	/**
	 * Sets the data type of this column entry.
	 *
	 * @param dataType the data type of this column entry
	 */
	@Override
	public void setDataType(String dataType) {
		model.setDataType(dataType);
	}

	/**
	 * Sets the description of this column entry.
	 *
	 * @param description the description of this column entry
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this column entry.
	 *
	 * @param groupId the group ID of this column entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this column entry is is active.
	 *
	 * @param isActive the is active of this column entry
	 */
	@Override
	public void setIsActive(boolean isActive) {
		model.setIsActive(isActive);
	}

	/**
	 * Sets whether this column entry is is not null.
	 *
	 * @param isNotNull the is not null of this column entry
	 */
	@Override
	public void setIsNotNull(boolean isNotNull) {
		model.setIsNotNull(isNotNull);
	}

	/**
	 * Sets whether this column entry is is primary key.
	 *
	 * @param isPrimaryKey the is primary key of this column entry
	 */
	@Override
	public void setIsPrimaryKey(boolean isPrimaryKey) {
		model.setIsPrimaryKey(isPrimaryKey);
	}

	/**
	 * Sets the modified date of this column entry.
	 *
	 * @param modifiedDate the modified date of this column entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this column entry.
	 *
	 * @param mvccVersion the mvcc version of this column entry
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this column entry.
	 *
	 * @param primaryKey the primary key of this column entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this column entry.
	 *
	 * @param status the status of this column entry
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this column entry.
	 *
	 * @param statusByUserId the status by user ID of this column entry
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this column entry.
	 *
	 * @param statusByUserName the status by user name of this column entry
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this column entry.
	 *
	 * @param statusByUserUuid the status by user uuid of this column entry
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this column entry.
	 *
	 * @param statusDate the status date of this column entry
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the system name of this column entry.
	 *
	 * @param systemName the system name of this column entry
	 */
	@Override
	public void setSystemName(String systemName) {
		model.setSystemName(systemName);
	}

	/**
	 * Sets the table entry ID of this column entry.
	 *
	 * @param tableEntryId the table entry ID of this column entry
	 */
	@Override
	public void setTableEntryId(long tableEntryId) {
		model.setTableEntryId(tableEntryId);
	}

	/**
	 * Sets the table name of this column entry.
	 *
	 * @param tableName the table name of this column entry
	 */
	@Override
	public void setTableName(String tableName) {
		model.setTableName(tableName);
	}

	/**
	 * Sets the url title of this column entry.
	 *
	 * @param urlTitle the url title of this column entry
	 */
	@Override
	public void setUrlTitle(String urlTitle) {
		model.setUrlTitle(urlTitle);
	}

	/**
	 * Sets the user ID of this column entry.
	 *
	 * @param userId the user ID of this column entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this column entry.
	 *
	 * @param userName the user name of this column entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this column entry.
	 *
	 * @param userUuid the user uuid of this column entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this column entry.
	 *
	 * @param uuid the uuid of this column entry
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
	protected ColumnEntryWrapper wrap(ColumnEntry columnEntry) {
		return new ColumnEntryWrapper(columnEntry);
	}

}