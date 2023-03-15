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
import cz.csob.ency.delegations.model.DelegatedRole;
import cz.csob.ency.delegations.model.Delegation;
import cz.csob.ency.delegations.service.DelegatedRoleLocalService;
import cz.csob.ency.delegations.service.base.DelegationLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Miroslav Čermák
 */
@Component(
        property = "model.class.name=cz.csob.ency.delegations.model.Delegation",
        service = AopService.class
)
public class DelegationLocalServiceImpl extends DelegationLocalServiceBaseImpl {
    private static final Log _log = LogFactoryUtil.getLog(
            DelegationLocalServiceImpl.class);

    @Override
    @Transactional(enabled = false)
    public Delegation create() {
        long primaryKey = counterLocalService.increment(
                Delegation.class.getName());

        return createWithId(primaryKey);
    }

    @Transactional(enabled = false)
    public Delegation createWithId(long primaryKey) {
        Delegation entry = delegationPersistence.create(primaryKey);
        return entry;
    }

    @Override
    public Delegation deleteDelegation(long primaryKey) {
        Delegation entry = fetchDelegation(primaryKey);

        if(Validator.isNull(entry)){
            return null;
        }

        return delegationPersistence.remove(entry);
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
    public Delegation deleteDelegation(Delegation entry) {
        /* @todo delete delegations */
        return delegationPersistence.remove(entry);
    }

    @Override
    public Delegation fetchDelegation(long primaryKey) {
        return delegationPersistence.fetchByPrimaryKey(primaryKey);
    }

    @Transactional(enabled = false)
    public Delegation fetchOrCreate(long primaryKey, ServiceContext serviceContext) {
        Delegation entry = fetchDelegation(primaryKey);
        if (Validator.isNotNull(entry)) {
            return entry;
        }

        long topPrimaryKey = counterLocalService.increment(
                Delegation.class.getName(), 0);
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
    public List<Delegation> getDelegations(long groupId, long roleId) {
        return delegationPersistence.findByG_R(groupId, roleId);
    }

    @Override
    public List<Delegation> getDelegationsOfUser(long groupId, String roleCode, long delegatingUserId) {
        DelegatedRole role = delegatedRoleLocalService.fetchDelegatedRole(roleCode);
        if(Validator.isNull(role)) {
            return new ArrayList<>();
        }

        return delegationPersistence.findByG_R_Delegating(groupId, role.getRoleId(), delegatingUserId);
    }

    @Override
    public List<Delegation> getDelegationsOfUser(long groupId, long roleId, long delegatingUserId) {
        return delegationPersistence.findByG_R_Delegating(groupId, roleId, delegatingUserId);
    }

    @Override
    public List<Delegation> getDelegationsToUser(long groupId, long roleId, long delegatedUserId) {
        return delegationPersistence.findByG_R_Delegated(groupId, roleId, delegatedUserId);
    }

    @Override
    public List<Delegation> getDelegationsToUser(long groupId, String roleCode, long delegatedUserId) {
        DelegatedRole role = delegatedRoleLocalService.fetchDelegatedRole(roleCode);
        if(Validator.isNull(role)) {
            return new ArrayList<>();
        }
        return delegationPersistence.findByG_R_Delegated(groupId, role.getRoleId(), delegatedUserId);
    }


    @Override
    public Delegation updateDelegation(
            long delegationId, long roleId, long delegatingUserId, long delegatedUserId,
            String note, ServiceContext serviceContext) throws PortalException {

        Delegation entry = fetchOrCreate(delegationId, serviceContext);

        User u = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
        if (Validator.isNull(u)) {
            throw new PortalException("Unknown user with id " + serviceContext.getUserId());
        }

        entry.setRoleId(roleId);
        entry.setDelegatingUserId(delegatingUserId);
        entry.setDelegatedUserId(delegatedUserId);
        entry.setNote(note);

        entry.setUserId(u.getUserId());
        entry.setUserName(userHelper.getFormattedUserName(u));
        entry.setModifiedDate(new Date());

        delegationPersistence.update(entry, serviceContext);

        return entry;
    }

    @Reference
    protected DelegatedRoleLocalService delegatedRoleLocalService;

    @Reference
    protected UserHelper userHelper;
}