/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package cz.csob.ency.modules.e3.entry.service.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.friendly.url.service.FriendlyURLEntryLocalService;
import com.liferay.marketplace.service.AppLocalService;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.comment.CommentManager;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.service.permission.ModelPermissions;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.subscription.util.UnsubscribeHelper;
import com.liferay.upload.UniqueFileNameProvider;
import cz.csob.ency.modules.e3.app.model.E3App;
import cz.csob.ency.modules.e3.app.service.E3AppLocalService;
import cz.csob.ency.modules.e3.app.service.E3AppLocalServiceUtil;
import cz.csob.ency.modules.e3.entry.exception.InvalidE3EntryException;
import cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.entry.service.base.E3EntryLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.ws.rs.NotSupportedException;
import java.math.BigInteger;

/**
 * The implementation of the entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>EntryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see E3EntryLocalServiceBaseImpl
 */
@Component(
        property = "model.class.name=cz.csob.ency.modules.e3.entry.model.E3Entry",
        service = AopService.class
)
public class E3EntryLocalServiceImpl extends E3EntryLocalServiceBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Use <code>EntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>EntryLocalServiceUtil</code>.
     */

    private static final Log log = LogFactoryUtil.getLog(E3EntryLocalServiceImpl.class);


    /**
     * Do not call this internal method from outside directly. Use Appropriate addEntry method instead.
     *
     * @param e3Entry the e3 entry
     * @return -
     * @throws NotSupportedException when called directly
     */
    @Override
    public E3Entry addE3Entry(E3Entry e3Entry) {

        throw new NotSupportedException("Method is not supported. Use addEntry instead");
    }

    @Override
    public E3Entry addEntry(E3Entry entry, boolean publish, ServiceContext serviceContext)
            throws PortalException {
        return addEntry(serviceContext.getUserId(), entry, publish, serviceContext);
    }

    @Indexable(type = IndexableType.REINDEX)
    public E3Entry addEntry(long userId, E3Entry entry, boolean publish, ServiceContext serviceContext)
            throws PortalException {

        // Entry
        User user = userLocalService.getUser(userId);
        long groupId = serviceContext.getScopeGroupId();

        // @todo adaptovat na e3workflow
        int status = WorkflowConstants.STATUS_DRAFT;

        _validate(entry);


        // Set what needs to be set
        entry.setUserId(serviceContext.getUserId());
        entry.setGroupId(serviceContext.getScopeGroupId());
        entry.setCompanyId(serviceContext.getCompanyId());

        // call before entry add logic

        entry = super.addE3Entry(entry);
        if (publish) {
            entry = publishDraft(entry);
        }

        //call after entry add logic

        // Resources

        if (serviceContext.isAddGroupPermissions() ||
                serviceContext.isAddGuestPermissions()) {

            addEntryResources(
                    entry, serviceContext.isAddGroupPermissions(),
                    serviceContext.isAddGuestPermissions());
        } else {
            addEntryResources(entry, serviceContext.getModelPermissions());
        }


        // Handle Assets
        updateAsset(
                serviceContext.getUserId(), entry,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(),
                serviceContext.getAssetLinkEntryIds(),
                serviceContext.getAssetPriority());

        //Handle Workflow


        return entry;
    }

    @Override
    public void addEntryResources(
            E3Entry entry, boolean addGroupPermissions,
            boolean addGuestPermissions)
            throws PortalException {
        log.info("Adding entry permissions "+addGroupPermissions+" "+addGuestPermissions);

        resourceLocalService.addResources(
                entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
                E3Entry.class.getName(), entry.getEntryId(), false,
                addGroupPermissions, addGuestPermissions);
    }

    @Override
    public void addEntryResources(
            E3Entry entry, ModelPermissions modelPermissions)
            throws PortalException {
        log.info("Adding entry permissions "+"{CompanyId="+entry.getCompanyId()
                +",GroupId="+entry.getGroupId()+",UserId="+entry.getUserId()
                +",class="+ E3Entry.class.getName()+",EntryId="+ entry.getEntryId()+",}");

        resourceLocalService.addModelResources(
                entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
                E3Entry.class.getName(), entry.getEntryId(), modelPermissions);
    }

    /**
     * Do not call this internal method from outside directly. Use createEntry(appClass) method instead.
     *
     * @return -
     * @throws
     */
    @Override
    @Transactional(enabled = false)
    public E3Entry create() {
        return super.create();
    }

    /**
     * Creates a new draft e3 entry for given app class. Does not add the e3 entry to the database.
     *
     * @return the new draft e3 entry
     */
    @Transactional(enabled = false)
    public E3Entry createEntry(String appClass) {
        E3Entry draftE3Entry = super.create();

        draftE3Entry.setAppClass(appClass);

        return draftE3Entry;
    }

    /**
     * Do not call this internal method from outside directly. Use deleteEntry(entryId) method instead.
     *
     * @return -
     * @throws NotSupportedException when called directly
     */
    @Override
    public E3Entry deleteE3Entry(long entryId) throws PortalException {
        throw new NotSupportedException("Method is not supported. Use deleteEntry()");
    }

    @Override
    public E3Entry deleteE3Entry(E3Entry e3Entry) {
        throw new NotSupportedException("Method is not supported. Use deleteEntry()");
    }

    @Indexable(type = IndexableType.DELETE)
    public E3Entry deleteEntry(long entryId) throws PortalException {
        E3Entry e3Entry = e3EntryPersistence.fetchByPrimaryKey(entryId);
        return deleteE3Entry(e3Entry);
    }

    @Indexable(type = IndexableType.DELETE)
    @Transactional(enabled = true)
    public E3Entry deleteEntry(E3Entry entry, ServiceContext serviceContext) throws PortalException {

        // Before entry delete @todo

        // Order is important. See LPS-81826.

        // Ratings

        ratingsStatsLocalService.deleteStats(E3Entry.class.getName(), entry.getEntryId());

        // Entry

        entry = super.deleteE3Entry(entry);

        // Resources
        resourceLocalService.deleteResource(serviceContext.getCompanyId(),
                E3Entry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
                entry.getEntryId());

        // Subscriptions


        // Statistics

        // Asset
        assetEntryLocalService.deleteEntry(E3Entry.class.getName(), entry.getEntryId());

        // Attachments

        // Comment

        _commentManager.deleteDiscussion(
                E3Entry.class.getName(), entry.getEntryId());

        // Friendly URL

        // Trash

        // Workflow

        // After entry delete @todo

        return entry;
    }

    public E3Entry getEntry(long entryId)
            throws NoSuchE3EntryException {
        try {
            return getE3Entry(entryId);
        } catch (PortalException exception) {
            throw new NoSuchE3EntryException("{entryId=" + entryId + "}");
        }
    }

    public String getEntryPortletName(E3Entry entry)
            throws PortalException {

        if (Validator.isNull(entry)) {
            throw new PortalException("unable to get portlet for null entry");
        }

        E3App app = E3AppLocalServiceUtil.getApp(entry);

        if (Validator.isNull(app)) {
            throw new PortalException("unable to get portlet for entry [" + entry.getEntryId() + "]");
        }

        return app.getAppMainPortletName();
    }

    public long getMaxEntryVersion(long id) {
        String sql = "SELECT coalesce(max(entry_version),0) FROM ency_entry WHERE entry_id=?";
        Session session = null;
        Long count = 0L;

        try {
            session = e3EntryPersistence.openSession();

            Query query = session.createSQLQuery(sql);

            QueryPos queryPos = QueryPos.getInstance(query);

            queryPos.add(id);

            count = ((BigInteger) query.uniqueResult()).longValue();

            if (count == null) count = 0L;

            log.info("Max version for entry id=" + id + " is " + count);
        } catch (Exception exception) {
            log.error(exception);
            throw exception;
        } finally {
            e3EntryPersistence.closeSession(session);
        }

        return count;
    }

    @Override
    public void updateAsset(
            long userId, E3Entry entry, long[] assetCategoryIds,
            String[] assetTagNames, long[] assetLinkEntryIds, Double priority)
            throws PortalException {

        boolean visible = false;

        if (_appLocalService.isEntryApproved(entry)) {
            visible = true;
        }

        AssetEntry assetEntry = assetEntryLocalService.updateEntry(
                userId, entry.getGroupId(), entry.getCreateDate(),
                entry.getModifiedDate(), E3Entry.class.getName(),
                entry.getEntryId(), entry.getUuid(), 0, assetCategoryIds,
                assetTagNames, true, visible, null, null, null, null,
                ContentTypes.TEXT_HTML, entry.getName(), entry.getDescription(),
                entry.getSummary(), null, null, 0, 0, priority);

        assetLinkLocalService.updateLinks(
                userId, assetEntry.getEntryId(), assetLinkEntryIds,
                AssetLinkConstants.TYPE_RELATED);
    }

    @Indexable(type = IndexableType.REINDEX)
    public E3Entry updateEntry(E3Entry entry, boolean publish, ServiceContext serviceContext)
            throws PortalException {
        E3Entry draftEntry = getDraft(entry);

        // Entry

        _validate(draftEntry);

        //   User user = _userLocalService.getUser(getU);
        long groupId = serviceContext.getScopeGroupId();

        draftEntry.setUuid(serviceContext.getUuid());
        draftEntry.setGroupId(groupId);
        draftEntry.setUserId(serviceContext.getUserId());

        draftEntry = updateE3Entry(draftEntry);

        if (publish) {
           entry = publishDraft(draftEntry);
        }

        //Resources

        resourceLocalService.updateResources(serviceContext.getCompanyId(),
                serviceContext.getScopeGroupId(),
                E3Entry.class.getName(), entry.getEntryId(),
                serviceContext.getModelPermissions());

        // Assets
        updateAsset(
                serviceContext.getUserId(), entry,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(),
                serviceContext.getAssetLinkEntryIds(),
                serviceContext.getAssetPriority());

        return draftEntry;
    }

    private void _validate(E3Entry entry) throws PortalException {
        // check if entry is valid
        if (Validator.isBlank(entry.getAppClass())) {
            throw new InvalidE3EntryException("AppClass not set {entry:" + entry + "}");
        }

        // check if entry has name
        if (Validator.isBlank(entry.getName())) {
            throw new InvalidE3EntryException("Entry Name not set {entry:" + entry + "}");
        }
    }

    @Reference
    private E3AppLocalService _appLocalService;

    @Reference
    private UserLocalService _userLocalService;

    @Reference
    private CommentManager _commentManager;

    @Reference
    private FriendlyURLEntryLocalService _friendlyURLEntryLocalService;

    @Reference
    private UniqueFileNameProvider _uniqueFileNameProvider;

    @Reference
    private UnsubscribeHelper _unsubscribeHelper;

    @Reference
    private Portal _portal;

}