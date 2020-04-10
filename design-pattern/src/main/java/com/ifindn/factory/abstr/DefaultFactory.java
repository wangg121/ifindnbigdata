package com.ifindn.factory.abstr;

import com.ifindn.factory.simple.Car;

/**
 * @author Guo Yan
 * @date 2020/4/10-15:18
 */
public class DefaultFactory extends AbstractFactory {

    /**
     * 设定默认返回值
     * @return
     */
    @Override
    public Car getCar() {
        return new BenzFactory().getCar();
    }
}
