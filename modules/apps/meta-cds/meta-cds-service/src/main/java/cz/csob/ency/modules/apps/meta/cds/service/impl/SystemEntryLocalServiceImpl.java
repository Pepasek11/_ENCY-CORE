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

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.exportimport.kernel.lar.ExportImportThreadLocal;
import com.liferay.friendly.url.exception.DuplicateFriendlyURLEntryException;
import com.liferay.friendly.url.model.FriendlyURLEntry;
import com.liferay.friendly.url.service.FriendlyURLEntryLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.comment.CommentManagerUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ModelHintsUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.ModelValidator;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.permission.ModelPermissions;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.trash.exception.RestoreEntryException;
import com.liferay.trash.exception.TrashEntryException;
import com.liferay.trash.model.TrashEntry;
import com.liferay.trash.service.TrashEntryLocalService;
import cz.csob.ency.modules.apps.meta.cds.exception.SystemEntryValidateException;
import cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry;
import cz.csob.ency.modules.apps.meta.cds.model.SystemEntry;
import cz.csob.ency.modules.apps.meta.cds.service.base.SystemEntryLocalServiceBaseImpl;
import cz.csob.ency.modules.apps.meta.cds.service.util.SystemEntryValidator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;


/**
 * The implementation of the SystemEntry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>cz.csob.ency.modules.apps.meta.cds.service.SystemEntryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Miroslav Čermák
 * @see SystemEntryLocalServiceBaseImpl
 */
@Component(
        property = "model.class.name=cz.csob.ency.modules.apps.meta.cds.model.SystemEntry",
        service = AopService.class
)
public class SystemEntryLocalServiceImpl extends SystemEntryLocalServiceBaseImpl {

    private static final int[] STATUS_ANY = {
            WorkflowConstants.STATUS_APPROVED, WorkflowConstants.STATUS_DENIED,
            WorkflowConstants.STATUS_DRAFT, WorkflowConstants.STATUS_EXPIRED,
            WorkflowConstants.STATUS_IN_TRASH, WorkflowConstants.STATUS_INACTIVE,
            WorkflowConstants.STATUS_INCOMPLETE, WorkflowConstants.STATUS_PENDING,
            WorkflowConstants.STATUS_SCHEDULED
    };
    private static final Log _log = LogFactoryUtil.getLog(
            SystemEntryLocalServiceImpl.class);

