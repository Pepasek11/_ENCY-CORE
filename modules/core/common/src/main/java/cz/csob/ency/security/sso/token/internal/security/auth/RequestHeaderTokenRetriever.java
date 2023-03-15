package cz.csob.ency.security.sso.token.internal.security.auth;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.sso.token.security.auth.TokenLocation;
import com.liferay.portal.security.sso.token.security.auth.TokenRetriever;
import org.osgi.service.component.annotations.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Michael C. Han
 */
@Component(
        property = {"token.location=" + TokenLocation.REQUEST_HEADER,
                "service.ranking:Integer=200"
        },
        service = TokenRetriever.class
)
public class RequestHeaderTokenRetriever implements TokenRetriever {
    private static final Log _log = LogFactoryUtil.getLog(RequestHeaderTokenRetriever.class);

    @Override
    public String getLoginToken(
            HttpServletRequest httpServletRequest, String userTokenName) {

        String login = httpServletRequest.getHeader(userTokenName);
        _log.debug("Getting login token from " + userTokenName + " got " + login);

        if (Validator.isBlank(login)) {
            if (_log.isDebugEnabled()) {
                _log.debug("No auto login found");
            }

            return null;
        }

        int pos = login.indexOf('\\');

        if (pos != -1 && pos < (login.length() - 1)) {
            login = login.substring(pos + 1);
        }

        if (Validator.isBlank(login)) {
            if (_log.isDebugEnabled()) {
                _log.debug("No valid auto login found");
            }

            return null;
        }

        _log.debug("Found auto login " + login);
        return login;
    }

}