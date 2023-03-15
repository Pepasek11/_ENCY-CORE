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

import cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry;

import java.util.List;

/**
 * Provides the remote service utility for ColumnEntry. This utility wraps
 * <code>cz.csob.ency.modules.apps.meta.cds.service.impl.ColumnEntryServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author "Miroslav Čermák"
 * @see ColumnEntryService
 * @generated
 */
public class ColumnEntryServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>cz.csob.ency.modules.apps.meta.cds.service.impl.ColumnEntryServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Add Entry
	 *
	 * @param orgEntry       ColumnEntry model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception ColumnEntryValidateException
	 * @return created ColumnEntry model.
	 */
	public static ColumnEntry addEntry(
			ColumnEntry orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			ColumnEntryValidateException,
			   PortalException {

		return getService().addEntry(orgEntry, serviceContext);
	}

	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return ColumnEntry
	 * @throws PortalException
	 */
	public static void deleteEntry(long primaryKey) throws PortalException {
		getService().deleteEntry(primaryKey);
	}

	/**
	 * Returns the columnentry with the primary key.
	 *
	 * @param primaryKey the primary key of the sample sb
	 * @return the columnentry
	 * @throws PortalException if a columnentry with the primary key could not be found
	 */
	public static ColumnEntry getColumnEntry(long primaryKey)
		throws PortalException {

		return getService().getColumnEntry(primaryKey);
	}

	/**
	 * Returns the columnentry
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	public static ColumnEntry getColumnEntry(long groupId, String urlTitle)
		throws PortalException {

		return getService().getColumnEntry(groupId, urlTitle);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return ColumnEntry Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	public static ColumnEntry getColumnEntryFromRequest(
			long primaryKey, javax.portlet.PortletRequest request)
		throws javax.portlet.PortletException, PortalException {

		return getService().getColumnEntryFromRequest(primaryKey, request);
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
	public static ColumnEntry getInitializedColumnEntry(
			long primaryKey, javax.portlet.PortletRequest request)
		throws javax.portlet.PortletException, PortalException {

		return getService().getInitializedColumnEntry(primaryKey, request);
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return ServiceContext serviceContext
	 * @throws PrincipalException
	 * @throws PortletException
	 */
	public static ColumnEntry getNewObject(
			long primaryKey,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return getService().getNewObject(primaryKey, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static List<ColumnEntry> getTableColumns(long tableEntryId)
		throws PortalException {

		return getService().getTableColumns(tableEntryId);
	}

	/**
	 * Move an entry to the trush can
	 *
	 * @param entryId
	 * @return ColumnEntry
	 * @throws PortalException
	 */
	public static ColumnEntry moveEntryToTrash(long entryId)
		throws PortalException {

		return getService().moveEntryToTrash(entryId);
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
	public static ColumnEntry updateEntry(
			ColumnEntry orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			ColumnEntryValidateException,
			   PortalException {

		return getService().updateEntry(orgEntry, serviceContext);
	}

	public static ColumnEntryService getService() {
		return _service;
	}

	private static volatile ColumnEntryService _service;

}