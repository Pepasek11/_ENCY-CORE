package cz.csob.ency.cds.demands.cst.service;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import cz.csob.ency.common.json.response.EncyJsonResponse;
import org.osgi.annotation.versioning.ProviderType;

@AccessControlled
@JSONWebService
@ImplementationClassName("cz.csob.ency.cds.demands.cst.service.impl.CstServiceImpl")
@ProviderType
public interface CstService {
    public EncyJsonResponse getGdprCategoryOptions();

    public EncyJsonResponse getGdprReasoningOptions();

}
