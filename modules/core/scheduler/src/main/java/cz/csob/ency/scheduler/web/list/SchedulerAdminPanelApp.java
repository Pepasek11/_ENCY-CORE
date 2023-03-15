package cz.csob.ency.scheduler.web.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import cz.csob.ency.scheduler.web.constants.SchedulerPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(
    immediate = true,
    property = {
        "panel.app.order:Integer=300",
        "panel.category.key=" + PanelCategoryKeys.CONTROL_PANEL
    },
    service = PanelApp.class
)
public class SchedulerAdminPanelApp extends BasePanelApp {
    @Override
    public String getPortletId() {
        return SchedulerPortletKeys.SCHEDULER_PORTLET;
    }

    @Override
    @Reference(
        target = "(javax.portlet.name=" + SchedulerPortletKeys.SCHEDULER_PORTLET + ")",
        unbind = "-"
    )
    public void setPortlet(Portlet portlet) {
        super.setPortlet(portlet);
    }
}

