package cz.csob.ency.modules.e3.field.utils;

import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.field.model.E3Field;

public interface E3FieldRenderer {
    String renderIndexableValue(E3Field field, E3Entry entry);

    Object renderValue(E3Field field, E3Entry entry);
}
