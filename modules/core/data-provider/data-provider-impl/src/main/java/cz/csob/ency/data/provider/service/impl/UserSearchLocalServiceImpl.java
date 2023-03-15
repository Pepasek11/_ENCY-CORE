package cz.csob.ency.data.provider.service.impl;

import com.liferay.portal.kernel.exception.NoSuchRoleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.search.hits.SearchHit;
import com.liferay.portal.search.hits.SearchHits;
import com.liferay.portal.search.query.BooleanQuery;
import com.liferay.portal.search.query.Queries;
import com.liferay.portal.search.query.Query;
import com.liferay.portal.search.searcher.*;
import cz.csob.ency.data.provider.search.result.SearchResult;
import cz.csob.ency.data.provider.service.UserSearchLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

@Component(
        service = UserSearchLocalService.class
)
public class UserSearchLocalServiceImpl implements UserSearchLocalService {

    private static final Log _log = LogFactoryUtil.getLog(
            UserSearchLocalServiceImpl.class);

    @Override
    public SearchResult searchUsers(
            String searchQuery, String roles, int start, int end, ServiceContext serviceContext)
            throws Exception {

        SearchResult searchResult = new SearchResult<List<User>>();
        List<User> users = new ArrayList<>();

        try {
            if (_log.isDebugEnabled())
                _log.debug("Searching users with params [ roles:" + roles + ", q:" +
                        searchQuery + ", start:" + start + ", end:" + end + "]");

            long[] rolesIds = _getRolesIds(serviceContext.getCompanyId(), roles);

            SearchHits searchHits = _getSearchHits(serviceContext.getCompanyId(), searchQuery,
                    start, end, rolesIds, _getGroupIds(rolesIds)
            );

            List<SearchHit> searchHitList = searchHits.getSearchHits();

            if (_log.isDebugEnabled())
                _log.debug("Got " + searchHits.getTotalHits() + " hits");

            searchResult
                    .setTotalResults(searchHits.getTotalHits());
            if (searchHitList.size() > 0) {
                searchResult
                        .setResultsStart(start)
                        .setResultsEnd(searchHitList.size() + start - 1);
            }

            for (SearchHit searchHit : searchHitList) {
                com.liferay.portal.search.document.Document doc = searchHit.getDocument();
                long userId = doc.getLong(Field.USER_ID);
                User user = UserLocalServiceUtil.getUser(userId);
                users.add(user);
            }

            searchResult.setData(users);
        } catch (NoSuchRoleException e) {
            searchResult.fail(e);
            _log.error(e.getMessage());
        } catch (Exception e) {
            searchResult.fail(e);
            _log.error(e);
        }
        return searchResult;
    }

    private long[] _getGroupIds(long[] rolesIds) {
        List<Long> groupIds = new ArrayList<>();

        for (long roleId : rolesIds) {
            List<Group> groups = GroupLocalServiceUtil.getRoleGroups(roleId);
            for (Group group : groups) {
                groupIds.add(group.getClassPK());
            }
        }

        return ArrayUtil.toLongArray(groupIds);
    }

    private long[] _getRolesIds(long companyId, String names) throws PortalException {
        List<Long> rolesIds = new ArrayList<>();

        if (Validator.isBlank(names)) {
            return ArrayUtil.toLongArray(rolesIds);
        }

        String[] splits = names.split(",");
        for (String roleName : splits) {
            if (!Validator.isBlank(roleName)) {
                Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
                rolesIds.add(role.getRoleId());
            }
        }

        return ArrayUtil.toLongArray(rolesIds);
    }

    private SearchHits _getSearchHits(long comapanyId, String keyword,
                                      int start, int end, long[] rolesIds, long[] userGroupsIds) {
        BooleanQuery booleanQuery = queries.booleanQuery();
        List<Query> queryList = new ArrayList<>();

        _log.debug("Searching hits with params [ keyword:" + keyword + ", roles:" +
                rolesIds.toString() + ", groups:" + userGroupsIds.toString() + ", start:" + start + ", end:" + end + "]");

        for (long roleId : rolesIds) {
            if (roleId > 0) {
                queryList.add(queries.match("roleIds", roleId));
            }
        }

        for (long userGroupId : userGroupsIds) {
            queryList.add(queries.match("userGroupIds", userGroupId));
        }

        booleanQuery.addShouldQueryClauses(queryList.toArray(new Query[]{}));
        if(queryList.size()>0) {
            booleanQuery.setMinimumShouldMatch(1);
        }

        booleanQuery.addMustQueryClauses(
                queries.match(Field.STATUS, WorkflowConstants.STATUS_APPROVED)
        );

        SearchRequestBuilder searchRequestBuilder =
                searchRequestBuilderFactory.builder();
        searchRequestBuilder.emptySearchEnabled(true);

        searchRequestBuilder.withSearchContext(
                searchContext -> {
                    searchContext.setAttribute(Field.STATUS, WorkflowConstants.STATUS_APPROVED);
                    searchContext.setStart(start);
                    searchContext.setEnd(end);
                    searchContext.setEntryClassNames(new String[]{User.class.getName()});
                    searchContext.setCompanyId(comapanyId);
                    searchContext.setKeywords(keyword);
                    searchContext.setSorts(
                            new Sort("lastName_sortable", false),
                            new Sort("firstName_sortable", false),
                            new Sort("screenName_sortable", false)
                    );
                });

        SearchRequest searchRequest =
                searchRequestBuilder.query(booleanQuery).build();

        SearchResponse searchResponse = searcher.search(searchRequest);
        return searchResponse.getSearchHits();
    }

    @Reference
    protected Queries queries;
    @Reference
    protected SearchRequestBuilderFactory searchRequestBuilderFactory;
    @Reference
    protected Searcher searcher;
}
