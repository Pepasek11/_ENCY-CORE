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

package cz.csob.ency.workflow.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import cz.csob.ency.workflow.exception.NoSuchTransitionException;
import cz.csob.ency.workflow.model.EncyWorkflowTransition;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ency workflow transition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowTransitionUtil
 * @generated
 */
@ProviderType
public interface EncyWorkflowTransitionPersistence
	extends BasePersistence<EncyWorkflowTransition> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EncyWorkflowTransitionUtil} to access the ency workflow transition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ency workflow transitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ency workflow transitions
	 */
	public java.util.List<EncyWorkflowTransition> findByUuid(String uuid);

	/**
	 * Returns a range of all the ency workflow transitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @return the range of matching ency workflow transitions
	 */
	public java.util.List<EncyWorkflowTransition> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the ency workflow transitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow transitions
	 */
	public java.util.List<EncyWorkflowTransition> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowTransition>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflow transitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow transitions
	 */
	public java.util.List<EncyWorkflowTransition> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowTransition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ency workflow transition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	public EncyWorkflowTransition findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException;

	/**
	 * Returns the first ency workflow transition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	public EncyWorkflowTransition fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowTransition>
			orderByComparator);

	/**
	 * Returns the last ency workflow transition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	public EncyWorkflowTransition findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException;

	/**
	 * Returns the last ency workflow transition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	public EncyWorkflowTransition fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowTransition>
			orderByComparator);

	/**
	 * Returns the ency workflow transitions before and after the current ency workflow transition in the ordered set where uuid = &#63;.
	 *
	 * @param transitionId the primary key of the current ency workflow transition
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow transition
	 * @throws NoSuchTransitionException if a ency workflow transition with the primary key could not be found
	 */
	public EncyWorkflowTransition[] findByUuid_PrevAndNext(
			long transitionId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException;

	/**
	 * Removes all the ency workflow transitions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of ency workflow transitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ency workflow transitions
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the ency workflow transition where stateId = &#63; and name = &#63; or throws a <code>NoSuchTransitionException</code> if it could not be found.
	 *
	 * @param stateId the state ID
	 * @param name the name
	 * @return the matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	public EncyWorkflowTransition findByS_N(long stateId, String name)
		throws NoSuchTransitionException;

	/**
	 * Returns the ency workflow transition where stateId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param stateId the state ID
	 * @param name the name
	 * @return the matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	public EncyWorkflowTransition fetchByS_N(long stateId, String name);

	/**
	 * Returns the ency workflow transition where stateId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param stateId the state ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	public EncyWorkflowTransition fetchByS_N(
		long stateId, String name, boolean useFinderCache);

	/**
	 * Removes the ency workflow transition where stateId = &#63; and name = &#63; from the database.
	 *
	 * @param stateId the state ID
	 * @param name the name
	 * @return the ency workflow transition that was removed
	 */
	public EncyWorkflowTransition removeByS_N(long stateId, String name)
		throws NoSuchTransitionException;

	/**
	 * Returns the number of ency workflow transitions where stateId = &#63; and name = &#63;.
	 *
	 * @param stateId the state ID
	 * @param name the name
	 * @return the number of matching ency workflow transitions
	 */
	public int countByS_N(long stateId, String name);

	/**
	 * Returns all the ency workflow transitions where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @return the matching ency workflow transitions
	 */
	public java.util.List<EncyWorkflowTransition> findByWorkflow(
		long workflowId);

	/**
	 * Returns a range of all the ency workflow transitions where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @return the range of matching ency workflow transitions
	 */
	public java.util.List<EncyWorkflowTransition> findByWorkflow(
		long workflowId, int start, int end);

	/**
	 * Returns an ordered range of all the ency workflow transitions where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow transitions
	 */
	public java.util.List<EncyWorkflowTransition> findByWorkflow(
		long workflowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowTransition>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflow transitions where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow transitions
	 */
	public java.util.List<EncyWorkflowTransition> findByWorkflow(
		long workflowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowTransition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ency workflow transition in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	public EncyWorkflowTransition findByWorkflow_First(
			long workflowId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException;

	/**
	 * Returns the first ency workflow transition in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	public EncyWorkflowTransition fetchByWorkflow_First(
		long workflowId,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowTransition>
			orderByComparator);

	/**
	 * Returns the last ency workflow transition in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	public EncyWorkflowTransition findByWorkflow_Last(
			long workflowId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException;

	/**
	 * Returns the last ency workflow transition in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	public EncyWorkflowTransition fetchByWorkflow_Last(
		long workflowId,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowTransition>
			orderByComparator);

	/**
	 * Returns the ency workflow transitions before and after the current ency workflow transition in the ordered set where workflowId = &#63;.
	 *
	 * @param transitionId the primary key of the current ency workflow transition
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow transition
	 * @throws NoSuchTransitionException if a ency workflow transition with the primary key could not be found
	 */
	public EncyWorkflowTransition[] findByWorkflow_PrevAndNext(
			long transitionId, long workflowId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException;

	/**
	 * Removes all the ency workflow transitions where workflowId = &#63; from the database.
	 *
	 * @param workflowId the workflow ID
	 */
	public void removeByWorkflow(long workflowId);

	/**
	 * Returns the number of ency workflow transitions where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @return the number of matching ency workflow transitions
	 */
	public int countByWorkflow(long workflowId);

	/**
	 * Returns all the ency workflow transitions where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the matching ency workflow transitions
	 */
	public java.util.List<EncyWorkflowTransition> findByState(long stateId);

	/**
	 * Returns a range of all the ency workflow transitions where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @return the range of matching ency workflow transitions
	 */
	public java.util.List<EncyWorkflowTransition> findByState(
		long stateId, int start, int end);

	/**
	 * Returns an ordered range of all the ency workflow transitions where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow transitions
	 */
	public java.util.List<EncyWorkflowTransition> findByState(
		long stateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowTransition>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflow transitions where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow transitions
	 */
	public java.util.List<EncyWorkflowTransition> findByState(
		long stateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowTransition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ency workflow transition in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	public EncyWorkflowTransition findByState_First(
			long stateId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException;

	/**
	 * Returns the first ency workflow transition in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	public EncyWorkflowTransition fetchByState_First(
		long stateId,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowTransition>
			orderByComparator);

	/**
	 * Returns the last ency workflow transition in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	public EncyWorkflowTransition findByState_Last(
			long stateId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException;

	/**
	 * Returns the last ency workflow transition in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	public EncyWorkflowTransition fetchByState_Last(
		long stateId,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowTransition>
			orderByComparator);

	/**
	 * Returns the ency workflow transitions before and after the current ency workflow transition in the ordered set where stateId = &#63;.
	 *
	 * @param transitionId the primary key of the current ency workflow transition
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow transition
	 * @throws NoSuchTransitionException if a ency workflow transition with the primary key could not be found
	 */
	public EncyWorkflowTransition[] findByState_PrevAndNext(
			long transitionId, long stateId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException;

	/**
	 * Removes all the ency workflow transitions where stateId = &#63; from the database.
	 *
	 * @param stateId the state ID
	 */
	public void removeByState(long stateId);

	/**
	 * Returns the number of ency workflow transitions where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the number of matching ency workflow transitions
	 */
	public int countByState(long stateId);

	/**
	 * Returns all the ency workflow transitions where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching ency workflow transitions
	 */
	public java.util.List<EncyWorkflowTransition> findByActive(Boolean active);

	/**
	 * Returns a range of all the ency workflow transitions where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @return the range of matching ency workflow transitions
	 */
	public java.util.List<EncyWorkflowTransition> findByActive(
		Boolean active, int start, int end);

	/**
	 * Returns an ordered range of all the ency workflow transitions where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow transitions
	 */
	public java.util.List<EncyWorkflowTransition> findByActive(
		Boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowTransition>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflow transitions where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow transitions
	 */
	public java.util.List<EncyWorkflowTransition> findByActive(
		Boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowTransition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ency workflow transition in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	public EncyWorkflowTransition findByActive_First(
			Boolean active,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException;

	/**
	 * Returns the first ency workflow transition in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	public EncyWorkflowTransition fetchByActive_First(
		Boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowTransition>
			orderByComparator);

	/**
	 * Returns the last ency workflow transition in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	public EncyWorkflowTransition findByActive_Last(
			Boolean active,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException;

	/**
	 * Returns the last ency workflow transition in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	public EncyWorkflowTransition fetchByActive_Last(
		Boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowTransition>
			orderByComparator);

	/**
	 * Returns the ency workflow transitions before and after the current ency workflow transition in the ordered set where active = &#63;.
	 *
	 * @param transitionId the primary key of the current ency workflow transition
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow transition
	 * @throws NoSuchTransitionException if a ency workflow transition with the primary key could not be found
	 */
	public EncyWorkflowTransition[] findByActive_PrevAndNext(
			long transitionId, Boolean active,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException;

	/**
	 * Removes all the ency workflow transitions where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public void removeByActive(Boolean active);

	/**
	 * Returns the number of ency workflow transitions where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching ency workflow transitions
	 */
	public int countByActive(Boolean active);

	/**
	 * Caches the ency workflow transition in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowTransition the ency workflow transition
	 */
	public void cacheResult(EncyWorkflowTransition encyWorkflowTransition);

	/**
	 * Caches the ency workflow transitions in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowTransitions the ency workflow transitions
	 */
	public void cacheResult(
		java.util.List<EncyWorkflowTransition> encyWorkflowTransitions);

	/**
	 * Creates a new ency workflow transition with the primary key. Does not add the ency workflow transition to the database.
	 *
	 * @param transitionId the primary key for the new ency workflow transition
	 * @return the new ency workflow transition
	 */
	public EncyWorkflowTransition create(long transitionId);

	/**
	 * Removes the ency workflow transition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transitionId the primary key of the ency workflow transition
	 * @return the ency workflow transition that was removed
	 * @throws NoSuchTransitionException if a ency workflow transition with the primary key could not be found
	 */
	public EncyWorkflowTransition remove(long transitionId)
		throws NoSuchTransitionException;

	public EncyWorkflowTransition updateImpl(
		EncyWorkflowTransition encyWorkflowTransition);

	/**
	 * Returns the ency workflow transition with the primary key or throws a <code>NoSuchTransitionException</code> if it could not be found.
	 *
	 * @param transitionId the primary key of the ency workflow transition
	 * @return the ency workflow transition
	 * @throws NoSuchTransitionException if a ency workflow transition with the primary key could not be found
	 */
	public EncyWorkflowTransition findByPrimaryKey(long transitionId)
		throws NoSuchTransitionException;

	/**
	 * Returns the ency workflow transition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param transitionId the primary key of the ency workflow transition
	 * @return the ency workflow transition, or <code>null</code> if a ency workflow transition with the primary key could not be found
	 */
	public EncyWorkflowTransition fetchByPrimaryKey(long transitionId);

	/**
	 * Returns all the ency workflow transitions.
	 *
	 * @return the ency workflow transitions
	 */
	public java.util.List<EncyWorkflowTransition> findAll();

	/**
	 * Returns a range of all the ency workflow transitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @return the range of ency workflow transitions
	 */
	public java.util.List<EncyWorkflowTransition> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ency workflow transitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ency workflow transitions
	 */
	public java.util.List<EncyWorkflowTransition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowTransition>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflow transitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ency workflow transitions
	 */
	public java.util.List<EncyWorkflowTransition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowTransition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ency workflow transitions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ency workflow transitions.
	 *
	 * @return the number of ency workflow transitions
	 */
	public int countAll();

}