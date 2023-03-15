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

import com.liferay.asset.constants.AssetWebKeys;
import com.liferay.asset.util.AssetHelper;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.trash.TrashHelper;
import com.liferay.trash.util.TrashWebKeys;
import cz.csob.ency.modules.apps.meta.cds.constants.MetaCdsPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

/**
 * SystemEntry Admin Portlet
 *
 * @author Miroslav Čermák
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.add-default-resource=true",
                "com.liferay.portlet.css-class-wrapper=portlet-metacds",
                "com.liferay.portlet.display-category=category.hidden",
                "com.liferay.portlet.header-portlet-css=/meta_cds_admin/css/main.css",
                "com.liferay.portlet.icon=/icons/metacds.png",
                "com.liferay.portlet.preferences-unique-per-layout=falset",
                "com.liferay.portlet.preferences-owned-by-group=true",
                "com.liferay.portlet.private-request-attributes=false",
                "com.liferay.portlet.private-session-attributes=false",
                "com.liferay.portlet.render-weight=50",
                "com.liferay.portlet.scopeable=false",
                "com.liferay.portlet.use-default-template=true",
                "javax.portlet.display-name=Meta Cds Admin",
                "javax.portlet.expiration-cache=0",
                "javax.portlet.init-param.mvc-command-names-default-views=/metacds/view",
                "javax.portlet.init-param.portlet-title-based-navigation=true",
                "javax.portlet.init-param.template-path=/META-INF/resources/",
                "javax.portlet.name=" + MetaCdsPortletKeys.METACDS_ADMIN,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=administrator"
        },
        service = Portlet.class
)
public class MetaCdsAdminPortlet extends MVCPortlet {

    @Override
    public void render(
            RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        renderRequest.setAttribute(AssetWebKeys.ASSET_HELPER, _assetHelper);
        renderRequest.setAttribute(TrashWebKeys.TRASH_HELPER, _trashHelper);

        super.render(renderRequest, renderResponse);
    }

    @Reference
    private AssetHelper _assetHelper;

    @Reference
    private TrashHelper _trashHelper;

}