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

import cz.csob.ency.workflow.model.EncyWorkflowTransitionInstance;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EncyWorkflowTransitionInstance in entity cache.
 *
 * @author Miroslav Čermák
 * @generated
 */
public class EncyWorkflowTransitionInstanceCacheModel
	implements CacheModel<EncyWorkflowTransitionInstance>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EncyWorkflowTransitionInstanceCacheModel)) {
			return false;
		}

		EncyWorkflowTransitionInstanceCacheModel
			encyWorkflowTransitionInstanceCacheModel =
				(EncyWorkflowTransitionInstanceCacheModel)object;

		if (transitionInstanceId ==
				encyWorkflowTransitionInstanceCacheModel.transitionInstanceId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, transitionInstanceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", transitionInstanceId=");
		sb.append(transitionInstanceId);
		sb.append(", transitionId=");
		sb.append(transitionId);
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append(", stateInstanceId=");
		sb.append(stateInstanceId);
		sb.append(", workflowId=");
		sb.append(workflowId);
		sb.append(", workflowInstanceId=");
		sb.append(workflowInstanceId);
		sb.append(", version=");
		sb.append(version);
		sb.append(", comment=");
		sb.append(comment);
		sb.append(", targetStateId=");
		sb.append(targetStateId);
		sb.append(", targetStateInstanceId=");
		sb.append(targetStateInstanceId);
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
		sb.append(", workflowContext=");
		sb.append(workflowContext);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EncyWorkflowTransitionInstance toEntityModel() {
		EncyWorkflowTransitionInstanceImpl encyWorkflowTransitionInstanceImpl =
			new EncyWorkflowTransitionInstanceImpl();

		if (uuid == null) {
			encyWorkflowTransitionInstanceImpl.setUuid("");
		}
		else {
			encyWorkflowTransitionInstanceImpl.setUuid(uuid);
		}

		encyWorkflowTransitionInstanceImpl.setTransitionInstanceId(
			transitionInstanceId);
		encyWorkflowTransitionInstanceImpl.setTransitionId(transitionId);
		encyWorkflowTransitionInstanceImpl.setStateId(stateId);
		encyWorkflowTransitionInstanceImpl.setStateInstanceId(stateInstanceId);
		encyWorkflowTransitionInstanceImpl.setWorkflowId(workflowId);
		encyWorkflowTransitionInstanceImpl.setWorkflowInstanceId(
			workflowInstanceId);
		encyWorkflowTransitionInstanceImpl.setVersion(version);

		if (comment == null) {
			encyWorkflowTransitionInstanceImpl.setComment("");
		}
		else {
			encyWorkflowTransitionInstanceImpl.setComment(comment);
		}

		encyWorkflowTransitionInstanceImpl.setTargetStateId(targetStateId);
		encyWorkflowTransitionInstanceImpl.setTargetStateInstanceId(
			targetStateInstanceId);
		encyWorkflowTransitionInstanceImpl.setGroupId(groupId);
		encyWorkflowTransitionInstanceImpl.setCompanyId(companyId);
		encyWorkflowTransitionInstanceImpl.setUserId(userId);

		if (userName == null) {
			encyWorkflowTransitionInstanceImpl.setUserName("");
		}
		else {
			encyWorkflowTransitionInstanceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			encyWorkflowTransitionInstanceImpl.setCreateDate(null);
		}
		else {
			encyWorkflowTransitionInstanceImpl.setCreateDate(
				new Date(createDate));
		}

		if (workflowContext == null) {
			encyWorkflowTransitionInstanceImpl.setWorkflowContext("");
		}
		else {
			encyWorkflowTransitionInstanceImpl.setWorkflowContext(
				workflowContext);
		}

		encyWorkflowTransitionInstanceImpl.resetOriginalValues();

		return encyWorkflowTransitionInstanceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		transitionInstanceId = objectInput.readLong();

		transitionId = objectInput.readLong();

		stateId = objectInput.readLong();

		stateInstanceId = objectInput.readLong();

		workflowId = objectInput.readLong();

		workflowInstanceId = objectInput.readLong();

		version = objectInput.readLong();
		comment = objectInput.readUTF();

		targetStateId = objectInput.readLong();

		targetStateInstanceId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
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

		objectOutput.writeLong(transitionInstanceId);

		objectOutput.writeLong(transitionId);

		objectOutput.writeLong(stateId);

		objectOutput.writeLong(stateInstanceId);

		objectOutput.writeLong(workflowId);

		objectOutput.writeLong(workflowInstanceId);

		objectOutput.writeLong(version);

		if (comment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comment);
		}

		objectOutput.writeLong(targetStateId);

		objectOutput.writeLong(targetStateInstanceId);

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

		if (workflowContext == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(workflowContext);
		}
	}

	public String uuid;
	public long transitionInstanceId;
	public long transitionId;
	public long stateId;
	public long stateInstanceId;
	public long workflowId;
	public long workflowInstanceId;
	public long version;
	public String comment;
	public long targetStateId;
	public long targetStateInstanceId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public String workflowContext;

}