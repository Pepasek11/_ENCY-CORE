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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link E3EntryVersion}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see E3EntryVersion
 * @generated
 */
public class E3EntryVersionWrapper
	extends BaseModelWrapper<E3EntryVersion>
	implements E3EntryVersion, ModelWrapper<E3EntryVersion> {

	public E3EntryVersionWrapper(E3EntryVersion e3EntryVersion) {
		super(e3EntryVersion);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("e3EntryVersionId", getE3EntryVersionId());
		attributes.put("version", getVersion());
		attributes.put("uuid", getUuid());
		attributes.put("entryId", getEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("authorId", getAuthorId());
		attributes.put("authorName", getAuthorName());
		attributes.put("xid", getXid());
		attributes.put("name", getName());
		attributes.put("appClass", getAppClass());
		attributes.put("parentId", getParentId());
		attributes.put("parentField", getParentField());
		attributes.put("values", getValues());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long e3EntryVersionId = (Long)attributes.get("e3EntryVersionId");

		if (e3EntryVersionId != null) {
			setE3EntryVersionId(e3EntryVersionId);
		}

		Integer version = (Integer)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}

		String authorName = (String)attributes.get("authorName");

		if (authorName != null) {
			setAuthorName(authorName);
		}

		String xid = (String)attributes.get("xid");

		if (xid != null) {
			setXid(xid);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String appClass = (String)attributes.get("appClass");

		if (appClass != null) {
			setAppClass(appClass);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String parentField = (String)attributes.get("parentField");

		if (parentField != null) {
			setParentField(parentField);
		}

		Map<String, Serializable> values =
			(Map<String, Serializable>)attributes.get("values");

		if (values != null) {
			setValues(values);
		}

		Long status = (Long)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the app class of this e3 entry version.
	 *
	 * @return the app class of this e3 entry version
	 */
	@Override
	public String getAppClass() {
		return model.getAppClass();
	}

	/**
	 * Returns the author ID of this e3 entry version.
	 *
	 * @return the author ID of this e3 entry version
	 */
	@Override
	public long getAuthorId() {
		return model.getAuthorId();
	}

	/**
	 * Returns the author name of this e3 entry version.
	 *
	 * @return the author name of this e3 entry version
	 */
	@Override
	public String getAuthorName() {
		return model.getAuthorName();
	}

	/**
	 * Returns the company ID of this e3 entry version.
	 *
	 * @return the company ID of this e3 entry version
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this e3 entry version.
	 *
	 * @return the create date of this e3 entry version
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the e3 entry version ID of this e3 entry version.
	 *
	 * @return the e3 entry version ID of this e3 entry version
	 */
	@Override
	public long getE3EntryVersionId() {
		return model.getE3EntryVersionId();
	}

	/**
	 * Returns the entry ID of this e3 entry version.
	 *
	 * @return the entry ID of this e3 entry version
	 */
	@Override
	public long getEntryId() {
		return model.getEntryId();
	}

	/**
	 * Returns the group ID of this e3 entry version.
	 *
	 * @return the group ID of this e3 entry version
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this e3 entry version.
	 *
	 * @return the modified date of this e3 entry version
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this e3 entry version.
	 *
	 * @return the name of this e3 entry version
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the parent field of this e3 entry version.
	 *
	 * @return the parent field of this e3 entry version
	 */
	@Override
	public String getParentField() {
		return model.getParentField();
	}

	/**
	 * Returns the parent ID of this e3 entry version.
	 *
	 * @return the parent ID of this e3 entry version
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the primary key of this e3 entry version.
	 *
	 * @return the primary key of this e3 entry version
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this e3 entry version.
	 *
	 * @return the status of this e3 entry version
	 */
	@Override
	public long getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this e3 entry version.
	 *
	 * @return the user ID of this e3 entry version
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this e3 entry version.
	 *
	 * @return the user name of this e3 entry version
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this e3 entry version.
	 *
	 * @return the user uuid of this e3 entry version
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this e3 entry version.
	 *
	 * @return the uuid of this e3 entry version
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the values of this e3 entry version.
	 *
	 * @return the values of this e3 entry version
	 */
	@Override
	public Map<String, Serializable> getValues() {
		return model.getValues();
	}

	/**
	 * Returns the version of this e3 entry version.
	 *
	 * @return the version of this e3 entry version
	 */
	@Override
	public int getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns the xid of this e3 entry version.
	 *
	 * @return the xid of this e3 entry version
	 */
	@Override
	public String getXid() {
		return model.getXid();
	}

	/**
	 * Sets the app class of this e3 entry version.
	 *
	 * @param appClass the app class of this e3 entry version
	 */
	@Override
	public void setAppClass(String appClass) {
		model.setAppClass(appClass);
	}

	/**
	 * Sets the author ID of this e3 entry version.
	 *
	 * @param authorId the author ID of this e3 entry version
	 */
	@Override
	public void setAuthorId(long authorId) {
		model.setAuthorId(authorId);
	}

	/**
	 * Sets the author name of this e3 entry version.
	 *
	 * @param authorName the author name of this e3 entry version
	 */
	@Override
	public void setAuthorName(String authorName) {
		model.setAuthorName(authorName);
	}

	/**
	 * Sets the company ID of this e3 entry version.
	 *
	 * @param companyId the company ID of this e3 entry version
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this e3 entry version.
	 *
	 * @param createDate the create date of this e3 entry version
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the e3 entry version ID of this e3 entry version.
	 *
	 * @param e3EntryVersionId the e3 entry version ID of this e3 entry version
	 */
	@Override
	public void setE3EntryVersionId(long e3EntryVersionId) {
		model.setE3EntryVersionId(e3EntryVersionId);
	}

	/**
	 * Sets the entry ID of this e3 entry version.
	 *
	 * @param entryId the entry ID of this e3 entry version
	 */
	@Override
	public void setEntryId(long entryId) {
		model.setEntryId(entryId);
	}

	/**
	 * Sets the group ID of this e3 entry version.
	 *
	 * @param groupId the group ID of this e3 entry version
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this e3 entry version.
	 *
	 * @param modifiedDate the modified date of this e3 entry version
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this e3 entry version.
	 *
	 * @param name the name of this e3 entry version
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the parent field of this e3 entry version.
	 *
	 * @param parentField the parent field of this e3 entry version
	 */
	@Override
	public void setParentField(String parentField) {
		model.setParentField(parentField);
	}

	/**
	 * Sets the parent ID of this e3 entry version.
	 *
	 * @param parentId the parent ID of this e3 entry version
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this e3 entry version.
	 *
	 * @param primaryKey the primary key of this e3 entry version
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this e3 entry version.
	 *
	 * @param status the status of this e3 entry version
	 */
	@Override
	public void setStatus(long status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this e3 entry version.
	 *
	 * @param userId the user ID of this e3 entry version
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this e3 entry version.
	 *
	 * @param userName the user name of this e3 entry version
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this e3 entry version.
	 *
	 * @param userUuid the user uuid of this e3 entry version
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this e3 entry version.
	 *
	 * @param uuid the uuid of this e3 entry version
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the values of this e3 entry version.
	 *
	 * @param values the values of this e3 entry version
	 */
	@Override
	public void setValues(Map<String, Serializable> values) {
		model.setValues(values);
	}

	/**
	 * Sets the version of this e3 entry version.
	 *
	 * @param version the version of this e3 entry version
	 */
	@Override
	public void setVersion(int version) {
		model.setVersion(version);
	}

	/**
	 * Sets the xid of this e3 entry version.
	 *
	 * @param xid the xid of this e3 entry version
	 */
	@Override
	public void setXid(String xid) {
		model.setXid(xid);
	}

	@Override
	public long getVersionedModelId() {
		return model.getVersionedModelId();
	}

	@Override
	public void setVersionedModelId(long id) {
		model.setVersionedModelId(id);
	}

	@Override
	public void populateVersionedModel(E3Entry e3Entry) {
		model.populateVersionedModel(e3Entry);
	}

	@Override
	public E3Entry toVersionedModel() {
		return model.toVersionedModel();
	}

	@Override
	protected E3EntryVersionWrapper wrap(E3EntryVersion e3EntryVersion) {
		return new E3EntryVersionWrapper(e3EntryVersion);
	}

}