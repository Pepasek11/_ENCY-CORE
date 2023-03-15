package cz.csob.ency.cds.demands.bioe.service.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.comment.CommentManagerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.lock.DuplicateLockException;
import com.liferay.portal.kernel.lock.Lock;
import com.liferay.portal.kernel.lock.LockManager;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.util.*;
import com.liferay.subscription.service.SubscriptionLocalServiceUtil;
import cz.csob.ency.cds.demands.constants.CdsDemandWorkflowConstants;
import cz.csob.ency.cds.demands.internal.notifications.CdsDemandNotificationSender;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.cds.demands.service.CdsDemandLocalServiceUtil;
import cz.csob.ency.connection.sql.SqlUtils;
import cz.csob.ency.workflow.manager.EncyWorkflowManagerUtil;
import cz.csob.ency.workflow.model.EncyWorkflowStateInstance;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

@Component(immediate = true, service = BioeDemandsSync.class)
public class BioeDemandsSync {
    private static final long LOCK_EXPIRATION_TIME = 3600;
    private static final Log _log = LogFactoryUtil.getLog(BioeDemandsSync.class);
    private static final List<String> checkStates =
            Arrays.asList(new String[]{
                    CdsDemandWorkflowConstants.STATE_REALIZACE,
                    CdsDemandWorkflowConstants.STATE_REVIZE_DODAVKY,
                    CdsDemandWorkflowConstants.STATE_AKCEPTOVANO,
                    CdsDemandWorkflowConstants.STATE_AKCEPTACE
            });



    public Map<String, Object> doSync() throws PortalException {
        ServiceContext serviceContext = new ServiceContext();

        Company company = CompanyLocalServiceUtil.getCompanies().get(0);
        long companyId = company!=null?company.getCompanyId():0;

        serviceContext.setCompanyId(companyId);
        serviceContext.setScopeGroupId(company.getGroupId());
        serviceContext.setUserId(_userLocalService.getDefaultUserId(companyId));
        return doSync(serviceContext);
    }

    public Map<String, Object> doSync(ServiceContext serviceContext) {
        long companyId = serviceContext.getCompanyId();
        try {
            long userId = _userLocalService.getDefaultUserId(companyId);

            Lock lock = _lockManager.lock(
                    userId, BioeDemandsSync.class.getName(), companyId,
                    BioeDemandsSync.class.getName(), false,
                    LOCK_EXPIRATION_TIME, false);

            if (!lock.isNew()) {
                if (_log.isDebugEnabled()) {
                    _log.debug(
                            StringBundler.concat(
                                    "Skipping BIOE import for company ", companyId,
                                    " because another BIOE import is in process by ",
                                    "the same user ", userId));
                }

                return Collections.emptyMap();
            }
        } catch (DuplicateLockException duplicateLockException) {
            if (_log.isDebugEnabled()) {
                Lock lock = duplicateLockException.getLock();

                _log.debug(
                        StringBundler.concat(
                                "Skipping BIOE import for company ", companyId,
                                " because another BIOE import is in process by ",
                                "another user ", lock.getUserId()));
            }

            return Collections.emptyMap();
        } catch (Throwable throwable) {
            if (_log.isDebugEnabled()) {
                _log.debug(
                        "Skipping BIOE import for company " + companyId +
                                " because unable to lock the lock",
                        throwable);
            }

            return Collections.emptyMap();
        }

        Map<String, Object> result = Collections.emptyMap();
        try {
            result = _doSync(serviceContext);
        } finally {
            _lockManager.unlock(BioeDemandsSync.class.getName(), companyId);
        }
        return result;
    }

