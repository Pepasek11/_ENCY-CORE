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

package cz.csob.ency.workflow.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import cz.csob.ency.workflow.exception.NoSuchTransitionInstanceException;
import cz.csob.ency.workflow.model.EncyWorkflowTransitionInstance;
import cz.csob.ency.workflow.model.EncyWorkflowTransitionInstanceTable;
import cz.csob.ency.workflow.model.impl.EncyWorkflowTransitionInstanceImpl;
import cz.csob.ency.workflow.model.impl.EncyWorkflowTransitionInstanceModelImpl;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowTransitionInstancePersistence;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowTransitionInstanceUtil;
import cz.csob.ency.workflow.service.persistence.impl.constants.EncyWorkflowPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the ency workflow transition instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @generated
 */
@Component(
	service = {
		EncyWorkflowTransitionInstancePersistence.class, BasePersistence.class
	}
)
public class EncyWorkflowTransitionInstancePersistenceImpl
	extends BasePersistenceImpl<EncyWorkflowTransitionInstance>
	implements EncyWorkflowTransitionInstancePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EncyWorkflowTransitionInstanceUtil</code> to access the ency workflow transition instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EncyWorkflowTransitionInstanceImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the ency workflow transition instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ency workflow transition instances
	 */
	@Override
	public List<EncyWorkflowTransitionInstance> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow transition instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @return the range of matching ency workflow transition instances
	 */
	@Override
	public List<EncyWorkflowTransitionInstance> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow transition instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow transition instances
	 */
	@Override
	public List<EncyWorkflowTransitionInstance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow transition instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow transition instances
	 */
	@Override
	public List<EncyWorkflowTransitionInstance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<EncyWorkflowTransitionInstance> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowTransitionInstance>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowTransitionInstance
						encyWorkflowTransitionInstance : list) {

					if (!uuid.equals(
							encyWorkflowTransitionInstance.getUuid())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ENCYWORKFLOWTRANSITIONINSTANCE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					EncyWorkflowTransitionInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<EncyWorkflowTransitionInstance>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ency workflow transition instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a matching ency workflow transition instance could not be found
	 */
	@Override
	public EncyWorkflowTransitionInstance findByUuid_First(
			String uuid,
			OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator)
		throws NoSuchTransitionInstanceException {

		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance =
			fetchByUuid_First(uuid, orderByComparator);

		if (encyWorkflowTransitionInstance != null) {
			return encyWorkflowTransitionInstance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTransitionInstanceException(sb.toString());
	}

	/**
	 * Returns the first ency workflow transition instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	@Override
	public EncyWorkflowTransitionInstance fetchByUuid_First(
		String uuid,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator) {

		List<EncyWorkflowTransitionInstance> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow transition instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a matching ency workflow transition instance could not be found
	 */
	@Override
	public EncyWorkflowTransitionInstance findByUuid_Last(
			String uuid,
			OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator)
		throws NoSuchTransitionInstanceException {

		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance =
			fetchByUuid_Last(uuid, orderByComparator);

		if (encyWorkflowTransitionInstance != null) {
			return encyWorkflowTransitionInstance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTransitionInstanceException(sb.toString());
	}

	/**
	 * Returns the last ency workflow transition instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	@Override
	public EncyWorkflowTransitionInstance fetchByUuid_Last(
		String uuid,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflowTransitionInstance> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflow transition instances before and after the current ency workflow transition instance in the ordered set where uuid = &#63;.
	 *
	 * @param transitionInstanceId the primary key of the current ency workflow transition instance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a ency workflow transition instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowTransitionInstance[] findByUuid_PrevAndNext(
			long transitionInstanceId, String uuid,
			OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator)
		throws NoSuchTransitionInstanceException {

		uuid = Objects.toString(uuid, "");

		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance =
			findByPrimaryKey(transitionInstanceId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowTransitionInstance[] array =
				new EncyWorkflowTransitionInstanceImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, encyWorkflowTransitionInstance, uuid,
				orderByComparator, true);

			array[1] = encyWorkflowTransitionInstance;

			array[2] = getByUuid_PrevAndNext(
				session, encyWorkflowTransitionInstance, uuid,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EncyWorkflowTransitionInstance getByUuid_PrevAndNext(
		Session session,
		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance,
		String uuid,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ENCYWORKFLOWTRANSITIONINSTANCE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EncyWorkflowTransitionInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						encyWorkflowTransitionInstance)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflowTransitionInstance> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ency workflow transition instances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EncyWorkflowTransitionInstance encyWorkflowTransitionInstance :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(encyWorkflowTransitionInstance);
		}
	}

	/**
	 * Returns the number of ency workflow transition instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ency workflow transition instances
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ENCYWORKFLOWTRANSITIONINSTANCE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"encyWorkflowTransitionInstance.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(encyWorkflowTransitionInstance.uuid IS NULL OR encyWorkflowTransitionInstance.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the ency workflow transition instance where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTransitionInstanceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a matching ency workflow transition instance could not be found
	 */
	@Override
	public EncyWorkflowTransitionInstance findByUUID_G(
			String uuid, long groupId)
		throws NoSuchTransitionInstanceException {

		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance =
			fetchByUUID_G(uuid, groupId);

		if (encyWorkflowTransitionInstance == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTransitionInstanceException(sb.toString());
		}

		return encyWorkflowTransitionInstance;
	}

	/**
	 * Returns the ency workflow transition instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	@Override
	public EncyWorkflowTransitionInstance fetchByUUID_G(
		String uuid, long groupId) {

		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the ency workflow transition instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	@Override
	public EncyWorkflowTransitionInstance fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof EncyWorkflowTransitionInstance) {
			EncyWorkflowTransitionInstance encyWorkflowTransitionInstance =
				(EncyWorkflowTransitionInstance)result;

			if (!Objects.equals(
					uuid, encyWorkflowTransitionInstance.getUuid()) ||
				(groupId != encyWorkflowTransitionInstance.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ENCYWORKFLOWTRANSITIONINSTANCE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<EncyWorkflowTransitionInstance> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					EncyWorkflowTransitionInstance
						encyWorkflowTransitionInstance = list.get(0);

					result = encyWorkflowTransitionInstance;

					cacheResult(encyWorkflowTransitionInstance);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (EncyWorkflowTransitionInstance)result;
		}
	}

	/**
	 * Removes the ency workflow transition instance where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ency workflow transition instance that was removed
	 */
	@Override
	public EncyWorkflowTransitionInstance removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchTransitionInstanceException {

		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance =
			findByUUID_G(uuid, groupId);

		return remove(encyWorkflowTransitionInstance);
	}

	/**
	 * Returns the number of ency workflow transition instances where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ency workflow transition instances
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ENCYWORKFLOWTRANSITIONINSTANCE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"encyWorkflowTransitionInstance.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(encyWorkflowTransitionInstance.uuid IS NULL OR encyWorkflowTransitionInstance.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"encyWorkflowTransitionInstance.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the ency workflow transition instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ency workflow transition instances
	 */
	@Override
	public List<EncyWorkflowTransitionInstance> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow transition instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @return the range of matching ency workflow transition instances
	 */
	@Override
	public List<EncyWorkflowTransitionInstance> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow transition instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow transition instances
	 */
	@Override
	public List<EncyWorkflowTransitionInstance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow transition instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow transition instances
	 */
	@Override
	public List<EncyWorkflowTransitionInstance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<EncyWorkflowTransitionInstance> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowTransitionInstance>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowTransitionInstance
						encyWorkflowTransitionInstance : list) {

					if (!uuid.equals(
							encyWorkflowTransitionInstance.getUuid()) ||
						(companyId !=
							encyWorkflowTransitionInstance.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_ENCYWORKFLOWTRANSITIONINSTANCE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					EncyWorkflowTransitionInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<EncyWorkflowTransitionInstance>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ency workflow transition instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a matching ency workflow transition instance could not be found
	 */
	@Override
	public EncyWorkflowTransitionInstance findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator)
		throws NoSuchTransitionInstanceException {

		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (encyWorkflowTransitionInstance != null) {
			return encyWorkflowTransitionInstance;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTransitionInstanceException(sb.toString());
	}

	/**
	 * Returns the first ency workflow transition instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	@Override
	public EncyWorkflowTransitionInstance fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator) {

		List<EncyWorkflowTransitionInstance> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow transition instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a matching ency workflow transition instance could not be found
	 */
	@Override
	public EncyWorkflowTransitionInstance findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator)
		throws NoSuchTransitionInstanceException {

		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (encyWorkflowTransitionInstance != null) {
			return encyWorkflowTransitionInstance;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTransitionInstanceException(sb.toString());
	}

	/**
	 * Returns the last ency workflow transition instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	@Override
	public EncyWorkflowTransitionInstance fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflowTransitionInstance> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflow transition instances before and after the current ency workflow transition instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param transitionInstanceId the primary key of the current ency workflow transition instance
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a ency workflow transition instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowTransitionInstance[] findByUuid_C_PrevAndNext(
			long transitionInstanceId, String uuid, long companyId,
			OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator)
		throws NoSuchTransitionInstanceException {

		uuid = Objects.toString(uuid, "");

		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance =
			findByPrimaryKey(transitionInstanceId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowTransitionInstance[] array =
				new EncyWorkflowTransitionInstanceImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, encyWorkflowTransitionInstance, uuid, companyId,
				orderByComparator, true);

			array[1] = encyWorkflowTransitionInstance;

			array[2] = getByUuid_C_PrevAndNext(
				session, encyWorkflowTransitionInstance, uuid, companyId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EncyWorkflowTransitionInstance getByUuid_C_PrevAndNext(
		Session session,
		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance,
		String uuid, long companyId,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_ENCYWORKFLOWTRANSITIONINSTANCE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EncyWorkflowTransitionInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						encyWorkflowTransitionInstance)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflowTransitionInstance> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ency workflow transition instances where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (EncyWorkflowTransitionInstance encyWorkflowTransitionInstance :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(encyWorkflowTransitionInstance);
		}
	}

	/**
	 * Returns the number of ency workflow transition instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ency workflow transition instances
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ENCYWORKFLOWTRANSITIONINSTANCE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"encyWorkflowTransitionInstance.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(encyWorkflowTransitionInstance.uuid IS NULL OR encyWorkflowTransitionInstance.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"encyWorkflowTransitionInstance.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByWorkflowInstanceId;
	private FinderPath _finderPathWithoutPaginationFindByWorkflowInstanceId;
	private FinderPath _finderPathCountByWorkflowInstanceId;

	/**
	 * Returns all the ency workflow transition instances where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @return the matching ency workflow transition instances
	 */
	@Override
	public List<EncyWorkflowTransitionInstance> findByWorkflowInstanceId(
		long workflowInstanceId) {

		return findByWorkflowInstanceId(
			workflowInstanceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow transition instances where workflowInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @return the range of matching ency workflow transition instances
	 */
	@Override
	public List<EncyWorkflowTransitionInstance> findByWorkflowInstanceId(
		long workflowInstanceId, int start, int end) {

		return findByWorkflowInstanceId(workflowInstanceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow transition instances where workflowInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow transition instances
	 */
	@Override
	public List<EncyWorkflowTransitionInstance> findByWorkflowInstanceId(
		long workflowInstanceId, int start, int end,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator) {

		return findByWorkflowInstanceId(
			workflowInstanceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow transition instances where workflowInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow transition instances
	 */
	@Override
	public List<EncyWorkflowTransitionInstance> findByWorkflowInstanceId(
		long workflowInstanceId, int start, int end,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByWorkflowInstanceId;
				finderArgs = new Object[] {workflowInstanceId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByWorkflowInstanceId;
			finderArgs = new Object[] {
				workflowInstanceId, start, end, orderByComparator
			};
		}

		List<EncyWorkflowTransitionInstance> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowTransitionInstance>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowTransitionInstance
						encyWorkflowTransitionInstance : list) {

					if (workflowInstanceId !=
							encyWorkflowTransitionInstance.
								getWorkflowInstanceId()) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ENCYWORKFLOWTRANSITIONINSTANCE_WHERE);

			sb.append(_FINDER_COLUMN_WORKFLOWINSTANCEID_WORKFLOWINSTANCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					EncyWorkflowTransitionInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workflowInstanceId);

				list = (List<EncyWorkflowTransitionInstance>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ency workflow transition instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a matching ency workflow transition instance could not be found
	 */
	@Override
	public EncyWorkflowTransitionInstance findByWorkflowInstanceId_First(
			long workflowInstanceId,
			OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator)
		throws NoSuchTransitionInstanceException {

		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance =
			fetchByWorkflowInstanceId_First(
				workflowInstanceId, orderByComparator);

		if (encyWorkflowTransitionInstance != null) {
			return encyWorkflowTransitionInstance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workflowInstanceId=");
		sb.append(workflowInstanceId);

		sb.append("}");

		throw new NoSuchTransitionInstanceException(sb.toString());
	}

	/**
	 * Returns the first ency workflow transition instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	@Override
	public EncyWorkflowTransitionInstance fetchByWorkflowInstanceId_First(
		long workflowInstanceId,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator) {

		List<EncyWorkflowTransitionInstance> list = findByWorkflowInstanceId(
			workflowInstanceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow transition instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a matching ency workflow transition instance could not be found
	 */
	@Override
	public EncyWorkflowTransitionInstance findByWorkflowInstanceId_Last(
			long workflowInstanceId,
			OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator)
		throws NoSuchTransitionInstanceException {

		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance =
			fetchByWorkflowInstanceId_Last(
				workflowInstanceId, orderByComparator);

		if (encyWorkflowTransitionInstance != null) {
			return encyWorkflowTransitionInstance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workflowInstanceId=");
		sb.append(workflowInstanceId);

		sb.append("}");

		throw new NoSuchTransitionInstanceException(sb.toString());
	}

	/**
	 * Returns the last ency workflow transition instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition instance, or <code>null</code> if a matching ency workflow transition instance could not be found
	 */
	@Override
	public EncyWorkflowTransitionInstance fetchByWorkflowInstanceId_Last(
		long workflowInstanceId,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator) {

		int count = countByWorkflowInstanceId(workflowInstanceId);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflowTransitionInstance> list = findByWorkflowInstanceId(
			workflowInstanceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflow transition instances before and after the current ency workflow transition instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param transitionInstanceId the primary key of the current ency workflow transition instance
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a ency workflow transition instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowTransitionInstance[]
			findByWorkflowInstanceId_PrevAndNext(
				long transitionInstanceId, long workflowInstanceId,
				OrderByComparator<EncyWorkflowTransitionInstance>
					orderByComparator)
		throws NoSuchTransitionInstanceException {

		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance =
			findByPrimaryKey(transitionInstanceId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowTransitionInstance[] array =
				new EncyWorkflowTransitionInstanceImpl[3];

			array[0] = getByWorkflowInstanceId_PrevAndNext(
				session, encyWorkflowTransitionInstance, workflowInstanceId,
				orderByComparator, true);

			array[1] = encyWorkflowTransitionInstance;

			array[2] = getByWorkflowInstanceId_PrevAndNext(
				session, encyWorkflowTransitionInstance, workflowInstanceId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EncyWorkflowTransitionInstance
		getByWorkflowInstanceId_PrevAndNext(
			Session session,
			EncyWorkflowTransitionInstance encyWorkflowTransitionInstance,
			long workflowInstanceId,
			OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator,
			boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ENCYWORKFLOWTRANSITIONINSTANCE_WHERE);

		sb.append(_FINDER_COLUMN_WORKFLOWINSTANCEID_WORKFLOWINSTANCEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EncyWorkflowTransitionInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(workflowInstanceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						encyWorkflowTransitionInstance)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflowTransitionInstance> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ency workflow transition instances where workflowInstanceId = &#63; from the database.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 */
	@Override
	public void removeByWorkflowInstanceId(long workflowInstanceId) {
		for (EncyWorkflowTransitionInstance encyWorkflowTransitionInstance :
				findByWorkflowInstanceId(
					workflowInstanceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(encyWorkflowTransitionInstance);
		}
	}

	/**
	 * Returns the number of ency workflow transition instances where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @return the number of matching ency workflow transition instances
	 */
	@Override
	public int countByWorkflowInstanceId(long workflowInstanceId) {
		FinderPath finderPath = _finderPathCountByWorkflowInstanceId;

		Object[] finderArgs = new Object[] {workflowInstanceId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ENCYWORKFLOWTRANSITIONINSTANCE_WHERE);

			sb.append(_FINDER_COLUMN_WORKFLOWINSTANCEID_WORKFLOWINSTANCEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workflowInstanceId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_WORKFLOWINSTANCEID_WORKFLOWINSTANCEID_2 =
			"encyWorkflowTransitionInstance.workflowInstanceId = ?";

	public EncyWorkflowTransitionInstancePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("comment", "comment_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EncyWorkflowTransitionInstance.class);

		setModelImplClass(EncyWorkflowTransitionInstanceImpl.class);
		setModelPKClass(long.class);

		setTable(EncyWorkflowTransitionInstanceTable.INSTANCE);
	}

	/**
	 * Caches the ency workflow transition instance in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowTransitionInstance the ency workflow transition instance
	 */
	@Override
	public void cacheResult(
		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance) {

		entityCache.putResult(
			EncyWorkflowTransitionInstanceImpl.class,
			encyWorkflowTransitionInstance.getPrimaryKey(),
			encyWorkflowTransitionInstance);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				encyWorkflowTransitionInstance.getUuid(),
				encyWorkflowTransitionInstance.getGroupId()
			},
			encyWorkflowTransitionInstance);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the ency workflow transition instances in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowTransitionInstances the ency workflow transition instances
	 */
	@Override
	public void cacheResult(
		List<EncyWorkflowTransitionInstance> encyWorkflowTransitionInstances) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (encyWorkflowTransitionInstances.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EncyWorkflowTransitionInstance encyWorkflowTransitionInstance :
				encyWorkflowTransitionInstances) {

			if (entityCache.getResult(
					EncyWorkflowTransitionInstanceImpl.class,
					encyWorkflowTransitionInstance.getPrimaryKey()) == null) {

				cacheResult(encyWorkflowTransitionInstance);
			}
		}
	}

	/**
	 * Clears the cache for all ency workflow transition instances.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EncyWorkflowTransitionInstanceImpl.class);

		finderCache.clearCache(EncyWorkflowTransitionInstanceImpl.class);
	}

	/**
	 * Clears the cache for the ency workflow transition instance.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance) {

		entityCache.removeResult(
			EncyWorkflowTransitionInstanceImpl.class,
			encyWorkflowTransitionInstance);
	}

	@Override
	public void clearCache(
		List<EncyWorkflowTransitionInstance> encyWorkflowTransitionInstances) {

		for (EncyWorkflowTransitionInstance encyWorkflowTransitionInstance :
				encyWorkflowTransitionInstances) {

			entityCache.removeResult(
				EncyWorkflowTransitionInstanceImpl.class,
				encyWorkflowTransitionInstance);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EncyWorkflowTransitionInstanceImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				EncyWorkflowTransitionInstanceImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EncyWorkflowTransitionInstanceModelImpl
			encyWorkflowTransitionInstanceModelImpl) {

		Object[] args = new Object[] {
			encyWorkflowTransitionInstanceModelImpl.getUuid(),
			encyWorkflowTransitionInstanceModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			encyWorkflowTransitionInstanceModelImpl);
	}

	/**
	 * Creates a new ency workflow transition instance with the primary key. Does not add the ency workflow transition instance to the database.
	 *
	 * @param transitionInstanceId the primary key for the new ency workflow transition instance
	 * @return the new ency workflow transition instance
	 */
	@Override
	public EncyWorkflowTransitionInstance create(long transitionInstanceId) {
		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance =
			new EncyWorkflowTransitionInstanceImpl();

		encyWorkflowTransitionInstance.setNew(true);
		encyWorkflowTransitionInstance.setPrimaryKey(transitionInstanceId);

		String uuid = _portalUUID.generate();

		encyWorkflowTransitionInstance.setUuid(uuid);

		encyWorkflowTransitionInstance.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return encyWorkflowTransitionInstance;
	}

	/**
	 * Removes the ency workflow transition instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transitionInstanceId the primary key of the ency workflow transition instance
	 * @return the ency workflow transition instance that was removed
	 * @throws NoSuchTransitionInstanceException if a ency workflow transition instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowTransitionInstance remove(long transitionInstanceId)
		throws NoSuchTransitionInstanceException {

		return remove((Serializable)transitionInstanceId);
	}

	/**
	 * Removes the ency workflow transition instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ency workflow transition instance
	 * @return the ency workflow transition instance that was removed
	 * @throws NoSuchTransitionInstanceException if a ency workflow transition instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowTransitionInstance remove(Serializable primaryKey)
		throws NoSuchTransitionInstanceException {

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowTransitionInstance encyWorkflowTransitionInstance =
				(EncyWorkflowTransitionInstance)session.get(
					EncyWorkflowTransitionInstanceImpl.class, primaryKey);

			if (encyWorkflowTransitionInstance == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTransitionInstanceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(encyWorkflowTransitionInstance);
		}
		catch (NoSuchTransitionInstanceException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected EncyWorkflowTransitionInstance removeImpl(
		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(encyWorkflowTransitionInstance)) {
				encyWorkflowTransitionInstance =
					(EncyWorkflowTransitionInstance)session.get(
						EncyWorkflowTransitionInstanceImpl.class,
						encyWorkflowTransitionInstance.getPrimaryKeyObj());
			}

			if (encyWorkflowTransitionInstance != null) {
				session.delete(encyWorkflowTransitionInstance);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (encyWorkflowTransitionInstance != null) {
			clearCache(encyWorkflowTransitionInstance);
		}

		return encyWorkflowTransitionInstance;
	}

	@Override
	public EncyWorkflowTransitionInstance updateImpl(
		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance) {

		boolean isNew = encyWorkflowTransitionInstance.isNew();

		if (!(encyWorkflowTransitionInstance instanceof
				EncyWorkflowTransitionInstanceModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					encyWorkflowTransitionInstance.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					encyWorkflowTransitionInstance);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in encyWorkflowTransitionInstance proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EncyWorkflowTransitionInstance implementation " +
					encyWorkflowTransitionInstance.getClass());
		}

		EncyWorkflowTransitionInstanceModelImpl
			encyWorkflowTransitionInstanceModelImpl =
				(EncyWorkflowTransitionInstanceModelImpl)
					encyWorkflowTransitionInstance;

		if (Validator.isNull(encyWorkflowTransitionInstance.getUuid())) {
			String uuid = _portalUUID.generate();

			encyWorkflowTransitionInstance.setUuid(uuid);
		}

		if (isNew && (encyWorkflowTransitionInstance.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				encyWorkflowTransitionInstance.setCreateDate(date);
			}
			else {
				encyWorkflowTransitionInstance.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(encyWorkflowTransitionInstance);
			}
			else {
				encyWorkflowTransitionInstance =
					(EncyWorkflowTransitionInstance)session.merge(
						encyWorkflowTransitionInstance);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EncyWorkflowTransitionInstanceImpl.class,
			encyWorkflowTransitionInstanceModelImpl, false, true);

		cacheUniqueFindersCache(encyWorkflowTransitionInstanceModelImpl);

		if (isNew) {
			encyWorkflowTransitionInstance.setNew(false);
		}

		encyWorkflowTransitionInstance.resetOriginalValues();

		return encyWorkflowTransitionInstance;
	}

	/**
	 * Returns the ency workflow transition instance with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ency workflow transition instance
	 * @return the ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a ency workflow transition instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowTransitionInstance findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchTransitionInstanceException {

		EncyWorkflowTransitionInstance encyWorkflowTransitionInstance =
			fetchByPrimaryKey(primaryKey);

		if (encyWorkflowTransitionInstance == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTransitionInstanceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return encyWorkflowTransitionInstance;
	}

	/**
	 * Returns the ency workflow transition instance with the primary key or throws a <code>NoSuchTransitionInstanceException</code> if it could not be found.
	 *
	 * @param transitionInstanceId the primary key of the ency workflow transition instance
	 * @return the ency workflow transition instance
	 * @throws NoSuchTransitionInstanceException if a ency workflow transition instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowTransitionInstance findByPrimaryKey(
			long transitionInstanceId)
		throws NoSuchTransitionInstanceException {

		return findByPrimaryKey((Serializable)transitionInstanceId);
	}

	/**
	 * Returns the ency workflow transition instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param transitionInstanceId the primary key of the ency workflow transition instance
	 * @return the ency workflow transition instance, or <code>null</code> if a ency workflow transition instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowTransitionInstance fetchByPrimaryKey(
		long transitionInstanceId) {

		return fetchByPrimaryKey((Serializable)transitionInstanceId);
	}

	/**
	 * Returns all the ency workflow transition instances.
	 *
	 * @return the ency workflow transition instances
	 */
	@Override
	public List<EncyWorkflowTransitionInstance> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow transition instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @return the range of ency workflow transition instances
	 */
	@Override
	public List<EncyWorkflowTransitionInstance> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow transition instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ency workflow transition instances
	 */
	@Override
	public List<EncyWorkflowTransitionInstance> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow transition instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow transition instances
	 * @param end the upper bound of the range of ency workflow transition instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ency workflow transition instances
	 */
	@Override
	public List<EncyWorkflowTransitionInstance> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowTransitionInstance> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<EncyWorkflowTransitionInstance> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowTransitionInstance>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ENCYWORKFLOWTRANSITIONINSTANCE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ENCYWORKFLOWTRANSITIONINSTANCE;

				sql = sql.concat(
					EncyWorkflowTransitionInstanceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EncyWorkflowTransitionInstance>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the ency workflow transition instances from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EncyWorkflowTransitionInstance encyWorkflowTransitionInstance :
				findAll()) {

			remove(encyWorkflowTransitionInstance);
		}
	}

	/**
	 * Returns the number of ency workflow transition instances.
	 *
	 * @return the number of ency workflow transition instances
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_ENCYWORKFLOWTRANSITIONINSTANCE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "transitionInstanceId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ENCYWORKFLOWTRANSITIONINSTANCE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EncyWorkflowTransitionInstanceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ency workflow transition instance persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByWorkflowInstanceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByWorkflowInstanceId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"workflowInstanceId"}, true);

		_finderPathWithoutPaginationFindByWorkflowInstanceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByWorkflowInstanceId", new String[] {Long.class.getName()},
			new String[] {"workflowInstanceId"}, true);

		_finderPathCountByWorkflowInstanceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByWorkflowInstanceId", new String[] {Long.class.getName()},
			new String[] {"workflowInstanceId"}, false);

		_setEncyWorkflowTransitionInstanceUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setEncyWorkflowTransitionInstanceUtilPersistence(null);

		entityCache.removeCache(
			EncyWorkflowTransitionInstanceImpl.class.getName());
	}

	private void _setEncyWorkflowTransitionInstanceUtilPersistence(
		EncyWorkflowTransitionInstancePersistence
			encyWorkflowTransitionInstancePersistence) {

		try {
			Field field =
				EncyWorkflowTransitionInstanceUtil.class.getDeclaredField(
					"_persistence");

			field.setAccessible(true);

			field.set(null, encyWorkflowTransitionInstancePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = EncyWorkflowPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = EncyWorkflowPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = EncyWorkflowPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ENCYWORKFLOWTRANSITIONINSTANCE =
		"SELECT encyWorkflowTransitionInstance FROM EncyWorkflowTransitionInstance encyWorkflowTransitionInstance";

	private static final String
		_SQL_SELECT_ENCYWORKFLOWTRANSITIONINSTANCE_WHERE =
			"SELECT encyWorkflowTransitionInstance FROM EncyWorkflowTransitionInstance encyWorkflowTransitionInstance WHERE ";

	private static final String _SQL_COUNT_ENCYWORKFLOWTRANSITIONINSTANCE =
		"SELECT COUNT(encyWorkflowTransitionInstance) FROM EncyWorkflowTransitionInstance encyWorkflowTransitionInstance";

	private static final String
		_SQL_COUNT_ENCYWORKFLOWTRANSITIONINSTANCE_WHERE =
			"SELECT COUNT(encyWorkflowTransitionInstance) FROM EncyWorkflowTransitionInstance encyWorkflowTransitionInstance WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"encyWorkflowTransitionInstance.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EncyWorkflowTransitionInstance exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EncyWorkflowTransitionInstance exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EncyWorkflowTransitionInstancePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "comment"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private EncyWorkflowTransitionInstanceModelArgumentsResolver
		_encyWorkflowTransitionInstanceModelArgumentsResolver;

}