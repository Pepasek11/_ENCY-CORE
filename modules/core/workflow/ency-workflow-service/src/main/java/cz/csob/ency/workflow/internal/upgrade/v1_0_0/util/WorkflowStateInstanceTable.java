package cz.csob.ency.workflow.internal.upgrade.v1_0_0.util;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class WorkflowStateInstanceTable {
    public static final Object[][] TABLE_COLUMNS = {
            {"uuid_", Types.VARCHAR}, {"stateInstanceId", Types.BIGINT},
            {"stateId", Types.BIGINT}, {"workflowId", Types.BIGINT},
            {"workflowInstanceId", Types.BIGINT}, {"version", Types.BIGINT},
            {"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
            {"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
            {"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
            {"completedDate", Types.TIMESTAMP}, {"workflowContext", Types.CLOB}
    };
    public static final Map<String, Integer> TABLE_COLUMNS_MAP =
            new HashMap<String, Integer>();
    public static final String TABLE_NAME = "ency_workflowstateinstance";
    public static final String TABLE_SQL_CREATE =
            "create table ency_workflowstateinstance (uuid_ VARCHAR(75) null,stateInstanceId LONG not null primary key,stateId LONG,workflowId LONG,workflowInstanceId LONG,version LONG,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,completedDate DATE null,workflowContext TEXT null)";
    public static final String TABLE_SQL_DROP =
            "drop table ency_workflowstateinstance";

    static {
        TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("stateInstanceId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("stateId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("workflowId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("workflowInstanceId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("version", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
        TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
        TABLE_COLUMNS_MAP.put("completedDate", Types.TIMESTAMP);
        TABLE_COLUMNS_MAP.put("workflowContext", Types.CLOB);
    }

}
