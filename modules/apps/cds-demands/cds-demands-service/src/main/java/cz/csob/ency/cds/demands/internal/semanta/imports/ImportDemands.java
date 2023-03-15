package cz.csob.ency.cds.demands.internal.semanta.imports;


import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.comment.CommentManagerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import cz.csob.ency.cds.demands.constants.*;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.cds.demands.service.CdsDemandLocalService;
import cz.csob.ency.cds.demands.service.CdsDemandLocalServiceUtil;
import cz.csob.ency.cds.demands.service.persistence.CdsDemandPersistence;
import cz.csob.ency.cds.demands.service.persistence.CdsDemandVersionPersistence;
import cz.csob.ency.connection.sql.SqlUtils;
import cz.csob.ency.workflow.manager.EncyWorkflowManager;
import cz.csob.ency.workflow.model.*;
import cz.csob.ency.workflow.service.*;
import cz.csob.ency.workflow.util.WorkflowContextBuilder;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component(service = ImportDemands.class, immediate = true)

public class ImportDemands {
    private static final String CONN_NAME = "cemart";
    private static final Map<String, BiConsumer<CdsDemand, Object>>
            _attributeSetterBiConsumers;
    private static final Log _log = LogFactoryUtil.getLog(ImportDemands.class);
    private static long _companyId;
    private static Map<String, Integer> _fiveTracks;
    private static Map<String, Map<String, Object>> _userMap = new HashMap<>();

    private static void _dummy(CdsDemand cdsDemand, Map<String, Object> row) {
    }

    private static boolean _getBoolean(Map<String, Object> row) {
        return "1".equals(String.valueOf(row.get("int_value")));
    }

    private static String _getClob(Map<String, Object> row) {
        return _getStringColumn(row, "clob_value");
    }

    private static Date _getDate(Map<String, Object> row) {
        LocalDateTime val = (LocalDateTime) row.get("date_value");
        if (Validator.isNull(val)) {
            return null;
        }
        return Date.from(val.atZone(ZoneId.systemDefault()).toInstant());
    }

    private static int _getFrequency(String typeXid) {
        switch (typeXid) {
            case "[xf3:a915181e-76ec-4a34-bd21-39b5e64499ac]":
                return CdsDemandUSFrequency.FREQUENCY_ONCE;
            case "[xf3:0f40496b-341e-431c-acfa-45e0f059df14]":
                return CdsDemandUSFrequency.FREQUENCY_DAILY;
            case "[xf3:07fbe1b2-624f-4364-bc91-c77afa7770e6]":
                return CdsDemandUSFrequency.FREQUENCY_WEEKLY;
            case "[xf3:080d2bb4-fa67-48a0-9370-63d6ba87b922]":
                return CdsDemandUSFrequency.FREQUENCY_MONTHLY;
            case "[xf3:5cd648d1-ba8a-46e4-b8f1-1131c7e55de1]":
                return CdsDemandUSFrequency.FREQUENCY_QUARTERLY;
            case "[xf3:f1c91526-bcc3-4c89-9901-c3153ea4c50c]":
                return CdsDemandUSFrequency.FREQUENCY_HALFYEARLY;
            case "[xf3:0a302665-37c9-4af3-9abe-d34c8420480e]":
                return CdsDemandUSFrequency.FREQUENCY_YEARLY;
            case "[xf3:530142fb-c4df-40b6-aac7-aa6289e4479b]":
                return CdsDemandUSFrequency.FREQUENCY_OTHER;
            default:
                return 0;
        }
    }

    private static int _getInt(Map<String, Object> row) {
        Object o = row.get("int_value");
        return o == null ? 0 : Integer.parseInt(String.valueOf(o));
    }

    private static int _getPriority(String typeXid) {
        switch (typeXid) {
            case "[xf3:ecccf323-f93a-4a8e-86d2-708f76fcebc9]":
                return CdsDemandPriority.PRIORITY_HIGH;
            case "[xf3:22f6c4b0-39f7-4c57-bb97-b7f9a2ef60d0]":
                return CdsDemandPriority.PRIORITY_LOW;
            case "[xf3:66fce1ec-4600-4704-b228-c0773a6105f2]":
                return CdsDemandPriority.PRIORITY_EXTREME;
            default:
                return 0;
        }
    }

    private static String _getState(String stateXid, String defaultStateTitle) {
        switch (stateXid) {
            case "b8a3b85f-96ef-48df-8645-938423f523d3":
                return CdsDemandWorkflowConstants.STATE_AKCEPTACE;
            case "a4e0f671-28e2-47d8-bd38-d476501e8bae":
                return CdsDemandWorkflowConstants.STATE_AKCEPTOVANO;
            case "f6fabdc7-0b09-4214-a361-e2c528711ec0":
                return CdsDemandWorkflowConstants.STATE_REALIZACE;
            case "9c07e30e-564e-468e-a032-008d4a11c778":
                return CdsDemandWorkflowConstants.STATE_NAVRH;
            case "313e6adb-8345-445b-a840-8ae6f72feb70":
                return CdsDemandWorkflowConstants.STATE_ZRUSENO;
            case "fc1d44e8-f7cc-43a0-a9bc-76dcc3481ddc":
                return CdsDemandWorkflowConstants.STATE_REVIZE_DODAVKY;
            case "ef09ca58-ea45-49bb-b6d5-b2b71c9aa95b":
                return CdsDemandWorkflowConstants.STATE_REVIZE_BAN;
            case "621f3e4a-03e7-434d-a8f1-e03d9801a412":
                return CdsDemandWorkflowConstants.STATE_REVIZE_SPOC;
            case "29703a0f-dadd-4fe9-b991-23c08a58ad45":
                return CdsDemandWorkflowConstants.STATE_POZASTAVENO_BAN;
            case "31e0576f-236f-42f6-8fe4-b7a8ce77a6f0":
                return CdsDemandWorkflowConstants.STATE_POZASTAVENO_SPOC;
            case "31063b1f-8ada-4b4b-b92c-814238e98491":
                return CdsDemandWorkflowConstants.STATE_NACENOVANO;
            case "1bf7b836-dac7-49fb-b8a9-b25b1a839a6d":
                return CdsDemandWorkflowConstants.STATE_NACENENO;
            case "2125d380-4257-449e-b645-2fb3859d975a":
                return CdsDemandWorkflowConstants.STATE_MIMO_BICDS;
            default:
                _log.warn("Unknown state " + stateXid);
                return defaultStateTitle;
        }
    }

