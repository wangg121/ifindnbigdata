package com.ifindn.thread;

/**
 * if语句有一个特点，代码在哪里停止（下面wait）就在哪里起来，第二个特点是notify是随机唤醒线程等待，这个随机特点造成了打印结果的不可控
 * notify换成notifyAll（），可以唤醒全部的线程，然后这些线程去判断，再执行相关打印
 *
 * 线程虚假唤醒问题：
 * https://www.cnblogs.com/nicaicai/p/14082018.html
 * https://www.cnblogs.com/dk1024/p/14163377.html
 */
public class NotifyAllDemo {

    public static void main(String[] args) {

        Printer2 printer2 = new Printer2();

        new Thread(()->{ for (int i = 0; i < 10; i++) {
            try {
                printer2.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        },"A").start();

        new Thread(()->{ for (int i = 0; i < 10; i++) {
            try {
                printer2.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        },"B").start();


        new Thread(()->{ for (int i = 0; i < 10; i++) {
            try {
                printer2.decrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        },"C").start();


        new Thread(()->{ for (int i = 0; i < 10; i++) {
            try {
                printer2.decrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        },"D").start();
    }

}


class Printer2{

    private int num = 0;

    public synchronized void  increment() throws InterruptedException {
        if(num !=0){
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName() + "生产了》》" + num + "个");
        this.notifyAll();
    }

    public synchronized void  decrement() throws InterruptedException {
        if(num !=1){
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName() + "消费了》》" + num + "个");
        this.notifyAll();
    }
}
