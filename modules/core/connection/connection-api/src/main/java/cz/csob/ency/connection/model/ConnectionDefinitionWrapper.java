/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package cz.csob.ency.connection.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ConnectionDefinition}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConnectionDefinition
 * @generated
 */
public class ConnectionDefinitionWrapper
	extends BaseModelWrapper<ConnectionDefinition>
	implements ConnectionDefinition, ModelWrapper<ConnectionDefinition> {

	public ConnectionDefinitionWrapper(
		ConnectionDefinition connectionDefinition) {

		super(connectionDefinition);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("connectionId", getConnectionId());
		attributes.put("name", getName());
		attributes.put("driver", getDriver());
		attributes.put("url", getUrl());
		attributes.put("serverAddress", getServerAddress());
		attributes.put("serverPort", getServerPort());
		attributes.put("databaseName", getDatabaseName());
		attributes.put("integratedSecurity", getIntegratedSecurity());
		attributes.put("username", getUsername());
		attributes.put("password", getPassword());
		attributes.put("additionalParams", getAdditionalParams());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long connectionId = (Long)attributes.get("connectionId");

		if (connectionId != null) {
			setConnectionId(connectionId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String driver = (String)attributes.get("driver");

		if (driver != null) {
			setDriver(driver);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String serverAddress = (String)attributes.get("serverAddress");

		if (serverAddress != null) {
			setServerAddress(serverAddress);
		}

		String serverPort = (String)attributes.get("serverPort");

		if (serverPort != null) {
			setServerPort(serverPort);
		}

		String databaseName = (String)attributes.get("databaseName");

		if (databaseName != null) {
			setDatabaseName(databaseName);
		}

		Boolean integratedSecurity = (Boolean)attributes.get(
			"integratedSecurity");

		if (integratedSecurity != null) {
			setIntegratedSecurity(integratedSecurity);
		}

		String username = (String)attributes.get("username");

		if (username != null) {
			setUsername(username);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		String additionalParams = (String)attributes.get("additionalParams");

		if (additionalParams != null) {
			setAdditionalParams(additionalParams);
		}
	}

	@Override
	public ConnectionDefinition cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the additional params of this connection definition.
	 *
	 * @return the additional params of this connection definition
	 */
	@Override
	public String getAdditionalParams() {
		return model.getAdditionalParams();
	}

	/**
	 * Returns the connection ID of this connection definition.
	 *
	 * @return the connection ID of this connection definition
	 */
	@Override
	public long getConnectionId() {
		return model.getConnectionId();
	}

	/**
	 * Returns the database name of this connection definition.
	 *
	 * @return the database name of this connection definition
	 */
	@Override
	public String getDatabaseName() {
		return model.getDatabaseName();
	}

	/**
	 * Returns the driver of this connection definition.
	 *
	 * @return the driver of this connection definition
	 */
	@Override
	public String getDriver() {
		return model.getDriver();
	}

	/**
	 * Returns the integrated security of this connection definition.
	 *
	 * @return the integrated security of this connection definition
	 */
	@Override
	public Boolean getIntegratedSecurity() {
		return model.getIntegratedSecurity();
	}

	/**
	 * Returns the name of this connection definition.
	 *
	 * @return the name of this connection definition
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the password of this connection definition.
	 *
	 * @return the password of this connection definition
	 */
	@Override
	public String getPassword() {
		return model.getPassword();
	}

	/**
	 * Returns the primary key of this connection definition.
	 *
	 * @return the primary key of this connection definition
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the server address of this connection definition.
	 *
	 * @return the server address of this connection definition
	 */
	@Override
	public String getServerAddress() {
		return model.getServerAddress();
	}

	/**
	 * Returns the server port of this connection definition.
	 *
	 * @return the server port of this connection definition
	 */
	@Override
	public String getServerPort() {
		return model.getServerPort();
	}

	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the url of this connection definition.
	 *
	 * @return the url of this connection definition
	 */
	@Override
	public String getUrl() {
		return model.getUrl();
	}

	/**
	 * Returns the username of this connection definition.
	 *
	 * @return the username of this connection definition
	 */
	@Override
	public String getUsername() {
		return model.getUsername();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the additional params of this connection definition.
	 *
	 * @param additionalParams the additional params of this connection definition
	 */
	@Override
	public void setAdditionalParams(String additionalParams) {
		model.setAdditionalParams(additionalParams);
	}

	/**
	 * Sets the connection ID of this connection definition.
	 *
	 * @param connectionId the connection ID of this connection definition
	 */
	@Override
	public void setConnectionId(long connectionId) {
		model.setConnectionId(connectionId);
	}

	/**
	 * Sets the database name of this connection definition.
	 *
	 * @param databaseName the database name of this connection definition
	 */
	@Override
	public void setDatabaseName(String databaseName) {
		model.setDatabaseName(databaseName);
	}

	/**
	 * Sets the driver of this connection definition.
	 *
	 * @param driver the driver of this connection definition
	 */
	@Override
	public void setDriver(String driver) {
		model.setDriver(driver);
	}

	/**
	 * Sets the integrated security of this connection definition.
	 *
	 * @param integratedSecurity the integrated security of this connection definition
	 */
	@Override
	public void setIntegratedSecurity(Boolean integratedSecurity) {
		model.setIntegratedSecurity(integratedSecurity);
	}

	/**
	 * Sets the name of this connection definition.
	 *
	 * @param name the name of this connection definition
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the password of this connection definition.
	 *
	 * @param password the password of this connection definition
	 */
	@Override
	public void setPassword(String password) {
		model.setPassword(password);
	}

	/**
	 * Sets the primary key of this connection definition.
	 *
	 * @param primaryKey the primary key of this connection definition
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the server address of this connection definition.
	 *
	 * @param serverAddress the server address of this connection definition
	 */
	@Override
	public void setServerAddress(String serverAddress) {
		model.setServerAddress(serverAddress);
	}

	/**
	 * Sets the server port of this connection definition.
	 *
	 * @param serverPort the server port of this connection definition
	 */
	@Override
	public void setServerPort(String serverPort) {
		model.setServerPort(serverPort);
	}

	/**
	 * Sets the url of this connection definition.
	 *
	 * @param url the url of this connection definition
	 */
	@Override
	public void setUrl(String url) {
		model.setUrl(url);
	}

	/**
	 * Sets the username of this connection definition.
	 *
	 * @param username the username of this connection definition
	 */
	@Override
	public void setUsername(String username) {
		model.setUsername(username);
	}

	@Override
	protected ConnectionDefinitionWrapper wrap(
		ConnectionDefinition connectionDefinition) {

		return new ConnectionDefinitionWrapper(connectionDefinition);
	}

}