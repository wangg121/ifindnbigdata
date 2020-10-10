package com.ifindn.observer;

import com.ifindn.observer.impl.User;
import com.ifindn.observer.impl.WechatServer;
import sun.applet.Main;

/**
 * @Author Mr.Guo
 * @Date 2020-06-17 17:36
 */
public class TestMain {

    public static void main(String[] args) {

        new Thread().start();
        User zhangsan = new User("zhangsan");
        User lisi = new User("lisi");
        User wangwu = new User("wangwu");

        WechatServer server = new WechatServer();

        server.registerObserver(zhangsan);
        server.registerObserver(lisi);
        server.registerObserver(wangwu);

        server.setInformation("这是观察者模式");


        System.out.println("------------------------");
        server.removeObserver(wangwu);
        server.setInformation("wangwu取消了订阅-----观察者又说了一句话");

    }
}
