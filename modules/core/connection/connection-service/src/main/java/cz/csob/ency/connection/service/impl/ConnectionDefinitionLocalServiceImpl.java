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

package cz.csob.ency.connection.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.connection.exception.ConnectionDefinitionEmptyDriverException;
import cz.csob.ency.connection.exception.ConnectionDefinitionEmptyNameException;
import cz.csob.ency.connection.exception.ConnectionDefinitionEmptyServerNameException;
import cz.csob.ency.connection.exception.ConnectionDefinitionEmptyUsernameException;
import cz.csob.ency.connection.model.ConnectionDefinition;
import cz.csob.ency.connection.service.base.ConnectionDefinitionLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the connection definition local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>cz.csob.ency.connection.service.ConnectionDefinitionLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConnectionDefinitionLocalServiceBaseImpl
 */
@Component(
    property = "model.class.name=cz.csob.ency.connection.model.ConnectionDefinition",
    service = AopService.class
)
public class ConnectionDefinitionLocalServiceImpl
    extends ConnectionDefinitionLocalServiceBaseImpl {
    private static final Log log = LogFactoryUtil.getLog(ConnectionDefinitionLocalServiceImpl.class);

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Use <code>cz.csob.ency.connection.service.ConnectionDefinitionLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>cz.csob.ency.connection.service.ConnectionDefinitionLocalServiceUtil</code>.
     */

    @Activate
    public void activate() {
        if(connectionDefinitionPersistence==null) {
            log.warn("connectionDefinitionPersistence is null :(");
        }
    }

    public ConnectionDefinition addConnectionDefinition(String name, String driver, String serverAddress
            , String serverPort, String databaseName, Boolean integratedSecurity, String username, String password
            , String additionalParams)
            throws PortalException {

        Long id = counterLocalService.increment();
        ConnectionDefinition condef = connectionDefinitionPersistence.create(id);

        if(Validator.isBlank(serverPort)) {
            serverPort="1433";
        }

        condef.setName(name);
        condef.setDriver(driver);
        condef.setServerAddress(serverAddress);
        condef.setServerPort(serverPort);
        condef.setDatabaseName(databaseName);
        condef.setIntegratedSecurity(integratedSecurity);
        condef.setUsername(username);
        condef.setPassword(password);
        condef.setAdditionalParams(additionalParams);

        connectionDefinitionPersistence.update(condef);
        return condef;
    }

    public ConnectionDefinition getConnectionDefinition(Long id) {
        return connectionDefinitionPersistence.findById(id).get(0);
    }

    public ConnectionDefinition getConnectionDefinition(String name) {
        return connectionDefinitionPersistence.findByName(name).get(0);
    }

    public ConnectionDefinition updateConnectionDefinition(Long id, String name, String driver, String serverAddress
            , String serverPort, String databaseName, Boolean integratedSecurity, String username, String password
            , String additionalParams)
            throws PortalException {
        validate(name, driver, serverAddress, serverPort, username);

        ConnectionDefinition condef = getConnectionDefinition(id);

        if(Validator.isBlank(serverPort)) {
            serverPort="1433";
        }

        condef.setName(name);
        condef.setDriver(driver);
        condef.setServerAddress(serverAddress);
        condef.setServerPort(serverPort);
        condef.setDatabaseName(databaseName);
        condef.setIntegratedSecurity(integratedSecurity);
        condef.setUsername(username);
        condef.setPassword(password);
        condef.setAdditionalParams(additionalParams);

        connectionDefinitionPersistence.update(condef);

        return condef;
    }

    public ConnectionDefinition deleteConnectionDefinition(Long id) throws PortalException, SystemException {
        ConnectionDefinition condef = getConnectionDefinition(id);

        condef = deleteConnectionDefinition(id);
        return condef;
    }

    protected void validate(String name, String driver, String serverAddress, String serverPort, String username)
            throws PortalException {
        if (Validator.isBlank(name)) {
            throw new ConnectionDefinitionEmptyNameException();
        }
        if (Validator.isBlank(driver)) {
            throw new ConnectionDefinitionEmptyDriverException();
        }
        if (Validator.isBlank(serverAddress)) {
            throw new ConnectionDefinitionEmptyServerNameException();
        }
        if (Validator.isBlank(username)) {
            throw new ConnectionDefinitionEmptyUsernameException();
        }
    }

}