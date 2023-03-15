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

import cz.csob.ency.pdr.exception.NoSuchPDRAttributeException;
import cz.csob.ency.pdr.model.PDRAttribute;
import cz.csob.ency.pdr.service.PDRAttributeLocalServiceUtil;
import cz.csob.ency.pdr.service.persistence.PDRAttributePersistence;
import cz.csob.ency.pdr.service.persistence.PDRAttributeUtil;

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
public class PDRAttributePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "cz.csob.ency.pdr.service"));

	@Before
	public void setUp() {
		_persistence = PDRAttributeUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<PDRAttribute> iterator = _pdrAttributes.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PDRAttribute pdrAttribute = _persistence.create(pk);

		Assert.assertNotNull(pdrAttribute);

		Assert.assertEquals(pdrAttribute.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		PDRAttribute newPDRAttribute = addPDRAttribute();

		_persistence.remove(newPDRAttribute);

		PDRAttribute existingPDRAttribute = _persistence.fetchByPrimaryKey(
			newPDRAttribute.getPrimaryKey());

		Assert.assertNull(existingPDRAttribute);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addPDRAttribute();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PDRAttribute newPDRAttribute = _persistence.create(pk);

		newPDRAttribute.setMvccVersion(RandomTestUtil.nextLong());

		newPDRAttribute.setFullName(RandomTestUtil.randomString());

		newPDRAttribute.setParentId(RandomTestUtil.nextLong());

		newPDRAttribute.setNameCz(RandomTestUtil.randomString());

		newPDRAttribute.setNameEn(RandomTestUtil.randomString());

		newPDRAttribute.setNameSk(RandomTestUtil.randomString());

		newPDRAttribute.setOrder(RandomTestUtil.nextInt());

		newPDRAttribute.setLevel(RandomTestUtil.nextInt());

		newPDRAttribute.setIdsPath(RandomTestUtil.randomString());

		newPDRAttribute.setDescription(RandomTestUtil.randomString());

		newPDRAttribute.setPersonalDataTypeId(RandomTestUtil.nextLong());

		newPDRAttribute.setTagName(RandomTestUtil.randomString());

		newPDRAttribute.setIsRoA(RandomTestUtil.randomBoolean());

		newPDRAttribute.setIsRtP(RandomTestUtil.randomBoolean());

		newPDRAttribute.setSeparatorBefore(RandomTestUtil.randomString());

		newPDRAttribute.setSeparatorAfter(RandomTestUtil.randomString());

		newPDRAttribute.setIsMerge(RandomTestUtil.randomBoolean());

		newPDRAttribute.setIsLabel(RandomTestUtil.randomBoolean());

		newPDRAttribute.setIsObject(RandomTestUtil.randomBoolean());

		newPDRAttribute.setGroupId(RandomTestUtil.nextLong());

		newPDRAttribute.setCompanyId(RandomTestUtil.nextLong());

		newPDRAttribute.setUserId(RandomTestUtil.nextLong());

		newPDRAttribute.setUserName(RandomTestUtil.randomString());

		newPDRAttribute.setCreateDate(RandomTestUtil.nextDate());

		newPDRAttribute.setModifiedDate(RandomTestUtil.nextDate());

		_pdrAttributes.add(_persistence.update(newPDRAttribute));

		PDRAttribute existingPDRAttribute = _persistence.findByPrimaryKey(
			newPDRAttribute.getPrimaryKey());

		Assert.assertEquals(
			existingPDRAttribute.getMvccVersion(),
			newPDRAttribute.getMvccVersion());
		Assert.assertEquals(
			existingPDRAttribute.getAttributeId(),
			newPDRAttribute.getAttributeId());
		Assert.assertEquals(
			existingPDRAttribute.getFullName(), newPDRAttribute.getFullName());
		Assert.assertEquals(
			existingPDRAttribute.getParentId(), newPDRAttribute.getParentId());
		Assert.assertEquals(
			existingPDRAttribute.getNameCz(), newPDRAttribute.getNameCz());
		Assert.assertEquals(
			existingPDRAttribute.getNameEn(), newPDRAttribute.getNameEn());
		Assert.assertEquals(
			existingPDRAttribute.getNameSk(), newPDRAttribute.getNameSk());
		Assert.assertEquals(
			existingPDRAttribute.getOrder(), newPDRAttribute.getOrder());
		Assert.assertEquals(
			existingPDRAttribute.getLevel(), newPDRAttribute.getLevel());
		Assert.assertEquals(
			existingPDRAttribute.getIdsPath(), newPDRAttribute.getIdsPath());
		Assert.assertEquals(
			existingPDRAttribute.getDescription(),
			newPDRAttribute.getDescription());
		Assert.assertEquals(
			existingPDRAttribute.getPersonalDataTypeId(),
			newPDRAttribute.getPersonalDataTypeId());
		Assert.assertEquals(
			existingPDRAttribute.getTagName(), newPDRAttribute.getTagName());
		Assert.assertEquals(
			existingPDRAttribute.isIsRoA(), newPDRAttribute.isIsRoA());
		Assert.assertEquals(
			existingPDRAttribute.isIsRtP(), newPDRAttribute.isIsRtP());
		Assert.assertEquals(
			existingPDRAttribute.getSeparatorBefore(),
			newPDRAttribute.getSeparatorBefore());
		Assert.assertEquals(
			existingPDRAttribute.getSeparatorAfter(),
			newPDRAttribute.getSeparatorAfter());
		Assert.assertEquals(
			existingPDRAttribute.isIsMerge(), newPDRAttribute.isIsMerge());
		Assert.assertEquals(
			existingPDRAttribute.isIsLabel(), newPDRAttribute.isIsLabel());
		Assert.assertEquals(
			existingPDRAttribute.isIsObject(), newPDRAttribute.isIsObject());
		Assert.assertEquals(
			existingPDRAttribute.getGroupId(), newPDRAttribute.getGroupId());
		Assert.assertEquals(
			existingPDRAttribute.getCompanyId(),
			newPDRAttribute.getCompanyId());
		Assert.assertEquals(
			existingPDRAttribute.getUserId(), newPDRAttribute.getUserId());
		Assert.assertEquals(
			existingPDRAttribute.getUserName(), newPDRAttribute.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingPDRAttribute.getCreateDate()),
			Time.getShortTimestamp(newPDRAttribute.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingPDRAttribute.getModifiedDate()),
			Time.getShortTimestamp(newPDRAttribute.getModifiedDate()));
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		PDRAttribute newPDRAttribute = addPDRAttribute();

		PDRAttribute existingPDRAttribute = _persistence.findByPrimaryKey(
			newPDRAttribute.getPrimaryKey());

		Assert.assertEquals(existingPDRAttribute, newPDRAttribute);
	}

	@Test(expected = NoSuchPDRAttributeException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<PDRAttribute> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"pdr_attribute", "mvccVersion", true, "attributeId", true,
			"fullName", true, "parentId", true, "nameCz", true, "nameEn", true,
			"nameSk", true, "order", true, "level", true, "idsPath", true,
			"description", true, "personalDataTypeId", true, "tagName", true,
			"isRoA", true, "isRtP", true, "separatorBefore", true,
			"separatorAfter", true, "isMerge", true, "isLabel", true,
			"isObject", true, "groupId", true, "companyId", true, "userId",
			true, "userName", true, "createDate", true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		PDRAttribute newPDRAttribute = addPDRAttribute();

		PDRAttribute existingPDRAttribute = _persistence.fetchByPrimaryKey(
			newPDRAttribute.getPrimaryKey());

		Assert.assertEquals(existingPDRAttribute, newPDRAttribute);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PDRAttribute missingPDRAttribute = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingPDRAttribute);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		PDRAttribute newPDRAttribute1 = addPDRAttribute();
		PDRAttribute newPDRAttribute2 = addPDRAttribute();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPDRAttribute1.getPrimaryKey());
		primaryKeys.add(newPDRAttribute2.getPrimaryKey());

		Map<Serializable, PDRAttribute> pdrAttributes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, pdrAttributes.size());
		Assert.assertEquals(
			newPDRAttribute1,
			pdrAttributes.get(newPDRAttribute1.getPrimaryKey()));
		Assert.assertEquals(
			newPDRAttribute2,
			pdrAttributes.get(newPDRAttribute2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, PDRAttribute> pdrAttributes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(pdrAttributes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		PDRAttribute newPDRAttribute = addPDRAttribute();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPDRAttribute.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, PDRAttribute> pdrAttributes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, pdrAttributes.size());
		Assert.assertEquals(
			newPDRAttribute,
			pdrAttributes.get(newPDRAttribute.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, PDRAttribute> pdrAttributes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(pdrAttributes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		PDRAttribute newPDRAttribute = addPDRAttribute();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPDRAttribute.getPrimaryKey());

		Map<Serializable, PDRAttribute> pdrAttributes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, pdrAttributes.size());
		Assert.assertEquals(
			newPDRAttribute,
			pdrAttributes.get(newPDRAttribute.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			PDRAttributeLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<PDRAttribute>() {

				@Override
				public void performAction(PDRAttribute pdrAttribute) {
					Assert.assertNotNull(pdrAttribute);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		PDRAttribute newPDRAttribute = addPDRAttribute();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PDRAttribute.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"attributeId", newPDRAttribute.getAttributeId()));

		List<PDRAttribute> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		PDRAttribute existingPDRAttribute = result.get(0);

		Assert.assertEquals(existingPDRAttribute, newPDRAttribute);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PDRAttribute.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"attributeId", RandomTestUtil.nextLong()));

		List<PDRAttribute> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		PDRAttribute newPDRAttribute = addPDRAttribute();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PDRAttribute.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("attributeId"));

		Object newAttributeId = newPDRAttribute.getAttributeId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"attributeId", new Object[] {newAttributeId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAttributeId = result.get(0);

		Assert.assertEquals(existingAttributeId, newAttributeId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PDRAttribute.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("attributeId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"attributeId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected PDRAttribute addPDRAttribute() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PDRAttribute pdrAttribute = _persistence.create(pk);

		pdrAttribute.setMvccVersion(RandomTestUtil.nextLong());

		pdrAttribute.setFullName(RandomTestUtil.randomString());

		pdrAttribute.setParentId(RandomTestUtil.nextLong());

		pdrAttribute.setNameCz(RandomTestUtil.randomString());

		pdrAttribute.setNameEn(RandomTestUtil.randomString());

		pdrAttribute.setNameSk(RandomTestUtil.randomString());

		pdrAttribute.setOrder(RandomTestUtil.nextInt());

		pdrAttribute.setLevel(RandomTestUtil.nextInt());

		pdrAttribute.setIdsPath(RandomTestUtil.randomString());

		pdrAttribute.setDescription(RandomTestUtil.randomString());

		pdrAttribute.setPersonalDataTypeId(RandomTestUtil.nextLong());

		pdrAttribute.setTagName(RandomTestUtil.randomString());

		pdrAttribute.setIsRoA(RandomTestUtil.randomBoolean());

		pdrAttribute.setIsRtP(RandomTestUtil.randomBoolean());

		pdrAttribute.setSeparatorBefore(RandomTestUtil.randomString());

		pdrAttribute.setSeparatorAfter(RandomTestUtil.randomString());

		pdrAttribute.setIsMerge(RandomTestUtil.randomBoolean());

		pdrAttribute.setIsLabel(RandomTestUtil.randomBoolean());

		pdrAttribute.setIsObject(RandomTestUtil.randomBoolean());

		pdrAttribute.setGroupId(RandomTestUtil.nextLong());

		pdrAttribute.setCompanyId(RandomTestUtil.nextLong());

		pdrAttribute.setUserId(RandomTestUtil.nextLong());

		pdrAttribute.setUserName(RandomTestUtil.randomString());

		pdrAttribute.setCreateDate(RandomTestUtil.nextDate());

		pdrAttribute.setModifiedDate(RandomTestUtil.nextDate());

		_pdrAttributes.add(_persistence.update(pdrAttribute));

		return pdrAttribute;
	}

	private List<PDRAttribute> _pdrAttributes = new ArrayList<PDRAttribute>();
	private PDRAttributePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}