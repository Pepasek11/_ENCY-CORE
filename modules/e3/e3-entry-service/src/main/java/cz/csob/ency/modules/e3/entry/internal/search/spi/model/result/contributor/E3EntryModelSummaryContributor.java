package cz.csob.ency.modules.e3.entry.internal.search.spi.model.result.contributor;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import cz.csob.ency.modules.e3.entry.internal.search.E3SearchField;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

@Component(
        immediate = true,
        property = "indexer.class.name=cz.csob.ency.modules.e3.entry.model.E3Entry",
        service = ModelSummaryContributor.class
)
public class E3EntryModelSummaryContributor implements ModelSummaryContributor {

    @Override
    public Summary getSummary(
            Document document, Locale locale, String snippet) {

        Summary summary = createSummary(document);
        summary.setMaxContentLength(200);
        return summary;
    }

    private Summary createSummary(Document document) {
        String prefix = Field.SNIPPET + StringPool.UNDERLINE;
        String title = document.get(prefix + Field.TITLE, Field.TITLE);
        String content = document.get(prefix + E3SearchField.DESCRIPTION, E3SearchField.DESCRIPTION);

        return new Summary(title, content);
    }

}