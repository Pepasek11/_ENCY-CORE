package cz.csob.ency.security.sso.token.internal.configuration.definition;

import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;
import cz.csob.ency.security.sso.token.configuration.TokenConfiguration;
import cz.csob.ency.security.sso.token.constants.TokenConstants;
import org.osgi.service.component.annotations.Component;

/**
 * @author Mika Koivisto
 */
@Component(service = ConfigurationPidMapping.class)
public class TokenCompanyServiceConfigurationPidMapping
        implements ConfigurationPidMapping{
    @Override
    public Class<?> getConfigurationBeanClass() {
        return TokenConfiguration.class;
    }

    @Override
    public String getConfigurationPid() {
        return TokenConstants.SERVICE_NAME;
    }
}
