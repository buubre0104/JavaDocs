package ro.teamnet.zth.api.annotations;

/**
 * Created by user on 7/15/2016.
 */

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestParam {
    String name();
}
