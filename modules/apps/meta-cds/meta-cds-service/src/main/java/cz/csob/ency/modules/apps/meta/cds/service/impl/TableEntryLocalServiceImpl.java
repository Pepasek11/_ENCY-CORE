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
import cz.csob.ency.modules.apps.meta.cds.exception.TableEntryValidateException;
import cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry;
import cz.csob.ency.modules.apps.meta.cds.model.TableEntry;
import cz.csob.ency.modules.apps.meta.cds.service.SystemEntryLocalServiceUtil;
import cz.csob.ency.modules.apps.meta.cds.service.base.TableEntryLocalServiceBaseImpl;
import cz.csob.ency.modules.apps.meta.cds.service.util.TableEntryValidator;
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
 * The implementation of the TableEntry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>cz.csob.ency.modules.apps.meta.cds.service.TableEntryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Miroslav Čermák
 * @see TableEntryLocalServiceBaseImpl
 */
@Component(
        property = "model.class.name=cz.csob.ency.modules.apps.meta.cds.model.TableEntry",
        service = AopService.class
)
public class TableEntryLocalServiceImpl extends TableEntryLocalServiceBaseImpl {

    private static final int[] STATUS_ANY = {
            WorkflowConstants.STATUS_APPROVED, WorkflowConstants.STATUS_DENIED,
            WorkflowConstants.STATUS_DRAFT, WorkflowConstants.STATUS_EXPIRED,
            WorkflowConstants.STATUS_IN_TRASH, WorkflowConstants.STATUS_INACTIVE,
            WorkflowConstants.STATUS_INCOMPLETE, WorkflowConstants.STATUS_PENDING,
            WorkflowConstants.STATUS_SCHEDULED
    };
    private static final Log _log = LogFactoryUtil.getLog(
            TableEntryLocalServiceImpl.class);

