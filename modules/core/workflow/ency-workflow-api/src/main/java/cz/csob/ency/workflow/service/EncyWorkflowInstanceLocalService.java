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

package cz.csob.ency.workflow.service;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import cz.csob.ency.workflow.model.EncyWorkflowInstance;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for EncyWorkflowInstance. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowInstanceLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface EncyWorkflowInstanceLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>cz.csob.ency.workflow.service.impl.EncyWorkflowInstanceLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the ency workflow instance local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link EncyWorkflowInstanceLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the ency workflow instance to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowInstanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowInstance the ency workflow instance
	 * @return the ency workflow instance that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public EncyWorkflowInstance addEncyWorkflowInstance(
		EncyWorkflowInstance encyWorkflowInstance);

	public EncyWorkflowInstance create();

	/**
	 * Creates a new ency workflow instance with the primary key. Does not add the ency workflow instance to the database.
	 *
	 * @param workflowInstanceId the primary key for the new ency workflow instance
	 * @return the new ency workflow instance
	 */
	@Transactional(enabled = false)
	public EncyWorkflowInstance createEncyWorkflowInstance(
		long workflowInstanceId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the ency workflow instance from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowInstanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowInstance the ency workflow instance
	 * @return the ency workflow instance that was removed
	 * @throws PortalException
	 */
	@Indexable(type = IndexableType.DELETE)
	public EncyWorkflowInstance deleteEncyWorkflowInstance(
			EncyWorkflowInstance encyWorkflowInstance)
		throws PortalException;

	/**
	 * Deletes the ency workflow instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowInstanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workflowInstanceId the primary key of the ency workflow instance
	 * @return the ency workflow instance that was removed
	 * @throws PortalException if a ency workflow instance with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public EncyWorkflowInstance deleteEncyWorkflowInstance(
			long workflowInstanceId)
		throws PortalException;

	public EncyWorkflowInstance deleteEncyWorkflowInstance(
			String className, long primaryKey)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EncyWorkflowInstance fetchEncyWorkflowInstance(
		long workflowInstanceId);

	/**
	 * Returns the ency workflow instance matching the UUID and group.
	 *
	 * @param uuid the ency workflow instance's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EncyWorkflowInstance fetchEncyWorkflowInstanceByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the ency workflow instance with the primary key.
	 *
	 * @param workflowInstanceId the primary key of the ency workflow instance
	 * @return the ency workflow instance
	 * @throws PortalException if a ency workflow instance with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EncyWorkflowInstance getEncyWorkflowInstance(long workflowInstanceId)
		throws PortalException;

	/**
	 * Returns the ency workflow instance matching the UUID and group.
	 *
	 * @param uuid the ency workflow instance's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ency workflow instance
	 * @throws PortalException if a matching ency workflow instance could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EncyWorkflowInstance getEncyWorkflowInstanceByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the ency workflow instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @return the range of ency workflow instances
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EncyWorkflowInstance> getEncyWorkflowInstances(
		int start, int end);

	/**
	 * Returns all the ency workflow instances matching the UUID and company.
	 *
	 * @param uuid the UUID of the ency workflow instances
	 * @param companyId the primary key of the company
	 * @return the matching ency workflow instances, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EncyWorkflowInstance>
		getEncyWorkflowInstancesByUuidAndCompanyId(String uuid, long companyId);

	/**
	 * Returns a range of ency workflow instances matching the UUID and company.
	 *
	 * @param uuid the UUID of the ency workflow instances
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching ency workflow instances, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EncyWorkflowInstance>
		getEncyWorkflowInstancesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<EncyWorkflowInstance> orderByComparator);

	/**
	 * Returns the number of ency workflow instances.
	 *
	 * @return the number of ency workflow instances
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEncyWorkflowInstancesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EncyWorkflowInstance getWorkflowInstance(
		long companyId, long groupId, String className, long classPK);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EncyWorkflowInstance getWorkflowInstance(
		String className, long classPK);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasWorkflowInstance(
		long companyId, long groupId, String className, long classPK);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasWorkflowInstance(String className, long classPK);

	public EncyWorkflowInstance startWorkflowInstance(
			long companyId, long groupId, long userId, String className,
			long classPK, Map<String, Serializable> workflowContext)
		throws PortalException;

	/**
	 * Updates the ency workflow instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowInstanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowInstance the ency workflow instance
	 * @return the ency workflow instance that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public EncyWorkflowInstance updateEncyWorkflowInstance(
		EncyWorkflowInstance encyWorkflowInstance);

}