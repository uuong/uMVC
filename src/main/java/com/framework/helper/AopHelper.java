package com.framework.helper;

import com.framework.annotation.Aspect;
import com.framework.bean.BeanContainer;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/7/14 0014
 * Time: 8:40
 * To change this template use File | Settings | File Templates.
 */
public class AopHelper {
    static {
        Map<Class<?>, Object> beanMap = BeanContainer.getBeanMap();
        for (Map.Entry<Class<?>, Object> entry : beanMap.entrySet()) {
            Class<?> aClass = entry.getKey();
            Object obj = entry.getValue();
            Method[] methods = aClass.getDeclaredMethods();
            for (Method method : methods) {
                Aspect aspect = method.getAnnotation(Aspect.class);
                if (aspect != null) {



                }
            }
        }
    }
}
