/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package cz.csob.ency.modules.apps.meta.cds.model.impl;

import cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry;

import java.util.Objects;

/**
 * The extended model implementation for the ColumnEntry service. Represents a row in the &quot;MetaCds_ColumnEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry</code> interface.
 * </p>
 *
 * @author "Miroslav Čermák"
 */
public class ColumnEntryImpl extends ColumnEntryBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a column entry model instance should use the {@link cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry} interface instead.
     */
    public ColumnEntryImpl() {
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) return false;
        ColumnEntry entry = (ColumnEntry) object;

        if (
                this.getCompanyId() == entry.getCompanyId()
                        && this.getGroupId() == entry.getGroupId()
                        && Objects.equals(this.getColumnType(), entry.getColumnType())
                        && Objects.equals(this.getColumnName(), entry.getColumnName())
                        && this.getColumnPosition() == entry.getColumnPosition()
                        && Objects.equals(this.getColumnFullName(), entry.getColumnFullName())
                        && this.getTableEntryId() == entry.getTableEntryId()
                        && Objects.equals(this.getTableName(), entry.getTableName())
                        && Objects.equals(this.getSystemName(), entry.getSystemName())
                        && Objects.equals(this.getDatabaseName(), entry.getDatabaseName())
                        && Objects.equals(this.getDescription(), entry.getDescription())
                        && Objects.equals(this.getDataType(), entry.getDataType())
                        && this.getDataSize() == entry.getDataSize()
                        && this.getIsPrimaryKey() == entry.getIsPrimaryKey()
                        && this.getIsNotNull() == entry.getIsNotNull()
                        && this.getIsActive() == entry.getIsActive()
        ) {
            return true;
        }

        return false;
    }

}