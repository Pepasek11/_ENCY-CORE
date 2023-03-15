package cz.csob.ency.cds.demands.internal.util;

import com.liferay.admin.kernel.util.Omniadmin;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.SelectOption;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.RoleModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.model.UserGroupGroupRole;
import com.liferay.portal.kernel.security.auth.GuestOrUserUtil;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserGroupGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.util.*;
import cz.csob.ency.cds.demands.constants.*;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.cds.demands.model.CdsDemandWrapper;
import cz.csob.ency.cds.demands.service.CdsDemandLocalServiceUtil;
import cz.csob.ency.common.helpers.UserHelperUtil;
import cz.csob.ency.delegations.model.Delegation;
import cz.csob.ency.delegations.service.DelegationLocalServiceUtil;
import cz.csob.ency.workflow.manager.EncyWorkflowManagerUtil;
import cz.csob.ency.workflow.model.EncyWorkflowTransition;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Helper utils to get data for use mainly in web (gui)
 */

@Component(
        immediate = true,
        service = RenderHelperUtils.class
)
public class RenderHelperUtils {
    private static final Log _log = LogFactoryUtil.getLog(
            RenderHelperUtils.class);

    public RenderHelperUtils() {
        _resourceBundle = ResourceBundleUtil.getBundle("content.Language", CdsDemand.class);
    }

    /**
     * Get model meta info map used in GUI
     * like actions, rights ...
     *
     * @param entry
     * @return extended attributes
     */

    public Map<String, Object> getEntryMetaAttributes(
            CdsDemand entry, ServiceContext serviceContext) {

        if (entry.isNew()) {
            return Collections.emptyMap();
        }

        User user = serviceContext.fetchUser();
        PermissionChecker permissionChecker = getPermissionCheckerS(user);

        Map<String, Object> meta = new HashMap<>();

        boolean canPerform = false;
        String actionUrl = StringPool.BLANK;

        try {
            /* ADD action */
            try {
                canPerform = _portletResourcePermission.contains(
                        permissionChecker, serviceContext.getScopeGroupId(), ActionKeys.ADD_ENTRY);
            } catch (Exception e) {
                canPerform = false;
            }

            meta.put("canAdd", canPerform);

            // If omniadmin, then allow impersonations given in serviceContext
            /*
            if (permissionChecker.isOmniadmin()) {
                permissionChecker =
                        PermissionCheckerFactoryUtil.getPermissionCheckerFactory()
                                .create(serviceContext.fetchUser());
            }
            */

            /* VIEW action */
            canPerform = _modelResourcePermission.contains(
                    permissionChecker, entry.getPrimaryKey(),
                    ActionKeys.VIEW);

            meta.put("canView", canPerform);

            /* UPDATE action */
            canPerform = _modelResourcePermission.contains(
                    permissionChecker, entry.getPrimaryKey(),
                    ActionKeys.UPDATE);

            meta.put("canEdit", canPerform);

            /* DELETE action */
            canPerform = _modelResourcePermission.contains(
                    permissionChecker, entry, ActionKeys.DELETE);
            meta.put("canDelete", canPerform);

            /* Workflow actions */
            meta.put("workflwActions",
                    getWorkflowActions(entry, serviceContext));
        } catch (PortalException e) {
            e.printStackTrace();
        }

        return meta;
    }

