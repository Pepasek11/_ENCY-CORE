package cz.csob.ency.connection.internal.upgrade.v1_0_1;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.upgrade.util.UpgradeTable;
import com.liferay.portal.kernel.upgrade.util.UpgradeTableFactoryUtil;
import cz.csob.ency.connection.internal.upgrade.v1_0_1.utils.ConnectionDefinitionTable;

public class ConnectionDefinitionUpgradeProcess extends UpgradeProcess {
    @Override
    protected void doUpgrade() throws Exception {
        if (!hasTable(ConnectionDefinitionTable.TABLE_NAME)) {
            UpgradeTable upgradeTable = UpgradeTableFactoryUtil.getUpgradeTable(
                    ConnectionDefinitionTable.TABLE_NAME,
                    ConnectionDefinitionTable.TABLE_COLUMNS
            );

            upgradeTable.setCreateSQL(ConnectionDefinitionTable.TABLE_SQL_CREATE);
            upgradeTable.updateTable();
        }
    }

    private static final Log _log = LogFactoryUtil.getLog(
            ConnectionDefinitionUpgradeProcess.class);
}
