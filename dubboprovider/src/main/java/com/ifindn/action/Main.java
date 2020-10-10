package com.ifindn.action;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @Author Mr.Guo
 * @Date 2020-06-27 18:08
 */
public class Main {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("sampler-provider.xml");

        context.start();

        System.in.read();
    }
}