    /**
     * Get model attributes map and extend it by another informations used in GUI
     * like translated labels, state ...
     *
     * @param entry
     * @return extended attributes
     */
    public Map<String, Object> getExtendedModelAttributes(
            CdsDemand entry, ServiceContext serviceContext) {

        Locale locale = serviceContext.getLocale();

        CdsDemandWrapper wrappedEntry = new CdsDemandWrapper(entry);
        Map<String, Object> entryAttrs = wrappedEntry.getModelAttributes();


        entryAttrs.put("fiveTracks", entry.getFiveTracksArray());
        entryAttrs.put("requestedDelivery", entry.getRequestedDelivery().getTime());


        entryAttrs.put("fiveTest", "fivetest");
        entryAttrs.put("typeLabel", _getLocalizedTypeLabel.getLabel(entry.getType(), locale));
        entryAttrs.put("priorityLabel", _getLocalizedPriorityLabel.getLabel(entry.getPriority(), locale));
        entryAttrs.put("fiveTracksLabels", _getLocalizedTrackLabel.getLabel(entry.getFiveTracksArray(), locale));
        entryAttrs.put("usFrequencyOutLabel", _getLocalizedUSFrequencyLabel.getLabel(entry.getUsFrequencyOut(), locale));
        entryAttrs.put("stateLabel", getLocalizedStateLabel(entry.getState(), locale));
        entryAttrs.put("requestedDeliveryLabel", DateUtil.getDate(entry.getRequestedDelivery(), "yyyy-MM-dd", locale));
        entryAttrs.put("workflowTransitions", getWorkflowActions(entry, serviceContext));
        //     .put("_meta", getEntryMetaAttributes(entry, serviceContext))
        entryAttrs.put("repositoryId", CdsDemandLocalServiceUtil.getRepositoryId(serviceContext.getScopeGroupId()));
        entryAttrs.put("attachmentsFolderId", CdsDemandLocalServiceUtil.getAttachmentsFolderId(
                0,
                serviceContext.getScopeGroupId(),
                entry.getPrimaryKey()));

        entryAttrs.put("banDelegations", _getDelegations(
                CdsDemandConstants.DELEGATION_ROLE_BAN_CODE, entry.getBanId(), serviceContext));

        entryAttrs.put("spocDelegations", _getDelegations(
                CdsDemandConstants.DELEGATION_ROLE_SPOC_CODE, entry.getSpocId(), serviceContext));

        return entryAttrs;
    }

    public List<Map<String, Object>> getFivetracksSelectList(Locale locale) {
        return _getSelectList(FIVETRACKS_ITEMS, _getLocalizedTrackLabel, locale);
    }

    public List<Map<String, Object>> getFrequencySelectList(Locale locale) {
        return _getSelectList(FREQUENCY_ITEMS, _getLocalizedUSFrequencyLabel, locale);
    }

    public String getLocalizedStateLabel(String status, Locale locale) {
        if (locale == null) {
            locale = LocaleUtil.getDefault();
        }

        return LanguageUtil.get(
                ResourceBundleUtil.getBundle(locale, CdsDemand.class),
                status
        );
    }

    public PermissionChecker getPermissionCheckerS(User u) {
        if (Validator.isNull(u)) {
            try {
                return GuestOrUserUtil.getPermissionChecker();
            } catch (PrincipalException e) {
                return PermissionCheckerFactoryUtil.create(null);
            }
        }

        return PermissionCheckerFactoryUtil.create(u);
    }

    public List<Map<String, Object>> getPrioritySelectList(Locale locale) {
        return _getSelectList(PRIORITY_ITEMS, _getLocalizedPriorityLabel, locale);
    }

    public List<SelectOption> getPrioritySelectOptions(Locale locale, int selectedId) {
        return _getSelectOptions(PRIORITY_ITEMS, _getLocalizedPriorityLabel, locale, selectedId);
    }

    public List<Map<String, Object>> getTypeSelectList(Locale locale) {
        return _getSelectList(TYPE_ITEMS, _getLocalizedTypeLabel, locale);
    }

    public List<SelectOption> getTypeSelectOptions(Locale locale, int selectedId) {
        return _getSelectOptions(TYPE_ITEMS, _getLocalizedTypeLabel, locale, selectedId);
    }

    public List<SelectOption> getUSFrequencySelectOptions(Locale locale, int selectedId) {
        return _getSelectOptions(FREQUENCY_ITEMS, _getLocalizedUSFrequencyLabel, locale, selectedId);
    }

    public Set<String> getUserRoles(User user) {

        Set<String> roles = user.getRoles().stream().map(RoleModel::getName).collect(Collectors.toSet());
        List<UserGroup> groups = UserGroupLocalServiceUtil.getUserUserGroups(user.getUserId());
        _log.warn("USer: " + user.getUserId());
        List<UserGroupGroupRole> uggrs = UserGroupGroupRoleLocalServiceUtil.getUserGroupGroupRolesByUser(user.getUserId());
        _log.warn("UGGRS size = " + uggrs.size());

        /**
         * @todo: zjistit jak ziskat inherited roles. UserGroupGroupRoleLocalServiceUtil.getUserGroupGroupRolesByUser
         * nefunguje, i kdyz by melo. Pouziva se to v default lr administraci a tam to ukazuje role :/
         */
        uggrs.stream().map(userGroupGroupRole -> {
            try {
                _log.warn("UGGR: " + userGroupGroupRole.getRole().getName());
                return userGroupGroupRole.getRole().getName();
            } catch (PortalException e) {
                e.printStackTrace();
            }
            return null;
        }).forEach(roles::add);
        return roles;
    }

