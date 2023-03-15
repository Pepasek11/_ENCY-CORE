package cz.csob.ency.workflow.util;

import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import cz.csob.ency.common.helpers.UserHelper;
import cz.csob.ency.common.helpers.UserHelperUtil;
import org.osgi.service.component.annotations.Reference;

//@todo replace by common method that use format: Name (Jxyyyy)
public class WorkflowHelperUtils {

    public static String getUserName(long userId) {
        String userName = "SYSTEM";
        if(userId >0) {
            try {
                User user = UserLocalServiceUtil.getUser(userId);

                if (user != null) {
                    userName = UserHelperUtil.getFormattedUserName(user);
                }

            } catch (NoSuchUserException e) {
                userName = "Unknown";
            } catch (PortalException e) {
                e.printStackTrace();
            }
        }
        return userName;
    }
}
