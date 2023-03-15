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

import cz.csob.ency.modules.apps.meta.cds.exception.NoSuchTableEntryException;
import cz.csob.ency.modules.apps.meta.cds.model.TableEntry;
import cz.csob.ency.modules.apps.meta.cds.service.TableEntryLocalServiceUtil;
import cz.csob.ency.modules.apps.meta.cds.service.persistence.TableEntryPersistence;
import cz.csob.ency.modules.apps.meta.cds.service.persistence.TableEntryUtil;

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
public class TableEntryPersistenceTest {

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
		_persistence = TableEntryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<TableEntry> iterator = _tableEntries.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TableEntry tableEntry = _persistence.create(pk);

		Assert.assertNotNull(tableEntry);

		Assert.assertEquals(tableEntry.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		TableEntry newTableEntry = addTableEntry();

		_persistence.remove(newTableEntry);

		TableEntry existingTableEntry = _persistence.fetchByPrimaryKey(
			newTableEntry.getPrimaryKey());

		Assert.assertNull(existingTableEntry);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addTableEntry();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TableEntry newTableEntry = _persistence.create(pk);

		newTableEntry.setMvccVersion(RandomTestUtil.nextLong());

		newTableEntry.setUuid(RandomTestUtil.randomString());

		newTableEntry.setTableName(RandomTestUtil.randomString());

		newTableEntry.setTableFullName(RandomTestUtil.randomString());

		newTableEntry.setTableType(RandomTestUtil.randomString());

		newTableEntry.setTableDatabase(RandomTestUtil.randomString());

		newTableEntry.setSystemEntryId(RandomTestUtil.nextLong());

		newTableEntry.setSystemName(RandomTestUtil.randomString());

		newTableEntry.setDescription(RandomTestUtil.randomString());

		newTableEntry.setDsaUrl(RandomTestUtil.randomString());

		newTableEntry.setContactPersonName(RandomTestUtil.randomString());

		newTableEntry.setContactPersonId(RandomTestUtil.randomString());

		newTableEntry.setSpecificationOwnerName(RandomTestUtil.randomString());

		newTableEntry.setSpecificationOwnerId(RandomTestUtil.randomString());

		newTableEntry.setUnstructuredClause(RandomTestUtil.randomString());

		newTableEntry.setIsActive(RandomTestUtil.randomBoolean());

		newTableEntry.setGroupId(RandomTestUtil.nextLong());

		newTableEntry.setCompanyId(RandomTestUtil.nextLong());

		newTableEntry.setUserId(RandomTestUtil.nextLong());

		newTableEntry.setUserName(RandomTestUtil.randomString());

		newTableEntry.setCreateDate(RandomTestUtil.nextDate());

		newTableEntry.setModifiedDate(RandomTestUtil.nextDate());

		newTableEntry.setUrlTitle(RandomTestUtil.randomString());

		newTableEntry.setStatus(RandomTestUtil.nextInt());

		newTableEntry.setStatusByUserId(RandomTestUtil.nextLong());

		newTableEntry.setStatusByUserName(RandomTestUtil.randomString());

		newTableEntry.setStatusDate(RandomTestUtil.nextDate());

		_tableEntries.add(_persistence.update(newTableEntry));

		TableEntry existingTableEntry = _persistence.findByPrimaryKey(
			newTableEntry.getPrimaryKey());

		Assert.assertEquals(
			existingTableEntry.getMvccVersion(),
			newTableEntry.getMvccVersion());
		Assert.assertEquals(
			existingTableEntry.getUuid(), newTableEntry.getUuid());
		Assert.assertEquals(
			existingTableEntry.getTableEntryId(),
			newTableEntry.getTableEntryId());
		Assert.assertEquals(
			existingTableEntry.getTableName(), newTableEntry.getTableName());
		Assert.assertEquals(
			existingTableEntry.getTableFullName(),
			newTableEntry.getTableFullName());
		Assert.assertEquals(
			existingTableEntry.getTableType(), newTableEntry.getTableType());
		Assert.assertEquals(
			existingTableEntry.getTableDatabase(),
			newTableEntry.getTableDatabase());
		Assert.assertEquals(
			existingTableEntry.getSystemEntryId(),
			newTableEntry.getSystemEntryId());
		Assert.assertEquals(
			existingTableEntry.getSystemName(), newTableEntry.getSystemName());
		Assert.assertEquals(
			existingTableEntry.getDescription(),
			newTableEntry.getDescription());
		Assert.assertEquals(
			existingTableEntry.getDsaUrl(), newTableEntry.getDsaUrl());
		Assert.assertEquals(
			existingTableEntry.getContactPersonName(),
			newTableEntry.getContactPersonName());
		Assert.assertEquals(
			existingTableEntry.getContactPersonId(),
			newTableEntry.getContactPersonId());
		Assert.assertEquals(
			existingTableEntry.getSpecificationOwnerName(),
			newTableEntry.getSpecificationOwnerName());
		Assert.assertEquals(
			existingTableEntry.getSpecificationOwnerId(),
			newTableEntry.getSpecificationOwnerId());
		Assert.assertEquals(
			existingTableEntry.getUnstructuredClause(),
			newTableEntry.getUnstructuredClause());
		Assert.assertEquals(
			existingTableEntry.isIsActive(), newTableEntry.isIsActive());
		Assert.assertEquals(
			existingTableEntry.getGroupId(), newTableEntry.getGroupId());
		Assert.assertEquals(
			existingTableEntry.getCompanyId(), newTableEntry.getCompanyId());
		Assert.assertEquals(
			existingTableEntry.getUserId(), newTableEntry.getUserId());
		Assert.assertEquals(
			existingTableEntry.getUserName(), newTableEntry.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingTableEntry.getCreateDate()),
			Time.getShortTimestamp(newTableEntry.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingTableEntry.getModifiedDate()),
			Time.getShortTimestamp(newTableEntry.getModifiedDate()));
		Assert.assertEquals(
			existingTableEntry.getUrlTitle(), newTableEntry.getUrlTitle());
		Assert.assertEquals(
			existingTableEntry.getStatus(), newTableEntry.getStatus());
		Assert.assertEquals(
			existingTableEntry.getStatusByUserId(),
			newTableEntry.getStatusByUserId());
		Assert.assertEquals(
			existingTableEntry.getStatusByUserName(),
			newTableEntry.getStatusByUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingTableEntry.getStatusDate()),
			Time.getShortTimestamp(newTableEntry.getStatusDate()));
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
	public void testCountByTableEntryId() throws Exception {
		_persistence.countByTableEntryId(RandomTestUtil.nextLong());

		_persistence.countByTableEntryId(0L);
	}

	@Test
	public void testCountByTableName() throws Exception {
		_persistence.countByTableName("");

		_persistence.countByTableName("null");

		_persistence.countByTableName((String)null);
	}

	@Test
	public void testCountByTableFullName() throws Exception {
		_persistence.countByTableFullName("");

		_persistence.countByTableFullName("null");

		_persistence.countByTableFullName((String)null);
	}

	@Test
	public void testCountByTableType() throws Exception {
		_persistence.countByTableType("");

		_persistence.countByTableType("null");

		_persistence.countByTableType((String)null);
	}

	@Test
	public void testCountByTableDatabase() throws Exception {
		_persistence.countByTableDatabase("");

		_persistence.countByTableDatabase("null");

		_persistence.countByTableDatabase((String)null);
	}

	@Test
	public void testCountByTableDatabaseArrayable() throws Exception {
		_persistence.countByTableDatabase(
			new String[] {
				RandomTestUtil.randomString(), "", "null", null, null
			});
	}

	@Test
	public void testCountBySystemEntryId() throws Exception {
		_persistence.countBySystemEntryId(RandomTestUtil.nextLong());

		_persistence.countBySystemEntryId(0L);
	}

	@Test
	public void testCountByDescription() throws Exception {
		_persistence.countByDescription("");

		_persistence.countByDescription("null");

		_persistence.countByDescription((String)null);
	}

	@Test
	public void testCountByIsActive() throws Exception {
		_persistence.countByIsActive(RandomTestUtil.randomBoolean());

		_persistence.countByIsActive(RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByS_D() throws Exception {
		_persistence.countByS_D(RandomTestUtil.nextLong(), "");

		_persistence.countByS_D(0L, "null");

		_persistence.countByS_D(0L, (String)null);
	}

	@Test
	public void testCountByS_DArrayable() throws Exception {
		_persistence.countByS_D(
			RandomTestUtil.nextLong(),
			new String[] {
				RandomTestUtil.randomString(), "", "null", null, null
			});
	}

	@Test
	public void testCountByS_T() throws Exception {
		_persistence.countByS_T(RandomTestUtil.nextLong(), "");

		_persistence.countByS_T(0L, "null");

		_persistence.countByS_T(0L, (String)null);
	}

	@Test
	public void testCountByS_TArrayable() throws Exception {
		_persistence.countByS_T(
			RandomTestUtil.nextLong(),
			new String[] {
				RandomTestUtil.randomString(), "", "null", null, null
			});
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		TableEntry newTableEntry = addTableEntry();

		TableEntry existingTableEntry = _persistence.findByPrimaryKey(
			newTableEntry.getPrimaryKey());

		Assert.assertEquals(existingTableEntry, newTableEntry);
	}

	@Test(expected = NoSuchTableEntryException.class)
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

	protected OrderByComparator<TableEntry> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"MetaCds_TableEntry", "mvccVersion", true, "uuid", true,
			"tableEntryId", true, "tableName", true, "tableFullName", true,
			"tableType", true, "tableDatabase", true, "systemEntryId", true,
			"systemName", true, "dsaUrl", true, "contactPersonName", true,
			"contactPersonId", true, "specificationOwnerName", true,
			"specificationOwnerId", true, "isActive", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "urlTitle", true, "status", true,
			"statusByUserId", true, "statusByUserName", true, "statusDate",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		TableEntry newTableEntry = addTableEntry();

		TableEntry existingTableEntry = _persistence.fetchByPrimaryKey(
			newTableEntry.getPrimaryKey());

		Assert.assertEquals(existingTableEntry, newTableEntry);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TableEntry missingTableEntry = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingTableEntry);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		TableEntry newTableEntry1 = addTableEntry();
		TableEntry newTableEntry2 = addTableEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTableEntry1.getPrimaryKey());
		primaryKeys.add(newTableEntry2.getPrimaryKey());

		Map<Serializable, TableEntry> tableEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, tableEntries.size());
		Assert.assertEquals(
			newTableEntry1, tableEntries.get(newTableEntry1.getPrimaryKey()));
		Assert.assertEquals(
			newTableEntry2, tableEntries.get(newTableEntry2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, TableEntry> tableEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(tableEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		TableEntry newTableEntry = addTableEntry();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTableEntry.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, TableEntry> tableEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, tableEntries.size());
		Assert.assertEquals(
			newTableEntry, tableEntries.get(newTableEntry.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, TableEntry> tableEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(tableEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		TableEntry newTableEntry = addTableEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTableEntry.getPrimaryKey());

		Map<Serializable, TableEntry> tableEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, tableEntries.size());
		Assert.assertEquals(
			newTableEntry, tableEntries.get(newTableEntry.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			TableEntryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<TableEntry>() {

				@Override
				public void performAction(TableEntry tableEntry) {
					Assert.assertNotNull(tableEntry);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		TableEntry newTableEntry = addTableEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TableEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"tableEntryId", newTableEntry.getTableEntryId()));

		List<TableEntry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		TableEntry existingTableEntry = result.get(0);

		Assert.assertEquals(existingTableEntry, newTableEntry);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TableEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"tableEntryId", RandomTestUtil.nextLong()));

		List<TableEntry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		TableEntry newTableEntry = addTableEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TableEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("tableEntryId"));

		Object newTableEntryId = newTableEntry.getTableEntryId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"tableEntryId", new Object[] {newTableEntryId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingTableEntryId = result.get(0);

		Assert.assertEquals(existingTableEntryId, newTableEntryId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TableEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("tableEntryId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"tableEntryId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		TableEntry newTableEntry = addTableEntry();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newTableEntry.getPrimaryKey()));
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

		TableEntry newTableEntry = addTableEntry();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TableEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"tableEntryId", newTableEntry.getTableEntryId()));

		List<TableEntry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(TableEntry tableEntry) {
		Assert.assertEquals(
			tableEntry.getUuid(),
			ReflectionTestUtil.invoke(
				tableEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(tableEntry.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				tableEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));

		Assert.assertEquals(
			Long.valueOf(tableEntry.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				tableEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
		Assert.assertEquals(
			tableEntry.getUrlTitle(),
			ReflectionTestUtil.invoke(
				tableEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "urlTitle"));

		Assert.assertEquals(
			tableEntry.getUrlTitle(),
			ReflectionTestUtil.invoke(
				tableEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "urlTitle"));
	}

	protected TableEntry addTableEntry() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TableEntry tableEntry = _persistence.create(pk);

		tableEntry.setMvccVersion(RandomTestUtil.nextLong());

		tableEntry.setUuid(RandomTestUtil.randomString());

		tableEntry.setTableName(RandomTestUtil.randomString());

		tableEntry.setTableFullName(RandomTestUtil.randomString());

		tableEntry.setTableType(RandomTestUtil.randomString());

		tableEntry.setTableDatabase(RandomTestUtil.randomString());

		tableEntry.setSystemEntryId(RandomTestUtil.nextLong());

		tableEntry.setSystemName(RandomTestUtil.randomString());

		tableEntry.setDescription(RandomTestUtil.randomString());

		tableEntry.setDsaUrl(RandomTestUtil.randomString());

		tableEntry.setContactPersonName(RandomTestUtil.randomString());

		tableEntry.setContactPersonId(RandomTestUtil.randomString());

		tableEntry.setSpecificationOwnerName(RandomTestUtil.randomString());

		tableEntry.setSpecificationOwnerId(RandomTestUtil.randomString());

		tableEntry.setUnstructuredClause(RandomTestUtil.randomString());

		tableEntry.setIsActive(RandomTestUtil.randomBoolean());

		tableEntry.setGroupId(RandomTestUtil.nextLong());

		tableEntry.setCompanyId(RandomTestUtil.nextLong());

		tableEntry.setUserId(RandomTestUtil.nextLong());

		tableEntry.setUserName(RandomTestUtil.randomString());

		tableEntry.setCreateDate(RandomTestUtil.nextDate());

		tableEntry.setModifiedDate(RandomTestUtil.nextDate());

		tableEntry.setUrlTitle(RandomTestUtil.randomString());

		tableEntry.setStatus(RandomTestUtil.nextInt());

		tableEntry.setStatusByUserId(RandomTestUtil.nextLong());

		tableEntry.setStatusByUserName(RandomTestUtil.randomString());

		tableEntry.setStatusDate(RandomTestUtil.nextDate());

		_tableEntries.add(_persistence.update(tableEntry));

		return tableEntry;
	}

	private List<TableEntry> _tableEntries = new ArrayList<TableEntry>();
	private TableEntryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}