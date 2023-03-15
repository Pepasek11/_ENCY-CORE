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


package cz.csob.ency.cds.demands.service.impl;

import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactory;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.cds.demands.constants.CdsDemandConstants;
import cz.csob.ency.cds.demands.exception.CdsDemandValidateException;
import cz.csob.ency.cds.demands.internal.util.RenderHelperUtils;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.cds.demands.service.base.CdsDemandServiceBaseImpl;
import cz.csob.ency.common.json.response.EncyJsonResponse;
import cz.csob.ency.workflow.manager.EncyWorkflowManager;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The implementation of the CdsDemand remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>cz.csob.ency.cds.demands.service.CdsDemandService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Miroslav Čermák
 * @see CdsDemandServiceBaseImpl
 */
@Component(
        property = {
                "json.web.service.context.name=cdsdemand",
                "json.web.service.context.path=CdsDemand"
        },
        service = AopService.class
)
public class CdsDemandServiceImpl extends CdsDemandServiceBaseImpl {
    private static final Log _log = LogFactoryUtil.getLog(
            CdsDemandServiceImpl.class);

    private static volatile ModelResourcePermission<CdsDemand>
            _cdsDemandModelResourcePermission =
            ModelResourcePermissionFactory.getInstance(
                    CdsDemandServiceImpl.class, "_cdsDemandModelResourcePermission",
                    CdsDemand.class);

    /**
     * Add Entry
     *
     * @param orgEntry       CdsDemand model
     * @param serviceContext ServiceContext
     * @return created CdsDemand model.
     * @throws PortalException
     * @throws CdsDemandValidateException
     */
    @Override
    public CdsDemand addEntry(CdsDemand orgEntry, ServiceContext serviceContext)
            throws PortalException, CdsDemandValidateException {

        _portletResourcePermission.check(
                _getPermissionChecker(serviceContext.getUserId()), serviceContext.getScopeGroupId(),
                ActionKeys.ADD_ENTRY);

        return cdsDemandLocalService.addEntry(orgEntry, serviceContext);
    }

    /**
     * Delete Attachment
     *
     * @param fileEntryId
     * @return CdsDemand
     * @throws PortalException
     */
    public EncyJsonResponse deleteAttachment(
            long fileEntryId, ServiceContext serviceContext) {

        try {

        /*
        @todo permissions:
        -Allow only for admin + owner/bicds only during new or spoc/ban approval phase

        _portletResourcePermission.check(
                 _getPermissionChecker(serviceContext.getUserId()), serviceContext.getScopeGroupId(),
                ActionKeys.DELETE);
        */


            FileEntry fileEntry = DLAppServiceUtil.getFileEntry(fileEntryId);
            if (Validator.isNull(fileEntry)) {
                return EncyJsonResponse.failure(
                        LanguageUtil.get(
                                serviceContext.getLocale(),
                                "attachment-not-found"));
            }

            _dlAppLocalService.deleteFileEntry(fileEntryId);

            return EncyJsonResponse.success("attachment-x-deleted-successfully", fileEntry);
        } catch (Exception ex) {
            return EncyJsonResponse.failure(ex);
        }
    }

    /**
     * Delete Entry
     *
     * @param primaryKey
     * @return CdsDemand
     * @throws PortalException
     */
    public EncyJsonResponse deleteEntry(long primaryKey, ServiceContext serviceContext) {

        try {
            _portletResourcePermission.check(
                    _getPermissionChecker(serviceContext.getUserId()),
                    serviceContext.getScopeGroupId(),
                    ActionKeys.DELETE);
        } catch (Exception e) {
            return EncyJsonResponse.failure("No permission", e);
        }

        try {
            cdsDemandLocalService.deleteEntry(primaryKey);
        } catch (Exception e) {
            return EncyJsonResponse.failure(e);
        }
        return EncyJsonResponse.success("ok");
    }

    public EncyJsonResponse findDemands(String[] states, ServiceContext serviceContext) {

        List<CdsDemand> result = null;
        List<Object> extendedResult = new LinkedList<>();
        try {
            _portletResourcePermission.check(
                    _getPermissionChecker(serviceContext.getUserId()), serviceContext.getScopeGroupId(),
                    ActionKeys.VIEW);

            result = cdsDemandLocalService.findAll();
            result.stream().forEach(cdsDemand ->
                    extendedResult.add(
                            _renderHelper.getExtendedModelAttributes(
                                    cdsDemand, serviceContext
                            )));
        } catch (PrincipalException e) {
            return EncyJsonResponse.failure("do-not-have-permission", e);
        } catch (Exception e) {
            return EncyJsonResponse.failure(e);
        }
        return EncyJsonResponse.success(extendedResult);

    }

    public EncyJsonResponse findDomainDemands(
            long userId, Long[] domainId, boolean getLongClosed,
            boolean includeOthersDrafts, ServiceContext serviceContext) {

        List<CdsDemand> demands =
                cdsDemandLocalService.findDomainDemands(
                        userId > 0 ? userId : serviceContext.getUserId(),
                        domainId, getLongClosed, includeOthersDrafts);

        return _toEncyJsonResponse(serviceContext, demands);

    }

