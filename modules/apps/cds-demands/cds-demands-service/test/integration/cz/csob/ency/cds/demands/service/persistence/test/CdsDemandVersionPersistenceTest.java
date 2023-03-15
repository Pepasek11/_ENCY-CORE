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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import cz.csob.ency.cds.demands.exception.NoSuchCdsDemandVersionException;
import cz.csob.ency.cds.demands.model.CdsDemandVersion;
import cz.csob.ency.cds.demands.service.persistence.CdsDemandVersionPersistence;
import cz.csob.ency.cds.demands.service.persistence.CdsDemandVersionUtil;

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
public class CdsDemandVersionPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "cz.csob.ency.cds.demands.service"));

	@Before
	public void setUp() {
		_persistence = CdsDemandVersionUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CdsDemandVersion> iterator = _cdsDemandVersions.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CdsDemandVersion cdsDemandVersion = _persistence.create(pk);

		Assert.assertNotNull(cdsDemandVersion);

		Assert.assertEquals(cdsDemandVersion.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CdsDemandVersion newCdsDemandVersion = addCdsDemandVersion();

		_persistence.remove(newCdsDemandVersion);

		CdsDemandVersion existingCdsDemandVersion =
			_persistence.fetchByPrimaryKey(newCdsDemandVersion.getPrimaryKey());

		Assert.assertNull(existingCdsDemandVersion);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCdsDemandVersion();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CdsDemandVersion newCdsDemandVersion = _persistence.create(pk);

		newCdsDemandVersion.setVersion(RandomTestUtil.nextInt());

		newCdsDemandVersion.setUuid(RandomTestUtil.randomString());

		newCdsDemandVersion.setDemandId(RandomTestUtil.nextLong());

		newCdsDemandVersion.setTitle(RandomTestUtil.randomString());

		newCdsDemandVersion.setDescription(RandomTestUtil.randomString());

		newCdsDemandVersion.setType(RandomTestUtil.nextInt());

		newCdsDemandVersion.setPriority(RandomTestUtil.nextInt());

		newCdsDemandVersion.setRequestedDelivery(RandomTestUtil.nextDate());

		newCdsDemandVersion.setIsGDPR(RandomTestUtil.randomBoolean());

		newCdsDemandVersion.setGdprInfo(RandomTestUtil.randomString());

		newCdsDemandVersion.setFiveTracks(RandomTestUtil.randomString());

		newCdsDemandVersion.setRequestorId(RandomTestUtil.nextLong());

		newCdsDemandVersion.setRequestorName(RandomTestUtil.randomString());

		newCdsDemandVersion.setRequestedForId(RandomTestUtil.nextLong());

		newCdsDemandVersion.setRequestedForName(RandomTestUtil.randomString());

		newCdsDemandVersion.setContactId(RandomTestUtil.nextLong());

		newCdsDemandVersion.setContactName(RandomTestUtil.randomString());

		newCdsDemandVersion.setDomainId(RandomTestUtil.nextLong());

		newCdsDemandVersion.setDomainName(RandomTestUtil.randomString());

		newCdsDemandVersion.setBanId(RandomTestUtil.nextLong());

		newCdsDemandVersion.setBanName(RandomTestUtil.randomString());

		newCdsDemandVersion.setSpocId(RandomTestUtil.nextLong());

		newCdsDemandVersion.setSpocName(RandomTestUtil.randomString());

		newCdsDemandVersion.setUsReasoning(RandomTestUtil.randomString());

		newCdsDemandVersion.setUsFrequencyOut(RandomTestUtil.nextInt());

		newCdsDemandVersion.setUsAccessDPM(RandomTestUtil.randomBoolean());

		newCdsDemandVersion.setUsFolderDPM(RandomTestUtil.randomString());

		newCdsDemandVersion.setUsCreateFolderDPM(
			RandomTestUtil.randomBoolean());

		newCdsDemandVersion.setUsGestorFolderDPMId(RandomTestUtil.nextLong());

		newCdsDemandVersion.setUsGestorFolderDPMName(
			RandomTestUtil.randomString());

		newCdsDemandVersion.setUsDPMNotificationMail(
			RandomTestUtil.randomString());

		newCdsDemandVersion.setBioeId(RandomTestUtil.randomString());

		newCdsDemandVersion.setBioeStateId();

		newCdsDemandVersion.setBioeStateName(RandomTestUtil.randomString());

		newCdsDemandVersion.setWorkEstimate(RandomTestUtil.nextDouble());

		newCdsDemandVersion.setAcceptedWorkEstimate(
			RandomTestUtil.nextDouble());

		newCdsDemandVersion.setExpectedDelivery(RandomTestUtil.nextDate());

		newCdsDemandVersion.setAcceptedDelivery(RandomTestUtil.nextDate());

		newCdsDemandVersion.setGroupId(RandomTestUtil.nextLong());

		newCdsDemandVersion.setCompanyId(RandomTestUtil.nextLong());

		newCdsDemandVersion.setUserId(RandomTestUtil.nextLong());

		newCdsDemandVersion.setUserName(RandomTestUtil.randomString());

		newCdsDemandVersion.setCreateDate(RandomTestUtil.nextDate());

		newCdsDemandVersion.setModifiedDate(RandomTestUtil.nextDate());

		newCdsDemandVersion.setUrlTitle(RandomTestUtil.randomString());

		newCdsDemandVersion.setState(RandomTestUtil.randomString());

		newCdsDemandVersion.setStateByUserId(RandomTestUtil.nextLong());

		newCdsDemandVersion.setStateByUserName(RandomTestUtil.randomString());

		newCdsDemandVersion.setStateDate(RandomTestUtil.nextDate());

		_cdsDemandVersions.add(_persistence.update(newCdsDemandVersion));

		CdsDemandVersion existingCdsDemandVersion =
			_persistence.findByPrimaryKey(newCdsDemandVersion.getPrimaryKey());

		Assert.assertEquals(
			existingCdsDemandVersion.getCdsDemandVersionId(),
			newCdsDemandVersion.getCdsDemandVersionId());
		Assert.assertEquals(
			existingCdsDemandVersion.getVersion(),
			newCdsDemandVersion.getVersion());
		Assert.assertEquals(
			existingCdsDemandVersion.getUuid(), newCdsDemandVersion.getUuid());
		Assert.assertEquals(
			existingCdsDemandVersion.getDemandId(),
			newCdsDemandVersion.getDemandId());
		Assert.assertEquals(
			existingCdsDemandVersion.getTitle(),
			newCdsDemandVersion.getTitle());
		Assert.assertEquals(
			existingCdsDemandVersion.getDescription(),
			newCdsDemandVersion.getDescription());
		Assert.assertEquals(
			existingCdsDemandVersion.getType(), newCdsDemandVersion.getType());
		Assert.assertEquals(
			existingCdsDemandVersion.getPriority(),
			newCdsDemandVersion.getPriority());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingCdsDemandVersion.getRequestedDelivery()),
			Time.getShortTimestamp(newCdsDemandVersion.getRequestedDelivery()));
		Assert.assertEquals(
			existingCdsDemandVersion.isIsGDPR(),
			newCdsDemandVersion.isIsGDPR());
		Assert.assertEquals(
			existingCdsDemandVersion.getGdprInfo(),
			newCdsDemandVersion.getGdprInfo());
		Assert.assertEquals(
			existingCdsDemandVersion.getFiveTracks(),
			newCdsDemandVersion.getFiveTracks());
		Assert.assertEquals(
			existingCdsDemandVersion.getRequestorId(),
			newCdsDemandVersion.getRequestorId());
		Assert.assertEquals(
			existingCdsDemandVersion.getRequestorName(),
			newCdsDemandVersion.getRequestorName());
		Assert.assertEquals(
			existingCdsDemandVersion.getRequestedForId(),
			newCdsDemandVersion.getRequestedForId());
		Assert.assertEquals(
			existingCdsDemandVersion.getRequestedForName(),
			newCdsDemandVersion.getRequestedForName());
		Assert.assertEquals(
			existingCdsDemandVersion.getContactId(),
			newCdsDemandVersion.getContactId());
		Assert.assertEquals(
			existingCdsDemandVersion.getContactName(),
			newCdsDemandVersion.getContactName());
		Assert.assertEquals(
			existingCdsDemandVersion.getDomainId(),
			newCdsDemandVersion.getDomainId());
		Assert.assertEquals(
			existingCdsDemandVersion.getDomainName(),
			newCdsDemandVersion.getDomainName());
		Assert.assertEquals(
			existingCdsDemandVersion.getBanId(),
			newCdsDemandVersion.getBanId());
		Assert.assertEquals(
			existingCdsDemandVersion.getBanName(),
			newCdsDemandVersion.getBanName());
		Assert.assertEquals(
			existingCdsDemandVersion.getSpocId(),
			newCdsDemandVersion.getSpocId());
		Assert.assertEquals(
			existingCdsDemandVersion.getSpocName(),
			newCdsDemandVersion.getSpocName());
		Assert.assertEquals(
			existingCdsDemandVersion.getUsReasoning(),
			newCdsDemandVersion.getUsReasoning());
		Assert.assertEquals(
			existingCdsDemandVersion.getUsFrequencyOut(),
			newCdsDemandVersion.getUsFrequencyOut());
		Assert.assertEquals(
			existingCdsDemandVersion.isUsAccessDPM(),
			newCdsDemandVersion.isUsAccessDPM());
		Assert.assertEquals(
			existingCdsDemandVersion.getUsFolderDPM(),
			newCdsDemandVersion.getUsFolderDPM());
		Assert.assertEquals(
			existingCdsDemandVersion.isUsCreateFolderDPM(),
			newCdsDemandVersion.isUsCreateFolderDPM());
		Assert.assertEquals(
			existingCdsDemandVersion.getUsGestorFolderDPMId(),
			newCdsDemandVersion.getUsGestorFolderDPMId());
		Assert.assertEquals(
			existingCdsDemandVersion.getUsGestorFolderDPMName(),
			newCdsDemandVersion.getUsGestorFolderDPMName());
		Assert.assertEquals(
			existingCdsDemandVersion.getUsDPMNotificationMail(),
			newCdsDemandVersion.getUsDPMNotificationMail());
		Assert.assertEquals(
			existingCdsDemandVersion.getBioeId(),
			newCdsDemandVersion.getBioeId());
		Assert.assertEquals(
			existingCdsDemandVersion.getBioeStateId(),
			newCdsDemandVersion.getBioeStateId());
		Assert.assertEquals(
			existingCdsDemandVersion.getBioeStateName(),
			newCdsDemandVersion.getBioeStateName());
		AssertUtils.assertEquals(
			existingCdsDemandVersion.getWorkEstimate(),
			newCdsDemandVersion.getWorkEstimate());
		AssertUtils.assertEquals(
			existingCdsDemandVersion.getAcceptedWorkEstimate(),
			newCdsDemandVersion.getAcceptedWorkEstimate());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingCdsDemandVersion.getExpectedDelivery()),
			Time.getShortTimestamp(newCdsDemandVersion.getExpectedDelivery()));
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingCdsDemandVersion.getAcceptedDelivery()),
			Time.getShortTimestamp(newCdsDemandVersion.getAcceptedDelivery()));
		Assert.assertEquals(
			existingCdsDemandVersion.getGroupId(),
			newCdsDemandVersion.getGroupId());
		Assert.assertEquals(
			existingCdsDemandVersion.getCompanyId(),
			newCdsDemandVersion.getCompanyId());
		Assert.assertEquals(
			existingCdsDemandVersion.getUserId(),
			newCdsDemandVersion.getUserId());
		Assert.assertEquals(
			existingCdsDemandVersion.getUserName(),
			newCdsDemandVersion.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCdsDemandVersion.getCreateDate()),
			Time.getShortTimestamp(newCdsDemandVersion.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCdsDemandVersion.getModifiedDate()),
			Time.getShortTimestamp(newCdsDemandVersion.getModifiedDate()));
		Assert.assertEquals(
			existingCdsDemandVersion.getUrlTitle(),
			newCdsDemandVersion.getUrlTitle());
		Assert.assertEquals(
			existingCdsDemandVersion.getState(),
			newCdsDemandVersion.getState());
		Assert.assertEquals(
			existingCdsDemandVersion.getStateByUserId(),
			newCdsDemandVersion.getStateByUserId());
		Assert.assertEquals(
			existingCdsDemandVersion.getStateByUserName(),
			newCdsDemandVersion.getStateByUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCdsDemandVersion.getStateDate()),
			Time.getShortTimestamp(newCdsDemandVersion.getStateDate()));
	}

	@Test
	public void testCountByDemandId() throws Exception {
		_persistence.countByDemandId(RandomTestUtil.nextLong());

		_persistence.countByDemandId(0L);
	}

	@Test
	public void testCountByDemandId_Version() throws Exception {
		_persistence.countByDemandId_Version(
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByDemandId_Version(0L, 0);
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
	public void testCountByUserId() throws Exception {
		_persistence.countByUserId(RandomTestUtil.nextLong());

		_persistence.countByUserId(0L);
	}

	@Test
	public void testCountByUserId_Version() throws Exception {
		_persistence.countByUserId_Version(
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByUserId_Version(0L, 0);
	}

	@Test
	public void testCountByXid() throws Exception {
		_persistence.countByXid("");

		_persistence.countByXid("null");

		_persistence.countByXid((String)null);
	}

	@Test
	public void testCountByXid_Version() throws Exception {
		_persistence.countByXid_Version("", RandomTestUtil.nextInt());

		_persistence.countByXid_Version("null", 0);

		_persistence.countByXid_Version((String)null, 0);
	}

	@Test
	public void testCountByDI() throws Exception {
		_persistence.countByDI(RandomTestUtil.nextLong());

		_persistence.countByDI(0L);
	}

	@Test
	public void testCountByDI_Version() throws Exception {
		_persistence.countByDI_Version(
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByDI_Version(0L, 0);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CdsDemandVersion newCdsDemandVersion = addCdsDemandVersion();

		CdsDemandVersion existingCdsDemandVersion =
			_persistence.findByPrimaryKey(newCdsDemandVersion.getPrimaryKey());

		Assert.assertEquals(existingCdsDemandVersion, newCdsDemandVersion);
	}

	@Test(expected = NoSuchCdsDemandVersionException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<CdsDemandVersion> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"CdsDemands_CdsDemandVersion", "cdsDemandVersionId", true,
			"version", true, "uuid", true, "demandId", true, "title", true,
			"description", true, "type", true, "priority", true,
			"requestedDelivery", true, "isGDPR", true, "gdprInfo", true,
			"fiveTracks", true, "requestorId", true, "requestorName", true,
			"requestedForId", true, "requestedForName", true, "contactId", true,
			"contactName", true, "domainId", true, "domainName", true, "banId",
			true, "banName", true, "spocId", true, "spocName", true,
			"usReasoning", true, "usFrequencyOut", true, "usAccessDPM", true,
			"usFolderDPM", true, "usCreateFolderDPM", true,
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
		CdsDemandVersion newCdsDemandVersion = addCdsDemandVersion();

		CdsDemandVersion existingCdsDemandVersion =
			_persistence.fetchByPrimaryKey(newCdsDemandVersion.getPrimaryKey());

		Assert.assertEquals(existingCdsDemandVersion, newCdsDemandVersion);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CdsDemandVersion missingCdsDemandVersion =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCdsDemandVersion);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		CdsDemandVersion newCdsDemandVersion1 = addCdsDemandVersion();
		CdsDemandVersion newCdsDemandVersion2 = addCdsDemandVersion();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCdsDemandVersion1.getPrimaryKey());
		primaryKeys.add(newCdsDemandVersion2.getPrimaryKey());

		Map<Serializable, CdsDemandVersion> cdsDemandVersions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, cdsDemandVersions.size());
		Assert.assertEquals(
			newCdsDemandVersion1,
			cdsDemandVersions.get(newCdsDemandVersion1.getPrimaryKey()));
		Assert.assertEquals(
			newCdsDemandVersion2,
			cdsDemandVersions.get(newCdsDemandVersion2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CdsDemandVersion> cdsDemandVersions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(cdsDemandVersions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		CdsDemandVersion newCdsDemandVersion = addCdsDemandVersion();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCdsDemandVersion.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CdsDemandVersion> cdsDemandVersions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, cdsDemandVersions.size());
		Assert.assertEquals(
			newCdsDemandVersion,
			cdsDemandVersions.get(newCdsDemandVersion.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CdsDemandVersion> cdsDemandVersions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(cdsDemandVersions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		CdsDemandVersion newCdsDemandVersion = addCdsDemandVersion();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCdsDemandVersion.getPrimaryKey());

		Map<Serializable, CdsDemandVersion> cdsDemandVersions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, cdsDemandVersions.size());
		Assert.assertEquals(
			newCdsDemandVersion,
			cdsDemandVersions.get(newCdsDemandVersion.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		CdsDemandVersion newCdsDemandVersion = addCdsDemandVersion();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CdsDemandVersion.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"cdsDemandVersionId",
				newCdsDemandVersion.getCdsDemandVersionId()));

		List<CdsDemandVersion> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		CdsDemandVersion existingCdsDemandVersion = result.get(0);

		Assert.assertEquals(existingCdsDemandVersion, newCdsDemandVersion);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CdsDemandVersion.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"cdsDemandVersionId", RandomTestUtil.nextLong()));

		List<CdsDemandVersion> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		CdsDemandVersion newCdsDemandVersion = addCdsDemandVersion();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CdsDemandVersion.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("cdsDemandVersionId"));

		Object newCdsDemandVersionId =
			newCdsDemandVersion.getCdsDemandVersionId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"cdsDemandVersionId", new Object[] {newCdsDemandVersionId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCdsDemandVersionId = result.get(0);

		Assert.assertEquals(existingCdsDemandVersionId, newCdsDemandVersionId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CdsDemandVersion.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("cdsDemandVersionId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"cdsDemandVersionId",
				new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		CdsDemandVersion newCdsDemandVersion = addCdsDemandVersion();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newCdsDemandVersion.getPrimaryKey()));
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

		CdsDemandVersion newCdsDemandVersion = addCdsDemandVersion();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CdsDemandVersion.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"cdsDemandVersionId",
				newCdsDemandVersion.getCdsDemandVersionId()));

		List<CdsDemandVersion> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(CdsDemandVersion cdsDemandVersion) {
		Assert.assertEquals(
			Long.valueOf(cdsDemandVersion.getDemandId()),
			ReflectionTestUtil.<Long>invoke(
				cdsDemandVersion, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "demandId"));
		Assert.assertEquals(
			Integer.valueOf(cdsDemandVersion.getVersion()),
			ReflectionTestUtil.<Integer>invoke(
				cdsDemandVersion, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "version"));

		Assert.assertEquals(
			cdsDemandVersion.getUuid(),
			ReflectionTestUtil.invoke(
				cdsDemandVersion, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(cdsDemandVersion.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				cdsDemandVersion, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
		Assert.assertEquals(
			Integer.valueOf(cdsDemandVersion.getVersion()),
			ReflectionTestUtil.<Integer>invoke(
				cdsDemandVersion, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "version"));

		Assert.assertEquals(
			cdsDemandVersion.getUuid(),
			ReflectionTestUtil.invoke(
				cdsDemandVersion, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Integer.valueOf(cdsDemandVersion.getVersion()),
			ReflectionTestUtil.<Integer>invoke(
				cdsDemandVersion, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "version"));
	}

	protected CdsDemandVersion addCdsDemandVersion() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CdsDemandVersion cdsDemandVersion = _persistence.create(pk);

		cdsDemandVersion.setVersion(RandomTestUtil.nextInt());

		cdsDemandVersion.setUuid(RandomTestUtil.randomString());

		cdsDemandVersion.setDemandId(RandomTestUtil.nextLong());

		cdsDemandVersion.setTitle(RandomTestUtil.randomString());

		cdsDemandVersion.setDescription(RandomTestUtil.randomString());

		cdsDemandVersion.setType(RandomTestUtil.nextInt());

		cdsDemandVersion.setPriority(RandomTestUtil.nextInt());

		cdsDemandVersion.setRequestedDelivery(RandomTestUtil.nextDate());

		cdsDemandVersion.setIsGDPR(RandomTestUtil.randomBoolean());

		cdsDemandVersion.setGdprInfo(RandomTestUtil.randomString());

		cdsDemandVersion.setFiveTracks(RandomTestUtil.randomString());

		cdsDemandVersion.setRequestorId(RandomTestUtil.nextLong());

		cdsDemandVersion.setRequestorName(RandomTestUtil.randomString());

		cdsDemandVersion.setRequestedForId(RandomTestUtil.nextLong());

		cdsDemandVersion.setRequestedForName(RandomTestUtil.randomString());

		cdsDemandVersion.setContactId(RandomTestUtil.nextLong());

		cdsDemandVersion.setContactName(RandomTestUtil.randomString());

		cdsDemandVersion.setDomainId(RandomTestUtil.nextLong());

		cdsDemandVersion.setDomainName(RandomTestUtil.randomString());

		cdsDemandVersion.setBanId(RandomTestUtil.nextLong());

		cdsDemandVersion.setBanName(RandomTestUtil.randomString());

		cdsDemandVersion.setSpocId(RandomTestUtil.nextLong());

		cdsDemandVersion.setSpocName(RandomTestUtil.randomString());

		cdsDemandVersion.setUsReasoning(RandomTestUtil.randomString());

		cdsDemandVersion.setUsFrequencyOut(RandomTestUtil.nextInt());

		cdsDemandVersion.setUsAccessDPM(RandomTestUtil.randomBoolean());

		cdsDemandVersion.setUsFolderDPM(RandomTestUtil.randomString());

		cdsDemandVersion.setUsCreateFolderDPM(RandomTestUtil.randomBoolean());

		cdsDemandVersion.setUsGestorFolderDPMId(RandomTestUtil.nextLong());

		cdsDemandVersion.setUsGestorFolderDPMName(
			RandomTestUtil.randomString());

		cdsDemandVersion.setUsDPMNotificationMail(
			RandomTestUtil.randomString());

		cdsDemandVersion.setBioeId(RandomTestUtil.randomString());

		cdsDemandVersion.setBioeStateId();

		cdsDemandVersion.setBioeStateName(RandomTestUtil.randomString());

		cdsDemandVersion.setWorkEstimate(RandomTestUtil.nextDouble());

		cdsDemandVersion.setAcceptedWorkEstimate(RandomTestUtil.nextDouble());

		cdsDemandVersion.setExpectedDelivery(RandomTestUtil.nextDate());

		cdsDemandVersion.setAcceptedDelivery(RandomTestUtil.nextDate());

		cdsDemandVersion.setGroupId(RandomTestUtil.nextLong());

		cdsDemandVersion.setCompanyId(RandomTestUtil.nextLong());

		cdsDemandVersion.setUserId(RandomTestUtil.nextLong());

		cdsDemandVersion.setUserName(RandomTestUtil.randomString());

		cdsDemandVersion.setCreateDate(RandomTestUtil.nextDate());

		cdsDemandVersion.setModifiedDate(RandomTestUtil.nextDate());

		cdsDemandVersion.setUrlTitle(RandomTestUtil.randomString());

		cdsDemandVersion.setState(RandomTestUtil.randomString());

		cdsDemandVersion.setStateByUserId(RandomTestUtil.nextLong());

		cdsDemandVersion.setStateByUserName(RandomTestUtil.randomString());

		cdsDemandVersion.setStateDate(RandomTestUtil.nextDate());

		_cdsDemandVersions.add(_persistence.update(cdsDemandVersion));

		return cdsDemandVersion;
	}

	private List<CdsDemandVersion> _cdsDemandVersions =
		new ArrayList<CdsDemandVersion>();
	private CdsDemandVersionPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}