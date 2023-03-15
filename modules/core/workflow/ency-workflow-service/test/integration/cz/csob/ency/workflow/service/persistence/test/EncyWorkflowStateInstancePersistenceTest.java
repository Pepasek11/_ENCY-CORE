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

import cz.csob.ency.workflow.exception.NoSuchStateInstanceException;
import cz.csob.ency.workflow.model.EncyWorkflowStateInstance;
import cz.csob.ency.workflow.service.EncyWorkflowStateInstanceLocalServiceUtil;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowStateInstancePersistence;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowStateInstanceUtil;

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
public class EncyWorkflowStateInstancePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "cz.csob.ency.workflow.service"));

	@Before
	public void setUp() {
		_persistence = EncyWorkflowStateInstanceUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<EncyWorkflowStateInstance> iterator =
			_encyWorkflowStateInstances.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflowStateInstance encyWorkflowStateInstance =
			_persistence.create(pk);

		Assert.assertNotNull(encyWorkflowStateInstance);

		Assert.assertEquals(encyWorkflowStateInstance.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		EncyWorkflowStateInstance newEncyWorkflowStateInstance =
			addEncyWorkflowStateInstance();

		_persistence.remove(newEncyWorkflowStateInstance);

		EncyWorkflowStateInstance existingEncyWorkflowStateInstance =
			_persistence.fetchByPrimaryKey(
				newEncyWorkflowStateInstance.getPrimaryKey());

		Assert.assertNull(existingEncyWorkflowStateInstance);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEncyWorkflowStateInstance();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflowStateInstance newEncyWorkflowStateInstance =
			_persistence.create(pk);

		newEncyWorkflowStateInstance.setUuid(RandomTestUtil.randomString());

		newEncyWorkflowStateInstance.setStateId(RandomTestUtil.nextLong());

		newEncyWorkflowStateInstance.setWorkflowId(RandomTestUtil.nextLong());

		newEncyWorkflowStateInstance.setWorkflowInstanceId(
			RandomTestUtil.nextLong());

		newEncyWorkflowStateInstance.setVersion(RandomTestUtil.nextLong());

		newEncyWorkflowStateInstance.setGroupId(RandomTestUtil.nextLong());

		newEncyWorkflowStateInstance.setCompanyId(RandomTestUtil.nextLong());

		newEncyWorkflowStateInstance.setUserId(RandomTestUtil.nextLong());

		newEncyWorkflowStateInstance.setUserName(RandomTestUtil.randomString());

		newEncyWorkflowStateInstance.setCreateDate(RandomTestUtil.nextDate());

		newEncyWorkflowStateInstance.setModifiedDate(RandomTestUtil.nextDate());

		newEncyWorkflowStateInstance.setCompletedDate(
			RandomTestUtil.nextDate());

		newEncyWorkflowStateInstance.setWorkflowContext(
			RandomTestUtil.randomString());

		_encyWorkflowStateInstances.add(
			_persistence.update(newEncyWorkflowStateInstance));

		EncyWorkflowStateInstance existingEncyWorkflowStateInstance =
			_persistence.findByPrimaryKey(
				newEncyWorkflowStateInstance.getPrimaryKey());

		Assert.assertEquals(
			existingEncyWorkflowStateInstance.getUuid(),
			newEncyWorkflowStateInstance.getUuid());
		Assert.assertEquals(
			existingEncyWorkflowStateInstance.getStateInstanceId(),
			newEncyWorkflowStateInstance.getStateInstanceId());
		Assert.assertEquals(
			existingEncyWorkflowStateInstance.getStateId(),
			newEncyWorkflowStateInstance.getStateId());
		Assert.assertEquals(
			existingEncyWorkflowStateInstance.getWorkflowId(),
			newEncyWorkflowStateInstance.getWorkflowId());
		Assert.assertEquals(
			existingEncyWorkflowStateInstance.getWorkflowInstanceId(),
			newEncyWorkflowStateInstance.getWorkflowInstanceId());
		Assert.assertEquals(
			existingEncyWorkflowStateInstance.getVersion(),
			newEncyWorkflowStateInstance.getVersion());
		Assert.assertEquals(
			existingEncyWorkflowStateInstance.getGroupId(),
			newEncyWorkflowStateInstance.getGroupId());
		Assert.assertEquals(
			existingEncyWorkflowStateInstance.getCompanyId(),
			newEncyWorkflowStateInstance.getCompanyId());
		Assert.assertEquals(
			existingEncyWorkflowStateInstance.getUserId(),
			newEncyWorkflowStateInstance.getUserId());
		Assert.assertEquals(
			existingEncyWorkflowStateInstance.getUserName(),
			newEncyWorkflowStateInstance.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingEncyWorkflowStateInstance.getCreateDate()),
			Time.getShortTimestamp(
				newEncyWorkflowStateInstance.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingEncyWorkflowStateInstance.getModifiedDate()),
			Time.getShortTimestamp(
				newEncyWorkflowStateInstance.getModifiedDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingEncyWorkflowStateInstance.getCompletedDate()),
			Time.getShortTimestamp(
				newEncyWorkflowStateInstance.getCompletedDate()));
		Assert.assertEquals(
			existingEncyWorkflowStateInstance.getWorkflowContext(),
			newEncyWorkflowStateInstance.getWorkflowContext());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByWorkflowInstanceId() throws Exception {
		_persistence.countByWorkflowInstanceId(RandomTestUtil.nextLong());

		_persistence.countByWorkflowInstanceId(0L);
	}

	@Test
	public void testCountByWorkflowId() throws Exception {
		_persistence.countByWorkflowId(RandomTestUtil.nextLong());

		_persistence.countByWorkflowId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		EncyWorkflowStateInstance newEncyWorkflowStateInstance =
			addEncyWorkflowStateInstance();

		EncyWorkflowStateInstance existingEncyWorkflowStateInstance =
			_persistence.findByPrimaryKey(
				newEncyWorkflowStateInstance.getPrimaryKey());

		Assert.assertEquals(
			existingEncyWorkflowStateInstance, newEncyWorkflowStateInstance);
	}

	@Test(expected = NoSuchStateInstanceException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<EncyWorkflowStateInstance>
		getOrderByComparator() {

		return OrderByComparatorFactoryUtil.create(
			"ency_workflowstateinstance", "uuid", true, "stateInstanceId", true,
			"stateId", true, "workflowId", true, "workflowInstanceId", true,
			"version", true, "groupId", true, "companyId", true, "userId", true,
			"userName", true, "createDate", true, "modifiedDate", true,
			"completedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		EncyWorkflowStateInstance newEncyWorkflowStateInstance =
			addEncyWorkflowStateInstance();

		EncyWorkflowStateInstance existingEncyWorkflowStateInstance =
			_persistence.fetchByPrimaryKey(
				newEncyWorkflowStateInstance.getPrimaryKey());

		Assert.assertEquals(
			existingEncyWorkflowStateInstance, newEncyWorkflowStateInstance);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflowStateInstance missingEncyWorkflowStateInstance =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEncyWorkflowStateInstance);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		EncyWorkflowStateInstance newEncyWorkflowStateInstance1 =
			addEncyWorkflowStateInstance();
		EncyWorkflowStateInstance newEncyWorkflowStateInstance2 =
			addEncyWorkflowStateInstance();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEncyWorkflowStateInstance1.getPrimaryKey());
		primaryKeys.add(newEncyWorkflowStateInstance2.getPrimaryKey());

		Map<Serializable, EncyWorkflowStateInstance>
			encyWorkflowStateInstances = _persistence.fetchByPrimaryKeys(
				primaryKeys);

		Assert.assertEquals(2, encyWorkflowStateInstances.size());
		Assert.assertEquals(
			newEncyWorkflowStateInstance1,
			encyWorkflowStateInstances.get(
				newEncyWorkflowStateInstance1.getPrimaryKey()));
		Assert.assertEquals(
			newEncyWorkflowStateInstance2,
			encyWorkflowStateInstances.get(
				newEncyWorkflowStateInstance2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, EncyWorkflowStateInstance>
			encyWorkflowStateInstances = _persistence.fetchByPrimaryKeys(
				primaryKeys);

		Assert.assertTrue(encyWorkflowStateInstances.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		EncyWorkflowStateInstance newEncyWorkflowStateInstance =
			addEncyWorkflowStateInstance();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEncyWorkflowStateInstance.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, EncyWorkflowStateInstance>
			encyWorkflowStateInstances = _persistence.fetchByPrimaryKeys(
				primaryKeys);

		Assert.assertEquals(1, encyWorkflowStateInstances.size());
		Assert.assertEquals(
			newEncyWorkflowStateInstance,
			encyWorkflowStateInstances.get(
				newEncyWorkflowStateInstance.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, EncyWorkflowStateInstance>
			encyWorkflowStateInstances = _persistence.fetchByPrimaryKeys(
				primaryKeys);

		Assert.assertTrue(encyWorkflowStateInstances.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		EncyWorkflowStateInstance newEncyWorkflowStateInstance =
			addEncyWorkflowStateInstance();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEncyWorkflowStateInstance.getPrimaryKey());

		Map<Serializable, EncyWorkflowStateInstance>
			encyWorkflowStateInstances = _persistence.fetchByPrimaryKeys(
				primaryKeys);

		Assert.assertEquals(1, encyWorkflowStateInstances.size());
		Assert.assertEquals(
			newEncyWorkflowStateInstance,
			encyWorkflowStateInstances.get(
				newEncyWorkflowStateInstance.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			EncyWorkflowStateInstanceLocalServiceUtil.
				getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<EncyWorkflowStateInstance>() {

				@Override
				public void performAction(
					EncyWorkflowStateInstance encyWorkflowStateInstance) {

					Assert.assertNotNull(encyWorkflowStateInstance);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		EncyWorkflowStateInstance newEncyWorkflowStateInstance =
			addEncyWorkflowStateInstance();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowStateInstance.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"stateInstanceId",
				newEncyWorkflowStateInstance.getStateInstanceId()));

		List<EncyWorkflowStateInstance> result =
			_persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		EncyWorkflowStateInstance existingEncyWorkflowStateInstance =
			result.get(0);

		Assert.assertEquals(
			existingEncyWorkflowStateInstance, newEncyWorkflowStateInstance);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowStateInstance.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"stateInstanceId", RandomTestUtil.nextLong()));

		List<EncyWorkflowStateInstance> result =
			_persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		EncyWorkflowStateInstance newEncyWorkflowStateInstance =
			addEncyWorkflowStateInstance();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowStateInstance.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("stateInstanceId"));

		Object newStateInstanceId =
			newEncyWorkflowStateInstance.getStateInstanceId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"stateInstanceId", new Object[] {newStateInstanceId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingStateInstanceId = result.get(0);

		Assert.assertEquals(existingStateInstanceId, newStateInstanceId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowStateInstance.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("stateInstanceId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"stateInstanceId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		EncyWorkflowStateInstance newEncyWorkflowStateInstance =
			addEncyWorkflowStateInstance();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(
				newEncyWorkflowStateInstance.getPrimaryKey()));
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

		EncyWorkflowStateInstance newEncyWorkflowStateInstance =
			addEncyWorkflowStateInstance();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowStateInstance.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"stateInstanceId",
				newEncyWorkflowStateInstance.getStateInstanceId()));

		List<EncyWorkflowStateInstance> result =
			_persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(
		EncyWorkflowStateInstance encyWorkflowStateInstance) {

		Assert.assertEquals(
			encyWorkflowStateInstance.getUuid(),
			ReflectionTestUtil.invoke(
				encyWorkflowStateInstance, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(encyWorkflowStateInstance.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				encyWorkflowStateInstance, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected EncyWorkflowStateInstance addEncyWorkflowStateInstance()
		throws Exception {

		long pk = RandomTestUtil.nextLong();

		EncyWorkflowStateInstance encyWorkflowStateInstance =
			_persistence.create(pk);

		encyWorkflowStateInstance.setUuid(RandomTestUtil.randomString());

		encyWorkflowStateInstance.setStateId(RandomTestUtil.nextLong());

		encyWorkflowStateInstance.setWorkflowId(RandomTestUtil.nextLong());

		encyWorkflowStateInstance.setWorkflowInstanceId(
			RandomTestUtil.nextLong());

		encyWorkflowStateInstance.setVersion(RandomTestUtil.nextLong());

		encyWorkflowStateInstance.setGroupId(RandomTestUtil.nextLong());

		encyWorkflowStateInstance.setCompanyId(RandomTestUtil.nextLong());

		encyWorkflowStateInstance.setUserId(RandomTestUtil.nextLong());

		encyWorkflowStateInstance.setUserName(RandomTestUtil.randomString());

		encyWorkflowStateInstance.setCreateDate(RandomTestUtil.nextDate());

		encyWorkflowStateInstance.setModifiedDate(RandomTestUtil.nextDate());

		encyWorkflowStateInstance.setCompletedDate(RandomTestUtil.nextDate());

		encyWorkflowStateInstance.setWorkflowContext(
			RandomTestUtil.randomString());

		_encyWorkflowStateInstances.add(
			_persistence.update(encyWorkflowStateInstance));

		return encyWorkflowStateInstance;
	}

	private List<EncyWorkflowStateInstance> _encyWorkflowStateInstances =
		new ArrayList<EncyWorkflowStateInstance>();
	private EncyWorkflowStateInstancePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}