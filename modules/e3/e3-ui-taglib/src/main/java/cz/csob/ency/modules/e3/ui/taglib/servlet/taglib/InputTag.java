package cz.csob.ency.modules.e3.ui.taglib.servlet.taglib;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import cz.csob.ency.modules.e3.ui.taglib.servlet.taglib.base.E3StringValueTag;

import javax.servlet.http.HttpServletRequest;

public class InputTag extends E3StringValueTag {
    private static final Log log = LogFactoryUtil.getLog(InputTag.class);
    private static final boolean _CLEAN_UP_SET_ATTRIBUTES = true;

    private String _title;
    private String _label;
    private String _id;


    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getTitle() {
        return getStringContextValue("title", _title);
    }

    public void setTitle(String title) {
        this._title = title;
    }

    public String getLabel() {
        return getStringContextValue("label", _label);
    }

    public void setLabel(String label) {
        this._label = label;
    }

    @Override
    protected void cleanUp() {
        super.cleanUp();
        _id = null;
        _title = null;
        _label = null;
    }

    @Override
    protected boolean isCleanUpSetAttributes() {
        return _CLEAN_UP_SET_ATTRIBUTES;
    }

    @Override
    protected String getPage() {
        return "/taglib/input/page.jsp";
    }

    @Override
    protected void setAttributes(HttpServletRequest httpServletRequest) {
        setAttributeNamespace("e3-ui:input:");
        super.setAttributes(httpServletRequest);
        setNamespacedAttribute(httpServletRequest, "id", getId());
        setNamespacedAttribute(httpServletRequest, "label", getLabel());
        setNamespacedAttribute(httpServletRequest, "value", getValue());
    }
}
