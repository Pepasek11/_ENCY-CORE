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

import com.liferay.portal.kernel.exception.PortalException;

import cz.csob.ency.cds.demands.model.CdsDemand;

/**
 * Provides the remote service utility for CdsDemand. This utility wraps
 * <code>cz.csob.ency.cds.demands.service.impl.CdsDemandServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Miroslav Čermák
 * @see CdsDemandService
 * @generated
 */
public class CdsDemandServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>cz.csob.ency.cds.demands.service.impl.CdsDemandServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Add Entry
	 *
	 * @param orgEntry       CdsDemand model
	 * @param serviceContext ServiceContext
	 * @return created CdsDemand model.
	 * @throws PortalException
	 * @throws CdsDemandValidateException
	 */
	public static CdsDemand addEntry(
			CdsDemand orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws cz.csob.ency.cds.demands.exception.CdsDemandValidateException,
			   PortalException {

		return getService().addEntry(orgEntry, serviceContext);
	}

	/**
	 * Delete Attachment
	 *
	 * @param fileEntryId
	 * @return CdsDemand
	 * @throws PortalException
	 */
	public static cz.csob.ency.common.json.response.EncyJsonResponse
		deleteAttachment(
			long fileEntryId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().deleteAttachment(fileEntryId, serviceContext);
	}

	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return CdsDemand
	 * @throws PortalException
	 */
	public static cz.csob.ency.common.json.response.EncyJsonResponse
		deleteEntry(
			long primaryKey,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().deleteEntry(primaryKey, serviceContext);
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse
		findDemands(
			String[] states,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().findDemands(states, serviceContext);
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse
		findDomainDemands(
			long userId, Long[] domainId, boolean getLongClosed,
			boolean includeOthersDrafts,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().findDomainDemands(
			userId, domainId, getLongClosed, includeOthersDrafts,
			serviceContext);
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse
		findUserActionRequiredDemands(
			long userId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().findUserActionRequiredDemands(
			userId, serviceContext);
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse
		findUserDemands(
			long userId, boolean getLongClosed,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().findUserDemands(
			userId, getLongClosed, serviceContext);
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse
		getAttachments(
			long entryId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().getAttachments(entryId, serviceContext);
	}

	/**
	 * Returns the cdsdemand with the primary key.
	 *
	 * @param primaryKey the primary key of the sample sb
	 * @return the cdsdemand
	 * @throws PortalException if a cdsdemand with the primary key could not be found
	 * @todo zrusit???
	 */
	public static CdsDemand getCdsDemand(long primaryKey)
		throws PortalException {

		return getService().getCdsDemand(primaryKey);
	}

	/**
	 * Returns the cdsdemand with the primary key.
	 *
	 * @param uuid the uuid key of the sample sb
	 * @return the cdsdemand
	 * @throws PortalException if a cdsdemand with the primary key could not be found
	 * @todo zrusit????
	 */
	public static CdsDemand getCdsDemandByUUID(String uuid)
		throws PortalException {

		return getService().getCdsDemandByUUID(uuid);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return CdsDemand Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	public static CdsDemand getCdsDemandFromRequest(
			long primaryKey, javax.portlet.PortletRequest request)
		throws javax.portlet.PortletException, PortalException {

		return getService().getCdsDemandFromRequest(primaryKey, request);
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
	public static cz.csob.ency.common.json.response.EncyJsonResponse
			getExtendedCdsDemand(
				long primaryKey,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().getExtendedCdsDemand(primaryKey, serviceContext);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return CdsDemand Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	public static CdsDemand getInitializedCdsDemand(
			javax.portlet.PortletRequest request)
		throws javax.portlet.PortletException, PortalException {

		return getService().getInitializedCdsDemand(request);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse
			performTransition(
				long entryId, String transitionName, String comment,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().performTransition(
			entryId, transitionName, comment, serviceContext);
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse test(
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().test(serviceContext);
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
	public static CdsDemand updateEntry(
			CdsDemand orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws cz.csob.ency.cds.demands.exception.CdsDemandValidateException,
			   PortalException {

		return getService().updateEntry(orgEntry, serviceContext);
	}

	public static CdsDemandService getService() {
		return _service;
	}

	private static volatile CdsDemandService _service;

}