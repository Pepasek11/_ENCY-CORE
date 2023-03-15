package cz.csob.ency.security.sso.token.internal.wrapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author Minhchau Dang
 */
public class EncyHttpServletRequestWrapper extends HttpServletRequestWrapper {
    private static final Log _log = LogFactoryUtil.getLog(EncyHttpServletRequestWrapper.class);

    public EncyHttpServletRequestWrapper(
            HttpServletRequest httpServletRequest) {

        super(httpServletRequest);
    }

    @Override
    public String getRemoteUser() {
        final String remoteUser = super.getRemoteUser();

        if (Validator.isBlank(remoteUser)) {
            return remoteUser;
        }

        if (remoteUser.contains("\\")) {
            // do not return remote user if remote user is from iis and contains domain
            // so custom Auto Logon is performed
            return null;
        }

        return remoteUser;
    }
}