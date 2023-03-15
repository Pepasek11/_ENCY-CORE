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

package cz.csob.ency.cds.demands.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import cz.csob.ency.cds.demands.model.CdsDemandGdprInfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CdsDemandGdprInfo in entity cache.
 *
 * @author Miroslav Čermák
 * @generated
 */
public class CdsDemandGdprInfoCacheModel
	implements CacheModel<CdsDemandGdprInfo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CdsDemandGdprInfoCacheModel)) {
			return false;
		}

		CdsDemandGdprInfoCacheModel cdsDemandGdprInfoCacheModel =
			(CdsDemandGdprInfoCacheModel)object;

		if (gdprInfoId == cdsDemandGdprInfoCacheModel.gdprInfoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, gdprInfoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", gdprInfoId=");
		sb.append(gdprInfoId);
		sb.append(", demandId=");
		sb.append(demandId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", isEmployee=");
		sb.append(isEmployee);
		sb.append(", employeeCategory=");
		sb.append(employeeCategory);
		sb.append(", employeeReasoning=");
		sb.append(employeeReasoning);
		sb.append(", isClient=");
		sb.append(isClient);
		sb.append(", clientCategory=");
		sb.append(clientCategory);
		sb.append(", clientReasoning=");
		sb.append(clientReasoning);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CdsDemandGdprInfo toEntityModel() {
		CdsDemandGdprInfoImpl cdsDemandGdprInfoImpl =
			new CdsDemandGdprInfoImpl();

		if (uuid == null) {
			cdsDemandGdprInfoImpl.setUuid("");
		}
		else {
			cdsDemandGdprInfoImpl.setUuid(uuid);
		}

		cdsDemandGdprInfoImpl.setGdprInfoId(gdprInfoId);
		cdsDemandGdprInfoImpl.setDemandId(demandId);

		if (title == null) {
			cdsDemandGdprInfoImpl.setTitle("");
		}
		else {
			cdsDemandGdprInfoImpl.setTitle(title);
		}

		if (description == null) {
			cdsDemandGdprInfoImpl.setDescription("");
		}
		else {
			cdsDemandGdprInfoImpl.setDescription(description);
		}

		cdsDemandGdprInfoImpl.setIsEmployee(isEmployee);

		if (employeeCategory == null) {
			cdsDemandGdprInfoImpl.setEmployeeCategory("");
		}
		else {
			cdsDemandGdprInfoImpl.setEmployeeCategory(employeeCategory);
		}

		if (employeeReasoning == null) {
			cdsDemandGdprInfoImpl.setEmployeeReasoning("");
		}
		else {
			cdsDemandGdprInfoImpl.setEmployeeReasoning(employeeReasoning);
		}

		cdsDemandGdprInfoImpl.setIsClient(isClient);

		if (clientCategory == null) {
			cdsDemandGdprInfoImpl.setClientCategory("");
		}
		else {
			cdsDemandGdprInfoImpl.setClientCategory(clientCategory);
		}

		if (clientReasoning == null) {
			cdsDemandGdprInfoImpl.setClientReasoning("");
		}
		else {
			cdsDemandGdprInfoImpl.setClientReasoning(clientReasoning);
		}

		cdsDemandGdprInfoImpl.setUserId(userId);

		if (userName == null) {
			cdsDemandGdprInfoImpl.setUserName("");
		}
		else {
			cdsDemandGdprInfoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			cdsDemandGdprInfoImpl.setCreateDate(null);
		}
		else {
			cdsDemandGdprInfoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cdsDemandGdprInfoImpl.setModifiedDate(null);
		}
		else {
			cdsDemandGdprInfoImpl.setModifiedDate(new Date(modifiedDate));
		}

		cdsDemandGdprInfoImpl.resetOriginalValues();

		return cdsDemandGdprInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		gdprInfoId = objectInput.readLong();

		demandId = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();

		isEmployee = objectInput.readBoolean();
		employeeCategory = objectInput.readUTF();
		employeeReasoning = objectInput.readUTF();

		isClient = objectInput.readBoolean();
		clientCategory = objectInput.readUTF();
		clientReasoning = objectInput.readUTF();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(gdprInfoId);

		objectOutput.writeLong(demandId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeBoolean(isEmployee);

		if (employeeCategory == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(employeeCategory);
		}

		if (employeeReasoning == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(employeeReasoning);
		}

		objectOutput.writeBoolean(isClient);

		if (clientCategory == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(clientCategory);
		}

		if (clientReasoning == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(clientReasoning);
		}

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long gdprInfoId;
	public long demandId;
	public String title;
	public String description;
	public boolean isEmployee;
	public String employeeCategory;
	public String employeeReasoning;
	public boolean isClient;
	public String clientCategory;
	public String clientReasoning;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}