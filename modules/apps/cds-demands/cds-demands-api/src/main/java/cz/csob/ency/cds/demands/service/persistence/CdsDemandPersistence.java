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

package cz.csob.ency.cds.demands.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException;
import cz.csob.ency.cds.demands.model.CdsDemand;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cds demand service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see CdsDemandUtil
 * @generated
 */
@ProviderType
public interface CdsDemandPersistence extends BasePersistence<CdsDemand> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CdsDemandUtil} to access the cds demand persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cds demands where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cds demands
	 */
	public java.util.List<CdsDemand> findByUuid(String uuid);

	/**
	 * Returns a range of all the cds demands where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public CdsDemand findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public CdsDemand findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	public CdsDemand[] findByUuid_PrevAndNext(
			long demandId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Removes all the cds demands where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of cds demands where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cds demands
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the cds demands where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the matching cds demands
	 */
	public java.util.List<CdsDemand> findByUuid_Head(String uuid, boolean head);

	/**
	 * Returns a range of all the cds demands where uuid = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByUuid_Head(
		String uuid, boolean head, int start, int end);

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByUuid_Head(
		String uuid, boolean head, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByUuid_Head(
		String uuid, boolean head, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public CdsDemand findByUuid_Head_First(
			String uuid, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByUuid_Head_First(
		String uuid, boolean head,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public CdsDemand findByUuid_Head_Last(
			String uuid, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByUuid_Head_Last(
		String uuid, boolean head,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	public CdsDemand[] findByUuid_Head_PrevAndNext(
			long demandId, String uuid, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Removes all the cds demands where uuid = &#63; and head = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 */
	public void removeByUuid_Head(String uuid, boolean head);

	/**
	 * Returns the number of cds demands where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the number of matching cds demands
	 */
	public int countByUuid_Head(String uuid, boolean head);

	/**
	 * Returns all the cds demands where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cds demands
	 */
	public java.util.List<CdsDemand> findByUUID_G(String uuid, long groupId);

	/**
	 * Returns a range of all the cds demands where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByUUID_G(
		String uuid, long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByUUID_G(
		String uuid, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByUUID_G(
		String uuid, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public CdsDemand findByUUID_G_First(
			String uuid, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByUUID_G_First(
		String uuid, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public CdsDemand findByUUID_G_Last(
			String uuid, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByUUID_G_Last(
		String uuid, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	public CdsDemand[] findByUUID_G_PrevAndNext(
			long demandId, String uuid, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Removes all the cds demands where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 */
	public void removeByUUID_G(String uuid, long groupId);

	/**
	 * Returns the number of cds demands where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching cds demands
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns the cds demand where uuid = &#63; and groupId = &#63; and head = &#63; or throws a <code>NoSuchCdsDemandException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public CdsDemand findByUUID_G_Head(String uuid, long groupId, boolean head)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the cds demand where uuid = &#63; and groupId = &#63; and head = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByUUID_G_Head(
		String uuid, long groupId, boolean head);

	/**
	 * Returns the cds demand where uuid = &#63; and groupId = &#63; and head = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByUUID_G_Head(
		String uuid, long groupId, boolean head, boolean useFinderCache);

	/**
	 * Removes the cds demand where uuid = &#63; and groupId = &#63; and head = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the cds demand that was removed
	 */
	public CdsDemand removeByUUID_G_Head(
			String uuid, long groupId, boolean head)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the number of cds demands where uuid = &#63; and groupId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the number of matching cds demands
	 */
	public int countByUUID_G_Head(String uuid, long groupId, boolean head);

	/**
	 * Returns all the cds demands where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching cds demands
	 */
	public java.util.List<CdsDemand> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the cds demands where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public CdsDemand findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public CdsDemand findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	public CdsDemand[] findByUuid_C_PrevAndNext(
			long demandId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Removes all the cds demands where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of cds demands where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching cds demands
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the cds demands where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @return the matching cds demands
	 */
	public java.util.List<CdsDemand> findByUuid_C_Head(
		String uuid, long companyId, boolean head);

	/**
	 * Returns a range of all the cds demands where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByUuid_C_Head(
		String uuid, long companyId, boolean head, int start, int end);

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByUuid_C_Head(
		String uuid, long companyId, boolean head, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByUuid_C_Head(
		String uuid, long companyId, boolean head, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public CdsDemand findByUuid_C_Head_First(
			String uuid, long companyId, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByUuid_C_Head_First(
		String uuid, long companyId, boolean head,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public CdsDemand findByUuid_C_Head_Last(
			String uuid, long companyId, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByUuid_C_Head_Last(
		String uuid, long companyId, boolean head,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	public CdsDemand[] findByUuid_C_Head_PrevAndNext(
			long demandId, String uuid, long companyId, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Removes all the cds demands where uuid = &#63; and companyId = &#63; and head = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 */
	public void removeByUuid_C_Head(String uuid, long companyId, boolean head);

	/**
	 * Returns the number of cds demands where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @return the number of matching cds demands
	 */
	public int countByUuid_C_Head(String uuid, long companyId, boolean head);

	/**
	 * Returns all the cds demands where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching cds demands
	 */
	public java.util.List<CdsDemand> findByUserId(long userId);

	/**
	 * Returns a range of all the cds demands where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByUserId(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the cds demands where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cds demands where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cds demand in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public CdsDemand findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the first cds demand in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns the last cds demand in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public CdsDemand findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the last cds demand in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where userId = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	public CdsDemand[] findByUserId_PrevAndNext(
			long demandId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Removes all the cds demands where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of cds demands where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching cds demands
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the cds demands where userId = &#63; and head = &#63;.
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @return the matching cds demands
	 */
	public java.util.List<CdsDemand> findByUserId_Head(
		long userId, boolean head);

	/**
	 * Returns a range of all the cds demands where userId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByUserId_Head(
		long userId, boolean head, int start, int end);

	/**
	 * Returns an ordered range of all the cds demands where userId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByUserId_Head(
		long userId, boolean head, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cds demands where userId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByUserId_Head(
		long userId, boolean head, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cds demand in the ordered set where userId = &#63; and head = &#63;.
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public CdsDemand findByUserId_Head_First(
			long userId, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the first cds demand in the ordered set where userId = &#63; and head = &#63;.
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByUserId_Head_First(
		long userId, boolean head,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns the last cds demand in the ordered set where userId = &#63; and head = &#63;.
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public CdsDemand findByUserId_Head_Last(
			long userId, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the last cds demand in the ordered set where userId = &#63; and head = &#63;.
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByUserId_Head_Last(
		long userId, boolean head,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where userId = &#63; and head = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param userId the user ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	public CdsDemand[] findByUserId_Head_PrevAndNext(
			long demandId, long userId, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Removes all the cds demands where userId = &#63; and head = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param head the head
	 */
	public void removeByUserId_Head(long userId, boolean head);

	/**
	 * Returns the number of cds demands where userId = &#63; and head = &#63;.
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @return the number of matching cds demands
	 */
	public int countByUserId_Head(long userId, boolean head);

	/**
	 * Returns all the cds demands where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cds demands
	 */
	public java.util.List<CdsDemand> findByXid(String uuid);

	/**
	 * Returns a range of all the cds demands where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByXid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByXid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByXid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public CdsDemand findByXid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByXid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public CdsDemand findByXid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByXid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	public CdsDemand[] findByXid_PrevAndNext(
			long demandId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Removes all the cds demands where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByXid(String uuid);

	/**
	 * Returns the number of cds demands where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cds demands
	 */
	public int countByXid(String uuid);

	/**
	 * Returns the cds demand where uuid = &#63; and head = &#63; or throws a <code>NoSuchCdsDemandException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public CdsDemand findByXid_Head(String uuid, boolean head)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the cds demand where uuid = &#63; and head = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByXid_Head(String uuid, boolean head);

	/**
	 * Returns the cds demand where uuid = &#63; and head = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByXid_Head(
		String uuid, boolean head, boolean useFinderCache);

	/**
	 * Removes the cds demand where uuid = &#63; and head = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the cds demand that was removed
	 */
	public CdsDemand removeByXid_Head(String uuid, boolean head)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the number of cds demands where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the number of matching cds demands
	 */
	public int countByXid_Head(String uuid, boolean head);

	/**
	 * Returns all the cds demands where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @return the matching cds demands
	 */
	public java.util.List<CdsDemand> findByDI(long domainId);

	/**
	 * Returns a range of all the cds demands where domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByDI(
		long domainId, int start, int end);

	/**
	 * Returns an ordered range of all the cds demands where domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByDI(
		long domainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cds demands where domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByDI(
		long domainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cds demand in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public CdsDemand findByDI_First(
			long domainId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the first cds demand in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByDI_First(
		long domainId,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns the last cds demand in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public CdsDemand findByDI_Last(
			long domainId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the last cds demand in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByDI_Last(
		long domainId,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where domainId = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	public CdsDemand[] findByDI_PrevAndNext(
			long demandId, long domainId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Returns all the cds demands where domainId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainIds the domain IDs
	 * @return the matching cds demands
	 */
	public java.util.List<CdsDemand> findByDI(long[] domainIds);

	/**
	 * Returns a range of all the cds demands where domainId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainIds the domain IDs
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByDI(
		long[] domainIds, int start, int end);

	/**
	 * Returns an ordered range of all the cds demands where domainId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainIds the domain IDs
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByDI(
		long[] domainIds, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cds demands where domainId = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByDI(
		long[] domainIds, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cds demands where domainId = &#63; from the database.
	 *
	 * @param domainId the domain ID
	 */
	public void removeByDI(long domainId);

	/**
	 * Returns the number of cds demands where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @return the number of matching cds demands
	 */
	public int countByDI(long domainId);

	/**
	 * Returns the number of cds demands where domainId = any &#63;.
	 *
	 * @param domainIds the domain IDs
	 * @return the number of matching cds demands
	 */
	public int countByDI(long[] domainIds);

	/**
	 * Returns all the cds demands where domainId = &#63; and head = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @return the matching cds demands
	 */
	public java.util.List<CdsDemand> findByDI_Head(long domainId, boolean head);

	/**
	 * Returns a range of all the cds demands where domainId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByDI_Head(
		long domainId, boolean head, int start, int end);

	/**
	 * Returns an ordered range of all the cds demands where domainId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByDI_Head(
		long domainId, boolean head, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cds demands where domainId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByDI_Head(
		long domainId, boolean head, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cds demand in the ordered set where domainId = &#63; and head = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public CdsDemand findByDI_Head_First(
			long domainId, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the first cds demand in the ordered set where domainId = &#63; and head = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByDI_Head_First(
		long domainId, boolean head,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns the last cds demand in the ordered set where domainId = &#63; and head = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public CdsDemand findByDI_Head_Last(
			long domainId, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the last cds demand in the ordered set where domainId = &#63; and head = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByDI_Head_Last(
		long domainId, boolean head,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where domainId = &#63; and head = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param domainId the domain ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	public CdsDemand[] findByDI_Head_PrevAndNext(
			long demandId, long domainId, boolean head,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
				orderByComparator)
		throws NoSuchCdsDemandException;

	/**
	 * Returns all the cds demands where domainId = any &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainIds the domain IDs
	 * @param head the head
	 * @return the matching cds demands
	 */
	public java.util.List<CdsDemand> findByDI_Head(
		long[] domainIds, boolean head);

	/**
	 * Returns a range of all the cds demands where domainId = any &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainIds the domain IDs
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByDI_Head(
		long[] domainIds, boolean head, int start, int end);

	/**
	 * Returns an ordered range of all the cds demands where domainId = any &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainIds the domain IDs
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByDI_Head(
		long[] domainIds, boolean head, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cds demands where domainId = &#63; and head = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	public java.util.List<CdsDemand> findByDI_Head(
		long[] domainIds, boolean head, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cds demands where domainId = &#63; and head = &#63; from the database.
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 */
	public void removeByDI_Head(long domainId, boolean head);

	/**
	 * Returns the number of cds demands where domainId = &#63; and head = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @return the number of matching cds demands
	 */
	public int countByDI_Head(long domainId, boolean head);

	/**
	 * Returns the number of cds demands where domainId = any &#63; and head = &#63;.
	 *
	 * @param domainIds the domain IDs
	 * @param head the head
	 * @return the number of matching cds demands
	 */
	public int countByDI_Head(long[] domainIds, boolean head);

	/**
	 * Returns the cds demand where headId = &#63; or throws a <code>NoSuchCdsDemandException</code> if it could not be found.
	 *
	 * @param headId the head ID
	 * @return the matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public CdsDemand findByHeadId(long headId) throws NoSuchCdsDemandException;

	/**
	 * Returns the cds demand where headId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param headId the head ID
	 * @return the matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByHeadId(long headId);

	/**
	 * Returns the cds demand where headId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param headId the head ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public CdsDemand fetchByHeadId(long headId, boolean useFinderCache);

	/**
	 * Removes the cds demand where headId = &#63; from the database.
	 *
	 * @param headId the head ID
	 * @return the cds demand that was removed
	 */
	public CdsDemand removeByHeadId(long headId)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the number of cds demands where headId = &#63;.
	 *
	 * @param headId the head ID
	 * @return the number of matching cds demands
	 */
	public int countByHeadId(long headId);

	/**
	 * Caches the cds demand in the entity cache if it is enabled.
	 *
	 * @param cdsDemand the cds demand
	 */
	public void cacheResult(CdsDemand cdsDemand);

	/**
	 * Caches the cds demands in the entity cache if it is enabled.
	 *
	 * @param cdsDemands the cds demands
	 */
	public void cacheResult(java.util.List<CdsDemand> cdsDemands);

	/**
	 * Creates a new cds demand with the primary key. Does not add the cds demand to the database.
	 *
	 * @param demandId the primary key for the new cds demand
	 * @return the new cds demand
	 */
	public CdsDemand create(long demandId);

	/**
	 * Removes the cds demand with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param demandId the primary key of the cds demand
	 * @return the cds demand that was removed
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	public CdsDemand remove(long demandId) throws NoSuchCdsDemandException;

	public CdsDemand updateImpl(CdsDemand cdsDemand);

	/**
	 * Returns the cds demand with the primary key or throws a <code>NoSuchCdsDemandException</code> if it could not be found.
	 *
	 * @param demandId the primary key of the cds demand
	 * @return the cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	public CdsDemand findByPrimaryKey(long demandId)
		throws NoSuchCdsDemandException;

	/**
	 * Returns the cds demand with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param demandId the primary key of the cds demand
	 * @return the cds demand, or <code>null</code> if a cds demand with the primary key could not be found
	 */
	public CdsDemand fetchByPrimaryKey(long demandId);

	/**
	 * Returns all the cds demands.
	 *
	 * @return the cds demands
	 */
	public java.util.List<CdsDemand> findAll();

	/**
	 * Returns a range of all the cds demands.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of cds demands
	 */
	public java.util.List<CdsDemand> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the cds demands.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cds demands
	 */
	public java.util.List<CdsDemand> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cds demands.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cds demands
	 */
	public java.util.List<CdsDemand> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemand>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cds demands from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cds demands.
	 *
	 * @return the number of cds demands
	 */
	public int countAll();

}