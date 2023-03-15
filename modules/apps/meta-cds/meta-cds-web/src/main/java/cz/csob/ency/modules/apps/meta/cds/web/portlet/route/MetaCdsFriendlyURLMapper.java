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
package cz.csob.ency.modules.apps.meta.cds.web.portlet.route;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import cz.csob.ency.modules.apps.meta.cds.constants.MetaCdsPortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * FriendlyURL Mapper
 *
 * This is used to mapping Friendly URL to the portlet. This class is reqired for routing path correctly for Asset Publisher.
 *
 * @author Miroslav Čermák
 */
@Component(
	property = {
		"com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
		"javax.portlet.name=" + MetaCdsPortletKeys.METACDS
	},
	service = FriendlyURLMapper.class
)
public class MetaCdsFriendlyURLMapper extends DefaultFriendlyURLMapper {

	@Override
	public String getMapping() {
		return _MAPPING;
	}

	private static final String _MAPPING = "metacds";

}