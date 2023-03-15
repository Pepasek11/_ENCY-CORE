package cz.csob.ency.modules.apps.meta.cds.internal.upgrade.v1_0_1;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import cz.csob.ency.modules.apps.meta.cds.internal.upgrade.v1_0_1.utils.ColumnEntryTable;
import cz.csob.ency.modules.apps.meta.cds.internal.upgrade.v1_0_1.utils.SystemEntryTable;
import cz.csob.ency.modules.apps.meta.cds.internal.upgrade.v1_0_1.utils.TableEntryTable;

public class PrepareTablesUpgradeProcess extends UpgradeProcess {
    @Override
    protected void doUpgrade() throws Exception {
        if (!hasTable(SystemEntryTable.TABLE_NAME)) {
            runSQL(SystemEntryTable.TABLE_SQL_CREATE);
        }

        if (!hasTable(TableEntryTable.TABLE_NAME)) {
            runSQL(TableEntryTable.TABLE_SQL_CREATE);
        }

        if (!hasTable(ColumnEntryTable.TABLE_NAME)) {
            runSQL(ColumnEntryTable.TABLE_SQL_CREATE);
        }
    }
}
