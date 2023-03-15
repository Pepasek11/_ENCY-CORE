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
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.common.json.response.EncyJsonResponse;
import cz.csob.ency.delegations.model.DelegatedRole;
import cz.csob.ency.delegations.service.base.DelegatedRoleServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Miroslav Čermák
 */
@Component(
        property = {
                "json.web.service.context.name=delegations",
                "json.web.service.context.path=DelegatedRole"
        },
        service = AopService.class
)
public class DelegatedRoleServiceImpl
        extends DelegatedRoleServiceBaseImpl {

    public EncyJsonResponse create(ServiceContext serviceContext) {
        DelegatedRole entry =
                delegatedRoleLocalService.fetchOrCreate(0, serviceContext);
        return EncyJsonResponse.success(_toJSON(entry));
    }

    public EncyJsonResponse delete(long roleId, ServiceContext serviceContext) {
        try {
            DelegatedRole entry = delegatedRoleLocalService.deleteDelegatedRole(roleId);
            return EncyJsonResponse.success(_toJSON(entry));
        } catch (Exception e) {
            return EncyJsonResponse.failure(e);
        }

    }

    public EncyJsonResponse getRole(long roleId, ServiceContext serviceContext) {
        try {
            DelegatedRole entry = delegatedRoleLocalService.getDelegatedRole(roleId);
            return EncyJsonResponse.success(_toJSON(entry));
        } catch (Exception e) {
            return EncyJsonResponse.failure(e);
        }
    }

    public EncyJsonResponse getRoles(ServiceContext serviceContext) {
        List<DelegatedRole> roles =
                delegatedRoleLocalService.getDelegatedRoles(
                        serviceContext.getScopeGroupId());

        if (Validator.isNull(roles)) {
            roles = Collections.emptyList();
        }

        return EncyJsonResponse.success(_toJSON(roles));
    }

    public EncyJsonResponse update(long roleId, String code, String title, String description,
                                   ServiceContext serviceContext) {
        try {
            DelegatedRole entry =
                    delegatedRoleLocalService.updateDelegatedRole(
                            roleId, code, title, description, serviceContext);
            return EncyJsonResponse.success(_toJSON(entry));
        } catch (Exception e) {
            return EncyJsonResponse.failure(e);
        }

    }


    private JSONObject _toJSON(DelegatedRole entry) {
        Map<String, Object> attrs = entry.getModelAttributes();
        // extend attributes here if necessary
        return JSONFactoryUtil.createJSONObject(attrs);
    }

    private JSONArray _toJSON(List<DelegatedRole> list) {

        JSONArray array = JSONFactoryUtil.createJSONArray();
        for (DelegatedRole d : list) {
            array.put(_toJSON(d));
        }
        return array;
    }
}