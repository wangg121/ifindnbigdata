package com.ifindn.observer;

/**
 * @Author Mr.Guo
 * @Date 2020-06-17 17:10
 * 抽象观察者，
 * 定义一个update（）方法，当被观察者调用notifyObservers()方法时，
 * 观察者的update（）方法会被调用。
 */
public interface Observer {

    void update(String message);
}
