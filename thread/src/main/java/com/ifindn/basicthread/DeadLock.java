package com.ifindn.basicthread;

/**
 * @author Guo Yan
 * @date 2020/4/14-13:00
 * 死锁
 */
public class DeadLock {

    static StringBuffer sb1 = new StringBuffer();
    static StringBuffer sb2 = new StringBuffer();

    public static void main(String[] args){
        new Thread(){
            @Override
            public void run(){
                synchronized (sb1){
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sb1.append("A");
                    synchronized (sb2){
                        sb2.append("B");
                        System.out.println(sb1);
                        System.out.println(sb2);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                synchronized (sb2){
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sb2.append("C");
                    synchronized (sb1){
                        sb1.append("D");
                        System.out.println(sb1);
                        System.out.println(sb2);
                    }
                }
            }
        }.start();
    }

}
