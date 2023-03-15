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
 * Provides a wrapper for {@link TableEntryLocalService}.
 *
 * @author "Miroslav Čermák"
 * @see TableEntryLocalService
 * @generated
 */
public class TableEntryLocalServiceWrapper
	implements ServiceWrapper<TableEntryLocalService>, TableEntryLocalService {

	public TableEntryLocalServiceWrapper() {
		this(null);
	}

	public TableEntryLocalServiceWrapper(
		TableEntryLocalService tableEntryLocalService) {

		_tableEntryLocalService = tableEntryLocalService;
	}

	/**
	 * Add Entry
	 *
	 * @param orgEntry       TableEntry model
	 * @param serviceContext ServiceContext
	 * @return created TableEntry model.
	 * @throws PortalException
	 * @throws TableEntryValidateException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry addEntry(
			cz.csob.ency.modules.apps.meta.cds.model.TableEntry orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.modules.apps.meta.cds.exception.
				   TableEntryValidateException {

		return _tableEntryLocalService.addEntry(orgEntry, serviceContext);
	}

	@Override
	public void addEntryResources(
			long entryId, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_tableEntryLocalService.addEntryResources(
			entryId, addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addEntryResources(
			long entryId,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_tableEntryLocalService.addEntryResources(entryId, modelPermissions);
	}

	@Override
	public void addEntryResources(
			cz.csob.ency.modules.apps.meta.cds.model.TableEntry entry,
			boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_tableEntryLocalService.addEntryResources(
			entry, addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addEntryResources(
			cz.csob.ency.modules.apps.meta.cds.model.TableEntry entry,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_tableEntryLocalService.addEntryResources(entry, modelPermissions);
	}

	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry
			addOrUpdateFromRow(
				java.util.Map<String, Object> row,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableEntryLocalService.addOrUpdateFromRow(row, serviceContext);
	}

	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry
			addOrUpdateFromRow(
				java.util.Map<String, Object> row,
				com.liferay.portal.kernel.service.ServiceContext serviceContext,
				boolean validate)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableEntryLocalService.addOrUpdateFromRow(
			row, serviceContext, validate);
	}

	/**
	 * Adds the table entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TableEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tableEntry the table entry
	 * @return the table entry that was added
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry addTableEntry(
		cz.csob.ency.modules.apps.meta.cds.model.TableEntry tableEntry) {

		return _tableEntryLocalService.addTableEntry(tableEntry);
	}

	@Override
	public int countAllInGroup(long groupId) {
		return _tableEntryLocalService.countAllInGroup(groupId);
	}

	@Override
	public int countAllInGroup(long groupId, int[] status) {
		return _tableEntryLocalService.countAllInGroup(groupId, status);
	}

	@Override
	public int countAllInUser(long userId) {
		return _tableEntryLocalService.countAllInUser(userId);
	}

	@Override
	public int countAllInUser(long userId, int[] status) {
		return _tableEntryLocalService.countAllInUser(userId, status);
	}

	@Override
	public int countAllInUserAndGroup(long userId, long groupId) {
		return _tableEntryLocalService.countAllInUserAndGroup(userId, groupId);
	}

	@Override
	public int countAllInUserAndGroup(long userId, long groupId, int[] status) {
		return _tableEntryLocalService.countAllInUserAndGroup(
			userId, groupId, status);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new table entry with the primary key. Does not add the table entry to the database.
	 *
	 * @param tableEntryId the primary key for the new table entry
	 * @return the new table entry
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry createTableEntry(
		long tableEntryId) {

		return _tableEntryLocalService.createTableEntry(tableEntryId);
	}

	/**
	 * Delete entry
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry deleteEntry(
			long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableEntryLocalService.deleteEntry(primaryKey);
	}

	/**
	 * Delete entry
	 *
	 * @param entry TableEntry
	 * @return TableEntry oject
	 * @throws PortalException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry deleteEntry(
			cz.csob.ency.modules.apps.meta.cds.model.TableEntry entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableEntryLocalService.deleteEntry(entry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableEntryLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the table entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TableEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tableEntryId the primary key of the table entry
	 * @return the table entry that was removed
	 * @throws PortalException if a table entry with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry deleteTableEntry(
			long tableEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableEntryLocalService.deleteTableEntry(tableEntryId);
	}

	/**
	 * Deletes the table entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TableEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tableEntry the table entry
	 * @return the table entry that was removed
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry deleteTableEntry(
		cz.csob.ency.modules.apps.meta.cds.model.TableEntry tableEntry) {

		return _tableEntryLocalService.deleteTableEntry(tableEntry);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _tableEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _tableEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tableEntryLocalService.dynamicQuery();
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

		return _tableEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.modules.apps.meta.cds.model.impl.TableEntryModelImpl</code>.
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

		return _tableEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.modules.apps.meta.cds.model.impl.TableEntryModelImpl</code>.
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

		return _tableEntryLocalService.dynamicQuery(
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

		return _tableEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _tableEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry
		fetchEntryByTableFullName(String tableFullName) {

		return _tableEntryLocalService.fetchEntryByTableFullName(tableFullName);
	}

	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry fetchTableEntry(
		long tableEntryId) {

		return _tableEntryLocalService.fetchTableEntry(tableEntryId);
	}

	/**
	 * Returns the table entry matching the UUID and group.
	 *
	 * @param uuid the table entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry
		fetchTableEntryByUuidAndGroupId(String uuid, long groupId) {

		return _tableEntryLocalService.fetchTableEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		findAllInGroup(long groupId) {

		return _tableEntryLocalService.findAllInGroup(groupId);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		findAllInGroup(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
					orderByComparator) {

		return _tableEntryLocalService.findAllInGroup(
			groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		findAllInGroup(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
					orderByComparator,
			int[] status) {

		return _tableEntryLocalService.findAllInGroup(
			groupId, start, end, orderByComparator, status);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		findAllInGroup(long groupId, int[] status) {

		return _tableEntryLocalService.findAllInGroup(groupId, status);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		findAllInGroup(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
					orderByComparator) {

		return _tableEntryLocalService.findAllInGroup(
			groupId, orderByComparator);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		findAllInSystem(long systemEntryId) {

		return _tableEntryLocalService.findAllInSystem(systemEntryId);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		findAllInSystemDatabase(long systemEntryId, String tableDatabase) {

		return _tableEntryLocalService.findAllInSystemDatabase(
			systemEntryId, tableDatabase);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		findAllInSystemDatabase(long systemEntryId, String[] tableDatabase) {

		return _tableEntryLocalService.findAllInSystemDatabase(
			systemEntryId, tableDatabase);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		findAllInSystemType(long systemEntryId, String tableType) {

		return _tableEntryLocalService.findAllInSystemType(
			systemEntryId, tableType);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		findAllInSystemType(long systemEntryId, String[] tableType) {

		return _tableEntryLocalService.findAllInSystemType(
			systemEntryId, tableType);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		findAllInUser(long userId) {

		return _tableEntryLocalService.findAllInUser(userId);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		findAllInUser(
			long userId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
					orderByComparator) {

		return _tableEntryLocalService.findAllInUser(
			userId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		findAllInUser(
			long userId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
					orderByComparator,
			int[] status) {

		return _tableEntryLocalService.findAllInUser(
			userId, start, end, orderByComparator, status);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		findAllInUser(long userId, int[] status) {

		return _tableEntryLocalService.findAllInUser(userId, status);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		findAllInUser(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
					orderByComparator) {

		return _tableEntryLocalService.findAllInUser(userId, orderByComparator);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		findAllInUserAndGroup(long userId, long groupId) {

		return _tableEntryLocalService.findAllInUserAndGroup(userId, groupId);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		findAllInUserAndGroup(
			long userId, long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
					orderByComparator) {

		return _tableEntryLocalService.findAllInUserAndGroup(
			userId, groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		findAllInUserAndGroup(
			long userId, long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
					orderByComparator,
			int[] status) {

		return _tableEntryLocalService.findAllInUserAndGroup(
			userId, groupId, start, end, orderByComparator, status);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		findAllInUserAndGroup(long userId, long groupId, int[] status) {

		return _tableEntryLocalService.findAllInUserAndGroup(
			userId, groupId, status);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		findAllInUserAndGroup(
			long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
					orderByComparator) {

		return _tableEntryLocalService.findAllInUserAndGroup(
			userId, groupId, orderByComparator);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _tableEntryLocalService.getActionableDynamicQuery();
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
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		getCompanyEntries(long companyId, int status, int start, int end) {

		return _tableEntryLocalService.getCompanyEntries(
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
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		getCompanyEntries(
			long companyId, int status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.TableEntry> obc) {

		return _tableEntryLocalService.getCompanyEntries(
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
		return _tableEntryLocalService.getCompanyEntriesCount(
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

		return _tableEntryLocalService.getDateTimeFromRequest(request, prefix);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _tableEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _tableEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param primaryKey primary key
	 * @param request    PortletRequest
	 * @return TableEntry Object
	 * @throws PortletException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry
			getInitializedTableEntry(
				long primaryKey, javax.portlet.PortletRequest request)
		throws javax.portlet.PortletException {

		return _tableEntryLocalService.getInitializedTableEntry(
			primaryKey, request);
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return TableEntry object
	 * @throws PortletException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry getNewObject(
		long primaryKey) {

		return _tableEntryLocalService.getNewObject(primaryKey);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tableEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableEntryLocalService.getPersistedModel(primaryKeyObj);
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
		return _tableEntryLocalService.getStatusAny();
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		getSystemTables(Long systemId) {

		return _tableEntryLocalService.getSystemTables(systemId);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		getSystemTables(Long systemEntryId, String type) {

		return _tableEntryLocalService.getSystemTables(systemEntryId, type);
	}

	/**
	 * Returns a range of all the table entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.modules.apps.meta.cds.model.impl.TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of table entries
	 */
	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		getTableEntries(int start, int end) {

		return _tableEntryLocalService.getTableEntries(start, end);
	}

	/**
	 * Returns all the table entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the table entries
	 * @param companyId the primary key of the company
	 * @return the matching table entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		getTableEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _tableEntryLocalService.getTableEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of table entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the table entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching table entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		getTableEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
					orderByComparator) {

		return _tableEntryLocalService.getTableEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of table entries.
	 *
	 * @return the number of table entries
	 */
	@Override
	public int getTableEntriesCount() {
		return _tableEntryLocalService.getTableEntriesCount();
	}

	/**
	 * Returns the table entry with the primary key.
	 *
	 * @param tableEntryId the primary key of the table entry
	 * @return the table entry
	 * @throws PortalException if a table entry with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry getTableEntry(
			long tableEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableEntryLocalService.getTableEntry(tableEntryId);
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
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry getTableEntry(
			long groupId, String urlTitle)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableEntryLocalService.getTableEntry(groupId, urlTitle);
	}

	/**
	 * Returns the table entry matching the UUID and group.
	 *
	 * @param uuid the table entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching table entry
	 * @throws PortalException if a matching table entry could not be found
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry
			getTableEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableEntryLocalService.getTableEntryByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return TableEntry Object
	 * @throws PortletException
	 * @throws TableEntryValidateException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry
			getTableEntryFromRequest(
				long primaryKey, javax.portlet.PortletRequest request)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			TableEntryValidateException,
			   javax.portlet.PortletException {

		return _tableEntryLocalService.getTableEntryFromRequest(
			primaryKey, request);
	}

	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry moveEntryToTrash(
			long userId, long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableEntryLocalService.moveEntryToTrash(userId, entryId);
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
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry moveEntryToTrash(
			long userId,
			cz.csob.ency.modules.apps.meta.cds.model.TableEntry entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableEntryLocalService.moveEntryToTrash(userId, entry);
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
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry
			restoreEntryFromTrash(long userId, long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableEntryLocalService.restoreEntryFromTrash(userId, entryId);
	}

	@Override
	public void updateAsset(
			long userId,
			cz.csob.ency.modules.apps.meta.cds.model.TableEntry entry,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds, Double priority)
		throws com.liferay.portal.kernel.exception.PortalException {

		_tableEntryLocalService.updateAsset(
			userId, entry, assetCategoryIds, assetTagNames, assetLinkEntryIds,
			priority);
	}

	/**
	 * Edit Entry
	 *
	 * @param orgEntry       TableEntry model
	 * @param serviceContext ServiceContext
	 * @return updated TableEntry model.
	 * @throws PortalException
	 * @throws TableEntryValidateException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry updateEntry(
			cz.csob.ency.modules.apps.meta.cds.model.TableEntry orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.modules.apps.meta.cds.exception.
				   TableEntryValidateException {

		return _tableEntryLocalService.updateEntry(orgEntry, serviceContext);
	}

	@Override
	public void updateEntryResources(
			cz.csob.ency.modules.apps.meta.cds.model.TableEntry entry,
			String[] groupPermissions, String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_tableEntryLocalService.updateEntryResources(
			entry, groupPermissions, guestPermissions);
	}

	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableEntryLocalService.updateStatus(
			userId, entryId, status, serviceContext, workflowContext);
	}

	/**
	 * Updates the table entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TableEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tableEntry the table entry
	 * @return the table entry that was updated
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry updateTableEntry(
		cz.csob.ency.modules.apps.meta.cds.model.TableEntry tableEntry) {

		return _tableEntryLocalService.updateTableEntry(tableEntry);
	}

	@Override
	public TableEntryLocalService getWrappedService() {
		return _tableEntryLocalService;
	}

	@Override
	public void setWrappedService(
		TableEntryLocalService tableEntryLocalService) {

		_tableEntryLocalService = tableEntryLocalService;
	}

	private TableEntryLocalService _tableEntryLocalService;

}