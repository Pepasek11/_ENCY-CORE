package cz.csob.ency.modules.apps.meta.cds.internal.security.service.access.policy;

import com.liferay.portal.instance.lifecycle.BasePortalInstanceLifecycleListener;
import com.liferay.portal.instance.lifecycle.PortalInstanceLifecycleListener;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.security.service.access.policy.model.SAPEntry;
import com.liferay.portal.security.service.access.policy.service.SAPEntryLocalService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component(immediate = true, service = {})
public class MetaCdsSAPEntryActivator {
    @Activate
    protected void activate(BundleContext bundleContext) {
        _serviceRegistration = bundleContext.registerService(
                PortalInstanceLifecycleListener.class,
                new MetaCdsEntryPortalInstanceLifecycleListener(), null);
    }

    protected void addSAPEntry(long companyId) throws PortalException {
        SAPEntry sapEntry = _sapEntryLocalService.fetchSAPEntry(
                companyId, _SAP_ENTRY_NAME);

        if (sapEntry != null) {
            return;
        }

        String allowedServiceSignatures =
                "cz.csob.ency.modules.apps.meta.cds.service.*";

        Map<Locale, String> titleMap = new HashMap<>();
        titleMap.put(LocaleUtil.getDefault(), "Service Access Policy for REST Requests to the Meta CDS API");

        _sapEntryLocalService.addSAPEntry(
                _userLocalService.getDefaultUserId(companyId),
                allowedServiceSignatures, false, true, _SAP_ENTRY_NAME, titleMap,
                new ServiceContext());
    }

    @Deactivate
    protected void deactivate() {
        if (_serviceRegistration != null) {
            _serviceRegistration.unregister();
        }
    }

    private static final String _SAP_ENTRY_NAME = "META_CDS_DEFAULT";

    private static final Log _log = LogFactoryUtil.getLog(
            MetaCdsSAPEntryActivator.class);

    @Reference
    private SAPEntryLocalService _sapEntryLocalService;

    private ServiceRegistration<PortalInstanceLifecycleListener>
            _serviceRegistration;

    @Reference
    private UserLocalService _userLocalService;

    private class MetaCdsEntryPortalInstanceLifecycleListener
            extends BasePortalInstanceLifecycleListener {

        public void portalInstanceRegistered(Company company) throws Exception {
            try {
                addSAPEntry(company.getCompanyId());
            }
            catch (PortalException portalException) {
                _log.error(
                        "Unable to add service access policy entry for company " +
                                company.getCompanyId(),
                        portalException);
            }
        }

    }
}

