package com.ifindn.reflect.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author Mr.Guo
 * @Date 2020-06-30 11:06
 */
public class SubjectProxy implements InvocationHandler {

    private Object object;

    public SubjectProxy(Subject subject) {
        this.object = subject;
    }

    public Object getSubjectProxy(){
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces()
        ,this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        proxy = this.object;
//        System.out.println("invoke中proxy的类型为 " + proxy.getClass().getSimpleName());
        System.out.println("代理发出的声明");
        Object o = method.invoke(proxy,args);
        return o;
    }
}
