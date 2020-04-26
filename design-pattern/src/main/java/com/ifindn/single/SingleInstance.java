package com.ifindn.single;

/**
 * @author Guo Yan
 * @date 2020/4/10-17:15
 * 懒汉模式
 */
public class SingleInstance {

    //1.先声明一个静态内部类
    //private，私有保证别人不能修改
    //static，保证全局唯一
    private static class LazyHolder{
        //final,防止内部操作错误
        private static final  SingleInstance INSTANCE = new SingleInstance();
    }

    //2.将默认构造方法私有化
    private SingleInstance(){}

    //3.同样提供静态方法获取实例
    //final确保别人不能覆盖
    public static final SingleInstance getInstance(){
        return LazyHolder.INSTANCE;
    }

    //为什么不在静态快中生成？
    static{
        /*
        方法中的逻辑，要在用户调用的时候才开始执行，方法中实现逻辑需要分配内存，也是在调用的时候才分配的，
        如果放在静态快中，静态块在classloader执行完后，就加载完毕。
         */
    }


}
