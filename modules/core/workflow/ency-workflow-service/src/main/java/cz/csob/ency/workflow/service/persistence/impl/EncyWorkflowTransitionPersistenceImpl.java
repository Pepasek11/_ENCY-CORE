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

import cz.csob.ency.workflow.exception.NoSuchTransitionException;
import cz.csob.ency.workflow.model.EncyWorkflowTransition;
import cz.csob.ency.workflow.model.EncyWorkflowTransitionTable;
import cz.csob.ency.workflow.model.impl.EncyWorkflowTransitionImpl;
import cz.csob.ency.workflow.model.impl.EncyWorkflowTransitionModelImpl;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowTransitionPersistence;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowTransitionUtil;
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
 * The persistence implementation for the ency workflow transition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @generated
 */
@Component(
	service = {EncyWorkflowTransitionPersistence.class, BasePersistence.class}
)
public class EncyWorkflowTransitionPersistenceImpl
	extends BasePersistenceImpl<EncyWorkflowTransition>
	implements EncyWorkflowTransitionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EncyWorkflowTransitionUtil</code> to access the ency workflow transition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EncyWorkflowTransitionImpl.class.getName();

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
	 * Returns all the ency workflow transitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ency workflow transitions
	 */
	@Override
	public List<EncyWorkflowTransition> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow transitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @return the range of matching ency workflow transitions
	 */
	@Override
	public List<EncyWorkflowTransition> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow transitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow transitions
	 */
	@Override
	public List<EncyWorkflowTransition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow transitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow transitions
	 */
	@Override
	public List<EncyWorkflowTransition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowTransition> orderByComparator,
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

		List<EncyWorkflowTransition> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowTransition>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowTransition encyWorkflowTransition : list) {
					if (!uuid.equals(encyWorkflowTransition.getUuid())) {
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

			sb.append(_SQL_SELECT_ENCYWORKFLOWTRANSITION_WHERE);

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
				sb.append(EncyWorkflowTransitionModelImpl.ORDER_BY_JPQL);
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

				list = (List<EncyWorkflowTransition>)QueryUtil.list(
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
	 * Returns the first ency workflow transition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	@Override
	public EncyWorkflowTransition findByUuid_First(
			String uuid,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException {

		EncyWorkflowTransition encyWorkflowTransition = fetchByUuid_First(
			uuid, orderByComparator);

		if (encyWorkflowTransition != null) {
			return encyWorkflowTransition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTransitionException(sb.toString());
	}

	/**
	 * Returns the first ency workflow transition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	@Override
	public EncyWorkflowTransition fetchByUuid_First(
		String uuid,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		List<EncyWorkflowTransition> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow transition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	@Override
	public EncyWorkflowTransition findByUuid_Last(
			String uuid,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException {

		EncyWorkflowTransition encyWorkflowTransition = fetchByUuid_Last(
			uuid, orderByComparator);

		if (encyWorkflowTransition != null) {
			return encyWorkflowTransition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTransitionException(sb.toString());
	}

	/**
	 * Returns the last ency workflow transition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	@Override
	public EncyWorkflowTransition fetchByUuid_Last(
		String uuid,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflowTransition> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflow transitions before and after the current ency workflow transition in the ordered set where uuid = &#63;.
	 *
	 * @param transitionId the primary key of the current ency workflow transition
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow transition
	 * @throws NoSuchTransitionException if a ency workflow transition with the primary key could not be found
	 */
	@Override
	public EncyWorkflowTransition[] findByUuid_PrevAndNext(
			long transitionId, String uuid,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException {

		uuid = Objects.toString(uuid, "");

		EncyWorkflowTransition encyWorkflowTransition = findByPrimaryKey(
			transitionId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowTransition[] array = new EncyWorkflowTransitionImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, encyWorkflowTransition, uuid, orderByComparator, true);

			array[1] = encyWorkflowTransition;

			array[2] = getByUuid_PrevAndNext(
				session, encyWorkflowTransition, uuid, orderByComparator,
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

	protected EncyWorkflowTransition getByUuid_PrevAndNext(
		Session session, EncyWorkflowTransition encyWorkflowTransition,
		String uuid,
		OrderByComparator<EncyWorkflowTransition> orderByComparator,
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

		sb.append(_SQL_SELECT_ENCYWORKFLOWTRANSITION_WHERE);

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
			sb.append(EncyWorkflowTransitionModelImpl.ORDER_BY_JPQL);
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
						encyWorkflowTransition)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflowTransition> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ency workflow transitions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EncyWorkflowTransition encyWorkflowTransition :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(encyWorkflowTransition);
		}
	}

	/**
	 * Returns the number of ency workflow transitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ency workflow transitions
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ENCYWORKFLOWTRANSITION_WHERE);

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
		"encyWorkflowTransition.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(encyWorkflowTransition.uuid IS NULL OR encyWorkflowTransition.uuid = '')";

	private FinderPath _finderPathFetchByS_N;
	private FinderPath _finderPathCountByS_N;

	/**
	 * Returns the ency workflow transition where stateId = &#63; and name = &#63; or throws a <code>NoSuchTransitionException</code> if it could not be found.
	 *
	 * @param stateId the state ID
	 * @param name the name
	 * @return the matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	@Override
	public EncyWorkflowTransition findByS_N(long stateId, String name)
		throws NoSuchTransitionException {

		EncyWorkflowTransition encyWorkflowTransition = fetchByS_N(
			stateId, name);

		if (encyWorkflowTransition == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("stateId=");
			sb.append(stateId);

			sb.append(", name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTransitionException(sb.toString());
		}

		return encyWorkflowTransition;
	}

	/**
	 * Returns the ency workflow transition where stateId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param stateId the state ID
	 * @param name the name
	 * @return the matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	@Override
	public EncyWorkflowTransition fetchByS_N(long stateId, String name) {
		return fetchByS_N(stateId, name, true);
	}

	/**
	 * Returns the ency workflow transition where stateId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param stateId the state ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	@Override
	public EncyWorkflowTransition fetchByS_N(
		long stateId, String name, boolean useFinderCache) {

		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {stateId, name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByS_N, finderArgs);
		}

		if (result instanceof EncyWorkflowTransition) {
			EncyWorkflowTransition encyWorkflowTransition =
				(EncyWorkflowTransition)result;

			if ((stateId != encyWorkflowTransition.getStateId()) ||
				!Objects.equals(name, encyWorkflowTransition.getName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ENCYWORKFLOWTRANSITION_WHERE);

			sb.append(_FINDER_COLUMN_S_N_STATEID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_S_N_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_S_N_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(stateId);

				if (bindName) {
					queryPos.add(name);
				}

				List<EncyWorkflowTransition> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByS_N, finderArgs, list);
					}
				}
				else {
					EncyWorkflowTransition encyWorkflowTransition = list.get(0);

					result = encyWorkflowTransition;

					cacheResult(encyWorkflowTransition);
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
			return (EncyWorkflowTransition)result;
		}
	}

	/**
	 * Removes the ency workflow transition where stateId = &#63; and name = &#63; from the database.
	 *
	 * @param stateId the state ID
	 * @param name the name
	 * @return the ency workflow transition that was removed
	 */
	@Override
	public EncyWorkflowTransition removeByS_N(long stateId, String name)
		throws NoSuchTransitionException {

		EncyWorkflowTransition encyWorkflowTransition = findByS_N(
			stateId, name);

		return remove(encyWorkflowTransition);
	}

	/**
	 * Returns the number of ency workflow transitions where stateId = &#63; and name = &#63;.
	 *
	 * @param stateId the state ID
	 * @param name the name
	 * @return the number of matching ency workflow transitions
	 */
	@Override
	public int countByS_N(long stateId, String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByS_N;

		Object[] finderArgs = new Object[] {stateId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ENCYWORKFLOWTRANSITION_WHERE);

			sb.append(_FINDER_COLUMN_S_N_STATEID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_S_N_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_S_N_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(stateId);

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

	private static final String _FINDER_COLUMN_S_N_STATEID_2 =
		"encyWorkflowTransition.stateId = ? AND ";

	private static final String _FINDER_COLUMN_S_N_NAME_2 =
		"encyWorkflowTransition.name = ?";

	private static final String _FINDER_COLUMN_S_N_NAME_3 =
		"(encyWorkflowTransition.name IS NULL OR encyWorkflowTransition.name = '')";

	private FinderPath _finderPathWithPaginationFindByWorkflow;
	private FinderPath _finderPathWithoutPaginationFindByWorkflow;
	private FinderPath _finderPathCountByWorkflow;

	/**
	 * Returns all the ency workflow transitions where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @return the matching ency workflow transitions
	 */
	@Override
	public List<EncyWorkflowTransition> findByWorkflow(long workflowId) {
		return findByWorkflow(
			workflowId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow transitions where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @return the range of matching ency workflow transitions
	 */
	@Override
	public List<EncyWorkflowTransition> findByWorkflow(
		long workflowId, int start, int end) {

		return findByWorkflow(workflowId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow transitions where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow transitions
	 */
	@Override
	public List<EncyWorkflowTransition> findByWorkflow(
		long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		return findByWorkflow(workflowId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow transitions where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow transitions
	 */
	@Override
	public List<EncyWorkflowTransition> findByWorkflow(
		long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowTransition> orderByComparator,
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

		List<EncyWorkflowTransition> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowTransition>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowTransition encyWorkflowTransition : list) {
					if (workflowId != encyWorkflowTransition.getWorkflowId()) {
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

			sb.append(_SQL_SELECT_ENCYWORKFLOWTRANSITION_WHERE);

			sb.append(_FINDER_COLUMN_WORKFLOW_WORKFLOWID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EncyWorkflowTransitionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workflowId);

				list = (List<EncyWorkflowTransition>)QueryUtil.list(
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
	 * Returns the first ency workflow transition in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	@Override
	public EncyWorkflowTransition findByWorkflow_First(
			long workflowId,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException {

		EncyWorkflowTransition encyWorkflowTransition = fetchByWorkflow_First(
			workflowId, orderByComparator);

		if (encyWorkflowTransition != null) {
			return encyWorkflowTransition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workflowId=");
		sb.append(workflowId);

		sb.append("}");

		throw new NoSuchTransitionException(sb.toString());
	}

	/**
	 * Returns the first ency workflow transition in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	@Override
	public EncyWorkflowTransition fetchByWorkflow_First(
		long workflowId,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		List<EncyWorkflowTransition> list = findByWorkflow(
			workflowId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow transition in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	@Override
	public EncyWorkflowTransition findByWorkflow_Last(
			long workflowId,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException {

		EncyWorkflowTransition encyWorkflowTransition = fetchByWorkflow_Last(
			workflowId, orderByComparator);

		if (encyWorkflowTransition != null) {
			return encyWorkflowTransition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workflowId=");
		sb.append(workflowId);

		sb.append("}");

		throw new NoSuchTransitionException(sb.toString());
	}

	/**
	 * Returns the last ency workflow transition in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	@Override
	public EncyWorkflowTransition fetchByWorkflow_Last(
		long workflowId,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		int count = countByWorkflow(workflowId);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflowTransition> list = findByWorkflow(
			workflowId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflow transitions before and after the current ency workflow transition in the ordered set where workflowId = &#63;.
	 *
	 * @param transitionId the primary key of the current ency workflow transition
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow transition
	 * @throws NoSuchTransitionException if a ency workflow transition with the primary key could not be found
	 */
	@Override
	public EncyWorkflowTransition[] findByWorkflow_PrevAndNext(
			long transitionId, long workflowId,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException {

		EncyWorkflowTransition encyWorkflowTransition = findByPrimaryKey(
			transitionId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowTransition[] array = new EncyWorkflowTransitionImpl[3];

			array[0] = getByWorkflow_PrevAndNext(
				session, encyWorkflowTransition, workflowId, orderByComparator,
				true);

			array[1] = encyWorkflowTransition;

			array[2] = getByWorkflow_PrevAndNext(
				session, encyWorkflowTransition, workflowId, orderByComparator,
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

	protected EncyWorkflowTransition getByWorkflow_PrevAndNext(
		Session session, EncyWorkflowTransition encyWorkflowTransition,
		long workflowId,
		OrderByComparator<EncyWorkflowTransition> orderByComparator,
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

		sb.append(_SQL_SELECT_ENCYWORKFLOWTRANSITION_WHERE);

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
			sb.append(EncyWorkflowTransitionModelImpl.ORDER_BY_JPQL);
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
						encyWorkflowTransition)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflowTransition> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ency workflow transitions where workflowId = &#63; from the database.
	 *
	 * @param workflowId the workflow ID
	 */
	@Override
	public void removeByWorkflow(long workflowId) {
		for (EncyWorkflowTransition encyWorkflowTransition :
				findByWorkflow(
					workflowId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(encyWorkflowTransition);
		}
	}

	/**
	 * Returns the number of ency workflow transitions where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @return the number of matching ency workflow transitions
	 */
	@Override
	public int countByWorkflow(long workflowId) {
		FinderPath finderPath = _finderPathCountByWorkflow;

		Object[] finderArgs = new Object[] {workflowId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ENCYWORKFLOWTRANSITION_WHERE);

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
		"encyWorkflowTransition.workflowId = ?";

	private FinderPath _finderPathWithPaginationFindByState;
	private FinderPath _finderPathWithoutPaginationFindByState;
	private FinderPath _finderPathCountByState;

	/**
	 * Returns all the ency workflow transitions where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the matching ency workflow transitions
	 */
	@Override
	public List<EncyWorkflowTransition> findByState(long stateId) {
		return findByState(stateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow transitions where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @return the range of matching ency workflow transitions
	 */
	@Override
	public List<EncyWorkflowTransition> findByState(
		long stateId, int start, int end) {

		return findByState(stateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow transitions where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow transitions
	 */
	@Override
	public List<EncyWorkflowTransition> findByState(
		long stateId, int start, int end,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		return findByState(stateId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow transitions where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow transitions
	 */
	@Override
	public List<EncyWorkflowTransition> findByState(
		long stateId, int start, int end,
		OrderByComparator<EncyWorkflowTransition> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByState;
				finderArgs = new Object[] {stateId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByState;
			finderArgs = new Object[] {stateId, start, end, orderByComparator};
		}

		List<EncyWorkflowTransition> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowTransition>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowTransition encyWorkflowTransition : list) {
					if (stateId != encyWorkflowTransition.getStateId()) {
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

			sb.append(_SQL_SELECT_ENCYWORKFLOWTRANSITION_WHERE);

			sb.append(_FINDER_COLUMN_STATE_STATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EncyWorkflowTransitionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(stateId);

				list = (List<EncyWorkflowTransition>)QueryUtil.list(
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
	 * Returns the first ency workflow transition in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	@Override
	public EncyWorkflowTransition findByState_First(
			long stateId,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException {

		EncyWorkflowTransition encyWorkflowTransition = fetchByState_First(
			stateId, orderByComparator);

		if (encyWorkflowTransition != null) {
			return encyWorkflowTransition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stateId=");
		sb.append(stateId);

		sb.append("}");

		throw new NoSuchTransitionException(sb.toString());
	}

	/**
	 * Returns the first ency workflow transition in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	@Override
	public EncyWorkflowTransition fetchByState_First(
		long stateId,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		List<EncyWorkflowTransition> list = findByState(
			stateId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow transition in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	@Override
	public EncyWorkflowTransition findByState_Last(
			long stateId,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException {

		EncyWorkflowTransition encyWorkflowTransition = fetchByState_Last(
			stateId, orderByComparator);

		if (encyWorkflowTransition != null) {
			return encyWorkflowTransition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stateId=");
		sb.append(stateId);

		sb.append("}");

		throw new NoSuchTransitionException(sb.toString());
	}

	/**
	 * Returns the last ency workflow transition in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	@Override
	public EncyWorkflowTransition fetchByState_Last(
		long stateId,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		int count = countByState(stateId);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflowTransition> list = findByState(
			stateId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflow transitions before and after the current ency workflow transition in the ordered set where stateId = &#63;.
	 *
	 * @param transitionId the primary key of the current ency workflow transition
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow transition
	 * @throws NoSuchTransitionException if a ency workflow transition with the primary key could not be found
	 */
	@Override
	public EncyWorkflowTransition[] findByState_PrevAndNext(
			long transitionId, long stateId,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException {

		EncyWorkflowTransition encyWorkflowTransition = findByPrimaryKey(
			transitionId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowTransition[] array = new EncyWorkflowTransitionImpl[3];

			array[0] = getByState_PrevAndNext(
				session, encyWorkflowTransition, stateId, orderByComparator,
				true);

			array[1] = encyWorkflowTransition;

			array[2] = getByState_PrevAndNext(
				session, encyWorkflowTransition, stateId, orderByComparator,
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

	protected EncyWorkflowTransition getByState_PrevAndNext(
		Session session, EncyWorkflowTransition encyWorkflowTransition,
		long stateId,
		OrderByComparator<EncyWorkflowTransition> orderByComparator,
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

		sb.append(_SQL_SELECT_ENCYWORKFLOWTRANSITION_WHERE);

		sb.append(_FINDER_COLUMN_STATE_STATEID_2);

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
			sb.append(EncyWorkflowTransitionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(stateId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						encyWorkflowTransition)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflowTransition> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ency workflow transitions where stateId = &#63; from the database.
	 *
	 * @param stateId the state ID
	 */
	@Override
	public void removeByState(long stateId) {
		for (EncyWorkflowTransition encyWorkflowTransition :
				findByState(
					stateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(encyWorkflowTransition);
		}
	}

	/**
	 * Returns the number of ency workflow transitions where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the number of matching ency workflow transitions
	 */
	@Override
	public int countByState(long stateId) {
		FinderPath finderPath = _finderPathCountByState;

		Object[] finderArgs = new Object[] {stateId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ENCYWORKFLOWTRANSITION_WHERE);

			sb.append(_FINDER_COLUMN_STATE_STATEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(stateId);

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

	private static final String _FINDER_COLUMN_STATE_STATEID_2 =
		"encyWorkflowTransition.stateId = ?";

	private FinderPath _finderPathWithPaginationFindByActive;
	private FinderPath _finderPathWithoutPaginationFindByActive;
	private FinderPath _finderPathCountByActive;

	/**
	 * Returns all the ency workflow transitions where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching ency workflow transitions
	 */
	@Override
	public List<EncyWorkflowTransition> findByActive(Boolean active) {
		return findByActive(active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow transitions where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @return the range of matching ency workflow transitions
	 */
	@Override
	public List<EncyWorkflowTransition> findByActive(
		Boolean active, int start, int end) {

		return findByActive(active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow transitions where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow transitions
	 */
	@Override
	public List<EncyWorkflowTransition> findByActive(
		Boolean active, int start, int end,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		return findByActive(active, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow transitions where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow transitions
	 */
	@Override
	public List<EncyWorkflowTransition> findByActive(
		Boolean active, int start, int end,
		OrderByComparator<EncyWorkflowTransition> orderByComparator,
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

		List<EncyWorkflowTransition> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowTransition>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowTransition encyWorkflowTransition : list) {
					if (!Objects.equals(
							active, encyWorkflowTransition.getActive())) {

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

			sb.append(_SQL_SELECT_ENCYWORKFLOWTRANSITION_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EncyWorkflowTransitionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(active.booleanValue());

				list = (List<EncyWorkflowTransition>)QueryUtil.list(
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
	 * Returns the first ency workflow transition in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	@Override
	public EncyWorkflowTransition findByActive_First(
			Boolean active,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException {

		EncyWorkflowTransition encyWorkflowTransition = fetchByActive_First(
			active, orderByComparator);

		if (encyWorkflowTransition != null) {
			return encyWorkflowTransition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchTransitionException(sb.toString());
	}

	/**
	 * Returns the first ency workflow transition in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	@Override
	public EncyWorkflowTransition fetchByActive_First(
		Boolean active,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		List<EncyWorkflowTransition> list = findByActive(
			active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow transition in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition
	 * @throws NoSuchTransitionException if a matching ency workflow transition could not be found
	 */
	@Override
	public EncyWorkflowTransition findByActive_Last(
			Boolean active,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException {

		EncyWorkflowTransition encyWorkflowTransition = fetchByActive_Last(
			active, orderByComparator);

		if (encyWorkflowTransition != null) {
			return encyWorkflowTransition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchTransitionException(sb.toString());
	}

	/**
	 * Returns the last ency workflow transition in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow transition, or <code>null</code> if a matching ency workflow transition could not be found
	 */
	@Override
	public EncyWorkflowTransition fetchByActive_Last(
		Boolean active,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		int count = countByActive(active);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflowTransition> list = findByActive(
			active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflow transitions before and after the current ency workflow transition in the ordered set where active = &#63;.
	 *
	 * @param transitionId the primary key of the current ency workflow transition
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow transition
	 * @throws NoSuchTransitionException if a ency workflow transition with the primary key could not be found
	 */
	@Override
	public EncyWorkflowTransition[] findByActive_PrevAndNext(
			long transitionId, Boolean active,
			OrderByComparator<EncyWorkflowTransition> orderByComparator)
		throws NoSuchTransitionException {

		EncyWorkflowTransition encyWorkflowTransition = findByPrimaryKey(
			transitionId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowTransition[] array = new EncyWorkflowTransitionImpl[3];

			array[0] = getByActive_PrevAndNext(
				session, encyWorkflowTransition, active, orderByComparator,
				true);

			array[1] = encyWorkflowTransition;

			array[2] = getByActive_PrevAndNext(
				session, encyWorkflowTransition, active, orderByComparator,
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

	protected EncyWorkflowTransition getByActive_PrevAndNext(
		Session session, EncyWorkflowTransition encyWorkflowTransition,
		Boolean active,
		OrderByComparator<EncyWorkflowTransition> orderByComparator,
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

		sb.append(_SQL_SELECT_ENCYWORKFLOWTRANSITION_WHERE);

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
			sb.append(EncyWorkflowTransitionModelImpl.ORDER_BY_JPQL);
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
						encyWorkflowTransition)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflowTransition> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ency workflow transitions where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	@Override
	public void removeByActive(Boolean active) {
		for (EncyWorkflowTransition encyWorkflowTransition :
				findByActive(
					active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(encyWorkflowTransition);
		}
	}

	/**
	 * Returns the number of ency workflow transitions where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching ency workflow transitions
	 */
	@Override
	public int countByActive(Boolean active) {
		FinderPath finderPath = _finderPathCountByActive;

		Object[] finderArgs = new Object[] {active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ENCYWORKFLOWTRANSITION_WHERE);

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
		"encyWorkflowTransition.active = ?";

	public EncyWorkflowTransitionPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("active", "active_");
		dbColumnNames.put("order", "order_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EncyWorkflowTransition.class);

		setModelImplClass(EncyWorkflowTransitionImpl.class);
		setModelPKClass(long.class);

		setTable(EncyWorkflowTransitionTable.INSTANCE);
	}

	/**
	 * Caches the ency workflow transition in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowTransition the ency workflow transition
	 */
	@Override
	public void cacheResult(EncyWorkflowTransition encyWorkflowTransition) {
		entityCache.putResult(
			EncyWorkflowTransitionImpl.class,
			encyWorkflowTransition.getPrimaryKey(), encyWorkflowTransition);

		finderCache.putResult(
			_finderPathFetchByS_N,
			new Object[] {
				encyWorkflowTransition.getStateId(),
				encyWorkflowTransition.getName()
			},
			encyWorkflowTransition);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the ency workflow transitions in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowTransitions the ency workflow transitions
	 */
	@Override
	public void cacheResult(
		List<EncyWorkflowTransition> encyWorkflowTransitions) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (encyWorkflowTransitions.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EncyWorkflowTransition encyWorkflowTransition :
				encyWorkflowTransitions) {

			if (entityCache.getResult(
					EncyWorkflowTransitionImpl.class,
					encyWorkflowTransition.getPrimaryKey()) == null) {

				cacheResult(encyWorkflowTransition);
			}
		}
	}

	/**
	 * Clears the cache for all ency workflow transitions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EncyWorkflowTransitionImpl.class);

		finderCache.clearCache(EncyWorkflowTransitionImpl.class);
	}

	/**
	 * Clears the cache for the ency workflow transition.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EncyWorkflowTransition encyWorkflowTransition) {
		entityCache.removeResult(
			EncyWorkflowTransitionImpl.class, encyWorkflowTransition);
	}

	@Override
	public void clearCache(
		List<EncyWorkflowTransition> encyWorkflowTransitions) {

		for (EncyWorkflowTransition encyWorkflowTransition :
				encyWorkflowTransitions) {

			entityCache.removeResult(
				EncyWorkflowTransitionImpl.class, encyWorkflowTransition);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EncyWorkflowTransitionImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				EncyWorkflowTransitionImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EncyWorkflowTransitionModelImpl encyWorkflowTransitionModelImpl) {

		Object[] args = new Object[] {
			encyWorkflowTransitionModelImpl.getStateId(),
			encyWorkflowTransitionModelImpl.getName()
		};

		finderCache.putResult(_finderPathCountByS_N, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByS_N, args, encyWorkflowTransitionModelImpl);
	}

	/**
	 * Creates a new ency workflow transition with the primary key. Does not add the ency workflow transition to the database.
	 *
	 * @param transitionId the primary key for the new ency workflow transition
	 * @return the new ency workflow transition
	 */
	@Override
	public EncyWorkflowTransition create(long transitionId) {
		EncyWorkflowTransition encyWorkflowTransition =
			new EncyWorkflowTransitionImpl();

		encyWorkflowTransition.setNew(true);
		encyWorkflowTransition.setPrimaryKey(transitionId);

		String uuid = _portalUUID.generate();

		encyWorkflowTransition.setUuid(uuid);

		return encyWorkflowTransition;
	}

	/**
	 * Removes the ency workflow transition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transitionId the primary key of the ency workflow transition
	 * @return the ency workflow transition that was removed
	 * @throws NoSuchTransitionException if a ency workflow transition with the primary key could not be found
	 */
	@Override
	public EncyWorkflowTransition remove(long transitionId)
		throws NoSuchTransitionException {

		return remove((Serializable)transitionId);
	}

	/**
	 * Removes the ency workflow transition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ency workflow transition
	 * @return the ency workflow transition that was removed
	 * @throws NoSuchTransitionException if a ency workflow transition with the primary key could not be found
	 */
	@Override
	public EncyWorkflowTransition remove(Serializable primaryKey)
		throws NoSuchTransitionException {

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowTransition encyWorkflowTransition =
				(EncyWorkflowTransition)session.get(
					EncyWorkflowTransitionImpl.class, primaryKey);

			if (encyWorkflowTransition == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTransitionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(encyWorkflowTransition);
		}
		catch (NoSuchTransitionException noSuchEntityException) {
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
	protected EncyWorkflowTransition removeImpl(
		EncyWorkflowTransition encyWorkflowTransition) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(encyWorkflowTransition)) {
				encyWorkflowTransition = (EncyWorkflowTransition)session.get(
					EncyWorkflowTransitionImpl.class,
					encyWorkflowTransition.getPrimaryKeyObj());
			}

			if (encyWorkflowTransition != null) {
				session.delete(encyWorkflowTransition);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (encyWorkflowTransition != null) {
			clearCache(encyWorkflowTransition);
		}

		return encyWorkflowTransition;
	}

	@Override
	public EncyWorkflowTransition updateImpl(
		EncyWorkflowTransition encyWorkflowTransition) {

		boolean isNew = encyWorkflowTransition.isNew();

		if (!(encyWorkflowTransition instanceof
				EncyWorkflowTransitionModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(encyWorkflowTransition.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					encyWorkflowTransition);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in encyWorkflowTransition proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EncyWorkflowTransition implementation " +
					encyWorkflowTransition.getClass());
		}

		EncyWorkflowTransitionModelImpl encyWorkflowTransitionModelImpl =
			(EncyWorkflowTransitionModelImpl)encyWorkflowTransition;

		if (Validator.isNull(encyWorkflowTransition.getUuid())) {
			String uuid = _portalUUID.generate();

			encyWorkflowTransition.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (encyWorkflowTransition.getCreateDate() == null)) {
			if (serviceContext == null) {
				encyWorkflowTransition.setCreateDate(date);
			}
			else {
				encyWorkflowTransition.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!encyWorkflowTransitionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				encyWorkflowTransition.setModifiedDate(date);
			}
			else {
				encyWorkflowTransition.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(encyWorkflowTransition);
			}
			else {
				encyWorkflowTransition = (EncyWorkflowTransition)session.merge(
					encyWorkflowTransition);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EncyWorkflowTransitionImpl.class, encyWorkflowTransitionModelImpl,
			false, true);

		cacheUniqueFindersCache(encyWorkflowTransitionModelImpl);

		if (isNew) {
			encyWorkflowTransition.setNew(false);
		}

		encyWorkflowTransition.resetOriginalValues();

		return encyWorkflowTransition;
	}

	/**
	 * Returns the ency workflow transition with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ency workflow transition
	 * @return the ency workflow transition
	 * @throws NoSuchTransitionException if a ency workflow transition with the primary key could not be found
	 */
	@Override
	public EncyWorkflowTransition findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTransitionException {

		EncyWorkflowTransition encyWorkflowTransition = fetchByPrimaryKey(
			primaryKey);

		if (encyWorkflowTransition == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTransitionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return encyWorkflowTransition;
	}

	/**
	 * Returns the ency workflow transition with the primary key or throws a <code>NoSuchTransitionException</code> if it could not be found.
	 *
	 * @param transitionId the primary key of the ency workflow transition
	 * @return the ency workflow transition
	 * @throws NoSuchTransitionException if a ency workflow transition with the primary key could not be found
	 */
	@Override
	public EncyWorkflowTransition findByPrimaryKey(long transitionId)
		throws NoSuchTransitionException {

		return findByPrimaryKey((Serializable)transitionId);
	}

	/**
	 * Returns the ency workflow transition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param transitionId the primary key of the ency workflow transition
	 * @return the ency workflow transition, or <code>null</code> if a ency workflow transition with the primary key could not be found
	 */
	@Override
	public EncyWorkflowTransition fetchByPrimaryKey(long transitionId) {
		return fetchByPrimaryKey((Serializable)transitionId);
	}

	/**
	 * Returns all the ency workflow transitions.
	 *
	 * @return the ency workflow transitions
	 */
	@Override
	public List<EncyWorkflowTransition> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow transitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @return the range of ency workflow transitions
	 */
	@Override
	public List<EncyWorkflowTransition> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow transitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ency workflow transitions
	 */
	@Override
	public List<EncyWorkflowTransition> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowTransition> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow transitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ency workflow transitions
	 */
	@Override
	public List<EncyWorkflowTransition> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowTransition> orderByComparator,
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

		List<EncyWorkflowTransition> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowTransition>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ENCYWORKFLOWTRANSITION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ENCYWORKFLOWTRANSITION;

				sql = sql.concat(EncyWorkflowTransitionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EncyWorkflowTransition>)QueryUtil.list(
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
	 * Removes all the ency workflow transitions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EncyWorkflowTransition encyWorkflowTransition : findAll()) {
			remove(encyWorkflowTransition);
		}
	}

	/**
	 * Returns the number of ency workflow transitions.
	 *
	 * @return the number of ency workflow transitions
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
					_SQL_COUNT_ENCYWORKFLOWTRANSITION);

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
		return "transitionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ENCYWORKFLOWTRANSITION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EncyWorkflowTransitionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ency workflow transition persistence.
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

		_finderPathFetchByS_N = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByS_N",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"stateId", "name"}, true);

		_finderPathCountByS_N = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_N",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"stateId", "name"}, false);

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

		_finderPathWithPaginationFindByState = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByState",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"stateId"}, true);

		_finderPathWithoutPaginationFindByState = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByState",
			new String[] {Long.class.getName()}, new String[] {"stateId"},
			true);

		_finderPathCountByState = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByState",
			new String[] {Long.class.getName()}, new String[] {"stateId"},
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

		_setEncyWorkflowTransitionUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setEncyWorkflowTransitionUtilPersistence(null);

		entityCache.removeCache(EncyWorkflowTransitionImpl.class.getName());
	}

	private void _setEncyWorkflowTransitionUtilPersistence(
		EncyWorkflowTransitionPersistence encyWorkflowTransitionPersistence) {

		try {
			Field field = EncyWorkflowTransitionUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, encyWorkflowTransitionPersistence);
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

	private static final String _SQL_SELECT_ENCYWORKFLOWTRANSITION =
		"SELECT encyWorkflowTransition FROM EncyWorkflowTransition encyWorkflowTransition";

	private static final String _SQL_SELECT_ENCYWORKFLOWTRANSITION_WHERE =
		"SELECT encyWorkflowTransition FROM EncyWorkflowTransition encyWorkflowTransition WHERE ";

	private static final String _SQL_COUNT_ENCYWORKFLOWTRANSITION =
		"SELECT COUNT(encyWorkflowTransition) FROM EncyWorkflowTransition encyWorkflowTransition";

	private static final String _SQL_COUNT_ENCYWORKFLOWTRANSITION_WHERE =
		"SELECT COUNT(encyWorkflowTransition) FROM EncyWorkflowTransition encyWorkflowTransition WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"encyWorkflowTransition.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EncyWorkflowTransition exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EncyWorkflowTransition exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EncyWorkflowTransitionPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "active", "order"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private EncyWorkflowTransitionModelArgumentsResolver
		_encyWorkflowTransitionModelArgumentsResolver;

}