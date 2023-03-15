package cz.csob.ency.delegations.internal.upgrade;

import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import cz.csob.ency.delegations.internal.upgrade.v1_0_0.InitialUpgradeStep;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class DelegationsModuleUpgradeProcess implements UpgradeStepRegistrator {


    @Override
    public void register(Registry registry) {
        registry.register("0.0.0", "1.0.0", new InitialUpgradeStep());
    }
}

