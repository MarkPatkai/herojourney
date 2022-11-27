package io.tearstar.herojourney.model.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface DeveloperField {
    boolean editable() default true;
    boolean complex() default false;
    boolean required() default false;
    String  field() default "";

    String helpText() default "";
}
