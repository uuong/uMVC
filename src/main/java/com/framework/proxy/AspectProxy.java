package com.framework.proxy;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/7/14 0014
 * Time: 10:41
 * To change this template use File | Settings | File Templates.
 */
public class AspectProxy implements Proxy {
    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;
        Class<?> cls = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethod();
        Object[] params = proxyChain.getMethodParams();
        begin();
        try {
            if(intercept(cls,method,params)) {
                before(cls,method,params);
                result = proxyChain.doProxyChain();
                after(cls,method,params,result);
            } else {
                result = proxyChain.doProxyChain();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            end();
        }
        return result;
    }

    public void end() {

    }

    public void after(Class<?> cls, Method method, Object[] params, Object result) {
    }

    public void before(Class<?> cls, Method method, Object[] params) {
    }

    public boolean intercept(Class<?> cls, Method method, Object[] params) {
        return true;
    }

    public void begin() {
    }
}
