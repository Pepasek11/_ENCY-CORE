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

import cz.csob.ency.workflow.model.EncyWorkflowStateInstance;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the ency workflow state instance service. This utility wraps <code>cz.csob.ency.workflow.service.persistence.impl.EncyWorkflowStateInstancePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowStateInstancePersistence
 * @generated
 */
public class EncyWorkflowStateInstanceUtil {

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
		EncyWorkflowStateInstance encyWorkflowStateInstance) {

		getPersistence().clearCache(encyWorkflowStateInstance);
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
	public static Map<Serializable, EncyWorkflowStateInstance>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EncyWorkflowStateInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EncyWorkflowStateInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EncyWorkflowStateInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EncyWorkflowStateInstance update(
		EncyWorkflowStateInstance encyWorkflowStateInstance) {

		return getPersistence().update(encyWorkflowStateInstance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EncyWorkflowStateInstance update(
		EncyWorkflowStateInstance encyWorkflowStateInstance,
		ServiceContext serviceContext) {

		return getPersistence().update(
			encyWorkflowStateInstance, serviceContext);
	}

	/**
	 * Returns all the ency workflow state instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ency workflow state instances
	 */
	public static List<EncyWorkflowStateInstance> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the ency workflow state instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @return the range of matching ency workflow state instances
	 */
	public static List<EncyWorkflowStateInstance> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflow state instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow state instances
	 */
	public static List<EncyWorkflowStateInstance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow state instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow state instances
	 */
	public static List<EncyWorkflowStateInstance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ency workflow state instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	public static EncyWorkflowStateInstance findByUuid_First(
			String uuid,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchStateInstanceException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first ency workflow state instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	public static EncyWorkflowStateInstance fetchByUuid_First(
		String uuid,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last ency workflow state instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	public static EncyWorkflowStateInstance findByUuid_Last(
			String uuid,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchStateInstanceException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last ency workflow state instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	public static EncyWorkflowStateInstance fetchByUuid_Last(
		String uuid,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the ency workflow state instances before and after the current ency workflow state instance in the ordered set where uuid = &#63;.
	 *
	 * @param stateInstanceId the primary key of the current ency workflow state instance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow state instance
	 * @throws NoSuchStateInstanceException if a ency workflow state instance with the primary key could not be found
	 */
	public static EncyWorkflowStateInstance[] findByUuid_PrevAndNext(
			long stateInstanceId, String uuid,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchStateInstanceException {

		return getPersistence().findByUuid_PrevAndNext(
			stateInstanceId, uuid, orderByComparator);
	}

	/**
	 * Removes all the ency workflow state instances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of ency workflow state instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ency workflow state instances
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the ency workflow state instance where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchStateInstanceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	public static EncyWorkflowStateInstance findByUUID_G(
			String uuid, long groupId)
		throws cz.csob.ency.workflow.exception.NoSuchStateInstanceException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ency workflow state instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	public static EncyWorkflowStateInstance fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ency workflow state instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	public static EncyWorkflowStateInstance fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the ency workflow state instance where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ency workflow state instance that was removed
	 */
	public static EncyWorkflowStateInstance removeByUUID_G(
			String uuid, long groupId)
		throws cz.csob.ency.workflow.exception.NoSuchStateInstanceException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of ency workflow state instances where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ency workflow state instances
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the ency workflow state instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ency workflow state instances
	 */
	public static List<EncyWorkflowStateInstance> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the ency workflow state instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @return the range of matching ency workflow state instances
	 */
	public static List<EncyWorkflowStateInstance> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflow state instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow state instances
	 */
	public static List<EncyWorkflowStateInstance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow state instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow state instances
	 */
	public static List<EncyWorkflowStateInstance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ency workflow state instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	public static EncyWorkflowStateInstance findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchStateInstanceException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first ency workflow state instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	public static EncyWorkflowStateInstance fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow state instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	public static EncyWorkflowStateInstance findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchStateInstanceException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow state instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	public static EncyWorkflowStateInstance fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the ency workflow state instances before and after the current ency workflow state instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param stateInstanceId the primary key of the current ency workflow state instance
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow state instance
	 * @throws NoSuchStateInstanceException if a ency workflow state instance with the primary key could not be found
	 */
	public static EncyWorkflowStateInstance[] findByUuid_C_PrevAndNext(
			long stateInstanceId, String uuid, long companyId,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchStateInstanceException {

		return getPersistence().findByUuid_C_PrevAndNext(
			stateInstanceId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the ency workflow state instances where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of ency workflow state instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ency workflow state instances
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the ency workflow state instances where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @return the matching ency workflow state instances
	 */
	public static List<EncyWorkflowStateInstance> findByWorkflowInstanceId(
		long workflowInstanceId) {

		return getPersistence().findByWorkflowInstanceId(workflowInstanceId);
	}

	/**
	 * Returns a range of all the ency workflow state instances where workflowInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @return the range of matching ency workflow state instances
	 */
	public static List<EncyWorkflowStateInstance> findByWorkflowInstanceId(
		long workflowInstanceId, int start, int end) {

		return getPersistence().findByWorkflowInstanceId(
			workflowInstanceId, start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflow state instances where workflowInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow state instances
	 */
	public static List<EncyWorkflowStateInstance> findByWorkflowInstanceId(
		long workflowInstanceId, int start, int end,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		return getPersistence().findByWorkflowInstanceId(
			workflowInstanceId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow state instances where workflowInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow state instances
	 */
	public static List<EncyWorkflowStateInstance> findByWorkflowInstanceId(
		long workflowInstanceId, int start, int end,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByWorkflowInstanceId(
			workflowInstanceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ency workflow state instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	public static EncyWorkflowStateInstance findByWorkflowInstanceId_First(
			long workflowInstanceId,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchStateInstanceException {

		return getPersistence().findByWorkflowInstanceId_First(
			workflowInstanceId, orderByComparator);
	}

	/**
	 * Returns the first ency workflow state instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	public static EncyWorkflowStateInstance fetchByWorkflowInstanceId_First(
		long workflowInstanceId,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		return getPersistence().fetchByWorkflowInstanceId_First(
			workflowInstanceId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow state instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	public static EncyWorkflowStateInstance findByWorkflowInstanceId_Last(
			long workflowInstanceId,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchStateInstanceException {

		return getPersistence().findByWorkflowInstanceId_Last(
			workflowInstanceId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow state instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	public static EncyWorkflowStateInstance fetchByWorkflowInstanceId_Last(
		long workflowInstanceId,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		return getPersistence().fetchByWorkflowInstanceId_Last(
			workflowInstanceId, orderByComparator);
	}

	/**
	 * Returns the ency workflow state instances before and after the current ency workflow state instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param stateInstanceId the primary key of the current ency workflow state instance
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow state instance
	 * @throws NoSuchStateInstanceException if a ency workflow state instance with the primary key could not be found
	 */
	public static EncyWorkflowStateInstance[]
			findByWorkflowInstanceId_PrevAndNext(
				long stateInstanceId, long workflowInstanceId,
				OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchStateInstanceException {

		return getPersistence().findByWorkflowInstanceId_PrevAndNext(
			stateInstanceId, workflowInstanceId, orderByComparator);
	}

	/**
	 * Removes all the ency workflow state instances where workflowInstanceId = &#63; from the database.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 */
	public static void removeByWorkflowInstanceId(long workflowInstanceId) {
		getPersistence().removeByWorkflowInstanceId(workflowInstanceId);
	}

	/**
	 * Returns the number of ency workflow state instances where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @return the number of matching ency workflow state instances
	 */
	public static int countByWorkflowInstanceId(long workflowInstanceId) {
		return getPersistence().countByWorkflowInstanceId(workflowInstanceId);
	}

	/**
	 * Returns all the ency workflow state instances where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @return the matching ency workflow state instances
	 */
	public static List<EncyWorkflowStateInstance> findByWorkflowId(
		long workflowId) {

		return getPersistence().findByWorkflowId(workflowId);
	}

	/**
	 * Returns a range of all the ency workflow state instances where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @return the range of matching ency workflow state instances
	 */
	public static List<EncyWorkflowStateInstance> findByWorkflowId(
		long workflowId, int start, int end) {

		return getPersistence().findByWorkflowId(workflowId, start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflow state instances where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow state instances
	 */
	public static List<EncyWorkflowStateInstance> findByWorkflowId(
		long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		return getPersistence().findByWorkflowId(
			workflowId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow state instances where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow state instances
	 */
	public static List<EncyWorkflowStateInstance> findByWorkflowId(
		long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByWorkflowId(
			workflowId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ency workflow state instance in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	public static EncyWorkflowStateInstance findByWorkflowId_First(
			long workflowId,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchStateInstanceException {

		return getPersistence().findByWorkflowId_First(
			workflowId, orderByComparator);
	}

	/**
	 * Returns the first ency workflow state instance in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	public static EncyWorkflowStateInstance fetchByWorkflowId_First(
		long workflowId,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		return getPersistence().fetchByWorkflowId_First(
			workflowId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow state instance in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	public static EncyWorkflowStateInstance findByWorkflowId_Last(
			long workflowId,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchStateInstanceException {

		return getPersistence().findByWorkflowId_Last(
			workflowId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow state instance in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	public static EncyWorkflowStateInstance fetchByWorkflowId_Last(
		long workflowId,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		return getPersistence().fetchByWorkflowId_Last(
			workflowId, orderByComparator);
	}

	/**
	 * Returns the ency workflow state instances before and after the current ency workflow state instance in the ordered set where workflowId = &#63;.
	 *
	 * @param stateInstanceId the primary key of the current ency workflow state instance
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow state instance
	 * @throws NoSuchStateInstanceException if a ency workflow state instance with the primary key could not be found
	 */
	public static EncyWorkflowStateInstance[] findByWorkflowId_PrevAndNext(
			long stateInstanceId, long workflowId,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchStateInstanceException {

		return getPersistence().findByWorkflowId_PrevAndNext(
			stateInstanceId, workflowId, orderByComparator);
	}

	/**
	 * Removes all the ency workflow state instances where workflowId = &#63; from the database.
	 *
	 * @param workflowId the workflow ID
	 */
	public static void removeByWorkflowId(long workflowId) {
		getPersistence().removeByWorkflowId(workflowId);
	}

	/**
	 * Returns the number of ency workflow state instances where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @return the number of matching ency workflow state instances
	 */
	public static int countByWorkflowId(long workflowId) {
		return getPersistence().countByWorkflowId(workflowId);
	}

	/**
	 * Caches the ency workflow state instance in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowStateInstance the ency workflow state instance
	 */
	public static void cacheResult(
		EncyWorkflowStateInstance encyWorkflowStateInstance) {

		getPersistence().cacheResult(encyWorkflowStateInstance);
	}

	/**
	 * Caches the ency workflow state instances in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowStateInstances the ency workflow state instances
	 */
	public static void cacheResult(
		List<EncyWorkflowStateInstance> encyWorkflowStateInstances) {

		getPersistence().cacheResult(encyWorkflowStateInstances);
	}

	/**
	 * Creates a new ency workflow state instance with the primary key. Does not add the ency workflow state instance to the database.
	 *
	 * @param stateInstanceId the primary key for the new ency workflow state instance
	 * @return the new ency workflow state instance
	 */
	public static EncyWorkflowStateInstance create(long stateInstanceId) {
		return getPersistence().create(stateInstanceId);
	}

	/**
	 * Removes the ency workflow state instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stateInstanceId the primary key of the ency workflow state instance
	 * @return the ency workflow state instance that was removed
	 * @throws NoSuchStateInstanceException if a ency workflow state instance with the primary key could not be found
	 */
	public static EncyWorkflowStateInstance remove(long stateInstanceId)
		throws cz.csob.ency.workflow.exception.NoSuchStateInstanceException {

		return getPersistence().remove(stateInstanceId);
	}

	public static EncyWorkflowStateInstance updateImpl(
		EncyWorkflowStateInstance encyWorkflowStateInstance) {

		return getPersistence().updateImpl(encyWorkflowStateInstance);
	}

	/**
	 * Returns the ency workflow state instance with the primary key or throws a <code>NoSuchStateInstanceException</code> if it could not be found.
	 *
	 * @param stateInstanceId the primary key of the ency workflow state instance
	 * @return the ency workflow state instance
	 * @throws NoSuchStateInstanceException if a ency workflow state instance with the primary key could not be found
	 */
	public static EncyWorkflowStateInstance findByPrimaryKey(
			long stateInstanceId)
		throws cz.csob.ency.workflow.exception.NoSuchStateInstanceException {

		return getPersistence().findByPrimaryKey(stateInstanceId);
	}

	/**
	 * Returns the ency workflow state instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stateInstanceId the primary key of the ency workflow state instance
	 * @return the ency workflow state instance, or <code>null</code> if a ency workflow state instance with the primary key could not be found
	 */
	public static EncyWorkflowStateInstance fetchByPrimaryKey(
		long stateInstanceId) {

		return getPersistence().fetchByPrimaryKey(stateInstanceId);
	}

	/**
	 * Returns all the ency workflow state instances.
	 *
	 * @return the ency workflow state instances
	 */
	public static List<EncyWorkflowStateInstance> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ency workflow state instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @return the range of ency workflow state instances
	 */
	public static List<EncyWorkflowStateInstance> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflow state instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ency workflow state instances
	 */
	public static List<EncyWorkflowStateInstance> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow state instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ency workflow state instances
	 */
	public static List<EncyWorkflowStateInstance> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ency workflow state instances from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ency workflow state instances.
	 *
	 * @return the number of ency workflow state instances
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EncyWorkflowStateInstancePersistence getPersistence() {
		return _persistence;
	}

	private static volatile EncyWorkflowStateInstancePersistence _persistence;

}