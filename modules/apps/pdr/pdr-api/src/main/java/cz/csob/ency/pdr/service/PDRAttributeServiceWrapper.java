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
 * Provides a wrapper for {@link PDRAttributeService}.
 *
 * @author Miroslav Čermák
 * @see PDRAttributeService
 * @generated
 */
public class PDRAttributeServiceWrapper
	implements PDRAttributeService, ServiceWrapper<PDRAttributeService> {

	public PDRAttributeServiceWrapper() {
		this(null);
	}

	public PDRAttributeServiceWrapper(PDRAttributeService pdrAttributeService) {
		_pdrAttributeService = pdrAttributeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _pdrAttributeService.getOSGiServiceIdentifier();
	}

	@Override
	public PDRAttributeService getWrappedService() {
		return _pdrAttributeService;
	}

	@Override
	public void setWrappedService(PDRAttributeService pdrAttributeService) {
		_pdrAttributeService = pdrAttributeService;
	}

	private PDRAttributeService _pdrAttributeService;

}