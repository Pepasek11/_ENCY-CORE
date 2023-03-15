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

import cz.csob.ency.modules.apps.meta.cds.model.TableEntry;

import java.util.Objects;

/**
 * The extended model implementation for the TableEntry service. Represents a row in the &quot;MetaCds_TableEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>cz.csob.ency.modules.apps.meta.cds.model.TableEntry</code> interface.
 * </p>
 *
 * @author "Miroslav Čermák"
 */
public class TableEntryImpl extends TableEntryBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a table entry model instance should use the {@link cz.csob.ency.modules.apps.meta.cds.model.TableEntry} interface instead.
     */
    public TableEntryImpl() {
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) return false;

        TableEntry entry = (TableEntry) object;

        if (
                this.getCompanyId() == entry.getCompanyId()
                        && this.getGroupId() == entry.getGroupId()
                        && Objects.equals(this.getTableName(), entry.getTableName())
                        && Objects.equals(this.getTableFullName(), entry.getTableFullName())
                        && Objects.equals(this.getTableType(), entry.getTableType())
                        && Objects.equals(this.getTableDatabase(), entry.getTableDatabase())
                        && this.getSystemEntryId() == entry.getSystemEntryId()
                        && Objects.equals(this.getSystemName(), entry.getSystemName())
                        && Objects.equals(this.getDescription(), entry.getDescription())
                        && Objects.equals(this.getDsaUrl(), entry.getDsaUrl())
                        && Objects.equals(this.getContactPersonName(), entry.getContactPersonName())
                        && Objects.equals(this.getContactPersonId(), entry.getContactPersonId())
                        && Objects.equals(this.getSpecificationOwnerName(), entry.getSpecificationOwnerName())
                        && Objects.equals(this.getSpecificationOwnerId(), entry.getSpecificationOwnerId())
                        && Objects.equals(this.getUnstructuredClause(), entry.getUnstructuredClause())
                        && this.getIsActive() == entry.getIsActive()
        ) {
            return true;
        }

        return false;
    }
}