package cz.csob.ency.modules.e3.entry.internal.search.spi.model.index.contributor;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.entry.service.E3EntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=cz.csob.ency.modules.e3.entry.model.E3Entry",
        service = ModelIndexerWriterContributor.class
)
public class E3EntryIndexerWriterContributor implements ModelIndexerWriterContributor<E3Entry> {
    private static final Log _log = LogFactoryUtil.getLog(E3EntryIndexerWriterContributor.class);

    @Override
    public void customize(
            BatchIndexingActionable batchIndexingActionable,
            ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        //  _log.info("Entry indexer: Customize " );

        batchIndexingActionable.setPerformActionMethod(
                (E3Entry entry) -> {
                    batchIndexingActionable.addDocuments(
                            modelIndexerWriterDocumentHelper.getDocument(entry));
                });
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
                entryLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(E3Entry entry) {
        return entry.getCompanyId();
    }

    @Override
    public IndexerWriterMode getIndexerWriterMode(E3Entry entry) {
        if(! entry.isIndexable()) {
            return IndexerWriterMode.SKIP;
        }

        return IndexerWriterMode.UPDATE;

        /*
        if (entry.isApproved() || entry.isDraft() ||
                entry.isInTrash() || entry.isPending()) {

            return IndexerWriterMode.UPDATE;
        }

        if (!entry.isApproved() && !entry.isInTrash()) {
            return IndexerWriterMode.SKIP;
        }
        return IndexerWriterMode.DELETE;
        */
    }

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory
            dynamicQueryBatchIndexingActionableFactory;
    @Reference
    protected E3EntryLocalService entryLocalService;

}