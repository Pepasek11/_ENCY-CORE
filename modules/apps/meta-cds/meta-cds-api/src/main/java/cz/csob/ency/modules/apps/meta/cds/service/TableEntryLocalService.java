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

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.permission.ModelPermissions;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.util.OrderByComparator;

import cz.csob.ency.modules.apps.meta.cds.exception.TableEntryValidateException;
import cz.csob.ency.modules.apps.meta.cds.model.TableEntry;

import java.io.Serializable;

import java.util.*;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for TableEntry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author "Miroslav Čermák"
 * @see TableEntryLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TableEntryLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>cz.csob.ency.modules.apps.meta.cds.service.impl.TableEntryLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the table entry local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link TableEntryLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Add Entry
	 *
	 * @param orgEntry       TableEntry model
	 * @param serviceContext ServiceContext
	 * @return created TableEntry model.
	 * @throws PortalException
	 * @throws TableEntryValidateException
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TableEntry addEntry(
			TableEntry orgEntry, ServiceContext serviceContext)
		throws PortalException, TableEntryValidateException;

	public void addEntryResources(
			long entryId, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException;

	public void addEntryResources(
			long entryId, ModelPermissions modelPermissions)
		throws PortalException;

	public void addEntryResources(
			TableEntry entry, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException;

	public void addEntryResources(
			TableEntry entry, ModelPermissions modelPermissions)
		throws PortalException;

	public TableEntry addOrUpdateFromRow(
			java.util.Map<String, Object> row, ServiceContext serviceContext)
		throws PortalException;

	public TableEntry addOrUpdateFromRow(
			java.util.Map<String, Object> row, ServiceContext serviceContext,
			boolean validate)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public TableEntry addTableEntry(TableEntry tableEntry);

	public int countAllInGroup(long groupId);

	public int countAllInGroup(long groupId, int[] status);

	public int countAllInUser(long userId);

	public int countAllInUser(long userId, int[] status);

	public int countAllInUserAndGroup(long userId, long groupId);

	public int countAllInUserAndGroup(long userId, long groupId, int[] status);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new table entry with the primary key. Does not add the table entry to the database.
	 *
	 * @param tableEntryId the primary key for the new table entry
	 * @return the new table entry
	 */
	@Transactional(enabled = false)
	public TableEntry createTableEntry(long tableEntryId);

	/**
	 * Delete entry
	 */
	public TableEntry deleteEntry(long primaryKey) throws PortalException;

	/**
	 * Delete entry
	 *
	 * @param entry TableEntry
	 * @return TableEntry oject
	 * @throws PortalException
	 */
	@Indexable(type = IndexableType.DELETE)
	@SystemEvent(type = SystemEventConstants.TYPE_DELETE)
	public TableEntry deleteEntry(TableEntry entry) throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public TableEntry deleteTableEntry(long tableEntryId)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public TableEntry deleteTableEntry(TableEntry tableEntry);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TableEntry fetchEntryByTableFullName(String tableFullName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TableEntry fetchTableEntry(long tableEntryId);

	/**
	 * Returns the table entry matching the UUID and group.
	 *
	 * @param uuid the table entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TableEntry fetchTableEntryByUuidAndGroupId(
		String uuid, long groupId);

	public List<TableEntry> findAllInGroup(long groupId);

	public List<TableEntry> findAllInGroup(
		long groupId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator);

	public List<TableEntry> findAllInGroup(
		long groupId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator, int[] status);

	public List<TableEntry> findAllInGroup(long groupId, int[] status);

	public List<TableEntry> findAllInGroup(
		long groupId, OrderByComparator<TableEntry> orderByComparator);

	public List<TableEntry> findAllInSystem(long systemEntryId);

	public List<TableEntry> findAllInSystemDatabase(
		long systemEntryId, String tableDatabase);

	public List<TableEntry> findAllInSystemDatabase(
		long systemEntryId, String[] tableDatabase);

	public List<TableEntry> findAllInSystemType(
		long systemEntryId, String tableType);

	public List<TableEntry> findAllInSystemType(
		long systemEntryId, String[] tableType);

	public List<TableEntry> findAllInUser(long userId);

	public List<TableEntry> findAllInUser(
		long userId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator);

	public List<TableEntry> findAllInUser(
		long userId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator, int[] status);

	public List<TableEntry> findAllInUser(long userId, int[] status);

	public List<TableEntry> findAllInUser(
		long userId, OrderByComparator<TableEntry> orderByComparator);

	public List<TableEntry> findAllInUserAndGroup(long userId, long groupId);

	public List<TableEntry> findAllInUserAndGroup(
		long userId, long groupId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator);

	public List<TableEntry> findAllInUserAndGroup(
		long userId, long groupId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator, int[] status);

	public List<TableEntry> findAllInUserAndGroup(
		long userId, long groupId, int[] status);

	public List<TableEntry> findAllInUserAndGroup(
		long userId, long groupId,
		OrderByComparator<TableEntry> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TableEntry> getCompanyEntries(
		long companyId, int status, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TableEntry> getCompanyEntries(
		long companyId, int status, int start, int end,
		OrderByComparator<TableEntry> obc);

	/**
	 * Get Company entries counts
	 *
	 * @param companyId
	 * @param status
	 * @return
	 * @throws SystemException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCompanyEntriesCount(long companyId, int status);

	/**
	 * Converte Date Time into Date()
	 *
	 * @param request PortletRequest
	 * @param prefix  Prefix of the parameter
	 * @return Date object
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Date getDateTimeFromRequest(
		PortletRequest request, String prefix);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Populate Model with values from a form
	 *
	 * @param primaryKey primary key
	 * @param request    PortletRequest
	 * @return TableEntry Object
	 * @throws PortletException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TableEntry getInitializedTableEntry(
			long primaryKey, PortletRequest request)
		throws PortletException;

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return TableEntry object
	 * @throws PortletException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TableEntry getNewObject(long primaryKey);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Get STATUS_ANY for DB
	 * <p>
	 * This is equivalent of WorkflowConstants.STATUS_ANY
	 *
	 * @return All statuses for Workflow
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int[] getStatusAny();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TableEntry> getSystemTables(Long systemId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TableEntry> getSystemTables(Long systemEntryId, String type);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TableEntry> getTableEntries(int start, int end);

	/**
	 * Returns all the table entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the table entries
	 * @param companyId the primary key of the company
	 * @return the matching table entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TableEntry> getTableEntriesByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TableEntry> getTableEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator);

	/**
	 * Returns the number of table entries.
	 *
	 * @return the number of table entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTableEntriesCount();

	/**
	 * Returns the table entry with the primary key.
	 *
	 * @param tableEntryId the primary key of the table entry
	 * @return the table entry
	 * @throws PortalException if a table entry with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TableEntry getTableEntry(long tableEntryId) throws PortalException;

	/**
	 * Get Entity
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TableEntry getTableEntry(long groupId, String urlTitle)
		throws PortalException;

	/**
	 * Returns the table entry matching the UUID and group.
	 *
	 * @param uuid the table entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching table entry
	 * @throws PortalException if a matching table entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TableEntry getTableEntryByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return TableEntry Object
	 * @throws PortletException
	 * @throws TableEntryValidateException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TableEntry getTableEntryFromRequest(
			long primaryKey, PortletRequest request)
		throws PortletException, TableEntryValidateException;

	public TableEntry moveEntryToTrash(long userId, long entryId)
		throws PortalException;

	/**
	 * Moves the entry to the recycle bin.
	 * <p>
	 * Social activity counters for this entry get disabled.
	 *
	 * @param userId the primary key of the user moving the entry
	 * @param entry  the entry to be moved
	 * @return the moved entry
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TableEntry moveEntryToTrash(long userId, TableEntry entry)
		throws PortalException;

	/**
	 * Restores the entry with the ID from the recycle bin. Social activity counters
	 * for this entry get activated.
	 *
	 * @param userId  the primary key of the user restoring the entry
	 * @param entryId the primary key of the entry to be restored
	 * @return the restored entry from the recycle bin
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TableEntry restoreEntryFromTrash(long userId, long entryId)
		throws PortalException;

	public void updateAsset(
			long userId, TableEntry entry, long[] assetCategoryIds,
			String[] assetTagNames, long[] assetLinkEntryIds, Double priority)
		throws PortalException;

	/**
	 * Edit Entry
	 *
	 * @param orgEntry       TableEntry model
	 * @param serviceContext ServiceContext
	 * @return updated TableEntry model.
	 * @throws PortalException
	 * @throws TableEntryValidateException
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TableEntry updateEntry(
			TableEntry orgEntry, ServiceContext serviceContext)
		throws PortalException, TableEntryValidateException;

	public void updateEntryResources(
			TableEntry entry, String[] groupPermissions,
			String[] guestPermissions)
		throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	public TableEntry updateStatus(
			long userId, long entryId, int status,
			ServiceContext serviceContext,
			java.util.Map<String, Serializable> workflowContext)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public TableEntry updateTableEntry(TableEntry tableEntry);

}