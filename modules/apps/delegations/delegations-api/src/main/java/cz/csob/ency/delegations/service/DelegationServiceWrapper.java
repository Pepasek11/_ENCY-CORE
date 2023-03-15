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
 * Provides a wrapper for {@link DelegationService}.
 *
 * @author Miroslav Čermák
 * @see DelegationService
 * @generated
 */
public class DelegationServiceWrapper
	implements DelegationService, ServiceWrapper<DelegationService> {

	public DelegationServiceWrapper() {
		this(null);
	}

	public DelegationServiceWrapper(DelegationService delegationService) {
		_delegationService = delegationService;
	}

	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse create(
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _delegationService.create(serviceContext);
	}

	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse deleteDelegation(
		long delegationId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _delegationService.deleteDelegation(
			delegationId, serviceContext);
	}

	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse getDelegation(
		long delegationId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _delegationService.getDelegation(delegationId, serviceContext);
	}

	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse getDelegations(
		long roleId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _delegationService.getDelegations(roleId, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _delegationService.getOSGiServiceIdentifier();
	}

	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse updateDelegation(
		long delegationId, long roleId, long delegatingUserId,
		long delegatedUserId, String note,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _delegationService.updateDelegation(
			delegationId, roleId, delegatingUserId, delegatedUserId, note,
			serviceContext);
	}

	@Override
	public DelegationService getWrappedService() {
		return _delegationService;
	}

	@Override
	public void setWrappedService(DelegationService delegationService) {
		_delegationService = delegationService;
	}

	private DelegationService _delegationService;

}