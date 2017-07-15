package com.framework.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/7/14 0014
 * Time: 9:49
 * To change this template use File | Settings | File Templates.
 */
public interface Proxy {
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
