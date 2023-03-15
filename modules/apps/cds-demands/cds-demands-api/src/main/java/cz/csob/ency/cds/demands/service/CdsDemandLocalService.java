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

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.model.Repository;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.permission.ModelPermissions;
import com.liferay.portal.kernel.service.version.VersionService;
import com.liferay.portal.kernel.service.version.VersionServiceListener;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.util.OrderByComparator;

import cz.csob.ency.cds.demands.exception.CdsDemandValidateException;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.cds.demands.model.CdsDemandVersion;

import java.io.Serializable;

import java.util.*;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for CdsDemand. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Miroslav Čermák
 * @see CdsDemandLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CdsDemandLocalService
	extends BaseLocalService, PersistedModelLocalService,
			VersionService<CdsDemand, CdsDemandVersion> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>cz.csob.ency.cds.demands.service.impl.CdsDemandLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the cds demand local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link CdsDemandLocalServiceUtil} if injection and service tracking are not available.
	 */

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
	@Indexable(type = IndexableType.REINDEX)
	public CdsDemand addCdsDemand(CdsDemand cdsDemand);

	/**
	 * Add Entry
	 *
	 * @param orgEntry       CdsDemand model
	 * @param serviceContext ServiceContext
	 * @return created CdsDemand model.
	 * @throws PortalException
	 * @throws CdsDemandValidateException
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CdsDemand addEntry(CdsDemand orgEntry, ServiceContext serviceContext)
		throws CdsDemandValidateException, PortalException;

	public void addEntryResources(
			CdsDemand entry, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException;

	public void addEntryResources(
			CdsDemand entry, ModelPermissions modelPermissions)
		throws PortalException;

	public void addEntryResources(
			long entryId, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException;

	public void addEntryResources(
			long entryId, ModelPermissions modelPermissions)
		throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CdsDemand checkout(CdsDemand publishedCdsDemand, int version)
		throws PortalException;

	public int countAll();

	public int countAllInUser(long userId);

	/**
	 * Creates a new cds demand. Does not add the cds demand to the database.
	 *
	 * @return the new cds demand
	 */
	@Override
	@Transactional(enabled = false)
	public CdsDemand create();

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(enabled = false)
	public CdsDemand createWithId(long primaryKey);

	@Indexable(type = IndexableType.DELETE)
	@Override
	public CdsDemand delete(CdsDemand publishedCdsDemand)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public CdsDemand deleteCdsDemand(CdsDemand cdsDemand);

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
	@Indexable(type = IndexableType.DELETE)
	public CdsDemand deleteCdsDemand(long demandId) throws PortalException;

	@Indexable(type = IndexableType.DELETE)
	@Override
	public CdsDemand deleteDraft(CdsDemand draftCdsDemand)
		throws PortalException;

	/**
	 * Delete entry
	 *
	 * @param entry CdsDemand
	 * @return CdsDemand oject
	 * @throws PortalException
	 */
	@Indexable(type = IndexableType.DELETE)
	@SystemEvent(type = SystemEventConstants.TYPE_DELETE)
	public CdsDemand deleteEntry(CdsDemand entry) throws PortalException;

	/**
	 * Delete entry
	 */
	public CdsDemand deleteEntry(long primaryKey) throws PortalException;

	/**
	 * Delete entry
	 */
	@Transactional
	public CdsDemand deleteEntryFull(CdsDemand entry) throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	public CdsDemandVersion deleteVersion(CdsDemandVersion cdsDemandVersion)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.cds.demands.model.impl.CdsDemandModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.cds.demands.model.impl.CdsDemandModelImpl</code>.
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
	public Folder fetchAttachmentsFolder(
		long userId, long groupId, long entryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CdsDemand fetchCdsDemand(long demandId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CdsDemand fetchCdsDemand(String uuid);

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CdsDemand fetchDraft(CdsDemand cdsDemand);

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CdsDemand fetchDraft(long primaryKey);

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CdsDemandVersion fetchLatestVersion(CdsDemand cdsDemand);

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CdsDemand fetchPublished(CdsDemand cdsDemand);

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CdsDemand fetchPublished(long primaryKey);

	public List<CdsDemand> findAll();

	public List<CdsDemand> findAll(
		int start, int end, OrderByComparator<CdsDemand> orderByComparator);

	public List<CdsDemand> findAll(
		long groupId, OrderByComparator<CdsDemand> orderByComparator);

	public List<CdsDemand> findAllInUser(long userId);

	public List<CdsDemand> findAllInUser(
		long userId, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator);

	public List<CdsDemand> findAllInUser(
		long userId, OrderByComparator<CdsDemand> orderByComparator);

	public List<CdsDemand> findDomainDemands(
		long userId, Long[] domainId, boolean getLongClosed,
		boolean includeOthersDrafts);

	public List<CdsDemand> findUserActionRequiredDemands(
		long userId, long groupId);

	public List<CdsDemand> findUserDemands(long userId, boolean getLongClosed);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Folder getAttachmentsFolder(long userId, long groupId, long entryId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getAttachmentsFolderId(long userId, long groupId, long entryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getAttachmentsFolderName(long entryId);

	/**
	 * Returns the cds demand with the primary key.
	 *
	 * @param demandId the primary key of the cds demand
	 * @return the cds demand
	 * @throws PortalException if a cds demand with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CdsDemand getCdsDemand(long demandId) throws PortalException;

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return CdsDemand Object
	 * @throws PortletException
	 * @throws CdsDemandValidateException
	 * @todo bez primaryKey p[arametru?->Nacitat ho z requestu?
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CdsDemand getCdsDemandFromRequest(
			long primaryKey, PortletRequest request)
		throws CdsDemandValidateException, PortletException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CdsDemand> getCdsDemands(int start, int end);

	/**
	 * Returns the number of cds demands.
	 *
	 * @return the number of cds demands
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCdsDemandsCount();

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

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CdsDemand getDraft(CdsDemand cdsDemand) throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CdsDemand getDraft(long primaryKey) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getFormattedUserName(User user);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CdsDemand getInitializedCdsDemand(long id, ServiceContext sc);

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return CdsDemand Object
	 * @throws PortletException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CdsDemand getInitializedCdsDemand(PortletRequest request)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CdsDemand getInitializedCdsDemand(ServiceContext sc);

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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Repository getRepository(long groupId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getRepositoryId(long groupId);

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
	public long getUserDomainId(User user);

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CdsDemandVersion getVersion(CdsDemand cdsDemand, int version)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CdsDemandVersion> getVersions(CdsDemand cdsDemand);

	@Indexable(type = IndexableType.REINDEX)
	public CdsDemand importEntry(CdsDemand entry, ServiceContext serviceContext)
		throws CdsDemandValidateException, PortalException;

	@Indexable(type = IndexableType.REINDEX)
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CdsDemand publishDraft(CdsDemand draftCdsDemand)
		throws PortalException;

	@Override
	public void registerListener(
		VersionServiceListener<CdsDemand, CdsDemandVersion>
			versionServiceListener);

	@Override
	public void unregisterListener(
		VersionServiceListener<CdsDemand, CdsDemandVersion>
			versionServiceListener);

	public void updateAsset(
			long userId, CdsDemand entry, long[] assetCategoryIds,
			String[] assetTagNames, long[] assetLinkEntryIds, Double priority)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public CdsDemand updateCdsDemand(CdsDemand draftCdsDemand)
		throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CdsDemand updateDraft(CdsDemand draftCdsDemand)
		throws PortalException;

	/**
	 * Edit Entry
	 *
	 * @param orgEntry       CdsDemand model
	 * @param serviceContext ServiceContext
	 * @return updated CdsDemand model.
	 * @throws PortalException
	 * @throws CdsDemandValidateException
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CdsDemand updateEntry(
			CdsDemand orgEntry, ServiceContext serviceContext)
		throws CdsDemandValidateException, PortalException;

	public void updateEntryResources(
			CdsDemand entry, String[] groupPermissions,
			String[] guestPermissions)
		throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	@Transactional(propagation = Propagation.REQUIRED)
	public CdsDemand updateEntryVersion(CdsDemand cdsDemand)
		throws PortalException;

}