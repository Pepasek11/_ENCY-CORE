package cz.csob.ency.modules.e3.web.internal.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import cz.csob.ency.modules.e3.web.portlet.base.actions.BaseE3EntryMVCRenderCommand;
import cz.csob.ency.modules.e3.entry.constants.E3PortletKeys;
import org.osgi.service.component.annotations.Component;

/**
 * @author Sergio González, Miroslav Čermák
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + E3PortletKeys.E3Portlet,
                "javax.portlet.name=" + E3PortletKeys.E3AdminPortlet,
                "mvc.command.name=/",
                "mvc.command.name=/e3/view",
                "mvc.command.name=/e3/view_entry",
                "mvc.command.name=/e3/edit_entry"
        },
        service = MVCRenderCommand.class
)
public class CommonE3EntryMVCRenderCommand extends BaseE3EntryMVCRenderCommand {
    private static final Log _log = LogFactoryUtil.getLog(CommonE3EntryMVCRenderCommand.class);



}
