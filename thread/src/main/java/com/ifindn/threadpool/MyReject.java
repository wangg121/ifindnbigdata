package com.ifindn.threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Guo Yan
 * @date 2020/4/23-11:35
 */
public class MyReject implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("自定义处理....被拒绝的任务为：" + r.toString());
    }
}
