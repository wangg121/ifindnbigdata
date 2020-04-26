package com.ifindn.basicthread;

/**
 * @author Guo Yan
 * @date 2020/4/19-10:20
 */
public class Test1 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pong();
                }

            }
        };
        t.start();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ping");
        }

    }

    static void pong() {
        System.out.println("pong");
    }

}
