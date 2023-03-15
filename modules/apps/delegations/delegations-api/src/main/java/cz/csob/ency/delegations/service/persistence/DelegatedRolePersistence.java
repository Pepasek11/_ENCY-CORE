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

package cz.csob.ency.delegations.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import cz.csob.ency.delegations.exception.NoSuchDelegatedRoleException;
import cz.csob.ency.delegations.model.DelegatedRole;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the delegated role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see DelegatedRoleUtil
 * @generated
 */
@ProviderType
public interface DelegatedRolePersistence
	extends BasePersistence<DelegatedRole> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DelegatedRoleUtil} to access the delegated role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the delegated role where roleId = &#63; or throws a <code>NoSuchDelegatedRoleException</code> if it could not be found.
	 *
	 * @param roleId the role ID
	 * @return the matching delegated role
	 * @throws NoSuchDelegatedRoleException if a matching delegated role could not be found
	 */
	public DelegatedRole findById(long roleId)
		throws NoSuchDelegatedRoleException;

	/**
	 * Returns the delegated role where roleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param roleId the role ID
	 * @return the matching delegated role, or <code>null</code> if a matching delegated role could not be found
	 */
	public DelegatedRole fetchById(long roleId);

	/**
	 * Returns the delegated role where roleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param roleId the role ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching delegated role, or <code>null</code> if a matching delegated role could not be found
	 */
	public DelegatedRole fetchById(long roleId, boolean useFinderCache);

	/**
	 * Removes the delegated role where roleId = &#63; from the database.
	 *
	 * @param roleId the role ID
	 * @return the delegated role that was removed
	 */
	public DelegatedRole removeById(long roleId)
		throws NoSuchDelegatedRoleException;

	/**
	 * Returns the number of delegated roles where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the number of matching delegated roles
	 */
	public int countById(long roleId);

	/**
	 * Returns the delegated role where code = &#63; or throws a <code>NoSuchDelegatedRoleException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching delegated role
	 * @throws NoSuchDelegatedRoleException if a matching delegated role could not be found
	 */
	public DelegatedRole findByCode(String code)
		throws NoSuchDelegatedRoleException;

	/**
	 * Returns the delegated role where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching delegated role, or <code>null</code> if a matching delegated role could not be found
	 */
	public DelegatedRole fetchByCode(String code);

	/**
	 * Returns the delegated role where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching delegated role, or <code>null</code> if a matching delegated role could not be found
	 */
	public DelegatedRole fetchByCode(String code, boolean useFinderCache);

	/**
	 * Removes the delegated role where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the delegated role that was removed
	 */
	public DelegatedRole removeByCode(String code)
		throws NoSuchDelegatedRoleException;

	/**
	 * Returns the number of delegated roles where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching delegated roles
	 */
	public int countByCode(String code);

	/**
	 * Returns all the delegated roles where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching delegated roles
	 */
	public java.util.List<DelegatedRole> findByG(long groupId);

	/**
	 * Returns a range of all the delegated roles where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegatedRoleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of delegated roles
	 * @param end the upper bound of the range of delegated roles (not inclusive)
	 * @return the range of matching delegated roles
	 */
	public java.util.List<DelegatedRole> findByG(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the delegated roles where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegatedRoleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of delegated roles
	 * @param end the upper bound of the range of delegated roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching delegated roles
	 */
	public java.util.List<DelegatedRole> findByG(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DelegatedRole>
			orderByComparator);

	/**
	 * Returns an ordered range of all the delegated roles where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegatedRoleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of delegated roles
	 * @param end the upper bound of the range of delegated roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching delegated roles
	 */
	public java.util.List<DelegatedRole> findByG(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DelegatedRole>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first delegated role in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegated role
	 * @throws NoSuchDelegatedRoleException if a matching delegated role could not be found
	 */
	public DelegatedRole findByG_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DelegatedRole>
				orderByComparator)
		throws NoSuchDelegatedRoleException;

	/**
	 * Returns the first delegated role in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegated role, or <code>null</code> if a matching delegated role could not be found
	 */
	public DelegatedRole fetchByG_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DelegatedRole>
			orderByComparator);

	/**
	 * Returns the last delegated role in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegated role
	 * @throws NoSuchDelegatedRoleException if a matching delegated role could not be found
	 */
	public DelegatedRole findByG_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DelegatedRole>
				orderByComparator)
		throws NoSuchDelegatedRoleException;

	/**
	 * Returns the last delegated role in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegated role, or <code>null</code> if a matching delegated role could not be found
	 */
	public DelegatedRole fetchByG_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DelegatedRole>
			orderByComparator);

	/**
	 * Returns the delegated roles before and after the current delegated role in the ordered set where groupId = &#63;.
	 *
	 * @param roleId the primary key of the current delegated role
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next delegated role
	 * @throws NoSuchDelegatedRoleException if a delegated role with the primary key could not be found
	 */
	public DelegatedRole[] findByG_PrevAndNext(
			long roleId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DelegatedRole>
				orderByComparator)
		throws NoSuchDelegatedRoleException;

	/**
	 * Removes all the delegated roles where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByG(long groupId);

	/**
	 * Returns the number of delegated roles where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching delegated roles
	 */
	public int countByG(long groupId);

	/**
	 * Caches the delegated role in the entity cache if it is enabled.
	 *
	 * @param delegatedRole the delegated role
	 */
	public void cacheResult(DelegatedRole delegatedRole);

	/**
	 * Caches the delegated roles in the entity cache if it is enabled.
	 *
	 * @param delegatedRoles the delegated roles
	 */
	public void cacheResult(java.util.List<DelegatedRole> delegatedRoles);

	/**
	 * Creates a new delegated role with the primary key. Does not add the delegated role to the database.
	 *
	 * @param roleId the primary key for the new delegated role
	 * @return the new delegated role
	 */
	public DelegatedRole create(long roleId);

	/**
	 * Removes the delegated role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roleId the primary key of the delegated role
	 * @return the delegated role that was removed
	 * @throws NoSuchDelegatedRoleException if a delegated role with the primary key could not be found
	 */
	public DelegatedRole remove(long roleId)
		throws NoSuchDelegatedRoleException;

	public DelegatedRole updateImpl(DelegatedRole delegatedRole);

	/**
	 * Returns the delegated role with the primary key or throws a <code>NoSuchDelegatedRoleException</code> if it could not be found.
	 *
	 * @param roleId the primary key of the delegated role
	 * @return the delegated role
	 * @throws NoSuchDelegatedRoleException if a delegated role with the primary key could not be found
	 */
	public DelegatedRole findByPrimaryKey(long roleId)
		throws NoSuchDelegatedRoleException;

	/**
	 * Returns the delegated role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roleId the primary key of the delegated role
	 * @return the delegated role, or <code>null</code> if a delegated role with the primary key could not be found
	 */
	public DelegatedRole fetchByPrimaryKey(long roleId);

	/**
	 * Returns all the delegated roles.
	 *
	 * @return the delegated roles
	 */
	public java.util.List<DelegatedRole> findAll();

	/**
	 * Returns a range of all the delegated roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegatedRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of delegated roles
	 * @param end the upper bound of the range of delegated roles (not inclusive)
	 * @return the range of delegated roles
	 */
	public java.util.List<DelegatedRole> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the delegated roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegatedRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of delegated roles
	 * @param end the upper bound of the range of delegated roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of delegated roles
	 */
	public java.util.List<DelegatedRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DelegatedRole>
			orderByComparator);

	/**
	 * Returns an ordered range of all the delegated roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegatedRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of delegated roles
	 * @param end the upper bound of the range of delegated roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of delegated roles
	 */
	public java.util.List<DelegatedRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DelegatedRole>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the delegated roles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of delegated roles.
	 *
	 * @return the number of delegated roles
	 */
	public int countAll();

}