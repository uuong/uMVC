package com.framework.annotation;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/7/14 0014
 * Time: 8:43
 * To change this template use File | Settings | File Templates.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    Class<? extends Annotation> value();
}
