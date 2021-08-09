package com.ifindn.thread;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class JoinTest {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new TestThread(),"A");

        Thread t2 = new Thread(new TestThread(),"B");

        Thread t3 = new Thread(new TestThread(),"C");
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        System.out.println("main结束");

        Map<String,Integer> map = new ConcurrentHashMap<>();

    }
}


class TestThread implements Runnable{

    @Override
    public void run() {

//        for (int i = 0; i < 10; i++) {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName());
//        }
    }
}
