package cz.csob.ency.modules.e3.entry.internal.search;

import com.liferay.portal.kernel.search.Field;

import java.util.Locale;
import java.util.Map;

public class E3SearchField extends Field {
    public static final String SUMMARY = "summary";
    public static final String EXTENDED_NAME = "extendedName";
    public static final String MODIFIEDBY_USER_NAME = "modifiedByUserName";
    public static final String CREATEDBY_USER_NAME = "createdByUserName";
    public static final String APP_CLASS = "appClass";
    public static final String APP_CODE = "appCode";

    public E3SearchField(String name) {
        super(name);
    }

    public E3SearchField(String name, Map<Locale, String> localizedValues) {
        super(name, localizedValues);
    }

    public E3SearchField(String name, String value) {
        super(name, value);
    }

    public E3SearchField(String name, String[] values) {
        super(name, values);
    }
}
