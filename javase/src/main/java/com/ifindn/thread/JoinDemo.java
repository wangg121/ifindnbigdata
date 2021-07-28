package com.ifindn.thread;

public class JoinDemo {

    JoinPrinter joinPrinter = new JoinPrinter();

    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                joinPrinter.print1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });


    Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                joinPrinter.print2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });


    Thread thread3 = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                joinPrinter.print3();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });



}


class JoinPrinter{
    private int flag = 1;


    public void print1() throws InterruptedException {
        synchronized (this){
            if(flag != 1){
                this.wait();//如果flag不等于1，设置线程等待
            }

            System.out.println("跟");
            System.out.println("我");
            System.out.println("一");
            System.out.println("起");
            System.out.println("念");
            flag = 2;
            this.notify();//设置flag等于2，使用线程唤醒功能，其他线程就可以启动
        }
    }

    public void print2() throws InterruptedException {
        synchronized (this){
            if(flag != 2){
                this.wait();
            }

            System.out.println("做");
            System.out.println("测");
            System.out.println("试");
            System.out.println("死");
            System.out.println("路");
            System.out.println("一");
            System.out.println("条");

            flag = 3;
            this.notify();//随机唤醒单个等待的线程
        }
    }

    public void print3() throws InterruptedException {
        synchronized (this){
            if(flag != 3){
                this.wait();
            }

            System.out.println("信");
            System.out.println("才");
            System.out.println("怪");
            System.out.println("呢");

            flag = 1;
            this.notify();//随机唤醒单个等待的线程
        }
    }
}



