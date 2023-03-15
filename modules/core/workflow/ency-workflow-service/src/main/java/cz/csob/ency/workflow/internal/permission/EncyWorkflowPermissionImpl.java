package cz.csob.ency.workflow.internal.permission;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import cz.csob.ency.workflow.manager.EncyWorkflowManagerUtil;
import cz.csob.ency.workflow.model.EncyWorkflowStateInstance;
import cz.csob.ency.workflow.permission.EncyWorkflowPermission;
import cz.csob.ency.workflow.service.EncyWorkflowInstanceLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = EncyWorkflowPermission.class)
public class EncyWorkflowPermissionImpl implements EncyWorkflowPermission {

    private static final Log _log = LogFactoryUtil.getLog(
            EncyWorkflowPermissionImpl.class);

    @Override
    public Boolean hasPermission(
            PermissionChecker permissionChecker, long groupId, String className,
            long classPK, String actionId) {

        try {
            return doHasPermission(
                    permissionChecker, groupId, className, classPK, actionId);
        } catch (Exception exception) {
            _log.error(exception);
        }

        return null;
    }

    protected Boolean doHasPermission(
            PermissionChecker permissionChecker, long groupId, String className,
            long classPK, String actionId)
            throws Exception {

        long companyId = permissionChecker.getCompanyId();
        User user = permissionChecker.getUser();

        if (EncyWorkflowInstanceLocalServiceUtil.hasWorkflowInstance(
                companyId, groupId, className, classPK)) {

            EncyWorkflowStateInstance wsi =
                    EncyWorkflowManagerUtil.getEntryStateInstance(companyId, groupId, className, classPK);

            if (wsi == null) {
                return null;
            }

            if (actionId.equals("VIEW")) {
                // @todo has implicit permission,
                return null;
            }

            if (actionId.equals("UPDATE")) {
                // @todo has implicit permission AllowEdit wf handler
                if (!wsi.getWorkflowState().getIsEditable()) {
                    return Boolean.FALSE;
                }
            }

            if (actionId.equals("DELETE")) {
                if (permissionChecker.isOmniadmin()
                        || user.getRoles().stream().anyMatch
                        (
                                role -> ("Administrator".equals(role.getName())
                                        || "0002_GS_ACDSENCYADMINISTRATOR".equals(role.getName()))
                        )
                ) {
                    return Boolean.TRUE;
                }
                //@todo daa isDeletable state? or test candelete via workflow handler?
                if (!wsi.getWorkflowState().getIsEditable()) {
                    return Boolean.FALSE;
                }
            }
        }

        return null;
    }


}
