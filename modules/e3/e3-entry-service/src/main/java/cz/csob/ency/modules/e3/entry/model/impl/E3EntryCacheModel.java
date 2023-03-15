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
import com.liferay.portal.kernel.model.MVCCModel;

import cz.csob.ency.modules.e3.entry.model.E3Entry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

import java.util.Date;
import java.util.Map;

/**
 * The cache model class for representing E3Entry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class E3EntryCacheModel
	implements CacheModel<E3Entry>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof E3EntryCacheModel)) {
			return false;
		}

		E3EntryCacheModel e3EntryCacheModel = (E3EntryCacheModel)object;

		if ((entryId == e3EntryCacheModel.entryId) &&
			(mvccVersion == e3EntryCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, entryId);

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
		StringBundler sb = new StringBundler(39);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", headId=");
		sb.append(headId);
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
	public E3Entry toEntityModel() {
		E3EntryImpl e3EntryImpl = new E3EntryImpl();

		e3EntryImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			e3EntryImpl.setUuid("");
		}
		else {
			e3EntryImpl.setUuid(uuid);
		}

		e3EntryImpl.setHeadId(headId);
		e3EntryImpl.setHead(head);
		e3EntryImpl.setEntryId(entryId);
		e3EntryImpl.setGroupId(groupId);
		e3EntryImpl.setCompanyId(companyId);
		e3EntryImpl.setUserId(userId);

		if (userName == null) {
			e3EntryImpl.setUserName("");
		}
		else {
			e3EntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			e3EntryImpl.setCreateDate(null);
		}
		else {
			e3EntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			e3EntryImpl.setModifiedDate(null);
		}
		else {
			e3EntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		e3EntryImpl.setAuthorId(authorId);

		if (authorName == null) {
			e3EntryImpl.setAuthorName("");
		}
		else {
			e3EntryImpl.setAuthorName(authorName);
		}

		if (xid == null) {
			e3EntryImpl.setXid("");
		}
		else {
			e3EntryImpl.setXid(xid);
		}

		if (name == null) {
			e3EntryImpl.setName("");
		}
		else {
			e3EntryImpl.setName(name);
		}

		if (appClass == null) {
			e3EntryImpl.setAppClass("");
		}
		else {
			e3EntryImpl.setAppClass(appClass);
		}

		e3EntryImpl.setParentId(parentId);

		if (parentField == null) {
			e3EntryImpl.setParentField("");
		}
		else {
			e3EntryImpl.setParentField(parentField);
		}

		e3EntryImpl.setValues(values);
		e3EntryImpl.setStatus(status);

		e3EntryImpl.resetOriginalValues();

		return e3EntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		headId = objectInput.readLong();

		head = objectInput.readBoolean();

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
		objectOutput.writeLong(mvccVersion);

		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(headId);

		objectOutput.writeBoolean(head);

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

	public long mvccVersion;
	public String uuid;
	public long headId;
	public boolean head;
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