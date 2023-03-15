package cz.csob.ency.cds.demands.internal.workflow.runtime;

import com.liferay.admin.kernel.util.Omniadmin;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import cz.csob.ency.cds.demands.constants.CdsDemandConstants;
import cz.csob.ency.cds.demands.constants.CdsDemandType;
import cz.csob.ency.cds.demands.constants.CdsDemandWorkflowConstants;
import cz.csob.ency.cds.demands.internal.util.CdsDemandValidator;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.delegations.service.DelegationLocalService;
import cz.csob.ency.workflow.runtime.ExecutionContext;
import cz.csob.ency.workflow.runtime.action.EncyWorkflowTransitionAllowAction;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Objects;

@Component(immediate = true,
        service = EncyWorkflowTransitionAllowAction.class,
        property = {
                "ency.workflow.class.name=" + CdsDemandWorkflowConstants.WORKFLOW_CLASS_NAME,
                "ency.workflow.transition.name=ALL"
        }
)
public class CdsDemandOnTransitionAllow implements EncyWorkflowTransitionAllowAction<CdsDemand> {
    static final int CHECK_BAN = 1;
    static final int CHECK_BICDS = 1 << 1;
    static final int CHECK_CONTACTPERSON = 1 << 2;
    static final int CHECK_GDPR = 1 << 3;
    static final int CHECK_INPUTS = 1 << 4;
    static final int CHECK_REQUESTOR = 1 << 5;
    static final int CHECK_SPOC = 1 << 6;
    private static final Log _log = LogFactoryUtil.getLog(
            CdsDemandOnTransitionAllow.class);

