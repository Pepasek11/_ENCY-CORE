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

import cz.csob.ency.cds.demands.service.CdsDemandServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>CdsDemandServiceUtil</code> service
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
public class CdsDemandServiceHttp {

	public static cz.csob.ency.cds.demands.model.CdsDemand addEntry(
			HttpPrincipal httpPrincipal,
			cz.csob.ency.cds.demands.model.CdsDemand orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.cds.demands.exception.CdsDemandValidateException {

		try {
			MethodKey methodKey = new MethodKey(
				CdsDemandServiceUtil.class, "addEntry",
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
						cz.csob.ency.cds.demands.exception.
							CdsDemandValidateException) {

					throw (cz.csob.ency.cds.demands.exception.
						CdsDemandValidateException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (cz.csob.ency.cds.demands.model.CdsDemand)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse
		deleteAttachment(
			HttpPrincipal httpPrincipal, long fileEntryId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				CdsDemandServiceUtil.class, "deleteAttachment",
				_deleteAttachmentParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fileEntryId, serviceContext);

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
		deleteEntry(
			HttpPrincipal httpPrincipal, long primaryKey,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				CdsDemandServiceUtil.class, "deleteEntry",
				_deleteEntryParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, primaryKey, serviceContext);

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
		findDemands(
			HttpPrincipal httpPrincipal, String[] states,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				CdsDemandServiceUtil.class, "findDemands",
				_findDemandsParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, states, serviceContext);

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
		findDomainDemands(
			HttpPrincipal httpPrincipal, long userId, Long[] domainId,
			boolean getLongClosed, boolean includeOthersDrafts,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				CdsDemandServiceUtil.class, "findDomainDemands",
				_findDomainDemandsParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, domainId, getLongClosed, includeOthersDrafts,
				serviceContext);

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
		findUserActionRequiredDemands(
			HttpPrincipal httpPrincipal, long userId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				CdsDemandServiceUtil.class, "findUserActionRequiredDemands",
				_findUserActionRequiredDemandsParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, serviceContext);

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
		findUserDemands(
			HttpPrincipal httpPrincipal, long userId, boolean getLongClosed,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				CdsDemandServiceUtil.class, "findUserDemands",
				_findUserDemandsParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, getLongClosed, serviceContext);

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
		getAttachments(
			HttpPrincipal httpPrincipal, long entryId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				CdsDemandServiceUtil.class, "getAttachments",
				_getAttachmentsParameterTypes7);

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

	public static cz.csob.ency.cds.demands.model.CdsDemand getCdsDemand(
			HttpPrincipal httpPrincipal, long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CdsDemandServiceUtil.class, "getCdsDemand",
				_getCdsDemandParameterTypes8);

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

			return (cz.csob.ency.cds.demands.model.CdsDemand)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.cds.demands.model.CdsDemand getCdsDemandByUUID(
			HttpPrincipal httpPrincipal, String uuid)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CdsDemandServiceUtil.class, "getCdsDemandByUUID",
				_getCdsDemandByUUIDParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(methodKey, uuid);

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

			return (cz.csob.ency.cds.demands.model.CdsDemand)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.cds.demands.model.CdsDemand
			getCdsDemandFromRequest(
				HttpPrincipal httpPrincipal, long primaryKey,
				javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		try {
			MethodKey methodKey = new MethodKey(
				CdsDemandServiceUtil.class, "getCdsDemandFromRequest",
				_getCdsDemandFromRequestParameterTypes10);

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

			return (cz.csob.ency.cds.demands.model.CdsDemand)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse
			getExtendedCdsDemand(
				HttpPrincipal httpPrincipal, long primaryKey,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CdsDemandServiceUtil.class, "getExtendedCdsDemand",
				_getExtendedCdsDemandParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, primaryKey, serviceContext);

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

			return (cz.csob.ency.common.json.response.EncyJsonResponse)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.cds.demands.model.CdsDemand
			getInitializedCdsDemand(
				HttpPrincipal httpPrincipal,
				javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		try {
			MethodKey methodKey = new MethodKey(
				CdsDemandServiceUtil.class, "getInitializedCdsDemand",
				_getInitializedCdsDemandParameterTypes12);

			MethodHandler methodHandler = new MethodHandler(methodKey, request);

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

			return (cz.csob.ency.cds.demands.model.CdsDemand)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse
			performTransition(
				HttpPrincipal httpPrincipal, long entryId,
				String transitionName, String comment,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CdsDemandServiceUtil.class, "performTransition",
				_performTransitionParameterTypes13);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, entryId, transitionName, comment, serviceContext);

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

			return (cz.csob.ency.common.json.response.EncyJsonResponse)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.common.json.response.EncyJsonResponse test(
			HttpPrincipal httpPrincipal,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CdsDemandServiceUtil.class, "test", _testParameterTypes14);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, serviceContext);

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

			return (cz.csob.ency.common.json.response.EncyJsonResponse)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static cz.csob.ency.cds.demands.model.CdsDemand updateEntry(
			HttpPrincipal httpPrincipal,
			cz.csob.ency.cds.demands.model.CdsDemand orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   cz.csob.ency.cds.demands.exception.CdsDemandValidateException {

		try {
			MethodKey methodKey = new MethodKey(
				CdsDemandServiceUtil.class, "updateEntry",
				_updateEntryParameterTypes15);

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
						cz.csob.ency.cds.demands.exception.
							CdsDemandValidateException) {

					throw (cz.csob.ency.cds.demands.exception.
						CdsDemandValidateException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (cz.csob.ency.cds.demands.model.CdsDemand)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CdsDemandServiceHttp.class);

	private static final Class<?>[] _addEntryParameterTypes0 = new Class[] {
		cz.csob.ency.cds.demands.model.CdsDemand.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _deleteAttachmentParameterTypes1 =
		new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteEntryParameterTypes2 = new Class[] {
		long.class, com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _findDemandsParameterTypes3 = new Class[] {
		String[].class, com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _findDomainDemandsParameterTypes4 =
		new Class[] {
			long.class, Long[].class, boolean.class, boolean.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[]
		_findUserActionRequiredDemandsParameterTypes5 = new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _findUserDemandsParameterTypes6 =
		new Class[] {
			long.class, boolean.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getAttachmentsParameterTypes7 =
		new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getCdsDemandParameterTypes8 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getCdsDemandByUUIDParameterTypes9 =
		new Class[] {String.class};
	private static final Class<?>[] _getCdsDemandFromRequestParameterTypes10 =
		new Class[] {long.class, javax.portlet.PortletRequest.class};
	private static final Class<?>[] _getExtendedCdsDemandParameterTypes11 =
		new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getInitializedCdsDemandParameterTypes12 =
		new Class[] {javax.portlet.PortletRequest.class};
	private static final Class<?>[] _performTransitionParameterTypes13 =
		new Class[] {
			long.class, String.class, String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _testParameterTypes14 = new Class[] {
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _updateEntryParameterTypes15 = new Class[] {
		cz.csob.ency.cds.demands.model.CdsDemand.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};

}