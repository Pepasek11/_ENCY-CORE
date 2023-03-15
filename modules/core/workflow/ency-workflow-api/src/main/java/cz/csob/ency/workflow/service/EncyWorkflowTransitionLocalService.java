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
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
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

import cz.csob.ency.workflow.definition.EncyWorkflowTransitionDefinition;
import cz.csob.ency.workflow.model.EncyWorkflowState;
import cz.csob.ency.workflow.model.EncyWorkflowTransition;

import java.io.Serializable;

import java.util.List;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for EncyWorkflowTransition. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowTransitionLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface EncyWorkflowTransitionLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>cz.csob.ency.workflow.service.impl.EncyWorkflowTransitionLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the ency workflow transition local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link EncyWorkflowTransitionLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public EncyWorkflowTransition addEncyWorkflowTransition(
		EncyWorkflowTransition encyWorkflowTransition);

	/**
	 * Create new EncyWorkflowState entry, but do not persist it.
	 *
	 * @return EncyWorkflowState
	 */
	@Transactional(enabled = false)
	public EncyWorkflowTransition create();

	/**
	 * Creates a new ency workflow transition with the primary key. Does not add the ency workflow transition to the database.
	 *
	 * @param transitionId the primary key for the new ency workflow transition
	 * @return the new ency workflow transition
	 */
	@Transactional(enabled = false)
	public EncyWorkflowTransition createEncyWorkflowTransition(
		long transitionId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deactivae old states for given workflow. List of valid states is given and all other states are
	 * considered ad deprecated, thus are marked inactive.
	 *
	 * @param stateId
	 * @param activeTransitionNames
	 */
	public void deactivateOldWorkflowStateTransitions(
		long stateId, Set<String> activeTransitionNames);

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
	@Indexable(type = IndexableType.DELETE)
	public EncyWorkflowTransition deleteEncyWorkflowTransition(
		EncyWorkflowTransition encyWorkflowTransition);

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
	@Indexable(type = IndexableType.DELETE)
	public EncyWorkflowTransition deleteEncyWorkflowTransition(
			long transitionId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowTransitionModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowTransitionModelImpl</code>.
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
	public EncyWorkflowTransition fetchEncyWorkflowTransition(
		long transitionId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EncyWorkflowTransition fetchEncyWorkflowTransition(
		long stateId, String name);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the ency workflow transition with the primary key.
	 *
	 * @param transitionId the primary key of the ency workflow transition
	 * @return the ency workflow transition
	 * @throws PortalException if a ency workflow transition with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EncyWorkflowTransition getEncyWorkflowTransition(long transitionId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EncyWorkflowTransition> getEncyWorkflowTransitions(
		int start, int end);

	/**
	 * Returns the number of ency workflow transitions.
	 *
	 * @return the number of ency workflow transitions
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEncyWorkflowTransitionsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EncyWorkflowTransition> getOutgoingTransitions(long stateId);

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Save (add or update) Ency Workflow State into persistence. Transitions are saved separately at the workflow
	 * level to have available all target state references (State Ids)
	 *
	 * @param definition
	 * @param sourceEntry
	 * @return
	 */
	@Transactional
	public EncyWorkflowTransition saveWorkflowTransition(
		EncyWorkflowTransitionDefinition definition,
		EncyWorkflowState sourceEntry, EncyWorkflowState targetEntry);

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
	@Indexable(type = IndexableType.REINDEX)
	public EncyWorkflowTransition updateEncyWorkflowTransition(
		EncyWorkflowTransition encyWorkflowTransition);

}