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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.ModelValidator;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.modules.apps.meta.cds.exception.ColumnEntryValidateException;
import cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry;
import cz.csob.ency.modules.apps.meta.cds.service.TableEntryLocalServiceUtil;
import cz.csob.ency.modules.apps.meta.cds.service.impl.ColumnEntryLocalServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * ColumnEntry Validator 
 *
 * @author Miroslav Čermák
 *
 */
public class ColumnEntryValidator implements ModelValidator<ColumnEntry> {

    @Override
    public void validate(ColumnEntry entry) throws PortalException {
        /*   */
        // Field columnType
        validateColumnType(entry.getColumnType());

        // Field columnName
        validateColumnName(entry.getColumnName());

        // Field columnFullName
        validateColumnFullName(entry.getColumnFullName());

        // Field tableEntryId
        validateTableEntryId(entry.getTableEntryId());

        // Field tableName
        validateTableName(entry.getTableName());

        // Field systemName
        validateSystemName(entry.getSystemName());

        // Field databaseName
        validateDatabaseName(entry.getDatabaseName());
/*
        // Field description
        validateDescription(entry.getDescription());

        // Field dataType
        validateDataType(entry.getDataType());

        // Field dataSize
        validateDataSize(entry.getDataSize());

        // Field isPrimaryKey
        validateIsPrimaryKey(entry.getIsPrimaryKey());

        // Field isNotNull
        validateIsNotNull(entry.getIsNotNull());

        // Field isActive
        validateIsActive(entry.getIsActive());
*/
        /*  */
/*
        validateColumnName(entry.getColumnName());
*/
        if (0 < _errors.size()) {
            _log.debug("Validation errors: "+_errors);
            throw new ColumnEntryValidateException(_errors);
        }

    }

    /**
     * columnEntryId field Validation
     *
     * @param field columnEntryId
     */
    protected void validateColumnEntryId(long field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
    }

    /**
     * columnFullName field Validation
     *
     * @param field columnFullName
     */
    protected void validateColumnFullName(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("columnfullname-required");
        }

    }

    /**
     * columnName field Validation
     *
     * @param field columnName
     */
    protected void validateColumnName(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("columnname-required");
        }

    }

    /**
     * columnType field Validation
     *
     * @param field columnType
     */
    protected void validateColumnType(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("columntype-required");
        }

    }

    /**
     * dataSize field Validation
     *
     * @param field dataSize
     */
    protected void validateDataSize(long field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.

    }

    /**
     * dataType field Validation
     *
     * @param field dataType
     */
    protected void validateDataType(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("datatype-required");
        }

    }

    /**
     * databaseName field Validation
     *
     * @param field databaseName
     */
    protected void validateDatabaseName(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("databasename-required");
        }

    }

    /**
     * description field Validation
     *
     * @param field description
     */
    protected void validateDescription(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("description-required");
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
     * isNotNull field Validation
     *
     * @param field isNotNull
     */
    protected void validateIsNotNull(boolean field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.

    }

    /**
     * isPrimaryKey field Validation
     *
     * @param field isPrimaryKey
     */
    protected void validateIsPrimaryKey(boolean field) {
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
     * tableEntryId field Validation
     *
     * @param field tableEntryId
     */
    protected void validateTableEntryId(long field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (field <= 0) {
            _errors.add("tableentryid-required");
        }
/*
        try {
            TableEntryLocalServiceUtil.getTableEntry(field);
        } catch (PortalException e) {
            _errors.add("tableentryid-not-found");
        }

 */
    }

    /**
     * tableName field Validation
     *
     * @param field tableName
     */
    protected void validateTableName(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("tablename-required");
        }

    }

    /*  */
    protected List<String> _errors = new ArrayList<>();

    private static final Log _log = LogFactoryUtil.getLog(
            ColumnEntryValidator.class);

}
