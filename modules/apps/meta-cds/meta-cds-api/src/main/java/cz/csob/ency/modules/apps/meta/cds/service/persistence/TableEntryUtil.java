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

import cz.csob.ency.modules.apps.meta.cds.model.TableEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the table entry service. This utility wraps <code>cz.csob.ency.modules.apps.meta.cds.service.persistence.impl.TableEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author "Miroslav Čermák"
 * @see TableEntryPersistence
 * @generated
 */
public class TableEntryUtil {

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
	public static void clearCache(TableEntry tableEntry) {
		getPersistence().clearCache(tableEntry);
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
	public static Map<Serializable, TableEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TableEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TableEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TableEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TableEntry update(TableEntry tableEntry) {
		return getPersistence().update(tableEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TableEntry update(
		TableEntry tableEntry, ServiceContext serviceContext) {

		return getPersistence().update(tableEntry, serviceContext);
	}

	/**
	 * Returns all the table entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the table entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first table entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByUuid_First(
			String uuid, OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first table entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByUuid_First(
		String uuid, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByUuid_Last(
			String uuid, OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByUuid_Last(
		String uuid, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where uuid = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] findByUuid_PrevAndNext(
			long tableEntryId, String uuid,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			tableEntryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the table entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of table entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching table entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the table entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTableEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByUUID_G(String uuid, long groupId)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the table entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the table entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the table entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the table entry that was removed
	 */
	public static TableEntry removeByUUID_G(String uuid, long groupId)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of table entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching table entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the table entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the table entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first table entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first table entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] findByUuid_C_PrevAndNext(
			long tableEntryId, String uuid, long companyId,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			tableEntryId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the table entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of table entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching table entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the table entries where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByC_S(long companyId, int status) {
		return getPersistence().findByC_S(companyId, status);
	}

	/**
	 * Returns a range of all the table entries where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByC_S(
		long companyId, int status, int start, int end) {

		return getPersistence().findByC_S(companyId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByC_S(
		long companyId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByC_S(
			companyId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByC_S(
		long companyId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_S(
			companyId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first table entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByC_S_First(
			long companyId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByC_S_First(
			companyId, status, orderByComparator);
	}

	/**
	 * Returns the first table entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByC_S_First(
		long companyId, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByC_S_First(
			companyId, status, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByC_S_Last(
			long companyId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByC_S_Last(
			companyId, status, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByC_S_Last(
		long companyId, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByC_S_Last(
			companyId, status, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] findByC_S_PrevAndNext(
			long tableEntryId, long companyId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByC_S_PrevAndNext(
			tableEntryId, companyId, status, orderByComparator);
	}

	/**
	 * Returns all the table entries where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByC_S(long companyId, int[] statuses) {
		return getPersistence().findByC_S(companyId, statuses);
	}

	/**
	 * Returns a range of all the table entries where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByC_S(
		long companyId, int[] statuses, int start, int end) {

		return getPersistence().findByC_S(companyId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByC_S(
		long companyId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByC_S(
			companyId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where companyId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByC_S(
		long companyId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_S(
			companyId, statuses, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the table entries where companyId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 */
	public static void removeByC_S(long companyId, int status) {
		getPersistence().removeByC_S(companyId, status);
	}

	/**
	 * Returns the number of table entries where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching table entries
	 */
	public static int countByC_S(long companyId, int status) {
		return getPersistence().countByC_S(companyId, status);
	}

	/**
	 * Returns the number of table entries where companyId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @return the number of matching table entries
	 */
	public static int countByC_S(long companyId, int[] statuses) {
		return getPersistence().countByC_S(companyId, statuses);
	}

	/**
	 * Returns all the table entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the table entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first table entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByG_S_First(
			long groupId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first table entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByG_S_Last(
			long groupId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] findByG_S_PrevAndNext(
			long tableEntryId, long groupId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByG_S_PrevAndNext(
			tableEntryId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the table entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByG_S(long groupId, int status) {
		return getPersistence().filterFindByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the table entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().filterFindByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set of table entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] filterFindByG_S_PrevAndNext(
			long tableEntryId, long groupId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().filterFindByG_S_PrevAndNext(
			tableEntryId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the table entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByG_S(
		long groupId, int[] statuses) {

		return getPersistence().filterFindByG_S(groupId, statuses);
	}

	/**
	 * Returns a range of all the table entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByG_S(
		long groupId, int[] statuses, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().filterFindByG_S(
			groupId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns all the table entries where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByG_S(long groupId, int[] statuses) {
		return getPersistence().findByG_S(groupId, statuses);
	}

	/**
	 * Returns a range of all the table entries where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByG_S(
		long groupId, int[] statuses, int start, int end) {

		return getPersistence().findByG_S(groupId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, statuses, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the table entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of table entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching table entries
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns the number of table entries where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching table entries
	 */
	public static int countByG_S(long groupId, int[] statuses) {
		return getPersistence().countByG_S(groupId, statuses);
	}

	/**
	 * Returns the number of table entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching table entries that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, int status) {
		return getPersistence().filterCountByG_S(groupId, status);
	}

	/**
	 * Returns the number of table entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching table entries that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, int[] statuses) {
		return getPersistence().filterCountByG_S(groupId, statuses);
	}

	/**
	 * Returns all the table entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByC_U_S(
		long companyId, long userId, int status) {

		return getPersistence().findByC_U_S(companyId, userId, status);
	}

	/**
	 * Returns a range of all the table entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end) {

		return getPersistence().findByC_U_S(
			companyId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByC_U_S(
			companyId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_U_S(
			companyId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first table entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByC_U_S_First(
			long companyId, long userId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByC_U_S_First(
			companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first table entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByC_U_S_First(
		long companyId, long userId, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByC_U_S_First(
			companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByC_U_S_Last(
			long companyId, long userId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByC_U_S_Last(
			companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByC_U_S_Last(
		long companyId, long userId, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByC_U_S_Last(
			companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] findByC_U_S_PrevAndNext(
			long tableEntryId, long companyId, long userId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByC_U_S_PrevAndNext(
			tableEntryId, companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the table entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByC_U_S(
		long companyId, long userId, int[] statuses) {

		return getPersistence().findByC_U_S(companyId, userId, statuses);
	}

	/**
	 * Returns a range of all the table entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end) {

		return getPersistence().findByC_U_S(
			companyId, userId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByC_U_S(
			companyId, userId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where companyId = &#63; and userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_U_S(
			companyId, userId, statuses, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the table entries where companyId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByC_U_S(long companyId, long userId, int status) {
		getPersistence().removeByC_U_S(companyId, userId, status);
	}

	/**
	 * Returns the number of table entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching table entries
	 */
	public static int countByC_U_S(long companyId, long userId, int status) {
		return getPersistence().countByC_U_S(companyId, userId, status);
	}

	/**
	 * Returns the number of table entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching table entries
	 */
	public static int countByC_U_S(
		long companyId, long userId, int[] statuses) {

		return getPersistence().countByC_U_S(companyId, userId, statuses);
	}

	/**
	 * Returns all the table entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().findByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns a range of all the table entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first table entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByG_U_S_First(
			long groupId, long userId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first table entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByG_U_S_First(
		long groupId, long userId, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByG_U_S_Last(
			long groupId, long userId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByG_U_S_Last(
		long groupId, long userId, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] findByG_U_S_PrevAndNext(
			long tableEntryId, long groupId, long userId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByG_U_S_PrevAndNext(
			tableEntryId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the table entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().filterFindByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns a range of all the table entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries that the user has permissions to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set of table entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] filterFindByG_U_S_PrevAndNext(
			long tableEntryId, long groupId, long userId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().filterFindByG_U_S_PrevAndNext(
			tableEntryId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the table entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses) {

		return getPersistence().filterFindByG_U_S(groupId, userId, statuses);
	}

	/**
	 * Returns a range of all the table entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns all the table entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByG_U_S(
		long groupId, long userId, int[] statuses) {

		return getPersistence().findByG_U_S(groupId, userId, statuses);
	}

	/**
	 * Returns a range of all the table entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end) {

		return getPersistence().findByG_U_S(
			groupId, userId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByG_U_S(
			groupId, userId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_U_S(
			groupId, userId, statuses, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the table entries where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByG_U_S(long groupId, long userId, int status) {
		getPersistence().removeByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of table entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching table entries
	 */
	public static int countByG_U_S(long groupId, long userId, int status) {
		return getPersistence().countByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of table entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching table entries
	 */
	public static int countByG_U_S(long groupId, long userId, int[] statuses) {
		return getPersistence().countByG_U_S(groupId, userId, statuses);
	}

	/**
	 * Returns the number of table entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching table entries that the user has permission to view
	 */
	public static int filterCountByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().filterCountByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of table entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching table entries that the user has permission to view
	 */
	public static int filterCountByG_U_S(
		long groupId, long userId, int[] statuses) {

		return getPersistence().filterCountByG_U_S(groupId, userId, statuses);
	}

	/**
	 * Returns all the table entries where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByU_S(long userId, int status) {
		return getPersistence().findByU_S(userId, status);
	}

	/**
	 * Returns a range of all the table entries where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByU_S(
		long userId, int status, int start, int end) {

		return getPersistence().findByU_S(userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first table entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByU_S_First(
			long userId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the first table entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByU_S_First(
		long userId, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByU_S_Last(
			long userId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByU_S_Last(
		long userId, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] findByU_S_PrevAndNext(
			long tableEntryId, long userId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByU_S_PrevAndNext(
			tableEntryId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the table entries where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByU_S(long userId, int[] statuses) {
		return getPersistence().findByU_S(userId, statuses);
	}

	/**
	 * Returns a range of all the table entries where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByU_S(
		long userId, int[] statuses, int start, int end) {

		return getPersistence().findByU_S(userId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByU_S(
		long userId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByU_S(
			userId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByU_S(
		long userId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByU_S(
			userId, statuses, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the table entries where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByU_S(long userId, int status) {
		getPersistence().removeByU_S(userId, status);
	}

	/**
	 * Returns the number of table entries where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching table entries
	 */
	public static int countByU_S(long userId, int status) {
		return getPersistence().countByU_S(userId, status);
	}

	/**
	 * Returns the number of table entries where userId = &#63; and status = any &#63;.
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching table entries
	 */
	public static int countByU_S(long userId, int[] statuses) {
		return getPersistence().countByU_S(userId, statuses);
	}

	/**
	 * Returns all the table entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return getPersistence().findByG_UT_ST(groupId, urlTitle, status);
	}

	/**
	 * Returns a range of all the table entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, status, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first table entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByG_UT_ST_First(
			long groupId, String urlTitle, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByG_UT_ST_First(
			groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns the first table entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByG_UT_ST_First(
		long groupId, String urlTitle, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByG_UT_ST_First(
			groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByG_UT_ST_Last(
			long groupId, String urlTitle, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByG_UT_ST_Last(
			groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByG_UT_ST_Last(
		long groupId, String urlTitle, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByG_UT_ST_Last(
			groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] findByG_UT_ST_PrevAndNext(
			long tableEntryId, long groupId, String urlTitle, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByG_UT_ST_PrevAndNext(
			tableEntryId, groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns all the table entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return getPersistence().filterFindByG_UT_ST(groupId, urlTitle, status);
	}

	/**
	 * Returns a range of all the table entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, status, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries that the user has permissions to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, status, start, end, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set of table entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] filterFindByG_UT_ST_PrevAndNext(
			long tableEntryId, long groupId, String urlTitle, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().filterFindByG_UT_ST_PrevAndNext(
			tableEntryId, groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns all the table entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, statuses);
	}

	/**
	 * Returns a range of all the table entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns all the table entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return getPersistence().findByG_UT_ST(groupId, urlTitle, statuses);
	}

	/**
	 * Returns a range of all the table entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and urlTitle = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, statuses, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the table entries where groupId = &#63; and urlTitle = &#63; and status = &#63; from the database.
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
	 * Returns the number of table entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching table entries
	 */
	public static int countByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return getPersistence().countByG_UT_ST(groupId, urlTitle, status);
	}

	/**
	 * Returns the number of table entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching table entries
	 */
	public static int countByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return getPersistence().countByG_UT_ST(groupId, urlTitle, statuses);
	}

	/**
	 * Returns the number of table entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching table entries that the user has permission to view
	 */
	public static int filterCountByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return getPersistence().filterCountByG_UT_ST(groupId, urlTitle, status);
	}

	/**
	 * Returns the number of table entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching table entries that the user has permission to view
	 */
	public static int filterCountByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return getPersistence().filterCountByG_UT_ST(
			groupId, urlTitle, statuses);
	}

