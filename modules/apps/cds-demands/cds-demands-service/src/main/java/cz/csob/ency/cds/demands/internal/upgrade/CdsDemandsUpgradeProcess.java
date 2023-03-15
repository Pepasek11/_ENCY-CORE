package cz.csob.ency.cds.demands.internal.upgrade;

import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import cz.csob.ency.cds.demands.internal.upgrade.v1_0_0.InitialUpgradeStep;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class CdsDemandsUpgradeProcess implements UpgradeStepRegistrator {

    @Override
    public void register(UpgradeStepRegistrator.Registry registry) {
        registry.register("0.0.0", "1.0.0", new InitialUpgradeStep());
    }
}
