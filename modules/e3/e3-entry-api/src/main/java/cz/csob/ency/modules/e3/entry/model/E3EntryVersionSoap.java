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

package cz.csob.ency.modules.e3.entry.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class E3EntryVersionSoap implements Serializable {

	public static E3EntryVersionSoap toSoapModel(E3EntryVersion model) {
		E3EntryVersionSoap soapModel = new E3EntryVersionSoap();

		soapModel.setE3EntryVersionId(model.getE3EntryVersionId());
		soapModel.setVersion(model.getVersion());
		soapModel.setUuid(model.getUuid());
		soapModel.setEntryId(model.getEntryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAuthorId(model.getAuthorId());
		soapModel.setAuthorName(model.getAuthorName());
		soapModel.setXid(model.getXid());
		soapModel.setName(model.getName());
		soapModel.setAppClass(model.getAppClass());
		soapModel.setParentId(model.getParentId());
		soapModel.setParentField(model.getParentField());
		soapModel.setValues(model.getValues());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static E3EntryVersionSoap[] toSoapModels(E3EntryVersion[] models) {
		E3EntryVersionSoap[] soapModels = new E3EntryVersionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static E3EntryVersionSoap[][] toSoapModels(
		E3EntryVersion[][] models) {

		E3EntryVersionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new E3EntryVersionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new E3EntryVersionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static E3EntryVersionSoap[] toSoapModels(
		List<E3EntryVersion> models) {

		List<E3EntryVersionSoap> soapModels = new ArrayList<E3EntryVersionSoap>(
			models.size());

		for (E3EntryVersion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new E3EntryVersionSoap[soapModels.size()]);
	}

	public E3EntryVersionSoap() {
	}

	public long getPrimaryKey() {
		return _e3EntryVersionId;
	}

	public void setPrimaryKey(long pk) {
		setE3EntryVersionId(pk);
	}

	public long getE3EntryVersionId() {
		return _e3EntryVersionId;
	}

	public void setE3EntryVersionId(long e3EntryVersionId) {
		_e3EntryVersionId = e3EntryVersionId;
	}

	public int getVersion() {
		return _version;
	}

	public void setVersion(int version) {
		_version = version;
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_entryId = entryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getAuthorId() {
		return _authorId;
	}

	public void setAuthorId(long authorId) {
		_authorId = authorId;
	}

	public String getAuthorName() {
		return _authorName;
	}

	public void setAuthorName(String authorName) {
		_authorName = authorName;
	}

	public String getXid() {
		return _xid;
	}

	public void setXid(String xid) {
		_xid = xid;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getAppClass() {
		return _appClass;
	}

	public void setAppClass(String appClass) {
		_appClass = appClass;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public String getParentField() {
		return _parentField;
	}

	public void setParentField(String parentField) {
		_parentField = parentField;
	}

	public Map<String, Serializable> getValues() {
		return _values;
	}

	public void setValues(Map<String, Serializable> values) {
		_values = values;
	}

	public long getStatus() {
		return _status;
	}

	public void setStatus(long status) {
		_status = status;
	}

	private long _e3EntryVersionId;
	private int _version;
	private String _uuid;
	private long _entryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _authorId;
	private String _authorName;
	private String _xid;
	private String _name;
	private String _appClass;
	private long _parentId;
	private String _parentField;
	private Map<String, Serializable> _values;
	private long _status;

}