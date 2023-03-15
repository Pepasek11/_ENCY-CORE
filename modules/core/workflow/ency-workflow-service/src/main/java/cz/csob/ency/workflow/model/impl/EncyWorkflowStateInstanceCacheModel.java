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

package cz.csob.ency.workflow.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import cz.csob.ency.workflow.model.EncyWorkflowStateInstance;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EncyWorkflowStateInstance in entity cache.
 *
 * @author Miroslav Čermák
 * @generated
 */
public class EncyWorkflowStateInstanceCacheModel
	implements CacheModel<EncyWorkflowStateInstance>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EncyWorkflowStateInstanceCacheModel)) {
			return false;
		}

		EncyWorkflowStateInstanceCacheModel
			encyWorkflowStateInstanceCacheModel =
				(EncyWorkflowStateInstanceCacheModel)object;

		if (stateInstanceId ==
				encyWorkflowStateInstanceCacheModel.stateInstanceId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stateInstanceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", stateInstanceId=");
		sb.append(stateInstanceId);
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append(", workflowId=");
		sb.append(workflowId);
		sb.append(", workflowInstanceId=");
		sb.append(workflowInstanceId);
		sb.append(", version=");
		sb.append(version);
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
		sb.append(", completedDate=");
		sb.append(completedDate);
		sb.append(", workflowContext=");
		sb.append(workflowContext);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EncyWorkflowStateInstance toEntityModel() {
		EncyWorkflowStateInstanceImpl encyWorkflowStateInstanceImpl =
			new EncyWorkflowStateInstanceImpl();

		if (uuid == null) {
			encyWorkflowStateInstanceImpl.setUuid("");
		}
		else {
			encyWorkflowStateInstanceImpl.setUuid(uuid);
		}

		encyWorkflowStateInstanceImpl.setStateInstanceId(stateInstanceId);
		encyWorkflowStateInstanceImpl.setStateId(stateId);
		encyWorkflowStateInstanceImpl.setWorkflowId(workflowId);
		encyWorkflowStateInstanceImpl.setWorkflowInstanceId(workflowInstanceId);
		encyWorkflowStateInstanceImpl.setVersion(version);
		encyWorkflowStateInstanceImpl.setGroupId(groupId);
		encyWorkflowStateInstanceImpl.setCompanyId(companyId);
		encyWorkflowStateInstanceImpl.setUserId(userId);

		if (userName == null) {
			encyWorkflowStateInstanceImpl.setUserName("");
		}
		else {
			encyWorkflowStateInstanceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			encyWorkflowStateInstanceImpl.setCreateDate(null);
		}
		else {
			encyWorkflowStateInstanceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			encyWorkflowStateInstanceImpl.setModifiedDate(null);
		}
		else {
			encyWorkflowStateInstanceImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		if (completedDate == Long.MIN_VALUE) {
			encyWorkflowStateInstanceImpl.setCompletedDate(null);
		}
		else {
			encyWorkflowStateInstanceImpl.setCompletedDate(
				new Date(completedDate));
		}

		if (workflowContext == null) {
			encyWorkflowStateInstanceImpl.setWorkflowContext("");
		}
		else {
			encyWorkflowStateInstanceImpl.setWorkflowContext(workflowContext);
		}

		encyWorkflowStateInstanceImpl.resetOriginalValues();

		return encyWorkflowStateInstanceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		stateInstanceId = objectInput.readLong();

		stateId = objectInput.readLong();

		workflowId = objectInput.readLong();

		workflowInstanceId = objectInput.readLong();

		version = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		completedDate = objectInput.readLong();
		workflowContext = (String)objectInput.readObject();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(stateInstanceId);

		objectOutput.writeLong(stateId);

		objectOutput.writeLong(workflowId);

		objectOutput.writeLong(workflowInstanceId);

		objectOutput.writeLong(version);

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
		objectOutput.writeLong(completedDate);

		if (workflowContext == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(workflowContext);
		}
	}

	public String uuid;
	public long stateInstanceId;
	public long stateId;
	public long workflowId;
	public long workflowInstanceId;
	public long version;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long completedDate;
	public String workflowContext;

}