    public boolean isEncyAdmin(User u) {
        try {
            return RoleLocalServiceUtil.hasUserRole(
                    u.getUserId(),
                    u.getCompanyId(),
                    CdsDemandConstants.ROLE_ENCYADMIN,
                    true);
        } catch (PortalException e) {
        }

        return false;
    }

    public boolean isCdsUser(User u) {
        try {
            return RoleLocalServiceUtil.hasUserRole(
                    u.getUserId(),
                    u.getCompanyId(),
                    CdsDemandConstants.ROLE_CDSINTERNAL,
                    true);
        } catch (PortalException e) {
        }

        return false;
    }

    public boolean isLorm(User u) {
        try {
            return RoleLocalServiceUtil.hasUserRole(
                    u.getUserId(),
                    u.getCompanyId(),
                    CdsDemandConstants.ROLE_ENCYLORM,
                    true);
        } catch (PortalException e) {
        }

        return false;
    }

    public boolean isOmniadmin(long userId) {
        return isOmniadmin(userId, true);
    }

    public boolean isOmniadmin(long userId, boolean checkimpersonation) {
        /* @todo
        PermissionChecker permissionChecker =
                PermissionThreadLocal.getPermissionChecker();
        if (checkimpersonation
                && permissionChecker.getUserId() != userId
                && !permissionChecker.isOmniadmin()) {
            // Only omniadmin can impersonate another user
            return false;
        }
         */
        return _omniadmin.isOmniadmin(userId);
    }

    private List<Object> _getDelegations(String roleCode, long userId, ServiceContext serviceContext) {
        List<Delegation> delegations =
                DelegationLocalServiceUtil.getDelegationsOfUser(
                        serviceContext.getScopeGroupId(), roleCode, userId);

        return
                delegations.stream().map(
                        delegation -> HashMapBuilder
                                .put("value",
                                        UserHelperUtil.getFormattedUserName(
                                                delegation.getDelegatedUserId()))
                                .put("id", String.valueOf(delegation.getDelegatedUserId()))
                                .build()
                ).collect(Collectors.toList());

    }

    private List<Map<String, Object>> _getSelectList(
            int[] items, GetLabelInterface getter, Locale locale) {

        List<Map<String, Object>> options = new ArrayList<>();

        for (int item : items) {
            options.add(
                    HashMapBuilder.<String, Object>put(
                            "label", getter.getLabel(item, locale)
                    ).put(
                            "value", item
                    ).build()
            );
        }
        return options;
    }

    private List<SelectOption> _getSelectOptions(
            int[] items, GetLabelInterface getter, Locale locale, int selectedId) {
        List<SelectOption> options = new ArrayList<>();

        for (int item : items) {
            options.add(new SelectOption(
                            getter.getLabel(item, locale),
                            String.valueOf(item),
                            selectedId == item
                    )
            );
        }

        return options;
    }

