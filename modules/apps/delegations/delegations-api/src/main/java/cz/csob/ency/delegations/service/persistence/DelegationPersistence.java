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

import cz.csob.ency.delegations.exception.NoSuchDelegationException;
import cz.csob.ency.delegations.model.Delegation;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the delegation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see DelegationUtil
 * @generated
 */
@ProviderType
public interface DelegationPersistence extends BasePersistence<Delegation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DelegationUtil} to access the delegation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the delegation where delegationId = &#63; or throws a <code>NoSuchDelegationException</code> if it could not be found.
	 *
	 * @param delegationId the delegation ID
	 * @return the matching delegation
	 * @throws NoSuchDelegationException if a matching delegation could not be found
	 */
	public Delegation findById(long delegationId)
		throws NoSuchDelegationException;

	/**
	 * Returns the delegation where delegationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param delegationId the delegation ID
	 * @return the matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	public Delegation fetchById(long delegationId);

	/**
	 * Returns the delegation where delegationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param delegationId the delegation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	public Delegation fetchById(long delegationId, boolean useFinderCache);

	/**
	 * Removes the delegation where delegationId = &#63; from the database.
	 *
	 * @param delegationId the delegation ID
	 * @return the delegation that was removed
	 */
	public Delegation removeById(long delegationId)
		throws NoSuchDelegationException;

	/**
	 * Returns the number of delegations where delegationId = &#63;.
	 *
	 * @param delegationId the delegation ID
	 * @return the number of matching delegations
	 */
	public int countById(long delegationId);

	/**
	 * Returns all the delegations where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @return the matching delegations
	 */
	public java.util.List<Delegation> findByG_R(long groupId, long roleId);

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
	public java.util.List<Delegation> findByG_R(
		long groupId, long roleId, int start, int end);

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
	public java.util.List<Delegation> findByG_R(
		long groupId, long roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Delegation>
			orderByComparator);

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
	public java.util.List<Delegation> findByG_R(
		long groupId, long roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Delegation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first delegation in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegation
	 * @throws NoSuchDelegationException if a matching delegation could not be found
	 */
	public Delegation findByG_R_First(
			long groupId, long roleId,
			com.liferay.portal.kernel.util.OrderByComparator<Delegation>
				orderByComparator)
		throws NoSuchDelegationException;

	/**
	 * Returns the first delegation in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	public Delegation fetchByG_R_First(
		long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator<Delegation>
			orderByComparator);

	/**
	 * Returns the last delegation in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegation
	 * @throws NoSuchDelegationException if a matching delegation could not be found
	 */
	public Delegation findByG_R_Last(
			long groupId, long roleId,
			com.liferay.portal.kernel.util.OrderByComparator<Delegation>
				orderByComparator)
		throws NoSuchDelegationException;

	/**
	 * Returns the last delegation in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	public Delegation fetchByG_R_Last(
		long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator<Delegation>
			orderByComparator);

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
	public Delegation[] findByG_R_PrevAndNext(
			long delegationId, long groupId, long roleId,
			com.liferay.portal.kernel.util.OrderByComparator<Delegation>
				orderByComparator)
		throws NoSuchDelegationException;

	/**
	 * Removes all the delegations where groupId = &#63; and roleId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 */
	public void removeByG_R(long groupId, long roleId);

	/**
	 * Returns the number of delegations where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @return the number of matching delegations
	 */
	public int countByG_R(long groupId, long roleId);

	/**
	 * Returns all the delegations where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @return the matching delegations
	 */
	public java.util.List<Delegation> findByG_R_Delegating(
		long groupId, long roleId, long delegatingUserId);

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
	public java.util.List<Delegation> findByG_R_Delegating(
		long groupId, long roleId, long delegatingUserId, int start, int end);

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
	public java.util.List<Delegation> findByG_R_Delegating(
		long groupId, long roleId, long delegatingUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Delegation>
			orderByComparator);

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
	public java.util.List<Delegation> findByG_R_Delegating(
		long groupId, long roleId, long delegatingUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Delegation>
			orderByComparator,
		boolean useFinderCache);

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
	public Delegation findByG_R_Delegating_First(
			long groupId, long roleId, long delegatingUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Delegation>
				orderByComparator)
		throws NoSuchDelegationException;

	/**
	 * Returns the first delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	public Delegation fetchByG_R_Delegating_First(
		long groupId, long roleId, long delegatingUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Delegation>
			orderByComparator);

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
	public Delegation findByG_R_Delegating_Last(
			long groupId, long roleId, long delegatingUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Delegation>
				orderByComparator)
		throws NoSuchDelegationException;

	/**
	 * Returns the last delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	public Delegation fetchByG_R_Delegating_Last(
		long groupId, long roleId, long delegatingUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Delegation>
			orderByComparator);

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
	public Delegation[] findByG_R_Delegating_PrevAndNext(
			long delegationId, long groupId, long roleId, long delegatingUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Delegation>
				orderByComparator)
		throws NoSuchDelegationException;

	/**
	 * Removes all the delegations where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 */
	public void removeByG_R_Delegating(
		long groupId, long roleId, long delegatingUserId);

	/**
	 * Returns the number of delegations where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @return the number of matching delegations
	 */
	public int countByG_R_Delegating(
		long groupId, long roleId, long delegatingUserId);

	/**
	 * Returns all the delegations where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @return the matching delegations
	 */
	public java.util.List<Delegation> findByG_R_Delegated(
		long groupId, long roleId, long delegatedUserId);

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
	public java.util.List<Delegation> findByG_R_Delegated(
		long groupId, long roleId, long delegatedUserId, int start, int end);

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
	public java.util.List<Delegation> findByG_R_Delegated(
		long groupId, long roleId, long delegatedUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Delegation>
			orderByComparator);

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
	public java.util.List<Delegation> findByG_R_Delegated(
		long groupId, long roleId, long delegatedUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Delegation>
			orderByComparator,
		boolean useFinderCache);

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
	public Delegation findByG_R_Delegated_First(
			long groupId, long roleId, long delegatedUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Delegation>
				orderByComparator)
		throws NoSuchDelegationException;

	/**
	 * Returns the first delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	public Delegation fetchByG_R_Delegated_First(
		long groupId, long roleId, long delegatedUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Delegation>
			orderByComparator);

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
	public Delegation findByG_R_Delegated_Last(
			long groupId, long roleId, long delegatedUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Delegation>
				orderByComparator)
		throws NoSuchDelegationException;

	/**
	 * Returns the last delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	public Delegation fetchByG_R_Delegated_Last(
		long groupId, long roleId, long delegatedUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Delegation>
			orderByComparator);

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
	public Delegation[] findByG_R_Delegated_PrevAndNext(
			long delegationId, long groupId, long roleId, long delegatedUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Delegation>
				orderByComparator)
		throws NoSuchDelegationException;

	/**
	 * Removes all the delegations where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 */
	public void removeByG_R_Delegated(
		long groupId, long roleId, long delegatedUserId);

	/**
	 * Returns the number of delegations where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @return the number of matching delegations
	 */
	public int countByG_R_Delegated(
		long groupId, long roleId, long delegatedUserId);

	/**
	 * Returns all the delegations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching delegations
	 */
	public java.util.List<Delegation> findByG(long groupId);

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
	public java.util.List<Delegation> findByG(long groupId, int start, int end);

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
	public java.util.List<Delegation> findByG(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Delegation>
			orderByComparator);

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
	public java.util.List<Delegation> findByG(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Delegation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first delegation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegation
	 * @throws NoSuchDelegationException if a matching delegation could not be found
	 */
	public Delegation findByG_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Delegation>
				orderByComparator)
		throws NoSuchDelegationException;

	/**
	 * Returns the first delegation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	public Delegation fetchByG_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Delegation>
			orderByComparator);

	/**
	 * Returns the last delegation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegation
	 * @throws NoSuchDelegationException if a matching delegation could not be found
	 */
	public Delegation findByG_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Delegation>
				orderByComparator)
		throws NoSuchDelegationException;

	/**
	 * Returns the last delegation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	public Delegation fetchByG_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Delegation>
			orderByComparator);

	/**
	 * Returns the delegations before and after the current delegation in the ordered set where groupId = &#63;.
	 *
	 * @param delegationId the primary key of the current delegation
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next delegation
	 * @throws NoSuchDelegationException if a delegation with the primary key could not be found
	 */
	public Delegation[] findByG_PrevAndNext(
			long delegationId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Delegation>
				orderByComparator)
		throws NoSuchDelegationException;

	/**
	 * Removes all the delegations where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByG(long groupId);

	/**
	 * Returns the number of delegations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching delegations
	 */
	public int countByG(long groupId);

	/**
	 * Caches the delegation in the entity cache if it is enabled.
	 *
	 * @param delegation the delegation
	 */
	public void cacheResult(Delegation delegation);

	/**
	 * Caches the delegations in the entity cache if it is enabled.
	 *
	 * @param delegations the delegations
	 */
	public void cacheResult(java.util.List<Delegation> delegations);

	/**
	 * Creates a new delegation with the primary key. Does not add the delegation to the database.
	 *
	 * @param delegationId the primary key for the new delegation
	 * @return the new delegation
	 */
	public Delegation create(long delegationId);

	/**
	 * Removes the delegation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param delegationId the primary key of the delegation
	 * @return the delegation that was removed
	 * @throws NoSuchDelegationException if a delegation with the primary key could not be found
	 */
	public Delegation remove(long delegationId)
		throws NoSuchDelegationException;

	public Delegation updateImpl(Delegation delegation);

	/**
	 * Returns the delegation with the primary key or throws a <code>NoSuchDelegationException</code> if it could not be found.
	 *
	 * @param delegationId the primary key of the delegation
	 * @return the delegation
	 * @throws NoSuchDelegationException if a delegation with the primary key could not be found
	 */
	public Delegation findByPrimaryKey(long delegationId)
		throws NoSuchDelegationException;

	/**
	 * Returns the delegation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param delegationId the primary key of the delegation
	 * @return the delegation, or <code>null</code> if a delegation with the primary key could not be found
	 */
	public Delegation fetchByPrimaryKey(long delegationId);

	/**
	 * Returns all the delegations.
	 *
	 * @return the delegations
	 */
	public java.util.List<Delegation> findAll();

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
	public java.util.List<Delegation> findAll(int start, int end);

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
	public java.util.List<Delegation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Delegation>
			orderByComparator);

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
	public java.util.List<Delegation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Delegation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the delegations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of delegations.
	 *
	 * @return the number of delegations
	 */
	public int countAll();

}