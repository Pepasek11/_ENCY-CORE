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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link E3Entry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see E3Entry
 * @generated
 */
public class E3EntryWrapper
	extends BaseModelWrapper<E3Entry>
	implements E3Entry, ModelWrapper<E3Entry> {

	public E3EntryWrapper(E3Entry e3Entry) {
		super(e3Entry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("headId", getHeadId());
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
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long headId = (Long)attributes.get("headId");

		if (headId != null) {
			setHeadId(headId);
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
	 * Returns the app class of this e3 entry.
	 *
	 * @return the app class of this e3 entry
	 */
	@Override
	public String getAppClass() {
		return model.getAppClass();
	}

	@Override
	public String getAppCode() {
		return model.getAppCode();
	}

	/**
	 * Returns the author ID of this e3 entry.
	 *
	 * @return the author ID of this e3 entry
	 */
	@Override
	public long getAuthorId() {
		return model.getAuthorId();
	}

	/**
	 * Returns the author name of this e3 entry.
	 *
	 * @return the author name of this e3 entry
	 */
	@Override
	public String getAuthorName() {
		return model.getAuthorName();
	}

	/**
	 * Returns the company ID of this e3 entry.
	 *
	 * @return the company ID of this e3 entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this e3 entry.
	 *
	 * @return the create date of this e3 entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the entry ID of this e3 entry.
	 *
	 * @return the entry ID of this e3 entry
	 */
	@Override
	public long getEntryId() {
		return model.getEntryId();
	}

	/**
	 * Returns the group ID of this e3 entry.
	 *
	 * @return the group ID of this e3 entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the head ID of this e3 entry.
	 *
	 * @return the head ID of this e3 entry
	 */
	@Override
	public long getHeadId() {
		return model.getHeadId();
	}

	/**
	 * Returns the modified date of this e3 entry.
	 *
	 * @return the modified date of this e3 entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this e3 entry.
	 *
	 * @return the mvcc version of this e3 entry
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the name of this e3 entry.
	 *
	 * @return the name of this e3 entry
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the parent field of this e3 entry.
	 *
	 * @return the parent field of this e3 entry
	 */
	@Override
	public String getParentField() {
		return model.getParentField();
	}

	/**
	 * Returns the parent ID of this e3 entry.
	 *
	 * @return the parent ID of this e3 entry
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the primary key of this e3 entry.
	 *
	 * @return the primary key of this e3 entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this e3 entry.
	 *
	 * @return the status of this e3 entry
	 */
	@Override
	public long getStatus() {
		return model.getStatus();
	}

	@Override
	public String getSummary() {
		return model.getSummary();
	}

	/**
	 * Returns the user ID of this e3 entry.
	 *
	 * @return the user ID of this e3 entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this e3 entry.
	 *
	 * @return the user name of this e3 entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this e3 entry.
	 *
	 * @return the user uuid of this e3 entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this e3 entry.
	 *
	 * @return the uuid of this e3 entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public Serializable getValue(String key) {
		return model.getValue(key);
	}

	/**
	 * Returns the values of this e3 entry.
	 *
	 * @return the values of this e3 entry
	 */
	@Override
	public Map<String, Serializable> getValues() {
		return model.getValues();
	}

	/**
	 * Returns the xid of this e3 entry.
	 *
	 * @return the xid of this e3 entry
	 */
	@Override
	public String getXid() {
		return model.getXid();
	}

	@Override
	public Boolean isIndexable() {
		return model.isIndexable();
	}

	@Override
	public Boolean isVersioned() {
		return model.isVersioned();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the app class of this e3 entry.
	 *
	 * @param appClass the app class of this e3 entry
	 */
	@Override
	public void setAppClass(String appClass) {
		model.setAppClass(appClass);
	}

	/**
	 * Sets the author ID of this e3 entry.
	 *
	 * @param authorId the author ID of this e3 entry
	 */
	@Override
	public void setAuthorId(long authorId) {
		model.setAuthorId(authorId);
	}

	/**
	 * Sets the author name of this e3 entry.
	 *
	 * @param authorName the author name of this e3 entry
	 */
	@Override
	public void setAuthorName(String authorName) {
		model.setAuthorName(authorName);
	}

	/**
	 * Sets the company ID of this e3 entry.
	 *
	 * @param companyId the company ID of this e3 entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this e3 entry.
	 *
	 * @param createDate the create date of this e3 entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the entry ID of this e3 entry.
	 *
	 * @param entryId the entry ID of this e3 entry
	 */
	@Override
	public void setEntryId(long entryId) {
		model.setEntryId(entryId);
	}

	/**
	 * Sets the group ID of this e3 entry.
	 *
	 * @param groupId the group ID of this e3 entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the head ID of this e3 entry.
	 *
	 * @param headId the head ID of this e3 entry
	 */
	@Override
	public void setHeadId(long headId) {
		model.setHeadId(headId);
	}

	/**
	 * Sets the modified date of this e3 entry.
	 *
	 * @param modifiedDate the modified date of this e3 entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this e3 entry.
	 *
	 * @param mvccVersion the mvcc version of this e3 entry
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the name of this e3 entry.
	 *
	 * @param name the name of this e3 entry
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the parent field of this e3 entry.
	 *
	 * @param parentField the parent field of this e3 entry
	 */
	@Override
	public void setParentField(String parentField) {
		model.setParentField(parentField);
	}

	/**
	 * Sets the parent ID of this e3 entry.
	 *
	 * @param parentId the parent ID of this e3 entry
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this e3 entry.
	 *
	 * @param primaryKey the primary key of this e3 entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this e3 entry.
	 *
	 * @param status the status of this e3 entry
	 */
	@Override
	public void setStatus(long status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this e3 entry.
	 *
	 * @param userId the user ID of this e3 entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this e3 entry.
	 *
	 * @param userName the user name of this e3 entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this e3 entry.
	 *
	 * @param userUuid the user uuid of this e3 entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this e3 entry.
	 *
	 * @param uuid the uuid of this e3 entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry setValue(
		String key, Serializable value) {

		return model.setValue(key, value);
	}

	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry setValues(
		javax.portlet.ActionRequest actionRequest) {

		return model.setValues(actionRequest);
	}

	/**
	 * Sets the values of this e3 entry.
	 *
	 * @param values the values of this e3 entry
	 */
	@Override
	public void setValues(Map<String, Serializable> values) {
		model.setValues(values);
	}

	/**
	 * Sets the xid of this e3 entry.
	 *
	 * @param xid the xid of this e3 entry
	 */
	@Override
	public void setXid(String xid) {
		model.setXid(xid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	public boolean isHead() {
		return model.isHead();
	}

	@Override
	public void populateVersionModel(E3EntryVersion e3EntryVersion) {
		model.populateVersionModel(e3EntryVersion);
	}

	@Override
	protected E3EntryWrapper wrap(E3Entry e3Entry) {
		return new E3EntryWrapper(e3Entry);
	}

}