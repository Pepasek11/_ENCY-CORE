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
 * Provides a wrapper for {@link EncyWorkflowTransitionLocalService}.
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowTransitionLocalService
 * @generated
 */
public class EncyWorkflowTransitionLocalServiceWrapper
	implements EncyWorkflowTransitionLocalService,
			   ServiceWrapper<EncyWorkflowTransitionLocalService> {

	public EncyWorkflowTransitionLocalServiceWrapper() {
		this(null);
	}

	public EncyWorkflowTransitionLocalServiceWrapper(
		EncyWorkflowTransitionLocalService encyWorkflowTransitionLocalService) {

		_encyWorkflowTransitionLocalService =
			encyWorkflowTransitionLocalService;
	}

	/**
	 * Adds the ency workflow transition to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowTransitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowTransition the ency workflow transition
	 * @return the ency workflow transition that was added
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowTransition
		addEncyWorkflowTransition(
			cz.csob.ency.workflow.model.EncyWorkflowTransition
				encyWorkflowTransition) {

		return _encyWorkflowTransitionLocalService.addEncyWorkflowTransition(
			encyWorkflowTransition);
	}

	/**
	 * Create new EncyWorkflowState entry, but do not persist it.
	 *
	 * @return EncyWorkflowState
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowTransition create() {
		return _encyWorkflowTransitionLocalService.create();
	}

	/**
	 * Creates a new ency workflow transition with the primary key. Does not add the ency workflow transition to the database.
	 *
	 * @param transitionId the primary key for the new ency workflow transition
	 * @return the new ency workflow transition
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowTransition
		createEncyWorkflowTransition(long transitionId) {

		return _encyWorkflowTransitionLocalService.createEncyWorkflowTransition(
			transitionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowTransitionLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deactivae old states for given workflow. List of valid states is given and all other states are
	 * considered ad deprecated, thus are marked inactive.
	 *
	 * @param stateId
	 * @param activeTransitionNames
	 */
	@Override
	public void deactivateOldWorkflowStateTransitions(
		long stateId, java.util.Set<String> activeTransitionNames) {

		_encyWorkflowTransitionLocalService.
			deactivateOldWorkflowStateTransitions(
				stateId, activeTransitionNames);
	}

	/**
	 * Deletes the ency workflow transition from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowTransitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowTransition the ency workflow transition
	 * @return the ency workflow transition that was removed
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowTransition
		deleteEncyWorkflowTransition(
			cz.csob.ency.workflow.model.EncyWorkflowTransition
				encyWorkflowTransition) {

		return _encyWorkflowTransitionLocalService.deleteEncyWorkflowTransition(
			encyWorkflowTransition);
	}

	/**
	 * Deletes the ency workflow transition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowTransitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param transitionId the primary key of the ency workflow transition
	 * @return the ency workflow transition that was removed
	 * @throws PortalException if a ency workflow transition with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowTransition
			deleteEncyWorkflowTransition(long transitionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowTransitionLocalService.deleteEncyWorkflowTransition(
			transitionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowTransitionLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _encyWorkflowTransitionLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _encyWorkflowTransitionLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _encyWorkflowTransitionLocalService.dynamicQuery();
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

		return _encyWorkflowTransitionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowTransitionModelImpl</code>.
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

		return _encyWorkflowTransitionLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowTransitionModelImpl</code>.
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

		return _encyWorkflowTransitionLocalService.dynamicQuery(
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

		return _encyWorkflowTransitionLocalService.dynamicQueryCount(
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

		return _encyWorkflowTransitionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowTransition
		fetchEncyWorkflowTransition(long transitionId) {

		return _encyWorkflowTransitionLocalService.fetchEncyWorkflowTransition(
			transitionId);
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowTransition
		fetchEncyWorkflowTransition(long stateId, String name) {

		return _encyWorkflowTransitionLocalService.fetchEncyWorkflowTransition(
			stateId, name);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _encyWorkflowTransitionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the ency workflow transition with the primary key.
	 *
	 * @param transitionId the primary key of the ency workflow transition
	 * @return the ency workflow transition
	 * @throws PortalException if a ency workflow transition with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowTransition
			getEncyWorkflowTransition(long transitionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowTransitionLocalService.getEncyWorkflowTransition(
			transitionId);
	}

	/**
	 * Returns a range of all the ency workflow transitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @return the range of ency workflow transitions
	 */
	@Override
	public java.util.List<cz.csob.ency.workflow.model.EncyWorkflowTransition>
		getEncyWorkflowTransitions(int start, int end) {

		return _encyWorkflowTransitionLocalService.getEncyWorkflowTransitions(
			start, end);
	}

	/**
	 * Returns the number of ency workflow transitions.
	 *
	 * @return the number of ency workflow transitions
	 */
	@Override
	public int getEncyWorkflowTransitionsCount() {
		return _encyWorkflowTransitionLocalService.
			getEncyWorkflowTransitionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _encyWorkflowTransitionLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _encyWorkflowTransitionLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<cz.csob.ency.workflow.model.EncyWorkflowTransition>
		getOutgoingTransitions(long stateId) {

		return _encyWorkflowTransitionLocalService.getOutgoingTransitions(
			stateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowTransitionLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Save (add or update) Ency Workflow State into persistence. Transitions are saved separately at the workflow
	 * level to have available all target state references (State Ids)
	 *
	 * @param definition
	 * @param sourceEntry
	 * @return
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowTransition
		saveWorkflowTransition(
			cz.csob.ency.workflow.definition.EncyWorkflowTransitionDefinition
				definition,
			cz.csob.ency.workflow.model.EncyWorkflowState sourceEntry,
			cz.csob.ency.workflow.model.EncyWorkflowState targetEntry) {

		return _encyWorkflowTransitionLocalService.saveWorkflowTransition(
			definition, sourceEntry, targetEntry);
	}

	/**
	 * Updates the ency workflow transition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowTransitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowTransition the ency workflow transition
	 * @return the ency workflow transition that was updated
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowTransition
		updateEncyWorkflowTransition(
			cz.csob.ency.workflow.model.EncyWorkflowTransition
				encyWorkflowTransition) {

		return _encyWorkflowTransitionLocalService.updateEncyWorkflowTransition(
			encyWorkflowTransition);
	}

	@Override
	public EncyWorkflowTransitionLocalService getWrappedService() {
		return _encyWorkflowTransitionLocalService;
	}

	@Override
	public void setWrappedService(
		EncyWorkflowTransitionLocalService encyWorkflowTransitionLocalService) {

		_encyWorkflowTransitionLocalService =
			encyWorkflowTransitionLocalService;
	}

	private EncyWorkflowTransitionLocalService
		_encyWorkflowTransitionLocalService;

}