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
package cz.csob.ency.cds.demands.internal.search.index.contributor;

import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import cz.csob.ency.cds.demands.constants.CdsDemandType;
import cz.csob.ency.cds.demands.constants.CdsDemandWorkflowConstants;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.cds.demands.service.CdsDemandLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;

/**
 * CdsDemand Model Indexer Writer Contributor
 *
 * This class is used during bulk reindexing to identify records to reindex.
 *
 * @author Miroslav Čermák
 */
@Component(
        immediate = true,
        property = "indexer.class.name=cz.csob.ency.cds.demands.model.CdsDemand",
        service = ModelIndexerWriterContributor.class
)
public class CdsDemandModelIndexerWriterContributor implements ModelIndexerWriterContributor<CdsDemand> {

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
            // dynamicQuery.add(statusProperty.in(statuses));
        });

        // add any matched entry into the documents to index.
        batchIndexingActionable.setPerformActionMethod((CdsDemand entry) -> {
            batchIndexingActionable.addDocuments(modelIndexerWriterDocumentHelper.getDocument(entry));
        });
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
                _cdsDemandLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(CdsDemand entry) {
        return entry.getCompanyId();
    }

    @Override
    public IndexerWriterMode getIndexerWriterMode(CdsDemand entry) {

        String state = entry.getState();

		String[] DELETE_STATES = {
				CdsDemandWorkflowConstants.STATE_ZRUSENO,
				CdsDemandWorkflowConstants.STATE_POZASTAVENO_BAN,
				CdsDemandWorkflowConstants.STATE_POZASTAVENO_SPOC,
		};



        if (Arrays.stream(DELETE_STATES).anyMatch(s -> s.equals(state))) {
            return IndexerWriterMode.DELETE;
        }

        return IndexerWriterMode.UPDATE;
    }
    @Reference
    protected CdsDemandLocalService _cdsDemandLocalService;

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory;
}