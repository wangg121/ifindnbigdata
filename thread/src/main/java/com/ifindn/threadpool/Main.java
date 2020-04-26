package com.ifindn.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Guo Yan
 * @date 2020/4/23-11:41
 * 有界队列
 */
public class Main {

    public static void main(String[] args){
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1,2,0L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),new MyReject());

        MyTask t1 = new MyTask("1", "t1");
        MyTask t2 = new MyTask("2", "t2");
        MyTask t3 = new MyTask("3", "t3");
        MyTask t4 = new MyTask("4", "t4");
        MyTask t5 = new MyTask("5", "t5");
        MyTask t6 = new MyTask("6", "t6");

        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);

        pool.shutdown();
    }

}
