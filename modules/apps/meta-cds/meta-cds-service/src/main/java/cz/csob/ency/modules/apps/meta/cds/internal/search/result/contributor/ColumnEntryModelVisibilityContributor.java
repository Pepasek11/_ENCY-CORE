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

import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.search.spi.model.result.contributor.ModelVisibilityContributor;
import cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry;
import cz.csob.ency.modules.apps.meta.cds.service.ColumnEntryLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * ColumnEntry Model Visibility Contributor
 *
 * Controls the visibility of entities that can be attached to other asset types in the search context.
 *
 * @author Miroslav Čermák
 */
@Component(
	immediate = true,
	property = "indexer.class.name=cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry",
	service = ModelVisibilityContributor.class
)
public class ColumnEntryModelVisibilityContributor implements ModelVisibilityContributor {

	@Override
	public boolean isVisible(long classPK, int status) {

		ColumnEntry entry = _columnEntryLocalService.fetchColumnEntry(classPK);

		if (entry == null) {
			return false;
		}

		return isVisible(entry.getStatus(), status);
	}

	@Reference
	protected ColumnEntryLocalService _columnEntryLocalService;
}