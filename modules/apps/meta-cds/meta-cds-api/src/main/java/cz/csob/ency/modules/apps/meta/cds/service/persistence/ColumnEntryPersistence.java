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

import cz.csob.ency.modules.apps.meta.cds.exception.NoSuchColumnEntryException;
import cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the column entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author "Miroslav Čermák"
 * @see ColumnEntryUtil
 * @generated
 */
@ProviderType
public interface ColumnEntryPersistence extends BasePersistence<ColumnEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ColumnEntryUtil} to access the column entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the column entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching column entries
	 */
	public java.util.List<ColumnEntry> findByUuid(String uuid);

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
	public java.util.List<ColumnEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ColumnEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first column entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the first column entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the last column entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the last column entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where uuid = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public ColumnEntry[] findByUuid_PrevAndNext(
			long columnEntryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Removes all the column entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of column entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching column entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the column entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchColumnEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the column entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the column entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the column entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the column entry that was removed
	 */
	public ColumnEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the number of column entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching column entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the column entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching column entries
	 */
	public java.util.List<ColumnEntry> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<ColumnEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ColumnEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first column entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the first column entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the last column entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the last column entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public ColumnEntry[] findByUuid_C_PrevAndNext(
			long columnEntryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Removes all the column entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of column entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching column entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the column entries where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching column entries
	 */
	public java.util.List<ColumnEntry> findByC_S(long companyId, int status);

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
	public java.util.List<ColumnEntry> findByC_S(
		long companyId, int status, int start, int end);

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
	public java.util.List<ColumnEntry> findByC_S(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByC_S(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first column entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByC_S_First(
			long companyId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the first column entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByC_S_First(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the last column entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByC_S_Last(
			long companyId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the last column entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByC_S_Last(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public ColumnEntry[] findByC_S_PrevAndNext(
			long columnEntryId, long companyId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

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
	public java.util.List<ColumnEntry> findByC_S(
		long companyId, int[] statuses);

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
	public java.util.List<ColumnEntry> findByC_S(
		long companyId, int[] statuses, int start, int end);

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
	public java.util.List<ColumnEntry> findByC_S(
		long companyId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByC_S(
		long companyId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the column entries where companyId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 */
	public void removeByC_S(long companyId, int status);

	/**
	 * Returns the number of column entries where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching column entries
	 */
	public int countByC_S(long companyId, int status);

	/**
	 * Returns the number of column entries where companyId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @return the number of matching column entries
	 */
	public int countByC_S(long companyId, int[] statuses);

	/**
	 * Returns all the column entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching column entries
	 */
	public java.util.List<ColumnEntry> findByG_S(long groupId, int status);

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
	public java.util.List<ColumnEntry> findByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<ColumnEntry> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first column entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the first column entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the last column entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the last column entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public ColumnEntry[] findByG_S_PrevAndNext(
			long columnEntryId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns all the column entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching column entries that the user has permission to view
	 */
	public java.util.List<ColumnEntry> filterFindByG_S(
		long groupId, int status);

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
	public java.util.List<ColumnEntry> filterFindByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<ColumnEntry> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public ColumnEntry[] filterFindByG_S_PrevAndNext(
			long columnEntryId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns all the column entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching column entries that the user has permission to view
	 */
	public java.util.List<ColumnEntry> filterFindByG_S(
		long groupId, int[] statuses);

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
	public java.util.List<ColumnEntry> filterFindByG_S(
		long groupId, int[] statuses, int start, int end);

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
	public java.util.List<ColumnEntry> filterFindByG_S(
		long groupId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByG_S(long groupId, int[] statuses);

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
	public java.util.List<ColumnEntry> findByG_S(
		long groupId, int[] statuses, int start, int end);

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
	public java.util.List<ColumnEntry> findByG_S(
		long groupId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByG_S(
		long groupId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the column entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of column entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching column entries
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns the number of column entries where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching column entries
	 */
	public int countByG_S(long groupId, int[] statuses);

	/**
	 * Returns the number of column entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching column entries that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int status);

	/**
	 * Returns the number of column entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching column entries that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int[] statuses);

	/**
	 * Returns all the column entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching column entries
	 */
	public java.util.List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int status);

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
	public java.util.List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end);

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
	public java.util.List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

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
	public ColumnEntry findByC_U_S_First(
			long companyId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the first column entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByC_U_S_First(
		long companyId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public ColumnEntry findByC_U_S_Last(
			long companyId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the last column entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByC_U_S_Last(
		long companyId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public ColumnEntry[] findByC_U_S_PrevAndNext(
			long columnEntryId, long companyId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

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
	public java.util.List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int[] statuses);

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
	public java.util.List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end);

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
	public java.util.List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the column entries where companyId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByC_U_S(long companyId, long userId, int status);

	/**
	 * Returns the number of column entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching column entries
	 */
	public int countByC_U_S(long companyId, long userId, int status);

	/**
	 * Returns the number of column entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching column entries
	 */
	public int countByC_U_S(long companyId, long userId, int[] statuses);

	/**
	 * Returns all the column entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching column entries
	 */
	public java.util.List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int status);

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
	public java.util.List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end);

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
	public java.util.List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

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
	public ColumnEntry findByG_U_S_First(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the first column entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByG_U_S_First(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public ColumnEntry findByG_U_S_Last(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the last column entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByG_U_S_Last(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public ColumnEntry[] findByG_U_S_PrevAndNext(
			long columnEntryId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns all the column entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching column entries that the user has permission to view
	 */
	public java.util.List<ColumnEntry> filterFindByG_U_S(
		long groupId, long userId, int status);

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
	public java.util.List<ColumnEntry> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end);

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
	public java.util.List<ColumnEntry> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public ColumnEntry[] filterFindByG_U_S_PrevAndNext(
			long columnEntryId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns all the column entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching column entries that the user has permission to view
	 */
	public java.util.List<ColumnEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses);

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
	public java.util.List<ColumnEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end);

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
	public java.util.List<ColumnEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int[] statuses);

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
	public java.util.List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end);

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
	public java.util.List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the column entries where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of column entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching column entries
	 */
	public int countByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of column entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching column entries
	 */
	public int countByG_U_S(long groupId, long userId, int[] statuses);

	/**
	 * Returns the number of column entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching column entries that the user has permission to view
	 */
	public int filterCountByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of column entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching column entries that the user has permission to view
	 */
	public int filterCountByG_U_S(long groupId, long userId, int[] statuses);

	/**
	 * Returns all the column entries where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching column entries
	 */
	public java.util.List<ColumnEntry> findByU_S(long userId, int status);

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
	public java.util.List<ColumnEntry> findByU_S(
		long userId, int status, int start, int end);

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
	public java.util.List<ColumnEntry> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first column entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByU_S_First(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the first column entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByU_S_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the last column entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByU_S_Last(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the last column entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByU_S_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public ColumnEntry[] findByU_S_PrevAndNext(
			long columnEntryId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

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
	public java.util.List<ColumnEntry> findByU_S(long userId, int[] statuses);

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
	public java.util.List<ColumnEntry> findByU_S(
		long userId, int[] statuses, int start, int end);

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
	public java.util.List<ColumnEntry> findByU_S(
		long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByU_S(
		long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the column entries where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByU_S(long userId, int status);

	/**
	 * Returns the number of column entries where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching column entries
	 */
	public int countByU_S(long userId, int status);

	/**
	 * Returns the number of column entries where userId = &#63; and status = any &#63;.
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching column entries
	 */
	public int countByU_S(long userId, int[] statuses);

	/**
	 * Returns all the column entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching column entries
	 */
	public java.util.List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status);

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
	public java.util.List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end);

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
	public java.util.List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

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
	public ColumnEntry findByG_UT_ST_First(
			long groupId, String urlTitle, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the first column entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByG_UT_ST_First(
		long groupId, String urlTitle, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public ColumnEntry findByG_UT_ST_Last(
			long groupId, String urlTitle, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the last column entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByG_UT_ST_Last(
		long groupId, String urlTitle, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public ColumnEntry[] findByG_UT_ST_PrevAndNext(
			long columnEntryId, long groupId, String urlTitle, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns all the column entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching column entries that the user has permission to view
	 */
	public java.util.List<ColumnEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status);

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
	public java.util.List<ColumnEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end);

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
	public java.util.List<ColumnEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public ColumnEntry[] filterFindByG_UT_ST_PrevAndNext(
			long columnEntryId, long groupId, String urlTitle, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns all the column entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the matching column entries that the user has permission to view
	 */
	public java.util.List<ColumnEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses);

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
	public java.util.List<ColumnEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end);

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
	public java.util.List<ColumnEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses);

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
	public java.util.List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end);

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
	public java.util.List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the column entries where groupId = &#63; and urlTitle = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 */
	public void removeByG_UT_ST(long groupId, String urlTitle, int status);

	/**
	 * Returns the number of column entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching column entries
	 */
	public int countByG_UT_ST(long groupId, String urlTitle, int status);

	/**
	 * Returns the number of column entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching column entries
	 */
	public int countByG_UT_ST(long groupId, String urlTitle, int[] statuses);

	/**
	 * Returns the number of column entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching column entries that the user has permission to view
	 */
	public int filterCountByG_UT_ST(long groupId, String urlTitle, int status);

	/**
	 * Returns the number of column entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching column entries that the user has permission to view
	 */
	public int filterCountByG_UT_ST(
		long groupId, String urlTitle, int[] statuses);

	/**
	 * Returns the column entry where groupId = &#63; and urlTitle = &#63; or throws a <code>NoSuchColumnEntryException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByG_UT(long groupId, String urlTitle)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the column entry where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByG_UT(long groupId, String urlTitle);

	/**
	 * Returns the column entry where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByG_UT(
		long groupId, String urlTitle, boolean useFinderCache);

	/**
	 * Removes the column entry where groupId = &#63; and urlTitle = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the column entry that was removed
	 */
	public ColumnEntry removeByG_UT(long groupId, String urlTitle)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the number of column entries where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the number of matching column entries
	 */
	public int countByG_UT(long groupId, String urlTitle);

	/**
	 * Returns the column entry where urlTitle = &#63; or throws a <code>NoSuchColumnEntryException</code> if it could not be found.
	 *
	 * @param urlTitle the url title
	 * @return the matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByURLTitle(String urlTitle)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the column entry where urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param urlTitle the url title
	 * @return the matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByURLTitle(String urlTitle);

	/**
	 * Returns the column entry where urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByURLTitle(String urlTitle, boolean useFinderCache);

	/**
	 * Removes the column entry where urlTitle = &#63; from the database.
	 *
	 * @param urlTitle the url title
	 * @return the column entry that was removed
	 */
	public ColumnEntry removeByURLTitle(String urlTitle)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the number of column entries where urlTitle = &#63;.
	 *
	 * @param urlTitle the url title
	 * @return the number of matching column entries
	 */
	public int countByURLTitle(String urlTitle);

	/**
	 * Returns all the column entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching column entries
	 */
	public java.util.List<ColumnEntry> findByGroupId(long groupId);

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
	public java.util.List<ColumnEntry> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<ColumnEntry> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first column entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the first column entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the last column entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the last column entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where groupId = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public ColumnEntry[] findByGroupId_PrevAndNext(
			long columnEntryId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns all the column entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching column entries that the user has permission to view
	 */
	public java.util.List<ColumnEntry> filterFindByGroupId(long groupId);

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
	public java.util.List<ColumnEntry> filterFindByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<ColumnEntry> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the column entries before and after the current column entry in the ordered set of column entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public ColumnEntry[] filterFindByGroupId_PrevAndNext(
			long columnEntryId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Removes all the column entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of column entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching column entries
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of column entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching column entries that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the column entries where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching column entries
	 */
	public java.util.List<ColumnEntry> findByUserIdGroupId(
		long userId, long groupId);

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
	public java.util.List<ColumnEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end);

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
	public java.util.List<ColumnEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first column entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByUserIdGroupId_First(
			long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the first column entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByUserIdGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the last column entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByUserIdGroupId_Last(
			long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the last column entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByUserIdGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public ColumnEntry[] findByUserIdGroupId_PrevAndNext(
			long columnEntryId, long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns all the column entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching column entries that the user has permission to view
	 */
	public java.util.List<ColumnEntry> filterFindByUserIdGroupId(
		long userId, long groupId);

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
	public java.util.List<ColumnEntry> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end);

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
	public java.util.List<ColumnEntry> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public ColumnEntry[] filterFindByUserIdGroupId_PrevAndNext(
			long columnEntryId, long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Removes all the column entries where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 */
	public void removeByUserIdGroupId(long userId, long groupId);

	/**
	 * Returns the number of column entries where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching column entries
	 */
	public int countByUserIdGroupId(long userId, long groupId);

	/**
	 * Returns the number of column entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching column entries that the user has permission to view
	 */
	public int filterCountByUserIdGroupId(long userId, long groupId);

	/**
	 * Returns all the column entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching column entries
	 */
	public java.util.List<ColumnEntry> findByUserId(long userId);

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
	public java.util.List<ColumnEntry> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<ColumnEntry> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first column entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the first column entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the last column entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the last column entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where userId = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public ColumnEntry[] findByUserId_PrevAndNext(
			long columnEntryId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Removes all the column entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of column entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching column entries
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the column entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching column entries
	 */
	public java.util.List<ColumnEntry> findByCompanyId(long companyId);

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
	public java.util.List<ColumnEntry> findByCompanyId(
		long companyId, int start, int end);

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
	public java.util.List<ColumnEntry> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first column entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByCompanyId_First(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the first column entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the last column entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByCompanyId_Last(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the last column entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where companyId = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public ColumnEntry[] findByCompanyId_PrevAndNext(
			long columnEntryId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Removes all the column entries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompanyId(long companyId);

	/**
	 * Returns the number of column entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching column entries
	 */
	public int countByCompanyId(long companyId);

	/**
	 * Returns all the column entries where columnEntryId = &#63;.
	 *
	 * @param columnEntryId the column entry ID
	 * @return the matching column entries
	 */
	public java.util.List<ColumnEntry> findByColumnEntryId(long columnEntryId);

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
	public java.util.List<ColumnEntry> findByColumnEntryId(
		long columnEntryId, int start, int end);

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
	public java.util.List<ColumnEntry> findByColumnEntryId(
		long columnEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByColumnEntryId(
		long columnEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first column entry in the ordered set where columnEntryId = &#63;.
	 *
	 * @param columnEntryId the column entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByColumnEntryId_First(
			long columnEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the first column entry in the ordered set where columnEntryId = &#63;.
	 *
	 * @param columnEntryId the column entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByColumnEntryId_First(
		long columnEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the last column entry in the ordered set where columnEntryId = &#63;.
	 *
	 * @param columnEntryId the column entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByColumnEntryId_Last(
			long columnEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the last column entry in the ordered set where columnEntryId = &#63;.
	 *
	 * @param columnEntryId the column entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByColumnEntryId_Last(
		long columnEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Removes all the column entries where columnEntryId = &#63; from the database.
	 *
	 * @param columnEntryId the column entry ID
	 */
	public void removeByColumnEntryId(long columnEntryId);

	/**
	 * Returns the number of column entries where columnEntryId = &#63;.
	 *
	 * @param columnEntryId the column entry ID
	 * @return the number of matching column entries
	 */
	public int countByColumnEntryId(long columnEntryId);

	/**
	 * Returns all the column entries where columnType = &#63;.
	 *
	 * @param columnType the column type
	 * @return the matching column entries
	 */
	public java.util.List<ColumnEntry> findByColumnType(String columnType);

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
	public java.util.List<ColumnEntry> findByColumnType(
		String columnType, int start, int end);

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
	public java.util.List<ColumnEntry> findByColumnType(
		String columnType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByColumnType(
		String columnType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first column entry in the ordered set where columnType = &#63;.
	 *
	 * @param columnType the column type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByColumnType_First(
			String columnType,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the first column entry in the ordered set where columnType = &#63;.
	 *
	 * @param columnType the column type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByColumnType_First(
		String columnType,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the last column entry in the ordered set where columnType = &#63;.
	 *
	 * @param columnType the column type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByColumnType_Last(
			String columnType,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the last column entry in the ordered set where columnType = &#63;.
	 *
	 * @param columnType the column type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByColumnType_Last(
		String columnType,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where columnType = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param columnType the column type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public ColumnEntry[] findByColumnType_PrevAndNext(
			long columnEntryId, String columnType,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Removes all the column entries where columnType = &#63; from the database.
	 *
	 * @param columnType the column type
	 */
	public void removeByColumnType(String columnType);

	/**
	 * Returns the number of column entries where columnType = &#63;.
	 *
	 * @param columnType the column type
	 * @return the number of matching column entries
	 */
	public int countByColumnType(String columnType);

	/**
	 * Returns all the column entries where columnName = &#63;.
	 *
	 * @param columnName the column name
	 * @return the matching column entries
	 */
	public java.util.List<ColumnEntry> findByColumnName(String columnName);

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
	public java.util.List<ColumnEntry> findByColumnName(
		String columnName, int start, int end);

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
	public java.util.List<ColumnEntry> findByColumnName(
		String columnName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByColumnName(
		String columnName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first column entry in the ordered set where columnName = &#63;.
	 *
	 * @param columnName the column name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByColumnName_First(
			String columnName,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the first column entry in the ordered set where columnName = &#63;.
	 *
	 * @param columnName the column name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByColumnName_First(
		String columnName,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the last column entry in the ordered set where columnName = &#63;.
	 *
	 * @param columnName the column name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByColumnName_Last(
			String columnName,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the last column entry in the ordered set where columnName = &#63;.
	 *
	 * @param columnName the column name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByColumnName_Last(
		String columnName,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where columnName = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param columnName the column name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public ColumnEntry[] findByColumnName_PrevAndNext(
			long columnEntryId, String columnName,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Removes all the column entries where columnName = &#63; from the database.
	 *
	 * @param columnName the column name
	 */
	public void removeByColumnName(String columnName);

	/**
	 * Returns the number of column entries where columnName = &#63;.
	 *
	 * @param columnName the column name
	 * @return the number of matching column entries
	 */
	public int countByColumnName(String columnName);

	/**
	 * Returns all the column entries where columnFullName = &#63;.
	 *
	 * @param columnFullName the column full name
	 * @return the matching column entries
	 */
	public java.util.List<ColumnEntry> findByColumnFullName(
		String columnFullName);

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
	public java.util.List<ColumnEntry> findByColumnFullName(
		String columnFullName, int start, int end);

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
	public java.util.List<ColumnEntry> findByColumnFullName(
		String columnFullName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByColumnFullName(
		String columnFullName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first column entry in the ordered set where columnFullName = &#63;.
	 *
	 * @param columnFullName the column full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByColumnFullName_First(
			String columnFullName,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the first column entry in the ordered set where columnFullName = &#63;.
	 *
	 * @param columnFullName the column full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByColumnFullName_First(
		String columnFullName,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the last column entry in the ordered set where columnFullName = &#63;.
	 *
	 * @param columnFullName the column full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByColumnFullName_Last(
			String columnFullName,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the last column entry in the ordered set where columnFullName = &#63;.
	 *
	 * @param columnFullName the column full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByColumnFullName_Last(
		String columnFullName,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where columnFullName = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param columnFullName the column full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public ColumnEntry[] findByColumnFullName_PrevAndNext(
			long columnEntryId, String columnFullName,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Removes all the column entries where columnFullName = &#63; from the database.
	 *
	 * @param columnFullName the column full name
	 */
	public void removeByColumnFullName(String columnFullName);

	/**
	 * Returns the number of column entries where columnFullName = &#63;.
	 *
	 * @param columnFullName the column full name
	 * @return the number of matching column entries
	 */
	public int countByColumnFullName(String columnFullName);

	/**
	 * Returns all the column entries where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @return the matching column entries
	 */
	public java.util.List<ColumnEntry> findByTableEntryId(long tableEntryId);

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
	public java.util.List<ColumnEntry> findByTableEntryId(
		long tableEntryId, int start, int end);

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
	public java.util.List<ColumnEntry> findByTableEntryId(
		long tableEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByTableEntryId(
		long tableEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first column entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByTableEntryId_First(
			long tableEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the first column entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByTableEntryId_First(
		long tableEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the last column entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByTableEntryId_Last(
			long tableEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the last column entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByTableEntryId_Last(
		long tableEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public ColumnEntry[] findByTableEntryId_PrevAndNext(
			long columnEntryId, long tableEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Removes all the column entries where tableEntryId = &#63; from the database.
	 *
	 * @param tableEntryId the table entry ID
	 */
	public void removeByTableEntryId(long tableEntryId);

	/**
	 * Returns the number of column entries where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @return the number of matching column entries
	 */
	public int countByTableEntryId(long tableEntryId);

	/**
	 * Returns all the column entries where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @return the matching column entries
	 */
	public java.util.List<ColumnEntry> findBySystemName(String systemName);

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
	public java.util.List<ColumnEntry> findBySystemName(
		String systemName, int start, int end);

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
	public java.util.List<ColumnEntry> findBySystemName(
		String systemName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findBySystemName(
		String systemName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first column entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findBySystemName_First(
			String systemName,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the first column entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchBySystemName_First(
		String systemName,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the last column entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findBySystemName_Last(
			String systemName,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the last column entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchBySystemName_Last(
		String systemName,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where systemName = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public ColumnEntry[] findBySystemName_PrevAndNext(
			long columnEntryId, String systemName,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Removes all the column entries where systemName = &#63; from the database.
	 *
	 * @param systemName the system name
	 */
	public void removeBySystemName(String systemName);

	/**
	 * Returns the number of column entries where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @return the number of matching column entries
	 */
	public int countBySystemName(String systemName);

	/**
	 * Returns all the column entries where databaseName = &#63;.
	 *
	 * @param databaseName the database name
	 * @return the matching column entries
	 */
	public java.util.List<ColumnEntry> findByDatabaseName(String databaseName);

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
	public java.util.List<ColumnEntry> findByDatabaseName(
		String databaseName, int start, int end);

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
	public java.util.List<ColumnEntry> findByDatabaseName(
		String databaseName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByDatabaseName(
		String databaseName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first column entry in the ordered set where databaseName = &#63;.
	 *
	 * @param databaseName the database name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByDatabaseName_First(
			String databaseName,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the first column entry in the ordered set where databaseName = &#63;.
	 *
	 * @param databaseName the database name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByDatabaseName_First(
		String databaseName,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the last column entry in the ordered set where databaseName = &#63;.
	 *
	 * @param databaseName the database name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByDatabaseName_Last(
			String databaseName,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the last column entry in the ordered set where databaseName = &#63;.
	 *
	 * @param databaseName the database name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByDatabaseName_Last(
		String databaseName,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where databaseName = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param databaseName the database name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public ColumnEntry[] findByDatabaseName_PrevAndNext(
			long columnEntryId, String databaseName,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Removes all the column entries where databaseName = &#63; from the database.
	 *
	 * @param databaseName the database name
	 */
	public void removeByDatabaseName(String databaseName);

	/**
	 * Returns the number of column entries where databaseName = &#63;.
	 *
	 * @param databaseName the database name
	 * @return the number of matching column entries
	 */
	public int countByDatabaseName(String databaseName);

	/**
	 * Returns all the column entries where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the matching column entries
	 */
	public java.util.List<ColumnEntry> findByIsActive(boolean isActive);

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
	public java.util.List<ColumnEntry> findByIsActive(
		boolean isActive, int start, int end);

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
	public java.util.List<ColumnEntry> findByIsActive(
		boolean isActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findByIsActive(
		boolean isActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first column entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByIsActive_First(
			boolean isActive,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the first column entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByIsActive_First(
		boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the last column entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	public ColumnEntry findByIsActive_Last(
			boolean isActive,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the last column entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public ColumnEntry fetchByIsActive_Last(
		boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where isActive = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public ColumnEntry[] findByIsActive_PrevAndNext(
			long columnEntryId, boolean isActive,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
				orderByComparator)
		throws NoSuchColumnEntryException;

	/**
	 * Removes all the column entries where isActive = &#63; from the database.
	 *
	 * @param isActive the is active
	 */
	public void removeByIsActive(boolean isActive);

	/**
	 * Returns the number of column entries where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the number of matching column entries
	 */
	public int countByIsActive(boolean isActive);

	/**
	 * Caches the column entry in the entity cache if it is enabled.
	 *
	 * @param columnEntry the column entry
	 */
	public void cacheResult(ColumnEntry columnEntry);

	/**
	 * Caches the column entries in the entity cache if it is enabled.
	 *
	 * @param columnEntries the column entries
	 */
	public void cacheResult(java.util.List<ColumnEntry> columnEntries);

	/**
	 * Creates a new column entry with the primary key. Does not add the column entry to the database.
	 *
	 * @param columnEntryId the primary key for the new column entry
	 * @return the new column entry
	 */
	public ColumnEntry create(long columnEntryId);

	/**
	 * Removes the column entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param columnEntryId the primary key of the column entry
	 * @return the column entry that was removed
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public ColumnEntry remove(long columnEntryId)
		throws NoSuchColumnEntryException;

	public ColumnEntry updateImpl(ColumnEntry columnEntry);

	/**
	 * Returns the column entry with the primary key or throws a <code>NoSuchColumnEntryException</code> if it could not be found.
	 *
	 * @param columnEntryId the primary key of the column entry
	 * @return the column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	public ColumnEntry findByPrimaryKey(long columnEntryId)
		throws NoSuchColumnEntryException;

	/**
	 * Returns the column entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param columnEntryId the primary key of the column entry
	 * @return the column entry, or <code>null</code> if a column entry with the primary key could not be found
	 */
	public ColumnEntry fetchByPrimaryKey(long columnEntryId);

	/**
	 * Returns all the column entries.
	 *
	 * @return the column entries
	 */
	public java.util.List<ColumnEntry> findAll();

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
	public java.util.List<ColumnEntry> findAll(int start, int end);

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
	public java.util.List<ColumnEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator);

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
	public java.util.List<ColumnEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the column entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of column entries.
	 *
	 * @return the number of column entries
	 */
	public int countAll();

}