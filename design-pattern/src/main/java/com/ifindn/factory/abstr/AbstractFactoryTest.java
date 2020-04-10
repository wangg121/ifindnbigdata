package com.ifindn.factory.abstr;

import com.ifindn.factory.simple.Car;

/**
 * @author Guo Yan
 * @date 2020/4/10-15:19
 */
public class AbstractFactoryTest {

    public static void main(String[] args){
        DefaultFactory defaultFactory = new DefaultFactory();
        Car c = defaultFactory.getCar();
        System.out.println(c);
        Car c2 = defaultFactory.getCar("bmw");
        System.out.println(c2);
    }

}
