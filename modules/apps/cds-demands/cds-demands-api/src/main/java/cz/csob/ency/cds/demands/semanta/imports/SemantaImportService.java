package cz.csob.ency.cds.demands.semanta.imports;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.ServiceContext;
import cz.csob.ency.common.json.response.EncyJsonResponse;
import org.osgi.annotation.versioning.ProviderType;

@AccessControlled
@JSONWebService
@ImplementationClassName("cz.csob.ency.cds.demands.internal.semanta.imports.SemantaImportLocalServiceImpl")
@ProviderType
public interface SemantaImportService {
    EncyJsonResponse importDemands(
            boolean reimport, long limit, ServiceContext serviceContext)
            throws PortalException;    //  @Override


    EncyJsonResponse importExUsers(ServiceContext serviceContext)
            throws PortalException;

}
