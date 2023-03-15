package cz.csob.ency.modules.e3.field.utils;

import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.field.model.E3Field;

import java.util.Map;

public interface E3FieldContextProvider {
    Map<String, Object> getRenderContext(E3Field field, E3Entry entry);
}