    private static String _getString(Map<String, Object> row) {
        return _getStringColumn(row, "string_value");
    }

    private static String _getStringColumn(Map<String, Object> row, String colName) {
        return String.valueOf(row.get(colName));
    }

    private static int _getType(String typeXid) {
        switch (typeXid) {
            case "[xf3:ae0f348c-c7b9-4a9a-b4b2-e3caaa549278]":
                return CdsDemandType.TYPE_US;
            case "[xf3:4c2b0fb2-b29a-490f-a568-d6606daeb42e]":
                return CdsDemandType.TYPE_BS;
            default:
                return 0;
        }
    }

    private static Map<String, Object> _getUserMap(Map<String, Object> row) {
        return _getUserMap(row, "clob_value");
    }

    private static Map<String, Object> _getUserMap(Map<String, Object> row, String srcColName) {
        String uxid = _getStringColumn(row, srcColName);
        if (!_userMap.containsKey(uxid)) {
            _log.debug("Unable to determine user for " + uxid + "row=" + row);
            return null;
        }

        User u;
        Map<String, Object> rec = _userMap.get(uxid);
        if (rec.containsKey("user")) {
            u = (User) rec.get("user");
        } else {
            try {
                u = UserLocalServiceUtil.getUserByScreenName(_companyId, (String) rec.get("login"));
                if (Validator.isNotNull(u)) rec.put("user", u);
            } catch (PortalException e) {
            }
        }
        return rec;
    }

    private static void _setAcceptedDt(CdsDemand entry, Map<String, Object> row) {
        entry.setAcceptedDelivery(_getDate(row));
    }

    private static void _setBan(CdsDemand entry, Map<String, Object> row) {
        Map<String, Object> rec = _getUserMap(row);
        if (rec == null) return;
        User u = (User) rec.getOrDefault("user", null);
        if (Validator.isNotNull(u)) {
            entry.setBanId(u.getPrimaryKey());
            entry.setBanName(CdsDemandLocalServiceUtil.getFormattedUserName(u));
        } else {
            entry.setBanId(0);
            entry.setBanName((String) rec.get("name"));
        }

    }

    private static void _setBioeId(CdsDemand entry, Map<String, Object> row) {
        entry.setBioeId(_getString(row));
    }

    private static void _setBioeStateId(CdsDemand entry, Map<String, Object> row) {
        entry.setBioeStateId(Short.valueOf(_getString(row)));
    }

    private static void _setBioeStateName(CdsDemand entry, Map<String, Object> row) {
        entry.setBioeStateName(_getString(row));
    }

    private static void _setContactPerson(CdsDemand entry, Map<String, Object> row) {
        Map<String, Object> rec = _getUserMap(row);
        if (rec == null) return;
        User u = (User) rec.getOrDefault("user", null);
        if (Validator.isNotNull(u)) {
            entry.setContactId(u.getPrimaryKey());
            entry.setContactName(CdsDemandLocalServiceUtil.getFormattedUserName(u));
        } else {
            entry.setContactId(0);
            entry.setContactName((String) rec.get("name"));
        }
    }

    private static void _setDPMFolderGestor(CdsDemand entry, Map<String, Object> row) {
        Map<String, Object> rec = _getUserMap(row);
        if (rec == null) return;
        User u = (User) rec.getOrDefault("user", null);
        if (Validator.isNotNull(u)) {
            entry.setUsGestorFolderDPMId(u.getPrimaryKey());
            entry.setUsGestorFolderDPMName(CdsDemandLocalServiceUtil.getFormattedUserName(u));
        } else {
            entry.setUsGestorFolderDPMId(0);
            entry.setUsGestorFolderDPMName((String) rec.get("name"));
        }
    }

    private static void _setDescription(CdsDemand entry, Map<String, Object> row) {
        String description = String.valueOf(row.get("clob_value"));
        entry.setDescription(description);
    }

    private static void _setDomain(CdsDemand entry, Map<String, Object> row) {
        String domainName = _getString(row);
        entry.setDomainName(domainName);
        int end = domainName.indexOf(' ');
        if (end > 0) {
            domainName = domainName.substring(0, end);
            try {
                long domainId = Long.valueOf(domainName);
                entry.setDomainId(domainId);
            } catch (NumberFormatException e) {
            }
        }
    }

    private static void _setExpectedDeliveryDt(CdsDemand entry, Map<String, Object> row) {
        entry.setExpectedDelivery(_getDate(row));
    }

    private static void _setExpectedWorkHours(CdsDemand entry, Map<String, Object> row) {
        entry.setWorkEstimate(Double.valueOf(_getString(row)));
    }

    private static void _setFiveTracks(CdsDemand entry, Map<String, Object> row) {
        String val = _getClob(row);
        List<Long> ft = new LinkedList<>();
        _fiveTracks.forEach((s, i) -> {
            if (val.contains(s)) {
                ft.add((long) i);
            }
        });
        long[] arr = new long[ft.size()];
        for (int i = 0; i < ft.size(); i++) {
            arr[i] = ft.get(i);
        }
        entry.setFiveTracks(arr);
    }

    private static void _setFrequency(CdsDemand entry, Map<String, Object> row) {
        String val = String.valueOf(row.getOrDefault("clob_value", ""));
        entry.setUsFrequencyOut(_getFrequency(val));
    }

    private static void _setIsGdpr(CdsDemand entry, Map<String, Object> row) {
        entry.setIsGDPR(_getBoolean(row));
    }

    private static void _setOutOfCdsScope(CdsDemand cdsDemand, Map<String, Object> row) {
        int i = _getInt(row);
        if (i > 0) {
            cdsDemand.setType(CdsDemandType.TYPE_OUT);
        }
    }

