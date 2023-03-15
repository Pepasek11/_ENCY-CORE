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
package cz.csob.ency.modules.apps.meta.cds.web.portlet;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Portlet;
import cz.csob.ency.modules.apps.meta.cds.constants.MetaCdsPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

/**
 * PanelApp
 * <p>
 * This class is used to display a portet in the product menu
 *
 * @author Miroslav Čermák
 */
@Component(
        immediate = true,
        property = {
                "panel.app.order:Integer=90",
                "panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
        },
        service = PanelApp.class
)
public class MetaCdsPanelApp extends BasePanelApp {
    private static final Log _log = LogFactoryUtil.getLog(BasePanelApp.class);

    // TODO: Zjistit proc to v GA4 nepreklada pak nechat standardni logiku
    @Override
    public String getLabel(Locale locale) {
        return "Meta CDS";
    }

    @Override
    public String getPortletId() {
        return MetaCdsPortletKeys.METACDS_ADMIN;
    }

    @Override
    @Reference(
            target = "(javax.portlet.name=" + MetaCdsPortletKeys.METACDS_ADMIN + ")",
            unbind = "-"
    )
    public void setPortlet(Portlet portlet) {
        super.setPortlet(portlet);
    }
}