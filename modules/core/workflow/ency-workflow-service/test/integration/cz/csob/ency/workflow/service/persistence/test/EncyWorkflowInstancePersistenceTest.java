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

import cz.csob.ency.workflow.exception.NoSuchInstanceException;
import cz.csob.ency.workflow.model.EncyWorkflowInstance;
import cz.csob.ency.workflow.service.EncyWorkflowInstanceLocalServiceUtil;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowInstancePersistence;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowInstanceUtil;

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
public class EncyWorkflowInstancePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "cz.csob.ency.workflow.service"));

	@Before
	public void setUp() {
		_persistence = EncyWorkflowInstanceUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<EncyWorkflowInstance> iterator =
			_encyWorkflowInstances.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflowInstance encyWorkflowInstance = _persistence.create(pk);

		Assert.assertNotNull(encyWorkflowInstance);

		Assert.assertEquals(encyWorkflowInstance.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		EncyWorkflowInstance newEncyWorkflowInstance =
			addEncyWorkflowInstance();

		_persistence.remove(newEncyWorkflowInstance);

		EncyWorkflowInstance existingEncyWorkflowInstance =
			_persistence.fetchByPrimaryKey(
				newEncyWorkflowInstance.getPrimaryKey());

		Assert.assertNull(existingEncyWorkflowInstance);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEncyWorkflowInstance();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflowInstance newEncyWorkflowInstance = _persistence.create(pk);

		newEncyWorkflowInstance.setUuid(RandomTestUtil.randomString());

		newEncyWorkflowInstance.setGroupId(RandomTestUtil.nextLong());

		newEncyWorkflowInstance.setCompanyId(RandomTestUtil.nextLong());

		newEncyWorkflowInstance.setUserId(RandomTestUtil.nextLong());

		newEncyWorkflowInstance.setUserName(RandomTestUtil.randomString());

		newEncyWorkflowInstance.setCreateDate(RandomTestUtil.nextDate());

		newEncyWorkflowInstance.setModifiedDate(RandomTestUtil.nextDate());

		newEncyWorkflowInstance.setWorkflowId(RandomTestUtil.nextLong());

		newEncyWorkflowInstance.setWorkflowVersion(RandomTestUtil.nextLong());

		newEncyWorkflowInstance.setClassName(RandomTestUtil.randomString());

		newEncyWorkflowInstance.setClassPK(RandomTestUtil.nextLong());

		newEncyWorkflowInstance.setWorkflowContext(
			RandomTestUtil.randomString());

		_encyWorkflowInstances.add(
			_persistence.update(newEncyWorkflowInstance));

		EncyWorkflowInstance existingEncyWorkflowInstance =
			_persistence.findByPrimaryKey(
				newEncyWorkflowInstance.getPrimaryKey());

		Assert.assertEquals(
			existingEncyWorkflowInstance.getUuid(),
			newEncyWorkflowInstance.getUuid());
		Assert.assertEquals(
			existingEncyWorkflowInstance.getWorkflowInstanceId(),
			newEncyWorkflowInstance.getWorkflowInstanceId());
		Assert.assertEquals(
			existingEncyWorkflowInstance.getGroupId(),
			newEncyWorkflowInstance.getGroupId());
		Assert.assertEquals(
			existingEncyWorkflowInstance.getCompanyId(),
			newEncyWorkflowInstance.getCompanyId());
		Assert.assertEquals(
			existingEncyWorkflowInstance.getUserId(),
			newEncyWorkflowInstance.getUserId());
		Assert.assertEquals(
			existingEncyWorkflowInstance.getUserName(),
			newEncyWorkflowInstance.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingEncyWorkflowInstance.getCreateDate()),
			Time.getShortTimestamp(newEncyWorkflowInstance.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingEncyWorkflowInstance.getModifiedDate()),
			Time.getShortTimestamp(newEncyWorkflowInstance.getModifiedDate()));
		Assert.assertEquals(
			existingEncyWorkflowInstance.getWorkflowId(),
			newEncyWorkflowInstance.getWorkflowId());
		Assert.assertEquals(
			existingEncyWorkflowInstance.getWorkflowVersion(),
			newEncyWorkflowInstance.getWorkflowVersion());
		Assert.assertEquals(
			existingEncyWorkflowInstance.getClassName(),
			newEncyWorkflowInstance.getClassName());
		Assert.assertEquals(
			existingEncyWorkflowInstance.getClassPK(),
			newEncyWorkflowInstance.getClassPK());
		Assert.assertEquals(
			existingEncyWorkflowInstance.getWorkflowContext(),
			newEncyWorkflowInstance.getWorkflowContext());
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
	public void testCountByC_C() throws Exception {
		_persistence.countByC_C("", RandomTestUtil.nextLong());

		_persistence.countByC_C("null", 0L);

		_persistence.countByC_C((String)null, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		EncyWorkflowInstance newEncyWorkflowInstance =
			addEncyWorkflowInstance();

		EncyWorkflowInstance existingEncyWorkflowInstance =
			_persistence.findByPrimaryKey(
				newEncyWorkflowInstance.getPrimaryKey());

		Assert.assertEquals(
			existingEncyWorkflowInstance, newEncyWorkflowInstance);
	}

	@Test(expected = NoSuchInstanceException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<EncyWorkflowInstance> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ency_workflowinstance", "uuid", true, "workflowInstanceId", true,
			"groupId", true, "companyId", true, "userId", true, "userName",
			true, "createDate", true, "modifiedDate", true, "workflowId", true,
			"workflowVersion", true, "className", true, "classPK", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		EncyWorkflowInstance newEncyWorkflowInstance =
			addEncyWorkflowInstance();

		EncyWorkflowInstance existingEncyWorkflowInstance =
			_persistence.fetchByPrimaryKey(
				newEncyWorkflowInstance.getPrimaryKey());

		Assert.assertEquals(
			existingEncyWorkflowInstance, newEncyWorkflowInstance);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflowInstance missingEncyWorkflowInstance =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEncyWorkflowInstance);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		EncyWorkflowInstance newEncyWorkflowInstance1 =
			addEncyWorkflowInstance();
		EncyWorkflowInstance newEncyWorkflowInstance2 =
			addEncyWorkflowInstance();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEncyWorkflowInstance1.getPrimaryKey());
		primaryKeys.add(newEncyWorkflowInstance2.getPrimaryKey());

		Map<Serializable, EncyWorkflowInstance> encyWorkflowInstances =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, encyWorkflowInstances.size());
		Assert.assertEquals(
			newEncyWorkflowInstance1,
			encyWorkflowInstances.get(
				newEncyWorkflowInstance1.getPrimaryKey()));
		Assert.assertEquals(
			newEncyWorkflowInstance2,
			encyWorkflowInstances.get(
				newEncyWorkflowInstance2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, EncyWorkflowInstance> encyWorkflowInstances =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(encyWorkflowInstances.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		EncyWorkflowInstance newEncyWorkflowInstance =
			addEncyWorkflowInstance();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEncyWorkflowInstance.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, EncyWorkflowInstance> encyWorkflowInstances =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, encyWorkflowInstances.size());
		Assert.assertEquals(
			newEncyWorkflowInstance,
			encyWorkflowInstances.get(newEncyWorkflowInstance.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, EncyWorkflowInstance> encyWorkflowInstances =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(encyWorkflowInstances.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		EncyWorkflowInstance newEncyWorkflowInstance =
			addEncyWorkflowInstance();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEncyWorkflowInstance.getPrimaryKey());

		Map<Serializable, EncyWorkflowInstance> encyWorkflowInstances =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, encyWorkflowInstances.size());
		Assert.assertEquals(
			newEncyWorkflowInstance,
			encyWorkflowInstances.get(newEncyWorkflowInstance.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			EncyWorkflowInstanceLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<EncyWorkflowInstance>() {

				@Override
				public void performAction(
					EncyWorkflowInstance encyWorkflowInstance) {

					Assert.assertNotNull(encyWorkflowInstance);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		EncyWorkflowInstance newEncyWorkflowInstance =
			addEncyWorkflowInstance();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowInstance.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"workflowInstanceId",
				newEncyWorkflowInstance.getWorkflowInstanceId()));

		List<EncyWorkflowInstance> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		EncyWorkflowInstance existingEncyWorkflowInstance = result.get(0);

		Assert.assertEquals(
			existingEncyWorkflowInstance, newEncyWorkflowInstance);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowInstance.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"workflowInstanceId", RandomTestUtil.nextLong()));

		List<EncyWorkflowInstance> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		EncyWorkflowInstance newEncyWorkflowInstance =
			addEncyWorkflowInstance();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowInstance.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("workflowInstanceId"));

		Object newWorkflowInstanceId =
			newEncyWorkflowInstance.getWorkflowInstanceId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"workflowInstanceId", new Object[] {newWorkflowInstanceId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingWorkflowInstanceId = result.get(0);

		Assert.assertEquals(existingWorkflowInstanceId, newWorkflowInstanceId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowInstance.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("workflowInstanceId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"workflowInstanceId",
				new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		EncyWorkflowInstance newEncyWorkflowInstance =
			addEncyWorkflowInstance();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(
				newEncyWorkflowInstance.getPrimaryKey()));
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

		EncyWorkflowInstance newEncyWorkflowInstance =
			addEncyWorkflowInstance();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowInstance.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"workflowInstanceId",
				newEncyWorkflowInstance.getWorkflowInstanceId()));

		List<EncyWorkflowInstance> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(
		EncyWorkflowInstance encyWorkflowInstance) {

		Assert.assertEquals(
			encyWorkflowInstance.getUuid(),
			ReflectionTestUtil.invoke(
				encyWorkflowInstance, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(encyWorkflowInstance.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				encyWorkflowInstance, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));

		Assert.assertEquals(
			encyWorkflowInstance.getClassName(),
			ReflectionTestUtil.invoke(
				encyWorkflowInstance, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "className"));
		Assert.assertEquals(
			Long.valueOf(encyWorkflowInstance.getClassPK()),
			ReflectionTestUtil.<Long>invoke(
				encyWorkflowInstance, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "classPK"));
	}

	protected EncyWorkflowInstance addEncyWorkflowInstance() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflowInstance encyWorkflowInstance = _persistence.create(pk);

		encyWorkflowInstance.setUuid(RandomTestUtil.randomString());

		encyWorkflowInstance.setGroupId(RandomTestUtil.nextLong());

		encyWorkflowInstance.setCompanyId(RandomTestUtil.nextLong());

		encyWorkflowInstance.setUserId(RandomTestUtil.nextLong());

		encyWorkflowInstance.setUserName(RandomTestUtil.randomString());

		encyWorkflowInstance.setCreateDate(RandomTestUtil.nextDate());

		encyWorkflowInstance.setModifiedDate(RandomTestUtil.nextDate());

		encyWorkflowInstance.setWorkflowId(RandomTestUtil.nextLong());

		encyWorkflowInstance.setWorkflowVersion(RandomTestUtil.nextLong());

		encyWorkflowInstance.setClassName(RandomTestUtil.randomString());

		encyWorkflowInstance.setClassPK(RandomTestUtil.nextLong());

		encyWorkflowInstance.setWorkflowContext(RandomTestUtil.randomString());

		_encyWorkflowInstances.add(_persistence.update(encyWorkflowInstance));

		return encyWorkflowInstance;
	}

	private List<EncyWorkflowInstance> _encyWorkflowInstances =
		new ArrayList<EncyWorkflowInstance>();
	private EncyWorkflowInstancePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}