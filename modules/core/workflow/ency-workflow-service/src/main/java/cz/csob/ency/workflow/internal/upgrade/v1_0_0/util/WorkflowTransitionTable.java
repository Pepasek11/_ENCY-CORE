package cz.csob.ency.workflow.internal.upgrade.v1_0_0.util;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class WorkflowTransitionTable {
    public static final Object[][] TABLE_COLUMNS = {
            {"uuid_", Types.VARCHAR}, {"transitionId", Types.BIGINT},
            {"stateId", Types.BIGINT}, {"workflowId", Types.BIGINT},
            {"version", Types.BIGINT}, {"name", Types.VARCHAR},
            {"title", Types.VARCHAR}, {"description", Types.CLOB},
            {"targetStateName", Types.VARCHAR}, {"targetStateId", Types.BIGINT},
            {"cssIcon", Types.VARCHAR}, {"cssIconColor", Types.VARCHAR},
            {"active_", Types.BOOLEAN}, {"createDate", Types.TIMESTAMP},
            {"modifiedDate", Types.TIMESTAMP}, {"order_", Types.BIGINT}
    };
    public static final Map<String, Integer> TABLE_COLUMNS_MAP =
            new HashMap<String, Integer>();
    public static final String TABLE_NAME = "ency_workflowtransition";
    public static final String TABLE_SQL_CREATE =
            "create table ency_workflowtransition (uuid_ VARCHAR(75) null,transitionId LONG not null primary key,stateId LONG,workflowId LONG,version LONG,name VARCHAR(200) null,title VARCHAR(1000) null,description TEXT null,targetStateName VARCHAR(200) null,targetStateId LONG,cssIcon VARCHAR(100) null,cssIconColor VARCHAR(10) null,active_ BOOLEAN,createDate DATE null,modifiedDate DATE null,order_ LONG)";
    public static final String TABLE_SQL_DROP =
            "drop table ency_workflowtransition";

    static {
        TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("transitionId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("stateId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("workflowId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("version", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("description", Types.CLOB);
        TABLE_COLUMNS_MAP.put("targetStateName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("targetStateId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("cssIcon", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("cssIconColor", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
        TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
        TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
        TABLE_COLUMNS_MAP.put("order_", Types.BIGINT);
    }

}
