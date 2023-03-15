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

import cz.csob.ency.modules.apps.meta.cds.model.TableEntry;

import java.util.List;

/**
 * Provides the remote service utility for TableEntry. This utility wraps
 * <code>cz.csob.ency.modules.apps.meta.cds.service.impl.TableEntryServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author "Miroslav Čermák"
 * @see TableEntryService
 * @generated
 */
public class TableEntryServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>cz.csob.ency.modules.apps.meta.cds.service.impl.TableEntryServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
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
	public static TableEntry addEntry(
			TableEntry orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			TableEntryValidateException,
			   PortalException {

		return getService().addEntry(orgEntry, serviceContext);
	}

	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return TableEntry
	 * @throws PortalException
	 */
	public static void deleteEntry(long primaryKey) throws PortalException {
		getService().deleteEntry(primaryKey);
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
	public static TableEntry getInitializedTableEntry(
			long primaryKey, javax.portlet.PortletRequest request)
		throws javax.portlet.PortletException, PortalException {

		return getService().getInitializedTableEntry(primaryKey, request);
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return ServiceContext serviceContext
	 * @throws PrincipalException
	 * @throws PortletException
	 */
	public static TableEntry getNewObject(
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

	public static List<TableEntry> getSystemTables(
		Long systemEntryId, String type) {

		return getService().getSystemTables(systemEntryId, type);
	}

	/**
	 * Returns the tableentry with the primary key.
	 *
	 * @param primaryKey the primary key of the sample sb
	 * @return the tableentry
	 * @throws PortalException if a tableentry with the primary key could not be found
	 */
	public static TableEntry getTableEntry(long primaryKey)
		throws PortalException {

		return getService().getTableEntry(primaryKey);
	}

	/**
	 * Returns the tableentry
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	public static TableEntry getTableEntry(long groupId, String urlTitle)
		throws PortalException {

		return getService().getTableEntry(groupId, urlTitle);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return TableEntry Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	public static TableEntry getTableEntryFromRequest(
			long primaryKey, javax.portlet.PortletRequest request)
		throws javax.portlet.PortletException, PortalException {

		return getService().getTableEntryFromRequest(primaryKey, request);
	}

	/**
	 * Move an entry to the trush can
	 *
	 * @param entryId
	 * @return TableEntry
	 * @throws PortalException
	 */
	public static TableEntry moveEntryToTrash(long entryId)
		throws PortalException {

		return getService().moveEntryToTrash(entryId);
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
	public static TableEntry updateEntry(
			TableEntry orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws cz.csob.ency.modules.apps.meta.cds.exception.
			TableEntryValidateException,
			   PortalException {

		return getService().updateEntry(orgEntry, serviceContext);
	}

	public static TableEntryService getService() {
		return _service;
	}

	private static volatile TableEntryService _service;

}