    private static void _setPriority(CdsDemand entry, Map<String, Object> row) {
        String val = String.valueOf(row.getOrDefault("clob_value", ""));
        entry.setPriority(_getPriority(val));
    }

    private static void _setRequestedDelivery(CdsDemand entry, Map<String, Object> row) {
        entry.setRequestedDelivery(_getDate(row));
    }

    private static void _setRequestedFor(CdsDemand entry, Map<String, Object> row) {
        Map<String, Object> rec = _getUserMap(row);
        if (rec == null) return;
        User u = (User) rec.getOrDefault("user", null);
        if (Validator.isNotNull(u)) {
            entry.setRequestedForId(u.getPrimaryKey());
            entry.setRequestedForName(CdsDemandLocalServiceUtil.getFormattedUserName(u));
        } else {
            entry.setRequestedForId(0);
            entry.setRequestedForName((String) rec.get("name"));
        }
    }

    private static void _setRequestor(CdsDemand entry, Map<String, Object> row) {
        Map<String, Object> rec = _getUserMap(row);
        if (rec == null) return;
        User u = (User) rec.getOrDefault("user", null);
        if (Validator.isNotNull(u)) {
            entry.setRequestorId(u.getPrimaryKey());
            entry.setRequestorName(CdsDemandLocalServiceUtil.getFormattedUserName(u));
        } else {
            entry.setRequestorId(0);
            entry.setRequestorName((String) rec.get("name"));
        }
    }

    private static void _setSpoc(CdsDemand entry, Map<String, Object> row) {
        Map<String, Object> rec = _getUserMap(row);
        if (rec == null) return;
        User u = (User) rec.getOrDefault("user", null);
        if (Validator.isNotNull(u)) {
            entry.setSpocId(u.getPrimaryKey());
            entry.setSpocName(CdsDemandLocalServiceUtil.getFormattedUserName(u));
        } else {
            entry.setSpocId(0);
            entry.setSpocName((String) rec.get("name"));
        }
    }

    private static void _setType(CdsDemand entry, Map<String, Object> row) {
        String val = String.valueOf(row.getOrDefault("clob_value", ""));
        entry.setType(_getType(val));
    }

    private static void _setUsAccessDPM(CdsDemand entry, Map<String, Object> row) {
        entry.setUsAccessDPM(_getBoolean(row));

    }

    private static void _setUsCreateFolderDPM(CdsDemand entry, Map<String, Object> row) {
        entry.setUsCreateFolderDPM(_getBoolean(row));
    }

    private static void _setUsDPMNotifikaceEmail(CdsDemand entry, Map<String, Object> row) {
        entry.setUsDPMNotificationMail(_getString(row));
    }

    private static void _setUsFolderDPM(CdsDemand entry, Map<String, Object> row) {
        entry.setUsFolderDPM(_getString(row));
    }

    private static void _setUsReasoning(CdsDemand entry, Map<String, Object> row) {
        entry.setUsReasoning(_getString(row));
    }

    public Map<String, Object> importDemands(boolean reimport, long limit, ServiceContext serviceContext)
            throws PortalException {
        _companyId = serviceContext.getCompanyId();
        loadSemantaUsersMap();
        //   importExUsers(serviceContext);

        String sql = "SELECT \n" +
                "\te.[entry_xid]as xid\n" +
                "\t,e.[entry_version] as version\n" +
                "\t,e.[app_xid]\n" +
                "\t,e.[entry_name] as title\n" +
                "\t,e.[entry_valid_from] as created_date\n" +
                "\t,e.[entry_modification_author] as created_user\n" +
                "\t,s.workflow_state_id as state_xid\n" +
                "\t,se.entry_name as state_title\n" +
                " FROM [Ency].[dbo].[entry] as e\n" +
                " LEFT JOIN [Ency].[dbo].[entry_state] as s  ON e.entry_xid=s.entry_xid AND e.entry_version>=s.entry_version_first AND e.entry_version<=s.entry_version_last\n" +
                " LEFT JOIN [Ency].[dbo].[entry] as se ON s.workflow_state_id=se.entry_xid AND se.parent_entry_xid is not null\n" +
                " WHERE e.app_xid='csob_demand'\n" +
                (limit > 0 ? " AND e.entry_xid in (SELECT DISTINCT TOP " + limit + " entry_xid FROM [Ency].[dbo].[entry] WHERE  app_xid='csob_demand' order by entry_xid asc)\n" : "") +
                " order by e.entry_xid, e.entry_version asc ";

        _log.debug("Running import.");
        List<Map<String, Object>> results;
        try {
            results = SqlUtils.executeSelect(CONN_NAME, sql);
        } catch (Exception e) {
            _log.error(e.getMessage());
            return HashMapBuilder.<String, Object>put("error", e.getMessage()).build();
        }
        _log.info("SQL returned " + results.size() + " results.");

        String prevXid = StringPool.BLANK;
        String skipXid = StringPool.BLANK;
        String prevState = StringPool.BLANK;
        long stateAuthor = 0;
        String stateAuthorName = StringPool.BLANK;


        CdsDemand e = null;
        long i = 0;
        long ii = 0;

        for (Map<String, Object> row : results) {
            try {
                _log.debug("Processing row " + row);
                int version = Integer.parseInt(String.valueOf(row.get("version")));
                String xid = String.valueOf(row.get("xid"));
                _log.info("Processing row " + (++i) + ". Entry:" + xid + " version " + version);
                if (Validator.isBlank(xid)) {
                    _log.warn("xid is blank in row " + row);
                }

                if (skipXid.equals(xid)) {
                    continue;
                } else {
                    skipXid = "";
                }

                Date date = new Date(Long.parseLong(String.valueOf(row.get("created_date"))));

                if (!prevXid.equals(xid)) {
                    ii++;
                    e = cdsDemandLocalService.fetchCdsDemand(xid);
                    if (!Validator.isNull(e)) {
                        if (reimport) {
                            _log.warn("Entry with xid " + xid + " already exists and will be reimported!");
                            cdsDemandLocalService.deleteEntryFull(e);
                        } else {
                            skipXid = xid;
                            _log.warn("Entry with xid " + xid + " already exists. Skipping");
                            continue;
                        }
                    }
                    e = cdsDemandLocalService.getInitializedCdsDemand(Validator.isNull(e) ? 0 : e.getDemandId(), serviceContext);
                    e.setCreateDate(date);

                    prevState = StringPool.BLANK;
                    stateAuthor = -1;
                    stateAuthorName = StringPool.BLANK;
                }

                if (e == null) {
                    _log.error("Entry not initialized!!!");
                    continue;
                }

                e.setUuid(xid);
                e.setTitle(String.valueOf(row.get("title")));
                e.setModifiedDate(date);

                String author = String.valueOf(row.get("created_user"));
                User authorUser = userLocalService.fetchUserByScreenName(serviceContext.getScopeGroupId(), author);

                if (Validator.isNotNull(authorUser)) {
                    e.setUserId(authorUser.getUserId());
                    e.setUserName(cdsDemandLocalService.getFormattedUserName(authorUser));
                } else {
                    e.setUserId(0);
                    e.setUserName(author);
                }
                e.setUrlTitle(xid);

                String state = _getState(
                        String.valueOf(row.getOrDefault("state_xid", "")),
                        String.valueOf(row.getOrDefault("state_title", "")));

                e.setState(state);

                if (CdsDemandWorkflowConstants.STATE_MIMO_BICDS.equals(state)) {
                    e.setType(CdsDemandType.TYPE_OUT);
                }

                if (!prevState.equals(state)) {
                    stateAuthor = e.getUserId();
                    stateAuthorName = e.getUserName();
                    prevState = state;
                }
                e.setStateByUserId(stateAuthor);
                e.setStateByUserName(stateAuthorName);

                importAttributes(e, xid, version);

                _log.debug("adding: " + e);
                e = cdsDemandLocalService.importEntry(e, serviceContext);

                if (!prevXid.equals(xid)) {
                    importComments(e, serviceContext);
                    importWorkflow(e, serviceContext);
                    importAttachments(e, serviceContext);
                }

                prevXid = xid;
            } catch (Exception ex) {
                _log.error(ex);
                //@todo, comment throw after implementing class. This is here only to prevent multiple errors while debugging
                throw ex;
            }
        }
        _log.info("Import end. Imported " + ii + " demands");
        return Collections.EMPTY_MAP;
    }

