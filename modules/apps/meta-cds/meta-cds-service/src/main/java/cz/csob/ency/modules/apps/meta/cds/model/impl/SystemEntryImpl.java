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

import cz.csob.ency.modules.apps.meta.cds.model.SystemEntry;

import java.util.Objects;

/**
 * The extended model implementation for the SystemEntry service. Represents a row in the &quot;MetaCds_SystemEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>cz.csob.ency.modules.apps.meta.cds.model.SystemEntry</code> interface.
 * </p>
 *
 * @author "Miroslav Čermák"
 */
public class SystemEntryImpl extends SystemEntryBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a system entry model instance should use the {@link cz.csob.ency.modules.apps.meta.cds.model.SystemEntry} interface instead.
     */
    public SystemEntryImpl() {
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) return false;
        SystemEntry entry = (SystemEntry) object;

        if (
                this.getIsActive() == entry.isIsActive()
                        && this.getIsSelfBi() == entry.isIsSelfBi()
                        && this.getIsSlaSigned() == entry.isIsSlaSigned()
                        && this.getCompanyId() == entry.getCompanyId()
                        && this.getGroupId() == entry.getGroupId()
                        && this.getSystemCode() == entry.getSystemCode()
                        && Objects.equals(this.getSystemName(), entry.getSystemName())
                        && Objects.equals(this.getSystemTitle(), entry.getSystemTitle())
                        && Objects.equals(this.getSystemType(), entry.getSystemType())
                        && Objects.equals(this.getDescription(), entry.getDescription())
                        && Objects.equals(this.getStewardName(), entry.getStewardName())
                        && Objects.equals(this.getStewardId(), entry.getStewardId())
                        && Objects.equals(this.getStewardDepartment(), entry.getStewardDepartment())
                        && Objects.equals(this.getBusinessOwnerName(), entry.getBusinessOwnerName())
                        && Objects.equals(this.getBusinessOwnerId(), entry.getBusinessOwnerId())
                        && Objects.equals(this.getContactPersonName(), entry.getContactPersonName())
                        && Objects.equals(this.getContactPersonId(), entry.getContactPersonId())
                        && Objects.equals(this.getSandboxName(), entry.getSandboxName())
                        && Objects.equals(this.getGestorDepartmentId(), entry.getGestorDepartmentId())
                        && Objects.equals(this.getGestorDepartmentName(), entry.getGestorDepartmentName())
                        && Objects.equals(this.getRole(), entry.getRole())
                        && Objects.equals(this.getSnowAssetTagId(), entry.getSnowAssetTagId())
                        && Objects.equals(this.getSnowAssetTagName(), entry.getSnowAssetTagName())
        ) {
            return true;
        }

        return false;
    }
}