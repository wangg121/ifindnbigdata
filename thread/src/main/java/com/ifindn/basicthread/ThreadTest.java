package com.ifindn.basicthread;

/**
 * @author Guo Yan
 * @date 2020/4/12-23:08
 */
public class ThreadTest {

    public static void main(String[] args){

        SubThread subThread = new SubThread();
        subThread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            if(i == 20){
                try {
                    subThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class SubThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
