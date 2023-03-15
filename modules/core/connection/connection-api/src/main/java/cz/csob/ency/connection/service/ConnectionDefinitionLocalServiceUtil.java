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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import cz.csob.ency.connection.model.ConnectionDefinition;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ConnectionDefinition. This utility wraps
 * <code>cz.csob.ency.connection.service.impl.ConnectionDefinitionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ConnectionDefinitionLocalService
 * @generated
 */
public class ConnectionDefinitionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>cz.csob.ency.connection.service.impl.ConnectionDefinitionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static ConnectionDefinition addConnectionDefinition(
		ConnectionDefinition connectionDefinition) {

		return getService().addConnectionDefinition(connectionDefinition);
	}

	public static ConnectionDefinition addConnectionDefinition(
			String name, String driver, String serverAddress, String serverPort,
			String databaseName, Boolean integratedSecurity, String username,
			String password, String additionalParams)
		throws PortalException {

		return getService().addConnectionDefinition(
			name, driver, serverAddress, serverPort, databaseName,
			integratedSecurity, username, password, additionalParams);
	}

	/**
	 * Creates a new connection definition with the primary key. Does not add the connection definition to the database.
	 *
	 * @param connectionId the primary key for the new connection definition
	 * @return the new connection definition
	 */
	public static ConnectionDefinition createConnectionDefinition(
		long connectionId) {

		return getService().createConnectionDefinition(connectionId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static ConnectionDefinition deleteConnectionDefinition(
		ConnectionDefinition connectionDefinition) {

		return getService().deleteConnectionDefinition(connectionDefinition);
	}

	public static ConnectionDefinition deleteConnectionDefinition(Long id)
		throws PortalException, SystemException {

		return getService().deleteConnectionDefinition(id);
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
	public static ConnectionDefinition deleteConnectionDefinition(
			long connectionId)
		throws PortalException {

		return getService().deleteConnectionDefinition(connectionId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ConnectionDefinition fetchConnectionDefinition(
		long connectionId) {

		return getService().fetchConnectionDefinition(connectionId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static ConnectionDefinition getConnectionDefinition(Long id) {
		return getService().getConnectionDefinition(id);
	}

	/**
	 * Returns the connection definition with the primary key.
	 *
	 * @param connectionId the primary key of the connection definition
	 * @return the connection definition
	 * @throws PortalException if a connection definition with the primary key could not be found
	 */
	public static ConnectionDefinition getConnectionDefinition(
			long connectionId)
		throws PortalException {

		return getService().getConnectionDefinition(connectionId);
	}

	public static ConnectionDefinition getConnectionDefinition(String name) {
		return getService().getConnectionDefinition(name);
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
	public static List<ConnectionDefinition> getConnectionDefinitions(
		int start, int end) {

		return getService().getConnectionDefinitions(start, end);
	}

	/**
	 * Returns the number of connection definitions.
	 *
	 * @return the number of connection definitions
	 */
	public static int getConnectionDefinitionsCount() {
		return getService().getConnectionDefinitionsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static ConnectionDefinition updateConnectionDefinition(
		ConnectionDefinition connectionDefinition) {

		return getService().updateConnectionDefinition(connectionDefinition);
	}

	public static ConnectionDefinition updateConnectionDefinition(
			Long id, String name, String driver, String serverAddress,
			String serverPort, String databaseName, Boolean integratedSecurity,
			String username, String password, String additionalParams)
		throws PortalException {

		return getService().updateConnectionDefinition(
			id, name, driver, serverAddress, serverPort, databaseName,
			integratedSecurity, username, password, additionalParams);
	}

	public static ConnectionDefinitionLocalService getService() {
		return _service;
	}

	private static volatile ConnectionDefinitionLocalService _service;

}