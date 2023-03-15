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

package cz.csob.ency.connection.model.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import cz.csob.ency.connection.sql.SqlUtils;

import java.util.List;
import java.util.Map;

/**
 * The extended model implementation for the ConnectionDefinition service. Represents a row in the &quot;pec_connection&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>cz.csob.ency.connection.model.ConnectionDefinition</code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class ConnectionDefinitionImpl extends ConnectionDefinitionBaseImpl {
    private final Log log = LogFactoryUtil.getLog(ConnectionDefinitionImpl.class);

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a connection definition model instance should use the {@link cz.csob.ency.connection.model.ConnectionDefinition} interface instead.
     */
    public ConnectionDefinitionImpl() {

    }

    public String getStatus() {
        List<Map<String, Object>> res = SqlUtils.executeSelect(this.getName(), "SELECT 'connection_ping' as res");
        if (res.size() == 1 && res.get(0).containsKey("res") && res.get(0).get("res").equals("connection_ping")) {
            return "OK";
        }
        return "UNAVAILABLE";
    }

}