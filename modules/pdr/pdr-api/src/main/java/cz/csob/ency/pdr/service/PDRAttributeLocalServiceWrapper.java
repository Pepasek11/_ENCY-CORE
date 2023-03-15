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
 * Provides a wrapper for {@link PDRAttributeLocalService}.
 *
 * @author Miroslav Čermák
 * @see PDRAttributeLocalService
 * @generated
 */
public class PDRAttributeLocalServiceWrapper
	implements PDRAttributeLocalService,
			   ServiceWrapper<PDRAttributeLocalService> {

	public PDRAttributeLocalServiceWrapper() {
		this(null);
	}

	public PDRAttributeLocalServiceWrapper(
		PDRAttributeLocalService pdrAttributeLocalService) {

		_pdrAttributeLocalService = pdrAttributeLocalService;
	}

	/**
	 * Adds the pdr attribute to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PDRAttributeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pdrAttribute the pdr attribute
	 * @return the pdr attribute that was added
	 */
	@Override
	public cz.csob.ency.pdr.model.PDRAttribute addPDRAttribute(
		cz.csob.ency.pdr.model.PDRAttribute pdrAttribute) {

		return _pdrAttributeLocalService.addPDRAttribute(pdrAttribute);
	}

	/**
	 * Creates a new pdr attribute with the primary key. Does not add the pdr attribute to the database.
	 *
	 * @param attributeId the primary key for the new pdr attribute
	 * @return the new pdr attribute
	 */
	@Override
	public cz.csob.ency.pdr.model.PDRAttribute createPDRAttribute(
		long attributeId) {

		return _pdrAttributeLocalService.createPDRAttribute(attributeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pdrAttributeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the pdr attribute with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PDRAttributeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param attributeId the primary key of the pdr attribute
	 * @return the pdr attribute that was removed
	 * @throws PortalException if a pdr attribute with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.pdr.model.PDRAttribute deletePDRAttribute(
			long attributeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pdrAttributeLocalService.deletePDRAttribute(attributeId);
	}

	/**
	 * Deletes the pdr attribute from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PDRAttributeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pdrAttribute the pdr attribute
	 * @return the pdr attribute that was removed
	 */
	@Override
	public cz.csob.ency.pdr.model.PDRAttribute deletePDRAttribute(
		cz.csob.ency.pdr.model.PDRAttribute pdrAttribute) {

		return _pdrAttributeLocalService.deletePDRAttribute(pdrAttribute);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pdrAttributeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _pdrAttributeLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _pdrAttributeLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _pdrAttributeLocalService.dynamicQuery();
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

		return _pdrAttributeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.pdr.model.impl.PDRAttributeModelImpl</code>.
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

		return _pdrAttributeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.pdr.model.impl.PDRAttributeModelImpl</code>.
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

		return _pdrAttributeLocalService.dynamicQuery(
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

		return _pdrAttributeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _pdrAttributeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public cz.csob.ency.pdr.model.PDRAttribute fetchPDRAttribute(
		long attributeId) {

		return _pdrAttributeLocalService.fetchPDRAttribute(attributeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _pdrAttributeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _pdrAttributeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _pdrAttributeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the pdr attribute with the primary key.
	 *
	 * @param attributeId the primary key of the pdr attribute
	 * @return the pdr attribute
	 * @throws PortalException if a pdr attribute with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.pdr.model.PDRAttribute getPDRAttribute(long attributeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pdrAttributeLocalService.getPDRAttribute(attributeId);
	}

	/**
	 * Returns a range of all the pdr attributes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.pdr.model.impl.PDRAttributeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pdr attributes
	 * @param end the upper bound of the range of pdr attributes (not inclusive)
	 * @return the range of pdr attributes
	 */
	@Override
	public java.util.List<cz.csob.ency.pdr.model.PDRAttribute> getPDRAttributes(
		int start, int end) {

		return _pdrAttributeLocalService.getPDRAttributes(start, end);
	}

	/**
	 * Returns the number of pdr attributes.
	 *
	 * @return the number of pdr attributes
	 */
	@Override
	public int getPDRAttributesCount() {
		return _pdrAttributeLocalService.getPDRAttributesCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pdrAttributeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the pdr attribute in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PDRAttributeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pdrAttribute the pdr attribute
	 * @return the pdr attribute that was updated
	 */
	@Override
	public cz.csob.ency.pdr.model.PDRAttribute updatePDRAttribute(
		cz.csob.ency.pdr.model.PDRAttribute pdrAttribute) {

		return _pdrAttributeLocalService.updatePDRAttribute(pdrAttribute);
	}

	@Override
	public PDRAttributeLocalService getWrappedService() {
		return _pdrAttributeLocalService;
	}

	@Override
	public void setWrappedService(
		PDRAttributeLocalService pdrAttributeLocalService) {

		_pdrAttributeLocalService = pdrAttributeLocalService;
	}

	private PDRAttributeLocalService _pdrAttributeLocalService;

}