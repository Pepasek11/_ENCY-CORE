package cz.csob.ency.modules.e3.field.service;

import cz.csob.ency.modules.e3.field.model.E3FieldType;

import java.util.Set;

public interface E3FieldTypeLocalService {
    E3FieldType getFallbackFieldType();

    E3FieldType getFieldType(String name);

    Set<E3FieldType> getFieldTypes();

    Set<String> getFieldTypesNames();
}
