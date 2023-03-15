/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package cz.csob.ency.security.sso.token.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Michael C. Han
 * @author Mika Koivisto
 * https://github.com/liferay/liferay-portal/blob/master/modules/apps/portal-security-sso/portal-security-sso-token-api/src/main/java/com/liferay/portal/security/sso/token/configuration/TokenConfiguration.java
 */
@ExtendedObjectClassDefinition(category = "sso")
@Meta.OCD(
        id = "cz.csob.ency.security.sso.token.configuration.TokenConfiguration",
        name = "Ency Token SSO"
)
public interface TokenConfiguration {

    @Meta.AD(deflt = "false", name = "enabled", required = false)
    public boolean enabled();

    @Meta.AD(
            deflt = "auth-user", description = "user-token-name-help",
            name = "user-token-name", required = false
    )
    public String userTokenName();

    @Meta.AD(deflt = "false", name = "Allow Anonymous", required = false)
    public boolean allowAnonymous();

    @Meta.AD(deflt = "anonymous", name = "Anonymous Login", required = false)
    public String anonymousLogin();

    /*
    @Meta.AD(name = "logout-redirect-url", required = false)
    public String logoutRedirectURL();

    @Meta.AD(
            deflt = "", description = "strip-token-prefixes-help",
            name = "strip-token-prefixes-name", required = false
    )
    public String[] stripTokenPrefixes();
    */


}