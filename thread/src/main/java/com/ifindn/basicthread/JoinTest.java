package com.ifindn.basicthread;

/**
 * @Author Mr.Guo
 * @Date 2020-07-05 9:35
 */
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {

        JoinThread t = new JoinThread();
        long start = System.currentTimeMillis();
        t.start();
//        t.join(1000);
        long end = System.currentTimeMillis();
        System.out.println("main finshed");
    }
}
class JoinThread extends Thread{
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName());
            for (int i = 0;i<5;i++){
                Thread.sleep(1000);
                System.out.println("睡眠" + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("JointTest execute finshed");
    }
}