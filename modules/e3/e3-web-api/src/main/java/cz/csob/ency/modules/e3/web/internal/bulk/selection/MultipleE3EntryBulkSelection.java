package cz.csob.ency.modules.e3.web.internal.bulk.selection;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.bulk.selection.BaseMultipleEntryBulkSelection;
import com.liferay.bulk.selection.BulkSelection;
import com.liferay.bulk.selection.BulkSelectionFactory;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.entry.service.E3EntryLocalService;

import java.util.Map;
public class MultipleE3EntryBulkSelection
        extends BaseMultipleEntryBulkSelection<E3Entry> {

    public MultipleE3EntryBulkSelection(
            long[] entryIds, Map<String, String[]> parameterMap,
            E3EntryLocalService entryService,
            AssetEntryLocalService assetEntryLocalService) {

        super(entryIds, parameterMap);

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
    protected E3Entry fetchEntry(long entryId) {
        try {
            return _entryService.getEntry(entryId);
        }
        catch (NoSuchE3EntryException noSuchEntryException) {
            if (_log.isWarnEnabled()) {
                _log.warn(noSuchEntryException, noSuchEntryException);
            }

            return null;
        }
        catch (PortalException portalException) {
            return ReflectionUtil.throwException(portalException);
        }
    }

    private static final Log _log = LogFactoryUtil.getLog(
            MultipleE3EntryBulkSelection.class);

    private final AssetEntryLocalService _assetEntryLocalService;
    private final E3EntryLocalService _entryService;

}