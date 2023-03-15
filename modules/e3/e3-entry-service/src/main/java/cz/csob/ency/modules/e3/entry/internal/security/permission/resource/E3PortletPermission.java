package cz.csob.ency.modules.e3.entry.internal.security.permission.resource;

import com.liferay.portal.kernel.exception.NoSuchResourcePermissionException;
import cz.csob.ency.modules.e3.entry.constants.E3EntryConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;

@Component(immediate = true)
public class E3PortletPermission {

    private static PortletResourcePermission _portletResourcePermission;

    public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId) {

        return _portletResourcePermission.contains(permissionChecker, groupId, actionId);
    }

    @Reference(
            target = "(resource.name=" + E3EntryConstants.RESOURCE_NAME + ")",
            unbind = "-"
    )
    protected void setPortletResourcePermission(PortletResourcePermission portletResourcePermission) {

        _portletResourcePermission = portletResourcePermission;
    }
}
