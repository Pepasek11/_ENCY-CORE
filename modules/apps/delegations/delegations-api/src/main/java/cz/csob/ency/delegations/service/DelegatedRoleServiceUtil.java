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
 * Provides the remote service utility for DelegatedRole. This utility wraps
 * <code>cz.csob.ency.delegations.service.impl.DelegatedRoleServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Miroslav Čermák
 * @see DelegatedRoleService
 * @generated
 */
public class DelegatedRoleServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>cz.csob.ency.delegations.service.impl.DelegatedRoleServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static cz.csob.ency.common.json.response.EncyJsonResponse create(
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().create(serviceContext);
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse delete(
		long roleId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().delete(roleId, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse getRole(
		long roleId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().getRole(roleId, serviceContext);
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse getRoles(
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().getRoles(serviceContext);
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse update(
		long roleId, java.lang.String code, java.lang.String title,
		java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().update(
			roleId, code, title, description, serviceContext);
	}

	public static DelegatedRoleService getService() {
		return _service;
	}

	private static volatile DelegatedRoleService _service;

}