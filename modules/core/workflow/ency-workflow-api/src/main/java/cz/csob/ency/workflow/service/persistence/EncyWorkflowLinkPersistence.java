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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import cz.csob.ency.workflow.exception.NoSuchLinkException;
import cz.csob.ency.workflow.model.EncyWorkflowLink;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ency workflow link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowLinkUtil
 * @generated
 */
@ProviderType
public interface EncyWorkflowLinkPersistence
	extends BasePersistence<EncyWorkflowLink> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EncyWorkflowLinkUtil} to access the ency workflow link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ency workflow links where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ency workflow links
	 */
	public java.util.List<EncyWorkflowLink> findByUuid(String uuid);

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
	public java.util.List<EncyWorkflowLink> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<EncyWorkflowLink> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

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
	public java.util.List<EncyWorkflowLink> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ency workflow link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Returns the first ency workflow link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

	/**
	 * Returns the last ency workflow link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Returns the last ency workflow link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

	/**
	 * Returns the ency workflow links before and after the current ency workflow link in the ordered set where uuid = &#63;.
	 *
	 * @param workflowLinkId the primary key of the current ency workflow link
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow link
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	public EncyWorkflowLink[] findByUuid_PrevAndNext(
			long workflowLinkId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Removes all the ency workflow links where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of ency workflow links where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ency workflow links
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the ency workflow link where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLinkException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink findByUUID_G(String uuid, long groupId)
		throws NoSuchLinkException;

	/**
	 * Returns the ency workflow link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the ency workflow link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the ency workflow link where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ency workflow link that was removed
	 */
	public EncyWorkflowLink removeByUUID_G(String uuid, long groupId)
		throws NoSuchLinkException;

	/**
	 * Returns the number of ency workflow links where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ency workflow links
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the ency workflow links where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ency workflow links
	 */
	public java.util.List<EncyWorkflowLink> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<EncyWorkflowLink> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<EncyWorkflowLink> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

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
	public java.util.List<EncyWorkflowLink> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ency workflow link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Returns the first ency workflow link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

	/**
	 * Returns the last ency workflow link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Returns the last ency workflow link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

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
	public EncyWorkflowLink[] findByUuid_C_PrevAndNext(
			long workflowLinkId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Removes all the ency workflow links where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of ency workflow links where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ency workflow links
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the ency workflow links where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching ency workflow links
	 */
	public java.util.List<EncyWorkflowLink> findByCompanyId(long companyId);

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
	public java.util.List<EncyWorkflowLink> findByCompanyId(
		long companyId, int start, int end);

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
	public java.util.List<EncyWorkflowLink> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

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
	public java.util.List<EncyWorkflowLink> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ency workflow link in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink findByCompanyId_First(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Returns the first ency workflow link in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

	/**
	 * Returns the last ency workflow link in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink findByCompanyId_Last(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Returns the last ency workflow link in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

	/**
	 * Returns the ency workflow links before and after the current ency workflow link in the ordered set where companyId = &#63;.
	 *
	 * @param workflowLinkId the primary key of the current ency workflow link
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow link
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	public EncyWorkflowLink[] findByCompanyId_PrevAndNext(
			long workflowLinkId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Removes all the ency workflow links where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompanyId(long companyId);

	/**
	 * Returns the number of ency workflow links where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching ency workflow links
	 */
	public int countByCompanyId(long companyId);

	/**
	 * Returns all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @return the matching ency workflow links
	 */
	public java.util.List<EncyWorkflowLink> findByG_C_C(
		long groupId, long companyId, String className);

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
	public java.util.List<EncyWorkflowLink> findByG_C_C(
		long groupId, long companyId, String className, int start, int end);

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
	public java.util.List<EncyWorkflowLink> findByG_C_C(
		long groupId, long companyId, String className, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

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
	public java.util.List<EncyWorkflowLink> findByG_C_C(
		long groupId, long companyId, String className, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator,
		boolean useFinderCache);

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
	public EncyWorkflowLink findByG_C_C_First(
			long groupId, long companyId, String className,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Returns the first ency workflow link in the ordered set where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink fetchByG_C_C_First(
		long groupId, long companyId, String className,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

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
	public EncyWorkflowLink findByG_C_C_Last(
			long groupId, long companyId, String className,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Returns the last ency workflow link in the ordered set where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink fetchByG_C_C_Last(
		long groupId, long companyId, String className,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

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
	public EncyWorkflowLink[] findByG_C_C_PrevAndNext(
			long workflowLinkId, long groupId, long companyId, String className,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
				orderByComparator)
		throws NoSuchLinkException;

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
	public java.util.List<EncyWorkflowLink> findByG_C_C(
		long[] groupIds, long[] companyIds, String className);

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
	public java.util.List<EncyWorkflowLink> findByG_C_C(
		long[] groupIds, long[] companyIds, String className, int start,
		int end);

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
	public java.util.List<EncyWorkflowLink> findByG_C_C(
		long[] groupIds, long[] companyIds, String className, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

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
	public java.util.List<EncyWorkflowLink> findByG_C_C(
		long[] groupIds, long[] companyIds, String className, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 */
	public void removeByG_C_C(long groupId, long companyId, String className);

	/**
	 * Returns the number of ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @return the number of matching ency workflow links
	 */
	public int countByG_C_C(long groupId, long companyId, String className);

	/**
	 * Returns the number of ency workflow links where groupId = any &#63; and companyId = any &#63; and className = &#63;.
	 *
	 * @param groupIds the group IDs
	 * @param companyIds the company IDs
	 * @param className the class name
	 * @return the number of matching ency workflow links
	 */
	public int countByG_C_C(
		long[] groupIds, long[] companyIds, String className);

	/**
	 * Returns all the ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @return the matching ency workflow links
	 */
	public java.util.List<EncyWorkflowLink> findByC_I(
		long companyId, long workflowId);

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
	public java.util.List<EncyWorkflowLink> findByC_I(
		long companyId, long workflowId, int start, int end);

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
	public java.util.List<EncyWorkflowLink> findByC_I(
		long companyId, long workflowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

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
	public java.util.List<EncyWorkflowLink> findByC_I(
		long companyId, long workflowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink findByC_I_First(
			long companyId, long workflowId,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Returns the first ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink fetchByC_I_First(
		long companyId, long workflowId,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

	/**
	 * Returns the last ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink findByC_I_Last(
			long companyId, long workflowId,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Returns the last ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink fetchByC_I_Last(
		long companyId, long workflowId,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

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
	public EncyWorkflowLink[] findByC_I_PrevAndNext(
			long workflowLinkId, long companyId, long workflowId,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
				orderByComparator)
		throws NoSuchLinkException;

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
	public java.util.List<EncyWorkflowLink> findByC_I(
		long[] companyIds, long workflowId);

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
	public java.util.List<EncyWorkflowLink> findByC_I(
		long[] companyIds, long workflowId, int start, int end);

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
	public java.util.List<EncyWorkflowLink> findByC_I(
		long[] companyIds, long workflowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

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
	public java.util.List<EncyWorkflowLink> findByC_I(
		long[] companyIds, long workflowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ency workflow links where companyId = &#63; and workflowId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 */
	public void removeByC_I(long companyId, long workflowId);

	/**
	 * Returns the number of ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @return the number of matching ency workflow links
	 */
	public int countByC_I(long companyId, long workflowId);

	/**
	 * Returns the number of ency workflow links where companyId = any &#63; and workflowId = &#63;.
	 *
	 * @param companyIds the company IDs
	 * @param workflowId the workflow ID
	 * @return the number of matching ency workflow links
	 */
	public int countByC_I(long[] companyIds, long workflowId);

	/**
	 * Returns all the ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @return the matching ency workflow links
	 */
	public java.util.List<EncyWorkflowLink> findByWorkflowId(
		long companyId, long workflowId);

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
	public java.util.List<EncyWorkflowLink> findByWorkflowId(
		long companyId, long workflowId, int start, int end);

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
	public java.util.List<EncyWorkflowLink> findByWorkflowId(
		long companyId, long workflowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

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
	public java.util.List<EncyWorkflowLink> findByWorkflowId(
		long companyId, long workflowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink findByWorkflowId_First(
			long companyId, long workflowId,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Returns the first ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink fetchByWorkflowId_First(
		long companyId, long workflowId,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

	/**
	 * Returns the last ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink findByWorkflowId_Last(
			long companyId, long workflowId,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Returns the last ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public EncyWorkflowLink fetchByWorkflowId_Last(
		long companyId, long workflowId,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

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
	public EncyWorkflowLink[] findByWorkflowId_PrevAndNext(
			long workflowLinkId, long companyId, long workflowId,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
				orderByComparator)
		throws NoSuchLinkException;

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
	public java.util.List<EncyWorkflowLink> findByWorkflowId(
		long[] companyIds, long workflowId);

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
	public java.util.List<EncyWorkflowLink> findByWorkflowId(
		long[] companyIds, long workflowId, int start, int end);

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
	public java.util.List<EncyWorkflowLink> findByWorkflowId(
		long[] companyIds, long workflowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

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
	public java.util.List<EncyWorkflowLink> findByWorkflowId(
		long[] companyIds, long workflowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ency workflow links where companyId = &#63; and workflowId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 */
	public void removeByWorkflowId(long companyId, long workflowId);

	/**
	 * Returns the number of ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @return the number of matching ency workflow links
	 */
	public int countByWorkflowId(long companyId, long workflowId);

	/**
	 * Returns the number of ency workflow links where companyId = any &#63; and workflowId = &#63;.
	 *
	 * @param companyIds the company IDs
	 * @param workflowId the workflow ID
	 * @return the number of matching ency workflow links
	 */
	public int countByWorkflowId(long[] companyIds, long workflowId);

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
	public java.util.List<EncyWorkflowLink> findByG_C_C_F_F(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK);

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
	public java.util.List<EncyWorkflowLink> findByG_C_C_F_F(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK, int start, int end);

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
	public java.util.List<EncyWorkflowLink> findByG_C_C_F_F(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

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
	public java.util.List<EncyWorkflowLink> findByG_C_C_F_F(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator,
		boolean useFinderCache);

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
	public EncyWorkflowLink findByG_C_C_F_F_First(
			long groupId, long companyId, String className,
			String folderClassName, long folderPK,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
				orderByComparator)
		throws NoSuchLinkException;

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
	public EncyWorkflowLink fetchByG_C_C_F_F_First(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

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
	public EncyWorkflowLink findByG_C_C_F_F_Last(
			long groupId, long companyId, String className,
			String folderClassName, long folderPK,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
				orderByComparator)
		throws NoSuchLinkException;

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
	public EncyWorkflowLink fetchByG_C_C_F_F_Last(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

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
	public EncyWorkflowLink[] findByG_C_C_F_F_PrevAndNext(
			long workflowLinkId, long groupId, long companyId, String className,
			String folderClassName, long folderPK,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
				orderByComparator)
		throws NoSuchLinkException;

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
	public java.util.List<EncyWorkflowLink> findByG_C_C_F_F(
		long[] groupIds, long[] companyIds, String className,
		String[] folderClassNames, long[] folderPKs);

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
	public java.util.List<EncyWorkflowLink> findByG_C_C_F_F(
		long[] groupIds, long[] companyIds, String className,
		String[] folderClassNames, long[] folderPKs, int start, int end);

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
	public java.util.List<EncyWorkflowLink> findByG_C_C_F_F(
		long[] groupIds, long[] companyIds, String className,
		String[] folderClassNames, long[] folderPKs, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

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
	public java.util.List<EncyWorkflowLink> findByG_C_C_F_F(
		long[] groupIds, long[] companyIds, String className,
		String[] folderClassNames, long[] folderPKs, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 */
	public void removeByG_C_C_F_F(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK);

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
	public int countByG_C_C_F_F(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK);

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
	public int countByG_C_C_F_F(
		long[] groupIds, long[] companyIds, String className,
		String[] folderClassNames, long[] folderPKs);

	/**
	 * Caches the ency workflow link in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowLink the ency workflow link
	 */
	public void cacheResult(EncyWorkflowLink encyWorkflowLink);

	/**
	 * Caches the ency workflow links in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowLinks the ency workflow links
	 */
	public void cacheResult(java.util.List<EncyWorkflowLink> encyWorkflowLinks);

	/**
	 * Creates a new ency workflow link with the primary key. Does not add the ency workflow link to the database.
	 *
	 * @param workflowLinkId the primary key for the new ency workflow link
	 * @return the new ency workflow link
	 */
	public EncyWorkflowLink create(long workflowLinkId);

	/**
	 * Removes the ency workflow link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workflowLinkId the primary key of the ency workflow link
	 * @return the ency workflow link that was removed
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	public EncyWorkflowLink remove(long workflowLinkId)
		throws NoSuchLinkException;

	public EncyWorkflowLink updateImpl(EncyWorkflowLink encyWorkflowLink);

	/**
	 * Returns the ency workflow link with the primary key or throws a <code>NoSuchLinkException</code> if it could not be found.
	 *
	 * @param workflowLinkId the primary key of the ency workflow link
	 * @return the ency workflow link
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	public EncyWorkflowLink findByPrimaryKey(long workflowLinkId)
		throws NoSuchLinkException;

	/**
	 * Returns the ency workflow link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workflowLinkId the primary key of the ency workflow link
	 * @return the ency workflow link, or <code>null</code> if a ency workflow link with the primary key could not be found
	 */
	public EncyWorkflowLink fetchByPrimaryKey(long workflowLinkId);

	/**
	 * Returns all the ency workflow links.
	 *
	 * @return the ency workflow links
	 */
	public java.util.List<EncyWorkflowLink> findAll();

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
	public java.util.List<EncyWorkflowLink> findAll(int start, int end);

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
	public java.util.List<EncyWorkflowLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator);

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
	public java.util.List<EncyWorkflowLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ency workflow links from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ency workflow links.
	 *
	 * @return the number of ency workflow links
	 */
	public int countAll();

}