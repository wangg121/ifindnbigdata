package com.ifindn.basicthread.bank;

/**
 * @author Guo Yan
 * @date 2020/4/14-11:29
 */
public class Account {

    private double blance;

    public synchronized void cunqian(double num){
        blance += num;
        try {
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "余额：" + blance);
    }

    public static void main(String[] args){
        Account a = new Account();
        Customer c = new Customer(a);
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.setName("甲 ：");
        t2.setName("乙 ：");
        t1.start();
        t2.start();
    }

}

class Customer implements Runnable{

    Account account;

    public Customer(Account account){
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.cunqian(100);
        }
    }
}