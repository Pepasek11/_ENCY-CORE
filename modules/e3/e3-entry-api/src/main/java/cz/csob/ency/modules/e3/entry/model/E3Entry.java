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
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the E3Entry service. Represents a row in the &quot;E3Entry&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see E3EntryModel
 * @generated
 */
@ImplementationClassName("cz.csob.ency.modules.e3.entry.model.impl.E3EntryImpl")
@ProviderType
public interface E3Entry extends E3EntryModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>cz.csob.ency.modules.e3.entry.model.impl.E3EntryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<E3Entry, Long> ENTRY_ID_ACCESSOR =
		new Accessor<E3Entry, Long>() {

			@Override
			public Long get(E3Entry e3Entry) {
				return e3Entry.getEntryId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<E3Entry> getTypeClass() {
				return E3Entry.class;
			}

		};

	public String getAppCode();

	public String getDescription();

	public String getSummary();

	public java.io.Serializable getValue(String key);

	public Boolean isIndexable();

	public Boolean isVersioned();

	public cz.csob.ency.modules.e3.entry.model.E3Entry setValue(
		String key, java.io.Serializable value);

	public cz.csob.ency.modules.e3.entry.model.E3Entry setValues(
		javax.portlet.ActionRequest actionRequest);

}