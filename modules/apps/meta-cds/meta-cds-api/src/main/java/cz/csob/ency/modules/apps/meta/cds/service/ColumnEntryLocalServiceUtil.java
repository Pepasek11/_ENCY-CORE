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

package cz.csob.ency.modules.apps.meta.cds.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for ColumnEntry. This utility wraps
 * <code>cz.csob.ency.modules.apps.meta.cds.service.impl.ColumnEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author "Miroslav Čermák"
 * @see ColumnEntryLocalService
 * @generated
 */
public class ColumnEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>cz.csob.ency.modules.apps.meta.cds.service.impl.ColumnEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the column entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ColumnEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param columnEntry the column entry
	 * @return the column entry that was added
	 */
	public static ColumnEntry addColumnEntry(ColumnEntry columnEntry) {
		return getService().addColumnEntry(columnEntry);
	}

	/**
	 * Add Entry
	 *
	 * @param orgEntry       ColumnEntry model
	 * @param serviceContext ServiceContext
	 * @return created ColumnEntry model.
	 * @throws PortalException
	 * @throws ColumnEntryValidateException
	 */
	public static ColumnEntry addEntry(
			ColumnEntry orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			ColumnEntryValidateException,
			   PortalException {

		return getService().addEntry(orgEntry, serviceContext);
	}

	public static void addEntryResources(
			ColumnEntry entry, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException {

		getService().addEntryResources(
			entry, addGroupPermissions, addGuestPermissions);
	}

	public static void addEntryResources(
			ColumnEntry entry,
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

	public static ColumnEntry addOrUpdateFromRow(
			Map<String, Object> row,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addOrUpdateFromRow(row, serviceContext);
	}

	public static ColumnEntry addOrUpdateFromRow(
			Map<String, Object> row,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			boolean validate)
		throws PortalException {

		return getService().addOrUpdateFromRow(row, serviceContext, validate);
	}

	public static int countAllInGroup(long groupId) {
		return getService().countAllInGroup(groupId);
	}

	public static int countAllInGroup(long groupId, int[] status) {
		return getService().countAllInGroup(groupId, status);
	}

	public static int countAllInUser(long userId) {
		return getService().countAllInUser(userId);
	}

	public static int countAllInUser(long userId, int[] status) {
		return getService().countAllInUser(userId, status);
	}

	public static int countAllInUserAndGroup(long userId, long groupId) {
		return getService().countAllInUserAndGroup(userId, groupId);
	}

	public static int countAllInUserAndGroup(
		long userId, long groupId, int[] status) {

		return getService().countAllInUserAndGroup(userId, groupId, status);
	}

	/**
	 * Creates a new column entry with the primary key. Does not add the column entry to the database.
	 *
	 * @param columnEntryId the primary key for the new column entry
	 * @return the new column entry
	 */
	public static ColumnEntry createColumnEntry(long columnEntryId) {
		return getService().createColumnEntry(columnEntryId);
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
	 * Deletes the column entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ColumnEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param columnEntry the column entry
	 * @return the column entry that was removed
	 */
	public static ColumnEntry deleteColumnEntry(ColumnEntry columnEntry) {
		return getService().deleteColumnEntry(columnEntry);
	}

	/**
	 * Deletes the column entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ColumnEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param columnEntryId the primary key of the column entry
	 * @return the column entry that was removed
	 * @throws PortalException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry deleteColumnEntry(long columnEntryId)
		throws PortalException {

		return getService().deleteColumnEntry(columnEntryId);
	}

	/**
	 * Delete entry
	 *
	 * @param entry ColumnEntry
	 * @return ColumnEntry oject
	 * @throws PortalException
	 */
	public static ColumnEntry deleteEntry(ColumnEntry entry)
		throws PortalException {

		return getService().deleteEntry(entry);
	}

	/**
	 * Delete entry
	 */
	public static ColumnEntry deleteEntry(long primaryKey)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.modules.apps.meta.cds.model.impl.ColumnEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.modules.apps.meta.cds.model.impl.ColumnEntryModelImpl</code>.
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

	public static ColumnEntry fetchColumnEntry(long columnEntryId) {
		return getService().fetchColumnEntry(columnEntryId);
	}

	/**
	 * Returns the column entry matching the UUID and group.
	 *
	 * @param uuid the column entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	public static ColumnEntry fetchColumnEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchColumnEntryByUuidAndGroupId(uuid, groupId);
	}

	public static List<ColumnEntry> findAllInGroup(long groupId) {
		return getService().findAllInGroup(groupId);
	}

	public static List<ColumnEntry> findAllInGroup(
		long groupId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getService().findAllInGroup(
			groupId, start, end, orderByComparator);
	}

	public static List<ColumnEntry> findAllInGroup(
		long groupId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator, int[] status) {

		return getService().findAllInGroup(
			groupId, start, end, orderByComparator, status);
	}

	public static List<ColumnEntry> findAllInGroup(long groupId, int[] status) {
		return getService().findAllInGroup(groupId, status);
	}

	public static List<ColumnEntry> findAllInGroup(
		long groupId, OrderByComparator<ColumnEntry> orderByComparator) {

		return getService().findAllInGroup(groupId, orderByComparator);
	}

	public static List<ColumnEntry> findAllInTable(long tableEntryId) {
		return getService().findAllInTable(tableEntryId);
	}

	public static List<ColumnEntry> findAllInUser(long userId) {
		return getService().findAllInUser(userId);
	}

	public static List<ColumnEntry> findAllInUser(
		long userId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getService().findAllInUser(
			userId, start, end, orderByComparator);
	}

	public static List<ColumnEntry> findAllInUser(
		long userId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator, int[] status) {

		return getService().findAllInUser(
			userId, start, end, orderByComparator, status);
	}

	public static List<ColumnEntry> findAllInUser(long userId, int[] status) {
		return getService().findAllInUser(userId, status);
	}

	public static List<ColumnEntry> findAllInUser(
		long userId, OrderByComparator<ColumnEntry> orderByComparator) {

		return getService().findAllInUser(userId, orderByComparator);
	}

	public static List<ColumnEntry> findAllInUserAndGroup(
		long userId, long groupId) {

		return getService().findAllInUserAndGroup(userId, groupId);
	}

	public static List<ColumnEntry> findAllInUserAndGroup(
		long userId, long groupId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getService().findAllInUserAndGroup(
			userId, groupId, start, end, orderByComparator);
	}

	public static List<ColumnEntry> findAllInUserAndGroup(
		long userId, long groupId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator, int[] status) {

		return getService().findAllInUserAndGroup(
			userId, groupId, start, end, orderByComparator, status);
	}

	public static List<ColumnEntry> findAllInUserAndGroup(
		long userId, long groupId, int[] status) {

		return getService().findAllInUserAndGroup(userId, groupId, status);
	}

	public static List<ColumnEntry> findAllInUserAndGroup(
		long userId, long groupId,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getService().findAllInUserAndGroup(
			userId, groupId, orderByComparator);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the column entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.modules.apps.meta.cds.model.impl.ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of column entries
	 */
	public static List<ColumnEntry> getColumnEntries(int start, int end) {
		return getService().getColumnEntries(start, end);
	}

	/**
	 * Returns all the column entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the column entries
	 * @param companyId the primary key of the company
	 * @return the matching column entries, or an empty list if no matches were found
	 */
	public static List<ColumnEntry> getColumnEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getColumnEntriesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of column entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the column entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching column entries, or an empty list if no matches were found
	 */
	public static List<ColumnEntry> getColumnEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return getService().getColumnEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of column entries.
	 *
	 * @return the number of column entries
	 */
	public static int getColumnEntriesCount() {
		return getService().getColumnEntriesCount();
	}

	/**
	 * Returns the column entry with the primary key.
	 *
	 * @param columnEntryId the primary key of the column entry
	 * @return the column entry
	 * @throws PortalException if a column entry with the primary key could not be found
	 */
	public static ColumnEntry getColumnEntry(long columnEntryId)
		throws PortalException {

		return getService().getColumnEntry(columnEntryId);
	}

	/**
	 * Get Entity
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	public static ColumnEntry getColumnEntry(long groupId, String urlTitle)
		throws PortalException {

		return getService().getColumnEntry(groupId, urlTitle);
	}

	/**
	 * Returns the column entry matching the UUID and group.
	 *
	 * @param uuid the column entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching column entry
	 * @throws PortalException if a matching column entry could not be found
	 */
	public static ColumnEntry getColumnEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getColumnEntryByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return ColumnEntry Object
	 * @throws PortletException
	 * @throws ColumnEntryValidateException
	 */
	public static ColumnEntry getColumnEntryFromRequest(
			long primaryKey, javax.portlet.PortletRequest request)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			ColumnEntryValidateException,
			   javax.portlet.PortletException {

		return getService().getColumnEntryFromRequest(primaryKey, request);
	}

	/**
	 * Get Company entries
	 *
	 * @param companyId Company Id
	 * @param status    Workflow status
	 * @param start     start index of entries
	 * @param end       end index of entries
	 * @return
	 * @throws SystemException
	 */
	public static List<ColumnEntry> getCompanyEntries(
		long companyId, int status, int start, int end) {

		return getService().getCompanyEntries(companyId, status, start, end);
	}

	/**
	 * Get Company entries
	 *
	 * @param companyId Company Id
	 * @param status    Workflow status
	 * @param start     start index of entries
	 * @param end       end index of entries
	 * @param obc       Comparator for the order
	 * @return List of entries
	 * @throws SystemException
	 */
	public static List<ColumnEntry> getCompanyEntries(
		long companyId, int status, int start, int end,
		OrderByComparator<ColumnEntry> obc) {

		return getService().getCompanyEntries(
			companyId, status, start, end, obc);
	}

	/**
	 * Get Company entries counts
	 *
	 * @param companyId
	 * @param status
	 * @return
	 * @throws SystemException
	 */
	public static int getCompanyEntriesCount(long companyId, int status) {
		return getService().getCompanyEntriesCount(companyId, status);
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

	/**
	 * Populate Model with values from a form
	 *
	 * @param primaryKey primary key
	 * @param request    PortletRequest
	 * @return ColumnEntry Object
	 * @throws PortletException
	 */
	public static ColumnEntry getInitializedColumnEntry(
			long primaryKey, javax.portlet.PortletRequest request)
		throws javax.portlet.PortletException {

		return getService().getInitializedColumnEntry(primaryKey, request);
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return ColumnEntry object
	 * @throws PortletException
	 */
	public static ColumnEntry getNewObject(long primaryKey) {
		return getService().getNewObject(primaryKey);
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
	 * Get STATUS_ANY for DB
	 * <p>
	 * This is equivalent of WorkflowConstants.STATUS_ANY
	 *
	 * @return All statuses for Workflow
	 */
	public static int[] getStatusAny() {
		return getService().getStatusAny();
	}

	/**
	 * Moves the entry to the recycle bin.
	 * <p>
	 * Social activity counters for this entry get disabled.
	 *
	 * @param userId the primary key of the user moving the entry
	 * @param entry  the entry to be moved
	 * @return the moved entry
	 */
	public static ColumnEntry moveEntryToTrash(long userId, ColumnEntry entry)
		throws PortalException {

		return getService().moveEntryToTrash(userId, entry);
	}

	public static ColumnEntry moveEntryToTrash(long userId, long entryId)
		throws PortalException {

		return getService().moveEntryToTrash(userId, entryId);
	}

	/**
	 * Restores the entry with the ID from the recycle bin. Social activity counters
	 * for this entry get activated.
	 *
	 * @param userId  the primary key of the user restoring the entry
	 * @param entryId the primary key of the entry to be restored
	 * @return the restored entry from the recycle bin
	 */
	public static ColumnEntry restoreEntryFromTrash(long userId, long entryId)
		throws PortalException {

		return getService().restoreEntryFromTrash(userId, entryId);
	}

	public static void updateAsset(
			long userId, ColumnEntry entry, long[] assetCategoryIds,
			String[] assetTagNames, long[] assetLinkEntryIds, Double priority)
		throws PortalException {

		getService().updateAsset(
			userId, entry, assetCategoryIds, assetTagNames, assetLinkEntryIds,
			priority);
	}

	/**
	 * Updates the column entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ColumnEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param columnEntry the column entry
	 * @return the column entry that was updated
	 */
	public static ColumnEntry updateColumnEntry(ColumnEntry columnEntry) {
		return getService().updateColumnEntry(columnEntry);
	}

	/**
	 * Edit Entry
	 *
	 * @param orgEntry       ColumnEntry model
	 * @param serviceContext ServiceContext
	 * @return updated ColumnEntry model.
	 * @throws PortalException
	 * @throws ColumnEntryValidateException
	 */
	public static ColumnEntry updateEntry(
			ColumnEntry orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			ColumnEntryValidateException,
			   PortalException {

		return getService().updateEntry(orgEntry, serviceContext);
	}

	public static void updateEntryResources(
			ColumnEntry entry, String[] groupPermissions,
			String[] guestPermissions)
		throws PortalException {

		getService().updateEntryResources(
			entry, groupPermissions, guestPermissions);
	}

	public static ColumnEntry updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().updateStatus(
			userId, entryId, status, serviceContext, workflowContext);
	}

	public static ColumnEntryLocalService getService() {
		return _service;
	}

	private static volatile ColumnEntryLocalService _service;

}