// 
//  //
/**
 * Copyright (C) 2021 Yasuyuki Takeo All rights reserved.
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 */
//  //
package cz.csob.ency.modules.apps.meta.cds.web.portlet.action;

import com.liferay.portal.kernel.portlet.BasePortletLayoutFinder;
import com.liferay.portal.kernel.portlet.PortletLayoutFinder;
import cz.csob.ency.modules.apps.meta.cds.constants.MetaCdsPortletKeys;
import org.osgi.service.component.annotations.Component;

/**
 * @author Miroslav Čermák
 */
@Component(
        immediate = true,
        property = "model.class.name=cz.csob.ency.modules.apps.meta.cds.model.SystemEntry",
        service = PortletLayoutFinder.class
)
public class SystemEntryPortletLayoutFinder extends BasePortletLayoutFinder {

    private static final String[] _PORTLET_IDS = {MetaCdsPortletKeys.METACDS};

    @Override
    protected String[] getPortletIds() {
        return _PORTLET_IDS;
    }

}