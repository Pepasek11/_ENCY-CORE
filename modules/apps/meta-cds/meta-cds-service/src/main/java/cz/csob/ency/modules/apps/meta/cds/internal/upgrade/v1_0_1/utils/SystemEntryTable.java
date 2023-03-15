package cz.csob.ency.modules.apps.meta.cds.internal.upgrade.v1_0_1.utils;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class SystemEntryTable {
    public static final String TABLE_NAME = "MetaCds_SystemEntry";

    public static final Object[][] TABLE_COLUMNS = {
            {"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
            {"systemEntryId", Types.BIGINT}, {"systemCode", Types.BIGINT},
            {"systemName", Types.VARCHAR}, {"systemTitle", Types.VARCHAR},
            {"systemType", Types.VARCHAR}, {"description", Types.CLOB},
            {"stewardName", Types.VARCHAR}, {"stewardId", Types.VARCHAR},
            {"stewardDepartment", Types.VARCHAR},
            {"businessOwnerName", Types.VARCHAR},
            {"businessOwnerId", Types.VARCHAR},
            {"contactPersonName", Types.VARCHAR},
            {"contactPersonId", Types.VARCHAR}, {"sandboxName", Types.VARCHAR},
            {"gestorDepartmentId", Types.VARCHAR},
            {"gestorDepartmentName", Types.VARCHAR}, {"role_", Types.VARCHAR},
            {"snowAssetTagId", Types.VARCHAR}, {"snowAssetTagName", Types.VARCHAR},
            {"isSlaSigned", Types.BOOLEAN}, {"isSelfBi", Types.BOOLEAN},
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
        TABLE_COLUMNS_MAP.put("systemEntryId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("systemCode", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("systemName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("systemTitle", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("systemType", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("description", Types.CLOB);
        TABLE_COLUMNS_MAP.put("stewardName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("stewardId", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("stewardDepartment", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("businessOwnerName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("businessOwnerId", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("contactPersonName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("contactPersonId", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("sandboxName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("gestorDepartmentId", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("gestorDepartmentName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("role_", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("snowAssetTagId", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("snowAssetTagName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("isSlaSigned", Types.BOOLEAN);
        TABLE_COLUMNS_MAP.put("isSelfBi", Types.BOOLEAN);
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
            "create table MetaCds_SystemEntry (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,systemEntryId LONG not null primary key,systemCode LONG,systemName VARCHAR(10) null,systemTitle VARCHAR(200) null,systemType VARCHAR(20) null,description TEXT null,stewardName VARCHAR(3000) null,stewardId VARCHAR(300) null,stewardDepartment VARCHAR(3000) null,businessOwnerName VARCHAR(3000) null,businessOwnerId VARCHAR(300) null,contactPersonName VARCHAR(3000) null,contactPersonId VARCHAR(300) null,sandboxName VARCHAR(256) null,gestorDepartmentId VARCHAR(300) null,gestorDepartmentName VARCHAR(512) null,role_ VARCHAR(256) null,snowAssetTagId VARCHAR(300) null,snowAssetTagName VARCHAR(3000) null,isSlaSigned BOOLEAN,isSelfBi BOOLEAN,isActive BOOLEAN,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,urlTitle VARCHAR(256) null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";

    public static final String TABLE_SQL_DROP =
            "drop table MetaCds_SystemEntry";

}
