package com.framework.bean;

import java.lang.reflect.Method;

/**
 * RequestMapping信息
 */
public class Handler {
    private Class<?> controllerClass;
    private Method method;

    public Handler(Class<?> controllerClass, Method method) {
        this.controllerClass = controllerClass;
        this.method = method;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getMethod() {
        return method;
    }

    @Override
    public String toString() {
        return "Handler{" +
                "controllerClass=" + controllerClass +
                ", method=" + method +
                '}';
    }
}
