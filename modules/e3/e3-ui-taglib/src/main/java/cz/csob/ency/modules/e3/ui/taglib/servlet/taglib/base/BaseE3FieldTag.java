package cz.csob.ency.modules.e3.ui.taglib.servlet.taglib.base;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.modules.e3.constants.E3EntryModes;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

public class BaseE3FieldTag extends E3ContextTag {
    private static final Log log = LogFactoryUtil.getLog(BaseE3FieldTag.class);
    public static final String ATTRIBUTE_NAME = "name";
    private static final boolean _CLEAN_UP_SET_ATTRIBUTES = true;
    private String _name;

    @Override
    public void setContext(Map<String, Object> context) {
        if (context == null) return;

        setMode(GetterUtil.getString(context.getOrDefault("entryMode", E3EntryModes.VIEW_MODE)));

        if (!Validator.isBlank(this._name) && context.containsKey("_fields")) {
            super.setContext(
                    (Map<String, Object>) ((Map<String, Object>) context.get("_fields"))
                            .getOrDefault(this._name, Collections.EMPTY_MAP)
            );
        } else {
            super.setContext(context);
        }
    }

    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        _name = name;
        setContext(getContext());
    }

    @Override
    protected void cleanUp() {
        super.cleanUp();
        this._name = null;
    }

    @Override
    protected void setAttributes(HttpServletRequest httpServletRequest) {
        super.setAttributes(httpServletRequest);
        setNamespacedAttribute(httpServletRequest, ATTRIBUTE_NAME, getName());
    }
}

