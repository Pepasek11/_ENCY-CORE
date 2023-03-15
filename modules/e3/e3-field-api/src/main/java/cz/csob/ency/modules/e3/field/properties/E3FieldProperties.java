package cz.csob.ency.modules.e3.field.properties;

import com.liferay.portal.kernel.util.HashMapBuilder;
import cz.csob.ency.modules.e3.field.annotation.E3FieldDef;

import java.util.HashMap;
import java.util.Map;

public class E3FieldProperties {
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_PREDEFINED_VALUE = "predefinedValue";
    public static final String PROPERTY_LABEL = "label";
    public static final String PROPERTY_HINT = "hint";
    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_INDEXABLE = "indexable";
    public static final String PROPERTY_PERSISTENT = "persistent";

    private final HashMap<String, Object> _properties;

    public E3FieldProperties(E3FieldDef fd) {
        _properties = HashMapBuilder.
                <String, Object>put(PROPERTY_NAME, fd.name())
                .put(PROPERTY_PREDEFINED_VALUE, fd.predefinedValue())
                .put(PROPERTY_LABEL, fd.label())
                .put(PROPERTY_HINT, fd.hint())
                .put(PROPERTY_TYPE, fd.type())
                .put(PROPERTY_INDEXABLE, fd.indexable())
                .put(PROPERTY_PERSISTENT, fd.persistent())
                // todo
                .build();
    }

    public Object getProperty(String propertyName) {
        return getProperty(propertyName, null);
    }

    public Object getProperty(String propertyName, Object defaultValue) {
        if (_properties.containsKey(propertyName)) {
            return _properties.get(propertyName);
        }
        return defaultValue;
    }

    public boolean hasProperty(String propertyName) {
        return _properties.containsKey(propertyName);
    }

    /**
     * Gets !copy of properties map
     *
     * @return
     * @todo shoud be deep copy?
     */
    public Map<String, Object> getProperties() {

        return ((HashMap<String, Object>) _properties.clone());
    }

    public E3FieldProperties setProperty(String propertyName, Object value) {

        _properties.put(propertyName, value);
        return this;
    }

}
