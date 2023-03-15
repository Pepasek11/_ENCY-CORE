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

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import cz.csob.ency.cds.demands.constants.CdsDemandPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * PanelApp
 *
 * This class is used to display a portet in the product menu
 *
 * @author Miroslav Čermák
 */
@Component(
    immediate = true,
    property = {
        "panel.app.order:Integer=101", //TODO : this number determine the order in the panel
        "panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
    },
    service = PanelApp.class
)
public class CdsDemandPanelApp extends BasePanelApp  {

	@Override
	public String getPortletId() {
		return CdsDemandPortletKeys.CDSDEMAND_ADMIN;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + CdsDemandPortletKeys.CDSDEMAND_ADMIN + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}