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

package cz.csob.ency.workflow.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import cz.csob.ency.workflow.exception.NoSuchEncyWorkflowException;
import cz.csob.ency.workflow.model.EncyWorkflow;
import cz.csob.ency.workflow.service.EncyWorkflowLocalServiceUtil;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowPersistence;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowUtil;

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
public class EncyWorkflowPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "cz.csob.ency.workflow.service"));

	@Before
	public void setUp() {
		_persistence = EncyWorkflowUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<EncyWorkflow> iterator = _encyWorkflows.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflow encyWorkflow = _persistence.create(pk);

		Assert.assertNotNull(encyWorkflow);

		Assert.assertEquals(encyWorkflow.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		EncyWorkflow newEncyWorkflow = addEncyWorkflow();

		_persistence.remove(newEncyWorkflow);

		EncyWorkflow existingEncyWorkflow = _persistence.fetchByPrimaryKey(
			newEncyWorkflow.getPrimaryKey());

		Assert.assertNull(existingEncyWorkflow);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEncyWorkflow();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflow newEncyWorkflow = _persistence.create(pk);

		newEncyWorkflow.setUuid(RandomTestUtil.randomString());

		newEncyWorkflow.setClassName(RandomTestUtil.randomString());

		newEncyWorkflow.setTitle(RandomTestUtil.randomString());

		newEncyWorkflow.setDescription(RandomTestUtil.randomString());

		newEncyWorkflow.setInitialStateName(RandomTestUtil.randomString());

		newEncyWorkflow.setVersion(RandomTestUtil.nextLong());

		newEncyWorkflow.setActive();

		newEncyWorkflow.setCreateDate(RandomTestUtil.nextDate());

		newEncyWorkflow.setModifiedDate(RandomTestUtil.nextDate());

		_encyWorkflows.add(_persistence.update(newEncyWorkflow));

		EncyWorkflow existingEncyWorkflow = _persistence.findByPrimaryKey(
			newEncyWorkflow.getPrimaryKey());

		Assert.assertEquals(
			existingEncyWorkflow.getUuid(), newEncyWorkflow.getUuid());
		Assert.assertEquals(
			existingEncyWorkflow.getWorkflowId(),
			newEncyWorkflow.getWorkflowId());
		Assert.assertEquals(
			existingEncyWorkflow.getClassName(),
			newEncyWorkflow.getClassName());
		Assert.assertEquals(
			existingEncyWorkflow.getTitle(), newEncyWorkflow.getTitle());
		Assert.assertEquals(
			existingEncyWorkflow.getDescription(),
			newEncyWorkflow.getDescription());
		Assert.assertEquals(
			existingEncyWorkflow.getInitialStateName(),
			newEncyWorkflow.getInitialStateName());
		Assert.assertEquals(
			existingEncyWorkflow.getVersion(), newEncyWorkflow.getVersion());
		Assert.assertEquals(
			existingEncyWorkflow.getActive(), newEncyWorkflow.getActive());
		Assert.assertEquals(
			Time.getShortTimestamp(existingEncyWorkflow.getCreateDate()),
			Time.getShortTimestamp(newEncyWorkflow.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingEncyWorkflow.getModifiedDate()),
			Time.getShortTimestamp(newEncyWorkflow.getModifiedDate()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByClassName() throws Exception {
		_persistence.countByClassName("");

		_persistence.countByClassName("null");

		_persistence.countByClassName((String)null);
	}

	@Test
	public void testCountByActive() throws Exception {
		_persistence.countByActive((Boolean)null);

		_persistence.countByActive((Boolean)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		EncyWorkflow newEncyWorkflow = addEncyWorkflow();

		EncyWorkflow existingEncyWorkflow = _persistence.findByPrimaryKey(
			newEncyWorkflow.getPrimaryKey());

		Assert.assertEquals(existingEncyWorkflow, newEncyWorkflow);
	}

	@Test(expected = NoSuchEncyWorkflowException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<EncyWorkflow> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ency_workflow", "uuid", true, "workflowId", true, "className",
			true, "title", true, "initialStateName", true, "version", true,
			"active", true, "createDate", true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		EncyWorkflow newEncyWorkflow = addEncyWorkflow();

		EncyWorkflow existingEncyWorkflow = _persistence.fetchByPrimaryKey(
			newEncyWorkflow.getPrimaryKey());

		Assert.assertEquals(existingEncyWorkflow, newEncyWorkflow);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflow missingEncyWorkflow = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEncyWorkflow);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		EncyWorkflow newEncyWorkflow1 = addEncyWorkflow();
		EncyWorkflow newEncyWorkflow2 = addEncyWorkflow();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEncyWorkflow1.getPrimaryKey());
		primaryKeys.add(newEncyWorkflow2.getPrimaryKey());

		Map<Serializable, EncyWorkflow> encyWorkflows =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, encyWorkflows.size());
		Assert.assertEquals(
			newEncyWorkflow1,
			encyWorkflows.get(newEncyWorkflow1.getPrimaryKey()));
		Assert.assertEquals(
			newEncyWorkflow2,
			encyWorkflows.get(newEncyWorkflow2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, EncyWorkflow> encyWorkflows =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(encyWorkflows.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		EncyWorkflow newEncyWorkflow = addEncyWorkflow();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEncyWorkflow.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, EncyWorkflow> encyWorkflows =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, encyWorkflows.size());
		Assert.assertEquals(
			newEncyWorkflow,
			encyWorkflows.get(newEncyWorkflow.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, EncyWorkflow> encyWorkflows =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(encyWorkflows.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		EncyWorkflow newEncyWorkflow = addEncyWorkflow();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEncyWorkflow.getPrimaryKey());

		Map<Serializable, EncyWorkflow> encyWorkflows =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, encyWorkflows.size());
		Assert.assertEquals(
			newEncyWorkflow,
			encyWorkflows.get(newEncyWorkflow.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			EncyWorkflowLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<EncyWorkflow>() {

				@Override
				public void performAction(EncyWorkflow encyWorkflow) {
					Assert.assertNotNull(encyWorkflow);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		EncyWorkflow newEncyWorkflow = addEncyWorkflow();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflow.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"workflowId", newEncyWorkflow.getWorkflowId()));

		List<EncyWorkflow> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		EncyWorkflow existingEncyWorkflow = result.get(0);

		Assert.assertEquals(existingEncyWorkflow, newEncyWorkflow);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflow.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"workflowId", RandomTestUtil.nextLong()));

		List<EncyWorkflow> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		EncyWorkflow newEncyWorkflow = addEncyWorkflow();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflow.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("workflowId"));

		Object newWorkflowId = newEncyWorkflow.getWorkflowId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"workflowId", new Object[] {newWorkflowId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingWorkflowId = result.get(0);

		Assert.assertEquals(existingWorkflowId, newWorkflowId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflow.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("workflowId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"workflowId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		EncyWorkflow newEncyWorkflow = addEncyWorkflow();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newEncyWorkflow.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		EncyWorkflow newEncyWorkflow = addEncyWorkflow();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflow.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"workflowId", newEncyWorkflow.getWorkflowId()));

		List<EncyWorkflow> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(EncyWorkflow encyWorkflow) {
		Assert.assertEquals(
			encyWorkflow.getClassName(),
			ReflectionTestUtil.invoke(
				encyWorkflow, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "className"));
	}

	protected EncyWorkflow addEncyWorkflow() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflow encyWorkflow = _persistence.create(pk);

		encyWorkflow.setUuid(RandomTestUtil.randomString());

		encyWorkflow.setClassName(RandomTestUtil.randomString());

		encyWorkflow.setTitle(RandomTestUtil.randomString());

		encyWorkflow.setDescription(RandomTestUtil.randomString());

		encyWorkflow.setInitialStateName(RandomTestUtil.randomString());

		encyWorkflow.setVersion(RandomTestUtil.nextLong());

		encyWorkflow.setActive();

		encyWorkflow.setCreateDate(RandomTestUtil.nextDate());

		encyWorkflow.setModifiedDate(RandomTestUtil.nextDate());

		_encyWorkflows.add(_persistence.update(encyWorkflow));

		return encyWorkflow;
	}

	private List<EncyWorkflow> _encyWorkflows = new ArrayList<EncyWorkflow>();
	private EncyWorkflowPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}