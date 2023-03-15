package cz.csob.ency.cds.demands.internal.upgrade.v1_0_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import cz.csob.ency.cds.demands.internal.upgrade.v1_0_0.util.*;

public class InitialUpgradeStep extends UpgradeProcess {
    @Override
    protected void doUpgrade() throws Exception {
        if (!hasTable(CdsDemandTable.TABLE_NAME)) {
            runSQL(CdsDemandTable.TABLE_SQL_CREATE);
        }

        if (!hasTable(CdsDemandVersionTable.TABLE_NAME)) {
            runSQL(CdsDemandVersionTable.TABLE_SQL_CREATE);
        }

        if (!hasTable(CdsDemandGdprInfoTable.TABLE_NAME)) {
            runSQL(CdsDemandGdprInfoTable.TABLE_SQL_CREATE);
        }
    }
}
