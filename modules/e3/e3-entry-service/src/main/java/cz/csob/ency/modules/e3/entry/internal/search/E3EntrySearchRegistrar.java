package cz.csob.ency.modules.e3.entry.internal.search;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.liferay.portal.search.spi.model.result.contributor.ModelVisibilityContributor;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = {})
public class E3EntrySearchRegistrar {

    @Activate
    protected void activate(BundleContext bundleContext) {
        _serviceRegistration = _modelSearchRegistrarHelper.register(
                E3Entry.class, bundleContext, modelSearchDefinition -> {
                    modelSearchDefinition.setDefaultSelectedFieldNames(
                            Field.CONTENT, E3SearchField.TITLE,E3SearchField.SUMMARY,
                            Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.MODIFIED_DATE,
                            Field.CREATE_DATE, Field.GROUP_ID, Field.UID
                    );

                    modelSearchDefinition.setModelIndexWriteContributor(
                            modelIndexWriterContributor);
                    modelSearchDefinition.setModelSummaryContributor(
                            _modelSummaryContributor);
                    modelSearchDefinition.setModelVisibilityContributor(
                            _modelVisibilityContributor);
                    modelSearchDefinition.setSelectAllLocales(true);
                    // @todo remove when permissons will be available
                    modelSearchDefinition.setSearchResultPermissionFilterSuppressed(true);
                });
    }

    @Deactivate
    protected void deactivate() {
        _serviceRegistration.unregister();
    }

    private static final Log _log = LogFactoryUtil.getLog(E3EntrySearchRegistrar.class);

    @Reference
    protected ModelSearchRegistrarHelper _modelSearchRegistrarHelper;

    @Reference(target = "(indexer.class.name=cz.csob.ency.modules.e3.entry.model.E3Entry)")
    protected ModelSummaryContributor _modelSummaryContributor;

    @Reference(target = "(indexer.class.name=cz.csob.ency.modules.e3.entry.model.E3Entry)")
    protected ModelIndexerWriterContributor<E3Entry> modelIndexWriterContributor;

    @Reference(
            target = "(indexer.class.name=cz.csob.ency.modules.e3.entry.model.E3Entry)"
    )
    private ModelVisibilityContributor _modelVisibilityContributor;

    private ServiceRegistration<?> _serviceRegistration;
}
