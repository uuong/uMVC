package com.framework.helper;

import com.framework.annotation.Action;
import com.framework.annotation.Aspect;
import com.framework.bean.Handler;
import com.framework.bean.Request;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/7/13 0013
 * Time: 16:01
 * To change this template use File | Settings | File Templates.
 */
public class ControllerHelper {
    private static Map<Request, Handler> actionMap = new HashMap<>();

    static {
        System.out.println("action helper");
        Set<Class<?>> classSet = ClassHelper.getController();
        for (Class<?> item : classSet) {
            Method[] methods = item.getDeclaredMethods();
            for (Method method : methods) {
                Action action = method.getAnnotation(Action.class);
                if (action != null) {
                    Request request = new Request(action.method(), action.path());
                    Handler handler = new Handler(item, method);
                    actionMap.put(request, handler);
                }
            }
        }
    }


    public static Set<Class<?>> createTargetClassSet(Aspect aspect) {
        Set<Class<?>> targetClassSet = new HashSet<>();
        Class<? extends Annotation> annotation = aspect.value();
        if (annotation != null && !annotation.equals(Aspect.class)) {
            targetClassSet.addAll(ClassHelper.getClassSetByAnnotation(annotation));
        }
        return targetClassSet;
    }

    public static Handler getActionMethod(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return actionMap.get(request);
    }
}
