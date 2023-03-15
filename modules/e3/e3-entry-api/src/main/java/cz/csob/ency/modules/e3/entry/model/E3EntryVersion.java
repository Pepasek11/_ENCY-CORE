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

package cz.csob.ency.modules.e3.entry.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the E3EntryVersion service. Represents a row in the &quot;E3EntryVersion&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see E3EntryVersionModel
 * @generated
 */
@ImplementationClassName(
	"cz.csob.ency.modules.e3.entry.model.impl.E3EntryVersionImpl"
)
@ProviderType
public interface E3EntryVersion extends E3EntryVersionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>cz.csob.ency.modules.e3.entry.model.impl.E3EntryVersionImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<E3EntryVersion, Long>
		E3_ENTRY_VERSION_ID_ACCESSOR = new Accessor<E3EntryVersion, Long>() {

			@Override
			public Long get(E3EntryVersion e3EntryVersion) {
				return e3EntryVersion.getE3EntryVersionId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<E3EntryVersion> getTypeClass() {
				return E3EntryVersion.class;
			}

		};

}