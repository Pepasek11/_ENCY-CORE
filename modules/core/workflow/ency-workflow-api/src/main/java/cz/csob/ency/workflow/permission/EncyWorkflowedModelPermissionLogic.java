package cz.csob.ency.workflow.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionLogic;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;

import java.util.Objects;
import java.util.function.ToLongFunction;

public class EncyWorkflowedModelPermissionLogic<T extends GroupedModel> implements ModelResourcePermissionLogic<T> {
    public EncyWorkflowedModelPermissionLogic(
            WorkflowPermission workflowPermission, ModelResourcePermission<T> modelResourcePermission,
            GroupLocalService groupLocalService, ToLongFunction<T> primKeyToLongFunction) {
        this._workflowPermission = (EncyWorkflowPermission) Objects.requireNonNull(workflowPermission);
        this._modelResourcePermission = (ModelResourcePermission) Objects.requireNonNull(modelResourcePermission);
        this._groupLocalService = groupLocalService;
        this._primKeyToLongFunction = (ToLongFunction) Objects.requireNonNull(primKeyToLongFunction);
    }

    public Boolean contains(PermissionChecker permissionChecker, String name, T model, String actionId)
            throws PortalException {
        return this._workflowPermission.hasPermission(
                permissionChecker, model.getGroupId(), name, this._primKeyToLongFunction.applyAsLong(model), actionId);
    }

    private final GroupLocalService _groupLocalService;
    private final ModelResourcePermission<T> _modelResourcePermission;
    private final ToLongFunction<T> _primKeyToLongFunction;
    private final EncyWorkflowPermission _workflowPermission;
}
