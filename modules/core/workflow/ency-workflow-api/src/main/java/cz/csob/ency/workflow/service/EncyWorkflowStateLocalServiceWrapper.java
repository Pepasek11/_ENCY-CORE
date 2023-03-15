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
 * Provides a wrapper for {@link EncyWorkflowStateLocalService}.
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowStateLocalService
 * @generated
 */
public class EncyWorkflowStateLocalServiceWrapper
	implements EncyWorkflowStateLocalService,
			   ServiceWrapper<EncyWorkflowStateLocalService> {

	public EncyWorkflowStateLocalServiceWrapper() {
		this(null);
	}

	public EncyWorkflowStateLocalServiceWrapper(
		EncyWorkflowStateLocalService encyWorkflowStateLocalService) {

		_encyWorkflowStateLocalService = encyWorkflowStateLocalService;
	}

	/**
	 * Adds the ency workflow state to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowStateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowState the ency workflow state
	 * @return the ency workflow state that was added
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowState addEncyWorkflowState(
		cz.csob.ency.workflow.model.EncyWorkflowState encyWorkflowState) {

		return _encyWorkflowStateLocalService.addEncyWorkflowState(
			encyWorkflowState);
	}

	/**
	 * Create new EncyWorkflowState entry, but do not persist it.
	 *
	 * @return EncyWorkflowState
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowState create() {
		return _encyWorkflowStateLocalService.create();
	}

	/**
	 * Creates a new ency workflow state with the primary key. Does not add the ency workflow state to the database.
	 *
	 * @param stateId the primary key for the new ency workflow state
	 * @return the new ency workflow state
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowState
		createEncyWorkflowState(long stateId) {

		return _encyWorkflowStateLocalService.createEncyWorkflowState(stateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowStateLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deactivae old states for given workflow. List of valid states is given and all other states are
	 * considered ad deprecated, thus are marked inactive.
	 *
	 * @param workflowId
	 * @param activeStatesNames
	 */
	@Override
	public void deactivateOldWorkflowStates(
		long workflowId, java.util.Set<String> activeStatesNames) {

		_encyWorkflowStateLocalService.deactivateOldWorkflowStates(
			workflowId, activeStatesNames);
	}

	/**
	 * Deletes the ency workflow state from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowStateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowState the ency workflow state
	 * @return the ency workflow state that was removed
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowState
		deleteEncyWorkflowState(
			cz.csob.ency.workflow.model.EncyWorkflowState encyWorkflowState) {

		return _encyWorkflowStateLocalService.deleteEncyWorkflowState(
			encyWorkflowState);
	}

	/**
	 * Deletes the ency workflow state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowStateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stateId the primary key of the ency workflow state
	 * @return the ency workflow state that was removed
	 * @throws PortalException if a ency workflow state with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowState
			deleteEncyWorkflowState(long stateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowStateLocalService.deleteEncyWorkflowState(stateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowStateLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _encyWorkflowStateLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _encyWorkflowStateLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _encyWorkflowStateLocalService.dynamicQuery();
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

		return _encyWorkflowStateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowStateModelImpl</code>.
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

		return _encyWorkflowStateLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowStateModelImpl</code>.
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

		return _encyWorkflowStateLocalService.dynamicQuery(
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

		return _encyWorkflowStateLocalService.dynamicQueryCount(dynamicQuery);
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

		return _encyWorkflowStateLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowState fetchEncyWorkflowState(
		long stateId) {

		return _encyWorkflowStateLocalService.fetchEncyWorkflowState(stateId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _encyWorkflowStateLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the ency workflow state with the primary key.
	 *
	 * @param stateId the primary key of the ency workflow state
	 * @return the ency workflow state
	 * @throws PortalException if a ency workflow state with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowState getEncyWorkflowState(
			long stateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowStateLocalService.getEncyWorkflowState(stateId);
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowState getEncyWorkflowState(
			long workflowId, String stateName)
		throws cz.csob.ency.workflow.exception.NoSuchStateException {

		return _encyWorkflowStateLocalService.getEncyWorkflowState(
			workflowId, stateName);
	}

	/**
	 * Returns a range of all the ency workflow states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @return the range of ency workflow states
	 */
	@Override
	public java.util.List<cz.csob.ency.workflow.model.EncyWorkflowState>
		getEncyWorkflowStates(int start, int end) {

		return _encyWorkflowStateLocalService.getEncyWorkflowStates(start, end);
	}

	/**
	 * Returns the number of ency workflow states.
	 *
	 * @return the number of ency workflow states
	 */
	@Override
	public int getEncyWorkflowStatesCount() {
		return _encyWorkflowStateLocalService.getEncyWorkflowStatesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _encyWorkflowStateLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _encyWorkflowStateLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowStateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Save (add or update) Ency Workflow State into persistence. Transitions are saved in workflow service, after
	 * references to all states are available.
	 *
	 * @param definition
	 * @param workflowEntry
	 * @return
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowState saveWorkflowState(
		cz.csob.ency.workflow.definition.EncyWorkflowStateDefinition definition,
		cz.csob.ency.workflow.model.EncyWorkflow workflowEntry) {

		return _encyWorkflowStateLocalService.saveWorkflowState(
			definition, workflowEntry);
	}

	/**
	 * Updates the ency workflow state in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowStateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowState the ency workflow state
	 * @return the ency workflow state that was updated
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowState
		updateEncyWorkflowState(
			cz.csob.ency.workflow.model.EncyWorkflowState encyWorkflowState) {

		return _encyWorkflowStateLocalService.updateEncyWorkflowState(
			encyWorkflowState);
	}

	@Override
	public EncyWorkflowStateLocalService getWrappedService() {
		return _encyWorkflowStateLocalService;
	}

	@Override
	public void setWrappedService(
		EncyWorkflowStateLocalService encyWorkflowStateLocalService) {

		_encyWorkflowStateLocalService = encyWorkflowStateLocalService;
	}

	private EncyWorkflowStateLocalService _encyWorkflowStateLocalService;

}