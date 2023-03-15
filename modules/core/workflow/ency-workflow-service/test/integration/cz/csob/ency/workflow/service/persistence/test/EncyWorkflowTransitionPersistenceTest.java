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

import cz.csob.ency.workflow.exception.NoSuchTransitionException;
import cz.csob.ency.workflow.model.EncyWorkflowTransition;
import cz.csob.ency.workflow.service.EncyWorkflowTransitionLocalServiceUtil;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowTransitionPersistence;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowTransitionUtil;

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
public class EncyWorkflowTransitionPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "cz.csob.ency.workflow.service"));

	@Before
	public void setUp() {
		_persistence = EncyWorkflowTransitionUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<EncyWorkflowTransition> iterator =
			_encyWorkflowTransitions.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflowTransition encyWorkflowTransition = _persistence.create(pk);

		Assert.assertNotNull(encyWorkflowTransition);

		Assert.assertEquals(encyWorkflowTransition.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		EncyWorkflowTransition newEncyWorkflowTransition =
			addEncyWorkflowTransition();

		_persistence.remove(newEncyWorkflowTransition);

		EncyWorkflowTransition existingEncyWorkflowTransition =
			_persistence.fetchByPrimaryKey(
				newEncyWorkflowTransition.getPrimaryKey());

		Assert.assertNull(existingEncyWorkflowTransition);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEncyWorkflowTransition();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflowTransition newEncyWorkflowTransition = _persistence.create(
			pk);

		newEncyWorkflowTransition.setUuid(RandomTestUtil.randomString());

		newEncyWorkflowTransition.setStateId(RandomTestUtil.nextLong());

		newEncyWorkflowTransition.setWorkflowId(RandomTestUtil.nextLong());

		newEncyWorkflowTransition.setVersion(RandomTestUtil.nextLong());

		newEncyWorkflowTransition.setName(RandomTestUtil.randomString());

		newEncyWorkflowTransition.setTitle(RandomTestUtil.randomString());

		newEncyWorkflowTransition.setDescription(RandomTestUtil.randomString());

		newEncyWorkflowTransition.setTargetStateName(
			RandomTestUtil.randomString());

		newEncyWorkflowTransition.setTargetStateId(RandomTestUtil.nextLong());

		newEncyWorkflowTransition.setCssIcon(RandomTestUtil.randomString());

		newEncyWorkflowTransition.setCssIconColor(
			RandomTestUtil.randomString());

		newEncyWorkflowTransition.setActive();

		newEncyWorkflowTransition.setCreateDate(RandomTestUtil.nextDate());

		newEncyWorkflowTransition.setModifiedDate(RandomTestUtil.nextDate());

		newEncyWorkflowTransition.setOrder(RandomTestUtil.nextLong());

		_encyWorkflowTransitions.add(
			_persistence.update(newEncyWorkflowTransition));

		EncyWorkflowTransition existingEncyWorkflowTransition =
			_persistence.findByPrimaryKey(
				newEncyWorkflowTransition.getPrimaryKey());

		Assert.assertEquals(
			existingEncyWorkflowTransition.getUuid(),
			newEncyWorkflowTransition.getUuid());
		Assert.assertEquals(
			existingEncyWorkflowTransition.getTransitionId(),
			newEncyWorkflowTransition.getTransitionId());
		Assert.assertEquals(
			existingEncyWorkflowTransition.getStateId(),
			newEncyWorkflowTransition.getStateId());
		Assert.assertEquals(
			existingEncyWorkflowTransition.getWorkflowId(),
			newEncyWorkflowTransition.getWorkflowId());
		Assert.assertEquals(
			existingEncyWorkflowTransition.getVersion(),
			newEncyWorkflowTransition.getVersion());
		Assert.assertEquals(
			existingEncyWorkflowTransition.getName(),
			newEncyWorkflowTransition.getName());
		Assert.assertEquals(
			existingEncyWorkflowTransition.getTitle(),
			newEncyWorkflowTransition.getTitle());
		Assert.assertEquals(
			existingEncyWorkflowTransition.getDescription(),
			newEncyWorkflowTransition.getDescription());
		Assert.assertEquals(
			existingEncyWorkflowTransition.getTargetStateName(),
			newEncyWorkflowTransition.getTargetStateName());
		Assert.assertEquals(
			existingEncyWorkflowTransition.getTargetStateId(),
			newEncyWorkflowTransition.getTargetStateId());
		Assert.assertEquals(
			existingEncyWorkflowTransition.getCssIcon(),
			newEncyWorkflowTransition.getCssIcon());
		Assert.assertEquals(
			existingEncyWorkflowTransition.getCssIconColor(),
			newEncyWorkflowTransition.getCssIconColor());
		Assert.assertEquals(
			existingEncyWorkflowTransition.getActive(),
			newEncyWorkflowTransition.getActive());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingEncyWorkflowTransition.getCreateDate()),
			Time.getShortTimestamp(newEncyWorkflowTransition.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingEncyWorkflowTransition.getModifiedDate()),
			Time.getShortTimestamp(
				newEncyWorkflowTransition.getModifiedDate()));
		Assert.assertEquals(
			existingEncyWorkflowTransition.getOrder(),
			newEncyWorkflowTransition.getOrder());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByS_N() throws Exception {
		_persistence.countByS_N(RandomTestUtil.nextLong(), "");

		_persistence.countByS_N(0L, "null");

		_persistence.countByS_N(0L, (String)null);
	}

	@Test
	public void testCountByWorkflow() throws Exception {
		_persistence.countByWorkflow(RandomTestUtil.nextLong());

		_persistence.countByWorkflow(0L);
	}

	@Test
	public void testCountByState() throws Exception {
		_persistence.countByState(RandomTestUtil.nextLong());

		_persistence.countByState(0L);
	}

	@Test
	public void testCountByActive() throws Exception {
		_persistence.countByActive((Boolean)null);

		_persistence.countByActive((Boolean)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		EncyWorkflowTransition newEncyWorkflowTransition =
			addEncyWorkflowTransition();

		EncyWorkflowTransition existingEncyWorkflowTransition =
			_persistence.findByPrimaryKey(
				newEncyWorkflowTransition.getPrimaryKey());

		Assert.assertEquals(
			existingEncyWorkflowTransition, newEncyWorkflowTransition);
	}

	@Test(expected = NoSuchTransitionException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<EncyWorkflowTransition> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ency_workflowtransition", "uuid", true, "transitionId", true,
			"stateId", true, "workflowId", true, "version", true, "name", true,
			"title", true, "targetStateName", true, "targetStateId", true,
			"cssIcon", true, "cssIconColor", true, "active", true, "createDate",
			true, "modifiedDate", true, "order", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		EncyWorkflowTransition newEncyWorkflowTransition =
			addEncyWorkflowTransition();

		EncyWorkflowTransition existingEncyWorkflowTransition =
			_persistence.fetchByPrimaryKey(
				newEncyWorkflowTransition.getPrimaryKey());

		Assert.assertEquals(
			existingEncyWorkflowTransition, newEncyWorkflowTransition);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflowTransition missingEncyWorkflowTransition =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEncyWorkflowTransition);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		EncyWorkflowTransition newEncyWorkflowTransition1 =
			addEncyWorkflowTransition();
		EncyWorkflowTransition newEncyWorkflowTransition2 =
			addEncyWorkflowTransition();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEncyWorkflowTransition1.getPrimaryKey());
		primaryKeys.add(newEncyWorkflowTransition2.getPrimaryKey());

		Map<Serializable, EncyWorkflowTransition> encyWorkflowTransitions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, encyWorkflowTransitions.size());
		Assert.assertEquals(
			newEncyWorkflowTransition1,
			encyWorkflowTransitions.get(
				newEncyWorkflowTransition1.getPrimaryKey()));
		Assert.assertEquals(
			newEncyWorkflowTransition2,
			encyWorkflowTransitions.get(
				newEncyWorkflowTransition2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, EncyWorkflowTransition> encyWorkflowTransitions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(encyWorkflowTransitions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		EncyWorkflowTransition newEncyWorkflowTransition =
			addEncyWorkflowTransition();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEncyWorkflowTransition.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, EncyWorkflowTransition> encyWorkflowTransitions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, encyWorkflowTransitions.size());
		Assert.assertEquals(
			newEncyWorkflowTransition,
			encyWorkflowTransitions.get(
				newEncyWorkflowTransition.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, EncyWorkflowTransition> encyWorkflowTransitions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(encyWorkflowTransitions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		EncyWorkflowTransition newEncyWorkflowTransition =
			addEncyWorkflowTransition();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEncyWorkflowTransition.getPrimaryKey());

		Map<Serializable, EncyWorkflowTransition> encyWorkflowTransitions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, encyWorkflowTransitions.size());
		Assert.assertEquals(
			newEncyWorkflowTransition,
			encyWorkflowTransitions.get(
				newEncyWorkflowTransition.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			EncyWorkflowTransitionLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<EncyWorkflowTransition>() {

				@Override
				public void performAction(
					EncyWorkflowTransition encyWorkflowTransition) {

					Assert.assertNotNull(encyWorkflowTransition);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		EncyWorkflowTransition newEncyWorkflowTransition =
			addEncyWorkflowTransition();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowTransition.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"transitionId", newEncyWorkflowTransition.getTransitionId()));

		List<EncyWorkflowTransition> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		EncyWorkflowTransition existingEncyWorkflowTransition = result.get(0);

		Assert.assertEquals(
			existingEncyWorkflowTransition, newEncyWorkflowTransition);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowTransition.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"transitionId", RandomTestUtil.nextLong()));

		List<EncyWorkflowTransition> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		EncyWorkflowTransition newEncyWorkflowTransition =
			addEncyWorkflowTransition();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowTransition.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("transitionId"));

		Object newTransitionId = newEncyWorkflowTransition.getTransitionId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"transitionId", new Object[] {newTransitionId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingTransitionId = result.get(0);

		Assert.assertEquals(existingTransitionId, newTransitionId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowTransition.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("transitionId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"transitionId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		EncyWorkflowTransition newEncyWorkflowTransition =
			addEncyWorkflowTransition();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(
				newEncyWorkflowTransition.getPrimaryKey()));
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

		EncyWorkflowTransition newEncyWorkflowTransition =
			addEncyWorkflowTransition();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowTransition.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"transitionId", newEncyWorkflowTransition.getTransitionId()));

		List<EncyWorkflowTransition> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(
		EncyWorkflowTransition encyWorkflowTransition) {

		Assert.assertEquals(
			Long.valueOf(encyWorkflowTransition.getStateId()),
			ReflectionTestUtil.<Long>invoke(
				encyWorkflowTransition, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "stateId"));
		Assert.assertEquals(
			encyWorkflowTransition.getName(),
			ReflectionTestUtil.invoke(
				encyWorkflowTransition, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "name"));
	}

	protected EncyWorkflowTransition addEncyWorkflowTransition()
		throws Exception {

		long pk = RandomTestUtil.nextLong();

		EncyWorkflowTransition encyWorkflowTransition = _persistence.create(pk);

		encyWorkflowTransition.setUuid(RandomTestUtil.randomString());

		encyWorkflowTransition.setStateId(RandomTestUtil.nextLong());

		encyWorkflowTransition.setWorkflowId(RandomTestUtil.nextLong());

		encyWorkflowTransition.setVersion(RandomTestUtil.nextLong());

		encyWorkflowTransition.setName(RandomTestUtil.randomString());

		encyWorkflowTransition.setTitle(RandomTestUtil.randomString());

		encyWorkflowTransition.setDescription(RandomTestUtil.randomString());

		encyWorkflowTransition.setTargetStateName(
			RandomTestUtil.randomString());

		encyWorkflowTransition.setTargetStateId(RandomTestUtil.nextLong());

		encyWorkflowTransition.setCssIcon(RandomTestUtil.randomString());

		encyWorkflowTransition.setCssIconColor(RandomTestUtil.randomString());

		encyWorkflowTransition.setActive();

		encyWorkflowTransition.setCreateDate(RandomTestUtil.nextDate());

		encyWorkflowTransition.setModifiedDate(RandomTestUtil.nextDate());

		encyWorkflowTransition.setOrder(RandomTestUtil.nextLong());

		_encyWorkflowTransitions.add(
			_persistence.update(encyWorkflowTransition));

		return encyWorkflowTransition;
	}

	private List<EncyWorkflowTransition> _encyWorkflowTransitions =
		new ArrayList<EncyWorkflowTransition>();
	private EncyWorkflowTransitionPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}