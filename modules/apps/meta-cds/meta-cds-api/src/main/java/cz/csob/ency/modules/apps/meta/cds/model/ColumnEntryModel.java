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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.TrashedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the ColumnEntry service. Represents a row in the &quot;MetaCds_ColumnEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>cz.csob.ency.modules.apps.meta.cds.model.impl.ColumnEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>cz.csob.ency.modules.apps.meta.cds.model.impl.ColumnEntryImpl</code>.
 * </p>
 *
 * @author "Miroslav Čermák"
 * @see ColumnEntry
 * @generated
 */
@ProviderType
public interface ColumnEntryModel
	extends BaseModel<ColumnEntry>, GroupedModel, MVCCModel, ShardedModel,
			StagedAuditedModel, TrashedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a column entry model instance should use the {@link ColumnEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this column entry.
	 *
	 * @return the primary key of this column entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this column entry.
	 *
	 * @param primaryKey the primary key of this column entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this column entry.
	 *
	 * @return the mvcc version of this column entry
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this column entry.
	 *
	 * @param mvccVersion the mvcc version of this column entry
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this column entry.
	 *
	 * @return the uuid of this column entry
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this column entry.
	 *
	 * @param uuid the uuid of this column entry
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the column entry ID of this column entry.
	 *
	 * @return the column entry ID of this column entry
	 */
	public long getColumnEntryId();

	/**
	 * Sets the column entry ID of this column entry.
	 *
	 * @param columnEntryId the column entry ID of this column entry
	 */
	public void setColumnEntryId(long columnEntryId);

	/**
	 * Returns the column type of this column entry.
	 *
	 * @return the column type of this column entry
	 */
	@AutoEscape
	public String getColumnType();

	/**
	 * Sets the column type of this column entry.
	 *
	 * @param columnType the column type of this column entry
	 */
	public void setColumnType(String columnType);

	/**
	 * Returns the column name of this column entry.
	 *
	 * @return the column name of this column entry
	 */
	@AutoEscape
	public String getColumnName();

	/**
	 * Sets the column name of this column entry.
	 *
	 * @param columnName the column name of this column entry
	 */
	public void setColumnName(String columnName);

	/**
	 * Returns the column position of this column entry.
	 *
	 * @return the column position of this column entry
	 */
	public long getColumnPosition();

	/**
	 * Sets the column position of this column entry.
	 *
	 * @param columnPosition the column position of this column entry
	 */
	public void setColumnPosition(long columnPosition);

	/**
	 * Returns the column full name of this column entry.
	 *
	 * @return the column full name of this column entry
	 */
	@AutoEscape
	public String getColumnFullName();

	/**
	 * Sets the column full name of this column entry.
	 *
	 * @param columnFullName the column full name of this column entry
	 */
	public void setColumnFullName(String columnFullName);

	/**
	 * Returns the table entry ID of this column entry.
	 *
	 * @return the table entry ID of this column entry
	 */
	public long getTableEntryId();

	/**
	 * Sets the table entry ID of this column entry.
	 *
	 * @param tableEntryId the table entry ID of this column entry
	 */
	public void setTableEntryId(long tableEntryId);

	/**
	 * Returns the table name of this column entry.
	 *
	 * @return the table name of this column entry
	 */
	@AutoEscape
	public String getTableName();

	/**
	 * Sets the table name of this column entry.
	 *
	 * @param tableName the table name of this column entry
	 */
	public void setTableName(String tableName);

	/**
	 * Returns the system name of this column entry.
	 *
	 * @return the system name of this column entry
	 */
	@AutoEscape
	public String getSystemName();

	/**
	 * Sets the system name of this column entry.
	 *
	 * @param systemName the system name of this column entry
	 */
	public void setSystemName(String systemName);

	/**
	 * Returns the database name of this column entry.
	 *
	 * @return the database name of this column entry
	 */
	@AutoEscape
	public String getDatabaseName();

	/**
	 * Sets the database name of this column entry.
	 *
	 * @param databaseName the database name of this column entry
	 */
	public void setDatabaseName(String databaseName);

	/**
	 * Returns the description of this column entry.
	 *
	 * @return the description of this column entry
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this column entry.
	 *
	 * @param description the description of this column entry
	 */
	public void setDescription(String description);

	/**
	 * Returns the data type of this column entry.
	 *
	 * @return the data type of this column entry
	 */
	@AutoEscape
	public String getDataType();

	/**
	 * Sets the data type of this column entry.
	 *
	 * @param dataType the data type of this column entry
	 */
	public void setDataType(String dataType);

	/**
	 * Returns the data size of this column entry.
	 *
	 * @return the data size of this column entry
	 */
	public long getDataSize();

	/**
	 * Sets the data size of this column entry.
	 *
	 * @param dataSize the data size of this column entry
	 */
	public void setDataSize(long dataSize);

	/**
	 * Returns the is primary key of this column entry.
	 *
	 * @return the is primary key of this column entry
	 */
	public boolean getIsPrimaryKey();

	/**
	 * Returns <code>true</code> if this column entry is is primary key.
	 *
	 * @return <code>true</code> if this column entry is is primary key; <code>false</code> otherwise
	 */
	public boolean isIsPrimaryKey();

	/**
	 * Sets whether this column entry is is primary key.
	 *
	 * @param isPrimaryKey the is primary key of this column entry
	 */
	public void setIsPrimaryKey(boolean isPrimaryKey);

	/**
	 * Returns the is not null of this column entry.
	 *
	 * @return the is not null of this column entry
	 */
	public boolean getIsNotNull();

	/**
	 * Returns <code>true</code> if this column entry is is not null.
	 *
	 * @return <code>true</code> if this column entry is is not null; <code>false</code> otherwise
	 */
	public boolean isIsNotNull();

	/**
	 * Sets whether this column entry is is not null.
	 *
	 * @param isNotNull the is not null of this column entry
	 */
	public void setIsNotNull(boolean isNotNull);

	/**
	 * Returns the is active of this column entry.
	 *
	 * @return the is active of this column entry
	 */
	public boolean getIsActive();

	/**
	 * Returns <code>true</code> if this column entry is is active.
	 *
	 * @return <code>true</code> if this column entry is is active; <code>false</code> otherwise
	 */
	public boolean isIsActive();

	/**
	 * Sets whether this column entry is is active.
	 *
	 * @param isActive the is active of this column entry
	 */
	public void setIsActive(boolean isActive);

	/**
	 * Returns the group ID of this column entry.
	 *
	 * @return the group ID of this column entry
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this column entry.
	 *
	 * @param groupId the group ID of this column entry
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this column entry.
	 *
	 * @return the company ID of this column entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this column entry.
	 *
	 * @param companyId the company ID of this column entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this column entry.
	 *
	 * @return the user ID of this column entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this column entry.
	 *
	 * @param userId the user ID of this column entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this column entry.
	 *
	 * @return the user uuid of this column entry
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this column entry.
	 *
	 * @param userUuid the user uuid of this column entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this column entry.
	 *
	 * @return the user name of this column entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this column entry.
	 *
	 * @param userName the user name of this column entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this column entry.
	 *
	 * @return the create date of this column entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this column entry.
	 *
	 * @param createDate the create date of this column entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this column entry.
	 *
	 * @return the modified date of this column entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this column entry.
	 *
	 * @param modifiedDate the modified date of this column entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the url title of this column entry.
	 *
	 * @return the url title of this column entry
	 */
	@AutoEscape
	public String getUrlTitle();

	/**
	 * Sets the url title of this column entry.
	 *
	 * @param urlTitle the url title of this column entry
	 */
	public void setUrlTitle(String urlTitle);

	/**
	 * Returns the status of this column entry.
	 *
	 * @return the status of this column entry
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this column entry.
	 *
	 * @param status the status of this column entry
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this column entry.
	 *
	 * @return the status by user ID of this column entry
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this column entry.
	 *
	 * @param statusByUserId the status by user ID of this column entry
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this column entry.
	 *
	 * @return the status by user uuid of this column entry
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this column entry.
	 *
	 * @param statusByUserUuid the status by user uuid of this column entry
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this column entry.
	 *
	 * @return the status by user name of this column entry
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this column entry.
	 *
	 * @param statusByUserName the status by user name of this column entry
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this column entry.
	 *
	 * @return the status date of this column entry
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this column entry.
	 *
	 * @param statusDate the status date of this column entry
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the trash entry created when this column entry was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this column entry.
	 *
	 * @return the trash entry created when this column entry was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws PortalException;

	/**
	 * Returns the class primary key of the trash entry for this column entry.
	 *
	 * @return the class primary key of the trash entry for this column entry
	 */
	@Override
	public long getTrashEntryClassPK();

	/**
	 * Returns the trash handler for this column entry.
	 *
	 * @return the trash handler for this column entry
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler();

	/**
	 * Returns <code>true</code> if this column entry is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this column entry is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash();

	/**
	 * Returns <code>true</code> if the parent of this column entry is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this column entry is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrashContainer();

	@Override
	public boolean isInTrashExplicitly();

	@Override
	public boolean isInTrashImplicitly();

	/**
	 * Returns <code>true</code> if this column entry is approved.
	 *
	 * @return <code>true</code> if this column entry is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this column entry is denied.
	 *
	 * @return <code>true</code> if this column entry is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this column entry is a draft.
	 *
	 * @return <code>true</code> if this column entry is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this column entry is expired.
	 *
	 * @return <code>true</code> if this column entry is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this column entry is inactive.
	 *
	 * @return <code>true</code> if this column entry is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this column entry is incomplete.
	 *
	 * @return <code>true</code> if this column entry is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this column entry is pending.
	 *
	 * @return <code>true</code> if this column entry is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this column entry is scheduled.
	 *
	 * @return <code>true</code> if this column entry is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public ColumnEntry cloneWithOriginalValues();

}