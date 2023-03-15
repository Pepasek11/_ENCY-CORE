package cz.csob.ency.workflow.internal.upgrade.v1_0_0.util;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class WorkflowStateTable {
    public static final Object[][] TABLE_COLUMNS = {
            {"uuid_", Types.VARCHAR}, {"stateId", Types.BIGINT},
            {"workflowId", Types.BIGINT}, {"name", Types.VARCHAR},
            {"title", Types.VARCHAR}, {"description", Types.CLOB},
            {"version", Types.BIGINT}, {"isInitial", Types.BOOLEAN},
            {"isFinal", Types.BOOLEAN}, {"isEditable", Types.BOOLEAN},
            {"isSearchable", Types.BOOLEAN}, {"isPermanent", Types.BOOLEAN},
            {"cssIcon", Types.VARCHAR}, {"cssIconColor", Types.VARCHAR},
            {"cssLabelColor", Types.VARCHAR}, {"active_", Types.BOOLEAN},
            {"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP}
    };
    public static final Map<String, Integer> TABLE_COLUMNS_MAP =
            new HashMap<String, Integer>();
    public static final String TABLE_NAME = "ency_workflowstate";
    public static final String TABLE_SQL_CREATE =
            "create table ency_workflowstate (uuid_ VARCHAR(75) null,stateId LONG not null primary key,workflowId LONG,name VARCHAR(200) null,title VARCHAR(1000) null,description TEXT null,version LONG,isInitial BOOLEAN,isFinal BOOLEAN,isEditable BOOLEAN,isSearchable BOOLEAN,isPermanent BOOLEAN,cssIcon VARCHAR(100) null,cssIconColor VARCHAR(10) null,cssLabelColor VARCHAR(10) null,active_ BOOLEAN,createDate DATE null,modifiedDate DATE null)";
    public static final String TABLE_SQL_DROP = "drop table ency_workflowstate";

    static {
        TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("stateId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("workflowId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("description", Types.CLOB);
        TABLE_COLUMNS_MAP.put("version", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("isInitial", Types.BOOLEAN);
        TABLE_COLUMNS_MAP.put("isFinal", Types.BOOLEAN);
        TABLE_COLUMNS_MAP.put("isEditable", Types.BOOLEAN);
        TABLE_COLUMNS_MAP.put("isSearchable", Types.BOOLEAN);
        TABLE_COLUMNS_MAP.put("isPermanent", Types.BOOLEAN);
        TABLE_COLUMNS_MAP.put("cssIcon", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("cssIconColor", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("cssLabelColor", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
        TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
        TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
    }

}
