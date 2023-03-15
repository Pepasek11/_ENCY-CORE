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
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.service.ServiceContext;
import cz.csob.ency.common.helpers.UserHelper;
import cz.csob.ency.common.json.response.EncyJsonResponse;
import cz.csob.ency.delegations.model.Delegation;
import cz.csob.ency.delegations.service.base.DelegationServiceBaseImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;
import java.util.Map;

/**
 * @author Miroslav Čermák
 */
@Component(
        property = {
                "json.web.service.context.name=delegations",
                "json.web.service.context.path=Delegation"
        },
        service = AopService.class
)
public class DelegationServiceImpl extends DelegationServiceBaseImpl {

    public EncyJsonResponse create(ServiceContext serviceContext) {
        Delegation entry =
                delegationLocalService.fetchOrCreate(0, serviceContext);

        return EncyJsonResponse.success(_toJSON(entry));
    }

    public EncyJsonResponse deleteDelegation(long delegationId, ServiceContext serviceContext) {
        try {
            Delegation entry = delegationLocalService.deleteDelegation(delegationId);
            return EncyJsonResponse.success(_toJSON(entry));
        } catch (Exception e) {
            return EncyJsonResponse.failure(e);
        }
    }

    public EncyJsonResponse getDelegation(long delegationId, ServiceContext serviceContext) {
        try {
            Delegation entry = delegationLocalService.getDelegation(delegationId);
            return EncyJsonResponse.success(_toJSON(entry));
        } catch (Exception e) {
            return EncyJsonResponse.failure(e);
        }
    }

    public EncyJsonResponse getDelegations(long roleId, ServiceContext serviceContext) {
        List<Delegation> entries =
                delegationLocalService.getDelegations(
                        serviceContext.getScopeGroupId(), roleId);
        return EncyJsonResponse.success(_toJSON(entries));
    }

    public EncyJsonResponse updateDelegation(
            long delegationId, long roleId, long delegatingUserId, long delegatedUserId,
            String note, ServiceContext serviceContext) {

        try {
            Delegation entry = delegationLocalService.updateDelegation(
                    delegationId, roleId, delegatingUserId, delegatedUserId, note, serviceContext);

            return EncyJsonResponse.success(_toJSON(entry));
        } catch (Exception e) {
            return EncyJsonResponse.failure(e);
        }
    }

    private JSONObject _toJSON(Delegation entry) {
        Map<String, Object> attrs = entry.getModelAttributes();

        attrs.put("delegatingUserName",
                userHelper.getFormattedUserName(
                        entry.getDelegatingUserId(),
                        String.valueOf(entry.getDelegatingUserId())));

        attrs.put("delegatedUserName",
                userHelper.getFormattedUserName(
                        entry.getDelegatedUserId(),
                        String.valueOf(entry.getDelegatedUserId())));

        // extend attributes here if necessary
        return JSONFactoryUtil.createJSONObject(attrs);
    }

    private JSONArray _toJSON(List<Delegation> list) {

        JSONArray array = JSONFactoryUtil.createJSONArray();
        for (Delegation d : list) {
            array.put(_toJSON(d));
        }
        return array;
    }

    @Reference
    protected UserHelper userHelper;

}