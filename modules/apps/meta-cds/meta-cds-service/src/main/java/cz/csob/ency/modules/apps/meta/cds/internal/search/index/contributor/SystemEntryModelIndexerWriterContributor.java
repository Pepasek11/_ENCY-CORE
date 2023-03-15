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
package cz.csob.ency.modules.apps.meta.cds.internal.search.index.contributor;

import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import cz.csob.ency.modules.apps.meta.cds.model.SystemEntry;
import cz.csob.ency.modules.apps.meta.cds.service.SystemEntryLocalService;

/**
 * SystemEntry Model Indexer Writer Contributor
 *
 * This class is used during bulk reindexing to identify records to reindex.
 *
 * @author Miroslav Čermák
 */
@Component(
	immediate = true,
	property = "indexer.class.name=cz.csob.ency.modules.apps.meta.cds.model.SystemEntry",
	service = ModelIndexerWriterContributor.class
)
public class SystemEntryModelIndexerWriterContributor implements ModelIndexerWriterContributor<SystemEntry> {

	@Override
	public void customize(BatchIndexingActionable batchIndexingActionable, ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

		// TODO: add criteria to the DQ to select the entities to include in the reindex.
		batchIndexingActionable.setAddCriteriaMethod(dynamicQuery -> {
			Property statusProperty = PropertyFactoryUtil.forName("status");

			Integer[] statuses = {
				WorkflowConstants.STATUS_APPROVED,
				WorkflowConstants.STATUS_IN_TRASH
			};

			// reindex any entry that is approved or in the trash
			dynamicQuery.add(statusProperty.in(statuses));
		});

		// add any matched entry into the documents to index.
		batchIndexingActionable.setPerformActionMethod((SystemEntry entry) -> {
			batchIndexingActionable.addDocuments(modelIndexerWriterDocumentHelper.getDocument(entry));
		});
	}

	@Override
	public IndexerWriterMode getIndexerWriterMode(SystemEntry entry) {

		// TODO: Update as necessary to control the indexer writer mode for the given entry.

		int status = entry.getStatus();

		if ((status == WorkflowConstants.STATUS_APPROVED) || (status == WorkflowConstants.STATUS_IN_TRASH) || (status == WorkflowConstants.STATUS_DRAFT)) {
			return IndexerWriterMode.UPDATE;
		}

		return IndexerWriterMode.DELETE;
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
			_systemEntryLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(SystemEntry entry) {
		return entry.getCompanyId();
	}

	@Reference
	protected SystemEntryLocalService _systemEntryLocalService;

	@Reference
	protected DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory;
}