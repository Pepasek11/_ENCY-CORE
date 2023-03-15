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

package cz.csob.ency.connection.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import cz.csob.ency.connection.model.ConnectionDefinition;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ConnectionDefinition in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ConnectionDefinitionCacheModel
	implements CacheModel<ConnectionDefinition>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ConnectionDefinitionCacheModel)) {
			return false;
		}

		ConnectionDefinitionCacheModel connectionDefinitionCacheModel =
			(ConnectionDefinitionCacheModel)object;

		if (connectionId == connectionDefinitionCacheModel.connectionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, connectionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{connectionId=");
		sb.append(connectionId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", driver=");
		sb.append(driver);
		sb.append(", url=");
		sb.append(url);
		sb.append(", serverAddress=");
		sb.append(serverAddress);
		sb.append(", serverPort=");
		sb.append(serverPort);
		sb.append(", databaseName=");
		sb.append(databaseName);
		sb.append(", integratedSecurity=");
		sb.append(integratedSecurity);
		sb.append(", username=");
		sb.append(username);
		sb.append(", password=");
		sb.append(password);
		sb.append(", additionalParams=");
		sb.append(additionalParams);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ConnectionDefinition toEntityModel() {
		ConnectionDefinitionImpl connectionDefinitionImpl =
			new ConnectionDefinitionImpl();

		connectionDefinitionImpl.setConnectionId(connectionId);

		if (name == null) {
			connectionDefinitionImpl.setName("");
		}
		else {
			connectionDefinitionImpl.setName(name);
		}

		if (driver == null) {
			connectionDefinitionImpl.setDriver("");
		}
		else {
			connectionDefinitionImpl.setDriver(driver);
		}

		if (url == null) {
			connectionDefinitionImpl.setUrl("");
		}
		else {
			connectionDefinitionImpl.setUrl(url);
		}

		if (serverAddress == null) {
			connectionDefinitionImpl.setServerAddress("");
		}
		else {
			connectionDefinitionImpl.setServerAddress(serverAddress);
		}

		if (serverPort == null) {
			connectionDefinitionImpl.setServerPort("");
		}
		else {
			connectionDefinitionImpl.setServerPort(serverPort);
		}

		if (databaseName == null) {
			connectionDefinitionImpl.setDatabaseName("");
		}
		else {
			connectionDefinitionImpl.setDatabaseName(databaseName);
		}

		connectionDefinitionImpl.setIntegratedSecurity(integratedSecurity);

		if (username == null) {
			connectionDefinitionImpl.setUsername("");
		}
		else {
			connectionDefinitionImpl.setUsername(username);
		}

		if (password == null) {
			connectionDefinitionImpl.setPassword("");
		}
		else {
			connectionDefinitionImpl.setPassword(password);
		}

		if (additionalParams == null) {
			connectionDefinitionImpl.setAdditionalParams("");
		}
		else {
			connectionDefinitionImpl.setAdditionalParams(additionalParams);
		}

		connectionDefinitionImpl.resetOriginalValues();

		return connectionDefinitionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		connectionId = objectInput.readLong();
		name = objectInput.readUTF();
		driver = objectInput.readUTF();
		url = objectInput.readUTF();
		serverAddress = objectInput.readUTF();
		serverPort = objectInput.readUTF();
		databaseName = objectInput.readUTF();

		integratedSecurity = objectInput.readBoolean();
		username = objectInput.readUTF();
		password = objectInput.readUTF();
		additionalParams = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(connectionId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (driver == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driver);
		}

		if (url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(url);
		}

		if (serverAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(serverAddress);
		}

		if (serverPort == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(serverPort);
		}

		if (databaseName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(databaseName);
		}

		objectOutput.writeBoolean(integratedSecurity);

		if (username == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(username);
		}

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}

		if (additionalParams == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(additionalParams);
		}
	}

	public long connectionId;
	public String name;
	public String driver;
	public String url;
	public String serverAddress;
	public String serverPort;
	public String databaseName;
	public boolean integratedSecurity;
	public String username;
	public String password;
	public String additionalParams;

}