    /**
     * Return available workflow actions (as action URLs) for given entry
     *
     * @param entry
     * @todo Use workflow service as main entry ponit for wf transition handling
     */
    private List<Object> getWorkflowActions(CdsDemand entry, ServiceContext serviceContext) {
        List<EncyWorkflowTransition> transitions = Collections.EMPTY_LIST;
        List<Object> actions = new ArrayList<>();
        try {
            //       ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
            ResourceBundle resourceBundle =
                    ResourceBundleUtil.getBundle(
                            serviceContext.getLocale(),
                            CdsDemand.class);

            transitions =
                    EncyWorkflowManagerUtil.getAllowedOutgoingTransitions(
                            entry.getCompanyId(),
                            entry.getGroupId(),
                            entry,
                            serviceContext
                    );

            for (EncyWorkflowTransition transition : transitions) {
                actions.add(HashMapBuilder
                        .put("name", transition.getName())
                        .put("cssIcon", transition.getCssIcon())
                        .put("cssIconColor", transition.getCssIconColor())
                        .put("title", LanguageUtil.get(
                                resourceBundle, transition.getTitle())
                        )
                        .build()
                );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return actions;
    }

    private interface GetLabelInterface {
        default String getLabel(int item, Locale locale) {
            return StringPool.BLANK;
        }

        default String[] getLabel(int[] items, Locale locale) {
            return new String[]{};
        }
    }

    public final int[] FIVETRACKS_ITEMS = {
            CdsDemandFiveTracks.TRACK_0NONE,
            CdsDemandFiveTracks.TRACK_1KATE,
            CdsDemandFiveTracks.TRACK_2LEAD,
            CdsDemandFiveTracks.TRACK_3NDM,
            CdsDemandFiveTracks.TRACK_4STP,
            CdsDemandFiveTracks.TRACK_5DATA
    };
    public final int[] FREQUENCY_ITEMS = {
            CdsDemandUSFrequency.FREQUENCY_ONCE,
            CdsDemandUSFrequency.FREQUENCY_DAILY,
            CdsDemandUSFrequency.FREQUENCY_WEEKLY,
            CdsDemandUSFrequency.FREQUENCY_MONTHLY,
            CdsDemandUSFrequency.FREQUENCY_QUARTERLY,
            CdsDemandUSFrequency.FREQUENCY_HALFYEARLY,
            CdsDemandUSFrequency.FREQUENCY_YEARLY,
            CdsDemandUSFrequency.FREQUENCY_OTHER
    };
    public final int[] PRIORITY_ITEMS = {
            CdsDemandPriority.PRIORITY_LOW,
            CdsDemandPriority.PRIORITY_HIGH,
            CdsDemandPriority.PRIORITY_EXTREME
    };
    public final int[] TYPE_ITEMS = {
            CdsDemandType.TYPE_BS,
            CdsDemandType.TYPE_US,
            CdsDemandType.TYPE_OUT,
    };
    private final GetLabelInterface _getLocalizedPriorityLabel = new GetLabelInterface() {
        @Override
        public String getLabel(int status, Locale locale) {
            if (locale == null) {
                locale = LocaleUtil.getDefault();
            }

            return LanguageUtil.get(
                    ResourceBundleUtil.getBundle(locale, CdsDemand.class),
                    CdsDemandPriority.getStatusLabel(status)
            );
        }
    };
    private final GetLabelInterface _getLocalizedTrackLabel = new GetLabelInterface() {
        @Override
        public String getLabel(int track, Locale locale) {
            if (locale == null) {
                locale = LocaleUtil.getDefault();
            }

            return LanguageUtil.get(
                    ResourceBundleUtil.getBundle(locale, CdsDemand.class),
                    CdsDemandFiveTracks.getTrackLabel(track)
            );
        }

        @Override
        public String[] getLabel(int[] tracks, Locale locale) {
            if (locale == null) {
                locale = LocaleUtil.getDefault();
            }
            String[] labels = new String[tracks.length];
            for (int i = 0; i < tracks.length; i++) {
                labels[i] = LanguageUtil.get(
                        ResourceBundleUtil.getBundle(locale, CdsDemand.class),
                        CdsDemandFiveTracks.getTrackLabel(tracks[i]));
            }
            return labels;
        }
    };
    private final GetLabelInterface _getLocalizedTypeLabel = new GetLabelInterface() {
        @Override
        public String getLabel(int status, Locale locale) {
            if (locale == null) {
                locale = LocaleUtil.getDefault();
            }

            return LanguageUtil.get(
                    ResourceBundleUtil.getBundle(locale, CdsDemand.class),
                    CdsDemandType.getTypeLabel(status)
            );
        }
    };
    private final GetLabelInterface _getLocalizedUSFrequencyLabel = new GetLabelInterface() {
        @Override
        public String getLabel(int status, Locale locale) {
            if (locale == null) {
                locale = LocaleUtil.getDefault();
            }

            return LanguageUtil.get(
                    ResourceBundleUtil.getBundle(locale, CdsDemand.class),
                    CdsDemandUSFrequency.getTypeLabel(status)
            );
        }
    };
    @Reference(
            policy = ReferencePolicy.DYNAMIC,
            policyOption = ReferencePolicyOption.GREEDY,
            target = "(model.class.name=" + CdsDemandConstants.DEMAND_MODEL_CLASS_NAME + ")"
    )
    private volatile ModelResourcePermission<CdsDemand> _modelResourcePermission;
    @Reference
    private Omniadmin _omniadmin;
    @Reference(
            policy = ReferencePolicy.DYNAMIC,
            policyOption = ReferencePolicyOption.GREEDY,
            target = "(resource.name=" + CdsDemandConstants.RESOURCE_NAME + ")"
    )
    private volatile PortletResourcePermission _portletResourcePermission;
    private ResourceBundle _resourceBundle;
}
