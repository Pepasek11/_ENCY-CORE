package cz.csob.ency.workflow.annotation;

import com.liferay.petra.string.StringPool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface EncyWorkflow {
    public String title() default StringPool.BLANK;

    public String description() default StringPool.BLANK;

    public long version() default 1;

    public EncyWorkflowState[] nodes();

}