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

import cz.csob.ency.workflow.exception.NoSuchEncyWorkflowException;
import cz.csob.ency.workflow.model.EncyWorkflow;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ency workflow service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowUtil
 * @generated
 */
@ProviderType
public interface EncyWorkflowPersistence extends BasePersistence<EncyWorkflow> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EncyWorkflowUtil} to access the ency workflow persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ency workflows where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ency workflows
	 */
	public java.util.List<EncyWorkflow> findByUuid(String uuid);

	/**
	 * Returns a range of all the ency workflows where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @return the range of matching ency workflows
	 */
	public java.util.List<EncyWorkflow> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the ency workflows where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflows
	 */
	public java.util.List<EncyWorkflow> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflow>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflows where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflows
	 */
	public java.util.List<EncyWorkflow> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflow>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ency workflow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow
	 * @throws NoSuchEncyWorkflowException if a matching ency workflow could not be found
	 */
	public EncyWorkflow findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflow>
				orderByComparator)
		throws NoSuchEncyWorkflowException;

	/**
	 * Returns the first ency workflow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow, or <code>null</code> if a matching ency workflow could not be found
	 */
	public EncyWorkflow fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflow>
			orderByComparator);

	/**
	 * Returns the last ency workflow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow
	 * @throws NoSuchEncyWorkflowException if a matching ency workflow could not be found
	 */
	public EncyWorkflow findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflow>
				orderByComparator)
		throws NoSuchEncyWorkflowException;

	/**
	 * Returns the last ency workflow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow, or <code>null</code> if a matching ency workflow could not be found
	 */
	public EncyWorkflow fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflow>
			orderByComparator);

	/**
	 * Returns the ency workflows before and after the current ency workflow in the ordered set where uuid = &#63;.
	 *
	 * @param workflowId the primary key of the current ency workflow
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow
	 * @throws NoSuchEncyWorkflowException if a ency workflow with the primary key could not be found
	 */
	public EncyWorkflow[] findByUuid_PrevAndNext(
			long workflowId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflow>
				orderByComparator)
		throws NoSuchEncyWorkflowException;

	/**
	 * Removes all the ency workflows where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of ency workflows where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ency workflows
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the ency workflow where className = &#63; or throws a <code>NoSuchEncyWorkflowException</code> if it could not be found.
	 *
	 * @param className the class name
	 * @return the matching ency workflow
	 * @throws NoSuchEncyWorkflowException if a matching ency workflow could not be found
	 */
	public EncyWorkflow findByClassName(String className)
		throws NoSuchEncyWorkflowException;

	/**
	 * Returns the ency workflow where className = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param className the class name
	 * @return the matching ency workflow, or <code>null</code> if a matching ency workflow could not be found
	 */
	public EncyWorkflow fetchByClassName(String className);

	/**
	 * Returns the ency workflow where className = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param className the class name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow, or <code>null</code> if a matching ency workflow could not be found
	 */
	public EncyWorkflow fetchByClassName(
		String className, boolean useFinderCache);

	/**
	 * Removes the ency workflow where className = &#63; from the database.
	 *
	 * @param className the class name
	 * @return the ency workflow that was removed
	 */
	public EncyWorkflow removeByClassName(String className)
		throws NoSuchEncyWorkflowException;

	/**
	 * Returns the number of ency workflows where className = &#63;.
	 *
	 * @param className the class name
	 * @return the number of matching ency workflows
	 */
	public int countByClassName(String className);

	/**
	 * Returns all the ency workflows where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching ency workflows
	 */
	public java.util.List<EncyWorkflow> findByActive(Boolean active);

	/**
	 * Returns a range of all the ency workflows where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @return the range of matching ency workflows
	 */
	public java.util.List<EncyWorkflow> findByActive(
		Boolean active, int start, int end);

	/**
	 * Returns an ordered range of all the ency workflows where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflows
	 */
	public java.util.List<EncyWorkflow> findByActive(
		Boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflow>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflows where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflows
	 */
	public java.util.List<EncyWorkflow> findByActive(
		Boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflow>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ency workflow in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow
	 * @throws NoSuchEncyWorkflowException if a matching ency workflow could not be found
	 */
	public EncyWorkflow findByActive_First(
			Boolean active,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflow>
				orderByComparator)
		throws NoSuchEncyWorkflowException;

	/**
	 * Returns the first ency workflow in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow, or <code>null</code> if a matching ency workflow could not be found
	 */
	public EncyWorkflow fetchByActive_First(
		Boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflow>
			orderByComparator);

	/**
	 * Returns the last ency workflow in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow
	 * @throws NoSuchEncyWorkflowException if a matching ency workflow could not be found
	 */
	public EncyWorkflow findByActive_Last(
			Boolean active,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflow>
				orderByComparator)
		throws NoSuchEncyWorkflowException;

	/**
	 * Returns the last ency workflow in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow, or <code>null</code> if a matching ency workflow could not be found
	 */
	public EncyWorkflow fetchByActive_Last(
		Boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflow>
			orderByComparator);

	/**
	 * Returns the ency workflows before and after the current ency workflow in the ordered set where active = &#63;.
	 *
	 * @param workflowId the primary key of the current ency workflow
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow
	 * @throws NoSuchEncyWorkflowException if a ency workflow with the primary key could not be found
	 */
	public EncyWorkflow[] findByActive_PrevAndNext(
			long workflowId, Boolean active,
			com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflow>
				orderByComparator)
		throws NoSuchEncyWorkflowException;

	/**
	 * Removes all the ency workflows where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public void removeByActive(Boolean active);

	/**
	 * Returns the number of ency workflows where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching ency workflows
	 */
	public int countByActive(Boolean active);

	/**
	 * Caches the ency workflow in the entity cache if it is enabled.
	 *
	 * @param encyWorkflow the ency workflow
	 */
	public void cacheResult(EncyWorkflow encyWorkflow);

	/**
	 * Caches the ency workflows in the entity cache if it is enabled.
	 *
	 * @param encyWorkflows the ency workflows
	 */
	public void cacheResult(java.util.List<EncyWorkflow> encyWorkflows);

	/**
	 * Creates a new ency workflow with the primary key. Does not add the ency workflow to the database.
	 *
	 * @param workflowId the primary key for the new ency workflow
	 * @return the new ency workflow
	 */
	public EncyWorkflow create(long workflowId);

	/**
	 * Removes the ency workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workflowId the primary key of the ency workflow
	 * @return the ency workflow that was removed
	 * @throws NoSuchEncyWorkflowException if a ency workflow with the primary key could not be found
	 */
	public EncyWorkflow remove(long workflowId)
		throws NoSuchEncyWorkflowException;

	public EncyWorkflow updateImpl(EncyWorkflow encyWorkflow);

	/**
	 * Returns the ency workflow with the primary key or throws a <code>NoSuchEncyWorkflowException</code> if it could not be found.
	 *
	 * @param workflowId the primary key of the ency workflow
	 * @return the ency workflow
	 * @throws NoSuchEncyWorkflowException if a ency workflow with the primary key could not be found
	 */
	public EncyWorkflow findByPrimaryKey(long workflowId)
		throws NoSuchEncyWorkflowException;

	/**
	 * Returns the ency workflow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workflowId the primary key of the ency workflow
	 * @return the ency workflow, or <code>null</code> if a ency workflow with the primary key could not be found
	 */
	public EncyWorkflow fetchByPrimaryKey(long workflowId);

	/**
	 * Returns all the ency workflows.
	 *
	 * @return the ency workflows
	 */
	public java.util.List<EncyWorkflow> findAll();

	/**
	 * Returns a range of all the ency workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @return the range of ency workflows
	 */
	public java.util.List<EncyWorkflow> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ency workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ency workflows
	 */
	public java.util.List<EncyWorkflow> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflow>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ency workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ency workflows
	 */
	public java.util.List<EncyWorkflow> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EncyWorkflow>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ency workflows from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ency workflows.
	 *
	 * @return the number of ency workflows
	 */
	public int countAll();

}