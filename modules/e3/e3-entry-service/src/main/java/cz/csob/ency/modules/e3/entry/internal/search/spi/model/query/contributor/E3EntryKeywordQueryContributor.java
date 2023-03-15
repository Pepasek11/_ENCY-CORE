package cz.csob.ency.modules.e3.entry.internal.search.spi.model.query.contributor;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import cz.csob.ency.modules.e3.entry.internal.search.E3SearchField;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=cz.csob.ency.modules.e3.entry.model.E3Entry",
        service = KeywordQueryContributor.class
)
public class E3EntryKeywordQueryContributor implements KeywordQueryContributor {
    private static final Log _log = LogFactoryUtil.getLog(E3EntryKeywordQueryContributor.class);

    @Override
    public void contribute(
            String keywords, BooleanQuery booleanQuery,
            KeywordQueryContributorHelper keywordQueryContributorHelper) {

        SearchContext searchContext =
                keywordQueryContributorHelper.getSearchContext();

        queryHelper.addSearchTerm(booleanQuery, searchContext, E3SearchField.NAME, false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, E3SearchField.EXTENDED_NAME, false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, E3SearchField.CONTENT, false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, E3SearchField.DESCRIPTION, false);

        //@todo add support for fields defined in query

     //   _log.info("in contributor {keywords: "+keywords+"}, {searchContext:"+searchContext.getAttributes().toString()
     //           +"}, {" + booleanQuery.toString()+"}");
    }
    @Reference
    protected QueryHelper queryHelper;

}