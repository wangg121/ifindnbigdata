package com.ifindn.proxy.jdk;


import java.lang.reflect.Proxy;

/**
 * @author Guo Yan
 * @date 2020/3/31-18:28
 */
public class TestFindLove {
    public static void main(String[] args){

        /*
        Person person = (Person) new Meipo().getInstance(new xiaoxingxing());
        person.findLove();*/

        xiaoxingxing x = new xiaoxingxing();
        Person stuProxy = (Person) Proxy.newProxyInstance(
                x.getClass().getClassLoader(),x.getClass().getInterfaces(),new Meipo(x));
        stuProxy.findLove();

    }

}
