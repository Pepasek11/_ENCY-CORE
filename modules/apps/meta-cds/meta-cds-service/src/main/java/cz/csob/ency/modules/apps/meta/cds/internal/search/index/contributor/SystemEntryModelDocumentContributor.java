// 
/*   */
/**
 * Copyright (C) 2021 Yasuyuki Takeo All rights reserved.
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 */
/*  */
package cz.csob.ency.modules.apps.meta.cds.internal.search.index.contributor;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import cz.csob.ency.modules.apps.meta.cds.model.SystemEntry;
import org.osgi.service.component.annotations.Component;

/**
 * SystemEntry Model Document Contributor
 * <p>
 * This class is used to contribute fields to the document to be indexed.
 *
 * @author Miroslav Čermák
 */
@Component(
        immediate = true,
        property = "indexer.class.name=cz.csob.ency.modules.apps.meta.cds.model.SystemEntry",
        service = ModelDocumentContributor.class
)
public class SystemEntryModelDocumentContributor implements ModelDocumentContributor<SystemEntry> {

    @Override
    public void contribute(Document document, SystemEntry entry) {

        // TODO : These fields should be modified according to your requirements.

        document.addText(Field.CAPTION, entry.getSystemName());
        document.addText(
                Field.CONTENT,
                HtmlUtil.stripHtml(entry.getSystemName() + StringPool.NEW_LINE +
                        entry.getSystemTitle() + StringPool.NEW_LINE +
                        entry.getSystemCode() + StringPool.NEW_LINE +
                        entry.getDescription()
                ));
        document.addText(Field.DESCRIPTION, entry.getDescription());
        document.addText(Field.SUBTITLE, entry.getSystemTitle());
        document.addText(Field.TITLE, entry.getSystemName());

        document.addDate(Field.MODIFIED_DATE, entry.getModifiedDate());

        document.addNumber("systemEntryId", entry.getSystemEntryId());
        document.addNumber("systemCode", entry.getSystemCode());
        document.addText("systemName", entry.getSystemName());
        document.addText("systemTitle", entry.getSystemTitle());
        document.addText("systemType", entry.getSystemType());
        document.addText("description", entry.getDescription());
        document.addText("stewardName", entry.getStewardName());
        document.addText("stewardId", entry.getStewardId());
        document.addText("stewardDepartment", entry.getStewardDepartment());
        document.addText("businessOwnerName", entry.getBusinessOwnerName());
        document.addText("businessOwnerId", entry.getBusinessOwnerId());
        document.addText("contactPersonName", entry.getContactPersonName());
        document.addText("contactPersonId", entry.getContactPersonId());
        document.addText("sandboxName", entry.getSandboxName());
        document.addText("gestorDepartmentId", entry.getGestorDepartmentId());
        document.addText("gestorDepartmentName", entry.getGestorDepartmentName());
        document.addText("role", entry.getRole());
        document.addText("snowAssetTagId", entry.getSnowAssetTagId());
        document.addText("snowAssetTagName", entry.getSnowAssetTagName());
    }
}