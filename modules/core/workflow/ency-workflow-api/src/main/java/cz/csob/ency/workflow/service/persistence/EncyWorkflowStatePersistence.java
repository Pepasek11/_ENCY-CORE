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

import cz.csob.ency.workflow.exception.NoSuchStateException;
import cz.csob.ency.workflow.model.EncyWorkflowState;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ency workflow state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowStateUtil
 * @generated
 */
@ProviderType
public interface EncyWorkflowStatePersistence
	extends BasePersistence<EncyWorkflowState> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EncyWorkflowStateUtil} to access the ency workflow state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ency workflow states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ency workflow states
	 */
	public java.util.List<EncyWorkflowState> findByUuid(String uuid);

	/**
	 * Returns a range of all the ency workflow states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @return the range of matching ency workflow states
	 */
	public java.util.List<EncyWorkflowState> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the ency workflow states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow states
	 */
	public java.util.List<EncyWorkflowState> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowState>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflow states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow states
	 */
	public java.util.List<EncyWorkflowState> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowState>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ency workflow state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state
	 * @throws NoSuchStateException if a matching ency workflow state could not be found
	 */
	public EncyWorkflowState findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowState>
				orderByComparator)
		throws NoSuchStateException;

	/**
	 * Returns the first ency workflow state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	public EncyWorkflowState fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowState>
			orderByComparator);

	/**
	 * Returns the last ency workflow state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state
	 * @throws NoSuchStateException if a matching ency workflow state could not be found
	 */
	public EncyWorkflowState findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowState>
				orderByComparator)
		throws NoSuchStateException;

	/**
	 * Returns the last ency workflow state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	public EncyWorkflowState fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowState>
			orderByComparator);

	/**
	 * Returns the ency workflow states before and after the current ency workflow state in the ordered set where uuid = &#63;.
	 *
	 * @param stateId the primary key of the current ency workflow state
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow state
	 * @throws NoSuchStateException if a ency workflow state with the primary key could not be found
	 */
	public EncyWorkflowState[] findByUuid_PrevAndNext(
			long stateId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowState>
				orderByComparator)
		throws NoSuchStateException;

	/**
	 * Removes all the ency workflow states where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of ency workflow states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ency workflow states
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the ency workflow state where workflowId = &#63; and name = &#63; or throws a <code>NoSuchStateException</code> if it could not be found.
	 *
	 * @param workflowId the workflow ID
	 * @param name the name
	 * @return the matching ency workflow state
	 * @throws NoSuchStateException if a matching ency workflow state could not be found
	 */
	public EncyWorkflowState findByW_N(long workflowId, String name)
		throws NoSuchStateException;

	/**
	 * Returns the ency workflow state where workflowId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param workflowId the workflow ID
	 * @param name the name
	 * @return the matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	public EncyWorkflowState fetchByW_N(long workflowId, String name);

	/**
	 * Returns the ency workflow state where workflowId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param workflowId the workflow ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	public EncyWorkflowState fetchByW_N(
		long workflowId, String name, boolean useFinderCache);

	/**
	 * Removes the ency workflow state where workflowId = &#63; and name = &#63; from the database.
	 *
	 * @param workflowId the workflow ID
	 * @param name the name
	 * @return the ency workflow state that was removed
	 */
	public EncyWorkflowState removeByW_N(long workflowId, String name)
		throws NoSuchStateException;

	/**
	 * Returns the number of ency workflow states where workflowId = &#63; and name = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param name the name
	 * @return the number of matching ency workflow states
	 */
	public int countByW_N(long workflowId, String name);

	/**
	 * Returns all the ency workflow states where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @return the matching ency workflow states
	 */
	public java.util.List<EncyWorkflowState> findByWorkflow(long workflowId);

	/**
	 * Returns a range of all the ency workflow states where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @return the range of matching ency workflow states
	 */
	public java.util.List<EncyWorkflowState> findByWorkflow(
		long workflowId, int start, int end);

	/**
	 * Returns an ordered range of all the ency workflow states where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow states
	 */
	public java.util.List<EncyWorkflowState> findByWorkflow(
		long workflowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowState>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflow states where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow states
	 */
	public java.util.List<EncyWorkflowState> findByWorkflow(
		long workflowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowState>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ency workflow state in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state
	 * @throws NoSuchStateException if a matching ency workflow state could not be found
	 */
	public EncyWorkflowState findByWorkflow_First(
			long workflowId,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowState>
				orderByComparator)
		throws NoSuchStateException;

	/**
	 * Returns the first ency workflow state in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	public EncyWorkflowState fetchByWorkflow_First(
		long workflowId,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowState>
			orderByComparator);

	/**
	 * Returns the last ency workflow state in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state
	 * @throws NoSuchStateException if a matching ency workflow state could not be found
	 */
	public EncyWorkflowState findByWorkflow_Last(
			long workflowId,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowState>
				orderByComparator)
		throws NoSuchStateException;

	/**
	 * Returns the last ency workflow state in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	public EncyWorkflowState fetchByWorkflow_Last(
		long workflowId,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowState>
			orderByComparator);

	/**
	 * Returns the ency workflow states before and after the current ency workflow state in the ordered set where workflowId = &#63;.
	 *
	 * @param stateId the primary key of the current ency workflow state
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow state
	 * @throws NoSuchStateException if a ency workflow state with the primary key could not be found
	 */
	public EncyWorkflowState[] findByWorkflow_PrevAndNext(
			long stateId, long workflowId,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowState>
				orderByComparator)
		throws NoSuchStateException;

	/**
	 * Removes all the ency workflow states where workflowId = &#63; from the database.
	 *
	 * @param workflowId the workflow ID
	 */
	public void removeByWorkflow(long workflowId);

	/**
	 * Returns the number of ency workflow states where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @return the number of matching ency workflow states
	 */
	public int countByWorkflow(long workflowId);

	/**
	 * Returns all the ency workflow states where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching ency workflow states
	 */
	public java.util.List<EncyWorkflowState> findByActive(Boolean active);

	/**
	 * Returns a range of all the ency workflow states where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @return the range of matching ency workflow states
	 */
	public java.util.List<EncyWorkflowState> findByActive(
		Boolean active, int start, int end);

	/**
	 * Returns an ordered range of all the ency workflow states where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow states
	 */
	public java.util.List<EncyWorkflowState> findByActive(
		Boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowState>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflow states where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow states
	 */
	public java.util.List<EncyWorkflowState> findByActive(
		Boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowState>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ency workflow state in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state
	 * @throws NoSuchStateException if a matching ency workflow state could not be found
	 */
	public EncyWorkflowState findByActive_First(
			Boolean active,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowState>
				orderByComparator)
		throws NoSuchStateException;

	/**
	 * Returns the first ency workflow state in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	public EncyWorkflowState fetchByActive_First(
		Boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowState>
			orderByComparator);

	/**
	 * Returns the last ency workflow state in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state
	 * @throws NoSuchStateException if a matching ency workflow state could not be found
	 */
	public EncyWorkflowState findByActive_Last(
			Boolean active,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowState>
				orderByComparator)
		throws NoSuchStateException;

	/**
	 * Returns the last ency workflow state in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	public EncyWorkflowState fetchByActive_Last(
		Boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowState>
			orderByComparator);

	/**
	 * Returns the ency workflow states before and after the current ency workflow state in the ordered set where active = &#63;.
	 *
	 * @param stateId the primary key of the current ency workflow state
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow state
	 * @throws NoSuchStateException if a ency workflow state with the primary key could not be found
	 */
	public EncyWorkflowState[] findByActive_PrevAndNext(
			long stateId, Boolean active,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowState>
				orderByComparator)
		throws NoSuchStateException;

	/**
	 * Removes all the ency workflow states where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public void removeByActive(Boolean active);

	/**
	 * Returns the number of ency workflow states where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching ency workflow states
	 */
	public int countByActive(Boolean active);

	/**
	 * Caches the ency workflow state in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowState the ency workflow state
	 */
	public void cacheResult(EncyWorkflowState encyWorkflowState);

	/**
	 * Caches the ency workflow states in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowStates the ency workflow states
	 */
	public void cacheResult(
		java.util.List<EncyWorkflowState> encyWorkflowStates);

	/**
	 * Creates a new ency workflow state with the primary key. Does not add the ency workflow state to the database.
	 *
	 * @param stateId the primary key for the new ency workflow state
	 * @return the new ency workflow state
	 */
	public EncyWorkflowState create(long stateId);

	/**
	 * Removes the ency workflow state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stateId the primary key of the ency workflow state
	 * @return the ency workflow state that was removed
	 * @throws NoSuchStateException if a ency workflow state with the primary key could not be found
	 */
	public EncyWorkflowState remove(long stateId) throws NoSuchStateException;

	public EncyWorkflowState updateImpl(EncyWorkflowState encyWorkflowState);

	/**
	 * Returns the ency workflow state with the primary key or throws a <code>NoSuchStateException</code> if it could not be found.
	 *
	 * @param stateId the primary key of the ency workflow state
	 * @return the ency workflow state
	 * @throws NoSuchStateException if a ency workflow state with the primary key could not be found
	 */
	public EncyWorkflowState findByPrimaryKey(long stateId)
		throws NoSuchStateException;

	/**
	 * Returns the ency workflow state with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stateId the primary key of the ency workflow state
	 * @return the ency workflow state, or <code>null</code> if a ency workflow state with the primary key could not be found
	 */
	public EncyWorkflowState fetchByPrimaryKey(long stateId);

	/**
	 * Returns all the ency workflow states.
	 *
	 * @return the ency workflow states
	 */
	public java.util.List<EncyWorkflowState> findAll();

	/**
	 * Returns a range of all the ency workflow states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @return the range of ency workflow states
	 */
	public java.util.List<EncyWorkflowState> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ency workflow states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ency workflow states
	 */
	public java.util.List<EncyWorkflowState> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowState>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflow states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ency workflow states
	 */
	public java.util.List<EncyWorkflowState> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowState>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ency workflow states from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ency workflow states.
	 *
	 * @return the number of ency workflow states
	 */
	public int countAll();

}