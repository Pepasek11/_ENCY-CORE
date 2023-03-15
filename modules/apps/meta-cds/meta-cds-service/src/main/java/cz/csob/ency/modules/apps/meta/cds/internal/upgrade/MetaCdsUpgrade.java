package cz.csob.ency.modules.apps.meta.cds.internal.upgrade;

import com.liferay.portal.kernel.upgrade.DummyUpgradeProcess;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import cz.csob.ency.modules.apps.meta.cds.internal.upgrade.v1_0_1.PrepareTablesUpgradeProcess;
import org.osgi.service.component.annotations.Component;

/**
 * @author Miroslav Čermák
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class MetaCdsUpgrade implements UpgradeStepRegistrator {
    @Override
    public void register(Registry registry) {
        registry.register("0.0.0", "1.0.0", new DummyUpgradeProcess());
        registry.register("1.0.0", "1.0.1", new PrepareTablesUpgradeProcess());
    }
}
