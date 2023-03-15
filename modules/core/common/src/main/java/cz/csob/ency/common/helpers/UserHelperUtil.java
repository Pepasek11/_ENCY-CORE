package cz.csob.ency.common.helpers;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.util.tracker.ServiceTracker;

@Component(immediate = true, service = UserHelperUtil.class)
public class UserHelperUtil {

    private static final ServiceTracker<UserHelper, UserHelper> _serviceTracker;

    protected static UserHelper getService() {
        return _serviceTracker.getService();
    }

    public static String getFormattedUserName(long userId) {
        return getService().getFormattedUserName(userId);
    }

    public static String getFormattedUserName(long userId, String defaultName) {
        return getService().getFormattedUserName(userId, defaultName);
    }

    public static String getFormattedUserName(User user) {
        return getService().getFormattedUserName(user);
    }

    public static String getFormattedUserName(User user, String defaultName) {
        return getService().getFormattedUserName(user, defaultName);
    }

    static {
        Bundle bundle = FrameworkUtil.getBundle(UserHelper.class);

        ServiceTracker
                <UserHelper, UserHelper>
                serviceTracker =
                new ServiceTracker<UserHelper, UserHelper>(
                        bundle.getBundleContext(),
                        UserHelper.class, null);

        serviceTracker.open();

        _serviceTracker = serviceTracker;
    }

    @Reference
    protected UserLocalService userLocalService;
}
