package com.ifindn.reflect.proxy.jdkproxy;

/**
 * @Author Mr.Guo
 * @Date 2020-06-30 11:05
 */
public class SubjectImpl implements Subject {
    @Override
    public void sayHi(String name) {
        System.out.println("hi " + name);
    }

    @Override
    public void sayBye(String name) {
        System.out.println("good bye " + name);
    }
}
