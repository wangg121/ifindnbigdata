package com.ifindn.test;

import com.ifindn.provider.SamplerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

/**
 * @Author Mr.Guo
 * @Date 2020-06-27 18:24
 */
public class Consumer {

    public static void main(String[] args) throws IOException {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
//                ("sampler-consumer.xml");
//        context.start();
//        SamplerService service = (SamplerService)context.getBean("samplerService");
//        service.sayHello("zhangsan");
//
//        List list = service.getUsers();
//        if(list != null && list.size() > 0){
//            for (int i = 0; i < list.size(); i++) {
//                System.out.println(list.get(i));
//            }
//        }

        Consumer c = new Consumer();
        c.hello(null);
//        System.in.read();


    }

    public void hello(Object name){
        System.out.println("object");

    }
    public void hello(String name){
        System.out.println("string");
    }
}
