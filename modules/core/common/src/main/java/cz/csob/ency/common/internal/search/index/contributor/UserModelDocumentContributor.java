package cz.csob.ency.common.internal.search.index.contributor;

import com.liferay.normalizer.Normalizer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import cz.csob.ency.common.helpers.UserHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.portal.kernel.model.User",
        service = ModelDocumentContributor.class
)
public class UserModelDocumentContributor
        implements ModelDocumentContributor<User> {

    private static final Log _log = LogFactoryUtil.getLog(
            UserModelDocumentContributor.class);

    @Override
    public void contribute(Document document, User user) {
        try {
            String userDisplayName = _userHelper.getFormattedUserName(user);

            userDisplayName = _normalizer.normalizeToAscii(userDisplayName);

            if (!Validator.isBlank(userDisplayName)) {
                document.addKeyword("normalizedDisplayName", userDisplayName);
            }
        } catch (Exception exception) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                        "Unable to index user " + user.getUserId(), exception);
            }
        }
    }
    @Reference
    private Normalizer _normalizer;
    @Reference
    private Portal _portal;
    @Reference
    private UserHelper _userHelper;


}