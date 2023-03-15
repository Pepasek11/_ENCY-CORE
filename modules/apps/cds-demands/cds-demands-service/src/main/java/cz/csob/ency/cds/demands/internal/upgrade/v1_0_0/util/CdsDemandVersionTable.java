package cz.csob.ency.cds.demands.internal.upgrade.v1_0_0.util;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class CdsDemandVersionTable {
    public static final Object[][] TABLE_COLUMNS = {
            {"cdsDemandVersionId", Types.BIGINT}, {"version", Types.INTEGER},
            {"uuid_", Types.VARCHAR}, {"demandId", Types.BIGINT},
            {"title", Types.VARCHAR}, {"description", Types.VARCHAR},
            {"type_", Types.INTEGER}, {"priority", Types.INTEGER},
            {"requestedDelivery", Types.TIMESTAMP}, {"isGDPR", Types.BOOLEAN},
            {"gdprInfo", Types.VARCHAR}, {"fiveTracks", Types.VARCHAR},
            {"requestorId", Types.BIGINT}, {"requestorName", Types.VARCHAR},
            {"requestedForId", Types.BIGINT}, {"requestedForName", Types.VARCHAR},
            {"contactId", Types.BIGINT}, {"contactName", Types.VARCHAR},
            {"domainId", Types.BIGINT}, {"domainName", Types.VARCHAR},
            {"banId", Types.BIGINT}, {"banName", Types.VARCHAR},
            {"spocId", Types.BIGINT}, {"spocName", Types.VARCHAR},
            {"usReasoning", Types.VARCHAR}, {"usFrequencyOut", Types.INTEGER},
            {"usAccessDPM", Types.BOOLEAN}, {"usFolderDPM", Types.VARCHAR},
            {"usCreateFolderDPM", Types.BOOLEAN},
            {"usGestorFolderDPMId", Types.BIGINT},
            {"usGestorFolderDPMName", Types.VARCHAR},
            {"usDPMNotificationMail", Types.VARCHAR}, {"bioeId", Types.VARCHAR},
            {"bioeStateId", Types.INTEGER}, {"bioeStateName", Types.VARCHAR},
            {"workEstimate", Types.DOUBLE}, {"acceptedWorkEstimate", Types.DOUBLE},
            {"expectedDelivery", Types.TIMESTAMP},
            {"acceptedDelivery", Types.TIMESTAMP}, {"groupId", Types.BIGINT},
            {"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
            {"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
            {"modifiedDate", Types.TIMESTAMP}, {"urlTitle", Types.VARCHAR},
            {"state_", Types.VARCHAR}, {"stateByUserId", Types.BIGINT},
            {"stateByUserName", Types.VARCHAR}, {"stateDate", Types.TIMESTAMP}
    };
    public static final Map<String, Integer> TABLE_COLUMNS_MAP =
            new HashMap<String, Integer>();
    public static final String TABLE_NAME = "CdsDemands_CdsDemandVersion";
    public static final String TABLE_SQL_CREATE =
            "create table CdsDemands_CdsDemandVersion (cdsDemandVersionId LONG not null primary key,version INTEGER,uuid_ VARCHAR(75) null,demandId LONG,title VARCHAR(500) null,description TEXT null,type_ INTEGER,priority INTEGER,requestedDelivery DATE null,isGDPR BOOLEAN,gdprInfo VARCHAR(512) null,fiveTracks VARCHAR(512) null,requestorId LONG,requestorName VARCHAR(256) null,requestedForId LONG,requestedForName VARCHAR(256) null,contactId LONG,contactName VARCHAR(256) null,domainId LONG,domainName VARCHAR(256) null,banId LONG,banName VARCHAR(256) null,spocId LONG,spocName VARCHAR(256) null,usReasoning VARCHAR(512) null,usFrequencyOut INTEGER,usAccessDPM BOOLEAN,usFolderDPM VARCHAR(256) null,usCreateFolderDPM BOOLEAN,usGestorFolderDPMId LONG,usGestorFolderDPMName VARCHAR(256) null,usDPMNotificationMail VARCHAR(75) null,bioeId VARCHAR(20) null,bioeStateId INTEGER,bioeStateName VARCHAR(75) null,workEstimate DOUBLE,acceptedWorkEstimate DOUBLE,expectedDelivery DATE null,acceptedDelivery DATE null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(256) null,createDate DATE null,modifiedDate DATE null,urlTitle VARCHAR(256) null,state_ VARCHAR(75) null,stateByUserId LONG,stateByUserName VARCHAR(75) null,stateDate DATE null)";
    public static final String TABLE_SQL_DROP =
            "drop table CdsDemands_CdsDemandVersion";

    static {
        TABLE_COLUMNS_MAP.put("cdsDemandVersionId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("version", Types.INTEGER);
        TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("demandId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("type_", Types.INTEGER);
        TABLE_COLUMNS_MAP.put("priority", Types.INTEGER);
        TABLE_COLUMNS_MAP.put("requestedDelivery", Types.TIMESTAMP);
        TABLE_COLUMNS_MAP.put("isGDPR", Types.BOOLEAN);
        TABLE_COLUMNS_MAP.put("gdprInfo", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("fiveTracks", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("requestorId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("requestorName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("requestedForId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("requestedForName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("contactId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("contactName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("domainId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("domainName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("banId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("banName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("spocId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("spocName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("usReasoning", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("usFrequencyOut", Types.INTEGER);
        TABLE_COLUMNS_MAP.put("usAccessDPM", Types.BOOLEAN);
        TABLE_COLUMNS_MAP.put("usFolderDPM", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("usCreateFolderDPM", Types.BOOLEAN);
        TABLE_COLUMNS_MAP.put("usGestorFolderDPMId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("usGestorFolderDPMName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("usDPMNotificationMail", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("bioeId", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("bioeStateId", Types.INTEGER);
        TABLE_COLUMNS_MAP.put("bioeStateName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("workEstimate", Types.DOUBLE);
        TABLE_COLUMNS_MAP.put("acceptedWorkEstimate", Types.DOUBLE);
        TABLE_COLUMNS_MAP.put("expectedDelivery", Types.TIMESTAMP);
        TABLE_COLUMNS_MAP.put("acceptedDelivery", Types.TIMESTAMP);
        TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
        TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
        TABLE_COLUMNS_MAP.put("urlTitle", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("state_", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("stateByUserId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("stateByUserName", Types.VARCHAR);
        TABLE_COLUMNS_MAP.put("stateDate", Types.TIMESTAMP);
    }

}
