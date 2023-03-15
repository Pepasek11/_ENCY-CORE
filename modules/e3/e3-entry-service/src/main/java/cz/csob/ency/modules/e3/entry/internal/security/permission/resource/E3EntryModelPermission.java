package cz.csob.ency.modules.e3.entry.internal.security.permission.resource;

import com.liferay.portal.kernel.exception.NoSuchResourcePermissionException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;

@Component(immediate = true)
public class E3EntryModelPermission {
    private static final Log _log = LogFactoryUtil.getLog(E3EntryModelPermission.class);
    private static ModelResourcePermission<E3Entry> _entryResourcePermission;

    public static boolean contains(
            PermissionChecker permissionChecker, E3Entry entry, String actionId) throws PortalException {


        try {
            return _entryResourcePermission.contains(permissionChecker, entry, actionId);
        } catch (
                NoSuchResourcePermissionException exception) {
            _log.warn("Allowing Entry without permission resources. {entry=" + entry + "}");
            return true;
        }
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long entryId, String actionId) throws PortalException {

        try {
            return _entryResourcePermission.contains(permissionChecker, entryId, actionId);
        } catch (
                NoSuchResourcePermissionException exception) {
            _log.warn("Allowing Entry without permission resources. {entryId=" + entryId + "}");
            return true;
        }
    }

    @Reference(
            target = "(model.class.name=cz.csob.ency.modules.e3.entry.model.E3Entry)",
            unbind = "-")
    protected void setEntryModelPermission(ModelResourcePermission<E3Entry> modelResourcePermission) {

        _entryResourcePermission = modelResourcePermission;
    }

}