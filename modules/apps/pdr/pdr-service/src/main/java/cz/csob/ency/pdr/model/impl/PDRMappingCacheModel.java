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

package cz.csob.ency.pdr.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import cz.csob.ency.pdr.model.PDRMapping;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PDRMapping in entity cache.
 *
 * @author Miroslav Čermák
 * @generated
 */
public class PDRMappingCacheModel
	implements CacheModel<PDRMapping>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PDRMappingCacheModel)) {
			return false;
		}

		PDRMappingCacheModel pdrMappingCacheModel =
			(PDRMappingCacheModel)object;

		if ((mappingId == pdrMappingCacheModel.mappingId) &&
			(mvccVersion == pdrMappingCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, mappingId);

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
		StringBundler sb = new StringBundler(37);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", mappingId=");
		sb.append(mappingId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", systemId=");
		sb.append(systemId);
		sb.append(", tableId=");
		sb.append(tableId);
		sb.append(", columnId=");
		sb.append(columnId);
		sb.append(", attributeId=");
		sb.append(attributeId);
		sb.append(", mappingRules=");
		sb.append(mappingRules);
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
		sb.append(", state=");
		sb.append(state);
		sb.append(", stateByUserId=");
		sb.append(stateByUserId);
		sb.append(", stateByUserName=");
		sb.append(stateByUserName);
		sb.append(", stateDate=");
		sb.append(stateDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PDRMapping toEntityModel() {
		PDRMappingImpl pdrMappingImpl = new PDRMappingImpl();

		pdrMappingImpl.setMvccVersion(mvccVersion);
		pdrMappingImpl.setMappingId(mappingId);

		if (title == null) {
			pdrMappingImpl.setTitle("");
		}
		else {
			pdrMappingImpl.setTitle(title);
		}

		pdrMappingImpl.setSystemId(systemId);
		pdrMappingImpl.setTableId(tableId);
		pdrMappingImpl.setColumnId(columnId);
		pdrMappingImpl.setAttributeId(attributeId);

		if (mappingRules == null) {
			pdrMappingImpl.setMappingRules("");
		}
		else {
			pdrMappingImpl.setMappingRules(mappingRules);
		}

		pdrMappingImpl.setGroupId(groupId);
		pdrMappingImpl.setCompanyId(companyId);
		pdrMappingImpl.setUserId(userId);

		if (userName == null) {
			pdrMappingImpl.setUserName("");
		}
		else {
			pdrMappingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			pdrMappingImpl.setCreateDate(null);
		}
		else {
			pdrMappingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			pdrMappingImpl.setModifiedDate(null);
		}
		else {
			pdrMappingImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (state == null) {
			pdrMappingImpl.setState("");
		}
		else {
			pdrMappingImpl.setState(state);
		}

		pdrMappingImpl.setStateByUserId(stateByUserId);

		if (stateByUserName == null) {
			pdrMappingImpl.setStateByUserName("");
		}
		else {
			pdrMappingImpl.setStateByUserName(stateByUserName);
		}

		if (stateDate == Long.MIN_VALUE) {
			pdrMappingImpl.setStateDate(null);
		}
		else {
			pdrMappingImpl.setStateDate(new Date(stateDate));
		}

		pdrMappingImpl.resetOriginalValues();

		return pdrMappingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		mappingId = objectInput.readLong();
		title = objectInput.readUTF();

		systemId = objectInput.readLong();

		tableId = objectInput.readLong();

		columnId = objectInput.readLong();

		attributeId = objectInput.readLong();
		mappingRules = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		state = objectInput.readUTF();

		stateByUserId = objectInput.readLong();
		stateByUserName = objectInput.readUTF();
		stateDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(mappingId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeLong(systemId);

		objectOutput.writeLong(tableId);

		objectOutput.writeLong(columnId);

		objectOutput.writeLong(attributeId);

		if (mappingRules == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mappingRules);
		}

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

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		objectOutput.writeLong(stateByUserId);

		if (stateByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stateByUserName);
		}

		objectOutput.writeLong(stateDate);
	}

	public long mvccVersion;
	public long mappingId;
	public String title;
	public long systemId;
	public long tableId;
	public long columnId;
	public long attributeId;
	public String mappingRules;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String state;
	public long stateByUserId;
	public String stateByUserName;
	public long stateDate;

}