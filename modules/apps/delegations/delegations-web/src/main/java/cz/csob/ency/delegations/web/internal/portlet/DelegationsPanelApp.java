package cz.csob.ency.delegations.web.internal.portlet;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import cz.csob.ency.delegations.constants.DelegationsPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * PanelApp
 * <p>
 * This class is used to display a portet in the product menu
 *
 * @author Miroslav Čermák
 */
@Component(
        immediate = true,
        property = {
                "panel.app.order:Integer=101", //TODO : this number determine the order in the panel
                "panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_MEMBERS
        },
        service = PanelApp.class
)
public class DelegationsPanelApp extends BasePanelApp {

    @Override
    public String getPortletId() {
        return DelegationsPortletKeys.DELEGATIONS_ADMIN;
    }

    @Override
    @Reference(
            target = "(javax.portlet.name=" + DelegationsPortletKeys.DELEGATIONS_ADMIN + ")",
            unbind = "-"
    )
    public void setPortlet(Portlet portlet) {
        super.setPortlet(portlet);
    }
}