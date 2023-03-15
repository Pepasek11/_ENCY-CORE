package cz.csob.ency.modules.e3.field.model.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.field.model.E3Field;
import cz.csob.ency.modules.e3.field.model.E3FieldType;
import cz.csob.ency.modules.e3.field.properties.E3FieldProperties;

import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.Map;
import java.util.StringJoiner;

public class E3FieldImpl<T extends Serializable> implements E3Field<T> {
    private static final Log _log = LogFactoryUtil.getLog(E3FieldImpl.class);
    private Map<String, Object> _properties;
    private E3FieldType _fieldType;

    public E3FieldImpl(E3FieldType fieldType, E3FieldProperties properties) {
        _fieldType = fieldType;
        _properties = properties.getProperties();
    }

    @Override
    public T getValue(E3Entry entry) {
        if(Validator.isNull(entry)){
            // @todo nebude null delat problemy?
            return null;
        }
        return (T) entry.getValue(getName());
    }

    @Override
    public String renderValueString(Serializable value) {
        return null;
    }

    @Override
    public String getName() {
        String name = GetterUtil.getString(_properties.get(E3FieldProperties.PROPERTY_NAME), StringPool.BLANK);

        if (Validator.isBlank(name)) {
            _log.error("EncyField does not have name!");
        }
        return name;
    }


    @Override
    public boolean hasValue(E3Entry entry) {
        return _fieldType.hasValue(getValue(entry));
    }

    @Override
    public Object getProperty(String name) {
        if (_properties.containsKey(name)) {
            return _properties.get(name);
        }
        return null;
    }

    @Override
    public E3FieldImpl setProperty(String name, Object value) {
        _properties.put(name, value);
        return this;
    }

    @Override
    public void setProperties(Map<String, Object> properties) {
        _properties = properties;
    }

    @Override
    public Map<String, Object> getDisplayContext(@Null E3Entry entry) {
        Map<String, Object> context = _fieldType.getContextProvider().getRenderContext(this, entry);
        context.put("value", _fieldType.getFieldRederer().renderValue(this, entry));
        return context;
    }

    @Override
    public E3FieldType getType() {
        return _fieldType;
    }

    @Override
    public void addProperties(Map<String, Object> properties) {
        _properties.putAll(properties);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", E3FieldImpl.class.getSimpleName() + "[", "]")
                .add("_fieldType=" + _fieldType.getClass().getSimpleName())
                .add("_properties=" + _properties)
                .toString();
    }

    @Override
    public String renderIndexString(E3Entry entry) {
        return _fieldType.getFieldRederer().renderIndexableValue(this, entry);
    }
}
