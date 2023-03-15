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

package cz.csob.ency.delegations.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Delegation}.
 * </p>
 *
 * @author Miroslav Čermák
 * @see Delegation
 * @generated
 */
public class DelegationWrapper
	extends BaseModelWrapper<Delegation>
	implements Delegation, ModelWrapper<Delegation> {

	public DelegationWrapper(Delegation delegation) {
		super(delegation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("delegationId", getDelegationId());
		attributes.put("roleId", getRoleId());
		attributes.put("delegatingUserId", getDelegatingUserId());
		attributes.put("delegatedUserId", getDelegatedUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("note", getNote());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long delegationId = (Long)attributes.get("delegationId");

		if (delegationId != null) {
			setDelegationId(delegationId);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		Long delegatingUserId = (Long)attributes.get("delegatingUserId");

		if (delegatingUserId != null) {
			setDelegatingUserId(delegatingUserId);
		}

		Long delegatedUserId = (Long)attributes.get("delegatedUserId");

		if (delegatedUserId != null) {
			setDelegatedUserId(delegatedUserId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
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
	}

	@Override
	public Delegation cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this delegation.
	 *
	 * @return the company ID of this delegation
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this delegation.
	 *
	 * @return the create date of this delegation
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the delegated user ID of this delegation.
	 *
	 * @return the delegated user ID of this delegation
	 */
	@Override
	public long getDelegatedUserId() {
		return model.getDelegatedUserId();
	}

	/**
	 * Returns the delegated user uuid of this delegation.
	 *
	 * @return the delegated user uuid of this delegation
	 */
	@Override
	public String getDelegatedUserUuid() {
		return model.getDelegatedUserUuid();
	}

	/**
	 * Returns the delegating user ID of this delegation.
	 *
	 * @return the delegating user ID of this delegation
	 */
	@Override
	public long getDelegatingUserId() {
		return model.getDelegatingUserId();
	}

	/**
	 * Returns the delegating user uuid of this delegation.
	 *
	 * @return the delegating user uuid of this delegation
	 */
	@Override
	public String getDelegatingUserUuid() {
		return model.getDelegatingUserUuid();
	}

	/**
	 * Returns the delegation ID of this delegation.
	 *
	 * @return the delegation ID of this delegation
	 */
	@Override
	public long getDelegationId() {
		return model.getDelegationId();
	}

	/**
	 * Returns the group ID of this delegation.
	 *
	 * @return the group ID of this delegation
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this delegation.
	 *
	 * @return the modified date of this delegation
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this delegation.
	 *
	 * @return the mvcc version of this delegation
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the note of this delegation.
	 *
	 * @return the note of this delegation
	 */
	@Override
	public String getNote() {
		return model.getNote();
	}

	/**
	 * Returns the primary key of this delegation.
	 *
	 * @return the primary key of this delegation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role ID of this delegation.
	 *
	 * @return the role ID of this delegation
	 */
	@Override
	public long getRoleId() {
		return model.getRoleId();
	}

	/**
	 * Returns the user ID of this delegation.
	 *
	 * @return the user ID of this delegation
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this delegation.
	 *
	 * @return the user name of this delegation
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this delegation.
	 *
	 * @return the user uuid of this delegation
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this delegation.
	 *
	 * @param companyId the company ID of this delegation
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this delegation.
	 *
	 * @param createDate the create date of this delegation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the delegated user ID of this delegation.
	 *
	 * @param delegatedUserId the delegated user ID of this delegation
	 */
	@Override
	public void setDelegatedUserId(long delegatedUserId) {
		model.setDelegatedUserId(delegatedUserId);
	}

	/**
	 * Sets the delegated user uuid of this delegation.
	 *
	 * @param delegatedUserUuid the delegated user uuid of this delegation
	 */
	@Override
	public void setDelegatedUserUuid(String delegatedUserUuid) {
		model.setDelegatedUserUuid(delegatedUserUuid);
	}

	/**
	 * Sets the delegating user ID of this delegation.
	 *
	 * @param delegatingUserId the delegating user ID of this delegation
	 */
	@Override
	public void setDelegatingUserId(long delegatingUserId) {
		model.setDelegatingUserId(delegatingUserId);
	}

	/**
	 * Sets the delegating user uuid of this delegation.
	 *
	 * @param delegatingUserUuid the delegating user uuid of this delegation
	 */
	@Override
	public void setDelegatingUserUuid(String delegatingUserUuid) {
		model.setDelegatingUserUuid(delegatingUserUuid);
	}

	/**
	 * Sets the delegation ID of this delegation.
	 *
	 * @param delegationId the delegation ID of this delegation
	 */
	@Override
	public void setDelegationId(long delegationId) {
		model.setDelegationId(delegationId);
	}

	/**
	 * Sets the group ID of this delegation.
	 *
	 * @param groupId the group ID of this delegation
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this delegation.
	 *
	 * @param modifiedDate the modified date of this delegation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this delegation.
	 *
	 * @param mvccVersion the mvcc version of this delegation
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the note of this delegation.
	 *
	 * @param note the note of this delegation
	 */
	@Override
	public void setNote(String note) {
		model.setNote(note);
	}

	/**
	 * Sets the primary key of this delegation.
	 *
	 * @param primaryKey the primary key of this delegation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role ID of this delegation.
	 *
	 * @param roleId the role ID of this delegation
	 */
	@Override
	public void setRoleId(long roleId) {
		model.setRoleId(roleId);
	}

	/**
	 * Sets the user ID of this delegation.
	 *
	 * @param userId the user ID of this delegation
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this delegation.
	 *
	 * @param userName the user name of this delegation
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this delegation.
	 *
	 * @param userUuid the user uuid of this delegation
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected DelegationWrapper wrap(Delegation delegation) {
		return new DelegationWrapper(delegation);
	}

}