package cz.csob.ency.security.sso.token.internal.auto.login;

import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.security.auto.login.AutoLogin;
import com.liferay.portal.kernel.security.auto.login.BaseAutoLogin;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.settings.CompanyServiceSettingsLocator;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.exportimport.UserImporter;
import com.liferay.portal.util.PropsValues;
import cz.csob.ency.security.sso.token.configuration.TokenConfiguration;
import cz.csob.ency.security.sso.token.constants.TokenConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Participates in every unauthenticated HTTP request to Liferay Portal.
 *
 * <p>
 * If this class finds an authentication token in the HTTP request and
 * successfully identifies a Liferay Portal user using it, then this user is
 * logged in without any further challenge.
 * </p>
 *
 * @author Michael C. Han
 */
@Component(
        configurationPid = "cz.csob.ency.security.sso.token.configuration.TokenConfiguration",
        configurationPolicy = ConfigurationPolicy.OPTIONAL,
        service = AutoLogin.class
)
public class TokenAutoLogin extends BaseAutoLogin {

    private static final Log _log = LogFactoryUtil.getLog(TokenAutoLogin.class);

    @Override
    protected String[] doLogin(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse)
            throws Exception {

        long companyId = _portal.getCompanyId(httpServletRequest);

        TokenConfiguration tokenCompanyServiceSettings =
                _configurationProvider.getConfiguration(
                        TokenConfiguration.class,
                        new CompanyServiceSettingsLocator(
                                companyId, TokenConstants.SERVICE_NAME));

        if (!tokenCompanyServiceSettings.enabled()) {
            return null;
        }

        String userTokenName = tokenCompanyServiceSettings.userTokenName();

        String login = httpServletRequest.getHeader(userTokenName);

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

        User user = null;
        try {
            user = _getUser(companyId, login, tokenCompanyServiceSettings);
        } catch (NoSuchUserException nsue) {
            if (_log.isWarnEnabled()) {
                _log.warn("Auto Login " + login + " found but user is not loaded.");
            }

            String anonymousLogin = tokenCompanyServiceSettings.anonymousLogin();

            if(tokenCompanyServiceSettings.allowAnonymous()
                && !Validator.isBlank(anonymousLogin)) {
                try {
                    user = _getUser(companyId, login, tokenCompanyServiceSettings);
                } catch (NoSuchUserException nsue2) {
                    if (_log.isWarnEnabled()) {
                        _log.warn("Anonymous Login is enabled, but anonymous user is missing or misconfigured.");
                    }
                    return null;
                }
            }
        }

        addRedirect(httpServletRequest);

        String[] credentials = new String[3];

        credentials[0] = String.valueOf(user.getUserId());
        credentials[1] = user.getPassword();
        credentials[2] = Boolean.TRUE.toString();

        return credentials;
    }

    @Reference(unbind = "-")
    protected void setConfigurationProvider(
            ConfigurationProvider configurationProvider) {

        _configurationProvider = configurationProvider;
    }

    @Reference(unbind = "-")
    protected void setUserImporter(UserImporter userImporter) {
        _userImporter = userImporter;
    }

    @Reference(unbind = "-")
    protected void setUserLocalService(UserLocalService userLocalService) {
        _userLocalService = userLocalService;
    }

    private User _getUser(
            long companyId, String login,
            TokenConfiguration tokenCompanyServiceSettings)
            throws Exception {

        User user = null;

        String authType = PrefsPropsUtil.getString(
                companyId, PropsKeys.COMPANY_SECURITY_AUTH_TYPE,
                PropsValues.COMPANY_SECURITY_AUTH_TYPE);

        user = _userLocalService.getUserByScreenName(companyId, login);

        return user;
    }

    private ConfigurationProvider _configurationProvider;

    @Reference
    private Portal _portal;

    private UserImporter _userImporter;
    private UserLocalService _userLocalService;

}