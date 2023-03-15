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

import cz.csob.ency.workflow.model.EncyWorkflowTransition;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EncyWorkflowTransition in entity cache.
 *
 * @author Miroslav Čermák
 * @generated
 */
public class EncyWorkflowTransitionCacheModel
	implements CacheModel<EncyWorkflowTransition>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EncyWorkflowTransitionCacheModel)) {
			return false;
		}

		EncyWorkflowTransitionCacheModel encyWorkflowTransitionCacheModel =
			(EncyWorkflowTransitionCacheModel)object;

		if (transitionId == encyWorkflowTransitionCacheModel.transitionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, transitionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", transitionId=");
		sb.append(transitionId);
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append(", workflowId=");
		sb.append(workflowId);
		sb.append(", version=");
		sb.append(version);
		sb.append(", name=");
		sb.append(name);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", targetStateName=");
		sb.append(targetStateName);
		sb.append(", targetStateId=");
		sb.append(targetStateId);
		sb.append(", cssIcon=");
		sb.append(cssIcon);
		sb.append(", cssIconColor=");
		sb.append(cssIconColor);
		sb.append(", active=");
		sb.append(active);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", order=");
		sb.append(order);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EncyWorkflowTransition toEntityModel() {
		EncyWorkflowTransitionImpl encyWorkflowTransitionImpl =
			new EncyWorkflowTransitionImpl();

		if (uuid == null) {
			encyWorkflowTransitionImpl.setUuid("");
		}
		else {
			encyWorkflowTransitionImpl.setUuid(uuid);
		}

		encyWorkflowTransitionImpl.setTransitionId(transitionId);
		encyWorkflowTransitionImpl.setStateId(stateId);
		encyWorkflowTransitionImpl.setWorkflowId(workflowId);
		encyWorkflowTransitionImpl.setVersion(version);

		if (name == null) {
			encyWorkflowTransitionImpl.setName("");
		}
		else {
			encyWorkflowTransitionImpl.setName(name);
		}

		if (title == null) {
			encyWorkflowTransitionImpl.setTitle("");
		}
		else {
			encyWorkflowTransitionImpl.setTitle(title);
		}

		if (description == null) {
			encyWorkflowTransitionImpl.setDescription("");
		}
		else {
			encyWorkflowTransitionImpl.setDescription(description);
		}

		if (targetStateName == null) {
			encyWorkflowTransitionImpl.setTargetStateName("");
		}
		else {
			encyWorkflowTransitionImpl.setTargetStateName(targetStateName);
		}

		encyWorkflowTransitionImpl.setTargetStateId(targetStateId);

		if (cssIcon == null) {
			encyWorkflowTransitionImpl.setCssIcon("");
		}
		else {
			encyWorkflowTransitionImpl.setCssIcon(cssIcon);
		}

		if (cssIconColor == null) {
			encyWorkflowTransitionImpl.setCssIconColor("");
		}
		else {
			encyWorkflowTransitionImpl.setCssIconColor(cssIconColor);
		}

		encyWorkflowTransitionImpl.setActive(active);

		if (createDate == Long.MIN_VALUE) {
			encyWorkflowTransitionImpl.setCreateDate(null);
		}
		else {
			encyWorkflowTransitionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			encyWorkflowTransitionImpl.setModifiedDate(null);
		}
		else {
			encyWorkflowTransitionImpl.setModifiedDate(new Date(modifiedDate));
		}

		encyWorkflowTransitionImpl.setOrder(order);

		encyWorkflowTransitionImpl.resetOriginalValues();

		return encyWorkflowTransitionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		transitionId = objectInput.readLong();

		stateId = objectInput.readLong();

		workflowId = objectInput.readLong();

		version = objectInput.readLong();
		name = objectInput.readUTF();
		title = objectInput.readUTF();
		description = (String)objectInput.readObject();
		targetStateName = objectInput.readUTF();

		targetStateId = objectInput.readLong();
		cssIcon = objectInput.readUTF();
		cssIconColor = objectInput.readUTF();

		active = objectInput.readBoolean();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		order = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(transitionId);

		objectOutput.writeLong(stateId);

		objectOutput.writeLong(workflowId);

		objectOutput.writeLong(version);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
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

		if (targetStateName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(targetStateName);
		}

		objectOutput.writeLong(targetStateId);

		if (cssIcon == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cssIcon);
		}

		if (cssIconColor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cssIconColor);
		}

		objectOutput.writeBoolean(active);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(order);
	}

	public String uuid;
	public long transitionId;
	public long stateId;
	public long workflowId;
	public long version;
	public String name;
	public String title;
	public String description;
	public String targetStateName;
	public long targetStateId;
	public String cssIcon;
	public String cssIconColor;
	public boolean active;
	public long createDate;
	public long modifiedDate;
	public long order;

}