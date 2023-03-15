package cz.csob.ency.modules.e3.web.internal.bulk.selection;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.bulk.selection.BaseSingleEntryBulkSelection;
import com.liferay.bulk.selection.BulkSelection;
import com.liferay.bulk.selection.BulkSelectionFactory;
import com.liferay.portal.kernel.exception.PortalException;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.entry.service.E3EntryLocalService;

import java.util.Map;

public class SingleE3EntryBulkSelection extends BaseSingleEntryBulkSelection<E3Entry> {

    public SingleE3EntryBulkSelection(
            long entryId, Map<String, String[]> parameterMap,
            E3EntryLocalService entryService,
            AssetEntryLocalService assetEntryLocalService) {

        super(entryId, parameterMap);

        _entryId = entryId;
        _entryService = entryService;
        _assetEntryLocalService = assetEntryLocalService;
    }

    @Override
    public Class<? extends BulkSelectionFactory>
    getBulkSelectionFactoryClass() {

        return E3EntryBulkSelectionFactory.class;
    }

    @Override
    public BulkSelection<AssetEntry> toAssetEntryBulkSelection() {
        return new E3EntryAssetEntryBulkSelection(
                this, _assetEntryLocalService);
    }

    @Override
    protected E3Entry getEntry() throws PortalException {
        return _entryService.getEntry(_entryId);
    }

    @Override
    protected String getEntryName() throws PortalException {
        E3Entry entry = getEntry();

        return entry.getName();
    }

    private final AssetEntryLocalService _assetEntryLocalService;
    private final E3EntryLocalService _entryService;
    private final long _entryId;

}
