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

import cz.csob.ency.workflow.model.EncyWorkflow;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the ency workflow service. This utility wraps <code>cz.csob.ency.workflow.service.persistence.impl.EncyWorkflowPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowPersistence
 * @generated
 */
public class EncyWorkflowUtil {

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
	public static void clearCache(EncyWorkflow encyWorkflow) {
		getPersistence().clearCache(encyWorkflow);
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
	public static Map<Serializable, EncyWorkflow> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EncyWorkflow> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EncyWorkflow> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EncyWorkflow> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EncyWorkflow> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EncyWorkflow update(EncyWorkflow encyWorkflow) {
		return getPersistence().update(encyWorkflow);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EncyWorkflow update(
		EncyWorkflow encyWorkflow, ServiceContext serviceContext) {

		return getPersistence().update(encyWorkflow, serviceContext);
	}

	/**
	 * Returns all the ency workflows where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ency workflows
	 */
	public static List<EncyWorkflow> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the ency workflows where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @return the range of matching ency workflows
	 */
	public static List<EncyWorkflow> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflows where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflows
	 */
	public static List<EncyWorkflow> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflow> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflows where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflows
	 */
	public static List<EncyWorkflow> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflow> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ency workflow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow
	 * @throws NoSuchEncyWorkflowException if a matching ency workflow could not be found
	 */
	public static EncyWorkflow findByUuid_First(
			String uuid, OrderByComparator<EncyWorkflow> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchEncyWorkflowException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first ency workflow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow, or <code>null</code> if a matching ency workflow could not be found
	 */
	public static EncyWorkflow fetchByUuid_First(
		String uuid, OrderByComparator<EncyWorkflow> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last ency workflow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow
	 * @throws NoSuchEncyWorkflowException if a matching ency workflow could not be found
	 */
	public static EncyWorkflow findByUuid_Last(
			String uuid, OrderByComparator<EncyWorkflow> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchEncyWorkflowException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last ency workflow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow, or <code>null</code> if a matching ency workflow could not be found
	 */
	public static EncyWorkflow fetchByUuid_Last(
		String uuid, OrderByComparator<EncyWorkflow> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the ency workflows before and after the current ency workflow in the ordered set where uuid = &#63;.
	 *
	 * @param workflowId the primary key of the current ency workflow
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow
	 * @throws NoSuchEncyWorkflowException if a ency workflow with the primary key could not be found
	 */
	public static EncyWorkflow[] findByUuid_PrevAndNext(
			long workflowId, String uuid,
			OrderByComparator<EncyWorkflow> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchEncyWorkflowException {

		return getPersistence().findByUuid_PrevAndNext(
			workflowId, uuid, orderByComparator);
	}

	/**
	 * Removes all the ency workflows where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of ency workflows where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ency workflows
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the ency workflow where className = &#63; or throws a <code>NoSuchEncyWorkflowException</code> if it could not be found.
	 *
	 * @param className the class name
	 * @return the matching ency workflow
	 * @throws NoSuchEncyWorkflowException if a matching ency workflow could not be found
	 */
	public static EncyWorkflow findByClassName(String className)
		throws cz.csob.ency.workflow.exception.NoSuchEncyWorkflowException {

		return getPersistence().findByClassName(className);
	}

	/**
	 * Returns the ency workflow where className = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param className the class name
	 * @return the matching ency workflow, or <code>null</code> if a matching ency workflow could not be found
	 */
	public static EncyWorkflow fetchByClassName(String className) {
		return getPersistence().fetchByClassName(className);
	}

	/**
	 * Returns the ency workflow where className = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param className the class name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow, or <code>null</code> if a matching ency workflow could not be found
	 */
	public static EncyWorkflow fetchByClassName(
		String className, boolean useFinderCache) {

		return getPersistence().fetchByClassName(className, useFinderCache);
	}

	/**
	 * Removes the ency workflow where className = &#63; from the database.
	 *
	 * @param className the class name
	 * @return the ency workflow that was removed
	 */
	public static EncyWorkflow removeByClassName(String className)
		throws cz.csob.ency.workflow.exception.NoSuchEncyWorkflowException {

		return getPersistence().removeByClassName(className);
	}

	/**
	 * Returns the number of ency workflows where className = &#63;.
	 *
	 * @param className the class name
	 * @return the number of matching ency workflows
	 */
	public static int countByClassName(String className) {
		return getPersistence().countByClassName(className);
	}

	/**
	 * Returns all the ency workflows where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching ency workflows
	 */
	public static List<EncyWorkflow> findByActive(Boolean active) {
		return getPersistence().findByActive(active);
	}

	/**
	 * Returns a range of all the ency workflows where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @return the range of matching ency workflows
	 */
	public static List<EncyWorkflow> findByActive(
		Boolean active, int start, int end) {

		return getPersistence().findByActive(active, start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflows where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflows
	 */
	public static List<EncyWorkflow> findByActive(
		Boolean active, int start, int end,
		OrderByComparator<EncyWorkflow> orderByComparator) {

		return getPersistence().findByActive(
			active, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflows where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflows
	 */
	public static List<EncyWorkflow> findByActive(
		Boolean active, int start, int end,
		OrderByComparator<EncyWorkflow> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByActive(
			active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ency workflow in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow
	 * @throws NoSuchEncyWorkflowException if a matching ency workflow could not be found
	 */
	public static EncyWorkflow findByActive_First(
			Boolean active, OrderByComparator<EncyWorkflow> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchEncyWorkflowException {

		return getPersistence().findByActive_First(active, orderByComparator);
	}

	/**
	 * Returns the first ency workflow in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow, or <code>null</code> if a matching ency workflow could not be found
	 */
	public static EncyWorkflow fetchByActive_First(
		Boolean active, OrderByComparator<EncyWorkflow> orderByComparator) {

		return getPersistence().fetchByActive_First(active, orderByComparator);
	}

	/**
	 * Returns the last ency workflow in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow
	 * @throws NoSuchEncyWorkflowException if a matching ency workflow could not be found
	 */
	public static EncyWorkflow findByActive_Last(
			Boolean active, OrderByComparator<EncyWorkflow> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchEncyWorkflowException {

		return getPersistence().findByActive_Last(active, orderByComparator);
	}

	/**
	 * Returns the last ency workflow in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow, or <code>null</code> if a matching ency workflow could not be found
	 */
	public static EncyWorkflow fetchByActive_Last(
		Boolean active, OrderByComparator<EncyWorkflow> orderByComparator) {

		return getPersistence().fetchByActive_Last(active, orderByComparator);
	}

	/**
	 * Returns the ency workflows before and after the current ency workflow in the ordered set where active = &#63;.
	 *
	 * @param workflowId the primary key of the current ency workflow
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow
	 * @throws NoSuchEncyWorkflowException if a ency workflow with the primary key could not be found
	 */
	public static EncyWorkflow[] findByActive_PrevAndNext(
			long workflowId, Boolean active,
			OrderByComparator<EncyWorkflow> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchEncyWorkflowException {

		return getPersistence().findByActive_PrevAndNext(
			workflowId, active, orderByComparator);
	}

	/**
	 * Removes all the ency workflows where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public static void removeByActive(Boolean active) {
		getPersistence().removeByActive(active);
	}

	/**
	 * Returns the number of ency workflows where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching ency workflows
	 */
	public static int countByActive(Boolean active) {
		return getPersistence().countByActive(active);
	}

	/**
	 * Caches the ency workflow in the entity cache if it is enabled.
	 *
	 * @param encyWorkflow the ency workflow
	 */
	public static void cacheResult(EncyWorkflow encyWorkflow) {
		getPersistence().cacheResult(encyWorkflow);
	}

	/**
	 * Caches the ency workflows in the entity cache if it is enabled.
	 *
	 * @param encyWorkflows the ency workflows
	 */
	public static void cacheResult(List<EncyWorkflow> encyWorkflows) {
		getPersistence().cacheResult(encyWorkflows);
	}

	/**
	 * Creates a new ency workflow with the primary key. Does not add the ency workflow to the database.
	 *
	 * @param workflowId the primary key for the new ency workflow
	 * @return the new ency workflow
	 */
	public static EncyWorkflow create(long workflowId) {
		return getPersistence().create(workflowId);
	}

	/**
	 * Removes the ency workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workflowId the primary key of the ency workflow
	 * @return the ency workflow that was removed
	 * @throws NoSuchEncyWorkflowException if a ency workflow with the primary key could not be found
	 */
	public static EncyWorkflow remove(long workflowId)
		throws cz.csob.ency.workflow.exception.NoSuchEncyWorkflowException {

		return getPersistence().remove(workflowId);
	}

	public static EncyWorkflow updateImpl(EncyWorkflow encyWorkflow) {
		return getPersistence().updateImpl(encyWorkflow);
	}

	/**
	 * Returns the ency workflow with the primary key or throws a <code>NoSuchEncyWorkflowException</code> if it could not be found.
	 *
	 * @param workflowId the primary key of the ency workflow
	 * @return the ency workflow
	 * @throws NoSuchEncyWorkflowException if a ency workflow with the primary key could not be found
	 */
	public static EncyWorkflow findByPrimaryKey(long workflowId)
		throws cz.csob.ency.workflow.exception.NoSuchEncyWorkflowException {

		return getPersistence().findByPrimaryKey(workflowId);
	}

	/**
	 * Returns the ency workflow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workflowId the primary key of the ency workflow
	 * @return the ency workflow, or <code>null</code> if a ency workflow with the primary key could not be found
	 */
	public static EncyWorkflow fetchByPrimaryKey(long workflowId) {
		return getPersistence().fetchByPrimaryKey(workflowId);
	}

	/**
	 * Returns all the ency workflows.
	 *
	 * @return the ency workflows
	 */
	public static List<EncyWorkflow> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ency workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @return the range of ency workflows
	 */
	public static List<EncyWorkflow> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ency workflows
	 */
	public static List<EncyWorkflow> findAll(
		int start, int end, OrderByComparator<EncyWorkflow> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ency workflows
	 */
	public static List<EncyWorkflow> findAll(
		int start, int end, OrderByComparator<EncyWorkflow> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ency workflows from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ency workflows.
	 *
	 * @return the number of ency workflows
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EncyWorkflowPersistence getPersistence() {
		return _persistence;
	}

	private static volatile EncyWorkflowPersistence _persistence;

}