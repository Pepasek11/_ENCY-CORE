package cz.csob.ency.modules.apps.meta.cds.internal.loader;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.modules.apps.meta.cds.background.task.MetaCdsLoaderStatusMessageSender;
import cz.csob.ency.modules.apps.meta.cds.exception.ColumnEntryValidateException;
import cz.csob.ency.modules.apps.meta.cds.exception.SystemEntryValidateException;
import cz.csob.ency.modules.apps.meta.cds.exception.TableEntryValidateException;
import cz.csob.ency.modules.apps.meta.cds.loader.MetaCdsLoader;
import cz.csob.ency.modules.apps.meta.cds.model.SystemEntry;
import cz.csob.ency.modules.apps.meta.cds.model.TableEntry;
import cz.csob.ency.modules.apps.meta.cds.service.ColumnEntryLocalService;
import cz.csob.ency.modules.apps.meta.cds.service.SystemEntryLocalService;
import cz.csob.ency.modules.apps.meta.cds.service.TableEntryLocalService;
import cz.csob.ency.connection.sql.SqlUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Component(
        service = MetaCdsLoader.class, immediate = true
)
public class MetaCdsLoaderImpl implements MetaCdsLoader {

    private static final Log log = LogFactoryUtil.getLog(MetaCdsLoaderImpl.class);

    public long loadColumnMeta(ServiceContext serviceContext, String parentTableName) {
        return loadColumnMeta(serviceContext, parentTableName, false);
    }

    public long loadMetaCdsFull(ServiceContext serviceContext) {
        long syscount = loadSystemMeta(serviceContext, true);
        log.debug("Loaded/updated " + syscount + " systems");

        long tabcount = loadTableMeta(serviceContext, null, true);
        log.debug("Loaded/updated " + tabcount + " tables");

        long colcount = loadColumnMeta(serviceContext, null, true);
        log.debug("Loaded/updated " + tabcount + " columns");

        systemCodeMapping.clear();
        tableCodeMapping.clear();

        return syscount + tabcount + colcount;
    }

    public long loadSystemMeta(ServiceContext serviceContext) {
        return loadSystemMeta(serviceContext, false);
    }

    public long loadTableMeta(ServiceContext serviceContext, String parentSystemName) {
        return loadTableMeta(serviceContext, parentSystemName, false);
    }

