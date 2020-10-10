package com.ifindn.reflect.proxy.cglbproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author Mr.Guo
 * @Date 2020-06-30 16:24
 */
public class MyMethodInterceptor implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("插入前置通知");
        Object obj = methodProxy.invokeSuper(o,objects);
        System.out.println("插入后置通知");
        return obj;
    }
}
