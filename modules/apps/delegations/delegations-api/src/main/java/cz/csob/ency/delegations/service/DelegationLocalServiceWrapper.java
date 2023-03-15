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
 * Provides a wrapper for {@link DelegationLocalService}.
 *
 * @author Miroslav Čermák
 * @see DelegationLocalService
 * @generated
 */
public class DelegationLocalServiceWrapper
	implements DelegationLocalService, ServiceWrapper<DelegationLocalService> {

	public DelegationLocalServiceWrapper() {
		this(null);
	}

	public DelegationLocalServiceWrapper(
		DelegationLocalService delegationLocalService) {

		_delegationLocalService = delegationLocalService;
	}

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
	@Override
	public cz.csob.ency.delegations.model.Delegation addDelegation(
		cz.csob.ency.delegations.model.Delegation delegation) {

		return _delegationLocalService.addDelegation(delegation);
	}

	@Override
	public cz.csob.ency.delegations.model.Delegation create() {
		return _delegationLocalService.create();
	}

	/**
	 * Creates a new delegation with the primary key. Does not add the delegation to the database.
	 *
	 * @param delegationId the primary key for the new delegation
	 * @return the new delegation
	 */
	@Override
	public cz.csob.ency.delegations.model.Delegation createDelegation(
		long delegationId) {

		return _delegationLocalService.createDelegation(delegationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _delegationLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public cz.csob.ency.delegations.model.Delegation createWithId(
		long primaryKey) {

		return _delegationLocalService.createWithId(primaryKey);
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
	@Override
	public cz.csob.ency.delegations.model.Delegation deleteDelegation(
		cz.csob.ency.delegations.model.Delegation delegation) {

		return _delegationLocalService.deleteDelegation(delegation);
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
	@Override
	public cz.csob.ency.delegations.model.Delegation deleteDelegation(
			long delegationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _delegationLocalService.deleteDelegation(delegationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _delegationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _delegationLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _delegationLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _delegationLocalService.dynamicQuery();
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

		return _delegationLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _delegationLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _delegationLocalService.dynamicQuery(
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

		return _delegationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _delegationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public cz.csob.ency.delegations.model.Delegation fetchDelegation(
		long delegationId) {

		return _delegationLocalService.fetchDelegation(delegationId);
	}

	@Override
	public cz.csob.ency.delegations.model.Delegation fetchOrCreate(
		long primaryKey,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _delegationLocalService.fetchOrCreate(
			primaryKey, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _delegationLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the delegation with the primary key.
	 *
	 * @param delegationId the primary key of the delegation
	 * @return the delegation
	 * @throws PortalException if a delegation with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.delegations.model.Delegation getDelegation(
			long delegationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _delegationLocalService.getDelegation(delegationId);
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
	@Override
	public java.util.List<cz.csob.ency.delegations.model.Delegation>
		getDelegations(int start, int end) {

		return _delegationLocalService.getDelegations(start, end);
	}

	@Override
	public java.util.List<cz.csob.ency.delegations.model.Delegation>
		getDelegations(long groupId, long roleId) {

		return _delegationLocalService.getDelegations(groupId, roleId);
	}

	/**
	 * Returns the number of delegations.
	 *
	 * @return the number of delegations
	 */
	@Override
	public int getDelegationsCount() {
		return _delegationLocalService.getDelegationsCount();
	}

	@Override
	public java.util.List<cz.csob.ency.delegations.model.Delegation>
		getDelegationsOfUser(long groupId, long roleId, long delegatingUserId) {

		return _delegationLocalService.getDelegationsOfUser(
			groupId, roleId, delegatingUserId);
	}

	@Override
	public java.util.List<cz.csob.ency.delegations.model.Delegation>
		getDelegationsOfUser(
			long groupId, String roleCode, long delegatingUserId) {

		return _delegationLocalService.getDelegationsOfUser(
			groupId, roleCode, delegatingUserId);
	}

	@Override
	public java.util.List<cz.csob.ency.delegations.model.Delegation>
		getDelegationsToUser(long groupId, long roleId, long delegatedUserId) {

		return _delegationLocalService.getDelegationsToUser(
			groupId, roleId, delegatedUserId);
	}

	@Override
	public java.util.List<cz.csob.ency.delegations.model.Delegation>
		getDelegationsToUser(
			long groupId, String roleCode, long delegatedUserId) {

		return _delegationLocalService.getDelegationsToUser(
			groupId, roleCode, delegatedUserId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _delegationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _delegationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _delegationLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public cz.csob.ency.delegations.model.Delegation updateDelegation(
		cz.csob.ency.delegations.model.Delegation delegation) {

		return _delegationLocalService.updateDelegation(delegation);
	}

	@Override
	public cz.csob.ency.delegations.model.Delegation updateDelegation(
			long delegationId, long roleId, long delegatingUserId,
			long delegatedUserId, String note,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _delegationLocalService.updateDelegation(
			delegationId, roleId, delegatingUserId, delegatedUserId, note,
			serviceContext);
	}

	@Override
	public DelegationLocalService getWrappedService() {
		return _delegationLocalService;
	}

	@Override
	public void setWrappedService(
		DelegationLocalService delegationLocalService) {

		_delegationLocalService = delegationLocalService;
	}

	private DelegationLocalService _delegationLocalService;

}