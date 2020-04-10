package com.ifindn.factory.simple;

/**
 * @author Guo Yan
 * @date 2020/4/10-12:48
 */
public class CarFactory {

    public static  Car productCar(String name){
        if("benz".equalsIgnoreCase(name)){
            return new Benz();
        }else if(name.equalsIgnoreCase("bmw")){
            return new Bmw();
        }else{
            return null;
        }
    }

}
