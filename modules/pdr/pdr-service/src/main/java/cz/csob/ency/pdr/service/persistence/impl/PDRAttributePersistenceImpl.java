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

package cz.csob.ency.pdr.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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

import cz.csob.ency.pdr.exception.NoSuchPDRAttributeException;
import cz.csob.ency.pdr.model.PDRAttribute;
import cz.csob.ency.pdr.model.PDRAttributeTable;
import cz.csob.ency.pdr.model.impl.PDRAttributeImpl;
import cz.csob.ency.pdr.model.impl.PDRAttributeModelImpl;
import cz.csob.ency.pdr.service.persistence.PDRAttributePersistence;
import cz.csob.ency.pdr.service.persistence.PDRAttributeUtil;
import cz.csob.ency.pdr.service.persistence.impl.constants.pdrPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the pdr attribute service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @generated
 */
@Component(service = {PDRAttributePersistence.class, BasePersistence.class})
public class PDRAttributePersistenceImpl
	extends BasePersistenceImpl<PDRAttribute>
	implements PDRAttributePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PDRAttributeUtil</code> to access the pdr attribute persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PDRAttributeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PDRAttributePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("order", "order_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PDRAttribute.class);

		setModelImplClass(PDRAttributeImpl.class);
		setModelPKClass(long.class);

		setTable(PDRAttributeTable.INSTANCE);
	}

	/**
	 * Caches the pdr attribute in the entity cache if it is enabled.
	 *
	 * @param pdrAttribute the pdr attribute
	 */
	@Override
	public void cacheResult(PDRAttribute pdrAttribute) {
		entityCache.putResult(
			PDRAttributeImpl.class, pdrAttribute.getPrimaryKey(), pdrAttribute);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the pdr attributes in the entity cache if it is enabled.
	 *
	 * @param pdrAttributes the pdr attributes
	 */
	@Override
	public void cacheResult(List<PDRAttribute> pdrAttributes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (pdrAttributes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PDRAttribute pdrAttribute : pdrAttributes) {
			if (entityCache.getResult(
					PDRAttributeImpl.class, pdrAttribute.getPrimaryKey()) ==
						null) {

				cacheResult(pdrAttribute);
			}
		}
	}

	/**
	 * Clears the cache for all pdr attributes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PDRAttributeImpl.class);

		finderCache.clearCache(PDRAttributeImpl.class);
	}

	/**
	 * Clears the cache for the pdr attribute.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PDRAttribute pdrAttribute) {
		entityCache.removeResult(PDRAttributeImpl.class, pdrAttribute);
	}

	@Override
	public void clearCache(List<PDRAttribute> pdrAttributes) {
		for (PDRAttribute pdrAttribute : pdrAttributes) {
			entityCache.removeResult(PDRAttributeImpl.class, pdrAttribute);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PDRAttributeImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PDRAttributeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new pdr attribute with the primary key. Does not add the pdr attribute to the database.
	 *
	 * @param attributeId the primary key for the new pdr attribute
	 * @return the new pdr attribute
	 */
	@Override
	public PDRAttribute create(long attributeId) {
		PDRAttribute pdrAttribute = new PDRAttributeImpl();

		pdrAttribute.setNew(true);
		pdrAttribute.setPrimaryKey(attributeId);

		pdrAttribute.setCompanyId(CompanyThreadLocal.getCompanyId());

		return pdrAttribute;
	}

	/**
	 * Removes the pdr attribute with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attributeId the primary key of the pdr attribute
	 * @return the pdr attribute that was removed
	 * @throws NoSuchPDRAttributeException if a pdr attribute with the primary key could not be found
	 */
	@Override
	public PDRAttribute remove(long attributeId)
		throws NoSuchPDRAttributeException {

		return remove((Serializable)attributeId);
	}

	/**
	 * Removes the pdr attribute with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pdr attribute
	 * @return the pdr attribute that was removed
	 * @throws NoSuchPDRAttributeException if a pdr attribute with the primary key could not be found
	 */
	@Override
	public PDRAttribute remove(Serializable primaryKey)
		throws NoSuchPDRAttributeException {

		Session session = null;

		try {
			session = openSession();

			PDRAttribute pdrAttribute = (PDRAttribute)session.get(
				PDRAttributeImpl.class, primaryKey);

			if (pdrAttribute == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPDRAttributeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(pdrAttribute);
		}
		catch (NoSuchPDRAttributeException noSuchEntityException) {
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
	protected PDRAttribute removeImpl(PDRAttribute pdrAttribute) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(pdrAttribute)) {
				pdrAttribute = (PDRAttribute)session.get(
					PDRAttributeImpl.class, pdrAttribute.getPrimaryKeyObj());
			}

			if (pdrAttribute != null) {
				session.delete(pdrAttribute);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (pdrAttribute != null) {
			clearCache(pdrAttribute);
		}

		return pdrAttribute;
	}

	@Override
	public PDRAttribute updateImpl(PDRAttribute pdrAttribute) {
		boolean isNew = pdrAttribute.isNew();

		if (!(pdrAttribute instanceof PDRAttributeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(pdrAttribute.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					pdrAttribute);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in pdrAttribute proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PDRAttribute implementation " +
					pdrAttribute.getClass());
		}

		PDRAttributeModelImpl pdrAttributeModelImpl =
			(PDRAttributeModelImpl)pdrAttribute;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (pdrAttribute.getCreateDate() == null)) {
			if (serviceContext == null) {
				pdrAttribute.setCreateDate(date);
			}
			else {
				pdrAttribute.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!pdrAttributeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				pdrAttribute.setModifiedDate(date);
			}
			else {
				pdrAttribute.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(pdrAttribute);
			}
			else {
				pdrAttribute = (PDRAttribute)session.merge(pdrAttribute);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PDRAttributeImpl.class, pdrAttribute, false, true);

		if (isNew) {
			pdrAttribute.setNew(false);
		}

		pdrAttribute.resetOriginalValues();

		return pdrAttribute;
	}

	/**
	 * Returns the pdr attribute with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pdr attribute
	 * @return the pdr attribute
	 * @throws NoSuchPDRAttributeException if a pdr attribute with the primary key could not be found
	 */
	@Override
	public PDRAttribute findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPDRAttributeException {

		PDRAttribute pdrAttribute = fetchByPrimaryKey(primaryKey);

		if (pdrAttribute == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPDRAttributeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return pdrAttribute;
	}

	/**
	 * Returns the pdr attribute with the primary key or throws a <code>NoSuchPDRAttributeException</code> if it could not be found.
	 *
	 * @param attributeId the primary key of the pdr attribute
	 * @return the pdr attribute
	 * @throws NoSuchPDRAttributeException if a pdr attribute with the primary key could not be found
	 */
	@Override
	public PDRAttribute findByPrimaryKey(long attributeId)
		throws NoSuchPDRAttributeException {

		return findByPrimaryKey((Serializable)attributeId);
	}

	/**
	 * Returns the pdr attribute with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attributeId the primary key of the pdr attribute
	 * @return the pdr attribute, or <code>null</code> if a pdr attribute with the primary key could not be found
	 */
	@Override
	public PDRAttribute fetchByPrimaryKey(long attributeId) {
		return fetchByPrimaryKey((Serializable)attributeId);
	}

	/**
	 * Returns all the pdr attributes.
	 *
	 * @return the pdr attributes
	 */
	@Override
	public List<PDRAttribute> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pdr attributes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PDRAttributeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pdr attributes
	 * @param end the upper bound of the range of pdr attributes (not inclusive)
	 * @return the range of pdr attributes
	 */
	@Override
	public List<PDRAttribute> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pdr attributes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PDRAttributeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pdr attributes
	 * @param end the upper bound of the range of pdr attributes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pdr attributes
	 */
	@Override
	public List<PDRAttribute> findAll(
		int start, int end, OrderByComparator<PDRAttribute> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pdr attributes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PDRAttributeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pdr attributes
	 * @param end the upper bound of the range of pdr attributes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pdr attributes
	 */
	@Override
	public List<PDRAttribute> findAll(
		int start, int end, OrderByComparator<PDRAttribute> orderByComparator,
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

		List<PDRAttribute> list = null;

		if (useFinderCache) {
			list = (List<PDRAttribute>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PDRATTRIBUTE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PDRATTRIBUTE;

				sql = sql.concat(PDRAttributeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PDRAttribute>)QueryUtil.list(
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
	 * Removes all the pdr attributes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PDRAttribute pdrAttribute : findAll()) {
			remove(pdrAttribute);
		}
	}

	/**
	 * Returns the number of pdr attributes.
	 *
	 * @return the number of pdr attributes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PDRATTRIBUTE);

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
		return "attributeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PDRATTRIBUTE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PDRAttributeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pdr attribute persistence.
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

		_setPDRAttributeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPDRAttributeUtilPersistence(null);

		entityCache.removeCache(PDRAttributeImpl.class.getName());
	}

	private void _setPDRAttributeUtilPersistence(
		PDRAttributePersistence pdrAttributePersistence) {

		try {
			Field field = PDRAttributeUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, pdrAttributePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = pdrPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = pdrPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = pdrPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PDRATTRIBUTE =
		"SELECT pdrAttribute FROM PDRAttribute pdrAttribute";

	private static final String _SQL_COUNT_PDRATTRIBUTE =
		"SELECT COUNT(pdrAttribute) FROM PDRAttribute pdrAttribute";

	private static final String _ORDER_BY_ENTITY_ALIAS = "pdrAttribute.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PDRAttribute exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PDRAttributePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"order"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PDRAttributeModelArgumentsResolver
		_pdrAttributeModelArgumentsResolver;

}