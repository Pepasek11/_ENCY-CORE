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

package cz.csob.ency.workflow.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import cz.csob.ency.workflow.model.EncyWorkflowInstance;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for EncyWorkflowInstance. This utility wraps
 * <code>cz.csob.ency.workflow.service.impl.EncyWorkflowInstanceLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowInstanceLocalService
 * @generated
 */
public class EncyWorkflowInstanceLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>cz.csob.ency.workflow.service.impl.EncyWorkflowInstanceLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the ency workflow instance to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowInstanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowInstance the ency workflow instance
	 * @return the ency workflow instance that was added
	 */
	public static EncyWorkflowInstance addEncyWorkflowInstance(
		EncyWorkflowInstance encyWorkflowInstance) {

		return getService().addEncyWorkflowInstance(encyWorkflowInstance);
	}

	public static EncyWorkflowInstance create() {
		return getService().create();
	}

	/**
	 * Creates a new ency workflow instance with the primary key. Does not add the ency workflow instance to the database.
	 *
	 * @param workflowInstanceId the primary key for the new ency workflow instance
	 * @return the new ency workflow instance
	 */
	public static EncyWorkflowInstance createEncyWorkflowInstance(
		long workflowInstanceId) {

		return getService().createEncyWorkflowInstance(workflowInstanceId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the ency workflow instance from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowInstanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowInstance the ency workflow instance
	 * @return the ency workflow instance that was removed
	 * @throws PortalException
	 */
	public static EncyWorkflowInstance deleteEncyWorkflowInstance(
			EncyWorkflowInstance encyWorkflowInstance)
		throws PortalException {

		return getService().deleteEncyWorkflowInstance(encyWorkflowInstance);
	}

	/**
	 * Deletes the ency workflow instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowInstanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workflowInstanceId the primary key of the ency workflow instance
	 * @return the ency workflow instance that was removed
	 * @throws PortalException if a ency workflow instance with the primary key could not be found
	 */
	public static EncyWorkflowInstance deleteEncyWorkflowInstance(
			long workflowInstanceId)
		throws PortalException {

		return getService().deleteEncyWorkflowInstance(workflowInstanceId);
	}

	public static EncyWorkflowInstance deleteEncyWorkflowInstance(
			String className, long primaryKey)
		throws PortalException {

		return getService().deleteEncyWorkflowInstance(className, primaryKey);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static EncyWorkflowInstance fetchEncyWorkflowInstance(
		long workflowInstanceId) {

		return getService().fetchEncyWorkflowInstance(workflowInstanceId);
	}

	/**
	 * Returns the ency workflow instance matching the UUID and group.
	 *
	 * @param uuid the ency workflow instance's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ency workflow instance, or <code>null</code> if a matching ency workflow instance could not be found
	 */
	public static EncyWorkflowInstance
		fetchEncyWorkflowInstanceByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchEncyWorkflowInstanceByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the ency workflow instance with the primary key.
	 *
	 * @param workflowInstanceId the primary key of the ency workflow instance
	 * @return the ency workflow instance
	 * @throws PortalException if a ency workflow instance with the primary key could not be found
	 */
	public static EncyWorkflowInstance getEncyWorkflowInstance(
			long workflowInstanceId)
		throws PortalException {

		return getService().getEncyWorkflowInstance(workflowInstanceId);
	}

	/**
	 * Returns the ency workflow instance matching the UUID and group.
	 *
	 * @param uuid the ency workflow instance's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ency workflow instance
	 * @throws PortalException if a matching ency workflow instance could not be found
	 */
	public static EncyWorkflowInstance getEncyWorkflowInstanceByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getEncyWorkflowInstanceByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the ency workflow instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @return the range of ency workflow instances
	 */
	public static List<EncyWorkflowInstance> getEncyWorkflowInstances(
		int start, int end) {

		return getService().getEncyWorkflowInstances(start, end);
	}

	/**
	 * Returns all the ency workflow instances matching the UUID and company.
	 *
	 * @param uuid the UUID of the ency workflow instances
	 * @param companyId the primary key of the company
	 * @return the matching ency workflow instances, or an empty list if no matches were found
	 */
	public static List<EncyWorkflowInstance>
		getEncyWorkflowInstancesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getEncyWorkflowInstancesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of ency workflow instances matching the UUID and company.
	 *
	 * @param uuid the UUID of the ency workflow instances
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of ency workflow instances
	 * @param end the upper bound of the range of ency workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching ency workflow instances, or an empty list if no matches were found
	 */
	public static List<EncyWorkflowInstance>
		getEncyWorkflowInstancesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<EncyWorkflowInstance> orderByComparator) {

		return getService().getEncyWorkflowInstancesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of ency workflow instances.
	 *
	 * @return the number of ency workflow instances
	 */
	public static int getEncyWorkflowInstancesCount() {
		return getService().getEncyWorkflowInstancesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static EncyWorkflowInstance getWorkflowInstance(
		long companyId, long groupId, String className, long classPK) {

		return getService().getWorkflowInstance(
			companyId, groupId, className, classPK);
	}

	public static EncyWorkflowInstance getWorkflowInstance(
		String className, long classPK) {

		return getService().getWorkflowInstance(className, classPK);
	}

	public static boolean hasWorkflowInstance(
		long companyId, long groupId, String className, long classPK) {

		return getService().hasWorkflowInstance(
			companyId, groupId, className, classPK);
	}

	public static boolean hasWorkflowInstance(String className, long classPK) {
		return getService().hasWorkflowInstance(className, classPK);
	}

	public static EncyWorkflowInstance startWorkflowInstance(
			long companyId, long groupId, long userId, String className,
			long classPK, Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().startWorkflowInstance(
			companyId, groupId, userId, className, classPK, workflowContext);
	}

	/**
	 * Updates the ency workflow instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowInstanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowInstance the ency workflow instance
	 * @return the ency workflow instance that was updated
	 */
	public static EncyWorkflowInstance updateEncyWorkflowInstance(
		EncyWorkflowInstance encyWorkflowInstance) {

		return getService().updateEncyWorkflowInstance(encyWorkflowInstance);
	}

	public static EncyWorkflowInstanceLocalService getService() {
		return _service;
	}

	private static volatile EncyWorkflowInstanceLocalService _service;

}