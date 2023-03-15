package cz.csob.ency.modules.e3.field.model;

import cz.csob.ency.modules.e3.entry.model.E3Entry;

import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.Map;

public interface E3Field<T extends Serializable> extends Serializable {
    String FIELD_NAME = "name";

    T getValue(@Null E3Entry entry);

    String renderValueString(Serializable value);

    String getName();

    boolean hasValue(E3Entry entry);

    Object getProperty(String name);

    E3Field setProperty(String name, Object value);

    void setProperties(Map<String, Object> properties);

    Map<String, Object> getDisplayContext(E3Entry entry);

    E3FieldType getType();

    void addProperties(Map<String, Object> properties);

    String toString();

    String renderIndexString(E3Entry entry);
}
