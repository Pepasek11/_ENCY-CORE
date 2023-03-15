package cz.csob.ency.workflow.internal.upgrade.v1_0_0.util;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class WorkflowInstanceTable {

    public static final Object[][] TABLE_COLUMNS = {
            {"uuid_", Types.VARCHAR}, {"workflowInstanceId", Types.BIGINT},
            {"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
            {"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
            {"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
            {"workflowId", Types.BIGINT}, {"workflowVersion", Types.BIGINT},
            {"className", Types.VARCHAR}, {"classPK", Types.BIGINT},
            {"workflowContext", Types.CLOB}
    };
    public static final Map<String, Integer> TABLE_COLUMNS_MAP =
            new HashMap<String, Integer>();
    public static final String TABLE_NAME = "ency_workflowinstance";
    public static final String TABLE_SQL_CREATE =
            "create table ency_workflowinstance (uuid_ VARCHAR(75) null,workflowInstanceId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,workflowId LONG,workflowVersion LONG,className VARCHAR(1000) null,classPK LONG,workflowContext TEXT null)";
    public static final String TABLE_SQL_DROP =
            "drop table ency_workflowinstance";

    static {
        TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("workflowInstanceId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
        TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
        TABLE_COLUMNS_MAP.put("workflowId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("workflowVersion", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("className", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("classPK", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("workflowContext", Types.CLOB);
    }

}
