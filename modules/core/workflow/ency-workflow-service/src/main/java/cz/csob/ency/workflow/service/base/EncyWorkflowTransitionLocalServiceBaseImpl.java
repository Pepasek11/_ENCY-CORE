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

package cz.csob.ency.workflow.service.base;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import cz.csob.ency.workflow.model.EncyWorkflowTransition;
import cz.csob.ency.workflow.service.EncyWorkflowTransitionLocalService;
import cz.csob.ency.workflow.service.EncyWorkflowTransitionLocalServiceUtil;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowInstancePersistence;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowLinkPersistence;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowPersistence;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowStateInstancePersistence;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowStatePersistence;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowTransitionInstancePersistence;
import cz.csob.ency.workflow.service.persistence.EncyWorkflowTransitionPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the ency workflow transition local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link cz.csob.ency.workflow.service.impl.EncyWorkflowTransitionLocalServiceImpl}.
 * </p>
 *
 * @author Miroslav Čermák
 * @see cz.csob.ency.workflow.service.impl.EncyWorkflowTransitionLocalServiceImpl
 * @generated
 */
public abstract class EncyWorkflowTransitionLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, EncyWorkflowTransitionLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>EncyWorkflowTransitionLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>EncyWorkflowTransitionLocalServiceUtil</code>.
	 */

	/**
	 * Adds the ency workflow transition to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowTransitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowTransition the ency workflow transition
	 * @return the ency workflow transition that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EncyWorkflowTransition addEncyWorkflowTransition(
		EncyWorkflowTransition encyWorkflowTransition) {

		encyWorkflowTransition.setNew(true);

		return encyWorkflowTransitionPersistence.update(encyWorkflowTransition);
	}

	/**
	 * Creates a new ency workflow transition with the primary key. Does not add the ency workflow transition to the database.
	 *
	 * @param transitionId the primary key for the new ency workflow transition
	 * @return the new ency workflow transition
	 */
	@Override
	@Transactional(enabled = false)
	public EncyWorkflowTransition createEncyWorkflowTransition(
		long transitionId) {

		return encyWorkflowTransitionPersistence.create(transitionId);
	}

	/**
	 * Deletes the ency workflow transition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowTransitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param transitionId the primary key of the ency workflow transition
	 * @return the ency workflow transition that was removed
	 * @throws PortalException if a ency workflow transition with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EncyWorkflowTransition deleteEncyWorkflowTransition(
			long transitionId)
		throws PortalException {

		return encyWorkflowTransitionPersistence.remove(transitionId);
	}

	/**
	 * Deletes the ency workflow transition from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowTransitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowTransition the ency workflow transition
	 * @return the ency workflow transition that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EncyWorkflowTransition deleteEncyWorkflowTransition(
		EncyWorkflowTransition encyWorkflowTransition) {

		return encyWorkflowTransitionPersistence.remove(encyWorkflowTransition);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return encyWorkflowTransitionPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			EncyWorkflowTransition.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return encyWorkflowTransitionPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return encyWorkflowTransitionPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return encyWorkflowTransitionPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return encyWorkflowTransitionPersistence.countWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return encyWorkflowTransitionPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public EncyWorkflowTransition fetchEncyWorkflowTransition(
		long transitionId) {

		return encyWorkflowTransitionPersistence.fetchByPrimaryKey(
			transitionId);
	}

	/**
	 * Returns the ency workflow transition with the primary key.
	 *
	 * @param transitionId the primary key of the ency workflow transition
	 * @return the ency workflow transition
	 * @throws PortalException if a ency workflow transition with the primary key could not be found
	 */
	@Override
	public EncyWorkflowTransition getEncyWorkflowTransition(long transitionId)
		throws PortalException {

		return encyWorkflowTransitionPersistence.findByPrimaryKey(transitionId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			encyWorkflowTransitionLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(EncyWorkflowTransition.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("transitionId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			encyWorkflowTransitionLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			EncyWorkflowTransition.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"transitionId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			encyWorkflowTransitionLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(EncyWorkflowTransition.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("transitionId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return encyWorkflowTransitionPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return encyWorkflowTransitionLocalService.deleteEncyWorkflowTransition(
			(EncyWorkflowTransition)persistedModel);
	}

	@Override
	public BasePersistence<EncyWorkflowTransition> getBasePersistence() {
		return encyWorkflowTransitionPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return encyWorkflowTransitionPersistence.findByPrimaryKey(
			primaryKeyObj);
	}

	/**
	 * Returns a range of all the ency workflow transitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowTransitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow transitions
	 * @param end the upper bound of the range of ency workflow transitions (not inclusive)
	 * @return the range of ency workflow transitions
	 */
	@Override
	public List<EncyWorkflowTransition> getEncyWorkflowTransitions(
		int start, int end) {

		return encyWorkflowTransitionPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of ency workflow transitions.
	 *
	 * @return the number of ency workflow transitions
	 */
	@Override
	public int getEncyWorkflowTransitionsCount() {
		return encyWorkflowTransitionPersistence.countAll();
	}

	/**
	 * Updates the ency workflow transition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowTransitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowTransition the ency workflow transition
	 * @return the ency workflow transition that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EncyWorkflowTransition updateEncyWorkflowTransition(
		EncyWorkflowTransition encyWorkflowTransition) {

		return encyWorkflowTransitionPersistence.update(encyWorkflowTransition);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			EncyWorkflowTransitionLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		encyWorkflowTransitionLocalService =
			(EncyWorkflowTransitionLocalService)aopProxy;

		_setLocalServiceUtilService(encyWorkflowTransitionLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return EncyWorkflowTransitionLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return EncyWorkflowTransition.class;
	}

	protected String getModelClassName() {
		return EncyWorkflowTransition.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				encyWorkflowTransitionPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		EncyWorkflowTransitionLocalService encyWorkflowTransitionLocalService) {

		try {
			Field field =
				EncyWorkflowTransitionLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, encyWorkflowTransitionLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected EncyWorkflowPersistence encyWorkflowPersistence;

	@Reference
	protected EncyWorkflowInstancePersistence encyWorkflowInstancePersistence;

	@Reference
	protected EncyWorkflowLinkPersistence encyWorkflowLinkPersistence;

	@Reference
	protected EncyWorkflowStatePersistence encyWorkflowStatePersistence;

	@Reference
	protected EncyWorkflowStateInstancePersistence
		encyWorkflowStateInstancePersistence;

	protected EncyWorkflowTransitionLocalService
		encyWorkflowTransitionLocalService;

	@Reference
	protected EncyWorkflowTransitionPersistence
		encyWorkflowTransitionPersistence;

	@Reference
	protected EncyWorkflowTransitionInstancePersistence
		encyWorkflowTransitionInstancePersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}