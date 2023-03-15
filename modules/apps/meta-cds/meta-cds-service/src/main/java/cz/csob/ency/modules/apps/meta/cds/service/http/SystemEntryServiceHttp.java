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

package cz.csob.ency.modules.apps.meta.cds.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import cz.csob.ency.modules.apps.meta.cds.service.SystemEntryServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>SystemEntryServiceUtil</code> service
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
 * @author "Miroslav Čermák"
 * @generated
 */
public class SystemEntryServiceHttp {

	public static cz.csob.ency.modules.apps.meta.cds.model.SystemEntry addEntry(
			HttpPrincipal httpPrincipal,
			cz.csob.ency.modules.apps.meta.cds.model.SystemEntry orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.modules.apps.meta.cds.exception.
				   SystemEntryValidateException {

		try {
			MethodKey methodKey = new MethodKey(
				SystemEntryServiceUtil.class, "addEntry",
				_addEntryParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, orgEntry, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				if (exception instanceof
						cz.csob.ency.modules.apps.meta.cds.exception.
							SystemEntryValidateException) {

					throw (cz.csob.ency.modules.apps.meta.cds.exception.
						SystemEntryValidateException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (cz.csob.ency.modules.apps.meta.cds.model.SystemEntry)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void deleteEntry(HttpPrincipal httpPrincipal, long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SystemEntryServiceUtil.class, "deleteEntry",
				_deleteEntryParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, primaryKey);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
			getInitializedSystemEntry(
				HttpPrincipal httpPrincipal, long primaryKey,
				javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		try {
			MethodKey methodKey = new MethodKey(
				SystemEntryServiceUtil.class, "getInitializedSystemEntry",
				_getInitializedSystemEntryParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, primaryKey, request);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				if (exception instanceof javax.portlet.PortletException) {
					throw (javax.portlet.PortletException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (cz.csob.ency.modules.apps.meta.cds.model.SystemEntry)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
			getNewObject(
				HttpPrincipal httpPrincipal, long primaryKey,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		try {
			MethodKey methodKey = new MethodKey(
				SystemEntryServiceUtil.class, "getNewObject",
				_getNewObjectParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, primaryKey, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.security.auth.
							PrincipalException) {

					throw (com.liferay.portal.kernel.security.auth.
						PrincipalException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (cz.csob.ency.modules.apps.meta.cds.model.SystemEntry)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
			getSystemEntry(HttpPrincipal httpPrincipal, long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SystemEntryServiceUtil.class, "getSystemEntry",
				_getSystemEntryParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, primaryKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (cz.csob.ency.modules.apps.meta.cds.model.SystemEntry)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
			getSystemEntry(
				HttpPrincipal httpPrincipal, long groupId, String urlTitle)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SystemEntryServiceUtil.class, "getSystemEntry",
				_getSystemEntryParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, urlTitle);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (cz.csob.ency.modules.apps.meta.cds.model.SystemEntry)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
			getSystemEntryFromRequest(
				HttpPrincipal httpPrincipal, long primaryKey,
				javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		try {
			MethodKey methodKey = new MethodKey(
				SystemEntryServiceUtil.class, "getSystemEntryFromRequest",
				_getSystemEntryFromRequestParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, primaryKey, request);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				if (exception instanceof javax.portlet.PortletException) {
					throw (javax.portlet.PortletException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (cz.csob.ency.modules.apps.meta.cds.model.SystemEntry)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
			moveEntryToTrash(HttpPrincipal httpPrincipal, long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SystemEntryServiceUtil.class, "moveEntryToTrash",
				_moveEntryToTrashParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey, entryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (cz.csob.ency.modules.apps.meta.cds.model.SystemEntry)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.modules.apps.meta.cds.model.SystemEntry
			updateEntry(
				HttpPrincipal httpPrincipal,
				cz.csob.ency.modules.apps.meta.cds.model.SystemEntry orgEntry,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.modules.apps.meta.cds.exception.
				   SystemEntryValidateException {

		try {
			MethodKey methodKey = new MethodKey(
				SystemEntryServiceUtil.class, "updateEntry",
				_updateEntryParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, orgEntry, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				if (exception instanceof
						cz.csob.ency.modules.apps.meta.cds.exception.
							SystemEntryValidateException) {

					throw (cz.csob.ency.modules.apps.meta.cds.exception.
						SystemEntryValidateException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (cz.csob.ency.modules.apps.meta.cds.model.SystemEntry)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry> getSystemEntries(
			HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				SystemEntryServiceUtil.class, "getSystemEntries",
				_getSystemEntriesParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<cz.csob.ency.modules.apps.meta.cds.model.SystemEntry>)
					returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		SystemEntryServiceHttp.class);

	private static final Class<?>[] _addEntryParameterTypes0 = new Class[] {
		cz.csob.ency.modules.apps.meta.cds.model.SystemEntry.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _deleteEntryParameterTypes1 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getInitializedSystemEntryParameterTypes2 =
		new Class[] {long.class, javax.portlet.PortletRequest.class};
	private static final Class<?>[] _getNewObjectParameterTypes3 = new Class[] {
		long.class, com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _getSystemEntryParameterTypes4 =
		new Class[] {long.class};
	private static final Class<?>[] _getSystemEntryParameterTypes5 =
		new Class[] {long.class, String.class};
	private static final Class<?>[] _getSystemEntryFromRequestParameterTypes6 =
		new Class[] {long.class, javax.portlet.PortletRequest.class};
	private static final Class<?>[] _moveEntryToTrashParameterTypes7 =
		new Class[] {long.class};
	private static final Class<?>[] _updateEntryParameterTypes8 = new Class[] {
		cz.csob.ency.modules.apps.meta.cds.model.SystemEntry.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _getSystemEntriesParameterTypes9 =
		new Class[] {};

}