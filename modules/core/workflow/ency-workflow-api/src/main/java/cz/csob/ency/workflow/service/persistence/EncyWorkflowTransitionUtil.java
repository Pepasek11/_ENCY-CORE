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

import cz.csob.ency.workflow.model.EncyWorkflowTransition;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the ency workflow transition service. This utility wraps <code>cz.csob.ency.workflow.service.persistence.impl.EncyWorkflowTransitionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowTransitionPersistence
 * @generated
 */
public class EncyWorkflowTransitionUtil {

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
	public static void clearCache(
		EncyWorkflowTransition encyWorkflowTransition) {

		getPersistence().clearCache(encyWorkflowTransition);
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
	public static Map<Serializable, EncyWorkflowTransition> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EncyWorkflowTransition> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EncyWorkflowTransition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EncyWorkflowTransition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EncyWorkflowTransition update(
		EncyWorkflowTransition encyWorkflowTransition) {

		return getPersistence().update(encyWorkflowTransition);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EncyWorkflowTransition update(
		EncyWorkflowTransition encyWorkflowTransition,
		ServiceContext serviceContext) {

		return getPersistence().update(encyWorkflowTransition, serviceContext);
	}

	/**
	 * Returns all the ency workflow transitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ency workflow transitions
	 */
	public static List<EncyWorkflowTransition> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<EncyWorkflowTransition> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<EncyWorkflowTransition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<EncyWorkflowTransition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowTransition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ency workflow transition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	public static EncyWorkflowTransition findByUuid_First(
			String uuid,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchTransitionException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first ency workflow transition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	public static EncyWorkflowTransition fetchByUuid_First(
		String uuid,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last ency workflow transition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	public static EncyWorkflowTransition findByUuid_Last(
			String uuid,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchTransitionException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last ency workflow transition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	public static EncyWorkflowTransition fetchByUuid_Last(
		String uuid,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the ency workflow transitions before and after the current ency workflow transition in the ordered set where uuid = &#63;.
	 *
	 * @param transitionId the primary key of the current ency workflow transition
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow transition
	 * @throws NoSuchTransitionException if a ency workflow transition with the primary key could not be found
	 */
	public static EncyWorkflowTransition[] findByUuid_PrevAndNext(
			long transitionId, String uuid,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchTransitionException {

		return getPersistence().findByUuid_PrevAndNext(
			transitionId, uuid, orderByComparator);
	}

	/**
	 * Removes all the ency workflow transitions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of ency workflow transitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ency workflow transitions
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the ency workflow transition where stateId = &#63; and name = &#63; or throws a <code>NoSuchTransitionException</code> if it could not be found.
	 *
	 * @param stateId the state ID
	 * @param name the name
	 * @return the matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	public static EncyWorkflowTransition findByS_N(long stateId, String name)
		throws cz.csob.ency.workflow.exception.NoSuchTransitionException {

		return getPersistence().findByS_N(stateId, name);
	}

	/**
	 * Returns the ency workflow transition where stateId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param stateId the state ID
	 * @param name the name
	 * @return the matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	public static EncyWorkflowTransition fetchByS_N(long stateId, String name) {
		return getPersistence().fetchByS_N(stateId, name);
	}

	/**
	 * Returns the ency workflow transition where stateId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param stateId the state ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	public static EncyWorkflowTransition fetchByS_N(
		long stateId, String name, boolean useFinderCache) {

		return getPersistence().fetchByS_N(stateId, name, useFinderCache);
	}

	/**
	 * Removes the ency workflow transition where stateId = &#63; and name = &#63; from the database.
	 *
	 * @param stateId the state ID
	 * @param name the name
	 * @return the ency workflow transition that was removed
	 */
	public static EncyWorkflowTransition removeByS_N(long stateId, String name)
		throws cz.csob.ency.workflow.exception.NoSuchTransitionException {

		return getPersistence().removeByS_N(stateId, name);
	}

	/**
	 * Returns the number of ency workflow transitions where stateId = &#63; and name = &#63;.
	 *
	 * @param stateId the state ID
	 * @param name the name
	 * @return the number of matching ency workflow transitions
	 */
	public static int countByS_N(long stateId, String name) {
		return getPersistence().countByS_N(stateId, name);
	}

	/**
	 * Returns all the ency workflow transitions where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @return the matching ency workflow transitions
	 */
	public static List<EncyWorkflowTransition> findByWorkflow(long workflowId) {
		return getPersistence().findByWorkflow(workflowId);
	}

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
	public static List<EncyWorkflowTransition> findByWorkflow(
		long workflowId, int start, int end) {

		return getPersistence().findByWorkflow(workflowId, start, end);
	}

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
	public static List<EncyWorkflowTransition> findByWorkflow(
		long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		return getPersistence().findByWorkflow(
			workflowId, start, end, orderByComparator);
	}

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
	public static List<EncyWorkflowTransition> findByWorkflow(
		long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowTransition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByWorkflow(
			workflowId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ency workflow transition in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	public static EncyWorkflowTransition findByWorkflow_First(
			long workflowId,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchTransitionException {

		return getPersistence().findByWorkflow_First(
			workflowId, orderByComparator);
	}

	/**
	 * Returns the first ency workflow transition in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	public static EncyWorkflowTransition fetchByWorkflow_First(
		long workflowId,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		return getPersistence().fetchByWorkflow_First(
			workflowId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow transition in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	public static EncyWorkflowTransition findByWorkflow_Last(
			long workflowId,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchTransitionException {

		return getPersistence().findByWorkflow_Last(
			workflowId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow transition in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	public static EncyWorkflowTransition fetchByWorkflow_Last(
		long workflowId,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		return getPersistence().fetchByWorkflow_Last(
			workflowId, orderByComparator);
	}

	/**
	 * Returns the ency workflow transitions before and after the current ency workflow transition in the ordered set where workflowId = &#63;.
	 *
	 * @param transitionId the primary key of the current ency workflow transition
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow transition
	 * @throws NoSuchTransitionException if a ency workflow transition with the primary key could not be found
	 */
	public static EncyWorkflowTransition[] findByWorkflow_PrevAndNext(
			long transitionId, long workflowId,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchTransitionException {

		return getPersistence().findByWorkflow_PrevAndNext(
			transitionId, workflowId, orderByComparator);
	}

	/**
	 * Removes all the ency workflow transitions where workflowId = &#63; from the database.
	 *
	 * @param workflowId the workflow ID
	 */
	public static void removeByWorkflow(long workflowId) {
		getPersistence().removeByWorkflow(workflowId);
	}

	/**
	 * Returns the number of ency workflow transitions where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @return the number of matching ency workflow transitions
	 */
	public static int countByWorkflow(long workflowId) {
		return getPersistence().countByWorkflow(workflowId);
	}

	/**
	 * Returns all the ency workflow transitions where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the matching ency workflow transitions
	 */
	public static List<EncyWorkflowTransition> findByState(long stateId) {
		return getPersistence().findByState(stateId);
	}

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
	public static List<EncyWorkflowTransition> findByState(
		long stateId, int start, int end) {

		return getPersistence().findByState(stateId, start, end);
	}

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
	public static List<EncyWorkflowTransition> findByState(
		long stateId, int start, int end,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		return getPersistence().findByState(
			stateId, start, end, orderByComparator);
	}

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
	public static List<EncyWorkflowTransition> findByState(
		long stateId, int start, int end,
		OrderByComparator<EncyWorkflowTransition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByState(
			stateId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ency workflow transition in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	public static EncyWorkflowTransition findByState_First(
			long stateId,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchTransitionException {

		return getPersistence().findByState_First(stateId, orderByComparator);
	}

	/**
	 * Returns the first ency workflow transition in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	public static EncyWorkflowTransition fetchByState_First(
		long stateId,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		return getPersistence().fetchByState_First(stateId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow transition in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	public static EncyWorkflowTransition findByState_Last(
			long stateId,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchTransitionException {

		return getPersistence().findByState_Last(stateId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow transition in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	public static EncyWorkflowTransition fetchByState_Last(
		long stateId,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		return getPersistence().fetchByState_Last(stateId, orderByComparator);
	}

	/**
	 * Returns the ency workflow transitions before and after the current ency workflow transition in the ordered set where stateId = &#63;.
	 *
	 * @param transitionId the primary key of the current ency workflow transition
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow transition
	 * @throws NoSuchTransitionException if a ency workflow transition with the primary key could not be found
	 */
	public static EncyWorkflowTransition[] findByState_PrevAndNext(
			long transitionId, long stateId,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchTransitionException {

		return getPersistence().findByState_PrevAndNext(
			transitionId, stateId, orderByComparator);
	}

	/**
	 * Removes all the ency workflow transitions where stateId = &#63; from the database.
	 *
	 * @param stateId the state ID
	 */
	public static void removeByState(long stateId) {
		getPersistence().removeByState(stateId);
	}

	/**
	 * Returns the number of ency workflow transitions where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the number of matching ency workflow transitions
	 */
	public static int countByState(long stateId) {
		return getPersistence().countByState(stateId);
	}

	/**
	 * Returns all the ency workflow transitions where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching ency workflow transitions
	 */
	public static List<EncyWorkflowTransition> findByActive(Boolean active) {
		return getPersistence().findByActive(active);
	}

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
	public static List<EncyWorkflowTransition> findByActive(
		Boolean active, int start, int end) {

		return getPersistence().findByActive(active, start, end);
	}

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
	public static List<EncyWorkflowTransition> findByActive(
		Boolean active, int start, int end,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		return getPersistence().findByActive(
			active, start, end, orderByComparator);
	}

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
	public static List<EncyWorkflowTransition> findByActive(
		Boolean active, int start, int end,
		OrderByComparator<EncyWorkflowTransition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByActive(
			active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ency workflow transition in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	public static EncyWorkflowTransition findByActive_First(
			Boolean active,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchTransitionException {

		return getPersistence().findByActive_First(active, orderByComparator);
	}

	/**
	 * Returns the first ency workflow transition in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	public static EncyWorkflowTransition fetchByActive_First(
		Boolean active,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		return getPersistence().fetchByActive_First(active, orderByComparator);
	}

	/**
	 * Returns the last ency workflow transition in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	public static EncyWorkflowTransition findByActive_Last(
			Boolean active,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchTransitionException {

		return getPersistence().findByActive_Last(active, orderByComparator);
	}

	/**
	 * Returns the last ency workflow transition in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	public static EncyWorkflowTransition fetchByActive_Last(
		Boolean active,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		return getPersistence().fetchByActive_Last(active, orderByComparator);
	}

	/**
	 * Returns the ency workflow transitions before and after the current ency workflow transition in the ordered set where active = &#63;.
	 *
	 * @param transitionId the primary key of the current ency workflow transition
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow transition
	 * @throws NoSuchTransitionException if a ency workflow transition with the primary key could not be found
	 */
	public static EncyWorkflowTransition[] findByActive_PrevAndNext(
			long transitionId, Boolean active,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchTransitionException {

		return getPersistence().findByActive_PrevAndNext(
			transitionId, active, orderByComparator);
	}

	/**
	 * Removes all the ency workflow transitions where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public static void removeByActive(Boolean active) {
		getPersistence().removeByActive(active);
	}

	/**
	 * Returns the number of ency workflow transitions where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching ency workflow transitions
	 */
	public static int countByActive(Boolean active) {
		return getPersistence().countByActive(active);
	}

	/**
	 * Caches the ency workflow transition in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowTransition the ency workflow transition
	 */
	public static void cacheResult(
		EncyWorkflowTransition encyWorkflowTransition) {

		getPersistence().cacheResult(encyWorkflowTransition);
	}

	/**
	 * Caches the ency workflow transitions in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowTransitions the ency workflow transitions
	 */
	public static void cacheResult(
		List<EncyWorkflowTransition> encyWorkflowTransitions) {

		getPersistence().cacheResult(encyWorkflowTransitions);
	}

	/**
	 * Creates a new ency workflow transition with the primary key. Does not add the ency workflow transition to the database.
	 *
	 * @param transitionId the primary key for the new ency workflow transition
	 * @return the new ency workflow transition
	 */
	public static EncyWorkflowTransition create(long transitionId) {
		return getPersistence().create(transitionId);
	}

	/**
	 * Removes the ency workflow transition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transitionId the primary key of the ency workflow transition
	 * @return the ency workflow transition that was removed
	 * @throws NoSuchTransitionException if a ency workflow transition with the primary key could not be found
	 */
	public static EncyWorkflowTransition remove(long transitionId)
		throws cz.csob.ency.workflow.exception.NoSuchTransitionException {

		return getPersistence().remove(transitionId);
	}

	public static EncyWorkflowTransition updateImpl(
		EncyWorkflowTransition encyWorkflowTransition) {

		return getPersistence().updateImpl(encyWorkflowTransition);
	}

	/**
	 * Returns the ency workflow transition with the primary key or throws a <code>NoSuchTransitionException</code> if it could not be found.
	 *
	 * @param transitionId the primary key of the ency workflow transition
	 * @return the ency workflow transition
	 * @throws NoSuchTransitionException if a ency workflow transition with the primary key could not be found
	 */
	public static EncyWorkflowTransition findByPrimaryKey(long transitionId)
		throws cz.csob.ency.workflow.exception.NoSuchTransitionException {

		return getPersistence().findByPrimaryKey(transitionId);
	}

	/**
	 * Returns the ency workflow transition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param transitionId the primary key of the ency workflow transition
	 * @return the ency workflow transition, or <code>null</code> if a ency workflow transition with the primary key could not be found
	 */
	public static EncyWorkflowTransition fetchByPrimaryKey(long transitionId) {
		return getPersistence().fetchByPrimaryKey(transitionId);
	}

	/**
	 * Returns all the ency workflow transitions.
	 *
	 * @return the ency workflow transitions
	 */
	public static List<EncyWorkflowTransition> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<EncyWorkflowTransition> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<EncyWorkflowTransition> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<EncyWorkflowTransition> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowTransition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ency workflow transitions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ency workflow transitions.
	 *
	 * @return the number of ency workflow transitions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EncyWorkflowTransitionPersistence getPersistence() {
		return _persistence;
	}

	private static volatile EncyWorkflowTransitionPersistence _persistence;

}