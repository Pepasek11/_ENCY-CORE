package cz.csob.ency.modules.e3.ui.taglib.servlet.taglib.base;

import javax.servlet.http.HttpServletRequest;

public class E3StringValueTag extends BaseE3FieldTag{
    private String _value = null;

    public String getValue() {
        return getStringContextValue("value",_value);
    }

    public void setValue(String value) {
        this._value = value;
    }

    @Override
    protected void cleanUp() {
        super.cleanUp();
        this._value = null;
    }

    @Override
    protected void setAttributes(HttpServletRequest httpServletRequest) {
        super.setAttributes(httpServletRequest);
        setNamespacedAttribute(httpServletRequest, "value", getValue());
    }

}
