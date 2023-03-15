package cz.csob.ency.data.provider.service;

import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.ServiceContext;
import cz.csob.ency.data.provider.search.result.SearchResult;
import org.osgi.annotation.versioning.ProviderType;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@AccessControlled
@JSONWebService
@ProviderType
public interface UsersDataProviderService {
    List<Map<String, Serializable>> searchUsers(String searchQuery, ServiceContext serviceContext)
            throws Exception;

    List<Map<String, Serializable>> searchUsersPaged(String searchQuery, int start, int end, ServiceContext serviceContext)
            throws Exception;

    List<Map<String, Serializable>> searchUsersByRoles(String searchQuery, String roles, ServiceContext serviceContext)
            throws Exception;

    List<Map<String, Serializable>> searchUsersByRolesPaged(String searchQuery, String roles, int searchPage, int delta, ServiceContext serviceContext)
            throws Exception;

    SearchResult<List<Map<String, Serializable>>> searchUsersForSelect(String searchQuery, String roles, int page, int delta, ServiceContext serviceContext)
            throws Exception;
}
