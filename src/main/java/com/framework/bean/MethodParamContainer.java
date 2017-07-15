package com.framework.bean;

import com.framework.helper.ClassHelper;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/7/15 0015
 * Time: 23:25
 * To change this template use File | Settings | File Templates.
 */
public class MethodParamContainer {
    static {
        Set<Class<?>> classSet = ClassHelper.getController();
        for (Class<?> cls : classSet) {
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                // 需要 java 8 注解转移到方法上//////
                //method.getParameters();
                //////////////////
            }
        }
    }
}
