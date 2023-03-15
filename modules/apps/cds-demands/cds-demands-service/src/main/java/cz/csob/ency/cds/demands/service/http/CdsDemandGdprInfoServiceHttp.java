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

package cz.csob.ency.cds.demands.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import cz.csob.ency.cds.demands.service.CdsDemandGdprInfoServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>CdsDemandGdprInfoServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Miroslav Čermák
 * @generated
 */
public class CdsDemandGdprInfoServiceHttp {

	public static cz.csob.ency.common.json.response.EncyJsonResponse
		deleteEntry(
			HttpPrincipal httpPrincipal, long entryId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				CdsDemandGdprInfoServiceUtil.class, "deleteEntry",
				_deleteEntryParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, entryId, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (cz.csob.ency.common.json.response.EncyJsonResponse)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse
		getEntriesByDemandId(
			HttpPrincipal httpPrincipal, long demandId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				CdsDemandGdprInfoServiceUtil.class, "getEntriesByDemandId",
				_getEntriesByDemandIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, demandId, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (cz.csob.ency.common.json.response.EncyJsonResponse)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse getEntry(
		HttpPrincipal httpPrincipal, long entryId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				CdsDemandGdprInfoServiceUtil.class, "getEntry",
				_getEntryParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, entryId, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (cz.csob.ency.common.json.response.EncyJsonResponse)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse
		getInitializedEntry(
			HttpPrincipal httpPrincipal,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				CdsDemandGdprInfoServiceUtil.class, "getInitializedEntry",
				_getInitializedEntryParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (cz.csob.ency.common.json.response.EncyJsonResponse)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse
		updateEntry(
			HttpPrincipal httpPrincipal, java.util.Map<String, Object> values,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				CdsDemandGdprInfoServiceUtil.class, "updateEntry",
				_updateEntryParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, values, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (cz.csob.ency.common.json.response.EncyJsonResponse)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		CdsDemandGdprInfoServiceHttp.class);

	private static final Class<?>[] _deleteEntryParameterTypes0 = new Class[] {
		long.class, com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _getEntriesByDemandIdParameterTypes1 =
		new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getEntryParameterTypes4 = new Class[] {
		long.class, com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _getInitializedEntryParameterTypes5 =
		new Class[] {com.liferay.portal.kernel.service.ServiceContext.class};
	private static final Class<?>[] _updateEntryParameterTypes6 = new Class[] {
		java.util.Map.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};

}