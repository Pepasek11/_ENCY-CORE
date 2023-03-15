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

package cz.csob.ency.workflow.service.persistence.test;

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

import cz.csob.ency.workflow.exception.NoSuchLinkException;
import cz.csob.ency.workflow.model.EncyWorkflowLink;
import cz.csob.ency.workflow.service.EncyWorkflowLinkLocalServiceUtil;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowLinkPersistence;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowLinkUtil;

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
public class EncyWorkflowLinkPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "cz.csob.ency.workflow.service"));

	@Before
	public void setUp() {
		_persistence = EncyWorkflowLinkUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<EncyWorkflowLink> iterator = _encyWorkflowLinks.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflowLink encyWorkflowLink = _persistence.create(pk);

		Assert.assertNotNull(encyWorkflowLink);

		Assert.assertEquals(encyWorkflowLink.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		EncyWorkflowLink newEncyWorkflowLink = addEncyWorkflowLink();

		_persistence.remove(newEncyWorkflowLink);

		EncyWorkflowLink existingEncyWorkflowLink =
			_persistence.fetchByPrimaryKey(newEncyWorkflowLink.getPrimaryKey());

		Assert.assertNull(existingEncyWorkflowLink);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEncyWorkflowLink();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflowLink newEncyWorkflowLink = _persistence.create(pk);

		newEncyWorkflowLink.setUuid(RandomTestUtil.randomString());

		newEncyWorkflowLink.setGroupId(RandomTestUtil.nextLong());

		newEncyWorkflowLink.setCompanyId(RandomTestUtil.nextLong());

		newEncyWorkflowLink.setUserId(RandomTestUtil.nextLong());

		newEncyWorkflowLink.setUserName(RandomTestUtil.randomString());

		newEncyWorkflowLink.setCreateDate(RandomTestUtil.nextDate());

		newEncyWorkflowLink.setModifiedDate(RandomTestUtil.nextDate());

		newEncyWorkflowLink.setClassName(RandomTestUtil.randomString());

		newEncyWorkflowLink.setFolderClassName(RandomTestUtil.randomString());

		newEncyWorkflowLink.setFolderPK(RandomTestUtil.nextLong());

		newEncyWorkflowLink.setWorkflowId(RandomTestUtil.nextLong());

		_encyWorkflowLinks.add(_persistence.update(newEncyWorkflowLink));

		EncyWorkflowLink existingEncyWorkflowLink =
			_persistence.findByPrimaryKey(newEncyWorkflowLink.getPrimaryKey());

		Assert.assertEquals(
			existingEncyWorkflowLink.getUuid(), newEncyWorkflowLink.getUuid());
		Assert.assertEquals(
			existingEncyWorkflowLink.getWorkflowLinkId(),
			newEncyWorkflowLink.getWorkflowLinkId());
		Assert.assertEquals(
			existingEncyWorkflowLink.getGroupId(),
			newEncyWorkflowLink.getGroupId());
		Assert.assertEquals(
			existingEncyWorkflowLink.getCompanyId(),
			newEncyWorkflowLink.getCompanyId());
		Assert.assertEquals(
			existingEncyWorkflowLink.getUserId(),
			newEncyWorkflowLink.getUserId());
		Assert.assertEquals(
			existingEncyWorkflowLink.getUserName(),
			newEncyWorkflowLink.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingEncyWorkflowLink.getCreateDate()),
			Time.getShortTimestamp(newEncyWorkflowLink.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingEncyWorkflowLink.getModifiedDate()),
			Time.getShortTimestamp(newEncyWorkflowLink.getModifiedDate()));
		Assert.assertEquals(
			existingEncyWorkflowLink.getClassName(),
			newEncyWorkflowLink.getClassName());
		Assert.assertEquals(
			existingEncyWorkflowLink.getFolderClassName(),
			newEncyWorkflowLink.getFolderClassName());
		Assert.assertEquals(
			existingEncyWorkflowLink.getFolderPK(),
			newEncyWorkflowLink.getFolderPK());
		Assert.assertEquals(
			existingEncyWorkflowLink.getWorkflowId(),
			newEncyWorkflowLink.getWorkflowId());
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
	public void testCountByCompanyId() throws Exception {
		_persistence.countByCompanyId(RandomTestUtil.nextLong());

		_persistence.countByCompanyId(0L);
	}

	@Test
	public void testCountByG_C_C() throws Exception {
		_persistence.countByG_C_C(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(), "");

		_persistence.countByG_C_C(0L, 0L, "null");

		_persistence.countByG_C_C(0L, 0L, (String)null);
	}

	@Test
	public void testCountByG_C_CArrayable() throws Exception {
		_persistence.countByG_C_C(
			new long[] {RandomTestUtil.nextLong(), 0L},
			new long[] {RandomTestUtil.nextLong(), 0L},
			RandomTestUtil.randomString());
	}

	@Test
	public void testCountByC_I() throws Exception {
		_persistence.countByC_I(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByC_I(0L, 0L);
	}

	@Test
	public void testCountByC_IArrayable() throws Exception {
		_persistence.countByC_I(
			new long[] {RandomTestUtil.nextLong(), 0L},
			RandomTestUtil.nextLong());
	}

	@Test
	public void testCountByWorkflowId() throws Exception {
		_persistence.countByWorkflowId(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByWorkflowId(0L, 0L);
	}

	@Test
	public void testCountByWorkflowIdArrayable() throws Exception {
		_persistence.countByWorkflowId(
			new long[] {RandomTestUtil.nextLong(), 0L},
			RandomTestUtil.nextLong());
	}

	@Test
	public void testCountByG_C_C_F_F() throws Exception {
		_persistence.countByG_C_C_F_F(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(), "", "",
			RandomTestUtil.nextLong());

		_persistence.countByG_C_C_F_F(0L, 0L, "null", "null", 0L);

		_persistence.countByG_C_C_F_F(0L, 0L, (String)null, (String)null, 0L);
	}

	@Test
	public void testCountByG_C_C_F_FArrayable() throws Exception {
		_persistence.countByG_C_C_F_F(
			new long[] {RandomTestUtil.nextLong(), 0L},
			new long[] {RandomTestUtil.nextLong(), 0L},
			RandomTestUtil.randomString(),
			new String[] {
				RandomTestUtil.randomString(), "", "null", null, null
			},
			new long[] {RandomTestUtil.nextLong(), 0L});
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		EncyWorkflowLink newEncyWorkflowLink = addEncyWorkflowLink();

		EncyWorkflowLink existingEncyWorkflowLink =
			_persistence.findByPrimaryKey(newEncyWorkflowLink.getPrimaryKey());

		Assert.assertEquals(existingEncyWorkflowLink, newEncyWorkflowLink);
	}

	@Test(expected = NoSuchLinkException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<EncyWorkflowLink> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ency_workflowlink", "uuid", true, "workflowLinkId", true,
			"groupId", true, "companyId", true, "userId", true, "userName",
			true, "createDate", true, "modifiedDate", true, "className", true,
			"folderClassName", true, "folderPK", true, "workflowId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		EncyWorkflowLink newEncyWorkflowLink = addEncyWorkflowLink();

		EncyWorkflowLink existingEncyWorkflowLink =
			_persistence.fetchByPrimaryKey(newEncyWorkflowLink.getPrimaryKey());

		Assert.assertEquals(existingEncyWorkflowLink, newEncyWorkflowLink);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflowLink missingEncyWorkflowLink =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEncyWorkflowLink);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		EncyWorkflowLink newEncyWorkflowLink1 = addEncyWorkflowLink();
		EncyWorkflowLink newEncyWorkflowLink2 = addEncyWorkflowLink();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEncyWorkflowLink1.getPrimaryKey());
		primaryKeys.add(newEncyWorkflowLink2.getPrimaryKey());

		Map<Serializable, EncyWorkflowLink> encyWorkflowLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, encyWorkflowLinks.size());
		Assert.assertEquals(
			newEncyWorkflowLink1,
			encyWorkflowLinks.get(newEncyWorkflowLink1.getPrimaryKey()));
		Assert.assertEquals(
			newEncyWorkflowLink2,
			encyWorkflowLinks.get(newEncyWorkflowLink2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, EncyWorkflowLink> encyWorkflowLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(encyWorkflowLinks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		EncyWorkflowLink newEncyWorkflowLink = addEncyWorkflowLink();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEncyWorkflowLink.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, EncyWorkflowLink> encyWorkflowLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, encyWorkflowLinks.size());
		Assert.assertEquals(
			newEncyWorkflowLink,
			encyWorkflowLinks.get(newEncyWorkflowLink.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, EncyWorkflowLink> encyWorkflowLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(encyWorkflowLinks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		EncyWorkflowLink newEncyWorkflowLink = addEncyWorkflowLink();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEncyWorkflowLink.getPrimaryKey());

		Map<Serializable, EncyWorkflowLink> encyWorkflowLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, encyWorkflowLinks.size());
		Assert.assertEquals(
			newEncyWorkflowLink,
			encyWorkflowLinks.get(newEncyWorkflowLink.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			EncyWorkflowLinkLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<EncyWorkflowLink>() {

				@Override
				public void performAction(EncyWorkflowLink encyWorkflowLink) {
					Assert.assertNotNull(encyWorkflowLink);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		EncyWorkflowLink newEncyWorkflowLink = addEncyWorkflowLink();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowLink.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"workflowLinkId", newEncyWorkflowLink.getWorkflowLinkId()));

		List<EncyWorkflowLink> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		EncyWorkflowLink existingEncyWorkflowLink = result.get(0);

		Assert.assertEquals(existingEncyWorkflowLink, newEncyWorkflowLink);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowLink.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"workflowLinkId", RandomTestUtil.nextLong()));

		List<EncyWorkflowLink> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		EncyWorkflowLink newEncyWorkflowLink = addEncyWorkflowLink();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowLink.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("workflowLinkId"));

		Object newWorkflowLinkId = newEncyWorkflowLink.getWorkflowLinkId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"workflowLinkId", new Object[] {newWorkflowLinkId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingWorkflowLinkId = result.get(0);

		Assert.assertEquals(existingWorkflowLinkId, newWorkflowLinkId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowLink.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("workflowLinkId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"workflowLinkId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		EncyWorkflowLink newEncyWorkflowLink = addEncyWorkflowLink();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newEncyWorkflowLink.getPrimaryKey()));
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

		EncyWorkflowLink newEncyWorkflowLink = addEncyWorkflowLink();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EncyWorkflowLink.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"workflowLinkId", newEncyWorkflowLink.getWorkflowLinkId()));

		List<EncyWorkflowLink> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(EncyWorkflowLink encyWorkflowLink) {
		Assert.assertEquals(
			encyWorkflowLink.getUuid(),
			ReflectionTestUtil.invoke(
				encyWorkflowLink, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(encyWorkflowLink.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				encyWorkflowLink, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected EncyWorkflowLink addEncyWorkflowLink() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EncyWorkflowLink encyWorkflowLink = _persistence.create(pk);

		encyWorkflowLink.setUuid(RandomTestUtil.randomString());

		encyWorkflowLink.setGroupId(RandomTestUtil.nextLong());

		encyWorkflowLink.setCompanyId(RandomTestUtil.nextLong());

		encyWorkflowLink.setUserId(RandomTestUtil.nextLong());

		encyWorkflowLink.setUserName(RandomTestUtil.randomString());

		encyWorkflowLink.setCreateDate(RandomTestUtil.nextDate());

		encyWorkflowLink.setModifiedDate(RandomTestUtil.nextDate());

		encyWorkflowLink.setClassName(RandomTestUtil.randomString());

		encyWorkflowLink.setFolderClassName(RandomTestUtil.randomString());

		encyWorkflowLink.setFolderPK(RandomTestUtil.nextLong());

		encyWorkflowLink.setWorkflowId(RandomTestUtil.nextLong());

		_encyWorkflowLinks.add(_persistence.update(encyWorkflowLink));

		return encyWorkflowLink;
	}

	private List<EncyWorkflowLink> _encyWorkflowLinks =
		new ArrayList<EncyWorkflowLink>();
	private EncyWorkflowLinkPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}