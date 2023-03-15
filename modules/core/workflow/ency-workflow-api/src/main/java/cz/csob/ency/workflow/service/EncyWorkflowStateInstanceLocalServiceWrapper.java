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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EncyWorkflowStateInstanceLocalService}.
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowStateInstanceLocalService
 * @generated
 */
public class EncyWorkflowStateInstanceLocalServiceWrapper
	implements EncyWorkflowStateInstanceLocalService,
			   ServiceWrapper<EncyWorkflowStateInstanceLocalService> {

	public EncyWorkflowStateInstanceLocalServiceWrapper() {
		this(null);
	}

	public EncyWorkflowStateInstanceLocalServiceWrapper(
		EncyWorkflowStateInstanceLocalService
			encyWorkflowStateInstanceLocalService) {

		_encyWorkflowStateInstanceLocalService =
			encyWorkflowStateInstanceLocalService;
	}

	/**
	 * Adds the ency workflow state instance to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowStateInstanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowStateInstance the ency workflow state instance
	 * @return the ency workflow state instance that was added
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowStateInstance
		addEncyWorkflowStateInstance(
			cz.csob.ency.workflow.model.EncyWorkflowStateInstance
				encyWorkflowStateInstance) {

		return _encyWorkflowStateInstanceLocalService.
			addEncyWorkflowStateInstance(encyWorkflowStateInstance);
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowStateInstance
			completeWorkflowStateInstance(
				long stateInstanceId, long userId,
				java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowStateInstanceLocalService.
			completeWorkflowStateInstance(
				stateInstanceId, userId, workflowContext);
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowStateInstance create() {
		return _encyWorkflowStateInstanceLocalService.create();
	}

	/**
	 * Creates a new ency workflow state instance with the primary key. Does not add the ency workflow state instance to the database.
	 *
	 * @param stateInstanceId the primary key for the new ency workflow state instance
	 * @return the new ency workflow state instance
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowStateInstance
		createEncyWorkflowStateInstance(long stateInstanceId) {

		return _encyWorkflowStateInstanceLocalService.
			createEncyWorkflowStateInstance(stateInstanceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowStateInstanceLocalService.createPersistedModel(
			primaryKeyObj);
	}

	@Override
	public void deleteEncyWorkflowInstanceStateInstances(
		long workflowInstanceId) {

		_encyWorkflowStateInstanceLocalService.
			deleteEncyWorkflowInstanceStateInstances(workflowInstanceId);
	}

	/**
	 * Deletes the ency workflow state instance from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowStateInstanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowStateInstance the ency workflow state instance
	 * @return the ency workflow state instance that was removed
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowStateInstance
		deleteEncyWorkflowStateInstance(
			cz.csob.ency.workflow.model.EncyWorkflowStateInstance
				encyWorkflowStateInstance) {

		return _encyWorkflowStateInstanceLocalService.
			deleteEncyWorkflowStateInstance(encyWorkflowStateInstance);
	}

	/**
	 * Deletes the ency workflow state instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowStateInstanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stateInstanceId the primary key of the ency workflow state instance
	 * @return the ency workflow state instance that was removed
	 * @throws PortalException if a ency workflow state instance with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowStateInstance
			deleteEncyWorkflowStateInstance(long stateInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowStateInstanceLocalService.
			deleteEncyWorkflowStateInstance(stateInstanceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowStateInstanceLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _encyWorkflowStateInstanceLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _encyWorkflowStateInstanceLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _encyWorkflowStateInstanceLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _encyWorkflowStateInstanceLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _encyWorkflowStateInstanceLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _encyWorkflowStateInstanceLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _encyWorkflowStateInstanceLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _encyWorkflowStateInstanceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowStateInstance
		fetchEncyWorkflowStateInstance(long stateInstanceId) {

		return _encyWorkflowStateInstanceLocalService.
			fetchEncyWorkflowStateInstance(stateInstanceId);
	}

	/**
	 * Returns the ency workflow state instance matching the UUID and group.
	 *
	 * @param uuid the ency workflow state instance's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowStateInstance
		fetchEncyWorkflowStateInstanceByUuidAndGroupId(
			String uuid, long groupId) {

		return _encyWorkflowStateInstanceLocalService.
			fetchEncyWorkflowStateInstanceByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _encyWorkflowStateInstanceLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowStateInstance
		getCurrentWorkflowStateInstance(long workflowInstanceId) {

		return _encyWorkflowStateInstanceLocalService.
			getCurrentWorkflowStateInstance(workflowInstanceId);
	}

	/**
	 * Returns the ency workflow state instance with the primary key.
	 *
	 * @param stateInstanceId the primary key of the ency workflow state instance
	 * @return the ency workflow state instance
	 * @throws PortalException if a ency workflow state instance with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowStateInstance
			getEncyWorkflowStateInstance(long stateInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowStateInstanceLocalService.
			getEncyWorkflowStateInstance(stateInstanceId);
	}

	/**
	 * Returns the ency workflow state instance matching the UUID and group.
	 *
	 * @param uuid the ency workflow state instance's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ency workflow state instance
	 * @throws PortalException if a matching ency workflow state instance could not be found
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowStateInstance
			getEncyWorkflowStateInstanceByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowStateInstanceLocalService.
			getEncyWorkflowStateInstanceByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the ency workflow state instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @return the range of ency workflow state instances
	 */
	@Override
	public java.util.List<cz.csob.ency.workflow.model.EncyWorkflowStateInstance>
		getEncyWorkflowStateInstances(int start, int end) {

		return _encyWorkflowStateInstanceLocalService.
			getEncyWorkflowStateInstances(start, end);
	}

	/**
	 * Returns all the ency workflow state instances matching the UUID and company.
	 *
	 * @param uuid the UUID of the ency workflow state instances
	 * @param companyId the primary key of the company
	 * @return the matching ency workflow state instances, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<cz.csob.ency.workflow.model.EncyWorkflowStateInstance>
		getEncyWorkflowStateInstancesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _encyWorkflowStateInstanceLocalService.
			getEncyWorkflowStateInstancesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of ency workflow state instances matching the UUID and company.
	 *
	 * @param uuid the UUID of the ency workflow state instances
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching ency workflow state instances, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<cz.csob.ency.workflow.model.EncyWorkflowStateInstance>
		getEncyWorkflowStateInstancesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.workflow.model.EncyWorkflowStateInstance>
					orderByComparator) {

		return _encyWorkflowStateInstanceLocalService.
			getEncyWorkflowStateInstancesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of ency workflow state instances.
	 *
	 * @return the number of ency workflow state instances
	 */
	@Override
	public int getEncyWorkflowStateInstancesCount() {
		return _encyWorkflowStateInstanceLocalService.
			getEncyWorkflowStateInstancesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _encyWorkflowStateInstanceLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _encyWorkflowStateInstanceLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _encyWorkflowStateInstanceLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowStateInstanceLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowStateInstance
		startWorkflowStateInstance(
			long stateId, long workflowId, long workflowInstanceId,
			long version, long groupId, long companyId, long userId,
			java.util.Map<String, java.io.Serializable> workflowContext) {

		return _encyWorkflowStateInstanceLocalService.
			startWorkflowStateInstance(
				stateId, workflowId, workflowInstanceId, version, groupId,
				companyId, userId, workflowContext);
	}

	/**
	 * Updates the ency workflow state instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowStateInstanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowStateInstance the ency workflow state instance
	 * @return the ency workflow state instance that was updated
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowStateInstance
		updateEncyWorkflowStateInstance(
			cz.csob.ency.workflow.model.EncyWorkflowStateInstance
				encyWorkflowStateInstance) {

		return _encyWorkflowStateInstanceLocalService.
			updateEncyWorkflowStateInstance(encyWorkflowStateInstance);
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowStateInstance
			updateWorkflowStateInstance(
				long stateInstanceId, long userId,
				java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowStateInstanceLocalService.
			updateWorkflowStateInstance(
				stateInstanceId, userId, workflowContext);
	}

	@Override
	public EncyWorkflowStateInstanceLocalService getWrappedService() {
		return _encyWorkflowStateInstanceLocalService;
	}

	@Override
	public void setWrappedService(
		EncyWorkflowStateInstanceLocalService
			encyWorkflowStateInstanceLocalService) {

		_encyWorkflowStateInstanceLocalService =
			encyWorkflowStateInstanceLocalService;
	}

	private EncyWorkflowStateInstanceLocalService
		_encyWorkflowStateInstanceLocalService;

}