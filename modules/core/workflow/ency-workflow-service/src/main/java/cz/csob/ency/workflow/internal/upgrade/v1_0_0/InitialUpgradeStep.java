package cz.csob.ency.workflow.internal.upgrade.v1_0_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import cz.csob.ency.workflow.internal.upgrade.v1_0_0.util.*;

public class InitialUpgradeStep extends UpgradeProcess {
    @Override
    protected void doUpgrade() throws Exception {
        if (!hasTable(WorkflowTable.TABLE_NAME)) {
            runSQL(WorkflowTable.TABLE_SQL_CREATE);
        }

        if (!hasTable(WorkflowInstanceTable.TABLE_NAME)) {
            runSQL(WorkflowInstanceTable.TABLE_SQL_CREATE);
        }

        if (!hasTable(WorkflowLinkTable.TABLE_NAME)) {
            runSQL(WorkflowLinkTable.TABLE_SQL_CREATE);
        }

        if (!hasTable(WorkflowStateTable.TABLE_NAME)) {
            runSQL(WorkflowStateTable.TABLE_SQL_CREATE);
        }

        if (!hasTable(WorkflowStateInstanceTable.TABLE_NAME)) {
            runSQL(WorkflowStateInstanceTable.TABLE_SQL_CREATE);
        }

        if (!hasTable(WorkflowTransitionTable.TABLE_NAME)) {
            runSQL(WorkflowTransitionTable.TABLE_SQL_CREATE);
        }

        if (!hasTable(WorkflowTransitionInstanceTable.TABLE_NAME)) {
            runSQL(WorkflowTransitionInstanceTable.TABLE_SQL_CREATE);
        }
    }
}