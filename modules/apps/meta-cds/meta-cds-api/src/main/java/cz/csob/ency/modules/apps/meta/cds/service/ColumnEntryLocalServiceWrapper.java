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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ColumnEntryLocalService}.
 *
 * @author "Miroslav Čermák"
 * @see ColumnEntryLocalService
 * @generated
 */
public class ColumnEntryLocalServiceWrapper
	implements ColumnEntryLocalService,
			   ServiceWrapper<ColumnEntryLocalService> {

	public ColumnEntryLocalServiceWrapper() {
		this(null);
	}

	public ColumnEntryLocalServiceWrapper(
		ColumnEntryLocalService columnEntryLocalService) {

		_columnEntryLocalService = columnEntryLocalService;
	}

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
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry addColumnEntry(
		cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry columnEntry) {

		return _columnEntryLocalService.addColumnEntry(columnEntry);
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
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry addEntry(
			cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.modules.apps.meta.cds.exception.
				   ColumnEntryValidateException {

		return _columnEntryLocalService.addEntry(orgEntry, serviceContext);
	}

	@Override
	public void addEntryResources(
			cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry entry,
			boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_columnEntryLocalService.addEntryResources(
			entry, addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addEntryResources(
			cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry entry,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_columnEntryLocalService.addEntryResources(entry, modelPermissions);
	}

	@Override
	public void addEntryResources(
			long entryId, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_columnEntryLocalService.addEntryResources(
			entryId, addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addEntryResources(
			long entryId,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_columnEntryLocalService.addEntryResources(entryId, modelPermissions);
	}

	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
			addOrUpdateFromRow(
				java.util.Map<String, Object> row,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _columnEntryLocalService.addOrUpdateFromRow(row, serviceContext);
	}

	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
			addOrUpdateFromRow(
				java.util.Map<String, Object> row,
				com.liferay.portal.kernel.service.ServiceContext serviceContext,
				boolean validate)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _columnEntryLocalService.addOrUpdateFromRow(
			row, serviceContext, validate);
	}

	@Override
	public int countAllInGroup(long groupId) {
		return _columnEntryLocalService.countAllInGroup(groupId);
	}

	@Override
	public int countAllInGroup(long groupId, int[] status) {
		return _columnEntryLocalService.countAllInGroup(groupId, status);
	}

	@Override
	public int countAllInUser(long userId) {
		return _columnEntryLocalService.countAllInUser(userId);
	}

	@Override
	public int countAllInUser(long userId, int[] status) {
		return _columnEntryLocalService.countAllInUser(userId, status);
	}

	@Override
	public int countAllInUserAndGroup(long userId, long groupId) {
		return _columnEntryLocalService.countAllInUserAndGroup(userId, groupId);
	}

	@Override
	public int countAllInUserAndGroup(long userId, long groupId, int[] status) {
		return _columnEntryLocalService.countAllInUserAndGroup(
			userId, groupId, status);
	}

	/**
	 * Creates a new column entry with the primary key. Does not add the column entry to the database.
	 *
	 * @param columnEntryId the primary key for the new column entry
	 * @return the new column entry
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
		createColumnEntry(long columnEntryId) {

		return _columnEntryLocalService.createColumnEntry(columnEntryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _columnEntryLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
		deleteColumnEntry(
			cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry columnEntry) {

		return _columnEntryLocalService.deleteColumnEntry(columnEntry);
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
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
			deleteColumnEntry(long columnEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _columnEntryLocalService.deleteColumnEntry(columnEntryId);
	}

	/**
	 * Delete entry
	 *
	 * @param entry ColumnEntry
	 * @return ColumnEntry oject
	 * @throws PortalException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry deleteEntry(
			cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _columnEntryLocalService.deleteEntry(entry);
	}

	/**
	 * Delete entry
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry deleteEntry(
			long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _columnEntryLocalService.deleteEntry(primaryKey);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _columnEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _columnEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _columnEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _columnEntryLocalService.dynamicQuery();
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

		return _columnEntryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _columnEntryLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _columnEntryLocalService.dynamicQuery(
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

		return _columnEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _columnEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
		fetchColumnEntry(long columnEntryId) {

		return _columnEntryLocalService.fetchColumnEntry(columnEntryId);
	}

	/**
	 * Returns the column entry matching the UUID and group.
	 *
	 * @param uuid the column entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
		fetchColumnEntryByUuidAndGroupId(String uuid, long groupId) {

		return _columnEntryLocalService.fetchColumnEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
		findAllInGroup(long groupId) {

		return _columnEntryLocalService.findAllInGroup(groupId);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
		findAllInGroup(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
					orderByComparator) {

		return _columnEntryLocalService.findAllInGroup(
			groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
		findAllInGroup(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
					orderByComparator,
			int[] status) {

		return _columnEntryLocalService.findAllInGroup(
			groupId, start, end, orderByComparator, status);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
		findAllInGroup(long groupId, int[] status) {

		return _columnEntryLocalService.findAllInGroup(groupId, status);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
		findAllInGroup(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
					orderByComparator) {

		return _columnEntryLocalService.findAllInGroup(
			groupId, orderByComparator);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
		findAllInTable(long tableEntryId) {

		return _columnEntryLocalService.findAllInTable(tableEntryId);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
		findAllInUser(long userId) {

		return _columnEntryLocalService.findAllInUser(userId);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
		findAllInUser(
			long userId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
					orderByComparator) {

		return _columnEntryLocalService.findAllInUser(
			userId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
		findAllInUser(
			long userId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
					orderByComparator,
			int[] status) {

		return _columnEntryLocalService.findAllInUser(
			userId, start, end, orderByComparator, status);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
		findAllInUser(long userId, int[] status) {

		return _columnEntryLocalService.findAllInUser(userId, status);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
		findAllInUser(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
					orderByComparator) {

		return _columnEntryLocalService.findAllInUser(
			userId, orderByComparator);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
		findAllInUserAndGroup(long userId, long groupId) {

		return _columnEntryLocalService.findAllInUserAndGroup(userId, groupId);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
		findAllInUserAndGroup(
			long userId, long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
					orderByComparator) {

		return _columnEntryLocalService.findAllInUserAndGroup(
			userId, groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
		findAllInUserAndGroup(
			long userId, long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
					orderByComparator,
			int[] status) {

		return _columnEntryLocalService.findAllInUserAndGroup(
			userId, groupId, start, end, orderByComparator, status);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
		findAllInUserAndGroup(long userId, long groupId, int[] status) {

		return _columnEntryLocalService.findAllInUserAndGroup(
			userId, groupId, status);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
		findAllInUserAndGroup(
			long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
					orderByComparator) {

		return _columnEntryLocalService.findAllInUserAndGroup(
			userId, groupId, orderByComparator);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _columnEntryLocalService.getActionableDynamicQuery();
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
	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
		getColumnEntries(int start, int end) {

		return _columnEntryLocalService.getColumnEntries(start, end);
	}

	/**
	 * Returns all the column entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the column entries
	 * @param companyId the primary key of the company
	 * @return the matching column entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
		getColumnEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _columnEntryLocalService.getColumnEntriesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
		getColumnEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
					orderByComparator) {

		return _columnEntryLocalService.getColumnEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of column entries.
	 *
	 * @return the number of column entries
	 */
	@Override
	public int getColumnEntriesCount() {
		return _columnEntryLocalService.getColumnEntriesCount();
	}

	/**
	 * Returns the column entry with the primary key.
	 *
	 * @param columnEntryId the primary key of the column entry
	 * @return the column entry
	 * @throws PortalException if a column entry with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry getColumnEntry(
			long columnEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _columnEntryLocalService.getColumnEntry(columnEntryId);
	}

	/**
	 * Get Entity
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry getColumnEntry(
			long groupId, String urlTitle)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _columnEntryLocalService.getColumnEntry(groupId, urlTitle);
	}

	/**
	 * Returns the column entry matching the UUID and group.
	 *
	 * @param uuid the column entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching column entry
	 * @throws PortalException if a matching column entry could not be found
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
			getColumnEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _columnEntryLocalService.getColumnEntryByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return ColumnEntry Object
	 * @throws PortletException
	 * @throws ColumnEntryValidateException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
			getColumnEntryFromRequest(
				long primaryKey, javax.portlet.PortletRequest request)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			ColumnEntryValidateException,
			   javax.portlet.PortletException {

		return _columnEntryLocalService.getColumnEntryFromRequest(
			primaryKey, request);
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
	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
		getCompanyEntries(long companyId, int status, int start, int end) {

		return _columnEntryLocalService.getCompanyEntries(
			companyId, status, start, end);
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
	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
		getCompanyEntries(
			long companyId, int status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry> obc) {

		return _columnEntryLocalService.getCompanyEntries(
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
	@Override
	public int getCompanyEntriesCount(long companyId, int status) {
		return _columnEntryLocalService.getCompanyEntriesCount(
			companyId, status);
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

		return _columnEntryLocalService.getDateTimeFromRequest(request, prefix);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _columnEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _columnEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param primaryKey primary key
	 * @param request    PortletRequest
	 * @return ColumnEntry Object
	 * @throws PortletException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
			getInitializedColumnEntry(
				long primaryKey, javax.portlet.PortletRequest request)
		throws javax.portlet.PortletException {

		return _columnEntryLocalService.getInitializedColumnEntry(
			primaryKey, request);
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return ColumnEntry object
	 * @throws PortletException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry getNewObject(
		long primaryKey) {

		return _columnEntryLocalService.getNewObject(primaryKey);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _columnEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _columnEntryLocalService.getPersistedModel(primaryKeyObj);
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
		return _columnEntryLocalService.getStatusAny();
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
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
			moveEntryToTrash(
				long userId,
				cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _columnEntryLocalService.moveEntryToTrash(userId, entry);
	}

	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
			moveEntryToTrash(long userId, long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _columnEntryLocalService.moveEntryToTrash(userId, entryId);
	}

	/**
	 * Restores the entry with the ID from the recycle bin. Social activity counters
	 * for this entry get activated.
	 *
	 * @param userId  the primary key of the user restoring the entry
	 * @param entryId the primary key of the entry to be restored
	 * @return the restored entry from the recycle bin
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
			restoreEntryFromTrash(long userId, long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _columnEntryLocalService.restoreEntryFromTrash(userId, entryId);
	}

	@Override
	public void updateAsset(
			long userId,
			cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry entry,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds, Double priority)
		throws com.liferay.portal.kernel.exception.PortalException {

		_columnEntryLocalService.updateAsset(
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
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
		updateColumnEntry(
			cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry columnEntry) {

		return _columnEntryLocalService.updateColumnEntry(columnEntry);
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
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry updateEntry(
			cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.modules.apps.meta.cds.exception.
				   ColumnEntryValidateException {

		return _columnEntryLocalService.updateEntry(orgEntry, serviceContext);
	}

	@Override
	public void updateEntryResources(
			cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry entry,
			String[] groupPermissions, String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_columnEntryLocalService.updateEntryResources(
			entry, groupPermissions, guestPermissions);
	}

	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _columnEntryLocalService.updateStatus(
			userId, entryId, status, serviceContext, workflowContext);
	}

	@Override
	public ColumnEntryLocalService getWrappedService() {
		return _columnEntryLocalService;
	}

	@Override
	public void setWrappedService(
		ColumnEntryLocalService columnEntryLocalService) {

		_columnEntryLocalService = columnEntryLocalService;
	}

	private ColumnEntryLocalService _columnEntryLocalService;

}