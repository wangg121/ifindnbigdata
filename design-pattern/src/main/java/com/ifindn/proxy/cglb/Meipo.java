package com.ifindn.proxy.cglb;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Guo Yan
 * @date 2020/4/9-23:19
 */
public class Meipo implements MethodInterceptor {


    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("对目标增强");

        return methodProxy.invokeSuper(o,objects);
    }
}