    private long loadColumnMeta(ServiceContext serviceContext, String parentTableName, boolean keepCache) {
        AtomicLong count = new AtomicLong();

        String sql =
                " (\n" +
                        "   SELECT DISTINCT \n" +//TODO: Remove tmp limitation
                        "      c.[object_type]              as columnType,\n" +
                        "      c.fld_name                   as columnName,\n" +
                        "      c.fld_no                     as columnPosition,\n" +
                        "      c.column_full_name           as columnFullName,\n" +
                        "      t.table_full_name            as tableFullName,\n" +
                        "      t.extract_name               as tableName,\n" +
                        "      t.source_system              as systemName,\n" +
                        "      t.database_nm                as databaseName,\n" +
                        "      COALESCE(TRIM(' ''' FROM c.fld_desc),'')             as [description],\n" +
                        "      c.fld_data_type                                      as dataType,\n" +
                        "      CAST(c.fld_precision as int)                         as dataSize,\n" +
                        "      CASE WHEN c.fld_primary_key='YES' THEN 1 ELSE 0 END  as isPrimaryKey,\n" +
                        "      CASE WHEN c.fld_not_null='YES' THEN 1 ELSE 0 END     as isNotNull,\n" +
                        "      CASE WHEN c.fld_diacritics='YES' THEN 1 ELSE 0 END   as isDiacritic,\n" +
                        "      c.[update_time]                                      as dsaModifiedDate,           \n" +
                        "      CASE WHEN c.valid_to_time IS NULL THEN 1 ELSE 0 END  as isActive\n" +
                        "\n" +
                        "   FROM [dbo].[Ency__DSA_TAB2__HIST] c\n" +
                        "   JOIN [dbo].[Ency__DSA_TAB1__HIST] t \n" +
                        "      on t.table_full_name = c.table_full_name \n" +
                        "         AND t.database_nm IN ('DP_DCDS', 'f_WCDS', 'DP_SCDS', 'DP_TCDS','UP_UOBCRF')\n" +
                        "   JOIN [dbo].[Ency__DSA__SYSTEM__HIST] s \n" +
                        "      on t.source_system = s.system_name\n" +
                        "   WHERE \n" +
                        (Validator.isBlank(parentTableName) ?
                                " 1=1 "
                                : " t.table_full_name=? \n") +
                        ") UNION (\n" +
                        "   SELECT DISTINCT \n" +
                        "      c.[object_type]              as columnType,\n" +
                        "      c.fld_name                   as columnName,\n" +
                        "      c.fld_no                     as columnPosition,\n" +
                        "      c.column_full_name           as columnFullName,\n" +
                        "      c.table_full_name            as tableFullName,\n" +
                        "      t.view_name                  as tableName,\n" +
                        "      t.source_system              as systemName,\n" +
                        "      t.view_database              as databaseName,\n" +
                        "      COALESCE(TRIM(' ''' FROM c.fld_desc),'')             as [description],\n" +
                        "      c.fld_data_type                                      as dataType,\n" +
                        "      CAST(c.fld_precision as int)                         as dataSize,\n" +
                        "      CASE WHEN c.fld_primary_key='YES' OR c.fld_primary_key='ANO' THEN 1 ELSE 0 END  as isPrimaryKey,\n" +
                        "      CASE WHEN c.fld_not_null='YES' OR c.fld_not_null='ANO' THEN 1 ELSE 0 END     as isNotNull,\n" +
                        "      CASE WHEN c.fld_diacritics='YES' OR c.fld_diacritics='ANO' THEN 1 ELSE 0 END   as isDiacritic,\n" +
                        "      c.[update_time]                                      as dsaModifiedDate,           \n" +
                        "      CASE WHEN c.valid_to_time IS NULL THEN 1 ELSE 0 END  as isActive\n" +
                        "\n" +
                        "   FROM [dbo].[Ency__DSA_VIEW2__HIST] c\n" +
                        "      JOIN [dbo].[Ency__DSA_VIEW1__HIST] t \n" +
                        "         on t.table_full_name = c.table_full_name\n" +
                        "      JOIN [dbo].[Ency__DSA__SYSTEM__HIST] s \n" +
                        "         on t.source_system = s.system_name\n" +
                        "   WHERE c.object_type = 'VW' \n" +
                        "      \n" +
                        (Validator.isBlank(parentTableName)
                                ? ""
                                : " AND c.table_full_name=? \n") +
                        ")";

        List<Map<String, Object>> results;
        if (Validator.isBlank(parentTableName)) {
            results = SqlUtils.executeSelect("cemart", sql);
        } else {
            results = SqlUtils.executeSelect("cemart", sql, parentTableName, parentTableName);
        }

        long total = results.size();
        log.debug("Sql executed. Returned " + total + " results");
        long step = Math.floorDiv(total, 100) + 1;

        try {
            results.forEach(row -> {
                long s = System.currentTimeMillis();

                try {
                    String tableFullName = GetterUtil.getString(row.getOrDefault("tableFullName", ""), "");
                    String tableName = GetterUtil.getString(row.getOrDefault("tableName", ""), "");
                    long tableEntryId = tableCodeMapping.getOrDefault(tableFullName, 0L);
                    if (tableEntryId == 0L) {
                        TableEntry te = tableEntryLocalService.fetchEntryByTableFullName(tableFullName);
                        if (Validator.isNotNull(te)) {
                            tableEntryId = te.getTableEntryId();
                        }
                    }
                    if (tableEntryId != 0L) {
                        row.put("tableEntryId", tableEntryId);
                        if (Validator.isBlank(tableName)) {
                            String[] splits = tableFullName.split("\\.");
                            if (splits.length > 0) row.put("tableName", splits[splits.length - 1]);
                        }

                        columnEntryLocalService.addOrUpdateFromRow(row, serviceContext);

                        if (Math.floorMod(count.get(), step) == 0) {
                            metaCdsLoaderStatusMessageSender.sendStatusMessage(SystemEntry.class.getName(), count.get(), total);
                        }
                        count.getAndIncrement();
                        if (log.isDebugEnabled()) {
                            log.debug("#" + count + " in " + (System.currentTimeMillis() - s) + " ms ");
                        }
                    } else {
                        if (log.isDebugEnabled()) {
                            log.debug("Column skipped. Parent table not found." + row);
                        }
                    }
                } catch (ColumnEntryValidateException sve) {
                    log.info("Skipping beacuse of validation :" + sve.getErrors().toString() + " row: " + row);
                } catch (Exception ex) {
                    log.error(ex);
                }

            });
        } catch (Exception ex) {
            log.error(ex);
        }

        log.debug("Columns import ended.");
        return count.get();
    }

