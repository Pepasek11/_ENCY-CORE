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

import cz.csob.ency.cds.demands.exception.NoSuchCdsDemandException;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.cds.demands.model.CdsDemandTable;
import cz.csob.ency.cds.demands.model.impl.CdsDemandImpl;
import cz.csob.ency.cds.demands.model.impl.CdsDemandModelImpl;
import cz.csob.ency.cds.demands.service.persistence.CdsDemandPersistence;
import cz.csob.ency.cds.demands.service.persistence.CdsDemandUtil;
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
 * The persistence implementation for the cds demand service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @generated
 */
@Component(service = {CdsDemandPersistence.class, BasePersistence.class})
public class CdsDemandPersistenceImpl
	extends BasePersistenceImpl<CdsDemand> implements CdsDemandPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CdsDemandUtil</code> to access the cds demand persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CdsDemandImpl.class.getName();

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
	 * Returns all the cds demands where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demands where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
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

		List<CdsDemand> list = null;

		if (useFinderCache) {
			list = (List<CdsDemand>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemand cdsDemand : list) {
					if (!uuid.equals(cdsDemand.getUuid())) {
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

			sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

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
				sb.append(CdsDemandModelImpl.ORDER_BY_JPQL);
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

				list = (List<CdsDemand>)QueryUtil.list(
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
	 * Returns the first cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand findByUuid_First(
			String uuid, OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = fetchByUuid_First(uuid, orderByComparator);

		if (cdsDemand != null) {
			return cdsDemand;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCdsDemandException(sb.toString());
	}

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByUuid_First(
		String uuid, OrderByComparator<CdsDemand> orderByComparator) {

		List<CdsDemand> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand findByUuid_Last(
			String uuid, OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = fetchByUuid_Last(uuid, orderByComparator);

		if (cdsDemand != null) {
			return cdsDemand;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCdsDemandException(sb.toString());
	}

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByUuid_Last(
		String uuid, OrderByComparator<CdsDemand> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CdsDemand> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	@Override
	public CdsDemand[] findByUuid_PrevAndNext(
			long demandId, String uuid,
			OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		uuid = Objects.toString(uuid, "");

		CdsDemand cdsDemand = findByPrimaryKey(demandId);

		Session session = null;

		try {
			session = openSession();

			CdsDemand[] array = new CdsDemandImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, cdsDemand, uuid, orderByComparator, true);

			array[1] = cdsDemand;

			array[2] = getByUuid_PrevAndNext(
				session, cdsDemand, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CdsDemand getByUuid_PrevAndNext(
		Session session, CdsDemand cdsDemand, String uuid,
		OrderByComparator<CdsDemand> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

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
			sb.append(CdsDemandModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(cdsDemand)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CdsDemand> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cds demands where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CdsDemand cdsDemand :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cdsDemand);
		}
	}

	/**
	 * Returns the number of cds demands where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cds demands
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CDSDEMAND_WHERE);

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
		"cdsDemand.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(cdsDemand.uuid IS NULL OR cdsDemand.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_Head;
	private FinderPath _finderPathWithoutPaginationFindByUuid_Head;
	private FinderPath _finderPathCountByUuid_Head;

	/**
	 * Returns all the cds demands where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUuid_Head(String uuid, boolean head) {
		return findByUuid_Head(
			uuid, head, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demands where uuid = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUuid_Head(
		String uuid, boolean head, int start, int end) {

		return findByUuid_Head(uuid, head, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUuid_Head(
		String uuid, boolean head, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return findByUuid_Head(uuid, head, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUuid_Head(
		String uuid, boolean head, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
		boolean useFinderCache) {

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

		List<CdsDemand> list = null;

		if (useFinderCache) {
			list = (List<CdsDemand>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemand cdsDemand : list) {
					if (!uuid.equals(cdsDemand.getUuid()) ||
						(head != cdsDemand.isHead())) {

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

			sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

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
				sb.append(CdsDemandModelImpl.ORDER_BY_JPQL);
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

				list = (List<CdsDemand>)QueryUtil.list(
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
	 * Returns the first cds demand in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand findByUuid_Head_First(
			String uuid, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = fetchByUuid_Head_First(
			uuid, head, orderByComparator);

		if (cdsDemand != null) {
			return cdsDemand;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", head=");
		sb.append(head);

		sb.append("}");

		throw new NoSuchCdsDemandException(sb.toString());
	}

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByUuid_Head_First(
		String uuid, boolean head,
		OrderByComparator<CdsDemand> orderByComparator) {

		List<CdsDemand> list = findByUuid_Head(
			uuid, head, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand findByUuid_Head_Last(
			String uuid, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = fetchByUuid_Head_Last(
			uuid, head, orderByComparator);

		if (cdsDemand != null) {
			return cdsDemand;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", head=");
		sb.append(head);

		sb.append("}");

		throw new NoSuchCdsDemandException(sb.toString());
	}

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByUuid_Head_Last(
		String uuid, boolean head,
		OrderByComparator<CdsDemand> orderByComparator) {

		int count = countByUuid_Head(uuid, head);

		if (count == 0) {
			return null;
		}

		List<CdsDemand> list = findByUuid_Head(
			uuid, head, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where uuid = &#63; and head = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param uuid the uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	@Override
	public CdsDemand[] findByUuid_Head_PrevAndNext(
			long demandId, String uuid, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		uuid = Objects.toString(uuid, "");

		CdsDemand cdsDemand = findByPrimaryKey(demandId);

		Session session = null;

		try {
			session = openSession();

			CdsDemand[] array = new CdsDemandImpl[3];

			array[0] = getByUuid_Head_PrevAndNext(
				session, cdsDemand, uuid, head, orderByComparator, true);

			array[1] = cdsDemand;

			array[2] = getByUuid_Head_PrevAndNext(
				session, cdsDemand, uuid, head, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CdsDemand getByUuid_Head_PrevAndNext(
		Session session, CdsDemand cdsDemand, String uuid, boolean head,
		OrderByComparator<CdsDemand> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

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
			sb.append(CdsDemandModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(cdsDemand)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CdsDemand> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cds demands where uuid = &#63; and head = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 */
	@Override
	public void removeByUuid_Head(String uuid, boolean head) {
		for (CdsDemand cdsDemand :
				findByUuid_Head(
					uuid, head, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cdsDemand);
		}
	}

	/**
	 * Returns the number of cds demands where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the number of matching cds demands
	 */
	@Override
	public int countByUuid_Head(String uuid, boolean head) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_Head;

		Object[] finderArgs = new Object[] {uuid, head};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CDSDEMAND_WHERE);

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
		"cdsDemand.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_HEAD_UUID_3 =
		"(cdsDemand.uuid IS NULL OR cdsDemand.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_HEAD_HEAD_2 =
		"cdsDemand.head = ?";

	private FinderPath _finderPathWithPaginationFindByUUID_G;
	private FinderPath _finderPathWithoutPaginationFindByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns all the cds demands where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUUID_G(String uuid, long groupId) {
		return findByUUID_G(
			uuid, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demands where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUUID_G(
		String uuid, long groupId, int start, int end) {

		return findByUUID_G(uuid, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUUID_G(
		String uuid, long groupId, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return findByUUID_G(uuid, groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUUID_G(
		String uuid, long groupId, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
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

		List<CdsDemand> list = null;

		if (useFinderCache) {
			list = (List<CdsDemand>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemand cdsDemand : list) {
					if (!uuid.equals(cdsDemand.getUuid()) ||
						(groupId != cdsDemand.getGroupId())) {

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

			sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

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
				sb.append(CdsDemandModelImpl.ORDER_BY_JPQL);
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

				list = (List<CdsDemand>)QueryUtil.list(
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
	 * Returns the first cds demand in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand findByUUID_G_First(
			String uuid, long groupId,
			OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = fetchByUUID_G_First(
			uuid, groupId, orderByComparator);

		if (cdsDemand != null) {
			return cdsDemand;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchCdsDemandException(sb.toString());
	}

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByUUID_G_First(
		String uuid, long groupId,
		OrderByComparator<CdsDemand> orderByComparator) {

		List<CdsDemand> list = findByUUID_G(
			uuid, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand findByUUID_G_Last(
			String uuid, long groupId,
			OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = fetchByUUID_G_Last(
			uuid, groupId, orderByComparator);

		if (cdsDemand != null) {
			return cdsDemand;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchCdsDemandException(sb.toString());
	}

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByUUID_G_Last(
		String uuid, long groupId,
		OrderByComparator<CdsDemand> orderByComparator) {

		int count = countByUUID_G(uuid, groupId);

		if (count == 0) {
			return null;
		}

		List<CdsDemand> list = findByUUID_G(
			uuid, groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where uuid = &#63; and groupId = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	@Override
	public CdsDemand[] findByUUID_G_PrevAndNext(
			long demandId, String uuid, long groupId,
			OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		uuid = Objects.toString(uuid, "");

		CdsDemand cdsDemand = findByPrimaryKey(demandId);

		Session session = null;

		try {
			session = openSession();

			CdsDemand[] array = new CdsDemandImpl[3];

			array[0] = getByUUID_G_PrevAndNext(
				session, cdsDemand, uuid, groupId, orderByComparator, true);

			array[1] = cdsDemand;

			array[2] = getByUUID_G_PrevAndNext(
				session, cdsDemand, uuid, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CdsDemand getByUUID_G_PrevAndNext(
		Session session, CdsDemand cdsDemand, String uuid, long groupId,
		OrderByComparator<CdsDemand> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

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
			sb.append(CdsDemandModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(cdsDemand)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CdsDemand> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cds demands where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 */
	@Override
	public void removeByUUID_G(String uuid, long groupId) {
		for (CdsDemand cdsDemand :
				findByUUID_G(
					uuid, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(cdsDemand);
		}
	}

	/**
	 * Returns the number of cds demands where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching cds demands
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CDSDEMAND_WHERE);

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
		"cdsDemand.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(cdsDemand.uuid IS NULL OR cdsDemand.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"cdsDemand.groupId = ?";

	private FinderPath _finderPathFetchByUUID_G_Head;
	private FinderPath _finderPathCountByUUID_G_Head;

	/**
	 * Returns the cds demand where uuid = &#63; and groupId = &#63; and head = &#63; or throws a <code>NoSuchCdsDemandException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand findByUUID_G_Head(String uuid, long groupId, boolean head)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = fetchByUUID_G_Head(uuid, groupId, head);

		if (cdsDemand == null) {
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

			throw new NoSuchCdsDemandException(sb.toString());
		}

		return cdsDemand;
	}

	/**
	 * Returns the cds demand where uuid = &#63; and groupId = &#63; and head = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByUUID_G_Head(
		String uuid, long groupId, boolean head) {

		return fetchByUUID_G_Head(uuid, groupId, head, true);
	}

	/**
	 * Returns the cds demand where uuid = &#63; and groupId = &#63; and head = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByUUID_G_Head(
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

		if (result instanceof CdsDemand) {
			CdsDemand cdsDemand = (CdsDemand)result;

			if (!Objects.equals(uuid, cdsDemand.getUuid()) ||
				(groupId != cdsDemand.getGroupId()) ||
				(head != cdsDemand.isHead())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

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

				List<CdsDemand> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G_Head, finderArgs, list);
					}
				}
				else {
					CdsDemand cdsDemand = list.get(0);

					result = cdsDemand;

					cacheResult(cdsDemand);
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
			return (CdsDemand)result;
		}
	}

	/**
	 * Removes the cds demand where uuid = &#63; and groupId = &#63; and head = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the cds demand that was removed
	 */
	@Override
	public CdsDemand removeByUUID_G_Head(
			String uuid, long groupId, boolean head)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = findByUUID_G_Head(uuid, groupId, head);

		return remove(cdsDemand);
	}

	/**
	 * Returns the number of cds demands where uuid = &#63; and groupId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param head the head
	 * @return the number of matching cds demands
	 */
	@Override
	public int countByUUID_G_Head(String uuid, long groupId, boolean head) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G_Head;

		Object[] finderArgs = new Object[] {uuid, groupId, head};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_CDSDEMAND_WHERE);

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
		"cdsDemand.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_HEAD_UUID_3 =
		"(cdsDemand.uuid IS NULL OR cdsDemand.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_HEAD_GROUPID_2 =
		"cdsDemand.groupId = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_HEAD_HEAD_2 =
		"cdsDemand.head = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the cds demands where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demands where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
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

		List<CdsDemand> list = null;

		if (useFinderCache) {
			list = (List<CdsDemand>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemand cdsDemand : list) {
					if (!uuid.equals(cdsDemand.getUuid()) ||
						(companyId != cdsDemand.getCompanyId())) {

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

			sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

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
				sb.append(CdsDemandModelImpl.ORDER_BY_JPQL);
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

				list = (List<CdsDemand>)QueryUtil.list(
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
	 * Returns the first cds demand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (cdsDemand != null) {
			return cdsDemand;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCdsDemandException(sb.toString());
	}

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CdsDemand> orderByComparator) {

		List<CdsDemand> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (cdsDemand != null) {
			return cdsDemand;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCdsDemandException(sb.toString());
	}

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CdsDemand> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CdsDemand> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	@Override
	public CdsDemand[] findByUuid_C_PrevAndNext(
			long demandId, String uuid, long companyId,
			OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		uuid = Objects.toString(uuid, "");

		CdsDemand cdsDemand = findByPrimaryKey(demandId);

		Session session = null;

		try {
			session = openSession();

			CdsDemand[] array = new CdsDemandImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, cdsDemand, uuid, companyId, orderByComparator, true);

			array[1] = cdsDemand;

			array[2] = getByUuid_C_PrevAndNext(
				session, cdsDemand, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CdsDemand getByUuid_C_PrevAndNext(
		Session session, CdsDemand cdsDemand, String uuid, long companyId,
		OrderByComparator<CdsDemand> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

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
			sb.append(CdsDemandModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(cdsDemand)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CdsDemand> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cds demands where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CdsDemand cdsDemand :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(cdsDemand);
		}
	}

	/**
	 * Returns the number of cds demands where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching cds demands
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CDSDEMAND_WHERE);

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
		"cdsDemand.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(cdsDemand.uuid IS NULL OR cdsDemand.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"cdsDemand.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C_Head;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C_Head;
	private FinderPath _finderPathCountByUuid_C_Head;

	/**
	 * Returns all the cds demands where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @return the matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUuid_C_Head(
		String uuid, long companyId, boolean head) {

		return findByUuid_C_Head(
			uuid, companyId, head, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demands where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUuid_C_Head(
		String uuid, long companyId, boolean head, int start, int end) {

		return findByUuid_C_Head(uuid, companyId, head, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUuid_C_Head(
		String uuid, long companyId, boolean head, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return findByUuid_C_Head(
			uuid, companyId, head, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUuid_C_Head(
		String uuid, long companyId, boolean head, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
		boolean useFinderCache) {

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

		List<CdsDemand> list = null;

		if (useFinderCache) {
			list = (List<CdsDemand>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemand cdsDemand : list) {
					if (!uuid.equals(cdsDemand.getUuid()) ||
						(companyId != cdsDemand.getCompanyId()) ||
						(head != cdsDemand.isHead())) {

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

			sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

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
				sb.append(CdsDemandModelImpl.ORDER_BY_JPQL);
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

				list = (List<CdsDemand>)QueryUtil.list(
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
	 * Returns the first cds demand in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand findByUuid_C_Head_First(
			String uuid, long companyId, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = fetchByUuid_C_Head_First(
			uuid, companyId, head, orderByComparator);

		if (cdsDemand != null) {
			return cdsDemand;
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

		throw new NoSuchCdsDemandException(sb.toString());
	}

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByUuid_C_Head_First(
		String uuid, long companyId, boolean head,
		OrderByComparator<CdsDemand> orderByComparator) {

		List<CdsDemand> list = findByUuid_C_Head(
			uuid, companyId, head, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand findByUuid_C_Head_Last(
			String uuid, long companyId, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = fetchByUuid_C_Head_Last(
			uuid, companyId, head, orderByComparator);

		if (cdsDemand != null) {
			return cdsDemand;
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

		throw new NoSuchCdsDemandException(sb.toString());
	}

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByUuid_C_Head_Last(
		String uuid, long companyId, boolean head,
		OrderByComparator<CdsDemand> orderByComparator) {

		int count = countByUuid_C_Head(uuid, companyId, head);

		if (count == 0) {
			return null;
		}

		List<CdsDemand> list = findByUuid_C_Head(
			uuid, companyId, head, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	@Override
	public CdsDemand[] findByUuid_C_Head_PrevAndNext(
			long demandId, String uuid, long companyId, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		uuid = Objects.toString(uuid, "");

		CdsDemand cdsDemand = findByPrimaryKey(demandId);

		Session session = null;

		try {
			session = openSession();

			CdsDemand[] array = new CdsDemandImpl[3];

			array[0] = getByUuid_C_Head_PrevAndNext(
				session, cdsDemand, uuid, companyId, head, orderByComparator,
				true);

			array[1] = cdsDemand;

			array[2] = getByUuid_C_Head_PrevAndNext(
				session, cdsDemand, uuid, companyId, head, orderByComparator,
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

	protected CdsDemand getByUuid_C_Head_PrevAndNext(
		Session session, CdsDemand cdsDemand, String uuid, long companyId,
		boolean head, OrderByComparator<CdsDemand> orderByComparator,
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

		sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

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
			sb.append(CdsDemandModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(cdsDemand)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CdsDemand> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cds demands where uuid = &#63; and companyId = &#63; and head = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 */
	@Override
	public void removeByUuid_C_Head(String uuid, long companyId, boolean head) {
		for (CdsDemand cdsDemand :
				findByUuid_C_Head(
					uuid, companyId, head, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(cdsDemand);
		}
	}

	/**
	 * Returns the number of cds demands where uuid = &#63; and companyId = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param head the head
	 * @return the number of matching cds demands
	 */
	@Override
	public int countByUuid_C_Head(String uuid, long companyId, boolean head) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C_Head;

		Object[] finderArgs = new Object[] {uuid, companyId, head};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_CDSDEMAND_WHERE);

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
		"cdsDemand.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_HEAD_UUID_3 =
		"(cdsDemand.uuid IS NULL OR cdsDemand.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_HEAD_COMPANYID_2 =
		"cdsDemand.companyId = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_HEAD_HEAD_2 =
		"cdsDemand.head = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the cds demands where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demands where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demands where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUserId(
		long userId, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demands where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUserId(
		long userId, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
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

		List<CdsDemand> list = null;

		if (useFinderCache) {
			list = (List<CdsDemand>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemand cdsDemand : list) {
					if (userId != cdsDemand.getUserId()) {
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

			sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CdsDemandModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<CdsDemand>)QueryUtil.list(
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
	 * Returns the first cds demand in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand findByUserId_First(
			long userId, OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = fetchByUserId_First(userId, orderByComparator);

		if (cdsDemand != null) {
			return cdsDemand;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchCdsDemandException(sb.toString());
	}

	/**
	 * Returns the first cds demand in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByUserId_First(
		long userId, OrderByComparator<CdsDemand> orderByComparator) {

		List<CdsDemand> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cds demand in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand findByUserId_Last(
			long userId, OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = fetchByUserId_Last(userId, orderByComparator);

		if (cdsDemand != null) {
			return cdsDemand;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchCdsDemandException(sb.toString());
	}

	/**
	 * Returns the last cds demand in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByUserId_Last(
		long userId, OrderByComparator<CdsDemand> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<CdsDemand> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where userId = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	@Override
	public CdsDemand[] findByUserId_PrevAndNext(
			long demandId, long userId,
			OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = findByPrimaryKey(demandId);

		Session session = null;

		try {
			session = openSession();

			CdsDemand[] array = new CdsDemandImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, cdsDemand, userId, orderByComparator, true);

			array[1] = cdsDemand;

			array[2] = getByUserId_PrevAndNext(
				session, cdsDemand, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CdsDemand getByUserId_PrevAndNext(
		Session session, CdsDemand cdsDemand, long userId,
		OrderByComparator<CdsDemand> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

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
			sb.append(CdsDemandModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(cdsDemand)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CdsDemand> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cds demands where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (CdsDemand cdsDemand :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cdsDemand);
		}
	}

	/**
	 * Returns the number of cds demands where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching cds demands
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CDSDEMAND_WHERE);

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
		"cdsDemand.userId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId_Head;
	private FinderPath _finderPathWithoutPaginationFindByUserId_Head;
	private FinderPath _finderPathCountByUserId_Head;

	/**
	 * Returns all the cds demands where userId = &#63; and head = &#63;.
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @return the matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUserId_Head(long userId, boolean head) {
		return findByUserId_Head(
			userId, head, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demands where userId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUserId_Head(
		long userId, boolean head, int start, int end) {

		return findByUserId_Head(userId, head, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demands where userId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUserId_Head(
		long userId, boolean head, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return findByUserId_Head(
			userId, head, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demands where userId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByUserId_Head(
		long userId, boolean head, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId_Head;
				finderArgs = new Object[] {userId, head};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId_Head;
			finderArgs = new Object[] {
				userId, head, start, end, orderByComparator
			};
		}

		List<CdsDemand> list = null;

		if (useFinderCache) {
			list = (List<CdsDemand>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemand cdsDemand : list) {
					if ((userId != cdsDemand.getUserId()) ||
						(head != cdsDemand.isHead())) {

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

			sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

			sb.append(_FINDER_COLUMN_USERID_HEAD_USERID_2);

			sb.append(_FINDER_COLUMN_USERID_HEAD_HEAD_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CdsDemandModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(head);

				list = (List<CdsDemand>)QueryUtil.list(
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
	 * Returns the first cds demand in the ordered set where userId = &#63; and head = &#63;.
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand findByUserId_Head_First(
			long userId, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = fetchByUserId_Head_First(
			userId, head, orderByComparator);

		if (cdsDemand != null) {
			return cdsDemand;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", head=");
		sb.append(head);

		sb.append("}");

		throw new NoSuchCdsDemandException(sb.toString());
	}

	/**
	 * Returns the first cds demand in the ordered set where userId = &#63; and head = &#63;.
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByUserId_Head_First(
		long userId, boolean head,
		OrderByComparator<CdsDemand> orderByComparator) {

		List<CdsDemand> list = findByUserId_Head(
			userId, head, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cds demand in the ordered set where userId = &#63; and head = &#63;.
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand findByUserId_Head_Last(
			long userId, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = fetchByUserId_Head_Last(
			userId, head, orderByComparator);

		if (cdsDemand != null) {
			return cdsDemand;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", head=");
		sb.append(head);

		sb.append("}");

		throw new NoSuchCdsDemandException(sb.toString());
	}

	/**
	 * Returns the last cds demand in the ordered set where userId = &#63; and head = &#63;.
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByUserId_Head_Last(
		long userId, boolean head,
		OrderByComparator<CdsDemand> orderByComparator) {

		int count = countByUserId_Head(userId, head);

		if (count == 0) {
			return null;
		}

		List<CdsDemand> list = findByUserId_Head(
			userId, head, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where userId = &#63; and head = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param userId the user ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	@Override
	public CdsDemand[] findByUserId_Head_PrevAndNext(
			long demandId, long userId, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = findByPrimaryKey(demandId);

		Session session = null;

		try {
			session = openSession();

			CdsDemand[] array = new CdsDemandImpl[3];

			array[0] = getByUserId_Head_PrevAndNext(
				session, cdsDemand, userId, head, orderByComparator, true);

			array[1] = cdsDemand;

			array[2] = getByUserId_Head_PrevAndNext(
				session, cdsDemand, userId, head, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CdsDemand getByUserId_Head_PrevAndNext(
		Session session, CdsDemand cdsDemand, long userId, boolean head,
		OrderByComparator<CdsDemand> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

		sb.append(_FINDER_COLUMN_USERID_HEAD_USERID_2);

		sb.append(_FINDER_COLUMN_USERID_HEAD_HEAD_2);

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
			sb.append(CdsDemandModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		queryPos.add(head);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(cdsDemand)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CdsDemand> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cds demands where userId = &#63; and head = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param head the head
	 */
	@Override
	public void removeByUserId_Head(long userId, boolean head) {
		for (CdsDemand cdsDemand :
				findByUserId_Head(
					userId, head, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cdsDemand);
		}
	}

	/**
	 * Returns the number of cds demands where userId = &#63; and head = &#63;.
	 *
	 * @param userId the user ID
	 * @param head the head
	 * @return the number of matching cds demands
	 */
	@Override
	public int countByUserId_Head(long userId, boolean head) {
		FinderPath finderPath = _finderPathCountByUserId_Head;

		Object[] finderArgs = new Object[] {userId, head};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CDSDEMAND_WHERE);

			sb.append(_FINDER_COLUMN_USERID_HEAD_USERID_2);

			sb.append(_FINDER_COLUMN_USERID_HEAD_HEAD_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_HEAD_USERID_2 =
		"cdsDemand.userId = ? AND ";

	private static final String _FINDER_COLUMN_USERID_HEAD_HEAD_2 =
		"cdsDemand.head = ?";

	private FinderPath _finderPathWithPaginationFindByXid;
	private FinderPath _finderPathWithoutPaginationFindByXid;
	private FinderPath _finderPathCountByXid;

	/**
	 * Returns all the cds demands where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cds demands
	 */
	@Override
	public List<CdsDemand> findByXid(String uuid) {
		return findByXid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demands where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByXid(String uuid, int start, int end) {
		return findByXid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByXid(
		String uuid, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return findByXid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demands where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByXid(
		String uuid, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
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

		List<CdsDemand> list = null;

		if (useFinderCache) {
			list = (List<CdsDemand>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemand cdsDemand : list) {
					if (!uuid.equals(cdsDemand.getUuid())) {
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

			sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

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
				sb.append(CdsDemandModelImpl.ORDER_BY_JPQL);
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

				list = (List<CdsDemand>)QueryUtil.list(
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
	 * Returns the first cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand findByXid_First(
			String uuid, OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = fetchByXid_First(uuid, orderByComparator);

		if (cdsDemand != null) {
			return cdsDemand;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCdsDemandException(sb.toString());
	}

	/**
	 * Returns the first cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByXid_First(
		String uuid, OrderByComparator<CdsDemand> orderByComparator) {

		List<CdsDemand> list = findByXid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand findByXid_Last(
			String uuid, OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = fetchByXid_Last(uuid, orderByComparator);

		if (cdsDemand != null) {
			return cdsDemand;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCdsDemandException(sb.toString());
	}

	/**
	 * Returns the last cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByXid_Last(
		String uuid, OrderByComparator<CdsDemand> orderByComparator) {

		int count = countByXid(uuid);

		if (count == 0) {
			return null;
		}

		List<CdsDemand> list = findByXid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where uuid = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	@Override
	public CdsDemand[] findByXid_PrevAndNext(
			long demandId, String uuid,
			OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		uuid = Objects.toString(uuid, "");

		CdsDemand cdsDemand = findByPrimaryKey(demandId);

		Session session = null;

		try {
			session = openSession();

			CdsDemand[] array = new CdsDemandImpl[3];

			array[0] = getByXid_PrevAndNext(
				session, cdsDemand, uuid, orderByComparator, true);

			array[1] = cdsDemand;

			array[2] = getByXid_PrevAndNext(
				session, cdsDemand, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CdsDemand getByXid_PrevAndNext(
		Session session, CdsDemand cdsDemand, String uuid,
		OrderByComparator<CdsDemand> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

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
			sb.append(CdsDemandModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(cdsDemand)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CdsDemand> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cds demands where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByXid(String uuid) {
		for (CdsDemand cdsDemand :
				findByXid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cdsDemand);
		}
	}

	/**
	 * Returns the number of cds demands where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cds demands
	 */
	@Override
	public int countByXid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByXid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CDSDEMAND_WHERE);

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
		"cdsDemand.uuid = ?";

	private static final String _FINDER_COLUMN_XID_UUID_3 =
		"(cdsDemand.uuid IS NULL OR cdsDemand.uuid = '')";

	private FinderPath _finderPathFetchByXid_Head;
	private FinderPath _finderPathCountByXid_Head;

	/**
	 * Returns the cds demand where uuid = &#63; and head = &#63; or throws a <code>NoSuchCdsDemandException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand findByXid_Head(String uuid, boolean head)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = fetchByXid_Head(uuid, head);

		if (cdsDemand == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", head=");
			sb.append(head);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCdsDemandException(sb.toString());
		}

		return cdsDemand;
	}

	/**
	 * Returns the cds demand where uuid = &#63; and head = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByXid_Head(String uuid, boolean head) {
		return fetchByXid_Head(uuid, head, true);
	}

	/**
	 * Returns the cds demand where uuid = &#63; and head = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByXid_Head(
		String uuid, boolean head, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, head};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByXid_Head, finderArgs);
		}

		if (result instanceof CdsDemand) {
			CdsDemand cdsDemand = (CdsDemand)result;

			if (!Objects.equals(uuid, cdsDemand.getUuid()) ||
				(head != cdsDemand.isHead())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_XID_HEAD_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_XID_HEAD_UUID_2);
			}

			sb.append(_FINDER_COLUMN_XID_HEAD_HEAD_2);

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

				List<CdsDemand> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByXid_Head, finderArgs, list);
					}
				}
				else {
					CdsDemand cdsDemand = list.get(0);

					result = cdsDemand;

					cacheResult(cdsDemand);
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
			return (CdsDemand)result;
		}
	}

	/**
	 * Removes the cds demand where uuid = &#63; and head = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the cds demand that was removed
	 */
	@Override
	public CdsDemand removeByXid_Head(String uuid, boolean head)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = findByXid_Head(uuid, head);

		return remove(cdsDemand);
	}

	/**
	 * Returns the number of cds demands where uuid = &#63; and head = &#63;.
	 *
	 * @param uuid the uuid
	 * @param head the head
	 * @return the number of matching cds demands
	 */
	@Override
	public int countByXid_Head(String uuid, boolean head) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByXid_Head;

		Object[] finderArgs = new Object[] {uuid, head};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CDSDEMAND_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_XID_HEAD_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_XID_HEAD_UUID_2);
			}

			sb.append(_FINDER_COLUMN_XID_HEAD_HEAD_2);

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

	private static final String _FINDER_COLUMN_XID_HEAD_UUID_2 =
		"cdsDemand.uuid = ? AND ";

	private static final String _FINDER_COLUMN_XID_HEAD_UUID_3 =
		"(cdsDemand.uuid IS NULL OR cdsDemand.uuid = '') AND ";

	private static final String _FINDER_COLUMN_XID_HEAD_HEAD_2 =
		"cdsDemand.head = ?";

	private FinderPath _finderPathWithPaginationFindByDI;
	private FinderPath _finderPathWithoutPaginationFindByDI;
	private FinderPath _finderPathCountByDI;
	private FinderPath _finderPathWithPaginationCountByDI;

	/**
	 * Returns all the cds demands where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @return the matching cds demands
	 */
	@Override
	public List<CdsDemand> findByDI(long domainId) {
		return findByDI(domainId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demands where domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByDI(long domainId, int start, int end) {
		return findByDI(domainId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demands where domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByDI(
		long domainId, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return findByDI(domainId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demands where domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByDI(
		long domainId, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
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

		List<CdsDemand> list = null;

		if (useFinderCache) {
			list = (List<CdsDemand>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemand cdsDemand : list) {
					if (domainId != cdsDemand.getDomainId()) {
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

			sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

			sb.append(_FINDER_COLUMN_DI_DOMAINID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CdsDemandModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(domainId);

				list = (List<CdsDemand>)QueryUtil.list(
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
	 * Returns the first cds demand in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand findByDI_First(
			long domainId, OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = fetchByDI_First(domainId, orderByComparator);

		if (cdsDemand != null) {
			return cdsDemand;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("domainId=");
		sb.append(domainId);

		sb.append("}");

		throw new NoSuchCdsDemandException(sb.toString());
	}

	/**
	 * Returns the first cds demand in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByDI_First(
		long domainId, OrderByComparator<CdsDemand> orderByComparator) {

		List<CdsDemand> list = findByDI(domainId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cds demand in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand findByDI_Last(
			long domainId, OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = fetchByDI_Last(domainId, orderByComparator);

		if (cdsDemand != null) {
			return cdsDemand;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("domainId=");
		sb.append(domainId);

		sb.append("}");

		throw new NoSuchCdsDemandException(sb.toString());
	}

	/**
	 * Returns the last cds demand in the ordered set where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByDI_Last(
		long domainId, OrderByComparator<CdsDemand> orderByComparator) {

		int count = countByDI(domainId);

		if (count == 0) {
			return null;
		}

		List<CdsDemand> list = findByDI(
			domainId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where domainId = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	@Override
	public CdsDemand[] findByDI_PrevAndNext(
			long demandId, long domainId,
			OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = findByPrimaryKey(demandId);

		Session session = null;

		try {
			session = openSession();

			CdsDemand[] array = new CdsDemandImpl[3];

			array[0] = getByDI_PrevAndNext(
				session, cdsDemand, domainId, orderByComparator, true);

			array[1] = cdsDemand;

			array[2] = getByDI_PrevAndNext(
				session, cdsDemand, domainId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CdsDemand getByDI_PrevAndNext(
		Session session, CdsDemand cdsDemand, long domainId,
		OrderByComparator<CdsDemand> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

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
			sb.append(CdsDemandModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(domainId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(cdsDemand)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CdsDemand> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the cds demands where domainId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainIds the domain IDs
	 * @return the matching cds demands
	 */
	@Override
	public List<CdsDemand> findByDI(long[] domainIds) {
		return findByDI(domainIds, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demands where domainId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainIds the domain IDs
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByDI(long[] domainIds, int start, int end) {
		return findByDI(domainIds, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demands where domainId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainIds the domain IDs
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByDI(
		long[] domainIds, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return findByDI(domainIds, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demands where domainId = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByDI(
		long[] domainIds, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
		boolean useFinderCache) {

		if (domainIds == null) {
			domainIds = new long[0];
		}
		else if (domainIds.length > 1) {
			domainIds = ArrayUtil.sortedUnique(domainIds);
		}

		if (domainIds.length == 1) {
			return findByDI(domainIds[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {StringUtil.merge(domainIds)};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				StringUtil.merge(domainIds), start, end, orderByComparator
			};
		}

		List<CdsDemand> list = null;

		if (useFinderCache) {
			list = (List<CdsDemand>)finderCache.getResult(
				_finderPathWithPaginationFindByDI, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemand cdsDemand : list) {
					if (!ArrayUtil.contains(
							domainIds, cdsDemand.getDomainId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

			if (domainIds.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_DI_DOMAINID_7);

				sb.append(StringUtil.merge(domainIds));

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
				sb.append(CdsDemandModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CdsDemand>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByDI, finderArgs, list);
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
	 * Removes all the cds demands where domainId = &#63; from the database.
	 *
	 * @param domainId the domain ID
	 */
	@Override
	public void removeByDI(long domainId) {
		for (CdsDemand cdsDemand :
				findByDI(
					domainId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cdsDemand);
		}
	}

	/**
	 * Returns the number of cds demands where domainId = &#63;.
	 *
	 * @param domainId the domain ID
	 * @return the number of matching cds demands
	 */
	@Override
	public int countByDI(long domainId) {
		FinderPath finderPath = _finderPathCountByDI;

		Object[] finderArgs = new Object[] {domainId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CDSDEMAND_WHERE);

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

	/**
	 * Returns the number of cds demands where domainId = any &#63;.
	 *
	 * @param domainIds the domain IDs
	 * @return the number of matching cds demands
	 */
	@Override
	public int countByDI(long[] domainIds) {
		if (domainIds == null) {
			domainIds = new long[0];
		}
		else if (domainIds.length > 1) {
			domainIds = ArrayUtil.sortedUnique(domainIds);
		}

		Object[] finderArgs = new Object[] {StringUtil.merge(domainIds)};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByDI, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_CDSDEMAND_WHERE);

			if (domainIds.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_DI_DOMAINID_7);

				sb.append(StringUtil.merge(domainIds));

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

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByDI, finderArgs, count);
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
		"cdsDemand.domainId = ?";

	private static final String _FINDER_COLUMN_DI_DOMAINID_7 =
		"cdsDemand.domainId IN (";

	private FinderPath _finderPathWithPaginationFindByDI_Head;
	private FinderPath _finderPathWithoutPaginationFindByDI_Head;
	private FinderPath _finderPathCountByDI_Head;
	private FinderPath _finderPathWithPaginationCountByDI_Head;

	/**
	 * Returns all the cds demands where domainId = &#63; and head = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @return the matching cds demands
	 */
	@Override
	public List<CdsDemand> findByDI_Head(long domainId, boolean head) {
		return findByDI_Head(
			domainId, head, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demands where domainId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByDI_Head(
		long domainId, boolean head, int start, int end) {

		return findByDI_Head(domainId, head, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demands where domainId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByDI_Head(
		long domainId, boolean head, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return findByDI_Head(
			domainId, head, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demands where domainId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByDI_Head(
		long domainId, boolean head, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDI_Head;
				finderArgs = new Object[] {domainId, head};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDI_Head;
			finderArgs = new Object[] {
				domainId, head, start, end, orderByComparator
			};
		}

		List<CdsDemand> list = null;

		if (useFinderCache) {
			list = (List<CdsDemand>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemand cdsDemand : list) {
					if ((domainId != cdsDemand.getDomainId()) ||
						(head != cdsDemand.isHead())) {

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

			sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

			sb.append(_FINDER_COLUMN_DI_HEAD_DOMAINID_2);

			sb.append(_FINDER_COLUMN_DI_HEAD_HEAD_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CdsDemandModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(domainId);

				queryPos.add(head);

				list = (List<CdsDemand>)QueryUtil.list(
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
	 * Returns the first cds demand in the ordered set where domainId = &#63; and head = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand findByDI_Head_First(
			long domainId, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = fetchByDI_Head_First(
			domainId, head, orderByComparator);

		if (cdsDemand != null) {
			return cdsDemand;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("domainId=");
		sb.append(domainId);

		sb.append(", head=");
		sb.append(head);

		sb.append("}");

		throw new NoSuchCdsDemandException(sb.toString());
	}

	/**
	 * Returns the first cds demand in the ordered set where domainId = &#63; and head = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByDI_Head_First(
		long domainId, boolean head,
		OrderByComparator<CdsDemand> orderByComparator) {

		List<CdsDemand> list = findByDI_Head(
			domainId, head, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cds demand in the ordered set where domainId = &#63; and head = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand findByDI_Head_Last(
			long domainId, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = fetchByDI_Head_Last(
			domainId, head, orderByComparator);

		if (cdsDemand != null) {
			return cdsDemand;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("domainId=");
		sb.append(domainId);

		sb.append(", head=");
		sb.append(head);

		sb.append("}");

		throw new NoSuchCdsDemandException(sb.toString());
	}

	/**
	 * Returns the last cds demand in the ordered set where domainId = &#63; and head = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByDI_Head_Last(
		long domainId, boolean head,
		OrderByComparator<CdsDemand> orderByComparator) {

		int count = countByDI_Head(domainId, head);

		if (count == 0) {
			return null;
		}

		List<CdsDemand> list = findByDI_Head(
			domainId, head, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cds demands before and after the current cds demand in the ordered set where domainId = &#63; and head = &#63;.
	 *
	 * @param demandId the primary key of the current cds demand
	 * @param domainId the domain ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	@Override
	public CdsDemand[] findByDI_Head_PrevAndNext(
			long demandId, long domainId, boolean head,
			OrderByComparator<CdsDemand> orderByComparator)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = findByPrimaryKey(demandId);

		Session session = null;

		try {
			session = openSession();

			CdsDemand[] array = new CdsDemandImpl[3];

			array[0] = getByDI_Head_PrevAndNext(
				session, cdsDemand, domainId, head, orderByComparator, true);

			array[1] = cdsDemand;

			array[2] = getByDI_Head_PrevAndNext(
				session, cdsDemand, domainId, head, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CdsDemand getByDI_Head_PrevAndNext(
		Session session, CdsDemand cdsDemand, long domainId, boolean head,
		OrderByComparator<CdsDemand> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

		sb.append(_FINDER_COLUMN_DI_HEAD_DOMAINID_2);

		sb.append(_FINDER_COLUMN_DI_HEAD_HEAD_2);

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
			sb.append(CdsDemandModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(domainId);

		queryPos.add(head);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(cdsDemand)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CdsDemand> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the cds demands where domainId = any &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainIds the domain IDs
	 * @param head the head
	 * @return the matching cds demands
	 */
	@Override
	public List<CdsDemand> findByDI_Head(long[] domainIds, boolean head) {
		return findByDI_Head(
			domainIds, head, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demands where domainId = any &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainIds the domain IDs
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByDI_Head(
		long[] domainIds, boolean head, int start, int end) {

		return findByDI_Head(domainIds, head, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demands where domainId = any &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainIds the domain IDs
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByDI_Head(
		long[] domainIds, boolean head, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator) {

		return findByDI_Head(
			domainIds, head, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demands where domainId = &#63; and head = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demands
	 */
	@Override
	public List<CdsDemand> findByDI_Head(
		long[] domainIds, boolean head, int start, int end,
		OrderByComparator<CdsDemand> orderByComparator,
		boolean useFinderCache) {

		if (domainIds == null) {
			domainIds = new long[0];
		}
		else if (domainIds.length > 1) {
			domainIds = ArrayUtil.sortedUnique(domainIds);
		}

		if (domainIds.length == 1) {
			return findByDI_Head(
				domainIds[0], head, start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {StringUtil.merge(domainIds), head};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				StringUtil.merge(domainIds), head, start, end, orderByComparator
			};
		}

		List<CdsDemand> list = null;

		if (useFinderCache) {
			list = (List<CdsDemand>)finderCache.getResult(
				_finderPathWithPaginationFindByDI_Head, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemand cdsDemand : list) {
					if (!ArrayUtil.contains(
							domainIds, cdsDemand.getDomainId()) ||
						(head != cdsDemand.isHead())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

			if (domainIds.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_DI_HEAD_DOMAINID_7);

				sb.append(StringUtil.merge(domainIds));

				sb.append(")");

				sb.append(")");

				sb.append(WHERE_AND);
			}

			sb.append(_FINDER_COLUMN_DI_HEAD_HEAD_2);

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CdsDemandModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(head);

				list = (List<CdsDemand>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByDI_Head, finderArgs,
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
	 * Removes all the cds demands where domainId = &#63; and head = &#63; from the database.
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 */
	@Override
	public void removeByDI_Head(long domainId, boolean head) {
		for (CdsDemand cdsDemand :
				findByDI_Head(
					domainId, head, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(cdsDemand);
		}
	}

	/**
	 * Returns the number of cds demands where domainId = &#63; and head = &#63;.
	 *
	 * @param domainId the domain ID
	 * @param head the head
	 * @return the number of matching cds demands
	 */
	@Override
	public int countByDI_Head(long domainId, boolean head) {
		FinderPath finderPath = _finderPathCountByDI_Head;

		Object[] finderArgs = new Object[] {domainId, head};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CDSDEMAND_WHERE);

			sb.append(_FINDER_COLUMN_DI_HEAD_DOMAINID_2);

			sb.append(_FINDER_COLUMN_DI_HEAD_HEAD_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(domainId);

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
	 * Returns the number of cds demands where domainId = any &#63; and head = &#63;.
	 *
	 * @param domainIds the domain IDs
	 * @param head the head
	 * @return the number of matching cds demands
	 */
	@Override
	public int countByDI_Head(long[] domainIds, boolean head) {
		if (domainIds == null) {
			domainIds = new long[0];
		}
		else if (domainIds.length > 1) {
			domainIds = ArrayUtil.sortedUnique(domainIds);
		}

		Object[] finderArgs = new Object[] {StringUtil.merge(domainIds), head};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByDI_Head, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_CDSDEMAND_WHERE);

			if (domainIds.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_DI_HEAD_DOMAINID_7);

				sb.append(StringUtil.merge(domainIds));

				sb.append(")");

				sb.append(")");

				sb.append(WHERE_AND);
			}

			sb.append(_FINDER_COLUMN_DI_HEAD_HEAD_2);

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(head);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByDI_Head, finderArgs, count);
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

	private static final String _FINDER_COLUMN_DI_HEAD_DOMAINID_2 =
		"cdsDemand.domainId = ? AND ";

	private static final String _FINDER_COLUMN_DI_HEAD_DOMAINID_7 =
		"cdsDemand.domainId IN (";

	private static final String _FINDER_COLUMN_DI_HEAD_HEAD_2 =
		"cdsDemand.head = ?";

	private FinderPath _finderPathFetchByHeadId;
	private FinderPath _finderPathCountByHeadId;

	/**
	 * Returns the cds demand where headId = &#63; or throws a <code>NoSuchCdsDemandException</code> if it could not be found.
	 *
	 * @param headId the head ID
	 * @return the matching cds demand
	 * @throws NoSuchCdsDemandException if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand findByHeadId(long headId) throws NoSuchCdsDemandException {
		CdsDemand cdsDemand = fetchByHeadId(headId);

		if (cdsDemand == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("headId=");
			sb.append(headId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCdsDemandException(sb.toString());
		}

		return cdsDemand;
	}

	/**
	 * Returns the cds demand where headId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param headId the head ID
	 * @return the matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByHeadId(long headId) {
		return fetchByHeadId(headId, true);
	}

	/**
	 * Returns the cds demand where headId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param headId the head ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cds demand, or <code>null</code> if a matching cds demand could not be found
	 */
	@Override
	public CdsDemand fetchByHeadId(long headId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {headId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByHeadId, finderArgs);
		}

		if (result instanceof CdsDemand) {
			CdsDemand cdsDemand = (CdsDemand)result;

			if (headId != cdsDemand.getHeadId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CDSDEMAND_WHERE);

			sb.append(_FINDER_COLUMN_HEADID_HEADID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(headId);

				List<CdsDemand> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByHeadId, finderArgs, list);
					}
				}
				else {
					CdsDemand cdsDemand = list.get(0);

					result = cdsDemand;

					cacheResult(cdsDemand);
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
			return (CdsDemand)result;
		}
	}

	/**
	 * Removes the cds demand where headId = &#63; from the database.
	 *
	 * @param headId the head ID
	 * @return the cds demand that was removed
	 */
	@Override
	public CdsDemand removeByHeadId(long headId)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = findByHeadId(headId);

		return remove(cdsDemand);
	}

	/**
	 * Returns the number of cds demands where headId = &#63;.
	 *
	 * @param headId the head ID
	 * @return the number of matching cds demands
	 */
	@Override
	public int countByHeadId(long headId) {
		FinderPath finderPath = _finderPathCountByHeadId;

		Object[] finderArgs = new Object[] {headId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CDSDEMAND_WHERE);

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
		"cdsDemand.headId = ?";

	public CdsDemandPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");
		dbColumnNames.put("state", "state_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CdsDemand.class);

		setModelImplClass(CdsDemandImpl.class);
		setModelPKClass(long.class);

		setTable(CdsDemandTable.INSTANCE);
	}

	/**
	 * Caches the cds demand in the entity cache if it is enabled.
	 *
	 * @param cdsDemand the cds demand
	 */
	@Override
	public void cacheResult(CdsDemand cdsDemand) {
		entityCache.putResult(
			CdsDemandImpl.class, cdsDemand.getPrimaryKey(), cdsDemand);

		finderCache.putResult(
			_finderPathFetchByUUID_G_Head,
			new Object[] {
				cdsDemand.getUuid(), cdsDemand.getGroupId(), cdsDemand.isHead()
			},
			cdsDemand);

		finderCache.putResult(
			_finderPathFetchByXid_Head,
			new Object[] {cdsDemand.getUuid(), cdsDemand.isHead()}, cdsDemand);

		finderCache.putResult(
			_finderPathFetchByHeadId, new Object[] {cdsDemand.getHeadId()},
			cdsDemand);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the cds demands in the entity cache if it is enabled.
	 *
	 * @param cdsDemands the cds demands
	 */
	@Override
	public void cacheResult(List<CdsDemand> cdsDemands) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (cdsDemands.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CdsDemand cdsDemand : cdsDemands) {
			if (entityCache.getResult(
					CdsDemandImpl.class, cdsDemand.getPrimaryKey()) == null) {

				cacheResult(cdsDemand);
			}
		}
	}

	/**
	 * Clears the cache for all cds demands.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CdsDemandImpl.class);

		finderCache.clearCache(CdsDemandImpl.class);
	}

	/**
	 * Clears the cache for the cds demand.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CdsDemand cdsDemand) {
		entityCache.removeResult(CdsDemandImpl.class, cdsDemand);
	}

	@Override
	public void clearCache(List<CdsDemand> cdsDemands) {
		for (CdsDemand cdsDemand : cdsDemands) {
			entityCache.removeResult(CdsDemandImpl.class, cdsDemand);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CdsDemandImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CdsDemandImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CdsDemandModelImpl cdsDemandModelImpl) {

		Object[] args = new Object[] {
			cdsDemandModelImpl.getUuid(), cdsDemandModelImpl.getGroupId(),
			cdsDemandModelImpl.isHead()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G_Head, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G_Head, args, cdsDemandModelImpl);

		args = new Object[] {
			cdsDemandModelImpl.getUuid(), cdsDemandModelImpl.isHead()
		};

		finderCache.putResult(
			_finderPathCountByXid_Head, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByXid_Head, args, cdsDemandModelImpl);

		args = new Object[] {cdsDemandModelImpl.getHeadId()};

		finderCache.putResult(_finderPathCountByHeadId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByHeadId, args, cdsDemandModelImpl);
	}

	/**
	 * Creates a new cds demand with the primary key. Does not add the cds demand to the database.
	 *
	 * @param demandId the primary key for the new cds demand
	 * @return the new cds demand
	 */
	@Override
	public CdsDemand create(long demandId) {
		CdsDemand cdsDemand = new CdsDemandImpl();

		cdsDemand.setNew(true);
		cdsDemand.setPrimaryKey(demandId);

		String uuid = _portalUUID.generate();

		cdsDemand.setUuid(uuid);

		cdsDemand.setCompanyId(CompanyThreadLocal.getCompanyId());

		return cdsDemand;
	}

	/**
	 * Removes the cds demand with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param demandId the primary key of the cds demand
	 * @return the cds demand that was removed
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	@Override
	public CdsDemand remove(long demandId) throws NoSuchCdsDemandException {
		return remove((Serializable)demandId);
	}

	/**
	 * Removes the cds demand with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cds demand
	 * @return the cds demand that was removed
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	@Override
	public CdsDemand remove(Serializable primaryKey)
		throws NoSuchCdsDemandException {

		Session session = null;

		try {
			session = openSession();

			CdsDemand cdsDemand = (CdsDemand)session.get(
				CdsDemandImpl.class, primaryKey);

			if (cdsDemand == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCdsDemandException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(cdsDemand);
		}
		catch (NoSuchCdsDemandException noSuchEntityException) {
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
	protected CdsDemand removeImpl(CdsDemand cdsDemand) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cdsDemand)) {
				cdsDemand = (CdsDemand)session.get(
					CdsDemandImpl.class, cdsDemand.getPrimaryKeyObj());
			}

			if (cdsDemand != null) {
				session.delete(cdsDemand);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (cdsDemand != null) {
			clearCache(cdsDemand);
		}

		return cdsDemand;
	}

	@Override
	public CdsDemand updateImpl(CdsDemand cdsDemand) {
		boolean isNew = cdsDemand.isNew();

		if (!(cdsDemand instanceof CdsDemandModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(cdsDemand.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(cdsDemand);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in cdsDemand proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CdsDemand implementation " +
					cdsDemand.getClass());
		}

		CdsDemandModelImpl cdsDemandModelImpl = (CdsDemandModelImpl)cdsDemand;

		if (Validator.isNull(cdsDemand.getUuid())) {
			String uuid = _portalUUID.generate();

			cdsDemand.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (cdsDemand.getCreateDate() == null)) {
			if (serviceContext == null) {
				cdsDemand.setCreateDate(date);
			}
			else {
				cdsDemand.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!cdsDemandModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				cdsDemand.setModifiedDate(date);
			}
			else {
				cdsDemand.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(cdsDemand);
			}
			else {
				cdsDemand = (CdsDemand)session.merge(cdsDemand);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CdsDemandImpl.class, cdsDemandModelImpl, false, true);

		cacheUniqueFindersCache(cdsDemandModelImpl);

		if (isNew) {
			cdsDemand.setNew(false);
		}

		cdsDemand.resetOriginalValues();

		return cdsDemand;
	}

	/**
	 * Returns the cds demand with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cds demand
	 * @return the cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	@Override
	public CdsDemand findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCdsDemandException {

		CdsDemand cdsDemand = fetchByPrimaryKey(primaryKey);

		if (cdsDemand == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCdsDemandException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return cdsDemand;
	}

	/**
	 * Returns the cds demand with the primary key or throws a <code>NoSuchCdsDemandException</code> if it could not be found.
	 *
	 * @param demandId the primary key of the cds demand
	 * @return the cds demand
	 * @throws NoSuchCdsDemandException if a cds demand with the primary key could not be found
	 */
	@Override
	public CdsDemand findByPrimaryKey(long demandId)
		throws NoSuchCdsDemandException {

		return findByPrimaryKey((Serializable)demandId);
	}

	/**
	 * Returns the cds demand with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param demandId the primary key of the cds demand
	 * @return the cds demand, or <code>null</code> if a cds demand with the primary key could not be found
	 */
	@Override
	public CdsDemand fetchByPrimaryKey(long demandId) {
		return fetchByPrimaryKey((Serializable)demandId);
	}

	/**
	 * Returns all the cds demands.
	 *
	 * @return the cds demands
	 */
	@Override
	public List<CdsDemand> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demands.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @return the range of cds demands
	 */
	@Override
	public List<CdsDemand> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demands.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cds demands
	 */
	@Override
	public List<CdsDemand> findAll(
		int start, int end, OrderByComparator<CdsDemand> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demands.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cds demands
	 * @param end the upper bound of the range of cds demands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cds demands
	 */
	@Override
	public List<CdsDemand> findAll(
		int start, int end, OrderByComparator<CdsDemand> orderByComparator,
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

		List<CdsDemand> list = null;

		if (useFinderCache) {
			list = (List<CdsDemand>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CDSDEMAND);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CDSDEMAND;

				sql = sql.concat(CdsDemandModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CdsDemand>)QueryUtil.list(
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
	 * Removes all the cds demands from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CdsDemand cdsDemand : findAll()) {
			remove(cdsDemand);
		}
	}

	/**
	 * Returns the number of cds demands.
	 *
	 * @return the number of cds demands
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CDSDEMAND);

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
		return "demandId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CDSDEMAND;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CdsDemandModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cds demand persistence.
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

		_finderPathWithPaginationFindByUserId_Head = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId_Head",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"userId", "head"}, true);

		_finderPathWithoutPaginationFindByUserId_Head = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId_Head",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"userId", "head"}, true);

		_finderPathCountByUserId_Head = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId_Head",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"userId", "head"}, false);

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

		_finderPathFetchByXid_Head = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByXid_Head",
			new String[] {String.class.getName(), Boolean.class.getName()},
			new String[] {"uuid_", "head"}, true);

		_finderPathCountByXid_Head = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByXid_Head",
			new String[] {String.class.getName(), Boolean.class.getName()},
			new String[] {"uuid_", "head"}, false);

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

		_finderPathWithPaginationCountByDI = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByDI",
			new String[] {Long.class.getName()}, new String[] {"domainId"},
			false);

		_finderPathWithPaginationFindByDI_Head = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDI_Head",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"domainId", "head"}, true);

		_finderPathWithoutPaginationFindByDI_Head = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDI_Head",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"domainId", "head"}, true);

		_finderPathCountByDI_Head = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDI_Head",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"domainId", "head"}, false);

		_finderPathWithPaginationCountByDI_Head = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByDI_Head",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"domainId", "head"}, false);

		_finderPathFetchByHeadId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByHeadId",
			new String[] {Long.class.getName()}, new String[] {"headId"}, true);

		_finderPathCountByHeadId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHeadId",
			new String[] {Long.class.getName()}, new String[] {"headId"},
			false);

		_setCdsDemandUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCdsDemandUtilPersistence(null);

		entityCache.removeCache(CdsDemandImpl.class.getName());
	}

	private void _setCdsDemandUtilPersistence(
		CdsDemandPersistence cdsDemandPersistence) {

		try {
			Field field = CdsDemandUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, cdsDemandPersistence);
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

	private static final String _SQL_SELECT_CDSDEMAND =
		"SELECT cdsDemand FROM CdsDemand cdsDemand";

	private static final String _SQL_SELECT_CDSDEMAND_WHERE =
		"SELECT cdsDemand FROM CdsDemand cdsDemand WHERE ";

	private static final String _SQL_COUNT_CDSDEMAND =
		"SELECT COUNT(cdsDemand) FROM CdsDemand cdsDemand";

	private static final String _SQL_COUNT_CDSDEMAND_WHERE =
		"SELECT COUNT(cdsDemand) FROM CdsDemand cdsDemand WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "cdsDemand.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CdsDemand exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CdsDemand exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CdsDemandPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type", "state"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private CdsDemandModelArgumentsResolver _cdsDemandModelArgumentsResolver;

}