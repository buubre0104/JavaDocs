package ro.teamnet.zth.api.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import  java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by user on 7/7/2016.
 */

@Target(ElementType.TYPE)
@Retention(RUNTIME)
public @interface Table {

    String name() default "";
}

