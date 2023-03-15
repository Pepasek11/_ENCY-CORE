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

package cz.csob.ency.modules.apps.meta.cds.service.persistence.test;

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

import cz.csob.ency.modules.apps.meta.cds.exception.NoSuchColumnEntryException;
import cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry;
import cz.csob.ency.modules.apps.meta.cds.service.ColumnEntryLocalServiceUtil;
import cz.csob.ency.modules.apps.meta.cds.service.persistence.ColumnEntryPersistence;
import cz.csob.ency.modules.apps.meta.cds.service.persistence.ColumnEntryUtil;

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
public class ColumnEntryPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED,
				"cz.csob.ency.modules.apps.meta.cds.service"));

	@Before
	public void setUp() {
		_persistence = ColumnEntryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ColumnEntry> iterator = _columnEntries.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ColumnEntry columnEntry = _persistence.create(pk);

		Assert.assertNotNull(columnEntry);

		Assert.assertEquals(columnEntry.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ColumnEntry newColumnEntry = addColumnEntry();

		_persistence.remove(newColumnEntry);

		ColumnEntry existingColumnEntry = _persistence.fetchByPrimaryKey(
			newColumnEntry.getPrimaryKey());

		Assert.assertNull(existingColumnEntry);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addColumnEntry();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ColumnEntry newColumnEntry = _persistence.create(pk);

		newColumnEntry.setMvccVersion(RandomTestUtil.nextLong());

		newColumnEntry.setUuid(RandomTestUtil.randomString());

		newColumnEntry.setColumnType(RandomTestUtil.randomString());

		newColumnEntry.setColumnName(RandomTestUtil.randomString());

		newColumnEntry.setColumnPosition(RandomTestUtil.nextLong());

		newColumnEntry.setColumnFullName(RandomTestUtil.randomString());

		newColumnEntry.setTableEntryId(RandomTestUtil.nextLong());

		newColumnEntry.setTableName(RandomTestUtil.randomString());

		newColumnEntry.setSystemName(RandomTestUtil.randomString());

		newColumnEntry.setDatabaseName(RandomTestUtil.randomString());

		newColumnEntry.setDescription(RandomTestUtil.randomString());

		newColumnEntry.setDataType(RandomTestUtil.randomString());

		newColumnEntry.setDataSize(RandomTestUtil.nextLong());

		newColumnEntry.setIsPrimaryKey(RandomTestUtil.randomBoolean());

		newColumnEntry.setIsNotNull(RandomTestUtil.randomBoolean());

		newColumnEntry.setIsActive(RandomTestUtil.randomBoolean());

		newColumnEntry.setGroupId(RandomTestUtil.nextLong());

		newColumnEntry.setCompanyId(RandomTestUtil.nextLong());

		newColumnEntry.setUserId(RandomTestUtil.nextLong());

		newColumnEntry.setUserName(RandomTestUtil.randomString());

		newColumnEntry.setCreateDate(RandomTestUtil.nextDate());

		newColumnEntry.setModifiedDate(RandomTestUtil.nextDate());

		newColumnEntry.setUrlTitle(RandomTestUtil.randomString());

		newColumnEntry.setStatus(RandomTestUtil.nextInt());

		newColumnEntry.setStatusByUserId(RandomTestUtil.nextLong());

		newColumnEntry.setStatusByUserName(RandomTestUtil.randomString());

		newColumnEntry.setStatusDate(RandomTestUtil.nextDate());

		_columnEntries.add(_persistence.update(newColumnEntry));

		ColumnEntry existingColumnEntry = _persistence.findByPrimaryKey(
			newColumnEntry.getPrimaryKey());

		Assert.assertEquals(
			existingColumnEntry.getMvccVersion(),
			newColumnEntry.getMvccVersion());
		Assert.assertEquals(
			existingColumnEntry.getUuid(), newColumnEntry.getUuid());
		Assert.assertEquals(
			existingColumnEntry.getColumnEntryId(),
			newColumnEntry.getColumnEntryId());
		Assert.assertEquals(
			existingColumnEntry.getColumnType(),
			newColumnEntry.getColumnType());
		Assert.assertEquals(
			existingColumnEntry.getColumnName(),
			newColumnEntry.getColumnName());
		Assert.assertEquals(
			existingColumnEntry.getColumnPosition(),
			newColumnEntry.getColumnPosition());
		Assert.assertEquals(
			existingColumnEntry.getColumnFullName(),
			newColumnEntry.getColumnFullName());
		Assert.assertEquals(
			existingColumnEntry.getTableEntryId(),
			newColumnEntry.getTableEntryId());
		Assert.assertEquals(
			existingColumnEntry.getTableName(), newColumnEntry.getTableName());
		Assert.assertEquals(
			existingColumnEntry.getSystemName(),
			newColumnEntry.getSystemName());
		Assert.assertEquals(
			existingColumnEntry.getDatabaseName(),
			newColumnEntry.getDatabaseName());
		Assert.assertEquals(
			existingColumnEntry.getDescription(),
			newColumnEntry.getDescription());
		Assert.assertEquals(
			existingColumnEntry.getDataType(), newColumnEntry.getDataType());
		Assert.assertEquals(
			existingColumnEntry.getDataSize(), newColumnEntry.getDataSize());
		Assert.assertEquals(
			existingColumnEntry.isIsPrimaryKey(),
			newColumnEntry.isIsPrimaryKey());
		Assert.assertEquals(
			existingColumnEntry.isIsNotNull(), newColumnEntry.isIsNotNull());
		Assert.assertEquals(
			existingColumnEntry.isIsActive(), newColumnEntry.isIsActive());
		Assert.assertEquals(
			existingColumnEntry.getGroupId(), newColumnEntry.getGroupId());
		Assert.assertEquals(
			existingColumnEntry.getCompanyId(), newColumnEntry.getCompanyId());
		Assert.assertEquals(
			existingColumnEntry.getUserId(), newColumnEntry.getUserId());
		Assert.assertEquals(
			existingColumnEntry.getUserName(), newColumnEntry.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingColumnEntry.getCreateDate()),
			Time.getShortTimestamp(newColumnEntry.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingColumnEntry.getModifiedDate()),
			Time.getShortTimestamp(newColumnEntry.getModifiedDate()));
		Assert.assertEquals(
			existingColumnEntry.getUrlTitle(), newColumnEntry.getUrlTitle());
		Assert.assertEquals(
			existingColumnEntry.getStatus(), newColumnEntry.getStatus());
		Assert.assertEquals(
			existingColumnEntry.getStatusByUserId(),
			newColumnEntry.getStatusByUserId());
		Assert.assertEquals(
			existingColumnEntry.getStatusByUserName(),
			newColumnEntry.getStatusByUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingColumnEntry.getStatusDate()),
			Time.getShortTimestamp(newColumnEntry.getStatusDate()));
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
	public void testCountByC_S() throws Exception {
		_persistence.countByC_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByC_S(0L, 0);
	}

	@Test
	public void testCountByC_SArrayable() throws Exception {
		_persistence.countByC_S(
			RandomTestUtil.nextLong(), new int[] {RandomTestUtil.nextInt(), 0});
	}

	@Test
	public void testCountByG_S() throws Exception {
		_persistence.countByG_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByG_S(0L, 0);
	}

	@Test
	public void testCountByG_SArrayable() throws Exception {
		_persistence.countByG_S(
			RandomTestUtil.nextLong(), new int[] {RandomTestUtil.nextInt(), 0});
	}

	@Test
	public void testCountByC_U_S() throws Exception {
		_persistence.countByC_U_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextInt());

		_persistence.countByC_U_S(0L, 0L, 0);
	}

	@Test
	public void testCountByC_U_SArrayable() throws Exception {
		_persistence.countByC_U_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			new int[] {RandomTestUtil.nextInt(), 0});
	}

	@Test
	public void testCountByG_U_S() throws Exception {
		_persistence.countByG_U_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextInt());

		_persistence.countByG_U_S(0L, 0L, 0);
	}

	@Test
	public void testCountByG_U_SArrayable() throws Exception {
		_persistence.countByG_U_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			new int[] {RandomTestUtil.nextInt(), 0});
	}

	@Test
	public void testCountByU_S() throws Exception {
		_persistence.countByU_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByU_S(0L, 0);
	}

	@Test
	public void testCountByU_SArrayable() throws Exception {
		_persistence.countByU_S(
			RandomTestUtil.nextLong(), new int[] {RandomTestUtil.nextInt(), 0});
	}

	@Test
	public void testCountByG_UT_ST() throws Exception {
		_persistence.countByG_UT_ST(
			RandomTestUtil.nextLong(), "", RandomTestUtil.nextInt());

		_persistence.countByG_UT_ST(0L, "null", 0);

		_persistence.countByG_UT_ST(0L, (String)null, 0);
	}

	@Test
	public void testCountByG_UT_STArrayable() throws Exception {
		_persistence.countByG_UT_ST(
			RandomTestUtil.nextLong(), RandomTestUtil.randomString(),
			new int[] {RandomTestUtil.nextInt(), 0});
	}

	@Test
	public void testCountByG_UT() throws Exception {
		_persistence.countByG_UT(RandomTestUtil.nextLong(), "");

		_persistence.countByG_UT(0L, "null");

		_persistence.countByG_UT(0L, (String)null);
	}

	@Test
	public void testCountByURLTitle() throws Exception {
		_persistence.countByURLTitle("");

		_persistence.countByURLTitle("null");

		_persistence.countByURLTitle((String)null);
	}

	@Test
	public void testCountByGroupId() throws Exception {
		_persistence.countByGroupId(RandomTestUtil.nextLong());

		_persistence.countByGroupId(0L);
	}

	@Test
	public void testCountByUserIdGroupId() throws Exception {
		_persistence.countByUserIdGroupId(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByUserIdGroupId(0L, 0L);
	}

	@Test
	public void testCountByUserId() throws Exception {
		_persistence.countByUserId(RandomTestUtil.nextLong());

		_persistence.countByUserId(0L);
	}

	@Test
	public void testCountByCompanyId() throws Exception {
		_persistence.countByCompanyId(RandomTestUtil.nextLong());

		_persistence.countByCompanyId(0L);
	}

	@Test
	public void testCountByColumnEntryId() throws Exception {
		_persistence.countByColumnEntryId(RandomTestUtil.nextLong());

		_persistence.countByColumnEntryId(0L);
	}

	@Test
	public void testCountByColumnType() throws Exception {
		_persistence.countByColumnType("");

		_persistence.countByColumnType("null");

		_persistence.countByColumnType((String)null);
	}

	@Test
	public void testCountByColumnName() throws Exception {
		_persistence.countByColumnName("");

		_persistence.countByColumnName("null");

		_persistence.countByColumnName((String)null);
	}

	@Test
	public void testCountByColumnFullName() throws Exception {
		_persistence.countByColumnFullName("");

		_persistence.countByColumnFullName("null");

		_persistence.countByColumnFullName((String)null);
	}

	@Test
	public void testCountByTableEntryId() throws Exception {
		_persistence.countByTableEntryId(RandomTestUtil.nextLong());

		_persistence.countByTableEntryId(0L);
	}

	@Test
	public void testCountBySystemName() throws Exception {
		_persistence.countBySystemName("");

		_persistence.countBySystemName("null");

		_persistence.countBySystemName((String)null);
	}

	@Test
	public void testCountByDatabaseName() throws Exception {
		_persistence.countByDatabaseName("");

		_persistence.countByDatabaseName("null");

		_persistence.countByDatabaseName((String)null);
	}

	@Test
	public void testCountByIsActive() throws Exception {
		_persistence.countByIsActive(RandomTestUtil.randomBoolean());

		_persistence.countByIsActive(RandomTestUtil.randomBoolean());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ColumnEntry newColumnEntry = addColumnEntry();

		ColumnEntry existingColumnEntry = _persistence.findByPrimaryKey(
			newColumnEntry.getPrimaryKey());

		Assert.assertEquals(existingColumnEntry, newColumnEntry);
	}

	@Test(expected = NoSuchColumnEntryException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	@Test
	public void testFilterFindByGroupId() throws Exception {
		_persistence.filterFindByGroupId(
			0, QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<ColumnEntry> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"MetaCds_ColumnEntry", "mvccVersion", true, "uuid", true,
			"columnEntryId", true, "columnType", true, "columnName", true,
			"columnPosition", true, "columnFullName", true, "tableEntryId",
			true, "tableName", true, "systemName", true, "databaseName", true,
			"dataType", true, "dataSize", true, "isPrimaryKey", true,
			"isNotNull", true, "isActive", true, "groupId", true, "companyId",
			true, "userId", true, "userName", true, "createDate", true,
			"modifiedDate", true, "urlTitle", true, "status", true,
			"statusByUserId", true, "statusByUserName", true, "statusDate",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ColumnEntry newColumnEntry = addColumnEntry();

		ColumnEntry existingColumnEntry = _persistence.fetchByPrimaryKey(
			newColumnEntry.getPrimaryKey());

		Assert.assertEquals(existingColumnEntry, newColumnEntry);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ColumnEntry missingColumnEntry = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingColumnEntry);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		ColumnEntry newColumnEntry1 = addColumnEntry();
		ColumnEntry newColumnEntry2 = addColumnEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newColumnEntry1.getPrimaryKey());
		primaryKeys.add(newColumnEntry2.getPrimaryKey());

		Map<Serializable, ColumnEntry> columnEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, columnEntries.size());
		Assert.assertEquals(
			newColumnEntry1,
			columnEntries.get(newColumnEntry1.getPrimaryKey()));
		Assert.assertEquals(
			newColumnEntry2,
			columnEntries.get(newColumnEntry2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ColumnEntry> columnEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(columnEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		ColumnEntry newColumnEntry = addColumnEntry();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newColumnEntry.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ColumnEntry> columnEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, columnEntries.size());
		Assert.assertEquals(
			newColumnEntry, columnEntries.get(newColumnEntry.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ColumnEntry> columnEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(columnEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		ColumnEntry newColumnEntry = addColumnEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newColumnEntry.getPrimaryKey());

		Map<Serializable, ColumnEntry> columnEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, columnEntries.size());
		Assert.assertEquals(
			newColumnEntry, columnEntries.get(newColumnEntry.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ColumnEntryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ColumnEntry>() {

				@Override
				public void performAction(ColumnEntry columnEntry) {
					Assert.assertNotNull(columnEntry);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		ColumnEntry newColumnEntry = addColumnEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ColumnEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"columnEntryId", newColumnEntry.getColumnEntryId()));

		List<ColumnEntry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		ColumnEntry existingColumnEntry = result.get(0);

		Assert.assertEquals(existingColumnEntry, newColumnEntry);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ColumnEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"columnEntryId", RandomTestUtil.nextLong()));

		List<ColumnEntry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		ColumnEntry newColumnEntry = addColumnEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ColumnEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("columnEntryId"));

		Object newColumnEntryId = newColumnEntry.getColumnEntryId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"columnEntryId", new Object[] {newColumnEntryId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingColumnEntryId = result.get(0);

		Assert.assertEquals(existingColumnEntryId, newColumnEntryId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ColumnEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("columnEntryId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"columnEntryId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		ColumnEntry newColumnEntry = addColumnEntry();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newColumnEntry.getPrimaryKey()));
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

		ColumnEntry newColumnEntry = addColumnEntry();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ColumnEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"columnEntryId", newColumnEntry.getColumnEntryId()));

		List<ColumnEntry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(ColumnEntry columnEntry) {
		Assert.assertEquals(
			columnEntry.getUuid(),
			ReflectionTestUtil.invoke(
				columnEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(columnEntry.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				columnEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));

		Assert.assertEquals(
			Long.valueOf(columnEntry.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				columnEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
		Assert.assertEquals(
			columnEntry.getUrlTitle(),
			ReflectionTestUtil.invoke(
				columnEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "urlTitle"));

		Assert.assertEquals(
			columnEntry.getUrlTitle(),
			ReflectionTestUtil.invoke(
				columnEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "urlTitle"));
	}

	protected ColumnEntry addColumnEntry() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ColumnEntry columnEntry = _persistence.create(pk);

		columnEntry.setMvccVersion(RandomTestUtil.nextLong());

		columnEntry.setUuid(RandomTestUtil.randomString());

		columnEntry.setColumnType(RandomTestUtil.randomString());

		columnEntry.setColumnName(RandomTestUtil.randomString());

		columnEntry.setColumnPosition(RandomTestUtil.nextLong());

		columnEntry.setColumnFullName(RandomTestUtil.randomString());

		columnEntry.setTableEntryId(RandomTestUtil.nextLong());

		columnEntry.setTableName(RandomTestUtil.randomString());

		columnEntry.setSystemName(RandomTestUtil.randomString());

		columnEntry.setDatabaseName(RandomTestUtil.randomString());

		columnEntry.setDescription(RandomTestUtil.randomString());

		columnEntry.setDataType(RandomTestUtil.randomString());

		columnEntry.setDataSize(RandomTestUtil.nextLong());

		columnEntry.setIsPrimaryKey(RandomTestUtil.randomBoolean());

		columnEntry.setIsNotNull(RandomTestUtil.randomBoolean());

		columnEntry.setIsActive(RandomTestUtil.randomBoolean());

		columnEntry.setGroupId(RandomTestUtil.nextLong());

		columnEntry.setCompanyId(RandomTestUtil.nextLong());

		columnEntry.setUserId(RandomTestUtil.nextLong());

		columnEntry.setUserName(RandomTestUtil.randomString());

		columnEntry.setCreateDate(RandomTestUtil.nextDate());

		columnEntry.setModifiedDate(RandomTestUtil.nextDate());

		columnEntry.setUrlTitle(RandomTestUtil.randomString());

		columnEntry.setStatus(RandomTestUtil.nextInt());

		columnEntry.setStatusByUserId(RandomTestUtil.nextLong());

		columnEntry.setStatusByUserName(RandomTestUtil.randomString());

		columnEntry.setStatusDate(RandomTestUtil.nextDate());

		_columnEntries.add(_persistence.update(columnEntry));

		return columnEntry;
	}

	private List<ColumnEntry> _columnEntries = new ArrayList<ColumnEntry>();
	private ColumnEntryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}