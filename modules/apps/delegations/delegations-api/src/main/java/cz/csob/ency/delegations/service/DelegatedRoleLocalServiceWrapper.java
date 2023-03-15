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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DelegatedRoleLocalService}.
 *
 * @author Miroslav Čermák
 * @see DelegatedRoleLocalService
 * @generated
 */
public class DelegatedRoleLocalServiceWrapper
	implements DelegatedRoleLocalService,
			   ServiceWrapper<DelegatedRoleLocalService> {

	public DelegatedRoleLocalServiceWrapper() {
		this(null);
	}

	public DelegatedRoleLocalServiceWrapper(
		DelegatedRoleLocalService delegatedRoleLocalService) {

		_delegatedRoleLocalService = delegatedRoleLocalService;
	}

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
	@Override
	public cz.csob.ency.delegations.model.DelegatedRole addDelegatedRole(
		cz.csob.ency.delegations.model.DelegatedRole delegatedRole) {

		return _delegatedRoleLocalService.addDelegatedRole(delegatedRole);
	}

	@Override
	public cz.csob.ency.delegations.model.DelegatedRole create() {
		return _delegatedRoleLocalService.create();
	}

	/**
	 * Creates a new delegated role with the primary key. Does not add the delegated role to the database.
	 *
	 * @param roleId the primary key for the new delegated role
	 * @return the new delegated role
	 */
	@Override
	public cz.csob.ency.delegations.model.DelegatedRole createDelegatedRole(
		long roleId) {

		return _delegatedRoleLocalService.createDelegatedRole(roleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _delegatedRoleLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public cz.csob.ency.delegations.model.DelegatedRole createWithId(
		long primaryKey) {

		return _delegatedRoleLocalService.createWithId(primaryKey);
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
	@Override
	public cz.csob.ency.delegations.model.DelegatedRole deleteDelegatedRole(
		cz.csob.ency.delegations.model.DelegatedRole delegatedRole) {

		return _delegatedRoleLocalService.deleteDelegatedRole(delegatedRole);
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
	@Override
	public cz.csob.ency.delegations.model.DelegatedRole deleteDelegatedRole(
			long roleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _delegatedRoleLocalService.deleteDelegatedRole(roleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _delegatedRoleLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _delegatedRoleLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _delegatedRoleLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _delegatedRoleLocalService.dynamicQuery();
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

		return _delegatedRoleLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _delegatedRoleLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _delegatedRoleLocalService.dynamicQuery(
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

		return _delegatedRoleLocalService.dynamicQueryCount(dynamicQuery);
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

		return _delegatedRoleLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public cz.csob.ency.delegations.model.DelegatedRole fetchDelegatedRole(
		long roleId) {

		return _delegatedRoleLocalService.fetchDelegatedRole(roleId);
	}

	@Override
	public cz.csob.ency.delegations.model.DelegatedRole fetchDelegatedRole(
		String code) {

		return _delegatedRoleLocalService.fetchDelegatedRole(code);
	}

	@Override
	public cz.csob.ency.delegations.model.DelegatedRole fetchOrCreate(
		long primaryKey,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _delegatedRoleLocalService.fetchOrCreate(
			primaryKey, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _delegatedRoleLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the delegated role with the primary key.
	 *
	 * @param roleId the primary key of the delegated role
	 * @return the delegated role
	 * @throws PortalException if a delegated role with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.delegations.model.DelegatedRole getDelegatedRole(
			long roleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _delegatedRoleLocalService.getDelegatedRole(roleId);
	}

	@Override
	public cz.csob.ency.delegations.model.DelegatedRole getDelegatedRole(
			String code)
		throws cz.csob.ency.delegations.exception.NoSuchDelegatedRoleException {

		return _delegatedRoleLocalService.getDelegatedRole(code);
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
	@Override
	public java.util.List<cz.csob.ency.delegations.model.DelegatedRole>
		getDelegatedRoles(int start, int end) {

		return _delegatedRoleLocalService.getDelegatedRoles(start, end);
	}

	@Override
	public java.util.List<cz.csob.ency.delegations.model.DelegatedRole>
		getDelegatedRoles(long groupId) {

		return _delegatedRoleLocalService.getDelegatedRoles(groupId);
	}

	/**
	 * Returns the number of delegated roles.
	 *
	 * @return the number of delegated roles
	 */
	@Override
	public int getDelegatedRolesCount() {
		return _delegatedRoleLocalService.getDelegatedRolesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _delegatedRoleLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _delegatedRoleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _delegatedRoleLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public cz.csob.ency.delegations.model.DelegatedRole updateDelegatedRole(
		cz.csob.ency.delegations.model.DelegatedRole delegatedRole) {

		return _delegatedRoleLocalService.updateDelegatedRole(delegatedRole);
	}

	@Override
	public cz.csob.ency.delegations.model.DelegatedRole updateDelegatedRole(
			long roleId, String code, String title, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _delegatedRoleLocalService.updateDelegatedRole(
			roleId, code, title, description, serviceContext);
	}

	@Override
	public DelegatedRoleLocalService getWrappedService() {
		return _delegatedRoleLocalService;
	}

	@Override
	public void setWrappedService(
		DelegatedRoleLocalService delegatedRoleLocalService) {

		_delegatedRoleLocalService = delegatedRoleLocalService;
	}

	private DelegatedRoleLocalService _delegatedRoleLocalService;

}