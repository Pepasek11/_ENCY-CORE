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

package cz.csob.ency.delegations.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import cz.csob.ency.delegations.service.DelegationServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>DelegationServiceUtil</code> service
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
public class DelegationServiceHttp {

	public static cz.csob.ency.common.json.response.EncyJsonResponse create(
		HttpPrincipal httpPrincipal,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				DelegationServiceUtil.class, "create", _createParameterTypes0);

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
		deleteDelegation(
			HttpPrincipal httpPrincipal, long delegationId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				DelegationServiceUtil.class, "deleteDelegation",
				_deleteDelegationParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, delegationId, serviceContext);

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
		getDelegation(
			HttpPrincipal httpPrincipal, long delegationId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				DelegationServiceUtil.class, "getDelegation",
				_getDelegationParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, delegationId, serviceContext);

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
		getDelegations(
			HttpPrincipal httpPrincipal, long roleId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				DelegationServiceUtil.class, "getDelegations",
				_getDelegationsParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, roleId, serviceContext);

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
		updateDelegation(
			HttpPrincipal httpPrincipal, long delegationId, long roleId,
			long delegatingUserId, long delegatedUserId, String note,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				DelegationServiceUtil.class, "updateDelegation",
				_updateDelegationParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, delegationId, roleId, delegatingUserId,
				delegatedUserId, note, serviceContext);

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
		DelegationServiceHttp.class);

	private static final Class<?>[] _createParameterTypes0 = new Class[] {
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _deleteDelegationParameterTypes1 =
		new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getDelegationParameterTypes2 =
		new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getDelegationsParameterTypes3 =
		new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _updateDelegationParameterTypes4 =
		new Class[] {
			long.class, long.class, long.class, long.class, String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};

}