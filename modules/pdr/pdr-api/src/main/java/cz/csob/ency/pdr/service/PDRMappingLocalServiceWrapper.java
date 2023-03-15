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

package cz.csob.ency.pdr.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PDRMappingLocalService}.
 *
 * @author Miroslav Čermák
 * @see PDRMappingLocalService
 * @generated
 */
public class PDRMappingLocalServiceWrapper
	implements PDRMappingLocalService, ServiceWrapper<PDRMappingLocalService> {

	public PDRMappingLocalServiceWrapper() {
		this(null);
	}

	public PDRMappingLocalServiceWrapper(
		PDRMappingLocalService pdrMappingLocalService) {

		_pdrMappingLocalService = pdrMappingLocalService;
	}

	/**
	 * Adds the pdr mapping to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PDRMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pdrMapping the pdr mapping
	 * @return the pdr mapping that was added
	 */
	@Override
	public cz.csob.ency.pdr.model.PDRMapping addPDRMapping(
		cz.csob.ency.pdr.model.PDRMapping pdrMapping) {

		return _pdrMappingLocalService.addPDRMapping(pdrMapping);
	}

	/**
	 * Creates a new pdr mapping with the primary key. Does not add the pdr mapping to the database.
	 *
	 * @param mappingId the primary key for the new pdr mapping
	 * @return the new pdr mapping
	 */
	@Override
	public cz.csob.ency.pdr.model.PDRMapping createPDRMapping(long mappingId) {
		return _pdrMappingLocalService.createPDRMapping(mappingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pdrMappingLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the pdr mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PDRMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mappingId the primary key of the pdr mapping
	 * @return the pdr mapping that was removed
	 * @throws PortalException if a pdr mapping with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.pdr.model.PDRMapping deletePDRMapping(long mappingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pdrMappingLocalService.deletePDRMapping(mappingId);
	}

	/**
	 * Deletes the pdr mapping from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PDRMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pdrMapping the pdr mapping
	 * @return the pdr mapping that was removed
	 */
	@Override
	public cz.csob.ency.pdr.model.PDRMapping deletePDRMapping(
		cz.csob.ency.pdr.model.PDRMapping pdrMapping) {

		return _pdrMappingLocalService.deletePDRMapping(pdrMapping);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pdrMappingLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _pdrMappingLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _pdrMappingLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _pdrMappingLocalService.dynamicQuery();
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

		return _pdrMappingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.pdr.model.impl.PDRMappingModelImpl</code>.
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

		return _pdrMappingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.pdr.model.impl.PDRMappingModelImpl</code>.
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

		return _pdrMappingLocalService.dynamicQuery(
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

		return _pdrMappingLocalService.dynamicQueryCount(dynamicQuery);
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

		return _pdrMappingLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public cz.csob.ency.pdr.model.PDRMapping fetchPDRMapping(long mappingId) {
		return _pdrMappingLocalService.fetchPDRMapping(mappingId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _pdrMappingLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _pdrMappingLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _pdrMappingLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the pdr mapping with the primary key.
	 *
	 * @param mappingId the primary key of the pdr mapping
	 * @return the pdr mapping
	 * @throws PortalException if a pdr mapping with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.pdr.model.PDRMapping getPDRMapping(long mappingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pdrMappingLocalService.getPDRMapping(mappingId);
	}

	/**
	 * Returns a range of all the pdr mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.pdr.model.impl.PDRMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pdr mappings
	 * @param end the upper bound of the range of pdr mappings (not inclusive)
	 * @return the range of pdr mappings
	 */
	@Override
	public java.util.List<cz.csob.ency.pdr.model.PDRMapping> getPDRMappings(
		int start, int end) {

		return _pdrMappingLocalService.getPDRMappings(start, end);
	}

	/**
	 * Returns the number of pdr mappings.
	 *
	 * @return the number of pdr mappings
	 */
	@Override
	public int getPDRMappingsCount() {
		return _pdrMappingLocalService.getPDRMappingsCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pdrMappingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the pdr mapping in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PDRMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pdrMapping the pdr mapping
	 * @return the pdr mapping that was updated
	 */
	@Override
	public cz.csob.ency.pdr.model.PDRMapping updatePDRMapping(
		cz.csob.ency.pdr.model.PDRMapping pdrMapping) {

		return _pdrMappingLocalService.updatePDRMapping(pdrMapping);
	}

	@Override
	public PDRMappingLocalService getWrappedService() {
		return _pdrMappingLocalService;
	}

	@Override
	public void setWrappedService(
		PDRMappingLocalService pdrMappingLocalService) {

		_pdrMappingLocalService = pdrMappingLocalService;
	}

	private PDRMappingLocalService _pdrMappingLocalService;

}