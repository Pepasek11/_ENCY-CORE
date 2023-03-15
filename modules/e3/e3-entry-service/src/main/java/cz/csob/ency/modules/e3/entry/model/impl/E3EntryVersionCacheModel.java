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

package cz.csob.ency.modules.e3.entry.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import cz.csob.ency.modules.e3.entry.model.E3EntryVersion;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

import java.util.Date;
import java.util.Map;

/**
 * The cache model class for representing E3EntryVersion in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class E3EntryVersionCacheModel
	implements CacheModel<E3EntryVersion>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof E3EntryVersionCacheModel)) {
			return false;
		}

		E3EntryVersionCacheModel e3EntryVersionCacheModel =
			(E3EntryVersionCacheModel)object;

		if (e3EntryVersionId == e3EntryVersionCacheModel.e3EntryVersionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, e3EntryVersionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{e3EntryVersionId=");
		sb.append(e3EntryVersionId);
		sb.append(", version=");
		sb.append(version);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", entryId=");
		sb.append(entryId);
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
		sb.append(", authorId=");
		sb.append(authorId);
		sb.append(", authorName=");
		sb.append(authorName);
		sb.append(", xid=");
		sb.append(xid);
		sb.append(", name=");
		sb.append(name);
		sb.append(", appClass=");
		sb.append(appClass);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", parentField=");
		sb.append(parentField);
		sb.append(", values=");
		sb.append(values);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public E3EntryVersion toEntityModel() {
		E3EntryVersionImpl e3EntryVersionImpl = new E3EntryVersionImpl();

		e3EntryVersionImpl.setE3EntryVersionId(e3EntryVersionId);
		e3EntryVersionImpl.setVersion(version);

		if (uuid == null) {
			e3EntryVersionImpl.setUuid("");
		}
		else {
			e3EntryVersionImpl.setUuid(uuid);
		}

		e3EntryVersionImpl.setEntryId(entryId);
		e3EntryVersionImpl.setGroupId(groupId);
		e3EntryVersionImpl.setCompanyId(companyId);
		e3EntryVersionImpl.setUserId(userId);

		if (userName == null) {
			e3EntryVersionImpl.setUserName("");
		}
		else {
			e3EntryVersionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			e3EntryVersionImpl.setCreateDate(null);
		}
		else {
			e3EntryVersionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			e3EntryVersionImpl.setModifiedDate(null);
		}
		else {
			e3EntryVersionImpl.setModifiedDate(new Date(modifiedDate));
		}

		e3EntryVersionImpl.setAuthorId(authorId);

		if (authorName == null) {
			e3EntryVersionImpl.setAuthorName("");
		}
		else {
			e3EntryVersionImpl.setAuthorName(authorName);
		}

		if (xid == null) {
			e3EntryVersionImpl.setXid("");
		}
		else {
			e3EntryVersionImpl.setXid(xid);
		}

		if (name == null) {
			e3EntryVersionImpl.setName("");
		}
		else {
			e3EntryVersionImpl.setName(name);
		}

		if (appClass == null) {
			e3EntryVersionImpl.setAppClass("");
		}
		else {
			e3EntryVersionImpl.setAppClass(appClass);
		}

		e3EntryVersionImpl.setParentId(parentId);

		if (parentField == null) {
			e3EntryVersionImpl.setParentField("");
		}
		else {
			e3EntryVersionImpl.setParentField(parentField);
		}

		e3EntryVersionImpl.setValues(values);
		e3EntryVersionImpl.setStatus(status);

		e3EntryVersionImpl.resetOriginalValues();

		return e3EntryVersionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		e3EntryVersionId = objectInput.readLong();

		version = objectInput.readInt();
		uuid = objectInput.readUTF();

		entryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		authorId = objectInput.readLong();
		authorName = objectInput.readUTF();
		xid = objectInput.readUTF();
		name = objectInput.readUTF();
		appClass = objectInput.readUTF();

		parentId = objectInput.readLong();
		parentField = objectInput.readUTF();
		values = (Map<String, Serializable>)objectInput.readObject();

		status = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(e3EntryVersionId);

		objectOutput.writeInt(version);

		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(entryId);

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

		objectOutput.writeLong(authorId);

		if (authorName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(authorName);
		}

		if (xid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(xid);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (appClass == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(appClass);
		}

		objectOutput.writeLong(parentId);

		if (parentField == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(parentField);
		}

		objectOutput.writeObject(values);

		objectOutput.writeLong(status);
	}

	public long e3EntryVersionId;
	public int version;
	public String uuid;
	public long entryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long authorId;
	public String authorName;
	public String xid;
	public String name;
	public String appClass;
	public long parentId;
	public String parentField;
	public Map<String, Serializable> values;
	public long status;

}