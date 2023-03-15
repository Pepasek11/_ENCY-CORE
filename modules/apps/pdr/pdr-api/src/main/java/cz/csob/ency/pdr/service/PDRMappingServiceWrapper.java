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

package cz.csob.ency.pdr.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PDRMappingService}.
 *
 * @author Miroslav Čermák
 * @see PDRMappingService
 * @generated
 */
public class PDRMappingServiceWrapper
	implements PDRMappingService, ServiceWrapper<PDRMappingService> {

	public PDRMappingServiceWrapper() {
		this(null);
	}

	public PDRMappingServiceWrapper(PDRMappingService pdrMappingService) {
		_pdrMappingService = pdrMappingService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _pdrMappingService.getOSGiServiceIdentifier();
	}

	@Override
	public PDRMappingService getWrappedService() {
		return _pdrMappingService;
	}

	@Override
	public void setWrappedService(PDRMappingService pdrMappingService) {
		_pdrMappingService = pdrMappingService;
	}

	private PDRMappingService _pdrMappingService;

}