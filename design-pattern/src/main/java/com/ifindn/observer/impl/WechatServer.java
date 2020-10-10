package com.ifindn.observer.impl;

import com.ifindn.observer.Observer;
import com.ifindn.observer.Observrerable;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mr.Guo
 * @Date 2020-06-17 17:25
 * 被观察者，也就是微信公众号，
 */
public class WechatServer implements Observrerable {

    private List<Observer> list;
    private String message;

    public WechatServer() {
        list = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if(!list.isEmpty()){
            list.remove(o);
        }
    }

    /**
     * 遍历
     */
    @Override
    public void notifyObserver() {
        for(Observer o : list){
            o.update(message);
        }
    }

    public void setInformation(String message){
        this.message = message;
        System.out.println("微服务更新的消息是 " + message);
        //消息更新，通知所有观察者
        notifyObserver();
    }
}
