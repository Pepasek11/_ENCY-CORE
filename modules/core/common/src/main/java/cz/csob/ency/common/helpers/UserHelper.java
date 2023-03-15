package cz.csob.ency.common.helpers;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

@Component(immediate = true, service = UserHelper.class)
public class UserHelper {
    private static final String DEFAULT_USER_NAME = "System";


    public String getFormattedUserName(long userId) {
        return getFormattedUserName(userId, DEFAULT_USER_NAME);
    }

    public String getFormattedUserName(long userId, String defaultName) {
        User u = userLocalService.fetchUser(userId);
        return getFormattedUserName(u, defaultName);
    }

    public String getFormattedUserName(User user) {
        return getFormattedUserName(user, DEFAULT_USER_NAME);
    }

    public String getFormattedUserName(User user, String defaultName) {
        if (Validator.isNull(user)) {
            return StringPool.BLANK;
        }
        return user.getLastName().toUpperCase(Locale.ROOT) + " " + user.getFirstName() +
                " (" + user.getScreenName().toUpperCase(Locale.ROOT) + ")";
    }

    @Reference
    protected UserLocalService userLocalService;
}
