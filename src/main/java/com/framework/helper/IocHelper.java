package com.framework.helper;

import com.framework.annotation.AutoWired;
import com.framework.bean.BeanContainer;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/7/13 0013
 * Time: 1:01
 * To change this template use File | Settings | File Templates.
 */
public class IocHelper {
    static {
        System.out.println("IocHelper helper");
        Map<Class<?>, Object> beanMap = BeanContainer.getBeanMap();
        for (Map.Entry<Class<?>, Object> entry : beanMap.entrySet()) {
            Class<?> beanClass = entry.getKey();
            Object beanInstance = entry.getValue();
            Field[] fields = beanClass.getDeclaredFields();
            if (fields != null) {
                for (Field field : fields) {
                    if (field.isAnnotationPresent(AutoWired.class)) {
                        Class<?> beanFieldClass = field.getType();

                        Object beanFieldInstance = beanMap.get(beanFieldClass);

                        if (beanFieldInstance != null) {

                            try {
                                field.setAccessible(true);
                                field.set(beanInstance,beanFieldInstance);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}
