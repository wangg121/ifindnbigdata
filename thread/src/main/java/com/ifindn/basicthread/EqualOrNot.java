package com.ifindn.basicthread;

import com.sun.org.apache.bcel.internal.generic.I2B;

import java.lang.reflect.Field;

/**
 * @Author Mr.Guo
 * @Date 2020-07-06 16:19
 */
public class EqualOrNot {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
       Integer i1 = 1,i2 = 2;
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        Integer tmp = new Integer(i1.intValue());
        System.out.println(tmp);
        field.set(i1,2);
        System.out.println(tmp);
    }


}

class UserA{
    public UserA(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String name;
    int age;
}

