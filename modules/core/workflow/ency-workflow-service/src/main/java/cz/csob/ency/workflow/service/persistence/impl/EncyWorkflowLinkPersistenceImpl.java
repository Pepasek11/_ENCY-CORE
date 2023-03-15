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

package cz.csob.ency.workflow.service.persistence.impl;

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

import cz.csob.ency.workflow.exception.NoSuchLinkException;
import cz.csob.ency.workflow.model.EncyWorkflowLink;
import cz.csob.ency.workflow.model.EncyWorkflowLinkTable;
import cz.csob.ency.workflow.model.impl.EncyWorkflowLinkImpl;
import cz.csob.ency.workflow.model.impl.EncyWorkflowLinkModelImpl;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowLinkPersistence;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowLinkUtil;
import cz.csob.ency.workflow.service.persistence.impl.constants.EncyWorkflowPersistenceConstants;

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
 * The persistence implementation for the ency workflow link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @generated
 */
@Component(service = {EncyWorkflowLinkPersistence.class, BasePersistence.class})
public class EncyWorkflowLinkPersistenceImpl
	extends BasePersistenceImpl<EncyWorkflowLink>
	implements EncyWorkflowLinkPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EncyWorkflowLinkUtil</code> to access the ency workflow link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EncyWorkflowLinkImpl.class.getName();

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
	 * Returns all the ency workflow links where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow links where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
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

		List<EncyWorkflowLink> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowLink>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowLink encyWorkflowLink : list) {
					if (!uuid.equals(encyWorkflowLink.getUuid())) {
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

			sb.append(_SQL_SELECT_ENCYWORKFLOWLINK_WHERE);

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
				sb.append(EncyWorkflowLinkModelImpl.ORDER_BY_JPQL);
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

				list = (List<EncyWorkflowLink>)QueryUtil.list(
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
	 * Returns the first ency workflow link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink findByUuid_First(
			String uuid, OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws NoSuchLinkException {

		EncyWorkflowLink encyWorkflowLink = fetchByUuid_First(
			uuid, orderByComparator);

		if (encyWorkflowLink != null) {
			return encyWorkflowLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLinkException(sb.toString());
	}

	/**
	 * Returns the first ency workflow link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink fetchByUuid_First(
		String uuid, OrderByComparator<EncyWorkflowLink> orderByComparator) {

		List<EncyWorkflowLink> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink findByUuid_Last(
			String uuid, OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws NoSuchLinkException {

		EncyWorkflowLink encyWorkflowLink = fetchByUuid_Last(
			uuid, orderByComparator);

		if (encyWorkflowLink != null) {
			return encyWorkflowLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLinkException(sb.toString());
	}

	/**
	 * Returns the last ency workflow link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink fetchByUuid_Last(
		String uuid, OrderByComparator<EncyWorkflowLink> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflowLink> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflow links before and after the current ency workflow link in the ordered set where uuid = &#63;.
	 *
	 * @param workflowLinkId the primary key of the current ency workflow link
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow link
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	@Override
	public EncyWorkflowLink[] findByUuid_PrevAndNext(
			long workflowLinkId, String uuid,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws NoSuchLinkException {

		uuid = Objects.toString(uuid, "");

		EncyWorkflowLink encyWorkflowLink = findByPrimaryKey(workflowLinkId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowLink[] array = new EncyWorkflowLinkImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, encyWorkflowLink, uuid, orderByComparator, true);

			array[1] = encyWorkflowLink;

			array[2] = getByUuid_PrevAndNext(
				session, encyWorkflowLink, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EncyWorkflowLink getByUuid_PrevAndNext(
		Session session, EncyWorkflowLink encyWorkflowLink, String uuid,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
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

		sb.append(_SQL_SELECT_ENCYWORKFLOWLINK_WHERE);

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
			sb.append(EncyWorkflowLinkModelImpl.ORDER_BY_JPQL);
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
						encyWorkflowLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflowLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ency workflow links where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EncyWorkflowLink encyWorkflowLink :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(encyWorkflowLink);
		}
	}

	/**
	 * Returns the number of ency workflow links where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ency workflow links
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ENCYWORKFLOWLINK_WHERE);

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
		"encyWorkflowLink.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(encyWorkflowLink.uuid IS NULL OR encyWorkflowLink.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the ency workflow link where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLinkException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink findByUUID_G(String uuid, long groupId)
		throws NoSuchLinkException {

		EncyWorkflowLink encyWorkflowLink = fetchByUUID_G(uuid, groupId);

		if (encyWorkflowLink == null) {
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

			throw new NoSuchLinkException(sb.toString());
		}

		return encyWorkflowLink;
	}

	/**
	 * Returns the ency workflow link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the ency workflow link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink fetchByUUID_G(
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

		if (result instanceof EncyWorkflowLink) {
			EncyWorkflowLink encyWorkflowLink = (EncyWorkflowLink)result;

			if (!Objects.equals(uuid, encyWorkflowLink.getUuid()) ||
				(groupId != encyWorkflowLink.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ENCYWORKFLOWLINK_WHERE);

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

				List<EncyWorkflowLink> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					EncyWorkflowLink encyWorkflowLink = list.get(0);

					result = encyWorkflowLink;

					cacheResult(encyWorkflowLink);
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
			return (EncyWorkflowLink)result;
		}
	}

	/**
	 * Removes the ency workflow link where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ency workflow link that was removed
	 */
	@Override
	public EncyWorkflowLink removeByUUID_G(String uuid, long groupId)
		throws NoSuchLinkException {

		EncyWorkflowLink encyWorkflowLink = findByUUID_G(uuid, groupId);

		return remove(encyWorkflowLink);
	}

	/**
	 * Returns the number of ency workflow links where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ency workflow links
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ENCYWORKFLOWLINK_WHERE);

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
		"encyWorkflowLink.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(encyWorkflowLink.uuid IS NULL OR encyWorkflowLink.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"encyWorkflowLink.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the ency workflow links where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow links where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
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

		List<EncyWorkflowLink> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowLink>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowLink encyWorkflowLink : list) {
					if (!uuid.equals(encyWorkflowLink.getUuid()) ||
						(companyId != encyWorkflowLink.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ENCYWORKFLOWLINK_WHERE);

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
				sb.append(EncyWorkflowLinkModelImpl.ORDER_BY_JPQL);
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

				list = (List<EncyWorkflowLink>)QueryUtil.list(
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
	 * Returns the first ency workflow link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws NoSuchLinkException {

		EncyWorkflowLink encyWorkflowLink = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (encyWorkflowLink != null) {
			return encyWorkflowLink;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLinkException(sb.toString());
	}

	/**
	 * Returns the first ency workflow link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		List<EncyWorkflowLink> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws NoSuchLinkException {

		EncyWorkflowLink encyWorkflowLink = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (encyWorkflowLink != null) {
			return encyWorkflowLink;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLinkException(sb.toString());
	}

	/**
	 * Returns the last ency workflow link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflowLink> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflow links before and after the current ency workflow link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param workflowLinkId the primary key of the current ency workflow link
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow link
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	@Override
	public EncyWorkflowLink[] findByUuid_C_PrevAndNext(
			long workflowLinkId, String uuid, long companyId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws NoSuchLinkException {

		uuid = Objects.toString(uuid, "");

		EncyWorkflowLink encyWorkflowLink = findByPrimaryKey(workflowLinkId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowLink[] array = new EncyWorkflowLinkImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, encyWorkflowLink, uuid, companyId, orderByComparator,
				true);

			array[1] = encyWorkflowLink;

			array[2] = getByUuid_C_PrevAndNext(
				session, encyWorkflowLink, uuid, companyId, orderByComparator,
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

	protected EncyWorkflowLink getByUuid_C_PrevAndNext(
		Session session, EncyWorkflowLink encyWorkflowLink, String uuid,
		long companyId, OrderByComparator<EncyWorkflowLink> orderByComparator,
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

		sb.append(_SQL_SELECT_ENCYWORKFLOWLINK_WHERE);

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
			sb.append(EncyWorkflowLinkModelImpl.ORDER_BY_JPQL);
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
						encyWorkflowLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflowLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ency workflow links where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (EncyWorkflowLink encyWorkflowLink :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(encyWorkflowLink);
		}
	}

	/**
	 * Returns the number of ency workflow links where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ency workflow links
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ENCYWORKFLOWLINK_WHERE);

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
		"encyWorkflowLink.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(encyWorkflowLink.uuid IS NULL OR encyWorkflowLink.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"encyWorkflowLink.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByCompanyId;
	private FinderPath _finderPathWithoutPaginationFindByCompanyId;
	private FinderPath _finderPathCountByCompanyId;

	/**
	 * Returns all the ency workflow links where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByCompanyId(long companyId) {
		return findByCompanyId(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow links where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByCompanyId(
		long companyId, int start, int end) {

		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return findByCompanyId(companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
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

		List<EncyWorkflowLink> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowLink>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowLink encyWorkflowLink : list) {
					if (companyId != encyWorkflowLink.getCompanyId()) {
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

			sb.append(_SQL_SELECT_ENCYWORKFLOWLINK_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EncyWorkflowLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<EncyWorkflowLink>)QueryUtil.list(
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
	 * Returns the first ency workflow link in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink findByCompanyId_First(
			long companyId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws NoSuchLinkException {

		EncyWorkflowLink encyWorkflowLink = fetchByCompanyId_First(
			companyId, orderByComparator);

		if (encyWorkflowLink != null) {
			return encyWorkflowLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLinkException(sb.toString());
	}

	/**
	 * Returns the first ency workflow link in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink fetchByCompanyId_First(
		long companyId, OrderByComparator<EncyWorkflowLink> orderByComparator) {

		List<EncyWorkflowLink> list = findByCompanyId(
			companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow link in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink findByCompanyId_Last(
			long companyId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws NoSuchLinkException {

		EncyWorkflowLink encyWorkflowLink = fetchByCompanyId_Last(
			companyId, orderByComparator);

		if (encyWorkflowLink != null) {
			return encyWorkflowLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLinkException(sb.toString());
	}

	/**
	 * Returns the last ency workflow link in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink fetchByCompanyId_Last(
		long companyId, OrderByComparator<EncyWorkflowLink> orderByComparator) {

		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflowLink> list = findByCompanyId(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflow links before and after the current ency workflow link in the ordered set where companyId = &#63;.
	 *
	 * @param workflowLinkId the primary key of the current ency workflow link
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow link
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	@Override
	public EncyWorkflowLink[] findByCompanyId_PrevAndNext(
			long workflowLinkId, long companyId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws NoSuchLinkException {

		EncyWorkflowLink encyWorkflowLink = findByPrimaryKey(workflowLinkId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowLink[] array = new EncyWorkflowLinkImpl[3];

			array[0] = getByCompanyId_PrevAndNext(
				session, encyWorkflowLink, companyId, orderByComparator, true);

			array[1] = encyWorkflowLink;

			array[2] = getByCompanyId_PrevAndNext(
				session, encyWorkflowLink, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EncyWorkflowLink getByCompanyId_PrevAndNext(
		Session session, EncyWorkflowLink encyWorkflowLink, long companyId,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
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

		sb.append(_SQL_SELECT_ENCYWORKFLOWLINK_WHERE);

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
			sb.append(EncyWorkflowLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						encyWorkflowLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflowLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ency workflow links where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (EncyWorkflowLink encyWorkflowLink :
				findByCompanyId(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(encyWorkflowLink);
		}
	}

	/**
	 * Returns the number of ency workflow links where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching ency workflow links
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = _finderPathCountByCompanyId;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ENCYWORKFLOWLINK_WHERE);

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
		"encyWorkflowLink.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByG_C_C;
	private FinderPath _finderPathWithoutPaginationFindByG_C_C;
	private FinderPath _finderPathCountByG_C_C;
	private FinderPath _finderPathWithPaginationCountByG_C_C;

	/**
	 * Returns all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @return the matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByG_C_C(
		long groupId, long companyId, String className) {

		return findByG_C_C(
			groupId, companyId, className, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByG_C_C(
		long groupId, long companyId, String className, int start, int end) {

		return findByG_C_C(groupId, companyId, className, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByG_C_C(
		long groupId, long companyId, String className, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return findByG_C_C(
			groupId, companyId, className, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByG_C_C(
		long groupId, long companyId, String className, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
		boolean useFinderCache) {

		className = Objects.toString(className, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_C_C;
				finderArgs = new Object[] {groupId, companyId, className};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_C_C;
			finderArgs = new Object[] {
				groupId, companyId, className, start, end, orderByComparator
			};
		}

		List<EncyWorkflowLink> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowLink>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowLink encyWorkflowLink : list) {
					if ((groupId != encyWorkflowLink.getGroupId()) ||
						(companyId != encyWorkflowLink.getCompanyId()) ||
						!className.equals(encyWorkflowLink.getClassName())) {

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

			sb.append(_SQL_SELECT_ENCYWORKFLOWLINK_WHERE);

			sb.append(_FINDER_COLUMN_G_C_C_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_C_C_COMPANYID_2);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_C_C_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(_FINDER_COLUMN_G_C_C_CLASSNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EncyWorkflowLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(companyId);

				if (bindClassName) {
					queryPos.add(className);
				}

				list = (List<EncyWorkflowLink>)QueryUtil.list(
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
	 * Returns the first ency workflow link in the ordered set where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink findByG_C_C_First(
			long groupId, long companyId, String className,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws NoSuchLinkException {

		EncyWorkflowLink encyWorkflowLink = fetchByG_C_C_First(
			groupId, companyId, className, orderByComparator);

		if (encyWorkflowLink != null) {
			return encyWorkflowLink;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append(", className=");
		sb.append(className);

		sb.append("}");

		throw new NoSuchLinkException(sb.toString());
	}

	/**
	 * Returns the first ency workflow link in the ordered set where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink fetchByG_C_C_First(
		long groupId, long companyId, String className,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		List<EncyWorkflowLink> list = findByG_C_C(
			groupId, companyId, className, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow link in the ordered set where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink findByG_C_C_Last(
			long groupId, long companyId, String className,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws NoSuchLinkException {

		EncyWorkflowLink encyWorkflowLink = fetchByG_C_C_Last(
			groupId, companyId, className, orderByComparator);

		if (encyWorkflowLink != null) {
			return encyWorkflowLink;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append(", className=");
		sb.append(className);

		sb.append("}");

		throw new NoSuchLinkException(sb.toString());
	}

	/**
	 * Returns the last ency workflow link in the ordered set where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink fetchByG_C_C_Last(
		long groupId, long companyId, String className,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		int count = countByG_C_C(groupId, companyId, className);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflowLink> list = findByG_C_C(
			groupId, companyId, className, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflow links before and after the current ency workflow link in the ordered set where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * @param workflowLinkId the primary key of the current ency workflow link
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow link
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	@Override
	public EncyWorkflowLink[] findByG_C_C_PrevAndNext(
			long workflowLinkId, long groupId, long companyId, String className,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws NoSuchLinkException {

		className = Objects.toString(className, "");

		EncyWorkflowLink encyWorkflowLink = findByPrimaryKey(workflowLinkId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowLink[] array = new EncyWorkflowLinkImpl[3];

			array[0] = getByG_C_C_PrevAndNext(
				session, encyWorkflowLink, groupId, companyId, className,
				orderByComparator, true);

			array[1] = encyWorkflowLink;

			array[2] = getByG_C_C_PrevAndNext(
				session, encyWorkflowLink, groupId, companyId, className,
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

	protected EncyWorkflowLink getByG_C_C_PrevAndNext(
		Session session, EncyWorkflowLink encyWorkflowLink, long groupId,
		long companyId, String className,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
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

		sb.append(_SQL_SELECT_ENCYWORKFLOWLINK_WHERE);

		sb.append(_FINDER_COLUMN_G_C_C_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_C_C_COMPANYID_2);

		boolean bindClassName = false;

		if (className.isEmpty()) {
			sb.append(_FINDER_COLUMN_G_C_C_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			sb.append(_FINDER_COLUMN_G_C_C_CLASSNAME_2);
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
			sb.append(EncyWorkflowLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(companyId);

		if (bindClassName) {
			queryPos.add(className);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						encyWorkflowLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflowLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ency workflow links where groupId = any &#63; and companyId = any &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param companyIds the company IDs
	 * @param className the class name
	 * @return the matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByG_C_C(
		long[] groupIds, long[] companyIds, String className) {

		return findByG_C_C(
			groupIds, companyIds, className, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow links where groupId = any &#63; and companyId = any &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param companyIds the company IDs
	 * @param className the class name
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByG_C_C(
		long[] groupIds, long[] companyIds, String className, int start,
		int end) {

		return findByG_C_C(groupIds, companyIds, className, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where groupId = any &#63; and companyId = any &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param companyIds the company IDs
	 * @param className the class name
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByG_C_C(
		long[] groupIds, long[] companyIds, String className, int start,
		int end, OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return findByG_C_C(
			groupIds, companyIds, className, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByG_C_C(
		long[] groupIds, long[] companyIds, String className, int start,
		int end, OrderByComparator<EncyWorkflowLink> orderByComparator,
		boolean useFinderCache) {

		if (groupIds == null) {
			groupIds = new long[0];
		}
		else if (groupIds.length > 1) {
			groupIds = ArrayUtil.sortedUnique(groupIds);
		}

		if (companyIds == null) {
			companyIds = new long[0];
		}
		else if (companyIds.length > 1) {
			companyIds = ArrayUtil.sortedUnique(companyIds);
		}

		className = Objects.toString(className, "");

		if ((groupIds.length == 1) && (companyIds.length == 1)) {
			return findByG_C_C(
				groupIds[0], companyIds[0], className, start, end,
				orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					StringUtil.merge(groupIds), StringUtil.merge(companyIds),
					className
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				StringUtil.merge(groupIds), StringUtil.merge(companyIds),
				className, start, end, orderByComparator
			};
		}

		List<EncyWorkflowLink> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowLink>)finderCache.getResult(
				_finderPathWithPaginationFindByG_C_C, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowLink encyWorkflowLink : list) {
					if (!ArrayUtil.contains(
							groupIds, encyWorkflowLink.getGroupId()) ||
						!ArrayUtil.contains(
							companyIds, encyWorkflowLink.getCompanyId()) ||
						!className.equals(encyWorkflowLink.getClassName())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_ENCYWORKFLOWLINK_WHERE);

			if (groupIds.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_G_C_C_GROUPID_7);

				sb.append(StringUtil.merge(groupIds));

				sb.append(")");

				sb.append(")");

				sb.append(WHERE_AND);
			}

			if (companyIds.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_G_C_C_COMPANYID_7);

				sb.append(StringUtil.merge(companyIds));

				sb.append(")");

				sb.append(")");

				sb.append(WHERE_AND);
			}

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_C_C_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(_FINDER_COLUMN_G_C_C_CLASSNAME_2);
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EncyWorkflowLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindClassName) {
					queryPos.add(className);
				}

				list = (List<EncyWorkflowLink>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByG_C_C, finderArgs, list);
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
	 * Removes all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 */
	@Override
	public void removeByG_C_C(long groupId, long companyId, String className) {
		for (EncyWorkflowLink encyWorkflowLink :
				findByG_C_C(
					groupId, companyId, className, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(encyWorkflowLink);
		}
	}

	/**
	 * Returns the number of ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @return the number of matching ency workflow links
	 */
	@Override
	public int countByG_C_C(long groupId, long companyId, String className) {
		className = Objects.toString(className, "");

		FinderPath finderPath = _finderPathCountByG_C_C;

		Object[] finderArgs = new Object[] {groupId, companyId, className};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_ENCYWORKFLOWLINK_WHERE);

			sb.append(_FINDER_COLUMN_G_C_C_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_C_C_COMPANYID_2);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_C_C_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(_FINDER_COLUMN_G_C_C_CLASSNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(companyId);

				if (bindClassName) {
					queryPos.add(className);
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
	 * Returns the number of ency workflow links where groupId = any &#63; and companyId = any &#63; and className = &#63;.
	 *
	 * @param groupIds the group IDs
	 * @param companyIds the company IDs
	 * @param className the class name
	 * @return the number of matching ency workflow links
	 */
	@Override
	public int countByG_C_C(
		long[] groupIds, long[] companyIds, String className) {

		if (groupIds == null) {
			groupIds = new long[0];
		}
		else if (groupIds.length > 1) {
			groupIds = ArrayUtil.sortedUnique(groupIds);
		}

		if (companyIds == null) {
			companyIds = new long[0];
		}
		else if (companyIds.length > 1) {
			companyIds = ArrayUtil.sortedUnique(companyIds);
		}

		className = Objects.toString(className, "");

		Object[] finderArgs = new Object[] {
			StringUtil.merge(groupIds), StringUtil.merge(companyIds), className
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByG_C_C, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_ENCYWORKFLOWLINK_WHERE);

			if (groupIds.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_G_C_C_GROUPID_7);

				sb.append(StringUtil.merge(groupIds));

				sb.append(")");

				sb.append(")");

				sb.append(WHERE_AND);
			}

			if (companyIds.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_G_C_C_COMPANYID_7);

				sb.append(StringUtil.merge(companyIds));

				sb.append(")");

				sb.append(")");

				sb.append(WHERE_AND);
			}

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_C_C_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(_FINDER_COLUMN_G_C_C_CLASSNAME_2);
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindClassName) {
					queryPos.add(className);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByG_C_C, finderArgs, count);
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

	private static final String _FINDER_COLUMN_G_C_C_GROUPID_2 =
		"encyWorkflowLink.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_C_GROUPID_7 =
		"encyWorkflowLink.groupId IN (";

	private static final String _FINDER_COLUMN_G_C_C_COMPANYID_2 =
		"encyWorkflowLink.companyId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_C_COMPANYID_7 =
		"encyWorkflowLink.companyId IN (";

	private static final String _FINDER_COLUMN_G_C_C_CLASSNAME_2 =
		"encyWorkflowLink.className = ?";

	private static final String _FINDER_COLUMN_G_C_C_CLASSNAME_3 =
		"(encyWorkflowLink.className IS NULL OR encyWorkflowLink.className = '')";

	private FinderPath _finderPathWithPaginationFindByC_I;
	private FinderPath _finderPathWithoutPaginationFindByC_I;
	private FinderPath _finderPathCountByC_I;
	private FinderPath _finderPathWithPaginationCountByC_I;

	/**
	 * Returns all the ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @return the matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByC_I(long companyId, long workflowId) {
		return findByC_I(
			companyId, workflowId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByC_I(
		long companyId, long workflowId, int start, int end) {

		return findByC_I(companyId, workflowId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByC_I(
		long companyId, long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return findByC_I(
			companyId, workflowId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByC_I(
		long companyId, long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_I;
				finderArgs = new Object[] {companyId, workflowId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_I;
			finderArgs = new Object[] {
				companyId, workflowId, start, end, orderByComparator
			};
		}

		List<EncyWorkflowLink> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowLink>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowLink encyWorkflowLink : list) {
					if ((companyId != encyWorkflowLink.getCompanyId()) ||
						(workflowId != encyWorkflowLink.getWorkflowId())) {

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

			sb.append(_SQL_SELECT_ENCYWORKFLOWLINK_WHERE);

			sb.append(_FINDER_COLUMN_C_I_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_I_WORKFLOWID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EncyWorkflowLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(workflowId);

				list = (List<EncyWorkflowLink>)QueryUtil.list(
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
	 * Returns the first ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink findByC_I_First(
			long companyId, long workflowId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws NoSuchLinkException {

		EncyWorkflowLink encyWorkflowLink = fetchByC_I_First(
			companyId, workflowId, orderByComparator);

		if (encyWorkflowLink != null) {
			return encyWorkflowLink;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", workflowId=");
		sb.append(workflowId);

		sb.append("}");

		throw new NoSuchLinkException(sb.toString());
	}

	/**
	 * Returns the first ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink fetchByC_I_First(
		long companyId, long workflowId,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		List<EncyWorkflowLink> list = findByC_I(
			companyId, workflowId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink findByC_I_Last(
			long companyId, long workflowId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws NoSuchLinkException {

		EncyWorkflowLink encyWorkflowLink = fetchByC_I_Last(
			companyId, workflowId, orderByComparator);

		if (encyWorkflowLink != null) {
			return encyWorkflowLink;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", workflowId=");
		sb.append(workflowId);

		sb.append("}");

		throw new NoSuchLinkException(sb.toString());
	}

	/**
	 * Returns the last ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink fetchByC_I_Last(
		long companyId, long workflowId,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		int count = countByC_I(companyId, workflowId);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflowLink> list = findByC_I(
			companyId, workflowId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflow links before and after the current ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param workflowLinkId the primary key of the current ency workflow link
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow link
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	@Override
	public EncyWorkflowLink[] findByC_I_PrevAndNext(
			long workflowLinkId, long companyId, long workflowId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws NoSuchLinkException {

		EncyWorkflowLink encyWorkflowLink = findByPrimaryKey(workflowLinkId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowLink[] array = new EncyWorkflowLinkImpl[3];

			array[0] = getByC_I_PrevAndNext(
				session, encyWorkflowLink, companyId, workflowId,
				orderByComparator, true);

			array[1] = encyWorkflowLink;

			array[2] = getByC_I_PrevAndNext(
				session, encyWorkflowLink, companyId, workflowId,
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

	protected EncyWorkflowLink getByC_I_PrevAndNext(
		Session session, EncyWorkflowLink encyWorkflowLink, long companyId,
		long workflowId, OrderByComparator<EncyWorkflowLink> orderByComparator,
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

		sb.append(_SQL_SELECT_ENCYWORKFLOWLINK_WHERE);

		sb.append(_FINDER_COLUMN_C_I_COMPANYID_2);

		sb.append(_FINDER_COLUMN_C_I_WORKFLOWID_2);

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
			sb.append(EncyWorkflowLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		queryPos.add(workflowId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						encyWorkflowLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflowLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ency workflow links where companyId = any &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyIds the company IDs
	 * @param workflowId the workflow ID
	 * @return the matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByC_I(
		long[] companyIds, long workflowId) {

		return findByC_I(
			companyIds, workflowId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow links where companyId = any &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyIds the company IDs
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByC_I(
		long[] companyIds, long workflowId, int start, int end) {

		return findByC_I(companyIds, workflowId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where companyId = any &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyIds the company IDs
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByC_I(
		long[] companyIds, long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return findByC_I(
			companyIds, workflowId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where companyId = &#63; and workflowId = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByC_I(
		long[] companyIds, long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
		boolean useFinderCache) {

		if (companyIds == null) {
			companyIds = new long[0];
		}
		else if (companyIds.length > 1) {
			companyIds = ArrayUtil.sortedUnique(companyIds);
		}

		if (companyIds.length == 1) {
			return findByC_I(
				companyIds[0], workflowId, start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					StringUtil.merge(companyIds), workflowId
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				StringUtil.merge(companyIds), workflowId, start, end,
				orderByComparator
			};
		}

		List<EncyWorkflowLink> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowLink>)finderCache.getResult(
				_finderPathWithPaginationFindByC_I, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowLink encyWorkflowLink : list) {
					if (!ArrayUtil.contains(
							companyIds, encyWorkflowLink.getCompanyId()) ||
						(workflowId != encyWorkflowLink.getWorkflowId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_ENCYWORKFLOWLINK_WHERE);

			if (companyIds.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_C_I_COMPANYID_7);

				sb.append(StringUtil.merge(companyIds));

				sb.append(")");

				sb.append(")");

				sb.append(WHERE_AND);
			}

			sb.append(_FINDER_COLUMN_C_I_WORKFLOWID_2);

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EncyWorkflowLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workflowId);

				list = (List<EncyWorkflowLink>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByC_I, finderArgs, list);
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
	 * Removes all the ency workflow links where companyId = &#63; and workflowId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 */
	@Override
	public void removeByC_I(long companyId, long workflowId) {
		for (EncyWorkflowLink encyWorkflowLink :
				findByC_I(
					companyId, workflowId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(encyWorkflowLink);
		}
	}

	/**
	 * Returns the number of ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @return the number of matching ency workflow links
	 */
	@Override
	public int countByC_I(long companyId, long workflowId) {
		FinderPath finderPath = _finderPathCountByC_I;

		Object[] finderArgs = new Object[] {companyId, workflowId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ENCYWORKFLOWLINK_WHERE);

			sb.append(_FINDER_COLUMN_C_I_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_I_WORKFLOWID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(workflowId);

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
	 * Returns the number of ency workflow links where companyId = any &#63; and workflowId = &#63;.
	 *
	 * @param companyIds the company IDs
	 * @param workflowId the workflow ID
	 * @return the number of matching ency workflow links
	 */
	@Override
	public int countByC_I(long[] companyIds, long workflowId) {
		if (companyIds == null) {
			companyIds = new long[0];
		}
		else if (companyIds.length > 1) {
			companyIds = ArrayUtil.sortedUnique(companyIds);
		}

		Object[] finderArgs = new Object[] {
			StringUtil.merge(companyIds), workflowId
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByC_I, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_ENCYWORKFLOWLINK_WHERE);

			if (companyIds.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_C_I_COMPANYID_7);

				sb.append(StringUtil.merge(companyIds));

				sb.append(")");

				sb.append(")");

				sb.append(WHERE_AND);
			}

			sb.append(_FINDER_COLUMN_C_I_WORKFLOWID_2);

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workflowId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByC_I, finderArgs, count);
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

	private static final String _FINDER_COLUMN_C_I_COMPANYID_2 =
		"encyWorkflowLink.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_I_COMPANYID_7 =
		"encyWorkflowLink.companyId IN (";

	private static final String _FINDER_COLUMN_C_I_WORKFLOWID_2 =
		"encyWorkflowLink.workflowId = ?";

	private FinderPath _finderPathWithPaginationFindByWorkflowId;
	private FinderPath _finderPathWithoutPaginationFindByWorkflowId;
	private FinderPath _finderPathCountByWorkflowId;
	private FinderPath _finderPathWithPaginationCountByWorkflowId;

	/**
	 * Returns all the ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @return the matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByWorkflowId(
		long companyId, long workflowId) {

		return findByWorkflowId(
			companyId, workflowId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByWorkflowId(
		long companyId, long workflowId, int start, int end) {

		return findByWorkflowId(companyId, workflowId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByWorkflowId(
		long companyId, long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return findByWorkflowId(
			companyId, workflowId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByWorkflowId(
		long companyId, long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByWorkflowId;
				finderArgs = new Object[] {companyId, workflowId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByWorkflowId;
			finderArgs = new Object[] {
				companyId, workflowId, start, end, orderByComparator
			};
		}

		List<EncyWorkflowLink> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowLink>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowLink encyWorkflowLink : list) {
					if ((companyId != encyWorkflowLink.getCompanyId()) ||
						(workflowId != encyWorkflowLink.getWorkflowId())) {

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

			sb.append(_SQL_SELECT_ENCYWORKFLOWLINK_WHERE);

			sb.append(_FINDER_COLUMN_WORKFLOWID_COMPANYID_2);

			sb.append(_FINDER_COLUMN_WORKFLOWID_WORKFLOWID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EncyWorkflowLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(workflowId);

				list = (List<EncyWorkflowLink>)QueryUtil.list(
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
	 * Returns the first ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink findByWorkflowId_First(
			long companyId, long workflowId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws NoSuchLinkException {

		EncyWorkflowLink encyWorkflowLink = fetchByWorkflowId_First(
			companyId, workflowId, orderByComparator);

		if (encyWorkflowLink != null) {
			return encyWorkflowLink;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", workflowId=");
		sb.append(workflowId);

		sb.append("}");

		throw new NoSuchLinkException(sb.toString());
	}

	/**
	 * Returns the first ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink fetchByWorkflowId_First(
		long companyId, long workflowId,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		List<EncyWorkflowLink> list = findByWorkflowId(
			companyId, workflowId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink findByWorkflowId_Last(
			long companyId, long workflowId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws NoSuchLinkException {

		EncyWorkflowLink encyWorkflowLink = fetchByWorkflowId_Last(
			companyId, workflowId, orderByComparator);

		if (encyWorkflowLink != null) {
			return encyWorkflowLink;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", workflowId=");
		sb.append(workflowId);

		sb.append("}");

		throw new NoSuchLinkException(sb.toString());
	}

	/**
	 * Returns the last ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink fetchByWorkflowId_Last(
		long companyId, long workflowId,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		int count = countByWorkflowId(companyId, workflowId);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflowLink> list = findByWorkflowId(
			companyId, workflowId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflow links before and after the current ency workflow link in the ordered set where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param workflowLinkId the primary key of the current ency workflow link
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow link
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	@Override
	public EncyWorkflowLink[] findByWorkflowId_PrevAndNext(
			long workflowLinkId, long companyId, long workflowId,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws NoSuchLinkException {

		EncyWorkflowLink encyWorkflowLink = findByPrimaryKey(workflowLinkId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowLink[] array = new EncyWorkflowLinkImpl[3];

			array[0] = getByWorkflowId_PrevAndNext(
				session, encyWorkflowLink, companyId, workflowId,
				orderByComparator, true);

			array[1] = encyWorkflowLink;

			array[2] = getByWorkflowId_PrevAndNext(
				session, encyWorkflowLink, companyId, workflowId,
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

	protected EncyWorkflowLink getByWorkflowId_PrevAndNext(
		Session session, EncyWorkflowLink encyWorkflowLink, long companyId,
		long workflowId, OrderByComparator<EncyWorkflowLink> orderByComparator,
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

		sb.append(_SQL_SELECT_ENCYWORKFLOWLINK_WHERE);

		sb.append(_FINDER_COLUMN_WORKFLOWID_COMPANYID_2);

		sb.append(_FINDER_COLUMN_WORKFLOWID_WORKFLOWID_2);

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
			sb.append(EncyWorkflowLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		queryPos.add(workflowId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						encyWorkflowLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflowLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ency workflow links where companyId = any &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyIds the company IDs
	 * @param workflowId the workflow ID
	 * @return the matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByWorkflowId(
		long[] companyIds, long workflowId) {

		return findByWorkflowId(
			companyIds, workflowId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow links where companyId = any &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyIds the company IDs
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByWorkflowId(
		long[] companyIds, long workflowId, int start, int end) {

		return findByWorkflowId(companyIds, workflowId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where companyId = any &#63; and workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyIds the company IDs
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByWorkflowId(
		long[] companyIds, long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return findByWorkflowId(
			companyIds, workflowId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where companyId = &#63; and workflowId = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByWorkflowId(
		long[] companyIds, long workflowId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
		boolean useFinderCache) {

		if (companyIds == null) {
			companyIds = new long[0];
		}
		else if (companyIds.length > 1) {
			companyIds = ArrayUtil.sortedUnique(companyIds);
		}

		if (companyIds.length == 1) {
			return findByWorkflowId(
				companyIds[0], workflowId, start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					StringUtil.merge(companyIds), workflowId
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				StringUtil.merge(companyIds), workflowId, start, end,
				orderByComparator
			};
		}

		List<EncyWorkflowLink> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowLink>)finderCache.getResult(
				_finderPathWithPaginationFindByWorkflowId, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowLink encyWorkflowLink : list) {
					if (!ArrayUtil.contains(
							companyIds, encyWorkflowLink.getCompanyId()) ||
						(workflowId != encyWorkflowLink.getWorkflowId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_ENCYWORKFLOWLINK_WHERE);

			if (companyIds.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_WORKFLOWID_COMPANYID_7);

				sb.append(StringUtil.merge(companyIds));

				sb.append(")");

				sb.append(")");

				sb.append(WHERE_AND);
			}

			sb.append(_FINDER_COLUMN_WORKFLOWID_WORKFLOWID_2);

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EncyWorkflowLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workflowId);

				list = (List<EncyWorkflowLink>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByWorkflowId, finderArgs,
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
	 * Removes all the ency workflow links where companyId = &#63; and workflowId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 */
	@Override
	public void removeByWorkflowId(long companyId, long workflowId) {
		for (EncyWorkflowLink encyWorkflowLink :
				findByWorkflowId(
					companyId, workflowId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(encyWorkflowLink);
		}
	}

	/**
	 * Returns the number of ency workflow links where companyId = &#63; and workflowId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param workflowId the workflow ID
	 * @return the number of matching ency workflow links
	 */
	@Override
	public int countByWorkflowId(long companyId, long workflowId) {
		FinderPath finderPath = _finderPathCountByWorkflowId;

		Object[] finderArgs = new Object[] {companyId, workflowId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ENCYWORKFLOWLINK_WHERE);

			sb.append(_FINDER_COLUMN_WORKFLOWID_COMPANYID_2);

			sb.append(_FINDER_COLUMN_WORKFLOWID_WORKFLOWID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(workflowId);

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
	 * Returns the number of ency workflow links where companyId = any &#63; and workflowId = &#63;.
	 *
	 * @param companyIds the company IDs
	 * @param workflowId the workflow ID
	 * @return the number of matching ency workflow links
	 */
	@Override
	public int countByWorkflowId(long[] companyIds, long workflowId) {
		if (companyIds == null) {
			companyIds = new long[0];
		}
		else if (companyIds.length > 1) {
			companyIds = ArrayUtil.sortedUnique(companyIds);
		}

		Object[] finderArgs = new Object[] {
			StringUtil.merge(companyIds), workflowId
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByWorkflowId, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_ENCYWORKFLOWLINK_WHERE);

			if (companyIds.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_WORKFLOWID_COMPANYID_7);

				sb.append(StringUtil.merge(companyIds));

				sb.append(")");

				sb.append(")");

				sb.append(WHERE_AND);
			}

			sb.append(_FINDER_COLUMN_WORKFLOWID_WORKFLOWID_2);

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workflowId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByWorkflowId, finderArgs,
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

	private static final String _FINDER_COLUMN_WORKFLOWID_COMPANYID_2 =
		"encyWorkflowLink.companyId = ? AND ";

	private static final String _FINDER_COLUMN_WORKFLOWID_COMPANYID_7 =
		"encyWorkflowLink.companyId IN (";

	private static final String _FINDER_COLUMN_WORKFLOWID_WORKFLOWID_2 =
		"encyWorkflowLink.workflowId = ?";

	private FinderPath _finderPathWithPaginationFindByG_C_C_F_F;
	private FinderPath _finderPathWithoutPaginationFindByG_C_C_F_F;
	private FinderPath _finderPathCountByG_C_C_F_F;
	private FinderPath _finderPathWithPaginationCountByG_C_C_F_F;

	/**
	 * Returns all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 * @return the matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByG_C_C_F_F(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK) {

		return findByG_C_C_F_F(
			groupId, companyId, className, folderClassName, folderPK,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByG_C_C_F_F(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK, int start, int end) {

		return findByG_C_C_F_F(
			groupId, companyId, className, folderClassName, folderPK, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByG_C_C_F_F(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return findByG_C_C_F_F(
			groupId, companyId, className, folderClassName, folderPK, start,
			end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByG_C_C_F_F(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
		boolean useFinderCache) {

		className = Objects.toString(className, "");
		folderClassName = Objects.toString(folderClassName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_C_C_F_F;
				finderArgs = new Object[] {
					groupId, companyId, className, folderClassName, folderPK
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_C_C_F_F;
			finderArgs = new Object[] {
				groupId, companyId, className, folderClassName, folderPK, start,
				end, orderByComparator
			};
		}

		List<EncyWorkflowLink> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowLink>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowLink encyWorkflowLink : list) {
					if ((groupId != encyWorkflowLink.getGroupId()) ||
						(companyId != encyWorkflowLink.getCompanyId()) ||
						!className.equals(encyWorkflowLink.getClassName()) ||
						!folderClassName.equals(
							encyWorkflowLink.getFolderClassName()) ||
						(folderPK != encyWorkflowLink.getFolderPK())) {

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
					7 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(7);
			}

			sb.append(_SQL_SELECT_ENCYWORKFLOWLINK_WHERE);

			sb.append(_FINDER_COLUMN_G_C_C_F_F_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_C_C_F_F_COMPANYID_2);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_C_C_F_F_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(_FINDER_COLUMN_G_C_C_F_F_CLASSNAME_2);
			}

			boolean bindFolderClassName = false;

			if (folderClassName.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_C_C_F_F_FOLDERCLASSNAME_3);
			}
			else {
				bindFolderClassName = true;

				sb.append(_FINDER_COLUMN_G_C_C_F_F_FOLDERCLASSNAME_2);
			}

			sb.append(_FINDER_COLUMN_G_C_C_F_F_FOLDERPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EncyWorkflowLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(companyId);

				if (bindClassName) {
					queryPos.add(className);
				}

				if (bindFolderClassName) {
					queryPos.add(folderClassName);
				}

				queryPos.add(folderPK);

				list = (List<EncyWorkflowLink>)QueryUtil.list(
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
	 * Returns the first ency workflow link in the ordered set where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink findByG_C_C_F_F_First(
			long groupId, long companyId, String className,
			String folderClassName, long folderPK,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws NoSuchLinkException {

		EncyWorkflowLink encyWorkflowLink = fetchByG_C_C_F_F_First(
			groupId, companyId, className, folderClassName, folderPK,
			orderByComparator);

		if (encyWorkflowLink != null) {
			return encyWorkflowLink;
		}

		StringBundler sb = new StringBundler(12);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append(", className=");
		sb.append(className);

		sb.append(", folderClassName=");
		sb.append(folderClassName);

		sb.append(", folderPK=");
		sb.append(folderPK);

		sb.append("}");

		throw new NoSuchLinkException(sb.toString());
	}

	/**
	 * Returns the first ency workflow link in the ordered set where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink fetchByG_C_C_F_F_First(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK, OrderByComparator<EncyWorkflowLink> orderByComparator) {

		List<EncyWorkflowLink> list = findByG_C_C_F_F(
			groupId, companyId, className, folderClassName, folderPK, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ency workflow link in the ordered set where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link
	 * @throws NoSuchLinkException if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink findByG_C_C_F_F_Last(
			long groupId, long companyId, String className,
			String folderClassName, long folderPK,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws NoSuchLinkException {

		EncyWorkflowLink encyWorkflowLink = fetchByG_C_C_F_F_Last(
			groupId, companyId, className, folderClassName, folderPK,
			orderByComparator);

		if (encyWorkflowLink != null) {
			return encyWorkflowLink;
		}

		StringBundler sb = new StringBundler(12);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append(", className=");
		sb.append(className);

		sb.append(", folderClassName=");
		sb.append(folderClassName);

		sb.append(", folderPK=");
		sb.append(folderPK);

		sb.append("}");

		throw new NoSuchLinkException(sb.toString());
	}

	/**
	 * Returns the last ency workflow link in the ordered set where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	@Override
	public EncyWorkflowLink fetchByG_C_C_F_F_Last(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK, OrderByComparator<EncyWorkflowLink> orderByComparator) {

		int count = countByG_C_C_F_F(
			groupId, companyId, className, folderClassName, folderPK);

		if (count == 0) {
			return null;
		}

		List<EncyWorkflowLink> list = findByG_C_C_F_F(
			groupId, companyId, className, folderClassName, folderPK, count - 1,
			count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ency workflow links before and after the current ency workflow link in the ordered set where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63;.
	 *
	 * @param workflowLinkId the primary key of the current ency workflow link
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ency workflow link
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	@Override
	public EncyWorkflowLink[] findByG_C_C_F_F_PrevAndNext(
			long workflowLinkId, long groupId, long companyId, String className,
			String folderClassName, long folderPK,
			OrderByComparator<EncyWorkflowLink> orderByComparator)
		throws NoSuchLinkException {

		className = Objects.toString(className, "");
		folderClassName = Objects.toString(folderClassName, "");

		EncyWorkflowLink encyWorkflowLink = findByPrimaryKey(workflowLinkId);

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowLink[] array = new EncyWorkflowLinkImpl[3];

			array[0] = getByG_C_C_F_F_PrevAndNext(
				session, encyWorkflowLink, groupId, companyId, className,
				folderClassName, folderPK, orderByComparator, true);

			array[1] = encyWorkflowLink;

			array[2] = getByG_C_C_F_F_PrevAndNext(
				session, encyWorkflowLink, groupId, companyId, className,
				folderClassName, folderPK, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EncyWorkflowLink getByG_C_C_F_F_PrevAndNext(
		Session session, EncyWorkflowLink encyWorkflowLink, long groupId,
		long companyId, String className, String folderClassName, long folderPK,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				8 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(7);
		}

		sb.append(_SQL_SELECT_ENCYWORKFLOWLINK_WHERE);

		sb.append(_FINDER_COLUMN_G_C_C_F_F_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_C_C_F_F_COMPANYID_2);

		boolean bindClassName = false;

		if (className.isEmpty()) {
			sb.append(_FINDER_COLUMN_G_C_C_F_F_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			sb.append(_FINDER_COLUMN_G_C_C_F_F_CLASSNAME_2);
		}

		boolean bindFolderClassName = false;

		if (folderClassName.isEmpty()) {
			sb.append(_FINDER_COLUMN_G_C_C_F_F_FOLDERCLASSNAME_3);
		}
		else {
			bindFolderClassName = true;

			sb.append(_FINDER_COLUMN_G_C_C_F_F_FOLDERCLASSNAME_2);
		}

		sb.append(_FINDER_COLUMN_G_C_C_F_F_FOLDERPK_2);

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
			sb.append(EncyWorkflowLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(companyId);

		if (bindClassName) {
			queryPos.add(className);
		}

		if (bindFolderClassName) {
			queryPos.add(folderClassName);
		}

		queryPos.add(folderPK);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						encyWorkflowLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EncyWorkflowLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ency workflow links where groupId = any &#63; and companyId = any &#63; and className = &#63; and folderClassName = any &#63; and folderPK = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param companyIds the company IDs
	 * @param className the class name
	 * @param folderClassNames the folder class names
	 * @param folderPKs the folder pks
	 * @return the matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByG_C_C_F_F(
		long[] groupIds, long[] companyIds, String className,
		String[] folderClassNames, long[] folderPKs) {

		return findByG_C_C_F_F(
			groupIds, companyIds, className, folderClassNames, folderPKs,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow links where groupId = any &#63; and companyId = any &#63; and className = &#63; and folderClassName = any &#63; and folderPK = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param companyIds the company IDs
	 * @param className the class name
	 * @param folderClassNames the folder class names
	 * @param folderPKs the folder pks
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByG_C_C_F_F(
		long[] groupIds, long[] companyIds, String className,
		String[] folderClassNames, long[] folderPKs, int start, int end) {

		return findByG_C_C_F_F(
			groupIds, companyIds, className, folderClassNames, folderPKs, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where groupId = any &#63; and companyId = any &#63; and className = &#63; and folderClassName = any &#63; and folderPK = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param companyIds the company IDs
	 * @param className the class name
	 * @param folderClassNames the folder class names
	 * @param folderPKs the folder pks
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByG_C_C_F_F(
		long[] groupIds, long[] companyIds, String className,
		String[] folderClassNames, long[] folderPKs, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return findByG_C_C_F_F(
			groupIds, companyIds, className, folderClassNames, folderPKs, start,
			end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findByG_C_C_F_F(
		long[] groupIds, long[] companyIds, String className,
		String[] folderClassNames, long[] folderPKs, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
		boolean useFinderCache) {

		if (groupIds == null) {
			groupIds = new long[0];
		}
		else if (groupIds.length > 1) {
			groupIds = ArrayUtil.sortedUnique(groupIds);
		}

		if (companyIds == null) {
			companyIds = new long[0];
		}
		else if (companyIds.length > 1) {
			companyIds = ArrayUtil.sortedUnique(companyIds);
		}

		className = Objects.toString(className, "");

		if (folderClassNames == null) {
			folderClassNames = new String[0];
		}
		else if (folderClassNames.length > 1) {
			for (int i = 0; i < folderClassNames.length; i++) {
				folderClassNames[i] = Objects.toString(folderClassNames[i], "");
			}

			folderClassNames = ArrayUtil.sortedUnique(folderClassNames);
		}

		if (folderPKs == null) {
			folderPKs = new long[0];
		}
		else if (folderPKs.length > 1) {
			folderPKs = ArrayUtil.sortedUnique(folderPKs);
		}

		if ((groupIds.length == 1) && (companyIds.length == 1) &&
			(folderClassNames.length == 1) && (folderPKs.length == 1)) {

			return findByG_C_C_F_F(
				groupIds[0], companyIds[0], className, folderClassNames[0],
				folderPKs[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					StringUtil.merge(groupIds), StringUtil.merge(companyIds),
					className, StringUtil.merge(folderClassNames),
					StringUtil.merge(folderPKs)
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				StringUtil.merge(groupIds), StringUtil.merge(companyIds),
				className, StringUtil.merge(folderClassNames),
				StringUtil.merge(folderPKs), start, end, orderByComparator
			};
		}

		List<EncyWorkflowLink> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowLink>)finderCache.getResult(
				_finderPathWithPaginationFindByG_C_C_F_F, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EncyWorkflowLink encyWorkflowLink : list) {
					if (!ArrayUtil.contains(
							groupIds, encyWorkflowLink.getGroupId()) ||
						!ArrayUtil.contains(
							companyIds, encyWorkflowLink.getCompanyId()) ||
						!className.equals(encyWorkflowLink.getClassName()) ||
						!ArrayUtil.contains(
							folderClassNames,
							encyWorkflowLink.getFolderClassName()) ||
						!ArrayUtil.contains(
							folderPKs, encyWorkflowLink.getFolderPK())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_ENCYWORKFLOWLINK_WHERE);

			if (groupIds.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_G_C_C_F_F_GROUPID_7);

				sb.append(StringUtil.merge(groupIds));

				sb.append(")");

				sb.append(")");

				sb.append(WHERE_AND);
			}

			if (companyIds.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_G_C_C_F_F_COMPANYID_7);

				sb.append(StringUtil.merge(companyIds));

				sb.append(")");

				sb.append(")");

				sb.append(WHERE_AND);
			}

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_C_C_F_F_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(_FINDER_COLUMN_G_C_C_F_F_CLASSNAME_2);
			}

			if (folderClassNames.length > 0) {
				sb.append("(");

				for (int i = 0; i < folderClassNames.length; i++) {
					String folderClassName = folderClassNames[i];

					if (folderClassName.isEmpty()) {
						sb.append(_FINDER_COLUMN_G_C_C_F_F_FOLDERCLASSNAME_6);
					}
					else {
						sb.append(_FINDER_COLUMN_G_C_C_F_F_FOLDERCLASSNAME_5);
					}

					if ((i + 1) < folderClassNames.length) {
						sb.append(WHERE_OR);
					}
				}

				sb.append(")");

				sb.append(WHERE_AND);
			}

			if (folderPKs.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_G_C_C_F_F_FOLDERPK_7);

				sb.append(StringUtil.merge(folderPKs));

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
				sb.append(EncyWorkflowLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindClassName) {
					queryPos.add(className);
				}

				for (String folderClassName : folderClassNames) {
					if ((folderClassName != null) &&
						!folderClassName.isEmpty()) {

						queryPos.add(folderClassName);
					}
				}

				list = (List<EncyWorkflowLink>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByG_C_C_F_F, finderArgs,
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
	 * Removes all the ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 */
	@Override
	public void removeByG_C_C_F_F(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK) {

		for (EncyWorkflowLink encyWorkflowLink :
				findByG_C_C_F_F(
					groupId, companyId, className, folderClassName, folderPK,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(encyWorkflowLink);
		}
	}

	/**
	 * Returns the number of ency workflow links where groupId = &#63; and companyId = &#63; and className = &#63; and folderClassName = &#63; and folderPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param className the class name
	 * @param folderClassName the folder class name
	 * @param folderPK the folder pk
	 * @return the number of matching ency workflow links
	 */
	@Override
	public int countByG_C_C_F_F(
		long groupId, long companyId, String className, String folderClassName,
		long folderPK) {

		className = Objects.toString(className, "");
		folderClassName = Objects.toString(folderClassName, "");

		FinderPath finderPath = _finderPathCountByG_C_C_F_F;

		Object[] finderArgs = new Object[] {
			groupId, companyId, className, folderClassName, folderPK
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_COUNT_ENCYWORKFLOWLINK_WHERE);

			sb.append(_FINDER_COLUMN_G_C_C_F_F_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_C_C_F_F_COMPANYID_2);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_C_C_F_F_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(_FINDER_COLUMN_G_C_C_F_F_CLASSNAME_2);
			}

			boolean bindFolderClassName = false;

			if (folderClassName.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_C_C_F_F_FOLDERCLASSNAME_3);
			}
			else {
				bindFolderClassName = true;

				sb.append(_FINDER_COLUMN_G_C_C_F_F_FOLDERCLASSNAME_2);
			}

			sb.append(_FINDER_COLUMN_G_C_C_F_F_FOLDERPK_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(companyId);

				if (bindClassName) {
					queryPos.add(className);
				}

				if (bindFolderClassName) {
					queryPos.add(folderClassName);
				}

				queryPos.add(folderPK);

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
	 * Returns the number of ency workflow links where groupId = any &#63; and companyId = any &#63; and className = &#63; and folderClassName = any &#63; and folderPK = any &#63;.
	 *
	 * @param groupIds the group IDs
	 * @param companyIds the company IDs
	 * @param className the class name
	 * @param folderClassNames the folder class names
	 * @param folderPKs the folder pks
	 * @return the number of matching ency workflow links
	 */
	@Override
	public int countByG_C_C_F_F(
		long[] groupIds, long[] companyIds, String className,
		String[] folderClassNames, long[] folderPKs) {

		if (groupIds == null) {
			groupIds = new long[0];
		}
		else if (groupIds.length > 1) {
			groupIds = ArrayUtil.sortedUnique(groupIds);
		}

		if (companyIds == null) {
			companyIds = new long[0];
		}
		else if (companyIds.length > 1) {
			companyIds = ArrayUtil.sortedUnique(companyIds);
		}

		className = Objects.toString(className, "");

		if (folderClassNames == null) {
			folderClassNames = new String[0];
		}
		else if (folderClassNames.length > 1) {
			for (int i = 0; i < folderClassNames.length; i++) {
				folderClassNames[i] = Objects.toString(folderClassNames[i], "");
			}

			folderClassNames = ArrayUtil.sortedUnique(folderClassNames);
		}

		if (folderPKs == null) {
			folderPKs = new long[0];
		}
		else if (folderPKs.length > 1) {
			folderPKs = ArrayUtil.sortedUnique(folderPKs);
		}

		Object[] finderArgs = new Object[] {
			StringUtil.merge(groupIds), StringUtil.merge(companyIds), className,
			StringUtil.merge(folderClassNames), StringUtil.merge(folderPKs)
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByG_C_C_F_F, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_ENCYWORKFLOWLINK_WHERE);

			if (groupIds.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_G_C_C_F_F_GROUPID_7);

				sb.append(StringUtil.merge(groupIds));

				sb.append(")");

				sb.append(")");

				sb.append(WHERE_AND);
			}

			if (companyIds.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_G_C_C_F_F_COMPANYID_7);

				sb.append(StringUtil.merge(companyIds));

				sb.append(")");

				sb.append(")");

				sb.append(WHERE_AND);
			}

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_C_C_F_F_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(_FINDER_COLUMN_G_C_C_F_F_CLASSNAME_2);
			}

			if (folderClassNames.length > 0) {
				sb.append("(");

				for (int i = 0; i < folderClassNames.length; i++) {
					String folderClassName = folderClassNames[i];

					if (folderClassName.isEmpty()) {
						sb.append(_FINDER_COLUMN_G_C_C_F_F_FOLDERCLASSNAME_6);
					}
					else {
						sb.append(_FINDER_COLUMN_G_C_C_F_F_FOLDERCLASSNAME_5);
					}

					if ((i + 1) < folderClassNames.length) {
						sb.append(WHERE_OR);
					}
				}

				sb.append(")");

				sb.append(WHERE_AND);
			}

			if (folderPKs.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_G_C_C_F_F_FOLDERPK_7);

				sb.append(StringUtil.merge(folderPKs));

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

				if (bindClassName) {
					queryPos.add(className);
				}

				for (String folderClassName : folderClassNames) {
					if ((folderClassName != null) &&
						!folderClassName.isEmpty()) {

						queryPos.add(folderClassName);
					}
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByG_C_C_F_F, finderArgs,
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

	private static final String _FINDER_COLUMN_G_C_C_F_F_GROUPID_2 =
		"encyWorkflowLink.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_C_F_F_GROUPID_7 =
		"encyWorkflowLink.groupId IN (";

	private static final String _FINDER_COLUMN_G_C_C_F_F_COMPANYID_2 =
		"encyWorkflowLink.companyId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_C_F_F_COMPANYID_7 =
		"encyWorkflowLink.companyId IN (";

	private static final String _FINDER_COLUMN_G_C_C_F_F_CLASSNAME_2 =
		"encyWorkflowLink.className = ? AND ";

	private static final String _FINDER_COLUMN_G_C_C_F_F_CLASSNAME_3 =
		"(encyWorkflowLink.className IS NULL OR encyWorkflowLink.className = '') AND ";

	private static final String _FINDER_COLUMN_G_C_C_F_F_FOLDERCLASSNAME_2 =
		"encyWorkflowLink.folderClassName = ? AND ";

	private static final String _FINDER_COLUMN_G_C_C_F_F_FOLDERCLASSNAME_3 =
		"(encyWorkflowLink.folderClassName IS NULL OR encyWorkflowLink.folderClassName = '') AND ";

	private static final String _FINDER_COLUMN_G_C_C_F_F_FOLDERCLASSNAME_5 =
		"(" + removeConjunction(_FINDER_COLUMN_G_C_C_F_F_FOLDERCLASSNAME_2) +
			")";

	private static final String _FINDER_COLUMN_G_C_C_F_F_FOLDERCLASSNAME_6 =
		"(" + removeConjunction(_FINDER_COLUMN_G_C_C_F_F_FOLDERCLASSNAME_3) +
			")";

	private static final String _FINDER_COLUMN_G_C_C_F_F_FOLDERPK_2 =
		"encyWorkflowLink.folderPK = ?";

	private static final String _FINDER_COLUMN_G_C_C_F_F_FOLDERPK_7 =
		"encyWorkflowLink.folderPK IN (";

	public EncyWorkflowLinkPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EncyWorkflowLink.class);

		setModelImplClass(EncyWorkflowLinkImpl.class);
		setModelPKClass(long.class);

		setTable(EncyWorkflowLinkTable.INSTANCE);
	}

	/**
	 * Caches the ency workflow link in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowLink the ency workflow link
	 */
	@Override
	public void cacheResult(EncyWorkflowLink encyWorkflowLink) {
		entityCache.putResult(
			EncyWorkflowLinkImpl.class, encyWorkflowLink.getPrimaryKey(),
			encyWorkflowLink);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				encyWorkflowLink.getUuid(), encyWorkflowLink.getGroupId()
			},
			encyWorkflowLink);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the ency workflow links in the entity cache if it is enabled.
	 *
	 * @param encyWorkflowLinks the ency workflow links
	 */
	@Override
	public void cacheResult(List<EncyWorkflowLink> encyWorkflowLinks) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (encyWorkflowLinks.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EncyWorkflowLink encyWorkflowLink : encyWorkflowLinks) {
			if (entityCache.getResult(
					EncyWorkflowLinkImpl.class,
					encyWorkflowLink.getPrimaryKey()) == null) {

				cacheResult(encyWorkflowLink);
			}
		}
	}

	/**
	 * Clears the cache for all ency workflow links.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EncyWorkflowLinkImpl.class);

		finderCache.clearCache(EncyWorkflowLinkImpl.class);
	}

	/**
	 * Clears the cache for the ency workflow link.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EncyWorkflowLink encyWorkflowLink) {
		entityCache.removeResult(EncyWorkflowLinkImpl.class, encyWorkflowLink);
	}

	@Override
	public void clearCache(List<EncyWorkflowLink> encyWorkflowLinks) {
		for (EncyWorkflowLink encyWorkflowLink : encyWorkflowLinks) {
			entityCache.removeResult(
				EncyWorkflowLinkImpl.class, encyWorkflowLink);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EncyWorkflowLinkImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EncyWorkflowLinkImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EncyWorkflowLinkModelImpl encyWorkflowLinkModelImpl) {

		Object[] args = new Object[] {
			encyWorkflowLinkModelImpl.getUuid(),
			encyWorkflowLinkModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, encyWorkflowLinkModelImpl);
	}

	/**
	 * Creates a new ency workflow link with the primary key. Does not add the ency workflow link to the database.
	 *
	 * @param workflowLinkId the primary key for the new ency workflow link
	 * @return the new ency workflow link
	 */
	@Override
	public EncyWorkflowLink create(long workflowLinkId) {
		EncyWorkflowLink encyWorkflowLink = new EncyWorkflowLinkImpl();

		encyWorkflowLink.setNew(true);
		encyWorkflowLink.setPrimaryKey(workflowLinkId);

		String uuid = _portalUUID.generate();

		encyWorkflowLink.setUuid(uuid);

		encyWorkflowLink.setCompanyId(CompanyThreadLocal.getCompanyId());

		return encyWorkflowLink;
	}

	/**
	 * Removes the ency workflow link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workflowLinkId the primary key of the ency workflow link
	 * @return the ency workflow link that was removed
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	@Override
	public EncyWorkflowLink remove(long workflowLinkId)
		throws NoSuchLinkException {

		return remove((Serializable)workflowLinkId);
	}

	/**
	 * Removes the ency workflow link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ency workflow link
	 * @return the ency workflow link that was removed
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	@Override
	public EncyWorkflowLink remove(Serializable primaryKey)
		throws NoSuchLinkException {

		Session session = null;

		try {
			session = openSession();

			EncyWorkflowLink encyWorkflowLink = (EncyWorkflowLink)session.get(
				EncyWorkflowLinkImpl.class, primaryKey);

			if (encyWorkflowLink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLinkException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(encyWorkflowLink);
		}
		catch (NoSuchLinkException noSuchEntityException) {
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
	protected EncyWorkflowLink removeImpl(EncyWorkflowLink encyWorkflowLink) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(encyWorkflowLink)) {
				encyWorkflowLink = (EncyWorkflowLink)session.get(
					EncyWorkflowLinkImpl.class,
					encyWorkflowLink.getPrimaryKeyObj());
			}

			if (encyWorkflowLink != null) {
				session.delete(encyWorkflowLink);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (encyWorkflowLink != null) {
			clearCache(encyWorkflowLink);
		}

		return encyWorkflowLink;
	}

	@Override
	public EncyWorkflowLink updateImpl(EncyWorkflowLink encyWorkflowLink) {
		boolean isNew = encyWorkflowLink.isNew();

		if (!(encyWorkflowLink instanceof EncyWorkflowLinkModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(encyWorkflowLink.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					encyWorkflowLink);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in encyWorkflowLink proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EncyWorkflowLink implementation " +
					encyWorkflowLink.getClass());
		}

		EncyWorkflowLinkModelImpl encyWorkflowLinkModelImpl =
			(EncyWorkflowLinkModelImpl)encyWorkflowLink;

		if (Validator.isNull(encyWorkflowLink.getUuid())) {
			String uuid = _portalUUID.generate();

			encyWorkflowLink.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (encyWorkflowLink.getCreateDate() == null)) {
			if (serviceContext == null) {
				encyWorkflowLink.setCreateDate(date);
			}
			else {
				encyWorkflowLink.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!encyWorkflowLinkModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				encyWorkflowLink.setModifiedDate(date);
			}
			else {
				encyWorkflowLink.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(encyWorkflowLink);
			}
			else {
				encyWorkflowLink = (EncyWorkflowLink)session.merge(
					encyWorkflowLink);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EncyWorkflowLinkImpl.class, encyWorkflowLinkModelImpl, false, true);

		cacheUniqueFindersCache(encyWorkflowLinkModelImpl);

		if (isNew) {
			encyWorkflowLink.setNew(false);
		}

		encyWorkflowLink.resetOriginalValues();

		return encyWorkflowLink;
	}

	/**
	 * Returns the ency workflow link with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ency workflow link
	 * @return the ency workflow link
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	@Override
	public EncyWorkflowLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLinkException {

		EncyWorkflowLink encyWorkflowLink = fetchByPrimaryKey(primaryKey);

		if (encyWorkflowLink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLinkException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return encyWorkflowLink;
	}

	/**
	 * Returns the ency workflow link with the primary key or throws a <code>NoSuchLinkException</code> if it could not be found.
	 *
	 * @param workflowLinkId the primary key of the ency workflow link
	 * @return the ency workflow link
	 * @throws NoSuchLinkException if a ency workflow link with the primary key could not be found
	 */
	@Override
	public EncyWorkflowLink findByPrimaryKey(long workflowLinkId)
		throws NoSuchLinkException {

		return findByPrimaryKey((Serializable)workflowLinkId);
	}

	/**
	 * Returns the ency workflow link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workflowLinkId the primary key of the ency workflow link
	 * @return the ency workflow link, or <code>null</code> if a ency workflow link with the primary key could not be found
	 */
	@Override
	public EncyWorkflowLink fetchByPrimaryKey(long workflowLinkId) {
		return fetchByPrimaryKey((Serializable)workflowLinkId);
	}

	/**
	 * Returns all the ency workflow links.
	 *
	 * @return the ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ency workflow links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ency workflow links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ency workflow links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ency workflow links
	 */
	@Override
	public List<EncyWorkflowLink> findAll(
		int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator,
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

		List<EncyWorkflowLink> list = null;

		if (useFinderCache) {
			list = (List<EncyWorkflowLink>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ENCYWORKFLOWLINK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ENCYWORKFLOWLINK;

				sql = sql.concat(EncyWorkflowLinkModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EncyWorkflowLink>)QueryUtil.list(
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
	 * Removes all the ency workflow links from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EncyWorkflowLink encyWorkflowLink : findAll()) {
			remove(encyWorkflowLink);
		}
	}

	/**
	 * Returns the number of ency workflow links.
	 *
	 * @return the number of ency workflow links
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ENCYWORKFLOWLINK);

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
		return "workflowLinkId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ENCYWORKFLOWLINK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EncyWorkflowLinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ency workflow link persistence.
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

		_finderPathWithPaginationFindByG_C_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId", "companyId", "className"}, true);

		_finderPathWithoutPaginationFindByG_C_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"groupId", "companyId", "className"}, true);

		_finderPathCountByG_C_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"groupId", "companyId", "className"}, false);

		_finderPathWithPaginationCountByG_C_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByG_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"groupId", "companyId", "className"}, false);

		_finderPathWithPaginationFindByC_I = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_I",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"companyId", "workflowId"}, true);

		_finderPathWithoutPaginationFindByC_I = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_I",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"companyId", "workflowId"}, true);

		_finderPathCountByC_I = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_I",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"companyId", "workflowId"}, false);

		_finderPathWithPaginationCountByC_I = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_I",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"companyId", "workflowId"}, false);

		_finderPathWithPaginationFindByWorkflowId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByWorkflowId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"companyId", "workflowId"}, true);

		_finderPathWithoutPaginationFindByWorkflowId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByWorkflowId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"companyId", "workflowId"}, true);

		_finderPathCountByWorkflowId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWorkflowId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"companyId", "workflowId"}, false);

		_finderPathWithPaginationCountByWorkflowId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByWorkflowId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"companyId", "workflowId"}, false);

		_finderPathWithPaginationFindByG_C_C_F_F = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_C_F_F",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {
				"groupId", "companyId", "className", "folderClassName",
				"folderPK"
			},
			true);

		_finderPathWithoutPaginationFindByG_C_C_F_F = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_C_F_F",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			new String[] {
				"groupId", "companyId", "className", "folderClassName",
				"folderPK"
			},
			true);

		_finderPathCountByG_C_C_F_F = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_C_F_F",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			new String[] {
				"groupId", "companyId", "className", "folderClassName",
				"folderPK"
			},
			false);

		_finderPathWithPaginationCountByG_C_C_F_F = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByG_C_C_F_F",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			new String[] {
				"groupId", "companyId", "className", "folderClassName",
				"folderPK"
			},
			false);

		_setEncyWorkflowLinkUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setEncyWorkflowLinkUtilPersistence(null);

		entityCache.removeCache(EncyWorkflowLinkImpl.class.getName());
	}

	private void _setEncyWorkflowLinkUtilPersistence(
		EncyWorkflowLinkPersistence encyWorkflowLinkPersistence) {

		try {
			Field field = EncyWorkflowLinkUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, encyWorkflowLinkPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = EncyWorkflowPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = EncyWorkflowPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = EncyWorkflowPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ENCYWORKFLOWLINK =
		"SELECT encyWorkflowLink FROM EncyWorkflowLink encyWorkflowLink";

	private static final String _SQL_SELECT_ENCYWORKFLOWLINK_WHERE =
		"SELECT encyWorkflowLink FROM EncyWorkflowLink encyWorkflowLink WHERE ";

	private static final String _SQL_COUNT_ENCYWORKFLOWLINK =
		"SELECT COUNT(encyWorkflowLink) FROM EncyWorkflowLink encyWorkflowLink";

	private static final String _SQL_COUNT_ENCYWORKFLOWLINK_WHERE =
		"SELECT COUNT(encyWorkflowLink) FROM EncyWorkflowLink encyWorkflowLink WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "encyWorkflowLink.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EncyWorkflowLink exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EncyWorkflowLink exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EncyWorkflowLinkPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private EncyWorkflowLinkModelArgumentsResolver
		_encyWorkflowLinkModelArgumentsResolver;

}