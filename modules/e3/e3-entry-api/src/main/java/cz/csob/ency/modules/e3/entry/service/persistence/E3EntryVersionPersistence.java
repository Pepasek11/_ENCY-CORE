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

import cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryVersionException;
import cz.csob.ency.modules.e3.entry.model.E3EntryVersion;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the e3 entry version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see E3EntryVersionUtil
 * @generated
 */
@ProviderType
public interface E3EntryVersionPersistence
	extends BasePersistence<E3EntryVersion> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link E3EntryVersionUtil} to access the e3 entry version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the e3 entry versions where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @return the matching e3 entry versions
	 */
	public java.util.List<E3EntryVersion> findByEntryId(long entryId);

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
	public java.util.List<E3EntryVersion> findByEntryId(
		long entryId, int start, int end);

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
	public java.util.List<E3EntryVersion> findByEntryId(
		long entryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public java.util.List<E3EntryVersion> findByEntryId(
		long entryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first e3 entry version in the ordered set where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByEntryId_First(
			long entryId,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the first e3 entry version in the ordered set where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByEntryId_First(
		long entryId,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

	/**
	 * Returns the last e3 entry version in the ordered set where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByEntryId_Last(
			long entryId,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the last e3 entry version in the ordered set where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByEntryId_Last(
		long entryId,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where entryId = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param entryId the entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	public E3EntryVersion[] findByEntryId_PrevAndNext(
			long e3EntryVersionId, long entryId,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Removes all the e3 entry versions where entryId = &#63; from the database.
	 *
	 * @param entryId the entry ID
	 */
	public void removeByEntryId(long entryId);

	/**
	 * Returns the number of e3 entry versions where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @return the number of matching e3 entry versions
	 */
	public int countByEntryId(long entryId);

	/**
	 * Returns the e3 entry version where entryId = &#63; and version = &#63; or throws a <code>NoSuchE3EntryVersionException</code> if it could not be found.
	 *
	 * @param entryId the entry ID
	 * @param version the version
	 * @return the matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByEntryId_Version(long entryId, int version)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the e3 entry version where entryId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param entryId the entry ID
	 * @param version the version
	 * @return the matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByEntryId_Version(long entryId, int version);

	/**
	 * Returns the e3 entry version where entryId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param entryId the entry ID
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByEntryId_Version(
		long entryId, int version, boolean useFinderCache);

	/**
	 * Removes the e3 entry version where entryId = &#63; and version = &#63; from the database.
	 *
	 * @param entryId the entry ID
	 * @param version the version
	 * @return the e3 entry version that was removed
	 */
	public E3EntryVersion removeByEntryId_Version(long entryId, int version)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the number of e3 entry versions where entryId = &#63; and version = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	public int countByEntryId_Version(long entryId, int version);

	/**
	 * Returns all the e3 entry versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e3 entry versions
	 */
	public java.util.List<E3EntryVersion> findByUuid(String uuid);

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
	public java.util.List<E3EntryVersion> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<E3EntryVersion> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public java.util.List<E3EntryVersion> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where uuid = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	public E3EntryVersion[] findByUuid_PrevAndNext(
			long e3EntryVersionId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Removes all the e3 entry versions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of e3 entry versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e3 entry versions
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the e3 entry versions where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the matching e3 entry versions
	 */
	public java.util.List<E3EntryVersion> findByUuid_Version(
		String uuid, int version);

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
	public java.util.List<E3EntryVersion> findByUuid_Version(
		String uuid, int version, int start, int end);

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
	public java.util.List<E3EntryVersion> findByUuid_Version(
		String uuid, int version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public java.util.List<E3EntryVersion> findByUuid_Version(
		String uuid, int version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByUuid_Version_First(
			String uuid, int version,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByUuid_Version_First(
		String uuid, int version,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByUuid_Version_Last(
			String uuid, int version,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByUuid_Version_Last(
		String uuid, int version,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public E3EntryVersion[] findByUuid_Version_PrevAndNext(
			long e3EntryVersionId, String uuid, int version,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Removes all the e3 entry versions where uuid = &#63; and version = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 */
	public void removeByUuid_Version(String uuid, int version);

	/**
	 * Returns the number of e3 entry versions where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	public int countByUuid_Version(String uuid, int version);

	/**
	 * Returns all the e3 entry versions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e3 entry versions
	 */
	public java.util.List<E3EntryVersion> findByUUID_G(
		String uuid, long groupId);

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
	public java.util.List<E3EntryVersion> findByUUID_G(
		String uuid, long groupId, int start, int end);

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
	public java.util.List<E3EntryVersion> findByUUID_G(
		String uuid, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public java.util.List<E3EntryVersion> findByUUID_G(
		String uuid, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByUUID_G_First(
			String uuid, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByUUID_G_First(
		String uuid, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByUUID_G_Last(
			String uuid, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByUUID_G_Last(
		String uuid, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public E3EntryVersion[] findByUUID_G_PrevAndNext(
			long e3EntryVersionId, String uuid, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Removes all the e3 entry versions where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 */
	public void removeByUUID_G(String uuid, long groupId);

	/**
	 * Returns the number of e3 entry versions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e3 entry versions
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns the e3 entry version where uuid = &#63; and groupId = &#63; and version = &#63; or throws a <code>NoSuchE3EntryVersionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByUUID_G_Version(
			String uuid, long groupId, int version)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the e3 entry version where uuid = &#63; and groupId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByUUID_G_Version(
		String uuid, long groupId, int version);

	/**
	 * Returns the e3 entry version where uuid = &#63; and groupId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByUUID_G_Version(
		String uuid, long groupId, int version, boolean useFinderCache);

	/**
	 * Removes the e3 entry version where uuid = &#63; and groupId = &#63; and version = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the e3 entry version that was removed
	 */
	public E3EntryVersion removeByUUID_G_Version(
			String uuid, long groupId, int version)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the number of e3 entry versions where uuid = &#63; and groupId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	public int countByUUID_G_Version(String uuid, long groupId, int version);

	/**
	 * Returns all the e3 entry versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e3 entry versions
	 */
	public java.util.List<E3EntryVersion> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<E3EntryVersion> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<E3EntryVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public java.util.List<E3EntryVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public E3EntryVersion[] findByUuid_C_PrevAndNext(
			long e3EntryVersionId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Removes all the e3 entry versions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of e3 entry versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e3 entry versions
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the e3 entry versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @return the matching e3 entry versions
	 */
	public java.util.List<E3EntryVersion> findByUuid_C_Version(
		String uuid, long companyId, int version);

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
	public java.util.List<E3EntryVersion> findByUuid_C_Version(
		String uuid, long companyId, int version, int start, int end);

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
	public java.util.List<E3EntryVersion> findByUuid_C_Version(
		String uuid, long companyId, int version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public java.util.List<E3EntryVersion> findByUuid_C_Version(
		String uuid, long companyId, int version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator,
		boolean useFinderCache);

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
	public E3EntryVersion findByUuid_C_Version_First(
			String uuid, long companyId, int version,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByUuid_C_Version_First(
		String uuid, long companyId, int version,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public E3EntryVersion findByUuid_C_Version_Last(
			String uuid, long companyId, int version,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByUuid_C_Version_Last(
		String uuid, long companyId, int version,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public E3EntryVersion[] findByUuid_C_Version_PrevAndNext(
			long e3EntryVersionId, String uuid, long companyId, int version,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Removes all the e3 entry versions where uuid = &#63; and companyId = &#63; and version = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 */
	public void removeByUuid_C_Version(
		String uuid, long companyId, int version);

	/**
	 * Returns the number of e3 entry versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	public int countByUuid_C_Version(String uuid, long companyId, int version);

	/**
	 * Returns all the e3 entry versions where xid = &#63;.
	 *
	 * @param xid the xid
	 * @return the matching e3 entry versions
	 */
	public java.util.List<E3EntryVersion> findByxid(String xid);

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
	public java.util.List<E3EntryVersion> findByxid(
		String xid, int start, int end);

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
	public java.util.List<E3EntryVersion> findByxid(
		String xid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public java.util.List<E3EntryVersion> findByxid(
		String xid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first e3 entry version in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByxid_First(
			String xid,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the first e3 entry version in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByxid_First(
		String xid,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

	/**
	 * Returns the last e3 entry version in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByxid_Last(
			String xid,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the last e3 entry version in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByxid_Last(
		String xid,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where xid = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	public E3EntryVersion[] findByxid_PrevAndNext(
			long e3EntryVersionId, String xid,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Removes all the e3 entry versions where xid = &#63; from the database.
	 *
	 * @param xid the xid
	 */
	public void removeByxid(String xid);

	/**
	 * Returns the number of e3 entry versions where xid = &#63;.
	 *
	 * @param xid the xid
	 * @return the number of matching e3 entry versions
	 */
	public int countByxid(String xid);

	/**
	 * Returns all the e3 entry versions where xid = &#63; and version = &#63;.
	 *
	 * @param xid the xid
	 * @param version the version
	 * @return the matching e3 entry versions
	 */
	public java.util.List<E3EntryVersion> findByxid_Version(
		String xid, int version);

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
	public java.util.List<E3EntryVersion> findByxid_Version(
		String xid, int version, int start, int end);

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
	public java.util.List<E3EntryVersion> findByxid_Version(
		String xid, int version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public java.util.List<E3EntryVersion> findByxid_Version(
		String xid, int version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first e3 entry version in the ordered set where xid = &#63; and version = &#63;.
	 *
	 * @param xid the xid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByxid_Version_First(
			String xid, int version,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the first e3 entry version in the ordered set where xid = &#63; and version = &#63;.
	 *
	 * @param xid the xid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByxid_Version_First(
		String xid, int version,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

	/**
	 * Returns the last e3 entry version in the ordered set where xid = &#63; and version = &#63;.
	 *
	 * @param xid the xid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByxid_Version_Last(
			String xid, int version,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the last e3 entry version in the ordered set where xid = &#63; and version = &#63;.
	 *
	 * @param xid the xid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByxid_Version_Last(
		String xid, int version,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public E3EntryVersion[] findByxid_Version_PrevAndNext(
			long e3EntryVersionId, String xid, int version,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Removes all the e3 entry versions where xid = &#63; and version = &#63; from the database.
	 *
	 * @param xid the xid
	 * @param version the version
	 */
	public void removeByxid_Version(String xid, int version);

	/**
	 * Returns the number of e3 entry versions where xid = &#63; and version = &#63;.
	 *
	 * @param xid the xid
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	public int countByxid_Version(String xid, int version);

	/**
	 * Returns all the e3 entry versions where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @return the matching e3 entry versions
	 */
	public java.util.List<E3EntryVersion> findByp_f(
		long parentId, String parentField);

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
	public java.util.List<E3EntryVersion> findByp_f(
		long parentId, String parentField, int start, int end);

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
	public java.util.List<E3EntryVersion> findByp_f(
		long parentId, String parentField, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public java.util.List<E3EntryVersion> findByp_f(
		long parentId, String parentField, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first e3 entry version in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByp_f_First(
			long parentId, String parentField,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the first e3 entry version in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByp_f_First(
		long parentId, String parentField,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

	/**
	 * Returns the last e3 entry version in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByp_f_Last(
			long parentId, String parentField,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the last e3 entry version in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByp_f_Last(
		long parentId, String parentField,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public E3EntryVersion[] findByp_f_PrevAndNext(
			long e3EntryVersionId, long parentId, String parentField,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Removes all the e3 entry versions where parentId = &#63; and parentField = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 */
	public void removeByp_f(long parentId, String parentField);

	/**
	 * Returns the number of e3 entry versions where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @return the number of matching e3 entry versions
	 */
	public int countByp_f(long parentId, String parentField);

	/**
	 * Returns all the e3 entry versions where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @return the matching e3 entry versions
	 */
	public java.util.List<E3EntryVersion> findByp_f_Version(
		long parentId, String parentField, int version);

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
	public java.util.List<E3EntryVersion> findByp_f_Version(
		long parentId, String parentField, int version, int start, int end);

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
	public java.util.List<E3EntryVersion> findByp_f_Version(
		long parentId, String parentField, int version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public java.util.List<E3EntryVersion> findByp_f_Version(
		long parentId, String parentField, int version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator,
		boolean useFinderCache);

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
	public E3EntryVersion findByp_f_Version_First(
			long parentId, String parentField, int version,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the first e3 entry version in the ordered set where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByp_f_Version_First(
		long parentId, String parentField, int version,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public E3EntryVersion findByp_f_Version_Last(
			long parentId, String parentField, int version,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the last e3 entry version in the ordered set where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByp_f_Version_Last(
		long parentId, String parentField, int version,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public E3EntryVersion[] findByp_f_Version_PrevAndNext(
			long e3EntryVersionId, long parentId, String parentField,
			int version,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Removes all the e3 entry versions where parentId = &#63; and parentField = &#63; and version = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 */
	public void removeByp_f_Version(
		long parentId, String parentField, int version);

	/**
	 * Returns the number of e3 entry versions where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	public int countByp_f_Version(
		long parentId, String parentField, int version);

	/**
	 * Returns all the e3 entry versions where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching e3 entry versions
	 */
	public java.util.List<E3EntryVersion> findByStatus(long status);

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
	public java.util.List<E3EntryVersion> findByStatus(
		long status, int start, int end);

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
	public java.util.List<E3EntryVersion> findByStatus(
		long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public java.util.List<E3EntryVersion> findByStatus(
		long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first e3 entry version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByStatus_First(
			long status,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the first e3 entry version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByStatus_First(
		long status,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

	/**
	 * Returns the last e3 entry version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByStatus_Last(
			long status,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the last e3 entry version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByStatus_Last(
		long status,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where status = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	public E3EntryVersion[] findByStatus_PrevAndNext(
			long e3EntryVersionId, long status,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Removes all the e3 entry versions where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(long status);

	/**
	 * Returns the number of e3 entry versions where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching e3 entry versions
	 */
	public int countByStatus(long status);

	/**
	 * Returns all the e3 entry versions where status = &#63; and version = &#63;.
	 *
	 * @param status the status
	 * @param version the version
	 * @return the matching e3 entry versions
	 */
	public java.util.List<E3EntryVersion> findByStatus_Version(
		long status, int version);

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
	public java.util.List<E3EntryVersion> findByStatus_Version(
		long status, int version, int start, int end);

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
	public java.util.List<E3EntryVersion> findByStatus_Version(
		long status, int version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public java.util.List<E3EntryVersion> findByStatus_Version(
		long status, int version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first e3 entry version in the ordered set where status = &#63; and version = &#63;.
	 *
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByStatus_Version_First(
			long status, int version,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the first e3 entry version in the ordered set where status = &#63; and version = &#63;.
	 *
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByStatus_Version_First(
		long status, int version,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

	/**
	 * Returns the last e3 entry version in the ordered set where status = &#63; and version = &#63;.
	 *
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByStatus_Version_Last(
			long status, int version,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the last e3 entry version in the ordered set where status = &#63; and version = &#63;.
	 *
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByStatus_Version_Last(
		long status, int version,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public E3EntryVersion[] findByStatus_Version_PrevAndNext(
			long e3EntryVersionId, long status, int version,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Removes all the e3 entry versions where status = &#63; and version = &#63; from the database.
	 *
	 * @param status the status
	 * @param version the version
	 */
	public void removeByStatus_Version(long status, int version);

	/**
	 * Returns the number of e3 entry versions where status = &#63; and version = &#63;.
	 *
	 * @param status the status
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	public int countByStatus_Version(long status, int version);

	/**
	 * Returns all the e3 entry versions where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching e3 entry versions
	 */
	public java.util.List<E3EntryVersion> findByG_S(long groupId, long status);

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
	public java.util.List<E3EntryVersion> findByG_S(
		long groupId, long status, int start, int end);

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
	public java.util.List<E3EntryVersion> findByG_S(
		long groupId, long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public java.util.List<E3EntryVersion> findByG_S(
		long groupId, long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first e3 entry version in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByG_S_First(
			long groupId, long status,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the first e3 entry version in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByG_S_First(
		long groupId, long status,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

	/**
	 * Returns the last e3 entry version in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	public E3EntryVersion findByG_S_Last(
			long groupId, long status,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the last e3 entry version in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByG_S_Last(
		long groupId, long status,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public E3EntryVersion[] findByG_S_PrevAndNext(
			long e3EntryVersionId, long groupId, long status,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Removes all the e3 entry versions where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, long status);

	/**
	 * Returns the number of e3 entry versions where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching e3 entry versions
	 */
	public int countByG_S(long groupId, long status);

	/**
	 * Returns all the e3 entry versions where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @return the matching e3 entry versions
	 */
	public java.util.List<E3EntryVersion> findByG_S_Version(
		long groupId, long status, int version);

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
	public java.util.List<E3EntryVersion> findByG_S_Version(
		long groupId, long status, int version, int start, int end);

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
	public java.util.List<E3EntryVersion> findByG_S_Version(
		long groupId, long status, int version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public java.util.List<E3EntryVersion> findByG_S_Version(
		long groupId, long status, int version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator,
		boolean useFinderCache);

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
	public E3EntryVersion findByG_S_Version_First(
			long groupId, long status, int version,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the first e3 entry version in the ordered set where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByG_S_Version_First(
		long groupId, long status, int version,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public E3EntryVersion findByG_S_Version_Last(
			long groupId, long status, int version,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the last e3 entry version in the ordered set where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	public E3EntryVersion fetchByG_S_Version_Last(
		long groupId, long status, int version,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public E3EntryVersion[] findByG_S_Version_PrevAndNext(
			long e3EntryVersionId, long groupId, long status, int version,
			com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
				orderByComparator)
		throws NoSuchE3EntryVersionException;

	/**
	 * Removes all the e3 entry versions where groupId = &#63; and status = &#63; and version = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 */
	public void removeByG_S_Version(long groupId, long status, int version);

	/**
	 * Returns the number of e3 entry versions where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	public int countByG_S_Version(long groupId, long status, int version);

	/**
	 * Caches the e3 entry version in the entity cache if it is enabled.
	 *
	 * @param e3EntryVersion the e3 entry version
	 */
	public void cacheResult(E3EntryVersion e3EntryVersion);

	/**
	 * Caches the e3 entry versions in the entity cache if it is enabled.
	 *
	 * @param e3EntryVersions the e3 entry versions
	 */
	public void cacheResult(java.util.List<E3EntryVersion> e3EntryVersions);

	/**
	 * Creates a new e3 entry version with the primary key. Does not add the e3 entry version to the database.
	 *
	 * @param e3EntryVersionId the primary key for the new e3 entry version
	 * @return the new e3 entry version
	 */
	public E3EntryVersion create(long e3EntryVersionId);

	/**
	 * Removes the e3 entry version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param e3EntryVersionId the primary key of the e3 entry version
	 * @return the e3 entry version that was removed
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	public E3EntryVersion remove(long e3EntryVersionId)
		throws NoSuchE3EntryVersionException;

	public E3EntryVersion updateImpl(E3EntryVersion e3EntryVersion);

	/**
	 * Returns the e3 entry version with the primary key or throws a <code>NoSuchE3EntryVersionException</code> if it could not be found.
	 *
	 * @param e3EntryVersionId the primary key of the e3 entry version
	 * @return the e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	public E3EntryVersion findByPrimaryKey(long e3EntryVersionId)
		throws NoSuchE3EntryVersionException;

	/**
	 * Returns the e3 entry version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param e3EntryVersionId the primary key of the e3 entry version
	 * @return the e3 entry version, or <code>null</code> if a e3 entry version with the primary key could not be found
	 */
	public E3EntryVersion fetchByPrimaryKey(long e3EntryVersionId);

	/**
	 * Returns all the e3 entry versions.
	 *
	 * @return the e3 entry versions
	 */
	public java.util.List<E3EntryVersion> findAll();

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
	public java.util.List<E3EntryVersion> findAll(int start, int end);

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
	public java.util.List<E3EntryVersion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator);

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
	public java.util.List<E3EntryVersion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<E3EntryVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the e3 entry versions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of e3 entry versions.
	 *
	 * @return the number of e3 entry versions
	 */
	public int countAll();

}