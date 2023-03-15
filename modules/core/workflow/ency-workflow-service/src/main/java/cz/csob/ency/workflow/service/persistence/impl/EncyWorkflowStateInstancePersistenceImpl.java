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

import cz.csob.ency.workflow.exception.NoSuchStateInstanceException;
import cz.csob.ency.workflow.model.EncyWorkflowStateInstance;
import cz.csob.ency.workflow.model.EncyWorkflowStateInstanceTable;
import cz.csob.ency.workflow.model.impl.EncyWorkflowStateInstanceImpl;
import cz.csob.ency.workflow.model.impl.EncyWorkflowStateInstanceModelImpl;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowStateInstancePersistence;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowStateInstanceUtil;
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
 * The persistence implementation for the ency workflow state instance service.
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
		EncyWorkflowStateInstancePersistence.class, BasePersistence.class
	}
)
public class EncyWorkflowStateInstancePersistenceImpl
	extends BasePersistenceImpl<EncyWorkflowStateInstance>
	implements EncyWorkflowStateInstancePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EncyWorkflowStateInstanceUtil</code> to access the ency workflow state instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EncyWorkflowStateInstanceImpl.class.getName();

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
	 * Returns all the ency workflow state instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ency workflow state instances
	 */
	@Override
	public List<EncyWorkflowStateInstance> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow state instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @return the range of matching ency workflow state instances
	 */
	@Override
	public List<EncyWorkflowStateInstance> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow state instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow state instances
	 */
	@Override
	public List<EncyWorkflowStateInstance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow state instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow state instances
	 */
	@Override
	public List<EncyWorkflowStateInstance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator,
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

		List<EncyWorkflowStateInstance> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowStateInstance>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowStateInstance encyWorkflowStateInstance :
						list) {

					if (!uuid.equals(encyWorkflowStateInstance.getUuid())) {
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

			sb.append(_SQL_SELECT_ENCYWORKFLOWSTATEINSTANCE_WHERE);

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
				sb.append(EncyWorkflowStateInstanceModelImpl.ORDER_BY_JPQL);
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

				list = (List<EncyWorkflowStateInstance>)QueryUtil.list(
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
	 * Returns the first ency workflow state instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	@Override
	public EncyWorkflowStateInstance findByUuid_First(
			String uuid,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException {

		EncyWorkflowStateInstance encyWorkflowStateInstance = fetchByUuid_First(
			uuid, orderByComparator);

		if (encyWorkflowStateInstance != null) {
			return encyWorkflowStateInstance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchStateInstanceException(sb.toString());
	}

	/**
	 * Returns the first ency workflow state instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	@Override
	public EncyWorkflowStateInstance fetchByUuid_First(
		String uuid,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		List<EncyWorkflowStateInstance> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow state instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	@Override
	public EncyWorkflowStateInstance findByUuid_Last(
			String uuid,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException {

		EncyWorkflowStateInstance encyWorkflowStateInstance = fetchByUuid_Last(
			uuid, orderByComparator);

		if (encyWorkflowStateInstance != null) {
			return encyWorkflowStateInstance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchStateInstanceException(sb.toString());
	}

	/**
	 * Returns the last ency workflow state instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	@Override
	public EncyWorkflowStateInstance fetchByUuid_Last(
		String uuid,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflowStateInstance> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflow state instances before and after the current ency workflow state instance in the ordered set where uuid = &#63;.
	 *
	 * @param stateInstanceId the primary key of the current ency workflow state instance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow state instance
	 * @throws NoSuchStateInstanceException if a ency workflow state instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowStateInstance[] findByUuid_PrevAndNext(
			long stateInstanceId, String uuid,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException {

		uuid = Objects.toString(uuid, "");

		EncyWorkflowStateInstance encyWorkflowStateInstance = findByPrimaryKey(
			stateInstanceId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowStateInstance[] array =
				new EncyWorkflowStateInstanceImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, encyWorkflowStateInstance, uuid, orderByComparator,
				true);

			array[1] = encyWorkflowStateInstance;

			array[2] = getByUuid_PrevAndNext(
				session, encyWorkflowStateInstance, uuid, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EncyWorkflowStateInstance getByUuid_PrevAndNext(
		Session session, EncyWorkflowStateInstance encyWorkflowStateInstance,
		String uuid,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator,
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

		sb.append(_SQL_SELECT_ENCYWORKFLOWSTATEINSTANCE_WHERE);

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
			sb.append(EncyWorkflowStateInstanceModelImpl.ORDER_BY_JPQL);
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
						encyWorkflowStateInstance)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflowStateInstance> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ency workflow state instances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EncyWorkflowStateInstance encyWorkflowStateInstance :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(encyWorkflowStateInstance);
		}
	}

	/**
	 * Returns the number of ency workflow state instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ency workflow state instances
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ENCYWORKFLOWSTATEINSTANCE_WHERE);

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
		"encyWorkflowStateInstance.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(encyWorkflowStateInstance.uuid IS NULL OR encyWorkflowStateInstance.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the ency workflow state instance where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchStateInstanceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	@Override
	public EncyWorkflowStateInstance findByUUID_G(String uuid, long groupId)
		throws NoSuchStateInstanceException {

		EncyWorkflowStateInstance encyWorkflowStateInstance = fetchByUUID_G(
			uuid, groupId);

		if (encyWorkflowStateInstance == null) {
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

			throw new NoSuchStateInstanceException(sb.toString());
		}

		return encyWorkflowStateInstance;
	}

	/**
	 * Returns the ency workflow state instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	@Override
	public EncyWorkflowStateInstance fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the ency workflow state instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	@Override
	public EncyWorkflowStateInstance fetchByUUID_G(
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

		if (result instanceof EncyWorkflowStateInstance) {
			EncyWorkflowStateInstance encyWorkflowStateInstance =
				(EncyWorkflowStateInstance)result;

			if (!Objects.equals(uuid, encyWorkflowStateInstance.getUuid()) ||
				(groupId != encyWorkflowStateInstance.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ENCYWORKFLOWSTATEINSTANCE_WHERE);

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

				List<EncyWorkflowStateInstance> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					EncyWorkflowStateInstance encyWorkflowStateInstance =
						list.get(0);

					result = encyWorkflowStateInstance;

					cacheResult(encyWorkflowStateInstance);
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
			return (EncyWorkflowStateInstance)result;
		}
	}

	/**
	 * Removes the ency workflow state instance where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ency workflow state instance that was removed
	 */
	@Override
	public EncyWorkflowStateInstance removeByUUID_G(String uuid, long groupId)
		throws NoSuchStateInstanceException {

		EncyWorkflowStateInstance encyWorkflowStateInstance = findByUUID_G(
			uuid, groupId);

		return remove(encyWorkflowStateInstance);
	}

	/**
	 * Returns the number of ency workflow state instances where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ency workflow state instances
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ENCYWORKFLOWSTATEINSTANCE_WHERE);

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
		"encyWorkflowStateInstance.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(encyWorkflowStateInstance.uuid IS NULL OR encyWorkflowStateInstance.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"encyWorkflowStateInstance.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the ency workflow state instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ency workflow state instances
	 */
	@Override
	public List<EncyWorkflowStateInstance> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow state instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @return the range of matching ency workflow state instances
	 */
	@Override
	public List<EncyWorkflowStateInstance> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow state instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow state instances
	 */
	@Override
	public List<EncyWorkflowStateInstance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow state instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow state instances
	 */
	@Override
	public List<EncyWorkflowStateInstance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator,
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

		List<EncyWorkflowStateInstance> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowStateInstance>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowStateInstance encyWorkflowStateInstance :
						list) {

					if (!uuid.equals(encyWorkflowStateInstance.getUuid()) ||
						(companyId !=
							encyWorkflowStateInstance.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ENCYWORKFLOWSTATEINSTANCE_WHERE);

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
				sb.append(EncyWorkflowStateInstanceModelImpl.ORDER_BY_JPQL);
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

				list = (List<EncyWorkflowStateInstance>)QueryUtil.list(
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
	 * Returns the first ency workflow state instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	@Override
	public EncyWorkflowStateInstance findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException {

		EncyWorkflowStateInstance encyWorkflowStateInstance =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (encyWorkflowStateInstance != null) {
			return encyWorkflowStateInstance;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchStateInstanceException(sb.toString());
	}

	/**
	 * Returns the first ency workflow state instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	@Override
	public EncyWorkflowStateInstance fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		List<EncyWorkflowStateInstance> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow state instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	@Override
	public EncyWorkflowStateInstance findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException {

		EncyWorkflowStateInstance encyWorkflowStateInstance =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (encyWorkflowStateInstance != null) {
			return encyWorkflowStateInstance;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchStateInstanceException(sb.toString());
	}

	/**
	 * Returns the last ency workflow state instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	@Override
	public EncyWorkflowStateInstance fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflowStateInstance> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflow state instances before and after the current ency workflow state instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param stateInstanceId the primary key of the current ency workflow state instance
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow state instance
	 * @throws NoSuchStateInstanceException if a ency workflow state instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowStateInstance[] findByUuid_C_PrevAndNext(
			long stateInstanceId, String uuid, long companyId,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException {

		uuid = Objects.toString(uuid, "");

		EncyWorkflowStateInstance encyWorkflowStateInstance = findByPrimaryKey(
			stateInstanceId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowStateInstance[] array =
				new EncyWorkflowStateInstanceImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, encyWorkflowStateInstance, uuid, companyId,
				orderByComparator, true);

			array[1] = encyWorkflowStateInstance;

			array[2] = getByUuid_C_PrevAndNext(
				session, encyWorkflowStateInstance, uuid, companyId,
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

	protected EncyWorkflowStateInstance getByUuid_C_PrevAndNext(
		Session session, EncyWorkflowStateInstance encyWorkflowStateInstance,
		String uuid, long companyId,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator,
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

		sb.append(_SQL_SELECT_ENCYWORKFLOWSTATEINSTANCE_WHERE);

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
			sb.append(EncyWorkflowStateInstanceModelImpl.ORDER_BY_JPQL);
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
						encyWorkflowStateInstance)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflowStateInstance> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ency workflow state instances where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (EncyWorkflowStateInstance encyWorkflowStateInstance :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(encyWorkflowStateInstance);
		}
	}

	/**
	 * Returns the number of ency workflow state instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ency workflow state instances
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ENCYWORKFLOWSTATEINSTANCE_WHERE);

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
		"encyWorkflowStateInstance.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(encyWorkflowStateInstance.uuid IS NULL OR encyWorkflowStateInstance.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"encyWorkflowStateInstance.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByWorkflowInstanceId;
	private FinderPath _finderPathWithoutPaginationFindByWorkflowInstanceId;
	private FinderPath _finderPathCountByWorkflowInstanceId;

	/**
	 * Returns all the ency workflow state instances where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @return the matching ency workflow state instances
	 */
	@Override
	public List<EncyWorkflowStateInstance> findByWorkflowInstanceId(
		long workflowInstanceId) {

		return findByWorkflowInstanceId(
			workflowInstanceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow state instances where workflowInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @return the range of matching ency workflow state instances
	 */
	@Override
	public List<EncyWorkflowStateInstance> findByWorkflowInstanceId(
		long workflowInstanceId, int start, int end) {

		return findByWorkflowInstanceId(workflowInstanceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow state instances where workflowInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow state instances
	 */
	@Override
	public List<EncyWorkflowStateInstance> findByWorkflowInstanceId(
		long workflowInstanceId, int start, int end,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		return findByWorkflowInstanceId(
			workflowInstanceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow state instances where workflowInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow state instances
	 */
	@Override
	public List<EncyWorkflowStateInstance> findByWorkflowInstanceId(
		long workflowInstanceId, int start, int end,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator,
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

		List<EncyWorkflowStateInstance> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowStateInstance>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowStateInstance encyWorkflowStateInstance :
						list) {

					if (workflowInstanceId !=
							encyWorkflowStateInstance.getWorkflowInstanceId()) {

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

			sb.append(_SQL_SELECT_ENCYWORKFLOWSTATEINSTANCE_WHERE);

			sb.append(_FINDER_COLUMN_WORKFLOWINSTANCEID_WORKFLOWINSTANCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EncyWorkflowStateInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workflowInstanceId);

				list = (List<EncyWorkflowStateInstance>)QueryUtil.list(
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
	 * Returns the first ency workflow state instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	@Override
	public EncyWorkflowStateInstance findByWorkflowInstanceId_First(
			long workflowInstanceId,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException {

		EncyWorkflowStateInstance encyWorkflowStateInstance =
			fetchByWorkflowInstanceId_First(
				workflowInstanceId, orderByComparator);

		if (encyWorkflowStateInstance != null) {
			return encyWorkflowStateInstance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workflowInstanceId=");
		sb.append(workflowInstanceId);

		sb.append("}");

		throw new NoSuchStateInstanceException(sb.toString());
	}

	/**
	 * Returns the first ency workflow state instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	@Override
	public EncyWorkflowStateInstance fetchByWorkflowInstanceId_First(
		long workflowInstanceId,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		List<EncyWorkflowStateInstance> list = findByWorkflowInstanceId(
			workflowInstanceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow state instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	@Override
	public EncyWorkflowStateInstance findByWorkflowInstanceId_Last(
			long workflowInstanceId,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException {

		EncyWorkflowStateInstance encyWorkflowStateInstance =
			fetchByWorkflowInstanceId_Last(
				workflowInstanceId, orderByComparator);

		if (encyWorkflowStateInstance != null) {
			return encyWorkflowStateInstance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workflowInstanceId=");
		sb.append(workflowInstanceId);

		sb.append("}");

		throw new NoSuchStateInstanceException(sb.toString());
	}

	/**
	 * Returns the last ency workflow state instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	@Override
	public EncyWorkflowStateInstance fetchByWorkflowInstanceId_Last(
		long workflowInstanceId,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		int count = countByWorkflowInstanceId(workflowInstanceId);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflowStateInstance> list = findByWorkflowInstanceId(
			workflowInstanceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflow state instances before and after the current ency workflow state instance in the ordered set where workflowInstanceId = &#63;.
	 *
	 * @param stateInstanceId the primary key of the current ency workflow state instance
	 * @param workflowInstanceId the workflow instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow state instance
	 * @throws NoSuchStateInstanceException if a ency workflow state instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowStateInstance[] findByWorkflowInstanceId_PrevAndNext(
			long stateInstanceId, long workflowInstanceId,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException {

		EncyWorkflowStateInstance encyWorkflowStateInstance = findByPrimaryKey(
			stateInstanceId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowStateInstance[] array =
				new EncyWorkflowStateInstanceImpl[3];

			array[0] = getByWorkflowInstanceId_PrevAndNext(
				session, encyWorkflowStateInstance, workflowInstanceId,
				orderByComparator, true);

			array[1] = encyWorkflowStateInstance;

			array[2] = getByWorkflowInstanceId_PrevAndNext(
				session, encyWorkflowStateInstance, workflowInstanceId,
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

	protected EncyWorkflowStateInstance getByWorkflowInstanceId_PrevAndNext(
		Session session, EncyWorkflowStateInstance encyWorkflowStateInstance,
		long workflowInstanceId,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator,
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

		sb.append(_SQL_SELECT_ENCYWORKFLOWSTATEINSTANCE_WHERE);

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
			sb.append(EncyWorkflowStateInstanceModelImpl.ORDER_BY_JPQL);
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
						encyWorkflowStateInstance)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflowStateInstance> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ency workflow state instances where workflowInstanceId = &#63; from the database.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 */
	@Override
	public void removeByWorkflowInstanceId(long workflowInstanceId) {
		for (EncyWorkflowStateInstance encyWorkflowStateInstance :
				findByWorkflowInstanceId(
					workflowInstanceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(encyWorkflowStateInstance);
		}
	}

	/**
	 * Returns the number of ency workflow state instances where workflowInstanceId = &#63;.
	 *
	 * @param workflowInstanceId the workflow instance ID
	 * @return the number of matching ency workflow state instances
	 */
	@Override
	public int countByWorkflowInstanceId(long workflowInstanceId) {
		FinderPath finderPath = _finderPathCountByWorkflowInstanceId;

		Object[] finderArgs = new Object[] {workflowInstanceId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ENCYWORKFLOWSTATEINSTANCE_WHERE);

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
			"encyWorkflowStateInstance.workflowInstanceId = ?";

	private FinderPath _finderPathWithPaginationFindByWorkflowId;
	private FinderPath _finderPathWithoutPaginationFindByWorkflowId;
	private FinderPath _finderPathCountByWorkflowId;

	/**
	 * Returns all the ency workflow state instances where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @return the matching ency workflow state instances
	 */
	@Override
	public List<EncyWorkflowStateInstance> findByWorkflowId(long workflowId) {
		return findByWorkflowId(
			workflowId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow state instances where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @return the range of matching ency workflow state instances
	 */
	@Override
	public List<EncyWorkflowStateInstance> findByWorkflowId(
		long workflowId, int start, int end) {

		return findByWorkflowId(workflowId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow state instances where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow state instances
	 */
	@Override
	public List<EncyWorkflowStateInstance> findByWorkflowId(
		long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		return findByWorkflowId(
			workflowId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow state instances where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow state instances
	 */
	@Override
	public List<EncyWorkflowStateInstance> findByWorkflowId(
		long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByWorkflowId;
				finderArgs = new Object[] {workflowId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByWorkflowId;
			finderArgs = new Object[] {
				workflowId, start, end, orderByComparator
			};
		}

		List<EncyWorkflowStateInstance> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowStateInstance>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowStateInstance encyWorkflowStateInstance :
						list) {

					if (workflowId !=
							encyWorkflowStateInstance.getWorkflowId()) {

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

			sb.append(_SQL_SELECT_ENCYWORKFLOWSTATEINSTANCE_WHERE);

			sb.append(_FINDER_COLUMN_WORKFLOWID_WORKFLOWID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EncyWorkflowStateInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workflowId);

				list = (List<EncyWorkflowStateInstance>)QueryUtil.list(
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
	 * Returns the first ency workflow state instance in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	@Override
	public EncyWorkflowStateInstance findByWorkflowId_First(
			long workflowId,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException {

		EncyWorkflowStateInstance encyWorkflowStateInstance =
			fetchByWorkflowId_First(workflowId, orderByComparator);

		if (encyWorkflowStateInstance != null) {
			return encyWorkflowStateInstance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workflowId=");
		sb.append(workflowId);

		sb.append("}");

		throw new NoSuchStateInstanceException(sb.toString());
	}

	/**
	 * Returns the first ency workflow state instance in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	@Override
	public EncyWorkflowStateInstance fetchByWorkflowId_First(
		long workflowId,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		List<EncyWorkflowStateInstance> list = findByWorkflowId(
			workflowId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow state instance in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance
	 * @throws NoSuchStateInstanceException if a matching ency workflow state instance could not be found
	 */
	@Override
	public EncyWorkflowStateInstance findByWorkflowId_Last(
			long workflowId,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException {

		EncyWorkflowStateInstance encyWorkflowStateInstance =
			fetchByWorkflowId_Last(workflowId, orderByComparator);

		if (encyWorkflowStateInstance != null) {
			return encyWorkflowStateInstance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workflowId=");
		sb.append(workflowId);

		sb.append("}");

		throw new NoSuchStateInstanceException(sb.toString());
	}

	/**
	 * Returns the last ency workflow state instance in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	@Override
	public EncyWorkflowStateInstance fetchByWorkflowId_Last(
		long workflowId,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		int count = countByWorkflowId(workflowId);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflowStateInstance> list = findByWorkflowId(
			workflowId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflow state instances before and after the current ency workflow state instance in the ordered set where workflowId = &#63;.
	 *
	 * @param stateInstanceId the primary key of the current ency workflow state instance
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow state instance
	 * @throws NoSuchStateInstanceException if a ency workflow state instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowStateInstance[] findByWorkflowId_PrevAndNext(
			long stateInstanceId, long workflowId,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator)
		throws NoSuchStateInstanceException {

		EncyWorkflowStateInstance encyWorkflowStateInstance = findByPrimaryKey(
			stateInstanceId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowStateInstance[] array =
				new EncyWorkflowStateInstanceImpl[3];

			array[0] = getByWorkflowId_PrevAndNext(
				session, encyWorkflowStateInstance, workflowId,
				orderByComparator, true);

			array[1] = encyWorkflowStateInstance;

			array[2] = getByWorkflowId_PrevAndNext(
				session, encyWorkflowStateInstance, workflowId,
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

	protected EncyWorkflowStateInstance getByWorkflowId_PrevAndNext(
		Session session, EncyWorkflowStateInstance encyWorkflowStateInstance,
		long workflowId,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator,
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

		sb.append(_SQL_SELECT_ENCYWORKFLOWSTATEINSTANCE_WHERE);

		sb.append(_FINDER_COLUMN_WORKFLOWID_WORKFLOWID_2);

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
			sb.append(EncyWorkflowStateInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(workflowId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						encyWorkflowStateInstance)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflowStateInstance> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ency workflow state instances where workflowId = &#63; from the database.
	 *
	 * @param workflowId the workflow ID
	 */
	@Override
	public void removeByWorkflowId(long workflowId) {
		for (EncyWorkflowStateInstance encyWorkflowStateInstance :
				findByWorkflowId(
					workflowId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(encyWorkflowStateInstance);
		}
	}

	/**
	 * Returns the number of ency workflow state instances where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @return the number of matching ency workflow state instances
	 */
	@Override
	public int countByWorkflowId(long workflowId) {
		FinderPath finderPath = _finderPathCountByWorkflowId;

		Object[] finderArgs = new Object[] {workflowId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ENCYWORKFLOWSTATEINSTANCE_WHERE);

			sb.append(_FINDER_COLUMN_WORKFLOWID_WORKFLOWID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workflowId);

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

	private static final String _FINDER_COLUMN_WORKFLOWID_WORKFLOWID_2 =
		"encyWorkflowStateInstance.workflowId = ?";

	public EncyWorkflowStateInstancePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EncyWorkflowStateInstance.class);

		setModelImplClass(EncyWorkflowStateInstanceImpl.class);
		setModelPKClass(long.class);

		setTable(EncyWorkflowStateInstanceTable.INSTANCE);
	}

	/**
	 * Caches the ency workflow state instance in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowStateInstance the ency workflow state instance
	 */
	@Override
	public void cacheResult(
		EncyWorkflowStateInstance encyWorkflowStateInstance) {

		entityCache.putResult(
			EncyWorkflowStateInstanceImpl.class,
			encyWorkflowStateInstance.getPrimaryKey(),
			encyWorkflowStateInstance);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				encyWorkflowStateInstance.getUuid(),
				encyWorkflowStateInstance.getGroupId()
			},
			encyWorkflowStateInstance);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the ency workflow state instances in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowStateInstances the ency workflow state instances
	 */
	@Override
	public void cacheResult(
		List<EncyWorkflowStateInstance> encyWorkflowStateInstances) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (encyWorkflowStateInstances.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EncyWorkflowStateInstance encyWorkflowStateInstance :
				encyWorkflowStateInstances) {

			if (entityCache.getResult(
					EncyWorkflowStateInstanceImpl.class,
					encyWorkflowStateInstance.getPrimaryKey()) == null) {

				cacheResult(encyWorkflowStateInstance);
			}
		}
	}

	/**
	 * Clears the cache for all ency workflow state instances.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EncyWorkflowStateInstanceImpl.class);

		finderCache.clearCache(EncyWorkflowStateInstanceImpl.class);
	}

	/**
	 * Clears the cache for the ency workflow state instance.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		EncyWorkflowStateInstance encyWorkflowStateInstance) {

		entityCache.removeResult(
			EncyWorkflowStateInstanceImpl.class, encyWorkflowStateInstance);
	}

	@Override
	public void clearCache(
		List<EncyWorkflowStateInstance> encyWorkflowStateInstances) {

		for (EncyWorkflowStateInstance encyWorkflowStateInstance :
				encyWorkflowStateInstances) {

			entityCache.removeResult(
				EncyWorkflowStateInstanceImpl.class, encyWorkflowStateInstance);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EncyWorkflowStateInstanceImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				EncyWorkflowStateInstanceImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EncyWorkflowStateInstanceModelImpl encyWorkflowStateInstanceModelImpl) {

		Object[] args = new Object[] {
			encyWorkflowStateInstanceModelImpl.getUuid(),
			encyWorkflowStateInstanceModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, encyWorkflowStateInstanceModelImpl);
	}

	/**
	 * Creates a new ency workflow state instance with the primary key. Does not add the ency workflow state instance to the database.
	 *
	 * @param stateInstanceId the primary key for the new ency workflow state instance
	 * @return the new ency workflow state instance
	 */
	@Override
	public EncyWorkflowStateInstance create(long stateInstanceId) {
		EncyWorkflowStateInstance encyWorkflowStateInstance =
			new EncyWorkflowStateInstanceImpl();

		encyWorkflowStateInstance.setNew(true);
		encyWorkflowStateInstance.setPrimaryKey(stateInstanceId);

		String uuid = _portalUUID.generate();

		encyWorkflowStateInstance.setUuid(uuid);

		encyWorkflowStateInstance.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return encyWorkflowStateInstance;
	}

	/**
	 * Removes the ency workflow state instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stateInstanceId the primary key of the ency workflow state instance
	 * @return the ency workflow state instance that was removed
	 * @throws NoSuchStateInstanceException if a ency workflow state instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowStateInstance remove(long stateInstanceId)
		throws NoSuchStateInstanceException {

		return remove((Serializable)stateInstanceId);
	}

	/**
	 * Removes the ency workflow state instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ency workflow state instance
	 * @return the ency workflow state instance that was removed
	 * @throws NoSuchStateInstanceException if a ency workflow state instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowStateInstance remove(Serializable primaryKey)
		throws NoSuchStateInstanceException {

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowStateInstance encyWorkflowStateInstance =
				(EncyWorkflowStateInstance)session.get(
					EncyWorkflowStateInstanceImpl.class, primaryKey);

			if (encyWorkflowStateInstance == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStateInstanceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(encyWorkflowStateInstance);
		}
		catch (NoSuchStateInstanceException noSuchEntityException) {
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
	protected EncyWorkflowStateInstance removeImpl(
		EncyWorkflowStateInstance encyWorkflowStateInstance) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(encyWorkflowStateInstance)) {
				encyWorkflowStateInstance =
					(EncyWorkflowStateInstance)session.get(
						EncyWorkflowStateInstanceImpl.class,
						encyWorkflowStateInstance.getPrimaryKeyObj());
			}

			if (encyWorkflowStateInstance != null) {
				session.delete(encyWorkflowStateInstance);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (encyWorkflowStateInstance != null) {
			clearCache(encyWorkflowStateInstance);
		}

		return encyWorkflowStateInstance;
	}

	@Override
	public EncyWorkflowStateInstance updateImpl(
		EncyWorkflowStateInstance encyWorkflowStateInstance) {

		boolean isNew = encyWorkflowStateInstance.isNew();

		if (!(encyWorkflowStateInstance instanceof
				EncyWorkflowStateInstanceModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(encyWorkflowStateInstance.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					encyWorkflowStateInstance);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in encyWorkflowStateInstance proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EncyWorkflowStateInstance implementation " +
					encyWorkflowStateInstance.getClass());
		}

		EncyWorkflowStateInstanceModelImpl encyWorkflowStateInstanceModelImpl =
			(EncyWorkflowStateInstanceModelImpl)encyWorkflowStateInstance;

		if (Validator.isNull(encyWorkflowStateInstance.getUuid())) {
			String uuid = _portalUUID.generate();

			encyWorkflowStateInstance.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (encyWorkflowStateInstance.getCreateDate() == null)) {
			if (serviceContext == null) {
				encyWorkflowStateInstance.setCreateDate(date);
			}
			else {
				encyWorkflowStateInstance.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!encyWorkflowStateInstanceModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				encyWorkflowStateInstance.setModifiedDate(date);
			}
			else {
				encyWorkflowStateInstance.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(encyWorkflowStateInstance);
			}
			else {
				encyWorkflowStateInstance =
					(EncyWorkflowStateInstance)session.merge(
						encyWorkflowStateInstance);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EncyWorkflowStateInstanceImpl.class,
			encyWorkflowStateInstanceModelImpl, false, true);

		cacheUniqueFindersCache(encyWorkflowStateInstanceModelImpl);

		if (isNew) {
			encyWorkflowStateInstance.setNew(false);
		}

		encyWorkflowStateInstance.resetOriginalValues();

		return encyWorkflowStateInstance;
	}

	/**
	 * Returns the ency workflow state instance with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ency workflow state instance
	 * @return the ency workflow state instance
	 * @throws NoSuchStateInstanceException if a ency workflow state instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowStateInstance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStateInstanceException {

		EncyWorkflowStateInstance encyWorkflowStateInstance = fetchByPrimaryKey(
			primaryKey);

		if (encyWorkflowStateInstance == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStateInstanceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return encyWorkflowStateInstance;
	}

	/**
	 * Returns the ency workflow state instance with the primary key or throws a <code>NoSuchStateInstanceException</code> if it could not be found.
	 *
	 * @param stateInstanceId the primary key of the ency workflow state instance
	 * @return the ency workflow state instance
	 * @throws NoSuchStateInstanceException if a ency workflow state instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowStateInstance findByPrimaryKey(long stateInstanceId)
		throws NoSuchStateInstanceException {

		return findByPrimaryKey((Serializable)stateInstanceId);
	}

	/**
	 * Returns the ency workflow state instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stateInstanceId the primary key of the ency workflow state instance
	 * @return the ency workflow state instance, or <code>null</code> if a ency workflow state instance with the primary key could not be found
	 */
	@Override
	public EncyWorkflowStateInstance fetchByPrimaryKey(long stateInstanceId) {
		return fetchByPrimaryKey((Serializable)stateInstanceId);
	}

	/**
	 * Returns all the ency workflow state instances.
	 *
	 * @return the ency workflow state instances
	 */
	@Override
	public List<EncyWorkflowStateInstance> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow state instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @return the range of ency workflow state instances
	 */
	@Override
	public List<EncyWorkflowStateInstance> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow state instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ency workflow state instances
	 */
	@Override
	public List<EncyWorkflowStateInstance> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow state instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ency workflow state instances
	 */
	@Override
	public List<EncyWorkflowStateInstance> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowStateInstance> orderByComparator,
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

		List<EncyWorkflowStateInstance> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowStateInstance>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ENCYWORKFLOWSTATEINSTANCE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ENCYWORKFLOWSTATEINSTANCE;

				sql = sql.concat(
					EncyWorkflowStateInstanceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EncyWorkflowStateInstance>)QueryUtil.list(
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
	 * Removes all the ency workflow state instances from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EncyWorkflowStateInstance encyWorkflowStateInstance : findAll()) {
			remove(encyWorkflowStateInstance);
		}
	}

	/**
	 * Returns the number of ency workflow state instances.
	 *
	 * @return the number of ency workflow state instances
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
					_SQL_COUNT_ENCYWORKFLOWSTATEINSTANCE);

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
		return "stateInstanceId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ENCYWORKFLOWSTATEINSTANCE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EncyWorkflowStateInstanceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ency workflow state instance persistence.
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

		_finderPathWithPaginationFindByWorkflowId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByWorkflowId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"workflowId"}, true);

		_finderPathWithoutPaginationFindByWorkflowId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByWorkflowId",
			new String[] {Long.class.getName()}, new String[] {"workflowId"},
			true);

		_finderPathCountByWorkflowId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWorkflowId",
			new String[] {Long.class.getName()}, new String[] {"workflowId"},
			false);

		_setEncyWorkflowStateInstanceUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setEncyWorkflowStateInstanceUtilPersistence(null);

		entityCache.removeCache(EncyWorkflowStateInstanceImpl.class.getName());
	}

	private void _setEncyWorkflowStateInstanceUtilPersistence(
		EncyWorkflowStateInstancePersistence
			encyWorkflowStateInstancePersistence) {

		try {
			Field field = EncyWorkflowStateInstanceUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, encyWorkflowStateInstancePersistence);
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

	private static final String _SQL_SELECT_ENCYWORKFLOWSTATEINSTANCE =
		"SELECT encyWorkflowStateInstance FROM EncyWorkflowStateInstance encyWorkflowStateInstance";

	private static final String _SQL_SELECT_ENCYWORKFLOWSTATEINSTANCE_WHERE =
		"SELECT encyWorkflowStateInstance FROM EncyWorkflowStateInstance encyWorkflowStateInstance WHERE ";

	private static final String _SQL_COUNT_ENCYWORKFLOWSTATEINSTANCE =
		"SELECT COUNT(encyWorkflowStateInstance) FROM EncyWorkflowStateInstance encyWorkflowStateInstance";

	private static final String _SQL_COUNT_ENCYWORKFLOWSTATEINSTANCE_WHERE =
		"SELECT COUNT(encyWorkflowStateInstance) FROM EncyWorkflowStateInstance encyWorkflowStateInstance WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"encyWorkflowStateInstance.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EncyWorkflowStateInstance exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EncyWorkflowStateInstance exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EncyWorkflowStateInstancePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private EncyWorkflowStateInstanceModelArgumentsResolver
		_encyWorkflowStateInstanceModelArgumentsResolver;

}