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

package cz.csob.ency.connection.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import cz.csob.ency.connection.model.ConnectionDefinition;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the connection definition service. This utility wraps <code>cz.csob.ency.connection.service.persistence.impl.ConnectionDefinitionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConnectionDefinitionPersistence
 * @generated
 */
public class ConnectionDefinitionUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ConnectionDefinition connectionDefinition) {
		getPersistence().clearCache(connectionDefinition);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ConnectionDefinition> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ConnectionDefinition> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ConnectionDefinition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ConnectionDefinition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ConnectionDefinition> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ConnectionDefinition update(
		ConnectionDefinition connectionDefinition) {

		return getPersistence().update(connectionDefinition);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ConnectionDefinition update(
		ConnectionDefinition connectionDefinition,
		ServiceContext serviceContext) {

		return getPersistence().update(connectionDefinition, serviceContext);
	}

	/**
	 * Returns all the connection definitions where connectionId = &#63;.
	 *
	 * @param connectionId the connection ID
	 * @return the matching connection definitions
	 */
	public static List<ConnectionDefinition> findById(long connectionId) {
		return getPersistence().findById(connectionId);
	}

	/**
	 * Returns a range of all the connection definitions where connectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectionDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param connectionId the connection ID
	 * @param start the lower bound of the range of connection definitions
	 * @param end the upper bound of the range of connection definitions (not inclusive)
	 * @return the range of matching connection definitions
	 */
	public static List<ConnectionDefinition> findById(
		long connectionId, int start, int end) {

		return getPersistence().findById(connectionId, start, end);
	}

	/**
	 * Returns an ordered range of all the connection definitions where connectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectionDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param connectionId the connection ID
	 * @param start the lower bound of the range of connection definitions
	 * @param end the upper bound of the range of connection definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching connection definitions
	 */
	public static List<ConnectionDefinition> findById(
		long connectionId, int start, int end,
		OrderByComparator<ConnectionDefinition> orderByComparator) {

		return getPersistence().findById(
			connectionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the connection definitions where connectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectionDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param connectionId the connection ID
	 * @param start the lower bound of the range of connection definitions
	 * @param end the upper bound of the range of connection definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching connection definitions
	 */
	public static List<ConnectionDefinition> findById(
		long connectionId, int start, int end,
		OrderByComparator<ConnectionDefinition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findById(
			connectionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first connection definition in the ordered set where connectionId = &#63;.
	 *
	 * @param connectionId the connection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connection definition
	 * @throws NoSuchConnectionDefinitionException if a matching connection definition could not be found
	 */
	public static ConnectionDefinition findById_First(
			long connectionId,
			OrderByComparator<ConnectionDefinition> orderByComparator)
		throws cz.csob.ency.connection.exception.
			NoSuchConnectionDefinitionException {

		return getPersistence().findById_First(connectionId, orderByComparator);
	}

	/**
	 * Returns the first connection definition in the ordered set where connectionId = &#63;.
	 *
	 * @param connectionId the connection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connection definition, or <code>null</code> if a matching connection definition could not be found
	 */
	public static ConnectionDefinition fetchById_First(
		long connectionId,
		OrderByComparator<ConnectionDefinition> orderByComparator) {

		return getPersistence().fetchById_First(
			connectionId, orderByComparator);
	}

	/**
	 * Returns the last connection definition in the ordered set where connectionId = &#63;.
	 *
	 * @param connectionId the connection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connection definition
	 * @throws NoSuchConnectionDefinitionException if a matching connection definition could not be found
	 */
	public static ConnectionDefinition findById_Last(
			long connectionId,
			OrderByComparator<ConnectionDefinition> orderByComparator)
		throws cz.csob.ency.connection.exception.
			NoSuchConnectionDefinitionException {

		return getPersistence().findById_Last(connectionId, orderByComparator);
	}

	/**
	 * Returns the last connection definition in the ordered set where connectionId = &#63;.
	 *
	 * @param connectionId the connection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connection definition, or <code>null</code> if a matching connection definition could not be found
	 */
	public static ConnectionDefinition fetchById_Last(
		long connectionId,
		OrderByComparator<ConnectionDefinition> orderByComparator) {

		return getPersistence().fetchById_Last(connectionId, orderByComparator);
	}

	/**
	 * Removes all the connection definitions where connectionId = &#63; from the database.
	 *
	 * @param connectionId the connection ID
	 */
	public static void removeById(long connectionId) {
		getPersistence().removeById(connectionId);
	}

	/**
	 * Returns the number of connection definitions where connectionId = &#63;.
	 *
	 * @param connectionId the connection ID
	 * @return the number of matching connection definitions
	 */
	public static int countById(long connectionId) {
		return getPersistence().countById(connectionId);
	}

	/**
	 * Returns all the connection definitions where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching connection definitions
	 */
	public static List<ConnectionDefinition> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the connection definitions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectionDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of connection definitions
	 * @param end the upper bound of the range of connection definitions (not inclusive)
	 * @return the range of matching connection definitions
	 */
	public static List<ConnectionDefinition> findByName(
		String name, int start, int end) {

		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the connection definitions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectionDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of connection definitions
	 * @param end the upper bound of the range of connection definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching connection definitions
	 */
	public static List<ConnectionDefinition> findByName(
		String name, int start, int end,
		OrderByComparator<ConnectionDefinition> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the connection definitions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectionDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of connection definitions
	 * @param end the upper bound of the range of connection definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching connection definitions
	 */
	public static List<ConnectionDefinition> findByName(
		String name, int start, int end,
		OrderByComparator<ConnectionDefinition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first connection definition in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connection definition
	 * @throws NoSuchConnectionDefinitionException if a matching connection definition could not be found
	 */
	public static ConnectionDefinition findByName_First(
			String name,
			OrderByComparator<ConnectionDefinition> orderByComparator)
		throws cz.csob.ency.connection.exception.
			NoSuchConnectionDefinitionException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first connection definition in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connection definition, or <code>null</code> if a matching connection definition could not be found
	 */
	public static ConnectionDefinition fetchByName_First(
		String name,
		OrderByComparator<ConnectionDefinition> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last connection definition in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connection definition
	 * @throws NoSuchConnectionDefinitionException if a matching connection definition could not be found
	 */
	public static ConnectionDefinition findByName_Last(
			String name,
			OrderByComparator<ConnectionDefinition> orderByComparator)
		throws cz.csob.ency.connection.exception.
			NoSuchConnectionDefinitionException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last connection definition in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connection definition, or <code>null</code> if a matching connection definition could not be found
	 */
	public static ConnectionDefinition fetchByName_Last(
		String name,
		OrderByComparator<ConnectionDefinition> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the connection definitions before and after the current connection definition in the ordered set where name = &#63;.
	 *
	 * @param connectionId the primary key of the current connection definition
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next connection definition
	 * @throws NoSuchConnectionDefinitionException if a connection definition with the primary key could not be found
	 */
	public static ConnectionDefinition[] findByName_PrevAndNext(
			long connectionId, String name,
			OrderByComparator<ConnectionDefinition> orderByComparator)
		throws cz.csob.ency.connection.exception.
			NoSuchConnectionDefinitionException {

		return getPersistence().findByName_PrevAndNext(
			connectionId, name, orderByComparator);
	}

	/**
	 * Removes all the connection definitions where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of connection definitions where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching connection definitions
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the connection definition in the entity cache if it is enabled.
	 *
	 * @param connectionDefinition the connection definition
	 */
	public static void cacheResult(ConnectionDefinition connectionDefinition) {
		getPersistence().cacheResult(connectionDefinition);
	}

	/**
	 * Caches the connection definitions in the entity cache if it is enabled.
	 *
	 * @param connectionDefinitions the connection definitions
	 */
	public static void cacheResult(
		List<ConnectionDefinition> connectionDefinitions) {

		getPersistence().cacheResult(connectionDefinitions);
	}

	/**
	 * Creates a new connection definition with the primary key. Does not add the connection definition to the database.
	 *
	 * @param connectionId the primary key for the new connection definition
	 * @return the new connection definition
	 */
	public static ConnectionDefinition create(long connectionId) {
		return getPersistence().create(connectionId);
	}

	/**
	 * Removes the connection definition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param connectionId the primary key of the connection definition
	 * @return the connection definition that was removed
	 * @throws NoSuchConnectionDefinitionException if a connection definition with the primary key could not be found
	 */
	public static ConnectionDefinition remove(long connectionId)
		throws cz.csob.ency.connection.exception.
			NoSuchConnectionDefinitionException {

		return getPersistence().remove(connectionId);
	}

	public static ConnectionDefinition updateImpl(
		ConnectionDefinition connectionDefinition) {

		return getPersistence().updateImpl(connectionDefinition);
	}

	/**
	 * Returns the connection definition with the primary key or throws a <code>NoSuchConnectionDefinitionException</code> if it could not be found.
	 *
	 * @param connectionId the primary key of the connection definition
	 * @return the connection definition
	 * @throws NoSuchConnectionDefinitionException if a connection definition with the primary key could not be found
	 */
	public static ConnectionDefinition findByPrimaryKey(long connectionId)
		throws cz.csob.ency.connection.exception.
			NoSuchConnectionDefinitionException {

		return getPersistence().findByPrimaryKey(connectionId);
	}

	/**
	 * Returns the connection definition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param connectionId the primary key of the connection definition
	 * @return the connection definition, or <code>null</code> if a connection definition with the primary key could not be found
	 */
	public static ConnectionDefinition fetchByPrimaryKey(long connectionId) {
		return getPersistence().fetchByPrimaryKey(connectionId);
	}

	/**
	 * Returns all the connection definitions.
	 *
	 * @return the connection definitions
	 */
	public static List<ConnectionDefinition> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the connection definitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectionDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of connection definitions
	 * @param end the upper bound of the range of connection definitions (not inclusive)
	 * @return the range of connection definitions
	 */
	public static List<ConnectionDefinition> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the connection definitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectionDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of connection definitions
	 * @param end the upper bound of the range of connection definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of connection definitions
	 */
	public static List<ConnectionDefinition> findAll(
		int start, int end,
		OrderByComparator<ConnectionDefinition> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the connection definitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectionDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of connection definitions
	 * @param end the upper bound of the range of connection definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of connection definitions
	 */
	public static List<ConnectionDefinition> findAll(
		int start, int end,
		OrderByComparator<ConnectionDefinition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the connection definitions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of connection definitions.
	 *
	 * @return the number of connection definitions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ConnectionDefinitionPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ConnectionDefinitionPersistence _persistence;

}