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
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the CdsDemand service. Represents a row in the &quot;CdsDemands_CdsDemand&quot; database table, with each column mapped to a property of this class.
 *
 * @author Miroslav Čermák
 * @see CdsDemandModel
 * @generated
 */
@ImplementationClassName("cz.csob.ency.cds.demands.model.impl.CdsDemandImpl")
@ProviderType
public interface CdsDemand extends CdsDemandModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>cz.csob.ency.cds.demands.model.impl.CdsDemandImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CdsDemand, Long> DEMAND_ID_ACCESSOR =
		new Accessor<CdsDemand, Long>() {

			@Override
			public Long get(CdsDemand cdsDemand) {
				return cdsDemand.getDemandId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<CdsDemand> getTypeClass() {
				return CdsDemand.class;
			}

		};

	public int[] getFiveTracksArray();

	public void setFiveTracks(long[] tracks);

	public int getStatus();

	/**
	 * Compares two object by significant values. Technical values (creation, modifiaction dates ...)
	 * are ignored
	 *
	 * @param that
	 * @return
	 */
	public boolean isSubstantiallyEqual(
		cz.csob.ency.cds.demands.model.CdsDemand that);

}