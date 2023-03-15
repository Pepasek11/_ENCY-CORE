package cz.csob.ency.cds.demands.bioe.service;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.ServiceContext;
import cz.csob.ency.common.json.response.EncyJsonResponse;
import org.osgi.annotation.versioning.ProviderType;

import java.io.Serializable;
import java.util.Map;

@AccessControlled
@JSONWebService
@ImplementationClassName("cz.csob.ency.cds.demands.bioe.service.impl.BioeLocalServiceImpl")
@ProviderType
public interface BioeLocalService {
    EncyJsonResponse getClouds(Long[] domainId, ServiceContext serviceContext);

    Map<String, Object> runBioeSync(ServiceContext serviceContext);

    Map<String, Object> getRequestorInfo(long userId, ServiceContext serviceContext);

    Map<String, Object> getRequestorInfo(User user, ServiceContext serviceContext);

    long getUserDomainId(String screenName);
}
