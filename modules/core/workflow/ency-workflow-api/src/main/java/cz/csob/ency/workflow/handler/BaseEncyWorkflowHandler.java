package cz.csob.ency.workflow.handler;

import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import cz.csob.ency.workflow.entry.model.EncyWorkflowedModel;
import cz.csob.ency.workflow.model.EncyWorkflowInstance;
import cz.csob.ency.workflow.model.EncyWorkflowLink;
import cz.csob.ency.workflow.service.EncyWorkflowInstanceLocalServiceUtil;
import cz.csob.ency.workflow.service.EncyWorkflowLinkLocalServiceUtil;
import cz.csob.ency.workflow.util.WorkflowHelperUtils;

import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public abstract class BaseEncyWorkflowHandler<T extends BaseModel<T>> implements EncyWorkflowHandler<T> {
    private static final boolean _ASSET_TYPE_SEARCHABLE = true;
    private static final boolean _SCOPEABLE = true;
    private static final boolean _VISIBLE = true;
    private static final Log _log = LogFactoryUtil.getLog(
            BaseEncyWorkflowHandler.class);

    /*
        @Activate
        public void activateModelListener() {
            _listener = new WorkflowedModelListener(this.getModelClass());
            _log.warn("Registering listener for " + getModelClass());
            ModelListenerRegistrationUtil.register(_listener);
        }

        @Deactivate
        public void deactivateModelListener() {
            ModelListenerRegistrationUtil.unregister(_listener);
        }
    */
    @Override
    public AssetRenderer<T> getAssetRenderer(long classPK)
            throws PortalException {

        AssetRendererFactory<T> assetRendererFactory =
                getAssetRendererFactory();

        if (assetRendererFactory != null) {
            return assetRendererFactory.getAssetRenderer(
                    classPK, AssetRendererFactory.TYPE_LATEST);
        }

        return null;
    }

    @Override
    public AssetRendererFactory<T> getAssetRendererFactory() {
        return (AssetRendererFactory<T>)
                AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(
                        getModelClassName());
    }

    @Override
    public String getIconCssClass() {
        AssetRendererFactory<?> assetRendererFactory =
                getAssetRendererFactory();

        if (assetRendererFactory != null) {
            return assetRendererFactory.getIconCssClass();
        }

        return StringPool.BLANK;
    }

    @Override
    public String getNotificationLink(
            long workflowTaskId, ServiceContext serviceContext)
            throws PortalException {

        try {
            PortletURL portletURL = PortletURLFactoryUtil.create(
                    serviceContext.getRequest(), PortletKeys.MY_WORKFLOW_TASK,
                    PortletRequest.RENDER_PHASE);

            portletURL.setParameter("mvcPath", "/edit_workflow_task.jsp");
            portletURL.setParameter(
                    "workflowTaskId", String.valueOf(workflowTaskId));
            portletURL.setWindowState(WindowState.MAXIMIZED);

            return portletURL.toString();
        } catch (WindowStateException windowStateException) {
            throw new PortalException(windowStateException);
        }
    }

    @Override
    public String getSummary(
            long classPK, PortletRequest portletRequest,
            PortletResponse portletResponse) {

        try {
            AssetRenderer<?> assetRenderer = getAssetRenderer(classPK);

            if (assetRenderer != null) {
                return assetRenderer.getSummary(
                        portletRequest, portletResponse);
            }
        } catch (Exception exception) {
            if (_log.isWarnEnabled()) {
                _log.warn(exception, exception);
            }
        }

        return null;
    }

    @Override
    public String getTitle(long classPK, Locale locale) {
        try {
            AssetRenderer<?> assetRenderer = getAssetRenderer(classPK);

            if (assetRenderer != null) {
                return assetRenderer.getTitle(locale);
            }
        } catch (Exception exception) {
            if (_log.isWarnEnabled()) {
                _log.warn(exception, exception);
            }
        }

        return null;
    }

    @Override
    public PortletURL getURLEdit(
            long classPK, LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse) {

        try {
            AssetRenderer<?> assetRenderer = getAssetRenderer(classPK);

            if (assetRenderer != null) {
                return assetRenderer.getURLEdit(
                        liferayPortletRequest, liferayPortletResponse);
            }
        } catch (Exception exception) {
            if (_log.isWarnEnabled()) {
                _log.warn(exception, exception);
            }
        }

        return null;
    }

    @Override
    public PortletURL getURLViewDiffs(
            long classPK, LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse) {

        try {
            AssetRenderer<?> assetRenderer = getAssetRenderer(classPK);

            if (assetRenderer != null) {
                return assetRenderer.getURLViewDiffs(
                        liferayPortletRequest, liferayPortletResponse);
            }
        } catch (Exception exception) {
            if (_log.isWarnEnabled()) {
                _log.warn(exception, exception);
            }
        }

        return null;
    }

    @Override
    public String getURLViewInContext(
            long classPK, LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            String noSuchEntryRedirect) {

        try {
            AssetRenderer<?> assetRenderer = getAssetRenderer(classPK);

            if (assetRenderer != null) {
                return assetRenderer.getURLViewInContext(
                        liferayPortletRequest, liferayPortletResponse,
                        noSuchEntryRedirect);
            }
        } catch (Exception exception) {
            if (_log.isWarnEnabled()) {
                _log.warn(exception, exception);
            }
        }

        return null;
    }

    /**
     * @throws PortalException
     */
    @Override
    public EncyWorkflowLink getWorkflowLink(
            long companyId, long groupId, long classPK)
            throws PortalException {

        return EncyWorkflowLinkLocalServiceUtil.
                fetchWorkflowLink(companyId, groupId, getModelClassName(), null, 0);
    }

    @Override
    public boolean include(
            long classPK, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, String template) {

        try {
            AssetRenderer<?> assetRenderer = getAssetRenderer(classPK);

            if (assetRenderer != null) {
                return assetRenderer.include(
                        httpServletRequest, httpServletResponse, template);
            }
        } catch (Exception exception) {
            if (_log.isWarnEnabled()) {
                _log.warn(exception, exception);
            }
        }

        return false;
    }

    @Override
    public boolean isAssetTypeSearchable() {
        return _ASSET_TYPE_SEARCHABLE;
    }

    @Override
    public boolean isScopeable() {
        return _SCOPEABLE;
    }

    @Override
    public boolean isVisible() {
        return _VISIBLE;
    }

    @Override
    public EncyWorkflowInstance startWorkflowInstance(
            long companyId, long groupId, long userId, long classPK, T model,
            Map<String, Serializable> workflowContext)
            throws PortalException {

        return EncyWorkflowInstanceLocalServiceUtil.startWorkflowInstance(
                companyId, groupId, userId, getModelClassName(), classPK,
                workflowContext);
    }

    @Override
    public T updateState(T model, String state, Map<String, Serializable> workflowContext) {

        if (model instanceof EncyWorkflowedModel) {
            EncyWorkflowedModel entry = (EncyWorkflowedModel) model;
            long userId = GetterUtil.getLong(
                    (String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
            ServiceContext serviceContext = (ServiceContext) workflowContext.get(
                    WorkflowConstants.CONTEXT_SERVICE_CONTEXT);
            Date now = new Date();

            entry.setState(state);
            entry.setStateByUserId(userId);
            entry.setStateByUserName(WorkflowHelperUtils.getUserName(userId));
            entry.setStateDate(serviceContext==null?now:serviceContext.getModifiedDate(now));

            return (T) entry;
        }
        return model;
    }
}
