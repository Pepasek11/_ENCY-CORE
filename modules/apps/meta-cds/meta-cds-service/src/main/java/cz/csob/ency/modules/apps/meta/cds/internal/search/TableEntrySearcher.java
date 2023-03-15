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
package cz.csob.ency.modules.apps.meta.cds.internal.search;

import com.liferay.portal.kernel.search.BaseSearcher;
import com.liferay.portal.kernel.search.Field;
import org.osgi.service.component.annotations.Component;
import cz.csob.ency.modules.apps.meta.cds.model.TableEntry;

/**
 * TableEntry Searcher
 *
 * Sets up the searcher instance for TableEntry.
 *
 * @author Miroslav Čermák
 */
@Component(
	immediate = true,
	property = "model.class.name=cz.csob.ency.modules.apps.meta.cds.model.TableEntry",
	service = BaseSearcher.class
)
public class TableEntrySearcher extends BaseSearcher {

	public static final String CLASS_NAME = TableEntry.class.getName();

	public TableEntrySearcher() {

		// TODO: Adjust the fields as necessary.
		setDefaultSelectedFieldNames(
			Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT,
			Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.GROUP_ID,
			Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID, Field.TITLE, Field.UID);
		setFilterSearch(true);
		setPermissionAware(true);

		// TODO Adjust localized fields as well
		setDefaultSelectedLocalizedFieldNames(Field.TITLE, Field.CONTENT);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}
}