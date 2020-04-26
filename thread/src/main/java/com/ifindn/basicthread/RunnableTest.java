package com.ifindn.basicthread;

/**
 * @author Guo Yan
 * @date 2020/4/13-17:28
 * 实现接口的方式vs继承的方式
 * 优势：1）避免了java单继承的局限性
 *      2）如果多个线程要操作同一份资源（或数据），更适合使用实现接口的方式。
 */
class ThreadDemo implements Runnable{
    private int num = 100;
    Object object = new Object();
    public void run() {
        while(true){
            synchronized (object){
                if(num > 0 ){
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + num--);
                }else {
                    break;
                }
            }

        }
    }
}


public class RunnableTest {

    public static void main(String[] args){

        ThreadDemo thread = new ThreadDemo();

        Thread t1 = new Thread(thread);
        Thread t2 = new Thread(thread);
        Thread t3 = new Thread(thread);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}

