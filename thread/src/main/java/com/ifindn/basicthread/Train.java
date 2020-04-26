package com.ifindn.basicthread;

/**
 * @author Guo Yan
 * @date 2020/4/13-13:05
 */
public class Train {
    public static void main(String[] args){
        Ticket t1 = new Ticket();
        Ticket t2 = new Ticket();
        Ticket t3 = new Ticket();
        t1.setName("票口1");
        t2.setName("票口2");
        t3.setName("票口3");
        t1.start();
        t2.start();
        t3.start();
    }


}

class Ticket extends Thread{
    private static int num =1;
    @Override
    public void run() {
        while (num < 100){
            num++;
            System.out.println(Thread.currentThread().getName() + " 票号： " +num);
        }
    }
}