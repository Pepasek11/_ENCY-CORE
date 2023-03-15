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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException;
import cz.csob.ency.modules.e3.entry.model.E3Entry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the e3 entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see E3EntryUtil
 * @generated
 */
@ProviderType
public interface E3EntryPersistence extends BasePersistence<E3Entry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link E3EntryUtil} to access the e3 entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the e3 entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e3 entries
	 */
	public java.util.List<E3Entry> findByUuid(String uuid);

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
	public java.util.List<E3Entry> findByUuid(String uuid, int start, int end);

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
	public java.util.List<E3Entry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public java.util.List<E3Entry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public E3Entry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public E3Entry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where uuid = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	public E3Entry[] findByUuid_PrevAndNext(
			long entryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Removes all the e3 entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of e3 entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e3 entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the e3 entries where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the matching e3 entries
	 */
	public java.util.List<E3Entry> findByUuid_Head(String uuid, boolean head);

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
	public java.util.List<E3Entry> findByUuid_Head(
		String uuid, boolean head, int start, int end);

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
	public java.util.List<E3Entry> findByUuid_Head(
		String uuid, boolean head, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public java.util.List<E3Entry> findByUuid_Head(
		String uuid, boolean head, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public E3Entry findByUuid_Head_First(
			String uuid, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByUuid_Head_First(
		String uuid, boolean head,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public E3Entry findByUuid_Head_Last(
			String uuid, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByUuid_Head_Last(
		String uuid, boolean head,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public E3Entry[] findByUuid_Head_PrevAndNext(
			long entryId, String uuid, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Removes all the e3 entries where uuid = &#63; and head = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 */
	public void removeByUuid_Head(String uuid, boolean head);

	/**
	 * Returns the number of e3 entries where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the number of matching e3 entries
	 */
	public int countByUuid_Head(String uuid, boolean head);

	/**
	 * Returns all the e3 entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e3 entries
	 */
	public java.util.List<E3Entry> findByUUID_G(String uuid, long groupId);

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
	public java.util.List<E3Entry> findByUUID_G(
		String uuid, long groupId, int start, int end);

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
	public java.util.List<E3Entry> findByUUID_G(
		String uuid, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public java.util.List<E3Entry> findByUUID_G(
		String uuid, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public E3Entry findByUUID_G_First(
			String uuid, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByUUID_G_First(
		String uuid, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public E3Entry findByUUID_G_Last(
			String uuid, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByUUID_G_Last(
		String uuid, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public E3Entry[] findByUUID_G_PrevAndNext(
			long entryId, String uuid, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Removes all the e3 entries where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 */
	public void removeByUUID_G(String uuid, long groupId);

	/**
	 * Returns the number of e3 entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e3 entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns the e3 entry where uuid = &#63; and groupId = &#63; and head = &#63; or throws a <code>NoSuchE3EntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public E3Entry findByUUID_G_Head(String uuid, long groupId, boolean head)
		throws NoSuchE3EntryException;

	/**
	 * Returns the e3 entry where uuid = &#63; and groupId = &#63; and head = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByUUID_G_Head(String uuid, long groupId, boolean head);

	/**
	 * Returns the e3 entry where uuid = &#63; and groupId = &#63; and head = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByUUID_G_Head(
		String uuid, long groupId, boolean head, boolean useFinderCache);

	/**
	 * Removes the e3 entry where uuid = &#63; and groupId = &#63; and head = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the e3 entry that was removed
	 */
	public E3Entry removeByUUID_G_Head(String uuid, long groupId, boolean head)
		throws NoSuchE3EntryException;

	/**
	 * Returns the number of e3 entries where uuid = &#63; and groupId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the number of matching e3 entries
	 */
	public int countByUUID_G_Head(String uuid, long groupId, boolean head);

	/**
	 * Returns all the e3 entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e3 entries
	 */
	public java.util.List<E3Entry> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<E3Entry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<E3Entry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public java.util.List<E3Entry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public E3Entry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public E3Entry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public E3Entry[] findByUuid_C_PrevAndNext(
			long entryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Removes all the e3 entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of e3 entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e3 entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the e3 entries where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @return the matching e3 entries
	 */
	public java.util.List<E3Entry> findByUuid_C_Head(
		String uuid, long companyId, boolean head);

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
	public java.util.List<E3Entry> findByUuid_C_Head(
		String uuid, long companyId, boolean head, int start, int end);

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
	public java.util.List<E3Entry> findByUuid_C_Head(
		String uuid, long companyId, boolean head, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public java.util.List<E3Entry> findByUuid_C_Head(
		String uuid, long companyId, boolean head, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator,
		boolean useFinderCache);

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
	public E3Entry findByUuid_C_Head_First(
			String uuid, long companyId, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByUuid_C_Head_First(
		String uuid, long companyId, boolean head,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public E3Entry findByUuid_C_Head_Last(
			String uuid, long companyId, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByUuid_C_Head_Last(
		String uuid, long companyId, boolean head,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public E3Entry[] findByUuid_C_Head_PrevAndNext(
			long entryId, String uuid, long companyId, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Removes all the e3 entries where uuid = &#63; and companyId = &#63; and head = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 */
	public void removeByUuid_C_Head(String uuid, long companyId, boolean head);

	/**
	 * Returns the number of e3 entries where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @return the number of matching e3 entries
	 */
	public int countByUuid_C_Head(String uuid, long companyId, boolean head);

	/**
	 * Returns all the e3 entries where xid = &#63;.
	 *
	 * @param xid the xid
	 * @return the matching e3 entries
	 */
	public java.util.List<E3Entry> findByxid(String xid);

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
	public java.util.List<E3Entry> findByxid(String xid, int start, int end);

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
	public java.util.List<E3Entry> findByxid(
		String xid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public java.util.List<E3Entry> findByxid(
		String xid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first e3 entry in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public E3Entry findByxid_First(
			String xid,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns the first e3 entry in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByxid_First(
		String xid,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

	/**
	 * Returns the last e3 entry in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public E3Entry findByxid_Last(
			String xid,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns the last e3 entry in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByxid_Last(
		String xid,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where xid = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	public E3Entry[] findByxid_PrevAndNext(
			long entryId, String xid,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Removes all the e3 entries where xid = &#63; from the database.
	 *
	 * @param xid the xid
	 */
	public void removeByxid(String xid);

	/**
	 * Returns the number of e3 entries where xid = &#63;.
	 *
	 * @param xid the xid
	 * @return the number of matching e3 entries
	 */
	public int countByxid(String xid);

	/**
	 * Returns the e3 entry where xid = &#63; and head = &#63; or throws a <code>NoSuchE3EntryException</code> if it could not be found.
	 *
	 * @param xid the xid
	 * @param head the head
	 * @return the matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public E3Entry findByxid_Head(String xid, boolean head)
		throws NoSuchE3EntryException;

	/**
	 * Returns the e3 entry where xid = &#63; and head = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param xid the xid
	 * @param head the head
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByxid_Head(String xid, boolean head);

	/**
	 * Returns the e3 entry where xid = &#63; and head = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param xid the xid
	 * @param head the head
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByxid_Head(
		String xid, boolean head, boolean useFinderCache);

	/**
	 * Removes the e3 entry where xid = &#63; and head = &#63; from the database.
	 *
	 * @param xid the xid
	 * @param head the head
	 * @return the e3 entry that was removed
	 */
	public E3Entry removeByxid_Head(String xid, boolean head)
		throws NoSuchE3EntryException;

	/**
	 * Returns the number of e3 entries where xid = &#63; and head = &#63;.
	 *
	 * @param xid the xid
	 * @param head the head
	 * @return the number of matching e3 entries
	 */
	public int countByxid_Head(String xid, boolean head);

	/**
	 * Returns all the e3 entries where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @return the matching e3 entries
	 */
	public java.util.List<E3Entry> findByp_f(long parentId, String parentField);

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
	public java.util.List<E3Entry> findByp_f(
		long parentId, String parentField, int start, int end);

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
	public java.util.List<E3Entry> findByp_f(
		long parentId, String parentField, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public java.util.List<E3Entry> findByp_f(
		long parentId, String parentField, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first e3 entry in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public E3Entry findByp_f_First(
			long parentId, String parentField,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns the first e3 entry in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByp_f_First(
		long parentId, String parentField,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

	/**
	 * Returns the last e3 entry in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public E3Entry findByp_f_Last(
			long parentId, String parentField,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns the last e3 entry in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByp_f_Last(
		long parentId, String parentField,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public E3Entry[] findByp_f_PrevAndNext(
			long entryId, long parentId, String parentField,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Removes all the e3 entries where parentId = &#63; and parentField = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 */
	public void removeByp_f(long parentId, String parentField);

	/**
	 * Returns the number of e3 entries where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @return the number of matching e3 entries
	 */
	public int countByp_f(long parentId, String parentField);

	/**
	 * Returns the e3 entry where parentId = &#63; and parentField = &#63; and head = &#63; or throws a <code>NoSuchE3EntryException</code> if it could not be found.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param head the head
	 * @return the matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public E3Entry findByp_f_Head(
			long parentId, String parentField, boolean head)
		throws NoSuchE3EntryException;

	/**
	 * Returns the e3 entry where parentId = &#63; and parentField = &#63; and head = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param head the head
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByp_f_Head(
		long parentId, String parentField, boolean head);

	/**
	 * Returns the e3 entry where parentId = &#63; and parentField = &#63; and head = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param head the head
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByp_f_Head(
		long parentId, String parentField, boolean head,
		boolean useFinderCache);

	/**
	 * Removes the e3 entry where parentId = &#63; and parentField = &#63; and head = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param head the head
	 * @return the e3 entry that was removed
	 */
	public E3Entry removeByp_f_Head(
			long parentId, String parentField, boolean head)
		throws NoSuchE3EntryException;

	/**
	 * Returns the number of e3 entries where parentId = &#63; and parentField = &#63; and head = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param head the head
	 * @return the number of matching e3 entries
	 */
	public int countByp_f_Head(long parentId, String parentField, boolean head);

	/**
	 * Returns all the e3 entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching e3 entries
	 */
	public java.util.List<E3Entry> findByStatus(long status);

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
	public java.util.List<E3Entry> findByStatus(
		long status, int start, int end);

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
	public java.util.List<E3Entry> findByStatus(
		long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public java.util.List<E3Entry> findByStatus(
		long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first e3 entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public E3Entry findByStatus_First(
			long status,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns the first e3 entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByStatus_First(
		long status,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

	/**
	 * Returns the last e3 entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public E3Entry findByStatus_Last(
			long status,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns the last e3 entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByStatus_Last(
		long status,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where status = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	public E3Entry[] findByStatus_PrevAndNext(
			long entryId, long status,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Removes all the e3 entries where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(long status);

	/**
	 * Returns the number of e3 entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching e3 entries
	 */
	public int countByStatus(long status);

	/**
	 * Returns all the e3 entries where status = &#63; and head = &#63;.
	 *
	 * @param status the status
	 * @param head the head
	 * @return the matching e3 entries
	 */
	public java.util.List<E3Entry> findByStatus_Head(long status, boolean head);

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
	public java.util.List<E3Entry> findByStatus_Head(
		long status, boolean head, int start, int end);

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
	public java.util.List<E3Entry> findByStatus_Head(
		long status, boolean head, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public java.util.List<E3Entry> findByStatus_Head(
		long status, boolean head, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first e3 entry in the ordered set where status = &#63; and head = &#63;.
	 *
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public E3Entry findByStatus_Head_First(
			long status, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns the first e3 entry in the ordered set where status = &#63; and head = &#63;.
	 *
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByStatus_Head_First(
		long status, boolean head,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

	/**
	 * Returns the last e3 entry in the ordered set where status = &#63; and head = &#63;.
	 *
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public E3Entry findByStatus_Head_Last(
			long status, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns the last e3 entry in the ordered set where status = &#63; and head = &#63;.
	 *
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByStatus_Head_Last(
		long status, boolean head,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public E3Entry[] findByStatus_Head_PrevAndNext(
			long entryId, long status, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Removes all the e3 entries where status = &#63; and head = &#63; from the database.
	 *
	 * @param status the status
	 * @param head the head
	 */
	public void removeByStatus_Head(long status, boolean head);

	/**
	 * Returns the number of e3 entries where status = &#63; and head = &#63;.
	 *
	 * @param status the status
	 * @param head the head
	 * @return the number of matching e3 entries
	 */
	public int countByStatus_Head(long status, boolean head);

	/**
	 * Returns all the e3 entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching e3 entries
	 */
	public java.util.List<E3Entry> findByG_S(long groupId, long status);

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
	public java.util.List<E3Entry> findByG_S(
		long groupId, long status, int start, int end);

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
	public java.util.List<E3Entry> findByG_S(
		long groupId, long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public java.util.List<E3Entry> findByG_S(
		long groupId, long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first e3 entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public E3Entry findByG_S_First(
			long groupId, long status,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns the first e3 entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByG_S_First(
		long groupId, long status,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

	/**
	 * Returns the last e3 entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public E3Entry findByG_S_Last(
			long groupId, long status,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns the last e3 entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByG_S_Last(
		long groupId, long status,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public E3Entry[] findByG_S_PrevAndNext(
			long entryId, long groupId, long status,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns all the e3 entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching e3 entries that the user has permission to view
	 */
	public java.util.List<E3Entry> filterFindByG_S(long groupId, long status);

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
	public java.util.List<E3Entry> filterFindByG_S(
		long groupId, long status, int start, int end);

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
	public java.util.List<E3Entry> filterFindByG_S(
		long groupId, long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public E3Entry[] filterFindByG_S_PrevAndNext(
			long entryId, long groupId, long status,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Removes all the e3 entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, long status);

	/**
	 * Returns the number of e3 entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching e3 entries
	 */
	public int countByG_S(long groupId, long status);

	/**
	 * Returns the number of e3 entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching e3 entries that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, long status);

	/**
	 * Returns all the e3 entries where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @return the matching e3 entries
	 */
	public java.util.List<E3Entry> findByG_S_Head(
		long groupId, long status, boolean head);

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
	public java.util.List<E3Entry> findByG_S_Head(
		long groupId, long status, boolean head, int start, int end);

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
	public java.util.List<E3Entry> findByG_S_Head(
		long groupId, long status, boolean head, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public java.util.List<E3Entry> findByG_S_Head(
		long groupId, long status, boolean head, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator,
		boolean useFinderCache);

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
	public E3Entry findByG_S_Head_First(
			long groupId, long status, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns the first e3 entry in the ordered set where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByG_S_Head_First(
		long groupId, long status, boolean head,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public E3Entry findByG_S_Head_Last(
			long groupId, long status, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns the last e3 entry in the ordered set where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByG_S_Head_Last(
		long groupId, long status, boolean head,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public E3Entry[] findByG_S_Head_PrevAndNext(
			long entryId, long groupId, long status, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Returns all the e3 entries that the user has permission to view where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @return the matching e3 entries that the user has permission to view
	 */
	public java.util.List<E3Entry> filterFindByG_S_Head(
		long groupId, long status, boolean head);

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
	public java.util.List<E3Entry> filterFindByG_S_Head(
		long groupId, long status, boolean head, int start, int end);

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
	public java.util.List<E3Entry> filterFindByG_S_Head(
		long groupId, long status, boolean head, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public E3Entry[] filterFindByG_S_Head_PrevAndNext(
			long entryId, long groupId, long status, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
				orderByComparator)
		throws NoSuchE3EntryException;

	/**
	 * Removes all the e3 entries where groupId = &#63; and status = &#63; and head = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 */
	public void removeByG_S_Head(long groupId, long status, boolean head);

	/**
	 * Returns the number of e3 entries where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @return the number of matching e3 entries
	 */
	public int countByG_S_Head(long groupId, long status, boolean head);

	/**
	 * Returns the number of e3 entries that the user has permission to view where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @return the number of matching e3 entries that the user has permission to view
	 */
	public int filterCountByG_S_Head(long groupId, long status, boolean head);

	/**
	 * Returns the e3 entry where headId = &#63; or throws a <code>NoSuchE3EntryException</code> if it could not be found.
	 *
	 * @param headId the head ID
	 * @return the matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	public E3Entry findByHeadId(long headId) throws NoSuchE3EntryException;

	/**
	 * Returns the e3 entry where headId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param headId the head ID
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByHeadId(long headId);

	/**
	 * Returns the e3 entry where headId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param headId the head ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	public E3Entry fetchByHeadId(long headId, boolean useFinderCache);

	/**
	 * Removes the e3 entry where headId = &#63; from the database.
	 *
	 * @param headId the head ID
	 * @return the e3 entry that was removed
	 */
	public E3Entry removeByHeadId(long headId) throws NoSuchE3EntryException;

	/**
	 * Returns the number of e3 entries where headId = &#63;.
	 *
	 * @param headId the head ID
	 * @return the number of matching e3 entries
	 */
	public int countByHeadId(long headId);

	/**
	 * Caches the e3 entry in the entity cache if it is enabled.
	 *
	 * @param e3Entry the e3 entry
	 */
	public void cacheResult(E3Entry e3Entry);

	/**
	 * Caches the e3 entries in the entity cache if it is enabled.
	 *
	 * @param e3Entries the e3 entries
	 */
	public void cacheResult(java.util.List<E3Entry> e3Entries);

	/**
	 * Creates a new e3 entry with the primary key. Does not add the e3 entry to the database.
	 *
	 * @param entryId the primary key for the new e3 entry
	 * @return the new e3 entry
	 */
	public E3Entry create(long entryId);

	/**
	 * Removes the e3 entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the e3 entry
	 * @return the e3 entry that was removed
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	public E3Entry remove(long entryId) throws NoSuchE3EntryException;

	public E3Entry updateImpl(E3Entry e3Entry);

	/**
	 * Returns the e3 entry with the primary key or throws a <code>NoSuchE3EntryException</code> if it could not be found.
	 *
	 * @param entryId the primary key of the e3 entry
	 * @return the e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	public E3Entry findByPrimaryKey(long entryId) throws NoSuchE3EntryException;

	/**
	 * Returns the e3 entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the e3 entry
	 * @return the e3 entry, or <code>null</code> if a e3 entry with the primary key could not be found
	 */
	public E3Entry fetchByPrimaryKey(long entryId);

	/**
	 * Returns all the e3 entries.
	 *
	 * @return the e3 entries
	 */
	public java.util.List<E3Entry> findAll();

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
	public java.util.List<E3Entry> findAll(int start, int end);

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
	public java.util.List<E3Entry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator);

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
	public java.util.List<E3Entry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3Entry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the e3 entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of e3 entries.
	 *
	 * @return the number of e3 entries
	 */
	public int countAll();

}