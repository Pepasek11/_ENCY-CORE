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
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryVersionException;
import cz.csob.ency.modules.e3.entry.model.E3EntryVersion;
import cz.csob.ency.modules.e3.entry.model.E3EntryVersionTable;
import cz.csob.ency.modules.e3.entry.model.impl.E3EntryVersionImpl;
import cz.csob.ency.modules.e3.entry.model.impl.E3EntryVersionModelImpl;
import cz.csob.ency.modules.e3.entry.service.persistence.E3EntryVersionPersistence;
import cz.csob.ency.modules.e3.entry.service.persistence.impl.constants.EncyThreeEntryPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the e3 entry version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {E3EntryVersionPersistence.class, BasePersistence.class})
public class E3EntryVersionPersistenceImpl
	extends BasePersistenceImpl<E3EntryVersion>
	implements E3EntryVersionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>E3EntryVersionUtil</code> to access the e3 entry version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		E3EntryVersionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByEntryId;
	private FinderPath _finderPathWithoutPaginationFindByEntryId;
	private FinderPath _finderPathCountByEntryId;

	/**
	 * Returns all the e3 entry versions where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @return the matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByEntryId(long entryId) {
		return findByEntryId(
			entryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entry versions where entryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param entryId the entry ID
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByEntryId(
		long entryId, int start, int end) {

		return findByEntryId(entryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where entryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param entryId the entry ID
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByEntryId(
		long entryId, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return findByEntryId(entryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where entryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param entryId the entry ID
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByEntryId(
		long entryId, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEntryId;
				finderArgs = new Object[] {entryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEntryId;
			finderArgs = new Object[] {entryId, start, end, orderByComparator};
		}

		List<E3EntryVersion> list = null;

		if (useFinderCache) {
			list = (List<E3EntryVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3EntryVersion e3EntryVersion : list) {
					if (entryId != e3EntryVersion.getEntryId()) {
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

			sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

			sb.append(_FINDER_COLUMN_ENTRYID_ENTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entryId);

				list = (List<E3EntryVersion>)QueryUtil.list(
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
	 * Returns the first e3 entry version in the ordered set where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByEntryId_First(
			long entryId, OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByEntryId_First(
			entryId, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entryId=");
		sb.append(entryId);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the first e3 entry version in the ordered set where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByEntryId_First(
		long entryId, OrderByComparator<E3EntryVersion> orderByComparator) {

		List<E3EntryVersion> list = findByEntryId(
			entryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry version in the ordered set where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByEntryId_Last(
			long entryId, OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByEntryId_Last(
			entryId, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entryId=");
		sb.append(entryId);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the last e3 entry version in the ordered set where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByEntryId_Last(
		long entryId, OrderByComparator<E3EntryVersion> orderByComparator) {

		int count = countByEntryId(entryId);

		if (count == 0) {
			return null;
		}

		List<E3EntryVersion> list = findByEntryId(
			entryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where entryId = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param entryId the entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	@Override
	public E3EntryVersion[] findByEntryId_PrevAndNext(
			long e3EntryVersionId, long entryId,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = findByPrimaryKey(e3EntryVersionId);

		Session session = null;

		try {
			session = openSession();

			E3EntryVersion[] array = new E3EntryVersionImpl[3];

			array[0] = getByEntryId_PrevAndNext(
				session, e3EntryVersion, entryId, orderByComparator, true);

			array[1] = e3EntryVersion;

			array[2] = getByEntryId_PrevAndNext(
				session, e3EntryVersion, entryId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected E3EntryVersion getByEntryId_PrevAndNext(
		Session session, E3EntryVersion e3EntryVersion, long entryId,
		OrderByComparator<E3EntryVersion> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

		sb.append(_FINDER_COLUMN_ENTRYID_ENTRYID_2);

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
			sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(entryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						e3EntryVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3EntryVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entry versions where entryId = &#63; from the database.
	 *
	 * @param entryId the entry ID
	 */
	@Override
	public void removeByEntryId(long entryId) {
		for (E3EntryVersion e3EntryVersion :
				findByEntryId(
					entryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(e3EntryVersion);
		}
	}

	/**
	 * Returns the number of e3 entry versions where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @return the number of matching e3 entry versions
	 */
	@Override
	public int countByEntryId(long entryId) {
		FinderPath finderPath = _finderPathCountByEntryId;

		Object[] finderArgs = new Object[] {entryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_E3ENTRYVERSION_WHERE);

			sb.append(_FINDER_COLUMN_ENTRYID_ENTRYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entryId);

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

	private static final String _FINDER_COLUMN_ENTRYID_ENTRYID_2 =
		"e3EntryVersion.entryId = ?";

	private FinderPath _finderPathFetchByEntryId_Version;
	private FinderPath _finderPathCountByEntryId_Version;

	/**
	 * Returns the e3 entry version where entryId = &#63; and version = &#63; or throws a <code>NoSuchE3EntryVersionException</code> if it could not be found.
	 *
	 * @param entryId the entry ID
	 * @param version the version
	 * @return the matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByEntryId_Version(long entryId, int version)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByEntryId_Version(
			entryId, version);

		if (e3EntryVersion == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("entryId=");
			sb.append(entryId);

			sb.append(", version=");
			sb.append(version);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchE3EntryVersionException(sb.toString());
		}

		return e3EntryVersion;
	}

	/**
	 * Returns the e3 entry version where entryId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param entryId the entry ID
	 * @param version the version
	 * @return the matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByEntryId_Version(long entryId, int version) {
		return fetchByEntryId_Version(entryId, version, true);
	}

	/**
	 * Returns the e3 entry version where entryId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param entryId the entry ID
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByEntryId_Version(
		long entryId, int version, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {entryId, version};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByEntryId_Version, finderArgs);
		}

		if (result instanceof E3EntryVersion) {
			E3EntryVersion e3EntryVersion = (E3EntryVersion)result;

			if ((entryId != e3EntryVersion.getEntryId()) ||
				(version != e3EntryVersion.getVersion())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

			sb.append(_FINDER_COLUMN_ENTRYID_VERSION_ENTRYID_2);

			sb.append(_FINDER_COLUMN_ENTRYID_VERSION_VERSION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entryId);

				queryPos.add(version);

				List<E3EntryVersion> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByEntryId_Version, finderArgs,
							list);
					}
				}
				else {
					E3EntryVersion e3EntryVersion = list.get(0);

					result = e3EntryVersion;

					cacheResult(e3EntryVersion);
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
			return (E3EntryVersion)result;
		}
	}

	/**
	 * Removes the e3 entry version where entryId = &#63; and version = &#63; from the database.
	 *
	 * @param entryId the entry ID
	 * @param version the version
	 * @return the e3 entry version that was removed
	 */
	@Override
	public E3EntryVersion removeByEntryId_Version(long entryId, int version)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = findByEntryId_Version(entryId, version);

		return remove(e3EntryVersion);
	}

	/**
	 * Returns the number of e3 entry versions where entryId = &#63; and version = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	@Override
	public int countByEntryId_Version(long entryId, int version) {
		FinderPath finderPath = _finderPathCountByEntryId_Version;

		Object[] finderArgs = new Object[] {entryId, version};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_E3ENTRYVERSION_WHERE);

			sb.append(_FINDER_COLUMN_ENTRYID_VERSION_ENTRYID_2);

			sb.append(_FINDER_COLUMN_ENTRYID_VERSION_VERSION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entryId);

				queryPos.add(version);

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

	private static final String _FINDER_COLUMN_ENTRYID_VERSION_ENTRYID_2 =
		"e3EntryVersion.entryId = ? AND ";

	private static final String _FINDER_COLUMN_ENTRYID_VERSION_VERSION_2 =
		"e3EntryVersion.version = ?";

	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the e3 entry versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entry versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
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

		List<E3EntryVersion> list = null;

		if (useFinderCache) {
			list = (List<E3EntryVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3EntryVersion e3EntryVersion : list) {
					if (!uuid.equals(e3EntryVersion.getUuid())) {
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

			sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

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
				sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
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

				list = (List<E3EntryVersion>)QueryUtil.list(
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
	 * Returns the first e3 entry version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByUuid_First(
			String uuid, OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByUuid_First(
			uuid, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByUuid_First(
		String uuid, OrderByComparator<E3EntryVersion> orderByComparator) {

		List<E3EntryVersion> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByUuid_Last(
			String uuid, OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByUuid_Last(
			uuid, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByUuid_Last(
		String uuid, OrderByComparator<E3EntryVersion> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<E3EntryVersion> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where uuid = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	@Override
	public E3EntryVersion[] findByUuid_PrevAndNext(
			long e3EntryVersionId, String uuid,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		uuid = Objects.toString(uuid, "");

		E3EntryVersion e3EntryVersion = findByPrimaryKey(e3EntryVersionId);

		Session session = null;

		try {
			session = openSession();

			E3EntryVersion[] array = new E3EntryVersionImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, e3EntryVersion, uuid, orderByComparator, true);

			array[1] = e3EntryVersion;

			array[2] = getByUuid_PrevAndNext(
				session, e3EntryVersion, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected E3EntryVersion getByUuid_PrevAndNext(
		Session session, E3EntryVersion e3EntryVersion, String uuid,
		OrderByComparator<E3EntryVersion> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

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
			sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
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
						e3EntryVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3EntryVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entry versions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (E3EntryVersion e3EntryVersion :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(e3EntryVersion);
		}
	}

	/**
	 * Returns the number of e3 entry versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e3 entry versions
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_E3ENTRYVERSION_WHERE);

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
		"e3EntryVersion.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(e3EntryVersion.uuid IS NULL OR e3EntryVersion.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_Version;
	private FinderPath _finderPathWithoutPaginationFindByUuid_Version;
	private FinderPath _finderPathCountByUuid_Version;

	/**
	 * Returns all the e3 entry versions where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByUuid_Version(String uuid, int version) {
		return findByUuid_Version(
			uuid, version, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entry versions where uuid = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByUuid_Version(
		String uuid, int version, int start, int end) {

		return findByUuid_Version(uuid, version, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where uuid = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByUuid_Version(
		String uuid, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return findByUuid_Version(
			uuid, version, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where uuid = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByUuid_Version(
		String uuid, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_Version;
				finderArgs = new Object[] {uuid, version};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_Version;
			finderArgs = new Object[] {
				uuid, version, start, end, orderByComparator
			};
		}

		List<E3EntryVersion> list = null;

		if (useFinderCache) {
			list = (List<E3EntryVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3EntryVersion e3EntryVersion : list) {
					if (!uuid.equals(e3EntryVersion.getUuid()) ||
						(version != e3EntryVersion.getVersion())) {

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

			sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_VERSION_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_VERSION_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_VERSION_VERSION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(version);

				list = (List<E3EntryVersion>)QueryUtil.list(
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
	 * Returns the first e3 entry version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByUuid_Version_First(
			String uuid, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByUuid_Version_First(
			uuid, version, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", version=");
		sb.append(version);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByUuid_Version_First(
		String uuid, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		List<E3EntryVersion> list = findByUuid_Version(
			uuid, version, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByUuid_Version_Last(
			String uuid, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByUuid_Version_Last(
			uuid, version, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", version=");
		sb.append(version);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByUuid_Version_Last(
		String uuid, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		int count = countByUuid_Version(uuid, version);

		if (count == 0) {
			return null;
		}

		List<E3EntryVersion> list = findByUuid_Version(
			uuid, version, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	@Override
	public E3EntryVersion[] findByUuid_Version_PrevAndNext(
			long e3EntryVersionId, String uuid, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		uuid = Objects.toString(uuid, "");

		E3EntryVersion e3EntryVersion = findByPrimaryKey(e3EntryVersionId);

		Session session = null;

		try {
			session = openSession();

			E3EntryVersion[] array = new E3EntryVersionImpl[3];

			array[0] = getByUuid_Version_PrevAndNext(
				session, e3EntryVersion, uuid, version, orderByComparator,
				true);

			array[1] = e3EntryVersion;

			array[2] = getByUuid_Version_PrevAndNext(
				session, e3EntryVersion, uuid, version, orderByComparator,
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

	protected E3EntryVersion getByUuid_Version_PrevAndNext(
		Session session, E3EntryVersion e3EntryVersion, String uuid,
		int version, OrderByComparator<E3EntryVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_VERSION_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_VERSION_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_VERSION_VERSION_2);

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
			sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(version);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						e3EntryVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3EntryVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entry versions where uuid = &#63; and version = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 */
	@Override
	public void removeByUuid_Version(String uuid, int version) {
		for (E3EntryVersion e3EntryVersion :
				findByUuid_Version(
					uuid, version, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(e3EntryVersion);
		}
	}

	/**
	 * Returns the number of e3 entry versions where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	@Override
	public int countByUuid_Version(String uuid, int version) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_Version;

		Object[] finderArgs = new Object[] {uuid, version};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_E3ENTRYVERSION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_VERSION_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_VERSION_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_VERSION_VERSION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(version);

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

	private static final String _FINDER_COLUMN_UUID_VERSION_UUID_2 =
		"e3EntryVersion.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_VERSION_UUID_3 =
		"(e3EntryVersion.uuid IS NULL OR e3EntryVersion.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_VERSION_VERSION_2 =
		"e3EntryVersion.version = ?";

	private FinderPath _finderPathWithPaginationFindByUUID_G;
	private FinderPath _finderPathWithoutPaginationFindByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns all the e3 entry versions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByUUID_G(String uuid, long groupId) {
		return findByUUID_G(
			uuid, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entry versions where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByUUID_G(
		String uuid, long groupId, int start, int end) {

		return findByUUID_G(uuid, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByUUID_G(
		String uuid, long groupId, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return findByUUID_G(uuid, groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByUUID_G(
		String uuid, long groupId, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

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

		List<E3EntryVersion> list = null;

		if (useFinderCache) {
			list = (List<E3EntryVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3EntryVersion e3EntryVersion : list) {
					if (!uuid.equals(e3EntryVersion.getUuid()) ||
						(groupId != e3EntryVersion.getGroupId())) {

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

			sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

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
				sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
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

				list = (List<E3EntryVersion>)QueryUtil.list(
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
	 * Returns the first e3 entry version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByUUID_G_First(
			String uuid, long groupId,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByUUID_G_First(
			uuid, groupId, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByUUID_G_First(
		String uuid, long groupId,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		List<E3EntryVersion> list = findByUUID_G(
			uuid, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByUUID_G_Last(
			String uuid, long groupId,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByUUID_G_Last(
			uuid, groupId, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByUUID_G_Last(
		String uuid, long groupId,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		int count = countByUUID_G(uuid, groupId);

		if (count == 0) {
			return null;
		}

		List<E3EntryVersion> list = findByUUID_G(
			uuid, groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	@Override
	public E3EntryVersion[] findByUUID_G_PrevAndNext(
			long e3EntryVersionId, String uuid, long groupId,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		uuid = Objects.toString(uuid, "");

		E3EntryVersion e3EntryVersion = findByPrimaryKey(e3EntryVersionId);

		Session session = null;

		try {
			session = openSession();

			E3EntryVersion[] array = new E3EntryVersionImpl[3];

			array[0] = getByUUID_G_PrevAndNext(
				session, e3EntryVersion, uuid, groupId, orderByComparator,
				true);

			array[1] = e3EntryVersion;

			array[2] = getByUUID_G_PrevAndNext(
				session, e3EntryVersion, uuid, groupId, orderByComparator,
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

	protected E3EntryVersion getByUUID_G_PrevAndNext(
		Session session, E3EntryVersion e3EntryVersion, String uuid,
		long groupId, OrderByComparator<E3EntryVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

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
			sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						e3EntryVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3EntryVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entry versions where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 */
	@Override
	public void removeByUUID_G(String uuid, long groupId) {
		for (E3EntryVersion e3EntryVersion :
				findByUUID_G(
					uuid, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(e3EntryVersion);
		}
	}

	/**
	 * Returns the number of e3 entry versions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e3 entry versions
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_E3ENTRYVERSION_WHERE);

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
		"e3EntryVersion.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(e3EntryVersion.uuid IS NULL OR e3EntryVersion.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"e3EntryVersion.groupId = ?";

	private FinderPath _finderPathFetchByUUID_G_Version;
	private FinderPath _finderPathCountByUUID_G_Version;

	/**
	 * Returns the e3 entry version where uuid = &#63; and groupId = &#63; and version = &#63; or throws a <code>NoSuchE3EntryVersionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByUUID_G_Version(
			String uuid, long groupId, int version)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByUUID_G_Version(
			uuid, groupId, version);

		if (e3EntryVersion == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append(", version=");
			sb.append(version);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchE3EntryVersionException(sb.toString());
		}

		return e3EntryVersion;
	}

	/**
	 * Returns the e3 entry version where uuid = &#63; and groupId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByUUID_G_Version(
		String uuid, long groupId, int version) {

		return fetchByUUID_G_Version(uuid, groupId, version, true);
	}

	/**
	 * Returns the e3 entry version where uuid = &#63; and groupId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByUUID_G_Version(
		String uuid, long groupId, int version, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId, version};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G_Version, finderArgs);
		}

		if (result instanceof E3EntryVersion) {
			E3EntryVersion e3EntryVersion = (E3EntryVersion)result;

			if (!Objects.equals(uuid, e3EntryVersion.getUuid()) ||
				(groupId != e3EntryVersion.getGroupId()) ||
				(version != e3EntryVersion.getVersion())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_VERSION_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_VERSION_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_VERSION_GROUPID_2);

			sb.append(_FINDER_COLUMN_UUID_G_VERSION_VERSION_2);

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

				queryPos.add(version);

				List<E3EntryVersion> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G_Version, finderArgs, list);
					}
				}
				else {
					E3EntryVersion e3EntryVersion = list.get(0);

					result = e3EntryVersion;

					cacheResult(e3EntryVersion);
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
			return (E3EntryVersion)result;
		}
	}

	/**
	 * Removes the e3 entry version where uuid = &#63; and groupId = &#63; and version = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the e3 entry version that was removed
	 */
	@Override
	public E3EntryVersion removeByUUID_G_Version(
			String uuid, long groupId, int version)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = findByUUID_G_Version(
			uuid, groupId, version);

		return remove(e3EntryVersion);
	}

	/**
	 * Returns the number of e3 entry versions where uuid = &#63; and groupId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	@Override
	public int countByUUID_G_Version(String uuid, long groupId, int version) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G_Version;

		Object[] finderArgs = new Object[] {uuid, groupId, version};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_E3ENTRYVERSION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_VERSION_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_VERSION_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_VERSION_GROUPID_2);

			sb.append(_FINDER_COLUMN_UUID_G_VERSION_VERSION_2);

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

				queryPos.add(version);

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

	private static final String _FINDER_COLUMN_UUID_G_VERSION_UUID_2 =
		"e3EntryVersion.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_VERSION_UUID_3 =
		"(e3EntryVersion.uuid IS NULL OR e3EntryVersion.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_VERSION_GROUPID_2 =
		"e3EntryVersion.groupId = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_VERSION_VERSION_2 =
		"e3EntryVersion.version = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the e3 entry versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entry versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
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

		List<E3EntryVersion> list = null;

		if (useFinderCache) {
			list = (List<E3EntryVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3EntryVersion e3EntryVersion : list) {
					if (!uuid.equals(e3EntryVersion.getUuid()) ||
						(companyId != e3EntryVersion.getCompanyId())) {

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

			sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

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
				sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
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

				list = (List<E3EntryVersion>)QueryUtil.list(
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
	 * Returns the first e3 entry version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		List<E3EntryVersion> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<E3EntryVersion> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	@Override
	public E3EntryVersion[] findByUuid_C_PrevAndNext(
			long e3EntryVersionId, String uuid, long companyId,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		uuid = Objects.toString(uuid, "");

		E3EntryVersion e3EntryVersion = findByPrimaryKey(e3EntryVersionId);

		Session session = null;

		try {
			session = openSession();

			E3EntryVersion[] array = new E3EntryVersionImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, e3EntryVersion, uuid, companyId, orderByComparator,
				true);

			array[1] = e3EntryVersion;

			array[2] = getByUuid_C_PrevAndNext(
				session, e3EntryVersion, uuid, companyId, orderByComparator,
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

	protected E3EntryVersion getByUuid_C_PrevAndNext(
		Session session, E3EntryVersion e3EntryVersion, String uuid,
		long companyId, OrderByComparator<E3EntryVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

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
			sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						e3EntryVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3EntryVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entry versions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (E3EntryVersion e3EntryVersion :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(e3EntryVersion);
		}
	}

	/**
	 * Returns the number of e3 entry versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e3 entry versions
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_E3ENTRYVERSION_WHERE);

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
		"e3EntryVersion.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(e3EntryVersion.uuid IS NULL OR e3EntryVersion.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"e3EntryVersion.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C_Version;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C_Version;
	private FinderPath _finderPathCountByUuid_C_Version;

	/**
	 * Returns all the e3 entry versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @return the matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByUuid_C_Version(
		String uuid, long companyId, int version) {

		return findByUuid_C_Version(
			uuid, companyId, version, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e3 entry versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByUuid_C_Version(
		String uuid, long companyId, int version, int start, int end) {

		return findByUuid_C_Version(uuid, companyId, version, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByUuid_C_Version(
		String uuid, long companyId, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return findByUuid_C_Version(
			uuid, companyId, version, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByUuid_C_Version(
		String uuid, long companyId, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C_Version;
				finderArgs = new Object[] {uuid, companyId, version};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C_Version;
			finderArgs = new Object[] {
				uuid, companyId, version, start, end, orderByComparator
			};
		}

		List<E3EntryVersion> list = null;

		if (useFinderCache) {
			list = (List<E3EntryVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3EntryVersion e3EntryVersion : list) {
					if (!uuid.equals(e3EntryVersion.getUuid()) ||
						(companyId != e3EntryVersion.getCompanyId()) ||
						(version != e3EntryVersion.getVersion())) {

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

			sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_VERSION_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_VERSION_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_VERSION_COMPANYID_2);

			sb.append(_FINDER_COLUMN_UUID_C_VERSION_VERSION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(version);

				list = (List<E3EntryVersion>)QueryUtil.list(
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
	 * Returns the first e3 entry version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByUuid_C_Version_First(
			String uuid, long companyId, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByUuid_C_Version_First(
			uuid, companyId, version, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append(", version=");
		sb.append(version);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the first e3 entry version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByUuid_C_Version_First(
		String uuid, long companyId, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		List<E3EntryVersion> list = findByUuid_C_Version(
			uuid, companyId, version, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByUuid_C_Version_Last(
			String uuid, long companyId, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByUuid_C_Version_Last(
			uuid, companyId, version, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append(", version=");
		sb.append(version);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the last e3 entry version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByUuid_C_Version_Last(
		String uuid, long companyId, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		int count = countByUuid_C_Version(uuid, companyId, version);

		if (count == 0) {
			return null;
		}

		List<E3EntryVersion> list = findByUuid_C_Version(
			uuid, companyId, version, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	@Override
	public E3EntryVersion[] findByUuid_C_Version_PrevAndNext(
			long e3EntryVersionId, String uuid, long companyId, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		uuid = Objects.toString(uuid, "");

		E3EntryVersion e3EntryVersion = findByPrimaryKey(e3EntryVersionId);

		Session session = null;

		try {
			session = openSession();

			E3EntryVersion[] array = new E3EntryVersionImpl[3];

			array[0] = getByUuid_C_Version_PrevAndNext(
				session, e3EntryVersion, uuid, companyId, version,
				orderByComparator, true);

			array[1] = e3EntryVersion;

			array[2] = getByUuid_C_Version_PrevAndNext(
				session, e3EntryVersion, uuid, companyId, version,
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

	protected E3EntryVersion getByUuid_C_Version_PrevAndNext(
		Session session, E3EntryVersion e3EntryVersion, String uuid,
		long companyId, int version,
		OrderByComparator<E3EntryVersion> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_VERSION_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_VERSION_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_VERSION_COMPANYID_2);

		sb.append(_FINDER_COLUMN_UUID_C_VERSION_VERSION_2);

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
			sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
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

		queryPos.add(version);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						e3EntryVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3EntryVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entry versions where uuid = &#63; and companyId = &#63; and version = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 */
	@Override
	public void removeByUuid_C_Version(
		String uuid, long companyId, int version) {

		for (E3EntryVersion e3EntryVersion :
				findByUuid_C_Version(
					uuid, companyId, version, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(e3EntryVersion);
		}
	}

	/**
	 * Returns the number of e3 entry versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	@Override
	public int countByUuid_C_Version(String uuid, long companyId, int version) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C_Version;

		Object[] finderArgs = new Object[] {uuid, companyId, version};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_E3ENTRYVERSION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_VERSION_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_VERSION_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_VERSION_COMPANYID_2);

			sb.append(_FINDER_COLUMN_UUID_C_VERSION_VERSION_2);

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

				queryPos.add(version);

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

	private static final String _FINDER_COLUMN_UUID_C_VERSION_UUID_2 =
		"e3EntryVersion.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_VERSION_UUID_3 =
		"(e3EntryVersion.uuid IS NULL OR e3EntryVersion.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_VERSION_COMPANYID_2 =
		"e3EntryVersion.companyId = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_VERSION_VERSION_2 =
		"e3EntryVersion.version = ?";

	private FinderPath _finderPathWithPaginationFindByxid;
	private FinderPath _finderPathWithoutPaginationFindByxid;
	private FinderPath _finderPathCountByxid;

	/**
	 * Returns all the e3 entry versions where xid = &#63;.
	 *
	 * @param xid the xid
	 * @return the matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByxid(String xid) {
		return findByxid(xid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entry versions where xid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param xid the xid
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByxid(String xid, int start, int end) {
		return findByxid(xid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where xid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param xid the xid
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByxid(
		String xid, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return findByxid(xid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where xid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param xid the xid
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByxid(
		String xid, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

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

		List<E3EntryVersion> list = null;

		if (useFinderCache) {
			list = (List<E3EntryVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3EntryVersion e3EntryVersion : list) {
					if (!xid.equals(e3EntryVersion.getXid())) {
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

			sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

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
				sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
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

				list = (List<E3EntryVersion>)QueryUtil.list(
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
	 * Returns the first e3 entry version in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByxid_First(
			String xid, OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByxid_First(
			xid, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("xid=");
		sb.append(xid);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the first e3 entry version in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByxid_First(
		String xid, OrderByComparator<E3EntryVersion> orderByComparator) {

		List<E3EntryVersion> list = findByxid(xid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry version in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByxid_Last(
			String xid, OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByxid_Last(xid, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("xid=");
		sb.append(xid);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the last e3 entry version in the ordered set where xid = &#63;.
	 *
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByxid_Last(
		String xid, OrderByComparator<E3EntryVersion> orderByComparator) {

		int count = countByxid(xid);

		if (count == 0) {
			return null;
		}

		List<E3EntryVersion> list = findByxid(
			xid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where xid = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param xid the xid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	@Override
	public E3EntryVersion[] findByxid_PrevAndNext(
			long e3EntryVersionId, String xid,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		xid = Objects.toString(xid, "");

		E3EntryVersion e3EntryVersion = findByPrimaryKey(e3EntryVersionId);

		Session session = null;

		try {
			session = openSession();

			E3EntryVersion[] array = new E3EntryVersionImpl[3];

			array[0] = getByxid_PrevAndNext(
				session, e3EntryVersion, xid, orderByComparator, true);

			array[1] = e3EntryVersion;

			array[2] = getByxid_PrevAndNext(
				session, e3EntryVersion, xid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected E3EntryVersion getByxid_PrevAndNext(
		Session session, E3EntryVersion e3EntryVersion, String xid,
		OrderByComparator<E3EntryVersion> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

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
			sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						e3EntryVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3EntryVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entry versions where xid = &#63; from the database.
	 *
	 * @param xid the xid
	 */
	@Override
	public void removeByxid(String xid) {
		for (E3EntryVersion e3EntryVersion :
				findByxid(xid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(e3EntryVersion);
		}
	}

	/**
	 * Returns the number of e3 entry versions where xid = &#63;.
	 *
	 * @param xid the xid
	 * @return the number of matching e3 entry versions
	 */
	@Override
	public int countByxid(String xid) {
		xid = Objects.toString(xid, "");

		FinderPath finderPath = _finderPathCountByxid;

		Object[] finderArgs = new Object[] {xid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_E3ENTRYVERSION_WHERE);

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

	private static final String _FINDER_COLUMN_XID_XID_2 =
		"e3EntryVersion.xid = ?";

	private static final String _FINDER_COLUMN_XID_XID_3 =
		"(e3EntryVersion.xid IS NULL OR e3EntryVersion.xid = '')";

	private FinderPath _finderPathWithPaginationFindByxid_Version;
	private FinderPath _finderPathWithoutPaginationFindByxid_Version;
	private FinderPath _finderPathCountByxid_Version;

	/**
	 * Returns all the e3 entry versions where xid = &#63; and version = &#63;.
	 *
	 * @param xid the xid
	 * @param version the version
	 * @return the matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByxid_Version(String xid, int version) {
		return findByxid_Version(
			xid, version, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entry versions where xid = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param xid the xid
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByxid_Version(
		String xid, int version, int start, int end) {

		return findByxid_Version(xid, version, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where xid = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param xid the xid
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByxid_Version(
		String xid, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return findByxid_Version(
			xid, version, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where xid = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param xid the xid
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByxid_Version(
		String xid, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

		xid = Objects.toString(xid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByxid_Version;
				finderArgs = new Object[] {xid, version};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByxid_Version;
			finderArgs = new Object[] {
				xid, version, start, end, orderByComparator
			};
		}

		List<E3EntryVersion> list = null;

		if (useFinderCache) {
			list = (List<E3EntryVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3EntryVersion e3EntryVersion : list) {
					if (!xid.equals(e3EntryVersion.getXid()) ||
						(version != e3EntryVersion.getVersion())) {

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

			sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

			boolean bindXid = false;

			if (xid.isEmpty()) {
				sb.append(_FINDER_COLUMN_XID_VERSION_XID_3);
			}
			else {
				bindXid = true;

				sb.append(_FINDER_COLUMN_XID_VERSION_XID_2);
			}

			sb.append(_FINDER_COLUMN_XID_VERSION_VERSION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(version);

				list = (List<E3EntryVersion>)QueryUtil.list(
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
	 * Returns the first e3 entry version in the ordered set where xid = &#63; and version = &#63;.
	 *
	 * @param xid the xid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByxid_Version_First(
			String xid, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByxid_Version_First(
			xid, version, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("xid=");
		sb.append(xid);

		sb.append(", version=");
		sb.append(version);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the first e3 entry version in the ordered set where xid = &#63; and version = &#63;.
	 *
	 * @param xid the xid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByxid_Version_First(
		String xid, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		List<E3EntryVersion> list = findByxid_Version(
			xid, version, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry version in the ordered set where xid = &#63; and version = &#63;.
	 *
	 * @param xid the xid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByxid_Version_Last(
			String xid, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByxid_Version_Last(
			xid, version, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("xid=");
		sb.append(xid);

		sb.append(", version=");
		sb.append(version);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the last e3 entry version in the ordered set where xid = &#63; and version = &#63;.
	 *
	 * @param xid the xid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByxid_Version_Last(
		String xid, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		int count = countByxid_Version(xid, version);

		if (count == 0) {
			return null;
		}

		List<E3EntryVersion> list = findByxid_Version(
			xid, version, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where xid = &#63; and version = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param xid the xid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	@Override
	public E3EntryVersion[] findByxid_Version_PrevAndNext(
			long e3EntryVersionId, String xid, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		xid = Objects.toString(xid, "");

		E3EntryVersion e3EntryVersion = findByPrimaryKey(e3EntryVersionId);

		Session session = null;

		try {
			session = openSession();

			E3EntryVersion[] array = new E3EntryVersionImpl[3];

			array[0] = getByxid_Version_PrevAndNext(
				session, e3EntryVersion, xid, version, orderByComparator, true);

			array[1] = e3EntryVersion;

			array[2] = getByxid_Version_PrevAndNext(
				session, e3EntryVersion, xid, version, orderByComparator,
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

	protected E3EntryVersion getByxid_Version_PrevAndNext(
		Session session, E3EntryVersion e3EntryVersion, String xid, int version,
		OrderByComparator<E3EntryVersion> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

		boolean bindXid = false;

		if (xid.isEmpty()) {
			sb.append(_FINDER_COLUMN_XID_VERSION_XID_3);
		}
		else {
			bindXid = true;

			sb.append(_FINDER_COLUMN_XID_VERSION_XID_2);
		}

		sb.append(_FINDER_COLUMN_XID_VERSION_VERSION_2);

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
			sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindXid) {
			queryPos.add(xid);
		}

		queryPos.add(version);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						e3EntryVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3EntryVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entry versions where xid = &#63; and version = &#63; from the database.
	 *
	 * @param xid the xid
	 * @param version the version
	 */
	@Override
	public void removeByxid_Version(String xid, int version) {
		for (E3EntryVersion e3EntryVersion :
				findByxid_Version(
					xid, version, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(e3EntryVersion);
		}
	}

	/**
	 * Returns the number of e3 entry versions where xid = &#63; and version = &#63;.
	 *
	 * @param xid the xid
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	@Override
	public int countByxid_Version(String xid, int version) {
		xid = Objects.toString(xid, "");

		FinderPath finderPath = _finderPathCountByxid_Version;

		Object[] finderArgs = new Object[] {xid, version};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_E3ENTRYVERSION_WHERE);

			boolean bindXid = false;

			if (xid.isEmpty()) {
				sb.append(_FINDER_COLUMN_XID_VERSION_XID_3);
			}
			else {
				bindXid = true;

				sb.append(_FINDER_COLUMN_XID_VERSION_XID_2);
			}

			sb.append(_FINDER_COLUMN_XID_VERSION_VERSION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindXid) {
					queryPos.add(xid);
				}

				queryPos.add(version);

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

	private static final String _FINDER_COLUMN_XID_VERSION_XID_2 =
		"e3EntryVersion.xid = ? AND ";

	private static final String _FINDER_COLUMN_XID_VERSION_XID_3 =
		"(e3EntryVersion.xid IS NULL OR e3EntryVersion.xid = '') AND ";

	private static final String _FINDER_COLUMN_XID_VERSION_VERSION_2 =
		"e3EntryVersion.version = ?";

	private FinderPath _finderPathWithPaginationFindByp_f;
	private FinderPath _finderPathWithoutPaginationFindByp_f;
	private FinderPath _finderPathCountByp_f;

	/**
	 * Returns all the e3 entry versions where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @return the matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByp_f(long parentId, String parentField) {
		return findByp_f(
			parentId, parentField, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entry versions where parentId = &#63; and parentField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByp_f(
		long parentId, String parentField, int start, int end) {

		return findByp_f(parentId, parentField, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where parentId = &#63; and parentField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByp_f(
		long parentId, String parentField, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return findByp_f(
			parentId, parentField, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where parentId = &#63; and parentField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByp_f(
		long parentId, String parentField, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

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

		List<E3EntryVersion> list = null;

		if (useFinderCache) {
			list = (List<E3EntryVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3EntryVersion e3EntryVersion : list) {
					if ((parentId != e3EntryVersion.getParentId()) ||
						!parentField.equals(e3EntryVersion.getParentField())) {

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

			sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

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
				sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
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

				list = (List<E3EntryVersion>)QueryUtil.list(
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
	 * Returns the first e3 entry version in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByp_f_First(
			long parentId, String parentField,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByp_f_First(
			parentId, parentField, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentId=");
		sb.append(parentId);

		sb.append(", parentField=");
		sb.append(parentField);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the first e3 entry version in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByp_f_First(
		long parentId, String parentField,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		List<E3EntryVersion> list = findByp_f(
			parentId, parentField, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry version in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByp_f_Last(
			long parentId, String parentField,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByp_f_Last(
			parentId, parentField, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentId=");
		sb.append(parentId);

		sb.append(", parentField=");
		sb.append(parentField);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the last e3 entry version in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByp_f_Last(
		long parentId, String parentField,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		int count = countByp_f(parentId, parentField);

		if (count == 0) {
			return null;
		}

		List<E3EntryVersion> list = findByp_f(
			parentId, parentField, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where parentId = &#63; and parentField = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	@Override
	public E3EntryVersion[] findByp_f_PrevAndNext(
			long e3EntryVersionId, long parentId, String parentField,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		parentField = Objects.toString(parentField, "");

		E3EntryVersion e3EntryVersion = findByPrimaryKey(e3EntryVersionId);

		Session session = null;

		try {
			session = openSession();

			E3EntryVersion[] array = new E3EntryVersionImpl[3];

			array[0] = getByp_f_PrevAndNext(
				session, e3EntryVersion, parentId, parentField,
				orderByComparator, true);

			array[1] = e3EntryVersion;

			array[2] = getByp_f_PrevAndNext(
				session, e3EntryVersion, parentId, parentField,
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

	protected E3EntryVersion getByp_f_PrevAndNext(
		Session session, E3EntryVersion e3EntryVersion, long parentId,
		String parentField, OrderByComparator<E3EntryVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

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
			sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						e3EntryVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3EntryVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entry versions where parentId = &#63; and parentField = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 */
	@Override
	public void removeByp_f(long parentId, String parentField) {
		for (E3EntryVersion e3EntryVersion :
				findByp_f(
					parentId, parentField, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(e3EntryVersion);
		}
	}

	/**
	 * Returns the number of e3 entry versions where parentId = &#63; and parentField = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @return the number of matching e3 entry versions
	 */
	@Override
	public int countByp_f(long parentId, String parentField) {
		parentField = Objects.toString(parentField, "");

		FinderPath finderPath = _finderPathCountByp_f;

		Object[] finderArgs = new Object[] {parentId, parentField};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_E3ENTRYVERSION_WHERE);

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
		"e3EntryVersion.parentId = ? AND ";

	private static final String _FINDER_COLUMN_P_F_PARENTFIELD_2 =
		"e3EntryVersion.parentField = ?";

	private static final String _FINDER_COLUMN_P_F_PARENTFIELD_3 =
		"(e3EntryVersion.parentField IS NULL OR e3EntryVersion.parentField = '')";

	private FinderPath _finderPathWithPaginationFindByp_f_Version;
	private FinderPath _finderPathWithoutPaginationFindByp_f_Version;
	private FinderPath _finderPathCountByp_f_Version;

	/**
	 * Returns all the e3 entry versions where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @return the matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByp_f_Version(
		long parentId, String parentField, int version) {

		return findByp_f_Version(
			parentId, parentField, version, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entry versions where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByp_f_Version(
		long parentId, String parentField, int version, int start, int end) {

		return findByp_f_Version(
			parentId, parentField, version, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByp_f_Version(
		long parentId, String parentField, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return findByp_f_Version(
			parentId, parentField, version, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByp_f_Version(
		long parentId, String parentField, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

		parentField = Objects.toString(parentField, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByp_f_Version;
				finderArgs = new Object[] {parentId, parentField, version};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByp_f_Version;
			finderArgs = new Object[] {
				parentId, parentField, version, start, end, orderByComparator
			};
		}

		List<E3EntryVersion> list = null;

		if (useFinderCache) {
			list = (List<E3EntryVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3EntryVersion e3EntryVersion : list) {
					if ((parentId != e3EntryVersion.getParentId()) ||
						!parentField.equals(e3EntryVersion.getParentField()) ||
						(version != e3EntryVersion.getVersion())) {

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

			sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

			sb.append(_FINDER_COLUMN_P_F_VERSION_PARENTID_2);

			boolean bindParentField = false;

			if (parentField.isEmpty()) {
				sb.append(_FINDER_COLUMN_P_F_VERSION_PARENTFIELD_3);
			}
			else {
				bindParentField = true;

				sb.append(_FINDER_COLUMN_P_F_VERSION_PARENTFIELD_2);
			}

			sb.append(_FINDER_COLUMN_P_F_VERSION_VERSION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(version);

				list = (List<E3EntryVersion>)QueryUtil.list(
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
	 * Returns the first e3 entry version in the ordered set where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByp_f_Version_First(
			long parentId, String parentField, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByp_f_Version_First(
			parentId, parentField, version, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentId=");
		sb.append(parentId);

		sb.append(", parentField=");
		sb.append(parentField);

		sb.append(", version=");
		sb.append(version);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the first e3 entry version in the ordered set where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByp_f_Version_First(
		long parentId, String parentField, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		List<E3EntryVersion> list = findByp_f_Version(
			parentId, parentField, version, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry version in the ordered set where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByp_f_Version_Last(
			long parentId, String parentField, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByp_f_Version_Last(
			parentId, parentField, version, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentId=");
		sb.append(parentId);

		sb.append(", parentField=");
		sb.append(parentField);

		sb.append(", version=");
		sb.append(version);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the last e3 entry version in the ordered set where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByp_f_Version_Last(
		long parentId, String parentField, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		int count = countByp_f_Version(parentId, parentField, version);

		if (count == 0) {
			return null;
		}

		List<E3EntryVersion> list = findByp_f_Version(
			parentId, parentField, version, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	@Override
	public E3EntryVersion[] findByp_f_Version_PrevAndNext(
			long e3EntryVersionId, long parentId, String parentField,
			int version, OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		parentField = Objects.toString(parentField, "");

		E3EntryVersion e3EntryVersion = findByPrimaryKey(e3EntryVersionId);

		Session session = null;

		try {
			session = openSession();

			E3EntryVersion[] array = new E3EntryVersionImpl[3];

			array[0] = getByp_f_Version_PrevAndNext(
				session, e3EntryVersion, parentId, parentField, version,
				orderByComparator, true);

			array[1] = e3EntryVersion;

			array[2] = getByp_f_Version_PrevAndNext(
				session, e3EntryVersion, parentId, parentField, version,
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

	protected E3EntryVersion getByp_f_Version_PrevAndNext(
		Session session, E3EntryVersion e3EntryVersion, long parentId,
		String parentField, int version,
		OrderByComparator<E3EntryVersion> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

		sb.append(_FINDER_COLUMN_P_F_VERSION_PARENTID_2);

		boolean bindParentField = false;

		if (parentField.isEmpty()) {
			sb.append(_FINDER_COLUMN_P_F_VERSION_PARENTFIELD_3);
		}
		else {
			bindParentField = true;

			sb.append(_FINDER_COLUMN_P_F_VERSION_PARENTFIELD_2);
		}

		sb.append(_FINDER_COLUMN_P_F_VERSION_VERSION_2);

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
			sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
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

		queryPos.add(version);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						e3EntryVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3EntryVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entry versions where parentId = &#63; and parentField = &#63; and version = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 */
	@Override
	public void removeByp_f_Version(
		long parentId, String parentField, int version) {

		for (E3EntryVersion e3EntryVersion :
				findByp_f_Version(
					parentId, parentField, version, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(e3EntryVersion);
		}
	}

	/**
	 * Returns the number of e3 entry versions where parentId = &#63; and parentField = &#63; and version = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param parentField the parent field
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	@Override
	public int countByp_f_Version(
		long parentId, String parentField, int version) {

		parentField = Objects.toString(parentField, "");

		FinderPath finderPath = _finderPathCountByp_f_Version;

		Object[] finderArgs = new Object[] {parentId, parentField, version};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_E3ENTRYVERSION_WHERE);

			sb.append(_FINDER_COLUMN_P_F_VERSION_PARENTID_2);

			boolean bindParentField = false;

			if (parentField.isEmpty()) {
				sb.append(_FINDER_COLUMN_P_F_VERSION_PARENTFIELD_3);
			}
			else {
				bindParentField = true;

				sb.append(_FINDER_COLUMN_P_F_VERSION_PARENTFIELD_2);
			}

			sb.append(_FINDER_COLUMN_P_F_VERSION_VERSION_2);

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

				queryPos.add(version);

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

	private static final String _FINDER_COLUMN_P_F_VERSION_PARENTID_2 =
		"e3EntryVersion.parentId = ? AND ";

	private static final String _FINDER_COLUMN_P_F_VERSION_PARENTFIELD_2 =
		"e3EntryVersion.parentField = ? AND ";

	private static final String _FINDER_COLUMN_P_F_VERSION_PARENTFIELD_3 =
		"(e3EntryVersion.parentField IS NULL OR e3EntryVersion.parentField = '') AND ";

	private static final String _FINDER_COLUMN_P_F_VERSION_VERSION_2 =
		"e3EntryVersion.version = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the e3 entry versions where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByStatus(long status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entry versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByStatus(long status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByStatus(
		long status, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByStatus(
		long status, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

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

		List<E3EntryVersion> list = null;

		if (useFinderCache) {
			list = (List<E3EntryVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3EntryVersion e3EntryVersion : list) {
					if (status != e3EntryVersion.getStatus()) {
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

			sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<E3EntryVersion>)QueryUtil.list(
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
	 * Returns the first e3 entry version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByStatus_First(
			long status, OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByStatus_First(
			status, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the first e3 entry version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByStatus_First(
		long status, OrderByComparator<E3EntryVersion> orderByComparator) {

		List<E3EntryVersion> list = findByStatus(
			status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByStatus_Last(
			long status, OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByStatus_Last(
			status, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the last e3 entry version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByStatus_Last(
		long status, OrderByComparator<E3EntryVersion> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<E3EntryVersion> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where status = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	@Override
	public E3EntryVersion[] findByStatus_PrevAndNext(
			long e3EntryVersionId, long status,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = findByPrimaryKey(e3EntryVersionId);

		Session session = null;

		try {
			session = openSession();

			E3EntryVersion[] array = new E3EntryVersionImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, e3EntryVersion, status, orderByComparator, true);

			array[1] = e3EntryVersion;

			array[2] = getByStatus_PrevAndNext(
				session, e3EntryVersion, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected E3EntryVersion getByStatus_PrevAndNext(
		Session session, E3EntryVersion e3EntryVersion, long status,
		OrderByComparator<E3EntryVersion> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

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
			sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						e3EntryVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3EntryVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entry versions where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(long status) {
		for (E3EntryVersion e3EntryVersion :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(e3EntryVersion);
		}
	}

	/**
	 * Returns the number of e3 entry versions where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching e3 entry versions
	 */
	@Override
	public int countByStatus(long status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_E3ENTRYVERSION_WHERE);

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
		"e3EntryVersion.status = ?";

	private FinderPath _finderPathWithPaginationFindByStatus_Version;
	private FinderPath _finderPathWithoutPaginationFindByStatus_Version;
	private FinderPath _finderPathCountByStatus_Version;

	/**
	 * Returns all the e3 entry versions where status = &#63; and version = &#63;.
	 *
	 * @param status the status
	 * @param version the version
	 * @return the matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByStatus_Version(long status, int version) {
		return findByStatus_Version(
			status, version, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entry versions where status = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByStatus_Version(
		long status, int version, int start, int end) {

		return findByStatus_Version(status, version, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where status = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByStatus_Version(
		long status, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return findByStatus_Version(
			status, version, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where status = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByStatus_Version(
		long status, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus_Version;
				finderArgs = new Object[] {status, version};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus_Version;
			finderArgs = new Object[] {
				status, version, start, end, orderByComparator
			};
		}

		List<E3EntryVersion> list = null;

		if (useFinderCache) {
			list = (List<E3EntryVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3EntryVersion e3EntryVersion : list) {
					if ((status != e3EntryVersion.getStatus()) ||
						(version != e3EntryVersion.getVersion())) {

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

			sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_VERSION_STATUS_2);

			sb.append(_FINDER_COLUMN_STATUS_VERSION_VERSION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				queryPos.add(version);

				list = (List<E3EntryVersion>)QueryUtil.list(
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
	 * Returns the first e3 entry version in the ordered set where status = &#63; and version = &#63;.
	 *
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByStatus_Version_First(
			long status, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByStatus_Version_First(
			status, version, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append(", version=");
		sb.append(version);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the first e3 entry version in the ordered set where status = &#63; and version = &#63;.
	 *
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByStatus_Version_First(
		long status, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		List<E3EntryVersion> list = findByStatus_Version(
			status, version, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry version in the ordered set where status = &#63; and version = &#63;.
	 *
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByStatus_Version_Last(
			long status, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByStatus_Version_Last(
			status, version, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append(", version=");
		sb.append(version);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the last e3 entry version in the ordered set where status = &#63; and version = &#63;.
	 *
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByStatus_Version_Last(
		long status, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		int count = countByStatus_Version(status, version);

		if (count == 0) {
			return null;
		}

		List<E3EntryVersion> list = findByStatus_Version(
			status, version, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where status = &#63; and version = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	@Override
	public E3EntryVersion[] findByStatus_Version_PrevAndNext(
			long e3EntryVersionId, long status, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = findByPrimaryKey(e3EntryVersionId);

		Session session = null;

		try {
			session = openSession();

			E3EntryVersion[] array = new E3EntryVersionImpl[3];

			array[0] = getByStatus_Version_PrevAndNext(
				session, e3EntryVersion, status, version, orderByComparator,
				true);

			array[1] = e3EntryVersion;

			array[2] = getByStatus_Version_PrevAndNext(
				session, e3EntryVersion, status, version, orderByComparator,
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

	protected E3EntryVersion getByStatus_Version_PrevAndNext(
		Session session, E3EntryVersion e3EntryVersion, long status,
		int version, OrderByComparator<E3EntryVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

		sb.append(_FINDER_COLUMN_STATUS_VERSION_STATUS_2);

		sb.append(_FINDER_COLUMN_STATUS_VERSION_VERSION_2);

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
			sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		queryPos.add(version);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						e3EntryVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3EntryVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entry versions where status = &#63; and version = &#63; from the database.
	 *
	 * @param status the status
	 * @param version the version
	 */
	@Override
	public void removeByStatus_Version(long status, int version) {
		for (E3EntryVersion e3EntryVersion :
				findByStatus_Version(
					status, version, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(e3EntryVersion);
		}
	}

	/**
	 * Returns the number of e3 entry versions where status = &#63; and version = &#63;.
	 *
	 * @param status the status
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	@Override
	public int countByStatus_Version(long status, int version) {
		FinderPath finderPath = _finderPathCountByStatus_Version;

		Object[] finderArgs = new Object[] {status, version};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_E3ENTRYVERSION_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_VERSION_STATUS_2);

			sb.append(_FINDER_COLUMN_STATUS_VERSION_VERSION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				queryPos.add(version);

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

	private static final String _FINDER_COLUMN_STATUS_VERSION_STATUS_2 =
		"e3EntryVersion.status = ? AND ";

	private static final String _FINDER_COLUMN_STATUS_VERSION_VERSION_2 =
		"e3EntryVersion.version = ?";

	private FinderPath _finderPathWithPaginationFindByG_S;
	private FinderPath _finderPathWithoutPaginationFindByG_S;
	private FinderPath _finderPathCountByG_S;

	/**
	 * Returns all the e3 entry versions where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByG_S(long groupId, long status) {
		return findByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entry versions where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByG_S(
		long groupId, long status, int start, int end) {

		return findByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByG_S(
		long groupId, long status, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return findByG_S(groupId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByG_S(
		long groupId, long status, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
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

		List<E3EntryVersion> list = null;

		if (useFinderCache) {
			list = (List<E3EntryVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3EntryVersion e3EntryVersion : list) {
					if ((groupId != e3EntryVersion.getGroupId()) ||
						(status != e3EntryVersion.getStatus())) {

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

			sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				list = (List<E3EntryVersion>)QueryUtil.list(
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
	 * Returns the first e3 entry version in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByG_S_First(
			long groupId, long status,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByG_S_First(
			groupId, status, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the first e3 entry version in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByG_S_First(
		long groupId, long status,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		List<E3EntryVersion> list = findByG_S(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry version in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByG_S_Last(
			long groupId, long status,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByG_S_Last(
			groupId, status, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the last e3 entry version in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByG_S_Last(
		long groupId, long status,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		int count = countByG_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<E3EntryVersion> list = findByG_S(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	@Override
	public E3EntryVersion[] findByG_S_PrevAndNext(
			long e3EntryVersionId, long groupId, long status,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = findByPrimaryKey(e3EntryVersionId);

		Session session = null;

		try {
			session = openSession();

			E3EntryVersion[] array = new E3EntryVersionImpl[3];

			array[0] = getByG_S_PrevAndNext(
				session, e3EntryVersion, groupId, status, orderByComparator,
				true);

			array[1] = e3EntryVersion;

			array[2] = getByG_S_PrevAndNext(
				session, e3EntryVersion, groupId, status, orderByComparator,
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

	protected E3EntryVersion getByG_S_PrevAndNext(
		Session session, E3EntryVersion e3EntryVersion, long groupId,
		long status, OrderByComparator<E3EntryVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

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
			sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						e3EntryVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3EntryVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entry versions where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByG_S(long groupId, long status) {
		for (E3EntryVersion e3EntryVersion :
				findByG_S(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(e3EntryVersion);
		}
	}

	/**
	 * Returns the number of e3 entry versions where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching e3 entry versions
	 */
	@Override
	public int countByG_S(long groupId, long status) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_E3ENTRYVERSION_WHERE);

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

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 =
		"e3EntryVersion.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_STATUS_2 =
		"e3EntryVersion.status = ?";

	private FinderPath _finderPathWithPaginationFindByG_S_Version;
	private FinderPath _finderPathWithoutPaginationFindByG_S_Version;
	private FinderPath _finderPathCountByG_S_Version;

	/**
	 * Returns all the e3 entry versions where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @return the matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByG_S_Version(
		long groupId, long status, int version) {

		return findByG_S_Version(
			groupId, status, version, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e3 entry versions where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByG_S_Version(
		long groupId, long status, int version, int start, int end) {

		return findByG_S_Version(groupId, status, version, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByG_S_Version(
		long groupId, long status, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return findByG_S_Version(
			groupId, status, version, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findByG_S_Version(
		long groupId, long status, int version, int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_S_Version;
				finderArgs = new Object[] {groupId, status, version};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_S_Version;
			finderArgs = new Object[] {
				groupId, status, version, start, end, orderByComparator
			};
		}

		List<E3EntryVersion> list = null;

		if (useFinderCache) {
			list = (List<E3EntryVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (E3EntryVersion e3EntryVersion : list) {
					if ((groupId != e3EntryVersion.getGroupId()) ||
						(status != e3EntryVersion.getStatus()) ||
						(version != e3EntryVersion.getVersion())) {

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

			sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

			sb.append(_FINDER_COLUMN_G_S_VERSION_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_VERSION_STATUS_2);

			sb.append(_FINDER_COLUMN_G_S_VERSION_VERSION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				queryPos.add(version);

				list = (List<E3EntryVersion>)QueryUtil.list(
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
	 * Returns the first e3 entry version in the ordered set where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByG_S_Version_First(
			long groupId, long status, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByG_S_Version_First(
			groupId, status, version, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append(", version=");
		sb.append(version);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the first e3 entry version in the ordered set where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByG_S_Version_First(
		long groupId, long status, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		List<E3EntryVersion> list = findByG_S_Version(
			groupId, status, version, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e3 entry version in the ordered set where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version
	 * @throws NoSuchE3EntryVersionException if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion findByG_S_Version_Last(
			long groupId, long status, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByG_S_Version_Last(
			groupId, status, version, orderByComparator);

		if (e3EntryVersion != null) {
			return e3EntryVersion;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append(", version=");
		sb.append(version);

		sb.append("}");

		throw new NoSuchE3EntryVersionException(sb.toString());
	}

	/**
	 * Returns the last e3 entry version in the ordered set where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e3 entry version, or <code>null</code> if a matching e3 entry version could not be found
	 */
	@Override
	public E3EntryVersion fetchByG_S_Version_Last(
		long groupId, long status, int version,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		int count = countByG_S_Version(groupId, status, version);

		if (count == 0) {
			return null;
		}

		List<E3EntryVersion> list = findByG_S_Version(
			groupId, status, version, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e3 entry versions before and after the current e3 entry version in the ordered set where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * @param e3EntryVersionId the primary key of the current e3 entry version
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	@Override
	public E3EntryVersion[] findByG_S_Version_PrevAndNext(
			long e3EntryVersionId, long groupId, long status, int version,
			OrderByComparator<E3EntryVersion> orderByComparator)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = findByPrimaryKey(e3EntryVersionId);

		Session session = null;

		try {
			session = openSession();

			E3EntryVersion[] array = new E3EntryVersionImpl[3];

			array[0] = getByG_S_Version_PrevAndNext(
				session, e3EntryVersion, groupId, status, version,
				orderByComparator, true);

			array[1] = e3EntryVersion;

			array[2] = getByG_S_Version_PrevAndNext(
				session, e3EntryVersion, groupId, status, version,
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

	protected E3EntryVersion getByG_S_Version_PrevAndNext(
		Session session, E3EntryVersion e3EntryVersion, long groupId,
		long status, int version,
		OrderByComparator<E3EntryVersion> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_E3ENTRYVERSION_WHERE);

		sb.append(_FINDER_COLUMN_G_S_VERSION_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_VERSION_STATUS_2);

		sb.append(_FINDER_COLUMN_G_S_VERSION_VERSION_2);

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
			sb.append(E3EntryVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(status);

		queryPos.add(version);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						e3EntryVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<E3EntryVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e3 entry versions where groupId = &#63; and status = &#63; and version = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 */
	@Override
	public void removeByG_S_Version(long groupId, long status, int version) {
		for (E3EntryVersion e3EntryVersion :
				findByG_S_Version(
					groupId, status, version, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(e3EntryVersion);
		}
	}

	/**
	 * Returns the number of e3 entry versions where groupId = &#63; and status = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param version the version
	 * @return the number of matching e3 entry versions
	 */
	@Override
	public int countByG_S_Version(long groupId, long status, int version) {
		FinderPath finderPath = _finderPathCountByG_S_Version;

		Object[] finderArgs = new Object[] {groupId, status, version};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_E3ENTRYVERSION_WHERE);

			sb.append(_FINDER_COLUMN_G_S_VERSION_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_VERSION_STATUS_2);

			sb.append(_FINDER_COLUMN_G_S_VERSION_VERSION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				queryPos.add(version);

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

	private static final String _FINDER_COLUMN_G_S_VERSION_GROUPID_2 =
		"e3EntryVersion.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_VERSION_STATUS_2 =
		"e3EntryVersion.status = ? AND ";

	private static final String _FINDER_COLUMN_G_S_VERSION_VERSION_2 =
		"e3EntryVersion.version = ?";

	public E3EntryVersionPersistenceImpl() {
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

		setModelClass(E3EntryVersion.class);

		setModelImplClass(E3EntryVersionImpl.class);
		setModelPKClass(long.class);

		setTable(E3EntryVersionTable.INSTANCE);
	}

	/**
	 * Caches the e3 entry version in the entity cache if it is enabled.
	 *
	 * @param e3EntryVersion the e3 entry version
	 */
	@Override
	public void cacheResult(E3EntryVersion e3EntryVersion) {
		entityCache.putResult(
			E3EntryVersionImpl.class, e3EntryVersion.getPrimaryKey(),
			e3EntryVersion);

		finderCache.putResult(
			_finderPathFetchByEntryId_Version,
			new Object[] {
				e3EntryVersion.getEntryId(), e3EntryVersion.getVersion()
			},
			e3EntryVersion);

		finderCache.putResult(
			_finderPathFetchByUUID_G_Version,
			new Object[] {
				e3EntryVersion.getUuid(), e3EntryVersion.getGroupId(),
				e3EntryVersion.getVersion()
			},
			e3EntryVersion);
	}

	/**
	 * Caches the e3 entry versions in the entity cache if it is enabled.
	 *
	 * @param e3EntryVersions the e3 entry versions
	 */
	@Override
	public void cacheResult(List<E3EntryVersion> e3EntryVersions) {
		for (E3EntryVersion e3EntryVersion : e3EntryVersions) {
			if (entityCache.getResult(
					E3EntryVersionImpl.class, e3EntryVersion.getPrimaryKey()) ==
						null) {

				cacheResult(e3EntryVersion);
			}
		}
	}

	/**
	 * Clears the cache for all e3 entry versions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(E3EntryVersionImpl.class);

		finderCache.clearCache(E3EntryVersionImpl.class);
	}

	/**
	 * Clears the cache for the e3 entry version.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(E3EntryVersion e3EntryVersion) {
		entityCache.removeResult(E3EntryVersionImpl.class, e3EntryVersion);
	}

	@Override
	public void clearCache(List<E3EntryVersion> e3EntryVersions) {
		for (E3EntryVersion e3EntryVersion : e3EntryVersions) {
			entityCache.removeResult(E3EntryVersionImpl.class, e3EntryVersion);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(E3EntryVersionImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(E3EntryVersionImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		E3EntryVersionModelImpl e3EntryVersionModelImpl) {

		Object[] args = new Object[] {
			e3EntryVersionModelImpl.getEntryId(),
			e3EntryVersionModelImpl.getVersion()
		};

		finderCache.putResult(
			_finderPathCountByEntryId_Version, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByEntryId_Version, args, e3EntryVersionModelImpl);

		args = new Object[] {
			e3EntryVersionModelImpl.getUuid(),
			e3EntryVersionModelImpl.getGroupId(),
			e3EntryVersionModelImpl.getVersion()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G_Version, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G_Version, args, e3EntryVersionModelImpl);
	}

	/**
	 * Creates a new e3 entry version with the primary key. Does not add the e3 entry version to the database.
	 *
	 * @param e3EntryVersionId the primary key for the new e3 entry version
	 * @return the new e3 entry version
	 */
	@Override
	public E3EntryVersion create(long e3EntryVersionId) {
		E3EntryVersion e3EntryVersion = new E3EntryVersionImpl();

		e3EntryVersion.setNew(true);
		e3EntryVersion.setPrimaryKey(e3EntryVersionId);

		e3EntryVersion.setCompanyId(CompanyThreadLocal.getCompanyId());

		return e3EntryVersion;
	}

	/**
	 * Removes the e3 entry version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param e3EntryVersionId the primary key of the e3 entry version
	 * @return the e3 entry version that was removed
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	@Override
	public E3EntryVersion remove(long e3EntryVersionId)
		throws NoSuchE3EntryVersionException {

		return remove((Serializable)e3EntryVersionId);
	}

	/**
	 * Removes the e3 entry version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e3 entry version
	 * @return the e3 entry version that was removed
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	@Override
	public E3EntryVersion remove(Serializable primaryKey)
		throws NoSuchE3EntryVersionException {

		Session session = null;

		try {
			session = openSession();

			E3EntryVersion e3EntryVersion = (E3EntryVersion)session.get(
				E3EntryVersionImpl.class, primaryKey);

			if (e3EntryVersion == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchE3EntryVersionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(e3EntryVersion);
		}
		catch (NoSuchE3EntryVersionException noSuchEntityException) {
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
	protected E3EntryVersion removeImpl(E3EntryVersion e3EntryVersion) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(e3EntryVersion)) {
				e3EntryVersion = (E3EntryVersion)session.get(
					E3EntryVersionImpl.class,
					e3EntryVersion.getPrimaryKeyObj());
			}

			if (e3EntryVersion != null) {
				session.delete(e3EntryVersion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (e3EntryVersion != null) {
			clearCache(e3EntryVersion);
		}

		return e3EntryVersion;
	}

	@Override
	public E3EntryVersion updateImpl(E3EntryVersion e3EntryVersion) {
		boolean isNew = e3EntryVersion.isNew();

		if (!(e3EntryVersion instanceof E3EntryVersionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(e3EntryVersion.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					e3EntryVersion);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in e3EntryVersion proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom E3EntryVersion implementation " +
					e3EntryVersion.getClass());
		}

		E3EntryVersionModelImpl e3EntryVersionModelImpl =
			(E3EntryVersionModelImpl)e3EntryVersion;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (e3EntryVersion.getCreateDate() == null)) {
			if (serviceContext == null) {
				e3EntryVersion.setCreateDate(date);
			}
			else {
				e3EntryVersion.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!e3EntryVersionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				e3EntryVersion.setModifiedDate(date);
			}
			else {
				e3EntryVersion.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(e3EntryVersion);
			}
			else {
				throw new IllegalArgumentException(
					"E3EntryVersion is read only, create a new version instead");
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			E3EntryVersionImpl.class, e3EntryVersionModelImpl, false, true);

		cacheUniqueFindersCache(e3EntryVersionModelImpl);

		if (isNew) {
			e3EntryVersion.setNew(false);
		}

		e3EntryVersion.resetOriginalValues();

		return e3EntryVersion;
	}

	/**
	 * Returns the e3 entry version with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e3 entry version
	 * @return the e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	@Override
	public E3EntryVersion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchE3EntryVersionException {

		E3EntryVersion e3EntryVersion = fetchByPrimaryKey(primaryKey);

		if (e3EntryVersion == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchE3EntryVersionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return e3EntryVersion;
	}

	/**
	 * Returns the e3 entry version with the primary key or throws a <code>NoSuchE3EntryVersionException</code> if it could not be found.
	 *
	 * @param e3EntryVersionId the primary key of the e3 entry version
	 * @return the e3 entry version
	 * @throws NoSuchE3EntryVersionException if a e3 entry version with the primary key could not be found
	 */
	@Override
	public E3EntryVersion findByPrimaryKey(long e3EntryVersionId)
		throws NoSuchE3EntryVersionException {

		return findByPrimaryKey((Serializable)e3EntryVersionId);
	}

	/**
	 * Returns the e3 entry version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param e3EntryVersionId the primary key of the e3 entry version
	 * @return the e3 entry version, or <code>null</code> if a e3 entry version with the primary key could not be found
	 */
	@Override
	public E3EntryVersion fetchByPrimaryKey(long e3EntryVersionId) {
		return fetchByPrimaryKey((Serializable)e3EntryVersionId);
	}

	/**
	 * Returns all the e3 entry versions.
	 *
	 * @return the e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e3 entry versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @return the range of e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findAll(
		int start, int end,
		OrderByComparator<E3EntryVersion> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e3 entry versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>E3EntryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e3 entry versions
	 * @param end the upper bound of the range of e3 entry versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of e3 entry versions
	 */
	@Override
	public List<E3EntryVersion> findAll(
		int start, int end, OrderByComparator<E3EntryVersion> orderByComparator,
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

		List<E3EntryVersion> list = null;

		if (useFinderCache) {
			list = (List<E3EntryVersion>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_E3ENTRYVERSION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_E3ENTRYVERSION;

				sql = sql.concat(E3EntryVersionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<E3EntryVersion>)QueryUtil.list(
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
	 * Removes all the e3 entry versions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (E3EntryVersion e3EntryVersion : findAll()) {
			remove(e3EntryVersion);
		}
	}

	/**
	 * Returns the number of e3 entry versions.
	 *
	 * @return the number of e3 entry versions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_E3ENTRYVERSION);

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
		return "e3EntryVersionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_E3ENTRYVERSION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return E3EntryVersionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the e3 entry version persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new E3EntryVersionModelArgumentsResolver(),
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

		_finderPathWithPaginationFindByEntryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEntryId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"entry_id"}, true);

		_finderPathWithoutPaginationFindByEntryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEntryId",
			new String[] {Long.class.getName()}, new String[] {"entry_id"},
			true);

		_finderPathCountByEntryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEntryId",
			new String[] {Long.class.getName()}, new String[] {"entry_id"},
			false);

		_finderPathFetchByEntryId_Version = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByEntryId_Version",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"entry_id", "version"}, true);

		_finderPathCountByEntryId_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEntryId_Version",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"entry_id", "version"}, false);

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

		_finderPathWithPaginationFindByUuid_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_Version",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "version"}, true);

		_finderPathWithoutPaginationFindByUuid_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_Version",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"uuid_", "version"}, true);

		_finderPathCountByUuid_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_Version",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"uuid_", "version"}, false);

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

		_finderPathFetchByUUID_G_Version = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G_Version",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			new String[] {"uuid_", "groupId", "version"}, true);

		_finderPathCountByUUID_G_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G_Version",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			new String[] {"uuid_", "groupId", "version"}, false);

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

		_finderPathWithPaginationFindByUuid_C_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C_Version",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId", "version"}, true);

		_finderPathWithoutPaginationFindByUuid_C_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C_Version",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			new String[] {"uuid_", "companyId", "version"}, true);

		_finderPathCountByUuid_C_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C_Version",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			new String[] {"uuid_", "companyId", "version"}, false);

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

		_finderPathWithPaginationFindByxid_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByxid_Version",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"entry_xid", "version"}, true);

		_finderPathWithoutPaginationFindByxid_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByxid_Version",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"entry_xid", "version"}, true);

		_finderPathCountByxid_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByxid_Version",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"entry_xid", "version"}, false);

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

		_finderPathWithPaginationFindByp_f_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByp_f_Version",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"parent_id", "parent_field", "version"}, true);

		_finderPathWithoutPaginationFindByp_f_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByp_f_Version",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			},
			new String[] {"parent_id", "parent_field", "version"}, true);

		_finderPathCountByp_f_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByp_f_Version",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			},
			new String[] {"parent_id", "parent_field", "version"}, false);

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

		_finderPathWithPaginationFindByStatus_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus_Version",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"status", "version"}, true);

		_finderPathWithoutPaginationFindByStatus_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus_Version",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"status", "version"}, true);

		_finderPathCountByStatus_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus_Version",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"status", "version"}, false);

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

		_finderPathWithPaginationFindByG_S_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S_Version",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId", "status", "version"}, true);

		_finderPathWithoutPaginationFindByG_S_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S_Version",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			new String[] {"groupId", "status", "version"}, true);

		_finderPathCountByG_S_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S_Version",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			new String[] {"groupId", "status", "version"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(E3EntryVersionImpl.class.getName());

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

	private static final String _SQL_SELECT_E3ENTRYVERSION =
		"SELECT e3EntryVersion FROM E3EntryVersion e3EntryVersion";

	private static final String _SQL_SELECT_E3ENTRYVERSION_WHERE =
		"SELECT e3EntryVersion FROM E3EntryVersion e3EntryVersion WHERE ";

	private static final String _SQL_COUNT_E3ENTRYVERSION =
		"SELECT COUNT(e3EntryVersion) FROM E3EntryVersion e3EntryVersion";

	private static final String _SQL_COUNT_E3ENTRYVERSION_WHERE =
		"SELECT COUNT(e3EntryVersion) FROM E3EntryVersion e3EntryVersion WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "e3EntryVersion.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No E3EntryVersion exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No E3EntryVersion exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		E3EntryVersionPersistenceImpl.class);

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

	private static class E3EntryVersionModelArgumentsResolver
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

			E3EntryVersionModelImpl e3EntryVersionModelImpl =
				(E3EntryVersionModelImpl)baseModel;

			long columnBitmask = e3EntryVersionModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					e3EntryVersionModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						e3EntryVersionModelImpl.getColumnBitmask(columnName);
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
				return _getValue(
					e3EntryVersionModelImpl, columnNames, original);
			}

			return null;
		}

		@Override
		public String getClassName() {
			return E3EntryVersionImpl.class.getName();
		}

		@Override
		public String getTableName() {
			return E3EntryVersionTable.INSTANCE.getTableName();
		}

		private static Object[] _getValue(
			E3EntryVersionModelImpl e3EntryVersionModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						e3EntryVersionModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = e3EntryVersionModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			orderByColumnsBitmask |= E3EntryVersionModelImpl.getColumnBitmask(
				"version");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}