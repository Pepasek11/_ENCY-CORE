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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.jsonwebservice.JSONWebServiceMode;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import cz.csob.ency.modules.apps.meta.cds.exception.TableEntryValidateException;
import cz.csob.ency.modules.apps.meta.cds.model.TableEntry;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for TableEntry. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author "Miroslav Čermák"
 * @see TableEntryServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TableEntryService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>cz.csob.ency.modules.apps.meta.cds.service.impl.TableEntryServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the table entry remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link TableEntryServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Add Entry
	 *
	 * @param orgEntry       TableEntry model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception TableEntryValidateException
	 * @return created TableEntry model.
	 */
	@JSONWebService(mode = JSONWebServiceMode.IGNORE)
	public TableEntry addEntry(
			TableEntry orgEntry, ServiceContext serviceContext)
		throws PortalException, TableEntryValidateException;

	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return TableEntry
	 * @throws PortalException
	 */
	@JSONWebService(mode = JSONWebServiceMode.IGNORE)
	public void deleteEntry(long primaryKey) throws PortalException;

	/**
	 * Populate Model with values from a form
	 *
	 * @param primaryKey primary key
	 * @param request    PortletRequest
	 * @return TableEntry Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	@JSONWebService(mode = JSONWebServiceMode.IGNORE)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TableEntry getInitializedTableEntry(
			long primaryKey, PortletRequest request)
		throws PortalException, PortletException;

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return ServiceContext serviceContext
	 * @throws PrincipalException
	 * @throws PortletException
	 */
	@JSONWebService(mode = JSONWebServiceMode.IGNORE)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TableEntry getNewObject(
			long primaryKey, ServiceContext serviceContext)
		throws PrincipalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TableEntry> getSystemTables(Long systemEntryId, String type);

	/**
	 * Returns the tableentry with the primary key.
	 *
	 * @param primaryKey the primary key of the sample sb
	 * @return the tableentry
	 * @throws PortalException if a tableentry with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TableEntry getTableEntry(long primaryKey) throws PortalException;

	/**
	 * Returns the tableentry
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	@JSONWebService(mode = JSONWebServiceMode.IGNORE)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TableEntry getTableEntry(long groupId, String urlTitle)
		throws PortalException;

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return TableEntry Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	@JSONWebService(mode = JSONWebServiceMode.IGNORE)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TableEntry getTableEntryFromRequest(
			long primaryKey, PortletRequest request)
		throws PortalException, PortletException;

	/**
	 * Move an entry to the trush can
	 *
	 * @param entryId
	 * @return TableEntry
	 * @throws PortalException
	 */
	@JSONWebService(mode = JSONWebServiceMode.IGNORE)
	public TableEntry moveEntryToTrash(long entryId) throws PortalException;

	/**
	 * Edit Entry
	 *
	 * @param orgEntry       TableEntry model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception TableEntryValidateException
	 * @return updated TableEntry model.
	 */
	@JSONWebService(mode = JSONWebServiceMode.IGNORE)
	public TableEntry updateEntry(
			TableEntry orgEntry, ServiceContext serviceContext)
		throws PortalException, TableEntryValidateException;

}