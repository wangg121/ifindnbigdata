package com.ifindn.basicthread;

/**
 * @Author Mr.Guo
 * @Date 2020-07-05 16:28
 */
public class TicketTest {

    public static void main(String[] args) {
        Ticket1 ticket1 = new Ticket1();
        new Thread(ticket1).start();
        new Thread(ticket1).start();
        new Thread(ticket1).start();
        new Thread(ticket1).start();

    }
}

class Ticket1 implements Runnable {

    private volatile int total = 100;

    @Override
    public void run() {

        try {
            while (true) {
                if (total > 0) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " 剩余票数为" + total--);
                }else{
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
