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

import cz.csob.ency.delegations.model.Delegation;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the delegation service. This utility wraps <code>cz.csob.ency.delegations.service.persistence.impl.DelegationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see DelegationPersistence
 * @generated
 */
public class DelegationUtil {

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
	public static void clearCache(Delegation delegation) {
		getPersistence().clearCache(delegation);
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
	public static Map<Serializable, Delegation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Delegation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Delegation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Delegation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Delegation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Delegation update(Delegation delegation) {
		return getPersistence().update(delegation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Delegation update(
		Delegation delegation, ServiceContext serviceContext) {

		return getPersistence().update(delegation, serviceContext);
	}

	/**
	 * Returns the delegation where delegationId = &#63; or throws a <code>NoSuchDelegationException</code> if it could not be found.
	 *
	 * @param delegationId the delegation ID
	 * @return the matching delegation
	 * @throws NoSuchDelegationException if a matching delegation could not be found
	 */
	public static Delegation findById(long delegationId)
		throws cz.csob.ency.delegations.exception.NoSuchDelegationException {

		return getPersistence().findById(delegationId);
	}

	/**
	 * Returns the delegation where delegationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param delegationId the delegation ID
	 * @return the matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	public static Delegation fetchById(long delegationId) {
		return getPersistence().fetchById(delegationId);
	}

	/**
	 * Returns the delegation where delegationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param delegationId the delegation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	public static Delegation fetchById(
		long delegationId, boolean useFinderCache) {

		return getPersistence().fetchById(delegationId, useFinderCache);
	}

	/**
	 * Removes the delegation where delegationId = &#63; from the database.
	 *
	 * @param delegationId the delegation ID
	 * @return the delegation that was removed
	 */
	public static Delegation removeById(long delegationId)
		throws cz.csob.ency.delegations.exception.NoSuchDelegationException {

		return getPersistence().removeById(delegationId);
	}

	/**
	 * Returns the number of delegations where delegationId = &#63;.
	 *
	 * @param delegationId the delegation ID
	 * @return the number of matching delegations
	 */
	public static int countById(long delegationId) {
		return getPersistence().countById(delegationId);
	}

	/**
	 * Returns all the delegations where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @return the matching delegations
	 */
	public static List<Delegation> findByG_R(long groupId, long roleId) {
		return getPersistence().findByG_R(groupId, roleId);
	}

	/**
	 * Returns a range of all the delegations where groupId = &#63; and roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @return the range of matching delegations
	 */
	public static List<Delegation> findByG_R(
		long groupId, long roleId, int start, int end) {

		return getPersistence().findByG_R(groupId, roleId, start, end);
	}

	/**
	 * Returns an ordered range of all the delegations where groupId = &#63; and roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching delegations
	 */
	public static List<Delegation> findByG_R(
		long groupId, long roleId, int start, int end,
		OrderByComparator<Delegation> orderByComparator) {

		return getPersistence().findByG_R(
			groupId, roleId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the delegations where groupId = &#63; and roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching delegations
	 */
	public static List<Delegation> findByG_R(
		long groupId, long roleId, int start, int end,
		OrderByComparator<Delegation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_R(
			groupId, roleId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first delegation in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegation
	 * @throws NoSuchDelegationException if a matching delegation could not be found
	 */
	public static Delegation findByG_R_First(
			long groupId, long roleId,
			OrderByComparator<Delegation> orderByComparator)
		throws cz.csob.ency.delegations.exception.NoSuchDelegationException {

		return getPersistence().findByG_R_First(
			groupId, roleId, orderByComparator);
	}

	/**
	 * Returns the first delegation in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	public static Delegation fetchByG_R_First(
		long groupId, long roleId,
		OrderByComparator<Delegation> orderByComparator) {

		return getPersistence().fetchByG_R_First(
			groupId, roleId, orderByComparator);
	}

	/**
	 * Returns the last delegation in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegation
	 * @throws NoSuchDelegationException if a matching delegation could not be found
	 */
	public static Delegation findByG_R_Last(
			long groupId, long roleId,
			OrderByComparator<Delegation> orderByComparator)
		throws cz.csob.ency.delegations.exception.NoSuchDelegationException {

		return getPersistence().findByG_R_Last(
			groupId, roleId, orderByComparator);
	}

	/**
	 * Returns the last delegation in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	public static Delegation fetchByG_R_Last(
		long groupId, long roleId,
		OrderByComparator<Delegation> orderByComparator) {

		return getPersistence().fetchByG_R_Last(
			groupId, roleId, orderByComparator);
	}

	/**
	 * Returns the delegations before and after the current delegation in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param delegationId the primary key of the current delegation
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next delegation
	 * @throws NoSuchDelegationException if a delegation with the primary key could not be found
	 */
	public static Delegation[] findByG_R_PrevAndNext(
			long delegationId, long groupId, long roleId,
			OrderByComparator<Delegation> orderByComparator)
		throws cz.csob.ency.delegations.exception.NoSuchDelegationException {

		return getPersistence().findByG_R_PrevAndNext(
			delegationId, groupId, roleId, orderByComparator);
	}

	/**
	 * Removes all the delegations where groupId = &#63; and roleId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 */
	public static void removeByG_R(long groupId, long roleId) {
		getPersistence().removeByG_R(groupId, roleId);
	}

	/**
	 * Returns the number of delegations where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @return the number of matching delegations
	 */
	public static int countByG_R(long groupId, long roleId) {
		return getPersistence().countByG_R(groupId, roleId);
	}

	/**
	 * Returns all the delegations where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @return the matching delegations
	 */
	public static List<Delegation> findByG_R_Delegating(
		long groupId, long roleId, long delegatingUserId) {

		return getPersistence().findByG_R_Delegating(
			groupId, roleId, delegatingUserId);
	}

	/**
	 * Returns a range of all the delegations where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @return the range of matching delegations
	 */
	public static List<Delegation> findByG_R_Delegating(
		long groupId, long roleId, long delegatingUserId, int start, int end) {

		return getPersistence().findByG_R_Delegating(
			groupId, roleId, delegatingUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the delegations where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching delegations
	 */
	public static List<Delegation> findByG_R_Delegating(
		long groupId, long roleId, long delegatingUserId, int start, int end,
		OrderByComparator<Delegation> orderByComparator) {

		return getPersistence().findByG_R_Delegating(
			groupId, roleId, delegatingUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the delegations where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching delegations
	 */
	public static List<Delegation> findByG_R_Delegating(
		long groupId, long roleId, long delegatingUserId, int start, int end,
		OrderByComparator<Delegation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_R_Delegating(
			groupId, roleId, delegatingUserId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegation
	 * @throws NoSuchDelegationException if a matching delegation could not be found
	 */
	public static Delegation findByG_R_Delegating_First(
			long groupId, long roleId, long delegatingUserId,
			OrderByComparator<Delegation> orderByComparator)
		throws cz.csob.ency.delegations.exception.NoSuchDelegationException {

		return getPersistence().findByG_R_Delegating_First(
			groupId, roleId, delegatingUserId, orderByComparator);
	}

	/**
	 * Returns the first delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	public static Delegation fetchByG_R_Delegating_First(
		long groupId, long roleId, long delegatingUserId,
		OrderByComparator<Delegation> orderByComparator) {

		return getPersistence().fetchByG_R_Delegating_First(
			groupId, roleId, delegatingUserId, orderByComparator);
	}

	/**
	 * Returns the last delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegation
	 * @throws NoSuchDelegationException if a matching delegation could not be found
	 */
	public static Delegation findByG_R_Delegating_Last(
			long groupId, long roleId, long delegatingUserId,
			OrderByComparator<Delegation> orderByComparator)
		throws cz.csob.ency.delegations.exception.NoSuchDelegationException {

		return getPersistence().findByG_R_Delegating_Last(
			groupId, roleId, delegatingUserId, orderByComparator);
	}

	/**
	 * Returns the last delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	public static Delegation fetchByG_R_Delegating_Last(
		long groupId, long roleId, long delegatingUserId,
		OrderByComparator<Delegation> orderByComparator) {

		return getPersistence().fetchByG_R_Delegating_Last(
			groupId, roleId, delegatingUserId, orderByComparator);
	}

	/**
	 * Returns the delegations before and after the current delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * @param delegationId the primary key of the current delegation
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next delegation
	 * @throws NoSuchDelegationException if a delegation with the primary key could not be found
	 */
	public static Delegation[] findByG_R_Delegating_PrevAndNext(
			long delegationId, long groupId, long roleId, long delegatingUserId,
			OrderByComparator<Delegation> orderByComparator)
		throws cz.csob.ency.delegations.exception.NoSuchDelegationException {

		return getPersistence().findByG_R_Delegating_PrevAndNext(
			delegationId, groupId, roleId, delegatingUserId, orderByComparator);
	}

	/**
	 * Removes all the delegations where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 */
	public static void removeByG_R_Delegating(
		long groupId, long roleId, long delegatingUserId) {

		getPersistence().removeByG_R_Delegating(
			groupId, roleId, delegatingUserId);
	}

	/**
	 * Returns the number of delegations where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @return the number of matching delegations
	 */
	public static int countByG_R_Delegating(
		long groupId, long roleId, long delegatingUserId) {

		return getPersistence().countByG_R_Delegating(
			groupId, roleId, delegatingUserId);
	}

	/**
	 * Returns all the delegations where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @return the matching delegations
	 */
	public static List<Delegation> findByG_R_Delegated(
		long groupId, long roleId, long delegatedUserId) {

		return getPersistence().findByG_R_Delegated(
			groupId, roleId, delegatedUserId);
	}

	/**
	 * Returns a range of all the delegations where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @return the range of matching delegations
	 */
	public static List<Delegation> findByG_R_Delegated(
		long groupId, long roleId, long delegatedUserId, int start, int end) {

		return getPersistence().findByG_R_Delegated(
			groupId, roleId, delegatedUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the delegations where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching delegations
	 */
	public static List<Delegation> findByG_R_Delegated(
		long groupId, long roleId, long delegatedUserId, int start, int end,
		OrderByComparator<Delegation> orderByComparator) {

		return getPersistence().findByG_R_Delegated(
			groupId, roleId, delegatedUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the delegations where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching delegations
	 */
	public static List<Delegation> findByG_R_Delegated(
		long groupId, long roleId, long delegatedUserId, int start, int end,
		OrderByComparator<Delegation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_R_Delegated(
			groupId, roleId, delegatedUserId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegation
	 * @throws NoSuchDelegationException if a matching delegation could not be found
	 */
	public static Delegation findByG_R_Delegated_First(
			long groupId, long roleId, long delegatedUserId,
			OrderByComparator<Delegation> orderByComparator)
		throws cz.csob.ency.delegations.exception.NoSuchDelegationException {

		return getPersistence().findByG_R_Delegated_First(
			groupId, roleId, delegatedUserId, orderByComparator);
	}

	/**
	 * Returns the first delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	public static Delegation fetchByG_R_Delegated_First(
		long groupId, long roleId, long delegatedUserId,
		OrderByComparator<Delegation> orderByComparator) {

		return getPersistence().fetchByG_R_Delegated_First(
			groupId, roleId, delegatedUserId, orderByComparator);
	}

	/**
	 * Returns the last delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegation
	 * @throws NoSuchDelegationException if a matching delegation could not be found
	 */
	public static Delegation findByG_R_Delegated_Last(
			long groupId, long roleId, long delegatedUserId,
			OrderByComparator<Delegation> orderByComparator)
		throws cz.csob.ency.delegations.exception.NoSuchDelegationException {

		return getPersistence().findByG_R_Delegated_Last(
			groupId, roleId, delegatedUserId, orderByComparator);
	}

	/**
	 * Returns the last delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	public static Delegation fetchByG_R_Delegated_Last(
		long groupId, long roleId, long delegatedUserId,
		OrderByComparator<Delegation> orderByComparator) {

		return getPersistence().fetchByG_R_Delegated_Last(
			groupId, roleId, delegatedUserId, orderByComparator);
	}

	/**
	 * Returns the delegations before and after the current delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * @param delegationId the primary key of the current delegation
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next delegation
	 * @throws NoSuchDelegationException if a delegation with the primary key could not be found
	 */
	public static Delegation[] findByG_R_Delegated_PrevAndNext(
			long delegationId, long groupId, long roleId, long delegatedUserId,
			OrderByComparator<Delegation> orderByComparator)
		throws cz.csob.ency.delegations.exception.NoSuchDelegationException {

		return getPersistence().findByG_R_Delegated_PrevAndNext(
			delegationId, groupId, roleId, delegatedUserId, orderByComparator);
	}

	/**
	 * Removes all the delegations where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 */
	public static void removeByG_R_Delegated(
		long groupId, long roleId, long delegatedUserId) {

		getPersistence().removeByG_R_Delegated(
			groupId, roleId, delegatedUserId);
	}

	/**
	 * Returns the number of delegations where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @return the number of matching delegations
	 */
	public static int countByG_R_Delegated(
		long groupId, long roleId, long delegatedUserId) {

		return getPersistence().countByG_R_Delegated(
			groupId, roleId, delegatedUserId);
	}

	/**
	 * Returns all the delegations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching delegations
	 */
	public static List<Delegation> findByG(long groupId) {
		return getPersistence().findByG(groupId);
	}

	/**
	 * Returns a range of all the delegations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @return the range of matching delegations
	 */
	public static List<Delegation> findByG(long groupId, int start, int end) {
		return getPersistence().findByG(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the delegations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching delegations
	 */
	public static List<Delegation> findByG(
		long groupId, int start, int end,
		OrderByComparator<Delegation> orderByComparator) {

		return getPersistence().findByG(groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the delegations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching delegations
	 */
	public static List<Delegation> findByG(
		long groupId, int start, int end,
		OrderByComparator<Delegation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first delegation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegation
	 * @throws NoSuchDelegationException if a matching delegation could not be found
	 */
	public static Delegation findByG_First(
			long groupId, OrderByComparator<Delegation> orderByComparator)
		throws cz.csob.ency.delegations.exception.NoSuchDelegationException {

		return getPersistence().findByG_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first delegation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	public static Delegation fetchByG_First(
		long groupId, OrderByComparator<Delegation> orderByComparator) {

		return getPersistence().fetchByG_First(groupId, orderByComparator);
	}

	/**
	 * Returns the last delegation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegation
	 * @throws NoSuchDelegationException if a matching delegation could not be found
	 */
	public static Delegation findByG_Last(
			long groupId, OrderByComparator<Delegation> orderByComparator)
		throws cz.csob.ency.delegations.exception.NoSuchDelegationException {

		return getPersistence().findByG_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last delegation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	public static Delegation fetchByG_Last(
		long groupId, OrderByComparator<Delegation> orderByComparator) {

		return getPersistence().fetchByG_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the delegations before and after the current delegation in the ordered set where groupId = &#63;.
	 *
	 * @param delegationId the primary key of the current delegation
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next delegation
	 * @throws NoSuchDelegationException if a delegation with the primary key could not be found
	 */
	public static Delegation[] findByG_PrevAndNext(
			long delegationId, long groupId,
			OrderByComparator<Delegation> orderByComparator)
		throws cz.csob.ency.delegations.exception.NoSuchDelegationException {

		return getPersistence().findByG_PrevAndNext(
			delegationId, groupId, orderByComparator);
	}

	/**
	 * Removes all the delegations where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByG(long groupId) {
		getPersistence().removeByG(groupId);
	}

	/**
	 * Returns the number of delegations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching delegations
	 */
	public static int countByG(long groupId) {
		return getPersistence().countByG(groupId);
	}

	/**
	 * Caches the delegation in the entity cache if it is enabled.
	 *
	 * @param delegation the delegation
	 */
	public static void cacheResult(Delegation delegation) {
		getPersistence().cacheResult(delegation);
	}

	/**
	 * Caches the delegations in the entity cache if it is enabled.
	 *
	 * @param delegations the delegations
	 */
	public static void cacheResult(List<Delegation> delegations) {
		getPersistence().cacheResult(delegations);
	}

	/**
	 * Creates a new delegation with the primary key. Does not add the delegation to the database.
	 *
	 * @param delegationId the primary key for the new delegation
	 * @return the new delegation
	 */
	public static Delegation create(long delegationId) {
		return getPersistence().create(delegationId);
	}

	/**
	 * Removes the delegation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param delegationId the primary key of the delegation
	 * @return the delegation that was removed
	 * @throws NoSuchDelegationException if a delegation with the primary key could not be found
	 */
	public static Delegation remove(long delegationId)
		throws cz.csob.ency.delegations.exception.NoSuchDelegationException {

		return getPersistence().remove(delegationId);
	}

	public static Delegation updateImpl(Delegation delegation) {
		return getPersistence().updateImpl(delegation);
	}

	/**
	 * Returns the delegation with the primary key or throws a <code>NoSuchDelegationException</code> if it could not be found.
	 *
	 * @param delegationId the primary key of the delegation
	 * @return the delegation
	 * @throws NoSuchDelegationException if a delegation with the primary key could not be found
	 */
	public static Delegation findByPrimaryKey(long delegationId)
		throws cz.csob.ency.delegations.exception.NoSuchDelegationException {

		return getPersistence().findByPrimaryKey(delegationId);
	}

	/**
	 * Returns the delegation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param delegationId the primary key of the delegation
	 * @return the delegation, or <code>null</code> if a delegation with the primary key could not be found
	 */
	public static Delegation fetchByPrimaryKey(long delegationId) {
		return getPersistence().fetchByPrimaryKey(delegationId);
	}

	/**
	 * Returns all the delegations.
	 *
	 * @return the delegations
	 */
	public static List<Delegation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @return the range of delegations
	 */
	public static List<Delegation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of delegations
	 */
	public static List<Delegation> findAll(
		int start, int end, OrderByComparator<Delegation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of delegations
	 */
	public static List<Delegation> findAll(
		int start, int end, OrderByComparator<Delegation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the delegations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of delegations.
	 *
	 * @return the number of delegations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DelegationPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DelegationPersistence _persistence;

}