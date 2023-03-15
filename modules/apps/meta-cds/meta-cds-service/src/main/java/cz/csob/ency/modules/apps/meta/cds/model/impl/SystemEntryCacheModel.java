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

package cz.csob.ency.modules.apps.meta.cds.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import cz.csob.ency.modules.apps.meta.cds.model.SystemEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SystemEntry in entity cache.
 *
 * @author "Miroslav Čermák"
 * @generated
 */
public class SystemEntryCacheModel
	implements CacheModel<SystemEntry>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SystemEntryCacheModel)) {
			return false;
		}

		SystemEntryCacheModel systemEntryCacheModel =
			(SystemEntryCacheModel)object;

		if ((systemEntryId == systemEntryCacheModel.systemEntryId) &&
			(mvccVersion == systemEntryCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, systemEntryId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(71);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", systemEntryId=");
		sb.append(systemEntryId);
		sb.append(", systemCode=");
		sb.append(systemCode);
		sb.append(", systemName=");
		sb.append(systemName);
		sb.append(", systemTitle=");
		sb.append(systemTitle);
		sb.append(", systemType=");
		sb.append(systemType);
		sb.append(", description=");
		sb.append(description);
		sb.append(", stewardName=");
		sb.append(stewardName);
		sb.append(", stewardId=");
		sb.append(stewardId);
		sb.append(", stewardDepartment=");
		sb.append(stewardDepartment);
		sb.append(", businessOwnerName=");
		sb.append(businessOwnerName);
		sb.append(", businessOwnerId=");
		sb.append(businessOwnerId);
		sb.append(", contactPersonName=");
		sb.append(contactPersonName);
		sb.append(", contactPersonId=");
		sb.append(contactPersonId);
		sb.append(", sandboxName=");
		sb.append(sandboxName);
		sb.append(", gestorDepartmentId=");
		sb.append(gestorDepartmentId);
		sb.append(", gestorDepartmentName=");
		sb.append(gestorDepartmentName);
		sb.append(", role=");
		sb.append(role);
		sb.append(", snowAssetTagId=");
		sb.append(snowAssetTagId);
		sb.append(", snowAssetTagName=");
		sb.append(snowAssetTagName);
		sb.append(", isSlaSigned=");
		sb.append(isSlaSigned);
		sb.append(", isSelfBi=");
		sb.append(isSelfBi);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", urlTitle=");
		sb.append(urlTitle);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SystemEntry toEntityModel() {
		SystemEntryImpl systemEntryImpl = new SystemEntryImpl();

		systemEntryImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			systemEntryImpl.setUuid("");
		}
		else {
			systemEntryImpl.setUuid(uuid);
		}

		systemEntryImpl.setSystemEntryId(systemEntryId);
		systemEntryImpl.setSystemCode(systemCode);

		if (systemName == null) {
			systemEntryImpl.setSystemName("");
		}
		else {
			systemEntryImpl.setSystemName(systemName);
		}

		if (systemTitle == null) {
			systemEntryImpl.setSystemTitle("");
		}
		else {
			systemEntryImpl.setSystemTitle(systemTitle);
		}

		if (systemType == null) {
			systemEntryImpl.setSystemType("");
		}
		else {
			systemEntryImpl.setSystemType(systemType);
		}

		if (description == null) {
			systemEntryImpl.setDescription("");
		}
		else {
			systemEntryImpl.setDescription(description);
		}

		if (stewardName == null) {
			systemEntryImpl.setStewardName("");
		}
		else {
			systemEntryImpl.setStewardName(stewardName);
		}

		if (stewardId == null) {
			systemEntryImpl.setStewardId("");
		}
		else {
			systemEntryImpl.setStewardId(stewardId);
		}

		if (stewardDepartment == null) {
			systemEntryImpl.setStewardDepartment("");
		}
		else {
			systemEntryImpl.setStewardDepartment(stewardDepartment);
		}

		if (businessOwnerName == null) {
			systemEntryImpl.setBusinessOwnerName("");
		}
		else {
			systemEntryImpl.setBusinessOwnerName(businessOwnerName);
		}

		if (businessOwnerId == null) {
			systemEntryImpl.setBusinessOwnerId("");
		}
		else {
			systemEntryImpl.setBusinessOwnerId(businessOwnerId);
		}

		if (contactPersonName == null) {
			systemEntryImpl.setContactPersonName("");
		}
		else {
			systemEntryImpl.setContactPersonName(contactPersonName);
		}

		if (contactPersonId == null) {
			systemEntryImpl.setContactPersonId("");
		}
		else {
			systemEntryImpl.setContactPersonId(contactPersonId);
		}

		if (sandboxName == null) {
			systemEntryImpl.setSandboxName("");
		}
		else {
			systemEntryImpl.setSandboxName(sandboxName);
		}

		if (gestorDepartmentId == null) {
			systemEntryImpl.setGestorDepartmentId("");
		}
		else {
			systemEntryImpl.setGestorDepartmentId(gestorDepartmentId);
		}

		if (gestorDepartmentName == null) {
			systemEntryImpl.setGestorDepartmentName("");
		}
		else {
			systemEntryImpl.setGestorDepartmentName(gestorDepartmentName);
		}

		if (role == null) {
			systemEntryImpl.setRole("");
		}
		else {
			systemEntryImpl.setRole(role);
		}

		if (snowAssetTagId == null) {
			systemEntryImpl.setSnowAssetTagId("");
		}
		else {
			systemEntryImpl.setSnowAssetTagId(snowAssetTagId);
		}

		if (snowAssetTagName == null) {
			systemEntryImpl.setSnowAssetTagName("");
		}
		else {
			systemEntryImpl.setSnowAssetTagName(snowAssetTagName);
		}

		systemEntryImpl.setIsSlaSigned(isSlaSigned);
		systemEntryImpl.setIsSelfBi(isSelfBi);
		systemEntryImpl.setIsActive(isActive);
		systemEntryImpl.setGroupId(groupId);
		systemEntryImpl.setCompanyId(companyId);
		systemEntryImpl.setUserId(userId);

		if (userName == null) {
			systemEntryImpl.setUserName("");
		}
		else {
			systemEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			systemEntryImpl.setCreateDate(null);
		}
		else {
			systemEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			systemEntryImpl.setModifiedDate(null);
		}
		else {
			systemEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (urlTitle == null) {
			systemEntryImpl.setUrlTitle("");
		}
		else {
			systemEntryImpl.setUrlTitle(urlTitle);
		}

		systemEntryImpl.setStatus(status);
		systemEntryImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			systemEntryImpl.setStatusByUserName("");
		}
		else {
			systemEntryImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			systemEntryImpl.setStatusDate(null);
		}
		else {
			systemEntryImpl.setStatusDate(new Date(statusDate));
		}

		systemEntryImpl.resetOriginalValues();

		return systemEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		systemEntryId = objectInput.readLong();

		systemCode = objectInput.readLong();
		systemName = objectInput.readUTF();
		systemTitle = objectInput.readUTF();
		systemType = objectInput.readUTF();
		description = (String)objectInput.readObject();
		stewardName = objectInput.readUTF();
		stewardId = objectInput.readUTF();
		stewardDepartment = objectInput.readUTF();
		businessOwnerName = objectInput.readUTF();
		businessOwnerId = objectInput.readUTF();
		contactPersonName = objectInput.readUTF();
		contactPersonId = objectInput.readUTF();
		sandboxName = objectInput.readUTF();
		gestorDepartmentId = objectInput.readUTF();
		gestorDepartmentName = objectInput.readUTF();
		role = objectInput.readUTF();
		snowAssetTagId = objectInput.readUTF();
		snowAssetTagName = objectInput.readUTF();

		isSlaSigned = objectInput.readBoolean();

		isSelfBi = objectInput.readBoolean();

		isActive = objectInput.readBoolean();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		urlTitle = objectInput.readUTF();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(systemEntryId);

		objectOutput.writeLong(systemCode);

		if (systemName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(systemName);
		}

		if (systemTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(systemTitle);
		}

		if (systemType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(systemType);
		}

		if (description == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(description);
		}

		if (stewardName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stewardName);
		}

		if (stewardId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stewardId);
		}

		if (stewardDepartment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stewardDepartment);
		}

		if (businessOwnerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessOwnerName);
		}

		if (businessOwnerId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessOwnerId);
		}

		if (contactPersonName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactPersonName);
		}

		if (contactPersonId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactPersonId);
		}

		if (sandboxName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sandboxName);
		}

		if (gestorDepartmentId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gestorDepartmentId);
		}

		if (gestorDepartmentName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gestorDepartmentName);
		}

		if (role == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(role);
		}

		if (snowAssetTagId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(snowAssetTagId);
		}

		if (snowAssetTagName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(snowAssetTagName);
		}

		objectOutput.writeBoolean(isSlaSigned);

		objectOutput.writeBoolean(isSelfBi);

		objectOutput.writeBoolean(isActive);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (urlTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(urlTitle);
		}

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public long mvccVersion;
	public String uuid;
	public long systemEntryId;
	public long systemCode;
	public String systemName;
	public String systemTitle;
	public String systemType;
	public String description;
	public String stewardName;
	public String stewardId;
	public String stewardDepartment;
	public String businessOwnerName;
	public String businessOwnerId;
	public String contactPersonName;
	public String contactPersonId;
	public String sandboxName;
	public String gestorDepartmentId;
	public String gestorDepartmentName;
	public String role;
	public String snowAssetTagId;
	public String snowAssetTagName;
	public boolean isSlaSigned;
	public boolean isSelfBi;
	public boolean isActive;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String urlTitle;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}