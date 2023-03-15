package cz.csob.ency.delegations.internal.upgrade.v1_0_0.util;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class DelegatedRoleTable {
    public static final String TABLE_NAME = "delegations_delegatedrole";

    public static final Object[][] TABLE_COLUMNS = {
            {"mvccVersion", Types.BIGINT}, {"roleId", Types.BIGINT},
            {"title", Types.VARCHAR}, {"code_", Types.VARCHAR},
            {"description", Types.VARCHAR}, {"groupId", Types.BIGINT},
            {"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
            {"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
            {"modifiedDate", Types.TIMESTAMP}
    };

    public static final Map<String, Integer> TABLE_COLUMNS_MAP =
            new HashMap<String, Integer>();

    static {
        TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("roleId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("code_", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
        TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
    }

    public static final String TABLE_SQL_CREATE =
            "create table delegations_delegatedrole (mvccVersion LONG default 0 not null,roleId LONG not null primary key,title VARCHAR(256) null,code_ VARCHAR(256) null,description VARCHAR(1024) null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(256) null,createDate DATE null,modifiedDate DATE null)";

    public static final String TABLE_SQL_DROP =
            "drop table delegations_delegatedrole";


}
