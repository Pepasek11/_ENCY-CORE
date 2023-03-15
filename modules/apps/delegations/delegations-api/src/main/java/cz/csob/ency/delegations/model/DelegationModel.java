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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Delegation service. Represents a row in the &quot;delegations_delegation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>cz.csob.ency.delegations.model.impl.DelegationModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>cz.csob.ency.delegations.model.impl.DelegationImpl</code>.
 * </p>
 *
 * @author Miroslav Čermák
 * @see Delegation
 * @generated
 */
@ProviderType
public interface DelegationModel
	extends BaseModel<Delegation>, GroupedModel, MVCCModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a delegation model instance should use the {@link Delegation} interface instead.
	 */

	/**
	 * Returns the primary key of this delegation.
	 *
	 * @return the primary key of this delegation
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this delegation.
	 *
	 * @param primaryKey the primary key of this delegation
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this delegation.
	 *
	 * @return the mvcc version of this delegation
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this delegation.
	 *
	 * @param mvccVersion the mvcc version of this delegation
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the delegation ID of this delegation.
	 *
	 * @return the delegation ID of this delegation
	 */
	public long getDelegationId();

	/**
	 * Sets the delegation ID of this delegation.
	 *
	 * @param delegationId the delegation ID of this delegation
	 */
	public void setDelegationId(long delegationId);

	/**
	 * Returns the role ID of this delegation.
	 *
	 * @return the role ID of this delegation
	 */
	public long getRoleId();

	/**
	 * Sets the role ID of this delegation.
	 *
	 * @param roleId the role ID of this delegation
	 */
	public void setRoleId(long roleId);

	/**
	 * Returns the delegating user ID of this delegation.
	 *
	 * @return the delegating user ID of this delegation
	 */
	public long getDelegatingUserId();

	/**
	 * Sets the delegating user ID of this delegation.
	 *
	 * @param delegatingUserId the delegating user ID of this delegation
	 */
	public void setDelegatingUserId(long delegatingUserId);

	/**
	 * Returns the delegating user uuid of this delegation.
	 *
	 * @return the delegating user uuid of this delegation
	 */
	public String getDelegatingUserUuid();

	/**
	 * Sets the delegating user uuid of this delegation.
	 *
	 * @param delegatingUserUuid the delegating user uuid of this delegation
	 */
	public void setDelegatingUserUuid(String delegatingUserUuid);

	/**
	 * Returns the delegated user ID of this delegation.
	 *
	 * @return the delegated user ID of this delegation
	 */
	public long getDelegatedUserId();

	/**
	 * Sets the delegated user ID of this delegation.
	 *
	 * @param delegatedUserId the delegated user ID of this delegation
	 */
	public void setDelegatedUserId(long delegatedUserId);

	/**
	 * Returns the delegated user uuid of this delegation.
	 *
	 * @return the delegated user uuid of this delegation
	 */
	public String getDelegatedUserUuid();

	/**
	 * Sets the delegated user uuid of this delegation.
	 *
	 * @param delegatedUserUuid the delegated user uuid of this delegation
	 */
	public void setDelegatedUserUuid(String delegatedUserUuid);

	/**
	 * Returns the group ID of this delegation.
	 *
	 * @return the group ID of this delegation
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this delegation.
	 *
	 * @param groupId the group ID of this delegation
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the note of this delegation.
	 *
	 * @return the note of this delegation
	 */
	@AutoEscape
	public String getNote();

	/**
	 * Sets the note of this delegation.
	 *
	 * @param note the note of this delegation
	 */
	public void setNote(String note);

	/**
	 * Returns the company ID of this delegation.
	 *
	 * @return the company ID of this delegation
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this delegation.
	 *
	 * @param companyId the company ID of this delegation
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this delegation.
	 *
	 * @return the user ID of this delegation
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this delegation.
	 *
	 * @param userId the user ID of this delegation
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this delegation.
	 *
	 * @return the user uuid of this delegation
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this delegation.
	 *
	 * @param userUuid the user uuid of this delegation
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this delegation.
	 *
	 * @return the user name of this delegation
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this delegation.
	 *
	 * @param userName the user name of this delegation
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this delegation.
	 *
	 * @return the create date of this delegation
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this delegation.
	 *
	 * @param createDate the create date of this delegation
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this delegation.
	 *
	 * @return the modified date of this delegation
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this delegation.
	 *
	 * @param modifiedDate the modified date of this delegation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	@Override
	public Delegation cloneWithOriginalValues();

}