	/**
	 * Returns the table entry where groupId = &#63; and urlTitle = &#63; or throws a <code>NoSuchTableEntryException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByG_UT(long groupId, String urlTitle)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByG_UT(groupId, urlTitle);
	}

	/**
	 * Returns the table entry where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByG_UT(long groupId, String urlTitle) {
		return getPersistence().fetchByG_UT(groupId, urlTitle);
	}

	/**
	 * Returns the table entry where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByG_UT(
		long groupId, String urlTitle, boolean useFinderCache) {

		return getPersistence().fetchByG_UT(groupId, urlTitle, useFinderCache);
	}

	/**
	 * Removes the table entry where groupId = &#63; and urlTitle = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the table entry that was removed
	 */
	public static TableEntry removeByG_UT(long groupId, String urlTitle)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().removeByG_UT(groupId, urlTitle);
	}

	/**
	 * Returns the number of table entries where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the number of matching table entries
	 */
	public static int countByG_UT(long groupId, String urlTitle) {
		return getPersistence().countByG_UT(groupId, urlTitle);
	}

	/**
	 * Returns the table entry where urlTitle = &#63; or throws a <code>NoSuchTableEntryException</code> if it could not be found.
	 *
	 * @param urlTitle the url title
	 * @return the matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByURLTitle(String urlTitle)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByURLTitle(urlTitle);
	}

	/**
	 * Returns the table entry where urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param urlTitle the url title
	 * @return the matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByURLTitle(String urlTitle) {
		return getPersistence().fetchByURLTitle(urlTitle);
	}

	/**
	 * Returns the table entry where urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByURLTitle(
		String urlTitle, boolean useFinderCache) {

		return getPersistence().fetchByURLTitle(urlTitle, useFinderCache);
	}

	/**
	 * Removes the table entry where urlTitle = &#63; from the database.
	 *
	 * @param urlTitle the url title
	 * @return the table entry that was removed
	 */
	public static TableEntry removeByURLTitle(String urlTitle)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().removeByURLTitle(urlTitle);
	}

	/**
	 * Returns the number of table entries where urlTitle = &#63;.
	 *
	 * @param urlTitle the url title
	 * @return the number of matching table entries
	 */
	public static int countByURLTitle(String urlTitle) {
		return getPersistence().countByURLTitle(urlTitle);
	}

	/**
	 * Returns all the table entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the table entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first table entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByGroupId_First(
			long groupId, OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first table entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByGroupId_First(
		long groupId, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByGroupId_Last(
			long groupId, OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByGroupId_Last(
		long groupId, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where groupId = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] findByGroupId_PrevAndNext(
			long tableEntryId, long groupId,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByGroupId_PrevAndNext(
			tableEntryId, groupId, orderByComparator);
	}

	/**
	 * Returns all the table entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the table entries that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set of table entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] filterFindByGroupId_PrevAndNext(
			long tableEntryId, long groupId,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			tableEntryId, groupId, orderByComparator);
	}

	/**
	 * Removes all the table entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of table entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching table entries
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of table entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching table entries that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns all the table entries where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByUserIdGroupId(
		long userId, long groupId) {

		return getPersistence().findByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns a range of all the table entries where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end) {

		return getPersistence().findByUserIdGroupId(
			userId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByUserIdGroupId(
			userId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserIdGroupId(
			userId, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first table entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByUserIdGroupId_First(
			long userId, long groupId,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByUserIdGroupId_First(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the first table entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByUserIdGroupId_First(
		long userId, long groupId,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByUserIdGroupId_First(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByUserIdGroupId_Last(
			long userId, long groupId,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByUserIdGroupId_Last(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByUserIdGroupId_Last(
		long userId, long groupId,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByUserIdGroupId_Last(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] findByUserIdGroupId_PrevAndNext(
			long tableEntryId, long userId, long groupId,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByUserIdGroupId_PrevAndNext(
			tableEntryId, userId, groupId, orderByComparator);
	}

	/**
	 * Returns all the table entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByUserIdGroupId(
		long userId, long groupId) {

		return getPersistence().filterFindByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns a range of all the table entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end) {

		return getPersistence().filterFindByUserIdGroupId(
			userId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries that the user has permissions to view where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries that the user has permission to view
	 */
	public static List<TableEntry> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().filterFindByUserIdGroupId(
			userId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set of table entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] filterFindByUserIdGroupId_PrevAndNext(
			long tableEntryId, long userId, long groupId,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().filterFindByUserIdGroupId_PrevAndNext(
			tableEntryId, userId, groupId, orderByComparator);
	}

	/**
	 * Removes all the table entries where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 */
	public static void removeByUserIdGroupId(long userId, long groupId) {
		getPersistence().removeByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns the number of table entries where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching table entries
	 */
	public static int countByUserIdGroupId(long userId, long groupId) {
		return getPersistence().countByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns the number of table entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching table entries that the user has permission to view
	 */
	public static int filterCountByUserIdGroupId(long userId, long groupId) {
		return getPersistence().filterCountByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns all the table entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the table entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByUserId(
		long userId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByUserId(
		long userId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first table entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByUserId_First(
			long userId, OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first table entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByUserId_First(
		long userId, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByUserId_Last(
			long userId, OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByUserId_Last(
		long userId, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where userId = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] findByUserId_PrevAndNext(
			long tableEntryId, long userId,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByUserId_PrevAndNext(
			tableEntryId, userId, orderByComparator);
	}

	/**
	 * Removes all the table entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of table entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching table entries
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the table entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByCompanyId(long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	 * Returns a range of all the table entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByCompanyId(
		long companyId, int start, int end) {

		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first table entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByCompanyId_First(
			long companyId, OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first table entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByCompanyId_First(
		long companyId, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByCompanyId_Last(
			long companyId, OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByCompanyId_Last(
		long companyId, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where companyId = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] findByCompanyId_PrevAndNext(
			long tableEntryId, long companyId,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByCompanyId_PrevAndNext(
			tableEntryId, companyId, orderByComparator);
	}

	/**
	 * Removes all the table entries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	 * Returns the number of table entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching table entries
	 */
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	 * Returns all the table entries where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByTableEntryId(long tableEntryId) {
		return getPersistence().findByTableEntryId(tableEntryId);
	}

	/**
	 * Returns a range of all the table entries where tableEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableEntryId the table entry ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByTableEntryId(
		long tableEntryId, int start, int end) {

		return getPersistence().findByTableEntryId(tableEntryId, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where tableEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableEntryId the table entry ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByTableEntryId(
		long tableEntryId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByTableEntryId(
			tableEntryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where tableEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableEntryId the table entry ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByTableEntryId(
		long tableEntryId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTableEntryId(
			tableEntryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first table entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByTableEntryId_First(
			long tableEntryId, OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByTableEntryId_First(
			tableEntryId, orderByComparator);
	}

	/**
	 * Returns the first table entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByTableEntryId_First(
		long tableEntryId, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByTableEntryId_First(
			tableEntryId, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByTableEntryId_Last(
			long tableEntryId, OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByTableEntryId_Last(
			tableEntryId, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByTableEntryId_Last(
		long tableEntryId, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByTableEntryId_Last(
			tableEntryId, orderByComparator);
	}

	/**
	 * Removes all the table entries where tableEntryId = &#63; from the database.
	 *
	 * @param tableEntryId the table entry ID
	 */
	public static void removeByTableEntryId(long tableEntryId) {
		getPersistence().removeByTableEntryId(tableEntryId);
	}

	/**
	 * Returns the number of table entries where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @return the number of matching table entries
	 */
	public static int countByTableEntryId(long tableEntryId) {
		return getPersistence().countByTableEntryId(tableEntryId);
	}

	/**
	 * Returns all the table entries where tableName = &#63;.
	 *
	 * @param tableName the table name
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByTableName(String tableName) {
		return getPersistence().findByTableName(tableName);
	}

	/**
	 * Returns a range of all the table entries where tableName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableName the table name
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByTableName(
		String tableName, int start, int end) {

		return getPersistence().findByTableName(tableName, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where tableName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableName the table name
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByTableName(
		String tableName, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByTableName(
			tableName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where tableName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableName the table name
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByTableName(
		String tableName, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTableName(
			tableName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first table entry in the ordered set where tableName = &#63;.
	 *
	 * @param tableName the table name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByTableName_First(
			String tableName, OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByTableName_First(
			tableName, orderByComparator);
	}

	/**
	 * Returns the first table entry in the ordered set where tableName = &#63;.
	 *
	 * @param tableName the table name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByTableName_First(
		String tableName, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByTableName_First(
			tableName, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where tableName = &#63;.
	 *
	 * @param tableName the table name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByTableName_Last(
			String tableName, OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByTableName_Last(
			tableName, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where tableName = &#63;.
	 *
	 * @param tableName the table name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByTableName_Last(
		String tableName, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByTableName_Last(
			tableName, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where tableName = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param tableName the table name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] findByTableName_PrevAndNext(
			long tableEntryId, String tableName,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByTableName_PrevAndNext(
			tableEntryId, tableName, orderByComparator);
	}

	/**
	 * Removes all the table entries where tableName = &#63; from the database.
	 *
	 * @param tableName the table name
	 */
	public static void removeByTableName(String tableName) {
		getPersistence().removeByTableName(tableName);
	}

	/**
	 * Returns the number of table entries where tableName = &#63;.
	 *
	 * @param tableName the table name
	 * @return the number of matching table entries
	 */
	public static int countByTableName(String tableName) {
		return getPersistence().countByTableName(tableName);
	}

	/**
	 * Returns all the table entries where tableFullName = &#63;.
	 *
	 * @param tableFullName the table full name
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByTableFullName(String tableFullName) {
		return getPersistence().findByTableFullName(tableFullName);
	}

	/**
	 * Returns a range of all the table entries where tableFullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableFullName the table full name
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByTableFullName(
		String tableFullName, int start, int end) {

		return getPersistence().findByTableFullName(tableFullName, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where tableFullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableFullName the table full name
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByTableFullName(
		String tableFullName, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByTableFullName(
			tableFullName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where tableFullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableFullName the table full name
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByTableFullName(
		String tableFullName, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTableFullName(
			tableFullName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first table entry in the ordered set where tableFullName = &#63;.
	 *
	 * @param tableFullName the table full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByTableFullName_First(
			String tableFullName,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByTableFullName_First(
			tableFullName, orderByComparator);
	}

	/**
	 * Returns the first table entry in the ordered set where tableFullName = &#63;.
	 *
	 * @param tableFullName the table full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByTableFullName_First(
		String tableFullName, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByTableFullName_First(
			tableFullName, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where tableFullName = &#63;.
	 *
	 * @param tableFullName the table full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByTableFullName_Last(
			String tableFullName,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByTableFullName_Last(
			tableFullName, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where tableFullName = &#63;.
	 *
	 * @param tableFullName the table full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByTableFullName_Last(
		String tableFullName, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByTableFullName_Last(
			tableFullName, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where tableFullName = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param tableFullName the table full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] findByTableFullName_PrevAndNext(
			long tableEntryId, String tableFullName,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByTableFullName_PrevAndNext(
			tableEntryId, tableFullName, orderByComparator);
	}

	/**
	 * Removes all the table entries where tableFullName = &#63; from the database.
	 *
	 * @param tableFullName the table full name
	 */
	public static void removeByTableFullName(String tableFullName) {
		getPersistence().removeByTableFullName(tableFullName);
	}

	/**
	 * Returns the number of table entries where tableFullName = &#63;.
	 *
	 * @param tableFullName the table full name
	 * @return the number of matching table entries
	 */
	public static int countByTableFullName(String tableFullName) {
		return getPersistence().countByTableFullName(tableFullName);
	}

	/**
	 * Returns all the table entries where tableType = &#63;.
	 *
	 * @param tableType the table type
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByTableType(String tableType) {
		return getPersistence().findByTableType(tableType);
	}

	/**
	 * Returns a range of all the table entries where tableType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableType the table type
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByTableType(
		String tableType, int start, int end) {

		return getPersistence().findByTableType(tableType, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where tableType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableType the table type
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByTableType(
		String tableType, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByTableType(
			tableType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where tableType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableType the table type
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByTableType(
		String tableType, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTableType(
			tableType, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first table entry in the ordered set where tableType = &#63;.
	 *
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByTableType_First(
			String tableType, OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByTableType_First(
			tableType, orderByComparator);
	}

	/**
	 * Returns the first table entry in the ordered set where tableType = &#63;.
	 *
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByTableType_First(
		String tableType, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByTableType_First(
			tableType, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where tableType = &#63;.
	 *
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByTableType_Last(
			String tableType, OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByTableType_Last(
			tableType, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where tableType = &#63;.
	 *
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByTableType_Last(
		String tableType, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByTableType_Last(
			tableType, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where tableType = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] findByTableType_PrevAndNext(
			long tableEntryId, String tableType,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByTableType_PrevAndNext(
			tableEntryId, tableType, orderByComparator);
	}

	/**
	 * Removes all the table entries where tableType = &#63; from the database.
	 *
	 * @param tableType the table type
	 */
	public static void removeByTableType(String tableType) {
		getPersistence().removeByTableType(tableType);
	}

	/**
	 * Returns the number of table entries where tableType = &#63;.
	 *
	 * @param tableType the table type
	 * @return the number of matching table entries
	 */
	public static int countByTableType(String tableType) {
		return getPersistence().countByTableType(tableType);
	}

	/**
	 * Returns all the table entries where tableDatabase = &#63;.
	 *
	 * @param tableDatabase the table database
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByTableDatabase(String tableDatabase) {
		return getPersistence().findByTableDatabase(tableDatabase);
	}

	/**
	 * Returns a range of all the table entries where tableDatabase = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableDatabase the table database
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByTableDatabase(
		String tableDatabase, int start, int end) {

		return getPersistence().findByTableDatabase(tableDatabase, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where tableDatabase = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableDatabase the table database
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByTableDatabase(
		String tableDatabase, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByTableDatabase(
			tableDatabase, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where tableDatabase = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableDatabase the table database
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByTableDatabase(
		String tableDatabase, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTableDatabase(
			tableDatabase, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first table entry in the ordered set where tableDatabase = &#63;.
	 *
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByTableDatabase_First(
			String tableDatabase,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByTableDatabase_First(
			tableDatabase, orderByComparator);
	}

	/**
	 * Returns the first table entry in the ordered set where tableDatabase = &#63;.
	 *
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByTableDatabase_First(
		String tableDatabase, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByTableDatabase_First(
			tableDatabase, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where tableDatabase = &#63;.
	 *
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByTableDatabase_Last(
			String tableDatabase,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByTableDatabase_Last(
			tableDatabase, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where tableDatabase = &#63;.
	 *
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByTableDatabase_Last(
		String tableDatabase, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByTableDatabase_Last(
			tableDatabase, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where tableDatabase = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] findByTableDatabase_PrevAndNext(
			long tableEntryId, String tableDatabase,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByTableDatabase_PrevAndNext(
			tableEntryId, tableDatabase, orderByComparator);
	}

	/**
	 * Returns all the table entries where tableDatabase = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableDatabases the table databases
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByTableDatabase(
		String[] tableDatabases) {

		return getPersistence().findByTableDatabase(tableDatabases);
	}

	/**
	 * Returns a range of all the table entries where tableDatabase = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableDatabases the table databases
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByTableDatabase(
		String[] tableDatabases, int start, int end) {

		return getPersistence().findByTableDatabase(tableDatabases, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where tableDatabase = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableDatabases the table databases
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByTableDatabase(
		String[] tableDatabases, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByTableDatabase(
			tableDatabases, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where tableDatabase = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableDatabase the table database
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByTableDatabase(
		String[] tableDatabases, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTableDatabase(
			tableDatabases, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the table entries where tableDatabase = &#63; from the database.
	 *
	 * @param tableDatabase the table database
	 */
	public static void removeByTableDatabase(String tableDatabase) {
		getPersistence().removeByTableDatabase(tableDatabase);
	}

	/**
	 * Returns the number of table entries where tableDatabase = &#63;.
	 *
	 * @param tableDatabase the table database
	 * @return the number of matching table entries
	 */
	public static int countByTableDatabase(String tableDatabase) {
		return getPersistence().countByTableDatabase(tableDatabase);
	}

	/**
	 * Returns the number of table entries where tableDatabase = any &#63;.
	 *
	 * @param tableDatabases the table databases
	 * @return the number of matching table entries
	 */
	public static int countByTableDatabase(String[] tableDatabases) {
		return getPersistence().countByTableDatabase(tableDatabases);
	}

	/**
	 * Returns all the table entries where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @return the matching table entries
	 */
	public static List<TableEntry> findBySystemEntryId(long systemEntryId) {
		return getPersistence().findBySystemEntryId(systemEntryId);
	}

	/**
	 * Returns a range of all the table entries where systemEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findBySystemEntryId(
		long systemEntryId, int start, int end) {

		return getPersistence().findBySystemEntryId(systemEntryId, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where systemEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findBySystemEntryId(
		long systemEntryId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findBySystemEntryId(
			systemEntryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where systemEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findBySystemEntryId(
		long systemEntryId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySystemEntryId(
			systemEntryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first table entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findBySystemEntryId_First(
			long systemEntryId, OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findBySystemEntryId_First(
			systemEntryId, orderByComparator);
	}

	/**
	 * Returns the first table entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchBySystemEntryId_First(
		long systemEntryId, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchBySystemEntryId_First(
			systemEntryId, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findBySystemEntryId_Last(
			long systemEntryId, OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findBySystemEntryId_Last(
			systemEntryId, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchBySystemEntryId_Last(
		long systemEntryId, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchBySystemEntryId_Last(
			systemEntryId, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] findBySystemEntryId_PrevAndNext(
			long tableEntryId, long systemEntryId,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findBySystemEntryId_PrevAndNext(
			tableEntryId, systemEntryId, orderByComparator);
	}

	/**
	 * Removes all the table entries where systemEntryId = &#63; from the database.
	 *
	 * @param systemEntryId the system entry ID
	 */
	public static void removeBySystemEntryId(long systemEntryId) {
		getPersistence().removeBySystemEntryId(systemEntryId);
	}

	/**
	 * Returns the number of table entries where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @return the number of matching table entries
	 */
	public static int countBySystemEntryId(long systemEntryId) {
		return getPersistence().countBySystemEntryId(systemEntryId);
	}

	/**
	 * Returns all the table entries where description = &#63;.
	 *
	 * @param description the description
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByDescription(String description) {
		return getPersistence().findByDescription(description);
	}

	/**
	 * Returns a range of all the table entries where description = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param description the description
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByDescription(
		String description, int start, int end) {

		return getPersistence().findByDescription(description, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where description = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param description the description
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByDescription(
		String description, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByDescription(
			description, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where description = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param description the description
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByDescription(
		String description, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDescription(
			description, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first table entry in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByDescription_First(
			String description, OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByDescription_First(
			description, orderByComparator);
	}

	/**
	 * Returns the first table entry in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByDescription_First(
		String description, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByDescription_First(
			description, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByDescription_Last(
			String description, OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByDescription_Last(
			description, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByDescription_Last(
		String description, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByDescription_Last(
			description, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where description = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] findByDescription_PrevAndNext(
			long tableEntryId, String description,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByDescription_PrevAndNext(
			tableEntryId, description, orderByComparator);
	}

	/**
	 * Removes all the table entries where description = &#63; from the database.
	 *
	 * @param description the description
	 */
	public static void removeByDescription(String description) {
		getPersistence().removeByDescription(description);
	}

	/**
	 * Returns the number of table entries where description = &#63;.
	 *
	 * @param description the description
	 * @return the number of matching table entries
	 */
	public static int countByDescription(String description) {
		return getPersistence().countByDescription(description);
	}

	/**
	 * Returns all the table entries where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByIsActive(boolean isActive) {
		return getPersistence().findByIsActive(isActive);
	}

	/**
	 * Returns a range of all the table entries where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByIsActive(
		boolean isActive, int start, int end) {

		return getPersistence().findByIsActive(isActive, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByIsActive(
		boolean isActive, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByIsActive(
			isActive, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByIsActive(
		boolean isActive, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByIsActive(
			isActive, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first table entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByIsActive_First(
			boolean isActive, OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByIsActive_First(
			isActive, orderByComparator);
	}

	/**
	 * Returns the first table entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByIsActive_First(
		boolean isActive, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByIsActive_First(
			isActive, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByIsActive_Last(
			boolean isActive, OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByIsActive_Last(
			isActive, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByIsActive_Last(
		boolean isActive, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByIsActive_Last(
			isActive, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where isActive = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] findByIsActive_PrevAndNext(
			long tableEntryId, boolean isActive,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByIsActive_PrevAndNext(
			tableEntryId, isActive, orderByComparator);
	}

	/**
	 * Removes all the table entries where isActive = &#63; from the database.
	 *
	 * @param isActive the is active
	 */
	public static void removeByIsActive(boolean isActive) {
		getPersistence().removeByIsActive(isActive);
	}

	/**
	 * Returns the number of table entries where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the number of matching table entries
	 */
	public static int countByIsActive(boolean isActive) {
		return getPersistence().countByIsActive(isActive);
	}

	/**
	 * Returns all the table entries where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByS_D(
		long systemEntryId, String tableDatabase) {

		return getPersistence().findByS_D(systemEntryId, tableDatabase);
	}

	/**
	 * Returns a range of all the table entries where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByS_D(
		long systemEntryId, String tableDatabase, int start, int end) {

		return getPersistence().findByS_D(
			systemEntryId, tableDatabase, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByS_D(
		long systemEntryId, String tableDatabase, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByS_D(
			systemEntryId, tableDatabase, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByS_D(
		long systemEntryId, String tableDatabase, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByS_D(
			systemEntryId, tableDatabase, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first table entry in the ordered set where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByS_D_First(
			long systemEntryId, String tableDatabase,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByS_D_First(
			systemEntryId, tableDatabase, orderByComparator);
	}

	/**
	 * Returns the first table entry in the ordered set where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByS_D_First(
		long systemEntryId, String tableDatabase,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByS_D_First(
			systemEntryId, tableDatabase, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByS_D_Last(
			long systemEntryId, String tableDatabase,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByS_D_Last(
			systemEntryId, tableDatabase, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByS_D_Last(
		long systemEntryId, String tableDatabase,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByS_D_Last(
			systemEntryId, tableDatabase, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] findByS_D_PrevAndNext(
			long tableEntryId, long systemEntryId, String tableDatabase,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByS_D_PrevAndNext(
			tableEntryId, systemEntryId, tableDatabase, orderByComparator);
	}

	/**
	 * Returns all the table entries where systemEntryId = &#63; and tableDatabase = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabases the table databases
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByS_D(
		long systemEntryId, String[] tableDatabases) {

		return getPersistence().findByS_D(systemEntryId, tableDatabases);
	}

	/**
	 * Returns a range of all the table entries where systemEntryId = &#63; and tableDatabase = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabases the table databases
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByS_D(
		long systemEntryId, String[] tableDatabases, int start, int end) {

		return getPersistence().findByS_D(
			systemEntryId, tableDatabases, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where systemEntryId = &#63; and tableDatabase = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabases the table databases
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByS_D(
		long systemEntryId, String[] tableDatabases, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByS_D(
			systemEntryId, tableDatabases, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where systemEntryId = &#63; and tableDatabase = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByS_D(
		long systemEntryId, String[] tableDatabases, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByS_D(
			systemEntryId, tableDatabases, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the table entries where systemEntryId = &#63; and tableDatabase = &#63; from the database.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 */
	public static void removeByS_D(long systemEntryId, String tableDatabase) {
		getPersistence().removeByS_D(systemEntryId, tableDatabase);
	}

	/**
	 * Returns the number of table entries where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @return the number of matching table entries
	 */
	public static int countByS_D(long systemEntryId, String tableDatabase) {
		return getPersistence().countByS_D(systemEntryId, tableDatabase);
	}

	/**
	 * Returns the number of table entries where systemEntryId = &#63; and tableDatabase = any &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabases the table databases
	 * @return the number of matching table entries
	 */
	public static int countByS_D(long systemEntryId, String[] tableDatabases) {
		return getPersistence().countByS_D(systemEntryId, tableDatabases);
	}

	/**
	 * Returns all the table entries where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByS_T(
		long systemEntryId, String tableType) {

		return getPersistence().findByS_T(systemEntryId, tableType);
	}

	/**
	 * Returns a range of all the table entries where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByS_T(
		long systemEntryId, String tableType, int start, int end) {

		return getPersistence().findByS_T(systemEntryId, tableType, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByS_T(
		long systemEntryId, String tableType, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByS_T(
			systemEntryId, tableType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByS_T(
		long systemEntryId, String tableType, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByS_T(
			systemEntryId, tableType, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first table entry in the ordered set where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByS_T_First(
			long systemEntryId, String tableType,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByS_T_First(
			systemEntryId, tableType, orderByComparator);
	}

	/**
	 * Returns the first table entry in the ordered set where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByS_T_First(
		long systemEntryId, String tableType,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByS_T_First(
			systemEntryId, tableType, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public static TableEntry findByS_T_Last(
			long systemEntryId, String tableType,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByS_T_Last(
			systemEntryId, tableType, orderByComparator);
	}

	/**
	 * Returns the last table entry in the ordered set where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public static TableEntry fetchByS_T_Last(
		long systemEntryId, String tableType,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().fetchByS_T_Last(
			systemEntryId, tableType, orderByComparator);
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry[] findByS_T_PrevAndNext(
			long tableEntryId, long systemEntryId, String tableType,
			OrderByComparator<TableEntry> orderByComparator)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByS_T_PrevAndNext(
			tableEntryId, systemEntryId, tableType, orderByComparator);
	}

	/**
	 * Returns all the table entries where systemEntryId = &#63; and tableType = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableTypes the table types
	 * @return the matching table entries
	 */
	public static List<TableEntry> findByS_T(
		long systemEntryId, String[] tableTypes) {

		return getPersistence().findByS_T(systemEntryId, tableTypes);
	}

	/**
	 * Returns a range of all the table entries where systemEntryId = &#63; and tableType = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableTypes the table types
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	public static List<TableEntry> findByS_T(
		long systemEntryId, String[] tableTypes, int start, int end) {

		return getPersistence().findByS_T(
			systemEntryId, tableTypes, start, end);
	}

	/**
	 * Returns an ordered range of all the table entries where systemEntryId = &#63; and tableType = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableTypes the table types
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByS_T(
		long systemEntryId, String[] tableTypes, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findByS_T(
			systemEntryId, tableTypes, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries where systemEntryId = &#63; and tableType = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	public static List<TableEntry> findByS_T(
		long systemEntryId, String[] tableTypes, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByS_T(
			systemEntryId, tableTypes, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the table entries where systemEntryId = &#63; and tableType = &#63; from the database.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 */
	public static void removeByS_T(long systemEntryId, String tableType) {
		getPersistence().removeByS_T(systemEntryId, tableType);
	}

	/**
	 * Returns the number of table entries where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @return the number of matching table entries
	 */
	public static int countByS_T(long systemEntryId, String tableType) {
		return getPersistence().countByS_T(systemEntryId, tableType);
	}

	/**
	 * Returns the number of table entries where systemEntryId = &#63; and tableType = any &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableTypes the table types
	 * @return the number of matching table entries
	 */
	public static int countByS_T(long systemEntryId, String[] tableTypes) {
		return getPersistence().countByS_T(systemEntryId, tableTypes);
	}

	/**
	 * Caches the table entry in the entity cache if it is enabled.
	 *
	 * @param tableEntry the table entry
	 */
	public static void cacheResult(TableEntry tableEntry) {
		getPersistence().cacheResult(tableEntry);
	}

	/**
	 * Caches the table entries in the entity cache if it is enabled.
	 *
	 * @param tableEntries the table entries
	 */
	public static void cacheResult(List<TableEntry> tableEntries) {
		getPersistence().cacheResult(tableEntries);
	}

	/**
	 * Creates a new table entry with the primary key. Does not add the table entry to the database.
	 *
	 * @param tableEntryId the primary key for the new table entry
	 * @return the new table entry
	 */
	public static TableEntry create(long tableEntryId) {
		return getPersistence().create(tableEntryId);
	}

	/**
	 * Removes the table entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tableEntryId the primary key of the table entry
	 * @return the table entry that was removed
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry remove(long tableEntryId)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().remove(tableEntryId);
	}

	public static TableEntry updateImpl(TableEntry tableEntry) {
		return getPersistence().updateImpl(tableEntry);
	}

	/**
	 * Returns the table entry with the primary key or throws a <code>NoSuchTableEntryException</code> if it could not be found.
	 *
	 * @param tableEntryId the primary key of the table entry
	 * @return the table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public static TableEntry findByPrimaryKey(long tableEntryId)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			NoSuchTableEntryException {

		return getPersistence().findByPrimaryKey(tableEntryId);
	}

	/**
	 * Returns the table entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tableEntryId the primary key of the table entry
	 * @return the table entry, or <code>null</code> if a table entry with the primary key could not be found
	 */
	public static TableEntry fetchByPrimaryKey(long tableEntryId) {
		return getPersistence().fetchByPrimaryKey(tableEntryId);
	}

	/**
	 * Returns all the table entries.
	 *
	 * @return the table entries
	 */
	public static List<TableEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the table entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of table entries
	 */
	public static List<TableEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the table entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of table entries
	 */
	public static List<TableEntry> findAll(
		int start, int end, OrderByComparator<TableEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of table entries
	 */
	public static List<TableEntry> findAll(
		int start, int end, OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the table entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of table entries.
	 *
	 * @return the number of table entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TableEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TableEntryPersistence _persistence;

}