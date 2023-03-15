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

package cz.csob.ency.modules.e3.entry.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link E3EntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see E3EntryLocalService
 * @generated
 */
public class E3EntryLocalServiceWrapper
	implements E3EntryLocalService, ServiceWrapper<E3EntryLocalService> {

	public E3EntryLocalServiceWrapper(E3EntryLocalService e3EntryLocalService) {
		_e3EntryLocalService = e3EntryLocalService;
	}

	/**
	 * Adds the e3 entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect E3EntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param e3Entry the e3 entry
	 * @return the e3 entry that was added
	 */
	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry addE3Entry(
		cz.csob.ency.modules.e3.entry.model.E3Entry e3Entry) {

		return _e3EntryLocalService.addE3Entry(e3Entry);
	}

	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry addEntry(
			cz.csob.ency.modules.e3.entry.model.E3Entry entry, boolean publish,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _e3EntryLocalService.addEntry(entry, publish, serviceContext);
	}

	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry addEntry(
			long userId, cz.csob.ency.modules.e3.entry.model.E3Entry entry,
			boolean publish,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _e3EntryLocalService.addEntry(
			userId, entry, publish, serviceContext);
	}

	@Override
	public void addEntryResources(
			cz.csob.ency.modules.e3.entry.model.E3Entry entry,
			boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_e3EntryLocalService.addEntryResources(
			entry, addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addEntryResources(
			cz.csob.ency.modules.e3.entry.model.E3Entry entry,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_e3EntryLocalService.addEntryResources(entry, modelPermissions);
	}

	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry checkout(
			cz.csob.ency.modules.e3.entry.model.E3Entry publishedE3Entry,
			int version)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _e3EntryLocalService.checkout(publishedE3Entry, version);
	}

	/**
	 * Creates a new e3 entry. Does not add the e3 entry to the database.
	 *
	 * @return the new e3 entry
	 */
	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry create() {
		return _e3EntryLocalService.create();
	}

	/**
	 * Creates a new draft e3 entry for given app class. Does not add the e3 entry to the database.
	 *
	 * @return the new draft e3 entry
	 */
	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry createEntry(
		String appClass) {

		return _e3EntryLocalService.createEntry(appClass);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _e3EntryLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry delete(
			cz.csob.ency.modules.e3.entry.model.E3Entry publishedE3Entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _e3EntryLocalService.delete(publishedE3Entry);
	}

	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry deleteDraft(
			cz.csob.ency.modules.e3.entry.model.E3Entry draftE3Entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _e3EntryLocalService.deleteDraft(draftE3Entry);
	}

	/**
	 * Deletes the e3 entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect E3EntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param e3Entry the e3 entry
	 * @return the e3 entry that was removed
	 */
	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry deleteE3Entry(
		cz.csob.ency.modules.e3.entry.model.E3Entry e3Entry) {

		return _e3EntryLocalService.deleteE3Entry(e3Entry);
	}

	/**
	 * Deletes the e3 entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect E3EntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param entryId the primary key of the e3 entry
	 * @return the e3 entry that was removed
	 * @throws PortalException if a e3 entry with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry deleteE3Entry(
			long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _e3EntryLocalService.deleteE3Entry(entryId);
	}

	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry deleteEntry(
			cz.csob.ency.modules.e3.entry.model.E3Entry entry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _e3EntryLocalService.deleteEntry(entry, serviceContext);
	}

	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry deleteEntry(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _e3EntryLocalService.deleteEntry(entryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _e3EntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public cz.csob.ency.modules.e3.entry.model.E3EntryVersion deleteVersion(
			cz.csob.ency.modules.e3.entry.model.E3EntryVersion e3EntryVersion)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _e3EntryLocalService.deleteVersion(e3EntryVersion);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _e3EntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _e3EntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _e3EntryLocalService.dynamicQuery();
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

		return _e3EntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.modules.e3.entry.model.impl.E3EntryModelImpl</code>.
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

		return _e3EntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.modules.e3.entry.model.impl.E3EntryModelImpl</code>.
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

		return _e3EntryLocalService.dynamicQuery(
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

		return _e3EntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _e3EntryLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry fetchDraft(
		cz.csob.ency.modules.e3.entry.model.E3Entry e3Entry) {

		return _e3EntryLocalService.fetchDraft(e3Entry);
	}

	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry fetchDraft(
		long primaryKey) {

		return _e3EntryLocalService.fetchDraft(primaryKey);
	}

	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry fetchE3Entry(
		long entryId) {

		return _e3EntryLocalService.fetchE3Entry(entryId);
	}

	@Override
	public cz.csob.ency.modules.e3.entry.model.E3EntryVersion
		fetchLatestVersion(
			cz.csob.ency.modules.e3.entry.model.E3Entry e3Entry) {

		return _e3EntryLocalService.fetchLatestVersion(e3Entry);
	}

	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry fetchPublished(
		cz.csob.ency.modules.e3.entry.model.E3Entry e3Entry) {

		return _e3EntryLocalService.fetchPublished(e3Entry);
	}

	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry fetchPublished(
		long primaryKey) {

		return _e3EntryLocalService.fetchPublished(primaryKey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _e3EntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry getDraft(
			cz.csob.ency.modules.e3.entry.model.E3Entry e3Entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _e3EntryLocalService.getDraft(e3Entry);
	}

	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry getDraft(long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _e3EntryLocalService.getDraft(primaryKey);
	}

	/**
	 * Returns a range of all the e3 entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.modules.e3.entry.model.impl.E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of e3 entries
	 */
	@Override
	public java.util.List<cz.csob.ency.modules.e3.entry.model.E3Entry>
		getE3Entries(int start, int end) {

		return _e3EntryLocalService.getE3Entries(start, end);
	}

	/**
	 * Returns the number of e3 entries.
	 *
	 * @return the number of e3 entries
	 */
	@Override
	public int getE3EntriesCount() {
		return _e3EntryLocalService.getE3EntriesCount();
	}

	/**
	 * Returns the e3 entry with the primary key.
	 *
	 * @param entryId the primary key of the e3 entry
	 * @return the e3 entry
	 * @throws PortalException if a e3 entry with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry getE3Entry(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _e3EntryLocalService.getE3Entry(entryId);
	}

	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry getEntry(long entryId)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return _e3EntryLocalService.getEntry(entryId);
	}

	@Override
	public String getEntryPortletName(
			cz.csob.ency.modules.e3.entry.model.E3Entry entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _e3EntryLocalService.getEntryPortletName(entry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _e3EntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _e3EntryLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public long getMaxEntryVersion(long id) {
		return _e3EntryLocalService.getMaxEntryVersion(id);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _e3EntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _e3EntryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public cz.csob.ency.modules.e3.entry.model.E3EntryVersion getVersion(
			cz.csob.ency.modules.e3.entry.model.E3Entry e3Entry, int version)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _e3EntryLocalService.getVersion(e3Entry, version);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.e3.entry.model.E3EntryVersion>
		getVersions(cz.csob.ency.modules.e3.entry.model.E3Entry e3Entry) {

		return _e3EntryLocalService.getVersions(e3Entry);
	}

	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry publishDraft(
			cz.csob.ency.modules.e3.entry.model.E3Entry draftE3Entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _e3EntryLocalService.publishDraft(draftE3Entry);
	}

	@Override
	public void registerListener(
		com.liferay.portal.kernel.service.version.VersionServiceListener
			<cz.csob.ency.modules.e3.entry.model.E3Entry,
			 cz.csob.ency.modules.e3.entry.model.E3EntryVersion>
				versionServiceListener) {

		_e3EntryLocalService.registerListener(versionServiceListener);
	}

	@Override
	public void unregisterListener(
		com.liferay.portal.kernel.service.version.VersionServiceListener
			<cz.csob.ency.modules.e3.entry.model.E3Entry,
			 cz.csob.ency.modules.e3.entry.model.E3EntryVersion>
				versionServiceListener) {

		_e3EntryLocalService.unregisterListener(versionServiceListener);
	}

	@Override
	public void updateAsset(
			long userId, cz.csob.ency.modules.e3.entry.model.E3Entry entry,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds, Double priority)
		throws com.liferay.portal.kernel.exception.PortalException {

		_e3EntryLocalService.updateAsset(
			userId, entry, assetCategoryIds, assetTagNames, assetLinkEntryIds,
			priority);
	}

	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry updateDraft(
			cz.csob.ency.modules.e3.entry.model.E3Entry draftE3Entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _e3EntryLocalService.updateDraft(draftE3Entry);
	}

	/**
	 * Updates the e3 entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect E3EntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param e3Entry the e3 entry
	 * @return the e3 entry that was updated
	 */
	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry updateE3Entry(
			cz.csob.ency.modules.e3.entry.model.E3Entry draftE3Entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _e3EntryLocalService.updateE3Entry(draftE3Entry);
	}

	@Override
	public cz.csob.ency.modules.e3.entry.model.E3Entry updateEntry(
			cz.csob.ency.modules.e3.entry.model.E3Entry entry, boolean publish,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _e3EntryLocalService.updateEntry(entry, publish, serviceContext);
	}

	@Override
	public E3EntryLocalService getWrappedService() {
		return _e3EntryLocalService;
	}

	@Override
	public void setWrappedService(E3EntryLocalService e3EntryLocalService) {
		_e3EntryLocalService = e3EntryLocalService;
	}

	private E3EntryLocalService _e3EntryLocalService;

}