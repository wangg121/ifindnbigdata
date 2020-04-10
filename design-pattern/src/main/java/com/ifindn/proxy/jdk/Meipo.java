package com.ifindn.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Guo Yan
 * @date 2020/3/31-18:28
 */
public class Meipo implements InvocationHandler {

    private Person targert;

    public Object getInstance(Person person){
        this.targert = person;
        Class clazz = targert.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    public Meipo(Person person){
        super();
        this.targert = person;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("媒婆介绍对象");
        method.invoke(targert,args);
        System.out.println("end");
        return null;
    }
}
