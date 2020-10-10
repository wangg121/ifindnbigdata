package com.ifindn.single;

import sun.applet.Main;

/**
 * @author Guo Yan
 * @date 2020/4/10-19:15
 */
public class StaticDemo {
    static String name = "zhangsan";
    public StaticDemo(){
        System.out.println("construction");
        System.out.println(name);
    }
    static{
        System.out.println("start static block");
        System.out.println(name);
        name = "liming";
        System.out.println(name);
        System.out.println("end static block");
    }
    {
        name = "wangwu";
    }
    public static void main(String[] args) {
        StaticDemo staticDemo = new StaticDemo();
    }





}
