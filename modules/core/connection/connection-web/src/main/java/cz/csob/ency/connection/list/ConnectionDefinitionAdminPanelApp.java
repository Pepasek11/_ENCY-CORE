package cz.csob.ency.connection.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import cz.csob.ency.connection.constants.ConnectionDefinitionPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

@Component(
    immediate = true,
    property = {
        "panel.app.order:Integer=300",
        "panel.category.key=" + PanelCategoryKeys.CONTROL_PANEL_CONFIGURATION
    },
    service = PanelApp.class
)
public class ConnectionDefinitionAdminPanelApp extends BasePanelApp {
    @Override
    public String getPortletId() {
        return ConnectionDefinitionPortletKeys.CONNECTIONDEFINITION_ADMIN;
    }

    @Override
    public String getLabel(Locale locale) {
        return "Connections";
    }

    @Override
    @Reference(
        target = "(javax.portlet.name=" + ConnectionDefinitionPortletKeys.CONNECTIONDEFINITION_ADMIN + ")",
        unbind = "-"
    )
    public void setPortlet(Portlet portlet) {
        super.setPortlet(portlet);
    }
}
