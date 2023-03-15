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

import cz.csob.ency.workflow.model.EncyWorkflowLink;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for EncyWorkflowLink. This utility wraps
 * <code>cz.csob.ency.workflow.service.impl.EncyWorkflowLinkLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowLinkLocalService
 * @generated
 */
public class EncyWorkflowLinkLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>cz.csob.ency.workflow.service.impl.EncyWorkflowLinkLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the ency workflow link to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowLink the ency workflow link
	 * @return the ency workflow link that was added
	 */
	public static EncyWorkflowLink addEncyWorkflowLink(
		EncyWorkflowLink encyWorkflowLink) {

		return getService().addEncyWorkflowLink(encyWorkflowLink);
	}

	/**
	 * Adds new workflow link, if there isn't yet.
	 *
	 * @param groupId
	 * @param companyId
	 * @param userId
	 * @param targetClassName
	 * @param folderClassName
	 * @param folderPk
	 * @param workflowId
	 * @return
	 * @throws InvalidEncyWorkflowLinkException
	 */
	public static EncyWorkflowLink addWorkflowLink(
			long groupId, long companyId, long userId, String targetClassName,
			String folderClassName, long folderPk, long workflowId)
		throws cz.csob.ency.workflow.exception.
			InvalidEncyWorkflowLinkException {

		return getService().addWorkflowLink(
			groupId, companyId, userId, targetClassName, folderClassName,
			folderPk, workflowId);
	}

	/**
	 * Adds new workflow link, if there isn't yet.
	 *
	 * @param groupId
	 * @param companyId
	 * @param userId
	 * @param targetClassName
	 * @param folderClassName
	 * @param folderPk
	 * @param workflowClassName
	 * @return
	 * @throws InvalidEncyWorkflowLinkException
	 */
	public static EncyWorkflowLink addWorkflowLink(
			long groupId, long companyId, long userId, String targetClassName,
			String folderClassName, long folderPk, String workflowClassName)
		throws cz.csob.ency.workflow.exception.
			InvalidEncyWorkflowLinkException {

		return getService().addWorkflowLink(
			groupId, companyId, userId, targetClassName, folderClassName,
			folderPk, workflowClassName);
	}

	public static EncyWorkflowLink create() {
		return getService().create();
	}

	/**
	 * Creates a new ency workflow link with the primary key. Does not add the ency workflow link to the database.
	 *
	 * @param workflowLinkId the primary key for the new ency workflow link
	 * @return the new ency workflow link
	 */
	public static EncyWorkflowLink createEncyWorkflowLink(long workflowLinkId) {
		return getService().createEncyWorkflowLink(workflowLinkId);
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
	 * Deletes the ency workflow link from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowLink the ency workflow link
	 * @return the ency workflow link that was removed
	 */
	public static EncyWorkflowLink deleteEncyWorkflowLink(
		EncyWorkflowLink encyWorkflowLink) {

		return getService().deleteEncyWorkflowLink(encyWorkflowLink);
	}

	/**
	 * Deletes the ency workflow link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workflowLinkId the primary key of the ency workflow link
	 * @return the ency workflow link that was removed
	 * @throws PortalException if a ency workflow link with the primary key could not be found
	 */
	public static EncyWorkflowLink deleteEncyWorkflowLink(long workflowLinkId)
		throws PortalException {

		return getService().deleteEncyWorkflowLink(workflowLinkId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowLinkModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowLinkModelImpl</code>.
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

	public static EncyWorkflowLink fetchEncyWorkflowLink(long workflowLinkId) {
		return getService().fetchEncyWorkflowLink(workflowLinkId);
	}

	/**
	 * Returns the ency workflow link matching the UUID and group.
	 *
	 * @param uuid the ency workflow link's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink fetchEncyWorkflowLinkByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchEncyWorkflowLinkByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Fetch workflow definition for given parameters.
	 *
	 * @param groupId         WD applicable for given group. 0 for all groups
	 * @param companyId       WD applicable for given company. 0 for all comapnies
	 * @param className       WD applicable  for given model defind by className.
	 Class Name is mandatory as we do not allow workflow for all models.
	 * @param folderClassName WD applicable for entries in folder defined by @folderClassName and @folderPK
	 * @param folderPk
	 * @return
	 */
	public static EncyWorkflowLink fetchWorkflowLink(
		long groupId, long companyId, String className, String folderClassName,
		long folderPk) {

		return getService().fetchWorkflowLink(
			groupId, companyId, className, folderClassName, folderPk);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the ency workflow link with the primary key.
	 *
	 * @param workflowLinkId the primary key of the ency workflow link
	 * @return the ency workflow link
	 * @throws PortalException if a ency workflow link with the primary key could not be found
	 */
	public static EncyWorkflowLink getEncyWorkflowLink(long workflowLinkId)
		throws PortalException {

		return getService().getEncyWorkflowLink(workflowLinkId);
	}

	/**
	 * Returns the ency workflow link matching the UUID and group.
	 *
	 * @param uuid the ency workflow link's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ency workflow link
	 * @throws PortalException if a matching ency workflow link could not be found
	 */
	public static EncyWorkflowLink getEncyWorkflowLinkByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getEncyWorkflowLinkByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the ency workflow links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cz.csob.ency.workflow.model.impl.EncyWorkflowLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @return the range of ency workflow links
	 */
	public static List<EncyWorkflowLink> getEncyWorkflowLinks(
		int start, int end) {

		return getService().getEncyWorkflowLinks(start, end);
	}

	/**
	 * Returns all the ency workflow links matching the UUID and company.
	 *
	 * @param uuid the UUID of the ency workflow links
	 * @param companyId the primary key of the company
	 * @return the matching ency workflow links, or an empty list if no matches were found
	 */
	public static List<EncyWorkflowLink> getEncyWorkflowLinksByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getEncyWorkflowLinksByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of ency workflow links matching the UUID and company.
	 *
	 * @param uuid the UUID of the ency workflow links
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of ency workflow links
	 * @param end the upper bound of the range of ency workflow links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching ency workflow links, or an empty list if no matches were found
	 */
	public static List<EncyWorkflowLink> getEncyWorkflowLinksByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EncyWorkflowLink> orderByComparator) {

		return getService().getEncyWorkflowLinksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of ency workflow links.
	 *
	 * @return the number of ency workflow links
	 */
	public static int getEncyWorkflowLinksCount() {
		return getService().getEncyWorkflowLinksCount();
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

	/**
	 * Updates the ency workflow link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EncyWorkflowLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param encyWorkflowLink the ency workflow link
	 * @return the ency workflow link that was updated
	 */
	public static EncyWorkflowLink updateEncyWorkflowLink(
		EncyWorkflowLink encyWorkflowLink) {

		return getService().updateEncyWorkflowLink(encyWorkflowLink);
	}

	public static EncyWorkflowLinkLocalService getService() {
		return _service;
	}

	private static volatile EncyWorkflowLinkLocalService _service;

}