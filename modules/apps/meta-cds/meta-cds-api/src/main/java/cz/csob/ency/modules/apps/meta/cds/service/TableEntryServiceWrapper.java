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
 * Provides a wrapper for {@link TableEntryService}.
 *
 * @author "Miroslav Čermák"
 * @see TableEntryService
 * @generated
 */
public class TableEntryServiceWrapper
	implements ServiceWrapper<TableEntryService>, TableEntryService {

	public TableEntryServiceWrapper() {
		this(null);
	}

	public TableEntryServiceWrapper(TableEntryService tableEntryService) {
		_tableEntryService = tableEntryService;
	}

	/**
	 * Add Entry
	 *
	 * @param orgEntry       TableEntry model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception TableEntryValidateException
	 * @return created TableEntry model.
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry addEntry(
			cz.csob.ency.modules.apps.meta.cds.model.TableEntry orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.modules.apps.meta.cds.exception.
				   TableEntryValidateException {

		return _tableEntryService.addEntry(orgEntry, serviceContext);
	}

	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return TableEntry
	 * @throws PortalException
	 */
	@Override
	public void deleteEntry(long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		_tableEntryService.deleteEntry(primaryKey);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param primaryKey primary key
	 * @param request    PortletRequest
	 * @return TableEntry Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry
			getInitializedTableEntry(
				long primaryKey, javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		return _tableEntryService.getInitializedTableEntry(primaryKey, request);
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return ServiceContext serviceContext
	 * @throws PrincipalException
	 * @throws PortletException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry getNewObject(
			long primaryKey,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _tableEntryService.getNewObject(primaryKey, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tableEntryService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.TableEntry>
		getSystemTables(Long systemEntryId, String type) {

		return _tableEntryService.getSystemTables(systemEntryId, type);
	}

	/**
	 * Returns the tableentry with the primary key.
	 *
	 * @param primaryKey the primary key of the sample sb
	 * @return the tableentry
	 * @throws PortalException if a tableentry with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry getTableEntry(
			long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableEntryService.getTableEntry(primaryKey);
	}

	/**
	 * Returns the tableentry
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

		return _tableEntryService.getTableEntry(groupId, urlTitle);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return TableEntry Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry
			getTableEntryFromRequest(
				long primaryKey, javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		return _tableEntryService.getTableEntryFromRequest(primaryKey, request);
	}

	/**
	 * Move an entry to the trush can
	 *
	 * @param entryId
	 * @return TableEntry
	 * @throws PortalException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry moveEntryToTrash(
			long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableEntryService.moveEntryToTrash(entryId);
	}

	/**
	 * Edit Entry
	 *
	 * @param orgEntry       TableEntry model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception TableEntryValidateException
	 * @return updated TableEntry model.
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.TableEntry updateEntry(
			cz.csob.ency.modules.apps.meta.cds.model.TableEntry orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.modules.apps.meta.cds.exception.
				   TableEntryValidateException {

		return _tableEntryService.updateEntry(orgEntry, serviceContext);
	}

	@Override
	public TableEntryService getWrappedService() {
		return _tableEntryService;
	}

	@Override
	public void setWrappedService(TableEntryService tableEntryService) {
		_tableEntryService = tableEntryService;
	}

	private TableEntryService _tableEntryService;

}