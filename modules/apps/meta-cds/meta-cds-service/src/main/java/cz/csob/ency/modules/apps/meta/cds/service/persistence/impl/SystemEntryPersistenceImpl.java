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

import cz.csob.ency.modules.apps.meta.cds.exception.NoSuchSystemEntryException;
import cz.csob.ency.modules.apps.meta.cds.model.SystemEntry;
import cz.csob.ency.modules.apps.meta.cds.model.SystemEntryTable;
import cz.csob.ency.modules.apps.meta.cds.model.impl.SystemEntryImpl;
import cz.csob.ency.modules.apps.meta.cds.model.impl.SystemEntryModelImpl;
import cz.csob.ency.modules.apps.meta.cds.service.persistence.SystemEntryPersistence;
import cz.csob.ency.modules.apps.meta.cds.service.persistence.SystemEntryUtil;
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
 * The persistence implementation for the system entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author "Miroslav Čermák"
 * @generated
 */
@Component(service = {SystemEntryPersistence.class, BasePersistence.class})
public class SystemEntryPersistenceImpl
	extends BasePersistenceImpl<SystemEntry> implements SystemEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SystemEntryUtil</code> to access the system entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SystemEntryImpl.class.getName();

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
	 * Returns all the system entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the system entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
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

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if (!uuid.equals(systemEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Returns the first system entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByUuid_First(
			String uuid, OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByUuid_First(uuid, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the first system entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByUuid_First(
		String uuid, OrderByComparator<SystemEntry> orderByComparator) {

		List<SystemEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last system entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByUuid_Last(
			String uuid, OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the last system entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByUuid_Last(
		String uuid, OrderByComparator<SystemEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SystemEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where uuid = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry[] findByUuid_PrevAndNext(
			long systemEntryId, String uuid,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		uuid = Objects.toString(uuid, "");

		SystemEntry systemEntry = findByPrimaryKey(systemEntryId);

		Session session = null;

		try {
			session = openSession();

			SystemEntry[] array = new SystemEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, systemEntry, uuid, orderByComparator, true);

			array[1] = systemEntry;

			array[2] = getByUuid_PrevAndNext(
				session, systemEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SystemEntry getByUuid_PrevAndNext(
		Session session, SystemEntry systemEntry, String uuid,
		OrderByComparator<SystemEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
			sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(systemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SystemEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the system entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SystemEntry systemEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(systemEntry);
		}
	}

	/**
	 * Returns the number of system entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching system entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
		"systemEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(systemEntry.uuid IS NULL OR systemEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the system entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSystemEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByUUID_G(uuid, groupId);

		if (systemEntry == null) {
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

			throw new NoSuchSystemEntryException(sb.toString());
		}

		return systemEntry;
	}

	/**
	 * Returns the system entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the system entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByUUID_G(
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

		if (result instanceof SystemEntry) {
			SystemEntry systemEntry = (SystemEntry)result;

			if (!Objects.equals(uuid, systemEntry.getUuid()) ||
				(groupId != systemEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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

				List<SystemEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					SystemEntry systemEntry = list.get(0);

					result = systemEntry;

					cacheResult(systemEntry);
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
			return (SystemEntry)result;
		}
	}

	/**
	 * Removes the system entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the system entry that was removed
	 */
	@Override
	public SystemEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = findByUUID_G(uuid, groupId);

		return remove(systemEntry);
	}

	/**
	 * Returns the number of system entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching system entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
		"systemEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(systemEntry.uuid IS NULL OR systemEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"systemEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the system entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the system entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
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

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if (!uuid.equals(systemEntry.getUuid()) ||
						(companyId != systemEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Returns the first system entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the first system entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SystemEntry> orderByComparator) {

		List<SystemEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last system entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the last system entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SystemEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SystemEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry[] findByUuid_C_PrevAndNext(
			long systemEntryId, String uuid, long companyId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		uuid = Objects.toString(uuid, "");

		SystemEntry systemEntry = findByPrimaryKey(systemEntryId);

		Session session = null;

		try {
			session = openSession();

			SystemEntry[] array = new SystemEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, systemEntry, uuid, companyId, orderByComparator, true);

			array[1] = systemEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, systemEntry, uuid, companyId, orderByComparator,
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

	protected SystemEntry getByUuid_C_PrevAndNext(
		Session session, SystemEntry systemEntry, String uuid, long companyId,
		OrderByComparator<SystemEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
			sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(systemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SystemEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the system entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (SystemEntry systemEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(systemEntry);
		}
	}

	/**
	 * Returns the number of system entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching system entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
		"systemEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(systemEntry.uuid IS NULL OR systemEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"systemEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByC_S;
	private FinderPath _finderPathWithoutPaginationFindByC_S;
	private FinderPath _finderPathCountByC_S;
	private FinderPath _finderPathWithPaginationCountByC_S;

	/**
	 * Returns all the system entries where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findByC_S(long companyId, int status) {
		return findByC_S(
			companyId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the system entries where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByC_S(
		long companyId, int status, int start, int end) {

		return findByC_S(companyId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByC_S(
		long companyId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findByC_S(
			companyId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByC_S(
		long companyId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
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

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if ((companyId != systemEntry.getCompanyId()) ||
						(status != systemEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_S_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(status);

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Returns the first system entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByC_S_First(
			long companyId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByC_S_First(
			companyId, status, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the first system entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByC_S_First(
		long companyId, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		List<SystemEntry> list = findByC_S(
			companyId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last system entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByC_S_Last(
			long companyId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByC_S_Last(
			companyId, status, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the last system entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByC_S_Last(
		long companyId, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		int count = countByC_S(companyId, status);

		if (count == 0) {
			return null;
		}

		List<SystemEntry> list = findByC_S(
			companyId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry[] findByC_S_PrevAndNext(
			long systemEntryId, long companyId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = findByPrimaryKey(systemEntryId);

		Session session = null;

		try {
			session = openSession();

			SystemEntry[] array = new SystemEntryImpl[3];

			array[0] = getByC_S_PrevAndNext(
				session, systemEntry, companyId, status, orderByComparator,
				true);

			array[1] = systemEntry;

			array[2] = getByC_S_PrevAndNext(
				session, systemEntry, companyId, status, orderByComparator,
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

	protected SystemEntry getByC_S_PrevAndNext(
		Session session, SystemEntry systemEntry, long companyId, int status,
		OrderByComparator<SystemEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
			sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(systemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SystemEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the system entries where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findByC_S(long companyId, int[] statuses) {
		return findByC_S(
			companyId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the system entries where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByC_S(
		long companyId, int[] statuses, int start, int end) {

		return findByC_S(companyId, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByC_S(
		long companyId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findByC_S(
			companyId, statuses, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where companyId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByC_S(
		long companyId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
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

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				_finderPathWithPaginationFindByC_S, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if ((companyId != systemEntry.getCompanyId()) ||
						!ArrayUtil.contains(
							statuses, systemEntry.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Removes all the system entries where companyId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 */
	@Override
	public void removeByC_S(long companyId, int status) {
		for (SystemEntry systemEntry :
				findByC_S(
					companyId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(systemEntry);
		}
	}

	/**
	 * Returns the number of system entries where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching system entries
	 */
	@Override
	public int countByC_S(long companyId, int status) {
		FinderPath finderPath = _finderPathCountByC_S;

		Object[] finderArgs = new Object[] {companyId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
	 * Returns the number of system entries where companyId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @return the number of matching system entries
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

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
		"systemEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_S_STATUS_2 =
		"systemEntry.status = ?";

	private static final String _FINDER_COLUMN_C_S_STATUS_7 =
		"systemEntry.status IN (";

	private FinderPath _finderPathWithPaginationFindByG_S;
	private FinderPath _finderPathWithoutPaginationFindByG_S;
	private FinderPath _finderPathCountByG_S;
	private FinderPath _finderPathWithPaginationCountByG_S;

	/**
	 * Returns all the system entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_S(long groupId, int status) {
		return findByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the system entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_S(
		long groupId, int status, int start, int end) {

		return findByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findByG_S(groupId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
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

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if ((groupId != systemEntry.getGroupId()) ||
						(status != systemEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Returns the first system entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByG_S_First(
			long groupId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByG_S_First(
			groupId, status, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the first system entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		List<SystemEntry> list = findByG_S(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last system entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByG_S_Last(
			long groupId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByG_S_Last(
			groupId, status, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the last system entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		int count = countByG_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<SystemEntry> list = findByG_S(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry[] findByG_S_PrevAndNext(
			long systemEntryId, long groupId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = findByPrimaryKey(systemEntryId);

		Session session = null;

		try {
			session = openSession();

			SystemEntry[] array = new SystemEntryImpl[3];

			array[0] = getByG_S_PrevAndNext(
				session, systemEntry, groupId, status, orderByComparator, true);

			array[1] = systemEntry;

			array[2] = getByG_S_PrevAndNext(
				session, systemEntry, groupId, status, orderByComparator,
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

	protected SystemEntry getByG_S_PrevAndNext(
		Session session, SystemEntry systemEntry, long groupId, int status,
		OrderByComparator<SystemEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
			sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(systemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SystemEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the system entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByG_S(long groupId, int status) {
		return filterFindByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the system entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return filterFindByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_SYSTEMENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SystemEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SystemEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SystemEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(status);

			return (List<SystemEntry>)QueryUtil.list(
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
	 * Returns the system entries before and after the current system entry in the ordered set of system entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry[] filterFindByG_S_PrevAndNext(
			long systemEntryId, long groupId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_PrevAndNext(
				systemEntryId, groupId, status, orderByComparator);
		}

		SystemEntry systemEntry = findByPrimaryKey(systemEntryId);

		Session session = null;

		try {
			session = openSession();

			SystemEntry[] array = new SystemEntryImpl[3];

			array[0] = filterGetByG_S_PrevAndNext(
				session, systemEntry, groupId, status, orderByComparator, true);

			array[1] = systemEntry;

			array[2] = filterGetByG_S_PrevAndNext(
				session, systemEntry, groupId, status, orderByComparator,
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

	protected SystemEntry filterGetByG_S_PrevAndNext(
		Session session, SystemEntry systemEntry, long groupId, int status,
		OrderByComparator<SystemEntry> orderByComparator, boolean previous) {

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
			sb.append(_FILTER_SQL_SELECT_SYSTEMENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SystemEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SystemEntryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SystemEntryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(systemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SystemEntry> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the system entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByG_S(long groupId, int[] statuses) {
		return filterFindByG_S(
			groupId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the system entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByG_S(
		long groupId, int[] statuses, int start, int end) {

		return filterFindByG_S(groupId, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_SYSTEMENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_1);
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
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SystemEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SystemEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SystemEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			return (List<SystemEntry>)QueryUtil.list(
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
	 * Returns all the system entries where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_S(long groupId, int[] statuses) {
		return findByG_S(
			groupId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the system entries where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_S(
		long groupId, int[] statuses, int start, int end) {

		return findByG_S(groupId, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findByG_S(
			groupId, statuses, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
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

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				_finderPathWithPaginationFindByG_S, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if ((groupId != systemEntry.getGroupId()) ||
						!ArrayUtil.contains(
							statuses, systemEntry.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Removes all the system entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByG_S(long groupId, int status) {
		for (SystemEntry systemEntry :
				findByG_S(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(systemEntry);
		}
	}

	/**
	 * Returns the number of system entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching system entries
	 */
	@Override
	public int countByG_S(long groupId, int status) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
	 * Returns the number of system entries where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching system entries
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

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
	 * Returns the number of system entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching system entries that the user has permission to view
	 */
	@Override
	public int filterCountByG_S(long groupId, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S(groupId, status);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_SYSTEMENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SystemEntry.class.getName(),
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
	 * Returns the number of system entries that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching system entries that the user has permission to view
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

		sb.append(_FILTER_SQL_COUNT_SYSTEMENTRY_WHERE);

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
			sb.toString(), SystemEntry.class.getName(),
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
		"systemEntry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_STATUS_2 =
		"systemEntry.status = ?";

	private static final String _FINDER_COLUMN_G_S_STATUS_7 =
		"systemEntry.status IN (";

	private FinderPath _finderPathWithPaginationFindByC_U_S;
	private FinderPath _finderPathWithoutPaginationFindByC_U_S;
	private FinderPath _finderPathCountByC_U_S;
	private FinderPath _finderPathWithPaginationCountByC_U_S;

	/**
	 * Returns all the system entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findByC_U_S(
		long companyId, long userId, int status) {

		return findByC_U_S(
			companyId, userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the system entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end) {

		return findByC_U_S(companyId, userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findByC_U_S(
			companyId, userId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
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

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if ((companyId != systemEntry.getCompanyId()) ||
						(userId != systemEntry.getUserId()) ||
						(status != systemEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_U_S_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_C_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Returns the first system entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByC_U_S_First(
			long companyId, long userId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByC_U_S_First(
			companyId, userId, status, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
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

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the first system entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByC_U_S_First(
		long companyId, long userId, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		List<SystemEntry> list = findByC_U_S(
			companyId, userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last system entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByC_U_S_Last(
			long companyId, long userId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByC_U_S_Last(
			companyId, userId, status, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
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

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the last system entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByC_U_S_Last(
		long companyId, long userId, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		int count = countByC_U_S(companyId, userId, status);

		if (count == 0) {
			return null;
		}

		List<SystemEntry> list = findByC_U_S(
			companyId, userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry[] findByC_U_S_PrevAndNext(
			long systemEntryId, long companyId, long userId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = findByPrimaryKey(systemEntryId);

		Session session = null;

		try {
			session = openSession();

			SystemEntry[] array = new SystemEntryImpl[3];

			array[0] = getByC_U_S_PrevAndNext(
				session, systemEntry, companyId, userId, status,
				orderByComparator, true);

			array[1] = systemEntry;

			array[2] = getByC_U_S_PrevAndNext(
				session, systemEntry, companyId, userId, status,
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

	protected SystemEntry getByC_U_S_PrevAndNext(
		Session session, SystemEntry systemEntry, long companyId, long userId,
		int status, OrderByComparator<SystemEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
			sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(systemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SystemEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the system entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findByC_U_S(
		long companyId, long userId, int[] statuses) {

		return findByC_U_S(
			companyId, userId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the system entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end) {

		return findByC_U_S(companyId, userId, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findByC_U_S(
			companyId, userId, statuses, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where companyId = &#63; and userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
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

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				_finderPathWithPaginationFindByC_U_S, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if ((companyId != systemEntry.getCompanyId()) ||
						(userId != systemEntry.getUserId()) ||
						!ArrayUtil.contains(
							statuses, systemEntry.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userId);

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Removes all the system entries where companyId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByC_U_S(long companyId, long userId, int status) {
		for (SystemEntry systemEntry :
				findByC_U_S(
					companyId, userId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(systemEntry);
		}
	}

	/**
	 * Returns the number of system entries where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching system entries
	 */
	@Override
	public int countByC_U_S(long companyId, long userId, int status) {
		FinderPath finderPath = _finderPathCountByC_U_S;

		Object[] finderArgs = new Object[] {companyId, userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
	 * Returns the number of system entries where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching system entries
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

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
		"systemEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_U_S_USERID_2 =
		"systemEntry.userId = ? AND ";

	private static final String _FINDER_COLUMN_C_U_S_STATUS_2 =
		"systemEntry.status = ?";

	private static final String _FINDER_COLUMN_C_U_S_STATUS_7 =
		"systemEntry.status IN (";

	private FinderPath _finderPathWithPaginationFindByG_U_S;
	private FinderPath _finderPathWithoutPaginationFindByG_U_S;
	private FinderPath _finderPathCountByG_U_S;
	private FinderPath _finderPathWithPaginationCountByG_U_S;

	/**
	 * Returns all the system entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_U_S(
		long groupId, long userId, int status) {

		return findByG_U_S(
			groupId, userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the system entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return findByG_U_S(groupId, userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findByG_U_S(
			groupId, userId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
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

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if ((groupId != systemEntry.getGroupId()) ||
						(userId != systemEntry.getUserId()) ||
						(status != systemEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Returns the first system entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByG_U_S_First(
			long groupId, long userId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByG_U_S_First(
			groupId, userId, status, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
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

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the first system entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByG_U_S_First(
		long groupId, long userId, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		List<SystemEntry> list = findByG_U_S(
			groupId, userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last system entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByG_U_S_Last(
			long groupId, long userId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByG_U_S_Last(
			groupId, userId, status, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
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

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the last system entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByG_U_S_Last(
		long groupId, long userId, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		int count = countByG_U_S(groupId, userId, status);

		if (count == 0) {
			return null;
		}

		List<SystemEntry> list = findByG_U_S(
			groupId, userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry[] findByG_U_S_PrevAndNext(
			long systemEntryId, long groupId, long userId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = findByPrimaryKey(systemEntryId);

		Session session = null;

		try {
			session = openSession();

			SystemEntry[] array = new SystemEntryImpl[3];

			array[0] = getByG_U_S_PrevAndNext(
				session, systemEntry, groupId, userId, status,
				orderByComparator, true);

			array[1] = systemEntry;

			array[2] = getByG_U_S_PrevAndNext(
				session, systemEntry, groupId, userId, status,
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

	protected SystemEntry getByG_U_S_PrevAndNext(
		Session session, SystemEntry systemEntry, long groupId, long userId,
		int status, OrderByComparator<SystemEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
			sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(systemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SystemEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the system entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByG_U_S(
		long groupId, long userId, int status) {

		return filterFindByG_U_S(
			groupId, userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the system entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return filterFindByG_U_S(groupId, userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries that the user has permissions to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_SYSTEMENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SystemEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SystemEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SystemEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(userId);

			queryPos.add(status);

			return (List<SystemEntry>)QueryUtil.list(
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
	 * Returns the system entries before and after the current system entry in the ordered set of system entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry[] filterFindByG_U_S_PrevAndNext(
			long systemEntryId, long groupId, long userId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_U_S_PrevAndNext(
				systemEntryId, groupId, userId, status, orderByComparator);
		}

		SystemEntry systemEntry = findByPrimaryKey(systemEntryId);

		Session session = null;

		try {
			session = openSession();

			SystemEntry[] array = new SystemEntryImpl[3];

			array[0] = filterGetByG_U_S_PrevAndNext(
				session, systemEntry, groupId, userId, status,
				orderByComparator, true);

			array[1] = systemEntry;

			array[2] = filterGetByG_U_S_PrevAndNext(
				session, systemEntry, groupId, userId, status,
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

	protected SystemEntry filterGetByG_U_S_PrevAndNext(
		Session session, SystemEntry systemEntry, long groupId, long userId,
		int status, OrderByComparator<SystemEntry> orderByComparator,
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
			sb.append(_FILTER_SQL_SELECT_SYSTEMENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SystemEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SystemEntryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SystemEntryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(userId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(systemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SystemEntry> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the system entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses) {

		return filterFindByG_U_S(
			groupId, userId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the system entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end) {

		return filterFindByG_U_S(groupId, userId, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_SYSTEMENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_1);
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
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SystemEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SystemEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SystemEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(userId);

			return (List<SystemEntry>)QueryUtil.list(
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
	 * Returns all the system entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_U_S(
		long groupId, long userId, int[] statuses) {

		return findByG_U_S(
			groupId, userId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the system entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end) {

		return findByG_U_S(groupId, userId, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findByG_U_S(
			groupId, userId, statuses, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
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

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				_finderPathWithPaginationFindByG_U_S, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if ((groupId != systemEntry.getGroupId()) ||
						(userId != systemEntry.getUserId()) ||
						!ArrayUtil.contains(
							statuses, systemEntry.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Removes all the system entries where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByG_U_S(long groupId, long userId, int status) {
		for (SystemEntry systemEntry :
				findByG_U_S(
					groupId, userId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(systemEntry);
		}
	}

	/**
	 * Returns the number of system entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching system entries
	 */
	@Override
	public int countByG_U_S(long groupId, long userId, int status) {
		FinderPath finderPath = _finderPathCountByG_U_S;

		Object[] finderArgs = new Object[] {groupId, userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
	 * Returns the number of system entries where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching system entries
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

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
	 * Returns the number of system entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching system entries that the user has permission to view
	 */
	@Override
	public int filterCountByG_U_S(long groupId, long userId, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_U_S(groupId, userId, status);
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_FILTER_SQL_COUNT_SYSTEMENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SystemEntry.class.getName(),
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
	 * Returns the number of system entries that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching system entries that the user has permission to view
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

		sb.append(_FILTER_SQL_COUNT_SYSTEMENTRY_WHERE);

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
			sb.toString(), SystemEntry.class.getName(),
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
		"systemEntry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_U_S_USERID_2 =
		"systemEntry.userId = ? AND ";

	private static final String _FINDER_COLUMN_G_U_S_STATUS_2 =
		"systemEntry.status = ?";

	private static final String _FINDER_COLUMN_G_U_S_STATUS_7 =
		"systemEntry.status IN (";

	private FinderPath _finderPathWithPaginationFindByU_S;
	private FinderPath _finderPathWithoutPaginationFindByU_S;
	private FinderPath _finderPathCountByU_S;
	private FinderPath _finderPathWithPaginationCountByU_S;

	/**
	 * Returns all the system entries where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findByU_S(long userId, int status) {
		return findByU_S(
			userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the system entries where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByU_S(
		long userId, int status, int start, int end) {

		return findByU_S(userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findByU_S(userId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
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

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if ((userId != systemEntry.getUserId()) ||
						(status != systemEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(status);

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Returns the first system entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByU_S_First(
			long userId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByU_S_First(
			userId, status, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the first system entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByU_S_First(
		long userId, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		List<SystemEntry> list = findByU_S(
			userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last system entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByU_S_Last(
			long userId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByU_S_Last(
			userId, status, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the last system entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByU_S_Last(
		long userId, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		int count = countByU_S(userId, status);

		if (count == 0) {
			return null;
		}

		List<SystemEntry> list = findByU_S(
			userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry[] findByU_S_PrevAndNext(
			long systemEntryId, long userId, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = findByPrimaryKey(systemEntryId);

		Session session = null;

		try {
			session = openSession();

			SystemEntry[] array = new SystemEntryImpl[3];

			array[0] = getByU_S_PrevAndNext(
				session, systemEntry, userId, status, orderByComparator, true);

			array[1] = systemEntry;

			array[2] = getByU_S_PrevAndNext(
				session, systemEntry, userId, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SystemEntry getByU_S_PrevAndNext(
		Session session, SystemEntry systemEntry, long userId, int status,
		OrderByComparator<SystemEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
			sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(systemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SystemEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the system entries where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findByU_S(long userId, int[] statuses) {
		return findByU_S(
			userId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the system entries where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByU_S(
		long userId, int[] statuses, int start, int end) {

		return findByU_S(userId, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByU_S(
		long userId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findByU_S(userId, statuses, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByU_S(
		long userId, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
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

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				_finderPathWithPaginationFindByU_S, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if ((userId != systemEntry.getUserId()) ||
						!ArrayUtil.contains(
							statuses, systemEntry.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Removes all the system entries where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByU_S(long userId, int status) {
		for (SystemEntry systemEntry :
				findByU_S(
					userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(systemEntry);
		}
	}

	/**
	 * Returns the number of system entries where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching system entries
	 */
	@Override
	public int countByU_S(long userId, int status) {
		FinderPath finderPath = _finderPathCountByU_S;

		Object[] finderArgs = new Object[] {userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
	 * Returns the number of system entries where userId = &#63; and status = any &#63;.
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching system entries
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

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
		"systemEntry.userId = ? AND ";

	private static final String _FINDER_COLUMN_U_S_STATUS_2 =
		"systemEntry.status = ?";

	private static final String _FINDER_COLUMN_U_S_STATUS_7 =
		"systemEntry.status IN (";

	private FinderPath _finderPathWithPaginationFindByG_UT_ST;
	private FinderPath _finderPathWithoutPaginationFindByG_UT_ST;
	private FinderPath _finderPathCountByG_UT_ST;
	private FinderPath _finderPathWithPaginationCountByG_UT_ST;

	/**
	 * Returns all the system entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return findByG_UT_ST(
			groupId, urlTitle, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the system entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end) {

		return findByG_UT_ST(groupId, urlTitle, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findByG_UT_ST(
			groupId, urlTitle, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
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

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if ((groupId != systemEntry.getGroupId()) ||
						!urlTitle.equals(systemEntry.getUrlTitle()) ||
						(status != systemEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Returns the first system entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByG_UT_ST_First(
			long groupId, String urlTitle, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByG_UT_ST_First(
			groupId, urlTitle, status, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
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

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the first system entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByG_UT_ST_First(
		long groupId, String urlTitle, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		List<SystemEntry> list = findByG_UT_ST(
			groupId, urlTitle, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last system entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByG_UT_ST_Last(
			long groupId, String urlTitle, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByG_UT_ST_Last(
			groupId, urlTitle, status, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
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

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the last system entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByG_UT_ST_Last(
		long groupId, String urlTitle, int status,
		OrderByComparator<SystemEntry> orderByComparator) {

		int count = countByG_UT_ST(groupId, urlTitle, status);

		if (count == 0) {
			return null;
		}

		List<SystemEntry> list = findByG_UT_ST(
			groupId, urlTitle, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry[] findByG_UT_ST_PrevAndNext(
			long systemEntryId, long groupId, String urlTitle, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		urlTitle = Objects.toString(urlTitle, "");

		SystemEntry systemEntry = findByPrimaryKey(systemEntryId);

		Session session = null;

		try {
			session = openSession();

			SystemEntry[] array = new SystemEntryImpl[3];

			array[0] = getByG_UT_ST_PrevAndNext(
				session, systemEntry, groupId, urlTitle, status,
				orderByComparator, true);

			array[1] = systemEntry;

			array[2] = getByG_UT_ST_PrevAndNext(
				session, systemEntry, groupId, urlTitle, status,
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

	protected SystemEntry getByG_UT_ST_PrevAndNext(
		Session session, SystemEntry systemEntry, long groupId, String urlTitle,
		int status, OrderByComparator<SystemEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
			sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(systemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SystemEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the system entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return filterFindByG_UT_ST(
			groupId, urlTitle, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the system entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end) {

		return filterFindByG_UT_ST(groupId, urlTitle, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries that the user has permissions to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_SYSTEMENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_1);
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
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SystemEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SystemEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SystemEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			if (bindUrlTitle) {
				queryPos.add(urlTitle);
			}

			queryPos.add(status);

			return (List<SystemEntry>)QueryUtil.list(
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
	 * Returns the system entries before and after the current system entry in the ordered set of system entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry[] filterFindByG_UT_ST_PrevAndNext(
			long systemEntryId, long groupId, String urlTitle, int status,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_UT_ST_PrevAndNext(
				systemEntryId, groupId, urlTitle, status, orderByComparator);
		}

		urlTitle = Objects.toString(urlTitle, "");

		SystemEntry systemEntry = findByPrimaryKey(systemEntryId);

		Session session = null;

		try {
			session = openSession();

			SystemEntry[] array = new SystemEntryImpl[3];

			array[0] = filterGetByG_UT_ST_PrevAndNext(
				session, systemEntry, groupId, urlTitle, status,
				orderByComparator, true);

			array[1] = systemEntry;

			array[2] = filterGetByG_UT_ST_PrevAndNext(
				session, systemEntry, groupId, urlTitle, status,
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

	protected SystemEntry filterGetByG_UT_ST_PrevAndNext(
		Session session, SystemEntry systemEntry, long groupId, String urlTitle,
		int status, OrderByComparator<SystemEntry> orderByComparator,
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
			sb.append(_FILTER_SQL_SELECT_SYSTEMENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_1);
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
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SystemEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SystemEntryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SystemEntryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (bindUrlTitle) {
			queryPos.add(urlTitle);
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(systemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SystemEntry> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the system entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return filterFindByG_UT_ST(
			groupId, urlTitle, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the system entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end) {

		return filterFindByG_UT_ST(
			groupId, urlTitle, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_SYSTEMENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_1);
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
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SystemEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SystemEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SystemEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			if (bindUrlTitle) {
				queryPos.add(urlTitle);
			}

			return (List<SystemEntry>)QueryUtil.list(
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
	 * Returns all the system entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return findByG_UT_ST(
			groupId, urlTitle, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the system entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end) {

		return findByG_UT_ST(groupId, urlTitle, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findByG_UT_ST(
			groupId, urlTitle, statuses, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63; and urlTitle = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
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

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				_finderPathWithPaginationFindByG_UT_ST, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if ((groupId != systemEntry.getGroupId()) ||
						!urlTitle.equals(systemEntry.getUrlTitle()) ||
						!ArrayUtil.contains(
							statuses, systemEntry.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Removes all the system entries where groupId = &#63; and urlTitle = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 */
	@Override
	public void removeByG_UT_ST(long groupId, String urlTitle, int status) {
		for (SystemEntry systemEntry :
				findByG_UT_ST(
					groupId, urlTitle, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(systemEntry);
		}
	}

	/**
	 * Returns the number of system entries where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching system entries
	 */
	@Override
	public int countByG_UT_ST(long groupId, String urlTitle, int status) {
		urlTitle = Objects.toString(urlTitle, "");

		FinderPath finderPath = _finderPathCountByG_UT_ST;

		Object[] finderArgs = new Object[] {groupId, urlTitle, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
	 * Returns the number of system entries where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching system entries
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

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
	 * Returns the number of system entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching system entries that the user has permission to view
	 */
	@Override
	public int filterCountByG_UT_ST(long groupId, String urlTitle, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_UT_ST(groupId, urlTitle, status);
		}

		urlTitle = Objects.toString(urlTitle, "");

		StringBundler sb = new StringBundler(4);

		sb.append(_FILTER_SQL_COUNT_SYSTEMENTRY_WHERE);

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
			sb.toString(), SystemEntry.class.getName(),
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
	 * Returns the number of system entries that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching system entries that the user has permission to view
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

		sb.append(_FILTER_SQL_COUNT_SYSTEMENTRY_WHERE);

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
			sb.toString(), SystemEntry.class.getName(),
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
		"systemEntry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_UT_ST_URLTITLE_2 =
		"systemEntry.urlTitle = ? AND ";

	private static final String _FINDER_COLUMN_G_UT_ST_URLTITLE_3 =
		"(systemEntry.urlTitle IS NULL OR systemEntry.urlTitle = '') AND ";

	private static final String _FINDER_COLUMN_G_UT_ST_STATUS_2 =
		"systemEntry.status = ?";

	private static final String _FINDER_COLUMN_G_UT_ST_STATUS_7 =
		"systemEntry.status IN (";

	private FinderPath _finderPathFetchByG_UT;
	private FinderPath _finderPathCountByG_UT;

	/**
	 * Returns the system entry where groupId = &#63; and urlTitle = &#63; or throws a <code>NoSuchSystemEntryException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByG_UT(long groupId, String urlTitle)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByG_UT(groupId, urlTitle);

		if (systemEntry == null) {
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

			throw new NoSuchSystemEntryException(sb.toString());
		}

		return systemEntry;
	}

	/**
	 * Returns the system entry where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByG_UT(long groupId, String urlTitle) {
		return fetchByG_UT(groupId, urlTitle, true);
	}

	/**
	 * Returns the system entry where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByG_UT(
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

		if (result instanceof SystemEntry) {
			SystemEntry systemEntry = (SystemEntry)result;

			if ((groupId != systemEntry.getGroupId()) ||
				!Objects.equals(urlTitle, systemEntry.getUrlTitle())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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

				List<SystemEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByG_UT, finderArgs, list);
					}
				}
				else {
					SystemEntry systemEntry = list.get(0);

					result = systemEntry;

					cacheResult(systemEntry);
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
			return (SystemEntry)result;
		}
	}

	/**
	 * Removes the system entry where groupId = &#63; and urlTitle = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the system entry that was removed
	 */
	@Override
	public SystemEntry removeByG_UT(long groupId, String urlTitle)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = findByG_UT(groupId, urlTitle);

		return remove(systemEntry);
	}

	/**
	 * Returns the number of system entries where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the number of matching system entries
	 */
	@Override
	public int countByG_UT(long groupId, String urlTitle) {
		urlTitle = Objects.toString(urlTitle, "");

		FinderPath finderPath = _finderPathCountByG_UT;

		Object[] finderArgs = new Object[] {groupId, urlTitle};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
		"systemEntry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_UT_URLTITLE_2 =
		"systemEntry.urlTitle = ?";

	private static final String _FINDER_COLUMN_G_UT_URLTITLE_3 =
		"(systemEntry.urlTitle IS NULL OR systemEntry.urlTitle = '')";

	private FinderPath _finderPathFetchByURLTitle;
	private FinderPath _finderPathCountByURLTitle;

	/**
	 * Returns the system entry where urlTitle = &#63; or throws a <code>NoSuchSystemEntryException</code> if it could not be found.
	 *
	 * @param urlTitle the url title
	 * @return the matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByURLTitle(String urlTitle)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByURLTitle(urlTitle);

		if (systemEntry == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("urlTitle=");
			sb.append(urlTitle);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSystemEntryException(sb.toString());
		}

		return systemEntry;
	}

	/**
	 * Returns the system entry where urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param urlTitle the url title
	 * @return the matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByURLTitle(String urlTitle) {
		return fetchByURLTitle(urlTitle, true);
	}

	/**
	 * Returns the system entry where urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByURLTitle(
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

		if (result instanceof SystemEntry) {
			SystemEntry systemEntry = (SystemEntry)result;

			if (!Objects.equals(urlTitle, systemEntry.getUrlTitle())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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

				List<SystemEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByURLTitle, finderArgs, list);
					}
				}
				else {
					SystemEntry systemEntry = list.get(0);

					result = systemEntry;

					cacheResult(systemEntry);
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
			return (SystemEntry)result;
		}
	}

	/**
	 * Removes the system entry where urlTitle = &#63; from the database.
	 *
	 * @param urlTitle the url title
	 * @return the system entry that was removed
	 */
	@Override
	public SystemEntry removeByURLTitle(String urlTitle)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = findByURLTitle(urlTitle);

		return remove(systemEntry);
	}

	/**
	 * Returns the number of system entries where urlTitle = &#63;.
	 *
	 * @param urlTitle the url title
	 * @return the number of matching system entries
	 */
	@Override
	public int countByURLTitle(String urlTitle) {
		urlTitle = Objects.toString(urlTitle, "");

		FinderPath finderPath = _finderPathCountByURLTitle;

		Object[] finderArgs = new Object[] {urlTitle};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
		"systemEntry.urlTitle = ?";

	private static final String _FINDER_COLUMN_URLTITLE_URLTITLE_3 =
		"(systemEntry.urlTitle IS NULL OR systemEntry.urlTitle = '')";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the system entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the system entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
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

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if (groupId != systemEntry.getGroupId()) {
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

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Returns the first system entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByGroupId_First(
			long groupId, OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByGroupId_First(
			groupId, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the first system entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByGroupId_First(
		long groupId, OrderByComparator<SystemEntry> orderByComparator) {

		List<SystemEntry> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last system entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByGroupId_Last(
			long groupId, OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the last system entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByGroupId_Last(
		long groupId, OrderByComparator<SystemEntry> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<SystemEntry> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where groupId = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry[] findByGroupId_PrevAndNext(
			long systemEntryId, long groupId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = findByPrimaryKey(systemEntryId);

		Session session = null;

		try {
			session = openSession();

			SystemEntry[] array = new SystemEntryImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, systemEntry, groupId, orderByComparator, true);

			array[1] = systemEntry;

			array[2] = getByGroupId_PrevAndNext(
				session, systemEntry, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SystemEntry getByGroupId_PrevAndNext(
		Session session, SystemEntry systemEntry, long groupId,
		OrderByComparator<SystemEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
			sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(systemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SystemEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the system entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the system entries that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByGroupId(
		long groupId, int start, int end) {

		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_SYSTEMENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SystemEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SystemEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SystemEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			return (List<SystemEntry>)QueryUtil.list(
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
	 * Returns the system entries before and after the current system entry in the ordered set of system entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry[] filterFindByGroupId_PrevAndNext(
			long systemEntryId, long groupId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(
				systemEntryId, groupId, orderByComparator);
		}

		SystemEntry systemEntry = findByPrimaryKey(systemEntryId);

		Session session = null;

		try {
			session = openSession();

			SystemEntry[] array = new SystemEntryImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(
				session, systemEntry, groupId, orderByComparator, true);

			array[1] = systemEntry;

			array[2] = filterGetByGroupId_PrevAndNext(
				session, systemEntry, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SystemEntry filterGetByGroupId_PrevAndNext(
		Session session, SystemEntry systemEntry, long groupId,
		OrderByComparator<SystemEntry> orderByComparator, boolean previous) {

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
			sb.append(_FILTER_SQL_SELECT_SYSTEMENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SystemEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SystemEntryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SystemEntryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(systemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SystemEntry> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the system entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (SystemEntry systemEntry :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(systemEntry);
		}
	}

	/**
	 * Returns the number of system entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching system entries
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
	 * Returns the number of system entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching system entries that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler sb = new StringBundler(2);

		sb.append(_FILTER_SQL_COUNT_SYSTEMENTRY_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SystemEntry.class.getName(),
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
		"systemEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUserIdGroupId;
	private FinderPath _finderPathWithoutPaginationFindByUserIdGroupId;
	private FinderPath _finderPathCountByUserIdGroupId;

	/**
	 * Returns all the system entries where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findByUserIdGroupId(long userId, long groupId) {
		return findByUserIdGroupId(
			userId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the system entries where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end) {

		return findByUserIdGroupId(userId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findByUserIdGroupId(
			userId, groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
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

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if ((userId != systemEntry.getUserId()) ||
						(groupId != systemEntry.getGroupId())) {

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

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

			sb.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(groupId);

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Returns the first system entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByUserIdGroupId_First(
			long userId, long groupId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByUserIdGroupId_First(
			userId, groupId, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the first system entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByUserIdGroupId_First(
		long userId, long groupId,
		OrderByComparator<SystemEntry> orderByComparator) {

		List<SystemEntry> list = findByUserIdGroupId(
			userId, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last system entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByUserIdGroupId_Last(
			long userId, long groupId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByUserIdGroupId_Last(
			userId, groupId, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the last system entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByUserIdGroupId_Last(
		long userId, long groupId,
		OrderByComparator<SystemEntry> orderByComparator) {

		int count = countByUserIdGroupId(userId, groupId);

		if (count == 0) {
			return null;
		}

		List<SystemEntry> list = findByUserIdGroupId(
			userId, groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry[] findByUserIdGroupId_PrevAndNext(
			long systemEntryId, long userId, long groupId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = findByPrimaryKey(systemEntryId);

		Session session = null;

		try {
			session = openSession();

			SystemEntry[] array = new SystemEntryImpl[3];

			array[0] = getByUserIdGroupId_PrevAndNext(
				session, systemEntry, userId, groupId, orderByComparator, true);

			array[1] = systemEntry;

			array[2] = getByUserIdGroupId_PrevAndNext(
				session, systemEntry, userId, groupId, orderByComparator,
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

	protected SystemEntry getByUserIdGroupId_PrevAndNext(
		Session session, SystemEntry systemEntry, long userId, long groupId,
		OrderByComparator<SystemEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
			sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(systemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SystemEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the system entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByUserIdGroupId(
		long userId, long groupId) {

		return filterFindByUserIdGroupId(
			userId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the system entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end) {

		return filterFindByUserIdGroupId(userId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries that the user has permissions to view where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries that the user has permission to view
	 */
	@Override
	public List<SystemEntry> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_SYSTEMENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		sb.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SystemEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SystemEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SystemEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(userId);

			queryPos.add(groupId);

			return (List<SystemEntry>)QueryUtil.list(
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
	 * Returns the system entries before and after the current system entry in the ordered set of system entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry[] filterFindByUserIdGroupId_PrevAndNext(
			long systemEntryId, long userId, long groupId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByUserIdGroupId_PrevAndNext(
				systemEntryId, userId, groupId, orderByComparator);
		}

		SystemEntry systemEntry = findByPrimaryKey(systemEntryId);

		Session session = null;

		try {
			session = openSession();

			SystemEntry[] array = new SystemEntryImpl[3];

			array[0] = filterGetByUserIdGroupId_PrevAndNext(
				session, systemEntry, userId, groupId, orderByComparator, true);

			array[1] = systemEntry;

			array[2] = filterGetByUserIdGroupId_PrevAndNext(
				session, systemEntry, userId, groupId, orderByComparator,
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

	protected SystemEntry filterGetByUserIdGroupId_PrevAndNext(
		Session session, SystemEntry systemEntry, long userId, long groupId,
		OrderByComparator<SystemEntry> orderByComparator, boolean previous) {

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
			sb.append(_FILTER_SQL_SELECT_SYSTEMENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		sb.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SystemEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SystemEntryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SystemEntryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(userId);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(systemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SystemEntry> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the system entries where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 */
	@Override
	public void removeByUserIdGroupId(long userId, long groupId) {
		for (SystemEntry systemEntry :
				findByUserIdGroupId(
					userId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(systemEntry);
		}
	}

	/**
	 * Returns the number of system entries where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching system entries
	 */
	@Override
	public int countByUserIdGroupId(long userId, long groupId) {
		FinderPath finderPath = _finderPathCountByUserIdGroupId;

		Object[] finderArgs = new Object[] {userId, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
	 * Returns the number of system entries that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching system entries that the user has permission to view
	 */
	@Override
	public int filterCountByUserIdGroupId(long userId, long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByUserIdGroupId(userId, groupId);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_SYSTEMENTRY_WHERE);

		sb.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		sb.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SystemEntry.class.getName(),
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
		"systemEntry.userId = ? AND ";

	private static final String _FINDER_COLUMN_USERIDGROUPID_GROUPID_2 =
		"systemEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the system entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the system entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByUserId(
		long userId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByUserId(
		long userId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
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

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if (userId != systemEntry.getUserId()) {
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

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Returns the first system entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByUserId_First(
			long userId, OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByUserId_First(
			userId, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the first system entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByUserId_First(
		long userId, OrderByComparator<SystemEntry> orderByComparator) {

		List<SystemEntry> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last system entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByUserId_Last(
			long userId, OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByUserId_Last(userId, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the last system entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByUserId_Last(
		long userId, OrderByComparator<SystemEntry> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<SystemEntry> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where userId = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry[] findByUserId_PrevAndNext(
			long systemEntryId, long userId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = findByPrimaryKey(systemEntryId);

		Session session = null;

		try {
			session = openSession();

			SystemEntry[] array = new SystemEntryImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, systemEntry, userId, orderByComparator, true);

			array[1] = systemEntry;

			array[2] = getByUserId_PrevAndNext(
				session, systemEntry, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SystemEntry getByUserId_PrevAndNext(
		Session session, SystemEntry systemEntry, long userId,
		OrderByComparator<SystemEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
			sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(systemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SystemEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the system entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (SystemEntry systemEntry :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(systemEntry);
		}
	}

	/**
	 * Returns the number of system entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching system entries
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
		"systemEntry.userId = ?";

	private FinderPath _finderPathWithPaginationFindByCompanyId;
	private FinderPath _finderPathWithoutPaginationFindByCompanyId;
	private FinderPath _finderPathCountByCompanyId;

	/**
	 * Returns all the system entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findByCompanyId(long companyId) {
		return findByCompanyId(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the system entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByCompanyId(
		long companyId, int start, int end) {

		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findByCompanyId(companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
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

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if (companyId != systemEntry.getCompanyId()) {
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

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Returns the first system entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByCompanyId_First(
			long companyId, OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByCompanyId_First(
			companyId, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the first system entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByCompanyId_First(
		long companyId, OrderByComparator<SystemEntry> orderByComparator) {

		List<SystemEntry> list = findByCompanyId(
			companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last system entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByCompanyId_Last(
			long companyId, OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByCompanyId_Last(
			companyId, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the last system entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByCompanyId_Last(
		long companyId, OrderByComparator<SystemEntry> orderByComparator) {

		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<SystemEntry> list = findByCompanyId(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where companyId = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry[] findByCompanyId_PrevAndNext(
			long systemEntryId, long companyId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = findByPrimaryKey(systemEntryId);

		Session session = null;

		try {
			session = openSession();

			SystemEntry[] array = new SystemEntryImpl[3];

			array[0] = getByCompanyId_PrevAndNext(
				session, systemEntry, companyId, orderByComparator, true);

			array[1] = systemEntry;

			array[2] = getByCompanyId_PrevAndNext(
				session, systemEntry, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SystemEntry getByCompanyId_PrevAndNext(
		Session session, SystemEntry systemEntry, long companyId,
		OrderByComparator<SystemEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
			sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(systemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SystemEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the system entries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (SystemEntry systemEntry :
				findByCompanyId(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(systemEntry);
		}
	}

	/**
	 * Returns the number of system entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching system entries
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = _finderPathCountByCompanyId;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
		"systemEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBySystemEntryId;
	private FinderPath _finderPathWithoutPaginationFindBySystemEntryId;
	private FinderPath _finderPathCountBySystemEntryId;

	/**
	 * Returns all the system entries where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findBySystemEntryId(long systemEntryId) {
		return findBySystemEntryId(
			systemEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the system entries where systemEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findBySystemEntryId(
		long systemEntryId, int start, int end) {

		return findBySystemEntryId(systemEntryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where systemEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findBySystemEntryId(
		long systemEntryId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findBySystemEntryId(
			systemEntryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where systemEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemEntryId the system entry ID
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findBySystemEntryId(
		long systemEntryId, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
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

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if (systemEntryId != systemEntry.getSystemEntryId()) {
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

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_SYSTEMENTRYID_SYSTEMENTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(systemEntryId);

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Returns the first system entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findBySystemEntryId_First(
			long systemEntryId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchBySystemEntryId_First(
			systemEntryId, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("systemEntryId=");
		sb.append(systemEntryId);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the first system entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchBySystemEntryId_First(
		long systemEntryId, OrderByComparator<SystemEntry> orderByComparator) {

		List<SystemEntry> list = findBySystemEntryId(
			systemEntryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last system entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findBySystemEntryId_Last(
			long systemEntryId,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchBySystemEntryId_Last(
			systemEntryId, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("systemEntryId=");
		sb.append(systemEntryId);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the last system entry in the ordered set where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchBySystemEntryId_Last(
		long systemEntryId, OrderByComparator<SystemEntry> orderByComparator) {

		int count = countBySystemEntryId(systemEntryId);

		if (count == 0) {
			return null;
		}

		List<SystemEntry> list = findBySystemEntryId(
			systemEntryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the system entries where systemEntryId = &#63; from the database.
	 *
	 * @param systemEntryId the system entry ID
	 */
	@Override
	public void removeBySystemEntryId(long systemEntryId) {
		for (SystemEntry systemEntry :
				findBySystemEntryId(
					systemEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(systemEntry);
		}
	}

	/**
	 * Returns the number of system entries where systemEntryId = &#63;.
	 *
	 * @param systemEntryId the system entry ID
	 * @return the number of matching system entries
	 */
	@Override
	public int countBySystemEntryId(long systemEntryId) {
		FinderPath finderPath = _finderPathCountBySystemEntryId;

		Object[] finderArgs = new Object[] {systemEntryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
		"systemEntry.systemEntryId = ?";

	private FinderPath _finderPathWithPaginationFindBySystemCode;
	private FinderPath _finderPathWithoutPaginationFindBySystemCode;
	private FinderPath _finderPathCountBySystemCode;

	/**
	 * Returns all the system entries where systemCode = &#63;.
	 *
	 * @param systemCode the system code
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findBySystemCode(long systemCode) {
		return findBySystemCode(
			systemCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the system entries where systemCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemCode the system code
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findBySystemCode(
		long systemCode, int start, int end) {

		return findBySystemCode(systemCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where systemCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemCode the system code
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findBySystemCode(
		long systemCode, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findBySystemCode(
			systemCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where systemCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemCode the system code
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findBySystemCode(
		long systemCode, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySystemCode;
				finderArgs = new Object[] {systemCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySystemCode;
			finderArgs = new Object[] {
				systemCode, start, end, orderByComparator
			};
		}

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if (systemCode != systemEntry.getSystemCode()) {
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

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_SYSTEMCODE_SYSTEMCODE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(systemCode);

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Returns the first system entry in the ordered set where systemCode = &#63;.
	 *
	 * @param systemCode the system code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findBySystemCode_First(
			long systemCode, OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchBySystemCode_First(
			systemCode, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("systemCode=");
		sb.append(systemCode);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the first system entry in the ordered set where systemCode = &#63;.
	 *
	 * @param systemCode the system code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchBySystemCode_First(
		long systemCode, OrderByComparator<SystemEntry> orderByComparator) {

		List<SystemEntry> list = findBySystemCode(
			systemCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last system entry in the ordered set where systemCode = &#63;.
	 *
	 * @param systemCode the system code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findBySystemCode_Last(
			long systemCode, OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchBySystemCode_Last(
			systemCode, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("systemCode=");
		sb.append(systemCode);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the last system entry in the ordered set where systemCode = &#63;.
	 *
	 * @param systemCode the system code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchBySystemCode_Last(
		long systemCode, OrderByComparator<SystemEntry> orderByComparator) {

		int count = countBySystemCode(systemCode);

		if (count == 0) {
			return null;
		}

		List<SystemEntry> list = findBySystemCode(
			systemCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where systemCode = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param systemCode the system code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry[] findBySystemCode_PrevAndNext(
			long systemEntryId, long systemCode,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = findByPrimaryKey(systemEntryId);

		Session session = null;

		try {
			session = openSession();

			SystemEntry[] array = new SystemEntryImpl[3];

			array[0] = getBySystemCode_PrevAndNext(
				session, systemEntry, systemCode, orderByComparator, true);

			array[1] = systemEntry;

			array[2] = getBySystemCode_PrevAndNext(
				session, systemEntry, systemCode, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SystemEntry getBySystemCode_PrevAndNext(
		Session session, SystemEntry systemEntry, long systemCode,
		OrderByComparator<SystemEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

		sb.append(_FINDER_COLUMN_SYSTEMCODE_SYSTEMCODE_2);

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
			sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(systemCode);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(systemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SystemEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the system entries where systemCode = &#63; from the database.
	 *
	 * @param systemCode the system code
	 */
	@Override
	public void removeBySystemCode(long systemCode) {
		for (SystemEntry systemEntry :
				findBySystemCode(
					systemCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(systemEntry);
		}
	}

	/**
	 * Returns the number of system entries where systemCode = &#63;.
	 *
	 * @param systemCode the system code
	 * @return the number of matching system entries
	 */
	@Override
	public int countBySystemCode(long systemCode) {
		FinderPath finderPath = _finderPathCountBySystemCode;

		Object[] finderArgs = new Object[] {systemCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_SYSTEMCODE_SYSTEMCODE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(systemCode);

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

	private static final String _FINDER_COLUMN_SYSTEMCODE_SYSTEMCODE_2 =
		"systemEntry.systemCode = ?";

	private FinderPath _finderPathWithPaginationFindBySystemName;
	private FinderPath _finderPathWithoutPaginationFindBySystemName;
	private FinderPath _finderPathCountBySystemName;

	/**
	 * Returns all the system entries where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findBySystemName(String systemName) {
		return findBySystemName(
			systemName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the system entries where systemName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemName the system name
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findBySystemName(
		String systemName, int start, int end) {

		return findBySystemName(systemName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where systemName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemName the system name
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findBySystemName(
		String systemName, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findBySystemName(
			systemName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where systemName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param systemName the system name
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findBySystemName(
		String systemName, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
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

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if (!systemName.equals(systemEntry.getSystemName())) {
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

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Returns the first system entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findBySystemName_First(
			String systemName, OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchBySystemName_First(
			systemName, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("systemName=");
		sb.append(systemName);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the first system entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchBySystemName_First(
		String systemName, OrderByComparator<SystemEntry> orderByComparator) {

		List<SystemEntry> list = findBySystemName(
			systemName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last system entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findBySystemName_Last(
			String systemName, OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchBySystemName_Last(
			systemName, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("systemName=");
		sb.append(systemName);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the last system entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchBySystemName_Last(
		String systemName, OrderByComparator<SystemEntry> orderByComparator) {

		int count = countBySystemName(systemName);

		if (count == 0) {
			return null;
		}

		List<SystemEntry> list = findBySystemName(
			systemName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where systemName = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param systemName the system name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry[] findBySystemName_PrevAndNext(
			long systemEntryId, String systemName,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		systemName = Objects.toString(systemName, "");

		SystemEntry systemEntry = findByPrimaryKey(systemEntryId);

		Session session = null;

		try {
			session = openSession();

			SystemEntry[] array = new SystemEntryImpl[3];

			array[0] = getBySystemName_PrevAndNext(
				session, systemEntry, systemName, orderByComparator, true);

			array[1] = systemEntry;

			array[2] = getBySystemName_PrevAndNext(
				session, systemEntry, systemName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SystemEntry getBySystemName_PrevAndNext(
		Session session, SystemEntry systemEntry, String systemName,
		OrderByComparator<SystemEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
			sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(systemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SystemEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the system entries where systemName = &#63; from the database.
	 *
	 * @param systemName the system name
	 */
	@Override
	public void removeBySystemName(String systemName) {
		for (SystemEntry systemEntry :
				findBySystemName(
					systemName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(systemEntry);
		}
	}

	/**
	 * Returns the number of system entries where systemName = &#63;.
	 *
	 * @param systemName the system name
	 * @return the number of matching system entries
	 */
	@Override
	public int countBySystemName(String systemName) {
		systemName = Objects.toString(systemName, "");

		FinderPath finderPath = _finderPathCountBySystemName;

		Object[] finderArgs = new Object[] {systemName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
		"systemEntry.systemName = ?";

	private static final String _FINDER_COLUMN_SYSTEMNAME_SYSTEMNAME_3 =
		"(systemEntry.systemName IS NULL OR systemEntry.systemName = '')";

	private FinderPath _finderPathWithPaginationFindByIsSlaSigned;
	private FinderPath _finderPathWithoutPaginationFindByIsSlaSigned;
	private FinderPath _finderPathCountByIsSlaSigned;

	/**
	 * Returns all the system entries where isSlaSigned = &#63;.
	 *
	 * @param isSlaSigned the is sla signed
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findByIsSlaSigned(boolean isSlaSigned) {
		return findByIsSlaSigned(
			isSlaSigned, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the system entries where isSlaSigned = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isSlaSigned the is sla signed
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByIsSlaSigned(
		boolean isSlaSigned, int start, int end) {

		return findByIsSlaSigned(isSlaSigned, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where isSlaSigned = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isSlaSigned the is sla signed
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByIsSlaSigned(
		boolean isSlaSigned, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findByIsSlaSigned(
			isSlaSigned, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where isSlaSigned = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isSlaSigned the is sla signed
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByIsSlaSigned(
		boolean isSlaSigned, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByIsSlaSigned;
				finderArgs = new Object[] {isSlaSigned};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIsSlaSigned;
			finderArgs = new Object[] {
				isSlaSigned, start, end, orderByComparator
			};
		}

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if (isSlaSigned != systemEntry.isIsSlaSigned()) {
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

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_ISSLASIGNED_ISSLASIGNED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isSlaSigned);

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Returns the first system entry in the ordered set where isSlaSigned = &#63;.
	 *
	 * @param isSlaSigned the is sla signed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByIsSlaSigned_First(
			boolean isSlaSigned,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByIsSlaSigned_First(
			isSlaSigned, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isSlaSigned=");
		sb.append(isSlaSigned);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the first system entry in the ordered set where isSlaSigned = &#63;.
	 *
	 * @param isSlaSigned the is sla signed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByIsSlaSigned_First(
		boolean isSlaSigned, OrderByComparator<SystemEntry> orderByComparator) {

		List<SystemEntry> list = findByIsSlaSigned(
			isSlaSigned, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last system entry in the ordered set where isSlaSigned = &#63;.
	 *
	 * @param isSlaSigned the is sla signed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByIsSlaSigned_Last(
			boolean isSlaSigned,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByIsSlaSigned_Last(
			isSlaSigned, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isSlaSigned=");
		sb.append(isSlaSigned);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the last system entry in the ordered set where isSlaSigned = &#63;.
	 *
	 * @param isSlaSigned the is sla signed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByIsSlaSigned_Last(
		boolean isSlaSigned, OrderByComparator<SystemEntry> orderByComparator) {

		int count = countByIsSlaSigned(isSlaSigned);

		if (count == 0) {
			return null;
		}

		List<SystemEntry> list = findByIsSlaSigned(
			isSlaSigned, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where isSlaSigned = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param isSlaSigned the is sla signed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry[] findByIsSlaSigned_PrevAndNext(
			long systemEntryId, boolean isSlaSigned,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = findByPrimaryKey(systemEntryId);

		Session session = null;

		try {
			session = openSession();

			SystemEntry[] array = new SystemEntryImpl[3];

			array[0] = getByIsSlaSigned_PrevAndNext(
				session, systemEntry, isSlaSigned, orderByComparator, true);

			array[1] = systemEntry;

			array[2] = getByIsSlaSigned_PrevAndNext(
				session, systemEntry, isSlaSigned, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SystemEntry getByIsSlaSigned_PrevAndNext(
		Session session, SystemEntry systemEntry, boolean isSlaSigned,
		OrderByComparator<SystemEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

		sb.append(_FINDER_COLUMN_ISSLASIGNED_ISSLASIGNED_2);

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
			sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isSlaSigned);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(systemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SystemEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the system entries where isSlaSigned = &#63; from the database.
	 *
	 * @param isSlaSigned the is sla signed
	 */
	@Override
	public void removeByIsSlaSigned(boolean isSlaSigned) {
		for (SystemEntry systemEntry :
				findByIsSlaSigned(
					isSlaSigned, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(systemEntry);
		}
	}

	/**
	 * Returns the number of system entries where isSlaSigned = &#63;.
	 *
	 * @param isSlaSigned the is sla signed
	 * @return the number of matching system entries
	 */
	@Override
	public int countByIsSlaSigned(boolean isSlaSigned) {
		FinderPath finderPath = _finderPathCountByIsSlaSigned;

		Object[] finderArgs = new Object[] {isSlaSigned};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_ISSLASIGNED_ISSLASIGNED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isSlaSigned);

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

	private static final String _FINDER_COLUMN_ISSLASIGNED_ISSLASIGNED_2 =
		"systemEntry.isSlaSigned = ?";

	private FinderPath _finderPathWithPaginationFindByIsSelfBi;
	private FinderPath _finderPathWithoutPaginationFindByIsSelfBi;
	private FinderPath _finderPathCountByIsSelfBi;

	/**
	 * Returns all the system entries where isSelfBi = &#63;.
	 *
	 * @param isSelfBi the is self bi
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findByIsSelfBi(boolean isSelfBi) {
		return findByIsSelfBi(
			isSelfBi, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the system entries where isSelfBi = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isSelfBi the is self bi
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByIsSelfBi(
		boolean isSelfBi, int start, int end) {

		return findByIsSelfBi(isSelfBi, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where isSelfBi = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isSelfBi the is self bi
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByIsSelfBi(
		boolean isSelfBi, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findByIsSelfBi(isSelfBi, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where isSelfBi = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isSelfBi the is self bi
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByIsSelfBi(
		boolean isSelfBi, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByIsSelfBi;
				finderArgs = new Object[] {isSelfBi};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIsSelfBi;
			finderArgs = new Object[] {isSelfBi, start, end, orderByComparator};
		}

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if (isSelfBi != systemEntry.isIsSelfBi()) {
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

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_ISSELFBI_ISSELFBI_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isSelfBi);

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Returns the first system entry in the ordered set where isSelfBi = &#63;.
	 *
	 * @param isSelfBi the is self bi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByIsSelfBi_First(
			boolean isSelfBi, OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByIsSelfBi_First(
			isSelfBi, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isSelfBi=");
		sb.append(isSelfBi);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the first system entry in the ordered set where isSelfBi = &#63;.
	 *
	 * @param isSelfBi the is self bi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByIsSelfBi_First(
		boolean isSelfBi, OrderByComparator<SystemEntry> orderByComparator) {

		List<SystemEntry> list = findByIsSelfBi(
			isSelfBi, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last system entry in the ordered set where isSelfBi = &#63;.
	 *
	 * @param isSelfBi the is self bi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByIsSelfBi_Last(
			boolean isSelfBi, OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByIsSelfBi_Last(
			isSelfBi, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isSelfBi=");
		sb.append(isSelfBi);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the last system entry in the ordered set where isSelfBi = &#63;.
	 *
	 * @param isSelfBi the is self bi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByIsSelfBi_Last(
		boolean isSelfBi, OrderByComparator<SystemEntry> orderByComparator) {

		int count = countByIsSelfBi(isSelfBi);

		if (count == 0) {
			return null;
		}

		List<SystemEntry> list = findByIsSelfBi(
			isSelfBi, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where isSelfBi = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param isSelfBi the is self bi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry[] findByIsSelfBi_PrevAndNext(
			long systemEntryId, boolean isSelfBi,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = findByPrimaryKey(systemEntryId);

		Session session = null;

		try {
			session = openSession();

			SystemEntry[] array = new SystemEntryImpl[3];

			array[0] = getByIsSelfBi_PrevAndNext(
				session, systemEntry, isSelfBi, orderByComparator, true);

			array[1] = systemEntry;

			array[2] = getByIsSelfBi_PrevAndNext(
				session, systemEntry, isSelfBi, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SystemEntry getByIsSelfBi_PrevAndNext(
		Session session, SystemEntry systemEntry, boolean isSelfBi,
		OrderByComparator<SystemEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

		sb.append(_FINDER_COLUMN_ISSELFBI_ISSELFBI_2);

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
			sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isSelfBi);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(systemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SystemEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the system entries where isSelfBi = &#63; from the database.
	 *
	 * @param isSelfBi the is self bi
	 */
	@Override
	public void removeByIsSelfBi(boolean isSelfBi) {
		for (SystemEntry systemEntry :
				findByIsSelfBi(
					isSelfBi, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(systemEntry);
		}
	}

	/**
	 * Returns the number of system entries where isSelfBi = &#63;.
	 *
	 * @param isSelfBi the is self bi
	 * @return the number of matching system entries
	 */
	@Override
	public int countByIsSelfBi(boolean isSelfBi) {
		FinderPath finderPath = _finderPathCountByIsSelfBi;

		Object[] finderArgs = new Object[] {isSelfBi};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_ISSELFBI_ISSELFBI_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isSelfBi);

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

	private static final String _FINDER_COLUMN_ISSELFBI_ISSELFBI_2 =
		"systemEntry.isSelfBi = ?";

	private FinderPath _finderPathWithPaginationFindByIsActive;
	private FinderPath _finderPathWithoutPaginationFindByIsActive;
	private FinderPath _finderPathCountByIsActive;

	/**
	 * Returns all the system entries where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the matching system entries
	 */
	@Override
	public List<SystemEntry> findByIsActive(boolean isActive) {
		return findByIsActive(
			isActive, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the system entries where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByIsActive(
		boolean isActive, int start, int end) {

		return findByIsActive(isActive, start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByIsActive(
		boolean isActive, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator) {

		return findByIsActive(isActive, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching system entries
	 */
	@Override
	public List<SystemEntry> findByIsActive(
		boolean isActive, int start, int end,
		OrderByComparator<SystemEntry> orderByComparator,
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

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SystemEntry systemEntry : list) {
					if (isActive != systemEntry.isIsActive()) {
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

			sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_ISACTIVE_ISACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isActive);

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Returns the first system entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByIsActive_First(
			boolean isActive, OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByIsActive_First(
			isActive, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isActive=");
		sb.append(isActive);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the first system entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByIsActive_First(
		boolean isActive, OrderByComparator<SystemEntry> orderByComparator) {

		List<SystemEntry> list = findByIsActive(
			isActive, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last system entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry
	 * @throws NoSuchSystemEntryException if a matching system entry could not be found
	 */
	@Override
	public SystemEntry findByIsActive_Last(
			boolean isActive, OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByIsActive_Last(
			isActive, orderByComparator);

		if (systemEntry != null) {
			return systemEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isActive=");
		sb.append(isActive);

		sb.append("}");

		throw new NoSuchSystemEntryException(sb.toString());
	}

	/**
	 * Returns the last system entry in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching system entry, or <code>null</code> if a matching system entry could not be found
	 */
	@Override
	public SystemEntry fetchByIsActive_Last(
		boolean isActive, OrderByComparator<SystemEntry> orderByComparator) {

		int count = countByIsActive(isActive);

		if (count == 0) {
			return null;
		}

		List<SystemEntry> list = findByIsActive(
			isActive, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the system entries before and after the current system entry in the ordered set where isActive = &#63;.
	 *
	 * @param systemEntryId the primary key of the current system entry
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry[] findByIsActive_PrevAndNext(
			long systemEntryId, boolean isActive,
			OrderByComparator<SystemEntry> orderByComparator)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = findByPrimaryKey(systemEntryId);

		Session session = null;

		try {
			session = openSession();

			SystemEntry[] array = new SystemEntryImpl[3];

			array[0] = getByIsActive_PrevAndNext(
				session, systemEntry, isActive, orderByComparator, true);

			array[1] = systemEntry;

			array[2] = getByIsActive_PrevAndNext(
				session, systemEntry, isActive, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SystemEntry getByIsActive_PrevAndNext(
		Session session, SystemEntry systemEntry, boolean isActive,
		OrderByComparator<SystemEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SYSTEMENTRY_WHERE);

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
			sb.append(SystemEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isActive);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(systemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SystemEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the system entries where isActive = &#63; from the database.
	 *
	 * @param isActive the is active
	 */
	@Override
	public void removeByIsActive(boolean isActive) {
		for (SystemEntry systemEntry :
				findByIsActive(
					isActive, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(systemEntry);
		}
	}

	/**
	 * Returns the number of system entries where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the number of matching system entries
	 */
	@Override
	public int countByIsActive(boolean isActive) {
		FinderPath finderPath = _finderPathCountByIsActive;

		Object[] finderArgs = new Object[] {isActive};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SYSTEMENTRY_WHERE);

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
		"systemEntry.isActive = ?";

	public SystemEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("role", "role_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SystemEntry.class);

		setModelImplClass(SystemEntryImpl.class);
		setModelPKClass(long.class);

		setTable(SystemEntryTable.INSTANCE);
	}

	/**
	 * Caches the system entry in the entity cache if it is enabled.
	 *
	 * @param systemEntry the system entry
	 */
	@Override
	public void cacheResult(SystemEntry systemEntry) {
		entityCache.putResult(
			SystemEntryImpl.class, systemEntry.getPrimaryKey(), systemEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {systemEntry.getUuid(), systemEntry.getGroupId()},
			systemEntry);

		finderCache.putResult(
			_finderPathFetchByG_UT,
			new Object[] {systemEntry.getGroupId(), systemEntry.getUrlTitle()},
			systemEntry);

		finderCache.putResult(
			_finderPathFetchByURLTitle,
			new Object[] {systemEntry.getUrlTitle()}, systemEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the system entries in the entity cache if it is enabled.
	 *
	 * @param systemEntries the system entries
	 */
	@Override
	public void cacheResult(List<SystemEntry> systemEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (systemEntries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SystemEntry systemEntry : systemEntries) {
			if (entityCache.getResult(
					SystemEntryImpl.class, systemEntry.getPrimaryKey()) ==
						null) {

				cacheResult(systemEntry);
			}
		}
	}

	/**
	 * Clears the cache for all system entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SystemEntryImpl.class);

		finderCache.clearCache(SystemEntryImpl.class);
	}

	/**
	 * Clears the cache for the system entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SystemEntry systemEntry) {
		entityCache.removeResult(SystemEntryImpl.class, systemEntry);
	}

	@Override
	public void clearCache(List<SystemEntry> systemEntries) {
		for (SystemEntry systemEntry : systemEntries) {
			entityCache.removeResult(SystemEntryImpl.class, systemEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SystemEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SystemEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SystemEntryModelImpl systemEntryModelImpl) {

		Object[] args = new Object[] {
			systemEntryModelImpl.getUuid(), systemEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, systemEntryModelImpl);

		args = new Object[] {
			systemEntryModelImpl.getGroupId(),
			systemEntryModelImpl.getUrlTitle()
		};

		finderCache.putResult(_finderPathCountByG_UT, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByG_UT, args, systemEntryModelImpl);

		args = new Object[] {systemEntryModelImpl.getUrlTitle()};

		finderCache.putResult(
			_finderPathCountByURLTitle, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByURLTitle, args, systemEntryModelImpl);
	}

	/**
	 * Creates a new system entry with the primary key. Does not add the system entry to the database.
	 *
	 * @param systemEntryId the primary key for the new system entry
	 * @return the new system entry
	 */
	@Override
	public SystemEntry create(long systemEntryId) {
		SystemEntry systemEntry = new SystemEntryImpl();

		systemEntry.setNew(true);
		systemEntry.setPrimaryKey(systemEntryId);

		String uuid = _portalUUID.generate();

		systemEntry.setUuid(uuid);

		systemEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return systemEntry;
	}

	/**
	 * Removes the system entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param systemEntryId the primary key of the system entry
	 * @return the system entry that was removed
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry remove(long systemEntryId)
		throws NoSuchSystemEntryException {

		return remove((Serializable)systemEntryId);
	}

	/**
	 * Removes the system entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the system entry
	 * @return the system entry that was removed
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry remove(Serializable primaryKey)
		throws NoSuchSystemEntryException {

		Session session = null;

		try {
			session = openSession();

			SystemEntry systemEntry = (SystemEntry)session.get(
				SystemEntryImpl.class, primaryKey);

			if (systemEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSystemEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(systemEntry);
		}
		catch (NoSuchSystemEntryException noSuchEntityException) {
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
	protected SystemEntry removeImpl(SystemEntry systemEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(systemEntry)) {
				systemEntry = (SystemEntry)session.get(
					SystemEntryImpl.class, systemEntry.getPrimaryKeyObj());
			}

			if (systemEntry != null) {
				session.delete(systemEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (systemEntry != null) {
			clearCache(systemEntry);
		}

		return systemEntry;
	}

	@Override
	public SystemEntry updateImpl(SystemEntry systemEntry) {
		boolean isNew = systemEntry.isNew();

		if (!(systemEntry instanceof SystemEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(systemEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(systemEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in systemEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SystemEntry implementation " +
					systemEntry.getClass());
		}

		SystemEntryModelImpl systemEntryModelImpl =
			(SystemEntryModelImpl)systemEntry;

		if (Validator.isNull(systemEntry.getUuid())) {
			String uuid = _portalUUID.generate();

			systemEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (systemEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				systemEntry.setCreateDate(date);
			}
			else {
				systemEntry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!systemEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				systemEntry.setModifiedDate(date);
			}
			else {
				systemEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(systemEntry);
			}
			else {
				systemEntry = (SystemEntry)session.merge(systemEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SystemEntryImpl.class, systemEntryModelImpl, false, true);

		cacheUniqueFindersCache(systemEntryModelImpl);

		if (isNew) {
			systemEntry.setNew(false);
		}

		systemEntry.resetOriginalValues();

		return systemEntry;
	}

	/**
	 * Returns the system entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the system entry
	 * @return the system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSystemEntryException {

		SystemEntry systemEntry = fetchByPrimaryKey(primaryKey);

		if (systemEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSystemEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return systemEntry;
	}

	/**
	 * Returns the system entry with the primary key or throws a <code>NoSuchSystemEntryException</code> if it could not be found.
	 *
	 * @param systemEntryId the primary key of the system entry
	 * @return the system entry
	 * @throws NoSuchSystemEntryException if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry findByPrimaryKey(long systemEntryId)
		throws NoSuchSystemEntryException {

		return findByPrimaryKey((Serializable)systemEntryId);
	}

	/**
	 * Returns the system entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param systemEntryId the primary key of the system entry
	 * @return the system entry, or <code>null</code> if a system entry with the primary key could not be found
	 */
	@Override
	public SystemEntry fetchByPrimaryKey(long systemEntryId) {
		return fetchByPrimaryKey((Serializable)systemEntryId);
	}

	/**
	 * Returns all the system entries.
	 *
	 * @return the system entries
	 */
	@Override
	public List<SystemEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the system entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @return the range of system entries
	 */
	@Override
	public List<SystemEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the system entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of system entries
	 */
	@Override
	public List<SystemEntry> findAll(
		int start, int end, OrderByComparator<SystemEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the system entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SystemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of system entries
	 * @param end the upper bound of the range of system entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of system entries
	 */
	@Override
	public List<SystemEntry> findAll(
		int start, int end, OrderByComparator<SystemEntry> orderByComparator,
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

		List<SystemEntry> list = null;

		if (useFinderCache) {
			list = (List<SystemEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SYSTEMENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SYSTEMENTRY;

				sql = sql.concat(SystemEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SystemEntry>)QueryUtil.list(
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
	 * Removes all the system entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SystemEntry systemEntry : findAll()) {
			remove(systemEntry);
		}
	}

	/**
	 * Returns the number of system entries.
	 *
	 * @return the number of system entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SYSTEMENTRY);

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
		return "systemEntryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SYSTEMENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SystemEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the system entry persistence.
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

		_finderPathWithPaginationFindBySystemCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySystemCode",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"systemCode"}, true);

		_finderPathWithoutPaginationFindBySystemCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySystemCode",
			new String[] {Long.class.getName()}, new String[] {"systemCode"},
			true);

		_finderPathCountBySystemCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySystemCode",
			new String[] {Long.class.getName()}, new String[] {"systemCode"},
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

		_finderPathWithPaginationFindByIsSlaSigned = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsSlaSigned",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"isSlaSigned"}, true);

		_finderPathWithoutPaginationFindByIsSlaSigned = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsSlaSigned",
			new String[] {Boolean.class.getName()},
			new String[] {"isSlaSigned"}, true);

		_finderPathCountByIsSlaSigned = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsSlaSigned",
			new String[] {Boolean.class.getName()},
			new String[] {"isSlaSigned"}, false);

		_finderPathWithPaginationFindByIsSelfBi = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsSelfBi",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"isSelfBi"}, true);

		_finderPathWithoutPaginationFindByIsSelfBi = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsSelfBi",
			new String[] {Boolean.class.getName()}, new String[] {"isSelfBi"},
			true);

		_finderPathCountByIsSelfBi = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsSelfBi",
			new String[] {Boolean.class.getName()}, new String[] {"isSelfBi"},
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

		_setSystemEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSystemEntryUtilPersistence(null);

		entityCache.removeCache(SystemEntryImpl.class.getName());
	}

	private void _setSystemEntryUtilPersistence(
		SystemEntryPersistence systemEntryPersistence) {

		try {
			Field field = SystemEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, systemEntryPersistence);
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

	private static final String _SQL_SELECT_SYSTEMENTRY =
		"SELECT systemEntry FROM SystemEntry systemEntry";

	private static final String _SQL_SELECT_SYSTEMENTRY_WHERE =
		"SELECT systemEntry FROM SystemEntry systemEntry WHERE ";

	private static final String _SQL_COUNT_SYSTEMENTRY =
		"SELECT COUNT(systemEntry) FROM SystemEntry systemEntry";

	private static final String _SQL_COUNT_SYSTEMENTRY_WHERE =
		"SELECT COUNT(systemEntry) FROM SystemEntry systemEntry WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"systemEntry.systemEntryId";

	private static final String _FILTER_SQL_SELECT_SYSTEMENTRY_WHERE =
		"SELECT DISTINCT {systemEntry.*} FROM MetaCds_SystemEntry systemEntry WHERE ";

	private static final String
		_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {MetaCds_SystemEntry.*} FROM (SELECT DISTINCT systemEntry.systemEntryId FROM MetaCds_SystemEntry systemEntry WHERE ";

	private static final String
		_FILTER_SQL_SELECT_SYSTEMENTRY_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN MetaCds_SystemEntry ON TEMP_TABLE.systemEntryId = MetaCds_SystemEntry.systemEntryId";

	private static final String _FILTER_SQL_COUNT_SYSTEMENTRY_WHERE =
		"SELECT COUNT(DISTINCT systemEntry.systemEntryId) AS COUNT_VALUE FROM MetaCds_SystemEntry systemEntry WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "systemEntry";

	private static final String _FILTER_ENTITY_TABLE = "MetaCds_SystemEntry";

	private static final String _ORDER_BY_ENTITY_ALIAS = "systemEntry.";

	private static final String _ORDER_BY_ENTITY_TABLE = "MetaCds_SystemEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SystemEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SystemEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SystemEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "role"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private SystemEntryModelArgumentsResolver
		_systemEntryModelArgumentsResolver;

}