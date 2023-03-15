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

package cz.csob.ency.modules.apps.meta.cds.service.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.ModelValidator;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.modules.apps.meta.cds.exception.SystemEntryValidateException;
import cz.csob.ency.modules.apps.meta.cds.model.SystemEntry;

import java.util.ArrayList;
import java.util.List;


/**
 * SystemEntry Validator
 *
 * @author Miroslav Čermák
 */
public class SystemEntryValidator implements ModelValidator<SystemEntry> {

    @Override
    public void validate(SystemEntry entry) throws PortalException {
        /*   */
        // Field systemEntryId
       // validateSystemEntryId(entry.getSystemEntryId());

        // Field systemCode
       // validateSystemCode(entry.getSystemCode());

        // Field systemName
        //validateSystemName(entry.getSystemName());

        // Field systemTitle
        //validateSystemTitle(entry.getSystemTitle());

        // Field systemType
        //validateSystemType(entry.getSystemType());

        // Field description
        //validateDescription(entry.getDescription());

        // Field stewardName
        // validateStewardName(entry.getStewardName());

        // Field stewardId
        // validateStewardId(entry.getStewardId());

        // Field stewardDepartment
        // validateStewardDepartment(entry.getStewardDepartment());

        // Field businessOwnerName
        // validateBusinessOwnerName(entry.getBusinessOwnerName());

        // Field businessOwnerId
        //  validateBusinessOwnerId(entry.getBusinessOwnerId());

        // Field contactPersonName
        // validateContactPersonName(entry.getContactPersonName());

        // Field contactPersonId
        // validateContactPersonId(entry.getContactPersonId());

        // Field sandboxName
        // validateSandboxName(entry.getSandboxName());

        // Field gestorDepartmentId
        // validateGestorDepartmentId(entry.getGestorDepartmentId());

        // Field gestorDepartmentName
        // validateGestorDepartmentName(entry.getGestorDepartmentName());

        // Field role
        //validateRole(entry.getRole());

        // Field snowAssetTagId
        // validateSnowAssetTagId(entry.getSnowAssetTagId());

        // Field snowAssetTagName
        //validateSnowAssetTagName(entry.getSnowAssetTagName());

        // Field isSlaSigned
        //validateIsSlaSigned(entry.getIsSlaSigned());

        // Field isSelfBi
        //  validateIsSelfBi(entry.getIsSelfBi());

        // Field isActive
        // validateIsActive(entry.getIsActive());

        /*  */
/*
        validateSystemName(entry.getSystemName());
*/
        if (0 < _errors.size()) {
            throw new SystemEntryValidateException(_errors);
        }

    }

    /**
     * businessOwnerId field Validation
     *
     * @param field businessOwnerId
     */
    protected void validateBusinessOwnerId(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("businessownerid-required");
        }

    }

    /**
     * businessOwnerName field Validation
     *
     * @param field businessOwnerName
     */
    protected void validateBusinessOwnerName(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("businessownername-required");
        }

    }

    /**
     * contactPersonId field Validation
     *
     * @param field contactPersonId
     */
    protected void validateContactPersonId(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("contactpersonid-required");
        }

    }

    /**
     * contactPersonName field Validation
     *
     * @param field contactPersonName
     */
    protected void validateContactPersonName(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("contactpersonname-required");
        }

    }

    /**
     * description field Validation
     *
     * @param field description
     */
    protected void validateDescription(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
    }

    /**
     * gestorDepartmentId field Validation
     *
     * @param field gestorDepartmentId
     */
    protected void validateGestorDepartmentId(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("gestordepartmentid-required");
        }

    }

    /**
     * gestorDepartmentName field Validation
     *
     * @param field gestorDepartmentName
     */
    protected void validateGestorDepartmentName(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("gestordepartmentname-required");
        }

    }

    /**
     * isActive field Validation
     *
     * @param field isActive
     */
    protected void validateIsActive(boolean field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.

    }

    /**
     * isSelfBi field Validation
     *
     * @param field isSelfBi
     */
    protected void validateIsSelfBi(boolean field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.

    }

    /**
     * isSlaSigned field Validation
     *
     * @param field isSlaSigned
     */
    protected void validateIsSlaSigned(boolean field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.

    }

    /**
     * role field Validation
     *
     * @param field role
     */
    protected void validateRole(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("role-required");
        }

    }

    /**
     * sandboxName field Validation
     *
     * @param field sandboxName
     */
    protected void validateSandboxName(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("sandboxname-required");
        }

    }

    /**
     * snowAssetTagId field Validation
     *
     * @param field snowAssetTagId
     */
    protected void validateSnowAssetTagId(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("snowassettagid-required");
        }

    }

    /**
     * snowAssetTagName field Validation
     *
     * @param field snowAssetTagName
     */
    protected void validateSnowAssetTagName(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("snowassettagname-required");
        }

    }

    /**
     * stewardDepartment field Validation
     *
     * @param field stewardDepartment
     */
    protected void validateStewardDepartment(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("stewarddepartment-required");
        }

    }

    /**
     * stewardId field Validation
     *
     * @param field stewardId
     */
    protected void validateStewardId(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("stewardid-required");
        }

    }

    /**
     * stewardName field Validation
     *
     * @param field stewardName
     */
    protected void validateStewardName(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("stewardname-required");
        }

    }

    /**
     * systemCode field Validation
     *
     * @param field systemCode
     */
    protected void validateSystemCode(long field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.

    }

    /**
     * systemEntryId field Validation
     *
     * @param field systemEntryId
     */
    protected void validateSystemEntryId(long field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
    }

    /**
     * systemName field Validation
     *
     * @param field systemName
     */
    protected void validateSystemName(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("systemname-required");
        }

    }

    /**
     * systemTitle field Validation
     *
     * @param field systemTitle
     */
    protected void validateSystemTitle(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
    }

    /**
     * systemType field Validation
     *
     * @param field systemType
     */
    protected void validateSystemType(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("systemtype-required");
        }

    }

    /*  */
    protected List<String> _errors = new ArrayList<>();

}
