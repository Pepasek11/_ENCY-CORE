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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import cz.csob.ency.workflow.model.EncyWorkflowState;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the ency workflow state service. This utility wraps <code>cz.csob.ency.workflow.service.persistence.impl.EncyWorkflowStatePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowStatePersistence
 * @generated
 */
public class EncyWorkflowStateUtil {

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
	public static void clearCache(EncyWorkflowState encyWorkflowState) {
		getPersistence().clearCache(encyWorkflowState);
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
	public static Map<Serializable, EncyWorkflowState> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EncyWorkflowState> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EncyWorkflowState> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EncyWorkflowState> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EncyWorkflowState> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EncyWorkflowState update(
		EncyWorkflowState encyWorkflowState) {

		return getPersistence().update(encyWorkflowState);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EncyWorkflowState update(
		EncyWorkflowState encyWorkflowState, ServiceContext serviceContext) {

		return getPersistence().update(encyWorkflowState, serviceContext);
	}

	/**
	 * Returns all the ency workflow states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ency workflow states
	 */
	public static List<EncyWorkflowState> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<EncyWorkflowState> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<EncyWorkflowState> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowState> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<EncyWorkflowState> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowState> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ency workflow state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state
	 * @throws NoSuchStateException if a matching ency workflow state could not be found
	 */
	public static EncyWorkflowState findByUuid_First(
			String uuid, OrderByComparator<EncyWorkflowState> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchStateException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first ency workflow state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	public static EncyWorkflowState fetchByUuid_First(
		String uuid, OrderByComparator<EncyWorkflowState> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last ency workflow state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state
	 * @throws NoSuchStateException if a matching ency workflow state could not be found
	 */
	public static EncyWorkflowState findByUuid_Last(
			String uuid, OrderByComparator<EncyWorkflowState> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchStateException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last ency workflow state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	public static EncyWorkflowState fetchByUuid_Last(
		String uuid, OrderByComparator<EncyWorkflowState> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the ency workflow states before and after the current ency workflow state in the ordered set where uuid = &#63;.
	 *
	 * @param stateId the primary key of the current ency workflow state
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow state
	 * @throws NoSuchStateException if a ency workflow state with the primary key could not be found
	 */
	public static EncyWorkflowState[] findByUuid_PrevAndNext(
			long stateId, String uuid,
			OrderByComparator<EncyWorkflowState> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchStateException {

		return getPersistence().findByUuid_PrevAndNext(
			stateId, uuid, orderByComparator);
	}

	/**
	 * Removes all the ency workflow states where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of ency workflow states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ency workflow states
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the ency workflow state where workflowId = &#63; and name = &#63; or throws a <code>NoSuchStateException</code> if it could not be found.
	 *
	 * @param workflowId the workflow ID
	 * @param name the name
	 * @return the matching ency workflow state
	 * @throws NoSuchStateException if a matching ency workflow state could not be found
	 */
	public static EncyWorkflowState findByW_N(long workflowId, String name)
		throws cz.csob.ency.workflow.exception.NoSuchStateException {

		return getPersistence().findByW_N(workflowId, name);
	}

	/**
	 * Returns the ency workflow state where workflowId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param workflowId the workflow ID
	 * @param name the name
	 * @return the matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	public static EncyWorkflowState fetchByW_N(long workflowId, String name) {
		return getPersistence().fetchByW_N(workflowId, name);
	}

	/**
	 * Returns the ency workflow state where workflowId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param workflowId the workflow ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	public static EncyWorkflowState fetchByW_N(
		long workflowId, String name, boolean useFinderCache) {

		return getPersistence().fetchByW_N(workflowId, name, useFinderCache);
	}

	/**
	 * Removes the ency workflow state where workflowId = &#63; and name = &#63; from the database.
	 *
	 * @param workflowId the workflow ID
	 * @param name the name
	 * @return the ency workflow state that was removed
	 */
	public static EncyWorkflowState removeByW_N(long workflowId, String name)
		throws cz.csob.ency.workflow.exception.NoSuchStateException {

		return getPersistence().removeByW_N(workflowId, name);
	}

	/**
	 * Returns the number of ency workflow states where workflowId = &#63; and name = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param name the name
	 * @return the number of matching ency workflow states
	 */
	public static int countByW_N(long workflowId, String name) {
		return getPersistence().countByW_N(workflowId, name);
	}

	/**
	 * Returns all the ency workflow states where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @return the matching ency workflow states
	 */
	public static List<EncyWorkflowState> findByWorkflow(long workflowId) {
		return getPersistence().findByWorkflow(workflowId);
	}

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
	public static List<EncyWorkflowState> findByWorkflow(
		long workflowId, int start, int end) {

		return getPersistence().findByWorkflow(workflowId, start, end);
	}

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
	public static List<EncyWorkflowState> findByWorkflow(
		long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowState> orderByComparator) {

		return getPersistence().findByWorkflow(
			workflowId, start, end, orderByComparator);
	}

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
	public static List<EncyWorkflowState> findByWorkflow(
		long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowState> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByWorkflow(
			workflowId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ency workflow state in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state
	 * @throws NoSuchStateException if a matching ency workflow state could not be found
	 */
	public static EncyWorkflowState findByWorkflow_First(
			long workflowId,
			OrderByComparator<EncyWorkflowState> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchStateException {

		return getPersistence().findByWorkflow_First(
			workflowId, orderByComparator);
	}

	/**
	 * Returns the first ency workflow state in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	public static EncyWorkflowState fetchByWorkflow_First(
		long workflowId,
		OrderByComparator<EncyWorkflowState> orderByComparator) {

		return getPersistence().fetchByWorkflow_First(
			workflowId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow state in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state
	 * @throws NoSuchStateException if a matching ency workflow state could not be found
	 */
	public static EncyWorkflowState findByWorkflow_Last(
			long workflowId,
			OrderByComparator<EncyWorkflowState> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchStateException {

		return getPersistence().findByWorkflow_Last(
			workflowId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow state in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	public static EncyWorkflowState fetchByWorkflow_Last(
		long workflowId,
		OrderByComparator<EncyWorkflowState> orderByComparator) {

		return getPersistence().fetchByWorkflow_Last(
			workflowId, orderByComparator);
	}

	/**
	 * Returns the ency workflow states before and after the current ency workflow state in the ordered set where workflowId = &#63;.
	 *
	 * @param stateId the primary key of the current ency workflow state
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow state
	 * @throws NoSuchStateException if a ency workflow state with the primary key could not be found
	 */
	public static EncyWorkflowState[] findByWorkflow_PrevAndNext(
			long stateId, long workflowId,
			OrderByComparator<EncyWorkflowState> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchStateException {

		return getPersistence().findByWorkflow_PrevAndNext(
			stateId, workflowId, orderByComparator);
	}

	/**
	 * Removes all the ency workflow states where workflowId = &#63; from the database.
	 *
	 * @param workflowId the workflow ID
	 */
	public static void removeByWorkflow(long workflowId) {
		getPersistence().removeByWorkflow(workflowId);
	}

	/**
	 * Returns the number of ency workflow states where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @return the number of matching ency workflow states
	 */
	public static int countByWorkflow(long workflowId) {
		return getPersistence().countByWorkflow(workflowId);
	}

	/**
	 * Returns all the ency workflow states where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching ency workflow states
	 */
	public static List<EncyWorkflowState> findByActive(Boolean active) {
		return getPersistence().findByActive(active);
	}

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
	public static List<EncyWorkflowState> findByActive(
		Boolean active, int start, int end) {

		return getPersistence().findByActive(active, start, end);
	}

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
	public static List<EncyWorkflowState> findByActive(
		Boolean active, int start, int end,
		OrderByComparator<EncyWorkflowState> orderByComparator) {

		return getPersistence().findByActive(
			active, start, end, orderByComparator);
	}

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
	public static List<EncyWorkflowState> findByActive(
		Boolean active, int start, int end,
		OrderByComparator<EncyWorkflowState> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByActive(
			active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ency workflow state in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state
	 * @throws NoSuchStateException if a matching ency workflow state could not be found
	 */
	public static EncyWorkflowState findByActive_First(
			Boolean active,
			OrderByComparator<EncyWorkflowState> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchStateException {

		return getPersistence().findByActive_First(active, orderByComparator);
	}

	/**
	 * Returns the first ency workflow state in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	public static EncyWorkflowState fetchByActive_First(
		Boolean active,
		OrderByComparator<EncyWorkflowState> orderByComparator) {

		return getPersistence().fetchByActive_First(active, orderByComparator);
	}

	/**
	 * Returns the last ency workflow state in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state
	 * @throws NoSuchStateException if a matching ency workflow state could not be found
	 */
	public static EncyWorkflowState findByActive_Last(
			Boolean active,
			OrderByComparator<EncyWorkflowState> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchStateException {

		return getPersistence().findByActive_Last(active, orderByComparator);
	}

	/**
	 * Returns the last ency workflow state in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	public static EncyWorkflowState fetchByActive_Last(
		Boolean active,
		OrderByComparator<EncyWorkflowState> orderByComparator) {

		return getPersistence().fetchByActive_Last(active, orderByComparator);
	}

	/**
	 * Returns the ency workflow states before and after the current ency workflow state in the ordered set where active = &#63;.
	 *
	 * @param stateId the primary key of the current ency workflow state
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow state
	 * @throws NoSuchStateException if a ency workflow state with the primary key could not be found
	 */
	public static EncyWorkflowState[] findByActive_PrevAndNext(
			long stateId, Boolean active,
			OrderByComparator<EncyWorkflowState> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchStateException {

		return getPersistence().findByActive_PrevAndNext(
			stateId, active, orderByComparator);
	}

	/**
	 * Removes all the ency workflow states where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public static void removeByActive(Boolean active) {
		getPersistence().removeByActive(active);
	}

	/**
	 * Returns the number of ency workflow states where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching ency workflow states
	 */
	public static int countByActive(Boolean active) {
		return getPersistence().countByActive(active);
	}

	/**
	 * Caches the ency workflow state in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowState the ency workflow state
	 */
	public static void cacheResult(EncyWorkflowState encyWorkflowState) {
		getPersistence().cacheResult(encyWorkflowState);
	}

	/**
	 * Caches the ency workflow states in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowStates the ency workflow states
	 */
	public static void cacheResult(List<EncyWorkflowState> encyWorkflowStates) {
		getPersistence().cacheResult(encyWorkflowStates);
	}

	/**
	 * Creates a new ency workflow state with the primary key. Does not add the ency workflow state to the database.
	 *
	 * @param stateId the primary key for the new ency workflow state
	 * @return the new ency workflow state
	 */
	public static EncyWorkflowState create(long stateId) {
		return getPersistence().create(stateId);
	}

	/**
	 * Removes the ency workflow state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stateId the primary key of the ency workflow state
	 * @return the ency workflow state that was removed
	 * @throws NoSuchStateException if a ency workflow state with the primary key could not be found
	 */
	public static EncyWorkflowState remove(long stateId)
		throws cz.csob.ency.workflow.exception.NoSuchStateException {

		return getPersistence().remove(stateId);
	}

	public static EncyWorkflowState updateImpl(
		EncyWorkflowState encyWorkflowState) {

		return getPersistence().updateImpl(encyWorkflowState);
	}

	/**
	 * Returns the ency workflow state with the primary key or throws a <code>NoSuchStateException</code> if it could not be found.
	 *
	 * @param stateId the primary key of the ency workflow state
	 * @return the ency workflow state
	 * @throws NoSuchStateException if a ency workflow state with the primary key could not be found
	 */
	public static EncyWorkflowState findByPrimaryKey(long stateId)
		throws cz.csob.ency.workflow.exception.NoSuchStateException {

		return getPersistence().findByPrimaryKey(stateId);
	}

	/**
	 * Returns the ency workflow state with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stateId the primary key of the ency workflow state
	 * @return the ency workflow state, or <code>null</code> if a ency workflow state with the primary key could not be found
	 */
	public static EncyWorkflowState fetchByPrimaryKey(long stateId) {
		return getPersistence().fetchByPrimaryKey(stateId);
	}

	/**
	 * Returns all the ency workflow states.
	 *
	 * @return the ency workflow states
	 */
	public static List<EncyWorkflowState> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<EncyWorkflowState> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<EncyWorkflowState> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowState> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<EncyWorkflowState> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowState> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ency workflow states from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ency workflow states.
	 *
	 * @return the number of ency workflow states
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EncyWorkflowStatePersistence getPersistence() {
		return _persistence;
	}

	private static volatile EncyWorkflowStatePersistence _persistence;

}