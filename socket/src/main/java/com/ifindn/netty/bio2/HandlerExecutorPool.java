package com.ifindn.netty.bio2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Guo Yan
 * @date 2020/4/30-11:05
 */
public class HandlerExecutorPool {

    private ExecutorService executor;

    public HandlerExecutorPool(int maxSize ,int queueSize){
        this.executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                maxSize,
                120L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queueSize));
    }

    public void execute(Runnable task){
        executor.execute(task);
    }

}
