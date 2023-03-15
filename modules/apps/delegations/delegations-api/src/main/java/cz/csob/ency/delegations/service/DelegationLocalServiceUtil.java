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

package cz.csob.ency.delegations.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import cz.csob.ency.delegations.model.Delegation;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Delegation. This utility wraps
 * <code>cz.csob.ency.delegations.service.impl.DelegationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Miroslav Čermák
 * @see DelegationLocalService
 * @generated
 */
public class DelegationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>cz.csob.ency.delegations.service.impl.DelegationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the delegation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DelegationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param delegation the delegation
	 * @return the delegation that was added
	 */
	public static Delegation addDelegation(Delegation delegation) {
		return getService().addDelegation(delegation);
	}

	public static Delegation create() {
		return getService().create();
	}

	/**
	 * Creates a new delegation with the primary key. Does not add the delegation to the database.
	 *
	 * @param delegationId the primary key for the new delegation
	 * @return the new delegation
	 */
	public static Delegation createDelegation(long delegationId) {
		return getService().createDelegation(delegationId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static Delegation createWithId(long primaryKey) {
		return getService().createWithId(primaryKey);
	}

	/**
	 * Deletes the delegation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DelegationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param delegation the delegation
	 * @return the delegation that was removed
	 */
	public static Delegation deleteDelegation(Delegation delegation) {
		return getService().deleteDelegation(delegation);
	}

	/**
	 * Deletes the delegation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DelegationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param delegationId the primary key of the delegation
	 * @return the delegation that was removed
	 * @throws PortalException if a delegation with the primary key could not be found
	 */
	public static Delegation deleteDelegation(long delegationId)
		throws PortalException {

		return getService().deleteDelegation(delegationId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.delegations.model.impl.DelegationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.delegations.model.impl.DelegationModelImpl</code>.
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

	public static Delegation fetchDelegation(long delegationId) {
		return getService().fetchDelegation(delegationId);
	}

	public static Delegation fetchOrCreate(
		long primaryKey,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().fetchOrCreate(primaryKey, serviceContext);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the delegation with the primary key.
	 *
	 * @param delegationId the primary key of the delegation
	 * @return the delegation
	 * @throws PortalException if a delegation with the primary key could not be found
	 */
	public static Delegation getDelegation(long delegationId)
		throws PortalException {

		return getService().getDelegation(delegationId);
	}

	/**
	 * Returns a range of all the delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.delegations.model.impl.DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @return the range of delegations
	 */
	public static List<Delegation> getDelegations(int start, int end) {
		return getService().getDelegations(start, end);
	}

	public static List<Delegation> getDelegations(long groupId, long roleId) {
		return getService().getDelegations(groupId, roleId);
	}

	/**
	 * Returns the number of delegations.
	 *
	 * @return the number of delegations
	 */
	public static int getDelegationsCount() {
		return getService().getDelegationsCount();
	}

	public static List<Delegation> getDelegationsOfUser(
		long groupId, long roleId, long delegatingUserId) {

		return getService().getDelegationsOfUser(
			groupId, roleId, delegatingUserId);
	}

	public static List<Delegation> getDelegationsOfUser(
		long groupId, String roleCode, long delegatingUserId) {

		return getService().getDelegationsOfUser(
			groupId, roleCode, delegatingUserId);
	}

	public static List<Delegation> getDelegationsToUser(
		long groupId, long roleId, long delegatedUserId) {

		return getService().getDelegationsToUser(
			groupId, roleId, delegatedUserId);
	}

	public static List<Delegation> getDelegationsToUser(
		long groupId, String roleCode, long delegatedUserId) {

		return getService().getDelegationsToUser(
			groupId, roleCode, delegatedUserId);
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
	 * Updates the delegation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DelegationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param delegation the delegation
	 * @return the delegation that was updated
	 */
	public static Delegation updateDelegation(Delegation delegation) {
		return getService().updateDelegation(delegation);
	}

	public static Delegation updateDelegation(
			long delegationId, long roleId, long delegatingUserId,
			long delegatedUserId, String note,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateDelegation(
			delegationId, roleId, delegatingUserId, delegatedUserId, note,
			serviceContext);
	}

	public static DelegationLocalService getService() {
		return _service;
	}

	private static volatile DelegationLocalService _service;

}