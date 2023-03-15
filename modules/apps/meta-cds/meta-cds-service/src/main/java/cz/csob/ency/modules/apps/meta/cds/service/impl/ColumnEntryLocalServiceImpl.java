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
import cz.csob.ency.modules.apps.meta.cds.exception.ColumnEntryValidateException;
import cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry;
import cz.csob.ency.modules.apps.meta.cds.service.base.ColumnEntryLocalServiceBaseImpl;
import cz.csob.ency.modules.apps.meta.cds.service.util.ColumnEntryValidator;
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
 * The implementation of the ColumnEntry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>cz.csob.ency.modules.apps.meta.cds.service.ColumnEntryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Miroslav Čermák
 * @see ColumnEntryLocalServiceBaseImpl
 */
@Component(
        property = "model.class.name=cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry",
        service = AopService.class
)
public class ColumnEntryLocalServiceImpl extends ColumnEntryLocalServiceBaseImpl {

    private static final int[] STATUS_ANY = {
            WorkflowConstants.STATUS_APPROVED, WorkflowConstants.STATUS_DENIED,
            WorkflowConstants.STATUS_DRAFT, WorkflowConstants.STATUS_EXPIRED,
            WorkflowConstants.STATUS_IN_TRASH, WorkflowConstants.STATUS_INACTIVE,
            WorkflowConstants.STATUS_INCOMPLETE, WorkflowConstants.STATUS_PENDING,
            WorkflowConstants.STATUS_SCHEDULED
    };
    private static final Log _log = LogFactoryUtil.getLog(
            ColumnEntryLocalServiceImpl.class);

