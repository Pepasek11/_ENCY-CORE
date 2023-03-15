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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import cz.csob.ency.cds.demands.model.CdsDemand;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the cds demand service. This utility wraps <code>cz.csob.ency.cds.demands.service.persistence.impl.CdsDemandPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see CdsDemandPersistence
 * @generated
 */
public class CdsDemandUtil {

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
	public static void clearCache(CdsDemand cdsDemand) {
		getPersistence().clearCache(cdsDemand);
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
	public static Map<Serializable, CdsDemand> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CdsDemand> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CdsDemand> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CdsDemand> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CdsDemand update(CdsDemand cdsDemand) {
		return getPersistence().update(cdsDemand);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CdsDemand update(
		CdsDemand cdsDemand, ServiceContext serviceContext) {

		return getPersistence().update(cdsDemand, serviceContext);
	}

	/**
	 * Returns all the cds demands where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cds demands
	 */
	public static List<CdsDemand> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<CdsDemand> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<CdsDemand> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<CdsDemand> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public static CdsDemand findByUuid_First(
			String uuid, OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByUuid_First(
		String uuid, OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public static CdsDemand findByUuid_Last(
			String uuid, OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByUuid_Last(
		String uuid, OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	public static CdsDemand[] findByUuid_PrevAndNext(
			long demandId, String uuid,
			OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByUuid_PrevAndNext(
			demandId, uuid, orderByComparator);
	}

	/**
	 * Removes all the cds demands where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of cds demands where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cds demands
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the cds demands where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the matching cds demands
	 */
	public static List<CdsDemand> findByUuid_Head(String uuid, boolean head) {
		return getPersistence().findByUuid_Head(uuid, head);
	}

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
	public static List<CdsDemand> findByUuid_Head(
		String uuid, boolean head, int start, int end) {

		return getPersistence().findByUuid_Head(uuid, head, start, end);
	}

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
	public static List<CdsDemand> findByUuid_Head(
		String uuid, boolean head, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().findByUuid_Head(
			uuid, head, start, end, orderByComparator);
	}

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
	public static List<CdsDemand> findByUuid_Head(
		String uuid, boolean head, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_Head(
			uuid, head, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public static CdsDemand findByUuid_Head_First(
			String uuid, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByUuid_Head_First(
			uuid, head, orderByComparator);
	}

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByUuid_Head_First(
		String uuid, boolean head,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().fetchByUuid_Head_First(
			uuid, head, orderByComparator);
	}

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public static CdsDemand findByUuid_Head_Last(
			String uuid, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByUuid_Head_Last(
			uuid, head, orderByComparator);
	}

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByUuid_Head_Last(
		String uuid, boolean head,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().fetchByUuid_Head_Last(
			uuid, head, orderByComparator);
	}

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
	public static CdsDemand[] findByUuid_Head_PrevAndNext(
			long demandId, String uuid, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByUuid_Head_PrevAndNext(
			demandId, uuid, head, orderByComparator);
	}

	/**
	 * Removes all the cds demands where uuid = &#63; and head = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 */
	public static void removeByUuid_Head(String uuid, boolean head) {
		getPersistence().removeByUuid_Head(uuid, head);
	}

	/**
	 * Returns the number of cds demands where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the number of matching cds demands
	 */
	public static int countByUuid_Head(String uuid, boolean head) {
		return getPersistence().countByUuid_Head(uuid, head);
	}

	/**
	 * Returns all the cds demands where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cds demands
	 */
	public static List<CdsDemand> findByUUID_G(String uuid, long groupId) {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

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
	public static List<CdsDemand> findByUUID_G(
		String uuid, long groupId, int start, int end) {

		return getPersistence().findByUUID_G(uuid, groupId, start, end);
	}

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
	public static List<CdsDemand> findByUUID_G(
		String uuid, long groupId, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().findByUUID_G(
			uuid, groupId, start, end, orderByComparator);
	}

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
	public static List<CdsDemand> findByUUID_G(
		String uuid, long groupId, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUUID_G(
			uuid, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public static CdsDemand findByUUID_G_First(
			String uuid, long groupId,
			OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByUUID_G_First(
			uuid, groupId, orderByComparator);
	}

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByUUID_G_First(
		String uuid, long groupId,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().fetchByUUID_G_First(
			uuid, groupId, orderByComparator);
	}

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public static CdsDemand findByUUID_G_Last(
			String uuid, long groupId,
			OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByUUID_G_Last(
			uuid, groupId, orderByComparator);
	}

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByUUID_G_Last(
		String uuid, long groupId,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().fetchByUUID_G_Last(
			uuid, groupId, orderByComparator);
	}

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
	public static CdsDemand[] findByUUID_G_PrevAndNext(
			long demandId, String uuid, long groupId,
			OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByUUID_G_PrevAndNext(
			demandId, uuid, groupId, orderByComparator);
	}

	/**
	 * Removes all the cds demands where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 */
	public static void removeByUUID_G(String uuid, long groupId) {
		getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of cds demands where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching cds demands
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the cds demand where uuid = &#63; and groupId = &#63; and head = &#63; or throws a <code>NoSuchCdsDemandException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public static CdsDemand findByUUID_G_Head(
			String uuid, long groupId, boolean head)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByUUID_G_Head(uuid, groupId, head);
	}

	/**
	 * Returns the cds demand where uuid = &#63; and groupId = &#63; and head = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByUUID_G_Head(
		String uuid, long groupId, boolean head) {

		return getPersistence().fetchByUUID_G_Head(uuid, groupId, head);
	}

	/**
	 * Returns the cds demand where uuid = &#63; and groupId = &#63; and head = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByUUID_G_Head(
		String uuid, long groupId, boolean head, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G_Head(
			uuid, groupId, head, useFinderCache);
	}

	/**
	 * Removes the cds demand where uuid = &#63; and groupId = &#63; and head = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the cds demand that was removed
	 */
	public static CdsDemand removeByUUID_G_Head(
			String uuid, long groupId, boolean head)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().removeByUUID_G_Head(uuid, groupId, head);
	}

	/**
	 * Returns the number of cds demands where uuid = &#63; and groupId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the number of matching cds demands
	 */
	public static int countByUUID_G_Head(
		String uuid, long groupId, boolean head) {

		return getPersistence().countByUUID_G_Head(uuid, groupId, head);
	}

	/**
	 * Returns all the cds demands where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching cds demands
	 */
	public static List<CdsDemand> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<CdsDemand> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<CdsDemand> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<CdsDemand> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public static CdsDemand findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public static CdsDemand findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static CdsDemand[] findByUuid_C_PrevAndNext(
			long demandId, String uuid, long companyId,
			OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByUuid_C_PrevAndNext(
			demandId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the cds demands where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of cds demands where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching cds demands
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the cds demands where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @return the matching cds demands
	 */
	public static List<CdsDemand> findByUuid_C_Head(
		String uuid, long companyId, boolean head) {

		return getPersistence().findByUuid_C_Head(uuid, companyId, head);
	}

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
	public static List<CdsDemand> findByUuid_C_Head(
		String uuid, long companyId, boolean head, int start, int end) {

		return getPersistence().findByUuid_C_Head(
			uuid, companyId, head, start, end);
	}

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
	public static List<CdsDemand> findByUuid_C_Head(
		String uuid, long companyId, boolean head, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().findByUuid_C_Head(
			uuid, companyId, head, start, end, orderByComparator);
	}

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
	public static List<CdsDemand> findByUuid_C_Head(
		String uuid, long companyId, boolean head, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C_Head(
			uuid, companyId, head, start, end, orderByComparator,
			useFinderCache);
	}

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
	public static CdsDemand findByUuid_C_Head_First(
			String uuid, long companyId, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByUuid_C_Head_First(
			uuid, companyId, head, orderByComparator);
	}

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByUuid_C_Head_First(
		String uuid, long companyId, boolean head,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().fetchByUuid_C_Head_First(
			uuid, companyId, head, orderByComparator);
	}

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
	public static CdsDemand findByUuid_C_Head_Last(
			String uuid, long companyId, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByUuid_C_Head_Last(
			uuid, companyId, head, orderByComparator);
	}

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByUuid_C_Head_Last(
		String uuid, long companyId, boolean head,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().fetchByUuid_C_Head_Last(
			uuid, companyId, head, orderByComparator);
	}

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
	public static CdsDemand[] findByUuid_C_Head_PrevAndNext(
			long demandId, String uuid, long companyId, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByUuid_C_Head_PrevAndNext(
			demandId, uuid, companyId, head, orderByComparator);
	}

	/**
	 * Removes all the cds demands where uuid = &#63; and companyId = &#63; and head = &#63; from the database.
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
	 * Returns the number of cds demands where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @return the number of matching cds demands
	 */
	public static int countByUuid_C_Head(
		String uuid, long companyId, boolean head) {

		return getPersistence().countByUuid_C_Head(uuid, companyId, head);
	}

	/**
	 * Returns all the cds demands where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching cds demands
	 */
	public static List<CdsDemand> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

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
	public static List<CdsDemand> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

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
	public static List<CdsDemand> findByUserId(
		long userId, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

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
	public static List<CdsDemand> findByUserId(
		long userId, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cds demand in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public static CdsDemand findByUserId_First(
			long userId, OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first cds demand in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByUserId_First(
		long userId, OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last cds demand in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public static CdsDemand findByUserId_Last(
			long userId, OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last cds demand in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByUserId_Last(
		long userId, OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where userId = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	public static CdsDemand[] findByUserId_PrevAndNext(
			long demandId, long userId,
			OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByUserId_PrevAndNext(
			demandId, userId, orderByComparator);
	}

	/**
	 * Removes all the cds demands where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of cds demands where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching cds demands
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the cds demands where userId = &#63; and head = &#63;.
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @return the matching cds demands
	 */
	public static List<CdsDemand> findByUserId_Head(long userId, boolean head) {
		return getPersistence().findByUserId_Head(userId, head);
	}

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
	public static List<CdsDemand> findByUserId_Head(
		long userId, boolean head, int start, int end) {

		return getPersistence().findByUserId_Head(userId, head, start, end);
	}

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
	public static List<CdsDemand> findByUserId_Head(
		long userId, boolean head, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().findByUserId_Head(
			userId, head, start, end, orderByComparator);
	}

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
	public static List<CdsDemand> findByUserId_Head(
		long userId, boolean head, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId_Head(
			userId, head, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cds demand in the ordered set where userId = &#63; and head = &#63;.
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public static CdsDemand findByUserId_Head_First(
			long userId, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByUserId_Head_First(
			userId, head, orderByComparator);
	}

	/**
	 * Returns the first cds demand in the ordered set where userId = &#63; and head = &#63;.
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByUserId_Head_First(
		long userId, boolean head,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().fetchByUserId_Head_First(
			userId, head, orderByComparator);
	}

	/**
	 * Returns the last cds demand in the ordered set where userId = &#63; and head = &#63;.
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public static CdsDemand findByUserId_Head_Last(
			long userId, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByUserId_Head_Last(
			userId, head, orderByComparator);
	}

	/**
	 * Returns the last cds demand in the ordered set where userId = &#63; and head = &#63;.
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByUserId_Head_Last(
		long userId, boolean head,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().fetchByUserId_Head_Last(
			userId, head, orderByComparator);
	}

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
	public static CdsDemand[] findByUserId_Head_PrevAndNext(
			long demandId, long userId, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByUserId_Head_PrevAndNext(
			demandId, userId, head, orderByComparator);
	}

	/**
	 * Removes all the cds demands where userId = &#63; and head = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param head the head
	 */
	public static void removeByUserId_Head(long userId, boolean head) {
		getPersistence().removeByUserId_Head(userId, head);
	}

	/**
	 * Returns the number of cds demands where userId = &#63; and head = &#63;.
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @return the number of matching cds demands
	 */
	public static int countByUserId_Head(long userId, boolean head) {
		return getPersistence().countByUserId_Head(userId, head);
	}

	/**
	 * Returns all the cds demands where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cds demands
	 */
	public static List<CdsDemand> findByXid(String uuid) {
		return getPersistence().findByXid(uuid);
	}

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
	public static List<CdsDemand> findByXid(String uuid, int start, int end) {
		return getPersistence().findByXid(uuid, start, end);
	}

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
	public static List<CdsDemand> findByXid(
		String uuid, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().findByXid(uuid, start, end, orderByComparator);
	}

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
	public static List<CdsDemand> findByXid(
		String uuid, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByXid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public static CdsDemand findByXid_First(
			String uuid, OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByXid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByXid_First(
		String uuid, OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().fetchByXid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public static CdsDemand findByXid_Last(
			String uuid, OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByXid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByXid_Last(
		String uuid, OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().fetchByXid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	public static CdsDemand[] findByXid_PrevAndNext(
			long demandId, String uuid,
			OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByXid_PrevAndNext(
			demandId, uuid, orderByComparator);
	}

	/**
	 * Removes all the cds demands where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByXid(String uuid) {
		getPersistence().removeByXid(uuid);
	}

	/**
	 * Returns the number of cds demands where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cds demands
	 */
	public static int countByXid(String uuid) {
		return getPersistence().countByXid(uuid);
	}

	/**
	 * Returns the cds demand where uuid = &#63; and head = &#63; or throws a <code>NoSuchCdsDemandException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public static CdsDemand findByXid_Head(String uuid, boolean head)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByXid_Head(uuid, head);
	}

	/**
	 * Returns the cds demand where uuid = &#63; and head = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByXid_Head(String uuid, boolean head) {
		return getPersistence().fetchByXid_Head(uuid, head);
	}

	/**
	 * Returns the cds demand where uuid = &#63; and head = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByXid_Head(
		String uuid, boolean head, boolean useFinderCache) {

		return getPersistence().fetchByXid_Head(uuid, head, useFinderCache);
	}

	/**
	 * Removes the cds demand where uuid = &#63; and head = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the cds demand that was removed
	 */
	public static CdsDemand removeByXid_Head(String uuid, boolean head)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().removeByXid_Head(uuid, head);
	}

	/**
	 * Returns the number of cds demands where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the number of matching cds demands
	 */
	public static int countByXid_Head(String uuid, boolean head) {
		return getPersistence().countByXid_Head(uuid, head);
	}

	/**
	 * Returns all the cds demands where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @return the matching cds demands
	 */
	public static List<CdsDemand> findByDI(long domainId) {
		return getPersistence().findByDI(domainId);
	}

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
	public static List<CdsDemand> findByDI(long domainId, int start, int end) {
		return getPersistence().findByDI(domainId, start, end);
	}

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
	public static List<CdsDemand> findByDI(
		long domainId, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().findByDI(
			domainId, start, end, orderByComparator);
	}

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
	public static List<CdsDemand> findByDI(
		long domainId, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDI(
			domainId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cds demand in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public static CdsDemand findByDI_First(
			long domainId, OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByDI_First(domainId, orderByComparator);
	}

	/**
	 * Returns the first cds demand in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByDI_First(
		long domainId, OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().fetchByDI_First(domainId, orderByComparator);
	}

	/**
	 * Returns the last cds demand in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public static CdsDemand findByDI_Last(
			long domainId, OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByDI_Last(domainId, orderByComparator);
	}

	/**
	 * Returns the last cds demand in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByDI_Last(
		long domainId, OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().fetchByDI_Last(domainId, orderByComparator);
	}

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where domainId = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	public static CdsDemand[] findByDI_PrevAndNext(
			long demandId, long domainId,
			OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByDI_PrevAndNext(
			demandId, domainId, orderByComparator);
	}

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
	public static List<CdsDemand> findByDI(long[] domainIds) {
		return getPersistence().findByDI(domainIds);
	}

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
	public static List<CdsDemand> findByDI(
		long[] domainIds, int start, int end) {

		return getPersistence().findByDI(domainIds, start, end);
	}

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
	public static List<CdsDemand> findByDI(
		long[] domainIds, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().findByDI(
			domainIds, start, end, orderByComparator);
	}

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
	public static List<CdsDemand> findByDI(
		long[] domainIds, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDI(
			domainIds, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cds demands where domainId = &#63; from the database.
	 *
	 * @param domainId the domain ID
	 */
	public static void removeByDI(long domainId) {
		getPersistence().removeByDI(domainId);
	}

	/**
	 * Returns the number of cds demands where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @return the number of matching cds demands
	 */
	public static int countByDI(long domainId) {
		return getPersistence().countByDI(domainId);
	}

	/**
	 * Returns the number of cds demands where domainId = any &#63;.
	 *
	 * @param domainIds the domain IDs
	 * @return the number of matching cds demands
	 */
	public static int countByDI(long[] domainIds) {
		return getPersistence().countByDI(domainIds);
	}

	/**
	 * Returns all the cds demands where domainId = &#63; and head = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @return the matching cds demands
	 */
	public static List<CdsDemand> findByDI_Head(long domainId, boolean head) {
		return getPersistence().findByDI_Head(domainId, head);
	}

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
	public static List<CdsDemand> findByDI_Head(
		long domainId, boolean head, int start, int end) {

		return getPersistence().findByDI_Head(domainId, head, start, end);
	}

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
	public static List<CdsDemand> findByDI_Head(
		long domainId, boolean head, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().findByDI_Head(
			domainId, head, start, end, orderByComparator);
	}

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
	public static List<CdsDemand> findByDI_Head(
		long domainId, boolean head, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDI_Head(
			domainId, head, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cds demand in the ordered set where domainId = &#63; and head = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public static CdsDemand findByDI_Head_First(
			long domainId, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByDI_Head_First(
			domainId, head, orderByComparator);
	}

	/**
	 * Returns the first cds demand in the ordered set where domainId = &#63; and head = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByDI_Head_First(
		long domainId, boolean head,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().fetchByDI_Head_First(
			domainId, head, orderByComparator);
	}

	/**
	 * Returns the last cds demand in the ordered set where domainId = &#63; and head = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public static CdsDemand findByDI_Head_Last(
			long domainId, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByDI_Head_Last(
			domainId, head, orderByComparator);
	}

	/**
	 * Returns the last cds demand in the ordered set where domainId = &#63; and head = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByDI_Head_Last(
		long domainId, boolean head,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().fetchByDI_Head_Last(
			domainId, head, orderByComparator);
	}

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
	public static CdsDemand[] findByDI_Head_PrevAndNext(
			long demandId, long domainId, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByDI_Head_PrevAndNext(
			demandId, domainId, head, orderByComparator);
	}

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
	public static List<CdsDemand> findByDI_Head(
		long[] domainIds, boolean head) {

		return getPersistence().findByDI_Head(domainIds, head);
	}

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
	public static List<CdsDemand> findByDI_Head(
		long[] domainIds, boolean head, int start, int end) {

		return getPersistence().findByDI_Head(domainIds, head, start, end);
	}

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
	public static List<CdsDemand> findByDI_Head(
		long[] domainIds, boolean head, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().findByDI_Head(
			domainIds, head, start, end, orderByComparator);
	}

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
	public static List<CdsDemand> findByDI_Head(
		long[] domainIds, boolean head, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDI_Head(
			domainIds, head, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cds demands where domainId = &#63; and head = &#63; from the database.
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 */
	public static void removeByDI_Head(long domainId, boolean head) {
		getPersistence().removeByDI_Head(domainId, head);
	}

	/**
	 * Returns the number of cds demands where domainId = &#63; and head = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @return the number of matching cds demands
	 */
	public static int countByDI_Head(long domainId, boolean head) {
		return getPersistence().countByDI_Head(domainId, head);
	}

	/**
	 * Returns the number of cds demands where domainId = any &#63; and head = &#63;.
	 *
	 * @param domainIds the domain IDs
	 * @param head the head
	 * @return the number of matching cds demands
	 */
	public static int countByDI_Head(long[] domainIds, boolean head) {
		return getPersistence().countByDI_Head(domainIds, head);
	}

	/**
	 * Returns the cds demand where headId = &#63; or throws a <code>NoSuchCdsDemandException</code> if it could not be found.
	 *
	 * @param headId the head ID
	 * @return the matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	public static CdsDemand findByHeadId(long headId)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByHeadId(headId);
	}

	/**
	 * Returns the cds demand where headId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param headId the head ID
	 * @return the matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByHeadId(long headId) {
		return getPersistence().fetchByHeadId(headId);
	}

	/**
	 * Returns the cds demand where headId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param headId the head ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	public static CdsDemand fetchByHeadId(long headId, boolean useFinderCache) {
		return getPersistence().fetchByHeadId(headId, useFinderCache);
	}

	/**
	 * Removes the cds demand where headId = &#63; from the database.
	 *
	 * @param headId the head ID
	 * @return the cds demand that was removed
	 */
	public static CdsDemand removeByHeadId(long headId)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().removeByHeadId(headId);
	}

	/**
	 * Returns the number of cds demands where headId = &#63;.
	 *
	 * @param headId the head ID
	 * @return the number of matching cds demands
	 */
	public static int countByHeadId(long headId) {
		return getPersistence().countByHeadId(headId);
	}

	/**
	 * Caches the cds demand in the entity cache if it is enabled.
	 *
	 * @param cdsDemand the cds demand
	 */
	public static void cacheResult(CdsDemand cdsDemand) {
		getPersistence().cacheResult(cdsDemand);
	}

	/**
	 * Caches the cds demands in the entity cache if it is enabled.
	 *
	 * @param cdsDemands the cds demands
	 */
	public static void cacheResult(List<CdsDemand> cdsDemands) {
		getPersistence().cacheResult(cdsDemands);
	}

	/**
	 * Creates a new cds demand with the primary key. Does not add the cds demand to the database.
	 *
	 * @param demandId the primary key for the new cds demand
	 * @return the new cds demand
	 */
	public static CdsDemand create(long demandId) {
		return getPersistence().create(demandId);
	}

	/**
	 * Removes the cds demand with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param demandId the primary key of the cds demand
	 * @return the cds demand that was removed
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	public static CdsDemand remove(long demandId)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().remove(demandId);
	}

	public static CdsDemand updateImpl(CdsDemand cdsDemand) {
		return getPersistence().updateImpl(cdsDemand);
	}

	/**
	 * Returns the cds demand with the primary key or throws a <code>NoSuchCdsDemandException</code> if it could not be found.
	 *
	 * @param demandId the primary key of the cds demand
	 * @return the cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	public static CdsDemand findByPrimaryKey(long demandId)
		throws cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException {

		return getPersistence().findByPrimaryKey(demandId);
	}

	/**
	 * Returns the cds demand with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param demandId the primary key of the cds demand
	 * @return the cds demand, or <code>null</code> if a cds demand with the primary key could not be found
	 */
	public static CdsDemand fetchByPrimaryKey(long demandId) {
		return getPersistence().fetchByPrimaryKey(demandId);
	}

	/**
	 * Returns all the cds demands.
	 *
	 * @return the cds demands
	 */
	public static List<CdsDemand> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<CdsDemand> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<CdsDemand> findAll(
		int start, int end, OrderByComparator<CdsDemand> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<CdsDemand> findAll(
		int start, int end, OrderByComparator<CdsDemand> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cds demands from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cds demands.
	 *
	 * @return the number of cds demands
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CdsDemandPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CdsDemandPersistence _persistence;

}