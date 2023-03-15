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

package cz.csob.ency.cds.demands.service.persistence.impl;

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

import cz.csob.ency.cds.demands.exception.NoSuchCdsDemandVersionException;
import cz.csob.ency.cds.demands.model.CdsDemandVersion;
import cz.csob.ency.cds.demands.model.CdsDemandVersionTable;
import cz.csob.ency.cds.demands.model.impl.CdsDemandVersionImpl;
import cz.csob.ency.cds.demands.model.impl.CdsDemandVersionModelImpl;
import cz.csob.ency.cds.demands.service.persistence.CdsDemandVersionPersistence;
import cz.csob.ency.cds.demands.service.persistence.CdsDemandVersionUtil;
import cz.csob.ency.cds.demands.service.persistence.impl.constants.CdsDemandsPersistenceConstants;

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
 * The persistence implementation for the cds demand version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @generated
 */
@Component(service = {CdsDemandVersionPersistence.class, BasePersistence.class})
public class CdsDemandVersionPersistenceImpl
	extends BasePersistenceImpl<CdsDemandVersion>
	implements CdsDemandVersionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CdsDemandVersionUtil</code> to access the cds demand version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CdsDemandVersionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByDemandId;
	private FinderPath _finderPathWithoutPaginationFindByDemandId;
	private FinderPath _finderPathCountByDemandId;

	/**
	 * Returns all the cds demand versions where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @return the matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByDemandId(long demandId) {
		return findByDemandId(
			demandId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demand versions where demandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param demandId the demand ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByDemandId(
		long demandId, int start, int end) {

		return findByDemandId(demandId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where demandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param demandId the demand ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByDemandId(
		long demandId, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return findByDemandId(demandId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where demandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param demandId the demand ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByDemandId(
		long demandId, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDemandId;
				finderArgs = new Object[] {demandId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDemandId;
			finderArgs = new Object[] {demandId, start, end, orderByComparator};
		}

		List<CdsDemandVersion> list = null;

		if (useFinderCache) {
			list = (List<CdsDemandVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemandVersion cdsDemandVersion : list) {
					if (demandId != cdsDemandVersion.getDemandId()) {
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

			sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

			sb.append(_FINDER_COLUMN_DEMANDID_DEMANDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CdsDemandVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(demandId);

				list = (List<CdsDemandVersion>)QueryUtil.list(
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
	 * Returns the first cds demand version in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByDemandId_First(
			long demandId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByDemandId_First(
			demandId, orderByComparator);

		if (cdsDemandVersion != null) {
			return cdsDemandVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("demandId=");
		sb.append(demandId);

		sb.append("}");

		throw new NoSuchCdsDemandVersionException(sb.toString());
	}

	/**
	 * Returns the first cds demand version in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByDemandId_First(
		long demandId, OrderByComparator<CdsDemandVersion> orderByComparator) {

		List<CdsDemandVersion> list = findByDemandId(
			demandId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cds demand version in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByDemandId_Last(
			long demandId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByDemandId_Last(
			demandId, orderByComparator);

		if (cdsDemandVersion != null) {
			return cdsDemandVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("demandId=");
		sb.append(demandId);

		sb.append("}");

		throw new NoSuchCdsDemandVersionException(sb.toString());
	}

	/**
	 * Returns the last cds demand version in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByDemandId_Last(
		long demandId, OrderByComparator<CdsDemandVersion> orderByComparator) {

		int count = countByDemandId(demandId);

		if (count == 0) {
			return null;
		}

		List<CdsDemandVersion> list = findByDemandId(
			demandId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where demandId = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	@Override
	public CdsDemandVersion[] findByDemandId_PrevAndNext(
			long cdsDemandVersionId, long demandId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = findByPrimaryKey(
			cdsDemandVersionId);

		Session session = null;

		try {
			session = openSession();

			CdsDemandVersion[] array = new CdsDemandVersionImpl[3];

			array[0] = getByDemandId_PrevAndNext(
				session, cdsDemandVersion, demandId, orderByComparator, true);

			array[1] = cdsDemandVersion;

			array[2] = getByDemandId_PrevAndNext(
				session, cdsDemandVersion, demandId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CdsDemandVersion getByDemandId_PrevAndNext(
		Session session, CdsDemandVersion cdsDemandVersion, long demandId,
		OrderByComparator<CdsDemandVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

		sb.append(_FINDER_COLUMN_DEMANDID_DEMANDID_2);

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
			sb.append(CdsDemandVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(demandId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						cdsDemandVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CdsDemandVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cds demand versions where demandId = &#63; from the database.
	 *
	 * @param demandId the demand ID
	 */
	@Override
	public void removeByDemandId(long demandId) {
		for (CdsDemandVersion cdsDemandVersion :
				findByDemandId(
					demandId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cdsDemandVersion);
		}
	}

	/**
	 * Returns the number of cds demand versions where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @return the number of matching cds demand versions
	 */
	@Override
	public int countByDemandId(long demandId) {
		FinderPath finderPath = _finderPathCountByDemandId;

		Object[] finderArgs = new Object[] {demandId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CDSDEMANDVERSION_WHERE);

			sb.append(_FINDER_COLUMN_DEMANDID_DEMANDID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(demandId);

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

	private static final String _FINDER_COLUMN_DEMANDID_DEMANDID_2 =
		"cdsDemandVersion.demandId = ?";

	private FinderPath _finderPathFetchByDemandId_Version;
	private FinderPath _finderPathCountByDemandId_Version;

	/**
	 * Returns the cds demand version where demandId = &#63; and version = &#63; or throws a <code>NoSuchCdsDemandVersionException</code> if it could not be found.
	 *
	 * @param demandId the demand ID
	 * @param version the version
	 * @return the matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByDemandId_Version(long demandId, int version)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByDemandId_Version(
			demandId, version);

		if (cdsDemandVersion == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("demandId=");
			sb.append(demandId);

			sb.append(", version=");
			sb.append(version);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCdsDemandVersionException(sb.toString());
		}

		return cdsDemandVersion;
	}

	/**
	 * Returns the cds demand version where demandId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param demandId the demand ID
	 * @param version the version
	 * @return the matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByDemandId_Version(
		long demandId, int version) {

		return fetchByDemandId_Version(demandId, version, true);
	}

	/**
	 * Returns the cds demand version where demandId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param demandId the demand ID
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByDemandId_Version(
		long demandId, int version, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {demandId, version};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDemandId_Version, finderArgs);
		}

		if (result instanceof CdsDemandVersion) {
			CdsDemandVersion cdsDemandVersion = (CdsDemandVersion)result;

			if ((demandId != cdsDemandVersion.getDemandId()) ||
				(version != cdsDemandVersion.getVersion())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

			sb.append(_FINDER_COLUMN_DEMANDID_VERSION_DEMANDID_2);

			sb.append(_FINDER_COLUMN_DEMANDID_VERSION_VERSION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(demandId);

				queryPos.add(version);

				List<CdsDemandVersion> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDemandId_Version, finderArgs,
							list);
					}
				}
				else {
					CdsDemandVersion cdsDemandVersion = list.get(0);

					result = cdsDemandVersion;

					cacheResult(cdsDemandVersion);
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
			return (CdsDemandVersion)result;
		}
	}

	/**
	 * Removes the cds demand version where demandId = &#63; and version = &#63; from the database.
	 *
	 * @param demandId the demand ID
	 * @param version the version
	 * @return the cds demand version that was removed
	 */
	@Override
	public CdsDemandVersion removeByDemandId_Version(long demandId, int version)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = findByDemandId_Version(
			demandId, version);

		return remove(cdsDemandVersion);
	}

	/**
	 * Returns the number of cds demand versions where demandId = &#63; and version = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param version the version
	 * @return the number of matching cds demand versions
	 */
	@Override
	public int countByDemandId_Version(long demandId, int version) {
		FinderPath finderPath = _finderPathCountByDemandId_Version;

		Object[] finderArgs = new Object[] {demandId, version};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CDSDEMANDVERSION_WHERE);

			sb.append(_FINDER_COLUMN_DEMANDID_VERSION_DEMANDID_2);

			sb.append(_FINDER_COLUMN_DEMANDID_VERSION_VERSION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(demandId);

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

	private static final String _FINDER_COLUMN_DEMANDID_VERSION_DEMANDID_2 =
		"cdsDemandVersion.demandId = ? AND ";

	private static final String _FINDER_COLUMN_DEMANDID_VERSION_VERSION_2 =
		"cdsDemandVersion.version = ?";

	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the cds demand versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demand versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
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

		List<CdsDemandVersion> list = null;

		if (useFinderCache) {
			list = (List<CdsDemandVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemandVersion cdsDemandVersion : list) {
					if (!uuid.equals(cdsDemandVersion.getUuid())) {
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

			sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

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
				sb.append(CdsDemandVersionModelImpl.ORDER_BY_JPQL);
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

				list = (List<CdsDemandVersion>)QueryUtil.list(
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
	 * Returns the first cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByUuid_First(
			String uuid, OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByUuid_First(
			uuid, orderByComparator);

		if (cdsDemandVersion != null) {
			return cdsDemandVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCdsDemandVersionException(sb.toString());
	}

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByUuid_First(
		String uuid, OrderByComparator<CdsDemandVersion> orderByComparator) {

		List<CdsDemandVersion> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByUuid_Last(
			String uuid, OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByUuid_Last(
			uuid, orderByComparator);

		if (cdsDemandVersion != null) {
			return cdsDemandVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCdsDemandVersionException(sb.toString());
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByUuid_Last(
		String uuid, OrderByComparator<CdsDemandVersion> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CdsDemandVersion> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	@Override
	public CdsDemandVersion[] findByUuid_PrevAndNext(
			long cdsDemandVersionId, String uuid,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		uuid = Objects.toString(uuid, "");

		CdsDemandVersion cdsDemandVersion = findByPrimaryKey(
			cdsDemandVersionId);

		Session session = null;

		try {
			session = openSession();

			CdsDemandVersion[] array = new CdsDemandVersionImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, cdsDemandVersion, uuid, orderByComparator, true);

			array[1] = cdsDemandVersion;

			array[2] = getByUuid_PrevAndNext(
				session, cdsDemandVersion, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CdsDemandVersion getByUuid_PrevAndNext(
		Session session, CdsDemandVersion cdsDemandVersion, String uuid,
		OrderByComparator<CdsDemandVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

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
			sb.append(CdsDemandVersionModelImpl.ORDER_BY_JPQL);
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
						cdsDemandVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CdsDemandVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cds demand versions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CdsDemandVersion cdsDemandVersion :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cdsDemandVersion);
		}
	}

	/**
	 * Returns the number of cds demand versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cds demand versions
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CDSDEMANDVERSION_WHERE);

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
		"cdsDemandVersion.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(cdsDemandVersion.uuid IS NULL OR cdsDemandVersion.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_Version;
	private FinderPath _finderPathWithoutPaginationFindByUuid_Version;
	private FinderPath _finderPathCountByUuid_Version;

	/**
	 * Returns all the cds demand versions where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUuid_Version(String uuid, int version) {
		return findByUuid_Version(
			uuid, version, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demand versions where uuid = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUuid_Version(
		String uuid, int version, int start, int end) {

		return findByUuid_Version(uuid, version, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUuid_Version(
		String uuid, int version, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return findByUuid_Version(
			uuid, version, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUuid_Version(
		String uuid, int version, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
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

		List<CdsDemandVersion> list = null;

		if (useFinderCache) {
			list = (List<CdsDemandVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemandVersion cdsDemandVersion : list) {
					if (!uuid.equals(cdsDemandVersion.getUuid()) ||
						(version != cdsDemandVersion.getVersion())) {

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

			sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

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
				sb.append(CdsDemandVersionModelImpl.ORDER_BY_JPQL);
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

				list = (List<CdsDemandVersion>)QueryUtil.list(
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
	 * Returns the first cds demand version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByUuid_Version_First(
			String uuid, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByUuid_Version_First(
			uuid, version, orderByComparator);

		if (cdsDemandVersion != null) {
			return cdsDemandVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", version=");
		sb.append(version);

		sb.append("}");

		throw new NoSuchCdsDemandVersionException(sb.toString());
	}

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByUuid_Version_First(
		String uuid, int version,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		List<CdsDemandVersion> list = findByUuid_Version(
			uuid, version, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByUuid_Version_Last(
			String uuid, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByUuid_Version_Last(
			uuid, version, orderByComparator);

		if (cdsDemandVersion != null) {
			return cdsDemandVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", version=");
		sb.append(version);

		sb.append("}");

		throw new NoSuchCdsDemandVersionException(sb.toString());
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByUuid_Version_Last(
		String uuid, int version,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		int count = countByUuid_Version(uuid, version);

		if (count == 0) {
			return null;
		}

		List<CdsDemandVersion> list = findByUuid_Version(
			uuid, version, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where uuid = &#63; and version = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param uuid the uuid
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	@Override
	public CdsDemandVersion[] findByUuid_Version_PrevAndNext(
			long cdsDemandVersionId, String uuid, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		uuid = Objects.toString(uuid, "");

		CdsDemandVersion cdsDemandVersion = findByPrimaryKey(
			cdsDemandVersionId);

		Session session = null;

		try {
			session = openSession();

			CdsDemandVersion[] array = new CdsDemandVersionImpl[3];

			array[0] = getByUuid_Version_PrevAndNext(
				session, cdsDemandVersion, uuid, version, orderByComparator,
				true);

			array[1] = cdsDemandVersion;

			array[2] = getByUuid_Version_PrevAndNext(
				session, cdsDemandVersion, uuid, version, orderByComparator,
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

	protected CdsDemandVersion getByUuid_Version_PrevAndNext(
		Session session, CdsDemandVersion cdsDemandVersion, String uuid,
		int version, OrderByComparator<CdsDemandVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

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
			sb.append(CdsDemandVersionModelImpl.ORDER_BY_JPQL);
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
						cdsDemandVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CdsDemandVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cds demand versions where uuid = &#63; and version = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 */
	@Override
	public void removeByUuid_Version(String uuid, int version) {
		for (CdsDemandVersion cdsDemandVersion :
				findByUuid_Version(
					uuid, version, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(cdsDemandVersion);
		}
	}

	/**
	 * Returns the number of cds demand versions where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the number of matching cds demand versions
	 */
	@Override
	public int countByUuid_Version(String uuid, int version) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_Version;

		Object[] finderArgs = new Object[] {uuid, version};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CDSDEMANDVERSION_WHERE);

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
		"cdsDemandVersion.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_VERSION_UUID_3 =
		"(cdsDemandVersion.uuid IS NULL OR cdsDemandVersion.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_VERSION_VERSION_2 =
		"cdsDemandVersion.version = ?";

	private FinderPath _finderPathWithPaginationFindByUUID_G;
	private FinderPath _finderPathWithoutPaginationFindByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns all the cds demand versions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUUID_G(String uuid, long groupId) {
		return findByUUID_G(
			uuid, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demand versions where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUUID_G(
		String uuid, long groupId, int start, int end) {

		return findByUUID_G(uuid, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUUID_G(
		String uuid, long groupId, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return findByUUID_G(uuid, groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUUID_G(
		String uuid, long groupId, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
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

		List<CdsDemandVersion> list = null;

		if (useFinderCache) {
			list = (List<CdsDemandVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemandVersion cdsDemandVersion : list) {
					if (!uuid.equals(cdsDemandVersion.getUuid()) ||
						(groupId != cdsDemandVersion.getGroupId())) {

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

			sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

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
				sb.append(CdsDemandVersionModelImpl.ORDER_BY_JPQL);
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

				list = (List<CdsDemandVersion>)QueryUtil.list(
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
	 * Returns the first cds demand version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByUUID_G_First(
			String uuid, long groupId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByUUID_G_First(
			uuid, groupId, orderByComparator);

		if (cdsDemandVersion != null) {
			return cdsDemandVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchCdsDemandVersionException(sb.toString());
	}

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByUUID_G_First(
		String uuid, long groupId,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		List<CdsDemandVersion> list = findByUUID_G(
			uuid, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByUUID_G_Last(
			String uuid, long groupId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByUUID_G_Last(
			uuid, groupId, orderByComparator);

		if (cdsDemandVersion != null) {
			return cdsDemandVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchCdsDemandVersionException(sb.toString());
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByUUID_G_Last(
		String uuid, long groupId,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		int count = countByUUID_G(uuid, groupId);

		if (count == 0) {
			return null;
		}

		List<CdsDemandVersion> list = findByUUID_G(
			uuid, groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	@Override
	public CdsDemandVersion[] findByUUID_G_PrevAndNext(
			long cdsDemandVersionId, String uuid, long groupId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		uuid = Objects.toString(uuid, "");

		CdsDemandVersion cdsDemandVersion = findByPrimaryKey(
			cdsDemandVersionId);

		Session session = null;

		try {
			session = openSession();

			CdsDemandVersion[] array = new CdsDemandVersionImpl[3];

			array[0] = getByUUID_G_PrevAndNext(
				session, cdsDemandVersion, uuid, groupId, orderByComparator,
				true);

			array[1] = cdsDemandVersion;

			array[2] = getByUUID_G_PrevAndNext(
				session, cdsDemandVersion, uuid, groupId, orderByComparator,
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

	protected CdsDemandVersion getByUUID_G_PrevAndNext(
		Session session, CdsDemandVersion cdsDemandVersion, String uuid,
		long groupId, OrderByComparator<CdsDemandVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

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
			sb.append(CdsDemandVersionModelImpl.ORDER_BY_JPQL);
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
						cdsDemandVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CdsDemandVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cds demand versions where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 */
	@Override
	public void removeByUUID_G(String uuid, long groupId) {
		for (CdsDemandVersion cdsDemandVersion :
				findByUUID_G(
					uuid, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(cdsDemandVersion);
		}
	}

	/**
	 * Returns the number of cds demand versions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching cds demand versions
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CDSDEMANDVERSION_WHERE);

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
		"cdsDemandVersion.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(cdsDemandVersion.uuid IS NULL OR cdsDemandVersion.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"cdsDemandVersion.groupId = ?";

	private FinderPath _finderPathFetchByUUID_G_Version;
	private FinderPath _finderPathCountByUUID_G_Version;

	/**
	 * Returns the cds demand version where uuid = &#63; and groupId = &#63; and version = &#63; or throws a <code>NoSuchCdsDemandVersionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByUUID_G_Version(
			String uuid, long groupId, int version)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByUUID_G_Version(
			uuid, groupId, version);

		if (cdsDemandVersion == null) {
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

			throw new NoSuchCdsDemandVersionException(sb.toString());
		}

		return cdsDemandVersion;
	}

	/**
	 * Returns the cds demand version where uuid = &#63; and groupId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByUUID_G_Version(
		String uuid, long groupId, int version) {

		return fetchByUUID_G_Version(uuid, groupId, version, true);
	}

	/**
	 * Returns the cds demand version where uuid = &#63; and groupId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByUUID_G_Version(
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

		if (result instanceof CdsDemandVersion) {
			CdsDemandVersion cdsDemandVersion = (CdsDemandVersion)result;

			if (!Objects.equals(uuid, cdsDemandVersion.getUuid()) ||
				(groupId != cdsDemandVersion.getGroupId()) ||
				(version != cdsDemandVersion.getVersion())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

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

				List<CdsDemandVersion> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G_Version, finderArgs, list);
					}
				}
				else {
					CdsDemandVersion cdsDemandVersion = list.get(0);

					result = cdsDemandVersion;

					cacheResult(cdsDemandVersion);
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
			return (CdsDemandVersion)result;
		}
	}

	/**
	 * Removes the cds demand version where uuid = &#63; and groupId = &#63; and version = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the cds demand version that was removed
	 */
	@Override
	public CdsDemandVersion removeByUUID_G_Version(
			String uuid, long groupId, int version)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = findByUUID_G_Version(
			uuid, groupId, version);

		return remove(cdsDemandVersion);
	}

	/**
	 * Returns the number of cds demand versions where uuid = &#63; and groupId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param version the version
	 * @return the number of matching cds demand versions
	 */
	@Override
	public int countByUUID_G_Version(String uuid, long groupId, int version) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G_Version;

		Object[] finderArgs = new Object[] {uuid, groupId, version};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_CDSDEMANDVERSION_WHERE);

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
		"cdsDemandVersion.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_VERSION_UUID_3 =
		"(cdsDemandVersion.uuid IS NULL OR cdsDemandVersion.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_VERSION_GROUPID_2 =
		"cdsDemandVersion.groupId = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_VERSION_VERSION_2 =
		"cdsDemandVersion.version = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the cds demand versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demand versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
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

		List<CdsDemandVersion> list = null;

		if (useFinderCache) {
			list = (List<CdsDemandVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemandVersion cdsDemandVersion : list) {
					if (!uuid.equals(cdsDemandVersion.getUuid()) ||
						(companyId != cdsDemandVersion.getCompanyId())) {

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

			sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

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
				sb.append(CdsDemandVersionModelImpl.ORDER_BY_JPQL);
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

				list = (List<CdsDemandVersion>)QueryUtil.list(
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
	 * Returns the first cds demand version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (cdsDemandVersion != null) {
			return cdsDemandVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCdsDemandVersionException(sb.toString());
	}

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		List<CdsDemandVersion> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (cdsDemandVersion != null) {
			return cdsDemandVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCdsDemandVersionException(sb.toString());
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CdsDemandVersion> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	@Override
	public CdsDemandVersion[] findByUuid_C_PrevAndNext(
			long cdsDemandVersionId, String uuid, long companyId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		uuid = Objects.toString(uuid, "");

		CdsDemandVersion cdsDemandVersion = findByPrimaryKey(
			cdsDemandVersionId);

		Session session = null;

		try {
			session = openSession();

			CdsDemandVersion[] array = new CdsDemandVersionImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, cdsDemandVersion, uuid, companyId, orderByComparator,
				true);

			array[1] = cdsDemandVersion;

			array[2] = getByUuid_C_PrevAndNext(
				session, cdsDemandVersion, uuid, companyId, orderByComparator,
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

	protected CdsDemandVersion getByUuid_C_PrevAndNext(
		Session session, CdsDemandVersion cdsDemandVersion, String uuid,
		long companyId, OrderByComparator<CdsDemandVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

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
			sb.append(CdsDemandVersionModelImpl.ORDER_BY_JPQL);
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
						cdsDemandVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CdsDemandVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cds demand versions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CdsDemandVersion cdsDemandVersion :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(cdsDemandVersion);
		}
	}

	/**
	 * Returns the number of cds demand versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching cds demand versions
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CDSDEMANDVERSION_WHERE);

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
		"cdsDemandVersion.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(cdsDemandVersion.uuid IS NULL OR cdsDemandVersion.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"cdsDemandVersion.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C_Version;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C_Version;
	private FinderPath _finderPathCountByUuid_C_Version;

	/**
	 * Returns all the cds demand versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @return the matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUuid_C_Version(
		String uuid, long companyId, int version) {

		return findByUuid_C_Version(
			uuid, companyId, version, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the cds demand versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUuid_C_Version(
		String uuid, long companyId, int version, int start, int end) {

		return findByUuid_C_Version(uuid, companyId, version, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUuid_C_Version(
		String uuid, long companyId, int version, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return findByUuid_C_Version(
			uuid, companyId, version, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUuid_C_Version(
		String uuid, long companyId, int version, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
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

		List<CdsDemandVersion> list = null;

		if (useFinderCache) {
			list = (List<CdsDemandVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemandVersion cdsDemandVersion : list) {
					if (!uuid.equals(cdsDemandVersion.getUuid()) ||
						(companyId != cdsDemandVersion.getCompanyId()) ||
						(version != cdsDemandVersion.getVersion())) {

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

			sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

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
				sb.append(CdsDemandVersionModelImpl.ORDER_BY_JPQL);
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

				list = (List<CdsDemandVersion>)QueryUtil.list(
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
	 * Returns the first cds demand version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByUuid_C_Version_First(
			String uuid, long companyId, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByUuid_C_Version_First(
			uuid, companyId, version, orderByComparator);

		if (cdsDemandVersion != null) {
			return cdsDemandVersion;
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

		throw new NoSuchCdsDemandVersionException(sb.toString());
	}

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByUuid_C_Version_First(
		String uuid, long companyId, int version,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		List<CdsDemandVersion> list = findByUuid_C_Version(
			uuid, companyId, version, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByUuid_C_Version_Last(
			String uuid, long companyId, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByUuid_C_Version_Last(
			uuid, companyId, version, orderByComparator);

		if (cdsDemandVersion != null) {
			return cdsDemandVersion;
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

		throw new NoSuchCdsDemandVersionException(sb.toString());
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByUuid_C_Version_Last(
		String uuid, long companyId, int version,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		int count = countByUuid_C_Version(uuid, companyId, version);

		if (count == 0) {
			return null;
		}

		List<CdsDemandVersion> list = findByUuid_C_Version(
			uuid, companyId, version, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	@Override
	public CdsDemandVersion[] findByUuid_C_Version_PrevAndNext(
			long cdsDemandVersionId, String uuid, long companyId, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		uuid = Objects.toString(uuid, "");

		CdsDemandVersion cdsDemandVersion = findByPrimaryKey(
			cdsDemandVersionId);

		Session session = null;

		try {
			session = openSession();

			CdsDemandVersion[] array = new CdsDemandVersionImpl[3];

			array[0] = getByUuid_C_Version_PrevAndNext(
				session, cdsDemandVersion, uuid, companyId, version,
				orderByComparator, true);

			array[1] = cdsDemandVersion;

			array[2] = getByUuid_C_Version_PrevAndNext(
				session, cdsDemandVersion, uuid, companyId, version,
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

	protected CdsDemandVersion getByUuid_C_Version_PrevAndNext(
		Session session, CdsDemandVersion cdsDemandVersion, String uuid,
		long companyId, int version,
		OrderByComparator<CdsDemandVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

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
			sb.append(CdsDemandVersionModelImpl.ORDER_BY_JPQL);
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
						cdsDemandVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CdsDemandVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cds demand versions where uuid = &#63; and companyId = &#63; and version = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 */
	@Override
	public void removeByUuid_C_Version(
		String uuid, long companyId, int version) {

		for (CdsDemandVersion cdsDemandVersion :
				findByUuid_C_Version(
					uuid, companyId, version, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(cdsDemandVersion);
		}
	}

	/**
	 * Returns the number of cds demand versions where uuid = &#63; and companyId = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param version the version
	 * @return the number of matching cds demand versions
	 */
	@Override
	public int countByUuid_C_Version(String uuid, long companyId, int version) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C_Version;

		Object[] finderArgs = new Object[] {uuid, companyId, version};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_CDSDEMANDVERSION_WHERE);

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
		"cdsDemandVersion.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_VERSION_UUID_3 =
		"(cdsDemandVersion.uuid IS NULL OR cdsDemandVersion.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_VERSION_COMPANYID_2 =
		"cdsDemandVersion.companyId = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_VERSION_VERSION_2 =
		"cdsDemandVersion.version = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the cds demand versions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demand versions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUserId(
		long userId, int start, int end) {

		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUserId(
		long userId, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUserId(
		long userId, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
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

		List<CdsDemandVersion> list = null;

		if (useFinderCache) {
			list = (List<CdsDemandVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemandVersion cdsDemandVersion : list) {
					if (userId != cdsDemandVersion.getUserId()) {
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

			sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CdsDemandVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<CdsDemandVersion>)QueryUtil.list(
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
	 * Returns the first cds demand version in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByUserId_First(
			long userId, OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByUserId_First(
			userId, orderByComparator);

		if (cdsDemandVersion != null) {
			return cdsDemandVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchCdsDemandVersionException(sb.toString());
	}

	/**
	 * Returns the first cds demand version in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByUserId_First(
		long userId, OrderByComparator<CdsDemandVersion> orderByComparator) {

		List<CdsDemandVersion> list = findByUserId(
			userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cds demand version in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByUserId_Last(
			long userId, OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByUserId_Last(
			userId, orderByComparator);

		if (cdsDemandVersion != null) {
			return cdsDemandVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchCdsDemandVersionException(sb.toString());
	}

	/**
	 * Returns the last cds demand version in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByUserId_Last(
		long userId, OrderByComparator<CdsDemandVersion> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<CdsDemandVersion> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where userId = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	@Override
	public CdsDemandVersion[] findByUserId_PrevAndNext(
			long cdsDemandVersionId, long userId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = findByPrimaryKey(
			cdsDemandVersionId);

		Session session = null;

		try {
			session = openSession();

			CdsDemandVersion[] array = new CdsDemandVersionImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, cdsDemandVersion, userId, orderByComparator, true);

			array[1] = cdsDemandVersion;

			array[2] = getByUserId_PrevAndNext(
				session, cdsDemandVersion, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CdsDemandVersion getByUserId_PrevAndNext(
		Session session, CdsDemandVersion cdsDemandVersion, long userId,
		OrderByComparator<CdsDemandVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

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
			sb.append(CdsDemandVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						cdsDemandVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CdsDemandVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cds demand versions where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (CdsDemandVersion cdsDemandVersion :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cdsDemandVersion);
		}
	}

	/**
	 * Returns the number of cds demand versions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching cds demand versions
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CDSDEMANDVERSION_WHERE);

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
		"cdsDemandVersion.userId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId_Version;
	private FinderPath _finderPathWithoutPaginationFindByUserId_Version;
	private FinderPath _finderPathCountByUserId_Version;

	/**
	 * Returns all the cds demand versions where userId = &#63; and version = &#63;.
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @return the matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUserId_Version(
		long userId, int version) {

		return findByUserId_Version(
			userId, version, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demand versions where userId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUserId_Version(
		long userId, int version, int start, int end) {

		return findByUserId_Version(userId, version, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where userId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUserId_Version(
		long userId, int version, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return findByUserId_Version(
			userId, version, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where userId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByUserId_Version(
		long userId, int version, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId_Version;
				finderArgs = new Object[] {userId, version};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId_Version;
			finderArgs = new Object[] {
				userId, version, start, end, orderByComparator
			};
		}

		List<CdsDemandVersion> list = null;

		if (useFinderCache) {
			list = (List<CdsDemandVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemandVersion cdsDemandVersion : list) {
					if ((userId != cdsDemandVersion.getUserId()) ||
						(version != cdsDemandVersion.getVersion())) {

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

			sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

			sb.append(_FINDER_COLUMN_USERID_VERSION_USERID_2);

			sb.append(_FINDER_COLUMN_USERID_VERSION_VERSION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CdsDemandVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(version);

				list = (List<CdsDemandVersion>)QueryUtil.list(
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
	 * Returns the first cds demand version in the ordered set where userId = &#63; and version = &#63;.
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByUserId_Version_First(
			long userId, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByUserId_Version_First(
			userId, version, orderByComparator);

		if (cdsDemandVersion != null) {
			return cdsDemandVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", version=");
		sb.append(version);

		sb.append("}");

		throw new NoSuchCdsDemandVersionException(sb.toString());
	}

	/**
	 * Returns the first cds demand version in the ordered set where userId = &#63; and version = &#63;.
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByUserId_Version_First(
		long userId, int version,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		List<CdsDemandVersion> list = findByUserId_Version(
			userId, version, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cds demand version in the ordered set where userId = &#63; and version = &#63;.
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByUserId_Version_Last(
			long userId, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByUserId_Version_Last(
			userId, version, orderByComparator);

		if (cdsDemandVersion != null) {
			return cdsDemandVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", version=");
		sb.append(version);

		sb.append("}");

		throw new NoSuchCdsDemandVersionException(sb.toString());
	}

	/**
	 * Returns the last cds demand version in the ordered set where userId = &#63; and version = &#63;.
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByUserId_Version_Last(
		long userId, int version,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		int count = countByUserId_Version(userId, version);

		if (count == 0) {
			return null;
		}

		List<CdsDemandVersion> list = findByUserId_Version(
			userId, version, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where userId = &#63; and version = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param userId the user ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	@Override
	public CdsDemandVersion[] findByUserId_Version_PrevAndNext(
			long cdsDemandVersionId, long userId, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = findByPrimaryKey(
			cdsDemandVersionId);

		Session session = null;

		try {
			session = openSession();

			CdsDemandVersion[] array = new CdsDemandVersionImpl[3];

			array[0] = getByUserId_Version_PrevAndNext(
				session, cdsDemandVersion, userId, version, orderByComparator,
				true);

			array[1] = cdsDemandVersion;

			array[2] = getByUserId_Version_PrevAndNext(
				session, cdsDemandVersion, userId, version, orderByComparator,
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

	protected CdsDemandVersion getByUserId_Version_PrevAndNext(
		Session session, CdsDemandVersion cdsDemandVersion, long userId,
		int version, OrderByComparator<CdsDemandVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

		sb.append(_FINDER_COLUMN_USERID_VERSION_USERID_2);

		sb.append(_FINDER_COLUMN_USERID_VERSION_VERSION_2);

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
			sb.append(CdsDemandVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		queryPos.add(version);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						cdsDemandVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CdsDemandVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cds demand versions where userId = &#63; and version = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param version the version
	 */
	@Override
	public void removeByUserId_Version(long userId, int version) {
		for (CdsDemandVersion cdsDemandVersion :
				findByUserId_Version(
					userId, version, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(cdsDemandVersion);
		}
	}

	/**
	 * Returns the number of cds demand versions where userId = &#63; and version = &#63;.
	 *
	 * @param userId the user ID
	 * @param version the version
	 * @return the number of matching cds demand versions
	 */
	@Override
	public int countByUserId_Version(long userId, int version) {
		FinderPath finderPath = _finderPathCountByUserId_Version;

		Object[] finderArgs = new Object[] {userId, version};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CDSDEMANDVERSION_WHERE);

			sb.append(_FINDER_COLUMN_USERID_VERSION_USERID_2);

			sb.append(_FINDER_COLUMN_USERID_VERSION_VERSION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_VERSION_USERID_2 =
		"cdsDemandVersion.userId = ? AND ";

	private static final String _FINDER_COLUMN_USERID_VERSION_VERSION_2 =
		"cdsDemandVersion.version = ?";

	private FinderPath _finderPathWithPaginationFindByXid;
	private FinderPath _finderPathWithoutPaginationFindByXid;
	private FinderPath _finderPathCountByXid;

	/**
	 * Returns all the cds demand versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByXid(String uuid) {
		return findByXid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demand versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByXid(String uuid, int start, int end) {
		return findByXid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByXid(
		String uuid, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return findByXid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByXid(
		String uuid, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByXid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByXid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<CdsDemandVersion> list = null;

		if (useFinderCache) {
			list = (List<CdsDemandVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemandVersion cdsDemandVersion : list) {
					if (!uuid.equals(cdsDemandVersion.getUuid())) {
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

			sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_XID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_XID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CdsDemandVersionModelImpl.ORDER_BY_JPQL);
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

				list = (List<CdsDemandVersion>)QueryUtil.list(
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
	 * Returns the first cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByXid_First(
			String uuid, OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByXid_First(
			uuid, orderByComparator);

		if (cdsDemandVersion != null) {
			return cdsDemandVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCdsDemandVersionException(sb.toString());
	}

	/**
	 * Returns the first cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByXid_First(
		String uuid, OrderByComparator<CdsDemandVersion> orderByComparator) {

		List<CdsDemandVersion> list = findByXid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByXid_Last(
			String uuid, OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByXid_Last(
			uuid, orderByComparator);

		if (cdsDemandVersion != null) {
			return cdsDemandVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCdsDemandVersionException(sb.toString());
	}

	/**
	 * Returns the last cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByXid_Last(
		String uuid, OrderByComparator<CdsDemandVersion> orderByComparator) {

		int count = countByXid(uuid);

		if (count == 0) {
			return null;
		}

		List<CdsDemandVersion> list = findByXid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where uuid = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	@Override
	public CdsDemandVersion[] findByXid_PrevAndNext(
			long cdsDemandVersionId, String uuid,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		uuid = Objects.toString(uuid, "");

		CdsDemandVersion cdsDemandVersion = findByPrimaryKey(
			cdsDemandVersionId);

		Session session = null;

		try {
			session = openSession();

			CdsDemandVersion[] array = new CdsDemandVersionImpl[3];

			array[0] = getByXid_PrevAndNext(
				session, cdsDemandVersion, uuid, orderByComparator, true);

			array[1] = cdsDemandVersion;

			array[2] = getByXid_PrevAndNext(
				session, cdsDemandVersion, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CdsDemandVersion getByXid_PrevAndNext(
		Session session, CdsDemandVersion cdsDemandVersion, String uuid,
		OrderByComparator<CdsDemandVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_XID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_XID_UUID_2);
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
			sb.append(CdsDemandVersionModelImpl.ORDER_BY_JPQL);
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
						cdsDemandVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CdsDemandVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cds demand versions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByXid(String uuid) {
		for (CdsDemandVersion cdsDemandVersion :
				findByXid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cdsDemandVersion);
		}
	}

	/**
	 * Returns the number of cds demand versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cds demand versions
	 */
	@Override
	public int countByXid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByXid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CDSDEMANDVERSION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_XID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_XID_UUID_2);
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

	private static final String _FINDER_COLUMN_XID_UUID_2 =
		"cdsDemandVersion.uuid = ?";

	private static final String _FINDER_COLUMN_XID_UUID_3 =
		"(cdsDemandVersion.uuid IS NULL OR cdsDemandVersion.uuid = '')";

	private FinderPath _finderPathFetchByXid_Version;
	private FinderPath _finderPathCountByXid_Version;

	/**
	 * Returns the cds demand version where uuid = &#63; and version = &#63; or throws a <code>NoSuchCdsDemandVersionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByXid_Version(String uuid, int version)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByXid_Version(uuid, version);

		if (cdsDemandVersion == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", version=");
			sb.append(version);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCdsDemandVersionException(sb.toString());
		}

		return cdsDemandVersion;
	}

	/**
	 * Returns the cds demand version where uuid = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByXid_Version(String uuid, int version) {
		return fetchByXid_Version(uuid, version, true);
	}

	/**
	 * Returns the cds demand version where uuid = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByXid_Version(
		String uuid, int version, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, version};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByXid_Version, finderArgs);
		}

		if (result instanceof CdsDemandVersion) {
			CdsDemandVersion cdsDemandVersion = (CdsDemandVersion)result;

			if (!Objects.equals(uuid, cdsDemandVersion.getUuid()) ||
				(version != cdsDemandVersion.getVersion())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_XID_VERSION_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_XID_VERSION_UUID_2);
			}

			sb.append(_FINDER_COLUMN_XID_VERSION_VERSION_2);

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

				List<CdsDemandVersion> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByXid_Version, finderArgs, list);
					}
				}
				else {
					CdsDemandVersion cdsDemandVersion = list.get(0);

					result = cdsDemandVersion;

					cacheResult(cdsDemandVersion);
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
			return (CdsDemandVersion)result;
		}
	}

	/**
	 * Removes the cds demand version where uuid = &#63; and version = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the cds demand version that was removed
	 */
	@Override
	public CdsDemandVersion removeByXid_Version(String uuid, int version)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = findByXid_Version(uuid, version);

		return remove(cdsDemandVersion);
	}

	/**
	 * Returns the number of cds demand versions where uuid = &#63; and version = &#63;.
	 *
	 * @param uuid the uuid
	 * @param version the version
	 * @return the number of matching cds demand versions
	 */
	@Override
	public int countByXid_Version(String uuid, int version) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByXid_Version;

		Object[] finderArgs = new Object[] {uuid, version};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CDSDEMANDVERSION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_XID_VERSION_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_XID_VERSION_UUID_2);
			}

			sb.append(_FINDER_COLUMN_XID_VERSION_VERSION_2);

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

	private static final String _FINDER_COLUMN_XID_VERSION_UUID_2 =
		"cdsDemandVersion.uuid = ? AND ";

	private static final String _FINDER_COLUMN_XID_VERSION_UUID_3 =
		"(cdsDemandVersion.uuid IS NULL OR cdsDemandVersion.uuid = '') AND ";

	private static final String _FINDER_COLUMN_XID_VERSION_VERSION_2 =
		"cdsDemandVersion.version = ?";

	private FinderPath _finderPathWithPaginationFindByDI;
	private FinderPath _finderPathWithoutPaginationFindByDI;
	private FinderPath _finderPathCountByDI;

	/**
	 * Returns all the cds demand versions where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @return the matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByDI(long domainId) {
		return findByDI(domainId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demand versions where domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByDI(long domainId, int start, int end) {
		return findByDI(domainId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByDI(
		long domainId, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return findByDI(domainId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByDI(
		long domainId, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDI;
				finderArgs = new Object[] {domainId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDI;
			finderArgs = new Object[] {domainId, start, end, orderByComparator};
		}

		List<CdsDemandVersion> list = null;

		if (useFinderCache) {
			list = (List<CdsDemandVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemandVersion cdsDemandVersion : list) {
					if (domainId != cdsDemandVersion.getDomainId()) {
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

			sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

			sb.append(_FINDER_COLUMN_DI_DOMAINID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CdsDemandVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(domainId);

				list = (List<CdsDemandVersion>)QueryUtil.list(
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
	 * Returns the first cds demand version in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByDI_First(
			long domainId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByDI_First(
			domainId, orderByComparator);

		if (cdsDemandVersion != null) {
			return cdsDemandVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("domainId=");
		sb.append(domainId);

		sb.append("}");

		throw new NoSuchCdsDemandVersionException(sb.toString());
	}

	/**
	 * Returns the first cds demand version in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByDI_First(
		long domainId, OrderByComparator<CdsDemandVersion> orderByComparator) {

		List<CdsDemandVersion> list = findByDI(
			domainId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cds demand version in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByDI_Last(
			long domainId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByDI_Last(
			domainId, orderByComparator);

		if (cdsDemandVersion != null) {
			return cdsDemandVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("domainId=");
		sb.append(domainId);

		sb.append("}");

		throw new NoSuchCdsDemandVersionException(sb.toString());
	}

	/**
	 * Returns the last cds demand version in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByDI_Last(
		long domainId, OrderByComparator<CdsDemandVersion> orderByComparator) {

		int count = countByDI(domainId);

		if (count == 0) {
			return null;
		}

		List<CdsDemandVersion> list = findByDI(
			domainId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where domainId = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	@Override
	public CdsDemandVersion[] findByDI_PrevAndNext(
			long cdsDemandVersionId, long domainId,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = findByPrimaryKey(
			cdsDemandVersionId);

		Session session = null;

		try {
			session = openSession();

			CdsDemandVersion[] array = new CdsDemandVersionImpl[3];

			array[0] = getByDI_PrevAndNext(
				session, cdsDemandVersion, domainId, orderByComparator, true);

			array[1] = cdsDemandVersion;

			array[2] = getByDI_PrevAndNext(
				session, cdsDemandVersion, domainId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CdsDemandVersion getByDI_PrevAndNext(
		Session session, CdsDemandVersion cdsDemandVersion, long domainId,
		OrderByComparator<CdsDemandVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

		sb.append(_FINDER_COLUMN_DI_DOMAINID_2);

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
			sb.append(CdsDemandVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(domainId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						cdsDemandVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CdsDemandVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cds demand versions where domainId = &#63; from the database.
	 *
	 * @param domainId the domain ID
	 */
	@Override
	public void removeByDI(long domainId) {
		for (CdsDemandVersion cdsDemandVersion :
				findByDI(
					domainId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cdsDemandVersion);
		}
	}

	/**
	 * Returns the number of cds demand versions where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @return the number of matching cds demand versions
	 */
	@Override
	public int countByDI(long domainId) {
		FinderPath finderPath = _finderPathCountByDI;

		Object[] finderArgs = new Object[] {domainId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CDSDEMANDVERSION_WHERE);

			sb.append(_FINDER_COLUMN_DI_DOMAINID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(domainId);

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

	private static final String _FINDER_COLUMN_DI_DOMAINID_2 =
		"cdsDemandVersion.domainId = ?";

	private FinderPath _finderPathWithPaginationFindByDI_Version;
	private FinderPath _finderPathWithoutPaginationFindByDI_Version;
	private FinderPath _finderPathCountByDI_Version;

	/**
	 * Returns all the cds demand versions where domainId = &#63; and version = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @return the matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByDI_Version(long domainId, int version) {
		return findByDI_Version(
			domainId, version, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demand versions where domainId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByDI_Version(
		long domainId, int version, int start, int end) {

		return findByDI_Version(domainId, version, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where domainId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByDI_Version(
		long domainId, int version, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return findByDI_Version(
			domainId, version, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demand versions where domainId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findByDI_Version(
		long domainId, int version, int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDI_Version;
				finderArgs = new Object[] {domainId, version};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDI_Version;
			finderArgs = new Object[] {
				domainId, version, start, end, orderByComparator
			};
		}

		List<CdsDemandVersion> list = null;

		if (useFinderCache) {
			list = (List<CdsDemandVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemandVersion cdsDemandVersion : list) {
					if ((domainId != cdsDemandVersion.getDomainId()) ||
						(version != cdsDemandVersion.getVersion())) {

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

			sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

			sb.append(_FINDER_COLUMN_DI_VERSION_DOMAINID_2);

			sb.append(_FINDER_COLUMN_DI_VERSION_VERSION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CdsDemandVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(domainId);

				queryPos.add(version);

				list = (List<CdsDemandVersion>)QueryUtil.list(
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
	 * Returns the first cds demand version in the ordered set where domainId = &#63; and version = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByDI_Version_First(
			long domainId, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByDI_Version_First(
			domainId, version, orderByComparator);

		if (cdsDemandVersion != null) {
			return cdsDemandVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("domainId=");
		sb.append(domainId);

		sb.append(", version=");
		sb.append(version);

		sb.append("}");

		throw new NoSuchCdsDemandVersionException(sb.toString());
	}

	/**
	 * Returns the first cds demand version in the ordered set where domainId = &#63; and version = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByDI_Version_First(
		long domainId, int version,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		List<CdsDemandVersion> list = findByDI_Version(
			domainId, version, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cds demand version in the ordered set where domainId = &#63; and version = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version
	 * @throws NoSuchCdsDemandVersionException if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion findByDI_Version_Last(
			long domainId, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByDI_Version_Last(
			domainId, version, orderByComparator);

		if (cdsDemandVersion != null) {
			return cdsDemandVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("domainId=");
		sb.append(domainId);

		sb.append(", version=");
		sb.append(version);

		sb.append("}");

		throw new NoSuchCdsDemandVersionException(sb.toString());
	}

	/**
	 * Returns the last cds demand version in the ordered set where domainId = &#63; and version = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand version, or <code>null</code> if a matching cds demand version could not be found
	 */
	@Override
	public CdsDemandVersion fetchByDI_Version_Last(
		long domainId, int version,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		int count = countByDI_Version(domainId, version);

		if (count == 0) {
			return null;
		}

		List<CdsDemandVersion> list = findByDI_Version(
			domainId, version, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cds demand versions before and after the current cds demand version in the ordered set where domainId = &#63; and version = &#63;.
	 *
	 * @param cdsDemandVersionId the primary key of the current cds demand version
	 * @param domainId the domain ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	@Override
	public CdsDemandVersion[] findByDI_Version_PrevAndNext(
			long cdsDemandVersionId, long domainId, int version,
			OrderByComparator<CdsDemandVersion> orderByComparator)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = findByPrimaryKey(
			cdsDemandVersionId);

		Session session = null;

		try {
			session = openSession();

			CdsDemandVersion[] array = new CdsDemandVersionImpl[3];

			array[0] = getByDI_Version_PrevAndNext(
				session, cdsDemandVersion, domainId, version, orderByComparator,
				true);

			array[1] = cdsDemandVersion;

			array[2] = getByDI_Version_PrevAndNext(
				session, cdsDemandVersion, domainId, version, orderByComparator,
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

	protected CdsDemandVersion getByDI_Version_PrevAndNext(
		Session session, CdsDemandVersion cdsDemandVersion, long domainId,
		int version, OrderByComparator<CdsDemandVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_CDSDEMANDVERSION_WHERE);

		sb.append(_FINDER_COLUMN_DI_VERSION_DOMAINID_2);

		sb.append(_FINDER_COLUMN_DI_VERSION_VERSION_2);

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
			sb.append(CdsDemandVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(domainId);

		queryPos.add(version);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						cdsDemandVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CdsDemandVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cds demand versions where domainId = &#63; and version = &#63; from the database.
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 */
	@Override
	public void removeByDI_Version(long domainId, int version) {
		for (CdsDemandVersion cdsDemandVersion :
				findByDI_Version(
					domainId, version, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(cdsDemandVersion);
		}
	}

	/**
	 * Returns the number of cds demand versions where domainId = &#63; and version = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param version the version
	 * @return the number of matching cds demand versions
	 */
	@Override
	public int countByDI_Version(long domainId, int version) {
		FinderPath finderPath = _finderPathCountByDI_Version;

		Object[] finderArgs = new Object[] {domainId, version};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CDSDEMANDVERSION_WHERE);

			sb.append(_FINDER_COLUMN_DI_VERSION_DOMAINID_2);

			sb.append(_FINDER_COLUMN_DI_VERSION_VERSION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(domainId);

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

	private static final String _FINDER_COLUMN_DI_VERSION_DOMAINID_2 =
		"cdsDemandVersion.domainId = ? AND ";

	private static final String _FINDER_COLUMN_DI_VERSION_VERSION_2 =
		"cdsDemandVersion.version = ?";

	public CdsDemandVersionPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");
		dbColumnNames.put("state", "state_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CdsDemandVersion.class);

		setModelImplClass(CdsDemandVersionImpl.class);
		setModelPKClass(long.class);

		setTable(CdsDemandVersionTable.INSTANCE);
	}

	/**
	 * Caches the cds demand version in the entity cache if it is enabled.
	 *
	 * @param cdsDemandVersion the cds demand version
	 */
	@Override
	public void cacheResult(CdsDemandVersion cdsDemandVersion) {
		entityCache.putResult(
			CdsDemandVersionImpl.class, cdsDemandVersion.getPrimaryKey(),
			cdsDemandVersion);

		finderCache.putResult(
			_finderPathFetchByDemandId_Version,
			new Object[] {
				cdsDemandVersion.getDemandId(), cdsDemandVersion.getVersion()
			},
			cdsDemandVersion);

		finderCache.putResult(
			_finderPathFetchByUUID_G_Version,
			new Object[] {
				cdsDemandVersion.getUuid(), cdsDemandVersion.getGroupId(),
				cdsDemandVersion.getVersion()
			},
			cdsDemandVersion);

		finderCache.putResult(
			_finderPathFetchByXid_Version,
			new Object[] {
				cdsDemandVersion.getUuid(), cdsDemandVersion.getVersion()
			},
			cdsDemandVersion);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the cds demand versions in the entity cache if it is enabled.
	 *
	 * @param cdsDemandVersions the cds demand versions
	 */
	@Override
	public void cacheResult(List<CdsDemandVersion> cdsDemandVersions) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (cdsDemandVersions.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CdsDemandVersion cdsDemandVersion : cdsDemandVersions) {
			if (entityCache.getResult(
					CdsDemandVersionImpl.class,
					cdsDemandVersion.getPrimaryKey()) == null) {

				cacheResult(cdsDemandVersion);
			}
		}
	}

	/**
	 * Clears the cache for all cds demand versions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CdsDemandVersionImpl.class);

		finderCache.clearCache(CdsDemandVersionImpl.class);
	}

	/**
	 * Clears the cache for the cds demand version.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CdsDemandVersion cdsDemandVersion) {
		entityCache.removeResult(CdsDemandVersionImpl.class, cdsDemandVersion);
	}

	@Override
	public void clearCache(List<CdsDemandVersion> cdsDemandVersions) {
		for (CdsDemandVersion cdsDemandVersion : cdsDemandVersions) {
			entityCache.removeResult(
				CdsDemandVersionImpl.class, cdsDemandVersion);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CdsDemandVersionImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CdsDemandVersionImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CdsDemandVersionModelImpl cdsDemandVersionModelImpl) {

		Object[] args = new Object[] {
			cdsDemandVersionModelImpl.getDemandId(),
			cdsDemandVersionModelImpl.getVersion()
		};

		finderCache.putResult(
			_finderPathCountByDemandId_Version, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDemandId_Version, args,
			cdsDemandVersionModelImpl);

		args = new Object[] {
			cdsDemandVersionModelImpl.getUuid(),
			cdsDemandVersionModelImpl.getGroupId(),
			cdsDemandVersionModelImpl.getVersion()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G_Version, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G_Version, args, cdsDemandVersionModelImpl);

		args = new Object[] {
			cdsDemandVersionModelImpl.getUuid(),
			cdsDemandVersionModelImpl.getVersion()
		};

		finderCache.putResult(
			_finderPathCountByXid_Version, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByXid_Version, args, cdsDemandVersionModelImpl);
	}

	/**
	 * Creates a new cds demand version with the primary key. Does not add the cds demand version to the database.
	 *
	 * @param cdsDemandVersionId the primary key for the new cds demand version
	 * @return the new cds demand version
	 */
	@Override
	public CdsDemandVersion create(long cdsDemandVersionId) {
		CdsDemandVersion cdsDemandVersion = new CdsDemandVersionImpl();

		cdsDemandVersion.setNew(true);
		cdsDemandVersion.setPrimaryKey(cdsDemandVersionId);

		cdsDemandVersion.setCompanyId(CompanyThreadLocal.getCompanyId());

		return cdsDemandVersion;
	}

	/**
	 * Removes the cds demand version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cdsDemandVersionId the primary key of the cds demand version
	 * @return the cds demand version that was removed
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	@Override
	public CdsDemandVersion remove(long cdsDemandVersionId)
		throws NoSuchCdsDemandVersionException {

		return remove((Serializable)cdsDemandVersionId);
	}

	/**
	 * Removes the cds demand version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cds demand version
	 * @return the cds demand version that was removed
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	@Override
	public CdsDemandVersion remove(Serializable primaryKey)
		throws NoSuchCdsDemandVersionException {

		Session session = null;

		try {
			session = openSession();

			CdsDemandVersion cdsDemandVersion = (CdsDemandVersion)session.get(
				CdsDemandVersionImpl.class, primaryKey);

			if (cdsDemandVersion == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCdsDemandVersionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(cdsDemandVersion);
		}
		catch (NoSuchCdsDemandVersionException noSuchEntityException) {
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
	protected CdsDemandVersion removeImpl(CdsDemandVersion cdsDemandVersion) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cdsDemandVersion)) {
				cdsDemandVersion = (CdsDemandVersion)session.get(
					CdsDemandVersionImpl.class,
					cdsDemandVersion.getPrimaryKeyObj());
			}

			if (cdsDemandVersion != null) {
				session.delete(cdsDemandVersion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (cdsDemandVersion != null) {
			clearCache(cdsDemandVersion);
		}

		return cdsDemandVersion;
	}

	@Override
	public CdsDemandVersion updateImpl(CdsDemandVersion cdsDemandVersion) {
		boolean isNew = cdsDemandVersion.isNew();

		if (!(cdsDemandVersion instanceof CdsDemandVersionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(cdsDemandVersion.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					cdsDemandVersion);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in cdsDemandVersion proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CdsDemandVersion implementation " +
					cdsDemandVersion.getClass());
		}

		CdsDemandVersionModelImpl cdsDemandVersionModelImpl =
			(CdsDemandVersionModelImpl)cdsDemandVersion;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (cdsDemandVersion.getCreateDate() == null)) {
			if (serviceContext == null) {
				cdsDemandVersion.setCreateDate(date);
			}
			else {
				cdsDemandVersion.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!cdsDemandVersionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				cdsDemandVersion.setModifiedDate(date);
			}
			else {
				cdsDemandVersion.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(cdsDemandVersion);
			}
			else {
				throw new IllegalArgumentException(
					"CdsDemandVersion is read only, create a new version instead");
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CdsDemandVersionImpl.class, cdsDemandVersionModelImpl, false, true);

		cacheUniqueFindersCache(cdsDemandVersionModelImpl);

		if (isNew) {
			cdsDemandVersion.setNew(false);
		}

		cdsDemandVersion.resetOriginalValues();

		return cdsDemandVersion;
	}

	/**
	 * Returns the cds demand version with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cds demand version
	 * @return the cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	@Override
	public CdsDemandVersion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCdsDemandVersionException {

		CdsDemandVersion cdsDemandVersion = fetchByPrimaryKey(primaryKey);

		if (cdsDemandVersion == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCdsDemandVersionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return cdsDemandVersion;
	}

	/**
	 * Returns the cds demand version with the primary key or throws a <code>NoSuchCdsDemandVersionException</code> if it could not be found.
	 *
	 * @param cdsDemandVersionId the primary key of the cds demand version
	 * @return the cds demand version
	 * @throws NoSuchCdsDemandVersionException if a cds demand version with the primary key could not be found
	 */
	@Override
	public CdsDemandVersion findByPrimaryKey(long cdsDemandVersionId)
		throws NoSuchCdsDemandVersionException {

		return findByPrimaryKey((Serializable)cdsDemandVersionId);
	}

	/**
	 * Returns the cds demand version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cdsDemandVersionId the primary key of the cds demand version
	 * @return the cds demand version, or <code>null</code> if a cds demand version with the primary key could not be found
	 */
	@Override
	public CdsDemandVersion fetchByPrimaryKey(long cdsDemandVersionId) {
		return fetchByPrimaryKey((Serializable)cdsDemandVersionId);
	}

	/**
	 * Returns all the cds demand versions.
	 *
	 * @return the cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demand versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @return the range of cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demand versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findAll(
		int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demand versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cds demand versions
	 * @param end the upper bound of the range of cds demand versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cds demand versions
	 */
	@Override
	public List<CdsDemandVersion> findAll(
		int start, int end,
		OrderByComparator<CdsDemandVersion> orderByComparator,
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

		List<CdsDemandVersion> list = null;

		if (useFinderCache) {
			list = (List<CdsDemandVersion>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CDSDEMANDVERSION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CDSDEMANDVERSION;

				sql = sql.concat(CdsDemandVersionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CdsDemandVersion>)QueryUtil.list(
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
	 * Removes all the cds demand versions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CdsDemandVersion cdsDemandVersion : findAll()) {
			remove(cdsDemandVersion);
		}
	}

	/**
	 * Returns the number of cds demand versions.
	 *
	 * @return the number of cds demand versions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CDSDEMANDVERSION);

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
		return "cdsDemandVersionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CDSDEMANDVERSION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CdsDemandVersionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cds demand version persistence.
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

		_finderPathWithPaginationFindByDemandId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDemandId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"demandId"}, true);

		_finderPathWithoutPaginationFindByDemandId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDemandId",
			new String[] {Long.class.getName()}, new String[] {"demandId"},
			true);

		_finderPathCountByDemandId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDemandId",
			new String[] {Long.class.getName()}, new String[] {"demandId"},
			false);

		_finderPathFetchByDemandId_Version = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDemandId_Version",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"demandId", "version"}, true);

		_finderPathCountByDemandId_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDemandId_Version",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"demandId", "version"}, false);

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

		_finderPathWithPaginationFindByUserId_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId_Version",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"userId", "version"}, true);

		_finderPathWithoutPaginationFindByUserId_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId_Version",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"userId", "version"}, true);

		_finderPathCountByUserId_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId_Version",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"userId", "version"}, false);

		_finderPathWithPaginationFindByXid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByXid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByXid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByXid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByXid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByXid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByXid_Version = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByXid_Version",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"uuid_", "version"}, true);

		_finderPathCountByXid_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByXid_Version",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"uuid_", "version"}, false);

		_finderPathWithPaginationFindByDI = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDI",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"domainId"}, true);

		_finderPathWithoutPaginationFindByDI = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDI",
			new String[] {Long.class.getName()}, new String[] {"domainId"},
			true);

		_finderPathCountByDI = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDI",
			new String[] {Long.class.getName()}, new String[] {"domainId"},
			false);

		_finderPathWithPaginationFindByDI_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDI_Version",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"domainId", "version"}, true);

		_finderPathWithoutPaginationFindByDI_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDI_Version",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"domainId", "version"}, true);

		_finderPathCountByDI_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDI_Version",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"domainId", "version"}, false);

		_setCdsDemandVersionUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCdsDemandVersionUtilPersistence(null);

		entityCache.removeCache(CdsDemandVersionImpl.class.getName());
	}

	private void _setCdsDemandVersionUtilPersistence(
		CdsDemandVersionPersistence cdsDemandVersionPersistence) {

		try {
			Field field = CdsDemandVersionUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, cdsDemandVersionPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = CdsDemandsPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = CdsDemandsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CdsDemandsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CDSDEMANDVERSION =
		"SELECT cdsDemandVersion FROM CdsDemandVersion cdsDemandVersion";

	private static final String _SQL_SELECT_CDSDEMANDVERSION_WHERE =
		"SELECT cdsDemandVersion FROM CdsDemandVersion cdsDemandVersion WHERE ";

	private static final String _SQL_COUNT_CDSDEMANDVERSION =
		"SELECT COUNT(cdsDemandVersion) FROM CdsDemandVersion cdsDemandVersion";

	private static final String _SQL_COUNT_CDSDEMANDVERSION_WHERE =
		"SELECT COUNT(cdsDemandVersion) FROM CdsDemandVersion cdsDemandVersion WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "cdsDemandVersion.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CdsDemandVersion exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CdsDemandVersion exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CdsDemandVersionPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type", "state"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private CdsDemandVersionModelArgumentsResolver
		_cdsDemandVersionModelArgumentsResolver;

}