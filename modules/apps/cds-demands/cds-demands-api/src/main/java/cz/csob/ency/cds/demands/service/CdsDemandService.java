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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import cz.csob.ency.cds.demands.exception.CdsDemandValidateException;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.common.json.response.EncyJsonResponse;

import java.util.*;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for CdsDemand. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Miroslav Čermák
 * @see CdsDemandServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CdsDemandService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>cz.csob.ency.cds.demands.service.impl.CdsDemandServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the cds demand remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link CdsDemandServiceUtil} if injection and service tracking are not available.
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
	public CdsDemand addEntry(CdsDemand orgEntry, ServiceContext serviceContext)
		throws CdsDemandValidateException, PortalException;

	/**
	 * Delete Attachment
	 *
	 * @param fileEntryId
	 * @return CdsDemand
	 * @throws PortalException
	 */
	public EncyJsonResponse deleteAttachment(
		long fileEntryId, ServiceContext serviceContext);

	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return CdsDemand
	 * @throws PortalException
	 */
	public EncyJsonResponse deleteEntry(
		long primaryKey, ServiceContext serviceContext);

	public EncyJsonResponse findDemands(
		String[] states, ServiceContext serviceContext);

	public EncyJsonResponse findDomainDemands(
		long userId, Long[] domainId, boolean getLongClosed,
		boolean includeOthersDrafts, ServiceContext serviceContext);

	public EncyJsonResponse findUserActionRequiredDemands(
		long userId, ServiceContext serviceContext);

	public EncyJsonResponse findUserDemands(
		long userId, boolean getLongClosed, ServiceContext serviceContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EncyJsonResponse getAttachments(
		long entryId, ServiceContext serviceContext);

	/**
	 * Returns the cdsdemand with the primary key.
	 *
	 * @param primaryKey the primary key of the sample sb
	 * @return the cdsdemand
	 * @throws PortalException if a cdsdemand with the primary key could not be found
	 * @todo zrusit???
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CdsDemand getCdsDemand(long primaryKey) throws PortalException;

	/**
	 * Returns the cdsdemand with the primary key.
	 *
	 * @param uuid the uuid key of the sample sb
	 * @return the cdsdemand
	 * @throws PortalException if a cdsdemand with the primary key could not be found
	 * @todo zrusit????
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CdsDemand getCdsDemandByUUID(String uuid) throws PortalException;

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return CdsDemand Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CdsDemand getCdsDemandFromRequest(
			long primaryKey, PortletRequest request)
		throws PortalException, PortletException;

	/**
	 * Returns the extended cdsdemand with given primary key.
	 * <p>
	 * Extended info contains metadata and translated select fields to be used in react consumer.
	 *
	 * @param primaryKey the primary key of the sample sb
	 * @return the cdsdemand
	 * @throws PortalException if a cdsdemand with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EncyJsonResponse getExtendedCdsDemand(
			long primaryKey, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return CdsDemand Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CdsDemand getInitializedCdsDemand(PortletRequest request)
		throws PortalException, PortletException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public EncyJsonResponse performTransition(
			long entryId, String transitionName, String comment,
			ServiceContext serviceContext)
		throws PortalException;

	public EncyJsonResponse test(ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Edit Entry
	 *
	 * @param orgEntry       CdsDemand model
	 * @param serviceContext ServiceContext
	 * @return updated CdsDemand model.
	 * @throws PortalException
	 * @throws CdsDemandValidateException
	 */
	public CdsDemand updateEntry(
			CdsDemand orgEntry, ServiceContext serviceContext)
		throws CdsDemandValidateException, PortalException;

}