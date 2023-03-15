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

import cz.csob.ency.workflow.exception.NoSuchTransitionInstanceException;
import cz.csob.ency.workflow.model.EncyWorkflowTransitionInstance;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ency workflow transition instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowTransitionInstanceUtil
 * @generated
 */
@ProviderType
public interface EncyWorkflowTransitionInstancePersistence
	extends BasePersistence<EncyWorkflowTransitionInstance> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EncyWorkflowTransitionInstanceUtil} to access the ency workflow transition instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ency workflow transition instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ency workflow transition instances
	 */
	public java.util.List<EncyWorkflowTransitionInstance> findByUuid(
		String uuid);

	/**
	 * Returns a range of all the ency workflow transition instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @return the range of matching ency workflow transition instances
	 */
	public java.util.List<EncyWorkflowTransitionInstance> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the ency workflow transition instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow transition instances
	 */
	public java.util.List<EncyWorkflowTransitionInstance> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowTransitionInstance> orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflow transition instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow transition instances
	 */
	public java.util.List<EncyWorkflowTransitionInstance> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowTransitionInstance> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ency workflow transition instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a matching ency workflow transition instance could not be found
	 */
	public EncyWorkflowTransitionInstance findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowTransitionInstance> orderByComparator)
		throws NoSuchTransitionInstanceException;

	/**
	 * Returns the first ency workflow transition instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	public EncyWorkflowTransitionInstance fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowTransitionInstance> orderByComparator);

	/**
	 * Returns the last ency workflow transition instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a matching ency workflow transition instance could not be found
	 */
	public EncyWorkflowTransitionInstance findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowTransitionInstance> orderByComparator)
		throws NoSuchTransitionInstanceException;

	/**
	 * Returns the last ency workflow transition instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	public EncyWorkflowTransitionInstance fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowTransitionInstance> orderByComparator);

	/**
	 * Returns the ency workflow transition instances before and after the current ency workflow transition instance in the ordered set where uuid = &#63;.
	 *
	 * @param transitionInstanceId the primary key of the current ency workflow transition instance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a ency workflow transition instance with the primary key could not be found
	 */
	public EncyWorkflowTransitionInstance[] findByUuid_PrevAndNext(
			long transitionInstanceId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowTransitionInstance> orderByComparator)
		throws NoSuchTransitionInstanceException;

	/**
	 * Removes all the ency workflow transition instances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of ency workflow transition instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ency workflow transition instances
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the ency workflow transition instance where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTransitionInstanceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a matching ency workflow transition instance could not be found
	 */
	public EncyWorkflowTransitionInstance findByUUID_G(
			String uuid, long groupId)
		throws NoSuchTransitionInstanceException;

	/**
	 * Returns the ency workflow transition instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	public EncyWorkflowTransitionInstance fetchByUUID_G(
		String uuid, long groupId);

	/**
	 * Returns the ency workflow transition instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	public EncyWorkflowTransitionInstance fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the ency workflow transition instance where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ency workflow transition instance that was removed
	 */
	public EncyWorkflowTransitionInstance removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchTransitionInstanceException;

	/**
	 * Returns the number of ency workflow transition instances where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ency workflow transition instances
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the ency workflow transition instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ency workflow transition instances
	 */
	public java.util.List<EncyWorkflowTransitionInstance> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the ency workflow transition instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @return the range of matching ency workflow transition instances
	 */
	public java.util.List<EncyWorkflowTransitionInstance> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the ency workflow transition instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow transition instances
	 */
	public java.util.List<EncyWorkflowTransitionInstance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowTransitionInstance> orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflow transition instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow transition instances
	 */
	public java.util.List<EncyWorkflowTransitionInstance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowTransitionInstance> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ency workflow transition instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a matching ency workflow transition instance could not be found
	 */
	public EncyWorkflowTransitionInstance findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowTransitionInstance> orderByComparator)
		throws NoSuchTransitionInstanceException;

	/**
	 * Returns the first ency workflow transition instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	public EncyWorkflowTransitionInstance fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowTransitionInstance> orderByComparator);

	/**
	 * Returns the last ency workflow transition instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a matching ency workflow transition instance could not be found
	 */
	public EncyWorkflowTransitionInstance findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowTransitionInstance> orderByComparator)
		throws NoSuchTransitionInstanceException;

	/**
	 * Returns the last ency workflow transition instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	public EncyWorkflowTransitionInstance fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowTransitionInstance> orderByComparator);

	/**
	 * Returns the ency workflow transition instances before and after the current ency workflow transition instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param transitionInstanceId the primary key of the current ency workflow transition instance
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a ency workflow transition instance with the primary key could not be found
	 */
	public EncyWorkflowTransitionInstance[] findByUuid_C_PrevAndNext(
			long transitionInstanceId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowTransitionInstance> orderByComparator)
		throws NoSuchTransitionInstanceException;

	/**
	 * Removes all the ency workflow transition instances where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of ency workflow transition instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ency workflow transition instances
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the ency workflow transition instances where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @return the matching ency workflow transition instances
	 */
	public java.util.List<EncyWorkflowTransitionInstance>
		findByWorkflowInstanceId(long workflowInstanceId);

	/**
	 * Returns a range of all the ency workflow transition instances where workflowInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @return the range of matching ency workflow transition instances
	 */
	public java.util.List<EncyWorkflowTransitionInstance>
		findByWorkflowInstanceId(long workflowInstanceId, int start, int end);

	/**
	 * Returns an ordered range of all the ency workflow transition instances where workflowInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow transition instances
	 */
	public java.util.List<EncyWorkflowTransitionInstance>
		findByWorkflowInstanceId(
			long workflowInstanceId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowTransitionInstance> orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflow transition instances where workflowInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow transition instances
	 */
	public java.util.List<EncyWorkflowTransitionInstance>
		findByWorkflowInstanceId(
			long workflowInstanceId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowTransitionInstance> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first ency workflow transition instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a matching ency workflow transition instance could not be found
	 */
	public EncyWorkflowTransitionInstance findByWorkflowInstanceId_First(
			long workflowInstanceId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowTransitionInstance> orderByComparator)
		throws NoSuchTransitionInstanceException;

	/**
	 * Returns the first ency workflow transition instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	public EncyWorkflowTransitionInstance fetchByWorkflowInstanceId_First(
		long workflowInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowTransitionInstance> orderByComparator);

	/**
	 * Returns the last ency workflow transition instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a matching ency workflow transition instance could not be found
	 */
	public EncyWorkflowTransitionInstance findByWorkflowInstanceId_Last(
			long workflowInstanceId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowTransitionInstance> orderByComparator)
		throws NoSuchTransitionInstanceException;

	/**
	 * Returns the last ency workflow transition instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	public EncyWorkflowTransitionInstance fetchByWorkflowInstanceId_Last(
		long workflowInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowTransitionInstance> orderByComparator);

	/**
	 * Returns the ency workflow transition instances before and after the current ency workflow transition instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param transitionInstanceId the primary key of the current ency workflow transition instance
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a ency workflow transition instance with the primary key could not be found
	 */
	public EncyWorkflowTransitionInstance[]
			findByWorkflowInstanceId_PrevAndNext(
				long transitionInstanceId, long workflowInstanceId,
				com.liferay.portal.kernel.util.OrderByComparator
					<EncyWorkflowTransitionInstance> orderByComparator)
		throws NoSuchTransitionInstanceException;

	/**
	 * Removes all the ency workflow transition instances where workflowInstanceId = &#63; from the database.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 */
	public void removeByWorkflowInstanceId(long workflowInstanceId);

	/**
	 * Returns the number of ency workflow transition instances where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @return the number of matching ency workflow transition instances
	 */
	public int countByWorkflowInstanceId(long workflowInstanceId);

	/**
	 * Caches the ency workflow transition instance in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowTransitionInstance the ency workflow transition instance
	 */
	public void cacheResult(
		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance);

	/**
	 * Caches the ency workflow transition instances in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowTransitionInstances the ency workflow transition instances
	 */
	public void cacheResult(
		java.util.List<EncyWorkflowTransitionInstance>
			encyWorkflowTransitionInstances);

	/**
	 * Creates a new ency workflow transition instance with the primary key. Does not add the ency workflow transition instance to the database.
	 *
	 * @param transitionInstanceId the primary key for the new ency workflow transition instance
	 * @return the new ency workflow transition instance
	 */
	public EncyWorkflowTransitionInstance create(long transitionInstanceId);

	/**
	 * Removes the ency workflow transition instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transitionInstanceId the primary key of the ency workflow transition instance
	 * @return the ency workflow transition instance that was removed
	 * @throws NoSuchTransitionInstanceException if a ency workflow transition instance with the primary key could not be found
	 */
	public EncyWorkflowTransitionInstance remove(long transitionInstanceId)
		throws NoSuchTransitionInstanceException;

	public EncyWorkflowTransitionInstance updateImpl(
		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance);

	/**
	 * Returns the ency workflow transition instance with the primary key or throws a <code>NoSuchTransitionInstanceException</code> if it could not be found.
	 *
	 * @param transitionInstanceId the primary key of the ency workflow transition instance
	 * @return the ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a ency workflow transition instance with the primary key could not be found
	 */
	public EncyWorkflowTransitionInstance findByPrimaryKey(
			long transitionInstanceId)
		throws NoSuchTransitionInstanceException;

	/**
	 * Returns the ency workflow transition instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param transitionInstanceId the primary key of the ency workflow transition instance
	 * @return the ency workflow transition instance, or <code>null</code> if a ency workflow transition instance with the primary key could not be found
	 */
	public EncyWorkflowTransitionInstance fetchByPrimaryKey(
		long transitionInstanceId);

	/**
	 * Returns all the ency workflow transition instances.
	 *
	 * @return the ency workflow transition instances
	 */
	public java.util.List<EncyWorkflowTransitionInstance> findAll();

	/**
	 * Returns a range of all the ency workflow transition instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @return the range of ency workflow transition instances
	 */
	public java.util.List<EncyWorkflowTransitionInstance> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the ency workflow transition instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ency workflow transition instances
	 */
	public java.util.List<EncyWorkflowTransitionInstance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowTransitionInstance> orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflow transition instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ency workflow transition instances
	 */
	public java.util.List<EncyWorkflowTransitionInstance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowTransitionInstance> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ency workflow transition instances from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ency workflow transition instances.
	 *
	 * @return the number of ency workflow transition instances
	 */
	public int countAll();

}