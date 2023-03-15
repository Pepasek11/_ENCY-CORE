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
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import cz.csob.ency.modules.apps.meta.cds.constants.TableEntryConstants;
import cz.csob.ency.modules.apps.meta.cds.exception.TableEntryValidateException;
import cz.csob.ency.modules.apps.meta.cds.model.TableEntry;
import cz.csob.ency.modules.apps.meta.cds.service.base.TableEntryServiceBaseImpl;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

import java.util.List;

/**
 * The implementation of the TableEntry remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>cz.csob.ency.modules.apps.meta.cds.service.TableEntryService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Miroslav Čermák
 * @see TableEntryServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=metacds",
		"json.web.service.context.path=TableEntry"
	},
	service = AopService.class
)
public class TableEntryServiceImpl extends TableEntryServiceBaseImpl {

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
	@JSONWebService(mode = JSONWebServiceMode.IGNORE)
	public TableEntry addEntry(TableEntry orgEntry, ServiceContext serviceContext)
		throws PortalException, TableEntryValidateException {

		_portletResourcePermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.ADD_ENTRY);

		return tableEntryLocalService.addEntry(orgEntry, serviceContext);
	}

	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return TableEntry
	 * @throws PortalException
	 */
	@JSONWebService(mode = JSONWebServiceMode.IGNORE)
	public void deleteEntry(long primaryKey) throws PortalException {
		_tableEntryModelResourcePermission.check(
			getPermissionChecker(), primaryKey, ActionKeys.DELETE);

		tableEntryLocalService.deleteEntry(primaryKey);
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
	@JSONWebService(mode = JSONWebServiceMode.IGNORE)
	public TableEntry getInitializedTableEntry(
			long primaryKey, PortletRequest request)
		throws PortalException, PortletException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			request);

		_portletResourcePermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.ADD_ENTRY);

		return tableEntryLocalService.getNewObject(primaryKey);
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
	public TableEntry getNewObject(long primaryKey, ServiceContext serviceContext)
		throws PrincipalException {

		primaryKey = (primaryKey <= 0) ? 0 :
		counterLocalService.increment(TableEntry.class.getName());

		_portletResourcePermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.UPDATE);

		return tableEntryLocalService.getNewObject(primaryKey);
	}

	public List<TableEntry> getSystemTables(Long systemEntryId, String type) {
		//todo: permissions?
		return tableEntryLocalService.getSystemTables(systemEntryId, type);
	}

		/**
         * Returns the tableentry with the primary key.
         *
         * @param primaryKey the primary key of the sample sb
         * @return the tableentry
         * @throws PortalException if a tableentry with the primary key could not be found
         */
	@Override
	public TableEntry getTableEntry(long primaryKey) throws PortalException {
		_tableEntryModelResourcePermission.check(
			getPermissionChecker(), primaryKey, ActionKeys.VIEW);

		return tableEntryLocalService.getTableEntry(primaryKey);
	}

	/**
	 * Returns the tableentry
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	@JSONWebService(mode = JSONWebServiceMode.IGNORE)
	public TableEntry getTableEntry(long groupId, String urlTitle)
		throws PortalException {

		TableEntry entry = tableEntryLocalService.getTableEntry(groupId, urlTitle);

		_tableEntryModelResourcePermission.check(
			getPermissionChecker(), entry, ActionKeys.VIEW);

		return entry;
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return TableEntry Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	@JSONWebService(mode = JSONWebServiceMode.IGNORE)
	public TableEntry getTableEntryFromRequest(
			long primaryKey, PortletRequest request)
		throws PortalException, PortletException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			request);

		_portletResourcePermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.VIEW);

		return tableEntryLocalService.getTableEntryFromRequest(primaryKey, request);
	}

	/**
	 * Move an entry to the trush can
	 *
	 * @param entryId
	 * @return TableEntry
	 * @throws PortalException
	 */
	@JSONWebService(mode = JSONWebServiceMode.IGNORE)
	public TableEntry moveEntryToTrash(long entryId) throws PortalException {
		_tableEntryModelResourcePermission.check(
			getPermissionChecker(), entryId, ActionKeys.DELETE);

		return tableEntryLocalService.moveEntryToTrash(getUserId(), entryId);
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
	@JSONWebService(mode = JSONWebServiceMode.IGNORE)
	public TableEntry updateEntry(
			TableEntry orgEntry, ServiceContext serviceContext)
		throws PortalException, TableEntryValidateException {

		_tableEntryModelResourcePermission.check(
			getPermissionChecker(), orgEntry.getPrimaryKey(),
			ActionKeys.UPDATE);

		return tableEntryLocalService.updateEntry(orgEntry, serviceContext);
	}

	private static volatile ModelResourcePermission<TableEntry>
		_tableEntryModelResourcePermission =
			ModelResourcePermissionFactory.getInstance(
				TableEntryServiceImpl.class, "_tableEntryModelResourcePermission",
				TableEntry.class);

	@Reference(
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY,
		target = "(resource.name=" + TableEntryConstants.RESOURCE_NAME + ")"
	)
	private volatile PortletResourcePermission _portletResourcePermission;

}