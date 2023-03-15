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

import cz.csob.ency.modules.apps.meta.cds.exception.ColumnEntryValidateException;
import cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry;

import java.io.Serializable;

import java.util.*;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ColumnEntry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author "Miroslav Čermák"
 * @see ColumnEntryLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ColumnEntryLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>cz.csob.ency.modules.apps.meta.cds.service.impl.ColumnEntryLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the column entry local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ColumnEntryLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public ColumnEntry addColumnEntry(ColumnEntry columnEntry);

	/**
	 * Add Entry
	 *
	 * @param orgEntry       ColumnEntry model
	 * @param serviceContext ServiceContext
	 * @return created ColumnEntry model.
	 * @throws PortalException
	 * @throws ColumnEntryValidateException
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ColumnEntry addEntry(
			ColumnEntry orgEntry, ServiceContext serviceContext)
		throws ColumnEntryValidateException, PortalException;

	public void addEntryResources(
			ColumnEntry entry, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException;

	public void addEntryResources(
			ColumnEntry entry, ModelPermissions modelPermissions)
		throws PortalException;

	public void addEntryResources(
			long entryId, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException;

	public void addEntryResources(
			long entryId, ModelPermissions modelPermissions)
		throws PortalException;

	public ColumnEntry addOrUpdateFromRow(
			java.util.Map<String, Object> row, ServiceContext serviceContext)
		throws PortalException;

	public ColumnEntry addOrUpdateFromRow(
			java.util.Map<String, Object> row, ServiceContext serviceContext,
			boolean validate)
		throws PortalException;

	public int countAllInGroup(long groupId);

	public int countAllInGroup(long groupId, int[] status);

	public int countAllInUser(long userId);

	public int countAllInUser(long userId, int[] status);

	public int countAllInUserAndGroup(long userId, long groupId);

	public int countAllInUserAndGroup(long userId, long groupId, int[] status);

	/**
	 * Creates a new column entry with the primary key. Does not add the column entry to the database.
	 *
	 * @param columnEntryId the primary key for the new column entry
	 * @return the new column entry
	 */
	@Transactional(enabled = false)
	public ColumnEntry createColumnEntry(long columnEntryId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public ColumnEntry deleteColumnEntry(ColumnEntry columnEntry);

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
	@Indexable(type = IndexableType.DELETE)
	public ColumnEntry deleteColumnEntry(long columnEntryId)
		throws PortalException;

	/**
	 * Delete entry
	 *
	 * @param entry ColumnEntry
	 * @return ColumnEntry oject
	 * @throws PortalException
	 */
	@Indexable(type = IndexableType.DELETE)
	@SystemEvent(type = SystemEventConstants.TYPE_DELETE)
	public ColumnEntry deleteEntry(ColumnEntry entry) throws PortalException;

	/**
	 * Delete entry
	 */
	public ColumnEntry deleteEntry(long primaryKey) throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.modules.apps.meta.cds.model.impl.ColumnEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.modules.apps.meta.cds.model.impl.ColumnEntryModelImpl</code>.
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
	public ColumnEntry fetchColumnEntry(long columnEntryId);

	/**
	 * Returns the column entry matching the UUID and group.
	 *
	 * @param uuid the column entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ColumnEntry fetchColumnEntryByUuidAndGroupId(
		String uuid, long groupId);

	public List<ColumnEntry> findAllInGroup(long groupId);

	public List<ColumnEntry> findAllInGroup(
		long groupId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator);

	public List<ColumnEntry> findAllInGroup(
		long groupId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator, int[] status);

	public List<ColumnEntry> findAllInGroup(long groupId, int[] status);

	public List<ColumnEntry> findAllInGroup(
		long groupId, OrderByComparator<ColumnEntry> orderByComparator);

	public List<ColumnEntry> findAllInTable(long tableEntryId);

	public List<ColumnEntry> findAllInUser(long userId);

	public List<ColumnEntry> findAllInUser(
		long userId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator);

	public List<ColumnEntry> findAllInUser(
		long userId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator, int[] status);

	public List<ColumnEntry> findAllInUser(long userId, int[] status);

	public List<ColumnEntry> findAllInUser(
		long userId, OrderByComparator<ColumnEntry> orderByComparator);

	public List<ColumnEntry> findAllInUserAndGroup(long userId, long groupId);

	public List<ColumnEntry> findAllInUserAndGroup(
		long userId, long groupId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator);

	public List<ColumnEntry> findAllInUserAndGroup(
		long userId, long groupId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator, int[] status);

	public List<ColumnEntry> findAllInUserAndGroup(
		long userId, long groupId, int[] status);

	public List<ColumnEntry> findAllInUserAndGroup(
		long userId, long groupId,
		OrderByComparator<ColumnEntry> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ColumnEntry> getColumnEntries(int start, int end);

	/**
	 * Returns all the column entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the column entries
	 * @param companyId the primary key of the company
	 * @return the matching column entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ColumnEntry> getColumnEntriesByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ColumnEntry> getColumnEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator);

	/**
	 * Returns the number of column entries.
	 *
	 * @return the number of column entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getColumnEntriesCount();

	/**
	 * Returns the column entry with the primary key.
	 *
	 * @param columnEntryId the primary key of the column entry
	 * @return the column entry
	 * @throws PortalException if a column entry with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ColumnEntry getColumnEntry(long columnEntryId)
		throws PortalException;

	/**
	 * Get Entity
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ColumnEntry getColumnEntry(long groupId, String urlTitle)
		throws PortalException;

	/**
	 * Returns the column entry matching the UUID and group.
	 *
	 * @param uuid the column entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching column entry
	 * @throws PortalException if a matching column entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ColumnEntry getColumnEntryByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return ColumnEntry Object
	 * @throws PortletException
	 * @throws ColumnEntryValidateException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ColumnEntry getColumnEntryFromRequest(
			long primaryKey, PortletRequest request)
		throws ColumnEntryValidateException, PortletException;

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
	public List<ColumnEntry> getCompanyEntries(
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
	public List<ColumnEntry> getCompanyEntries(
		long companyId, int status, int start, int end,
		OrderByComparator<ColumnEntry> obc);

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
	 * @return ColumnEntry Object
	 * @throws PortletException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ColumnEntry getInitializedColumnEntry(
			long primaryKey, PortletRequest request)
		throws PortletException;

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return ColumnEntry object
	 * @throws PortletException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ColumnEntry getNewObject(long primaryKey);

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
	public ColumnEntry moveEntryToTrash(long userId, ColumnEntry entry)
		throws PortalException;

	public ColumnEntry moveEntryToTrash(long userId, long entryId)
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
	public ColumnEntry restoreEntryFromTrash(long userId, long entryId)
		throws PortalException;

	public void updateAsset(
			long userId, ColumnEntry entry, long[] assetCategoryIds,
			String[] assetTagNames, long[] assetLinkEntryIds, Double priority)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public ColumnEntry updateColumnEntry(ColumnEntry columnEntry);

	/**
	 * Edit Entry
	 *
	 * @param orgEntry       ColumnEntry model
	 * @param serviceContext ServiceContext
	 * @return updated ColumnEntry model.
	 * @throws PortalException
	 * @throws ColumnEntryValidateException
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ColumnEntry updateEntry(
			ColumnEntry orgEntry, ServiceContext serviceContext)
		throws ColumnEntryValidateException, PortalException;

	public void updateEntryResources(
			ColumnEntry entry, String[] groupPermissions,
			String[] guestPermissions)
		throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	public ColumnEntry updateStatus(
			long userId, long entryId, int status,
			ServiceContext serviceContext,
			java.util.Map<String, Serializable> workflowContext)
		throws PortalException;

}