package cz.csob.ency.cds.demands.web.internal.notifications;

import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.notifications.UserNotificationDefinition;
import com.liferay.portal.kernel.notifications.UserNotificationDeliveryType;
import cz.csob.ency.cds.demands.constants.CdsDemandConstants;
import cz.csob.ency.cds.demands.constants.CdsDemandPortletKeys;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = {"javax.portlet.name=" + CdsDemandPortletKeys.CDSDEMAND},
        service = UserNotificationDefinition.class
)
public class CdsDemandWorkflowUserNotificationDefinition extends UserNotificationDefinition {
    public CdsDemandWorkflowUserNotificationDefinition() {
        // pass in our portlet key, 0 for a class name id (don't care about it), the notification type (not really), and
        // finally the resource bundle key for the message the user sees.
        super(CdsDemandPortletKeys.CDSDEMAND, 0, CdsDemandConstants.NOTIFICATION_TYPE_WORKFLOW,
                "receive-a-notification-on-workflow-action");

        // add a notification type for each sort of notification that we want to support.
        addUserNotificationDeliveryType(
                new UserNotificationDeliveryType(
                        "email", UserNotificationDeliveryConstants.TYPE_EMAIL, true,
                        true));
        addUserNotificationDeliveryType(
                new UserNotificationDeliveryType(
                        "website", UserNotificationDeliveryConstants.TYPE_WEBSITE, true,
                        true));
    }
}
