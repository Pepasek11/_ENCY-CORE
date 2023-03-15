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
package cz.csob.ency.modules.apps.meta.cds.web.info.display.contributor.portlet;

import com.liferay.asset.display.page.portlet.BaseAssetDisplayPageFriendlyURLResolver;
import com.liferay.portal.kernel.portlet.FriendlyURLResolver;

import org.osgi.service.component.annotations.Component;

/**
 *
 * @author Miroslav Čermák
 *
 */
@Component(service = FriendlyURLResolver.class)
public class TableEntryAssetDisplayPageFriendlyURLResolver
    extends BaseAssetDisplayPageFriendlyURLResolver {

	@Override
	public String getURLSeparator() {
		return "/tableentry/";
	}
}
