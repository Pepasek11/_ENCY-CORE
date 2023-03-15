package cz.csob.ency.modules.e3.web.internal.bulk.selection;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.bulk.selection.BulkSelection;
import com.liferay.bulk.selection.BulkSelectionFactory;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import cz.csob.ency.modules.e3.entry.model.E3Entry;

import java.io.Serializable;
import java.util.Map;

public class E3EntryAssetEntryBulkSelection implements BulkSelection<AssetEntry> {

    public E3EntryAssetEntryBulkSelection(
            BulkSelection<E3Entry> entryBulkSelection,
            AssetEntryLocalService assetEntryLocalService) {

        _entryBulkSelection = entryBulkSelection;
        _assetEntryLocalService = assetEntryLocalService;
    }

    @Override
    public <E extends PortalException> void forEach(
            UnsafeConsumer<AssetEntry, E> unsafeConsumer)
            throws PortalException {

        _entryBulkSelection.forEach(
                blogsEntry -> unsafeConsumer.accept(_toAssetEntry(blogsEntry)));
    }

    @Override
    public Class<? extends BulkSelectionFactory>
    getBulkSelectionFactoryClass() {

        return _entryBulkSelection.getBulkSelectionFactoryClass();
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return _entryBulkSelection.getParameterMap();
    }

    @Override
    public long getSize() throws PortalException {
        return _entryBulkSelection.getSize();
    }

    @Override
    public Serializable serialize() {
        return _entryBulkSelection.serialize();
    }

    @Override
    public BulkSelection<AssetEntry> toAssetEntryBulkSelection() {
        return this;
    }

    private AssetEntry _toAssetEntry(E3Entry entry) {
        try {
            return _assetEntryLocalService.getEntry(
                    E3Entry.class.getName(), entry.getEntryId());
        }
        catch (PortalException portalException) {
            return ReflectionUtil.throwException(portalException);
        }
    }

    private final AssetEntryLocalService _assetEntryLocalService;
    private final BulkSelection<E3Entry> _entryBulkSelection;

}