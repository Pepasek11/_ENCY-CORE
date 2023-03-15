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
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import cz.csob.ency.modules.apps.meta.cds.model.TableEntry;
import org.osgi.service.component.annotations.Component;

/**
 * TableEntry Model Document Contributor
 * <p>
 * This class is used to contribute fields to the document to be indexed.
 *
 * @author Miroslav Čermák
 */
@Component(
        immediate = true,
        property = "indexer.class.name=cz.csob.ency.modules.apps.meta.cds.model.TableEntry",
        service = ModelDocumentContributor.class
)
public class TableEntryModelDocumentContributor implements ModelDocumentContributor<TableEntry> {

    @Override
    public void contribute(Document document, TableEntry entry) {

        // TODO : These fields should be modified according to your requirements.

        document.addText(Field.CAPTION, entry.getTableFullName());
        document.addText(
                Field.CONTENT,
                entry.getTableFullName() + StringPool.NEW_LINE +
                        entry.getTableDatabase() + StringPool.NEW_LINE +
                        entry.getSystemName() + StringPool.NEW_LINE +
                        entry.getDescription());
        document.addText(Field.DESCRIPTION, entry.getDescription());
        document.addText(Field.SUBTITLE, entry.getTableFullName());
        document.addText(Field.TITLE, entry.getTableName());

        document.addDate(Field.MODIFIED_DATE, entry.getModifiedDate());

        document.addNumber("tableEntryId", entry.getTableEntryId());
        document.addText("tableName", entry.getTableName());
        document.addText("tableFullName", entry.getTableFullName());
        document.addText("tableType", entry.getTableType());
        document.addText("tableDatabase", entry.getTableDatabase());
        document.addNumber("systemEntryId", entry.getSystemEntryId());
        document.addText("systemName", entry.getSystemName());
        document.addText("description", entry.getDescription());
        document.addText("dsaUrl", entry.getDsaUrl());
        document.addText("contactPersonName", entry.getContactPersonName());
        document.addText("contactPersonId", entry.getContactPersonId());
        document.addText("specificationOwnerName", entry.getSpecificationOwnerName());
        document.addText("specificationOwnerId", entry.getSpecificationOwnerId());
        document.addText("unstructuredClause", entry.getUnstructuredClause());
    }
}