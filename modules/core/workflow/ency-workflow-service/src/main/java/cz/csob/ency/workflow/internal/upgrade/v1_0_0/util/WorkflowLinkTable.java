package cz.csob.ency.workflow.internal.upgrade.v1_0_0.util;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class WorkflowLinkTable {
    public static final Object[][] TABLE_COLUMNS = {
            {"uuid_", Types.VARCHAR}, {"workflowLinkId", Types.BIGINT},
            {"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
            {"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
            {"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
            {"className", Types.VARCHAR}, {"folderClassName", Types.VARCHAR},
            {"folderPK", Types.BIGINT}, {"workflowId", Types.BIGINT}
    };
    public static final Map<String, Integer> TABLE_COLUMNS_MAP =
            new HashMap<String, Integer>();
    public static final String TABLE_NAME = "ency_workflowlink";
    public static final String TABLE_SQL_CREATE =
            "create table ency_workflowlink (uuid_ VARCHAR(75) null,workflowLinkId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,className VARCHAR(1000) null,folderClassName VARCHAR(1000) null,folderPK LONG,workflowId LONG)";
    public static final String TABLE_SQL_DROP = "drop table ency_workflowlink";

    static {
        TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("workflowLinkId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
        TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
        TABLE_COLUMNS_MAP.put("className", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("folderClassName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("folderPK", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("workflowId", Types.BIGINT);
    }

}