    public EncyJsonResponse findUserActionRequiredDemands(
            long userId, ServiceContext serviceContext) {

        List<CdsDemand> demands =
                cdsDemandLocalService.findUserActionRequiredDemands(
                        userId > 0 ? userId : serviceContext.getUserId()
                        , serviceContext.getScopeGroupId());

        return _toEncyJsonResponse(serviceContext, demands);
    }

    public EncyJsonResponse findUserDemands(long userId, boolean getLongClosed, ServiceContext serviceContext) {
        List<CdsDemand> demands =
                cdsDemandLocalService.findUserDemands(
                        userId > 0 ? userId : serviceContext.getUserId(), getLongClosed);

        return _toEncyJsonResponse(serviceContext, demands);

    }

    public EncyJsonResponse getAttachments(long entryId, ServiceContext serviceContext) {

        CdsDemand entry = null;
        try {
            entry = getCdsDemand(entryId);
        } catch (PortalException e) {
        }

        if (Validator.isNull(entry)) {
            return EncyJsonResponse.failure(
                    LanguageUtil.get(
                            serviceContext.getLocale(),
                            "the-demand-is-not-found"));
        }

        long repositoryId = cdsDemandLocalService.getRepositoryId(entry.getGroupId());
        long folderId = cdsDemandLocalService.getAttachmentsFolderId(
                0, entry.getGroupId(), entry.getPrimaryKey());

        List<FileEntry> fileEntries = Collections.EMPTY_LIST;
        try {
            fileEntries = DLAppServiceUtil.getFileEntries(repositoryId, folderId);
        } catch (PortalException e) {
            if (_log.isDebugEnabled()) _log.debug(e);
        }

// @todo poskladat vystup a pridat url k priloze, ktera neni v FileEntry
//        .put(
//                "url",
//                () -> {
//                    ThemeDisplay themeDisplay =
//                            (ThemeDisplay)uploadPortletRequest.getAttribute(
//                                    WebKeys.THEME_DISPLAY);
//
//                    return PortletFileRepositoryUtil.getPortletFileEntryURL(
//                            themeDisplay, fileEntry, StringPool.BLANK);
//                }
//        )

        return EncyJsonResponse.success(fileEntries);
    }

    /**
     * Returns the cdsdemand with the primary key.
     *
     * @param primaryKey the primary key of the sample sb
     * @return the cdsdemand
     * @throws PortalException if a cdsdemand with the primary key could not be found
     * @todo zrusit???
     */
    @Override
    public CdsDemand getCdsDemand(long primaryKey) throws PortalException {
        _cdsDemandModelResourcePermission.check(
                getPermissionChecker(), primaryKey, ActionKeys.VIEW);

        return cdsDemandLocalService.getCdsDemand(primaryKey);
    }

    /**
     * Returns the cdsdemand with the primary key.
     *
     * @param uuid the uuid key of the sample sb
     * @return the cdsdemand
     * @throws PortalException if a cdsdemand with the primary key could not be found
     * @todo zrusit????
     */
    @Override
    public CdsDemand getCdsDemandByUUID(String uuid) throws PortalException {
        CdsDemand entry = cdsDemandLocalService.fetchCdsDemand(uuid);
        _cdsDemandModelResourcePermission.check(
                getPermissionChecker(), entry.getPrimaryKey(), ActionKeys.VIEW);

        return entry;
    }

    /**
     * Populate Model with values from a form
     *
     * @param request PortletRequest
     * @return CdsDemand Object
     * @throws PortletException
     * @throws PortalException
     */
    public CdsDemand getCdsDemandFromRequest(
            long primaryKey, PortletRequest request)
            throws PortalException, PortletException {

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                request);

        _portletResourcePermission.check(
                _getPermissionChecker(serviceContext.getUserId()), serviceContext.getScopeGroupId(),
                ActionKeys.VIEW);

