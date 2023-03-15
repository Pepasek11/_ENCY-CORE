package cz.csob.ency.modules.e3.app.model;

import com.liferay.petra.string.StringPool;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.field.model.E3Field;

import javax.portlet.ActionRequest;
import java.io.Serializable;
import java.util.Map;

public interface E3App extends Serializable {
    Class<?> getAppClass();

    String getAppCode();

    String getAppMainPortletName();

    String getAppName();

    Map<String, Serializable> getCustomFieldsRenderContext(E3Entry entry);

    String getDescription();

    default String getEntryDescription(E3Entry entry) {
        return getEntryExtendedName(entry);
    }

    default String getEntryExtendedName(E3Entry entry) {
        return entry.getName() + " in " + getAppCode();
    }

    default String getEntrySummary(E3Entry entry) {
        return StringPool.BLANK;
    }

    Map<String, E3Field> getFields();

    Map<String, E3Field> getIndexableFields();

    Map<String, Serializable> getRenderContext(E3Entry entry);

    boolean hasWorkflow();

    boolean isEntryApproved(E3Entry entry);

    boolean isIndexable();

    boolean isVersioned();

    void setEntryValues(ActionRequest actionRequest, E3Entry e3Entry);
}
