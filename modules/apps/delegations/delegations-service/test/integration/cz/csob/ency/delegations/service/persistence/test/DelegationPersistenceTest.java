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

package cz.csob.ency.delegations.service.persistence.test;

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

import cz.csob.ency.delegations.exception.NoSuchDelegationException;
import cz.csob.ency.delegations.model.Delegation;
import cz.csob.ency.delegations.service.DelegationLocalServiceUtil;
import cz.csob.ency.delegations.service.persistence.DelegationPersistence;
import cz.csob.ency.delegations.service.persistence.DelegationUtil;

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
public class DelegationPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "cz.csob.ency.delegations.service"));

	@Before
	public void setUp() {
		_persistence = DelegationUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Delegation> iterator = _delegations.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Delegation delegation = _persistence.create(pk);

		Assert.assertNotNull(delegation);

		Assert.assertEquals(delegation.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Delegation newDelegation = addDelegation();

		_persistence.remove(newDelegation);

		Delegation existingDelegation = _persistence.fetchByPrimaryKey(
			newDelegation.getPrimaryKey());

		Assert.assertNull(existingDelegation);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDelegation();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Delegation newDelegation = _persistence.create(pk);

		newDelegation.setMvccVersion(RandomTestUtil.nextLong());

		newDelegation.setRoleId(RandomTestUtil.nextLong());

		newDelegation.setDelegatingUserId(RandomTestUtil.nextLong());

		newDelegation.setDelegatedUserId(RandomTestUtil.nextLong());

		newDelegation.setGroupId(RandomTestUtil.nextLong());

		newDelegation.setNote(RandomTestUtil.randomString());

		newDelegation.setCompanyId(RandomTestUtil.nextLong());

		newDelegation.setUserId(RandomTestUtil.nextLong());

		newDelegation.setUserName(RandomTestUtil.randomString());

		newDelegation.setCreateDate(RandomTestUtil.nextDate());

		newDelegation.setModifiedDate(RandomTestUtil.nextDate());

		_delegations.add(_persistence.update(newDelegation));

		Delegation existingDelegation = _persistence.findByPrimaryKey(
			newDelegation.getPrimaryKey());

		Assert.assertEquals(
			existingDelegation.getMvccVersion(),
			newDelegation.getMvccVersion());
		Assert.assertEquals(
			existingDelegation.getDelegationId(),
			newDelegation.getDelegationId());
		Assert.assertEquals(
			existingDelegation.getRoleId(), newDelegation.getRoleId());
		Assert.assertEquals(
			existingDelegation.getDelegatingUserId(),
			newDelegation.getDelegatingUserId());
		Assert.assertEquals(
			existingDelegation.getDelegatedUserId(),
			newDelegation.getDelegatedUserId());
		Assert.assertEquals(
			existingDelegation.getGroupId(), newDelegation.getGroupId());
		Assert.assertEquals(
			existingDelegation.getNote(), newDelegation.getNote());
		Assert.assertEquals(
			existingDelegation.getCompanyId(), newDelegation.getCompanyId());
		Assert.assertEquals(
			existingDelegation.getUserId(), newDelegation.getUserId());
		Assert.assertEquals(
			existingDelegation.getUserName(), newDelegation.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDelegation.getCreateDate()),
			Time.getShortTimestamp(newDelegation.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingDelegation.getModifiedDate()),
			Time.getShortTimestamp(newDelegation.getModifiedDate()));
	}

	@Test
	public void testCountById() throws Exception {
		_persistence.countById(RandomTestUtil.nextLong());

		_persistence.countById(0L);
	}

	@Test
	public void testCountByG_R() throws Exception {
		_persistence.countByG_R(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByG_R(0L, 0L);
	}

	@Test
	public void testCountByG_R_Delegating() throws Exception {
		_persistence.countByG_R_Delegating(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByG_R_Delegating(0L, 0L, 0L);
	}

	@Test
	public void testCountByG_R_Delegated() throws Exception {
		_persistence.countByG_R_Delegated(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByG_R_Delegated(0L, 0L, 0L);
	}

	@Test
	public void testCountByG() throws Exception {
		_persistence.countByG(RandomTestUtil.nextLong());

		_persistence.countByG(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Delegation newDelegation = addDelegation();

		Delegation existingDelegation = _persistence.findByPrimaryKey(
			newDelegation.getPrimaryKey());

		Assert.assertEquals(existingDelegation, newDelegation);
	}

	@Test(expected = NoSuchDelegationException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Delegation> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"delegations_delegation", "mvccVersion", true, "delegationId", true,
			"roleId", true, "delegatingUserId", true, "delegatedUserId", true,
			"groupId", true, "note", true, "companyId", true, "userId", true,
			"userName", true, "createDate", true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Delegation newDelegation = addDelegation();

		Delegation existingDelegation = _persistence.fetchByPrimaryKey(
			newDelegation.getPrimaryKey());

		Assert.assertEquals(existingDelegation, newDelegation);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Delegation missingDelegation = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDelegation);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Delegation newDelegation1 = addDelegation();
		Delegation newDelegation2 = addDelegation();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDelegation1.getPrimaryKey());
		primaryKeys.add(newDelegation2.getPrimaryKey());

		Map<Serializable, Delegation> delegations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, delegations.size());
		Assert.assertEquals(
			newDelegation1, delegations.get(newDelegation1.getPrimaryKey()));
		Assert.assertEquals(
			newDelegation2, delegations.get(newDelegation2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Delegation> delegations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(delegations.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Delegation newDelegation = addDelegation();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDelegation.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Delegation> delegations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, delegations.size());
		Assert.assertEquals(
			newDelegation, delegations.get(newDelegation.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Delegation> delegations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(delegations.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Delegation newDelegation = addDelegation();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDelegation.getPrimaryKey());

		Map<Serializable, Delegation> delegations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, delegations.size());
		Assert.assertEquals(
			newDelegation, delegations.get(newDelegation.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			DelegationLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Delegation>() {

				@Override
				public void performAction(Delegation delegation) {
					Assert.assertNotNull(delegation);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Delegation newDelegation = addDelegation();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Delegation.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"delegationId", newDelegation.getDelegationId()));

		List<Delegation> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Delegation existingDelegation = result.get(0);

		Assert.assertEquals(existingDelegation, newDelegation);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Delegation.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"delegationId", RandomTestUtil.nextLong()));

		List<Delegation> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Delegation newDelegation = addDelegation();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Delegation.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("delegationId"));

		Object newDelegationId = newDelegation.getDelegationId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"delegationId", new Object[] {newDelegationId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingDelegationId = result.get(0);

		Assert.assertEquals(existingDelegationId, newDelegationId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Delegation.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("delegationId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"delegationId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Delegation newDelegation = addDelegation();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newDelegation.getPrimaryKey()));
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

		Delegation newDelegation = addDelegation();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Delegation.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"delegationId", newDelegation.getDelegationId()));

		List<Delegation> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Delegation delegation) {
		Assert.assertEquals(
			Long.valueOf(delegation.getDelegationId()),
			ReflectionTestUtil.<Long>invoke(
				delegation, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "delegationId"));
	}

	protected Delegation addDelegation() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Delegation delegation = _persistence.create(pk);

		delegation.setMvccVersion(RandomTestUtil.nextLong());

		delegation.setRoleId(RandomTestUtil.nextLong());

		delegation.setDelegatingUserId(RandomTestUtil.nextLong());

		delegation.setDelegatedUserId(RandomTestUtil.nextLong());

		delegation.setGroupId(RandomTestUtil.nextLong());

		delegation.setNote(RandomTestUtil.randomString());

		delegation.setCompanyId(RandomTestUtil.nextLong());

		delegation.setUserId(RandomTestUtil.nextLong());

		delegation.setUserName(RandomTestUtil.randomString());

		delegation.setCreateDate(RandomTestUtil.nextDate());

		delegation.setModifiedDate(RandomTestUtil.nextDate());

		_delegations.add(_persistence.update(delegation));

		return delegation;
	}

	private List<Delegation> _delegations = new ArrayList<Delegation>();
	private DelegationPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}