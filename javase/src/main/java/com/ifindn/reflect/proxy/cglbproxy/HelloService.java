package com.ifindn.reflect.proxy.cglbproxy;

import com.sun.deploy.util.SyncAccess;

/**
 * @Author Mr.Guo
 * @Date 2020-06-30 16:14
 */
public class HelloService {

    public HelloService() {
        System.out.println("创建 HelloService");
    }

    //该方法不能被子类覆盖，cglb是无法替代final修饰的方法的
    public final String sayOthers(String name){
        System.out.println("HelloService : sayOthers 方法" + name);
        return null;
    }

    public void sayHello(String name){
        System.out.println("HelloService : sayHello " + name);
    }
}
