package cz.csob.ency.modules.e3.entry.internal.security.permission.resource;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.StagedPortletPermissionLogic;
import com.liferay.portal.kernel.util.HashMapDictionary;
import cz.csob.ency.modules.e3.entry.constants.E3EntryConstants;
import cz.csob.ency.modules.e3.entry.constants.E3PortletKeys;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.util.Dictionary;

@Component(immediate = true)
public class E3PortletResourcePermissionRegistrar {
    @Activate
    public void activate(BundleContext bundleContext) {
        Dictionary<String, Object> properties = new HashMapDictionary<>();

        properties.put("resource.name", E3EntryConstants.RESOURCE_NAME);

        _serviceRegistration = bundleContext.registerService(
                PortletResourcePermission.class,
                PortletResourcePermissionFactory.create(
                        E3EntryConstants.RESOURCE_NAME,
                        new StagedPortletPermissionLogic(
                                _stagingPermission, E3PortletKeys.E3Portlet)),
                properties);
    }

    @Deactivate
    public void deactivate() {
        _serviceRegistration.unregister();
    }

    private ServiceRegistration<PortletResourcePermission> _serviceRegistration;

    @Reference
    private StagingPermission _stagingPermission;

}
