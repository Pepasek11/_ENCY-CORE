package cz.csob.ency.data.provider.service;

import com.liferay.portal.kernel.service.ServiceContext;
import cz.csob.ency.data.provider.search.result.SearchResult;
import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface UserSearchLocalService {

    SearchResult searchUsers(String searchQuery, String roles, int start, int end, ServiceContext serviceContext)
            throws Exception;
}
