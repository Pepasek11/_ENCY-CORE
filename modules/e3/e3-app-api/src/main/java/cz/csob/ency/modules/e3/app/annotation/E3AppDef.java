package cz.csob.ency.modules.e3.app.annotation;

import com.liferay.petra.string.StringPool;
import cz.csob.ency.modules.e3.field.annotation.E3FieldDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface E3AppDef {
    public String name() default StringPool.BLANK;

    public String code() default StringPool.BLANK;

    public String description() default StringPool.BLANK;

    public boolean indexable() default true;

    public boolean versioned() default true;

    public E3FieldDef[] fields();

}
