// 
//  //
/**
*  Copyright (C) 2021 Yasuyuki Takeo All rights reserved.
*
*  This program is free software: you can redistribute it and/or modify
*  it under the terms of the GNU Lesser General Public License as published by
*  the Free Software Foundation, either version 3 of the License, or
*  (at your option) any later version.
*
*  This program is distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
*  GNU Lesser General Public License for more details.
*/
//  //
package cz.csob.ency.modules.apps.meta.cds.web.info.display.contributor;

import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetTagLocalServiceUtil;
import com.liferay.info.display.contributor.InfoDisplayObjectProvider;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import cz.csob.ency.modules.apps.meta.cds.model.TableEntry;

import java.util.Locale;


/**
 * TableEntry Asset Info Display Contributor
 * 
 * @author Miroslav Čermák
 *
 */

public class TableEntryInfoDisplayObjectProvider
    implements InfoDisplayObjectProvider<TableEntry> {

public TableEntryInfoDisplayObjectProvider(TableEntry tableEntry)
        throws PortalException {
        _tableEntry = tableEntry;
        _assetEntry = _getAssetEntry(tableEntry);

    }

    @Override
    public long getClassNameId() {
        return _assetEntry.getClassNameId();
    }

    @Override
    public long getClassPK() {
        return _tableEntry.getPrimaryKey();
    }

    @Override
    public long getClassTypeId() {
        return _assetEntry.getClassTypeId();
    }

    @Override
    public String getDescription(Locale locale) {
        return _assetEntry.getDescription(locale);
    }

    @Override
    public TableEntry getDisplayObject() {
        return _tableEntry;
    }

    @Override
    public long getGroupId() {
        return _tableEntry.getGroupId();
    }

    @Override
    public String getKeywords(Locale locale) {
        String[] assetTagNames = AssetTagLocalServiceUtil.getTagNames(
            _assetEntry.getClassName(), _assetEntry.getClassPK());
        String[] assetCategoryNames =
            AssetCategoryLocalServiceUtil.getCategoryNames(
                _assetEntry.getClassName(), _assetEntry.getClassPK());

        String[] keywords =
            new String[assetTagNames.length + assetCategoryNames.length];

        ArrayUtil.combine(assetTagNames, assetCategoryNames, keywords);

        return StringUtil.merge(keywords);
    }

    @Override
    public String getTitle(Locale locale) {
        return _assetEntry.getTitle(locale);
    }

    @Override
    public String getURLTitle(Locale locale) {
        AssetRenderer<?> assetRenderer = _assetEntry.getAssetRenderer();

        return assetRenderer.getUrlTitle(locale);
    }

    private AssetEntry _getAssetEntry(TableEntry tableEntry)
        throws PortalException {

        AssetRendererFactory<?> assetRendererFactory =
            AssetRendererFactoryRegistryUtil.
                getAssetRendererFactoryByClassNameId(
                    PortalUtil.getClassNameId(TableEntry.class));

        return assetRendererFactory.getAssetEntry(
            TableEntry.class.getName(), tableEntry.getPrimaryKey());
    }

    private final AssetEntry _assetEntry;
    private final TableEntry _tableEntry;

}
