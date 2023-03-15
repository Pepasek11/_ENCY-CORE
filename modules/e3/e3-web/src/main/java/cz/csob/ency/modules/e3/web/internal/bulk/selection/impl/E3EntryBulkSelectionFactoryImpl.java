package cz.csob.ency.modules.e3.web.internal.bulk.selection.impl;

import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.bulk.selection.BulkSelection;
import com.liferay.bulk.selection.EmptyBulkSelection;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.StringUtil;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.entry.service.E3EntryLocalService;
import cz.csob.ency.modules.e3.web.internal.bulk.selection.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Map;

@Component(
        immediate = true,
        property = "model.class.name=cz.csob.ency.modules.e3.entry.model.E3Entry",
        service = {E3EntryBulkSelectionFactory.class}
)
public class E3EntryBulkSelectionFactoryImpl implements E3EntryBulkSelectionFactory {
    private static final Log _log = LogFactoryUtil.getLog(E3EntryBulkSelectionFactoryImpl.class);

    @Override
    public BulkSelection<E3Entry> create(
            Map<String, String[]> parameterMap) {

        boolean selectAll = MapUtil.getBoolean(parameterMap, "selectAll");

        if (selectAll) {
            long groupId = MapUtil.getLong(parameterMap, "groupId");

            return new GroupE3EntryBulkSelection(
                    groupId, parameterMap, _entryService,
                    _assetEntryLocalService);
        }

        long entryId = MapUtil.getLong(parameterMap, "entryId");

        if (entryId > 0) {
            return new SingleE3EntryBulkSelection(
                    entryId, parameterMap, _entryService,
                    _assetEntryLocalService);
        }

        long[] entryIds = GetterUtil.getLongValues(
                StringUtil.split(
                        MapUtil.getString(parameterMap, "deleteEntryIds")));

        if (ArrayUtil.isNotEmpty(entryIds)) {
            return new MultipleE3EntryBulkSelection(
                    entryIds, parameterMap, _entryService,
                    _assetEntryLocalService);
        }

        return new EmptyBulkSelection<>();
    }

    @Reference
    private AssetEntryLocalService _assetEntryLocalService;

    @Reference
    private E3EntryLocalService _entryService;


}