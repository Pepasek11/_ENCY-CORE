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

import cz.csob.ency.cds.demands.model.CdsDemandVersion;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the cds demand version service. This utility wraps <code>cz.csob.ency.cds.demands.service.persistence.impl.CdsDemandVersionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see CdsDemandVersionPersistence
 * @generated
 */
public class CdsDemandVersionUtil {

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
	public static void clearCache(CdsDemandVersion cdsDemandVersion) {
		getPersistence().clearCache(cdsDemandVersion);
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
	public static Map<Serializable, CdsDemandVersion> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CdsDemandVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CdsDemandVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CdsDemandVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CdsDemandVersion update(CdsDemandVersion cdsDemandVersion) {
		return getPersistence().update(cdsDemandVersion);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CdsDemandVersion update(
		CdsDemandVersion cdsDemandVersion, ServiceContext serviceContext) {

		return getPersistence().update(cdsDemandVersion, serviceContext);
	}

	/**
	 * Returns all the cds demand versions where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @return the matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByDemandId(long demandId) {
		return getPersistence().findByDemandId(demandId);
	}

	/**
	 * Returns a range of all the cds demand versions where demandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param demandId the demand ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByDemandId(
		long demandId, int start, int end) {

		return getPersistence().findByDemandId(demandId, start, end);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where demandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param demandId the demand ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByDemandId(
		long demandId, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().findByDemandId(
			demandId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where demandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param demandId the demand ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByDemandId(
		long demandId, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDemandId(
			demandId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cds demand version in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByDemandId_First(
			long demandId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByDemandId_First(
			demandId, orderByComparator);
	}

	/**
	 * Returns the first cds demand version in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByDemandId_First(
		long demandId, OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().fetchByDemandId_First(
			demandId, orderByComparator);
	}

	/**
	 * Returns the last cds demand version in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByDemandId_Last(
			long demandId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByDemandId_Last(
			demandId, orderByComparator);
	}

	/**
	 * Returns the last cds demand version in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByDemandId_Last(
		long demandId, OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().fetchByDemandId_Last(
			demandId, orderByComparator);
	}

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where demandId = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	public static CdsDemandVersion[] findByDemandId_PrevAndNext(
			long cdsDemandVersionId, long demandId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByDemandId_PrevAndNext(
			cdsDemandVersionId, demandId, orderByComparator);
	}

	/**
	 * Removes all the cds demand versions where demandId = &#63; from the database.
	 *
	 * @param demandId the demand ID
	 */
	public static void removeByDemandId(long demandId) {
		getPersistence().removeByDemandId(demandId);
	}

	/**
	 * Returns the number of cds demand versions where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @return the number of matching cds demand versions
	 */
	public static int countByDemandId(long demandId) {
		return getPersistence().countByDemandId(demandId);
	}

	/**
	 * Returns the cds demand version where demandId = &#63; and version = &#63; or throws a <code>NoSuchCdsDemandVersionException</code> if it could not be found.
	 *
	 * @param demandId the demand ID
	 * @param version the version
	 * @return the matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByDemandId_Version(
			long demandId, int version)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByDemandId_Version(demandId, version);
	}

	/**
	 * Returns the cds demand version where demandId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param demandId the demand ID
	 * @param version the version
	 * @return the matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByDemandId_Version(
		long demandId, int version) {

		return getPersistence().fetchByDemandId_Version(demandId, version);
	}

	/**
	 * Returns the cds demand version where demandId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param demandId the demand ID
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByDemandId_Version(
		long demandId, int version, boolean useFinderCache) {

		return getPersistence().fetchByDemandId_Version(
			demandId, version, useFinderCache);
	}

	/**
	 * Removes the cds demand version where demandId = &#63; and version = &#63; from the database.
	 *
	 * @param demandId the demand ID
	 * @param version the version
	 * @return the cds demand version that was removed
	 */
	public static CdsDemandVersion removeByDemandId_Version(
			long demandId, int version)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().removeByDemandId_Version(demandId, version);
	}

	/**
	 * Returns the number of cds demand versions where demandId = &#63; and version = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param version the version
	 * @return the number of matching cds demand versions
	 */
	public static int countByDemandId_Version(long demandId, int version) {
		return getPersistence().countByDemandId_Version(demandId, version);
	}

	/**
	 * Returns all the cds demand versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the cds demand versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByUuid_First(
			String uuid, OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByUuid_First(
		String uuid, OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByUuid_Last(
			String uuid, OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByUuid_Last(
		String uuid, OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	public static CdsDemandVersion[] findByUuid_PrevAndNext(
			long cdsDemandVersionId, String uuid,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByUuid_PrevAndNext(
			cdsDemandVersionId, uuid, orderByComparator);
	}

	/**
	 * Removes all the cds demand versions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of cds demand versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cds demand versions
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the cds demand versions where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUuid_Version(
		String uuid, int version) {

		return getPersistence().findByUuid_Version(uuid, version);
	}

	/**
	 * Returns a range of all the cds demand versions where uuid = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUuid_Version(
		String uuid, int version, int start, int end) {

		return getPersistence().findByUuid_Version(uuid, version, start, end);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUuid_Version(
		String uuid, int version, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().findByUuid_Version(
			uuid, version, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUuid_Version(
		String uuid, int version, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_Version(
			uuid, version, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByUuid_Version_First(
			String uuid, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByUuid_Version_First(
			uuid, version, orderByComparator);
	}

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByUuid_Version_First(
		String uuid, int version,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().fetchByUuid_Version_First(
			uuid, version, orderByComparator);
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByUuid_Version_Last(
			String uuid, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByUuid_Version_Last(
			uuid, version, orderByComparator);
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByUuid_Version_Last(
		String uuid, int version,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().fetchByUuid_Version_Last(
			uuid, version, orderByComparator);
	}

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	public static CdsDemandVersion[] findByUuid_Version_PrevAndNext(
			long cdsDemandVersionId, String uuid, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByUuid_Version_PrevAndNext(
			cdsDemandVersionId, uuid, version, orderByComparator);
	}

	/**
	 * Removes all the cds demand versions where uuid = &#63; and version = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 */
	public static void removeByUuid_Version(String uuid, int version) {
		getPersistence().removeByUuid_Version(uuid, version);
	}

	/**
	 * Returns the number of cds demand versions where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the number of matching cds demand versions
	 */
	public static int countByUuid_Version(String uuid, int version) {
		return getPersistence().countByUuid_Version(uuid, version);
	}

	/**
	 * Returns all the cds demand versions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUUID_G(
		String uuid, long groupId) {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the cds demand versions where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUUID_G(
		String uuid, long groupId, int start, int end) {

		return getPersistence().findByUUID_G(uuid, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUUID_G(
		String uuid, long groupId, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().findByUUID_G(
			uuid, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUUID_G(
		String uuid, long groupId, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUUID_G(
			uuid, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByUUID_G_First(
			String uuid, long groupId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByUUID_G_First(
			uuid, groupId, orderByComparator);
	}

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByUUID_G_First(
		String uuid, long groupId,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().fetchByUUID_G_First(
			uuid, groupId, orderByComparator);
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByUUID_G_Last(
			String uuid, long groupId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByUUID_G_Last(
			uuid, groupId, orderByComparator);
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByUUID_G_Last(
		String uuid, long groupId,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().fetchByUUID_G_Last(
			uuid, groupId, orderByComparator);
	}

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	public static CdsDemandVersion[] findByUUID_G_PrevAndNext(
			long cdsDemandVersionId, String uuid, long groupId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByUUID_G_PrevAndNext(
			cdsDemandVersionId, uuid, groupId, orderByComparator);
	}

	/**
	 * Removes all the cds demand versions where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 */
	public static void removeByUUID_G(String uuid, long groupId) {
		getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of cds demand versions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching cds demand versions
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the cds demand version where uuid = &#63; and groupId = &#63; and version = &#63; or throws a <code>NoSuchCdsDemandVersionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByUUID_G_Version(
			String uuid, long groupId, int version)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByUUID_G_Version(uuid, groupId, version);
	}

