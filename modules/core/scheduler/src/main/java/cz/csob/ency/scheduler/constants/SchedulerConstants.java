package cz.csob.ency.scheduler.constants;

public class SchedulerConstants {
    public static final String ATTRIBUTE_JOBS_LIST = "schedulerJobsList";
    public static final String ATTRIBUTE_COUNT = "count";
    public static final String LOG_ACTION_MSG = "action will be processed on job ";
    public static final String LOG_SHUTDOWN_ACTION_MSG = "Processing request for shutdown";
    public static final String LOG_JOB_FORMAT = "%s %s %s [%s, %s]";

    public static final String COLUMN_SHORT_NAME = "shortName";
    public static final String COLUMN_SHORT_GROUP = "shortGroup";
    public static final String COLUMN_STATE = "triggerState";
    public static final String COLUMN_START_TIME = "startTime";
    public static final String COLUMN_END_TIME = "endTime";
    public static final String COLUMN_PREVIOUS_FIRE_TIME = "previousFireTime";
    public static final String COLUMN_NEXT_FIRE_TIME = "nextFireTime";
    public static final String COLUMN_STORAGE_TYPE = "storageType";

    public static final String ACTION_RUN = "run";
    public static final String ACTION_PAUSE = "pause";
    public static final String ACTION_RESUME = "resume";
    public static final String ACTION_UNSCHEDULE = "unschedule";
    public static final String ACTION_SHUTDOWN = "shutdown";
    public static final String ACTION_REFRESH = "refresh";
    public static final String ACTION_ADDNEW = "add new";

    public static final String PARAMETER_JOB_ACTION = "jobAction";
    public static final String PARAMETER_JOB_SELECTED = "jobSelected";
    public static final String PARAMETER_JOB_NAME = "jobName";
    public static final String PARAMETER_JOB_GROUP = "jobGroup";
    public static final String PARAMETER_STORAGE_TYPE = "jobStorageType";

    public static final String DEFAULT_ORDER_BY_TYPE = "asc";
    public static final String DEFAULT_ORDER_BY_COL = COLUMN_SHORT_NAME;

    public static final String DYNAMIC_SCHEDULER_DESTINATION = "Ency/scheduler_dispatch";
    public static final String JOB_CLASS = "JOB_CLASS";

}
