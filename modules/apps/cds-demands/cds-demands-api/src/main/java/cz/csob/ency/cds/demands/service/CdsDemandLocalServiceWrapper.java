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
 * Provides a wrapper for {@link CdsDemandLocalService}.
 *
 * @author Miroslav Čermák
 * @see CdsDemandLocalService
 * @generated
 */
public class CdsDemandLocalServiceWrapper
	implements CdsDemandLocalService, ServiceWrapper<CdsDemandLocalService> {

	public CdsDemandLocalServiceWrapper() {
		this(null);
	}

	public CdsDemandLocalServiceWrapper(
		CdsDemandLocalService cdsDemandLocalService) {

		_cdsDemandLocalService = cdsDemandLocalService;
	}

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
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand addCdsDemand(
		cz.csob.ency.cds.demands.model.CdsDemand cdsDemand) {

		return _cdsDemandLocalService.addCdsDemand(cdsDemand);
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
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand addEntry(
			cz.csob.ency.cds.demands.model.CdsDemand orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.cds.demands.exception.CdsDemandValidateException {

		return _cdsDemandLocalService.addEntry(orgEntry, serviceContext);
	}

	@Override
	public void addEntryResources(
			cz.csob.ency.cds.demands.model.CdsDemand entry,
			boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_cdsDemandLocalService.addEntryResources(
			entry, addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addEntryResources(
			cz.csob.ency.cds.demands.model.CdsDemand entry,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_cdsDemandLocalService.addEntryResources(entry, modelPermissions);
	}

	@Override
	public void addEntryResources(
			long entryId, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_cdsDemandLocalService.addEntryResources(
			entryId, addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addEntryResources(
			long entryId,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_cdsDemandLocalService.addEntryResources(entryId, modelPermissions);
	}

	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand checkout(
			cz.csob.ency.cds.demands.model.CdsDemand publishedCdsDemand,
			int version)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandLocalService.checkout(publishedCdsDemand, version);
	}

	@Override
	public int countAll() {
		return _cdsDemandLocalService.countAll();
	}

	@Override
	public int countAllInUser(long userId) {
		return _cdsDemandLocalService.countAllInUser(userId);
	}

	/**
	 * Creates a new cds demand. Does not add the cds demand to the database.
	 *
	 * @return the new cds demand
	 */
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand create() {
		return _cdsDemandLocalService.create();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand createWithId(
		long primaryKey) {

		return _cdsDemandLocalService.createWithId(primaryKey);
	}

	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand delete(
			cz.csob.ency.cds.demands.model.CdsDemand publishedCdsDemand)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandLocalService.delete(publishedCdsDemand);
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
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand deleteCdsDemand(
		cz.csob.ency.cds.demands.model.CdsDemand cdsDemand) {

		return _cdsDemandLocalService.deleteCdsDemand(cdsDemand);
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
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand deleteCdsDemand(
			long demandId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandLocalService.deleteCdsDemand(demandId);
	}

	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand deleteDraft(
			cz.csob.ency.cds.demands.model.CdsDemand draftCdsDemand)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandLocalService.deleteDraft(draftCdsDemand);
	}

	/**
	 * Delete entry
	 *
	 * @param entry CdsDemand
	 * @return CdsDemand oject
	 * @throws PortalException
	 */
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand deleteEntry(
			cz.csob.ency.cds.demands.model.CdsDemand entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandLocalService.deleteEntry(entry);
	}

	/**
	 * Delete entry
	 */
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand deleteEntry(long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandLocalService.deleteEntry(primaryKey);
	}

	/**
	 * Delete entry
	 */
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand deleteEntryFull(
			cz.csob.ency.cds.demands.model.CdsDemand entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandLocalService.deleteEntryFull(entry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public cz.csob.ency.cds.demands.model.CdsDemandVersion deleteVersion(
			cz.csob.ency.cds.demands.model.CdsDemandVersion cdsDemandVersion)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandLocalService.deleteVersion(cdsDemandVersion);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _cdsDemandLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _cdsDemandLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cdsDemandLocalService.dynamicQuery();
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

		return _cdsDemandLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _cdsDemandLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _cdsDemandLocalService.dynamicQuery(
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

		return _cdsDemandLocalService.dynamicQueryCount(dynamicQuery);
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

		return _cdsDemandLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.portal.kernel.repository.model.Folder
		fetchAttachmentsFolder(long userId, long groupId, long entryId) {

		return _cdsDemandLocalService.fetchAttachmentsFolder(
			userId, groupId, entryId);
	}

	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand fetchCdsDemand(
		long demandId) {

		return _cdsDemandLocalService.fetchCdsDemand(demandId);
	}

	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand fetchCdsDemand(
		String uuid) {

		return _cdsDemandLocalService.fetchCdsDemand(uuid);
	}

	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand fetchDraft(
		cz.csob.ency.cds.demands.model.CdsDemand cdsDemand) {

		return _cdsDemandLocalService.fetchDraft(cdsDemand);
	}

	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand fetchDraft(
		long primaryKey) {

		return _cdsDemandLocalService.fetchDraft(primaryKey);
	}

	@Override
	public cz.csob.ency.cds.demands.model.CdsDemandVersion fetchLatestVersion(
		cz.csob.ency.cds.demands.model.CdsDemand cdsDemand) {

		return _cdsDemandLocalService.fetchLatestVersion(cdsDemand);
	}

	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand fetchPublished(
		cz.csob.ency.cds.demands.model.CdsDemand cdsDemand) {

		return _cdsDemandLocalService.fetchPublished(cdsDemand);
	}

	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand fetchPublished(
		long primaryKey) {

		return _cdsDemandLocalService.fetchPublished(primaryKey);
	}

	@Override
	public java.util.List<cz.csob.ency.cds.demands.model.CdsDemand> findAll() {
		return _cdsDemandLocalService.findAll();
	}

	@Override
	public java.util.List<cz.csob.ency.cds.demands.model.CdsDemand> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<cz.csob.ency.cds.demands.model.CdsDemand> orderByComparator) {

		return _cdsDemandLocalService.findAll(start, end, orderByComparator);
	}

	@Override
	public java.util.List<cz.csob.ency.cds.demands.model.CdsDemand> findAll(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator
			<cz.csob.ency.cds.demands.model.CdsDemand> orderByComparator) {

		return _cdsDemandLocalService.findAll(groupId, orderByComparator);
	}

	@Override
	public java.util.List<cz.csob.ency.cds.demands.model.CdsDemand>
		findAllInUser(long userId) {

		return _cdsDemandLocalService.findAllInUser(userId);
	}

	@Override
	public java.util.List<cz.csob.ency.cds.demands.model.CdsDemand>
		findAllInUser(
			long userId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.cds.demands.model.CdsDemand> orderByComparator) {

		return _cdsDemandLocalService.findAllInUser(
			userId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<cz.csob.ency.cds.demands.model.CdsDemand>
		findAllInUser(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.cds.demands.model.CdsDemand> orderByComparator) {

		return _cdsDemandLocalService.findAllInUser(userId, orderByComparator);
	}

	@Override
	public java.util.List<cz.csob.ency.cds.demands.model.CdsDemand>
		findDomainDemands(
			long userId, Long[] domainId, boolean getLongClosed,
			boolean includeOthersDrafts) {

		return _cdsDemandLocalService.findDomainDemands(
			userId, domainId, getLongClosed, includeOthersDrafts);
	}

	@Override
	public java.util.List<cz.csob.ency.cds.demands.model.CdsDemand>
		findUserActionRequiredDemands(long userId, long groupId) {

		return _cdsDemandLocalService.findUserActionRequiredDemands(
			userId, groupId);
	}

	@Override
	public java.util.List<cz.csob.ency.cds.demands.model.CdsDemand>
		findUserDemands(long userId, boolean getLongClosed) {

		return _cdsDemandLocalService.findUserDemands(userId, getLongClosed);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _cdsDemandLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.repository.model.Folder
			getAttachmentsFolder(long userId, long groupId, long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandLocalService.getAttachmentsFolder(
			userId, groupId, entryId);
	}

	@Override
	public long getAttachmentsFolderId(
		long userId, long groupId, long entryId) {

		return _cdsDemandLocalService.getAttachmentsFolderId(
			userId, groupId, entryId);
	}

	@Override
	public String getAttachmentsFolderName(long entryId) {
		return _cdsDemandLocalService.getAttachmentsFolderName(entryId);
	}

	/**
	 * Returns the cds demand with the primary key.
	 *
	 * @param demandId the primary key of the cds demand
	 * @return the cds demand
	 * @throws PortalException if a cds demand with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand getCdsDemand(long demandId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandLocalService.getCdsDemand(demandId);
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
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand getCdsDemandFromRequest(
			long primaryKey, javax.portlet.PortletRequest request)
		throws cz.csob.ency.cds.demands.exception.CdsDemandValidateException,
			   javax.portlet.PortletException {

		return _cdsDemandLocalService.getCdsDemandFromRequest(
			primaryKey, request);
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
	@Override
	public java.util.List<cz.csob.ency.cds.demands.model.CdsDemand>
		getCdsDemands(int start, int end) {

		return _cdsDemandLocalService.getCdsDemands(start, end);
	}

	/**
	 * Returns the number of cds demands.
	 *
	 * @return the number of cds demands
	 */
	@Override
	public int getCdsDemandsCount() {
		return _cdsDemandLocalService.getCdsDemandsCount();
	}

	/**
	 * Converte Date Time into Date()
	 *
	 * @param request PortletRequest
	 * @param prefix  Prefix of the parameter
	 * @return Date object
	 */
	@Override
	public java.util.Date getDateTimeFromRequest(
		javax.portlet.PortletRequest request, String prefix) {

		return _cdsDemandLocalService.getDateTimeFromRequest(request, prefix);
	}

	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand getDraft(
			cz.csob.ency.cds.demands.model.CdsDemand cdsDemand)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandLocalService.getDraft(cdsDemand);
	}

	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand getDraft(long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandLocalService.getDraft(primaryKey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _cdsDemandLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public String getFormattedUserName(
		com.liferay.portal.kernel.model.User user) {

		return _cdsDemandLocalService.getFormattedUserName(user);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _cdsDemandLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand getInitializedCdsDemand(
		long id, com.liferay.portal.kernel.service.ServiceContext sc) {

		return _cdsDemandLocalService.getInitializedCdsDemand(id, sc);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return CdsDemand Object
	 * @throws PortletException
	 */
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand getInitializedCdsDemand(
			javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandLocalService.getInitializedCdsDemand(request);
	}

	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand getInitializedCdsDemand(
		com.liferay.portal.kernel.service.ServiceContext sc) {

		return _cdsDemandLocalService.getInitializedCdsDemand(sc);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cdsDemandLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.Repository getRepository(
			long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandLocalService.getRepository(groupId);
	}

	@Override
	public long getRepositoryId(long groupId) {
		return _cdsDemandLocalService.getRepositoryId(groupId);
	}

	/**
	 * Get STATUS_ANY for DB
	 * <p>
	 * This is equivalent of WorkflowConstants.STATUS_ANY
	 *
	 * @return All statuses for Workflow
	 */
	@Override
	public int[] getStatusAny() {
		return _cdsDemandLocalService.getStatusAny();
	}

	@Override
	public long getUserDomainId(com.liferay.portal.kernel.model.User user) {
		return _cdsDemandLocalService.getUserDomainId(user);
	}

	@Override
	public cz.csob.ency.cds.demands.model.CdsDemandVersion getVersion(
			cz.csob.ency.cds.demands.model.CdsDemand cdsDemand, int version)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandLocalService.getVersion(cdsDemand, version);
	}

	@Override
	public java.util.List<cz.csob.ency.cds.demands.model.CdsDemandVersion>
		getVersions(cz.csob.ency.cds.demands.model.CdsDemand cdsDemand) {

		return _cdsDemandLocalService.getVersions(cdsDemand);
	}

	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand importEntry(
			cz.csob.ency.cds.demands.model.CdsDemand entry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.cds.demands.exception.CdsDemandValidateException {

		return _cdsDemandLocalService.importEntry(entry, serviceContext);
	}

	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand publishDraft(
			cz.csob.ency.cds.demands.model.CdsDemand draftCdsDemand)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandLocalService.publishDraft(draftCdsDemand);
	}

	@Override
	public void registerListener(
		com.liferay.portal.kernel.service.version.VersionServiceListener
			<cz.csob.ency.cds.demands.model.CdsDemand,
			 cz.csob.ency.cds.demands.model.CdsDemandVersion>
				versionServiceListener) {

		_cdsDemandLocalService.registerListener(versionServiceListener);
	}

	@Override
	public void unregisterListener(
		com.liferay.portal.kernel.service.version.VersionServiceListener
			<cz.csob.ency.cds.demands.model.CdsDemand,
			 cz.csob.ency.cds.demands.model.CdsDemandVersion>
				versionServiceListener) {

		_cdsDemandLocalService.unregisterListener(versionServiceListener);
	}

	@Override
	public void updateAsset(
			long userId, cz.csob.ency.cds.demands.model.CdsDemand entry,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds, Double priority)
		throws com.liferay.portal.kernel.exception.PortalException {

		_cdsDemandLocalService.updateAsset(
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
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand updateCdsDemand(
			cz.csob.ency.cds.demands.model.CdsDemand draftCdsDemand)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandLocalService.updateCdsDemand(draftCdsDemand);
	}

	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand updateDraft(
			cz.csob.ency.cds.demands.model.CdsDemand draftCdsDemand)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandLocalService.updateDraft(draftCdsDemand);
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
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand updateEntry(
			cz.csob.ency.cds.demands.model.CdsDemand orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.cds.demands.exception.CdsDemandValidateException {

		return _cdsDemandLocalService.updateEntry(orgEntry, serviceContext);
	}

	@Override
	public void updateEntryResources(
			cz.csob.ency.cds.demands.model.CdsDemand entry,
			String[] groupPermissions, String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_cdsDemandLocalService.updateEntryResources(
			entry, groupPermissions, guestPermissions);
	}

	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand updateEntryVersion(
			cz.csob.ency.cds.demands.model.CdsDemand cdsDemand)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandLocalService.updateEntryVersion(cdsDemand);
	}

	@Override
	public CdsDemandLocalService getWrappedService() {
		return _cdsDemandLocalService;
	}

	@Override
	public void setWrappedService(CdsDemandLocalService cdsDemandLocalService) {
		_cdsDemandLocalService = cdsDemandLocalService;
	}

	private CdsDemandLocalService _cdsDemandLocalService;

}