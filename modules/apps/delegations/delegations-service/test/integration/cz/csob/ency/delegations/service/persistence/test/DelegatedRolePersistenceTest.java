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

import cz.csob.ency.delegations.exception.NoSuchDelegatedRoleException;
import cz.csob.ency.delegations.model.DelegatedRole;
import cz.csob.ency.delegations.service.DelegatedRoleLocalServiceUtil;
import cz.csob.ency.delegations.service.persistence.DelegatedRolePersistence;
import cz.csob.ency.delegations.service.persistence.DelegatedRoleUtil;

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
public class DelegatedRolePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "cz.csob.ency.delegations.service"));

	@Before
	public void setUp() {
		_persistence = DelegatedRoleUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<DelegatedRole> iterator = _delegatedRoles.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DelegatedRole delegatedRole = _persistence.create(pk);

		Assert.assertNotNull(delegatedRole);

		Assert.assertEquals(delegatedRole.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		DelegatedRole newDelegatedRole = addDelegatedRole();

		_persistence.remove(newDelegatedRole);

		DelegatedRole existingDelegatedRole = _persistence.fetchByPrimaryKey(
			newDelegatedRole.getPrimaryKey());

		Assert.assertNull(existingDelegatedRole);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDelegatedRole();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DelegatedRole newDelegatedRole = _persistence.create(pk);

		newDelegatedRole.setMvccVersion(RandomTestUtil.nextLong());

		newDelegatedRole.setTitle(RandomTestUtil.randomString());

		newDelegatedRole.setCode(RandomTestUtil.randomString());

		newDelegatedRole.setDescription(RandomTestUtil.randomString());

		newDelegatedRole.setGroupId(RandomTestUtil.nextLong());

		newDelegatedRole.setCompanyId(RandomTestUtil.nextLong());

		newDelegatedRole.setUserId(RandomTestUtil.nextLong());

		newDelegatedRole.setUserName(RandomTestUtil.randomString());

		newDelegatedRole.setCreateDate(RandomTestUtil.nextDate());

		newDelegatedRole.setModifiedDate(RandomTestUtil.nextDate());

		_delegatedRoles.add(_persistence.update(newDelegatedRole));

		DelegatedRole existingDelegatedRole = _persistence.findByPrimaryKey(
			newDelegatedRole.getPrimaryKey());

		Assert.assertEquals(
			existingDelegatedRole.getMvccVersion(),
			newDelegatedRole.getMvccVersion());
		Assert.assertEquals(
			existingDelegatedRole.getRoleId(), newDelegatedRole.getRoleId());
		Assert.assertEquals(
			existingDelegatedRole.getTitle(), newDelegatedRole.getTitle());
		Assert.assertEquals(
			existingDelegatedRole.getCode(), newDelegatedRole.getCode());
		Assert.assertEquals(
			existingDelegatedRole.getDescription(),
			newDelegatedRole.getDescription());
		Assert.assertEquals(
			existingDelegatedRole.getGroupId(), newDelegatedRole.getGroupId());
		Assert.assertEquals(
			existingDelegatedRole.getCompanyId(),
			newDelegatedRole.getCompanyId());
		Assert.assertEquals(
			existingDelegatedRole.getUserId(), newDelegatedRole.getUserId());
		Assert.assertEquals(
			existingDelegatedRole.getUserName(),
			newDelegatedRole.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDelegatedRole.getCreateDate()),
			Time.getShortTimestamp(newDelegatedRole.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingDelegatedRole.getModifiedDate()),
			Time.getShortTimestamp(newDelegatedRole.getModifiedDate()));
	}

	@Test
	public void testCountById() throws Exception {
		_persistence.countById(RandomTestUtil.nextLong());

		_persistence.countById(0L);
	}

	@Test
	public void testCountByCode() throws Exception {
		_persistence.countByCode("");

		_persistence.countByCode("null");

		_persistence.countByCode((String)null);
	}

	@Test
	public void testCountByG() throws Exception {
		_persistence.countByG(RandomTestUtil.nextLong());

		_persistence.countByG(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		DelegatedRole newDelegatedRole = addDelegatedRole();

		DelegatedRole existingDelegatedRole = _persistence.findByPrimaryKey(
			newDelegatedRole.getPrimaryKey());

		Assert.assertEquals(existingDelegatedRole, newDelegatedRole);
	}

	@Test(expected = NoSuchDelegatedRoleException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<DelegatedRole> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"delegations_delegatedrole", "mvccVersion", true, "roleId", true,
			"title", true, "code", true, "description", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		DelegatedRole newDelegatedRole = addDelegatedRole();

		DelegatedRole existingDelegatedRole = _persistence.fetchByPrimaryKey(
			newDelegatedRole.getPrimaryKey());

		Assert.assertEquals(existingDelegatedRole, newDelegatedRole);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DelegatedRole missingDelegatedRole = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDelegatedRole);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		DelegatedRole newDelegatedRole1 = addDelegatedRole();
		DelegatedRole newDelegatedRole2 = addDelegatedRole();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDelegatedRole1.getPrimaryKey());
		primaryKeys.add(newDelegatedRole2.getPrimaryKey());

		Map<Serializable, DelegatedRole> delegatedRoles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, delegatedRoles.size());
		Assert.assertEquals(
			newDelegatedRole1,
			delegatedRoles.get(newDelegatedRole1.getPrimaryKey()));
		Assert.assertEquals(
			newDelegatedRole2,
			delegatedRoles.get(newDelegatedRole2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, DelegatedRole> delegatedRoles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(delegatedRoles.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		DelegatedRole newDelegatedRole = addDelegatedRole();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDelegatedRole.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, DelegatedRole> delegatedRoles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, delegatedRoles.size());
		Assert.assertEquals(
			newDelegatedRole,
			delegatedRoles.get(newDelegatedRole.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, DelegatedRole> delegatedRoles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(delegatedRoles.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		DelegatedRole newDelegatedRole = addDelegatedRole();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDelegatedRole.getPrimaryKey());

		Map<Serializable, DelegatedRole> delegatedRoles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, delegatedRoles.size());
		Assert.assertEquals(
			newDelegatedRole,
			delegatedRoles.get(newDelegatedRole.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			DelegatedRoleLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<DelegatedRole>() {

				@Override
				public void performAction(DelegatedRole delegatedRole) {
					Assert.assertNotNull(delegatedRole);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		DelegatedRole newDelegatedRole = addDelegatedRole();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DelegatedRole.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("roleId", newDelegatedRole.getRoleId()));

		List<DelegatedRole> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		DelegatedRole existingDelegatedRole = result.get(0);

		Assert.assertEquals(existingDelegatedRole, newDelegatedRole);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DelegatedRole.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("roleId", RandomTestUtil.nextLong()));

		List<DelegatedRole> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		DelegatedRole newDelegatedRole = addDelegatedRole();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DelegatedRole.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("roleId"));

		Object newRoleId = newDelegatedRole.getRoleId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("roleId", new Object[] {newRoleId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingRoleId = result.get(0);

		Assert.assertEquals(existingRoleId, newRoleId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DelegatedRole.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("roleId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"roleId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		DelegatedRole newDelegatedRole = addDelegatedRole();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newDelegatedRole.getPrimaryKey()));
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

		DelegatedRole newDelegatedRole = addDelegatedRole();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DelegatedRole.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("roleId", newDelegatedRole.getRoleId()));

		List<DelegatedRole> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(DelegatedRole delegatedRole) {
		Assert.assertEquals(
			Long.valueOf(delegatedRole.getRoleId()),
			ReflectionTestUtil.<Long>invoke(
				delegatedRole, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "roleId"));

		Assert.assertEquals(
			delegatedRole.getCode(),
			ReflectionTestUtil.invoke(
				delegatedRole, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "code_"));
	}

	protected DelegatedRole addDelegatedRole() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DelegatedRole delegatedRole = _persistence.create(pk);

		delegatedRole.setMvccVersion(RandomTestUtil.nextLong());

		delegatedRole.setTitle(RandomTestUtil.randomString());

		delegatedRole.setCode(RandomTestUtil.randomString());

		delegatedRole.setDescription(RandomTestUtil.randomString());

		delegatedRole.setGroupId(RandomTestUtil.nextLong());

		delegatedRole.setCompanyId(RandomTestUtil.nextLong());

		delegatedRole.setUserId(RandomTestUtil.nextLong());

		delegatedRole.setUserName(RandomTestUtil.randomString());

		delegatedRole.setCreateDate(RandomTestUtil.nextDate());

		delegatedRole.setModifiedDate(RandomTestUtil.nextDate());

		_delegatedRoles.add(_persistence.update(delegatedRole));

		return delegatedRole;
	}

	private List<DelegatedRole> _delegatedRoles =
		new ArrayList<DelegatedRole>();
	private DelegatedRolePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}