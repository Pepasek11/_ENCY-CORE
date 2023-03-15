package cz.csob.ency.modules.e3.entry.internal.search.spi.model.query.contributor;

import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.search.spi.model.query.contributor.ModelPreFilterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchSettings;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=cz.csob.ency.modules.e3.entry.model.E3Entry",
        service = ModelPreFilterContributor.class
)
public class E3EntryModelPreFilterContributor implements ModelPreFilterContributor {

    @Override
    public void contribute(
            BooleanFilter booleanFilter, ModelSearchSettings modelSearchSettings,
            SearchContext searchContext) {
/*
        _workflowStatusModelPreFilterContributor.contribute(
                booleanFilter, modelSearchSettings, searchContext);

 */
    }

    // @todo implemets our workflow prefilter contributor?
    @Reference(target = "(model.pre.filter.contributor.id=WorkflowStatus)")
    private ModelPreFilterContributor _workflowStatusModelPreFilterContributor;

}
