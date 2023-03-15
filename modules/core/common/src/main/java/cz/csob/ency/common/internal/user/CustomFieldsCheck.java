package cz.csob.ency.common.internal.user;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.model.ExpandoColumnConstants;
import com.liferay.expando.kernel.util.ExpandoBridgeFactory;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.UnicodeProperties;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class CustomFieldsCheck {
    private static final Log _log = LogFactoryUtil.getLog(CustomFieldsCheck.class);

    private void _checkAttribute(String attributeName) {
        companyLocalService.forEachCompanyId(
                companyId -> {
                    ExpandoBridge expandoBridge =
                            expandoBridgeFactory.getExpandoBridge(
                                    companyId, User.class.getName());

                    if (!expandoBridge.hasAttribute(attributeName)) {
                        try {
                            expandoBridge.addAttribute(attributeName, false);
                        } catch (PortalException portalException) {
                            if (_log.isWarnEnabled()) {
                                _log.warn(portalException);
                            }
                        }
                    }

                    UnicodeProperties unicodeProperties =
                            expandoBridge.getAttributeProperties(attributeName);

                    unicodeProperties.put(
                            ExpandoColumnConstants.PROPERTY_HIDDEN,
                            StringPool.FALSE);

                    unicodeProperties.put(
                            ExpandoColumnConstants.INDEX_TYPE,
                            String.valueOf(ExpandoColumnConstants.INDEX_TYPE_KEYWORD));

                    unicodeProperties.put(
                            "localize-field",
                            StringPool.FALSE);

                    unicodeProperties.put(
                            ExpandoColumnConstants.PROPERTY_LOCALIZE_FIELD_NAME,
                            StringPool.FALSE);

                    unicodeProperties.put(
                            ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE,
                            ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_INPUT_FIELD);

                    expandoBridge.setAttributeProperties(
                            attributeName, unicodeProperties, false);
                });
    }

    @Activate
    void activate() throws PortalException {
        _checkAttribute("employee_number");
        _checkAttribute("company");
        _checkAttribute("department");
        _checkAttribute("user_principal_name");
    }
    @Reference
    CompanyLocalService companyLocalService;
    @Reference
    ExpandoBridgeFactory expandoBridgeFactory;
    @Reference
    UserLocalService userLocalService;
}