    /**
     * Add Entry
     *
     * @param orgEntry       ColumnEntry model
     * @param serviceContext ServiceContext
     * @return created ColumnEntry model.
     * @throws PortalException
     * @throws ColumnEntryValidateException
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public ColumnEntry addEntry(ColumnEntry orgEntry, ServiceContext serviceContext)
            throws PortalException, ColumnEntryValidateException {

        long userId = serviceContext.getUserId();

        // Validation

        ModelValidator<ColumnEntry> modelValidator = new ColumnEntryValidator();
        modelValidator.validate(orgEntry);

        ColumnEntry entry = _addEntry(orgEntry, serviceContext);

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

        ColumnEntry entry = columnEntryPersistence.findByPrimaryKey(entryId);

        addEntryResources(entry, addGroupPermissions, addGuestPermissions);
    }

    @Override
    public void addEntryResources(
            long entryId, ModelPermissions modelPermissions)
            throws PortalException {

        ColumnEntry entry = columnEntryPersistence.findByPrimaryKey(entryId);

        addEntryResources(entry, modelPermissions);
    }

    @Override
    public void addEntryResources(
            ColumnEntry entry, boolean addGroupPermissions,
            boolean addGuestPermissions)
            throws PortalException {

        resourceLocalService.addResources(
                entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
                ColumnEntry.class.getName(), entry.getPrimaryKey(), false,
                addGroupPermissions, addGuestPermissions);
    }

    @Override
    public void addEntryResources(
            ColumnEntry entry, ModelPermissions modelPermissions)
            throws PortalException {

        resourceLocalService.addModelResources(
                entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
                ColumnEntry.class.getName(), entry.getPrimaryKey(), modelPermissions);
    }

    public ColumnEntry addOrUpdateFromRow(
            Map<String, Object> row, ServiceContext serviceContext) throws PortalException {
        return addOrUpdateFromRow(row, serviceContext, false);
    }

    public ColumnEntry addOrUpdateFromRow(
            Map<String, Object> row, ServiceContext serviceContext, boolean validate) throws PortalException {

        long primaryKey = GetterUtil.getLong(row.getOrDefault("columnEntryId", 0));
        boolean isNew = false;
        ColumnEntry entry = null;

        if (primaryKey > 0) {
            entry = fetchColumnEntry(primaryKey);
        }

        if (Validator.isNull(entry)) {
            String columnFullName = GetterUtil.getString(row.getOrDefault("columnFullName", ""));
            if (!Validator.isBlank(columnFullName)) {
                entry = columnEntryPersistence.fetchByColumnFullName_First(
                        columnFullName, OrderByComparatorFactoryUtil.create(
                                "ColumnEntry", "columnFullName", true
                        ));
            }
        }

        if (Validator.isNull(entry)) {
            Boolean isActive = GetterUtil.getBoolean(GetterUtil.getString(row.get("isActive"), "true"));
            if (!isActive) return null;
            entry = getNewObject(0);
            isNew = true;
        }

        try {
            entry.setColumnName(GetterUtil.getString(row.get("columnName")));
            entry.setColumnPosition(GetterUtil.getLong(row.get("columnPosition"),0));
            entry.setColumnType(GetterUtil.getString(row.get("columnType")));
            entry.setColumnFullName(GetterUtil.getString(row.get("columnFullName")));
            entry.setTableName(GetterUtil.getString(row.get("tableName")));
            entry.setTableEntryId(GetterUtil.getLong(row.get("tableEntryId")));
            entry.setDatabaseName(GetterUtil.getString(row.get("databaseName")));
            entry.setSystemName(GetterUtil.getString(row.get("systemName")));
            entry.setDescription(GetterUtil.getString(row.get("description")));
            entry.setDataType(GetterUtil.getString(row.get("dataType")));
            entry.setDataSize(GetterUtil.getLong(row.get("dataSize")));
            entry.setIsPrimaryKey(1==GetterUtil.getLong(row.get("isPrimaryKey"), 0));
            entry.setIsNotNull(1==GetterUtil.getLong(row.get("isNotNull"), 0));
            entry.setIsActive(1==GetterUtil.getLong(row.get("isActive"), 0));
            entry.setCompanyId(serviceContext.getCompanyId());
            entry.setGroupId(serviceContext.getScopeGroupId());
            entry.setUserId(serviceContext.getUserId());

            if (isNew) {
                addEntry(entry, serviceContext);
            } else {
                updateEntry(entry, serviceContext);
            }
        } catch (ColumnEntryValidateException e) {
            throw e;
        } catch (Exception e) {
            _log.error("Errors occur while populating the model", e);
            throw e;
        }

        return entry;
    }

    public int countAllInGroup(long groupId) {
        int count = columnEntryPersistence.countByGroupId(groupId);

        return count;
    }

    public int countAllInGroup(long groupId, int[] status) {
        int count = columnEntryPersistence.countByG_S(groupId, status);

        return count;
    }

    public int countAllInUser(long userId) {
        int count = columnEntryPersistence.countByUserId(userId);

        return count;
    }

    public int countAllInUser(long userId, int[] status) {
        int count = columnEntryPersistence.countByU_S(userId, status);

        return count;
    }

    public int countAllInUserAndGroup(long userId, long groupId) {
        int count = columnEntryPersistence.countByUserIdGroupId(userId, groupId);

        return count;
    }

    public int countAllInUserAndGroup(long userId, long groupId, int[] status) {
        int count = columnEntryPersistence.countByG_U_S(groupId, userId, status);

        return count;
    }

    /**
     * Delete entry
     */
    public ColumnEntry deleteEntry(long primaryKey) throws PortalException {
        ColumnEntry entry = getColumnEntry(primaryKey);

        return deleteEntry(entry);
    }

