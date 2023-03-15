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

import cz.csob.ency.cds.demands.model.CdsDemandGdprInfo;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the cds demand gdpr info service. This utility wraps <code>cz.csob.ency.cds.demands.service.persistence.impl.CdsDemandGdprInfoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see CdsDemandGdprInfoPersistence
 * @generated
 */
public class CdsDemandGdprInfoUtil {

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
	public static void clearCache(CdsDemandGdprInfo cdsDemandGdprInfo) {
		getPersistence().clearCache(cdsDemandGdprInfo);
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
	public static Map<Serializable, CdsDemandGdprInfo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CdsDemandGdprInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CdsDemandGdprInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CdsDemandGdprInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CdsDemandGdprInfo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CdsDemandGdprInfo update(
		CdsDemandGdprInfo cdsDemandGdprInfo) {

		return getPersistence().update(cdsDemandGdprInfo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CdsDemandGdprInfo update(
		CdsDemandGdprInfo cdsDemandGdprInfo, ServiceContext serviceContext) {

		return getPersistence().update(cdsDemandGdprInfo, serviceContext);
	}

	/**
	 * Returns all the cds demand gdpr infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cds demand gdpr infos
	 */
	public static List<CdsDemandGdprInfo> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the cds demand gdpr infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandGdprInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demand gdpr infos
	 * @param end the upper bound of the range of cds demand gdpr infos (not inclusive)
	 * @return the range of matching cds demand gdpr infos
	 */
	public static List<CdsDemandGdprInfo> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the cds demand gdpr infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandGdprInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demand gdpr infos
	 * @param end the upper bound of the range of cds demand gdpr infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand gdpr infos
	 */
	public static List<CdsDemandGdprInfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CdsDemandGdprInfo> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cds demand gdpr infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandGdprInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demand gdpr infos
	 * @param end the upper bound of the range of cds demand gdpr infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand gdpr infos
	 */
	public static List<CdsDemandGdprInfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CdsDemandGdprInfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cds demand gdpr info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand gdpr info
	 * @throws NoSuchCdsDemandGdprInfoException if a matching cds demand gdpr info could not be found
	 */
	public static CdsDemandGdprInfo findByUuid_First(
			String uuid, OrderByComparator<CdsDemandGdprInfo> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandGdprInfoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first cds demand gdpr info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand gdpr info, or <code>null</code> if a matching cds demand gdpr info could not be found
	 */
	public static CdsDemandGdprInfo fetchByUuid_First(
		String uuid, OrderByComparator<CdsDemandGdprInfo> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last cds demand gdpr info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand gdpr info
	 * @throws NoSuchCdsDemandGdprInfoException if a matching cds demand gdpr info could not be found
	 */
	public static CdsDemandGdprInfo findByUuid_Last(
			String uuid, OrderByComparator<CdsDemandGdprInfo> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandGdprInfoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last cds demand gdpr info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand gdpr info, or <code>null</code> if a matching cds demand gdpr info could not be found
	 */
	public static CdsDemandGdprInfo fetchByUuid_Last(
		String uuid, OrderByComparator<CdsDemandGdprInfo> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the cds demand gdpr infos before and after the current cds demand gdpr info in the ordered set where uuid = &#63;.
	 *
	 * @param gdprInfoId the primary key of the current cds demand gdpr info
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand gdpr info
	 * @throws NoSuchCdsDemandGdprInfoException if a cds demand gdpr info with the primary key could not be found
	 */
	public static CdsDemandGdprInfo[] findByUuid_PrevAndNext(
			long gdprInfoId, String uuid,
			OrderByComparator<CdsDemandGdprInfo> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandGdprInfoException {

		return getPersistence().findByUuid_PrevAndNext(
			gdprInfoId, uuid, orderByComparator);
	}

	/**
	 * Removes all the cds demand gdpr infos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of cds demand gdpr infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cds demand gdpr infos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the cds demand gdpr infos where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @return the matching cds demand gdpr infos
	 */
	public static List<CdsDemandGdprInfo> findBydemandId(long demandId) {
		return getPersistence().findBydemandId(demandId);
	}

	/**
	 * Returns a range of all the cds demand gdpr infos where demandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandGdprInfoModelImpl</code>.
	 * </p>
	 *
	 * @param demandId the demand ID
	 * @param start the lower bound of the range of cds demand gdpr infos
	 * @param end the upper bound of the range of cds demand gdpr infos (not inclusive)
	 * @return the range of matching cds demand gdpr infos
	 */
	public static List<CdsDemandGdprInfo> findBydemandId(
		long demandId, int start, int end) {

		return getPersistence().findBydemandId(demandId, start, end);
	}

	/**
	 * Returns an ordered range of all the cds demand gdpr infos where demandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandGdprInfoModelImpl</code>.
	 * </p>
	 *
	 * @param demandId the demand ID
	 * @param start the lower bound of the range of cds demand gdpr infos
	 * @param end the upper bound of the range of cds demand gdpr infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand gdpr infos
	 */
	public static List<CdsDemandGdprInfo> findBydemandId(
		long demandId, int start, int end,
		OrderByComparator<CdsDemandGdprInfo> orderByComparator) {

		return getPersistence().findBydemandId(
			demandId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cds demand gdpr infos where demandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandGdprInfoModelImpl</code>.
	 * </p>
	 *
	 * @param demandId the demand ID
	 * @param start the lower bound of the range of cds demand gdpr infos
	 * @param end the upper bound of the range of cds demand gdpr infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand gdpr infos
	 */
	public static List<CdsDemandGdprInfo> findBydemandId(
		long demandId, int start, int end,
		OrderByComparator<CdsDemandGdprInfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydemandId(
			demandId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cds demand gdpr info in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand gdpr info
	 * @throws NoSuchCdsDemandGdprInfoException if a matching cds demand gdpr info could not be found
	 */
	public static CdsDemandGdprInfo findBydemandId_First(
			long demandId,
			OrderByComparator<CdsDemandGdprInfo> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandGdprInfoException {

		return getPersistence().findBydemandId_First(
			demandId, orderByComparator);
	}

	/**
	 * Returns the first cds demand gdpr info in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand gdpr info, or <code>null</code> if a matching cds demand gdpr info could not be found
	 */
	public static CdsDemandGdprInfo fetchBydemandId_First(
		long demandId, OrderByComparator<CdsDemandGdprInfo> orderByComparator) {

		return getPersistence().fetchBydemandId_First(
			demandId, orderByComparator);
	}

	/**
	 * Returns the last cds demand gdpr info in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand gdpr info
	 * @throws NoSuchCdsDemandGdprInfoException if a matching cds demand gdpr info could not be found
	 */
	public static CdsDemandGdprInfo findBydemandId_Last(
			long demandId,
			OrderByComparator<CdsDemandGdprInfo> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandGdprInfoException {

		return getPersistence().findBydemandId_Last(
			demandId, orderByComparator);
	}

	/**
	 * Returns the last cds demand gdpr info in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand gdpr info, or <code>null</code> if a matching cds demand gdpr info could not be found
	 */
	public static CdsDemandGdprInfo fetchBydemandId_Last(
		long demandId, OrderByComparator<CdsDemandGdprInfo> orderByComparator) {

		return getPersistence().fetchBydemandId_Last(
			demandId, orderByComparator);
	}

	/**
	 * Returns the cds demand gdpr infos before and after the current cds demand gdpr info in the ordered set where demandId = &#63;.
	 *
	 * @param gdprInfoId the primary key of the current cds demand gdpr info
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand gdpr info
	 * @throws NoSuchCdsDemandGdprInfoException if a cds demand gdpr info with the primary key could not be found
	 */
	public static CdsDemandGdprInfo[] findBydemandId_PrevAndNext(
			long gdprInfoId, long demandId,
			OrderByComparator<CdsDemandGdprInfo> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandGdprInfoException {

		return getPersistence().findBydemandId_PrevAndNext(
			gdprInfoId, demandId, orderByComparator);
	}

	/**
	 * Removes all the cds demand gdpr infos where demandId = &#63; from the database.
	 *
	 * @param demandId the demand ID
	 */
	public static void removeBydemandId(long demandId) {
		getPersistence().removeBydemandId(demandId);
	}

	/**
	 * Returns the number of cds demand gdpr infos where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @return the number of matching cds demand gdpr infos
	 */
	public static int countBydemandId(long demandId) {
		return getPersistence().countBydemandId(demandId);
	}

	/**
	 * Caches the cds demand gdpr info in the entity cache if it is enabled.
	 *
	 * @param cdsDemandGdprInfo the cds demand gdpr info
	 */
	public static void cacheResult(CdsDemandGdprInfo cdsDemandGdprInfo) {
		getPersistence().cacheResult(cdsDemandGdprInfo);
	}

	/**
	 * Caches the cds demand gdpr infos in the entity cache if it is enabled.
	 *
	 * @param cdsDemandGdprInfos the cds demand gdpr infos
	 */
	public static void cacheResult(List<CdsDemandGdprInfo> cdsDemandGdprInfos) {
		getPersistence().cacheResult(cdsDemandGdprInfos);
	}

	/**
	 * Creates a new cds demand gdpr info with the primary key. Does not add the cds demand gdpr info to the database.
	 *
	 * @param gdprInfoId the primary key for the new cds demand gdpr info
	 * @return the new cds demand gdpr info
	 */
	public static CdsDemandGdprInfo create(long gdprInfoId) {
		return getPersistence().create(gdprInfoId);
	}

	/**
	 * Removes the cds demand gdpr info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gdprInfoId the primary key of the cds demand gdpr info
	 * @return the cds demand gdpr info that was removed
	 * @throws NoSuchCdsDemandGdprInfoException if a cds demand gdpr info with the primary key could not be found
	 */
	public static CdsDemandGdprInfo remove(long gdprInfoId)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandGdprInfoException {

		return getPersistence().remove(gdprInfoId);
	}

	public static CdsDemandGdprInfo updateImpl(
		CdsDemandGdprInfo cdsDemandGdprInfo) {

		return getPersistence().updateImpl(cdsDemandGdprInfo);
	}

	/**
	 * Returns the cds demand gdpr info with the primary key or throws a <code>NoSuchCdsDemandGdprInfoException</code> if it could not be found.
	 *
	 * @param gdprInfoId the primary key of the cds demand gdpr info
	 * @return the cds demand gdpr info
	 * @throws NoSuchCdsDemandGdprInfoException if a cds demand gdpr info with the primary key could not be found
	 */
	public static CdsDemandGdprInfo findByPrimaryKey(long gdprInfoId)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandGdprInfoException {

		return getPersistence().findByPrimaryKey(gdprInfoId);
	}

	/**
	 * Returns the cds demand gdpr info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param gdprInfoId the primary key of the cds demand gdpr info
	 * @return the cds demand gdpr info, or <code>null</code> if a cds demand gdpr info with the primary key could not be found
	 */
	public static CdsDemandGdprInfo fetchByPrimaryKey(long gdprInfoId) {
		return getPersistence().fetchByPrimaryKey(gdprInfoId);
	}

	/**
	 * Returns all the cds demand gdpr infos.
	 *
	 * @return the cds demand gdpr infos
	 */
	public static List<CdsDemandGdprInfo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cds demand gdpr infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandGdprInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cds demand gdpr infos
	 * @param end the upper bound of the range of cds demand gdpr infos (not inclusive)
	 * @return the range of cds demand gdpr infos
	 */
	public static List<CdsDemandGdprInfo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cds demand gdpr infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandGdprInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cds demand gdpr infos
	 * @param end the upper bound of the range of cds demand gdpr infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cds demand gdpr infos
	 */
	public static List<CdsDemandGdprInfo> findAll(
		int start, int end,
		OrderByComparator<CdsDemandGdprInfo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cds demand gdpr infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandGdprInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cds demand gdpr infos
	 * @param end the upper bound of the range of cds demand gdpr infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cds demand gdpr infos
	 */
	public static List<CdsDemandGdprInfo> findAll(
		int start, int end,
		OrderByComparator<CdsDemandGdprInfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cds demand gdpr infos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cds demand gdpr infos.
	 *
	 * @return the number of cds demand gdpr infos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CdsDemandGdprInfoPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CdsDemandGdprInfoPersistence _persistence;

}