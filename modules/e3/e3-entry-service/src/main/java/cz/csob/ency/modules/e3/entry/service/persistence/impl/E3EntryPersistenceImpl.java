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

package cz.csob.ency.modules.e3.entry.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
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
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.entry.model.E3EntryTable;
import cz.csob.ency.modules.e3.entry.model.impl.E3EntryImpl;
import cz.csob.ency.modules.e3.entry.model.impl.E3EntryModelImpl;
import cz.csob.ency.modules.e3.entry.service.persistence.E3EntryPersistence;
import cz.csob.ency.modules.e3.entry.service.persistence.impl.constants.EncyThreeEntryPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the e3 entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {E3EntryPersistence.class, BasePersistence.class})
public class E3EntryPersistenceImpl
	extends BasePersistenceImpl<E3Entry> implements E3EntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>E3EntryUtil</code> to access the e3 entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		E3EntryImpl.class.getName();

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
	 * Returns all the e3 entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e3 entries
	 */
	@Override
	public List<E3Entry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<E3Entry> orderByComparator, boolean useFinderCache) {

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

		List<E3Entry> list = null;

		if (useFinderCache) {
			list = (List<E3Entry>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3Entry e3Entry : list) {
					if (!uuid.equals(e3Entry.getUuid())) {
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

			sb.append(_SQL_SELECT_E3ENTRY_WHERE);

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
				sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<E3Entry>)QueryUtil.list(
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
	 * Returns the first e3 entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByUuid_First(
			String uuid, OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByUuid_First(uuid, orderByComparator);

		if (e3Entry != null) {
			return e3Entry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchE3EntryException(sb.toString());
	}

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByUuid_First(
		String uuid, OrderByComparator<E3Entry> orderByComparator) {

		List<E3Entry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByUuid_Last(
			String uuid, OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByUuid_Last(uuid, orderByComparator);

		if (e3Entry != null) {
			return e3Entry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchE3EntryException(sb.toString());
	}

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByUuid_Last(
		String uuid, OrderByComparator<E3Entry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<E3Entry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where uuid = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	@Override
	public E3Entry[] findByUuid_PrevAndNext(
			long entryId, String uuid,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		uuid = Objects.toString(uuid, "");

		E3Entry e3Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			E3Entry[] array = new E3EntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, e3Entry, uuid, orderByComparator, true);

			array[1] = e3Entry;

			array[2] = getByUuid_PrevAndNext(
				session, e3Entry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected E3Entry getByUuid_PrevAndNext(
		Session session, E3Entry e3Entry, String uuid,
		OrderByComparator<E3Entry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_E3ENTRY_WHERE);

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
			sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(e3Entry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3Entry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (E3Entry e3Entry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(e3Entry);
		}
	}

	/**
	 * Returns the number of e3 entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e3 entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_E3ENTRY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "e3Entry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(e3Entry.uuid IS NULL OR e3Entry.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_Head;
	private FinderPath _finderPathWithoutPaginationFindByUuid_Head;
	private FinderPath _finderPathCountByUuid_Head;

	/**
	 * Returns all the e3 entries where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the matching e3 entries
	 */
	@Override
	public List<E3Entry> findByUuid_Head(String uuid, boolean head) {
		return findByUuid_Head(
			uuid, head, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entries where uuid = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByUuid_Head(
		String uuid, boolean head, int start, int end) {

		return findByUuid_Head(uuid, head, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entries where uuid = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByUuid_Head(
		String uuid, boolean head, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return findByUuid_Head(uuid, head, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entries where uuid = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByUuid_Head(
		String uuid, boolean head, int start, int end,
		OrderByComparator<E3Entry> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_Head;
				finderArgs = new Object[] {uuid, head};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_Head;
			finderArgs = new Object[] {
				uuid, head, start, end, orderByComparator
			};
		}

		List<E3Entry> list = null;

		if (useFinderCache) {
			list = (List<E3Entry>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3Entry e3Entry : list) {
					if (!uuid.equals(e3Entry.getUuid()) ||
						(head != e3Entry.isHead())) {

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

			sb.append(_SQL_SELECT_E3ENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_HEAD_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_HEAD_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_HEAD_HEAD_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(head);

				list = (List<E3Entry>)QueryUtil.list(
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
	 * Returns the first e3 entry in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByUuid_Head_First(
			String uuid, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByUuid_Head_First(uuid, head, orderByComparator);

		if (e3Entry != null) {
			return e3Entry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", head=");
		sb.append(head);

		sb.append("}");

		throw new NoSuchE3EntryException(sb.toString());
	}

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByUuid_Head_First(
		String uuid, boolean head,
		OrderByComparator<E3Entry> orderByComparator) {

		List<E3Entry> list = findByUuid_Head(
			uuid, head, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByUuid_Head_Last(
			String uuid, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByUuid_Head_Last(uuid, head, orderByComparator);

		if (e3Entry != null) {
			return e3Entry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", head=");
		sb.append(head);

		sb.append("}");

		throw new NoSuchE3EntryException(sb.toString());
	}

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByUuid_Head_Last(
		String uuid, boolean head,
		OrderByComparator<E3Entry> orderByComparator) {

		int count = countByUuid_Head(uuid, head);

		if (count == 0) {
			return null;
		}

		List<E3Entry> list = findByUuid_Head(
			uuid, head, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	@Override
	public E3Entry[] findByUuid_Head_PrevAndNext(
			long entryId, String uuid, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		uuid = Objects.toString(uuid, "");

		E3Entry e3Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			E3Entry[] array = new E3EntryImpl[3];

			array[0] = getByUuid_Head_PrevAndNext(
				session, e3Entry, uuid, head, orderByComparator, true);

			array[1] = e3Entry;

			array[2] = getByUuid_Head_PrevAndNext(
				session, e3Entry, uuid, head, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected E3Entry getByUuid_Head_PrevAndNext(
		Session session, E3Entry e3Entry, String uuid, boolean head,
		OrderByComparator<E3Entry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_E3ENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_HEAD_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_HEAD_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_HEAD_HEAD_2);

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
			sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(head);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(e3Entry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3Entry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entries where uuid = &#63; and head = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 */
	@Override
	public void removeByUuid_Head(String uuid, boolean head) {
		for (E3Entry e3Entry :
				findByUuid_Head(
					uuid, head, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(e3Entry);
		}
	}

	/**
	 * Returns the number of e3 entries where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the number of matching e3 entries
	 */
	@Override
	public int countByUuid_Head(String uuid, boolean head) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_Head;

		Object[] finderArgs = new Object[] {uuid, head};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_E3ENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_HEAD_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_HEAD_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_HEAD_HEAD_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(head);

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

	private static final String _FINDER_COLUMN_UUID_HEAD_UUID_2 =
		"e3Entry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_HEAD_UUID_3 =
		"(e3Entry.uuid IS NULL OR e3Entry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_HEAD_HEAD_2 =
		"e3Entry.head = ?";

	private FinderPath _finderPathWithPaginationFindByUUID_G;
	private FinderPath _finderPathWithoutPaginationFindByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns all the e3 entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e3 entries
	 */
	@Override
	public List<E3Entry> findByUUID_G(String uuid, long groupId) {
		return findByUUID_G(
			uuid, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entries where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByUUID_G(
		String uuid, long groupId, int start, int end) {

		return findByUUID_G(uuid, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entries where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByUUID_G(
		String uuid, long groupId, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return findByUUID_G(uuid, groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entries where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByUUID_G(
		String uuid, long groupId, int start, int end,
		OrderByComparator<E3Entry> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUUID_G;
				finderArgs = new Object[] {uuid, groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUUID_G;
			finderArgs = new Object[] {
				uuid, groupId, start, end, orderByComparator
			};
		}

		List<E3Entry> list = null;

		if (useFinderCache) {
			list = (List<E3Entry>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3Entry e3Entry : list) {
					if (!uuid.equals(e3Entry.getUuid()) ||
						(groupId != e3Entry.getGroupId())) {

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

			sb.append(_SQL_SELECT_E3ENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(groupId);

				list = (List<E3Entry>)QueryUtil.list(
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
	 * Returns the first e3 entry in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByUUID_G_First(
			String uuid, long groupId,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByUUID_G_First(uuid, groupId, orderByComparator);

		if (e3Entry != null) {
			return e3Entry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchE3EntryException(sb.toString());
	}

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByUUID_G_First(
		String uuid, long groupId,
		OrderByComparator<E3Entry> orderByComparator) {

		List<E3Entry> list = findByUUID_G(
			uuid, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByUUID_G_Last(
			String uuid, long groupId,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByUUID_G_Last(uuid, groupId, orderByComparator);

		if (e3Entry != null) {
			return e3Entry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchE3EntryException(sb.toString());
	}

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByUUID_G_Last(
		String uuid, long groupId,
		OrderByComparator<E3Entry> orderByComparator) {

		int count = countByUUID_G(uuid, groupId);

		if (count == 0) {
			return null;
		}

		List<E3Entry> list = findByUUID_G(
			uuid, groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	@Override
	public E3Entry[] findByUUID_G_PrevAndNext(
			long entryId, String uuid, long groupId,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		uuid = Objects.toString(uuid, "");

		E3Entry e3Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			E3Entry[] array = new E3EntryImpl[3];

			array[0] = getByUUID_G_PrevAndNext(
				session, e3Entry, uuid, groupId, orderByComparator, true);

			array[1] = e3Entry;

			array[2] = getByUUID_G_PrevAndNext(
				session, e3Entry, uuid, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected E3Entry getByUUID_G_PrevAndNext(
		Session session, E3Entry e3Entry, String uuid, long groupId,
		OrderByComparator<E3Entry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_E3ENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

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
			sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(e3Entry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3Entry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entries where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 */
	@Override
	public void removeByUUID_G(String uuid, long groupId) {
		for (E3Entry e3Entry :
				findByUUID_G(
					uuid, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(e3Entry);
		}
	}

	/**
	 * Returns the number of e3 entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e3 entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_E3ENTRY_WHERE);

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
		"e3Entry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(e3Entry.uuid IS NULL OR e3Entry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"e3Entry.groupId = ?";

	private FinderPath _finderPathFetchByUUID_G_Head;
	private FinderPath _finderPathCountByUUID_G_Head;

	/**
	 * Returns the e3 entry where uuid = &#63; and groupId = &#63; and head = &#63; or throws a <code>NoSuchE3EntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByUUID_G_Head(String uuid, long groupId, boolean head)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByUUID_G_Head(uuid, groupId, head);

		if (e3Entry == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append(", head=");
			sb.append(head);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchE3EntryException(sb.toString());
		}

		return e3Entry;
	}

	/**
	 * Returns the e3 entry where uuid = &#63; and groupId = &#63; and head = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByUUID_G_Head(String uuid, long groupId, boolean head) {
		return fetchByUUID_G_Head(uuid, groupId, head, true);
	}

	/**
	 * Returns the e3 entry where uuid = &#63; and groupId = &#63; and head = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByUUID_G_Head(
		String uuid, long groupId, boolean head, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId, head};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G_Head, finderArgs);
		}

		if (result instanceof E3Entry) {
			E3Entry e3Entry = (E3Entry)result;

			if (!Objects.equals(uuid, e3Entry.getUuid()) ||
				(groupId != e3Entry.getGroupId()) ||
				(head != e3Entry.isHead())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_E3ENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_HEAD_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_HEAD_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_HEAD_GROUPID_2);

			sb.append(_FINDER_COLUMN_UUID_G_HEAD_HEAD_2);

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

				queryPos.add(head);

				List<E3Entry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G_Head, finderArgs, list);
					}
				}
				else {
					E3Entry e3Entry = list.get(0);

					result = e3Entry;

					cacheResult(e3Entry);
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
			return (E3Entry)result;
		}
	}

	/**
	 * Removes the e3 entry where uuid = &#63; and groupId = &#63; and head = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the e3 entry that was removed
	 */
	@Override
	public E3Entry removeByUUID_G_Head(String uuid, long groupId, boolean head)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = findByUUID_G_Head(uuid, groupId, head);

		return remove(e3Entry);
	}

	/**
	 * Returns the number of e3 entries where uuid = &#63; and groupId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the number of matching e3 entries
	 */
	@Override
	public int countByUUID_G_Head(String uuid, long groupId, boolean head) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G_Head;

		Object[] finderArgs = new Object[] {uuid, groupId, head};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_E3ENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_HEAD_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_HEAD_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_HEAD_GROUPID_2);

			sb.append(_FINDER_COLUMN_UUID_G_HEAD_HEAD_2);

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

				queryPos.add(head);

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

	private static final String _FINDER_COLUMN_UUID_G_HEAD_UUID_2 =
		"e3Entry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_HEAD_UUID_3 =
		"(e3Entry.uuid IS NULL OR e3Entry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_HEAD_GROUPID_2 =
		"e3Entry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_HEAD_HEAD_2 =
		"e3Entry.head = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the e3 entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e3 entries
	 */
	@Override
	public List<E3Entry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<E3Entry> orderByComparator, boolean useFinderCache) {

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

		List<E3Entry> list = null;

		if (useFinderCache) {
			list = (List<E3Entry>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3Entry e3Entry : list) {
					if (!uuid.equals(e3Entry.getUuid()) ||
						(companyId != e3Entry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_E3ENTRY_WHERE);

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
				sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<E3Entry>)QueryUtil.list(
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
	 * Returns the first e3 entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (e3Entry != null) {
			return e3Entry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchE3EntryException(sb.toString());
	}

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<E3Entry> orderByComparator) {

		List<E3Entry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (e3Entry != null) {
			return e3Entry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchE3EntryException(sb.toString());
	}

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<E3Entry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<E3Entry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	@Override
	public E3Entry[] findByUuid_C_PrevAndNext(
			long entryId, String uuid, long companyId,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		uuid = Objects.toString(uuid, "");

		E3Entry e3Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			E3Entry[] array = new E3EntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, e3Entry, uuid, companyId, orderByComparator, true);

			array[1] = e3Entry;

			array[2] = getByUuid_C_PrevAndNext(
				session, e3Entry, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected E3Entry getByUuid_C_PrevAndNext(
		Session session, E3Entry e3Entry, String uuid, long companyId,
		OrderByComparator<E3Entry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_E3ENTRY_WHERE);

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
			sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(e3Entry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3Entry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (E3Entry e3Entry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(e3Entry);
		}
	}

	/**
	 * Returns the number of e3 entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e3 entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_E3ENTRY_WHERE);

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
		"e3Entry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(e3Entry.uuid IS NULL OR e3Entry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"e3Entry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C_Head;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C_Head;
	private FinderPath _finderPathCountByUuid_C_Head;

	/**
	 * Returns all the e3 entries where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @return the matching e3 entries
	 */
	@Override
	public List<E3Entry> findByUuid_C_Head(
		String uuid, long companyId, boolean head) {

		return findByUuid_C_Head(
			uuid, companyId, head, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entries where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByUuid_C_Head(
		String uuid, long companyId, boolean head, int start, int end) {

		return findByUuid_C_Head(uuid, companyId, head, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entries where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByUuid_C_Head(
		String uuid, long companyId, boolean head, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return findByUuid_C_Head(
			uuid, companyId, head, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entries where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByUuid_C_Head(
		String uuid, long companyId, boolean head, int start, int end,
		OrderByComparator<E3Entry> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C_Head;
				finderArgs = new Object[] {uuid, companyId, head};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C_Head;
			finderArgs = new Object[] {
				uuid, companyId, head, start, end, orderByComparator
			};
		}

		List<E3Entry> list = null;

		if (useFinderCache) {
			list = (List<E3Entry>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3Entry e3Entry : list) {
					if (!uuid.equals(e3Entry.getUuid()) ||
						(companyId != e3Entry.getCompanyId()) ||
						(head != e3Entry.isHead())) {

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

			sb.append(_SQL_SELECT_E3ENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_HEAD_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_HEAD_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_HEAD_COMPANYID_2);

			sb.append(_FINDER_COLUMN_UUID_C_HEAD_HEAD_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(head);

				list = (List<E3Entry>)QueryUtil.list(
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
	 * Returns the first e3 entry in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByUuid_C_Head_First(
			String uuid, long companyId, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByUuid_C_Head_First(
			uuid, companyId, head, orderByComparator);

		if (e3Entry != null) {
			return e3Entry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append(", head=");
		sb.append(head);

		sb.append("}");

		throw new NoSuchE3EntryException(sb.toString());
	}

	/**
	 * Returns the first e3 entry in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByUuid_C_Head_First(
		String uuid, long companyId, boolean head,
		OrderByComparator<E3Entry> orderByComparator) {

		List<E3Entry> list = findByUuid_C_Head(
			uuid, companyId, head, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByUuid_C_Head_Last(
			String uuid, long companyId, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByUuid_C_Head_Last(
			uuid, companyId, head, orderByComparator);

		if (e3Entry != null) {
			return e3Entry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append(", head=");
		sb.append(head);

		sb.append("}");

		throw new NoSuchE3EntryException(sb.toString());
	}

	/**
	 * Returns the last e3 entry in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByUuid_C_Head_Last(
		String uuid, long companyId, boolean head,
		OrderByComparator<E3Entry> orderByComparator) {

		int count = countByUuid_C_Head(uuid, companyId, head);

		if (count == 0) {
			return null;
		}

		List<E3Entry> list = findByUuid_C_Head(
			uuid, companyId, head, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	@Override
	public E3Entry[] findByUuid_C_Head_PrevAndNext(
			long entryId, String uuid, long companyId, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		uuid = Objects.toString(uuid, "");

		E3Entry e3Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			E3Entry[] array = new E3EntryImpl[3];

			array[0] = getByUuid_C_Head_PrevAndNext(
				session, e3Entry, uuid, companyId, head, orderByComparator,
				true);

			array[1] = e3Entry;

			array[2] = getByUuid_C_Head_PrevAndNext(
				session, e3Entry, uuid, companyId, head, orderByComparator,
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

	protected E3Entry getByUuid_C_Head_PrevAndNext(
		Session session, E3Entry e3Entry, String uuid, long companyId,
		boolean head, OrderByComparator<E3Entry> orderByComparator,
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

		sb.append(_SQL_SELECT_E3ENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_HEAD_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_HEAD_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_HEAD_COMPANYID_2);

		sb.append(_FINDER_COLUMN_UUID_C_HEAD_HEAD_2);

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
			sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
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

		queryPos.add(head);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(e3Entry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3Entry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entries where uuid = &#63; and companyId = &#63; and head = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 */
	@Override
	public void removeByUuid_C_Head(String uuid, long companyId, boolean head) {
		for (E3Entry e3Entry :
				findByUuid_C_Head(
					uuid, companyId, head, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(e3Entry);
		}
	}

	/**
	 * Returns the number of e3 entries where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @return the number of matching e3 entries
	 */
	@Override
	public int countByUuid_C_Head(String uuid, long companyId, boolean head) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C_Head;

		Object[] finderArgs = new Object[] {uuid, companyId, head};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_E3ENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_HEAD_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_HEAD_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_HEAD_COMPANYID_2);

			sb.append(_FINDER_COLUMN_UUID_C_HEAD_HEAD_2);

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

				queryPos.add(head);

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

	private static final String _FINDER_COLUMN_UUID_C_HEAD_UUID_2 =
		"e3Entry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_HEAD_UUID_3 =
		"(e3Entry.uuid IS NULL OR e3Entry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_HEAD_COMPANYID_2 =
		"e3Entry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_HEAD_HEAD_2 =
		"e3Entry.head = ?";

	private FinderPath _finderPathWithPaginationFindByxid;
	private FinderPath _finderPathWithoutPaginationFindByxid;
	private FinderPath _finderPathCountByxid;

	/**
	 * Returns all the e3 entries where xid = &#63;.
	 *
	 * @param xid the xid
	 * @return the matching e3 entries
	 */
	@Override
	public List<E3Entry> findByxid(String xid) {
		return findByxid(xid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entries where xid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param xid the xid
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByxid(String xid, int start, int end) {
		return findByxid(xid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entries where xid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param xid the xid
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByxid(
		String xid, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return findByxid(xid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entries where xid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param xid the xid
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByxid(
		String xid, int start, int end,
		OrderByComparator<E3Entry> orderByComparator, boolean useFinderCache) {

		xid = Objects.toString(xid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByxid;
				finderArgs = new Object[] {xid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByxid;
			finderArgs = new Object[] {xid, start, end, orderByComparator};
		}

		List<E3Entry> list = null;

		if (useFinderCache) {
			list = (List<E3Entry>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3Entry e3Entry : list) {
					if (!xid.equals(e3Entry.getXid())) {
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

			sb.append(_SQL_SELECT_E3ENTRY_WHERE);

			boolean bindXid = false;

			if (xid.isEmpty()) {
				sb.append(_FINDER_COLUMN_XID_XID_3);
			}
			else {
				bindXid = true;

				sb.append(_FINDER_COLUMN_XID_XID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindXid) {
					queryPos.add(xid);
				}

				list = (List<E3Entry>)QueryUtil.list(
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
	 * Returns the first e3 entry in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByxid_First(
			String xid, OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByxid_First(xid, orderByComparator);

		if (e3Entry != null) {
			return e3Entry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("xid=");
		sb.append(xid);

		sb.append("}");

		throw new NoSuchE3EntryException(sb.toString());
	}

	/**
	 * Returns the first e3 entry in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByxid_First(
		String xid, OrderByComparator<E3Entry> orderByComparator) {

		List<E3Entry> list = findByxid(xid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByxid_Last(
			String xid, OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByxid_Last(xid, orderByComparator);

		if (e3Entry != null) {
			return e3Entry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("xid=");
		sb.append(xid);

		sb.append("}");

		throw new NoSuchE3EntryException(sb.toString());
	}

	/**
	 * Returns the last e3 entry in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByxid_Last(
		String xid, OrderByComparator<E3Entry> orderByComparator) {

		int count = countByxid(xid);

		if (count == 0) {
			return null;
		}

		List<E3Entry> list = findByxid(
			xid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where xid = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	@Override
	public E3Entry[] findByxid_PrevAndNext(
			long entryId, String xid,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		xid = Objects.toString(xid, "");

		E3Entry e3Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			E3Entry[] array = new E3EntryImpl[3];

			array[0] = getByxid_PrevAndNext(
				session, e3Entry, xid, orderByComparator, true);

			array[1] = e3Entry;

			array[2] = getByxid_PrevAndNext(
				session, e3Entry, xid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected E3Entry getByxid_PrevAndNext(
		Session session, E3Entry e3Entry, String xid,
		OrderByComparator<E3Entry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_E3ENTRY_WHERE);

		boolean bindXid = false;

		if (xid.isEmpty()) {
			sb.append(_FINDER_COLUMN_XID_XID_3);
		}
		else {
			bindXid = true;

			sb.append(_FINDER_COLUMN_XID_XID_2);
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
			sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindXid) {
			queryPos.add(xid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(e3Entry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3Entry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entries where xid = &#63; from the database.
	 *
	 * @param xid the xid
	 */
	@Override
	public void removeByxid(String xid) {
		for (E3Entry e3Entry :
				findByxid(xid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(e3Entry);
		}
	}

	/**
	 * Returns the number of e3 entries where xid = &#63;.
	 *
	 * @param xid the xid
	 * @return the number of matching e3 entries
	 */
	@Override
	public int countByxid(String xid) {
		xid = Objects.toString(xid, "");

		FinderPath finderPath = _finderPathCountByxid;

		Object[] finderArgs = new Object[] {xid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_E3ENTRY_WHERE);

			boolean bindXid = false;

			if (xid.isEmpty()) {
				sb.append(_FINDER_COLUMN_XID_XID_3);
			}
			else {
				bindXid = true;

				sb.append(_FINDER_COLUMN_XID_XID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindXid) {
					queryPos.add(xid);
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

	private static final String _FINDER_COLUMN_XID_XID_2 = "e3Entry.xid = ?";

	private static final String _FINDER_COLUMN_XID_XID_3 =
		"(e3Entry.xid IS NULL OR e3Entry.xid = '')";

	private FinderPath _finderPathFetchByxid_Head;
	private FinderPath _finderPathCountByxid_Head;

	/**
	 * Returns the e3 entry where xid = &#63; and head = &#63; or throws a <code>NoSuchE3EntryException</code> if it could not be found.
	 *
	 * @param xid the xid
	 * @param head the head
	 * @return the matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByxid_Head(String xid, boolean head)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByxid_Head(xid, head);

		if (e3Entry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("xid=");
			sb.append(xid);

			sb.append(", head=");
			sb.append(head);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchE3EntryException(sb.toString());
		}

		return e3Entry;
	}

	/**
	 * Returns the e3 entry where xid = &#63; and head = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param xid the xid
	 * @param head the head
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByxid_Head(String xid, boolean head) {
		return fetchByxid_Head(xid, head, true);
	}

	/**
	 * Returns the e3 entry where xid = &#63; and head = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param xid the xid
	 * @param head the head
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByxid_Head(
		String xid, boolean head, boolean useFinderCache) {

		xid = Objects.toString(xid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {xid, head};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByxid_Head, finderArgs);
		}

		if (result instanceof E3Entry) {
			E3Entry e3Entry = (E3Entry)result;

			if (!Objects.equals(xid, e3Entry.getXid()) ||
				(head != e3Entry.isHead())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_E3ENTRY_WHERE);

			boolean bindXid = false;

			if (xid.isEmpty()) {
				sb.append(_FINDER_COLUMN_XID_HEAD_XID_3);
			}
			else {
				bindXid = true;

				sb.append(_FINDER_COLUMN_XID_HEAD_XID_2);
			}

			sb.append(_FINDER_COLUMN_XID_HEAD_HEAD_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindXid) {
					queryPos.add(xid);
				}

				queryPos.add(head);

				List<E3Entry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByxid_Head, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {xid, head};
							}

							_log.warn(
								"E3EntryPersistenceImpl.fetchByxid_Head(String, boolean, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					E3Entry e3Entry = list.get(0);

					result = e3Entry;

					cacheResult(e3Entry);
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
			return (E3Entry)result;
		}
	}

	/**
	 * Removes the e3 entry where xid = &#63; and head = &#63; from the database.
	 *
	 * @param xid the xid
	 * @param head the head
	 * @return the e3 entry that was removed
	 */
	@Override
	public E3Entry removeByxid_Head(String xid, boolean head)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = findByxid_Head(xid, head);

		return remove(e3Entry);
	}

	/**
	 * Returns the number of e3 entries where xid = &#63; and head = &#63;.
	 *
	 * @param xid the xid
	 * @param head the head
	 * @return the number of matching e3 entries
	 */
	@Override
	public int countByxid_Head(String xid, boolean head) {
		xid = Objects.toString(xid, "");

		FinderPath finderPath = _finderPathCountByxid_Head;

		Object[] finderArgs = new Object[] {xid, head};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_E3ENTRY_WHERE);

			boolean bindXid = false;

			if (xid.isEmpty()) {
				sb.append(_FINDER_COLUMN_XID_HEAD_XID_3);
			}
			else {
				bindXid = true;

				sb.append(_FINDER_COLUMN_XID_HEAD_XID_2);
			}

			sb.append(_FINDER_COLUMN_XID_HEAD_HEAD_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindXid) {
					queryPos.add(xid);
				}

				queryPos.add(head);

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

	private static final String _FINDER_COLUMN_XID_HEAD_XID_2 =
		"e3Entry.xid = ? AND ";

	private static final String _FINDER_COLUMN_XID_HEAD_XID_3 =
		"(e3Entry.xid IS NULL OR e3Entry.xid = '') AND ";

	private static final String _FINDER_COLUMN_XID_HEAD_HEAD_2 =
		"e3Entry.head = ?";

	private FinderPath _finderPathWithPaginationFindByp_f;
	private FinderPath _finderPathWithoutPaginationFindByp_f;
	private FinderPath _finderPathCountByp_f;

	/**
	 * Returns all the e3 entries where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @return the matching e3 entries
	 */
	@Override
	public List<E3Entry> findByp_f(long parentId, String parentField) {
		return findByp_f(
			parentId, parentField, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entries where parentId = &#63; and parentField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByp_f(
		long parentId, String parentField, int start, int end) {

		return findByp_f(parentId, parentField, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entries where parentId = &#63; and parentField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByp_f(
		long parentId, String parentField, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return findByp_f(
			parentId, parentField, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entries where parentId = &#63; and parentField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByp_f(
		long parentId, String parentField, int start, int end,
		OrderByComparator<E3Entry> orderByComparator, boolean useFinderCache) {

		parentField = Objects.toString(parentField, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByp_f;
				finderArgs = new Object[] {parentId, parentField};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByp_f;
			finderArgs = new Object[] {
				parentId, parentField, start, end, orderByComparator
			};
		}

		List<E3Entry> list = null;

		if (useFinderCache) {
			list = (List<E3Entry>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3Entry e3Entry : list) {
					if ((parentId != e3Entry.getParentId()) ||
						!parentField.equals(e3Entry.getParentField())) {

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

			sb.append(_SQL_SELECT_E3ENTRY_WHERE);

			sb.append(_FINDER_COLUMN_P_F_PARENTID_2);

			boolean bindParentField = false;

			if (parentField.isEmpty()) {
				sb.append(_FINDER_COLUMN_P_F_PARENTFIELD_3);
			}
			else {
				bindParentField = true;

				sb.append(_FINDER_COLUMN_P_F_PARENTFIELD_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentId);

				if (bindParentField) {
					queryPos.add(parentField);
				}

				list = (List<E3Entry>)QueryUtil.list(
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
	 * Returns the first e3 entry in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByp_f_First(
			long parentId, String parentField,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByp_f_First(
			parentId, parentField, orderByComparator);

		if (e3Entry != null) {
			return e3Entry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentId=");
		sb.append(parentId);

		sb.append(", parentField=");
		sb.append(parentField);

		sb.append("}");

		throw new NoSuchE3EntryException(sb.toString());
	}

	/**
	 * Returns the first e3 entry in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByp_f_First(
		long parentId, String parentField,
		OrderByComparator<E3Entry> orderByComparator) {

		List<E3Entry> list = findByp_f(
			parentId, parentField, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByp_f_Last(
			long parentId, String parentField,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByp_f_Last(
			parentId, parentField, orderByComparator);

		if (e3Entry != null) {
			return e3Entry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentId=");
		sb.append(parentId);

		sb.append(", parentField=");
		sb.append(parentField);

		sb.append("}");

		throw new NoSuchE3EntryException(sb.toString());
	}

	/**
	 * Returns the last e3 entry in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByp_f_Last(
		long parentId, String parentField,
		OrderByComparator<E3Entry> orderByComparator) {

		int count = countByp_f(parentId, parentField);

		if (count == 0) {
			return null;
		}

		List<E3Entry> list = findByp_f(
			parentId, parentField, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	@Override
	public E3Entry[] findByp_f_PrevAndNext(
			long entryId, long parentId, String parentField,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		parentField = Objects.toString(parentField, "");

		E3Entry e3Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			E3Entry[] array = new E3EntryImpl[3];

			array[0] = getByp_f_PrevAndNext(
				session, e3Entry, parentId, parentField, orderByComparator,
				true);

			array[1] = e3Entry;

			array[2] = getByp_f_PrevAndNext(
				session, e3Entry, parentId, parentField, orderByComparator,
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

	protected E3Entry getByp_f_PrevAndNext(
		Session session, E3Entry e3Entry, long parentId, String parentField,
		OrderByComparator<E3Entry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_E3ENTRY_WHERE);

		sb.append(_FINDER_COLUMN_P_F_PARENTID_2);

		boolean bindParentField = false;

		if (parentField.isEmpty()) {
			sb.append(_FINDER_COLUMN_P_F_PARENTFIELD_3);
		}
		else {
			bindParentField = true;

			sb.append(_FINDER_COLUMN_P_F_PARENTFIELD_2);
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
			sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(parentId);

		if (bindParentField) {
			queryPos.add(parentField);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(e3Entry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3Entry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entries where parentId = &#63; and parentField = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 */
	@Override
	public void removeByp_f(long parentId, String parentField) {
		for (E3Entry e3Entry :
				findByp_f(
					parentId, parentField, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(e3Entry);
		}
	}

	/**
	 * Returns the number of e3 entries where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @return the number of matching e3 entries
	 */
	@Override
	public int countByp_f(long parentId, String parentField) {
		parentField = Objects.toString(parentField, "");

		FinderPath finderPath = _finderPathCountByp_f;

		Object[] finderArgs = new Object[] {parentId, parentField};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_E3ENTRY_WHERE);

			sb.append(_FINDER_COLUMN_P_F_PARENTID_2);

			boolean bindParentField = false;

			if (parentField.isEmpty()) {
				sb.append(_FINDER_COLUMN_P_F_PARENTFIELD_3);
			}
			else {
				bindParentField = true;

				sb.append(_FINDER_COLUMN_P_F_PARENTFIELD_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentId);

				if (bindParentField) {
					queryPos.add(parentField);
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

	private static final String _FINDER_COLUMN_P_F_PARENTID_2 =
		"e3Entry.parentId = ? AND ";

	private static final String _FINDER_COLUMN_P_F_PARENTFIELD_2 =
		"e3Entry.parentField = ?";

	private static final String _FINDER_COLUMN_P_F_PARENTFIELD_3 =
		"(e3Entry.parentField IS NULL OR e3Entry.parentField = '')";

	private FinderPath _finderPathFetchByp_f_Head;
	private FinderPath _finderPathCountByp_f_Head;

	/**
	 * Returns the e3 entry where parentId = &#63; and parentField = &#63; and head = &#63; or throws a <code>NoSuchE3EntryException</code> if it could not be found.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param head the head
	 * @return the matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByp_f_Head(
			long parentId, String parentField, boolean head)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByp_f_Head(parentId, parentField, head);

		if (e3Entry == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("parentId=");
			sb.append(parentId);

			sb.append(", parentField=");
			sb.append(parentField);

			sb.append(", head=");
			sb.append(head);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchE3EntryException(sb.toString());
		}

		return e3Entry;
	}

	/**
	 * Returns the e3 entry where parentId = &#63; and parentField = &#63; and head = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param head the head
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByp_f_Head(
		long parentId, String parentField, boolean head) {

		return fetchByp_f_Head(parentId, parentField, head, true);
	}

	/**
	 * Returns the e3 entry where parentId = &#63; and parentField = &#63; and head = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param head the head
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByp_f_Head(
		long parentId, String parentField, boolean head,
		boolean useFinderCache) {

		parentField = Objects.toString(parentField, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {parentId, parentField, head};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByp_f_Head, finderArgs);
		}

		if (result instanceof E3Entry) {
			E3Entry e3Entry = (E3Entry)result;

			if ((parentId != e3Entry.getParentId()) ||
				!Objects.equals(parentField, e3Entry.getParentField()) ||
				(head != e3Entry.isHead())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_E3ENTRY_WHERE);

			sb.append(_FINDER_COLUMN_P_F_HEAD_PARENTID_2);

			boolean bindParentField = false;

			if (parentField.isEmpty()) {
				sb.append(_FINDER_COLUMN_P_F_HEAD_PARENTFIELD_3);
			}
			else {
				bindParentField = true;

				sb.append(_FINDER_COLUMN_P_F_HEAD_PARENTFIELD_2);
			}

			sb.append(_FINDER_COLUMN_P_F_HEAD_HEAD_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentId);

				if (bindParentField) {
					queryPos.add(parentField);
				}

				queryPos.add(head);

				List<E3Entry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByp_f_Head, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									parentId, parentField, head
								};
							}

							_log.warn(
								"E3EntryPersistenceImpl.fetchByp_f_Head(long, String, boolean, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					E3Entry e3Entry = list.get(0);

					result = e3Entry;

					cacheResult(e3Entry);
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
			return (E3Entry)result;
		}
	}

	/**
	 * Removes the e3 entry where parentId = &#63; and parentField = &#63; and head = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param head the head
	 * @return the e3 entry that was removed
	 */
	@Override
	public E3Entry removeByp_f_Head(
			long parentId, String parentField, boolean head)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = findByp_f_Head(parentId, parentField, head);

		return remove(e3Entry);
	}

	/**
	 * Returns the number of e3 entries where parentId = &#63; and parentField = &#63; and head = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param head the head
	 * @return the number of matching e3 entries
	 */
	@Override
	public int countByp_f_Head(
		long parentId, String parentField, boolean head) {

		parentField = Objects.toString(parentField, "");

		FinderPath finderPath = _finderPathCountByp_f_Head;

		Object[] finderArgs = new Object[] {parentId, parentField, head};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_E3ENTRY_WHERE);

			sb.append(_FINDER_COLUMN_P_F_HEAD_PARENTID_2);

			boolean bindParentField = false;

			if (parentField.isEmpty()) {
				sb.append(_FINDER_COLUMN_P_F_HEAD_PARENTFIELD_3);
			}
			else {
				bindParentField = true;

				sb.append(_FINDER_COLUMN_P_F_HEAD_PARENTFIELD_2);
			}

			sb.append(_FINDER_COLUMN_P_F_HEAD_HEAD_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentId);

				if (bindParentField) {
					queryPos.add(parentField);
				}

				queryPos.add(head);

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

	private static final String _FINDER_COLUMN_P_F_HEAD_PARENTID_2 =
		"e3Entry.parentId = ? AND ";

	private static final String _FINDER_COLUMN_P_F_HEAD_PARENTFIELD_2 =
		"e3Entry.parentField = ? AND ";

	private static final String _FINDER_COLUMN_P_F_HEAD_PARENTFIELD_3 =
		"(e3Entry.parentField IS NULL OR e3Entry.parentField = '') AND ";

	private static final String _FINDER_COLUMN_P_F_HEAD_HEAD_2 =
		"e3Entry.head = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the e3 entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching e3 entries
	 */
	@Override
	public List<E3Entry> findByStatus(long status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByStatus(long status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByStatus(
		long status, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByStatus(
		long status, int start, int end,
		OrderByComparator<E3Entry> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<E3Entry> list = null;

		if (useFinderCache) {
			list = (List<E3Entry>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3Entry e3Entry : list) {
					if (status != e3Entry.getStatus()) {
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

			sb.append(_SQL_SELECT_E3ENTRY_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<E3Entry>)QueryUtil.list(
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
	 * Returns the first e3 entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByStatus_First(
			long status, OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByStatus_First(status, orderByComparator);

		if (e3Entry != null) {
			return e3Entry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchE3EntryException(sb.toString());
	}

	/**
	 * Returns the first e3 entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByStatus_First(
		long status, OrderByComparator<E3Entry> orderByComparator) {

		List<E3Entry> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByStatus_Last(
			long status, OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByStatus_Last(status, orderByComparator);

		if (e3Entry != null) {
			return e3Entry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchE3EntryException(sb.toString());
	}

	/**
	 * Returns the last e3 entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByStatus_Last(
		long status, OrderByComparator<E3Entry> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<E3Entry> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where status = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	@Override
	public E3Entry[] findByStatus_PrevAndNext(
			long entryId, long status,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			E3Entry[] array = new E3EntryImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, e3Entry, status, orderByComparator, true);

			array[1] = e3Entry;

			array[2] = getByStatus_PrevAndNext(
				session, e3Entry, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected E3Entry getByStatus_PrevAndNext(
		Session session, E3Entry e3Entry, long status,
		OrderByComparator<E3Entry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_E3ENTRY_WHERE);

		sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(e3Entry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3Entry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entries where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(long status) {
		for (E3Entry e3Entry :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(e3Entry);
		}
	}

	/**
	 * Returns the number of e3 entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching e3 entries
	 */
	@Override
	public int countByStatus(long status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_E3ENTRY_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"e3Entry.status = ?";

	private FinderPath _finderPathWithPaginationFindByStatus_Head;
	private FinderPath _finderPathWithoutPaginationFindByStatus_Head;
	private FinderPath _finderPathCountByStatus_Head;

	/**
	 * Returns all the e3 entries where status = &#63; and head = &#63;.
	 *
	 * @param status the status
	 * @param head the head
	 * @return the matching e3 entries
	 */
	@Override
	public List<E3Entry> findByStatus_Head(long status, boolean head) {
		return findByStatus_Head(
			status, head, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entries where status = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByStatus_Head(
		long status, boolean head, int start, int end) {

		return findByStatus_Head(status, head, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entries where status = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByStatus_Head(
		long status, boolean head, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return findByStatus_Head(
			status, head, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entries where status = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByStatus_Head(
		long status, boolean head, int start, int end,
		OrderByComparator<E3Entry> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus_Head;
				finderArgs = new Object[] {status, head};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus_Head;
			finderArgs = new Object[] {
				status, head, start, end, orderByComparator
			};
		}

		List<E3Entry> list = null;

		if (useFinderCache) {
			list = (List<E3Entry>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3Entry e3Entry : list) {
					if ((status != e3Entry.getStatus()) ||
						(head != e3Entry.isHead())) {

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

			sb.append(_SQL_SELECT_E3ENTRY_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_HEAD_STATUS_2);

			sb.append(_FINDER_COLUMN_STATUS_HEAD_HEAD_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				queryPos.add(head);

				list = (List<E3Entry>)QueryUtil.list(
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
	 * Returns the first e3 entry in the ordered set where status = &#63; and head = &#63;.
	 *
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByStatus_Head_First(
			long status, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByStatus_Head_First(
			status, head, orderByComparator);

		if (e3Entry != null) {
			return e3Entry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append(", head=");
		sb.append(head);

		sb.append("}");

		throw new NoSuchE3EntryException(sb.toString());
	}

	/**
	 * Returns the first e3 entry in the ordered set where status = &#63; and head = &#63;.
	 *
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByStatus_Head_First(
		long status, boolean head,
		OrderByComparator<E3Entry> orderByComparator) {

		List<E3Entry> list = findByStatus_Head(
			status, head, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry in the ordered set where status = &#63; and head = &#63;.
	 *
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByStatus_Head_Last(
			long status, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByStatus_Head_Last(
			status, head, orderByComparator);

		if (e3Entry != null) {
			return e3Entry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append(", head=");
		sb.append(head);

		sb.append("}");

		throw new NoSuchE3EntryException(sb.toString());
	}

	/**
	 * Returns the last e3 entry in the ordered set where status = &#63; and head = &#63;.
	 *
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByStatus_Head_Last(
		long status, boolean head,
		OrderByComparator<E3Entry> orderByComparator) {

		int count = countByStatus_Head(status, head);

		if (count == 0) {
			return null;
		}

		List<E3Entry> list = findByStatus_Head(
			status, head, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where status = &#63; and head = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	@Override
	public E3Entry[] findByStatus_Head_PrevAndNext(
			long entryId, long status, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			E3Entry[] array = new E3EntryImpl[3];

			array[0] = getByStatus_Head_PrevAndNext(
				session, e3Entry, status, head, orderByComparator, true);

			array[1] = e3Entry;

			array[2] = getByStatus_Head_PrevAndNext(
				session, e3Entry, status, head, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected E3Entry getByStatus_Head_PrevAndNext(
		Session session, E3Entry e3Entry, long status, boolean head,
		OrderByComparator<E3Entry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_E3ENTRY_WHERE);

		sb.append(_FINDER_COLUMN_STATUS_HEAD_STATUS_2);

		sb.append(_FINDER_COLUMN_STATUS_HEAD_HEAD_2);

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
			sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		queryPos.add(head);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(e3Entry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3Entry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entries where status = &#63; and head = &#63; from the database.
	 *
	 * @param status the status
	 * @param head the head
	 */
	@Override
	public void removeByStatus_Head(long status, boolean head) {
		for (E3Entry e3Entry :
				findByStatus_Head(
					status, head, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(e3Entry);
		}
	}

	/**
	 * Returns the number of e3 entries where status = &#63; and head = &#63;.
	 *
	 * @param status the status
	 * @param head the head
	 * @return the number of matching e3 entries
	 */
	@Override
	public int countByStatus_Head(long status, boolean head) {
		FinderPath finderPath = _finderPathCountByStatus_Head;

		Object[] finderArgs = new Object[] {status, head};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_E3ENTRY_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_HEAD_STATUS_2);

			sb.append(_FINDER_COLUMN_STATUS_HEAD_HEAD_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				queryPos.add(head);

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

	private static final String _FINDER_COLUMN_STATUS_HEAD_STATUS_2 =
		"e3Entry.status = ? AND ";

	private static final String _FINDER_COLUMN_STATUS_HEAD_HEAD_2 =
		"e3Entry.head = ?";

	private FinderPath _finderPathWithPaginationFindByG_S;
	private FinderPath _finderPathWithoutPaginationFindByG_S;
	private FinderPath _finderPathCountByG_S;

	/**
	 * Returns all the e3 entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching e3 entries
	 */
	@Override
	public List<E3Entry> findByG_S(long groupId, long status) {
		return findByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByG_S(
		long groupId, long status, int start, int end) {

		return findByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByG_S(
		long groupId, long status, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return findByG_S(groupId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByG_S(
		long groupId, long status, int start, int end,
		OrderByComparator<E3Entry> orderByComparator, boolean useFinderCache) {

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

		List<E3Entry> list = null;

		if (useFinderCache) {
			list = (List<E3Entry>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3Entry e3Entry : list) {
					if ((groupId != e3Entry.getGroupId()) ||
						(status != e3Entry.getStatus())) {

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

			sb.append(_SQL_SELECT_E3ENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				list = (List<E3Entry>)QueryUtil.list(
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
	 * Returns the first e3 entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByG_S_First(
			long groupId, long status,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByG_S_First(groupId, status, orderByComparator);

		if (e3Entry != null) {
			return e3Entry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchE3EntryException(sb.toString());
	}

	/**
	 * Returns the first e3 entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByG_S_First(
		long groupId, long status,
		OrderByComparator<E3Entry> orderByComparator) {

		List<E3Entry> list = findByG_S(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByG_S_Last(
			long groupId, long status,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByG_S_Last(groupId, status, orderByComparator);

		if (e3Entry != null) {
			return e3Entry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchE3EntryException(sb.toString());
	}

	/**
	 * Returns the last e3 entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByG_S_Last(
		long groupId, long status,
		OrderByComparator<E3Entry> orderByComparator) {

		int count = countByG_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<E3Entry> list = findByG_S(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	@Override
	public E3Entry[] findByG_S_PrevAndNext(
			long entryId, long groupId, long status,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			E3Entry[] array = new E3EntryImpl[3];

			array[0] = getByG_S_PrevAndNext(
				session, e3Entry, groupId, status, orderByComparator, true);

			array[1] = e3Entry;

			array[2] = getByG_S_PrevAndNext(
				session, e3Entry, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected E3Entry getByG_S_PrevAndNext(
		Session session, E3Entry e3Entry, long groupId, long status,
		OrderByComparator<E3Entry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_E3ENTRY_WHERE);

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
			sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(e3Entry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3Entry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e3 entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching e3 entries that the user has permission to view
	 */
	@Override
	public List<E3Entry> filterFindByG_S(long groupId, long status) {
		return filterFindByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries that the user has permission to view
	 */
	@Override
	public List<E3Entry> filterFindByG_S(
		long groupId, long status, int start, int end) {

		return filterFindByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entries that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries that the user has permission to view
	 */
	@Override
	public List<E3Entry> filterFindByG_S(
		long groupId, long status, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_E3ENTRY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_E3ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_E3ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(E3EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), E3Entry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, E3EntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, E3EntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(status);

			return (List<E3Entry>)QueryUtil.list(
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
	 * Returns the e3 entries before and after the current e3 entry in the ordered set of e3 entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	@Override
	public E3Entry[] filterFindByG_S_PrevAndNext(
			long entryId, long groupId, long status,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_PrevAndNext(
				entryId, groupId, status, orderByComparator);
		}

		E3Entry e3Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			E3Entry[] array = new E3EntryImpl[3];

			array[0] = filterGetByG_S_PrevAndNext(
				session, e3Entry, groupId, status, orderByComparator, true);

			array[1] = e3Entry;

			array[2] = filterGetByG_S_PrevAndNext(
				session, e3Entry, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected E3Entry filterGetByG_S_PrevAndNext(
		Session session, E3Entry e3Entry, long groupId, long status,
		OrderByComparator<E3Entry> orderByComparator, boolean previous) {

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
			sb.append(_FILTER_SQL_SELECT_E3ENTRY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_E3ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_E3ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(E3EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), E3Entry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, E3EntryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, E3EntryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(e3Entry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3Entry> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByG_S(long groupId, long status) {
		for (E3Entry e3Entry :
				findByG_S(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(e3Entry);
		}
	}

	/**
	 * Returns the number of e3 entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching e3 entries
	 */
	@Override
	public int countByG_S(long groupId, long status) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_E3ENTRY_WHERE);

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
	 * Returns the number of e3 entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching e3 entries that the user has permission to view
	 */
	@Override
	public int filterCountByG_S(long groupId, long status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S(groupId, status);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_E3ENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), E3Entry.class.getName(),
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

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 =
		"e3Entry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_STATUS_2 =
		"e3Entry.status = ?";

	private FinderPath _finderPathWithPaginationFindByG_S_Head;
	private FinderPath _finderPathWithoutPaginationFindByG_S_Head;
	private FinderPath _finderPathCountByG_S_Head;

	/**
	 * Returns all the e3 entries where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @return the matching e3 entries
	 */
	@Override
	public List<E3Entry> findByG_S_Head(
		long groupId, long status, boolean head) {

		return findByG_S_Head(
			groupId, status, head, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entries where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByG_S_Head(
		long groupId, long status, boolean head, int start, int end) {

		return findByG_S_Head(groupId, status, head, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entries where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByG_S_Head(
		long groupId, long status, boolean head, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		return findByG_S_Head(
			groupId, status, head, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entries where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entries
	 */
	@Override
	public List<E3Entry> findByG_S_Head(
		long groupId, long status, boolean head, int start, int end,
		OrderByComparator<E3Entry> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_S_Head;
				finderArgs = new Object[] {groupId, status, head};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_S_Head;
			finderArgs = new Object[] {
				groupId, status, head, start, end, orderByComparator
			};
		}

		List<E3Entry> list = null;

		if (useFinderCache) {
			list = (List<E3Entry>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3Entry e3Entry : list) {
					if ((groupId != e3Entry.getGroupId()) ||
						(status != e3Entry.getStatus()) ||
						(head != e3Entry.isHead())) {

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

			sb.append(_SQL_SELECT_E3ENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_S_HEAD_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_HEAD_STATUS_2);

			sb.append(_FINDER_COLUMN_G_S_HEAD_HEAD_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				queryPos.add(head);

				list = (List<E3Entry>)QueryUtil.list(
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
	 * Returns the first e3 entry in the ordered set where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByG_S_Head_First(
			long groupId, long status, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByG_S_Head_First(
			groupId, status, head, orderByComparator);

		if (e3Entry != null) {
			return e3Entry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append(", head=");
		sb.append(head);

		sb.append("}");

		throw new NoSuchE3EntryException(sb.toString());
	}

	/**
	 * Returns the first e3 entry in the ordered set where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByG_S_Head_First(
		long groupId, long status, boolean head,
		OrderByComparator<E3Entry> orderByComparator) {

		List<E3Entry> list = findByG_S_Head(
			groupId, status, head, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry in the ordered set where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByG_S_Head_Last(
			long groupId, long status, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByG_S_Head_Last(
			groupId, status, head, orderByComparator);

		if (e3Entry != null) {
			return e3Entry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append(", head=");
		sb.append(head);

		sb.append("}");

		throw new NoSuchE3EntryException(sb.toString());
	}

	/**
	 * Returns the last e3 entry in the ordered set where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByG_S_Head_Last(
		long groupId, long status, boolean head,
		OrderByComparator<E3Entry> orderByComparator) {

		int count = countByG_S_Head(groupId, status, head);

		if (count == 0) {
			return null;
		}

		List<E3Entry> list = findByG_S_Head(
			groupId, status, head, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entries before and after the current e3 entry in the ordered set where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	@Override
	public E3Entry[] findByG_S_Head_PrevAndNext(
			long entryId, long groupId, long status, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			E3Entry[] array = new E3EntryImpl[3];

			array[0] = getByG_S_Head_PrevAndNext(
				session, e3Entry, groupId, status, head, orderByComparator,
				true);

			array[1] = e3Entry;

			array[2] = getByG_S_Head_PrevAndNext(
				session, e3Entry, groupId, status, head, orderByComparator,
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

	protected E3Entry getByG_S_Head_PrevAndNext(
		Session session, E3Entry e3Entry, long groupId, long status,
		boolean head, OrderByComparator<E3Entry> orderByComparator,
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

		sb.append(_SQL_SELECT_E3ENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_S_HEAD_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_HEAD_STATUS_2);

		sb.append(_FINDER_COLUMN_G_S_HEAD_HEAD_2);

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
			sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(status);

		queryPos.add(head);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(e3Entry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3Entry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e3 entries that the user has permission to view where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @return the matching e3 entries that the user has permission to view
	 */
	@Override
	public List<E3Entry> filterFindByG_S_Head(
		long groupId, long status, boolean head) {

		return filterFindByG_S_Head(
			groupId, status, head, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entries that the user has permission to view where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of matching e3 entries that the user has permission to view
	 */
	@Override
	public List<E3Entry> filterFindByG_S_Head(
		long groupId, long status, boolean head, int start, int end) {

		return filterFindByG_S_Head(groupId, status, head, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entries that the user has permissions to view where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entries that the user has permission to view
	 */
	@Override
	public List<E3Entry> filterFindByG_S_Head(
		long groupId, long status, boolean head, int start, int end,
		OrderByComparator<E3Entry> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_Head(
				groupId, status, head, start, end, orderByComparator);
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
			sb.append(_FILTER_SQL_SELECT_E3ENTRY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_E3ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_HEAD_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_HEAD_STATUS_2);

		sb.append(_FINDER_COLUMN_G_S_HEAD_HEAD_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_E3ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(E3EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), E3Entry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, E3EntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, E3EntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(status);

			queryPos.add(head);

			return (List<E3Entry>)QueryUtil.list(
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
	 * Returns the e3 entries before and after the current e3 entry in the ordered set of e3 entries that the user has permission to view where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param entryId the primary key of the current e3 entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	@Override
	public E3Entry[] filterFindByG_S_Head_PrevAndNext(
			long entryId, long groupId, long status, boolean head,
			OrderByComparator<E3Entry> orderByComparator)
		throws NoSuchE3EntryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_Head_PrevAndNext(
				entryId, groupId, status, head, orderByComparator);
		}

		E3Entry e3Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			E3Entry[] array = new E3EntryImpl[3];

			array[0] = filterGetByG_S_Head_PrevAndNext(
				session, e3Entry, groupId, status, head, orderByComparator,
				true);

			array[1] = e3Entry;

			array[2] = filterGetByG_S_Head_PrevAndNext(
				session, e3Entry, groupId, status, head, orderByComparator,
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

	protected E3Entry filterGetByG_S_Head_PrevAndNext(
		Session session, E3Entry e3Entry, long groupId, long status,
		boolean head, OrderByComparator<E3Entry> orderByComparator,
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
			sb.append(_FILTER_SQL_SELECT_E3ENTRY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_E3ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_HEAD_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_HEAD_STATUS_2);

		sb.append(_FINDER_COLUMN_G_S_HEAD_HEAD_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_E3ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(E3EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(E3EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), E3Entry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, E3EntryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, E3EntryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(status);

		queryPos.add(head);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(e3Entry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3Entry> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entries where groupId = &#63; and status = &#63; and head = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 */
	@Override
	public void removeByG_S_Head(long groupId, long status, boolean head) {
		for (E3Entry e3Entry :
				findByG_S_Head(
					groupId, status, head, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(e3Entry);
		}
	}

	/**
	 * Returns the number of e3 entries where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @return the number of matching e3 entries
	 */
	@Override
	public int countByG_S_Head(long groupId, long status, boolean head) {
		FinderPath finderPath = _finderPathCountByG_S_Head;

		Object[] finderArgs = new Object[] {groupId, status, head};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_E3ENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_S_HEAD_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_HEAD_STATUS_2);

			sb.append(_FINDER_COLUMN_G_S_HEAD_HEAD_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				queryPos.add(head);

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
	 * Returns the number of e3 entries that the user has permission to view where groupId = &#63; and status = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param head the head
	 * @return the number of matching e3 entries that the user has permission to view
	 */
	@Override
	public int filterCountByG_S_Head(long groupId, long status, boolean head) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S_Head(groupId, status, head);
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_FILTER_SQL_COUNT_E3ENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_S_HEAD_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_HEAD_STATUS_2);

		sb.append(_FINDER_COLUMN_G_S_HEAD_HEAD_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), E3Entry.class.getName(),
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

			queryPos.add(head);

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

	private static final String _FINDER_COLUMN_G_S_HEAD_GROUPID_2 =
		"e3Entry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_HEAD_STATUS_2 =
		"e3Entry.status = ? AND ";

	private static final String _FINDER_COLUMN_G_S_HEAD_HEAD_2 =
		"e3Entry.head = ?";

	private FinderPath _finderPathFetchByHeadId;
	private FinderPath _finderPathCountByHeadId;

	/**
	 * Returns the e3 entry where headId = &#63; or throws a <code>NoSuchE3EntryException</code> if it could not be found.
	 *
	 * @param headId the head ID
	 * @return the matching e3 entry
	 * @throws NoSuchE3EntryException if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry findByHeadId(long headId) throws NoSuchE3EntryException {
		E3Entry e3Entry = fetchByHeadId(headId);

		if (e3Entry == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("headId=");
			sb.append(headId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchE3EntryException(sb.toString());
		}

		return e3Entry;
	}

	/**
	 * Returns the e3 entry where headId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param headId the head ID
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByHeadId(long headId) {
		return fetchByHeadId(headId, true);
	}

	/**
	 * Returns the e3 entry where headId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param headId the head ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching e3 entry, or <code>null</code> if a matching e3 entry could not be found
	 */
	@Override
	public E3Entry fetchByHeadId(long headId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {headId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByHeadId, finderArgs);
		}

		if (result instanceof E3Entry) {
			E3Entry e3Entry = (E3Entry)result;

			if (headId != e3Entry.getHeadId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_E3ENTRY_WHERE);

			sb.append(_FINDER_COLUMN_HEADID_HEADID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(headId);

				List<E3Entry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByHeadId, finderArgs, list);
					}
				}
				else {
					E3Entry e3Entry = list.get(0);

					result = e3Entry;

					cacheResult(e3Entry);
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
			return (E3Entry)result;
		}
	}

	/**
	 * Removes the e3 entry where headId = &#63; from the database.
	 *
	 * @param headId the head ID
	 * @return the e3 entry that was removed
	 */
	@Override
	public E3Entry removeByHeadId(long headId) throws NoSuchE3EntryException {
		E3Entry e3Entry = findByHeadId(headId);

		return remove(e3Entry);
	}

	/**
	 * Returns the number of e3 entries where headId = &#63;.
	 *
	 * @param headId the head ID
	 * @return the number of matching e3 entries
	 */
	@Override
	public int countByHeadId(long headId) {
		FinderPath finderPath = _finderPathCountByHeadId;

		Object[] finderArgs = new Object[] {headId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_E3ENTRY_WHERE);

			sb.append(_FINDER_COLUMN_HEADID_HEADID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(headId);

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

	private static final String _FINDER_COLUMN_HEADID_HEADID_2 =
		"e3Entry.headId = ?";

	public E3EntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("entryId", "entry_id");
		dbColumnNames.put("userId", "entry_modifier_id");
		dbColumnNames.put("userName", "entry_modifier_name");
		dbColumnNames.put("createDate", "entry_created");
		dbColumnNames.put("modifiedDate", "entry_modified");
		dbColumnNames.put("authorId", "entry_author_id");
		dbColumnNames.put("authorName", "entry_author_name");
		dbColumnNames.put("xid", "entry_xid");
		dbColumnNames.put("name", "entry_name");
		dbColumnNames.put("appClass", "app_class");
		dbColumnNames.put("parentId", "parent_id");
		dbColumnNames.put("parentField", "parent_field");
		dbColumnNames.put("values", "json_values");

		setDBColumnNames(dbColumnNames);

		setModelClass(E3Entry.class);

		setModelImplClass(E3EntryImpl.class);
		setModelPKClass(long.class);

		setTable(E3EntryTable.INSTANCE);
	}

	/**
	 * Caches the e3 entry in the entity cache if it is enabled.
	 *
	 * @param e3Entry the e3 entry
	 */
	@Override
	public void cacheResult(E3Entry e3Entry) {
		entityCache.putResult(
			E3EntryImpl.class, e3Entry.getPrimaryKey(), e3Entry);

		finderCache.putResult(
			_finderPathFetchByUUID_G_Head,
			new Object[] {
				e3Entry.getUuid(), e3Entry.getGroupId(), e3Entry.isHead()
			},
			e3Entry);

		finderCache.putResult(
			_finderPathFetchByxid_Head,
			new Object[] {e3Entry.getXid(), e3Entry.isHead()}, e3Entry);

		finderCache.putResult(
			_finderPathFetchByp_f_Head,
			new Object[] {
				e3Entry.getParentId(), e3Entry.getParentField(),
				e3Entry.isHead()
			},
			e3Entry);

		finderCache.putResult(
			_finderPathFetchByHeadId, new Object[] {e3Entry.getHeadId()},
			e3Entry);
	}

	/**
	 * Caches the e3 entries in the entity cache if it is enabled.
	 *
	 * @param e3Entries the e3 entries
	 */
	@Override
	public void cacheResult(List<E3Entry> e3Entries) {
		for (E3Entry e3Entry : e3Entries) {
			if (entityCache.getResult(
					E3EntryImpl.class, e3Entry.getPrimaryKey()) == null) {

				cacheResult(e3Entry);
			}
		}
	}

	/**
	 * Clears the cache for all e3 entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(E3EntryImpl.class);

		finderCache.clearCache(E3EntryImpl.class);
	}

	/**
	 * Clears the cache for the e3 entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(E3Entry e3Entry) {
		entityCache.removeResult(E3EntryImpl.class, e3Entry);
	}

	@Override
	public void clearCache(List<E3Entry> e3Entries) {
		for (E3Entry e3Entry : e3Entries) {
			entityCache.removeResult(E3EntryImpl.class, e3Entry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(E3EntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(E3EntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(E3EntryModelImpl e3EntryModelImpl) {
		Object[] args = new Object[] {
			e3EntryModelImpl.getUuid(), e3EntryModelImpl.getGroupId(),
			e3EntryModelImpl.isHead()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G_Head, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G_Head, args, e3EntryModelImpl);

		args = new Object[] {
			e3EntryModelImpl.getXid(), e3EntryModelImpl.isHead()
		};

		finderCache.putResult(
			_finderPathCountByxid_Head, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByxid_Head, args, e3EntryModelImpl);

		args = new Object[] {
			e3EntryModelImpl.getParentId(), e3EntryModelImpl.getParentField(),
			e3EntryModelImpl.isHead()
		};

		finderCache.putResult(
			_finderPathCountByp_f_Head, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByp_f_Head, args, e3EntryModelImpl);

		args = new Object[] {e3EntryModelImpl.getHeadId()};

		finderCache.putResult(_finderPathCountByHeadId, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByHeadId, args, e3EntryModelImpl);
	}

	/**
	 * Creates a new e3 entry with the primary key. Does not add the e3 entry to the database.
	 *
	 * @param entryId the primary key for the new e3 entry
	 * @return the new e3 entry
	 */
	@Override
	public E3Entry create(long entryId) {
		E3Entry e3Entry = new E3EntryImpl();

		e3Entry.setNew(true);
		e3Entry.setPrimaryKey(entryId);

		String uuid = PortalUUIDUtil.generate();

		e3Entry.setUuid(uuid);

		e3Entry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return e3Entry;
	}

	/**
	 * Removes the e3 entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the e3 entry
	 * @return the e3 entry that was removed
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	@Override
	public E3Entry remove(long entryId) throws NoSuchE3EntryException {
		return remove((Serializable)entryId);
	}

	/**
	 * Removes the e3 entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e3 entry
	 * @return the e3 entry that was removed
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	@Override
	public E3Entry remove(Serializable primaryKey)
		throws NoSuchE3EntryException {

		Session session = null;

		try {
			session = openSession();

			E3Entry e3Entry = (E3Entry)session.get(
				E3EntryImpl.class, primaryKey);

			if (e3Entry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchE3EntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(e3Entry);
		}
		catch (NoSuchE3EntryException noSuchEntityException) {
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
	protected E3Entry removeImpl(E3Entry e3Entry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(e3Entry)) {
				e3Entry = (E3Entry)session.get(
					E3EntryImpl.class, e3Entry.getPrimaryKeyObj());
			}

			if (e3Entry != null) {
				session.delete(e3Entry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (e3Entry != null) {
			clearCache(e3Entry);
		}

		return e3Entry;
	}

	@Override
	public E3Entry updateImpl(E3Entry e3Entry) {
		boolean isNew = e3Entry.isNew();

		if (!(e3Entry instanceof E3EntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(e3Entry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(e3Entry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in e3Entry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom E3Entry implementation " +
					e3Entry.getClass());
		}

		E3EntryModelImpl e3EntryModelImpl = (E3EntryModelImpl)e3Entry;

		if (Validator.isNull(e3Entry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			e3Entry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (e3Entry.getCreateDate() == null)) {
			if (serviceContext == null) {
				e3Entry.setCreateDate(date);
			}
			else {
				e3Entry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!e3EntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				e3Entry.setModifiedDate(date);
			}
			else {
				e3Entry.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(e3Entry);
			}
			else {
				e3Entry = (E3Entry)session.merge(e3Entry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(E3EntryImpl.class, e3EntryModelImpl, false, true);

		cacheUniqueFindersCache(e3EntryModelImpl);

		if (isNew) {
			e3Entry.setNew(false);
		}

		e3Entry.resetOriginalValues();

		return e3Entry;
	}

	/**
	 * Returns the e3 entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e3 entry
	 * @return the e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	@Override
	public E3Entry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchE3EntryException {

		E3Entry e3Entry = fetchByPrimaryKey(primaryKey);

		if (e3Entry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchE3EntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return e3Entry;
	}

	/**
	 * Returns the e3 entry with the primary key or throws a <code>NoSuchE3EntryException</code> if it could not be found.
	 *
	 * @param entryId the primary key of the e3 entry
	 * @return the e3 entry
	 * @throws NoSuchE3EntryException if a e3 entry with the primary key could not be found
	 */
	@Override
	public E3Entry findByPrimaryKey(long entryId)
		throws NoSuchE3EntryException {

		return findByPrimaryKey((Serializable)entryId);
	}

	/**
	 * Returns the e3 entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the e3 entry
	 * @return the e3 entry, or <code>null</code> if a e3 entry with the primary key could not be found
	 */
	@Override
	public E3Entry fetchByPrimaryKey(long entryId) {
		return fetchByPrimaryKey((Serializable)entryId);
	}

	/**
	 * Returns all the e3 entries.
	 *
	 * @return the e3 entries
	 */
	@Override
	public List<E3Entry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @return the range of e3 entries
	 */
	@Override
	public List<E3Entry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e3 entries
	 */
	@Override
	public List<E3Entry> findAll(
		int start, int end, OrderByComparator<E3Entry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e3 entries
	 * @param end the upper bound of the range of e3 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of e3 entries
	 */
	@Override
	public List<E3Entry> findAll(
		int start, int end, OrderByComparator<E3Entry> orderByComparator,
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

		List<E3Entry> list = null;

		if (useFinderCache) {
			list = (List<E3Entry>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_E3ENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_E3ENTRY;

				sql = sql.concat(E3EntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<E3Entry>)QueryUtil.list(
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
	 * Removes all the e3 entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (E3Entry e3Entry : findAll()) {
			remove(e3Entry);
		}
	}

	/**
	 * Returns the number of e3 entries.
	 *
	 * @return the number of e3 entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_E3ENTRY);

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
		return "entry_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_E3ENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return E3EntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the e3 entry persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new E3EntryModelArgumentsResolver(),
			new HashMapDictionary<>());

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

		_finderPathWithPaginationFindByUuid_Head = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_Head",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "head"}, true);

		_finderPathWithoutPaginationFindByUuid_Head = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_Head",
			new String[] {String.class.getName(), Boolean.class.getName()},
			new String[] {"uuid_", "head"}, true);

		_finderPathCountByUuid_Head = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_Head",
			new String[] {String.class.getName(), Boolean.class.getName()},
			new String[] {"uuid_", "head"}, false);

		_finderPathWithPaginationFindByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUUID_G",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathWithoutPaginationFindByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathFetchByUUID_G_Head = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G_Head",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"uuid_", "groupId", "head"}, true);

		_finderPathCountByUUID_G_Head = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G_Head",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"uuid_", "groupId", "head"}, false);

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

		_finderPathWithPaginationFindByUuid_C_Head = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C_Head",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId", "head"}, true);

		_finderPathWithoutPaginationFindByUuid_C_Head = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C_Head",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"uuid_", "companyId", "head"}, true);

		_finderPathCountByUuid_C_Head = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C_Head",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"uuid_", "companyId", "head"}, false);

		_finderPathWithPaginationFindByxid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByxid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"entry_xid"}, true);

		_finderPathWithoutPaginationFindByxid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByxid",
			new String[] {String.class.getName()}, new String[] {"entry_xid"},
			true);

		_finderPathCountByxid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByxid",
			new String[] {String.class.getName()}, new String[] {"entry_xid"},
			false);

		_finderPathFetchByxid_Head = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByxid_Head",
			new String[] {String.class.getName(), Boolean.class.getName()},
			new String[] {"entry_xid", "head"}, true);

		_finderPathCountByxid_Head = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByxid_Head",
			new String[] {String.class.getName(), Boolean.class.getName()},
			new String[] {"entry_xid", "head"}, false);

		_finderPathWithPaginationFindByp_f = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByp_f",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"parent_id", "parent_field"}, true);

		_finderPathWithoutPaginationFindByp_f = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByp_f",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"parent_id", "parent_field"}, true);

		_finderPathCountByp_f = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByp_f",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"parent_id", "parent_field"}, false);

		_finderPathFetchByp_f_Head = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByp_f_Head",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"parent_id", "parent_field", "head"}, true);

		_finderPathCountByp_f_Head = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByp_f_Head",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"parent_id", "parent_field", "head"}, false);

		_finderPathWithPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"status"}, true);

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Long.class.getName()}, new String[] {"status"}, true);

		_finderPathCountByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Long.class.getName()}, new String[] {"status"},
			false);

		_finderPathWithPaginationFindByStatus_Head = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus_Head",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"status", "head"}, true);

		_finderPathWithoutPaginationFindByStatus_Head = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus_Head",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"status", "head"}, true);

		_finderPathCountByStatus_Head = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus_Head",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"status", "head"}, false);

		_finderPathWithPaginationFindByG_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "status"}, true);

		_finderPathWithoutPaginationFindByG_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "status"}, true);

		_finderPathCountByG_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "status"}, false);

		_finderPathWithPaginationFindByG_S_Head = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S_Head",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId", "status", "head"}, true);

		_finderPathWithoutPaginationFindByG_S_Head = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S_Head",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"groupId", "status", "head"}, true);

		_finderPathCountByG_S_Head = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S_Head",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"groupId", "status", "head"}, false);

		_finderPathFetchByHeadId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByHeadId",
			new String[] {Long.class.getName()}, new String[] {"headId"}, true);

		_finderPathCountByHeadId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHeadId",
			new String[] {Long.class.getName()}, new String[] {"headId"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(E3EntryImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();
	}

	@Override
	@Reference(
		target = EncyThreeEntryPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = EncyThreeEntryPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = EncyThreeEntryPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_E3ENTRY =
		"SELECT e3Entry FROM E3Entry e3Entry";

	private static final String _SQL_SELECT_E3ENTRY_WHERE =
		"SELECT e3Entry FROM E3Entry e3Entry WHERE ";

	private static final String _SQL_COUNT_E3ENTRY =
		"SELECT COUNT(e3Entry) FROM E3Entry e3Entry";

	private static final String _SQL_COUNT_E3ENTRY_WHERE =
		"SELECT COUNT(e3Entry) FROM E3Entry e3Entry WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"e3Entry.entry_id";

	private static final String _FILTER_SQL_SELECT_E3ENTRY_WHERE =
		"SELECT DISTINCT {e3Entry.*} FROM E3Entry e3Entry WHERE ";

	private static final String
		_FILTER_SQL_SELECT_E3ENTRY_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {E3Entry.*} FROM (SELECT DISTINCT e3Entry.entry_id FROM E3Entry e3Entry WHERE ";

	private static final String
		_FILTER_SQL_SELECT_E3ENTRY_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN E3Entry ON TEMP_TABLE.entry_id = E3Entry.entry_id";

	private static final String _FILTER_SQL_COUNT_E3ENTRY_WHERE =
		"SELECT COUNT(DISTINCT e3Entry.entry_id) AS COUNT_VALUE FROM E3Entry e3Entry WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "e3Entry";

	private static final String _FILTER_ENTITY_TABLE = "E3Entry";

	private static final String _ORDER_BY_ENTITY_ALIAS = "e3Entry.";

	private static final String _ORDER_BY_ENTITY_TABLE = "E3Entry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No E3Entry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No E3Entry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		E3EntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "entryId", "userId", "userName", "createDate",
			"modifiedDate", "authorId", "authorName", "xid", "name", "appClass",
			"parentId", "parentField", "values"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class E3EntryModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			E3EntryModelImpl e3EntryModelImpl = (E3EntryModelImpl)baseModel;

			long columnBitmask = e3EntryModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(e3EntryModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						e3EntryModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(e3EntryModelImpl, columnNames, original);
			}

			return null;
		}

		@Override
		public String getClassName() {
			return E3EntryImpl.class.getName();
		}

		@Override
		public String getTableName() {
			return E3EntryTable.INSTANCE.getTableName();
		}

		private static Object[] _getValue(
			E3EntryModelImpl e3EntryModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = e3EntryModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = e3EntryModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			orderByColumnsBitmask |= E3EntryModelImpl.getColumnBitmask(
				"entry_name");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}