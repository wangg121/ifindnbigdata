package com.ifindn.basicthread;

/**
 * @author Guo Yan
 * @date 2020/4/14-13:57
 * 两个线程交替打印100
 */
public class Commiuntion {
    public static void main(String[] args){
        PrintNum printNum = new PrintNum();
        Thread t1 = new Thread(printNum);
        Thread t2 = new Thread(printNum);

        t1.setName("甲");
        t2.setName("乙");

        t1.start();
        t2.start();
    }

}

class PrintNum implements Runnable {

    int num = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (num <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }



        }
    }
}





