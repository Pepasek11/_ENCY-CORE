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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import cz.csob.ency.modules.e3.entry.model.E3Entry;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for E3Entry. This utility wraps
 * <code>cz.csob.ency.modules.e3.entry.service.impl.E3EntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see E3EntryLocalService
 * @generated
 */
public class E3EntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>cz.csob.ency.modules.e3.entry.service.impl.E3EntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static E3Entry addE3Entry(E3Entry e3Entry) {
		return getService().addE3Entry(e3Entry);
	}

	public static E3Entry addEntry(
			E3Entry entry, boolean publish,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addEntry(entry, publish, serviceContext);
	}

	public static E3Entry addEntry(
			long userId, E3Entry entry, boolean publish,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addEntry(userId, entry, publish, serviceContext);
	}

	public static void addEntryResources(
			E3Entry entry, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException {

		getService().addEntryResources(
			entry, addGroupPermissions, addGuestPermissions);
	}

	public static void addEntryResources(
			E3Entry entry,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws PortalException {

		getService().addEntryResources(entry, modelPermissions);
	}

	public static E3Entry checkout(E3Entry publishedE3Entry, int version)
		throws PortalException {

		return getService().checkout(publishedE3Entry, version);
	}

	/**
	 * Creates a new e3 entry. Does not add the e3 entry to the database.
	 *
	 * @return the new e3 entry
	 */
	public static E3Entry create() {
		return getService().create();
	}

	/**
	 * Creates a new draft e3 entry for given app class. Does not add the e3 entry to the database.
	 *
	 * @return the new draft e3 entry
	 */
	public static E3Entry createEntry(String appClass) {
		return getService().createEntry(appClass);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static E3Entry delete(E3Entry publishedE3Entry)
		throws PortalException {

		return getService().delete(publishedE3Entry);
	}

	public static E3Entry deleteDraft(E3Entry draftE3Entry)
		throws PortalException {

		return getService().deleteDraft(draftE3Entry);
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
	public static E3Entry deleteE3Entry(E3Entry e3Entry) {
		return getService().deleteE3Entry(e3Entry);
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
	public static E3Entry deleteE3Entry(long entryId) throws PortalException {
		return getService().deleteE3Entry(entryId);
	}

	public static E3Entry deleteEntry(
			E3Entry entry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().deleteEntry(entry, serviceContext);
	}

	public static E3Entry deleteEntry(long entryId) throws PortalException {
		return getService().deleteEntry(entryId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static cz.csob.ency.modules.e3.entry.model.E3EntryVersion
			deleteVersion(
				cz.csob.ency.modules.e3.entry.model.E3EntryVersion
					e3EntryVersion)
		throws PortalException {

		return getService().deleteVersion(e3EntryVersion);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.modules.e3.entry.model.impl.E3EntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.modules.e3.entry.model.impl.E3EntryModelImpl</code>.
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

	public static E3Entry fetchDraft(E3Entry e3Entry) {
		return getService().fetchDraft(e3Entry);
	}

	public static E3Entry fetchDraft(long primaryKey) {
		return getService().fetchDraft(primaryKey);
	}

	public static E3Entry fetchE3Entry(long entryId) {
		return getService().fetchE3Entry(entryId);
	}

	public static cz.csob.ency.modules.e3.entry.model.E3EntryVersion
		fetchLatestVersion(E3Entry e3Entry) {

		return getService().fetchLatestVersion(e3Entry);
	}

	public static E3Entry fetchPublished(E3Entry e3Entry) {
		return getService().fetchPublished(e3Entry);
	}

	public static E3Entry fetchPublished(long primaryKey) {
		return getService().fetchPublished(primaryKey);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static E3Entry getDraft(E3Entry e3Entry) throws PortalException {
		return getService().getDraft(e3Entry);
	}

	public static E3Entry getDraft(long primaryKey) throws PortalException {
		return getService().getDraft(primaryKey);
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
	public static List<E3Entry> getE3Entries(int start, int end) {
		return getService().getE3Entries(start, end);
	}

	/**
	 * Returns the number of e3 entries.
	 *
	 * @return the number of e3 entries
	 */
	public static int getE3EntriesCount() {
		return getService().getE3EntriesCount();
	}

	/**
	 * Returns the e3 entry with the primary key.
	 *
	 * @param entryId the primary key of the e3 entry
	 * @return the e3 entry
	 * @throws PortalException if a e3 entry with the primary key could not be found
	 */
	public static E3Entry getE3Entry(long entryId) throws PortalException {
		return getService().getE3Entry(entryId);
	}

	public static E3Entry getEntry(long entryId)
		throws cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException {

		return getService().getEntry(entryId);
	}

	public static String getEntryPortletName(E3Entry entry)
		throws PortalException {

		return getService().getEntryPortletName(entry);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static long getMaxEntryVersion(long id) {
		return getService().getMaxEntryVersion(id);
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

	public static cz.csob.ency.modules.e3.entry.model.E3EntryVersion getVersion(
			E3Entry e3Entry, int version)
		throws PortalException {

		return getService().getVersion(e3Entry, version);
	}

	public static List<cz.csob.ency.modules.e3.entry.model.E3EntryVersion>
		getVersions(E3Entry e3Entry) {

		return getService().getVersions(e3Entry);
	}

	public static E3Entry publishDraft(E3Entry draftE3Entry)
		throws PortalException {

		return getService().publishDraft(draftE3Entry);
	}

	public static void registerListener(
		com.liferay.portal.kernel.service.version.VersionServiceListener
			<E3Entry, cz.csob.ency.modules.e3.entry.model.E3EntryVersion>
				versionServiceListener) {

		getService().registerListener(versionServiceListener);
	}

	public static void unregisterListener(
		com.liferay.portal.kernel.service.version.VersionServiceListener
			<E3Entry, cz.csob.ency.modules.e3.entry.model.E3EntryVersion>
				versionServiceListener) {

		getService().unregisterListener(versionServiceListener);
	}

	public static void updateAsset(
			long userId, E3Entry entry, long[] assetCategoryIds,
			String[] assetTagNames, long[] assetLinkEntryIds, Double priority)
		throws PortalException {

		getService().updateAsset(
			userId, entry, assetCategoryIds, assetTagNames, assetLinkEntryIds,
			priority);
	}

	public static E3Entry updateDraft(E3Entry draftE3Entry)
		throws PortalException {

		return getService().updateDraft(draftE3Entry);
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
	public static E3Entry updateE3Entry(E3Entry draftE3Entry)
		throws PortalException {

		return getService().updateE3Entry(draftE3Entry);
	}

	public static E3Entry updateEntry(
			E3Entry entry, boolean publish,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateEntry(entry, publish, serviceContext);
	}

	public static E3EntryLocalService getService() {
		return _service;
	}

	private static volatile E3EntryLocalService _service;

}