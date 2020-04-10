package com.ifindn.factory.abstr;

import com.ifindn.factory.simple.Bmw;
import com.ifindn.factory.simple.Car;

/**
 * @author Guo Yan
 * @date 2020/4/10-15:15
 */
public class BmwFactory extends AbstractFactory {

    @Override
    public Car getCar() {
        return new Bmw();
    }
}
