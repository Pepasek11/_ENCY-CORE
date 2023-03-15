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

package cz.csob.ency.delegations.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import cz.csob.ency.delegations.model.DelegatedRole;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DelegatedRole in entity cache.
 *
 * @author Miroslav Čermák
 * @generated
 */
public class DelegatedRoleCacheModel
	implements CacheModel<DelegatedRole>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DelegatedRoleCacheModel)) {
			return false;
		}

		DelegatedRoleCacheModel delegatedRoleCacheModel =
			(DelegatedRoleCacheModel)object;

		if ((roleId == delegatedRoleCacheModel.roleId) &&
			(mvccVersion == delegatedRoleCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, roleId);

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
		StringBundler sb = new StringBundler(23);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", roleId=");
		sb.append(roleId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", code=");
		sb.append(code);
		sb.append(", description=");
		sb.append(description);
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
	public DelegatedRole toEntityModel() {
		DelegatedRoleImpl delegatedRoleImpl = new DelegatedRoleImpl();

		delegatedRoleImpl.setMvccVersion(mvccVersion);
		delegatedRoleImpl.setRoleId(roleId);

		if (title == null) {
			delegatedRoleImpl.setTitle("");
		}
		else {
			delegatedRoleImpl.setTitle(title);
		}

		if (code == null) {
			delegatedRoleImpl.setCode("");
		}
		else {
			delegatedRoleImpl.setCode(code);
		}

		if (description == null) {
			delegatedRoleImpl.setDescription("");
		}
		else {
			delegatedRoleImpl.setDescription(description);
		}

		delegatedRoleImpl.setGroupId(groupId);
		delegatedRoleImpl.setCompanyId(companyId);
		delegatedRoleImpl.setUserId(userId);

		if (userName == null) {
			delegatedRoleImpl.setUserName("");
		}
		else {
			delegatedRoleImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			delegatedRoleImpl.setCreateDate(null);
		}
		else {
			delegatedRoleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			delegatedRoleImpl.setModifiedDate(null);
		}
		else {
			delegatedRoleImpl.setModifiedDate(new Date(modifiedDate));
		}

		delegatedRoleImpl.resetOriginalValues();

		return delegatedRoleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		roleId = objectInput.readLong();
		title = objectInput.readUTF();
		code = objectInput.readUTF();
		description = objectInput.readUTF();

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

		objectOutput.writeLong(roleId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
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
	}

	public long mvccVersion;
	public long roleId;
	public String title;
	public String code;
	public String description;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}