    /**
     * Add Entry
     *
     * @param orgEntry       SystemEntry model
     * @param serviceContext ServiceContext
     * @return created SystemEntry model.
     * @throws PortalException
     * @throws SystemEntryValidateException
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public SystemEntry addEntry(SystemEntry orgEntry, ServiceContext serviceContext)
            throws PortalException, SystemEntryValidateException {

        long userId = serviceContext.getUserId();

        // Validation

        ModelValidator<SystemEntry> modelValidator = new SystemEntryValidator();
        modelValidator.validate(orgEntry);

        SystemEntry entry = _addEntry(orgEntry, serviceContext);

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

        return startWorkflowInstance(userId, entry, serviceContext);
    }

    @Override
    public void addEntryResources(
            long entryId, boolean addGroupPermissions,
            boolean addGuestPermissions)
            throws PortalException {

        SystemEntry entry = systemEntryPersistence.findByPrimaryKey(entryId);

        addEntryResources(entry, addGroupPermissions, addGuestPermissions);
    }

    @Override
    public void addEntryResources(
            long entryId, ModelPermissions modelPermissions)
            throws PortalException {

        SystemEntry entry = systemEntryPersistence.findByPrimaryKey(entryId);

        addEntryResources(entry, modelPermissions);
    }

    @Override
    public void addEntryResources(
            SystemEntry entry, boolean addGroupPermissions,
            boolean addGuestPermissions)
            throws PortalException {

        resourceLocalService.addResources(
                entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
                SystemEntry.class.getName(), entry.getPrimaryKey(), false,
                addGroupPermissions, addGuestPermissions);
    }

    @Override
    public void addEntryResources(
            SystemEntry entry, ModelPermissions modelPermissions)
            throws PortalException {

        resourceLocalService.addModelResources(
                entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
                SystemEntry.class.getName(), entry.getPrimaryKey(), modelPermissions);
    }

    public SystemEntry addOrUpdateFromRow(
            Map<String, Object> row, ServiceContext serviceContext) throws PortalException {

        long primaryKey = GetterUtil.getLong(row.getOrDefault("systemEntryId", 0));
        boolean isNew = false;
        SystemEntry entry = null;

        if (primaryKey > 0) {
            entry = fetchSystemEntry(primaryKey);
        }

        if (Validator.isNull(entry)) {
            primaryKey = GetterUtil.getLong(row.getOrDefault("systemCode", -9999));
            if (primaryKey > 0) {
                entry = systemEntryPersistence.fetchBySystemCode_First(
                        primaryKey, OrderByComparatorFactoryUtil.create(
                                "SystemEntry", "systemName", true, "systemCode", true
                        ));
            }
        }

        if (Validator.isNull(entry)) {
            entry = getNewObject(0);
            isNew = true;
        }

        try {
            entry.setSystemCode(GetterUtil.getLong(row.get("systemCode")));
            entry.setSystemName(GetterUtil.getString(row.get("systemName")));
            entry.setSystemTitle(GetterUtil.getString(row.get("systemTitle")));
            entry.setSystemType(GetterUtil.getString(row.get("systemType")));
            entry.setDescription(GetterUtil.getString(row.get("description")));
            entry.setStewardName(GetterUtil.getString(row.get("stewardName")));
            entry.setStewardId(GetterUtil.getString(row.get("stewardId")));
            entry.setStewardDepartment(GetterUtil.getString(row.get("stewardDepartment")));
            entry.setBusinessOwnerName(GetterUtil.getString(row.get("businessOwnerName")));
            entry.setBusinessOwnerId(GetterUtil.getString(row.get("businessOwnerId")));
            entry.setContactPersonName(GetterUtil.getString(row.get("contactPersonName")));
            entry.setContactPersonId(GetterUtil.getString(row.get("contactPersonId")));
            entry.setSandboxName(GetterUtil.getString(row.get("sandboxName")));
            entry.setGestorDepartmentId(GetterUtil.getString(row.get("gestorDepartmentId")));
            entry.setGestorDepartmentName(GetterUtil.getString(row.get("gestorDepartmentName")));
            entry.setRole(GetterUtil.getString(row.get("role")));
            entry.setSnowAssetTagId(GetterUtil.getString(row.get("snowAssetTagId")));
            entry.setSnowAssetTagName(GetterUtil.getString(row.get("snowAssetTagName")));
            entry.setIsSlaSigned(1==GetterUtil.getLong(row.get("isSlaSigned"), 0));
            entry.setIsSelfBi(1==GetterUtil.getLong(row.get("isSelfBi"), 0));
            entry.setIsActive(1==GetterUtil.getLong(row.get("isActive"), 0));
            entry.setCompanyId(serviceContext.getCompanyId());
            entry.setGroupId(serviceContext.getScopeGroupId());
            entry.setUserId(serviceContext.getUserId());

            if (isNew) {
                addEntry(entry, serviceContext);
            } else {
                updateEntry(entry, serviceContext);
            }
        } catch (Exception e) {
            throw e;
        }

        return entry;
    }

    public int countAllInGroup(long groupId) {
        int count = systemEntryPersistence.countByGroupId(groupId);

        return count;
    }

    public int countAllInGroup(long groupId, int[] status) {
        int count = systemEntryPersistence.countByG_S(groupId, status);

        return count;
    }

    public int countAllInUser(long userId) {
        int count = systemEntryPersistence.countByUserId(userId);

        return count;
    }

    public int countAllInUser(long userId, int[] status) {
        int count = systemEntryPersistence.countByU_S(userId, status);

        return count;
    }

    public int countAllInUserAndGroup(long userId, long groupId) {
        int count = systemEntryPersistence.countByUserIdGroupId(userId, groupId);

        return count;
    }

    public int countAllInUserAndGroup(long userId, long groupId, int[] status) {
        int count = systemEntryPersistence.countByG_U_S(groupId, userId, status);

        return count;
    }

    /**
     * Delete entry
     */
    public SystemEntry deleteEntry(long primaryKey) throws PortalException {
        SystemEntry entry = getSystemEntry(primaryKey);

        return deleteEntry(entry);
    }

