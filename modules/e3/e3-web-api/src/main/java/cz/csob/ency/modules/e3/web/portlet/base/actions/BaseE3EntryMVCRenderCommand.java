package cz.csob.ency.modules.e3.web.portlet.base.actions;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.web.context.E3EntriesDisplayContext;
import cz.csob.ency.modules.e3.web.context.E3EntryDisplayContext;
import cz.csob.ency.modules.e3.web.portlet.base.actions.constants.E3RenderCommand;
import cz.csob.ency.modules.e3.web.constants.E3WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.Locale;

public class BaseE3EntryMVCRenderCommand implements MVCRenderCommand {
    private static final Log _log = LogFactoryUtil.getLog(BaseE3EntryMVCRenderCommand.class);

    @Override
    public String render(
            RenderRequest renderRequest, RenderResponse renderResponse)
            throws PortletException {

        Portal _portal = PortalUtil.getPortal();
        E3RenderCommand renderCommand = new E3RenderCommand(renderRequest);

        String mvcPath = mapCommandToPath(renderCommand);
        if (Validator.isBlank(renderCommand.getDefaultPath())) {
            SessionErrors.add(renderRequest, "unknown-command-path", renderCommand);
            _log.warn("Unable to determine path for command " + renderCommand);
            return "/e3/error.jsp";
        }

        boolean useEntryContext = renderCommand.toString().toLowerCase(Locale.ROOT).contains("entry");
        long entryId = ParamUtil.getLong(renderRequest, "entryId");
   //     _log.info("MVC Path: " + mvcPath + " entryId:" + entryId);

        try {
            if(useEntryContext) {
                E3EntryDisplayContext entryDisplayContext = new E3EntryDisplayContext(
                        _portal.getLiferayPortletRequest(renderRequest),
                        _portal.getLiferayPortletResponse(renderResponse));

                renderRequest.setAttribute(
                        E3WebKeys.ENTRY_DISPLAY_CONTEXT,
                        entryDisplayContext);

                E3Entry entry = entryDisplayContext.getEntry();

                ThemeDisplay themeDisplay =
                        (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
/*
            FriendlyURLEntry mainFriendlyURLEntry =
                    FriendlyURLEntryLocalServiceUtil.getMainFriendlyURLEntry(
                            E3Entry.class, entry.getEntryId());

            boolean redirectToLastFriendlyURL = ParamUtil.getBoolean(
                    renderRequest, "redirectToLastFriendlyURL", true);
            String urlTitle = ParamUtil.getString(renderRequest, "urlTitle");

            if (redirectToLastFriendlyURL && Validator.isNotNull(urlTitle) &&
                    !urlTitle.equals(mainFriendlyURLEntry.getUrlTitle())) {

                PortletURL portletURL = renderResponse.createRenderURL();

                portletURL.setParameter(
                        "mvcRenderCommandName", E3RenderCommand.VIEW_ENTRY.toString());
                portletURL.setParameter(
                        "urlTitle", mainFriendlyURLEntry.getUrlTitle());

                HttpServletResponse httpServletResponse =
                        _portal.getHttpServletResponse(renderResponse);

                httpServletResponse.sendRedirect(portletURL.toString());

                return MVCRenderConstants.MVC_PATH_VALUE_SKIP_DISPATCH;
            }
*/
            }else {
                E3EntriesDisplayContext entriesDisplayContext = new E3EntriesDisplayContext(
                        _portal.getLiferayPortletRequest(renderRequest),
                        _portal.getLiferayPortletResponse(renderResponse));

                renderRequest.setAttribute(
                        E3WebKeys.ENTRIES_DISPLAY_CONTEXT,
                        entriesDisplayContext);

            }

        } catch (Exception exception) {
            if (exception instanceof NoSuchE3EntryException ||
                    exception instanceof PrincipalException) {

                SessionErrors.add(renderRequest, exception.getClass());
                _log.warn(exception);
                return "/e3/error.jsp";
            }
            _log.error(exception);

            throw new PortletException(exception);
        }

        return mvcPath;
    }

    /**
     * Override this method to define custom command to path mappings
     *
     * @param renderCommand E3 Render Command
     * @return MVC Path if defined, StringPool.BLANK otherwise
     */
    public String mapCommandToPath(E3RenderCommand renderCommand) {
        return renderCommand.getDefaultPath();
    }
}
