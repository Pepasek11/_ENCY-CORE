package cz.csob.ency.modules.e3.entry.utils;

import com.liferay.petra.string.StringPool;
import cz.csob.ency.modules.e3.entry.model.E3Entry;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

public interface E3EntryIndexer {

    public static final String ENTRY_FIELD_NAMESPACE = "e3";

    public static final String DDM_FIELD_PREFIX =
            ENTRY_FIELD_NAMESPACE + E3EntryIndexer.DDM_FIELD_SEPARATOR;

    public static final String DDM_FIELD_SEPARATOR =
            StringPool.DOUBLE_UNDERLINE;

    Map<String, Serializable> getIndexableFieldsValues(E3Entry entry, Locale locale);

    public String extractIndexableContent(E3Entry entry, Locale locale);
}
