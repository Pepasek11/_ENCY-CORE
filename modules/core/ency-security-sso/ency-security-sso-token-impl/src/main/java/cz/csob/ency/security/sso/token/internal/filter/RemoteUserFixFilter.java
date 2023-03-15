package cz.csob.ency.security.sso.token.internal.filter;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.BaseFilter;
import cz.csob.ency.security.sso.token.internal.wrapper.EncyHttpServletRequestWrapper;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component(
        immediate = true,
        property = {
                "servlet-context-name=",
                "servlet-filter-name=ency-remote-user-http-filter",
                "before-filter=URL Rewrite Filter",

                "url-pattern=/*"
        },
        service = Filter.class
)

public class RemoteUserFixFilter extends BaseFilter {

    private static final Log _log = LogFactoryUtil.getLog(RemoteUserFixFilter.class);

    @Override
    protected Log getLog() {
        return _log;
    }

    @Override
    protected void processFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws Exception {
        HttpServletRequest wrappedRequest = new EncyHttpServletRequestWrapper(request);
      //  _log.warn("Wrapping");
        super.processFilter(wrappedRequest, response, filterChain);
    }
}

