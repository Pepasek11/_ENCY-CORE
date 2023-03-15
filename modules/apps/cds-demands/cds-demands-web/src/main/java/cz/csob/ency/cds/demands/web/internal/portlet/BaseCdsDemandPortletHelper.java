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

import aQute.bnd.annotation.metatype.Configurable;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import cz.csob.ency.cds.demands.configuration.CdsDemandsConfiguration;
import cz.csob.ency.cds.demands.internal.util.RenderHelperUtils;
import cz.csob.ency.cds.demands.service.CdsDemandLocalService;
import cz.csob.ency.cds.demands.web.internal.constants.CdsDemandWebKeys;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

@Component(
        configurationPid = "cz.csob.ency.cds.demands.configuration.CdsDemandsConfiguration",
        immediate = true, service = BaseCdsDemandPortletHelper.class
)
public class BaseCdsDemandPortletHelper {
    private static final Log _log = LogFactoryUtil.getLog(
            BaseCdsDemandPortletHelper.class);

    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(
                WebKeys.THEME_DISPLAY);

        User user = themeDisplay.getUser();
        long userDomainId = cdsDemandLocalService.getUserDomainId(user);

        PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

        Map<String, Object> context = HashMapBuilder.<String, Object>put(
                "portalURL", portal.getPortalURL(renderRequest)
        ).put(
                "historyRouterBasePath", cdsDemandConfiguration.historyRouterBasePath()
        ).put(
                "includeContextPath", renderRequest.getAttribute("javax.servlet.include.context_path")
        ).put(
                "isCdsUser", renderHelper.isCdsUser(user)
        ).put(
                "isEncyAdmin", renderHelper.isEncyAdmin(user)
        ).put(
                "isLorm", renderHelper.isLorm(user)
        ).put(
                "isOmniAdmin", renderHelper.isOmniadmin(themeDisplay.getUserId())
        ).put(
                "allowedAttachmentFileExtensions", cdsDemandConfiguration.allowedAttachmentsFileExtensions()
        ).put(
                "maxAttachmentFileSize", cdsDemandConfiguration.maxAttachmentSize() * 1024 * 1024
        ).put(
                "namespace", portletDisplay.getNamespace()
        ).put(
                "portletId", themeDisplay.getPortletDisplay().getId()
        ).put(
                "selectoptions", HashMapBuilder.<String, Object>put(
                        "type", renderHelper.getTypeSelectList(themeDisplay.getLocale())
                ).put(
                        "priority", renderHelper.getPrioritySelectList(themeDisplay.getLocale())
                ).put(
                        "frequency", renderHelper.getFrequencySelectList(themeDisplay.getLocale())
                ).put(
                        "fivetracks", renderHelper.getFivetracksSelectList(themeDisplay.getLocale())
                ).build()
        ).put(
                "siteKey", String.valueOf(themeDisplay.getScopeGroupId())
        ).put(
                "userId", String.valueOf(themeDisplay.getUserId())
        ).put(
                "userDomainId", String.valueOf(userDomainId)
        ).build();

        renderRequest.setAttribute(
                CdsDemandWebKeys.DISPLAY_CONTEXT, context);
    }

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        cdsDemandConfiguration = Configurable.createConfigurable(
                CdsDemandsConfiguration.class, properties);
    }

    protected volatile CdsDemandsConfiguration cdsDemandConfiguration;
    @Reference
    protected CdsDemandLocalService cdsDemandLocalService;
    @Reference
    protected Portal portal;
    @Reference
    protected RenderHelperUtils renderHelper;
}
