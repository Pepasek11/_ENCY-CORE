package cz.csob.ency.connection.internal.upgrade;


import com.liferay.portal.kernel.upgrade.BaseSQLServerDatetimeUpgradeProcess;
import com.liferay.portal.kernel.upgrade.DummyUpgradeStep;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import cz.csob.ency.connection.internal.upgrade.v1_0_1.ConnectionDefinitionUpgradeProcess;
import cz.csob.ency.connection.internal.upgrade.v1_0_1.utils.ConnectionDefinitionTable;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class ConnectionModuleUpgrade implements UpgradeStepRegistrator {
    @Override
    public void register(UpgradeStepRegistrator.Registry registry) {
        registry.register("0.0.1", "1.0.0", new DummyUpgradeStep());
        registry.register("1.0.0", "1.0.1", new ConnectionDefinitionUpgradeProcess());
    }
}
