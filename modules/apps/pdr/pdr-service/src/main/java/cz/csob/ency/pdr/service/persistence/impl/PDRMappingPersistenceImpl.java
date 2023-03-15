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

import cz.csob.ency.pdr.exception.NoSuchPDRMappingException;
import cz.csob.ency.pdr.model.PDRMapping;
import cz.csob.ency.pdr.model.PDRMappingTable;
import cz.csob.ency.pdr.model.impl.PDRMappingImpl;
import cz.csob.ency.pdr.model.impl.PDRMappingModelImpl;
import cz.csob.ency.pdr.service.persistence.PDRMappingPersistence;
import cz.csob.ency.pdr.service.persistence.PDRMappingUtil;
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
 * The persistence implementation for the pdr mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @generated
 */
@Component(service = {PDRMappingPersistence.class, BasePersistence.class})
public class PDRMappingPersistenceImpl
	extends BasePersistenceImpl<PDRMapping> implements PDRMappingPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PDRMappingUtil</code> to access the pdr mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PDRMappingImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PDRMappingPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("state", "state_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PDRMapping.class);

		setModelImplClass(PDRMappingImpl.class);
		setModelPKClass(long.class);

		setTable(PDRMappingTable.INSTANCE);
	}

	/**
	 * Caches the pdr mapping in the entity cache if it is enabled.
	 *
	 * @param pdrMapping the pdr mapping
	 */
	@Override
	public void cacheResult(PDRMapping pdrMapping) {
		entityCache.putResult(
			PDRMappingImpl.class, pdrMapping.getPrimaryKey(), pdrMapping);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the pdr mappings in the entity cache if it is enabled.
	 *
	 * @param pdrMappings the pdr mappings
	 */
	@Override
	public void cacheResult(List<PDRMapping> pdrMappings) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (pdrMappings.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PDRMapping pdrMapping : pdrMappings) {
			if (entityCache.getResult(
					PDRMappingImpl.class, pdrMapping.getPrimaryKey()) == null) {

				cacheResult(pdrMapping);
			}
		}
	}

	/**
	 * Clears the cache for all pdr mappings.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PDRMappingImpl.class);

		finderCache.clearCache(PDRMappingImpl.class);
	}

	/**
	 * Clears the cache for the pdr mapping.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PDRMapping pdrMapping) {
		entityCache.removeResult(PDRMappingImpl.class, pdrMapping);
	}

	@Override
	public void clearCache(List<PDRMapping> pdrMappings) {
		for (PDRMapping pdrMapping : pdrMappings) {
			entityCache.removeResult(PDRMappingImpl.class, pdrMapping);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PDRMappingImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PDRMappingImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new pdr mapping with the primary key. Does not add the pdr mapping to the database.
	 *
	 * @param mappingId the primary key for the new pdr mapping
	 * @return the new pdr mapping
	 */
	@Override
	public PDRMapping create(long mappingId) {
		PDRMapping pdrMapping = new PDRMappingImpl();

		pdrMapping.setNew(true);
		pdrMapping.setPrimaryKey(mappingId);

		pdrMapping.setCompanyId(CompanyThreadLocal.getCompanyId());

		return pdrMapping;
	}

	/**
	 * Removes the pdr mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mappingId the primary key of the pdr mapping
	 * @return the pdr mapping that was removed
	 * @throws NoSuchPDRMappingException if a pdr mapping with the primary key could not be found
	 */
	@Override
	public PDRMapping remove(long mappingId) throws NoSuchPDRMappingException {
		return remove((Serializable)mappingId);
	}

	/**
	 * Removes the pdr mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pdr mapping
	 * @return the pdr mapping that was removed
	 * @throws NoSuchPDRMappingException if a pdr mapping with the primary key could not be found
	 */
	@Override
	public PDRMapping remove(Serializable primaryKey)
		throws NoSuchPDRMappingException {

		Session session = null;

		try {
			session = openSession();

			PDRMapping pdrMapping = (PDRMapping)session.get(
				PDRMappingImpl.class, primaryKey);

			if (pdrMapping == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPDRMappingException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(pdrMapping);
		}
		catch (NoSuchPDRMappingException noSuchEntityException) {
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
	protected PDRMapping removeImpl(PDRMapping pdrMapping) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(pdrMapping)) {
				pdrMapping = (PDRMapping)session.get(
					PDRMappingImpl.class, pdrMapping.getPrimaryKeyObj());
			}

			if (pdrMapping != null) {
				session.delete(pdrMapping);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (pdrMapping != null) {
			clearCache(pdrMapping);
		}

		return pdrMapping;
	}

	@Override
	public PDRMapping updateImpl(PDRMapping pdrMapping) {
		boolean isNew = pdrMapping.isNew();

		if (!(pdrMapping instanceof PDRMappingModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(pdrMapping.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(pdrMapping);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in pdrMapping proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PDRMapping implementation " +
					pdrMapping.getClass());
		}

		PDRMappingModelImpl pdrMappingModelImpl =
			(PDRMappingModelImpl)pdrMapping;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (pdrMapping.getCreateDate() == null)) {
			if (serviceContext == null) {
				pdrMapping.setCreateDate(date);
			}
			else {
				pdrMapping.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!pdrMappingModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				pdrMapping.setModifiedDate(date);
			}
			else {
				pdrMapping.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(pdrMapping);
			}
			else {
				pdrMapping = (PDRMapping)session.merge(pdrMapping);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(PDRMappingImpl.class, pdrMapping, false, true);

		if (isNew) {
			pdrMapping.setNew(false);
		}

		pdrMapping.resetOriginalValues();

		return pdrMapping;
	}

	/**
	 * Returns the pdr mapping with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pdr mapping
	 * @return the pdr mapping
	 * @throws NoSuchPDRMappingException if a pdr mapping with the primary key could not be found
	 */
	@Override
	public PDRMapping findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPDRMappingException {

		PDRMapping pdrMapping = fetchByPrimaryKey(primaryKey);

		if (pdrMapping == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPDRMappingException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return pdrMapping;
	}

	/**
	 * Returns the pdr mapping with the primary key or throws a <code>NoSuchPDRMappingException</code> if it could not be found.
	 *
	 * @param mappingId the primary key of the pdr mapping
	 * @return the pdr mapping
	 * @throws NoSuchPDRMappingException if a pdr mapping with the primary key could not be found
	 */
	@Override
	public PDRMapping findByPrimaryKey(long mappingId)
		throws NoSuchPDRMappingException {

		return findByPrimaryKey((Serializable)mappingId);
	}

	/**
	 * Returns the pdr mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mappingId the primary key of the pdr mapping
	 * @return the pdr mapping, or <code>null</code> if a pdr mapping with the primary key could not be found
	 */
	@Override
	public PDRMapping fetchByPrimaryKey(long mappingId) {
		return fetchByPrimaryKey((Serializable)mappingId);
	}

	/**
	 * Returns all the pdr mappings.
	 *
	 * @return the pdr mappings
	 */
	@Override
	public List<PDRMapping> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pdr mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PDRMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pdr mappings
	 * @param end the upper bound of the range of pdr mappings (not inclusive)
	 * @return the range of pdr mappings
	 */
	@Override
	public List<PDRMapping> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pdr mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PDRMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pdr mappings
	 * @param end the upper bound of the range of pdr mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pdr mappings
	 */
	@Override
	public List<PDRMapping> findAll(
		int start, int end, OrderByComparator<PDRMapping> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pdr mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PDRMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pdr mappings
	 * @param end the upper bound of the range of pdr mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pdr mappings
	 */
	@Override
	public List<PDRMapping> findAll(
		int start, int end, OrderByComparator<PDRMapping> orderByComparator,
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

		List<PDRMapping> list = null;

		if (useFinderCache) {
			list = (List<PDRMapping>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PDRMAPPING);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PDRMAPPING;

				sql = sql.concat(PDRMappingModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PDRMapping>)QueryUtil.list(
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
	 * Removes all the pdr mappings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PDRMapping pdrMapping : findAll()) {
			remove(pdrMapping);
		}
	}

	/**
	 * Returns the number of pdr mappings.
	 *
	 * @return the number of pdr mappings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PDRMAPPING);

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
		return "mappingId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PDRMAPPING;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PDRMappingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pdr mapping persistence.
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

		_setPDRMappingUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPDRMappingUtilPersistence(null);

		entityCache.removeCache(PDRMappingImpl.class.getName());
	}

	private void _setPDRMappingUtilPersistence(
		PDRMappingPersistence pdrMappingPersistence) {

		try {
			Field field = PDRMappingUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, pdrMappingPersistence);
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

	private static final String _SQL_SELECT_PDRMAPPING =
		"SELECT pdrMapping FROM PDRMapping pdrMapping";

	private static final String _SQL_COUNT_PDRMAPPING =
		"SELECT COUNT(pdrMapping) FROM PDRMapping pdrMapping";

	private static final String _ORDER_BY_ENTITY_ALIAS = "pdrMapping.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PDRMapping exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PDRMappingPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"state"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PDRMappingModelArgumentsResolver _pdrMappingModelArgumentsResolver;

}