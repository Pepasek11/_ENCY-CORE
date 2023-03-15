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

import cz.csob.ency.workflow.exception.NoSuchInstanceException;
import cz.csob.ency.workflow.model.EncyWorkflowInstance;
import cz.csob.ency.workflow.model.EncyWorkflowInstanceTable;
import cz.csob.ency.workflow.model.impl.EncyWorkflowInstanceImpl;
import cz.csob.ency.workflow.model.impl.EncyWorkflowInstanceModelImpl;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowInstancePersistence;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowInstanceUtil;
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
 * The persistence implementation for the ency workflow instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @generated
 */
@Component(
	service = {EncyWorkflowInstancePersistence.class, BasePersistence.class}
)
public class EncyWorkflowInstancePersistenceImpl
	extends BasePersistenceImpl<EncyWorkflowInstance>
	implements EncyWorkflowInstancePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EncyWorkflowInstanceUtil</code> to access the ency workflow instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EncyWorkflowInstanceImpl.class.getName();

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
	 * Returns all the ency workflow instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ency workflow instances
	 */
	@Override
	public List<EncyWorkflowInstance> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @return the range of matching ency workflow instances
	 */
	@Override
	public List<EncyWorkflowInstance> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow instances
	 */
	@Override
	public List<EncyWorkflowInstance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowInstance> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow instances
	 */
	@Override
	public List<EncyWorkflowInstance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowInstance> orderByComparator,
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

		List<EncyWorkflowInstance> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowInstance>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowInstance encyWorkflowInstance : list) {
					if (!uuid.equals(encyWorkflowInstance.getUuid())) {
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

			sb.append(_SQL_SELECT_ENCYWORKFLOWINSTANCE_WHERE);

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
				sb.append(EncyWorkflowInstanceModelImpl.ORDER_BY_JPQL);
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

				list = (List<EncyWorkflowInstance>)QueryUtil.list(
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
	 * Returns the first ency workflow instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow instance
	 * @throws NoSuchInstanceException if a matching ency workflow instance could not be found
	 */
	@Override
	public EncyWorkflowInstance findByUuid_First(
			String uuid,
			OrderByComparator<EncyWorkflowInstance> orderByComparator)
		throws NoSuchInstanceException {

		EncyWorkflowInstance encyWorkflowInstance = fetchByUuid_First(
			uuid, orderByComparator);

		if (encyWorkflowInstance != null) {
			return encyWorkflowInstance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchInstanceException(sb.toString());
	}

	/**
	 * Returns the first ency workflow instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	@Override
	public EncyWorkflowInstance fetchByUuid_First(
		String uuid,
		OrderByComparator<EncyWorkflowInstance> orderByComparator) {

		List<EncyWorkflowInstance> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow instance
	 * @throws NoSuchInstanceException if a matching ency workflow instance could not be found
	 */
	@Override
	public EncyWorkflowInstance findByUuid_Last(
			String uuid,
			OrderByComparator<EncyWorkflowInstance> orderByComparator)
		throws NoSuchInstanceException {

		EncyWorkflowInstance encyWorkflowInstance = fetchByUuid_Last(
			uuid, orderByComparator);

		if (encyWorkflowInstance != null) {
			return encyWorkflowInstance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchInstanceException(sb.toString());
	}

	/**
	 * Returns the last ency workflow instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	@Override
	public EncyWorkflowInstance fetchByUuid_Last(
		String uuid,
		OrderByComparator<EncyWorkflowInstance> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflowInstance> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflow instances before and after the current ency workflow instance in the ordered set where uuid = &#63;.
	 *
	 * @param workflowInstanceId the primary key of the current ency workflow instance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow instance
	 * @throws NoSuchInstanceException if a ency workflow instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowInstance[] findByUuid_PrevAndNext(
			long workflowInstanceId, String uuid,
			OrderByComparator<EncyWorkflowInstance> orderByComparator)
		throws NoSuchInstanceException {

		uuid = Objects.toString(uuid, "");

		EncyWorkflowInstance encyWorkflowInstance = findByPrimaryKey(
			workflowInstanceId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowInstance[] array = new EncyWorkflowInstanceImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, encyWorkflowInstance, uuid, orderByComparator, true);

			array[1] = encyWorkflowInstance;

			array[2] = getByUuid_PrevAndNext(
				session, encyWorkflowInstance, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EncyWorkflowInstance getByUuid_PrevAndNext(
		Session session, EncyWorkflowInstance encyWorkflowInstance, String uuid,
		OrderByComparator<EncyWorkflowInstance> orderByComparator,
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

		sb.append(_SQL_SELECT_ENCYWORKFLOWINSTANCE_WHERE);

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
			sb.append(EncyWorkflowInstanceModelImpl.ORDER_BY_JPQL);
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
						encyWorkflowInstance)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflowInstance> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ency workflow instances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EncyWorkflowInstance encyWorkflowInstance :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(encyWorkflowInstance);
		}
	}

	/**
	 * Returns the number of ency workflow instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ency workflow instances
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ENCYWORKFLOWINSTANCE_WHERE);

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
		"encyWorkflowInstance.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(encyWorkflowInstance.uuid IS NULL OR encyWorkflowInstance.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the ency workflow instance where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchInstanceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow instance
	 * @throws NoSuchInstanceException if a matching ency workflow instance could not be found
	 */
	@Override
	public EncyWorkflowInstance findByUUID_G(String uuid, long groupId)
		throws NoSuchInstanceException {

		EncyWorkflowInstance encyWorkflowInstance = fetchByUUID_G(
			uuid, groupId);

		if (encyWorkflowInstance == null) {
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

			throw new NoSuchInstanceException(sb.toString());
		}

		return encyWorkflowInstance;
	}

	/**
	 * Returns the ency workflow instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	@Override
	public EncyWorkflowInstance fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the ency workflow instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	@Override
	public EncyWorkflowInstance fetchByUUID_G(
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

		if (result instanceof EncyWorkflowInstance) {
			EncyWorkflowInstance encyWorkflowInstance =
				(EncyWorkflowInstance)result;

			if (!Objects.equals(uuid, encyWorkflowInstance.getUuid()) ||
				(groupId != encyWorkflowInstance.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ENCYWORKFLOWINSTANCE_WHERE);

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

				List<EncyWorkflowInstance> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					EncyWorkflowInstance encyWorkflowInstance = list.get(0);

					result = encyWorkflowInstance;

					cacheResult(encyWorkflowInstance);
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
			return (EncyWorkflowInstance)result;
		}
	}

	/**
	 * Removes the ency workflow instance where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ency workflow instance that was removed
	 */
	@Override
	public EncyWorkflowInstance removeByUUID_G(String uuid, long groupId)
		throws NoSuchInstanceException {

		EncyWorkflowInstance encyWorkflowInstance = findByUUID_G(uuid, groupId);

		return remove(encyWorkflowInstance);
	}

	/**
	 * Returns the number of ency workflow instances where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ency workflow instances
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ENCYWORKFLOWINSTANCE_WHERE);

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
		"encyWorkflowInstance.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(encyWorkflowInstance.uuid IS NULL OR encyWorkflowInstance.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"encyWorkflowInstance.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the ency workflow instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ency workflow instances
	 */
	@Override
	public List<EncyWorkflowInstance> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @return the range of matching ency workflow instances
	 */
	@Override
	public List<EncyWorkflowInstance> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow instances
	 */
	@Override
	public List<EncyWorkflowInstance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EncyWorkflowInstance> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow instances
	 */
	@Override
	public List<EncyWorkflowInstance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EncyWorkflowInstance> orderByComparator,
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

		List<EncyWorkflowInstance> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowInstance>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowInstance encyWorkflowInstance : list) {
					if (!uuid.equals(encyWorkflowInstance.getUuid()) ||
						(companyId != encyWorkflowInstance.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ENCYWORKFLOWINSTANCE_WHERE);

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
				sb.append(EncyWorkflowInstanceModelImpl.ORDER_BY_JPQL);
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

				list = (List<EncyWorkflowInstance>)QueryUtil.list(
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
	 * Returns the first ency workflow instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow instance
	 * @throws NoSuchInstanceException if a matching ency workflow instance could not be found
	 */
	@Override
	public EncyWorkflowInstance findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EncyWorkflowInstance> orderByComparator)
		throws NoSuchInstanceException {

		EncyWorkflowInstance encyWorkflowInstance = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (encyWorkflowInstance != null) {
			return encyWorkflowInstance;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchInstanceException(sb.toString());
	}

	/**
	 * Returns the first ency workflow instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	@Override
	public EncyWorkflowInstance fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EncyWorkflowInstance> orderByComparator) {

		List<EncyWorkflowInstance> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow instance
	 * @throws NoSuchInstanceException if a matching ency workflow instance could not be found
	 */
	@Override
	public EncyWorkflowInstance findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EncyWorkflowInstance> orderByComparator)
		throws NoSuchInstanceException {

		EncyWorkflowInstance encyWorkflowInstance = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (encyWorkflowInstance != null) {
			return encyWorkflowInstance;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchInstanceException(sb.toString());
	}

	/**
	 * Returns the last ency workflow instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	@Override
	public EncyWorkflowInstance fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EncyWorkflowInstance> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflowInstance> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflow instances before and after the current ency workflow instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param workflowInstanceId the primary key of the current ency workflow instance
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow instance
	 * @throws NoSuchInstanceException if a ency workflow instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowInstance[] findByUuid_C_PrevAndNext(
			long workflowInstanceId, String uuid, long companyId,
			OrderByComparator<EncyWorkflowInstance> orderByComparator)
		throws NoSuchInstanceException {

		uuid = Objects.toString(uuid, "");

		EncyWorkflowInstance encyWorkflowInstance = findByPrimaryKey(
			workflowInstanceId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowInstance[] array = new EncyWorkflowInstanceImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, encyWorkflowInstance, uuid, companyId,
				orderByComparator, true);

			array[1] = encyWorkflowInstance;

			array[2] = getByUuid_C_PrevAndNext(
				session, encyWorkflowInstance, uuid, companyId,
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

	protected EncyWorkflowInstance getByUuid_C_PrevAndNext(
		Session session, EncyWorkflowInstance encyWorkflowInstance, String uuid,
		long companyId,
		OrderByComparator<EncyWorkflowInstance> orderByComparator,
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

		sb.append(_SQL_SELECT_ENCYWORKFLOWINSTANCE_WHERE);

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
			sb.append(EncyWorkflowInstanceModelImpl.ORDER_BY_JPQL);
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
						encyWorkflowInstance)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflowInstance> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ency workflow instances where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (EncyWorkflowInstance encyWorkflowInstance :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(encyWorkflowInstance);
		}
	}

	/**
	 * Returns the number of ency workflow instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ency workflow instances
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ENCYWORKFLOWINSTANCE_WHERE);

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
		"encyWorkflowInstance.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(encyWorkflowInstance.uuid IS NULL OR encyWorkflowInstance.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"encyWorkflowInstance.companyId = ?";

	private FinderPath _finderPathFetchByC_C;
	private FinderPath _finderPathCountByC_C;

	/**
	 * Returns the ency workflow instance where className = &#63; and classPK = &#63; or throws a <code>NoSuchInstanceException</code> if it could not be found.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the matching ency workflow instance
	 * @throws NoSuchInstanceException if a matching ency workflow instance could not be found
	 */
	@Override
	public EncyWorkflowInstance findByC_C(String className, long classPK)
		throws NoSuchInstanceException {

		EncyWorkflowInstance encyWorkflowInstance = fetchByC_C(
			className, classPK);

		if (encyWorkflowInstance == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("className=");
			sb.append(className);

			sb.append(", classPK=");
			sb.append(classPK);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchInstanceException(sb.toString());
		}

		return encyWorkflowInstance;
	}

	/**
	 * Returns the ency workflow instance where className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	@Override
	public EncyWorkflowInstance fetchByC_C(String className, long classPK) {
		return fetchByC_C(className, classPK, true);
	}

	/**
	 * Returns the ency workflow instance where className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	@Override
	public EncyWorkflowInstance fetchByC_C(
		String className, long classPK, boolean useFinderCache) {

		className = Objects.toString(className, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {className, classPK};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByC_C, finderArgs);
		}

		if (result instanceof EncyWorkflowInstance) {
			EncyWorkflowInstance encyWorkflowInstance =
				(EncyWorkflowInstance)result;

			if (!Objects.equals(
					className, encyWorkflowInstance.getClassName()) ||
				(classPK != encyWorkflowInstance.getClassPK())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ENCYWORKFLOWINSTANCE_WHERE);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_C_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(_FINDER_COLUMN_C_C_CLASSNAME_2);
			}

			sb.append(_FINDER_COLUMN_C_C_CLASSPK_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindClassName) {
					queryPos.add(className);
				}

				queryPos.add(classPK);

				List<EncyWorkflowInstance> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_C, finderArgs, list);
					}
				}
				else {
					EncyWorkflowInstance encyWorkflowInstance = list.get(0);

					result = encyWorkflowInstance;

					cacheResult(encyWorkflowInstance);
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
			return (EncyWorkflowInstance)result;
		}
	}

	/**
	 * Removes the ency workflow instance where className = &#63; and classPK = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the ency workflow instance that was removed
	 */
	@Override
	public EncyWorkflowInstance removeByC_C(String className, long classPK)
		throws NoSuchInstanceException {

		EncyWorkflowInstance encyWorkflowInstance = findByC_C(
			className, classPK);

		return remove(encyWorkflowInstance);
	}

	/**
	 * Returns the number of ency workflow instances where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the number of matching ency workflow instances
	 */
	@Override
	public int countByC_C(String className, long classPK) {
		className = Objects.toString(className, "");

		FinderPath finderPath = _finderPathCountByC_C;

		Object[] finderArgs = new Object[] {className, classPK};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ENCYWORKFLOWINSTANCE_WHERE);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_C_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(_FINDER_COLUMN_C_C_CLASSNAME_2);
			}

			sb.append(_FINDER_COLUMN_C_C_CLASSPK_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindClassName) {
					queryPos.add(className);
				}

				queryPos.add(classPK);

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

	private static final String _FINDER_COLUMN_C_C_CLASSNAME_2 =
		"encyWorkflowInstance.className = ? AND ";

	private static final String _FINDER_COLUMN_C_C_CLASSNAME_3 =
		"(encyWorkflowInstance.className IS NULL OR encyWorkflowInstance.className = '') AND ";

	private static final String _FINDER_COLUMN_C_C_CLASSPK_2 =
		"encyWorkflowInstance.classPK = ?";

	public EncyWorkflowInstancePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EncyWorkflowInstance.class);

		setModelImplClass(EncyWorkflowInstanceImpl.class);
		setModelPKClass(long.class);

		setTable(EncyWorkflowInstanceTable.INSTANCE);
	}

	/**
	 * Caches the ency workflow instance in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowInstance the ency workflow instance
	 */
	@Override
	public void cacheResult(EncyWorkflowInstance encyWorkflowInstance) {
		entityCache.putResult(
			EncyWorkflowInstanceImpl.class,
			encyWorkflowInstance.getPrimaryKey(), encyWorkflowInstance);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				encyWorkflowInstance.getUuid(),
				encyWorkflowInstance.getGroupId()
			},
			encyWorkflowInstance);

		finderCache.putResult(
			_finderPathFetchByC_C,
			new Object[] {
				encyWorkflowInstance.getClassName(),
				encyWorkflowInstance.getClassPK()
			},
			encyWorkflowInstance);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the ency workflow instances in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowInstances the ency workflow instances
	 */
	@Override
	public void cacheResult(List<EncyWorkflowInstance> encyWorkflowInstances) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (encyWorkflowInstances.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EncyWorkflowInstance encyWorkflowInstance :
				encyWorkflowInstances) {

			if (entityCache.getResult(
					EncyWorkflowInstanceImpl.class,
					encyWorkflowInstance.getPrimaryKey()) == null) {

				cacheResult(encyWorkflowInstance);
			}
		}
	}

	/**
	 * Clears the cache for all ency workflow instances.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EncyWorkflowInstanceImpl.class);

		finderCache.clearCache(EncyWorkflowInstanceImpl.class);
	}

	/**
	 * Clears the cache for the ency workflow instance.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EncyWorkflowInstance encyWorkflowInstance) {
		entityCache.removeResult(
			EncyWorkflowInstanceImpl.class, encyWorkflowInstance);
	}

	@Override
	public void clearCache(List<EncyWorkflowInstance> encyWorkflowInstances) {
		for (EncyWorkflowInstance encyWorkflowInstance :
				encyWorkflowInstances) {

			entityCache.removeResult(
				EncyWorkflowInstanceImpl.class, encyWorkflowInstance);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EncyWorkflowInstanceImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				EncyWorkflowInstanceImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EncyWorkflowInstanceModelImpl encyWorkflowInstanceModelImpl) {

		Object[] args = new Object[] {
			encyWorkflowInstanceModelImpl.getUuid(),
			encyWorkflowInstanceModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, encyWorkflowInstanceModelImpl);

		args = new Object[] {
			encyWorkflowInstanceModelImpl.getClassName(),
			encyWorkflowInstanceModelImpl.getClassPK()
		};

		finderCache.putResult(_finderPathCountByC_C, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_C, args, encyWorkflowInstanceModelImpl);
	}

	/**
	 * Creates a new ency workflow instance with the primary key. Does not add the ency workflow instance to the database.
	 *
	 * @param workflowInstanceId the primary key for the new ency workflow instance
	 * @return the new ency workflow instance
	 */
	@Override
	public EncyWorkflowInstance create(long workflowInstanceId) {
		EncyWorkflowInstance encyWorkflowInstance =
			new EncyWorkflowInstanceImpl();

		encyWorkflowInstance.setNew(true);
		encyWorkflowInstance.setPrimaryKey(workflowInstanceId);

		String uuid = _portalUUID.generate();

		encyWorkflowInstance.setUuid(uuid);

		encyWorkflowInstance.setCompanyId(CompanyThreadLocal.getCompanyId());

		return encyWorkflowInstance;
	}

	/**
	 * Removes the ency workflow instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workflowInstanceId the primary key of the ency workflow instance
	 * @return the ency workflow instance that was removed
	 * @throws NoSuchInstanceException if a ency workflow instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowInstance remove(long workflowInstanceId)
		throws NoSuchInstanceException {

		return remove((Serializable)workflowInstanceId);
	}

	/**
	 * Removes the ency workflow instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ency workflow instance
	 * @return the ency workflow instance that was removed
	 * @throws NoSuchInstanceException if a ency workflow instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowInstance remove(Serializable primaryKey)
		throws NoSuchInstanceException {

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowInstance encyWorkflowInstance =
				(EncyWorkflowInstance)session.get(
					EncyWorkflowInstanceImpl.class, primaryKey);

			if (encyWorkflowInstance == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInstanceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(encyWorkflowInstance);
		}
		catch (NoSuchInstanceException noSuchEntityException) {
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
	protected EncyWorkflowInstance removeImpl(
		EncyWorkflowInstance encyWorkflowInstance) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(encyWorkflowInstance)) {
				encyWorkflowInstance = (EncyWorkflowInstance)session.get(
					EncyWorkflowInstanceImpl.class,
					encyWorkflowInstance.getPrimaryKeyObj());
			}

			if (encyWorkflowInstance != null) {
				session.delete(encyWorkflowInstance);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (encyWorkflowInstance != null) {
			clearCache(encyWorkflowInstance);
		}

		return encyWorkflowInstance;
	}

	@Override
	public EncyWorkflowInstance updateImpl(
		EncyWorkflowInstance encyWorkflowInstance) {

		boolean isNew = encyWorkflowInstance.isNew();

		if (!(encyWorkflowInstance instanceof EncyWorkflowInstanceModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(encyWorkflowInstance.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					encyWorkflowInstance);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in encyWorkflowInstance proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EncyWorkflowInstance implementation " +
					encyWorkflowInstance.getClass());
		}

		EncyWorkflowInstanceModelImpl encyWorkflowInstanceModelImpl =
			(EncyWorkflowInstanceModelImpl)encyWorkflowInstance;

		if (Validator.isNull(encyWorkflowInstance.getUuid())) {
			String uuid = _portalUUID.generate();

			encyWorkflowInstance.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (encyWorkflowInstance.getCreateDate() == null)) {
			if (serviceContext == null) {
				encyWorkflowInstance.setCreateDate(date);
			}
			else {
				encyWorkflowInstance.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!encyWorkflowInstanceModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				encyWorkflowInstance.setModifiedDate(date);
			}
			else {
				encyWorkflowInstance.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(encyWorkflowInstance);
			}
			else {
				encyWorkflowInstance = (EncyWorkflowInstance)session.merge(
					encyWorkflowInstance);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EncyWorkflowInstanceImpl.class, encyWorkflowInstanceModelImpl,
			false, true);

		cacheUniqueFindersCache(encyWorkflowInstanceModelImpl);

		if (isNew) {
			encyWorkflowInstance.setNew(false);
		}

		encyWorkflowInstance.resetOriginalValues();

		return encyWorkflowInstance;
	}

	/**
	 * Returns the ency workflow instance with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ency workflow instance
	 * @return the ency workflow instance
	 * @throws NoSuchInstanceException if a ency workflow instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowInstance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInstanceException {

		EncyWorkflowInstance encyWorkflowInstance = fetchByPrimaryKey(
			primaryKey);

		if (encyWorkflowInstance == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInstanceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return encyWorkflowInstance;
	}

	/**
	 * Returns the ency workflow instance with the primary key or throws a <code>NoSuchInstanceException</code> if it could not be found.
	 *
	 * @param workflowInstanceId the primary key of the ency workflow instance
	 * @return the ency workflow instance
	 * @throws NoSuchInstanceException if a ency workflow instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowInstance findByPrimaryKey(long workflowInstanceId)
		throws NoSuchInstanceException {

		return findByPrimaryKey((Serializable)workflowInstanceId);
	}

	/**
	 * Returns the ency workflow instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workflowInstanceId the primary key of the ency workflow instance
	 * @return the ency workflow instance, or <code>null</code> if a ency workflow instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowInstance fetchByPrimaryKey(long workflowInstanceId) {
		return fetchByPrimaryKey((Serializable)workflowInstanceId);
	}

	/**
	 * Returns all the ency workflow instances.
	 *
	 * @return the ency workflow instances
	 */
	@Override
	public List<EncyWorkflowInstance> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @return the range of ency workflow instances
	 */
	@Override
	public List<EncyWorkflowInstance> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ency workflow instances
	 */
	@Override
	public List<EncyWorkflowInstance> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowInstance> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ency workflow instances
	 */
	@Override
	public List<EncyWorkflowInstance> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowInstance> orderByComparator,
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

		List<EncyWorkflowInstance> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowInstance>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ENCYWORKFLOWINSTANCE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ENCYWORKFLOWINSTANCE;

				sql = sql.concat(EncyWorkflowInstanceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EncyWorkflowInstance>)QueryUtil.list(
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
	 * Removes all the ency workflow instances from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EncyWorkflowInstance encyWorkflowInstance : findAll()) {
			remove(encyWorkflowInstance);
		}
	}

	/**
	 * Returns the number of ency workflow instances.
	 *
	 * @return the number of ency workflow instances
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
					_SQL_COUNT_ENCYWORKFLOWINSTANCE);

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
		return "workflowInstanceId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ENCYWORKFLOWINSTANCE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EncyWorkflowInstanceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ency workflow instance persistence.
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

		_finderPathFetchByC_C = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"className", "classPK"}, true);

		_finderPathCountByC_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"className", "classPK"}, false);

		_setEncyWorkflowInstanceUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setEncyWorkflowInstanceUtilPersistence(null);

		entityCache.removeCache(EncyWorkflowInstanceImpl.class.getName());
	}

	private void _setEncyWorkflowInstanceUtilPersistence(
		EncyWorkflowInstancePersistence encyWorkflowInstancePersistence) {

		try {
			Field field = EncyWorkflowInstanceUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, encyWorkflowInstancePersistence);
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

	private static final String _SQL_SELECT_ENCYWORKFLOWINSTANCE =
		"SELECT encyWorkflowInstance FROM EncyWorkflowInstance encyWorkflowInstance";

	private static final String _SQL_SELECT_ENCYWORKFLOWINSTANCE_WHERE =
		"SELECT encyWorkflowInstance FROM EncyWorkflowInstance encyWorkflowInstance WHERE ";

	private static final String _SQL_COUNT_ENCYWORKFLOWINSTANCE =
		"SELECT COUNT(encyWorkflowInstance) FROM EncyWorkflowInstance encyWorkflowInstance";

	private static final String _SQL_COUNT_ENCYWORKFLOWINSTANCE_WHERE =
		"SELECT COUNT(encyWorkflowInstance) FROM EncyWorkflowInstance encyWorkflowInstance WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"encyWorkflowInstance.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EncyWorkflowInstance exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EncyWorkflowInstance exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EncyWorkflowInstancePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private EncyWorkflowInstanceModelArgumentsResolver
		_encyWorkflowInstanceModelArgumentsResolver;

}