    @Override
    public boolean perform(ExecutionContext<CdsDemand> executionContext) throws PortalException {

        CdsDemand demand = executionContext.getModel();
        String transitionCode = executionContext.getTransitionName();
        long groupId = executionContext.getModel().getGroupId();
        long companyId = executionContext.getModel().getCompanyId();

        if (Validator.isNull(demand)) {
            _log.warn("Demand is null");
            return false;
        }
        if (Validator.isBlank(transitionCode)) {
            _log.warn("transitionName is blank");
            return false;
        }

        long userId = Long.parseLong(
                executionContext.getWorkflowContext().getOrDefault(
                                WorkflowConstants.CONTEXT_USER_ID, 0)
                        .toString());

        /*
        @todo PermissionThreadLocal neni spolehlivy. Na DEVu tam nastavuje default usera :/
        PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
        if (!permissionChecker.isOmniadmin() && permissionChecker.getUserId() != userId) {
            // do not allow impersonations to non omniusers
            userId = permissionChecker.getUserId();
        }
         */

        User user = UserLocalServiceUtil.fetchUser(userId);
        if (user == null) {
            _log.warn("Check if transition is allowed for null user. If it is system, its ok.");
            return true;
        }

        int checks = 0;
        switch (transitionCode) {
            case CdsDemandWorkflowConstants.TRANSITION_NACENOVANO_SYNC_ZRUSENO:
            case CdsDemandWorkflowConstants.TRANSITION_NACENENO_SYNC_ZRUSENO:
            case CdsDemandWorkflowConstants.TRANSITION_REALIZACE_SYNC_ZRUSENO:
            case CdsDemandWorkflowConstants.TRANSITION_AKCEPTACE_SYNC_ZRUSENO:
            case CdsDemandWorkflowConstants.TRANSITION_REALIZACE_SYNC_DO_AKCEPTACE:
                return false;
            case CdsDemandWorkflowConstants.TRANSITION_NACENOVANO_NACENENO:
            case CdsDemandWorkflowConstants.TRANSITION_NACENOVANO_NACENENO_US:
                return false;
            //return false
            case CdsDemandWorkflowConstants.TRANSITION_NAVRH_ZRUSIT:
                checks = CHECK_REQUESTOR | CHECK_CONTACTPERSON | CHECK_BICDS | CHECK_SPOC;
                break;
            case CdsDemandWorkflowConstants.TRANSITION_NAVRH_KE_SCHVALENI:
                checks = CHECK_REQUESTOR | CHECK_CONTACTPERSON | CHECK_INPUTS | CHECK_GDPR | CHECK_BICDS | CHECK_SPOC;
                break;
            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_SPOC_SCHVALIT:
                if (demand.getType() != CdsDemandType.TYPE_US
                        && demand.getType() != CdsDemandType.TYPE_BS) {
                    return false;
                }
                checks = CHECK_SPOC | CHECK_INPUTS;
                break;
            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_SPOC_VRATIT:
            case CdsDemandWorkflowConstants.TRANSITION_POZASTAVENO_SPOC_OBNOVIT:
            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_SPOC_POZASTAVIT:
                checks = CHECK_SPOC;
                break;
            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_SPOC_MIMO_CDS:
                if (demand.getType() != CdsDemandType.TYPE_OUT) {
                    return false;
                }
                checks = CHECK_SPOC;
                break;
            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_SPOC_ZRUSIT:
                checks = CHECK_REQUESTOR | CHECK_CONTACTPERSON | CHECK_SPOC;
                break;
            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_BAN_SCHVALIT:
                if (demand.getType() != CdsDemandType.TYPE_BS) return false;
                checks = CHECK_BAN | CHECK_INPUTS;
                break;
            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_BAN_SCHVALITUS:
                if (demand.getType() != CdsDemandType.TYPE_US) return false;
                checks = CHECK_BAN | CHECK_INPUTS;
                break;
            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_BAN_MIMO_CDS:
                if (demand.getType() != CdsDemandType.TYPE_OUT) {
                    return false;
                }
                checks = CHECK_BAN;
                break;
            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_BAN_POZASTAVIT:
            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_BAN_VRATIT:
            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_BAN_ZAMITNOUT:
            case CdsDemandWorkflowConstants.TRANSITION_POZASTAVENO_BAN_OBNOVIT:
                checks = CHECK_BAN;
                break;
            case CdsDemandWorkflowConstants.TRANSITION_NACENENO_ODMITNOUT:
            case CdsDemandWorkflowConstants.TRANSITION_NACENENO_SCHVALIT:
                checks = CHECK_SPOC;
                break;
            case CdsDemandWorkflowConstants.TRANSITION_REALIZACE_DO_AKCEPTACE:
                checks = CHECK_BAN | CHECK_BICDS;
                break;
            case CdsDemandWorkflowConstants.TRANSITION_AKCEPTACE_SCHVALIT:
            case CdsDemandWorkflowConstants.TRANSITION_AKCEPTACE_ODMITNOUT:
                checks = CHECK_SPOC | CHECK_REQUESTOR | CHECK_CONTACTPERSON;
                break;
            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_DODAVKY_DO_AKCEPTACE:
            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_DODAVKY_DO_REALIZACE:
                checks = CHECK_BAN;
                break;
            case CdsDemandWorkflowConstants.TRANSITION_VRATIT_CDS:
            case CdsDemandWorkflowConstants.TRANSITION_NACENOVANO_ADM_DO_REVIZE:
            case CdsDemandWorkflowConstants.TRANSITION_REALIZACE_TMP_DO_REVIZE_BAN:
                // Only Ency admins
                break;
            default:
                _log.warn("Unsupported transition_code [" + transitionCode + "].");
                return false;
        }

        Boolean checksResult = omniadmin.isOmniadmin(userId);

        _log.debug("Going to process selected chceck [" + checks + "]. With" + checksResult + " and userId=" + userId);

        // Check for person, first (only one) match is enought for allow person/role
        // Check for requestor
        if (!checksResult && (checks & CHECK_REQUESTOR) > 0) {
            checksResult =
                    Objects.equals(userId, demand.getRequestorId())
                            || Objects.equals(userId, demand.getRequestedForId());
        }

        // Check for the contact person
        if (!checksResult && (checks & CHECK_CONTACTPERSON) > 0) {
            checksResult =
                    Objects.equals(userId, demand.getContactId());
        }

        // Check for the spoc
        if (!checksResult && (checks & CHECK_SPOC) > 0) {
            checksResult = _check_with_backups(
                    CdsDemandConstants.DELEGATION_ROLE_SPOC_CODE, demand.getSpocId(), userId, groupId);
        }

        //  Check for the ban
        if (!checksResult && (checks & CHECK_BAN) > 0) {
            _check_with_backups(
                    CdsDemandConstants.DELEGATION_ROLE_BAN_CODE, demand.getSpocId(), userId, groupId);
        }

        // Check for the BI CDS
        if (!checksResult && (checks & CHECK_BICDS) > 0) {
            // checksResult = user.getRoles().contains("0002_GS_ACDSENCYBICDSINTERNAL");
            checksResult = roleLocalService.hasUserRole(
                    userId, companyId, CdsDemandConstants.ROLE_CDSINTERNAL, true);
        }

        _log.debug("Going to check inputs current state: [" + checksResult + "].");

        // Check for data, all checks must be satisfied
        if (checksResult && (checks & CHECK_INPUTS) > 0) {
            CdsDemandValidator validator = new CdsDemandValidator();
            validator.validate(demand);
        }
        _log.debug("Final result [" + checksResult + "].");

        return checksResult;
    }

    protected boolean _check_with_backups(
            String role, long roleUserId, long currentUserId, long groupId) {
        if (Objects.equals(currentUserId, roleUserId)) {
            return true;
        }

        return delegationLocalService.getDelegationsOfUser(
                groupId, role, roleUserId
        ).stream().anyMatch(delegation ->
                Objects.equals(currentUserId, delegation.getDelegatedUserId())
        );
    }

    @Reference
    protected DelegationLocalService delegationLocalService;
    @Reference
    protected Omniadmin omniadmin;
    @Reference
    protected RoleLocalService roleLocalService;
}