        return cdsDemandLocalService.getCdsDemandFromRequest(primaryKey, request);
    }

    /**
     * Returns the extended cdsdemand with given primary key.
     * <p>
     * Extended info contains metadata and translated select fields to be used in react consumer.
     *
     * @param primaryKey the primary key of the sample sb
     * @return the cdsdemand
     * @throws PortalException if a cdsdemand with the primary key could not be found
     */
    @Override
    public EncyJsonResponse getExtendedCdsDemand(
            long primaryKey, ServiceContext serviceContext)
            throws PortalException {

        if (primaryKey > 0) {
            _cdsDemandModelResourcePermission.check(
                    _getPermissionChecker(serviceContext.getUserId()), primaryKey, ActionKeys.VIEW);
        } else {
            _portletResourcePermission.check(
                    _getPermissionChecker(serviceContext.getUserId()), serviceContext.getScopeGroupId(),
                    ActionKeys.ADD_ENTRY);
        }

        ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
                "content.Language", serviceContext.getLocale(), getClass());

        CdsDemand entry =
                primaryKey > 0 ?
                        cdsDemandLocalService.fetchCdsDemand(primaryKey) :
                        cdsDemandLocalService.getInitializedCdsDemand(serviceContext);

        if (Validator.isNull(entry)) {
            return EncyJsonResponse.failure(LanguageUtil.get(resourceBundle, "the-demand-is-not-found"));
        }

        JSONObject json = JSONFactoryUtil.createJSONObject(
                HashMapBuilder
                        .put("entry", _renderHelper.getExtendedModelAttributes(
                                entry, serviceContext))
                        .put("meta", _renderHelper.getEntryMetaAttributes(
                                entry, serviceContext))
                        .build());

        return EncyJsonResponse.success(json);
    }

    /**
     * Populate Model with values from a form
     *
     * @param request PortletRequest
     * @return CdsDemand Object
     * @throws PortletException
     * @throws PortalException
     */
    public CdsDemand getInitializedCdsDemand(PortletRequest request)
            throws PortalException, PortletException {

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                request);

        _portletResourcePermission.check(
                _getPermissionChecker(serviceContext.getUserId()), serviceContext.getScopeGroupId(),
                ActionKeys.ADD_ENTRY);

        return cdsDemandLocalService.getInitializedCdsDemand(request);
    }

    public EncyJsonResponse performTransition(
            long entryId, String transitionName, String comment, ServiceContext serviceContext)
            throws PortalException {

        _portletResourcePermission.check(
                _getPermissionChecker(serviceContext.getUserId()), serviceContext.getScopeGroupId(),
                ActionKeys.VIEW);

        ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
                "content.Language", serviceContext.getLocale(), getClass());

        String message = "";
        CdsDemand updatedEntry = null;

        if (Validator.isBlank(transitionName) || 0 == entryId) {
            message = LanguageUtil.get(
                    resourceBundle, "transition-param-missing");
        } else {
            CdsDemand entry = cdsDemandLocalService.fetchCdsDemand(entryId);

            try {
                updatedEntry = _encyWorkflowManager.performTransition(
                        serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), serviceContext.getUserId(),
                        CdsDemand.class.getName(), entryId, entry, transitionName, comment,
                        serviceContext, new HashMap<String, Serializable>());

                message = LanguageUtil.get(
                        resourceBundle, "transition-performed-successfully");

            } catch (CdsDemandValidateException e) {
                message = e.getErrors().stream().collect(Collectors.joining("<br/>"));
                _log.warn(message, e);
                return EncyJsonResponse.failure(message);
            } catch (PortalException e) {
                _log.warn(e);
                return EncyJsonResponse.failure(e);
            }
        }

        return EncyJsonResponse.success(message, updatedEntry);
    }

    @Override
    public EncyJsonResponse test(ServiceContext serviceContext) throws PortalException {
        return EncyJsonResponse.success("result", "jkshfkshdjfsd");
    }

    /**
     * Edit Entry
     *
     * @param orgEntry       CdsDemand model
     * @param serviceContext ServiceContext
     * @return updated CdsDemand model.
     * @throws PortalException
     * @throws CdsDemandValidateException
     */
    @Override
    public CdsDemand updateEntry(
            CdsDemand orgEntry, ServiceContext serviceContext)
            throws PortalException, CdsDemandValidateException {

        _cdsDemandModelResourcePermission.check(
                _getPermissionChecker(serviceContext.getUserId()), orgEntry.getPrimaryKey(),
                ActionKeys.UPDATE);

        return cdsDemandLocalService.updateEntry(orgEntry, serviceContext);
    }

    private PermissionChecker _getPermissionChecker(long userId)
            throws PrincipalException {

        User user = userLocalService.fetchUser(userId);
        if (Validator.isNull(user)) {
            return getPermissionChecker();
        }
        return PermissionCheckerFactoryUtil.create(user);
    }

    private EncyJsonResponse _toEncyJsonResponse(ServiceContext serviceContext, List<CdsDemand> demands) {
        return EncyJsonResponse.success(
                demands.stream().map(cdsDemand ->
                        _renderHelper.getExtendedModelAttributes(
                                cdsDemand, serviceContext)).collect(Collectors.toList()));
    }

    @Reference
    private PermissionCheckerFactory _defaultPermissionCheckerFactory;

    @Reference
    private DLAppLocalService _dlAppLocalService;

    @Reference
    private volatile EncyWorkflowManager _encyWorkflowManager;
    @Reference(
            policy = ReferencePolicy.DYNAMIC,
            policyOption = ReferencePolicyOption.GREEDY,
            target = "(resource.name=" + CdsDemandConstants.RESOURCE_NAME + ")"
    )
    private volatile PortletResourcePermission _portletResourcePermission;
    @Reference
    private RenderHelperUtils _renderHelper;
}