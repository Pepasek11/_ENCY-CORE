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

import cz.csob.ency.modules.apps.meta.cds.exception.NoSuchTableEntryException;
import cz.csob.ency.modules.apps.meta.cds.model.TableEntry;
import cz.csob.ency.modules.apps.meta.cds.model.TableEntryTable;
import cz.csob.ency.modules.apps.meta.cds.model.impl.TableEntryImpl;
import cz.csob.ency.modules.apps.meta.cds.model.impl.TableEntryModelImpl;
import cz.csob.ency.modules.apps.meta.cds.service.persistence.TableEntryPersistence;
import cz.csob.ency.modules.apps.meta.cds.service.persistence.TableEntryUtil;
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
 * The persistence implementation for the table entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author "Miroslav Čermák"
 * @generated
 */
@Component(service = {TableEntryPersistence.class, BasePersistence.class})
public class TableEntryPersistenceImpl
	extends BasePersistenceImpl<TableEntry> implements TableEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TableEntryUtil</code> to access the table entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TableEntryImpl.class.getName();

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
	 * Returns all the table entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
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

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if (!uuid.equals(tableEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Returns the first table entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByUuid_First(
			String uuid, OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByUuid_First(uuid, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the first table entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByUuid_First(
		String uuid, OrderByComparator<TableEntry> orderByComparator) {

		List<TableEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByUuid_Last(
			String uuid, OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the last table entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByUuid_Last(
		String uuid, OrderByComparator<TableEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TableEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where uuid = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] findByUuid_PrevAndNext(
			long tableEntryId, String uuid,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		uuid = Objects.toString(uuid, "");

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, tableEntry, uuid, orderByComparator, true);

			array[1] = tableEntry;

			array[2] = getByUuid_PrevAndNext(
				session, tableEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TableEntry getByUuid_PrevAndNext(
		Session session, TableEntry tableEntry, String uuid,
		OrderByComparator<TableEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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
			sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the table entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TableEntry tableEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tableEntry);
		}
	}

	/**
	 * Returns the number of table entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching table entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

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
		"tableEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(tableEntry.uuid IS NULL OR tableEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the table entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTableEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByUUID_G(uuid, groupId);

		if (tableEntry == null) {
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

			throw new NoSuchTableEntryException(sb.toString());
		}

		return tableEntry;
	}

	/**
	 * Returns the table entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the table entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByUUID_G(
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

		if (result instanceof TableEntry) {
			TableEntry tableEntry = (TableEntry)result;

			if (!Objects.equals(uuid, tableEntry.getUuid()) ||
				(groupId != tableEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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

				List<TableEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					TableEntry tableEntry = list.get(0);

					result = tableEntry;

					cacheResult(tableEntry);
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
			return (TableEntry)result;
		}
	}

	/**
	 * Removes the table entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the table entry that was removed
	 */
	@Override
	public TableEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = findByUUID_G(uuid, groupId);

		return remove(tableEntry);
	}

	/**
	 * Returns the number of table entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching table entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

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
		"tableEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(tableEntry.uuid IS NULL OR tableEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"tableEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the table entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
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

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if (!uuid.equals(tableEntry.getUuid()) ||
						(companyId != tableEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Returns the first table entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the first table entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TableEntry> orderByComparator) {

		List<TableEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the last table entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TableEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TableEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] findByUuid_C_PrevAndNext(
			long tableEntryId, String uuid, long companyId,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		uuid = Objects.toString(uuid, "");

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, tableEntry, uuid, companyId, orderByComparator, true);

			array[1] = tableEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, tableEntry, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TableEntry getByUuid_C_PrevAndNext(
		Session session, TableEntry tableEntry, String uuid, long companyId,
		OrderByComparator<TableEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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
			sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the table entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (TableEntry tableEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(tableEntry);
		}
	}

	/**
	 * Returns the number of table entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching table entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

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
		"tableEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(tableEntry.uuid IS NULL OR tableEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"tableEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByC_S;
	private FinderPath _finderPathWithoutPaginationFindByC_S;
	private FinderPath _finderPathCountByC_S;
	private FinderPath _finderPathWithPaginationCountByC_S;

	/**
	 * Returns all the table entries where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByC_S(long companyId, int status) {
		return findByC_S(
			companyId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByC_S(
		long companyId, int status, int start, int end) {

		return findByC_S(companyId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByC_S(
		long companyId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByC_S(
			companyId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByC_S(
		long companyId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
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

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if ((companyId != tableEntry.getCompanyId()) ||
						(status != tableEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_S_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(status);

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Returns the first table entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByC_S_First(
			long companyId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByC_S_First(
			companyId, status, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the first table entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByC_S_First(
		long companyId, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		List<TableEntry> list = findByC_S(
			companyId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByC_S_Last(
			long companyId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByC_S_Last(
			companyId, status, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the last table entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByC_S_Last(
		long companyId, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		int count = countByC_S(companyId, status);

		if (count == 0) {
			return null;
		}

		List<TableEntry> list = findByC_S(
			companyId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] findByC_S_PrevAndNext(
			long tableEntryId, long companyId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = getByC_S_PrevAndNext(
				session, tableEntry, companyId, status, orderByComparator,
				true);

			array[1] = tableEntry;

			array[2] = getByC_S_PrevAndNext(
				session, tableEntry, companyId, status, orderByComparator,
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

	protected TableEntry getByC_S_PrevAndNext(
		Session session, TableEntry tableEntry, long companyId, int status,
		OrderByComparator<TableEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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
			sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the table entries where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByC_S(long companyId, int[] statuses) {
		return findByC_S(
			companyId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByC_S(
		long companyId, int[] statuses, int start, int end) {

		return findByC_S(companyId, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByC_S(
		long companyId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByC_S(
			companyId, statuses, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where companyId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByC_S(
		long companyId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
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

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				_finderPathWithPaginationFindByC_S, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if ((companyId != tableEntry.getCompanyId()) ||
						!ArrayUtil.contains(statuses, tableEntry.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Removes all the table entries where companyId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 */
	@Override
	public void removeByC_S(long companyId, int status) {
		for (TableEntry tableEntry :
				findByC_S(
					companyId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(tableEntry);
		}
	}

	/**
	 * Returns the number of table entries where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching table entries
	 */
	@Override
	public int countByC_S(long companyId, int status) {
		FinderPath finderPath = _finderPathCountByC_S;

		Object[] finderArgs = new Object[] {companyId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

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
	 * Returns the number of table entries where companyId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @return the number of matching table entries
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

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

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
		"tableEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_S_STATUS_2 =
		"tableEntry.status = ?";

	private static final String _FINDER_COLUMN_C_S_STATUS_7 =
		"tableEntry.status IN (";

	private FinderPath _finderPathWithPaginationFindByG_S;
	private FinderPath _finderPathWithoutPaginationFindByG_S;
	private FinderPath _finderPathCountByG_S;
	private FinderPath _finderPathWithPaginationCountByG_S;

	/**
	 * Returns all the table entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByG_S(long groupId, int status) {
		return findByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByG_S(
		long groupId, int status, int start, int end) {

		return findByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByG_S(groupId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
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

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if ((groupId != tableEntry.getGroupId()) ||
						(status != tableEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Returns the first table entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByG_S_First(
			long groupId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByG_S_First(
			groupId, status, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the first table entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		List<TableEntry> list = findByG_S(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByG_S_Last(
			long groupId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByG_S_Last(
			groupId, status, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the last table entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		int count = countByG_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<TableEntry> list = findByG_S(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] findByG_S_PrevAndNext(
			long tableEntryId, long groupId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = getByG_S_PrevAndNext(
				session, tableEntry, groupId, status, orderByComparator, true);

			array[1] = tableEntry;

			array[2] = getByG_S_PrevAndNext(
				session, tableEntry, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TableEntry getByG_S_PrevAndNext(
		Session session, TableEntry tableEntry, long groupId, int status,
		OrderByComparator<TableEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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
			sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the table entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByG_S(long groupId, int status) {
		return filterFindByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return filterFindByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), TableEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, TableEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, TableEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(status);

			return (List<TableEntry>)QueryUtil.list(
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
	 * Returns the table entries before and after the current table entry in the ordered set of table entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] filterFindByG_S_PrevAndNext(
			long tableEntryId, long groupId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_PrevAndNext(
				tableEntryId, groupId, status, orderByComparator);
		}

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = filterGetByG_S_PrevAndNext(
				session, tableEntry, groupId, status, orderByComparator, true);

			array[1] = tableEntry;

			array[2] = filterGetByG_S_PrevAndNext(
				session, tableEntry, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TableEntry filterGetByG_S_PrevAndNext(
		Session session, TableEntry tableEntry, long groupId, int status,
		OrderByComparator<TableEntry> orderByComparator, boolean previous) {

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
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), TableEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, TableEntryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, TableEntryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the table entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByG_S(long groupId, int[] statuses) {
		return filterFindByG_S(
			groupId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByG_S(
		long groupId, int[] statuses, int start, int end) {

		return filterFindByG_S(groupId, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_1);
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
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), TableEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, TableEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, TableEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			return (List<TableEntry>)QueryUtil.list(
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
	 * Returns all the table entries where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByG_S(long groupId, int[] statuses) {
		return findByG_S(
			groupId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByG_S(
		long groupId, int[] statuses, int start, int end) {

		return findByG_S(groupId, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByG_S(
			groupId, statuses, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
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

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				_finderPathWithPaginationFindByG_S, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if ((groupId != tableEntry.getGroupId()) ||
						!ArrayUtil.contains(statuses, tableEntry.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Removes all the table entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByG_S(long groupId, int status) {
		for (TableEntry tableEntry :
				findByG_S(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(tableEntry);
		}
	}

	/**
	 * Returns the number of table entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching table entries
	 */
	@Override
	public int countByG_S(long groupId, int status) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

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
	 * Returns the number of table entries where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching table entries
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

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

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
	 * Returns the number of table entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching table entries that the user has permission to view
	 */
	@Override
	public int filterCountByG_S(long groupId, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S(groupId, status);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_TABLEENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), TableEntry.class.getName(),
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
	 * Returns the number of table entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching table entries that the user has permission to view
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

		sb.append(_FILTER_SQL_COUNT_TABLEENTRY_WHERE);

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
			sb.toString(), TableEntry.class.getName(),
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
		"tableEntry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_STATUS_2 =
		"tableEntry.status = ?";

	private static final String _FINDER_COLUMN_G_S_STATUS_7 =
		"tableEntry.status IN (";

	private FinderPath _finderPathWithPaginationFindByC_U_S;
	private FinderPath _finderPathWithoutPaginationFindByC_U_S;
	private FinderPath _finderPathCountByC_U_S;
	private FinderPath _finderPathWithPaginationCountByC_U_S;

	/**
	 * Returns all the table entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByC_U_S(
		long companyId, long userId, int status) {

		return findByC_U_S(
			companyId, userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the table entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end) {

		return findByC_U_S(companyId, userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByC_U_S(
			companyId, userId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
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

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if ((companyId != tableEntry.getCompanyId()) ||
						(userId != tableEntry.getUserId()) ||
						(status != tableEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_U_S_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_C_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Returns the first table entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByC_U_S_First(
			long companyId, long userId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByC_U_S_First(
			companyId, userId, status, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
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

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the first table entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByC_U_S_First(
		long companyId, long userId, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		List<TableEntry> list = findByC_U_S(
			companyId, userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByC_U_S_Last(
			long companyId, long userId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByC_U_S_Last(
			companyId, userId, status, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
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

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the last table entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByC_U_S_Last(
		long companyId, long userId, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		int count = countByC_U_S(companyId, userId, status);

		if (count == 0) {
			return null;
		}

		List<TableEntry> list = findByC_U_S(
			companyId, userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] findByC_U_S_PrevAndNext(
			long tableEntryId, long companyId, long userId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = getByC_U_S_PrevAndNext(
				session, tableEntry, companyId, userId, status,
				orderByComparator, true);

			array[1] = tableEntry;

			array[2] = getByC_U_S_PrevAndNext(
				session, tableEntry, companyId, userId, status,
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

	protected TableEntry getByC_U_S_PrevAndNext(
		Session session, TableEntry tableEntry, long companyId, long userId,
		int status, OrderByComparator<TableEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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
			sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the table entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByC_U_S(
		long companyId, long userId, int[] statuses) {

		return findByC_U_S(
			companyId, userId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the table entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end) {

		return findByC_U_S(companyId, userId, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByC_U_S(
			companyId, userId, statuses, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where companyId = &#63; and userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
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

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				_finderPathWithPaginationFindByC_U_S, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if ((companyId != tableEntry.getCompanyId()) ||
						(userId != tableEntry.getUserId()) ||
						!ArrayUtil.contains(statuses, tableEntry.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userId);

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Removes all the table entries where companyId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByC_U_S(long companyId, long userId, int status) {
		for (TableEntry tableEntry :
				findByC_U_S(
					companyId, userId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(tableEntry);
		}
	}

	/**
	 * Returns the number of table entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching table entries
	 */
	@Override
	public int countByC_U_S(long companyId, long userId, int status) {
		FinderPath finderPath = _finderPathCountByC_U_S;

		Object[] finderArgs = new Object[] {companyId, userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

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
	 * Returns the number of table entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching table entries
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

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

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
		"tableEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_U_S_USERID_2 =
		"tableEntry.userId = ? AND ";

	private static final String _FINDER_COLUMN_C_U_S_STATUS_2 =
		"tableEntry.status = ?";

	private static final String _FINDER_COLUMN_C_U_S_STATUS_7 =
		"tableEntry.status IN (";

	private FinderPath _finderPathWithPaginationFindByG_U_S;
	private FinderPath _finderPathWithoutPaginationFindByG_U_S;
	private FinderPath _finderPathCountByG_U_S;
	private FinderPath _finderPathWithPaginationCountByG_U_S;

	/**
	 * Returns all the table entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByG_U_S(long groupId, long userId, int status) {
		return findByG_U_S(
			groupId, userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the table entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return findByG_U_S(groupId, userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByG_U_S(
			groupId, userId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
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

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if ((groupId != tableEntry.getGroupId()) ||
						(userId != tableEntry.getUserId()) ||
						(status != tableEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Returns the first table entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByG_U_S_First(
			long groupId, long userId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByG_U_S_First(
			groupId, userId, status, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
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

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the first table entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByG_U_S_First(
		long groupId, long userId, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		List<TableEntry> list = findByG_U_S(
			groupId, userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByG_U_S_Last(
			long groupId, long userId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByG_U_S_Last(
			groupId, userId, status, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
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

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the last table entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByG_U_S_Last(
		long groupId, long userId, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		int count = countByG_U_S(groupId, userId, status);

		if (count == 0) {
			return null;
		}

		List<TableEntry> list = findByG_U_S(
			groupId, userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] findByG_U_S_PrevAndNext(
			long tableEntryId, long groupId, long userId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = getByG_U_S_PrevAndNext(
				session, tableEntry, groupId, userId, status, orderByComparator,
				true);

			array[1] = tableEntry;

			array[2] = getByG_U_S_PrevAndNext(
				session, tableEntry, groupId, userId, status, orderByComparator,
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

	protected TableEntry getByG_U_S_PrevAndNext(
		Session session, TableEntry tableEntry, long groupId, long userId,
		int status, OrderByComparator<TableEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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
			sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the table entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByG_U_S(
		long groupId, long userId, int status) {

		return filterFindByG_U_S(
			groupId, userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the table entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return filterFindByG_U_S(groupId, userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries that the user has permissions to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), TableEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, TableEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, TableEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(userId);

			queryPos.add(status);

			return (List<TableEntry>)QueryUtil.list(
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
	 * Returns the table entries before and after the current table entry in the ordered set of table entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] filterFindByG_U_S_PrevAndNext(
			long tableEntryId, long groupId, long userId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_U_S_PrevAndNext(
				tableEntryId, groupId, userId, status, orderByComparator);
		}

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = filterGetByG_U_S_PrevAndNext(
				session, tableEntry, groupId, userId, status, orderByComparator,
				true);

			array[1] = tableEntry;

			array[2] = filterGetByG_U_S_PrevAndNext(
				session, tableEntry, groupId, userId, status, orderByComparator,
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

	protected TableEntry filterGetByG_U_S_PrevAndNext(
		Session session, TableEntry tableEntry, long groupId, long userId,
		int status, OrderByComparator<TableEntry> orderByComparator,
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
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), TableEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, TableEntryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, TableEntryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(userId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the table entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses) {

		return filterFindByG_U_S(
			groupId, userId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the table entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end) {

		return filterFindByG_U_S(groupId, userId, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_1);
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
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), TableEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, TableEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, TableEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(userId);

			return (List<TableEntry>)QueryUtil.list(
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
	 * Returns all the table entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByG_U_S(
		long groupId, long userId, int[] statuses) {

		return findByG_U_S(
			groupId, userId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the table entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end) {

		return findByG_U_S(groupId, userId, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByG_U_S(
			groupId, userId, statuses, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
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

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				_finderPathWithPaginationFindByG_U_S, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if ((groupId != tableEntry.getGroupId()) ||
						(userId != tableEntry.getUserId()) ||
						!ArrayUtil.contains(statuses, tableEntry.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Removes all the table entries where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByG_U_S(long groupId, long userId, int status) {
		for (TableEntry tableEntry :
				findByG_U_S(
					groupId, userId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(tableEntry);
		}
	}

	/**
	 * Returns the number of table entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching table entries
	 */
	@Override
	public int countByG_U_S(long groupId, long userId, int status) {
		FinderPath finderPath = _finderPathCountByG_U_S;

		Object[] finderArgs = new Object[] {groupId, userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

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
	 * Returns the number of table entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching table entries
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

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

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
	 * Returns the number of table entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching table entries that the user has permission to view
	 */
	@Override
	public int filterCountByG_U_S(long groupId, long userId, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_U_S(groupId, userId, status);
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_FILTER_SQL_COUNT_TABLEENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), TableEntry.class.getName(),
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
	 * Returns the number of table entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching table entries that the user has permission to view
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

		sb.append(_FILTER_SQL_COUNT_TABLEENTRY_WHERE);

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
			sb.toString(), TableEntry.class.getName(),
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
		"tableEntry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_U_S_USERID_2 =
		"tableEntry.userId = ? AND ";

	private static final String _FINDER_COLUMN_G_U_S_STATUS_2 =
		"tableEntry.status = ?";

	private static final String _FINDER_COLUMN_G_U_S_STATUS_7 =
		"tableEntry.status IN (";

	private FinderPath _finderPathWithPaginationFindByU_S;
	private FinderPath _finderPathWithoutPaginationFindByU_S;
	private FinderPath _finderPathCountByU_S;
	private FinderPath _finderPathWithPaginationCountByU_S;

	/**
	 * Returns all the table entries where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByU_S(long userId, int status) {
		return findByU_S(
			userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByU_S(
		long userId, int status, int start, int end) {

		return findByU_S(userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByU_S(userId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
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

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if ((userId != tableEntry.getUserId()) ||
						(status != tableEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(status);

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Returns the first table entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByU_S_First(
			long userId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByU_S_First(
			userId, status, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the first table entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByU_S_First(
		long userId, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		List<TableEntry> list = findByU_S(
			userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByU_S_Last(
			long userId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByU_S_Last(
			userId, status, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the last table entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByU_S_Last(
		long userId, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		int count = countByU_S(userId, status);

		if (count == 0) {
			return null;
		}

		List<TableEntry> list = findByU_S(
			userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] findByU_S_PrevAndNext(
			long tableEntryId, long userId, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = getByU_S_PrevAndNext(
				session, tableEntry, userId, status, orderByComparator, true);

			array[1] = tableEntry;

			array[2] = getByU_S_PrevAndNext(
				session, tableEntry, userId, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TableEntry getByU_S_PrevAndNext(
		Session session, TableEntry tableEntry, long userId, int status,
		OrderByComparator<TableEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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
			sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the table entries where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByU_S(long userId, int[] statuses) {
		return findByU_S(
			userId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByU_S(
		long userId, int[] statuses, int start, int end) {

		return findByU_S(userId, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByU_S(
		long userId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByU_S(userId, statuses, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByU_S(
		long userId, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
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

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				_finderPathWithPaginationFindByU_S, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if ((userId != tableEntry.getUserId()) ||
						!ArrayUtil.contains(statuses, tableEntry.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Removes all the table entries where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByU_S(long userId, int status) {
		for (TableEntry tableEntry :
				findByU_S(
					userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(tableEntry);
		}
	}

	/**
	 * Returns the number of table entries where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching table entries
	 */
	@Override
	public int countByU_S(long userId, int status) {
		FinderPath finderPath = _finderPathCountByU_S;

		Object[] finderArgs = new Object[] {userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

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
	 * Returns the number of table entries where userId = &#63; and status = any &#63;.
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching table entries
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

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

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
		"tableEntry.userId = ? AND ";

	private static final String _FINDER_COLUMN_U_S_STATUS_2 =
		"tableEntry.status = ?";

	private static final String _FINDER_COLUMN_U_S_STATUS_7 =
		"tableEntry.status IN (";

	private FinderPath _finderPathWithPaginationFindByG_UT_ST;
	private FinderPath _finderPathWithoutPaginationFindByG_UT_ST;
	private FinderPath _finderPathCountByG_UT_ST;
	private FinderPath _finderPathWithPaginationCountByG_UT_ST;

	/**
	 * Returns all the table entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return findByG_UT_ST(
			groupId, urlTitle, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the table entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end) {

		return findByG_UT_ST(groupId, urlTitle, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByG_UT_ST(
			groupId, urlTitle, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
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

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if ((groupId != tableEntry.getGroupId()) ||
						!urlTitle.equals(tableEntry.getUrlTitle()) ||
						(status != tableEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Returns the first table entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByG_UT_ST_First(
			long groupId, String urlTitle, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByG_UT_ST_First(
			groupId, urlTitle, status, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
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

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the first table entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByG_UT_ST_First(
		long groupId, String urlTitle, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		List<TableEntry> list = findByG_UT_ST(
			groupId, urlTitle, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByG_UT_ST_Last(
			long groupId, String urlTitle, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByG_UT_ST_Last(
			groupId, urlTitle, status, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
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

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the last table entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByG_UT_ST_Last(
		long groupId, String urlTitle, int status,
		OrderByComparator<TableEntry> orderByComparator) {

		int count = countByG_UT_ST(groupId, urlTitle, status);

		if (count == 0) {
			return null;
		}

		List<TableEntry> list = findByG_UT_ST(
			groupId, urlTitle, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] findByG_UT_ST_PrevAndNext(
			long tableEntryId, long groupId, String urlTitle, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		urlTitle = Objects.toString(urlTitle, "");

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = getByG_UT_ST_PrevAndNext(
				session, tableEntry, groupId, urlTitle, status,
				orderByComparator, true);

			array[1] = tableEntry;

			array[2] = getByG_UT_ST_PrevAndNext(
				session, tableEntry, groupId, urlTitle, status,
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

	protected TableEntry getByG_UT_ST_PrevAndNext(
		Session session, TableEntry tableEntry, long groupId, String urlTitle,
		int status, OrderByComparator<TableEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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
			sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the table entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return filterFindByG_UT_ST(
			groupId, urlTitle, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the table entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end) {

		return filterFindByG_UT_ST(groupId, urlTitle, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries that the user has permissions to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_1);
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
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), TableEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, TableEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, TableEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			if (bindUrlTitle) {
				queryPos.add(urlTitle);
			}

			queryPos.add(status);

			return (List<TableEntry>)QueryUtil.list(
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
	 * Returns the table entries before and after the current table entry in the ordered set of table entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] filterFindByG_UT_ST_PrevAndNext(
			long tableEntryId, long groupId, String urlTitle, int status,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_UT_ST_PrevAndNext(
				tableEntryId, groupId, urlTitle, status, orderByComparator);
		}

		urlTitle = Objects.toString(urlTitle, "");

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = filterGetByG_UT_ST_PrevAndNext(
				session, tableEntry, groupId, urlTitle, status,
				orderByComparator, true);

			array[1] = tableEntry;

			array[2] = filterGetByG_UT_ST_PrevAndNext(
				session, tableEntry, groupId, urlTitle, status,
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

	protected TableEntry filterGetByG_UT_ST_PrevAndNext(
		Session session, TableEntry tableEntry, long groupId, String urlTitle,
		int status, OrderByComparator<TableEntry> orderByComparator,
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
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_1);
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
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), TableEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, TableEntryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, TableEntryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (bindUrlTitle) {
			queryPos.add(urlTitle);
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the table entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return filterFindByG_UT_ST(
			groupId, urlTitle, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the table entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end) {

		return filterFindByG_UT_ST(
			groupId, urlTitle, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_1);
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
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), TableEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, TableEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, TableEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			if (bindUrlTitle) {
				queryPos.add(urlTitle);
			}

			return (List<TableEntry>)QueryUtil.list(
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
	 * Returns all the table entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return findByG_UT_ST(
			groupId, urlTitle, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the table entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end) {

		return findByG_UT_ST(groupId, urlTitle, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByG_UT_ST(
			groupId, urlTitle, statuses, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63; and urlTitle = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
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

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				_finderPathWithPaginationFindByG_UT_ST, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if ((groupId != tableEntry.getGroupId()) ||
						!urlTitle.equals(tableEntry.getUrlTitle()) ||
						!ArrayUtil.contains(statuses, tableEntry.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Removes all the table entries where groupId = &#63; and urlTitle = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 */
	@Override
	public void removeByG_UT_ST(long groupId, String urlTitle, int status) {
		for (TableEntry tableEntry :
				findByG_UT_ST(
					groupId, urlTitle, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(tableEntry);
		}
	}

	/**
	 * Returns the number of table entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching table entries
	 */
	@Override
	public int countByG_UT_ST(long groupId, String urlTitle, int status) {
		urlTitle = Objects.toString(urlTitle, "");

		FinderPath finderPath = _finderPathCountByG_UT_ST;

		Object[] finderArgs = new Object[] {groupId, urlTitle, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

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
	 * Returns the number of table entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching table entries
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

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

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
	 * Returns the number of table entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching table entries that the user has permission to view
	 */
	@Override
	public int filterCountByG_UT_ST(long groupId, String urlTitle, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_UT_ST(groupId, urlTitle, status);
		}

		urlTitle = Objects.toString(urlTitle, "");

		StringBundler sb = new StringBundler(4);

		sb.append(_FILTER_SQL_COUNT_TABLEENTRY_WHERE);

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
			sb.toString(), TableEntry.class.getName(),
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
	 * Returns the number of table entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching table entries that the user has permission to view
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

		sb.append(_FILTER_SQL_COUNT_TABLEENTRY_WHERE);

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
			sb.toString(), TableEntry.class.getName(),
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
		"tableEntry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_UT_ST_URLTITLE_2 =
		"tableEntry.urlTitle = ? AND ";

	private static final String _FINDER_COLUMN_G_UT_ST_URLTITLE_3 =
		"(tableEntry.urlTitle IS NULL OR tableEntry.urlTitle = '') AND ";

	private static final String _FINDER_COLUMN_G_UT_ST_STATUS_2 =
		"tableEntry.status = ?";

	private static final String _FINDER_COLUMN_G_UT_ST_STATUS_7 =
		"tableEntry.status IN (";

	private FinderPath _finderPathFetchByG_UT;
	private FinderPath _finderPathCountByG_UT;

	/**
	 * Returns the table entry where groupId = &#63; and urlTitle = &#63; or throws a <code>NoSuchTableEntryException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByG_UT(long groupId, String urlTitle)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByG_UT(groupId, urlTitle);

		if (tableEntry == null) {
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

			throw new NoSuchTableEntryException(sb.toString());
		}

		return tableEntry;
	}

	/**
	 * Returns the table entry where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByG_UT(long groupId, String urlTitle) {
		return fetchByG_UT(groupId, urlTitle, true);
	}

	/**
	 * Returns the table entry where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByG_UT(
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

		if (result instanceof TableEntry) {
			TableEntry tableEntry = (TableEntry)result;

			if ((groupId != tableEntry.getGroupId()) ||
				!Objects.equals(urlTitle, tableEntry.getUrlTitle())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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

				List<TableEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByG_UT, finderArgs, list);
					}
				}
				else {
					TableEntry tableEntry = list.get(0);

					result = tableEntry;

					cacheResult(tableEntry);
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
			return (TableEntry)result;
		}
	}

	/**
	 * Removes the table entry where groupId = &#63; and urlTitle = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the table entry that was removed
	 */
	@Override
	public TableEntry removeByG_UT(long groupId, String urlTitle)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = findByG_UT(groupId, urlTitle);

		return remove(tableEntry);
	}

	/**
	 * Returns the number of table entries where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the number of matching table entries
	 */
	@Override
	public int countByG_UT(long groupId, String urlTitle) {
		urlTitle = Objects.toString(urlTitle, "");

		FinderPath finderPath = _finderPathCountByG_UT;

		Object[] finderArgs = new Object[] {groupId, urlTitle};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

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
		"tableEntry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_UT_URLTITLE_2 =
		"tableEntry.urlTitle = ?";

	private static final String _FINDER_COLUMN_G_UT_URLTITLE_3 =
		"(tableEntry.urlTitle IS NULL OR tableEntry.urlTitle = '')";

	private FinderPath _finderPathFetchByURLTitle;
	private FinderPath _finderPathCountByURLTitle;

	/**
	 * Returns the table entry where urlTitle = &#63; or throws a <code>NoSuchTableEntryException</code> if it could not be found.
	 *
	 * @param urlTitle the url title
	 * @return the matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByURLTitle(String urlTitle)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByURLTitle(urlTitle);

		if (tableEntry == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("urlTitle=");
			sb.append(urlTitle);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTableEntryException(sb.toString());
		}

		return tableEntry;
	}

	/**
	 * Returns the table entry where urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param urlTitle the url title
	 * @return the matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByURLTitle(String urlTitle) {
		return fetchByURLTitle(urlTitle, true);
	}

	/**
	 * Returns the table entry where urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByURLTitle(String urlTitle, boolean useFinderCache) {
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

		if (result instanceof TableEntry) {
			TableEntry tableEntry = (TableEntry)result;

			if (!Objects.equals(urlTitle, tableEntry.getUrlTitle())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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

				List<TableEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByURLTitle, finderArgs, list);
					}
				}
				else {
					TableEntry tableEntry = list.get(0);

					result = tableEntry;

					cacheResult(tableEntry);
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
			return (TableEntry)result;
		}
	}

	/**
	 * Removes the table entry where urlTitle = &#63; from the database.
	 *
	 * @param urlTitle the url title
	 * @return the table entry that was removed
	 */
	@Override
	public TableEntry removeByURLTitle(String urlTitle)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = findByURLTitle(urlTitle);

		return remove(tableEntry);
	}

	/**
	 * Returns the number of table entries where urlTitle = &#63;.
	 *
	 * @param urlTitle the url title
	 * @return the number of matching table entries
	 */
	@Override
	public int countByURLTitle(String urlTitle) {
		urlTitle = Objects.toString(urlTitle, "");

		FinderPath finderPath = _finderPathCountByURLTitle;

		Object[] finderArgs = new Object[] {urlTitle};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

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
		"tableEntry.urlTitle = ?";

	private static final String _FINDER_COLUMN_URLTITLE_URLTITLE_3 =
		"(tableEntry.urlTitle IS NULL OR tableEntry.urlTitle = '')";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the table entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
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

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if (groupId != tableEntry.getGroupId()) {
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

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Returns the first table entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByGroupId_First(
			long groupId, OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByGroupId_First(
			groupId, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the first table entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByGroupId_First(
		long groupId, OrderByComparator<TableEntry> orderByComparator) {

		List<TableEntry> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByGroupId_Last(
			long groupId, OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByGroupId_Last(groupId, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the last table entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByGroupId_Last(
		long groupId, OrderByComparator<TableEntry> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<TableEntry> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where groupId = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] findByGroupId_PrevAndNext(
			long tableEntryId, long groupId,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, tableEntry, groupId, orderByComparator, true);

			array[1] = tableEntry;

			array[2] = getByGroupId_PrevAndNext(
				session, tableEntry, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TableEntry getByGroupId_PrevAndNext(
		Session session, TableEntry tableEntry, long groupId,
		OrderByComparator<TableEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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
			sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the table entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByGroupId(
		long groupId, int start, int end) {

		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), TableEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, TableEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, TableEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			return (List<TableEntry>)QueryUtil.list(
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
	 * Returns the table entries before and after the current table entry in the ordered set of table entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] filterFindByGroupId_PrevAndNext(
			long tableEntryId, long groupId,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(
				tableEntryId, groupId, orderByComparator);
		}

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(
				session, tableEntry, groupId, orderByComparator, true);

			array[1] = tableEntry;

			array[2] = filterGetByGroupId_PrevAndNext(
				session, tableEntry, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TableEntry filterGetByGroupId_PrevAndNext(
		Session session, TableEntry tableEntry, long groupId,
		OrderByComparator<TableEntry> orderByComparator, boolean previous) {

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
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), TableEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, TableEntryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, TableEntryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the table entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (TableEntry tableEntry :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tableEntry);
		}
	}

	/**
	 * Returns the number of table entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching table entries
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

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
	 * Returns the number of table entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching table entries that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler sb = new StringBundler(2);

		sb.append(_FILTER_SQL_COUNT_TABLEENTRY_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), TableEntry.class.getName(),
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
		"tableEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUserIdGroupId;
	private FinderPath _finderPathWithoutPaginationFindByUserIdGroupId;
	private FinderPath _finderPathCountByUserIdGroupId;

	/**
	 * Returns all the table entries where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByUserIdGroupId(long userId, long groupId) {
		return findByUserIdGroupId(
			userId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end) {

		return findByUserIdGroupId(userId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByUserIdGroupId(
			userId, groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
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

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if ((userId != tableEntry.getUserId()) ||
						(groupId != tableEntry.getGroupId())) {

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

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

			sb.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(groupId);

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Returns the first table entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByUserIdGroupId_First(
			long userId, long groupId,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByUserIdGroupId_First(
			userId, groupId, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the first table entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByUserIdGroupId_First(
		long userId, long groupId,
		OrderByComparator<TableEntry> orderByComparator) {

		List<TableEntry> list = findByUserIdGroupId(
			userId, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByUserIdGroupId_Last(
			long userId, long groupId,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByUserIdGroupId_Last(
			userId, groupId, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the last table entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByUserIdGroupId_Last(
		long userId, long groupId,
		OrderByComparator<TableEntry> orderByComparator) {

		int count = countByUserIdGroupId(userId, groupId);

		if (count == 0) {
			return null;
		}

		List<TableEntry> list = findByUserIdGroupId(
			userId, groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] findByUserIdGroupId_PrevAndNext(
			long tableEntryId, long userId, long groupId,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = getByUserIdGroupId_PrevAndNext(
				session, tableEntry, userId, groupId, orderByComparator, true);

			array[1] = tableEntry;

			array[2] = getByUserIdGroupId_PrevAndNext(
				session, tableEntry, userId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TableEntry getByUserIdGroupId_PrevAndNext(
		Session session, TableEntry tableEntry, long userId, long groupId,
		OrderByComparator<TableEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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
			sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the table entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByUserIdGroupId(
		long userId, long groupId) {

		return filterFindByUserIdGroupId(
			userId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end) {

		return filterFindByUserIdGroupId(userId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries that the user has permissions to view where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries that the user has permission to view
	 */
	@Override
	public List<TableEntry> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		sb.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), TableEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, TableEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, TableEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(userId);

			queryPos.add(groupId);

			return (List<TableEntry>)QueryUtil.list(
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
	 * Returns the table entries before and after the current table entry in the ordered set of table entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] filterFindByUserIdGroupId_PrevAndNext(
			long tableEntryId, long userId, long groupId,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByUserIdGroupId_PrevAndNext(
				tableEntryId, userId, groupId, orderByComparator);
		}

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = filterGetByUserIdGroupId_PrevAndNext(
				session, tableEntry, userId, groupId, orderByComparator, true);

			array[1] = tableEntry;

			array[2] = filterGetByUserIdGroupId_PrevAndNext(
				session, tableEntry, userId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TableEntry filterGetByUserIdGroupId_PrevAndNext(
		Session session, TableEntry tableEntry, long userId, long groupId,
		OrderByComparator<TableEntry> orderByComparator, boolean previous) {

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
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		sb.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), TableEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, TableEntryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, TableEntryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(userId);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the table entries where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 */
	@Override
	public void removeByUserIdGroupId(long userId, long groupId) {
		for (TableEntry tableEntry :
				findByUserIdGroupId(
					userId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(tableEntry);
		}
	}

	/**
	 * Returns the number of table entries where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching table entries
	 */
	@Override
	public int countByUserIdGroupId(long userId, long groupId) {
		FinderPath finderPath = _finderPathCountByUserIdGroupId;

		Object[] finderArgs = new Object[] {userId, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

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
	 * Returns the number of table entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching table entries that the user has permission to view
	 */
	@Override
	public int filterCountByUserIdGroupId(long userId, long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByUserIdGroupId(userId, groupId);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_TABLEENTRY_WHERE);

		sb.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		sb.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), TableEntry.class.getName(),
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
		"tableEntry.userId = ? AND ";

	private static final String _FINDER_COLUMN_USERIDGROUPID_GROUPID_2 =
		"tableEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the table entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByUserId(
		long userId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByUserId(
		long userId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
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

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if (userId != tableEntry.getUserId()) {
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

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Returns the first table entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByUserId_First(
			long userId, OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByUserId_First(userId, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the first table entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByUserId_First(
		long userId, OrderByComparator<TableEntry> orderByComparator) {

		List<TableEntry> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByUserId_Last(
			long userId, OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByUserId_Last(userId, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the last table entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByUserId_Last(
		long userId, OrderByComparator<TableEntry> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<TableEntry> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where userId = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] findByUserId_PrevAndNext(
			long tableEntryId, long userId,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, tableEntry, userId, orderByComparator, true);

			array[1] = tableEntry;

			array[2] = getByUserId_PrevAndNext(
				session, tableEntry, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TableEntry getByUserId_PrevAndNext(
		Session session, TableEntry tableEntry, long userId,
		OrderByComparator<TableEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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
			sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the table entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (TableEntry tableEntry :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tableEntry);
		}
	}

	/**
	 * Returns the number of table entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching table entries
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

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
		"tableEntry.userId = ?";

	private FinderPath _finderPathWithPaginationFindByCompanyId;
	private FinderPath _finderPathWithoutPaginationFindByCompanyId;
	private FinderPath _finderPathCountByCompanyId;

	/**
	 * Returns all the table entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByCompanyId(long companyId) {
		return findByCompanyId(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByCompanyId(
		long companyId, int start, int end) {

		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByCompanyId(companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
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

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if (companyId != tableEntry.getCompanyId()) {
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

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Returns the first table entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByCompanyId_First(
			long companyId, OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByCompanyId_First(
			companyId, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the first table entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByCompanyId_First(
		long companyId, OrderByComparator<TableEntry> orderByComparator) {

		List<TableEntry> list = findByCompanyId(
			companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByCompanyId_Last(
			long companyId, OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByCompanyId_Last(
			companyId, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the last table entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByCompanyId_Last(
		long companyId, OrderByComparator<TableEntry> orderByComparator) {

		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<TableEntry> list = findByCompanyId(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where companyId = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] findByCompanyId_PrevAndNext(
			long tableEntryId, long companyId,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = getByCompanyId_PrevAndNext(
				session, tableEntry, companyId, orderByComparator, true);

			array[1] = tableEntry;

			array[2] = getByCompanyId_PrevAndNext(
				session, tableEntry, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TableEntry getByCompanyId_PrevAndNext(
		Session session, TableEntry tableEntry, long companyId,
		OrderByComparator<TableEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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
			sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the table entries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (TableEntry tableEntry :
				findByCompanyId(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tableEntry);
		}
	}

	/**
	 * Returns the number of table entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching table entries
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = _finderPathCountByCompanyId;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

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
		"tableEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByTableEntryId;
	private FinderPath _finderPathWithoutPaginationFindByTableEntryId;
	private FinderPath _finderPathCountByTableEntryId;

	/**
	 * Returns all the table entries where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByTableEntryId(long tableEntryId) {
		return findByTableEntryId(
			tableEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries where tableEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableEntryId the table entry ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByTableEntryId(
		long tableEntryId, int start, int end) {

		return findByTableEntryId(tableEntryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where tableEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableEntryId the table entry ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByTableEntryId(
		long tableEntryId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByTableEntryId(
			tableEntryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where tableEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableEntryId the table entry ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByTableEntryId(
		long tableEntryId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
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

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if (tableEntryId != tableEntry.getTableEntryId()) {
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

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_TABLEENTRYID_TABLEENTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tableEntryId);

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Returns the first table entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByTableEntryId_First(
			long tableEntryId, OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByTableEntryId_First(
			tableEntryId, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tableEntryId=");
		sb.append(tableEntryId);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the first table entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByTableEntryId_First(
		long tableEntryId, OrderByComparator<TableEntry> orderByComparator) {

		List<TableEntry> list = findByTableEntryId(
			tableEntryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByTableEntryId_Last(
			long tableEntryId, OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByTableEntryId_Last(
			tableEntryId, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tableEntryId=");
		sb.append(tableEntryId);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the last table entry in the ordered set where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByTableEntryId_Last(
		long tableEntryId, OrderByComparator<TableEntry> orderByComparator) {

		int count = countByTableEntryId(tableEntryId);

		if (count == 0) {
			return null;
		}

		List<TableEntry> list = findByTableEntryId(
			tableEntryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the table entries where tableEntryId = &#63; from the database.
	 *
	 * @param tableEntryId the table entry ID
	 */
	@Override
	public void removeByTableEntryId(long tableEntryId) {
		for (TableEntry tableEntry :
				findByTableEntryId(
					tableEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tableEntry);
		}
	}

	/**
	 * Returns the number of table entries where tableEntryId = &#63;.
	 *
	 * @param tableEntryId the table entry ID
	 * @return the number of matching table entries
	 */
	@Override
	public int countByTableEntryId(long tableEntryId) {
		FinderPath finderPath = _finderPathCountByTableEntryId;

		Object[] finderArgs = new Object[] {tableEntryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

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
		"tableEntry.tableEntryId = ?";

	private FinderPath _finderPathWithPaginationFindByTableName;
	private FinderPath _finderPathWithoutPaginationFindByTableName;
	private FinderPath _finderPathCountByTableName;

	/**
	 * Returns all the table entries where tableName = &#63;.
	 *
	 * @param tableName the table name
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByTableName(String tableName) {
		return findByTableName(
			tableName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries where tableName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableName the table name
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByTableName(
		String tableName, int start, int end) {

		return findByTableName(tableName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where tableName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableName the table name
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByTableName(
		String tableName, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByTableName(tableName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where tableName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableName the table name
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByTableName(
		String tableName, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		tableName = Objects.toString(tableName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTableName;
				finderArgs = new Object[] {tableName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTableName;
			finderArgs = new Object[] {
				tableName, start, end, orderByComparator
			};
		}

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if (!tableName.equals(tableEntry.getTableName())) {
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

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

			boolean bindTableName = false;

			if (tableName.isEmpty()) {
				sb.append(_FINDER_COLUMN_TABLENAME_TABLENAME_3);
			}
			else {
				bindTableName = true;

				sb.append(_FINDER_COLUMN_TABLENAME_TABLENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTableName) {
					queryPos.add(tableName);
				}

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Returns the first table entry in the ordered set where tableName = &#63;.
	 *
	 * @param tableName the table name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByTableName_First(
			String tableName, OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByTableName_First(
			tableName, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tableName=");
		sb.append(tableName);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the first table entry in the ordered set where tableName = &#63;.
	 *
	 * @param tableName the table name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByTableName_First(
		String tableName, OrderByComparator<TableEntry> orderByComparator) {

		List<TableEntry> list = findByTableName(
			tableName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table entry in the ordered set where tableName = &#63;.
	 *
	 * @param tableName the table name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByTableName_Last(
			String tableName, OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByTableName_Last(
			tableName, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tableName=");
		sb.append(tableName);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the last table entry in the ordered set where tableName = &#63;.
	 *
	 * @param tableName the table name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByTableName_Last(
		String tableName, OrderByComparator<TableEntry> orderByComparator) {

		int count = countByTableName(tableName);

		if (count == 0) {
			return null;
		}

		List<TableEntry> list = findByTableName(
			tableName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where tableName = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param tableName the table name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] findByTableName_PrevAndNext(
			long tableEntryId, String tableName,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		tableName = Objects.toString(tableName, "");

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = getByTableName_PrevAndNext(
				session, tableEntry, tableName, orderByComparator, true);

			array[1] = tableEntry;

			array[2] = getByTableName_PrevAndNext(
				session, tableEntry, tableName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TableEntry getByTableName_PrevAndNext(
		Session session, TableEntry tableEntry, String tableName,
		OrderByComparator<TableEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

		boolean bindTableName = false;

		if (tableName.isEmpty()) {
			sb.append(_FINDER_COLUMN_TABLENAME_TABLENAME_3);
		}
		else {
			bindTableName = true;

			sb.append(_FINDER_COLUMN_TABLENAME_TABLENAME_2);
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
			sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTableName) {
			queryPos.add(tableName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the table entries where tableName = &#63; from the database.
	 *
	 * @param tableName the table name
	 */
	@Override
	public void removeByTableName(String tableName) {
		for (TableEntry tableEntry :
				findByTableName(
					tableName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tableEntry);
		}
	}

	/**
	 * Returns the number of table entries where tableName = &#63;.
	 *
	 * @param tableName the table name
	 * @return the number of matching table entries
	 */
	@Override
	public int countByTableName(String tableName) {
		tableName = Objects.toString(tableName, "");

		FinderPath finderPath = _finderPathCountByTableName;

		Object[] finderArgs = new Object[] {tableName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

			boolean bindTableName = false;

			if (tableName.isEmpty()) {
				sb.append(_FINDER_COLUMN_TABLENAME_TABLENAME_3);
			}
			else {
				bindTableName = true;

				sb.append(_FINDER_COLUMN_TABLENAME_TABLENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTableName) {
					queryPos.add(tableName);
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

	private static final String _FINDER_COLUMN_TABLENAME_TABLENAME_2 =
		"tableEntry.tableName = ?";

	private static final String _FINDER_COLUMN_TABLENAME_TABLENAME_3 =
		"(tableEntry.tableName IS NULL OR tableEntry.tableName = '')";

	private FinderPath _finderPathWithPaginationFindByTableFullName;
	private FinderPath _finderPathWithoutPaginationFindByTableFullName;
	private FinderPath _finderPathCountByTableFullName;

	/**
	 * Returns all the table entries where tableFullName = &#63;.
	 *
	 * @param tableFullName the table full name
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByTableFullName(String tableFullName) {
		return findByTableFullName(
			tableFullName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries where tableFullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableFullName the table full name
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByTableFullName(
		String tableFullName, int start, int end) {

		return findByTableFullName(tableFullName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where tableFullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableFullName the table full name
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByTableFullName(
		String tableFullName, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByTableFullName(
			tableFullName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where tableFullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableFullName the table full name
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByTableFullName(
		String tableFullName, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		tableFullName = Objects.toString(tableFullName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTableFullName;
				finderArgs = new Object[] {tableFullName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTableFullName;
			finderArgs = new Object[] {
				tableFullName, start, end, orderByComparator
			};
		}

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if (!tableFullName.equals(tableEntry.getTableFullName())) {
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

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

			boolean bindTableFullName = false;

			if (tableFullName.isEmpty()) {
				sb.append(_FINDER_COLUMN_TABLEFULLNAME_TABLEFULLNAME_3);
			}
			else {
				bindTableFullName = true;

				sb.append(_FINDER_COLUMN_TABLEFULLNAME_TABLEFULLNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTableFullName) {
					queryPos.add(tableFullName);
				}

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Returns the first table entry in the ordered set where tableFullName = &#63;.
	 *
	 * @param tableFullName the table full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByTableFullName_First(
			String tableFullName,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByTableFullName_First(
			tableFullName, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tableFullName=");
		sb.append(tableFullName);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the first table entry in the ordered set where tableFullName = &#63;.
	 *
	 * @param tableFullName the table full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByTableFullName_First(
		String tableFullName, OrderByComparator<TableEntry> orderByComparator) {

		List<TableEntry> list = findByTableFullName(
			tableFullName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table entry in the ordered set where tableFullName = &#63;.
	 *
	 * @param tableFullName the table full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByTableFullName_Last(
			String tableFullName,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByTableFullName_Last(
			tableFullName, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tableFullName=");
		sb.append(tableFullName);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the last table entry in the ordered set where tableFullName = &#63;.
	 *
	 * @param tableFullName the table full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByTableFullName_Last(
		String tableFullName, OrderByComparator<TableEntry> orderByComparator) {

		int count = countByTableFullName(tableFullName);

		if (count == 0) {
			return null;
		}

		List<TableEntry> list = findByTableFullName(
			tableFullName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where tableFullName = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param tableFullName the table full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] findByTableFullName_PrevAndNext(
			long tableEntryId, String tableFullName,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		tableFullName = Objects.toString(tableFullName, "");

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = getByTableFullName_PrevAndNext(
				session, tableEntry, tableFullName, orderByComparator, true);

			array[1] = tableEntry;

			array[2] = getByTableFullName_PrevAndNext(
				session, tableEntry, tableFullName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TableEntry getByTableFullName_PrevAndNext(
		Session session, TableEntry tableEntry, String tableFullName,
		OrderByComparator<TableEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

		boolean bindTableFullName = false;

		if (tableFullName.isEmpty()) {
			sb.append(_FINDER_COLUMN_TABLEFULLNAME_TABLEFULLNAME_3);
		}
		else {
			bindTableFullName = true;

			sb.append(_FINDER_COLUMN_TABLEFULLNAME_TABLEFULLNAME_2);
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
			sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTableFullName) {
			queryPos.add(tableFullName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the table entries where tableFullName = &#63; from the database.
	 *
	 * @param tableFullName the table full name
	 */
	@Override
	public void removeByTableFullName(String tableFullName) {
		for (TableEntry tableEntry :
				findByTableFullName(
					tableFullName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(tableEntry);
		}
	}

	/**
	 * Returns the number of table entries where tableFullName = &#63;.
	 *
	 * @param tableFullName the table full name
	 * @return the number of matching table entries
	 */
	@Override
	public int countByTableFullName(String tableFullName) {
		tableFullName = Objects.toString(tableFullName, "");

		FinderPath finderPath = _finderPathCountByTableFullName;

		Object[] finderArgs = new Object[] {tableFullName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

			boolean bindTableFullName = false;

			if (tableFullName.isEmpty()) {
				sb.append(_FINDER_COLUMN_TABLEFULLNAME_TABLEFULLNAME_3);
			}
			else {
				bindTableFullName = true;

				sb.append(_FINDER_COLUMN_TABLEFULLNAME_TABLEFULLNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTableFullName) {
					queryPos.add(tableFullName);
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

	private static final String _FINDER_COLUMN_TABLEFULLNAME_TABLEFULLNAME_2 =
		"tableEntry.tableFullName = ?";

	private static final String _FINDER_COLUMN_TABLEFULLNAME_TABLEFULLNAME_3 =
		"(tableEntry.tableFullName IS NULL OR tableEntry.tableFullName = '')";

	private FinderPath _finderPathWithPaginationFindByTableType;
	private FinderPath _finderPathWithoutPaginationFindByTableType;
	private FinderPath _finderPathCountByTableType;

	/**
	 * Returns all the table entries where tableType = &#63;.
	 *
	 * @param tableType the table type
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByTableType(String tableType) {
		return findByTableType(
			tableType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries where tableType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableType the table type
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByTableType(
		String tableType, int start, int end) {

		return findByTableType(tableType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where tableType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableType the table type
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByTableType(
		String tableType, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByTableType(tableType, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where tableType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableType the table type
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByTableType(
		String tableType, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		tableType = Objects.toString(tableType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTableType;
				finderArgs = new Object[] {tableType};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTableType;
			finderArgs = new Object[] {
				tableType, start, end, orderByComparator
			};
		}

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if (!tableType.equals(tableEntry.getTableType())) {
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

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

			boolean bindTableType = false;

			if (tableType.isEmpty()) {
				sb.append(_FINDER_COLUMN_TABLETYPE_TABLETYPE_3);
			}
			else {
				bindTableType = true;

				sb.append(_FINDER_COLUMN_TABLETYPE_TABLETYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTableType) {
					queryPos.add(tableType);
				}

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Returns the first table entry in the ordered set where tableType = &#63;.
	 *
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByTableType_First(
			String tableType, OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByTableType_First(
			tableType, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tableType=");
		sb.append(tableType);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the first table entry in the ordered set where tableType = &#63;.
	 *
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByTableType_First(
		String tableType, OrderByComparator<TableEntry> orderByComparator) {

		List<TableEntry> list = findByTableType(
			tableType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table entry in the ordered set where tableType = &#63;.
	 *
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByTableType_Last(
			String tableType, OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByTableType_Last(
			tableType, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tableType=");
		sb.append(tableType);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the last table entry in the ordered set where tableType = &#63;.
	 *
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByTableType_Last(
		String tableType, OrderByComparator<TableEntry> orderByComparator) {

		int count = countByTableType(tableType);

		if (count == 0) {
			return null;
		}

		List<TableEntry> list = findByTableType(
			tableType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where tableType = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] findByTableType_PrevAndNext(
			long tableEntryId, String tableType,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		tableType = Objects.toString(tableType, "");

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = getByTableType_PrevAndNext(
				session, tableEntry, tableType, orderByComparator, true);

			array[1] = tableEntry;

			array[2] = getByTableType_PrevAndNext(
				session, tableEntry, tableType, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TableEntry getByTableType_PrevAndNext(
		Session session, TableEntry tableEntry, String tableType,
		OrderByComparator<TableEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

		boolean bindTableType = false;

		if (tableType.isEmpty()) {
			sb.append(_FINDER_COLUMN_TABLETYPE_TABLETYPE_3);
		}
		else {
			bindTableType = true;

			sb.append(_FINDER_COLUMN_TABLETYPE_TABLETYPE_2);
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
			sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTableType) {
			queryPos.add(tableType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the table entries where tableType = &#63; from the database.
	 *
	 * @param tableType the table type
	 */
	@Override
	public void removeByTableType(String tableType) {
		for (TableEntry tableEntry :
				findByTableType(
					tableType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tableEntry);
		}
	}

	/**
	 * Returns the number of table entries where tableType = &#63;.
	 *
	 * @param tableType the table type
	 * @return the number of matching table entries
	 */
	@Override
	public int countByTableType(String tableType) {
		tableType = Objects.toString(tableType, "");

		FinderPath finderPath = _finderPathCountByTableType;

		Object[] finderArgs = new Object[] {tableType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

			boolean bindTableType = false;

			if (tableType.isEmpty()) {
				sb.append(_FINDER_COLUMN_TABLETYPE_TABLETYPE_3);
			}
			else {
				bindTableType = true;

				sb.append(_FINDER_COLUMN_TABLETYPE_TABLETYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTableType) {
					queryPos.add(tableType);
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

	private static final String _FINDER_COLUMN_TABLETYPE_TABLETYPE_2 =
		"tableEntry.tableType = ?";

	private static final String _FINDER_COLUMN_TABLETYPE_TABLETYPE_3 =
		"(tableEntry.tableType IS NULL OR tableEntry.tableType = '')";

	private FinderPath _finderPathWithPaginationFindByTableDatabase;
	private FinderPath _finderPathWithoutPaginationFindByTableDatabase;
	private FinderPath _finderPathCountByTableDatabase;
	private FinderPath _finderPathWithPaginationCountByTableDatabase;

	/**
	 * Returns all the table entries where tableDatabase = &#63;.
	 *
	 * @param tableDatabase the table database
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByTableDatabase(String tableDatabase) {
		return findByTableDatabase(
			tableDatabase, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries where tableDatabase = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableDatabase the table database
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByTableDatabase(
		String tableDatabase, int start, int end) {

		return findByTableDatabase(tableDatabase, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where tableDatabase = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableDatabase the table database
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByTableDatabase(
		String tableDatabase, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByTableDatabase(
			tableDatabase, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where tableDatabase = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableDatabase the table database
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByTableDatabase(
		String tableDatabase, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		tableDatabase = Objects.toString(tableDatabase, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTableDatabase;
				finderArgs = new Object[] {tableDatabase};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTableDatabase;
			finderArgs = new Object[] {
				tableDatabase, start, end, orderByComparator
			};
		}

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if (!tableDatabase.equals(tableEntry.getTableDatabase())) {
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

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

			boolean bindTableDatabase = false;

			if (tableDatabase.isEmpty()) {
				sb.append(_FINDER_COLUMN_TABLEDATABASE_TABLEDATABASE_3);
			}
			else {
				bindTableDatabase = true;

				sb.append(_FINDER_COLUMN_TABLEDATABASE_TABLEDATABASE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTableDatabase) {
					queryPos.add(tableDatabase);
				}

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Returns the first table entry in the ordered set where tableDatabase = &#63;.
	 *
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByTableDatabase_First(
			String tableDatabase,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByTableDatabase_First(
			tableDatabase, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tableDatabase=");
		sb.append(tableDatabase);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the first table entry in the ordered set where tableDatabase = &#63;.
	 *
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByTableDatabase_First(
		String tableDatabase, OrderByComparator<TableEntry> orderByComparator) {

		List<TableEntry> list = findByTableDatabase(
			tableDatabase, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table entry in the ordered set where tableDatabase = &#63;.
	 *
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByTableDatabase_Last(
			String tableDatabase,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByTableDatabase_Last(
			tableDatabase, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tableDatabase=");
		sb.append(tableDatabase);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the last table entry in the ordered set where tableDatabase = &#63;.
	 *
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByTableDatabase_Last(
		String tableDatabase, OrderByComparator<TableEntry> orderByComparator) {

		int count = countByTableDatabase(tableDatabase);

		if (count == 0) {
			return null;
		}

		List<TableEntry> list = findByTableDatabase(
			tableDatabase, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where tableDatabase = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] findByTableDatabase_PrevAndNext(
			long tableEntryId, String tableDatabase,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		tableDatabase = Objects.toString(tableDatabase, "");

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = getByTableDatabase_PrevAndNext(
				session, tableEntry, tableDatabase, orderByComparator, true);

			array[1] = tableEntry;

			array[2] = getByTableDatabase_PrevAndNext(
				session, tableEntry, tableDatabase, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TableEntry getByTableDatabase_PrevAndNext(
		Session session, TableEntry tableEntry, String tableDatabase,
		OrderByComparator<TableEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

		boolean bindTableDatabase = false;

		if (tableDatabase.isEmpty()) {
			sb.append(_FINDER_COLUMN_TABLEDATABASE_TABLEDATABASE_3);
		}
		else {
			bindTableDatabase = true;

			sb.append(_FINDER_COLUMN_TABLEDATABASE_TABLEDATABASE_2);
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
			sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTableDatabase) {
			queryPos.add(tableDatabase);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the table entries where tableDatabase = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableDatabases the table databases
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByTableDatabase(String[] tableDatabases) {
		return findByTableDatabase(
			tableDatabases, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries where tableDatabase = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableDatabases the table databases
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByTableDatabase(
		String[] tableDatabases, int start, int end) {

		return findByTableDatabase(tableDatabases, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where tableDatabase = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableDatabases the table databases
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByTableDatabase(
		String[] tableDatabases, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByTableDatabase(
			tableDatabases, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where tableDatabase = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tableDatabase the table database
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByTableDatabase(
		String[] tableDatabases, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		if (tableDatabases == null) {
			tableDatabases = new String[0];
		}
		else if (tableDatabases.length > 1) {
			for (int i = 0; i < tableDatabases.length; i++) {
				tableDatabases[i] = Objects.toString(tableDatabases[i], "");
			}

			tableDatabases = ArrayUtil.sortedUnique(tableDatabases);
		}

		if (tableDatabases.length == 1) {
			return findByTableDatabase(
				tableDatabases[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {StringUtil.merge(tableDatabases)};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				StringUtil.merge(tableDatabases), start, end, orderByComparator
			};
		}

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				_finderPathWithPaginationFindByTableDatabase, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if (!ArrayUtil.contains(
							tableDatabases, tableEntry.getTableDatabase())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

			if (tableDatabases.length > 0) {
				sb.append("(");

				for (int i = 0; i < tableDatabases.length; i++) {
					String tableDatabase = tableDatabases[i];

					if (tableDatabase.isEmpty()) {
						sb.append(_FINDER_COLUMN_TABLEDATABASE_TABLEDATABASE_3);
					}
					else {
						sb.append(_FINDER_COLUMN_TABLEDATABASE_TABLEDATABASE_2);
					}

					if ((i + 1) < tableDatabases.length) {
						sb.append(WHERE_OR);
					}
				}

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				for (String tableDatabase : tableDatabases) {
					if ((tableDatabase != null) && !tableDatabase.isEmpty()) {
						queryPos.add(tableDatabase);
					}
				}

				list = (List<TableEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByTableDatabase,
						finderArgs, list);
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
	 * Removes all the table entries where tableDatabase = &#63; from the database.
	 *
	 * @param tableDatabase the table database
	 */
	@Override
	public void removeByTableDatabase(String tableDatabase) {
		for (TableEntry tableEntry :
				findByTableDatabase(
					tableDatabase, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(tableEntry);
		}
	}

	/**
	 * Returns the number of table entries where tableDatabase = &#63;.
	 *
	 * @param tableDatabase the table database
	 * @return the number of matching table entries
	 */
	@Override
	public int countByTableDatabase(String tableDatabase) {
		tableDatabase = Objects.toString(tableDatabase, "");

		FinderPath finderPath = _finderPathCountByTableDatabase;

		Object[] finderArgs = new Object[] {tableDatabase};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

			boolean bindTableDatabase = false;

			if (tableDatabase.isEmpty()) {
				sb.append(_FINDER_COLUMN_TABLEDATABASE_TABLEDATABASE_3);
			}
			else {
				bindTableDatabase = true;

				sb.append(_FINDER_COLUMN_TABLEDATABASE_TABLEDATABASE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTableDatabase) {
					queryPos.add(tableDatabase);
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

	/**
	 * Returns the number of table entries where tableDatabase = any &#63;.
	 *
	 * @param tableDatabases the table databases
	 * @return the number of matching table entries
	 */
	@Override
	public int countByTableDatabase(String[] tableDatabases) {
		if (tableDatabases == null) {
			tableDatabases = new String[0];
		}
		else if (tableDatabases.length > 1) {
			for (int i = 0; i < tableDatabases.length; i++) {
				tableDatabases[i] = Objects.toString(tableDatabases[i], "");
			}

			tableDatabases = ArrayUtil.sortedUnique(tableDatabases);
		}

		Object[] finderArgs = new Object[] {StringUtil.merge(tableDatabases)};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByTableDatabase, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

			if (tableDatabases.length > 0) {
				sb.append("(");

				for (int i = 0; i < tableDatabases.length; i++) {
					String tableDatabase = tableDatabases[i];

					if (tableDatabase.isEmpty()) {
						sb.append(_FINDER_COLUMN_TABLEDATABASE_TABLEDATABASE_3);
					}
					else {
						sb.append(_FINDER_COLUMN_TABLEDATABASE_TABLEDATABASE_2);
					}

					if ((i + 1) < tableDatabases.length) {
						sb.append(WHERE_OR);
					}
				}

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

				for (String tableDatabase : tableDatabases) {
					if ((tableDatabase != null) && !tableDatabase.isEmpty()) {
						queryPos.add(tableDatabase);
					}
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByTableDatabase, finderArgs,
					count);
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

	private static final String _FINDER_COLUMN_TABLEDATABASE_TABLEDATABASE_2 =
		"tableEntry.tableDatabase = ?";

	private static final String _FINDER_COLUMN_TABLEDATABASE_TABLEDATABASE_3 =
		"(tableEntry.tableDatabase IS NULL OR tableEntry.tableDatabase = '')";

	private FinderPath _finderPathWithPaginationFindBySystemEntryId;
	private FinderPath _finderPathWithoutPaginationFindBySystemEntryId;
	private FinderPath _finderPathCountBySystemEntryId;

	/**
	 * Returns all the table entries where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findBySystemEntryId(long systemEntryId) {
		return findBySystemEntryId(
			systemEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries where systemEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findBySystemEntryId(
		long systemEntryId, int start, int end) {

		return findBySystemEntryId(systemEntryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where systemEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findBySystemEntryId(
		long systemEntryId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findBySystemEntryId(
			systemEntryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where systemEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findBySystemEntryId(
		long systemEntryId, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySystemEntryId;
				finderArgs = new Object[] {systemEntryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySystemEntryId;
			finderArgs = new Object[] {
				systemEntryId, start, end, orderByComparator
			};
		}

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if (systemEntryId != tableEntry.getSystemEntryId()) {
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

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_SYSTEMENTRYID_SYSTEMENTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(systemEntryId);

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Returns the first table entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findBySystemEntryId_First(
			long systemEntryId, OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchBySystemEntryId_First(
			systemEntryId, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("systemEntryId=");
		sb.append(systemEntryId);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the first table entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchBySystemEntryId_First(
		long systemEntryId, OrderByComparator<TableEntry> orderByComparator) {

		List<TableEntry> list = findBySystemEntryId(
			systemEntryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findBySystemEntryId_Last(
			long systemEntryId, OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchBySystemEntryId_Last(
			systemEntryId, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("systemEntryId=");
		sb.append(systemEntryId);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the last table entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchBySystemEntryId_Last(
		long systemEntryId, OrderByComparator<TableEntry> orderByComparator) {

		int count = countBySystemEntryId(systemEntryId);

		if (count == 0) {
			return null;
		}

		List<TableEntry> list = findBySystemEntryId(
			systemEntryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] findBySystemEntryId_PrevAndNext(
			long tableEntryId, long systemEntryId,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = getBySystemEntryId_PrevAndNext(
				session, tableEntry, systemEntryId, orderByComparator, true);

			array[1] = tableEntry;

			array[2] = getBySystemEntryId_PrevAndNext(
				session, tableEntry, systemEntryId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TableEntry getBySystemEntryId_PrevAndNext(
		Session session, TableEntry tableEntry, long systemEntryId,
		OrderByComparator<TableEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

		sb.append(_FINDER_COLUMN_SYSTEMENTRYID_SYSTEMENTRYID_2);

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
			sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(systemEntryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the table entries where systemEntryId = &#63; from the database.
	 *
	 * @param systemEntryId the system entry ID
	 */
	@Override
	public void removeBySystemEntryId(long systemEntryId) {
		for (TableEntry tableEntry :
				findBySystemEntryId(
					systemEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(tableEntry);
		}
	}

	/**
	 * Returns the number of table entries where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @return the number of matching table entries
	 */
	@Override
	public int countBySystemEntryId(long systemEntryId) {
		FinderPath finderPath = _finderPathCountBySystemEntryId;

		Object[] finderArgs = new Object[] {systemEntryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_SYSTEMENTRYID_SYSTEMENTRYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(systemEntryId);

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

	private static final String _FINDER_COLUMN_SYSTEMENTRYID_SYSTEMENTRYID_2 =
		"tableEntry.systemEntryId = ?";

	private FinderPath _finderPathWithPaginationFindByDescription;
	private FinderPath _finderPathWithoutPaginationFindByDescription;
	private FinderPath _finderPathCountByDescription;

	/**
	 * Returns all the table entries where description = &#63;.
	 *
	 * @param description the description
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByDescription(String description) {
		return findByDescription(
			description, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries where description = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param description the description
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByDescription(
		String description, int start, int end) {

		return findByDescription(description, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where description = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param description the description
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByDescription(
		String description, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByDescription(
			description, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where description = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param description the description
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByDescription(
		String description, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		description = Objects.toString(description, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDescription;
				finderArgs = new Object[] {description};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDescription;
			finderArgs = new Object[] {
				description, start, end, orderByComparator
			};
		}

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if (!description.equals(tableEntry.getDescription())) {
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

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

			boolean bindDescription = false;

			if (description.isEmpty()) {
				sb.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				sb.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDescription) {
					queryPos.add(description);
				}

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Returns the first table entry in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByDescription_First(
			String description, OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByDescription_First(
			description, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("description=");
		sb.append(description);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the first table entry in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByDescription_First(
		String description, OrderByComparator<TableEntry> orderByComparator) {

		List<TableEntry> list = findByDescription(
			description, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table entry in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByDescription_Last(
			String description, OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByDescription_Last(
			description, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("description=");
		sb.append(description);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the last table entry in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByDescription_Last(
		String description, OrderByComparator<TableEntry> orderByComparator) {

		int count = countByDescription(description);

		if (count == 0) {
			return null;
		}

		List<TableEntry> list = findByDescription(
			description, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where description = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] findByDescription_PrevAndNext(
			long tableEntryId, String description,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		description = Objects.toString(description, "");

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = getByDescription_PrevAndNext(
				session, tableEntry, description, orderByComparator, true);

			array[1] = tableEntry;

			array[2] = getByDescription_PrevAndNext(
				session, tableEntry, description, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TableEntry getByDescription_PrevAndNext(
		Session session, TableEntry tableEntry, String description,
		OrderByComparator<TableEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

		boolean bindDescription = false;

		if (description.isEmpty()) {
			sb.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_3);
		}
		else {
			bindDescription = true;

			sb.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2);
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
			sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDescription) {
			queryPos.add(description);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the table entries where description = &#63; from the database.
	 *
	 * @param description the description
	 */
	@Override
	public void removeByDescription(String description) {
		for (TableEntry tableEntry :
				findByDescription(
					description, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tableEntry);
		}
	}

	/**
	 * Returns the number of table entries where description = &#63;.
	 *
	 * @param description the description
	 * @return the number of matching table entries
	 */
	@Override
	public int countByDescription(String description) {
		description = Objects.toString(description, "");

		FinderPath finderPath = _finderPathCountByDescription;

		Object[] finderArgs = new Object[] {description};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

			boolean bindDescription = false;

			if (description.isEmpty()) {
				sb.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				sb.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDescription) {
					queryPos.add(description);
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

	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2 =
		"CAST_CLOB_TEXT(tableEntry.description) = ?";

	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_3 =
		"(tableEntry.description IS NULL OR CAST_CLOB_TEXT(tableEntry.description) = '')";

	private FinderPath _finderPathWithPaginationFindByIsActive;
	private FinderPath _finderPathWithoutPaginationFindByIsActive;
	private FinderPath _finderPathCountByIsActive;

	/**
	 * Returns all the table entries where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByIsActive(boolean isActive) {
		return findByIsActive(
			isActive, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByIsActive(
		boolean isActive, int start, int end) {

		return findByIsActive(isActive, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByIsActive(
		boolean isActive, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByIsActive(isActive, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByIsActive(
		boolean isActive, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
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

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if (isActive != tableEntry.isIsActive()) {
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

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_ISACTIVE_ISACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isActive);

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Returns the first table entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByIsActive_First(
			boolean isActive, OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByIsActive_First(
			isActive, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isActive=");
		sb.append(isActive);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the first table entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByIsActive_First(
		boolean isActive, OrderByComparator<TableEntry> orderByComparator) {

		List<TableEntry> list = findByIsActive(
			isActive, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByIsActive_Last(
			boolean isActive, OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByIsActive_Last(
			isActive, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isActive=");
		sb.append(isActive);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the last table entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByIsActive_Last(
		boolean isActive, OrderByComparator<TableEntry> orderByComparator) {

		int count = countByIsActive(isActive);

		if (count == 0) {
			return null;
		}

		List<TableEntry> list = findByIsActive(
			isActive, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where isActive = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] findByIsActive_PrevAndNext(
			long tableEntryId, boolean isActive,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = getByIsActive_PrevAndNext(
				session, tableEntry, isActive, orderByComparator, true);

			array[1] = tableEntry;

			array[2] = getByIsActive_PrevAndNext(
				session, tableEntry, isActive, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TableEntry getByIsActive_PrevAndNext(
		Session session, TableEntry tableEntry, boolean isActive,
		OrderByComparator<TableEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

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
			sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isActive);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the table entries where isActive = &#63; from the database.
	 *
	 * @param isActive the is active
	 */
	@Override
	public void removeByIsActive(boolean isActive) {
		for (TableEntry tableEntry :
				findByIsActive(
					isActive, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tableEntry);
		}
	}

	/**
	 * Returns the number of table entries where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the number of matching table entries
	 */
	@Override
	public int countByIsActive(boolean isActive) {
		FinderPath finderPath = _finderPathCountByIsActive;

		Object[] finderArgs = new Object[] {isActive};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

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
		"tableEntry.isActive = ?";

	private FinderPath _finderPathWithPaginationFindByS_D;
	private FinderPath _finderPathWithoutPaginationFindByS_D;
	private FinderPath _finderPathCountByS_D;
	private FinderPath _finderPathWithPaginationCountByS_D;

	/**
	 * Returns all the table entries where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByS_D(
		long systemEntryId, String tableDatabase) {

		return findByS_D(
			systemEntryId, tableDatabase, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the table entries where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByS_D(
		long systemEntryId, String tableDatabase, int start, int end) {

		return findByS_D(systemEntryId, tableDatabase, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByS_D(
		long systemEntryId, String tableDatabase, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByS_D(
			systemEntryId, tableDatabase, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByS_D(
		long systemEntryId, String tableDatabase, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		tableDatabase = Objects.toString(tableDatabase, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByS_D;
				finderArgs = new Object[] {systemEntryId, tableDatabase};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByS_D;
			finderArgs = new Object[] {
				systemEntryId, tableDatabase, start, end, orderByComparator
			};
		}

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if ((systemEntryId != tableEntry.getSystemEntryId()) ||
						!tableDatabase.equals(tableEntry.getTableDatabase())) {

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

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_S_D_SYSTEMENTRYID_2);

			boolean bindTableDatabase = false;

			if (tableDatabase.isEmpty()) {
				sb.append(_FINDER_COLUMN_S_D_TABLEDATABASE_3);
			}
			else {
				bindTableDatabase = true;

				sb.append(_FINDER_COLUMN_S_D_TABLEDATABASE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(systemEntryId);

				if (bindTableDatabase) {
					queryPos.add(tableDatabase);
				}

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Returns the first table entry in the ordered set where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByS_D_First(
			long systemEntryId, String tableDatabase,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByS_D_First(
			systemEntryId, tableDatabase, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("systemEntryId=");
		sb.append(systemEntryId);

		sb.append(", tableDatabase=");
		sb.append(tableDatabase);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the first table entry in the ordered set where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByS_D_First(
		long systemEntryId, String tableDatabase,
		OrderByComparator<TableEntry> orderByComparator) {

		List<TableEntry> list = findByS_D(
			systemEntryId, tableDatabase, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table entry in the ordered set where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByS_D_Last(
			long systemEntryId, String tableDatabase,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByS_D_Last(
			systemEntryId, tableDatabase, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("systemEntryId=");
		sb.append(systemEntryId);

		sb.append(", tableDatabase=");
		sb.append(tableDatabase);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the last table entry in the ordered set where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByS_D_Last(
		long systemEntryId, String tableDatabase,
		OrderByComparator<TableEntry> orderByComparator) {

		int count = countByS_D(systemEntryId, tableDatabase);

		if (count == 0) {
			return null;
		}

		List<TableEntry> list = findByS_D(
			systemEntryId, tableDatabase, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] findByS_D_PrevAndNext(
			long tableEntryId, long systemEntryId, String tableDatabase,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		tableDatabase = Objects.toString(tableDatabase, "");

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = getByS_D_PrevAndNext(
				session, tableEntry, systemEntryId, tableDatabase,
				orderByComparator, true);

			array[1] = tableEntry;

			array[2] = getByS_D_PrevAndNext(
				session, tableEntry, systemEntryId, tableDatabase,
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

	protected TableEntry getByS_D_PrevAndNext(
		Session session, TableEntry tableEntry, long systemEntryId,
		String tableDatabase, OrderByComparator<TableEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

		sb.append(_FINDER_COLUMN_S_D_SYSTEMENTRYID_2);

		boolean bindTableDatabase = false;

		if (tableDatabase.isEmpty()) {
			sb.append(_FINDER_COLUMN_S_D_TABLEDATABASE_3);
		}
		else {
			bindTableDatabase = true;

			sb.append(_FINDER_COLUMN_S_D_TABLEDATABASE_2);
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
			sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(systemEntryId);

		if (bindTableDatabase) {
			queryPos.add(tableDatabase);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the table entries where systemEntryId = &#63; and tableDatabase = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabases the table databases
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByS_D(
		long systemEntryId, String[] tableDatabases) {

		return findByS_D(
			systemEntryId, tableDatabases, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the table entries where systemEntryId = &#63; and tableDatabase = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabases the table databases
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByS_D(
		long systemEntryId, String[] tableDatabases, int start, int end) {

		return findByS_D(systemEntryId, tableDatabases, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where systemEntryId = &#63; and tableDatabase = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabases the table databases
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByS_D(
		long systemEntryId, String[] tableDatabases, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByS_D(
			systemEntryId, tableDatabases, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where systemEntryId = &#63; and tableDatabase = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByS_D(
		long systemEntryId, String[] tableDatabases, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		if (tableDatabases == null) {
			tableDatabases = new String[0];
		}
		else if (tableDatabases.length > 1) {
			for (int i = 0; i < tableDatabases.length; i++) {
				tableDatabases[i] = Objects.toString(tableDatabases[i], "");
			}

			tableDatabases = ArrayUtil.sortedUnique(tableDatabases);
		}

		if (tableDatabases.length == 1) {
			return findByS_D(
				systemEntryId, tableDatabases[0], start, end,
				orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					systemEntryId, StringUtil.merge(tableDatabases)
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				systemEntryId, StringUtil.merge(tableDatabases), start, end,
				orderByComparator
			};
		}

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				_finderPathWithPaginationFindByS_D, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if ((systemEntryId != tableEntry.getSystemEntryId()) ||
						!ArrayUtil.contains(
							tableDatabases, tableEntry.getTableDatabase())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_S_D_SYSTEMENTRYID_2);

			if (tableDatabases.length > 0) {
				sb.append("(");

				for (int i = 0; i < tableDatabases.length; i++) {
					String tableDatabase = tableDatabases[i];

					if (tableDatabase.isEmpty()) {
						sb.append(_FINDER_COLUMN_S_D_TABLEDATABASE_3);
					}
					else {
						sb.append(_FINDER_COLUMN_S_D_TABLEDATABASE_2);
					}

					if ((i + 1) < tableDatabases.length) {
						sb.append(WHERE_OR);
					}
				}

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(systemEntryId);

				for (String tableDatabase : tableDatabases) {
					if ((tableDatabase != null) && !tableDatabase.isEmpty()) {
						queryPos.add(tableDatabase);
					}
				}

				list = (List<TableEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByS_D, finderArgs, list);
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
	 * Removes all the table entries where systemEntryId = &#63; and tableDatabase = &#63; from the database.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 */
	@Override
	public void removeByS_D(long systemEntryId, String tableDatabase) {
		for (TableEntry tableEntry :
				findByS_D(
					systemEntryId, tableDatabase, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(tableEntry);
		}
	}

	/**
	 * Returns the number of table entries where systemEntryId = &#63; and tableDatabase = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabase the table database
	 * @return the number of matching table entries
	 */
	@Override
	public int countByS_D(long systemEntryId, String tableDatabase) {
		tableDatabase = Objects.toString(tableDatabase, "");

		FinderPath finderPath = _finderPathCountByS_D;

		Object[] finderArgs = new Object[] {systemEntryId, tableDatabase};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_S_D_SYSTEMENTRYID_2);

			boolean bindTableDatabase = false;

			if (tableDatabase.isEmpty()) {
				sb.append(_FINDER_COLUMN_S_D_TABLEDATABASE_3);
			}
			else {
				bindTableDatabase = true;

				sb.append(_FINDER_COLUMN_S_D_TABLEDATABASE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(systemEntryId);

				if (bindTableDatabase) {
					queryPos.add(tableDatabase);
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

	/**
	 * Returns the number of table entries where systemEntryId = &#63; and tableDatabase = any &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableDatabases the table databases
	 * @return the number of matching table entries
	 */
	@Override
	public int countByS_D(long systemEntryId, String[] tableDatabases) {
		if (tableDatabases == null) {
			tableDatabases = new String[0];
		}
		else if (tableDatabases.length > 1) {
			for (int i = 0; i < tableDatabases.length; i++) {
				tableDatabases[i] = Objects.toString(tableDatabases[i], "");
			}

			tableDatabases = ArrayUtil.sortedUnique(tableDatabases);
		}

		Object[] finderArgs = new Object[] {
			systemEntryId, StringUtil.merge(tableDatabases)
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByS_D, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_S_D_SYSTEMENTRYID_2);

			if (tableDatabases.length > 0) {
				sb.append("(");

				for (int i = 0; i < tableDatabases.length; i++) {
					String tableDatabase = tableDatabases[i];

					if (tableDatabase.isEmpty()) {
						sb.append(_FINDER_COLUMN_S_D_TABLEDATABASE_3);
					}
					else {
						sb.append(_FINDER_COLUMN_S_D_TABLEDATABASE_2);
					}

					if ((i + 1) < tableDatabases.length) {
						sb.append(WHERE_OR);
					}
				}

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

				queryPos.add(systemEntryId);

				for (String tableDatabase : tableDatabases) {
					if ((tableDatabase != null) && !tableDatabase.isEmpty()) {
						queryPos.add(tableDatabase);
					}
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByS_D, finderArgs, count);
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

	private static final String _FINDER_COLUMN_S_D_SYSTEMENTRYID_2 =
		"tableEntry.systemEntryId = ? AND ";

	private static final String _FINDER_COLUMN_S_D_TABLEDATABASE_2 =
		"tableEntry.tableDatabase = ?";

	private static final String _FINDER_COLUMN_S_D_TABLEDATABASE_3 =
		"(tableEntry.tableDatabase IS NULL OR tableEntry.tableDatabase = '')";

	private FinderPath _finderPathWithPaginationFindByS_T;
	private FinderPath _finderPathWithoutPaginationFindByS_T;
	private FinderPath _finderPathCountByS_T;
	private FinderPath _finderPathWithPaginationCountByS_T;

	/**
	 * Returns all the table entries where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByS_T(long systemEntryId, String tableType) {
		return findByS_T(
			systemEntryId, tableType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the table entries where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByS_T(
		long systemEntryId, String tableType, int start, int end) {

		return findByS_T(systemEntryId, tableType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByS_T(
		long systemEntryId, String tableType, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByS_T(
			systemEntryId, tableType, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByS_T(
		long systemEntryId, String tableType, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		tableType = Objects.toString(tableType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByS_T;
				finderArgs = new Object[] {systemEntryId, tableType};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByS_T;
			finderArgs = new Object[] {
				systemEntryId, tableType, start, end, orderByComparator
			};
		}

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if ((systemEntryId != tableEntry.getSystemEntryId()) ||
						!tableType.equals(tableEntry.getTableType())) {

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

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_S_T_SYSTEMENTRYID_2);

			boolean bindTableType = false;

			if (tableType.isEmpty()) {
				sb.append(_FINDER_COLUMN_S_T_TABLETYPE_3);
			}
			else {
				bindTableType = true;

				sb.append(_FINDER_COLUMN_S_T_TABLETYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(systemEntryId);

				if (bindTableType) {
					queryPos.add(tableType);
				}

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Returns the first table entry in the ordered set where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByS_T_First(
			long systemEntryId, String tableType,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByS_T_First(
			systemEntryId, tableType, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("systemEntryId=");
		sb.append(systemEntryId);

		sb.append(", tableType=");
		sb.append(tableType);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the first table entry in the ordered set where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByS_T_First(
		long systemEntryId, String tableType,
		OrderByComparator<TableEntry> orderByComparator) {

		List<TableEntry> list = findByS_T(
			systemEntryId, tableType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table entry in the ordered set where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry
	 * @throws NoSuchTableEntryException if a matching table entry could not be found
	 */
	@Override
	public TableEntry findByS_T_Last(
			long systemEntryId, String tableType,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByS_T_Last(
			systemEntryId, tableType, orderByComparator);

		if (tableEntry != null) {
			return tableEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("systemEntryId=");
		sb.append(systemEntryId);

		sb.append(", tableType=");
		sb.append(tableType);

		sb.append("}");

		throw new NoSuchTableEntryException(sb.toString());
	}

	/**
	 * Returns the last table entry in the ordered set where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table entry, or <code>null</code> if a matching table entry could not be found
	 */
	@Override
	public TableEntry fetchByS_T_Last(
		long systemEntryId, String tableType,
		OrderByComparator<TableEntry> orderByComparator) {

		int count = countByS_T(systemEntryId, tableType);

		if (count == 0) {
			return null;
		}

		List<TableEntry> list = findByS_T(
			systemEntryId, tableType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table entries before and after the current table entry in the ordered set where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * @param tableEntryId the primary key of the current table entry
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry[] findByS_T_PrevAndNext(
			long tableEntryId, long systemEntryId, String tableType,
			OrderByComparator<TableEntry> orderByComparator)
		throws NoSuchTableEntryException {

		tableType = Objects.toString(tableType, "");

		TableEntry tableEntry = findByPrimaryKey(tableEntryId);

		Session session = null;

		try {
			session = openSession();

			TableEntry[] array = new TableEntryImpl[3];

			array[0] = getByS_T_PrevAndNext(
				session, tableEntry, systemEntryId, tableType,
				orderByComparator, true);

			array[1] = tableEntry;

			array[2] = getByS_T_PrevAndNext(
				session, tableEntry, systemEntryId, tableType,
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

	protected TableEntry getByS_T_PrevAndNext(
		Session session, TableEntry tableEntry, long systemEntryId,
		String tableType, OrderByComparator<TableEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

		sb.append(_FINDER_COLUMN_S_T_SYSTEMENTRYID_2);

		boolean bindTableType = false;

		if (tableType.isEmpty()) {
			sb.append(_FINDER_COLUMN_S_T_TABLETYPE_3);
		}
		else {
			bindTableType = true;

			sb.append(_FINDER_COLUMN_S_T_TABLETYPE_2);
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
			sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(systemEntryId);

		if (bindTableType) {
			queryPos.add(tableType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tableEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the table entries where systemEntryId = &#63; and tableType = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableTypes the table types
	 * @return the matching table entries
	 */
	@Override
	public List<TableEntry> findByS_T(long systemEntryId, String[] tableTypes) {
		return findByS_T(
			systemEntryId, tableTypes, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the table entries where systemEntryId = &#63; and tableType = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableTypes the table types
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of matching table entries
	 */
	@Override
	public List<TableEntry> findByS_T(
		long systemEntryId, String[] tableTypes, int start, int end) {

		return findByS_T(systemEntryId, tableTypes, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries where systemEntryId = &#63; and tableType = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableTypes the table types
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByS_T(
		long systemEntryId, String[] tableTypes, int start, int end,
		OrderByComparator<TableEntry> orderByComparator) {

		return findByS_T(
			systemEntryId, tableTypes, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries where systemEntryId = &#63; and tableType = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table entries
	 */
	@Override
	public List<TableEntry> findByS_T(
		long systemEntryId, String[] tableTypes, int start, int end,
		OrderByComparator<TableEntry> orderByComparator,
		boolean useFinderCache) {

		if (tableTypes == null) {
			tableTypes = new String[0];
		}
		else if (tableTypes.length > 1) {
			for (int i = 0; i < tableTypes.length; i++) {
				tableTypes[i] = Objects.toString(tableTypes[i], "");
			}

			tableTypes = ArrayUtil.sortedUnique(tableTypes);
		}

		if (tableTypes.length == 1) {
			return findByS_T(
				systemEntryId, tableTypes[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					systemEntryId, StringUtil.merge(tableTypes)
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				systemEntryId, StringUtil.merge(tableTypes), start, end,
				orderByComparator
			};
		}

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				_finderPathWithPaginationFindByS_T, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TableEntry tableEntry : list) {
					if ((systemEntryId != tableEntry.getSystemEntryId()) ||
						!ArrayUtil.contains(
							tableTypes, tableEntry.getTableType())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_TABLEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_S_T_SYSTEMENTRYID_2);

			if (tableTypes.length > 0) {
				sb.append("(");

				for (int i = 0; i < tableTypes.length; i++) {
					String tableType = tableTypes[i];

					if (tableType.isEmpty()) {
						sb.append(_FINDER_COLUMN_S_T_TABLETYPE_3);
					}
					else {
						sb.append(_FINDER_COLUMN_S_T_TABLETYPE_2);
					}

					if ((i + 1) < tableTypes.length) {
						sb.append(WHERE_OR);
					}
				}

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(systemEntryId);

				for (String tableType : tableTypes) {
					if ((tableType != null) && !tableType.isEmpty()) {
						queryPos.add(tableType);
					}
				}

				list = (List<TableEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByS_T, finderArgs, list);
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
	 * Removes all the table entries where systemEntryId = &#63; and tableType = &#63; from the database.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 */
	@Override
	public void removeByS_T(long systemEntryId, String tableType) {
		for (TableEntry tableEntry :
				findByS_T(
					systemEntryId, tableType, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(tableEntry);
		}
	}

	/**
	 * Returns the number of table entries where systemEntryId = &#63; and tableType = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableType the table type
	 * @return the number of matching table entries
	 */
	@Override
	public int countByS_T(long systemEntryId, String tableType) {
		tableType = Objects.toString(tableType, "");

		FinderPath finderPath = _finderPathCountByS_T;

		Object[] finderArgs = new Object[] {systemEntryId, tableType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_S_T_SYSTEMENTRYID_2);

			boolean bindTableType = false;

			if (tableType.isEmpty()) {
				sb.append(_FINDER_COLUMN_S_T_TABLETYPE_3);
			}
			else {
				bindTableType = true;

				sb.append(_FINDER_COLUMN_S_T_TABLETYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(systemEntryId);

				if (bindTableType) {
					queryPos.add(tableType);
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

	/**
	 * Returns the number of table entries where systemEntryId = &#63; and tableType = any &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param tableTypes the table types
	 * @return the number of matching table entries
	 */
	@Override
	public int countByS_T(long systemEntryId, String[] tableTypes) {
		if (tableTypes == null) {
			tableTypes = new String[0];
		}
		else if (tableTypes.length > 1) {
			for (int i = 0; i < tableTypes.length; i++) {
				tableTypes[i] = Objects.toString(tableTypes[i], "");
			}

			tableTypes = ArrayUtil.sortedUnique(tableTypes);
		}

		Object[] finderArgs = new Object[] {
			systemEntryId, StringUtil.merge(tableTypes)
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByS_T, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_TABLEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_S_T_SYSTEMENTRYID_2);

			if (tableTypes.length > 0) {
				sb.append("(");

				for (int i = 0; i < tableTypes.length; i++) {
					String tableType = tableTypes[i];

					if (tableType.isEmpty()) {
						sb.append(_FINDER_COLUMN_S_T_TABLETYPE_3);
					}
					else {
						sb.append(_FINDER_COLUMN_S_T_TABLETYPE_2);
					}

					if ((i + 1) < tableTypes.length) {
						sb.append(WHERE_OR);
					}
				}

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

				queryPos.add(systemEntryId);

				for (String tableType : tableTypes) {
					if ((tableType != null) && !tableType.isEmpty()) {
						queryPos.add(tableType);
					}
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByS_T, finderArgs, count);
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

	private static final String _FINDER_COLUMN_S_T_SYSTEMENTRYID_2 =
		"tableEntry.systemEntryId = ? AND ";

	private static final String _FINDER_COLUMN_S_T_TABLETYPE_2 =
		"tableEntry.tableType = ?";

	private static final String _FINDER_COLUMN_S_T_TABLETYPE_3 =
		"(tableEntry.tableType IS NULL OR tableEntry.tableType = '')";

	public TableEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TableEntry.class);

		setModelImplClass(TableEntryImpl.class);
		setModelPKClass(long.class);

		setTable(TableEntryTable.INSTANCE);
	}

	/**
	 * Caches the table entry in the entity cache if it is enabled.
	 *
	 * @param tableEntry the table entry
	 */
	@Override
	public void cacheResult(TableEntry tableEntry) {
		entityCache.putResult(
			TableEntryImpl.class, tableEntry.getPrimaryKey(), tableEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {tableEntry.getUuid(), tableEntry.getGroupId()},
			tableEntry);

		finderCache.putResult(
			_finderPathFetchByG_UT,
			new Object[] {tableEntry.getGroupId(), tableEntry.getUrlTitle()},
			tableEntry);

		finderCache.putResult(
			_finderPathFetchByURLTitle, new Object[] {tableEntry.getUrlTitle()},
			tableEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the table entries in the entity cache if it is enabled.
	 *
	 * @param tableEntries the table entries
	 */
	@Override
	public void cacheResult(List<TableEntry> tableEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (tableEntries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TableEntry tableEntry : tableEntries) {
			if (entityCache.getResult(
					TableEntryImpl.class, tableEntry.getPrimaryKey()) == null) {

				cacheResult(tableEntry);
			}
		}
	}

	/**
	 * Clears the cache for all table entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TableEntryImpl.class);

		finderCache.clearCache(TableEntryImpl.class);
	}

	/**
	 * Clears the cache for the table entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TableEntry tableEntry) {
		entityCache.removeResult(TableEntryImpl.class, tableEntry);
	}

	@Override
	public void clearCache(List<TableEntry> tableEntries) {
		for (TableEntry tableEntry : tableEntries) {
			entityCache.removeResult(TableEntryImpl.class, tableEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TableEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TableEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TableEntryModelImpl tableEntryModelImpl) {

		Object[] args = new Object[] {
			tableEntryModelImpl.getUuid(), tableEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, tableEntryModelImpl);

		args = new Object[] {
			tableEntryModelImpl.getGroupId(), tableEntryModelImpl.getUrlTitle()
		};

		finderCache.putResult(_finderPathCountByG_UT, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByG_UT, args, tableEntryModelImpl);

		args = new Object[] {tableEntryModelImpl.getUrlTitle()};

		finderCache.putResult(
			_finderPathCountByURLTitle, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByURLTitle, args, tableEntryModelImpl);
	}

	/**
	 * Creates a new table entry with the primary key. Does not add the table entry to the database.
	 *
	 * @param tableEntryId the primary key for the new table entry
	 * @return the new table entry
	 */
	@Override
	public TableEntry create(long tableEntryId) {
		TableEntry tableEntry = new TableEntryImpl();

		tableEntry.setNew(true);
		tableEntry.setPrimaryKey(tableEntryId);

		String uuid = _portalUUID.generate();

		tableEntry.setUuid(uuid);

		tableEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return tableEntry;
	}

	/**
	 * Removes the table entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tableEntryId the primary key of the table entry
	 * @return the table entry that was removed
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry remove(long tableEntryId)
		throws NoSuchTableEntryException {

		return remove((Serializable)tableEntryId);
	}

	/**
	 * Removes the table entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the table entry
	 * @return the table entry that was removed
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry remove(Serializable primaryKey)
		throws NoSuchTableEntryException {

		Session session = null;

		try {
			session = openSession();

			TableEntry tableEntry = (TableEntry)session.get(
				TableEntryImpl.class, primaryKey);

			if (tableEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTableEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(tableEntry);
		}
		catch (NoSuchTableEntryException noSuchEntityException) {
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
	protected TableEntry removeImpl(TableEntry tableEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tableEntry)) {
				tableEntry = (TableEntry)session.get(
					TableEntryImpl.class, tableEntry.getPrimaryKeyObj());
			}

			if (tableEntry != null) {
				session.delete(tableEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (tableEntry != null) {
			clearCache(tableEntry);
		}

		return tableEntry;
	}

	@Override
	public TableEntry updateImpl(TableEntry tableEntry) {
		boolean isNew = tableEntry.isNew();

		if (!(tableEntry instanceof TableEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(tableEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(tableEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in tableEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TableEntry implementation " +
					tableEntry.getClass());
		}

		TableEntryModelImpl tableEntryModelImpl =
			(TableEntryModelImpl)tableEntry;

		if (Validator.isNull(tableEntry.getUuid())) {
			String uuid = _portalUUID.generate();

			tableEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (tableEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				tableEntry.setCreateDate(date);
			}
			else {
				tableEntry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!tableEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				tableEntry.setModifiedDate(date);
			}
			else {
				tableEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(tableEntry);
			}
			else {
				tableEntry = (TableEntry)session.merge(tableEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TableEntryImpl.class, tableEntryModelImpl, false, true);

		cacheUniqueFindersCache(tableEntryModelImpl);

		if (isNew) {
			tableEntry.setNew(false);
		}

		tableEntry.resetOriginalValues();

		return tableEntry;
	}

	/**
	 * Returns the table entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the table entry
	 * @return the table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTableEntryException {

		TableEntry tableEntry = fetchByPrimaryKey(primaryKey);

		if (tableEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTableEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return tableEntry;
	}

	/**
	 * Returns the table entry with the primary key or throws a <code>NoSuchTableEntryException</code> if it could not be found.
	 *
	 * @param tableEntryId the primary key of the table entry
	 * @return the table entry
	 * @throws NoSuchTableEntryException if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry findByPrimaryKey(long tableEntryId)
		throws NoSuchTableEntryException {

		return findByPrimaryKey((Serializable)tableEntryId);
	}

	/**
	 * Returns the table entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tableEntryId the primary key of the table entry
	 * @return the table entry, or <code>null</code> if a table entry with the primary key could not be found
	 */
	@Override
	public TableEntry fetchByPrimaryKey(long tableEntryId) {
		return fetchByPrimaryKey((Serializable)tableEntryId);
	}

	/**
	 * Returns all the table entries.
	 *
	 * @return the table entries
	 */
	@Override
	public List<TableEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @return the range of table entries
	 */
	@Override
	public List<TableEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the table entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of table entries
	 */
	@Override
	public List<TableEntry> findAll(
		int start, int end, OrderByComparator<TableEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of table entries
	 * @param end the upper bound of the range of table entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of table entries
	 */
	@Override
	public List<TableEntry> findAll(
		int start, int end, OrderByComparator<TableEntry> orderByComparator,
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

		List<TableEntry> list = null;

		if (useFinderCache) {
			list = (List<TableEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TABLEENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TABLEENTRY;

				sql = sql.concat(TableEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TableEntry>)QueryUtil.list(
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
	 * Removes all the table entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TableEntry tableEntry : findAll()) {
			remove(tableEntry);
		}
	}

	/**
	 * Returns the number of table entries.
	 *
	 * @return the number of table entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TABLEENTRY);

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
		return "tableEntryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TABLEENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TableEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the table entry persistence.
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

		_finderPathWithPaginationFindByTableName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTableName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"tableName"}, true);

		_finderPathWithoutPaginationFindByTableName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTableName",
			new String[] {String.class.getName()}, new String[] {"tableName"},
			true);

		_finderPathCountByTableName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTableName",
			new String[] {String.class.getName()}, new String[] {"tableName"},
			false);

		_finderPathWithPaginationFindByTableFullName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTableFullName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"tableFullName"}, true);

		_finderPathWithoutPaginationFindByTableFullName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTableFullName",
			new String[] {String.class.getName()},
			new String[] {"tableFullName"}, true);

		_finderPathCountByTableFullName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTableFullName",
			new String[] {String.class.getName()},
			new String[] {"tableFullName"}, false);

		_finderPathWithPaginationFindByTableType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTableType",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"tableType"}, true);

		_finderPathWithoutPaginationFindByTableType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTableType",
			new String[] {String.class.getName()}, new String[] {"tableType"},
			true);

		_finderPathCountByTableType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTableType",
			new String[] {String.class.getName()}, new String[] {"tableType"},
			false);

		_finderPathWithPaginationFindByTableDatabase = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTableDatabase",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"tableDatabase"}, true);

		_finderPathWithoutPaginationFindByTableDatabase = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTableDatabase",
			new String[] {String.class.getName()},
			new String[] {"tableDatabase"}, true);

		_finderPathCountByTableDatabase = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTableDatabase",
			new String[] {String.class.getName()},
			new String[] {"tableDatabase"}, false);

		_finderPathWithPaginationCountByTableDatabase = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByTableDatabase",
			new String[] {String.class.getName()},
			new String[] {"tableDatabase"}, false);

		_finderPathWithPaginationFindBySystemEntryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySystemEntryId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"systemEntryId"}, true);

		_finderPathWithoutPaginationFindBySystemEntryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySystemEntryId",
			new String[] {Long.class.getName()}, new String[] {"systemEntryId"},
			true);

		_finderPathCountBySystemEntryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySystemEntryId",
			new String[] {Long.class.getName()}, new String[] {"systemEntryId"},
			false);

		_finderPathWithPaginationFindByDescription = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDescription",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"description"}, true);

		_finderPathWithoutPaginationFindByDescription = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDescription",
			new String[] {String.class.getName()}, new String[] {"description"},
			true);

		_finderPathCountByDescription = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDescription",
			new String[] {String.class.getName()}, new String[] {"description"},
			false);

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

		_finderPathWithPaginationFindByS_D = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_D",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"systemEntryId", "tableDatabase"}, true);

		_finderPathWithoutPaginationFindByS_D = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_D",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"systemEntryId", "tableDatabase"}, true);

		_finderPathCountByS_D = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_D",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"systemEntryId", "tableDatabase"}, false);

		_finderPathWithPaginationCountByS_D = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByS_D",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"systemEntryId", "tableDatabase"}, false);

		_finderPathWithPaginationFindByS_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"systemEntryId", "tableType"}, true);

		_finderPathWithoutPaginationFindByS_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_T",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"systemEntryId", "tableType"}, true);

		_finderPathCountByS_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_T",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"systemEntryId", "tableType"}, false);

		_finderPathWithPaginationCountByS_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByS_T",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"systemEntryId", "tableType"}, false);

		_setTableEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTableEntryUtilPersistence(null);

		entityCache.removeCache(TableEntryImpl.class.getName());
	}

	private void _setTableEntryUtilPersistence(
		TableEntryPersistence tableEntryPersistence) {

		try {
			Field field = TableEntryUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, tableEntryPersistence);
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

	private static final String _SQL_SELECT_TABLEENTRY =
		"SELECT tableEntry FROM TableEntry tableEntry";

	private static final String _SQL_SELECT_TABLEENTRY_WHERE =
		"SELECT tableEntry FROM TableEntry tableEntry WHERE ";

	private static final String _SQL_COUNT_TABLEENTRY =
		"SELECT COUNT(tableEntry) FROM TableEntry tableEntry";

	private static final String _SQL_COUNT_TABLEENTRY_WHERE =
		"SELECT COUNT(tableEntry) FROM TableEntry tableEntry WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"tableEntry.tableEntryId";

	private static final String _FILTER_SQL_SELECT_TABLEENTRY_WHERE =
		"SELECT DISTINCT {tableEntry.*} FROM MetaCds_TableEntry tableEntry WHERE ";

	private static final String
		_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {MetaCds_TableEntry.*} FROM (SELECT DISTINCT tableEntry.tableEntryId FROM MetaCds_TableEntry tableEntry WHERE ";

	private static final String
		_FILTER_SQL_SELECT_TABLEENTRY_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN MetaCds_TableEntry ON TEMP_TABLE.tableEntryId = MetaCds_TableEntry.tableEntryId";

	private static final String _FILTER_SQL_COUNT_TABLEENTRY_WHERE =
		"SELECT COUNT(DISTINCT tableEntry.tableEntryId) AS COUNT_VALUE FROM MetaCds_TableEntry tableEntry WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "tableEntry";

	private static final String _FILTER_ENTITY_TABLE = "MetaCds_TableEntry";

	private static final String _ORDER_BY_ENTITY_ALIAS = "tableEntry.";

	private static final String _ORDER_BY_ENTITY_TABLE = "MetaCds_TableEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TableEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TableEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TableEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private TableEntryModelArgumentsResolver _tableEntryModelArgumentsResolver;

}