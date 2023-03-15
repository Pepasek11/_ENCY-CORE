package cz.csob.ency.workflow.internal.upgrade.v1_0_0.util;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class WorkflowTransitionInstanceTable {
    public static final Object[][] TABLE_COLUMNS = {
            {"uuid_", Types.VARCHAR}, {"transitionInstanceId", Types.BIGINT},
            {"transitionId", Types.BIGINT}, {"stateId", Types.BIGINT},
            {"stateInstanceId", Types.BIGINT}, {"workflowId", Types.BIGINT},
            {"workflowInstanceId", Types.BIGINT}, {"version", Types.BIGINT},
            {"comment_", Types.VARCHAR}, {"targetStateId", Types.BIGINT},
            {"targetStateInstanceId", Types.BIGINT}, {"groupId", Types.BIGINT},
            {"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
            {"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
            {"workflowContext", Types.CLOB}
    };
    public static final Map<String, Integer> TABLE_COLUMNS_MAP =
            new HashMap<String, Integer>();
    public static final String TABLE_NAME = "ency_workflowtransitioninstance";
    public static final String TABLE_SQL_CREATE =
            "create table ency_workflowtransitioninstance (uuid_ VARCHAR(75) null,transitionInstanceId LONG not null primary key,transitionId LONG,stateId LONG,stateInstanceId LONG,workflowId LONG,workflowInstanceId LONG,version LONG,comment_ VARCHAR(2000) null,targetStateId LONG,targetStateInstanceId LONG,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,workflowContext TEXT null)";
    public static final String TABLE_SQL_DROP =
            "drop table ency_workflowtransitioninstance";

    static {
        TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("transitionInstanceId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("transitionId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("stateId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("stateInstanceId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("workflowId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("workflowInstanceId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("version", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("comment_", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("targetStateId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("targetStateInstanceId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
        TABLE_COLUMNS_MAP.put("workflowContext", Types.CLOB);
    }

}
