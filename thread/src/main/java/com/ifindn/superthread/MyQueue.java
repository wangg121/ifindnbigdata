package com.ifindn.superthread;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Guo Yan
 * @date 2020/4/20-11:07
 * 模拟阻塞队列
 */
public class MyQueue {

    //需要一个承载元素的集合
    private LinkedList<Object> list = new LinkedList<>();

    //计数器
    private AtomicInteger count = new AtomicInteger();

    //制定上限和下限
    private final int minSize = 0;

    private final int maxSize;

    //构造方法
    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
    }


    private Object lock = new Object();

    public void put(Object obj) {
        synchronized ((lock)) {
            while (count.get() == this.maxSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            //加入元素
            list.add(obj);
            //计数器累加
            count.incrementAndGet();
            //通知另一线程唤醒
            lock.notify();

            System.out.println("最新加入的元素为：" + obj);
        }

    }

    public Object take(){
        Object ret = null;
        synchronized (lock){
            while (count.get() == this.minSize  ){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ret = list.removeFirst();

            count.decrementAndGet();
            lock.notify();
            return  ret;
        }
    }
    
    
    public static void main(String[] args){
        final  MyQueue queue = new MyQueue(5);
        queue.put("a");
        queue.put("b");
        queue.put("c");
        queue.put("d");
        queue.put("e");


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                queue.put("f");
                queue.put("g");
            }
        },"t1");

        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Object o1 = queue.take();
                System.out.println("移除的元素为：" +o1);
                Object o2 = queue.take();
                System.out.println("移除的元素为：" + o2);
            }
        },"t2");


       /* try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        t2.start();
    }




}
