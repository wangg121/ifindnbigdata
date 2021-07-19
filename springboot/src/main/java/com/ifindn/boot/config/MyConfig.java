package com.ifindn.boot.config;

import com.ifindn.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/** @Configuration 告诉springBoot这是一个配置类 == 配置文件
 *  1、配置类本身是一个组件
 *  2、配置类里使用@Bean标注在方法上，给容器注册组件，默认也是单例的
 *  3、在spring5之后，添加了proxyBeanMethods属性，默认为true
 *  为true表示，外部无论对配置类中的这个组件的注册方法调用多少次，获取的都是之前容器中的单实例对象
 *  MyConfig myConfig = run.getBean(MyConfig.class);
 *  User user2 = myConfig.user01();
 *  proxyBeanMethods为true时，表示用代理对象调用方法，springboot总会检查这个组件是否在容器中，保持组件单实例
 *  proxyBeanMethods为false时，
 *  Full模式(proxyBeanMethods=true)
 *  Lite模式(proxyBeanMethods=false):springboot不会检查这个组件是否在容器中，springboot启动会比较快，如果确定此组件没有被依赖时，可以设置成false，启动快
 * */

@Configuration(proxyBeanMethods = true)
public class MyConfig {


    @Bean//给容器中添加组件，以方法名作为组件的id（也可以自定义）。返回类型就是组件类型。返回的值，就是组件在容器中的实例。
    public User user01(){
        return new User("zhangsan",20);
    }

    @Bean("custom")//id可以自定义
    public User user02(){
        return new User("zhangsan",20);
    }
}
