package cz.csob.ency.workflow.handler;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.service.ServiceContext;
import cz.csob.ency.workflow.model.EncyWorkflowInstance;
import cz.csob.ency.workflow.model.EncyWorkflowLink;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.NotSupportedException;
import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

public interface EncyWorkflowHandler<T> {

    AssetRenderer<T> getAssetRenderer(long classPK)
            throws PortalException;

    AssetRendererFactory<T> getAssetRendererFactory();

    Class<?> getModelClass();

    default String getModelClassName(){return getModelClass().getName();}

    default String getClassName(){return getModelClass().getName();}

    String getIconCssClass();

    default String getNotificationLink(
            long workflowTaskId, ServiceContext serviceContext)
            throws PortalException {

        return StringPool.BLANK;
    }

    String getSummary(
            long classPK, PortletRequest portletRequest,
            PortletResponse portletResponse);

    String getTitle(long classPK, Locale locale);

    String getType(Locale locale);

    PortletURL getURLEdit(
            long classPK, LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse);

    PortletURL getURLViewDiffs(
            long classPK, LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse);

    String getURLViewInContext(
            long classPK, LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            String noSuchEntryRedirect);

    EncyWorkflowLink getWorkflowLink(
            long companyId, long groupId, long classPK)
            throws PortalException;

    boolean include(
            long classPK, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, String template);

    boolean isAssetTypeSearchable();

    default boolean isCommentable() {
        return true;
    }

    boolean isScopeable();

    boolean isVisible();

    default boolean isVisible(Group group) {
        return isVisible();
    }

    EncyWorkflowInstance startWorkflowInstance(
            long companyId, long groupId, long userId, long classPK, T model,
            Map<String, Serializable> workflowContext)
            throws PortalException;

    T updateModel(T model, ServiceContext serviceContext) throws PortalException;

    default T updateState(String state, Map<String, Serializable> workflowContext)
            throws PortalException {
        throw new NotSupportedException("");
    }

    T updateState(
            T model, String state, Map<String, Serializable> workflowContext)
            throws PortalException;


}
