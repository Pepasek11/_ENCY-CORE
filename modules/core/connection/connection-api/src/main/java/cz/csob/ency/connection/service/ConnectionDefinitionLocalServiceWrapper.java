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

package cz.csob.ency.connection.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ConnectionDefinitionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ConnectionDefinitionLocalService
 * @generated
 */
public class ConnectionDefinitionLocalServiceWrapper
	implements ConnectionDefinitionLocalService,
			   ServiceWrapper<ConnectionDefinitionLocalService> {

	public ConnectionDefinitionLocalServiceWrapper() {
		this(null);
	}

	public ConnectionDefinitionLocalServiceWrapper(
		ConnectionDefinitionLocalService connectionDefinitionLocalService) {

		_connectionDefinitionLocalService = connectionDefinitionLocalService;
	}

	/**
	 * Adds the connection definition to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConnectionDefinitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param connectionDefinition the connection definition
	 * @return the connection definition that was added
	 */
	@Override
	public cz.csob.ency.connection.model.ConnectionDefinition
		addConnectionDefinition(
			cz.csob.ency.connection.model.ConnectionDefinition
				connectionDefinition) {

		return _connectionDefinitionLocalService.addConnectionDefinition(
			connectionDefinition);
	}

	@Override
	public cz.csob.ency.connection.model.ConnectionDefinition
			addConnectionDefinition(
				String name, String driver, String serverAddress,
				String serverPort, String databaseName,
				Boolean integratedSecurity, String username, String password,
				String additionalParams)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _connectionDefinitionLocalService.addConnectionDefinition(
			name, driver, serverAddress, serverPort, databaseName,
			integratedSecurity, username, password, additionalParams);
	}

	/**
	 * Creates a new connection definition with the primary key. Does not add the connection definition to the database.
	 *
	 * @param connectionId the primary key for the new connection definition
	 * @return the new connection definition
	 */
	@Override
	public cz.csob.ency.connection.model.ConnectionDefinition
		createConnectionDefinition(long connectionId) {

		return _connectionDefinitionLocalService.createConnectionDefinition(
			connectionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _connectionDefinitionLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the connection definition from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConnectionDefinitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param connectionDefinition the connection definition
	 * @return the connection definition that was removed
	 */
	@Override
	public cz.csob.ency.connection.model.ConnectionDefinition
		deleteConnectionDefinition(
			cz.csob.ency.connection.model.ConnectionDefinition
				connectionDefinition) {

		return _connectionDefinitionLocalService.deleteConnectionDefinition(
			connectionDefinition);
	}

	@Override
	public cz.csob.ency.connection.model.ConnectionDefinition
			deleteConnectionDefinition(Long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _connectionDefinitionLocalService.deleteConnectionDefinition(id);
	}

	/**
	 * Deletes the connection definition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConnectionDefinitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param connectionId the primary key of the connection definition
	 * @return the connection definition that was removed
	 * @throws PortalException if a connection definition with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.connection.model.ConnectionDefinition
			deleteConnectionDefinition(long connectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _connectionDefinitionLocalService.deleteConnectionDefinition(
			connectionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _connectionDefinitionLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _connectionDefinitionLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _connectionDefinitionLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _connectionDefinitionLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _connectionDefinitionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.connection.model.impl.ConnectionDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _connectionDefinitionLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.connection.model.impl.ConnectionDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _connectionDefinitionLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _connectionDefinitionLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _connectionDefinitionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public cz.csob.ency.connection.model.ConnectionDefinition
		fetchConnectionDefinition(long connectionId) {

		return _connectionDefinitionLocalService.fetchConnectionDefinition(
			connectionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _connectionDefinitionLocalService.getActionableDynamicQuery();
	}

	@Override
	public cz.csob.ency.connection.model.ConnectionDefinition
		getConnectionDefinition(Long id) {

		return _connectionDefinitionLocalService.getConnectionDefinition(id);
	}

	/**
	 * Returns the connection definition with the primary key.
	 *
	 * @param connectionId the primary key of the connection definition
	 * @return the connection definition
	 * @throws PortalException if a connection definition with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.connection.model.ConnectionDefinition
			getConnectionDefinition(long connectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _connectionDefinitionLocalService.getConnectionDefinition(
			connectionId);
	}

	@Override
	public cz.csob.ency.connection.model.ConnectionDefinition
		getConnectionDefinition(String name) {

		return _connectionDefinitionLocalService.getConnectionDefinition(name);
	}

	/**
	 * Returns a range of all the connection definitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.connection.model.impl.ConnectionDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of connection definitions
	 * @param end the upper bound of the range of connection definitions (not inclusive)
	 * @return the range of connection definitions
	 */
	@Override
	public java.util.List<cz.csob.ency.connection.model.ConnectionDefinition>
		getConnectionDefinitions(int start, int end) {

		return _connectionDefinitionLocalService.getConnectionDefinitions(
			start, end);
	}

	/**
	 * Returns the number of connection definitions.
	 *
	 * @return the number of connection definitions
	 */
	@Override
	public int getConnectionDefinitionsCount() {
		return _connectionDefinitionLocalService.
			getConnectionDefinitionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _connectionDefinitionLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _connectionDefinitionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _connectionDefinitionLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the connection definition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConnectionDefinitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param connectionDefinition the connection definition
	 * @return the connection definition that was updated
	 */
	@Override
	public cz.csob.ency.connection.model.ConnectionDefinition
		updateConnectionDefinition(
			cz.csob.ency.connection.model.ConnectionDefinition
				connectionDefinition) {

		return _connectionDefinitionLocalService.updateConnectionDefinition(
			connectionDefinition);
	}

	@Override
	public cz.csob.ency.connection.model.ConnectionDefinition
			updateConnectionDefinition(
				Long id, String name, String driver, String serverAddress,
				String serverPort, String databaseName,
				Boolean integratedSecurity, String username, String password,
				String additionalParams)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _connectionDefinitionLocalService.updateConnectionDefinition(
			id, name, driver, serverAddress, serverPort, databaseName,
			integratedSecurity, username, password, additionalParams);
	}

	@Override
	public ConnectionDefinitionLocalService getWrappedService() {
		return _connectionDefinitionLocalService;
	}

	@Override
	public void setWrappedService(
		ConnectionDefinitionLocalService connectionDefinitionLocalService) {

		_connectionDefinitionLocalService = connectionDefinitionLocalService;
	}

	private ConnectionDefinitionLocalService _connectionDefinitionLocalService;

}