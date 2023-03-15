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
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.permission.ModelPermissions;
import com.liferay.portal.kernel.service.version.VersionService;
import com.liferay.portal.kernel.service.version.VersionServiceListener;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.util.OrderByComparator;

import cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.entry.model.E3EntryVersion;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for E3Entry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see E3EntryLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface E3EntryLocalService
	extends BaseLocalService, PersistedModelLocalService,
			VersionService<E3Entry, E3EntryVersion> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>cz.csob.ency.modules.e3.entry.service.impl.E3EntryLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the e3 entry local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link E3EntryLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public E3Entry addE3Entry(E3Entry e3Entry);

	public E3Entry addEntry(
			E3Entry entry, boolean publish, ServiceContext serviceContext)
		throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	public E3Entry addEntry(
			long userId, E3Entry entry, boolean publish,
			ServiceContext serviceContext)
		throws PortalException;

	public void addEntryResources(
			E3Entry entry, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException;

	public void addEntryResources(
			E3Entry entry, ModelPermissions modelPermissions)
		throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public E3Entry checkout(E3Entry publishedE3Entry, int version)
		throws PortalException;

	/**
	 * Creates a new e3 entry. Does not add the e3 entry to the database.
	 *
	 * @return the new e3 entry
	 */
	@Override
	@Transactional(enabled = false)
	public E3Entry create();

	/**
	 * Creates a new draft e3 entry for given app class. Does not add the e3 entry to the database.
	 *
	 * @return the new draft e3 entry
	 */
	@Transactional(enabled = false)
	public E3Entry createEntry(String appClass);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Indexable(type = IndexableType.DELETE)
	@Override
	public E3Entry delete(E3Entry publishedE3Entry) throws PortalException;

	@Indexable(type = IndexableType.DELETE)
	@Override
	public E3Entry deleteDraft(E3Entry draftE3Entry) throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public E3Entry deleteE3Entry(E3Entry e3Entry);

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
	@Indexable(type = IndexableType.DELETE)
	public E3Entry deleteE3Entry(long entryId) throws PortalException;

	@Indexable(type = IndexableType.DELETE)
	@Transactional(enabled = true)
	public E3Entry deleteEntry(E3Entry entry, ServiceContext serviceContext)
		throws PortalException;

	@Indexable(type = IndexableType.DELETE)
	public E3Entry deleteEntry(long entryId) throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	public E3EntryVersion deleteVersion(E3EntryVersion e3EntryVersion)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.modules.e3.entry.model.impl.E3EntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.modules.e3.entry.model.impl.E3EntryModelImpl</code>.
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

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public E3Entry fetchDraft(E3Entry e3Entry);

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public E3Entry fetchDraft(long primaryKey);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public E3Entry fetchE3Entry(long entryId);

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public E3EntryVersion fetchLatestVersion(E3Entry e3Entry);

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public E3Entry fetchPublished(E3Entry e3Entry);

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public E3Entry fetchPublished(long primaryKey);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public E3Entry getDraft(E3Entry e3Entry) throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public E3Entry getDraft(long primaryKey) throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<E3Entry> getE3Entries(int start, int end);

	/**
	 * Returns the number of e3 entries.
	 *
	 * @return the number of e3 entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getE3EntriesCount();

	/**
	 * Returns the e3 entry with the primary key.
	 *
	 * @param entryId the primary key of the e3 entry
	 * @return the e3 entry
	 * @throws PortalException if a e3 entry with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public E3Entry getE3Entry(long entryId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public E3Entry getEntry(long entryId) throws NoSuchE3EntryException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getEntryPortletName(E3Entry entry) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getMaxEntryVersion(long id);

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

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public E3EntryVersion getVersion(E3Entry e3Entry, int version)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<E3EntryVersion> getVersions(E3Entry e3Entry);

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public E3Entry publishDraft(E3Entry draftE3Entry) throws PortalException;

	@Override
	public void registerListener(
		VersionServiceListener<E3Entry, E3EntryVersion> versionServiceListener);

	@Override
	public void unregisterListener(
		VersionServiceListener<E3Entry, E3EntryVersion> versionServiceListener);

	public void updateAsset(
			long userId, E3Entry entry, long[] assetCategoryIds,
			String[] assetTagNames, long[] assetLinkEntryIds, Double priority)
		throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public E3Entry updateDraft(E3Entry draftE3Entry) throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public E3Entry updateE3Entry(E3Entry draftE3Entry) throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	public E3Entry updateEntry(
			E3Entry entry, boolean publish, ServiceContext serviceContext)
		throws PortalException;

}