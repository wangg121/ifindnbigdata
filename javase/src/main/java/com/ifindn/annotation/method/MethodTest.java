package com.ifindn.annotation.method;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 将注解注入到方法上
 */
public class MethodTest {

    @MyTargetMethod(name = "zhangsan",age = 12)
    public void record(String name, int age){
        System.out.println(name + age);

    }

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class clazz = MethodTest.class;
        Method record = clazz.getMethod("record",String.class,int.class);

        MyTargetMethod annotation = record.getAnnotation(MyTargetMethod.class);

        String name = annotation.name();
        int age = annotation.age();

        Object m = clazz.newInstance();

        record.invoke(m,name,age);



    }
}
