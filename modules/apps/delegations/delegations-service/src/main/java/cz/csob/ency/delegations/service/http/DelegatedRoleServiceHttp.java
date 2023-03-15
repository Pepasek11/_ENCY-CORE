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

import cz.csob.ency.delegations.service.DelegatedRoleServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>DelegatedRoleServiceUtil</code> service
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
public class DelegatedRoleServiceHttp {

	public static cz.csob.ency.common.json.response.EncyJsonResponse create(
		HttpPrincipal httpPrincipal,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				DelegatedRoleServiceUtil.class, "create",
				_createParameterTypes0);

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

	public static cz.csob.ency.common.json.response.EncyJsonResponse delete(
		HttpPrincipal httpPrincipal, long roleId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				DelegatedRoleServiceUtil.class, "delete",
				_deleteParameterTypes1);

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

	public static cz.csob.ency.common.json.response.EncyJsonResponse getRole(
		HttpPrincipal httpPrincipal, long roleId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				DelegatedRoleServiceUtil.class, "getRole",
				_getRoleParameterTypes2);

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

	public static cz.csob.ency.common.json.response.EncyJsonResponse getRoles(
		HttpPrincipal httpPrincipal,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				DelegatedRoleServiceUtil.class, "getRoles",
				_getRolesParameterTypes3);

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

	public static cz.csob.ency.common.json.response.EncyJsonResponse update(
		HttpPrincipal httpPrincipal, long roleId, String code, String title,
		String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				DelegatedRoleServiceUtil.class, "update",
				_updateParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, roleId, code, title, description, serviceContext);

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
		DelegatedRoleServiceHttp.class);

	private static final Class<?>[] _createParameterTypes0 = new Class[] {
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _deleteParameterTypes1 = new Class[] {
		long.class, com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _getRoleParameterTypes2 = new Class[] {
		long.class, com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _getRolesParameterTypes3 = new Class[] {
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _updateParameterTypes4 = new Class[] {
		long.class, String.class, String.class, String.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};

}