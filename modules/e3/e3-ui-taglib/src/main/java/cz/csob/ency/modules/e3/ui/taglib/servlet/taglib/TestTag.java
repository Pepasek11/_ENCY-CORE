package cz.csob.ency.modules.e3.ui.taglib.servlet.taglib;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import cz.csob.ency.modules.e3.ui.taglib.internal.servlet.ServletContextUtil;
import cz.csob.ency.modules.e3.ui.taglib.servlet.taglib.base.E3ContextTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTag;
import java.io.IOException;

public class TestTag // extends BodyTagSupport {
        extends E3ContextTag implements BodyTag {
    private static final Log log = LogFactoryUtil.getLog(EntryTag.class);
    private static final String _ATTRIBUTE_NAMESPACE = "e3-frontend:entry:";

    private String _body = StringPool.BLANK;

    @Override
    public int doStartTag() throws JspException {
        setAttributeNamespace(_ATTRIBUTE_NAMESPACE);
        return EVAL_BODY_BUFFERED;
    }

    @Override
    public void doInitBody() throws JspException {

        super.doInitBody();
    }

    @Override
    public int doAfterBody() throws JspException {
        setBody(bodyContent.getString());
        //log.info("Body: " + bodyContent.getString());
        bodyContent.clearBody();
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            // Write from bodyContent writer to original writer.
       //     pageContext.getOut().print(bodyContent.getString());
            // Now we're back to the original writer.
            pageContext.getOut().print("doEndTag()");
            return super.doEndTag();
        } catch (IOException ioe) {
            throw new JspException(ioe.getMessage());
        }
    }

    protected void setBody(String body) {
        this._body = body;
    }

    @Override
    public void setPageContext(PageContext pageContext) {
        super.setPageContext(pageContext);

        setServletContext(ServletContextUtil.getServletContext());
    }

    @Override
    protected String getPage() {
        return "/taglib/test/test.jsp";
    }

    @Override
    protected void setAttributes(HttpServletRequest httpServletRequest) {
        super.setAttributes(httpServletRequest);
        setNamespacedAttribute(httpServletRequest, "body", this._body);
        setNamespacedAttribute(httpServletRequest, "xxxxxxxxxxxxxxxxx", "xxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

}
