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

import cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the column entry service. This utility wraps <code>cz.csob.ency.modules.apps.meta.cds.service.persistence.impl.ColumnEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author "Miroslav Čermák"
 * @see ColumnEntryPersistence
 * @generated
 */
public class ColumnEntryUtil {

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
	public static void clearCache(ColumnEntry columnEntry) {
		getPersistence().clearCache(columnEntry);
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
	public static Map<Serializable, ColumnEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ColumnEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ColumnEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ColumnEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ColumnEntry update(ColumnEntry columnEntry) {
		return getPersistence().update(columnEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ColumnEntry update(
		ColumnEntry columnEntry, ServiceContext serviceContext) {

		return getPersistence().update(columnEntry, serviceContext);
	}

	/**
	 * Returns all the column entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the column entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first column entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByUuid_First(
			String uuid, OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first column entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByUuid_First(
		String uuid, OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByUuid_Last(
			String uuid, OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByUuid_Last(
		String uuid, OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where uuid = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] findByUuid_PrevAndNext(
			long columnEntryId, String uuid,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			columnEntryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the column entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of column entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching column entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the column entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchColumnEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByUUID_G(String uuid, long groupId)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the column entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the column entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the column entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the column entry that was removed
	 */
	public static ColumnEntry removeByUUID_G(String uuid, long groupId)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of column entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching column entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the column entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the column entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first column entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first column entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] findByUuid_C_PrevAndNext(
			long columnEntryId, String uuid, long companyId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			columnEntryId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the column entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of column entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching column entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the column entries where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByC_S(long companyId, int status) {
		return getPersistence().findByC_S(companyId, status);
	}

	/**
	 * Returns a range of all the column entries where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByC_S(
		long companyId, int status, int start, int end) {

		return getPersistence().findByC_S(companyId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByC_S(
		long companyId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByC_S(
			companyId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByC_S(
		long companyId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_S(
			companyId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first column entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByC_S_First(
			long companyId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByC_S_First(
			companyId, status, orderByComparator);
	}

	/**
	 * Returns the first column entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByC_S_First(
		long companyId, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByC_S_First(
			companyId, status, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByC_S_Last(
			long companyId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByC_S_Last(
			companyId, status, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByC_S_Last(
		long companyId, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByC_S_Last(
			companyId, status, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] findByC_S_PrevAndNext(
			long columnEntryId, long companyId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByC_S_PrevAndNext(
			columnEntryId, companyId, status, orderByComparator);
	}

	/**
	 * Returns all the column entries where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByC_S(long companyId, int[] statuses) {
		return getPersistence().findByC_S(companyId, statuses);
	}

	/**
	 * Returns a range of all the column entries where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByC_S(
		long companyId, int[] statuses, int start, int end) {

		return getPersistence().findByC_S(companyId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByC_S(
		long companyId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByC_S(
			companyId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where companyId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByC_S(
		long companyId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_S(
			companyId, statuses, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the column entries where companyId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 */
	public static void removeByC_S(long companyId, int status) {
		getPersistence().removeByC_S(companyId, status);
	}

	/**
	 * Returns the number of column entries where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching column entries
	 */
	public static int countByC_S(long companyId, int status) {
		return getPersistence().countByC_S(companyId, status);
	}

	/**
	 * Returns the number of column entries where companyId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @return the number of matching column entries
	 */
	public static int countByC_S(long companyId, int[] statuses) {
		return getPersistence().countByC_S(companyId, statuses);
	}

	/**
	 * Returns all the column entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the column entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first column entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByG_S_First(
			long groupId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first column entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByG_S_Last(
			long groupId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] findByG_S_PrevAndNext(
			long columnEntryId, long groupId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByG_S_PrevAndNext(
			columnEntryId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the column entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByG_S(long groupId, int status) {
		return getPersistence().filterFindByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the column entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().filterFindByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set of column entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] filterFindByG_S_PrevAndNext(
			long columnEntryId, long groupId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().filterFindByG_S_PrevAndNext(
			columnEntryId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the column entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByG_S(
		long groupId, int[] statuses) {

		return getPersistence().filterFindByG_S(groupId, statuses);
	}

	/**
	 * Returns a range of all the column entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByG_S(
		long groupId, int[] statuses, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().filterFindByG_S(
			groupId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns all the column entries where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByG_S(long groupId, int[] statuses) {
		return getPersistence().findByG_S(groupId, statuses);
	}

	/**
	 * Returns a range of all the column entries where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByG_S(
		long groupId, int[] statuses, int start, int end) {

		return getPersistence().findByG_S(groupId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, statuses, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the column entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of column entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching column entries
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns the number of column entries where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching column entries
	 */
	public static int countByG_S(long groupId, int[] statuses) {
		return getPersistence().countByG_S(groupId, statuses);
	}

	/**
	 * Returns the number of column entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching column entries that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, int status) {
		return getPersistence().filterCountByG_S(groupId, status);
	}

	/**
	 * Returns the number of column entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching column entries that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, int[] statuses) {
		return getPersistence().filterCountByG_S(groupId, statuses);
	}

	/**
	 * Returns all the column entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int status) {

		return getPersistence().findByC_U_S(companyId, userId, status);
	}

	/**
	 * Returns a range of all the column entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end) {

		return getPersistence().findByC_U_S(
			companyId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByC_U_S(
			companyId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_U_S(
			companyId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first column entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByC_U_S_First(
			long companyId, long userId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByC_U_S_First(
			companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first column entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByC_U_S_First(
		long companyId, long userId, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByC_U_S_First(
			companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByC_U_S_Last(
			long companyId, long userId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByC_U_S_Last(
			companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByC_U_S_Last(
		long companyId, long userId, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByC_U_S_Last(
			companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] findByC_U_S_PrevAndNext(
			long columnEntryId, long companyId, long userId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByC_U_S_PrevAndNext(
			columnEntryId, companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the column entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int[] statuses) {

		return getPersistence().findByC_U_S(companyId, userId, statuses);
	}

	/**
	 * Returns a range of all the column entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end) {

		return getPersistence().findByC_U_S(
			companyId, userId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByC_U_S(
			companyId, userId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where companyId = &#63; and userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_U_S(
			companyId, userId, statuses, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the column entries where companyId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByC_U_S(long companyId, long userId, int status) {
		getPersistence().removeByC_U_S(companyId, userId, status);
	}

	/**
	 * Returns the number of column entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching column entries
	 */
	public static int countByC_U_S(long companyId, long userId, int status) {
		return getPersistence().countByC_U_S(companyId, userId, status);
	}

	/**
	 * Returns the number of column entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching column entries
	 */
	public static int countByC_U_S(
		long companyId, long userId, int[] statuses) {

		return getPersistence().countByC_U_S(companyId, userId, statuses);
	}

	/**
	 * Returns all the column entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().findByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns a range of all the column entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first column entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByG_U_S_First(
			long groupId, long userId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first column entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByG_U_S_First(
		long groupId, long userId, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByG_U_S_Last(
			long groupId, long userId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByG_U_S_Last(
		long groupId, long userId, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] findByG_U_S_PrevAndNext(
			long columnEntryId, long groupId, long userId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByG_U_S_PrevAndNext(
			columnEntryId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the column entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().filterFindByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns a range of all the column entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries that the user has permissions to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set of column entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] filterFindByG_U_S_PrevAndNext(
			long columnEntryId, long groupId, long userId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().filterFindByG_U_S_PrevAndNext(
			columnEntryId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the column entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses) {

		return getPersistence().filterFindByG_U_S(groupId, userId, statuses);
	}

	/**
	 * Returns a range of all the column entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns all the column entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int[] statuses) {

		return getPersistence().findByG_U_S(groupId, userId, statuses);
	}

	/**
	 * Returns a range of all the column entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end) {

		return getPersistence().findByG_U_S(
			groupId, userId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByG_U_S(
			groupId, userId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_U_S(
			groupId, userId, statuses, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the column entries where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByG_U_S(long groupId, long userId, int status) {
		getPersistence().removeByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of column entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching column entries
	 */
	public static int countByG_U_S(long groupId, long userId, int status) {
		return getPersistence().countByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of column entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching column entries
	 */
	public static int countByG_U_S(long groupId, long userId, int[] statuses) {
		return getPersistence().countByG_U_S(groupId, userId, statuses);
	}

	/**
	 * Returns the number of column entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching column entries that the user has permission to view
	 */
	public static int filterCountByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().filterCountByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of column entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching column entries that the user has permission to view
	 */
	public static int filterCountByG_U_S(
		long groupId, long userId, int[] statuses) {

		return getPersistence().filterCountByG_U_S(groupId, userId, statuses);
	}

	/**
	 * Returns all the column entries where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByU_S(long userId, int status) {
		return getPersistence().findByU_S(userId, status);
	}

	/**
	 * Returns a range of all the column entries where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByU_S(
		long userId, int status, int start, int end) {

		return getPersistence().findByU_S(userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first column entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByU_S_First(
			long userId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the first column entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByU_S_First(
		long userId, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByU_S_Last(
			long userId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByU_S_Last(
		long userId, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] findByU_S_PrevAndNext(
			long columnEntryId, long userId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByU_S_PrevAndNext(
			columnEntryId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the column entries where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByU_S(long userId, int[] statuses) {
		return getPersistence().findByU_S(userId, statuses);
	}

	/**
	 * Returns a range of all the column entries where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByU_S(
		long userId, int[] statuses, int start, int end) {

		return getPersistence().findByU_S(userId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByU_S(
		long userId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByU_S(
			userId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByU_S(
		long userId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByU_S(
			userId, statuses, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the column entries where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByU_S(long userId, int status) {
		getPersistence().removeByU_S(userId, status);
	}

	/**
	 * Returns the number of column entries where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching column entries
	 */
	public static int countByU_S(long userId, int status) {
		return getPersistence().countByU_S(userId, status);
	}

	/**
	 * Returns the number of column entries where userId = &#63; and status = any &#63;.
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching column entries
	 */
	public static int countByU_S(long userId, int[] statuses) {
		return getPersistence().countByU_S(userId, statuses);
	}

	/**
	 * Returns all the column entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return getPersistence().findByG_UT_ST(groupId, urlTitle, status);
	}

	/**
	 * Returns a range of all the column entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, status, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first column entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByG_UT_ST_First(
			long groupId, String urlTitle, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByG_UT_ST_First(
			groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns the first column entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByG_UT_ST_First(
		long groupId, String urlTitle, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByG_UT_ST_First(
			groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByG_UT_ST_Last(
			long groupId, String urlTitle, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByG_UT_ST_Last(
			groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByG_UT_ST_Last(
		long groupId, String urlTitle, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByG_UT_ST_Last(
			groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] findByG_UT_ST_PrevAndNext(
			long columnEntryId, long groupId, String urlTitle, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByG_UT_ST_PrevAndNext(
			columnEntryId, groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns all the column entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return getPersistence().filterFindByG_UT_ST(groupId, urlTitle, status);
	}

	/**
	 * Returns a range of all the column entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, status, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries that the user has permissions to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, status, start, end, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set of column entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] filterFindByG_UT_ST_PrevAndNext(
			long columnEntryId, long groupId, String urlTitle, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().filterFindByG_UT_ST_PrevAndNext(
			columnEntryId, groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns all the column entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, statuses);
	}

	/**
	 * Returns a range of all the column entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns all the column entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return getPersistence().findByG_UT_ST(groupId, urlTitle, statuses);
	}

	/**
	 * Returns a range of all the column entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and urlTitle = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, statuses, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the column entries where groupId = &#63; and urlTitle = &#63; and status = &#63; from the database.
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
	 * Returns the number of column entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching column entries
	 */
	public static int countByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return getPersistence().countByG_UT_ST(groupId, urlTitle, status);
	}

	/**
	 * Returns the number of column entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching column entries
	 */
	public static int countByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return getPersistence().countByG_UT_ST(groupId, urlTitle, statuses);
	}

	/**
	 * Returns the number of column entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching column entries that the user has permission to view
	 */
	public static int filterCountByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return getPersistence().filterCountByG_UT_ST(groupId, urlTitle, status);
	}

	/**
	 * Returns the number of column entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching column entries that the user has permission to view
	 */
	public static int filterCountByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return getPersistence().filterCountByG_UT_ST(
			groupId, urlTitle, statuses);
	}

