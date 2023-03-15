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

import cz.csob.ency.modules.apps.meta.cds.exception.NoSuchTableEntryException;
import cz.csob.ency.modules.apps.meta.cds.model.TableEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the table entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author "Miroslav Čermák"
 * @see TableEntryUtil
 * @generated
 */
@ProviderType
public interface TableEntryPersistence extends BasePersistence<TableEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TableEntryUtil} to access the table entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the table entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching table entries
	 */
	public java.util.List<TableEntry> findByUuid(String uuid);

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
	public java.util.List<TableEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<TableEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first table entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the first table entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the last table entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the last table entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where uuid = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public TableEntry[] findByUuid_PrevAndNext(
			long tableEntryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Removes all the table entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of table entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching table entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the table entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTableEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchTableEntryException;

	/**
	 * Returns the table entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the table entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the table entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the table entry that was removed
	 */
	public TableEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchTableEntryException;

	/**
	 * Returns the number of table entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching table entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the table entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching table entries
	 */
	public java.util.List<TableEntry> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<TableEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<TableEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first table entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the first table entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the last table entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the last table entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public TableEntry[] findByUuid_C_PrevAndNext(
			long tableEntryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Removes all the table entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of table entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching table entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the table entries where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching table entries
	 */
	public java.util.List<TableEntry> findByC_S(long companyId, int status);

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
	public java.util.List<TableEntry> findByC_S(
		long companyId, int status, int start, int end);

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
	public java.util.List<TableEntry> findByC_S(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByC_S(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first table entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByC_S_First(
			long companyId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the first table entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByC_S_First(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the last table entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByC_S_Last(
			long companyId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the last table entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByC_S_Last(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public TableEntry[] findByC_S_PrevAndNext(
			long tableEntryId, long companyId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

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
	public java.util.List<TableEntry> findByC_S(long companyId, int[] statuses);

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
	public java.util.List<TableEntry> findByC_S(
		long companyId, int[] statuses, int start, int end);

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
	public java.util.List<TableEntry> findByC_S(
		long companyId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByC_S(
		long companyId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the table entries where companyId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 */
	public void removeByC_S(long companyId, int status);

	/**
	 * Returns the number of table entries where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching table entries
	 */
	public int countByC_S(long companyId, int status);

	/**
	 * Returns the number of table entries where companyId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @return the number of matching table entries
	 */
	public int countByC_S(long companyId, int[] statuses);

	/**
	 * Returns all the table entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching table entries
	 */
	public java.util.List<TableEntry> findByG_S(long groupId, int status);

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
	public java.util.List<TableEntry> findByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<TableEntry> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first table entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the first table entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the last table entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the last table entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public TableEntry[] findByG_S_PrevAndNext(
			long tableEntryId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns all the table entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching table entries that the user has permission to view
	 */
	public java.util.List<TableEntry> filterFindByG_S(long groupId, int status);

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
	public java.util.List<TableEntry> filterFindByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<TableEntry> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public TableEntry[] filterFindByG_S_PrevAndNext(
			long tableEntryId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns all the table entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching table entries that the user has permission to view
	 */
	public java.util.List<TableEntry> filterFindByG_S(
		long groupId, int[] statuses);

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
	public java.util.List<TableEntry> filterFindByG_S(
		long groupId, int[] statuses, int start, int end);

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
	public java.util.List<TableEntry> filterFindByG_S(
		long groupId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByG_S(long groupId, int[] statuses);

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
	public java.util.List<TableEntry> findByG_S(
		long groupId, int[] statuses, int start, int end);

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
	public java.util.List<TableEntry> findByG_S(
		long groupId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByG_S(
		long groupId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the table entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of table entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching table entries
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns the number of table entries where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching table entries
	 */
	public int countByG_S(long groupId, int[] statuses);

	/**
	 * Returns the number of table entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching table entries that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int status);

	/**
	 * Returns the number of table entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching table entries that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int[] statuses);

	/**
	 * Returns all the table entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching table entries
	 */
	public java.util.List<TableEntry> findByC_U_S(
		long companyId, long userId, int status);

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
	public java.util.List<TableEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end);

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
	public java.util.List<TableEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

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
	public TableEntry findByC_U_S_First(
			long companyId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the first table entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByC_U_S_First(
		long companyId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public TableEntry findByC_U_S_Last(
			long companyId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the last table entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByC_U_S_Last(
		long companyId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public TableEntry[] findByC_U_S_PrevAndNext(
			long tableEntryId, long companyId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

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
	public java.util.List<TableEntry> findByC_U_S(
		long companyId, long userId, int[] statuses);

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
	public java.util.List<TableEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end);

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
	public java.util.List<TableEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the table entries where companyId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByC_U_S(long companyId, long userId, int status);

	/**
	 * Returns the number of table entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching table entries
	 */
	public int countByC_U_S(long companyId, long userId, int status);

	/**
	 * Returns the number of table entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching table entries
	 */
	public int countByC_U_S(long companyId, long userId, int[] statuses);

	/**
	 * Returns all the table entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching table entries
	 */
	public java.util.List<TableEntry> findByG_U_S(
		long groupId, long userId, int status);

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
	public java.util.List<TableEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end);

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
	public java.util.List<TableEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

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
	public TableEntry findByG_U_S_First(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the first table entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByG_U_S_First(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public TableEntry findByG_U_S_Last(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the last table entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByG_U_S_Last(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public TableEntry[] findByG_U_S_PrevAndNext(
			long tableEntryId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns all the table entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching table entries that the user has permission to view
	 */
	public java.util.List<TableEntry> filterFindByG_U_S(
		long groupId, long userId, int status);

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
	public java.util.List<TableEntry> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end);

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
	public java.util.List<TableEntry> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public TableEntry[] filterFindByG_U_S_PrevAndNext(
			long tableEntryId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns all the table entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching table entries that the user has permission to view
	 */
	public java.util.List<TableEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses);

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
	public java.util.List<TableEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end);

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
	public java.util.List<TableEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByG_U_S(
		long groupId, long userId, int[] statuses);

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
	public java.util.List<TableEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end);

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
	public java.util.List<TableEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the table entries where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of table entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching table entries
	 */
	public int countByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of table entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching table entries
	 */
	public int countByG_U_S(long groupId, long userId, int[] statuses);

	/**
	 * Returns the number of table entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching table entries that the user has permission to view
	 */
	public int filterCountByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of table entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching table entries that the user has permission to view
	 */
	public int filterCountByG_U_S(long groupId, long userId, int[] statuses);

	/**
	 * Returns all the table entries where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching table entries
	 */
	public java.util.List<TableEntry> findByU_S(long userId, int status);

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
	public java.util.List<TableEntry> findByU_S(
		long userId, int status, int start, int end);

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
	public java.util.List<TableEntry> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first table entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByU_S_First(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the first table entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByU_S_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the last table entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByU_S_Last(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the last table entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByU_S_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public TableEntry[] findByU_S_PrevAndNext(
			long tableEntryId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

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
	public java.util.List<TableEntry> findByU_S(long userId, int[] statuses);

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
	public java.util.List<TableEntry> findByU_S(
		long userId, int[] statuses, int start, int end);

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
	public java.util.List<TableEntry> findByU_S(
		long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByU_S(
		long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the table entries where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByU_S(long userId, int status);

	/**
	 * Returns the number of table entries where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching table entries
	 */
	public int countByU_S(long userId, int status);

	/**
	 * Returns the number of table entries where userId = &#63; and status = any &#63;.
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching table entries
	 */
	public int countByU_S(long userId, int[] statuses);

	/**
	 * Returns all the table entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching table entries
	 */
	public java.util.List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status);

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
	public java.util.List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end);

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
	public java.util.List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

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
	public TableEntry findByG_UT_ST_First(
			long groupId, String urlTitle, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the first table entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByG_UT_ST_First(
		long groupId, String urlTitle, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public TableEntry findByG_UT_ST_Last(
			long groupId, String urlTitle, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the last table entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByG_UT_ST_Last(
		long groupId, String urlTitle, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public TableEntry[] findByG_UT_ST_PrevAndNext(
			long tableEntryId, long groupId, String urlTitle, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns all the table entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching table entries that the user has permission to view
	 */
	public java.util.List<TableEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status);

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
	public java.util.List<TableEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end);

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
	public java.util.List<TableEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public TableEntry[] filterFindByG_UT_ST_PrevAndNext(
			long tableEntryId, long groupId, String urlTitle, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns all the table entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the matching table entries that the user has permission to view
	 */
	public java.util.List<TableEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses);

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
	public java.util.List<TableEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end);

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
	public java.util.List<TableEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses);

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
	public java.util.List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end);

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
	public java.util.List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the table entries where groupId = &#63; and urlTitle = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 */
	public void removeByG_UT_ST(long groupId, String urlTitle, int status);

	/**
	 * Returns the number of table entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching table entries
	 */
	public int countByG_UT_ST(long groupId, String urlTitle, int status);

	/**
	 * Returns the number of table entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching table entries
	 */
	public int countByG_UT_ST(long groupId, String urlTitle, int[] statuses);

	/**
	 * Returns the number of table entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching table entries that the user has permission to view
	 */
	public int filterCountByG_UT_ST(long groupId, String urlTitle, int status);

	/**
	 * Returns the number of table entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching table entries that the user has permission to view
	 */
	public int filterCountByG_UT_ST(
		long groupId, String urlTitle, int[] statuses);

	/**
	 * Returns the table entry where groupId = &#63; and urlTitle = &#63; or throws a <code>NoSuchTableEntryException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByG_UT(long groupId, String urlTitle)
		throws NoSuchTableEntryException;

	/**
	 * Returns the table entry where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByG_UT(long groupId, String urlTitle);

	/**
	 * Returns the table entry where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByG_UT(
		long groupId, String urlTitle, boolean useFinderCache);

	/**
	 * Removes the table entry where groupId = &#63; and urlTitle = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the table entry that was removed
	 */
	public TableEntry removeByG_UT(long groupId, String urlTitle)
		throws NoSuchTableEntryException;

	/**
	 * Returns the number of table entries where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the number of matching table entries
	 */
	public int countByG_UT(long groupId, String urlTitle);

	/**
	 * Returns the table entry where urlTitle = &#63; or throws a <code>NoSuchTableEntryException</code> if it could not be found.
	 *
	 * @param urlTitle the url title
	 * @return the matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByURLTitle(String urlTitle)
		throws NoSuchTableEntryException;

	/**
	 * Returns the table entry where urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param urlTitle the url title
	 * @return the matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByURLTitle(String urlTitle);

	/**
	 * Returns the table entry where urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByURLTitle(String urlTitle, boolean useFinderCache);

	/**
	 * Removes the table entry where urlTitle = &#63; from the database.
	 *
	 * @param urlTitle the url title
	 * @return the table entry that was removed
	 */
	public TableEntry removeByURLTitle(String urlTitle)
		throws NoSuchTableEntryException;

	/**
	 * Returns the number of table entries where urlTitle = &#63;.
	 *
	 * @param urlTitle the url title
	 * @return the number of matching table entries
	 */
	public int countByURLTitle(String urlTitle);

	/**
	 * Returns all the table entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching table entries
	 */
	public java.util.List<TableEntry> findByGroupId(long groupId);

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
	public java.util.List<TableEntry> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<TableEntry> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first table entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the first table entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the last table entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the last table entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where groupId = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public TableEntry[] findByGroupId_PrevAndNext(
			long tableEntryId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns all the table entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching table entries that the user has permission to view
	 */
	public java.util.List<TableEntry> filterFindByGroupId(long groupId);

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
	public java.util.List<TableEntry> filterFindByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<TableEntry> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the table entries before and after the current table entry in the ordered set of table entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public TableEntry[] filterFindByGroupId_PrevAndNext(
			long tableEntryId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Removes all the table entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of table entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching table entries
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of table entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching table entries that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the table entries where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching table entries
	 */
	public java.util.List<TableEntry> findByUserIdGroupId(
		long userId, long groupId);

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
	public java.util.List<TableEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end);

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
	public java.util.List<TableEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first table entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByUserIdGroupId_First(
			long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the first table entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByUserIdGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the last table entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByUserIdGroupId_Last(
			long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the last table entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByUserIdGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public TableEntry[] findByUserIdGroupId_PrevAndNext(
			long tableEntryId, long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns all the table entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching table entries that the user has permission to view
	 */
	public java.util.List<TableEntry> filterFindByUserIdGroupId(
		long userId, long groupId);

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
	public java.util.List<TableEntry> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end);

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
	public java.util.List<TableEntry> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public TableEntry[] filterFindByUserIdGroupId_PrevAndNext(
			long tableEntryId, long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Removes all the table entries where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 */
	public void removeByUserIdGroupId(long userId, long groupId);

	/**
	 * Returns the number of table entries where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching table entries
	 */
	public int countByUserIdGroupId(long userId, long groupId);

	/**
	 * Returns the number of table entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching table entries that the user has permission to view
	 */
	public int filterCountByUserIdGroupId(long userId, long groupId);

	/**
	 * Returns all the table entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching table entries
	 */
	public java.util.List<TableEntry> findByUserId(long userId);

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
	public java.util.List<TableEntry> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<TableEntry> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first table entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the first table entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the last table entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the last table entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where userId = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public TableEntry[] findByUserId_PrevAndNext(
			long tableEntryId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Removes all the table entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of table entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching table entries
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the table entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching table entries
	 */
	public java.util.List<TableEntry> findByCompanyId(long companyId);

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
	public java.util.List<TableEntry> findByCompanyId(
		long companyId, int start, int end);

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
	public java.util.List<TableEntry> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first table entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByCompanyId_First(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the first table entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the last table entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByCompanyId_Last(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the last table entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where companyId = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public TableEntry[] findByCompanyId_PrevAndNext(
			long tableEntryId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Removes all the table entries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompanyId(long companyId);

	/**
	 * Returns the number of table entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching table entries
	 */
	public int countByCompanyId(long companyId);

	/**
	 * Returns all the table entries where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @return the matching table entries
	 */
	public java.util.List<TableEntry> findByTableEntryId(long tableEntryId);

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
	public java.util.List<TableEntry> findByTableEntryId(
		long tableEntryId, int start, int end);

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
	public java.util.List<TableEntry> findByTableEntryId(
		long tableEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByTableEntryId(
		long tableEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first table entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByTableEntryId_First(
			long tableEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the first table entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByTableEntryId_First(
		long tableEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the last table entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByTableEntryId_Last(
			long tableEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the last table entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByTableEntryId_Last(
		long tableEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Removes all the table entries where tableEntryId = &#63; from the database.
	 *
	 * @param tableEntryId the table entry ID
	 */
	public void removeByTableEntryId(long tableEntryId);

	/**
	 * Returns the number of table entries where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @return the number of matching table entries
	 */
	public int countByTableEntryId(long tableEntryId);

	/**
	 * Returns all the table entries where tableName = &#63;.
	 *
	 * @param tableName the table name
	 * @return the matching table entries
	 */
	public java.util.List<TableEntry> findByTableName(String tableName);

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
	public java.util.List<TableEntry> findByTableName(
		String tableName, int start, int end);

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
	public java.util.List<TableEntry> findByTableName(
		String tableName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByTableName(
		String tableName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first table entry in the ordered set where tableName = &#63;.
	 *
	 * @param tableName the table name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByTableName_First(
			String tableName,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the first table entry in the ordered set where tableName = &#63;.
	 *
	 * @param tableName the table name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByTableName_First(
		String tableName,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the last table entry in the ordered set where tableName = &#63;.
	 *
	 * @param tableName the table name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByTableName_Last(
			String tableName,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the last table entry in the ordered set where tableName = &#63;.
	 *
	 * @param tableName the table name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByTableName_Last(
		String tableName,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where tableName = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param tableName the table name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public TableEntry[] findByTableName_PrevAndNext(
			long tableEntryId, String tableName,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Removes all the table entries where tableName = &#63; from the database.
	 *
	 * @param tableName the table name
	 */
	public void removeByTableName(String tableName);

	/**
	 * Returns the number of table entries where tableName = &#63;.
	 *
	 * @param tableName the table name
	 * @return the number of matching table entries
	 */
	public int countByTableName(String tableName);

	/**
	 * Returns all the table entries where tableFullName = &#63;.
	 *
	 * @param tableFullName the table full name
	 * @return the matching table entries
	 */
	public java.util.List<TableEntry> findByTableFullName(String tableFullName);

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
	public java.util.List<TableEntry> findByTableFullName(
		String tableFullName, int start, int end);

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
	public java.util.List<TableEntry> findByTableFullName(
		String tableFullName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByTableFullName(
		String tableFullName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first table entry in the ordered set where tableFullName = &#63;.
	 *
	 * @param tableFullName the table full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByTableFullName_First(
			String tableFullName,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the first table entry in the ordered set where tableFullName = &#63;.
	 *
	 * @param tableFullName the table full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByTableFullName_First(
		String tableFullName,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the last table entry in the ordered set where tableFullName = &#63;.
	 *
	 * @param tableFullName the table full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByTableFullName_Last(
			String tableFullName,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the last table entry in the ordered set where tableFullName = &#63;.
	 *
	 * @param tableFullName the table full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByTableFullName_Last(
		String tableFullName,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where tableFullName = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param tableFullName the table full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public TableEntry[] findByTableFullName_PrevAndNext(
			long tableEntryId, String tableFullName,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Removes all the table entries where tableFullName = &#63; from the database.
	 *
	 * @param tableFullName the table full name
	 */
	public void removeByTableFullName(String tableFullName);

	/**
	 * Returns the number of table entries where tableFullName = &#63;.
	 *
	 * @param tableFullName the table full name
	 * @return the number of matching table entries
	 */
	public int countByTableFullName(String tableFullName);

	/**
	 * Returns all the table entries where tableType = &#63;.
	 *
	 * @param tableType the table type
	 * @return the matching table entries
	 */
	public java.util.List<TableEntry> findByTableType(String tableType);

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
	public java.util.List<TableEntry> findByTableType(
		String tableType, int start, int end);

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
	public java.util.List<TableEntry> findByTableType(
		String tableType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByTableType(
		String tableType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first table entry in the ordered set where tableType = &#63;.
	 *
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByTableType_First(
			String tableType,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the first table entry in the ordered set where tableType = &#63;.
	 *
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByTableType_First(
		String tableType,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the last table entry in the ordered set where tableType = &#63;.
	 *
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByTableType_Last(
			String tableType,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the last table entry in the ordered set where tableType = &#63;.
	 *
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByTableType_Last(
		String tableType,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where tableType = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public TableEntry[] findByTableType_PrevAndNext(
			long tableEntryId, String tableType,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Removes all the table entries where tableType = &#63; from the database.
	 *
	 * @param tableType the table type
	 */
	public void removeByTableType(String tableType);

	/**
	 * Returns the number of table entries where tableType = &#63;.
	 *
	 * @param tableType the table type
	 * @return the number of matching table entries
	 */
	public int countByTableType(String tableType);

	/**
	 * Returns all the table entries where tableDatabase = &#63;.
	 *
	 * @param tableDatabase the table database
	 * @return the matching table entries
	 */
	public java.util.List<TableEntry> findByTableDatabase(String tableDatabase);

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
	public java.util.List<TableEntry> findByTableDatabase(
		String tableDatabase, int start, int end);

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
	public java.util.List<TableEntry> findByTableDatabase(
		String tableDatabase, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByTableDatabase(
		String tableDatabase, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first table entry in the ordered set where tableDatabase = &#63;.
	 *
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByTableDatabase_First(
			String tableDatabase,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the first table entry in the ordered set where tableDatabase = &#63;.
	 *
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByTableDatabase_First(
		String tableDatabase,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the last table entry in the ordered set where tableDatabase = &#63;.
	 *
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByTableDatabase_Last(
			String tableDatabase,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the last table entry in the ordered set where tableDatabase = &#63;.
	 *
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByTableDatabase_Last(
		String tableDatabase,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where tableDatabase = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public TableEntry[] findByTableDatabase_PrevAndNext(
			long tableEntryId, String tableDatabase,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

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
	public java.util.List<TableEntry> findByTableDatabase(
		String[] tableDatabases);

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
	public java.util.List<TableEntry> findByTableDatabase(
		String[] tableDatabases, int start, int end);

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
	public java.util.List<TableEntry> findByTableDatabase(
		String[] tableDatabases, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByTableDatabase(
		String[] tableDatabases, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the table entries where tableDatabase = &#63; from the database.
	 *
	 * @param tableDatabase the table database
	 */
	public void removeByTableDatabase(String tableDatabase);

	/**
	 * Returns the number of table entries where tableDatabase = &#63;.
	 *
	 * @param tableDatabase the table database
	 * @return the number of matching table entries
	 */
	public int countByTableDatabase(String tableDatabase);

	/**
	 * Returns the number of table entries where tableDatabase = any &#63;.
	 *
	 * @param tableDatabases the table databases
	 * @return the number of matching table entries
	 */
	public int countByTableDatabase(String[] tableDatabases);

	/**
	 * Returns all the table entries where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @return the matching table entries
	 */
	public java.util.List<TableEntry> findBySystemEntryId(long systemEntryId);

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
	public java.util.List<TableEntry> findBySystemEntryId(
		long systemEntryId, int start, int end);

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
	public java.util.List<TableEntry> findBySystemEntryId(
		long systemEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findBySystemEntryId(
		long systemEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first table entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findBySystemEntryId_First(
			long systemEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the first table entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchBySystemEntryId_First(
		long systemEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the last table entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findBySystemEntryId_Last(
			long systemEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the last table entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchBySystemEntryId_Last(
		long systemEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public TableEntry[] findBySystemEntryId_PrevAndNext(
			long tableEntryId, long systemEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Removes all the table entries where systemEntryId = &#63; from the database.
	 *
	 * @param systemEntryId the system entry ID
	 */
	public void removeBySystemEntryId(long systemEntryId);

	/**
	 * Returns the number of table entries where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @return the number of matching table entries
	 */
	public int countBySystemEntryId(long systemEntryId);

	/**
	 * Returns all the table entries where description = &#63;.
	 *
	 * @param description the description
	 * @return the matching table entries
	 */
	public java.util.List<TableEntry> findByDescription(String description);

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
	public java.util.List<TableEntry> findByDescription(
		String description, int start, int end);

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
	public java.util.List<TableEntry> findByDescription(
		String description, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByDescription(
		String description, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first table entry in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByDescription_First(
			String description,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the first table entry in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByDescription_First(
		String description,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the last table entry in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByDescription_Last(
			String description,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the last table entry in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByDescription_Last(
		String description,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where description = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public TableEntry[] findByDescription_PrevAndNext(
			long tableEntryId, String description,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Removes all the table entries where description = &#63; from the database.
	 *
	 * @param description the description
	 */
	public void removeByDescription(String description);

	/**
	 * Returns the number of table entries where description = &#63;.
	 *
	 * @param description the description
	 * @return the number of matching table entries
	 */
	public int countByDescription(String description);

	/**
	 * Returns all the table entries where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the matching table entries
	 */
	public java.util.List<TableEntry> findByIsActive(boolean isActive);

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
	public java.util.List<TableEntry> findByIsActive(
		boolean isActive, int start, int end);

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
	public java.util.List<TableEntry> findByIsActive(
		boolean isActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByIsActive(
		boolean isActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first table entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByIsActive_First(
			boolean isActive,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the first table entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByIsActive_First(
		boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the last table entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByIsActive_Last(
			boolean isActive,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the last table entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByIsActive_Last(
		boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where isActive = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public TableEntry[] findByIsActive_PrevAndNext(
			long tableEntryId, boolean isActive,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Removes all the table entries where isActive = &#63; from the database.
	 *
	 * @param isActive the is active
	 */
	public void removeByIsActive(boolean isActive);

	/**
	 * Returns the number of table entries where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the number of matching table entries
	 */
	public int countByIsActive(boolean isActive);

	/**
	 * Returns all the table entries where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @return the matching table entries
	 */
	public java.util.List<TableEntry> findByS_D(
		long systemEntryId, String tableDatabase);

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
	public java.util.List<TableEntry> findByS_D(
		long systemEntryId, String tableDatabase, int start, int end);

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
	public java.util.List<TableEntry> findByS_D(
		long systemEntryId, String tableDatabase, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByS_D(
		long systemEntryId, String tableDatabase, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first table entry in the ordered set where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByS_D_First(
			long systemEntryId, String tableDatabase,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the first table entry in the ordered set where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByS_D_First(
		long systemEntryId, String tableDatabase,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the last table entry in the ordered set where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByS_D_Last(
			long systemEntryId, String tableDatabase,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the last table entry in the ordered set where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByS_D_Last(
		long systemEntryId, String tableDatabase,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public TableEntry[] findByS_D_PrevAndNext(
			long tableEntryId, long systemEntryId, String tableDatabase,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

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
	public java.util.List<TableEntry> findByS_D(
		long systemEntryId, String[] tableDatabases);

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
	public java.util.List<TableEntry> findByS_D(
		long systemEntryId, String[] tableDatabases, int start, int end);

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
	public java.util.List<TableEntry> findByS_D(
		long systemEntryId, String[] tableDatabases, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByS_D(
		long systemEntryId, String[] tableDatabases, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the table entries where systemEntryId = &#63; and tableDatabase = &#63; from the database.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 */
	public void removeByS_D(long systemEntryId, String tableDatabase);

	/**
	 * Returns the number of table entries where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @return the number of matching table entries
	 */
	public int countByS_D(long systemEntryId, String tableDatabase);

	/**
	 * Returns the number of table entries where systemEntryId = &#63; and tableDatabase = any &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabases the table databases
	 * @return the number of matching table entries
	 */
	public int countByS_D(long systemEntryId, String[] tableDatabases);

	/**
	 * Returns all the table entries where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @return the matching table entries
	 */
	public java.util.List<TableEntry> findByS_T(
		long systemEntryId, String tableType);

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
	public java.util.List<TableEntry> findByS_T(
		long systemEntryId, String tableType, int start, int end);

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
	public java.util.List<TableEntry> findByS_T(
		long systemEntryId, String tableType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByS_T(
		long systemEntryId, String tableType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first table entry in the ordered set where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByS_T_First(
			long systemEntryId, String tableType,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the first table entry in the ordered set where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByS_T_First(
		long systemEntryId, String tableType,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

	/**
	 * Returns the last table entry in the ordered set where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	public TableEntry findByS_T_Last(
			long systemEntryId, String tableType,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

	/**
	 * Returns the last table entry in the ordered set where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	public TableEntry fetchByS_T_Last(
		long systemEntryId, String tableType,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public TableEntry[] findByS_T_PrevAndNext(
			long tableEntryId, long systemEntryId, String tableType,
			com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
				orderByComparator)
		throws NoSuchTableEntryException;

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
	public java.util.List<TableEntry> findByS_T(
		long systemEntryId, String[] tableTypes);

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
	public java.util.List<TableEntry> findByS_T(
		long systemEntryId, String[] tableTypes, int start, int end);

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
	public java.util.List<TableEntry> findByS_T(
		long systemEntryId, String[] tableTypes, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findByS_T(
		long systemEntryId, String[] tableTypes, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the table entries where systemEntryId = &#63; and tableType = &#63; from the database.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 */
	public void removeByS_T(long systemEntryId, String tableType);

	/**
	 * Returns the number of table entries where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @return the number of matching table entries
	 */
	public int countByS_T(long systemEntryId, String tableType);

	/**
	 * Returns the number of table entries where systemEntryId = &#63; and tableType = any &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableTypes the table types
	 * @return the number of matching table entries
	 */
	public int countByS_T(long systemEntryId, String[] tableTypes);

	/**
	 * Caches the table entry in the entity cache if it is enabled.
	 *
	 * @param tableEntry the table entry
	 */
	public void cacheResult(TableEntry tableEntry);

	/**
	 * Caches the table entries in the entity cache if it is enabled.
	 *
	 * @param tableEntries the table entries
	 */
	public void cacheResult(java.util.List<TableEntry> tableEntries);

	/**
	 * Creates a new table entry with the primary key. Does not add the table entry to the database.
	 *
	 * @param tableEntryId the primary key for the new table entry
	 * @return the new table entry
	 */
	public TableEntry create(long tableEntryId);

	/**
	 * Removes the table entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tableEntryId the primary key of the table entry
	 * @return the table entry that was removed
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public TableEntry remove(long tableEntryId)
		throws NoSuchTableEntryException;

	public TableEntry updateImpl(TableEntry tableEntry);

	/**
	 * Returns the table entry with the primary key or throws a <code>NoSuchTableEntryException</code> if it could not be found.
	 *
	 * @param tableEntryId the primary key of the table entry
	 * @return the table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	public TableEntry findByPrimaryKey(long tableEntryId)
		throws NoSuchTableEntryException;

	/**
	 * Returns the table entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tableEntryId the primary key of the table entry
	 * @return the table entry, or <code>null</code> if a table entry with the primary key could not be found
	 */
	public TableEntry fetchByPrimaryKey(long tableEntryId);

	/**
	 * Returns all the table entries.
	 *
	 * @return the table entries
	 */
	public java.util.List<TableEntry> findAll();

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
	public java.util.List<TableEntry> findAll(int start, int end);

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
	public java.util.List<TableEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator);

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
	public java.util.List<TableEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the table entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of table entries.
	 *
	 * @return the number of table entries
	 */
	public int countAll();

}