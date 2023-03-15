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

/**
 * Provides the remote service utility for Delegation. This utility wraps
 * <code>cz.csob.ency.delegations.service.impl.DelegationServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Miroslav Čermák
 * @see DelegationService
 * @generated
 */
public class DelegationServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>cz.csob.ency.delegations.service.impl.DelegationServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static cz.csob.ency.common.json.response.EncyJsonResponse create(
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().create(serviceContext);
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse
		deleteDelegation(
			long delegationId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().deleteDelegation(delegationId, serviceContext);
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse
		getDelegation(
			long delegationId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().getDelegation(delegationId, serviceContext);
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse
		getDelegations(
			long roleId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().getDelegations(roleId, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse
		updateDelegation(
			long delegationId, long roleId, long delegatingUserId,
			long delegatedUserId, java.lang.String note,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateDelegation(
			delegationId, roleId, delegatingUserId, delegatedUserId, note,
			serviceContext);
	}

	public static DelegationService getService() {
		return _service;
	}

	private static volatile DelegationService _service;

}