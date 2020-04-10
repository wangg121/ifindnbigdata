package com.ifindn.factory.abstr;

import com.ifindn.factory.simple.Benz;
import com.ifindn.factory.simple.Car;

/**
 * @author Guo Yan
 * @date 2020/4/10-13:57
 */
public class BenzFactory extends AbstractFactory {


    @Override
    public Car getCar() {
        return new Benz();
    }
}
