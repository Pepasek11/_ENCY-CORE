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

import cz.csob.ency.modules.apps.meta.cds.exception.NoSuchSystemEntryException;
import cz.csob.ency.modules.apps.meta.cds.model.SystemEntry;
import cz.csob.ency.modules.apps.meta.cds.service.SystemEntryLocalServiceUtil;
import cz.csob.ency.modules.apps.meta.cds.service.persistence.SystemEntryPersistence;
import cz.csob.ency.modules.apps.meta.cds.service.persistence.SystemEntryUtil;

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
public class SystemEntryPersistenceTest {

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
		_persistence = SystemEntryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<SystemEntry> iterator = _systemEntries.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SystemEntry systemEntry = _persistence.create(pk);

		Assert.assertNotNull(systemEntry);

		Assert.assertEquals(systemEntry.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		SystemEntry newSystemEntry = addSystemEntry();

		_persistence.remove(newSystemEntry);

		SystemEntry existingSystemEntry = _persistence.fetchByPrimaryKey(
			newSystemEntry.getPrimaryKey());

		Assert.assertNull(existingSystemEntry);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSystemEntry();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SystemEntry newSystemEntry = _persistence.create(pk);

		newSystemEntry.setMvccVersion(RandomTestUtil.nextLong());

		newSystemEntry.setUuid(RandomTestUtil.randomString());

		newSystemEntry.setSystemCode(RandomTestUtil.nextLong());

		newSystemEntry.setSystemName(RandomTestUtil.randomString());

		newSystemEntry.setSystemTitle(RandomTestUtil.randomString());

		newSystemEntry.setSystemType(RandomTestUtil.randomString());

		newSystemEntry.setDescription(RandomTestUtil.randomString());

		newSystemEntry.setStewardName(RandomTestUtil.randomString());

		newSystemEntry.setStewardId(RandomTestUtil.randomString());

		newSystemEntry.setStewardDepartment(RandomTestUtil.randomString());

		newSystemEntry.setBusinessOwnerName(RandomTestUtil.randomString());

		newSystemEntry.setBusinessOwnerId(RandomTestUtil.randomString());

		newSystemEntry.setContactPersonName(RandomTestUtil.randomString());

		newSystemEntry.setContactPersonId(RandomTestUtil.randomString());

		newSystemEntry.setSandboxName(RandomTestUtil.randomString());

		newSystemEntry.setGestorDepartmentId(RandomTestUtil.randomString());

		newSystemEntry.setGestorDepartmentName(RandomTestUtil.randomString());

		newSystemEntry.setRole(RandomTestUtil.randomString());

		newSystemEntry.setSnowAssetTagId(RandomTestUtil.randomString());

		newSystemEntry.setSnowAssetTagName(RandomTestUtil.randomString());

		newSystemEntry.setIsSlaSigned(RandomTestUtil.randomBoolean());

		newSystemEntry.setIsSelfBi(RandomTestUtil.randomBoolean());

		newSystemEntry.setIsActive(RandomTestUtil.randomBoolean());

		newSystemEntry.setGroupId(RandomTestUtil.nextLong());

		newSystemEntry.setCompanyId(RandomTestUtil.nextLong());

		newSystemEntry.setUserId(RandomTestUtil.nextLong());

		newSystemEntry.setUserName(RandomTestUtil.randomString());

		newSystemEntry.setCreateDate(RandomTestUtil.nextDate());

		newSystemEntry.setModifiedDate(RandomTestUtil.nextDate());

		newSystemEntry.setUrlTitle(RandomTestUtil.randomString());

		newSystemEntry.setStatus(RandomTestUtil.nextInt());

		newSystemEntry.setStatusByUserId(RandomTestUtil.nextLong());

		newSystemEntry.setStatusByUserName(RandomTestUtil.randomString());

		newSystemEntry.setStatusDate(RandomTestUtil.nextDate());

		_systemEntries.add(_persistence.update(newSystemEntry));

		SystemEntry existingSystemEntry = _persistence.findByPrimaryKey(
			newSystemEntry.getPrimaryKey());

		Assert.assertEquals(
			existingSystemEntry.getMvccVersion(),
			newSystemEntry.getMvccVersion());
		Assert.assertEquals(
			existingSystemEntry.getUuid(), newSystemEntry.getUuid());
		Assert.assertEquals(
			existingSystemEntry.getSystemEntryId(),
			newSystemEntry.getSystemEntryId());
		Assert.assertEquals(
			existingSystemEntry.getSystemCode(),
			newSystemEntry.getSystemCode());
		Assert.assertEquals(
			existingSystemEntry.getSystemName(),
			newSystemEntry.getSystemName());
		Assert.assertEquals(
			existingSystemEntry.getSystemTitle(),
			newSystemEntry.getSystemTitle());
		Assert.assertEquals(
			existingSystemEntry.getSystemType(),
			newSystemEntry.getSystemType());
		Assert.assertEquals(
			existingSystemEntry.getDescription(),
			newSystemEntry.getDescription());
		Assert.assertEquals(
			existingSystemEntry.getStewardName(),
			newSystemEntry.getStewardName());
		Assert.assertEquals(
			existingSystemEntry.getStewardId(), newSystemEntry.getStewardId());
		Assert.assertEquals(
			existingSystemEntry.getStewardDepartment(),
			newSystemEntry.getStewardDepartment());
		Assert.assertEquals(
			existingSystemEntry.getBusinessOwnerName(),
			newSystemEntry.getBusinessOwnerName());
		Assert.assertEquals(
			existingSystemEntry.getBusinessOwnerId(),
			newSystemEntry.getBusinessOwnerId());
		Assert.assertEquals(
			existingSystemEntry.getContactPersonName(),
			newSystemEntry.getContactPersonName());
		Assert.assertEquals(
			existingSystemEntry.getContactPersonId(),
			newSystemEntry.getContactPersonId());
		Assert.assertEquals(
			existingSystemEntry.getSandboxName(),
			newSystemEntry.getSandboxName());
		Assert.assertEquals(
			existingSystemEntry.getGestorDepartmentId(),
			newSystemEntry.getGestorDepartmentId());
		Assert.assertEquals(
			existingSystemEntry.getGestorDepartmentName(),
			newSystemEntry.getGestorDepartmentName());
		Assert.assertEquals(
			existingSystemEntry.getRole(), newSystemEntry.getRole());
		Assert.assertEquals(
			existingSystemEntry.getSnowAssetTagId(),
			newSystemEntry.getSnowAssetTagId());
		Assert.assertEquals(
			existingSystemEntry.getSnowAssetTagName(),
			newSystemEntry.getSnowAssetTagName());
		Assert.assertEquals(
			existingSystemEntry.isIsSlaSigned(),
			newSystemEntry.isIsSlaSigned());
		Assert.assertEquals(
			existingSystemEntry.isIsSelfBi(), newSystemEntry.isIsSelfBi());
		Assert.assertEquals(
			existingSystemEntry.isIsActive(), newSystemEntry.isIsActive());
		Assert.assertEquals(
			existingSystemEntry.getGroupId(), newSystemEntry.getGroupId());
		Assert.assertEquals(
			existingSystemEntry.getCompanyId(), newSystemEntry.getCompanyId());
		Assert.assertEquals(
			existingSystemEntry.getUserId(), newSystemEntry.getUserId());
		Assert.assertEquals(
			existingSystemEntry.getUserName(), newSystemEntry.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingSystemEntry.getCreateDate()),
			Time.getShortTimestamp(newSystemEntry.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingSystemEntry.getModifiedDate()),
			Time.getShortTimestamp(newSystemEntry.getModifiedDate()));
		Assert.assertEquals(
			existingSystemEntry.getUrlTitle(), newSystemEntry.getUrlTitle());
		Assert.assertEquals(
			existingSystemEntry.getStatus(), newSystemEntry.getStatus());
		Assert.assertEquals(
			existingSystemEntry.getStatusByUserId(),
			newSystemEntry.getStatusByUserId());
		Assert.assertEquals(
			existingSystemEntry.getStatusByUserName(),
			newSystemEntry.getStatusByUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingSystemEntry.getStatusDate()),
			Time.getShortTimestamp(newSystemEntry.getStatusDate()));
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
	public void testCountBySystemEntryId() throws Exception {
		_persistence.countBySystemEntryId(RandomTestUtil.nextLong());

		_persistence.countBySystemEntryId(0L);
	}

	@Test
	public void testCountBySystemCode() throws Exception {
		_persistence.countBySystemCode(RandomTestUtil.nextLong());

		_persistence.countBySystemCode(0L);
	}

	@Test
	public void testCountBySystemName() throws Exception {
		_persistence.countBySystemName("");

		_persistence.countBySystemName("null");

		_persistence.countBySystemName((String)null);
	}

	@Test
	public void testCountByIsSlaSigned() throws Exception {
		_persistence.countByIsSlaSigned(RandomTestUtil.randomBoolean());

		_persistence.countByIsSlaSigned(RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByIsSelfBi() throws Exception {
		_persistence.countByIsSelfBi(RandomTestUtil.randomBoolean());

		_persistence.countByIsSelfBi(RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByIsActive() throws Exception {
		_persistence.countByIsActive(RandomTestUtil.randomBoolean());

		_persistence.countByIsActive(RandomTestUtil.randomBoolean());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		SystemEntry newSystemEntry = addSystemEntry();

		SystemEntry existingSystemEntry = _persistence.findByPrimaryKey(
			newSystemEntry.getPrimaryKey());

		Assert.assertEquals(existingSystemEntry, newSystemEntry);
	}

	@Test(expected = NoSuchSystemEntryException.class)
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

	protected OrderByComparator<SystemEntry> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"MetaCds_SystemEntry", "mvccVersion", true, "uuid", true,
			"systemEntryId", true, "systemCode", true, "systemName", true,
			"systemTitle", true, "systemType", true, "stewardName", true,
			"stewardId", true, "stewardDepartment", true, "businessOwnerName",
			true, "businessOwnerId", true, "contactPersonName", true,
			"contactPersonId", true, "sandboxName", true, "gestorDepartmentId",
			true, "gestorDepartmentName", true, "role", true, "snowAssetTagId",
			true, "snowAssetTagName", true, "isSlaSigned", true, "isSelfBi",
			true, "isActive", true, "groupId", true, "companyId", true,
			"userId", true, "userName", true, "createDate", true,
			"modifiedDate", true, "urlTitle", true, "status", true,
			"statusByUserId", true, "statusByUserName", true, "statusDate",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		SystemEntry newSystemEntry = addSystemEntry();

		SystemEntry existingSystemEntry = _persistence.fetchByPrimaryKey(
			newSystemEntry.getPrimaryKey());

		Assert.assertEquals(existingSystemEntry, newSystemEntry);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SystemEntry missingSystemEntry = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSystemEntry);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		SystemEntry newSystemEntry1 = addSystemEntry();
		SystemEntry newSystemEntry2 = addSystemEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSystemEntry1.getPrimaryKey());
		primaryKeys.add(newSystemEntry2.getPrimaryKey());

		Map<Serializable, SystemEntry> systemEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, systemEntries.size());
		Assert.assertEquals(
			newSystemEntry1,
			systemEntries.get(newSystemEntry1.getPrimaryKey()));
		Assert.assertEquals(
			newSystemEntry2,
			systemEntries.get(newSystemEntry2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, SystemEntry> systemEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(systemEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		SystemEntry newSystemEntry = addSystemEntry();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSystemEntry.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, SystemEntry> systemEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, systemEntries.size());
		Assert.assertEquals(
			newSystemEntry, systemEntries.get(newSystemEntry.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, SystemEntry> systemEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(systemEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		SystemEntry newSystemEntry = addSystemEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSystemEntry.getPrimaryKey());

		Map<Serializable, SystemEntry> systemEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, systemEntries.size());
		Assert.assertEquals(
			newSystemEntry, systemEntries.get(newSystemEntry.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			SystemEntryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<SystemEntry>() {

				@Override
				public void performAction(SystemEntry systemEntry) {
					Assert.assertNotNull(systemEntry);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		SystemEntry newSystemEntry = addSystemEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SystemEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"systemEntryId", newSystemEntry.getSystemEntryId()));

		List<SystemEntry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		SystemEntry existingSystemEntry = result.get(0);

		Assert.assertEquals(existingSystemEntry, newSystemEntry);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SystemEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"systemEntryId", RandomTestUtil.nextLong()));

		List<SystemEntry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		SystemEntry newSystemEntry = addSystemEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SystemEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("systemEntryId"));

		Object newSystemEntryId = newSystemEntry.getSystemEntryId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"systemEntryId", new Object[] {newSystemEntryId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingSystemEntryId = result.get(0);

		Assert.assertEquals(existingSystemEntryId, newSystemEntryId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SystemEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("systemEntryId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"systemEntryId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		SystemEntry newSystemEntry = addSystemEntry();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newSystemEntry.getPrimaryKey()));
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

		SystemEntry newSystemEntry = addSystemEntry();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SystemEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"systemEntryId", newSystemEntry.getSystemEntryId()));

		List<SystemEntry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(SystemEntry systemEntry) {
		Assert.assertEquals(
			systemEntry.getUuid(),
			ReflectionTestUtil.invoke(
				systemEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(systemEntry.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				systemEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));

		Assert.assertEquals(
			Long.valueOf(systemEntry.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				systemEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
		Assert.assertEquals(
			systemEntry.getUrlTitle(),
			ReflectionTestUtil.invoke(
				systemEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "urlTitle"));

		Assert.assertEquals(
			systemEntry.getUrlTitle(),
			ReflectionTestUtil.invoke(
				systemEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "urlTitle"));
	}

	protected SystemEntry addSystemEntry() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SystemEntry systemEntry = _persistence.create(pk);

		systemEntry.setMvccVersion(RandomTestUtil.nextLong());

		systemEntry.setUuid(RandomTestUtil.randomString());

		systemEntry.setSystemCode(RandomTestUtil.nextLong());

		systemEntry.setSystemName(RandomTestUtil.randomString());

		systemEntry.setSystemTitle(RandomTestUtil.randomString());

		systemEntry.setSystemType(RandomTestUtil.randomString());

		systemEntry.setDescription(RandomTestUtil.randomString());

		systemEntry.setStewardName(RandomTestUtil.randomString());

		systemEntry.setStewardId(RandomTestUtil.randomString());

		systemEntry.setStewardDepartment(RandomTestUtil.randomString());

		systemEntry.setBusinessOwnerName(RandomTestUtil.randomString());

		systemEntry.setBusinessOwnerId(RandomTestUtil.randomString());

		systemEntry.setContactPersonName(RandomTestUtil.randomString());

		systemEntry.setContactPersonId(RandomTestUtil.randomString());

		systemEntry.setSandboxName(RandomTestUtil.randomString());

		systemEntry.setGestorDepartmentId(RandomTestUtil.randomString());

		systemEntry.setGestorDepartmentName(RandomTestUtil.randomString());

		systemEntry.setRole(RandomTestUtil.randomString());

		systemEntry.setSnowAssetTagId(RandomTestUtil.randomString());

		systemEntry.setSnowAssetTagName(RandomTestUtil.randomString());

		systemEntry.setIsSlaSigned(RandomTestUtil.randomBoolean());

		systemEntry.setIsSelfBi(RandomTestUtil.randomBoolean());

		systemEntry.setIsActive(RandomTestUtil.randomBoolean());

		systemEntry.setGroupId(RandomTestUtil.nextLong());

		systemEntry.setCompanyId(RandomTestUtil.nextLong());

		systemEntry.setUserId(RandomTestUtil.nextLong());

		systemEntry.setUserName(RandomTestUtil.randomString());

		systemEntry.setCreateDate(RandomTestUtil.nextDate());

		systemEntry.setModifiedDate(RandomTestUtil.nextDate());

		systemEntry.setUrlTitle(RandomTestUtil.randomString());

		systemEntry.setStatus(RandomTestUtil.nextInt());

		systemEntry.setStatusByUserId(RandomTestUtil.nextLong());

		systemEntry.setStatusByUserName(RandomTestUtil.randomString());

		systemEntry.setStatusDate(RandomTestUtil.nextDate());

		_systemEntries.add(_persistence.update(systemEntry));

		return systemEntry;
	}

	private List<SystemEntry> _systemEntries = new ArrayList<SystemEntry>();
	private SystemEntryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}