	/**
	 * Returns the column entry where groupId = &#63; and urlTitle = &#63; or throws a <code>NoSuchColumnEntryException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByG_UT(long groupId, String urlTitle)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByG_UT(groupId, urlTitle);
	}

	/**
	 * Returns the column entry where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByG_UT(long groupId, String urlTitle) {
		return getPersistence().fetchByG_UT(groupId, urlTitle);
	}

	/**
	 * Returns the column entry where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByG_UT(
		long groupId, String urlTitle, boolean useFinderCache) {

		return getPersistence().fetchByG_UT(groupId, urlTitle, useFinderCache);
	}

	/**
	 * Removes the column entry where groupId = &#63; and urlTitle = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the column entry that was removed
	 */
	public static ColumnEntry removeByG_UT(long groupId, String urlTitle)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().removeByG_UT(groupId, urlTitle);
	}

	/**
	 * Returns the number of column entries where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the number of matching column entries
	 */
	public static int countByG_UT(long groupId, String urlTitle) {
		return getPersistence().countByG_UT(groupId, urlTitle);
	}

	/**
	 * Returns the column entry where urlTitle = &#63; or throws a <code>NoSuchColumnEntryException</code> if it could not be found.
	 *
	 * @param urlTitle the url title
	 * @return the matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByURLTitle(String urlTitle)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByURLTitle(urlTitle);
	}

	/**
	 * Returns the column entry where urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param urlTitle the url title
	 * @return the matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByURLTitle(String urlTitle) {
		return getPersistence().fetchByURLTitle(urlTitle);
	}

	/**
	 * Returns the column entry where urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByURLTitle(
		String urlTitle, boolean useFinderCache) {

		return getPersistence().fetchByURLTitle(urlTitle, useFinderCache);
	}

	/**
	 * Removes the column entry where urlTitle = &#63; from the database.
	 *
	 * @param urlTitle the url title
	 * @return the column entry that was removed
	 */
	public static ColumnEntry removeByURLTitle(String urlTitle)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().removeByURLTitle(urlTitle);
	}

	/**
	 * Returns the number of column entries where urlTitle = &#63;.
	 *
	 * @param urlTitle the url title
	 * @return the number of matching column entries
	 */
	public static int countByURLTitle(String urlTitle) {
		return getPersistence().countByURLTitle(urlTitle);
	}

	/**
	 * Returns all the column entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the column entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first column entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByGroupId_First(
			long groupId, OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first column entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByGroupId_First(
		long groupId, OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByGroupId_Last(
			long groupId, OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByGroupId_Last(
		long groupId, OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where groupId = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] findByGroupId_PrevAndNext(
			long columnEntryId, long groupId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByGroupId_PrevAndNext(
			columnEntryId, groupId, orderByComparator);
	}

	/**
	 * Returns all the column entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the column entries that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set of column entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] filterFindByGroupId_PrevAndNext(
			long columnEntryId, long groupId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			columnEntryId, groupId, orderByComparator);
	}

	/**
	 * Removes all the column entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of column entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching column entries
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of column entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching column entries that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns all the column entries where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByUserIdGroupId(
		long userId, long groupId) {

		return getPersistence().findByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns a range of all the column entries where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end) {

		return getPersistence().findByUserIdGroupId(
			userId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByUserIdGroupId(
			userId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserIdGroupId(
			userId, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first column entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByUserIdGroupId_First(
			long userId, long groupId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByUserIdGroupId_First(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the first column entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByUserIdGroupId_First(
		long userId, long groupId,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByUserIdGroupId_First(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByUserIdGroupId_Last(
			long userId, long groupId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByUserIdGroupId_Last(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByUserIdGroupId_Last(
		long userId, long groupId,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByUserIdGroupId_Last(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] findByUserIdGroupId_PrevAndNext(
			long columnEntryId, long userId, long groupId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByUserIdGroupId_PrevAndNext(
			columnEntryId, userId, groupId, orderByComparator);
	}

	/**
	 * Returns all the column entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByUserIdGroupId(
		long userId, long groupId) {

		return getPersistence().filterFindByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns a range of all the column entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end) {

		return getPersistence().filterFindByUserIdGroupId(
			userId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries that the user has permissions to view where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries that the user has permission to view
	 */
	public static List<ColumnEntry> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().filterFindByUserIdGroupId(
			userId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set of column entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] filterFindByUserIdGroupId_PrevAndNext(
			long columnEntryId, long userId, long groupId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().filterFindByUserIdGroupId_PrevAndNext(
			columnEntryId, userId, groupId, orderByComparator);
	}

	/**
	 * Removes all the column entries where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 */
	public static void removeByUserIdGroupId(long userId, long groupId) {
		getPersistence().removeByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns the number of column entries where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching column entries
	 */
	public static int countByUserIdGroupId(long userId, long groupId) {
		return getPersistence().countByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns the number of column entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching column entries that the user has permission to view
	 */
	public static int filterCountByUserIdGroupId(long userId, long groupId) {
		return getPersistence().filterCountByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns all the column entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the column entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByUserId(
		long userId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByUserId(
		long userId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first column entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByUserId_First(
			long userId, OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first column entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByUserId_First(
		long userId, OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByUserId_Last(
			long userId, OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByUserId_Last(
		long userId, OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where userId = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] findByUserId_PrevAndNext(
			long columnEntryId, long userId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByUserId_PrevAndNext(
			columnEntryId, userId, orderByComparator);
	}

	/**
	 * Removes all the column entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of column entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching column entries
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the column entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByCompanyId(long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	 * Returns a range of all the column entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByCompanyId(
		long companyId, int start, int end) {

		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first column entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByCompanyId_First(
			long companyId, OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first column entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByCompanyId_First(
		long companyId, OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByCompanyId_Last(
			long companyId, OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByCompanyId_Last(
		long companyId, OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where companyId = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] findByCompanyId_PrevAndNext(
			long columnEntryId, long companyId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByCompanyId_PrevAndNext(
			columnEntryId, companyId, orderByComparator);
	}

	/**
	 * Removes all the column entries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	 * Returns the number of column entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching column entries
	 */
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	 * Returns all the column entries where columnEntryId = &#63;.
	 *
	 * @param columnEntryId the column entry ID
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByColumnEntryId(long columnEntryId) {
		return getPersistence().findByColumnEntryId(columnEntryId);
	}

	/**
	 * Returns a range of all the column entries where columnEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnEntryId the column entry ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByColumnEntryId(
		long columnEntryId, int start, int end) {

		return getPersistence().findByColumnEntryId(columnEntryId, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where columnEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnEntryId the column entry ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByColumnEntryId(
		long columnEntryId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByColumnEntryId(
			columnEntryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where columnEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnEntryId the column entry ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByColumnEntryId(
		long columnEntryId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByColumnEntryId(
			columnEntryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first column entry in the ordered set where columnEntryId = &#63;.
	 *
	 * @param columnEntryId the column entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByColumnEntryId_First(
			long columnEntryId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByColumnEntryId_First(
			columnEntryId, orderByComparator);
	}

	/**
	 * Returns the first column entry in the ordered set where columnEntryId = &#63;.
	 *
	 * @param columnEntryId the column entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByColumnEntryId_First(
		long columnEntryId, OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByColumnEntryId_First(
			columnEntryId, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where columnEntryId = &#63;.
	 *
	 * @param columnEntryId the column entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByColumnEntryId_Last(
			long columnEntryId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByColumnEntryId_Last(
			columnEntryId, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where columnEntryId = &#63;.
	 *
	 * @param columnEntryId the column entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByColumnEntryId_Last(
		long columnEntryId, OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByColumnEntryId_Last(
			columnEntryId, orderByComparator);
	}

	/**
	 * Removes all the column entries where columnEntryId = &#63; from the database.
	 *
	 * @param columnEntryId the column entry ID
	 */
	public static void removeByColumnEntryId(long columnEntryId) {
		getPersistence().removeByColumnEntryId(columnEntryId);
	}

	/**
	 * Returns the number of column entries where columnEntryId = &#63;.
	 *
	 * @param columnEntryId the column entry ID
	 * @return the number of matching column entries
	 */
	public static int countByColumnEntryId(long columnEntryId) {
		return getPersistence().countByColumnEntryId(columnEntryId);
	}

	/**
	 * Returns all the column entries where columnType = &#63;.
	 *
	 * @param columnType the column type
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByColumnType(String columnType) {
		return getPersistence().findByColumnType(columnType);
	}

	/**
	 * Returns a range of all the column entries where columnType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnType the column type
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByColumnType(
		String columnType, int start, int end) {

		return getPersistence().findByColumnType(columnType, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where columnType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnType the column type
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByColumnType(
		String columnType, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByColumnType(
			columnType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where columnType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnType the column type
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByColumnType(
		String columnType, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByColumnType(
			columnType, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first column entry in the ordered set where columnType = &#63;.
	 *
	 * @param columnType the column type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByColumnType_First(
			String columnType, OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByColumnType_First(
			columnType, orderByComparator);
	}

	/**
	 * Returns the first column entry in the ordered set where columnType = &#63;.
	 *
	 * @param columnType the column type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByColumnType_First(
		String columnType, OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByColumnType_First(
			columnType, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where columnType = &#63;.
	 *
	 * @param columnType the column type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByColumnType_Last(
			String columnType, OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByColumnType_Last(
			columnType, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where columnType = &#63;.
	 *
	 * @param columnType the column type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByColumnType_Last(
		String columnType, OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByColumnType_Last(
			columnType, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where columnType = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param columnType the column type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] findByColumnType_PrevAndNext(
			long columnEntryId, String columnType,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByColumnType_PrevAndNext(
			columnEntryId, columnType, orderByComparator);
	}

	/**
	 * Removes all the column entries where columnType = &#63; from the database.
	 *
	 * @param columnType the column type
	 */
	public static void removeByColumnType(String columnType) {
		getPersistence().removeByColumnType(columnType);
	}

	/**
	 * Returns the number of column entries where columnType = &#63;.
	 *
	 * @param columnType the column type
	 * @return the number of matching column entries
	 */
	public static int countByColumnType(String columnType) {
		return getPersistence().countByColumnType(columnType);
	}

	/**
	 * Returns all the column entries where columnName = &#63;.
	 *
	 * @param columnName the column name
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByColumnName(String columnName) {
		return getPersistence().findByColumnName(columnName);
	}

	/**
	 * Returns a range of all the column entries where columnName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnName the column name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByColumnName(
		String columnName, int start, int end) {

		return getPersistence().findByColumnName(columnName, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where columnName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnName the column name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByColumnName(
		String columnName, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByColumnName(
			columnName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where columnName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnName the column name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByColumnName(
		String columnName, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByColumnName(
			columnName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first column entry in the ordered set where columnName = &#63;.
	 *
	 * @param columnName the column name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByColumnName_First(
			String columnName, OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByColumnName_First(
			columnName, orderByComparator);
	}

	/**
	 * Returns the first column entry in the ordered set where columnName = &#63;.
	 *
	 * @param columnName the column name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByColumnName_First(
		String columnName, OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByColumnName_First(
			columnName, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where columnName = &#63;.
	 *
	 * @param columnName the column name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByColumnName_Last(
			String columnName, OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByColumnName_Last(
			columnName, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where columnName = &#63;.
	 *
	 * @param columnName the column name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByColumnName_Last(
		String columnName, OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByColumnName_Last(
			columnName, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where columnName = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param columnName the column name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] findByColumnName_PrevAndNext(
			long columnEntryId, String columnName,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByColumnName_PrevAndNext(
			columnEntryId, columnName, orderByComparator);
	}

	/**
	 * Removes all the column entries where columnName = &#63; from the database.
	 *
	 * @param columnName the column name
	 */
	public static void removeByColumnName(String columnName) {
		getPersistence().removeByColumnName(columnName);
	}

	/**
	 * Returns the number of column entries where columnName = &#63;.
	 *
	 * @param columnName the column name
	 * @return the number of matching column entries
	 */
	public static int countByColumnName(String columnName) {
		return getPersistence().countByColumnName(columnName);
	}

	/**
	 * Returns all the column entries where columnFullName = &#63;.
	 *
	 * @param columnFullName the column full name
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByColumnFullName(
		String columnFullName) {

		return getPersistence().findByColumnFullName(columnFullName);
	}

	/**
	 * Returns a range of all the column entries where columnFullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnFullName the column full name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByColumnFullName(
		String columnFullName, int start, int end) {

		return getPersistence().findByColumnFullName(
			columnFullName, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where columnFullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnFullName the column full name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByColumnFullName(
		String columnFullName, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByColumnFullName(
			columnFullName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where columnFullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnFullName the column full name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByColumnFullName(
		String columnFullName, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByColumnFullName(
			columnFullName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first column entry in the ordered set where columnFullName = &#63;.
	 *
	 * @param columnFullName the column full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByColumnFullName_First(
			String columnFullName,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByColumnFullName_First(
			columnFullName, orderByComparator);
	}

	/**
	 * Returns the first column entry in the ordered set where columnFullName = &#63;.
	 *
	 * @param columnFullName the column full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByColumnFullName_First(
		String columnFullName,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByColumnFullName_First(
			columnFullName, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where columnFullName = &#63;.
	 *
	 * @param columnFullName the column full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByColumnFullName_Last(
			String columnFullName,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByColumnFullName_Last(
			columnFullName, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where columnFullName = &#63;.
	 *
	 * @param columnFullName the column full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByColumnFullName_Last(
		String columnFullName,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByColumnFullName_Last(
			columnFullName, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where columnFullName = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param columnFullName the column full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] findByColumnFullName_PrevAndNext(
			long columnEntryId, String columnFullName,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByColumnFullName_PrevAndNext(
			columnEntryId, columnFullName, orderByComparator);
	}

	/**
	 * Removes all the column entries where columnFullName = &#63; from the database.
	 *
	 * @param columnFullName the column full name
	 */
	public static void removeByColumnFullName(String columnFullName) {
		getPersistence().removeByColumnFullName(columnFullName);
	}

	/**
	 * Returns the number of column entries where columnFullName = &#63;.
	 *
	 * @param columnFullName the column full name
	 * @return the number of matching column entries
	 */
	public static int countByColumnFullName(String columnFullName) {
		return getPersistence().countByColumnFullName(columnFullName);
	}

	/**
	 * Returns all the column entries where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByTableEntryId(long tableEntryId) {
		return getPersistence().findByTableEntryId(tableEntryId);
	}

	/**
	 * Returns a range of all the column entries where tableEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableEntryId the table entry ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByTableEntryId(
		long tableEntryId, int start, int end) {

		return getPersistence().findByTableEntryId(tableEntryId, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where tableEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableEntryId the table entry ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByTableEntryId(
		long tableEntryId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByTableEntryId(
			tableEntryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where tableEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableEntryId the table entry ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByTableEntryId(
		long tableEntryId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTableEntryId(
			tableEntryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first column entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByTableEntryId_First(
			long tableEntryId, OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByTableEntryId_First(
			tableEntryId, orderByComparator);
	}

	/**
	 * Returns the first column entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByTableEntryId_First(
		long tableEntryId, OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByTableEntryId_First(
			tableEntryId, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByTableEntryId_Last(
			long tableEntryId, OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByTableEntryId_Last(
			tableEntryId, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByTableEntryId_Last(
		long tableEntryId, OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByTableEntryId_Last(
			tableEntryId, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] findByTableEntryId_PrevAndNext(
			long columnEntryId, long tableEntryId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByTableEntryId_PrevAndNext(
			columnEntryId, tableEntryId, orderByComparator);
	}

	/**
	 * Removes all the column entries where tableEntryId = &#63; from the database.
	 *
	 * @param tableEntryId the table entry ID
	 */
	public static void removeByTableEntryId(long tableEntryId) {
		getPersistence().removeByTableEntryId(tableEntryId);
	}

	/**
	 * Returns the number of column entries where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @return the number of matching column entries
	 */
	public static int countByTableEntryId(long tableEntryId) {
		return getPersistence().countByTableEntryId(tableEntryId);
	}

	/**
	 * Returns all the column entries where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findBySystemName(String systemName) {
		return getPersistence().findBySystemName(systemName);
	}

	/**
	 * Returns a range of all the column entries where systemName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemName the system name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findBySystemName(
		String systemName, int start, int end) {

		return getPersistence().findBySystemName(systemName, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where systemName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemName the system name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findBySystemName(
		String systemName, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findBySystemName(
			systemName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where systemName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemName the system name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findBySystemName(
		String systemName, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySystemName(
			systemName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first column entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findBySystemName_First(
			String systemName, OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findBySystemName_First(
			systemName, orderByComparator);
	}

	/**
	 * Returns the first column entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchBySystemName_First(
		String systemName, OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchBySystemName_First(
			systemName, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findBySystemName_Last(
			String systemName, OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findBySystemName_Last(
			systemName, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchBySystemName_Last(
		String systemName, OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchBySystemName_Last(
			systemName, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where systemName = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] findBySystemName_PrevAndNext(
			long columnEntryId, String systemName,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findBySystemName_PrevAndNext(
			columnEntryId, systemName, orderByComparator);
	}

	/**
	 * Removes all the column entries where systemName = &#63; from the database.
	 *
	 * @param systemName the system name
	 */
	public static void removeBySystemName(String systemName) {
		getPersistence().removeBySystemName(systemName);
	}

	/**
	 * Returns the number of column entries where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @return the number of matching column entries
	 */
	public static int countBySystemName(String systemName) {
		return getPersistence().countBySystemName(systemName);
	}

	/**
	 * Returns all the column entries where databaseName = &#63;.
	 *
	 * @param databaseName the database name
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByDatabaseName(String databaseName) {
		return getPersistence().findByDatabaseName(databaseName);
	}

	/**
	 * Returns a range of all the column entries where databaseName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param databaseName the database name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByDatabaseName(
		String databaseName, int start, int end) {

		return getPersistence().findByDatabaseName(databaseName, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where databaseName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param databaseName the database name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByDatabaseName(
		String databaseName, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByDatabaseName(
			databaseName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where databaseName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param databaseName the database name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByDatabaseName(
		String databaseName, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDatabaseName(
			databaseName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first column entry in the ordered set where databaseName = &#63;.
	 *
	 * @param databaseName the database name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByDatabaseName_First(
			String databaseName,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByDatabaseName_First(
			databaseName, orderByComparator);
	}

	/**
	 * Returns the first column entry in the ordered set where databaseName = &#63;.
	 *
	 * @param databaseName the database name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByDatabaseName_First(
		String databaseName, OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByDatabaseName_First(
			databaseName, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where databaseName = &#63;.
	 *
	 * @param databaseName the database name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByDatabaseName_Last(
			String databaseName,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByDatabaseName_Last(
			databaseName, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where databaseName = &#63;.
	 *
	 * @param databaseName the database name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByDatabaseName_Last(
		String databaseName, OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByDatabaseName_Last(
			databaseName, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where databaseName = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param databaseName the database name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] findByDatabaseName_PrevAndNext(
			long columnEntryId, String databaseName,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByDatabaseName_PrevAndNext(
			columnEntryId, databaseName, orderByComparator);
	}

	/**
	 * Removes all the column entries where databaseName = &#63; from the database.
	 *
	 * @param databaseName the database name
	 */
	public static void removeByDatabaseName(String databaseName) {
		getPersistence().removeByDatabaseName(databaseName);
	}

	/**
	 * Returns the number of column entries where databaseName = &#63;.
	 *
	 * @param databaseName the database name
	 * @return the number of matching column entries
	 */
	public static int countByDatabaseName(String databaseName) {
		return getPersistence().countByDatabaseName(databaseName);
	}

	/**
	 * Returns all the column entries where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the matching column entries
	 */
	public static List<ColumnEntry> findByIsActive(boolean isActive) {
		return getPersistence().findByIsActive(isActive);
	}

	/**
	 * Returns a range of all the column entries where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	public static List<ColumnEntry> findByIsActive(
		boolean isActive, int start, int end) {

		return getPersistence().findByIsActive(isActive, start, end);
	}

	/**
	 * Returns an ordered range of all the column entries where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByIsActive(
		boolean isActive, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findByIsActive(
			isActive, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	public static List<ColumnEntry> findByIsActive(
		boolean isActive, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByIsActive(
			isActive, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first column entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByIsActive_First(
			boolean isActive, OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByIsActive_First(
			isActive, orderByComparator);
	}

	/**
	 * Returns the first column entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByIsActive_First(
		boolean isActive, OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByIsActive_First(
			isActive, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public static ColumnEntry findByIsActive_Last(
			boolean isActive, OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByIsActive_Last(
			isActive, orderByComparator);
	}

	/**
	 * Returns the last column entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchByIsActive_Last(
		boolean isActive, OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().fetchByIsActive_Last(
			isActive, orderByComparator);
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where isActive = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry[] findByIsActive_PrevAndNext(
			long columnEntryId, boolean isActive,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByIsActive_PrevAndNext(
			columnEntryId, isActive, orderByComparator);
	}

	/**
	 * Removes all the column entries where isActive = &#63; from the database.
	 *
	 * @param isActive the is active
	 */
	public static void removeByIsActive(boolean isActive) {
		getPersistence().removeByIsActive(isActive);
	}

	/**
	 * Returns the number of column entries where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the number of matching column entries
	 */
	public static int countByIsActive(boolean isActive) {
		return getPersistence().countByIsActive(isActive);
	}

	/**
	 * Caches the column entry in the entity cache if it is enabled.
	 *
	 * @param columnEntry the column entry
	 */
	public static void cacheResult(ColumnEntry columnEntry) {
		getPersistence().cacheResult(columnEntry);
	}

	/**
	 * Caches the column entries in the entity cache if it is enabled.
	 *
	 * @param columnEntries the column entries
	 */
	public static void cacheResult(List<ColumnEntry> columnEntries) {
		getPersistence().cacheResult(columnEntries);
	}

	/**
	 * Creates a new column entry with the primary key. Does not add the column entry to the database.
	 *
	 * @param columnEntryId the primary key for the new column entry
	 * @return the new column entry
	 */
	public static ColumnEntry create(long columnEntryId) {
		return getPersistence().create(columnEntryId);
	}

	/**
	 * Removes the column entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param columnEntryId the primary key of the column entry
	 * @return the column entry that was removed
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry remove(long columnEntryId)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().remove(columnEntryId);
	}

	public static ColumnEntry updateImpl(ColumnEntry columnEntry) {
		return getPersistence().updateImpl(columnEntry);
	}

	/**
	 * Returns the column entry with the primary key or throws a <code>NoSuchColumnEntryException</code> if it could not be found.
	 *
	 * @param columnEntryId the primary key of the column entry
	 * @return the column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry findByPrimaryKey(long columnEntryId)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchColumnEntryException {

		return getPersistence().findByPrimaryKey(columnEntryId);
	}

	/**
	 * Returns the column entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param columnEntryId the primary key of the column entry
	 * @return the column entry, or <code>null</code> if a column entry with the primary key could not be found
	 */
	public static ColumnEntry fetchByPrimaryKey(long columnEntryId) {
		return getPersistence().fetchByPrimaryKey(columnEntryId);
	}

	/**
	 * Returns all the column entries.
	 *
	 * @return the column entries
	 */
	public static List<ColumnEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the column entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of column entries
	 */
	public static List<ColumnEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the column entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of column entries
	 */
	public static List<ColumnEntry> findAll(
		int start, int end, OrderByComparator<ColumnEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of column entries
	 */
	public static List<ColumnEntry> findAll(
		int start, int end, OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the column entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of column entries.
	 *
	 * @return the number of column entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ColumnEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ColumnEntryPersistence _persistence;

}