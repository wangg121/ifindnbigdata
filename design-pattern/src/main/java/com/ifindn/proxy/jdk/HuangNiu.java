package com.ifindn.proxy.jdk;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author Mr.Guo
 * @Date 2020-07-13 22:42
 */
public class HuangNiu implements InvocationHandler {

    private Person target;

    public Person getProxy(Person target){
        this.target = target;
        Class clazz = target.getClass();
        return (Person) Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);

    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("huangniu buy many tickets");
        Object obj = method.invoke(target,objects);
        System.out.println("student can not buy any tickets");
        return obj;
    }
}
