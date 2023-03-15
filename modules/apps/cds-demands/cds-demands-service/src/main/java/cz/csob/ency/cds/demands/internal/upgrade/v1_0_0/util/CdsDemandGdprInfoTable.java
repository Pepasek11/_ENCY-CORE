package cz.csob.ency.cds.demands.internal.upgrade.v1_0_0.util;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class CdsDemandGdprInfoTable {
    public static final Object[][] TABLE_COLUMNS = {
            {"uuid_", Types.VARCHAR}, {"gdprInfoId", Types.BIGINT},
            {"demandId", Types.BIGINT}, {"title", Types.VARCHAR},
            {"description", Types.VARCHAR}, {"isEmployee", Types.BOOLEAN},
            {"employeeCategory", Types.VARCHAR},
            {"employeeReasoning", Types.VARCHAR}, {"isClient", Types.BOOLEAN},
            {"clientCategory", Types.VARCHAR}, {"clientReasoning", Types.VARCHAR},
            {"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
            {"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP}
    };
    public static final Map<String, Integer> TABLE_COLUMNS_MAP =
            new HashMap<String, Integer>();
    public static final String TABLE_NAME = "CdsDemands_CdsDemandGdprInfo";
    public static final String TABLE_SQL_CREATE =
            "create table CdsDemands_CdsDemandGdprInfo (uuid_ VARCHAR(75) null,gdprInfoId LONG not null primary key,demandId LONG,title VARCHAR(500) null,description TEXT null,isEmployee BOOLEAN,employeeCategory VARCHAR(1024) null,employeeReasoning VARCHAR(1024) null,isClient BOOLEAN,clientCategory VARCHAR(1024) null,clientReasoning VARCHAR(1024) null,userId LONG,userName VARCHAR(256) null,createDate DATE null,modifiedDate DATE null)";
    public static final String TABLE_SQL_DROP =
            "drop table CdsDemands_CdsDemandGdprInfo";

    static {
        TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("gdprInfoId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("demandId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("isEmployee", Types.BOOLEAN);
        TABLE_COLUMNS_MAP.put("employeeCategory", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("employeeReasoning", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("isClient", Types.BOOLEAN);
        TABLE_COLUMNS_MAP.put("clientCategory", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("clientReasoning", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
        TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
    }


}
