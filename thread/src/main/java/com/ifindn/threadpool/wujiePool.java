package com.ifindn.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Guo Yan
 * @date 2020/4/23-18:20
 * 无界队列自定义线程池
 */
public class wujiePool implements Runnable {

    private static AtomicInteger atomic = new AtomicInteger();

    @Override
    public void run() {
        int num = atomic.incrementAndGet();
        System.out.println("任务" + num);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args){

        BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();

        ExecutorService pool = new ThreadPoolExecutor(5,5,120L, TimeUnit.SECONDS,
                queue);

        for (int i = 1; i <= 20 ; i++) {
            pool.execute(new wujiePool());
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("queue size :" + queue.size());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
