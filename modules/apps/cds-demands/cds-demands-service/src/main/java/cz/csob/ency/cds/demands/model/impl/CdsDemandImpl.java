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

package cz.csob.ency.cds.demands.model.impl;

import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.workflow.entry.model.EncyWorkflowedModel;

import java.util.*;
import java.util.function.Function;

/**
 * The extended model implementation for the CdsDemand service. Represents a row in the &quot;CdsDemands_CdsDemand&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>cz.csob.ency.cds.demands.model.CdsDemand</code> interface.
 * </p>
 *
 * @author Miroslav Čermák
 */
@JSON
public class CdsDemandImpl extends CdsDemandBaseImpl implements EncyWorkflowedModel<CdsDemand> {
    private static final Log _log = LogFactoryUtil.getLog(
            CdsDemandImpl.class);

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a cds demand model instance should use the {@link cz.csob.ency.cds.demands.model.CdsDemand} interface instead.
     */
    public CdsDemandImpl() {
    }

    public int[] getFiveTracksArray() {
        String serialized = getFiveTracks();
        int[] result = new int[]{};
        if (Validator.isBlank(serialized)) {
            return result;
        }

        try {
            Object obj = JSONFactoryUtil.deserialize(serialized);

            if (obj != null && obj.getClass().isArray()) {
                result = new int[((Object[]) obj).length];
                for (int i = 0; i < result.length; i++) {
                    try {
                        result[i] = (int) ((Object[]) obj)[i];
                    } catch (Exception ex) {
                        _log.warn(ex.getMessage());
                    }
                }
                return result;
            }
        } catch (Throwable e) {
        }
        return result;
    }

    public void setFiveTracks(long[] tracks){
       setFiveTracks(JSONFactoryUtil.serialize(tracks));
    }

    public int getStatus() {
        return WorkflowConstants.STATUS_APPROVED;
    }

    /**
     * Compares two object by significant values. Technical values (creation, modifiaction dates ...)
     * are ignored
     * @param that
     * @return
     */
    public boolean isSubstantiallyEqual(CdsDemand that) {
        Map<String, Function<CdsDemand, Object>> getters = this.getAttributeGetterFunctions();

        for (String field: getters.keySet()) {
            if(IGNORE_SUBSTANTIALLY_EQUAL_COLUMS.contains(field)){
                continue;
            }

            Function<CdsDemand, Object> getter = getters.get(field);
            if (!Objects.equals(
                    getter.apply(this),
                    getter.apply(that)
            )) {
                return false;
            }
        }
        return true;
    }

    public static final List<String> IGNORE_SUBSTANTIALLY_EQUAL_COLUMS =
            new LinkedList<>();
    static{
        IGNORE_SUBSTANTIALLY_EQUAL_COLUMS.add("createDate");
        IGNORE_SUBSTANTIALLY_EQUAL_COLUMS.add("modifiedDate");
        IGNORE_SUBSTANTIALLY_EQUAL_COLUMS.add("stateByUserId");
        IGNORE_SUBSTANTIALLY_EQUAL_COLUMS.add("stateByUserName");
        IGNORE_SUBSTANTIALLY_EQUAL_COLUMS.add("stateDate");
        IGNORE_SUBSTANTIALLY_EQUAL_COLUMS.add("userId");
        IGNORE_SUBSTANTIALLY_EQUAL_COLUMS.add("userName");
    }
}