    protected void _checkValuesAndNotify(CdsDemand newEntry, CdsDemand oldEntry) {
        try {

            if (!checkStates.contains(oldEntry.getState())) {
                return;
            }

            double wen = newEntry.getWorkEstimate();
            double weo = oldEntry.getWorkEstimate();

            Date edn = newEntry.getExpectedDelivery();
            Date edo = oldEntry.getExpectedDelivery();


            _log.debug(String.format(
                    "Going to check for changes in [%s] in MDs [%s] vs [%s] and Agreed date [%s] vs [%s]",
                    newEntry.getPrimaryKey(), wen, weo, edn, edo)
            );
            if (edn == null || edo == null) {
                _log.warn("There are some null data in mds or dates, when there should be values. " +
                        "Bad testing data or corrupted data.");
                return;
            }

            String out = "";
            if (weo != wen) {
                out += String.format("<li>Změna odhadu pracnosti z <b>%s</b> MDs na <b>%s</b> MDs</li>", weo, wen);
            }

            String sdn = DateUtil.getDate(
                    edn, "dd.MM.yyy", PortalUtil.getSiteDefaultLocale(
                            oldEntry.getGroupId()));
            String sdo = DateUtil.getDate(
                    edo, "dd.MM.yyy", PortalUtil.getSiteDefaultLocale(
                            oldEntry.getGroupId()));

            if (!sdo.equals(sdn)) {
                out += String.format("<li>Změna termínu dodání z <b>%s</b> na <b>%s</b></li>", sdo, sdn);
            }

            if (Validator.isBlank(out)) {
                _log.debug("No CHANGE");
                return;
            }

            _log.debug("Found changes: " + out);

            String stateName = newEntry.getState();
            try {
                EncyWorkflowStateInstance ewsi =
                        EncyWorkflowManagerUtil.getEntryStateInstance(
                                newEntry.getCompanyId(), newEntry.getGroupId(), newEntry);
                stateName = LanguageUtil.get(
                        ResourceBundleUtil.getBundle(
                                PortalUtil.getSiteDefaultLocale(
                                        newEntry.getGroupId()),
                                CdsDemand.class),
                        ewsi.getWorkflowState().getName());
            } catch (Exception e) {
            }
            out = String.format(
                    "Dobrý den,<br/><br/> " +
                            "u požadavku %s ve stavu <i>%s</i> došlo k následujícím změnám: <br/>" +
                            "<ul>%s</ul><br/><br/>" +
                            "S pozdravem, <br/> Vaše Ency", newEntry.getTitle(), stateName, out);

            String mailHeader = "Změna parametrů CDS požadavku";

            CdsDemandNotificationSender sender = new CdsDemandNotificationSender(newEntry);
            sender
                    .info(mailHeader)
                    .subject(mailHeader)
                    .body(out)
                    .targets(false, true, true, true, false
                    ).send();

            User u = _userLocalService.getDefaultUser(newEntry.getCompanyId());
            CommentManagerUtil.addComment(
                    u == null ? 0 : u.getUserId(),
                    newEntry.getGroupId(),
                    newEntry.getModelClassName(),
                    newEntry.getPrimaryKey(),
                    "System", "Změna SLA", out,
                    new Function<String, ServiceContext>() {

                        @Override
                        public ServiceContext apply(String className) {
                            ServiceContext serviceContext = new ServiceContext();

                            serviceContext.setCompanyId(newEntry.getCompanyId());

                            return serviceContext;
                        }

                    }
            );

            _log.debug("CHECK FINISHED");
        } catch (Exception ex) {
            _log.error("Exception catched when checking for date or MDs change", ex);
        }
    }


    @Reference(unbind = "-")
    protected void setLockManager(LockManager lockManager) {
        _lockManager = lockManager;
    }

