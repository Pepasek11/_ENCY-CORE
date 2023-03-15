package cz.csob.ency.scheduler.api;

import com.liferay.portal.kernel.messaging.BaseMessageListener;

public abstract class EncyScheduledJob extends BaseMessageListener {

    public abstract String getDefultJobName();
    public abstract String getDefultDescription();
    public String getDefultCronExpression() {return _DEFAULT_CRON_EXPRESSION;};

    // the default cron expression is to run daily at midnight
    private static final String _DEFAULT_CRON_EXPRESSION = "0 0 0 * * ?";

}
