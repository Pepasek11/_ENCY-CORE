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

import cz.csob.ency.modules.e3.entry.model.E3Entry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the e3 entry service. This utility wraps <code>cz.csob.ency.modules.e3.entry.service.persistence.impl.E3EntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see E3EntryPersistence
 * @generated
 */
public class E3EntryUtil {

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
	public static void clearCache(E3Entry e3Entry) {
		getPersistence().clearCache(e3Entry);
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
	public static Map<Serializable, E3Entry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<E3Entry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<E3Entry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<E3Entry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static E3Entry update(E3Entry e3Entry) {
		return getPersistence().update(e3Entry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static E3Entry update(
		E3Entry e3Entry, ServiceContext serviceContext) {

		return getPersistence().update(e3Entry, serviceContext);
	}

	/**
	 * Returns all the e3 entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e3 entries
	 */
	public static List<E3Entry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the e3 entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries
	 */
	public static List<E3Entry> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries
	 */
	public static List<E3Entry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entries
	 */
	public static List<E3Entry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<E3Entry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByUuid_First(
			String uuid, OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByUuid_First(
		String uuid, OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByUuid_Last(
			String uuid, OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByUuid_Last(
		String uuid, OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where uuid = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	public static E3Entry[] findByUuid_PrevAndNext(
			long entryId, String uuid,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByUuid_PrevAndNext(
			entryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the e3 entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of e3 entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e3 entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the e3 entries where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the matching e3 entries
	 */
	public static List<E3Entry> findByUuid_Head(String uuid, boolean head) {
		return getPersistence().findByUuid_Head(uuid, head);
	}

	/**
	 * Returns a range of all the e3 entries where uuid = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries
	 */
	public static List<E3Entry> findByUuid_Head(
		String uuid, boolean head, int start, int end) {

		return getPersistence().findByUuid_Head(uuid, head, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entries where uuid = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries
	 */
	public static List<E3Entry> findByUuid_Head(
		String uuid, boolean head, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().findByUuid_Head(
			uuid, head, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entries where uuid = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entries
	 */
	public static List<E3Entry> findByUuid_Head(
		String uuid, boolean head, int start, int end,
		OrderByComparator<E3Entry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_Head(
			uuid, head, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByUuid_Head_First(
			String uuid, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByUuid_Head_First(
			uuid, head, orderByComparator);
	}

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByUuid_Head_First(
		String uuid, boolean head,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().fetchByUuid_Head_First(
			uuid, head, orderByComparator);
	}

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByUuid_Head_Last(
			String uuid, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByUuid_Head_Last(
			uuid, head, orderByComparator);
	}

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByUuid_Head_Last(
		String uuid, boolean head,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().fetchByUuid_Head_Last(
			uuid, head, orderByComparator);
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	public static E3Entry[] findByUuid_Head_PrevAndNext(
			long entryId, String uuid, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByUuid_Head_PrevAndNext(
			entryId, uuid, head, orderByComparator);
	}

	/**
	 * Removes all the e3 entries where uuid = &#63; and head = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 */
	public static void removeByUuid_Head(String uuid, boolean head) {
		getPersistence().removeByUuid_Head(uuid, head);
	}

	/**
	 * Returns the number of e3 entries where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the number of matching e3 entries
	 */
	public static int countByUuid_Head(String uuid, boolean head) {
		return getPersistence().countByUuid_Head(uuid, head);
	}

	/**
	 * Returns all the e3 entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e3 entries
	 */
	public static List<E3Entry> findByUUID_G(String uuid, long groupId) {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the e3 entries where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries
	 */
	public static List<E3Entry> findByUUID_G(
		String uuid, long groupId, int start, int end) {

		return getPersistence().findByUUID_G(uuid, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entries where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries
	 */
	public static List<E3Entry> findByUUID_G(
		String uuid, long groupId, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().findByUUID_G(
			uuid, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entries where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entries
	 */
	public static List<E3Entry> findByUUID_G(
		String uuid, long groupId, int start, int end,
		OrderByComparator<E3Entry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUUID_G(
			uuid, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByUUID_G_First(
			String uuid, long groupId,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByUUID_G_First(
			uuid, groupId, orderByComparator);
	}

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByUUID_G_First(
		String uuid, long groupId,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().fetchByUUID_G_First(
			uuid, groupId, orderByComparator);
	}

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByUUID_G_Last(
			String uuid, long groupId,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByUUID_G_Last(
			uuid, groupId, orderByComparator);
	}

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByUUID_G_Last(
		String uuid, long groupId,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().fetchByUUID_G_Last(
			uuid, groupId, orderByComparator);
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	public static E3Entry[] findByUUID_G_PrevAndNext(
			long entryId, String uuid, long groupId,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByUUID_G_PrevAndNext(
			entryId, uuid, groupId, orderByComparator);
	}

	/**
	 * Removes all the e3 entries where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 */
	public static void removeByUUID_G(String uuid, long groupId) {
		getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of e3 entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e3 entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the e3 entry where uuid = &#63; and groupId = &#63; and head = &#63; or throws a <code>NoSuchE3EntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByUUID_G_Head(
			String uuid, long groupId, boolean head)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByUUID_G_Head(uuid, groupId, head);
	}

	/**
	 * Returns the e3 entry where uuid = &#63; and groupId = &#63; and head = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByUUID_G_Head(
		String uuid, long groupId, boolean head) {

		return getPersistence().fetchByUUID_G_Head(uuid, groupId, head);
	}

	/**
	 * Returns the e3 entry where uuid = &#63; and groupId = &#63; and head = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByUUID_G_Head(
		String uuid, long groupId, boolean head, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G_Head(
			uuid, groupId, head, useFinderCache);
	}

	/**
	 * Removes the e3 entry where uuid = &#63; and groupId = &#63; and head = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the e3 entry that was removed
	 */
	public static E3Entry removeByUUID_G_Head(
			String uuid, long groupId, boolean head)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().removeByUUID_G_Head(uuid, groupId, head);
	}

	/**
	 * Returns the number of e3 entries where uuid = &#63; and groupId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the number of matching e3 entries
	 */
	public static int countByUUID_G_Head(
		String uuid, long groupId, boolean head) {

		return getPersistence().countByUUID_G_Head(uuid, groupId, head);
	}

	/**
	 * Returns all the e3 entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e3 entries
	 */
	public static List<E3Entry> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the e3 entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries
	 */
	public static List<E3Entry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries
	 */
	public static List<E3Entry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entries
	 */
	public static List<E3Entry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<E3Entry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	public static E3Entry[] findByUuid_C_PrevAndNext(
			long entryId, String uuid, long companyId,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			entryId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the e3 entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of e3 entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e3 entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the e3 entries where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @return the matching e3 entries
	 */
	public static List<E3Entry> findByUuid_C_Head(
		String uuid, long companyId, boolean head) {

		return getPersistence().findByUuid_C_Head(uuid, companyId, head);
	}

	/**
	 * Returns a range of all the e3 entries where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries
	 */
	public static List<E3Entry> findByUuid_C_Head(
		String uuid, long companyId, boolean head, int start, int end) {

		return getPersistence().findByUuid_C_Head(
			uuid, companyId, head, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entries where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries
	 */
	public static List<E3Entry> findByUuid_C_Head(
		String uuid, long companyId, boolean head, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().findByUuid_C_Head(
			uuid, companyId, head, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entries where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entries
	 */
	public static List<E3Entry> findByUuid_C_Head(
		String uuid, long companyId, boolean head, int start, int end,
		OrderByComparator<E3Entry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C_Head(
			uuid, companyId, head, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByUuid_C_Head_First(
			String uuid, long companyId, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByUuid_C_Head_First(
			uuid, companyId, head, orderByComparator);
	}

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByUuid_C_Head_First(
		String uuid, long companyId, boolean head,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Head_First(
			uuid, companyId, head, orderByComparator);
	}

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByUuid_C_Head_Last(
			String uuid, long companyId, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByUuid_C_Head_Last(
			uuid, companyId, head, orderByComparator);
	}

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByUuid_C_Head_Last(
		String uuid, long companyId, boolean head,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Head_Last(
			uuid, companyId, head, orderByComparator);
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	public static E3Entry[] findByUuid_C_Head_PrevAndNext(
			long entryId, String uuid, long companyId, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByUuid_C_Head_PrevAndNext(
			entryId, uuid, companyId, head, orderByComparator);
	}

	/**
	 * Removes all the e3 entries where uuid = &#63; and companyId = &#63; and head = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 */
	public static void removeByUuid_C_Head(
		String uuid, long companyId, boolean head) {

		getPersistence().removeByUuid_C_Head(uuid, companyId, head);
	}

	/**
	 * Returns the number of e3 entries where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @return the number of matching e3 entries
	 */
	public static int countByUuid_C_Head(
		String uuid, long companyId, boolean head) {

		return getPersistence().countByUuid_C_Head(uuid, companyId, head);
	}

	/**
	 * Returns all the e3 entries where xid = &#63;.
	 *
	 * @param xid the xid
	 * @return the matching e3 entries
	 */
	public static List<E3Entry> findByxid(String xid) {
		return getPersistence().findByxid(xid);
	}

	/**
	 * Returns a range of all the e3 entries where xid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param xid the xid
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries
	 */
	public static List<E3Entry> findByxid(String xid, int start, int end) {
		return getPersistence().findByxid(xid, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entries where xid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param xid the xid
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries
	 */
	public static List<E3Entry> findByxid(
		String xid, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().findByxid(xid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entries where xid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param xid the xid
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entries
	 */
	public static List<E3Entry> findByxid(
		String xid, int start, int end,
		OrderByComparator<E3Entry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByxid(
			xid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first e3 entry in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByxid_First(
			String xid, OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByxid_First(xid, orderByComparator);
	}

	/**
	 * Returns the first e3 entry in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByxid_First(
		String xid, OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().fetchByxid_First(xid, orderByComparator);
	}

	/**
	 * Returns the last e3 entry in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByxid_Last(
			String xid, OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByxid_Last(xid, orderByComparator);
	}

	/**
	 * Returns the last e3 entry in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByxid_Last(
		String xid, OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().fetchByxid_Last(xid, orderByComparator);
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where xid = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	public static E3Entry[] findByxid_PrevAndNext(
			long entryId, String xid,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByxid_PrevAndNext(
			entryId, xid, orderByComparator);
	}

	/**
	 * Removes all the e3 entries where xid = &#63; from the database.
	 *
	 * @param xid the xid
	 */
	public static void removeByxid(String xid) {
		getPersistence().removeByxid(xid);
	}

	/**
	 * Returns the number of e3 entries where xid = &#63;.
	 *
	 * @param xid the xid
	 * @return the number of matching e3 entries
	 */
	public static int countByxid(String xid) {
		return getPersistence().countByxid(xid);
	}

	/**
	 * Returns the e3 entry where xid = &#63; and head = &#63; or throws a <code>NoSuchE3EntryException</code> if it could not be found.
	 *
	 * @param xid the xid
	 * @param head the head
	 * @return the matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByxid_Head(String xid, boolean head)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByxid_Head(xid, head);
	}

	/**
	 * Returns the e3 entry where xid = &#63; and head = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param xid the xid
	 * @param head the head
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByxid_Head(String xid, boolean head) {
		return getPersistence().fetchByxid_Head(xid, head);
	}

	/**
	 * Returns the e3 entry where xid = &#63; and head = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param xid the xid
	 * @param head the head
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByxid_Head(
		String xid, boolean head, boolean useFinderCache) {

		return getPersistence().fetchByxid_Head(xid, head, useFinderCache);
	}

	/**
	 * Removes the e3 entry where xid = &#63; and head = &#63; from the database.
	 *
	 * @param xid the xid
	 * @param head the head
	 * @return the e3 entry that was removed
	 */
	public static E3Entry removeByxid_Head(String xid, boolean head)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().removeByxid_Head(xid, head);
	}

	/**
	 * Returns the number of e3 entries where xid = &#63; and head = &#63;.
	 *
	 * @param xid the xid
	 * @param head the head
	 * @return the number of matching e3 entries
	 */
	public static int countByxid_Head(String xid, boolean head) {
		return getPersistence().countByxid_Head(xid, head);
	}

	/**
	 * Returns all the e3 entries where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @return the matching e3 entries
	 */
	public static List<E3Entry> findByp_f(long parentId, String parentField) {
		return getPersistence().findByp_f(parentId, parentField);
	}

	/**
	 * Returns a range of all the e3 entries where parentId = &#63; and parentField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries
	 */
	public static List<E3Entry> findByp_f(
		long parentId, String parentField, int start, int end) {

		return getPersistence().findByp_f(parentId, parentField, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entries where parentId = &#63; and parentField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries
	 */
	public static List<E3Entry> findByp_f(
		long parentId, String parentField, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().findByp_f(
			parentId, parentField, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entries where parentId = &#63; and parentField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entries
	 */
	public static List<E3Entry> findByp_f(
		long parentId, String parentField, int start, int end,
		OrderByComparator<E3Entry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByp_f(
			parentId, parentField, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first e3 entry in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByp_f_First(
			long parentId, String parentField,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByp_f_First(
			parentId, parentField, orderByComparator);
	}

	/**
	 * Returns the first e3 entry in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByp_f_First(
		long parentId, String parentField,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().fetchByp_f_First(
			parentId, parentField, orderByComparator);
	}

	/**
	 * Returns the last e3 entry in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByp_f_Last(
			long parentId, String parentField,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByp_f_Last(
			parentId, parentField, orderByComparator);
	}

	/**
	 * Returns the last e3 entry in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByp_f_Last(
		long parentId, String parentField,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().fetchByp_f_Last(
			parentId, parentField, orderByComparator);
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	public static E3Entry[] findByp_f_PrevAndNext(
			long entryId, long parentId, String parentField,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByp_f_PrevAndNext(
			entryId, parentId, parentField, orderByComparator);
	}

	/**
	 * Removes all the e3 entries where parentId = &#63; and parentField = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 */
	public static void removeByp_f(long parentId, String parentField) {
		getPersistence().removeByp_f(parentId, parentField);
	}

	/**
	 * Returns the number of e3 entries where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @return the number of matching e3 entries
	 */
	public static int countByp_f(long parentId, String parentField) {
		return getPersistence().countByp_f(parentId, parentField);
	}

	/**
	 * Returns the e3 entry where parentId = &#63; and parentField = &#63; and head = &#63; or throws a <code>NoSuchE3EntryException</code> if it could not be found.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param head the head
	 * @return the matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByp_f_Head(
			long parentId, String parentField, boolean head)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByp_f_Head(parentId, parentField, head);
	}

	/**
	 * Returns the e3 entry where parentId = &#63; and parentField = &#63; and head = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param head the head
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByp_f_Head(
		long parentId, String parentField, boolean head) {

		return getPersistence().fetchByp_f_Head(parentId, parentField, head);
	}

	/**
	 * Returns the e3 entry where parentId = &#63; and parentField = &#63; and head = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param head the head
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByp_f_Head(
		long parentId, String parentField, boolean head,
		boolean useFinderCache) {

		return getPersistence().fetchByp_f_Head(
			parentId, parentField, head, useFinderCache);
	}

	/**
	 * Removes the e3 entry where parentId = &#63; and parentField = &#63; and head = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param head the head
	 * @return the e3 entry that was removed
	 */
	public static E3Entry removeByp_f_Head(
			long parentId, String parentField, boolean head)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().removeByp_f_Head(parentId, parentField, head);
	}

	/**
	 * Returns the number of e3 entries where parentId = &#63; and parentField = &#63; and head = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param head the head
	 * @return the number of matching e3 entries
	 */
	public static int countByp_f_Head(
		long parentId, String parentField, boolean head) {

		return getPersistence().countByp_f_Head(parentId, parentField, head);
	}

	/**
	 * Returns all the e3 entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching e3 entries
	 */
	public static List<E3Entry> findByStatus(long status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the e3 entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries
	 */
	public static List<E3Entry> findByStatus(long status, int start, int end) {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries
	 */
	public static List<E3Entry> findByStatus(
		long status, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entries
	 */
	public static List<E3Entry> findByStatus(
		long status, int start, int end,
		OrderByComparator<E3Entry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first e3 entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByStatus_First(
			long status, OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first e3 entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByStatus_First(
		long status, OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last e3 entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByStatus_Last(
			long status, OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last e3 entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByStatus_Last(
		long status, OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where status = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	public static E3Entry[] findByStatus_PrevAndNext(
			long entryId, long status,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByStatus_PrevAndNext(
			entryId, status, orderByComparator);
	}

	/**
	 * Removes all the e3 entries where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(long status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of e3 entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching e3 entries
	 */
	public static int countByStatus(long status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the e3 entries where status = &#63; and head = &#63;.
	 *
	 * @param status the status
	 * @param head the head
	 * @return the matching e3 entries
	 */
	public static List<E3Entry> findByStatus_Head(long status, boolean head) {
		return getPersistence().findByStatus_Head(status, head);
	}

	/**
	 * Returns a range of all the e3 entries where status = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries
	 */
	public static List<E3Entry> findByStatus_Head(
		long status, boolean head, int start, int end) {

		return getPersistence().findByStatus_Head(status, head, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entries where status = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries
	 */
	public static List<E3Entry> findByStatus_Head(
		long status, boolean head, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().findByStatus_Head(
			status, head, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entries where status = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entries
	 */
	public static List<E3Entry> findByStatus_Head(
		long status, boolean head, int start, int end,
		OrderByComparator<E3Entry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByStatus_Head(
			status, head, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first e3 entry in the ordered set where status = &#63; and head = &#63;.
	 *
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByStatus_Head_First(
			long status, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByStatus_Head_First(
			status, head, orderByComparator);
	}

	/**
	 * Returns the first e3 entry in the ordered set where status = &#63; and head = &#63;.
	 *
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByStatus_Head_First(
		long status, boolean head,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().fetchByStatus_Head_First(
			status, head, orderByComparator);
	}

	/**
	 * Returns the last e3 entry in the ordered set where status = &#63; and head = &#63;.
	 *
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByStatus_Head_Last(
			long status, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByStatus_Head_Last(
			status, head, orderByComparator);
	}

	/**
	 * Returns the last e3 entry in the ordered set where status = &#63; and head = &#63;.
	 *
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByStatus_Head_Last(
		long status, boolean head,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().fetchByStatus_Head_Last(
			status, head, orderByComparator);
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where status = &#63; and head = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	public static E3Entry[] findByStatus_Head_PrevAndNext(
			long entryId, long status, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByStatus_Head_PrevAndNext(
			entryId, status, head, orderByComparator);
	}

	/**
	 * Removes all the e3 entries where status = &#63; and head = &#63; from the database.
	 *
	 * @param status the status
	 * @param head the head
	 */
	public static void removeByStatus_Head(long status, boolean head) {
		getPersistence().removeByStatus_Head(status, head);
	}

	/**
	 * Returns the number of e3 entries where status = &#63; and head = &#63;.
	 *
	 * @param status the status
	 * @param head the head
	 * @return the number of matching e3 entries
	 */
	public static int countByStatus_Head(long status, boolean head) {
		return getPersistence().countByStatus_Head(status, head);
	}

	/**
	 * Returns all the e3 entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching e3 entries
	 */
	public static List<E3Entry> findByG_S(long groupId, long status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the e3 entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries
	 */
	public static List<E3Entry> findByG_S(
		long groupId, long status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries
	 */
	public static List<E3Entry> findByG_S(
		long groupId, long status, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entries
	 */
	public static List<E3Entry> findByG_S(
		long groupId, long status, int start, int end,
		OrderByComparator<E3Entry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first e3 entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByG_S_First(
			long groupId, long status,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first e3 entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByG_S_First(
		long groupId, long status,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last e3 entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByG_S_Last(
			long groupId, long status,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last e3 entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByG_S_Last(
		long groupId, long status,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	public static E3Entry[] findByG_S_PrevAndNext(
			long entryId, long groupId, long status,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByG_S_PrevAndNext(
			entryId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the e3 entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching e3 entries that the user has permission to view
	 */
	public static List<E3Entry> filterFindByG_S(long groupId, long status) {
		return getPersistence().filterFindByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the e3 entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries that the user has permission to view
	 */
	public static List<E3Entry> filterFindByG_S(
		long groupId, long status, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entries that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries that the user has permission to view
	 */
	public static List<E3Entry> filterFindByG_S(
		long groupId, long status, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().filterFindByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set of e3 entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	public static E3Entry[] filterFindByG_S_PrevAndNext(
			long entryId, long groupId, long status,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().filterFindByG_S_PrevAndNext(
			entryId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the e3 entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, long status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of e3 entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching e3 entries
	 */
	public static int countByG_S(long groupId, long status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns the number of e3 entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching e3 entries that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, long status) {
		return getPersistence().filterCountByG_S(groupId, status);
	}

	/**
	 * Returns all the e3 entries where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @return the matching e3 entries
	 */
	public static List<E3Entry> findByG_S_Head(
		long groupId, long status, boolean head) {

		return getPersistence().findByG_S_Head(groupId, status, head);
	}

	/**
	 * Returns a range of all the e3 entries where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries
	 */
	public static List<E3Entry> findByG_S_Head(
		long groupId, long status, boolean head, int start, int end) {

		return getPersistence().findByG_S_Head(
			groupId, status, head, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entries where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries
	 */
	public static List<E3Entry> findByG_S_Head(
		long groupId, long status, boolean head, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().findByG_S_Head(
			groupId, status, head, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entries where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entries
	 */
	public static List<E3Entry> findByG_S_Head(
		long groupId, long status, boolean head, int start, int end,
		OrderByComparator<E3Entry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_S_Head(
			groupId, status, head, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first e3 entry in the ordered set where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByG_S_Head_First(
			long groupId, long status, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByG_S_Head_First(
			groupId, status, head, orderByComparator);
	}

	/**
	 * Returns the first e3 entry in the ordered set where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByG_S_Head_First(
		long groupId, long status, boolean head,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().fetchByG_S_Head_First(
			groupId, status, head, orderByComparator);
	}

	/**
	 * Returns the last e3 entry in the ordered set where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByG_S_Head_Last(
			long groupId, long status, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByG_S_Head_Last(
			groupId, status, head, orderByComparator);
	}

	/**
	 * Returns the last e3 entry in the ordered set where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByG_S_Head_Last(
		long groupId, long status, boolean head,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().fetchByG_S_Head_Last(
			groupId, status, head, orderByComparator);
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	public static E3Entry[] findByG_S_Head_PrevAndNext(
			long entryId, long groupId, long status, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByG_S_Head_PrevAndNext(
			entryId, groupId, status, head, orderByComparator);
	}

	/**
	 * Returns all the e3 entries that the user has permission to view where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @return the matching e3 entries that the user has permission to view
	 */
	public static List<E3Entry> filterFindByG_S_Head(
		long groupId, long status, boolean head) {

		return getPersistence().filterFindByG_S_Head(groupId, status, head);
	}

	/**
	 * Returns a range of all the e3 entries that the user has permission to view where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries that the user has permission to view
	 */
	public static List<E3Entry> filterFindByG_S_Head(
		long groupId, long status, boolean head, int start, int end) {

		return getPersistence().filterFindByG_S_Head(
			groupId, status, head, start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entries that the user has permissions to view where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries that the user has permission to view
	 */
	public static List<E3Entry> filterFindByG_S_Head(
		long groupId, long status, boolean head, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().filterFindByG_S_Head(
			groupId, status, head, start, end, orderByComparator);
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set of e3 entries that the user has permission to view where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	public static E3Entry[] filterFindByG_S_Head_PrevAndNext(
			long entryId, long groupId, long status, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().filterFindByG_S_Head_PrevAndNext(
			entryId, groupId, status, head, orderByComparator);
	}

	/**
	 * Removes all the e3 entries where groupId = &#63; and status = &#63; and head = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 */
	public static void removeByG_S_Head(
		long groupId, long status, boolean head) {

		getPersistence().removeByG_S_Head(groupId, status, head);
	}

	/**
	 * Returns the number of e3 entries where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @return the number of matching e3 entries
	 */
	public static int countByG_S_Head(long groupId, long status, boolean head) {
		return getPersistence().countByG_S_Head(groupId, status, head);
	}

	/**
	 * Returns the number of e3 entries that the user has permission to view where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @return the number of matching e3 entries that the user has permission to view
	 */
	public static int filterCountByG_S_Head(
		long groupId, long status, boolean head) {

		return getPersistence().filterCountByG_S_Head(groupId, status, head);
	}

	/**
	 * Returns the e3 entry where headId = &#63; or throws a <code>NoSuchE3EntryException</code> if it could not be found.
	 *
	 * @param headId the head ID
	 * @return the matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public static E3Entry findByHeadId(long headId)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByHeadId(headId);
	}

	/**
	 * Returns the e3 entry where headId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param headId the head ID
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByHeadId(long headId) {
		return getPersistence().fetchByHeadId(headId);
	}

	/**
	 * Returns the e3 entry where headId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param headId the head ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public static E3Entry fetchByHeadId(long headId, boolean useFinderCache) {
		return getPersistence().fetchByHeadId(headId, useFinderCache);
	}

	/**
	 * Removes the e3 entry where headId = &#63; from the database.
	 *
	 * @param headId the head ID
	 * @return the e3 entry that was removed
	 */
	public static E3Entry removeByHeadId(long headId)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().removeByHeadId(headId);
	}

	/**
	 * Returns the number of e3 entries where headId = &#63;.
	 *
	 * @param headId the head ID
	 * @return the number of matching e3 entries
	 */
	public static int countByHeadId(long headId) {
		return getPersistence().countByHeadId(headId);
	}

	/**
	 * Caches the e3 entry in the entity cache if it is enabled.
	 *
	 * @param e3Entry the e3 entry
	 */
	public static void cacheResult(E3Entry e3Entry) {
		getPersistence().cacheResult(e3Entry);
	}

	/**
	 * Caches the e3 entries in the entity cache if it is enabled.
	 *
	 * @param e3Entries the e3 entries
	 */
	public static void cacheResult(List<E3Entry> e3Entries) {
		getPersistence().cacheResult(e3Entries);
	}

	/**
	 * Creates a new e3 entry with the primary key. Does not add the e3 entry to the database.
	 *
	 * @param entryId the primary key for the new e3 entry
	 * @return the new e3 entry
	 */
	public static E3Entry create(long entryId) {
		return getPersistence().create(entryId);
	}

	/**
	 * Removes the e3 entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the e3 entry
	 * @return the e3 entry that was removed
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	public static E3Entry remove(long entryId)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().remove(entryId);
	}

	public static E3Entry updateImpl(E3Entry e3Entry) {
		return getPersistence().updateImpl(e3Entry);
	}

	/**
	 * Returns the e3 entry with the primary key or throws a <code>NoSuchE3EntryException</code> if it could not be found.
	 *
	 * @param entryId the primary key of the e3 entry
	 * @return the e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	public static E3Entry findByPrimaryKey(long entryId)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getPersistence().findByPrimaryKey(entryId);
	}

	/**
	 * Returns the e3 entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the e3 entry
	 * @return the e3 entry, or <code>null</code> if a e3 entry with the primary key could not be found
	 */
	public static E3Entry fetchByPrimaryKey(long entryId) {
		return getPersistence().fetchByPrimaryKey(entryId);
	}

	/**
	 * Returns all the e3 entries.
	 *
	 * @return the e3 entries
	 */
	public static List<E3Entry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the e3 entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of e3 entries
	 */
	public static List<E3Entry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the e3 entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e3 entries
	 */
	public static List<E3Entry> findAll(
		int start, int end, OrderByComparator<E3Entry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e3 entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of e3 entries
	 */
	public static List<E3Entry> findAll(
		int start, int end, OrderByComparator<E3Entry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the e3 entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of e3 entries.
	 *
	 * @return the number of e3 entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static E3EntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<E3EntryPersistence, E3EntryPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(E3EntryPersistence.class);

		ServiceTracker<E3EntryPersistence, E3EntryPersistence> serviceTracker =
			new ServiceTracker<E3EntryPersistence, E3EntryPersistence>(
				bundle.getBundleContext(), E3EntryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}