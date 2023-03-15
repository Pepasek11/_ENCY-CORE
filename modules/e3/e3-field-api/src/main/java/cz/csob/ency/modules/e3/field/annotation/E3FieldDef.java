package cz.csob.ency.modules.e3.field.annotation;

import com.liferay.petra.string.StringPool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface E3FieldDef {
    String type();

    String name();

    String label() default StringPool.BLANK;

    String[] optionLabels() default {};

    String[] optionValues() default {};

    String predefinedValue() default StringPool.BLANK;

    String[] properties() default {};

    boolean required() default false;

    String hint() default StringPool.BLANK;

    boolean indexable() default true;

    boolean persistent() default true;

    String validationErrorMessage() default StringPool.BLANK;

    String validationExpression() default StringPool.BLANK;

}
