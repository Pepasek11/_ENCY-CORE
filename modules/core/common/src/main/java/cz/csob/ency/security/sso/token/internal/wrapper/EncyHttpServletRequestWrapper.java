package cz.csob.ency.security.sso.token.internal.wrapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author Minhchau Dang
 */
public class EncyHttpServletRequestWrapper extends HttpServletRequestWrapper {
    private static final Log _log = LogFactoryUtil.getLog(EncyHttpServletRequestWrapper.class);

    public EncyHttpServletRequestWrapper(
            HttpServletRequest httpServletRequest, long companyId) {
        super(httpServletRequest);
        _companyId = companyId;
    }

    @Override
    public String getRemoteUser() {
        String remoteUser = super.getRemoteUser();

        if (Validator.isBlank(remoteUser)) {
            return remoteUser;
        }

        if (remoteUser.contains("\\")) {
            _log.debug("have remote user " + remoteUser);


            int pos = remoteUser.indexOf('\\');
            if (pos != -1 && pos < (remoteUser.length() - 1)) {
                remoteUser = remoteUser.substring(pos + 1);
            }

            User u = UserLocalServiceUtil.fetchUserByScreenName(_companyId, remoteUser);
            if (u != null) {
                _log.debug("found user id " + u.getUserId());
                return String.valueOf(u.getUserId());
            }
            return null;
        }

        return remoteUser;
    }

    private long _companyId;
}