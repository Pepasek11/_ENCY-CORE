package cz.csob.ency.modules.e3.ui.taglib.servlet.taglib;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import cz.csob.ency.modules.e3.constants.E3EntryModes;
import cz.csob.ency.modules.e3.ui.taglib.servlet.taglib.base.E3ContextTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTag;

public class EntryTag
        extends E3ContextTag implements BodyTag {
    private static final Log log = LogFactoryUtil.getLog(EntryTag.class);
    protected static final String _ATTRIBUTE_NAMESPACE = "e3-ui:entry:";
    private String _action = null;
    private String _appClass = null;
    private String _cssClass = null;
    private Long _entryId = null;
    private String _entryName = null;
    private boolean _escapeXml = true;
    private boolean _inlineLabels = false;
    private String _method = "post";
    private String _name = "fn";
    private String _onSubmit = null;
    private String _portletNamespace = null;
    private boolean _useNamespace = true;
    private boolean _validateOnBlur = true;

    public EntryTag() {
        super();
    }

    public String getAction() {
        return _action;
    }

    public void setAction(String action) {
        _action = action;
    }

    public String getAppClass() {
        return getStringContextValue("appClass", _appClass);
    }

    public void setAppClass(String appClass) {
        _appClass = appClass;
    }

    public String getCssClass() {
        return _cssClass;
    }

    public void setCssClass(String cssClass) {
        _cssClass = cssClass;
    }

    public long getEntryId() {
        return getLongContextValue("entryId", _entryId);
    }

    public void setEntryId(long entryId) {
        _entryId = entryId;
    }

    public String getEntryName() {
        return getStringContextValue("entryName", _entryName);
    }

    public String getEntryExtendedName() {
        return getStringContextValue("entryExtendedName", _entryName);
    }

    public String getModifiedDate() {
        return getStringContextValue("modifiedDate", _entryName);
    }

    public String getAuthorName() {
        return getStringContextValue("authorName", _entryName);
    }

    public String getUserName() {
        return getStringContextValue("modifiedUserName", _entryName);
    }

    public void setEntryName(String entryName) {
        _entryName = entryName;
    }

    public boolean getEscapeXml() {
        return getBooleanContextValue("escapeXml", _escapeXml);
    }

    public void setEscapeXml(boolean escapeXml) {
        _escapeXml = escapeXml;
    }

    public boolean getInlineLabels() {
        return getBooleanContextValue("inlineLabels", _inlineLabels);
    }

    public void setInlineLabels(boolean inlineLabels) {
        _inlineLabels = inlineLabels;
    }

    public String getMethod() {
        return _method;
    }

    public void setMethod(String method) {
        _method = method;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getOnSubmit() {
        return _onSubmit;
    }

    public void setOnSubmit(String onSubmit) {
        _onSubmit = onSubmit;
    }

    public String getPortletNamespace() {
        return _portletNamespace;
    }

    public void setPortletNamespace(String portletNamespace) {
        _portletNamespace = portletNamespace;
    }

    public boolean getUseNamespace() {
        return _useNamespace;
    }

    public void setUseNamespace(boolean useNamespace) {
        _useNamespace = useNamespace;
    }

    public boolean getValidateOnBlur() {
        return _validateOnBlur;
    }

    public void setValidateOnBlur(boolean validateOnBlur) {
        _validateOnBlur = validateOnBlur;
    }

    @Override
    protected void cleanUp() {
        super.cleanUp();

        _action = null;
        _appClass = null;
        _cssClass = null;
        _entryId = null;
        _entryName = null;
        _escapeXml = true;
        _inlineLabels = false;
        _method = "post";
        _name = null;
        _onSubmit = null;
        _portletNamespace = null;
        _useNamespace = true;
        _validateOnBlur = true;
    }

    @Override
    public int doStartTag() throws JspException {
        setAttributeNamespace(_ATTRIBUTE_NAMESPACE);
        return EVAL_BODY_BUFFERED;
    }

    @Override
    public void doInitBody() throws JspException {
        getRequest().setAttribute(_ATTRIBUTE_NAMESPACE + E3ContextTag.ATTRIBUTE_MODE, getMode());
        super.doInitBody();
    }

    @Override
    public int doAfterBody() throws JspException {
        return SKIP_BODY;
    }

    @Override
    protected String getPage() {
        if (getMode().equals(E3EntryModes.EDIT_MODE)) {
            return "/taglib/entry/page-edit.jsp";
        }
        return "/taglib/entry/page-view.jsp";
    }

    @Override
    protected void setAttributes(HttpServletRequest request) {
        super.setAttributes(request);
        setNamespacedAttribute(request, "body", (bodyContent != null ? bodyContent.getString() : StringPool.BLANK));
        setNamespacedAttribute(request, "action", getAction());
        setNamespacedAttribute(request, "appClass", getAppClass());
        setNamespacedAttribute(request, "cssClass", getCssClass());
        setNamespacedAttribute(request, "entryId", getEntryId());
        setNamespacedAttribute(request, "entryName", getEntryName());
        setNamespacedAttribute(request, "entryExtendedName", getEntryExtendedName());
        setNamespacedAttribute(request, "modifiedDate", getModifiedDate());
        setNamespacedAttribute(request, "name", getName());
        setNamespacedAttribute(request, "userName", getUserName());
        setNamespacedAttribute(request, "authorName", getAuthorName());
        setNamespacedAttribute(request, "escapeXml", getEscapeXml());
        setNamespacedAttribute(request, "inlineLabels", getInlineLabels());
        setNamespacedAttribute(request, "method", getMethod());
        setNamespacedAttribute(request, "onSubmit", getOnSubmit());
        setNamespacedAttribute(request, "portletNamespace", getPortletNamespace());
        setNamespacedAttribute(request, "useNamespace", getUseNamespace());
        setNamespacedAttribute(request, "validateOnBlur", getValidateOnBlur());
    }

}
