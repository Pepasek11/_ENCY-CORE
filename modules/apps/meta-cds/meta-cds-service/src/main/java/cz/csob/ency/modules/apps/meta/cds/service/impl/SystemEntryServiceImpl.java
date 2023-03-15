// 
/*   */ 
/**
*  Copyright (C) 2021 Yasuyuki Takeo All rights reserved.
*
*  This program is free software: you can redistribute it and/or modify
*  it under the terms of the GNU Lesser General Public License as published by
*  the Free Software Foundation, either version 3 of the License, or
*  (at your option) any later version.
*
*  This program is distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
*  GNU Lesser General Public License for more details.
*/
/*  */ 


package cz.csob.ency.modules.apps.meta.cds.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.jsonwebservice.JSONWebServiceMode;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import cz.csob.ency.modules.apps.meta.cds.constants.SystemEntryConstants;
import cz.csob.ency.modules.apps.meta.cds.exception.SystemEntryValidateException;
import cz.csob.ency.modules.apps.meta.cds.model.SystemEntry;
import cz.csob.ency.modules.apps.meta.cds.service.base.SystemEntryServiceBaseImpl;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

import java.util.List;
import java.util.Map;

/**
 * The implementation of the SystemEntry remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>cz.csob.ency.modules.apps.meta.cds.service.SystemEntryService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Miroslav Čermák
 * @see SystemEntryServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=metacds",
		"json.web.service.context.path=SystemEntry"
	},
	service = AopService.class
)
public class SystemEntryServiceImpl extends SystemEntryServiceBaseImpl {
	private static final Log _log = LogFactoryUtil.getLog(
			SystemEntryServiceImpl.class);
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
	@JSONWebService(mode = JSONWebServiceMode.IGNORE)
	public SystemEntry addEntry(SystemEntry orgEntry, ServiceContext serviceContext)
		throws PortalException, SystemEntryValidateException {

		_portletResourcePermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.ADD_ENTRY);

		return systemEntryLocalService.addEntry(orgEntry, serviceContext);
	}


	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return SystemEntry
	 * @throws PortalException
	 */
	@JSONWebService(mode = JSONWebServiceMode.IGNORE)
	public void deleteEntry(long primaryKey) throws PortalException {
		_systemEntryModelResourcePermission.check(
			getPermissionChecker(), primaryKey, ActionKeys.DELETE);

		systemEntryLocalService.deleteEntry(primaryKey);
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
	public SystemEntry getInitializedSystemEntry(
			long primaryKey, PortletRequest request)
		throws PortalException, PortletException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			request);

		_portletResourcePermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.ADD_ENTRY);

		return systemEntryLocalService.getNewObject(primaryKey);
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return ServiceContext serviceContext
	 * @throws PrincipalException
	 * @throws PortletException
	 */
	@JSONWebService(mode = JSONWebServiceMode.IGNORE)
	public SystemEntry getNewObject(long primaryKey, ServiceContext serviceContext)
		throws PrincipalException {

		primaryKey = (primaryKey <= 0) ? 0 :
		counterLocalService.increment(SystemEntry.class.getName());

		_portletResourcePermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.UPDATE);

		return systemEntryLocalService.getNewObject(primaryKey);
	}

	/**
	 * Returns the systementry with the primary key.
	 *
	 * @param primaryKey the primary key of the sample sb
	 * @return the systementry
	 * @throws PortalException if a systementry with the primary key could not be found
	 */
	@Override
	public SystemEntry getSystemEntry(long primaryKey) throws PortalException {
		_systemEntryModelResourcePermission.check(
			getPermissionChecker(), primaryKey, ActionKeys.VIEW);
		return systemEntryLocalService.getSystemEntry(primaryKey);
	}

	/**
	 * Returns the systementry
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	public SystemEntry getSystemEntry(long groupId, String urlTitle)
		throws PortalException {

		SystemEntry entry = systemEntryLocalService.getSystemEntry(groupId, urlTitle);

		_systemEntryModelResourcePermission.check(
			getPermissionChecker(), entry, ActionKeys.VIEW);

		return entry;
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return SystemEntry Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	@JSONWebService(mode = JSONWebServiceMode.IGNORE)
	public SystemEntry getSystemEntryFromRequest(
			long primaryKey, PortletRequest request)
		throws PortalException, PortletException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			request);

		_portletResourcePermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.VIEW);

		return systemEntryLocalService.getSystemEntryFromRequest(primaryKey, request);
	}

	/**
	 * Move an entry to the trush can
	 *
	 * @param entryId
	 * @return SystemEntry
	 * @throws PortalException
	 */
	@JSONWebService(mode = JSONWebServiceMode.IGNORE)
	public SystemEntry moveEntryToTrash(long entryId) throws PortalException {
		_systemEntryModelResourcePermission.check(
			getPermissionChecker(), entryId, ActionKeys.DELETE);

		return systemEntryLocalService.moveEntryToTrash(getUserId(), entryId);
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
	@JSONWebService(mode = JSONWebServiceMode.IGNORE)
	public SystemEntry updateEntry(
			SystemEntry orgEntry, ServiceContext serviceContext)
		throws PortalException, SystemEntryValidateException {

		_systemEntryModelResourcePermission.check(
			getPermissionChecker(), orgEntry.getPrimaryKey(),
			ActionKeys.UPDATE);

		return systemEntryLocalService.updateEntry(orgEntry, serviceContext);
	}

	public List<SystemEntry> getSystemEntries(){
		return systemEntryLocalService.getSystemEntries();
	}

	private static volatile ModelResourcePermission<SystemEntry>
		_systemEntryModelResourcePermission =
			ModelResourcePermissionFactory.getInstance(
				SystemEntryServiceImpl.class, "_systemEntryModelResourcePermission",
				SystemEntry.class);

	@Reference(
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY,
		target = "(resource.name=" + SystemEntryConstants.RESOURCE_NAME + ")"
	)
	private volatile PortletResourcePermission _portletResourcePermission;

}