// 
/*   */
/**
*  Copyright (C) 2021 Yasuyuki Takeo All rights reserved.
*
*  This program is free software: you can redistribute it and/or modify
*  it under the terms of the GNU Lesser General Public License as published by
*  the Free Software Foundation, either version 3 of the License, or
*  (at your option) any later version.
*
*  This program is distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
*  GNU Lesser General Public License for more details.
*/
/*  */ 

package cz.csob.ency.modules.apps.meta.cds.service.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.ModelValidator;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.modules.apps.meta.cds.exception.TableEntryValidateException;
import cz.csob.ency.modules.apps.meta.cds.model.TableEntry;
import cz.csob.ency.modules.apps.meta.cds.service.SystemEntryLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * TableEntry Validator 
 * 
 * @author Miroslav Čermák
 *
 */
public class TableEntryValidator implements ModelValidator<TableEntry> {

	@Override
	public void validate(TableEntry entry) throws PortalException {
/*   */
        // Field tableEntryId
        validateTableEntryId(entry.getTableEntryId());

        // Field tableName
        validateTableName(entry.getTableName());

        // Field tableFullName
        validateTableFullName(entry.getTableFullName());

        // Field tableType
        validateTableType(entry.getTableType());

        // Field tableDatabase
        validateTableDatabase(entry.getTableDatabase());

        // Field systemEntryId
        validateSystemEntryId(entry.getSystemEntryId());

        // Field systemName
        validateSystemName(entry.getSystemName());
/*
        // Field description
        validateDescription(entry.getDescription());

        // Field dsaUrl
        validateDsaUrl(entry.getDsaUrl());

        // Field contactPersonName
        validateContactPersonName(entry.getContactPersonName());

        // Field contactPersonId
        validateContactPersonId(entry.getContactPersonId());

        // Field specificationOwnerName
        validateSpecificationOwnerName(entry.getSpecificationOwnerName());

        // Field specificationOwnerId
        validateSpecificationOwnerId(entry.getSpecificationOwnerId());

        // Field unstructuredClause
        validateUnstructuredClause(entry.getUnstructuredClause());

        // Field isActive
        validateIsActive(entry.getIsActive());
*/
		if (0 < _errors.size()) {
			throw new TableEntryValidateException(_errors);
		}
		
	}

    /**
    * tableName field Validation
    *
    * @param tableName
    */
    /*
    protected void validateTableName(String tableName) {
        if (Validator.isNotNull(tableName)) {
            int tableNameMaxLength = ModelHintsUtil.getMaxLength(
                TableEntry.class.getName(), "tableName");

            if (tableName.length() > tableNameMaxLength) {
                _errors.add("tableName has more than " + tableNameMaxLength +
                " characters");
            }
        }
    }
    */

/*   */
    /**
    * tableEntryId field Validation
    *
    * @param field tableEntryId
    */
    protected void validateTableEntryId(long field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
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

    /**
    * tableFullName field Validation
    *
    * @param field tableFullName
    */
    protected void validateTableFullName(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("tablefullname-required");
        }

    }

    /**
    * tableType field Validation
    *
    * @param field tableType
    */
    protected void validateTableType(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("tabletype-required");
        }

    }

    /**
    * tableDatabase field Validation
    *
    * @param field tableDatabase
    */
    protected void validateTableDatabase(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("tabledatabase-required");
        }

    }

    /**
    * systemEntryId field Validation
    *
    * @param field systemEntryId
    */
    protected void validateSystemEntryId(long field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
		if(field <= 0) {
    		_errors.add("systementryid-required");
    	}

    	try {
    		SystemEntryLocalServiceUtil.getSystemEntry(field);
    	} catch(PortalException e) {
    		_errors.add("systementryid-not-found");
    	}
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
    * dsaUrl field Validation
    *
    * @param field dsaUrl
    */
    protected void validateDsaUrl(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("dsaurl-required");
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
    * specificationOwnerName field Validation
    *
    * @param field specificationOwnerName
    */
    protected void validateSpecificationOwnerName(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("specificationownername-required");
        }

    }

    /**
    * specificationOwnerId field Validation
    *
    * @param field specificationOwnerId
    */
    protected void validateSpecificationOwnerId(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("specificationownerid-required");
        }

    }

    /**
    * unstructuredClause field Validation
    *
    * @param field unstructuredClause
    */
    protected void validateUnstructuredClause(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (Validator.isBlank(field)) {
            _errors.add("unstructuredclause-required");
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

/*  */ 	
	

	protected List<String> _errors = new ArrayList<>();

}
