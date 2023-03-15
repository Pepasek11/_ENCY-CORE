package cz.csob.ency.common.internal.favicon;

import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Override default ency favicon with E3 custom favicon
 */
@Component(
        immediate = true,
        service = DynamicInclude.class
)
public class TopHeadDynamicInclude implements DynamicInclude {

    private static final String _FAVICON_PATH = "/images/favicon.ico";
    private static final String _WEB_CONTEXT_PATH = "/common";

    @Override
    public void include(
            HttpServletRequest request, HttpServletResponse response, String key)
            throws IOException {
        PrintWriter printWriter = response.getWriter();
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(
                WebKeys.THEME_DISPLAY);
        StringBundler url = new StringBundler(4);

        url.append(themeDisplay.getPortalURL());
        url.append("/o");
        url.append(_WEB_CONTEXT_PATH);
        url.append(_FAVICON_PATH);

        printWriter.println("<link href=\"" + url.toString() + "\" rel=\"icon\" />");
    }

    @Override
    public void register(DynamicIncludeRegistry dynamicIncludeRegistry) {
        dynamicIncludeRegistry.register("/html/common/themes/top_head.jsp#post");
    }

}