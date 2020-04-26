package com.ifindn.providerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Guo Yan
 * @date 2020/4/22-22:14
 */
public class Main {
    
    public static void main(String[] args){
        //内存缓冲区
        BlockingQueue<Data> queue = new LinkedBlockingDeque<>(10);

        Provider provider1 = new Provider(queue);
        Provider provider2 = new Provider(queue);
        Provider provider3 = new Provider(queue);

        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);

        //创建线程池运行，这是一个缓存的线程池，可以创建无穷大的线程，没有任务的时候不创建线程，空闲线程存活时间60s
        ExecutorService cachePool = Executors.newCachedThreadPool();
        cachePool.execute(provider1);
        cachePool.execute(provider2);
        cachePool.execute(provider3);

        cachePool.execute(consumer1);
        cachePool.execute(consumer2);
        cachePool.execute(consumer3);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        provider1.stop();
        provider2.stop();
        provider3.stop();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cachePool.shutdown();

    }
}
