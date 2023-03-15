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

package cz.csob.ency.delegations.web.internal.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.Portal;
import cz.csob.ency.delegations.constants.DelegationsPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

/**
 * CdsDemand Admin Portlet
 *
 * @author Miroslav Čermák
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.css-class-wrapper=portlet-delegations",
                "com.liferay.portlet.display-category=category.hidden",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.preferences-unique-per-layout=true",
                "com.liferay.portlet.preferences-owned-by-group=false",
                "com.liferay.portlet.private-request-attributes=false",
                "com.liferay.portlet.private-session-attributes=false",
                "com.liferay.portlet.render-weight=50",
                "com.liferay.portlet.scopeable=false",
                "com.liferay.portlet.struts-path=delegations",
                "com.liferay.portlet.use-default-template=true",
                "javax.portlet.display-name=Delegations Admin",
                "javax.portlet.expiration-cache=0",
                "javax.portlet.init-param.template-path=/META-INF/resources/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + DelegationsPortletKeys.DELEGATIONS_ADMIN,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=administrator,power-user"
        },
        service = Portlet.class
)
public class DelegationsAdminPortlet extends MVCPortlet {

    @Override
    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        super.doView(renderRequest, renderResponse);
    }

    @Reference
    protected Portal portal;
}
