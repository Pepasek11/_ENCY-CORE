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

package cz.csob.ency.delegations.service.persistence.impl;

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

import cz.csob.ency.delegations.exception.NoSuchDelegatedRoleException;
import cz.csob.ency.delegations.model.DelegatedRole;
import cz.csob.ency.delegations.model.DelegatedRoleTable;
import cz.csob.ency.delegations.model.impl.DelegatedRoleImpl;
import cz.csob.ency.delegations.model.impl.DelegatedRoleModelImpl;
import cz.csob.ency.delegations.service.persistence.DelegatedRolePersistence;
import cz.csob.ency.delegations.service.persistence.DelegatedRoleUtil;
import cz.csob.ency.delegations.service.persistence.impl.constants.DelegationsPersistenceConstants;

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
 * The persistence implementation for the delegated role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @generated
 */
@Component(service = {DelegatedRolePersistence.class, BasePersistence.class})
public class DelegatedRolePersistenceImpl
	extends BasePersistenceImpl<DelegatedRole>
	implements DelegatedRolePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DelegatedRoleUtil</code> to access the delegated role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DelegatedRoleImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchById;
	private FinderPath _finderPathCountById;

	/**
	 * Returns the delegated role where roleId = &#63; or throws a <code>NoSuchDelegatedRoleException</code> if it could not be found.
	 *
	 * @param roleId the role ID
	 * @return the matching delegated role
	 * @throws NoSuchDelegatedRoleException if a matching delegated role could not be found
	 */
	@Override
	public DelegatedRole findById(long roleId)
		throws NoSuchDelegatedRoleException {

		DelegatedRole delegatedRole = fetchById(roleId);

		if (delegatedRole == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("roleId=");
			sb.append(roleId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDelegatedRoleException(sb.toString());
		}

		return delegatedRole;
	}

	/**
	 * Returns the delegated role where roleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param roleId the role ID
	 * @return the matching delegated role, or <code>null</code> if a matching delegated role could not be found
	 */
	@Override
	public DelegatedRole fetchById(long roleId) {
		return fetchById(roleId, true);
	}

	/**
	 * Returns the delegated role where roleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param roleId the role ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching delegated role, or <code>null</code> if a matching delegated role could not be found
	 */
	@Override
	public DelegatedRole fetchById(long roleId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {roleId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchById, finderArgs);
		}

		if (result instanceof DelegatedRole) {
			DelegatedRole delegatedRole = (DelegatedRole)result;

			if (roleId != delegatedRole.getRoleId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DELEGATEDROLE_WHERE);

			sb.append(_FINDER_COLUMN_ID_ROLEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(roleId);

				List<DelegatedRole> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchById, finderArgs, list);
					}
				}
				else {
					DelegatedRole delegatedRole = list.get(0);

					result = delegatedRole;

					cacheResult(delegatedRole);
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
			return (DelegatedRole)result;
		}
	}

	/**
	 * Removes the delegated role where roleId = &#63; from the database.
	 *
	 * @param roleId the role ID
	 * @return the delegated role that was removed
	 */
	@Override
	public DelegatedRole removeById(long roleId)
		throws NoSuchDelegatedRoleException {

		DelegatedRole delegatedRole = findById(roleId);

		return remove(delegatedRole);
	}

	/**
	 * Returns the number of delegated roles where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the number of matching delegated roles
	 */
	@Override
	public int countById(long roleId) {
		FinderPath finderPath = _finderPathCountById;

		Object[] finderArgs = new Object[] {roleId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DELEGATEDROLE_WHERE);

			sb.append(_FINDER_COLUMN_ID_ROLEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(roleId);

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

	private static final String _FINDER_COLUMN_ID_ROLEID_2 =
		"delegatedRole.roleId = ?";

	private FinderPath _finderPathFetchByCode;
	private FinderPath _finderPathCountByCode;

	/**
	 * Returns the delegated role where code = &#63; or throws a <code>NoSuchDelegatedRoleException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching delegated role
	 * @throws NoSuchDelegatedRoleException if a matching delegated role could not be found
	 */
	@Override
	public DelegatedRole findByCode(String code)
		throws NoSuchDelegatedRoleException {

		DelegatedRole delegatedRole = fetchByCode(code);

		if (delegatedRole == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("code=");
			sb.append(code);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDelegatedRoleException(sb.toString());
		}

		return delegatedRole;
	}

	/**
	 * Returns the delegated role where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching delegated role, or <code>null</code> if a matching delegated role could not be found
	 */
	@Override
	public DelegatedRole fetchByCode(String code) {
		return fetchByCode(code, true);
	}

	/**
	 * Returns the delegated role where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching delegated role, or <code>null</code> if a matching delegated role could not be found
	 */
	@Override
	public DelegatedRole fetchByCode(String code, boolean useFinderCache) {
		code = Objects.toString(code, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {code};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByCode, finderArgs);
		}

		if (result instanceof DelegatedRole) {
			DelegatedRole delegatedRole = (DelegatedRole)result;

			if (!Objects.equals(code, delegatedRole.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DELEGATEDROLE_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(code);
				}

				List<DelegatedRole> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCode, finderArgs, list);
					}
				}
				else {
					DelegatedRole delegatedRole = list.get(0);

					result = delegatedRole;

					cacheResult(delegatedRole);
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
			return (DelegatedRole)result;
		}
	}

	/**
	 * Removes the delegated role where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the delegated role that was removed
	 */
	@Override
	public DelegatedRole removeByCode(String code)
		throws NoSuchDelegatedRoleException {

		DelegatedRole delegatedRole = findByCode(code);

		return remove(delegatedRole);
	}

	/**
	 * Returns the number of delegated roles where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching delegated roles
	 */
	@Override
	public int countByCode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountByCode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DELEGATEDROLE_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(code);
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

	private static final String _FINDER_COLUMN_CODE_CODE_2 =
		"delegatedRole.code = ?";

	private static final String _FINDER_COLUMN_CODE_CODE_3 =
		"(delegatedRole.code IS NULL OR delegatedRole.code = '')";

	private FinderPath _finderPathWithPaginationFindByG;
	private FinderPath _finderPathWithoutPaginationFindByG;
	private FinderPath _finderPathCountByG;

	/**
	 * Returns all the delegated roles where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching delegated roles
	 */
	@Override
	public List<DelegatedRole> findByG(long groupId) {
		return findByG(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the delegated roles where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegatedRoleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of delegated roles
	 * @param end the upper bound of the range of delegated roles (not inclusive)
	 * @return the range of matching delegated roles
	 */
	@Override
	public List<DelegatedRole> findByG(long groupId, int start, int end) {
		return findByG(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the delegated roles where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegatedRoleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of delegated roles
	 * @param end the upper bound of the range of delegated roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching delegated roles
	 */
	@Override
	public List<DelegatedRole> findByG(
		long groupId, int start, int end,
		OrderByComparator<DelegatedRole> orderByComparator) {

		return findByG(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the delegated roles where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegatedRoleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of delegated roles
	 * @param end the upper bound of the range of delegated roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching delegated roles
	 */
	@Override
	public List<DelegatedRole> findByG(
		long groupId, int start, int end,
		OrderByComparator<DelegatedRole> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<DelegatedRole> list = null;

		if (useFinderCache) {
			list = (List<DelegatedRole>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DelegatedRole delegatedRole : list) {
					if (groupId != delegatedRole.getGroupId()) {
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

			sb.append(_SQL_SELECT_DELEGATEDROLE_WHERE);

			sb.append(_FINDER_COLUMN_G_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DelegatedRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<DelegatedRole>)QueryUtil.list(
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
	 * Returns the first delegated role in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegated role
	 * @throws NoSuchDelegatedRoleException if a matching delegated role could not be found
	 */
	@Override
	public DelegatedRole findByG_First(
			long groupId, OrderByComparator<DelegatedRole> orderByComparator)
		throws NoSuchDelegatedRoleException {

		DelegatedRole delegatedRole = fetchByG_First(
			groupId, orderByComparator);

		if (delegatedRole != null) {
			return delegatedRole;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDelegatedRoleException(sb.toString());
	}

	/**
	 * Returns the first delegated role in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegated role, or <code>null</code> if a matching delegated role could not be found
	 */
	@Override
	public DelegatedRole fetchByG_First(
		long groupId, OrderByComparator<DelegatedRole> orderByComparator) {

		List<DelegatedRole> list = findByG(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last delegated role in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegated role
	 * @throws NoSuchDelegatedRoleException if a matching delegated role could not be found
	 */
	@Override
	public DelegatedRole findByG_Last(
			long groupId, OrderByComparator<DelegatedRole> orderByComparator)
		throws NoSuchDelegatedRoleException {

		DelegatedRole delegatedRole = fetchByG_Last(groupId, orderByComparator);

		if (delegatedRole != null) {
			return delegatedRole;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDelegatedRoleException(sb.toString());
	}

	/**
	 * Returns the last delegated role in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegated role, or <code>null</code> if a matching delegated role could not be found
	 */
	@Override
	public DelegatedRole fetchByG_Last(
		long groupId, OrderByComparator<DelegatedRole> orderByComparator) {

		int count = countByG(groupId);

		if (count == 0) {
			return null;
		}

		List<DelegatedRole> list = findByG(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the delegated roles before and after the current delegated role in the ordered set where groupId = &#63;.
	 *
	 * @param roleId the primary key of the current delegated role
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next delegated role
	 * @throws NoSuchDelegatedRoleException if a delegated role with the primary key could not be found
	 */
	@Override
	public DelegatedRole[] findByG_PrevAndNext(
			long roleId, long groupId,
			OrderByComparator<DelegatedRole> orderByComparator)
		throws NoSuchDelegatedRoleException {

		DelegatedRole delegatedRole = findByPrimaryKey(roleId);

		Session session = null;

		try {
			session = openSession();

			DelegatedRole[] array = new DelegatedRoleImpl[3];

			array[0] = getByG_PrevAndNext(
				session, delegatedRole, groupId, orderByComparator, true);

			array[1] = delegatedRole;

			array[2] = getByG_PrevAndNext(
				session, delegatedRole, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DelegatedRole getByG_PrevAndNext(
		Session session, DelegatedRole delegatedRole, long groupId,
		OrderByComparator<DelegatedRole> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DELEGATEDROLE_WHERE);

		sb.append(_FINDER_COLUMN_G_GROUPID_2);

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
			sb.append(DelegatedRoleModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						delegatedRole)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DelegatedRole> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the delegated roles where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByG(long groupId) {
		for (DelegatedRole delegatedRole :
				findByG(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(delegatedRole);
		}
	}

	/**
	 * Returns the number of delegated roles where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching delegated roles
	 */
	@Override
	public int countByG(long groupId) {
		FinderPath finderPath = _finderPathCountByG;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DELEGATEDROLE_WHERE);

			sb.append(_FINDER_COLUMN_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_G_GROUPID_2 =
		"delegatedRole.groupId = ?";

	public DelegatedRolePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DelegatedRole.class);

		setModelImplClass(DelegatedRoleImpl.class);
		setModelPKClass(long.class);

		setTable(DelegatedRoleTable.INSTANCE);
	}

	/**
	 * Caches the delegated role in the entity cache if it is enabled.
	 *
	 * @param delegatedRole the delegated role
	 */
	@Override
	public void cacheResult(DelegatedRole delegatedRole) {
		entityCache.putResult(
			DelegatedRoleImpl.class, delegatedRole.getPrimaryKey(),
			delegatedRole);

		finderCache.putResult(
			_finderPathFetchById, new Object[] {delegatedRole.getRoleId()},
			delegatedRole);

		finderCache.putResult(
			_finderPathFetchByCode, new Object[] {delegatedRole.getCode()},
			delegatedRole);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the delegated roles in the entity cache if it is enabled.
	 *
	 * @param delegatedRoles the delegated roles
	 */
	@Override
	public void cacheResult(List<DelegatedRole> delegatedRoles) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (delegatedRoles.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DelegatedRole delegatedRole : delegatedRoles) {
			if (entityCache.getResult(
					DelegatedRoleImpl.class, delegatedRole.getPrimaryKey()) ==
						null) {

				cacheResult(delegatedRole);
			}
		}
	}

	/**
	 * Clears the cache for all delegated roles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DelegatedRoleImpl.class);

		finderCache.clearCache(DelegatedRoleImpl.class);
	}

	/**
	 * Clears the cache for the delegated role.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DelegatedRole delegatedRole) {
		entityCache.removeResult(DelegatedRoleImpl.class, delegatedRole);
	}

	@Override
	public void clearCache(List<DelegatedRole> delegatedRoles) {
		for (DelegatedRole delegatedRole : delegatedRoles) {
			entityCache.removeResult(DelegatedRoleImpl.class, delegatedRole);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DelegatedRoleImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DelegatedRoleImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DelegatedRoleModelImpl delegatedRoleModelImpl) {

		Object[] args = new Object[] {delegatedRoleModelImpl.getRoleId()};

		finderCache.putResult(_finderPathCountById, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchById, args, delegatedRoleModelImpl);

		args = new Object[] {delegatedRoleModelImpl.getCode()};

		finderCache.putResult(_finderPathCountByCode, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByCode, args, delegatedRoleModelImpl);
	}

	/**
	 * Creates a new delegated role with the primary key. Does not add the delegated role to the database.
	 *
	 * @param roleId the primary key for the new delegated role
	 * @return the new delegated role
	 */
	@Override
	public DelegatedRole create(long roleId) {
		DelegatedRole delegatedRole = new DelegatedRoleImpl();

		delegatedRole.setNew(true);
		delegatedRole.setPrimaryKey(roleId);

		delegatedRole.setCompanyId(CompanyThreadLocal.getCompanyId());

		return delegatedRole;
	}

	/**
	 * Removes the delegated role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roleId the primary key of the delegated role
	 * @return the delegated role that was removed
	 * @throws NoSuchDelegatedRoleException if a delegated role with the primary key could not be found
	 */
	@Override
	public DelegatedRole remove(long roleId)
		throws NoSuchDelegatedRoleException {

		return remove((Serializable)roleId);
	}

	/**
	 * Removes the delegated role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the delegated role
	 * @return the delegated role that was removed
	 * @throws NoSuchDelegatedRoleException if a delegated role with the primary key could not be found
	 */
	@Override
	public DelegatedRole remove(Serializable primaryKey)
		throws NoSuchDelegatedRoleException {

		Session session = null;

		try {
			session = openSession();

			DelegatedRole delegatedRole = (DelegatedRole)session.get(
				DelegatedRoleImpl.class, primaryKey);

			if (delegatedRole == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDelegatedRoleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(delegatedRole);
		}
		catch (NoSuchDelegatedRoleException noSuchEntityException) {
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
	protected DelegatedRole removeImpl(DelegatedRole delegatedRole) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(delegatedRole)) {
				delegatedRole = (DelegatedRole)session.get(
					DelegatedRoleImpl.class, delegatedRole.getPrimaryKeyObj());
			}

			if (delegatedRole != null) {
				session.delete(delegatedRole);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (delegatedRole != null) {
			clearCache(delegatedRole);
		}

		return delegatedRole;
	}

	@Override
	public DelegatedRole updateImpl(DelegatedRole delegatedRole) {
		boolean isNew = delegatedRole.isNew();

		if (!(delegatedRole instanceof DelegatedRoleModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(delegatedRole.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					delegatedRole);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in delegatedRole proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DelegatedRole implementation " +
					delegatedRole.getClass());
		}

		DelegatedRoleModelImpl delegatedRoleModelImpl =
			(DelegatedRoleModelImpl)delegatedRole;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (delegatedRole.getCreateDate() == null)) {
			if (serviceContext == null) {
				delegatedRole.setCreateDate(date);
			}
			else {
				delegatedRole.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!delegatedRoleModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				delegatedRole.setModifiedDate(date);
			}
			else {
				delegatedRole.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(delegatedRole);
			}
			else {
				delegatedRole = (DelegatedRole)session.merge(delegatedRole);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DelegatedRoleImpl.class, delegatedRoleModelImpl, false, true);

		cacheUniqueFindersCache(delegatedRoleModelImpl);

		if (isNew) {
			delegatedRole.setNew(false);
		}

		delegatedRole.resetOriginalValues();

		return delegatedRole;
	}

	/**
	 * Returns the delegated role with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the delegated role
	 * @return the delegated role
	 * @throws NoSuchDelegatedRoleException if a delegated role with the primary key could not be found
	 */
	@Override
	public DelegatedRole findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDelegatedRoleException {

		DelegatedRole delegatedRole = fetchByPrimaryKey(primaryKey);

		if (delegatedRole == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDelegatedRoleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return delegatedRole;
	}

	/**
	 * Returns the delegated role with the primary key or throws a <code>NoSuchDelegatedRoleException</code> if it could not be found.
	 *
	 * @param roleId the primary key of the delegated role
	 * @return the delegated role
	 * @throws NoSuchDelegatedRoleException if a delegated role with the primary key could not be found
	 */
	@Override
	public DelegatedRole findByPrimaryKey(long roleId)
		throws NoSuchDelegatedRoleException {

		return findByPrimaryKey((Serializable)roleId);
	}

	/**
	 * Returns the delegated role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roleId the primary key of the delegated role
	 * @return the delegated role, or <code>null</code> if a delegated role with the primary key could not be found
	 */
	@Override
	public DelegatedRole fetchByPrimaryKey(long roleId) {
		return fetchByPrimaryKey((Serializable)roleId);
	}

	/**
	 * Returns all the delegated roles.
	 *
	 * @return the delegated roles
	 */
	@Override
	public List<DelegatedRole> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the delegated roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegatedRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of delegated roles
	 * @param end the upper bound of the range of delegated roles (not inclusive)
	 * @return the range of delegated roles
	 */
	@Override
	public List<DelegatedRole> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the delegated roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegatedRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of delegated roles
	 * @param end the upper bound of the range of delegated roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of delegated roles
	 */
	@Override
	public List<DelegatedRole> findAll(
		int start, int end,
		OrderByComparator<DelegatedRole> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the delegated roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegatedRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of delegated roles
	 * @param end the upper bound of the range of delegated roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of delegated roles
	 */
	@Override
	public List<DelegatedRole> findAll(
		int start, int end, OrderByComparator<DelegatedRole> orderByComparator,
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

		List<DelegatedRole> list = null;

		if (useFinderCache) {
			list = (List<DelegatedRole>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DELEGATEDROLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DELEGATEDROLE;

				sql = sql.concat(DelegatedRoleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DelegatedRole>)QueryUtil.list(
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
	 * Removes all the delegated roles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DelegatedRole delegatedRole : findAll()) {
			remove(delegatedRole);
		}
	}

	/**
	 * Returns the number of delegated roles.
	 *
	 * @return the number of delegated roles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DELEGATEDROLE);

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
		return "roleId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DELEGATEDROLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DelegatedRoleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the delegated role persistence.
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

		_finderPathFetchById = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchById",
			new String[] {Long.class.getName()}, new String[] {"roleId"}, true);

		_finderPathCountById = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countById",
			new String[] {Long.class.getName()}, new String[] {"roleId"},
			false);

		_finderPathFetchByCode = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] {String.class.getName()}, new String[] {"code_"},
			true);

		_finderPathCountByCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] {String.class.getName()}, new String[] {"code_"},
			false);

		_finderPathWithPaginationFindByG = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByG = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByG = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		_setDelegatedRoleUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDelegatedRoleUtilPersistence(null);

		entityCache.removeCache(DelegatedRoleImpl.class.getName());
	}

	private void _setDelegatedRoleUtilPersistence(
		DelegatedRolePersistence delegatedRolePersistence) {

		try {
			Field field = DelegatedRoleUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, delegatedRolePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = DelegationsPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DelegationsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DelegationsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DELEGATEDROLE =
		"SELECT delegatedRole FROM DelegatedRole delegatedRole";

	private static final String _SQL_SELECT_DELEGATEDROLE_WHERE =
		"SELECT delegatedRole FROM DelegatedRole delegatedRole WHERE ";

	private static final String _SQL_COUNT_DELEGATEDROLE =
		"SELECT COUNT(delegatedRole) FROM DelegatedRole delegatedRole";

	private static final String _SQL_COUNT_DELEGATEDROLE_WHERE =
		"SELECT COUNT(delegatedRole) FROM DelegatedRole delegatedRole WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "delegatedRole.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DelegatedRole exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DelegatedRole exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DelegatedRolePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"code"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private DelegatedRoleModelArgumentsResolver
		_delegatedRoleModelArgumentsResolver;

}