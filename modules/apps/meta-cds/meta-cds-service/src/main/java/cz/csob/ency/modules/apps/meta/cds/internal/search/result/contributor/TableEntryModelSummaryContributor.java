// 
/*   */ 
/**
*  Copyright (C) 2021 Yasuyuki Takeo All rights reserved.
*
*  This program is free software: you can redistribute it and/or modify
*  it under the terms of the GNU Lesser General Public License as published by
*  the Free Software Foundation, either version 3 of the License, or
*  (at your option) any later version.
*
*  This program is distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
*  GNU Lesser General Public License for more details.
*/
/*  */ 
package cz.csob.ency.modules.apps.meta.cds.internal.search.result.contributor;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

/**
 * TableEntry Model Summary Contributor
 *
 * Manipulates the Summary object for each entity search result.
 *
 * @author Miroslav Čermák
 */
@Component(
	immediate = true,
	property = "indexer.class.name=cz.csob.ency.modules.apps.meta.cds.model.TableEntry",
	service = ModelSummaryContributor.class
)
public class TableEntryModelSummaryContributor implements ModelSummaryContributor {

	@Override
	public Summary getSummary(Document document, Locale locale, String snippet) {
		String languageId = LocaleUtil.toLanguageId(locale);

		// TODO: Modify as necessary to use the corrected fields for the summary

		return _createSummary(document, Field.CONTENT, Field.TITLE );
	}

	protected Summary _createSummary(Document document, String contentField, String titleField) {

		String prefix = Field.SNIPPET + StringPool.UNDERLINE;

		String title = document.get(prefix + titleField, titleField);
		String content = document.get(prefix + contentField, contentField);

		Summary summary = new Summary(title,content);

		summary.setMaxContentLength(200);

		return summary;
	}
}