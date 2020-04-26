package com.ifindn.providerconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Guo Yan
 * @date 2020/4/22-21:45
 */
public class Provider implements Runnable{

    //共享缓存区
    private BlockingQueue<Data> queue;
    //多线程间是否启动变量
    private volatile boolean isRunning = true;
    //id生成器
    private static AtomicInteger count = new AtomicInteger();

    private  static Random rand = new Random();

    public Provider(BlockingQueue queue){
        this.queue = queue;
    }


    @Override
    public void run() {
        while (isRunning){
            try {
                //模拟生成数据耗时
                Thread.sleep(rand.nextInt(1000));
                int id = count.incrementAndGet();
                Data data = new Data(Integer.toString(id),"数据" + id);

                System.out.println("当前线程" + Thread.currentThread().getName()+
                ",获取了数据，id为 " + id + ",进行装载到公共缓冲区....");

                if(!this.queue.offer(data,2, TimeUnit.SECONDS)){
                    System.out.println("提交到缓冲区失败.....");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop(){
        isRunning = false;
    }
}
