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

import cz.csob.ency.workflow.exception.NoSuchEncyWorkflowException;
import cz.csob.ency.workflow.model.EncyWorkflow;
import cz.csob.ency.workflow.model.EncyWorkflowTable;
import cz.csob.ency.workflow.model.impl.EncyWorkflowImpl;
import cz.csob.ency.workflow.model.impl.EncyWorkflowModelImpl;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowPersistence;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowUtil;
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
 * The persistence implementation for the ency workflow service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @generated
 */
@Component(service = {EncyWorkflowPersistence.class, BasePersistence.class})
public class EncyWorkflowPersistenceImpl
	extends BasePersistenceImpl<EncyWorkflow>
	implements EncyWorkflowPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EncyWorkflowUtil</code> to access the ency workflow persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EncyWorkflowImpl.class.getName();

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
	 * Returns all the ency workflows where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ency workflows
	 */
	@Override
	public List<EncyWorkflow> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflows where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @return the range of matching ency workflows
	 */
	@Override
	public List<EncyWorkflow> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflows where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflows
	 */
	@Override
	public List<EncyWorkflow> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflow> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflows where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflows
	 */
	@Override
	public List<EncyWorkflow> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflow> orderByComparator,
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

		List<EncyWorkflow> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflow>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflow encyWorkflow : list) {
					if (!uuid.equals(encyWorkflow.getUuid())) {
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

			sb.append(_SQL_SELECT_ENCYWORKFLOW_WHERE);

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
				sb.append(EncyWorkflowModelImpl.ORDER_BY_JPQL);
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

				list = (List<EncyWorkflow>)QueryUtil.list(
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
	 * Returns the first ency workflow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow
	 * @throws NoSuchEncyWorkflowException if a matching ency workflow could not be found
	 */
	@Override
	public EncyWorkflow findByUuid_First(
			String uuid, OrderByComparator<EncyWorkflow> orderByComparator)
		throws NoSuchEncyWorkflowException {

		EncyWorkflow encyWorkflow = fetchByUuid_First(uuid, orderByComparator);

		if (encyWorkflow != null) {
			return encyWorkflow;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEncyWorkflowException(sb.toString());
	}

	/**
	 * Returns the first ency workflow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow, or <code>null</code> if a matching ency workflow could not be found
	 */
	@Override
	public EncyWorkflow fetchByUuid_First(
		String uuid, OrderByComparator<EncyWorkflow> orderByComparator) {

		List<EncyWorkflow> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow
	 * @throws NoSuchEncyWorkflowException if a matching ency workflow could not be found
	 */
	@Override
	public EncyWorkflow findByUuid_Last(
			String uuid, OrderByComparator<EncyWorkflow> orderByComparator)
		throws NoSuchEncyWorkflowException {

		EncyWorkflow encyWorkflow = fetchByUuid_Last(uuid, orderByComparator);

		if (encyWorkflow != null) {
			return encyWorkflow;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEncyWorkflowException(sb.toString());
	}

	/**
	 * Returns the last ency workflow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow, or <code>null</code> if a matching ency workflow could not be found
	 */
	@Override
	public EncyWorkflow fetchByUuid_Last(
		String uuid, OrderByComparator<EncyWorkflow> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflow> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflows before and after the current ency workflow in the ordered set where uuid = &#63;.
	 *
	 * @param workflowId the primary key of the current ency workflow
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow
	 * @throws NoSuchEncyWorkflowException if a ency workflow with the primary key could not be found
	 */
	@Override
	public EncyWorkflow[] findByUuid_PrevAndNext(
			long workflowId, String uuid,
			OrderByComparator<EncyWorkflow> orderByComparator)
		throws NoSuchEncyWorkflowException {

		uuid = Objects.toString(uuid, "");

		EncyWorkflow encyWorkflow = findByPrimaryKey(workflowId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflow[] array = new EncyWorkflowImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, encyWorkflow, uuid, orderByComparator, true);

			array[1] = encyWorkflow;

			array[2] = getByUuid_PrevAndNext(
				session, encyWorkflow, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EncyWorkflow getByUuid_PrevAndNext(
		Session session, EncyWorkflow encyWorkflow, String uuid,
		OrderByComparator<EncyWorkflow> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ENCYWORKFLOW_WHERE);

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
			sb.append(EncyWorkflowModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(encyWorkflow)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflow> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ency workflows where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EncyWorkflow encyWorkflow :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(encyWorkflow);
		}
	}

	/**
	 * Returns the number of ency workflows where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ency workflows
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ENCYWORKFLOW_WHERE);

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
		"encyWorkflow.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(encyWorkflow.uuid IS NULL OR encyWorkflow.uuid = '')";

	private FinderPath _finderPathFetchByClassName;
	private FinderPath _finderPathCountByClassName;

	/**
	 * Returns the ency workflow where className = &#63; or throws a <code>NoSuchEncyWorkflowException</code> if it could not be found.
	 *
	 * @param className the class name
	 * @return the matching ency workflow
	 * @throws NoSuchEncyWorkflowException if a matching ency workflow could not be found
	 */
	@Override
	public EncyWorkflow findByClassName(String className)
		throws NoSuchEncyWorkflowException {

		EncyWorkflow encyWorkflow = fetchByClassName(className);

		if (encyWorkflow == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("className=");
			sb.append(className);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEncyWorkflowException(sb.toString());
		}

		return encyWorkflow;
	}

	/**
	 * Returns the ency workflow where className = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param className the class name
	 * @return the matching ency workflow, or <code>null</code> if a matching ency workflow could not be found
	 */
	@Override
	public EncyWorkflow fetchByClassName(String className) {
		return fetchByClassName(className, true);
	}

	/**
	 * Returns the ency workflow where className = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param className the class name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow, or <code>null</code> if a matching ency workflow could not be found
	 */
	@Override
	public EncyWorkflow fetchByClassName(
		String className, boolean useFinderCache) {

		className = Objects.toString(className, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {className};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByClassName, finderArgs);
		}

		if (result instanceof EncyWorkflow) {
			EncyWorkflow encyWorkflow = (EncyWorkflow)result;

			if (!Objects.equals(className, encyWorkflow.getClassName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_ENCYWORKFLOW_WHERE);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindClassName) {
					queryPos.add(className);
				}

				List<EncyWorkflow> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByClassName, finderArgs, list);
					}
				}
				else {
					EncyWorkflow encyWorkflow = list.get(0);

					result = encyWorkflow;

					cacheResult(encyWorkflow);
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
			return (EncyWorkflow)result;
		}
	}

	/**
	 * Removes the ency workflow where className = &#63; from the database.
	 *
	 * @param className the class name
	 * @return the ency workflow that was removed
	 */
	@Override
	public EncyWorkflow removeByClassName(String className)
		throws NoSuchEncyWorkflowException {

		EncyWorkflow encyWorkflow = findByClassName(className);

		return remove(encyWorkflow);
	}

	/**
	 * Returns the number of ency workflows where className = &#63;.
	 *
	 * @param className the class name
	 * @return the number of matching ency workflows
	 */
	@Override
	public int countByClassName(String className) {
		className = Objects.toString(className, "");

		FinderPath finderPath = _finderPathCountByClassName;

		Object[] finderArgs = new Object[] {className};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ENCYWORKFLOW_WHERE);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindClassName) {
					queryPos.add(className);
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

	private static final String _FINDER_COLUMN_CLASSNAME_CLASSNAME_2 =
		"encyWorkflow.className = ?";

	private static final String _FINDER_COLUMN_CLASSNAME_CLASSNAME_3 =
		"(encyWorkflow.className IS NULL OR encyWorkflow.className = '')";

	private FinderPath _finderPathWithPaginationFindByActive;
	private FinderPath _finderPathWithoutPaginationFindByActive;
	private FinderPath _finderPathCountByActive;

	/**
	 * Returns all the ency workflows where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching ency workflows
	 */
	@Override
	public List<EncyWorkflow> findByActive(Boolean active) {
		return findByActive(active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflows where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @return the range of matching ency workflows
	 */
	@Override
	public List<EncyWorkflow> findByActive(Boolean active, int start, int end) {
		return findByActive(active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflows where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflows
	 */
	@Override
	public List<EncyWorkflow> findByActive(
		Boolean active, int start, int end,
		OrderByComparator<EncyWorkflow> orderByComparator) {

		return findByActive(active, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflows where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflows
	 */
	@Override
	public List<EncyWorkflow> findByActive(
		Boolean active, int start, int end,
		OrderByComparator<EncyWorkflow> orderByComparator,
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

		List<EncyWorkflow> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflow>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflow encyWorkflow : list) {
					if (!Objects.equals(active, encyWorkflow.getActive())) {
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

			sb.append(_SQL_SELECT_ENCYWORKFLOW_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EncyWorkflowModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(active.booleanValue());

				list = (List<EncyWorkflow>)QueryUtil.list(
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
	 * Returns the first ency workflow in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow
	 * @throws NoSuchEncyWorkflowException if a matching ency workflow could not be found
	 */
	@Override
	public EncyWorkflow findByActive_First(
			Boolean active, OrderByComparator<EncyWorkflow> orderByComparator)
		throws NoSuchEncyWorkflowException {

		EncyWorkflow encyWorkflow = fetchByActive_First(
			active, orderByComparator);

		if (encyWorkflow != null) {
			return encyWorkflow;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchEncyWorkflowException(sb.toString());
	}

	/**
	 * Returns the first ency workflow in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow, or <code>null</code> if a matching ency workflow could not be found
	 */
	@Override
	public EncyWorkflow fetchByActive_First(
		Boolean active, OrderByComparator<EncyWorkflow> orderByComparator) {

		List<EncyWorkflow> list = findByActive(active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow
	 * @throws NoSuchEncyWorkflowException if a matching ency workflow could not be found
	 */
	@Override
	public EncyWorkflow findByActive_Last(
			Boolean active, OrderByComparator<EncyWorkflow> orderByComparator)
		throws NoSuchEncyWorkflowException {

		EncyWorkflow encyWorkflow = fetchByActive_Last(
			active, orderByComparator);

		if (encyWorkflow != null) {
			return encyWorkflow;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchEncyWorkflowException(sb.toString());
	}

	/**
	 * Returns the last ency workflow in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow, or <code>null</code> if a matching ency workflow could not be found
	 */
	@Override
	public EncyWorkflow fetchByActive_Last(
		Boolean active, OrderByComparator<EncyWorkflow> orderByComparator) {

		int count = countByActive(active);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflow> list = findByActive(
			active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflows before and after the current ency workflow in the ordered set where active = &#63;.
	 *
	 * @param workflowId the primary key of the current ency workflow
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow
	 * @throws NoSuchEncyWorkflowException if a ency workflow with the primary key could not be found
	 */
	@Override
	public EncyWorkflow[] findByActive_PrevAndNext(
			long workflowId, Boolean active,
			OrderByComparator<EncyWorkflow> orderByComparator)
		throws NoSuchEncyWorkflowException {

		EncyWorkflow encyWorkflow = findByPrimaryKey(workflowId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflow[] array = new EncyWorkflowImpl[3];

			array[0] = getByActive_PrevAndNext(
				session, encyWorkflow, active, orderByComparator, true);

			array[1] = encyWorkflow;

			array[2] = getByActive_PrevAndNext(
				session, encyWorkflow, active, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EncyWorkflow getByActive_PrevAndNext(
		Session session, EncyWorkflow encyWorkflow, Boolean active,
		OrderByComparator<EncyWorkflow> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ENCYWORKFLOW_WHERE);

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
			sb.append(EncyWorkflowModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(active.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(encyWorkflow)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflow> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ency workflows where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	@Override
	public void removeByActive(Boolean active) {
		for (EncyWorkflow encyWorkflow :
				findByActive(
					active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(encyWorkflow);
		}
	}

	/**
	 * Returns the number of ency workflows where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching ency workflows
	 */
	@Override
	public int countByActive(Boolean active) {
		FinderPath finderPath = _finderPathCountByActive;

		Object[] finderArgs = new Object[] {active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ENCYWORKFLOW_WHERE);

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
		"encyWorkflow.active = ?";

	public EncyWorkflowPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EncyWorkflow.class);

		setModelImplClass(EncyWorkflowImpl.class);
		setModelPKClass(long.class);

		setTable(EncyWorkflowTable.INSTANCE);
	}

	/**
	 * Caches the ency workflow in the entity cache if it is enabled.
	 *
	 * @param encyWorkflow the ency workflow
	 */
	@Override
	public void cacheResult(EncyWorkflow encyWorkflow) {
		entityCache.putResult(
			EncyWorkflowImpl.class, encyWorkflow.getPrimaryKey(), encyWorkflow);

		finderCache.putResult(
			_finderPathFetchByClassName,
			new Object[] {encyWorkflow.getClassName()}, encyWorkflow);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the ency workflows in the entity cache if it is enabled.
	 *
	 * @param encyWorkflows the ency workflows
	 */
	@Override
	public void cacheResult(List<EncyWorkflow> encyWorkflows) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (encyWorkflows.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EncyWorkflow encyWorkflow : encyWorkflows) {
			if (entityCache.getResult(
					EncyWorkflowImpl.class, encyWorkflow.getPrimaryKey()) ==
						null) {

				cacheResult(encyWorkflow);
			}
		}
	}

	/**
	 * Clears the cache for all ency workflows.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EncyWorkflowImpl.class);

		finderCache.clearCache(EncyWorkflowImpl.class);
	}

	/**
	 * Clears the cache for the ency workflow.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EncyWorkflow encyWorkflow) {
		entityCache.removeResult(EncyWorkflowImpl.class, encyWorkflow);
	}

	@Override
	public void clearCache(List<EncyWorkflow> encyWorkflows) {
		for (EncyWorkflow encyWorkflow : encyWorkflows) {
			entityCache.removeResult(EncyWorkflowImpl.class, encyWorkflow);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EncyWorkflowImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EncyWorkflowImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EncyWorkflowModelImpl encyWorkflowModelImpl) {

		Object[] args = new Object[] {encyWorkflowModelImpl.getClassName()};

		finderCache.putResult(
			_finderPathCountByClassName, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByClassName, args, encyWorkflowModelImpl);
	}

	/**
	 * Creates a new ency workflow with the primary key. Does not add the ency workflow to the database.
	 *
	 * @param workflowId the primary key for the new ency workflow
	 * @return the new ency workflow
	 */
	@Override
	public EncyWorkflow create(long workflowId) {
		EncyWorkflow encyWorkflow = new EncyWorkflowImpl();

		encyWorkflow.setNew(true);
		encyWorkflow.setPrimaryKey(workflowId);

		String uuid = _portalUUID.generate();

		encyWorkflow.setUuid(uuid);

		return encyWorkflow;
	}

	/**
	 * Removes the ency workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workflowId the primary key of the ency workflow
	 * @return the ency workflow that was removed
	 * @throws NoSuchEncyWorkflowException if a ency workflow with the primary key could not be found
	 */
	@Override
	public EncyWorkflow remove(long workflowId)
		throws NoSuchEncyWorkflowException {

		return remove((Serializable)workflowId);
	}

	/**
	 * Removes the ency workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ency workflow
	 * @return the ency workflow that was removed
	 * @throws NoSuchEncyWorkflowException if a ency workflow with the primary key could not be found
	 */
	@Override
	public EncyWorkflow remove(Serializable primaryKey)
		throws NoSuchEncyWorkflowException {

		Session session = null;

		try {
			session = openSession();

			EncyWorkflow encyWorkflow = (EncyWorkflow)session.get(
				EncyWorkflowImpl.class, primaryKey);

			if (encyWorkflow == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEncyWorkflowException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(encyWorkflow);
		}
		catch (NoSuchEncyWorkflowException noSuchEntityException) {
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
	protected EncyWorkflow removeImpl(EncyWorkflow encyWorkflow) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(encyWorkflow)) {
				encyWorkflow = (EncyWorkflow)session.get(
					EncyWorkflowImpl.class, encyWorkflow.getPrimaryKeyObj());
			}

			if (encyWorkflow != null) {
				session.delete(encyWorkflow);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (encyWorkflow != null) {
			clearCache(encyWorkflow);
		}

		return encyWorkflow;
	}

	@Override
	public EncyWorkflow updateImpl(EncyWorkflow encyWorkflow) {
		boolean isNew = encyWorkflow.isNew();

		if (!(encyWorkflow instanceof EncyWorkflowModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(encyWorkflow.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					encyWorkflow);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in encyWorkflow proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EncyWorkflow implementation " +
					encyWorkflow.getClass());
		}

		EncyWorkflowModelImpl encyWorkflowModelImpl =
			(EncyWorkflowModelImpl)encyWorkflow;

		if (Validator.isNull(encyWorkflow.getUuid())) {
			String uuid = _portalUUID.generate();

			encyWorkflow.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (encyWorkflow.getCreateDate() == null)) {
			if (serviceContext == null) {
				encyWorkflow.setCreateDate(date);
			}
			else {
				encyWorkflow.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!encyWorkflowModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				encyWorkflow.setModifiedDate(date);
			}
			else {
				encyWorkflow.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(encyWorkflow);
			}
			else {
				encyWorkflow = (EncyWorkflow)session.merge(encyWorkflow);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EncyWorkflowImpl.class, encyWorkflowModelImpl, false, true);

		cacheUniqueFindersCache(encyWorkflowModelImpl);

		if (isNew) {
			encyWorkflow.setNew(false);
		}

		encyWorkflow.resetOriginalValues();

		return encyWorkflow;
	}

	/**
	 * Returns the ency workflow with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ency workflow
	 * @return the ency workflow
	 * @throws NoSuchEncyWorkflowException if a ency workflow with the primary key could not be found
	 */
	@Override
	public EncyWorkflow findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEncyWorkflowException {

		EncyWorkflow encyWorkflow = fetchByPrimaryKey(primaryKey);

		if (encyWorkflow == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEncyWorkflowException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return encyWorkflow;
	}

	/**
	 * Returns the ency workflow with the primary key or throws a <code>NoSuchEncyWorkflowException</code> if it could not be found.
	 *
	 * @param workflowId the primary key of the ency workflow
	 * @return the ency workflow
	 * @throws NoSuchEncyWorkflowException if a ency workflow with the primary key could not be found
	 */
	@Override
	public EncyWorkflow findByPrimaryKey(long workflowId)
		throws NoSuchEncyWorkflowException {

		return findByPrimaryKey((Serializable)workflowId);
	}

	/**
	 * Returns the ency workflow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workflowId the primary key of the ency workflow
	 * @return the ency workflow, or <code>null</code> if a ency workflow with the primary key could not be found
	 */
	@Override
	public EncyWorkflow fetchByPrimaryKey(long workflowId) {
		return fetchByPrimaryKey((Serializable)workflowId);
	}

	/**
	 * Returns all the ency workflows.
	 *
	 * @return the ency workflows
	 */
	@Override
	public List<EncyWorkflow> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @return the range of ency workflows
	 */
	@Override
	public List<EncyWorkflow> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ency workflows
	 */
	@Override
	public List<EncyWorkflow> findAll(
		int start, int end, OrderByComparator<EncyWorkflow> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflows
	 * @param end the upper bound of the range of ency workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ency workflows
	 */
	@Override
	public List<EncyWorkflow> findAll(
		int start, int end, OrderByComparator<EncyWorkflow> orderByComparator,
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

		List<EncyWorkflow> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflow>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ENCYWORKFLOW);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ENCYWORKFLOW;

				sql = sql.concat(EncyWorkflowModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EncyWorkflow>)QueryUtil.list(
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
	 * Removes all the ency workflows from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EncyWorkflow encyWorkflow : findAll()) {
			remove(encyWorkflow);
		}
	}

	/**
	 * Returns the number of ency workflows.
	 *
	 * @return the number of ency workflows
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ENCYWORKFLOW);

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
		return "workflowId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ENCYWORKFLOW;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EncyWorkflowModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ency workflow persistence.
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

		_finderPathFetchByClassName = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByClassName",
			new String[] {String.class.getName()}, new String[] {"className"},
			true);

		_finderPathCountByClassName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClassName",
			new String[] {String.class.getName()}, new String[] {"className"},
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

		_setEncyWorkflowUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setEncyWorkflowUtilPersistence(null);

		entityCache.removeCache(EncyWorkflowImpl.class.getName());
	}

	private void _setEncyWorkflowUtilPersistence(
		EncyWorkflowPersistence encyWorkflowPersistence) {

		try {
			Field field = EncyWorkflowUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, encyWorkflowPersistence);
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

	private static final String _SQL_SELECT_ENCYWORKFLOW =
		"SELECT encyWorkflow FROM EncyWorkflow encyWorkflow";

	private static final String _SQL_SELECT_ENCYWORKFLOW_WHERE =
		"SELECT encyWorkflow FROM EncyWorkflow encyWorkflow WHERE ";

	private static final String _SQL_COUNT_ENCYWORKFLOW =
		"SELECT COUNT(encyWorkflow) FROM EncyWorkflow encyWorkflow";

	private static final String _SQL_COUNT_ENCYWORKFLOW_WHERE =
		"SELECT COUNT(encyWorkflow) FROM EncyWorkflow encyWorkflow WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "encyWorkflow.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EncyWorkflow exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EncyWorkflow exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EncyWorkflowPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "active"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private EncyWorkflowModelArgumentsResolver
		_encyWorkflowModelArgumentsResolver;

}