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

package cz.csob.ency.pdr.service.persistence.test;

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

import cz.csob.ency.pdr.exception.NoSuchPDRMappingException;
import cz.csob.ency.pdr.model.PDRMapping;
import cz.csob.ency.pdr.service.PDRMappingLocalServiceUtil;
import cz.csob.ency.pdr.service.persistence.PDRMappingPersistence;
import cz.csob.ency.pdr.service.persistence.PDRMappingUtil;

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
public class PDRMappingPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "cz.csob.ency.pdr.service"));

	@Before
	public void setUp() {
		_persistence = PDRMappingUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<PDRMapping> iterator = _pdrMappings.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PDRMapping pdrMapping = _persistence.create(pk);

		Assert.assertNotNull(pdrMapping);

		Assert.assertEquals(pdrMapping.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		PDRMapping newPDRMapping = addPDRMapping();

		_persistence.remove(newPDRMapping);

		PDRMapping existingPDRMapping = _persistence.fetchByPrimaryKey(
			newPDRMapping.getPrimaryKey());

		Assert.assertNull(existingPDRMapping);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addPDRMapping();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PDRMapping newPDRMapping = _persistence.create(pk);

		newPDRMapping.setMvccVersion(RandomTestUtil.nextLong());

		newPDRMapping.setTitle(RandomTestUtil.randomString());

		newPDRMapping.setSystemId(RandomTestUtil.nextLong());

		newPDRMapping.setTableId(RandomTestUtil.nextLong());

		newPDRMapping.setColumnId(RandomTestUtil.nextLong());

		newPDRMapping.setAttributeId(RandomTestUtil.nextLong());

		newPDRMapping.setMappingRules(RandomTestUtil.randomString());

		newPDRMapping.setGroupId(RandomTestUtil.nextLong());

		newPDRMapping.setCompanyId(RandomTestUtil.nextLong());

		newPDRMapping.setUserId(RandomTestUtil.nextLong());

		newPDRMapping.setUserName(RandomTestUtil.randomString());

		newPDRMapping.setCreateDate(RandomTestUtil.nextDate());

		newPDRMapping.setModifiedDate(RandomTestUtil.nextDate());

		newPDRMapping.setState(RandomTestUtil.randomString());

		newPDRMapping.setStateByUserId(RandomTestUtil.nextLong());

		newPDRMapping.setStateByUserName(RandomTestUtil.randomString());

		newPDRMapping.setStateDate(RandomTestUtil.nextDate());

		_pdrMappings.add(_persistence.update(newPDRMapping));

		PDRMapping existingPDRMapping = _persistence.findByPrimaryKey(
			newPDRMapping.getPrimaryKey());

		Assert.assertEquals(
			existingPDRMapping.getMvccVersion(),
			newPDRMapping.getMvccVersion());
		Assert.assertEquals(
			existingPDRMapping.getMappingId(), newPDRMapping.getMappingId());
		Assert.assertEquals(
			existingPDRMapping.getTitle(), newPDRMapping.getTitle());
		Assert.assertEquals(
			existingPDRMapping.getSystemId(), newPDRMapping.getSystemId());
		Assert.assertEquals(
			existingPDRMapping.getTableId(), newPDRMapping.getTableId());
		Assert.assertEquals(
			existingPDRMapping.getColumnId(), newPDRMapping.getColumnId());
		Assert.assertEquals(
			existingPDRMapping.getAttributeId(),
			newPDRMapping.getAttributeId());
		Assert.assertEquals(
			existingPDRMapping.getMappingRules(),
			newPDRMapping.getMappingRules());
		Assert.assertEquals(
			existingPDRMapping.getGroupId(), newPDRMapping.getGroupId());
		Assert.assertEquals(
			existingPDRMapping.getCompanyId(), newPDRMapping.getCompanyId());
		Assert.assertEquals(
			existingPDRMapping.getUserId(), newPDRMapping.getUserId());
		Assert.assertEquals(
			existingPDRMapping.getUserName(), newPDRMapping.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingPDRMapping.getCreateDate()),
			Time.getShortTimestamp(newPDRMapping.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingPDRMapping.getModifiedDate()),
			Time.getShortTimestamp(newPDRMapping.getModifiedDate()));
		Assert.assertEquals(
			existingPDRMapping.getState(), newPDRMapping.getState());
		Assert.assertEquals(
			existingPDRMapping.getStateByUserId(),
			newPDRMapping.getStateByUserId());
		Assert.assertEquals(
			existingPDRMapping.getStateByUserName(),
			newPDRMapping.getStateByUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingPDRMapping.getStateDate()),
			Time.getShortTimestamp(newPDRMapping.getStateDate()));
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		PDRMapping newPDRMapping = addPDRMapping();

		PDRMapping existingPDRMapping = _persistence.findByPrimaryKey(
			newPDRMapping.getPrimaryKey());

		Assert.assertEquals(existingPDRMapping, newPDRMapping);
	}

	@Test(expected = NoSuchPDRMappingException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<PDRMapping> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"pdr_mapping", "mvccVersion", true, "mappingId", true, "title",
			true, "systemId", true, "tableId", true, "columnId", true,
			"attributeId", true, "mappingRules", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "state", true, "stateByUserId", true,
			"stateByUserName", true, "stateDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		PDRMapping newPDRMapping = addPDRMapping();

		PDRMapping existingPDRMapping = _persistence.fetchByPrimaryKey(
			newPDRMapping.getPrimaryKey());

		Assert.assertEquals(existingPDRMapping, newPDRMapping);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PDRMapping missingPDRMapping = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingPDRMapping);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		PDRMapping newPDRMapping1 = addPDRMapping();
		PDRMapping newPDRMapping2 = addPDRMapping();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPDRMapping1.getPrimaryKey());
		primaryKeys.add(newPDRMapping2.getPrimaryKey());

		Map<Serializable, PDRMapping> pdrMappings =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, pdrMappings.size());
		Assert.assertEquals(
			newPDRMapping1, pdrMappings.get(newPDRMapping1.getPrimaryKey()));
		Assert.assertEquals(
			newPDRMapping2, pdrMappings.get(newPDRMapping2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, PDRMapping> pdrMappings =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(pdrMappings.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		PDRMapping newPDRMapping = addPDRMapping();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPDRMapping.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, PDRMapping> pdrMappings =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, pdrMappings.size());
		Assert.assertEquals(
			newPDRMapping, pdrMappings.get(newPDRMapping.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, PDRMapping> pdrMappings =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(pdrMappings.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		PDRMapping newPDRMapping = addPDRMapping();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPDRMapping.getPrimaryKey());

		Map<Serializable, PDRMapping> pdrMappings =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, pdrMappings.size());
		Assert.assertEquals(
			newPDRMapping, pdrMappings.get(newPDRMapping.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			PDRMappingLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<PDRMapping>() {

				@Override
				public void performAction(PDRMapping pdrMapping) {
					Assert.assertNotNull(pdrMapping);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		PDRMapping newPDRMapping = addPDRMapping();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PDRMapping.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"mappingId", newPDRMapping.getMappingId()));

		List<PDRMapping> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		PDRMapping existingPDRMapping = result.get(0);

		Assert.assertEquals(existingPDRMapping, newPDRMapping);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PDRMapping.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("mappingId", RandomTestUtil.nextLong()));

		List<PDRMapping> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		PDRMapping newPDRMapping = addPDRMapping();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PDRMapping.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("mappingId"));

		Object newMappingId = newPDRMapping.getMappingId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"mappingId", new Object[] {newMappingId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingMappingId = result.get(0);

		Assert.assertEquals(existingMappingId, newMappingId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PDRMapping.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("mappingId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"mappingId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected PDRMapping addPDRMapping() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PDRMapping pdrMapping = _persistence.create(pk);

		pdrMapping.setMvccVersion(RandomTestUtil.nextLong());

		pdrMapping.setTitle(RandomTestUtil.randomString());

		pdrMapping.setSystemId(RandomTestUtil.nextLong());

		pdrMapping.setTableId(RandomTestUtil.nextLong());

		pdrMapping.setColumnId(RandomTestUtil.nextLong());

		pdrMapping.setAttributeId(RandomTestUtil.nextLong());

		pdrMapping.setMappingRules(RandomTestUtil.randomString());

		pdrMapping.setGroupId(RandomTestUtil.nextLong());

		pdrMapping.setCompanyId(RandomTestUtil.nextLong());

		pdrMapping.setUserId(RandomTestUtil.nextLong());

		pdrMapping.setUserName(RandomTestUtil.randomString());

		pdrMapping.setCreateDate(RandomTestUtil.nextDate());

		pdrMapping.setModifiedDate(RandomTestUtil.nextDate());

		pdrMapping.setState(RandomTestUtil.randomString());

		pdrMapping.setStateByUserId(RandomTestUtil.nextLong());

		pdrMapping.setStateByUserName(RandomTestUtil.randomString());

		pdrMapping.setStateDate(RandomTestUtil.nextDate());

		_pdrMappings.add(_persistence.update(pdrMapping));

		return pdrMapping;
	}

	private List<PDRMapping> _pdrMappings = new ArrayList<PDRMapping>();
	private PDRMappingPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}