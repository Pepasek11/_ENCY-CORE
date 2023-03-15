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

package cz.csob.ency.cds.demands.internal.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ModelHintsUtil;
import com.liferay.portal.kernel.repository.model.ModelValidator;
import com.liferay.portal.kernel.util.*;
import cz.csob.ency.cds.demands.exception.CdsDemandValidateException;
import cz.csob.ency.cds.demands.model.CdsDemand;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * CdsDemand Validator
 *
 * @author Miroslav Čermák
 *
 */
public class CdsDemandValidator implements ModelValidator<CdsDemand> {

    @Override
    public void validate(CdsDemand entry) throws PortalException {
        // Field title
        validateTitle(entry.getTitle());

        // Field description
        validateDescription(entry.getDescription());

        // Field demandType
        validateType(entry.getType());

        // Field demandType
        validateBan(entry.getBanId());

        // Field demandType
        validateSpoc(entry.getSpocId());

        // Field priority
        validatePriority(entry.getPriority());

        // Field expectedDelivery
        validateRequestedDelivery(entry.getRequestedDelivery());

        if (0 < _errors.size()) {
            throw new CdsDemandValidateException(_errors);
        }

    }


    /**
     * demandType field Validation
     *
     * @param field demandType
     */
    protected void validateType(long field) {
        if(field<=0) {
            _errors.add("cdsdemand-type-required");
        }
    }
    /**
     * banId field Validation
     *
     * @param field banId
     */
    protected void validateBan(long field) {
        if(field<=0) {
            _errors.add("cdsdemand-ban-required");
        }
    }
    /**
     * spocId field Validation
     *
     * @param field spocId
     */
    protected void validateSpoc(long field) {
        if(field<=0) {
            _errors.add("cdsdemand-spoc-required");
        }
    }

    /**
     * description field Validation
     *
     * @param field description
     */
    protected void validateDescription(String field) {
        if(Validator.isBlank(field)) {
            _errors.add("cdsdemand-description-required");
        }

    }

    /**
     * expectedDelivery field Validation
     *
     * @param field expectedDelivery
     */
    protected void validateRequestedDelivery(Date field) {
        if(Validator.isNull(field)) {
            _errors.add("cdsdemand-requested-delivery-required");
        }

        Calendar fcal = CalendarFactoryUtil.getCalendar(field.getTime());
        if(!CalendarUtil.isFuture(fcal.get(Calendar.MONTH),fcal.get(Calendar.DAY_OF_MONTH),fcal.get(Calendar.YEAR))) {
            _errors.add("cdsdemand-requested-delivery-must-be-in-future");
        }
    }

    /**
     * priority field Validation
     *
     * @param field priority
     */
    protected void validatePriority(long field) {
        if(field<=0) {
            _errors.add("cdsdemand-priority-required");
        }
    }

    /**
     * title field Validation
     *
     * @param title
     */
    protected void validateTitle(String title) {
        if (Validator.isBlank(title)) {
            _errors.add("cdsdemand-title-required");
        } else {
            int titleMaxLength = ModelHintsUtil.getMaxLength(
                    CdsDemand.class.getName(), "title");

            if (title.length() > titleMaxLength) {
                _errors.add("title has more than " + titleMaxLength +
                        " characters");
            }
        }
    }

    protected List<String> _errors = new ArrayList<>();

}
