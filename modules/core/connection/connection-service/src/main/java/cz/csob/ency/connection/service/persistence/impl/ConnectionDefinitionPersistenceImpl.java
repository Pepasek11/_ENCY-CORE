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

package cz.csob.ency.connection.service.persistence.impl;

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
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import cz.csob.ency.connection.exception.NoSuchConnectionDefinitionException;
import cz.csob.ency.connection.model.ConnectionDefinition;
import cz.csob.ency.connection.model.ConnectionDefinitionTable;
import cz.csob.ency.connection.model.impl.ConnectionDefinitionImpl;
import cz.csob.ency.connection.model.impl.ConnectionDefinitionModelImpl;
import cz.csob.ency.connection.service.persistence.ConnectionDefinitionPersistence;
import cz.csob.ency.connection.service.persistence.ConnectionDefinitionUtil;
import cz.csob.ency.connection.service.persistence.impl.constants.EncyConnectionPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the connection definition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {ConnectionDefinitionPersistence.class, BasePersistence.class}
)
public class ConnectionDefinitionPersistenceImpl
	extends BasePersistenceImpl<ConnectionDefinition>
	implements ConnectionDefinitionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ConnectionDefinitionUtil</code> to access the connection definition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ConnectionDefinitionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindById;
	private FinderPath _finderPathWithoutPaginationFindById;
	private FinderPath _finderPathCountById;

	/**
	 * Returns all the connection definitions where connectionId = &#63;.
	 *
	 * @param connectionId the connection ID
	 * @return the matching connection definitions
	 */
	@Override
	public List<ConnectionDefinition> findById(long connectionId) {
		return findById(
			connectionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the connection definitions where connectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectionDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param connectionId the connection ID
	 * @param start the lower bound of the range of connection definitions
	 * @param end the upper bound of the range of connection definitions (not inclusive)
	 * @return the range of matching connection definitions
	 */
	@Override
	public List<ConnectionDefinition> findById(
		long connectionId, int start, int end) {

		return findById(connectionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the connection definitions where connectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectionDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param connectionId the connection ID
	 * @param start the lower bound of the range of connection definitions
	 * @param end the upper bound of the range of connection definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching connection definitions
	 */
	@Override
	public List<ConnectionDefinition> findById(
		long connectionId, int start, int end,
		OrderByComparator<ConnectionDefinition> orderByComparator) {

		return findById(connectionId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the connection definitions where connectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectionDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param connectionId the connection ID
	 * @param start the lower bound of the range of connection definitions
	 * @param end the upper bound of the range of connection definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching connection definitions
	 */
	@Override
	public List<ConnectionDefinition> findById(
		long connectionId, int start, int end,
		OrderByComparator<ConnectionDefinition> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindById;
				finderArgs = new Object[] {connectionId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindById;
			finderArgs = new Object[] {
				connectionId, start, end, orderByComparator
			};
		}

		List<ConnectionDefinition> list = null;

		if (useFinderCache) {
			list = (List<ConnectionDefinition>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ConnectionDefinition connectionDefinition : list) {
					if (connectionId !=
							connectionDefinition.getConnectionId()) {

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

			sb.append(_SQL_SELECT_CONNECTIONDEFINITION_WHERE);

			sb.append(_FINDER_COLUMN_ID_CONNECTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ConnectionDefinitionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(connectionId);

				list = (List<ConnectionDefinition>)QueryUtil.list(
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
	 * Returns the first connection definition in the ordered set where connectionId = &#63;.
	 *
	 * @param connectionId the connection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connection definition
	 * @throws NoSuchConnectionDefinitionException if a matching connection definition could not be found
	 */
	@Override
	public ConnectionDefinition findById_First(
			long connectionId,
			OrderByComparator<ConnectionDefinition> orderByComparator)
		throws NoSuchConnectionDefinitionException {

		ConnectionDefinition connectionDefinition = fetchById_First(
			connectionId, orderByComparator);

		if (connectionDefinition != null) {
			return connectionDefinition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("connectionId=");
		sb.append(connectionId);

		sb.append("}");

		throw new NoSuchConnectionDefinitionException(sb.toString());
	}

	/**
	 * Returns the first connection definition in the ordered set where connectionId = &#63;.
	 *
	 * @param connectionId the connection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connection definition, or <code>null</code> if a matching connection definition could not be found
	 */
	@Override
	public ConnectionDefinition fetchById_First(
		long connectionId,
		OrderByComparator<ConnectionDefinition> orderByComparator) {

		List<ConnectionDefinition> list = findById(
			connectionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last connection definition in the ordered set where connectionId = &#63;.
	 *
	 * @param connectionId the connection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connection definition
	 * @throws NoSuchConnectionDefinitionException if a matching connection definition could not be found
	 */
	@Override
	public ConnectionDefinition findById_Last(
			long connectionId,
			OrderByComparator<ConnectionDefinition> orderByComparator)
		throws NoSuchConnectionDefinitionException {

		ConnectionDefinition connectionDefinition = fetchById_Last(
			connectionId, orderByComparator);

		if (connectionDefinition != null) {
			return connectionDefinition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("connectionId=");
		sb.append(connectionId);

		sb.append("}");

		throw new NoSuchConnectionDefinitionException(sb.toString());
	}

	/**
	 * Returns the last connection definition in the ordered set where connectionId = &#63;.
	 *
	 * @param connectionId the connection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connection definition, or <code>null</code> if a matching connection definition could not be found
	 */
	@Override
	public ConnectionDefinition fetchById_Last(
		long connectionId,
		OrderByComparator<ConnectionDefinition> orderByComparator) {

		int count = countById(connectionId);

		if (count == 0) {
			return null;
		}

		List<ConnectionDefinition> list = findById(
			connectionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the connection definitions where connectionId = &#63; from the database.
	 *
	 * @param connectionId the connection ID
	 */
	@Override
	public void removeById(long connectionId) {
		for (ConnectionDefinition connectionDefinition :
				findById(
					connectionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(connectionDefinition);
		}
	}

	/**
	 * Returns the number of connection definitions where connectionId = &#63;.
	 *
	 * @param connectionId the connection ID
	 * @return the number of matching connection definitions
	 */
	@Override
	public int countById(long connectionId) {
		FinderPath finderPath = _finderPathCountById;

		Object[] finderArgs = new Object[] {connectionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CONNECTIONDEFINITION_WHERE);

			sb.append(_FINDER_COLUMN_ID_CONNECTIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(connectionId);

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

	private static final String _FINDER_COLUMN_ID_CONNECTIONID_2 =
		"connectionDefinition.connectionId = ?";

	private FinderPath _finderPathWithPaginationFindByName;
	private FinderPath _finderPathWithoutPaginationFindByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns all the connection definitions where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching connection definitions
	 */
	@Override
	public List<ConnectionDefinition> findByName(String name) {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the connection definitions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectionDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of connection definitions
	 * @param end the upper bound of the range of connection definitions (not inclusive)
	 * @return the range of matching connection definitions
	 */
	@Override
	public List<ConnectionDefinition> findByName(
		String name, int start, int end) {

		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the connection definitions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectionDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of connection definitions
	 * @param end the upper bound of the range of connection definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching connection definitions
	 */
	@Override
	public List<ConnectionDefinition> findByName(
		String name, int start, int end,
		OrderByComparator<ConnectionDefinition> orderByComparator) {

		return findByName(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the connection definitions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectionDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of connection definitions
	 * @param end the upper bound of the range of connection definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching connection definitions
	 */
	@Override
	public List<ConnectionDefinition> findByName(
		String name, int start, int end,
		OrderByComparator<ConnectionDefinition> orderByComparator,
		boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByName;
				finderArgs = new Object[] {name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByName;
			finderArgs = new Object[] {name, start, end, orderByComparator};
		}

		List<ConnectionDefinition> list = null;

		if (useFinderCache) {
			list = (List<ConnectionDefinition>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ConnectionDefinition connectionDefinition : list) {
					if (!name.equals(connectionDefinition.getName())) {
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

			sb.append(_SQL_SELECT_CONNECTIONDEFINITION_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ConnectionDefinitionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<ConnectionDefinition>)QueryUtil.list(
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
	 * Returns the first connection definition in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connection definition
	 * @throws NoSuchConnectionDefinitionException if a matching connection definition could not be found
	 */
	@Override
	public ConnectionDefinition findByName_First(
			String name,
			OrderByComparator<ConnectionDefinition> orderByComparator)
		throws NoSuchConnectionDefinitionException {

		ConnectionDefinition connectionDefinition = fetchByName_First(
			name, orderByComparator);

		if (connectionDefinition != null) {
			return connectionDefinition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchConnectionDefinitionException(sb.toString());
	}

	/**
	 * Returns the first connection definition in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connection definition, or <code>null</code> if a matching connection definition could not be found
	 */
	@Override
	public ConnectionDefinition fetchByName_First(
		String name,
		OrderByComparator<ConnectionDefinition> orderByComparator) {

		List<ConnectionDefinition> list = findByName(
			name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last connection definition in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connection definition
	 * @throws NoSuchConnectionDefinitionException if a matching connection definition could not be found
	 */
	@Override
	public ConnectionDefinition findByName_Last(
			String name,
			OrderByComparator<ConnectionDefinition> orderByComparator)
		throws NoSuchConnectionDefinitionException {

		ConnectionDefinition connectionDefinition = fetchByName_Last(
			name, orderByComparator);

		if (connectionDefinition != null) {
			return connectionDefinition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchConnectionDefinitionException(sb.toString());
	}

	/**
	 * Returns the last connection definition in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connection definition, or <code>null</code> if a matching connection definition could not be found
	 */
	@Override
	public ConnectionDefinition fetchByName_Last(
		String name,
		OrderByComparator<ConnectionDefinition> orderByComparator) {

		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<ConnectionDefinition> list = findByName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the connection definitions before and after the current connection definition in the ordered set where name = &#63;.
	 *
	 * @param connectionId the primary key of the current connection definition
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next connection definition
	 * @throws NoSuchConnectionDefinitionException if a connection definition with the primary key could not be found
	 */
	@Override
	public ConnectionDefinition[] findByName_PrevAndNext(
			long connectionId, String name,
			OrderByComparator<ConnectionDefinition> orderByComparator)
		throws NoSuchConnectionDefinitionException {

		name = Objects.toString(name, "");

		ConnectionDefinition connectionDefinition = findByPrimaryKey(
			connectionId);

		Session session = null;

		try {
			session = openSession();

			ConnectionDefinition[] array = new ConnectionDefinitionImpl[3];

			array[0] = getByName_PrevAndNext(
				session, connectionDefinition, name, orderByComparator, true);

			array[1] = connectionDefinition;

			array[2] = getByName_PrevAndNext(
				session, connectionDefinition, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ConnectionDefinition getByName_PrevAndNext(
		Session session, ConnectionDefinition connectionDefinition, String name,
		OrderByComparator<ConnectionDefinition> orderByComparator,
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

		sb.append(_SQL_SELECT_CONNECTIONDEFINITION_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_NAME_2);
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
			sb.append(ConnectionDefinitionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						connectionDefinition)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ConnectionDefinition> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the connection definitions where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByName(String name) {
		for (ConnectionDefinition connectionDefinition :
				findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(connectionDefinition);
		}
	}

	/**
	 * Returns the number of connection definitions where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching connection definitions
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CONNECTIONDEFINITION_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_NAME_NAME_2 =
		"connectionDefinition.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(connectionDefinition.name IS NULL OR connectionDefinition.name = '')";

	public ConnectionDefinitionPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("password", "password_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ConnectionDefinition.class);

		setModelImplClass(ConnectionDefinitionImpl.class);
		setModelPKClass(long.class);

		setTable(ConnectionDefinitionTable.INSTANCE);
	}

	/**
	 * Caches the connection definition in the entity cache if it is enabled.
	 *
	 * @param connectionDefinition the connection definition
	 */
	@Override
	public void cacheResult(ConnectionDefinition connectionDefinition) {
		entityCache.putResult(
			ConnectionDefinitionImpl.class,
			connectionDefinition.getPrimaryKey(), connectionDefinition);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the connection definitions in the entity cache if it is enabled.
	 *
	 * @param connectionDefinitions the connection definitions
	 */
	@Override
	public void cacheResult(List<ConnectionDefinition> connectionDefinitions) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (connectionDefinitions.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ConnectionDefinition connectionDefinition :
				connectionDefinitions) {

			if (entityCache.getResult(
					ConnectionDefinitionImpl.class,
					connectionDefinition.getPrimaryKey()) == null) {

				cacheResult(connectionDefinition);
			}
		}
	}

	/**
	 * Clears the cache for all connection definitions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ConnectionDefinitionImpl.class);

		finderCache.clearCache(ConnectionDefinitionImpl.class);
	}

	/**
	 * Clears the cache for the connection definition.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ConnectionDefinition connectionDefinition) {
		entityCache.removeResult(
			ConnectionDefinitionImpl.class, connectionDefinition);
	}

	@Override
	public void clearCache(List<ConnectionDefinition> connectionDefinitions) {
		for (ConnectionDefinition connectionDefinition :
				connectionDefinitions) {

			entityCache.removeResult(
				ConnectionDefinitionImpl.class, connectionDefinition);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ConnectionDefinitionImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ConnectionDefinitionImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new connection definition with the primary key. Does not add the connection definition to the database.
	 *
	 * @param connectionId the primary key for the new connection definition
	 * @return the new connection definition
	 */
	@Override
	public ConnectionDefinition create(long connectionId) {
		ConnectionDefinition connectionDefinition =
			new ConnectionDefinitionImpl();

		connectionDefinition.setNew(true);
		connectionDefinition.setPrimaryKey(connectionId);

		return connectionDefinition;
	}

	/**
	 * Removes the connection definition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param connectionId the primary key of the connection definition
	 * @return the connection definition that was removed
	 * @throws NoSuchConnectionDefinitionException if a connection definition with the primary key could not be found
	 */
	@Override
	public ConnectionDefinition remove(long connectionId)
		throws NoSuchConnectionDefinitionException {

		return remove((Serializable)connectionId);
	}

	/**
	 * Removes the connection definition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the connection definition
	 * @return the connection definition that was removed
	 * @throws NoSuchConnectionDefinitionException if a connection definition with the primary key could not be found
	 */
	@Override
	public ConnectionDefinition remove(Serializable primaryKey)
		throws NoSuchConnectionDefinitionException {

		Session session = null;

		try {
			session = openSession();

			ConnectionDefinition connectionDefinition =
				(ConnectionDefinition)session.get(
					ConnectionDefinitionImpl.class, primaryKey);

			if (connectionDefinition == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConnectionDefinitionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(connectionDefinition);
		}
		catch (NoSuchConnectionDefinitionException noSuchEntityException) {
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
	protected ConnectionDefinition removeImpl(
		ConnectionDefinition connectionDefinition) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(connectionDefinition)) {
				connectionDefinition = (ConnectionDefinition)session.get(
					ConnectionDefinitionImpl.class,
					connectionDefinition.getPrimaryKeyObj());
			}

			if (connectionDefinition != null) {
				session.delete(connectionDefinition);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (connectionDefinition != null) {
			clearCache(connectionDefinition);
		}

		return connectionDefinition;
	}

	@Override
	public ConnectionDefinition updateImpl(
		ConnectionDefinition connectionDefinition) {

		boolean isNew = connectionDefinition.isNew();

		if (!(connectionDefinition instanceof ConnectionDefinitionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(connectionDefinition.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					connectionDefinition);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in connectionDefinition proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ConnectionDefinition implementation " +
					connectionDefinition.getClass());
		}

		ConnectionDefinitionModelImpl connectionDefinitionModelImpl =
			(ConnectionDefinitionModelImpl)connectionDefinition;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(connectionDefinition);
			}
			else {
				connectionDefinition = (ConnectionDefinition)session.merge(
					connectionDefinition);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ConnectionDefinitionImpl.class, connectionDefinitionModelImpl,
			false, true);

		if (isNew) {
			connectionDefinition.setNew(false);
		}

		connectionDefinition.resetOriginalValues();

		return connectionDefinition;
	}

	/**
	 * Returns the connection definition with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the connection definition
	 * @return the connection definition
	 * @throws NoSuchConnectionDefinitionException if a connection definition with the primary key could not be found
	 */
	@Override
	public ConnectionDefinition findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConnectionDefinitionException {

		ConnectionDefinition connectionDefinition = fetchByPrimaryKey(
			primaryKey);

		if (connectionDefinition == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConnectionDefinitionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return connectionDefinition;
	}

	/**
	 * Returns the connection definition with the primary key or throws a <code>NoSuchConnectionDefinitionException</code> if it could not be found.
	 *
	 * @param connectionId the primary key of the connection definition
	 * @return the connection definition
	 * @throws NoSuchConnectionDefinitionException if a connection definition with the primary key could not be found
	 */
	@Override
	public ConnectionDefinition findByPrimaryKey(long connectionId)
		throws NoSuchConnectionDefinitionException {

		return findByPrimaryKey((Serializable)connectionId);
	}

	/**
	 * Returns the connection definition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param connectionId the primary key of the connection definition
	 * @return the connection definition, or <code>null</code> if a connection definition with the primary key could not be found
	 */
	@Override
	public ConnectionDefinition fetchByPrimaryKey(long connectionId) {
		return fetchByPrimaryKey((Serializable)connectionId);
	}

	/**
	 * Returns all the connection definitions.
	 *
	 * @return the connection definitions
	 */
	@Override
	public List<ConnectionDefinition> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the connection definitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectionDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of connection definitions
	 * @param end the upper bound of the range of connection definitions (not inclusive)
	 * @return the range of connection definitions
	 */
	@Override
	public List<ConnectionDefinition> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the connection definitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectionDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of connection definitions
	 * @param end the upper bound of the range of connection definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of connection definitions
	 */
	@Override
	public List<ConnectionDefinition> findAll(
		int start, int end,
		OrderByComparator<ConnectionDefinition> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the connection definitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectionDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of connection definitions
	 * @param end the upper bound of the range of connection definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of connection definitions
	 */
	@Override
	public List<ConnectionDefinition> findAll(
		int start, int end,
		OrderByComparator<ConnectionDefinition> orderByComparator,
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

		List<ConnectionDefinition> list = null;

		if (useFinderCache) {
			list = (List<ConnectionDefinition>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CONNECTIONDEFINITION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CONNECTIONDEFINITION;

				sql = sql.concat(ConnectionDefinitionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ConnectionDefinition>)QueryUtil.list(
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
	 * Removes all the connection definitions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ConnectionDefinition connectionDefinition : findAll()) {
			remove(connectionDefinition);
		}
	}

	/**
	 * Returns the number of connection definitions.
	 *
	 * @return the number of connection definitions
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
					_SQL_COUNT_CONNECTIONDEFINITION);

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
		return "connectionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CONNECTIONDEFINITION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ConnectionDefinitionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the connection definition persistence.
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

		_finderPathWithPaginationFindById = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findById",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"connectionId"}, true);

		_finderPathWithoutPaginationFindById = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findById",
			new String[] {Long.class.getName()}, new String[] {"connectionId"},
			true);

		_finderPathCountById = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countById",
			new String[] {Long.class.getName()}, new String[] {"connectionId"},
			false);

		_finderPathWithPaginationFindByName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"name"}, true);

		_finderPathWithoutPaginationFindByName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountByName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);

		_setConnectionDefinitionUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setConnectionDefinitionUtilPersistence(null);

		entityCache.removeCache(ConnectionDefinitionImpl.class.getName());
	}

	private void _setConnectionDefinitionUtilPersistence(
		ConnectionDefinitionPersistence connectionDefinitionPersistence) {

		try {
			Field field = ConnectionDefinitionUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, connectionDefinitionPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = EncyConnectionPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = EncyConnectionPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = EncyConnectionPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CONNECTIONDEFINITION =
		"SELECT connectionDefinition FROM ConnectionDefinition connectionDefinition";

	private static final String _SQL_SELECT_CONNECTIONDEFINITION_WHERE =
		"SELECT connectionDefinition FROM ConnectionDefinition connectionDefinition WHERE ";

	private static final String _SQL_COUNT_CONNECTIONDEFINITION =
		"SELECT COUNT(connectionDefinition) FROM ConnectionDefinition connectionDefinition";

	private static final String _SQL_COUNT_CONNECTIONDEFINITION_WHERE =
		"SELECT COUNT(connectionDefinition) FROM ConnectionDefinition connectionDefinition WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"connectionDefinition.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ConnectionDefinition exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ConnectionDefinition exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ConnectionDefinitionPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"password"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ConnectionDefinitionModelArgumentsResolver
		_connectionDefinitionModelArgumentsResolver;

}