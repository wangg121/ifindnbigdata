package com.ifindn.proxy.jdk.myjdkproxy;

import java.lang.reflect.Method;

/**
 * @Author Mr.Guo
 * @Date 2020-07-25 18:37
 */
public interface IfindnInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