    /**
     * Delete entry
     *
     * @param entry SystemEntry
     * @return SystemEntry oject
     * @throws PortalException
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    @SystemEvent(type = SystemEventConstants.TYPE_DELETE)
    public SystemEntry deleteEntry(SystemEntry entry) throws PortalException {

        // Entry

        systemEntryPersistence.remove(entry);

        // Resources

        resourceLocalService.deleteResource(
                entry.getCompanyId(), SystemEntry.class.getName(),
                ResourceConstants.SCOPE_INDIVIDUAL, entry.getPrimaryKey());

        // Asset

        assetEntryLocalService.deleteEntry(
                SystemEntry.class.getName(), entry.getPrimaryKey());

        // Comment

        deleteDiscussion(entry);

        // Friendly URL

        _friendlyURLEntryLocalService.deleteFriendlyURLEntry(
                entry.getGroupId(), SystemEntry.class, entry.getPrimaryKey());

        // Trash

        _trashEntryLocalService.deleteEntry(
                SystemEntry.class.getName(), entry.getPrimaryKey());

        // Workflow

        workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
                entry.getCompanyId(), entry.getGroupId(), SystemEntry.class.getName(),
                entry.getPrimaryKey());

        return entry;
    }

    public SystemEntry fetchEntryByCode(long systemCode) {
        SystemEntry entry = (SystemEntry) systemEntryPersistence.fetchBySystemCode_First(
                systemCode,
                OrderByComparatorFactoryUtil.create("SystemEntry", "systemName", true));

        return entry;
    }

    public List<SystemEntry> findAllInGroup(long groupId) {
        List<SystemEntry> list = (List<SystemEntry>) systemEntryPersistence.findByGroupId(
                groupId);

        return list;
    }

    public List<SystemEntry> findAllInGroup(
            long groupId, int start, int end,
            OrderByComparator<SystemEntry> orderByComparator) {

        return findAllInGroup(
                groupId, start, end, orderByComparator,
                new int[]{WorkflowConstants.STATUS_APPROVED});
    }

    public List<SystemEntry> findAllInGroup(
            long groupId, int start, int end,
            OrderByComparator<SystemEntry> orderByComparator, int[] status) {

        List<SystemEntry> list = (List<SystemEntry>) systemEntryPersistence.findByG_S(
                groupId, status, start, end, orderByComparator);

        return list;
    }

    public List<SystemEntry> findAllInGroup(long groupId, int[] status) {
        List<SystemEntry> list = (List<SystemEntry>) systemEntryPersistence.findByG_S(
                groupId, status);

        return list;
    }

    public List<SystemEntry> findAllInGroup(
            long groupId, OrderByComparator<SystemEntry> orderByComparator) {

        List<SystemEntry> list = (List<SystemEntry>) findAllInGroup(
                groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);

        return list;
    }

    public List<SystemEntry> findAllInUser(long userId) {
        List<SystemEntry> list = (List<SystemEntry>) systemEntryPersistence.findByUserId(
                userId);

        return list;
    }

    public List<SystemEntry> findAllInUser(
            long userId, int start, int end,
            OrderByComparator<SystemEntry> orderByComparator) {

        List<SystemEntry> list = (List<SystemEntry>) systemEntryPersistence.findByUserId(
                userId, start, end, orderByComparator);

        return list;
    }

    public List<SystemEntry> findAllInUser(
            long userId, int start, int end,
            OrderByComparator<SystemEntry> orderByComparator, int[] status) {

        List<SystemEntry> list = (List<SystemEntry>) systemEntryPersistence.findByU_S(
                userId, status, start, end, orderByComparator);

        return list;
    }

    public List<SystemEntry> findAllInUser(long userId, int[] status) {
        List<SystemEntry> list = (List<SystemEntry>) systemEntryPersistence.findByU_S(
                userId, status);

        return list;
    }

    public List<SystemEntry> findAllInUser(
            long userId, OrderByComparator<SystemEntry> orderByComparator) {

        List<SystemEntry> list = (List<SystemEntry>) findAllInUser(
                userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);

        return list;
    }

    public List<SystemEntry> findAllInUserAndGroup(long userId, long groupId) {
        List<SystemEntry> list =
                (List<SystemEntry>) systemEntryPersistence.findByUserIdGroupId(
                        userId, groupId);

        return list;
    }

    public List<SystemEntry> findAllInUserAndGroup(
            long userId, long groupId, int start, int end,
            OrderByComparator<SystemEntry> orderByComparator) {

        List<SystemEntry> list =
                (List<SystemEntry>) systemEntryPersistence.findByUserIdGroupId(
                        groupId, userId, start, end, orderByComparator);

        return list;
    }

    public List<SystemEntry> findAllInUserAndGroup(
            long userId, long groupId, int start, int end,
            OrderByComparator<SystemEntry> orderByComparator, int[] status) {

        List<SystemEntry> list = (List<SystemEntry>) systemEntryPersistence.findByG_U_S(
                groupId, userId, status, start, end, orderByComparator);

        return list;
    }

    public List<SystemEntry> findAllInUserAndGroup(
            long userId, long groupId, int[] status) {

        List<SystemEntry> list = (List<SystemEntry>) systemEntryPersistence.findByG_U_S(
                groupId, userId, status);

        return list;
    }

    public List<SystemEntry> findAllInUserAndGroup(
            long userId, long groupId,
            OrderByComparator<SystemEntry> orderByComparator) {

        List<SystemEntry> list = (List<SystemEntry>) findAllInUserAndGroup(
                groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
                orderByComparator);

        return list;
    }

    /**
     * Get Company entries
     *
     * @param companyId Company Id
     * @param status    Workflow status
     * @param start     start index of entries
     * @param end       end index of entries
     * @return
     * @throws SystemException
     */
    public List<SystemEntry> getCompanyEntries(
            long companyId, int status, int start, int end) {

        if (status == WorkflowConstants.STATUS_ANY) {
            return systemEntryPersistence.findByCompanyId(companyId, start, end);
        }

        return systemEntryPersistence.findByC_S(companyId, status, start, end);
    }

