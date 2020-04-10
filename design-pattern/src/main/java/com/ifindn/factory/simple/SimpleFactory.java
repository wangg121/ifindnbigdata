package com.ifindn.factory.simple;

/**
 * @author Guo Yan
 * @date 2020/4/10-12:50
 * 简单工厂
 */
public class SimpleFactory {
    
    public static void main(String[] args){
        Car car = CarFactory.productCar("bmw");
        System.out.println(car.getName());
    }

}
