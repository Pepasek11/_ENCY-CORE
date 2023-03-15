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

import cz.csob.ency.workflow.exception.NoSuchStateException;
import cz.csob.ency.workflow.model.EncyWorkflowState;
import cz.csob.ency.workflow.service.EncyWorkflowStateLocalServiceUtil;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowStatePersistence;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowStateUtil;

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
public class EncyWorkflowStatePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "cz.csob.ency.workflow.service"));

	@Before
	public void setUp() {
		_persistence = EncyWorkflowStateUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<EncyWorkflowState> iterator = _encyWorkflowStates.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflowState encyWorkflowState = _persistence.create(pk);

		Assert.assertNotNull(encyWorkflowState);

		Assert.assertEquals(encyWorkflowState.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		EncyWorkflowState newEncyWorkflowState = addEncyWorkflowState();

		_persistence.remove(newEncyWorkflowState);

		EncyWorkflowState existingEncyWorkflowState =
			_persistence.fetchByPrimaryKey(
				newEncyWorkflowState.getPrimaryKey());

		Assert.assertNull(existingEncyWorkflowState);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEncyWorkflowState();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflowState newEncyWorkflowState = _persistence.create(pk);

		newEncyWorkflowState.setUuid(RandomTestUtil.randomString());

		newEncyWorkflowState.setWorkflowId(RandomTestUtil.nextLong());

		newEncyWorkflowState.setName(RandomTestUtil.randomString());

		newEncyWorkflowState.setTitle(RandomTestUtil.randomString());

		newEncyWorkflowState.setDescription(RandomTestUtil.randomString());

		newEncyWorkflowState.setVersion(RandomTestUtil.nextLong());

		newEncyWorkflowState.setIsInitial();

		newEncyWorkflowState.setIsFinal();

		newEncyWorkflowState.setIsEditable();

		newEncyWorkflowState.setIsSearchable();

		newEncyWorkflowState.setIsPermanent();

		newEncyWorkflowState.setCssIcon(RandomTestUtil.randomString());

		newEncyWorkflowState.setCssIconColor(RandomTestUtil.randomString());

		newEncyWorkflowState.setCssLabelColor(RandomTestUtil.randomString());

		newEncyWorkflowState.setActive();

		newEncyWorkflowState.setCreateDate(RandomTestUtil.nextDate());

		newEncyWorkflowState.setModifiedDate(RandomTestUtil.nextDate());

		_encyWorkflowStates.add(_persistence.update(newEncyWorkflowState));

		EncyWorkflowState existingEncyWorkflowState =
			_persistence.findByPrimaryKey(newEncyWorkflowState.getPrimaryKey());

		Assert.assertEquals(
			existingEncyWorkflowState.getUuid(),
			newEncyWorkflowState.getUuid());
		Assert.assertEquals(
			existingEncyWorkflowState.getStateId(),
			newEncyWorkflowState.getStateId());
		Assert.assertEquals(
			existingEncyWorkflowState.getWorkflowId(),
			newEncyWorkflowState.getWorkflowId());
		Assert.assertEquals(
			existingEncyWorkflowState.getName(),
			newEncyWorkflowState.getName());
		Assert.assertEquals(
			existingEncyWorkflowState.getTitle(),
			newEncyWorkflowState.getTitle());
		Assert.assertEquals(
			existingEncyWorkflowState.getDescription(),
			newEncyWorkflowState.getDescription());
		Assert.assertEquals(
			existingEncyWorkflowState.getVersion(),
			newEncyWorkflowState.getVersion());
		Assert.assertEquals(
			existingEncyWorkflowState.getIsInitial(),
			newEncyWorkflowState.getIsInitial());
		Assert.assertEquals(
			existingEncyWorkflowState.getIsFinal(),
			newEncyWorkflowState.getIsFinal());
		Assert.assertEquals(
			existingEncyWorkflowState.getIsEditable(),
			newEncyWorkflowState.getIsEditable());
		Assert.assertEquals(
			existingEncyWorkflowState.getIsSearchable(),
			newEncyWorkflowState.getIsSearchable());
		Assert.assertEquals(
			existingEncyWorkflowState.getIsPermanent(),
			newEncyWorkflowState.getIsPermanent());
		Assert.assertEquals(
			existingEncyWorkflowState.getCssIcon(),
			newEncyWorkflowState.getCssIcon());
		Assert.assertEquals(
			existingEncyWorkflowState.getCssIconColor(),
			newEncyWorkflowState.getCssIconColor());
		Assert.assertEquals(
			existingEncyWorkflowState.getCssLabelColor(),
			newEncyWorkflowState.getCssLabelColor());
		Assert.assertEquals(
			existingEncyWorkflowState.getActive(),
			newEncyWorkflowState.getActive());
		Assert.assertEquals(
			Time.getShortTimestamp(existingEncyWorkflowState.getCreateDate()),
			Time.getShortTimestamp(newEncyWorkflowState.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingEncyWorkflowState.getModifiedDate()),
			Time.getShortTimestamp(newEncyWorkflowState.getModifiedDate()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByW_N() throws Exception {
		_persistence.countByW_N(RandomTestUtil.nextLong(), "");

		_persistence.countByW_N(0L, "null");

		_persistence.countByW_N(0L, (String)null);
	}

	@Test
	public void testCountByWorkflow() throws Exception {
		_persistence.countByWorkflow(RandomTestUtil.nextLong());

		_persistence.countByWorkflow(0L);
	}

	@Test
	public void testCountByActive() throws Exception {
		_persistence.countByActive((Boolean)null);

		_persistence.countByActive((Boolean)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		EncyWorkflowState newEncyWorkflowState = addEncyWorkflowState();

		EncyWorkflowState existingEncyWorkflowState =
			_persistence.findByPrimaryKey(newEncyWorkflowState.getPrimaryKey());

		Assert.assertEquals(existingEncyWorkflowState, newEncyWorkflowState);
	}

	@Test(expected = NoSuchStateException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<EncyWorkflowState> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ency_workflowstate", "uuid", true, "stateId", true, "workflowId",
			true, "name", true, "title", true, "version", true, "isInitial",
			true, "isFinal", true, "isEditable", true, "isSearchable", true,
			"isPermanent", true, "cssIcon", true, "cssIconColor", true,
			"cssLabelColor", true, "active", true, "createDate", true,
			"modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		EncyWorkflowState newEncyWorkflowState = addEncyWorkflowState();

		EncyWorkflowState existingEncyWorkflowState =
			_persistence.fetchByPrimaryKey(
				newEncyWorkflowState.getPrimaryKey());

		Assert.assertEquals(existingEncyWorkflowState, newEncyWorkflowState);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflowState missingEncyWorkflowState =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEncyWorkflowState);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		EncyWorkflowState newEncyWorkflowState1 = addEncyWorkflowState();
		EncyWorkflowState newEncyWorkflowState2 = addEncyWorkflowState();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEncyWorkflowState1.getPrimaryKey());
		primaryKeys.add(newEncyWorkflowState2.getPrimaryKey());

		Map<Serializable, EncyWorkflowState> encyWorkflowStates =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, encyWorkflowStates.size());
		Assert.assertEquals(
			newEncyWorkflowState1,
			encyWorkflowStates.get(newEncyWorkflowState1.getPrimaryKey()));
		Assert.assertEquals(
			newEncyWorkflowState2,
			encyWorkflowStates.get(newEncyWorkflowState2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, EncyWorkflowState> encyWorkflowStates =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(encyWorkflowStates.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		EncyWorkflowState newEncyWorkflowState = addEncyWorkflowState();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEncyWorkflowState.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, EncyWorkflowState> encyWorkflowStates =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, encyWorkflowStates.size());
		Assert.assertEquals(
			newEncyWorkflowState,
			encyWorkflowStates.get(newEncyWorkflowState.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, EncyWorkflowState> encyWorkflowStates =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(encyWorkflowStates.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		EncyWorkflowState newEncyWorkflowState = addEncyWorkflowState();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEncyWorkflowState.getPrimaryKey());

		Map<Serializable, EncyWorkflowState> encyWorkflowStates =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, encyWorkflowStates.size());
		Assert.assertEquals(
			newEncyWorkflowState,
			encyWorkflowStates.get(newEncyWorkflowState.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			EncyWorkflowStateLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<EncyWorkflowState>() {

				@Override
				public void performAction(EncyWorkflowState encyWorkflowState) {
					Assert.assertNotNull(encyWorkflowState);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		EncyWorkflowState newEncyWorkflowState = addEncyWorkflowState();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowState.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"stateId", newEncyWorkflowState.getStateId()));

		List<EncyWorkflowState> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		EncyWorkflowState existingEncyWorkflowState = result.get(0);

		Assert.assertEquals(existingEncyWorkflowState, newEncyWorkflowState);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowState.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("stateId", RandomTestUtil.nextLong()));

		List<EncyWorkflowState> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		EncyWorkflowState newEncyWorkflowState = addEncyWorkflowState();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowState.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("stateId"));

		Object newStateId = newEncyWorkflowState.getStateId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("stateId", new Object[] {newStateId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingStateId = result.get(0);

		Assert.assertEquals(existingStateId, newStateId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowState.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("stateId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"stateId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		EncyWorkflowState newEncyWorkflowState = addEncyWorkflowState();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(
				newEncyWorkflowState.getPrimaryKey()));
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

		EncyWorkflowState newEncyWorkflowState = addEncyWorkflowState();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowState.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"stateId", newEncyWorkflowState.getStateId()));

		List<EncyWorkflowState> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(EncyWorkflowState encyWorkflowState) {
		Assert.assertEquals(
			Long.valueOf(encyWorkflowState.getWorkflowId()),
			ReflectionTestUtil.<Long>invoke(
				encyWorkflowState, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "workflowId"));
		Assert.assertEquals(
			encyWorkflowState.getName(),
			ReflectionTestUtil.invoke(
				encyWorkflowState, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "name"));
	}

	protected EncyWorkflowState addEncyWorkflowState() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflowState encyWorkflowState = _persistence.create(pk);

		encyWorkflowState.setUuid(RandomTestUtil.randomString());

		encyWorkflowState.setWorkflowId(RandomTestUtil.nextLong());

		encyWorkflowState.setName(RandomTestUtil.randomString());

		encyWorkflowState.setTitle(RandomTestUtil.randomString());

		encyWorkflowState.setDescription(RandomTestUtil.randomString());

		encyWorkflowState.setVersion(RandomTestUtil.nextLong());

		encyWorkflowState.setIsInitial();

		encyWorkflowState.setIsFinal();

		encyWorkflowState.setIsEditable();

		encyWorkflowState.setIsSearchable();

		encyWorkflowState.setIsPermanent();

		encyWorkflowState.setCssIcon(RandomTestUtil.randomString());

		encyWorkflowState.setCssIconColor(RandomTestUtil.randomString());

		encyWorkflowState.setCssLabelColor(RandomTestUtil.randomString());

		encyWorkflowState.setActive();

		encyWorkflowState.setCreateDate(RandomTestUtil.nextDate());

		encyWorkflowState.setModifiedDate(RandomTestUtil.nextDate());

		_encyWorkflowStates.add(_persistence.update(encyWorkflowState));

		return encyWorkflowState;
	}

	private List<EncyWorkflowState> _encyWorkflowStates =
		new ArrayList<EncyWorkflowState>();
	private EncyWorkflowStatePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}