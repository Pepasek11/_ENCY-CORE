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

import cz.csob.ency.workflow.exception.NoSuchTransitionInstanceException;
import cz.csob.ency.workflow.model.EncyWorkflowTransitionInstance;
import cz.csob.ency.workflow.service.EncyWorkflowTransitionInstanceLocalServiceUtil;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowTransitionInstancePersistence;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowTransitionInstanceUtil;

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
public class EncyWorkflowTransitionInstancePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "cz.csob.ency.workflow.service"));

	@Before
	public void setUp() {
		_persistence = EncyWorkflowTransitionInstanceUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<EncyWorkflowTransitionInstance> iterator =
			_encyWorkflowTransitionInstances.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance =
			_persistence.create(pk);

		Assert.assertNotNull(encyWorkflowTransitionInstance);

		Assert.assertEquals(encyWorkflowTransitionInstance.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		EncyWorkflowTransitionInstance newEncyWorkflowTransitionInstance =
			addEncyWorkflowTransitionInstance();

		_persistence.remove(newEncyWorkflowTransitionInstance);

		EncyWorkflowTransitionInstance existingEncyWorkflowTransitionInstance =
			_persistence.fetchByPrimaryKey(
				newEncyWorkflowTransitionInstance.getPrimaryKey());

		Assert.assertNull(existingEncyWorkflowTransitionInstance);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEncyWorkflowTransitionInstance();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflowTransitionInstance newEncyWorkflowTransitionInstance =
			_persistence.create(pk);

		newEncyWorkflowTransitionInstance.setUuid(
			RandomTestUtil.randomString());

		newEncyWorkflowTransitionInstance.setTransitionId(
			RandomTestUtil.nextLong());

		newEncyWorkflowTransitionInstance.setStateId(RandomTestUtil.nextLong());

		newEncyWorkflowTransitionInstance.setStateInstanceId(
			RandomTestUtil.nextLong());

		newEncyWorkflowTransitionInstance.setWorkflowId(
			RandomTestUtil.nextLong());

		newEncyWorkflowTransitionInstance.setWorkflowInstanceId(
			RandomTestUtil.nextLong());

		newEncyWorkflowTransitionInstance.setVersion(RandomTestUtil.nextLong());

		newEncyWorkflowTransitionInstance.setComment(
			RandomTestUtil.randomString());

		newEncyWorkflowTransitionInstance.setTargetStateId(
			RandomTestUtil.nextLong());

		newEncyWorkflowTransitionInstance.setTargetStateInstanceId(
			RandomTestUtil.nextLong());

		newEncyWorkflowTransitionInstance.setGroupId(RandomTestUtil.nextLong());

		newEncyWorkflowTransitionInstance.setCompanyId(
			RandomTestUtil.nextLong());

		newEncyWorkflowTransitionInstance.setUserId(RandomTestUtil.nextLong());

		newEncyWorkflowTransitionInstance.setUserName(
			RandomTestUtil.randomString());

		newEncyWorkflowTransitionInstance.setCreateDate(
			RandomTestUtil.nextDate());

		newEncyWorkflowTransitionInstance.setWorkflowContext(
			RandomTestUtil.randomString());

		_encyWorkflowTransitionInstances.add(
			_persistence.update(newEncyWorkflowTransitionInstance));

		EncyWorkflowTransitionInstance existingEncyWorkflowTransitionInstance =
			_persistence.findByPrimaryKey(
				newEncyWorkflowTransitionInstance.getPrimaryKey());

		Assert.assertEquals(
			existingEncyWorkflowTransitionInstance.getUuid(),
			newEncyWorkflowTransitionInstance.getUuid());
		Assert.assertEquals(
			existingEncyWorkflowTransitionInstance.getTransitionInstanceId(),
			newEncyWorkflowTransitionInstance.getTransitionInstanceId());
		Assert.assertEquals(
			existingEncyWorkflowTransitionInstance.getTransitionId(),
			newEncyWorkflowTransitionInstance.getTransitionId());
		Assert.assertEquals(
			existingEncyWorkflowTransitionInstance.getStateId(),
			newEncyWorkflowTransitionInstance.getStateId());
		Assert.assertEquals(
			existingEncyWorkflowTransitionInstance.getStateInstanceId(),
			newEncyWorkflowTransitionInstance.getStateInstanceId());
		Assert.assertEquals(
			existingEncyWorkflowTransitionInstance.getWorkflowId(),
			newEncyWorkflowTransitionInstance.getWorkflowId());
		Assert.assertEquals(
			existingEncyWorkflowTransitionInstance.getWorkflowInstanceId(),
			newEncyWorkflowTransitionInstance.getWorkflowInstanceId());
		Assert.assertEquals(
			existingEncyWorkflowTransitionInstance.getVersion(),
			newEncyWorkflowTransitionInstance.getVersion());
		Assert.assertEquals(
			existingEncyWorkflowTransitionInstance.getComment(),
			newEncyWorkflowTransitionInstance.getComment());
		Assert.assertEquals(
			existingEncyWorkflowTransitionInstance.getTargetStateId(),
			newEncyWorkflowTransitionInstance.getTargetStateId());
		Assert.assertEquals(
			existingEncyWorkflowTransitionInstance.getTargetStateInstanceId(),
			newEncyWorkflowTransitionInstance.getTargetStateInstanceId());
		Assert.assertEquals(
			existingEncyWorkflowTransitionInstance.getGroupId(),
			newEncyWorkflowTransitionInstance.getGroupId());
		Assert.assertEquals(
			existingEncyWorkflowTransitionInstance.getCompanyId(),
			newEncyWorkflowTransitionInstance.getCompanyId());
		Assert.assertEquals(
			existingEncyWorkflowTransitionInstance.getUserId(),
			newEncyWorkflowTransitionInstance.getUserId());
		Assert.assertEquals(
			existingEncyWorkflowTransitionInstance.getUserName(),
			newEncyWorkflowTransitionInstance.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingEncyWorkflowTransitionInstance.getCreateDate()),
			Time.getShortTimestamp(
				newEncyWorkflowTransitionInstance.getCreateDate()));
		Assert.assertEquals(
			existingEncyWorkflowTransitionInstance.getWorkflowContext(),
			newEncyWorkflowTransitionInstance.getWorkflowContext());
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
	public void testFindByPrimaryKeyExisting() throws Exception {
		EncyWorkflowTransitionInstance newEncyWorkflowTransitionInstance =
			addEncyWorkflowTransitionInstance();

		EncyWorkflowTransitionInstance existingEncyWorkflowTransitionInstance =
			_persistence.findByPrimaryKey(
				newEncyWorkflowTransitionInstance.getPrimaryKey());

		Assert.assertEquals(
			existingEncyWorkflowTransitionInstance,
			newEncyWorkflowTransitionInstance);
	}

	@Test(expected = NoSuchTransitionInstanceException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<EncyWorkflowTransitionInstance>
		getOrderByComparator() {

		return OrderByComparatorFactoryUtil.create(
			"ency_workflowtransitioninstance", "uuid", true,
			"transitionInstanceId", true, "transitionId", true, "stateId", true,
			"stateInstanceId", true, "workflowId", true, "workflowInstanceId",
			true, "version", true, "comment", true, "targetStateId", true,
			"targetStateInstanceId", true, "groupId", true, "companyId", true,
			"userId", true, "userName", true, "createDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		EncyWorkflowTransitionInstance newEncyWorkflowTransitionInstance =
			addEncyWorkflowTransitionInstance();

		EncyWorkflowTransitionInstance existingEncyWorkflowTransitionInstance =
			_persistence.fetchByPrimaryKey(
				newEncyWorkflowTransitionInstance.getPrimaryKey());

		Assert.assertEquals(
			existingEncyWorkflowTransitionInstance,
			newEncyWorkflowTransitionInstance);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflowTransitionInstance missingEncyWorkflowTransitionInstance =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEncyWorkflowTransitionInstance);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		EncyWorkflowTransitionInstance newEncyWorkflowTransitionInstance1 =
			addEncyWorkflowTransitionInstance();
		EncyWorkflowTransitionInstance newEncyWorkflowTransitionInstance2 =
			addEncyWorkflowTransitionInstance();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEncyWorkflowTransitionInstance1.getPrimaryKey());
		primaryKeys.add(newEncyWorkflowTransitionInstance2.getPrimaryKey());

		Map<Serializable, EncyWorkflowTransitionInstance>
			encyWorkflowTransitionInstances = _persistence.fetchByPrimaryKeys(
				primaryKeys);

		Assert.assertEquals(2, encyWorkflowTransitionInstances.size());
		Assert.assertEquals(
			newEncyWorkflowTransitionInstance1,
			encyWorkflowTransitionInstances.get(
				newEncyWorkflowTransitionInstance1.getPrimaryKey()));
		Assert.assertEquals(
			newEncyWorkflowTransitionInstance2,
			encyWorkflowTransitionInstances.get(
				newEncyWorkflowTransitionInstance2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, EncyWorkflowTransitionInstance>
			encyWorkflowTransitionInstances = _persistence.fetchByPrimaryKeys(
				primaryKeys);

		Assert.assertTrue(encyWorkflowTransitionInstances.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		EncyWorkflowTransitionInstance newEncyWorkflowTransitionInstance =
			addEncyWorkflowTransitionInstance();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEncyWorkflowTransitionInstance.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, EncyWorkflowTransitionInstance>
			encyWorkflowTransitionInstances = _persistence.fetchByPrimaryKeys(
				primaryKeys);

		Assert.assertEquals(1, encyWorkflowTransitionInstances.size());
		Assert.assertEquals(
			newEncyWorkflowTransitionInstance,
			encyWorkflowTransitionInstances.get(
				newEncyWorkflowTransitionInstance.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, EncyWorkflowTransitionInstance>
			encyWorkflowTransitionInstances = _persistence.fetchByPrimaryKeys(
				primaryKeys);

		Assert.assertTrue(encyWorkflowTransitionInstances.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		EncyWorkflowTransitionInstance newEncyWorkflowTransitionInstance =
			addEncyWorkflowTransitionInstance();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEncyWorkflowTransitionInstance.getPrimaryKey());

		Map<Serializable, EncyWorkflowTransitionInstance>
			encyWorkflowTransitionInstances = _persistence.fetchByPrimaryKeys(
				primaryKeys);

		Assert.assertEquals(1, encyWorkflowTransitionInstances.size());
		Assert.assertEquals(
			newEncyWorkflowTransitionInstance,
			encyWorkflowTransitionInstances.get(
				newEncyWorkflowTransitionInstance.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			EncyWorkflowTransitionInstanceLocalServiceUtil.
				getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<EncyWorkflowTransitionInstance>() {

				@Override
				public void performAction(
					EncyWorkflowTransitionInstance
						encyWorkflowTransitionInstance) {

					Assert.assertNotNull(encyWorkflowTransitionInstance);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		EncyWorkflowTransitionInstance newEncyWorkflowTransitionInstance =
			addEncyWorkflowTransitionInstance();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowTransitionInstance.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"transitionInstanceId",
				newEncyWorkflowTransitionInstance.getTransitionInstanceId()));

		List<EncyWorkflowTransitionInstance> result =
			_persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		EncyWorkflowTransitionInstance existingEncyWorkflowTransitionInstance =
			result.get(0);

		Assert.assertEquals(
			existingEncyWorkflowTransitionInstance,
			newEncyWorkflowTransitionInstance);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowTransitionInstance.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"transitionInstanceId", RandomTestUtil.nextLong()));

		List<EncyWorkflowTransitionInstance> result =
			_persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		EncyWorkflowTransitionInstance newEncyWorkflowTransitionInstance =
			addEncyWorkflowTransitionInstance();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowTransitionInstance.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("transitionInstanceId"));

		Object newTransitionInstanceId =
			newEncyWorkflowTransitionInstance.getTransitionInstanceId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"transitionInstanceId",
				new Object[] {newTransitionInstanceId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingTransitionInstanceId = result.get(0);

		Assert.assertEquals(
			existingTransitionInstanceId, newTransitionInstanceId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowTransitionInstance.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("transitionInstanceId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"transitionInstanceId",
				new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		EncyWorkflowTransitionInstance newEncyWorkflowTransitionInstance =
			addEncyWorkflowTransitionInstance();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(
				newEncyWorkflowTransitionInstance.getPrimaryKey()));
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

		EncyWorkflowTransitionInstance newEncyWorkflowTransitionInstance =
			addEncyWorkflowTransitionInstance();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowTransitionInstance.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"transitionInstanceId",
				newEncyWorkflowTransitionInstance.getTransitionInstanceId()));

		List<EncyWorkflowTransitionInstance> result =
			_persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(
		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance) {

		Assert.assertEquals(
			encyWorkflowTransitionInstance.getUuid(),
			ReflectionTestUtil.invoke(
				encyWorkflowTransitionInstance, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(encyWorkflowTransitionInstance.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				encyWorkflowTransitionInstance, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected EncyWorkflowTransitionInstance addEncyWorkflowTransitionInstance()
		throws Exception {

		long pk = RandomTestUtil.nextLong();

		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance =
			_persistence.create(pk);

		encyWorkflowTransitionInstance.setUuid(RandomTestUtil.randomString());

		encyWorkflowTransitionInstance.setTransitionId(
			RandomTestUtil.nextLong());

		encyWorkflowTransitionInstance.setStateId(RandomTestUtil.nextLong());

		encyWorkflowTransitionInstance.setStateInstanceId(
			RandomTestUtil.nextLong());

		encyWorkflowTransitionInstance.setWorkflowId(RandomTestUtil.nextLong());

		encyWorkflowTransitionInstance.setWorkflowInstanceId(
			RandomTestUtil.nextLong());

		encyWorkflowTransitionInstance.setVersion(RandomTestUtil.nextLong());

		encyWorkflowTransitionInstance.setComment(
			RandomTestUtil.randomString());

		encyWorkflowTransitionInstance.setTargetStateId(
			RandomTestUtil.nextLong());

		encyWorkflowTransitionInstance.setTargetStateInstanceId(
			RandomTestUtil.nextLong());

		encyWorkflowTransitionInstance.setGroupId(RandomTestUtil.nextLong());

		encyWorkflowTransitionInstance.setCompanyId(RandomTestUtil.nextLong());

		encyWorkflowTransitionInstance.setUserId(RandomTestUtil.nextLong());

		encyWorkflowTransitionInstance.setUserName(
			RandomTestUtil.randomString());

		encyWorkflowTransitionInstance.setCreateDate(RandomTestUtil.nextDate());

		encyWorkflowTransitionInstance.setWorkflowContext(
			RandomTestUtil.randomString());

		_encyWorkflowTransitionInstances.add(
			_persistence.update(encyWorkflowTransitionInstance));

		return encyWorkflowTransitionInstance;
	}

	private List<EncyWorkflowTransitionInstance>
		_encyWorkflowTransitionInstances =
			new ArrayList<EncyWorkflowTransitionInstance>();
	private EncyWorkflowTransitionInstancePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}