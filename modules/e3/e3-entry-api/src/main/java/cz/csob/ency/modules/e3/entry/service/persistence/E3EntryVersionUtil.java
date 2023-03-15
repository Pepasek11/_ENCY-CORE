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

package cz.csob.ency.modules.e3.entry.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import cz.csob.ency.modules.e3.entry.model.E3EntryVersion;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the e3 entry version service. This utility wraps <code>cz.csob.ency.modules.e3.entry.service.persistence.impl.E3EntryVersionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see E3EntryVersionPersistence
 * @generated
 */
public class E3EntryVersionUtil {

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
	public static void clearCache(E3EntryVersion e3EntryVersion) {
		getPersistence().clearCache(e3EntryVersion);
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
	public static Map<Serializable, E3EntryVersion> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<E3EntryVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<E3EntryVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<E3EntryVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static E3EntryVersion update(E3EntryVersion e3EntryVersion) {
		return getPersistence().update(e3EntryVersion);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static E3EntryVersion update(
		E3EntryVersion e3EntryVersion, ServiceContext serviceContext) {

		return getPersistence().update(e3EntryVersion, serviceContext);
	}

	/**
	 * Returns all the e3 entry versions where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @return the matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByEntryId(long entryId) {
		return getPersistence().findByEntryId(entryId);
	}

	/**
	 * Returns a range of all the e3 entry versions where entryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param entryId the entry ID
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByEntryId(
		long entryId, int start, int end) {

		return getPersistence().findByEntryId(entryId, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where entryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param entryId the entry ID
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByEntryId(
		long entryId, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().findByEntryId(
			entryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where entryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param entryId the entry ID
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByEntryId(
		long entryId, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEntryId(
			entryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByEntryId_First(
			long entryId, OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByEntryId_First(entryId, orderByComparator);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByEntryId_First(
		long entryId, OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByEntryId_First(
			entryId, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByEntryId_Last(
			long entryId, OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByEntryId_Last(entryId, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByEntryId_Last(
		long entryId, OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByEntryId_Last(entryId, orderByComparator);
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where entryId = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param entryId the entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	public static E3EntryVersion[] findByEntryId_PrevAndNext(
			long e3EntryVersionId, long entryId,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByEntryId_PrevAndNext(
			e3EntryVersionId, entryId, orderByComparator);
	}

	/**
	 * Removes all the e3 entry versions where entryId = &#63; from the database.
	 *
	 * @param entryId the entry ID
	 */
	public static void removeByEntryId(long entryId) {
		getPersistence().removeByEntryId(entryId);
	}

	/**
	 * Returns the number of e3 entry versions where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @return the number of matching e3 entry versions
	 */
	public static int countByEntryId(long entryId) {
		return getPersistence().countByEntryId(entryId);
	}

	/**
	 * Returns the e3 entry version where entryId = &#63; and version = &#63; or throws a <code>NoSuchE3EntryVersionException</code> if it could not be found.
	 *
	 * @param entryId the entry ID
	 * @param version the version
	 * @return the matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByEntryId_Version(
			long entryId, int version)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByEntryId_Version(entryId, version);
	}

	/**
	 * Returns the e3 entry version where entryId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param entryId the entry ID
	 * @param version the version
	 * @return the matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByEntryId_Version(
		long entryId, int version) {

		return getPersistence().fetchByEntryId_Version(entryId, version);
	}

	/**
	 * Returns the e3 entry version where entryId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param entryId the entry ID
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByEntryId_Version(
		long entryId, int version, boolean useFinderCache) {

		return getPersistence().fetchByEntryId_Version(
			entryId, version, useFinderCache);
	}

	/**
	 * Removes the e3 entry version where entryId = &#63; and version = &#63; from the database.
	 *
	 * @param entryId the entry ID
	 * @param version the version
	 * @return the e3 entry version that was removed
	 */
	public static E3EntryVersion removeByEntryId_Version(
			long entryId, int version)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().removeByEntryId_Version(entryId, version);
	}

	/**
	 * Returns the number of e3 entry versions where entryId = &#63; and version = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	public static int countByEntryId_Version(long entryId, int version) {
		return getPersistence().countByEntryId_Version(entryId, version);
	}

	/**
	 * Returns all the e3 entry versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the e3 entry versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByUuid_First(
			String uuid, OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByUuid_First(
		String uuid, OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByUuid_Last(
			String uuid, OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByUuid_Last(
		String uuid, OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where uuid = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	public static E3EntryVersion[] findByUuid_PrevAndNext(
			long e3EntryVersionId, String uuid,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByUuid_PrevAndNext(
			e3EntryVersionId, uuid, orderByComparator);
	}

	/**
	 * Removes all the e3 entry versions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of e3 entry versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e3 entry versions
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the e3 entry versions where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByUuid_Version(
		String uuid, int version) {

		return getPersistence().findByUuid_Version(uuid, version);
	}

	/**
	 * Returns a range of all the e3 entry versions where uuid = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByUuid_Version(
		String uuid, int version, int start, int end) {

		return getPersistence().findByUuid_Version(uuid, version, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where uuid = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByUuid_Version(
		String uuid, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().findByUuid_Version(
			uuid, version, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where uuid = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByUuid_Version(
		String uuid, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_Version(
			uuid, version, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByUuid_Version_First(
			String uuid, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByUuid_Version_First(
			uuid, version, orderByComparator);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByUuid_Version_First(
		String uuid, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByUuid_Version_First(
			uuid, version, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByUuid_Version_Last(
			String uuid, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByUuid_Version_Last(
			uuid, version, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByUuid_Version_Last(
		String uuid, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByUuid_Version_Last(
			uuid, version, orderByComparator);
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	public static E3EntryVersion[] findByUuid_Version_PrevAndNext(
			long e3EntryVersionId, String uuid, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByUuid_Version_PrevAndNext(
			e3EntryVersionId, uuid, version, orderByComparator);
	}

	/**
	 * Removes all the e3 entry versions where uuid = &#63; and version = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 */
	public static void removeByUuid_Version(String uuid, int version) {
		getPersistence().removeByUuid_Version(uuid, version);
	}

	/**
	 * Returns the number of e3 entry versions where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	public static int countByUuid_Version(String uuid, int version) {
		return getPersistence().countByUuid_Version(uuid, version);
	}

	/**
	 * Returns all the e3 entry versions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByUUID_G(String uuid, long groupId) {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the e3 entry versions where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByUUID_G(
		String uuid, long groupId, int start, int end) {

		return getPersistence().findByUUID_G(uuid, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByUUID_G(
		String uuid, long groupId, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().findByUUID_G(
			uuid, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByUUID_G(
		String uuid, long groupId, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUUID_G(
			uuid, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByUUID_G_First(
			String uuid, long groupId,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByUUID_G_First(
			uuid, groupId, orderByComparator);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByUUID_G_First(
		String uuid, long groupId,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByUUID_G_First(
			uuid, groupId, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByUUID_G_Last(
			String uuid, long groupId,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByUUID_G_Last(
			uuid, groupId, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByUUID_G_Last(
		String uuid, long groupId,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByUUID_G_Last(
			uuid, groupId, orderByComparator);
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	public static E3EntryVersion[] findByUUID_G_PrevAndNext(
			long e3EntryVersionId, String uuid, long groupId,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByUUID_G_PrevAndNext(
			e3EntryVersionId, uuid, groupId, orderByComparator);
	}

	/**
	 * Removes all the e3 entry versions where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 */
	public static void removeByUUID_G(String uuid, long groupId) {
		getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of e3 entry versions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e3 entry versions
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the e3 entry version where uuid = &#63; and groupId = &#63; and version = &#63; or throws a <code>NoSuchE3EntryVersionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByUUID_G_Version(
			String uuid, long groupId, int version)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByUUID_G_Version(uuid, groupId, version);
	}

