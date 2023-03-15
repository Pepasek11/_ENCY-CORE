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

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.friendly.url.service.FriendlyURLEntryLocalService;
import com.liferay.petra.portlet.url.builder.PortletURLBuilder;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.comment.CommentManagerUtil;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Repository;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepository;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.repository.model.ModelValidator;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.permission.ModelPermissions;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.upload.UniqueFileNameProvider;
import cz.csob.ency.cds.demands.bioe.service.BioeLocalService;
import cz.csob.ency.cds.demands.constants.CdsDemandConstants;
import cz.csob.ency.cds.demands.constants.CdsDemandWorkflowConstants;
import cz.csob.ency.cds.demands.exception.CdsDemandValidateException;
import cz.csob.ency.cds.demands.internal.util.CdsDemandValidator;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.cds.demands.model.CdsDemandVersion;
import cz.csob.ency.cds.demands.model.impl.CdsDemandModelImpl;
import cz.csob.ency.cds.demands.model.impl.CdsDemandVersionModelImpl;
import cz.csob.ency.cds.demands.service.base.CdsDemandLocalServiceBaseImpl;
import cz.csob.ency.common.helpers.UserHelper;
import cz.csob.ency.delegations.model.Delegation;
import cz.csob.ency.delegations.model.DelegationModel;
import cz.csob.ency.delegations.service.DelegatedRoleLocalService;
import cz.csob.ency.delegations.service.DelegationLocalService;
import cz.csob.ency.workflow.manager.EncyWorkflowManager;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;


/**
 * The implementation of the CdsDemand local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>cz.csob.ency.cds.demands.service.CdsDemandLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Miroslav Čermák
 * @todo Move urlTitle generation to the beforeModelUpdate event handler
 * @todo cleanup
 * @todo add support for an attachments
 * @see CdsDemandLocalServiceBaseImpl
 */
@Component(
        property = "model.class.name=cz.csob.ency.cds.demands.model.CdsDemand",
        service = AopService.class
)
public class CdsDemandLocalServiceImpl extends CdsDemandLocalServiceBaseImpl {

    public static final String[] FINAL_STATES = new String[]{
            CdsDemandWorkflowConstants.STATE_MIMO_BICDS,
            CdsDemandWorkflowConstants.STATE_AKCEPTOVANO,
            CdsDemandWorkflowConstants.STATE_POZASTAVENO_BAN,
            CdsDemandWorkflowConstants.STATE_POZASTAVENO_SPOC,
            CdsDemandWorkflowConstants.STATE_ZRUSENO,
    };
    //@todo refresh or remove default wf
    private static final int[] STATUS_ANY = {
            WorkflowConstants.STATUS_APPROVED, WorkflowConstants.STATUS_DENIED,
            WorkflowConstants.STATUS_DRAFT, WorkflowConstants.STATUS_EXPIRED,
            WorkflowConstants.STATUS_IN_TRASH, WorkflowConstants.STATUS_INACTIVE,
            WorkflowConstants.STATUS_INCOMPLETE, WorkflowConstants.STATUS_PENDING,
            WorkflowConstants.STATUS_SCHEDULED
    };
    private static final Log _log = LogFactoryUtil.getLog(
            CdsDemandLocalServiceImpl.class);

    /**
     * Add Entry
     *
     * @param orgEntry       CdsDemand model
     * @param serviceContext ServiceContext
     * @return created CdsDemand model.
     * @throws PortalException
     * @throws CdsDemandValidateException
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public CdsDemand addEntry(CdsDemand orgEntry, ServiceContext serviceContext)
            throws PortalException, CdsDemandValidateException {

        long userId = serviceContext.getUserId();
        // Validation

        ModelValidator<CdsDemand> modelValidator = new CdsDemandValidator();
        // modelValidator.validate(orgEntry);

        CdsDemand entry = _addEntry(orgEntry, serviceContext);

        // Force Set current user as an requestor
        entry.setRequestorId(userId);
        entry.setRequestorName(getFormattedUserName(serviceContext.fetchUser()));

        // Resources

        if (serviceContext.isAddGroupPermissions() ||
                serviceContext.isAddGuestPermissions()) {

            addEntryResources(
                    entry, serviceContext.isAddGroupPermissions(),
                    serviceContext.isAddGuestPermissions());
        } else {
            addEntryResources(entry, serviceContext.getModelPermissions());
        }

        // Asset

        updateAsset(
                userId, entry, serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(),
                serviceContext.getAssetLinkEntryIds(),
                serviceContext.getAssetPriority());

        // Workflow

        CdsDemand updatedEntry = _startWorkflowInstance(userId, entry, serviceContext);

        updatedEntry = updateEntryVersion(updatedEntry);

        return updatedEntry;
    }

    @Override
    public void addEntryResources(
            long entryId, boolean addGroupPermissions,
            boolean addGuestPermissions)
            throws PortalException {

        CdsDemand entry = cdsDemandPersistence.findByPrimaryKey(entryId);

        addEntryResources(entry, addGroupPermissions, addGuestPermissions);
    }

    @Override
    public void addEntryResources(
            long entryId, ModelPermissions modelPermissions)
            throws PortalException {

        CdsDemand entry = cdsDemandPersistence.findByPrimaryKey(entryId);

        addEntryResources(entry, modelPermissions);
    }

    @Override
    public void addEntryResources(
            CdsDemand entry, boolean addGroupPermissions,
            boolean addGuestPermissions)
            throws PortalException {

        resourceLocalService.addResources(
                entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
                CdsDemand.class.getName(), entry.getPrimaryKey(), false,
                addGroupPermissions, addGuestPermissions);
    }

    @Override
    public void addEntryResources(
            CdsDemand entry, ModelPermissions modelPermissions)
            throws PortalException {

        resourceLocalService.addModelResources(
                entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
                CdsDemand.class.getName(), entry.getPrimaryKey(), modelPermissions);
    }

    public int countAll() {
        int count = cdsDemandPersistence.countAll();
        return count;
    }

    public int countAllInUser(long userId) {
        int count = cdsDemandPersistence.countByUserId(userId);

        return count;
    }

    @Override
    @Transactional(enabled = false)
    public CdsDemand create() {
        long primaryKey = counterLocalService.increment(
                CdsDemand.class.getName());

        return createWithId(primaryKey);
    }

    @Transactional(enabled = false)
    public CdsDemand createWithId(long primaryKey) {
        CdsDemand draftCdsDemand = cdsDemandPersistence.create(primaryKey);

        draftCdsDemand.setHeadId(primaryKey);

        return draftCdsDemand;
    }

    /**
     * Delete entry
     */
    public CdsDemand deleteEntry(long primaryKey) throws PortalException {
        CdsDemand entry = getCdsDemand(primaryKey);

        return deleteEntry(entry);
    }

