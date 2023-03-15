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

import cz.csob.ency.workflow.model.EncyWorkflowState;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EncyWorkflowState in entity cache.
 *
 * @author Miroslav Čermák
 * @generated
 */
public class EncyWorkflowStateCacheModel
	implements CacheModel<EncyWorkflowState>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EncyWorkflowStateCacheModel)) {
			return false;
		}

		EncyWorkflowStateCacheModel encyWorkflowStateCacheModel =
			(EncyWorkflowStateCacheModel)object;

		if (stateId == encyWorkflowStateCacheModel.stateId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stateId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append(", workflowId=");
		sb.append(workflowId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", version=");
		sb.append(version);
		sb.append(", isInitial=");
		sb.append(isInitial);
		sb.append(", isFinal=");
		sb.append(isFinal);
		sb.append(", isEditable=");
		sb.append(isEditable);
		sb.append(", isSearchable=");
		sb.append(isSearchable);
		sb.append(", isPermanent=");
		sb.append(isPermanent);
		sb.append(", cssIcon=");
		sb.append(cssIcon);
		sb.append(", cssIconColor=");
		sb.append(cssIconColor);
		sb.append(", cssLabelColor=");
		sb.append(cssLabelColor);
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
	public EncyWorkflowState toEntityModel() {
		EncyWorkflowStateImpl encyWorkflowStateImpl =
			new EncyWorkflowStateImpl();

		if (uuid == null) {
			encyWorkflowStateImpl.setUuid("");
		}
		else {
			encyWorkflowStateImpl.setUuid(uuid);
		}

		encyWorkflowStateImpl.setStateId(stateId);
		encyWorkflowStateImpl.setWorkflowId(workflowId);

		if (name == null) {
			encyWorkflowStateImpl.setName("");
		}
		else {
			encyWorkflowStateImpl.setName(name);
		}

		if (title == null) {
			encyWorkflowStateImpl.setTitle("");
		}
		else {
			encyWorkflowStateImpl.setTitle(title);
		}

		if (description == null) {
			encyWorkflowStateImpl.setDescription("");
		}
		else {
			encyWorkflowStateImpl.setDescription(description);
		}

		encyWorkflowStateImpl.setVersion(version);
		encyWorkflowStateImpl.setIsInitial(isInitial);
		encyWorkflowStateImpl.setIsFinal(isFinal);
		encyWorkflowStateImpl.setIsEditable(isEditable);
		encyWorkflowStateImpl.setIsSearchable(isSearchable);
		encyWorkflowStateImpl.setIsPermanent(isPermanent);

		if (cssIcon == null) {
			encyWorkflowStateImpl.setCssIcon("");
		}
		else {
			encyWorkflowStateImpl.setCssIcon(cssIcon);
		}

		if (cssIconColor == null) {
			encyWorkflowStateImpl.setCssIconColor("");
		}
		else {
			encyWorkflowStateImpl.setCssIconColor(cssIconColor);
		}

		if (cssLabelColor == null) {
			encyWorkflowStateImpl.setCssLabelColor("");
		}
		else {
			encyWorkflowStateImpl.setCssLabelColor(cssLabelColor);
		}

		encyWorkflowStateImpl.setActive(active);

		if (createDate == Long.MIN_VALUE) {
			encyWorkflowStateImpl.setCreateDate(null);
		}
		else {
			encyWorkflowStateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			encyWorkflowStateImpl.setModifiedDate(null);
		}
		else {
			encyWorkflowStateImpl.setModifiedDate(new Date(modifiedDate));
		}

		encyWorkflowStateImpl.resetOriginalValues();

		return encyWorkflowStateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		stateId = objectInput.readLong();

		workflowId = objectInput.readLong();
		name = objectInput.readUTF();
		title = objectInput.readUTF();
		description = (String)objectInput.readObject();

		version = objectInput.readLong();

		isInitial = objectInput.readBoolean();

		isFinal = objectInput.readBoolean();

		isEditable = objectInput.readBoolean();

		isSearchable = objectInput.readBoolean();

		isPermanent = objectInput.readBoolean();
		cssIcon = objectInput.readUTF();
		cssIconColor = objectInput.readUTF();
		cssLabelColor = objectInput.readUTF();

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

		objectOutput.writeLong(stateId);

		objectOutput.writeLong(workflowId);

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

		objectOutput.writeLong(version);

		objectOutput.writeBoolean(isInitial);

		objectOutput.writeBoolean(isFinal);

		objectOutput.writeBoolean(isEditable);

		objectOutput.writeBoolean(isSearchable);

		objectOutput.writeBoolean(isPermanent);

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

		if (cssLabelColor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cssLabelColor);
		}

		objectOutput.writeBoolean(active);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long stateId;
	public long workflowId;
	public String name;
	public String title;
	public String description;
	public long version;
	public boolean isInitial;
	public boolean isFinal;
	public boolean isEditable;
	public boolean isSearchable;
	public boolean isPermanent;
	public String cssIcon;
	public String cssIconColor;
	public String cssLabelColor;
	public boolean active;
	public long createDate;
	public long modifiedDate;

}