    private Map<String, Object> _doSync(ServiceContext serviceContext) {
        if (_log.isDebugEnabled()) _log.debug("Starting");

        String sql =
                "Select\n" +
                        "       bioe.[JIRA_ID]                         as xid\n" +
                        "       ,bioe.[ID_JFP]                         as bioe_id\n" +
                        "       ,bioe.[bioe_stav]                      as bioe_status_name\n" +
                        "       ,bioe.[bioe_stav_id]                   as bioe_status_id\n" +
                        "       ,bioe.[typ_pozadavku_id]               as typ_pozadavku_id\n" +
                        "       ,CAST(COALESCE(bioe.[domena_id],0) as bigint)  as domain_id\n" +
                        "       ,bioe.[domena]                         as domain_name\n" +
                        "       ,CONCAT(bioe.domena_id,' - ',bioe.domena) as domain_label\n" +
                        "       ,bioe.[zadatel_id]                     as requestor_id\n" +
                        "       ,bioe.[datum_registrace]               as registration_date\n" +
                        "       ,bioe.[zacatek_praci]                  as work_start_dt\n" +
                        "       ,bioe.[konec_praci]                    as work_end_dt\n" +
                        "       ,COALESCE(bioe.[pracnost],0)           as workhoursn\n" +
                        "       ,bioe.[termin]                         as expected_end_of\n" +
                        "       ,ency.[id]                             as xid2\n" +
                        "       ,zadatele.zadatel_logon as requestor_login\n" +
                        "       ,case WHEN bioe.[typ_pozadavku_id]=1 THEN zadatele.spoc_us_logon ELSE zadatele.spoc_logon END as spoc_login\n" +
                        " from ENCY_DD_MOD_BPE_ALL bioe         \n" +
                        " join DX_NEW_ENCY ency                 \n" +
                        "       on ency.id=bioe.JIRA_ID         \n" +
                        " left join ENCY_zadatele zadatele on zadatele.os_c=bioe.zadatel_id and zadatele.actual=1\n" +
                        " where bioe.ID_JFP=(                                   \n" +
                        "       select max(bpe2.ID_JFP)                         \n" +
                        "       from ENCY_DD_MOD_BPE bpe2                       \n" +
                        "       where bpe2.JIRA_ID=bioe.JIRA_ID                 \n" +
                        "       )                                               \n" +
                        "       AND bioe.[JIRA_ID] != 'ency_0001'               \n" +
                        "       AND bioe.[JIRA_ID] IS NOT NULL AND [bioe_stav_id]<>11";

        List<Map<String, Object>> results;
        try {
            results = SqlUtils.executeSelect("bioe", sql);
        } catch (Exception e) {
            _log.error(e.getMessage());
            return HashMapBuilder.<String, Object>put("error", e.getMessage()).build();
        }
        if (_log.isDebugEnabled()) _log.error("Debug: Number of loaded BIOE records:" + results.size());

        long saved = 0;
        long skipped = 0;
        long failed = 0;

        Map<String, String> fieldmap = HashMapBuilder
                .put("bioeId", "bioe_id")
                .put("workEstimate", "workhoursn")
                .put("expectedDelivery", "expected_end_of")
                .put("domainId", "domain_id")
                .put("domainName", "domain_label")
                .put("bioeStateId", "bioe_status_id")
                .put("bioeStateName", "bioe_status_name")
                .build();

        List<String> loadedXids = new LinkedList<>();

        for (Map<String, Object> res : results) {
            try {
                if (_log.isDebugEnabled()) _log.debug("Processing record " + res);
                String xid = String.valueOf(res.getOrDefault("xid", ""));

                if (Validator.isBlank(xid)) {
                    if (_log.isDebugEnabled()) _log.debug("record without xid " + res);
                    continue;
                }

                CdsDemand entry = null;
                if (xid.contains("-")) {
                    entry = CdsDemandLocalServiceUtil.fetchCdsDemand(xid);
                } else {
                    entry = CdsDemandLocalServiceUtil.fetchCdsDemand(Long.valueOf(xid));
                }

                if (entry == null) {
                    // if (_log.isDebugEnabled()) _log.debug("demand is not in db: " + res);
                    skipped++;
                    continue;
                }

                if (loadedXids.contains(xid)) {
                    _log.error("Entry [" + xid + "] was already loaded, WATCH OUT FOR MULTIPLE RECORDS ON THE INPUT !!!!!");
                    skipped++;
                    continue;
                }
                loadedXids.add(xid);

                /** Specify status not differentiated by bioe states */
                if (5 == (short) res.get("bioe_status_id") && Validator.isNotNull(res.get("expected_end_of"))) {
                    if (1 == (short) res.get("typ_pozadavku_id")) {
                        res.put("bioe_status_name", "Čeká na zahájení vývoje");
                    } else {
                        res.put("bioe_status_name", "Čeká na souhlas zákazníka");
                    }
                }

                if (Validator.isNotNull(res.get("expected_end_of"))) {
                    LocalDateTime ldt = (LocalDateTime) res.get("expected_end_of");
                    res.put("expected_end_of", Date.from(
                            ldt.atZone(
                                    ZoneId.systemDefault()
                            ).toInstant())
                    );
                }

                _subscribeAsignees(res, entry, serviceContext);

                Map<String, BiConsumer<CdsDemand, Object>> setters =
                        entry.getAttributeSetterBiConsumers();
                try {

                    for (Map.Entry<String, String> name : fieldmap.entrySet()) {
                        if (setters.containsKey(name.getKey())) {
                            //_log.debug("Setting field: " + name.getKey() + " col name: " + name.getValue());
                            setters.get(name.getKey()).accept(entry, res.get(name.getValue()));
                        }
                    }


                    String login = String.valueOf(res.get("requestor_login"));
                    User usr = null;
                    if (!Validator.isBlank(login)) {
                        usr = UserLocalServiceUtil.fetchUserByScreenName(
                                PortalUtil.getDefaultCompanyId(), login);
                    }
                    if (Validator.isNull(usr)) {
                        _log.debug(" Unable to find user for requestor login '" + login + "' ");
                    } else {
                        boolean requestor = false;
                        long old = entry.getRequestedForId();
                        if (old <= 0) {
                            old = entry.getRequestorId();
                            if (old <= 0) return Collections.emptyMap();
                            requestor = true;
                        }

                        if (requestor) {
                            entry.setRequestorId(usr.getPrimaryKey());
                        } else {
                            entry.setRequestedForId(usr.getPrimaryKey());
                        }
                    }

                    login = String.valueOf(res.get("spoc_login"));
                    usr = null;
                    if (!Validator.isBlank(login)) {
                        usr = UserLocalServiceUtil.fetchUserByScreenName(
                                PortalUtil.getDefaultCompanyId(), login);
                    }

                    if (Validator.isNull(usr)) {
                        _log.debug(" Unable to find user for spoc login '" + login + "' ");
                    } else {
                        entry.setSpocId(usr.getPrimaryKey());
                    }
                } catch (Exception ex) {
                    _log.error("Error occured when updating extra fields with result [" + res + "]. Exception is " + ex.getMessage(), ex);
                }

                CdsDemand e2 = entry.cloneWithOriginalValues();

                if (entry.isSubstantiallyEqual(e2)) {
                    _log.debug(" Entry " + entry.getPrimaryKey() + " does not change");
                    skipped++;
                } else {
                    _log.debug(" Going to save entry " + entry.getPrimaryKey());
                    _checkValuesAndNotify(entry, e2);
                    CdsDemandLocalServiceUtil.updateEntry(entry, serviceContext);
                    saved++;
                    _log.debug(" Entry saved ");
                }
            } catch (Exception ex) {
                _log.error("Exception occured when processing result [" + res + "]. Exception is " + ex.getMessage());
                _log.error(ex);
                failed++;
                continue;
            }
        }

        _refreshMaterializedViews();

        _log.warn(String.format("Bioe loader finished processing. Saved : %s entries. " +
                "Skipped: %s entries. Failed: %s entries. ", saved, skipped, failed));
        return HashMapBuilder.<String, Object>create(3)
                .put("saved", saved)
                .put("skipped", skipped)
                .put("failed", failed)
                .build();

    }