    /**
     * Delete entry
     *
     * @param entry CdsDemand
     * @return CdsDemand oject
     * @throws PortalException
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    @SystemEvent(type = SystemEventConstants.TYPE_DELETE)
    public CdsDemand deleteEntry(CdsDemand entry) throws PortalException {

        // Entry

        cdsDemandPersistence.remove(entry);

        // Resources

        resourceLocalService.deleteResource(
                entry.getCompanyId(), CdsDemand.class.getName(),
                ResourceConstants.SCOPE_INDIVIDUAL, entry.getPrimaryKey());

        // Asset

        assetEntryLocalService.deleteEntry(
                CdsDemand.class.getName(), entry.getPrimaryKey());

        // Comment

        _deleteDiscussion(entry);

        // Friendly URL

        _friendlyURLEntryLocalService.deleteFriendlyURLEntry(
                entry.getGroupId(), CdsDemand.class, entry.getPrimaryKey());

        // Workflow

        _encyWorkflowManager.deleteWorkflowInstance(
                CdsDemand.class.getName(), entry.getPrimaryKey());

        // Attachments
        Folder folder =
                cdsDemandLocalService.getAttachmentsFolder(
                        userLocalService.getDefaultUserId(entry.getCompanyId()), entry.getGroupId(), entry.getPrimaryKey());

        PortletFileRepositoryUtil.deletePortletFileEntries(entry.getGroupId(), folder.getFolderId());
        PortletFileRepositoryUtil.deletePortletFolder(folder.getFolderId());

        return entry;
    }

    /**
     * Delete entry
     */
    @Override
    @Transactional
    public CdsDemand deleteEntryFull(CdsDemand entry) throws PortalException {
        cdsDemandVersionPersistence.removeByDemandId(entry.getDemandId());
        return deleteEntry(entry);
    }

    @Override
    public Folder fetchAttachmentsFolder(long userId, long groupId, long entryId) {
        ServiceContext serviceContext = new ServiceContext();

        serviceContext.setAddGroupPermissions(true);
        serviceContext.setAddGuestPermissions(true);

        Repository repository = _portletFileRepository.fetchPortletRepository(
                groupId, CdsDemandConstants.SERVICE_NAME);

        try {
            return _portletFileRepository.getPortletFolder(
                    repository.getRepositoryId(),
                    DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
                    String.valueOf(entryId));
        } catch (Exception exception) {
            if (_log.isDebugEnabled()) {
                _log.debug(exception);
            }
        }

        return null;
    }

    @Override
    public CdsDemand fetchCdsDemand(String uuid) {
        return cdsDemandPersistence.fetchByXid_First(
                uuid, OrderByComparatorFactoryUtil.create(
                        CdsDemandModelImpl.TABLE_NAME,
                        "uuid", true)
        );
    }

    public List<CdsDemand> findAll() {
        return cdsDemandPersistence.findAll();
    }

    public List<CdsDemand> findAll(int start, int end,
                                   OrderByComparator<CdsDemand> orderByComparator) {
        return cdsDemandPersistence.findAll(start, end, orderByComparator);
    }

    public List<CdsDemand> findAll(
            long groupId, OrderByComparator<CdsDemand> orderByComparator) {

        List<CdsDemand> list = (List<CdsDemand>) findAll(
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);

        return list;
    }

    public List<CdsDemand> findAllInUser(long userId) {
        List<CdsDemand> list = (List<CdsDemand>) cdsDemandPersistence.findByUserId(
                userId);

        return list;
    }

    public List<CdsDemand> findAllInUser(
            long userId, int start, int end,
            OrderByComparator<CdsDemand> orderByComparator) {

        List<CdsDemand> list = cdsDemandPersistence.findByUserId(
                userId, start, end, orderByComparator);

        return list;
    }

