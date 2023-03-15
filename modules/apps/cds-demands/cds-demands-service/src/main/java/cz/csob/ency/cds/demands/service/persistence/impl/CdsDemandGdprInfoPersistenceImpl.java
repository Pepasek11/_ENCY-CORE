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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import cz.csob.ency.cds.demands.exception.NoSuchCdsDemandGdprInfoException;
import cz.csob.ency.cds.demands.model.CdsDemandGdprInfo;
import cz.csob.ency.cds.demands.model.CdsDemandGdprInfoTable;
import cz.csob.ency.cds.demands.model.impl.CdsDemandGdprInfoImpl;
import cz.csob.ency.cds.demands.model.impl.CdsDemandGdprInfoModelImpl;
import cz.csob.ency.cds.demands.service.persistence.CdsDemandGdprInfoPersistence;
import cz.csob.ency.cds.demands.service.persistence.CdsDemandGdprInfoUtil;
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
 * The persistence implementation for the cds demand gdpr info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @generated
 */
@Component(
	service = {CdsDemandGdprInfoPersistence.class, BasePersistence.class}
)
public class CdsDemandGdprInfoPersistenceImpl
	extends BasePersistenceImpl<CdsDemandGdprInfo>
	implements CdsDemandGdprInfoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CdsDemandGdprInfoUtil</code> to access the cds demand gdpr info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CdsDemandGdprInfoImpl.class.getName();

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
	 * Returns all the cds demand gdpr infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cds demand gdpr infos
	 */
	@Override
	public List<CdsDemandGdprInfo> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demand gdpr infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandGdprInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demand gdpr infos
	 * @param end the upper bound of the range of cds demand gdpr infos (not inclusive)
	 * @return the range of matching cds demand gdpr infos
	 */
	@Override
	public List<CdsDemandGdprInfo> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demand gdpr infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandGdprInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demand gdpr infos
	 * @param end the upper bound of the range of cds demand gdpr infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand gdpr infos
	 */
	@Override
	public List<CdsDemandGdprInfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CdsDemandGdprInfo> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demand gdpr infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandGdprInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cds demand gdpr infos
	 * @param end the upper bound of the range of cds demand gdpr infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand gdpr infos
	 */
	@Override
	public List<CdsDemandGdprInfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CdsDemandGdprInfo> orderByComparator,
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

		List<CdsDemandGdprInfo> list = null;

		if (useFinderCache) {
			list = (List<CdsDemandGdprInfo>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemandGdprInfo cdsDemandGdprInfo : list) {
					if (!uuid.equals(cdsDemandGdprInfo.getUuid())) {
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

			sb.append(_SQL_SELECT_CDSDEMANDGDPRINFO_WHERE);

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
				sb.append(CdsDemandGdprInfoModelImpl.ORDER_BY_JPQL);
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

				list = (List<CdsDemandGdprInfo>)QueryUtil.list(
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
	 * Returns the first cds demand gdpr info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand gdpr info
	 * @throws NoSuchCdsDemandGdprInfoException if a matching cds demand gdpr info could not be found
	 */
	@Override
	public CdsDemandGdprInfo findByUuid_First(
			String uuid, OrderByComparator<CdsDemandGdprInfo> orderByComparator)
		throws NoSuchCdsDemandGdprInfoException {

		CdsDemandGdprInfo cdsDemandGdprInfo = fetchByUuid_First(
			uuid, orderByComparator);

		if (cdsDemandGdprInfo != null) {
			return cdsDemandGdprInfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCdsDemandGdprInfoException(sb.toString());
	}

	/**
	 * Returns the first cds demand gdpr info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand gdpr info, or <code>null</code> if a matching cds demand gdpr info could not be found
	 */
	@Override
	public CdsDemandGdprInfo fetchByUuid_First(
		String uuid, OrderByComparator<CdsDemandGdprInfo> orderByComparator) {

		List<CdsDemandGdprInfo> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cds demand gdpr info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand gdpr info
	 * @throws NoSuchCdsDemandGdprInfoException if a matching cds demand gdpr info could not be found
	 */
	@Override
	public CdsDemandGdprInfo findByUuid_Last(
			String uuid, OrderByComparator<CdsDemandGdprInfo> orderByComparator)
		throws NoSuchCdsDemandGdprInfoException {

		CdsDemandGdprInfo cdsDemandGdprInfo = fetchByUuid_Last(
			uuid, orderByComparator);

		if (cdsDemandGdprInfo != null) {
			return cdsDemandGdprInfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCdsDemandGdprInfoException(sb.toString());
	}

	/**
	 * Returns the last cds demand gdpr info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand gdpr info, or <code>null</code> if a matching cds demand gdpr info could not be found
	 */
	@Override
	public CdsDemandGdprInfo fetchByUuid_Last(
		String uuid, OrderByComparator<CdsDemandGdprInfo> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CdsDemandGdprInfo> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cds demand gdpr infos before and after the current cds demand gdpr info in the ordered set where uuid = &#63;.
	 *
	 * @param gdprInfoId the primary key of the current cds demand gdpr info
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand gdpr info
	 * @throws NoSuchCdsDemandGdprInfoException if a cds demand gdpr info with the primary key could not be found
	 */
	@Override
	public CdsDemandGdprInfo[] findByUuid_PrevAndNext(
			long gdprInfoId, String uuid,
			OrderByComparator<CdsDemandGdprInfo> orderByComparator)
		throws NoSuchCdsDemandGdprInfoException {

		uuid = Objects.toString(uuid, "");

		CdsDemandGdprInfo cdsDemandGdprInfo = findByPrimaryKey(gdprInfoId);

		Session session = null;

		try {
			session = openSession();

			CdsDemandGdprInfo[] array = new CdsDemandGdprInfoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, cdsDemandGdprInfo, uuid, orderByComparator, true);

			array[1] = cdsDemandGdprInfo;

			array[2] = getByUuid_PrevAndNext(
				session, cdsDemandGdprInfo, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CdsDemandGdprInfo getByUuid_PrevAndNext(
		Session session, CdsDemandGdprInfo cdsDemandGdprInfo, String uuid,
		OrderByComparator<CdsDemandGdprInfo> orderByComparator,
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

		sb.append(_SQL_SELECT_CDSDEMANDGDPRINFO_WHERE);

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
			sb.append(CdsDemandGdprInfoModelImpl.ORDER_BY_JPQL);
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
						cdsDemandGdprInfo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CdsDemandGdprInfo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cds demand gdpr infos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CdsDemandGdprInfo cdsDemandGdprInfo :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cdsDemandGdprInfo);
		}
	}

	/**
	 * Returns the number of cds demand gdpr infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cds demand gdpr infos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CDSDEMANDGDPRINFO_WHERE);

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
		"cdsDemandGdprInfo.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(cdsDemandGdprInfo.uuid IS NULL OR cdsDemandGdprInfo.uuid = '')";

	private FinderPath _finderPathWithPaginationFindBydemandId;
	private FinderPath _finderPathWithoutPaginationFindBydemandId;
	private FinderPath _finderPathCountBydemandId;

	/**
	 * Returns all the cds demand gdpr infos where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @return the matching cds demand gdpr infos
	 */
	@Override
	public List<CdsDemandGdprInfo> findBydemandId(long demandId) {
		return findBydemandId(
			demandId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demand gdpr infos where demandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandGdprInfoModelImpl</code>.
	 * </p>
	 *
	 * @param demandId the demand ID
	 * @param start the lower bound of the range of cds demand gdpr infos
	 * @param end the upper bound of the range of cds demand gdpr infos (not inclusive)
	 * @return the range of matching cds demand gdpr infos
	 */
	@Override
	public List<CdsDemandGdprInfo> findBydemandId(
		long demandId, int start, int end) {

		return findBydemandId(demandId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demand gdpr infos where demandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandGdprInfoModelImpl</code>.
	 * </p>
	 *
	 * @param demandId the demand ID
	 * @param start the lower bound of the range of cds demand gdpr infos
	 * @param end the upper bound of the range of cds demand gdpr infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cds demand gdpr infos
	 */
	@Override
	public List<CdsDemandGdprInfo> findBydemandId(
		long demandId, int start, int end,
		OrderByComparator<CdsDemandGdprInfo> orderByComparator) {

		return findBydemandId(demandId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demand gdpr infos where demandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandGdprInfoModelImpl</code>.
	 * </p>
	 *
	 * @param demandId the demand ID
	 * @param start the lower bound of the range of cds demand gdpr infos
	 * @param end the upper bound of the range of cds demand gdpr infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cds demand gdpr infos
	 */
	@Override
	public List<CdsDemandGdprInfo> findBydemandId(
		long demandId, int start, int end,
		OrderByComparator<CdsDemandGdprInfo> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBydemandId;
				finderArgs = new Object[] {demandId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBydemandId;
			finderArgs = new Object[] {demandId, start, end, orderByComparator};
		}

		List<CdsDemandGdprInfo> list = null;

		if (useFinderCache) {
			list = (List<CdsDemandGdprInfo>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CdsDemandGdprInfo cdsDemandGdprInfo : list) {
					if (demandId != cdsDemandGdprInfo.getDemandId()) {
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

			sb.append(_SQL_SELECT_CDSDEMANDGDPRINFO_WHERE);

			sb.append(_FINDER_COLUMN_DEMANDID_DEMANDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CdsDemandGdprInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(demandId);

				list = (List<CdsDemandGdprInfo>)QueryUtil.list(
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
	 * Returns the first cds demand gdpr info in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand gdpr info
	 * @throws NoSuchCdsDemandGdprInfoException if a matching cds demand gdpr info could not be found
	 */
	@Override
	public CdsDemandGdprInfo findBydemandId_First(
			long demandId,
			OrderByComparator<CdsDemandGdprInfo> orderByComparator)
		throws NoSuchCdsDemandGdprInfoException {

		CdsDemandGdprInfo cdsDemandGdprInfo = fetchBydemandId_First(
			demandId, orderByComparator);

		if (cdsDemandGdprInfo != null) {
			return cdsDemandGdprInfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("demandId=");
		sb.append(demandId);

		sb.append("}");

		throw new NoSuchCdsDemandGdprInfoException(sb.toString());
	}

	/**
	 * Returns the first cds demand gdpr info in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cds demand gdpr info, or <code>null</code> if a matching cds demand gdpr info could not be found
	 */
	@Override
	public CdsDemandGdprInfo fetchBydemandId_First(
		long demandId, OrderByComparator<CdsDemandGdprInfo> orderByComparator) {

		List<CdsDemandGdprInfo> list = findBydemandId(
			demandId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cds demand gdpr info in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand gdpr info
	 * @throws NoSuchCdsDemandGdprInfoException if a matching cds demand gdpr info could not be found
	 */
	@Override
	public CdsDemandGdprInfo findBydemandId_Last(
			long demandId,
			OrderByComparator<CdsDemandGdprInfo> orderByComparator)
		throws NoSuchCdsDemandGdprInfoException {

		CdsDemandGdprInfo cdsDemandGdprInfo = fetchBydemandId_Last(
			demandId, orderByComparator);

		if (cdsDemandGdprInfo != null) {
			return cdsDemandGdprInfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("demandId=");
		sb.append(demandId);

		sb.append("}");

		throw new NoSuchCdsDemandGdprInfoException(sb.toString());
	}

	/**
	 * Returns the last cds demand gdpr info in the ordered set where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cds demand gdpr info, or <code>null</code> if a matching cds demand gdpr info could not be found
	 */
	@Override
	public CdsDemandGdprInfo fetchBydemandId_Last(
		long demandId, OrderByComparator<CdsDemandGdprInfo> orderByComparator) {

		int count = countBydemandId(demandId);

		if (count == 0) {
			return null;
		}

		List<CdsDemandGdprInfo> list = findBydemandId(
			demandId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cds demand gdpr infos before and after the current cds demand gdpr info in the ordered set where demandId = &#63;.
	 *
	 * @param gdprInfoId the primary key of the current cds demand gdpr info
	 * @param demandId the demand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cds demand gdpr info
	 * @throws NoSuchCdsDemandGdprInfoException if a cds demand gdpr info with the primary key could not be found
	 */
	@Override
	public CdsDemandGdprInfo[] findBydemandId_PrevAndNext(
			long gdprInfoId, long demandId,
			OrderByComparator<CdsDemandGdprInfo> orderByComparator)
		throws NoSuchCdsDemandGdprInfoException {

		CdsDemandGdprInfo cdsDemandGdprInfo = findByPrimaryKey(gdprInfoId);

		Session session = null;

		try {
			session = openSession();

			CdsDemandGdprInfo[] array = new CdsDemandGdprInfoImpl[3];

			array[0] = getBydemandId_PrevAndNext(
				session, cdsDemandGdprInfo, demandId, orderByComparator, true);

			array[1] = cdsDemandGdprInfo;

			array[2] = getBydemandId_PrevAndNext(
				session, cdsDemandGdprInfo, demandId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CdsDemandGdprInfo getBydemandId_PrevAndNext(
		Session session, CdsDemandGdprInfo cdsDemandGdprInfo, long demandId,
		OrderByComparator<CdsDemandGdprInfo> orderByComparator,
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

		sb.append(_SQL_SELECT_CDSDEMANDGDPRINFO_WHERE);

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
			sb.append(CdsDemandGdprInfoModelImpl.ORDER_BY_JPQL);
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
						cdsDemandGdprInfo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CdsDemandGdprInfo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cds demand gdpr infos where demandId = &#63; from the database.
	 *
	 * @param demandId the demand ID
	 */
	@Override
	public void removeBydemandId(long demandId) {
		for (CdsDemandGdprInfo cdsDemandGdprInfo :
				findBydemandId(
					demandId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cdsDemandGdprInfo);
		}
	}

	/**
	 * Returns the number of cds demand gdpr infos where demandId = &#63;.
	 *
	 * @param demandId the demand ID
	 * @return the number of matching cds demand gdpr infos
	 */
	@Override
	public int countBydemandId(long demandId) {
		FinderPath finderPath = _finderPathCountBydemandId;

		Object[] finderArgs = new Object[] {demandId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CDSDEMANDGDPRINFO_WHERE);

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
		"cdsDemandGdprInfo.demandId = ?";

	public CdsDemandGdprInfoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CdsDemandGdprInfo.class);

		setModelImplClass(CdsDemandGdprInfoImpl.class);
		setModelPKClass(long.class);

		setTable(CdsDemandGdprInfoTable.INSTANCE);
	}

	/**
	 * Caches the cds demand gdpr info in the entity cache if it is enabled.
	 *
	 * @param cdsDemandGdprInfo the cds demand gdpr info
	 */
	@Override
	public void cacheResult(CdsDemandGdprInfo cdsDemandGdprInfo) {
		entityCache.putResult(
			CdsDemandGdprInfoImpl.class, cdsDemandGdprInfo.getPrimaryKey(),
			cdsDemandGdprInfo);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the cds demand gdpr infos in the entity cache if it is enabled.
	 *
	 * @param cdsDemandGdprInfos the cds demand gdpr infos
	 */
	@Override
	public void cacheResult(List<CdsDemandGdprInfo> cdsDemandGdprInfos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (cdsDemandGdprInfos.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CdsDemandGdprInfo cdsDemandGdprInfo : cdsDemandGdprInfos) {
			if (entityCache.getResult(
					CdsDemandGdprInfoImpl.class,
					cdsDemandGdprInfo.getPrimaryKey()) == null) {

				cacheResult(cdsDemandGdprInfo);
			}
		}
	}

	/**
	 * Clears the cache for all cds demand gdpr infos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CdsDemandGdprInfoImpl.class);

		finderCache.clearCache(CdsDemandGdprInfoImpl.class);
	}

	/**
	 * Clears the cache for the cds demand gdpr info.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CdsDemandGdprInfo cdsDemandGdprInfo) {
		entityCache.removeResult(
			CdsDemandGdprInfoImpl.class, cdsDemandGdprInfo);
	}

	@Override
	public void clearCache(List<CdsDemandGdprInfo> cdsDemandGdprInfos) {
		for (CdsDemandGdprInfo cdsDemandGdprInfo : cdsDemandGdprInfos) {
			entityCache.removeResult(
				CdsDemandGdprInfoImpl.class, cdsDemandGdprInfo);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CdsDemandGdprInfoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CdsDemandGdprInfoImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new cds demand gdpr info with the primary key. Does not add the cds demand gdpr info to the database.
	 *
	 * @param gdprInfoId the primary key for the new cds demand gdpr info
	 * @return the new cds demand gdpr info
	 */
	@Override
	public CdsDemandGdprInfo create(long gdprInfoId) {
		CdsDemandGdprInfo cdsDemandGdprInfo = new CdsDemandGdprInfoImpl();

		cdsDemandGdprInfo.setNew(true);
		cdsDemandGdprInfo.setPrimaryKey(gdprInfoId);

		String uuid = _portalUUID.generate();

		cdsDemandGdprInfo.setUuid(uuid);

		return cdsDemandGdprInfo;
	}

	/**
	 * Removes the cds demand gdpr info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gdprInfoId the primary key of the cds demand gdpr info
	 * @return the cds demand gdpr info that was removed
	 * @throws NoSuchCdsDemandGdprInfoException if a cds demand gdpr info with the primary key could not be found
	 */
	@Override
	public CdsDemandGdprInfo remove(long gdprInfoId)
		throws NoSuchCdsDemandGdprInfoException {

		return remove((Serializable)gdprInfoId);
	}

	/**
	 * Removes the cds demand gdpr info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cds demand gdpr info
	 * @return the cds demand gdpr info that was removed
	 * @throws NoSuchCdsDemandGdprInfoException if a cds demand gdpr info with the primary key could not be found
	 */
	@Override
	public CdsDemandGdprInfo remove(Serializable primaryKey)
		throws NoSuchCdsDemandGdprInfoException {

		Session session = null;

		try {
			session = openSession();

			CdsDemandGdprInfo cdsDemandGdprInfo =
				(CdsDemandGdprInfo)session.get(
					CdsDemandGdprInfoImpl.class, primaryKey);

			if (cdsDemandGdprInfo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCdsDemandGdprInfoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(cdsDemandGdprInfo);
		}
		catch (NoSuchCdsDemandGdprInfoException noSuchEntityException) {
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
	protected CdsDemandGdprInfo removeImpl(
		CdsDemandGdprInfo cdsDemandGdprInfo) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cdsDemandGdprInfo)) {
				cdsDemandGdprInfo = (CdsDemandGdprInfo)session.get(
					CdsDemandGdprInfoImpl.class,
					cdsDemandGdprInfo.getPrimaryKeyObj());
			}

			if (cdsDemandGdprInfo != null) {
				session.delete(cdsDemandGdprInfo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (cdsDemandGdprInfo != null) {
			clearCache(cdsDemandGdprInfo);
		}

		return cdsDemandGdprInfo;
	}

	@Override
	public CdsDemandGdprInfo updateImpl(CdsDemandGdprInfo cdsDemandGdprInfo) {
		boolean isNew = cdsDemandGdprInfo.isNew();

		if (!(cdsDemandGdprInfo instanceof CdsDemandGdprInfoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(cdsDemandGdprInfo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					cdsDemandGdprInfo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in cdsDemandGdprInfo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CdsDemandGdprInfo implementation " +
					cdsDemandGdprInfo.getClass());
		}

		CdsDemandGdprInfoModelImpl cdsDemandGdprInfoModelImpl =
			(CdsDemandGdprInfoModelImpl)cdsDemandGdprInfo;

		if (Validator.isNull(cdsDemandGdprInfo.getUuid())) {
			String uuid = _portalUUID.generate();

			cdsDemandGdprInfo.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (cdsDemandGdprInfo.getCreateDate() == null)) {
			if (serviceContext == null) {
				cdsDemandGdprInfo.setCreateDate(date);
			}
			else {
				cdsDemandGdprInfo.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!cdsDemandGdprInfoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				cdsDemandGdprInfo.setModifiedDate(date);
			}
			else {
				cdsDemandGdprInfo.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(cdsDemandGdprInfo);
			}
			else {
				cdsDemandGdprInfo = (CdsDemandGdprInfo)session.merge(
					cdsDemandGdprInfo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CdsDemandGdprInfoImpl.class, cdsDemandGdprInfoModelImpl, false,
			true);

		if (isNew) {
			cdsDemandGdprInfo.setNew(false);
		}

		cdsDemandGdprInfo.resetOriginalValues();

		return cdsDemandGdprInfo;
	}

	/**
	 * Returns the cds demand gdpr info with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cds demand gdpr info
	 * @return the cds demand gdpr info
	 * @throws NoSuchCdsDemandGdprInfoException if a cds demand gdpr info with the primary key could not be found
	 */
	@Override
	public CdsDemandGdprInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCdsDemandGdprInfoException {

		CdsDemandGdprInfo cdsDemandGdprInfo = fetchByPrimaryKey(primaryKey);

		if (cdsDemandGdprInfo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCdsDemandGdprInfoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return cdsDemandGdprInfo;
	}

	/**
	 * Returns the cds demand gdpr info with the primary key or throws a <code>NoSuchCdsDemandGdprInfoException</code> if it could not be found.
	 *
	 * @param gdprInfoId the primary key of the cds demand gdpr info
	 * @return the cds demand gdpr info
	 * @throws NoSuchCdsDemandGdprInfoException if a cds demand gdpr info with the primary key could not be found
	 */
	@Override
	public CdsDemandGdprInfo findByPrimaryKey(long gdprInfoId)
		throws NoSuchCdsDemandGdprInfoException {

		return findByPrimaryKey((Serializable)gdprInfoId);
	}

	/**
	 * Returns the cds demand gdpr info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param gdprInfoId the primary key of the cds demand gdpr info
	 * @return the cds demand gdpr info, or <code>null</code> if a cds demand gdpr info with the primary key could not be found
	 */
	@Override
	public CdsDemandGdprInfo fetchByPrimaryKey(long gdprInfoId) {
		return fetchByPrimaryKey((Serializable)gdprInfoId);
	}

	/**
	 * Returns all the cds demand gdpr infos.
	 *
	 * @return the cds demand gdpr infos
	 */
	@Override
	public List<CdsDemandGdprInfo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cds demand gdpr infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandGdprInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cds demand gdpr infos
	 * @param end the upper bound of the range of cds demand gdpr infos (not inclusive)
	 * @return the range of cds demand gdpr infos
	 */
	@Override
	public List<CdsDemandGdprInfo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cds demand gdpr infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandGdprInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cds demand gdpr infos
	 * @param end the upper bound of the range of cds demand gdpr infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cds demand gdpr infos
	 */
	@Override
	public List<CdsDemandGdprInfo> findAll(
		int start, int end,
		OrderByComparator<CdsDemandGdprInfo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cds demand gdpr infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CdsDemandGdprInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cds demand gdpr infos
	 * @param end the upper bound of the range of cds demand gdpr infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cds demand gdpr infos
	 */
	@Override
	public List<CdsDemandGdprInfo> findAll(
		int start, int end,
		OrderByComparator<CdsDemandGdprInfo> orderByComparator,
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

		List<CdsDemandGdprInfo> list = null;

		if (useFinderCache) {
			list = (List<CdsDemandGdprInfo>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CDSDEMANDGDPRINFO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CDSDEMANDGDPRINFO;

				sql = sql.concat(CdsDemandGdprInfoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CdsDemandGdprInfo>)QueryUtil.list(
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
	 * Removes all the cds demand gdpr infos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CdsDemandGdprInfo cdsDemandGdprInfo : findAll()) {
			remove(cdsDemandGdprInfo);
		}
	}

	/**
	 * Returns the number of cds demand gdpr infos.
	 *
	 * @return the number of cds demand gdpr infos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CDSDEMANDGDPRINFO);

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
		return "gdprInfoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CDSDEMANDGDPRINFO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CdsDemandGdprInfoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cds demand gdpr info persistence.
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

		_finderPathWithPaginationFindBydemandId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydemandId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"demandId"}, true);

		_finderPathWithoutPaginationFindBydemandId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydemandId",
			new String[] {Long.class.getName()}, new String[] {"demandId"},
			true);

		_finderPathCountBydemandId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydemandId",
			new String[] {Long.class.getName()}, new String[] {"demandId"},
			false);

		_setCdsDemandGdprInfoUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCdsDemandGdprInfoUtilPersistence(null);

		entityCache.removeCache(CdsDemandGdprInfoImpl.class.getName());
	}

	private void _setCdsDemandGdprInfoUtilPersistence(
		CdsDemandGdprInfoPersistence cdsDemandGdprInfoPersistence) {

		try {
			Field field = CdsDemandGdprInfoUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, cdsDemandGdprInfoPersistence);
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

	private static final String _SQL_SELECT_CDSDEMANDGDPRINFO =
		"SELECT cdsDemandGdprInfo FROM CdsDemandGdprInfo cdsDemandGdprInfo";

	private static final String _SQL_SELECT_CDSDEMANDGDPRINFO_WHERE =
		"SELECT cdsDemandGdprInfo FROM CdsDemandGdprInfo cdsDemandGdprInfo WHERE ";

	private static final String _SQL_COUNT_CDSDEMANDGDPRINFO =
		"SELECT COUNT(cdsDemandGdprInfo) FROM CdsDemandGdprInfo cdsDemandGdprInfo";

	private static final String _SQL_COUNT_CDSDEMANDGDPRINFO_WHERE =
		"SELECT COUNT(cdsDemandGdprInfo) FROM CdsDemandGdprInfo cdsDemandGdprInfo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "cdsDemandGdprInfo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CdsDemandGdprInfo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CdsDemandGdprInfo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CdsDemandGdprInfoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private CdsDemandGdprInfoModelArgumentsResolver
		_cdsDemandGdprInfoModelArgumentsResolver;

}