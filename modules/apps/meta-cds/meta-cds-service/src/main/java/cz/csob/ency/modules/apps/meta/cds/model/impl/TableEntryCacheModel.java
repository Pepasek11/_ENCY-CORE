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

import cz.csob.ency.modules.apps.meta.cds.model.TableEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TableEntry in entity cache.
 *
 * @author "Miroslav Čermák"
 * @generated
 */
public class TableEntryCacheModel
	implements CacheModel<TableEntry>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TableEntryCacheModel)) {
			return false;
		}

		TableEntryCacheModel tableEntryCacheModel =
			(TableEntryCacheModel)object;

		if ((tableEntryId == tableEntryCacheModel.tableEntryId) &&
			(mvccVersion == tableEntryCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, tableEntryId);

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
		StringBundler sb = new StringBundler(57);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", tableEntryId=");
		sb.append(tableEntryId);
		sb.append(", tableName=");
		sb.append(tableName);
		sb.append(", tableFullName=");
		sb.append(tableFullName);
		sb.append(", tableType=");
		sb.append(tableType);
		sb.append(", tableDatabase=");
		sb.append(tableDatabase);
		sb.append(", systemEntryId=");
		sb.append(systemEntryId);
		sb.append(", systemName=");
		sb.append(systemName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", dsaUrl=");
		sb.append(dsaUrl);
		sb.append(", contactPersonName=");
		sb.append(contactPersonName);
		sb.append(", contactPersonId=");
		sb.append(contactPersonId);
		sb.append(", specificationOwnerName=");
		sb.append(specificationOwnerName);
		sb.append(", specificationOwnerId=");
		sb.append(specificationOwnerId);
		sb.append(", unstructuredClause=");
		sb.append(unstructuredClause);
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
	public TableEntry toEntityModel() {
		TableEntryImpl tableEntryImpl = new TableEntryImpl();

		tableEntryImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			tableEntryImpl.setUuid("");
		}
		else {
			tableEntryImpl.setUuid(uuid);
		}

		tableEntryImpl.setTableEntryId(tableEntryId);

		if (tableName == null) {
			tableEntryImpl.setTableName("");
		}
		else {
			tableEntryImpl.setTableName(tableName);
		}

		if (tableFullName == null) {
			tableEntryImpl.setTableFullName("");
		}
		else {
			tableEntryImpl.setTableFullName(tableFullName);
		}

		if (tableType == null) {
			tableEntryImpl.setTableType("");
		}
		else {
			tableEntryImpl.setTableType(tableType);
		}

		if (tableDatabase == null) {
			tableEntryImpl.setTableDatabase("");
		}
		else {
			tableEntryImpl.setTableDatabase(tableDatabase);
		}

		tableEntryImpl.setSystemEntryId(systemEntryId);

		if (systemName == null) {
			tableEntryImpl.setSystemName("");
		}
		else {
			tableEntryImpl.setSystemName(systemName);
		}

		if (description == null) {
			tableEntryImpl.setDescription("");
		}
		else {
			tableEntryImpl.setDescription(description);
		}

		if (dsaUrl == null) {
			tableEntryImpl.setDsaUrl("");
		}
		else {
			tableEntryImpl.setDsaUrl(dsaUrl);
		}

		if (contactPersonName == null) {
			tableEntryImpl.setContactPersonName("");
		}
		else {
			tableEntryImpl.setContactPersonName(contactPersonName);
		}

		if (contactPersonId == null) {
			tableEntryImpl.setContactPersonId("");
		}
		else {
			tableEntryImpl.setContactPersonId(contactPersonId);
		}

		if (specificationOwnerName == null) {
			tableEntryImpl.setSpecificationOwnerName("");
		}
		else {
			tableEntryImpl.setSpecificationOwnerName(specificationOwnerName);
		}

		if (specificationOwnerId == null) {
			tableEntryImpl.setSpecificationOwnerId("");
		}
		else {
			tableEntryImpl.setSpecificationOwnerId(specificationOwnerId);
		}

		if (unstructuredClause == null) {
			tableEntryImpl.setUnstructuredClause("");
		}
		else {
			tableEntryImpl.setUnstructuredClause(unstructuredClause);
		}

		tableEntryImpl.setIsActive(isActive);
		tableEntryImpl.setGroupId(groupId);
		tableEntryImpl.setCompanyId(companyId);
		tableEntryImpl.setUserId(userId);

		if (userName == null) {
			tableEntryImpl.setUserName("");
		}
		else {
			tableEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			tableEntryImpl.setCreateDate(null);
		}
		else {
			tableEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tableEntryImpl.setModifiedDate(null);
		}
		else {
			tableEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (urlTitle == null) {
			tableEntryImpl.setUrlTitle("");
		}
		else {
			tableEntryImpl.setUrlTitle(urlTitle);
		}

		tableEntryImpl.setStatus(status);
		tableEntryImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			tableEntryImpl.setStatusByUserName("");
		}
		else {
			tableEntryImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			tableEntryImpl.setStatusDate(null);
		}
		else {
			tableEntryImpl.setStatusDate(new Date(statusDate));
		}

		tableEntryImpl.resetOriginalValues();

		return tableEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		tableEntryId = objectInput.readLong();
		tableName = objectInput.readUTF();
		tableFullName = objectInput.readUTF();
		tableType = objectInput.readUTF();
		tableDatabase = objectInput.readUTF();

		systemEntryId = objectInput.readLong();
		systemName = objectInput.readUTF();
		description = (String)objectInput.readObject();
		dsaUrl = objectInput.readUTF();
		contactPersonName = objectInput.readUTF();
		contactPersonId = objectInput.readUTF();
		specificationOwnerName = objectInput.readUTF();
		specificationOwnerId = objectInput.readUTF();
		unstructuredClause = (String)objectInput.readObject();

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

		objectOutput.writeLong(tableEntryId);

		if (tableName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tableName);
		}

		if (tableFullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tableFullName);
		}

		if (tableType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tableType);
		}

		if (tableDatabase == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tableDatabase);
		}

		objectOutput.writeLong(systemEntryId);

		if (systemName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(systemName);
		}

		if (description == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(description);
		}

		if (dsaUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dsaUrl);
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

		if (specificationOwnerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(specificationOwnerName);
		}

		if (specificationOwnerId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(specificationOwnerId);
		}

		if (unstructuredClause == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(unstructuredClause);
		}

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
	public long tableEntryId;
	public String tableName;
	public String tableFullName;
	public String tableType;
	public String tableDatabase;
	public long systemEntryId;
	public String systemName;
	public String description;
	public String dsaUrl;
	public String contactPersonName;
	public String contactPersonId;
	public String specificationOwnerName;
	public String specificationOwnerId;
	public String unstructuredClause;
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