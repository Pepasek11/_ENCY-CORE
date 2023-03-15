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

import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.EditPortletProvider;
import com.liferay.portal.kernel.portlet.ManagePortletProvider;
import com.liferay.portal.kernel.portlet.ViewPortletProvider;
import cz.csob.ency.cds.demands.constants.CdsDemandPortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * CdsDemand Portlet Provider
 *
 * This class returns Portlet ID for PortletProviderUtil which is used in TrashHandler.
 * This Portlet ID is used to create a restore URL.
 *
 * @author Miroslav Čermák
 */
@Component(
	immediate = true,
	property = "model.class.name=cz.csob.ency.cds.demands.model.CdsDemand",
	service = {
		EditPortletProvider.class, ManagePortletProvider.class,
		ViewPortletProvider.class
	}
)
public class CdsDemandAdminPortletProvider
	extends BasePortletProvider
	implements EditPortletProvider, ManagePortletProvider, ViewPortletProvider {

	@Override
	public String getPortletName() {
		return CdsDemandPortletKeys.CDSDEMAND_ADMIN;
	}

}