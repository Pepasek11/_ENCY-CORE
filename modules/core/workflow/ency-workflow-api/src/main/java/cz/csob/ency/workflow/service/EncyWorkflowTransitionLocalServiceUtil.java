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

import cz.csob.ency.workflow.model.EncyWorkflowTransition;

import java.io.Serializable;

import java.util.List;
import java.util.Set;

/**
 * Provides the local service utility for EncyWorkflowTransition. This utility wraps
 * <code>cz.csob.ency.workflow.service.impl.EncyWorkflowTransitionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowTransitionLocalService
 * @generated
 */
public class EncyWorkflowTransitionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>cz.csob.ency.workflow.service.impl.EncyWorkflowTransitionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static EncyWorkflowTransition addEncyWorkflowTransition(
		EncyWorkflowTransition encyWorkflowTransition) {

		return getService().addEncyWorkflowTransition(encyWorkflowTransition);
	}

	/**
	 * Create new EncyWorkflowState entry, but do not persist it.
	 *
	 * @return EncyWorkflowState
	 */
	public static EncyWorkflowTransition create() {
		return getService().create();
	}

	/**
	 * Creates a new ency workflow transition with the primary key. Does not add the ency workflow transition to the database.
	 *
	 * @param transitionId the primary key for the new ency workflow transition
	 * @return the new ency workflow transition
	 */
	public static EncyWorkflowTransition createEncyWorkflowTransition(
		long transitionId) {

		return getService().createEncyWorkflowTransition(transitionId);
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
	 * @param stateId
	 * @param activeTransitionNames
	 */
	public static void deactivateOldWorkflowStateTransitions(
		long stateId, Set<String> activeTransitionNames) {

		getService().deactivateOldWorkflowStateTransitions(
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
	public static EncyWorkflowTransition deleteEncyWorkflowTransition(
		EncyWorkflowTransition encyWorkflowTransition) {

		return getService().deleteEncyWorkflowTransition(
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
	public static EncyWorkflowTransition deleteEncyWorkflowTransition(
			long transitionId)
		throws PortalException {

		return getService().deleteEncyWorkflowTransition(transitionId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowTransitionModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowTransitionModelImpl</code>.
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

	public static EncyWorkflowTransition fetchEncyWorkflowTransition(
		long transitionId) {

		return getService().fetchEncyWorkflowTransition(transitionId);
	}

	public static EncyWorkflowTransition fetchEncyWorkflowTransition(
		long stateId, String name) {

		return getService().fetchEncyWorkflowTransition(stateId, name);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the ency workflow transition with the primary key.
	 *
	 * @param transitionId the primary key of the ency workflow transition
	 * @return the ency workflow transition
	 * @throws PortalException if a ency workflow transition with the primary key could not be found
	 */
	public static EncyWorkflowTransition getEncyWorkflowTransition(
			long transitionId)
		throws PortalException {

		return getService().getEncyWorkflowTransition(transitionId);
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
	public static List<EncyWorkflowTransition> getEncyWorkflowTransitions(
		int start, int end) {

		return getService().getEncyWorkflowTransitions(start, end);
	}

	/**
	 * Returns the number of ency workflow transitions.
	 *
	 * @return the number of ency workflow transitions
	 */
	public static int getEncyWorkflowTransitionsCount() {
		return getService().getEncyWorkflowTransitionsCount();
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

	public static List<EncyWorkflowTransition> getOutgoingTransitions(
		long stateId) {

		return getService().getOutgoingTransitions(stateId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Save (add or update) Ency Workflow State into persistence. Transitions are saved separately at the workflow
	 * level to have available all target state references (State Ids)
	 *
	 * @param definition
	 * @param sourceEntry
	 * @return
	 */
	public static EncyWorkflowTransition saveWorkflowTransition(
		cz.csob.ency.workflow.definition.EncyWorkflowTransitionDefinition
			definition,
		cz.csob.ency.workflow.model.EncyWorkflowState sourceEntry,
		cz.csob.ency.workflow.model.EncyWorkflowState targetEntry) {

		return getService().saveWorkflowTransition(
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
	public static EncyWorkflowTransition updateEncyWorkflowTransition(
		EncyWorkflowTransition encyWorkflowTransition) {

		return getService().updateEncyWorkflowTransition(
			encyWorkflowTransition);
	}

	public static EncyWorkflowTransitionLocalService getService() {
		return _service;
	}

	private static volatile EncyWorkflowTransitionLocalService _service;

}