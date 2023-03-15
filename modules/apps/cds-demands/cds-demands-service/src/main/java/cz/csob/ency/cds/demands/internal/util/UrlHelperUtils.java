package cz.csob.ency.cds.demands.internal.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.cds.demands.constants.CdsDemandPortletKeys;
import cz.csob.ency.cds.demands.model.CdsDemand;

public class UrlHelperUtils {

    private static String BASE_URL = null;

    private static String _getBaseUrl() {
        if (Validator.isNotNull(BASE_URL)) {
            return BASE_URL;
        }

        Company company = CompanyLocalServiceUtil.getCompanies(0, 1).get(0);

        BASE_URL = PortalUtil.getPortalURL(company.getVirtualHostname(),
                PortalUtil.getPortalServerPort(false), false);
        return BASE_URL;
    }

    public static String getViewUrl(CdsDemand demand) {
        return getViewUrl(demand.getPrimaryKey(), demand.getGroupId());
    }

    public static String getViewUrl(long entryId, long groupId) {
        String baseUrl = _getBaseUrl();
        if (Validator.isBlank(baseUrl)) {
            return StringPool.BLANK;
        }
        try {
            Long plid = LayoutLocalServiceUtil.getDefaultPlid(
                    groupId, false, CdsDemandPortletKeys.CDSDEMAND);
            Layout layout = LayoutLocalServiceUtil.getLayout(plid);
            String layoutUrl = layout.getFriendlyURL();
            if (Validator.isBlank(layoutUrl)) {
                layoutUrl = PortalUtil.getLayoutActualURL(layout);
            }
            return baseUrl + layoutUrl + "#/demand/view/" + entryId;
        } catch (PortalException ex) {
            return StringPool.BLANK;
        }
    }


}
