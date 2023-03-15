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
 * This class is a wrapper for {@link SystemEntry}.
 * </p>
 *
 * @author "Miroslav Čermák"
 * @see SystemEntry
 * @generated
 */
public class SystemEntryWrapper
	extends BaseModelWrapper<SystemEntry>
	implements ModelWrapper<SystemEntry>, SystemEntry {

	public SystemEntryWrapper(SystemEntry systemEntry) {
		super(systemEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("systemEntryId", getSystemEntryId());
		attributes.put("systemCode", getSystemCode());
		attributes.put("systemName", getSystemName());
		attributes.put("systemTitle", getSystemTitle());
		attributes.put("systemType", getSystemType());
		attributes.put("description", getDescription());
		attributes.put("stewardName", getStewardName());
		attributes.put("stewardId", getStewardId());
		attributes.put("stewardDepartment", getStewardDepartment());
		attributes.put("businessOwnerName", getBusinessOwnerName());
		attributes.put("businessOwnerId", getBusinessOwnerId());
		attributes.put("contactPersonName", getContactPersonName());
		attributes.put("contactPersonId", getContactPersonId());
		attributes.put("sandboxName", getSandboxName());
		attributes.put("gestorDepartmentId", getGestorDepartmentId());
		attributes.put("gestorDepartmentName", getGestorDepartmentName());
		attributes.put("role", getRole());
		attributes.put("snowAssetTagId", getSnowAssetTagId());
		attributes.put("snowAssetTagName", getSnowAssetTagName());
		attributes.put("isSlaSigned", isIsSlaSigned());
		attributes.put("isSelfBi", isIsSelfBi());
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

		Long systemEntryId = (Long)attributes.get("systemEntryId");

		if (systemEntryId != null) {
			setSystemEntryId(systemEntryId);
		}

		Long systemCode = (Long)attributes.get("systemCode");

		if (systemCode != null) {
			setSystemCode(systemCode);
		}

		String systemName = (String)attributes.get("systemName");

		if (systemName != null) {
			setSystemName(systemName);
		}

		String systemTitle = (String)attributes.get("systemTitle");

		if (systemTitle != null) {
			setSystemTitle(systemTitle);
		}

		String systemType = (String)attributes.get("systemType");

		if (systemType != null) {
			setSystemType(systemType);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String stewardName = (String)attributes.get("stewardName");

		if (stewardName != null) {
			setStewardName(stewardName);
		}

		String stewardId = (String)attributes.get("stewardId");

		if (stewardId != null) {
			setStewardId(stewardId);
		}

		String stewardDepartment = (String)attributes.get("stewardDepartment");

		if (stewardDepartment != null) {
			setStewardDepartment(stewardDepartment);
		}

		String businessOwnerName = (String)attributes.get("businessOwnerName");

		if (businessOwnerName != null) {
			setBusinessOwnerName(businessOwnerName);
		}

		String businessOwnerId = (String)attributes.get("businessOwnerId");

		if (businessOwnerId != null) {
			setBusinessOwnerId(businessOwnerId);
		}

		String contactPersonName = (String)attributes.get("contactPersonName");

		if (contactPersonName != null) {
			setContactPersonName(contactPersonName);
		}

		String contactPersonId = (String)attributes.get("contactPersonId");

		if (contactPersonId != null) {
			setContactPersonId(contactPersonId);
		}

		String sandboxName = (String)attributes.get("sandboxName");

		if (sandboxName != null) {
			setSandboxName(sandboxName);
		}

		String gestorDepartmentId = (String)attributes.get(
			"gestorDepartmentId");

		if (gestorDepartmentId != null) {
			setGestorDepartmentId(gestorDepartmentId);
		}

		String gestorDepartmentName = (String)attributes.get(
			"gestorDepartmentName");

		if (gestorDepartmentName != null) {
			setGestorDepartmentName(gestorDepartmentName);
		}

		String role = (String)attributes.get("role");

		if (role != null) {
			setRole(role);
		}

		String snowAssetTagId = (String)attributes.get("snowAssetTagId");

		if (snowAssetTagId != null) {
			setSnowAssetTagId(snowAssetTagId);
		}

		String snowAssetTagName = (String)attributes.get("snowAssetTagName");

		if (snowAssetTagName != null) {
			setSnowAssetTagName(snowAssetTagName);
		}

		Boolean isSlaSigned = (Boolean)attributes.get("isSlaSigned");

		if (isSlaSigned != null) {
			setIsSlaSigned(isSlaSigned);
		}

		Boolean isSelfBi = (Boolean)attributes.get("isSelfBi");

		if (isSelfBi != null) {
			setIsSelfBi(isSelfBi);
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
	public SystemEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public boolean equals(Object object) {
		return model.equals(object);
	}

	/**
	 * Returns the business owner ID of this system entry.
	 *
	 * @return the business owner ID of this system entry
	 */
	@Override
	public String getBusinessOwnerId() {
		return model.getBusinessOwnerId();
	}

	/**
	 * Returns the business owner name of this system entry.
	 *
	 * @return the business owner name of this system entry
	 */
	@Override
	public String getBusinessOwnerName() {
		return model.getBusinessOwnerName();
	}

	/**
	 * Returns the company ID of this system entry.
	 *
	 * @return the company ID of this system entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the contact person ID of this system entry.
	 *
	 * @return the contact person ID of this system entry
	 */
	@Override
	public String getContactPersonId() {
		return model.getContactPersonId();
	}

	/**
	 * Returns the contact person name of this system entry.
	 *
	 * @return the contact person name of this system entry
	 */
	@Override
	public String getContactPersonName() {
		return model.getContactPersonName();
	}

	/**
	 * Returns the create date of this system entry.
	 *
	 * @return the create date of this system entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this system entry.
	 *
	 * @return the description of this system entry
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the gestor department ID of this system entry.
	 *
	 * @return the gestor department ID of this system entry
	 */
	@Override
	public String getGestorDepartmentId() {
		return model.getGestorDepartmentId();
	}

	/**
	 * Returns the gestor department name of this system entry.
	 *
	 * @return the gestor department name of this system entry
	 */
	@Override
	public String getGestorDepartmentName() {
		return model.getGestorDepartmentName();
	}

	/**
	 * Returns the group ID of this system entry.
	 *
	 * @return the group ID of this system entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is active of this system entry.
	 *
	 * @return the is active of this system entry
	 */
	@Override
	public boolean getIsActive() {
		return model.getIsActive();
	}

	/**
	 * Returns the is self bi of this system entry.
	 *
	 * @return the is self bi of this system entry
	 */
	@Override
	public boolean getIsSelfBi() {
		return model.getIsSelfBi();
	}

	/**
	 * Returns the is sla signed of this system entry.
	 *
	 * @return the is sla signed of this system entry
	 */
	@Override
	public boolean getIsSlaSigned() {
		return model.getIsSlaSigned();
	}

	/**
	 * Returns the modified date of this system entry.
	 *
	 * @return the modified date of this system entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this system entry.
	 *
	 * @return the mvcc version of this system entry
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this system entry.
	 *
	 * @return the primary key of this system entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role of this system entry.
	 *
	 * @return the role of this system entry
	 */
	@Override
	public String getRole() {
		return model.getRole();
	}

	/**
	 * Returns the sandbox name of this system entry.
	 *
	 * @return the sandbox name of this system entry
	 */
	@Override
	public String getSandboxName() {
		return model.getSandboxName();
	}

	/**
	 * Returns the snow asset tag ID of this system entry.
	 *
	 * @return the snow asset tag ID of this system entry
	 */
	@Override
	public String getSnowAssetTagId() {
		return model.getSnowAssetTagId();
	}

	/**
	 * Returns the snow asset tag name of this system entry.
	 *
	 * @return the snow asset tag name of this system entry
	 */
	@Override
	public String getSnowAssetTagName() {
		return model.getSnowAssetTagName();
	}

	/**
	 * Returns the status of this system entry.
	 *
	 * @return the status of this system entry
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this system entry.
	 *
	 * @return the status by user ID of this system entry
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this system entry.
	 *
	 * @return the status by user name of this system entry
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this system entry.
	 *
	 * @return the status by user uuid of this system entry
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this system entry.
	 *
	 * @return the status date of this system entry
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the steward department of this system entry.
	 *
	 * @return the steward department of this system entry
	 */
	@Override
	public String getStewardDepartment() {
		return model.getStewardDepartment();
	}

	/**
	 * Returns the steward ID of this system entry.
	 *
	 * @return the steward ID of this system entry
	 */
	@Override
	public String getStewardId() {
		return model.getStewardId();
	}

	/**
	 * Returns the steward name of this system entry.
	 *
	 * @return the steward name of this system entry
	 */
	@Override
	public String getStewardName() {
		return model.getStewardName();
	}

	/**
	 * Returns the system code of this system entry.
	 *
	 * @return the system code of this system entry
	 */
	@Override
	public long getSystemCode() {
		return model.getSystemCode();
	}

	/**
	 * Returns the system entry ID of this system entry.
	 *
	 * @return the system entry ID of this system entry
	 */
	@Override
	public long getSystemEntryId() {
		return model.getSystemEntryId();
	}

	/**
	 * Returns the system name of this system entry.
	 *
	 * @return the system name of this system entry
	 */
	@Override
	public String getSystemName() {
		return model.getSystemName();
	}

	/**
	 * Returns the system title of this system entry.
	 *
	 * @return the system title of this system entry
	 */
	@Override
	public String getSystemTitle() {
		return model.getSystemTitle();
	}

	/**
	 * Returns the system type of this system entry.
	 *
	 * @return the system type of this system entry
	 */
	@Override
	public String getSystemType() {
		return model.getSystemType();
	}

	/**
	 * Returns the trash entry created when this system entry was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this system entry.
	 *
	 * @return the trash entry created when this system entry was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this system entry.
	 *
	 * @return the class primary key of the trash entry for this system entry
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this system entry.
	 *
	 * @return the trash handler for this system entry
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the url title of this system entry.
	 *
	 * @return the url title of this system entry
	 */
	@Override
	public String getUrlTitle() {
		return model.getUrlTitle();
	}

	/**
	 * Returns the user ID of this system entry.
	 *
	 * @return the user ID of this system entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this system entry.
	 *
	 * @return the user name of this system entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this system entry.
	 *
	 * @return the user uuid of this system entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this system entry.
	 *
	 * @return the uuid of this system entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this system entry is approved.
	 *
	 * @return <code>true</code> if this system entry is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this system entry is denied.
	 *
	 * @return <code>true</code> if this system entry is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this system entry is a draft.
	 *
	 * @return <code>true</code> if this system entry is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this system entry is expired.
	 *
	 * @return <code>true</code> if this system entry is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this system entry is inactive.
	 *
	 * @return <code>true</code> if this system entry is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this system entry is incomplete.
	 *
	 * @return <code>true</code> if this system entry is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this system entry is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this system entry is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this system entry is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this system entry is in the Recycle Bin; <code>false</code> otherwise
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
	 * Returns <code>true</code> if this system entry is is active.
	 *
	 * @return <code>true</code> if this system entry is is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsActive() {
		return model.isIsActive();
	}

	/**
	 * Returns <code>true</code> if this system entry is is self bi.
	 *
	 * @return <code>true</code> if this system entry is is self bi; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsSelfBi() {
		return model.isIsSelfBi();
	}

	/**
	 * Returns <code>true</code> if this system entry is is sla signed.
	 *
	 * @return <code>true</code> if this system entry is is sla signed; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsSlaSigned() {
		return model.isIsSlaSigned();
	}

	/**
	 * Returns <code>true</code> if this system entry is pending.
	 *
	 * @return <code>true</code> if this system entry is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this system entry is scheduled.
	 *
	 * @return <code>true</code> if this system entry is scheduled; <code>false</code> otherwise
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
	 * Sets the business owner ID of this system entry.
	 *
	 * @param businessOwnerId the business owner ID of this system entry
	 */
	@Override
	public void setBusinessOwnerId(String businessOwnerId) {
		model.setBusinessOwnerId(businessOwnerId);
	}

	/**
	 * Sets the business owner name of this system entry.
	 *
	 * @param businessOwnerName the business owner name of this system entry
	 */
	@Override
	public void setBusinessOwnerName(String businessOwnerName) {
		model.setBusinessOwnerName(businessOwnerName);
	}

	/**
	 * Sets the company ID of this system entry.
	 *
	 * @param companyId the company ID of this system entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the contact person ID of this system entry.
	 *
	 * @param contactPersonId the contact person ID of this system entry
	 */
	@Override
	public void setContactPersonId(String contactPersonId) {
		model.setContactPersonId(contactPersonId);
	}

	/**
	 * Sets the contact person name of this system entry.
	 *
	 * @param contactPersonName the contact person name of this system entry
	 */
	@Override
	public void setContactPersonName(String contactPersonName) {
		model.setContactPersonName(contactPersonName);
	}

	/**
	 * Sets the create date of this system entry.
	 *
	 * @param createDate the create date of this system entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this system entry.
	 *
	 * @param description the description of this system entry
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the gestor department ID of this system entry.
	 *
	 * @param gestorDepartmentId the gestor department ID of this system entry
	 */
	@Override
	public void setGestorDepartmentId(String gestorDepartmentId) {
		model.setGestorDepartmentId(gestorDepartmentId);
	}

	/**
	 * Sets the gestor department name of this system entry.
	 *
	 * @param gestorDepartmentName the gestor department name of this system entry
	 */
	@Override
	public void setGestorDepartmentName(String gestorDepartmentName) {
		model.setGestorDepartmentName(gestorDepartmentName);
	}

	/**
	 * Sets the group ID of this system entry.
	 *
	 * @param groupId the group ID of this system entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this system entry is is active.
	 *
	 * @param isActive the is active of this system entry
	 */
	@Override
	public void setIsActive(boolean isActive) {
		model.setIsActive(isActive);
	}

	/**
	 * Sets whether this system entry is is self bi.
	 *
	 * @param isSelfBi the is self bi of this system entry
	 */
	@Override
	public void setIsSelfBi(boolean isSelfBi) {
		model.setIsSelfBi(isSelfBi);
	}

	/**
	 * Sets whether this system entry is is sla signed.
	 *
	 * @param isSlaSigned the is sla signed of this system entry
	 */
	@Override
	public void setIsSlaSigned(boolean isSlaSigned) {
		model.setIsSlaSigned(isSlaSigned);
	}

	/**
	 * Sets the modified date of this system entry.
	 *
	 * @param modifiedDate the modified date of this system entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this system entry.
	 *
	 * @param mvccVersion the mvcc version of this system entry
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this system entry.
	 *
	 * @param primaryKey the primary key of this system entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role of this system entry.
	 *
	 * @param role the role of this system entry
	 */
	@Override
	public void setRole(String role) {
		model.setRole(role);
	}

	/**
	 * Sets the sandbox name of this system entry.
	 *
	 * @param sandboxName the sandbox name of this system entry
	 */
	@Override
	public void setSandboxName(String sandboxName) {
		model.setSandboxName(sandboxName);
	}

	/**
	 * Sets the snow asset tag ID of this system entry.
	 *
	 * @param snowAssetTagId the snow asset tag ID of this system entry
	 */
	@Override
	public void setSnowAssetTagId(String snowAssetTagId) {
		model.setSnowAssetTagId(snowAssetTagId);
	}

	/**
	 * Sets the snow asset tag name of this system entry.
	 *
	 * @param snowAssetTagName the snow asset tag name of this system entry
	 */
	@Override
	public void setSnowAssetTagName(String snowAssetTagName) {
		model.setSnowAssetTagName(snowAssetTagName);
	}

	/**
	 * Sets the status of this system entry.
	 *
	 * @param status the status of this system entry
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this system entry.
	 *
	 * @param statusByUserId the status by user ID of this system entry
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this system entry.
	 *
	 * @param statusByUserName the status by user name of this system entry
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this system entry.
	 *
	 * @param statusByUserUuid the status by user uuid of this system entry
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this system entry.
	 *
	 * @param statusDate the status date of this system entry
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the steward department of this system entry.
	 *
	 * @param stewardDepartment the steward department of this system entry
	 */
	@Override
	public void setStewardDepartment(String stewardDepartment) {
		model.setStewardDepartment(stewardDepartment);
	}

	/**
	 * Sets the steward ID of this system entry.
	 *
	 * @param stewardId the steward ID of this system entry
	 */
	@Override
	public void setStewardId(String stewardId) {
		model.setStewardId(stewardId);
	}

	/**
	 * Sets the steward name of this system entry.
	 *
	 * @param stewardName the steward name of this system entry
	 */
	@Override
	public void setStewardName(String stewardName) {
		model.setStewardName(stewardName);
	}

	/**
	 * Sets the system code of this system entry.
	 *
	 * @param systemCode the system code of this system entry
	 */
	@Override
	public void setSystemCode(long systemCode) {
		model.setSystemCode(systemCode);
	}

	/**
	 * Sets the system entry ID of this system entry.
	 *
	 * @param systemEntryId the system entry ID of this system entry
	 */
	@Override
	public void setSystemEntryId(long systemEntryId) {
		model.setSystemEntryId(systemEntryId);
	}

	/**
	 * Sets the system name of this system entry.
	 *
	 * @param systemName the system name of this system entry
	 */
	@Override
	public void setSystemName(String systemName) {
		model.setSystemName(systemName);
	}

	/**
	 * Sets the system title of this system entry.
	 *
	 * @param systemTitle the system title of this system entry
	 */
	@Override
	public void setSystemTitle(String systemTitle) {
		model.setSystemTitle(systemTitle);
	}

	/**
	 * Sets the system type of this system entry.
	 *
	 * @param systemType the system type of this system entry
	 */
	@Override
	public void setSystemType(String systemType) {
		model.setSystemType(systemType);
	}

	/**
	 * Sets the url title of this system entry.
	 *
	 * @param urlTitle the url title of this system entry
	 */
	@Override
	public void setUrlTitle(String urlTitle) {
		model.setUrlTitle(urlTitle);
	}

	/**
	 * Sets the user ID of this system entry.
	 *
	 * @param userId the user ID of this system entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this system entry.
	 *
	 * @param userName the user name of this system entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this system entry.
	 *
	 * @param userUuid the user uuid of this system entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this system entry.
	 *
	 * @param uuid the uuid of this system entry
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
	protected SystemEntryWrapper wrap(SystemEntry systemEntry) {
		return new SystemEntryWrapper(systemEntry);
	}

}