package cz.csob.ency.cds.demands.constants;

public class CdsDemandUSFrequency {

    public static final int FREQUENCY_DAILY = 2;
    public static final int FREQUENCY_HALFYEARLY = 6;
    public static final int FREQUENCY_MONTHLY = 4;
    public static final int FREQUENCY_NONE = 0;
    public static final int FREQUENCY_ONCE = 1;
    public static final int FREQUENCY_OTHER = 8;
    public static final int FREQUENCY_QUARTERLY = 5;
    public static final int FREQUENCY_WEEKLY = 3;
    public static final int FREQUENCY_YEARLY = 7;
    public static final String LABEL_DAILY = "daily";
    public static final String LABEL_HALFYEARLY = "halfyearly";
    public static final String LABEL_MONTHLY = "monthly";
    public static final String LABEL_NONE = "none";
    public static final String LABEL_ONCE = "once";
    public static final String LABEL_OTHER = "other";
    public static final String LABEL_QUARTERLY = "quarterly";
    public static final String LABEL_WEEKLY = "weekly";
    public static final String LABEL_YEARLY = "yearly";

    public CdsDemandUSFrequency() {
    }

    public static int getLabelType(String label) {
        switch (label) {
            case LABEL_ONCE:
                return FREQUENCY_ONCE;
            case LABEL_DAILY:
                return FREQUENCY_DAILY;
            case LABEL_WEEKLY:
                return FREQUENCY_WEEKLY;
            case LABEL_MONTHLY:
                return FREQUENCY_MONTHLY;
            case LABEL_QUARTERLY:
                return FREQUENCY_QUARTERLY;
            case LABEL_HALFYEARLY:
                return FREQUENCY_HALFYEARLY;
            case LABEL_YEARLY:
                return FREQUENCY_YEARLY;
            case LABEL_OTHER:
                return FREQUENCY_OTHER;
            default:
                return FREQUENCY_NONE;
        }
    }

    public static String getTypeCssClass(int status) {
        return getTypeLabel(status);
    }

    public static String getTypeLabel(int status) {
        switch (status) {
            case FREQUENCY_NONE:
                return LABEL_NONE;
            case FREQUENCY_ONCE:
                return LABEL_ONCE;
            case FREQUENCY_DAILY:
                return LABEL_DAILY;
            case FREQUENCY_WEEKLY:
                return LABEL_WEEKLY;
            case FREQUENCY_MONTHLY:
                return LABEL_MONTHLY;
            case FREQUENCY_QUARTERLY:
                return LABEL_QUARTERLY;
            case FREQUENCY_HALFYEARLY:
                return LABEL_HALFYEARLY;
            case FREQUENCY_YEARLY:
                return LABEL_YEARLY;
            case FREQUENCY_OTHER:
                return LABEL_OTHER;
            default:
                return "invalid";
        }
    }

    public static String getTypeStyle(int status) {
        switch (status) {
            case 0:
                return "warning";
            default:
                return "info";
        }
    }
}
