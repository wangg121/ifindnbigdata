package com.ifindn.basicthread;

/**
 * @author Guo Yan
 * @date 2020/4/14-16:42
 */
class Clerk {
    private int num ;

    public void produce() {
        synchronized (this) {

            if (num >= 20) {

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println(Thread.currentThread().getName() + ":" + num);
                num++;
                notifyAll();
            }
        }

    }

    public void sale() {
        synchronized (this) {
            if (num <= 0) {

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }else{
                System.out.println(Thread.currentThread().getName() + ":" + num);
                num--;
                notifyAll();
            }
        }

    }

    public int getNum() {
        return num;
    }
}

class Producer implements Runnable {

    Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produce();
        }
    }
}

class Consumer implements Runnable {

    Clerk clerk;

    Consumer(Clerk clerk) {

        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.sale();
        }

    }
}

public class TestProduceConsume {

    public static void main(String[] args) {

        Clerk c = new Clerk();
        Producer producer = new Producer(c);
        Consumer consumer = new Consumer(c);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.setName("生产者");
        t2.setName("消费者");


        t1.start();
        t2.start();
    }

}