    /**
     * Add Entry
     *
     * @param orgEntry       TableEntry model
     * @param serviceContext ServiceContext
     * @return created TableEntry model.
     * @throws PortalException
     * @throws TableEntryValidateException
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public TableEntry addEntry(TableEntry orgEntry, ServiceContext serviceContext)
            throws PortalException, TableEntryValidateException {

        long userId = serviceContext.getUserId();

        // Validation

        ModelValidator<TableEntry> modelValidator = new TableEntryValidator();
        modelValidator.validate(orgEntry);

        TableEntry entry = _addEntry(orgEntry, serviceContext);

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

        TableEntry entry = tableEntryPersistence.findByPrimaryKey(entryId);

        addEntryResources(entry, addGroupPermissions, addGuestPermissions);
    }

    @Override
    public void addEntryResources(
            long entryId, ModelPermissions modelPermissions)
            throws PortalException {

        TableEntry entry = tableEntryPersistence.findByPrimaryKey(entryId);

        addEntryResources(entry, modelPermissions);
    }

    @Override
    public void addEntryResources(
            TableEntry entry, boolean addGroupPermissions,
            boolean addGuestPermissions)
            throws PortalException {

        resourceLocalService.addResources(
                entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
                TableEntry.class.getName(), entry.getPrimaryKey(), false,
                addGroupPermissions, addGuestPermissions);
    }

    @Override
    public void addEntryResources(
            TableEntry entry, ModelPermissions modelPermissions)
            throws PortalException {

        resourceLocalService.addModelResources(
                entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
                TableEntry.class.getName(), entry.getPrimaryKey(), modelPermissions);
    }

    public TableEntry addOrUpdateFromRow(
            Map<String, Object> row, ServiceContext serviceContext) throws PortalException {
        return addOrUpdateFromRow(row, serviceContext, false);
    }



    public TableEntry addOrUpdateFromRow(
            Map<String, Object> row, ServiceContext serviceContext, boolean validate)
            throws PortalException {

        long primaryKey = GetterUtil.getLong(row.getOrDefault("tableEntryId", 0));
        boolean isNew = false;
        TableEntry entry = null;

        if (primaryKey > 0) {
            entry = fetchTableEntry(primaryKey);
        }

        if (Validator.isNull(entry)) {
            String tableFullName = GetterUtil.getString(row.getOrDefault("tableFullName", ""));
            if (!Validator.isBlank(tableFullName)) {
                entry = tableEntryPersistence.fetchByTableFullName_First(
                        tableFullName, OrderByComparatorFactoryUtil.create(
                                "TableEntry", "tableFullName", true
                        ));
              //  _log.debug("Fetching entry with code " + tableFullName + " and have " + entry);
            }
        }

        if (Validator.isNull(entry)) {
            entry = getNewObject(0);
            isNew = true;
        }

        try {
            entry.setTableName(GetterUtil.getString(row.get("tableName")));
            entry.setTableFullName(GetterUtil.getString(row.get("tableFullName")));
            entry.setTableType(GetterUtil.getString(row.get("tableType")));
            entry.setDescription(GetterUtil.getString(row.get("description")));
            entry.setTableDatabase(GetterUtil.getString(row.get("tableDatabase")));
            entry.setSystemEntryId(GetterUtil.getLong(row.get("systemEntryId")));
            entry.setSystemName(GetterUtil.getString(row.get("systemName")));
            entry.setDsaUrl(GetterUtil.getString(row.get("dsaUrl")));
            entry.setUnstructuredClause(GetterUtil.getString(row.get("unstructuredClause")));
            entry.setContactPersonName(GetterUtil.getString(row.get("contactPersonName")));
            entry.setSpecificationOwnerName(GetterUtil.getString(row.get("specificationOwnerName")));
            entry.setIsActive(1==GetterUtil.getLong(row.get("isActive"), 0));
            entry.setCompanyId(serviceContext.getCompanyId());
            entry.setGroupId(serviceContext.getScopeGroupId());
            entry.setUserId(serviceContext.getUserId());

            if (isNew) {
                addEntry(entry, serviceContext);
            } else {
                updateEntry(entry, serviceContext);
            }
        } catch (TableEntryValidateException e) {
            throw e;
        } catch (Exception e) {
            _log.error("Errors occur while populating the model", e);
            throw e;
        }

        return entry;
    }

    public int countAllInGroup(long groupId) {
        int count = tableEntryPersistence.countByGroupId(groupId);

        return count;
    }

    public int countAllInGroup(long groupId, int[] status) {
        int count = tableEntryPersistence.countByG_S(groupId, status);

        return count;
    }

    public int countAllInUser(long userId) {
        int count = tableEntryPersistence.countByUserId(userId);

        return count;
    }

    public int countAllInUser(long userId, int[] status) {
        int count = tableEntryPersistence.countByU_S(userId, status);

        return count;
    }

    public int countAllInUserAndGroup(long userId, long groupId) {
        int count = tableEntryPersistence.countByUserIdGroupId(userId, groupId);

        return count;
    }

    public int countAllInUserAndGroup(long userId, long groupId, int[] status) {
        int count = tableEntryPersistence.countByG_U_S(groupId, userId, status);

        return count;
    }

    /**
     * Delete entry
     */
    public TableEntry deleteEntry(long primaryKey) throws PortalException {
        TableEntry entry = getTableEntry(primaryKey);

        return deleteEntry(entry);
    }

