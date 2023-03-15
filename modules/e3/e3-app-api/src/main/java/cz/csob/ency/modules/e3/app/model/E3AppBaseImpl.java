package cz.csob.ency.modules.e3.app.model;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.*;
import cz.csob.ency.modules.e3.app.annotation.E3AppDef;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.field.model.E3Field;
import cz.csob.ency.modules.e3.field.model.E3FieldType;
import cz.csob.ency.modules.e3.field.properties.E3FieldProperties;
import cz.csob.ency.modules.e3.field.service.E3FieldTypeServiceUtils;

import javax.portlet.ActionRequest;
import javax.portlet.PortletException;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.*;

@E3AppDef(
        fields = {}
)
public abstract class E3AppBaseImpl implements E3App {
    private final static Log _log = LogFactoryUtil.getLog(E3AppBaseImpl.class);

    public E3AppBaseImpl() {
        init();
    }

    @Override
    public Class<?> getAppClass() {
        return this.getClass();
    }

    @Override
    public String getAppCode() {
        return this._code;
    }

    @Override
    public String getAppName() {
        return this._name;
    }

    public Map<String, Serializable> getCustomFieldsRenderContext(@Null E3Entry entry) {
        //@todo
        return Collections.emptyMap();
    }

    @Override
    public String getDescription() {
        return this._description;
    }

    @Override
    public String getEntryExtendedName(@Null E3Entry entry) {
        if (Validator.isNull(entry)) {
            return StringPool.BLANK;
        }
        return entry.getName();
    }

    @Override
    public Map<String, E3Field> getFields() {
        Map<String, E3Field> fieldsMap = new HashMap<>();

        _fields.forEach((fieldCode, fieldProperties) -> {
            String typeName = GetterUtil.getString(fieldProperties.getProperty("type"), "");
            if (!Validator.isBlank(typeName)) {

                E3FieldType eft = E3FieldTypeServiceUtils.getFieldType(typeName);
                if (eft != null) {
                    fieldsMap.put(fieldCode, eft.getFieldInstance(fieldProperties));
                }
            }
        });

        return fieldsMap;
    }

    @Override
    public final Map<String, E3Field> getIndexableFields() {
        Map<String, E3Field> indexableFields = new HashMap<>();

        _fields.forEach((fieldCode, fieldProperties) -> {
            Boolean indexable = true;
            if (fieldProperties.hasProperty(E3FieldProperties.PROPERTY_INDEXABLE)) {
                indexable = GetterUtil.getBoolean(fieldProperties.getProperty(E3FieldProperties.PROPERTY_INDEXABLE));
            }

            String typeName = GetterUtil.getString(fieldProperties.getProperty("type"), "");
            //  _log.info("Checking field " + fieldCode + ". Indexable:" + indexable);
            if (indexable && !Validator.isBlank(typeName)) {
                E3FieldType eft = E3FieldTypeServiceUtils.getFieldType(typeName);
                if (eft != null) {
                    indexableFields.put(fieldCode, eft.getFieldInstance(fieldProperties));
                }
            }
        });

        return indexableFields;
    }

    @Override
    public Map<String, Serializable> getRenderContext(@Null E3Entry entry) {
        Map<String, Serializable> context = new HashMap<>();
        context = HashMapBuilder.<String, Serializable>put(
                "appName", getAppName()
        ).put(
                "appCode", getAppCode()
        ).put(
                "appClass", getAppClass().getName()
        ).put(
                "entryId", 0
        ).put(
                "indexable", isIndexable()
        ).put(
                "versioned", isVersioned()
        ).put(
                "version", 0
        ).put(
                "draft", true
        ).build();

        if (Validator.isNotNull(entry)) {
            context.putAll(HashMapBuilder.<String, Serializable>put(
                    "entryName", entry.getName()
                    ).put(
                    "entryExtendedName", getEntryExtendedName(entry)
                    ).put(
                    "entryId", entry.getEntryId()
                    ).put(
                    "version", entry.getMvccVersion()
                    ).put(
                    "draft", entry.isHead()
                    ).put(
                    "modifiedDate", entry.getModifiedDate()
                    ).put(
                    "modifiedUserId", entry.getUserId()
                    ).put(
                    "modifiedUserName", entry.getUserName()
                    ).put(
                    "createdDate", entry.getCreateDate()
                    ).put(
                    "authorId", entry.getAuthorId()
                    ).put(
                    "authorName", entry.getAuthorName()
                    ).build()
            );
        }

        return context;

    }

    @Override
    public boolean hasWorkflow() {
        return false;
    }

    public boolean isEntryApproved(E3Entry entry) {
        // todo podle default workflow
        return true;
    }

    @Override
    public boolean isIndexable() {
        return this._isIndexable;
    }

    @Override
    public boolean isVersioned() {
        return this._isVersioned;
    }

    @Override
    public void setEntryValues(ActionRequest actionRequest, E3Entry entry) {
        Map<String, E3Field> fields = getFields();

        Enumeration<String> parameterNames = actionRequest.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            if(fields.containsKey(parameterName)) {
                // @todo convert string action value to value object
                entry.setValue(parameterName, actionRequest.getParameter(parameterName));
            }
        }

        String entryName = ParamUtil.getString(actionRequest, "entryName", StringPool.BLANK);
        if (Validator.isBlank(entryName)) {
            if (Validator.isBlank(entry.getName())) {
                // @todo EmptyName Exception?
            }
        } else {
            entry.setName(entryName);
        }
    }

    private void init() {
        Class<?> clazz = this.getClass();

        if (!clazz.isAnnotationPresent(E3AppDef.class)) {
            _log.error("Class {className:" + clazz + "} is not Annotated as E3AppDef");
            return;
        }

        E3AppDef a = clazz.getAnnotation(E3AppDef.class);

        this._name = a.name();
        if (Validator.isBlank(this._name)) {
            this._name = this.getClass().getSimpleName();
        }

        this._code = a.code();
        if (Validator.isBlank(this._name)) {
            this._name = this.getClass().getSimpleName();
        }

        this._description = a.description();
        this._isVersioned = a.versioned();
        this._isIndexable = a.indexable();

        Arrays.stream(a.fields()).sequential().forEach(f -> {
            String fieldName = f.name();
            if (!Validator.isBlank(fieldName)) {
                if (RESERVED_FIELD_CODES.contains(fieldName)) {
                    _log.error("Skipping field definition for field with reserved name. {appClass:"
                            + this.getAppClass().getName() + ", fieldName:" + fieldName + "}");
                } else {
                    _fields.put(fieldName, new E3FieldProperties(f));
                }
            }
        });
    }
    //@todo
    protected final List<String> RESERVED_FIELD_CODES = Arrays.asList("version", "entryName", "appClass", "entryId");
    protected String _code = "";
    protected String _description = "";
    protected Map<String, E3FieldProperties> _fields = new HashMap<>();
    protected boolean _isIndexable = true;
    protected boolean _isVersioned = true;
    protected String _name = "";
}