    public List<CdsDemand> findAllInUser(
            long userId, OrderByComparator<CdsDemand> orderByComparator) {

        return findAllInUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);
    }

    public List<CdsDemand> findDomainDemands(
            long userId, Long[] domainId, boolean getLongClosed, boolean includeOthersDrafts) {
        Session session = null;
        try {
            session = cdsDemandPersistence.openSession();

            // Demands waiting for action of requestor/requested for user
            Criterion criterion =
                    (Validator.isNull(domainId) || domainId.length == 0) ?
                            RestrictionsFactoryUtil.sqlRestriction("1=1") :
                            RestrictionsFactoryUtil.in("domainId", domainId);

            if (!getLongClosed) {
                // Demands waiting for action of requestor/requested for user
                criterion = RestrictionsFactoryUtil.and(
                        criterion,
                        _getFinalStatesCriterion()
                );
            }

            if (!includeOthersDrafts) {
                Criterion userDrafts =
                        RestrictionsFactoryUtil.or(
                                RestrictionsFactoryUtil.and(
                                        _getRequestorsCrieterion(userId),
                                        RestrictionsFactoryUtil.eq("state", CdsDemandWorkflowConstants.STATE_NAVRH)
                                ),
                                RestrictionsFactoryUtil.not(
                                        RestrictionsFactoryUtil.eq("state", CdsDemandWorkflowConstants.STATE_NAVRH)
                                )
                        );
                criterion = RestrictionsFactoryUtil.and(
                        criterion,
                        userDrafts
                );
            }

            ClassLoader classLoader = getClass().getClassLoader();
            Order order = OrderFactoryUtil.desc("modifiedDate");

            DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(CdsDemand.class, classLoader)
                    .add(criterion)
                    .addOrder(order);

            return dynamicQuery(entryQuery);
        } catch (Exception e) {
            try {
                throw new SystemException(e);
            } catch (SystemException se) {
                se.printStackTrace();
            }
        } finally {
            cdsDemandPersistence.closeSession(session);
        }
        return Collections.emptyList();
    }

    public List<CdsDemand> findUserActionRequiredDemands(long userId, long groupId) {
        Session session = null;
        try {
            session = cdsDemandPersistence.openSession();

            ClassLoader classLoader = getClass().getClassLoader();

            Order order = OrderFactoryUtil.desc("modifiedDate");

            // Demands waiting for action of requestor/requested for user
            Criterion requestorActions =
                    RestrictionsFactoryUtil.and(
                            RestrictionsFactoryUtil.in("state",
                                    new String[]{
                                            CdsDemandWorkflowConstants.STATE_NAVRH,
                                            CdsDemandWorkflowConstants.STATE_AKCEPTACE,
                                    }),
                            _getRequestorsCrieterion(userId)
                    );

            // Demand required ban action and where user is ban or has delegated ban role
            List<Long> delagatedByBanId = _getDelegatedByBanId(userId, groupId);
            delagatedByBanId.add(userId);
            Criterion banActions =
                    RestrictionsFactoryUtil.and(
                            RestrictionsFactoryUtil.in("state",
                                    new String[]{
                                            CdsDemandWorkflowConstants.STATE_REVIZE_BAN,
                                            CdsDemandWorkflowConstants.STATE_REVIZE_DODAVKY,
                                            CdsDemandWorkflowConstants.STATE_POZASTAVENO_BAN,
                                            CdsDemandWorkflowConstants.STATE_REALIZACE,
                                    }),
                            RestrictionsFactoryUtil.in("banId", delagatedByBanId)
                    );

            // Demand required spoc action and where user is ban or has delegated ban role
            List<Long> delagatedBySpocId = _getDelegatedBySpocId(userId, groupId);
            delagatedBySpocId.add(userId);

            Criterion spocActions =
                    RestrictionsFactoryUtil.and(
                            RestrictionsFactoryUtil.in("state",
                                    new String[]{
                                            CdsDemandWorkflowConstants.STATE_REVIZE_SPOC,
                                            CdsDemandWorkflowConstants.STATE_NACENENO,
                                            CdsDemandWorkflowConstants.STATE_POZASTAVENO_SPOC,
                                            CdsDemandWorkflowConstants.STATE_AKCEPTACE,
                                    }),
                            RestrictionsFactoryUtil.in("spocId", delagatedBySpocId)
                    );

            DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(CdsDemand.class, classLoader)
                    .add(RestrictionsFactoryUtil.or(
                            requestorActions,
                            RestrictionsFactoryUtil.or(banActions, spocActions)))
                    .addOrder(order);

            return dynamicQuery(entryQuery);
        } catch (Exception e) {
            try {
                throw new SystemException(e);
            } catch (SystemException se) {
                se.printStackTrace();
            }
        } finally {
            cdsDemandPersistence.closeSession(session);
        }
        return Collections.emptyList();
    }

    public List<CdsDemand> findUserDemands(long userId, boolean getLongClosed) {
        Session session = null;
        try {
            session = cdsDemandPersistence.openSession();

            // Demands waiting for action of requestor/requested for user
            Criterion requestorCriterion =
                    RestrictionsFactoryUtil.or(
                            RestrictionsFactoryUtil.eq("requestorId", userId),
                            RestrictionsFactoryUtil.eq("requestedForId", userId)
                    );

            if (!getLongClosed) {
                // Demands waiting for action of requestor/requested for user
                requestorCriterion = RestrictionsFactoryUtil.and(
                        requestorCriterion,
                        _getFinalStatesCriterion()
                );
            }

            ClassLoader classLoader = getClass().getClassLoader();
            Order order = OrderFactoryUtil.desc("modifiedDate");

            DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(CdsDemand.class, classLoader)
                    .add(requestorCriterion)
                    .addOrder(order);

            return dynamicQuery(entryQuery);
        } catch (Exception e) {
            try {
                throw new SystemException(e);
            } catch (SystemException se) {
                se.printStackTrace();
            }
        } finally {
            cdsDemandPersistence.closeSession(session);
        }
        return Collections.emptyList();
    }

    @Override
    public Folder getAttachmentsFolder(long userId, long groupId, long entryId)
            throws PortalException {

        return _getAttachmentsFolder(userId, groupId, getAttachmentsFolderName(entryId));
    }

    @Override
    public long getAttachmentsFolderId(long userId, long groupId, long entryId) {
        try {
            return getAttachmentsFolder(userId, groupId, entryId).getFolderId();
        } catch (PortalException e) {

        }
        return 0;
    }

    public String getAttachmentsFolderName(long entryId) {
        return "CdsDemand_" + String.valueOf(entryId);
    }

    /**
     * Populate Model with values from a form
     *
     * @param request PortletRequest
     * @return CdsDemand Object
     * @throws PortletException
     * @throws CdsDemandValidateException
     * @todo bez primaryKey p[arametru?->Nacitat ho z requestu?
     */
    public CdsDemand getCdsDemandFromRequest(
            long primaryKey, PortletRequest request)
            throws PortletException, CdsDemandValidateException {

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(
                WebKeys.THEME_DISPLAY);

        // Create or fetch existing data

        CdsDemand entry;

        _log.debug("Get from request for " + primaryKey);
        if (primaryKey <= 0) {
            entry = create();
        } else {
            entry = fetchCdsDemand(primaryKey);
            if (Validator.isNull(entry)) {
                long currCounter = counterLocalService.increment(CdsDemand.class.getName(), 0);
                _log.debug("Not in db curr counter is " + currCounter);
                if (primaryKey <= currCounter) {
                    entry = createWithId(primaryKey);
                } else {
                    _log.error("trying to add new entry with primaryKey[" + primaryKey + "]>currentCounter[" + currCounter + "]");
                }
            }
        }

        try {
            // entry.setDemandId(primaryKey);
            entry.setTitle(ParamUtil.getString(request, "title"));
            entry.setDescription(ParamUtil.getString(request, "description"));
            entry.setType(ParamUtil.getInteger(request, "type"));
            entry.setPriority(ParamUtil.getInteger(request, "priority"));
            entry.setRequestedDelivery(getDateTimeFromRequest(request, "requestedDelivery"));
            entry.setIsGDPR(ParamUtil.getBoolean(request, "isGDPR"));
            entry.setFiveTracks(
                    ParamUtil.getLongValues(request, "fiveTracks"));
            entry.setRequestorId(ParamUtil.getLong(request, "requestorId"));
            entry.setContactId(ParamUtil.getLong(request, "contactId"));
            entry.setRequestedForId(ParamUtil.getLong(request, "requestedForId"));
            entry.setDomainId(ParamUtil.getLong(request, "domainId"));
            entry.setDomainName(ParamUtil.getString(request, "domainName"));
            entry.setBanId(ParamUtil.getLong(request, "banId"));
            entry.setSpocId(ParamUtil.getLong(request, "spocId"));

            entry.setUsReasoning(ParamUtil.getString(request, "usReasoning"));
            entry.setUsFrequencyOut(ParamUtil.getInteger(request, "usFrequencyOut"));
            entry.setUsAccessDPM(ParamUtil.getBoolean(request, "usAccessDPM"));
            entry.setUsFolderDPM(ParamUtil.getString(request, "usFolderDPM"));
            entry.setUsDPMNotificationMail(ParamUtil.getString(request, "usDPMNotificationMail"));
            entry.setUsCreateFolderDPM(ParamUtil.getBoolean(request, "usCreateFolderDPM"));
            entry.setUsGestorFolderDPMId(ParamUtil.getLong(request, "usGestorFolderDPMId"));

            entry.setCompanyId(themeDisplay.getCompanyId());
            entry.setGroupId(themeDisplay.getScopeGroupId());
            entry.setUserId(themeDisplay.getUserId());

            // Following entries are set by bioe loader, not from edit forms:
            // entry.setBioeId(ParamUtil.getString(request, "bioeId"));
            // entry.setBioeStateId(ParamUtil.getInt(request, "bioeStateId"));
            // entry.setBioeStateName(ParamUtil.getString(request, "bioeStateName"));
            // entry.setExpectedDelivery(getDateTimeFromRequest(request, "expectedDelivery"));
            // entry.setAcceptedDelivery(getDateTimeFromRequest(request, "acceptedDelivery"));
            // entry.setWorkEstimate(ParamUtil.getLong(request, "workEstimate"));
            // entry.setAcceptedWorkEstimate(ParamUtil.getLong(request, "acceptedWorkEstimate"));

            updateUserNames(entry);
        } catch (Exception e) {
            _log.error("Errors occur while populating the model", e);
            List<String> error = new ArrayList<>();
            error.add("value-convert-error");

            throw new CdsDemandValidateException(error);
        }

        return entry;
    }

    /**
     * Converte Date Time into Date()
     *
     * @param request PortletRequest
     * @param prefix  Prefix of the parameter
     * @return Date object
     */
    public Date getDateTimeFromRequest(PortletRequest request, String prefix) {
        long timestamp = ParamUtil.getLong(request, prefix, -1);
        if (timestamp > 0) {
            // Branch for ClayDateTimePicker from ajax that is working with timestamps
            return new Date(timestamp);
        }
        int Year = ParamUtil.getInteger(request, prefix + "Year");
        int Month = ParamUtil.getInteger(request, prefix + "Month") + 1;
        int Day = ParamUtil.getInteger(request, prefix + "Day");
        int Hour = ParamUtil.getInteger(request, prefix + "Hour");
        int Minute = ParamUtil.getInteger(request, prefix + "Minute");
        int AmPm = ParamUtil.getInteger(request, prefix + "AmPm");

        if (AmPm == Calendar.PM) {
            Hour += 12;
        }

        LocalDateTime ldt;

        try {
            ldt = LocalDateTime.of(Year, Month, Day, Hour, Minute, 0);
        } catch (Exception e) {
            _log.error(
                    "Unnable get date data. Initialize with current date", e);
            Date in = new Date();

            Instant instant = in.toInstant();

            return Date.from(instant);
        }

        return Date.from(
                ldt.atZone(
                        ZoneId.systemDefault()
                ).toInstant());
    }

    public String getFormattedUserName(User user) {
        if (Validator.isNull(user)) {
            return StringPool.BLANK;
        }
        return _userHelper.getFormattedUserName(user);
    }

    /**
     * Populate Model with values from a form
     *
     * @param request PortletRequest
     * @return CdsDemand Object
     * @throws PortletException
     */
    public CdsDemand getInitializedCdsDemand(PortletRequest request)
            throws PortalException {

        ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
        return getInitializedCdsDemand(0, serviceContext);
    }

    public CdsDemand getInitializedCdsDemand(ServiceContext sc) {
        return getInitializedCdsDemand(0, sc);
    }

    public CdsDemand getInitializedCdsDemand(long id, ServiceContext sc) {

        CdsDemand entry = null;

        Instant t = Instant.now();
        t = t.plusSeconds(60*60*24);

        if (id > 0) {
            entry = createWithId(id);
        } else {
            entry = create();
        }

        entry.setTitle("");
        entry.setDescription("");
        entry.setBioeId("");
        entry.setType(0);
        entry.setPriority(0);
        entry.setWorkEstimate(0);
        entry.setAcceptedWorkEstimate(0);
        entry.setRequestedDelivery(new Date(t.toEpochMilli()));
        entry.setExpectedDelivery(null);
        entry.setAcceptedDelivery(null);
        entry.setIsGDPR(false);
        entry.setGdprInfo("");
        entry.setFiveTracks("");
        entry.setRequestorId(sc.getUserId());
        User u = userLocalService.fetchUser(sc.getUserId());
        entry.setRequestorName(getFormattedUserName(u));
        entry.setRequestedForId(0);
        entry.setRequestedForName("");
        entry.setContactId(0);
        entry.setContactName("");
        entry.setDomainId(0);
        entry.setDomainName("");
        entry.setBanId(0);
        entry.setBanName("");
        entry.setSpocId(0);
        entry.setSpocName("");
        entry.setUsReasoning("");
        entry.setUsFrequencyOut(0);
        entry.setUsAccessDPM(false);
        entry.setUsFolderDPM("");
        entry.setUsDPMNotificationMail("");
        entry.setUsCreateFolderDPM(false);
        entry.setUsGestorFolderDPMId(0);
        entry.setUsGestorFolderDPMName("");
        entry.setCompanyId(sc.getCompanyId());
        entry.setGroupId(sc.getScopeGroupId());
        entry.setUserId(sc.getUserId());
        entry.setBioeStateId((short) 0);
        entry.setBioeStateName("");

        return entry;
    }

    public Repository getRepository(long groupId)
            throws PortalException {
        ServiceContext serviceContext = new ServiceContext();

        serviceContext.setAddGroupPermissions(true);
        serviceContext.setAddGuestPermissions(true);

        return _portletFileRepository.addPortletRepository(
                groupId, CdsDemandConstants.SERVICE_NAME, serviceContext);
    }

    public long getRepositoryId(long groupId) {
        try {
            return getRepository(groupId).getRepositoryId();
        } catch (PortalException e) {
        }
        return 0;
    }

    /**
     * Get STATUS_ANY for DB
     * <p>
     * This is equivalent of WorkflowConstants.STATUS_ANY
     *
     * @return All statuses for Workflow
     */
    public int[] getStatusAny() {
        return STATUS_ANY;
    }

    public long getUserDomainId(User user) {
        return _bioeLocalService.getUserDomainId(user.getScreenName());
    }

    @Indexable(type = IndexableType.REINDEX)
    @Override
    public CdsDemand importEntry(
            CdsDemand entry, ServiceContext serviceContext)
            throws PortalException, CdsDemandValidateException {


        if (entry.isNew()) {
            if (serviceContext.isAddGroupPermissions() ||
                    serviceContext.isAddGuestPermissions()) {

                addEntryResources(
                        entry, serviceContext.isAddGroupPermissions(),
                        serviceContext.isAddGuestPermissions());
            } else {
                addEntryResources(entry, serviceContext.getModelPermissions());
            }
        }


        //CdsDemand updatedEntry = cdsDemandPersistence.update(prepEntry);
        CdsDemand updatedEntry = updateEntryVersion(entry);

        // Asset

        updateAsset(
                updatedEntry.getUserId(), updatedEntry,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(),
                serviceContext.getAssetLinkEntryIds(),
                serviceContext.getAssetPriority());


        return updatedEntry;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public CdsDemand publishDraft(CdsDemand draftCdsDemand) throws PortalException {
        /*
        _log.info("Publishing draft.");
        deleteDraft(draftCdsDemand);
        return super.publishDraft(draftCdsDemand);
        */
        throw new UnsupportedOperationException("publishDraft is not supported.");
    }

    @Override
    public void updateAsset(
            long userId, CdsDemand entry, long[] assetCategoryIds,
            String[] assetTagNames, long[] assetLinkEntryIds, Double priority)
            throws PortalException {

        boolean visible = true;

        /* @todo add visible check logic
         boolean visible = false;
        if (entry.isApproved()) {
            visible = true;
        }
         */

        String summary = HtmlUtil.stripHtml(
                StringUtil.shorten(entry.getDescription(), 500));

        AssetEntry assetEntry = assetEntryLocalService.updateEntry(
                userId, entry.getGroupId(), entry.getCreateDate(),
                entry.getModifiedDate(), CdsDemand.class.getName(),
                entry.getPrimaryKey(), entry.getUuid(), 0, assetCategoryIds,
                assetTagNames, true, visible, null, null, null, null,
                ContentTypes.TEXT_HTML, entry.getTitle(), null, summary,
                null, null, 0, 0, priority);

        assetLinkLocalService.updateLinks(
                userId, assetEntry.getEntryId(), assetLinkEntryIds,
                AssetLinkConstants.TYPE_RELATED);
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
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public CdsDemand updateEntry(
            CdsDemand orgEntry, ServiceContext serviceContext)
            throws PortalException, CdsDemandValidateException {

        // Validation

        ModelValidator<CdsDemand> modelValidator = new CdsDemandValidator();
        //modelValidator.validate(orgEntry);

        // Update entry

        CdsDemand entry = _updateEntry(
                orgEntry.getPrimaryKey(), orgEntry, serviceContext);

        //CdsDemand updatedEntry = cdsDemandPersistence.update(entry);
        CdsDemand updatedEntry = updateEntryVersion(entry);

        // Asset

        updateAsset(
                updatedEntry.getUserId(), updatedEntry,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(),
                serviceContext.getAssetLinkEntryIds(),
                serviceContext.getAssetPriority());

        updatedEntry = _startWorkflowInstance(
                serviceContext.getUserId(), updatedEntry, serviceContext);

        return updatedEntry;
    }

    @Override
    public void updateEntryResources(
            CdsDemand entry, String[] groupPermissions,
            String[] guestPermissions)
            throws PortalException {

        resourceLocalService.updateResources(
                entry.getCompanyId(), entry.getGroupId(), CdsDemand.class.getName(),
                entry.getPrimaryKey(), groupPermissions, guestPermissions);
    }

    @Indexable(type = IndexableType.REINDEX)
    @Transactional(propagation = Propagation.REQUIRED)
    public CdsDemand updateEntryVersion(CdsDemand cdsDemand)
            throws PortalException {

        CdsDemand headCdsDemand = null;
        CdsDemand draftCdsDemand = null;

        int version = 1;

        if (cdsDemand.getHeadId() == cdsDemand.getPrimaryKey()) {
            // Draft not yet published
            headCdsDemand = cdsDemand;
        } else {
            if (cdsDemand.isHead()) {
                // Published entry
                headCdsDemand = cdsDemand;

            } else {
                // Draft with published version
                headCdsDemand = cdsDemandPersistence.findByPrimaryKey(
                        cdsDemand.getHeadId());
                draftCdsDemand = cdsDemand;
            }

            CdsDemandVersion latestCdsDemandVersion =
                    cdsDemandVersionPersistence.findByDemandId_First(
                            headCdsDemand.getPrimaryKey(),
                            OrderByComparatorFactoryUtil.create(
                                    CdsDemandVersionModelImpl.TABLE_NAME,
                                    "version", false
                            ));

            version = latestCdsDemandVersion.getVersion() + 1;
        }


        CdsDemandVersion cdsDemandVersion = cdsDemandVersionPersistence.create(
                counterLocalService.increment(CdsDemandVersion.class.getName()));

        cdsDemandVersion.setVersion(version);
        cdsDemandVersion.setVersionedModelId(headCdsDemand.getPrimaryKey());
        cdsDemand.populateVersionModel(cdsDemandVersion);
        cdsDemandVersionPersistence.update(cdsDemandVersion);

        cdsDemandVersion.populateVersionedModel(headCdsDemand);
        headCdsDemand.setHeadId(-headCdsDemand.getPrimaryKey());
        headCdsDemand = cdsDemandPersistence.update(headCdsDemand);

        if (draftCdsDemand != null /*&& draftCdsDemand.isDraft()*/) {
            deleteDraft(draftCdsDemand);
        }

        return headCdsDemand;
    }

    protected void updateUserNames(CdsDemand entry) {
        User user;

        user = userLocalService.fetchUser(entry.getSpocId());
        entry.setSpocName(Validator.isNull(user) ? null : getFormattedUserName(user));

        user = userLocalService.fetchUser(entry.getBanId());
        entry.setBanName(Validator.isNull(user) ? null : getFormattedUserName(user));

        user = userLocalService.fetchUser(entry.getRequestedForId());
        entry.setRequestedForName(Validator.isNull(user) ? null : getFormattedUserName(user));

        user = userLocalService.fetchUser(entry.getRequestorId());
        entry.setRequestorName(Validator.isNull(user) ? null : getFormattedUserName(user));

        user = userLocalService.fetchUser(entry.getContactId());
        entry.setContactName(Validator.isNull(user) ? null : getFormattedUserName(user));

        user = userLocalService.fetchUser(entry.getUsGestorFolderDPMId());
        entry.setUsGestorFolderDPMName(Validator.isNull(user) ? null : getFormattedUserName(user));
    }

    /**
     * Copy models at add entry
     * <p>
     * To process storing a record into database, copy the model passed into a new
     * model object here.
     *
     * @param entry          model object
     * @param serviceContext ServiceContext
     * @return
     * @throws PortalException
     */
    private CdsDemand _addEntry(CdsDemand entry, ServiceContext serviceContext)
            throws PortalException {

        // Check if entry with given id already exists
        CdsDemand persisted = fetchCdsDemand(entry.getDemandId());
        long currentIdHead = counterLocalService.increment(
                CdsDemand.class.getName(), 0);

        CdsDemand draftDemandEntry =
                Validator.isNull(persisted) && entry.getPrimaryKey() > 0 && entry.getPrimaryKey() <= currentIdHead ?
                        // It doesnt exist and we have Id (i.e. from getInitialized... from form)
                        createWithId(entry.getDemandId()) :
                        // It exist, or we dont have Id, or given Id was before current counter
                        create();

        User user = userLocalService.fetchUser(entry.getUserId());

        Date now = new Date();
        draftDemandEntry.setCompanyId(serviceContext.getCompanyId());
        draftDemandEntry.setGroupId(serviceContext.getScopeGroupId());
        draftDemandEntry.setUserId(serviceContext.getUserId());
        draftDemandEntry.setUserName(user == null ? entry.getUserName() : getFormattedUserName(user));
        draftDemandEntry.setCreateDate(now);
        draftDemandEntry.setModifiedDate(now);
        _setDemandFields(entry, draftDemandEntry);

        CdsDemand updatedDraftDemandEntry = updateDraft(draftDemandEntry);

        return updatedDraftDemandEntry;
    }

    /**
     * Delete discussion (comments)
     *
     * @param entry
     * @throws PortalException
     */
    private void _deleteDiscussion(CdsDemand entry) throws PortalException {
        CommentManagerUtil.deleteDiscussion(
                CdsDemand.class.getName(), entry.getPrimaryKey());
    }

    private Folder _getAttachmentsFolder(long userId, long groupId, String folderName)
            throws PortalException {

        ServiceContext serviceContext = new ServiceContext();

        serviceContext.setAddGroupPermissions(true);
        serviceContext.setAddGuestPermissions(true);

        Repository repository = getRepository(groupId);

        return _portletFileRepository.addPortletFolder(
                userId, repository.getRepositoryId(),
                DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName,
                serviceContext);
    }

    private List<Long> _getDelegatedByBanId(long userId, long groupId) {

        List<Delegation> delegations =
                _delegationLocalService.getDelegationsToUser(
                        groupId, "BAN", userId);

        return delegations.stream()
                .map(DelegationModel::getDelegatingUserId)
                .collect(Collectors.toList());
    }

    private List<Long> _getDelegatedBySpocId(long userId, long groupId) {
        List<Delegation> delegations =
                _delegationLocalService.getDelegationsToUser(
                        groupId, "SPOC", userId);
        return delegations.stream()
                .map(DelegationModel::getDelegatingUserId)
                .collect(Collectors.toList());
    }

    private String _getEntryURL(CdsDemand entry, ServiceContext serviceContext)
            throws PortalException {

        String entryURL = GetterUtil.getString(
                serviceContext.getAttribute("entryURL"));

        if (Validator.isNotNull(entryURL)) {
            return entryURL;
        }

        HttpServletRequest httpServletRequest = serviceContext.getRequest();

        if (httpServletRequest == null) {
            return StringPool.BLANK;
        }

        String portletId = PortletProviderUtil.getPortletId(
                CdsDemand.class.getName(), PortletProvider.Action.VIEW);

        if (Validator.isNotNull(portletId)) {
            String layoutURL = _portal.getLayoutFullURL(
                    entry.getGroupId(), portletId);

            if (Validator.isNotNull(layoutURL)) {
                return StringBundler.concat(
                        layoutURL, Portal.FRIENDLY_URL_SEPARATOR, "cdsdemand/",
                        Long.toString(entry.getDemandId()));
            }
        }

        portletId = PortletProviderUtil.getPortletId(
                CdsDemand.class.getName(), PortletProvider.Action.MANAGE);

        if (Validator.isNull(portletId) ||
                (serviceContext.getThemeDisplay() == null)) {

            return StringPool.BLANK;
        }

        return PortletURLBuilder.create(
                _portal.getControlPanelPortletURL(
                        httpServletRequest, portletId, PortletRequest.RENDER_PHASE)
        ).setMVCRenderCommandName(
                "/cdsdemand/crud"
        ).setCMD(
                Constants.VIEW
        ).setParameter(
                "resourcePrimKey", entry.getPrimaryKey()
        ).buildString();
    }

    private Criterion _getFinalStatesCriterion() {
        Date now = new Date();
        Instant boundary = now.toInstant().minusSeconds(30 * 24 * 60 * 60);
        return _getFinalStatesCriterion(boundary);
    }

    private Criterion _getFinalStatesCriterion(Instant boundary) {
        return RestrictionsFactoryUtil.or(
                RestrictionsFactoryUtil.and(
                        RestrictionsFactoryUtil.in("state", FINAL_STATES),
                        RestrictionsFactoryUtil.gt("modifiedDate", Date.from(boundary))
                ),
                RestrictionsFactoryUtil.not(
                        RestrictionsFactoryUtil.in("state", FINAL_STATES)
                )
        );
    }

    private Criterion _getRequestorsCrieterion(long userId) {
        return RestrictionsFactoryUtil.or(
                RestrictionsFactoryUtil.eq("requestorId", userId),
                RestrictionsFactoryUtil.or(
                        RestrictionsFactoryUtil.eq("requestedForId", userId),
                        RestrictionsFactoryUtil.eq("contactId", userId)
                )
        );
    }

    private boolean _hasFileEntry(
            long groupId, long folderId, String fileName) {

        FileEntry fileEntry = _portletFileRepository.fetchPortletFileEntry(
                groupId, folderId, fileName);

        if (fileEntry == null) {
            return false;
        }

        return true;
    }

    private void _setDemandFields(CdsDemand sourceEntry, CdsDemand targetEntry) {
        targetEntry.setTitle(sourceEntry.getTitle());
        targetEntry.setDescription(sourceEntry.getDescription());
        targetEntry.setBioeId(sourceEntry.getBioeId());
        targetEntry.setType(sourceEntry.getType());
        targetEntry.setPriority(sourceEntry.getPriority());
        targetEntry.setWorkEstimate(sourceEntry.getWorkEstimate());
        targetEntry.setAcceptedWorkEstimate(sourceEntry.getAcceptedWorkEstimate());
        targetEntry.setRequestedDelivery(sourceEntry.getRequestedDelivery());
        targetEntry.setExpectedDelivery(sourceEntry.getExpectedDelivery());
        targetEntry.setAcceptedDelivery(sourceEntry.getAcceptedDelivery());
        targetEntry.setIsGDPR(sourceEntry.getIsGDPR());
        targetEntry.setGdprInfo(sourceEntry.getGdprInfo());
        targetEntry.setFiveTracks(sourceEntry.getFiveTracks());

        targetEntry.setRequestorId(sourceEntry.getRequestorId());
        targetEntry.setRequestorName(sourceEntry.getRequestorName());
        targetEntry.setRequestedForId(sourceEntry.getRequestedForId());
        targetEntry.setRequestedForName(sourceEntry.getRequestedForName());
        targetEntry.setContactId(sourceEntry.getContactId());
        targetEntry.setContactName(sourceEntry.getContactName());
        targetEntry.setDomainId(sourceEntry.getDomainId());
        targetEntry.setDomainName(sourceEntry.getDomainName());
        targetEntry.setBanId(sourceEntry.getBanId());
        targetEntry.setBanName(sourceEntry.getBanName());
        targetEntry.setSpocId(sourceEntry.getSpocId());
        targetEntry.setSpocName(sourceEntry.getSpocName());

        targetEntry.setUsReasoning(sourceEntry.getUsReasoning());
        targetEntry.setUsFrequencyOut(sourceEntry.getUsFrequencyOut());
        targetEntry.setUsAccessDPM(sourceEntry.getUsAccessDPM());
        targetEntry.setUsFolderDPM(sourceEntry.getUsFolderDPM());
        targetEntry.setUsDPMNotificationMail(sourceEntry.getUsDPMNotificationMail());
        targetEntry.setUsCreateFolderDPM(sourceEntry.getUsCreateFolderDPM());
        targetEntry.setUsGestorFolderDPMId(sourceEntry.getUsGestorFolderDPMId());
        targetEntry.setUsGestorFolderDPMName(sourceEntry.getUsGestorFolderDPMName());

        targetEntry.setBioeStateName(sourceEntry.getBioeStateName());
        targetEntry.setBioeStateId(sourceEntry.getBioeStateId());
    }

    /**
     * Start workflow
     *
     * @param userId         User id of this model's owner
     * @param entry          model object
     * @param serviceContext ServiceContext
     * @return model with workflow configrations.
     * @throws PortalException
     */
    private CdsDemand _startWorkflowInstance(
            long userId, CdsDemand entry, ServiceContext serviceContext)
            throws PortalException {

        String userPortraitURL = StringPool.BLANK;
        String userURL = StringPool.BLANK;

        if (serviceContext.getThemeDisplay() != null) {
            User user = userLocalService.getUser(userId);

            userPortraitURL = user.getPortraitURL(
                    serviceContext.getThemeDisplay());
            userURL = user.getDisplayURL(serviceContext.getThemeDisplay());
        }

        Map<String, Serializable> workflowContext =
                HashMapBuilder.<String, Serializable>put(
                        WorkflowConstants.CONTEXT_URL,
                        _getEntryURL(entry, serviceContext)
                ).put(
                        WorkflowConstants.CONTEXT_USER_PORTRAIT_URL,
                        userPortraitURL
                ).put(
                        WorkflowConstants.CONTEXT_USER_URL,
                        userURL
                ).build();

        return _encyWorkflowManager.startWorkflowInstance(
                entry.getCompanyId(), entry.getGroupId(), userId,
                CdsDemand.class.getName(), entry.getPrimaryKey(), entry,
                serviceContext, workflowContext);
    }

    /**
     * Copy models at update entry
     * <p>
     * To process storing a record into database, copy the model passed into a new
     * model object here.
     *
     * @param primaryKey     Primary key
     * @param entry          model object
     * @param serviceContext ServiceContext
     * @return updated entry
     * @throws PortalException
     */
    private CdsDemand _updateEntry(
            long primaryKey, CdsDemand entry, ServiceContext serviceContext)
            throws PortalException {

        CdsDemand updateEntry = fetchCdsDemand(primaryKey);

        User user = userLocalService.fetchUser(entry.getUserId());

        Date now = new Date();
        updateEntry.setUuid(entry.getUuid());
        updateEntry.setDemandId(entry.getDemandId());

        updateEntry.setState(entry.getState());
        updateEntry.setStateByUserId(entry.getStateByUserId());
        updateEntry.setStateByUserName(entry.getStateByUserName());

        updateEntry.setCompanyId(entry.getCompanyId());
        updateEntry.setGroupId(entry.getGroupId());
        updateEntry.setUserId(entry.getUserId());
        updateEntry.setUserName(user == null ? entry.getUserName() : getFormattedUserName(user));
        updateEntry.setCreateDate(entry.getCreateDate());
        updateEntry.setModifiedDate(now);

        _setDemandFields(entry, updateEntry);

        if (0 == updateEntry.getRequestorId()) {
            updateEntry.setRequestorName(entry.getUserName());
            updateEntry.setRequestorId(entry.getUserId());
        }

        return updateEntry;
    }
    @Reference
    private BioeLocalService _bioeLocalService;
    @Reference
    private DelegatedRoleLocalService _delegatedRoleLocalService;
    @Reference
    private DelegationLocalService _delegationLocalService;
    @Reference
    private EncyWorkflowManager _encyWorkflowManager;
    @Reference
    private FriendlyURLEntryLocalService _friendlyURLEntryLocalService;
    @Reference
    private Portal _portal;
    @Reference
    private PortletFileRepository _portletFileRepository;
    @Reference
    private UniqueFileNameProvider _uniqueFileNameProvider;
    @Reference
    private UserHelper _userHelper;

}