    private long loadSystemMeta(ServiceContext serviceContext, boolean keepCaches) {
        AtomicLong count = new AtomicLong();

        String sql =
                "SELECT DISTINCT \n" +
                        "   s0.system_code         AS systemCode,   \n" +
                        "   s0.system_name         AS systemName,   \n" +
                        "   [e40]                  as systemTitle,  \n" +
                        "   j50                    as role,         \n" +
                        "   system_type            AS systemType,   \n" +
                        "   ISNULL(table_count, 0) AS table_count,  \n" +
                        "   ISNULL(view_count, 0)  AS view_count,   \n" +
                        "   COALESCE(TRIM(' ''' FROM s0.system_description),'')   AS description,  \n" +
                        "   a140                   AS stewardName,  \n" +
                        "   a140_c                 AS stewardId,    \n" +
                        "   a138                   as stewardDepartment,\n" +
                        "   a100                   as businessOwnerName,\n" +
                        "   a100_c                 as businessOwnerId,  \n" +
                        "   a110                   as contactPersonName,\n" +
                        "   a110_c                 as contactPersonId,  \n" +
                        "   e80                    as sandboxName,      \n" +
                        "   a190                   as gestorDepartmentId,   \n" +
                        "   a190_c                 as gestorDepartmentName, \n" +
                        "   n10                    as snowAssetTagId,       \n" +
                        "   n20                    as snowAssetTagName,     \n" +
                        "   update_time            as dsaModifiedDate,     \n" +
                        "   CASE WHEN n60='YES' OR n60='ANO' THEN 1 ELSE 0 END as isSlaSigned,          \n" +
                        "   CASE WHEN a95='YES' OR a95='ANO' THEN 1 ELSE 0 END as isSelfBi,             \n" +
                        "   CASE WHEN valid_to_time IS NULL THEN 1 ELSE 0 END  as isActive\n" +
                        "FROM [dbo].[Ency__DSA__SYSTEM__HIST] s0\n" +
                        "   LEFT JOIN\n" +
                        "   (\n" +
                        "      SELECT\n" +
                        "         source_system_code,\n" +
                        "         count(table_full_name) AS table_count\n" +
                        "      FROM (\n" +
                        "             SELECT DISTINCT\n" +
                        "                source_system_code,\n" +
                        "                table_full_name\n" +
                        "             from [dbo].[Ency__DSA_TAB1__HIST]\n" +
                        "          ) as tab1\n" +
                        "      GROUP BY source_system_code\n" +
                        "   ) t2 ON s0.system_code = t2.source_system_code\n" +
                        "   LEFT JOIN\n" +
                        "   (\n" +
                        "      SELECT\n" +
                        "         source_system_code,\n" +
                        "         count(table_full_name) AS view_count\n" +
                        "      FROM (\n" +
                        "             SELECT DISTINCT\n" +
                        "                source_system_code,\n" +
                        "                table_full_name\n" +
                        "             FROM [dbo].[Ency__DSA_VIEW1__HIST]\n" +
                        "          ) AS tab1\n" +
                        "      GROUP BY source_system_code\n" +
                        "   )\n" +
                        "   t1 ON s0.system_code = t1.source_system_code\n" +
                        " ORDER BY s0.system_name\n";

        List<Map<String, Object>> results = SqlUtils.executeSelect("cemart", sql);

        long total = results.size();
        log.debug("Sql executed. Returned " + total + " results");
        long step = Math.floorDiv(total, 100) + 1;

        try {
            results.forEach(row -> {
                long s = System.currentTimeMillis();

                try {
                    SystemEntry entry = systemEntryLocalService.addOrUpdateFromRow(row, serviceContext);

                    if (keepCaches) {
                        systemCodeMapping.put(entry.getSystemCode(), entry.getPrimaryKey());
                    }

                    if (Math.floorMod(count.get(), step) == 0) {
                        metaCdsLoaderStatusMessageSender.sendStatusMessage(SystemEntry.class.getName(), count.get(), total);
                    }

                    log.debug("#" + count + " in " + (System.currentTimeMillis() - s) + " ms");

                } catch (SystemEntryValidateException sve) {
                    log.info("Skipping beacuse of validation :" + sve.getErrors().toString());
                } catch (Exception ex) {
                    log.error(ex);
                }

                count.getAndIncrement();
            });
        } catch (Exception ex) {
            log.error(ex);
        }
        log.debug("Systems import ended.");
        return count.get();
    }

