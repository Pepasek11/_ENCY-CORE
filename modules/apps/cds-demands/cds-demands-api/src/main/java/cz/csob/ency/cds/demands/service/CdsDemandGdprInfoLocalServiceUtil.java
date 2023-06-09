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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import cz.csob.ency.cds.demands.model.CdsDemandGdprInfo;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for CdsDemandGdprInfo. This utility wraps
 * <code>cz.csob.ency.cds.demands.service.impl.CdsDemandGdprInfoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Miroslav Čermák
 * @see CdsDemandGdprInfoLocalService
 * @generated
 */
public class CdsDemandGdprInfoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>cz.csob.ency.cds.demands.service.impl.CdsDemandGdprInfoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static CdsDemandGdprInfo addCdsDemandGdprInfo(
		CdsDemandGdprInfo cdsDemandGdprInfo) {

		return getService().addCdsDemandGdprInfo(cdsDemandGdprInfo);
	}

	/**
	 * Creates a new cds demand gdpr info with the primary key. Does not add the cds demand gdpr info to the database.
	 *
	 * @param gdprInfoId the primary key for the new cds demand gdpr info
	 * @return the new cds demand gdpr info
	 */
	public static CdsDemandGdprInfo createCdsDemandGdprInfo(long gdprInfoId) {
		return getService().createCdsDemandGdprInfo(gdprInfoId);
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
	 * Deletes the cds demand gdpr info from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CdsDemandGdprInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cdsDemandGdprInfo the cds demand gdpr info
	 * @return the cds demand gdpr info that was removed
	 */
	public static CdsDemandGdprInfo deleteCdsDemandGdprInfo(
		CdsDemandGdprInfo cdsDemandGdprInfo) {

		return getService().deleteCdsDemandGdprInfo(cdsDemandGdprInfo);
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
	public static CdsDemandGdprInfo deleteCdsDemandGdprInfo(long gdprInfoId)
		throws PortalException {

		return getService().deleteCdsDemandGdprInfo(gdprInfoId);
	}

	/**
	 * Delete entry
	 *
	 * @param entry CdsDemand
	 * @return CdsDemand oject
	 * @throws PortalException
	 */
	public static CdsDemandGdprInfo deleteEntry(CdsDemandGdprInfo entry)
		throws PortalException {

		return getService().deleteEntry(entry);
	}

	/**
	 * Delete entry
	 */
	public static CdsDemandGdprInfo deleteEntry(long primaryKey)
		throws PortalException {

		return getService().deleteEntry(primaryKey);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.cds.demands.model.impl.CdsDemandGdprInfoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.cds.demands.model.impl.CdsDemandGdprInfoModelImpl</code>.
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

	public static CdsDemandGdprInfo fetchCdsDemandGdprInfo(long gdprInfoId) {
		return getService().fetchCdsDemandGdprInfo(gdprInfoId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<CdsDemandGdprInfo> getAllInDemandId(long demanId) {
		return getService().getAllInDemandId(demanId);
	}

	/**
	 * Returns the cds demand gdpr info with the primary key.
	 *
	 * @param gdprInfoId the primary key of the cds demand gdpr info
	 * @return the cds demand gdpr info
	 * @throws PortalException if a cds demand gdpr info with the primary key could not be found
	 */
	public static CdsDemandGdprInfo getCdsDemandGdprInfo(long gdprInfoId)
		throws PortalException {

		return getService().getCdsDemandGdprInfo(gdprInfoId);
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
	public static List<CdsDemandGdprInfo> getCdsDemandGdprInfos(
		int start, int end) {

		return getService().getCdsDemandGdprInfos(start, end);
	}

	/**
	 * Returns the number of cds demand gdpr infos.
	 *
	 * @return the number of cds demand gdpr infos
	 */
	public static int getCdsDemandGdprInfosCount() {
		return getService().getCdsDemandGdprInfosCount();
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param map KeyVAlue map
	 * @return CdsDemand Object
	 * @throws PortletException
	 * @throws CdsDemandValidateException
	 */
	public static CdsDemandGdprInfo getEntryFromMap(Map<String, Object> map) {
		return getService().getEntryFromMap(map);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return CdsDemand Object
	 * @throws PortletException
	 * @throws CdsDemandValidateException
	 */
	public static CdsDemandGdprInfo getEntryFromRequest(
			long primaryKey, javax.portlet.PortletRequest request)
		throws cz.csob.ency.cds.demands.exception.CdsDemandValidateException,
			   javax.portlet.PortletException {

		return getService().getEntryFromRequest(primaryKey, request);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Populate Model with default values for a form
	 *
	 * @return CdsDemand Object
	 * @throws PortletException
	 */
	public static CdsDemandGdprInfo getInitializedEntry()
		throws javax.portlet.PortletException {

		return getService().getInitializedEntry();
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
	 * Updates the cds demand gdpr info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CdsDemandGdprInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cdsDemandGdprInfo the cds demand gdpr info
	 * @return the cds demand gdpr info that was updated
	 */
	public static CdsDemandGdprInfo updateCdsDemandGdprInfo(
		CdsDemandGdprInfo cdsDemandGdprInfo) {

		return getService().updateCdsDemandGdprInfo(cdsDemandGdprInfo);
	}

	public static CdsDemandGdprInfo updateEntry(
			CdsDemandGdprInfo entry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws cz.csob.ency.cds.demands.exception.CdsDemandValidateException,
			   PortalException {

		return getService().updateEntry(entry, serviceContext);
	}

	public static CdsDemandGdprInfoLocalService getService() {
		return _service;
	}

	private static volatile CdsDemandGdprInfoLocalService _service;

}