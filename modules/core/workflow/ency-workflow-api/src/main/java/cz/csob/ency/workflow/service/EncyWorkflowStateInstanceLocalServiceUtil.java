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

import cz.csob.ency.workflow.model.EncyWorkflowStateInstance;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for EncyWorkflowStateInstance. This utility wraps
 * <code>cz.csob.ency.workflow.service.impl.EncyWorkflowStateInstanceLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowStateInstanceLocalService
 * @generated
 */
public class EncyWorkflowStateInstanceLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>cz.csob.ency.workflow.service.impl.EncyWorkflowStateInstanceLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the ency workflow state instance to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowStateInstanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowStateInstance the ency workflow state instance
	 * @return the ency workflow state instance that was added
	 */
	public static EncyWorkflowStateInstance addEncyWorkflowStateInstance(
		EncyWorkflowStateInstance encyWorkflowStateInstance) {

		return getService().addEncyWorkflowStateInstance(
			encyWorkflowStateInstance);
	}

	public static EncyWorkflowStateInstance completeWorkflowStateInstance(
			long stateInstanceId, long userId,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().completeWorkflowStateInstance(
			stateInstanceId, userId, workflowContext);
	}

	public static EncyWorkflowStateInstance create() {
		return getService().create();
	}

	/**
	 * Creates a new ency workflow state instance with the primary key. Does not add the ency workflow state instance to the database.
	 *
	 * @param stateInstanceId the primary key for the new ency workflow state instance
	 * @return the new ency workflow state instance
	 */
	public static EncyWorkflowStateInstance createEncyWorkflowStateInstance(
		long stateInstanceId) {

		return getService().createEncyWorkflowStateInstance(stateInstanceId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static void deleteEncyWorkflowInstanceStateInstances(
		long workflowInstanceId) {

		getService().deleteEncyWorkflowInstanceStateInstances(
			workflowInstanceId);
	}

	/**
	 * Deletes the ency workflow state instance from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowStateInstanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowStateInstance the ency workflow state instance
	 * @return the ency workflow state instance that was removed
	 */
	public static EncyWorkflowStateInstance deleteEncyWorkflowStateInstance(
		EncyWorkflowStateInstance encyWorkflowStateInstance) {

		return getService().deleteEncyWorkflowStateInstance(
			encyWorkflowStateInstance);
	}

	/**
	 * Deletes the ency workflow state instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowStateInstanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stateInstanceId the primary key of the ency workflow state instance
	 * @return the ency workflow state instance that was removed
	 * @throws PortalException if a ency workflow state instance with the primary key could not be found
	 */
	public static EncyWorkflowStateInstance deleteEncyWorkflowStateInstance(
			long stateInstanceId)
		throws PortalException {

		return getService().deleteEncyWorkflowStateInstance(stateInstanceId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowStateInstanceModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowStateInstanceModelImpl</code>.
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

	public static EncyWorkflowStateInstance fetchEncyWorkflowStateInstance(
		long stateInstanceId) {

		return getService().fetchEncyWorkflowStateInstance(stateInstanceId);
	}

	/**
	 * Returns the ency workflow state instance matching the UUID and group.
	 *
	 * @param uuid the ency workflow state instance's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ency workflow state instance, or <code>null</code> if a matching ency workflow state instance could not be found
	 */
	public static EncyWorkflowStateInstance
		fetchEncyWorkflowStateInstanceByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchEncyWorkflowStateInstanceByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static EncyWorkflowStateInstance getCurrentWorkflowStateInstance(
		long workflowInstanceId) {

		return getService().getCurrentWorkflowStateInstance(workflowInstanceId);
	}

	/**
	 * Returns the ency workflow state instance with the primary key.
	 *
	 * @param stateInstanceId the primary key of the ency workflow state instance
	 * @return the ency workflow state instance
	 * @throws PortalException if a ency workflow state instance with the primary key could not be found
	 */
	public static EncyWorkflowStateInstance getEncyWorkflowStateInstance(
			long stateInstanceId)
		throws PortalException {

		return getService().getEncyWorkflowStateInstance(stateInstanceId);
	}

	/**
	 * Returns the ency workflow state instance matching the UUID and group.
	 *
	 * @param uuid the ency workflow state instance's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ency workflow state instance
	 * @throws PortalException if a matching ency workflow state instance could not be found
	 */
	public static EncyWorkflowStateInstance
			getEncyWorkflowStateInstanceByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().getEncyWorkflowStateInstanceByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the ency workflow state instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowStateInstanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @return the range of ency workflow state instances
	 */
	public static List<EncyWorkflowStateInstance> getEncyWorkflowStateInstances(
		int start, int end) {

		return getService().getEncyWorkflowStateInstances(start, end);
	}

	/**
	 * Returns all the ency workflow state instances matching the UUID and company.
	 *
	 * @param uuid the UUID of the ency workflow state instances
	 * @param companyId the primary key of the company
	 * @return the matching ency workflow state instances, or an empty list if no matches were found
	 */
	public static List<EncyWorkflowStateInstance>
		getEncyWorkflowStateInstancesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getEncyWorkflowStateInstancesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of ency workflow state instances matching the UUID and company.
	 *
	 * @param uuid the UUID of the ency workflow state instances
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of ency workflow state instances
	 * @param end the upper bound of the range of ency workflow state instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching ency workflow state instances, or an empty list if no matches were found
	 */
	public static List<EncyWorkflowStateInstance>
		getEncyWorkflowStateInstancesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<EncyWorkflowStateInstance> orderByComparator) {

		return getService().getEncyWorkflowStateInstancesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of ency workflow state instances.
	 *
	 * @return the number of ency workflow state instances
	 */
	public static int getEncyWorkflowStateInstancesCount() {
		return getService().getEncyWorkflowStateInstancesCount();
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

	public static EncyWorkflowStateInstance startWorkflowStateInstance(
		long stateId, long workflowId, long workflowInstanceId, long version,
		long groupId, long companyId, long userId,
		Map<String, Serializable> workflowContext) {

		return getService().startWorkflowStateInstance(
			stateId, workflowId, workflowInstanceId, version, groupId,
			companyId, userId, workflowContext);
	}

	/**
	 * Updates the ency workflow state instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowStateInstanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowStateInstance the ency workflow state instance
	 * @return the ency workflow state instance that was updated
	 */
	public static EncyWorkflowStateInstance updateEncyWorkflowStateInstance(
		EncyWorkflowStateInstance encyWorkflowStateInstance) {

		return getService().updateEncyWorkflowStateInstance(
			encyWorkflowStateInstance);
	}

	public static EncyWorkflowStateInstance updateWorkflowStateInstance(
			long stateInstanceId, long userId,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().updateWorkflowStateInstance(
			stateInstanceId, userId, workflowContext);
	}

	public static EncyWorkflowStateInstanceLocalService getService() {
		return _service;
	}

	private static volatile EncyWorkflowStateInstanceLocalService _service;

}