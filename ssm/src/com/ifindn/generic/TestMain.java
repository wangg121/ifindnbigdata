package com.ifindn.generic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Guo Yan
 * @date 2020/6/12-14:53
 */
public class TestMain {

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-generic.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.save();
    }

}
