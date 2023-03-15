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
 * Provides a wrapper for {@link CdsDemandGdprInfoService}.
 *
 * @author Miroslav Čermák
 * @see CdsDemandGdprInfoService
 * @generated
 */
public class CdsDemandGdprInfoServiceWrapper
	implements CdsDemandGdprInfoService,
			   ServiceWrapper<CdsDemandGdprInfoService> {

	public CdsDemandGdprInfoServiceWrapper() {
		this(null);
	}

	public CdsDemandGdprInfoServiceWrapper(
		CdsDemandGdprInfoService cdsDemandGdprInfoService) {

		_cdsDemandGdprInfoService = cdsDemandGdprInfoService;
	}

	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse deleteEntry(
		long entryId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _cdsDemandGdprInfoService.deleteEntry(entryId, serviceContext);
	}

	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse
		getEntriesByDemandId(
			long demandId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _cdsDemandGdprInfoService.getEntriesByDemandId(
			demandId, serviceContext);
	}

	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse getEntry(
		long entryId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _cdsDemandGdprInfoService.getEntry(entryId, serviceContext);
	}

	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse
		getInitializedEntry(
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _cdsDemandGdprInfoService.getInitializedEntry(serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cdsDemandGdprInfoService.getOSGiServiceIdentifier();
	}

	@Override
	public cz.csob.ency.common.json.response.EncyJsonResponse updateEntry(
		java.util.Map<String, Object> values,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _cdsDemandGdprInfoService.updateEntry(values, serviceContext);
	}

	@Override
	public CdsDemandGdprInfoService getWrappedService() {
		return _cdsDemandGdprInfoService;
	}

	@Override
	public void setWrappedService(
		CdsDemandGdprInfoService cdsDemandGdprInfoService) {

		_cdsDemandGdprInfoService = cdsDemandGdprInfoService;
	}

	private CdsDemandGdprInfoService _cdsDemandGdprInfoService;

}