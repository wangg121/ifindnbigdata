package com.ifindn.reflect.proxy.cglbproxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @Author Mr.Guo
 * @Date 2020-06-30 16:43
 */
public class CglibTest {

    public static void main(String[] args) {

        //代理类class文件
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"E:\\code");

        //通过cglib动态代理获取对象的过程
        Enhancer enhancer = new Enhancer();

        //设置enhancer对象的父类
        enhancer.setSuperclass(HelloService.class);

        //设置enhancer的回调对象
        enhancer.setCallback(new MyMethodInterceptor());

        //创建代理对象
        HelloService proxy = (HelloService)enhancer.create();

        proxy.sayHello("张三");

    }
}
