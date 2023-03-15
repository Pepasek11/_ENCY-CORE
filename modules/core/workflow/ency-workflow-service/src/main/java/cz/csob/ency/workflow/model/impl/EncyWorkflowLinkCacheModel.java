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

import cz.csob.ency.workflow.model.EncyWorkflowLink;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EncyWorkflowLink in entity cache.
 *
 * @author Miroslav Čermák
 * @generated
 */
public class EncyWorkflowLinkCacheModel
	implements CacheModel<EncyWorkflowLink>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EncyWorkflowLinkCacheModel)) {
			return false;
		}

		EncyWorkflowLinkCacheModel encyWorkflowLinkCacheModel =
			(EncyWorkflowLinkCacheModel)object;

		if (workflowLinkId == encyWorkflowLinkCacheModel.workflowLinkId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, workflowLinkId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", workflowLinkId=");
		sb.append(workflowLinkId);
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
		sb.append(", className=");
		sb.append(className);
		sb.append(", folderClassName=");
		sb.append(folderClassName);
		sb.append(", folderPK=");
		sb.append(folderPK);
		sb.append(", workflowId=");
		sb.append(workflowId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EncyWorkflowLink toEntityModel() {
		EncyWorkflowLinkImpl encyWorkflowLinkImpl = new EncyWorkflowLinkImpl();

		if (uuid == null) {
			encyWorkflowLinkImpl.setUuid("");
		}
		else {
			encyWorkflowLinkImpl.setUuid(uuid);
		}

		encyWorkflowLinkImpl.setWorkflowLinkId(workflowLinkId);
		encyWorkflowLinkImpl.setGroupId(groupId);
		encyWorkflowLinkImpl.setCompanyId(companyId);
		encyWorkflowLinkImpl.setUserId(userId);

		if (userName == null) {
			encyWorkflowLinkImpl.setUserName("");
		}
		else {
			encyWorkflowLinkImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			encyWorkflowLinkImpl.setCreateDate(null);
		}
		else {
			encyWorkflowLinkImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			encyWorkflowLinkImpl.setModifiedDate(null);
		}
		else {
			encyWorkflowLinkImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (className == null) {
			encyWorkflowLinkImpl.setClassName("");
		}
		else {
			encyWorkflowLinkImpl.setClassName(className);
		}

		if (folderClassName == null) {
			encyWorkflowLinkImpl.setFolderClassName("");
		}
		else {
			encyWorkflowLinkImpl.setFolderClassName(folderClassName);
		}

		encyWorkflowLinkImpl.setFolderPK(folderPK);
		encyWorkflowLinkImpl.setWorkflowId(workflowId);

		encyWorkflowLinkImpl.resetOriginalValues();

		return encyWorkflowLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		workflowLinkId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		className = objectInput.readUTF();
		folderClassName = objectInput.readUTF();

		folderPK = objectInput.readLong();

		workflowId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(workflowLinkId);

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

		if (className == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(className);
		}

		if (folderClassName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(folderClassName);
		}

		objectOutput.writeLong(folderPK);

		objectOutput.writeLong(workflowId);
	}

	public String uuid;
	public long workflowLinkId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String className;
	public String folderClassName;
	public long folderPK;
	public long workflowId;

}