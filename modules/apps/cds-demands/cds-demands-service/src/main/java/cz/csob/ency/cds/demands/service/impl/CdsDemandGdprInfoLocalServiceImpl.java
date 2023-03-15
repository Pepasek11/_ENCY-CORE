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
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import cz.csob.ency.cds.demands.exception.CdsDemandValidateException;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.cds.demands.model.CdsDemandGdprInfo;
import cz.csob.ency.cds.demands.model.impl.CdsDemandGdprInfoImpl;
import cz.csob.ency.cds.demands.service.CdsDemandLocalServiceUtil;
import cz.csob.ency.cds.demands.service.base.CdsDemandGdprInfoLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author Miroslav Čermák
 */
@Component(
        property = "model.class.name=cz.csob.ency.cds.demands.model.CdsDemandGdprInfo",
        service = AopService.class
)
public class CdsDemandGdprInfoLocalServiceImpl
        extends CdsDemandGdprInfoLocalServiceBaseImpl {

    private static final Log _log = LogFactoryUtil.getLog(
            CdsDemandGdprInfoLocalServiceImpl.class);

    /**
     * Delete entry
     */
    public CdsDemandGdprInfo deleteEntry(long primaryKey) throws PortalException {
        CdsDemandGdprInfo entry = getCdsDemandGdprInfo(primaryKey);

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
    public CdsDemandGdprInfo deleteEntry(CdsDemandGdprInfo entry) throws PortalException {

        // Entry

        return cdsDemandGdprInfoPersistence.remove(entry);
    }

    public List<CdsDemandGdprInfo> getAllInDemandId(long demanId) {
        return cdsDemandGdprInfoPersistence.findBydemandId(demanId);
    }

    /**
     * Populate Model with values from a form
     *
     * @param map KeyVAlue map
     * @return CdsDemand Object
     * @throws PortletException
     * @throws CdsDemandValidateException
     */
    public CdsDemandGdprInfo getEntryFromMap(
            Map<String, Object> map) {

        // Create or fetch existing data

        CdsDemandGdprInfo e = new CdsDemandGdprInfoImpl();

        Map<String, BiConsumer<CdsDemandGdprInfo, Object>> setters =
                e.getAttributeSetterBiConsumers();
        try {
            map.forEach((field, val) -> {
                if(val == null) return;
                if (setters.containsKey(field) ) {
                    //_log.warn(field + " " + val + "  $ " + val.getClass());

                    // Pokud dostaneme Map, tak je zvolen jenom jeden objekt a tak to obalime do Listu
                    if (Map.class.isAssignableFrom(val.getClass())) {
                        List<Object> arr = new ArrayList<>();
                        arr.add(val);
                        val = arr;
                    }

                    if (List.class.isAssignableFrom(val.getClass())) {
                        setters.get(field).accept(e, JSONFactoryUtil.serialize(val));

                    } else if (Integer.class.isAssignableFrom(val.getClass())) {
                        setters.get(field).accept(e, Long.valueOf(String.valueOf(val)));

                    } else {
                        setters.get(field).accept(e, val);
                    }
                } else {
                    _log.warn("Unknown field to set:" + field);
                }
            });
        } catch (Exception ex) {
            _log.error(ex);
            throw ex;
        }

        return e;
    }


    /**
     * Populate Model with values from a form
     *
     * @param request PortletRequest
     * @return CdsDemand Object
     * @throws PortletException
     * @throws CdsDemandValidateException
     */
    public CdsDemandGdprInfo getEntryFromRequest(
            long primaryKey, PortletRequest request)
            throws PortletException, CdsDemandValidateException {

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(
                WebKeys.THEME_DISPLAY);

        // Create or fetch existing data

        CdsDemandGdprInfo entry;

        if (primaryKey <= 0) {
            entry = create();
        } else {
            entry = fetchCdsDemandGdprInfo(primaryKey);
            long currCounter = counterLocalService.increment(CdsDemand.class.getName(), 0);
            if (Validator.isNull(entry) || currCounter < primaryKey) {
                entry = create();
            }
        }


        try {
            // entry.setDemandId(primaryKey);
            entry.setTitle(ParamUtil.getString(request, "title"));
            entry.setDescription(ParamUtil.getString(request, "description"));

            entry.setIsClient(ParamUtil.getBoolean(request, "isClient"));
            entry.setIsEmployee(ParamUtil.getBoolean(request, "isEmployee"));
            entry.setClientCategory(
                    JSONFactoryUtil.serialize(
                            ParamUtil.getLongValues(request, "clientCategory")
                    ));
            entry.setClientReasoning(
                    JSONFactoryUtil.serialize(
                            ParamUtil.getLongValues(request, "clientReasoning")
                    ));
            entry.setEmployeeCategory(
                    JSONFactoryUtil.serialize(
                            ParamUtil.getLongValues(request, "employeeCategory")
                    ));
            entry.setEmployeeReasoning(
                    JSONFactoryUtil.serialize(
                            ParamUtil.getLongValues(request, "employeeReasoning")
                    ));

            entry.setUserId(themeDisplay.getUserId());

        } catch (Exception e) {
            _log.error("Errors occur while populating the model", e);
            List<String> error = new ArrayList<>();
            error.add("value-convert-error");

            throw new CdsDemandValidateException(error);
        }

        return entry;
    }

    /**
     * Populate Model with default values for a form
     *
     * @return CdsDemand Object
     * @throws PortletException
     */
    public CdsDemandGdprInfo getInitializedEntry()
            throws PortletException {
        CdsDemandGdprInfo entry = create();

        entry.setTitle("");
        entry.setDescription("");
        entry.setIsClient(false);
        entry.setIsEmployee(false);
        entry.setClientCategory("[]");
        entry.setClientReasoning("[]");
        entry.setEmployeeCategory("[]");
        entry.setEmployeeReasoning("[]");

        return entry;
    }

    @Override
    public CdsDemandGdprInfo updateEntry(
            CdsDemandGdprInfo entry, ServiceContext serviceContext)
            throws PortalException, CdsDemandValidateException {

        User user = userLocalService.getUser(serviceContext.getUserId());

        CdsDemandGdprInfo updateEntry =
                fetchCdsDemandGdprInfo(entry.getPrimaryKey());

        long newestKey = counterLocalService.increment(
                CdsDemand.class.getName(), 0);

        Date now = new Date();
        if (Validator.isNotNull(updateEntry)) {
            // Ok we have an update with correct key
        } else {
            if (entry.getPrimaryKey() <= 0 || entry.getPrimaryKey() > newestKey) {
                // Insert from form with initialized empty entry or wrong key
                updateEntry = create();
            } else {
                // insert new entry with preinitialized id
                updateEntry = create(entry.getPrimaryKey());
            }
            updateEntry.setCreateDate(now);
        }

        updateEntry.setDemandId(entry.getDemandId());
        updateEntry.setTitle(entry.getTitle());
        updateEntry.setDescription(entry.getDescription());
        updateEntry.setIsClient(entry.getIsClient());
        updateEntry.setIsEmployee(entry.getIsEmployee());
        updateEntry.setClientCategory(entry.getClientCategory());
        updateEntry.setClientReasoning(entry.getClientReasoning());
        updateEntry.setEmployeeCategory(entry.getEmployeeCategory());
        updateEntry.setEmployeeReasoning(entry.getEmployeeReasoning());

        updateEntry.setUserId(user.getUserId());
        updateEntry.setUserName(
                CdsDemandLocalServiceUtil.getFormattedUserName(user));
        updateEntry.setModifiedDate(now);

        CdsDemandGdprInfo updatedEntry =
                cdsDemandGdprInfoPersistence.update(updateEntry);

        return updatedEntry;
    }

    @Transactional(enabled = false)
    protected CdsDemandGdprInfo create() {
        long primaryKey = counterLocalService.increment(
                CdsDemandGdprInfo.class.getName());

        return create(primaryKey);
    }

    @Transactional(enabled = false)
    protected CdsDemandGdprInfo create(final long primaryKey) {

        CdsDemandGdprInfo entry = cdsDemandGdprInfoPersistence.create(primaryKey);

        return entry;
    }


}