    public boolean importExUsers(ServiceContext serviceContext) {

        String sql = "SELECT e.[entry_xid]\n" +
                "      ,[entry_name]\n" +
                "\t  ,a.[string_value] as login\n" +
                "  FROM [Ency].[dbo].[entry] as e\n" +
                "  LEFT JOIN  [Ency].[dbo].[attribute] as a \n" +
                "\ton e.entry_xid=a.entry_xid and e.entry_version=a.entry_version and a.attr_key='login'\n" +
                "  WHERE parent_entry_xid='b24b1222-9a76-4525-bb8f-e276f6bbef28' \n" +
                "  and e.app_xid='person' and a.string_value is not null";

        _log.info("Running import of exusers.");
        List<Map<String, Object>> results;
        try {
            results = SqlUtils.executeSelect(CONN_NAME, sql);
        } catch (Exception e) {
            _log.error(e.getMessage());
            return false;
        }
        _log.debug("SQL returned " + results.size() + " results.");

        List<User> addedUsers = new ArrayList<>();

        for (Map<String, Object> row : results) {
            try {
                _log.warn("Importing row " + row);
                String userName = String.valueOf(row.get("entry_name"));
                String xid = String.valueOf(row.get("entry_xid"));
                String login = String.valueOf(row.get("login"));

                Pattern pattern =
                        Pattern.compile(
                                "(\\S+)\\s([^\\(]+)\\s\\(([^\\)]+)\\)", Pattern.CASE_INSENSITIVE);


                Matcher matcher = pattern.matcher(userName);
                String jmeno = "jmeno";
                String prijmeni = userName;
                if (matcher.find()) {
                    jmeno = matcher.group(2);
                    prijmeni = matcher.group(1);
                }

                User u =
                        userLocalService.fetchUserByScreenName(
                                serviceContext.getCompanyId(), login);

                if (Validator.isNotNull(u)) {
                    userLocalService.updateStatus(u.getUserId(), WorkflowConstants.STATUS_INACTIVE, serviceContext);
                    continue;
                }

                // long uid =  CounterLocalServiceUtil.increment(User.class.getName())
                u = userLocalService.addOrUpdateUser(
                        xid, /*creatorUserId*/serviceContext.getGuestOrUserId(),
                        serviceContext.getCompanyId(),        /*autoPassword*/false,
                        /*password1*/ xid, /*password2*/xid,    /*autoScreenName*/ false,
                        /*screenName*/ login, /*emailAddress*/login + "@csob.cz",
                        serviceContext.getLocale(), /*firstName*/jmeno, /*middleName*/ "",
                        /*lastName*/ prijmeni, /*prefixId*/ 0, /*suffixId*/0,
                        /*male*/ true, /*birthdayMonth*/1, /*birthdayDay*/1,
                        /*birthdayYear*/1990, /*jobTitle*/"",/*sendEmail*/ false,
                        serviceContext);
                userLocalService.updateStatus(u.getUserId(), WorkflowConstants.STATUS_INACTIVE, serviceContext);
                addedUsers.add(u);


            } catch (Exception e) {
                _log.error(e);
            }

        }

        try {
            UserGroup ug =
                    UserGroupLocalServiceUtil.fetchUserGroup(
                            serviceContext.getCompanyId(), "Semanta ExUsers");

            if (Validator.isNull(ug)) {
                ug = UserGroupLocalServiceUtil.addUserGroup(
                        serviceContext.getGuestOrUserId(), serviceContext.getCompanyId(),
                        "Semanta ExUsers", "Skupina s uzivateli, ktery jiz nejsou v LDAP ale maji " +
                                "vztahy na Ecny", serviceContext);
            }

            _log.debug("Group found:" + ug);

            userLocalService.addUserGroupUsers(ug.getUserGroupId(), addedUsers);
        } catch (Exception e) {
            _log.error(e);
        }

        _log.info("Finished import of exusers.");

        return true;
    }

