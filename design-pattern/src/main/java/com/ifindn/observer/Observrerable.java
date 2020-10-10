package com.ifindn.observer;

/**
 * @Author Mr.Guo
 * @Date 2020-06-17 17:12
 * 抽象被观察者接口，声明了添加，删除，通知观察者方法
 */
public interface Observrerable {

    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}
