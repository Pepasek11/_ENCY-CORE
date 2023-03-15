package cz.csob.ency.modules.e3.web.internal.bulk.selection;


import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.bulk.selection.BaseContainerEntryBulkSelection;
import com.liferay.bulk.selection.BulkSelection;
import com.liferay.bulk.selection.BulkSelectionFactory;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.interval.IntervalActionProcessor;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.entry.service.E3EntryLocalService;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupE3EntryBulkSelection extends BaseContainerEntryBulkSelection<E3Entry> {

    public GroupE3EntryBulkSelection(
            long groupId, Map<String, String[]> parameterMap,
            E3EntryLocalService entryService,
            AssetEntryLocalService assetEntryLocalService) {

        super(groupId, parameterMap);

        _groupId = groupId;
        _entryService = entryService;
        _assetEntryLocalService = assetEntryLocalService;
    }

    @Override
    public <E extends PortalException> void forEach(
            UnsafeConsumer<E3Entry, E> unsafeConsumer)
            throws PortalException {

        IntervalActionProcessor<E3Entry> entryIntervalActionProcessor =
                new IntervalActionProcessor<>((int)getSize());

        entryIntervalActionProcessor.setPerformIntervalActionMethod(
                (start, end) -> {
                    List<E3Entry> entries =
                            new LinkedList<>();
                    /* @todo uncomment when group support will be added
                            _entryService.getGroupEntries(
                                    _groupId, WorkflowConstants.STATUS_APPROVED, start,
                                    end);

                     */

                    for (E3Entry entry : entries) {
                        unsafeConsumer.accept(entry);
                    }

                    return null;
                });

        entryIntervalActionProcessor.performIntervalActions();
    }

    @Override
    public Class<? extends BulkSelectionFactory>
    getBulkSelectionFactoryClass() {

        return E3EntryBulkSelectionFactory.class;
    }

    @Override
    public long getSize() {
        return 0;
        /* @todo uncomment when group support will be added
        return _entryService.getGroupEntriesCount(
                _groupId, WorkflowConstants.STATUS_APPROVED);

         */
    }

    @Override
    public BulkSelection<AssetEntry> toAssetEntryBulkSelection() {
        return new E3EntryAssetEntryBulkSelection(
                this, _assetEntryLocalService);
    }

    private final AssetEntryLocalService _assetEntryLocalService;
    private final E3EntryLocalService _entryService;
    private final long _groupId;

}