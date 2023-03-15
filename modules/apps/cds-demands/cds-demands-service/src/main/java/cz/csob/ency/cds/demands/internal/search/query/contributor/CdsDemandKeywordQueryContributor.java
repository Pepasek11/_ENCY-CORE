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
package cz.csob.ency.cds.demands.internal.search.query.contributor;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * CdsDemand Keyword Query Contributor
 *
 * Contributes clauses to the ongoing search query to control how the model entities are searched.
 *
 * @author Miroslav Čermák
 */
@Component(
        immediate = true,
        property = "indexer.class.name=cz.csob.ency.cds.demands.model.CdsDemand",
        service = KeywordQueryContributor.class
)
public class CdsDemandKeywordQueryContributor implements KeywordQueryContributor {

    @Override
    public void contribute(String keywords, BooleanQuery booleanQuery, KeywordQueryContributorHelper keywordQueryContributorHelper) {
        SearchContext searchContext = keywordQueryContributorHelper.getSearchContext();

        // TODO: Adjust as necessary to support the search for the entity

        queryHelper.addSearchTerm(booleanQuery, searchContext, Field.ARTICLE_ID, false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, Field.CLASS_PK, false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, Field.ENTRY_CLASS_PK, false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, Field.USER_NAME, false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, Field.CONTENT, true);
        queryHelper.addSearchTerm(booleanQuery, searchContext, Field.DESCRIPTION, true);
        queryHelper.addSearchTerm(booleanQuery, searchContext, Field.TITLE, true);
        queryHelper.addSearchTerm(booleanQuery, searchContext, Field.SUBTITLE, false);

        queryHelper.addSearchTerm(booleanQuery, searchContext, "demandId", false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "uuid", true);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "bioeId", false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "type", false);

        // must be modified, because field "priority" breaks up search
        queryHelper.addSearchTerm(booleanQuery, searchContext, "priority_", false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "workEstimate", false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "acceptedWorkEstimate", false);

        queryHelper.addSearchTerm(booleanQuery, searchContext, "requestedDelivery", false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "expectedDelivery", false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "acceptedDelivery", false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "gdprInfo", false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "requestorId", false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "requestedForId", false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "domainId", false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "domainName", false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "banId", false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "spocId", false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "banName", false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, "spocName", false);


    }

    @Reference
    protected QueryHelper queryHelper;
}