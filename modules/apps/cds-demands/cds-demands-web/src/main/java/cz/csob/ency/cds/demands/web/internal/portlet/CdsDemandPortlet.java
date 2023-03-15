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
package cz.csob.ency.cds.demands.web.internal.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import cz.csob.ency.cds.demands.constants.CdsDemandPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

/**
 * Portlet
 *
 * @author yasuflatland
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.add-default-resource=true",
                "com.liferay.portlet.application-type=full-page-application",
                "com.liferay.portlet.application-type=widget",
                "com.liferay.portlet.css-class-wrapper=portlet-cdsdemand",
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.layout-cacheable=true",
                "com.liferay.portlet.preferences-owned-by-group=true",
                "com.liferay.portlet.private-request-attributes=false",
                "com.liferay.portlet.private-session-attributes=false",
                "com.liferay.portlet.render-weight=50",
                "com.liferay.portlet.scopeable=true",
                "com.liferay.portlet.struts-path=cdsdemand",
                "com.liferay.portlet.use-default-template=true",
                "javax.portlet.display-name=CdsDemand",
                "javax.portlet.expiration-cache=0",
                "javax.portlet.init-param.always-display-default-configuration-icons=true",
                "javax.portlet.init-param.template-path=/META-INF/resources/",
                "javax.portlet.init-param.view-template=/cds_demand/view.jsp",
                "javax.portlet.name=" + CdsDemandPortletKeys.CDSDEMAND,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=guest,power-user,user"
        },
        service = Portlet.class
)
public class CdsDemandPortlet extends MVCPortlet {
        @Override
        public void doView(
                RenderRequest renderRequest, RenderResponse renderResponse)
                throws IOException, PortletException {

                helper.doView(renderRequest, renderResponse);
                super.doView(renderRequest, renderResponse);
        }

        @Reference
        protected BaseCdsDemandPortletHelper helper;
}

