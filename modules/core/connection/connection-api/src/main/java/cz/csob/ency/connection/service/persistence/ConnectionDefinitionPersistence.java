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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import cz.csob.ency.connection.exception.NoSuchConnectionDefinitionException;
import cz.csob.ency.connection.model.ConnectionDefinition;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the connection definition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConnectionDefinitionUtil
 * @generated
 */
@ProviderType
public interface ConnectionDefinitionPersistence
	extends BasePersistence<ConnectionDefinition> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConnectionDefinitionUtil} to access the connection definition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the connection definitions where connectionId = &#63;.
	 *
	 * @param connectionId the connection ID
	 * @return the matching connection definitions
	 */
	public java.util.List<ConnectionDefinition> findById(long connectionId);

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
	public java.util.List<ConnectionDefinition> findById(
		long connectionId, int start, int end);

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
	public java.util.List<ConnectionDefinition> findById(
		long connectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectionDefinition>
			orderByComparator);

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
	public java.util.List<ConnectionDefinition> findById(
		long connectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectionDefinition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first connection definition in the ordered set where connectionId = &#63;.
	 *
	 * @param connectionId the connection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connection definition
	 * @throws NoSuchConnectionDefinitionException if a matching connection definition could not be found
	 */
	public ConnectionDefinition findById_First(
			long connectionId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConnectionDefinition> orderByComparator)
		throws NoSuchConnectionDefinitionException;

	/**
	 * Returns the first connection definition in the ordered set where connectionId = &#63;.
	 *
	 * @param connectionId the connection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connection definition, or <code>null</code> if a matching connection definition could not be found
	 */
	public ConnectionDefinition fetchById_First(
		long connectionId,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectionDefinition>
			orderByComparator);

	/**
	 * Returns the last connection definition in the ordered set where connectionId = &#63;.
	 *
	 * @param connectionId the connection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connection definition
	 * @throws NoSuchConnectionDefinitionException if a matching connection definition could not be found
	 */
	public ConnectionDefinition findById_Last(
			long connectionId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConnectionDefinition> orderByComparator)
		throws NoSuchConnectionDefinitionException;

	/**
	 * Returns the last connection definition in the ordered set where connectionId = &#63;.
	 *
	 * @param connectionId the connection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connection definition, or <code>null</code> if a matching connection definition could not be found
	 */
	public ConnectionDefinition fetchById_Last(
		long connectionId,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectionDefinition>
			orderByComparator);

	/**
	 * Removes all the connection definitions where connectionId = &#63; from the database.
	 *
	 * @param connectionId the connection ID
	 */
	public void removeById(long connectionId);

	/**
	 * Returns the number of connection definitions where connectionId = &#63;.
	 *
	 * @param connectionId the connection ID
	 * @return the number of matching connection definitions
	 */
	public int countById(long connectionId);

	/**
	 * Returns all the connection definitions where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching connection definitions
	 */
	public java.util.List<ConnectionDefinition> findByName(String name);

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
	public java.util.List<ConnectionDefinition> findByName(
		String name, int start, int end);

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
	public java.util.List<ConnectionDefinition> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectionDefinition>
			orderByComparator);

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
	public java.util.List<ConnectionDefinition> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectionDefinition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first connection definition in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connection definition
	 * @throws NoSuchConnectionDefinitionException if a matching connection definition could not be found
	 */
	public ConnectionDefinition findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConnectionDefinition> orderByComparator)
		throws NoSuchConnectionDefinitionException;

	/**
	 * Returns the first connection definition in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connection definition, or <code>null</code> if a matching connection definition could not be found
	 */
	public ConnectionDefinition fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectionDefinition>
			orderByComparator);

	/**
	 * Returns the last connection definition in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connection definition
	 * @throws NoSuchConnectionDefinitionException if a matching connection definition could not be found
	 */
	public ConnectionDefinition findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConnectionDefinition> orderByComparator)
		throws NoSuchConnectionDefinitionException;

	/**
	 * Returns the last connection definition in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connection definition, or <code>null</code> if a matching connection definition could not be found
	 */
	public ConnectionDefinition fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectionDefinition>
			orderByComparator);

	/**
	 * Returns the connection definitions before and after the current connection definition in the ordered set where name = &#63;.
	 *
	 * @param connectionId the primary key of the current connection definition
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next connection definition
	 * @throws NoSuchConnectionDefinitionException if a connection definition with the primary key could not be found
	 */
	public ConnectionDefinition[] findByName_PrevAndNext(
			long connectionId, String name,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConnectionDefinition> orderByComparator)
		throws NoSuchConnectionDefinitionException;

	/**
	 * Removes all the connection definitions where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of connection definitions where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching connection definitions
	 */
	public int countByName(String name);

	/**
	 * Caches the connection definition in the entity cache if it is enabled.
	 *
	 * @param connectionDefinition the connection definition
	 */
	public void cacheResult(ConnectionDefinition connectionDefinition);

	/**
	 * Caches the connection definitions in the entity cache if it is enabled.
	 *
	 * @param connectionDefinitions the connection definitions
	 */
	public void cacheResult(
		java.util.List<ConnectionDefinition> connectionDefinitions);

	/**
	 * Creates a new connection definition with the primary key. Does not add the connection definition to the database.
	 *
	 * @param connectionId the primary key for the new connection definition
	 * @return the new connection definition
	 */
	public ConnectionDefinition create(long connectionId);

	/**
	 * Removes the connection definition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param connectionId the primary key of the connection definition
	 * @return the connection definition that was removed
	 * @throws NoSuchConnectionDefinitionException if a connection definition with the primary key could not be found
	 */
	public ConnectionDefinition remove(long connectionId)
		throws NoSuchConnectionDefinitionException;

	public ConnectionDefinition updateImpl(
		ConnectionDefinition connectionDefinition);

	/**
	 * Returns the connection definition with the primary key or throws a <code>NoSuchConnectionDefinitionException</code> if it could not be found.
	 *
	 * @param connectionId the primary key of the connection definition
	 * @return the connection definition
	 * @throws NoSuchConnectionDefinitionException if a connection definition with the primary key could not be found
	 */
	public ConnectionDefinition findByPrimaryKey(long connectionId)
		throws NoSuchConnectionDefinitionException;

	/**
	 * Returns the connection definition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param connectionId the primary key of the connection definition
	 * @return the connection definition, or <code>null</code> if a connection definition with the primary key could not be found
	 */
	public ConnectionDefinition fetchByPrimaryKey(long connectionId);

	/**
	 * Returns all the connection definitions.
	 *
	 * @return the connection definitions
	 */
	public java.util.List<ConnectionDefinition> findAll();

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
	public java.util.List<ConnectionDefinition> findAll(int start, int end);

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
	public java.util.List<ConnectionDefinition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectionDefinition>
			orderByComparator);

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
	public java.util.List<ConnectionDefinition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectionDefinition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the connection definitions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of connection definitions.
	 *
	 * @return the number of connection definitions
	 */
	public int countAll();

}