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
 * Provides a wrapper for {@link EncyWorkflowLocalService}.
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowLocalService
 * @generated
 */
public class EncyWorkflowLocalServiceWrapper
	implements EncyWorkflowLocalService,
			   ServiceWrapper<EncyWorkflowLocalService> {

	public EncyWorkflowLocalServiceWrapper() {
		this(null);
	}

	public EncyWorkflowLocalServiceWrapper(
		EncyWorkflowLocalService encyWorkflowLocalService) {

		_encyWorkflowLocalService = encyWorkflowLocalService;
	}

	/**
	 * Adds the ency workflow to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflow the ency workflow
	 * @return the ency workflow that was added
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflow addEncyWorkflow(
		cz.csob.ency.workflow.model.EncyWorkflow encyWorkflow) {

		return _encyWorkflowLocalService.addEncyWorkflow(encyWorkflow);
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflow create() {
		return _encyWorkflowLocalService.create();
	}

	/**
	 * Creates a new ency workflow with the primary key. Does not add the ency workflow to the database.
	 *
	 * @param workflowId the primary key for the new ency workflow
	 * @return the new ency workflow
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflow createEncyWorkflow(
		long workflowId) {

		return _encyWorkflowLocalService.createEncyWorkflow(workflowId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deactivates workflow entry, i.e. when definition is unloaded.
	 *
	 * @param definitionClass
	 * @return
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflow deactivateWorkflow(
		String definitionClass) {

		return _encyWorkflowLocalService.deactivateWorkflow(definitionClass);
	}

	/**
	 * Deletes the ency workflow from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflow the ency workflow
	 * @return the ency workflow that was removed
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflow deleteEncyWorkflow(
		cz.csob.ency.workflow.model.EncyWorkflow encyWorkflow) {

		return _encyWorkflowLocalService.deleteEncyWorkflow(encyWorkflow);
	}

	/**
	 * Deletes the ency workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workflowId the primary key of the ency workflow
	 * @return the ency workflow that was removed
	 * @throws PortalException if a ency workflow with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflow deleteEncyWorkflow(
			long workflowId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowLocalService.deleteEncyWorkflow(workflowId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _encyWorkflowLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _encyWorkflowLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _encyWorkflowLocalService.dynamicQuery();
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

		return _encyWorkflowLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowModelImpl</code>.
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

		return _encyWorkflowLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowModelImpl</code>.
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

		return _encyWorkflowLocalService.dynamicQuery(
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

		return _encyWorkflowLocalService.dynamicQueryCount(dynamicQuery);
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

		return _encyWorkflowLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflow fetchEncyWorkflow(
		long workflowId) {

		return _encyWorkflowLocalService.fetchEncyWorkflow(workflowId);
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflow fetchEncyWorkflow(
		String className) {

		return _encyWorkflowLocalService.fetchEncyWorkflow(className);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _encyWorkflowLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the ency workflow with the primary key.
	 *
	 * @param workflowId the primary key of the ency workflow
	 * @return the ency workflow
	 * @throws PortalException if a ency workflow with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflow getEncyWorkflow(
			long workflowId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowLocalService.getEncyWorkflow(workflowId);
	}

	/**
	 * Returns a range of all the ency workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @return the range of ency workflows
	 */
	@Override
	public java.util.List<cz.csob.ency.workflow.model.EncyWorkflow>
		getEncyWorkflows(int start, int end) {

		return _encyWorkflowLocalService.getEncyWorkflows(start, end);
	}

	/**
	 * Returns the number of ency workflows.
	 *
	 * @return the number of ency workflows
	 */
	@Override
	public int getEncyWorkflowsCount() {
		return _encyWorkflowLocalService.getEncyWorkflowsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _encyWorkflowLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _encyWorkflowLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Save (Add or update) Ency Workflow into persistence. Also save its states.
	 *
	 * @param definition
	 * @return
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflow saveWorkflow(
		cz.csob.ency.workflow.definition.EncyWorkflowDefinition definition) {

		return _encyWorkflowLocalService.saveWorkflow(definition);
	}

	/**
	 * Updates the ency workflow in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflow the ency workflow
	 * @return the ency workflow that was updated
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflow updateEncyWorkflow(
		cz.csob.ency.workflow.model.EncyWorkflow encyWorkflow) {

		return _encyWorkflowLocalService.updateEncyWorkflow(encyWorkflow);
	}

	@Override
	public EncyWorkflowLocalService getWrappedService() {
		return _encyWorkflowLocalService;
	}

	@Override
	public void setWrappedService(
		EncyWorkflowLocalService encyWorkflowLocalService) {

		_encyWorkflowLocalService = encyWorkflowLocalService;
	}

	private EncyWorkflowLocalService _encyWorkflowLocalService;

}