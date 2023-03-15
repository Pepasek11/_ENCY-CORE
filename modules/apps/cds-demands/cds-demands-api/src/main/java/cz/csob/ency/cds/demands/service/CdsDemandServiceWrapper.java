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

package cz.csob.ency.cds.demands.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CdsDemandService}.
 *
 * @author Miroslav Čermák
 * @see CdsDemandService
 * @generated
 */
public class CdsDemandServiceWrapper
	implements CdsDemandService, ServiceWrapper<CdsDemandService> {

	public CdsDemandServiceWrapper() {
		this(null);
	}

	public CdsDemandServiceWrapper(CdsDemandService cdsDemandService) {
		_cdsDemandService = cdsDemandService;
	}

	/**
	 * Add Entry
	 *
	 * @param orgEntry       CdsDemand model
	 * @param serviceContext ServiceContext
	 * @return created CdsDemand model.
	 * @throws PortalException
	 * @throws CdsDemandValidateException
	 */
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand addEntry(
			cz.csob.ency.cds.demands.model.CdsDemand orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.cds.demands.exception.CdsDemandValidateException {

		return _cdsDemandService.addEntry(orgEntry, serviceContext);
	}

	/**
	 * Delete Attachment
	 *
	 * @param fileEntryId
	 * @return CdsDemand
	 * @throws PortalException
	 */
	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse deleteAttachment(
		long fileEntryId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _cdsDemandService.deleteAttachment(fileEntryId, serviceContext);
	}

	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return CdsDemand
	 * @throws PortalException
	 */
	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse deleteEntry(
		long primaryKey,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _cdsDemandService.deleteEntry(primaryKey, serviceContext);
	}

	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse findDemands(
		String[] states,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _cdsDemandService.findDemands(states, serviceContext);
	}

	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse findDomainDemands(
		long userId, Long[] domainId, boolean getLongClosed,
		boolean includeOthersDrafts,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _cdsDemandService.findDomainDemands(
			userId, domainId, getLongClosed, includeOthersDrafts,
			serviceContext);
	}

	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse
		findUserActionRequiredDemands(
			long userId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _cdsDemandService.findUserActionRequiredDemands(
			userId, serviceContext);
	}

	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse findUserDemands(
		long userId, boolean getLongClosed,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _cdsDemandService.findUserDemands(
			userId, getLongClosed, serviceContext);
	}

	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse getAttachments(
		long entryId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _cdsDemandService.getAttachments(entryId, serviceContext);
	}

	/**
	 * Returns the cdsdemand with the primary key.
	 *
	 * @param primaryKey the primary key of the sample sb
	 * @return the cdsdemand
	 * @throws PortalException if a cdsdemand with the primary key could not be found
	 * @todo zrusit???
	 */
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand getCdsDemand(
			long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandService.getCdsDemand(primaryKey);
	}

	/**
	 * Returns the cdsdemand with the primary key.
	 *
	 * @param uuid the uuid key of the sample sb
	 * @return the cdsdemand
	 * @throws PortalException if a cdsdemand with the primary key could not be found
	 * @todo zrusit????
	 */
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand getCdsDemandByUUID(
			String uuid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandService.getCdsDemandByUUID(uuid);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return CdsDemand Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand getCdsDemandFromRequest(
			long primaryKey, javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		return _cdsDemandService.getCdsDemandFromRequest(primaryKey, request);
	}

	/**
	 * Returns the extended cdsdemand with given primary key.
	 * <p>
	 * Extended info contains metadata and translated select fields to be used in react consumer.
	 *
	 * @param primaryKey the primary key of the sample sb
	 * @return the cdsdemand
	 * @throws PortalException if a cdsdemand with the primary key could not be found
	 */
	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse
			getExtendedCdsDemand(
				long primaryKey,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandService.getExtendedCdsDemand(
			primaryKey, serviceContext);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return CdsDemand Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand getInitializedCdsDemand(
			javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		return _cdsDemandService.getInitializedCdsDemand(request);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cdsDemandService.getOSGiServiceIdentifier();
	}

	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse performTransition(
			long entryId, String transitionName, String comment,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandService.performTransition(
			entryId, transitionName, comment, serviceContext);
	}

	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse test(
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cdsDemandService.test(serviceContext);
	}

	/**
	 * Edit Entry
	 *
	 * @param orgEntry       CdsDemand model
	 * @param serviceContext ServiceContext
	 * @return updated CdsDemand model.
	 * @throws PortalException
	 * @throws CdsDemandValidateException
	 */
	@Override
	public cz.csob.ency.cds.demands.model.CdsDemand updateEntry(
			cz.csob.ency.cds.demands.model.CdsDemand orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.cds.demands.exception.CdsDemandValidateException {

		return _cdsDemandService.updateEntry(orgEntry, serviceContext);
	}

	@Override
	public CdsDemandService getWrappedService() {
		return _cdsDemandService;
	}

	@Override
	public void setWrappedService(CdsDemandService cdsDemandService) {
		_cdsDemandService = cdsDemandService;
	}

	private CdsDemandService _cdsDemandService;

}