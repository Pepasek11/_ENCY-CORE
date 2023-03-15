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

import cz.csob.ency.workflow.exception.NoSuchInstanceException;
import cz.csob.ency.workflow.model.EncyWorkflowInstance;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ency workflow instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowInstanceUtil
 * @generated
 */
@ProviderType
public interface EncyWorkflowInstancePersistence
	extends BasePersistence<EncyWorkflowInstance> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EncyWorkflowInstanceUtil} to access the ency workflow instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ency workflow instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ency workflow instances
	 */
	public java.util.List<EncyWorkflowInstance> findByUuid(String uuid);

	/**
	 * Returns a range of all the ency workflow instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @return the range of matching ency workflow instances
	 */
	public java.util.List<EncyWorkflowInstance> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the ency workflow instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow instances
	 */
	public java.util.List<EncyWorkflowInstance> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowInstance>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflow instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow instances
	 */
	public java.util.List<EncyWorkflowInstance> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowInstance>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ency workflow instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow instance
	 * @throws NoSuchInstanceException if a matching ency workflow instance could not be found
	 */
	public EncyWorkflowInstance findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowInstance> orderByComparator)
		throws NoSuchInstanceException;

	/**
	 * Returns the first ency workflow instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	public EncyWorkflowInstance fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowInstance>
			orderByComparator);

	/**
	 * Returns the last ency workflow instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow instance
	 * @throws NoSuchInstanceException if a matching ency workflow instance could not be found
	 */
	public EncyWorkflowInstance findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowInstance> orderByComparator)
		throws NoSuchInstanceException;

	/**
	 * Returns the last ency workflow instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	public EncyWorkflowInstance fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowInstance>
			orderByComparator);

	/**
	 * Returns the ency workflow instances before and after the current ency workflow instance in the ordered set where uuid = &#63;.
	 *
	 * @param workflowInstanceId the primary key of the current ency workflow instance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow instance
	 * @throws NoSuchInstanceException if a ency workflow instance with the primary key could not be found
	 */
	public EncyWorkflowInstance[] findByUuid_PrevAndNext(
			long workflowInstanceId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowInstance> orderByComparator)
		throws NoSuchInstanceException;

	/**
	 * Removes all the ency workflow instances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of ency workflow instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ency workflow instances
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the ency workflow instance where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchInstanceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow instance
	 * @throws NoSuchInstanceException if a matching ency workflow instance could not be found
	 */
	public EncyWorkflowInstance findByUUID_G(String uuid, long groupId)
		throws NoSuchInstanceException;

	/**
	 * Returns the ency workflow instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	public EncyWorkflowInstance fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the ency workflow instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	public EncyWorkflowInstance fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the ency workflow instance where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ency workflow instance that was removed
	 */
	public EncyWorkflowInstance removeByUUID_G(String uuid, long groupId)
		throws NoSuchInstanceException;

	/**
	 * Returns the number of ency workflow instances where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ency workflow instances
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the ency workflow instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ency workflow instances
	 */
	public java.util.List<EncyWorkflowInstance> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the ency workflow instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @return the range of matching ency workflow instances
	 */
	public java.util.List<EncyWorkflowInstance> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the ency workflow instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow instances
	 */
	public java.util.List<EncyWorkflowInstance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowInstance>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflow instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow instances
	 */
	public java.util.List<EncyWorkflowInstance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowInstance>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ency workflow instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow instance
	 * @throws NoSuchInstanceException if a matching ency workflow instance could not be found
	 */
	public EncyWorkflowInstance findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowInstance> orderByComparator)
		throws NoSuchInstanceException;

	/**
	 * Returns the first ency workflow instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	public EncyWorkflowInstance fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowInstance>
			orderByComparator);

	/**
	 * Returns the last ency workflow instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow instance
	 * @throws NoSuchInstanceException if a matching ency workflow instance could not be found
	 */
	public EncyWorkflowInstance findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowInstance> orderByComparator)
		throws NoSuchInstanceException;

	/**
	 * Returns the last ency workflow instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	public EncyWorkflowInstance fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowInstance>
			orderByComparator);

	/**
	 * Returns the ency workflow instances before and after the current ency workflow instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param workflowInstanceId the primary key of the current ency workflow instance
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow instance
	 * @throws NoSuchInstanceException if a ency workflow instance with the primary key could not be found
	 */
	public EncyWorkflowInstance[] findByUuid_C_PrevAndNext(
			long workflowInstanceId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EncyWorkflowInstance> orderByComparator)
		throws NoSuchInstanceException;

	/**
	 * Removes all the ency workflow instances where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of ency workflow instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ency workflow instances
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the ency workflow instance where className = &#63; and classPK = &#63; or throws a <code>NoSuchInstanceException</code> if it could not be found.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the matching ency workflow instance
	 * @throws NoSuchInstanceException if a matching ency workflow instance could not be found
	 */
	public EncyWorkflowInstance findByC_C(String className, long classPK)
		throws NoSuchInstanceException;

	/**
	 * Returns the ency workflow instance where className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	public EncyWorkflowInstance fetchByC_C(String className, long classPK);

	/**
	 * Returns the ency workflow instance where className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	public EncyWorkflowInstance fetchByC_C(
		String className, long classPK, boolean useFinderCache);

	/**
	 * Removes the ency workflow instance where className = &#63; and classPK = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the ency workflow instance that was removed
	 */
	public EncyWorkflowInstance removeByC_C(String className, long classPK)
		throws NoSuchInstanceException;

	/**
	 * Returns the number of ency workflow instances where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the number of matching ency workflow instances
	 */
	public int countByC_C(String className, long classPK);

	/**
	 * Caches the ency workflow instance in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowInstance the ency workflow instance
	 */
	public void cacheResult(EncyWorkflowInstance encyWorkflowInstance);

	/**
	 * Caches the ency workflow instances in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowInstances the ency workflow instances
	 */
	public void cacheResult(
		java.util.List<EncyWorkflowInstance> encyWorkflowInstances);

	/**
	 * Creates a new ency workflow instance with the primary key. Does not add the ency workflow instance to the database.
	 *
	 * @param workflowInstanceId the primary key for the new ency workflow instance
	 * @return the new ency workflow instance
	 */
	public EncyWorkflowInstance create(long workflowInstanceId);

	/**
	 * Removes the ency workflow instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workflowInstanceId the primary key of the ency workflow instance
	 * @return the ency workflow instance that was removed
	 * @throws NoSuchInstanceException if a ency workflow instance with the primary key could not be found
	 */
	public EncyWorkflowInstance remove(long workflowInstanceId)
		throws NoSuchInstanceException;

	public EncyWorkflowInstance updateImpl(
		EncyWorkflowInstance encyWorkflowInstance);

	/**
	 * Returns the ency workflow instance with the primary key or throws a <code>NoSuchInstanceException</code> if it could not be found.
	 *
	 * @param workflowInstanceId the primary key of the ency workflow instance
	 * @return the ency workflow instance
	 * @throws NoSuchInstanceException if a ency workflow instance with the primary key could not be found
	 */
	public EncyWorkflowInstance findByPrimaryKey(long workflowInstanceId)
		throws NoSuchInstanceException;

	/**
	 * Returns the ency workflow instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workflowInstanceId the primary key of the ency workflow instance
	 * @return the ency workflow instance, or <code>null</code> if a ency workflow instance with the primary key could not be found
	 */
	public EncyWorkflowInstance fetchByPrimaryKey(long workflowInstanceId);

	/**
	 * Returns all the ency workflow instances.
	 *
	 * @return the ency workflow instances
	 */
	public java.util.List<EncyWorkflowInstance> findAll();

	/**
	 * Returns a range of all the ency workflow instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @return the range of ency workflow instances
	 */
	public java.util.List<EncyWorkflowInstance> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ency workflow instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ency workflow instances
	 */
	public java.util.List<EncyWorkflowInstance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowInstance>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflow instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ency workflow instances
	 */
	public java.util.List<EncyWorkflowInstance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflowInstance>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ency workflow instances from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ency workflow instances.
	 *
	 * @return the number of ency workflow instances
	 */
	public int countAll();

}