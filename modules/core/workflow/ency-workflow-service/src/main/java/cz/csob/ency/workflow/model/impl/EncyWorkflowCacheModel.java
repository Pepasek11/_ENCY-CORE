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

import cz.csob.ency.workflow.model.EncyWorkflow;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EncyWorkflow in entity cache.
 *
 * @author Miroslav Čermák
 * @generated
 */
public class EncyWorkflowCacheModel
	implements CacheModel<EncyWorkflow>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EncyWorkflowCacheModel)) {
			return false;
		}

		EncyWorkflowCacheModel encyWorkflowCacheModel =
			(EncyWorkflowCacheModel)object;

		if (workflowId == encyWorkflowCacheModel.workflowId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, workflowId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", workflowId=");
		sb.append(workflowId);
		sb.append(", className=");
		sb.append(className);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", initialStateName=");
		sb.append(initialStateName);
		sb.append(", version=");
		sb.append(version);
		sb.append(", active=");
		sb.append(active);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EncyWorkflow toEntityModel() {
		EncyWorkflowImpl encyWorkflowImpl = new EncyWorkflowImpl();

		if (uuid == null) {
			encyWorkflowImpl.setUuid("");
		}
		else {
			encyWorkflowImpl.setUuid(uuid);
		}

		encyWorkflowImpl.setWorkflowId(workflowId);

		if (className == null) {
			encyWorkflowImpl.setClassName("");
		}
		else {
			encyWorkflowImpl.setClassName(className);
		}

		if (title == null) {
			encyWorkflowImpl.setTitle("");
		}
		else {
			encyWorkflowImpl.setTitle(title);
		}

		if (description == null) {
			encyWorkflowImpl.setDescription("");
		}
		else {
			encyWorkflowImpl.setDescription(description);
		}

		if (initialStateName == null) {
			encyWorkflowImpl.setInitialStateName("");
		}
		else {
			encyWorkflowImpl.setInitialStateName(initialStateName);
		}

		encyWorkflowImpl.setVersion(version);
		encyWorkflowImpl.setActive(active);

		if (createDate == Long.MIN_VALUE) {
			encyWorkflowImpl.setCreateDate(null);
		}
		else {
			encyWorkflowImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			encyWorkflowImpl.setModifiedDate(null);
		}
		else {
			encyWorkflowImpl.setModifiedDate(new Date(modifiedDate));
		}

		encyWorkflowImpl.resetOriginalValues();

		return encyWorkflowImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		workflowId = objectInput.readLong();
		className = objectInput.readUTF();
		title = objectInput.readUTF();
		description = (String)objectInput.readObject();
		initialStateName = objectInput.readUTF();

		version = objectInput.readLong();

		active = objectInput.readBoolean();
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

		objectOutput.writeLong(workflowId);

		if (className == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(className);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(description);
		}

		if (initialStateName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(initialStateName);
		}

		objectOutput.writeLong(version);

		objectOutput.writeBoolean(active);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long workflowId;
	public String className;
	public String title;
	public String description;
	public String initialStateName;
	public long version;
	public boolean active;
	public long createDate;
	public long modifiedDate;

}