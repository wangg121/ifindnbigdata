package com.ifindn.single;

/**
 * @author Guo Yan
 * @date 2020/4/10-17:15
 * 懒汉模式，静态内部类形式
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
        //方法中的逻辑，是要在用户调用的时候才开始执行的，
        //方法中实现逻辑需要分配内存，也是调用时才分配的，
        // 所以此种方法与在静态块初始化的好处是，避免一开始就占用内存
        return LazyHolder.INSTANCE;
    }

    //为什么不在静态快中生成？
    //不管该class有没有被实例化，静态块在classloader执行完后，就加载完毕。
    static{
        /*
        方法中的逻辑，要在用户调用的时候才开始执行，方法中实现逻辑需要分配内存，也是在调用的时候才分配的，
        静态方法或静态属性可以使用class名字直接点出来

         */
    }


}
