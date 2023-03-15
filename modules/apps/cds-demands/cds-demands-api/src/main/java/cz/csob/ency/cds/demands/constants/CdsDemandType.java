package cz.csob.ency.cds.demands.constants;

public class CdsDemandType {
    public static final String LABEL_BS = "bs";
    public static final String LABEL_OUT = "out-of-cds";
    public static final String LABEL_US = "us";
    public static final int TYPE_BS = 2;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_OUT = -1;
    public static final int TYPE_US = 1;

    public CdsDemandType() {
    }

    public static int getLabelType(String label) {
        switch (label) {
            case LABEL_US:
                return TYPE_US;
            case LABEL_BS:
                return TYPE_BS;
            case LABEL_OUT:
                return TYPE_OUT;
            default:
                return TYPE_NONE;
        }
    }

    public static String getTypeCssClass(int status) {
        switch (status) {
            case -1:
                return "out-of-cds";
            case 0:
                return "none";
            case 1:
                return "us";
            case 2:
                return "bs";
            default:
                return "invalid";
        }
    }

    public static String getTypeLabel(int status) {
        switch (status) {
            case TYPE_NONE:
                return "none";
            case TYPE_US:
                return LABEL_US;
            case TYPE_BS:
                return LABEL_BS;
            case TYPE_OUT:
                return LABEL_OUT;
            default:
                return "invalid";
        }
    }
/*
    public static String getTypeStyle(int status) {
        switch (status) {
            case TYPE_NONE:
                return "none";
            case TYPE_US:
                return "warning";
            case TYPE_BS:
                return "success";
            case TYPE_OUT:
                return "info";
            default:
                return "danger";
        }
    }

 */
}
