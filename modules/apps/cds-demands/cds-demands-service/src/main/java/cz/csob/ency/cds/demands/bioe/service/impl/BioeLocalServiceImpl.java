package cz.csob.ency.cds.demands.bioe.service.impl;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.cds.demands.bioe.service.BioeLocalService;
import cz.csob.ency.cds.demands.configuration.CdsDemandsConfiguration;
import cz.csob.ency.cds.demands.service.CdsDemandLocalServiceUtil;
import cz.csob.ency.common.json.response.EncyJsonResponse;
import cz.csob.ency.connection.sql.SqlUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import java.util.*;
import java.util.stream.Collectors;

@Component(
        configurationPid = "cz.csob.ency.cds.demands.configuration.CdsDemandsConfiguration",
        immediate = true,
        property = {
                "json.web.service.context.name=cdsdemand",
                "json.web.service.context.path=BIOE"
        },
        service = BioeLocalService.class
)

public class BioeLocalServiceImpl implements BioeLocalService {

    protected static final Map<String, Long> userDomainCache = new HashMap<>();
    private static final Log _log = LogFactoryUtil.getLog(BioeLocalServiceImpl.class);

    @Override
    public EncyJsonResponse getClouds(Long[] domainId, ServiceContext serviceContext) {

        List<Long> l = new LinkedList<Long>();
        try {
            List<Map<String, Object>> rows = SqlUtils.executeSelect(
                    "cemart",
                    "SELECT\n" +
                            "      CASE WHEN [request_type]=1 THEN 'Ultraspeed' ELSE [utvar_b0_desc] END AS [utvar_b0_desc]\n" +
                            "      ,[utvar_b0]\n" +
                            "      ,[request_type]\n" +
                            "      ,[prislibene]\n" +
                            "      ,[planovano]\n" +
                            "      ,[planwaiting]\n" +
                            "      ,[planworking]\n" +
                            "      ,[plandone]\n" +
                            "      ,[vykazanoworking]\n" +
                            "      ,[vykazanoclosed]\n" +
                            "      ,[vykazano]\n" +
                            "      ,[rok]\n" +
                            "FROM [ce_mart].[dbo].[BIOE__CLOUDY_MATERIALIZED]\n" +
                            "WHERE rok=year(getdate()) AND request_type<3 " +
                            ((domainId != null && domainId.length > 0) ?
                                    " AND [utvar_b0] in (" + Arrays.stream(domainId)
                                            .map(aLong -> String.valueOf(aLong))
                                            .collect(Collectors.joining(",")) + ") "
                                    : "")
            );

            return EncyJsonResponse.success(rows);
        } catch (Exception ex) {
            _log.error(ex);
            return EncyJsonResponse.failure(ex);
        }
    }

    @JsonIgnore
    @Override
    public Map<String, Object> getRequestorInfo(User user, ServiceContext serviceContext) {
        if (Validator.isNull(user) || Validator.isBlank(user.getScreenName())) {
            return Collections.EMPTY_MAP;
        }
        try {
            String defaultBanLogon = _cdsDemandsConfiguration.defaultBanUserScreenName();
            List<Map<String, Object>> rows = SqlUtils.executeSelect("bioe",
                    "select " +
                            "   zadatel_jmeno, " +
                            "   bod, " +
                            "   bod_id, " +
                            "   ban_logon, " +
                            "   ? as ban_us_logon, " +
                            "   dm_jmeno, spoc_logon, " +
                            "   spoc_jmeno, " +
                            "   spoc_us_logon, " +
                            "   spoc_us_jmeno " +
                            " from bioe.dbo.ENCY_zadatele " +
                            " where actual=1 and (zadatel_logon=?)",
                    defaultBanLogon,
                    user.getScreenName()
            );

            if (rows.size() > 0) {

                Map<String, Object> row = rows.get(0);
                long id = 0;

                _updateRow(row, "spoc", serviceContext);
                _updateRow(row, "spoc_us", serviceContext);
                _updateRow(row, "ban", serviceContext);
                _updateRow(row, "ban_us", serviceContext);

                _log.debug("got infop for " + user.getScreenName() + ": " + rows.get(0));
                return row;
            }
        } catch (Exception ex) {
            _log.error(ex);
        }
        return Collections.emptyMap();
    }

    @Override
    public Map<String, Object> getRequestorInfo(long userId, ServiceContext serviceContext) {
        User user = null;
        try {
            user = userLocalService.getUserById(userId);
        } catch (PortalException e) {
            return Collections.EMPTY_MAP;
        }
        return getRequestorInfo(user, serviceContext);
    }

    @Override
    public long getUserDomainId(String screenName) {
        //@todo: make userDomainCache expirable
        Long domainId = userDomainCache.getOrDefault(screenName, null);

        if (Validator.isNotNull(domainId)) {
            return domainId;
        }

        try {
            List<Map<String, Object>> rows = SqlUtils.executeSelect("bioe",
                    "SELECT TOP (1) [bod_id]\n" +
                            "  FROM [BIOE].[dbo].[ENCY_zadatele]\n" +
                            "  where zadatel_logon like ? and actual=1",
                    screenName
            );

            if (rows.size() > 0) {
                Map<String, Object> row = rows.get(0);
                long id = GetterUtil.getLong(
                        row.getOrDefault("bod_id", 0));

                if (id > 0) {
                    userDomainCache.put(screenName, id);
                    return id;
                }
            }
        } catch (Exception ex) {
            _log.error(ex);
        }

        return 0;
    }

    @Override
    public Map<String, Object> runBioeSync(ServiceContext serviceContext) {
        // @todo check acces rights
        Map<String, Object> syncresult = bioeDemandsSync.doSync(serviceContext);

        Map<String, Object> result =
                HashMapBuilder.<String, Object>create(2)
                        .put("message", "sync-run-sucessfully")
                        .put("success", true)
                        .build();
        if (syncresult.containsKey("error")) {
            result.put("message", syncresult.get("error"));
            result.put("success", false);
        }

        return result;
    }

    @Activate
    @Modified
    protected void activate(Map<String, Object> properties) throws SchedulerException {
        _cdsDemandsConfiguration = ConfigurableUtil.createConfigurable(
                CdsDemandsConfiguration.class, properties);
    }

    private void _updateRow(Map<String, Object> row, String role, ServiceContext serviceContext) {
        try {
            User u = userLocalService.getUserByScreenName(serviceContext.getCompanyId(),
                    GetterUtil.getString(row.getOrDefault(role + "_logon", "XXXXXX"))
            );
            row.put(role + "_id", u.getUserId());
            row.put(role + "_name", CdsDemandLocalServiceUtil.getFormattedUserName(u));
        } catch (NoSuchUserException e) {
            //ok
        } catch (PortalException ex) {
            _log.error(ex);
        }
    }

    protected volatile CdsDemandsConfiguration _cdsDemandsConfiguration;
    @Reference
    protected BioeDemandsSync bioeDemandsSync;
    @Reference
    protected UserLocalService userLocalService;
}
