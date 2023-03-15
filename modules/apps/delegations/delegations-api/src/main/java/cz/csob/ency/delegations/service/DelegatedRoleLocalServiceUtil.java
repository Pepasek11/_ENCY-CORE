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

import cz.csob.ency.delegations.model.DelegatedRole;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DelegatedRole. This utility wraps
 * <code>cz.csob.ency.delegations.service.impl.DelegatedRoleLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Miroslav Čermák
 * @see DelegatedRoleLocalService
 * @generated
 */
public class DelegatedRoleLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>cz.csob.ency.delegations.service.impl.DelegatedRoleLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the delegated role to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DelegatedRoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param delegatedRole the delegated role
	 * @return the delegated role that was added
	 */
	public static DelegatedRole addDelegatedRole(DelegatedRole delegatedRole) {
		return getService().addDelegatedRole(delegatedRole);
	}

	public static DelegatedRole create() {
		return getService().create();
	}

	/**
	 * Creates a new delegated role with the primary key. Does not add the delegated role to the database.
	 *
	 * @param roleId the primary key for the new delegated role
	 * @return the new delegated role
	 */
	public static DelegatedRole createDelegatedRole(long roleId) {
		return getService().createDelegatedRole(roleId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static DelegatedRole createWithId(long primaryKey) {
		return getService().createWithId(primaryKey);
	}

	/**
	 * Deletes the delegated role from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DelegatedRoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param delegatedRole the delegated role
	 * @return the delegated role that was removed
	 */
	public static DelegatedRole deleteDelegatedRole(
		DelegatedRole delegatedRole) {

		return getService().deleteDelegatedRole(delegatedRole);
	}

	/**
	 * Deletes the delegated role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DelegatedRoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roleId the primary key of the delegated role
	 * @return the delegated role that was removed
	 * @throws PortalException if a delegated role with the primary key could not be found
	 */
	public static DelegatedRole deleteDelegatedRole(long roleId)
		throws PortalException {

		return getService().deleteDelegatedRole(roleId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.delegations.model.impl.DelegatedRoleModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.delegations.model.impl.DelegatedRoleModelImpl</code>.
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

	public static DelegatedRole fetchDelegatedRole(long roleId) {
		return getService().fetchDelegatedRole(roleId);
	}

	public static DelegatedRole fetchDelegatedRole(String code) {
		return getService().fetchDelegatedRole(code);
	}

	public static DelegatedRole fetchOrCreate(
		long primaryKey,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().fetchOrCreate(primaryKey, serviceContext);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the delegated role with the primary key.
	 *
	 * @param roleId the primary key of the delegated role
	 * @return the delegated role
	 * @throws PortalException if a delegated role with the primary key could not be found
	 */
	public static DelegatedRole getDelegatedRole(long roleId)
		throws PortalException {

		return getService().getDelegatedRole(roleId);
	}

	public static DelegatedRole getDelegatedRole(String code)
		throws cz.csob.ency.delegations.exception.NoSuchDelegatedRoleException {

		return getService().getDelegatedRole(code);
	}

	/**
	 * Returns a range of all the delegated roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.delegations.model.impl.DelegatedRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of delegated roles
	 * @param end the upper bound of the range of delegated roles (not inclusive)
	 * @return the range of delegated roles
	 */
	public static List<DelegatedRole> getDelegatedRoles(int start, int end) {
		return getService().getDelegatedRoles(start, end);
	}

	public static List<DelegatedRole> getDelegatedRoles(long groupId) {
		return getService().getDelegatedRoles(groupId);
	}

	/**
	 * Returns the number of delegated roles.
	 *
	 * @return the number of delegated roles
	 */
	public static int getDelegatedRolesCount() {
		return getService().getDelegatedRolesCount();
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
	 * Updates the delegated role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DelegatedRoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param delegatedRole the delegated role
	 * @return the delegated role that was updated
	 */
	public static DelegatedRole updateDelegatedRole(
		DelegatedRole delegatedRole) {

		return getService().updateDelegatedRole(delegatedRole);
	}

	public static DelegatedRole updateDelegatedRole(
			long roleId, String code, String title, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateDelegatedRole(
			roleId, code, title, description, serviceContext);
	}

	public static DelegatedRoleLocalService getService() {
		return _service;
	}

	private static volatile DelegatedRoleLocalService _service;

}