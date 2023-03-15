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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import cz.csob.ency.delegations.model.DelegatedRole;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the delegated role service. This utility wraps <code>cz.csob.ency.delegations.service.persistence.impl.DelegatedRolePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see DelegatedRolePersistence
 * @generated
 */
public class DelegatedRoleUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(DelegatedRole delegatedRole) {
		getPersistence().clearCache(delegatedRole);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, DelegatedRole> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DelegatedRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DelegatedRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DelegatedRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DelegatedRole> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DelegatedRole update(DelegatedRole delegatedRole) {
		return getPersistence().update(delegatedRole);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DelegatedRole update(
		DelegatedRole delegatedRole, ServiceContext serviceContext) {

		return getPersistence().update(delegatedRole, serviceContext);
	}

	/**
	 * Returns the delegated role where roleId = &#63; or throws a <code>NoSuchDelegatedRoleException</code> if it could not be found.
	 *
	 * @param roleId the role ID
	 * @return the matching delegated role
	 * @throws NoSuchDelegatedRoleException if a matching delegated role could not be found
	 */
	public static DelegatedRole findById(long roleId)
		throws cz.csob.ency.delegations.exception.NoSuchDelegatedRoleException {

		return getPersistence().findById(roleId);
	}

	/**
	 * Returns the delegated role where roleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param roleId the role ID
	 * @return the matching delegated role, or <code>null</code> if a matching delegated role could not be found
	 */
	public static DelegatedRole fetchById(long roleId) {
		return getPersistence().fetchById(roleId);
	}

	/**
	 * Returns the delegated role where roleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param roleId the role ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching delegated role, or <code>null</code> if a matching delegated role could not be found
	 */
	public static DelegatedRole fetchById(long roleId, boolean useFinderCache) {
		return getPersistence().fetchById(roleId, useFinderCache);
	}

	/**
	 * Removes the delegated role where roleId = &#63; from the database.
	 *
	 * @param roleId the role ID
	 * @return the delegated role that was removed
	 */
	public static DelegatedRole removeById(long roleId)
		throws cz.csob.ency.delegations.exception.NoSuchDelegatedRoleException {

		return getPersistence().removeById(roleId);
	}

	/**
	 * Returns the number of delegated roles where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the number of matching delegated roles
	 */
	public static int countById(long roleId) {
		return getPersistence().countById(roleId);
	}

	/**
	 * Returns the delegated role where code = &#63; or throws a <code>NoSuchDelegatedRoleException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching delegated role
	 * @throws NoSuchDelegatedRoleException if a matching delegated role could not be found
	 */
	public static DelegatedRole findByCode(String code)
		throws cz.csob.ency.delegations.exception.NoSuchDelegatedRoleException {

		return getPersistence().findByCode(code);
	}

	/**
	 * Returns the delegated role where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching delegated role, or <code>null</code> if a matching delegated role could not be found
	 */
	public static DelegatedRole fetchByCode(String code) {
		return getPersistence().fetchByCode(code);
	}

	/**
	 * Returns the delegated role where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching delegated role, or <code>null</code> if a matching delegated role could not be found
	 */
	public static DelegatedRole fetchByCode(
		String code, boolean useFinderCache) {

		return getPersistence().fetchByCode(code, useFinderCache);
	}

	/**
	 * Removes the delegated role where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the delegated role that was removed
	 */
	public static DelegatedRole removeByCode(String code)
		throws cz.csob.ency.delegations.exception.NoSuchDelegatedRoleException {

		return getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of delegated roles where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching delegated roles
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the delegated roles where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching delegated roles
	 */
	public static List<DelegatedRole> findByG(long groupId) {
		return getPersistence().findByG(groupId);
	}

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
	public static List<DelegatedRole> findByG(
		long groupId, int start, int end) {

		return getPersistence().findByG(groupId, start, end);
	}

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
	public static List<DelegatedRole> findByG(
		long groupId, int start, int end,
		OrderByComparator<DelegatedRole> orderByComparator) {

		return getPersistence().findByG(groupId, start, end, orderByComparator);
	}

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
	public static List<DelegatedRole> findByG(
		long groupId, int start, int end,
		OrderByComparator<DelegatedRole> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first delegated role in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegated role
	 * @throws NoSuchDelegatedRoleException if a matching delegated role could not be found
	 */
	public static DelegatedRole findByG_First(
			long groupId, OrderByComparator<DelegatedRole> orderByComparator)
		throws cz.csob.ency.delegations.exception.NoSuchDelegatedRoleException {

		return getPersistence().findByG_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first delegated role in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegated role, or <code>null</code> if a matching delegated role could not be found
	 */
	public static DelegatedRole fetchByG_First(
		long groupId, OrderByComparator<DelegatedRole> orderByComparator) {

		return getPersistence().fetchByG_First(groupId, orderByComparator);
	}

	/**
	 * Returns the last delegated role in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegated role
	 * @throws NoSuchDelegatedRoleException if a matching delegated role could not be found
	 */
	public static DelegatedRole findByG_Last(
			long groupId, OrderByComparator<DelegatedRole> orderByComparator)
		throws cz.csob.ency.delegations.exception.NoSuchDelegatedRoleException {

		return getPersistence().findByG_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last delegated role in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegated role, or <code>null</code> if a matching delegated role could not be found
	 */
	public static DelegatedRole fetchByG_Last(
		long groupId, OrderByComparator<DelegatedRole> orderByComparator) {

		return getPersistence().fetchByG_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the delegated roles before and after the current delegated role in the ordered set where groupId = &#63;.
	 *
	 * @param roleId the primary key of the current delegated role
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next delegated role
	 * @throws NoSuchDelegatedRoleException if a delegated role with the primary key could not be found
	 */
	public static DelegatedRole[] findByG_PrevAndNext(
			long roleId, long groupId,
			OrderByComparator<DelegatedRole> orderByComparator)
		throws cz.csob.ency.delegations.exception.NoSuchDelegatedRoleException {

		return getPersistence().findByG_PrevAndNext(
			roleId, groupId, orderByComparator);
	}

	/**
	 * Removes all the delegated roles where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByG(long groupId) {
		getPersistence().removeByG(groupId);
	}

	/**
	 * Returns the number of delegated roles where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching delegated roles
	 */
	public static int countByG(long groupId) {
		return getPersistence().countByG(groupId);
	}

	/**
	 * Caches the delegated role in the entity cache if it is enabled.
	 *
	 * @param delegatedRole the delegated role
	 */
	public static void cacheResult(DelegatedRole delegatedRole) {
		getPersistence().cacheResult(delegatedRole);
	}

	/**
	 * Caches the delegated roles in the entity cache if it is enabled.
	 *
	 * @param delegatedRoles the delegated roles
	 */
	public static void cacheResult(List<DelegatedRole> delegatedRoles) {
		getPersistence().cacheResult(delegatedRoles);
	}

	/**
	 * Creates a new delegated role with the primary key. Does not add the delegated role to the database.
	 *
	 * @param roleId the primary key for the new delegated role
	 * @return the new delegated role
	 */
	public static DelegatedRole create(long roleId) {
		return getPersistence().create(roleId);
	}

	/**
	 * Removes the delegated role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roleId the primary key of the delegated role
	 * @return the delegated role that was removed
	 * @throws NoSuchDelegatedRoleException if a delegated role with the primary key could not be found
	 */
	public static DelegatedRole remove(long roleId)
		throws cz.csob.ency.delegations.exception.NoSuchDelegatedRoleException {

		return getPersistence().remove(roleId);
	}

	public static DelegatedRole updateImpl(DelegatedRole delegatedRole) {
		return getPersistence().updateImpl(delegatedRole);
	}

	/**
	 * Returns the delegated role with the primary key or throws a <code>NoSuchDelegatedRoleException</code> if it could not be found.
	 *
	 * @param roleId the primary key of the delegated role
	 * @return the delegated role
	 * @throws NoSuchDelegatedRoleException if a delegated role with the primary key could not be found
	 */
	public static DelegatedRole findByPrimaryKey(long roleId)
		throws cz.csob.ency.delegations.exception.NoSuchDelegatedRoleException {

		return getPersistence().findByPrimaryKey(roleId);
	}

	/**
	 * Returns the delegated role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roleId the primary key of the delegated role
	 * @return the delegated role, or <code>null</code> if a delegated role with the primary key could not be found
	 */
	public static DelegatedRole fetchByPrimaryKey(long roleId) {
		return getPersistence().fetchByPrimaryKey(roleId);
	}

	/**
	 * Returns all the delegated roles.
	 *
	 * @return the delegated roles
	 */
	public static List<DelegatedRole> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<DelegatedRole> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<DelegatedRole> findAll(
		int start, int end,
		OrderByComparator<DelegatedRole> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<DelegatedRole> findAll(
		int start, int end, OrderByComparator<DelegatedRole> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the delegated roles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of delegated roles.
	 *
	 * @return the number of delegated roles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DelegatedRolePersistence getPersistence() {
		return _persistence;
	}

	private static volatile DelegatedRolePersistence _persistence;

}