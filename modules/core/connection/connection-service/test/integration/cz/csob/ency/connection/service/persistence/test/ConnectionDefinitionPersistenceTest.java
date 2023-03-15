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

package cz.csob.ency.connection.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import cz.csob.ency.connection.exception.NoSuchConnectionDefinitionException;
import cz.csob.ency.connection.model.ConnectionDefinition;
import cz.csob.ency.connection.service.ConnectionDefinitionLocalServiceUtil;
import cz.csob.ency.connection.service.persistence.ConnectionDefinitionPersistence;
import cz.csob.ency.connection.service.persistence.ConnectionDefinitionUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class ConnectionDefinitionPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "cz.csob.ency.connection.service"));

	@Before
	public void setUp() {
		_persistence = ConnectionDefinitionUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ConnectionDefinition> iterator =
			_connectionDefinitions.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ConnectionDefinition connectionDefinition = _persistence.create(pk);

		Assert.assertNotNull(connectionDefinition);

		Assert.assertEquals(connectionDefinition.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ConnectionDefinition newConnectionDefinition =
			addConnectionDefinition();

		_persistence.remove(newConnectionDefinition);

		ConnectionDefinition existingConnectionDefinition =
			_persistence.fetchByPrimaryKey(
				newConnectionDefinition.getPrimaryKey());

		Assert.assertNull(existingConnectionDefinition);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addConnectionDefinition();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ConnectionDefinition newConnectionDefinition = _persistence.create(pk);

		newConnectionDefinition.setName(RandomTestUtil.randomString());

		newConnectionDefinition.setDriver(RandomTestUtil.randomString());

		newConnectionDefinition.setUrl(RandomTestUtil.randomString());

		newConnectionDefinition.setServerAddress(RandomTestUtil.randomString());

		newConnectionDefinition.setServerPort(RandomTestUtil.randomString(7));

		newConnectionDefinition.setDatabaseName(RandomTestUtil.randomString());

		newConnectionDefinition.setIntegratedSecurity();

		newConnectionDefinition.setUsername(RandomTestUtil.randomString());

		newConnectionDefinition.setPassword(RandomTestUtil.randomString());

		newConnectionDefinition.setAdditionalParams(
			RandomTestUtil.randomString());

		_connectionDefinitions.add(
			_persistence.update(newConnectionDefinition));

		ConnectionDefinition existingConnectionDefinition =
			_persistence.findByPrimaryKey(
				newConnectionDefinition.getPrimaryKey());

		Assert.assertEquals(
			existingConnectionDefinition.getConnectionId(),
			newConnectionDefinition.getConnectionId());
		Assert.assertEquals(
			existingConnectionDefinition.getName(),
			newConnectionDefinition.getName());
		Assert.assertEquals(
			existingConnectionDefinition.getDriver(),
			newConnectionDefinition.getDriver());
		Assert.assertEquals(
			existingConnectionDefinition.getUrl(),
			newConnectionDefinition.getUrl());
		Assert.assertEquals(
			existingConnectionDefinition.getServerAddress(),
			newConnectionDefinition.getServerAddress());
		Assert.assertEquals(
			existingConnectionDefinition.getServerPort(),
			newConnectionDefinition.getServerPort());
		Assert.assertEquals(
			existingConnectionDefinition.getDatabaseName(),
			newConnectionDefinition.getDatabaseName());
		Assert.assertEquals(
			existingConnectionDefinition.getIntegratedSecurity(),
			newConnectionDefinition.getIntegratedSecurity());
		Assert.assertEquals(
			existingConnectionDefinition.getUsername(),
			newConnectionDefinition.getUsername());
		Assert.assertEquals(
			existingConnectionDefinition.getPassword(),
			newConnectionDefinition.getPassword());
		Assert.assertEquals(
			existingConnectionDefinition.getAdditionalParams(),
			newConnectionDefinition.getAdditionalParams());
	}

	@Test
	public void testCountById() throws Exception {
		_persistence.countById(RandomTestUtil.nextLong());

		_persistence.countById(0L);
	}

	@Test
	public void testCountByName() throws Exception {
		_persistence.countByName("");

		_persistence.countByName("null");

		_persistence.countByName((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ConnectionDefinition newConnectionDefinition =
			addConnectionDefinition();

		ConnectionDefinition existingConnectionDefinition =
			_persistence.findByPrimaryKey(
				newConnectionDefinition.getPrimaryKey());

		Assert.assertEquals(
			existingConnectionDefinition, newConnectionDefinition);
	}

	@Test(expected = NoSuchConnectionDefinitionException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<ConnectionDefinition> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ency_connection", "connectionId", true, "name", true, "driver",
			true, "url", true, "serverAddress", true, "serverPort", true,
			"databaseName", true, "integratedSecurity", true, "username", true,
			"password", true, "additionalParams", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ConnectionDefinition newConnectionDefinition =
			addConnectionDefinition();

		ConnectionDefinition existingConnectionDefinition =
			_persistence.fetchByPrimaryKey(
				newConnectionDefinition.getPrimaryKey());

		Assert.assertEquals(
			existingConnectionDefinition, newConnectionDefinition);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ConnectionDefinition missingConnectionDefinition =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingConnectionDefinition);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		ConnectionDefinition newConnectionDefinition1 =
			addConnectionDefinition();
		ConnectionDefinition newConnectionDefinition2 =
			addConnectionDefinition();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newConnectionDefinition1.getPrimaryKey());
		primaryKeys.add(newConnectionDefinition2.getPrimaryKey());

		Map<Serializable, ConnectionDefinition> connectionDefinitions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, connectionDefinitions.size());
		Assert.assertEquals(
			newConnectionDefinition1,
			connectionDefinitions.get(
				newConnectionDefinition1.getPrimaryKey()));
		Assert.assertEquals(
			newConnectionDefinition2,
			connectionDefinitions.get(
				newConnectionDefinition2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ConnectionDefinition> connectionDefinitions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(connectionDefinitions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		ConnectionDefinition newConnectionDefinition =
			addConnectionDefinition();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newConnectionDefinition.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ConnectionDefinition> connectionDefinitions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, connectionDefinitions.size());
		Assert.assertEquals(
			newConnectionDefinition,
			connectionDefinitions.get(newConnectionDefinition.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ConnectionDefinition> connectionDefinitions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(connectionDefinitions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		ConnectionDefinition newConnectionDefinition =
			addConnectionDefinition();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newConnectionDefinition.getPrimaryKey());

		Map<Serializable, ConnectionDefinition> connectionDefinitions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, connectionDefinitions.size());
		Assert.assertEquals(
			newConnectionDefinition,
			connectionDefinitions.get(newConnectionDefinition.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ConnectionDefinitionLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<ConnectionDefinition>() {

				@Override
				public void performAction(
					ConnectionDefinition connectionDefinition) {

					Assert.assertNotNull(connectionDefinition);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		ConnectionDefinition newConnectionDefinition =
			addConnectionDefinition();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ConnectionDefinition.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"connectionId", newConnectionDefinition.getConnectionId()));

		List<ConnectionDefinition> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		ConnectionDefinition existingConnectionDefinition = result.get(0);

		Assert.assertEquals(
			existingConnectionDefinition, newConnectionDefinition);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ConnectionDefinition.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"connectionId", RandomTestUtil.nextLong()));

		List<ConnectionDefinition> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		ConnectionDefinition newConnectionDefinition =
			addConnectionDefinition();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ConnectionDefinition.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("connectionId"));

		Object newConnectionId = newConnectionDefinition.getConnectionId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"connectionId", new Object[] {newConnectionId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingConnectionId = result.get(0);

		Assert.assertEquals(existingConnectionId, newConnectionId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ConnectionDefinition.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("connectionId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"connectionId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected ConnectionDefinition addConnectionDefinition() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ConnectionDefinition connectionDefinition = _persistence.create(pk);

		connectionDefinition.setName(RandomTestUtil.randomString());

		connectionDefinition.setDriver(RandomTestUtil.randomString());

		connectionDefinition.setUrl(RandomTestUtil.randomString());

		connectionDefinition.setServerAddress(RandomTestUtil.randomString());

		connectionDefinition.setServerPort(RandomTestUtil.randomString(7));

		connectionDefinition.setDatabaseName(RandomTestUtil.randomString());

		connectionDefinition.setIntegratedSecurity();

		connectionDefinition.setUsername(RandomTestUtil.randomString());

		connectionDefinition.setPassword(RandomTestUtil.randomString());

		connectionDefinition.setAdditionalParams(RandomTestUtil.randomString());

		_connectionDefinitions.add(_persistence.update(connectionDefinition));

		return connectionDefinition;
	}

	private List<ConnectionDefinition> _connectionDefinitions =
		new ArrayList<ConnectionDefinition>();
	private ConnectionDefinitionPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}