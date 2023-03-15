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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import cz.csob.ency.modules.apps.meta.cds.exception.NoSuchSystemEntryException;
import cz.csob.ency.modules.apps.meta.cds.model.SystemEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the system entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author "Miroslav Čermák"
 * @see SystemEntryUtil
 * @generated
 */
@ProviderType
public interface SystemEntryPersistence extends BasePersistence<SystemEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SystemEntryUtil} to access the system entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the system entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching system entries
	 */
	public java.util.List<SystemEntry> findByUuid(String uuid);

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
	public java.util.List<SystemEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<SystemEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first system entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the first system entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the last system entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the last system entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where uuid = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public SystemEntry[] findByUuid_PrevAndNext(
			long systemEntryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Removes all the system entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of system entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching system entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the system entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSystemEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the system entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the system entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the system entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the system entry that was removed
	 */
	public SystemEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the number of system entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching system entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the system entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching system entries
	 */
	public java.util.List<SystemEntry> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<SystemEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<SystemEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first system entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the first system entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the last system entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the last system entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public SystemEntry[] findByUuid_C_PrevAndNext(
			long systemEntryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Removes all the system entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of system entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching system entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the system entries where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching system entries
	 */
	public java.util.List<SystemEntry> findByC_S(long companyId, int status);

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
	public java.util.List<SystemEntry> findByC_S(
		long companyId, int status, int start, int end);

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
	public java.util.List<SystemEntry> findByC_S(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByC_S(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first system entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByC_S_First(
			long companyId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the first system entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByC_S_First(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the last system entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByC_S_Last(
			long companyId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the last system entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByC_S_Last(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public SystemEntry[] findByC_S_PrevAndNext(
			long systemEntryId, long companyId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

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
	public java.util.List<SystemEntry> findByC_S(
		long companyId, int[] statuses);

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
	public java.util.List<SystemEntry> findByC_S(
		long companyId, int[] statuses, int start, int end);

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
	public java.util.List<SystemEntry> findByC_S(
		long companyId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByC_S(
		long companyId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the system entries where companyId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 */
	public void removeByC_S(long companyId, int status);

	/**
	 * Returns the number of system entries where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching system entries
	 */
	public int countByC_S(long companyId, int status);

	/**
	 * Returns the number of system entries where companyId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @return the number of matching system entries
	 */
	public int countByC_S(long companyId, int[] statuses);

	/**
	 * Returns all the system entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching system entries
	 */
	public java.util.List<SystemEntry> findByG_S(long groupId, int status);

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
	public java.util.List<SystemEntry> findByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<SystemEntry> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first system entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the first system entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the last system entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the last system entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public SystemEntry[] findByG_S_PrevAndNext(
			long systemEntryId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns all the system entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching system entries that the user has permission to view
	 */
	public java.util.List<SystemEntry> filterFindByG_S(
		long groupId, int status);

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
	public java.util.List<SystemEntry> filterFindByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<SystemEntry> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public SystemEntry[] filterFindByG_S_PrevAndNext(
			long systemEntryId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns all the system entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching system entries that the user has permission to view
	 */
	public java.util.List<SystemEntry> filterFindByG_S(
		long groupId, int[] statuses);

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
	public java.util.List<SystemEntry> filterFindByG_S(
		long groupId, int[] statuses, int start, int end);

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
	public java.util.List<SystemEntry> filterFindByG_S(
		long groupId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByG_S(long groupId, int[] statuses);

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
	public java.util.List<SystemEntry> findByG_S(
		long groupId, int[] statuses, int start, int end);

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
	public java.util.List<SystemEntry> findByG_S(
		long groupId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByG_S(
		long groupId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the system entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of system entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching system entries
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns the number of system entries where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching system entries
	 */
	public int countByG_S(long groupId, int[] statuses);

	/**
	 * Returns the number of system entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching system entries that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int status);

	/**
	 * Returns the number of system entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching system entries that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int[] statuses);

	/**
	 * Returns all the system entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching system entries
	 */
	public java.util.List<SystemEntry> findByC_U_S(
		long companyId, long userId, int status);

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
	public java.util.List<SystemEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end);

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
	public java.util.List<SystemEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

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
	public SystemEntry findByC_U_S_First(
			long companyId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the first system entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByC_U_S_First(
		long companyId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public SystemEntry findByC_U_S_Last(
			long companyId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the last system entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByC_U_S_Last(
		long companyId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public SystemEntry[] findByC_U_S_PrevAndNext(
			long systemEntryId, long companyId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

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
	public java.util.List<SystemEntry> findByC_U_S(
		long companyId, long userId, int[] statuses);

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
	public java.util.List<SystemEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end);

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
	public java.util.List<SystemEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the system entries where companyId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByC_U_S(long companyId, long userId, int status);

	/**
	 * Returns the number of system entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching system entries
	 */
	public int countByC_U_S(long companyId, long userId, int status);

	/**
	 * Returns the number of system entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching system entries
	 */
	public int countByC_U_S(long companyId, long userId, int[] statuses);

	/**
	 * Returns all the system entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching system entries
	 */
	public java.util.List<SystemEntry> findByG_U_S(
		long groupId, long userId, int status);

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
	public java.util.List<SystemEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end);

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
	public java.util.List<SystemEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

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
	public SystemEntry findByG_U_S_First(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the first system entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByG_U_S_First(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public SystemEntry findByG_U_S_Last(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the last system entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByG_U_S_Last(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public SystemEntry[] findByG_U_S_PrevAndNext(
			long systemEntryId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns all the system entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching system entries that the user has permission to view
	 */
	public java.util.List<SystemEntry> filterFindByG_U_S(
		long groupId, long userId, int status);

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
	public java.util.List<SystemEntry> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end);

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
	public java.util.List<SystemEntry> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public SystemEntry[] filterFindByG_U_S_PrevAndNext(
			long systemEntryId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns all the system entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching system entries that the user has permission to view
	 */
	public java.util.List<SystemEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses);

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
	public java.util.List<SystemEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end);

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
	public java.util.List<SystemEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByG_U_S(
		long groupId, long userId, int[] statuses);

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
	public java.util.List<SystemEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end);

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
	public java.util.List<SystemEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the system entries where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of system entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching system entries
	 */
	public int countByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of system entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching system entries
	 */
	public int countByG_U_S(long groupId, long userId, int[] statuses);

	/**
	 * Returns the number of system entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching system entries that the user has permission to view
	 */
	public int filterCountByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of system entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching system entries that the user has permission to view
	 */
	public int filterCountByG_U_S(long groupId, long userId, int[] statuses);

	/**
	 * Returns all the system entries where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching system entries
	 */
	public java.util.List<SystemEntry> findByU_S(long userId, int status);

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
	public java.util.List<SystemEntry> findByU_S(
		long userId, int status, int start, int end);

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
	public java.util.List<SystemEntry> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first system entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByU_S_First(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the first system entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByU_S_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the last system entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByU_S_Last(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the last system entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByU_S_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public SystemEntry[] findByU_S_PrevAndNext(
			long systemEntryId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

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
	public java.util.List<SystemEntry> findByU_S(long userId, int[] statuses);

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
	public java.util.List<SystemEntry> findByU_S(
		long userId, int[] statuses, int start, int end);

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
	public java.util.List<SystemEntry> findByU_S(
		long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByU_S(
		long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the system entries where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByU_S(long userId, int status);

	/**
	 * Returns the number of system entries where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching system entries
	 */
	public int countByU_S(long userId, int status);

	/**
	 * Returns the number of system entries where userId = &#63; and status = any &#63;.
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching system entries
	 */
	public int countByU_S(long userId, int[] statuses);

	/**
	 * Returns all the system entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching system entries
	 */
	public java.util.List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status);

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
	public java.util.List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end);

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
	public java.util.List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

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
	public SystemEntry findByG_UT_ST_First(
			long groupId, String urlTitle, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the first system entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByG_UT_ST_First(
		long groupId, String urlTitle, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public SystemEntry findByG_UT_ST_Last(
			long groupId, String urlTitle, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the last system entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByG_UT_ST_Last(
		long groupId, String urlTitle, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public SystemEntry[] findByG_UT_ST_PrevAndNext(
			long systemEntryId, long groupId, String urlTitle, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns all the system entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching system entries that the user has permission to view
	 */
	public java.util.List<SystemEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status);

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
	public java.util.List<SystemEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end);

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
	public java.util.List<SystemEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public SystemEntry[] filterFindByG_UT_ST_PrevAndNext(
			long systemEntryId, long groupId, String urlTitle, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns all the system entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the matching system entries that the user has permission to view
	 */
	public java.util.List<SystemEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses);

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
	public java.util.List<SystemEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end);

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
	public java.util.List<SystemEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses);

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
	public java.util.List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end);

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
	public java.util.List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the system entries where groupId = &#63; and urlTitle = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 */
	public void removeByG_UT_ST(long groupId, String urlTitle, int status);

	/**
	 * Returns the number of system entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching system entries
	 */
	public int countByG_UT_ST(long groupId, String urlTitle, int status);

	/**
	 * Returns the number of system entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching system entries
	 */
	public int countByG_UT_ST(long groupId, String urlTitle, int[] statuses);

	/**
	 * Returns the number of system entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching system entries that the user has permission to view
	 */
	public int filterCountByG_UT_ST(long groupId, String urlTitle, int status);

	/**
	 * Returns the number of system entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching system entries that the user has permission to view
	 */
	public int filterCountByG_UT_ST(
		long groupId, String urlTitle, int[] statuses);

	/**
	 * Returns the system entry where groupId = &#63; and urlTitle = &#63; or throws a <code>NoSuchSystemEntryException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByG_UT(long groupId, String urlTitle)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the system entry where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByG_UT(long groupId, String urlTitle);

	/**
	 * Returns the system entry where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByG_UT(
		long groupId, String urlTitle, boolean useFinderCache);

	/**
	 * Removes the system entry where groupId = &#63; and urlTitle = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the system entry that was removed
	 */
	public SystemEntry removeByG_UT(long groupId, String urlTitle)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the number of system entries where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the number of matching system entries
	 */
	public int countByG_UT(long groupId, String urlTitle);

	/**
	 * Returns the system entry where urlTitle = &#63; or throws a <code>NoSuchSystemEntryException</code> if it could not be found.
	 *
	 * @param urlTitle the url title
	 * @return the matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByURLTitle(String urlTitle)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the system entry where urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param urlTitle the url title
	 * @return the matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByURLTitle(String urlTitle);

	/**
	 * Returns the system entry where urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByURLTitle(String urlTitle, boolean useFinderCache);

	/**
	 * Removes the system entry where urlTitle = &#63; from the database.
	 *
	 * @param urlTitle the url title
	 * @return the system entry that was removed
	 */
	public SystemEntry removeByURLTitle(String urlTitle)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the number of system entries where urlTitle = &#63;.
	 *
	 * @param urlTitle the url title
	 * @return the number of matching system entries
	 */
	public int countByURLTitle(String urlTitle);

	/**
	 * Returns all the system entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching system entries
	 */
	public java.util.List<SystemEntry> findByGroupId(long groupId);

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
	public java.util.List<SystemEntry> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<SystemEntry> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first system entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the first system entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the last system entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the last system entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where groupId = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public SystemEntry[] findByGroupId_PrevAndNext(
			long systemEntryId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns all the system entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching system entries that the user has permission to view
	 */
	public java.util.List<SystemEntry> filterFindByGroupId(long groupId);

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
	public java.util.List<SystemEntry> filterFindByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<SystemEntry> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the system entries before and after the current system entry in the ordered set of system entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public SystemEntry[] filterFindByGroupId_PrevAndNext(
			long systemEntryId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Removes all the system entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of system entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching system entries
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of system entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching system entries that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the system entries where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching system entries
	 */
	public java.util.List<SystemEntry> findByUserIdGroupId(
		long userId, long groupId);

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
	public java.util.List<SystemEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end);

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
	public java.util.List<SystemEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first system entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByUserIdGroupId_First(
			long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the first system entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByUserIdGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the last system entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByUserIdGroupId_Last(
			long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the last system entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByUserIdGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public SystemEntry[] findByUserIdGroupId_PrevAndNext(
			long systemEntryId, long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns all the system entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching system entries that the user has permission to view
	 */
	public java.util.List<SystemEntry> filterFindByUserIdGroupId(
		long userId, long groupId);

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
	public java.util.List<SystemEntry> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end);

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
	public java.util.List<SystemEntry> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public SystemEntry[] filterFindByUserIdGroupId_PrevAndNext(
			long systemEntryId, long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Removes all the system entries where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 */
	public void removeByUserIdGroupId(long userId, long groupId);

	/**
	 * Returns the number of system entries where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching system entries
	 */
	public int countByUserIdGroupId(long userId, long groupId);

	/**
	 * Returns the number of system entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching system entries that the user has permission to view
	 */
	public int filterCountByUserIdGroupId(long userId, long groupId);

	/**
	 * Returns all the system entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching system entries
	 */
	public java.util.List<SystemEntry> findByUserId(long userId);

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
	public java.util.List<SystemEntry> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<SystemEntry> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first system entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the first system entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the last system entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the last system entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where userId = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public SystemEntry[] findByUserId_PrevAndNext(
			long systemEntryId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Removes all the system entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of system entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching system entries
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the system entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching system entries
	 */
	public java.util.List<SystemEntry> findByCompanyId(long companyId);

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
	public java.util.List<SystemEntry> findByCompanyId(
		long companyId, int start, int end);

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
	public java.util.List<SystemEntry> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first system entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByCompanyId_First(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the first system entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the last system entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByCompanyId_Last(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the last system entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where companyId = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public SystemEntry[] findByCompanyId_PrevAndNext(
			long systemEntryId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Removes all the system entries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompanyId(long companyId);

	/**
	 * Returns the number of system entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching system entries
	 */
	public int countByCompanyId(long companyId);

	/**
	 * Returns all the system entries where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @return the matching system entries
	 */
	public java.util.List<SystemEntry> findBySystemEntryId(long systemEntryId);

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
	public java.util.List<SystemEntry> findBySystemEntryId(
		long systemEntryId, int start, int end);

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
	public java.util.List<SystemEntry> findBySystemEntryId(
		long systemEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findBySystemEntryId(
		long systemEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first system entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findBySystemEntryId_First(
			long systemEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the first system entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchBySystemEntryId_First(
		long systemEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the last system entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findBySystemEntryId_Last(
			long systemEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the last system entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchBySystemEntryId_Last(
		long systemEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Removes all the system entries where systemEntryId = &#63; from the database.
	 *
	 * @param systemEntryId the system entry ID
	 */
	public void removeBySystemEntryId(long systemEntryId);

	/**
	 * Returns the number of system entries where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @return the number of matching system entries
	 */
	public int countBySystemEntryId(long systemEntryId);

	/**
	 * Returns all the system entries where systemCode = &#63;.
	 *
	 * @param systemCode the system code
	 * @return the matching system entries
	 */
	public java.util.List<SystemEntry> findBySystemCode(long systemCode);

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
	public java.util.List<SystemEntry> findBySystemCode(
		long systemCode, int start, int end);

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
	public java.util.List<SystemEntry> findBySystemCode(
		long systemCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findBySystemCode(
		long systemCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first system entry in the ordered set where systemCode = &#63;.
	 *
	 * @param systemCode the system code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findBySystemCode_First(
			long systemCode,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the first system entry in the ordered set where systemCode = &#63;.
	 *
	 * @param systemCode the system code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchBySystemCode_First(
		long systemCode,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the last system entry in the ordered set where systemCode = &#63;.
	 *
	 * @param systemCode the system code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findBySystemCode_Last(
			long systemCode,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the last system entry in the ordered set where systemCode = &#63;.
	 *
	 * @param systemCode the system code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchBySystemCode_Last(
		long systemCode,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where systemCode = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param systemCode the system code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public SystemEntry[] findBySystemCode_PrevAndNext(
			long systemEntryId, long systemCode,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Removes all the system entries where systemCode = &#63; from the database.
	 *
	 * @param systemCode the system code
	 */
	public void removeBySystemCode(long systemCode);

	/**
	 * Returns the number of system entries where systemCode = &#63;.
	 *
	 * @param systemCode the system code
	 * @return the number of matching system entries
	 */
	public int countBySystemCode(long systemCode);

	/**
	 * Returns all the system entries where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @return the matching system entries
	 */
	public java.util.List<SystemEntry> findBySystemName(String systemName);

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
	public java.util.List<SystemEntry> findBySystemName(
		String systemName, int start, int end);

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
	public java.util.List<SystemEntry> findBySystemName(
		String systemName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findBySystemName(
		String systemName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first system entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findBySystemName_First(
			String systemName,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the first system entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchBySystemName_First(
		String systemName,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the last system entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findBySystemName_Last(
			String systemName,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the last system entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchBySystemName_Last(
		String systemName,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public SystemEntry[] findBySystemName_PrevAndNext(
			long systemEntryId, String systemName,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Removes all the system entries where systemName = &#63; from the database.
	 *
	 * @param systemName the system name
	 */
	public void removeBySystemName(String systemName);

	/**
	 * Returns the number of system entries where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @return the number of matching system entries
	 */
	public int countBySystemName(String systemName);

	/**
	 * Returns all the system entries where isSlaSigned = &#63;.
	 *
	 * @param isSlaSigned the is sla signed
	 * @return the matching system entries
	 */
	public java.util.List<SystemEntry> findByIsSlaSigned(boolean isSlaSigned);

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
	public java.util.List<SystemEntry> findByIsSlaSigned(
		boolean isSlaSigned, int start, int end);

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
	public java.util.List<SystemEntry> findByIsSlaSigned(
		boolean isSlaSigned, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByIsSlaSigned(
		boolean isSlaSigned, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first system entry in the ordered set where isSlaSigned = &#63;.
	 *
	 * @param isSlaSigned the is sla signed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByIsSlaSigned_First(
			boolean isSlaSigned,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the first system entry in the ordered set where isSlaSigned = &#63;.
	 *
	 * @param isSlaSigned the is sla signed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByIsSlaSigned_First(
		boolean isSlaSigned,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the last system entry in the ordered set where isSlaSigned = &#63;.
	 *
	 * @param isSlaSigned the is sla signed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByIsSlaSigned_Last(
			boolean isSlaSigned,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the last system entry in the ordered set where isSlaSigned = &#63;.
	 *
	 * @param isSlaSigned the is sla signed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByIsSlaSigned_Last(
		boolean isSlaSigned,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where isSlaSigned = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param isSlaSigned the is sla signed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public SystemEntry[] findByIsSlaSigned_PrevAndNext(
			long systemEntryId, boolean isSlaSigned,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Removes all the system entries where isSlaSigned = &#63; from the database.
	 *
	 * @param isSlaSigned the is sla signed
	 */
	public void removeByIsSlaSigned(boolean isSlaSigned);

	/**
	 * Returns the number of system entries where isSlaSigned = &#63;.
	 *
	 * @param isSlaSigned the is sla signed
	 * @return the number of matching system entries
	 */
	public int countByIsSlaSigned(boolean isSlaSigned);

	/**
	 * Returns all the system entries where isSelfBi = &#63;.
	 *
	 * @param isSelfBi the is self bi
	 * @return the matching system entries
	 */
	public java.util.List<SystemEntry> findByIsSelfBi(boolean isSelfBi);

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
	public java.util.List<SystemEntry> findByIsSelfBi(
		boolean isSelfBi, int start, int end);

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
	public java.util.List<SystemEntry> findByIsSelfBi(
		boolean isSelfBi, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByIsSelfBi(
		boolean isSelfBi, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first system entry in the ordered set where isSelfBi = &#63;.
	 *
	 * @param isSelfBi the is self bi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByIsSelfBi_First(
			boolean isSelfBi,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the first system entry in the ordered set where isSelfBi = &#63;.
	 *
	 * @param isSelfBi the is self bi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByIsSelfBi_First(
		boolean isSelfBi,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the last system entry in the ordered set where isSelfBi = &#63;.
	 *
	 * @param isSelfBi the is self bi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByIsSelfBi_Last(
			boolean isSelfBi,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the last system entry in the ordered set where isSelfBi = &#63;.
	 *
	 * @param isSelfBi the is self bi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByIsSelfBi_Last(
		boolean isSelfBi,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where isSelfBi = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param isSelfBi the is self bi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public SystemEntry[] findByIsSelfBi_PrevAndNext(
			long systemEntryId, boolean isSelfBi,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Removes all the system entries where isSelfBi = &#63; from the database.
	 *
	 * @param isSelfBi the is self bi
	 */
	public void removeByIsSelfBi(boolean isSelfBi);

	/**
	 * Returns the number of system entries where isSelfBi = &#63;.
	 *
	 * @param isSelfBi the is self bi
	 * @return the number of matching system entries
	 */
	public int countByIsSelfBi(boolean isSelfBi);

	/**
	 * Returns all the system entries where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the matching system entries
	 */
	public java.util.List<SystemEntry> findByIsActive(boolean isActive);

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
	public java.util.List<SystemEntry> findByIsActive(
		boolean isActive, int start, int end);

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
	public java.util.List<SystemEntry> findByIsActive(
		boolean isActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findByIsActive(
		boolean isActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first system entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByIsActive_First(
			boolean isActive,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the first system entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByIsActive_First(
		boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the last system entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	public SystemEntry findByIsActive_Last(
			boolean isActive,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the last system entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	public SystemEntry fetchByIsActive_Last(
		boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where isActive = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public SystemEntry[] findByIsActive_PrevAndNext(
			long systemEntryId, boolean isActive,
			com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
				orderByComparator)
		throws NoSuchSystemEntryException;

	/**
	 * Removes all the system entries where isActive = &#63; from the database.
	 *
	 * @param isActive the is active
	 */
	public void removeByIsActive(boolean isActive);

	/**
	 * Returns the number of system entries where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the number of matching system entries
	 */
	public int countByIsActive(boolean isActive);

	/**
	 * Caches the system entry in the entity cache if it is enabled.
	 *
	 * @param systemEntry the system entry
	 */
	public void cacheResult(SystemEntry systemEntry);

	/**
	 * Caches the system entries in the entity cache if it is enabled.
	 *
	 * @param systemEntries the system entries
	 */
	public void cacheResult(java.util.List<SystemEntry> systemEntries);

	/**
	 * Creates a new system entry with the primary key. Does not add the system entry to the database.
	 *
	 * @param systemEntryId the primary key for the new system entry
	 * @return the new system entry
	 */
	public SystemEntry create(long systemEntryId);

	/**
	 * Removes the system entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param systemEntryId the primary key of the system entry
	 * @return the system entry that was removed
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public SystemEntry remove(long systemEntryId)
		throws NoSuchSystemEntryException;

	public SystemEntry updateImpl(SystemEntry systemEntry);

	/**
	 * Returns the system entry with the primary key or throws a <code>NoSuchSystemEntryException</code> if it could not be found.
	 *
	 * @param systemEntryId the primary key of the system entry
	 * @return the system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	public SystemEntry findByPrimaryKey(long systemEntryId)
		throws NoSuchSystemEntryException;

	/**
	 * Returns the system entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param systemEntryId the primary key of the system entry
	 * @return the system entry, or <code>null</code> if a system entry with the primary key could not be found
	 */
	public SystemEntry fetchByPrimaryKey(long systemEntryId);

	/**
	 * Returns all the system entries.
	 *
	 * @return the system entries
	 */
	public java.util.List<SystemEntry> findAll();

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
	public java.util.List<SystemEntry> findAll(int start, int end);

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
	public java.util.List<SystemEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator);

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
	public java.util.List<SystemEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SystemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the system entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of system entries.
	 *
	 * @return the number of system entries
	 */
	public int countAll();

}