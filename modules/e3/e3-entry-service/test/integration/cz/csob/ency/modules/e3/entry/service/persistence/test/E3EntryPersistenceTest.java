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

package cz.csob.ency.modules.e3.entry.service.persistence.test;

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

import cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.entry.service.E3EntryLocalServiceUtil;
import cz.csob.ency.modules.e3.entry.service.persistence.E3EntryPersistence;
import cz.csob.ency.modules.e3.entry.service.persistence.E3EntryUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashMap;
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
public class E3EntryPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "cz.csob.ency.modules.e3.entry.service"));

	@Before
	public void setUp() {
		_persistence = E3EntryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<E3Entry> iterator = _e3Entries.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		E3Entry e3Entry = _persistence.create(pk);

		Assert.assertNotNull(e3Entry);

		Assert.assertEquals(e3Entry.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		E3Entry newE3Entry = addE3Entry();

		_persistence.remove(newE3Entry);

		E3Entry existingE3Entry = _persistence.fetchByPrimaryKey(
			newE3Entry.getPrimaryKey());

		Assert.assertNull(existingE3Entry);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addE3Entry();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		E3Entry newE3Entry = _persistence.create(pk);

		newE3Entry.setMvccVersion(RandomTestUtil.nextLong());

		newE3Entry.setUuid(RandomTestUtil.randomString());

		newE3Entry.setHeadId(RandomTestUtil.nextLong());

		newE3Entry.setGroupId(RandomTestUtil.nextLong());

		newE3Entry.setCompanyId(RandomTestUtil.nextLong());

		newE3Entry.setUserId(RandomTestUtil.nextLong());

		newE3Entry.setUserName(RandomTestUtil.randomString());

		newE3Entry.setCreateDate(RandomTestUtil.nextDate());

		newE3Entry.setModifiedDate(RandomTestUtil.nextDate());

		newE3Entry.setAuthorId(RandomTestUtil.nextLong());

		newE3Entry.setAuthorName(RandomTestUtil.randomString());

		newE3Entry.setXid(RandomTestUtil.randomString());

		newE3Entry.setName(RandomTestUtil.randomString());

		newE3Entry.setAppClass(RandomTestUtil.randomString());

		newE3Entry.setParentId(RandomTestUtil.nextLong());

		newE3Entry.setParentField(RandomTestUtil.randomString());

		newE3Entry.setValues(new HashMap<String, Serializable>());

		newE3Entry.setStatus(RandomTestUtil.nextLong());

		_e3Entries.add(_persistence.update(newE3Entry));

		E3Entry existingE3Entry = _persistence.findByPrimaryKey(
			newE3Entry.getPrimaryKey());

		Assert.assertEquals(
			existingE3Entry.getMvccVersion(), newE3Entry.getMvccVersion());
		Assert.assertEquals(existingE3Entry.getUuid(), newE3Entry.getUuid());
		Assert.assertEquals(
			existingE3Entry.getHeadId(), newE3Entry.getHeadId());
		Assert.assertEquals(
			existingE3Entry.getEntryId(), newE3Entry.getEntryId());
		Assert.assertEquals(
			existingE3Entry.getGroupId(), newE3Entry.getGroupId());
		Assert.assertEquals(
			existingE3Entry.getCompanyId(), newE3Entry.getCompanyId());
		Assert.assertEquals(
			existingE3Entry.getUserId(), newE3Entry.getUserId());
		Assert.assertEquals(
			existingE3Entry.getUserName(), newE3Entry.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingE3Entry.getCreateDate()),
			Time.getShortTimestamp(newE3Entry.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingE3Entry.getModifiedDate()),
			Time.getShortTimestamp(newE3Entry.getModifiedDate()));
		Assert.assertEquals(
			existingE3Entry.getAuthorId(), newE3Entry.getAuthorId());
		Assert.assertEquals(
			existingE3Entry.getAuthorName(), newE3Entry.getAuthorName());
		Assert.assertEquals(existingE3Entry.getXid(), newE3Entry.getXid());
		Assert.assertEquals(existingE3Entry.getName(), newE3Entry.getName());
		Assert.assertEquals(
			existingE3Entry.getAppClass(), newE3Entry.getAppClass());
		Assert.assertEquals(
			existingE3Entry.getParentId(), newE3Entry.getParentId());
		Assert.assertEquals(
			existingE3Entry.getParentField(), newE3Entry.getParentField());
		Assert.assertEquals(
			existingE3Entry.getValues(), newE3Entry.getValues());
		Assert.assertEquals(
			existingE3Entry.getStatus(), newE3Entry.getStatus());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUuid_Head() throws Exception {
		_persistence.countByUuid_Head("", RandomTestUtil.randomBoolean());

		_persistence.countByUuid_Head("null", RandomTestUtil.randomBoolean());

		_persistence.countByUuid_Head(
			(String)null, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUUID_G_Head() throws Exception {
		_persistence.countByUUID_G_Head(
			"", RandomTestUtil.nextLong(), RandomTestUtil.randomBoolean());

		_persistence.countByUUID_G_Head(
			"null", 0L, RandomTestUtil.randomBoolean());

		_persistence.countByUUID_G_Head(
			(String)null, 0L, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C_Head() throws Exception {
		_persistence.countByUuid_C_Head(
			"", RandomTestUtil.nextLong(), RandomTestUtil.randomBoolean());

		_persistence.countByUuid_C_Head(
			"null", 0L, RandomTestUtil.randomBoolean());

		_persistence.countByUuid_C_Head(
			(String)null, 0L, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByxid() throws Exception {
		_persistence.countByxid("");

		_persistence.countByxid("null");

		_persistence.countByxid((String)null);
	}

	@Test
	public void testCountByxid_Head() throws Exception {
		_persistence.countByxid_Head("", RandomTestUtil.randomBoolean());

		_persistence.countByxid_Head("null", RandomTestUtil.randomBoolean());

		_persistence.countByxid_Head(
			(String)null, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByp_f() throws Exception {
		_persistence.countByp_f(RandomTestUtil.nextLong(), "");

		_persistence.countByp_f(0L, "null");

		_persistence.countByp_f(0L, (String)null);
	}

	@Test
	public void testCountByp_f_Head() throws Exception {
		_persistence.countByp_f_Head(
			RandomTestUtil.nextLong(), "", RandomTestUtil.randomBoolean());

		_persistence.countByp_f_Head(
			0L, "null", RandomTestUtil.randomBoolean());

		_persistence.countByp_f_Head(
			0L, (String)null, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByStatus() throws Exception {
		_persistence.countByStatus(RandomTestUtil.nextLong());

		_persistence.countByStatus(0L);
	}

	@Test
	public void testCountByStatus_Head() throws Exception {
		_persistence.countByStatus_Head(
			RandomTestUtil.nextLong(), RandomTestUtil.randomBoolean());

		_persistence.countByStatus_Head(0L, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByG_S() throws Exception {
		_persistence.countByG_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByG_S(0L, 0L);
	}

	@Test
	public void testCountByG_S_Head() throws Exception {
		_persistence.countByG_S_Head(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.randomBoolean());

		_persistence.countByG_S_Head(0L, 0L, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByHeadId() throws Exception {
		_persistence.countByHeadId(RandomTestUtil.nextLong());

		_persistence.countByHeadId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		E3Entry newE3Entry = addE3Entry();

		E3Entry existingE3Entry = _persistence.findByPrimaryKey(
			newE3Entry.getPrimaryKey());

		Assert.assertEquals(existingE3Entry, newE3Entry);
	}

	@Test(expected = NoSuchE3EntryException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<E3Entry> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"E3Entry", "mvccVersion", true, "uuid", true, "headId", true,
			"entryId", true, "groupId", true, "companyId", true, "userId", true,
			"userName", true, "createDate", true, "modifiedDate", true,
			"authorId", true, "authorName", true, "xid", true, "name", true,
			"appClass", true, "parentId", true, "parentField", true, "status",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		E3Entry newE3Entry = addE3Entry();

		E3Entry existingE3Entry = _persistence.fetchByPrimaryKey(
			newE3Entry.getPrimaryKey());

		Assert.assertEquals(existingE3Entry, newE3Entry);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		E3Entry missingE3Entry = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingE3Entry);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		E3Entry newE3Entry1 = addE3Entry();
		E3Entry newE3Entry2 = addE3Entry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newE3Entry1.getPrimaryKey());
		primaryKeys.add(newE3Entry2.getPrimaryKey());

		Map<Serializable, E3Entry> e3Entries = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, e3Entries.size());
		Assert.assertEquals(
			newE3Entry1, e3Entries.get(newE3Entry1.getPrimaryKey()));
		Assert.assertEquals(
			newE3Entry2, e3Entries.get(newE3Entry2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, E3Entry> e3Entries = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(e3Entries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		E3Entry newE3Entry = addE3Entry();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newE3Entry.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, E3Entry> e3Entries = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, e3Entries.size());
		Assert.assertEquals(
			newE3Entry, e3Entries.get(newE3Entry.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, E3Entry> e3Entries = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(e3Entries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		E3Entry newE3Entry = addE3Entry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newE3Entry.getPrimaryKey());

		Map<Serializable, E3Entry> e3Entries = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, e3Entries.size());
		Assert.assertEquals(
			newE3Entry, e3Entries.get(newE3Entry.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			E3EntryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<E3Entry>() {

				@Override
				public void performAction(E3Entry e3Entry) {
					Assert.assertNotNull(e3Entry);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		E3Entry newE3Entry = addE3Entry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			E3Entry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("entryId", newE3Entry.getEntryId()));

		List<E3Entry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		E3Entry existingE3Entry = result.get(0);

		Assert.assertEquals(existingE3Entry, newE3Entry);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			E3Entry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("entryId", RandomTestUtil.nextLong()));

		List<E3Entry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		E3Entry newE3Entry = addE3Entry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			E3Entry.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("entryId"));

		Object newEntryId = newE3Entry.getEntryId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("entryId", new Object[] {newEntryId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingEntryId = result.get(0);

		Assert.assertEquals(existingEntryId, newEntryId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			E3Entry.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("entryId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"entryId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		E3Entry newE3Entry = addE3Entry();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newE3Entry.getPrimaryKey()));
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

		E3Entry newE3Entry = addE3Entry();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			E3Entry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("entryId", newE3Entry.getEntryId()));

		List<E3Entry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(E3Entry e3Entry) {
		Assert.assertEquals(
			e3Entry.getUuid(),
			ReflectionTestUtil.invoke(
				e3Entry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(e3Entry.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				e3Entry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));

		Assert.assertEquals(
			e3Entry.getXid(),
			ReflectionTestUtil.invoke(
				e3Entry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "entry_xid"));

		Assert.assertEquals(
			Long.valueOf(e3Entry.getParentId()),
			ReflectionTestUtil.<Long>invoke(
				e3Entry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "parent_id"));
		Assert.assertEquals(
			e3Entry.getParentField(),
			ReflectionTestUtil.invoke(
				e3Entry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "parent_field"));

		Assert.assertEquals(
			Long.valueOf(e3Entry.getHeadId()),
			ReflectionTestUtil.<Long>invoke(
				e3Entry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "headId"));
	}

	protected E3Entry addE3Entry() throws Exception {
		long pk = RandomTestUtil.nextLong();

		E3Entry e3Entry = _persistence.create(pk);

		e3Entry.setMvccVersion(RandomTestUtil.nextLong());

		e3Entry.setUuid(RandomTestUtil.randomString());

		e3Entry.setHeadId(RandomTestUtil.nextLong());

		e3Entry.setGroupId(RandomTestUtil.nextLong());

		e3Entry.setCompanyId(RandomTestUtil.nextLong());

		e3Entry.setUserId(RandomTestUtil.nextLong());

		e3Entry.setUserName(RandomTestUtil.randomString());

		e3Entry.setCreateDate(RandomTestUtil.nextDate());

		e3Entry.setModifiedDate(RandomTestUtil.nextDate());

		e3Entry.setAuthorId(RandomTestUtil.nextLong());

		e3Entry.setAuthorName(RandomTestUtil.randomString());

		e3Entry.setXid(RandomTestUtil.randomString());

		e3Entry.setName(RandomTestUtil.randomString());

		e3Entry.setAppClass(RandomTestUtil.randomString());

		e3Entry.setParentId(RandomTestUtil.nextLong());

		e3Entry.setParentField(RandomTestUtil.randomString());

		e3Entry.setValues(new HashMap<String, Serializable>());

		e3Entry.setStatus(RandomTestUtil.nextLong());

		_e3Entries.add(_persistence.update(e3Entry));

		return e3Entry;
	}

	private List<E3Entry> _e3Entries = new ArrayList<E3Entry>();
	private E3EntryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}