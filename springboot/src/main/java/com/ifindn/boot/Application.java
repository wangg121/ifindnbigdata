package com.ifindn.boot;

import com.ifindn.boot.bean.User;
import com.ifindn.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//ComponentScan可以手动指定扫描的包
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        //1、返回我们的容器
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);

//        //2、查看容器中的组件
//        String[] names = run.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }
//
//
//        //3、从容器中获取组件
//        User user = run.getBean("user01",User.class);
//        User user1 = run.getBean("user01",User.class);
//        System.out.println("组件：" + (user == user1));
//
//        MyConfig myConfig = run.getBean(MyConfig.class);
//        User user2 = myConfig.user01();
    }
}
