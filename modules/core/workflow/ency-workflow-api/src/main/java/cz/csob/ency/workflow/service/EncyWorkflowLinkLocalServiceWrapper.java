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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EncyWorkflowLinkLocalService}.
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowLinkLocalService
 * @generated
 */
public class EncyWorkflowLinkLocalServiceWrapper
	implements EncyWorkflowLinkLocalService,
			   ServiceWrapper<EncyWorkflowLinkLocalService> {

	public EncyWorkflowLinkLocalServiceWrapper() {
		this(null);
	}

	public EncyWorkflowLinkLocalServiceWrapper(
		EncyWorkflowLinkLocalService encyWorkflowLinkLocalService) {

		_encyWorkflowLinkLocalService = encyWorkflowLinkLocalService;
	}

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
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowLink addEncyWorkflowLink(
		cz.csob.ency.workflow.model.EncyWorkflowLink encyWorkflowLink) {

		return _encyWorkflowLinkLocalService.addEncyWorkflowLink(
			encyWorkflowLink);
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
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowLink addWorkflowLink(
			long groupId, long companyId, long userId, String targetClassName,
			String folderClassName, long folderPk, long workflowId)
		throws cz.csob.ency.workflow.exception.
			InvalidEncyWorkflowLinkException {

		return _encyWorkflowLinkLocalService.addWorkflowLink(
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
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowLink addWorkflowLink(
			long groupId, long companyId, long userId, String targetClassName,
			String folderClassName, long folderPk, String workflowClassName)
		throws cz.csob.ency.workflow.exception.
			InvalidEncyWorkflowLinkException {

		return _encyWorkflowLinkLocalService.addWorkflowLink(
			groupId, companyId, userId, targetClassName, folderClassName,
			folderPk, workflowClassName);
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowLink create() {
		return _encyWorkflowLinkLocalService.create();
	}

	/**
	 * Creates a new ency workflow link with the primary key. Does not add the ency workflow link to the database.
	 *
	 * @param workflowLinkId the primary key for the new ency workflow link
	 * @return the new ency workflow link
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowLink createEncyWorkflowLink(
		long workflowLinkId) {

		return _encyWorkflowLinkLocalService.createEncyWorkflowLink(
			workflowLinkId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowLinkLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowLink deleteEncyWorkflowLink(
		cz.csob.ency.workflow.model.EncyWorkflowLink encyWorkflowLink) {

		return _encyWorkflowLinkLocalService.deleteEncyWorkflowLink(
			encyWorkflowLink);
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
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowLink deleteEncyWorkflowLink(
			long workflowLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowLinkLocalService.deleteEncyWorkflowLink(
			workflowLinkId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowLinkLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _encyWorkflowLinkLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _encyWorkflowLinkLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _encyWorkflowLinkLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _encyWorkflowLinkLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _encyWorkflowLinkLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _encyWorkflowLinkLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _encyWorkflowLinkLocalService.dynamicQueryCount(dynamicQuery);
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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _encyWorkflowLinkLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowLink fetchEncyWorkflowLink(
		long workflowLinkId) {

		return _encyWorkflowLinkLocalService.fetchEncyWorkflowLink(
			workflowLinkId);
	}

	/**
	 * Returns the ency workflow link matching the UUID and group.
	 *
	 * @param uuid the ency workflow link's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ency workflow link, or <code>null</code> if a matching ency workflow link could not be found
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowLink
		fetchEncyWorkflowLinkByUuidAndGroupId(String uuid, long groupId) {

		return _encyWorkflowLinkLocalService.
			fetchEncyWorkflowLinkByUuidAndGroupId(uuid, groupId);
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
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowLink fetchWorkflowLink(
		long groupId, long companyId, String className, String folderClassName,
		long folderPk) {

		return _encyWorkflowLinkLocalService.fetchWorkflowLink(
			groupId, companyId, className, folderClassName, folderPk);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _encyWorkflowLinkLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the ency workflow link with the primary key.
	 *
	 * @param workflowLinkId the primary key of the ency workflow link
	 * @return the ency workflow link
	 * @throws PortalException if a ency workflow link with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowLink getEncyWorkflowLink(
			long workflowLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowLinkLocalService.getEncyWorkflowLink(
			workflowLinkId);
	}

	/**
	 * Returns the ency workflow link matching the UUID and group.
	 *
	 * @param uuid the ency workflow link's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ency workflow link
	 * @throws PortalException if a matching ency workflow link could not be found
	 */
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowLink
			getEncyWorkflowLinkByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowLinkLocalService.
			getEncyWorkflowLinkByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<cz.csob.ency.workflow.model.EncyWorkflowLink>
		getEncyWorkflowLinks(int start, int end) {

		return _encyWorkflowLinkLocalService.getEncyWorkflowLinks(start, end);
	}

	/**
	 * Returns all the ency workflow links matching the UUID and company.
	 *
	 * @param uuid the UUID of the ency workflow links
	 * @param companyId the primary key of the company
	 * @return the matching ency workflow links, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<cz.csob.ency.workflow.model.EncyWorkflowLink>
		getEncyWorkflowLinksByUuidAndCompanyId(String uuid, long companyId) {

		return _encyWorkflowLinkLocalService.
			getEncyWorkflowLinksByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<cz.csob.ency.workflow.model.EncyWorkflowLink>
		getEncyWorkflowLinksByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<cz.csob.ency.workflow.model.EncyWorkflowLink>
					orderByComparator) {

		return _encyWorkflowLinkLocalService.
			getEncyWorkflowLinksByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of ency workflow links.
	 *
	 * @return the number of ency workflow links
	 */
	@Override
	public int getEncyWorkflowLinksCount() {
		return _encyWorkflowLinkLocalService.getEncyWorkflowLinksCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _encyWorkflowLinkLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _encyWorkflowLinkLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _encyWorkflowLinkLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _encyWorkflowLinkLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public cz.csob.ency.workflow.model.EncyWorkflowLink updateEncyWorkflowLink(
		cz.csob.ency.workflow.model.EncyWorkflowLink encyWorkflowLink) {

		return _encyWorkflowLinkLocalService.updateEncyWorkflowLink(
			encyWorkflowLink);
	}

	@Override
	public EncyWorkflowLinkLocalService getWrappedService() {
		return _encyWorkflowLinkLocalService;
	}

	@Override
	public void setWrappedService(
		EncyWorkflowLinkLocalService encyWorkflowLinkLocalService) {

		_encyWorkflowLinkLocalService = encyWorkflowLinkLocalService;
	}

	private EncyWorkflowLinkLocalService _encyWorkflowLinkLocalService;

}