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

package cz.csob.ency.connection.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ConnectionDefinition service. Represents a row in the &quot;ency_connection&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ConnectionDefinitionModel
 * @generated
 */
@ImplementationClassName(
	"cz.csob.ency.connection.model.impl.ConnectionDefinitionImpl"
)
@ProviderType
public interface ConnectionDefinition
	extends ConnectionDefinitionModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>cz.csob.ency.connection.model.impl.ConnectionDefinitionImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ConnectionDefinition, Long>
		CONNECTION_ID_ACCESSOR = new Accessor<ConnectionDefinition, Long>() {

			@Override
			public Long get(ConnectionDefinition connectionDefinition) {
				return connectionDefinition.getConnectionId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ConnectionDefinition> getTypeClass() {
				return ConnectionDefinition.class;
			}

		};

	public String getStatus();

}