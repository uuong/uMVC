package com.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  参数注解需要 java 8 ,注解转移到方法上
 * User: krny
 * Date: 2017/7/15 0015
 * Time: 22:44
 * To change this template use File | Settings | File Templates.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Params {
    String value();
}
