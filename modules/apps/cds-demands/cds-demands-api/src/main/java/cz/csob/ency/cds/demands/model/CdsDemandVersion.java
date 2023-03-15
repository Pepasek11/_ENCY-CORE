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

package cz.csob.ency.cds.demands.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the CdsDemandVersion service. Represents a row in the &quot;CdsDemands_CdsDemandVersion&quot; database table, with each column mapped to a property of this class.
 *
 * @author Miroslav Čermák
 * @see CdsDemandVersionModel
 * @generated
 */
@ImplementationClassName(
	"cz.csob.ency.cds.demands.model.impl.CdsDemandVersionImpl"
)
@ProviderType
public interface CdsDemandVersion extends CdsDemandVersionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>cz.csob.ency.cds.demands.model.impl.CdsDemandVersionImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CdsDemandVersion, Long>
		CDS_DEMAND_VERSION_ID_ACCESSOR =
			new Accessor<CdsDemandVersion, Long>() {

				@Override
				public Long get(CdsDemandVersion cdsDemandVersion) {
					return cdsDemandVersion.getCdsDemandVersionId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<CdsDemandVersion> getTypeClass() {
					return CdsDemandVersion.class;
				}

			};

}