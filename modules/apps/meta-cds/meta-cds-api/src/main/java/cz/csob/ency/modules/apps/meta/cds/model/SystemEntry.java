/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package cz.csob.ency.modules.apps.meta.cds.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the SystemEntry service. Represents a row in the &quot;MetaCds_SystemEntry&quot; database table, with each column mapped to a property of this class.
 *
 * @author "Miroslav Čermák"
 * @see SystemEntryModel
 * @generated
 */
@ImplementationClassName(
	"cz.csob.ency.modules.apps.meta.cds.model.impl.SystemEntryImpl"
)
@ProviderType
public interface SystemEntry extends PersistedModel, SystemEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>cz.csob.ency.modules.apps.meta.cds.model.impl.SystemEntryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SystemEntry, Long> SYSTEM_ENTRY_ID_ACCESSOR =
		new Accessor<SystemEntry, Long>() {

			@Override
			public Long get(SystemEntry systemEntry) {
				return systemEntry.getSystemEntryId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<SystemEntry> getTypeClass() {
				return SystemEntry.class;
			}

		};

	@Override
	public boolean equals(Object object);

}