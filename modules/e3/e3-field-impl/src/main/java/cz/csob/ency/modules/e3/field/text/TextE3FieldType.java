package cz.csob.ency.modules.e3.field.text;

import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.modules.e3.field.constants.E3FieldTypeConstants;
import cz.csob.ency.modules.e3.field.model.E3FieldType;
import cz.csob.ency.modules.e3.field.model.impl.E3FieldImpl;
import cz.csob.ency.modules.e3.field.properties.E3FieldProperties;
import cz.csob.ency.modules.e3.field.utils.E3FieldContextProvider;
import cz.csob.ency.modules.e3.field.utils.E3FieldRenderer;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "e3.field.type.name=text",
        service = E3FieldType.class
)
public class TextE3FieldType extends E3FieldType {
    @Reference(target = "(e3.field.type.name=" + E3FieldTypeConstants.TEXT + ")")
    E3FieldRenderer e3FieldRenderer;

    @Reference(target = "(e3.field.type.name=" + E3FieldTypeConstants.TEXT + ")")
    E3FieldContextProvider e3FieldContextProvider;

    @Override
    public String getName() {
        return E3FieldTypeConstants.TEXT;
    }

    @Override
    public E3FieldContextProvider getContextProvider() {
        return e3FieldContextProvider;
    }

    @Override
    public E3FieldRenderer getFieldRederer() {
        return e3FieldRenderer;
    }

    @Override
    public E3FieldImpl getFieldInstance(E3FieldProperties properties) {
        return new E3FieldImpl<String>(this, properties);
    }

    @Override
    public boolean hasValue(Object value) {
        return !Validator.isBlank(value.toString());
    }
}