	/**
	 * Returns the e3 entry version where uuid = &#63; and groupId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByUUID_G_Version(
		String uuid, long groupId, int version) {

		return getPersistence().fetchByUUID_G_Version(uuid, groupId, version);
	}

	/**
	 * Returns the e3 entry version where uuid = &#63; and groupId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByUUID_G_Version(
		String uuid, long groupId, int version, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G_Version(
			uuid, groupId, version, useFinderCache);
	}

	/**
	 * Removes the e3 entry version where uuid = &#63; and groupId = &#63; and version = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the e3 entry version that was removed
	 */
	public static E3EntryVersion removeByUUID_G_Version(
			String uuid, long groupId, int version)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().removeByUUID_G_Version(uuid, groupId, version);
	}

	/**
	 * Returns the number of e3 entry versions where uuid = &#63; and groupId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	public static int countByUUID_G_Version(
		String uuid, long groupId, int version) {

		return getPersistence().countByUUID_G_Version(uuid, groupId, version);
	}

	/**
	 * Returns all the e3 entry versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the e3 entry versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	public static E3EntryVersion[] findByUuid_C_PrevAndNext(
			long e3EntryVersionId, String uuid, long companyId,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByUuid_C_PrevAndNext(
			e3EntryVersionId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the e3 entry versions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of e3 entry versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e3 entry versions
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the e3 entry versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @return the matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByUuid_C_Version(
		String uuid, long companyId, int version) {

		return getPersistence().findByUuid_C_Version(uuid, companyId, version);
	}

	/**
	 * Returns a range of all the e3 entry versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByUuid_C_Version(
		String uuid, long companyId, int version, int start, int end) {

		return getPersistence().findByUuid_C_Version(
			uuid, companyId, version, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByUuid_C_Version(
		String uuid, long companyId, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().findByUuid_C_Version(
			uuid, companyId, version, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByUuid_C_Version(
		String uuid, long companyId, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C_Version(
			uuid, companyId, version, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByUuid_C_Version_First(
			String uuid, long companyId, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByUuid_C_Version_First(
			uuid, companyId, version, orderByComparator);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByUuid_C_Version_First(
		String uuid, long companyId, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByUuid_C_Version_First(
			uuid, companyId, version, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByUuid_C_Version_Last(
			String uuid, long companyId, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByUuid_C_Version_Last(
			uuid, companyId, version, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByUuid_C_Version_Last(
		String uuid, long companyId, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByUuid_C_Version_Last(
			uuid, companyId, version, orderByComparator);
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	public static E3EntryVersion[] findByUuid_C_Version_PrevAndNext(
			long e3EntryVersionId, String uuid, long companyId, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByUuid_C_Version_PrevAndNext(
			e3EntryVersionId, uuid, companyId, version, orderByComparator);
	}

	/**
	 * Removes all the e3 entry versions where uuid = &#63; and companyId = &#63; and version = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 */
	public static void removeByUuid_C_Version(
		String uuid, long companyId, int version) {

		getPersistence().removeByUuid_C_Version(uuid, companyId, version);
	}

	/**
	 * Returns the number of e3 entry versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	public static int countByUuid_C_Version(
		String uuid, long companyId, int version) {

		return getPersistence().countByUuid_C_Version(uuid, companyId, version);
	}

	/**
	 * Returns all the e3 entry versions where xid = &#63;.
	 *
	 * @param xid the xid
	 * @return the matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByxid(String xid) {
		return getPersistence().findByxid(xid);
	}

	/**
	 * Returns a range of all the e3 entry versions where xid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param xid the xid
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByxid(
		String xid, int start, int end) {

		return getPersistence().findByxid(xid, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where xid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param xid the xid
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByxid(
		String xid, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().findByxid(xid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where xid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param xid the xid
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByxid(
		String xid, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByxid(
			xid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByxid_First(
			String xid, OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByxid_First(xid, orderByComparator);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByxid_First(
		String xid, OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByxid_First(xid, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByxid_Last(
			String xid, OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByxid_Last(xid, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByxid_Last(
		String xid, OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByxid_Last(xid, orderByComparator);
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where xid = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	public static E3EntryVersion[] findByxid_PrevAndNext(
			long e3EntryVersionId, String xid,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByxid_PrevAndNext(
			e3EntryVersionId, xid, orderByComparator);
	}

	/**
	 * Removes all the e3 entry versions where xid = &#63; from the database.
	 *
	 * @param xid the xid
	 */
	public static void removeByxid(String xid) {
		getPersistence().removeByxid(xid);
	}

	/**
	 * Returns the number of e3 entry versions where xid = &#63;.
	 *
	 * @param xid the xid
	 * @return the number of matching e3 entry versions
	 */
	public static int countByxid(String xid) {
		return getPersistence().countByxid(xid);
	}

	/**
	 * Returns all the e3 entry versions where xid = &#63; and version = &#63;.
	 *
	 * @param xid the xid
	 * @param version the version
	 * @return the matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByxid_Version(
		String xid, int version) {

		return getPersistence().findByxid_Version(xid, version);
	}

	/**
	 * Returns a range of all the e3 entry versions where xid = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param xid the xid
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByxid_Version(
		String xid, int version, int start, int end) {

		return getPersistence().findByxid_Version(xid, version, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where xid = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param xid the xid
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByxid_Version(
		String xid, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().findByxid_Version(
			xid, version, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where xid = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param xid the xid
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByxid_Version(
		String xid, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByxid_Version(
			xid, version, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where xid = &#63; and version = &#63;.
	 *
	 * @param xid the xid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByxid_Version_First(
			String xid, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByxid_Version_First(
			xid, version, orderByComparator);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where xid = &#63; and version = &#63;.
	 *
	 * @param xid the xid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByxid_Version_First(
		String xid, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByxid_Version_First(
			xid, version, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where xid = &#63; and version = &#63;.
	 *
	 * @param xid the xid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByxid_Version_Last(
			String xid, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByxid_Version_Last(
			xid, version, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where xid = &#63; and version = &#63;.
	 *
	 * @param xid the xid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByxid_Version_Last(
		String xid, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByxid_Version_Last(
			xid, version, orderByComparator);
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where xid = &#63; and version = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param xid the xid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	public static E3EntryVersion[] findByxid_Version_PrevAndNext(
			long e3EntryVersionId, String xid, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByxid_Version_PrevAndNext(
			e3EntryVersionId, xid, version, orderByComparator);
	}

	/**
	 * Removes all the e3 entry versions where xid = &#63; and version = &#63; from the database.
	 *
	 * @param xid the xid
	 * @param version the version
	 */
	public static void removeByxid_Version(String xid, int version) {
		getPersistence().removeByxid_Version(xid, version);
	}

	/**
	 * Returns the number of e3 entry versions where xid = &#63; and version = &#63;.
	 *
	 * @param xid the xid
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	public static int countByxid_Version(String xid, int version) {
		return getPersistence().countByxid_Version(xid, version);
	}

	/**
	 * Returns all the e3 entry versions where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @return the matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByp_f(
		long parentId, String parentField) {

		return getPersistence().findByp_f(parentId, parentField);
	}

	/**
	 * Returns a range of all the e3 entry versions where parentId = &#63; and parentField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByp_f(
		long parentId, String parentField, int start, int end) {

		return getPersistence().findByp_f(parentId, parentField, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where parentId = &#63; and parentField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByp_f(
		long parentId, String parentField, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().findByp_f(
			parentId, parentField, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where parentId = &#63; and parentField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByp_f(
		long parentId, String parentField, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByp_f(
			parentId, parentField, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByp_f_First(
			long parentId, String parentField,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByp_f_First(
			parentId, parentField, orderByComparator);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByp_f_First(
		long parentId, String parentField,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByp_f_First(
			parentId, parentField, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByp_f_Last(
			long parentId, String parentField,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByp_f_Last(
			parentId, parentField, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByp_f_Last(
		long parentId, String parentField,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByp_f_Last(
			parentId, parentField, orderByComparator);
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	public static E3EntryVersion[] findByp_f_PrevAndNext(
			long e3EntryVersionId, long parentId, String parentField,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByp_f_PrevAndNext(
			e3EntryVersionId, parentId, parentField, orderByComparator);
	}

	/**
	 * Removes all the e3 entry versions where parentId = &#63; and parentField = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 */
	public static void removeByp_f(long parentId, String parentField) {
		getPersistence().removeByp_f(parentId, parentField);
	}

	/**
	 * Returns the number of e3 entry versions where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @return the number of matching e3 entry versions
	 */
	public static int countByp_f(long parentId, String parentField) {
		return getPersistence().countByp_f(parentId, parentField);
	}

	/**
	 * Returns all the e3 entry versions where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @return the matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByp_f_Version(
		long parentId, String parentField, int version) {

		return getPersistence().findByp_f_Version(
			parentId, parentField, version);
	}

	/**
	 * Returns a range of all the e3 entry versions where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByp_f_Version(
		long parentId, String parentField, int version, int start, int end) {

		return getPersistence().findByp_f_Version(
			parentId, parentField, version, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByp_f_Version(
		long parentId, String parentField, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().findByp_f_Version(
			parentId, parentField, version, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByp_f_Version(
		long parentId, String parentField, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByp_f_Version(
			parentId, parentField, version, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByp_f_Version_First(
			long parentId, String parentField, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByp_f_Version_First(
			parentId, parentField, version, orderByComparator);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByp_f_Version_First(
		long parentId, String parentField, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByp_f_Version_First(
			parentId, parentField, version, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByp_f_Version_Last(
			long parentId, String parentField, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByp_f_Version_Last(
			parentId, parentField, version, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByp_f_Version_Last(
		long parentId, String parentField, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByp_f_Version_Last(
			parentId, parentField, version, orderByComparator);
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	public static E3EntryVersion[] findByp_f_Version_PrevAndNext(
			long e3EntryVersionId, long parentId, String parentField,
			int version, OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByp_f_Version_PrevAndNext(
			e3EntryVersionId, parentId, parentField, version,
			orderByComparator);
	}

	/**
	 * Removes all the e3 entry versions where parentId = &#63; and parentField = &#63; and version = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 */
	public static void removeByp_f_Version(
		long parentId, String parentField, int version) {

		getPersistence().removeByp_f_Version(parentId, parentField, version);
	}

	/**
	 * Returns the number of e3 entry versions where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	public static int countByp_f_Version(
		long parentId, String parentField, int version) {

		return getPersistence().countByp_f_Version(
			parentId, parentField, version);
	}

	/**
	 * Returns all the e3 entry versions where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByStatus(long status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the e3 entry versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByStatus(
		long status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByStatus(
		long status, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByStatus(
		long status, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByStatus_First(
			long status, OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByStatus_First(
		long status, OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByStatus_Last(
			long status, OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByStatus_Last(
		long status, OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where status = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	public static E3EntryVersion[] findByStatus_PrevAndNext(
			long e3EntryVersionId, long status,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByStatus_PrevAndNext(
			e3EntryVersionId, status, orderByComparator);
	}

	/**
	 * Removes all the e3 entry versions where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(long status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of e3 entry versions where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching e3 entry versions
	 */
	public static int countByStatus(long status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the e3 entry versions where status = &#63; and version = &#63;.
	 *
	 * @param status the status
	 * @param version the version
	 * @return the matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByStatus_Version(
		long status, int version) {

		return getPersistence().findByStatus_Version(status, version);
	}

	/**
	 * Returns a range of all the e3 entry versions where status = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByStatus_Version(
		long status, int version, int start, int end) {

		return getPersistence().findByStatus_Version(
			status, version, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where status = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByStatus_Version(
		long status, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().findByStatus_Version(
			status, version, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where status = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByStatus_Version(
		long status, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus_Version(
			status, version, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where status = &#63; and version = &#63;.
	 *
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByStatus_Version_First(
			long status, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByStatus_Version_First(
			status, version, orderByComparator);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where status = &#63; and version = &#63;.
	 *
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByStatus_Version_First(
		long status, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByStatus_Version_First(
			status, version, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where status = &#63; and version = &#63;.
	 *
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByStatus_Version_Last(
			long status, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByStatus_Version_Last(
			status, version, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where status = &#63; and version = &#63;.
	 *
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByStatus_Version_Last(
		long status, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByStatus_Version_Last(
			status, version, orderByComparator);
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where status = &#63; and version = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	public static E3EntryVersion[] findByStatus_Version_PrevAndNext(
			long e3EntryVersionId, long status, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByStatus_Version_PrevAndNext(
			e3EntryVersionId, status, version, orderByComparator);
	}

	/**
	 * Removes all the e3 entry versions where status = &#63; and version = &#63; from the database.
	 *
	 * @param status the status
	 * @param version the version
	 */
	public static void removeByStatus_Version(long status, int version) {
		getPersistence().removeByStatus_Version(status, version);
	}

	/**
	 * Returns the number of e3 entry versions where status = &#63; and version = &#63;.
	 *
	 * @param status the status
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	public static int countByStatus_Version(long status, int version) {
		return getPersistence().countByStatus_Version(status, version);
	}

	/**
	 * Returns all the e3 entry versions where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByG_S(long groupId, long status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the e3 entry versions where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByG_S(
		long groupId, long status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByG_S(
		long groupId, long status, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByG_S(
		long groupId, long status, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByG_S_First(
			long groupId, long status,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByG_S_First(
		long groupId, long status,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByG_S_Last(
			long groupId, long status,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByG_S_Last(
		long groupId, long status,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	public static E3EntryVersion[] findByG_S_PrevAndNext(
			long e3EntryVersionId, long groupId, long status,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByG_S_PrevAndNext(
			e3EntryVersionId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the e3 entry versions where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, long status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of e3 entry versions where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching e3 entry versions
	 */
	public static int countByG_S(long groupId, long status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns all the e3 entry versions where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @return the matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByG_S_Version(
		long groupId, long status, int version) {

		return getPersistence().findByG_S_Version(groupId, status, version);
	}

	/**
	 * Returns a range of all the e3 entry versions where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByG_S_Version(
		long groupId, long status, int version, int start, int end) {

		return getPersistence().findByG_S_Version(
			groupId, status, version, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByG_S_Version(
		long groupId, long status, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().findByG_S_Version(
			groupId, status, version, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	public static List<E3EntryVersion> findByG_S_Version(
		long groupId, long status, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S_Version(
			groupId, status, version, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByG_S_Version_First(
			long groupId, long status, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByG_S_Version_First(
			groupId, status, version, orderByComparator);
	}

	/**
	 * Returns the first e3 entry version in the ordered set where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByG_S_Version_First(
		long groupId, long status, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByG_S_Version_First(
			groupId, status, version, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion findByG_S_Version_Last(
			long groupId, long status, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByG_S_Version_Last(
			groupId, status, version, orderByComparator);
	}

	/**
	 * Returns the last e3 entry version in the ordered set where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public static E3EntryVersion fetchByG_S_Version_Last(
		long groupId, long status, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().fetchByG_S_Version_Last(
			groupId, status, version, orderByComparator);
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	public static E3EntryVersion[] findByG_S_Version_PrevAndNext(
			long e3EntryVersionId, long groupId, long status, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByG_S_Version_PrevAndNext(
			e3EntryVersionId, groupId, status, version, orderByComparator);
	}

	/**
	 * Removes all the e3 entry versions where groupId = &#63; and status = &#63; and version = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 */
	public static void removeByG_S_Version(
		long groupId, long status, int version) {

		getPersistence().removeByG_S_Version(groupId, status, version);
	}

	/**
	 * Returns the number of e3 entry versions where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	public static int countByG_S_Version(
		long groupId, long status, int version) {

		return getPersistence().countByG_S_Version(groupId, status, version);
	}

	/**
	 * Caches the e3 entry version in the entity cache if it is enabled.
	 *
	 * @param e3EntryVersion the e3 entry version
	 */
	public static void cacheResult(E3EntryVersion e3EntryVersion) {
		getPersistence().cacheResult(e3EntryVersion);
	}

	/**
	 * Caches the e3 entry versions in the entity cache if it is enabled.
	 *
	 * @param e3EntryVersions the e3 entry versions
	 */
	public static void cacheResult(List<E3EntryVersion> e3EntryVersions) {
		getPersistence().cacheResult(e3EntryVersions);
	}

	/**
	 * Creates a new e3 entry version with the primary key. Does not add the e3 entry version to the database.
	 *
	 * @param e3EntryVersionId the primary key for the new e3 entry version
	 * @return the new e3 entry version
	 */
	public static E3EntryVersion create(long e3EntryVersionId) {
		return getPersistence().create(e3EntryVersionId);
	}

	/**
	 * Removes the e3 entry version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param e3EntryVersionId the primary key of the e3 entry version
	 * @return the e3 entry version that was removed
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	public static E3EntryVersion remove(long e3EntryVersionId)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().remove(e3EntryVersionId);
	}

	public static E3EntryVersion updateImpl(E3EntryVersion e3EntryVersion) {
		return getPersistence().updateImpl(e3EntryVersion);
	}

	/**
	 * Returns the e3 entry version with the primary key or throws a <code>NoSuchE3EntryVersionException</code> if it could not be found.
	 *
	 * @param e3EntryVersionId the primary key of the e3 entry version
	 * @return the e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	public static E3EntryVersion findByPrimaryKey(long e3EntryVersionId)
		throws cz.csob.ency.modules.e3.entry.exception.
			NoSuchE3EntryVersionException {

		return getPersistence().findByPrimaryKey(e3EntryVersionId);
	}

	/**
	 * Returns the e3 entry version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param e3EntryVersionId the primary key of the e3 entry version
	 * @return the e3 entry version, or <code>null</code> if a e3 entry version with the primary key could not be found
	 */
	public static E3EntryVersion fetchByPrimaryKey(long e3EntryVersionId) {
		return getPersistence().fetchByPrimaryKey(e3EntryVersionId);
	}

	/**
	 * Returns all the e3 entry versions.
	 *
	 * @return the e3 entry versions
	 */
	public static List<E3EntryVersion> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the e3 entry versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of e3 entry versions
	 */
	public static List<E3EntryVersion> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e3 entry versions
	 */
	public static List<E3EntryVersion> findAll(
		int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of e3 entry versions
	 */
	public static List<E3EntryVersion> findAll(
		int start, int end, OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the e3 entry versions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of e3 entry versions.
	 *
	 * @return the number of e3 entry versions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static E3EntryVersionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<E3EntryVersionPersistence, E3EntryVersionPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			E3EntryVersionPersistence.class);

		ServiceTracker<E3EntryVersionPersistence, E3EntryVersionPersistence>
			serviceTracker =
				new ServiceTracker
					<E3EntryVersionPersistence, E3EntryVersionPersistence>(
						bundle.getBundleContext(),
						E3EntryVersionPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}