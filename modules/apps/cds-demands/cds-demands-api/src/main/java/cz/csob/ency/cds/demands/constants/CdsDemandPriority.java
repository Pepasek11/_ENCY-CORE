package cz.csob.ency.cds.demands.constants;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.SelectOption;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CdsDemandPriority {
    public static final String LABEL_EXTREME = "extreme";
    public static final String LABEL_HI = "high";
    public static final String LABEL_LOW = "low";
    public static final int PRIORITY_EXTREME = 1;
    public static final int PRIORITY_HIGH = 2;
    public static final int PRIORITY_LOW = 3;
    public static final int PRIORITY_NONE = 0;

    public CdsDemandPriority() {
    }

    public static int getLabelStatus(String label) {
        switch (label) {
            case "extreme":
                return 1;
            case "high":
                return 2;
            case "low":
                return 2;
            default:
                return 0;
        }
    }

    public static String getStatusCssClass(int status) {
        switch (status) {
            case 0:
                return "none";
            case 1:
                return "extreme";
            case 2:
                return "high";
            case 3:
                return "low";
            default:
                return "invalid";
        }
    }

    public static String getStatusLabel(int status) {
        switch (status) {
            case 0:
                return "none";
            case 1:
                return "extreme";
            case 2:
                return "high";
            case 3:
                return "low";
            default:
                return "invalid";
        }
    }

    public static String getStatusStyle(int status) {
        switch (status) {
            case 0:
                return "warning";
            case 1:
                return "primary";
            case 2:
                return "secondary";
            case 3:
                return "info";
            default:
                return "danger";
        }
    }

}
