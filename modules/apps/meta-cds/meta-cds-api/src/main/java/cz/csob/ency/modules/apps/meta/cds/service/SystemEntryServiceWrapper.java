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
 * Provides a wrapper for {@link SystemEntryService}.
 *
 * @author "Miroslav Čermák"
 * @see SystemEntryService
 * @generated
 */
public class SystemEntryServiceWrapper
	implements ServiceWrapper<SystemEntryService>, SystemEntryService {

	public SystemEntryServiceWrapper() {
		this(null);
	}

	public SystemEntryServiceWrapper(SystemEntryService systemEntryService) {
		_systemEntryService = systemEntryService;
	}

	/**
	 * Add Entry
	 *
	 * @param orgEntry       SystemEntry model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception SystemEntryValidateException
	 * @return created SystemEntry model.
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry addEntry(
			cz.csob.ency.modules.apps.meta.cds.model.SystemEntry orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.modules.apps.meta.cds.exception.
				   SystemEntryValidateException {

		return _systemEntryService.addEntry(orgEntry, serviceContext);
	}

	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return SystemEntry
	 * @throws PortalException
	 */
	@Override
	public void deleteEntry(long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		_systemEntryService.deleteEntry(primaryKey);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param primaryKey primary key
	 * @param request    PortletRequest
	 * @return SystemEntry Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
			getInitializedSystemEntry(
				long primaryKey, javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		return _systemEntryService.getInitializedSystemEntry(
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
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry getNewObject(
			long primaryKey,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _systemEntryService.getNewObject(primaryKey, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _systemEntryService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>
		getSystemEntries() {

		return _systemEntryService.getSystemEntries();
	}

	/**
	 * Returns the systementry with the primary key.
	 *
	 * @param primaryKey the primary key of the sample sb
	 * @return the systementry
	 * @throws PortalException if a systementry with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry getSystemEntry(
			long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _systemEntryService.getSystemEntry(primaryKey);
	}

	/**
	 * Returns the systementry
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

		return _systemEntryService.getSystemEntry(groupId, urlTitle);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return SystemEntry Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
			getSystemEntryFromRequest(
				long primaryKey, javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		return _systemEntryService.getSystemEntryFromRequest(
			primaryKey, request);
	}

	/**
	 * Move an entry to the trush can
	 *
	 * @param entryId
	 * @return SystemEntry
	 * @throws PortalException
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
			moveEntryToTrash(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _systemEntryService.moveEntryToTrash(entryId);
	}

	/**
	 * Edit Entry
	 *
	 * @param orgEntry       SystemEntry model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception SystemEntryValidateException
	 * @return updated SystemEntry model.
	 */
	@Override
	public cz.csob.ency.modules.apps.meta.cds.model.SystemEntry updateEntry(
			cz.csob.ency.modules.apps.meta.cds.model.SystemEntry orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.modules.apps.meta.cds.exception.
				   SystemEntryValidateException {

		return _systemEntryService.updateEntry(orgEntry, serviceContext);
	}

	@Override
	public SystemEntryService getWrappedService() {
		return _systemEntryService;
	}

	@Override
	public void setWrappedService(SystemEntryService systemEntryService) {
		_systemEntryService = systemEntryService;
	}

	private SystemEntryService _systemEntryService;

}