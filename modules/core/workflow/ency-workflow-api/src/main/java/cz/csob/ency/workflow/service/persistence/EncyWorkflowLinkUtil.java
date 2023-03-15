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

package cz.csob.ency.workflow.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import cz.csob.ency.workflow.model.EncyWorkflowLink;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the ency workflow link service. This utility wraps <code>cz.csob.ency.workflow.service.persistence.impl.EncyWorkflowLinkPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowLinkPersistence
 * @generated
 */
public class EncyWorkflowLinkUtil {

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
	public static void clearCache(EncyWorkflowLink encyWorkflowLink) {
		getPersistence().clearCache(encyWorkflowLink);
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
	public static Map<Serializable, EncyWorkflowLink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EncyWorkflowLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EncyWorkflowLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EncyWorkflowLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EncyWorkflowLink update(EncyWorkflowLink encyWorkflowLink) {
		return getPersistence().update(encyWorkflowLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EncyWorkflowLink update(
		EncyWorkflowLink encyWorkflowLink, ServiceContext serviceContext) {

		return getPersistence().update(encyWorkflowLink, serviceContext);
	}

	/**
	 * Returns all the ency workflow links where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the ency workflow links where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ency workflow link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink findByUuid_First(
			String uuid, OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first ency workflow link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink fetchByUuid_First(
		String uuid, OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last ency workflow link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink findByUuid_Last(
			String uuid, OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last ency workflow link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink fetchByUuid_Last(
		String uuid, OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the ency workflow links before and after the current ency workflow link in the ordered set where uuid = &#63;.
	 *
	 * @param workflowLinkId the primary key of the current ency workflow link
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow link
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	public static EncyWorkflowLink[] findByUuid_PrevAndNext(
			long workflowLinkId, String uuid,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().findByUuid_PrevAndNext(
			workflowLinkId, uuid, orderByComparator);
	}

	/**
	 * Removes all the ency workflow links where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of ency workflow links where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ency workflow links
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the ency workflow link where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLinkException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink findByUUID_G(String uuid, long groupId)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ency workflow link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ency workflow link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the ency workflow link where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ency workflow link that was removed
	 */
	public static EncyWorkflowLink removeByUUID_G(String uuid, long groupId)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of ency workflow links where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ency workflow links
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the ency workflow links where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the ency workflow links where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ency workflow link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first ency workflow link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the ency workflow links before and after the current ency workflow link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param workflowLinkId the primary key of the current ency workflow link
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow link
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	public static EncyWorkflowLink[] findByUuid_C_PrevAndNext(
			long workflowLinkId, String uuid, long companyId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().findByUuid_C_PrevAndNext(
			workflowLinkId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the ency workflow links where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of ency workflow links where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ency workflow links
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the ency workflow links where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByCompanyId(long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	 * Returns a range of all the ency workflow links where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByCompanyId(
		long companyId, int start, int end) {

		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ency workflow link in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink findByCompanyId_First(
			long companyId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().findByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first ency workflow link in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink fetchByCompanyId_First(
		long companyId, OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().fetchByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow link in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink findByCompanyId_Last(
			long companyId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().findByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow link in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink fetchByCompanyId_Last(
		long companyId, OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().fetchByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the ency workflow links before and after the current ency workflow link in the ordered set where companyId = &#63;.
	 *
	 * @param workflowLinkId the primary key of the current ency workflow link
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow link
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	public static EncyWorkflowLink[] findByCompanyId_PrevAndNext(
			long workflowLinkId, long companyId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().findByCompanyId_PrevAndNext(
			workflowLinkId, companyId, orderByComparator);
	}

	/**
	 * Removes all the ency workflow links where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	 * Returns the number of ency workflow links where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching ency workflow links
	 */
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	 * Returns all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @return the matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByG_C_C(
		long groupId, long companyId, String className) {

		return getPersistence().findByG_C_C(groupId, companyId, className);
	}

	/**
	 * Returns a range of all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByG_C_C(
		long groupId, long companyId, String className, int start, int end) {

		return getPersistence().findByG_C_C(
			groupId, companyId, className, start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByG_C_C(
		long groupId, long companyId, String className, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().findByG_C_C(
			groupId, companyId, className, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByG_C_C(
		long groupId, long companyId, String className, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_C_C(
			groupId, companyId, className, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first ency workflow link in the ordered set where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink findByG_C_C_First(
			long groupId, long companyId, String className,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().findByG_C_C_First(
			groupId, companyId, className, orderByComparator);
	}

	/**
	 * Returns the first ency workflow link in the ordered set where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink fetchByG_C_C_First(
		long groupId, long companyId, String className,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().fetchByG_C_C_First(
			groupId, companyId, className, orderByComparator);
	}

	/**
	 * Returns the last ency workflow link in the ordered set where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink findByG_C_C_Last(
			long groupId, long companyId, String className,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().findByG_C_C_Last(
			groupId, companyId, className, orderByComparator);
	}

	/**
	 * Returns the last ency workflow link in the ordered set where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink fetchByG_C_C_Last(
		long groupId, long companyId, String className,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().fetchByG_C_C_Last(
			groupId, companyId, className, orderByComparator);
	}

	/**
	 * Returns the ency workflow links before and after the current ency workflow link in the ordered set where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * @param workflowLinkId the primary key of the current ency workflow link
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow link
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	public static EncyWorkflowLink[] findByG_C_C_PrevAndNext(
			long workflowLinkId, long groupId, long companyId, String className,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().findByG_C_C_PrevAndNext(
			workflowLinkId, groupId, companyId, className, orderByComparator);
	}

	/**
	 * Returns all the ency workflow links where groupId = any &#63; and companyId = any &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param companyIds the company IDs
	 * @param className the class name
	 * @return the matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByG_C_C(
		long[] groupIds, long[] companyIds, String className) {

		return getPersistence().findByG_C_C(groupIds, companyIds, className);
	}

	/**
	 * Returns a range of all the ency workflow links where groupId = any &#63; and companyId = any &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param companyIds the company IDs
	 * @param className the class name
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByG_C_C(
		long[] groupIds, long[] companyIds, String className, int start,
		int end) {

		return getPersistence().findByG_C_C(
			groupIds, companyIds, className, start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where groupId = any &#63; and companyId = any &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param companyIds the company IDs
	 * @param className the class name
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByG_C_C(
		long[] groupIds, long[] companyIds, String className, int start,
		int end, OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().findByG_C_C(
			groupIds, companyIds, className, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByG_C_C(
		long[] groupIds, long[] companyIds, String className, int start,
		int end, OrderByComparator<EncyWorkflowLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_C_C(
			groupIds, companyIds, className, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 */
	public static void removeByG_C_C(
		long groupId, long companyId, String className) {

		getPersistence().removeByG_C_C(groupId, companyId, className);
	}

	/**
	 * Returns the number of ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @return the number of matching ency workflow links
	 */
	public static int countByG_C_C(
		long groupId, long companyId, String className) {

		return getPersistence().countByG_C_C(groupId, companyId, className);
	}

	/**
	 * Returns the number of ency workflow links where groupId = any &#63; and companyId = any &#63; and className = &#63;.
	 *
	 * @param groupIds the group IDs
	 * @param companyIds the company IDs
	 * @param className the class name
	 * @return the number of matching ency workflow links
	 */
	public static int countByG_C_C(
		long[] groupIds, long[] companyIds, String className) {

		return getPersistence().countByG_C_C(groupIds, companyIds, className);
	}

	/**
	 * Returns all the ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @return the matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByC_I(
		long companyId, long workflowId) {

		return getPersistence().findByC_I(companyId, workflowId);
	}

	/**
	 * Returns a range of all the ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByC_I(
		long companyId, long workflowId, int start, int end) {

		return getPersistence().findByC_I(companyId, workflowId, start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByC_I(
		long companyId, long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().findByC_I(
			companyId, workflowId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByC_I(
		long companyId, long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_I(
			companyId, workflowId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink findByC_I_First(
			long companyId, long workflowId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().findByC_I_First(
			companyId, workflowId, orderByComparator);
	}

	/**
	 * Returns the first ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink fetchByC_I_First(
		long companyId, long workflowId,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().fetchByC_I_First(
			companyId, workflowId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink findByC_I_Last(
			long companyId, long workflowId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().findByC_I_Last(
			companyId, workflowId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink fetchByC_I_Last(
		long companyId, long workflowId,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().fetchByC_I_Last(
			companyId, workflowId, orderByComparator);
	}

	/**
	 * Returns the ency workflow links before and after the current ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param workflowLinkId the primary key of the current ency workflow link
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow link
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	public static EncyWorkflowLink[] findByC_I_PrevAndNext(
			long workflowLinkId, long companyId, long workflowId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().findByC_I_PrevAndNext(
			workflowLinkId, companyId, workflowId, orderByComparator);
	}

	/**
	 * Returns all the ency workflow links where companyId = any &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyIds the company IDs
	 * @param workflowId the workflow ID
	 * @return the matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByC_I(
		long[] companyIds, long workflowId) {

		return getPersistence().findByC_I(companyIds, workflowId);
	}

	/**
	 * Returns a range of all the ency workflow links where companyId = any &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyIds the company IDs
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByC_I(
		long[] companyIds, long workflowId, int start, int end) {

		return getPersistence().findByC_I(companyIds, workflowId, start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where companyId = any &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyIds the company IDs
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByC_I(
		long[] companyIds, long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().findByC_I(
			companyIds, workflowId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where companyId = &#63; and workflowId = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByC_I(
		long[] companyIds, long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_I(
			companyIds, workflowId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the ency workflow links where companyId = &#63; and workflowId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 */
	public static void removeByC_I(long companyId, long workflowId) {
		getPersistence().removeByC_I(companyId, workflowId);
	}

	/**
	 * Returns the number of ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @return the number of matching ency workflow links
	 */
	public static int countByC_I(long companyId, long workflowId) {
		return getPersistence().countByC_I(companyId, workflowId);
	}

	/**
	 * Returns the number of ency workflow links where companyId = any &#63; and workflowId = &#63;.
	 *
	 * @param companyIds the company IDs
	 * @param workflowId the workflow ID
	 * @return the number of matching ency workflow links
	 */
	public static int countByC_I(long[] companyIds, long workflowId) {
		return getPersistence().countByC_I(companyIds, workflowId);
	}

	/**
	 * Returns all the ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @return the matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByWorkflowId(
		long companyId, long workflowId) {

		return getPersistence().findByWorkflowId(companyId, workflowId);
	}

	/**
	 * Returns a range of all the ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByWorkflowId(
		long companyId, long workflowId, int start, int end) {

		return getPersistence().findByWorkflowId(
			companyId, workflowId, start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByWorkflowId(
		long companyId, long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().findByWorkflowId(
			companyId, workflowId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByWorkflowId(
		long companyId, long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByWorkflowId(
			companyId, workflowId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink findByWorkflowId_First(
			long companyId, long workflowId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().findByWorkflowId_First(
			companyId, workflowId, orderByComparator);
	}

	/**
	 * Returns the first ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink fetchByWorkflowId_First(
		long companyId, long workflowId,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().fetchByWorkflowId_First(
			companyId, workflowId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink findByWorkflowId_Last(
			long companyId, long workflowId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().findByWorkflowId_Last(
			companyId, workflowId, orderByComparator);
	}

	/**
	 * Returns the last ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink fetchByWorkflowId_Last(
		long companyId, long workflowId,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().fetchByWorkflowId_Last(
			companyId, workflowId, orderByComparator);
	}

	/**
	 * Returns the ency workflow links before and after the current ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param workflowLinkId the primary key of the current ency workflow link
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow link
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	public static EncyWorkflowLink[] findByWorkflowId_PrevAndNext(
			long workflowLinkId, long companyId, long workflowId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().findByWorkflowId_PrevAndNext(
			workflowLinkId, companyId, workflowId, orderByComparator);
	}

	/**
	 * Returns all the ency workflow links where companyId = any &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyIds the company IDs
	 * @param workflowId the workflow ID
	 * @return the matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByWorkflowId(
		long[] companyIds, long workflowId) {

		return getPersistence().findByWorkflowId(companyIds, workflowId);
	}

	/**
	 * Returns a range of all the ency workflow links where companyId = any &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyIds the company IDs
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByWorkflowId(
		long[] companyIds, long workflowId, int start, int end) {

		return getPersistence().findByWorkflowId(
			companyIds, workflowId, start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where companyId = any &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyIds the company IDs
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByWorkflowId(
		long[] companyIds, long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().findByWorkflowId(
			companyIds, workflowId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where companyId = &#63; and workflowId = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByWorkflowId(
		long[] companyIds, long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByWorkflowId(
			companyIds, workflowId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the ency workflow links where companyId = &#63; and workflowId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 */
	public static void removeByWorkflowId(long companyId, long workflowId) {
		getPersistence().removeByWorkflowId(companyId, workflowId);
	}

	/**
	 * Returns the number of ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @return the number of matching ency workflow links
	 */
	public static int countByWorkflowId(long companyId, long workflowId) {
		return getPersistence().countByWorkflowId(companyId, workflowId);
	}

	/**
	 * Returns the number of ency workflow links where companyId = any &#63; and workflowId = &#63;.
	 *
	 * @param companyIds the company IDs
	 * @param workflowId the workflow ID
	 * @return the number of matching ency workflow links
	 */
	public static int countByWorkflowId(long[] companyIds, long workflowId) {
		return getPersistence().countByWorkflowId(companyIds, workflowId);
	}

	/**
	 * Returns all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 * @return the matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByG_C_C_F_F(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK) {

		return getPersistence().findByG_C_C_F_F(
			groupId, companyId, className, folderClassName, folderPK);
	}

	/**
	 * Returns a range of all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByG_C_C_F_F(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK, int start, int end) {

		return getPersistence().findByG_C_C_F_F(
			groupId, companyId, className, folderClassName, folderPK, start,
			end);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByG_C_C_F_F(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().findByG_C_C_F_F(
			groupId, companyId, className, folderClassName, folderPK, start,
			end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByG_C_C_F_F(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_C_C_F_F(
			groupId, companyId, className, folderClassName, folderPK, start,
			end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ency workflow link in the ordered set where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink findByG_C_C_F_F_First(
			long groupId, long companyId, String className,
			String folderClassName, long folderPK,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().findByG_C_C_F_F_First(
			groupId, companyId, className, folderClassName, folderPK,
			orderByComparator);
	}

	/**
	 * Returns the first ency workflow link in the ordered set where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink fetchByG_C_C_F_F_First(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK, OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().fetchByG_C_C_F_F_First(
			groupId, companyId, className, folderClassName, folderPK,
			orderByComparator);
	}

	/**
	 * Returns the last ency workflow link in the ordered set where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink findByG_C_C_F_F_Last(
			long groupId, long companyId, String className,
			String folderClassName, long folderPK,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().findByG_C_C_F_F_Last(
			groupId, companyId, className, folderClassName, folderPK,
			orderByComparator);
	}

	/**
	 * Returns the last ency workflow link in the ordered set where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink fetchByG_C_C_F_F_Last(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK, OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().fetchByG_C_C_F_F_Last(
			groupId, companyId, className, folderClassName, folderPK,
			orderByComparator);
	}

	/**
	 * Returns the ency workflow links before and after the current ency workflow link in the ordered set where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63;.
	 *
	 * @param workflowLinkId the primary key of the current ency workflow link
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow link
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	public static EncyWorkflowLink[] findByG_C_C_F_F_PrevAndNext(
			long workflowLinkId, long groupId, long companyId, String className,
			String folderClassName, long folderPK,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().findByG_C_C_F_F_PrevAndNext(
			workflowLinkId, groupId, companyId, className, folderClassName,
			folderPK, orderByComparator);
	}

	/**
	 * Returns all the ency workflow links where groupId = any &#63; and companyId = any &#63; and className = &#63; and folderClassName = any &#63; and folderPK = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param companyIds the company IDs
	 * @param className the class name
	 * @param folderClassNames the folder class names
	 * @param folderPKs the folder pks
	 * @return the matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByG_C_C_F_F(
		long[] groupIds, long[] companyIds, String className,
		String[] folderClassNames, long[] folderPKs) {

		return getPersistence().findByG_C_C_F_F(
			groupIds, companyIds, className, folderClassNames, folderPKs);
	}

	/**
	 * Returns a range of all the ency workflow links where groupId = any &#63; and companyId = any &#63; and className = &#63; and folderClassName = any &#63; and folderPK = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param companyIds the company IDs
	 * @param className the class name
	 * @param folderClassNames the folder class names
	 * @param folderPKs the folder pks
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByG_C_C_F_F(
		long[] groupIds, long[] companyIds, String className,
		String[] folderClassNames, long[] folderPKs, int start, int end) {

		return getPersistence().findByG_C_C_F_F(
			groupIds, companyIds, className, folderClassNames, folderPKs, start,
			end);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where groupId = any &#63; and companyId = any &#63; and className = &#63; and folderClassName = any &#63; and folderPK = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param companyIds the company IDs
	 * @param className the class name
	 * @param folderClassNames the folder class names
	 * @param folderPKs the folder pks
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByG_C_C_F_F(
		long[] groupIds, long[] companyIds, String className,
		String[] folderClassNames, long[] folderPKs, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().findByG_C_C_F_F(
			groupIds, companyIds, className, folderClassNames, folderPKs, start,
			end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow links
	 */
	public static List<EncyWorkflowLink> findByG_C_C_F_F(
		long[] groupIds, long[] companyIds, String className,
		String[] folderClassNames, long[] folderPKs, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_C_C_F_F(
			groupIds, companyIds, className, folderClassNames, folderPKs, start,
			end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 */
	public static void removeByG_C_C_F_F(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK) {

		getPersistence().removeByG_C_C_F_F(
			groupId, companyId, className, folderClassName, folderPK);
	}

	/**
	 * Returns the number of ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 * @return the number of matching ency workflow links
	 */
	public static int countByG_C_C_F_F(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK) {

		return getPersistence().countByG_C_C_F_F(
			groupId, companyId, className, folderClassName, folderPK);
	}

	/**
	 * Returns the number of ency workflow links where groupId = any &#63; and companyId = any &#63; and className = &#63; and folderClassName = any &#63; and folderPK = any &#63;.
	 *
	 * @param groupIds the group IDs
	 * @param companyIds the company IDs
	 * @param className the class name
	 * @param folderClassNames the folder class names
	 * @param folderPKs the folder pks
	 * @return the number of matching ency workflow links
	 */
	public static int countByG_C_C_F_F(
		long[] groupIds, long[] companyIds, String className,
		String[] folderClassNames, long[] folderPKs) {

		return getPersistence().countByG_C_C_F_F(
			groupIds, companyIds, className, folderClassNames, folderPKs);
	}

	/**
	 * Caches the ency workflow link in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowLink the ency workflow link
	 */
	public static void cacheResult(EncyWorkflowLink encyWorkflowLink) {
		getPersistence().cacheResult(encyWorkflowLink);
	}

	/**
	 * Caches the ency workflow links in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowLinks the ency workflow links
	 */
	public static void cacheResult(List<EncyWorkflowLink> encyWorkflowLinks) {
		getPersistence().cacheResult(encyWorkflowLinks);
	}

	/**
	 * Creates a new ency workflow link with the primary key. Does not add the ency workflow link to the database.
	 *
	 * @param workflowLinkId the primary key for the new ency workflow link
	 * @return the new ency workflow link
	 */
	public static EncyWorkflowLink create(long workflowLinkId) {
		return getPersistence().create(workflowLinkId);
	}

	/**
	 * Removes the ency workflow link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workflowLinkId the primary key of the ency workflow link
	 * @return the ency workflow link that was removed
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	public static EncyWorkflowLink remove(long workflowLinkId)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().remove(workflowLinkId);
	}

	public static EncyWorkflowLink updateImpl(
		EncyWorkflowLink encyWorkflowLink) {

		return getPersistence().updateImpl(encyWorkflowLink);
	}

	/**
	 * Returns the ency workflow link with the primary key or throws a <code>NoSuchLinkException</code> if it could not be found.
	 *
	 * @param workflowLinkId the primary key of the ency workflow link
	 * @return the ency workflow link
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	public static EncyWorkflowLink findByPrimaryKey(long workflowLinkId)
		throws cz.csob.ency.workflow.exception.NoSuchLinkException {

		return getPersistence().findByPrimaryKey(workflowLinkId);
	}

	/**
	 * Returns the ency workflow link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workflowLinkId the primary key of the ency workflow link
	 * @return the ency workflow link, or <code>null</code> if a ency workflow link with the primary key could not be found
	 */
	public static EncyWorkflowLink fetchByPrimaryKey(long workflowLinkId) {
		return getPersistence().fetchByPrimaryKey(workflowLinkId);
	}

	/**
	 * Returns all the ency workflow links.
	 *
	 * @return the ency workflow links
	 */
	public static List<EncyWorkflowLink> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ency workflow links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of ency workflow links
	 */
	public static List<EncyWorkflowLink> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ency workflow links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ency workflow links
	 */
	public static List<EncyWorkflowLink> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ency workflow links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ency workflow links
	 */
	public static List<EncyWorkflowLink> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ency workflow links from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ency workflow links.
	 *
	 * @return the number of ency workflow links
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EncyWorkflowLinkPersistence getPersistence() {
		return _persistence;
	}

	private static volatile EncyWorkflowLinkPersistence _persistence;

}