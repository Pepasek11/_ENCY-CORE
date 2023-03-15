package cz.csob.ency.cds.demands.constants;

public class CdsDemandFiveTracks {
    public static final String LABEL_0NONE = "ft-nepodporuje";
    public static final String LABEL_1KATE = "ft-kate";
    public static final String LABEL_2LEAD = "ft-lead-management";
    public static final String LABEL_3NDM = "ft-distribution-model-nl";
    public static final String LABEL_4STP = "ft-stp";
    public static final String LABEL_5DATA = "ft-data";

    public static final int TRACK_0NONE = 0;
    public static final int TRACK_1KATE = 1;
    public static final int TRACK_2LEAD = 2;
    public static final int TRACK_3NDM = 3;
    public static final int TRACK_4STP = 4;
    public static final int TRACK_5DATA = 5;


    public CdsDemandFiveTracks() {
    }

    public static int getTrackType(String label) {
        switch (label) {
            case LABEL_1KATE:
                return TRACK_1KATE;
            case LABEL_2LEAD:
                return TRACK_2LEAD;
            case LABEL_3NDM:
                return TRACK_3NDM;
            case LABEL_4STP:
                return TRACK_4STP;
            case LABEL_5DATA:
                return TRACK_5DATA;
            default:
                return TRACK_0NONE;
        }
    }

    public static String getTrackCssClass(int status) {
        return "";
    }

    public static String getTrackLabel(int status) {
        switch (status) {
            case TRACK_1KATE:
                return LABEL_1KATE;
            case TRACK_2LEAD:
                return LABEL_2LEAD;
            case TRACK_3NDM:
                return LABEL_3NDM;
            case TRACK_4STP:
                return LABEL_4STP;
            case TRACK_5DATA:
                return LABEL_5DATA;
            default:
                return LABEL_0NONE;
        }
    }

    public static String getTrackStyle(int status) {
        return "info";
    }

}
