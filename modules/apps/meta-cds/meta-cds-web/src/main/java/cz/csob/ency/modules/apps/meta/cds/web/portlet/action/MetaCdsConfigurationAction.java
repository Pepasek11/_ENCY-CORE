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

import aQute.bnd.annotation.metatype.Configurable;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.modules.apps.meta.cds.constants.MetaCdsPortletKeys;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * SystemEntry Configuraion Aciton
 *
 * Determine the scope of the portlet configuration in DS properties of Portlet
 * class The default of this generator is Portlet Instance scope.
 *
 * Look at the elements preferences-company-wide, preferences-unique-per-layout
 * and preferences-owned-by-group to determine the right scope. The following
 * table maps out the scopes:
 *
 * liferay-portlet.xml Scope preferences-company-wide=true Company
 * preferences-owned-by-group=true AND preferences-unique-per-layout=false Group
 * preferences-owned-by-group=true AND preferences-unique-per-layout=true
 * Portlet Instance
 *
 * @author Miroslav Čermák
 *
 */
@Component(
        configurationPid = MetaCdsPortletKeys.METACDS_CONFIG,
        configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true,
        property = "javax.portlet.name=" + MetaCdsPortletKeys.METACDS,
        service = ConfigurationAction.class
)
public class MetaCdsConfigurationAction extends DefaultConfigurationAction {

    private static final Log _log = LogFactoryUtil.getLog(
            MetaCdsConfigurationAction.class);

    @Override
    public String getJspPath(HttpServletRequest httpServletRequest) {
        return "/meta_cds/configuration.jsp";
    }

    @Override
    public void include(
            PortletConfig portletConfig, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse)
            throws Exception {

        if (_log.isDebugEnabled()) {
            _log.debug("SystemEntry Portlet configuration include");
        }

        httpServletRequest.setAttribute(
                MetaCdsConfiguration.class.getName(), _metaCdsConfiguration);

        super.include(portletConfig, httpServletRequest, httpServletResponse);
    }

    @Override
    public void processAction(
            PortletConfig portletConfig, ActionRequest actionRequest,
            ActionResponse actionResponse)
            throws Exception {

        int prefsViewType = ParamUtil.getInteger(
                actionRequest, MetaCdsConfiguration.CONF_PREFS_VIEW_TYPE,
                Integer.valueOf(MetaCdsConfiguration.PREFS_VIEW_TYPE_DEFAULT));
        String dateFormat = ParamUtil.getString(
                actionRequest, MetaCdsConfiguration.CONF_DATE_FORMAT);
        String datetimeFormat = ParamUtil.getString(
                actionRequest, MetaCdsConfiguration.CONF_DATETIME_FORMAT);

        if (_log.isDebugEnabled()) {
            _log.debug("Prefs View Type :" + prefsViewType);
            _log.debug("Date Format     :" + dateFormat);
            _log.debug("Date Time Format:" + datetimeFormat);
        }

        List<String> errors = new ArrayList<>();

        if (validate(dateFormat, datetimeFormat, errors)) {
            setPreference(
                    actionRequest, MetaCdsConfiguration.CONF_PREFS_VIEW_TYPE,
                    String.valueOf(prefsViewType));
            setPreference(
                    actionRequest, MetaCdsConfiguration.CONF_DATE_FORMAT,
                    dateFormat);
            setPreference(
                    actionRequest, MetaCdsConfiguration.CONF_DATETIME_FORMAT,
                    datetimeFormat);

            SessionMessages.add(actionRequest, "prefsSuccess");
        }

        super.processAction(portletConfig, actionRequest, actionResponse);
    }

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        _metaCdsConfiguration = Configurable.createConfigurable(
                MetaCdsConfiguration.class, properties);
    }

    /**
     * Validate Preference
     *
     * @param dateFormat Date Format
     * @param datetimeFormat Date Time Format
     * @param errors
     * @return boolean
     */
    protected boolean validate(
            String dateFormat, String datetimeFormat, List<String> errors) {

        boolean valid = true;

        if (Validator.isNull(dateFormat)) {
            errors.add("date-format-required");
            valid = false;
        } else if (Validator.isNull(datetimeFormat)) {
            errors.add("datetime-format.required");
            valid = false;
        }

        return valid;
    }
    private volatile MetaCdsConfiguration _metaCdsConfiguration;

}