    /**
     * Delete entry
     *
     * @param entry ColumnEntry
     * @return ColumnEntry oject
     * @throws PortalException
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    @SystemEvent(type = SystemEventConstants.TYPE_DELETE)
    public ColumnEntry deleteEntry(ColumnEntry entry) throws PortalException {

        // Entry

        columnEntryPersistence.remove(entry);

        // Resources

        resourceLocalService.deleteResource(
                entry.getCompanyId(), ColumnEntry.class.getName(),
                ResourceConstants.SCOPE_INDIVIDUAL, entry.getPrimaryKey());

        // Asset

        assetEntryLocalService.deleteEntry(
                ColumnEntry.class.getName(), entry.getPrimaryKey());

        // Comment

        deleteDiscussion(entry);

        // Friendly URL

        _friendlyURLEntryLocalService.deleteFriendlyURLEntry(
                entry.getGroupId(), ColumnEntry.class, entry.getPrimaryKey());

        // Trash

        _trashEntryLocalService.deleteEntry(
                ColumnEntry.class.getName(), entry.getPrimaryKey());

        // Workflow

        workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
                entry.getCompanyId(), entry.getGroupId(), ColumnEntry.class.getName(),
                entry.getPrimaryKey());

        return entry;
    }

    public List<ColumnEntry> findAllInGroup(long groupId) {
        List<ColumnEntry> list = (List<ColumnEntry>) columnEntryPersistence.findByGroupId(
                groupId);

        return list;
    }

    public List<ColumnEntry> findAllInGroup(
            long groupId, int start, int end,
            OrderByComparator<ColumnEntry> orderByComparator) {

        return findAllInGroup(
                groupId, start, end, orderByComparator,
                new int[]{WorkflowConstants.STATUS_APPROVED});
    }

    public List<ColumnEntry> findAllInGroup(
            long groupId, int start, int end,
            OrderByComparator<ColumnEntry> orderByComparator, int[] status) {

        List<ColumnEntry> list = (List<ColumnEntry>) columnEntryPersistence.findByG_S(
                groupId, status, start, end, orderByComparator);

        return list;
    }

    public List<ColumnEntry> findAllInGroup(long groupId, int[] status) {
        List<ColumnEntry> list = (List<ColumnEntry>) columnEntryPersistence.findByG_S(
                groupId, status);

        return list;
    }

    public List<ColumnEntry> findAllInGroup(
            long groupId, OrderByComparator<ColumnEntry> orderByComparator) {

        List<ColumnEntry> list = (List<ColumnEntry>) findAllInGroup(
                groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);

        return list;
    }

    public List<ColumnEntry> findAllInTable(long tableEntryId) {
        List<ColumnEntry> list =
                (List<ColumnEntry>) columnEntryPersistence.findByTableEntryId(tableEntryId);

        return list;
    }

    public List<ColumnEntry> findAllInUser(long userId) {
        List<ColumnEntry> list = (List<ColumnEntry>) columnEntryPersistence.findByUserId(
                userId);

        return list;
    }

    public List<ColumnEntry> findAllInUser(
            long userId, int start, int end,
            OrderByComparator<ColumnEntry> orderByComparator) {

        List<ColumnEntry> list = (List<ColumnEntry>) columnEntryPersistence.findByUserId(
                userId, start, end, orderByComparator);

        return list;
    }

    public List<ColumnEntry> findAllInUser(
            long userId, int start, int end,
            OrderByComparator<ColumnEntry> orderByComparator, int[] status) {

        List<ColumnEntry> list = (List<ColumnEntry>) columnEntryPersistence.findByU_S(
                userId, status, start, end, orderByComparator);

        return list;
    }

    public List<ColumnEntry> findAllInUser(long userId, int[] status) {
        List<ColumnEntry> list = (List<ColumnEntry>) columnEntryPersistence.findByU_S(
                userId, status);

        return list;
    }

    public List<ColumnEntry> findAllInUser(
            long userId, OrderByComparator<ColumnEntry> orderByComparator) {

        List<ColumnEntry> list = (List<ColumnEntry>) findAllInUser(
                userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);

        return list;
    }

    public List<ColumnEntry> findAllInUserAndGroup(long userId, long groupId) {
        List<ColumnEntry> list =
                (List<ColumnEntry>) columnEntryPersistence.findByUserIdGroupId(
                        userId, groupId);

        return list;
    }

    public List<ColumnEntry> findAllInUserAndGroup(
            long userId, long groupId, int start, int end,
            OrderByComparator<ColumnEntry> orderByComparator) {

        List<ColumnEntry> list =
                (List<ColumnEntry>) columnEntryPersistence.findByUserIdGroupId(
                        groupId, userId, start, end, orderByComparator);

        return list;
    }

    public List<ColumnEntry> findAllInUserAndGroup(
            long userId, long groupId, int start, int end,
            OrderByComparator<ColumnEntry> orderByComparator, int[] status) {

        List<ColumnEntry> list = (List<ColumnEntry>) columnEntryPersistence.findByG_U_S(
                groupId, userId, status, start, end, orderByComparator);

        return list;
    }

    public List<ColumnEntry> findAllInUserAndGroup(
            long userId, long groupId, int[] status) {

        List<ColumnEntry> list = (List<ColumnEntry>) columnEntryPersistence.findByG_U_S(
                groupId, userId, status);

        return list;
    }

    public List<ColumnEntry> findAllInUserAndGroup(
            long userId, long groupId,
            OrderByComparator<ColumnEntry> orderByComparator) {

        List<ColumnEntry> list = (List<ColumnEntry>) findAllInUserAndGroup(
                groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
                orderByComparator);

        return list;
    }

    /**
     * Get Entity
     *
     * @param groupId
     * @param urlTitle
     * @return
     * @throws PortalException
     */
    public ColumnEntry getColumnEntry(long groupId, String urlTitle)
            throws PortalException {

        FriendlyURLEntry friendlyURLEntry =
                _friendlyURLEntryLocalService.fetchFriendlyURLEntry(
                        groupId, ColumnEntry.class, urlTitle);

        if (friendlyURLEntry != null) {
            return columnEntryPersistence.findByPrimaryKey(
                    friendlyURLEntry.getClassPK());
        }

        return columnEntryPersistence.findByG_UT(groupId, urlTitle);
    }

