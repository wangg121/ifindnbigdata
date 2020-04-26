package com.ifindn.providerconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author Guo Yan
 * @date 2020/4/22-21:45
 */
public class Consumer implements Runnable {

    private BlockingQueue<Data> queue;

    public Consumer(BlockingQueue queue){
        this.queue = queue;
    }

    private static Random rand = new Random();

    @Override
    public void run() {
        while (true){

            try {
                Thread.sleep(rand.nextInt(1000));
                Data data = queue.take();
                System.out.println("当前消费线程：" + Thread.currentThread().getName() +
                        "成功消费id ：" + data.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}
