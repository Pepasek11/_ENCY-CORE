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
 * Provides a wrapper for {@link ColumnEntryService}.
 *
 * @author "Miroslav Čermák"
 * @see ColumnEntryService
 * @generated
 */
public class ColumnEntryServiceWrapper
	implements ColumnEntryService, ServiceWrapper<ColumnEntryService> {

	public ColumnEntryServiceWrapper() {
		this(null);
	}

	public ColumnEntryServiceWrapper(ColumnEntryService columnEntryService) {
		_columnEntryService = columnEntryService;
	}

	/**
	 * Add Entry
	 *
	 * @param orgEntry       ColumnEntry model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception ColumnEntryValidateException
	 * @return created ColumnEntry model.
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry addEntry(
			cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.modules.apps.meta.cds.exception.
				   ColumnEntryValidateException {

		return _columnEntryService.addEntry(orgEntry, serviceContext);
	}

	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return ColumnEntry
	 * @throws PortalException
	 */
	@Override
	public void deleteEntry(long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		_columnEntryService.deleteEntry(primaryKey);
	}

	/**
	 * Returns the columnentry with the primary key.
	 *
	 * @param primaryKey the primary key of the sample sb
	 * @return the columnentry
	 * @throws PortalException if a columnentry with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry getColumnEntry(
			long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _columnEntryService.getColumnEntry(primaryKey);
	}

	/**
	 * Returns the columnentry
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

		return _columnEntryService.getColumnEntry(groupId, urlTitle);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return ColumnEntry Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
			getColumnEntryFromRequest(
				long primaryKey, javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		return _columnEntryService.getColumnEntryFromRequest(
			primaryKey, request);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param primaryKey primary key
	 * @param request    PortletRequest
	 * @return ColumnEntry Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
			getInitializedColumnEntry(
				long primaryKey, javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		return _columnEntryService.getInitializedColumnEntry(
			primaryKey, request);
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
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry getNewObject(
			long primaryKey,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _columnEntryService.getNewObject(primaryKey, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _columnEntryService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>
			getTableColumns(long tableEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _columnEntryService.getTableColumns(tableEntryId);
	}

	/**
	 * Move an entry to the trush can
	 *
	 * @param entryId
	 * @return ColumnEntry
	 * @throws PortalException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
			moveEntryToTrash(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _columnEntryService.moveEntryToTrash(entryId);
	}

	/**
	 * Edit Entry
	 *
	 * @param orgEntry       ColumnEntry model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception ColumnEntryValidateException
	 * @return updated ColumnEntry model.
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry updateEntry(
			cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.modules.apps.meta.cds.exception.
				   ColumnEntryValidateException {

		return _columnEntryService.updateEntry(orgEntry, serviceContext);
	}

	@Override
	public ColumnEntryService getWrappedService() {
		return _columnEntryService;
	}

	@Override
	public void setWrappedService(ColumnEntryService columnEntryService) {
		_columnEntryService = columnEntryService;
	}

	private ColumnEntryService _columnEntryService;

}