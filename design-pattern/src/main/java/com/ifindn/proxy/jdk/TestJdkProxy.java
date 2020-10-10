package com.ifindn.proxy.jdk;

import sun.misc.ProxyGenerator;

import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @Author Mr.Guo
 * @Date 2020-07-13 22:49
 */
public class TestJdkProxy {

    public static void main(String[] args) throws Exception {
        HuangNiu niu = new HuangNiu();

        Person proxy = niu.getProxy(new Student());
        System.out.println(proxy.getClass());
        proxy.buyTicket();

        /**
         * 原理：
         * 1.拿到被代理对象的引用，然后获取它的接口
         * 2.jdk代理重新生成一个类，同时实现我们给代理对象所实现的接口
         * 3.把被代理对象的引用也拿到
         * 4.重新动态生成一个class字节码文件
         * 5.然后编译
         */

        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});
        FileOutputStream fos = new FileOutputStream("$Proxy0.class");
        fos.write(bytes);
        fos.close();
    }
}
