package cz.csob.ency.workflow.permission;

import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;

public interface EncyWorkflowPermission extends WorkflowPermission {
    Boolean hasPermission(PermissionChecker var1, long var2, String var4, long var5, String var7);
}
