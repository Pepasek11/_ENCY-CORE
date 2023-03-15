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

import cz.csob.ency.pdr.model.PDRAttribute;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PDRAttribute in entity cache.
 *
 * @author Miroslav Čermák
 * @generated
 */
public class PDRAttributeCacheModel
	implements CacheModel<PDRAttribute>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PDRAttributeCacheModel)) {
			return false;
		}

		PDRAttributeCacheModel pdrAttributeCacheModel =
			(PDRAttributeCacheModel)object;

		if ((attributeId == pdrAttributeCacheModel.attributeId) &&
			(mvccVersion == pdrAttributeCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, attributeId);

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
		StringBundler sb = new StringBundler(53);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", attributeId=");
		sb.append(attributeId);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", nameCz=");
		sb.append(nameCz);
		sb.append(", nameEn=");
		sb.append(nameEn);
		sb.append(", nameSk=");
		sb.append(nameSk);
		sb.append(", order=");
		sb.append(order);
		sb.append(", level=");
		sb.append(level);
		sb.append(", idsPath=");
		sb.append(idsPath);
		sb.append(", description=");
		sb.append(description);
		sb.append(", personalDataTypeId=");
		sb.append(personalDataTypeId);
		sb.append(", tagName=");
		sb.append(tagName);
		sb.append(", isRoA=");
		sb.append(isRoA);
		sb.append(", isRtP=");
		sb.append(isRtP);
		sb.append(", separatorBefore=");
		sb.append(separatorBefore);
		sb.append(", separatorAfter=");
		sb.append(separatorAfter);
		sb.append(", isMerge=");
		sb.append(isMerge);
		sb.append(", isLabel=");
		sb.append(isLabel);
		sb.append(", isObject=");
		sb.append(isObject);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PDRAttribute toEntityModel() {
		PDRAttributeImpl pdrAttributeImpl = new PDRAttributeImpl();

		pdrAttributeImpl.setMvccVersion(mvccVersion);
		pdrAttributeImpl.setAttributeId(attributeId);

		if (fullName == null) {
			pdrAttributeImpl.setFullName("");
		}
		else {
			pdrAttributeImpl.setFullName(fullName);
		}

		pdrAttributeImpl.setParentId(parentId);

		if (nameCz == null) {
			pdrAttributeImpl.setNameCz("");
		}
		else {
			pdrAttributeImpl.setNameCz(nameCz);
		}

		if (nameEn == null) {
			pdrAttributeImpl.setNameEn("");
		}
		else {
			pdrAttributeImpl.setNameEn(nameEn);
		}

		if (nameSk == null) {
			pdrAttributeImpl.setNameSk("");
		}
		else {
			pdrAttributeImpl.setNameSk(nameSk);
		}

		pdrAttributeImpl.setOrder(order);
		pdrAttributeImpl.setLevel(level);

		if (idsPath == null) {
			pdrAttributeImpl.setIdsPath("");
		}
		else {
			pdrAttributeImpl.setIdsPath(idsPath);
		}

		if (description == null) {
			pdrAttributeImpl.setDescription("");
		}
		else {
			pdrAttributeImpl.setDescription(description);
		}

		pdrAttributeImpl.setPersonalDataTypeId(personalDataTypeId);

		if (tagName == null) {
			pdrAttributeImpl.setTagName("");
		}
		else {
			pdrAttributeImpl.setTagName(tagName);
		}

		pdrAttributeImpl.setIsRoA(isRoA);
		pdrAttributeImpl.setIsRtP(isRtP);

		if (separatorBefore == null) {
			pdrAttributeImpl.setSeparatorBefore("");
		}
		else {
			pdrAttributeImpl.setSeparatorBefore(separatorBefore);
		}

		if (separatorAfter == null) {
			pdrAttributeImpl.setSeparatorAfter("");
		}
		else {
			pdrAttributeImpl.setSeparatorAfter(separatorAfter);
		}

		pdrAttributeImpl.setIsMerge(isMerge);
		pdrAttributeImpl.setIsLabel(isLabel);
		pdrAttributeImpl.setIsObject(isObject);
		pdrAttributeImpl.setGroupId(groupId);
		pdrAttributeImpl.setCompanyId(companyId);
		pdrAttributeImpl.setUserId(userId);

		if (userName == null) {
			pdrAttributeImpl.setUserName("");
		}
		else {
			pdrAttributeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			pdrAttributeImpl.setCreateDate(null);
		}
		else {
			pdrAttributeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			pdrAttributeImpl.setModifiedDate(null);
		}
		else {
			pdrAttributeImpl.setModifiedDate(new Date(modifiedDate));
		}

		pdrAttributeImpl.resetOriginalValues();

		return pdrAttributeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		attributeId = objectInput.readLong();
		fullName = objectInput.readUTF();

		parentId = objectInput.readLong();
		nameCz = objectInput.readUTF();
		nameEn = objectInput.readUTF();
		nameSk = objectInput.readUTF();

		order = objectInput.readInt();

		level = objectInput.readInt();
		idsPath = objectInput.readUTF();
		description = objectInput.readUTF();

		personalDataTypeId = objectInput.readLong();
		tagName = objectInput.readUTF();

		isRoA = objectInput.readBoolean();

		isRtP = objectInput.readBoolean();
		separatorBefore = objectInput.readUTF();
		separatorAfter = objectInput.readUTF();

		isMerge = objectInput.readBoolean();

		isLabel = objectInput.readBoolean();

		isObject = objectInput.readBoolean();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(attributeId);

		if (fullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		objectOutput.writeLong(parentId);

		if (nameCz == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nameCz);
		}

		if (nameEn == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nameEn);
		}

		if (nameSk == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nameSk);
		}

		objectOutput.writeInt(order);

		objectOutput.writeInt(level);

		if (idsPath == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idsPath);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(personalDataTypeId);

		if (tagName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tagName);
		}

		objectOutput.writeBoolean(isRoA);

		objectOutput.writeBoolean(isRtP);

		if (separatorBefore == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(separatorBefore);
		}

		if (separatorAfter == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(separatorAfter);
		}

		objectOutput.writeBoolean(isMerge);

		objectOutput.writeBoolean(isLabel);

		objectOutput.writeBoolean(isObject);

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
	}

	public long mvccVersion;
	public long attributeId;
	public String fullName;
	public long parentId;
	public String nameCz;
	public String nameEn;
	public String nameSk;
	public int order;
	public int level;
	public String idsPath;
	public String description;
	public long personalDataTypeId;
	public String tagName;
	public boolean isRoA;
	public boolean isRtP;
	public String separatorBefore;
	public String separatorAfter;
	public boolean isMerge;
	public boolean isLabel;
	public boolean isObject;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}