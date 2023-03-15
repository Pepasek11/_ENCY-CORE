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

import cz.csob.ency.delegations.model.Delegation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Delegation in entity cache.
 *
 * @author Miroslav Čermák
 * @generated
 */
public class DelegationCacheModel
	implements CacheModel<Delegation>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DelegationCacheModel)) {
			return false;
		}

		DelegationCacheModel delegationCacheModel =
			(DelegationCacheModel)object;

		if ((delegationId == delegationCacheModel.delegationId) &&
			(mvccVersion == delegationCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, delegationId);

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
		StringBundler sb = new StringBundler(25);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", delegationId=");
		sb.append(delegationId);
		sb.append(", roleId=");
		sb.append(roleId);
		sb.append(", delegatingUserId=");
		sb.append(delegatingUserId);
		sb.append(", delegatedUserId=");
		sb.append(delegatedUserId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", note=");
		sb.append(note);
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
	public Delegation toEntityModel() {
		DelegationImpl delegationImpl = new DelegationImpl();

		delegationImpl.setMvccVersion(mvccVersion);
		delegationImpl.setDelegationId(delegationId);
		delegationImpl.setRoleId(roleId);
		delegationImpl.setDelegatingUserId(delegatingUserId);
		delegationImpl.setDelegatedUserId(delegatedUserId);
		delegationImpl.setGroupId(groupId);

		if (note == null) {
			delegationImpl.setNote("");
		}
		else {
			delegationImpl.setNote(note);
		}

		delegationImpl.setCompanyId(companyId);
		delegationImpl.setUserId(userId);

		if (userName == null) {
			delegationImpl.setUserName("");
		}
		else {
			delegationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			delegationImpl.setCreateDate(null);
		}
		else {
			delegationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			delegationImpl.setModifiedDate(null);
		}
		else {
			delegationImpl.setModifiedDate(new Date(modifiedDate));
		}

		delegationImpl.resetOriginalValues();

		return delegationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		delegationId = objectInput.readLong();

		roleId = objectInput.readLong();

		delegatingUserId = objectInput.readLong();

		delegatedUserId = objectInput.readLong();

		groupId = objectInput.readLong();
		note = objectInput.readUTF();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(delegationId);

		objectOutput.writeLong(roleId);

		objectOutput.writeLong(delegatingUserId);

		objectOutput.writeLong(delegatedUserId);

		objectOutput.writeLong(groupId);

		if (note == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(note);
		}

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
	public long delegationId;
	public long roleId;
	public long delegatingUserId;
	public long delegatedUserId;
	public long groupId;
	public String note;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}