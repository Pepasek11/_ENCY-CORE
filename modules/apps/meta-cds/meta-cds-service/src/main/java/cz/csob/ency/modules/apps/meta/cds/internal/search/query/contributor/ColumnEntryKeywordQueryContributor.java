// 
/*   */
/**
 * Copyright (C) 2021 Yasuyuki Takeo All rights reserved.
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 */
/*  */
package cz.csob.ency.modules.apps.meta.cds.internal.search.query.contributor;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * ColumnEntry Keyword Query Contributor
 *
 * Contributes clauses to the ongoing search query to control how the model entities are searched.
 *
 * @author Miroslav Čermák
 */
@Component(
        immediate = true,
        property = "indexer.class.name=cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry",
        service = KeywordQueryContributor.class
)
public class ColumnEntryKeywordQueryContributor implements KeywordQueryContributor {

    @Override
    public void contribute(String keywords, BooleanQuery booleanQuery, KeywordQueryContributorHelper keywordQueryContributorHelper) {
        SearchContext searchContext = keywordQueryContributorHelper.getSearchContext();

        // TODO: Adjust as necessary to support the search for the entity

        queryHelper.addSearchTerm(booleanQuery, searchContext, Field.ARTICLE_ID, false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, Field.CLASS_PK, false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, Field.ENTRY_CLASS_PK, false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, Field.USER_NAME, false);
        queryHelper.addSearchLocalizedTerm(booleanQuery, searchContext, Field.CONTENT, false);
        queryHelper.addSearchLocalizedTerm(booleanQuery, searchContext, Field.DESCRIPTION, false);
        queryHelper.addSearchLocalizedTerm(booleanQuery, searchContext, Field.TITLE, false);
        queryHelper.addSearchLocalizedTerm(booleanQuery, searchContext, Field.SUBTITLE, false);

        queryHelper.addSearchTerm(booleanQuery, searchContext, "columnEntryId", false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "columnType", false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "columnName", true);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "columnPositon", false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "columnFullName", true);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "tableEntryId", false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "tableName", true);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "systemName", false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "databaseName", false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "description", false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "dataType", false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "dataSize", false);
    }

    @Reference
    protected QueryHelper queryHelper;
}