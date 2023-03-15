package cz.csob.ency.workflow.annotation;

import com.liferay.petra.string.StringPool;

public @interface EncyWorkflowTransition {
    public String cssIcon() default StringPool.BLANK;

    public String cssIconColor() default StringPool.BLANK;

    public String description() default StringPool.BLANK;

    public String name();

    public long order() default 0;

    public String targetStateName();

    public String title() default StringPool.BLANK;


}
