package cz.csob.ency.modules.e3.field.text;

import com.liferay.portal.kernel.util.HashMapBuilder;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.field.constants.E3FieldTypeConstants;
import cz.csob.ency.modules.e3.field.model.E3Field;
import cz.csob.ency.modules.e3.field.utils.E3FieldContextProvider;
import org.osgi.service.component.annotations.Component;

import java.util.Map;

@Component(
        immediate = true,
        property = "e3.field.type.name="+ E3FieldTypeConstants.TEXT,
        service = E3FieldContextProvider.class
)
public class TextE3FieldContextProvider
        implements E3FieldContextProvider {
    @Override
    public Map<String, Object> getRenderContext(E3Field field, E3Entry entry) {

        return HashMapBuilder.<String, Object>put(
                "label", field.getProperty("label")
        ).put(
                "name", field.getProperty("name")
        ).put(
                "hint", field.getProperty("hint")
        ).put(
                "predefinedValue", field.getProperty("predefinedValue")
        ).build();
    }
}
