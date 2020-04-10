package com.ifindn.proxy.cglb;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author Guo Yan
 * @date 2020/4/9-23:26
 */
public class TestCglib {
    
    public static void main(String[] args){
        Enhancer en = new Enhancer();
        en.setSuperclass(Person.class);
        en.setCallback(new Meipo());
        Person p = (Person) en.create();
        p.findLove();
    }

}
