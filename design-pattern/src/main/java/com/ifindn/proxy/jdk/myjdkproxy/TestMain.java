package com.ifindn.proxy.jdk.myjdkproxy;

import com.ifindn.proxy.jdk.Person;
import com.ifindn.proxy.jdk.Student;
import sun.applet.Main;

import javax.sound.midi.Soundbank;

/**
 * @Author Mr.Guo
 * @Date 2020-07-27 21:41
 * 加载，验证，准备，解析，初始化，使用，卸载
 * jdk动态代理的基本总结是，字节码重组。
 */
public class TestMain {

    public static void main(String[] args)  {

        IfindnHuangniu ifindnHuangniu = new IfindnHuangniu();
        Person ifindPerson = (Person)ifindnHuangniu.getProxyInstance(new Student());
        ifindPerson.buyTicket();

    }
}
