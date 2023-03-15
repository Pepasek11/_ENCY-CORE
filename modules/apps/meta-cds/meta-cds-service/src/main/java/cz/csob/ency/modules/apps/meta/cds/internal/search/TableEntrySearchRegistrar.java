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

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.liferay.portal.search.spi.model.result.contributor.ModelVisibilityContributor;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import cz.csob.ency.modules.apps.meta.cds.model.TableEntry;

/**
 * TableEntry Search Registrar
 *
 * Registers the TableEntry entity with Liferay's search framework.
 *
 * @author Miroslav Čermák
 */
@Component(
	immediate = true,
	service = {}
)
public class TableEntrySearchRegistrar {

	@Activate
	protected void activate(BundleContext bundleContext) {
		_serviceRegistration = modelSearchRegistrarHelper.register(
			TableEntry.class, bundleContext,
			modelSearchDefinition -> {
				modelSearchDefinition.setDefaultSelectedFieldNames(
					Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT,
					Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.GROUP_ID,
					Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID, Field.TITLE, Field.UID);
			modelSearchDefinition.setDefaultSelectedLocalizedFieldNames(Field.TITLE, Field.CONTENT);

			modelSearchDefinition.setModelIndexWriteContributor(modelIndexWriterContributor);
			modelSearchDefinition.setModelSummaryContributor(modelSummaryContributor);
			modelSearchDefinition.setModelVisibilityContributor(modelVisibilityContributor);
		});
	}

	@Deactivate
	protected void deactivate() {
		_serviceRegistration.unregister();
	}

	@Reference(target = "(indexer.class.name=cz.csob.ency.modules.apps.meta.cds.model.TableEntry)")
	protected ModelIndexerWriterContributor<TableEntry> modelIndexWriterContributor;

	@Reference
	protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

	@Reference(target = "(indexer.class.name=cz.csob.ency.modules.apps.meta.cds.model.TableEntry)")
	protected ModelSummaryContributor modelSummaryContributor;

	@Reference(target = "(indexer.class.name=cz.csob.ency.modules.apps.meta.cds.model.TableEntry)")
	protected ModelVisibilityContributor modelVisibilityContributor;

	private ServiceRegistration<?> _serviceRegistration;
}