package cz.csob.ency.modules.e3.web.portlet.base;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.*;
import java.io.IOException;

public class BaseE3Portlet extends MVCPortlet {
    private static final Log _log = LogFactoryUtil.getLog(BaseE3Portlet.class);
/*
    @Override
    public void init() throws PortletException {
        super.init();

        if (Validator.isBlank(viewTemplate)) {
            viewTemplate = "/e3/view_entry.jsp";
        }
        if (Validator.isBlank(editTemplate)) {
            editTemplate = "/e3/edit_entry.jsp";
        }
    }
*/
    @Override
    public void render(
            RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {


        String mvcRenderCommandName = ParamUtil.getString(
                renderRequest, "mvcRenderCommandName", "/");
        String mvcPath = ParamUtil.getString(
                renderRequest, "mvcPath", "/");
        PortletMode pm =  renderRequest.getPortletMode();
      //  _log.info("here. command: " + mvcRenderCommandName + " path:" + mvcPath + " mode:"+pm);

        super.render(renderRequest, renderResponse);
    }
/*
    @Override
    public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        _log.info("doEdit");
        include(viewTemplate, renderRequest, renderResponse);
    }

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        _log.info("doView");
        include(viewTemplate, renderRequest, renderResponse);
    }
*/
    @Override
    protected boolean isAddSuccessMessage(ActionRequest actionRequest) {
        boolean ajax = ParamUtil.getBoolean(actionRequest, "ajax");

        if (ajax) {
            return false;
        }

        return super.isAddSuccessMessage(actionRequest);
    }

    @Override
    public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
            super.processAction(actionRequest, actionResponse);
    }
}