    /**
     * Get Company entries
     *
     * @param companyId Company Id
     * @param status    Workflow status
     * @param start     start index of entries
     * @param end       end index of entries
     * @param obc       Comparator for the order
     * @return List of entries
     * @throws SystemException
     */
    public List<SystemEntry> getCompanyEntries(
            long companyId, int status, int start, int end,
            OrderByComparator<SystemEntry> obc) {

        if (status == WorkflowConstants.STATUS_ANY) {
            return systemEntryPersistence.findByCompanyId(
                    companyId, start, end, obc);
        }

        return systemEntryPersistence.findByC_S(
                companyId, status, start, end, obc);
    }

    /**
     * Get Company entries counts
     *
     * @param companyId
     * @param status
     * @return
     * @throws SystemException
     */
    public int getCompanyEntriesCount(long companyId, int status) {
        if (status == WorkflowConstants.STATUS_ANY) {
            return systemEntryPersistence.countByCompanyId(companyId);
        }

        return systemEntryPersistence.countByC_S(companyId, status);
    }

    /**
     * Converte Date Time into Date()
     *
     * @param request PortletRequest
     * @param prefix  Prefix of the parameter
     * @return Date object
     */
    public Date getDateTimeFromRequest(PortletRequest request, String prefix) {
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

    /**
     * Populate Model with values from a form
     *
     * @param primaryKey primary key
     * @param request    PortletRequest
     * @return SystemEntry Object
     * @throws PortletException
     */
    public SystemEntry getInitializedSystemEntry(
            long primaryKey, PortletRequest request)
            throws PortletException {

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(
                WebKeys.THEME_DISPLAY);

        // Create or fetch existing data

        SystemEntry entry = getNewObject(primaryKey);

        /*   */
        entry.setSystemEntryId(primaryKey);
        entry.setSystemCode(0);
        entry.setSystemName("");
        entry.setSystemTitle("");
        entry.setSystemType("");
        entry.setDescription("");
        entry.setStewardName("");
        entry.setStewardId("");
        entry.setStewardDepartment("");
        entry.setBusinessOwnerName("");
        entry.setBusinessOwnerId("");
        entry.setContactPersonName("");
        entry.setContactPersonId("");
        entry.setSandboxName("");
        entry.setGestorDepartmentId("");
        entry.setGestorDepartmentName("");
        entry.setRole("");
        entry.setSnowAssetTagId("");
        entry.setSnowAssetTagName("");
        entry.setIsSlaSigned(true);
        entry.setIsSelfBi(true);
        entry.setIsActive(true);
/*
		entry.setSystemName("");
		entry.setDescription("");
*/

        entry.setCompanyId(themeDisplay.getCompanyId());
        entry.setGroupId(themeDisplay.getScopeGroupId());
        entry.setUserId(themeDisplay.getUserId());

        return entry;
    }

    /**
     * Get Record
     *
     * @param primaryKey Primary key
     * @return SystemEntry object
     * @throws PortletException
     */
    public SystemEntry getNewObject(long primaryKey) {
        primaryKey = (primaryKey <= 0) ? 0 :
                counterLocalService.increment(SystemEntry.class.getName());

        return createSystemEntry(primaryKey);
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

    /**
     * Get Entity
     *
     * @param groupId
     * @param urlTitle
     * @return
     * @throws PortalException
     */
    public SystemEntry getSystemEntry(long groupId, String urlTitle)
            throws PortalException {

        FriendlyURLEntry friendlyURLEntry =
                _friendlyURLEntryLocalService.fetchFriendlyURLEntry(
                        groupId, SystemEntry.class, urlTitle);

        if (friendlyURLEntry != null) {
            return systemEntryPersistence.findByPrimaryKey(
                    friendlyURLEntry.getClassPK());
        }

        return systemEntryPersistence.findByG_UT(groupId, urlTitle);
    }

    /**
     * Populate Model with values from a form
     *
     * @param request PortletRequest
     * @return SystemEntry Object
     * @throws PortletException
     * @throws SystemEntryValidateException
     */
    public SystemEntry getSystemEntryFromRequest(
            long primaryKey, PortletRequest request)
            throws PortletException, SystemEntryValidateException {

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(
                WebKeys.THEME_DISPLAY);

        // Create or fetch existing data

        SystemEntry entry;

        if (primaryKey <= 0) {
            entry = getNewObject(primaryKey);
        } else {
            entry = fetchSystemEntry(primaryKey);
        }

        try {
            /*   */
            entry.setSystemEntryId(primaryKey);
            entry.setSystemCode(ParamUtil.getLong(request, "systemCode"));
            entry.setSystemName(ParamUtil.getString(request, "systemName"));
            entry.setSystemTitle(ParamUtil.getString(request, "systemTitle"));
            entry.setSystemType(ParamUtil.getString(request, "systemType"));
            entry.setDescription(ParamUtil.getString(request, "description"));
            entry.setStewardName(ParamUtil.getString(request, "stewardName"));
            entry.setStewardId(ParamUtil.getString(request, "stewardId"));
            entry.setStewardDepartment(ParamUtil.getString(request, "stewardDepartment"));
            entry.setBusinessOwnerName(ParamUtil.getString(request, "businessOwnerName"));
            entry.setBusinessOwnerId(ParamUtil.getString(request, "businessOwnerId"));
            entry.setContactPersonName(ParamUtil.getString(request, "contactPersonName"));
            entry.setContactPersonId(ParamUtil.getString(request, "contactPersonId"));
            entry.setSandboxName(ParamUtil.getString(request, "sandboxName"));
            entry.setGestorDepartmentId(ParamUtil.getString(request, "gestorDepartmentId"));
            entry.setGestorDepartmentName(ParamUtil.getString(request, "gestorDepartmentName"));
            entry.setRole(ParamUtil.getString(request, "role"));
            entry.setSnowAssetTagId(ParamUtil.getString(request, "snowAssetTagId"));
            entry.setSnowAssetTagName(ParamUtil.getString(request, "snowAssetTagName"));
            entry.setIsSlaSigned(ParamUtil.getBoolean(request, "isSlaSigned"));
            entry.setIsSelfBi(ParamUtil.getBoolean(request, "isSelfBi"));
            entry.setIsActive(ParamUtil.getBoolean(request, "isActive"));
            entry.setCompanyId(themeDisplay.getCompanyId());
            entry.setGroupId(themeDisplay.getScopeGroupId());
            entry.setUserId(themeDisplay.getUserId());
        } catch (Exception e) {
            _log.error("Errors occur while populating the model", e);
            List<String> error = new ArrayList<>();
            error.add("value-convert-error");

            throw new SystemEntryValidateException(error);
        }

        return entry;
    }

    public List<SystemEntry> getSystemEntries() {
        return systemEntryPersistence.findAll();
    }

    public SystemEntry moveEntryToTrash(long userId, long entryId)
            throws PortalException {

        SystemEntry entry = systemEntryPersistence.findByPrimaryKey(entryId);

        return moveEntryToTrash(userId, entry);
    }

    /**
     * Moves the entry to the recycle bin.
     * <p>
     * Social activity counters for this entry get disabled.
     *
     * @param userId the primary key of the user moving the entry
     * @param entry  the entry to be moved
     * @return the moved entry
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public SystemEntry moveEntryToTrash(long userId, SystemEntry entry)
            throws PortalException {

        // Entry

        if (entry.isInTrash()) {
            throw new TrashEntryException();
        }

        int oldStatus = entry.getStatus();

        if (oldStatus == WorkflowConstants.STATUS_PENDING) {
            entry.setStatus(WorkflowConstants.STATUS_DRAFT);

            systemEntryPersistence.update(entry);
        }

        entry = updateStatus(
                userId, entry.getPrimaryKey(), WorkflowConstants.STATUS_IN_TRASH,
                new ServiceContext(), new HashMap<String, Serializable>());

        // Workflow

        if (oldStatus == WorkflowConstants.STATUS_PENDING) {
            workflowInstanceLinkLocalService.deleteWorkflowInstanceLink(
                    entry.getCompanyId(), entry.getGroupId(),
                    SystemEntry.class.getName(), entry.getPrimaryKey());
        }

        return entry;
    }

    /**
     * Restores the entry with the ID from the recycle bin. Social activity counters
     * for this entry get activated.
     *
     * @param userId  the primary key of the user restoring the entry
     * @param entryId the primary key of the entry to be restored
     * @return the restored entry from the recycle bin
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public SystemEntry restoreEntryFromTrash(long userId, long entryId)
            throws PortalException {

        // Entry

        SystemEntry entry = systemEntryPersistence.findByPrimaryKey(entryId);

        if (!entry.isInTrash()) {
            throw new RestoreEntryException(
                    RestoreEntryException.INVALID_STATUS);
        }

        TrashEntry trashEntry = _trashEntryLocalService.getEntry(
                SystemEntry.class.getName(), entryId);

        updateStatus(
                userId, entryId, trashEntry.getStatus(), new ServiceContext(),
                new HashMap<String, Serializable>());

        return entry;
    }

    @Override
    public void updateAsset(
            long userId, SystemEntry entry, long[] assetCategoryIds,
            String[] assetTagNames, long[] assetLinkEntryIds, Double priority)
            throws PortalException {

        boolean visible = false;

        if (entry.isApproved()) {
            visible = true;
        }

        String summary = HtmlUtil.stripHtml(
                StringUtil.shorten(entry.getDescription(), 500));

        AssetEntry assetEntry = assetEntryLocalService.updateEntry(
                userId, entry.getGroupId(), entry.getCreateDate(),
                entry.getModifiedDate(), SystemEntry.class.getName(),
                entry.getPrimaryKey(), entry.getUuid(), 0, assetCategoryIds,
                assetTagNames, true, visible, null, null, null, null,
                ContentTypes.TEXT_HTML, entry.getSystemName(), null, summary,
                null, null, 0, 0, priority);

        assetLinkLocalService.updateLinks(
                userId, assetEntry.getEntryId(), assetLinkEntryIds,
                AssetLinkConstants.TYPE_RELATED);
    }

    /**
     * Edit Entry
     *
     * @param orgEntry       SystemEntry model
     * @param serviceContext ServiceContext
     * @return updated SystemEntry model.
     * @throws PortalException
     * @throws SystemEntryValidateException
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public SystemEntry updateEntry(
            SystemEntry orgEntry, ServiceContext serviceContext)
            throws PortalException, SystemEntryValidateException {

        User user = userLocalService.getUser(orgEntry.getUserId());

        // Validation

        ModelValidator<SystemEntry> modelValidator = new SystemEntryValidator();
        modelValidator.validate(orgEntry);

        // Update entry

        SystemEntry entry = _updateEntry(
                orgEntry.getPrimaryKey(), orgEntry, serviceContext);

        if (!entry.isPending() && !entry.isDraft()) {
            entry.setStatus(WorkflowConstants.STATUS_DRAFT);
        }

        if(orgEntry.equals(entry)) {
            return entry;
        }

        SystemEntry updatedEntry = systemEntryPersistence.update(entry);

        // Asset

        updateAsset(
                updatedEntry.getUserId(), updatedEntry,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(),
                serviceContext.getAssetLinkEntryIds(),
                serviceContext.getAssetPriority());

        updatedEntry = startWorkflowInstance(
                user.getUserId(), updatedEntry, serviceContext);

        return updatedEntry;
    }

    @Override
    public void updateEntryResources(
            SystemEntry entry, String[] groupPermissions,
            String[] guestPermissions)
            throws PortalException {

        resourceLocalService.updateResources(
                entry.getCompanyId(), entry.getGroupId(), SystemEntry.class.getName(),
                entry.getPrimaryKey(), groupPermissions, guestPermissions);
    }

    @Indexable(type = IndexableType.REINDEX)
    public SystemEntry updateStatus(
            long userId, long entryId, int status,
            ServiceContext serviceContext,
            Map<String, Serializable> workflowContext)
            throws PortalException {

        // Entry

        User user = userLocalService.getUser(userId);
        Date now = new Date();

        SystemEntry entry = systemEntryPersistence.findByPrimaryKey(entryId);

        int oldStatus = entry.getStatus();

        entry.setModifiedDate(serviceContext.getModifiedDate(now));
        entry.setStatus(status);
        entry.setStatusByUserId(user.getUserId());
        entry.setStatusByUserName(user.getFullName());
        entry.setStatusDate(serviceContext.getModifiedDate(now));

        systemEntryPersistence.update(entry);

        AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
                SystemEntry.class.getName(), entryId);

        if ((assetEntry == null) || (assetEntry.getPublishDate() == null)) {
            serviceContext.setCommand(Constants.ADD);
        }

        JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

        extraDataJSONObject.put("title", entry.getSystemName());

        if (status == WorkflowConstants.STATUS_APPROVED) {

            // Asset

            assetEntryLocalService.updateEntry(
                    SystemEntry.class.getName(), entryId, entry.getModifiedDate(),
                    null, true, true);

            // Trash

            if (oldStatus == WorkflowConstants.STATUS_IN_TRASH) {
                CommentManagerUtil.restoreDiscussionFromTrash(
                        SystemEntry.class.getName(), entryId);

                _trashEntryLocalService.deleteEntry(
                        SystemEntry.class.getName(), entryId);
            }
        } else {

            // Asset

            assetEntryLocalService.updateVisible(
                    SystemEntry.class.getName(), entryId, false);

            // Trash

            if (status == WorkflowConstants.STATUS_IN_TRASH) {
                CommentManagerUtil.moveDiscussionToTrash(
                        SystemEntry.class.getName(), entryId);
                _trashEntryLocalService.addTrashEntry(
                        userId, entry.getGroupId(), SystemEntry.class.getName(),
                        entry.getPrimaryKey(), entry.getUuid(), null, oldStatus,
                        null, null);
            } else if (oldStatus == WorkflowConstants.STATUS_IN_TRASH) {
                CommentManagerUtil.restoreDiscussionFromTrash(
                        SystemEntry.class.getName(), entryId);

                _trashEntryLocalService.deleteEntry(
                        SystemEntry.class.getName(), entryId);
            }
        }

        return entry;
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
    protected SystemEntry _addEntry(SystemEntry entry, ServiceContext serviceContext)
            throws PortalException {

        long id = counterLocalService.increment(SystemEntry.class.getName());

        SystemEntry newEntry = systemEntryPersistence.create(id);

        User user = userLocalService.getUser(entry.getUserId());

        Date now = new Date();
        newEntry.setCompanyId(entry.getCompanyId());
        newEntry.setGroupId(entry.getGroupId());
        newEntry.setUserId(user.getUserId());
        newEntry.setUserName(user.getFullName());
        newEntry.setCreateDate(now);
        newEntry.setModifiedDate(now);

        newEntry.setUuid(serviceContext.getUuid());

        // Friendly URLs
        String urlTitle = getUniqueUrlTitle(newEntry, null);
        urlTitle = updateFriendlyURLs(newEntry, urlTitle, serviceContext);
        newEntry.setUrlTitle(urlTitle);


        newEntry.setSystemCode(entry.getSystemCode());
        newEntry.setSystemName(entry.getSystemName());
        newEntry.setSystemTitle(entry.getSystemTitle());
        newEntry.setSystemType(entry.getSystemType());
        newEntry.setDescription(entry.getDescription());
        newEntry.setStewardName(entry.getStewardName());
        newEntry.setStewardId(entry.getStewardId());
        newEntry.setStewardDepartment(entry.getStewardDepartment());
        newEntry.setBusinessOwnerName(entry.getBusinessOwnerName());
        newEntry.setBusinessOwnerId(entry.getBusinessOwnerId());
        newEntry.setContactPersonName(entry.getContactPersonName());
        newEntry.setContactPersonId(entry.getContactPersonId());
        newEntry.setSandboxName(entry.getSandboxName());
        newEntry.setGestorDepartmentId(entry.getGestorDepartmentId());
        newEntry.setGestorDepartmentName(entry.getGestorDepartmentName());
        newEntry.setRole(entry.getRole());
        newEntry.setSnowAssetTagId(entry.getSnowAssetTagId());
        newEntry.setSnowAssetTagName(entry.getSnowAssetTagName());
        newEntry.setIsSlaSigned(entry.getIsSlaSigned());
        newEntry.setIsSelfBi(entry.getIsSelfBi());
        newEntry.setIsActive(entry.getIsActive());
        /*  */

        return systemEntryPersistence.update(newEntry);
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
    protected SystemEntry _updateEntry(
            long primaryKey, SystemEntry entry, ServiceContext serviceContext)
            throws PortalException {

        SystemEntry updateEntry = fetchSystemEntry(primaryKey);

        User user = userLocalService.getUser(entry.getUserId());

        Date now = new Date();
        updateEntry.setCompanyId(entry.getCompanyId());
        updateEntry.setGroupId(entry.getGroupId());
        updateEntry.setUserId(user.getUserId());
        updateEntry.setUserName(user.getFullName());
        updateEntry.setCreateDate(entry.getCreateDate());
        updateEntry.setModifiedDate(now);

        updateEntry.setUuid(entry.getUuid());
        String urlTitle = getUniqueUrlTitle(entry, null);
        if (Validator.isNotNull(urlTitle)) {
            long classNameId = _classNameLocalService.getClassNameId(
                    SystemEntry.class);

            try {
                _friendlyURLEntryLocalService.validate(
                        entry.getGroupId(), classNameId, primaryKey, urlTitle);
            } catch (DuplicateFriendlyURLEntryException e) {
                List<String> error = new ArrayList<String>();
                error.add("duplicated-url-title");
                throw new SystemEntryValidateException(error);
            }
        }

        if (!urlTitle.equals(entry.getUrlTitle())) {
            urlTitle = updateFriendlyURLs(entry, urlTitle, serviceContext);
        }

        updateEntry.setUrlTitle(
                getUniqueUrlTitle(updateEntry, urlTitle));

        /*   */
        updateEntry.setSystemEntryId(entry.getSystemEntryId());
        updateEntry.setSystemCode(entry.getSystemCode());
        updateEntry.setSystemName(entry.getSystemName());
        updateEntry.setSystemTitle(entry.getSystemTitle());
        updateEntry.setSystemType(entry.getSystemType());
        updateEntry.setDescription(entry.getDescription());
        updateEntry.setStewardName(entry.getStewardName());
        updateEntry.setStewardId(entry.getStewardId());
        updateEntry.setStewardDepartment(entry.getStewardDepartment());
        updateEntry.setBusinessOwnerName(entry.getBusinessOwnerName());
        updateEntry.setBusinessOwnerId(entry.getBusinessOwnerId());
        updateEntry.setContactPersonName(entry.getContactPersonName());
        updateEntry.setContactPersonId(entry.getContactPersonId());
        updateEntry.setSandboxName(entry.getSandboxName());
        updateEntry.setGestorDepartmentId(entry.getGestorDepartmentId());
        updateEntry.setGestorDepartmentName(entry.getGestorDepartmentName());
        updateEntry.setRole(entry.getRole());
        updateEntry.setSnowAssetTagId(entry.getSnowAssetTagId());
        updateEntry.setSnowAssetTagName(entry.getSnowAssetTagName());
        updateEntry.setIsSlaSigned(entry.getIsSlaSigned());
        updateEntry.setIsSelfBi(entry.getIsSelfBi());
        updateEntry.setIsActive(entry.getIsActive());
        /*  */

        return updateEntry;
    }

    /**
     * Delete discussion (comments)
     *
     * @param entry
     * @throws PortalException
     */
    protected void deleteDiscussion(SystemEntry entry) throws PortalException {
        CommentManagerUtil.deleteDiscussion(
                SystemEntry.class.getName(), entry.getPrimaryKey());
    }

    /**
     * Generating a unique URL for asset
     */
    protected String getUniqueUrlTitle(SystemEntry entry, String newTitle) {
        long entryId = entry.getPrimaryKey();

        String urlTitle = null;
        String title = entry.getSystemName();
        String code = Long.toString(entry.getSystemCode());

        if (newTitle == null || newTitle.equals("")) {
            urlTitle = "meta_cds_system__" + String.valueOf(entryId);
            if (!Validator.isBlank(title)) {
                urlTitle += "__" + code+"_"+StringUtil.toLowerCase(title);
                ;
            }
        } else {
            urlTitle = StringUtil.toLowerCase(newTitle.trim());
            if (Validator.isNull(urlTitle) || Validator.isNumber(urlTitle) ||
                    urlTitle.equals("rss")) {

                urlTitle = "meta_cds_system__"+String.valueOf(entryId);
            }
        }

        urlTitle =
                FriendlyURLNormalizerUtil.normalizeWithPeriodsAndSlashes(
                        urlTitle);

        urlTitle = ModelHintsUtil.trimString(
                ColumnEntry.class.getName(), "urlTitle", urlTitle);

        long classNameId = _classNameLocalService.getClassNameId(
                ColumnEntry.class);

        return _friendlyURLEntryLocalService.getUniqueUrlTitle(
                entry.getGroupId(), classNameId, entry.getPrimaryKey(), urlTitle);
    }

    /**
     * Generating URL Title for unique URL
     *
     * @param entryId primaryKey of the model
     * @param title   title for the asset
     * @return URL title string
     */
    protected String getUrlTitle(long entryId, String title) {
        if (title == null) {
            return String.valueOf(entryId);
        }

        title = StringUtil.toLowerCase(title.trim());

        if (Validator.isNull(title) || Validator.isNumber(title)) {
            title = String.valueOf(entryId);
        } else {
            title = FriendlyURLNormalizerUtil.normalizeWithPeriodsAndSlashes(
                    title);
        }

        return ModelHintsUtil.trimString(
                SystemEntry.class.getName(), "urlTitle", title);
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
    protected SystemEntry startWorkflowInstance(
            long userId, SystemEntry entry, ServiceContext serviceContext)
            throws PortalException {

        Map<String, Serializable> workflowContext = new HashMap<>();

        String userPortraitURL = StringPool.BLANK;
        String userURL = StringPool.BLANK;

        if (serviceContext.getThemeDisplay() != null) {
            User user = userLocalService.getUser(userId);

            userPortraitURL = user.getPortraitURL(
                    serviceContext.getThemeDisplay());
            userURL = user.getDisplayURL(serviceContext.getThemeDisplay());
        }

        workflowContext.put(
                WorkflowConstants.CONTEXT_USER_PORTRAIT_URL, userPortraitURL);
        workflowContext.put(WorkflowConstants.CONTEXT_USER_URL, userURL);

        return WorkflowHandlerRegistryUtil.startWorkflowInstance(
                entry.getCompanyId(), entry.getGroupId(), userId,
                SystemEntry.class.getName(), entry.getPrimaryKey(), entry,
                serviceContext, workflowContext);
    }

    /**
     * Update Friendly URLs
     *
     * @param entry          SystemEntry
     * @param urlTitle
     * @param serviceContext
     * @return string
     * @throws PortalException
     */
    protected String updateFriendlyURLs(
            SystemEntry entry, String urlTitle,
            ServiceContext serviceContext)
            throws PortalException {

        if (ExportImportThreadLocal.isImportInProcess() ||
                ExportImportThreadLocal.isStagingInProcess()) {

            return urlTitle;
        }

        List<FriendlyURLEntry> friendlyURLEntries =
                _friendlyURLEntryLocalService.getFriendlyURLEntries(
                        entry.getGroupId(),
                        classNameLocalService.getClassNameId(SystemEntry.class),
                        entry.getPrimaryKey());

        FriendlyURLEntry newFriendlyURLEntry =
                _friendlyURLEntryLocalService.addFriendlyURLEntry(
                        entry.getGroupId(),
                        classNameLocalService.getClassNameId(SystemEntry.class),
                        entry.getPrimaryKey(), urlTitle, serviceContext);

        for (FriendlyURLEntry friendlyURLEntry : friendlyURLEntries) {
            if (newFriendlyURLEntry.getFriendlyURLEntryId() ==
                    friendlyURLEntry.getFriendlyURLEntryId()) {

                continue;
            }

            _friendlyURLEntryLocalService.deleteFriendlyURLEntry(friendlyURLEntry);
        }

        return newFriendlyURLEntry.getUrlTitle();
    }

    @Reference
    private ClassNameLocalService _classNameLocalService;

    @Reference
    private FriendlyURLEntryLocalService _friendlyURLEntryLocalService;

    @Reference
    private Portal _portal;

    @Reference
    private TrashEntryLocalService _trashEntryLocalService;

}
