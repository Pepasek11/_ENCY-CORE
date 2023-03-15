package cz.csob.ency.connection.internal.upgrade.v1_0_1.utils;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class ConnectionDefinitionTable {
    public static final String TABLE_NAME = "ency_connection";

    public static final Object[][] TABLE_COLUMNS = {
            {"connectionId", Types.BIGINT}, {"name", Types.VARCHAR},
            {"driver", Types.VARCHAR}, {"url", Types.VARCHAR},
            {"serverAddress", Types.VARCHAR}, {"serverPort", Types.VARCHAR},
            {"databaseName", Types.VARCHAR}, {"integratedSecurity", Types.BOOLEAN},
            {"username", Types.VARCHAR}, {"password_", Types.VARCHAR},
            {"additionalParams", Types.VARCHAR}
    };

    public static final Map<String, Integer> TABLE_COLUMNS_MAP =
            new HashMap<String, Integer>();

    static {
        TABLE_COLUMNS_MAP.put("connectionId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("driver", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("url", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("serverAddress", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("serverPort", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("databaseName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("integratedSecurity", Types.BOOLEAN);
        TABLE_COLUMNS_MAP.put("username", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("password_", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("additionalParams", Types.VARCHAR);
    }

    public static final String TABLE_SQL_CREATE =
            "create table ency_connection (connectionId LONG not null primary key,name VARCHAR(30) null,driver VARCHAR(20) null,url VARCHAR(1024) null,serverAddress VARCHAR(1024) null,serverPort VARCHAR(7) null,databaseName VARCHAR(100) null,integratedSecurity BOOLEAN,username VARCHAR(100) null,password_ VARCHAR(100) null,additionalParams VARCHAR(75) null)";

    public static final String TABLE_SQL_DROP = "drop table ency_connection";

    public static final String[] TABLE_SQL_ADD_INDEXES = {
            "create index IX_D103D943 on ency_connection (name[$COLUMN_LENGTH:30$])"
    };

}
