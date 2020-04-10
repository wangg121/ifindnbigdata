package com.ifindn.factory.abstr;

import com.ifindn.factory.simple.Car;

/**
 * @author Guo Yan
 * @date 2020/4/10-13:56
 */
public abstract class AbstractFactory {

    public abstract Car getCar();

    public Car getCar(String name){
        if("bmw".equalsIgnoreCase(name)){
            return new BmwFactory().getCar();
        }else if("benz".equalsIgnoreCase(name)){
            return new BenzFactory().getCar();
        }else{
            return  null;
        }
    }
}
