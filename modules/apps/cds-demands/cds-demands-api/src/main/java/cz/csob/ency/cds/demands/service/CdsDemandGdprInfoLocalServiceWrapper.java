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

package cz.csob.ency.cds.demands.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CdsDemandGdprInfoLocalService}.
 *
 * @author Miroslav Čermák
 * @see CdsDemandGdprInfoLocalService
 * @generated
 */
public class CdsDemandGdprInfoLocalServiceWrapper
	implements CdsDemandGdprInfoLocalService,
			   ServiceWrapper<CdsDemandGdprInfoLocalService> {

	public CdsDemandGdprInfoLocalServiceWrapper() {
		this(null);
	}

	public CdsDemandGdprInfoLocalServiceWrapper(
		CdsDemandGdprInfoLocalService cdsDemandGdprInfoLocalService) {

		_cdsDemandGdprInfoLocalService = cdsDemandGdprInfoLocalService;
	}

	/**
	 * Adds the cds demand gdpr info to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CdsDemandGdprInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cdsDemandGdprInfo the cds demand gdpr info
	 * @return the cds demand gdpr info that was added
	 */
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemandGdprInfo
		addCdsDemandGdprInfo(
			cz.csob.ency.cds.demands.model.CdsDemandGdprInfo
				cdsDemandGdprInfo) {

		return _cdsDemandGdprInfoLocalService.addCdsDemandGdprInfo(
			cdsDemandGdprInfo);
	}

	/**
	 * Creates a new cds demand gdpr info with the primary key. Does not add the cds demand gdpr info to the database.
	 *
	 * @param gdprInfoId the primary key for the new cds demand gdpr info
	 * @return the new cds demand gdpr info
	 */
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemandGdprInfo
		createCdsDemandGdprInfo(long gdprInfoId) {

		return _cdsDemandGdprInfoLocalService.createCdsDemandGdprInfo(
			gdprInfoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandGdprInfoLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the cds demand gdpr info from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CdsDemandGdprInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cdsDemandGdprInfo the cds demand gdpr info
	 * @return the cds demand gdpr info that was removed
	 */
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemandGdprInfo
		deleteCdsDemandGdprInfo(
			cz.csob.ency.cds.demands.model.CdsDemandGdprInfo
				cdsDemandGdprInfo) {

		return _cdsDemandGdprInfoLocalService.deleteCdsDemandGdprInfo(
			cdsDemandGdprInfo);
	}

	/**
	 * Deletes the cds demand gdpr info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CdsDemandGdprInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gdprInfoId the primary key of the cds demand gdpr info
	 * @return the cds demand gdpr info that was removed
	 * @throws PortalException if a cds demand gdpr info with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemandGdprInfo
			deleteCdsDemandGdprInfo(long gdprInfoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandGdprInfoLocalService.deleteCdsDemandGdprInfo(
			gdprInfoId);
	}

	/**
	 * Delete entry
	 *
	 * @param entry CdsDemand
	 * @return CdsDemand oject
	 * @throws PortalException
	 */
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemandGdprInfo deleteEntry(
			cz.csob.ency.cds.demands.model.CdsDemandGdprInfo entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandGdprInfoLocalService.deleteEntry(entry);
	}

	/**
	 * Delete entry
	 */
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemandGdprInfo deleteEntry(
			long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandGdprInfoLocalService.deleteEntry(primaryKey);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandGdprInfoLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _cdsDemandGdprInfoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _cdsDemandGdprInfoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cdsDemandGdprInfoLocalService.dynamicQuery();
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

		return _cdsDemandGdprInfoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.cds.demands.model.impl.CdsDemandGdprInfoModelImpl</code>.
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

		return _cdsDemandGdprInfoLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.cds.demands.model.impl.CdsDemandGdprInfoModelImpl</code>.
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

		return _cdsDemandGdprInfoLocalService.dynamicQuery(
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

		return _cdsDemandGdprInfoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _cdsDemandGdprInfoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public cz.csob.ency.cds.demands.model.CdsDemandGdprInfo
		fetchCdsDemandGdprInfo(long gdprInfoId) {

		return _cdsDemandGdprInfoLocalService.fetchCdsDemandGdprInfo(
			gdprInfoId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _cdsDemandGdprInfoLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<cz.csob.ency.cds.demands.model.CdsDemandGdprInfo>
		getAllInDemandId(long demanId) {

		return _cdsDemandGdprInfoLocalService.getAllInDemandId(demanId);
	}

	/**
	 * Returns the cds demand gdpr info with the primary key.
	 *
	 * @param gdprInfoId the primary key of the cds demand gdpr info
	 * @return the cds demand gdpr info
	 * @throws PortalException if a cds demand gdpr info with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemandGdprInfo
			getCdsDemandGdprInfo(long gdprInfoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandGdprInfoLocalService.getCdsDemandGdprInfo(gdprInfoId);
	}

	/**
	 * Returns a range of all the cds demand gdpr infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.cds.demands.model.impl.CdsDemandGdprInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cds demand gdpr infos
	 * @param end the upper bound of the range of cds demand gdpr infos (not inclusive)
	 * @return the range of cds demand gdpr infos
	 */
	@Override
	public java.util.List<cz.csob.ency.cds.demands.model.CdsDemandGdprInfo>
		getCdsDemandGdprInfos(int start, int end) {

		return _cdsDemandGdprInfoLocalService.getCdsDemandGdprInfos(start, end);
	}

	/**
	 * Returns the number of cds demand gdpr infos.
	 *
	 * @return the number of cds demand gdpr infos
	 */
	@Override
	public int getCdsDemandGdprInfosCount() {
		return _cdsDemandGdprInfoLocalService.getCdsDemandGdprInfosCount();
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param map KeyVAlue map
	 * @return CdsDemand Object
	 * @throws PortletException
	 * @throws CdsDemandValidateException
	 */
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemandGdprInfo getEntryFromMap(
		java.util.Map<String, Object> map) {

		return _cdsDemandGdprInfoLocalService.getEntryFromMap(map);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return CdsDemand Object
	 * @throws PortletException
	 * @throws CdsDemandValidateException
	 */
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemandGdprInfo getEntryFromRequest(
			long primaryKey, javax.portlet.PortletRequest request)
		throws cz.csob.ency.cds.demands.exception.CdsDemandValidateException,
			   javax.portlet.PortletException {

		return _cdsDemandGdprInfoLocalService.getEntryFromRequest(
			primaryKey, request);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _cdsDemandGdprInfoLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Populate Model with default values for a form
	 *
	 * @return CdsDemand Object
	 * @throws PortletException
	 */
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemandGdprInfo
			getInitializedEntry()
		throws javax.portlet.PortletException {

		return _cdsDemandGdprInfoLocalService.getInitializedEntry();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cdsDemandGdprInfoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandGdprInfoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cds demand gdpr info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CdsDemandGdprInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cdsDemandGdprInfo the cds demand gdpr info
	 * @return the cds demand gdpr info that was updated
	 */
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemandGdprInfo
		updateCdsDemandGdprInfo(
			cz.csob.ency.cds.demands.model.CdsDemandGdprInfo
				cdsDemandGdprInfo) {

		return _cdsDemandGdprInfoLocalService.updateCdsDemandGdprInfo(
			cdsDemandGdprInfo);
	}

	@Override
	public cz.csob.ency.cds.demands.model.CdsDemandGdprInfo updateEntry(
			cz.csob.ency.cds.demands.model.CdsDemandGdprInfo entry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.cds.demands.exception.CdsDemandValidateException {

		return _cdsDemandGdprInfoLocalService.updateEntry(
			entry, serviceContext);
	}

	@Override
	public CdsDemandGdprInfoLocalService getWrappedService() {
		return _cdsDemandGdprInfoLocalService;
	}

	@Override
	public void setWrappedService(
		CdsDemandGdprInfoLocalService cdsDemandGdprInfoLocalService) {

		_cdsDemandGdprInfoLocalService = cdsDemandGdprInfoLocalService;
	}

	private CdsDemandGdprInfoLocalService _cdsDemandGdprInfoLocalService;

}