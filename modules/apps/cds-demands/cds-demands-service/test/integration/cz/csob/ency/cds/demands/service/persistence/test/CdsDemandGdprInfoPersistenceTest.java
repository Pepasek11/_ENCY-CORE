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

package cz.csob.ency.cds.demands.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
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

import cz.csob.ency.cds.demands.exception.NoSuchCdsDemandGdprInfoException;
import cz.csob.ency.cds.demands.model.CdsDemandGdprInfo;
import cz.csob.ency.cds.demands.service.CdsDemandGdprInfoLocalServiceUtil;
import cz.csob.ency.cds.demands.service.persistence.CdsDemandGdprInfoPersistence;
import cz.csob.ency.cds.demands.service.persistence.CdsDemandGdprInfoUtil;

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
public class CdsDemandGdprInfoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "cz.csob.ency.cds.demands.service"));

	@Before
	public void setUp() {
		_persistence = CdsDemandGdprInfoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CdsDemandGdprInfo> iterator = _cdsDemandGdprInfos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CdsDemandGdprInfo cdsDemandGdprInfo = _persistence.create(pk);

		Assert.assertNotNull(cdsDemandGdprInfo);

		Assert.assertEquals(cdsDemandGdprInfo.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CdsDemandGdprInfo newCdsDemandGdprInfo = addCdsDemandGdprInfo();

		_persistence.remove(newCdsDemandGdprInfo);

		CdsDemandGdprInfo existingCdsDemandGdprInfo =
			_persistence.fetchByPrimaryKey(
				newCdsDemandGdprInfo.getPrimaryKey());

		Assert.assertNull(existingCdsDemandGdprInfo);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCdsDemandGdprInfo();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CdsDemandGdprInfo newCdsDemandGdprInfo = _persistence.create(pk);

		newCdsDemandGdprInfo.setUuid(RandomTestUtil.randomString());

		newCdsDemandGdprInfo.setDemandId(RandomTestUtil.nextLong());

		newCdsDemandGdprInfo.setTitle(RandomTestUtil.randomString());

		newCdsDemandGdprInfo.setDescription(RandomTestUtil.randomString());

		newCdsDemandGdprInfo.setIsEmployee(RandomTestUtil.randomBoolean());

		newCdsDemandGdprInfo.setEmployeeCategory(RandomTestUtil.randomString());

		newCdsDemandGdprInfo.setEmployeeReasoning(
			RandomTestUtil.randomString());

		newCdsDemandGdprInfo.setIsClient(RandomTestUtil.randomBoolean());

		newCdsDemandGdprInfo.setClientCategory(RandomTestUtil.randomString());

		newCdsDemandGdprInfo.setClientReasoning(RandomTestUtil.randomString());

		newCdsDemandGdprInfo.setUserId(RandomTestUtil.nextLong());

		newCdsDemandGdprInfo.setUserName(RandomTestUtil.randomString());

		newCdsDemandGdprInfo.setCreateDate(RandomTestUtil.nextDate());

		newCdsDemandGdprInfo.setModifiedDate(RandomTestUtil.nextDate());

		_cdsDemandGdprInfos.add(_persistence.update(newCdsDemandGdprInfo));

		CdsDemandGdprInfo existingCdsDemandGdprInfo =
			_persistence.findByPrimaryKey(newCdsDemandGdprInfo.getPrimaryKey());

		Assert.assertEquals(
			existingCdsDemandGdprInfo.getUuid(),
			newCdsDemandGdprInfo.getUuid());
		Assert.assertEquals(
			existingCdsDemandGdprInfo.getGdprInfoId(),
			newCdsDemandGdprInfo.getGdprInfoId());
		Assert.assertEquals(
			existingCdsDemandGdprInfo.getDemandId(),
			newCdsDemandGdprInfo.getDemandId());
		Assert.assertEquals(
			existingCdsDemandGdprInfo.getTitle(),
			newCdsDemandGdprInfo.getTitle());
		Assert.assertEquals(
			existingCdsDemandGdprInfo.getDescription(),
			newCdsDemandGdprInfo.getDescription());
		Assert.assertEquals(
			existingCdsDemandGdprInfo.isIsEmployee(),
			newCdsDemandGdprInfo.isIsEmployee());
		Assert.assertEquals(
			existingCdsDemandGdprInfo.getEmployeeCategory(),
			newCdsDemandGdprInfo.getEmployeeCategory());
		Assert.assertEquals(
			existingCdsDemandGdprInfo.getEmployeeReasoning(),
			newCdsDemandGdprInfo.getEmployeeReasoning());
		Assert.assertEquals(
			existingCdsDemandGdprInfo.isIsClient(),
			newCdsDemandGdprInfo.isIsClient());
		Assert.assertEquals(
			existingCdsDemandGdprInfo.getClientCategory(),
			newCdsDemandGdprInfo.getClientCategory());
		Assert.assertEquals(
			existingCdsDemandGdprInfo.getClientReasoning(),
			newCdsDemandGdprInfo.getClientReasoning());
		Assert.assertEquals(
			existingCdsDemandGdprInfo.getUserId(),
			newCdsDemandGdprInfo.getUserId());
		Assert.assertEquals(
			existingCdsDemandGdprInfo.getUserName(),
			newCdsDemandGdprInfo.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCdsDemandGdprInfo.getCreateDate()),
			Time.getShortTimestamp(newCdsDemandGdprInfo.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCdsDemandGdprInfo.getModifiedDate()),
			Time.getShortTimestamp(newCdsDemandGdprInfo.getModifiedDate()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountBydemandId() throws Exception {
		_persistence.countBydemandId(RandomTestUtil.nextLong());

		_persistence.countBydemandId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CdsDemandGdprInfo newCdsDemandGdprInfo = addCdsDemandGdprInfo();

		CdsDemandGdprInfo existingCdsDemandGdprInfo =
			_persistence.findByPrimaryKey(newCdsDemandGdprInfo.getPrimaryKey());

		Assert.assertEquals(existingCdsDemandGdprInfo, newCdsDemandGdprInfo);
	}

	@Test(expected = NoSuchCdsDemandGdprInfoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<CdsDemandGdprInfo> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"CdsDemands_CdsDemandGdprInfo", "uuid", true, "gdprInfoId", true,
			"demandId", true, "title", true, "description", true, "isEmployee",
			true, "employeeCategory", true, "employeeReasoning", true,
			"isClient", true, "clientCategory", true, "clientReasoning", true,
			"userId", true, "userName", true, "createDate", true,
			"modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CdsDemandGdprInfo newCdsDemandGdprInfo = addCdsDemandGdprInfo();

		CdsDemandGdprInfo existingCdsDemandGdprInfo =
			_persistence.fetchByPrimaryKey(
				newCdsDemandGdprInfo.getPrimaryKey());

		Assert.assertEquals(existingCdsDemandGdprInfo, newCdsDemandGdprInfo);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CdsDemandGdprInfo missingCdsDemandGdprInfo =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCdsDemandGdprInfo);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		CdsDemandGdprInfo newCdsDemandGdprInfo1 = addCdsDemandGdprInfo();
		CdsDemandGdprInfo newCdsDemandGdprInfo2 = addCdsDemandGdprInfo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCdsDemandGdprInfo1.getPrimaryKey());
		primaryKeys.add(newCdsDemandGdprInfo2.getPrimaryKey());

		Map<Serializable, CdsDemandGdprInfo> cdsDemandGdprInfos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, cdsDemandGdprInfos.size());
		Assert.assertEquals(
			newCdsDemandGdprInfo1,
			cdsDemandGdprInfos.get(newCdsDemandGdprInfo1.getPrimaryKey()));
		Assert.assertEquals(
			newCdsDemandGdprInfo2,
			cdsDemandGdprInfos.get(newCdsDemandGdprInfo2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CdsDemandGdprInfo> cdsDemandGdprInfos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(cdsDemandGdprInfos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		CdsDemandGdprInfo newCdsDemandGdprInfo = addCdsDemandGdprInfo();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCdsDemandGdprInfo.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CdsDemandGdprInfo> cdsDemandGdprInfos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, cdsDemandGdprInfos.size());
		Assert.assertEquals(
			newCdsDemandGdprInfo,
			cdsDemandGdprInfos.get(newCdsDemandGdprInfo.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CdsDemandGdprInfo> cdsDemandGdprInfos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(cdsDemandGdprInfos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		CdsDemandGdprInfo newCdsDemandGdprInfo = addCdsDemandGdprInfo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCdsDemandGdprInfo.getPrimaryKey());

		Map<Serializable, CdsDemandGdprInfo> cdsDemandGdprInfos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, cdsDemandGdprInfos.size());
		Assert.assertEquals(
			newCdsDemandGdprInfo,
			cdsDemandGdprInfos.get(newCdsDemandGdprInfo.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CdsDemandGdprInfoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<CdsDemandGdprInfo>() {

				@Override
				public void performAction(CdsDemandGdprInfo cdsDemandGdprInfo) {
					Assert.assertNotNull(cdsDemandGdprInfo);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		CdsDemandGdprInfo newCdsDemandGdprInfo = addCdsDemandGdprInfo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CdsDemandGdprInfo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"gdprInfoId", newCdsDemandGdprInfo.getGdprInfoId()));

		List<CdsDemandGdprInfo> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		CdsDemandGdprInfo existingCdsDemandGdprInfo = result.get(0);

		Assert.assertEquals(existingCdsDemandGdprInfo, newCdsDemandGdprInfo);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CdsDemandGdprInfo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"gdprInfoId", RandomTestUtil.nextLong()));

		List<CdsDemandGdprInfo> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		CdsDemandGdprInfo newCdsDemandGdprInfo = addCdsDemandGdprInfo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CdsDemandGdprInfo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("gdprInfoId"));

		Object newGdprInfoId = newCdsDemandGdprInfo.getGdprInfoId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"gdprInfoId", new Object[] {newGdprInfoId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingGdprInfoId = result.get(0);

		Assert.assertEquals(existingGdprInfoId, newGdprInfoId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CdsDemandGdprInfo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("gdprInfoId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"gdprInfoId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected CdsDemandGdprInfo addCdsDemandGdprInfo() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CdsDemandGdprInfo cdsDemandGdprInfo = _persistence.create(pk);

		cdsDemandGdprInfo.setUuid(RandomTestUtil.randomString());

		cdsDemandGdprInfo.setDemandId(RandomTestUtil.nextLong());

		cdsDemandGdprInfo.setTitle(RandomTestUtil.randomString());

		cdsDemandGdprInfo.setDescription(RandomTestUtil.randomString());

		cdsDemandGdprInfo.setIsEmployee(RandomTestUtil.randomBoolean());

		cdsDemandGdprInfo.setEmployeeCategory(RandomTestUtil.randomString());

		cdsDemandGdprInfo.setEmployeeReasoning(RandomTestUtil.randomString());

		cdsDemandGdprInfo.setIsClient(RandomTestUtil.randomBoolean());

		cdsDemandGdprInfo.setClientCategory(RandomTestUtil.randomString());

		cdsDemandGdprInfo.setClientReasoning(RandomTestUtil.randomString());

		cdsDemandGdprInfo.setUserId(RandomTestUtil.nextLong());

		cdsDemandGdprInfo.setUserName(RandomTestUtil.randomString());

		cdsDemandGdprInfo.setCreateDate(RandomTestUtil.nextDate());

		cdsDemandGdprInfo.setModifiedDate(RandomTestUtil.nextDate());

		_cdsDemandGdprInfos.add(_persistence.update(cdsDemandGdprInfo));

		return cdsDemandGdprInfo;
	}

	private List<CdsDemandGdprInfo> _cdsDemandGdprInfos =
		new ArrayList<CdsDemandGdprInfo>();
	private CdsDemandGdprInfoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}