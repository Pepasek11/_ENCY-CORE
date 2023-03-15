package cz.csob.ency.modules.apps.meta.cds.internal.upgrade.v1_0_1.utils;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class ColumnEntryTable {
    public static final String TABLE_NAME = "MetaCds_ColumnEntry";

    public static final Object[][] TABLE_COLUMNS = {
            {"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
            {"columnEntryId", Types.BIGINT}, {"columnType", Types.VARCHAR},
            {"columnName", Types.VARCHAR}, {"columnPosition", Types.BIGINT},
            {"columnFullName", Types.VARCHAR}, {"tableEntryId", Types.BIGINT},
            {"tableName", Types.VARCHAR}, {"systemName", Types.VARCHAR},
            {"databaseName", Types.VARCHAR}, {"description", Types.CLOB},
            {"dataType", Types.VARCHAR}, {"dataSize", Types.BIGINT},
            {"isPrimaryKey", Types.BOOLEAN}, {"isNotNull", Types.BOOLEAN},
            {"isActive", Types.BOOLEAN}, {"groupId", Types.BIGINT},
            {"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
            {"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
            {"modifiedDate", Types.TIMESTAMP}, {"urlTitle", Types.VARCHAR},
            {"status", Types.INTEGER}, {"statusByUserId", Types.BIGINT},
            {"statusByUserName", Types.VARCHAR}, {"statusDate", Types.TIMESTAMP}
    };

    public static final Map<String, Integer> TABLE_COLUMNS_MAP =
            new HashMap<String, Integer>();

    static {
        TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("columnEntryId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("columnType", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("columnName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("columnPosition", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("columnFullName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("tableEntryId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("tableName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("systemName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("databaseName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("description", Types.CLOB);
        TABLE_COLUMNS_MAP.put("dataType", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("dataSize", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("isPrimaryKey", Types.BOOLEAN);
        TABLE_COLUMNS_MAP.put("isNotNull", Types.BOOLEAN);
        TABLE_COLUMNS_MAP.put("isActive", Types.BOOLEAN);
        TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
        TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
        TABLE_COLUMNS_MAP.put("urlTitle", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
        TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
    }

    public static final String TABLE_SQL_CREATE =
            "create table MetaCds_ColumnEntry (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,columnEntryId LONG not null primary key,columnType VARCHAR(10) null,columnName VARCHAR(512) null,columnPosition LONG,columnFullName VARCHAR(512) null,tableEntryId LONG,tableName VARCHAR(512) null,systemName VARCHAR(10) null,databaseName VARCHAR(128) null,description TEXT null,dataType VARCHAR(32) null,dataSize LONG,isPrimaryKey BOOLEAN,isNotNull BOOLEAN,isActive BOOLEAN,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,urlTitle VARCHAR(256) null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";

    public static final String TABLE_SQL_DROP =
            "drop table MetaCds_ColumnEntry";

}
