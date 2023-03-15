// 
/*   */
/**
 * Copyright (C) 2021 Yasuyuki Takeo All rights reserved.
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
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
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import cz.csob.ency.modules.apps.meta.cds.constants.ColumnEntryConstants;
import cz.csob.ency.modules.apps.meta.cds.exception.ColumnEntryValidateException;
import cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry;
import cz.csob.ency.modules.apps.meta.cds.service.ColumnEntryService;
import cz.csob.ency.modules.apps.meta.cds.service.base.ColumnEntryServiceBaseImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import java.util.List;

/**
 * The implementation of the ColumnEntry remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>cz.csob.ency.modules.apps.meta.cds.service.ColumnEntryService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Miroslav Čermák
 * @see ColumnEntryServiceBaseImpl
 */
@Component(
        property = {
                "json.web.service.context.name=metacds",
                "json.web.service.context.path=ColumnEntry"
        },
        service = AopService.class
)
public class ColumnEntryServiceImpl extends ColumnEntryServiceBaseImpl {

    private static volatile ModelResourcePermission<ColumnEntry>
            _columnEntryModelResourcePermission =
            ModelResourcePermissionFactory.getInstance(
                    ColumnEntryServiceImpl.class, "_columnEntryModelResourcePermission",
                    ColumnEntry.class);

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
    @JSONWebService(mode = JSONWebServiceMode.IGNORE)
    public ColumnEntry addEntry(ColumnEntry orgEntry, ServiceContext serviceContext)
            throws PortalException, ColumnEntryValidateException {

        _portletResourcePermission.check(
                getPermissionChecker(), serviceContext.getScopeGroupId(),
                ActionKeys.ADD_ENTRY);

        return columnEntryLocalService.addEntry(orgEntry, serviceContext);
    }

    /**
     * Delete Entry
     *
     * @param primaryKey
     * @return ColumnEntry
     * @throws PortalException
     */
    @JSONWebService(mode = JSONWebServiceMode.IGNORE)
    public void deleteEntry(long primaryKey) throws PortalException {
        _columnEntryModelResourcePermission.check(
                getPermissionChecker(), primaryKey, ActionKeys.DELETE);

        columnEntryLocalService.deleteEntry(primaryKey);
    }

    /**
     * Returns the columnentry with the primary key.
     *
     * @param primaryKey the primary key of the sample sb
     * @return the columnentry
     * @throws PortalException if a columnentry with the primary key could not be found
     */
    @Override
    public ColumnEntry getColumnEntry(long primaryKey) throws PortalException {
        _columnEntryModelResourcePermission.check(
                getPermissionChecker(), primaryKey, ActionKeys.VIEW);

        return columnEntryLocalService.getColumnEntry(primaryKey);
    }

    /**
     * Returns the columnentry
     *
     * @param groupId
     * @param urlTitle
     * @return
     * @throws PortalException
     */
    @JSONWebService(mode = JSONWebServiceMode.IGNORE)
    public ColumnEntry getColumnEntry(long groupId, String urlTitle)
            throws PortalException {

        ColumnEntry entry = columnEntryLocalService.getColumnEntry(groupId, urlTitle);

        _columnEntryModelResourcePermission.check(
                getPermissionChecker(), entry, ActionKeys.VIEW);

        return entry;
    }

    /**
     * Populate Model with values from a form
     *
     * @param request PortletRequest
     * @return ColumnEntry Object
     * @throws PortletException
     * @throws PortalException
     */
    @JSONWebService(mode = JSONWebServiceMode.IGNORE)
    public ColumnEntry getColumnEntryFromRequest(
            long primaryKey, PortletRequest request)
            throws PortalException, PortletException {

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                request);

        _portletResourcePermission.check(
                getPermissionChecker(), serviceContext.getScopeGroupId(),
                ActionKeys.VIEW);

        return columnEntryLocalService.getColumnEntryFromRequest(primaryKey, request);
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
    @JSONWebService(mode = JSONWebServiceMode.IGNORE)
    public ColumnEntry getInitializedColumnEntry(
            long primaryKey, PortletRequest request)
            throws PortalException, PortletException {

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                request);

        _portletResourcePermission.check(
                getPermissionChecker(), serviceContext.getScopeGroupId(),
                ActionKeys.ADD_ENTRY);

        return columnEntryLocalService.getNewObject(primaryKey);
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
    public ColumnEntry getNewObject(long primaryKey, ServiceContext serviceContext)
            throws PrincipalException {

        primaryKey = (primaryKey <= 0) ? 0 :
                counterLocalService.increment(ColumnEntry.class.getName());

        _portletResourcePermission.check(
                getPermissionChecker(), serviceContext.getScopeGroupId(),
                ActionKeys.UPDATE);

        return columnEntryLocalService.getNewObject(primaryKey);
    }

    public List<ColumnEntry> getTableColumns(long tableEntryId) throws PortalException {
        //@todo permissions? probably not if module is public
        return columnEntryLocalService.findAllInTable(tableEntryId);
    }

    /**
     * Move an entry to the trush can
     *
     * @param entryId
     * @return ColumnEntry
     * @throws PortalException
     */
    public ColumnEntry moveEntryToTrash(long entryId) throws PortalException {
        _columnEntryModelResourcePermission.check(
                getPermissionChecker(), entryId, ActionKeys.DELETE);

        return columnEntryLocalService.moveEntryToTrash(getUserId(), entryId);
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
    @JSONWebService(mode = JSONWebServiceMode.IGNORE)
    public ColumnEntry updateEntry(
            ColumnEntry orgEntry, ServiceContext serviceContext)
            throws PortalException, ColumnEntryValidateException {

        _columnEntryModelResourcePermission.check(
                getPermissionChecker(), orgEntry.getPrimaryKey(),
                ActionKeys.UPDATE);

        return columnEntryLocalService.updateEntry(orgEntry, serviceContext);
    }
    @Reference(
            policy = ReferencePolicy.DYNAMIC,
            policyOption = ReferencePolicyOption.GREEDY,
            target = "(resource.name=" + ColumnEntryConstants.RESOURCE_NAME + ")"
    )
    private volatile PortletResourcePermission _portletResourcePermission;

}