    private void _refreshMaterializedViews() {
        try {
            SqlUtils.executeUpdate("cemart",
                    "EXECUTE [dbo].[Ency__MATERIALIZED_VIEWS_refresh]"
            );
        } catch (Exception ex) {
            _log.error(ex);
        }
    }

    private void _subscribeAsignees(Map<String, Object> res, CdsDemand entry, ServiceContext serviceContext) {
        short bioestatusId = (short) res.get("bioe_status_id");

        if (bioestatusId == 5 || bioestatusId == 4) {
            try {

                List<Map<String, Object>> result;
                result = SqlUtils.executeSelect("bioe",
                        "SELECT ID_BPE, logon_name as logon " +
                                " FROM [dbo].[ENCY_DD_MOD_BPE_SUBTASKS_ALL] " +
                                " WHERE JIRA_ID=?",
                        String.valueOf(entry.getPrimaryKey())
                );

                if (Validator.isNull(result)) {
                    _log.debug(" No result returned");
                }
                _log.debug(" Number of loaded task {$res.bioeID} assignees found:" + result.size());
                for (Map<String, Object> row : result) {
                    _log.debug(" Processing user record " + row);

                    String logon = String.valueOf(row.get("logon"));
                    if (Validator.isBlank(logon)) {
                        continue;
                    }

                    // Escape pipe character, otherwise it will tokenize each character separately
                    String[] splits = logon.split("\\|");
                    if (splits.length != 2) {
                        _log.debug(String.format(
                                " Invalid logon %, unable to split to two parts", logon));
                        continue;
                    }

                    User usr = UserLocalServiceUtil.fetchUserByScreenName(
                            serviceContext.getCompanyId(), splits[1]);

                    if (Validator.isNull(usr)) {
                        _log.debug(" Unable to find user for login " + splits[1]);
                        continue;
                    }

                    try {
                        SubscriptionLocalServiceUtil.addSubscription(
                                usr.getUserId(), entry.getGroupId(), entry.getModelClassName(), entry.getPrimaryKey()
                        );
                        _log.debug(" Watch set.");
                    } catch (Exception e) {
                        _log.debug(" Exception when setting watch: ", e);
                    }
                }
            } catch (Exception e) {
                _log.error("Exception caught when procesing assignees : ", e);
            }
        }
    }

    private LockManager _lockManager;
    @Reference
    private UserLocalService _userLocalService;

}
