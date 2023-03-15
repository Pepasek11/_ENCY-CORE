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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import cz.csob.ency.workflow.model.EncyWorkflowState;

import java.io.Serializable;

import java.util.List;
import java.util.Set;

/**
 * Provides the local service utility for EncyWorkflowState. This utility wraps
 * <code>cz.csob.ency.workflow.service.impl.EncyWorkflowStateLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowStateLocalService
 * @generated
 */
public class EncyWorkflowStateLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>cz.csob.ency.workflow.service.impl.EncyWorkflowStateLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static EncyWorkflowState addEncyWorkflowState(
		EncyWorkflowState encyWorkflowState) {

		return getService().addEncyWorkflowState(encyWorkflowState);
	}

	/**
	 * Create new EncyWorkflowState entry, but do not persist it.
	 *
	 * @return EncyWorkflowState
	 */
	public static EncyWorkflowState create() {
		return getService().create();
	}

	/**
	 * Creates a new ency workflow state with the primary key. Does not add the ency workflow state to the database.
	 *
	 * @param stateId the primary key for the new ency workflow state
	 * @return the new ency workflow state
	 */
	public static EncyWorkflowState createEncyWorkflowState(long stateId) {
		return getService().createEncyWorkflowState(stateId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deactivae old states for given workflow. List of valid states is given and all other states are
	 * considered ad deprecated, thus are marked inactive.
	 *
	 * @param workflowId
	 * @param activeStatesNames
	 */
	public static void deactivateOldWorkflowStates(
		long workflowId, Set<String> activeStatesNames) {

		getService().deactivateOldWorkflowStates(workflowId, activeStatesNames);
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
	public static EncyWorkflowState deleteEncyWorkflowState(
		EncyWorkflowState encyWorkflowState) {

		return getService().deleteEncyWorkflowState(encyWorkflowState);
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
	public static EncyWorkflowState deleteEncyWorkflowState(long stateId)
		throws PortalException {

		return getService().deleteEncyWorkflowState(stateId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static EncyWorkflowState fetchEncyWorkflowState(long stateId) {
		return getService().fetchEncyWorkflowState(stateId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the ency workflow state with the primary key.
	 *
	 * @param stateId the primary key of the ency workflow state
	 * @return the ency workflow state
	 * @throws PortalException if a ency workflow state with the primary key could not be found
	 */
	public static EncyWorkflowState getEncyWorkflowState(long stateId)
		throws PortalException {

		return getService().getEncyWorkflowState(stateId);
	}

	public static EncyWorkflowState getEncyWorkflowState(
			long workflowId, String stateName)
		throws cz.csob.ency.workflow.exception.NoSuchStateException {

		return getService().getEncyWorkflowState(workflowId, stateName);
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
	public static List<EncyWorkflowState> getEncyWorkflowStates(
		int start, int end) {

		return getService().getEncyWorkflowStates(start, end);
	}

	/**
	 * Returns the number of ency workflow states.
	 *
	 * @return the number of ency workflow states
	 */
	public static int getEncyWorkflowStatesCount() {
		return getService().getEncyWorkflowStatesCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Save (add or update) Ency Workflow State into persistence. Transitions are saved in workflow service, after
	 * references to all states are available.
	 *
	 * @param definition
	 * @param workflowEntry
	 * @return
	 */
	public static EncyWorkflowState saveWorkflowState(
		cz.csob.ency.workflow.definition.EncyWorkflowStateDefinition definition,
		cz.csob.ency.workflow.model.EncyWorkflow workflowEntry) {

		return getService().saveWorkflowState(definition, workflowEntry);
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
	public static EncyWorkflowState updateEncyWorkflowState(
		EncyWorkflowState encyWorkflowState) {

		return getService().updateEncyWorkflowState(encyWorkflowState);
	}

	public static EncyWorkflowStateLocalService getService() {
		return _service;
	}

	private static volatile EncyWorkflowStateLocalService _service;

}