    public boolean testImportAttachments(ServiceContext serviceContext) {
        CdsDemand cdsDemand = cdsDemandLocalService.fetchCdsDemand(12301);
        return importAttachments(cdsDemand, serviceContext);
    }

    private String _getTransition(String transitionXid) {
        switch (transitionXid) {
            case "01c41766-1a17-4ebd-84ae-2b461b22a950":
                return CdsDemandWorkflowConstants.TRANSITION_REVIZE_DODAVKY_DO_AKCEPTACE;
            case "07240169-c1b6-4852-a4a6-e52cf3aba37d":
                return CdsDemandWorkflowConstants.TRANSITION_NACENENO_SCHVALIT;
            case "08699ea1-836a-47b3-93ff-3119a66b7112":
                return CdsDemandWorkflowConstants.TRANSITION_AKCEPTACE_SCHVALIT;
            case "0b189519-da4c-488e-9b8e-e5d40a8d9aad":
                return CdsDemandWorkflowConstants.TRANSITION_NACENOVANO_ADM_DO_REVIZE;
            case "0efa0222-22f9-4c6f-ba54-55838addbb5e":
                return CdsDemandWorkflowConstants.TRANSITION_NACENOVANO_SYNC_ZRUSENO;
            case "19840ed5-b671-4529-9b0d-5ff05e228209":
                return CdsDemandWorkflowConstants.TRANSITION_POZASTAVENO_SPOC_OBNOVIT;
            case "1b183713-1175-4972-b71d-522b798bf3db":
                return CdsDemandWorkflowConstants.TRANSITION_REVIZE_BAN_SCHVALIT;
            case "2512ee8e-00fa-4287-92a4-bea632039eee":
                return CdsDemandWorkflowConstants.TRANSITION_REVIZE_SPOC_POZASTAVIT;
            case "2565ff14-8ad1-44df-8433-f5de438f8015":
                return CdsDemandWorkflowConstants.TRANSITION_AKCEPTACE_SYNC_ZRUSENO;
            case "2c4b80da-4cea-4aaa-a1c2-5a8902ae8add":
                return CdsDemandWorkflowConstants.TRANSITION_NAVRH_ZRUSIT;
            case "3e4205aa-9df9-4ae6-94bd-6d4d79bd41e6":
                return CdsDemandWorkflowConstants.TRANSITION_REALIZACE_SYNC_ZRUSENO;
            case "4133053a-d219-4c90-bf4c-fd2a897ba751":
                return CdsDemandWorkflowConstants.TRANSITION_REALIZACE_DO_AKCEPTACE;
            case "4ecb9efa-633d-4f46-99e9-e6ea8f81d9d6":
                return CdsDemandWorkflowConstants.TRANSITION_REVIZE_SPOC_ZRUSIT;
            case "539956ef-39a1-4715-93a1-cf52219d4fe1":
                return CdsDemandWorkflowConstants.TRANSITION_REVIZE_DODAVKY_DO_REALIZACE;
            case "6570ef16-16c3-4db6-a9bc-03e4ef89cf02":
                return CdsDemandWorkflowConstants.TRANSITION_REVIZE_SPOC_SCHVALIT;
            case "694cd78f-bd7d-4060-8f75-a4a8b13d3b2d":
                return CdsDemandWorkflowConstants.TRANSITION_AKCEPTACE_ODMITNOUT;
            case "726d5b24-82e9-40f6-9419-54a4fb27962c":
                return CdsDemandWorkflowConstants.TRANSITION_NACENOVANO_SYNC_ZRUSENO;
            case "7e90dd70-db09-4cf2-8629-20fb9f5b04e2":
                return CdsDemandWorkflowConstants.TRANSITION_REVIZE_BAN_SCHVALITUS;
            case "96de42da-b9a8-4ea5-90c0-fcbb2fbbdc1f":
                return CdsDemandWorkflowConstants.TRANSITION_NACENOVANO_NACENENO_US;
            case "972bf3a2-9a2a-42f5-8cfe-cc8c1f9ffa24":
                return CdsDemandWorkflowConstants.TRANSITION_REALIZACE_SYNC_DO_AKCEPTACE;
            case "9a62793e-8d11-4912-bdf0-e69cc67452f6":
                return CdsDemandWorkflowConstants.TRANSITION_NACENOVANO_NACENENO;
            case "a2be082b-4965-43a5-88fe-0274ff8ee19d":
                return CdsDemandWorkflowConstants.TRANSITION_REVIZE_BAN_POZASTAVIT;
            case "b1739885-9583-4c75-9da0-f2f72dd575ff":
                return CdsDemandWorkflowConstants.TRANSITION_NAVRH_KE_SCHVALENI;
            case "ba8039be-d8b3-4b4a-a076-23869fc02ed0":
                return CdsDemandWorkflowConstants.TRANSITION_NACENENO_ODMITNOUT;
            case "eaf622eb-3f56-4897-af26-2b2a17e9f62e":
                return CdsDemandWorkflowConstants.TRANSITION_POZASTAVENO_BAN_OBNOVIT;
            case "ebe89ec4-2df2-4dbb-a019-f4e5b034f371":
                return CdsDemandWorkflowConstants.TRANSITION_REVIZE_BAN_ZAMITNOUT;
            case "ec3b478e-9dfc-40fc-ab94-749dcf834875":
                return CdsDemandWorkflowConstants.TRANSITION_REVIZE_SPOC_MIMO_CDS;
            case "a5ea006b-55da-4f91-abd8-8736b5ba06d6":
                return CdsDemandWorkflowConstants.TRANSITION_REVIZE_BAN_VRATIT;
            case "b05532d5-bf31-460c-9fe1-92a21dccf770":
                return CdsDemandWorkflowConstants.TRANSITION_REVIZE_SPOC_VRATIT;
            case "83c6ccfc-9ce8-4347-9cdb-3711f3f47c8b":
                //TMP Vratit do Realizace	Zrušeno
                return null;
            case "e34154f5-c0f1-46f3-a33a-47f2a635bd49":
                //TMP k SPOCovi	K řešení mimo BI CDS
                return null;
        }
        return null;
    }

