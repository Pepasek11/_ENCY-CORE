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

import cz.csob.ency.modules.apps.meta.cds.service.ColumnEntryServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>ColumnEntryServiceUtil</code> service
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
public class ColumnEntryServiceHttp {

	public static cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry addEntry(
			HttpPrincipal httpPrincipal,
			cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.modules.apps.meta.cds.exception.
				   ColumnEntryValidateException {

		try {
			MethodKey methodKey = new MethodKey(
				ColumnEntryServiceUtil.class, "addEntry",
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
							ColumnEntryValidateException) {

					throw (cz.csob.ency.modules.apps.meta.cds.exception.
						ColumnEntryValidateException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry)
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
				ColumnEntryServiceUtil.class, "deleteEntry",
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

	public static cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
			getColumnEntry(HttpPrincipal httpPrincipal, long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ColumnEntryServiceUtil.class, "getColumnEntry",
				_getColumnEntryParameterTypes2);

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

			return (cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
			getColumnEntry(
				HttpPrincipal httpPrincipal, long groupId, String urlTitle)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ColumnEntryServiceUtil.class, "getColumnEntry",
				_getColumnEntryParameterTypes3);

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

			return (cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
			getColumnEntryFromRequest(
				HttpPrincipal httpPrincipal, long primaryKey,
				javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		try {
			MethodKey methodKey = new MethodKey(
				ColumnEntryServiceUtil.class, "getColumnEntryFromRequest",
				_getColumnEntryFromRequestParameterTypes4);

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

			return (cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
			getInitializedColumnEntry(
				HttpPrincipal httpPrincipal, long primaryKey,
				javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		try {
			MethodKey methodKey = new MethodKey(
				ColumnEntryServiceUtil.class, "getInitializedColumnEntry",
				_getInitializedColumnEntryParameterTypes5);

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

			return (cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
			getNewObject(
				HttpPrincipal httpPrincipal, long primaryKey,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		try {
			MethodKey methodKey = new MethodKey(
				ColumnEntryServiceUtil.class, "getNewObject",
				_getNewObjectParameterTypes6);

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

			return (cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry> getTableColumns(
				HttpPrincipal httpPrincipal, long tableEntryId)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ColumnEntryServiceUtil.class, "getTableColumns",
				_getTableColumnsParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, tableEntryId);

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

			return (java.util.List
				<cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry>)
					returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
			moveEntryToTrash(HttpPrincipal httpPrincipal, long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ColumnEntryServiceUtil.class, "moveEntryToTrash",
				_moveEntryToTrashParameterTypes8);

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

			return (cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry
			updateEntry(
				HttpPrincipal httpPrincipal,
				cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry orgEntry,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.modules.apps.meta.cds.exception.
				   ColumnEntryValidateException {

		try {
			MethodKey methodKey = new MethodKey(
				ColumnEntryServiceUtil.class, "updateEntry",
				_updateEntryParameterTypes9);

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
							ColumnEntryValidateException) {

					throw (cz.csob.ency.modules.apps.meta.cds.exception.
						ColumnEntryValidateException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		ColumnEntryServiceHttp.class);

	private static final Class<?>[] _addEntryParameterTypes0 = new Class[] {
		cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _deleteEntryParameterTypes1 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getColumnEntryParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[] _getColumnEntryParameterTypes3 =
		new Class[] {long.class, String.class};
	private static final Class<?>[] _getColumnEntryFromRequestParameterTypes4 =
		new Class[] {long.class, javax.portlet.PortletRequest.class};
	private static final Class<?>[] _getInitializedColumnEntryParameterTypes5 =
		new Class[] {long.class, javax.portlet.PortletRequest.class};
	private static final Class<?>[] _getNewObjectParameterTypes6 = new Class[] {
		long.class, com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _getTableColumnsParameterTypes7 =
		new Class[] {long.class};
	private static final Class<?>[] _moveEntryToTrashParameterTypes8 =
		new Class[] {long.class};
	private static final Class<?>[] _updateEntryParameterTypes9 = new Class[] {
		cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};

}