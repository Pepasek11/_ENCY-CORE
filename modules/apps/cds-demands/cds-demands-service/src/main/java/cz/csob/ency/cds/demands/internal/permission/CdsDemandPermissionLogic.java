package cz.csob.ency.cds.demands.internal.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionLogic;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import cz.csob.ency.cds.demands.constants.CdsDemandConstants;
import cz.csob.ency.cds.demands.constants.CdsDemandWorkflowConstants;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.delegations.service.DelegationLocalServiceUtil;

public class CdsDemandPermissionLogic<T extends GroupedModel> implements ModelResourcePermissionLogic<T> {
    private static final Log _log = LogFactoryUtil.getLog(
            CdsDemandPermissionLogic.class);

    public CdsDemandPermissionLogic() {
    }

    public Boolean contains(PermissionChecker permissionChecker, String name, T model, String actionId)
            throws PortalException {
        CdsDemand demand = (CdsDemand) model;
        long userId = permissionChecker.getUserId();

        if (_log.isDebugEnabled()) _log.debug("Checking permission for user " + userId + " and action " + actionId);
        switch (actionId) {
            case "UPDATE": {
                //  return true;
                // Ency admin and cds empl can update (can be disabled by WorkflowPermissionLogic before this check)
                if (permissionChecker.getUser().getRoles().stream().anyMatch(role ->
                        role.getName().equals(CdsDemandConstants.ROLE_ENCYADMIN) ||
                                role.getName().equals(CdsDemandConstants.ROLE_CDSINTERNAL)
                )) return true;

                if (_isSpoc(userId, demand)) return true;

                break;
            }

            case "DELETE": {
                // Requestor can delete if demand is in draft
                if (demand.getState().equals(CdsDemandWorkflowConstants.STATE_NAVRH) &&
                        _isRequestor(userId, demand)
                ) {
                    if (_log.isDebugEnabled()) _log.debug("Allowed - Requestor and draft");
                    return true;
                }

                // Ency admin can delete (can be disabled by WorkflowPermissionLogic before this check)
                if (RoleLocalServiceUtil.hasUserRole(
                        userId, permissionChecker.getCompanyId(),
                        CdsDemandConstants.ROLE_ENCYADMIN, true)) {
                    if (_log.isDebugEnabled()) _log.debug("Allowed - Encyadmin");
                    return true;
                }
                break;
            }
        }
        if (_log.isDebugEnabled()) _log.debug("Not decided");
        return null;
    }

    private boolean _isBan(long userId, CdsDemand demand) {
        if (userId == demand.getBanId()) return true;

        return DelegationLocalServiceUtil.getDelegationsOfUser(
                        demand.getGroupId(), CdsDemandConstants.DELEGATION_ROLE_BAN_CODE, demand.getBanId())
                .stream().anyMatch(delegation -> delegation.getDelegatedUserId() == userId);
    }

    private boolean _isRequestor(long userId, CdsDemand demand) {
        return userId == demand.getRequestorId()
                || userId == demand.getRequestedForId()
                || userId == demand.getContactId();
    }

    private boolean _isSpoc(long userId, CdsDemand demand) {
        if (userId == demand.getSpocId()) return true;

        return DelegationLocalServiceUtil.getDelegationsOfUser(
                        demand.getGroupId(), CdsDemandConstants.DELEGATION_ROLE_SPOC_CODE, demand.getSpocId())
                .stream().anyMatch(delegation -> delegation.getDelegatedUserId() == userId);
    }
}