    private long loadTableMeta(ServiceContext serviceContext, String parentSystemName, boolean keepCache) {

        String sql =
                "( " +
                        "       SELECT DISTINCT   \n" +
                        "          extract_name           as tableName            \n" +
                        "        , table_full_name       as tableFullName        \n" +
                        "        , [source_system_code]  as systemCode           \n" +
                        "        , [source_system]       as systemName           \n" +
                        "        , COALESCE(TRIM(' ''' FROM [table_desc]),'') as [description]        \n" +
                        "        , [database_nm]         as [tableDatabase]      \n" +
                        "        , [object_type]         as [tableType]          \n" +
                        "        , COALESCE(TRIM(' ''' FROM [specification_owner]),'') as [specificationOwnerName] \n" +
                        "        , COALESCE(TRIM(' ''' FROM [extract_contact_person]),'') as [contactPersonName] \n" +
                        "        , [key_field_list]      as [keyFieldList]       \n" +
                        "        , [extract_url]         as dsaUrl       \n" +
                        "        , t.[update_time]       as dsaModifiedDate           \n" +
                        "        , CASE WHEN t.valid_to_time IS NULL THEN 1 ELSE 0 END as isActive\n" +
                        "        , COALESCE(TRIM(' ''' FROM [unstructured_clause]),'')   as unstructuredClause\n" +
                        "        \n" +
                        "       FROM   \n" +
                        "           [dbo].[Ency__DSA_TAB1__HIST] t   \n" +
                        "       JOIN [dbo].[Ency__DSA__SYSTEM__HIST] s \n" +
                        "            on t.source_system = s.system_name\n" +
                        "       where  \n" +
                        "           database_nm in ('DP_DCDS','f_WCDS','DP_SCDS','DP_TCDS','UP_UOBCRF')  \n" +
                        (Validator.isBlank(parentSystemName) ? "" :
                                "          AND [source_system]=?  \n") +
                        "\n" +
                        ") UNION (\n" +
                        "SELECT DISTINCT \n" +
                        "    [view_name]              as tableName      \n" +
                        "    , v.[table_full_name]    as tableFullName  \n" +
                        "    , [source_system_code]   as systemCode     \n" +
                        "    , [source_system]        as systemName     \n" +
                        "    , COALESCE(TRIM(' ''' FROM [table_desc]),'') as [description]  \n" +
                        "    , [view_database]        as tableDatabase  \n" +
                        "    , v.[object_type]        as [tableType]    \n" +
                        "    , COALESCE(TRIM(' ''' FROM [specification_owner]),'') as [specificationOwnerName] \n" +
                        "    , COALESCE(TRIM(' ''' FROM [extract_contact_person]),'') as [contactPersonName] \n" +
                        "    , ''                     as keyFieldList   \n" +
                        "    , [extract_url]          as [dsaUrl]       \n" +
                        "    , v.[update_time]        as dsaModifiedDate     \n" +
                        "    , CASE WHEN v.valid_to_time IS NULL THEN 1 ELSE 0 END as isActive \n" +
                        "    , COALESCE(TRIM(' ''' FROM [unstructured_clause]),'')  as unstructuredClause \n" +
                        "\n" +
                        " FROM [dbo].[Ency__DSA_VIEW1__HIST] as v \n" +
                        " JOIN (" +
                        "   select MAX(version_timestamp) as version_timestamp, " +
                        "       table_full_name, " +
                        "       object_type  " +
                        "    FROM [dbo].[Ency__DSA_VIEW1__HIST] " +
                        "    group by table_full_name, object_type" +
                        ")  as b\n" +
                        "        on v.table_full_name=b.table_full_name and v.version_timestamp=b.version_timestamp  and v.object_type=b.object_type\n" +
                        " JOIN [dbo].[Ency__DSA__SYSTEM__HIST] s \n" +
                        "           on v.source_system = s.system_name\n" +
                        " WHERE \n" +
                        "    v.object_type='VW' \n" +
                        (Validator.isBlank(parentSystemName) ? "" :
                                "          AND [source_system]=?  \n") +
                        "    )";

        List<Map<String, Object>> results;
        if (Validator.isBlank(parentSystemName)) {
            results = SqlUtils.executeSelect("cemart", sql);
        } else {
            results = SqlUtils.executeSelect("cemart", sql, parentSystemName, parentSystemName);
        }

        long total = results.size();
        log.debug("Sql executed. Returned " + total + " results");
        long step = Math.floorDiv(total, 100) + 1;

        AtomicLong errcount = new AtomicLong();
        AtomicLong count = new AtomicLong();

        try {
            for (Map<String, Object> row : results) {
                if (errcount.get() < 5) { //todo, remove on final version
                    long s = System.currentTimeMillis();

                    try {
                        long systemCode = GetterUtil.getLong(row.getOrDefault("systemCode", 0), 0);
                        long systemEntryId = systemCodeMapping.getOrDefault(systemCode, 0L);

                        if (systemEntryId == 0L) {
                            SystemEntry se = systemEntryLocalService.fetchEntryByCode(systemCode);
                            if (Validator.isNotNull(se)) {
                                systemEntryId = se.getSystemEntryId();
                                systemCodeMapping.put(systemCode, systemEntryId);
                            }
                        }

                        String tableName = GetterUtil.getString(row.getOrDefault("tableName", ""), "");
                        if (Validator.isBlank(tableName)) {
                            String[] splits =
                                    GetterUtil.getString(
                                                    row.getOrDefault("tableFullName", "")
                                                    , "")
                                            .split("\\.");
                            if (splits.length > 0) {
                                row.put("tableName", splits[splits.length - 1]);
                            }
                        }

                        if (systemEntryId != 0L) {
                            row.put("systemEntryId", systemEntryId);
                            tableEntryLocalService.addOrUpdateFromRow(row, serviceContext);

                            if (Math.floorMod(count.get(), step) == 0) {
                                metaCdsLoaderStatusMessageSender.sendStatusMessage(SystemEntry.class.getName(), count.get(), total);
                            }

                            if (log.isDebugEnabled()) {
                                log.debug("#" + count + " in " + (System.currentTimeMillis() - s) + " ms ");
                            }

                        } else {
                            if (log.isDebugEnabled()) {
                                log.debug("Table skipped. Parent system not found." + row);
                            }
                            errcount.getAndIncrement();
                        }

                    } catch (TableEntryValidateException sve) {
                        log.info("Skipping beacuse of validation :" + sve.getErrors().toString() + " row: " + row);
                        errcount.getAndIncrement();

                    } catch (Exception ex) {
                        log.error(ex);
                        errcount.getAndIncrement();
                    }
                    count.getAndIncrement();
                }
                //});
            }
        } catch (Exception ex) {
            log.error(ex);
        }

        if (!keepCache) {
            systemCodeMapping.clear();
        }
        log.debug("Tables import ended.");
        return count.get();
    }

    private final Map<Long, Long> systemCodeMapping = new HashMap<>();
    private final Map<String, Long> tableCodeMapping = new HashMap<>();
    @Reference
    private ColumnEntryLocalService columnEntryLocalService;
    @Reference
    private MetaCdsLoaderStatusMessageSender metaCdsLoaderStatusMessageSender;
    @Reference
    private SystemEntryLocalService systemEntryLocalService;
    @Reference
    private TableEntryLocalService tableEntryLocalService;
}
