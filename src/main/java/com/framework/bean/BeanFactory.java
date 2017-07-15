package com.framework.bean;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/7/15 0015
 * Time: 10:03
 * To change this template use File | Settings | File Templates.
 */
public class BeanFactory {
    public static Object newInstance(Class<?> clazz) {
        Object result;
        try {
           result = clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("instance failure", e);
        }
        return result;
    }
    public static Object invokeMethod(Object obj, Method method, Object... args) {

        Object result;
        try {
            method.setAccessible(true);
            result = method.invoke(obj,args);
        } catch (Exception e) {
            throw new RuntimeException("invokeMethod failure", e);
        }
        return result;
    }

    /**
     *  设置成员变量
     * @param obj 持有field类
     * @param field
     * @param value 被注入的类
     */
    public static void setField(Object obj, Field field, Object value) {
        field.setAccessible(true);
        try {
            field.set(obj,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
