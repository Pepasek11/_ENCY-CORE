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
 * Provides a wrapper for {@link EncyWorkflowInstanceLocalService}.
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowInstanceLocalService
 * @generated
 */
public class EncyWorkflowInstanceLocalServiceWrapper
	implements EncyWorkflowInstanceLocalService,
			   ServiceWrapper<EncyWorkflowInstanceLocalService> {

	public EncyWorkflowInstanceLocalServiceWrapper() {
		this(null);
	}

	public EncyWorkflowInstanceLocalServiceWrapper(
		EncyWorkflowInstanceLocalService encyWorkflowInstanceLocalService) {

		_encyWorkflowInstanceLocalService = encyWorkflowInstanceLocalService;
	}

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
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowInstance
		addEncyWorkflowInstance(
			cz.csob.ency.workflow.model.EncyWorkflowInstance
				encyWorkflowInstance) {

		return _encyWorkflowInstanceLocalService.addEncyWorkflowInstance(
			encyWorkflowInstance);
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowInstance create() {
		return _encyWorkflowInstanceLocalService.create();
	}

	/**
	 * Creates a new ency workflow instance with the primary key. Does not add the ency workflow instance to the database.
	 *
	 * @param workflowInstanceId the primary key for the new ency workflow instance
	 * @return the new ency workflow instance
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowInstance
		createEncyWorkflowInstance(long workflowInstanceId) {

		return _encyWorkflowInstanceLocalService.createEncyWorkflowInstance(
			workflowInstanceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowInstanceLocalService.createPersistedModel(
			primaryKeyObj);
	}

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
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowInstance
			deleteEncyWorkflowInstance(
				cz.csob.ency.workflow.model.EncyWorkflowInstance
					encyWorkflowInstance)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowInstanceLocalService.deleteEncyWorkflowInstance(
			encyWorkflowInstance);
	}

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
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowInstance
			deleteEncyWorkflowInstance(long workflowInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowInstanceLocalService.deleteEncyWorkflowInstance(
			workflowInstanceId);
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowInstance
			deleteEncyWorkflowInstance(String className, long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowInstanceLocalService.deleteEncyWorkflowInstance(
			className, primaryKey);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowInstanceLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _encyWorkflowInstanceLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _encyWorkflowInstanceLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _encyWorkflowInstanceLocalService.dynamicQuery();
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

		return _encyWorkflowInstanceLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _encyWorkflowInstanceLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _encyWorkflowInstanceLocalService.dynamicQuery(
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

		return _encyWorkflowInstanceLocalService.dynamicQueryCount(
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

		return _encyWorkflowInstanceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowInstance
		fetchEncyWorkflowInstance(long workflowInstanceId) {

		return _encyWorkflowInstanceLocalService.fetchEncyWorkflowInstance(
			workflowInstanceId);
	}

	/**
	 * Returns the ency workflow instance matching the UUID and group.
	 *
	 * @param uuid the ency workflow instance's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowInstance
		fetchEncyWorkflowInstanceByUuidAndGroupId(String uuid, long groupId) {

		return _encyWorkflowInstanceLocalService.
			fetchEncyWorkflowInstanceByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _encyWorkflowInstanceLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the ency workflow instance with the primary key.
	 *
	 * @param workflowInstanceId the primary key of the ency workflow instance
	 * @return the ency workflow instance
	 * @throws PortalException if a ency workflow instance with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowInstance
			getEncyWorkflowInstance(long workflowInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowInstanceLocalService.getEncyWorkflowInstance(
			workflowInstanceId);
	}

	/**
	 * Returns the ency workflow instance matching the UUID and group.
	 *
	 * @param uuid the ency workflow instance's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ency workflow instance
	 * @throws PortalException if a matching ency workflow instance could not be found
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowInstance
			getEncyWorkflowInstanceByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowInstanceLocalService.
			getEncyWorkflowInstanceByUuidAndGroupId(uuid, groupId);
	}

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
	@Override
	public java.util.List<cz.csob.ency.workflow.model.EncyWorkflowInstance>
		getEncyWorkflowInstances(int start, int end) {

		return _encyWorkflowInstanceLocalService.getEncyWorkflowInstances(
			start, end);
	}

	/**
	 * Returns all the ency workflow instances matching the UUID and company.
	 *
	 * @param uuid the UUID of the ency workflow instances
	 * @param companyId the primary key of the company
	 * @return the matching ency workflow instances, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<cz.csob.ency.workflow.model.EncyWorkflowInstance>
		getEncyWorkflowInstancesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _encyWorkflowInstanceLocalService.
			getEncyWorkflowInstancesByUuidAndCompanyId(uuid, companyId);
	}

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
	@Override
	public java.util.List<cz.csob.ency.workflow.model.EncyWorkflowInstance>
		getEncyWorkflowInstancesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.workflow.model.EncyWorkflowInstance>
					orderByComparator) {

		return _encyWorkflowInstanceLocalService.
			getEncyWorkflowInstancesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of ency workflow instances.
	 *
	 * @return the number of ency workflow instances
	 */
	@Override
	public int getEncyWorkflowInstancesCount() {
		return _encyWorkflowInstanceLocalService.
			getEncyWorkflowInstancesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _encyWorkflowInstanceLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _encyWorkflowInstanceLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _encyWorkflowInstanceLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowInstanceLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowInstance getWorkflowInstance(
		long companyId, long groupId, String className, long classPK) {

		return _encyWorkflowInstanceLocalService.getWorkflowInstance(
			companyId, groupId, className, classPK);
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowInstance getWorkflowInstance(
		String className, long classPK) {

		return _encyWorkflowInstanceLocalService.getWorkflowInstance(
			className, classPK);
	}

	@Override
	public boolean hasWorkflowInstance(
		long companyId, long groupId, String className, long classPK) {

		return _encyWorkflowInstanceLocalService.hasWorkflowInstance(
			companyId, groupId, className, classPK);
	}

	@Override
	public boolean hasWorkflowInstance(String className, long classPK) {
		return _encyWorkflowInstanceLocalService.hasWorkflowInstance(
			className, classPK);
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowInstance
			startWorkflowInstance(
				long companyId, long groupId, long userId, String className,
				long classPK,
				java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowInstanceLocalService.startWorkflowInstance(
			companyId, groupId, userId, className, classPK, workflowContext);
	}

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
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowInstance
		updateEncyWorkflowInstance(
			cz.csob.ency.workflow.model.EncyWorkflowInstance
				encyWorkflowInstance) {

		return _encyWorkflowInstanceLocalService.updateEncyWorkflowInstance(
			encyWorkflowInstance);
	}

	@Override
	public EncyWorkflowInstanceLocalService getWrappedService() {
		return _encyWorkflowInstanceLocalService;
	}

	@Override
	public void setWrappedService(
		EncyWorkflowInstanceLocalService encyWorkflowInstanceLocalService) {

		_encyWorkflowInstanceLocalService = encyWorkflowInstanceLocalService;
	}

	private EncyWorkflowInstanceLocalService _encyWorkflowInstanceLocalService;

}