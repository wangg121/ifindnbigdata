package com.ifindn.observer.impl;

import com.ifindn.observer.Observer;

import javax.sound.midi.Soundbank;

/**
 * @Author Mr.Guo
 * @Date 2020-06-17 17:32
 */
public class User implements Observer {

    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read(){
        System.out.println(name + "收到的信息是 " + message);
    }
}