    /**
     * Delete entry
     *
     * @param entry TableEntry
     * @return TableEntry oject
     * @throws PortalException
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    @SystemEvent(type = SystemEventConstants.TYPE_DELETE)
    public TableEntry deleteEntry(TableEntry entry) throws PortalException {

        // Entry

        tableEntryPersistence.remove(entry);

        // Resources

        resourceLocalService.deleteResource(
                entry.getCompanyId(), TableEntry.class.getName(),
                ResourceConstants.SCOPE_INDIVIDUAL, entry.getPrimaryKey());

        // Asset

        assetEntryLocalService.deleteEntry(
                TableEntry.class.getName(), entry.getPrimaryKey());

        // Comment

        deleteDiscussion(entry);

        // Friendly URL

        _friendlyURLEntryLocalService.deleteFriendlyURLEntry(
                entry.getGroupId(), TableEntry.class, entry.getPrimaryKey());

        // Trash

        _trashEntryLocalService.deleteEntry(
                TableEntry.class.getName(), entry.getPrimaryKey());

        // Workflow

        workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
                entry.getCompanyId(), entry.getGroupId(), TableEntry.class.getName(),
                entry.getPrimaryKey());

        return entry;
    }

    public TableEntry fetchEntryByTableFullName(String tableFullName) {
        return tableEntryPersistence.fetchByTableFullName_First(
                tableFullName
                , OrderByComparatorFactoryUtil.create(
                        "TableEntry", "tableFullName", true));
    }

    public List<TableEntry> findAllInSystem(
            long systemEntryId) {
        List<TableEntry> list = tableEntryPersistence.findBySystemEntryId(systemEntryId);
        return list;

    }

    public List<TableEntry> findAllInSystemDatabase(
            long systemEntryId, String tableDatabase) {

        return (List<TableEntry>) tableEntryPersistence.findByS_D(systemEntryId,tableDatabase);

    }

    public List<TableEntry> findAllInSystemDatabase(
           long systemEntryId, String tableDatabase[]) {

        return (List<TableEntry>) tableEntryPersistence.findByS_D(systemEntryId,tableDatabase);
    }

    public List<TableEntry> findAllInSystemType(
            long systemEntryId, String tableType) {

        return (List<TableEntry>) tableEntryPersistence.findByS_T(systemEntryId,tableType);

    }

    public List<TableEntry> findAllInSystemType(
           long systemEntryId, String tableType[]) {

        return (List<TableEntry>) tableEntryPersistence.findByS_T(systemEntryId,tableType);
    }

    public List<TableEntry> findAllInGroup(long groupId) {
        List<TableEntry> list = (List<TableEntry>) tableEntryPersistence.findByGroupId(
                groupId);

        return list;
    }

    public List<TableEntry> findAllInGroup(
            long groupId, int start, int end,
            OrderByComparator<TableEntry> orderByComparator) {

        return findAllInGroup(
                groupId, start, end, orderByComparator,
                new int[]{WorkflowConstants.STATUS_APPROVED});
    }

    public List<TableEntry> findAllInGroup(
            long groupId, int start, int end,
            OrderByComparator<TableEntry> orderByComparator, int[] status) {

        List<TableEntry> list = (List<TableEntry>) tableEntryPersistence.findByG_S(
                groupId, status, start, end, orderByComparator);

        return list;
    }

    public List<TableEntry> findAllInGroup(long groupId, int[] status) {
        List<TableEntry> list = (List<TableEntry>) tableEntryPersistence.findByG_S(
                groupId, status);

        return list;
    }

    public List<TableEntry> findAllInGroup(
            long groupId, OrderByComparator<TableEntry> orderByComparator) {

        List<TableEntry> list = (List<TableEntry>) findAllInGroup(
                groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);

        return list;
    }

    public List<TableEntry> findAllInUser(long userId) {
        List<TableEntry> list = (List<TableEntry>) tableEntryPersistence.findByUserId(
                userId);

        return list;
    }

    public List<TableEntry> findAllInUser(
            long userId, int start, int end,
            OrderByComparator<TableEntry> orderByComparator) {

        List<TableEntry> list = (List<TableEntry>) tableEntryPersistence.findByUserId(
                userId, start, end, orderByComparator);

        return list;
    }

    public List<TableEntry> findAllInUser(
            long userId, int start, int end,
            OrderByComparator<TableEntry> orderByComparator, int[] status) {

        List<TableEntry> list = (List<TableEntry>) tableEntryPersistence.findByU_S(
                userId, status, start, end, orderByComparator);

        return list;
    }

    public List<TableEntry> findAllInUser(long userId, int[] status) {
        List<TableEntry> list = (List<TableEntry>) tableEntryPersistence.findByU_S(
                userId, status);

        return list;
    }

    public List<TableEntry> findAllInUser(
            long userId, OrderByComparator<TableEntry> orderByComparator) {

        List<TableEntry> list = (List<TableEntry>) findAllInUser(
                userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);

        return list;
    }

    public List<TableEntry> findAllInUserAndGroup(long userId, long groupId) {
        List<TableEntry> list =
                (List<TableEntry>) tableEntryPersistence.findByUserIdGroupId(
                        userId, groupId);

        return list;
    }

    public List<TableEntry> findAllInUserAndGroup(
            long userId, long groupId, int start, int end,
            OrderByComparator<TableEntry> orderByComparator) {

        List<TableEntry> list =
                (List<TableEntry>) tableEntryPersistence.findByUserIdGroupId(
                        groupId, userId, start, end, orderByComparator);

        return list;
    }

    public List<TableEntry> findAllInUserAndGroup(
            long userId, long groupId, int start, int end,
            OrderByComparator<TableEntry> orderByComparator, int[] status) {

        List<TableEntry> list = (List<TableEntry>) tableEntryPersistence.findByG_U_S(
                groupId, userId, status, start, end, orderByComparator);

        return list;
    }

    public List<TableEntry> findAllInUserAndGroup(
            long userId, long groupId, int[] status) {

        List<TableEntry> list = (List<TableEntry>) tableEntryPersistence.findByG_U_S(
                groupId, userId, status);

        return list;
    }

    public List<TableEntry> findAllInUserAndGroup(
            long userId, long groupId,
            OrderByComparator<TableEntry> orderByComparator) {

        List<TableEntry> list = (List<TableEntry>) findAllInUserAndGroup(
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
    public List<TableEntry> getCompanyEntries(
            long companyId, int status, int start, int end) {

        if (status == WorkflowConstants.STATUS_ANY) {
            return tableEntryPersistence.findByCompanyId(companyId, start, end);
        }

        return tableEntryPersistence.findByC_S(companyId, status, start, end);
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
    public List<TableEntry> getCompanyEntries(
            long companyId, int status, int start, int end,
            OrderByComparator<TableEntry> obc) {

        if (status == WorkflowConstants.STATUS_ANY) {
            return tableEntryPersistence.findByCompanyId(
                    companyId, start, end, obc);
        }

        return tableEntryPersistence.findByC_S(
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
            return tableEntryPersistence.countByCompanyId(companyId);
        }

        return tableEntryPersistence.countByC_S(companyId, status);
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
     * @return TableEntry Object
     * @throws PortletException
     */
    public TableEntry getInitializedTableEntry(
            long primaryKey, PortletRequest request)
            throws PortletException {

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(
                WebKeys.THEME_DISPLAY);

        // Create or fetch existing data

        TableEntry entry = getNewObject(primaryKey);

        /*   */
        entry.setTableEntryId(primaryKey);
        entry.setTableName("");
        entry.setTableFullName("");
        entry.setTableType("");
        entry.setTableDatabase("");
        entry.setSystemEntryId(0);
        entry.setSystemName("");
        entry.setDescription("");
        entry.setDsaUrl("");
        entry.setContactPersonName("");
        entry.setContactPersonId("");
        entry.setSpecificationOwnerName("");
        entry.setSpecificationOwnerId("");
        entry.setUnstructuredClause("");
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
     * @return TableEntry object
     * @throws PortletException
     */
    public TableEntry getNewObject(long primaryKey) {
        primaryKey = (primaryKey <= 0) ? 0 :
                counterLocalService.increment(TableEntry.class.getName());

        return createTableEntry(primaryKey);
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
    public TableEntry getTableEntry(long groupId, String urlTitle)
            throws PortalException {

        FriendlyURLEntry friendlyURLEntry =
                _friendlyURLEntryLocalService.fetchFriendlyURLEntry(
                        groupId, TableEntry.class, urlTitle);

        if (friendlyURLEntry != null) {
            return tableEntryPersistence.findByPrimaryKey(
                    friendlyURLEntry.getClassPK());
        }

        return tableEntryPersistence.findByG_UT(groupId, urlTitle);
    }

    /**
     * Populate Model with values from a form
     *
     * @param request PortletRequest
     * @return TableEntry Object
     * @throws PortletException
     * @throws TableEntryValidateException
     */
    public TableEntry getTableEntryFromRequest(
            long primaryKey, PortletRequest request)
            throws PortletException, TableEntryValidateException {

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(
                WebKeys.THEME_DISPLAY);

        // Create or fetch existing data

        TableEntry entry;

        if (primaryKey <= 0) {
            entry = getNewObject(primaryKey);
        } else {
            entry = fetchTableEntry(primaryKey);
        }

        try {
            /*   */
            entry.setTableEntryId(primaryKey);
            entry.setTableName(ParamUtil.getString(request, "tableName"));
            entry.setTableFullName(ParamUtil.getString(request, "tableFullName"));
            entry.setTableType(ParamUtil.getString(request, "tableType"));
            entry.setTableDatabase(ParamUtil.getString(request, "tableDatabase"));
            entry.setSystemEntryId(ParamUtil.getLong(request, "systemEntryId"));
            entry.setSystemName(ParamUtil.getString(request, "systemName"));
            entry.setDescription(ParamUtil.getString(request, "description"));
            entry.setDsaUrl(ParamUtil.getString(request, "dsaUrl"));
            entry.setContactPersonName(ParamUtil.getString(request, "contactPersonName"));
            entry.setContactPersonId(ParamUtil.getString(request, "contactPersonId"));
            entry.setSpecificationOwnerName(ParamUtil.getString(request, "specificationOwnerName"));
            entry.setSpecificationOwnerId(ParamUtil.getString(request, "specificationOwnerId"));
            entry.setUnstructuredClause(ParamUtil.getString(request, "unstructuredClause"));
            entry.setIsActive(ParamUtil.getBoolean(request, "isActive"));
            entry.setCompanyId(themeDisplay.getCompanyId());
            entry.setGroupId(themeDisplay.getScopeGroupId());
            entry.setUserId(themeDisplay.getUserId());
        } catch (Exception e) {
            _log.error("Errors occur while populating the model", e);
            List<String> error = new ArrayList<>();
            error.add("value-convert-error");

            throw new TableEntryValidateException(error);
        }

        return entry;
    }

    public List<TableEntry> getSystemTables(Long systemId) {
        return getSystemTables(systemId, "");
    }

    public List<TableEntry> getSystemTables(Long systemEntryId, String type) {
        List<TableEntry> list = new ArrayList<>();

        if(0>=systemEntryId) return list;

        switch (type) {
            case "tables":
                list = findAllInSystemDatabase(systemEntryId,new String[]{"DP_TCDS","DP_DCDS"});
                        break;
            case "views":
                list = findAllInSystemType(systemEntryId, "VW");
                        break;
            case "stage":
                list = findAllInSystemDatabase(systemEntryId,"DP_SCDS");
                break;
            case "files":
                list = findAllInSystemDatabase(systemEntryId,"f_WCDS");
                break;
            default:
                list = findAllInSystem(systemEntryId);
                break;
        }
        return list;
    }

    public TableEntry moveEntryToTrash(long userId, long entryId)
            throws PortalException {

        TableEntry entry = tableEntryPersistence.findByPrimaryKey(entryId);

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
    public TableEntry moveEntryToTrash(long userId, TableEntry entry)
            throws PortalException {

        // Entry

        if (entry.isInTrash()) {
            throw new TrashEntryException();
        }

        int oldStatus = entry.getStatus();

        if (oldStatus == WorkflowConstants.STATUS_PENDING) {
            entry.setStatus(WorkflowConstants.STATUS_DRAFT);

            tableEntryPersistence.update(entry);
        }

        entry = updateStatus(
                userId, entry.getPrimaryKey(), WorkflowConstants.STATUS_IN_TRASH,
                new ServiceContext(), new HashMap<String, Serializable>());

        // Workflow

        if (oldStatus == WorkflowConstants.STATUS_PENDING) {
            workflowInstanceLinkLocalService.deleteWorkflowInstanceLink(
                    entry.getCompanyId(), entry.getGroupId(),
                    TableEntry.class.getName(), entry.getPrimaryKey());
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
    public TableEntry restoreEntryFromTrash(long userId, long entryId)
            throws PortalException {

        // Entry

        TableEntry entry = tableEntryPersistence.findByPrimaryKey(entryId);

        if (!entry.isInTrash()) {
            throw new RestoreEntryException(
                    RestoreEntryException.INVALID_STATUS);
        }

        TrashEntry trashEntry = _trashEntryLocalService.getEntry(
                TableEntry.class.getName(), entryId);

        updateStatus(
                userId, entryId, trashEntry.getStatus(), new ServiceContext(),
                new HashMap<String, Serializable>());

        return entry;
    }

    @Override
    public void updateAsset(
            long userId, TableEntry entry, long[] assetCategoryIds,
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
                entry.getModifiedDate(), TableEntry.class.getName(),
                entry.getPrimaryKey(), entry.getUuid(), 0, assetCategoryIds,
                assetTagNames, true, visible, null, null, null, null,
                ContentTypes.TEXT_HTML, entry.getTableName(), null, summary,
                null, null, 0, 0, priority);

        assetLinkLocalService.updateLinks(
                userId, assetEntry.getEntryId(), assetLinkEntryIds,
                AssetLinkConstants.TYPE_RELATED);
    }

    /**
     * Edit Entry
     *
     * @param orgEntry       TableEntry model
     * @param serviceContext ServiceContext
     * @return updated TableEntry model.
     * @throws PortalException
     * @throws TableEntryValidateException
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public TableEntry updateEntry(
            TableEntry orgEntry, ServiceContext serviceContext)
            throws PortalException, TableEntryValidateException {

        User user = userLocalService.getUser(orgEntry.getUserId());

        // Validation

        ModelValidator<TableEntry> modelValidator = new TableEntryValidator();
        modelValidator.validate(orgEntry);

        // Update entry

        TableEntry entry = _updateEntry(
                orgEntry.getPrimaryKey(), orgEntry, serviceContext);

        if (!entry.isPending() && !entry.isDraft()) {
            entry.setStatus(WorkflowConstants.STATUS_DRAFT);
        }


        if(orgEntry.equals(entry)) {
            return entry;
        }

        TableEntry updatedEntry = tableEntryPersistence.update(entry);

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
            TableEntry entry, String[] groupPermissions,
            String[] guestPermissions)
            throws PortalException {

        resourceLocalService.updateResources(
                entry.getCompanyId(), entry.getGroupId(), TableEntry.class.getName(),
                entry.getPrimaryKey(), groupPermissions, guestPermissions);
    }

    @Indexable(type = IndexableType.REINDEX)
    public TableEntry updateStatus(
            long userId, long entryId, int status,
            ServiceContext serviceContext,
            Map<String, Serializable> workflowContext)
            throws PortalException {

        // Entry

        User user = userLocalService.getUser(userId);
        Date now = new Date();

        TableEntry entry = tableEntryPersistence.findByPrimaryKey(entryId);

        int oldStatus = entry.getStatus();

        entry.setModifiedDate(serviceContext.getModifiedDate(now));
        entry.setStatus(status);
        entry.setStatusByUserId(user.getUserId());
        entry.setStatusByUserName(user.getFullName());
        entry.setStatusDate(serviceContext.getModifiedDate(now));

        tableEntryPersistence.update(entry);

        AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
                TableEntry.class.getName(), entryId);

        if ((assetEntry == null) || (assetEntry.getPublishDate() == null)) {
            serviceContext.setCommand(Constants.ADD);
        }

        JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

        extraDataJSONObject.put("title", entry.getTableName());

        if (status == WorkflowConstants.STATUS_APPROVED) {

            // Asset

            assetEntryLocalService.updateEntry(
                    TableEntry.class.getName(), entryId, entry.getModifiedDate(),
                    null, true, true);

            // Trash

            if (oldStatus == WorkflowConstants.STATUS_IN_TRASH) {
                CommentManagerUtil.restoreDiscussionFromTrash(
                        TableEntry.class.getName(), entryId);

                _trashEntryLocalService.deleteEntry(
                        TableEntry.class.getName(), entryId);
            }
        } else {

            // Asset

            assetEntryLocalService.updateVisible(
                    TableEntry.class.getName(), entryId, false);

            // Trash

            if (status == WorkflowConstants.STATUS_IN_TRASH) {
                CommentManagerUtil.moveDiscussionToTrash(
                        TableEntry.class.getName(), entryId);
                _trashEntryLocalService.addTrashEntry(
                        userId, entry.getGroupId(), TableEntry.class.getName(),
                        entry.getPrimaryKey(), entry.getUuid(), null, oldStatus,
                        null, null);
            } else if (oldStatus == WorkflowConstants.STATUS_IN_TRASH) {
                CommentManagerUtil.restoreDiscussionFromTrash(
                        TableEntry.class.getName(), entryId);

                _trashEntryLocalService.deleteEntry(
                        TableEntry.class.getName(), entryId);
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
    protected TableEntry _addEntry(TableEntry entry, ServiceContext serviceContext)
            throws PortalException {

        long id = counterLocalService.increment(TableEntry.class.getName());

        TableEntry newEntry = tableEntryPersistence.create(id);

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
        String urlTitle = getUniqueUrlTitle(newEntry,null);
        urlTitle = updateFriendlyURLs(newEntry, urlTitle, serviceContext);
        newEntry.setUrlTitle(urlTitle);


        newEntry.setTableName(entry.getTableName());
        newEntry.setTableFullName(entry.getTableFullName());
        newEntry.setTableType(entry.getTableType());
        newEntry.setTableDatabase(entry.getTableDatabase());
        newEntry.setSystemEntryId(entry.getSystemEntryId());
        newEntry.setSystemName(entry.getSystemName());
        newEntry.setDescription(entry.getDescription());
        newEntry.setDsaUrl(entry.getDsaUrl());
        newEntry.setContactPersonName(entry.getContactPersonName());
        newEntry.setContactPersonId(entry.getContactPersonId());
        newEntry.setSpecificationOwnerName(entry.getSpecificationOwnerName());
        newEntry.setSpecificationOwnerId(entry.getSpecificationOwnerId());
        newEntry.setUnstructuredClause(entry.getUnstructuredClause());
        newEntry.setIsActive(entry.getIsActive());
        /*  */

        return tableEntryPersistence.update(newEntry);
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
    protected TableEntry _updateEntry(
            long primaryKey, TableEntry entry, ServiceContext serviceContext)
            throws PortalException {

        TableEntry updateEntry = fetchTableEntry(primaryKey);

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
                    TableEntry.class);

            try {
                _friendlyURLEntryLocalService.validate(
                        entry.getGroupId(), classNameId, primaryKey, urlTitle);
            } catch (DuplicateFriendlyURLEntryException e) {
                List<String> error = new ArrayList<String>();
                _log.warn("duplicated-url-title " + urlTitle);
                error.add("duplicated-url-title");
                throw new TableEntryValidateException(error);
            }
        }

        if (!urlTitle.equals(entry.getUrlTitle())) {
            urlTitle = updateFriendlyURLs(entry, urlTitle, serviceContext);
        }

        updateEntry.setUrlTitle(
                getUniqueUrlTitle(updateEntry, urlTitle));

/*
updateEntry.setTableName(entry.getTableName());
		updateEntry.setDescription(entry.getDescription());
*/
        /*   */
        updateEntry.setTableEntryId(entry.getTableEntryId());
        updateEntry.setTableName(entry.getTableName());
        updateEntry.setTableFullName(entry.getTableFullName());
        updateEntry.setTableType(entry.getTableType());
        updateEntry.setTableDatabase(entry.getTableDatabase());
        updateEntry.setSystemEntryId(entry.getSystemEntryId());
        updateEntry.setSystemName(entry.getSystemName());
        updateEntry.setDescription(entry.getDescription());
        updateEntry.setDsaUrl(entry.getDsaUrl());
        updateEntry.setContactPersonName(entry.getContactPersonName());
        updateEntry.setContactPersonId(entry.getContactPersonId());
        updateEntry.setSpecificationOwnerName(entry.getSpecificationOwnerName());
        updateEntry.setSpecificationOwnerId(entry.getSpecificationOwnerId());
        updateEntry.setUnstructuredClause(entry.getUnstructuredClause());
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
    protected void deleteDiscussion(TableEntry entry) throws PortalException {
        CommentManagerUtil.deleteDiscussion(
                TableEntry.class.getName(), entry.getPrimaryKey());
    }

    /**
     * Generating a unique URL for asset
     */
    protected String getUniqueUrlTitle(TableEntry entry, String newTitle) {
        long entryId = entry.getPrimaryKey();
        String title = entry.getTableName();

        String urlTitle = null;

        if (newTitle == null || newTitle.equals("")) {
            urlTitle = "meta_cds_table__" + String.valueOf(entryId);
            if (!Validator.isBlank(title)) {
                urlTitle += "__" + StringUtil.toLowerCase(title);
                ;
            }
        } else {
            urlTitle = StringUtil.toLowerCase(newTitle.trim());
            if (Validator.isNull(urlTitle) || Validator.isNumber(urlTitle) ||
                    urlTitle.equals("rss")) {

                urlTitle = "meta_cds_table__"+String.valueOf(entryId);
            }
        }

        urlTitle =
                FriendlyURLNormalizerUtil.normalizeWithPeriodsAndSlashes(
                        urlTitle);

        urlTitle = ModelHintsUtil.trimString(
                ColumnEntry.class.getName(), "urlTitle", urlTitle);


        long classNameId = _classNameLocalService.getClassNameId(
                TableEntry.class);

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
                TableEntry.class.getName(), "urlTitle", title);
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
    protected TableEntry startWorkflowInstance(
            long userId, TableEntry entry, ServiceContext serviceContext)
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
                TableEntry.class.getName(), entry.getPrimaryKey(), entry,
                serviceContext, workflowContext);
    }

    /**
     * Update Friendly URLs
     *
     * @param entry          TableEntry
     * @param urlTitle
     * @param serviceContext
     * @return string
     * @throws PortalException
     */
    protected String updateFriendlyURLs(
            TableEntry entry, String urlTitle,
            ServiceContext serviceContext)
            throws PortalException {

        if (ExportImportThreadLocal.isImportInProcess() ||
                ExportImportThreadLocal.isStagingInProcess()) {

            return urlTitle;
        }

        List<FriendlyURLEntry> friendlyURLEntries =
                _friendlyURLEntryLocalService.getFriendlyURLEntries(
                        entry.getGroupId(),
                        classNameLocalService.getClassNameId(TableEntry.class),
                        entry.getPrimaryKey());

        FriendlyURLEntry newFriendlyURLEntry =
                _friendlyURLEntryLocalService.addFriendlyURLEntry(
                        entry.getGroupId(),
                        classNameLocalService.getClassNameId(TableEntry.class),
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
