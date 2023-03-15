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

import cz.csob.ency.delegations.exception.NoSuchDelegationException;
import cz.csob.ency.delegations.model.Delegation;
import cz.csob.ency.delegations.model.DelegationTable;
import cz.csob.ency.delegations.model.impl.DelegationImpl;
import cz.csob.ency.delegations.model.impl.DelegationModelImpl;
import cz.csob.ency.delegations.service.persistence.DelegationPersistence;
import cz.csob.ency.delegations.service.persistence.DelegationUtil;
import cz.csob.ency.delegations.service.persistence.impl.constants.DelegationsPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the delegation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @generated
 */
@Component(service = {DelegationPersistence.class, BasePersistence.class})
public class DelegationPersistenceImpl
	extends BasePersistenceImpl<Delegation> implements DelegationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DelegationUtil</code> to access the delegation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DelegationImpl.class.getName();

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
	 * Returns the delegation where delegationId = &#63; or throws a <code>NoSuchDelegationException</code> if it could not be found.
	 *
	 * @param delegationId the delegation ID
	 * @return the matching delegation
	 * @throws NoSuchDelegationException if a matching delegation could not be found
	 */
	@Override
	public Delegation findById(long delegationId)
		throws NoSuchDelegationException {

		Delegation delegation = fetchById(delegationId);

		if (delegation == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("delegationId=");
			sb.append(delegationId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDelegationException(sb.toString());
		}

		return delegation;
	}

	/**
	 * Returns the delegation where delegationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param delegationId the delegation ID
	 * @return the matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	@Override
	public Delegation fetchById(long delegationId) {
		return fetchById(delegationId, true);
	}

	/**
	 * Returns the delegation where delegationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param delegationId the delegation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	@Override
	public Delegation fetchById(long delegationId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {delegationId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchById, finderArgs);
		}

		if (result instanceof Delegation) {
			Delegation delegation = (Delegation)result;

			if (delegationId != delegation.getDelegationId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DELEGATION_WHERE);

			sb.append(_FINDER_COLUMN_ID_DELEGATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(delegationId);

				List<Delegation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchById, finderArgs, list);
					}
				}
				else {
					Delegation delegation = list.get(0);

					result = delegation;

					cacheResult(delegation);
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
			return (Delegation)result;
		}
	}

	/**
	 * Removes the delegation where delegationId = &#63; from the database.
	 *
	 * @param delegationId the delegation ID
	 * @return the delegation that was removed
	 */
	@Override
	public Delegation removeById(long delegationId)
		throws NoSuchDelegationException {

		Delegation delegation = findById(delegationId);

		return remove(delegation);
	}

	/**
	 * Returns the number of delegations where delegationId = &#63;.
	 *
	 * @param delegationId the delegation ID
	 * @return the number of matching delegations
	 */
	@Override
	public int countById(long delegationId) {
		FinderPath finderPath = _finderPathCountById;

		Object[] finderArgs = new Object[] {delegationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DELEGATION_WHERE);

			sb.append(_FINDER_COLUMN_ID_DELEGATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(delegationId);

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

	private static final String _FINDER_COLUMN_ID_DELEGATIONID_2 =
		"delegation.delegationId = ?";

	private FinderPath _finderPathWithPaginationFindByG_R;
	private FinderPath _finderPathWithoutPaginationFindByG_R;
	private FinderPath _finderPathCountByG_R;

	/**
	 * Returns all the delegations where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @return the matching delegations
	 */
	@Override
	public List<Delegation> findByG_R(long groupId, long roleId) {
		return findByG_R(
			groupId, roleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the delegations where groupId = &#63; and roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @return the range of matching delegations
	 */
	@Override
	public List<Delegation> findByG_R(
		long groupId, long roleId, int start, int end) {

		return findByG_R(groupId, roleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the delegations where groupId = &#63; and roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching delegations
	 */
	@Override
	public List<Delegation> findByG_R(
		long groupId, long roleId, int start, int end,
		OrderByComparator<Delegation> orderByComparator) {

		return findByG_R(groupId, roleId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the delegations where groupId = &#63; and roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching delegations
	 */
	@Override
	public List<Delegation> findByG_R(
		long groupId, long roleId, int start, int end,
		OrderByComparator<Delegation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_R;
				finderArgs = new Object[] {groupId, roleId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_R;
			finderArgs = new Object[] {
				groupId, roleId, start, end, orderByComparator
			};
		}

		List<Delegation> list = null;

		if (useFinderCache) {
			list = (List<Delegation>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Delegation delegation : list) {
					if ((groupId != delegation.getGroupId()) ||
						(roleId != delegation.getRoleId())) {

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

			sb.append(_SQL_SELECT_DELEGATION_WHERE);

			sb.append(_FINDER_COLUMN_G_R_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_R_ROLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DelegationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(roleId);

				list = (List<Delegation>)QueryUtil.list(
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
	 * Returns the first delegation in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegation
	 * @throws NoSuchDelegationException if a matching delegation could not be found
	 */
	@Override
	public Delegation findByG_R_First(
			long groupId, long roleId,
			OrderByComparator<Delegation> orderByComparator)
		throws NoSuchDelegationException {

		Delegation delegation = fetchByG_R_First(
			groupId, roleId, orderByComparator);

		if (delegation != null) {
			return delegation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", roleId=");
		sb.append(roleId);

		sb.append("}");

		throw new NoSuchDelegationException(sb.toString());
	}

	/**
	 * Returns the first delegation in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	@Override
	public Delegation fetchByG_R_First(
		long groupId, long roleId,
		OrderByComparator<Delegation> orderByComparator) {

		List<Delegation> list = findByG_R(
			groupId, roleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last delegation in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegation
	 * @throws NoSuchDelegationException if a matching delegation could not be found
	 */
	@Override
	public Delegation findByG_R_Last(
			long groupId, long roleId,
			OrderByComparator<Delegation> orderByComparator)
		throws NoSuchDelegationException {

		Delegation delegation = fetchByG_R_Last(
			groupId, roleId, orderByComparator);

		if (delegation != null) {
			return delegation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", roleId=");
		sb.append(roleId);

		sb.append("}");

		throw new NoSuchDelegationException(sb.toString());
	}

	/**
	 * Returns the last delegation in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	@Override
	public Delegation fetchByG_R_Last(
		long groupId, long roleId,
		OrderByComparator<Delegation> orderByComparator) {

		int count = countByG_R(groupId, roleId);

		if (count == 0) {
			return null;
		}

		List<Delegation> list = findByG_R(
			groupId, roleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the delegations before and after the current delegation in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param delegationId the primary key of the current delegation
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next delegation
	 * @throws NoSuchDelegationException if a delegation with the primary key could not be found
	 */
	@Override
	public Delegation[] findByG_R_PrevAndNext(
			long delegationId, long groupId, long roleId,
			OrderByComparator<Delegation> orderByComparator)
		throws NoSuchDelegationException {

		Delegation delegation = findByPrimaryKey(delegationId);

		Session session = null;

		try {
			session = openSession();

			Delegation[] array = new DelegationImpl[3];

			array[0] = getByG_R_PrevAndNext(
				session, delegation, groupId, roleId, orderByComparator, true);

			array[1] = delegation;

			array[2] = getByG_R_PrevAndNext(
				session, delegation, groupId, roleId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Delegation getByG_R_PrevAndNext(
		Session session, Delegation delegation, long groupId, long roleId,
		OrderByComparator<Delegation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DELEGATION_WHERE);

		sb.append(_FINDER_COLUMN_G_R_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_R_ROLEID_2);

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
			sb.append(DelegationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(roleId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(delegation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Delegation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the delegations where groupId = &#63; and roleId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 */
	@Override
	public void removeByG_R(long groupId, long roleId) {
		for (Delegation delegation :
				findByG_R(
					groupId, roleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(delegation);
		}
	}

	/**
	 * Returns the number of delegations where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @return the number of matching delegations
	 */
	@Override
	public int countByG_R(long groupId, long roleId) {
		FinderPath finderPath = _finderPathCountByG_R;

		Object[] finderArgs = new Object[] {groupId, roleId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DELEGATION_WHERE);

			sb.append(_FINDER_COLUMN_G_R_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_R_ROLEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_G_R_GROUPID_2 =
		"delegation.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_R_ROLEID_2 =
		"delegation.roleId = ?";

	private FinderPath _finderPathWithPaginationFindByG_R_Delegating;
	private FinderPath _finderPathWithoutPaginationFindByG_R_Delegating;
	private FinderPath _finderPathCountByG_R_Delegating;

	/**
	 * Returns all the delegations where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @return the matching delegations
	 */
	@Override
	public List<Delegation> findByG_R_Delegating(
		long groupId, long roleId, long delegatingUserId) {

		return findByG_R_Delegating(
			groupId, roleId, delegatingUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the delegations where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @return the range of matching delegations
	 */
	@Override
	public List<Delegation> findByG_R_Delegating(
		long groupId, long roleId, long delegatingUserId, int start, int end) {

		return findByG_R_Delegating(
			groupId, roleId, delegatingUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the delegations where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching delegations
	 */
	@Override
	public List<Delegation> findByG_R_Delegating(
		long groupId, long roleId, long delegatingUserId, int start, int end,
		OrderByComparator<Delegation> orderByComparator) {

		return findByG_R_Delegating(
			groupId, roleId, delegatingUserId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the delegations where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching delegations
	 */
	@Override
	public List<Delegation> findByG_R_Delegating(
		long groupId, long roleId, long delegatingUserId, int start, int end,
		OrderByComparator<Delegation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_R_Delegating;
				finderArgs = new Object[] {groupId, roleId, delegatingUserId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_R_Delegating;
			finderArgs = new Object[] {
				groupId, roleId, delegatingUserId, start, end, orderByComparator
			};
		}

		List<Delegation> list = null;

		if (useFinderCache) {
			list = (List<Delegation>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Delegation delegation : list) {
					if ((groupId != delegation.getGroupId()) ||
						(roleId != delegation.getRoleId()) ||
						(delegatingUserId !=
							delegation.getDelegatingUserId())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_DELEGATION_WHERE);

			sb.append(_FINDER_COLUMN_G_R_DELEGATING_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_R_DELEGATING_ROLEID_2);

			sb.append(_FINDER_COLUMN_G_R_DELEGATING_DELEGATINGUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DelegationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(roleId);

				queryPos.add(delegatingUserId);

				list = (List<Delegation>)QueryUtil.list(
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
	 * Returns the first delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegation
	 * @throws NoSuchDelegationException if a matching delegation could not be found
	 */
	@Override
	public Delegation findByG_R_Delegating_First(
			long groupId, long roleId, long delegatingUserId,
			OrderByComparator<Delegation> orderByComparator)
		throws NoSuchDelegationException {

		Delegation delegation = fetchByG_R_Delegating_First(
			groupId, roleId, delegatingUserId, orderByComparator);

		if (delegation != null) {
			return delegation;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", roleId=");
		sb.append(roleId);

		sb.append(", delegatingUserId=");
		sb.append(delegatingUserId);

		sb.append("}");

		throw new NoSuchDelegationException(sb.toString());
	}

	/**
	 * Returns the first delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	@Override
	public Delegation fetchByG_R_Delegating_First(
		long groupId, long roleId, long delegatingUserId,
		OrderByComparator<Delegation> orderByComparator) {

		List<Delegation> list = findByG_R_Delegating(
			groupId, roleId, delegatingUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegation
	 * @throws NoSuchDelegationException if a matching delegation could not be found
	 */
	@Override
	public Delegation findByG_R_Delegating_Last(
			long groupId, long roleId, long delegatingUserId,
			OrderByComparator<Delegation> orderByComparator)
		throws NoSuchDelegationException {

		Delegation delegation = fetchByG_R_Delegating_Last(
			groupId, roleId, delegatingUserId, orderByComparator);

		if (delegation != null) {
			return delegation;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", roleId=");
		sb.append(roleId);

		sb.append(", delegatingUserId=");
		sb.append(delegatingUserId);

		sb.append("}");

		throw new NoSuchDelegationException(sb.toString());
	}

	/**
	 * Returns the last delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	@Override
	public Delegation fetchByG_R_Delegating_Last(
		long groupId, long roleId, long delegatingUserId,
		OrderByComparator<Delegation> orderByComparator) {

		int count = countByG_R_Delegating(groupId, roleId, delegatingUserId);

		if (count == 0) {
			return null;
		}

		List<Delegation> list = findByG_R_Delegating(
			groupId, roleId, delegatingUserId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the delegations before and after the current delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * @param delegationId the primary key of the current delegation
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next delegation
	 * @throws NoSuchDelegationException if a delegation with the primary key could not be found
	 */
	@Override
	public Delegation[] findByG_R_Delegating_PrevAndNext(
			long delegationId, long groupId, long roleId, long delegatingUserId,
			OrderByComparator<Delegation> orderByComparator)
		throws NoSuchDelegationException {

		Delegation delegation = findByPrimaryKey(delegationId);

		Session session = null;

		try {
			session = openSession();

			Delegation[] array = new DelegationImpl[3];

			array[0] = getByG_R_Delegating_PrevAndNext(
				session, delegation, groupId, roleId, delegatingUserId,
				orderByComparator, true);

			array[1] = delegation;

			array[2] = getByG_R_Delegating_PrevAndNext(
				session, delegation, groupId, roleId, delegatingUserId,
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

	protected Delegation getByG_R_Delegating_PrevAndNext(
		Session session, Delegation delegation, long groupId, long roleId,
		long delegatingUserId, OrderByComparator<Delegation> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_DELEGATION_WHERE);

		sb.append(_FINDER_COLUMN_G_R_DELEGATING_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_R_DELEGATING_ROLEID_2);

		sb.append(_FINDER_COLUMN_G_R_DELEGATING_DELEGATINGUSERID_2);

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
			sb.append(DelegationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(roleId);

		queryPos.add(delegatingUserId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(delegation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Delegation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the delegations where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 */
	@Override
	public void removeByG_R_Delegating(
		long groupId, long roleId, long delegatingUserId) {

		for (Delegation delegation :
				findByG_R_Delegating(
					groupId, roleId, delegatingUserId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(delegation);
		}
	}

	/**
	 * Returns the number of delegations where groupId = &#63; and roleId = &#63; and delegatingUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatingUserId the delegating user ID
	 * @return the number of matching delegations
	 */
	@Override
	public int countByG_R_Delegating(
		long groupId, long roleId, long delegatingUserId) {

		FinderPath finderPath = _finderPathCountByG_R_Delegating;

		Object[] finderArgs = new Object[] {groupId, roleId, delegatingUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DELEGATION_WHERE);

			sb.append(_FINDER_COLUMN_G_R_DELEGATING_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_R_DELEGATING_ROLEID_2);

			sb.append(_FINDER_COLUMN_G_R_DELEGATING_DELEGATINGUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(roleId);

				queryPos.add(delegatingUserId);

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

	private static final String _FINDER_COLUMN_G_R_DELEGATING_GROUPID_2 =
		"delegation.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_R_DELEGATING_ROLEID_2 =
		"delegation.roleId = ? AND ";

	private static final String
		_FINDER_COLUMN_G_R_DELEGATING_DELEGATINGUSERID_2 =
			"delegation.delegatingUserId = ?";

	private FinderPath _finderPathWithPaginationFindByG_R_Delegated;
	private FinderPath _finderPathWithoutPaginationFindByG_R_Delegated;
	private FinderPath _finderPathCountByG_R_Delegated;

	/**
	 * Returns all the delegations where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @return the matching delegations
	 */
	@Override
	public List<Delegation> findByG_R_Delegated(
		long groupId, long roleId, long delegatedUserId) {

		return findByG_R_Delegated(
			groupId, roleId, delegatedUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the delegations where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @return the range of matching delegations
	 */
	@Override
	public List<Delegation> findByG_R_Delegated(
		long groupId, long roleId, long delegatedUserId, int start, int end) {

		return findByG_R_Delegated(
			groupId, roleId, delegatedUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the delegations where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching delegations
	 */
	@Override
	public List<Delegation> findByG_R_Delegated(
		long groupId, long roleId, long delegatedUserId, int start, int end,
		OrderByComparator<Delegation> orderByComparator) {

		return findByG_R_Delegated(
			groupId, roleId, delegatedUserId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the delegations where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching delegations
	 */
	@Override
	public List<Delegation> findByG_R_Delegated(
		long groupId, long roleId, long delegatedUserId, int start, int end,
		OrderByComparator<Delegation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_R_Delegated;
				finderArgs = new Object[] {groupId, roleId, delegatedUserId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_R_Delegated;
			finderArgs = new Object[] {
				groupId, roleId, delegatedUserId, start, end, orderByComparator
			};
		}

		List<Delegation> list = null;

		if (useFinderCache) {
			list = (List<Delegation>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Delegation delegation : list) {
					if ((groupId != delegation.getGroupId()) ||
						(roleId != delegation.getRoleId()) ||
						(delegatedUserId != delegation.getDelegatedUserId())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_DELEGATION_WHERE);

			sb.append(_FINDER_COLUMN_G_R_DELEGATED_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_R_DELEGATED_ROLEID_2);

			sb.append(_FINDER_COLUMN_G_R_DELEGATED_DELEGATEDUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DelegationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(roleId);

				queryPos.add(delegatedUserId);

				list = (List<Delegation>)QueryUtil.list(
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
	 * Returns the first delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegation
	 * @throws NoSuchDelegationException if a matching delegation could not be found
	 */
	@Override
	public Delegation findByG_R_Delegated_First(
			long groupId, long roleId, long delegatedUserId,
			OrderByComparator<Delegation> orderByComparator)
		throws NoSuchDelegationException {

		Delegation delegation = fetchByG_R_Delegated_First(
			groupId, roleId, delegatedUserId, orderByComparator);

		if (delegation != null) {
			return delegation;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", roleId=");
		sb.append(roleId);

		sb.append(", delegatedUserId=");
		sb.append(delegatedUserId);

		sb.append("}");

		throw new NoSuchDelegationException(sb.toString());
	}

	/**
	 * Returns the first delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	@Override
	public Delegation fetchByG_R_Delegated_First(
		long groupId, long roleId, long delegatedUserId,
		OrderByComparator<Delegation> orderByComparator) {

		List<Delegation> list = findByG_R_Delegated(
			groupId, roleId, delegatedUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegation
	 * @throws NoSuchDelegationException if a matching delegation could not be found
	 */
	@Override
	public Delegation findByG_R_Delegated_Last(
			long groupId, long roleId, long delegatedUserId,
			OrderByComparator<Delegation> orderByComparator)
		throws NoSuchDelegationException {

		Delegation delegation = fetchByG_R_Delegated_Last(
			groupId, roleId, delegatedUserId, orderByComparator);

		if (delegation != null) {
			return delegation;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", roleId=");
		sb.append(roleId);

		sb.append(", delegatedUserId=");
		sb.append(delegatedUserId);

		sb.append("}");

		throw new NoSuchDelegationException(sb.toString());
	}

	/**
	 * Returns the last delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	@Override
	public Delegation fetchByG_R_Delegated_Last(
		long groupId, long roleId, long delegatedUserId,
		OrderByComparator<Delegation> orderByComparator) {

		int count = countByG_R_Delegated(groupId, roleId, delegatedUserId);

		if (count == 0) {
			return null;
		}

		List<Delegation> list = findByG_R_Delegated(
			groupId, roleId, delegatedUserId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the delegations before and after the current delegation in the ordered set where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * @param delegationId the primary key of the current delegation
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next delegation
	 * @throws NoSuchDelegationException if a delegation with the primary key could not be found
	 */
	@Override
	public Delegation[] findByG_R_Delegated_PrevAndNext(
			long delegationId, long groupId, long roleId, long delegatedUserId,
			OrderByComparator<Delegation> orderByComparator)
		throws NoSuchDelegationException {

		Delegation delegation = findByPrimaryKey(delegationId);

		Session session = null;

		try {
			session = openSession();

			Delegation[] array = new DelegationImpl[3];

			array[0] = getByG_R_Delegated_PrevAndNext(
				session, delegation, groupId, roleId, delegatedUserId,
				orderByComparator, true);

			array[1] = delegation;

			array[2] = getByG_R_Delegated_PrevAndNext(
				session, delegation, groupId, roleId, delegatedUserId,
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

	protected Delegation getByG_R_Delegated_PrevAndNext(
		Session session, Delegation delegation, long groupId, long roleId,
		long delegatedUserId, OrderByComparator<Delegation> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_DELEGATION_WHERE);

		sb.append(_FINDER_COLUMN_G_R_DELEGATED_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_R_DELEGATED_ROLEID_2);

		sb.append(_FINDER_COLUMN_G_R_DELEGATED_DELEGATEDUSERID_2);

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
			sb.append(DelegationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(roleId);

		queryPos.add(delegatedUserId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(delegation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Delegation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the delegations where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 */
	@Override
	public void removeByG_R_Delegated(
		long groupId, long roleId, long delegatedUserId) {

		for (Delegation delegation :
				findByG_R_Delegated(
					groupId, roleId, delegatedUserId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(delegation);
		}
	}

	/**
	 * Returns the number of delegations where groupId = &#63; and roleId = &#63; and delegatedUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param delegatedUserId the delegated user ID
	 * @return the number of matching delegations
	 */
	@Override
	public int countByG_R_Delegated(
		long groupId, long roleId, long delegatedUserId) {

		FinderPath finderPath = _finderPathCountByG_R_Delegated;

		Object[] finderArgs = new Object[] {groupId, roleId, delegatedUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DELEGATION_WHERE);

			sb.append(_FINDER_COLUMN_G_R_DELEGATED_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_R_DELEGATED_ROLEID_2);

			sb.append(_FINDER_COLUMN_G_R_DELEGATED_DELEGATEDUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(roleId);

				queryPos.add(delegatedUserId);

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

	private static final String _FINDER_COLUMN_G_R_DELEGATED_GROUPID_2 =
		"delegation.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_R_DELEGATED_ROLEID_2 =
		"delegation.roleId = ? AND ";

	private static final String _FINDER_COLUMN_G_R_DELEGATED_DELEGATEDUSERID_2 =
		"delegation.delegatedUserId = ?";

	private FinderPath _finderPathWithPaginationFindByG;
	private FinderPath _finderPathWithoutPaginationFindByG;
	private FinderPath _finderPathCountByG;

	/**
	 * Returns all the delegations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching delegations
	 */
	@Override
	public List<Delegation> findByG(long groupId) {
		return findByG(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the delegations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @return the range of matching delegations
	 */
	@Override
	public List<Delegation> findByG(long groupId, int start, int end) {
		return findByG(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the delegations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching delegations
	 */
	@Override
	public List<Delegation> findByG(
		long groupId, int start, int end,
		OrderByComparator<Delegation> orderByComparator) {

		return findByG(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the delegations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching delegations
	 */
	@Override
	public List<Delegation> findByG(
		long groupId, int start, int end,
		OrderByComparator<Delegation> orderByComparator,
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

		List<Delegation> list = null;

		if (useFinderCache) {
			list = (List<Delegation>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Delegation delegation : list) {
					if (groupId != delegation.getGroupId()) {
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

			sb.append(_SQL_SELECT_DELEGATION_WHERE);

			sb.append(_FINDER_COLUMN_G_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DelegationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Delegation>)QueryUtil.list(
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
	 * Returns the first delegation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegation
	 * @throws NoSuchDelegationException if a matching delegation could not be found
	 */
	@Override
	public Delegation findByG_First(
			long groupId, OrderByComparator<Delegation> orderByComparator)
		throws NoSuchDelegationException {

		Delegation delegation = fetchByG_First(groupId, orderByComparator);

		if (delegation != null) {
			return delegation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDelegationException(sb.toString());
	}

	/**
	 * Returns the first delegation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	@Override
	public Delegation fetchByG_First(
		long groupId, OrderByComparator<Delegation> orderByComparator) {

		List<Delegation> list = findByG(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last delegation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegation
	 * @throws NoSuchDelegationException if a matching delegation could not be found
	 */
	@Override
	public Delegation findByG_Last(
			long groupId, OrderByComparator<Delegation> orderByComparator)
		throws NoSuchDelegationException {

		Delegation delegation = fetchByG_Last(groupId, orderByComparator);

		if (delegation != null) {
			return delegation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDelegationException(sb.toString());
	}

	/**
	 * Returns the last delegation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delegation, or <code>null</code> if a matching delegation could not be found
	 */
	@Override
	public Delegation fetchByG_Last(
		long groupId, OrderByComparator<Delegation> orderByComparator) {

		int count = countByG(groupId);

		if (count == 0) {
			return null;
		}

		List<Delegation> list = findByG(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the delegations before and after the current delegation in the ordered set where groupId = &#63;.
	 *
	 * @param delegationId the primary key of the current delegation
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next delegation
	 * @throws NoSuchDelegationException if a delegation with the primary key could not be found
	 */
	@Override
	public Delegation[] findByG_PrevAndNext(
			long delegationId, long groupId,
			OrderByComparator<Delegation> orderByComparator)
		throws NoSuchDelegationException {

		Delegation delegation = findByPrimaryKey(delegationId);

		Session session = null;

		try {
			session = openSession();

			Delegation[] array = new DelegationImpl[3];

			array[0] = getByG_PrevAndNext(
				session, delegation, groupId, orderByComparator, true);

			array[1] = delegation;

			array[2] = getByG_PrevAndNext(
				session, delegation, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Delegation getByG_PrevAndNext(
		Session session, Delegation delegation, long groupId,
		OrderByComparator<Delegation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DELEGATION_WHERE);

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
			sb.append(DelegationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(delegation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Delegation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the delegations where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByG(long groupId) {
		for (Delegation delegation :
				findByG(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(delegation);
		}
	}

	/**
	 * Returns the number of delegations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching delegations
	 */
	@Override
	public int countByG(long groupId) {
		FinderPath finderPath = _finderPathCountByG;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DELEGATION_WHERE);

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
		"delegation.groupId = ?";

	public DelegationPersistenceImpl() {
		setModelClass(Delegation.class);

		setModelImplClass(DelegationImpl.class);
		setModelPKClass(long.class);

		setTable(DelegationTable.INSTANCE);
	}

	/**
	 * Caches the delegation in the entity cache if it is enabled.
	 *
	 * @param delegation the delegation
	 */
	@Override
	public void cacheResult(Delegation delegation) {
		entityCache.putResult(
			DelegationImpl.class, delegation.getPrimaryKey(), delegation);

		finderCache.putResult(
			_finderPathFetchById, new Object[] {delegation.getDelegationId()},
			delegation);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the delegations in the entity cache if it is enabled.
	 *
	 * @param delegations the delegations
	 */
	@Override
	public void cacheResult(List<Delegation> delegations) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (delegations.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Delegation delegation : delegations) {
			if (entityCache.getResult(
					DelegationImpl.class, delegation.getPrimaryKey()) == null) {

				cacheResult(delegation);
			}
		}
	}

	/**
	 * Clears the cache for all delegations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DelegationImpl.class);

		finderCache.clearCache(DelegationImpl.class);
	}

	/**
	 * Clears the cache for the delegation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Delegation delegation) {
		entityCache.removeResult(DelegationImpl.class, delegation);
	}

	@Override
	public void clearCache(List<Delegation> delegations) {
		for (Delegation delegation : delegations) {
			entityCache.removeResult(DelegationImpl.class, delegation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DelegationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DelegationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DelegationModelImpl delegationModelImpl) {

		Object[] args = new Object[] {delegationModelImpl.getDelegationId()};

		finderCache.putResult(_finderPathCountById, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchById, args, delegationModelImpl);
	}

	/**
	 * Creates a new delegation with the primary key. Does not add the delegation to the database.
	 *
	 * @param delegationId the primary key for the new delegation
	 * @return the new delegation
	 */
	@Override
	public Delegation create(long delegationId) {
		Delegation delegation = new DelegationImpl();

		delegation.setNew(true);
		delegation.setPrimaryKey(delegationId);

		delegation.setCompanyId(CompanyThreadLocal.getCompanyId());

		return delegation;
	}

	/**
	 * Removes the delegation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param delegationId the primary key of the delegation
	 * @return the delegation that was removed
	 * @throws NoSuchDelegationException if a delegation with the primary key could not be found
	 */
	@Override
	public Delegation remove(long delegationId)
		throws NoSuchDelegationException {

		return remove((Serializable)delegationId);
	}

	/**
	 * Removes the delegation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the delegation
	 * @return the delegation that was removed
	 * @throws NoSuchDelegationException if a delegation with the primary key could not be found
	 */
	@Override
	public Delegation remove(Serializable primaryKey)
		throws NoSuchDelegationException {

		Session session = null;

		try {
			session = openSession();

			Delegation delegation = (Delegation)session.get(
				DelegationImpl.class, primaryKey);

			if (delegation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDelegationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(delegation);
		}
		catch (NoSuchDelegationException noSuchEntityException) {
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
	protected Delegation removeImpl(Delegation delegation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(delegation)) {
				delegation = (Delegation)session.get(
					DelegationImpl.class, delegation.getPrimaryKeyObj());
			}

			if (delegation != null) {
				session.delete(delegation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (delegation != null) {
			clearCache(delegation);
		}

		return delegation;
	}

	@Override
	public Delegation updateImpl(Delegation delegation) {
		boolean isNew = delegation.isNew();

		if (!(delegation instanceof DelegationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(delegation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(delegation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in delegation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Delegation implementation " +
					delegation.getClass());
		}

		DelegationModelImpl delegationModelImpl =
			(DelegationModelImpl)delegation;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (delegation.getCreateDate() == null)) {
			if (serviceContext == null) {
				delegation.setCreateDate(date);
			}
			else {
				delegation.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!delegationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				delegation.setModifiedDate(date);
			}
			else {
				delegation.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(delegation);
			}
			else {
				delegation = (Delegation)session.merge(delegation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DelegationImpl.class, delegationModelImpl, false, true);

		cacheUniqueFindersCache(delegationModelImpl);

		if (isNew) {
			delegation.setNew(false);
		}

		delegation.resetOriginalValues();

		return delegation;
	}

	/**
	 * Returns the delegation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the delegation
	 * @return the delegation
	 * @throws NoSuchDelegationException if a delegation with the primary key could not be found
	 */
	@Override
	public Delegation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDelegationException {

		Delegation delegation = fetchByPrimaryKey(primaryKey);

		if (delegation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDelegationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return delegation;
	}

	/**
	 * Returns the delegation with the primary key or throws a <code>NoSuchDelegationException</code> if it could not be found.
	 *
	 * @param delegationId the primary key of the delegation
	 * @return the delegation
	 * @throws NoSuchDelegationException if a delegation with the primary key could not be found
	 */
	@Override
	public Delegation findByPrimaryKey(long delegationId)
		throws NoSuchDelegationException {

		return findByPrimaryKey((Serializable)delegationId);
	}

	/**
	 * Returns the delegation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param delegationId the primary key of the delegation
	 * @return the delegation, or <code>null</code> if a delegation with the primary key could not be found
	 */
	@Override
	public Delegation fetchByPrimaryKey(long delegationId) {
		return fetchByPrimaryKey((Serializable)delegationId);
	}

	/**
	 * Returns all the delegations.
	 *
	 * @return the delegations
	 */
	@Override
	public List<Delegation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @return the range of delegations
	 */
	@Override
	public List<Delegation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of delegations
	 */
	@Override
	public List<Delegation> findAll(
		int start, int end, OrderByComparator<Delegation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of delegations
	 * @param end the upper bound of the range of delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of delegations
	 */
	@Override
	public List<Delegation> findAll(
		int start, int end, OrderByComparator<Delegation> orderByComparator,
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

		List<Delegation> list = null;

		if (useFinderCache) {
			list = (List<Delegation>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DELEGATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DELEGATION;

				sql = sql.concat(DelegationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Delegation>)QueryUtil.list(
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
	 * Removes all the delegations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Delegation delegation : findAll()) {
			remove(delegation);
		}
	}

	/**
	 * Returns the number of delegations.
	 *
	 * @return the number of delegations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DELEGATION);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "delegationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DELEGATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DelegationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the delegation persistence.
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
			new String[] {Long.class.getName()}, new String[] {"delegationId"},
			true);

		_finderPathCountById = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countById",
			new String[] {Long.class.getName()}, new String[] {"delegationId"},
			false);

		_finderPathWithPaginationFindByG_R = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_R",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "roleId"}, true);

		_finderPathWithoutPaginationFindByG_R = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_R",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "roleId"}, true);

		_finderPathCountByG_R = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_R",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "roleId"}, false);

		_finderPathWithPaginationFindByG_R_Delegating = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_R_Delegating",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId", "roleId", "delegatingUserId"}, true);

		_finderPathWithoutPaginationFindByG_R_Delegating = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_R_Delegating",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			new String[] {"groupId", "roleId", "delegatingUserId"}, true);

		_finderPathCountByG_R_Delegating = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_R_Delegating",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			new String[] {"groupId", "roleId", "delegatingUserId"}, false);

		_finderPathWithPaginationFindByG_R_Delegated = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_R_Delegated",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId", "roleId", "delegatedUserId"}, true);

		_finderPathWithoutPaginationFindByG_R_Delegated = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_R_Delegated",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			new String[] {"groupId", "roleId", "delegatedUserId"}, true);

		_finderPathCountByG_R_Delegated = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_R_Delegated",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			new String[] {"groupId", "roleId", "delegatedUserId"}, false);

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

		_setDelegationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDelegationUtilPersistence(null);

		entityCache.removeCache(DelegationImpl.class.getName());
	}

	private void _setDelegationUtilPersistence(
		DelegationPersistence delegationPersistence) {

		try {
			Field field = DelegationUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, delegationPersistence);
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

	private static final String _SQL_SELECT_DELEGATION =
		"SELECT delegation FROM Delegation delegation";

	private static final String _SQL_SELECT_DELEGATION_WHERE =
		"SELECT delegation FROM Delegation delegation WHERE ";

	private static final String _SQL_COUNT_DELEGATION =
		"SELECT COUNT(delegation) FROM Delegation delegation";

	private static final String _SQL_COUNT_DELEGATION_WHERE =
		"SELECT COUNT(delegation) FROM Delegation delegation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "delegation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Delegation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Delegation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DelegationPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private DelegationModelArgumentsResolver _delegationModelArgumentsResolver;

}