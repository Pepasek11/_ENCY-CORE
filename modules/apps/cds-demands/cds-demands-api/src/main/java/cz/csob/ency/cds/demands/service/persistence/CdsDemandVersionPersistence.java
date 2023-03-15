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

import cz.csob.ency.cds.demands.exception.NoSuchCdsDemandVersionException;
import cz.csob.ency.cds.demands.model.CdsDemandVersion;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cds demand version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see CdsDemandVersionUtil
 * @generated
 */
@ProviderType
public interface CdsDemandVersionPersistence
	extends BasePersistence<CdsDemandVersion> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CdsDemandVersionUtil} to access the cds demand version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cds demand versions where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @return the matching cds demand versions
	 */
	public java.util.List<CdsDemandVersion> findByDemandId(long demandId);

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
	public java.util.List<CdsDemandVersion> findByDemandId(
		long demandId, int start, int end);

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
	public java.util.List<CdsDemandVersion> findByDemandId(
		long demandId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

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
	public java.util.List<CdsDemandVersion> findByDemandId(
		long demandId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cds demand version in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public CdsDemandVersion findByDemandId_First(
			long demandId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the first cds demand version in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByDemandId_First(
		long demandId,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

	/**
	 * Returns the last cds demand version in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public CdsDemandVersion findByDemandId_Last(
			long demandId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the last cds demand version in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByDemandId_Last(
		long demandId,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where demandId = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	public CdsDemandVersion[] findByDemandId_PrevAndNext(
			long cdsDemandVersionId, long demandId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Removes all the cds demand versions where demandId = &#63; from the database.
	 *
	 * @param demandId the demand ID
	 */
	public void removeByDemandId(long demandId);

	/**
	 * Returns the number of cds demand versions where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @return the number of matching cds demand versions
	 */
	public int countByDemandId(long demandId);

	/**
	 * Returns the cds demand version where demandId = &#63; and version = &#63; or throws a <code>NoSuchCdsDemandVersionException</code> if it could not be found.
	 *
	 * @param demandId the demand ID
	 * @param version the version
	 * @return the matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public CdsDemandVersion findByDemandId_Version(long demandId, int version)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the cds demand version where demandId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param demandId the demand ID
	 * @param version the version
	 * @return the matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByDemandId_Version(long demandId, int version);

	/**
	 * Returns the cds demand version where demandId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param demandId the demand ID
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByDemandId_Version(
		long demandId, int version, boolean useFinderCache);

	/**
	 * Removes the cds demand version where demandId = &#63; and version = &#63; from the database.
	 *
	 * @param demandId the demand ID
	 * @param version the version
	 * @return the cds demand version that was removed
	 */
	public CdsDemandVersion removeByDemandId_Version(long demandId, int version)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the number of cds demand versions where demandId = &#63; and version = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param version the version
	 * @return the number of matching cds demand versions
	 */
	public int countByDemandId_Version(long demandId, int version);

	/**
	 * Returns all the cds demand versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cds demand versions
	 */
	public java.util.List<CdsDemandVersion> findByUuid(String uuid);

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
	public java.util.List<CdsDemandVersion> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CdsDemandVersion> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

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
	public java.util.List<CdsDemandVersion> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public CdsDemandVersion findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public CdsDemandVersion findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	public CdsDemandVersion[] findByUuid_PrevAndNext(
			long cdsDemandVersionId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Removes all the cds demand versions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of cds demand versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cds demand versions
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the cds demand versions where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the matching cds demand versions
	 */
	public java.util.List<CdsDemandVersion> findByUuid_Version(
		String uuid, int version);

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
	public java.util.List<CdsDemandVersion> findByUuid_Version(
		String uuid, int version, int start, int end);

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
	public java.util.List<CdsDemandVersion> findByUuid_Version(
		String uuid, int version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

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
	public java.util.List<CdsDemandVersion> findByUuid_Version(
		String uuid, int version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public CdsDemandVersion findByUuid_Version_First(
			String uuid, int version,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByUuid_Version_First(
		String uuid, int version,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public CdsDemandVersion findByUuid_Version_Last(
			String uuid, int version,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByUuid_Version_Last(
		String uuid, int version,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

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
	public CdsDemandVersion[] findByUuid_Version_PrevAndNext(
			long cdsDemandVersionId, String uuid, int version,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Removes all the cds demand versions where uuid = &#63; and version = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 */
	public void removeByUuid_Version(String uuid, int version);

	/**
	 * Returns the number of cds demand versions where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the number of matching cds demand versions
	 */
	public int countByUuid_Version(String uuid, int version);

	/**
	 * Returns all the cds demand versions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cds demand versions
	 */
	public java.util.List<CdsDemandVersion> findByUUID_G(
		String uuid, long groupId);

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
	public java.util.List<CdsDemandVersion> findByUUID_G(
		String uuid, long groupId, int start, int end);

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
	public java.util.List<CdsDemandVersion> findByUUID_G(
		String uuid, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

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
	public java.util.List<CdsDemandVersion> findByUUID_G(
		String uuid, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public CdsDemandVersion findByUUID_G_First(
			String uuid, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByUUID_G_First(
		String uuid, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public CdsDemandVersion findByUUID_G_Last(
			String uuid, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByUUID_G_Last(
		String uuid, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

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
	public CdsDemandVersion[] findByUUID_G_PrevAndNext(
			long cdsDemandVersionId, String uuid, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Removes all the cds demand versions where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 */
	public void removeByUUID_G(String uuid, long groupId);

	/**
	 * Returns the number of cds demand versions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching cds demand versions
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns the cds demand version where uuid = &#63; and groupId = &#63; and version = &#63; or throws a <code>NoSuchCdsDemandVersionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public CdsDemandVersion findByUUID_G_Version(
			String uuid, long groupId, int version)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the cds demand version where uuid = &#63; and groupId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByUUID_G_Version(
		String uuid, long groupId, int version);

	/**
	 * Returns the cds demand version where uuid = &#63; and groupId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByUUID_G_Version(
		String uuid, long groupId, int version, boolean useFinderCache);

	/**
	 * Removes the cds demand version where uuid = &#63; and groupId = &#63; and version = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the cds demand version that was removed
	 */
	public CdsDemandVersion removeByUUID_G_Version(
			String uuid, long groupId, int version)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the number of cds demand versions where uuid = &#63; and groupId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the number of matching cds demand versions
	 */
	public int countByUUID_G_Version(String uuid, long groupId, int version);

	/**
	 * Returns all the cds demand versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching cds demand versions
	 */
	public java.util.List<CdsDemandVersion> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<CdsDemandVersion> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<CdsDemandVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

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
	public java.util.List<CdsDemandVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public CdsDemandVersion findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public CdsDemandVersion findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

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
	public CdsDemandVersion[] findByUuid_C_PrevAndNext(
			long cdsDemandVersionId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Removes all the cds demand versions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of cds demand versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching cds demand versions
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the cds demand versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @return the matching cds demand versions
	 */
	public java.util.List<CdsDemandVersion> findByUuid_C_Version(
		String uuid, long companyId, int version);

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
	public java.util.List<CdsDemandVersion> findByUuid_C_Version(
		String uuid, long companyId, int version, int start, int end);

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
	public java.util.List<CdsDemandVersion> findByUuid_C_Version(
		String uuid, long companyId, int version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

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
	public java.util.List<CdsDemandVersion> findByUuid_C_Version(
		String uuid, long companyId, int version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator,
		boolean useFinderCache);

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
	public CdsDemandVersion findByUuid_C_Version_First(
			String uuid, long companyId, int version,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByUuid_C_Version_First(
		String uuid, long companyId, int version,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

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
	public CdsDemandVersion findByUuid_C_Version_Last(
			String uuid, long companyId, int version,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByUuid_C_Version_Last(
		String uuid, long companyId, int version,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

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
	public CdsDemandVersion[] findByUuid_C_Version_PrevAndNext(
			long cdsDemandVersionId, String uuid, long companyId, int version,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Removes all the cds demand versions where uuid = &#63; and companyId = &#63; and version = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 */
	public void removeByUuid_C_Version(
		String uuid, long companyId, int version);

	/**
	 * Returns the number of cds demand versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @return the number of matching cds demand versions
	 */
	public int countByUuid_C_Version(String uuid, long companyId, int version);

	/**
	 * Returns all the cds demand versions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching cds demand versions
	 */
	public java.util.List<CdsDemandVersion> findByUserId(long userId);

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
	public java.util.List<CdsDemandVersion> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<CdsDemandVersion> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

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
	public java.util.List<CdsDemandVersion> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cds demand version in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public CdsDemandVersion findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the first cds demand version in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

	/**
	 * Returns the last cds demand version in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public CdsDemandVersion findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the last cds demand version in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where userId = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	public CdsDemandVersion[] findByUserId_PrevAndNext(
			long cdsDemandVersionId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Removes all the cds demand versions where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of cds demand versions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching cds demand versions
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the cds demand versions where userId = &#63; and version = &#63;.
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @return the matching cds demand versions
	 */
	public java.util.List<CdsDemandVersion> findByUserId_Version(
		long userId, int version);

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
	public java.util.List<CdsDemandVersion> findByUserId_Version(
		long userId, int version, int start, int end);

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
	public java.util.List<CdsDemandVersion> findByUserId_Version(
		long userId, int version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

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
	public java.util.List<CdsDemandVersion> findByUserId_Version(
		long userId, int version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cds demand version in the ordered set where userId = &#63; and version = &#63;.
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public CdsDemandVersion findByUserId_Version_First(
			long userId, int version,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the first cds demand version in the ordered set where userId = &#63; and version = &#63;.
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByUserId_Version_First(
		long userId, int version,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

	/**
	 * Returns the last cds demand version in the ordered set where userId = &#63; and version = &#63;.
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public CdsDemandVersion findByUserId_Version_Last(
			long userId, int version,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the last cds demand version in the ordered set where userId = &#63; and version = &#63;.
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByUserId_Version_Last(
		long userId, int version,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

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
	public CdsDemandVersion[] findByUserId_Version_PrevAndNext(
			long cdsDemandVersionId, long userId, int version,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Removes all the cds demand versions where userId = &#63; and version = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param version the version
	 */
	public void removeByUserId_Version(long userId, int version);

	/**
	 * Returns the number of cds demand versions where userId = &#63; and version = &#63;.
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @return the number of matching cds demand versions
	 */
	public int countByUserId_Version(long userId, int version);

	/**
	 * Returns all the cds demand versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cds demand versions
	 */
	public java.util.List<CdsDemandVersion> findByXid(String uuid);

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
	public java.util.List<CdsDemandVersion> findByXid(
		String uuid, int start, int end);

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
	public java.util.List<CdsDemandVersion> findByXid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

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
	public java.util.List<CdsDemandVersion> findByXid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public CdsDemandVersion findByXid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByXid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public CdsDemandVersion findByXid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByXid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	public CdsDemandVersion[] findByXid_PrevAndNext(
			long cdsDemandVersionId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Removes all the cds demand versions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByXid(String uuid);

	/**
	 * Returns the number of cds demand versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cds demand versions
	 */
	public int countByXid(String uuid);

	/**
	 * Returns the cds demand version where uuid = &#63; and version = &#63; or throws a <code>NoSuchCdsDemandVersionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public CdsDemandVersion findByXid_Version(String uuid, int version)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the cds demand version where uuid = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByXid_Version(String uuid, int version);

	/**
	 * Returns the cds demand version where uuid = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByXid_Version(
		String uuid, int version, boolean useFinderCache);

	/**
	 * Removes the cds demand version where uuid = &#63; and version = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the cds demand version that was removed
	 */
	public CdsDemandVersion removeByXid_Version(String uuid, int version)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the number of cds demand versions where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the number of matching cds demand versions
	 */
	public int countByXid_Version(String uuid, int version);

	/**
	 * Returns all the cds demand versions where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @return the matching cds demand versions
	 */
	public java.util.List<CdsDemandVersion> findByDI(long domainId);

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
	public java.util.List<CdsDemandVersion> findByDI(
		long domainId, int start, int end);

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
	public java.util.List<CdsDemandVersion> findByDI(
		long domainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

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
	public java.util.List<CdsDemandVersion> findByDI(
		long domainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cds demand version in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public CdsDemandVersion findByDI_First(
			long domainId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the first cds demand version in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByDI_First(
		long domainId,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

	/**
	 * Returns the last cds demand version in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public CdsDemandVersion findByDI_Last(
			long domainId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the last cds demand version in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByDI_Last(
		long domainId,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where domainId = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	public CdsDemandVersion[] findByDI_PrevAndNext(
			long cdsDemandVersionId, long domainId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Removes all the cds demand versions where domainId = &#63; from the database.
	 *
	 * @param domainId the domain ID
	 */
	public void removeByDI(long domainId);

	/**
	 * Returns the number of cds demand versions where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @return the number of matching cds demand versions
	 */
	public int countByDI(long domainId);

	/**
	 * Returns all the cds demand versions where domainId = &#63; and version = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @return the matching cds demand versions
	 */
	public java.util.List<CdsDemandVersion> findByDI_Version(
		long domainId, int version);

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
	public java.util.List<CdsDemandVersion> findByDI_Version(
		long domainId, int version, int start, int end);

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
	public java.util.List<CdsDemandVersion> findByDI_Version(
		long domainId, int version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

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
	public java.util.List<CdsDemandVersion> findByDI_Version(
		long domainId, int version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cds demand version in the ordered set where domainId = &#63; and version = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public CdsDemandVersion findByDI_Version_First(
			long domainId, int version,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the first cds demand version in the ordered set where domainId = &#63; and version = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByDI_Version_First(
		long domainId, int version,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

	/**
	 * Returns the last cds demand version in the ordered set where domainId = &#63; and version = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	public CdsDemandVersion findByDI_Version_Last(
			long domainId, int version,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the last cds demand version in the ordered set where domainId = &#63; and version = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	public CdsDemandVersion fetchByDI_Version_Last(
		long domainId, int version,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

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
	public CdsDemandVersion[] findByDI_Version_PrevAndNext(
			long cdsDemandVersionId, long domainId, int version,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
				orderByComparator)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Removes all the cds demand versions where domainId = &#63; and version = &#63; from the database.
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 */
	public void removeByDI_Version(long domainId, int version);

	/**
	 * Returns the number of cds demand versions where domainId = &#63; and version = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @return the number of matching cds demand versions
	 */
	public int countByDI_Version(long domainId, int version);

	/**
	 * Caches the cds demand version in the entity cache if it is enabled.
	 *
	 * @param cdsDemandVersion the cds demand version
	 */
	public void cacheResult(CdsDemandVersion cdsDemandVersion);

	/**
	 * Caches the cds demand versions in the entity cache if it is enabled.
	 *
	 * @param cdsDemandVersions the cds demand versions
	 */
	public void cacheResult(java.util.List<CdsDemandVersion> cdsDemandVersions);

	/**
	 * Creates a new cds demand version with the primary key. Does not add the cds demand version to the database.
	 *
	 * @param cdsDemandVersionId the primary key for the new cds demand version
	 * @return the new cds demand version
	 */
	public CdsDemandVersion create(long cdsDemandVersionId);

	/**
	 * Removes the cds demand version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cdsDemandVersionId the primary key of the cds demand version
	 * @return the cds demand version that was removed
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	public CdsDemandVersion remove(long cdsDemandVersionId)
		throws NoSuchCdsDemandVersionException;

	public CdsDemandVersion updateImpl(CdsDemandVersion cdsDemandVersion);

	/**
	 * Returns the cds demand version with the primary key or throws a <code>NoSuchCdsDemandVersionException</code> if it could not be found.
	 *
	 * @param cdsDemandVersionId the primary key of the cds demand version
	 * @return the cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	public CdsDemandVersion findByPrimaryKey(long cdsDemandVersionId)
		throws NoSuchCdsDemandVersionException;

	/**
	 * Returns the cds demand version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cdsDemandVersionId the primary key of the cds demand version
	 * @return the cds demand version, or <code>null</code> if a cds demand version with the primary key could not be found
	 */
	public CdsDemandVersion fetchByPrimaryKey(long cdsDemandVersionId);

	/**
	 * Returns all the cds demand versions.
	 *
	 * @return the cds demand versions
	 */
	public java.util.List<CdsDemandVersion> findAll();

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
	public java.util.List<CdsDemandVersion> findAll(int start, int end);

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
	public java.util.List<CdsDemandVersion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator);

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
	public java.util.List<CdsDemandVersion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cds demand versions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cds demand versions.
	 *
	 * @return the number of cds demand versions
	 */
	public int countAll();

}