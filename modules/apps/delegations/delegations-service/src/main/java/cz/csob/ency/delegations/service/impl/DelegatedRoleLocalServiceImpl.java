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

package cz.csob.ency.delegations.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.common.helpers.UserHelper;
import cz.csob.ency.delegations.exception.NoSuchDelegatedRoleException;
import cz.csob.ency.delegations.model.DelegatedRole;
import cz.csob.ency.delegations.service.base.DelegatedRoleLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Miroslav Čermák
 */
@Component(
        property = "model.class.name=cz.csob.ency.delegations.model.DelegatedRole",
        service = AopService.class
)
public class DelegatedRoleLocalServiceImpl
        extends DelegatedRoleLocalServiceBaseImpl {

    private static final Log _log = LogFactoryUtil.getLog(
            DelegatedRoleLocalServiceImpl.class);

    @Override
    @Transactional(enabled = false)
    public DelegatedRole create() {
        long primaryKey = counterLocalService.increment(
                DelegatedRole.class.getName());

        return createWithId(primaryKey);
    }

    @Transactional(enabled = false)
    public DelegatedRole createWithId(long primaryKey) {
        DelegatedRole entry = delegatedRolePersistence.create(primaryKey);
        return entry;
    }

    @Override
    public DelegatedRole deleteDelegatedRole(long primaryKey) {
        DelegatedRole entry = fetchDelegatedRole(primaryKey);

        if(Validator.isNull(entry)){
            return null;
        }

        return delegatedRolePersistence.remove(entry);
    }

    /**
     * Delete entry
     *
     * @param entry CdsDemand
     * @return CdsDemand oject
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    @SystemEvent(type = SystemEventConstants.TYPE_DELETE)
    public DelegatedRole deleteDelegatedRole(DelegatedRole entry) {
        /* @todo delete delegations */
        return delegatedRolePersistence.remove(entry);
    }

    @Override
    public DelegatedRole fetchDelegatedRole(String code) {
        return delegatedRolePersistence.fetchByCode(code);
    }

    @Override
    public DelegatedRole fetchDelegatedRole(long primaryKey) {
        return delegatedRolePersistence.fetchByPrimaryKey(primaryKey);
    }

    @Transactional(enabled = false)
    public DelegatedRole fetchOrCreate(long primaryKey, ServiceContext serviceContext) {
        DelegatedRole entry = fetchDelegatedRole(primaryKey);
        if (Validator.isNotNull(entry)) {
            return entry;
        }

        long topPrimaryKey = counterLocalService.increment(
                DelegatedRole.class.getName(), 0);
        if (primaryKey <= 0 || primaryKey > topPrimaryKey) {
            // empty or invalid key, create new
            entry = create();
        } else {
            entry = createWithId(primaryKey);
        }

        entry.setCreateDate(new Date());
        entry.setCompanyId(serviceContext.getCompanyId());
        entry.setGroupId(serviceContext.getScopeGroupId());

        return entry;
    }

    @Override
    public DelegatedRole getDelegatedRole(String code)
            throws NoSuchDelegatedRoleException {
        return delegatedRolePersistence.findByCode(code);
    }

    @Override
    public List<DelegatedRole> getDelegatedRoles(long groupId) {
        return delegatedRolePersistence.findByG(groupId);
    }

    @Override
    public DelegatedRole updateDelegatedRole(
            long roleId, String code, String title, String description,
            ServiceContext serviceContext) throws PortalException {

        DelegatedRole entry = fetchOrCreate(roleId, serviceContext);

        User u = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
        if (Validator.isNull(u)) {
            throw new PortalException("Unknown user with id " + serviceContext.getUserId());
        }

        entry.setCode(code);
        entry.setTitle(title);
        entry.setDescription(description);

        entry.setUserId(u.getUserId());
        entry.setUserName(userHelper.getFormattedUserName(u));
        entry.setModifiedDate(new Date());

        delegatedRolePersistence.update(entry, serviceContext);

        return entry;
    }

    private void _copyAttributes(DelegatedRole srcEntry, DelegatedRole tgtEntry) {
        Map<String, Object> attrs = srcEntry.getModelAttributes();
        attrs.remove("roleId");
        _log.warn(attrs);

        tgtEntry.setModelAttributes(attrs);
    }

    @Reference
    protected UserHelper userHelper;

}