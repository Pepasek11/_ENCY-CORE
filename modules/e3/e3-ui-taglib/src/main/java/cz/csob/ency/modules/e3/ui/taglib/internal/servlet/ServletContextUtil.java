package cz.csob.ency.modules.e3.ui.taglib.internal.servlet;

import com.liferay.frontend.taglib.servlet.taglib.ScreenNavigationRegistry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.ServletContext;


@Component(immediate = true, service = {})
public class ServletContextUtil {
    public static final ScreenNavigationRegistry getScreenNavigationRegistry() {
        return _screenNavigationRegistry;
    }

    public static final ServletContext getServletContext() {
        return _servletContext;
    }

    @Reference(unbind = "-")
    protected void setScreenNavigationRegistry(
            ScreenNavigationRegistry screenNavigationRegistry) {

        _screenNavigationRegistry = screenNavigationRegistry;
    }

    @Reference(
            target = "(osgi.web.symbolicname=cz.csob.ency.modules.e3.ui.taglib)",
            unbind = "-"
    )
    protected void setServletContext(ServletContext servletContext) {
        _servletContext = servletContext;
    }

    private static ScreenNavigationRegistry _screenNavigationRegistry;
    private static ServletContext _servletContext;
}
