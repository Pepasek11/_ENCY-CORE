package cz.csob.ency.cds.demands.web.internal.notifications;

import com.liferay.portal.kernel.notifications.BaseModelUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import cz.csob.ency.cds.demands.constants.CdsDemandPortletKeys;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true, property = "javax.portlet.name=" + CdsDemandPortletKeys.CDSDEMAND,
        service = UserNotificationHandler.class
)
public class CdsDemandUserNotificationHandler extends BaseModelUserNotificationHandler {

    public CdsDemandUserNotificationHandler() {
        setPortletId(CdsDemandPortletKeys.CDSDEMAND);
    }

}
