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
import cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry;
import org.osgi.service.component.annotations.Component;

/**
 * ColumnEntry Model Document Contributor
 * <p>
 * This class is used to contribute fields to the document to be indexed.
 *
 * @author Miroslav Čermák
 */
@Component(
        immediate = true,
        property = "indexer.class.name=cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry",
        service = ModelDocumentContributor.class
)
public class ColumnEntryModelDocumentContributor implements ModelDocumentContributor<ColumnEntry> {

    @Override
    public void contribute(Document document, ColumnEntry entry) {

        // TODO : These fields should be modified according to your requirements.

        document.addText(Field.CAPTION, entry.getColumnFullName());
        document.addText(
                Field.CONTENT,
                entry.getColumnFullName()
                        + StringPool.NEW_LINE + entry.getDescription());
        document.addText(Field.DESCRIPTION, entry.getDescription());
        document.addText(Field.SUBTITLE, entry.getColumnFullName());
        document.addText(Field.TITLE, entry.getColumnName());

        document.addDate(Field.MODIFIED_DATE, entry.getModifiedDate());

        document.addNumber("columnEntryId", entry.getColumnEntryId());
        document.addText("columnType", entry.getColumnType());
        document.addText("columnName", entry.getColumnName());
        document.addNumber("columnPosition", entry.getColumnPosition());
        document.addText("columnFullName", entry.getColumnFullName());
        document.addNumber("tableEntryId", entry.getTableEntryId());
        document.addText("tableName", entry.getTableName());
        document.addText("systemName", entry.getSystemName());
        document.addText("databaseName", entry.getDatabaseName());
        document.addText("description", entry.getDescription());
        document.addText("dataType", entry.getDataType());
        document.addNumber("dataSize", entry.getDataSize());
    }
}