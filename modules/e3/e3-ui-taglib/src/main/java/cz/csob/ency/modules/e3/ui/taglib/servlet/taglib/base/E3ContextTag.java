package cz.csob.ency.modules.e3.ui.taglib.servlet.taglib.base;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.taglib.util.IncludeTag;
import cz.csob.ency.modules.e3.constants.E3EntryModes;
import cz.csob.ency.modules.e3.ui.taglib.internal.servlet.ServletContextUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;
import java.util.HashMap;
import java.util.Map;

public class E3ContextTag extends IncludeTag {
    private static final Log log = LogFactoryUtil.getLog(E3ContextTag.class);
    public static final String ATTRIBUTE_CONTEXT = "context";
    public static final String ATTRIBUTE_MODE = "mode";
    private static final boolean _CLEAN_UP_SET_ATTRIBUTES = true;
    private Map<String, Object> _context;
    private String _mode;

    public Map<String, Object> getContext() {
        if (this._context == null) {
            this._context = new HashMap<>();
        }
        return _context;
    }

    public void setContext(Map<String, Object> context) {
        this._context = context;
        return;
    }

    public String getMode() {
        return GetterUtil.getString(
                this._mode
                , E3EntryModes.VIEW_MODE
        );
    }

    public void setMode(String mode) {
        this._mode = mode;
    }

    protected Boolean getBooleanContextValue(String key, Boolean usrValue) {
        return getBooleanContextValue(key, usrValue, null);
    }

    protected Boolean getBooleanContextValue(String key, Boolean usrValue, Boolean defValue) {
        if (Validator.isNotNull(usrValue)) {
            return usrValue;
        }

        if (Validator.isNull(this._context)) {
            return defValue;
        }

        return GetterUtil.getBoolean(this._context.get(key), defValue);
    }


    protected String getStringContextValue(String key, String usrValue) {
        return getStringContextValue(key, usrValue, StringPool.BLANK);
    }

    protected String getStringContextValue(String key, String usrValue, String defValue) {
        if (Validator.isNotNull(usrValue)) {
            return usrValue;
        }

        if (Validator.isNull(this._context)) {
            return StringPool.BLANK;
        }

        return GetterUtil.getString(this._context.get(key), defValue);
    }

    protected Long getLongContextValue(String key, Long usrValue) {
        return getLongContextValue(key, usrValue, 0L);
    }

    protected Long getLongContextValue(String key, Long usrValue, Long defValue) {
        if (Validator.isNotNull(usrValue)) {
            return usrValue;
        }

        if (Validator.isNull(this._context)) {
            return defValue;
        }

        return GetterUtil.getLong(this._context.get(key), defValue);
    }

    @Override
    protected void cleanUp() {
        super.cleanUp();
        this._context = null;
        this._mode = null;
    }

    @Override
    public void setPageContext(PageContext pageContext) {
        super.setPageContext(pageContext);

        setServletContext(ServletContextUtil.getServletContext());
    }

    @Override
    protected boolean isCleanUpSetAttributes() {
        return _CLEAN_UP_SET_ATTRIBUTES;
    }

    @Override
    protected void setAttributes(HttpServletRequest httpServletRequest) {
        super.setAttributes(httpServletRequest);
        setNamespacedAttribute(httpServletRequest, ATTRIBUTE_CONTEXT, getContext());
        setNamespacedAttribute(httpServletRequest, ATTRIBUTE_MODE, getMode());
    }
}
