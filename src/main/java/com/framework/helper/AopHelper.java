package com.framework.helper;

import com.framework.annotation.Aspect;
import com.framework.bean.BeanContainer;
import com.framework.bean.BeanFactory;
import com.framework.proxy.AspectProxy;
import com.framework.proxy.Proxy;
import com.framework.proxy.ProxyManager;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/7/14 0014
 * Time: 8:40
 * To change this template use File | Settings | File Templates.
 */
public class AopHelper {
    static {

        // ctrl =  Aspect(?)
        //  proxy         ctrl
        Map<Class<?>, Set<Class<?>>> proxyMap = createProxyMap();
        //  ctrl
        Map<Class<?>, List<Proxy>> ctrlMap = createTargetMap(proxyMap);
        for (Map.Entry<Class<?>, List<Proxy>> entry : ctrlMap.entrySet()) {
            Class<?> ctrlClass = entry.getKey();
            List<Proxy> proxyList = entry.getValue();
            Object proxy = ProxyManager.createProxy(ctrlClass,proxyList);
            BeanContainer.setBean(ctrlClass,proxy);
        }
    }

    private static Map<Class<?>, List<Proxy>> createTargetMap(Map<Class<?>, Set<Class<?>>> proxyMap) {
        Map<Class<?>, List<Proxy>> targetMap = new HashMap<>();
        for (Map.Entry<Class<?>, Set<Class<?>>> entry : proxyMap.entrySet()) {
            Class<?> proxyClass = entry.getKey();
            Set<Class<?>> ctrlSet = entry.getValue();
            for (Class<?> clazz : ctrlSet) {
                Proxy proxy = (Proxy) BeanFactory.newInstance(proxyClass);

                if (targetMap.containsKey(clazz)) {
                    targetMap.get(clazz).add(proxy);
                } else {
                    List<Proxy> list = new ArrayList<>();
                    list.add(proxy);
                    targetMap.put(clazz, list);
                }
            }
        }
        return targetMap;
    }

    private static Map<Class<?>, Set<Class<?>>> createProxyMap() {
        Map<Class<?>, Set<Class<?>>> proxyMap = new HashMap<>();
        addAspectProxy(proxyMap);
        return proxyMap;
    }

    private static void addAspectProxy(Map<Class<?>, Set<Class<?>>> proxyMap) {
        Set<Class<?>> proxyClassSet = ClassHelper.getClassSetBySuper(AspectProxy.class);
        for (Class<?> proxyClass : proxyClassSet) {
            if (proxyClass.isAnnotationPresent(Aspect.class)) {
                Aspect aspect = proxyClass.getAnnotation(Aspect.class);
                Set<Class<?>> ctrlClassSet = createCtrlClassSet(aspect);
                proxyMap.put(proxyClass,ctrlClassSet);
            }
        }
    }

    private static Set<Class<?>> createCtrlClassSet(Aspect aspect) {
        Set<Class<?>> targetClassSet = new HashSet<>();
        Class<? extends Annotation> annotation = aspect.value();
        if (!annotation.equals(Aspect.class)) {
            targetClassSet.addAll(ClassHelper.getClassSetByAnnotation(annotation));
        }
        return targetClassSet;
    }
}