	/**
	 * Returns the cds demand version where uuid = &#63; and groupId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByUUID_G_Version(
		String uuid, long groupId, int version) {

		return getPersistence().fetchByUUID_G_Version(uuid, groupId, version);
	}

	/**
	 * Returns the cds demand version where uuid = &#63; and groupId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByUUID_G_Version(
		String uuid, long groupId, int version, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G_Version(
			uuid, groupId, version, useFinderCache);
	}

	/**
	 * Removes the cds demand version where uuid = &#63; and groupId = &#63; and version = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the cds demand version that was removed
	 */
	public static CdsDemandVersion removeByUUID_G_Version(
			String uuid, long groupId, int version)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().removeByUUID_G_Version(uuid, groupId, version);
	}

	/**
	 * Returns the number of cds demand versions where uuid = &#63; and groupId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the number of matching cds demand versions
	 */
	public static int countByUUID_G_Version(
		String uuid, long groupId, int version) {

		return getPersistence().countByUUID_G_Version(uuid, groupId, version);
	}

	/**
	 * Returns all the cds demand versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the cds demand versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	public static CdsDemandVersion[] findByUuid_C_PrevAndNext(
			long cdsDemandVersionId, String uuid, long companyId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByUuid_C_PrevAndNext(
			cdsDemandVersionId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the cds demand versions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of cds demand versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching cds demand versions
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the cds demand versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @return the matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUuid_C_Version(
		String uuid, long companyId, int version) {

		return getPersistence().findByUuid_C_Version(uuid, companyId, version);
	}

	/**
	 * Returns a range of all the cds demand versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUuid_C_Version(
		String uuid, long companyId, int version, int start, int end) {

		return getPersistence().findByUuid_C_Version(
			uuid, companyId, version, start, end);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUuid_C_Version(
		String uuid, long companyId, int version, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().findByUuid_C_Version(
			uuid, companyId, version, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUuid_C_Version(
		String uuid, long companyId, int version, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C_Version(
			uuid, companyId, version, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByUuid_C_Version_First(
			String uuid, long companyId, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByUuid_C_Version_First(
			uuid, companyId, version, orderByComparator);
	}

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByUuid_C_Version_First(
		String uuid, long companyId, int version,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().fetchByUuid_C_Version_First(
			uuid, companyId, version, orderByComparator);
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByUuid_C_Version_Last(
			String uuid, long companyId, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByUuid_C_Version_Last(
			uuid, companyId, version, orderByComparator);
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByUuid_C_Version_Last(
		String uuid, long companyId, int version,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().fetchByUuid_C_Version_Last(
			uuid, companyId, version, orderByComparator);
	}

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	public static CdsDemandVersion[] findByUuid_C_Version_PrevAndNext(
			long cdsDemandVersionId, String uuid, long companyId, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByUuid_C_Version_PrevAndNext(
			cdsDemandVersionId, uuid, companyId, version, orderByComparator);
	}

	/**
	 * Removes all the cds demand versions where uuid = &#63; and companyId = &#63; and version = &#63; from the database.
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
	 * Returns the number of cds demand versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @return the number of matching cds demand versions
	 */
	public static int countByUuid_C_Version(
		String uuid, long companyId, int version) {

		return getPersistence().countByUuid_C_Version(uuid, companyId, version);
	}

	/**
	 * Returns all the cds demand versions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the cds demand versions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUserId(
		long userId, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUserId(
		long userId, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cds demand version in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByUserId_First(
			long userId, OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first cds demand version in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByUserId_First(
		long userId, OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last cds demand version in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByUserId_Last(
			long userId, OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last cds demand version in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByUserId_Last(
		long userId, OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where userId = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	public static CdsDemandVersion[] findByUserId_PrevAndNext(
			long cdsDemandVersionId, long userId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByUserId_PrevAndNext(
			cdsDemandVersionId, userId, orderByComparator);
	}

	/**
	 * Removes all the cds demand versions where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of cds demand versions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching cds demand versions
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the cds demand versions where userId = &#63; and version = &#63;.
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @return the matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUserId_Version(
		long userId, int version) {

		return getPersistence().findByUserId_Version(userId, version);
	}

	/**
	 * Returns a range of all the cds demand versions where userId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUserId_Version(
		long userId, int version, int start, int end) {

		return getPersistence().findByUserId_Version(
			userId, version, start, end);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where userId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUserId_Version(
		long userId, int version, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().findByUserId_Version(
			userId, version, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where userId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByUserId_Version(
		long userId, int version, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId_Version(
			userId, version, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cds demand version in the ordered set where userId = &#63; and version = &#63;.
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByUserId_Version_First(
			long userId, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByUserId_Version_First(
			userId, version, orderByComparator);
	}

	/**
	 * Returns the first cds demand version in the ordered set where userId = &#63; and version = &#63;.
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByUserId_Version_First(
		long userId, int version,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().fetchByUserId_Version_First(
			userId, version, orderByComparator);
	}

	/**
	 * Returns the last cds demand version in the ordered set where userId = &#63; and version = &#63;.
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByUserId_Version_Last(
			long userId, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByUserId_Version_Last(
			userId, version, orderByComparator);
	}

	/**
	 * Returns the last cds demand version in the ordered set where userId = &#63; and version = &#63;.
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByUserId_Version_Last(
		long userId, int version,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().fetchByUserId_Version_Last(
			userId, version, orderByComparator);
	}

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where userId = &#63; and version = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param userId the user ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	public static CdsDemandVersion[] findByUserId_Version_PrevAndNext(
			long cdsDemandVersionId, long userId, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByUserId_Version_PrevAndNext(
			cdsDemandVersionId, userId, version, orderByComparator);
	}

	/**
	 * Removes all the cds demand versions where userId = &#63; and version = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param version the version
	 */
	public static void removeByUserId_Version(long userId, int version) {
		getPersistence().removeByUserId_Version(userId, version);
	}

	/**
	 * Returns the number of cds demand versions where userId = &#63; and version = &#63;.
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @return the number of matching cds demand versions
	 */
	public static int countByUserId_Version(long userId, int version) {
		return getPersistence().countByUserId_Version(userId, version);
	}

	/**
	 * Returns all the cds demand versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByXid(String uuid) {
		return getPersistence().findByXid(uuid);
	}

	/**
	 * Returns a range of all the cds demand versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByXid(
		String uuid, int start, int end) {

		return getPersistence().findByXid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByXid(
		String uuid, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().findByXid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByXid(
		String uuid, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByXid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByXid_First(
			String uuid, OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByXid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByXid_First(
		String uuid, OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().fetchByXid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByXid_Last(
			String uuid, OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByXid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByXid_Last(
		String uuid, OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().fetchByXid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	public static CdsDemandVersion[] findByXid_PrevAndNext(
			long cdsDemandVersionId, String uuid,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByXid_PrevAndNext(
			cdsDemandVersionId, uuid, orderByComparator);
	}

	/**
	 * Removes all the cds demand versions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByXid(String uuid) {
		getPersistence().removeByXid(uuid);
	}

	/**
	 * Returns the number of cds demand versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cds demand versions
	 */
	public static int countByXid(String uuid) {
		return getPersistence().countByXid(uuid);
	}

	/**
	 * Returns the cds demand version where uuid = &#63; and version = &#63; or throws a <code>NoSuchCdsDemandVersionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByXid_Version(String uuid, int version)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByXid_Version(uuid, version);
	}

	/**
	 * Returns the cds demand version where uuid = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByXid_Version(
		String uuid, int version) {

		return getPersistence().fetchByXid_Version(uuid, version);
	}

	/**
	 * Returns the cds demand version where uuid = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByXid_Version(
		String uuid, int version, boolean useFinderCache) {

		return getPersistence().fetchByXid_Version(
			uuid, version, useFinderCache);
	}

	/**
	 * Removes the cds demand version where uuid = &#63; and version = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the cds demand version that was removed
	 */
	public static CdsDemandVersion removeByXid_Version(String uuid, int version)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().removeByXid_Version(uuid, version);
	}

	/**
	 * Returns the number of cds demand versions where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the number of matching cds demand versions
	 */
	public static int countByXid_Version(String uuid, int version) {
		return getPersistence().countByXid_Version(uuid, version);
	}

	/**
	 * Returns all the cds demand versions where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @return the matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByDI(long domainId) {
		return getPersistence().findByDI(domainId);
	}

	/**
	 * Returns a range of all the cds demand versions where domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByDI(
		long domainId, int start, int end) {

		return getPersistence().findByDI(domainId, start, end);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByDI(
		long domainId, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().findByDI(
			domainId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByDI(
		long domainId, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDI(
			domainId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cds demand version in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByDI_First(
			long domainId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByDI_First(domainId, orderByComparator);
	}

	/**
	 * Returns the first cds demand version in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByDI_First(
		long domainId, OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().fetchByDI_First(domainId, orderByComparator);
	}

	/**
	 * Returns the last cds demand version in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByDI_Last(
			long domainId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByDI_Last(domainId, orderByComparator);
	}

	/**
	 * Returns the last cds demand version in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByDI_Last(
		long domainId, OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().fetchByDI_Last(domainId, orderByComparator);
	}

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where domainId = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	public static CdsDemandVersion[] findByDI_PrevAndNext(
			long cdsDemandVersionId, long domainId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByDI_PrevAndNext(
			cdsDemandVersionId, domainId, orderByComparator);
	}

	/**
	 * Removes all the cds demand versions where domainId = &#63; from the database.
	 *
	 * @param domainId the domain ID
	 */
	public static void removeByDI(long domainId) {
		getPersistence().removeByDI(domainId);
	}

	/**
	 * Returns the number of cds demand versions where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @return the number of matching cds demand versions
	 */
	public static int countByDI(long domainId) {
		return getPersistence().countByDI(domainId);
	}

	/**
	 * Returns all the cds demand versions where domainId = &#63; and version = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @return the matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByDI_Version(
		long domainId, int version) {

		return getPersistence().findByDI_Version(domainId, version);
	}

	/**
	 * Returns a range of all the cds demand versions where domainId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByDI_Version(
		long domainId, int version, int start, int end) {

		return getPersistence().findByDI_Version(domainId, version, start, end);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where domainId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByDI_Version(
		long domainId, int version, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().findByDI_Version(
			domainId, version, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where domainId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand versions
	 */
	public static List<CdsDemandVersion> findByDI_Version(
		long domainId, int version, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDI_Version(
			domainId, version, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cds demand version in the ordered set where domainId = &#63; and version = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByDI_Version_First(
			long domainId, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByDI_Version_First(
			domainId, version, orderByComparator);
	}

	/**
	 * Returns the first cds demand version in the ordered set where domainId = &#63; and version = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByDI_Version_First(
		long domainId, int version,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().fetchByDI_Version_First(
			domainId, version, orderByComparator);
	}

	/**
	 * Returns the last cds demand version in the ordered set where domainId = &#63; and version = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion findByDI_Version_Last(
			long domainId, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByDI_Version_Last(
			domainId, version, orderByComparator);
	}

	/**
	 * Returns the last cds demand version in the ordered set where domainId = &#63; and version = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public static CdsDemandVersion fetchByDI_Version_Last(
		long domainId, int version,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().fetchByDI_Version_Last(
			domainId, version, orderByComparator);
	}

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where domainId = &#63; and version = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param domainId the domain ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	public static CdsDemandVersion[] findByDI_Version_PrevAndNext(
			long cdsDemandVersionId, long domainId, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByDI_Version_PrevAndNext(
			cdsDemandVersionId, domainId, version, orderByComparator);
	}

	/**
	 * Removes all the cds demand versions where domainId = &#63; and version = &#63; from the database.
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 */
	public static void removeByDI_Version(long domainId, int version) {
		getPersistence().removeByDI_Version(domainId, version);
	}

	/**
	 * Returns the number of cds demand versions where domainId = &#63; and version = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @return the number of matching cds demand versions
	 */
	public static int countByDI_Version(long domainId, int version) {
		return getPersistence().countByDI_Version(domainId, version);
	}

	/**
	 * Caches the cds demand version in the entity cache if it is enabled.
	 *
	 * @param cdsDemandVersion the cds demand version
	 */
	public static void cacheResult(CdsDemandVersion cdsDemandVersion) {
		getPersistence().cacheResult(cdsDemandVersion);
	}

	/**
	 * Caches the cds demand versions in the entity cache if it is enabled.
	 *
	 * @param cdsDemandVersions the cds demand versions
	 */
	public static void cacheResult(List<CdsDemandVersion> cdsDemandVersions) {
		getPersistence().cacheResult(cdsDemandVersions);
	}

	/**
	 * Creates a new cds demand version with the primary key. Does not add the cds demand version to the database.
	 *
	 * @param cdsDemandVersionId the primary key for the new cds demand version
	 * @return the new cds demand version
	 */
	public static CdsDemandVersion create(long cdsDemandVersionId) {
		return getPersistence().create(cdsDemandVersionId);
	}

	/**
	 * Removes the cds demand version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cdsDemandVersionId the primary key of the cds demand version
	 * @return the cds demand version that was removed
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	public static CdsDemandVersion remove(long cdsDemandVersionId)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().remove(cdsDemandVersionId);
	}

	public static CdsDemandVersion updateImpl(
		CdsDemandVersion cdsDemandVersion) {

		return getPersistence().updateImpl(cdsDemandVersion);
	}

	/**
	 * Returns the cds demand version with the primary key or throws a <code>NoSuchCdsDemandVersionException</code> if it could not be found.
	 *
	 * @param cdsDemandVersionId the primary key of the cds demand version
	 * @return the cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	public static CdsDemandVersion findByPrimaryKey(long cdsDemandVersionId)
		throws cz.csob.ency.cds.demands.exception.
			NoSuchCdsDemandVersionException {

		return getPersistence().findByPrimaryKey(cdsDemandVersionId);
	}

	/**
	 * Returns the cds demand version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cdsDemandVersionId the primary key of the cds demand version
	 * @return the cds demand version, or <code>null</code> if a cds demand version with the primary key could not be found
	 */
	public static CdsDemandVersion fetchByPrimaryKey(long cdsDemandVersionId) {
		return getPersistence().fetchByPrimaryKey(cdsDemandVersionId);
	}

	/**
	 * Returns all the cds demand versions.
	 *
	 * @return the cds demand versions
	 */
	public static List<CdsDemandVersion> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cds demand versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of cds demand versions
	 */
	public static List<CdsDemandVersion> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cds demand versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cds demand versions
	 */
	public static List<CdsDemandVersion> findAll(
		int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cds demand versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cds demand versions
	 */
	public static List<CdsDemandVersion> findAll(
		int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cds demand versions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cds demand versions.
	 *
	 * @return the number of cds demand versions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CdsDemandVersionPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CdsDemandVersionPersistence _persistence;

}