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

package cz.csob.ency.modules.apps.meta.cds.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import cz.csob.ency.modules.apps.meta.cds.exception.NoSuchColumnEntryException;
import cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry;
import cz.csob.ency.modules.apps.meta.cds.model.ColumnEntryTable;
import cz.csob.ency.modules.apps.meta.cds.model.impl.ColumnEntryImpl;
import cz.csob.ency.modules.apps.meta.cds.model.impl.ColumnEntryModelImpl;
import cz.csob.ency.modules.apps.meta.cds.service.persistence.ColumnEntryPersistence;
import cz.csob.ency.modules.apps.meta.cds.service.persistence.ColumnEntryUtil;
import cz.csob.ency.modules.apps.meta.cds.service.persistence.impl.constants.MetaCdsPersistenceConstants;

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
 * The persistence implementation for the column entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author "Miroslav Čermák"
 * @generated
 */
@Component(service = {ColumnEntryPersistence.class, BasePersistence.class})
public class ColumnEntryPersistenceImpl
	extends BasePersistenceImpl<ColumnEntry> implements ColumnEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ColumnEntryUtil</code> to access the column entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ColumnEntryImpl.class.getName();

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
	 * Returns all the column entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
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

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if (!uuid.equals(columnEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

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
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<ColumnEntry>)QueryUtil.list(
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
	 * Returns the first column entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByUuid_First(
			String uuid, OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByUuid_First(uuid, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the first column entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByUuid_First(
		String uuid, OrderByComparator<ColumnEntry> orderByComparator) {

		List<ColumnEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last column entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByUuid_Last(
			String uuid, OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the last column entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByUuid_Last(
		String uuid, OrderByComparator<ColumnEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ColumnEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where uuid = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] findByUuid_PrevAndNext(
			long columnEntryId, String uuid,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		uuid = Objects.toString(uuid, "");

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, columnEntry, uuid, orderByComparator, true);

			array[1] = columnEntry;

			array[2] = getByUuid_PrevAndNext(
				session, columnEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ColumnEntry getByUuid_PrevAndNext(
		Session session, ColumnEntry columnEntry, String uuid,
		OrderByComparator<ColumnEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

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
			sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the column entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ColumnEntry columnEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(columnEntry);
		}
	}

	/**
	 * Returns the number of column entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching column entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

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
		"columnEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(columnEntry.uuid IS NULL OR columnEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the column entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchColumnEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByUUID_G(uuid, groupId);

		if (columnEntry == null) {
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

			throw new NoSuchColumnEntryException(sb.toString());
		}

		return columnEntry;
	}

	/**
	 * Returns the column entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the column entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByUUID_G(
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

		if (result instanceof ColumnEntry) {
			ColumnEntry columnEntry = (ColumnEntry)result;

			if (!Objects.equals(uuid, columnEntry.getUuid()) ||
				(groupId != columnEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

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

				List<ColumnEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ColumnEntry columnEntry = list.get(0);

					result = columnEntry;

					cacheResult(columnEntry);
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
			return (ColumnEntry)result;
		}
	}

	/**
	 * Removes the column entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the column entry that was removed
	 */
	@Override
	public ColumnEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = findByUUID_G(uuid, groupId);

		return remove(columnEntry);
	}

	/**
	 * Returns the number of column entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching column entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

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
		"columnEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(columnEntry.uuid IS NULL OR columnEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"columnEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the column entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
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

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if (!uuid.equals(columnEntry.getUuid()) ||
						(companyId != columnEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

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
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<ColumnEntry>)QueryUtil.list(
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
	 * Returns the first column entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the first column entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ColumnEntry> orderByComparator) {

		List<ColumnEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last column entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the last column entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ColumnEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ColumnEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] findByUuid_C_PrevAndNext(
			long columnEntryId, String uuid, long companyId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		uuid = Objects.toString(uuid, "");

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, columnEntry, uuid, companyId, orderByComparator, true);

			array[1] = columnEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, columnEntry, uuid, companyId, orderByComparator,
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

	protected ColumnEntry getByUuid_C_PrevAndNext(
		Session session, ColumnEntry columnEntry, String uuid, long companyId,
		OrderByComparator<ColumnEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

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
			sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the column entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ColumnEntry columnEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(columnEntry);
		}
	}

	/**
	 * Returns the number of column entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching column entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

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
		"columnEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(columnEntry.uuid IS NULL OR columnEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"columnEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByC_S;
	private FinderPath _finderPathWithoutPaginationFindByC_S;
	private FinderPath _finderPathCountByC_S;
	private FinderPath _finderPathWithPaginationCountByC_S;

	/**
	 * Returns all the column entries where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByC_S(long companyId, int status) {
		return findByC_S(
			companyId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByC_S(
		long companyId, int status, int start, int end) {

		return findByC_S(companyId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByC_S(
		long companyId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByC_S(
			companyId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByC_S(
		long companyId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_S;
				finderArgs = new Object[] {companyId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_S;
			finderArgs = new Object[] {
				companyId, status, start, end, orderByComparator
			};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if ((companyId != columnEntry.getCompanyId()) ||
						(status != columnEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_S_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(status);

				list = (List<ColumnEntry>)QueryUtil.list(
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
	 * Returns the first column entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByC_S_First(
			long companyId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByC_S_First(
			companyId, status, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the first column entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByC_S_First(
		long companyId, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		List<ColumnEntry> list = findByC_S(
			companyId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last column entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByC_S_Last(
			long companyId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByC_S_Last(
			companyId, status, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the last column entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByC_S_Last(
		long companyId, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		int count = countByC_S(companyId, status);

		if (count == 0) {
			return null;
		}

		List<ColumnEntry> list = findByC_S(
			companyId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] findByC_S_PrevAndNext(
			long columnEntryId, long companyId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = getByC_S_PrevAndNext(
				session, columnEntry, companyId, status, orderByComparator,
				true);

			array[1] = columnEntry;

			array[2] = getByC_S_PrevAndNext(
				session, columnEntry, companyId, status, orderByComparator,
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

	protected ColumnEntry getByC_S_PrevAndNext(
		Session session, ColumnEntry columnEntry, long companyId, int status,
		OrderByComparator<ColumnEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

		sb.append(_FINDER_COLUMN_C_S_COMPANYID_2);

		sb.append(_FINDER_COLUMN_C_S_STATUS_2);

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
			sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the column entries where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByC_S(long companyId, int[] statuses) {
		return findByC_S(
			companyId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByC_S(
		long companyId, int[] statuses, int start, int end) {

		return findByC_S(companyId, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByC_S(
		long companyId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByC_S(
			companyId, statuses, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where companyId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByC_S(
		long companyId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		if (statuses.length == 1) {
			return findByC_S(
				companyId, statuses[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					companyId, StringUtil.merge(statuses)
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				companyId, StringUtil.merge(statuses), start, end,
				orderByComparator
			};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				_finderPathWithPaginationFindByC_S, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if ((companyId != columnEntry.getCompanyId()) ||
						!ArrayUtil.contains(
							statuses, columnEntry.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_S_COMPANYID_2);

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_C_S_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<ColumnEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByC_S, finderArgs, list);
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
	 * Removes all the column entries where companyId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 */
	@Override
	public void removeByC_S(long companyId, int status) {
		for (ColumnEntry columnEntry :
				findByC_S(
					companyId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(columnEntry);
		}
	}

	/**
	 * Returns the number of column entries where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching column entries
	 */
	@Override
	public int countByC_S(long companyId, int status) {
		FinderPath finderPath = _finderPathCountByC_S;

		Object[] finderArgs = new Object[] {companyId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_S_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(status);

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

	/**
	 * Returns the number of column entries where companyId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @return the number of matching column entries
	 */
	@Override
	public int countByC_S(long companyId, int[] statuses) {
		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		Object[] finderArgs = new Object[] {
			companyId, StringUtil.merge(statuses)
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByC_S, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_S_COMPANYID_2);

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_C_S_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByC_S, finderArgs, count);
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

	private static final String _FINDER_COLUMN_C_S_COMPANYID_2 =
		"columnEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_S_STATUS_2 =
		"columnEntry.status = ?";

	private static final String _FINDER_COLUMN_C_S_STATUS_7 =
		"columnEntry.status IN (";

	private FinderPath _finderPathWithPaginationFindByG_S;
	private FinderPath _finderPathWithoutPaginationFindByG_S;
	private FinderPath _finderPathCountByG_S;
	private FinderPath _finderPathWithPaginationCountByG_S;

	/**
	 * Returns all the column entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_S(long groupId, int status) {
		return findByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_S(
		long groupId, int status, int start, int end) {

		return findByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByG_S(groupId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_S;
				finderArgs = new Object[] {groupId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_S;
			finderArgs = new Object[] {
				groupId, status, start, end, orderByComparator
			};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if ((groupId != columnEntry.getGroupId()) ||
						(status != columnEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				list = (List<ColumnEntry>)QueryUtil.list(
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
	 * Returns the first column entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByG_S_First(
			long groupId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByG_S_First(
			groupId, status, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the first column entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		List<ColumnEntry> list = findByG_S(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last column entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByG_S_Last(
			long groupId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByG_S_Last(
			groupId, status, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the last column entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		int count = countByG_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<ColumnEntry> list = findByG_S(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] findByG_S_PrevAndNext(
			long columnEntryId, long groupId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = getByG_S_PrevAndNext(
				session, columnEntry, groupId, status, orderByComparator, true);

			array[1] = columnEntry;

			array[2] = getByG_S_PrevAndNext(
				session, columnEntry, groupId, status, orderByComparator,
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

	protected ColumnEntry getByG_S_PrevAndNext(
		Session session, ColumnEntry columnEntry, long groupId, int status,
		OrderByComparator<ColumnEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

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
			sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the column entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByG_S(long groupId, int status) {
		return filterFindByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return filterFindByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S(groupId, status, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_COLUMNENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ColumnEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, ColumnEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, ColumnEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(status);

			return (List<ColumnEntry>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set of column entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] filterFindByG_S_PrevAndNext(
			long columnEntryId, long groupId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_PrevAndNext(
				columnEntryId, groupId, status, orderByComparator);
		}

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = filterGetByG_S_PrevAndNext(
				session, columnEntry, groupId, status, orderByComparator, true);

			array[1] = columnEntry;

			array[2] = filterGetByG_S_PrevAndNext(
				session, columnEntry, groupId, status, orderByComparator,
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

	protected ColumnEntry filterGetByG_S_PrevAndNext(
		Session session, ColumnEntry columnEntry, long groupId, int status,
		OrderByComparator<ColumnEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_COLUMNENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ColumnEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, ColumnEntryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, ColumnEntryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the column entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByG_S(long groupId, int[] statuses) {
		return filterFindByG_S(
			groupId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByG_S(
		long groupId, int[] statuses, int start, int end) {

		return filterFindByG_S(groupId, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S(groupId, statuses, start, end, orderByComparator);
		}

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		StringBundler sb = new StringBundler();

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_COLUMNENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		if (statuses.length > 0) {
			sb.append("(");

			sb.append(_FINDER_COLUMN_G_S_STATUS_7);

			sb.append(StringUtil.merge(statuses));

			sb.append(")");

			sb.append(")");
		}

		sb.setStringAt(
			removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ColumnEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, ColumnEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, ColumnEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			return (List<ColumnEntry>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns all the column entries where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_S(long groupId, int[] statuses) {
		return findByG_S(
			groupId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_S(
		long groupId, int[] statuses, int start, int end) {

		return findByG_S(groupId, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByG_S(
			groupId, statuses, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		if (statuses.length == 1) {
			return findByG_S(
				groupId, statuses[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {groupId, StringUtil.merge(statuses)};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				groupId, StringUtil.merge(statuses), start, end,
				orderByComparator
			};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				_finderPathWithPaginationFindByG_S, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if ((groupId != columnEntry.getGroupId()) ||
						!ArrayUtil.contains(
							statuses, columnEntry.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_G_S_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<ColumnEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByG_S, finderArgs, list);
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
	 * Removes all the column entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByG_S(long groupId, int status) {
		for (ColumnEntry columnEntry :
				findByG_S(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(columnEntry);
		}
	}

	/**
	 * Returns the number of column entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching column entries
	 */
	@Override
	public int countByG_S(long groupId, int status) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

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

	/**
	 * Returns the number of column entries where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching column entries
	 */
	@Override
	public int countByG_S(long groupId, int[] statuses) {
		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		Object[] finderArgs = new Object[] {
			groupId, StringUtil.merge(statuses)
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByG_S, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_G_S_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByG_S, finderArgs, count);
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

	/**
	 * Returns the number of column entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching column entries that the user has permission to view
	 */
	@Override
	public int filterCountByG_S(long groupId, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S(groupId, status);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_COLUMNENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ColumnEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(status);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of column entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching column entries that the user has permission to view
	 */
	@Override
	public int filterCountByG_S(long groupId, int[] statuses) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S(groupId, statuses);
		}

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		StringBundler sb = new StringBundler();

		sb.append(_FILTER_SQL_COUNT_COLUMNENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		if (statuses.length > 0) {
			sb.append("(");

			sb.append(_FINDER_COLUMN_G_S_STATUS_7);

			sb.append(StringUtil.merge(statuses));

			sb.append(")");

			sb.append(")");
		}

		sb.setStringAt(
			removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ColumnEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 =
		"columnEntry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_STATUS_2 =
		"columnEntry.status = ?";

	private static final String _FINDER_COLUMN_G_S_STATUS_7 =
		"columnEntry.status IN (";

	private FinderPath _finderPathWithPaginationFindByC_U_S;
	private FinderPath _finderPathWithoutPaginationFindByC_U_S;
	private FinderPath _finderPathCountByC_U_S;
	private FinderPath _finderPathWithPaginationCountByC_U_S;

	/**
	 * Returns all the column entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int status) {

		return findByC_U_S(
			companyId, userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the column entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end) {

		return findByC_U_S(companyId, userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByC_U_S(
			companyId, userId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_U_S;
				finderArgs = new Object[] {companyId, userId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_U_S;
			finderArgs = new Object[] {
				companyId, userId, status, start, end, orderByComparator
			};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if ((companyId != columnEntry.getCompanyId()) ||
						(userId != columnEntry.getUserId()) ||
						(status != columnEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_U_S_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_C_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userId);

				queryPos.add(status);

				list = (List<ColumnEntry>)QueryUtil.list(
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
	 * Returns the first column entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByC_U_S_First(
			long companyId, long userId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByC_U_S_First(
			companyId, userId, status, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the first column entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByC_U_S_First(
		long companyId, long userId, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		List<ColumnEntry> list = findByC_U_S(
			companyId, userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last column entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByC_U_S_Last(
			long companyId, long userId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByC_U_S_Last(
			companyId, userId, status, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the last column entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByC_U_S_Last(
		long companyId, long userId, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		int count = countByC_U_S(companyId, userId, status);

		if (count == 0) {
			return null;
		}

		List<ColumnEntry> list = findByC_U_S(
			companyId, userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] findByC_U_S_PrevAndNext(
			long columnEntryId, long companyId, long userId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = getByC_U_S_PrevAndNext(
				session, columnEntry, companyId, userId, status,
				orderByComparator, true);

			array[1] = columnEntry;

			array[2] = getByC_U_S_PrevAndNext(
				session, columnEntry, companyId, userId, status,
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

	protected ColumnEntry getByC_U_S_PrevAndNext(
		Session session, ColumnEntry columnEntry, long companyId, long userId,
		int status, OrderByComparator<ColumnEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

		sb.append(_FINDER_COLUMN_C_U_S_COMPANYID_2);

		sb.append(_FINDER_COLUMN_C_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_C_U_S_STATUS_2);

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
			sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		queryPos.add(userId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the column entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int[] statuses) {

		return findByC_U_S(
			companyId, userId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the column entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end) {

		return findByC_U_S(companyId, userId, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByC_U_S(
			companyId, userId, statuses, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where companyId = &#63; and userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		if (statuses.length == 1) {
			return findByC_U_S(
				companyId, userId, statuses[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					companyId, userId, StringUtil.merge(statuses)
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				companyId, userId, StringUtil.merge(statuses), start, end,
				orderByComparator
			};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				_finderPathWithPaginationFindByC_U_S, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if ((companyId != columnEntry.getCompanyId()) ||
						(userId != columnEntry.getUserId()) ||
						!ArrayUtil.contains(
							statuses, columnEntry.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_U_S_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_U_S_USERID_2);

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_C_U_S_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userId);

				list = (List<ColumnEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByC_U_S, finderArgs, list);
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
	 * Removes all the column entries where companyId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByC_U_S(long companyId, long userId, int status) {
		for (ColumnEntry columnEntry :
				findByC_U_S(
					companyId, userId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(columnEntry);
		}
	}

	/**
	 * Returns the number of column entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching column entries
	 */
	@Override
	public int countByC_U_S(long companyId, long userId, int status) {
		FinderPath finderPath = _finderPathCountByC_U_S;

		Object[] finderArgs = new Object[] {companyId, userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_U_S_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_C_U_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userId);

				queryPos.add(status);

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

	/**
	 * Returns the number of column entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching column entries
	 */
	@Override
	public int countByC_U_S(long companyId, long userId, int[] statuses) {
		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		Object[] finderArgs = new Object[] {
			companyId, userId, StringUtil.merge(statuses)
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByC_U_S, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_U_S_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_U_S_USERID_2);

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_C_U_S_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByC_U_S, finderArgs, count);
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

	private static final String _FINDER_COLUMN_C_U_S_COMPANYID_2 =
		"columnEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_U_S_USERID_2 =
		"columnEntry.userId = ? AND ";

	private static final String _FINDER_COLUMN_C_U_S_STATUS_2 =
		"columnEntry.status = ?";

	private static final String _FINDER_COLUMN_C_U_S_STATUS_7 =
		"columnEntry.status IN (";

	private FinderPath _finderPathWithPaginationFindByG_U_S;
	private FinderPath _finderPathWithoutPaginationFindByG_U_S;
	private FinderPath _finderPathCountByG_U_S;
	private FinderPath _finderPathWithPaginationCountByG_U_S;

	/**
	 * Returns all the column entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int status) {

		return findByG_U_S(
			groupId, userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the column entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return findByG_U_S(groupId, userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByG_U_S(
			groupId, userId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_U_S;
				finderArgs = new Object[] {groupId, userId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_U_S;
			finderArgs = new Object[] {
				groupId, userId, status, start, end, orderByComparator
			};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if ((groupId != columnEntry.getGroupId()) ||
						(userId != columnEntry.getUserId()) ||
						(status != columnEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				queryPos.add(status);

				list = (List<ColumnEntry>)QueryUtil.list(
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
	 * Returns the first column entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByG_U_S_First(
			long groupId, long userId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByG_U_S_First(
			groupId, userId, status, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the first column entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByG_U_S_First(
		long groupId, long userId, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		List<ColumnEntry> list = findByG_U_S(
			groupId, userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last column entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByG_U_S_Last(
			long groupId, long userId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByG_U_S_Last(
			groupId, userId, status, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the last column entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByG_U_S_Last(
		long groupId, long userId, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		int count = countByG_U_S(groupId, userId, status);

		if (count == 0) {
			return null;
		}

		List<ColumnEntry> list = findByG_U_S(
			groupId, userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] findByG_U_S_PrevAndNext(
			long columnEntryId, long groupId, long userId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = getByG_U_S_PrevAndNext(
				session, columnEntry, groupId, userId, status,
				orderByComparator, true);

			array[1] = columnEntry;

			array[2] = getByG_U_S_PrevAndNext(
				session, columnEntry, groupId, userId, status,
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

	protected ColumnEntry getByG_U_S_PrevAndNext(
		Session session, ColumnEntry columnEntry, long groupId, long userId,
		int status, OrderByComparator<ColumnEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

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
			sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(userId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the column entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByG_U_S(
		long groupId, long userId, int status) {

		return filterFindByG_U_S(
			groupId, userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the column entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return filterFindByG_U_S(groupId, userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries that the user has permissions to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_U_S(
				groupId, userId, status, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_COLUMNENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ColumnEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, ColumnEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, ColumnEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(userId);

			queryPos.add(status);

			return (List<ColumnEntry>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set of column entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] filterFindByG_U_S_PrevAndNext(
			long columnEntryId, long groupId, long userId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_U_S_PrevAndNext(
				columnEntryId, groupId, userId, status, orderByComparator);
		}

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = filterGetByG_U_S_PrevAndNext(
				session, columnEntry, groupId, userId, status,
				orderByComparator, true);

			array[1] = columnEntry;

			array[2] = filterGetByG_U_S_PrevAndNext(
				session, columnEntry, groupId, userId, status,
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

	protected ColumnEntry filterGetByG_U_S_PrevAndNext(
		Session session, ColumnEntry columnEntry, long groupId, long userId,
		int status, OrderByComparator<ColumnEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_COLUMNENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ColumnEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, ColumnEntryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, ColumnEntryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(userId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the column entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses) {

		return filterFindByG_U_S(
			groupId, userId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the column entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end) {

		return filterFindByG_U_S(groupId, userId, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_U_S(
				groupId, userId, statuses, start, end, orderByComparator);
		}

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		StringBundler sb = new StringBundler();

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_COLUMNENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

		if (statuses.length > 0) {
			sb.append("(");

			sb.append(_FINDER_COLUMN_G_U_S_STATUS_7);

			sb.append(StringUtil.merge(statuses));

			sb.append(")");

			sb.append(")");
		}

		sb.setStringAt(
			removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ColumnEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, ColumnEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, ColumnEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(userId);

			return (List<ColumnEntry>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns all the column entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int[] statuses) {

		return findByG_U_S(
			groupId, userId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the column entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end) {

		return findByG_U_S(groupId, userId, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByG_U_S(
			groupId, userId, statuses, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		if (statuses.length == 1) {
			return findByG_U_S(
				groupId, userId, statuses[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					groupId, userId, StringUtil.merge(statuses)
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				groupId, userId, StringUtil.merge(statuses), start, end,
				orderByComparator
			};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				_finderPathWithPaginationFindByG_U_S, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if ((groupId != columnEntry.getGroupId()) ||
						(userId != columnEntry.getUserId()) ||
						!ArrayUtil.contains(
							statuses, columnEntry.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_G_U_S_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				list = (List<ColumnEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByG_U_S, finderArgs, list);
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
	 * Removes all the column entries where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByG_U_S(long groupId, long userId, int status) {
		for (ColumnEntry columnEntry :
				findByG_U_S(
					groupId, userId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(columnEntry);
		}
	}

	/**
	 * Returns the number of column entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching column entries
	 */
	@Override
	public int countByG_U_S(long groupId, long userId, int status) {
		FinderPath finderPath = _finderPathCountByG_U_S;

		Object[] finderArgs = new Object[] {groupId, userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				queryPos.add(status);

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

	/**
	 * Returns the number of column entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching column entries
	 */
	@Override
	public int countByG_U_S(long groupId, long userId, int[] statuses) {
		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		Object[] finderArgs = new Object[] {
			groupId, userId, StringUtil.merge(statuses)
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByG_U_S, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_G_U_S_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByG_U_S, finderArgs, count);
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

	/**
	 * Returns the number of column entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching column entries that the user has permission to view
	 */
	@Override
	public int filterCountByG_U_S(long groupId, long userId, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_U_S(groupId, userId, status);
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_FILTER_SQL_COUNT_COLUMNENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ColumnEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(userId);

			queryPos.add(status);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of column entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching column entries that the user has permission to view
	 */
	@Override
	public int filterCountByG_U_S(long groupId, long userId, int[] statuses) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_U_S(groupId, userId, statuses);
		}

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		StringBundler sb = new StringBundler();

		sb.append(_FILTER_SQL_COUNT_COLUMNENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

		if (statuses.length > 0) {
			sb.append("(");

			sb.append(_FINDER_COLUMN_G_U_S_STATUS_7);

			sb.append(StringUtil.merge(statuses));

			sb.append(")");

			sb.append(")");
		}

		sb.setStringAt(
			removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ColumnEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(userId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_U_S_GROUPID_2 =
		"columnEntry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_U_S_USERID_2 =
		"columnEntry.userId = ? AND ";

	private static final String _FINDER_COLUMN_G_U_S_STATUS_2 =
		"columnEntry.status = ?";

	private static final String _FINDER_COLUMN_G_U_S_STATUS_7 =
		"columnEntry.status IN (";

	private FinderPath _finderPathWithPaginationFindByU_S;
	private FinderPath _finderPathWithoutPaginationFindByU_S;
	private FinderPath _finderPathCountByU_S;
	private FinderPath _finderPathWithPaginationCountByU_S;

	/**
	 * Returns all the column entries where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByU_S(long userId, int status) {
		return findByU_S(
			userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByU_S(
		long userId, int status, int start, int end) {

		return findByU_S(userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByU_S(userId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByU_S;
				finderArgs = new Object[] {userId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByU_S;
			finderArgs = new Object[] {
				userId, status, start, end, orderByComparator
			};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if ((userId != columnEntry.getUserId()) ||
						(status != columnEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(status);

				list = (List<ColumnEntry>)QueryUtil.list(
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
	 * Returns the first column entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByU_S_First(
			long userId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByU_S_First(
			userId, status, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the first column entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByU_S_First(
		long userId, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		List<ColumnEntry> list = findByU_S(
			userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last column entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByU_S_Last(
			long userId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByU_S_Last(
			userId, status, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the last column entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByU_S_Last(
		long userId, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		int count = countByU_S(userId, status);

		if (count == 0) {
			return null;
		}

		List<ColumnEntry> list = findByU_S(
			userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] findByU_S_PrevAndNext(
			long columnEntryId, long userId, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = getByU_S_PrevAndNext(
				session, columnEntry, userId, status, orderByComparator, true);

			array[1] = columnEntry;

			array[2] = getByU_S_PrevAndNext(
				session, columnEntry, userId, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ColumnEntry getByU_S_PrevAndNext(
		Session session, ColumnEntry columnEntry, long userId, int status,
		OrderByComparator<ColumnEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

		sb.append(_FINDER_COLUMN_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_U_S_STATUS_2);

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
			sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the column entries where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByU_S(long userId, int[] statuses) {
		return findByU_S(
			userId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByU_S(
		long userId, int[] statuses, int start, int end) {

		return findByU_S(userId, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByU_S(
		long userId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByU_S(userId, statuses, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByU_S(
		long userId, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		if (statuses.length == 1) {
			return findByU_S(
				userId, statuses[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {userId, StringUtil.merge(statuses)};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				userId, StringUtil.merge(statuses), start, end,
				orderByComparator
			};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				_finderPathWithPaginationFindByU_S, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if ((userId != columnEntry.getUserId()) ||
						!ArrayUtil.contains(
							statuses, columnEntry.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_U_S_USERID_2);

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_U_S_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<ColumnEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByU_S, finderArgs, list);
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
	 * Removes all the column entries where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByU_S(long userId, int status) {
		for (ColumnEntry columnEntry :
				findByU_S(
					userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(columnEntry);
		}
	}

	/**
	 * Returns the number of column entries where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching column entries
	 */
	@Override
	public int countByU_S(long userId, int status) {
		FinderPath finderPath = _finderPathCountByU_S;

		Object[] finderArgs = new Object[] {userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_U_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(status);

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

	/**
	 * Returns the number of column entries where userId = &#63; and status = any &#63;.
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching column entries
	 */
	@Override
	public int countByU_S(long userId, int[] statuses) {
		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		Object[] finderArgs = new Object[] {userId, StringUtil.merge(statuses)};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByU_S, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_U_S_USERID_2);

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_U_S_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByU_S, finderArgs, count);
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

	private static final String _FINDER_COLUMN_U_S_USERID_2 =
		"columnEntry.userId = ? AND ";

	private static final String _FINDER_COLUMN_U_S_STATUS_2 =
		"columnEntry.status = ?";

	private static final String _FINDER_COLUMN_U_S_STATUS_7 =
		"columnEntry.status IN (";

	private FinderPath _finderPathWithPaginationFindByG_UT_ST;
	private FinderPath _finderPathWithoutPaginationFindByG_UT_ST;
	private FinderPath _finderPathCountByG_UT_ST;
	private FinderPath _finderPathWithPaginationCountByG_UT_ST;

	/**
	 * Returns all the column entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return findByG_UT_ST(
			groupId, urlTitle, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the column entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end) {

		return findByG_UT_ST(groupId, urlTitle, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByG_UT_ST(
			groupId, urlTitle, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		urlTitle = Objects.toString(urlTitle, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_UT_ST;
				finderArgs = new Object[] {groupId, urlTitle, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_UT_ST;
			finderArgs = new Object[] {
				groupId, urlTitle, status, start, end, orderByComparator
			};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if ((groupId != columnEntry.getGroupId()) ||
						!urlTitle.equals(columnEntry.getUrlTitle()) ||
						(status != columnEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
			}

			sb.append(_FINDER_COLUMN_G_UT_ST_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindUrlTitle) {
					queryPos.add(urlTitle);
				}

				queryPos.add(status);

				list = (List<ColumnEntry>)QueryUtil.list(
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
	 * Returns the first column entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByG_UT_ST_First(
			long groupId, String urlTitle, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByG_UT_ST_First(
			groupId, urlTitle, status, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", urlTitle=");
		sb.append(urlTitle);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the first column entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByG_UT_ST_First(
		long groupId, String urlTitle, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		List<ColumnEntry> list = findByG_UT_ST(
			groupId, urlTitle, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last column entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByG_UT_ST_Last(
			long groupId, String urlTitle, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByG_UT_ST_Last(
			groupId, urlTitle, status, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", urlTitle=");
		sb.append(urlTitle);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the last column entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByG_UT_ST_Last(
		long groupId, String urlTitle, int status,
		OrderByComparator<ColumnEntry> orderByComparator) {

		int count = countByG_UT_ST(groupId, urlTitle, status);

		if (count == 0) {
			return null;
		}

		List<ColumnEntry> list = findByG_UT_ST(
			groupId, urlTitle, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] findByG_UT_ST_PrevAndNext(
			long columnEntryId, long groupId, String urlTitle, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		urlTitle = Objects.toString(urlTitle, "");

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = getByG_UT_ST_PrevAndNext(
				session, columnEntry, groupId, urlTitle, status,
				orderByComparator, true);

			array[1] = columnEntry;

			array[2] = getByG_UT_ST_PrevAndNext(
				session, columnEntry, groupId, urlTitle, status,
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

	protected ColumnEntry getByG_UT_ST_PrevAndNext(
		Session session, ColumnEntry columnEntry, long groupId, String urlTitle,
		int status, OrderByComparator<ColumnEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

		boolean bindUrlTitle = false;

		if (urlTitle.isEmpty()) {
			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
		}
		else {
			bindUrlTitle = true;

			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
		}

		sb.append(_FINDER_COLUMN_G_UT_ST_STATUS_2);

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
			sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (bindUrlTitle) {
			queryPos.add(urlTitle);
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the column entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return filterFindByG_UT_ST(
			groupId, urlTitle, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the column entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end) {

		return filterFindByG_UT_ST(groupId, urlTitle, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries that the user has permissions to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_UT_ST(
				groupId, urlTitle, status, start, end, orderByComparator);
		}

		urlTitle = Objects.toString(urlTitle, "");

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_COLUMNENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

		boolean bindUrlTitle = false;

		if (urlTitle.isEmpty()) {
			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
		}
		else {
			bindUrlTitle = true;

			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
		}

		sb.append(_FINDER_COLUMN_G_UT_ST_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ColumnEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, ColumnEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, ColumnEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			if (bindUrlTitle) {
				queryPos.add(urlTitle);
			}

			queryPos.add(status);

			return (List<ColumnEntry>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set of column entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] filterFindByG_UT_ST_PrevAndNext(
			long columnEntryId, long groupId, String urlTitle, int status,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_UT_ST_PrevAndNext(
				columnEntryId, groupId, urlTitle, status, orderByComparator);
		}

		urlTitle = Objects.toString(urlTitle, "");

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = filterGetByG_UT_ST_PrevAndNext(
				session, columnEntry, groupId, urlTitle, status,
				orderByComparator, true);

			array[1] = columnEntry;

			array[2] = filterGetByG_UT_ST_PrevAndNext(
				session, columnEntry, groupId, urlTitle, status,
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

	protected ColumnEntry filterGetByG_UT_ST_PrevAndNext(
		Session session, ColumnEntry columnEntry, long groupId, String urlTitle,
		int status, OrderByComparator<ColumnEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_COLUMNENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

		boolean bindUrlTitle = false;

		if (urlTitle.isEmpty()) {
			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
		}
		else {
			bindUrlTitle = true;

			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
		}

		sb.append(_FINDER_COLUMN_G_UT_ST_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ColumnEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, ColumnEntryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, ColumnEntryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (bindUrlTitle) {
			queryPos.add(urlTitle);
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the column entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return filterFindByG_UT_ST(
			groupId, urlTitle, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the column entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end) {

		return filterFindByG_UT_ST(
			groupId, urlTitle, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_UT_ST(
				groupId, urlTitle, statuses, start, end, orderByComparator);
		}

		urlTitle = Objects.toString(urlTitle, "");

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		StringBundler sb = new StringBundler();

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_COLUMNENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

		boolean bindUrlTitle = false;

		if (urlTitle.isEmpty()) {
			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
		}
		else {
			bindUrlTitle = true;

			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
		}

		if (statuses.length > 0) {
			sb.append("(");

			sb.append(_FINDER_COLUMN_G_UT_ST_STATUS_7);

			sb.append(StringUtil.merge(statuses));

			sb.append(")");

			sb.append(")");
		}

		sb.setStringAt(
			removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ColumnEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, ColumnEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, ColumnEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			if (bindUrlTitle) {
				queryPos.add(urlTitle);
			}

			return (List<ColumnEntry>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns all the column entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return findByG_UT_ST(
			groupId, urlTitle, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the column entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end) {

		return findByG_UT_ST(groupId, urlTitle, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByG_UT_ST(
			groupId, urlTitle, statuses, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63; and urlTitle = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		urlTitle = Objects.toString(urlTitle, "");

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		if (statuses.length == 1) {
			return findByG_UT_ST(
				groupId, urlTitle, statuses[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					groupId, urlTitle, StringUtil.merge(statuses)
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				groupId, urlTitle, StringUtil.merge(statuses), start, end,
				orderByComparator
			};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				_finderPathWithPaginationFindByG_UT_ST, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if ((groupId != columnEntry.getGroupId()) ||
						!urlTitle.equals(columnEntry.getUrlTitle()) ||
						!ArrayUtil.contains(
							statuses, columnEntry.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
			}

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_G_UT_ST_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindUrlTitle) {
					queryPos.add(urlTitle);
				}

				list = (List<ColumnEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByG_UT_ST, finderArgs,
						list);
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
	 * Removes all the column entries where groupId = &#63; and urlTitle = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 */
	@Override
	public void removeByG_UT_ST(long groupId, String urlTitle, int status) {
		for (ColumnEntry columnEntry :
				findByG_UT_ST(
					groupId, urlTitle, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(columnEntry);
		}
	}

	/**
	 * Returns the number of column entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching column entries
	 */
	@Override
	public int countByG_UT_ST(long groupId, String urlTitle, int status) {
		urlTitle = Objects.toString(urlTitle, "");

		FinderPath finderPath = _finderPathCountByG_UT_ST;

		Object[] finderArgs = new Object[] {groupId, urlTitle, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
			}

			sb.append(_FINDER_COLUMN_G_UT_ST_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindUrlTitle) {
					queryPos.add(urlTitle);
				}

				queryPos.add(status);

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

	/**
	 * Returns the number of column entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching column entries
	 */
	@Override
	public int countByG_UT_ST(long groupId, String urlTitle, int[] statuses) {
		urlTitle = Objects.toString(urlTitle, "");

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		Object[] finderArgs = new Object[] {
			groupId, urlTitle, StringUtil.merge(statuses)
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByG_UT_ST, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
			}

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_G_UT_ST_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindUrlTitle) {
					queryPos.add(urlTitle);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByG_UT_ST, finderArgs, count);
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

	/**
	 * Returns the number of column entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching column entries that the user has permission to view
	 */
	@Override
	public int filterCountByG_UT_ST(long groupId, String urlTitle, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_UT_ST(groupId, urlTitle, status);
		}

		urlTitle = Objects.toString(urlTitle, "");

		StringBundler sb = new StringBundler(4);

		sb.append(_FILTER_SQL_COUNT_COLUMNENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

		boolean bindUrlTitle = false;

		if (urlTitle.isEmpty()) {
			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
		}
		else {
			bindUrlTitle = true;

			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
		}

		sb.append(_FINDER_COLUMN_G_UT_ST_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ColumnEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			if (bindUrlTitle) {
				queryPos.add(urlTitle);
			}

			queryPos.add(status);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of column entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching column entries that the user has permission to view
	 */
	@Override
	public int filterCountByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_UT_ST(groupId, urlTitle, statuses);
		}

		urlTitle = Objects.toString(urlTitle, "");

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		StringBundler sb = new StringBundler();

		sb.append(_FILTER_SQL_COUNT_COLUMNENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

		boolean bindUrlTitle = false;

		if (urlTitle.isEmpty()) {
			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
		}
		else {
			bindUrlTitle = true;

			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
		}

		if (statuses.length > 0) {
			sb.append("(");

			sb.append(_FINDER_COLUMN_G_UT_ST_STATUS_7);

			sb.append(StringUtil.merge(statuses));

			sb.append(")");

			sb.append(")");
		}

		sb.setStringAt(
			removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ColumnEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			if (bindUrlTitle) {
				queryPos.add(urlTitle);
			}

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_UT_ST_GROUPID_2 =
		"columnEntry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_UT_ST_URLTITLE_2 =
		"columnEntry.urlTitle = ? AND ";

	private static final String _FINDER_COLUMN_G_UT_ST_URLTITLE_3 =
		"(columnEntry.urlTitle IS NULL OR columnEntry.urlTitle = '') AND ";

	private static final String _FINDER_COLUMN_G_UT_ST_STATUS_2 =
		"columnEntry.status = ?";

	private static final String _FINDER_COLUMN_G_UT_ST_STATUS_7 =
		"columnEntry.status IN (";

	private FinderPath _finderPathFetchByG_UT;
	private FinderPath _finderPathCountByG_UT;

	/**
	 * Returns the column entry where groupId = &#63; and urlTitle = &#63; or throws a <code>NoSuchColumnEntryException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByG_UT(long groupId, String urlTitle)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByG_UT(groupId, urlTitle);

		if (columnEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("groupId=");
			sb.append(groupId);

			sb.append(", urlTitle=");
			sb.append(urlTitle);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchColumnEntryException(sb.toString());
		}

		return columnEntry;
	}

	/**
	 * Returns the column entry where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByG_UT(long groupId, String urlTitle) {
		return fetchByG_UT(groupId, urlTitle, true);
	}

	/**
	 * Returns the column entry where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByG_UT(
		long groupId, String urlTitle, boolean useFinderCache) {

		urlTitle = Objects.toString(urlTitle, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId, urlTitle};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByG_UT, finderArgs);
		}

		if (result instanceof ColumnEntry) {
			ColumnEntry columnEntry = (ColumnEntry)result;

			if ((groupId != columnEntry.getGroupId()) ||
				!Objects.equals(urlTitle, columnEntry.getUrlTitle())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_UT_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_UT_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				sb.append(_FINDER_COLUMN_G_UT_URLTITLE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindUrlTitle) {
					queryPos.add(urlTitle);
				}

				List<ColumnEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByG_UT, finderArgs, list);
					}
				}
				else {
					ColumnEntry columnEntry = list.get(0);

					result = columnEntry;

					cacheResult(columnEntry);
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
			return (ColumnEntry)result;
		}
	}

	/**
	 * Removes the column entry where groupId = &#63; and urlTitle = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the column entry that was removed
	 */
	@Override
	public ColumnEntry removeByG_UT(long groupId, String urlTitle)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = findByG_UT(groupId, urlTitle);

		return remove(columnEntry);
	}

	/**
	 * Returns the number of column entries where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the number of matching column entries
	 */
	@Override
	public int countByG_UT(long groupId, String urlTitle) {
		urlTitle = Objects.toString(urlTitle, "");

		FinderPath finderPath = _finderPathCountByG_UT;

		Object[] finderArgs = new Object[] {groupId, urlTitle};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_UT_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_UT_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				sb.append(_FINDER_COLUMN_G_UT_URLTITLE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindUrlTitle) {
					queryPos.add(urlTitle);
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

	private static final String _FINDER_COLUMN_G_UT_GROUPID_2 =
		"columnEntry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_UT_URLTITLE_2 =
		"columnEntry.urlTitle = ?";

	private static final String _FINDER_COLUMN_G_UT_URLTITLE_3 =
		"(columnEntry.urlTitle IS NULL OR columnEntry.urlTitle = '')";

	private FinderPath _finderPathFetchByURLTitle;
	private FinderPath _finderPathCountByURLTitle;

	/**
	 * Returns the column entry where urlTitle = &#63; or throws a <code>NoSuchColumnEntryException</code> if it could not be found.
	 *
	 * @param urlTitle the url title
	 * @return the matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByURLTitle(String urlTitle)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByURLTitle(urlTitle);

		if (columnEntry == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("urlTitle=");
			sb.append(urlTitle);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchColumnEntryException(sb.toString());
		}

		return columnEntry;
	}

	/**
	 * Returns the column entry where urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param urlTitle the url title
	 * @return the matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByURLTitle(String urlTitle) {
		return fetchByURLTitle(urlTitle, true);
	}

	/**
	 * Returns the column entry where urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByURLTitle(
		String urlTitle, boolean useFinderCache) {

		urlTitle = Objects.toString(urlTitle, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {urlTitle};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByURLTitle, finderArgs);
		}

		if (result instanceof ColumnEntry) {
			ColumnEntry columnEntry = (ColumnEntry)result;

			if (!Objects.equals(urlTitle, columnEntry.getUrlTitle())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				sb.append(_FINDER_COLUMN_URLTITLE_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				sb.append(_FINDER_COLUMN_URLTITLE_URLTITLE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUrlTitle) {
					queryPos.add(urlTitle);
				}

				List<ColumnEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByURLTitle, finderArgs, list);
					}
				}
				else {
					ColumnEntry columnEntry = list.get(0);

					result = columnEntry;

					cacheResult(columnEntry);
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
			return (ColumnEntry)result;
		}
	}

	/**
	 * Removes the column entry where urlTitle = &#63; from the database.
	 *
	 * @param urlTitle the url title
	 * @return the column entry that was removed
	 */
	@Override
	public ColumnEntry removeByURLTitle(String urlTitle)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = findByURLTitle(urlTitle);

		return remove(columnEntry);
	}

	/**
	 * Returns the number of column entries where urlTitle = &#63;.
	 *
	 * @param urlTitle the url title
	 * @return the number of matching column entries
	 */
	@Override
	public int countByURLTitle(String urlTitle) {
		urlTitle = Objects.toString(urlTitle, "");

		FinderPath finderPath = _finderPathCountByURLTitle;

		Object[] finderArgs = new Object[] {urlTitle};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				sb.append(_FINDER_COLUMN_URLTITLE_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				sb.append(_FINDER_COLUMN_URLTITLE_URLTITLE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUrlTitle) {
					queryPos.add(urlTitle);
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

	private static final String _FINDER_COLUMN_URLTITLE_URLTITLE_2 =
		"columnEntry.urlTitle = ?";

	private static final String _FINDER_COLUMN_URLTITLE_URLTITLE_3 =
		"(columnEntry.urlTitle IS NULL OR columnEntry.urlTitle = '')";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the column entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if (groupId != columnEntry.getGroupId()) {
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

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<ColumnEntry>)QueryUtil.list(
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
	 * Returns the first column entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByGroupId_First(
			long groupId, OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByGroupId_First(
			groupId, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the first column entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByGroupId_First(
		long groupId, OrderByComparator<ColumnEntry> orderByComparator) {

		List<ColumnEntry> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last column entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByGroupId_Last(
			long groupId, OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the last column entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByGroupId_Last(
		long groupId, OrderByComparator<ColumnEntry> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ColumnEntry> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where groupId = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] findByGroupId_PrevAndNext(
			long columnEntryId, long groupId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, columnEntry, groupId, orderByComparator, true);

			array[1] = columnEntry;

			array[2] = getByGroupId_PrevAndNext(
				session, columnEntry, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ColumnEntry getByGroupId_PrevAndNext(
		Session session, ColumnEntry columnEntry, long groupId,
		OrderByComparator<ColumnEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the column entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByGroupId(
		long groupId, int start, int end) {

		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				3 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_COLUMNENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ColumnEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, ColumnEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, ColumnEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			return (List<ColumnEntry>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set of column entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] filterFindByGroupId_PrevAndNext(
			long columnEntryId, long groupId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(
				columnEntryId, groupId, orderByComparator);
		}

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(
				session, columnEntry, groupId, orderByComparator, true);

			array[1] = columnEntry;

			array[2] = filterGetByGroupId_PrevAndNext(
				session, columnEntry, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ColumnEntry filterGetByGroupId_PrevAndNext(
		Session session, ColumnEntry columnEntry, long groupId,
		OrderByComparator<ColumnEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_COLUMNENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ColumnEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, ColumnEntryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, ColumnEntryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the column entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (ColumnEntry columnEntry :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(columnEntry);
		}
	}

	/**
	 * Returns the number of column entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching column entries
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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

	/**
	 * Returns the number of column entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching column entries that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler sb = new StringBundler(2);

		sb.append(_FILTER_SQL_COUNT_COLUMNENTRY_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ColumnEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"columnEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUserIdGroupId;
	private FinderPath _finderPathWithoutPaginationFindByUserIdGroupId;
	private FinderPath _finderPathCountByUserIdGroupId;

	/**
	 * Returns all the column entries where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByUserIdGroupId(long userId, long groupId) {
		return findByUserIdGroupId(
			userId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end) {

		return findByUserIdGroupId(userId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByUserIdGroupId(
			userId, groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserIdGroupId;
				finderArgs = new Object[] {userId, groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserIdGroupId;
			finderArgs = new Object[] {
				userId, groupId, start, end, orderByComparator
			};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if ((userId != columnEntry.getUserId()) ||
						(groupId != columnEntry.getGroupId())) {

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

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

			sb.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(groupId);

				list = (List<ColumnEntry>)QueryUtil.list(
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
	 * Returns the first column entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByUserIdGroupId_First(
			long userId, long groupId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByUserIdGroupId_First(
			userId, groupId, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the first column entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByUserIdGroupId_First(
		long userId, long groupId,
		OrderByComparator<ColumnEntry> orderByComparator) {

		List<ColumnEntry> list = findByUserIdGroupId(
			userId, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last column entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByUserIdGroupId_Last(
			long userId, long groupId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByUserIdGroupId_Last(
			userId, groupId, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the last column entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByUserIdGroupId_Last(
		long userId, long groupId,
		OrderByComparator<ColumnEntry> orderByComparator) {

		int count = countByUserIdGroupId(userId, groupId);

		if (count == 0) {
			return null;
		}

		List<ColumnEntry> list = findByUserIdGroupId(
			userId, groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] findByUserIdGroupId_PrevAndNext(
			long columnEntryId, long userId, long groupId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = getByUserIdGroupId_PrevAndNext(
				session, columnEntry, userId, groupId, orderByComparator, true);

			array[1] = columnEntry;

			array[2] = getByUserIdGroupId_PrevAndNext(
				session, columnEntry, userId, groupId, orderByComparator,
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

	protected ColumnEntry getByUserIdGroupId_PrevAndNext(
		Session session, ColumnEntry columnEntry, long userId, long groupId,
		OrderByComparator<ColumnEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

		sb.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		sb.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

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
			sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the column entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByUserIdGroupId(
		long userId, long groupId) {

		return filterFindByUserIdGroupId(
			userId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end) {

		return filterFindByUserIdGroupId(userId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries that the user has permissions to view where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries that the user has permission to view
	 */
	@Override
	public List<ColumnEntry> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByUserIdGroupId(
				userId, groupId, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_COLUMNENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		sb.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ColumnEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, ColumnEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, ColumnEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(userId);

			queryPos.add(groupId);

			return (List<ColumnEntry>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set of column entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] filterFindByUserIdGroupId_PrevAndNext(
			long columnEntryId, long userId, long groupId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByUserIdGroupId_PrevAndNext(
				columnEntryId, userId, groupId, orderByComparator);
		}

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = filterGetByUserIdGroupId_PrevAndNext(
				session, columnEntry, userId, groupId, orderByComparator, true);

			array[1] = columnEntry;

			array[2] = filterGetByUserIdGroupId_PrevAndNext(
				session, columnEntry, userId, groupId, orderByComparator,
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

	protected ColumnEntry filterGetByUserIdGroupId_PrevAndNext(
		Session session, ColumnEntry columnEntry, long userId, long groupId,
		OrderByComparator<ColumnEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_COLUMNENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		sb.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ColumnEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, ColumnEntryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, ColumnEntryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(userId);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the column entries where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 */
	@Override
	public void removeByUserIdGroupId(long userId, long groupId) {
		for (ColumnEntry columnEntry :
				findByUserIdGroupId(
					userId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(columnEntry);
		}
	}

	/**
	 * Returns the number of column entries where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching column entries
	 */
	@Override
	public int countByUserIdGroupId(long userId, long groupId) {
		FinderPath finderPath = _finderPathCountByUserIdGroupId;

		Object[] finderArgs = new Object[] {userId, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

			sb.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	/**
	 * Returns the number of column entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching column entries that the user has permission to view
	 */
	@Override
	public int filterCountByUserIdGroupId(long userId, long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByUserIdGroupId(userId, groupId);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_COLUMNENTRY_WHERE);

		sb.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		sb.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ColumnEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(userId);

			queryPos.add(groupId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_USERIDGROUPID_USERID_2 =
		"columnEntry.userId = ? AND ";

	private static final String _FINDER_COLUMN_USERIDGROUPID_GROUPID_2 =
		"columnEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the column entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByUserId(
		long userId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByUserId(
		long userId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if (userId != columnEntry.getUserId()) {
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

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<ColumnEntry>)QueryUtil.list(
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
	 * Returns the first column entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByUserId_First(
			long userId, OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByUserId_First(
			userId, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the first column entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByUserId_First(
		long userId, OrderByComparator<ColumnEntry> orderByComparator) {

		List<ColumnEntry> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last column entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByUserId_Last(
			long userId, OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByUserId_Last(userId, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the last column entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByUserId_Last(
		long userId, OrderByComparator<ColumnEntry> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<ColumnEntry> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where userId = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] findByUserId_PrevAndNext(
			long columnEntryId, long userId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, columnEntry, userId, orderByComparator, true);

			array[1] = columnEntry;

			array[2] = getByUserId_PrevAndNext(
				session, columnEntry, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ColumnEntry getByUserId_PrevAndNext(
		Session session, ColumnEntry columnEntry, long userId,
		OrderByComparator<ColumnEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

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
			sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the column entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (ColumnEntry columnEntry :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(columnEntry);
		}
	}

	/**
	 * Returns the number of column entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching column entries
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"columnEntry.userId = ?";

	private FinderPath _finderPathWithPaginationFindByCompanyId;
	private FinderPath _finderPathWithoutPaginationFindByCompanyId;
	private FinderPath _finderPathCountByCompanyId;

	/**
	 * Returns all the column entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByCompanyId(long companyId) {
		return findByCompanyId(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByCompanyId(
		long companyId, int start, int end) {

		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByCompanyId(companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCompanyId;
				finderArgs = new Object[] {companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCompanyId;
			finderArgs = new Object[] {
				companyId, start, end, orderByComparator
			};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if (companyId != columnEntry.getCompanyId()) {
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

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<ColumnEntry>)QueryUtil.list(
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
	 * Returns the first column entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByCompanyId_First(
			long companyId, OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByCompanyId_First(
			companyId, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the first column entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByCompanyId_First(
		long companyId, OrderByComparator<ColumnEntry> orderByComparator) {

		List<ColumnEntry> list = findByCompanyId(
			companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last column entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByCompanyId_Last(
			long companyId, OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByCompanyId_Last(
			companyId, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the last column entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByCompanyId_Last(
		long companyId, OrderByComparator<ColumnEntry> orderByComparator) {

		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<ColumnEntry> list = findByCompanyId(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where companyId = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] findByCompanyId_PrevAndNext(
			long columnEntryId, long companyId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = getByCompanyId_PrevAndNext(
				session, columnEntry, companyId, orderByComparator, true);

			array[1] = columnEntry;

			array[2] = getByCompanyId_PrevAndNext(
				session, columnEntry, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ColumnEntry getByCompanyId_PrevAndNext(
		Session session, ColumnEntry columnEntry, long companyId,
		OrderByComparator<ColumnEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

		sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
			sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the column entries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (ColumnEntry columnEntry :
				findByCompanyId(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(columnEntry);
		}
	}

	/**
	 * Returns the number of column entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching column entries
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = _finderPathCountByCompanyId;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 =
		"columnEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByColumnEntryId;
	private FinderPath _finderPathWithoutPaginationFindByColumnEntryId;
	private FinderPath _finderPathCountByColumnEntryId;

	/**
	 * Returns all the column entries where columnEntryId = &#63;.
	 *
	 * @param columnEntryId the column entry ID
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByColumnEntryId(long columnEntryId) {
		return findByColumnEntryId(
			columnEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries where columnEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnEntryId the column entry ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByColumnEntryId(
		long columnEntryId, int start, int end) {

		return findByColumnEntryId(columnEntryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where columnEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnEntryId the column entry ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByColumnEntryId(
		long columnEntryId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByColumnEntryId(
			columnEntryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where columnEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnEntryId the column entry ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByColumnEntryId(
		long columnEntryId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByColumnEntryId;
				finderArgs = new Object[] {columnEntryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByColumnEntryId;
			finderArgs = new Object[] {
				columnEntryId, start, end, orderByComparator
			};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if (columnEntryId != columnEntry.getColumnEntryId()) {
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

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_COLUMNENTRYID_COLUMNENTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(columnEntryId);

				list = (List<ColumnEntry>)QueryUtil.list(
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
	 * Returns the first column entry in the ordered set where columnEntryId = &#63;.
	 *
	 * @param columnEntryId the column entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByColumnEntryId_First(
			long columnEntryId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByColumnEntryId_First(
			columnEntryId, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("columnEntryId=");
		sb.append(columnEntryId);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the first column entry in the ordered set where columnEntryId = &#63;.
	 *
	 * @param columnEntryId the column entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByColumnEntryId_First(
		long columnEntryId, OrderByComparator<ColumnEntry> orderByComparator) {

		List<ColumnEntry> list = findByColumnEntryId(
			columnEntryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last column entry in the ordered set where columnEntryId = &#63;.
	 *
	 * @param columnEntryId the column entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByColumnEntryId_Last(
			long columnEntryId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByColumnEntryId_Last(
			columnEntryId, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("columnEntryId=");
		sb.append(columnEntryId);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the last column entry in the ordered set where columnEntryId = &#63;.
	 *
	 * @param columnEntryId the column entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByColumnEntryId_Last(
		long columnEntryId, OrderByComparator<ColumnEntry> orderByComparator) {

		int count = countByColumnEntryId(columnEntryId);

		if (count == 0) {
			return null;
		}

		List<ColumnEntry> list = findByColumnEntryId(
			columnEntryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the column entries where columnEntryId = &#63; from the database.
	 *
	 * @param columnEntryId the column entry ID
	 */
	@Override
	public void removeByColumnEntryId(long columnEntryId) {
		for (ColumnEntry columnEntry :
				findByColumnEntryId(
					columnEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(columnEntry);
		}
	}

	/**
	 * Returns the number of column entries where columnEntryId = &#63;.
	 *
	 * @param columnEntryId the column entry ID
	 * @return the number of matching column entries
	 */
	@Override
	public int countByColumnEntryId(long columnEntryId) {
		FinderPath finderPath = _finderPathCountByColumnEntryId;

		Object[] finderArgs = new Object[] {columnEntryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_COLUMNENTRYID_COLUMNENTRYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(columnEntryId);

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

	private static final String _FINDER_COLUMN_COLUMNENTRYID_COLUMNENTRYID_2 =
		"columnEntry.columnEntryId = ?";

	private FinderPath _finderPathWithPaginationFindByColumnType;
	private FinderPath _finderPathWithoutPaginationFindByColumnType;
	private FinderPath _finderPathCountByColumnType;

	/**
	 * Returns all the column entries where columnType = &#63;.
	 *
	 * @param columnType the column type
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByColumnType(String columnType) {
		return findByColumnType(
			columnType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries where columnType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnType the column type
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByColumnType(
		String columnType, int start, int end) {

		return findByColumnType(columnType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where columnType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnType the column type
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByColumnType(
		String columnType, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByColumnType(
			columnType, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where columnType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnType the column type
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByColumnType(
		String columnType, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		columnType = Objects.toString(columnType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByColumnType;
				finderArgs = new Object[] {columnType};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByColumnType;
			finderArgs = new Object[] {
				columnType, start, end, orderByComparator
			};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if (!columnType.equals(columnEntry.getColumnType())) {
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

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			boolean bindColumnType = false;

			if (columnType.isEmpty()) {
				sb.append(_FINDER_COLUMN_COLUMNTYPE_COLUMNTYPE_3);
			}
			else {
				bindColumnType = true;

				sb.append(_FINDER_COLUMN_COLUMNTYPE_COLUMNTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindColumnType) {
					queryPos.add(columnType);
				}

				list = (List<ColumnEntry>)QueryUtil.list(
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
	 * Returns the first column entry in the ordered set where columnType = &#63;.
	 *
	 * @param columnType the column type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByColumnType_First(
			String columnType, OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByColumnType_First(
			columnType, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("columnType=");
		sb.append(columnType);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the first column entry in the ordered set where columnType = &#63;.
	 *
	 * @param columnType the column type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByColumnType_First(
		String columnType, OrderByComparator<ColumnEntry> orderByComparator) {

		List<ColumnEntry> list = findByColumnType(
			columnType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last column entry in the ordered set where columnType = &#63;.
	 *
	 * @param columnType the column type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByColumnType_Last(
			String columnType, OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByColumnType_Last(
			columnType, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("columnType=");
		sb.append(columnType);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the last column entry in the ordered set where columnType = &#63;.
	 *
	 * @param columnType the column type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByColumnType_Last(
		String columnType, OrderByComparator<ColumnEntry> orderByComparator) {

		int count = countByColumnType(columnType);

		if (count == 0) {
			return null;
		}

		List<ColumnEntry> list = findByColumnType(
			columnType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where columnType = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param columnType the column type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] findByColumnType_PrevAndNext(
			long columnEntryId, String columnType,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		columnType = Objects.toString(columnType, "");

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = getByColumnType_PrevAndNext(
				session, columnEntry, columnType, orderByComparator, true);

			array[1] = columnEntry;

			array[2] = getByColumnType_PrevAndNext(
				session, columnEntry, columnType, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ColumnEntry getByColumnType_PrevAndNext(
		Session session, ColumnEntry columnEntry, String columnType,
		OrderByComparator<ColumnEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

		boolean bindColumnType = false;

		if (columnType.isEmpty()) {
			sb.append(_FINDER_COLUMN_COLUMNTYPE_COLUMNTYPE_3);
		}
		else {
			bindColumnType = true;

			sb.append(_FINDER_COLUMN_COLUMNTYPE_COLUMNTYPE_2);
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
			sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindColumnType) {
			queryPos.add(columnType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the column entries where columnType = &#63; from the database.
	 *
	 * @param columnType the column type
	 */
	@Override
	public void removeByColumnType(String columnType) {
		for (ColumnEntry columnEntry :
				findByColumnType(
					columnType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(columnEntry);
		}
	}

	/**
	 * Returns the number of column entries where columnType = &#63;.
	 *
	 * @param columnType the column type
	 * @return the number of matching column entries
	 */
	@Override
	public int countByColumnType(String columnType) {
		columnType = Objects.toString(columnType, "");

		FinderPath finderPath = _finderPathCountByColumnType;

		Object[] finderArgs = new Object[] {columnType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			boolean bindColumnType = false;

			if (columnType.isEmpty()) {
				sb.append(_FINDER_COLUMN_COLUMNTYPE_COLUMNTYPE_3);
			}
			else {
				bindColumnType = true;

				sb.append(_FINDER_COLUMN_COLUMNTYPE_COLUMNTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindColumnType) {
					queryPos.add(columnType);
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

	private static final String _FINDER_COLUMN_COLUMNTYPE_COLUMNTYPE_2 =
		"columnEntry.columnType = ?";

	private static final String _FINDER_COLUMN_COLUMNTYPE_COLUMNTYPE_3 =
		"(columnEntry.columnType IS NULL OR columnEntry.columnType = '')";

	private FinderPath _finderPathWithPaginationFindByColumnName;
	private FinderPath _finderPathWithoutPaginationFindByColumnName;
	private FinderPath _finderPathCountByColumnName;

	/**
	 * Returns all the column entries where columnName = &#63;.
	 *
	 * @param columnName the column name
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByColumnName(String columnName) {
		return findByColumnName(
			columnName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries where columnName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnName the column name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByColumnName(
		String columnName, int start, int end) {

		return findByColumnName(columnName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where columnName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnName the column name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByColumnName(
		String columnName, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByColumnName(
			columnName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where columnName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnName the column name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByColumnName(
		String columnName, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		columnName = Objects.toString(columnName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByColumnName;
				finderArgs = new Object[] {columnName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByColumnName;
			finderArgs = new Object[] {
				columnName, start, end, orderByComparator
			};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if (!columnName.equals(columnEntry.getColumnName())) {
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

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			boolean bindColumnName = false;

			if (columnName.isEmpty()) {
				sb.append(_FINDER_COLUMN_COLUMNNAME_COLUMNNAME_3);
			}
			else {
				bindColumnName = true;

				sb.append(_FINDER_COLUMN_COLUMNNAME_COLUMNNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindColumnName) {
					queryPos.add(columnName);
				}

				list = (List<ColumnEntry>)QueryUtil.list(
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
	 * Returns the first column entry in the ordered set where columnName = &#63;.
	 *
	 * @param columnName the column name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByColumnName_First(
			String columnName, OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByColumnName_First(
			columnName, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("columnName=");
		sb.append(columnName);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the first column entry in the ordered set where columnName = &#63;.
	 *
	 * @param columnName the column name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByColumnName_First(
		String columnName, OrderByComparator<ColumnEntry> orderByComparator) {

		List<ColumnEntry> list = findByColumnName(
			columnName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last column entry in the ordered set where columnName = &#63;.
	 *
	 * @param columnName the column name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByColumnName_Last(
			String columnName, OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByColumnName_Last(
			columnName, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("columnName=");
		sb.append(columnName);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the last column entry in the ordered set where columnName = &#63;.
	 *
	 * @param columnName the column name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByColumnName_Last(
		String columnName, OrderByComparator<ColumnEntry> orderByComparator) {

		int count = countByColumnName(columnName);

		if (count == 0) {
			return null;
		}

		List<ColumnEntry> list = findByColumnName(
			columnName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where columnName = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param columnName the column name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] findByColumnName_PrevAndNext(
			long columnEntryId, String columnName,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		columnName = Objects.toString(columnName, "");

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = getByColumnName_PrevAndNext(
				session, columnEntry, columnName, orderByComparator, true);

			array[1] = columnEntry;

			array[2] = getByColumnName_PrevAndNext(
				session, columnEntry, columnName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ColumnEntry getByColumnName_PrevAndNext(
		Session session, ColumnEntry columnEntry, String columnName,
		OrderByComparator<ColumnEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

		boolean bindColumnName = false;

		if (columnName.isEmpty()) {
			sb.append(_FINDER_COLUMN_COLUMNNAME_COLUMNNAME_3);
		}
		else {
			bindColumnName = true;

			sb.append(_FINDER_COLUMN_COLUMNNAME_COLUMNNAME_2);
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
			sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindColumnName) {
			queryPos.add(columnName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the column entries where columnName = &#63; from the database.
	 *
	 * @param columnName the column name
	 */
	@Override
	public void removeByColumnName(String columnName) {
		for (ColumnEntry columnEntry :
				findByColumnName(
					columnName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(columnEntry);
		}
	}

	/**
	 * Returns the number of column entries where columnName = &#63;.
	 *
	 * @param columnName the column name
	 * @return the number of matching column entries
	 */
	@Override
	public int countByColumnName(String columnName) {
		columnName = Objects.toString(columnName, "");

		FinderPath finderPath = _finderPathCountByColumnName;

		Object[] finderArgs = new Object[] {columnName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			boolean bindColumnName = false;

			if (columnName.isEmpty()) {
				sb.append(_FINDER_COLUMN_COLUMNNAME_COLUMNNAME_3);
			}
			else {
				bindColumnName = true;

				sb.append(_FINDER_COLUMN_COLUMNNAME_COLUMNNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindColumnName) {
					queryPos.add(columnName);
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

	private static final String _FINDER_COLUMN_COLUMNNAME_COLUMNNAME_2 =
		"columnEntry.columnName = ?";

	private static final String _FINDER_COLUMN_COLUMNNAME_COLUMNNAME_3 =
		"(columnEntry.columnName IS NULL OR columnEntry.columnName = '')";

	private FinderPath _finderPathWithPaginationFindByColumnFullName;
	private FinderPath _finderPathWithoutPaginationFindByColumnFullName;
	private FinderPath _finderPathCountByColumnFullName;

	/**
	 * Returns all the column entries where columnFullName = &#63;.
	 *
	 * @param columnFullName the column full name
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByColumnFullName(String columnFullName) {
		return findByColumnFullName(
			columnFullName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries where columnFullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnFullName the column full name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByColumnFullName(
		String columnFullName, int start, int end) {

		return findByColumnFullName(columnFullName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where columnFullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnFullName the column full name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByColumnFullName(
		String columnFullName, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByColumnFullName(
			columnFullName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where columnFullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param columnFullName the column full name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByColumnFullName(
		String columnFullName, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		columnFullName = Objects.toString(columnFullName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByColumnFullName;
				finderArgs = new Object[] {columnFullName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByColumnFullName;
			finderArgs = new Object[] {
				columnFullName, start, end, orderByComparator
			};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if (!columnFullName.equals(
							columnEntry.getColumnFullName())) {

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

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			boolean bindColumnFullName = false;

			if (columnFullName.isEmpty()) {
				sb.append(_FINDER_COLUMN_COLUMNFULLNAME_COLUMNFULLNAME_3);
			}
			else {
				bindColumnFullName = true;

				sb.append(_FINDER_COLUMN_COLUMNFULLNAME_COLUMNFULLNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindColumnFullName) {
					queryPos.add(columnFullName);
				}

				list = (List<ColumnEntry>)QueryUtil.list(
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
	 * Returns the first column entry in the ordered set where columnFullName = &#63;.
	 *
	 * @param columnFullName the column full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByColumnFullName_First(
			String columnFullName,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByColumnFullName_First(
			columnFullName, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("columnFullName=");
		sb.append(columnFullName);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the first column entry in the ordered set where columnFullName = &#63;.
	 *
	 * @param columnFullName the column full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByColumnFullName_First(
		String columnFullName,
		OrderByComparator<ColumnEntry> orderByComparator) {

		List<ColumnEntry> list = findByColumnFullName(
			columnFullName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last column entry in the ordered set where columnFullName = &#63;.
	 *
	 * @param columnFullName the column full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByColumnFullName_Last(
			String columnFullName,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByColumnFullName_Last(
			columnFullName, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("columnFullName=");
		sb.append(columnFullName);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the last column entry in the ordered set where columnFullName = &#63;.
	 *
	 * @param columnFullName the column full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByColumnFullName_Last(
		String columnFullName,
		OrderByComparator<ColumnEntry> orderByComparator) {

		int count = countByColumnFullName(columnFullName);

		if (count == 0) {
			return null;
		}

		List<ColumnEntry> list = findByColumnFullName(
			columnFullName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where columnFullName = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param columnFullName the column full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] findByColumnFullName_PrevAndNext(
			long columnEntryId, String columnFullName,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		columnFullName = Objects.toString(columnFullName, "");

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = getByColumnFullName_PrevAndNext(
				session, columnEntry, columnFullName, orderByComparator, true);

			array[1] = columnEntry;

			array[2] = getByColumnFullName_PrevAndNext(
				session, columnEntry, columnFullName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ColumnEntry getByColumnFullName_PrevAndNext(
		Session session, ColumnEntry columnEntry, String columnFullName,
		OrderByComparator<ColumnEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

		boolean bindColumnFullName = false;

		if (columnFullName.isEmpty()) {
			sb.append(_FINDER_COLUMN_COLUMNFULLNAME_COLUMNFULLNAME_3);
		}
		else {
			bindColumnFullName = true;

			sb.append(_FINDER_COLUMN_COLUMNFULLNAME_COLUMNFULLNAME_2);
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
			sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindColumnFullName) {
			queryPos.add(columnFullName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the column entries where columnFullName = &#63; from the database.
	 *
	 * @param columnFullName the column full name
	 */
	@Override
	public void removeByColumnFullName(String columnFullName) {
		for (ColumnEntry columnEntry :
				findByColumnFullName(
					columnFullName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(columnEntry);
		}
	}

	/**
	 * Returns the number of column entries where columnFullName = &#63;.
	 *
	 * @param columnFullName the column full name
	 * @return the number of matching column entries
	 */
	@Override
	public int countByColumnFullName(String columnFullName) {
		columnFullName = Objects.toString(columnFullName, "");

		FinderPath finderPath = _finderPathCountByColumnFullName;

		Object[] finderArgs = new Object[] {columnFullName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			boolean bindColumnFullName = false;

			if (columnFullName.isEmpty()) {
				sb.append(_FINDER_COLUMN_COLUMNFULLNAME_COLUMNFULLNAME_3);
			}
			else {
				bindColumnFullName = true;

				sb.append(_FINDER_COLUMN_COLUMNFULLNAME_COLUMNFULLNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindColumnFullName) {
					queryPos.add(columnFullName);
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

	private static final String _FINDER_COLUMN_COLUMNFULLNAME_COLUMNFULLNAME_2 =
		"columnEntry.columnFullName = ?";

	private static final String _FINDER_COLUMN_COLUMNFULLNAME_COLUMNFULLNAME_3 =
		"(columnEntry.columnFullName IS NULL OR columnEntry.columnFullName = '')";

	private FinderPath _finderPathWithPaginationFindByTableEntryId;
	private FinderPath _finderPathWithoutPaginationFindByTableEntryId;
	private FinderPath _finderPathCountByTableEntryId;

	/**
	 * Returns all the column entries where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByTableEntryId(long tableEntryId) {
		return findByTableEntryId(
			tableEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries where tableEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableEntryId the table entry ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByTableEntryId(
		long tableEntryId, int start, int end) {

		return findByTableEntryId(tableEntryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where tableEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableEntryId the table entry ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByTableEntryId(
		long tableEntryId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByTableEntryId(
			tableEntryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where tableEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableEntryId the table entry ID
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByTableEntryId(
		long tableEntryId, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTableEntryId;
				finderArgs = new Object[] {tableEntryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTableEntryId;
			finderArgs = new Object[] {
				tableEntryId, start, end, orderByComparator
			};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if (tableEntryId != columnEntry.getTableEntryId()) {
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

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_TABLEENTRYID_TABLEENTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tableEntryId);

				list = (List<ColumnEntry>)QueryUtil.list(
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
	 * Returns the first column entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByTableEntryId_First(
			long tableEntryId, OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByTableEntryId_First(
			tableEntryId, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tableEntryId=");
		sb.append(tableEntryId);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the first column entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByTableEntryId_First(
		long tableEntryId, OrderByComparator<ColumnEntry> orderByComparator) {

		List<ColumnEntry> list = findByTableEntryId(
			tableEntryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last column entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByTableEntryId_Last(
			long tableEntryId, OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByTableEntryId_Last(
			tableEntryId, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tableEntryId=");
		sb.append(tableEntryId);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the last column entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByTableEntryId_Last(
		long tableEntryId, OrderByComparator<ColumnEntry> orderByComparator) {

		int count = countByTableEntryId(tableEntryId);

		if (count == 0) {
			return null;
		}

		List<ColumnEntry> list = findByTableEntryId(
			tableEntryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] findByTableEntryId_PrevAndNext(
			long columnEntryId, long tableEntryId,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = getByTableEntryId_PrevAndNext(
				session, columnEntry, tableEntryId, orderByComparator, true);

			array[1] = columnEntry;

			array[2] = getByTableEntryId_PrevAndNext(
				session, columnEntry, tableEntryId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ColumnEntry getByTableEntryId_PrevAndNext(
		Session session, ColumnEntry columnEntry, long tableEntryId,
		OrderByComparator<ColumnEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

		sb.append(_FINDER_COLUMN_TABLEENTRYID_TABLEENTRYID_2);

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
			sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(tableEntryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the column entries where tableEntryId = &#63; from the database.
	 *
	 * @param tableEntryId the table entry ID
	 */
	@Override
	public void removeByTableEntryId(long tableEntryId) {
		for (ColumnEntry columnEntry :
				findByTableEntryId(
					tableEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(columnEntry);
		}
	}

	/**
	 * Returns the number of column entries where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @return the number of matching column entries
	 */
	@Override
	public int countByTableEntryId(long tableEntryId) {
		FinderPath finderPath = _finderPathCountByTableEntryId;

		Object[] finderArgs = new Object[] {tableEntryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_TABLEENTRYID_TABLEENTRYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tableEntryId);

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

	private static final String _FINDER_COLUMN_TABLEENTRYID_TABLEENTRYID_2 =
		"columnEntry.tableEntryId = ?";

	private FinderPath _finderPathWithPaginationFindBySystemName;
	private FinderPath _finderPathWithoutPaginationFindBySystemName;
	private FinderPath _finderPathCountBySystemName;

	/**
	 * Returns all the column entries where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findBySystemName(String systemName) {
		return findBySystemName(
			systemName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries where systemName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemName the system name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findBySystemName(
		String systemName, int start, int end) {

		return findBySystemName(systemName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where systemName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemName the system name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findBySystemName(
		String systemName, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findBySystemName(
			systemName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where systemName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemName the system name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findBySystemName(
		String systemName, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		systemName = Objects.toString(systemName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySystemName;
				finderArgs = new Object[] {systemName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySystemName;
			finderArgs = new Object[] {
				systemName, start, end, orderByComparator
			};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if (!systemName.equals(columnEntry.getSystemName())) {
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

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			boolean bindSystemName = false;

			if (systemName.isEmpty()) {
				sb.append(_FINDER_COLUMN_SYSTEMNAME_SYSTEMNAME_3);
			}
			else {
				bindSystemName = true;

				sb.append(_FINDER_COLUMN_SYSTEMNAME_SYSTEMNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSystemName) {
					queryPos.add(systemName);
				}

				list = (List<ColumnEntry>)QueryUtil.list(
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
	 * Returns the first column entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findBySystemName_First(
			String systemName, OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchBySystemName_First(
			systemName, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("systemName=");
		sb.append(systemName);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the first column entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchBySystemName_First(
		String systemName, OrderByComparator<ColumnEntry> orderByComparator) {

		List<ColumnEntry> list = findBySystemName(
			systemName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last column entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findBySystemName_Last(
			String systemName, OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchBySystemName_Last(
			systemName, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("systemName=");
		sb.append(systemName);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the last column entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchBySystemName_Last(
		String systemName, OrderByComparator<ColumnEntry> orderByComparator) {

		int count = countBySystemName(systemName);

		if (count == 0) {
			return null;
		}

		List<ColumnEntry> list = findBySystemName(
			systemName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where systemName = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] findBySystemName_PrevAndNext(
			long columnEntryId, String systemName,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		systemName = Objects.toString(systemName, "");

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = getBySystemName_PrevAndNext(
				session, columnEntry, systemName, orderByComparator, true);

			array[1] = columnEntry;

			array[2] = getBySystemName_PrevAndNext(
				session, columnEntry, systemName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ColumnEntry getBySystemName_PrevAndNext(
		Session session, ColumnEntry columnEntry, String systemName,
		OrderByComparator<ColumnEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

		boolean bindSystemName = false;

		if (systemName.isEmpty()) {
			sb.append(_FINDER_COLUMN_SYSTEMNAME_SYSTEMNAME_3);
		}
		else {
			bindSystemName = true;

			sb.append(_FINDER_COLUMN_SYSTEMNAME_SYSTEMNAME_2);
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
			sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindSystemName) {
			queryPos.add(systemName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the column entries where systemName = &#63; from the database.
	 *
	 * @param systemName the system name
	 */
	@Override
	public void removeBySystemName(String systemName) {
		for (ColumnEntry columnEntry :
				findBySystemName(
					systemName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(columnEntry);
		}
	}

	/**
	 * Returns the number of column entries where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @return the number of matching column entries
	 */
	@Override
	public int countBySystemName(String systemName) {
		systemName = Objects.toString(systemName, "");

		FinderPath finderPath = _finderPathCountBySystemName;

		Object[] finderArgs = new Object[] {systemName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			boolean bindSystemName = false;

			if (systemName.isEmpty()) {
				sb.append(_FINDER_COLUMN_SYSTEMNAME_SYSTEMNAME_3);
			}
			else {
				bindSystemName = true;

				sb.append(_FINDER_COLUMN_SYSTEMNAME_SYSTEMNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSystemName) {
					queryPos.add(systemName);
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

	private static final String _FINDER_COLUMN_SYSTEMNAME_SYSTEMNAME_2 =
		"columnEntry.systemName = ?";

	private static final String _FINDER_COLUMN_SYSTEMNAME_SYSTEMNAME_3 =
		"(columnEntry.systemName IS NULL OR columnEntry.systemName = '')";

	private FinderPath _finderPathWithPaginationFindByDatabaseName;
	private FinderPath _finderPathWithoutPaginationFindByDatabaseName;
	private FinderPath _finderPathCountByDatabaseName;

	/**
	 * Returns all the column entries where databaseName = &#63;.
	 *
	 * @param databaseName the database name
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByDatabaseName(String databaseName) {
		return findByDatabaseName(
			databaseName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries where databaseName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param databaseName the database name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByDatabaseName(
		String databaseName, int start, int end) {

		return findByDatabaseName(databaseName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where databaseName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param databaseName the database name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByDatabaseName(
		String databaseName, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByDatabaseName(
			databaseName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where databaseName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param databaseName the database name
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByDatabaseName(
		String databaseName, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		databaseName = Objects.toString(databaseName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDatabaseName;
				finderArgs = new Object[] {databaseName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDatabaseName;
			finderArgs = new Object[] {
				databaseName, start, end, orderByComparator
			};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if (!databaseName.equals(columnEntry.getDatabaseName())) {
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

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			boolean bindDatabaseName = false;

			if (databaseName.isEmpty()) {
				sb.append(_FINDER_COLUMN_DATABASENAME_DATABASENAME_3);
			}
			else {
				bindDatabaseName = true;

				sb.append(_FINDER_COLUMN_DATABASENAME_DATABASENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDatabaseName) {
					queryPos.add(databaseName);
				}

				list = (List<ColumnEntry>)QueryUtil.list(
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
	 * Returns the first column entry in the ordered set where databaseName = &#63;.
	 *
	 * @param databaseName the database name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByDatabaseName_First(
			String databaseName,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByDatabaseName_First(
			databaseName, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("databaseName=");
		sb.append(databaseName);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the first column entry in the ordered set where databaseName = &#63;.
	 *
	 * @param databaseName the database name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByDatabaseName_First(
		String databaseName, OrderByComparator<ColumnEntry> orderByComparator) {

		List<ColumnEntry> list = findByDatabaseName(
			databaseName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last column entry in the ordered set where databaseName = &#63;.
	 *
	 * @param databaseName the database name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByDatabaseName_Last(
			String databaseName,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByDatabaseName_Last(
			databaseName, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("databaseName=");
		sb.append(databaseName);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the last column entry in the ordered set where databaseName = &#63;.
	 *
	 * @param databaseName the database name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByDatabaseName_Last(
		String databaseName, OrderByComparator<ColumnEntry> orderByComparator) {

		int count = countByDatabaseName(databaseName);

		if (count == 0) {
			return null;
		}

		List<ColumnEntry> list = findByDatabaseName(
			databaseName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where databaseName = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param databaseName the database name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] findByDatabaseName_PrevAndNext(
			long columnEntryId, String databaseName,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		databaseName = Objects.toString(databaseName, "");

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = getByDatabaseName_PrevAndNext(
				session, columnEntry, databaseName, orderByComparator, true);

			array[1] = columnEntry;

			array[2] = getByDatabaseName_PrevAndNext(
				session, columnEntry, databaseName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ColumnEntry getByDatabaseName_PrevAndNext(
		Session session, ColumnEntry columnEntry, String databaseName,
		OrderByComparator<ColumnEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

		boolean bindDatabaseName = false;

		if (databaseName.isEmpty()) {
			sb.append(_FINDER_COLUMN_DATABASENAME_DATABASENAME_3);
		}
		else {
			bindDatabaseName = true;

			sb.append(_FINDER_COLUMN_DATABASENAME_DATABASENAME_2);
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
			sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDatabaseName) {
			queryPos.add(databaseName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the column entries where databaseName = &#63; from the database.
	 *
	 * @param databaseName the database name
	 */
	@Override
	public void removeByDatabaseName(String databaseName) {
		for (ColumnEntry columnEntry :
				findByDatabaseName(
					databaseName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(columnEntry);
		}
	}

	/**
	 * Returns the number of column entries where databaseName = &#63;.
	 *
	 * @param databaseName the database name
	 * @return the number of matching column entries
	 */
	@Override
	public int countByDatabaseName(String databaseName) {
		databaseName = Objects.toString(databaseName, "");

		FinderPath finderPath = _finderPathCountByDatabaseName;

		Object[] finderArgs = new Object[] {databaseName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			boolean bindDatabaseName = false;

			if (databaseName.isEmpty()) {
				sb.append(_FINDER_COLUMN_DATABASENAME_DATABASENAME_3);
			}
			else {
				bindDatabaseName = true;

				sb.append(_FINDER_COLUMN_DATABASENAME_DATABASENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDatabaseName) {
					queryPos.add(databaseName);
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

	private static final String _FINDER_COLUMN_DATABASENAME_DATABASENAME_2 =
		"columnEntry.databaseName = ?";

	private static final String _FINDER_COLUMN_DATABASENAME_DATABASENAME_3 =
		"(columnEntry.databaseName IS NULL OR columnEntry.databaseName = '')";

	private FinderPath _finderPathWithPaginationFindByIsActive;
	private FinderPath _finderPathWithoutPaginationFindByIsActive;
	private FinderPath _finderPathCountByIsActive;

	/**
	 * Returns all the column entries where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the matching column entries
	 */
	@Override
	public List<ColumnEntry> findByIsActive(boolean isActive) {
		return findByIsActive(
			isActive, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByIsActive(
		boolean isActive, int start, int end) {

		return findByIsActive(isActive, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByIsActive(
		boolean isActive, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator) {

		return findByIsActive(isActive, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column entries
	 */
	@Override
	public List<ColumnEntry> findByIsActive(
		boolean isActive, int start, int end,
		OrderByComparator<ColumnEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByIsActive;
				finderArgs = new Object[] {isActive};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIsActive;
			finderArgs = new Object[] {isActive, start, end, orderByComparator};
		}

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnEntry columnEntry : list) {
					if (isActive != columnEntry.isIsActive()) {
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

			sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_ISACTIVE_ISACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isActive);

				list = (List<ColumnEntry>)QueryUtil.list(
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
	 * Returns the first column entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByIsActive_First(
			boolean isActive, OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByIsActive_First(
			isActive, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isActive=");
		sb.append(isActive);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the first column entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByIsActive_First(
		boolean isActive, OrderByComparator<ColumnEntry> orderByComparator) {

		List<ColumnEntry> list = findByIsActive(
			isActive, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last column entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry
	 * @throws NoSuchColumnEntryException if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry findByIsActive_Last(
			boolean isActive, OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByIsActive_Last(
			isActive, orderByComparator);

		if (columnEntry != null) {
			return columnEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isActive=");
		sb.append(isActive);

		sb.append("}");

		throw new NoSuchColumnEntryException(sb.toString());
	}

	/**
	 * Returns the last column entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column entry, or <code>null</code> if a matching column entry could not be found
	 */
	@Override
	public ColumnEntry fetchByIsActive_Last(
		boolean isActive, OrderByComparator<ColumnEntry> orderByComparator) {

		int count = countByIsActive(isActive);

		if (count == 0) {
			return null;
		}

		List<ColumnEntry> list = findByIsActive(
			isActive, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the column entries before and after the current column entry in the ordered set where isActive = &#63;.
	 *
	 * @param columnEntryId the primary key of the current column entry
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry[] findByIsActive_PrevAndNext(
			long columnEntryId, boolean isActive,
			OrderByComparator<ColumnEntry> orderByComparator)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = findByPrimaryKey(columnEntryId);

		Session session = null;

		try {
			session = openSession();

			ColumnEntry[] array = new ColumnEntryImpl[3];

			array[0] = getByIsActive_PrevAndNext(
				session, columnEntry, isActive, orderByComparator, true);

			array[1] = columnEntry;

			array[2] = getByIsActive_PrevAndNext(
				session, columnEntry, isActive, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ColumnEntry getByIsActive_PrevAndNext(
		Session session, ColumnEntry columnEntry, boolean isActive,
		OrderByComparator<ColumnEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COLUMNENTRY_WHERE);

		sb.append(_FINDER_COLUMN_ISACTIVE_ISACTIVE_2);

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
			sb.append(ColumnEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isActive);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(columnEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ColumnEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the column entries where isActive = &#63; from the database.
	 *
	 * @param isActive the is active
	 */
	@Override
	public void removeByIsActive(boolean isActive) {
		for (ColumnEntry columnEntry :
				findByIsActive(
					isActive, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(columnEntry);
		}
	}

	/**
	 * Returns the number of column entries where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the number of matching column entries
	 */
	@Override
	public int countByIsActive(boolean isActive) {
		FinderPath finderPath = _finderPathCountByIsActive;

		Object[] finderArgs = new Object[] {isActive};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COLUMNENTRY_WHERE);

			sb.append(_FINDER_COLUMN_ISACTIVE_ISACTIVE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isActive);

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

	private static final String _FINDER_COLUMN_ISACTIVE_ISACTIVE_2 =
		"columnEntry.isActive = ?";

	public ColumnEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ColumnEntry.class);

		setModelImplClass(ColumnEntryImpl.class);
		setModelPKClass(long.class);

		setTable(ColumnEntryTable.INSTANCE);
	}

	/**
	 * Caches the column entry in the entity cache if it is enabled.
	 *
	 * @param columnEntry the column entry
	 */
	@Override
	public void cacheResult(ColumnEntry columnEntry) {
		entityCache.putResult(
			ColumnEntryImpl.class, columnEntry.getPrimaryKey(), columnEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {columnEntry.getUuid(), columnEntry.getGroupId()},
			columnEntry);

		finderCache.putResult(
			_finderPathFetchByG_UT,
			new Object[] {columnEntry.getGroupId(), columnEntry.getUrlTitle()},
			columnEntry);

		finderCache.putResult(
			_finderPathFetchByURLTitle,
			new Object[] {columnEntry.getUrlTitle()}, columnEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the column entries in the entity cache if it is enabled.
	 *
	 * @param columnEntries the column entries
	 */
	@Override
	public void cacheResult(List<ColumnEntry> columnEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (columnEntries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ColumnEntry columnEntry : columnEntries) {
			if (entityCache.getResult(
					ColumnEntryImpl.class, columnEntry.getPrimaryKey()) ==
						null) {

				cacheResult(columnEntry);
			}
		}
	}

	/**
	 * Clears the cache for all column entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ColumnEntryImpl.class);

		finderCache.clearCache(ColumnEntryImpl.class);
	}

	/**
	 * Clears the cache for the column entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ColumnEntry columnEntry) {
		entityCache.removeResult(ColumnEntryImpl.class, columnEntry);
	}

	@Override
	public void clearCache(List<ColumnEntry> columnEntries) {
		for (ColumnEntry columnEntry : columnEntries) {
			entityCache.removeResult(ColumnEntryImpl.class, columnEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ColumnEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ColumnEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ColumnEntryModelImpl columnEntryModelImpl) {

		Object[] args = new Object[] {
			columnEntryModelImpl.getUuid(), columnEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, columnEntryModelImpl);

		args = new Object[] {
			columnEntryModelImpl.getGroupId(),
			columnEntryModelImpl.getUrlTitle()
		};

		finderCache.putResult(_finderPathCountByG_UT, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByG_UT, args, columnEntryModelImpl);

		args = new Object[] {columnEntryModelImpl.getUrlTitle()};

		finderCache.putResult(
			_finderPathCountByURLTitle, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByURLTitle, args, columnEntryModelImpl);
	}

	/**
	 * Creates a new column entry with the primary key. Does not add the column entry to the database.
	 *
	 * @param columnEntryId the primary key for the new column entry
	 * @return the new column entry
	 */
	@Override
	public ColumnEntry create(long columnEntryId) {
		ColumnEntry columnEntry = new ColumnEntryImpl();

		columnEntry.setNew(true);
		columnEntry.setPrimaryKey(columnEntryId);

		String uuid = _portalUUID.generate();

		columnEntry.setUuid(uuid);

		columnEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return columnEntry;
	}

	/**
	 * Removes the column entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param columnEntryId the primary key of the column entry
	 * @return the column entry that was removed
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry remove(long columnEntryId)
		throws NoSuchColumnEntryException {

		return remove((Serializable)columnEntryId);
	}

	/**
	 * Removes the column entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the column entry
	 * @return the column entry that was removed
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry remove(Serializable primaryKey)
		throws NoSuchColumnEntryException {

		Session session = null;

		try {
			session = openSession();

			ColumnEntry columnEntry = (ColumnEntry)session.get(
				ColumnEntryImpl.class, primaryKey);

			if (columnEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchColumnEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(columnEntry);
		}
		catch (NoSuchColumnEntryException noSuchEntityException) {
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
	protected ColumnEntry removeImpl(ColumnEntry columnEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(columnEntry)) {
				columnEntry = (ColumnEntry)session.get(
					ColumnEntryImpl.class, columnEntry.getPrimaryKeyObj());
			}

			if (columnEntry != null) {
				session.delete(columnEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (columnEntry != null) {
			clearCache(columnEntry);
		}

		return columnEntry;
	}

	@Override
	public ColumnEntry updateImpl(ColumnEntry columnEntry) {
		boolean isNew = columnEntry.isNew();

		if (!(columnEntry instanceof ColumnEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(columnEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(columnEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in columnEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ColumnEntry implementation " +
					columnEntry.getClass());
		}

		ColumnEntryModelImpl columnEntryModelImpl =
			(ColumnEntryModelImpl)columnEntry;

		if (Validator.isNull(columnEntry.getUuid())) {
			String uuid = _portalUUID.generate();

			columnEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (columnEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				columnEntry.setCreateDate(date);
			}
			else {
				columnEntry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!columnEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				columnEntry.setModifiedDate(date);
			}
			else {
				columnEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(columnEntry);
			}
			else {
				columnEntry = (ColumnEntry)session.merge(columnEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ColumnEntryImpl.class, columnEntryModelImpl, false, true);

		cacheUniqueFindersCache(columnEntryModelImpl);

		if (isNew) {
			columnEntry.setNew(false);
		}

		columnEntry.resetOriginalValues();

		return columnEntry;
	}

	/**
	 * Returns the column entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the column entry
	 * @return the column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchColumnEntryException {

		ColumnEntry columnEntry = fetchByPrimaryKey(primaryKey);

		if (columnEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchColumnEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return columnEntry;
	}

	/**
	 * Returns the column entry with the primary key or throws a <code>NoSuchColumnEntryException</code> if it could not be found.
	 *
	 * @param columnEntryId the primary key of the column entry
	 * @return the column entry
	 * @throws NoSuchColumnEntryException if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry findByPrimaryKey(long columnEntryId)
		throws NoSuchColumnEntryException {

		return findByPrimaryKey((Serializable)columnEntryId);
	}

	/**
	 * Returns the column entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param columnEntryId the primary key of the column entry
	 * @return the column entry, or <code>null</code> if a column entry with the primary key could not be found
	 */
	@Override
	public ColumnEntry fetchByPrimaryKey(long columnEntryId) {
		return fetchByPrimaryKey((Serializable)columnEntryId);
	}

	/**
	 * Returns all the column entries.
	 *
	 * @return the column entries
	 */
	@Override
	public List<ColumnEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @return the range of column entries
	 */
	@Override
	public List<ColumnEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the column entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of column entries
	 */
	@Override
	public List<ColumnEntry> findAll(
		int start, int end, OrderByComparator<ColumnEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of column entries
	 * @param end the upper bound of the range of column entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of column entries
	 */
	@Override
	public List<ColumnEntry> findAll(
		int start, int end, OrderByComparator<ColumnEntry> orderByComparator,
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

		List<ColumnEntry> list = null;

		if (useFinderCache) {
			list = (List<ColumnEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COLUMNENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COLUMNENTRY;

				sql = sql.concat(ColumnEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ColumnEntry>)QueryUtil.list(
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
	 * Removes all the column entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ColumnEntry columnEntry : findAll()) {
			remove(columnEntry);
		}
	}

	/**
	 * Returns the number of column entries.
	 *
	 * @return the number of column entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COLUMNENTRY);

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
		return "columnEntryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COLUMNENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ColumnEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the column entry persistence.
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

		_finderPathWithPaginationFindByC_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"companyId", "status"}, true);

		_finderPathWithoutPaginationFindByC_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"companyId", "status"}, true);

		_finderPathCountByC_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"companyId", "status"}, false);

		_finderPathWithPaginationCountByC_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"companyId", "status"}, false);

		_finderPathWithPaginationFindByG_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "status"}, true);

		_finderPathWithoutPaginationFindByG_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"groupId", "status"}, true);

		_finderPathCountByG_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"groupId", "status"}, false);

		_finderPathWithPaginationCountByG_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"groupId", "status"}, false);

		_finderPathWithPaginationFindByC_U_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"companyId", "userId", "status"}, true);

		_finderPathWithoutPaginationFindByC_U_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			new String[] {"companyId", "userId", "status"}, true);

		_finderPathCountByC_U_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			new String[] {"companyId", "userId", "status"}, false);

		_finderPathWithPaginationCountByC_U_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			new String[] {"companyId", "userId", "status"}, false);

		_finderPathWithPaginationFindByG_U_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId", "userId", "status"}, true);

		_finderPathWithoutPaginationFindByG_U_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			new String[] {"groupId", "userId", "status"}, true);

		_finderPathCountByG_U_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			new String[] {"groupId", "userId", "status"}, false);

		_finderPathWithPaginationCountByG_U_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByG_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			new String[] {"groupId", "userId", "status"}, false);

		_finderPathWithPaginationFindByU_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"userId", "status"}, true);

		_finderPathWithoutPaginationFindByU_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"userId", "status"}, true);

		_finderPathCountByU_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"userId", "status"}, false);

		_finderPathWithPaginationCountByU_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByU_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"userId", "status"}, false);

		_finderPathWithPaginationFindByG_UT_ST = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_UT_ST",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId", "urlTitle", "status"}, true);

		_finderPathWithoutPaginationFindByG_UT_ST = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_UT_ST",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			},
			new String[] {"groupId", "urlTitle", "status"}, true);

		_finderPathCountByG_UT_ST = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_UT_ST",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			},
			new String[] {"groupId", "urlTitle", "status"}, false);

		_finderPathWithPaginationCountByG_UT_ST = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByG_UT_ST",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			},
			new String[] {"groupId", "urlTitle", "status"}, false);

		_finderPathFetchByG_UT = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByG_UT",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"groupId", "urlTitle"}, true);

		_finderPathCountByG_UT = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_UT",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"groupId", "urlTitle"}, false);

		_finderPathFetchByURLTitle = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByURLTitle",
			new String[] {String.class.getName()}, new String[] {"urlTitle"},
			true);

		_finderPathCountByURLTitle = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByURLTitle",
			new String[] {String.class.getName()}, new String[] {"urlTitle"},
			false);

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		_finderPathWithPaginationFindByUserIdGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"userId", "groupId"}, true);

		_finderPathWithoutPaginationFindByUserIdGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserIdGroupId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"userId", "groupId"}, true);

		_finderPathCountByUserIdGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserIdGroupId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"userId", "groupId"}, false);

		_finderPathWithPaginationFindByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId"}, true);

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_finderPathWithPaginationFindByCompanyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"companyId"}, true);

		_finderPathWithoutPaginationFindByCompanyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] {Long.class.getName()}, new String[] {"companyId"},
			true);

		_finderPathCountByCompanyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] {Long.class.getName()}, new String[] {"companyId"},
			false);

		_finderPathWithPaginationFindByColumnEntryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumnEntryId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"columnEntryId"}, true);

		_finderPathWithoutPaginationFindByColumnEntryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumnEntryId",
			new String[] {Long.class.getName()}, new String[] {"columnEntryId"},
			true);

		_finderPathCountByColumnEntryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumnEntryId",
			new String[] {Long.class.getName()}, new String[] {"columnEntryId"},
			false);

		_finderPathWithPaginationFindByColumnType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumnType",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"columnType"}, true);

		_finderPathWithoutPaginationFindByColumnType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumnType",
			new String[] {String.class.getName()}, new String[] {"columnType"},
			true);

		_finderPathCountByColumnType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumnType",
			new String[] {String.class.getName()}, new String[] {"columnType"},
			false);

		_finderPathWithPaginationFindByColumnName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumnName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"columnName"}, true);

		_finderPathWithoutPaginationFindByColumnName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumnName",
			new String[] {String.class.getName()}, new String[] {"columnName"},
			true);

		_finderPathCountByColumnName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumnName",
			new String[] {String.class.getName()}, new String[] {"columnName"},
			false);

		_finderPathWithPaginationFindByColumnFullName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumnFullName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"columnFullName"}, true);

		_finderPathWithoutPaginationFindByColumnFullName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumnFullName",
			new String[] {String.class.getName()},
			new String[] {"columnFullName"}, true);

		_finderPathCountByColumnFullName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumnFullName",
			new String[] {String.class.getName()},
			new String[] {"columnFullName"}, false);

		_finderPathWithPaginationFindByTableEntryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTableEntryId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"tableEntryId"}, true);

		_finderPathWithoutPaginationFindByTableEntryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTableEntryId",
			new String[] {Long.class.getName()}, new String[] {"tableEntryId"},
			true);

		_finderPathCountByTableEntryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTableEntryId",
			new String[] {Long.class.getName()}, new String[] {"tableEntryId"},
			false);

		_finderPathWithPaginationFindBySystemName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySystemName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"systemName"}, true);

		_finderPathWithoutPaginationFindBySystemName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySystemName",
			new String[] {String.class.getName()}, new String[] {"systemName"},
			true);

		_finderPathCountBySystemName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySystemName",
			new String[] {String.class.getName()}, new String[] {"systemName"},
			false);

		_finderPathWithPaginationFindByDatabaseName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDatabaseName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"databaseName"}, true);

		_finderPathWithoutPaginationFindByDatabaseName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDatabaseName",
			new String[] {String.class.getName()},
			new String[] {"databaseName"}, true);

		_finderPathCountByDatabaseName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDatabaseName",
			new String[] {String.class.getName()},
			new String[] {"databaseName"}, false);

		_finderPathWithPaginationFindByIsActive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsActive",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"isActive"}, true);

		_finderPathWithoutPaginationFindByIsActive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsActive",
			new String[] {Boolean.class.getName()}, new String[] {"isActive"},
			true);

		_finderPathCountByIsActive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsActive",
			new String[] {Boolean.class.getName()}, new String[] {"isActive"},
			false);

		_setColumnEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setColumnEntryUtilPersistence(null);

		entityCache.removeCache(ColumnEntryImpl.class.getName());
	}

	private void _setColumnEntryUtilPersistence(
		ColumnEntryPersistence columnEntryPersistence) {

		try {
			Field field = ColumnEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, columnEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = MetaCdsPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = MetaCdsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = MetaCdsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_COLUMNENTRY =
		"SELECT columnEntry FROM ColumnEntry columnEntry";

	private static final String _SQL_SELECT_COLUMNENTRY_WHERE =
		"SELECT columnEntry FROM ColumnEntry columnEntry WHERE ";

	private static final String _SQL_COUNT_COLUMNENTRY =
		"SELECT COUNT(columnEntry) FROM ColumnEntry columnEntry";

	private static final String _SQL_COUNT_COLUMNENTRY_WHERE =
		"SELECT COUNT(columnEntry) FROM ColumnEntry columnEntry WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"columnEntry.columnEntryId";

	private static final String _FILTER_SQL_SELECT_COLUMNENTRY_WHERE =
		"SELECT DISTINCT {columnEntry.*} FROM MetaCds_ColumnEntry columnEntry WHERE ";

	private static final String
		_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {MetaCds_ColumnEntry.*} FROM (SELECT DISTINCT columnEntry.columnEntryId FROM MetaCds_ColumnEntry columnEntry WHERE ";

	private static final String
		_FILTER_SQL_SELECT_COLUMNENTRY_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN MetaCds_ColumnEntry ON TEMP_TABLE.columnEntryId = MetaCds_ColumnEntry.columnEntryId";

	private static final String _FILTER_SQL_COUNT_COLUMNENTRY_WHERE =
		"SELECT COUNT(DISTINCT columnEntry.columnEntryId) AS COUNT_VALUE FROM MetaCds_ColumnEntry columnEntry WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "columnEntry";

	private static final String _FILTER_ENTITY_TABLE = "MetaCds_ColumnEntry";

	private static final String _ORDER_BY_ENTITY_ALIAS = "columnEntry.";

	private static final String _ORDER_BY_ENTITY_TABLE = "MetaCds_ColumnEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ColumnEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ColumnEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ColumnEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private ColumnEntryModelArgumentsResolver
		_columnEntryModelArgumentsResolver;

}