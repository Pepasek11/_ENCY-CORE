package cz.csob.ency.modules.e3.field.text;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.GetterUtil;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.field.constants.E3FieldTypeConstants;
import cz.csob.ency.modules.e3.field.model.E3Field;
import cz.csob.ency.modules.e3.field.properties.E3FieldProperties;
import cz.csob.ency.modules.e3.field.utils.E3FieldRenderer;
import org.osgi.service.component.annotations.Component;

import javax.validation.constraints.Null;

@Component(
        immediate = true,
        property = "e3.field.type.name="+ E3FieldTypeConstants.TEXT,
        service = E3FieldRenderer.class
)
public class TextE3FieldRenderer implements E3FieldRenderer {
    @Override
    public String renderIndexableValue(E3Field field, @Null E3Entry entry) {
        if (!GetterUtil.getBoolean(field.getProperty(E3FieldProperties.PROPERTY_INDEXABLE), false)) {
            return StringPool.BLANK;
        }
        String text = GetterUtil.getString(field.getValue(entry),StringPool.BLANK);
        return text.trim();
    }

    @Override
    public Object renderValue(E3Field field, @Null E3Entry entry) {
        String text = GetterUtil.getString(field.getValue(entry),StringPool.BLANK);
        return text.trim();
    }
}




