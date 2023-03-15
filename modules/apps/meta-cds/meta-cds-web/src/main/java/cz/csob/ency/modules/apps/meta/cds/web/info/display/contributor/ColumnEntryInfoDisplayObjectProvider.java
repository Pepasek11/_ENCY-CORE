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
import cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry;

import java.util.Locale;


/**
 * ColumnEntry Asset Info Display Contributor
 * 
 * @author Miroslav Čermák
 *
 */

public class ColumnEntryInfoDisplayObjectProvider
    implements InfoDisplayObjectProvider<ColumnEntry> {

public ColumnEntryInfoDisplayObjectProvider(ColumnEntry columnEntry)
        throws PortalException {
        _columnEntry = columnEntry;
        _assetEntry = _getAssetEntry(columnEntry);

    }

    @Override
    public long getClassNameId() {
        return _assetEntry.getClassNameId();
    }

    @Override
    public long getClassPK() {
        return _columnEntry.getPrimaryKey();
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
    public ColumnEntry getDisplayObject() {
        return _columnEntry;
    }

    @Override
    public long getGroupId() {
        return _columnEntry.getGroupId();
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

    private AssetEntry _getAssetEntry(ColumnEntry columnEntry)
        throws PortalException {

        AssetRendererFactory<?> assetRendererFactory =
            AssetRendererFactoryRegistryUtil.
                getAssetRendererFactoryByClassNameId(
                    PortalUtil.getClassNameId(ColumnEntry.class));

        return assetRendererFactory.getAssetEntry(
            ColumnEntry.class.getName(), columnEntry.getPrimaryKey());
    }

    private final AssetEntry _assetEntry;
    private final ColumnEntry _columnEntry;

}
