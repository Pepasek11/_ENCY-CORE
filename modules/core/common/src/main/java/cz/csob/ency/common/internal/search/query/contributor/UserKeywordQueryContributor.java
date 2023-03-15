package cz.csob.ency.common.internal.search.query.contributor;


import com.liferay.normalizer.Normalizer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.search.generic.WildcardQueryImpl;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Add term normalized screen name
 *
 * @author Miroslav Čermák
 */
@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.portal.kernel.model.User",
        service = KeywordQueryContributor.class
)
public class UserKeywordQueryContributor implements KeywordQueryContributor {

    @Override
    public void contribute(
            String keywords, BooleanQuery booleanQuery,
            KeywordQueryContributorHelper keywordQueryContributorHelper) {

        SearchContext searchContext =
                keywordQueryContributorHelper.getSearchContext();

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, "normalizedDisplayName", false);

        if (Validator.isNotNull(keywords)) {
            try {
                keywords = StringUtil.toLowerCase(keywords);
                keywords = normalizer.normalizeToAscii(keywords);

                booleanQuery.add(
                        _getTrailingWildcardQuery("normalizedDisplayName", keywords),
                        BooleanClauseOccur.SHOULD);
            } catch (ParseException parseException) {
                throw new SystemException(parseException);
            }
        }
    }

    private WildcardQuery _getTrailingWildcardQuery(
            String field, String value) {

        return new WildcardQueryImpl(field, value + StringPool.STAR);
    }

    @Reference
    protected Normalizer normalizer;
    @Reference
    protected QueryHelper queryHelper;

}