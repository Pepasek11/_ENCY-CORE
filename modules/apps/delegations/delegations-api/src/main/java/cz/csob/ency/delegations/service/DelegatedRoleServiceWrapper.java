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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DelegatedRoleService}.
 *
 * @author Miroslav Čermák
 * @see DelegatedRoleService
 * @generated
 */
public class DelegatedRoleServiceWrapper
	implements DelegatedRoleService, ServiceWrapper<DelegatedRoleService> {

	public DelegatedRoleServiceWrapper() {
		this(null);
	}

	public DelegatedRoleServiceWrapper(
		DelegatedRoleService delegatedRoleService) {

		_delegatedRoleService = delegatedRoleService;
	}

	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse create(
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _delegatedRoleService.create(serviceContext);
	}

	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse delete(
		long roleId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _delegatedRoleService.delete(roleId, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _delegatedRoleService.getOSGiServiceIdentifier();
	}

	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse getRole(
		long roleId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _delegatedRoleService.getRole(roleId, serviceContext);
	}

	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse getRoles(
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _delegatedRoleService.getRoles(serviceContext);
	}

	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse update(
		long roleId, String code, String title, String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _delegatedRoleService.update(
			roleId, code, title, description, serviceContext);
	}

	@Override
	public DelegatedRoleService getWrappedService() {
		return _delegatedRoleService;
	}

	@Override
	public void setWrappedService(DelegatedRoleService delegatedRoleService) {
		_delegatedRoleService = delegatedRoleService;
	}

	private DelegatedRoleService _delegatedRoleService;

}