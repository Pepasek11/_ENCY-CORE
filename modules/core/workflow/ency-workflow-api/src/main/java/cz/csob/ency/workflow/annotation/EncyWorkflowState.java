package cz.csob.ency.workflow.annotation;


import com.liferay.petra.string.StringPool;

public @interface EncyWorkflowState {
    public String cssIcon() default StringPool.BLANK;

    public String cssIconColor() default StringPool.BLANK;

    public String cssLabelColor() default StringPool.BLANK;

    public String description() default StringPool.BLANK;

    public boolean isFinal() default false;

    public boolean isInitial() default false;

    public boolean isEditable() default true;

    public boolean isSearchable() default true;

    public boolean isPermanent() default true;

    public String name();

    public String title() default StringPool.BLANK;

    public EncyWorkflowTransition[] transitions() default {};

}
