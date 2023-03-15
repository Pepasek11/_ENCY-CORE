// 
//  //
/**
*  Copyright (C) 2021 Yasuyuki Takeo All rights reserved.
*
*  This program is free software: you can redistribute it and/or modify
*  it under the terms of the GNU Lesser General Public License as published by
*  the Free Software Foundation, either version 3 of the License, or
*  (at your option) any later version.
*
*  This program is distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
*  GNU Lesser General Public License for more details.
*/
//  //
package cz.csob.ency.cds.demands.web.internal.portlet;

import com.liferay.portal.kernel.portlet.BasePortletLayoutFinder;
import com.liferay.portal.kernel.portlet.PortletLayoutFinder;
import cz.csob.ency.cds.demands.constants.CdsDemandPortletKeys;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = "model.class.name=cz.csob.ency.cds.demands.model.CdsDemand",
	service = PortletLayoutFinder.class
)
public class CdsDemandLayoutFinder extends BasePortletLayoutFinder {

	@Override
	protected String[] getPortletIds() {
		return _PORTLET_IDS;
	}

	private static final String[] _PORTLET_IDS = {CdsDemandPortletKeys.CDSDEMAND};

}