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

import cz.csob.ency.cds.demands.model.CdsDemand;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for CdsDemand. This utility wraps
 * <code>cz.csob.ency.cds.demands.service.impl.CdsDemandLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Miroslav Čermák
 * @see CdsDemandLocalService
 * @generated
 */
public class CdsDemandLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>cz.csob.ency.cds.demands.service.impl.CdsDemandLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the cds demand to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CdsDemandLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cdsDemand the cds demand
	 * @return the cds demand that was added
	 */
	public static CdsDemand addCdsDemand(CdsDemand cdsDemand) {
		return getService().addCdsDemand(cdsDemand);
	}

	/**
	 * Add Entry
	 *
	 * @param orgEntry       CdsDemand model
	 * @param serviceContext ServiceContext
	 * @return created CdsDemand model.
	 * @throws PortalException
	 * @throws CdsDemandValidateException
	 */
	public static CdsDemand addEntry(
			CdsDemand orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws cz.csob.ency.cds.demands.exception.CdsDemandValidateException,
			   PortalException {

		return getService().addEntry(orgEntry, serviceContext);
	}

	public static void addEntryResources(
			CdsDemand entry, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException {

		getService().addEntryResources(
			entry, addGroupPermissions, addGuestPermissions);
	}

	public static void addEntryResources(
			CdsDemand entry,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws PortalException {

		getService().addEntryResources(entry, modelPermissions);
	}

	public static void addEntryResources(
			long entryId, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException {

		getService().addEntryResources(
			entryId, addGroupPermissions, addGuestPermissions);
	}

	public static void addEntryResources(
			long entryId,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws PortalException {

		getService().addEntryResources(entryId, modelPermissions);
	}

	public static CdsDemand checkout(CdsDemand publishedCdsDemand, int version)
		throws PortalException {

		return getService().checkout(publishedCdsDemand, version);
	}

	public static int countAll() {
		return getService().countAll();
	}

	public static int countAllInUser(long userId) {
		return getService().countAllInUser(userId);
	}

	/**
	 * Creates a new cds demand. Does not add the cds demand to the database.
	 *
	 * @return the new cds demand
	 */
	public static CdsDemand create() {
		return getService().create();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static CdsDemand createWithId(long primaryKey) {
		return getService().createWithId(primaryKey);
	}

	public static CdsDemand delete(CdsDemand publishedCdsDemand)
		throws PortalException {

		return getService().delete(publishedCdsDemand);
	}

	/**
	 * Deletes the cds demand from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CdsDemandLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cdsDemand the cds demand
	 * @return the cds demand that was removed
	 */
	public static CdsDemand deleteCdsDemand(CdsDemand cdsDemand) {
		return getService().deleteCdsDemand(cdsDemand);
	}

	/**
	 * Deletes the cds demand with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CdsDemandLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param demandId the primary key of the cds demand
	 * @return the cds demand that was removed
	 * @throws PortalException if a cds demand with the primary key could not be found
	 */
	public static CdsDemand deleteCdsDemand(long demandId)
		throws PortalException {

		return getService().deleteCdsDemand(demandId);
	}

	public static CdsDemand deleteDraft(CdsDemand draftCdsDemand)
		throws PortalException {

		return getService().deleteDraft(draftCdsDemand);
	}

	/**
	 * Delete entry
	 *
	 * @param entry CdsDemand
	 * @return CdsDemand oject
	 * @throws PortalException
	 */
	public static CdsDemand deleteEntry(CdsDemand entry)
		throws PortalException {

		return getService().deleteEntry(entry);
	}

	/**
	 * Delete entry
	 */
	public static CdsDemand deleteEntry(long primaryKey)
		throws PortalException {

		return getService().deleteEntry(primaryKey);
	}

	/**
	 * Delete entry
	 */
	public static CdsDemand deleteEntryFull(CdsDemand entry)
		throws PortalException {

		return getService().deleteEntryFull(entry);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static cz.csob.ency.cds.demands.model.CdsDemandVersion deleteVersion(
			cz.csob.ency.cds.demands.model.CdsDemandVersion cdsDemandVersion)
		throws PortalException {

		return getService().deleteVersion(cdsDemandVersion);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.cds.demands.model.impl.CdsDemandModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.cds.demands.model.impl.CdsDemandModelImpl</code>.
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

	public static com.liferay.portal.kernel.repository.model.Folder
		fetchAttachmentsFolder(long userId, long groupId, long entryId) {

		return getService().fetchAttachmentsFolder(userId, groupId, entryId);
	}

	public static CdsDemand fetchCdsDemand(long demandId) {
		return getService().fetchCdsDemand(demandId);
	}

	public static CdsDemand fetchCdsDemand(String uuid) {
		return getService().fetchCdsDemand(uuid);
	}

	public static CdsDemand fetchDraft(CdsDemand cdsDemand) {
		return getService().fetchDraft(cdsDemand);
	}

	public static CdsDemand fetchDraft(long primaryKey) {
		return getService().fetchDraft(primaryKey);
	}

	public static cz.csob.ency.cds.demands.model.CdsDemandVersion
		fetchLatestVersion(CdsDemand cdsDemand) {

		return getService().fetchLatestVersion(cdsDemand);
	}

	public static CdsDemand fetchPublished(CdsDemand cdsDemand) {
		return getService().fetchPublished(cdsDemand);
	}

	public static CdsDemand fetchPublished(long primaryKey) {
		return getService().fetchPublished(primaryKey);
	}

	public static List<CdsDemand> findAll() {
		return getService().findAll();
	}

	public static List<CdsDemand> findAll(
		int start, int end, OrderByComparator<CdsDemand> orderByComparator) {

		return getService().findAll(start, end, orderByComparator);
	}

	public static List<CdsDemand> findAll(
		long groupId, OrderByComparator<CdsDemand> orderByComparator) {

		return getService().findAll(groupId, orderByComparator);
	}

	public static List<CdsDemand> findAllInUser(long userId) {
		return getService().findAllInUser(userId);
	}

	public static List<CdsDemand> findAllInUser(
		long userId, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return getService().findAllInUser(
			userId, start, end, orderByComparator);
	}

	public static List<CdsDemand> findAllInUser(
		long userId, OrderByComparator<CdsDemand> orderByComparator) {

		return getService().findAllInUser(userId, orderByComparator);
	}

	public static List<CdsDemand> findDomainDemands(
		long userId, Long[] domainId, boolean getLongClosed,
		boolean includeOthersDrafts) {

		return getService().findDomainDemands(
			userId, domainId, getLongClosed, includeOthersDrafts);
	}

	public static List<CdsDemand> findUserActionRequiredDemands(
		long userId, long groupId) {

		return getService().findUserActionRequiredDemands(userId, groupId);
	}

	public static List<CdsDemand> findUserDemands(
		long userId, boolean getLongClosed) {

		return getService().findUserDemands(userId, getLongClosed);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.repository.model.Folder
			getAttachmentsFolder(long userId, long groupId, long entryId)
		throws PortalException {

		return getService().getAttachmentsFolder(userId, groupId, entryId);
	}

	public static long getAttachmentsFolderId(
		long userId, long groupId, long entryId) {

		return getService().getAttachmentsFolderId(userId, groupId, entryId);
	}

	public static String getAttachmentsFolderName(long entryId) {
		return getService().getAttachmentsFolderName(entryId);
	}

	/**
	 * Returns the cds demand with the primary key.
	 *
	 * @param demandId the primary key of the cds demand
	 * @return the cds demand
	 * @throws PortalException if a cds demand with the primary key could not be found
	 */
	public static CdsDemand getCdsDemand(long demandId) throws PortalException {
		return getService().getCdsDemand(demandId);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return CdsDemand Object
	 * @throws PortletException
	 * @throws CdsDemandValidateException
	 * @todo bez primaryKey p[arametru?->Nacitat ho z requestu?
	 */
	public static CdsDemand getCdsDemandFromRequest(
			long primaryKey, javax.portlet.PortletRequest request)
		throws cz.csob.ency.cds.demands.exception.CdsDemandValidateException,
			   javax.portlet.PortletException {

		return getService().getCdsDemandFromRequest(primaryKey, request);
	}

	/**
	 * Returns a range of all the cds demands.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.cds.demands.model.impl.CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of cds demands
	 */
	public static List<CdsDemand> getCdsDemands(int start, int end) {
		return getService().getCdsDemands(start, end);
	}

	/**
	 * Returns the number of cds demands.
	 *
	 * @return the number of cds demands
	 */
	public static int getCdsDemandsCount() {
		return getService().getCdsDemandsCount();
	}

	/**
	 * Converte Date Time into Date()
	 *
	 * @param request PortletRequest
	 * @param prefix  Prefix of the parameter
	 * @return Date object
	 */
	public static java.util.Date getDateTimeFromRequest(
		javax.portlet.PortletRequest request, String prefix) {

		return getService().getDateTimeFromRequest(request, prefix);
	}

	public static CdsDemand getDraft(CdsDemand cdsDemand)
		throws PortalException {

		return getService().getDraft(cdsDemand);
	}

	public static CdsDemand getDraft(long primaryKey) throws PortalException {
		return getService().getDraft(primaryKey);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static String getFormattedUserName(
		com.liferay.portal.kernel.model.User user) {

		return getService().getFormattedUserName(user);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static CdsDemand getInitializedCdsDemand(
		long id, com.liferay.portal.kernel.service.ServiceContext sc) {

		return getService().getInitializedCdsDemand(id, sc);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return CdsDemand Object
	 * @throws PortletException
	 */
	public static CdsDemand getInitializedCdsDemand(
			javax.portlet.PortletRequest request)
		throws PortalException {

		return getService().getInitializedCdsDemand(request);
	}

	public static CdsDemand getInitializedCdsDemand(
		com.liferay.portal.kernel.service.ServiceContext sc) {

		return getService().getInitializedCdsDemand(sc);
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

	public static com.liferay.portal.kernel.model.Repository getRepository(
			long groupId)
		throws PortalException {

		return getService().getRepository(groupId);
	}

	public static long getRepositoryId(long groupId) {
		return getService().getRepositoryId(groupId);
	}

	/**
	 * Get STATUS_ANY for DB
	 * <p>
	 * This is equivalent of WorkflowConstants.STATUS_ANY
	 *
	 * @return All statuses for Workflow
	 */
	public static int[] getStatusAny() {
		return getService().getStatusAny();
	}

	public static long getUserDomainId(
		com.liferay.portal.kernel.model.User user) {

		return getService().getUserDomainId(user);
	}

	public static cz.csob.ency.cds.demands.model.CdsDemandVersion getVersion(
			CdsDemand cdsDemand, int version)
		throws PortalException {

		return getService().getVersion(cdsDemand, version);
	}

	public static List<cz.csob.ency.cds.demands.model.CdsDemandVersion>
		getVersions(CdsDemand cdsDemand) {

		return getService().getVersions(cdsDemand);
	}

	public static CdsDemand importEntry(
			CdsDemand entry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws cz.csob.ency.cds.demands.exception.CdsDemandValidateException,
			   PortalException {

		return getService().importEntry(entry, serviceContext);
	}

	public static CdsDemand publishDraft(CdsDemand draftCdsDemand)
		throws PortalException {

		return getService().publishDraft(draftCdsDemand);
	}

	public static void registerListener(
		com.liferay.portal.kernel.service.version.VersionServiceListener
			<CdsDemand, cz.csob.ency.cds.demands.model.CdsDemandVersion>
				versionServiceListener) {

		getService().registerListener(versionServiceListener);
	}

	public static void unregisterListener(
		com.liferay.portal.kernel.service.version.VersionServiceListener
			<CdsDemand, cz.csob.ency.cds.demands.model.CdsDemandVersion>
				versionServiceListener) {

		getService().unregisterListener(versionServiceListener);
	}

	public static void updateAsset(
			long userId, CdsDemand entry, long[] assetCategoryIds,
			String[] assetTagNames, long[] assetLinkEntryIds, Double priority)
		throws PortalException {

		getService().updateAsset(
			userId, entry, assetCategoryIds, assetTagNames, assetLinkEntryIds,
			priority);
	}

	/**
	 * Updates the cds demand in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CdsDemandLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cdsDemand the cds demand
	 * @return the cds demand that was updated
	 */
	public static CdsDemand updateCdsDemand(CdsDemand draftCdsDemand)
		throws PortalException {

		return getService().updateCdsDemand(draftCdsDemand);
	}

	public static CdsDemand updateDraft(CdsDemand draftCdsDemand)
		throws PortalException {

		return getService().updateDraft(draftCdsDemand);
	}

	/**
	 * Edit Entry
	 *
	 * @param orgEntry       CdsDemand model
	 * @param serviceContext ServiceContext
	 * @return updated CdsDemand model.
	 * @throws PortalException
	 * @throws CdsDemandValidateException
	 */
	public static CdsDemand updateEntry(
			CdsDemand orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws cz.csob.ency.cds.demands.exception.CdsDemandValidateException,
			   PortalException {

		return getService().updateEntry(orgEntry, serviceContext);
	}

	public static void updateEntryResources(
			CdsDemand entry, String[] groupPermissions,
			String[] guestPermissions)
		throws PortalException {

		getService().updateEntryResources(
			entry, groupPermissions, guestPermissions);
	}

	public static CdsDemand updateEntryVersion(CdsDemand cdsDemand)
		throws PortalException {

		return getService().updateEntryVersion(cdsDemand);
	}

	public static CdsDemandLocalService getService() {
		return _service;
	}

	private static volatile CdsDemandLocalService _service;

}