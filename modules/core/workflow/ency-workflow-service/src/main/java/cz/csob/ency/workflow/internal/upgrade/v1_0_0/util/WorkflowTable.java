package cz.csob.ency.workflow.internal.upgrade.v1_0_0.util;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class WorkflowTable {
    public static final Object[][] TABLE_COLUMNS = {
            {"uuid_", Types.VARCHAR}, {"workflowId", Types.BIGINT},
            {"className", Types.VARCHAR}, {"title", Types.VARCHAR},
            {"description", Types.CLOB}, {"initialStateName", Types.VARCHAR},
            {"version", Types.BIGINT}, {"active_", Types.BOOLEAN},
            {"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP}
    };
    public static final Map<String, Integer> TABLE_COLUMNS_MAP =
            new HashMap<String, Integer>();
    public static final String TABLE_NAME = "ency_workflow";
    public static final String TABLE_SQL_CREATE =
            "create table ency_workflow (uuid_ VARCHAR(75) null,workflowId LONG not null primary key,className VARCHAR(1000) null,title VARCHAR(1000) null,description TEXT null,initialStateName VARCHAR(75) null,version LONG,active_ BOOLEAN,createDate DATE null,modifiedDate DATE null)";
    public static final String TABLE_SQL_DROP = "drop table ency_workflow";

    static {
        TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("workflowId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("className", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("description", Types.CLOB);
        TABLE_COLUMNS_MAP.put("initialStateName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("version", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
        TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
        TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
    }

}
