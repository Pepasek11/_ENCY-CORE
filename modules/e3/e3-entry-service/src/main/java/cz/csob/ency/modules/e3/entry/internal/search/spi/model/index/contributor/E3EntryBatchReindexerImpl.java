package cz.csob.ency.modules.e3.entry.internal.search.spi.model.index.contributor;

import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.indexer.IndexerDocumentBuilder;
import com.liferay.portal.search.indexer.IndexerWriter;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = E3EntryBatchReindexer.class)
public class E3EntryBatchReindexerImpl implements E3EntryBatchReindexer {

    @Override
    public void reindex(String appClass, long companyId) {
        BatchIndexingActionable batchIndexingActionable =
                indexerWriter.getBatchIndexingActionable();

        batchIndexingActionable.setAddCriteriaMethod(dynamicQuery -> {
            Property appClassPropery = PropertyFactoryUtil.forName(
                    "appClass");

            dynamicQuery.add(appClassPropery.eq(appClass));
        });

        batchIndexingActionable.setCompanyId(companyId);

        batchIndexingActionable.setPerformActionMethod((E3Entry entry) -> {
            Document document = indexerDocumentBuilder.getDocument(entry);

            batchIndexingActionable.addDocuments(document);
        });

        batchIndexingActionable.performActions();

    }

    @Reference(target = "(indexer.class.name=cz.csob.ency.modules.e3.entry.model.E3Entry)")
    protected IndexerDocumentBuilder indexerDocumentBuilder;

    @Reference(target = "(indexer.class.name=cz.csob.ency.modules.e3.entry.model.E3Entry)")
    protected IndexerWriter<E3Entry> indexerWriter;

}
