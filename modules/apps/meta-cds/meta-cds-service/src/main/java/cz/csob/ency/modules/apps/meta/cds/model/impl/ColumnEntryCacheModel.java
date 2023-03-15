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

import cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ColumnEntry in entity cache.
 *
 * @author "Miroslav Čermák"
 * @generated
 */
public class ColumnEntryCacheModel
	implements CacheModel<ColumnEntry>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ColumnEntryCacheModel)) {
			return false;
		}

		ColumnEntryCacheModel columnEntryCacheModel =
			(ColumnEntryCacheModel)object;

		if ((columnEntryId == columnEntryCacheModel.columnEntryId) &&
			(mvccVersion == columnEntryCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, columnEntryId);

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
		sb.append(", columnEntryId=");
		sb.append(columnEntryId);
		sb.append(", columnType=");
		sb.append(columnType);
		sb.append(", columnName=");
		sb.append(columnName);
		sb.append(", columnPosition=");
		sb.append(columnPosition);
		sb.append(", columnFullName=");
		sb.append(columnFullName);
		sb.append(", tableEntryId=");
		sb.append(tableEntryId);
		sb.append(", tableName=");
		sb.append(tableName);
		sb.append(", systemName=");
		sb.append(systemName);
		sb.append(", databaseName=");
		sb.append(databaseName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", dataType=");
		sb.append(dataType);
		sb.append(", dataSize=");
		sb.append(dataSize);
		sb.append(", isPrimaryKey=");
		sb.append(isPrimaryKey);
		sb.append(", isNotNull=");
		sb.append(isNotNull);
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
	public ColumnEntry toEntityModel() {
		ColumnEntryImpl columnEntryImpl = new ColumnEntryImpl();

		columnEntryImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			columnEntryImpl.setUuid("");
		}
		else {
			columnEntryImpl.setUuid(uuid);
		}

		columnEntryImpl.setColumnEntryId(columnEntryId);

		if (columnType == null) {
			columnEntryImpl.setColumnType("");
		}
		else {
			columnEntryImpl.setColumnType(columnType);
		}

		if (columnName == null) {
			columnEntryImpl.setColumnName("");
		}
		else {
			columnEntryImpl.setColumnName(columnName);
		}

		columnEntryImpl.setColumnPosition(columnPosition);

		if (columnFullName == null) {
			columnEntryImpl.setColumnFullName("");
		}
		else {
			columnEntryImpl.setColumnFullName(columnFullName);
		}

		columnEntryImpl.setTableEntryId(tableEntryId);

		if (tableName == null) {
			columnEntryImpl.setTableName("");
		}
		else {
			columnEntryImpl.setTableName(tableName);
		}

		if (systemName == null) {
			columnEntryImpl.setSystemName("");
		}
		else {
			columnEntryImpl.setSystemName(systemName);
		}

		if (databaseName == null) {
			columnEntryImpl.setDatabaseName("");
		}
		else {
			columnEntryImpl.setDatabaseName(databaseName);
		}

		if (description == null) {
			columnEntryImpl.setDescription("");
		}
		else {
			columnEntryImpl.setDescription(description);
		}

		if (dataType == null) {
			columnEntryImpl.setDataType("");
		}
		else {
			columnEntryImpl.setDataType(dataType);
		}

		columnEntryImpl.setDataSize(dataSize);
		columnEntryImpl.setIsPrimaryKey(isPrimaryKey);
		columnEntryImpl.setIsNotNull(isNotNull);
		columnEntryImpl.setIsActive(isActive);
		columnEntryImpl.setGroupId(groupId);
		columnEntryImpl.setCompanyId(companyId);
		columnEntryImpl.setUserId(userId);

		if (userName == null) {
			columnEntryImpl.setUserName("");
		}
		else {
			columnEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			columnEntryImpl.setCreateDate(null);
		}
		else {
			columnEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			columnEntryImpl.setModifiedDate(null);
		}
		else {
			columnEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (urlTitle == null) {
			columnEntryImpl.setUrlTitle("");
		}
		else {
			columnEntryImpl.setUrlTitle(urlTitle);
		}

		columnEntryImpl.setStatus(status);
		columnEntryImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			columnEntryImpl.setStatusByUserName("");
		}
		else {
			columnEntryImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			columnEntryImpl.setStatusDate(null);
		}
		else {
			columnEntryImpl.setStatusDate(new Date(statusDate));
		}

		columnEntryImpl.resetOriginalValues();

		return columnEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		columnEntryId = objectInput.readLong();
		columnType = objectInput.readUTF();
		columnName = objectInput.readUTF();

		columnPosition = objectInput.readLong();
		columnFullName = objectInput.readUTF();

		tableEntryId = objectInput.readLong();
		tableName = objectInput.readUTF();
		systemName = objectInput.readUTF();
		databaseName = objectInput.readUTF();
		description = (String)objectInput.readObject();
		dataType = objectInput.readUTF();

		dataSize = objectInput.readLong();

		isPrimaryKey = objectInput.readBoolean();

		isNotNull = objectInput.readBoolean();

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

		objectOutput.writeLong(columnEntryId);

		if (columnType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(columnType);
		}

		if (columnName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(columnName);
		}

		objectOutput.writeLong(columnPosition);

		if (columnFullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(columnFullName);
		}

		objectOutput.writeLong(tableEntryId);

		if (tableName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tableName);
		}

		if (systemName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(systemName);
		}

		if (databaseName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(databaseName);
		}

		if (description == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(description);
		}

		if (dataType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataType);
		}

		objectOutput.writeLong(dataSize);

		objectOutput.writeBoolean(isPrimaryKey);

		objectOutput.writeBoolean(isNotNull);

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
	public long columnEntryId;
	public String columnType;
	public String columnName;
	public long columnPosition;
	public String columnFullName;
	public long tableEntryId;
	public String tableName;
	public String systemName;
	public String databaseName;
	public String description;
	public String dataType;
	public long dataSize;
	public boolean isPrimaryKey;
	public boolean isNotNull;
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