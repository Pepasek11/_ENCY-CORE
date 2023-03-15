package cz.csob.ency.delegations.internal.upgrade.v1_0_0.util;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class DelegationTable {
    public static final String TABLE_NAME = "delegations_delegation";

    public static final Object[][] TABLE_COLUMNS = {
            {"mvccVersion", Types.BIGINT}, {"delegationId", Types.BIGINT},
            {"roleId", Types.BIGINT}, {"delegatingUserId", Types.BIGINT},
            {"delegatedUserId", Types.BIGINT}, {"groupId", Types.BIGINT},
            {"note", Types.VARCHAR}, {"companyId", Types.BIGINT},
            {"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
            {"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP}
    };

    public static final Map<String, Integer> TABLE_COLUMNS_MAP =
            new HashMap<String, Integer>();

    static {
        TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("delegationId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("roleId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("delegatingUserId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("delegatedUserId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("note", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
        TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
    }

    public static final String TABLE_SQL_CREATE =
            "create table delegations_delegation (mvccVersion LONG default 0 not null,delegationId LONG not null primary key,roleId LONG,delegatingUserId LONG,delegatedUserId LONG,groupId LONG,note VARCHAR(1024) null,companyId LONG,userId LONG,userName VARCHAR(256) null,createDate DATE null,modifiedDate DATE null)";

    public static final String TABLE_SQL_DROP =
            "drop table delegations_delegation";
}
