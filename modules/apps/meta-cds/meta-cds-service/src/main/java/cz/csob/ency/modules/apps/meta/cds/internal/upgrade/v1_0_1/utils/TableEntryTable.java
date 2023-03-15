package cz.csob.ency.modules.apps.meta.cds.internal.upgrade.v1_0_1.utils;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class TableEntryTable {
    public static final String TABLE_NAME = "MetaCds_TableEntry";

    public static final Object[][] TABLE_COLUMNS = {
            {"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
            {"tableEntryId", Types.BIGINT}, {"tableName", Types.VARCHAR},
            {"tableFullName", Types.VARCHAR}, {"tableType", Types.VARCHAR},
            {"tableDatabase", Types.VARCHAR}, {"systemEntryId", Types.BIGINT},
            {"systemName", Types.VARCHAR}, {"description", Types.CLOB},
            {"dsaUrl", Types.VARCHAR}, {"contactPersonName", Types.VARCHAR},
            {"contactPersonId", Types.VARCHAR},
            {"specificationOwnerName", Types.VARCHAR},
            {"specificationOwnerId", Types.VARCHAR},
            {"unstructuredClause", Types.CLOB}, {"isActive", Types.BOOLEAN},
            {"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
            {"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
            {"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
            {"urlTitle", Types.VARCHAR}, {"status", Types.INTEGER},
            {"statusByUserId", Types.BIGINT}, {"statusByUserName", Types.VARCHAR},
            {"statusDate", Types.TIMESTAMP}
    };

    public static final Map<String, Integer> TABLE_COLUMNS_MAP =
            new HashMap<String, Integer>();

    static {
        TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("tableEntryId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("tableName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("tableFullName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("tableType", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("tableDatabase", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("systemEntryId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("systemName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("description", Types.CLOB);
        TABLE_COLUMNS_MAP.put("dsaUrl", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("contactPersonName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("contactPersonId", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("specificationOwnerName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("specificationOwnerId", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("unstructuredClause", Types.CLOB);
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
            "create table MetaCds_TableEntry (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,tableEntryId LONG not null primary key,tableName VARCHAR(512) null,tableFullName VARCHAR(512) null,tableType VARCHAR(10) null,tableDatabase VARCHAR(128) null,systemEntryId LONG,systemName VARCHAR(10) null,description TEXT null,dsaUrl STRING null,contactPersonName VARCHAR(3000) null,contactPersonId VARCHAR(300) null,specificationOwnerName VARCHAR(3000) null,specificationOwnerId VARCHAR(300) null,unstructuredClause TEXT null,isActive BOOLEAN,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,urlTitle VARCHAR(256) null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";

    public static final String TABLE_SQL_DROP = "drop table MetaCds_TableEntry";

}
