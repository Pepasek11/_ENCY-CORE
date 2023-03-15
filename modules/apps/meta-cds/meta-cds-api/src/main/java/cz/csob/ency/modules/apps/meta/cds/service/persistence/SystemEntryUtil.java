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

package cz.csob.ency.modules.apps.meta.cds.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import cz.csob.ency.modules.apps.meta.cds.model.SystemEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the system entry service. This utility wraps <code>cz.csob.ency.modules.apps.meta.cds.service.persistence.impl.SystemEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author "Miroslav Čermák"
 * @see SystemEntryPersistence
 * @generated
 */
public class SystemEntryUtil {

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
	public static void clearCache(SystemEntry systemEntry) {
		getPersistence().clearCache(systemEntry);
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
	public static Map<Serializable, SystemEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SystemEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SystemEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SystemEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SystemEntry update(SystemEntry systemEntry) {
		return getPersistence().update(systemEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SystemEntry update(
		SystemEntry systemEntry, ServiceContext serviceContext) {

		return getPersistence().update(systemEntry, serviceContext);
	}

	/**
	 * Returns all the system entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the system entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first system entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByUuid_First(
			String uuid, OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first system entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByUuid_First(
		String uuid, OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByUuid_Last(
			String uuid, OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByUuid_Last(
		String uuid, OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where uuid = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry[] findByUuid_PrevAndNext(
			long systemEntryId, String uuid,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			systemEntryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the system entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of system entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching system entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the system entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSystemEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByUUID_G(String uuid, long groupId)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the system entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the system entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the system entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the system entry that was removed
	 */
	public static SystemEntry removeByUUID_G(String uuid, long groupId)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of system entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching system entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the system entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the system entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first system entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first system entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry[] findByUuid_C_PrevAndNext(
			long systemEntryId, String uuid, long companyId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			systemEntryId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the system entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of system entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching system entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the system entries where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findByC_S(long companyId, int status) {
		return getPersistence().findByC_S(companyId, status);
	}

	/**
	 * Returns a range of all the system entries where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findByC_S(
		long companyId, int status, int start, int end) {

		return getPersistence().findByC_S(companyId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByC_S(
		long companyId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findByC_S(
			companyId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByC_S(
		long companyId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_S(
			companyId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first system entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByC_S_First(
			long companyId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByC_S_First(
			companyId, status, orderByComparator);
	}

	/**
	 * Returns the first system entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByC_S_First(
		long companyId, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByC_S_First(
			companyId, status, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByC_S_Last(
			long companyId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByC_S_Last(
			companyId, status, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByC_S_Last(
		long companyId, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByC_S_Last(
			companyId, status, orderByComparator);
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry[] findByC_S_PrevAndNext(
			long systemEntryId, long companyId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByC_S_PrevAndNext(
			systemEntryId, companyId, status, orderByComparator);
	}

	/**
	 * Returns all the system entries where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findByC_S(long companyId, int[] statuses) {
		return getPersistence().findByC_S(companyId, statuses);
	}

	/**
	 * Returns a range of all the system entries where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findByC_S(
		long companyId, int[] statuses, int start, int end) {

		return getPersistence().findByC_S(companyId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByC_S(
		long companyId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findByC_S(
			companyId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where companyId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByC_S(
		long companyId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_S(
			companyId, statuses, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the system entries where companyId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 */
	public static void removeByC_S(long companyId, int status) {
		getPersistence().removeByC_S(companyId, status);
	}

	/**
	 * Returns the number of system entries where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching system entries
	 */
	public static int countByC_S(long companyId, int status) {
		return getPersistence().countByC_S(companyId, status);
	}

	/**
	 * Returns the number of system entries where companyId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @return the number of matching system entries
	 */
	public static int countByC_S(long companyId, int[] statuses) {
		return getPersistence().countByC_S(companyId, statuses);
	}

	/**
	 * Returns all the system entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the system entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first system entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByG_S_First(
			long groupId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first system entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByG_S_Last(
			long groupId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry[] findByG_S_PrevAndNext(
			long systemEntryId, long groupId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByG_S_PrevAndNext(
			systemEntryId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the system entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByG_S(long groupId, int status) {
		return getPersistence().filterFindByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the system entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().filterFindByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set of system entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry[] filterFindByG_S_PrevAndNext(
			long systemEntryId, long groupId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().filterFindByG_S_PrevAndNext(
			systemEntryId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the system entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByG_S(
		long groupId, int[] statuses) {

		return getPersistence().filterFindByG_S(groupId, statuses);
	}

	/**
	 * Returns a range of all the system entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByG_S(
		long groupId, int[] statuses, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().filterFindByG_S(
			groupId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns all the system entries where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findByG_S(long groupId, int[] statuses) {
		return getPersistence().findByG_S(groupId, statuses);
	}

	/**
	 * Returns a range of all the system entries where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findByG_S(
		long groupId, int[] statuses, int start, int end) {

		return getPersistence().findByG_S(groupId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, statuses, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the system entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of system entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching system entries
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns the number of system entries where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching system entries
	 */
	public static int countByG_S(long groupId, int[] statuses) {
		return getPersistence().countByG_S(groupId, statuses);
	}

	/**
	 * Returns the number of system entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching system entries that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, int status) {
		return getPersistence().filterCountByG_S(groupId, status);
	}

	/**
	 * Returns the number of system entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching system entries that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, int[] statuses) {
		return getPersistence().filterCountByG_S(groupId, statuses);
	}

	/**
	 * Returns all the system entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findByC_U_S(
		long companyId, long userId, int status) {

		return getPersistence().findByC_U_S(companyId, userId, status);
	}

	/**
	 * Returns a range of all the system entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end) {

		return getPersistence().findByC_U_S(
			companyId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findByC_U_S(
			companyId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_U_S(
			companyId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first system entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByC_U_S_First(
			long companyId, long userId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByC_U_S_First(
			companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first system entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByC_U_S_First(
		long companyId, long userId, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByC_U_S_First(
			companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByC_U_S_Last(
			long companyId, long userId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByC_U_S_Last(
			companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByC_U_S_Last(
		long companyId, long userId, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByC_U_S_Last(
			companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry[] findByC_U_S_PrevAndNext(
			long systemEntryId, long companyId, long userId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByC_U_S_PrevAndNext(
			systemEntryId, companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the system entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findByC_U_S(
		long companyId, long userId, int[] statuses) {

		return getPersistence().findByC_U_S(companyId, userId, statuses);
	}

	/**
	 * Returns a range of all the system entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end) {

		return getPersistence().findByC_U_S(
			companyId, userId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findByC_U_S(
			companyId, userId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where companyId = &#63; and userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_U_S(
			companyId, userId, statuses, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the system entries where companyId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByC_U_S(long companyId, long userId, int status) {
		getPersistence().removeByC_U_S(companyId, userId, status);
	}

	/**
	 * Returns the number of system entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching system entries
	 */
	public static int countByC_U_S(long companyId, long userId, int status) {
		return getPersistence().countByC_U_S(companyId, userId, status);
	}

	/**
	 * Returns the number of system entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching system entries
	 */
	public static int countByC_U_S(
		long companyId, long userId, int[] statuses) {

		return getPersistence().countByC_U_S(companyId, userId, statuses);
	}

	/**
	 * Returns all the system entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().findByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns a range of all the system entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first system entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByG_U_S_First(
			long groupId, long userId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first system entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByG_U_S_First(
		long groupId, long userId, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByG_U_S_Last(
			long groupId, long userId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByG_U_S_Last(
		long groupId, long userId, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry[] findByG_U_S_PrevAndNext(
			long systemEntryId, long groupId, long userId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByG_U_S_PrevAndNext(
			systemEntryId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the system entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().filterFindByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns a range of all the system entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries that the user has permissions to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set of system entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry[] filterFindByG_U_S_PrevAndNext(
			long systemEntryId, long groupId, long userId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().filterFindByG_U_S_PrevAndNext(
			systemEntryId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the system entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses) {

		return getPersistence().filterFindByG_U_S(groupId, userId, statuses);
	}

	/**
	 * Returns a range of all the system entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns all the system entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findByG_U_S(
		long groupId, long userId, int[] statuses) {

		return getPersistence().findByG_U_S(groupId, userId, statuses);
	}

	/**
	 * Returns a range of all the system entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end) {

		return getPersistence().findByG_U_S(
			groupId, userId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findByG_U_S(
			groupId, userId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_U_S(
			groupId, userId, statuses, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the system entries where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByG_U_S(long groupId, long userId, int status) {
		getPersistence().removeByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of system entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching system entries
	 */
	public static int countByG_U_S(long groupId, long userId, int status) {
		return getPersistence().countByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of system entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching system entries
	 */
	public static int countByG_U_S(long groupId, long userId, int[] statuses) {
		return getPersistence().countByG_U_S(groupId, userId, statuses);
	}

	/**
	 * Returns the number of system entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching system entries that the user has permission to view
	 */
	public static int filterCountByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().filterCountByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of system entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching system entries that the user has permission to view
	 */
	public static int filterCountByG_U_S(
		long groupId, long userId, int[] statuses) {

		return getPersistence().filterCountByG_U_S(groupId, userId, statuses);
	}

	/**
	 * Returns all the system entries where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findByU_S(long userId, int status) {
		return getPersistence().findByU_S(userId, status);
	}

	/**
	 * Returns a range of all the system entries where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findByU_S(
		long userId, int status, int start, int end) {

		return getPersistence().findByU_S(userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first system entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByU_S_First(
			long userId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the first system entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByU_S_First(
		long userId, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByU_S_Last(
			long userId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByU_S_Last(
		long userId, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry[] findByU_S_PrevAndNext(
			long systemEntryId, long userId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByU_S_PrevAndNext(
			systemEntryId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the system entries where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findByU_S(long userId, int[] statuses) {
		return getPersistence().findByU_S(userId, statuses);
	}

	/**
	 * Returns a range of all the system entries where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findByU_S(
		long userId, int[] statuses, int start, int end) {

		return getPersistence().findByU_S(userId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByU_S(
		long userId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findByU_S(
			userId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByU_S(
		long userId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByU_S(
			userId, statuses, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the system entries where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByU_S(long userId, int status) {
		getPersistence().removeByU_S(userId, status);
	}

	/**
	 * Returns the number of system entries where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching system entries
	 */
	public static int countByU_S(long userId, int status) {
		return getPersistence().countByU_S(userId, status);
	}

	/**
	 * Returns the number of system entries where userId = &#63; and status = any &#63;.
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching system entries
	 */
	public static int countByU_S(long userId, int[] statuses) {
		return getPersistence().countByU_S(userId, statuses);
	}

	/**
	 * Returns all the system entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return getPersistence().findByG_UT_ST(groupId, urlTitle, status);
	}

	/**
	 * Returns a range of all the system entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, status, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first system entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByG_UT_ST_First(
			long groupId, String urlTitle, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByG_UT_ST_First(
			groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns the first system entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByG_UT_ST_First(
		long groupId, String urlTitle, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByG_UT_ST_First(
			groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByG_UT_ST_Last(
			long groupId, String urlTitle, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByG_UT_ST_Last(
			groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByG_UT_ST_Last(
		long groupId, String urlTitle, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByG_UT_ST_Last(
			groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry[] findByG_UT_ST_PrevAndNext(
			long systemEntryId, long groupId, String urlTitle, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByG_UT_ST_PrevAndNext(
			systemEntryId, groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns all the system entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return getPersistence().filterFindByG_UT_ST(groupId, urlTitle, status);
	}

	/**
	 * Returns a range of all the system entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, status, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries that the user has permissions to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, status, start, end, orderByComparator);
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set of system entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry[] filterFindByG_UT_ST_PrevAndNext(
			long systemEntryId, long groupId, String urlTitle, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().filterFindByG_UT_ST_PrevAndNext(
			systemEntryId, groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns all the system entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, statuses);
	}

	/**
	 * Returns a range of all the system entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns all the system entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return getPersistence().findByG_UT_ST(groupId, urlTitle, statuses);
	}

	/**
	 * Returns a range of all the system entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and urlTitle = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, statuses, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the system entries where groupId = &#63; and urlTitle = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 */
	public static void removeByG_UT_ST(
		long groupId, String urlTitle, int status) {

		getPersistence().removeByG_UT_ST(groupId, urlTitle, status);
	}

	/**
	 * Returns the number of system entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching system entries
	 */
	public static int countByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return getPersistence().countByG_UT_ST(groupId, urlTitle, status);
	}

	/**
	 * Returns the number of system entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching system entries
	 */
	public static int countByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return getPersistence().countByG_UT_ST(groupId, urlTitle, statuses);
	}

	/**
	 * Returns the number of system entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching system entries that the user has permission to view
	 */
	public static int filterCountByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return getPersistence().filterCountByG_UT_ST(groupId, urlTitle, status);
	}

	/**
	 * Returns the number of system entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching system entries that the user has permission to view
	 */
	public static int filterCountByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return getPersistence().filterCountByG_UT_ST(
			groupId, urlTitle, statuses);
	}

	/**
	 * Returns the system entry where groupId = &#63; and urlTitle = &#63; or throws a <code>NoSuchSystemEntryException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByG_UT(long groupId, String urlTitle)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByG_UT(groupId, urlTitle);
	}

	/**
	 * Returns the system entry where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByG_UT(long groupId, String urlTitle) {
		return getPersistence().fetchByG_UT(groupId, urlTitle);
	}

	/**
	 * Returns the system entry where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByG_UT(
		long groupId, String urlTitle, boolean useFinderCache) {

		return getPersistence().fetchByG_UT(groupId, urlTitle, useFinderCache);
	}

	/**
	 * Removes the system entry where groupId = &#63; and urlTitle = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the system entry that was removed
	 */
	public static SystemEntry removeByG_UT(long groupId, String urlTitle)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().removeByG_UT(groupId, urlTitle);
	}

