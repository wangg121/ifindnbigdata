package com.ifindn.proxy.jdk;

/**
 * @Author Mr.Guo
 * @Date 2020-07-13 22:41
 */
public class Student implements Person {
    @Override
    public void buyTicket() {
        System.out.println("student buy a ticket ");
    }

    @Override
    public void eat() {
        System.out.println("eat banana");
    }
}
