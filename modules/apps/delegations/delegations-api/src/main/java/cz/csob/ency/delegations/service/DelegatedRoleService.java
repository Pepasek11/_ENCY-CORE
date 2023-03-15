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

package cz.csob.ency.delegations.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import cz.csob.ency.common.json.response.EncyJsonResponse;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for DelegatedRole. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Miroslav Čermák
 * @see DelegatedRoleServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DelegatedRoleService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>cz.csob.ency.delegations.service.impl.DelegatedRoleServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the delegated role remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DelegatedRoleServiceUtil} if injection and service tracking are not available.
	 */
	public EncyJsonResponse create(ServiceContext serviceContext);

	public EncyJsonResponse delete(long roleId, ServiceContext serviceContext);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EncyJsonResponse getRole(long roleId, ServiceContext serviceContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EncyJsonResponse getRoles(ServiceContext serviceContext);

	public EncyJsonResponse update(
		long roleId, String code, String title, String description,
		ServiceContext serviceContext);

}