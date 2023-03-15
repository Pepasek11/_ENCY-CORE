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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryVersionException;
import cz.csob.ency.modules.e3.entry.model.E3EntryVersion;
import cz.csob.ency.modules.e3.entry.service.persistence.E3EntryVersionPersistence;
import cz.csob.ency.modules.e3.entry.service.persistence.E3EntryVersionUtil;

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
public class E3EntryVersionPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "cz.csob.ency.modules.e3.entry.service"));

	@Before
	public void setUp() {
		_persistence = E3EntryVersionUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<E3EntryVersion> iterator = _e3EntryVersions.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		E3EntryVersion e3EntryVersion = _persistence.create(pk);

		Assert.assertNotNull(e3EntryVersion);

		Assert.assertEquals(e3EntryVersion.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		E3EntryVersion newE3EntryVersion = addE3EntryVersion();

		_persistence.remove(newE3EntryVersion);

		E3EntryVersion existingE3EntryVersion = _persistence.fetchByPrimaryKey(
			newE3EntryVersion.getPrimaryKey());

		Assert.assertNull(existingE3EntryVersion);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addE3EntryVersion();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		E3EntryVersion newE3EntryVersion = _persistence.create(pk);

		newE3EntryVersion.setVersion(RandomTestUtil.nextInt());

		newE3EntryVersion.setUuid(RandomTestUtil.randomString());

		newE3EntryVersion.setEntryId(RandomTestUtil.nextLong());

		newE3EntryVersion.setGroupId(RandomTestUtil.nextLong());

		newE3EntryVersion.setCompanyId(RandomTestUtil.nextLong());

		newE3EntryVersion.setUserId(RandomTestUtil.nextLong());

		newE3EntryVersion.setUserName(RandomTestUtil.randomString());

		newE3EntryVersion.setCreateDate(RandomTestUtil.nextDate());

		newE3EntryVersion.setModifiedDate(RandomTestUtil.nextDate());

		newE3EntryVersion.setAuthorId(RandomTestUtil.nextLong());

		newE3EntryVersion.setAuthorName(RandomTestUtil.randomString());

		newE3EntryVersion.setXid(RandomTestUtil.randomString());

		newE3EntryVersion.setName(RandomTestUtil.randomString());

		newE3EntryVersion.setAppClass(RandomTestUtil.randomString());

		newE3EntryVersion.setParentId(RandomTestUtil.nextLong());

		newE3EntryVersion.setParentField(RandomTestUtil.randomString());

		newE3EntryVersion.setValues(new HashMap<String, Serializable>());

		newE3EntryVersion.setStatus(RandomTestUtil.nextLong());

		_e3EntryVersions.add(_persistence.update(newE3EntryVersion));

		E3EntryVersion existingE3EntryVersion = _persistence.findByPrimaryKey(
			newE3EntryVersion.getPrimaryKey());

		Assert.assertEquals(
			existingE3EntryVersion.getE3EntryVersionId(),
			newE3EntryVersion.getE3EntryVersionId());
		Assert.assertEquals(
			existingE3EntryVersion.getVersion(),
			newE3EntryVersion.getVersion());
		Assert.assertEquals(
			existingE3EntryVersion.getUuid(), newE3EntryVersion.getUuid());
		Assert.assertEquals(
			existingE3EntryVersion.getEntryId(),
			newE3EntryVersion.getEntryId());
		Assert.assertEquals(
			existingE3EntryVersion.getGroupId(),
			newE3EntryVersion.getGroupId());
		Assert.assertEquals(
			existingE3EntryVersion.getCompanyId(),
			newE3EntryVersion.getCompanyId());
		Assert.assertEquals(
			existingE3EntryVersion.getUserId(), newE3EntryVersion.getUserId());
		Assert.assertEquals(
			existingE3EntryVersion.getUserName(),
			newE3EntryVersion.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingE3EntryVersion.getCreateDate()),
			Time.getShortTimestamp(newE3EntryVersion.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingE3EntryVersion.getModifiedDate()),
			Time.getShortTimestamp(newE3EntryVersion.getModifiedDate()));
		Assert.assertEquals(
			existingE3EntryVersion.getAuthorId(),
			newE3EntryVersion.getAuthorId());
		Assert.assertEquals(
			existingE3EntryVersion.getAuthorName(),
			newE3EntryVersion.getAuthorName());
		Assert.assertEquals(
			existingE3EntryVersion.getXid(), newE3EntryVersion.getXid());
		Assert.assertEquals(
			existingE3EntryVersion.getName(), newE3EntryVersion.getName());
		Assert.assertEquals(
			existingE3EntryVersion.getAppClass(),
			newE3EntryVersion.getAppClass());
		Assert.assertEquals(
			existingE3EntryVersion.getParentId(),
			newE3EntryVersion.getParentId());
		Assert.assertEquals(
			existingE3EntryVersion.getParentField(),
			newE3EntryVersion.getParentField());
		Assert.assertEquals(
			existingE3EntryVersion.getValues(), newE3EntryVersion.getValues());
		Assert.assertEquals(
			existingE3EntryVersion.getStatus(), newE3EntryVersion.getStatus());
	}

	@Test
	public void testCountByEntryId() throws Exception {
		_persistence.countByEntryId(RandomTestUtil.nextLong());

		_persistence.countByEntryId(0L);
	}

	@Test
	public void testCountByEntryId_Version() throws Exception {
		_persistence.countByEntryId_Version(
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByEntryId_Version(0L, 0);
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUuid_Version() throws Exception {
		_persistence.countByUuid_Version("", RandomTestUtil.nextInt());

		_persistence.countByUuid_Version("null", 0);

		_persistence.countByUuid_Version((String)null, 0);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUUID_G_Version() throws Exception {
		_persistence.countByUUID_G_Version(
			"", RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByUUID_G_Version("null", 0L, 0);

		_persistence.countByUUID_G_Version((String)null, 0L, 0);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C_Version() throws Exception {
		_persistence.countByUuid_C_Version(
			"", RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByUuid_C_Version("null", 0L, 0);

		_persistence.countByUuid_C_Version((String)null, 0L, 0);
	}

	@Test
	public void testCountByxid() throws Exception {
		_persistence.countByxid("");

		_persistence.countByxid("null");

		_persistence.countByxid((String)null);
	}

	@Test
	public void testCountByxid_Version() throws Exception {
		_persistence.countByxid_Version("", RandomTestUtil.nextInt());

		_persistence.countByxid_Version("null", 0);

		_persistence.countByxid_Version((String)null, 0);
	}

	@Test
	public void testCountByp_f() throws Exception {
		_persistence.countByp_f(RandomTestUtil.nextLong(), "");

		_persistence.countByp_f(0L, "null");

		_persistence.countByp_f(0L, (String)null);
	}

	@Test
	public void testCountByp_f_Version() throws Exception {
		_persistence.countByp_f_Version(
			RandomTestUtil.nextLong(), "", RandomTestUtil.nextInt());

		_persistence.countByp_f_Version(0L, "null", 0);

		_persistence.countByp_f_Version(0L, (String)null, 0);
	}

	@Test
	public void testCountByStatus() throws Exception {
		_persistence.countByStatus(RandomTestUtil.nextLong());

		_persistence.countByStatus(0L);
	}

	@Test
	public void testCountByStatus_Version() throws Exception {
		_persistence.countByStatus_Version(
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByStatus_Version(0L, 0);
	}

	@Test
	public void testCountByG_S() throws Exception {
		_persistence.countByG_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByG_S(0L, 0L);
	}

	@Test
	public void testCountByG_S_Version() throws Exception {
		_persistence.countByG_S_Version(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextInt());

		_persistence.countByG_S_Version(0L, 0L, 0);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		E3EntryVersion newE3EntryVersion = addE3EntryVersion();

		E3EntryVersion existingE3EntryVersion = _persistence.findByPrimaryKey(
			newE3EntryVersion.getPrimaryKey());

		Assert.assertEquals(existingE3EntryVersion, newE3EntryVersion);
	}

	@Test(expected = NoSuchE3EntryVersionException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<E3EntryVersion> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"E3EntryVersion", "e3EntryVersionId", true, "version", true, "uuid",
			true, "entryId", true, "groupId", true, "companyId", true, "userId",
			true, "userName", true, "createDate", true, "modifiedDate", true,
			"authorId", true, "authorName", true, "xid", true, "name", true,
			"appClass", true, "parentId", true, "parentField", true, "status",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		E3EntryVersion newE3EntryVersion = addE3EntryVersion();

		E3EntryVersion existingE3EntryVersion = _persistence.fetchByPrimaryKey(
			newE3EntryVersion.getPrimaryKey());

		Assert.assertEquals(existingE3EntryVersion, newE3EntryVersion);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		E3EntryVersion missingE3EntryVersion = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingE3EntryVersion);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		E3EntryVersion newE3EntryVersion1 = addE3EntryVersion();
		E3EntryVersion newE3EntryVersion2 = addE3EntryVersion();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newE3EntryVersion1.getPrimaryKey());
		primaryKeys.add(newE3EntryVersion2.getPrimaryKey());

		Map<Serializable, E3EntryVersion> e3EntryVersions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, e3EntryVersions.size());
		Assert.assertEquals(
			newE3EntryVersion1,
			e3EntryVersions.get(newE3EntryVersion1.getPrimaryKey()));
		Assert.assertEquals(
			newE3EntryVersion2,
			e3EntryVersions.get(newE3EntryVersion2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, E3EntryVersion> e3EntryVersions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(e3EntryVersions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		E3EntryVersion newE3EntryVersion = addE3EntryVersion();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newE3EntryVersion.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, E3EntryVersion> e3EntryVersions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, e3EntryVersions.size());
		Assert.assertEquals(
			newE3EntryVersion,
			e3EntryVersions.get(newE3EntryVersion.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, E3EntryVersion> e3EntryVersions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(e3EntryVersions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		E3EntryVersion newE3EntryVersion = addE3EntryVersion();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newE3EntryVersion.getPrimaryKey());

		Map<Serializable, E3EntryVersion> e3EntryVersions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, e3EntryVersions.size());
		Assert.assertEquals(
			newE3EntryVersion,
			e3EntryVersions.get(newE3EntryVersion.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		E3EntryVersion newE3EntryVersion = addE3EntryVersion();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			E3EntryVersion.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"e3EntryVersionId", newE3EntryVersion.getE3EntryVersionId()));

		List<E3EntryVersion> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		E3EntryVersion existingE3EntryVersion = result.get(0);

		Assert.assertEquals(existingE3EntryVersion, newE3EntryVersion);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			E3EntryVersion.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"e3EntryVersionId", RandomTestUtil.nextLong()));

		List<E3EntryVersion> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		E3EntryVersion newE3EntryVersion = addE3EntryVersion();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			E3EntryVersion.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("e3EntryVersionId"));

		Object newE3EntryVersionId = newE3EntryVersion.getE3EntryVersionId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"e3EntryVersionId", new Object[] {newE3EntryVersionId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingE3EntryVersionId = result.get(0);

		Assert.assertEquals(existingE3EntryVersionId, newE3EntryVersionId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			E3EntryVersion.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("e3EntryVersionId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"e3EntryVersionId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		E3EntryVersion newE3EntryVersion = addE3EntryVersion();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newE3EntryVersion.getPrimaryKey()));
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

		E3EntryVersion newE3EntryVersion = addE3EntryVersion();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			E3EntryVersion.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"e3EntryVersionId", newE3EntryVersion.getE3EntryVersionId()));

		List<E3EntryVersion> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(E3EntryVersion e3EntryVersion) {
		Assert.assertEquals(
			Long.valueOf(e3EntryVersion.getEntryId()),
			ReflectionTestUtil.<Long>invoke(
				e3EntryVersion, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "entry_id"));
		Assert.assertEquals(
			Integer.valueOf(e3EntryVersion.getVersion()),
			ReflectionTestUtil.<Integer>invoke(
				e3EntryVersion, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "version"));

		Assert.assertEquals(
			e3EntryVersion.getUuid(),
			ReflectionTestUtil.invoke(
				e3EntryVersion, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(e3EntryVersion.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				e3EntryVersion, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
		Assert.assertEquals(
			Integer.valueOf(e3EntryVersion.getVersion()),
			ReflectionTestUtil.<Integer>invoke(
				e3EntryVersion, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "version"));
	}

	protected E3EntryVersion addE3EntryVersion() throws Exception {
		long pk = RandomTestUtil.nextLong();

		E3EntryVersion e3EntryVersion = _persistence.create(pk);

		e3EntryVersion.setVersion(RandomTestUtil.nextInt());

		e3EntryVersion.setUuid(RandomTestUtil.randomString());

		e3EntryVersion.setEntryId(RandomTestUtil.nextLong());

		e3EntryVersion.setGroupId(RandomTestUtil.nextLong());

		e3EntryVersion.setCompanyId(RandomTestUtil.nextLong());

		e3EntryVersion.setUserId(RandomTestUtil.nextLong());

		e3EntryVersion.setUserName(RandomTestUtil.randomString());

		e3EntryVersion.setCreateDate(RandomTestUtil.nextDate());

		e3EntryVersion.setModifiedDate(RandomTestUtil.nextDate());

		e3EntryVersion.setAuthorId(RandomTestUtil.nextLong());

		e3EntryVersion.setAuthorName(RandomTestUtil.randomString());

		e3EntryVersion.setXid(RandomTestUtil.randomString());

		e3EntryVersion.setName(RandomTestUtil.randomString());

		e3EntryVersion.setAppClass(RandomTestUtil.randomString());

		e3EntryVersion.setParentId(RandomTestUtil.nextLong());

		e3EntryVersion.setParentField(RandomTestUtil.randomString());

		e3EntryVersion.setValues(new HashMap<String, Serializable>());

		e3EntryVersion.setStatus(RandomTestUtil.nextLong());

		_e3EntryVersions.add(_persistence.update(e3EntryVersion));

		return e3EntryVersion;
	}

	private List<E3EntryVersion> _e3EntryVersions =
		new ArrayList<E3EntryVersion>();
	private E3EntryVersionPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}