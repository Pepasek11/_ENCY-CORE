package cz.csob.ency.delegations.internal.upgrade.v1_0_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import cz.csob.ency.delegations.internal.upgrade.v1_0_0.util.DelegatedRoleTable;
import cz.csob.ency.delegations.internal.upgrade.v1_0_0.util.DelegationTable;

public class InitialUpgradeStep extends UpgradeProcess {
    @Override
    protected void doUpgrade() throws Exception {
        if (!hasTable(DelegatedRoleTable.TABLE_NAME)) {
            runSQL(DelegatedRoleTable.TABLE_SQL_CREATE);
        }

        if (!hasTable(DelegationTable.TABLE_NAME)) {
            runSQL(DelegationTable.TABLE_SQL_CREATE);
        }
    }
}