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

import cz.csob.ency.workflow.model.EncyWorkflowInstance;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the ency workflow instance service. This utility wraps <code>cz.csob.ency.workflow.service.persistence.impl.EncyWorkflowInstancePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowInstancePersistence
 * @generated
 */
public class EncyWorkflowInstanceUtil {

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
	public static void clearCache(EncyWorkflowInstance encyWorkflowInstance) {
		getPersistence().clearCache(encyWorkflowInstance);
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
	public static Map<Serializable, EncyWorkflowInstance> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EncyWorkflowInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EncyWorkflowInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EncyWorkflowInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EncyWorkflowInstance> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EncyWorkflowInstance update(
		EncyWorkflowInstance encyWorkflowInstance) {

		return getPersistence().update(encyWorkflowInstance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EncyWorkflowInstance update(
		EncyWorkflowInstance encyWorkflowInstance,
		ServiceContext serviceContext) {

		return getPersistence().update(encyWorkflowInstance, serviceContext);
	}

	/**
	 * Returns all the ency workflow instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ency workflow instances
	 */
	public static List<EncyWorkflowInstance> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the ency workflow instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @return the range of matching ency workflow instances
	 */
	public static List<EncyWorkflowInstance> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflow instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow instances
	 */
	public static List<EncyWorkflowInstance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowInstance> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow instances
	 */
	public static List<EncyWorkflowInstance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowInstance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ency workflow instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow instance
	 * @throws NoSuchInstanceException if a matching ency workflow instance could not be found
	 */
	public static EncyWorkflowInstance findByUuid_First(
			String uuid,
			OrderByComparator<EncyWorkflowInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchInstanceException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first ency workflow instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	public static EncyWorkflowInstance fetchByUuid_First(
		String uuid,
		OrderByComparator<EncyWorkflowInstance> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last ency workflow instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow instance
	 * @throws NoSuchInstanceException if a matching ency workflow instance could not be found
	 */
	public static EncyWorkflowInstance findByUuid_Last(
			String uuid,
			OrderByComparator<EncyWorkflowInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchInstanceException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last ency workflow instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	public static EncyWorkflowInstance fetchByUuid_Last(
		String uuid,
		OrderByComparator<EncyWorkflowInstance> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the ency workflow instances before and after the current ency workflow instance in the ordered set where uuid = &#63;.
	 *
	 * @param workflowInstanceId the primary key of the current ency workflow instance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow instance
	 * @throws NoSuchInstanceException if a ency workflow instance with the primary key could not be found
	 */
	public static EncyWorkflowInstance[] findByUuid_PrevAndNext(
			long workflowInstanceId, String uuid,
			OrderByComparator<EncyWorkflowInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchInstanceException {

		return getPersistence().findByUuid_PrevAndNext(
			workflowInstanceId, uuid, orderByComparator);
	}

	/**
	 * Removes all the ency workflow instances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of ency workflow instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ency workflow instances
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the ency workflow instance where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchInstanceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow instance
	 * @throws NoSuchInstanceException if a matching ency workflow instance could not be found
	 */
	public static EncyWorkflowInstance findByUUID_G(String uuid, long groupId)
		throws cz.csob.ency.workflow.exception.NoSuchInstanceException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ency workflow instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	public static EncyWorkflowInstance fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ency workflow instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	public static EncyWorkflowInstance fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the ency workflow instance where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ency workflow instance that was removed
	 */
	public static EncyWorkflowInstance removeByUUID_G(String uuid, long groupId)
		throws cz.csob.ency.workflow.exception.NoSuchInstanceException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of ency workflow instances where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ency workflow instances
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the ency workflow instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ency workflow instances
	 */
	public static List<EncyWorkflowInstance> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the ency workflow instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @return the range of matching ency workflow instances
	 */
	public static List<EncyWorkflowInstance> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflow instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow instances
	 */
	public static List<EncyWorkflowInstance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EncyWorkflowInstance> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow instances
	 */
	public static List<EncyWorkflowInstance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EncyWorkflowInstance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ency workflow instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow instance
	 * @throws NoSuchInstanceException if a matching ency workflow instance could not be found
	 */
	public static EncyWorkflowInstance findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EncyWorkflowInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchInstanceException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first ency workflow instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	public static EncyWorkflowInstance fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EncyWorkflowInstance> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow instance
	 * @throws NoSuchInstanceException if a matching ency workflow instance could not be found
	 */
	public static EncyWorkflowInstance findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EncyWorkflowInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchInstanceException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	public static EncyWorkflowInstance fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EncyWorkflowInstance> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the ency workflow instances before and after the current ency workflow instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param workflowInstanceId the primary key of the current ency workflow instance
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow instance
	 * @throws NoSuchInstanceException if a ency workflow instance with the primary key could not be found
	 */
	public static EncyWorkflowInstance[] findByUuid_C_PrevAndNext(
			long workflowInstanceId, String uuid, long companyId,
			OrderByComparator<EncyWorkflowInstance> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchInstanceException {

		return getPersistence().findByUuid_C_PrevAndNext(
			workflowInstanceId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the ency workflow instances where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of ency workflow instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ency workflow instances
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the ency workflow instance where className = &#63; and classPK = &#63; or throws a <code>NoSuchInstanceException</code> if it could not be found.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the matching ency workflow instance
	 * @throws NoSuchInstanceException if a matching ency workflow instance could not be found
	 */
	public static EncyWorkflowInstance findByC_C(String className, long classPK)
		throws cz.csob.ency.workflow.exception.NoSuchInstanceException {

		return getPersistence().findByC_C(className, classPK);
	}

	/**
	 * Returns the ency workflow instance where className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	public static EncyWorkflowInstance fetchByC_C(
		String className, long classPK) {

		return getPersistence().fetchByC_C(className, classPK);
	}

	/**
	 * Returns the ency workflow instance where className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	public static EncyWorkflowInstance fetchByC_C(
		String className, long classPK, boolean useFinderCache) {

		return getPersistence().fetchByC_C(className, classPK, useFinderCache);
	}

	/**
	 * Removes the ency workflow instance where className = &#63; and classPK = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the ency workflow instance that was removed
	 */
	public static EncyWorkflowInstance removeByC_C(
			String className, long classPK)
		throws cz.csob.ency.workflow.exception.NoSuchInstanceException {

		return getPersistence().removeByC_C(className, classPK);
	}

	/**
	 * Returns the number of ency workflow instances where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the number of matching ency workflow instances
	 */
	public static int countByC_C(String className, long classPK) {
		return getPersistence().countByC_C(className, classPK);
	}

	/**
	 * Caches the ency workflow instance in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowInstance the ency workflow instance
	 */
	public static void cacheResult(EncyWorkflowInstance encyWorkflowInstance) {
		getPersistence().cacheResult(encyWorkflowInstance);
	}

	/**
	 * Caches the ency workflow instances in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowInstances the ency workflow instances
	 */
	public static void cacheResult(
		List<EncyWorkflowInstance> encyWorkflowInstances) {

		getPersistence().cacheResult(encyWorkflowInstances);
	}

	/**
	 * Creates a new ency workflow instance with the primary key. Does not add the ency workflow instance to the database.
	 *
	 * @param workflowInstanceId the primary key for the new ency workflow instance
	 * @return the new ency workflow instance
	 */
	public static EncyWorkflowInstance create(long workflowInstanceId) {
		return getPersistence().create(workflowInstanceId);
	}

	/**
	 * Removes the ency workflow instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workflowInstanceId the primary key of the ency workflow instance
	 * @return the ency workflow instance that was removed
	 * @throws NoSuchInstanceException if a ency workflow instance with the primary key could not be found
	 */
	public static EncyWorkflowInstance remove(long workflowInstanceId)
		throws cz.csob.ency.workflow.exception.NoSuchInstanceException {

		return getPersistence().remove(workflowInstanceId);
	}

	public static EncyWorkflowInstance updateImpl(
		EncyWorkflowInstance encyWorkflowInstance) {

		return getPersistence().updateImpl(encyWorkflowInstance);
	}

	/**
	 * Returns the ency workflow instance with the primary key or throws a <code>NoSuchInstanceException</code> if it could not be found.
	 *
	 * @param workflowInstanceId the primary key of the ency workflow instance
	 * @return the ency workflow instance
	 * @throws NoSuchInstanceException if a ency workflow instance with the primary key could not be found
	 */
	public static EncyWorkflowInstance findByPrimaryKey(long workflowInstanceId)
		throws cz.csob.ency.workflow.exception.NoSuchInstanceException {

		return getPersistence().findByPrimaryKey(workflowInstanceId);
	}

	/**
	 * Returns the ency workflow instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workflowInstanceId the primary key of the ency workflow instance
	 * @return the ency workflow instance, or <code>null</code> if a ency workflow instance with the primary key could not be found
	 */
	public static EncyWorkflowInstance fetchByPrimaryKey(
		long workflowInstanceId) {

		return getPersistence().fetchByPrimaryKey(workflowInstanceId);
	}

	/**
	 * Returns all the ency workflow instances.
	 *
	 * @return the ency workflow instances
	 */
	public static List<EncyWorkflowInstance> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ency workflow instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @return the range of ency workflow instances
	 */
	public static List<EncyWorkflowInstance> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflow instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ency workflow instances
	 */
	public static List<EncyWorkflowInstance> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowInstance> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ency workflow instances
	 */
	public static List<EncyWorkflowInstance> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowInstance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ency workflow instances from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ency workflow instances.
	 *
	 * @return the number of ency workflow instances
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EncyWorkflowInstancePersistence getPersistence() {
		return _persistence;
	}

	private static volatile EncyWorkflowInstancePersistence _persistence;

}