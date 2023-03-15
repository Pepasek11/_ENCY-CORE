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

import cz.csob.ency.workflow.model.EncyWorkflowTransitionInstance;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the ency workflow transition instance service. This utility wraps <code>cz.csob.ency.workflow.service.persistence.impl.EncyWorkflowTransitionInstancePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowTransitionInstancePersistence
 * @generated
 */
public class EncyWorkflowTransitionInstanceUtil {

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
		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance) {

		getPersistence().clearCache(encyWorkflowTransitionInstance);
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
	public static Map<Serializable, EncyWorkflowTransitionInstance>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EncyWorkflowTransitionInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EncyWorkflowTransitionInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EncyWorkflowTransitionInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EncyWorkflowTransitionInstance update(
		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance) {

		return getPersistence().update(encyWorkflowTransitionInstance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EncyWorkflowTransitionInstance update(
		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance,
		ServiceContext serviceContext) {

		return getPersistence().update(
			encyWorkflowTransitionInstance, serviceContext);
	}

	/**
	 * Returns all the ency workflow transition instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ency workflow transition instances
	 */
	public static List<EncyWorkflowTransitionInstance> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the ency workflow transition instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @return the range of matching ency workflow transition instances
	 */
	public static List<EncyWorkflowTransitionInstance> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflow transition instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow transition instances
	 */
	public static List<EncyWorkflowTransitionInstance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow transition instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow transition instances
	 */
	public static List<EncyWorkflowTransitionInstance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ency workflow transition instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a matching ency workflow transition instance could not be found
	 */
	public static EncyWorkflowTransitionInstance findByUuid_First(
			String uuid,
			OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.
			NoSuchTransitionInstanceException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first ency workflow transition instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	public static EncyWorkflowTransitionInstance fetchByUuid_First(
		String uuid,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last ency workflow transition instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a matching ency workflow transition instance could not be found
	 */
	public static EncyWorkflowTransitionInstance findByUuid_Last(
			String uuid,
			OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.
			NoSuchTransitionInstanceException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last ency workflow transition instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	public static EncyWorkflowTransitionInstance fetchByUuid_Last(
		String uuid,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the ency workflow transition instances before and after the current ency workflow transition instance in the ordered set where uuid = &#63;.
	 *
	 * @param transitionInstanceId the primary key of the current ency workflow transition instance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a ency workflow transition instance with the primary key could not be found
	 */
	public static EncyWorkflowTransitionInstance[] findByUuid_PrevAndNext(
			long transitionInstanceId, String uuid,
			OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.
			NoSuchTransitionInstanceException {

		return getPersistence().findByUuid_PrevAndNext(
			transitionInstanceId, uuid, orderByComparator);
	}

	/**
	 * Removes all the ency workflow transition instances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of ency workflow transition instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ency workflow transition instances
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the ency workflow transition instance where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTransitionInstanceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a matching ency workflow transition instance could not be found
	 */
	public static EncyWorkflowTransitionInstance findByUUID_G(
			String uuid, long groupId)
		throws cz.csob.ency.workflow.exception.
			NoSuchTransitionInstanceException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ency workflow transition instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	public static EncyWorkflowTransitionInstance fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ency workflow transition instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	public static EncyWorkflowTransitionInstance fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the ency workflow transition instance where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ency workflow transition instance that was removed
	 */
	public static EncyWorkflowTransitionInstance removeByUUID_G(
			String uuid, long groupId)
		throws cz.csob.ency.workflow.exception.
			NoSuchTransitionInstanceException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of ency workflow transition instances where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ency workflow transition instances
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the ency workflow transition instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ency workflow transition instances
	 */
	public static List<EncyWorkflowTransitionInstance> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the ency workflow transition instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @return the range of matching ency workflow transition instances
	 */
	public static List<EncyWorkflowTransitionInstance> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflow transition instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow transition instances
	 */
	public static List<EncyWorkflowTransitionInstance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow transition instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow transition instances
	 */
	public static List<EncyWorkflowTransitionInstance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ency workflow transition instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a matching ency workflow transition instance could not be found
	 */
	public static EncyWorkflowTransitionInstance findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.
			NoSuchTransitionInstanceException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first ency workflow transition instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	public static EncyWorkflowTransitionInstance fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow transition instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a matching ency workflow transition instance could not be found
	 */
	public static EncyWorkflowTransitionInstance findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.
			NoSuchTransitionInstanceException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow transition instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	public static EncyWorkflowTransitionInstance fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the ency workflow transition instances before and after the current ency workflow transition instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param transitionInstanceId the primary key of the current ency workflow transition instance
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a ency workflow transition instance with the primary key could not be found
	 */
	public static EncyWorkflowTransitionInstance[] findByUuid_C_PrevAndNext(
			long transitionInstanceId, String uuid, long companyId,
			OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.
			NoSuchTransitionInstanceException {

		return getPersistence().findByUuid_C_PrevAndNext(
			transitionInstanceId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the ency workflow transition instances where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of ency workflow transition instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ency workflow transition instances
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the ency workflow transition instances where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @return the matching ency workflow transition instances
	 */
	public static List<EncyWorkflowTransitionInstance> findByWorkflowInstanceId(
		long workflowInstanceId) {

		return getPersistence().findByWorkflowInstanceId(workflowInstanceId);
	}

	/**
	 * Returns a range of all the ency workflow transition instances where workflowInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @return the range of matching ency workflow transition instances
	 */
	public static List<EncyWorkflowTransitionInstance> findByWorkflowInstanceId(
		long workflowInstanceId, int start, int end) {

		return getPersistence().findByWorkflowInstanceId(
			workflowInstanceId, start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflow transition instances where workflowInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow transition instances
	 */
	public static List<EncyWorkflowTransitionInstance> findByWorkflowInstanceId(
		long workflowInstanceId, int start, int end,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator) {

		return getPersistence().findByWorkflowInstanceId(
			workflowInstanceId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow transition instances where workflowInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow transition instances
	 */
	public static List<EncyWorkflowTransitionInstance> findByWorkflowInstanceId(
		long workflowInstanceId, int start, int end,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByWorkflowInstanceId(
			workflowInstanceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ency workflow transition instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a matching ency workflow transition instance could not be found
	 */
	public static EncyWorkflowTransitionInstance findByWorkflowInstanceId_First(
			long workflowInstanceId,
			OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.
			NoSuchTransitionInstanceException {

		return getPersistence().findByWorkflowInstanceId_First(
			workflowInstanceId, orderByComparator);
	}

	/**
	 * Returns the first ency workflow transition instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	public static EncyWorkflowTransitionInstance
		fetchByWorkflowInstanceId_First(
			long workflowInstanceId,
			OrderByComparator<EncyWorkflowTransitionInstance>
				orderByComparator) {

		return getPersistence().fetchByWorkflowInstanceId_First(
			workflowInstanceId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow transition instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a matching ency workflow transition instance could not be found
	 */
	public static EncyWorkflowTransitionInstance findByWorkflowInstanceId_Last(
			long workflowInstanceId,
			OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.
			NoSuchTransitionInstanceException {

		return getPersistence().findByWorkflowInstanceId_Last(
			workflowInstanceId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow transition instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	public static EncyWorkflowTransitionInstance fetchByWorkflowInstanceId_Last(
		long workflowInstanceId,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator) {

		return getPersistence().fetchByWorkflowInstanceId_Last(
			workflowInstanceId, orderByComparator);
	}

	/**
	 * Returns the ency workflow transition instances before and after the current ency workflow transition instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param transitionInstanceId the primary key of the current ency workflow transition instance
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a ency workflow transition instance with the primary key could not be found
	 */
	public static EncyWorkflowTransitionInstance[]
			findByWorkflowInstanceId_PrevAndNext(
				long transitionInstanceId, long workflowInstanceId,
				OrderByComparator<EncyWorkflowTransitionInstance>
					orderByComparator)
		throws cz.csob.ency.workflow.exception.
			NoSuchTransitionInstanceException {

		return getPersistence().findByWorkflowInstanceId_PrevAndNext(
			transitionInstanceId, workflowInstanceId, orderByComparator);
	}

	/**
	 * Removes all the ency workflow transition instances where workflowInstanceId = &#63; from the database.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 */
	public static void removeByWorkflowInstanceId(long workflowInstanceId) {
		getPersistence().removeByWorkflowInstanceId(workflowInstanceId);
	}

	/**
	 * Returns the number of ency workflow transition instances where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @return the number of matching ency workflow transition instances
	 */
	public static int countByWorkflowInstanceId(long workflowInstanceId) {
		return getPersistence().countByWorkflowInstanceId(workflowInstanceId);
	}

	/**
	 * Caches the ency workflow transition instance in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowTransitionInstance the ency workflow transition instance
	 */
	public static void cacheResult(
		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance) {

		getPersistence().cacheResult(encyWorkflowTransitionInstance);
	}

	/**
	 * Caches the ency workflow transition instances in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowTransitionInstances the ency workflow transition instances
	 */
	public static void cacheResult(
		List<EncyWorkflowTransitionInstance> encyWorkflowTransitionInstances) {

		getPersistence().cacheResult(encyWorkflowTransitionInstances);
	}

	/**
	 * Creates a new ency workflow transition instance with the primary key. Does not add the ency workflow transition instance to the database.
	 *
	 * @param transitionInstanceId the primary key for the new ency workflow transition instance
	 * @return the new ency workflow transition instance
	 */
	public static EncyWorkflowTransitionInstance create(
		long transitionInstanceId) {

		return getPersistence().create(transitionInstanceId);
	}

	/**
	 * Removes the ency workflow transition instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transitionInstanceId the primary key of the ency workflow transition instance
	 * @return the ency workflow transition instance that was removed
	 * @throws NoSuchTransitionInstanceException if a ency workflow transition instance with the primary key could not be found
	 */
	public static EncyWorkflowTransitionInstance remove(
			long transitionInstanceId)
		throws cz.csob.ency.workflow.exception.
			NoSuchTransitionInstanceException {

		return getPersistence().remove(transitionInstanceId);
	}

	public static EncyWorkflowTransitionInstance updateImpl(
		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance) {

		return getPersistence().updateImpl(encyWorkflowTransitionInstance);
	}

	/**
	 * Returns the ency workflow transition instance with the primary key or throws a <code>NoSuchTransitionInstanceException</code> if it could not be found.
	 *
	 * @param transitionInstanceId the primary key of the ency workflow transition instance
	 * @return the ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a ency workflow transition instance with the primary key could not be found
	 */
	public static EncyWorkflowTransitionInstance findByPrimaryKey(
			long transitionInstanceId)
		throws cz.csob.ency.workflow.exception.
			NoSuchTransitionInstanceException {

		return getPersistence().findByPrimaryKey(transitionInstanceId);
	}

	/**
	 * Returns the ency workflow transition instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param transitionInstanceId the primary key of the ency workflow transition instance
	 * @return the ency workflow transition instance, or <code>null</code> if a ency workflow transition instance with the primary key could not be found
	 */
	public static EncyWorkflowTransitionInstance fetchByPrimaryKey(
		long transitionInstanceId) {

		return getPersistence().fetchByPrimaryKey(transitionInstanceId);
	}

	/**
	 * Returns all the ency workflow transition instances.
	 *
	 * @return the ency workflow transition instances
	 */
	public static List<EncyWorkflowTransitionInstance> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ency workflow transition instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @return the range of ency workflow transition instances
	 */
	public static List<EncyWorkflowTransitionInstance> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflow transition instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ency workflow transition instances
	 */
	public static List<EncyWorkflowTransitionInstance> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow transition instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ency workflow transition instances
	 */
	public static List<EncyWorkflowTransitionInstance> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ency workflow transition instances from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ency workflow transition instances.
	 *
	 * @return the number of ency workflow transition instances
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EncyWorkflowTransitionInstancePersistence getPersistence() {
		return _persistence;
	}

	private static volatile EncyWorkflowTransitionInstancePersistence
		_persistence;

}