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
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.AssertUtils;
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

import cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.cds.demands.service.CdsDemandLocalServiceUtil;
import cz.csob.ency.cds.demands.service.persistence.CdsDemandPersistence;
import cz.csob.ency.cds.demands.service.persistence.CdsDemandUtil;

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
public class CdsDemandPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "cz.csob.ency.cds.demands.service"));

	@Before
	public void setUp() {
		_persistence = CdsDemandUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CdsDemand> iterator = _cdsDemands.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CdsDemand cdsDemand = _persistence.create(pk);

		Assert.assertNotNull(cdsDemand);

		Assert.assertEquals(cdsDemand.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CdsDemand newCdsDemand = addCdsDemand();

		_persistence.remove(newCdsDemand);

		CdsDemand existingCdsDemand = _persistence.fetchByPrimaryKey(
			newCdsDemand.getPrimaryKey());

		Assert.assertNull(existingCdsDemand);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCdsDemand();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CdsDemand newCdsDemand = _persistence.create(pk);

		newCdsDemand.setMvccVersion(RandomTestUtil.nextLong());

		newCdsDemand.setUuid(RandomTestUtil.randomString());

		newCdsDemand.setHeadId(RandomTestUtil.nextLong());

		newCdsDemand.setTitle(RandomTestUtil.randomString());

		newCdsDemand.setDescription(RandomTestUtil.randomString());

		newCdsDemand.setType(RandomTestUtil.nextInt());

		newCdsDemand.setPriority(RandomTestUtil.nextInt());

		newCdsDemand.setRequestedDelivery(RandomTestUtil.nextDate());

		newCdsDemand.setIsGDPR(RandomTestUtil.randomBoolean());

		newCdsDemand.setGdprInfo(RandomTestUtil.randomString());

		newCdsDemand.setFiveTracks(RandomTestUtil.randomString());

		newCdsDemand.setRequestorId(RandomTestUtil.nextLong());

		newCdsDemand.setRequestorName(RandomTestUtil.randomString());

		newCdsDemand.setRequestedForId(RandomTestUtil.nextLong());

		newCdsDemand.setRequestedForName(RandomTestUtil.randomString());

		newCdsDemand.setContactId(RandomTestUtil.nextLong());

		newCdsDemand.setContactName(RandomTestUtil.randomString());

		newCdsDemand.setDomainId(RandomTestUtil.nextLong());

		newCdsDemand.setDomainName(RandomTestUtil.randomString());

		newCdsDemand.setBanId(RandomTestUtil.nextLong());

		newCdsDemand.setBanName(RandomTestUtil.randomString());

		newCdsDemand.setSpocId(RandomTestUtil.nextLong());

		newCdsDemand.setSpocName(RandomTestUtil.randomString());

		newCdsDemand.setUsReasoning(RandomTestUtil.randomString());

		newCdsDemand.setUsFrequencyOut(RandomTestUtil.nextInt());

		newCdsDemand.setUsAccessDPM(RandomTestUtil.randomBoolean());

		newCdsDemand.setUsFolderDPM(RandomTestUtil.randomString());

		newCdsDemand.setUsCreateFolderDPM(RandomTestUtil.randomBoolean());

		newCdsDemand.setUsGestorFolderDPMId(RandomTestUtil.nextLong());

		newCdsDemand.setUsGestorFolderDPMName(RandomTestUtil.randomString());

		newCdsDemand.setUsDPMNotificationMail(RandomTestUtil.randomString());

		newCdsDemand.setBioeId(RandomTestUtil.randomString());

		newCdsDemand.setBioeStateId();

		newCdsDemand.setBioeStateName(RandomTestUtil.randomString());

		newCdsDemand.setWorkEstimate(RandomTestUtil.nextDouble());

		newCdsDemand.setAcceptedWorkEstimate(RandomTestUtil.nextDouble());

		newCdsDemand.setExpectedDelivery(RandomTestUtil.nextDate());

		newCdsDemand.setAcceptedDelivery(RandomTestUtil.nextDate());

		newCdsDemand.setGroupId(RandomTestUtil.nextLong());

		newCdsDemand.setCompanyId(RandomTestUtil.nextLong());

		newCdsDemand.setUserId(RandomTestUtil.nextLong());

		newCdsDemand.setUserName(RandomTestUtil.randomString());

		newCdsDemand.setCreateDate(RandomTestUtil.nextDate());

		newCdsDemand.setModifiedDate(RandomTestUtil.nextDate());

		newCdsDemand.setUrlTitle(RandomTestUtil.randomString());

		newCdsDemand.setState(RandomTestUtil.randomString());

		newCdsDemand.setStateByUserId(RandomTestUtil.nextLong());

		newCdsDemand.setStateByUserName(RandomTestUtil.randomString());

		newCdsDemand.setStateDate(RandomTestUtil.nextDate());

		_cdsDemands.add(_persistence.update(newCdsDemand));

		CdsDemand existingCdsDemand = _persistence.findByPrimaryKey(
			newCdsDemand.getPrimaryKey());

		Assert.assertEquals(
			existingCdsDemand.getMvccVersion(), newCdsDemand.getMvccVersion());
		Assert.assertEquals(
			existingCdsDemand.getUuid(), newCdsDemand.getUuid());
		Assert.assertEquals(
			existingCdsDemand.getHeadId(), newCdsDemand.getHeadId());
		Assert.assertEquals(
			existingCdsDemand.getDemandId(), newCdsDemand.getDemandId());
		Assert.assertEquals(
			existingCdsDemand.getTitle(), newCdsDemand.getTitle());
		Assert.assertEquals(
			existingCdsDemand.getDescription(), newCdsDemand.getDescription());
		Assert.assertEquals(
			existingCdsDemand.getType(), newCdsDemand.getType());
		Assert.assertEquals(
			existingCdsDemand.getPriority(), newCdsDemand.getPriority());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCdsDemand.getRequestedDelivery()),
			Time.getShortTimestamp(newCdsDemand.getRequestedDelivery()));
		Assert.assertEquals(
			existingCdsDemand.isIsGDPR(), newCdsDemand.isIsGDPR());
		Assert.assertEquals(
			existingCdsDemand.getGdprInfo(), newCdsDemand.getGdprInfo());
		Assert.assertEquals(
			existingCdsDemand.getFiveTracks(), newCdsDemand.getFiveTracks());
		Assert.assertEquals(
			existingCdsDemand.getRequestorId(), newCdsDemand.getRequestorId());
		Assert.assertEquals(
			existingCdsDemand.getRequestorName(),
			newCdsDemand.getRequestorName());
		Assert.assertEquals(
			existingCdsDemand.getRequestedForId(),
			newCdsDemand.getRequestedForId());
		Assert.assertEquals(
			existingCdsDemand.getRequestedForName(),
			newCdsDemand.getRequestedForName());
		Assert.assertEquals(
			existingCdsDemand.getContactId(), newCdsDemand.getContactId());
		Assert.assertEquals(
			existingCdsDemand.getContactName(), newCdsDemand.getContactName());
		Assert.assertEquals(
			existingCdsDemand.getDomainId(), newCdsDemand.getDomainId());
		Assert.assertEquals(
			existingCdsDemand.getDomainName(), newCdsDemand.getDomainName());
		Assert.assertEquals(
			existingCdsDemand.getBanId(), newCdsDemand.getBanId());
		Assert.assertEquals(
			existingCdsDemand.getBanName(), newCdsDemand.getBanName());
		Assert.assertEquals(
			existingCdsDemand.getSpocId(), newCdsDemand.getSpocId());
		Assert.assertEquals(
			existingCdsDemand.getSpocName(), newCdsDemand.getSpocName());
		Assert.assertEquals(
			existingCdsDemand.getUsReasoning(), newCdsDemand.getUsReasoning());
		Assert.assertEquals(
			existingCdsDemand.getUsFrequencyOut(),
			newCdsDemand.getUsFrequencyOut());
		Assert.assertEquals(
			existingCdsDemand.isUsAccessDPM(), newCdsDemand.isUsAccessDPM());
		Assert.assertEquals(
			existingCdsDemand.getUsFolderDPM(), newCdsDemand.getUsFolderDPM());
		Assert.assertEquals(
			existingCdsDemand.isUsCreateFolderDPM(),
			newCdsDemand.isUsCreateFolderDPM());
		Assert.assertEquals(
			existingCdsDemand.getUsGestorFolderDPMId(),
			newCdsDemand.getUsGestorFolderDPMId());
		Assert.assertEquals(
			existingCdsDemand.getUsGestorFolderDPMName(),
			newCdsDemand.getUsGestorFolderDPMName());
		Assert.assertEquals(
			existingCdsDemand.getUsDPMNotificationMail(),
			newCdsDemand.getUsDPMNotificationMail());
		Assert.assertEquals(
			existingCdsDemand.getBioeId(), newCdsDemand.getBioeId());
		Assert.assertEquals(
			existingCdsDemand.getBioeStateId(), newCdsDemand.getBioeStateId());
		Assert.assertEquals(
			existingCdsDemand.getBioeStateName(),
			newCdsDemand.getBioeStateName());
		AssertUtils.assertEquals(
			existingCdsDemand.getWorkEstimate(),
			newCdsDemand.getWorkEstimate());
		AssertUtils.assertEquals(
			existingCdsDemand.getAcceptedWorkEstimate(),
			newCdsDemand.getAcceptedWorkEstimate());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCdsDemand.getExpectedDelivery()),
			Time.getShortTimestamp(newCdsDemand.getExpectedDelivery()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCdsDemand.getAcceptedDelivery()),
			Time.getShortTimestamp(newCdsDemand.getAcceptedDelivery()));
		Assert.assertEquals(
			existingCdsDemand.getGroupId(), newCdsDemand.getGroupId());
		Assert.assertEquals(
			existingCdsDemand.getCompanyId(), newCdsDemand.getCompanyId());
		Assert.assertEquals(
			existingCdsDemand.getUserId(), newCdsDemand.getUserId());
		Assert.assertEquals(
			existingCdsDemand.getUserName(), newCdsDemand.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCdsDemand.getCreateDate()),
			Time.getShortTimestamp(newCdsDemand.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCdsDemand.getModifiedDate()),
			Time.getShortTimestamp(newCdsDemand.getModifiedDate()));
		Assert.assertEquals(
			existingCdsDemand.getUrlTitle(), newCdsDemand.getUrlTitle());
		Assert.assertEquals(
			existingCdsDemand.getState(), newCdsDemand.getState());
		Assert.assertEquals(
			existingCdsDemand.getStateByUserId(),
			newCdsDemand.getStateByUserId());
		Assert.assertEquals(
			existingCdsDemand.getStateByUserName(),
			newCdsDemand.getStateByUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCdsDemand.getStateDate()),
			Time.getShortTimestamp(newCdsDemand.getStateDate()));
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
	public void testCountByUserId() throws Exception {
		_persistence.countByUserId(RandomTestUtil.nextLong());

		_persistence.countByUserId(0L);
	}

	@Test
	public void testCountByUserId_Head() throws Exception {
		_persistence.countByUserId_Head(
			RandomTestUtil.nextLong(), RandomTestUtil.randomBoolean());

		_persistence.countByUserId_Head(0L, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByXid() throws Exception {
		_persistence.countByXid("");

		_persistence.countByXid("null");

		_persistence.countByXid((String)null);
	}

	@Test
	public void testCountByXid_Head() throws Exception {
		_persistence.countByXid_Head("", RandomTestUtil.randomBoolean());

		_persistence.countByXid_Head("null", RandomTestUtil.randomBoolean());

		_persistence.countByXid_Head(
			(String)null, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByDI() throws Exception {
		_persistence.countByDI(RandomTestUtil.nextLong());

		_persistence.countByDI(0L);
	}

	@Test
	public void testCountByDIArrayable() throws Exception {
		_persistence.countByDI(new long[] {RandomTestUtil.nextLong(), 0L});
	}

	@Test
	public void testCountByDI_Head() throws Exception {
		_persistence.countByDI_Head(
			RandomTestUtil.nextLong(), RandomTestUtil.randomBoolean());

		_persistence.countByDI_Head(0L, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByDI_HeadArrayable() throws Exception {
		_persistence.countByDI_Head(
			new long[] {RandomTestUtil.nextLong(), 0L},
			RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByHeadId() throws Exception {
		_persistence.countByHeadId(RandomTestUtil.nextLong());

		_persistence.countByHeadId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CdsDemand newCdsDemand = addCdsDemand();

		CdsDemand existingCdsDemand = _persistence.findByPrimaryKey(
			newCdsDemand.getPrimaryKey());

		Assert.assertEquals(existingCdsDemand, newCdsDemand);
	}

	@Test(expected = NoSuchCdsDemandException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<CdsDemand> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"CdsDemands_CdsDemand", "mvccVersion", true, "uuid", true, "headId",
			true, "demandId", true, "title", true, "description", true, "type",
			true, "priority", true, "requestedDelivery", true, "isGDPR", true,
			"gdprInfo", true, "fiveTracks", true, "requestorId", true,
			"requestorName", true, "requestedForId", true, "requestedForName",
			true, "contactId", true, "contactName", true, "domainId", true,
			"domainName", true, "banId", true, "banName", true, "spocId", true,
			"spocName", true, "usReasoning", true, "usFrequencyOut", true,
			"usAccessDPM", true, "usFolderDPM", true, "usCreateFolderDPM", true,
			"usGestorFolderDPMId", true, "usGestorFolderDPMName", true,
			"usDPMNotificationMail", true, "bioeId", true, "bioeStateId", true,
			"bioeStateName", true, "workEstimate", true, "acceptedWorkEstimate",
			true, "expectedDelivery", true, "acceptedDelivery", true, "groupId",
			true, "companyId", true, "userId", true, "userName", true,
			"createDate", true, "modifiedDate", true, "urlTitle", true, "state",
			true, "stateByUserId", true, "stateByUserName", true, "stateDate",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CdsDemand newCdsDemand = addCdsDemand();

		CdsDemand existingCdsDemand = _persistence.fetchByPrimaryKey(
			newCdsDemand.getPrimaryKey());

		Assert.assertEquals(existingCdsDemand, newCdsDemand);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CdsDemand missingCdsDemand = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCdsDemand);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		CdsDemand newCdsDemand1 = addCdsDemand();
		CdsDemand newCdsDemand2 = addCdsDemand();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCdsDemand1.getPrimaryKey());
		primaryKeys.add(newCdsDemand2.getPrimaryKey());

		Map<Serializable, CdsDemand> cdsDemands =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, cdsDemands.size());
		Assert.assertEquals(
			newCdsDemand1, cdsDemands.get(newCdsDemand1.getPrimaryKey()));
		Assert.assertEquals(
			newCdsDemand2, cdsDemands.get(newCdsDemand2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CdsDemand> cdsDemands =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(cdsDemands.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		CdsDemand newCdsDemand = addCdsDemand();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCdsDemand.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CdsDemand> cdsDemands =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, cdsDemands.size());
		Assert.assertEquals(
			newCdsDemand, cdsDemands.get(newCdsDemand.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CdsDemand> cdsDemands =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(cdsDemands.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		CdsDemand newCdsDemand = addCdsDemand();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCdsDemand.getPrimaryKey());

		Map<Serializable, CdsDemand> cdsDemands =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, cdsDemands.size());
		Assert.assertEquals(
			newCdsDemand, cdsDemands.get(newCdsDemand.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CdsDemandLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<CdsDemand>() {

				@Override
				public void performAction(CdsDemand cdsDemand) {
					Assert.assertNotNull(cdsDemand);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		CdsDemand newCdsDemand = addCdsDemand();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CdsDemand.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("demandId", newCdsDemand.getDemandId()));

		List<CdsDemand> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		CdsDemand existingCdsDemand = result.get(0);

		Assert.assertEquals(existingCdsDemand, newCdsDemand);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CdsDemand.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("demandId", RandomTestUtil.nextLong()));

		List<CdsDemand> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		CdsDemand newCdsDemand = addCdsDemand();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CdsDemand.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("demandId"));

		Object newDemandId = newCdsDemand.getDemandId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("demandId", new Object[] {newDemandId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingDemandId = result.get(0);

		Assert.assertEquals(existingDemandId, newDemandId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CdsDemand.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("demandId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"demandId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		CdsDemand newCdsDemand = addCdsDemand();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newCdsDemand.getPrimaryKey()));
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

		CdsDemand newCdsDemand = addCdsDemand();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CdsDemand.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("demandId", newCdsDemand.getDemandId()));

		List<CdsDemand> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(CdsDemand cdsDemand) {
		Assert.assertEquals(
			cdsDemand.getUuid(),
			ReflectionTestUtil.invoke(
				cdsDemand, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(cdsDemand.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				cdsDemand, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));

		Assert.assertEquals(
			cdsDemand.getUuid(),
			ReflectionTestUtil.invoke(
				cdsDemand, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));

		Assert.assertEquals(
			Long.valueOf(cdsDemand.getHeadId()),
			ReflectionTestUtil.<Long>invoke(
				cdsDemand, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "headId"));
	}

	protected CdsDemand addCdsDemand() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CdsDemand cdsDemand = _persistence.create(pk);

		cdsDemand.setMvccVersion(RandomTestUtil.nextLong());

		cdsDemand.setUuid(RandomTestUtil.randomString());

		cdsDemand.setHeadId(RandomTestUtil.nextLong());

		cdsDemand.setTitle(RandomTestUtil.randomString());

		cdsDemand.setDescription(RandomTestUtil.randomString());

		cdsDemand.setType(RandomTestUtil.nextInt());

		cdsDemand.setPriority(RandomTestUtil.nextInt());

		cdsDemand.setRequestedDelivery(RandomTestUtil.nextDate());

		cdsDemand.setIsGDPR(RandomTestUtil.randomBoolean());

		cdsDemand.setGdprInfo(RandomTestUtil.randomString());

		cdsDemand.setFiveTracks(RandomTestUtil.randomString());

		cdsDemand.setRequestorId(RandomTestUtil.nextLong());

		cdsDemand.setRequestorName(RandomTestUtil.randomString());

		cdsDemand.setRequestedForId(RandomTestUtil.nextLong());

		cdsDemand.setRequestedForName(RandomTestUtil.randomString());

		cdsDemand.setContactId(RandomTestUtil.nextLong());

		cdsDemand.setContactName(RandomTestUtil.randomString());

		cdsDemand.setDomainId(RandomTestUtil.nextLong());

		cdsDemand.setDomainName(RandomTestUtil.randomString());

		cdsDemand.setBanId(RandomTestUtil.nextLong());

		cdsDemand.setBanName(RandomTestUtil.randomString());

		cdsDemand.setSpocId(RandomTestUtil.nextLong());

		cdsDemand.setSpocName(RandomTestUtil.randomString());

		cdsDemand.setUsReasoning(RandomTestUtil.randomString());

		cdsDemand.setUsFrequencyOut(RandomTestUtil.nextInt());

		cdsDemand.setUsAccessDPM(RandomTestUtil.randomBoolean());

		cdsDemand.setUsFolderDPM(RandomTestUtil.randomString());

		cdsDemand.setUsCreateFolderDPM(RandomTestUtil.randomBoolean());

		cdsDemand.setUsGestorFolderDPMId(RandomTestUtil.nextLong());

		cdsDemand.setUsGestorFolderDPMName(RandomTestUtil.randomString());

		cdsDemand.setUsDPMNotificationMail(RandomTestUtil.randomString());

		cdsDemand.setBioeId(RandomTestUtil.randomString());

		cdsDemand.setBioeStateId();

		cdsDemand.setBioeStateName(RandomTestUtil.randomString());

		cdsDemand.setWorkEstimate(RandomTestUtil.nextDouble());

		cdsDemand.setAcceptedWorkEstimate(RandomTestUtil.nextDouble());

		cdsDemand.setExpectedDelivery(RandomTestUtil.nextDate());

		cdsDemand.setAcceptedDelivery(RandomTestUtil.nextDate());

		cdsDemand.setGroupId(RandomTestUtil.nextLong());

		cdsDemand.setCompanyId(RandomTestUtil.nextLong());

		cdsDemand.setUserId(RandomTestUtil.nextLong());

		cdsDemand.setUserName(RandomTestUtil.randomString());

		cdsDemand.setCreateDate(RandomTestUtil.nextDate());

		cdsDemand.setModifiedDate(RandomTestUtil.nextDate());

		cdsDemand.setUrlTitle(RandomTestUtil.randomString());

		cdsDemand.setState(RandomTestUtil.randomString());

		cdsDemand.setStateByUserId(RandomTestUtil.nextLong());

		cdsDemand.setStateByUserName(RandomTestUtil.randomString());

		cdsDemand.setStateDate(RandomTestUtil.nextDate());

		_cdsDemands.add(_persistence.update(cdsDemand));

		return cdsDemand;
	}

	private List<CdsDemand> _cdsDemands = new ArrayList<CdsDemand>();
	private CdsDemandPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}