package cz.csob.ency.data.provider.service.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.search.query.Queries;
import com.liferay.portal.search.searcher.SearchRequestBuilderFactory;
import com.liferay.portal.search.searcher.Searcher;
import cz.csob.ency.common.helpers.UserHelper;
import cz.csob.ency.data.provider.search.result.SearchResult;
import cz.csob.ency.data.provider.service.UserSearchLocalService;
import cz.csob.ency.data.provider.service.UsersDataProviderService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.*;

@Component(
        property = {
                "json.web.service.context.name=ency",
                "json.web.service.context.path=Users"
        },
        service = AopService.class
)
public class UsersDataProviderServiceImpl implements UsersDataProviderService, AopService {

    private static final Log _log = LogFactoryUtil.getLog(
            UsersDataProviderServiceImpl.class);


    @Override
    public List<Map<String, Serializable>> searchUsers(String searchQuery, ServiceContext serviceContext)
            throws Exception {

        return this.searchUsersByRolesPaged(searchQuery, StringPool.BLANK, -1, -1, serviceContext);
    }

    @Override
    public List<Map<String, Serializable>> searchUsersByRoles(String searchQuery, String roles, ServiceContext serviceContext)
            throws Exception {

        return this.searchUsersByRolesPaged(searchQuery, roles, -1, -1, serviceContext);
    }

    @Override
    public List<Map<String, Serializable>> searchUsersByRolesPaged(String searchQuery, String roles, int start, int end, ServiceContext serviceContext)
            throws Exception {

        SearchResult<List<User>> searchResult = userSearchLocalService.searchUsers(searchQuery, roles, start, end, serviceContext);
        if (!searchResult.getSuccess()) {
            return Collections.emptyList();
        }

        List<User> users = searchResult.getData();
        return _getResult(users);
    }

    @Override
    public SearchResult<List<Map<String, Serializable>>> searchUsersForSelect(String searchQuery, String roles, int page, int delta, ServiceContext serviceContext)
            throws Exception {
        int start = Math.max(-1, (page - 1) * delta);
        int end = Math.max(-1, ((page) * delta));

        SearchResult<List<User>> searchResult =
                userSearchLocalService.searchUsers(searchQuery, roles, start, end, serviceContext);

        List<User> users = searchResult.getData();

        SearchResult<List<Map<String, Serializable>>> searchResultFinal = new SearchResult<>();
        searchResultFinal
                .setData(_getResult(users))
                .setResultsStart(searchResult.getResultsStart())
                .setResultsEnd(searchResult.getResultsEnd())
                .setTotalResults(searchResult.getTotalResults())
                .setErrorMessage(searchResult.getErrorMessage())
                .setProperties(searchResult.getProperties());

        return searchResultFinal;
    }

    @Override
    public List<Map<String, Serializable>> searchUsersPaged(String searchQuery, int start, int end, ServiceContext serviceContext)
            throws Exception {

        return this.searchUsersByRolesPaged(searchQuery, StringPool.BLANK, start, end, serviceContext);
    }

    private List<Map<String, Serializable>> _getResult(List<User> users) {
        List<Map<String, Serializable>> result = new ArrayList<>();
        for (User user : users) {
            Map<String, Serializable> rec = new HashMap<>();
            rec.put("id", user.getUserId());
            rec.put("fullName", user.getFullName());
            rec.put("text", userHelper.getFormattedUserName(user));
            rec.put("login", user.getScreenName());
            rec.put("email", user.getEmailAddress());
            rec.put("department", user.getExpandoBridge().getAttribute("department"));

            result.add(rec);
        }
        return result;
    }
    @Reference
    protected Queries queries;
    @Reference
    protected SearchRequestBuilderFactory searchRequestBuilderFactory;
    @Reference
    protected Searcher searcher;
    @Reference
    protected UserHelper userHelper;
    @Reference
    protected UserSearchLocalService userSearchLocalService;
}
