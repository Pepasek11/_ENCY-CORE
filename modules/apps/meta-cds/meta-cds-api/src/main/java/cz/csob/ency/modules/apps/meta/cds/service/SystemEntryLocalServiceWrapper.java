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
 * Provides a wrapper for {@link SystemEntryLocalService}.
 *
 * @author "Miroslav Čermák"
 * @see SystemEntryLocalService
 * @generated
 */
public class SystemEntryLocalServiceWrapper
	implements ServiceWrapper<SystemEntryLocalService>,
			   SystemEntryLocalService {

	public SystemEntryLocalServiceWrapper() {
		this(null);
	}

	public SystemEntryLocalServiceWrapper(
		SystemEntryLocalService systemEntryLocalService) {

		_systemEntryLocalService = systemEntryLocalService;
	}

	/**
	 * Add Entry
	 *
	 * @param orgEntry       SystemEntry model
	 * @param serviceContext ServiceContext
	 * @return created SystemEntry model.
	 * @throws PortalException
	 * @throws SystemEntryValidateException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry addEntry(
			cz.csob.ency.modules.apps.meta.cds.model.SystemEntry orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.modules.apps.meta.cds.exception.
				   SystemEntryValidateException {

		return _systemEntryLocalService.addEntry(orgEntry, serviceContext);
	}

	@Override
	public void addEntryResources(
			long entryId, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_systemEntryLocalService.addEntryResources(
			entryId, addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addEntryResources(
			long entryId,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_systemEntryLocalService.addEntryResources(entryId, modelPermissions);
	}

	@Override
	public void addEntryResources(
			cz.csob.ency.modules.apps.meta.cds.model.SystemEntry entry,
			boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_systemEntryLocalService.addEntryResources(
			entry, addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addEntryResources(
			cz.csob.ency.modules.apps.meta.cds.model.SystemEntry entry,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_systemEntryLocalService.addEntryResources(entry, modelPermissions);
	}

	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
			addOrUpdateFromRow(
				java.util.Map<String, Object> row,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _systemEntryLocalService.addOrUpdateFromRow(row, serviceContext);
	}

	/**
	 * Adds the system entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SystemEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param systemEntry the system entry
	 * @return the system entry that was added
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry addSystemEntry(
		cz.csob.ency.modules.apps.meta.cds.model.SystemEntry systemEntry) {

		return _systemEntryLocalService.addSystemEntry(systemEntry);
	}

	@Override
	public int countAllInGroup(long groupId) {
		return _systemEntryLocalService.countAllInGroup(groupId);
	}

	@Override
	public int countAllInGroup(long groupId, int[] status) {
		return _systemEntryLocalService.countAllInGroup(groupId, status);
	}

	@Override
	public int countAllInUser(long userId) {
		return _systemEntryLocalService.countAllInUser(userId);
	}

	@Override
	public int countAllInUser(long userId, int[] status) {
		return _systemEntryLocalService.countAllInUser(userId, status);
	}

	@Override
	public int countAllInUserAndGroup(long userId, long groupId) {
		return _systemEntryLocalService.countAllInUserAndGroup(userId, groupId);
	}

	@Override
	public int countAllInUserAndGroup(long userId, long groupId, int[] status) {
		return _systemEntryLocalService.countAllInUserAndGroup(
			userId, groupId, status);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _systemEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new system entry with the primary key. Does not add the system entry to the database.
	 *
	 * @param systemEntryId the primary key for the new system entry
	 * @return the new system entry
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
		createSystemEntry(long systemEntryId) {

		return _systemEntryLocalService.createSystemEntry(systemEntryId);
	}

	/**
	 * Delete entry
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry deleteEntry(
			long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _systemEntryLocalService.deleteEntry(primaryKey);
	}

	/**
	 * Delete entry
	 *
	 * @param entry SystemEntry
	 * @return SystemEntry oject
	 * @throws PortalException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry deleteEntry(
			cz.csob.ency.modules.apps.meta.cds.model.SystemEntry entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _systemEntryLocalService.deleteEntry(entry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _systemEntryLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the system entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SystemEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param systemEntryId the primary key of the system entry
	 * @return the system entry that was removed
	 * @throws PortalException if a system entry with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
			deleteSystemEntry(long systemEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _systemEntryLocalService.deleteSystemEntry(systemEntryId);
	}

	/**
	 * Deletes the system entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SystemEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param systemEntry the system entry
	 * @return the system entry that was removed
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
		deleteSystemEntry(
			cz.csob.ency.modules.apps.meta.cds.model.SystemEntry systemEntry) {

		return _systemEntryLocalService.deleteSystemEntry(systemEntry);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _systemEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _systemEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _systemEntryLocalService.dynamicQuery();
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

		return _systemEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.modules.apps.meta.cds.model.impl.SystemEntryModelImpl</code>.
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

		return _systemEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.modules.apps.meta.cds.model.impl.SystemEntryModelImpl</code>.
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

		return _systemEntryLocalService.dynamicQuery(
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

		return _systemEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _systemEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
		fetchEntryByCode(long systemCode) {

		return _systemEntryLocalService.fetchEntryByCode(systemCode);
	}

	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
		fetchSystemEntry(long systemEntryId) {

		return _systemEntryLocalService.fetchSystemEntry(systemEntryId);
	}

	/**
	 * Returns the system entry matching the UUID and group.
	 *
	 * @param uuid the system entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
		fetchSystemEntryByUuidAndGroupId(String uuid, long groupId) {

		return _systemEntryLocalService.fetchSystemEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
		findAllInGroup(long groupId) {

		return _systemEntryLocalService.findAllInGroup(groupId);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
		findAllInGroup(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
					orderByComparator) {

		return _systemEntryLocalService.findAllInGroup(
			groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
		findAllInGroup(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
					orderByComparator,
			int[] status) {

		return _systemEntryLocalService.findAllInGroup(
			groupId, start, end, orderByComparator, status);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
		findAllInGroup(long groupId, int[] status) {

		return _systemEntryLocalService.findAllInGroup(groupId, status);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
		findAllInGroup(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
					orderByComparator) {

		return _systemEntryLocalService.findAllInGroup(
			groupId, orderByComparator);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
		findAllInUser(long userId) {

		return _systemEntryLocalService.findAllInUser(userId);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
		findAllInUser(
			long userId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
					orderByComparator) {

		return _systemEntryLocalService.findAllInUser(
			userId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
		findAllInUser(
			long userId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
					orderByComparator,
			int[] status) {

		return _systemEntryLocalService.findAllInUser(
			userId, start, end, orderByComparator, status);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
		findAllInUser(long userId, int[] status) {

		return _systemEntryLocalService.findAllInUser(userId, status);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
		findAllInUser(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
					orderByComparator) {

		return _systemEntryLocalService.findAllInUser(
			userId, orderByComparator);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
		findAllInUserAndGroup(long userId, long groupId) {

		return _systemEntryLocalService.findAllInUserAndGroup(userId, groupId);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
		findAllInUserAndGroup(
			long userId, long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
					orderByComparator) {

		return _systemEntryLocalService.findAllInUserAndGroup(
			userId, groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
		findAllInUserAndGroup(
			long userId, long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
					orderByComparator,
			int[] status) {

		return _systemEntryLocalService.findAllInUserAndGroup(
			userId, groupId, start, end, orderByComparator, status);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
		findAllInUserAndGroup(long userId, long groupId, int[] status) {

		return _systemEntryLocalService.findAllInUserAndGroup(
			userId, groupId, status);
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
		findAllInUserAndGroup(
			long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
					orderByComparator) {

		return _systemEntryLocalService.findAllInUserAndGroup(
			userId, groupId, orderByComparator);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _systemEntryLocalService.getActionableDynamicQuery();
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
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
		getCompanyEntries(long companyId, int status, int start, int end) {

		return _systemEntryLocalService.getCompanyEntries(
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
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
		getCompanyEntries(
			long companyId, int status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry> obc) {

		return _systemEntryLocalService.getCompanyEntries(
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
		return _systemEntryLocalService.getCompanyEntriesCount(
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

		return _systemEntryLocalService.getDateTimeFromRequest(request, prefix);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _systemEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _systemEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param primaryKey primary key
	 * @param request    PortletRequest
	 * @return SystemEntry Object
	 * @throws PortletException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
			getInitializedSystemEntry(
				long primaryKey, javax.portlet.PortletRequest request)
		throws javax.portlet.PortletException {

		return _systemEntryLocalService.getInitializedSystemEntry(
			primaryKey, request);
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return SystemEntry object
	 * @throws PortletException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry getNewObject(
		long primaryKey) {

		return _systemEntryLocalService.getNewObject(primaryKey);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _systemEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _systemEntryLocalService.getPersistedModel(primaryKeyObj);
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
		return _systemEntryLocalService.getStatusAny();
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
		getSystemEntries() {

		return _systemEntryLocalService.getSystemEntries();
	}

	/**
	 * Returns a range of all the system entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.modules.apps.meta.cds.model.impl.SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of system entries
	 */
	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
		getSystemEntries(int start, int end) {

		return _systemEntryLocalService.getSystemEntries(start, end);
	}

	/**
	 * Returns all the system entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the system entries
	 * @param companyId the primary key of the company
	 * @return the matching system entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
		getSystemEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _systemEntryLocalService.getSystemEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of system entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the system entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching system entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
		getSystemEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
					orderByComparator) {

		return _systemEntryLocalService.getSystemEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of system entries.
	 *
	 * @return the number of system entries
	 */
	@Override
	public int getSystemEntriesCount() {
		return _systemEntryLocalService.getSystemEntriesCount();
	}

	/**
	 * Returns the system entry with the primary key.
	 *
	 * @param systemEntryId the primary key of the system entry
	 * @return the system entry
	 * @throws PortalException if a system entry with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry getSystemEntry(
			long systemEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _systemEntryLocalService.getSystemEntry(systemEntryId);
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
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry getSystemEntry(
			long groupId, String urlTitle)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _systemEntryLocalService.getSystemEntry(groupId, urlTitle);
	}

	/**
	 * Returns the system entry matching the UUID and group.
	 *
	 * @param uuid the system entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching system entry
	 * @throws PortalException if a matching system entry could not be found
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
			getSystemEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _systemEntryLocalService.getSystemEntryByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return SystemEntry Object
	 * @throws PortletException
	 * @throws SystemEntryValidateException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
			getSystemEntryFromRequest(
				long primaryKey, javax.portlet.PortletRequest request)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			SystemEntryValidateException,
			   javax.portlet.PortletException {

		return _systemEntryLocalService.getSystemEntryFromRequest(
			primaryKey, request);
	}

	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
			moveEntryToTrash(long userId, long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _systemEntryLocalService.moveEntryToTrash(userId, entryId);
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
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
			moveEntryToTrash(
				long userId,
				cz.csob.ency.modules.apps.meta.cds.model.SystemEntry entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _systemEntryLocalService.moveEntryToTrash(userId, entry);
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
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
			restoreEntryFromTrash(long userId, long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _systemEntryLocalService.restoreEntryFromTrash(userId, entryId);
	}

	@Override
	public void updateAsset(
			long userId,
			cz.csob.ency.modules.apps.meta.cds.model.SystemEntry entry,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds, Double priority)
		throws com.liferay.portal.kernel.exception.PortalException {

		_systemEntryLocalService.updateAsset(
			userId, entry, assetCategoryIds, assetTagNames, assetLinkEntryIds,
			priority);
	}

	/**
	 * Edit Entry
	 *
	 * @param orgEntry       SystemEntry model
	 * @param serviceContext ServiceContext
	 * @return updated SystemEntry model.
	 * @throws PortalException
	 * @throws SystemEntryValidateException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry updateEntry(
			cz.csob.ency.modules.apps.meta.cds.model.SystemEntry orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.modules.apps.meta.cds.exception.
				   SystemEntryValidateException {

		return _systemEntryLocalService.updateEntry(orgEntry, serviceContext);
	}

	@Override
	public void updateEntryResources(
			cz.csob.ency.modules.apps.meta.cds.model.SystemEntry entry,
			String[] groupPermissions, String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_systemEntryLocalService.updateEntryResources(
			entry, groupPermissions, guestPermissions);
	}

	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _systemEntryLocalService.updateStatus(
			userId, entryId, status, serviceContext, workflowContext);
	}

	/**
	 * Updates the system entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SystemEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param systemEntry the system entry
	 * @return the system entry that was updated
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
		updateSystemEntry(
			cz.csob.ency.modules.apps.meta.cds.model.SystemEntry systemEntry) {

		return _systemEntryLocalService.updateSystemEntry(systemEntry);
	}

	@Override
	public SystemEntryLocalService getWrappedService() {
		return _systemEntryLocalService;
	}

	@Override
	public void setWrappedService(
		SystemEntryLocalService systemEntryLocalService) {

		_systemEntryLocalService = systemEntryLocalService;
	}

	private SystemEntryLocalService _systemEntryLocalService;

}