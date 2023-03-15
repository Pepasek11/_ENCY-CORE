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

import cz.csob.ency.cds.demands.exception.NoSuchCdsDemandGdprInfoException;
import cz.csob.ency.cds.demands.model.CdsDemandGdprInfo;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cds demand gdpr info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see CdsDemandGdprInfoUtil
 * @generated
 */
@ProviderType
public interface CdsDemandGdprInfoPersistence
	extends BasePersistence<CdsDemandGdprInfo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CdsDemandGdprInfoUtil} to access the cds demand gdpr info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cds demand gdpr infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cds demand gdpr infos
	 */
	public java.util.List<CdsDemandGdprInfo> findByUuid(String uuid);

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
	public java.util.List<CdsDemandGdprInfo> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CdsDemandGdprInfo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandGdprInfo>
			orderByComparator);

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
	public java.util.List<CdsDemandGdprInfo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandGdprInfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cds demand gdpr info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand gdpr info
	 * @throws NoSuchCdsDemandGdprInfoException if a matching cds demand gdpr info could not be found
	 */
	public CdsDemandGdprInfo findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandGdprInfo>
				orderByComparator)
		throws NoSuchCdsDemandGdprInfoException;

	/**
	 * Returns the first cds demand gdpr info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand gdpr info, or <code>null</code> if a matching cds demand gdpr info could not be found
	 */
	public CdsDemandGdprInfo fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandGdprInfo>
			orderByComparator);

	/**
	 * Returns the last cds demand gdpr info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand gdpr info
	 * @throws NoSuchCdsDemandGdprInfoException if a matching cds demand gdpr info could not be found
	 */
	public CdsDemandGdprInfo findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandGdprInfo>
				orderByComparator)
		throws NoSuchCdsDemandGdprInfoException;

	/**
	 * Returns the last cds demand gdpr info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand gdpr info, or <code>null</code> if a matching cds demand gdpr info could not be found
	 */
	public CdsDemandGdprInfo fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandGdprInfo>
			orderByComparator);

	/**
	 * Returns the cds demand gdpr infos before and after the current cds demand gdpr info in the ordered set where uuid = &#63;.
	 *
	 * @param gdprInfoId the primary key of the current cds demand gdpr info
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand gdpr info
	 * @throws NoSuchCdsDemandGdprInfoException if a cds demand gdpr info with the primary key could not be found
	 */
	public CdsDemandGdprInfo[] findByUuid_PrevAndNext(
			long gdprInfoId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandGdprInfo>
				orderByComparator)
		throws NoSuchCdsDemandGdprInfoException;

	/**
	 * Removes all the cds demand gdpr infos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of cds demand gdpr infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cds demand gdpr infos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the cds demand gdpr infos where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @return the matching cds demand gdpr infos
	 */
	public java.util.List<CdsDemandGdprInfo> findBydemandId(long demandId);

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
	public java.util.List<CdsDemandGdprInfo> findBydemandId(
		long demandId, int start, int end);

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
	public java.util.List<CdsDemandGdprInfo> findBydemandId(
		long demandId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandGdprInfo>
			orderByComparator);

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
	public java.util.List<CdsDemandGdprInfo> findBydemandId(
		long demandId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandGdprInfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cds demand gdpr info in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand gdpr info
	 * @throws NoSuchCdsDemandGdprInfoException if a matching cds demand gdpr info could not be found
	 */
	public CdsDemandGdprInfo findBydemandId_First(
			long demandId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandGdprInfo>
				orderByComparator)
		throws NoSuchCdsDemandGdprInfoException;

	/**
	 * Returns the first cds demand gdpr info in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand gdpr info, or <code>null</code> if a matching cds demand gdpr info could not be found
	 */
	public CdsDemandGdprInfo fetchBydemandId_First(
		long demandId,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandGdprInfo>
			orderByComparator);

	/**
	 * Returns the last cds demand gdpr info in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand gdpr info
	 * @throws NoSuchCdsDemandGdprInfoException if a matching cds demand gdpr info could not be found
	 */
	public CdsDemandGdprInfo findBydemandId_Last(
			long demandId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandGdprInfo>
				orderByComparator)
		throws NoSuchCdsDemandGdprInfoException;

	/**
	 * Returns the last cds demand gdpr info in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand gdpr info, or <code>null</code> if a matching cds demand gdpr info could not be found
	 */
	public CdsDemandGdprInfo fetchBydemandId_Last(
		long demandId,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandGdprInfo>
			orderByComparator);

	/**
	 * Returns the cds demand gdpr infos before and after the current cds demand gdpr info in the ordered set where demandId = &#63;.
	 *
	 * @param gdprInfoId the primary key of the current cds demand gdpr info
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand gdpr info
	 * @throws NoSuchCdsDemandGdprInfoException if a cds demand gdpr info with the primary key could not be found
	 */
	public CdsDemandGdprInfo[] findBydemandId_PrevAndNext(
			long gdprInfoId, long demandId,
			com.liferay.portal.kernel.util.OrderByComparator<CdsDemandGdprInfo>
				orderByComparator)
		throws NoSuchCdsDemandGdprInfoException;

	/**
	 * Removes all the cds demand gdpr infos where demandId = &#63; from the database.
	 *
	 * @param demandId the demand ID
	 */
	public void removeBydemandId(long demandId);

	/**
	 * Returns the number of cds demand gdpr infos where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @return the number of matching cds demand gdpr infos
	 */
	public int countBydemandId(long demandId);

	/**
	 * Caches the cds demand gdpr info in the entity cache if it is enabled.
	 *
	 * @param cdsDemandGdprInfo the cds demand gdpr info
	 */
	public void cacheResult(CdsDemandGdprInfo cdsDemandGdprInfo);

	/**
	 * Caches the cds demand gdpr infos in the entity cache if it is enabled.
	 *
	 * @param cdsDemandGdprInfos the cds demand gdpr infos
	 */
	public void cacheResult(
		java.util.List<CdsDemandGdprInfo> cdsDemandGdprInfos);

	/**
	 * Creates a new cds demand gdpr info with the primary key. Does not add the cds demand gdpr info to the database.
	 *
	 * @param gdprInfoId the primary key for the new cds demand gdpr info
	 * @return the new cds demand gdpr info
	 */
	public CdsDemandGdprInfo create(long gdprInfoId);

	/**
	 * Removes the cds demand gdpr info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gdprInfoId the primary key of the cds demand gdpr info
	 * @return the cds demand gdpr info that was removed
	 * @throws NoSuchCdsDemandGdprInfoException if a cds demand gdpr info with the primary key could not be found
	 */
	public CdsDemandGdprInfo remove(long gdprInfoId)
		throws NoSuchCdsDemandGdprInfoException;

	public CdsDemandGdprInfo updateImpl(CdsDemandGdprInfo cdsDemandGdprInfo);

	/**
	 * Returns the cds demand gdpr info with the primary key or throws a <code>NoSuchCdsDemandGdprInfoException</code> if it could not be found.
	 *
	 * @param gdprInfoId the primary key of the cds demand gdpr info
	 * @return the cds demand gdpr info
	 * @throws NoSuchCdsDemandGdprInfoException if a cds demand gdpr info with the primary key could not be found
	 */
	public CdsDemandGdprInfo findByPrimaryKey(long gdprInfoId)
		throws NoSuchCdsDemandGdprInfoException;

	/**
	 * Returns the cds demand gdpr info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param gdprInfoId the primary key of the cds demand gdpr info
	 * @return the cds demand gdpr info, or <code>null</code> if a cds demand gdpr info with the primary key could not be found
	 */
	public CdsDemandGdprInfo fetchByPrimaryKey(long gdprInfoId);

	/**
	 * Returns all the cds demand gdpr infos.
	 *
	 * @return the cds demand gdpr infos
	 */
	public java.util.List<CdsDemandGdprInfo> findAll();

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
	public java.util.List<CdsDemandGdprInfo> findAll(int start, int end);

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
	public java.util.List<CdsDemandGdprInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandGdprInfo>
			orderByComparator);

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
	public java.util.List<CdsDemandGdprInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CdsDemandGdprInfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cds demand gdpr infos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cds demand gdpr infos.
	 *
	 * @return the number of cds demand gdpr infos
	 */
	public int countAll();

}