    private boolean importAttachments(CdsDemand entry, ServiceContext serviceContext) {
        String sql = "SELECT [entry_xid]\n" +
                "      ,[attachment_xid]\n" +
                "      ,[attachment_name]\n" +
                "      ,[attachment_upload_user]\n" +
                "      ,[attachment_size]\n" +
                "      ,[attachment_body]\n" +
                "  FROM [Ency].[dbo].[attachment]\n" +
                "  where attachment_current=1\n" +
                //"  and attachment_xid='004a15cb-6c7e-4143-9c97-a41a925275ce'";
                "  and entry_xid=?";

        _log.debug("Running import attachments.");
        List<Map<String, Object>> results;
        try {
            results = SqlUtils.executeSelect(CONN_NAME, sql, entry.getUuid());
        } catch (Exception e) {
            _log.error(e.getMessage());
            return false;
        }
        _log.debug("SQL returned " + results.size() + " results.");

        for (Map<String, Object> row : results) {
            try {
                String fileName = String.valueOf(row.get("attachment_name"));

                // long groupId = serviceContext.getScopeGroupId();
                long groupId = entry.getGroupId();
                //long entryId = 12301;
                long entryId = entry.getPrimaryKey();

                long defaultUserId =
                        UserLocalServiceUtil.getDefaultUserId(serviceContext.getCompanyId());
                long userId = serviceContext.getGuestOrUserId();

                Folder folder =
                        cdsDemandLocalService.getAttachmentsFolder(defaultUserId, groupId, entryId);

                File file = FileUtil.createTempFile((byte[]) row.get("attachment_body"));

                PortletFileRepositoryUtil.deletePortletFileEntries(groupId, folder.getFolderId());

                String uniqueFileName = PortletFileRepositoryUtil.getUniqueFileName(
                        groupId, folder.getFolderId(), fileName);

                PortletFileRepositoryUtil.addPortletFileEntry(
                        groupId, userId, CdsDemand.class.getName(), 0,
                        CdsDemandConstants.SERVICE_NAME, folder.getFolderId(), file, uniqueFileName,
                        MimeTypesUtil.getContentType(file, fileName), false);

                file.delete();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        _log.debug("Finished import attachments.");

        return true;
    }

    private void importAttributes(CdsDemand entry, String xid, long version) {
        String sql = "SELECT TOP (1000) [app_xid]\n" +
                "\t,[attr_key]\n" +
                "\t,[entry_xid]\n" +
                "\t,[entry_version]\n" +
                "\t,[date_value]\n" +
                "\t,[int_value]\n" +
                "\t,[string_value]\n" +
                "\t,[clob_value]\n" +
                "\t,[blob_value]\n" +
                "FROM [Ency].[dbo].[attribute]\n" +
                "WHERE app_xid='csob_demand'\n" +
                "\tand entry_xid=?\n" +
                "\tand entry_version=?";
        List<Map<String, Object>> results;
        try {
            results = SqlUtils.executeSelect(CONN_NAME, sql, xid, version);
        } catch (Exception e) {
            _log.error(e.getMessage());
            return;
        }

        for (Map<String, Object> row : results) {
            try {
                String fld = String.valueOf(row.getOrDefault("attr_key", "-"));

                if (_attributeSetterBiConsumers.containsKey(fld)) {
                    _attributeSetterBiConsumers.get(fld).accept(entry, row);
                } else {
                    _log.warn("Field " + fld + " does not have appropriate setter");
                }

            } catch (Exception ex) {
                _log.error(ex);
                return;
            }
        }
    }

    private void importComments(CdsDemand entry, ServiceContext serviceContext) {
        String sql = "SELECT \n" +
                "      '[xf3:'+[comment_author_xid]+']' as clob_value \n" +
                "      ,[comment_author_name]\n" +
                "      ,[comment_creation_date] as date_value\n" +
                "      ,[comment_text] as body\n" +
                "  FROM [Ency].[dbo].[komment] as c\n" +
                "  join [Ency].[dbo].[comment_thread] as t on c.thread_xid=t.thread_xid and entry_xid=?\n" +
                "  WHERE comment_text is not null and LEN(comment_text)>0\n" +
                "order by comment_creation_date asc";
        try {
            CommentManagerUtil.deleteDiscussion(
                    entry.getModelClassName(),
                    entry.getPrimaryKey()
            );

            CommentManagerUtil.addDiscussion(
                    serviceContext.getUserId(),
                    serviceContext.getScopeGroupId(),
                    entry.getModelClassName(),
                    entry.getPrimaryKey(),
                    "system"
            );


        } catch (PortalException e) {
            _log.error(e);
        }

        List<Map<String, Object>> results;
        try {
            results = SqlUtils.executeSelect(CONN_NAME, sql, entry.getUuid());
        } catch (Exception e) {
            _log.error(e.getMessage());
            return;
        }

        String prevBody = StringPool.BLANK;
        for (Map<String, Object> row : results) {
            try {
                String body = (String) row.get("body");
                if (body.equals(prevBody)) continue;

                Map<String, Object> usrMap = _getUserMap(row);
                User u = usrMap == null ? null : (User) usrMap.get("user");
                long defaultUId =
                        userLocalService.getDefaultUserId(serviceContext.getCompanyId());
                CommentManagerUtil.addComment(
                        u == null ? defaultUId : u.getUserId(),
                        serviceContext.getScopeGroupId(),
                        entry.getModelClassName(),
                        entry.getPrimaryKey(),
                        u == null ? (String) row.get("comment_author_name") : cdsDemandLocalService.getFormattedUserName(u),
                        "",
                        HtmlUtil.stripHtml(body),
                        new IdentityServiceContextFunction(serviceContext)
                );

                prevBody = body;
            } catch (Exception ex) {
                _log.error(ex);
                return;
            }
        }
    }

    private void importWorkflow(CdsDemand entry, ServiceContext serviceContext) throws PortalException {
        String sql = "SELECT  \n" +
                "      [transition_type]\n" +
                "      ,ss.workflow_state_id as [source_state_id]\n" +
                "      ,ts.workflow_state_id as [target_state_id]\n" +
                "      ,[transition_time]\n" +
                "      ,[transition_executor_xid] as executor_xid\n" +
                "      ,[transition_executor_name] as executor_name\n" +
                "      ,e.entry_name as transition_name\n" +
                "  FROM [Ency].[dbo].[workflow_transition] as t\n" +
                "  left join [Ency].[dbo].[entry] as e\n" +
                "    on e.entry_xid=t.transition_type \n" +
                "       and e.entry_current=1\n" +
                "  left join [Ency].[dbo].[entry_state] as ss\n" +
                "    on ss.entry_state_id=t.source_state_id\n" +
                "  left join [Ency].[dbo].[entry_state] as ts\n" +
                "    on ts.entry_state_id=t.target_state_id" +
                "  where  t.entry_xid=?\n" +
                "  order by transition_time asc";

        List<Map<String, Object>> results;
        try {
            results = SqlUtils.executeSelect(CONN_NAME, sql, entry.getUuid());
        } catch (Exception e) {
            _log.error(e.getMessage());
            return;
        }

        boolean first = true;
        long defaultUId =
                userLocalService.getDefaultUserId(serviceContext.getCompanyId());

        EncyWorkflowInstance ewi = null;
        workflowManager.startWorkflowInstance(
                serviceContext.getCompanyId(),
                serviceContext.getScopeGroupId(),
                entry.getUserId() == 0 ? defaultUId : entry.getUserId(),
                entry.getModelClassName(),
                entry.getPrimaryKey(),
                entry,
                serviceContext,
                Collections.EMPTY_MAP
        );

        // fix initial instance dates and user
        EncyWorkflowStateInstance instance =
                workflowManager.getWorkflowStateInstance(
                        serviceContext.getCompanyId(),
                        serviceContext.getScopeGroupId(),
                        entry
                );
        instance.setCreateDate(entry.getCreateDate());
        instance.setModifiedDate(entry.getModifiedDate());
        instance.setUserName(entry.getUserName());
        instance.setUserId(entry.getUserId());

        ewi = workflowInstanceLocalService.getWorkflowInstance(
                entry.getModelClassName(), entry.getPrimaryKey()
        );

        for (Map<String, Object> row : results) {
            try {
                // Close previous state
                Map<String, Object> usrMap = _getUserMap(row, "executor_xid");
                User u = usrMap == null ? null : (User) usrMap.get("user");
                long userId = u == null ? defaultUId : u.getUserId();

                Date td = new Date(Long.parseLong(String.valueOf(row.get("transition_time"))));
                Map<String, Serializable> workflowContext =
                        WorkflowContextBuilder
                                .fromServiceContext(serviceContext)
                                .putUserId(userId)
                                .putWorkflowId(ewi.getWorkflowId())
                                .putClassPk(entry.getPrimaryKey())
                                .putClassName(entry.getModelClassName())
                                .build();

                instance.setModifiedDate(td);
                instance.setCompletedDate(td);
                stateInstanceLocalService.updateEncyWorkflowStateInstance(instance);

                String stateName = _getState((String) row.get("target_state_id"), "---");
                EncyWorkflowState ews = stateLocalService.getEncyWorkflowState(ewi.getWorkflowId(), stateName);

                // Prepare transition
                EncyWorkflowTransitionInstance transition = transitionInstanceLocalService.create();
                transition.setStateId(instance.getStateId());
                transition.setStateInstanceId(instance.getStateInstanceId());


                // create target state
                instance = stateInstanceLocalService.create();
                instance.setWorkflowId(ewi.getWorkflowId());
                instance.setWorkflowInstanceId(ewi.getWorkflowInstanceId());
                instance.setStateId(ews.getStateId());
                instance.setCompanyId(serviceContext.getCompanyId());
                instance.setGroupId(serviceContext.getScopeGroupId());
                instance.setUserId(userId);
                instance.setUserName(
                        u == null ?
                                (String) row.get("executor_name") :
                                cdsDemandLocalService.getFormattedUserName(u));
                instance.setCreateDate(td);
                instance.setVersion(ewi.getWorkflowVersion());
                instance.setWorkflowContext(workflowContext);

                transition.setTargetStateInstanceId(instance.getStateId());
                transition.setTargetStateId(ews.getStateId());
                transition.setWorkflowId(ewi.getWorkflowInstanceId());
                transition.setWorkflowInstanceId(ewi.getWorkflowInstanceId());
                transition.setVersion(ewi.getWorkflowVersion());
                transition.setCompanyId(serviceContext.getCompanyId());
                transition.setGroupId(serviceContext.getScopeGroupId());
                transition.setCreateDate(td);
                transition.setUserId(instance.getUserId());
                transition.setUserName(instance.getUserName());
                transition.setWorkflowContext(workflowContext);
                String transitionName = _getTransition((String) row.get("transition_type"));
                if (Validator.isNotNull(transitionName)) {
                    EncyWorkflowTransition tr =
                            transitionLocalService.fetchEncyWorkflowTransition(
                                    transition.getStateId(), transitionName
                            );
                    if (Validator.isNotNull(tr)) {
                        transition.setTransitionId(tr.getTransitionId());
                        transitionInstanceLocalService.updateEncyWorkflowTransitionInstance(transition);
                    } else {
                        _log.warn("There is no transition for " + transitionName +
                                " and state" + instance.getWorkflowState().getName());
                    }
                }


            } catch (Exception ex) {
                _log.error(ex);
                return;
            }
        }
        stateInstanceLocalService.updateEncyWorkflowStateInstance(instance);
    }

    private void loadSemantaUsersMap() {
        _userMap = new HashMap<>();
        String sql = "SELECT " +
                "   e.[entry_xid]\n" +
                "   ,[entry_name] as name\n" +
                "   ,'[xf3:'+e.entry_xid+']' as targets\n" +
                "   ,a.string_value as login\n" +
                "FROM [Ency].[dbo].[entry] as e\n" +
                "JOIN [Ency].[dbo].attribute as a \n" +
                "   on e.entry_xid=a.entry_xid \n" +
                "   and e.entry_version=a.entry_version \n" +
                "   and a.attr_key='login'\n" +
                "where\n" +
                "   e.app_xid='person'\n" +
                "   and entry_current=1";

        List<Map<String, Object>> results;
        try {
            results = SqlUtils.executeSelect(CONN_NAME, sql);
        } catch (Exception e) {
            _log.error(e.getMessage());
            return;
        }

        for (Map<String, Object> row : results) {
            try {
                _userMap.put(
                        (String) row.getOrDefault("targets", "*-*-*"),
                        HashMapBuilder
                                .<String, Object>put("login", row.get("login"))
                                .put("name", row.get("name"))
                                .build()
                );

            } catch (Exception ex) {
                _log.error(ex);
            }
        }

    }

    static {
        Map<String, BiConsumer<CdsDemand, ?>> attributeSetterBiConsumers =
                new LinkedHashMap<String, BiConsumer<CdsDemand, ?>>();

        attributeSetterBiConsumers.put(
                "description", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setDescription);

        attributeSetterBiConsumers.put(
                "demandcategory", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setType);

        attributeSetterBiConsumers.put(
                "priority", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setPriority);

        attributeSetterBiConsumers.put(
                "frequencyOut", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setFrequency);

        attributeSetterBiConsumers.put(
                "b0domena", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setDomain);

        attributeSetterBiConsumers.put(
                "bioeID", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setBioeId);

        attributeSetterBiConsumers.put(
                "reasoning", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setUsReasoning);

        attributeSetterBiConsumers.put(
                "bioeexpected_end_of", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setExpectedDeliveryDt);

        attributeSetterBiConsumers.put(
                "accepted_bioeexpected_end_of", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setAcceptedDt);

        attributeSetterBiConsumers.put(
                "deliverydate", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setRequestedDelivery);

        attributeSetterBiConsumers.put(
                "bioeregistration_date", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_dummy);

        attributeSetterBiConsumers.put(
                "bioedepartment", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_dummy);
        attributeSetterBiConsumers.put(
                "bioestatusid", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setBioeStateId);
        attributeSetterBiConsumers.put(
                "bioestatus", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setBioeStateName);
        attributeSetterBiConsumers.put(
                "emailnotifikace", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setUsDPMNotifikaceEmail);
        attributeSetterBiConsumers.put(
                "bioedomain", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_dummy);
        attributeSetterBiConsumers.put(
                "bioework_end", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_dummy);
        attributeSetterBiConsumers.put(
                "bioework_start", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_dummy);
        attributeSetterBiConsumers.put(
                "createFolderDPM", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setUsCreateFolderDPM);
        attributeSetterBiConsumers.put(
                "bioeworkhours", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setExpectedWorkHours);
        attributeSetterBiConsumers.put(
                "gdprContainsPersonal", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setIsGdpr);
        attributeSetterBiConsumers.put(
                "accessDPM", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setUsAccessDPM);
        attributeSetterBiConsumers.put(
                "folderDPM", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setUsFolderDPM);
        attributeSetterBiConsumers.put(
                "fivetracks", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setFiveTracks);
        attributeSetterBiConsumers.put(
                "requestor", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setRequestor);
        attributeSetterBiConsumers.put(
                "contactPerson", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setContactPerson);
        attributeSetterBiConsumers.put(
                "requestedFor", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setRequestedFor);
        attributeSetterBiConsumers.put(
                "ban_user", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setBan);
        attributeSetterBiConsumers.put(
                "spoc_user", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setSpoc);
        attributeSetterBiConsumers.put(
                "gestorFolderDPM", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setDPMFolderGestor);
        attributeSetterBiConsumers.put(
                "requestorID", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_dummy);
        attributeSetterBiConsumers.put(
                "entryAttachments", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_dummy);
        attributeSetterBiConsumers.put(
                "requestorDepartment", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_dummy);
        attributeSetterBiConsumers.put(
                "outOfCdsScope", (BiConsumer<CdsDemand, Map<String, Object>>) ImportDemands::_setOutOfCdsScope);


        _attributeSetterBiConsumers = Collections.unmodifiableMap(
                (Map) attributeSetterBiConsumers);

        _fiveTracks = HashMapBuilder
                .put("[xf3:cdsdemands-ciselnik-fivetracks--0]", 0)
                .put("[xf3:cdsdemands-ciselnik-fivetracks--1]", 1)
                .put("[xf3:cdsdemands-ciselnik-fivetracks--2]", 2)
                .put("[xf3:cdsdemands-ciselnik-fivetracks--3]", 3)
                .put("[xf3:cdsdemands-ciselnik-fivetracks--4]", 4)
                .put("[xf3:cdsdemands-ciselnik-fivetracks--5]", 5)
                .build();
    }

    @Reference
    private CdsDemandLocalService cdsDemandLocalService;
    @Reference
    private CdsDemandPersistence cdsDemandPersistence;
    @Reference
    private CdsDemandVersionPersistence cdsDemandVersionPersistence;
    @Reference
    private EncyWorkflowStateInstanceLocalService stateInstanceLocalService;
    @Reference
    private EncyWorkflowStateLocalService stateLocalService;
    @Reference
    private EncyWorkflowTransitionInstanceLocalService transitionInstanceLocalService;
    @Reference
    private EncyWorkflowTransitionLocalService transitionLocalService;
    @Reference
    private UserLocalService userLocalService;
    @Reference
    private EncyWorkflowInstanceLocalService workflowInstanceLocalService;
    @Reference
    private EncyWorkflowLocalService workflowLocalService;
    @Reference
    private EncyWorkflowManager workflowManager;
}