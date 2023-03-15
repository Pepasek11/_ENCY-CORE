package cz.csob.ency.modules.e3.field.model;

import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.modules.e3.field.properties.E3FieldProperties;
import cz.csob.ency.modules.e3.field.utils.E3FieldContextProvider;
import cz.csob.ency.modules.e3.field.utils.E3FieldRenderer;

public abstract class E3FieldType {
    public abstract String getName();

    public abstract E3FieldContextProvider getContextProvider();

    public abstract E3FieldRenderer getFieldRederer();

    public abstract E3Field getFieldInstance(E3FieldProperties properties);

    public boolean hasValue(Object value) {
        return Validator.isNotNull(value);
    }

}
