package cz.csob.ency.security.sso.token.internal.settings.definition;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;
import cz.csob.ency.security.sso.token.configuration.TokenConfiguration;
import org.osgi.service.component.annotations.Component;

/**
 * @author Mika Koivisto
 */
@Component(service = ConfigurationBeanDeclaration.class)
public class TokenCompanyServiceConfigurationBeanDeclaration
        implements ConfigurationBeanDeclaration {

    @Override
    public Class<?> getConfigurationBeanClass() {
        return TokenConfiguration.class;
    }
}
