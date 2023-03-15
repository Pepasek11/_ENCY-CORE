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

import cz.csob.ency.workflow.exception.NoSuchStateException;
import cz.csob.ency.workflow.model.EncyWorkflowState;
import cz.csob.ency.workflow.model.EncyWorkflowStateTable;
import cz.csob.ency.workflow.model.impl.EncyWorkflowStateImpl;
import cz.csob.ency.workflow.model.impl.EncyWorkflowStateModelImpl;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowStatePersistence;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowStateUtil;
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
 * The persistence implementation for the ency workflow state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @generated
 */
@Component(
	service = {EncyWorkflowStatePersistence.class, BasePersistence.class}
)
public class EncyWorkflowStatePersistenceImpl
	extends BasePersistenceImpl<EncyWorkflowState>
	implements EncyWorkflowStatePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EncyWorkflowStateUtil</code> to access the ency workflow state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EncyWorkflowStateImpl.class.getName();

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
	 * Returns all the ency workflow states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ency workflow states
	 */
	@Override
	public List<EncyWorkflowState> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @return the range of matching ency workflow states
	 */
	@Override
	public List<EncyWorkflowState> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow states
	 */
	@Override
	public List<EncyWorkflowState> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowState> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow states
	 */
	@Override
	public List<EncyWorkflowState> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowState> orderByComparator,
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

		List<EncyWorkflowState> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowState>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowState encyWorkflowState : list) {
					if (!uuid.equals(encyWorkflowState.getUuid())) {
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

			sb.append(_SQL_SELECT_ENCYWORKFLOWSTATE_WHERE);

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
				sb.append(EncyWorkflowStateModelImpl.ORDER_BY_JPQL);
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

				list = (List<EncyWorkflowState>)QueryUtil.list(
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
	 * Returns the first ency workflow state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state
	 * @throws NoSuchStateException if a matching ency workflow state could not be found
	 */
	@Override
	public EncyWorkflowState findByUuid_First(
			String uuid, OrderByComparator<EncyWorkflowState> orderByComparator)
		throws NoSuchStateException {

		EncyWorkflowState encyWorkflowState = fetchByUuid_First(
			uuid, orderByComparator);

		if (encyWorkflowState != null) {
			return encyWorkflowState;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchStateException(sb.toString());
	}

	/**
	 * Returns the first ency workflow state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	@Override
	public EncyWorkflowState fetchByUuid_First(
		String uuid, OrderByComparator<EncyWorkflowState> orderByComparator) {

		List<EncyWorkflowState> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state
	 * @throws NoSuchStateException if a matching ency workflow state could not be found
	 */
	@Override
	public EncyWorkflowState findByUuid_Last(
			String uuid, OrderByComparator<EncyWorkflowState> orderByComparator)
		throws NoSuchStateException {

		EncyWorkflowState encyWorkflowState = fetchByUuid_Last(
			uuid, orderByComparator);

		if (encyWorkflowState != null) {
			return encyWorkflowState;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchStateException(sb.toString());
	}

	/**
	 * Returns the last ency workflow state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	@Override
	public EncyWorkflowState fetchByUuid_Last(
		String uuid, OrderByComparator<EncyWorkflowState> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflowState> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflow states before and after the current ency workflow state in the ordered set where uuid = &#63;.
	 *
	 * @param stateId the primary key of the current ency workflow state
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow state
	 * @throws NoSuchStateException if a ency workflow state with the primary key could not be found
	 */
	@Override
	public EncyWorkflowState[] findByUuid_PrevAndNext(
			long stateId, String uuid,
			OrderByComparator<EncyWorkflowState> orderByComparator)
		throws NoSuchStateException {

		uuid = Objects.toString(uuid, "");

		EncyWorkflowState encyWorkflowState = findByPrimaryKey(stateId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowState[] array = new EncyWorkflowStateImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, encyWorkflowState, uuid, orderByComparator, true);

			array[1] = encyWorkflowState;

			array[2] = getByUuid_PrevAndNext(
				session, encyWorkflowState, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EncyWorkflowState getByUuid_PrevAndNext(
		Session session, EncyWorkflowState encyWorkflowState, String uuid,
		OrderByComparator<EncyWorkflowState> orderByComparator,
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

		sb.append(_SQL_SELECT_ENCYWORKFLOWSTATE_WHERE);

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
			sb.append(EncyWorkflowStateModelImpl.ORDER_BY_JPQL);
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
						encyWorkflowState)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflowState> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ency workflow states where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EncyWorkflowState encyWorkflowState :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(encyWorkflowState);
		}
	}

	/**
	 * Returns the number of ency workflow states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ency workflow states
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ENCYWORKFLOWSTATE_WHERE);

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
		"encyWorkflowState.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(encyWorkflowState.uuid IS NULL OR encyWorkflowState.uuid = '')";

	private FinderPath _finderPathFetchByW_N;
	private FinderPath _finderPathCountByW_N;

	/**
	 * Returns the ency workflow state where workflowId = &#63; and name = &#63; or throws a <code>NoSuchStateException</code> if it could not be found.
	 *
	 * @param workflowId the workflow ID
	 * @param name the name
	 * @return the matching ency workflow state
	 * @throws NoSuchStateException if a matching ency workflow state could not be found
	 */
	@Override
	public EncyWorkflowState findByW_N(long workflowId, String name)
		throws NoSuchStateException {

		EncyWorkflowState encyWorkflowState = fetchByW_N(workflowId, name);

		if (encyWorkflowState == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("workflowId=");
			sb.append(workflowId);

			sb.append(", name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchStateException(sb.toString());
		}

		return encyWorkflowState;
	}

	/**
	 * Returns the ency workflow state where workflowId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param workflowId the workflow ID
	 * @param name the name
	 * @return the matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	@Override
	public EncyWorkflowState fetchByW_N(long workflowId, String name) {
		return fetchByW_N(workflowId, name, true);
	}

	/**
	 * Returns the ency workflow state where workflowId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param workflowId the workflow ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	@Override
	public EncyWorkflowState fetchByW_N(
		long workflowId, String name, boolean useFinderCache) {

		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {workflowId, name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByW_N, finderArgs);
		}

		if (result instanceof EncyWorkflowState) {
			EncyWorkflowState encyWorkflowState = (EncyWorkflowState)result;

			if ((workflowId != encyWorkflowState.getWorkflowId()) ||
				!Objects.equals(name, encyWorkflowState.getName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ENCYWORKFLOWSTATE_WHERE);

			sb.append(_FINDER_COLUMN_W_N_WORKFLOWID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_W_N_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_W_N_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workflowId);

				if (bindName) {
					queryPos.add(name);
				}

				List<EncyWorkflowState> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByW_N, finderArgs, list);
					}
				}
				else {
					EncyWorkflowState encyWorkflowState = list.get(0);

					result = encyWorkflowState;

					cacheResult(encyWorkflowState);
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
			return (EncyWorkflowState)result;
		}
	}

	/**
	 * Removes the ency workflow state where workflowId = &#63; and name = &#63; from the database.
	 *
	 * @param workflowId the workflow ID
	 * @param name the name
	 * @return the ency workflow state that was removed
	 */
	@Override
	public EncyWorkflowState removeByW_N(long workflowId, String name)
		throws NoSuchStateException {

		EncyWorkflowState encyWorkflowState = findByW_N(workflowId, name);

		return remove(encyWorkflowState);
	}

	/**
	 * Returns the number of ency workflow states where workflowId = &#63; and name = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param name the name
	 * @return the number of matching ency workflow states
	 */
	@Override
	public int countByW_N(long workflowId, String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByW_N;

		Object[] finderArgs = new Object[] {workflowId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ENCYWORKFLOWSTATE_WHERE);

			sb.append(_FINDER_COLUMN_W_N_WORKFLOWID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_W_N_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_W_N_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workflowId);

				if (bindName) {
					queryPos.add(name);
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

	private static final String _FINDER_COLUMN_W_N_WORKFLOWID_2 =
		"encyWorkflowState.workflowId = ? AND ";

	private static final String _FINDER_COLUMN_W_N_NAME_2 =
		"encyWorkflowState.name = ?";

	private static final String _FINDER_COLUMN_W_N_NAME_3 =
		"(encyWorkflowState.name IS NULL OR encyWorkflowState.name = '')";

	private FinderPath _finderPathWithPaginationFindByWorkflow;
	private FinderPath _finderPathWithoutPaginationFindByWorkflow;
	private FinderPath _finderPathCountByWorkflow;

	/**
	 * Returns all the ency workflow states where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @return the matching ency workflow states
	 */
	@Override
	public List<EncyWorkflowState> findByWorkflow(long workflowId) {
		return findByWorkflow(
			workflowId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow states where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @return the range of matching ency workflow states
	 */
	@Override
	public List<EncyWorkflowState> findByWorkflow(
		long workflowId, int start, int end) {

		return findByWorkflow(workflowId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow states where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow states
	 */
	@Override
	public List<EncyWorkflowState> findByWorkflow(
		long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowState> orderByComparator) {

		return findByWorkflow(workflowId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow states where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow states
	 */
	@Override
	public List<EncyWorkflowState> findByWorkflow(
		long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowState> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByWorkflow;
				finderArgs = new Object[] {workflowId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByWorkflow;
			finderArgs = new Object[] {
				workflowId, start, end, orderByComparator
			};
		}

		List<EncyWorkflowState> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowState>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowState encyWorkflowState : list) {
					if (workflowId != encyWorkflowState.getWorkflowId()) {
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

			sb.append(_SQL_SELECT_ENCYWORKFLOWSTATE_WHERE);

			sb.append(_FINDER_COLUMN_WORKFLOW_WORKFLOWID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EncyWorkflowStateModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workflowId);

				list = (List<EncyWorkflowState>)QueryUtil.list(
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
	 * Returns the first ency workflow state in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state
	 * @throws NoSuchStateException if a matching ency workflow state could not be found
	 */
	@Override
	public EncyWorkflowState findByWorkflow_First(
			long workflowId,
			OrderByComparator<EncyWorkflowState> orderByComparator)
		throws NoSuchStateException {

		EncyWorkflowState encyWorkflowState = fetchByWorkflow_First(
			workflowId, orderByComparator);

		if (encyWorkflowState != null) {
			return encyWorkflowState;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workflowId=");
		sb.append(workflowId);

		sb.append("}");

		throw new NoSuchStateException(sb.toString());
	}

	/**
	 * Returns the first ency workflow state in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	@Override
	public EncyWorkflowState fetchByWorkflow_First(
		long workflowId,
		OrderByComparator<EncyWorkflowState> orderByComparator) {

		List<EncyWorkflowState> list = findByWorkflow(
			workflowId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow state in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state
	 * @throws NoSuchStateException if a matching ency workflow state could not be found
	 */
	@Override
	public EncyWorkflowState findByWorkflow_Last(
			long workflowId,
			OrderByComparator<EncyWorkflowState> orderByComparator)
		throws NoSuchStateException {

		EncyWorkflowState encyWorkflowState = fetchByWorkflow_Last(
			workflowId, orderByComparator);

		if (encyWorkflowState != null) {
			return encyWorkflowState;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workflowId=");
		sb.append(workflowId);

		sb.append("}");

		throw new NoSuchStateException(sb.toString());
	}

	/**
	 * Returns the last ency workflow state in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	@Override
	public EncyWorkflowState fetchByWorkflow_Last(
		long workflowId,
		OrderByComparator<EncyWorkflowState> orderByComparator) {

		int count = countByWorkflow(workflowId);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflowState> list = findByWorkflow(
			workflowId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflow states before and after the current ency workflow state in the ordered set where workflowId = &#63;.
	 *
	 * @param stateId the primary key of the current ency workflow state
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow state
	 * @throws NoSuchStateException if a ency workflow state with the primary key could not be found
	 */
	@Override
	public EncyWorkflowState[] findByWorkflow_PrevAndNext(
			long stateId, long workflowId,
			OrderByComparator<EncyWorkflowState> orderByComparator)
		throws NoSuchStateException {

		EncyWorkflowState encyWorkflowState = findByPrimaryKey(stateId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowState[] array = new EncyWorkflowStateImpl[3];

			array[0] = getByWorkflow_PrevAndNext(
				session, encyWorkflowState, workflowId, orderByComparator,
				true);

			array[1] = encyWorkflowState;

			array[2] = getByWorkflow_PrevAndNext(
				session, encyWorkflowState, workflowId, orderByComparator,
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

	protected EncyWorkflowState getByWorkflow_PrevAndNext(
		Session session, EncyWorkflowState encyWorkflowState, long workflowId,
		OrderByComparator<EncyWorkflowState> orderByComparator,
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

		sb.append(_SQL_SELECT_ENCYWORKFLOWSTATE_WHERE);

		sb.append(_FINDER_COLUMN_WORKFLOW_WORKFLOWID_2);

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
			sb.append(EncyWorkflowStateModelImpl.ORDER_BY_JPQL);
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
						encyWorkflowState)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflowState> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ency workflow states where workflowId = &#63; from the database.
	 *
	 * @param workflowId the workflow ID
	 */
	@Override
	public void removeByWorkflow(long workflowId) {
		for (EncyWorkflowState encyWorkflowState :
				findByWorkflow(
					workflowId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(encyWorkflowState);
		}
	}

	/**
	 * Returns the number of ency workflow states where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @return the number of matching ency workflow states
	 */
	@Override
	public int countByWorkflow(long workflowId) {
		FinderPath finderPath = _finderPathCountByWorkflow;

		Object[] finderArgs = new Object[] {workflowId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ENCYWORKFLOWSTATE_WHERE);

			sb.append(_FINDER_COLUMN_WORKFLOW_WORKFLOWID_2);

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

	private static final String _FINDER_COLUMN_WORKFLOW_WORKFLOWID_2 =
		"encyWorkflowState.workflowId = ?";

	private FinderPath _finderPathWithPaginationFindByActive;
	private FinderPath _finderPathWithoutPaginationFindByActive;
	private FinderPath _finderPathCountByActive;

	/**
	 * Returns all the ency workflow states where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching ency workflow states
	 */
	@Override
	public List<EncyWorkflowState> findByActive(Boolean active) {
		return findByActive(active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow states where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @return the range of matching ency workflow states
	 */
	@Override
	public List<EncyWorkflowState> findByActive(
		Boolean active, int start, int end) {

		return findByActive(active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow states where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow states
	 */
	@Override
	public List<EncyWorkflowState> findByActive(
		Boolean active, int start, int end,
		OrderByComparator<EncyWorkflowState> orderByComparator) {

		return findByActive(active, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow states where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow states
	 */
	@Override
	public List<EncyWorkflowState> findByActive(
		Boolean active, int start, int end,
		OrderByComparator<EncyWorkflowState> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByActive;
				finderArgs = new Object[] {active};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByActive;
			finderArgs = new Object[] {active, start, end, orderByComparator};
		}

		List<EncyWorkflowState> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowState>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowState encyWorkflowState : list) {
					if (!Objects.equals(
							active, encyWorkflowState.getActive())) {

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

			sb.append(_SQL_SELECT_ENCYWORKFLOWSTATE_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EncyWorkflowStateModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(active.booleanValue());

				list = (List<EncyWorkflowState>)QueryUtil.list(
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
	 * Returns the first ency workflow state in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state
	 * @throws NoSuchStateException if a matching ency workflow state could not be found
	 */
	@Override
	public EncyWorkflowState findByActive_First(
			Boolean active,
			OrderByComparator<EncyWorkflowState> orderByComparator)
		throws NoSuchStateException {

		EncyWorkflowState encyWorkflowState = fetchByActive_First(
			active, orderByComparator);

		if (encyWorkflowState != null) {
			return encyWorkflowState;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchStateException(sb.toString());
	}

	/**
	 * Returns the first ency workflow state in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	@Override
	public EncyWorkflowState fetchByActive_First(
		Boolean active,
		OrderByComparator<EncyWorkflowState> orderByComparator) {

		List<EncyWorkflowState> list = findByActive(
			active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow state in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state
	 * @throws NoSuchStateException if a matching ency workflow state could not be found
	 */
	@Override
	public EncyWorkflowState findByActive_Last(
			Boolean active,
			OrderByComparator<EncyWorkflowState> orderByComparator)
		throws NoSuchStateException {

		EncyWorkflowState encyWorkflowState = fetchByActive_Last(
			active, orderByComparator);

		if (encyWorkflowState != null) {
			return encyWorkflowState;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchStateException(sb.toString());
	}

	/**
	 * Returns the last ency workflow state in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow state, or <code>null</code> if a matching ency workflow state could not be found
	 */
	@Override
	public EncyWorkflowState fetchByActive_Last(
		Boolean active,
		OrderByComparator<EncyWorkflowState> orderByComparator) {

		int count = countByActive(active);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflowState> list = findByActive(
			active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflow states before and after the current ency workflow state in the ordered set where active = &#63;.
	 *
	 * @param stateId the primary key of the current ency workflow state
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow state
	 * @throws NoSuchStateException if a ency workflow state with the primary key could not be found
	 */
	@Override
	public EncyWorkflowState[] findByActive_PrevAndNext(
			long stateId, Boolean active,
			OrderByComparator<EncyWorkflowState> orderByComparator)
		throws NoSuchStateException {

		EncyWorkflowState encyWorkflowState = findByPrimaryKey(stateId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowState[] array = new EncyWorkflowStateImpl[3];

			array[0] = getByActive_PrevAndNext(
				session, encyWorkflowState, active, orderByComparator, true);

			array[1] = encyWorkflowState;

			array[2] = getByActive_PrevAndNext(
				session, encyWorkflowState, active, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EncyWorkflowState getByActive_PrevAndNext(
		Session session, EncyWorkflowState encyWorkflowState, Boolean active,
		OrderByComparator<EncyWorkflowState> orderByComparator,
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

		sb.append(_SQL_SELECT_ENCYWORKFLOWSTATE_WHERE);

		sb.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

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
			sb.append(EncyWorkflowStateModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(active.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						encyWorkflowState)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflowState> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ency workflow states where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	@Override
	public void removeByActive(Boolean active) {
		for (EncyWorkflowState encyWorkflowState :
				findByActive(
					active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(encyWorkflowState);
		}
	}

	/**
	 * Returns the number of ency workflow states where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching ency workflow states
	 */
	@Override
	public int countByActive(Boolean active) {
		FinderPath finderPath = _finderPathCountByActive;

		Object[] finderArgs = new Object[] {active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ENCYWORKFLOWSTATE_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(active.booleanValue());

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

	private static final String _FINDER_COLUMN_ACTIVE_ACTIVE_2 =
		"encyWorkflowState.active = ?";

	public EncyWorkflowStatePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EncyWorkflowState.class);

		setModelImplClass(EncyWorkflowStateImpl.class);
		setModelPKClass(long.class);

		setTable(EncyWorkflowStateTable.INSTANCE);
	}

	/**
	 * Caches the ency workflow state in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowState the ency workflow state
	 */
	@Override
	public void cacheResult(EncyWorkflowState encyWorkflowState) {
		entityCache.putResult(
			EncyWorkflowStateImpl.class, encyWorkflowState.getPrimaryKey(),
			encyWorkflowState);

		finderCache.putResult(
			_finderPathFetchByW_N,
			new Object[] {
				encyWorkflowState.getWorkflowId(), encyWorkflowState.getName()
			},
			encyWorkflowState);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the ency workflow states in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowStates the ency workflow states
	 */
	@Override
	public void cacheResult(List<EncyWorkflowState> encyWorkflowStates) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (encyWorkflowStates.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EncyWorkflowState encyWorkflowState : encyWorkflowStates) {
			if (entityCache.getResult(
					EncyWorkflowStateImpl.class,
					encyWorkflowState.getPrimaryKey()) == null) {

				cacheResult(encyWorkflowState);
			}
		}
	}

	/**
	 * Clears the cache for all ency workflow states.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EncyWorkflowStateImpl.class);

		finderCache.clearCache(EncyWorkflowStateImpl.class);
	}

	/**
	 * Clears the cache for the ency workflow state.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EncyWorkflowState encyWorkflowState) {
		entityCache.removeResult(
			EncyWorkflowStateImpl.class, encyWorkflowState);
	}

	@Override
	public void clearCache(List<EncyWorkflowState> encyWorkflowStates) {
		for (EncyWorkflowState encyWorkflowState : encyWorkflowStates) {
			entityCache.removeResult(
				EncyWorkflowStateImpl.class, encyWorkflowState);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EncyWorkflowStateImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EncyWorkflowStateImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EncyWorkflowStateModelImpl encyWorkflowStateModelImpl) {

		Object[] args = new Object[] {
			encyWorkflowStateModelImpl.getWorkflowId(),
			encyWorkflowStateModelImpl.getName()
		};

		finderCache.putResult(_finderPathCountByW_N, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByW_N, args, encyWorkflowStateModelImpl);
	}

	/**
	 * Creates a new ency workflow state with the primary key. Does not add the ency workflow state to the database.
	 *
	 * @param stateId the primary key for the new ency workflow state
	 * @return the new ency workflow state
	 */
	@Override
	public EncyWorkflowState create(long stateId) {
		EncyWorkflowState encyWorkflowState = new EncyWorkflowStateImpl();

		encyWorkflowState.setNew(true);
		encyWorkflowState.setPrimaryKey(stateId);

		String uuid = _portalUUID.generate();

		encyWorkflowState.setUuid(uuid);

		return encyWorkflowState;
	}

	/**
	 * Removes the ency workflow state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stateId the primary key of the ency workflow state
	 * @return the ency workflow state that was removed
	 * @throws NoSuchStateException if a ency workflow state with the primary key could not be found
	 */
	@Override
	public EncyWorkflowState remove(long stateId) throws NoSuchStateException {
		return remove((Serializable)stateId);
	}

	/**
	 * Removes the ency workflow state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ency workflow state
	 * @return the ency workflow state that was removed
	 * @throws NoSuchStateException if a ency workflow state with the primary key could not be found
	 */
	@Override
	public EncyWorkflowState remove(Serializable primaryKey)
		throws NoSuchStateException {

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowState encyWorkflowState =
				(EncyWorkflowState)session.get(
					EncyWorkflowStateImpl.class, primaryKey);

			if (encyWorkflowState == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStateException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(encyWorkflowState);
		}
		catch (NoSuchStateException noSuchEntityException) {
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
	protected EncyWorkflowState removeImpl(
		EncyWorkflowState encyWorkflowState) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(encyWorkflowState)) {
				encyWorkflowState = (EncyWorkflowState)session.get(
					EncyWorkflowStateImpl.class,
					encyWorkflowState.getPrimaryKeyObj());
			}

			if (encyWorkflowState != null) {
				session.delete(encyWorkflowState);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (encyWorkflowState != null) {
			clearCache(encyWorkflowState);
		}

		return encyWorkflowState;
	}

	@Override
	public EncyWorkflowState updateImpl(EncyWorkflowState encyWorkflowState) {
		boolean isNew = encyWorkflowState.isNew();

		if (!(encyWorkflowState instanceof EncyWorkflowStateModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(encyWorkflowState.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					encyWorkflowState);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in encyWorkflowState proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EncyWorkflowState implementation " +
					encyWorkflowState.getClass());
		}

		EncyWorkflowStateModelImpl encyWorkflowStateModelImpl =
			(EncyWorkflowStateModelImpl)encyWorkflowState;

		if (Validator.isNull(encyWorkflowState.getUuid())) {
			String uuid = _portalUUID.generate();

			encyWorkflowState.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (encyWorkflowState.getCreateDate() == null)) {
			if (serviceContext == null) {
				encyWorkflowState.setCreateDate(date);
			}
			else {
				encyWorkflowState.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!encyWorkflowStateModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				encyWorkflowState.setModifiedDate(date);
			}
			else {
				encyWorkflowState.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(encyWorkflowState);
			}
			else {
				encyWorkflowState = (EncyWorkflowState)session.merge(
					encyWorkflowState);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EncyWorkflowStateImpl.class, encyWorkflowStateModelImpl, false,
			true);

		cacheUniqueFindersCache(encyWorkflowStateModelImpl);

		if (isNew) {
			encyWorkflowState.setNew(false);
		}

		encyWorkflowState.resetOriginalValues();

		return encyWorkflowState;
	}

	/**
	 * Returns the ency workflow state with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ency workflow state
	 * @return the ency workflow state
	 * @throws NoSuchStateException if a ency workflow state with the primary key could not be found
	 */
	@Override
	public EncyWorkflowState findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStateException {

		EncyWorkflowState encyWorkflowState = fetchByPrimaryKey(primaryKey);

		if (encyWorkflowState == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStateException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return encyWorkflowState;
	}

	/**
	 * Returns the ency workflow state with the primary key or throws a <code>NoSuchStateException</code> if it could not be found.
	 *
	 * @param stateId the primary key of the ency workflow state
	 * @return the ency workflow state
	 * @throws NoSuchStateException if a ency workflow state with the primary key could not be found
	 */
	@Override
	public EncyWorkflowState findByPrimaryKey(long stateId)
		throws NoSuchStateException {

		return findByPrimaryKey((Serializable)stateId);
	}

	/**
	 * Returns the ency workflow state with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stateId the primary key of the ency workflow state
	 * @return the ency workflow state, or <code>null</code> if a ency workflow state with the primary key could not be found
	 */
	@Override
	public EncyWorkflowState fetchByPrimaryKey(long stateId) {
		return fetchByPrimaryKey((Serializable)stateId);
	}

	/**
	 * Returns all the ency workflow states.
	 *
	 * @return the ency workflow states
	 */
	@Override
	public List<EncyWorkflowState> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @return the range of ency workflow states
	 */
	@Override
	public List<EncyWorkflowState> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ency workflow states
	 */
	@Override
	public List<EncyWorkflowState> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowState> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow states
	 * @param end the upper bound of the range of ency workflow states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ency workflow states
	 */
	@Override
	public List<EncyWorkflowState> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowState> orderByComparator,
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

		List<EncyWorkflowState> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowState>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ENCYWORKFLOWSTATE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ENCYWORKFLOWSTATE;

				sql = sql.concat(EncyWorkflowStateModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EncyWorkflowState>)QueryUtil.list(
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
	 * Removes all the ency workflow states from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EncyWorkflowState encyWorkflowState : findAll()) {
			remove(encyWorkflowState);
		}
	}

	/**
	 * Returns the number of ency workflow states.
	 *
	 * @return the number of ency workflow states
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ENCYWORKFLOWSTATE);

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
		return "stateId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ENCYWORKFLOWSTATE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EncyWorkflowStateModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ency workflow state persistence.
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

		_finderPathFetchByW_N = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByW_N",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"workflowId", "name"}, true);

		_finderPathCountByW_N = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByW_N",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"workflowId", "name"}, false);

		_finderPathWithPaginationFindByWorkflow = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByWorkflow",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"workflowId"}, true);

		_finderPathWithoutPaginationFindByWorkflow = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByWorkflow",
			new String[] {Long.class.getName()}, new String[] {"workflowId"},
			true);

		_finderPathCountByWorkflow = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWorkflow",
			new String[] {Long.class.getName()}, new String[] {"workflowId"},
			false);

		_finderPathWithPaginationFindByActive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActive",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"active_"}, true);

		_finderPathWithoutPaginationFindByActive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActive",
			new String[] {Boolean.class.getName()}, new String[] {"active_"},
			true);

		_finderPathCountByActive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActive",
			new String[] {Boolean.class.getName()}, new String[] {"active_"},
			false);

		_setEncyWorkflowStateUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setEncyWorkflowStateUtilPersistence(null);

		entityCache.removeCache(EncyWorkflowStateImpl.class.getName());
	}

	private void _setEncyWorkflowStateUtilPersistence(
		EncyWorkflowStatePersistence encyWorkflowStatePersistence) {

		try {
			Field field = EncyWorkflowStateUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, encyWorkflowStatePersistence);
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

	private static final String _SQL_SELECT_ENCYWORKFLOWSTATE =
		"SELECT encyWorkflowState FROM EncyWorkflowState encyWorkflowState";

	private static final String _SQL_SELECT_ENCYWORKFLOWSTATE_WHERE =
		"SELECT encyWorkflowState FROM EncyWorkflowState encyWorkflowState WHERE ";

	private static final String _SQL_COUNT_ENCYWORKFLOWSTATE =
		"SELECT COUNT(encyWorkflowState) FROM EncyWorkflowState encyWorkflowState";

	private static final String _SQL_COUNT_ENCYWORKFLOWSTATE_WHERE =
		"SELECT COUNT(encyWorkflowState) FROM EncyWorkflowState encyWorkflowState WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "encyWorkflowState.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EncyWorkflowState exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EncyWorkflowState exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EncyWorkflowStatePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "active"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private EncyWorkflowStateModelArgumentsResolver
		_encyWorkflowStateModelArgumentsResolver;

}