	/**
	 * Returns the number of system entries where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the number of matching system entries
	 */
	public static int countByG_UT(long groupId, String urlTitle) {
		return getPersistence().countByG_UT(groupId, urlTitle);
	}

	/**
	 * Returns the system entry where urlTitle = &#63; or throws a <code>NoSuchSystemEntryException</code> if it could not be found.
	 *
	 * @param urlTitle the url title
	 * @return the matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByURLTitle(String urlTitle)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByURLTitle(urlTitle);
	}

	/**
	 * Returns the system entry where urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param urlTitle the url title
	 * @return the matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByURLTitle(String urlTitle) {
		return getPersistence().fetchByURLTitle(urlTitle);
	}

	/**
	 * Returns the system entry where urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByURLTitle(
		String urlTitle, boolean useFinderCache) {

		return getPersistence().fetchByURLTitle(urlTitle, useFinderCache);
	}

	/**
	 * Removes the system entry where urlTitle = &#63; from the database.
	 *
	 * @param urlTitle the url title
	 * @return the system entry that was removed
	 */
	public static SystemEntry removeByURLTitle(String urlTitle)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().removeByURLTitle(urlTitle);
	}

	/**
	 * Returns the number of system entries where urlTitle = &#63;.
	 *
	 * @param urlTitle the url title
	 * @return the number of matching system entries
	 */
	public static int countByURLTitle(String urlTitle) {
		return getPersistence().countByURLTitle(urlTitle);
	}

	/**
	 * Returns all the system entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the system entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first system entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByGroupId_First(
			long groupId, OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first system entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByGroupId_First(
		long groupId, OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByGroupId_Last(
			long groupId, OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByGroupId_Last(
		long groupId, OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where groupId = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry[] findByGroupId_PrevAndNext(
			long systemEntryId, long groupId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByGroupId_PrevAndNext(
			systemEntryId, groupId, orderByComparator);
	}

	/**
	 * Returns all the system entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the system entries that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set of system entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry[] filterFindByGroupId_PrevAndNext(
			long systemEntryId, long groupId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			systemEntryId, groupId, orderByComparator);
	}

	/**
	 * Removes all the system entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of system entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching system entries
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of system entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching system entries that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns all the system entries where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findByUserIdGroupId(
		long userId, long groupId) {

		return getPersistence().findByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns a range of all the system entries where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end) {

		return getPersistence().findByUserIdGroupId(
			userId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findByUserIdGroupId(
			userId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserIdGroupId(
			userId, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first system entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByUserIdGroupId_First(
			long userId, long groupId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByUserIdGroupId_First(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the first system entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByUserIdGroupId_First(
		long userId, long groupId,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByUserIdGroupId_First(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByUserIdGroupId_Last(
			long userId, long groupId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByUserIdGroupId_Last(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByUserIdGroupId_Last(
		long userId, long groupId,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByUserIdGroupId_Last(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry[] findByUserIdGroupId_PrevAndNext(
			long systemEntryId, long userId, long groupId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByUserIdGroupId_PrevAndNext(
			systemEntryId, userId, groupId, orderByComparator);
	}

	/**
	 * Returns all the system entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByUserIdGroupId(
		long userId, long groupId) {

		return getPersistence().filterFindByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns a range of all the system entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end) {

		return getPersistence().filterFindByUserIdGroupId(
			userId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries that the user has permissions to view where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries that the user has permission to view
	 */
	public static List<SystemEntry> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().filterFindByUserIdGroupId(
			userId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set of system entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry[] filterFindByUserIdGroupId_PrevAndNext(
			long systemEntryId, long userId, long groupId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().filterFindByUserIdGroupId_PrevAndNext(
			systemEntryId, userId, groupId, orderByComparator);
	}

	/**
	 * Removes all the system entries where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 */
	public static void removeByUserIdGroupId(long userId, long groupId) {
		getPersistence().removeByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns the number of system entries where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching system entries
	 */
	public static int countByUserIdGroupId(long userId, long groupId) {
		return getPersistence().countByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns the number of system entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching system entries that the user has permission to view
	 */
	public static int filterCountByUserIdGroupId(long userId, long groupId) {
		return getPersistence().filterCountByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns all the system entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the system entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByUserId(
		long userId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByUserId(
		long userId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first system entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByUserId_First(
			long userId, OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first system entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByUserId_First(
		long userId, OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByUserId_Last(
			long userId, OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByUserId_Last(
		long userId, OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where userId = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry[] findByUserId_PrevAndNext(
			long systemEntryId, long userId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByUserId_PrevAndNext(
			systemEntryId, userId, orderByComparator);
	}

	/**
	 * Removes all the system entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of system entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching system entries
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the system entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findByCompanyId(long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	 * Returns a range of all the system entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findByCompanyId(
		long companyId, int start, int end) {

		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first system entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByCompanyId_First(
			long companyId, OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first system entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByCompanyId_First(
		long companyId, OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByCompanyId_Last(
			long companyId, OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByCompanyId_Last(
		long companyId, OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where companyId = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry[] findByCompanyId_PrevAndNext(
			long systemEntryId, long companyId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByCompanyId_PrevAndNext(
			systemEntryId, companyId, orderByComparator);
	}

	/**
	 * Removes all the system entries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	 * Returns the number of system entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching system entries
	 */
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	 * Returns all the system entries where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findBySystemEntryId(long systemEntryId) {
		return getPersistence().findBySystemEntryId(systemEntryId);
	}

	/**
	 * Returns a range of all the system entries where systemEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findBySystemEntryId(
		long systemEntryId, int start, int end) {

		return getPersistence().findBySystemEntryId(systemEntryId, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where systemEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findBySystemEntryId(
		long systemEntryId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findBySystemEntryId(
			systemEntryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where systemEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findBySystemEntryId(
		long systemEntryId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySystemEntryId(
			systemEntryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first system entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findBySystemEntryId_First(
			long systemEntryId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findBySystemEntryId_First(
			systemEntryId, orderByComparator);
	}

	/**
	 * Returns the first system entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchBySystemEntryId_First(
		long systemEntryId, OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchBySystemEntryId_First(
			systemEntryId, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findBySystemEntryId_Last(
			long systemEntryId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findBySystemEntryId_Last(
			systemEntryId, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchBySystemEntryId_Last(
		long systemEntryId, OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchBySystemEntryId_Last(
			systemEntryId, orderByComparator);
	}

	/**
	 * Removes all the system entries where systemEntryId = &#63; from the database.
	 *
	 * @param systemEntryId the system entry ID
	 */
	public static void removeBySystemEntryId(long systemEntryId) {
		getPersistence().removeBySystemEntryId(systemEntryId);
	}

	/**
	 * Returns the number of system entries where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @return the number of matching system entries
	 */
	public static int countBySystemEntryId(long systemEntryId) {
		return getPersistence().countBySystemEntryId(systemEntryId);
	}

	/**
	 * Returns all the system entries where systemCode = &#63;.
	 *
	 * @param systemCode the system code
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findBySystemCode(long systemCode) {
		return getPersistence().findBySystemCode(systemCode);
	}

	/**
	 * Returns a range of all the system entries where systemCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemCode the system code
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findBySystemCode(
		long systemCode, int start, int end) {

		return getPersistence().findBySystemCode(systemCode, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where systemCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemCode the system code
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findBySystemCode(
		long systemCode, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findBySystemCode(
			systemCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where systemCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemCode the system code
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findBySystemCode(
		long systemCode, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySystemCode(
			systemCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first system entry in the ordered set where systemCode = &#63;.
	 *
	 * @param systemCode the system code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findBySystemCode_First(
			long systemCode, OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findBySystemCode_First(
			systemCode, orderByComparator);
	}

	/**
	 * Returns the first system entry in the ordered set where systemCode = &#63;.
	 *
	 * @param systemCode the system code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchBySystemCode_First(
		long systemCode, OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchBySystemCode_First(
			systemCode, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where systemCode = &#63;.
	 *
	 * @param systemCode the system code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findBySystemCode_Last(
			long systemCode, OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findBySystemCode_Last(
			systemCode, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where systemCode = &#63;.
	 *
	 * @param systemCode the system code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchBySystemCode_Last(
		long systemCode, OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchBySystemCode_Last(
			systemCode, orderByComparator);
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where systemCode = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param systemCode the system code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry[] findBySystemCode_PrevAndNext(
			long systemEntryId, long systemCode,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findBySystemCode_PrevAndNext(
			systemEntryId, systemCode, orderByComparator);
	}

	/**
	 * Removes all the system entries where systemCode = &#63; from the database.
	 *
	 * @param systemCode the system code
	 */
	public static void removeBySystemCode(long systemCode) {
		getPersistence().removeBySystemCode(systemCode);
	}

	/**
	 * Returns the number of system entries where systemCode = &#63;.
	 *
	 * @param systemCode the system code
	 * @return the number of matching system entries
	 */
	public static int countBySystemCode(long systemCode) {
		return getPersistence().countBySystemCode(systemCode);
	}

	/**
	 * Returns all the system entries where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findBySystemName(String systemName) {
		return getPersistence().findBySystemName(systemName);
	}

	/**
	 * Returns a range of all the system entries where systemName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemName the system name
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findBySystemName(
		String systemName, int start, int end) {

		return getPersistence().findBySystemName(systemName, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where systemName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemName the system name
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findBySystemName(
		String systemName, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findBySystemName(
			systemName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where systemName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemName the system name
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findBySystemName(
		String systemName, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySystemName(
			systemName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first system entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findBySystemName_First(
			String systemName, OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findBySystemName_First(
			systemName, orderByComparator);
	}

	/**
	 * Returns the first system entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchBySystemName_First(
		String systemName, OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchBySystemName_First(
			systemName, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findBySystemName_Last(
			String systemName, OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findBySystemName_Last(
			systemName, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchBySystemName_Last(
		String systemName, OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchBySystemName_Last(
			systemName, orderByComparator);
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry[] findBySystemName_PrevAndNext(
			long systemEntryId, String systemName,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findBySystemName_PrevAndNext(
			systemEntryId, systemName, orderByComparator);
	}

	/**
	 * Removes all the system entries where systemName = &#63; from the database.
	 *
	 * @param systemName the system name
	 */
	public static void removeBySystemName(String systemName) {
		getPersistence().removeBySystemName(systemName);
	}

	/**
	 * Returns the number of system entries where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @return the number of matching system entries
	 */
	public static int countBySystemName(String systemName) {
		return getPersistence().countBySystemName(systemName);
	}

	/**
	 * Returns all the system entries where isSlaSigned = &#63;.
	 *
	 * @param isSlaSigned the is sla signed
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findByIsSlaSigned(boolean isSlaSigned) {
		return getPersistence().findByIsSlaSigned(isSlaSigned);
	}

	/**
	 * Returns a range of all the system entries where isSlaSigned = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isSlaSigned the is sla signed
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findByIsSlaSigned(
		boolean isSlaSigned, int start, int end) {

		return getPersistence().findByIsSlaSigned(isSlaSigned, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where isSlaSigned = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isSlaSigned the is sla signed
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByIsSlaSigned(
		boolean isSlaSigned, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findByIsSlaSigned(
			isSlaSigned, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where isSlaSigned = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isSlaSigned the is sla signed
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByIsSlaSigned(
		boolean isSlaSigned, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByIsSlaSigned(
			isSlaSigned, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first system entry in the ordered set where isSlaSigned = &#63;.
	 *
	 * @param isSlaSigned the is sla signed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByIsSlaSigned_First(
			boolean isSlaSigned,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByIsSlaSigned_First(
			isSlaSigned, orderByComparator);
	}

	/**
	 * Returns the first system entry in the ordered set where isSlaSigned = &#63;.
	 *
	 * @param isSlaSigned the is sla signed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByIsSlaSigned_First(
		boolean isSlaSigned, OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByIsSlaSigned_First(
			isSlaSigned, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where isSlaSigned = &#63;.
	 *
	 * @param isSlaSigned the is sla signed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByIsSlaSigned_Last(
			boolean isSlaSigned,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByIsSlaSigned_Last(
			isSlaSigned, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where isSlaSigned = &#63;.
	 *
	 * @param isSlaSigned the is sla signed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByIsSlaSigned_Last(
		boolean isSlaSigned, OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByIsSlaSigned_Last(
			isSlaSigned, orderByComparator);
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where isSlaSigned = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param isSlaSigned the is sla signed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry[] findByIsSlaSigned_PrevAndNext(
			long systemEntryId, boolean isSlaSigned,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByIsSlaSigned_PrevAndNext(
			systemEntryId, isSlaSigned, orderByComparator);
	}

	/**
	 * Removes all the system entries where isSlaSigned = &#63; from the database.
	 *
	 * @param isSlaSigned the is sla signed
	 */
	public static void removeByIsSlaSigned(boolean isSlaSigned) {
		getPersistence().removeByIsSlaSigned(isSlaSigned);
	}

	/**
	 * Returns the number of system entries where isSlaSigned = &#63;.
	 *
	 * @param isSlaSigned the is sla signed
	 * @return the number of matching system entries
	 */
	public static int countByIsSlaSigned(boolean isSlaSigned) {
		return getPersistence().countByIsSlaSigned(isSlaSigned);
	}

	/**
	 * Returns all the system entries where isSelfBi = &#63;.
	 *
	 * @param isSelfBi the is self bi
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findByIsSelfBi(boolean isSelfBi) {
		return getPersistence().findByIsSelfBi(isSelfBi);
	}

	/**
	 * Returns a range of all the system entries where isSelfBi = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isSelfBi the is self bi
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findByIsSelfBi(
		boolean isSelfBi, int start, int end) {

		return getPersistence().findByIsSelfBi(isSelfBi, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where isSelfBi = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isSelfBi the is self bi
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByIsSelfBi(
		boolean isSelfBi, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findByIsSelfBi(
			isSelfBi, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where isSelfBi = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isSelfBi the is self bi
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByIsSelfBi(
		boolean isSelfBi, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByIsSelfBi(
			isSelfBi, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first system entry in the ordered set where isSelfBi = &#63;.
	 *
	 * @param isSelfBi the is self bi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByIsSelfBi_First(
			boolean isSelfBi, OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByIsSelfBi_First(
			isSelfBi, orderByComparator);
	}

	/**
	 * Returns the first system entry in the ordered set where isSelfBi = &#63;.
	 *
	 * @param isSelfBi the is self bi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByIsSelfBi_First(
		boolean isSelfBi, OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByIsSelfBi_First(
			isSelfBi, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where isSelfBi = &#63;.
	 *
	 * @param isSelfBi the is self bi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByIsSelfBi_Last(
			boolean isSelfBi, OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByIsSelfBi_Last(
			isSelfBi, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where isSelfBi = &#63;.
	 *
	 * @param isSelfBi the is self bi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByIsSelfBi_Last(
		boolean isSelfBi, OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByIsSelfBi_Last(
			isSelfBi, orderByComparator);
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where isSelfBi = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param isSelfBi the is self bi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry[] findByIsSelfBi_PrevAndNext(
			long systemEntryId, boolean isSelfBi,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByIsSelfBi_PrevAndNext(
			systemEntryId, isSelfBi, orderByComparator);
	}

	/**
	 * Removes all the system entries where isSelfBi = &#63; from the database.
	 *
	 * @param isSelfBi the is self bi
	 */
	public static void removeByIsSelfBi(boolean isSelfBi) {
		getPersistence().removeByIsSelfBi(isSelfBi);
	}

	/**
	 * Returns the number of system entries where isSelfBi = &#63;.
	 *
	 * @param isSelfBi the is self bi
	 * @return the number of matching system entries
	 */
	public static int countByIsSelfBi(boolean isSelfBi) {
		return getPersistence().countByIsSelfBi(isSelfBi);
	}

	/**
	 * Returns all the system entries where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the matching system entries
	 */
	public static List<SystemEntry> findByIsActive(boolean isActive) {
		return getPersistence().findByIsActive(isActive);
	}

	/**
	 * Returns a range of all the system entries where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	public static List<SystemEntry> findByIsActive(
		boolean isActive, int start, int end) {

		return getPersistence().findByIsActive(isActive, start, end);
	}

	/**
	 * Returns an ordered range of all the system entries where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByIsActive(
		boolean isActive, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findByIsActive(
			isActive, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	public static List<SystemEntry> findByIsActive(
		boolean isActive, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByIsActive(
			isActive, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first system entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByIsActive_First(
			boolean isActive, OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByIsActive_First(
			isActive, orderByComparator);
	}

	/**
	 * Returns the first system entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByIsActive_First(
		boolean isActive, OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByIsActive_First(
			isActive, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public static SystemEntry findByIsActive_Last(
			boolean isActive, OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByIsActive_Last(
			isActive, orderByComparator);
	}

	/**
	 * Returns the last system entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public static SystemEntry fetchByIsActive_Last(
		boolean isActive, OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().fetchByIsActive_Last(
			isActive, orderByComparator);
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where isActive = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry[] findByIsActive_PrevAndNext(
			long systemEntryId, boolean isActive,
			OrderByComparator<SystemEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByIsActive_PrevAndNext(
			systemEntryId, isActive, orderByComparator);
	}

	/**
	 * Removes all the system entries where isActive = &#63; from the database.
	 *
	 * @param isActive the is active
	 */
	public static void removeByIsActive(boolean isActive) {
		getPersistence().removeByIsActive(isActive);
	}

	/**
	 * Returns the number of system entries where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the number of matching system entries
	 */
	public static int countByIsActive(boolean isActive) {
		return getPersistence().countByIsActive(isActive);
	}

	/**
	 * Caches the system entry in the entity cache if it is enabled.
	 *
	 * @param systemEntry the system entry
	 */
	public static void cacheResult(SystemEntry systemEntry) {
		getPersistence().cacheResult(systemEntry);
	}

	/**
	 * Caches the system entries in the entity cache if it is enabled.
	 *
	 * @param systemEntries the system entries
	 */
	public static void cacheResult(List<SystemEntry> systemEntries) {
		getPersistence().cacheResult(systemEntries);
	}

	/**
	 * Creates a new system entry with the primary key. Does not add the system entry to the database.
	 *
	 * @param systemEntryId the primary key for the new system entry
	 * @return the new system entry
	 */
	public static SystemEntry create(long systemEntryId) {
		return getPersistence().create(systemEntryId);
	}

	/**
	 * Removes the system entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param systemEntryId the primary key of the system entry
	 * @return the system entry that was removed
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry remove(long systemEntryId)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().remove(systemEntryId);
	}

	public static SystemEntry updateImpl(SystemEntry systemEntry) {
		return getPersistence().updateImpl(systemEntry);
	}

	/**
	 * Returns the system entry with the primary key or throws a <code>NoSuchSystemEntryException</code> if it could not be found.
	 *
	 * @param systemEntryId the primary key of the system entry
	 * @return the system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public static SystemEntry findByPrimaryKey(long systemEntryId)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchSystemEntryException {

		return getPersistence().findByPrimaryKey(systemEntryId);
	}

	/**
	 * Returns the system entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param systemEntryId the primary key of the system entry
	 * @return the system entry, or <code>null</code> if a system entry with the primary key could not be found
	 */
	public static SystemEntry fetchByPrimaryKey(long systemEntryId) {
		return getPersistence().fetchByPrimaryKey(systemEntryId);
	}

	/**
	 * Returns all the system entries.
	 *
	 * @return the system entries
	 */
	public static List<SystemEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the system entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of system entries
	 */
	public static List<SystemEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the system entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of system entries
	 */
	public static List<SystemEntry> findAll(
		int start, int end, OrderByComparator<SystemEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the system entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of system entries
	 */
	public static List<SystemEntry> findAll(
		int start, int end, OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the system entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of system entries.
	 *
	 * @return the number of system entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SystemEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SystemEntryPersistence _persistence;

}