    /**
     * Populate Model with values from a form
     *
     * @param request PortletRequest
     * @return ColumnEntry Object
     * @throws PortletException
     * @throws ColumnEntryValidateException
     */
    public ColumnEntry getColumnEntryFromRequest(
            long primaryKey, PortletRequest request)
            throws PortletException, ColumnEntryValidateException {

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(
                WebKeys.THEME_DISPLAY);

        // Create or fetch existing data

        ColumnEntry entry;

        if (primaryKey <= 0) {
            entry = getNewObject(primaryKey);
        } else {
            entry = fetchColumnEntry(primaryKey);
        }

        try {
            /*   */
            entry.setColumnEntryId(primaryKey);
            entry.setColumnType(ParamUtil.getString(request, "columnType"));
            entry.setColumnName(ParamUtil.getString(request, "columnName"));
            entry.setColumnPosition(ParamUtil.getLong(request, "columnPosition"));
            entry.setColumnFullName(ParamUtil.getString(request, "columnFullName"));
            entry.setTableEntryId(ParamUtil.getLong(request, "tableEntryId"));
            entry.setTableName(ParamUtil.getString(request, "tableName"));
            entry.setSystemName(ParamUtil.getString(request, "systemName"));
            entry.setDatabaseName(ParamUtil.getString(request, "databaseName"));
            entry.setDescription(ParamUtil.getString(request, "description"));
            entry.setDataType(ParamUtil.getString(request, "dataType"));
            entry.setDataSize(ParamUtil.getLong(request, "dataSize"));
            entry.setIsPrimaryKey(ParamUtil.getBoolean(request, "isPrimaryKey"));
            entry.setIsNotNull(ParamUtil.getBoolean(request, "isNotNull"));
            entry.setIsActive(ParamUtil.getBoolean(request, "isActive"));
            entry.setCompanyId(themeDisplay.getCompanyId());
            entry.setGroupId(themeDisplay.getScopeGroupId());
            entry.setUserId(themeDisplay.getUserId());
        } catch (Exception e) {
            _log.error("Errors occur while populating the model", e);
            List<String> error = new ArrayList<>();
            error.add("value-convert-error");

            throw new ColumnEntryValidateException(error);
        }

        return entry;
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
    public List<ColumnEntry> getCompanyEntries(
            long companyId, int status, int start, int end) {

        if (status == WorkflowConstants.STATUS_ANY) {
            return columnEntryPersistence.findByCompanyId(companyId, start, end);
        }

        return columnEntryPersistence.findByC_S(companyId, status, start, end);
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
    public List<ColumnEntry> getCompanyEntries(
            long companyId, int status, int start, int end,
            OrderByComparator<ColumnEntry> obc) {

        if (status == WorkflowConstants.STATUS_ANY) {
            return columnEntryPersistence.findByCompanyId(
                    companyId, start, end, obc);
        }

        return columnEntryPersistence.findByC_S(
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
            return columnEntryPersistence.countByCompanyId(companyId);
        }

        return columnEntryPersistence.countByC_S(companyId, status);
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
     * @return ColumnEntry Object
     * @throws PortletException
     */
    public ColumnEntry getInitializedColumnEntry(
            long primaryKey, PortletRequest request)
            throws PortletException {

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(
                WebKeys.THEME_DISPLAY);

        // Create or fetch existing data

        ColumnEntry entry = getNewObject(primaryKey);

        /*   */
        entry.setColumnEntryId(primaryKey);
        entry.setColumnType("");
        entry.setColumnName("");
        entry.setColumnPosition(0);
        entry.setColumnFullName("");
        entry.setTableEntryId(0);
        entry.setTableName("");
        entry.setSystemName("");
        entry.setDatabaseName("");
        entry.setDescription("");
        entry.setDataType("");
        entry.setDataSize(0);
        entry.setIsPrimaryKey(true);
        entry.setIsNotNull(true);
        entry.setIsActive(true);
        entry.setCompanyId(themeDisplay.getCompanyId());
        entry.setGroupId(themeDisplay.getScopeGroupId());
        entry.setUserId(themeDisplay.getUserId());

        return entry;
    }

    /**
     * Get Record
     *
     * @param primaryKey Primary key
     * @return ColumnEntry object
     * @throws PortletException
     */
    public ColumnEntry getNewObject(long primaryKey) {
        primaryKey = (primaryKey <= 0) ? 0 :
                counterLocalService.increment(ColumnEntry.class.getName());

        return createColumnEntry(primaryKey);
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

    public ColumnEntry moveEntryToTrash(long userId, long entryId)
            throws PortalException {

        ColumnEntry entry = columnEntryPersistence.findByPrimaryKey(entryId);

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
    public ColumnEntry moveEntryToTrash(long userId, ColumnEntry entry)
            throws PortalException {

        // Entry

        if (entry.isInTrash()) {
            throw new TrashEntryException();
        }

        int oldStatus = entry.getStatus();

        if (oldStatus == WorkflowConstants.STATUS_PENDING) {
            entry.setStatus(WorkflowConstants.STATUS_DRAFT);

            columnEntryPersistence.update(entry);
        }

        entry = updateStatus(
                userId, entry.getPrimaryKey(), WorkflowConstants.STATUS_IN_TRASH,
                new ServiceContext(), new HashMap<String, Serializable>());

        // Workflow

        if (oldStatus == WorkflowConstants.STATUS_PENDING) {
            workflowInstanceLinkLocalService.deleteWorkflowInstanceLink(
                    entry.getCompanyId(), entry.getGroupId(),
                    ColumnEntry.class.getName(), entry.getPrimaryKey());
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
    public ColumnEntry restoreEntryFromTrash(long userId, long entryId)
            throws PortalException {

        // Entry

        ColumnEntry entry = columnEntryPersistence.findByPrimaryKey(entryId);

        if (!entry.isInTrash()) {
            throw new RestoreEntryException(
                    RestoreEntryException.INVALID_STATUS);
        }

        TrashEntry trashEntry = _trashEntryLocalService.getEntry(
                ColumnEntry.class.getName(), entryId);

        updateStatus(
                userId, entryId, trashEntry.getStatus(), new ServiceContext(),
                new HashMap<String, Serializable>());

        return entry;
    }

    @Override
    public void updateAsset(
            long userId, ColumnEntry entry, long[] assetCategoryIds,
            String[] assetTagNames, long[] assetLinkEntryIds, Double priority)
            throws PortalException {

        boolean visible = false;

        if (entry.isApproved()) {
            visible = true;
        }

        String summary = StringUtil.shorten(entry.getColumnFullName(), 500);

        AssetEntry assetEntry = assetEntryLocalService.updateEntry(
                userId, entry.getGroupId(), entry.getCreateDate(),
                entry.getModifiedDate(), ColumnEntry.class.getName(),
                entry.getPrimaryKey(), entry.getUuid(), 0, assetCategoryIds,
                assetTagNames, true, visible, null, null, null, null,
                ContentTypes.TEXT_HTML, entry.getColumnName(), null, summary,
                null, null, 0, 0, priority);

        assetLinkLocalService.updateLinks(
                userId, assetEntry.getEntryId(), assetLinkEntryIds,
                AssetLinkConstants.TYPE_RELATED);
    }

    /**
     * Edit Entry
     *
     * @param orgEntry       ColumnEntry model
     * @param serviceContext ServiceContext
     * @return updated ColumnEntry model.
     * @throws PortalException
     * @throws ColumnEntryValidateException
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public ColumnEntry updateEntry(
            ColumnEntry orgEntry, ServiceContext serviceContext)
            throws PortalException, ColumnEntryValidateException {

        User user = userLocalService.getUser(orgEntry.getUserId());

        // Validation

        ModelValidator<ColumnEntry> modelValidator = new ColumnEntryValidator();
        modelValidator.validate(orgEntry);

        // Update entry

        ColumnEntry entry = _updateEntry(
                orgEntry.getPrimaryKey(), orgEntry, serviceContext);

        if (!entry.isPending() && !entry.isDraft()) {
            entry.setStatus(WorkflowConstants.STATUS_DRAFT);
        }


        if(orgEntry.equals(entry)) {
            return entry;
        }

        ColumnEntry updatedEntry = columnEntryPersistence.update(entry);

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
            ColumnEntry entry, String[] groupPermissions,
            String[] guestPermissions)
            throws PortalException {

        resourceLocalService.updateResources(
                entry.getCompanyId(), entry.getGroupId(), ColumnEntry.class.getName(),
                entry.getPrimaryKey(), groupPermissions, guestPermissions);
    }

    @Indexable(type = IndexableType.REINDEX)
    public ColumnEntry updateStatus(
            long userId, long entryId, int status,
            ServiceContext serviceContext,
            Map<String, Serializable> workflowContext)
            throws PortalException {

        // Entry

        User user = userLocalService.getUser(userId);
        Date now = new Date();

        ColumnEntry entry = columnEntryPersistence.findByPrimaryKey(entryId);

        int oldStatus = entry.getStatus();

        entry.setModifiedDate(serviceContext.getModifiedDate(now));
        entry.setStatus(status);
        entry.setStatusByUserId(user.getUserId());
        entry.setStatusByUserName(user.getFullName());
        entry.setStatusDate(serviceContext.getModifiedDate(now));

        columnEntryPersistence.update(entry);

        AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
                ColumnEntry.class.getName(), entryId);

        if ((assetEntry == null) || (assetEntry.getPublishDate() == null)) {
            serviceContext.setCommand(Constants.ADD);
        }

        JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

        extraDataJSONObject.put("title", entry.getColumnName());

        if (status == WorkflowConstants.STATUS_APPROVED) {

            // Asset

            assetEntryLocalService.updateEntry(
                    ColumnEntry.class.getName(), entryId, entry.getModifiedDate(),
                    null, true, true);

            // Trash

            if (oldStatus == WorkflowConstants.STATUS_IN_TRASH) {
                CommentManagerUtil.restoreDiscussionFromTrash(
                        ColumnEntry.class.getName(), entryId);

                _trashEntryLocalService.deleteEntry(
                        ColumnEntry.class.getName(), entryId);
            }
        } else {

            // Asset

            assetEntryLocalService.updateVisible(
                    ColumnEntry.class.getName(), entryId, false);

            // Trash

            if (status == WorkflowConstants.STATUS_IN_TRASH) {
                CommentManagerUtil.moveDiscussionToTrash(
                        ColumnEntry.class.getName(), entryId);
                _trashEntryLocalService.addTrashEntry(
                        userId, entry.getGroupId(), ColumnEntry.class.getName(),
                        entry.getPrimaryKey(), entry.getUuid(), null, oldStatus,
                        null, null);
            } else if (oldStatus == WorkflowConstants.STATUS_IN_TRASH) {
                CommentManagerUtil.restoreDiscussionFromTrash(
                        ColumnEntry.class.getName(), entryId);

                _trashEntryLocalService.deleteEntry(
                        ColumnEntry.class.getName(), entryId);
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
    protected ColumnEntry _addEntry(ColumnEntry entry, ServiceContext serviceContext)
            throws PortalException {

        long id = counterLocalService.increment(ColumnEntry.class.getName());

        ColumnEntry newEntry = columnEntryPersistence.create(id);

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


        newEntry.setColumnType(entry.getColumnType());
        newEntry.setColumnName(entry.getColumnName());
        newEntry.setColumnPosition(entry.getColumnPosition());
        newEntry.setColumnFullName(entry.getColumnFullName());
        newEntry.setTableEntryId(entry.getTableEntryId());
        newEntry.setTableName(entry.getTableName());
        newEntry.setSystemName(entry.getSystemName());
        newEntry.setDatabaseName(entry.getDatabaseName());
        newEntry.setDescription(entry.getDescription());
        newEntry.setDataType(entry.getDataType());
        newEntry.setDataSize(entry.getDataSize());
        newEntry.setIsPrimaryKey(entry.getIsPrimaryKey());
        newEntry.setIsNotNull(entry.getIsNotNull());
        newEntry.setIsActive(entry.getIsActive());
        /*  */

        return columnEntryPersistence.update(newEntry);
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
    protected ColumnEntry _updateEntry(
            long primaryKey, ColumnEntry entry, ServiceContext serviceContext)
            throws PortalException {

        ColumnEntry updateEntry = fetchColumnEntry(primaryKey);

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
                    ColumnEntry.class);

            try {
                _friendlyURLEntryLocalService.validate(
                        entry.getGroupId(), classNameId, primaryKey, urlTitle);
            } catch (DuplicateFriendlyURLEntryException e) {
                List<String> error = new ArrayList<String>();
                _log.debug("duplicated-url-title: " + urlTitle);
                error.add("duplicated-url-title");
                throw new ColumnEntryValidateException(error);
            }
        }

        if (!urlTitle.equals(entry.getUrlTitle())) {
            urlTitle = updateFriendlyURLs(entry, urlTitle, serviceContext);
        }

        updateEntry.setUrlTitle(
                getUniqueUrlTitle(updateEntry, urlTitle));

        updateEntry.setColumnEntryId(entry.getColumnEntryId());
        updateEntry.setColumnType(entry.getColumnType());
        updateEntry.setColumnName(entry.getColumnName());
        updateEntry.setColumnPosition(entry.getColumnPosition());
        updateEntry.setColumnFullName(entry.getColumnFullName());
        updateEntry.setTableEntryId(entry.getTableEntryId());
        updateEntry.setTableName(entry.getTableName());
        updateEntry.setSystemName(entry.getSystemName());
        updateEntry.setDatabaseName(entry.getDatabaseName());
        updateEntry.setDescription(entry.getDescription());
        updateEntry.setDataType(entry.getDataType());
        updateEntry.setDataSize(entry.getDataSize());
        updateEntry.setIsPrimaryKey(entry.getIsPrimaryKey());
        updateEntry.setIsNotNull(entry.getIsNotNull());
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
    protected void deleteDiscussion(ColumnEntry entry) throws PortalException {
        CommentManagerUtil.deleteDiscussion(
                ColumnEntry.class.getName(), entry.getPrimaryKey());
    }

    /**
     * Generating a unique URL for asset
     */
    protected String getUniqueUrlTitle(ColumnEntry entry, String newTitle) {
        long entryId = entry.getPrimaryKey();
        String title = entry.getColumnName();

        String urlTitle = null;

        if (newTitle == null || newTitle.equals("")) {
            urlTitle = "meta_cds_column__" + String.valueOf(entryId);
            if (!Validator.isBlank(title)) {
                urlTitle += "__" + StringUtil.toLowerCase(title);
                ;
            }
        } else {
            urlTitle = StringUtil.toLowerCase(newTitle.trim());
            if (Validator.isNull(urlTitle) || Validator.isNumber(urlTitle) ||
                    urlTitle.equals("rss")) {

                urlTitle = "meta_cds_column__"+String.valueOf(entryId);
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
                ColumnEntry.class.getName(), "urlTitle", title);
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
    protected ColumnEntry startWorkflowInstance(
            long userId, ColumnEntry entry, ServiceContext serviceContext)
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
                ColumnEntry.class.getName(), entry.getPrimaryKey(), entry,
                serviceContext, workflowContext);
    }

    /**
     * Update Friendly URLs
     *
     * @param entry          ColumnEntry
     * @param urlTitle
     * @param serviceContext
     * @return string
     * @throws PortalException
     */
    protected String updateFriendlyURLs(
            ColumnEntry entry, String urlTitle,
            ServiceContext serviceContext)
            throws PortalException {

        if (ExportImportThreadLocal.isImportInProcess() ||
                ExportImportThreadLocal.isStagingInProcess()) {

            return urlTitle;
        }

        List<FriendlyURLEntry> friendlyURLEntries =
                _friendlyURLEntryLocalService.getFriendlyURLEntries(
                        entry.getGroupId(),
                        classNameLocalService.getClassNameId(ColumnEntry.class),
                        entry.getPrimaryKey());

        FriendlyURLEntry newFriendlyURLEntry =
                _friendlyURLEntryLocalService.addFriendlyURLEntry(
                        entry.getGroupId(),
                        classNameLocalService.getClassNameId(ColumnEntry.class),
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
