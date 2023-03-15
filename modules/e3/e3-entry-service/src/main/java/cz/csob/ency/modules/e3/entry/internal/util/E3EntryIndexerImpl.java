package cz.csob.ency.modules.e3.entry.internal.util;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import cz.csob.ency.modules.e3.app.model.E3App;
import cz.csob.ency.modules.e3.app.service.E3AppLocalServiceUtil;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.entry.utils.E3EntryIndexer;
import cz.csob.ency.modules.e3.field.model.E3Field;
import org.osgi.service.component.annotations.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component(
        immediate = true, service = E3EntryIndexer.class
)
public class E3EntryIndexerImpl implements E3EntryIndexer {

    private static final Log _log = LogFactoryUtil.getLog(E3EntryIndexerImpl.class);

    @Override
    public Map<String, Serializable> getIndexableFieldsValues(E3Entry entry, Locale locale) {
        Map<String, Serializable> fieldValues = new HashMap<>();
        E3App e3App = E3AppLocalServiceUtil.getApp(entry);

        Map<String, E3Field> indexableFields = e3App.getIndexableFields();

        indexableFields.forEach((fieldName, encyField) -> {
            fieldValues.put(fieldName, encyField.getValue(entry));
        });

        return fieldValues;
    }

    @Override
    public String extractIndexableContent(E3Entry entry, Locale locale) {
        //  Format dateFormat = FastDateFormatFactoryUtil.getSimpleDateFormat(
        //          PropsUtil.get(PropsKeys.INDEX_DATE_FORMAT_PATTERN));

        StringBundler sb = new StringBundler();
        E3App e3App = E3AppLocalServiceUtil.getApp(entry);

        sb.append(entry.getName()).append(StringPool.SPACE);

        Map<String, E3Field> indexableFields = e3App.getIndexableFields();

        indexableFields.forEach((fieldName, encyField) -> {
            sb.append(encyField.renderIndexString(entry));
            sb.append(StringPool.SPACE);
        });

        /*
        Map<String, Serializable> fields = entry.getValues();
        fields.forEach((name, value) -> {
            try {

                String indexType = ddmStructure.getFieldProperty(
                        field.getName(), "indexType");

                if (Validator.isNull(indexType) || indexType.equals("none")) {
                    continue;
                }

                Serializable value = field.getValue(locale);


                if (value instanceof Boolean || value instanceof Number) {
                    sb.append(value);
                    sb.append(StringPool.SPACE);
                } else if (value instanceof Date) {
                    sb.append(dateFormat.format(value));
                    sb.append(StringPool.SPACE);
                } else if (value instanceof Date[]) {
                    Date[] dates = (Date[]) value;

                    for (Date date : dates) {
                        sb.append(dateFormat.format(date));
                        sb.append(StringPool.SPACE);
                    }
                } else if (value instanceof Object[]) {
                    Object[] values = (Object[]) value;

                    for (Object object : values) {
                        sb.append(object);
                        sb.append(StringPool.SPACE);
                    }
                } else {
                    /*
                    @todo
                    String valueString = _getSortableValue(
                            ddmStructure.getDDMFormField(field.getName()), locale,
                            value);

                    String type = field.getType();

                    if (type.equals(DDMFormFieldTypeConstants.SELECT)) {
                        JSONArray jsonArray = JSONFactoryUtil.createJSONArray(
                                valueString);

                        String[] stringArray = ArrayUtil.toStringArray(
                                jsonArray);

                        sb.append(stringArray);

                        sb.append(StringPool.SPACE);
                    }
                    else {
                        if (type.equals(DDMFormFieldTypeConstants.RICH_TEXT)) {
                            valueString = HtmlUtil.extractText(valueString);
                        }
                        sb.append(valueString);

                        sb.append(StringPool.SPACE);
                    }
                    // * /
                    sb.append(value);
                    sb.append(StringPool.SPACE);
                }
            } catch (Exception exception) {
                if (_log.isWarnEnabled()) {
                    _log.warn(exception, exception);
                }
            }
        });
*/
        return sb.toString();

    }
}
