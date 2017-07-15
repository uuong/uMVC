package com.framework.bean;

import com.framework.helper.ClassHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/7/15 0015
 * Time: 9:46
 * To change this template use File | Settings | File Templates.
 */
public class BeanContainer {

    /**
     * 存入class类 和 实例
     */
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<>();

    static {
        System.out.println("BeanContainer helper");
        Set<Class<?>> classSet = ClassHelper.getAll();
        for (Class<?> aClass : classSet) {
                Object instance = BeanFactory.newInstance(aClass);
                BEAN_MAP.put(aClass,instance);
        }
    }



    public static <T> T getBean(Class<T> tClass) {
        if (!BEAN_MAP.containsKey(tClass)) {
            throw new RuntimeException();
        }
        return (T)BEAN_MAP.get(tClass);
    }
    public static void setBean(Class<?> cls, Object obj){
        BEAN_MAP.put(cls, obj);
    }
    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

}
