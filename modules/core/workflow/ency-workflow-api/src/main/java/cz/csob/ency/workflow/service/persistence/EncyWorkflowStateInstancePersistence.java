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

import cz.csob.ency.workflow.exception.NoSuchStateInstanceException;
import cz.csob.ency.workflow.model.EncyWorkflowStateInstance;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ency workflow state instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowStateInstanceUtil
 * @generated
 */
@ProviderType
public interface EncyWorkflowStateInstancePersistence
	extends BasePersistence<EncyWorkflowStateInstance> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EncyWorkflowStateInstanceUtil} to access the ency workflow state instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ency workflow state instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ency workflow state instances
	 */
	public java.util.List<EncyWorkflowStateInstance> findByUuid(String uuid);

	/**
	 * Returns a range of all the ency workflow state instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @return the range of matching ency workflow state instances
	 */
	public java.util.List<EncyWorkflowStateInstance> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the ency workflow state instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow state instances
	 */
	public java.util.List<EncyWorkflowStateInstance> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowStateInstance> orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflow state instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow state instances
	 */
	public java.util.List<EncyWorkflowStateInstance> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowStateInstance> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ency workflow state instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	public EncyWorkflowStateInstance findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException;

	/**
	 * Returns the first ency workflow state instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	public EncyWorkflowStateInstance fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowStateInstance> orderByComparator);

	/**
	 * Returns the last ency workflow state instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	public EncyWorkflowStateInstance findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException;

	/**
	 * Returns the last ency workflow state instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	public EncyWorkflowStateInstance fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowStateInstance> orderByComparator);

	/**
	 * Returns the ency workflow state instances before and after the current ency workflow state instance in the ordered set where uuid = &#63;.
	 *
	 * @param stateInstanceId the primary key of the current ency workflow state instance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow state instance
	 * @throws NoSuchStateInstanceException if a ency workflow state instance with the primary key could not be found
	 */
	public EncyWorkflowStateInstance[] findByUuid_PrevAndNext(
			long stateInstanceId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException;

	/**
	 * Removes all the ency workflow state instances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of ency workflow state instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ency workflow state instances
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the ency workflow state instance where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchStateInstanceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	public EncyWorkflowStateInstance findByUUID_G(String uuid, long groupId)
		throws NoSuchStateInstanceException;

	/**
	 * Returns the ency workflow state instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	public EncyWorkflowStateInstance fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the ency workflow state instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	public EncyWorkflowStateInstance fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the ency workflow state instance where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ency workflow state instance that was removed
	 */
	public EncyWorkflowStateInstance removeByUUID_G(String uuid, long groupId)
		throws NoSuchStateInstanceException;

	/**
	 * Returns the number of ency workflow state instances where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ency workflow state instances
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the ency workflow state instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ency workflow state instances
	 */
	public java.util.List<EncyWorkflowStateInstance> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the ency workflow state instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @return the range of matching ency workflow state instances
	 */
	public java.util.List<EncyWorkflowStateInstance> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the ency workflow state instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow state instances
	 */
	public java.util.List<EncyWorkflowStateInstance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowStateInstance> orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflow state instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow state instances
	 */
	public java.util.List<EncyWorkflowStateInstance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowStateInstance> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ency workflow state instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	public EncyWorkflowStateInstance findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException;

	/**
	 * Returns the first ency workflow state instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	public EncyWorkflowStateInstance fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowStateInstance> orderByComparator);

	/**
	 * Returns the last ency workflow state instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	public EncyWorkflowStateInstance findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException;

	/**
	 * Returns the last ency workflow state instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	public EncyWorkflowStateInstance fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowStateInstance> orderByComparator);

	/**
	 * Returns the ency workflow state instances before and after the current ency workflow state instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param stateInstanceId the primary key of the current ency workflow state instance
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow state instance
	 * @throws NoSuchStateInstanceException if a ency workflow state instance with the primary key could not be found
	 */
	public EncyWorkflowStateInstance[] findByUuid_C_PrevAndNext(
			long stateInstanceId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException;

	/**
	 * Removes all the ency workflow state instances where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of ency workflow state instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ency workflow state instances
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the ency workflow state instances where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @return the matching ency workflow state instances
	 */
	public java.util.List<EncyWorkflowStateInstance> findByWorkflowInstanceId(
		long workflowInstanceId);

	/**
	 * Returns a range of all the ency workflow state instances where workflowInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @return the range of matching ency workflow state instances
	 */
	public java.util.List<EncyWorkflowStateInstance> findByWorkflowInstanceId(
		long workflowInstanceId, int start, int end);

	/**
	 * Returns an ordered range of all the ency workflow state instances where workflowInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow state instances
	 */
	public java.util.List<EncyWorkflowStateInstance> findByWorkflowInstanceId(
		long workflowInstanceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowStateInstance> orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflow state instances where workflowInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow state instances
	 */
	public java.util.List<EncyWorkflowStateInstance> findByWorkflowInstanceId(
		long workflowInstanceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowStateInstance> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ency workflow state instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	public EncyWorkflowStateInstance findByWorkflowInstanceId_First(
			long workflowInstanceId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException;

	/**
	 * Returns the first ency workflow state instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	public EncyWorkflowStateInstance fetchByWorkflowInstanceId_First(
		long workflowInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowStateInstance> orderByComparator);

	/**
	 * Returns the last ency workflow state instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	public EncyWorkflowStateInstance findByWorkflowInstanceId_Last(
			long workflowInstanceId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException;

	/**
	 * Returns the last ency workflow state instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	public EncyWorkflowStateInstance fetchByWorkflowInstanceId_Last(
		long workflowInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowStateInstance> orderByComparator);

	/**
	 * Returns the ency workflow state instances before and after the current ency workflow state instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param stateInstanceId the primary key of the current ency workflow state instance
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow state instance
	 * @throws NoSuchStateInstanceException if a ency workflow state instance with the primary key could not be found
	 */
	public EncyWorkflowStateInstance[] findByWorkflowInstanceId_PrevAndNext(
			long stateInstanceId, long workflowInstanceId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException;

	/**
	 * Removes all the ency workflow state instances where workflowInstanceId = &#63; from the database.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 */
	public void removeByWorkflowInstanceId(long workflowInstanceId);

	/**
	 * Returns the number of ency workflow state instances where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @return the number of matching ency workflow state instances
	 */
	public int countByWorkflowInstanceId(long workflowInstanceId);

	/**
	 * Returns all the ency workflow state instances where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @return the matching ency workflow state instances
	 */
	public java.util.List<EncyWorkflowStateInstance> findByWorkflowId(
		long workflowId);

	/**
	 * Returns a range of all the ency workflow state instances where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @return the range of matching ency workflow state instances
	 */
	public java.util.List<EncyWorkflowStateInstance> findByWorkflowId(
		long workflowId, int start, int end);

	/**
	 * Returns an ordered range of all the ency workflow state instances where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow state instances
	 */
	public java.util.List<EncyWorkflowStateInstance> findByWorkflowId(
		long workflowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowStateInstance> orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflow state instances where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow state instances
	 */
	public java.util.List<EncyWorkflowStateInstance> findByWorkflowId(
		long workflowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowStateInstance> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ency workflow state instance in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	public EncyWorkflowStateInstance findByWorkflowId_First(
			long workflowId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException;

	/**
	 * Returns the first ency workflow state instance in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	public EncyWorkflowStateInstance fetchByWorkflowId_First(
		long workflowId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowStateInstance> orderByComparator);

	/**
	 * Returns the last ency workflow state instance in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	public EncyWorkflowStateInstance findByWorkflowId_Last(
			long workflowId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException;

	/**
	 * Returns the last ency workflow state instance in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	public EncyWorkflowStateInstance fetchByWorkflowId_Last(
		long workflowId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowStateInstance> orderByComparator);

	/**
	 * Returns the ency workflow state instances before and after the current ency workflow state instance in the ordered set where workflowId = &#63;.
	 *
	 * @param stateInstanceId the primary key of the current ency workflow state instance
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow state instance
	 * @throws NoSuchStateInstanceException if a ency workflow state instance with the primary key could not be found
	 */
	public EncyWorkflowStateInstance[] findByWorkflowId_PrevAndNext(
			long stateInstanceId, long workflowId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException;

	/**
	 * Removes all the ency workflow state instances where workflowId = &#63; from the database.
	 *
	 * @param workflowId the workflow ID
	 */
	public void removeByWorkflowId(long workflowId);

	/**
	 * Returns the number of ency workflow state instances where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @return the number of matching ency workflow state instances
	 */
	public int countByWorkflowId(long workflowId);

	/**
	 * Caches the ency workflow state instance in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowStateInstance the ency workflow state instance
	 */
	public void cacheResult(
		EncyWorkflowStateInstance encyWorkflowStateInstance);

	/**
	 * Caches the ency workflow state instances in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowStateInstances the ency workflow state instances
	 */
	public void cacheResult(
		java.util.List<EncyWorkflowStateInstance> encyWorkflowStateInstances);

	/**
	 * Creates a new ency workflow state instance with the primary key. Does not add the ency workflow state instance to the database.
	 *
	 * @param stateInstanceId the primary key for the new ency workflow state instance
	 * @return the new ency workflow state instance
	 */
	public EncyWorkflowStateInstance create(long stateInstanceId);

	/**
	 * Removes the ency workflow state instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stateInstanceId the primary key of the ency workflow state instance
	 * @return the ency workflow state instance that was removed
	 * @throws NoSuchStateInstanceException if a ency workflow state instance with the primary key could not be found
	 */
	public EncyWorkflowStateInstance remove(long stateInstanceId)
		throws NoSuchStateInstanceException;

	public EncyWorkflowStateInstance updateImpl(
		EncyWorkflowStateInstance encyWorkflowStateInstance);

	/**
	 * Returns the ency workflow state instance with the primary key or throws a <code>NoSuchStateInstanceException</code> if it could not be found.
	 *
	 * @param stateInstanceId the primary key of the ency workflow state instance
	 * @return the ency workflow state instance
	 * @throws NoSuchStateInstanceException if a ency workflow state instance with the primary key could not be found
	 */
	public EncyWorkflowStateInstance findByPrimaryKey(long stateInstanceId)
		throws NoSuchStateInstanceException;

	/**
	 * Returns the ency workflow state instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stateInstanceId the primary key of the ency workflow state instance
	 * @return the ency workflow state instance, or <code>null</code> if a ency workflow state instance with the primary key could not be found
	 */
	public EncyWorkflowStateInstance fetchByPrimaryKey(long stateInstanceId);

	/**
	 * Returns all the ency workflow state instances.
	 *
	 * @return the ency workflow state instances
	 */
	public java.util.List<EncyWorkflowStateInstance> findAll();

	/**
	 * Returns a range of all the ency workflow state instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @return the range of ency workflow state instances
	 */
	public java.util.List<EncyWorkflowStateInstance> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the ency workflow state instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ency workflow state instances
	 */
	public java.util.List<EncyWorkflowStateInstance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowStateInstance> orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflow state instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ency workflow state instances
	 */
	public java.util.List<EncyWorkflowStateInstance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EncyWorkflowStateInstance> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ency workflow state instances from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ency workflow state instances.
	 *
	 * @return the number of ency workflow state instances
	 */
	public int countAll();

}