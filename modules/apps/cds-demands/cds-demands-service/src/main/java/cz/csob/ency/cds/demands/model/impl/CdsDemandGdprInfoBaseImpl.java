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

package cz.csob.ency.cds.demands.model.impl;

import cz.csob.ency.cds.demands.model.CdsDemandGdprInfo;
import cz.csob.ency.cds.demands.service.CdsDemandGdprInfoLocalServiceUtil;

/**
 * The extended model base implementation for the CdsDemandGdprInfo service. Represents a row in the &quot;CdsDemands_CdsDemandGdprInfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CdsDemandGdprInfoImpl}.
 * </p>
 *
 * @author Miroslav Čermák
 * @see CdsDemandGdprInfoImpl
 * @see CdsDemandGdprInfo
 * @generated
 */
public abstract class CdsDemandGdprInfoBaseImpl
	extends CdsDemandGdprInfoModelImpl implements CdsDemandGdprInfo {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cds demand gdpr info model instance should use the <code>CdsDemandGdprInfo</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			CdsDemandGdprInfoLocalServiceUtil.addCdsDemandGdprInfo(this);
		}
		else {
			CdsDemandGdprInfoLocalServiceUtil.updateCdsDemandGdprInfo(this);
		}
	}

}