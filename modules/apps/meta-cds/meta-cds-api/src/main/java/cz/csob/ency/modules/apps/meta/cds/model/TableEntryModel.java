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
 * The base model interface for the TableEntry service. Represents a row in the &quot;MetaCds_TableEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>cz.csob.ency.modules.apps.meta.cds.model.impl.TableEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>cz.csob.ency.modules.apps.meta.cds.model.impl.TableEntryImpl</code>.
 * </p>
 *
 * @author "Miroslav Čermák"
 * @see TableEntry
 * @generated
 */
@ProviderType
public interface TableEntryModel
	extends BaseModel<TableEntry>, GroupedModel, MVCCModel, ShardedModel,
			StagedAuditedModel, TrashedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a table entry model instance should use the {@link TableEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this table entry.
	 *
	 * @return the primary key of this table entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this table entry.
	 *
	 * @param primaryKey the primary key of this table entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this table entry.
	 *
	 * @return the mvcc version of this table entry
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this table entry.
	 *
	 * @param mvccVersion the mvcc version of this table entry
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this table entry.
	 *
	 * @return the uuid of this table entry
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this table entry.
	 *
	 * @param uuid the uuid of this table entry
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the table entry ID of this table entry.
	 *
	 * @return the table entry ID of this table entry
	 */
	public long getTableEntryId();

	/**
	 * Sets the table entry ID of this table entry.
	 *
	 * @param tableEntryId the table entry ID of this table entry
	 */
	public void setTableEntryId(long tableEntryId);

	/**
	 * Returns the table name of this table entry.
	 *
	 * @return the table name of this table entry
	 */
	@AutoEscape
	public String getTableName();

	/**
	 * Sets the table name of this table entry.
	 *
	 * @param tableName the table name of this table entry
	 */
	public void setTableName(String tableName);

	/**
	 * Returns the table full name of this table entry.
	 *
	 * @return the table full name of this table entry
	 */
	@AutoEscape
	public String getTableFullName();

	/**
	 * Sets the table full name of this table entry.
	 *
	 * @param tableFullName the table full name of this table entry
	 */
	public void setTableFullName(String tableFullName);

	/**
	 * Returns the table type of this table entry.
	 *
	 * @return the table type of this table entry
	 */
	@AutoEscape
	public String getTableType();

	/**
	 * Sets the table type of this table entry.
	 *
	 * @param tableType the table type of this table entry
	 */
	public void setTableType(String tableType);

	/**
	 * Returns the table database of this table entry.
	 *
	 * @return the table database of this table entry
	 */
	@AutoEscape
	public String getTableDatabase();

	/**
	 * Sets the table database of this table entry.
	 *
	 * @param tableDatabase the table database of this table entry
	 */
	public void setTableDatabase(String tableDatabase);

	/**
	 * Returns the system entry ID of this table entry.
	 *
	 * @return the system entry ID of this table entry
	 */
	public long getSystemEntryId();

	/**
	 * Sets the system entry ID of this table entry.
	 *
	 * @param systemEntryId the system entry ID of this table entry
	 */
	public void setSystemEntryId(long systemEntryId);

	/**
	 * Returns the system name of this table entry.
	 *
	 * @return the system name of this table entry
	 */
	@AutoEscape
	public String getSystemName();

	/**
	 * Sets the system name of this table entry.
	 *
	 * @param systemName the system name of this table entry
	 */
	public void setSystemName(String systemName);

	/**
	 * Returns the description of this table entry.
	 *
	 * @return the description of this table entry
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this table entry.
	 *
	 * @param description the description of this table entry
	 */
	public void setDescription(String description);

	/**
	 * Returns the dsa url of this table entry.
	 *
	 * @return the dsa url of this table entry
	 */
	@AutoEscape
	public String getDsaUrl();

	/**
	 * Sets the dsa url of this table entry.
	 *
	 * @param dsaUrl the dsa url of this table entry
	 */
	public void setDsaUrl(String dsaUrl);

	/**
	 * Returns the contact person name of this table entry.
	 *
	 * @return the contact person name of this table entry
	 */
	@AutoEscape
	public String getContactPersonName();

	/**
	 * Sets the contact person name of this table entry.
	 *
	 * @param contactPersonName the contact person name of this table entry
	 */
	public void setContactPersonName(String contactPersonName);

	/**
	 * Returns the contact person ID of this table entry.
	 *
	 * @return the contact person ID of this table entry
	 */
	@AutoEscape
	public String getContactPersonId();

	/**
	 * Sets the contact person ID of this table entry.
	 *
	 * @param contactPersonId the contact person ID of this table entry
	 */
	public void setContactPersonId(String contactPersonId);

	/**
	 * Returns the specification owner name of this table entry.
	 *
	 * @return the specification owner name of this table entry
	 */
	@AutoEscape
	public String getSpecificationOwnerName();

	/**
	 * Sets the specification owner name of this table entry.
	 *
	 * @param specificationOwnerName the specification owner name of this table entry
	 */
	public void setSpecificationOwnerName(String specificationOwnerName);

	/**
	 * Returns the specification owner ID of this table entry.
	 *
	 * @return the specification owner ID of this table entry
	 */
	@AutoEscape
	public String getSpecificationOwnerId();

	/**
	 * Sets the specification owner ID of this table entry.
	 *
	 * @param specificationOwnerId the specification owner ID of this table entry
	 */
	public void setSpecificationOwnerId(String specificationOwnerId);

	/**
	 * Returns the unstructured clause of this table entry.
	 *
	 * @return the unstructured clause of this table entry
	 */
	@AutoEscape
	public String getUnstructuredClause();

	/**
	 * Sets the unstructured clause of this table entry.
	 *
	 * @param unstructuredClause the unstructured clause of this table entry
	 */
	public void setUnstructuredClause(String unstructuredClause);

	/**
	 * Returns the is active of this table entry.
	 *
	 * @return the is active of this table entry
	 */
	public boolean getIsActive();

	/**
	 * Returns <code>true</code> if this table entry is is active.
	 *
	 * @return <code>true</code> if this table entry is is active; <code>false</code> otherwise
	 */
	public boolean isIsActive();

	/**
	 * Sets whether this table entry is is active.
	 *
	 * @param isActive the is active of this table entry
	 */
	public void setIsActive(boolean isActive);

	/**
	 * Returns the group ID of this table entry.
	 *
	 * @return the group ID of this table entry
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this table entry.
	 *
	 * @param groupId the group ID of this table entry
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this table entry.
	 *
	 * @return the company ID of this table entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this table entry.
	 *
	 * @param companyId the company ID of this table entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this table entry.
	 *
	 * @return the user ID of this table entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this table entry.
	 *
	 * @param userId the user ID of this table entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this table entry.
	 *
	 * @return the user uuid of this table entry
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this table entry.
	 *
	 * @param userUuid the user uuid of this table entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this table entry.
	 *
	 * @return the user name of this table entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this table entry.
	 *
	 * @param userName the user name of this table entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this table entry.
	 *
	 * @return the create date of this table entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this table entry.
	 *
	 * @param createDate the create date of this table entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this table entry.
	 *
	 * @return the modified date of this table entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this table entry.
	 *
	 * @param modifiedDate the modified date of this table entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the url title of this table entry.
	 *
	 * @return the url title of this table entry
	 */
	@AutoEscape
	public String getUrlTitle();

	/**
	 * Sets the url title of this table entry.
	 *
	 * @param urlTitle the url title of this table entry
	 */
	public void setUrlTitle(String urlTitle);

	/**
	 * Returns the status of this table entry.
	 *
	 * @return the status of this table entry
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this table entry.
	 *
	 * @param status the status of this table entry
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this table entry.
	 *
	 * @return the status by user ID of this table entry
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this table entry.
	 *
	 * @param statusByUserId the status by user ID of this table entry
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this table entry.
	 *
	 * @return the status by user uuid of this table entry
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this table entry.
	 *
	 * @param statusByUserUuid the status by user uuid of this table entry
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this table entry.
	 *
	 * @return the status by user name of this table entry
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this table entry.
	 *
	 * @param statusByUserName the status by user name of this table entry
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this table entry.
	 *
	 * @return the status date of this table entry
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this table entry.
	 *
	 * @param statusDate the status date of this table entry
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the trash entry created when this table entry was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this table entry.
	 *
	 * @return the trash entry created when this table entry was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws PortalException;

	/**
	 * Returns the class primary key of the trash entry for this table entry.
	 *
	 * @return the class primary key of the trash entry for this table entry
	 */
	@Override
	public long getTrashEntryClassPK();

	/**
	 * Returns the trash handler for this table entry.
	 *
	 * @return the trash handler for this table entry
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler();

	/**
	 * Returns <code>true</code> if this table entry is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this table entry is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash();

	/**
	 * Returns <code>true</code> if the parent of this table entry is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this table entry is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrashContainer();

	@Override
	public boolean isInTrashExplicitly();

	@Override
	public boolean isInTrashImplicitly();

	/**
	 * Returns <code>true</code> if this table entry is approved.
	 *
	 * @return <code>true</code> if this table entry is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this table entry is denied.
	 *
	 * @return <code>true</code> if this table entry is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this table entry is a draft.
	 *
	 * @return <code>true</code> if this table entry is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this table entry is expired.
	 *
	 * @return <code>true</code> if this table entry is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this table entry is inactive.
	 *
	 * @return <code>true</code> if this table entry is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this table entry is incomplete.
	 *
	 * @return <code>true</code> if this table entry is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this table entry is pending.
	 *
	 * @return <code>true</code> if this table entry is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this table entry is scheduled.
	 *
	 * @return <code>true</code> if this table entry is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public TableEntry cloneWithOriginalValues();

}