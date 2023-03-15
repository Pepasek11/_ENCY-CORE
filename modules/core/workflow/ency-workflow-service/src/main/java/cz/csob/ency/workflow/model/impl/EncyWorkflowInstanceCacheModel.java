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

import cz.csob.ency.workflow.model.EncyWorkflowInstance;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EncyWorkflowInstance in entity cache.
 *
 * @author Miroslav Čermák
 * @generated
 */
public class EncyWorkflowInstanceCacheModel
	implements CacheModel<EncyWorkflowInstance>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EncyWorkflowInstanceCacheModel)) {
			return false;
		}

		EncyWorkflowInstanceCacheModel encyWorkflowInstanceCacheModel =
			(EncyWorkflowInstanceCacheModel)object;

		if (workflowInstanceId ==
				encyWorkflowInstanceCacheModel.workflowInstanceId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, workflowInstanceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", workflowInstanceId=");
		sb.append(workflowInstanceId);
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
		sb.append(", workflowId=");
		sb.append(workflowId);
		sb.append(", workflowVersion=");
		sb.append(workflowVersion);
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", workflowContext=");
		sb.append(workflowContext);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EncyWorkflowInstance toEntityModel() {
		EncyWorkflowInstanceImpl encyWorkflowInstanceImpl =
			new EncyWorkflowInstanceImpl();

		if (uuid == null) {
			encyWorkflowInstanceImpl.setUuid("");
		}
		else {
			encyWorkflowInstanceImpl.setUuid(uuid);
		}

		encyWorkflowInstanceImpl.setWorkflowInstanceId(workflowInstanceId);
		encyWorkflowInstanceImpl.setGroupId(groupId);
		encyWorkflowInstanceImpl.setCompanyId(companyId);
		encyWorkflowInstanceImpl.setUserId(userId);

		if (userName == null) {
			encyWorkflowInstanceImpl.setUserName("");
		}
		else {
			encyWorkflowInstanceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			encyWorkflowInstanceImpl.setCreateDate(null);
		}
		else {
			encyWorkflowInstanceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			encyWorkflowInstanceImpl.setModifiedDate(null);
		}
		else {
			encyWorkflowInstanceImpl.setModifiedDate(new Date(modifiedDate));
		}

		encyWorkflowInstanceImpl.setWorkflowId(workflowId);
		encyWorkflowInstanceImpl.setWorkflowVersion(workflowVersion);

		if (className == null) {
			encyWorkflowInstanceImpl.setClassName("");
		}
		else {
			encyWorkflowInstanceImpl.setClassName(className);
		}

		encyWorkflowInstanceImpl.setClassPK(classPK);

		if (workflowContext == null) {
			encyWorkflowInstanceImpl.setWorkflowContext("");
		}
		else {
			encyWorkflowInstanceImpl.setWorkflowContext(workflowContext);
		}

		encyWorkflowInstanceImpl.resetOriginalValues();

		return encyWorkflowInstanceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		workflowInstanceId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		workflowId = objectInput.readLong();

		workflowVersion = objectInput.readLong();
		className = objectInput.readUTF();

		classPK = objectInput.readLong();
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

		objectOutput.writeLong(workflowInstanceId);

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

		objectOutput.writeLong(workflowId);

		objectOutput.writeLong(workflowVersion);

		if (className == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(className);
		}

		objectOutput.writeLong(classPK);

		if (workflowContext == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(workflowContext);
		}
	}

	public String uuid;
	public long workflowInstanceId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long workflowId;
	public long workflowVersion;
	public String className;
	public long classPK;
	public String workflowContext;

}