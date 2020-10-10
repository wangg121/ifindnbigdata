package com.ifindn.proxy.jdk.myjdkproxy;

import com.ifindn.proxy.jdk.Person;

import java.lang.reflect.Method;

/**
 * @Author Mr.Guo
 * @Date 2020-07-25 18:39
 */
public class IfindnHuangniu implements IfindnInvocationHandler {

    private Person student;

    public Object getProxyInstance(Person person){
        this.student = person;
        Class clazz = person.getClass();
        return IfindnProxy.newProxyInstance(new IfindnClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("自己写的invocationHandler开始执行");
        Object obj = method.invoke(student,args);
        System.out.println("自己写的invocationHandler执行结束");
        return obj;
    }
}
