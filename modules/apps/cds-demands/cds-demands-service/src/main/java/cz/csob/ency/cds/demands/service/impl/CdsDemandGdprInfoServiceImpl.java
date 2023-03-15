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

package cz.csob.ency.cds.demands.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.cds.demands.model.CdsDemandGdprInfo;
import cz.csob.ency.cds.demands.model.CdsDemandGdprInfoWrapper;
import cz.csob.ency.cds.demands.service.base.CdsDemandGdprInfoServiceBaseImpl;
import cz.csob.ency.common.json.response.EncyJsonResponse;
import org.osgi.service.component.annotations.Component;

import java.util.*;

/**
 * @author Miroslav Čermák
 */
@Component(
        property = {
                "json.web.service.context.name=cdsdemand",
                "json.web.service.context.path=GdprInfo"
        },
        service = AopService.class
)
public class CdsDemandGdprInfoServiceImpl
        extends CdsDemandGdprInfoServiceBaseImpl {

    private static final Log _log = LogFactoryUtil.getLog(
            CdsDemandGdprInfoServiceImpl.class);

    public EncyJsonResponse deleteEntry(long entryId, ServiceContext serviceContext) {
        try {
            cdsDemandGdprInfoLocalService.deleteEntry(entryId);
        } catch (PortalException e) {
            return EncyJsonResponse.failure(e);
        }
        return EncyJsonResponse.success(
                LanguageUtil.get(serviceContext.getLocale(), "gdpr-info-deleted-successfully"),
                "ok");
    }

    public EncyJsonResponse getEntriesByDemandId(long demandId, ServiceContext serviceContext) {
        try {
            List<CdsDemandGdprInfo> entries = cdsDemandGdprInfoLocalService.getAllInDemandId(demandId);
            List<Object> result = new LinkedList<>();
            for(CdsDemandGdprInfo entry : entries){
                result.add(_getExtendedAttributes(entry));
            }

            return EncyJsonResponse.success(result);
           // return EncyJsonResponse.success(entries);
        } catch (Exception e) {
            return EncyJsonResponse.failure(e);
        }
    }

    private Map<String, Object> _getExtendedAttributes(CdsDemandGdprInfo entry) {
        if(Validator.isNull(entry)) {
            return Collections.EMPTY_MAP;
        }
        CdsDemandGdprInfoWrapper wrapped = new CdsDemandGdprInfoWrapper(entry);
        Map<String, Object> attributes = wrapped.getModelAttributes();

        attributes.put("employeeCategory", _deserializeArray(entry.getEmployeeCategory()));
        attributes.put("employeeReasoning", _deserializeArray(entry.getEmployeeReasoning()));
        attributes.put("clientCategory", _deserializeArray(entry.getClientCategory()));
        attributes.put("clientReasoning", _deserializeArray(entry.getClientReasoning()));
        return attributes;
    }

    private JSONArray _deserializeArray(String val) {
        if(Validator.isNull(val)) {
            return JSONFactoryUtil.createJSONArray();
        }
        List<Map<String, String>> x =
                (List<Map<String, String>>) JSONFactoryUtil.deserialize(val);
        return JSONFactoryUtil.createJSONArray(x);
    }


    public EncyJsonResponse getEntry(long entryId, ServiceContext serviceContext) {
        try {
            CdsDemandGdprInfo result = cdsDemandGdprInfoLocalService.fetchCdsDemandGdprInfo(entryId);
            return EncyJsonResponse.success(_getExtendedAttributes(result));
        } catch (Exception e) {
            return EncyJsonResponse.failure(e);
        }
    }

    public EncyJsonResponse getInitializedEntry(ServiceContext serviceContext) {
        try {
            CdsDemandGdprInfo result = cdsDemandGdprInfoLocalService.getInitializedEntry();
            return EncyJsonResponse.success(result);
        } catch (Exception e) {
            return EncyJsonResponse.failure(e);
        }
    }

    public EncyJsonResponse updateEntry(Map<String, Object> values, ServiceContext serviceContext) {

		try {
            CdsDemandGdprInfo entry =
			cdsDemandGdprInfoLocalService.getEntryFromMap(values);

            CdsDemandGdprInfo updatedEntry =
                    cdsDemandGdprInfoLocalService.updateEntry(entry, serviceContext);

            return EncyJsonResponse.success(
                    LanguageUtil.get(serviceContext.getLocale(),"gdpr-info-added-successfully"),
                    updatedEntry);
		} catch (Exception e) {
            _log.error(e);
			return EncyJsonResponse.failure(e);
		}

    }


}