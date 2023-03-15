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

import java.util.Map;

/**
 * Provides the remote service utility for CdsDemandGdprInfo. This utility wraps
 * <code>cz.csob.ency.cds.demands.service.impl.CdsDemandGdprInfoServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Miroslav Čermák
 * @see CdsDemandGdprInfoService
 * @generated
 */
public class CdsDemandGdprInfoServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>cz.csob.ency.cds.demands.service.impl.CdsDemandGdprInfoServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static cz.csob.ency.common.json.response.EncyJsonResponse
		deleteEntry(
			long entryId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().deleteEntry(entryId, serviceContext);
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse
		getEntriesByDemandId(
			long demandId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().getEntriesByDemandId(demandId, serviceContext);
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse getEntry(
		long entryId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().getEntry(entryId, serviceContext);
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse
		getInitializedEntry(
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().getInitializedEntry(serviceContext);
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
		updateEntry(
			Map<String, Object> values,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateEntry(values, serviceContext);
	}

	public static CdsDemandGdprInfoService getService() {
		return _service;
	}

	private static volatile CdsDemandGdprInfoService _service;

}